package com.tencent.biz.pubaccount.readinjoy.video;

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
import noy;
import obk;
import ocp;
import rcz;
import rdd;

public class VideoFeedsGameAdComManager$2
  implements Runnable
{
  public VideoFeedsGameAdComManager$2(rcz paramrcz) {}
  
  public void run()
  {
    if ((rcz.a(this.this$0) != null) && (!TextUtils.isEmpty(rcz.a(this.this$0).d)) && (rcz.a(this.this$0).t != null)) {
      try
      {
        Object localObject = new HashMap();
        ((HashMap)localObject).put("vid", rcz.a(this.this$0));
        noy.a(new obk().a(rcz.a(this.this$0)).a(noy.z).b(noy.ad).c(noy.ao).a(rcz.a(this.this$0)).d(noy.a(null, rcz.a(this.this$0).mRowKey, rcz.b(this.this$0), rcz.a(this.this$0).r, rcz.a(this.this$0).d, (HashMap)localObject)).e(ocp.a(rcz.a(this.this$0).a, noy.F)).a());
        localObject = ocp.a(rcz.a(this.this$0).d);
        if (((rcz.a(this.this$0) instanceof Activity)) && (((Pair)localObject).first != null) && (((List)((Pair)localObject).first).size() > 0))
        {
          Activity localActivity = rcz.a(this.this$0);
          localActivity.runOnUiThread(new VideoFeedsGameAdComManager.2.1(this, localActivity, (Pair)localObject));
          return;
        }
        ThreadManager.getUIHandler().post(new VideoFeedsGameAdComManager.2.2(this));
        return;
      }
      catch (Exception localException)
      {
        QLog.e(rcz.a(), 2, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.2
 * JD-Core Version:    0.7.0.1
 */