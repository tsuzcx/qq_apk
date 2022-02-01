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
  private static int R = 30;
  protected static final String s;
  public static final Pattern t;
  String A;
  int B;
  public String C;
  ArrayList<Object> D = new ArrayList();
  boolean E = false;
  long F = 9223372036854775807L;
  long G = 9223372036854775807L;
  long H = 9223372036854775807L;
  int I = 3;
  View J;
  protected final MqqHandler K = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  long L = 0L;
  SeparateForward M;
  RelativeLayout N;
  private LinkedHashMap<String, List<MessageRecord>> O = new LinkedHashMap();
  private RelativeLayout P;
  private TextView Q;
  private SessionInfo S;
  private C2CLinkMessageSearchDialog T;
  QQAppInterface u;
  Context v;
  XListView w;
  ChatHistoryC2CLinkAdapter x;
  View.OnClickListener y;
  View.OnClickListener z;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Patterns.c.pattern());
    localStringBuilder.append("|");
    localStringBuilder.append(Patterns.d.pattern());
    s = localStringBuilder.toString();
    t = Pattern.compile(s, 2);
  }
  
  private void w()
  {
    if (this.z != null) {
      return;
    }
    this.z = new ChatHistoryC2CLinkFragment.1(this);
  }
  
  private List<ChatMessage> x()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.j.b();
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
  
  void a()
  {
    this.N = ((RelativeLayout)this.P.findViewById(2131445390));
    ((TextView)this.N.findViewById(2131448724)).setText(getString(2131887731));
    this.N.findViewById(2131429816).setVisibility(8);
    EditText localEditText = (EditText)this.N.findViewById(2131432634);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(this);
    if ((this.N != null) && (Build.VERSION.SDK_INT > 10)) {
      this.N.setLayerType(0, null);
    }
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.D.removeAll(paramList);
      Iterator localIterator = this.D.iterator();
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
        this.D.remove(localObject1);
        this.O.remove(localObject1);
      }
      this.x.a(this.O);
      FMToastUtil.b(2131888446);
      this.K.sendEmptyMessage(1);
    }
  }
  
  void b()
  {
    this.S = new SessionInfo();
    Bundle localBundle = getBaseActivity().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.S.b = localBundle.getString("uin");
    this.S.a = localBundle.getInt("uintype");
    this.S.H = new ChatBackground();
    this.S.r = ChatTextSizeSettingActivity.a(getBaseActivity());
    this.T = new C2CLinkMessageSearchDialog(getBaseActivity(), this.u, this.S);
    this.T.a(this.D);
    this.T.show();
    ReportController.b(this.u, "dc00898", "", "", "0X800A0B6", "0X800A0B6", 3, 0, "", "", "", "");
  }
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    this.x.notifyDataSetChanged();
    if (paramBoolean) {
      ReportController.b(this.u, "dc00898", "", "", "0X800A0B1", "0X800A0B1", 4, 0, "", "", "", "");
    }
  }
  
  protected void c() {}
  
  public void c(boolean paramBoolean)
  {
    ThreadManager.post(new ChatHistoryC2CLinkFragment.2(this, paramBoolean), 10, null, true);
  }
  
  protected void d() {}
  
  protected void h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(4));
    this.h.a(localArrayList);
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
    this.x.a(this.O);
    if (this.x.getCount() == 0)
    {
      this.Q.setVisibility(0);
      this.w.setVisibility(4);
      return false;
    }
    this.Q.setVisibility(8);
    this.J.setVisibility(8);
    this.w.setVisibility(0);
    return false;
  }
  
  public void i()
  {
    super.i();
    ChatHistoryC2CLinkAdapter localChatHistoryC2CLinkAdapter = this.x;
    if ((localChatHistoryC2CLinkAdapter != null) && (localChatHistoryC2CLinkAdapter.getCount() == 0)) {
      this.g.a(this, false);
    }
    ReportController.b(this.u, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 5, 0, "", "", "", "");
  }
  
  public void j()
  {
    super.j();
    m();
    this.x.notifyDataSetChanged();
  }
  
  public void k()
  {
    super.k();
    this.M.b();
  }
  
  protected int l()
  {
    return 1602;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131432634)
    {
      long l = System.currentTimeMillis();
      if (l - this.L > 1000L)
      {
        this.L = l;
        b();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.u = getBaseActivity().app;
    this.v = getBaseActivity();
    this.A = getBaseActivity().getIntent().getStringExtra("uin");
    this.B = getBaseActivity().getIntent().getIntExtra("uintype", 0);
    this.C = getBaseActivity().getIntent().getStringExtra("uinname");
    w();
    this.P = ((RelativeLayout)paramLayoutInflater.inflate(2131624474, paramViewGroup, false));
    this.Q = ((TextView)this.P.findViewById(2131432529));
    this.Q.setVisibility(0);
    this.w = ((XListView)this.P.findViewById(2131446442));
    this.w.setCacheColorHint(0);
    this.w.setOnScrollListener(this);
    this.J = View.inflate(this.v, 2131629321, null);
    this.J.setVisibility(0);
    this.w.addFooterView(this.J);
    a();
    c(true);
    this.x = new ChatHistoryC2CLinkAdapter(this.u, this.v, this.z, this.y, this, this.j);
    this.x.a(this.O);
    this.w.setAdapter(this.x);
    this.M = new SeparateForward(getBaseActivity(), 3);
    this.M.a();
    paramLayoutInflater = this.P;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (!this.E))
    {
      this.J.setVisibility(0);
      c(false);
      this.x.notifyDataSetChanged();
    }
  }
  
  protected void p()
  {
    super.p();
    b(getString(2131889416));
  }
  
  protected void q()
  {
    super.q();
    FMToastUtil.a(2131889814);
  }
  
  protected void r()
  {
    super.r();
    List localList = x();
    if (localList.size() == 0) {
      FMToastUtil.c(2131887735);
    }
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      if (localList != null) {
        localArrayList.addAll(localList);
      }
      this.M.a(localArrayList);
      m();
      ReportController.b(this.u, "dc00898", "", "", "0X800A0B2", "0X800A0B2", 4, 0, "", "", "", "");
    }
  }
  
  protected void s()
  {
    super.s();
    if (x().size() > 0)
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
      localActionSheet.setMainTitle(2131893858);
      localActionSheet.addButton(getString(2131889261), 3);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new ChatHistoryC2CLinkFragment.3(this, localActionSheet));
      localActionSheet.show();
      return;
    }
    FMToastUtil.c(2131887735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment
 * JD-Core Version:    0.7.0.1
 */