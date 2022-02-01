package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.GiftPackageListener;
import com.tencent.util.Pair;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJAdGameGiftUtil$showGiftDialog$1$1
  implements Runnable
{
  RIJAdGameGiftUtil$showGiftDialog$1$1(RIJAdGameGiftUtil.showGiftDialog.1 param1, Context paramContext, int paramInt, Pair paramPair, Ref.ObjectRef paramObjectRef) {}
  
  public final void run()
  {
    String str3 = null;
    GiftPackageDialog localGiftPackageDialog;
    if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())
    {
      if (this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a() != null)
      {
        localObject1 = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a();
        if ((localObject1 != null) && (((GiftPackageDialog)localObject1).isShowing() == true))
        {
          localObject1 = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a();
          if (localObject1 != null) {
            ((GiftPackageDialog)localObject1).dismiss();
          }
        }
      }
      localGiftPackageDialog = new GiftPackageDialog(this.this$0.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
      this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setDialog(localGiftPackageDialog);
      localGiftPackageDialog.a(this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      localGiftPackageDialog.a(true);
    }
    for (;;)
    {
      try
      {
        localObject1 = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData;
        if (localObject1 != null)
        {
          localObject1 = ((VideoInfo.GameAdComData)localObject1).u;
          if (localObject1 != null)
          {
            localObject2 = new JSONObject((String)localObject1);
            str1 = ((JSONObject)localObject2).optString("sActivityId");
            Intrinsics.checkExpressionValueIsNotNull(str1, "jsonObject.optString(\"sActivityId\")");
          }
        }
      }
      catch (Exception localException1)
      {
        Object localObject2;
        List localList1;
        List localList2;
        VideoInfo.GameAdComData localGameAdComData;
        String str1 = "";
        localObject1 = "";
      }
      try
      {
        localObject1 = ((JSONObject)localObject2).optString("sGiftName");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "jsonObject.optString(\"sGiftName\")");
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          String str2;
          localObject1 = "";
        }
      }
      try
      {
        localObject2 = ((JSONObject)localObject2).optString("sNeedRole");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "jsonObject.optString(\"sNeedRole\")");
        localList1 = (List)this.jdField_a_of_type_ComTencentUtilPair.first;
        localList2 = (List)this.jdField_a_of_type_ComTencentUtilPair.second;
        localObject3 = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData;
        if (localObject3 == null) {
          break label328;
        }
        localObject3 = ((VideoInfo.GameAdComData)localObject3).d;
        localGameAdComData = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData;
        if (localGameAdComData != null) {
          str3 = localGameAdComData.g;
        }
        localGiftPackageDialog.a(localList1, localList2, (String)localObject3, str1, (String)localObject1, str3, (String)localObject2);
        localGiftPackageDialog.a((GiftPackageDialog.GiftPackageListener)new RIJAdGameGiftUtil.showGiftDialog.1.1.1(this, localGiftPackageDialog));
        localGiftPackageDialog.show();
        return;
      }
      catch (Exception localException3)
      {
        break label318;
      }
      localObject1 = "";
      continue;
      label318:
      localException1.printStackTrace();
      str2 = "";
      continue;
      label328:
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdGameGiftUtil.showGiftDialog.1.1
 * JD-Core Version:    0.7.0.1
 */