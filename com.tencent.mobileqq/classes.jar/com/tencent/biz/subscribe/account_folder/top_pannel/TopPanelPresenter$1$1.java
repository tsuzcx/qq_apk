package com.tencent.biz.subscribe.account_folder.top_pannel;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetRecommendUserListRsp;
import com.tencent.mobileqq.pb.PBUInt32Field;
import common.config.service.QzoneConfig;
import java.util.List;
import ycz;
import yda;
import ydb;

public class TopPanelPresenter$1$1
  implements Runnable
{
  public TopPanelPresenter$1$1(ydb paramydb, CertifiedAccountRead.StGetRecommendUserListRsp paramStGetRecommendUserListRsp, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    ycz localycz = yda.a(this.jdField_a_of_type_Ydb.a);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverEntryEnable", 1) & (QzoneConfig.getInstance().getConfig("qqsubscribe", "JumpToNewServiceAccount", 1) ^ 0xFFFFFFFF)) == 1)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetRecommendUserListRsp.entry.has()) {
        localObject1 = (CertifiedAccountMeta.StEntry)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetRecommendUserListRsp.entry.get();
      }
    }
    if (localycz != null)
    {
      localycz.a((CertifiedAccountMeta.StEntry)localObject1, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Boolean);
      int i = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetRecommendUserListRsp.noticeCount.get();
      if (i > 0) {
        localycz.a(i);
      }
    }
    else
    {
      return;
    }
    localycz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelPresenter.1.1
 * JD-Core Version:    0.7.0.1
 */