package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
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
import com.tencent.mobileqq.app.BaseActivity;
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
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
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
  private SessionInfo A;
  private View B;
  private int C;
  private boolean D;
  private boolean E;
  private boolean F;
  private View G;
  SeparateForward s;
  protected final MqqHandler t = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  RelativeLayout u;
  private XListView v;
  private TroopLinkHandler w;
  private ArrayList<TroopLinkElement> x;
  private LinkAdapter y;
  private LinkMessageSearchDialog z;
  
  private void A()
  {
    this.y.b();
  }
  
  private List<ChatMessage> B()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.y.a().iterator();
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
      localObject = MessageRecordFactory.c(this.a, this.a.getCurrentUin(), localTroopLinkElement.uin, "0", 1, Long.parseLong(localTroopLinkElement.msgSeq), (AbsStructMsg)localObject);
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
    localSessionInfo.a = paramIntent.getIntExtra("uintype", 0);
    localSessionInfo.b = paramIntent.getStringExtra("uin");
    localSessionInfo.c = paramIntent.getStringExtra("troop_uin");
    ShareMsgHelper.a(this.a, localSessionInfo.b, localSessionInfo.a, localAbsStructMsg, null);
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
    this.y.a(paramBoolean);
    this.D = paramBoolean;
  }
  
  private void w()
  {
    this.x = new ArrayList();
    this.w = new TroopLinkHandler(this.a, this, this);
    this.w.a(this.e, false);
    this.s = new SeparateForward(getBaseActivity(), 3);
    this.s.a();
  }
  
  private void x()
  {
    this.v = ((XListView)this.f.findViewById(2131437262));
    this.y = new LinkAdapter(this.a, this.d, this);
    a();
    this.v.setAdapter(this.y);
    y();
    this.G = this.f.findViewById(2131432529);
  }
  
  private void y()
  {
    this.B = LayoutInflater.from(this.d).inflate(2131627871, null);
    this.v.addFooterView(this.B);
    this.B.setVisibility(8);
    this.v.setOnScrollListener(this);
  }
  
  private void z()
  {
    this.B.setVisibility(0);
    this.w.a(this.e, true);
  }
  
  void a()
  {
    this.u = ((RelativeLayout)this.f.findViewById(2131445390));
    ((TextView)this.u.findViewById(2131448724)).setText(getString(2131887731));
    this.u.findViewById(2131429816).setVisibility(8);
    EditText localEditText = (EditText)this.u.findViewById(2131432634);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setCursorVisible(false);
    localEditText.setOnClickListener(this);
    if ((this.u != null) && (Build.VERSION.SDK_INT > 10)) {
      this.u.setLayerType(0, null);
    }
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 21) {
        return;
      }
      a(paramIntent);
    }
  }
  
  public void a(boolean paramBoolean, @NonNull List<TroopLinkElement> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopLinkElement localTroopLinkElement = (TroopLinkElement)paramList.next();
      if (!FMConstants.a(localTroopLinkElement.url)) {
        this.x.add(localTroopLinkElement);
      }
    }
    paramList = a(this.x);
    this.y.a(paramList);
    if (this.y.getCount() == 0)
    {
      this.F = true;
      this.v.setEmptyView(this.G);
    }
  }
  
  void b()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    this.A = new SessionInfo();
    Bundle localBundle = getBaseActivity().getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.A.b = localBundle.getString("uin");
    this.A.a = localBundle.getInt("uintype");
    this.A.c = localBundle.getString("troop_uin");
    this.A.H = new ChatBackground();
    this.A.r = ChatTextSizeSettingActivity.a(getBaseActivity());
    this.z = new LinkMessageSearchDialog(getBaseActivity(), this.a, this.A, localMessageRoamManager.I());
    this.z.a(this.x);
    this.z.show();
  }
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    c(paramBoolean);
    A();
    if (paramBoolean) {
      ReportController.b(this.a, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 4, 0, "", "", "", "");
    }
  }
  
  protected void c() {}
  
  protected void d() {}
  
  protected void h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2));
    this.h.a(localArrayList);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void i()
  {
    super.i();
    if (this.F) {
      this.g.a(this, false);
    }
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 5, 0, "", "", "", "");
  }
  
  public void j()
  {
    super.j();
    m();
    this.y.a(false);
    this.y.notifyDataSetChanged();
  }
  
  public void k()
  {
    super.k();
    this.s.b();
  }
  
  protected int l()
  {
    return 1602;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131432634)
    {
      b();
      ReportController.b(this.a, "dc00898", "", "", "0X800A0BF", "0X800A0BF", 3, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131626671, paramViewGroup, false);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.C = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.C == this.y.getCount()) && (!this.E)) {
      z();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    x();
    w();
  }
  
  protected void p()
  {
    super.p();
    b(getString(2131889416));
  }
  
  protected void q()
  {
    super.q();
    b(getString(2131889420));
  }
  
  protected void r()
  {
    super.r();
    List localList = B();
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      if (localList != null) {
        localArrayList.addAll(localList);
      }
      this.s.a(localArrayList);
      m();
      ReportController.b(this.a, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 4, 0, "", "", "", "");
      return;
    }
    FMToastUtil.c(2131887735);
  }
  
  protected void s()
  {
    super.s();
    b(getString(2131889414));
  }
  
  public void v()
  {
    this.E = true;
    this.B.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopLinkFragment
 * JD-Core Version:    0.7.0.1
 */