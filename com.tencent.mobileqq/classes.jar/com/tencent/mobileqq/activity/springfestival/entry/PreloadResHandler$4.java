package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class PreloadResHandler$4
  implements IPreloadService.OnGetPathListener
{
  PreloadResHandler$4(PreloadResHandler paramPreloadResHandler) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if (QLog.isColorLevel())
    {
      String str2 = "null";
      String str1;
      if (paramPathResult == null) {
        str1 = "null";
      } else {
        str1 = paramPathResult.filePath;
      }
      if (paramPathResult == null) {
        paramPathResult = str2;
      } else {
        paramPathResult = paramPathResult.folderPath;
      }
      QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadFolderPathOfZip... onResult=%d \npath=%s folder=%s", new Object[] { Integer.valueOf(paramInt), str1, paramPathResult }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.PreloadResHandler.4
 * JD-Core Version:    0.7.0.1
 */