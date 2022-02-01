package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stSimpleMetaGdtAdInfo;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerStatusListener;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.GdtAdWsVideoReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

public class WSPlayerStatusListenerImpl
  implements WSPlayerStatusListener
{
  private WSPlayerManager a;
  private WSVerticalPageFragment b;
  private WSVerticalPageAdapter c;
  
  public WSPlayerStatusListenerImpl(WSPlayerManager paramWSPlayerManager)
  {
    this.a = paramWSPlayerManager;
  }
  
  private void a()
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = this.c.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerStatusListenerImpl.java][prePlayVideo] videoItemHolder:");
    localStringBuilder.append(localWSVerticalVideoHolder);
    localStringBuilder.append(", mPlayerParam:");
    Object localObject;
    if (localWSVerticalVideoHolder != null) {
      localObject = localWSVerticalVideoHolder.f;
    } else {
      localObject = "null";
    }
    localStringBuilder.append(localObject);
    WSLog.e("WS_VIDEO_LISTENER", localStringBuilder.toString());
    if ((localWSVerticalVideoHolder != null) && (localWSVerticalVideoHolder.f != null))
    {
      WSLog.e("WS_VIDEO_SCROLL", "[WSPlayerStatusListenerImpl.java][prePlayVideo] start prePlayView.");
      this.a.a(localWSVerticalVideoHolder.f);
    }
  }
  
  private void b(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((WSVerticalPageAdapter)localObject).b() == null) {
        return;
      }
      localObject = this.c.b();
      WSReportDC898Vertical.a(paramWSPlayerParam, paramBoolean);
      WSVerticalBeaconReport.a(this.b.k(), this.b.l(), paramWSPlayerParam, paramBoolean, ((WSVerticalVideoHolder)localObject).getAdapterPosition() - 1, ((WSVerticalPageContract.Presenter)this.b.aO_()).n());
      if ((((WSVerticalVideoHolder)localObject).e != null) && (((WSVerticalItemData)((WSVerticalVideoHolder)localObject).e).b() != null) && (paramWSPlayerParam != null))
      {
        stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = ((WSVerticalItemData)((WSVerticalVideoHolder)localObject).e).e();
        if ((localstSimpleMetaGdtAdInfo != null) && (!localstSimpleMetaGdtAdInfo.isGdtAdVidoReport))
        {
          if (localstSimpleMetaGdtAdInfo.isGdtAdclicked)
          {
            GdtAdWsVideoReport.a((WSVerticalItemData)((WSVerticalVideoHolder)localObject).e, paramWSPlayerParam, false, 2);
            localstSimpleMetaGdtAdInfo.isGdtAdclicked = false;
            return;
          }
          GdtAdWsVideoReport.a((WSVerticalItemData)((WSVerticalVideoHolder)localObject).e, paramWSPlayerParam, false, 3);
          localstSimpleMetaGdtAdInfo.numbersOfGdtAdPlayed = 0;
        }
      }
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt)
  {
    boolean bool = this.a.s();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onVideoReplayOnLoop loopPlayMode:");
    ((StringBuilder)localObject).append(bool);
    WSLog.e("WS_VIDEO_LISTENER", ((StringBuilder)localObject).toString());
    if (!bool)
    {
      this.b.E();
      return;
    }
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.c != null))
    {
      localObject = this.c;
      if ((localObject != null) && (((WSVerticalPageAdapter)localObject).b() != null))
      {
        localObject = this.c.b();
        if ((localObject != null) && (((WSVerticalVideoHolder)localObject).e != null) && (((WSVerticalItemData)((WSVerticalVideoHolder)localObject).e).b() != null) && (((WSVerticalItemData)((WSVerticalVideoHolder)localObject).e).e() != null))
        {
          GdtAdWsVideoReport.a((WSVerticalItemData)((WSVerticalVideoHolder)localObject).e, paramWSPlayerParam, true, 3);
          localObject = ((WSVerticalItemData)((WSVerticalVideoHolder)localObject).e).e();
          ((stSimpleMetaGdtAdInfo)localObject).numbersOfGdtAdPlayed += 1;
          paramWSPlayerParam.g = 0L;
        }
      }
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString)
  {
    this.b.a(paramWSPlayerParam, paramInt1, paramInt2, paramString);
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    this.b.a(paramWSPlayerParam, paramBoolean);
    b(paramWSPlayerParam, paramBoolean);
  }
  
  public void a(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this.b = paramWSVerticalPageFragment;
    if (paramWSVerticalPageFragment != null) {
      this.c = paramWSVerticalPageFragment.b();
    }
  }
  
  public void b(WSPlayerParam paramWSPlayerParam)
  {
    this.b.a(paramWSPlayerParam);
    if (this.c != null)
    {
      a();
      WSVerticalVideoHolder localWSVerticalVideoHolder = this.c.b();
      String str1 = this.b.k();
      String str2 = this.b.l();
      int i;
      if (localWSVerticalVideoHolder != null) {
        i = localWSVerticalVideoHolder.getAdapterPosition() - 1;
      } else {
        i = 0;
      }
      WSVerticalBeaconReport.a(str1, str2, paramWSPlayerParam, i, ((WSVerticalPageContract.Presenter)this.b.aO_()).n());
    }
    WSFallKeyPicMonitor.a().b();
  }
  
  public void c(WSPlayerParam paramWSPlayerParam)
  {
    if (!this.a.s()) {
      this.b.E();
    }
  }
  
  public void d(WSPlayerParam paramWSPlayerParam) {}
  
  public void e(WSPlayerParam paramWSPlayerParam) {}
  
  public void f(WSPlayerParam paramWSPlayerParam)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerStatusListenerImpl
 * JD-Core Version:    0.7.0.1
 */