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

public class MessageSearchDialog
  extends BaseMessageSearchDialog
{
  protected static final String a = "MessageSearchDialog";
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new MessageSearchDialog.4(this);
  protected TextView a;
  MessageResultAdapter jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter;
  SearchHistoryAdapter jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter;
  boolean b = true;
  
  public MessageSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    k();
    g();
    h();
    i();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new MessageSearchDialog.1(this));
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
    ((ImageButton)findViewById(2131368340)).setOnClickListener(new MessageSearchDialog.2(this));
  }
  
  private void i()
  {
    Button localButton = (Button)findViewById(2131363868);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new MessageSearchDialog.3(this));
  }
  
  private void j()
  {
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (QLog.isColorLevel())
    {
      String str2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMessageMore, currentKeyword = ");
      localStringBuilder.append(str1);
      QLog.i(str2, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.a(System.currentTimeMillis(), str1, 2);
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131377082));
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter = new MessageResultAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter = new SearchHistoryAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new MessageSearchDialog.5(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new MessageSearchDialog.6(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new MessageSearchDialog.7(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemLongClickListener(new MessageSearchDialog.8(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371921));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718604);
  }
  
  protected void a()
  {
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    Object localObject;
    if (QLog.isColorLevel())
    {
      str2 = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("searchMessage, currentKeyword = ");
      ((StringBuilder)localObject).append(str1);
      QLog.i(str2, 2, ((StringBuilder)localObject).toString());
    }
    if (str1.length() == 0) {
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.a();
    if ((this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() == this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter) && (str1.equalsIgnoreCase(str2)))
    {
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("searchMessage, skip, currentKeyword = ");
        localStringBuilder.append(str1);
        localStringBuilder.append(", mLastKeyword = ");
        localStringBuilder.append(str2);
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageResultAdapter.a(System.currentTimeMillis(), str1, 1);
    a(2131690804);
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
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage, msg.what = ");
      localStringBuilder.append(paramMessage.what);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
          if (this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() != this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter) {
            this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchSearchHistoryAdapter.notifyDataSetChanged();
          e();
          return true;
        }
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
          return true;
        }
        e();
        return true;
      }
      d();
      return true;
    }
    c();
    return true;
  }
  
  public void show()
  {
    super.show();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog
 * JD-Core Version:    0.7.0.1
 */