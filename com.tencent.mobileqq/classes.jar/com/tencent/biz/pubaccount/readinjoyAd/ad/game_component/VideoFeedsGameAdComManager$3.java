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
import obb;
import trn;
import tsf;
import tsk;
import ttp;

public class VideoFeedsGameAdComManager$3
  implements Runnable
{
  public VideoFeedsGameAdComManager$3(tsf paramtsf) {}
  
  public void run()
  {
    if ((tsf.a(this.this$0) != null) && (!TextUtils.isEmpty(tsf.a(this.this$0).d)) && (tsf.a(this.this$0).u != null)) {
      try
      {
        Object localObject = new HashMap();
        ((HashMap)localObject).put("vid", tsf.a(this.this$0));
        obb.a(new trn().a(tsf.a(this.this$0)).a(obb.A).b(obb.af).c(obb.as).a(tsf.a(this.this$0)).d(obb.a(null, tsf.a(this.this$0).mRowKey, tsf.b(this.this$0), tsf.a(this.this$0).s, tsf.a(this.this$0).d, (HashMap)localObject)).e(ttp.a(tsf.a(this.this$0).a, obb.G)).a());
        localObject = ttp.a(tsf.a(this.this$0).d);
        if (((tsf.a(this.this$0) instanceof Activity)) && (((Pair)localObject).first != null) && (((List)((Pair)localObject).first).size() > 0))
        {
          Activity localActivity = tsf.a(this.this$0);
          localActivity.runOnUiThread(new VideoFeedsGameAdComManager.3.1(this, localActivity, (Pair)localObject));
          return;
        }
        ThreadManager.getUIHandler().post(new VideoFeedsGameAdComManager.3.2(this));
        return;
      }
      catch (Exception localException)
      {
        QLog.e(tsf.a(), 2, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.3
 * JD-Core Version:    0.7.0.1
 */