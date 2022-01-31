package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import java.util.List;
import woj;
import wok;
import wol;
import wom;
import won;
import woo;
import wop;
import woq;

public class MessageSearchDialog
  extends BaseMessageSearchDialog
{
  public static final String a;
  private View.OnClickListener a;
  protected TextView a;
  public MessageResultAdapter a;
  public SearchHistoryAdapter a;
  public boolean b = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = MessageSearchDialog.class.getSimpleName();
  }
  
  public MessageSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new wom(this);
    k();
    g();
    h();
    i();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131368255));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new woj(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    BaseMessageSearchDialog.EnterForSearch localEnterForSearch = new BaseMessageSearchDialog.EnterForSearch(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(localEnterForSearch);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(localEnterForSearch);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter.a("");
  }
  
  private void h()
  {
    ((ImageButton)findViewById(2131368256)).setOnClickListener(new wok(this));
  }
  
  private void i()
  {
    Button localButton = (Button)findViewById(2131368254);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new wol(this));
  }
  
  private void j()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "loadMessageMore, currentKeyword = " + str);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.a(System.currentTimeMillis(), str, 2);
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131363901));
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter = new MessageResultAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter = new SearchHistoryAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new won(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new woo(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new wop(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemLongClickListener(new woq(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363902));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131433793);
  }
  
  protected void a()
  {
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "searchMessage, currentKeyword = " + str1);
    }
    if (str1.length() == 0) {}
    String str2;
    do
    {
      return;
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.a();
      if ((this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() != this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter) || (!str1.equalsIgnoreCase(str2))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "searchMessage, skip, currentKeyword = " + str1 + ", mLastKeyword = " + str2);
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.a(System.currentTimeMillis(), str1, 1);
    a(2131433635);
  }
  
  public void dismiss()
  {
    ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1);
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
  }
  
  void f()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "handleMessage, msg.what = " + paramMessage.what);
    }
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      c();
      continue;
      d();
      continue;
      b();
      if (this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() != this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter) {
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter);
      }
      if ((paramMessage.obj instanceof List))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.a((List)paramMessage.obj, paramMessage.arg1);
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.getCount() == 0)
      {
        f();
      }
      else
      {
        e();
        continue;
        if (this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() != this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter) {
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter.notifyDataSetChanged();
        e();
      }
    }
  }
  
  public void show()
  {
    super.show();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog
 * JD-Core Version:    0.7.0.1
 */