package com.tencent.mobileqq.activity.aio;

import agiq;
import android.graphics.Bitmap;
import bhld;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo;
import mqq.os.MqqHandler;

public class IntimateInfoView$18
  implements Runnable
{
  public IntimateInfoView$18(agiq paramagiq, IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo) {}
  
  public void run()
  {
    Object localObject3 = agiq.a(this.this$0, this.a, false) + this.a.iconStaticUrl;
    Object localObject2 = bhld.a((String)localObject3);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((Bitmap)localObject2).isRecycled()) {}
    }
    else
    {
      localObject1 = agiq.a(this.this$0, this.a);
      bhld.a((String)localObject3, (Bitmap)localObject1);
    }
    String str = agiq.a(this.this$0, this.a, true);
    localObject3 = bhld.a(str);
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (!((Bitmap)localObject3).isRecycled()) {}
    }
    else
    {
      localObject2 = agiq.b(this.this$0, this.a);
      bhld.a(str, (Bitmap)localObject2);
    }
    ThreadManager.getUIHandler().post(new IntimateInfoView.18.1(this, (Bitmap)localObject1, (Bitmap)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.18
 * JD-Core Version:    0.7.0.1
 */