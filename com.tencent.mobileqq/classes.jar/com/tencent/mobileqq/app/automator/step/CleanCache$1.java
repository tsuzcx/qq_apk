package com.tencent.mobileqq.app.automator.step;

import android.os.Build.VERSION;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class CleanCache$1
  implements Runnable
{
  private int a = 0;
  
  CleanCache$1(CleanCache paramCleanCache) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        CleanCache.a(this.this$0, this.a);
        CleanCache.a(this.this$0);
        localObject1 = new File[3];
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
        ((StringBuilder)localObject2).append("photo");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        j = 0;
        localObject1[0] = localObject2;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
        ((StringBuilder)localObject2).append("ptv_template");
        localObject1[1] = new File(((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(AppConstants.PATH_CUSTOM_HEAD_ROOT_SDCARD);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append("_dynamic");
        localObject1[2] = new File(((StringBuilder)localObject2).toString());
        k = localObject1.length;
        i = 0;
        if (j < k)
        {
          localObject2 = localObject1[j];
          i += CleanCache.a(this.this$0, (File)localObject2, 2000, 500);
          j += 1;
          continue;
        }
        k = CleanCache.a(this.this$0, new File(SafeBitmapFactory.LARGE_MAP_CACHE_PATH), 150, 50);
        if (Build.VERSION.SDK_INT < 21) {
          j = CleanCache.a(this.this$0, URLDrawableHelper.diskCachePath, 2000, 500);
        } else {
          j = CleanCache.a(this.this$0, URLDrawableHelper.diskCachePath, 5000, 2000);
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        int j;
        int k;
        int i;
        localException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onCleanCache. delete ");
        ((StringBuilder)localObject1).append(i + k + j);
        ((StringBuilder)localObject1).append(" cache file(s)");
        QLog.d("QQInitHandler", 2, ((StringBuilder)localObject1).toString());
      }
      this.this$0.c();
      this.this$0.b();
      CleanCache.b(this.this$0);
      CleanCache.c(this.this$0);
      CleanCache.d(this.this$0);
      this.this$0.mAutomator.notifyUI(40001, true, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CleanCache.1
 * JD-Core Version:    0.7.0.1
 */