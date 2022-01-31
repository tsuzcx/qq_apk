package com.tencent.mobileqq.activity.history;

import aeqq;
import ahec;
import ahyo;
import ahzr;
import ahzx;
import ahzy;
import aidt;
import aiei;
import aigf;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import arri;
import azqs;
import bdix;
import bhsl;
import bhtv;
import bhuf;
import bhus;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.widget.AbsListView;
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
  implements Handler.Callback, View.OnClickListener, bhtv
{
  public static final Pattern a;
  protected static final String b;
  private static int jdField_c_of_type_Int = 30;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 9223372036854775807L;
  ahec jdField_a_of_type_Ahec;
  public ahzr a;
  private aigf jdField_a_of_type_Aigf;
  public Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  ArrayList<Object> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private LinkedHashMap<String, List<MessageRecord>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  protected final MqqHandler a;
  int jdField_b_of_type_Int = 3;
  long jdField_b_of_type_Long = 9223372036854775807L;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public QQAppInterface b;
  long jdField_c_of_type_Long = 9223372036854775807L;
  String jdField_c_of_type_JavaLangString;
  long jdField_d_of_type_Long = 0L;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  
  static
  {
    jdField_b_of_type_JavaLangString = bdix.c.pattern() + "|" + bdix.d.pattern();
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile(jdField_b_of_type_JavaLangString, 2);
  }
  
  public ChatHistoryC2CLinkFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bhsl(Looper.getMainLooper(), this, true);
  }
  
  private List<ChatMessage> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Aidt.a();
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
  
  private void q()
  {
    if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ahzx(this);
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131376225));
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378988)).setText(getString(2131690776));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363522).setVisibility(8);
    EditText localEditText = (EditText)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365851);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(this);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (Build.VERSION.SDK_INT > 10)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayerType(0, null);
    }
  }
  
  public void a(List<ChatMessage> paramList)
  {
    Iterator localIterator;
    int i;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.removeAll(paramList);
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      paramList = null;
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = paramList;
      if (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if ((localObject2 instanceof String))
        {
          localObject1 = paramList;
          if (i == 0) {
            localObject1 = localObject2;
          }
          int j = i + 1;
          paramList = (List<ChatMessage>)localObject1;
          i = j;
          if (j != 2) {
            continue;
          }
        }
      }
      else
      {
        if (localObject1 != null)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(localObject1);
          this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(localObject1);
        }
        this.jdField_a_of_type_Ahzr.a(this.jdField_a_of_type_JavaUtilLinkedHashMap);
        arri.b(2131691570);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
        return;
      }
      paramList = null;
      i = 0;
    }
  }
  
  protected void b() {}
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    this.jdField_a_of_type_Ahzr.notifyDataSetChanged();
    if (paramBoolean) {
      azqs.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B1", "0X800A0B1", 4, 0, "", "", "", "");
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
    this.jdField_a_of_type_Aiei.a(localArrayList);
  }
  
  public void e()
  {
    super.e();
    if ((this.jdField_a_of_type_Ahzr != null) && (this.jdField_a_of_type_Ahzr.getCount() == 0)) {
      this.jdField_a_of_type_Ahyo.a(false);
    }
    azqs.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 5, 0, "", "", "", "");
  }
  
  public void f()
  {
    super.f();
    h();
    this.jdField_a_of_type_Ahzr.notifyDataSetChanged();
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_Ahec.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      this.jdField_a_of_type_Ahzr.a(this.jdField_a_of_type_JavaUtilLinkedHashMap);
      if (this.jdField_a_of_type_Ahzr.getCount() == 0)
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
    a((List)paramMessage.obj);
    return false;
  }
  
  protected void k()
  {
    super.k();
    c(getString(2131692630));
  }
  
  protected void l()
  {
    super.l();
    arri.a(2131692965);
  }
  
  protected void m()
  {
    super.m();
    List localList = a();
    if (localList.size() == 0) {
      arri.c(2131690780);
    }
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      if (localList != null) {
        localArrayList.addAll(localList);
      }
      this.jdField_a_of_type_Ahec.a(localArrayList);
      h();
      azqs.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B2", "0X800A0B2", 4, 0, "", "", "", "");
    }
  }
  
  protected void n()
  {
    super.n();
    if (a().size() > 0)
    {
      bhuf localbhuf = (bhuf)bhus.a(getActivity(), null);
      localbhuf.a(2131696570);
      localbhuf.a(getString(2131692486), 3);
      localbhuf.c(2131690648);
      localbhuf.a(new ahzy(this, localbhuf));
      localbhuf.show();
      return;
    }
    arri.c(2131690780);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while (l - this.jdField_d_of_type_Long <= 1000L);
    this.jdField_d_of_type_Long = l;
    p();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    this.jdField_c_of_type_JavaLangString = getActivity().getIntent().getStringExtra("uin");
    this.jdField_a_of_type_Int = getActivity().getIntent().getIntExtra("uintype", 0);
    this.jdField_d_of_type_JavaLangString = getActivity().getIntent().getStringExtra("uinname");
    q();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.inflate(2131558809, paramViewGroup, false));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131365760));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131377110));
    this.jdField_a_of_type_ComTencentWidgetXListView.setCacheColorHint(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_b_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131562677, null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
    a();
    c(true);
    this.jdField_a_of_type_Ahzr = new ahzr(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnClickListener, this, this.jdField_a_of_type_Aidt);
    this.jdField_a_of_type_Ahzr.a(this.jdField_a_of_type_JavaUtilLinkedHashMap);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahzr);
    this.jdField_a_of_type_Ahec = new ahec(getActivity(), 3);
    this.jdField_a_of_type_Ahec.a();
    return this.jdField_b_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      c(false);
      this.jdField_a_of_type_Ahzr.notifyDataSetChanged();
    }
  }
  
  void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    Bundle localBundle = getActivity().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = localBundle.getString("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = localBundle.getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aeqq = new aeqq();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(getActivity());
    this.jdField_a_of_type_Aigf = new aigf(getActivity(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Aigf.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Aigf.show();
    azqs.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 3, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment
 * JD-Core Version:    0.7.0.1
 */