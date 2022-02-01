package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdDialogUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "clickRegister"}, k=3, mv={1, 1, 16})
final class RIJAdGameGiftUtil$showGiftDialog$1$1$1
  implements GiftPackageListener
{
  RIJAdGameGiftUtil$showGiftDialog$1$1$1(RIJAdGameGiftUtil.showGiftDialog.1.1 param1, GiftPackageDialog paramGiftPackageDialog) {}
  
  public final void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog.dismiss();
    GameComponentReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadUtilRIJAdGameGiftUtil$showGiftDialog$1$1.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 1, "2");
    Context localContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadUtilRIJAdGameGiftUtil$showGiftDialog$1$1.this$0.jdField_a_of_type_AndroidContentContext;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadUtilRIJAdGameGiftUtil$showGiftDialog$1$1.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData;
    if (localObject != null) {
      localObject = ((GameAdComData)localObject).d;
    } else {
      localObject = null;
    }
    ReadInJoyAdDialogUtil.a(localContext, (String)localObject, (DialogInterface.OnClickListener)new RIJAdGameGiftUtil.showGiftDialog.1.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdGameGiftUtil.showGiftDialog.1.1.1
 * JD-Core Version:    0.7.0.1
 */