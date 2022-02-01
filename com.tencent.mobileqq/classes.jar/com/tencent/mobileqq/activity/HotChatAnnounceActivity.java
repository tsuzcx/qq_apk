package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.freshnews.BlockableEditTextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

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
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694694);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561275);
    setTitle(HardCodeUtil.a(2131705551));
    setRightButton(2131693643, this);
    setLeftViewName(2131690601);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView = ((BlockableEditTextView)super.findViewById(2131362744));
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.addTextChangedListener(new HotChatAnnounceActivity.2(this));
    this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView = ((BlockableEditTextView)super.findViewById(2131370439));
    this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.addTextChangedListener(new HotChatAnnounceActivity.3(this));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131381731);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370320));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131370451);
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
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppHotChatObserver);
      return true;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void doOnDestroy()
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
    Object localObject2;
    Object localObject1;
    if (paramView == this.rightViewText)
    {
      if (!NetworkUtil.d(this)) {
        QQToast.a(this, 0, 2131692257, 0).b(getTitleBarHeight());
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getText().toString();
        localObject1 = this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getText().toString();
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          QQToast.a(this, 0, HardCodeUtil.a(2131705556), 0).b(getTitleBarHeight());
        }
        else
        {
          if (((String)localObject2).getBytes().length / 3 <= 40) {
            break;
          }
          QQToast.a(this, 0, HardCodeUtil.a(2131705550), 0).b(getTitleBarHeight());
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((String)localObject1).trim()))) {
        break label486;
      }
      localObject1 = null;
    }
    label486:
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).length() > 1024))
      {
        QQToast.a(this, 0, HardCodeUtil.a(2131705558), 0).b(getTitleBarHeight());
        break;
      }
      HotChatHandler localHotChatHandler = (HotChatHandler)this.app.getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER);
      HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
      a();
      if (QLog.isColorLevel()) {
        QLog.i("HotChatAnnounceActivity", 2, "onClick.contnet=" + (String)localObject2 + ",link=" + (String)localObject1);
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8005D54", "0X8005D54", 0, 0, "", "", "", "");
      if (localHotChatInfo.userCreate == 1) {}
      for (boolean bool = localHotChatHandler.a(localHotChatInfo.troopUin, (String)localObject2);; bool = localHotChatHandler.a(localHotChatInfo.uuid.getBytes(), (String)localObject2, (String)localObject1))
      {
        this.d = ((String)localObject2);
        this.e = ((String)localObject1);
        if (bool) {
          break;
        }
        b();
        QQToast.a(this, 0, HardCodeUtil.a(2131705554), 0).b(getTitleBarHeight());
        break;
      }
      if (paramView != this.jdField_b_of_type_AndroidViewView) {
        break;
      }
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqFreshnewsBlockableEditTextView.getText().toString();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localObject2;
      if (!((String)localObject2).startsWith("http")) {
        localObject1 = "http://" + (String)localObject2;
      }
      localObject2 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      startActivity((Intent)localObject2);
      break;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HotChatAnnounceActivity
 * JD-Core Version:    0.7.0.1
 */