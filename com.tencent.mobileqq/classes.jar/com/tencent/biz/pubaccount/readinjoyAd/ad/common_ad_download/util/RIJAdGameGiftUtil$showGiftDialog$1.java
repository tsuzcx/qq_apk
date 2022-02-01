package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
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
    Object localObject1 = this.a;
    Context localContext = null;
    if (localObject1 != null) {
      localObject1 = ((AdvertisementInfo)localObject1).gameAdComData;
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      localObject1 = this.a.gameAdComData;
      if (localObject1 != null) {
        localObject1 = ((GameAdComData)localObject1).e;
      } else {
        localObject1 = null;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = this.a.gameAdComData;
        if (localObject1 != null) {
          localObject1 = ((GameAdComData)localObject1).v;
        } else {
          localObject1 = null;
        }
        if (localObject1 != null)
        {
          Object localObject2 = this.a.gameAdComData;
          localObject1 = localContext;
          if (localObject2 != null) {
            localObject1 = ((GameAdComData)localObject2).e;
          }
          localObject1 = GiftPackageManager.a((String)localObject1);
          if (((this.b instanceof Activity)) && (((Pair)localObject1).first != null) && (((List)((Pair)localObject1).first).size() > 0))
          {
            localContext = this.b;
            int i;
            if (this.a.mChannelID == 0L) {
              i = 1;
            } else {
              i = 3;
            }
            localObject2 = new Ref.ObjectRef();
            ((Ref.ObjectRef)localObject2).element = "";
            if (this.c.getInPtsCard()) {
              ((Ref.ObjectRef)localObject2).element = "2";
            } else if (this.c.getInFloatingBar()) {
              ((Ref.ObjectRef)localObject2).element = "1";
            }
            ((Activity)localContext).runOnUiThread((Runnable)new RIJAdGameGiftUtil.showGiftDialog.1.1(this, localContext, i, (Pair)localObject1, (Ref.ObjectRef)localObject2));
            return;
          }
          ThreadManager.getUIHandler().post((Runnable)RIJAdGameGiftUtil.showGiftDialog.1.2.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdGameGiftUtil.showGiftDialog.1
 * JD-Core Version:    0.7.0.1
 */