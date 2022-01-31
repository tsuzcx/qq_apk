package com.tencent.biz.pubaccount;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;

public class VideoPlayRecommendObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject != null) {}
    try
    {
      a(paramBoolean, (Bundle)paramObject);
      return;
    }
    catch (Exception paramObject) {}
    a(false, new Bundle());
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoPlayRecommendObserver
 * JD-Core Version:    0.7.0.1
 */