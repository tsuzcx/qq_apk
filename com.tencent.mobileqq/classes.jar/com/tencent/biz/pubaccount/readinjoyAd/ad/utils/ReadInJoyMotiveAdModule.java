package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.aditem.GdtAdUtil;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoParams;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.ContextInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public class ReadInJoyMotiveAdModule
{
  private static volatile ReadInJoyMotiveAdModule a;
  
  public static ReadInJoyMotiveAdModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ReadInJoyMotiveAdModule();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static Object a(GdtAd paramGdtAd)
  {
    if ((paramGdtAd != null) && (paramGdtAd.getGdtAdLoader() != null))
    {
      if (paramGdtAd.getGdtAdLoader().a() == null) {
        return null;
      }
      if (paramGdtAd.getGdtAdLoader().a().a.pos_ads_info != null)
      {
        if (paramGdtAd.getGdtAdLoader().a().a.pos_ads_info.get(0) == null) {
          return null;
        }
        if (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAd.getGdtAdLoader().a().a.pos_ads_info.get(0)).ads_info != null)
        {
          if (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAd.getGdtAdLoader().a().a.pos_ads_info.get(0)).ads_info.get(0) == null) {
            return null;
          }
          return GdtJsonPbUtil.a((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramGdtAd.getGdtAdLoader().a().a.pos_ads_info.get(0)).ads_info.get(0));
        }
      }
    }
    return null;
  }
  
  public GdtHandler.Params a(boolean paramBoolean, Activity paramActivity)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.c = 1;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    localParams.jdField_a_of_type_Boolean = paramBoolean;
    return localParams;
  }
  
  public qq_ad_get.QQAdGet a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, int paramInt2)
  {
    Object localObject1 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject1).share_rate.set(paramInt2);
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject1).share_check.set(GdtAdUtil.a(paramLong2, paramLong3, paramInt2));
    Object localObject2 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).share_info.set((MessageMicro)localObject1);
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).deep_link_version.set(1);
    localObject1 = new qq_ad_get.QQAdGet.PositionInfo();
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).pos_id.set(paramString);
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).ad_count.set(1);
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).pos_ext.set((MessageMicro)localObject2);
    paramString = new qq_ad_get.QQAdGet.ContextInfo();
    paramString.public_id.set(paramLong2);
    paramString.article_id.set(paramLong3);
    paramString.source_from.set(paramInt1);
    localObject2 = new qq_ad_get.QQAdGet.UserInfo();
    ((qq_ad_get.QQAdGet.UserInfo)localObject2).qq.set(paramLong1);
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    localQQAdGet.position_info.add((MessageMicro)localObject1);
    localQQAdGet.context_info.set(paramString);
    localQQAdGet.user_info.set((MessageMicro)localObject2);
    return localQQAdGet;
  }
  
  public void a(Activity paramActivity, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = (qq_ad_get.QQAdGetRsp.AdInfo)GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramString1));
    }
    catch (Exception paramString1)
    {
      QLog.e("MotiveAdUtils", 1, "showMotiveAd e", paramString1);
      paramString1 = null;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = GdtUtil.a(paramString1, GdtUtil.a(paramInt1));
    if (localGdtMotiveVideoPageData != null)
    {
      String str = paramActivity.getIntent().getStringExtra("big_brother_ref_source_key");
      paramString1 = str;
      if (TextUtils.isEmpty(str)) {
        paramString1 = paramActivity.getIntent().getStringExtra("big_brother_source_key");
      }
      str = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        str = "biz_src_feeds_kandian";
      }
      localGdtMotiveVideoPageData.refId = str;
      if (paramInt2 > 0) {
        localGdtMotiveVideoPageData.setVideoCountDown(paramInt2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localGdtMotiveVideoPageData.setRewardText(paramString3);
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("showMotiveAd : orientation = ");
        paramString1.append(paramInt1);
        paramString1.append("rewardTime + = ");
        paramString1.append(paramInt2);
        paramString1.append("refId = ");
        paramString1.append(str);
        paramString1.append("rewardText=");
        paramString1.append(paramString3);
        QLog.d("MotiveAdUtils", 2, paramString1.toString());
      }
      ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.a(paramActivity, localGdtMotiveVideoPageData, paramString2));
    }
  }
  
  public void a(Activity paramActivity, String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, GdtAdListener paramGdtAdListener)
  {
    try
    {
      Object localObject = new GdtMotiveVideoParams();
      ((GdtMotiveVideoParams)localObject).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = a(Long.parseLong(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface().getCurrentAccountUin()), paramString, paramLong1, paramLong2, paramInt1, paramInt2);
      try
      {
        ((GdtMotiveVideoParams)localObject).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = a(true, paramActivity);
        localObject = new GdtMotiveVideoAd((GdtMotiveVideoParams)localObject);
        ((GdtMotiveVideoAd)localObject).setListener(new WeakReference(paramGdtAdListener));
        ((GdtMotiveVideoAd)localObject).load(paramActivity);
      }
      catch (Throwable paramActivity) {}
      QLog.e("MotiveAdUtils", 1, paramActivity, new Object[0]);
    }
    catch (Throwable paramActivity) {}
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("getMotiveAd : posId = ");
      paramActivity.append(paramString);
      paramActivity.append("publicId = ");
      paramActivity.append(paramLong1);
      paramActivity.append("articleId = ");
      paramActivity.append(paramLong2);
      paramActivity.append("sourceFrom = ");
      paramActivity.append(paramInt1);
      paramActivity.append("shareRate = ");
      paramActivity.append(paramInt2);
      QLog.d("MotiveAdUtils", 2, paramActivity.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyMotiveAdModule
 * JD-Core Version:    0.7.0.1
 */