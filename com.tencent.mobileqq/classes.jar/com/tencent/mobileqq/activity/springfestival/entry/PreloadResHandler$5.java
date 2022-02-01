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
    int j;
    label13:
    String str;
    if (paramInt == 0)
    {
      i = 1;
      if (paramPathResult == null) {
        break label118;
      }
      j = 1;
      if (((j & i) == 0) || (StringUtil.a(paramPathResult.filePath))) {
        break label132;
      }
      str = paramPathResult.filePath;
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        if (paramPathResult != null) {
          break label124;
        }
      }
      label118:
      label124:
      for (paramPathResult = "null";; paramPathResult = paramPathResult.filePath)
      {
        QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadFilePath... onResult=%d path=%s url=%s", new Object[] { Integer.valueOf(paramInt), paramPathResult, this.jdField_a_of_type_JavaLangString }));
        paramPathResult = (PreloadResHandler)this.jdField_a_of_type_MqqUtilWeakReference.get();
        if (paramPathResult != null) {
          paramPathResult.a(bool, this.jdField_a_of_type_JavaLangString, str);
        }
        return;
        i = 0;
        break;
        j = 0;
        break label13;
      }
      label132:
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.PreloadResHandler.5
 * JD-Core Version:    0.7.0.1
 */