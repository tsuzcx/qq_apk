package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class FriendTipsHelper
  extends TipsHelper
  implements Handler.Callback
{
  protected LightalkBlueTipsBar a = null;
  GamePartyTipsBar b;
  private Observer h = new FriendTipsHelper.2(this);
  
  public FriendTipsHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected void a()
  {
    super.a();
    if (this.a == null) {
      this.a = new LightalkBlueTipsBar(this.d, this.f, this.g, this.e);
    }
    this.b = new GamePartyTipsBar(this.d, this.f, this.e, this.g);
    this.f.b(this.a);
    this.f.b(this.b);
  }
  
  @NonNull
  public String getTag()
  {
    return "FriendTipsHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 38)
    {
      if (this.a == null) {
        this.a = new LightalkBlueTipsBar(this.d, this.f, this.g, this.e);
      }
      if (this.f.a(this.a, new Object[0]))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LightalkBlueTipsBar", 2, "BaseChatPie:handleMessage() : TYPE_ON_SHOW =====>");
        }
        ThreadManager.getSubThreadHandler().post(new FriendTipsHelper.1(this));
        ReportController.b(this.d, "CliOper", "", "", "0X800510F", "0X800510F", 0, 0, "1", "", "", "");
      }
      return true;
    }
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 10, 15 };
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FriendTipsHelper
 * JD-Core Version:    0.7.0.1
 */