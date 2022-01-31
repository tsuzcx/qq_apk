package com.tencent.mobileqq.activity;

import aalh;
import aali;
import aalj;
import akge;
import akgf;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import bbev;
import bcpq;
import bcpw;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ClearableEditText;

public class AuthDevRenameActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, TextView.OnEditorActionListener
{
  public static String a;
  public static String b = "appname";
  public static String c = "appid";
  public static String d = "sub_appid";
  public static String e = "device_guid";
  public static String f = "target_name";
  public static String g = "target_type_info";
  public static String h = "target_desc";
  public static String i = "index";
  private akgf jdField_a_of_type_Akgf = new aali(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new aalj(this);
  private bcpq jdField_a_of_type_Bcpq;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  
  static
  {
    jdField_a_of_type_JavaLangString = "uin";
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AuthDevRenameActivity.4(this));
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AuthDevRenameActivity.5(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560727);
    super.addObserver(this.jdField_a_of_type_Akgf);
    super.setRightButton(2131692110, this);
    this.leftView.setText(2131690596);
    this.leftView.setOnClickListener(this);
    if ((this.centerView != null) && ((this.centerView instanceof TextView))) {
      this.centerView.setVisibility(8);
    }
    paramBundle = super.getIntent();
    String str;
    if (paramBundle != null)
    {
      str = paramBundle.getStringExtra(f);
      paramBundle = paramBundle.getStringExtra(g);
    }
    for (;;)
    {
      Object localObject = super.findViewById(2131377400);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        TextView localTextView = (TextView)((View)localObject).findViewById(2131377438);
        if (localTextView != null) {
          localTextView.setText(2131692164);
        }
        localObject = (TextView)((View)localObject).findViewById(2131377379);
        if ((localObject != null) && (!TextUtils.isEmpty(paramBundle))) {
          ((TextView)localObject).setText(paramBundle);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)super.findViewById(2131362875));
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setHint(str);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setImeOptions(6);
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnEditorActionListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setImeActionLabel(getString(2131694025), 6);
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setFilters(new InputFilter[] { new aalh(this) });
        return true;
        super.setTitle(2131692164);
      }
      paramBundle = null;
      str = null;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    Object localObject;
    do
    {
      String str;
      do
      {
        do
        {
          super.finish();
          return;
          if (!bbev.d(this))
          {
            bcpw.a(this, getString(2131692321), 0).b(getTitleBarHeight());
            return;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getEditableText().toString();
          if (TextUtils.isEmpty(paramView))
          {
            bcpw.a(this, getString(2131692129), 0).b(getTitleBarHeight());
            return;
          }
          localObject = super.getIntent();
        } while (localObject == null);
        str = ((Intent)localObject).getStringExtra(f);
      } while ((TextUtils.isEmpty(str)) || (TextUtils.equals(str, paramView)));
      localObject = ((Intent)localObject).getExtras();
      ((Bundle)localObject).putString(f, paramView);
      ((Bundle)localObject).putString(jdField_a_of_type_JavaLangString, this.app.getCurrentAccountUin());
      paramView = (akge)this.app.a(34);
    } while (paramView == null);
    a();
    paramView.a((Bundle)localObject);
  }
  
  public void onDestroy()
  {
    b();
    super.onDestroy();
    super.removeObserver(this.jdField_a_of_type_Akgf);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      onClick(this.rightViewText);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevRenameActivity
 * JD-Core Version:    0.7.0.1
 */