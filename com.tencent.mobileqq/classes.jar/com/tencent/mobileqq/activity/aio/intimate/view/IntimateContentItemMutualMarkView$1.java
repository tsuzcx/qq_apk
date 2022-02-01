package com.tencent.mobileqq.activity.aio.intimate.view;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo.PrefetchMutualMarkInfo;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import mqq.os.MqqHandler;

class IntimateContentItemMutualMarkView$1
  implements Runnable
{
  IntimateContentItemMutualMarkView$1(IntimateContentItemMutualMarkView paramIntimateContentItemMutualMarkView, IntimateInfo.PrefetchMutualMarkInfo paramPrefetchMutualMarkInfo) {}
  
  public void run()
  {
    Object localObject3 = IntimateContentItemMutualMarkView.a(this.this$0, this.a, false) + this.a.iconStaticUrl;
    Object localObject2 = CommonImageCacheHelper.a((String)localObject3);
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((Bitmap)localObject2).isRecycled()) {}
    }
    else
    {
      localObject1 = IntimateContentItemMutualMarkView.a(this.this$0, this.a);
      CommonImageCacheHelper.a((String)localObject3, (Bitmap)localObject1);
    }
    String str = IntimateContentItemMutualMarkView.a(this.this$0, this.a, true);
    localObject3 = CommonImageCacheHelper.a(str);
    if (localObject3 != null)
    {
      localObject2 = localObject3;
      if (!((Bitmap)localObject3).isRecycled()) {}
    }
    else
    {
      localObject2 = IntimateContentItemMutualMarkView.b(this.this$0, this.a);
      CommonImageCacheHelper.a(str, (Bitmap)localObject2);
    }
    ThreadManager.getUIHandler().post(new IntimateContentItemMutualMarkView.1.1(this, (Bitmap)localObject1, (Bitmap)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemMutualMarkView.1
 * JD-Core Version:    0.7.0.1
 */