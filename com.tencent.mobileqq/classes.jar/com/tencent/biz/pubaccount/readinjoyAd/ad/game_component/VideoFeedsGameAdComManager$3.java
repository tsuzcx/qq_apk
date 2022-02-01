package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import nzq;
import tlx;
import tmk;
import tmp;
import tns;

public class VideoFeedsGameAdComManager$3
  implements Runnable
{
  public VideoFeedsGameAdComManager$3(tmk paramtmk) {}
  
  public void run()
  {
    if ((tmk.a(this.this$0) != null) && (!TextUtils.isEmpty(tmk.a(this.this$0).d)) && (tmk.a(this.this$0).u != null)) {
      try
      {
        Object localObject = new HashMap();
        ((HashMap)localObject).put("vid", tmk.a(this.this$0));
        nzq.a(new tlx().a(tmk.a(this.this$0)).a(nzq.A).b(nzq.af).c(nzq.as).a(tmk.a(this.this$0)).d(nzq.a(null, tmk.a(this.this$0).mRowKey, tmk.b(this.this$0), tmk.a(this.this$0).s, tmk.a(this.this$0).d, (HashMap)localObject)).e(tns.a(tmk.a(this.this$0).a, nzq.G)).a());
        localObject = tns.a(tmk.a(this.this$0).d);
        if (((tmk.a(this.this$0) instanceof Activity)) && (((Pair)localObject).first != null) && (((List)((Pair)localObject).first).size() > 0))
        {
          Activity localActivity = tmk.a(this.this$0);
          localActivity.runOnUiThread(new VideoFeedsGameAdComManager.3.1(this, localActivity, (Pair)localObject));
          return;
        }
        ThreadManager.getUIHandler().post(new VideoFeedsGameAdComManager.3.2(this));
        return;
      }
      catch (Exception localException)
      {
        QLog.e(tmk.a(), 2, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.3
 * JD-Core Version:    0.7.0.1
 */