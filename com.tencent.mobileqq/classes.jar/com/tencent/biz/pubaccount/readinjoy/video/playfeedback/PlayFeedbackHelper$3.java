package com.tencent.biz.pubaccount.readinjoy.video.playfeedback;

import bctj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.tplayer.plugins.report.BeaconAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class PlayFeedbackHelper$3
  implements Runnable
{
  public PlayFeedbackHelper$3(HashMap paramHashMap) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((StringBuilder)localObject).append((String)localEntry.getKey()).append(":").append((String)localEntry.getValue()).append(" ");
      }
      QLog.d("PlayFeedbackHelper", 2, "report actVideoPlayFeedback, data=" + ((StringBuilder)localObject).toString());
    }
    Object localObject = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).c();
    bctj.a(BaseApplicationImpl.getContext()).a((String)localObject, "actVideoPlayFeedback", true, -1L, 0L, this.a, null);
    BeaconAdapter.onUserActionToTunnel("00000U7O8S3BLETM", "actVideoPlayFeedback", true, -1L, -1L, this.a, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.playfeedback.PlayFeedbackHelper.3
 * JD-Core Version:    0.7.0.1
 */