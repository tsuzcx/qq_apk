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
    if (paramInt == 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramPathResult != null) {
      j = 1;
    } else {
      j = 0;
    }
    Object localObject;
    if (((i & j) != 0) && (!StringUtil.a(paramPathResult.filePath)) && (!StringUtil.a(paramPathResult.folderPath)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramPathResult.folderPath);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      PreloadResHandler.a(((StringBuilder)localObject).toString(), this.b, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryPreloadResHandler.a);
    }
    if (QLog.isColorLevel())
    {
      String str2 = this.jdField_a_of_type_JavaLangString;
      String str3 = this.b;
      String str1 = "null";
      if (paramPathResult == null) {
        localObject = "null";
      } else {
        localObject = paramPathResult.filePath;
      }
      if (paramPathResult == null) {
        paramPathResult = str1;
      } else {
        paramPathResult = paramPathResult.folderPath;
      }
      QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadBitmapOfZip... onResult=%d fileName=[%s] defaultResName=[%s] \npath=%s folder=%s", new Object[] { Integer.valueOf(paramInt), str2, str3, localObject, paramPathResult }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.PreloadResHandler.6
 * JD-Core Version:    0.7.0.1
 */