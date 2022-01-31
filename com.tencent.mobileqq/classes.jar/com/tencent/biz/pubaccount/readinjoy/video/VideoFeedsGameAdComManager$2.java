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
import nmc;
import nyd;
import nzf;
import qnv;
import qnz;

public class VideoFeedsGameAdComManager$2
  implements Runnable
{
  public VideoFeedsGameAdComManager$2(qnv paramqnv) {}
  
  public void run()
  {
    if ((qnv.a(this.this$0) != null) && (!TextUtils.isEmpty(qnv.a(this.this$0).d)) && (qnv.a(this.this$0).t != null)) {
      try
      {
        Object localObject = new HashMap();
        ((HashMap)localObject).put("vid", qnv.a(this.this$0));
        nmc.a(new nyd().a(qnv.a(this.this$0)).a(nmc.z).b(nmc.ad).c(nmc.ao).a(qnv.a(this.this$0)).d(nmc.a(null, qnv.a(this.this$0).mRowKey, qnv.b(this.this$0), qnv.a(this.this$0).r, qnv.a(this.this$0).d, (HashMap)localObject)).e(nzf.a(qnv.a(this.this$0).a, nmc.F)).a());
        localObject = nzf.a(qnv.a(this.this$0).d);
        if (((qnv.a(this.this$0) instanceof Activity)) && (((Pair)localObject).first != null) && (((List)((Pair)localObject).first).size() > 0))
        {
          Activity localActivity = qnv.a(this.this$0);
          localActivity.runOnUiThread(new VideoFeedsGameAdComManager.2.1(this, localActivity, (Pair)localObject));
          return;
        }
        ThreadManager.getUIHandler().post(new VideoFeedsGameAdComManager.2.2(this));
        return;
      }
      catch (Exception localException)
      {
        QLog.e(qnv.a(), 2, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.2
 * JD-Core Version:    0.7.0.1
 */