package com.tencent.mobileqq.activity;

import adeq;
import ader;
import ades;
import alud;
import aluj;
import aluu;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import azqs;
import bdin;
import bety;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.freshnews.BlockableEditTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class HotChatAnnounceActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  aluu jdField_a_of_type_Aluu = new adeq(this);
  View jdField_a_of_type_AndroidViewView;
  public TextView a;
  bety jdField_a_of_type_Bety;
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
      if ((this.jdField_a_of_type_Bety == null) && (!isFinishing()))
      {
        this.jdField_a_of_type_Bety = new bety(this, getTitleBarHeight());
        this.jdField_a_of_type_Bety.c(2131695090);
      }
      if ((this.jdField_a_of_type_Bety != null) && (!this.jdField_a_of_type_Bety.isShowing())) {
        this.jdField_a_of_type_Bety.show();
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
      if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing()))
      {
        this.jdField_a_of_type_Bety.dismiss();
        this.jdField_a_of_type_Bety.cancel();
      }
      this.jdField_a_of_type_Bety = null;
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
    super.setContentView(2131560993);
    setTitle(alud.a(2131705919));
    setRightButton(2131693876, this);
    setLeftViewName(2131690382);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView = ((BlockableEditTextView)super.findViewById(2131362579));
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.addTextChangedListener(new ader(this));
    this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView = ((BlockableEditTextView)super.findViewById(2131369508));
    this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.addTextChangedListener(new ades(this));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131380056);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369392));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131369518);
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
      this.app.addObserver(this.jdField_a_of_type_Aluu);
      return true;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Aluu != null) {
      this.app.removeObserver(this.jdField_a_of_type_Aluu);
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
      if (!bdin.d(this))
      {
        QQToast.a(this, 0, 2131692398, 0).b(getTitleBarHeight());
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getText().toString();
      paramView = this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getText().toString();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QQToast.a(this, 0, alud.a(2131705924), 0).b(getTitleBarHeight());
        return;
      }
      if (((String)localObject).getBytes().length / 3 > 40)
      {
        QQToast.a(this, 0, alud.a(2131705918), 0).b(getTitleBarHeight());
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
        QQToast.a(this, 0, alud.a(2131705926), 0).b(getTitleBarHeight());
        return;
      }
      aluj localaluj = (aluj)this.app.a(35);
      HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(60)).a(this.jdField_a_of_type_JavaLangString);
      a();
      if (QLog.isColorLevel()) {
        QLog.i("HotChatAnnounceActivity", 2, "onClick.contnet=" + (String)localObject + ",link=" + paramView);
      }
      azqs.b(this.app, "CliOper", "", "", "0X8005D54", "0X8005D54", 0, 0, "", "", "", "");
      if (localHotChatInfo.userCreate == 1) {}
      for (boolean bool = localaluj.a(localHotChatInfo.troopUin, (String)localObject);; bool = localaluj.a(localHotChatInfo.uuid.getBytes(), (String)localObject, paramView))
      {
        this.d = ((String)localObject);
        this.e = paramView;
        if (bool) {
          break;
        }
        b();
        QQToast.a(this, 0, alud.a(2131705922), 0).b(getTitleBarHeight());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HotChatAnnounceActivity
 * JD-Core Version:    0.7.0.1
 */