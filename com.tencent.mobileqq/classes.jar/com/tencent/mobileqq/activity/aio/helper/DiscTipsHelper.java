package com.tencent.mobileqq.activity.aio.helper;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.DiscActiveTipsBar;
import com.tencent.mobileqq.activity.aio.tips.DiscFreqPttGrayTips;
import com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import java.util.Observable;
import java.util.Observer;

public class DiscTipsHelper
  extends TipsHelper
{
  GamePartyTipsBar a;
  private Observer b = new DiscTipsHelper.1(this);
  
  public DiscTipsHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected void a()
  {
    super.a();
    DiscActiveTipsBar localDiscActiveTipsBar = new DiscActiveTipsBar(this.c);
    DiscFreqPttGrayTips localDiscFreqPttGrayTips = new DiscFreqPttGrayTips(this.c);
    this.a = new GamePartyTipsBar(this.d, this.f, this.e, this.g);
    this.f.b(localDiscActiveTipsBar);
    this.f.b(localDiscFreqPttGrayTips);
    this.f.b(this.a);
  }
  
  @NonNull
  public String getTag()
  {
    return "DiscTipsHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10, 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    super.onMoveToState(paramInt);
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      ((GamePartyManager)this.d.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a().deleteObserver(this.b);
      return;
    }
    ((GamePartyManager)this.d.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a().addObserver(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.DiscTipsHelper
 * JD-Core Version:    0.7.0.1
 */