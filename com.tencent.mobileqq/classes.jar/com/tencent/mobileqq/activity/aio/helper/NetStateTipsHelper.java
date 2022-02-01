package com.tencent.mobileqq.activity.aio.helper;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.NetStateTipsObserver;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.NetStateTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class NetStateTipsHelper
  implements ILifeCycleHelper
{
  private QQAppInterface a;
  private BaseActivity b;
  private AIOContext c;
  private NetStateTipsBar d;
  private NetStateTipsObserver e;
  
  public NetStateTipsHelper(AIOContext paramAIOContext)
  {
    this.c = paramAIOContext;
    this.a = paramAIOContext.a();
    this.b = paramAIOContext.b();
  }
  
  @NonNull
  public String getTag()
  {
    return "NetStateTipsHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 10)
    {
      if (paramInt != 15) {
        return;
      }
      this.d = null;
      this.a.unRegistObserver(this.e);
      this.e = null;
      return;
    }
    if (this.d == null)
    {
      TipsManager localTipsManager = this.c.c();
      this.d = new NetStateTipsBar(this.a, this.b, localTipsManager);
      this.e = new NetStateTipsObserver(this.c, this.d);
      this.a.registObserver(this.e);
      localTipsManager.b(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NetStateTipsHelper
 * JD-Core Version:    0.7.0.1
 */