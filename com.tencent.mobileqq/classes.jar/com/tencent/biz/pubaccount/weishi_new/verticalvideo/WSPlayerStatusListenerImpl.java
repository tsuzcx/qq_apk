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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPlayerStatusListenerImpl.java][prePlayVideo] videoItemHolder:");
    localStringBuilder.append(localWSVerticalVideoHolder);
    localStringBuilder.append(", mPlayerParam:");
    Object localObject;
    if (localWSVerticalVideoHolder != null) {
      localObject = localWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
    } else {
      localObject = "null";
    }
    localStringBuilder.append(localObject);
    WSLog.e("WS_VIDEO_LISTENER", localStringBuilder.toString());
    if ((localWSVerticalVideoHolder != null) && (localWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null))
    {
      WSLog.e("WS_VIDEO_SCROLL", "[WSPlayerStatusListenerImpl.java][prePlayVideo] start prePlayView.");
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam);
    }
  }
  
  private void b(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter;
    if (localObject != null)
    {
      if (((WSVerticalPageAdapter)localObject).a() == null) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
      WSReportDC898Vertical.a(paramWSPlayerParam, paramBoolean);
      WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), paramWSPlayerParam, paramBoolean, ((WSVerticalVideoHolder)localObject).getAdapterPosition() - 1, ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b());
      if ((((WSVerticalVideoHolder)localObject).jdField_a_of_type_JavaLangObject != null) && (((WSVerticalItemData)((WSVerticalVideoHolder)localObject).jdField_a_of_type_JavaLangObject).a() != null) && (paramWSPlayerParam != null))
      {
        stSimpleMetaGdtAdInfo localstSimpleMetaGdtAdInfo = ((WSVerticalItemData)((WSVerticalVideoHolder)localObject).jdField_a_of_type_JavaLangObject).a();
        if ((localstSimpleMetaGdtAdInfo != null) && (!localstSimpleMetaGdtAdInfo.isGdtAdVidoReport))
        {
          if (localstSimpleMetaGdtAdInfo.isGdtAdclicked)
          {
            GdtAdWsVideoReport.a((WSVerticalItemData)((WSVerticalVideoHolder)localObject).jdField_a_of_type_JavaLangObject, paramWSPlayerParam, false, 2);
            localstSimpleMetaGdtAdInfo.isGdtAdclicked = false;
            return;
          }
          GdtAdWsVideoReport.a((WSVerticalItemData)((WSVerticalVideoHolder)localObject).jdField_a_of_type_JavaLangObject, paramWSPlayerParam, false, 3);
          localstSimpleMetaGdtAdInfo.numbersOfGdtAdPlayed = 0;
        }
      }
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam) {}
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt)
  {
    boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.j();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onVideoReplayOnLoop loopPlayMode:");
    ((StringBuilder)localObject).append(bool);
    WSLog.e("WS_VIDEO_LISTENER", ((StringBuilder)localObject).toString());
    if (!bool)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.i();
      return;
    }
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo != null))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter;
      if ((localObject != null) && (((WSVerticalPageAdapter)localObject).a() != null))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
        if ((localObject != null) && (((WSVerticalVideoHolder)localObject).jdField_a_of_type_JavaLangObject != null) && (((WSVerticalItemData)((WSVerticalVideoHolder)localObject).jdField_a_of_type_JavaLangObject).a() != null) && (((WSVerticalItemData)((WSVerticalVideoHolder)localObject).jdField_a_of_type_JavaLangObject).a() != null))
        {
          GdtAdWsVideoReport.a((WSVerticalItemData)((WSVerticalVideoHolder)localObject).jdField_a_of_type_JavaLangObject, paramWSPlayerParam, true, 3);
          localObject = ((WSVerticalItemData)((WSVerticalVideoHolder)localObject).jdField_a_of_type_JavaLangObject).a();
          ((stSimpleMetaGdtAdInfo)localObject).numbersOfGdtAdPlayed += 1;
          paramWSPlayerParam.jdField_a_of_type_Long = 0L;
        }
      }
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(paramWSPlayerParam, paramInt1, paramInt2, paramString);
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(paramWSPlayerParam, paramBoolean);
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter != null)
    {
      a();
      WSVerticalVideoHolder localWSVerticalVideoHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
      String str1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
      String str2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
      int i;
      if (localWSVerticalVideoHolder != null) {
        i = localWSVerticalVideoHolder.getAdapterPosition() - 1;
      } else {
        i = 0;
      }
      WSVerticalBeaconReport.a(str1, str2, paramWSPlayerParam, i, ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b());
    }
    WSFallKeyPicMonitor.a().a();
  }
  
  public void c(WSPlayerParam paramWSPlayerParam)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.j()) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.i();
    }
  }
  
  public void d(WSPlayerParam paramWSPlayerParam) {}
  
  public void e(WSPlayerParam paramWSPlayerParam) {}
  
  public void f(WSPlayerParam paramWSPlayerParam)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerStatusListenerImpl
 * JD-Core Version:    0.7.0.1
 */