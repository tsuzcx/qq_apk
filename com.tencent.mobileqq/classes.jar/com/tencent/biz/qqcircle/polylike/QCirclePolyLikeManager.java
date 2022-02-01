package com.tencent.biz.qqcircle.polylike;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestCall;
import com.tencent.biz.qqcircle.richframework.sender.iml.QCircleRequestSender;
import com.tencent.biz.qqcircle.richframework.sender.iml.fake.QCirclePraiseFakeInterceptor;
import com.tencent.biz.qqcircle.richframework.sender.iml.req.QCirclePolyLikeMergeReqInterceptor;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.BaseCall;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import java.util.List;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class QCirclePolyLikeManager
{
  public static QQCircleFeedBase.StPolyLike a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return null;
    }
    QQCircleFeedBase.StLikeBusiData localStLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
    try
    {
      localStLikeBusiData.mergeFrom(((FeedCloudMeta.StLike)paramStFeed.likeInfo.get()).busiData.get().toByteArray());
      paramStFeed = a(localStLikeBusiData);
      return paramStFeed;
    }
    catch (InvalidProtocolBufferMicroException paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
    return null;
  }
  
  public static QQCircleFeedBase.StPolyLike a(String paramString)
  {
    Object localObject = QCirclePolyLikeInfoManger.a().b();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      if (((QQCircleFeedBase.StPolyLike)((List)localObject).get(i)).polyLikeID.get().equals(paramString)) {
        return a((QQCircleFeedBase.StPolyLike)((List)localObject).get(i));
      }
      i += 1;
    }
    localObject = new QQCircleFeedBase.StPolyLike();
    ((QQCircleFeedBase.StPolyLike)localObject).polyLikeID.set(paramString);
    return localObject;
  }
  
  public static QQCircleFeedBase.StPolyLike a(QQCircleFeedBase.StLikeBusiData paramStLikeBusiData)
  {
    if (paramStLikeBusiData == null) {
      return null;
    }
    paramStLikeBusiData = paramStLikeBusiData.likeIDs.get();
    if (paramStLikeBusiData != null)
    {
      if (paramStLikeBusiData.size() == 0) {
        return null;
      }
      String str = (String)paramStLikeBusiData.get(0);
      if (paramStLikeBusiData.contains("6"))
      {
        paramStLikeBusiData = "6";
      }
      else if (paramStLikeBusiData.contains("1"))
      {
        paramStLikeBusiData = "1";
      }
      else if (paramStLikeBusiData.contains("10"))
      {
        paramStLikeBusiData = "10";
      }
      else if (str.contains("206008"))
      {
        paramStLikeBusiData = "206008";
      }
      else
      {
        paramStLikeBusiData = str;
        if (str.contains("205993")) {
          paramStLikeBusiData = "205993";
        }
      }
      return a(paramStLikeBusiData);
    }
    return null;
  }
  
  public static QQCircleFeedBase.StPolyLike a(QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    QQCircleFeedBase.StPolyLike localStPolyLike = new QQCircleFeedBase.StPolyLike();
    if (paramStPolyLike == null) {
      return localStPolyLike;
    }
    try
    {
      localStPolyLike.mergeFrom(paramStPolyLike.toByteArray());
      return localStPolyLike;
    }
    catch (InvalidProtocolBufferMicroException paramStPolyLike)
    {
      paramStPolyLike.printStackTrace();
    }
    return localStPolyLike;
  }
  
  public static void a(FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean)
  {
    if (!HostNetworkUtils.isNetworkAvailable())
    {
      QCircleToast.a(HardCodeUtil.a(2131892107), 0);
      return;
    }
    try
    {
      paramStFeed = b(paramStFeed, paramBoolean);
    }
    catch (InvalidProtocolBufferMicroException paramStFeed)
    {
      paramStFeed.printStackTrace();
      paramStFeed = null;
    }
    if (paramStFeed == null) {
      return;
    }
    QCircleRequestSender.a().b().b(new QCirclePraiseFakeInterceptor(true, null)).a(new QCirclePolyLikeMergeReqInterceptor()).a(paramStFeed).a(new QCirclePolyLikeManager.1(paramBoolean)).a();
  }
  
  public static int b(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return 0;
    }
    QQCircleFeedBase.StLikeBusiData localStLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
    try
    {
      localStLikeBusiData.mergeFrom(((FeedCloudMeta.StLike)paramStFeed.likeInfo.get()).busiData.get().toByteArray());
      int i = b(localStLikeBusiData);
      return i;
    }
    catch (InvalidProtocolBufferMicroException paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
    return 0;
  }
  
  public static int b(QQCircleFeedBase.StLikeBusiData paramStLikeBusiData)
  {
    int k = 0;
    int j = 0;
    int i = k;
    if (paramStLikeBusiData != null)
    {
      paramStLikeBusiData = paramStLikeBusiData.likeIDs.get();
      i = k;
      if (paramStLikeBusiData != null)
      {
        i = j;
        if (paramStLikeBusiData.contains("10")) {
          i = 1;
        }
        j = i;
        if (paramStLikeBusiData.contains("1")) {
          j = i + 1;
        }
        i = j;
        if (paramStLikeBusiData.contains("6")) {
          i = j + 1;
        }
      }
    }
    return i;
  }
  
  private static QCircleDoLikeRequest b(FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.equals(paramString, "205993")) && (!TextUtils.equals(paramString, "206008"));
  }
  
  public static boolean c(FeedCloudMeta.StFeed paramStFeed)
  {
    boolean bool;
    if ((paramStFeed != null) && (paramStFeed.opMask2 != null) && (paramStFeed.opMask2.get().contains(Integer.valueOf(15)))) {
      bool = true;
    } else {
      bool = false;
    }
    paramStFeed = new StringBuilder();
    paramStFeed.append("openCancelLike:");
    paramStFeed.append(bool);
    QLog.d("PL-QCirclePolyLikeManager", 1, paramStFeed.toString());
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeManager
 * JD-Core Version:    0.7.0.1
 */