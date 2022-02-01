package com.tencent.mobileqq.activity.aio.drawer;

import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.gamecenter.message.GameMsgAppContainer;
import com.tencent.qphone.base.util.QLog;

public class GameMsgAppDrawer
  extends BaseChatDrawer
{
  private GameMsgAppContainer h;
  
  public GameMsgAppDrawer(GameMsgChatPie paramGameMsgChatPie)
  {
    super(paramGameMsgChatPie);
  }
  
  protected View b()
  {
    this.h = new GameMsgAppDrawer.1(this, this.a, this.b, this.c, (GameMsgChatPie)this.e);
    this.h.a();
    return this.h.a();
  }
  
  public void c() {}
  
  public boolean h()
  {
    if ((this.h != null) && (d()))
    {
      this.h.e();
      return true;
    }
    return false;
  }
  
  public void i()
  {
    super.i();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onDrawerStartOpen");
    }
    GameMsgAppContainer localGameMsgAppContainer = this.h;
    if (localGameMsgAppContainer != null) {
      localGameMsgAppContainer.b();
    }
  }
  
  public void k()
  {
    super.k();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onDrawerOpened");
    }
    GameMsgAppContainer localGameMsgAppContainer = this.h;
    if (localGameMsgAppContainer != null) {
      localGameMsgAppContainer.c();
    }
  }
  
  public void l()
  {
    super.l();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onDrawerClosed");
    }
    GameMsgAppContainer localGameMsgAppContainer = this.h;
    if (localGameMsgAppContainer != null) {
      localGameMsgAppContainer.d();
    }
  }
  
  public void n()
  {
    GameMsgAppContainer localGameMsgAppContainer = this.h;
    if (localGameMsgAppContainer != null)
    {
      localGameMsgAppContainer.f();
      this.h = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.GameMsgAppDrawer
 * JD-Core Version:    0.7.0.1
 */