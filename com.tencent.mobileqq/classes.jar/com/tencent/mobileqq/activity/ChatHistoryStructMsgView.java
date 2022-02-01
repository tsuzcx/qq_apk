package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;
import mqq.os.MqqHandler;

public class ChatHistoryStructMsgView
  extends ChatHistoryViewBase
  implements Handler.Callback, AbsListView.OnScrollListener
{
  private static int v = 30;
  final String a = "ChatHistory_Struct";
  QQAppInterface b;
  Context c;
  XListView d;
  ChatHistoryStructAdapter e;
  boolean f = false;
  View.OnClickListener g;
  View.OnClickListener h;
  String i;
  int j;
  public String k;
  ArrayList<Object> l = new ArrayList();
  boolean m = false;
  long n = 9223372036854775807L;
  long o = 9223372036854775807L;
  long p = 9223372036854775807L;
  int q = 3;
  View r;
  protected final MqqHandler s = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private RelativeLayout t;
  private TextView u;
  
  private void c()
  {
    if (this.h != null) {
      return;
    }
    this.h = new ChatHistoryStructMsgView.1(this);
  }
  
  public View a()
  {
    return this.t;
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.b = paramQQAppInterface;
    this.c = paramContext;
    this.i = paramIntent.getStringExtra("uin");
    this.j = paramIntent.getIntExtra("uintype", 0);
    this.k = paramIntent.getStringExtra("uinname");
    c();
    this.t = ((RelativeLayout)View.inflate(this.c, 2131629322, null));
    this.u = ((TextView)this.t.findViewById(2131432529));
    this.u.setVisibility(0);
    this.d = ((XListView)this.t.findViewById(2131446442));
    this.d.setCacheColorHint(0);
    this.d.setOnScrollListener(this);
    this.r = View.inflate(this.c, 2131629321, null);
    this.r.setVisibility(0);
    this.d.addFooterView(this.r);
    a(true);
    this.e = new ChatHistoryStructAdapter(this.c, (ArrayList)this.l.clone(), this.h, this.g, this);
    this.d.setAdapter(this.e);
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.l.removeAll(paramList);
      Iterator localIterator = this.l.iterator();
      paramList = null;
      int i1 = 0;
      Object localObject1;
      int i2;
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
        if (i1 == 0) {
          localObject1 = localObject2;
        }
        i2 = i1 + 1;
        i1 = i2;
        paramList = (List<ChatMessage>)localObject1;
      } while (i2 != 2);
      label90:
      if (localObject1 != null) {
        this.l.remove(localObject1);
      }
      this.s.sendEmptyMessage(1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.post(new ChatHistoryStructMsgView.2(this, paramBoolean), 10, null, true);
  }
  
  public void g()
  {
    this.f = true;
    this.e.notifyDataSetChanged();
  }
  
  public void h()
  {
    this.f = false;
    this.e.notifyDataSetChanged();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    if (this.l.isEmpty())
    {
      this.u.setVisibility(0);
      this.d.setVisibility(4);
    }
    else
    {
      this.u.setVisibility(8);
      this.r.setVisibility(8);
      this.d.setVisibility(0);
      this.e.c = ((ArrayList)this.l.clone());
    }
    this.e.notifyDataSetChanged();
    return false;
  }
  
  public boolean i()
  {
    return this.f;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (!this.m))
    {
      this.r.setVisibility(0);
      a(false);
      this.e.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryStructMsgView
 * JD-Core Version:    0.7.0.1
 */