package com.tencent.hippy.qq.update;

import com.tencent.hippy.qq.api.PackageUpdateListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class HippyQQUpdateManager$2$1
  implements HippyQQFileUtil.DownLoadCallBack
{
  HippyQQUpdateManager$2$1(HippyQQUpdateManager.2 param2) {}
  
  public void onDownloadResult(int paramInt, File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Hippy", 2, new Object[] { "loadOnlineBundle onUpdateComplete result:", Integer.valueOf(paramInt) });
    }
    if (paramInt == 0) {
      try
      {
        String str = HippyQQFileUtil.getModuleFile(this.this$1.val$moduleName, 2147483646).getAbsolutePath();
        FileUtils.uncompressZip(paramFile.getAbsolutePath(), str, false);
        UpdateBase.checkAndResetLocalVersion(this.this$1.val$moduleName, 2147483646);
        if (this.this$1.val$updateListener != null)
        {
          this.this$1.val$updateListener.onUpdateComplete(0, "", str);
          return;
        }
      }
      catch (Exception paramFile)
      {
        QLog.e("Hippy", 1, paramFile, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQUpdateManager.2.1
 * JD-Core Version:    0.7.0.1
 */