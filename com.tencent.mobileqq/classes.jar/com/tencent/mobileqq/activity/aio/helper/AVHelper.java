package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;

public class AVHelper
  implements ILifeCycleHelper
{
  protected VideoStatusTipsBar a;
  private final AIOContext b;
  private final QQAppInterface c;
  private final BaseSessionInfo d;
  private final Context e;
  private AVObserver f;
  
  public AVHelper(AIOContext paramAIOContext)
  {
    this.b = paramAIOContext;
    this.c = paramAIOContext.a();
    this.d = paramAIOContext.O();
    this.e = paramAIOContext.b();
  }
  
  @NonNull
  public String getTag()
  {
    return "AVHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 1, 4, 10, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 10)
        {
          if (paramInt != 15) {
            return;
          }
          this.a = null;
          this.c.getAVNotifyCenter().deleteObserver(this.f);
          return;
        }
        if ((this.a == null) && (this.b.z().a(2)))
        {
          this.a = new VideoStatusTipsBar(this.c, this.d, this.b.c(), this.b.b(), this.b.g());
          this.b.c().b(this.a);
        }
      }
      else
      {
        this.c.getAVNotifyCenter().addObserver(this.f);
      }
    }
    else if (this.f == null) {
      this.f = new AVHelper.MyAVObserver(this, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVHelper
 * JD-Core Version:    0.7.0.1
 */