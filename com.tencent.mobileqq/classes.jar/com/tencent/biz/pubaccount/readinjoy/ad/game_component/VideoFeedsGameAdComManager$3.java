package com.tencent.biz.pubaccount.readinjoy.ad.game_component;

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
import nxw;
import omp;
import omz;
import one;
import ooh;

public class VideoFeedsGameAdComManager$3
  implements Runnable
{
  public VideoFeedsGameAdComManager$3(omz paramomz) {}
  
  public void run()
  {
    if ((omz.a(this.this$0) != null) && (!TextUtils.isEmpty(omz.a(this.this$0).d)) && (omz.a(this.this$0).u != null)) {
      try
      {
        Object localObject = new HashMap();
        ((HashMap)localObject).put("vid", omz.a(this.this$0));
        nxw.a(new omp().a(omz.a(this.this$0)).a(nxw.A).b(nxw.af).c(nxw.as).a(omz.a(this.this$0)).d(nxw.a(null, omz.a(this.this$0).mRowKey, omz.b(this.this$0), omz.a(this.this$0).s, omz.a(this.this$0).d, (HashMap)localObject)).e(ooh.a(omz.a(this.this$0).a, nxw.G)).a());
        localObject = ooh.a(omz.a(this.this$0).d);
        if (((omz.a(this.this$0) instanceof Activity)) && (((Pair)localObject).first != null) && (((List)((Pair)localObject).first).size() > 0))
        {
          Activity localActivity = omz.a(this.this$0);
          localActivity.runOnUiThread(new VideoFeedsGameAdComManager.3.1(this, localActivity, (Pair)localObject));
          return;
        }
        ThreadManager.getUIHandler().post(new VideoFeedsGameAdComManager.3.2(this));
        return;
      }
      catch (Exception localException)
      {
        QLog.e(omz.a(), 2, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.game_component.VideoFeedsGameAdComManager.3
 * JD-Core Version:    0.7.0.1
 */