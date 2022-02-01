package com.tencent.biz.pubaccount.weishi_new.download;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;

final class WSDownloadAppDialog$2
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (WeishiGuideUtils.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      WeishiScehmeUtil.a(this.jdField_a_of_type_AndroidAppActivity, "biz_src_jc_gzh_weishi", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mScene, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mLinkStrategyType, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mEventId);
      UserActionReportPresenter.a(114, this.jdField_a_of_type_Int, this.b, null);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      WSReportDc00898.b(112, 1, 0);
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mStReportItem == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mStReportItem = UserActionReportPresenter.a();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mStReportItem.downloadscene = WeishiDownloadUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mScene, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mLinkStrategyType, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mEventId);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mStReportItem.comment_loctaion = this.b;
      WeishiDownloadUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WSDownloadAppDialog.2
 * JD-Core Version:    0.7.0.1
 */