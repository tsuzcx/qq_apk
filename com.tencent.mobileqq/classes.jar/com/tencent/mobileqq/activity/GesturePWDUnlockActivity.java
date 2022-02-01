package com.tencent.mobileqq.activity;

import Override;
import aecx;
import aecy;
import aecz;
import aeda;
import akrl;
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
import anvi;
import avhn;
import avho;
import bhdj;
import bheh;
import bhey;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.statistics.StatisticCollector;
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

public class GesturePWDUnlockActivity
  extends BaseActivity
  implements View.OnClickListener, Animation.AnimationListener, avho
{
  public static boolean c;
  private float jdField_a_of_type_Float = 1.0F;
  int jdField_a_of_type_Int = 5;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aeda(this);
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  anvi jdField_a_of_type_Anvi = new aecz(this);
  LockPatternView jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView;
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
    this.jdField_c_of_type_JavaLangString = getString(2131692805);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_gesture_from_jumpactivity", false);
    this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("key_gesture_from_authority", false);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_req_by_contact_sync", false);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("scheme_content");
      this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("pkg_name");
    }
    addObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = GesturePWDUtils.getGestureUnlockFailedTime(getActivity(), this.app.getCurrentAccountUin());
  }
  
  private void h()
  {
    setTitle(2131692789);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367688));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367685));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView = ((LockPatternView)findViewById(2131367687));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setFillInGapCell(false);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setTactileFeedbackEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setOnPatternListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367684));
    Object localObject1;
    if ((this.app != null) && (this.app.getCurrentAccountUin() != null))
    {
      localObject1 = this.app.getFaceBitmap(this.app.getCurrentAccountUin(), (byte)3, false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367686));
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
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166922));
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
  
  public void a(List<avhn> paramList)
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
          boolean bool = a();
          if (!bool) {
            finish();
          }
          GesturePWDUtils.setGestureLocking(this, false);
          if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
          {
            paramList = bhey.a(this.app, getActivity(), this.jdField_a_of_type_JavaLangString);
            paramList.c(this.jdField_b_of_type_JavaLangString);
            paramList.g = bool;
            paramList.a();
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.gesturelock.unlock", 2, "unlock success.");
          }
          this.jdField_a_of_type_Int = 5;
          akrl.a(this.app, true);
          return;
          setResult(-1);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setDisplayMode(2);
      this.jdField_a_of_type_Int -= 1;
      if (this.jdField_a_of_type_Int > 0)
      {
        c();
        return;
      }
      d();
      return;
    }
    QQToast.a(this, 1, getString(2131692800), 0).b(getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setDisplayMode(2);
    this.jdField_a_of_type_Int -= 1;
    if (this.jdField_a_of_type_Int > 0)
    {
      c();
      return;
    }
    d();
  }
  
  public boolean a()
  {
    if ((!this.jdField_a_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      QLog.d("qqBaseActivity", 1, "isDelayFinish false noJump" + this.jdField_a_of_type_Boolean);
      return false;
    }
    bheh localbheh = bhey.a(this.app, getActivity(), this.jdField_a_of_type_JavaLangString);
    if (localbheh == null)
    {
      QLog.d("qqBaseActivity", 1, "isDelayFinish false jumpAction == null");
      return false;
    }
    if (("share".equals(localbheh.jdField_b_of_type_JavaLangString)) && ("to_fri".equals(localbheh.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(bheh.c((String)localbheh.a.get("file_uri")))))
    {
      QLog.d("qqBaseActivity", 1, "isDelayFinish true share qq file");
      return true;
    }
    if (("share".equals(localbheh.jdField_b_of_type_JavaLangString)) && ("to_qzone".equals(localbheh.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(bheh.c((String)localbheh.a.get("image_uri")))))
    {
      QLog.d("qqBaseActivity", 1, "isDelayFinish true share qqzone file");
      return true;
    }
    QLog.d("qqBaseActivity", 1, "isDelayFinish false sn = " + localbheh.jdField_b_of_type_JavaLangString + ",an=" + localbheh.jdField_c_of_type_JavaLangString);
    return false;
  }
  
  public void b() {}
  
  public void b(List<avhn> paramList) {}
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onUnlockFailedInRange");
    }
    Object localObject = MessageFormat.format(this.jdField_c_of_type_JavaLangString, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166922));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = this.jdField_a_of_type_Int + "";
    int i = ((String)localObject).indexOf(str);
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new StyleSpan(1), i, str.length() + i, 18);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    BaseApplicationImpl.sUiHandler.postDelayed(new GesturePWDUnlockActivity.2(this), 500L);
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.unlock", 2, "onUnlockFailedOutRange");
    }
    BaseApplicationImpl.sUiHandler.postDelayed(new GesturePWDUnlockActivity.3(this), 500L);
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this, 231, getString(2131692803), getString(2131692802), new aecx(this), null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new aecy(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
  
  public boolean doOnCreate(Bundle paramBundle)
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
    super.setContentView(2131559287);
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
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.e = false;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    removeObserver(this.jdField_a_of_type_Anvi);
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    jdField_c_of_type_Boolean = false;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_c_of_type_AndroidWidgetTextView.postDelayed(new GesturePWDUnlockActivity.1(this), 500L);
  }
  
  public void doOnStop()
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
        ((Intent)localObject).putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
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
    overridePendingTransition(2130771990, 2130772041);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    f();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public boolean onBackEvent()
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      e();
      GesturePWDUtils.setGestureUnlockFailedType(this, 0);
      StatisticCollector.getInstance(getBaseContext()).reportActionCount(this.app, this.app.getCurrentAccountUin(), "Gesture_pwd", "click_forgive", 0, 1, "0", null, null, null, null);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDUnlockActivity
 * JD-Core Version:    0.7.0.1
 */