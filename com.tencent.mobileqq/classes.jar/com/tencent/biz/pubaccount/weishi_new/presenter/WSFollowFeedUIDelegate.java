package com.tencent.biz.pubaccount.weishi_new.presenter;

import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi_new.holder.WSPlayableHolder;
import com.tencent.biz.pubaccount.weishi_new.player.IWSPlayerUIDelegate;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSFollowFeedUIDelegate
  implements IWSPlayerUIDelegate
{
  private WSFollowFeedHolder a;
  private boolean b;
  
  private void a()
  {
    WSFollowFeedHolder localWSFollowFeedHolder = this.a;
    if ((localWSFollowFeedHolder != null) && (!this.b))
    {
      this.b = true;
      localWSFollowFeedHolder.c();
    }
  }
  
  public void a(WSPlayableHolder paramWSPlayableHolder)
  {
    if ((paramWSPlayableHolder instanceof WSFollowFeedHolder)) {
      this.a = ((WSFollowFeedHolder)paramWSPlayableHolder);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt, boolean paramBoolean) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, long paramLong1, long paramLong2)
  {
    if (paramLong1 > 2000L) {
      a();
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.a;
    if ((localObject != null) && (paramBoolean1) && (paramBoolean2)) {
      ((WSFollowFeedHolder)localObject).a(8, 400);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSFollowFeedUIDelegate.java][onPrePlayFinished] title:");
    ((StringBuilder)localObject).append(paramWSPlayerParam.c.g);
    ((StringBuilder)localObject).append("\nisPreOutputFirstFrame:");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(", isFirstFrameDrawSuccess:");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append("\nmFollowPlayableHolder:");
    ((StringBuilder)localObject).append(this.a);
    WSLog.e("WS_VIDEO_PRE_PLAY", ((StringBuilder)localObject).toString());
  }
  
  public void b(WSPlayerParam paramWSPlayerParam) {}
  
  public void c(WSPlayerParam paramWSPlayerParam)
  {
    if ((this.a != null) && (paramWSPlayerParam != null) && (paramWSPlayerParam.d != null))
    {
      boolean bool = paramWSPlayerParam.d.e();
      this.a.b(bool);
      paramWSPlayerParam = this.a;
      int i;
      if (bool) {
        i = 8;
      } else {
        i = 0;
      }
      paramWSPlayerParam.a(i, 0);
    }
    a();
  }
  
  public void d(WSPlayerParam paramWSPlayerParam)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((WSFollowFeedHolder)localObject).b(true);
      this.a.a(8, 400);
      this.a.c(true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSFollowFeedUIDelegate.java][onVideoStart] title:");
      ((StringBuilder)localObject).append(paramWSPlayerParam.c.g);
      WSLog.a("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
    }
  }
  
  public void e(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = this.a;
    if (paramWSPlayerParam != null)
    {
      paramWSPlayerParam.b(false);
      this.a.d(true);
    }
  }
  
  public void f(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = this.a;
    if (paramWSPlayerParam != null)
    {
      paramWSPlayerParam.b(true);
      this.a.d(false);
    }
  }
  
  public void g(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = this.a;
    if (paramWSPlayerParam != null)
    {
      paramWSPlayerParam.b(false);
      this.a.a(0, 0);
      this.a.c(false);
    }
    a();
  }
  
  public void h(WSPlayerParam paramWSPlayerParam) {}
  
  public void i(WSPlayerParam paramWSPlayerParam) {}
  
  public void j(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = this.a;
    if (paramWSPlayerParam != null) {
      paramWSPlayerParam.a(0, 100);
    }
  }
  
  public boolean k(WSPlayerParam paramWSPlayerParam)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowFeedUIDelegate
 * JD-Core Version:    0.7.0.1
 */