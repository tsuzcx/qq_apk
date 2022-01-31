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
import nbe;
import nmv;
import nnx;
import qca;
import qce;

public class VideoFeedsGameAdComManager$2
  implements Runnable
{
  public VideoFeedsGameAdComManager$2(qca paramqca) {}
  
  public void run()
  {
    if ((qca.a(this.this$0) != null) && (!TextUtils.isEmpty(qca.a(this.this$0).d)) && (qca.a(this.this$0).t != null)) {
      try
      {
        Object localObject = new HashMap();
        ((HashMap)localObject).put("vid", qca.a(this.this$0));
        nbe.a(new nmv().a(qca.a(this.this$0)).a(nbe.z).b(nbe.ad).c(nbe.ao).a(qca.a(this.this$0)).d(nbe.a(null, qca.a(this.this$0).mRowKey, qca.b(this.this$0), qca.a(this.this$0).r, qca.a(this.this$0).d, (HashMap)localObject)).e(nnx.a(qca.a(this.this$0).a, nbe.F)).a());
        localObject = nnx.a(qca.a(this.this$0).d);
        if (((qca.a(this.this$0) instanceof Activity)) && (((Pair)localObject).first != null) && (((List)((Pair)localObject).first).size() > 0))
        {
          Activity localActivity = qca.a(this.this$0);
          localActivity.runOnUiThread(new VideoFeedsGameAdComManager.2.1(this, localActivity, (Pair)localObject));
          return;
        }
        ThreadManager.getUIHandler().post(new VideoFeedsGameAdComManager.2.2(this));
        return;
      }
      catch (Exception localException)
      {
        QLog.e(qca.a(), 2, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.2
 * JD-Core Version:    0.7.0.1
 */