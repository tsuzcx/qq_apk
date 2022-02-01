package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.GiftPackageManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJAdGameGiftUtil$showGiftDialog$1
  implements Runnable
{
  RIJAdGameGiftUtil$showGiftDialog$1(AdvertisementInfo paramAdvertisementInfo, Context paramContext, RIJDownloadView paramRIJDownloadView, ADVideoAppDownloadData paramADVideoAppDownloadData) {}
  
  public final void run()
  {
    Context localContext = null;
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    label37:
    label64:
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((AdvertisementInfo)localObject1).gameAdComData;
      if (localObject1 != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData;
        if (localObject1 == null) {
          break label208;
        }
        localObject1 = ((VideoInfo.GameAdComData)localObject1).d;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData;
          if (localObject1 == null) {
            break label213;
          }
          localObject1 = ((VideoInfo.GameAdComData)localObject1).u;
          if (localObject1 != null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData;
            localObject1 = localContext;
            if (localObject2 != null) {
              localObject1 = ((VideoInfo.GameAdComData)localObject2).d;
            }
            localObject1 = GiftPackageManager.a((String)localObject1);
            if ((!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) || (((Pair)localObject1).first == null) || (((List)((Pair)localObject1).first).size() <= 0)) {
              break label243;
            }
            localContext = this.jdField_a_of_type_AndroidContentContext;
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID != 0L) {
              break label218;
            }
            i = 1;
            label146:
            localObject2 = new Ref.ObjectRef();
            ((Ref.ObjectRef)localObject2).element = "";
            if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a()) {
              break label223;
            }
            ((Ref.ObjectRef)localObject2).element = "2";
          }
        }
      }
    }
    for (;;)
    {
      ((Activity)localContext).runOnUiThread((Runnable)new RIJAdGameGiftUtil.showGiftDialog.1.1(this, localContext, i, (Pair)localObject1, (Ref.ObjectRef)localObject2));
      return;
      localObject1 = null;
      break;
      label208:
      localObject1 = null;
      break label37;
      label213:
      localObject1 = null;
      break label64;
      label218:
      i = 3;
      break label146;
      label223:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.b()) {
        ((Ref.ObjectRef)localObject2).element = "1";
      }
    }
    label243:
    ThreadManager.getUIHandler().post((Runnable)RIJAdGameGiftUtil.showGiftDialog.1.2.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdGameGiftUtil.showGiftDialog.1
 * JD-Core Version:    0.7.0.1
 */