package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.activity.springfestival.entry.model.ZipRes;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

class ZipResCheckHandler$1
  implements IPreloadService.OnGetPathListener
{
  ZipResCheckHandler$1(ZipResCheckHandler paramZipResCheckHandler, ZipRes paramZipRes) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    boolean bool = QLog.isColorLevel();
    int i = 1;
    if (bool)
    {
      String str3 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelZipRes.url;
      String str2 = "null";
      String str1;
      if (paramPathResult == null) {
        str1 = "null";
      } else {
        str1 = paramPathResult.filePath;
      }
      if (paramPathResult != null) {
        str2 = paramPathResult.folderPath;
      }
      QLog.i("shua2021_ZipResCheckHandler", 2, String.format("downloadZipRes... onResult=%d zipUrl=[%s] \npath=%s folder=%s", new Object[] { Integer.valueOf(paramInt), str3, str1, str2 }));
    }
    if (paramInt == 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramPathResult == null) {
      i = 0;
    }
    if (((paramInt & i) != 0) && (!StringUtil.a(paramPathResult.filePath)) && (!StringUtil.a(paramPathResult.folderPath))) {
      ZipResCheckHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryZipResCheckHandler, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelZipRes.url, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ZipResCheckHandler.1
 * JD-Core Version:    0.7.0.1
 */