package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class PreloadResHandler$6
  implements IPreloadService.OnGetPathListener
{
  PreloadResHandler$6(PreloadResHandler paramPreloadResHandler, String paramString1, String paramString2) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    int i;
    int j;
    label13:
    String str2;
    String str3;
    String str1;
    if (paramInt == 0)
    {
      i = 1;
      if (paramPathResult == null) {
        break label165;
      }
      j = 1;
      if (((j & i) != 0) && (!StringUtil.a(paramPathResult.filePath)) && (!StringUtil.a(paramPathResult.folderPath))) {
        PreloadResHandler.a(paramPathResult.folderPath + File.separator + this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryPreloadResHandler.a);
      }
      if (QLog.isColorLevel())
      {
        str2 = this.jdField_a_of_type_JavaLangString;
        str3 = this.b;
        if (paramPathResult != null) {
          break label171;
        }
        str1 = "null";
        label111:
        if (paramPathResult != null) {
          break label180;
        }
      }
    }
    label165:
    label171:
    label180:
    for (paramPathResult = "null";; paramPathResult = paramPathResult.folderPath)
    {
      QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadBitmapOfZip... onResult=%d fileName=[%s] defaultResName=[%s] \npath=%s folder=%s", new Object[] { Integer.valueOf(paramInt), str2, str3, str1, paramPathResult }));
      return;
      i = 0;
      break;
      j = 0;
      break label13;
      str1 = paramPathResult.filePath;
      break label111;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.PreloadResHandler.6
 * JD-Core Version:    0.7.0.1
 */