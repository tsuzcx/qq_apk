package com.tencent.biz.pubaccount.NativeAd.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.NativeAd.report.AdReportManager;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.InteraActionReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class RIJAdReportManager
{
  public static AdvertisementInfo a(VideoAdInfo paramVideoAdInfo)
  {
    return a(paramVideoAdInfo, null, null);
  }
  
  public static AdvertisementInfo a(VideoAdInfo paramVideoAdInfo, Integer paramInteger1, Integer paramInteger2)
  {
    AdvertisementInfo localAdvertisementInfo = new AdvertisementInfo();
    if (paramVideoAdInfo == null) {
      return localAdvertisementInfo;
    }
    localAdvertisementInfo.mAdAdvertiseId = paramVideoAdInfo.Z;
    localAdvertisementInfo.mAdVideoUrl = paramVideoAdInfo.B;
    localAdvertisementInfo.mAdAid = paramVideoAdInfo.G;
    localAdvertisementInfo.mAdTraceId = paramVideoAdInfo.m;
    localAdvertisementInfo.mAdViewId = paramVideoAdInfo.u;
    localAdvertisementInfo.mAdProductId = paramVideoAdInfo.n;
    localAdvertisementInfo.mAdVia = paramVideoAdInfo.L;
    localAdvertisementInfo.mAdNocoId = paramVideoAdInfo.ac;
    localAdvertisementInfo.mAdApurl = paramVideoAdInfo.l;
    localAdvertisementInfo.mAdRl = paramVideoAdInfo.k;
    localAdvertisementInfo.mAdDownloadApiUrl = paramVideoAdInfo.ad;
    localAdvertisementInfo.mAdEffectUrl = paramVideoAdInfo.ab;
    localAdvertisementInfo.mAdLandingPageReportUrl = paramVideoAdInfo.Y;
    localAdvertisementInfo.mAdLandingPage = paramVideoAdInfo.r;
    localAdvertisementInfo.mAdCanvasJson = paramVideoAdInfo.X;
    localAdvertisementInfo.mAdDestType = paramVideoAdInfo.aa;
    localAdvertisementInfo.mAdExt = paramVideoAdInfo.A;
    localAdvertisementInfo.mAdAppDownLoadSchema = paramVideoAdInfo.W;
    localAdvertisementInfo.mAdCustomizedInvokeUrl = paramVideoAdInfo.v;
    localAdvertisementInfo.mAdProductType = paramVideoAdInfo.o;
    localAdvertisementInfo.mAdJumpMode = paramVideoAdInfo.S;
    localAdvertisementInfo.mAdPosID = paramVideoAdInfo.c;
    if (paramInteger1 != null) {
      localAdvertisementInfo.mOrigin = paramInteger1.intValue();
    }
    if (paramInteger2 != null) {
      localAdvertisementInfo.mChannelID = paramInteger2.intValue();
    }
    if (paramVideoAdInfo.R != null) {
      try
      {
        paramInteger1 = new JSONObject(paramVideoAdInfo.R);
        if (paramInteger1.has("mini_program_type")) {
          localAdvertisementInfo.miniProgramType = paramInteger1.optInt("mini_program_type");
        }
        localAdvertisementInfo.mAdExtInfo = paramVideoAdInfo.R;
      }
      catch (Exception paramInteger1)
      {
        paramInteger1.printStackTrace();
      }
    }
    localAdvertisementInfo.mPopFormH5Url = paramVideoAdInfo.ai;
    localAdvertisementInfo.mShowAdButton = paramVideoAdInfo.aj;
    localAdvertisementInfo.mAdFetchTime = paramVideoAdInfo.a;
    localAdvertisementInfo.mAdKdPos = paramVideoAdInfo.e;
    localAdvertisementInfo.ecpm = paramVideoAdInfo.az;
    localAdvertisementInfo.isContract = paramVideoAdInfo.aA;
    VideoAdInfo.a(paramVideoAdInfo);
    localAdvertisementInfo.mCToSSwitch = paramVideoAdInfo.af;
    localAdvertisementInfo.mCToSClickUrl = paramVideoAdInfo.ag;
    localAdvertisementInfo.mCToSExposureUrl = paramVideoAdInfo.ah;
    localAdvertisementInfo.replay = paramVideoAdInfo.ak;
    localAdvertisementInfo.mRevisionVideoType = paramVideoAdInfo.U;
    localAdvertisementInfo.isMultiyVideo = paramVideoAdInfo.V;
    localAdvertisementInfo.processAdExt(paramVideoAdInfo.A);
    localAdvertisementInfo.mAdBtnTxt = paramVideoAdInfo.t;
    localAdvertisementInfo.mAdvertisementExtInfo = new AdvertisementExtInfo(paramVideoAdInfo.R);
    return localAdvertisementInfo;
  }
  
  /* Error */
  public static JSONObject a(Context paramContext)
  {
    // Byte code:
    //   0: new 173	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 289	org/json/JSONObject:<init>	()V
    //   7: astore 8
    //   9: invokestatic 294	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdDeviceInfoUtil:a	()Ljava/lang/String;
    //   12: astore 6
    //   14: invokestatic 297	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdDeviceInfoUtil:d	()Ljava/lang/String;
    //   17: astore 7
    //   19: aload 6
    //   21: invokestatic 303	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: istore_3
    //   25: iload_3
    //   26: ifne +44 -> 70
    //   29: aload 6
    //   31: invokevirtual 308	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   34: astore 4
    //   36: aload 8
    //   38: ldc_w 310
    //   41: aload 4
    //   43: invokestatic 316	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokevirtual 308	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   49: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   52: pop
    //   53: aload 8
    //   55: ldc_w 322
    //   58: iconst_1
    //   59: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   62: pop
    //   63: aload 7
    //   65: astore 5
    //   67: goto +66 -> 133
    //   70: aload 6
    //   72: astore 4
    //   74: aload 7
    //   76: astore 5
    //   78: aload 7
    //   80: invokestatic 303	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   83: ifne +50 -> 133
    //   86: aload 7
    //   88: ldc_w 327
    //   91: ldc_w 329
    //   94: invokevirtual 333	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: invokevirtual 336	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   100: astore 5
    //   102: aload 8
    //   104: ldc_w 310
    //   107: aload 5
    //   109: invokestatic 316	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   112: invokevirtual 308	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   115: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   118: pop
    //   119: aload 8
    //   121: ldc_w 322
    //   124: iconst_3
    //   125: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   128: pop
    //   129: aload 6
    //   131: astore 4
    //   133: new 338	com/tencent/gdtad/util/GdtDeviceInfoHelper$Params
    //   136: dup
    //   137: invokespecial 339	com/tencent/gdtad/util/GdtDeviceInfoHelper$Params:<init>	()V
    //   140: astore 6
    //   142: aload 6
    //   144: ldc_w 341
    //   147: putfield 343	com/tencent/gdtad/util/GdtDeviceInfoHelper$Params:a	Ljava/lang/String;
    //   150: invokestatic 349	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   153: aload 6
    //   155: invokestatic 354	com/tencent/gdtad/util/GdtDeviceInfoHelper:a	(Landroid/content/Context;Lcom/tencent/gdtad/util/GdtDeviceInfoHelper$Params;)Lcom/tencent/gdtad/util/GdtDeviceInfoHelper$Result;
    //   158: astore 6
    //   160: aload 6
    //   162: ifnull +51 -> 213
    //   165: aload 6
    //   167: getfield 359	com/tencent/gdtad/util/GdtDeviceInfoHelper$Result:a	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   170: ifnull +43 -> 213
    //   173: aload 8
    //   175: ldc_w 310
    //   178: aload 6
    //   180: getfield 359	com/tencent/gdtad/util/GdtDeviceInfoHelper$Result:a	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   183: getfield 364	tencent/gdt/qq_ad_get$QQAdGet$DeviceInfo:muid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   186: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   189: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   192: pop
    //   193: aload 8
    //   195: ldc_w 322
    //   198: aload 6
    //   200: getfield 359	com/tencent/gdtad/util/GdtDeviceInfoHelper$Result:a	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   203: getfield 372	tencent/gdt/qq_ad_get$QQAdGet$DeviceInfo:muid_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   206: invokevirtual 376	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   209: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   212: pop
    //   213: aload 8
    //   215: ldc_w 378
    //   218: invokestatic 382	com/tencent/biz/pubaccount/Advertisement/util/PublicAccountAdUtil:a	()I
    //   221: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   224: pop
    //   225: aload 8
    //   227: ldc_w 384
    //   230: aload_0
    //   231: invokestatic 389	com/tencent/biz/qqstory/utils/NetworkUtils:e	(Landroid/content/Context;)Ljava/lang/String;
    //   234: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   237: pop
    //   238: iconst_0
    //   239: istore_1
    //   240: invokestatic 391	com/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdDeviceInfoUtil:e	()I
    //   243: istore_2
    //   244: iload_2
    //   245: istore_1
    //   246: aload 8
    //   248: ldc_w 393
    //   251: iload_1
    //   252: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   255: pop
    //   256: aload 8
    //   258: ldc_w 395
    //   261: invokestatic 400	com/tencent/mobileqq/utils/DeviceInfoUtil:g	()Ljava/lang/String;
    //   264: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   267: pop
    //   268: aload 8
    //   270: ldc_w 402
    //   273: invokestatic 404	com/tencent/mobileqq/utils/DeviceInfoUtil:e	()Ljava/lang/String;
    //   276: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   279: pop
    //   280: aload 8
    //   282: ldc_w 406
    //   285: invokestatic 410	com/tencent/common/config/AppSetting:d	()I
    //   288: invokestatic 414	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   291: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   294: pop
    //   295: aload 8
    //   297: ldc_w 416
    //   300: invokestatic 421	com/dataline/util/DatalineMathUtil:a	()J
    //   303: invokestatic 424	com/dataline/util/DatalineMathUtil:a	(J)Ljava/lang/String;
    //   306: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   309: pop
    //   310: aload 8
    //   312: ldc_w 426
    //   315: ldc_w 428
    //   318: invokestatic 434	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   321: checkcast 428	com/tencent/mobileqq/kandian/base/utils/api/IRIJNetworkUtils
    //   324: aload_0
    //   325: invokeinterface 437 2 0
    //   330: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   333: pop
    //   334: aload 8
    //   336: ldc_w 439
    //   339: aload 5
    //   341: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   344: pop
    //   345: aload 8
    //   347: ldc_w 441
    //   350: iconst_2
    //   351: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   354: pop
    //   355: aload 8
    //   357: ldc_w 443
    //   360: invokestatic 446	com/tencent/mobileqq/utils/DeviceInfoUtil:w	()Ljava/lang/String;
    //   363: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   366: pop
    //   367: aload 8
    //   369: ldc_w 448
    //   372: invokestatic 450	com/tencent/mobileqq/utils/DeviceInfoUtil:u	()Ljava/lang/String;
    //   375: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   378: pop
    //   379: aload 8
    //   381: ldc_w 452
    //   384: invokestatic 454	com/tencent/mobileqq/utils/DeviceInfoUtil:t	()Ljava/lang/String;
    //   387: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   390: pop
    //   391: aload 8
    //   393: ldc_w 456
    //   396: aload 4
    //   398: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   401: pop
    //   402: aload_0
    //   403: ifnull +66 -> 469
    //   406: aload 8
    //   408: ldc_w 458
    //   411: aload_0
    //   412: invokevirtual 464	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   415: ldc_w 466
    //   418: invokestatic 472	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   421: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   424: pop
    //   425: aload 8
    //   427: areturn
    //   428: astore_0
    //   429: new 474	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 475	java/lang/StringBuilder:<init>	()V
    //   436: astore 4
    //   438: aload 4
    //   440: ldc_w 477
    //   443: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 4
    //   449: aload_0
    //   450: invokevirtual 484	java/lang/Exception:toString	()Ljava/lang/String;
    //   453: invokevirtual 481	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: ldc_w 486
    //   460: iconst_1
    //   461: aload 4
    //   463: invokevirtual 487	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 492	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: aload 8
    //   471: areturn
    //   472: astore_0
    //   473: aload_0
    //   474: invokevirtual 195	java/lang/Exception:printStackTrace	()V
    //   477: aconst_null
    //   478: areturn
    //   479: astore 6
    //   481: goto -235 -> 246
    //   484: astore 6
    //   486: goto -176 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	paramContext	Context
    //   239	13	1	i	int
    //   243	2	2	j	int
    //   24	2	3	bool	boolean
    //   34	428	4	localObject1	Object
    //   65	275	5	str1	String
    //   12	187	6	localObject2	Object
    //   479	1	6	localException1	Exception
    //   484	1	6	localException2	Exception
    //   17	70	7	str2	String
    //   7	463	8	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   406	425	428	java/lang/Exception
    //   9	25	472	java/lang/Exception
    //   29	63	472	java/lang/Exception
    //   78	129	472	java/lang/Exception
    //   133	160	472	java/lang/Exception
    //   165	213	472	java/lang/Exception
    //   213	238	472	java/lang/Exception
    //   246	295	472	java/lang/Exception
    //   310	402	472	java/lang/Exception
    //   429	469	472	java/lang/Exception
    //   240	244	479	java/lang/Exception
    //   295	310	484	java/lang/Exception
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAdvertisementInfo != null) {}
    try
    {
      localJSONObject.put("traceid", paramAdvertisementInfo.mAdTraceId);
      localJSONObject.put("pull_time", paramAdvertisementInfo.mAdFetchTime);
      localJSONObject.put("apurl", paramAdvertisementInfo.mAdApurl);
      localJSONObject.put("rl", paramAdvertisementInfo.mAdRl);
      localJSONObject.put("viewid", paramAdvertisementInfo.mAdViewId);
      localJSONObject.put("posid", paramAdvertisementInfo.mAdPosID);
      localJSONObject.put("channel_id", paramAdvertisementInfo.mChannelID);
      localJSONObject.put("kd_pos", paramAdvertisementInfo.mAdKdPos);
      localJSONObject.put("cl", paramAdvertisementInfo.mAdCl);
      localJSONObject.put("pos_layout", paramAdvertisementInfo.mAdPosLayout);
      localJSONObject.put("product_id", paramAdvertisementInfo.mAdProductId);
      localJSONObject.put("product_type", paramAdvertisementInfo.mAdProductType);
      localJSONObject.put("ad_type", paramAdvertisementInfo.mAdType);
      localJSONObject.put("price", paramAdvertisementInfo.mAdPrice);
      localJSONObject.put("customized_invoke_url", paramAdvertisementInfo.mAdCustomizedInvokeUrl);
      localJSONObject.put("corporation_name", paramAdvertisementInfo.mAdCorporationName);
      localJSONObject.put("corporate_image_name", paramAdvertisementInfo.mAdCorporateImageName);
      localJSONObject.put("corporate_logo", paramAdvertisementInfo.mAdCorporateLogo);
      localJSONObject.put("ad_uin", paramAdvertisementInfo.mAdUin);
      localJSONObject.put("ext", paramAdvertisementInfo.mAdExt);
      localJSONObject.put("video_url", paramAdvertisementInfo.mVideoVid);
      localJSONObject.put("cost_type", paramAdvertisementInfo.mAdCostType);
      localJSONObject.put("aid", paramAdvertisementInfo.mAdAid);
      localJSONObject.put("img", paramAdvertisementInfo.mAdImg);
      localJSONObject.put("img_s", paramAdvertisementInfo.mAdImgs);
      localJSONObject.put("txt", paramAdvertisementInfo.mAdTxt);
      localJSONObject.put("desc", paramAdvertisementInfo.mAdDesc);
      localJSONObject.put("ad_layout", paramAdvertisementInfo.mAdLayout);
      localJSONObject.put("ad_material_id", paramAdvertisementInfo.mAdMaterialId);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramAdvertisementInfo.mAlgorithmID);
      localJSONObject.put("algo_id", localStringBuilder.toString());
      localJSONObject.put("replay", paramAdvertisementInfo.replay);
      a(localJSONObject, paramAdvertisementInfo);
      int i = paramAdvertisementInfo.downloadState;
      if (i == 0) {
        localJSONObject.put("download_state", "0");
      } else if (paramAdvertisementInfo.downloadState == 3) {
        localJSONObject.put("download_state", "1");
      } else if (paramAdvertisementInfo.downloadState == 4) {
        localJSONObject.put("download_state", "2");
      } else if ((paramAdvertisementInfo.downloadState == 5) || (paramAdvertisementInfo.downloadState == 1)) {
        localJSONObject.put("download_state", "3");
      }
      if (paramVideoAdInfo != null)
      {
        if (localJSONObject.isNull("apurl")) {
          localJSONObject.put("apurl", paramVideoAdInfo.l);
        }
        localJSONObject.put("via", paramVideoAdInfo.L);
        localJSONObject.put("dis_channel", paramVideoAdInfo.M);
        localJSONObject.put("button_url", paramVideoAdInfo.N);
      }
      localJSONObject.put("cookie", NativeAdUtils.b());
      if (paramInt > 0)
      {
        localJSONObject.put("click_pos", paramInt);
        return localJSONObject;
      }
      if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.clickPos <= 0)) {
        break label679;
      }
      localJSONObject.put("click_pos", paramAdvertisementInfo.clickPos);
      return localJSONObject;
    }
    catch (JSONException paramAdvertisementInfo)
    {
      label675:
      label679:
      break label675;
    }
    paramAdvertisementInfo.printStackTrace();
    return localJSONObject;
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mCToSSwitch == 1))
    {
      if (QLog.isColorLevel())
      {
        paramVideoAdInfo = new StringBuilder();
        paramVideoAdInfo.append(" C2S AD_EXPOSURE: advertisementInfo = ");
        paramVideoAdInfo.append(paramAdvertisementInfo.toString());
        paramVideoAdInfo.append(" clickurl = ");
        paramVideoAdInfo.append(paramAdvertisementInfo.mCToSClickUrl);
        paramVideoAdInfo.append(" exposureUrl = ");
        paramVideoAdInfo.append(paramAdvertisementInfo.mCToSExposureUrl);
        QLog.d("NativeAdUtils", 2, paramVideoAdInfo.toString());
      }
      GdtC2SReporter.a(0, 1, (qq_ad_get.QQAdGetRsp.AdInfo)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramAdvertisementInfo));
      return;
    }
    if ((paramVideoAdInfo != null) && (paramVideoAdInfo.af == 1))
    {
      paramAdvertisementInfo = a(paramVideoAdInfo);
      if (paramAdvertisementInfo != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" C2S AD_EXPOSURE: advertisementInfo1 = ");
          localStringBuilder.append(paramAdvertisementInfo.toString());
          localStringBuilder.append(" videoAdInfo = ");
          localStringBuilder.append(paramVideoAdInfo.toString());
          localStringBuilder.append(" clickurl = ");
          localStringBuilder.append(paramAdvertisementInfo.mCToSClickUrl);
          localStringBuilder.append(" exposureUrl = ");
          localStringBuilder.append(paramAdvertisementInfo.mCToSExposureUrl);
          QLog.d("NativeAdUtils", 2, localStringBuilder.toString());
        }
        GdtC2SReporter.a(0, 1, (qq_ad_get.QQAdGetRsp.AdInfo)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramAdvertisementInfo));
      }
    }
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, ArrayList<String> paramArrayList1, String paramString, ArrayList<String> paramArrayList2, int paramInt)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mCToSSwitch == 1))
    {
      if (QLog.isColorLevel())
      {
        paramVideoAdInfo = new StringBuilder();
        paramVideoAdInfo.append(" C2S AD_CLICK: advertisementInfo = ");
        paramVideoAdInfo.append(paramAdvertisementInfo.toString());
        paramVideoAdInfo.append(" clickurl = ");
        paramVideoAdInfo.append(paramArrayList1);
        paramVideoAdInfo.append(paramString);
        paramVideoAdInfo.append(paramArrayList2);
        QLog.d("NativeAdUtils", 2, paramVideoAdInfo.toString());
      }
      GdtC2SReporter.a(paramInt, 1, (qq_ad_get.QQAdGetRsp.AdInfo)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramAdvertisementInfo));
      return;
    }
    if ((paramVideoAdInfo != null) && (paramVideoAdInfo.af == 1))
    {
      paramAdvertisementInfo = a(paramVideoAdInfo);
      if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mCToSSwitch == 1))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" C2S AD_CLICK: advertisementInfo1 = ");
          localStringBuilder.append(paramAdvertisementInfo.toString());
          localStringBuilder.append(" videoAdInfo = ");
          localStringBuilder.append(paramVideoAdInfo.toString());
          localStringBuilder.append(" clickurl = ");
          localStringBuilder.append(paramArrayList1);
          localStringBuilder.append(paramString);
          localStringBuilder.append(paramArrayList2);
          QLog.d("NativeAdUtils", 2, localStringBuilder.toString());
        }
        GdtC2SReporter.a(paramInt, 1, (qq_ad_get.QQAdGetRsp.AdInfo)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramAdvertisementInfo));
      }
    }
  }
  
  public static void a(AdReportData paramAdReportData)
  {
    if (paramAdReportData == null) {
      return;
    }
    AppInterface localAppInterface = f(paramAdReportData);
    if (localAppInterface == null) {
      return;
    }
    if (AdReportManager.b(paramAdReportData)) {
      return;
    }
    Context localContext = paramAdReportData.b();
    int i = paramAdReportData.c();
    int j = paramAdReportData.d();
    AdvertisementInfo localAdvertisementInfo = paramAdReportData.g();
    VideoAdInfo localVideoAdInfo = paramAdReportData.h();
    long l = paramAdReportData.i();
    String str1 = paramAdReportData.j();
    JSONObject localJSONObject1 = paramAdReportData.l();
    int k = paramAdReportData.m();
    JSONObject localJSONObject2 = paramAdReportData.n();
    Bundle localBundle = paramAdReportData.o();
    JSONObject localJSONObject3 = paramAdReportData.p();
    JSONObject localJSONObject4 = paramAdReportData.q();
    JSONObject localJSONObject5 = paramAdReportData.s();
    JSONObject localJSONObject6 = paramAdReportData.r();
    int m = paramAdReportData.e();
    boolean bool2 = paramAdReportData.f();
    String str2 = localAppInterface.getAccount();
    boolean bool1;
    if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mSoftAdType != 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ThreadManager.post(new RIJAdReportManager.1(paramAdReportData, localJSONObject3, str2, i, j, m, localContext, localAdvertisementInfo, localVideoAdInfo, k, localJSONObject1, localJSONObject2, localBundle, str1, l, localJSONObject4, localJSONObject6, localJSONObject5, bool1, localAppInterface, bool2), 5, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(paramQQAppInterface, "dc04719", "ad", "0", paramString1.toUpperCase(), paramString2.toUpperCase(), paramInt1, paramInt2, paramString3, paramString4, paramString5, paramString6);
  }
  
  static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("，");
      localStringBuilder.append(paramString2);
      QLog.d("NativeAdUtils", 2, localStringBuilder.toString());
    }
  }
  
  private static void a(JSONObject paramJSONObject, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramJSONObject != null) && (paramAdvertisementInfo != null) && (paramAdvertisementInfo.gameAdComData != null)) {
      try
      {
        paramJSONObject.put("pkg_name", paramAdvertisementInfo.gameAdComData.e);
        paramJSONObject.put("game_adtag", new JSONObject(paramAdvertisementInfo.gameAdComData.F).optString("ADTAG"));
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
    }
    if ((paramJSONObject != null) && (paramAdvertisementInfo != null) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdExtInfo))) {
      try
      {
        paramJSONObject.put("extra_data", paramAdvertisementInfo.mAdExtInfo);
        paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
        paramJSONObject.put("game_adtag", paramAdvertisementInfo.optString("game_adtag"));
        paramJSONObject.put("pkg_name", paramAdvertisementInfo.optString("game_pkg_name"));
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  @NotNull
  private static JSONObject b(Bundle paramBundle, String paramString, long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBundle != null)
    {
      localJSONObject.put("type_id", 2);
      localJSONObject.put("tel", paramBundle.getString("ad_complain_tel", ""));
      localJSONObject.put("txt", paramBundle.getString("ad_complain_txt", ""));
      return localJSONObject;
    }
    localJSONObject.put("type_id", 1);
    if (TextUtils.isEmpty(paramString))
    {
      localJSONObject.put("neg_ids", String.valueOf(paramLong));
      return localJSONObject;
    }
    localJSONObject.put("neg_ids", paramString);
    return localJSONObject;
  }
  
  @NotNull
  private static JSONObject b(JSONObject paramJSONObject, int paramInt, AdvertisementInfo paramAdvertisementInfo)
  {
    new JSONObject();
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    localJSONObject.put("type", InteraActionReportUtils.a(paramInt));
    localJSONObject.put("interaction_report_url", paramAdvertisementInfo.mAdInteractionReportUrl);
    localJSONObject.put("effect_url", paramAdvertisementInfo.mAdEffectUrl);
    return localJSONObject;
  }
  
  private static void b(int paramInt, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    if (paramInt == 2) {
      a(paramAdvertisementInfo, paramVideoAdInfo);
    }
    if (paramInt == 1) {
      b(paramAdvertisementInfo, paramVideoAdInfo, paramAdvertisementInfo.mCToSClickUrl, " exposureUrl = ", paramAdvertisementInfo.mCToSExposureUrl, 1);
    }
    if (paramInt == 27) {
      a(paramAdvertisementInfo, paramVideoAdInfo, paramAdvertisementInfo.mC2SVideoPlayUrl, " videoClickUrl = ", paramAdvertisementInfo.mC2SVideoPlayUrl, 2);
    }
  }
  
  private static void b(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, ArrayList<String> paramArrayList1, String paramString, ArrayList<String> paramArrayList2, int paramInt)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mCToSSwitch == 1))
    {
      if (QLog.isColorLevel())
      {
        paramVideoAdInfo = new StringBuilder();
        paramVideoAdInfo.append(" C2S AD_CLICK: advertisementInfo = ");
        paramVideoAdInfo.append(paramAdvertisementInfo.toString());
        paramVideoAdInfo.append(" clickurl = ");
        paramVideoAdInfo.append(paramArrayList1);
        paramVideoAdInfo.append(paramString);
        paramVideoAdInfo.append(paramArrayList2);
        QLog.d("NativeAdUtils", 2, paramVideoAdInfo.toString());
      }
      GdtC2SReporter.a(paramInt, 1, (qq_ad_get.QQAdGetRsp.AdInfo)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramAdvertisementInfo));
      return;
    }
    if ((paramVideoAdInfo != null) && (paramVideoAdInfo.af == 1))
    {
      paramAdvertisementInfo = a(paramVideoAdInfo);
      if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mCToSSwitch == 1))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" C2S AD_CLICK: advertisementInfo1 = ");
          localStringBuilder.append(paramAdvertisementInfo.toString());
          localStringBuilder.append(" videoAdInfo = ");
          localStringBuilder.append(paramVideoAdInfo.toString());
          localStringBuilder.append(" clickurl = ");
          localStringBuilder.append(paramArrayList1);
          localStringBuilder.append(paramString);
          localStringBuilder.append(paramArrayList2);
          QLog.d("NativeAdUtils", 2, localStringBuilder.toString());
        }
        GdtC2SReporter.a(paramInt, 1, (qq_ad_get.QQAdGetRsp.AdInfo)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramAdvertisementInfo));
      }
    }
  }
  
  public static void b(AdReportData paramAdReportData)
  {
    if (paramAdReportData == null) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = paramAdReportData.g();
    if (localAdvertisementInfo == null) {
      return;
    }
    if (AdReportUtil.b(paramAdReportData) != ActionEntity.Default) {
      return;
    }
    if (AdReportUtil.a(paramAdReportData) != ReportAction.EXPOSE) {
      return;
    }
    if (ReadInJoyAdUtils.l(paramAdReportData.g()))
    {
      if (paramAdReportData.d() != 37)
      {
        QLog.e("reportAmsExpose", 1, "fail，超级蒙层计费曝光，不是外蒙层");
        return;
      }
      if (paramAdReportData.t().intValue() != 2) {
        QLog.e("reportAmsExpose", 1, "fail，超级蒙层计费曝光，不是宽口径");
      }
    }
    else if (paramAdReportData.t().intValue() == 2)
    {
      QLog.e("reportAmsExpose", 1, "fail，正常广告计费曝光是严口径");
      return;
    }
    if ((localAdvertisementInfo.mAdvertisementExtInfo != null) && (localAdvertisementInfo.mAdvertisementExtInfo.o == 32))
    {
      if (TextUtils.isEmpty(localAdvertisementInfo.mAdApurl))
      {
        QLog.e("reportAmsExpose", 1, "aPurl report fail with empty url");
        return;
      }
      if (!localAdvertisementInfo.mAdApurl.startsWith("http"))
      {
        paramAdReportData = new StringBuilder();
        paramAdReportData.append("aPurl report fail with error url:");
        paramAdReportData.append(localAdvertisementInfo.mAdApurl);
        QLog.e("reportAmsExpose", 1, paramAdReportData.toString());
        return;
      }
      paramAdReportData = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apurl = ");
      localStringBuilder.append(localAdvertisementInfo.mAdApurl);
      paramAdReportData.d("reportAmsExpose", localStringBuilder.toString());
      paramAdReportData = new Bundle();
      HttpUtil.addCookie(paramAdReportData);
      try
      {
        paramAdReportData = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), localAdvertisementInfo.mAdApurl, "GET", null, paramAdReportData);
        if (paramAdReportData == null) {
          paramAdReportData = "";
        } else {
          paramAdReportData = new String(paramAdReportData);
        }
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("reportAmsExpose, result:", paramAdReportData);
        return;
      }
      catch (Throwable paramAdReportData)
      {
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("reportAmsExpose, e:", paramAdReportData.getMessage());
        return;
      }
    }
    QLog.e("reportAmsExpose", 1, "aPurl report fail, not ams ad");
  }
  
  private static void b(String paramString, AppInterface paramAppInterface, AdvertisementInfo paramAdvertisementInfo, AdReportData paramAdReportData, int paramInt)
  {
    WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
    localWebSsoRequestBody.data.set(paramString);
    paramString = new NewIntent(paramAppInterface.getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    paramString.putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_report_new");
    paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
    paramString.setObserver(new RIJAdReportManager.2(paramAdvertisementInfo, paramAdReportData, paramInt));
    paramAppInterface.startServlet(paramString);
  }
  
  private static boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo != null) && (paramAdvertisementInfo.mAdvertisementExtInfo.o == 32);
  }
  
  private static boolean b(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (ReadInJoyAdUtils.l(paramAdvertisementInfo)) {
      return true;
    }
    return paramInt == 37;
  }
  
  private static boolean c(AdvertisementInfo paramAdvertisementInfo)
  {
    if (!b(paramAdvertisementInfo)) {
      return false;
    }
    paramAdvertisementInfo = Aladdin.getConfig(449).getString("ad_ams_loose_report", "0");
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.equals("1"));
  }
  
  private static String e(AdReportData paramAdReportData)
  {
    if ((paramAdReportData != null) && (paramAdReportData.g() != null) && (paramAdReportData.g().originalExposureUrl != null)) {
      return paramAdReportData.g().originalExposureUrl.replace("__VIEW_PERCENT__", "1").replace("__VIEW_TIME__", "0").replace("__ACTION_TYPE__", "0");
    }
    return null;
  }
  
  @Nullable
  private static AppInterface f(AdReportData paramAdReportData)
  {
    AppInterface localAppInterface = paramAdReportData.a();
    paramAdReportData = localAppInterface;
    if (localAppInterface == null)
    {
      paramAdReportData = localAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        paramAdReportData = localAppInterface;
        if ((localAppRuntime instanceof QQAppInterface)) {
          paramAdReportData = (QQAppInterface)localAppRuntime;
        }
      }
    }
    return paramAdReportData;
  }
  
  private static boolean g(AdReportData paramAdReportData)
  {
    int i = paramAdReportData.d();
    int j = paramAdReportData.c();
    AdvertisementInfo localAdvertisementInfo = paramAdReportData.g();
    if (i != 27)
    {
      if (j == 26) {
        return true;
      }
      if ((ReadInJoyAdUtils.l(localAdvertisementInfo)) && (j == 2))
      {
        if (AdReportUtil.b(paramAdReportData) == ActionEntity.InnerSuperMask)
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoySuperMaskAd", "inner mask, do not report c2s");
          return true;
        }
        if (paramAdReportData.t().intValue() == 1)
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoySuperMaskAd", "strict mask expose, do not report c2s");
          return true;
        }
        return false;
      }
      return (localAdvertisementInfo != null) && ((localAdvertisementInfo.clickPos == 39) || (localAdvertisementInfo.clickPos == 40) || (paramAdReportData.m() == 40) || (paramAdReportData.m() == 39));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.RIJAdReportManager
 * JD-Core Version:    0.7.0.1
 */