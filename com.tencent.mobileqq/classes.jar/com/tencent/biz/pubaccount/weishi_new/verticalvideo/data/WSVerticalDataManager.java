package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.WSRecommendRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.IFetchDataModule;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.WSFetchDataModuleFactory;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.vip.web.VasAdvWebManager;
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
  
  private WSVerticalDataManager.ResponseModel a(WSRequest<stSimpleGetFeedListRsp> paramWSRequest, stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, RspHeaderBean paramRspHeaderBean, boolean paramBoolean1, IVerticalRspListener paramIVerticalRspListener, boolean paramBoolean2, Object paramObject, long paramLong)
  {
    long l = System.currentTimeMillis();
    WSLog.a("weishi-beacon", "请求播放页（推荐)耗时：" + (l - paramLong) + "毫秒");
    if (paramBoolean1) {
      if (paramWSRequest == null) {
        break label236;
      }
    }
    label236:
    for (int i = paramWSRequest.getRequestScene();; i = 2)
    {
      a(paramstSimpleGetFeedListRsp, paramIVerticalRspListener, i);
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
      WSLog.e("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][onTaskResponse] itemDataList size:" + paramWSRequest.size() + ", isRefresh:" + paramBoolean2 + ", isFirst:" + paramBoolean1 + ", mAttachInfo:" + this.c + ", mLastSession:" + this.b + ", gdtArgs:" + a);
      return new WSVerticalDataManager.ResponseModel(paramWSRequest, paramBoolean2, paramBoolean1, paramObject);
    }
  }
  
  public static WSVerticalDataManager a()
  {
    return WSVerticalDataManager.SingletonHolder.a();
  }
  
  private void a(stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, IVerticalRspListener paramIVerticalRspListener, int paramInt)
  {
    if ((paramIVerticalRspListener instanceof AbsWSVerticalPagePresenter))
    {
      paramIVerticalRspListener = ((AbsWSVerticalPagePresenter)paramIVerticalRspListener).a();
      if (!(paramIVerticalRspListener instanceof WSVerticalPageFragment)) {
        break label60;
      }
    }
    label60:
    for (paramIVerticalRspListener = (WSVerticalPageFragment)paramIVerticalRspListener;; paramIVerticalRspListener = null)
    {
      if ((paramIVerticalRspListener != null) && (paramIVerticalRspListener.getActivity() != null) && (!paramIVerticalRspListener.getActivity().isFinishing())) {
        WSGlobalConfig.a().a(paramInt, paramstSimpleGetFeedListRsp.config);
      }
      return;
    }
  }
  
  private void a(WSVerticalDataManager.ResponseModel paramResponseModel, IVerticalRspListener paramIVerticalRspListener)
  {
    if (paramResponseModel == null) {}
    do
    {
      return;
      if ((paramResponseModel.b) && (WSUserAuthDialog.a())) {
        WSSimpleEventBus.a().a(new WSUserAuthEvent());
      }
    } while (paramIVerticalRspListener == null);
    paramIVerticalRspListener.a(paramResponseModel.jdField_a_of_type_JavaUtilList, paramResponseModel.jdField_a_of_type_Boolean, paramResponseModel.b, paramResponseModel.jdField_a_of_type_JavaLangObject);
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject();
        paramString.put("gdt_pageindex", 0);
        a = paramString.toString();
        String str = LocalMultiProcConfig.getString("cache_key_gdt_args", "");
        if (!TextUtils.isEmpty(str))
        {
          b(new JSONObject(str), paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        GdtLog.d("WSVerticalDataManagerLog", "setGdtArgs", paramString);
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new WSVerticalDataManager.2());
      return;
      a = paramString;
    }
  }
  
  private void a(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    if (CollectionUtils.isEmpty(paramArrayList)) {
      return;
    }
    WeishiManager.b((stSimpleMetaFeed)paramArrayList.get(0));
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
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, WSServiceErrorInfo paramWSServiceErrorInfo, IVerticalRspListener paramIVerticalRspListener)
  {
    if (paramIVerticalRspListener != null) {
      paramIVerticalRspListener.a(paramWSServiceErrorInfo.a(), paramWSServiceErrorInfo.a(), paramBoolean1, paramBoolean2);
    }
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("h5_render_param");
        if (paramString != null) {}
        for (paramString = paramString.optString("h5_url");; paramString = "")
        {
          this.d = paramString;
          WSLog.f("WSVerticalDataManagerLog", "h5 url from gdt_args: " + this.d);
          if (TextUtils.isEmpty(this.d)) {
            break;
          }
          VasAdvWebManager.a.b();
          return;
        }
        return;
      }
      catch (Exception paramString)
      {
        this.d = "";
        GdtLog.d("WSVerticalDataManagerLog", "Error when get conf from gdt_args", paramString);
      }
    }
  }
  
  private static void b(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null)) {
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
  
  public String a()
  {
    return this.d;
  }
  
  public void a(WSVerticalRequestParams paramWSVerticalRequestParams, IVerticalRspListener paramIVerticalRspListener)
  {
    int i = paramWSVerticalRequestParams.a();
    boolean bool1 = paramWSVerticalRequestParams.a();
    boolean bool2 = paramWSVerticalRequestParams.b();
    String str1 = paramWSVerticalRequestParams.a();
    String str2 = paramWSVerticalRequestParams.b();
    Object localObject = paramWSVerticalRequestParams.a();
    ArrayList localArrayList = paramWSVerticalRequestParams.a();
    long l = System.currentTimeMillis();
    a(bool1, bool2);
    WSLog.d("WSVerticalDataManagerLog", "[WSVerticalDataManager.java][fetchVerticalListData] " + paramWSVerticalRequestParams + ", attachInfo:" + this.c + ", lastSession:" + this.b + ", gdtArgs:" + a);
    byte b1;
    if (bool1)
    {
      paramWSVerticalRequestParams = "";
      if (!bool1) {
        break label200;
      }
      b1 = 1;
      label132:
      if (!bool2) {
        break label205;
      }
    }
    label200:
    label205:
    for (byte b2 = 1;; b2 = 0)
    {
      WSNetService.a(new WSRecommendRequest(paramWSVerticalRequestParams, b1, b2, localArrayList, i, a, "", this.b, str2, str1)).a(new WSVerticalDataManager.1(this, bool2, paramIVerticalRspListener, bool1, localObject, l));
      return;
      paramWSVerticalRequestParams = this.c;
      break;
      b1 = 0;
      break label132;
    }
  }
  
  public void a(boolean paramBoolean, IVerticalRspListener paramIVerticalRspListener)
  {
    if (!paramBoolean) {
      return;
    }
    WSFetchDataModuleFactory.a().a(paramIVerticalRspListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager
 * JD-Core Version:    0.7.0.1
 */