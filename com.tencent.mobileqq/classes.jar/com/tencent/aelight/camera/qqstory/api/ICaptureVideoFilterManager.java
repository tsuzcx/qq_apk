package com.tencent.aelight.camera.qqstory.api;

import android.content.Context;
import com.tencent.aelight.camera.struct.editor.FilterCategoryItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;

@QAPI(process={"all"})
public abstract interface ICaptureVideoFilterManager
  extends QRouteApi
{
  public abstract FilterDesc getFilterDesc(String paramString);
  
  public abstract String getQQFilterConfigpath();
  
  public abstract String getQQFilterResPath();
  
  public abstract int getQQShortVideoFilterConfigVersion(Context paramContext);
  
  public abstract FilterCategoryItem getSelectFilterCategoryItem();
  
  public abstract boolean needShowRedDot(int paramInt1, int paramInt2, String paramString);
  
  public abstract void updateQQShortVideoFilterConfig(Context paramContext, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.ICaptureVideoFilterManager
 * JD-Core Version:    0.7.0.1
 */