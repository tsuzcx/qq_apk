package com.tencent.mobileqq.activity.springfestival.entry;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class PreloadResHandler$3
  implements IPreloadService.OnGetPathListener
{
  PreloadResHandler$3(PreloadResHandler paramPreloadResHandler, String paramString1, WeakReference paramWeakReference, String paramString2) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    int i;
    int j;
    label13:
    Bitmap localBitmap;
    if (paramInt == 0)
    {
      i = 1;
      if (paramPathResult == null) {
        break label125;
      }
      j = 1;
      if (((j & i) == 0) || (StringUtil.a(paramPathResult.filePath))) {
        break label131;
      }
      localBitmap = PreloadResHandler.a(paramPathResult.filePath, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryPreloadResHandler.a);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadBitmap... defaultResName=[%s] onResult=%d %s", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt), paramPathResult }));
      }
      paramPathResult = (PreloadResHandler)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (paramPathResult != null) {
        paramPathResult.a(bool, this.b, localBitmap);
      }
      return;
      i = 0;
      break;
      label125:
      j = 0;
      break label13;
      label131:
      localBitmap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.PreloadResHandler.3
 * JD-Core Version:    0.7.0.1
 */