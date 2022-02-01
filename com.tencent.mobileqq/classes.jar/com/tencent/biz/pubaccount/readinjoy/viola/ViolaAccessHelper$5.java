package com.tencent.biz.pubaccount.readinjoy.viola;

import android.os.Handler;
import android.os.Looper;
import com.qq.ac.sdk.api.AcInterface;
import com.qq.ac.sdk.api.AcType.Gender;
import com.qq.ac.sdk.api.AcType.UidType;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate;
import com.tencent.biz.pubaccount.readinjoy.viola.comment.KdCommentHeader;
import com.tencent.biz.pubaccount.readinjoy.viola.comment.KdCommentList;
import com.tencent.biz.pubaccount.readinjoy.viola.components.VideoAnimationComponent;
import com.tencent.biz.pubaccount.readinjoy.viola.lottie.KdLottieViewCreater;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.CacheModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.ComicModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.DtReportModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.NavigationModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.NotifyModule;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.QReportModule;
import com.tencent.biz.pubaccount.readinjoy.viola.reward.VKdRewardTaskVideoTimer;
import com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageDomObject;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.VBarrage;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo.VTopicVideo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaDomObjectManager;
import com.tencent.viola.core.ViolaSDKEngine;
import com.tencent.viola.core.ViolaSDKEngine.InitCallback;
import com.tencent.viola.ui.view.lottie.VLottieView.Factory;
import org.json.JSONObject;

final class ViolaAccessHelper$5
  implements ViolaSDKEngine.InitCallback
{
  ViolaAccessHelper$5(AppInterface paramAppInterface, ViolaAccessHelper.SDKInitCallback paramSDKInitCallback, ViolaReportDelegate paramViolaReportDelegate, String paramString) {}
  
  public void onFinish(int paramInt, long paramLong, String paramString)
  {
    QLog.e("ViolaAccessHelper", 2, new Object[] { "QViolaSDKEngine", "sdk initialize errCode:" + paramInt });
    if ((paramInt == 0) || (paramInt == 1)) {
      for (;;)
      {
        try
        {
          ViolaSDKEngine.registerModule("bridge", BridgeModule.class, false);
          ViolaSDKEngine.registerModule("navigation", NavigationModule.class, true);
          ViolaSDKEngine.registerModule("QReport", QReportModule.class, true);
          ViolaSDKEngine.registerModule("cache", CacheModule.class, true);
          ViolaSDKEngine.registerModule("comic", ComicModule.class, true);
          ViolaSDKEngine.registerModule("report", DtReportModule.class, true);
          ViolaSDKEngine.registerModule("notify", NotifyModule.class, false);
          ViolaSDKEngine.registerComponent(VVideo.class, false, new String[] { "video" });
          ViolaSDKEngine.registerComponent(VKdRewardTaskVideoTimer.class, false, new String[] { "kdredpacket-process" });
          ViolaSDKEngine.registerComponent(VTopicVideo.class, false, new String[] { "topic-video" });
          ViolaSDKEngine.registerComponent(KdCommentList.class, false, new String[] { "kdcomment" });
          ViolaSDKEngine.registerComponent(KdCommentHeader.class, false, new String[] { "kdcomment-header" });
          ViolaSDKEngine.registerComponent(VBarrage.class, false, new String[] { "barrage" });
          ViolaDomObjectManager.registerDomObj("barrage", BarrageDomObject.class);
          ViolaSDKEngine.registerComponent(VideoAnimationComponent.class, false, new String[] { "video-animation" });
          VLottieView.Factory.setVLottieViewCreater(new KdLottieViewCreater());
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
          {
            paramString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
            AcInterface.init(paramString);
            AcInterface.setAppID("ac0632ab2c1e20593b52");
            AcInterface.setAppKey("zBWcxAx7HhqAj0pu2RaXm0T8QElpYiiLXMK4553L2uj");
            if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
              continue;
            }
            paramString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
            AcInterface.setUid(paramString, AcType.UidType.QQ, AcType.Gender.UNKNOWN);
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaAccessHelper$SDKInitCallback != null) {
              new Handler(Looper.getMainLooper()).post(new ViolaAccessHelper.5.1(this, paramLong));
            }
            return;
          }
        }
        catch (Exception paramString)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ViolaAccessHelper", 2, "SDKInitialize Exception e: " + paramString.getMessage());
          return;
        }
        paramString = null;
        continue;
        paramString = null;
      }
    }
    if (ViolaAccessHelper.a() < 3)
    {
      ViolaAccessHelper.b();
      ViolaAccessHelper.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + ViolaBizUtils.b(), new ViolaAccessHelper.5.2(this));
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("error_code", paramInt);
        localJSONObject.put("error_msg", paramString);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800AB6F", "0X800AB6F", 0, 0, "", "", "", localJSONObject.toString(), false);
        return;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaAccessHelper$SDKInitCallback == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaAccessHelper$SDKInitCallback.a();
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.5
 * JD-Core Version:    0.7.0.1
 */