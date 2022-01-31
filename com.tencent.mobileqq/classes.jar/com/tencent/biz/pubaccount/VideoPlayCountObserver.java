package com.tencent.biz.pubaccount;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;

public class VideoPlayCountObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject != null)
    {
      a(paramBoolean, (Bundle)paramObject);
      return;
    }
    a(paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoPlayCountObserver
 * JD-Core Version:    0.7.0.1
 */