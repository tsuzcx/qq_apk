package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.gameparty.GamePartyObserver;

class TroopTipsHelper$1
  extends GamePartyObserver
{
  TroopTipsHelper$1(TroopTipsHelper paramTroopTipsHelper) {}
  
  protected void a()
  {
    if (((GamePartyManager)this.a.d.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(this.a.g.a, this.a.g.b)) {
      this.a.c.c().a(this.a.b, new Object[0]);
    }
  }
  
  protected void b()
  {
    if (((GamePartyManager)this.a.d.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(this.a.g.a, this.a.g.b)) {
      this.a.b.d();
    }
  }
  
  protected void c()
  {
    if ((((GamePartyManager)this.a.d.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(this.a.g.a, this.a.g.b)) && (this.a.c.c().b() == 14)) {
      this.a.c.c().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopTipsHelper.1
 * JD-Core Version:    0.7.0.1
 */