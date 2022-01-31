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
import nmf;
import nyg;
import nzi;
import qny;
import qoc;

public class VideoFeedsGameAdComManager$2
  implements Runnable
{
  public VideoFeedsGameAdComManager$2(qny paramqny) {}
  
  public void run()
  {
    if ((qny.a(this.this$0) != null) && (!TextUtils.isEmpty(qny.a(this.this$0).d)) && (qny.a(this.this$0).t != null)) {
      try
      {
        Object localObject = new HashMap();
        ((HashMap)localObject).put("vid", qny.a(this.this$0));
        nmf.a(new nyg().a(qny.a(this.this$0)).a(nmf.z).b(nmf.ad).c(nmf.ao).a(qny.a(this.this$0)).d(nmf.a(null, qny.a(this.this$0).mRowKey, qny.b(this.this$0), qny.a(this.this$0).r, qny.a(this.this$0).d, (HashMap)localObject)).e(nzi.a(qny.a(this.this$0).a, nmf.F)).a());
        localObject = nzi.a(qny.a(this.this$0).d);
        if (((qny.a(this.this$0) instanceof Activity)) && (((Pair)localObject).first != null) && (((List)((Pair)localObject).first).size() > 0))
        {
          Activity localActivity = qny.a(this.this$0);
          localActivity.runOnUiThread(new VideoFeedsGameAdComManager.2.1(this, localActivity, (Pair)localObject));
          return;
        }
        ThreadManager.getUIHandler().post(new VideoFeedsGameAdComManager.2.2(this));
        return;
      }
      catch (Exception localException)
      {
        QLog.e(qny.a(), 2, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.2
 * JD-Core Version:    0.7.0.1
 */