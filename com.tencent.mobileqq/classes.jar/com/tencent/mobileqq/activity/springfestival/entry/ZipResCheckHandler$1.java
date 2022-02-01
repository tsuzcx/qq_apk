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
    String str1;
    String str2;
    if (QLog.isColorLevel())
    {
      String str3 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelZipRes.url;
      if (paramPathResult == null)
      {
        str1 = "null";
        if (paramPathResult != null) {
          break label131;
        }
        str2 = "null";
        label31:
        QLog.i("shua2021_ZipResCheckHandler", 2, String.format("downloadZipRes... onResult=%d zipUrl=[%s] \npath=%s folder=%s", new Object[] { Integer.valueOf(paramInt), str3, str1, str2 }));
      }
    }
    else
    {
      if (paramInt != 0) {
        break label140;
      }
      paramInt = 1;
      label74:
      if (paramPathResult == null) {
        break label145;
      }
    }
    label131:
    label140:
    label145:
    for (int i = 1;; i = 0)
    {
      if (((i & paramInt) != 0) && (!StringUtil.a(paramPathResult.filePath)) && (!StringUtil.a(paramPathResult.folderPath))) {
        ZipResCheckHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryZipResCheckHandler, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryModelZipRes.url, false);
      }
      return;
      str1 = paramPathResult.filePath;
      break;
      str2 = paramPathResult.folderPath;
      break label31;
      paramInt = 0;
      break label74;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ZipResCheckHandler.1
 * JD-Core Version:    0.7.0.1
 */