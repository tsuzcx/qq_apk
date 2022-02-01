package com.tencent.mobileqq.activity.history;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.chathistory.SeparateForward;
import com.tencent.mobileqq.activity.history.helper.ChatHistoryItemSelectHelper;
import com.tencent.mobileqq.activity.history.widget.ChatHistorySelectBottomBar;
import com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageSearchDialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;

public class ChatHistoryC2CLinkFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback, View.OnClickListener, AbsListView.OnScrollListener
{
  public static final Pattern a;
  protected static final String b;
  private static int jdField_c_of_type_Int = 30;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 9223372036854775807L;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  SeparateForward jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward;
  ChatHistoryC2CLinkAdapter jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter;
  private C2CLinkMessageSearchDialog jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CLinkMessageSearchDialog;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  ArrayList<Object> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private LinkedHashMap<String, List<MessageRecord>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  protected final MqqHandler a;
  int jdField_b_of_type_Int = 3;
  long jdField_b_of_type_Long = 9223372036854775807L;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  QQAppInterface jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
  long jdField_c_of_type_Long = 9223372036854775807L;
  String jdField_c_of_type_JavaLangString;
  long jdField_d_of_type_Long = 0L;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Patterns.c.pattern());
    localStringBuilder.append("|");
    localStringBuilder.append(Patterns.d.pattern());
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile(jdField_b_of_type_JavaLangString, 2);
  }
  
  public ChatHistoryC2CLinkFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  }
  
  private List<ChatMessage> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperChatHistoryItemSelectHelper.a();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof ChatMessage)) {
          localArrayList.add((ChatMessage)localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  private void r()
  {
    if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ChatHistoryC2CLinkFragment.1(this);
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131377024));
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379866)).setText(getString(2131690801));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363868).setVisibility(8);
    EditText localEditText = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366333);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(this);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (Build.VERSION.SDK_INT > 10)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayerType(0, null);
    }
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.removeAll(paramList);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      paramList = null;
      int i = 0;
      Object localObject1;
      int j;
      do
      {
        localObject1 = paramList;
        if (!localIterator.hasNext()) {
          break label90;
        }
        Object localObject2 = localIterator.next();
        if (!(localObject2 instanceof String)) {
          break;
        }
        localObject1 = paramList;
        if (i == 0) {
          localObject1 = localObject2;
        }
        j = i + 1;
        i = j;
        paramList = (List<ChatMessage>)localObject1;
      } while (j != 2);
      label90:
      if (localObject1 != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(localObject1);
        this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(localObject1);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter.a(this.jdField_a_of_type_JavaUtilLinkedHashMap);
      FMToastUtil.b(2131691487);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    }
  }
  
  protected void b() {}
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter.notifyDataSetChanged();
    if (paramBoolean) {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B1", "0X800A0B1", 4, 0, "", "", "", "");
    }
  }
  
  protected int c()
  {
    return 1602;
  }
  
  protected void c() {}
  
  public void c(boolean paramBoolean)
  {
    ThreadManager.post(new ChatHistoryC2CLinkFragment.2(this, paramBoolean), 10, null, true);
  }
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.a(localArrayList);
  }
  
  public void e()
  {
    super.e();
    ChatHistoryC2CLinkAdapter localChatHistoryC2CLinkAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter;
    if ((localChatHistoryC2CLinkAdapter != null) && (localChatHistoryC2CLinkAdapter.getCount() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(false);
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 5, 0, "", "", "", "");
  }
  
  public void f()
  {
    super.f();
    h();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter.notifyDataSetChanged();
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      a((List)paramMessage.obj);
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter.a(this.jdField_a_of_type_JavaUtilLinkedHashMap);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter.getCount() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
      return false;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    return false;
  }
  
  protected void k()
  {
    super.k();
    b(getString(2131692428));
  }
  
  protected void l()
  {
    super.l();
    FMToastUtil.a(2131692743);
  }
  
  protected void m()
  {
    super.m();
    List localList = a();
    if (localList.size() == 0) {
      FMToastUtil.c(2131690805);
    }
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      if (localList != null) {
        localArrayList.addAll(localList);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a(localArrayList);
      h();
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B2", "0X800A0B2", 4, 0, "", "", "", "");
    }
  }
  
  protected void n()
  {
    super.n();
    if (a().size() > 0)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getBaseActivity(), null);
      localActionSheet.setMainTitle(2131696093);
      localActionSheet.addButton(getString(2131692273), 3);
      localActionSheet.addCancelButton(2131690728);
      localActionSheet.setOnButtonClickListener(new ChatHistoryC2CLinkFragment.3(this, localActionSheet));
      localActionSheet.show();
      return;
    }
    FMToastUtil.c(2131690805);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131366333)
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_d_of_type_Long > 1000L)
      {
        this.jdField_d_of_type_Long = l;
        q();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    this.jdField_a_of_type_AndroidContentContext = getBaseActivity();
    this.jdField_c_of_type_JavaLangString = getBaseActivity().getIntent().getStringExtra("uin");
    this.jdField_a_of_type_Int = getBaseActivity().getIntent().getIntExtra("uintype", 0);
    this.jdField_d_of_type_JavaLangString = getBaseActivity().getIntent().getStringExtra("uinname");
    r();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.inflate(2131558854, paramViewGroup, false));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131366237));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131377955));
    this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_b_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131562870, null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
    a();
    c(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter = new ChatHistoryC2CLinkAdapter(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnClickListener, this, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperChatHistoryItemSelectHelper);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter.a(this.jdField_a_of_type_JavaUtilLinkedHashMap);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward = new SeparateForward(getBaseActivity(), 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a();
    paramLayoutInflater = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      c(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryC2CLinkAdapter.notifyDataSetChanged();
    }
  }
  
  void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    Bundle localBundle = getBaseActivity().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = localBundle.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = localBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getBaseActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CLinkMessageSearchDialog = new C2CLinkMessageSearchDialog(getBaseActivity(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CLinkMessageSearchDialog.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchC2CLinkMessageSearchDialog.show();
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 3, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment
 * JD-Core Version:    0.7.0.1
 */