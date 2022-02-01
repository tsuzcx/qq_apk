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
import ois;
import ufy;
import ugq;
import ugv;
import uhw;

public class VideoFeedsGameAdComManager$3
  implements Runnable
{
  public VideoFeedsGameAdComManager$3(ugq paramugq) {}
  
  public void run()
  {
    if ((ugq.a(this.this$0) != null) && (!TextUtils.isEmpty(ugq.a(this.this$0).d)) && (ugq.a(this.this$0).u != null)) {
      try
      {
        Object localObject = new HashMap();
        ((HashMap)localObject).put("vid", ugq.a(this.this$0));
        ois.a(new ufy().a(ugq.a(this.this$0)).a(24).b(26).c(1).a(ugq.a(this.this$0)).d(ois.a(null, ugq.a(this.this$0).mRowKey, ugq.b(this.this$0), ugq.a(this.this$0).s, ugq.a(this.this$0).d, (HashMap)localObject)).e(uhw.a(ugq.a(this.this$0).a, 1)).a());
        localObject = uhw.a(ugq.a(this.this$0).d);
        if (((ugq.a(this.this$0) instanceof Activity)) && (((Pair)localObject).first != null) && (((List)((Pair)localObject).first).size() > 0))
        {
          Activity localActivity = ugq.a(this.this$0);
          localActivity.runOnUiThread(new VideoFeedsGameAdComManager.3.1(this, localActivity, (Pair)localObject));
          return;
        }
        ThreadManager.getUIHandler().post(new VideoFeedsGameAdComManager.3.2(this));
        return;
      }
      catch (Exception localException)
      {
        QLog.e(ugq.a(), 2, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.3
 * JD-Core Version:    0.7.0.1
 */