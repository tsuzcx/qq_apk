package com.tencent.biz.pubaccount.readinjoy.video.playfeedback;

import azri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class PlayFeedbackHelper$2
  implements Runnable
{
  public PlayFeedbackHelper$2(HashMap paramHashMap) {}
  
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
    azri.a(BaseApplicationImpl.getContext()).a((String)localObject, "actVideoPlayFeedback", true, -1L, 0L, this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.playfeedback.PlayFeedbackHelper.2
 * JD-Core Version:    0.7.0.1
 */