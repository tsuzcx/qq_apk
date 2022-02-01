package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.IFetchDataModule;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.WSFetchDataModuleFactory;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.WeishiManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.web.api.IVasAdvWeb;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class WSVerticalDataManager
{
  private static String a = "";
  private volatile String b = "";
  private volatile String c = "";
  private volatile String d = "";
  
  private WSVerticalDataManager.ResponseModel a(WSRequest<stSimpleGetFeedListRsp> paramWSRequest, stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, RspHeaderBean paramRspHeaderBean, boolean paramBoolean1, IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener, boolean paramBoolean2, Object paramObject, long paramLong)
  {
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("请求播放页（推荐)耗时：");
    localStringBuilder.append(l - paramLong);
    localStringBuilder.append("毫秒");
    WSLog.a("weishi-beacon", localStringBuilder.toString());
    if (paramBoolean1)
    {
      int i;
      if (paramWSRequest != null) {
        i = paramWSRequest.getRequestScene();
      } else {
        i = 2;
      }
      a(paramstSimpleGetFeedListRsp, paramIFetchDataRspListener, i);
    }
    this.c = paramstSimpleGetFeedListRsp.attach_info;
    this.b = paramstSimpleGetFeedListRsp.session;
    if (!TextUtils.isEmpty(paramstSimpleGetFeedListRsp.gdt_args))
    {
      a(paramstSimpleGetFeedListRsp.gdt_args);
      b(paramstSimpleGetFeedListRsp.gdt_args);
    }
    if (paramRspHeaderBean != null) {
      WSRecommendReportManager.a().a(paramstSimpleGetFeedListRsp.trace_id, paramRspHeaderBean.a);
    }
    paramWSRequest = paramstSimpleGetFeedListRsp.feeds;
    a(paramWSRequest);
    paramWSRequest = WSVerticalDataUtil.a(paramWSRequest, false);
    paramstSimpleGetFeedListRsp = new StringBuilder();
    paramstSimpleGetFeedListRsp.append("[WSVerticalDataManager.java][onTaskResponse] itemDataList size:");
    paramstSimpleGetFeedListRsp.append(paramWSRequest.size());
    paramstSimpleGetFeedListRsp.append(", isRefresh:");
    paramstSimpleGetFeedListRsp.append(paramBoolean2);
    paramstSimpleGetFeedListRsp.append(", isFirst:");
    paramstSimpleGetFeedListRsp.append(paramBoolean1);
    paramstSimpleGetFeedListRsp.append(", mAttachInfo:");
    paramstSimpleGetFeedListRsp.append(this.c);
    paramstSimpleGetFeedListRsp.append(", mLastSession:");
    paramstSimpleGetFeedListRsp.append(this.b);
    paramstSimpleGetFeedListRsp.append(", gdtArgs:");
    paramstSimpleGetFeedListRsp.append(a);
    WSLog.e("WSVerticalDataManagerLog", paramstSimpleGetFeedListRsp.toString());
    return new WSVerticalDataManager.ResponseModel(paramWSRequest, paramBoolean2, paramBoolean1, paramObject);
  }
  
  public static WSVerticalDataManager a()
  {
    return WSVerticalDataManager.SingletonHolder.a();
  }
  
  private void a(stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener, int paramInt)
  {
    if ((paramIFetchDataRspListener instanceof AbsWSVerticalPagePresenter))
    {
      WSVerticalPageContract.View localView = ((AbsWSVerticalPagePresenter)paramIFetchDataRspListener).z();
      paramIFetchDataRspListener = null;
      if ((localView instanceof WSVerticalPageFragment)) {
        paramIFetchDataRspListener = (WSVerticalPageFragment)localView;
      }
      if ((paramIFetchDataRspListener != null) && (paramIFetchDataRspListener.getBaseActivity() != null) && (!paramIFetchDataRspListener.getBaseActivity().isFinishing())) {
        WSGlobalConfig.a().a(paramInt, paramstSimpleGetFeedListRsp.config);
      }
    }
  }
  
  private void a(WSVerticalDataManager.ResponseModel paramResponseModel, IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    if (paramResponseModel == null) {
      return;
    }
    if (paramIFetchDataRspListener != null) {
      paramIFetchDataRspListener.a(paramResponseModel.a, paramResponseModel.b, paramResponseModel.c, paramResponseModel.d);
    }
  }
  
  public static void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setGdtArgs start = ");
    ((StringBuilder)localObject).append(a);
    GdtLog.a("WSVerticalDataManagerLog", ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject();
        paramString.put("gdt_pageindex", 0);
        a = paramString.toString();
        localObject = LocalMultiProcConfig.getString("cache_key_gdt_args", "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setGdtArgs getDeviceInfo ok");
          localStringBuilder.append(a);
          GdtLog.a("WSVerticalDataManagerLog", localStringBuilder.toString());
          b(new JSONObject((String)localObject), paramString);
          return;
        }
        paramString = new StringBuilder();
        paramString.append("setGdtArgs deviceInfo is null ");
        paramString.append(a);
        GdtLog.a("WSVerticalDataManagerLog", paramString.toString());
      }
      catch (JSONException paramString)
      {
        GdtLog.d("WSVerticalDataManagerLog", "setGdtArgs", paramString);
      }
    } else {
      a = paramString;
    }
    ThreadManager.executeOnSubThread(new WSVerticalDataManager.2());
  }
  
  private void a(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    if (CollectionUtils.isEmpty(paramArrayList)) {
      return;
    }
    WeishiManager.a((stSimpleMetaFeed)paramArrayList.get(0));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) || (paramBoolean1))
    {
      this.c = "";
      a = "";
      this.b = "";
      this.d = "";
    }
    if (TextUtils.isEmpty(a)) {
      a("");
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, WSServiceErrorInfo paramWSServiceErrorInfo, IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    if (paramIFetchDataRspListener != null) {
      paramIFetchDataRspListener.a(paramWSServiceErrorInfo.a(), paramWSServiceErrorInfo.b(), paramBoolean1, paramBoolean2);
    }
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("h5_render_param");
        if (paramString == null) {
          break label118;
        }
        paramString = paramString.optString("h5_url");
        this.d = paramString;
        paramString = new StringBuilder();
        paramString.append("h5 url from gdt_args: ");
        paramString.append(this.d);
        WSLog.f("WSVerticalDataManagerLog", paramString.toString());
        if (!TextUtils.isEmpty(this.d))
        {
          ((IVasAdvWeb)QRoute.api(IVasAdvWeb.class)).initWebView();
          return;
        }
      }
      catch (Exception paramString)
      {
        this.d = "";
        GdtLog.d("WSVerticalDataManagerLog", "Error when get conf from gdt_args", paramString);
      }
      return;
      label118:
      paramString = "";
    }
  }
  
  private static void b(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (paramJSONObject1 != null)
    {
      if (paramJSONObject2 == null) {
        return;
      }
      try
      {
        paramJSONObject1.put("deep_link_version", 1);
        paramJSONObject2.put("device_info", paramJSONObject1);
        a = paramJSONObject2.toString();
        return;
      }
      catch (JSONException paramJSONObject1)
      {
        GdtLog.d("WSVerticalDataManagerLog", "onResult", paramJSONObject1);
      }
    }
  }
  
  public void a(WSVerticalRequestParams paramWSVerticalRequestParams, IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean, IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    if (!paramBoolean) {
      return;
    }
    WSFetchDataModuleFactory.a().a(paramIFetchDataRspListener);
  }
  
  public String b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager
 * JD-Core Version:    0.7.0.1
 */