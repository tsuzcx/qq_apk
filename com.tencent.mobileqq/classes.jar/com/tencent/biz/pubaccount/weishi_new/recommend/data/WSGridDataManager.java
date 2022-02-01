package com.tencent.biz.pubaccount.weishi_new.recommend.data;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.WSRecommendRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class WSGridDataManager
{
  private final WSGridDataFilter jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSGridDataFilter = new WSGridDataFilter();
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String b = "";
  
  @NotNull
  private ServiceCallback<stSimpleGetFeedListRsp, WSGridDataManager.WSGridRspModel> a(IWSGridRspListener paramIWSGridRspListener, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, long paramLong)
  {
    return new WSGridDataManager.1(this, paramBoolean2, paramBoolean1, paramString, paramIWSGridRspListener, paramBoolean3, paramLong);
  }
  
  private WSGridDataManager.WSGridRspModel a(stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, RspHeaderBean paramRspHeaderBean, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    WSLog.e("WSGridDataManagerLog", "[WSGridDataManager.java][handleFeedResponse] successOnSubThread!");
    WSGridDataManager.WSGridRspModel localWSGridRspModel = new WSGridDataManager.WSGridRspModel(null);
    if ((paramstSimpleGetFeedListRsp.feeds != null) && (paramstSimpleGetFeedListRsp.feeds.size() > 0))
    {
      this.jdField_a_of_type_JavaLangString = paramstSimpleGetFeedListRsp.attach_info;
      this.b = paramstSimpleGetFeedListRsp.session;
      if (paramRspHeaderBean != null)
      {
        WSRecommendReportManager.a().a(paramstSimpleGetFeedListRsp.trace_id, paramRspHeaderBean.a);
        paramRspHeaderBean = new StringBuilder();
        paramRspHeaderBean.append("[WSGridDataManager.java][handleFeedResponseForSuccess] onLoadDataSuccess traceId = ");
        paramRspHeaderBean.append(paramstSimpleGetFeedListRsp.trace_id);
        WSLog.e("WSGridDataManagerLog", paramRspHeaderBean.toString());
      }
      if (paramBoolean1) {
        WSGlobalConfig.a().a(1, paramstSimpleGetFeedListRsp.config);
      }
      paramRspHeaderBean = paramstSimpleGetFeedListRsp.feeds;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSGridDataFilter.a(paramBoolean1, paramBoolean2, paramRspHeaderBean, paramString);
      WeishiUtils.a(paramRspHeaderBean);
      localWSGridRspModel.a(paramRspHeaderBean);
      localWSGridRspModel.a(paramstSimpleGetFeedListRsp.is_finished);
      return localWSGridRspModel;
    }
    WSLog.d("WSGridDataManagerLog", "[WSGridDataManager.java][handleFeedResponse] feeds.size(): 0");
    return localWSGridRspModel;
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) || (paramBoolean1))
    {
      this.jdField_a_of_type_JavaLangString = "";
      this.b = "";
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(WSGridRequestParams paramWSGridRequestParams, IWSGridRspListener paramIWSGridRspListener)
  {
    boolean bool1 = paramWSGridRequestParams.a();
    boolean bool2 = paramWSGridRequestParams.b();
    boolean bool3 = paramWSGridRequestParams.c();
    long l = paramWSGridRequestParams.a();
    String str1 = paramWSGridRequestParams.a();
    String str2 = paramWSGridRequestParams.c();
    String str3 = paramWSGridRequestParams.b();
    ArrayList localArrayList = paramWSGridRequestParams.a();
    paramWSGridRequestParams = paramWSGridRequestParams.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridDataManager.java][fetchGridData] isFirstFromService:");
    localStringBuilder.append(bool2);
    localStringBuilder.append(", contentFeedIds:");
    localStringBuilder.append(localArrayList);
    localStringBuilder.append(", exposeFeedList.size:");
    localStringBuilder.append(paramWSGridRequestParams.size());
    WSLog.a("WSGridDataManagerLog", localStringBuilder.toString());
    a(bool1, bool2);
    WSNetService.a(new WSRecommendRequest(this.jdField_a_of_type_JavaLangString, (byte)bool1, (byte)bool2, localArrayList, 1, "", str2, this.b, str3, str1, paramWSGridRequestParams)).a(a(paramIWSGridRspListener, bool1, bool2, bool3, str1, l));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.WSGridDataManager
 * JD-Core Version:    0.7.0.1
 */