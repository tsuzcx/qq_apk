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
    String str2 = "";
    String str1 = str2;
    if (paramstSimpleMetaFeed != null)
    {
      str1 = str2;
      if (paramstSimpleMetaFeed.gdt_ad_type == 1)
      {
        str1 = str2;
        if (paramstSimpleMetaFeed.gdt_ad_info != null)
        {
          paramstSimpleMetaFeed = GdtAdUtil.a(paramstSimpleMetaFeed).report_info;
          str1 = str2;
          if (paramstSimpleMetaFeed != null)
          {
            str1 = str2;
            if (paramstSimpleMetaFeed.exposure_url != null)
            {
              str1 = str2;
              if (paramWSPlayerParam != null)
              {
                str1 = str2;
                if (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper != null) {
                  str1 = paramstSimpleMetaFeed.exposure_url.get();
                }
              }
            }
          }
        }
      }
    }
    return str1;
  }
  
  public static String a(GdtAdWsVideoReportModel paramGdtAdWsVideoReportModel)
  {
    int j = 1;
    if (paramGdtAdWsVideoReportModel == null) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("bt", paramGdtAdWsVideoReportModel.jdField_a_of_type_Long + "");
      localJSONObject.put("et", paramGdtAdWsVideoReportModel.jdField_b_of_type_Long + "");
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramGdtAdWsVideoReportModel.jdField_a_of_type_Boolean)
      {
        i = 1;
        localJSONObject.put("bf", i + "");
        localStringBuilder = new StringBuilder();
        if (!paramGdtAdWsVideoReportModel.jdField_b_of_type_Boolean) {
          break label268;
        }
      }
      label268:
      for (int i = j;; i = 0)
      {
        localJSONObject.put("ef", i + "");
        localJSONObject.put("pp", "11");
        localJSONObject.put("pa", paramGdtAdWsVideoReportModel.jdField_b_of_type_Int + "");
        localJSONObject.put("ft", paramGdtAdWsVideoReportModel.c + "");
        if (paramGdtAdWsVideoReportModel.d != 0) {
          localJSONObject.put("ps", paramGdtAdWsVideoReportModel.d + "");
        }
        paramGdtAdWsVideoReportModel = localJSONObject.toString();
        return paramGdtAdWsVideoReportModel;
        i = 0;
        break;
      }
      return null;
    }
    catch (Exception paramGdtAdWsVideoReportModel)
    {
      WSLog.a(a, " @getGdtInfo createGDTVideoAttachment" + paramGdtAdWsVideoReportModel.toString());
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (!TextUtils.isEmpty(paramString1)) {
        localStringBuffer.append(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        localStringBuffer.append("&video=");
        localStringBuffer.append(URLEncoder.encode(paramString2));
      }
      paramString1 = localStringBuffer.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      WSLog.a(a, " @getGdtInfo getHttpVideoPlayUrl" + paramString1.toString());
    }
    return "";
  }
  
  public static void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    GdtAdWsVideoReportModel.Builder localBuilder = new GdtAdWsVideoReportModel.Builder();
    localBuilder.a(paramLong1).b(paramBoolean2).b(paramLong2).d(paramInt4).a(paramInt1).a(paramBoolean1).b(paramInt2).c(paramInt3);
    a(localBuilder.a(), paramString);
  }
  
  public static void a(WSVerticalItemData paramWSVerticalItemData, WSPlayerParam paramWSPlayerParam)
  {
    if ((paramWSVerticalItemData == null) || (paramWSPlayerParam == null) || (paramWSVerticalItemData.a() == null) || (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo == null) || (paramWSVerticalItemData.a() == null)) {}
    do
    {
      return;
      paramWSVerticalItemData.a().numbersOfGdtAdPlayed += 1;
      localObject = paramWSVerticalItemData.a();
    } while (!(localObject instanceof stSimpleMetaFeed));
    Object localObject = a((stSimpleMetaFeed)localObject, paramWSPlayerParam);
    int i;
    long l1;
    long l2;
    if (paramWSVerticalItemData.a().numbersOfGdtAdPlayed > 1)
    {
      i = 13;
      l1 = paramWSPlayerParam.jdField_a_of_type_Long;
      l2 = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.c;
      if (paramWSPlayerParam.jdField_a_of_type_Long != 0L) {
        break label135;
      }
    }
    label135:
    for (boolean bool = true;; bool = false)
    {
      a(l1, l2, bool, true, 11, i, 3, 0, (String)localObject);
      return;
      i = 11;
      break;
    }
  }
  
  public static void a(WSVerticalItemData paramWSVerticalItemData, WSPlayerParam paramWSPlayerParam, int paramInt)
  {
    boolean bool2 = false;
    if ((paramWSVerticalItemData == null) || (paramWSPlayerParam == null) || ((paramWSVerticalItemData.a() == null) && (paramWSVerticalItemData.a() == null)) || (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = paramWSVerticalItemData.a();
      } while (localObject == null);
      localObject = a((stSimpleMetaFeed)localObject, paramWSPlayerParam);
    } while ((paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper == null) || (TextUtils.isEmpty((CharSequence)localObject)));
    WSPlayerWrapper localWSPlayerWrapper = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper;
    long l1 = paramWSPlayerParam.jdField_a_of_type_Long;
    long l2 = localWSPlayerWrapper.a();
    int i = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.c;
    if (l1 == 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (l2 == i) {
        bool2 = true;
      }
      if (paramWSVerticalItemData.a().numbersOfGdtAdPlayed > 1) {}
      for (i = 13;; i = 11)
      {
        ThreadManager.b().post(new GdtAdWsVideoReport.1(l1, l2, bool1, bool2, i, paramInt, (String)localObject));
        return;
      }
    }
  }
  
  private static void a(GdtAdWsVideoReportModel paramGdtAdWsVideoReportModel, String paramString)
  {
    if ((paramGdtAdWsVideoReportModel == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramGdtAdWsVideoReportModel = a(paramGdtAdWsVideoReportModel);
    paramString = a(paramString, paramGdtAdWsVideoReportModel);
    WSLog.a(a, 2, "reportHttpVideoUrl = " + paramGdtAdWsVideoReportModel);
    a(paramString);
  }
  
  private static void a(String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").postDelayed(new GdtAdWsVideoReport.2(paramString), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.GdtAdWsVideoReport
 * JD-Core Version:    0.7.0.1
 */