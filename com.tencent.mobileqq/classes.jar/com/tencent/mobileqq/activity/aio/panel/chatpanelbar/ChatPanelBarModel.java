package com.tencent.mobileqq.activity.aio.panel.chatpanelbar;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.bizstatus.RedBagShowData;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.UpdateParams;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.ChatPanelBarLoaderFactory;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.loader.IChatPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.C2CPanelBarLoader;
import com.tencent.mobileqq.activity.aio.rebuild.chatpanelbar.loader.GroupPanelBarLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatPanelBarModel
  implements IChatPanelBarData
{
  private static RedBagShowData b = new RedBagShowData();
  IChatPanelBarLoader a;
  private Context c;
  private SessionInfo d;
  private QQAppInterface e;
  private ChatPanelBarLoaderFactory f;
  private int g;
  private boolean h;
  private boolean i;
  private boolean j;
  private Map<int[], int[]> k = new HashMap();
  private Map<int[], int[]> l = new HashMap();
  private ArrayList<int[]> m = new ArrayList();
  
  private void c(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.a = this.f.a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  private void l()
  {
    this.l.put(AIOPanelUtiles.f, AIOPanelUtiles.j);
    this.l.put(AIOPanelUtiles.g, AIOPanelUtiles.k);
    this.l.put(AIOPanelUtiles.h, AIOPanelUtiles.l);
    this.l.put(AIOPanelUtiles.m, AIOPanelUtiles.q);
    this.l.put(AIOPanelUtiles.n, AIOPanelUtiles.r);
    this.l.put(AIOPanelUtiles.o, AIOPanelUtiles.s);
    this.k.put(AIOPanelUtiles.j, AIOPanelUtiles.f);
    this.k.put(AIOPanelUtiles.k, AIOPanelUtiles.g);
    this.k.put(AIOPanelUtiles.l, AIOPanelUtiles.h);
    this.k.put(AIOPanelUtiles.q, AIOPanelUtiles.m);
    this.k.put(AIOPanelUtiles.r, AIOPanelUtiles.n);
    this.k.put(AIOPanelUtiles.s, AIOPanelUtiles.o);
  }
  
  public List<AIOPanelIconItem> a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if (!this.a.f(paramQQAppInterface, paramSessionInfo, paramBaseChatPie)) {
      c(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
    }
    return this.a.d(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  public void a(ChatPanelBarContext paramChatPanelBarContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, Context paramContext)
  {
    this.e = paramQQAppInterface;
    this.d = paramSessionInfo;
    this.c = paramContext;
    this.f = new ChatPanelBarLoaderFactory(paramChatPanelBarContext);
    this.a = this.f.a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
    this.m = ((ArrayList)this.a.e(paramQQAppInterface, paramSessionInfo, paramBaseChatPie));
    l();
  }
  
  public void a(UpdateParams paramUpdateParams)
  {
    if (paramUpdateParams == null) {
      return;
    }
    this.h = paramUpdateParams.c;
    this.j = paramUpdateParams.b;
    this.i = paramUpdateParams.a;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a()
  {
    return this.j;
  }
  
  public int[] a(int[] paramArrayOfInt)
  {
    return (int[])this.l.get(paramArrayOfInt);
  }
  
  public String b()
  {
    return this.d.b;
  }
  
  public List<int[]> b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    if (!this.a.f(paramQQAppInterface, paramSessionInfo, paramBaseChatPie)) {
      c(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
    }
    return this.a.e(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  public int[] b(int[] paramArrayOfInt)
  {
    return (int[])this.k.get(paramArrayOfInt);
  }
  
  public boolean c()
  {
    return this.a instanceof GroupPanelBarLoader;
  }
  
  public boolean d()
  {
    return this.a instanceof C2CPanelBarLoader;
  }
  
  public QQAppInterface e()
  {
    return this.e;
  }
  
  public RedBagShowData f()
  {
    return b;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public SessionInfo h()
  {
    return this.d;
  }
  
  public boolean i()
  {
    return this.h;
  }
  
  public Context j()
  {
    return this.c;
  }
  
  public boolean k()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarModel
 * JD-Core Version:    0.7.0.1
 */