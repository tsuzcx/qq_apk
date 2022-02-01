package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.freshnews.BlockableEditTextView;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.app.HotChatHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class HotChatAnnounceActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  HotChatObserver jdField_a_of_type_ComTencentMobileqqAppHotChatObserver = new HotChatAnnounceActivity.1(this);
  BlockableEditTextView jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  View jdField_b_of_type_AndroidViewView;
  BlockableEditTextView jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView;
  String jdField_b_of_type_JavaLangString;
  String c;
  String d;
  String e;
  
  private void a()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) && (!isFinishing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694668);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (!localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void b()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561118);
    setTitle(HardCodeUtil.a(2131705624));
    setRightButton(2131693596, this);
    setLeftViewName(2131690529);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView = ((BlockableEditTextView)super.findViewById(2131362699));
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.addTextChangedListener(new HotChatAnnounceActivity.2(this));
    this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView = ((BlockableEditTextView)super.findViewById(2131370098));
    this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.addTextChangedListener(new HotChatAnnounceActivity.3(this));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131380963);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369988));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131370109);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("TROOPUIN");
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("CANADDLINK", false);
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("ANNOUCE");
    this.c = paramBundle.getStringExtra("LINK");
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.setText(this.c);
    paramBundle = this.c;
    if ((paramBundle != null) && (paramBundle.trim().length() > 0)) {
      this.jdField_b_of_type_AndroidViewView.setEnabled(true);
    }
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver != null) {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
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
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.a(this, 0, 2131692183, 0).b(getTitleBarHeight());
        return;
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getText().toString();
      localObject = this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getText().toString();
      if (TextUtils.isEmpty(str))
      {
        QQToast.a(this, 0, HardCodeUtil.a(2131705629), 0).b(getTitleBarHeight());
        return;
      }
      if (str.getBytes().length / 3 > 40)
      {
        QQToast.a(this, 0, HardCodeUtil.a(2131705623), 0).b(getTitleBarHeight());
        return;
      }
      if (localObject != null)
      {
        paramView = (View)localObject;
        if (!TextUtils.isEmpty(((String)localObject).trim())) {}
      }
      else
      {
        paramView = null;
      }
      if ((!TextUtils.isEmpty(paramView)) && (paramView.length() > 1024))
      {
        QQToast.a(this, 0, HardCodeUtil.a(2131705631), 0).b(getTitleBarHeight());
        return;
      }
      localObject = (HotChatHandler)this.app.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
      HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
      a();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick.contnet=");
        localStringBuilder.append(str);
        localStringBuilder.append(",link=");
        localStringBuilder.append(paramView);
        QLog.i("HotChatAnnounceActivity", 2, localStringBuilder.toString());
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8005D54", "0X8005D54", 0, 0, "", "", "", "");
      boolean bool;
      if (localHotChatInfo.userCreate == 1) {
        bool = ((HotChatHandler)localObject).setUserCreateHotChatAnnounce(localHotChatInfo.troopUin, str);
      } else {
        bool = ((HotChatHandler)localObject).setHotChatAnnounce(localHotChatInfo.uuid.getBytes(), str, paramView);
      }
      this.d = str;
      this.e = paramView;
      if (!bool)
      {
        b();
        QQToast.a(this, 0, HardCodeUtil.a(2131705627), 0).b(getTitleBarHeight());
      }
    }
    else if (paramView == this.jdField_b_of_type_AndroidViewView)
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getText().toString();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramView = (View)localObject;
        if (!((String)localObject).startsWith("http"))
        {
          paramView = new StringBuilder();
          paramView.append("http://");
          paramView.append((String)localObject);
          paramView = paramView.toString();
        }
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HotChatAnnounceActivity
 * JD-Core Version:    0.7.0.1
 */