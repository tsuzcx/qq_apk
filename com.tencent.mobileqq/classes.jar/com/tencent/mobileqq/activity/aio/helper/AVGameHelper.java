package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.tips.AVGameStatusTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class AVGameHelper
  implements ILifeCycleHelper
{
  public BaseActivity a;
  private final AIOContext b;
  private QQAppInterface c;
  private BaseSessionInfo d;
  private AVGameStatusTipsBar e;
  private AvGameRoomListObserver f = new AVGameHelper.1(this);
  
  public AVGameHelper(AIOContext paramAIOContext)
  {
    this.b = paramAIOContext;
    this.c = paramAIOContext.a();
    this.a = paramAIOContext.b();
    this.d = paramAIOContext.O();
  }
  
  public void a()
  {
    AVGameStatusTipsBar localAVGameStatusTipsBar = this.e;
    if (localAVGameStatusTipsBar != null) {
      localAVGameStatusTipsBar.d();
    }
  }
  
  public void a(TipsManager paramTipsManager)
  {
    if (paramTipsManager != null)
    {
      if (!this.b.z().a(2002)) {
        return;
      }
      if (this.e == null)
      {
        this.e = new AVGameStatusTipsBar(this.c, this.d, paramTipsManager, this.a);
        paramTipsManager.b(this.e);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = (IAvGameManager)this.c.getRuntimeService(IAvGameManager.class, "");
    if (localObject != null)
    {
      boolean bool = ((IAvGameManager)localObject).isAVGameOpen(this.d.b);
      if (bool) {
        ((IAvGameManager)localObject).requestGameRoomListForGroup(this.d.b, 0, 1);
      }
      if ((QLog.isColorLevel()) && (paramBoolean))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Enter AIO, troopUin :");
        ((StringBuilder)localObject).append(this.d.b);
        ((StringBuilder)localObject).append("isAVGameOpen is: ");
        ((StringBuilder)localObject).append(bool);
        QLog.d("AVGameHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public String getTag()
  {
    return "AVGameHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 10, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 7)
      {
        if (paramInt != 10)
        {
          if (paramInt != 15) {
            return;
          }
          this.e = null;
          this.c.removeObserver(this.f);
          return;
        }
        a(this.b.c());
        return;
      }
      a(true);
      return;
    }
    this.c.addObserver(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVGameHelper
 * JD-Core Version:    0.7.0.1
 */