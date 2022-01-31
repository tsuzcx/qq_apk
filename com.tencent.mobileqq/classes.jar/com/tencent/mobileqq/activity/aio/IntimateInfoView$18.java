package com.tencent.mobileqq.activity.aio;

import aesk;
import android.graphics.Bitmap;
import bdfz;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo;
import mqq.os.MqqHandler;

public class IntimateInfoView$18
  implements Runnable
{
  public IntimateInfoView$18(aesk paramaesk, IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo) {}
  
  public void run()
  {
    Object localObject3 = aesk.a(this.this$0, this.a, false);
    Object localObject2 = bdfz.a((String)localObject3);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((Bitmap)localObject2).isRecycled()) {}
    }
    else
    {
      localObject1 = aesk.a(this.this$0, this.a);
      bdfz.a((String)localObject3, (Bitmap)localObject1);
    }
    String str = aesk.a(this.this$0, this.a, true);
    localObject3 = bdfz.a(str);
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (!((Bitmap)localObject3).isRecycled()) {}
    }
    else
    {
      localObject2 = aesk.b(this.this$0, this.a);
      bdfz.a(str, (Bitmap)localObject2);
    }
    ThreadManager.getUIHandler().post(new IntimateInfoView.18.1(this, (Bitmap)localObject1, (Bitmap)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.18
 * JD-Core Version:    0.7.0.1
 */