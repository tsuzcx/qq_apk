package com.tencent.biz.subscribe.account_folder.top_pannel;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetRecommendUserListRsp;
import com.tencent.mobileqq.pb.PBUInt32Field;
import common.config.service.QzoneConfig;
import java.util.List;

class TopPanelPresenter$1$1
  implements Runnable
{
  TopPanelPresenter$1$1(TopPanelPresenter.1 param1, CertifiedAccountRead.StGetRecommendUserListRsp paramStGetRecommendUserListRsp, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    TopPanelContract.View localView = TopPanelPresenter.a(this.d.b);
    CertifiedAccountMeta.StEntry localStEntry;
    if (((QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverEntryEnable", 1) & (QzoneConfig.getInstance().getConfig("qqsubscribe", "JumpToNewServiceAccount", 1) ^ 0xFFFFFFFF)) == 1) && (this.a.entry.has())) {
      localStEntry = (CertifiedAccountMeta.StEntry)this.a.entry.get();
    } else {
      localStEntry = null;
    }
    if (localView != null)
    {
      localView.a(localStEntry, this.b, this.c);
      int i = this.a.noticeCount.get();
      if (i > 0)
      {
        localView.a(i);
        return;
      }
      localView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelPresenter.1.1
 * JD-Core Version:    0.7.0.1
 */