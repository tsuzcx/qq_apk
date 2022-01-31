package com.tencent.av.utils;

import adpn;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;
import bdgm;
import bdjz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import mbt;
import mqq.app.BaseActivity;
import mva;
import mvb;
import mvc;

public class PopupDialog
  extends BaseActivity
{
  public static mvc a;
  bdjz jdField_a_of_type_Bdjz = null;
  boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Mvc = new mvc();
  }
  
  public static bdjz a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    bdjz localbdjz2;
    try
    {
      if (paramContext != BaseApplicationImpl.getApplication()) {
        localbdjz1 = bdgm.a(paramContext, 230, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
      }
    }
    catch (Exception localException1)
    {
      bdjz localbdjz1;
      localbdjz2 = null;
    }
    try
    {
      localbdjz1.show();
      return localbdjz1;
    }
    catch (Exception localException2)
    {
      break label56;
    }
    a(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return null;
    label56:
    a(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return localbdjz2;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "hideCustomDialog");
    }
    jdField_a_of_type_Mvc.jdField_a_of_type_Boolean = false;
    mvc localmvc = jdField_a_of_type_Mvc;
    if (mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null)
    {
      localmvc = jdField_a_of_type_Mvc;
      mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog.finish();
      localmvc = jdField_a_of_type_Mvc;
      mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog = null;
    }
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    boolean bool2 = false;
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt1);
    localBundle.putString("titleText", paramString1);
    localBundle.putString("contentText", paramString2);
    localBundle.putInt("leftBtnText", paramInt2);
    localBundle.putInt("rightBtnText", paramInt3);
    if (paramOnClickListener2 != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localBundle.putBoolean("leftBtnVisiable", bool1);
      bool1 = bool2;
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
      adpn.a(paramContext, paramString1, PublicTransFragmentActivity.class, PopupDialogQQSide.class);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "changeDialogText");
    }
    Object localObject = jdField_a_of_type_Mvc;
    if (mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null)
    {
      paramContext = jdField_a_of_type_Mvc;
      mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog.a(paramString1, paramString2);
      return;
    }
    localObject = new Intent(paramContext, PopupDialog.class);
    ((Intent)localObject).putExtra("invoke_type", "changeText");
    ((Intent)localObject).addFlags(268435456);
    jdField_a_of_type_Mvc.jdField_a_of_type_JavaLangString = paramString1;
    jdField_a_of_type_Mvc.jdField_b_of_type_JavaLangString = paramString2;
    paramContext.startActivity((Intent)localObject);
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      mbt.a(BaseApplicationImpl.getContext(), paramBoolean);
    }
  }
  
  public static bdjz b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    bdjz localbdjz2;
    try
    {
      if (paramContext != BaseApplicationImpl.getApplication()) {
        localbdjz1 = bdgm.a(paramContext, 230, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
      }
    }
    catch (Exception localException1)
    {
      bdjz localbdjz1;
      localbdjz2 = null;
    }
    try
    {
      localbdjz1.show();
      return localbdjz1;
    }
    catch (Exception localException2)
    {
      break label56;
    }
    b(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return null;
    label56:
    b(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return localbdjz2;
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
    jdField_a_of_type_Mvc.jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Mvc.jdField_a_of_type_Int = paramInt1;
    jdField_a_of_type_Mvc.jdField_a_of_type_JavaLangString = paramString1;
    jdField_a_of_type_Mvc.jdField_b_of_type_JavaLangString = paramString2;
    jdField_a_of_type_Mvc.jdField_b_of_type_Int = paramInt2;
    jdField_a_of_type_Mvc.c = paramInt3;
    jdField_a_of_type_Mvc.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener2;
    jdField_a_of_type_Mvc.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener1;
    paramContext.startActivity(localIntent);
  }
  
  void a(String paramString1, String paramString2)
  {
    jdField_a_of_type_Mvc.jdField_a_of_type_JavaLangString = paramString1;
    jdField_a_of_type_Mvc.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Bdjz.setTitle(paramString1);
    this.jdField_a_of_type_Bdjz.setMessage(paramString2);
    if (!this.jdField_a_of_type_Bdjz.isShowing()) {
      this.jdField_a_of_type_Bdjz.show();
    }
  }
  
  void b()
  {
    Object localObject1 = super.getIntent().getStringExtra("invoke_type");
    if ((TextUtils.equals((CharSequence)localObject1, "reshow")) && (this.jdField_a_of_type_Bdjz != null)) {
      if (!this.jdField_a_of_type_Bdjz.isShowing()) {
        this.jdField_a_of_type_Bdjz.show();
      }
    }
    do
    {
      return;
      if ((!TextUtils.equals((CharSequence)localObject1, "changeText")) || (this.jdField_a_of_type_Bdjz == null)) {
        break;
      }
      localObject1 = jdField_a_of_type_Mvc.jdField_a_of_type_JavaLangString;
      localObject2 = jdField_a_of_type_Mvc.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_Bdjz.setTitle((String)localObject1);
      this.jdField_a_of_type_Bdjz.setMessage((CharSequence)localObject2);
    } while (this.jdField_a_of_type_Bdjz.isShowing());
    this.jdField_a_of_type_Bdjz.show();
    return;
    int k = jdField_a_of_type_Mvc.jdField_a_of_type_Int;
    String str1 = jdField_a_of_type_Mvc.jdField_a_of_type_JavaLangString;
    String str2 = jdField_a_of_type_Mvc.jdField_b_of_type_JavaLangString;
    int i = jdField_a_of_type_Mvc.jdField_b_of_type_Int;
    int j = jdField_a_of_type_Mvc.c;
    if (this.jdField_a_of_type_Bdjz != null)
    {
      this.jdField_a_of_type_Bdjz.dismiss();
      this.jdField_a_of_type_Bdjz = null;
    }
    localObject1 = new mva(this);
    Object localObject2 = new mvb(this);
    if ((i == 0) || (jdField_a_of_type_Mvc.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null))
    {
      localObject1 = null;
      i = 2131721336;
    }
    if ((j == 0) || (jdField_a_of_type_Mvc.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener == null))
    {
      localObject2 = null;
      j = 2131721336;
    }
    this.jdField_a_of_type_Bdjz = bdgm.a(this, k, str1, str2, i, j, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject1);
    this.jdField_a_of_type_Bdjz.setCancelable(false);
    this.jdField_a_of_type_Bdjz.show();
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "onCreate");
    }
    getWindow().setBackgroundDrawableResource(2130850075);
    paramBundle = jdField_a_of_type_Mvc;
    if (mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null)
    {
      paramBundle = jdField_a_of_type_Mvc;
      if (mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog != this)
      {
        paramBundle = jdField_a_of_type_Mvc;
        mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog.finish();
      }
    }
    paramBundle = jdField_a_of_type_Mvc;
    mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog = this;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PopupDialog", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_Bdjz != null)
    {
      this.jdField_a_of_type_Bdjz.dismiss();
      this.jdField_a_of_type_Bdjz = null;
    }
    mvc localmvc = jdField_a_of_type_Mvc;
    mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog = null;
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
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
    paramIntent = jdField_a_of_type_Mvc;
    if (mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null)
    {
      paramIntent = jdField_a_of_type_Mvc;
      if (mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog != this)
      {
        paramIntent = jdField_a_of_type_Mvc;
        mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog.finish();
      }
    }
    paramIntent = jdField_a_of_type_Mvc;
    mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog = this;
  }
  
  public void onPause()
  {
    super.onPause();
    a(false);
  }
  
  public void onResume()
  {
    super.onResume();
    b();
    mvc localmvc = jdField_a_of_type_Mvc;
    if (mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog != null)
    {
      localmvc = jdField_a_of_type_Mvc;
      if (mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog != this)
      {
        localmvc = jdField_a_of_type_Mvc;
        mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog.finish();
      }
    }
    localmvc = jdField_a_of_type_Mvc;
    if (mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog != this)
    {
      localmvc = jdField_a_of_type_Mvc;
      mvc.jdField_a_of_type_ComTencentAvUtilsPopupDialog = this;
    }
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.PopupDialog
 * JD-Core Version:    0.7.0.1
 */