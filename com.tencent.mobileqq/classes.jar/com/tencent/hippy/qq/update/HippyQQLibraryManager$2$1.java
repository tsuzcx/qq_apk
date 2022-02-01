package com.tencent.hippy.qq.update;

import android.text.TextUtils;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class HippyQQLibraryManager$2$1
  implements Runnable
{
  HippyQQLibraryManager$2$1(HippyQQLibraryManager.2 param2, int paramInt, LoadExtResult paramLoadExtResult) {}
  
  public void run()
  {
    if ((QLog.isColorLevel()) || (this.val$resCode != 0))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("Hippy: SoLoadManager loadSequentially resCode=");
      ((StringBuilder)???).append(this.val$resCode);
      QLog.d("Hippy", 1, ((StringBuilder)???).toString());
    }
    if (this.val$resCode == 0)
    {
      this.this$1.this$0.updateSoVersions(this.val$loadExtResult);
      HippyQQLibraryManager.access$002(this.this$1.this$0, this.val$loadExtResult.getRelatedFilesFolder("hippybridge"));
      if (!TextUtils.isEmpty(HippyQQLibraryManager.access$000(this.this$1.this$0)))
      {
        HippyQQLibraryManager.access$100(this.this$1.this$0);
      }
      else
      {
        QLog.d("Hippy", 2, "Hippy: SoLoadManager mCommonPackagePath empty");
        HippyQQLibraryManager.access$200(this.this$1.this$0, -10);
      }
    }
    else
    {
      HippyQQLibraryManager.access$200(this.this$1.this$0, this.val$resCode);
    }
    synchronized (HippyQQLibraryManager.access$300(this.this$1.this$0))
    {
      HippyQQLibraryManager.access$400(this.this$1.this$0).clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQLibraryManager.2.1
 * JD-Core Version:    0.7.0.1
 */