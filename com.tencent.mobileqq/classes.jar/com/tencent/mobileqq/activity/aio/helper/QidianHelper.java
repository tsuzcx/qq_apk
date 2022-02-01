package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.activity.aio.tips.C2BTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianHandler;
import java.util.Map;

public class QidianHelper
  implements ILifeCycleHelper
{
  public QidianManager a;
  protected C2BTipsBar b;
  private final FriendChatPie c;
  private final AIOContext d;
  private final BaseSessionInfo e;
  private final QQAppInterface f;
  
  public QidianHelper(FriendChatPie paramFriendChatPie)
  {
    this.c = paramFriendChatPie;
    this.d = paramFriendChatPie.bv();
    this.f = this.d.a();
    this.e = this.d.O();
    if (this.d.a().isCreateManager(QQManagerFactory.QIDIAN_MANAGER)) {
      this.a = ((QidianManager)this.d.a().getManager(QQManagerFactory.QIDIAN_MANAGER));
    }
  }
  
  public String a()
  {
    QidianManager localQidianManager = this.a;
    if (localQidianManager == null) {
      return null;
    }
    return localQidianManager.a(this.d.b(), this.e.b);
  }
  
  public boolean a(boolean paramBoolean)
  {
    QidianManager localQidianManager = this.a;
    return (localQidianManager != null) && (localQidianManager.b(this.e.b, paramBoolean));
  }
  
  public void b()
  {
    if (this.b == null)
    {
      this.b = new C2BTipsBar(this.d.b(), this.d.c());
      this.d.c().b(this.b);
    }
    this.b.a(this.e.b);
  }
  
  public String getTag()
  {
    return "QidianHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    Object localObject1;
    if (paramInt != 4)
    {
      localObject1 = "";
      Object localObject2;
      if (paramInt != 9)
      {
        if (paramInt != 15) {
          return;
        }
        localObject2 = this.d.O();
        if ((this.a != null) && ((((BaseSessionInfo)localObject2).a == 1024) || (this.a.e(((BaseSessionInfo)localObject2).b)))) {
          this.a.a(((BaseSessionInfo)localObject2).b, ((BaseSessionInfo)localObject2).a);
        }
        QidianManager localQidianManager = this.a;
        if ((localQidianManager != null) && (localQidianManager.e(((BaseSessionInfo)localObject2).b))) {
          ((QidianHandler)this.f.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(null, ((BaseSessionInfo)localObject2).b, false);
        }
        if (((this.c instanceof BusinessCmrTmpChatPie)) || (BmqqSegmentUtil.c(((BaseSessionInfo)localObject2).b)))
        {
          localQidianManager = this.a;
          if (localQidianManager != null) {
            localObject1 = localQidianManager.h(((BaseSessionInfo)localObject2).b);
          }
          ReportController.b(this.d.a(), "dc00899", "Qidian", ((BaseSessionInfo)localObject2).b, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject1, "8.8.17", "");
        }
      }
      else
      {
        if (BmqqSegmentUtil.c(this.e.b)) {
          this.a = ((QidianManager)this.f.getManager(QQManagerFactory.QIDIAN_MANAGER));
        }
        if (((this.c instanceof BusinessCmrTmpChatPie)) || (BmqqSegmentUtil.c(this.e.b)))
        {
          b();
          localObject2 = this.a;
          if (localObject2 != null) {
            localObject1 = ((QidianManager)localObject2).h(this.d.O().b);
          }
          ReportController.b(this.f, "dc00899", "Qidian", this.e.b, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject1, "8.8.17", "");
        }
      }
    }
    else
    {
      localObject1 = this.a;
      if ((localObject1 != null) && (((QidianManager)localObject1).a.containsKey(this.e.b))) {
        this.a.c(this.e.b, true);
      }
      localObject1 = this.a;
      if ((localObject1 != null) && (((QidianManager)localObject1).e(this.e.b)))
      {
        CrmUtils.c(this.f, this.d.b(), this.f.getCurrentAccountUin(), this.e.b);
        ((FriendListHandler)this.f.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.e.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QidianHelper
 * JD-Core Version:    0.7.0.1
 */