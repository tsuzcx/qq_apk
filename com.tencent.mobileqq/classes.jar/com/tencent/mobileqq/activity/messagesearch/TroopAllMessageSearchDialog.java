package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TroopAllMessageSearchDialog
  extends BaseMessageSearchDialog
{
  long jdField_a_of_type_Long;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new TroopAllMessageSearchDialog.4(this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public TroopAllMessageResultAdapter a;
  String jdField_a_of_type_JavaLangString = "";
  private List<MessageItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet();
  int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean = false;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  boolean jdField_d_of_type_Boolean = false;
  
  public TroopAllMessageSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    this.jdField_b_of_type_Boolean = paramBoolean;
    paramContext = paramQQAppInterface.getCurrentAccountUin();
    if (!TextUtils.isEmpty(paramContext)) {
      "1".equals(paramContext.substring(paramContext.length() - 1, paramContext.length()));
    }
    h();
    e();
    g();
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showHeaderViewByType, needShowType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",tips: ");
      localStringBuilder.append(paramString);
      QLog.i("LinkMessageSearchDialog", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return;
              }
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
              this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
              return;
            }
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            return;
          }
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setClickable(false);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167138));
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
          return;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166549));
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new TroopAllMessageSearchDialog.1(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    BaseMessageSearchDialog.EnterForSearch localEnterForSearch = new BaseMessageSearchDialog.EnterForSearch(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(localEnterForSearch);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(localEnterForSearch);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private void f()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void g()
  {
    ((ImageButton)findViewById(2131368340)).setOnClickListener(new TroopAllMessageSearchDialog.2(this));
    Button localButton = (Button)findViewById(2131363868);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new TroopAllMessageSearchDialog.3(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131377082));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131559333, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView, null, false);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376345));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377047));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377066));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377068));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371927));
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_b_of_type_AndroidViewView = getLayoutInflater().inflate(2131561866, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_b_of_type_AndroidViewView, null, false);
    this.jdField_b_of_type_AndroidViewView.setClickable(false);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131376345));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371517));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131718613));
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter = new TroopAllMessageResultAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new TroopAllMessageSearchDialog.5(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new TroopAllMessageSearchDialog.6(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new TroopAllMessageSearchDialog.7(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemLongClickListener(new TroopAllMessageSearchDialog.8(this));
  }
  
  protected void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("searchMessage, keyword = ");
      localStringBuilder.append((String)localObject);
      QLog.i("LinkMessageSearchDialog", 2, localStringBuilder.toString());
    }
    if (((String)localObject).length() == 0) {
      return;
    }
    f();
    this.jdField_a_of_type_JavaLangString = ((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("searchMessage, keyword: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", needSearchInCloud: ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(", netState: ");
      ((StringBuilder)localObject).append(AppNetConnInfo.isNetSupport());
      QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 1);
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleMessage, msg.what = ");
      ((StringBuilder)localObject1).append(paramMessage.what);
      ((StringBuilder)localObject1).append(",mSearchMode = ");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
      QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject1).toString());
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          if (i != 6) {
            if (i == 8) {}
          }
        }
        for (;;)
        {
          return true;
          localObject1 = (HashMap)paramMessage.obj;
          paramMessage = (String)((HashMap)localObject1).get("keyword");
          long l = ((Long)((HashMap)localObject1).get("sequence")).longValue();
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("handleMessage : MSG_TYPE_QUERY_LOCAL_DONE lastRequestKeyWord = ");
            ((StringBuilder)localObject1).append(paramMessage);
            ((StringBuilder)localObject1).append(",currentKeyword = ");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject1).append(",searchSequence = ");
            ((StringBuilder)localObject1).append(l);
            ((StringBuilder)localObject1).append(",mCurrentSequence = ");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
            ((StringBuilder)localObject1).append(",mIsComplete: ");
            ((StringBuilder)localObject1).append(this.jdField_d_of_type_Boolean);
            QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject1).toString());
          }
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Long == l) && (!TextUtils.isEmpty(paramMessage)) && (paramMessage.equals(this.jdField_a_of_type_JavaLangString)))
          {
            if ((l == this.jdField_a_of_type_Long) && (this.jdField_a_of_type_JavaLangString.equals(paramMessage)))
            {
              this.jdField_c_of_type_Boolean = false;
              this.jdField_b_of_type_AndroidViewView.setVisibility(8);
              this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_d_of_type_Boolean);
              if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter.getCount() < 20))
              {
                this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714964));
                this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131373124).setVisibility(8);
                this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                this.jdField_b_of_type_AndroidViewView.setVisibility(0);
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter.notifyDataSetChanged();
              this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter);
              this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
              this.jdField_a_of_type_JavaUtilList.clear();
            }
          }
          else
          {
            return true;
            localObject1 = (HashMap)paramMessage.obj;
            paramMessage = (String)((HashMap)localObject1).get("keyword");
            l = ((Long)((HashMap)localObject1).get("sequence")).longValue();
            localObject1 = (List)((HashMap)localObject1).get("data");
            Object localObject2;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleMessage: MERGE_LOCAL_MESSAGES_AND_CLOUD_MESSAGES reqKeyWord = ");
              ((StringBuilder)localObject2).append(paramMessage);
              ((StringBuilder)localObject2).append(",currentKeyword = ");
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject2).append(",searchSequence = ");
              ((StringBuilder)localObject2).append(l);
              ((StringBuilder)localObject2).append(",mCurrentSequence = ");
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
              ((StringBuilder)localObject2).append(",mIsComplete: ");
              ((StringBuilder)localObject2).append(this.jdField_d_of_type_Boolean);
              QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject2).toString());
            }
            if ((!TextUtils.isEmpty(paramMessage)) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Long == l) && (this.jdField_a_of_type_JavaLangString.equals(paramMessage)))
            {
              if ((l == this.jdField_a_of_type_Long) && (this.jdField_a_of_type_JavaLangString.equals(paramMessage)))
              {
                this.jdField_c_of_type_Boolean = false;
                this.jdField_b_of_type_AndroidViewView.setVisibility(8);
                this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter.a((List)localObject1, this.jdField_d_of_type_Boolean);
                this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter.notifyDataSetChanged();
                this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter);
                this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
                this.jdField_a_of_type_JavaUtilList.clear();
              }
            }
            else
            {
              return true;
              localObject1 = paramMessage.getData();
              l = ((Bundle)localObject1).getLong("searchSequence", 0L);
              localObject1 = ((Bundle)localObject1).getString("searchKeyword");
              localObject2 = (List)paramMessage.obj;
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("handleMessage : ACTION_SHOW_MESSAGE searchSequence: ");
                localStringBuilder.append(l);
                localStringBuilder.append(", keyword: ");
                localStringBuilder.append((String)localObject1);
                localStringBuilder.append(", mCurrentKeyword: ");
                localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
                localStringBuilder.append(", searchSequence: ");
                localStringBuilder.append(l);
                localStringBuilder.append(", mSearchSequence: ");
                localStringBuilder.append(this.jdField_a_of_type_Long);
                localStringBuilder.append(", loadType: ");
                localStringBuilder.append(paramMessage.arg1);
                localStringBuilder.append(", size: ");
                if (localObject2 == null) {
                  i = 0;
                } else {
                  i = ((List)localObject2).size();
                }
                localStringBuilder.append(i);
                QLog.d("LinkMessageSearchDialog", 2, localStringBuilder.toString());
              }
              if ((localObject2 == null) || (l != this.jdField_a_of_type_Long) || ((localObject1 != null) && (!((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)))) {
                break;
              }
              if (((1 == paramMessage.arg1) && (((List)localObject2).size() > 0) && (((List)localObject2).size() != 20)) || ((2 == paramMessage.arg1) && (((List)localObject2).size() == 0)))
              {
                this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714962));
                this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131373124).setVisibility(8);
                this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                this.jdField_b_of_type_AndroidViewView.setVisibility(0);
                if (2 == paramMessage.arg1)
                {
                  this.jdField_c_of_type_Boolean = false;
                  continue;
                }
              }
              if ((paramMessage.obj instanceof List))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter.a((List)paramMessage.obj, paramMessage.arg1, this.jdField_d_of_type_Boolean, 0);
                this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter.notifyDataSetChanged();
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkSearchTroopAllMessageResultAdapter.getCount() == 0)
              {
                a(4, null);
              }
              else
              {
                this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
              }
              this.jdField_c_of_type_Boolean = false;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("LinkMessageSearchDialog", 2, "handleMessage : ACTION_SHOW_MESSAGE sequence or keyword not equal, no load");
        }
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.TroopAllMessageSearchDialog
 * JD-Core Version:    0.7.0.1
 */