package com.tencent.hippy.qq.update;

import android.text.TextUtils;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class HippyQQLibraryManager$2$1
  implements Runnable
{
  HippyQQLibraryManager$2$1(HippyQQLibraryManager.2 param2, int paramInt, LoadExtResult paramLoadExtResult) {}
  
  public void run()
  {
    if ((QLog.isColorLevel()) || (this.val$resCode != 0)) {
      QLog.d("Hippy", 1, "Hippy: SoLoadManager loadSequentially resCode=" + this.val$resCode);
    }
    if (this.val$resCode == 0)
    {
      this.this$1.this$0.updateSoVersions(this.val$loadExtResult);
      HippyQQLibraryManager.access$002(this.this$1.this$0, this.val$loadExtResult.getRelatedFilesFolder("hippybridge"));
      if (!TextUtils.isEmpty(HippyQQLibraryManager.access$000(this.this$1.this$0))) {
        HippyQQLibraryManager.access$100(this.this$1.this$0);
      }
    }
    for (;;)
    {
      HippyQQLibraryManager.access$300(this.this$1.this$0).clear();
      return;
      QLog.d("Hippy", 2, "Hippy: SoLoadManager mCommonPackagePath empty");
      HippyQQLibraryManager.access$200(this.this$1.this$0, -10);
      continue;
      HippyQQLibraryManager.access$200(this.this$1.this$0, this.val$resCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQLibraryManager.2.1
 * JD-Core Version:    0.7.0.1
 */