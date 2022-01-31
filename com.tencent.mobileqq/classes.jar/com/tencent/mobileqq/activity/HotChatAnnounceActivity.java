package com.tencent.mobileqq.activity;

import abjf;
import abjg;
import abjh;
import ajyc;
import ajyi;
import ajyt;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import axqw;
import bbev;
import bcpq;
import bcpw;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.freshnews.BlockableEditTextView;
import com.tencent.qphone.base.util.QLog;

public class HotChatAnnounceActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  ajyt jdField_a_of_type_Ajyt = new abjf(this);
  View jdField_a_of_type_AndroidViewView;
  public TextView a;
  bcpq jdField_a_of_type_Bcpq;
  BlockableEditTextView jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView;
  public String a;
  boolean jdField_a_of_type_Boolean;
  public View b;
  BlockableEditTextView jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView;
  String jdField_b_of_type_JavaLangString;
  String c;
  public String d;
  public String e;
  
  private void a()
  {
    try
    {
      if ((this.jdField_a_of_type_Bcpq == null) && (!isFinishing()))
      {
        this.jdField_a_of_type_Bcpq = new bcpq(this, getTitleBarHeight());
        this.jdField_a_of_type_Bcpq.c(2131694930);
      }
      if ((this.jdField_a_of_type_Bcpq != null) && (!this.jdField_a_of_type_Bcpq.isShowing())) {
        this.jdField_a_of_type_Bcpq.show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  private void b()
  {
    try
    {
      if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing()))
      {
        this.jdField_a_of_type_Bcpq.dismiss();
        this.jdField_a_of_type_Bcpq.cancel();
      }
      this.jdField_a_of_type_Bcpq = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560793);
    setTitle(ajyc.a(2131705524));
    setRightButton(2131693757, this);
    setLeftViewName(2131690331);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView = ((BlockableEditTextView)super.findViewById(2131362552));
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.addTextChangedListener(new abjg(this));
    this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView = ((BlockableEditTextView)super.findViewById(2131369255));
    this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.addTextChangedListener(new abjh(this));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131379292);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369142));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131369265);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("TROOPUIN");
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("CANADDLINK", false);
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("ANNOUCE");
    this.c = paramBundle.getStringExtra("LINK");
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.setText(this.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.setText(this.c);
      if ((this.c != null) && (this.c.trim().length() > 0)) {
        this.jdField_b_of_type_AndroidViewView.setEnabled(true);
      }
      this.app.addObserver(this.jdField_a_of_type_Ajyt);
      return true;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Ajyt != null) {
      this.app.removeObserver(this.jdField_a_of_type_Ajyt);
    }
  }
  
  public void finish()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    View localView = getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == this.rightViewText)
    {
      if (!bbev.d(this))
      {
        bcpw.a(this, 0, 2131692321, 0).b(getTitleBarHeight());
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getText().toString();
      paramView = this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getText().toString();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        bcpw.a(this, 0, ajyc.a(2131705529), 0).b(getTitleBarHeight());
        return;
      }
      if (((String)localObject).getBytes().length / 3 > 40)
      {
        bcpw.a(this, 0, ajyc.a(2131705523), 0).b(getTitleBarHeight());
        return;
      }
      if ((paramView != null) && (!TextUtils.isEmpty(paramView.trim()))) {
        break label452;
      }
      paramView = null;
    }
    label452:
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramView)) && (paramView.length() > 1024))
      {
        bcpw.a(this, 0, ajyc.a(2131705531), 0).b(getTitleBarHeight());
        return;
      }
      ajyi localajyi = (ajyi)this.app.a(35);
      HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(60)).a(this.jdField_a_of_type_JavaLangString);
      a();
      if (QLog.isColorLevel()) {
        QLog.i("HotChatAnnounceActivity", 2, "onClick.contnet=" + (String)localObject + ",link=" + paramView);
      }
      axqw.b(this.app, "CliOper", "", "", "0X8005D54", "0X8005D54", 0, 0, "", "", "", "");
      if (localHotChatInfo.userCreate == 1) {}
      for (boolean bool = localajyi.a(localHotChatInfo.troopUin, (String)localObject);; bool = localajyi.a(localHotChatInfo.uuid.getBytes(), (String)localObject, paramView))
      {
        this.d = ((String)localObject);
        this.e = paramView;
        if (bool) {
          break;
        }
        b();
        bcpw.a(this, 0, ajyc.a(2131705527), 0).b(getTitleBarHeight());
        return;
      }
      if (paramView != this.jdField_b_of_type_AndroidViewView) {
        break;
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getText().toString();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      paramView = (View)localObject;
      if (!((String)localObject).startsWith("http")) {
        paramView = "http://" + (String)localObject;
      }
      localObject = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      startActivity((Intent)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HotChatAnnounceActivity
 * JD-Core Version:    0.7.0.1
 */