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
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSVerticalPageAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  
  public WSPlayerStatusListenerImpl(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
  }
  
  private void a()
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.b();
    StringBuilder localStringBuilder = new StringBuilder().append("[WSPlayerStatusListenerImpl.java][prePlayVideo] videoItemHolder:").append(localWSVerticalVideoHolder).append(", mPlayerParam:");
    if (localWSVerticalVideoHolder != null) {}
    for (Object localObject = localWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;; localObject = "null")
    {
      WSLog.e("WS_VIDEO_LISTENER", localObject);
      if ((localWSVerticalVideoHolder != null) && (localWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null))
      {
        WSLog.e("WS_VIDEO_SCROLL", "[WSPlayerStatusListenerImpl.java][prePlayVideo] start prePlayView.");
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
      }
      return;
    }
  }
  
  private void b(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a() == null)) {}
    WSVerticalVideoHolder localWSVerticalVideoHolder;
    stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo;
    do
    {
      do
      {
        return;
        localWSVerticalVideoHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
        WSReportDC898Vertical.a(paramWSPlayerParam, paramBoolean);
        WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), paramWSPlayerParam, paramBoolean, localWSVerticalVideoHolder.getAdapterPosition() - 1);
      } while ((localWSVerticalVideoHolder.jdField_a_of_type_JavaLangObject == null) || (((WSVerticalItemData)localWSVerticalVideoHolder.jdField_a_of_type_JavaLangObject).a() == null) || (paramWSPlayerParam == null));
      localstSimpleMetaGdtAdInfo = ((WSVerticalItemData)localWSVerticalVideoHolder.jdField_a_of_type_JavaLangObject).a();
    } while ((localstSimpleMetaGdtAdInfo == null) || (localstSimpleMetaGdtAdInfo.isGdtAdVidoReport));
    if (localstSimpleMetaGdtAdInfo.isGdtAdclicked)
    {
      GdtAdWsVideoReport.a((WSVerticalItemData)localWSVerticalVideoHolder.jdField_a_of_type_JavaLangObject, paramWSPlayerParam, 2);
      localstSimpleMetaGdtAdInfo.isGdtAdclicked = false;
      return;
    }
    ((WSVerticalItemData)localWSVerticalVideoHolder.jdField_a_of_type_JavaLangObject).a().numbersOfGdtAdPlayed = 0;
    GdtAdWsVideoReport.a((WSVerticalItemData)localWSVerticalVideoHolder.jdField_a_of_type_JavaLangObject, paramWSPlayerParam, 3);
  }
  
  public void a(WSPlayerParam paramWSPlayerParam) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.j();
    WSLog.e("WS_VIDEO_LISTENER", "onVideoReplayOnLoop loopPlayMode:" + bool);
    if (!bool) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.g();
    }
    WSVerticalVideoHolder localWSVerticalVideoHolder;
    do
    {
      do
      {
        return;
      } while ((paramWSPlayerParam == null) || (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a() == null));
      localWSVerticalVideoHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
    } while ((localWSVerticalVideoHolder == null) || (localWSVerticalVideoHolder.jdField_a_of_type_JavaLangObject == null) || (((WSVerticalItemData)localWSVerticalVideoHolder.jdField_a_of_type_JavaLangObject).a() == null) || (paramWSPlayerParam == null));
    GdtAdWsVideoReport.a((WSVerticalItemData)localWSVerticalVideoHolder.jdField_a_of_type_JavaLangObject, paramWSPlayerParam);
    paramWSPlayerParam.jdField_a_of_type_Long = 0L;
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(paramWSPlayerParam, paramInt1, paramInt2, paramString);
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    b(paramWSPlayerParam, paramBoolean);
  }
  
  public void a(WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
    if (paramWSVerticalPageFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter = paramWSVerticalPageFragment.a();
    }
  }
  
  public void b(WSPlayerParam paramWSPlayerParam)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(paramWSPlayerParam);
    WSVerticalVideoHolder localWSVerticalVideoHolder;
    String str1;
    String str2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter != null)
    {
      a();
      localWSVerticalVideoHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
      str1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
      str2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
      if (localWSVerticalVideoHolder == null) {
        break label72;
      }
    }
    label72:
    for (int i = localWSVerticalVideoHolder.getAdapterPosition() - 1;; i = 0)
    {
      WSVerticalBeaconReport.a(str1, str2, paramWSPlayerParam, i);
      WSFallKeyPicMonitor.a().a();
      return;
    }
  }
  
  public void c(WSPlayerParam paramWSPlayerParam)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.j()) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.g();
    }
  }
  
  public void d(WSPlayerParam paramWSPlayerParam) {}
  
  public void e(WSPlayerParam paramWSPlayerParam) {}
  
  public void f(WSPlayerParam paramWSPlayerParam)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerStatusListenerImpl
 * JD-Core Version:    0.7.0.1
 */