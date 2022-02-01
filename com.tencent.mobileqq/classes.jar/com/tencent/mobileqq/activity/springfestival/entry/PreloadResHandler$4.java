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
    String str;
    if (QLog.isColorLevel())
    {
      if (paramPathResult != null) {
        break label51;
      }
      str = "null";
      if (paramPathResult != null) {
        break label59;
      }
    }
    label51:
    label59:
    for (paramPathResult = "null";; paramPathResult = paramPathResult.folderPath)
    {
      QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadFolderPathOfZip... onResult=%d \npath=%s folder=%s", new Object[] { Integer.valueOf(paramInt), str, paramPathResult }));
      return;
      str = paramPathResult.filePath;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.PreloadResHandler.4
 * JD-Core Version:    0.7.0.1
 */