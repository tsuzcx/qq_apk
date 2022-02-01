package com.tencent.biz.subscribe.account_folder.top_pannel;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetRecommendUserListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Collections;
import mqq.os.MqqHandler;

class TopPanelPresenter$1
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetRecommendUserListRsp>
{
  TopPanelPresenter$1(TopPanelPresenter paramTopPanelPresenter, long paramLong) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetRecommendUserListRsp paramStGetRecommendUserListRsp)
  {
    if (paramBoolean)
    {
      paramBaseRequest = new StringBuilder();
      paramBaseRequest.append("sendRequest GetRecommendUserList success  time ==> ");
      paramBaseRequest.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      SLog.c("VSNetworkHelper", paramBaseRequest.toString());
      if (paramStGetRecommendUserListRsp != null)
      {
        paramBaseRequest = TopPanelPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelPresenter, paramStGetRecommendUserListRsp);
        TopPanelPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelPresenter, (COMM.StCommonExt)paramStGetRecommendUserListRsp.extInfo.get());
        int i = paramStGetRecommendUserListRsp.isFinish.get();
        paramBoolean = true;
        if (i != 1) {
          paramBoolean = false;
        }
        Collections.shuffle(paramBaseRequest);
        ThreadManager.getUIHandler().post(new TopPanelPresenter.1.1(this, paramStGetRecommendUserListRsp, paramBaseRequest, paramBoolean));
      }
    }
    else
    {
      SLog.c(TopPanelPresenter.a(), "sendRequest GetRecommendUserList error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelPresenter.1
 * JD-Core Version:    0.7.0.1
 */