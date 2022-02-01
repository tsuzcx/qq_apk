package com.tencent.biz.pubaccount.weishi_new.recommend.data;

import UserGrowth.stNotificationRsp;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.request.NotificationRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

public class WSNoticeDataManager
{
  private void a(WeishiTask paramWeishiTask, IWSNoticeRspListener paramIWSNoticeRspListener, long paramLong)
  {
    WSLog.e("WSNoticeDataManagerLog", "[WSNoticeDataManager.java][handleOnTaskResponse] resultCode:" + paramWeishiTask.b + ", resultBean:" + paramWeishiTask.jdField_a_of_type_JavaLangObject + ", thread:" + Thread.currentThread().getName());
    paramLong = System.currentTimeMillis() - paramLong;
    if (!paramWeishiTask.a())
    {
      WsBeaconReportPresenter.a().a(paramLong, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString);
      if (paramIWSNoticeRspListener != null) {
        paramIWSNoticeRspListener.a(paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString);
      }
    }
    do
    {
      stNotificationRsp localstNotificationRsp;
      RspHeaderBean localRspHeaderBean;
      do
      {
        do
        {
          return;
          if ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stNotificationRsp)) {
            break;
          }
          WSLog.d("WSNoticeDataManagerLog", "[WSNoticeDataManager.java][handleOnTaskResponse] task.mResultBean instanceof stNotificationRsp: false! error:" + paramWeishiTask.b + ", errorMsg:" + paramWeishiTask.jdField_a_of_type_JavaLangString);
          WsBeaconReportPresenter.a().a(paramLong, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, -1, "数据无法解析或为空");
        } while (paramIWSNoticeRspListener == null);
        paramIWSNoticeRspListener.a(paramWeishiTask.b, paramWeishiTask.jdField_a_of_type_JavaLangString);
        return;
        WsBeaconReportPresenter.a().a(paramLong, paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetWeishiRequest, "feeds", true);
        localstNotificationRsp = (stNotificationRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
        WSLog.e("WSNoticeDataManagerLog", "[WSNoticeDataManager.java][handleOnTaskResponse] type:" + localstNotificationRsp.type + ", text:" + localstNotificationRsp.text + ", h5Url:" + localstNotificationRsp.h5Url + ", schema:" + localstNotificationRsp.scheme_url);
        localRspHeaderBean = paramWeishiTask.jdField_a_of_type_ComTencentBizPubaccountWeishi_newNetRspHeaderBean;
        if (localRspHeaderBean != null) {
          WSRecommendReportManager.a().a(localstNotificationRsp.trace_id, localRspHeaderBean.a);
        }
        if (localstNotificationRsp.type <= 0) {
          break;
        }
      } while (paramIWSNoticeRspListener == null);
      paramIWSNoticeRspListener.a(localstNotificationRsp, localRspHeaderBean);
      return;
    } while (paramIWSNoticeRspListener == null);
    paramIWSNoticeRspListener.a(paramWeishiTask.b, paramWeishiTask.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString, IWSNoticeRspListener paramIWSNoticeRspListener)
  {
    long l = System.currentTimeMillis();
    paramString = new WeishiTask(new NotificationRequest(paramString), null, new WSNoticeDataManager.1(this, paramIWSNoticeRspListener, l), 2001);
    WeishiBusinessLooper.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.WSNoticeDataManager
 * JD-Core Version:    0.7.0.1
 */