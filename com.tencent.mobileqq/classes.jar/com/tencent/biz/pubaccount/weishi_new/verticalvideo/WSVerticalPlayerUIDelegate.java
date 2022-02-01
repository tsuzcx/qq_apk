package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.player.IWSPlayerUIDelegate;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.guide.WSCommentAtHelper;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomCollectionController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoAreaController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoOperationRightItemView;

public class WSVerticalPlayerUIDelegate
  implements IWSPlayerUIDelegate
{
  private WSVerticalItemVideoAreaController a;
  private WSVerticalItemVideoProgressController b;
  private WSVerticalItemBottomCollectionController c;
  private WSVerticalVideoOperationRightItemView d;
  private WSVerticalVideoHolder e;
  
  private WSPlayerManager a()
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = this.e;
    if ((localWSVerticalVideoHolder != null) && (localWSVerticalVideoHolder.d != null)) {
      return this.e.d.e();
    }
    return null;
  }
  
  private void a(long paramLong, float paramFloat)
  {
    Object localObject = this.d;
    if ((localObject != null) && (!((WSVerticalVideoOperationRightItemView)localObject).o()) && (WSCommentAtHelper.a.a(paramFloat, paramLong)))
    {
      this.d.p();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSVerticalPlayerUIDelegate.java][playAtGuideAnimation] pos:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", progress:");
      ((StringBuilder)localObject).append(paramFloat);
      WSLog.d("WSVerticalPlayerUIDelegateLog", ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString)
  {
    paramWSPlayerParam = this.a;
    if (paramWSPlayerParam != null)
    {
      paramWSPlayerParam.p();
      this.a.a(paramString);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt, boolean paramBoolean) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, long paramLong1, long paramLong2)
  {
    paramWSPlayerParam = this.b;
    if ((paramWSPlayerParam != null) && (!paramWSPlayerParam.p()))
    {
      float f = 0.0F;
      if (paramLong2 == 0L)
      {
        this.b.a(0.0F);
      }
      else
      {
        f = (float)paramLong1 / (float)paramLong2;
        this.b.a(f);
      }
      paramWSPlayerParam = this.c;
      if ((paramWSPlayerParam != null) && ((paramLong1 > paramWSPlayerParam.n()) || (100.0F * f > this.c.o()))) {
        this.c.l();
      }
      a(paramLong1, f);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    if (this.b != null)
    {
      WSLog.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoInitiate() show");
      this.b.m();
      this.b.a(0.0F);
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramWSPlayerParam = this.a;
    if ((paramWSPlayerParam != null) && (paramBoolean1) && (paramBoolean2)) {
      paramWSPlayerParam.a(8, 400);
    }
  }
  
  public void a(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    this.e = paramWSVerticalVideoHolder;
    if (paramWSVerticalVideoHolder == null) {
      return;
    }
    if ((paramWSVerticalVideoHolder.c instanceof AbsWSVideoItemView))
    {
      Object localObject = (AbsWSVideoItemView)paramWSVerticalVideoHolder.c;
      AbsWsUIGroup localAbsWsUIGroup = ((AbsWSVideoItemView)localObject).g();
      if ((localAbsWsUIGroup instanceof WSVerticalItemVideoAreaController)) {
        this.a = ((WSVerticalItemVideoAreaController)localAbsWsUIGroup);
      }
      localObject = ((AbsWSVideoItemView)localObject).h();
      if ((localObject instanceof WSVerticalItemVideoProgressController)) {
        this.b = ((WSVerticalItemVideoProgressController)localObject);
      }
    }
    if ((paramWSVerticalVideoHolder.c instanceof WSVerticalVideoOperationRightItemView))
    {
      this.d = ((WSVerticalVideoOperationRightItemView)paramWSVerticalVideoHolder.c);
      paramWSVerticalVideoHolder = this.d.m();
      if ((paramWSVerticalVideoHolder instanceof WSVerticalItemBottomCollectionController)) {
        this.c = ((WSVerticalItemBottomCollectionController)paramWSVerticalVideoHolder);
      }
    }
  }
  
  public void b(WSPlayerParam paramWSPlayerParam) {}
  
  public void c(WSPlayerParam paramWSPlayerParam)
  {
    WSLog.b("WS_VIDEO_VerticalUIDelegate", "WSVerticalPlayerUIDelegate onVideoViewLayoutSwitched()");
    paramWSPlayerParam = this.a;
    if (paramWSPlayerParam != null) {
      paramWSPlayerParam.a(8, 200);
    }
  }
  
  public void d(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = this.a;
    if (paramWSPlayerParam != null)
    {
      paramWSPlayerParam.a(8, 400);
      this.a.d(8);
      this.a.p();
      this.a.q();
    }
    if (this.b != null)
    {
      WSLog.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoStart() hide");
      this.b.n();
    }
  }
  
  public void e(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = this.a;
    if (paramWSPlayerParam != null) {
      paramWSPlayerParam.d(0);
    }
  }
  
  public void f(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = this.a;
    if (paramWSPlayerParam != null)
    {
      paramWSPlayerParam.d(8);
      this.a.q();
    }
  }
  
  public void g(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = this.a;
    if (paramWSPlayerParam != null)
    {
      paramWSPlayerParam.p();
      this.a.a(0, 100);
      this.a.d(8);
    }
    paramWSPlayerParam = this.b;
    if (paramWSPlayerParam != null)
    {
      paramWSPlayerParam.n();
      this.b.a(0.0F);
    }
  }
  
  public void h(WSPlayerParam paramWSPlayerParam)
  {
    paramWSPlayerParam = this.a;
    if (paramWSPlayerParam != null)
    {
      paramWSPlayerParam.o();
      paramWSPlayerParam = a();
      if ((paramWSPlayerParam != null) && (paramWSPlayerParam.f())) {
        this.a.d(8);
      }
    }
  }
  
  public void i(WSPlayerParam paramWSPlayerParam)
  {
    if (this.b != null)
    {
      WSLog.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoBufferEnd() hide");
      this.b.n();
    }
    paramWSPlayerParam = this.a;
    if (paramWSPlayerParam != null)
    {
      paramWSPlayerParam.p();
      paramWSPlayerParam = a();
      if ((paramWSPlayerParam != null) && (paramWSPlayerParam.f())) {
        this.a.d(0);
      }
    }
  }
  
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
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPlayerUIDelegate
 * JD-Core Version:    0.7.0.1
 */