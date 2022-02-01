package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.C2BTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class StrangerQidianHelper
  implements ILifeCycleHelper
{
  QidianManager a;
  protected C2BTipsBar b;
  private final AIOContext c;
  private final QQAppInterface d;
  private final BaseSessionInfo e;
  
  public StrangerQidianHelper(AIOContext paramAIOContext)
  {
    this.c = paramAIOContext;
    this.e = paramAIOContext.O();
    this.d = paramAIOContext.a();
  }
  
  public QidianManager a()
  {
    if (this.a == null) {
      this.a = ((QidianManager)this.d.getManager(QQManagerFactory.QIDIAN_MANAGER));
    }
    return this.a;
  }
  
  public boolean a(boolean paramBoolean)
  {
    return this.a.b(this.e.b, paramBoolean);
  }
  
  public String b()
  {
    return this.a.a(this.c.b(), this.e.b);
  }
  
  public void c()
  {
    if (this.b == null)
    {
      this.b = new C2BTipsBar(this.c.b(), this.c.c());
      this.c.c().b(this.b);
    }
    this.b.a(this.e.b);
  }
  
  @NonNull
  public String getTag()
  {
    return "StrangerQidianHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    Object localObject;
    if (paramInt != 4)
    {
      localObject = "";
      QidianManager localQidianManager;
      if (paramInt != 9)
      {
        if (paramInt != 15) {
          return;
        }
        if ((this.a != null) && (this.e.a == 1025)) {
          this.a.a(this.e.b, this.e.a);
        }
        localQidianManager = this.a;
        if ((localQidianManager != null) && (localQidianManager.e(this.e.b))) {
          ((QidianHandler)this.d.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(null, this.e.b, false);
        }
        if (BmqqSegmentUtil.c(this.e.b))
        {
          localQidianManager = this.a;
          if (localQidianManager != null) {
            localObject = localQidianManager.h(this.e.b);
          }
          ReportController.b(this.d, "dc00899", "Qidian", this.e.b, "0X8009787", "CloseAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "8.8.17", "");
        }
      }
      else if (BmqqSegmentUtil.c(this.e.b))
      {
        c();
        localQidianManager = this.a;
        if (localQidianManager != null) {
          localObject = localQidianManager.h(this.e.b);
        }
        ReportController.b(this.d, "dc00899", "Qidian", this.e.b, "0X8009786", "EnterAIO", 1, 0, String.valueOf(NetConnInfoCenter.getServerTime()), (String)localObject, "8.8.17", "");
      }
    }
    else if (this.e.a == 1025)
    {
      localObject = this.c.b().getIntent().getByteArrayExtra("sigt");
      if (localObject != null)
      {
        this.d.getMsgCache().d(this.e.b, (byte[])localObject);
        if (QLog.isDevelopLevel()) {
          QLog.d("StrangerQidianHelper", 4, "updateSession()--AIO 已保存 sigt");
        }
      }
      if (a().a.containsKey(this.e.b)) {
        a().c(this.e.b, true);
      }
      if (a().e(this.e.b)) {
        ((FriendListHandler)this.d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.e.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.StrangerQidianHelper
 * JD-Core Version:    0.7.0.1
 */