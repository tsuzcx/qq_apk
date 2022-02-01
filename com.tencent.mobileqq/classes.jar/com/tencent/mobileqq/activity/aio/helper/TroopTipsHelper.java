package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.tips.IMsgTipsListener;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import java.util.Observable;
import java.util.Observer;

public class TroopTipsHelper
  extends TipsHelper
  implements IMsgTipsListener, OnActivityResultCallback
{
  TroopAssistTipsBar a;
  GamePartyTipsBar b;
  private final Observer h = new TroopTipsHelper.1(this);
  
  public TroopTipsHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected void a()
  {
    super.a();
    if (this.c.z().a(3))
    {
      this.a = new TroopAssistTipsBar(this.d, this.f, this.e, this.g, this.c.G());
      this.f.b(this.a);
    }
    if (this.c.z().a(14))
    {
      this.b = new GamePartyTipsBar(this.d, this.f, this.e, this.g);
      this.f.b(this.b);
    }
  }
  
  public void a(AIOContext paramAIOContext)
  {
    if (c()) {
      this.f.c();
    }
  }
  
  public void a(AIOContext paramAIOContext, Message paramMessage) {}
  
  public void b()
  {
    TroopAssistTipsBar localTroopAssistTipsBar = this.a;
    if (localTroopAssistTipsBar != null) {
      localTroopAssistTipsBar.e();
    }
  }
  
  public boolean c()
  {
    TroopAssistTipsBar localTroopAssistTipsBar = this.a;
    return (localTroopAssistTipsBar != null) && (localTroopAssistTipsBar.d());
  }
  
  @NonNull
  public String getTag()
  {
    return "TroopTipsHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10, 4, 15 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2000)
    {
      paramIntent = this.a;
      if ((paramIntent != null) && (paramIntent.d()) && (TroopAssistantManager.a().c(this.d, this.g.b))) {
        this.f.c();
      }
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    super.onMoveToState(paramInt);
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      ((GamePartyManager)this.d.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a().deleteObserver(this.h);
      return;
    }
    ((GamePartyManager)this.d.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a().addObserver(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopTipsHelper
 * JD-Core Version:    0.7.0.1
 */