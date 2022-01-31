package com.tencent.mobileqq.activity.aio;

import aclw;
import android.graphics.Bitmap;
import babe;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo;
import mqq.os.MqqHandler;

public class IntimateInfoView$16
  implements Runnable
{
  public IntimateInfoView$16(aclw paramaclw, IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo) {}
  
  public void run()
  {
    Object localObject3 = aclw.a(this.this$0, this.a, false);
    Object localObject2 = babe.a((String)localObject3);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((Bitmap)localObject2).isRecycled()) {}
    }
    else
    {
      localObject1 = aclw.a(this.this$0, this.a);
      babe.a((String)localObject3, (Bitmap)localObject1);
    }
    String str = aclw.a(this.this$0, this.a, true);
    localObject3 = babe.a(str);
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (!((Bitmap)localObject3).isRecycled()) {}
    }
    else
    {
      localObject2 = aclw.b(this.this$0, this.a);
      babe.a(str, (Bitmap)localObject2);
    }
    ThreadManager.getUIHandler().post(new IntimateInfoView.16.1(this, (Bitmap)localObject1, (Bitmap)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.16
 * JD-Core Version:    0.7.0.1
 */