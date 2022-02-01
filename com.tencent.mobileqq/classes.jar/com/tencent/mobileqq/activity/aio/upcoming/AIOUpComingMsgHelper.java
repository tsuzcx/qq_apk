package com.tencent.mobileqq.activity.aio.upcoming;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.FriendScroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.colornote.ColorNoteCurd;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AIOUpComingMsgHelper
  implements Handler.Callback, ILifeCycleHelper
{
  private ColorNoteCurd a;
  private MultiColorNoteGenerator b;
  private BaseChatPie c;
  private QQAppInterface d;
  private SessionInfo e;
  private long f = -1L;
  private MqqHandler g;
  private UpcomingTimeSelector h;
  private MessageRecord i;
  private boolean j = false;
  private MessageRecord k;
  private MessageObserver l = new AIOUpComingMsgHelper.2(this);
  private OnColorNoteCurdListener m = new AIOUpComingMsgHelper.5(this);
  
  public AIOUpComingMsgHelper(BaseChatPie paramBaseChatPie)
  {
    this.d = paramBaseChatPie.d;
    this.c = paramBaseChatPie;
    this.e = paramBaseChatPie.ah;
    this.g = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void a()
  {
    this.j = true;
    g();
  }
  
  private void a(String paramString)
  {
    if (this.e.a == 1)
    {
      Object localObject = ((HotChatManager)this.d.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(paramString);
      Message localMessage = this.g.obtainMessage();
      localMessage.what = 2;
      if (localObject != null)
      {
        if (((HotChatInfo)localObject).state == 6) {
          localMessage.obj = this.c.aX().getResources().getString(2131886618);
        } else if (((HotChatInfo)localObject).state == 7) {
          localMessage.obj = this.c.aX().getResources().getString(2131886624);
        }
      }
      else
      {
        localObject = (TroopManager)this.d.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("");
          paramString = ((TroopManager)localObject).b(localStringBuilder.toString(), true);
          if (paramString != null)
          {
            if ((!paramString.isKicked()) && (!paramString.isExited()))
            {
              if (paramString.isDisband()) {
                localMessage.obj = this.c.aX().getResources().getString(2131886624);
              }
            }
            else {
              localMessage.obj = this.c.aX().getResources().getString(2131886618);
            }
          }
          else {
            localMessage.obj = this.c.aX().getResources().getString(2131886618);
          }
        }
      }
      if (localMessage.obj != null) {
        this.g.sendMessage(localMessage);
      }
    }
  }
  
  private void b()
  {
    MqqHandler localMqqHandler = this.g;
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(AIOUpComingMsgHelper.class);
    }
    this.d.removeObserver(this.l);
  }
  
  private void c()
  {
    Intent localIntent = this.c.aX().getIntent();
    if (localIntent != null) {
      this.f = localIntent.getLongExtra("key_uniseq", -1L);
    }
    this.d.addObserver(this.l);
    this.i = null;
  }
  
  private void d()
  {
    this.j = false;
    if (this.f != -1L)
    {
      this.c.a(false, null, false, false, true);
      long l1 = this.f;
      this.f = -1L;
      ThreadManager.getSubThreadHandler().postAtTime(new AIOUpComingMsgHelper.1(this, l1), AIOUpComingMsgHelper.class, 0L);
    }
  }
  
  private void d(List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      if (this.i != null)
      {
        ArrayList localArrayList = new ArrayList();
        if (1 == paramInt)
        {
          if (this.i.uniseq != ((MessageRecord)paramList.get(0)).uniseq) {
            localArrayList.add(paramList.get(0));
          }
        }
        else
        {
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
            if (this.i.uniseq != localMessageRecord.uniseq) {
              localArrayList.add(paramList.get(0));
            }
          }
        }
        if (!localArrayList.isEmpty())
        {
          a(paramList, paramLong, paramInt);
          return;
        }
        QQToast.makeText(this.c.aX(), 1, 2131886601, 0).show();
        return;
      }
      a(paramList, paramLong, paramInt);
    }
  }
  
  private void e()
  {
    if (this.h == null) {
      this.h = new UpcomingTimeSelector(this.c.aX());
    }
  }
  
  private void f()
  {
    if (this.a == null)
    {
      this.a = new ColorNoteCurd();
      this.a.a(this.m);
    }
  }
  
  private void g()
  {
    if ((this.k != null) && (this.j))
    {
      Object localObject = this.c;
      if ((localObject instanceof FriendChatPie))
      {
        ((FriendScroller)((BaseChatPie)localObject).bv().e().d()).a(22, this.k.msgUid, this.k.time);
      }
      else if (((BaseChatPie)localObject).ab())
      {
        localObject = this.d.getMessageFacade().getLastMessage(this.e.b, this.e.a);
        this.c.bv().e().d().a(22, this.k.shmsgseq, (int)(((MessageRecord)localObject).shmsgseq - this.k.shmsgseq));
      }
      this.j = false;
      this.k = null;
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    QLog.d("UpComingMsgLogic.AIOUpComingMsgHelper", 4, paramChatMessage.toString());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramChatMessage);
    e();
    this.h.a(1);
    this.h.a(new AIOUpComingMsgHelper.3(this, localArrayList));
    int n = UpComingMsgUtil.b(paramChatMessage);
    ReportController.b(this.d, "dc00898", "", "", "0X800AE7D", "0X800AE7D", n, 0, "", "", "", "");
  }
  
  public void a(List<ChatMessage> paramList)
  {
    if (!NetworkUtil.isNetSupport(this.c.aX()))
    {
      QQToast.makeText(this.d.getApp(), 2131889169, 0).show(this.c.A());
      return;
    }
    Object localObject1 = MultiMsgUtil.a(this.d, (ArrayList)paramList);
    if (localObject1 != null)
    {
      if (((ArrayList)localObject1).size() == 0) {
        return;
      }
      MultiMsgManager.a().b((List)localObject1);
      if (QLog.isDevelopLevel())
      {
        paramList = new StringBuilder();
        paramList.append("multiForwardTogether|checklist.size = ");
        paramList.append(((ArrayList)localObject1).size());
        QLog.d("MultiMsg_TAG", 4, paramList.toString());
      }
      if (((ArrayList)localObject1).size() == 0) {
        return;
      }
      this.c.e(2131896471);
      paramList = new ArrayList();
      Object localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = MsgProxyUtils.d((ChatMessage)((Iterator)localObject2).next());
        if (!paramList.contains(str)) {
          paramList.add(str);
        }
      }
      MultiMsgManager.a().c.clear();
      MultiMsgManager.a().c.addAll((Collection)localObject1);
      MultiMsgManager.a().e = 0;
      if (this.e.a == 1) {
        ((ITroopMemberInfoHandler)this.d.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER)).a(this.e.b, paramList, false, null);
      } else if ((this.e.a == 0) || (this.e.a == 3000) || (this.e.a == 1000) || (this.e.a == 1004)) {
        ((FriendListHandler)this.d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendNickByBatch(paramList);
      }
      localObject1 = this.c.j();
      localObject2 = ((MqqHandler)localObject1).obtainMessage(24);
      ((Message)localObject2).arg1 = paramList.size();
      ((MqqHandler)localObject1).sendMessageDelayed((Message)localObject2, 30000L);
    }
  }
  
  public void a(List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    f();
    this.a.a(0, "update_process_state", false);
    if (!this.a.b())
    {
      ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).showFullDialog(this.c.aX());
      return;
    }
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      f();
      try
      {
        paramList = c(paramList, paramLong, paramInt);
        if (paramList != null)
        {
          paramList = paramList.parseBundle();
          this.a.a(paramList);
          return;
        }
      }
      catch (IllegalAccessException paramList)
      {
        QLog.e("UpComingMsgLogic.AIOUpComingMsgHelper", 1, "addColorNote occur error.", paramList);
      }
    }
  }
  
  public void b(List<ChatMessage> paramList, long paramLong, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    e();
    this.h.a(2);
    this.h.a(new AIOUpComingMsgHelper.4(this, localArrayList, paramList));
    ReportController.b(this.d, "dc00898", "", "", "0X800AE7E", "0X800AE7E", paramList.size(), 0, "", "", "", "");
  }
  
  ColorNote c(List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
      if (this.b == null) {
        this.b = new MultiColorNoteGenerator(this.d);
      }
      return this.b.a(paramList, paramLong, 2, this.e);
    }
    if (this.b == null) {
      this.b = new MultiColorNoteGenerator(this.d);
    }
    return this.b.a(paramList, paramLong, 1, this.e);
  }
  
  public String getTag()
  {
    return "UpComingMsgLogic.AIOUpComingMsgHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int n = paramMessage.what;
    if (n != 1)
    {
      if (n != 2) {
        return true;
      }
      if (this.c.p != null) {
        this.c.p.setRightRootVisibility(4);
      }
      QQToast.makeText(this.c.aX(), (String)paramMessage.obj, 0).show(this.c.aX().getTitleBarHeight());
      return true;
    }
    ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(AIOUpComingMsgHelper.class);
    this.k = ((MessageRecord)paramMessage.obj);
    if (this.k == null)
    {
      QQToast.makeText(this.c.aX(), 2131895472, 0).show(this.c.aX().getTitleBarHeight());
      return true;
    }
    g();
    return true;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15, 7, 9 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 7)
      {
        if (paramInt != 9)
        {
          if (paramInt != 15) {
            return;
          }
          b();
          return;
        }
        a();
        return;
      }
      d();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper
 * JD-Core Version:    0.7.0.1
 */