package com.tencent.image;

import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;

class QQLiveImage$OnLogListener
  implements TVK_SDKMgr.OnLogListener
{
  public int d(String paramString1, String paramString2)
  {
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    URLDrawable.depImp.mLog.e(paramString1, 1, paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.i(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.w(paramString1, 2, paramString2);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.OnLogListener
 * JD-Core Version:    0.7.0.1
 */