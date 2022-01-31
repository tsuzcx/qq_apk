package com.tencent.mobileqq.activity.history;

import acuv;
import afck;
import afwh;
import agbl;
import agbo;
import agbp;
import agbs;
import agei;
import akay;
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
import apef;
import aptv;
import axaq;
import axqw;
import axuy;
import bbjj;
import bfmt;
import bfob;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;

public class ChatHistoryTroopLinkFragment
  extends ChatHistoryBaseFragment
  implements agbo, Handler.Callback, View.OnClickListener, bfob
{
  private int jdField_a_of_type_Int;
  afck jdField_a_of_type_Afck;
  private agbl jdField_a_of_type_Agbl;
  private agbp jdField_a_of_type_Agbp;
  private agei jdField_a_of_type_Agei;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
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
    this.jdField_a_of_type_MqqOsMqqHandler = new bfmt(Looper.getMainLooper(), this, true);
  }
  
  private List<ChatMessage> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_Agbl.a().iterator();
    while (localIterator.hasNext())
    {
      TroopLinkElement localTroopLinkElement = (TroopLinkElement)localIterator.next();
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("image_url_remote", localTroopLinkElement.url);
      ((Bundle)localObject).putString("detail_url", localTroopLinkElement.iconUrl);
      ((Bundle)localObject).putString("title", localTroopLinkElement.title);
      ((Bundle)localObject).putString("desc", localTroopLinkElement.title);
      ((Bundle)localObject).putString("req_create_time", localTroopLinkElement.timeSecond);
      localObject = axuy.a((Bundle)localObject);
      if (localObject != null) {
        ((AbsStructMsg)localObject).mMsgUrl = localTroopLinkElement.url;
      }
      localObject = axaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), localTroopLinkElement.uin, "0", 1, Long.parseLong(localTroopLinkElement.msgSeq), (AbsStructMsg)localObject);
      ((MessageForStructing)localObject).shmsgseq = Long.parseLong(localTroopLinkElement.msgSeq);
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  private static List<Object> a(List<TroopLinkElement> paramList)
  {
    Object localObject = new SimpleDateFormat("yyyy年MM月");
    ArrayList localArrayList = new ArrayList();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopLinkElement localTroopLinkElement = (TroopLinkElement)paramList.next();
      if (a(localTroopLinkElement)) {
        a(localLinkedHashMap, "7天内", localTroopLinkElement);
      } else {
        a(localLinkedHashMap, ((SimpleDateFormat)localObject).format(new Date(Long.parseLong(localTroopLinkElement.timeSecond) * 1000L)), localTroopLinkElement);
      }
    }
    paramList = localLinkedHashMap.entrySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (Map.Entry)paramList.next();
      localArrayList.add(((Map.Entry)localObject).getKey());
      localArrayList.addAll((Collection)((Map.Entry)localObject).getValue());
    }
    return localArrayList;
  }
  
  private void a(Intent paramIntent)
  {
    AbsStructMsg localAbsStructMsg = axuy.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
    if (localAbsStructMsg == null) {
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", 0);
    localSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    localSessionInfo.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("troop_uin");
    bbjj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, localAbsStructMsg, null);
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
    this.jdField_a_of_type_Agbl.a(paramBoolean);
    this.d = paramBoolean;
  }
  
  private void r()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Agbp = new agbp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this);
    this.jdField_a_of_type_Agbp.a(this.jdField_a_of_type_JavaLangString, false);
    this.jdField_a_of_type_Afck = new afck(getActivity(), 3);
    this.jdField_a_of_type_Afck.a();
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369257));
    this.jdField_a_of_type_Agbl = new agbl(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this);
    this.jdField_a_of_type_Agbl.a(new ArrayList());
    a();
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Agbl);
    t();
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131365675);
  }
  
  private void t()
  {
    this.b = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561124, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.b);
    this.b.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
  }
  
  private void u()
  {
    this.b.setVisibility(0);
    this.jdField_a_of_type_Agbp.a(this.jdField_a_of_type_JavaLangString, true);
  }
  
  private void v()
  {
    this.jdField_a_of_type_Agbl.a();
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375676));
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378334)).setText(getString(2131690724));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363480).setVisibility(8);
    EditText localEditText = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365764);
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
      if (!apef.a(localTroopLinkElement.url)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localTroopLinkElement);
      }
    }
    paramList = a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Agbl.a(paramList);
    this.jdField_a_of_type_Agbl.notifyDataSetChanged();
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
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
    v();
    if (paramBoolean) {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 4, 0, "", "", "", "");
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
    this.jdField_a_of_type_Agbs.a(localArrayList);
  }
  
  public void e()
  {
    super.e();
    if (this.f) {
      this.jdField_a_of_type_Afwh.a(false);
    }
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 5, 0, "", "", "", "");
  }
  
  public void f()
  {
    super.f();
    h();
    this.jdField_a_of_type_Agbl.a(false);
    this.jdField_a_of_type_Agbl.notifyDataSetChanged();
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_Afck.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  protected void k()
  {
    super.k();
    c(getString(2131692552));
  }
  
  protected void l()
  {
    super.l();
    c(getString(2131692556));
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
      this.jdField_a_of_type_Afck.a(localArrayList);
      h();
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 4, 0, "", "", "", "");
      return;
    }
    aptv.c(2131690728);
  }
  
  protected void n()
  {
    super.n();
    c(getString(2131692550));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    p();
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BF", "0X800A0BF", 3, 0, "", "", "", "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560309, paramViewGroup, false);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_Agbl.getCount()) && (!this.e)) {
      u();
    }
    if ((paramInt != 0) && (paramInt != 1)) {}
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    s();
    r();
  }
  
  void p()
  {
    akay localakay = (akay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    Bundle localBundle = getActivity().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = localBundle.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = localBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = localBundle.getString("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acuv = new acuv();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getActivity());
    this.jdField_a_of_type_Agei = new agei(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localakay.k());
    this.jdField_a_of_type_Agei.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Agei.show();
  }
  
  public void q()
  {
    this.e = true;
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopLinkFragment
 * JD-Core Version:    0.7.0.1
 */