package com.tencent.aelight.camera.qqstory.api.impl;

import android.content.Context;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager;
import com.tencent.aelight.camera.struct.editor.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;

public class CaptureVideoFilterManagerImpl
  implements ICaptureVideoFilterManager
{
  public FilterDesc getFilterDesc(String paramString)
  {
    return CaptureVideoFilterManager.a().a(paramString);
  }
  
  public String getQQFilterConfigpath()
  {
    return CaptureVideoFilterManager.a;
  }
  
  public String getQQFilterResPath()
  {
    return CaptureVideoFilterManager.b;
  }
  
  public int getQQShortVideoFilterConfigVersion(Context paramContext)
  {
    CaptureVideoFilterManager.a();
    return CaptureVideoFilterManager.a(paramContext);
  }
  
  public FilterCategoryItem getSelectFilterCategoryItem()
  {
    return CaptureVideoFilterManager.a().a();
  }
  
  public boolean needShowRedDot(int paramInt1, int paramInt2, String paramString)
  {
    return CaptureVideoFilterManager.a().a(paramInt1, paramInt2, paramString);
  }
  
  public void updateQQShortVideoFilterConfig(Context paramContext, String paramString, int paramInt)
  {
    CaptureVideoFilterManager.a().a(paramContext, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.CaptureVideoFilterManagerImpl
 * JD-Core Version:    0.7.0.1
 */