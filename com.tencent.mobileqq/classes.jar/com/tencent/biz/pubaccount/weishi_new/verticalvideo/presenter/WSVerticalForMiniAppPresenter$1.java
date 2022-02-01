package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleGetFeedDetailRsp;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.IVerticalRspListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import java.util.ArrayList;
import java.util.List;

class WSVerticalForMiniAppPresenter$1
  implements IWeishiServiceListener
{
  WSVerticalForMiniAppPresenter$1(WSVerticalForMiniAppPresenter paramWSVerticalForMiniAppPresenter, long paramLong, IVerticalRspListener paramIVerticalRspListener) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    WSLog.a("weishi-beacon", "小程序播放页请求耗时：" + l + "毫秒");
    WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, "fullscreen_videoplay", true);
    if (!paramWeishiTask.a())
    {
      WSLog.d("WSVerticalForMiniAppPresenter", "GetFeedDetailRequest onTaskResponse failed code:" + paramWeishiTask.jdField_a_of_type_Int + ", msg:" + paramWeishiTask.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener.a(paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString, true, false);
      }
      WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString);
    }
    Object localObject;
    do
    {
      do
      {
        return;
        if (!(paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedDetailRsp)) {
          break;
        }
        paramWeishiTask = ((stSimpleGetFeedDetailRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject).feed;
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramWeishiTask);
        paramWeishiTask = WSVerticalDataUtil.a((List)localObject);
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoPresenterWSVerticalForMiniAppPresenter.a();
      } while ((localObject == null) || (((WSVerticalPageContract.View)localObject).a() == null) || (((WSVerticalPageContract.View)localObject).a().a() == null));
      localObject = ((WSVerticalPageContract.View)localObject).a().a().a;
    } while (!(localObject instanceof AbsWSVideoItemView));
    ((AbsWSVideoItemView)localObject).b((WSVerticalItemData)paramWeishiTask.get(0));
    return;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener.a(paramWeishiTask.b, paramWeishiTask.jdField_a_of_type_JavaLangString, true, false);
    }
    WsBeaconReportPresenter.a().a(l, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, -1, "数据无法解析或为空");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForMiniAppPresenter.1
 * JD-Core Version:    0.7.0.1
 */