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
    Bitmap localBitmap;
    boolean bool;
    if (((i & j) != 0) && (!StringUtil.isEmpty(paramPathResult.filePath)))
    {
      localBitmap = PreloadResHandler.a(paramPathResult.filePath, this.a, this.d.c);
      bool = true;
    }
    else
    {
      localBitmap = null;
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadBitmap... defaultResName=[%s] onResult=%d %s", new Object[] { this.a, Integer.valueOf(paramInt), paramPathResult }));
    }
    paramPathResult = (PreloadResHandler)this.b.get();
    if (paramPathResult != null) {
      paramPathResult.a(bool, this.c, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.PreloadResHandler.3
 * JD-Core Version:    0.7.0.1
 */