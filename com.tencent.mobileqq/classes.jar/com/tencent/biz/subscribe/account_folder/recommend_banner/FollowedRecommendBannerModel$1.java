package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetRecommendUserListRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.beans.RecommendInfoItem;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class FollowedRecommendBannerModel$1
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetRecommendUserListRsp>
{
  FollowedRecommendBannerModel$1(FollowedRecommendBannerModel paramFollowedRecommendBannerModel) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetRecommendUserListRsp paramStGetRecommendUserListRsp)
  {
    if (paramBoolean)
    {
      SLog.c("FollowedRecommendBanner", "sendRequest GetRecommendUserList success");
      if (paramStGetRecommendUserListRsp != null)
      {
        paramBaseRequest = new ArrayList();
        if (paramStGetRecommendUserListRsp.vecUser.get() != null)
        {
          paramString = paramStGetRecommendUserListRsp.vecUser.get().iterator();
          while (paramString.hasNext()) {
            paramBaseRequest.add(new RecommendInfoItem((CertifiedAccountMeta.StUser)paramString.next()));
          }
        }
        FollowedRecommendBannerModel.a(this.a, (COMM.StCommonExt)paramStGetRecommendUserListRsp.extInfo.get());
        int i = paramStGetRecommendUserListRsp.isFinish.get();
        paramBoolean = true;
        if (i != 1) {
          paramBoolean = false;
        }
        ThreadManager.getUIHandler().post(new FollowedRecommendBannerModel.1.1(this, paramBaseRequest, paramBoolean));
      }
      VSReporter.a("subscribe_personal_detail_page_request", VSReporter.a(0L, System.currentTimeMillis() - FollowedRecommendBannerModel.a(this.a)));
      return;
    }
    SLog.c("FollowedRecommendBanner", "sendRequest GetRecommendUserList error");
    VSReporter.a("subscribe_personal_detail_page_request", VSReporter.a(paramLong, System.currentTimeMillis() - FollowedRecommendBannerModel.a(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerModel.1
 * JD-Core Version:    0.7.0.1
 */