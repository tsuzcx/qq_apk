package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.activity.history.link.LinkAdapter;
import com.tencent.mobileqq.activity.history.link.TroopLinkCallBack;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.activity.history.link.TroopLinkHandler;
import com.tencent.mobileqq.activity.history.widget.ChatHistorySelectBottomBar;
import com.tencent.mobileqq.activity.messagesearch.LinkMessageSearchDialog;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;

public class ChatHistoryTroopLinkFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback, View.OnClickListener, TroopLinkCallBack, AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  SeparateForward jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward;
  private LinkAdapter jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter;
  private TroopLinkHandler jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkHandler;
  private LinkMessageSearchDialog jdField_a_of_type_ComTencentMobileqqActivityMessagesearchLinkMessageSearchDialog;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ArrayList<TroopLinkElement> jdField_a_of_type_JavaUtilArrayList;
  protected final MqqHandler a;
  private View b;
  private View c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public ChatHistoryTroopLinkFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  }
  
  private List<ChatMessage> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter.a().iterator();
    while (localIterator.hasNext())
    {
      TroopLinkElement localTroopLinkElement = (TroopLinkElement)localIterator.next();
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("image_url_remote", localTroopLinkElement.url);
      ((Bundle)localObject).putString("detail_url", localTroopLinkElement.iconUrl);
      ((Bundle)localObject).putString("title", localTroopLinkElement.title);
      ((Bundle)localObject).putString("desc", localTroopLinkElement.title);
      ((Bundle)localObject).putString("req_create_time", localTroopLinkElement.timeSecond);
      localObject = StructMsgFactory.a((Bundle)localObject);
      if (localObject != null) {
        ((AbsStructMsg)localObject).mMsgUrl = localTroopLinkElement.url;
      }
      localObject = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), localTroopLinkElement.uin, "0", 1, Long.parseLong(localTroopLinkElement.msgSeq), (AbsStructMsg)localObject);
      ((MessageForStructing)localObject).shmsgseq = Long.parseLong(localTroopLinkElement.msgSeq);
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  private static Map<String, ArrayList<TroopLinkElement>> a(List<TroopLinkElement> paramList)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopLinkElement localTroopLinkElement = (TroopLinkElement)paramList.next();
      if (a(localTroopLinkElement)) {
        a(localLinkedHashMap, "7天内", localTroopLinkElement);
      } else {
        a(localLinkedHashMap, localSimpleDateFormat.format(new Date(Long.parseLong(localTroopLinkElement.timeSecond) * 1000L)), localTroopLinkElement);
      }
    }
    return localLinkedHashMap;
  }
  
  private void a(Intent paramIntent)
  {
    AbsStructMsg localAbsStructMsg = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
    if (localAbsStructMsg == null) {
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", 0);
    localSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    localSessionInfo.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("troop_uin");
    ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, localAbsStructMsg, null);
  }
  
  private static void a(LinkedHashMap<String, ArrayList<TroopLinkElement>> paramLinkedHashMap, String paramString, TroopLinkElement paramTroopLinkElement)
  {
    if (paramLinkedHashMap.containsKey(paramString))
    {
      localArrayList = (ArrayList)paramLinkedHashMap.get(paramString);
      localArrayList.add(paramTroopLinkElement);
      paramLinkedHashMap.put(paramString, localArrayList);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramTroopLinkElement);
    paramLinkedHashMap.put(paramString, localArrayList);
  }
  
  private static boolean a(TroopLinkElement paramTroopLinkElement)
  {
    long l = Long.parseLong(paramTroopLinkElement.timeSecond);
    return System.currentTimeMillis() - l * 1000L <= TimeUnit.DAYS.toMillis(7L);
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter.a(paramBoolean);
    this.d = paramBoolean;
  }
  
  private void s()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkHandler = new TroopLinkHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkHandler.a(this.jdField_a_of_type_JavaLangString, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward = new SeparateForward(getActivity(), 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a();
  }
  
  private void t()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370441));
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter = new LinkAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this);
    a();
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter);
    u();
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131366349);
  }
  
  private void u()
  {
    this.b = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561659, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.b);
    this.b.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
  }
  
  private void v()
  {
    this.b.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkHandler.a(this.jdField_a_of_type_JavaLangString, true);
  }
  
  private void w()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter.a();
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377580));
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380584)).setText(getString(2131690872));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363942).setVisibility(8);
    EditText localEditText = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366452);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(this);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (Build.VERSION.SDK_INT > 10)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayerType(0, null);
    }
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    a(paramIntent);
  }
  
  public void a(boolean paramBoolean, @NonNull List<TroopLinkElement> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopLinkElement localTroopLinkElement = (TroopLinkElement)paramList.next();
      if (!FMConstants.a(localTroopLinkElement.url)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localTroopLinkElement);
      }
    }
    paramList = a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter.a(paramList);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter.getCount() == 0)
    {
      this.f = true;
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.c);
    }
  }
  
  protected void b() {}
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    c(paramBoolean);
    w();
    if (paramBoolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 4, 0, "", "", "", "");
    }
  }
  
  protected int c()
  {
    return 1602;
  }
  
  protected void c() {}
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.a(localArrayList);
  }
  
  public void e()
  {
    super.e();
    if (this.f) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(false);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 5, 0, "", "", "", "");
  }
  
  public void f()
  {
    super.f();
    h();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter.notifyDataSetChanged();
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  protected void k()
  {
    super.k();
    c(getString(2131692492));
  }
  
  protected void l()
  {
    super.l();
    c(getString(2131692496));
  }
  
  protected void m()
  {
    super.m();
    List localList = a();
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      if (localList != null) {
        localArrayList.addAll(localList);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a(localArrayList);
      h();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 4, 0, "", "", "", "");
      return;
    }
    FMToastUtil.c(2131690876);
  }
  
  protected void n()
  {
    super.n();
    c(getString(2131692490));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      q();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BF", "0X800A0BF", 3, 0, "", "", "", "");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560738, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter.getCount()) && (!this.e)) {
      v();
    }
    if ((paramInt != 0) && (paramInt != 1)) {}
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    t();
    s();
  }
  
  void q()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    Bundle localBundle = getActivity().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = localBundle.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = localBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = localBundle.getString("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchLinkMessageSearchDialog = new LinkMessageSearchDialog(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRoamManager.l());
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchLinkMessageSearchDialog.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqActivityMessagesearchLinkMessageSearchDialog.show();
  }
  
  public void r()
  {
    this.e = true;
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopLinkFragment
 * JD-Core Version:    0.7.0.1
 */