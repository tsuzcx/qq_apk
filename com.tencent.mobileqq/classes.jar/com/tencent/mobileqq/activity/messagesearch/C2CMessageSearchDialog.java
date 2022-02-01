package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.util.Pair;
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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.searcher.oidb_c2c_searcher.Iterator;

public class C2CMessageSearchDialog
  extends BaseMessageSearchDialog
{
  long jdField_a_of_type_Long;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new C2CMessageSearchDialog.4(this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public C2CMessageResultAdapter a;
  String jdField_a_of_type_JavaLangString = "";
  private HashMap<String, oidb_c2c_searcher.Iterator> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<MessageItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet();
  int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = "";
  private List<MessageItem> jdField_b_of_type_JavaUtilList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  boolean jdField_d_of_type_Boolean = false;
  boolean e = false;
  
  public C2CMessageSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    this.jdField_b_of_type_Boolean = paramBoolean;
    paramContext = paramQQAppInterface.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(paramContext)) && ("1".equals(paramContext.substring(paramContext.length() - 1, paramContext.length())))) {
      this.e = true;
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
      QLog.i("C2CMessageSearchDialog", 2, localStringBuilder.toString());
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
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new C2CMessageSearchDialog.1(this));
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
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void g()
  {
    ((ImageButton)findViewById(2131368340)).setOnClickListener(new C2CMessageSearchDialog.2(this));
    Button localButton = (Button)findViewById(2131363868);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new C2CMessageSearchDialog.3(this));
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
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter = new C2CMessageResultAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new C2CMessageSearchDialog.5(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new C2CMessageSearchDialog.6(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new C2CMessageSearchDialog.7(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemLongClickListener(new C2CMessageSearchDialog.8(this));
  }
  
  protected void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("searchMessage, keyword = ");
      localStringBuilder.append((String)localObject);
      QLog.i("C2CMessageSearchDialog", 2, localStringBuilder.toString());
    }
    if (((String)localObject).length() == 0) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    f();
    this.jdField_a_of_type_JavaLangString = ((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("searchMessage, keyword: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", needSearchInCloud: ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(", netState: ");
      ((StringBuilder)localObject).append(AppNetConnInfo.isNetSupport());
      QLog.i("C2CMessageSearchDialog", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if ((this.jdField_b_of_type_Boolean) && (AppNetConnInfo.isNetSupport()))
    {
      this.jdField_b_of_type_Int = 1;
      a(5, null);
      b(1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FCB", "0X8005FCB", 0, 0, "", "", "", "");
    }
    else
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 1);
      if (this.jdField_b_of_type_Boolean) {
        a(3, this.jdField_a_of_type_AndroidContentContext.getString(2131718621));
      } else {
        a(0, null);
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FCA", "0X8005FCA", 0, 0, "", "", "", "");
  }
  
  public void b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    oidb_c2c_searcher.Iterator localIterator = (oidb_c2c_searcher.Iterator)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_JavaLangString);
    long l1 = NetConnInfoCenter.getServerTime();
    Object localObject2 = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    Object localObject1 = ((MessageRoamManager)localObject2).c();
    if (localObject1 != null)
    {
      long l2 = ((Long)((MessageRoamManager)localObject2).a((Calendar)localObject1).second).longValue();
      localObject2 = new StringBuilder();
      int i = ((Calendar)localObject1).get(1);
      int j = ((Calendar)localObject1).get(2) + 1;
      int k = ((Calendar)localObject1).get(5);
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("-");
      if (j > 9)
      {
        localObject1 = Integer.valueOf(j);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(j);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("-");
      if (k > 9)
      {
        localObject1 = Integer.valueOf(k);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(k);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((StringBuilder)localObject2).append(localObject1);
      l1 = l2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showSearchDialog--> lastDay:");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
        QLog.i("C2CMessageSearchDialog", 2, ((StringBuilder)localObject1).toString());
        l1 = l2;
      }
    }
    if (localIterator != null)
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add(localIterator);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(paramInt, localArrayList, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, (List)localObject1, 0, l1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(paramInt, localArrayList, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, null, 0, l1);
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
      QLog.i("C2CMessageSearchDialog", 2, ((StringBuilder)localObject1).toString());
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          if (i != 4) {
            if (i != 5) {
              if (i != 6) {
                if (i == 8) {}
              }
            }
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
            QLog.i("C2CMessageSearchDialog", 2, ((StringBuilder)localObject1).toString());
          }
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Long == l) && (!TextUtils.isEmpty(paramMessage)))
          {
            if (!paramMessage.equals(this.jdField_a_of_type_JavaLangString)) {
              return true;
            }
            if ((l == this.jdField_a_of_type_Long) && (this.jdField_a_of_type_JavaLangString.equals(paramMessage)))
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FC6", "0X8005FC6", 0, (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), "", "", "", "");
              this.jdField_c_of_type_Boolean = false;
              this.jdField_b_of_type_AndroidViewView.setVisibility(8);
              this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_d_of_type_Boolean);
              if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.getCount() < 20))
              {
                this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701504));
                this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131373124).setVisibility(8);
                this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                this.jdField_b_of_type_AndroidViewView.setVisibility(0);
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.notifyDataSetChanged();
              this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter);
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
              QLog.i("C2CMessageSearchDialog", 2, ((StringBuilder)localObject2).toString());
            }
            if ((!TextUtils.isEmpty(paramMessage)) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Long == l))
            {
              if (!this.jdField_a_of_type_JavaLangString.equals(paramMessage)) {
                return true;
              }
              if ((l == this.jdField_a_of_type_Long) && (this.jdField_a_of_type_JavaLangString.equals(paramMessage)))
              {
                this.jdField_c_of_type_Boolean = false;
                this.jdField_b_of_type_AndroidViewView.setVisibility(8);
                this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a((List)localObject1, this.jdField_d_of_type_Boolean);
                this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.notifyDataSetChanged();
                this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter);
                this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
                this.jdField_a_of_type_JavaUtilList.clear();
              }
            }
            else
            {
              return true;
              localObject2 = (HashMap)paramMessage.obj;
              localObject1 = (String)((HashMap)localObject2).get("KEYWORD");
              l = ((Long)((HashMap)localObject2).get("SEARCHSEQUENCE")).longValue();
              int j = ((Integer)((HashMap)localObject2).get("LOADTYPE")).intValue();
              paramMessage = (List)((HashMap)localObject2).get("SEARCHRESULT");
              boolean bool = ((Boolean)((HashMap)localObject2).get("SEARCHCOMPLETE")).booleanValue();
              if (((HashMap)localObject2).get("SEARCHINFO") != null)
              {
                localObject2 = (List)((HashMap)localObject2).get("SEARCHINFO");
                this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, ((List)localObject2).get(0));
              }
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("handleMessage : RSP_SEARCH_MORE_MESSAGE_IN_CLOUD reqKeyWord: ");
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append(", mCurrentKeyword: ");
                ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
                ((StringBuilder)localObject2).append(", searchSequence: ");
                ((StringBuilder)localObject2).append(l);
                ((StringBuilder)localObject2).append(", mCurrentSequence:");
                ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
                ((StringBuilder)localObject2).append(", searchresult size: ");
                ((StringBuilder)localObject2).append(paramMessage.size());
                ((StringBuilder)localObject2).append(", total cache size: ");
                ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilList.size());
                ((StringBuilder)localObject2).append(", IsComplete: ");
                ((StringBuilder)localObject2).append(bool);
                ((StringBuilder)localObject2).append(", loadType: ");
                ((StringBuilder)localObject2).append(j);
                ((StringBuilder)localObject2).append(", needSearchInCloud: ");
                ((StringBuilder)localObject2).append(this.jdField_b_of_type_Boolean);
                ((StringBuilder)localObject2).append(", retryGetMore: ");
                ((StringBuilder)localObject2).append(this.jdField_c_of_type_Int);
                QLog.i("C2CMessageSearchDialog", 2, ((StringBuilder)localObject2).toString());
              }
              if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Long == l) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)))
              {
                if ((this.jdField_a_of_type_Long == l) && (this.jdField_a_of_type_JavaLangString.equals(localObject1)))
                {
                  this.jdField_c_of_type_Boolean = false;
                  this.jdField_b_of_type_AndroidViewView.setVisibility(8);
                  this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                  this.jdField_d_of_type_Boolean = bool;
                  if (this.jdField_c_of_type_Int == 0) {
                    this.jdField_a_of_type_JavaUtilList.clear();
                  }
                  i = 0;
                  while (i < paramMessage.size())
                  {
                    localObject1 = new MessageItem(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)paramMessage.get(i));
                    this.jdField_a_of_type_JavaUtilList.add(localObject1);
                    this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(((MessageItem)localObject1).a.shmsgseq));
                    i += 1;
                  }
                  if ((this.jdField_a_of_type_JavaUtilList.size() < 15) && (!this.jdField_d_of_type_Boolean))
                  {
                    i = this.jdField_c_of_type_Int;
                    if (i < 4)
                    {
                      this.jdField_c_of_type_Int = (i + 1);
                      this.jdField_a_of_type_Long = System.currentTimeMillis();
                      if (QLog.isColorLevel())
                      {
                        paramMessage = new StringBuilder();
                        paramMessage.append("handleMessage, retry to accumulate more messages for one-screen-display,retryGetMore = ");
                        paramMessage.append(this.jdField_c_of_type_Int);
                        paramMessage.append(",loadType: ");
                        paramMessage.append(j);
                        QLog.i("C2CMessageSearchDialog", 2, paramMessage.toString());
                      }
                      b(j);
                      return true;
                    }
                  }
                  bool = this.jdField_d_of_type_Boolean;
                  if (!bool)
                  {
                    if (this.jdField_c_of_type_Int >= 4) {
                      bool = true;
                    }
                    this.jdField_d_of_type_Boolean = bool;
                  }
                  this.jdField_c_of_type_Int = 0;
                  if (j == 1)
                  {
                    a(0, null);
                    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
                    {
                      if (QLog.isColorLevel())
                      {
                        paramMessage = new StringBuilder();
                        paramMessage.append("LOAD_REFRESH, no result at cloud, load local msg, mIsComplete: ");
                        paramMessage.append(this.jdField_d_of_type_Boolean);
                        QLog.d("C2CMessageSearchDialog", 2, paramMessage.toString());
                      }
                      this.jdField_b_of_type_Int = 0;
                      this.jdField_a_of_type_Long = System.currentTimeMillis();
                      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 1);
                    }
                    else
                    {
                      if (QLog.isColorLevel())
                      {
                        paramMessage = new StringBuilder();
                        paramMessage.append("LOAD_REFRESH, has result at cloud size: ");
                        paramMessage.append(this.jdField_a_of_type_JavaUtilList.size());
                        paramMessage.append(", start merge local msg, mIsComplete: ");
                        paramMessage.append(this.jdField_d_of_type_Boolean);
                        QLog.d("C2CMessageSearchDialog", 2, paramMessage.toString());
                      }
                      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FC2", "0X8005FC2", 0, 0, "", "", "", "");
                    }
                  }
                  else
                  {
                    if (QLog.isColorLevel())
                    {
                      paramMessage = new StringBuilder();
                      paramMessage.append(" LOAD_MORE&LOAD_MSG_IN_CLOUD, has rsult at cloud size: ");
                      paramMessage.append(this.jdField_a_of_type_JavaUtilList.size());
                      paramMessage.append(", mIsComplete: ");
                      paramMessage.append(this.jdField_d_of_type_Boolean);
                      QLog.d("C2CMessageSearchDialog", 2, paramMessage.toString());
                    }
                    if (this.e) {
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FCC", "0X8005FCC", 0, (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), "", "", "", "");
                    }
                    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a(this.jdField_a_of_type_JavaUtilList, 4, this.jdField_d_of_type_Boolean, 1);
                    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.notifyDataSetChanged();
                    this.jdField_a_of_type_JavaUtilList.clear();
                  }
                }
              }
              else
              {
                return true;
                localObject1 = (HashMap)paramMessage.obj;
                paramMessage = (String)((HashMap)localObject1).get("KEYWORD");
                l = ((Long)((HashMap)localObject1).get("SEARCHSEQUENCE")).longValue();
                i = ((Integer)((HashMap)localObject1).get("LOADTYPE")).intValue();
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("handleMessage : RSP_SEARCH_TIMEOUT_OR_ERROR_IN_CLOUD ReqkeyWord = ");
                  ((StringBuilder)localObject1).append(paramMessage);
                  ((StringBuilder)localObject1).append(",currentKeyword: ");
                  ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
                  ((StringBuilder)localObject1).append(", searchSequence: ");
                  ((StringBuilder)localObject1).append(l);
                  ((StringBuilder)localObject1).append(",mCurrentSequence: ");
                  ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
                  ((StringBuilder)localObject1).append(", needSearchInCloud: ");
                  ((StringBuilder)localObject1).append(this.jdField_b_of_type_Boolean);
                  QLog.i("C2CMessageSearchDialog", 2, ((StringBuilder)localObject1).toString());
                }
                if ((this.jdField_b_of_type_Boolean) && (l == this.jdField_a_of_type_Long) && (!TextUtils.isEmpty(paramMessage)) && (paramMessage.equals(this.jdField_a_of_type_JavaLangString)))
                {
                  if ((l == this.jdField_a_of_type_Long) && (this.jdField_a_of_type_JavaLangString.equals(paramMessage)))
                  {
                    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
                    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
                    this.jdField_d_of_type_Boolean = true;
                    this.jdField_c_of_type_Int = 0;
                    if (i == 1)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("C2CMessageSearchDialog", 2, "LOAD_REFRESH query cloud failed --->>> switch local mode");
                      }
                      a(0, null);
                      this.jdField_b_of_type_Int = 0;
                      this.jdField_a_of_type_Long = System.currentTimeMillis();
                      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 1);
                    }
                    else
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("C2CMessageSearchDialog", 2, "LOAD_MSG_IN_CLOUD query cloud failed --->>> merge local data");
                      }
                      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a(this.jdField_a_of_type_JavaUtilList, 4, this.jdField_d_of_type_Boolean, 0);
                      this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.notifyDataSetChanged();
                    }
                    this.jdField_c_of_type_Boolean = false;
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
                    QLog.d("C2CMessageSearchDialog", 2, localStringBuilder.toString());
                  }
                  if ((localObject2 == null) || (l != this.jdField_a_of_type_Long) || ((localObject1 != null) && (!((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)))) {
                    break;
                  }
                  if (((1 == paramMessage.arg1) && (((List)localObject2).size() > 0) && (((List)localObject2).size() != 20)) || ((2 == paramMessage.arg1) && (((List)localObject2).size() == 0)))
                  {
                    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701502));
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
                    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.a((List)paramMessage.obj, paramMessage.arg1, this.jdField_d_of_type_Boolean, 0);
                    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.notifyDataSetChanged();
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CMessageResultAdapter.getCount() == 0)
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
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("C2CMessageSearchDialog", 2, "handleMessage : ACTION_SHOW_MESSAGE sequence or keyword not equal, no load");
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
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog
 * JD-Core Version:    0.7.0.1
 */