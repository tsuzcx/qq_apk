package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class RIJAdGameGiftUtil$showGiftDialog$1$1$1$1
  implements DialogInterface.OnClickListener
{
  RIJAdGameGiftUtil$showGiftDialog$1$1$1$1(RIJAdGameGiftUtil.showGiftDialog.1.1.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      paramDialogInterface.dismiss();
      GameComponentReport.a(Integer.valueOf(0), this.a.a.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 10, (String)this.a.a.a.element);
      return;
    }
    RIJAdGameGiftUtil.a(RIJAdGameGiftUtil.a, this.a.a.this$0.jdField_a_of_type_AndroidContentContext, this.a.a.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.a.a.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, this.a.a.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdGameGiftUtil.showGiftDialog.1.1.1.1
 * JD-Core Version:    0.7.0.1
 */