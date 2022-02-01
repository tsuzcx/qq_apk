package com.tencent.av.utils;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.BaseActivity;

public class PopupDialog
  extends BaseActivity
{
  static PopupDialog.Cache jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache = new PopupDialog.Cache();
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  boolean jdField_a_of_type_Boolean = true;
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog2 = null;
    QQCustomDialog localQQCustomDialog1 = null;
    try
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      if (paramContext != localBaseApplication) {
        localQQCustomDialog1 = localQQCustomDialog2;
      }
    }
    catch (Exception localException1)
    {
      break label73;
    }
    try
    {
      localQQCustomDialog2 = DialogUtil.a(paramContext, 230, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
      localQQCustomDialog1 = localQQCustomDialog2;
      localQQCustomDialog2.show();
      return localQQCustomDialog2;
    }
    catch (Exception localException2)
    {
      break label73;
    }
    localQQCustomDialog1 = localQQCustomDialog2;
    a(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return null;
    label73:
    a(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return localQQCustomDialog1;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "hideCustomDialog");
    }
    jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache.jdField_a_of_type_Boolean = false;
    if (PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null)
    {
      PopupDialog.Cache localCache = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
      PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog.finish();
      localCache = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
      PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog = null;
    }
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt1);
    localBundle.putString("titleText", paramString1);
    localBundle.putString("contentText", paramString2);
    localBundle.putInt("leftBtnText", paramInt2);
    localBundle.putInt("rightBtnText", paramInt3);
    boolean bool2 = false;
    if (paramOnClickListener2 != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localBundle.putBoolean("leftBtnVisiable", bool1);
    boolean bool1 = bool2;
    if (paramOnClickListener1 != null) {
      bool1 = true;
    }
    localBundle.putBoolean("rightBtnVisiable", bool1);
    if ((paramOnClickListener1 != null) || (paramOnClickListener2 != null)) {
      localBundle.putParcelable("resultReceiver", new PopupDialog.1(new Handler(), paramOnClickListener2, paramOnClickListener1));
    }
    paramString1 = new Intent();
    paramString1.putExtra("public_fragment_window_feature", 1);
    paramString1.putExtra("request", localBundle);
    paramString1.addFlags(268435456);
    QPublicFragmentActivity.Launcher.a(paramContext, paramString1, QPublicTransFragmentActivity.class, PopupDialogQQSide.class);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendIsResumeBroadcast isResume = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("PopupDialog", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      SmallScreenUtils.a(BaseApplication.getContext(), paramBoolean);
    }
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog2 = null;
    QQCustomDialog localQQCustomDialog1 = null;
    try
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      if (paramContext != localBaseApplication) {
        localQQCustomDialog1 = localQQCustomDialog2;
      }
    }
    catch (Exception localException1)
    {
      break label73;
    }
    try
    {
      localQQCustomDialog2 = DialogUtil.a(paramContext, 230, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
      localQQCustomDialog1 = localQQCustomDialog2;
      localQQCustomDialog2.show();
      return localQQCustomDialog2;
    }
    catch (Exception localException2)
    {
      break label73;
    }
    localQQCustomDialog1 = localQQCustomDialog2;
    b(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return null;
    label73:
    b(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return localQQCustomDialog1;
  }
  
  public static void b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    a();
    Intent localIntent = new Intent(paramContext, PopupDialog.class);
    localIntent.putExtra("invoke_type", "init");
    localIntent.addFlags(268435456);
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "showCustomDialog");
    }
    PopupDialog.Cache localCache = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
    localCache.jdField_a_of_type_Boolean = true;
    localCache.jdField_a_of_type_Int = paramInt1;
    localCache.jdField_a_of_type_JavaLangString = paramString1;
    localCache.jdField_b_of_type_JavaLangString = paramString2;
    localCache.jdField_b_of_type_Int = paramInt2;
    localCache.c = paramInt3;
    localCache.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener2;
    localCache.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener1;
    paramContext.startActivity(localIntent);
  }
  
  void b()
  {
    Object localObject1 = super.getIntent().getStringExtra("invoke_type");
    Object localObject2;
    if (TextUtils.equals((CharSequence)localObject1, "reshow"))
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      if (localObject2 != null)
      {
        if (((QQCustomDialog)localObject2).isShowing()) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
    }
    if ((TextUtils.equals((CharSequence)localObject1, "changeText")) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null))
    {
      localObject1 = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache.jdField_a_of_type_JavaLangString;
      localObject2 = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle((String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage((CharSequence)localObject2);
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
    }
    else
    {
      int k = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache.jdField_a_of_type_Int;
      String str1 = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache.jdField_a_of_type_JavaLangString;
      String str2 = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache.jdField_b_of_type_JavaLangString;
      int i = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache.jdField_b_of_type_Int;
      int j = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache.c;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      if (localObject1 != null)
      {
        ((QQCustomDialog)localObject1).dismiss();
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      }
      localObject1 = new PopupDialog.2(this);
      localObject2 = new PopupDialog.3(this);
      if ((i != 0) && (jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)) {
        break label222;
      }
      localObject1 = null;
      i = 2131720247;
      label222:
      if ((j != 0) && (jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener != null)) {
        break label247;
      }
      localObject2 = null;
      j = 2131720247;
      label247:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, k, str1, str2, i, j, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
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
  
  public void onBackPressed() {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "onCreate");
    }
    getWindow().setBackgroundDrawableResource(2130851081);
    paramBundle = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
    if (PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null)
    {
      paramBundle = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
      if (PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog != this)
      {
        paramBundle = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
        PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog.finish();
      }
    }
    paramBundle = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
    PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog = this;
  }
  
  protected void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "onDestroy");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    localObject = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
    PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog = null;
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    super.setIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "onNewIntent");
    }
    paramIntent = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
    if (PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null)
    {
      paramIntent = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
      if (PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog != this)
      {
        paramIntent = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
        PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog.finish();
      }
    }
    paramIntent = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
    PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog = this;
  }
  
  protected void onPause()
  {
    super.onPause();
    a(false);
  }
  
  protected void onResume()
  {
    super.onResume();
    b();
    PopupDialog.Cache localCache = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
    if (PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null)
    {
      localCache = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
      if (PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog != this)
      {
        localCache = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
        PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog.finish();
      }
    }
    localCache = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
    if (PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog != this)
    {
      localCache = jdField_a_of_type_ComTencentAvUtilsPopupDialog$Cache;
      PopupDialog.Cache.jdField_a_of_type_ComTencentAvUtilsPopupDialog = this;
    }
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialog
 * JD-Core Version:    0.7.0.1
 */