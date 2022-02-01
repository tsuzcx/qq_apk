package com.tencent.mobileqq.activity.aio.helper;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class FraudHelper
  implements ILifeCycleHelper
{
  private final AIOContext a;
  private FraudTipsBar b;
  private final FriendListObserver c = new FraudHelper.1(this);
  
  public FraudHelper(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
  }
  
  @NonNull
  public String getTag()
  {
    return "FraudHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 10, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 10)
      {
        if (paramInt != 15) {
          return;
        }
        this.b = null;
        this.a.a().removeObserver(this.c);
        return;
      }
      if ((this.b == null) && (this.a.z().a(0)))
      {
        this.b = new FraudTipsBar(this.a.a(), this.a.c(), this.a.a().getApp(), this.a.O(), this.a.g());
        this.a.c().b(this.b);
      }
    }
    else
    {
      this.a.a().addObserver(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FraudHelper
 * JD-Core Version:    0.7.0.1
 */