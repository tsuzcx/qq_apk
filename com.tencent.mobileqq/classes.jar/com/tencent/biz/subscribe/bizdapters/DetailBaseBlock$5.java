package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.utils.TimeAndCountHelper;
import com.tencent.biz.subscribe.utils.TimeAndCountHelper.CountResult;
import com.tencent.qphone.base.util.QLog;

class DetailBaseBlock$5
  implements TimeAndCountHelper.CountResult
{
  DetailBaseBlock$5(DetailBaseBlock paramDetailBaseBlock, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void a(int paramInt)
  {
    QLog.d(DetailBaseBlock.jdField_a_of_type_JavaLangString, 2, "count:" + paramInt);
    if ((DetailBaseBlock.n(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock) != null) && (paramInt == 1))
    {
      if (TimeAndCountHelper.a().a(DetailBaseBlock.o(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock), "subscribe_sp_key_show_praise_guide") != 0) {
        break label90;
      }
      if ((this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (!this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a())) {
        this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock.f();
      }
    }
    label90:
    while ((TimeAndCountHelper.a().a(DetailBaseBlock.p(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock), "subscribe_sp_key_show_follow_guide") != 0) || (SubscribeUtils.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed))) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersDetailBaseBlock.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.5
 * JD-Core Version:    0.7.0.1
 */