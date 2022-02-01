package com.tencent.biz.pubaccount.weishi_new.verticalvideo.report;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWsVideoReportModel;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWsVideoReportModel.Builder;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qav.thread.ThreadManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.net.URLEncoder;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class GdtAdWsVideoReport
{
  private static String a = "GdtAdWsVideoReport";
  
  private static String a(stSimpleMetaFeed paramstSimpleMetaFeed, WSPlayerParam paramWSPlayerParam)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.gdt_ad_type == 1) && (paramstSimpleMetaFeed.gdt_ad_info != null))
    {
      paramstSimpleMetaFeed = GdtAdUtil.a(paramstSimpleMetaFeed).report_info;
      if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.exposure_url != null) && (paramWSPlayerParam != null) && (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper != null)) {
        return paramstSimpleMetaFeed.exposure_url.get();
      }
    }
    return "";
  }
  
  public static String a(GdtAdWsVideoReportModel paramGdtAdWsVideoReportModel)
  {
    if (paramGdtAdWsVideoReportModel == null) {
      return "";
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramGdtAdWsVideoReportModel.jdField_a_of_type_Long);
        localStringBuilder.append("");
        ((JSONObject)localObject).put("bt", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramGdtAdWsVideoReportModel.jdField_b_of_type_Long);
        localStringBuilder.append("");
        ((JSONObject)localObject).put("et", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        boolean bool = paramGdtAdWsVideoReportModel.jdField_a_of_type_Boolean;
        int j = 1;
        if (bool)
        {
          i = 1;
          localStringBuilder.append(i);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("bf", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          if (!paramGdtAdWsVideoReportModel.jdField_b_of_type_Boolean) {
            break label393;
          }
          i = j;
          localStringBuilder.append(i);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("ef", localStringBuilder.toString());
          ((JSONObject)localObject).put("pp", "11");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramGdtAdWsVideoReportModel.jdField_b_of_type_Int);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("pa", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramGdtAdWsVideoReportModel.c);
          localStringBuilder.append("");
          ((JSONObject)localObject).put("ft", localStringBuilder.toString());
          if (paramGdtAdWsVideoReportModel.d != 0)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramGdtAdWsVideoReportModel.d);
            localStringBuilder.append("");
            ((JSONObject)localObject).put("ps", localStringBuilder.toString());
          }
          paramGdtAdWsVideoReportModel = ((JSONObject)localObject).toString();
          return paramGdtAdWsVideoReportModel;
        }
      }
      catch (Exception paramGdtAdWsVideoReportModel)
      {
        Object localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" @getGdtInfo createGDTVideoAttachment");
        localStringBuilder.append(paramGdtAdWsVideoReportModel.toString());
        WSLog.a((String)localObject, localStringBuilder.toString());
        return null;
      }
      int i = 0;
      continue;
      label393:
      i = 0;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      localObject = new StringBuffer();
      if (!TextUtils.isEmpty(paramString1)) {
        ((StringBuffer)localObject).append(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        ((StringBuffer)localObject).append("&video=");
        ((StringBuffer)localObject).append(URLEncoder.encode(paramString2));
      }
      paramString1 = ((StringBuffer)localObject).toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = a;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" @getGdtInfo getHttpVideoPlayUrl");
      ((StringBuilder)localObject).append(paramString1.toString());
      WSLog.a(paramString2, ((StringBuilder)localObject).toString());
    }
    return "";
  }
  
  public static void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    GdtAdWsVideoReportModel.Builder localBuilder = new GdtAdWsVideoReportModel.Builder();
    localBuilder.a(paramLong1).b(paramBoolean2).b(paramLong2).d(paramInt4).a(paramInt1).a(paramBoolean1).b(paramInt2).c(paramInt3);
    a(localBuilder.a(), paramString);
  }
  
  public static void a(WSVerticalItemData paramWSVerticalItemData, WSPlayerParam paramWSPlayerParam, boolean paramBoolean, int paramInt)
  {
    if ((paramWSVerticalItemData != null) && (paramWSPlayerParam != null) && ((paramWSVerticalItemData.a() != null) || (paramWSVerticalItemData.a() != null)))
    {
      if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo == null) {
        return;
      }
      Object localObject = paramWSVerticalItemData.a();
      if (localObject != null)
      {
        localObject = a((stSimpleMetaFeed)localObject, paramWSPlayerParam);
        if ((paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          WSPlayerWrapper localWSPlayerWrapper = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper;
          long l1 = paramWSPlayerParam.jdField_a_of_type_Long;
          long l2 = localWSPlayerWrapper.a();
          int j = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.c;
          boolean bool;
          if (l1 == 0L) {
            bool = true;
          } else {
            bool = false;
          }
          int i;
          if (paramWSVerticalItemData.a().numbersOfGdtAdPlayed != 0) {
            i = 13;
          } else {
            i = 11;
          }
          ThreadManager.b().post(new GdtAdWsVideoReport.1(l1, paramBoolean, j, l2, bool, i, paramInt, (String)localObject));
        }
      }
    }
  }
  
  private static void a(GdtAdWsVideoReportModel paramGdtAdWsVideoReportModel, String paramString)
  {
    if (paramGdtAdWsVideoReportModel != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramGdtAdWsVideoReportModel = a(paramGdtAdWsVideoReportModel);
      paramString = a(paramString, paramGdtAdWsVideoReportModel);
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportHttpVideoUrl = ");
      localStringBuilder.append(paramGdtAdWsVideoReportModel);
      WSLog.a(str, 2, localStringBuilder.toString());
      a(paramString);
    }
  }
  
  private static void a(String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").postDelayed(new GdtAdWsVideoReport.2(paramString), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.GdtAdWsVideoReport
 * JD-Core Version:    0.7.0.1
 */