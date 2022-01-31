package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.LeakInspector.ActivityLeakSolution;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.gesturelock.LockPatternView.DisplayMode;
import com.tencent.mobileqq.gesturelock.LockPatternView.OnPatternListener;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import syx;
import syy;
import syz;
import sza;
import szb;
import szc;
import szd;

public class GesturePWDUnlockActivity
  extends BaseActivity
  implements View.OnClickListener, Animation.AnimationListener, LockPatternView.OnPatternListener
{
  public static boolean c;
  private float jdField_a_of_type_Float = 1.0F;
  int jdField_a_of_type_Int = 5;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new szd(this);
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new szc(this);
  public LockPatternView a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt;
  private long[] jdField_a_of_type_ArrayOfLong;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private int jdField_d_of_type_Int = 5;
  private boolean jdField_d_of_type_Boolean;
  private boolean e = true;
  
  public GesturePWDUnlockActivity()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void a(View paramView)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 5;
    this.jdField_a_of_type_ArrayOfLong = new long[] { 50L, 100L, 100L, 100L, 100L };
    this.jdField_a_of_type_ArrayOfInt = new int[] { (int)(-20.0F * this.jdField_a_of_type_Float), (int)(20.0F * this.jdField_a_of_type_Float), (int)(-15.0F * this.jdField_a_of_type_Float), (int)(15.0F * this.jdField_a_of_type_Float), 0 };
    this.jdField_a_of_type_AndroidViewView = paramView;
    f();
  }
  
  private void g()
  {
    this.jdField_c_of_type_JavaLangString = getString(2131436072);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_gesture_from_jumpactivity", false);
    this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("key_gesture_from_authority", false);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_req_by_contact_sync", false);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("scheme_content");
      this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("pkg_name");
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = GesturePWDUtils.getGestureUnlockFailedTime(getActivity(), this.app.getCurrentAccountUin());
  }
  
  private void h()
  {
    setTitle(2131436058);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364746));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364747));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView = ((LockPatternView)findViewById(2131364748));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setFillInGapCell(false);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setTactileFeedbackEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setOnPatternListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364745));
    Object localObject1;
    if ((this.app != null) && (this.app.getCurrentAccountUin() != null))
    {
      localObject1 = this.app.a(this.app.getCurrentAccountUin(), (byte)3, false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364750));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(false);
    if (this.jdField_a_of_type_Float <= 1.0D)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(this.jdField_a_of_type_Float * 240.0F));
      ((ViewGroup.LayoutParams)localObject1).width = ((int)(this.jdField_a_of_type_Float * 240.0F));
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_b_of_type_Int < 5))
    {
      this.jdField_a_of_type_Int = (5 - this.jdField_b_of_type_Int);
      Object localObject2 = MessageFormat.format(this.jdField_c_of_type_JavaLangString, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131493806));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_Int + "";
      int i = ((String)localObject2).indexOf((String)localObject1);
      localObject2 = new SpannableString((CharSequence)localObject2);
      ((SpannableString)localObject2).setSpan(new StyleSpan(1), i, ((String)localObject1).length() + i, 18);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    }
    if (this.jdField_b_of_type_Int == 5)
    {
      this.jdField_a_of_type_Int = 0;
      d();
    }
  }
  
  public void a() {}
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      String str1 = GesturePWDUtils.getGesturePWD(this, this.app.getCurrentAccountUin());
      String str2 = MD5.toMD5(GesturePWDUtils.patternToString(paramList));
      paramList = GesturePWDUtils.encodeGesture(GesturePWDUtils.patternToString(paramList), this.app.getCurrentAccountUin());
      if ((str1 != null) && (((str2 != null) && (str2.equals(str1))) || ((paramList != null) && (paramList.equals(str1)))))
      {
        BaseActivity.isUnLockSuccess = true;
        if (this.jdField_b_of_type_Boolean)
        {
          paramList = new Intent(this, ContactSyncJumpActivity.class);
          paramList.putExtra("key_req_from_lock_screen", true);
          paramList.putExtra("key_orginal_intent", getIntent().getParcelableExtra("key_orginal_intent"));
          startActivity(paramList);
          moveTaskToBack(true);
        }
        for (;;)
        {
          finish();
          GesturePWDUtils.setGestureLocking(this, false);
          if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
          {
            paramList = JumpParser.a(this.app, getActivity(), this.jdField_a_of_type_JavaLangString);
            paramList.b(this.jdField_b_of_type_JavaLangString);
            paramList.b();
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.gesturelock.unlock", 2, "unlock success.");
          }
          this.jdField_a_of_type_Int = 5;
          QWalletPushManager.a(this.app, true);
          return;
          setResult(-1);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
      this.jdField_a_of_type_Int -= 1;
      if (this.jdField_a_of_type_Int > 0)
      {
        c();
        return;
      }
      d();
      return;
    }
    QQToast.a(this, 1, getString(2131436063), 0).b(getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setDisplayMode(LockPatternView.DisplayMode.Wrong);
    this.jdField_a_of_type_Int -= 1;
    if (this.jdField_a_of_type_Int > 0)
    {
      c();
      return;
    }
    d();
  }
  
  public void b() {}
  
  public void b(List paramList) {}
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onUnlockFailedInRange");
    }
    Object localObject = MessageFormat.format(this.jdField_c_of_type_JavaLangString, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131493806));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = this.jdField_a_of_type_Int + "";
    int i = ((String)localObject).indexOf(str);
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new StyleSpan(1), i, str.length() + i, 18);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    BaseApplicationImpl.sUiHandler.postDelayed(new syy(this), 500L);
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onUnlockFailedOutRange");
    }
    BaseApplicationImpl.sUiHandler.postDelayed(new syz(this), 500L);
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 231, getString(2131436074), getString(2131436075), new sza(this), null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new szb(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
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
      }
    }
    else {
      return;
    }
    setResult(0);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onCreate begin.");
    }
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130969015);
    g();
    h();
    GesturePWDUtils.setGestureLocking(this, true);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = new Intent();
    paramBundle.setAction("com.tencent.mobileqq.gestureunlock");
    paramBundle.putExtra("timeid", this.jdField_a_of_type_Long);
    sendBroadcast(paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.gestureunlock");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.e = false;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label39:
      ActivityLeakSolution.c(this);
      return;
    }
    catch (Exception localException)
    {
      break label39;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    jdField_c_of_type_Boolean = false;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_c_of_type_AndroidWidgetTextView.postDelayed(new syx(this), 500L);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(false);
    GesturePWDUtils.setGestureUnlockFailedTime(getActivity(), this.app.getCurrentAccountUin(), 5 - this.jdField_a_of_type_Int);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Int = 5;
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
    if (QQPlayerService.a())
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("qqplayer_exit_action");
      sendBroadcast((Intent)localObject);
    }
    this.app.logout(true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, this.jdField_d_of_type_Boolean + "," + this.jdField_b_of_type_Boolean + "," + this.jdField_a_of_type_Boolean + "," + this.jdField_a_of_type_JavaLangString + "," + this.jdField_b_of_type_JavaLangString);
    }
    localObject = new Intent(getApplicationContext(), LoginActivity.class);
    if (this.jdField_d_of_type_Boolean)
    {
      ((Intent)localObject).putExtra("key_gesture_from_authority", true);
      GesturePWDUtils.setGestureLocking(this, false);
      startActivityForResult((Intent)localObject, 9999);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("key_req_by_contact_sync", true);
      ((Intent)localObject).putExtra("key_orginal_intent", getIntent().getParcelableExtra("key_orginal_intent"));
      startActivity((Intent)localObject);
    }
    for (;;)
    {
      finish();
      return;
      if (!this.jdField_a_of_type_Boolean)
      {
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtra("key_gesture_unlock_failed", true);
        ((Intent)localObject).putExtra("tab_index", MainFragment.jdField_a_of_type_Int);
        startActivity((Intent)localObject);
      }
      else if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
      {
        ((Intent)localObject).putExtra("scheme_content", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("pkg_name", this.jdField_b_of_type_JavaLangString);
        startActivity((Intent)localObject);
      }
    }
  }
  
  void f()
  {
    int i = 0;
    if ((this.jdField_c_of_type_Int < this.jdField_d_of_type_Int) && (this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length >= this.jdField_d_of_type_Int) && (this.jdField_a_of_type_ArrayOfLong != null) && (this.jdField_a_of_type_ArrayOfLong.length >= this.jdField_d_of_type_Int))
    {
      if (this.jdField_c_of_type_Int > 0) {
        i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_c_of_type_Int - 1)];
      }
      int j = this.jdField_a_of_type_ArrayOfInt[this.jdField_c_of_type_Int];
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(i, j, 0.0F, 0.0F);
      localTranslateAnimation.setAnimationListener(this);
      localTranslateAnimation.setDuration(this.jdField_a_of_type_ArrayOfLong[this.jdField_c_of_type_Int]);
      this.jdField_a_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
      this.jdField_c_of_type_Int += 1;
      return;
    }
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2131034131, 2131034167);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    f();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
    {
      setResult(0);
      return super.onBackEvent();
    }
    moveTaskToBack(true);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    e();
    GesturePWDUtils.setGestureUnlockFailedType(this, 0);
    StatisticCollector.a(getBaseContext()).a(this.app, this.app.getCurrentAccountUin(), "Gesture_pwd", "click_forgive", 0, 1, "0", null, null, null, null);
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDUnlockActivity
 * JD-Core Version:    0.7.0.1
 */