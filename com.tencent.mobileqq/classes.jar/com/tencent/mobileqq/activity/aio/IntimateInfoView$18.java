package com.tencent.mobileqq.activity.aio;

import afbj;
import android.graphics.Bitmap;
import bfuj;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo;
import mqq.os.MqqHandler;

public class IntimateInfoView$18
  implements Runnable
{
  public IntimateInfoView$18(afbj paramafbj, IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo) {}
  
  public void run()
  {
    Object localObject3 = afbj.a(this.this$0, this.a, false) + this.a.iconStaticUrl;
    Object localObject2 = bfuj.a((String)localObject3);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((Bitmap)localObject2).isRecycled()) {}
    }
    else
    {
      localObject1 = afbj.a(this.this$0, this.a);
      bfuj.a((String)localObject3, (Bitmap)localObject1);
    }
    String str = afbj.a(this.this$0, this.a, true);
    localObject3 = bfuj.a(str);
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (!((Bitmap)localObject3).isRecycled()) {}
    }
    else
    {
      localObject2 = afbj.b(this.this$0, this.a);
      bfuj.a(str, (Bitmap)localObject2);
    }
    ThreadManager.getUIHandler().post(new IntimateInfoView.18.1(this, (Bitmap)localObject1, (Bitmap)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.18
 * JD-Core Version:    0.7.0.1
 */