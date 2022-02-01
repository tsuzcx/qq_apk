package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TenDocMessageSearchDialog
  extends BaseMessageSearchDialog
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TenDocMessageResultAdapter jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter;
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  
  public TenDocMessageSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    this.jdField_b_of_type_Int = paramInt;
    e();
    f();
    g();
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131377082));
    View localView = getLayoutInflater().inflate(2131559333, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131561866, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131371927));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131376345).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131373124).setVisibility(8);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371517)).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131718616));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView, null, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidViewView, null, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter = new TenDocMessageResultAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368340));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new TenDocMessageSearchDialog.1(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new TenDocMessageSearchDialog.2(this));
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366333));
    this.jdField_b_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(new TenDocMessageSearchDialog.3(this));
    this.jdField_b_of_type_AndroidWidgetEditText.setImeOptions(3);
    BaseMessageSearchDialog.EnterForSearch localEnterForSearch = new BaseMessageSearchDialog.EnterForSearch(this);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnEditorActionListener(localEnterForSearch);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnKeyListener(localEnterForSearch);
    this.jdField_b_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_AndroidContentContext.getString(2131690816));
    this.jdField_b_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_b_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new TenDocMessageSearchDialog.4(this));
    Button localButton = (Button)findViewById(2131363868);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new TenDocMessageSearchDialog.5(this));
  }
  
  protected void a()
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("searchMessage, keyword = ");
      localStringBuilder.append((String)localObject);
      QLog.i("TenDocMessageSearchDialog", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_JavaLangString = ((String)localObject);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("searchMessage, keyword: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", netState: ");
      ((StringBuilder)localObject).append(AppNetConnInfo.isNetSupport());
      QLog.i("TenDocMessageSearchDialog", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A174", "0X800A174", this.jdField_b_of_type_Int, 0, "", "", "s_qq_history_tab", "");
  }
  
  public void a(List<Object> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof TencentDocItem)) {
        localArrayList.add((TencentDocItem)localObject);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter.a(localArrayList);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TenDocMessageSearchDialog", 2, "handleMessage, catch show message");
      }
      Object localObject = paramMessage.getData();
      long l = ((Bundle)localObject).getLong("searchSequence", 0L);
      localObject = ((Bundle)localObject).getString("searchKeyword");
      if (((paramMessage.obj instanceof List)) && (l == this.jdField_a_of_type_Long) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, (CharSequence)localObject)))
      {
        List localList = (List)paramMessage.obj;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleMessage : ACTION_SHOW_MESSAGE searchSequence: ");
          localStringBuilder.append(l);
          localStringBuilder.append(", keyword: ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(", mCurrentKeyword: ");
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(", searchSequence: ");
          localStringBuilder.append(l);
          localStringBuilder.append(", mCurrentSearchSequence: ");
          localStringBuilder.append(this.jdField_a_of_type_Long);
          localStringBuilder.append(", loadType: ");
          localStringBuilder.append(paramMessage.arg1);
          localStringBuilder.append(", size: ");
          int i;
          if (localList == null) {
            i = 0;
          } else {
            i = localList.size();
          }
          localStringBuilder.append(i);
          QLog.d("TenDocMessageSearchDialog", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter.a(localList, paramMessage.arg1);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter.getCount() == 0)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          return true;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TenDocMessageSearchDialog", 2, "handleMessage : ACTION_SHOW_MESSAGE sequence or keyword not equal, no load");
      }
      return true;
    }
    return super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.TenDocMessageSearchDialog
 * JD-Core Version:    0.7.0.1
 */