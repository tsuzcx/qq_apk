package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.gesturelock.LockPatternView.Cell;
import com.tencent.mobileqq.gesturelock.LockPatternView.OnPatternListener;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qwallet.IQWalletPayApi;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

@RoutePage(desc="手势解锁", path="/base/gesturePwdUnlock")
public class GesturePWDUnlockActivity
  extends BaseActivity
  implements View.OnClickListener, Animation.AnimationListener, LockPatternView.OnPatternListener
{
  public static final int GESTUREPWD_LENGHT_MIN = 3;
  private static final int GESTUREPWD_UNLOCK_MAXTIME = 5;
  public static final String GESTURE_ACTION = "com.tencent.mobileqq.gestureunlock";
  private static final String GESTURE_TAG = "Q.gesturelock.unlock";
  public static final String KEY_GESTURE_FROM_AUTHORITY = "key_gesture_from_authority";
  public static final String KEY_GESTURE_FROM_JUMPACTIVITY = "key_gesture_from_jumpactivity";
  public static final String KEY_GESTURE_FROM_SYSTEM_CONTACT = "key_req_by_contact_sync";
  public static final String KEY_GESTURE_SHOWGESTURE_VALID = "key_gesture_showgesture_valid";
  public static final String KEY_GESTURE_UNLOCK_FAILED = "key_gesture_unlock_failed";
  public static final int MESSAGE_UNLOCK_FAILED = 2;
  public static final int MESSAGE_UNLOCK_SUCCESS = 1;
  private static final int REQUEST_CODE_LOGIN = 9999;
  public static boolean sGesturePWDUnlockShowing;
  private int[] StepLocation;
  private long[] StepTime;
  AvatarObserver avatarObserver = new GesturePWDUnlockActivity.6(this);
  long createTime = 0L;
  private int curStep = 0;
  private float density = 1.0F;
  private QQCustomDialog faiedUnlockDialog;
  private boolean isNeedReLogin = true;
  private boolean isOtherPageSuccess = false;
  private BroadcastReceiver mBroadcastReceiver = new GesturePWDUnlockActivity.7(this);
  ImageView mFaceImageView;
  private TextView mForgeTextView;
  private boolean mIsFromAuthority = false;
  boolean mIsFromJump = false;
  boolean mIsFromSystemContact = false;
  private GesturePWDUnlockActivity.JumpMqqHandler mJumpHandler;
  LockPatternView mLockView;
  String mPkgNameString = "";
  private View mTransView;
  private int mUnlockFailedTime = 0;
  private TextView mUnlockTextView;
  int mUnlockTime = 5;
  private TextView mUnlockTipTextView;
  String mUrlString = "";
  private String mWrongTips = "";
  private int totalStep = 5;
  
  private void doAlertAnimation(View paramView)
  {
    this.curStep = 0;
    this.totalStep = 5;
    this.StepTime = new long[] { 50L, 100L, 100L, 100L, 100L };
    float f = this.density;
    this.StepLocation = new int[] { (int)(-20.0F * f), (int)(20.0F * f), (int)(-15.0F * f), (int)(f * 15.0F), 0 };
    this.mTransView = paramView;
    nextStep();
  }
  
  private void doJumpAction(boolean paramBoolean)
  {
    if ((this.mIsFromJump) && (!TextUtils.isEmpty(this.mUrlString)))
    {
      JumpAction localJumpAction = JumpParser.a(this.app, getActivity(), this.mUrlString);
      localJumpAction.d(this.mPkgNameString);
      localJumpAction.w = paramBoolean;
      localJumpAction.a();
    }
  }
  
  private void initData()
  {
    this.mWrongTips = getString(2131890020);
    this.mIsFromJump = getIntent().getBooleanExtra("key_gesture_from_jumpactivity", false);
    this.mIsFromAuthority = getIntent().getBooleanExtra("key_gesture_from_authority", false);
    this.mIsFromSystemContact = getIntent().getBooleanExtra("key_req_by_contact_sync", false);
    if (this.mIsFromJump)
    {
      this.mUrlString = getIntent().getStringExtra("scheme_content");
      this.mPkgNameString = getIntent().getStringExtra("pkg_name");
      this.mJumpHandler = new GesturePWDUnlockActivity.JumpMqqHandler(this);
      this.app.setHandler(GesturePWDUnlockActivity.class, this.mJumpHandler);
    }
    addObserver(this.avatarObserver);
    this.density = getResources().getDisplayMetrics().density;
    this.mUnlockFailedTime = GesturePWDUtils.getGestureUnlockFailedTime(getActivity(), this.app.getCurrentAccountUin());
  }
  
  private void initUI()
  {
    setTitle(2131890004);
    this.mUnlockTextView = ((TextView)findViewById(2131434206));
    this.mUnlockTipTextView = ((TextView)findViewById(2131434203));
    this.mLockView = ((LockPatternView)findViewById(2131434205));
    this.mLockView.setFillInGapCell(false);
    this.mLockView.setTactileFeedbackEnabled(false);
    this.mLockView.setOnPatternListener(this);
    this.mFaceImageView = ((ImageView)findViewById(2131434202));
    Object localObject1;
    if ((this.app != null) && (this.app.getCurrentAccountUin() != null))
    {
      localObject1 = this.app.getFaceBitmap(this.app.getCurrentAccountUin(), (byte)3, false);
      this.mFaceImageView.setImageBitmap((Bitmap)localObject1);
    }
    this.mForgeTextView = ((TextView)findViewById(2131434204));
    this.mForgeTextView.setOnClickListener(this);
    this.mForgeTextView.setEnabled(false);
    if (this.density <= 1.0D)
    {
      localObject1 = this.mLockView.getLayoutParams();
      float f = this.density;
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(f * 240.0F));
      ((ViewGroup.LayoutParams)localObject1).width = ((int)(f * 240.0F));
      this.mLockView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    int i = this.mUnlockFailedTime;
    if ((i > 0) && (i < 5))
    {
      this.mUnlockTime = (5 - i);
      localObject1 = MessageFormat.format(this.mWrongTips, new Object[] { Integer.valueOf(this.mUnlockTime) });
      this.mUnlockTextView.setTextColor(getResources().getColor(2131167862));
      this.mUnlockTipTextView.setVisibility(0);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.mUnlockTime);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      i = ((String)localObject1).indexOf((String)localObject2);
      localObject1 = new SpannableString((CharSequence)localObject1);
      ((SpannableString)localObject1).setSpan(new StyleSpan(1), i, ((String)localObject2).length() + i, 18);
      this.mUnlockTextView.setText((CharSequence)localObject1);
    }
    if (this.mUnlockFailedTime == 5)
    {
      this.mUnlockTime = 0;
      onUnlockFailedOutRange();
    }
  }
  
  private void onJumpReceiveUnlock()
  {
    boolean bool = isDelayFinish();
    doJumpAction(bool);
    if (!bool) {
      finish();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 9999)
    {
      if (paramInt2 == -1)
      {
        setResult(-1, paramIntent);
        finish();
        return;
      }
      setResult(0);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onCreate begin.");
    }
    Window localWindow = getWindow();
    if (Build.VERSION.SDK_INT >= 28)
    {
      View localView = localWindow.getDecorView();
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.layoutInDisplayCutoutMode = 1;
      localWindow.setAttributes(localLayoutParams);
      int i = localView.getSystemUiVisibility();
      localWindow.getDecorView().setSystemUiVisibility(i | 0x400);
    }
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131624962);
    initData();
    initUI();
    GesturePWDUtils.setGestureLocking(this, true);
    this.createTime = System.currentTimeMillis();
    paramBundle = new Intent();
    paramBundle.setAction("com.tencent.mobileqq.gestureunlock");
    paramBundle.putExtra("timeid", this.createTime);
    sendBroadcast(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.gestureunlock");
    registerReceiver(this.mBroadcastReceiver, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    QQCustomDialog localQQCustomDialog = this.faiedUnlockDialog;
    if (localQQCustomDialog != null)
    {
      this.isNeedReLogin = false;
      localQQCustomDialog.dismiss();
    }
    removeObserver(this.avatarObserver);
    if (this.mJumpHandler != null) {
      this.app.removeHandler(GesturePWDUnlockActivity.class);
    }
    try
    {
      unregisterReceiver(this.mBroadcastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    sGesturePWDUnlockShowing = false;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.mForgeTextView.postDelayed(new GesturePWDUnlockActivity.1(this), 500L);
    if ((this.isOtherPageSuccess) && (this.mIsFromJump)) {
      onJumpReceiveUnlock();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.mForgeTextView.setEnabled(false);
    GesturePWDUtils.setGestureUnlockFailedTime(getActivity(), this.app.getCurrentAccountUin(), 5 - this.mUnlockTime);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772007, 2130772092);
  }
  
  public boolean isDelayFinish()
  {
    if ((this.mIsFromJump) && (!TextUtils.isEmpty(this.mUrlString)))
    {
      localObject = JumpParser.a(this.app, getActivity(), this.mUrlString);
      if (localObject == null)
      {
        QLog.d("qqBaseActivity", 1, "isDelayFinish false jumpAction == null");
        return false;
      }
      if (("share".equals(((JumpAction)localObject).d)) && ("to_fri".equals(((JumpAction)localObject).e)) && (!TextUtils.isEmpty(JumpAction.h((String)((JumpAction)localObject).f.get("file_uri")))))
      {
        QLog.d("qqBaseActivity", 1, "isDelayFinish true share qq file");
        return true;
      }
      if (("share".equals(((JumpAction)localObject).d)) && ("to_qzone".equals(((JumpAction)localObject).e)) && (!TextUtils.isEmpty(JumpAction.h((String)((JumpAction)localObject).f.get("image_uri")))))
      {
        QLog.d("qqBaseActivity", 1, "isDelayFinish true share qqzone file");
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDelayFinish false sn = ");
      localStringBuilder.append(((JumpAction)localObject).d);
      localStringBuilder.append(",an=");
      localStringBuilder.append(((JumpAction)localObject).e);
      QLog.d("qqBaseActivity", 1, localStringBuilder.toString());
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isDelayFinish false noJump");
    ((StringBuilder)localObject).append(this.mIsFromJump);
    QLog.d("qqBaseActivity", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  void nextStep()
  {
    int j = this.curStep;
    int k = this.totalStep;
    int i = 0;
    if (j < k)
    {
      Object localObject = this.StepLocation;
      if ((localObject != null) && (localObject.length >= k))
      {
        long[] arrayOfLong = this.StepTime;
        if ((arrayOfLong != null) && (arrayOfLong.length >= k))
        {
          if (j > 0) {
            i = localObject[(j - 1)];
          }
          j = this.StepLocation[this.curStep];
          localObject = new TranslateAnimation(i, j, 0.0F, 0.0F);
          ((TranslateAnimation)localObject).setAnimationListener(this);
          ((TranslateAnimation)localObject).setDuration(this.StepTime[this.curStep]);
          this.mTransView.startAnimation((Animation)localObject);
          this.curStep += 1;
          return;
        }
      }
    }
    this.curStep = 0;
    this.mTransView = null;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    nextStep();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected boolean onBackEvent()
  {
    if ((!this.mIsFromJump) && (!this.mIsFromAuthority))
    {
      moveTaskToBack(true);
      return true;
    }
    setResult(0);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131434204)
    {
      unLockFailed();
      GesturePWDUtils.setGestureUnlockFailedType(this, 0);
      StatisticCollector.getInstance(getBaseContext()).reportActionCount(this.app, this.app.getCurrentAccountUin(), "Gesture_pwd", "click_forgive", 0, 1, "0", null, null, null, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public void onPatternCellAdded(List<LockPatternView.Cell> paramList) {}
  
  public void onPatternCleared() {}
  
  public void onPatternDetected(List<LockPatternView.Cell> paramList)
  {
    if (paramList != null)
    {
      String str1 = GesturePWDUtils.getGesturePWD(this, this.app.getCurrentAccountUin());
      String str2 = MD5.toMD5(GesturePWDUtils.patternToString(paramList));
      paramList = GesturePWDUtils.encodeGesture(GesturePWDUtils.patternToString(paramList), this.app.getCurrentAccountUin());
      if ((str1 != null) && (((str2 != null) && (str2.equals(str1))) || ((paramList != null) && (paramList.equals(str1)))))
      {
        BaseActivity.isUnLockSuccess = true;
        if (this.mIsFromSystemContact)
        {
          paramList = new Intent(this, ContactSyncJumpActivity.class);
          paramList.putExtra("key_req_from_lock_screen", true);
          paramList.putExtra("key_orginal_intent", getIntent().getParcelableExtra("key_orginal_intent"));
          startActivity(paramList);
          moveTaskToBack(true);
        }
        else
        {
          setResult(-1);
        }
        boolean bool = isDelayFinish();
        doJumpAction(bool);
        if (!bool) {
          finish();
        }
        paramList = this.app.getHandler(GesturePWDUnlockActivity.class);
        if (paramList != null) {
          paramList.sendEmptyMessage(1);
        }
        GesturePWDUtils.setGestureLocking(this, false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.gesturelock.unlock", 2, "unlock success.");
        }
        this.mUnlockTime = 5;
        ((IQWalletPayApi)QRoute.api(IQWalletPayApi.class)).onQQForeground(this.app, true);
        return;
      }
      this.mLockView.setDisplayMode(2);
      this.mUnlockTime -= 1;
      if (this.mUnlockTime > 0)
      {
        onUnlockFailedInRange();
        return;
      }
      onUnlockFailedOutRange();
      return;
    }
    QQToast.makeText(this, 1, getString(2131890015), 0).show(getTitleBarHeight());
    this.mLockView.setDisplayMode(2);
    this.mUnlockTime -= 1;
    if (this.mUnlockTime > 0)
    {
      onUnlockFailedInRange();
      return;
    }
    onUnlockFailedOutRange();
  }
  
  public void onPatternStart() {}
  
  void onUnlockFailedInRange()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onUnlockFailedInRange");
    }
    Object localObject1 = MessageFormat.format(this.mWrongTips, new Object[] { Integer.valueOf(this.mUnlockTime) });
    this.mUnlockTextView.setTextColor(getResources().getColor(2131167862));
    this.mUnlockTipTextView.setVisibility(0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.mUnlockTime);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    int i = ((String)localObject1).indexOf((String)localObject2);
    localObject1 = new SpannableString((CharSequence)localObject1);
    ((SpannableString)localObject1).setSpan(new StyleSpan(1), i, ((String)localObject2).length() + i, 18);
    this.mUnlockTextView.setText((CharSequence)localObject1);
    doAlertAnimation(this.mUnlockTextView);
    BaseApplicationImpl.sUiHandler.postDelayed(new GesturePWDUnlockActivity.2(this), 500L);
  }
  
  void onUnlockFailedOutRange()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onUnlockFailedOutRange");
    }
    Object localObject = this.app.getHandler(GesturePWDUnlockActivity.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(2);
    }
    BaseApplicationImpl.sUiHandler.postDelayed(new GesturePWDUnlockActivity.3(this), 500L);
    localObject = this.faiedUnlockDialog;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      return;
    }
    this.faiedUnlockDialog = DialogUtil.a(this, 231, getString(2131890018), getString(2131890017), new GesturePWDUnlockActivity.4(this), null);
    this.faiedUnlockDialog.setOnDismissListener(new GesturePWDUnlockActivity.5(this));
    this.faiedUnlockDialog.show();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  void unLockFailed()
  {
    this.mUnlockTime = 5;
    GesturePWDUtils.setGesturePWDState(this, this.app.getCurrentAccountUin(), 0);
    GesturePWDUtils.setGesturePWDMode(this, this.app.getCurrentAccountUin(), 21);
    GesturePWDUtils.setGestureUnlockFailed(this, this.app.getCurrentAccountUin());
    Object localObject = getAppRuntime().getApplication().getAllAccounts();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
        if ((localSimpleAccount != null) && (localSimpleAccount.getUin() != null)) {
          this.app.updateSubAccountLogin(localSimpleAccount.getUin(), false);
        }
      }
      getAppRuntime().getApplication().refreAccountList();
    }
    GesturePWDUtils.setGestureLocking(this, false);
    if (QQPlayerService.b())
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("qqplayer_exit_action");
      sendBroadcast((Intent)localObject);
    }
    this.app.logout(true);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mIsFromAuthority);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.mIsFromSystemContact);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.mIsFromJump);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.mUrlString);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.mPkgNameString);
      QLog.d("Q.gesturelock.unlock", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new Intent();
    if (this.mIsFromAuthority)
    {
      ((Intent)localObject).putExtra("key_gesture_from_authority", true);
      GesturePWDUtils.setGestureLocking(this, false);
      RouteUtils.a(this, (Intent)localObject, "/base/login", 9999);
      return;
    }
    if (this.mIsFromSystemContact)
    {
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("key_req_by_contact_sync", true);
      ((Intent)localObject).putExtra("key_orginal_intent", getIntent().getParcelableExtra("key_orginal_intent"));
      RouteUtils.a(this, (Intent)localObject, "/base/login");
    }
    else if (!this.mIsFromJump)
    {
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("key_gesture_unlock_failed", true);
      ((Intent)localObject).putExtra("tab_index", FrameControllerUtil.a);
      RouteUtils.a(this, (Intent)localObject, "/base/login");
    }
    else if ((!TextUtils.isEmpty(this.mUrlString)) && (!TextUtils.isEmpty(this.mPkgNameString)))
    {
      ((Intent)localObject).putExtra("scheme_content", this.mUrlString);
      ((Intent)localObject).putExtra("pkg_name", this.mPkgNameString);
      RouteUtils.a(this, (Intent)localObject, "/base/login");
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDUnlockActivity
 * JD-Core Version:    0.7.0.1
 */