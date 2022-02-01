package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class PreloadResHandler$5
  implements IPreloadService.OnGetPathListener
{
  PreloadResHandler$5(PreloadResHandler paramPreloadResHandler, String paramString, WeakReference paramWeakReference) {}
  
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
    String str;
    boolean bool;
    if (((i & j) != 0) && (!StringUtil.a(paramPathResult.filePath)))
    {
      str = paramPathResult.filePath;
      bool = true;
    }
    else
    {
      str = null;
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      if (paramPathResult == null) {
        paramPathResult = "null";
      } else {
        paramPathResult = paramPathResult.filePath;
      }
      QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadFilePath... onResult=%d path=%s url=%s", new Object[] { Integer.valueOf(paramInt), paramPathResult, this.jdField_a_of_type_JavaLangString }));
    }
    paramPathResult = (PreloadResHandler)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (paramPathResult != null) {
      paramPathResult.a(bool, this.jdField_a_of_type_JavaLangString, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.PreloadResHandler.5
 * JD-Core Version:    0.7.0.1
 */