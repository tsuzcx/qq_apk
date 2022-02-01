package com.tencent.biz.pubaccount.weishi_new.recommend.data;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;

class WSGridDataManager$1
  extends ServiceCallback<stSimpleGetFeedListRsp, WSGridDataManager.WSGridRspModel>
{
  WSGridDataManager$1(WSGridDataManager paramWSGridDataManager, boolean paramBoolean1, boolean paramBoolean2, String paramString, IWSGridRspListener paramIWSGridRspListener, boolean paramBoolean3, long paramLong) {}
  
  protected WSGridDataManager.WSGridRspModel a(WSRequest<stSimpleGetFeedListRsp> paramWSRequest, stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, RspHeaderBean paramRspHeaderBean)
  {
    return WSGridDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSGridDataManager, paramstSimpleGetFeedListRsp, paramRspHeaderBean, this.jdField_a_of_type_Boolean, this.b, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(WSServiceErrorInfo paramWSServiceErrorInfo) {}
  
  public void a(WSGridDataManager.WSGridRspModel paramWSGridRspModel)
  {
    super.a(paramWSGridRspModel);
    WSGridDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSGridDataManager, paramWSGridRspModel.a());
    if ((paramWSGridRspModel.a() != null) && (paramWSGridRspModel.a().size() > 0))
    {
      IWSGridRspListener localIWSGridRspListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataIWSGridRspListener;
      if (localIWSGridRspListener != null) {
        localIWSGridRspListener.a(WSGridDataManager.WSGridRspModel.a(paramWSGridRspModel), this.jdField_a_of_type_Boolean, this.b, this.c, this.jdField_a_of_type_Long);
      }
    }
    else
    {
      b(new WSServiceErrorInfo(0, HardCodeUtil.a(2131716480)));
    }
  }
  
  public void b(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    super.b(paramWSServiceErrorInfo);
    IWSGridRspListener localIWSGridRspListener = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataIWSGridRspListener;
    if (localIWSGridRspListener != null) {
      localIWSGridRspListener.a(paramWSServiceErrorInfo.a(), paramWSServiceErrorInfo.a(), this.jdField_a_of_type_Boolean, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.WSGridDataManager.1
 * JD-Core Version:    0.7.0.1
 */