package com.tencent.aelight.camera.qqstory.api.impl;

import android.content.Context;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMBeautyManager;
import com.tencent.aelight.camera.qqstory.api.IQIMBeautyManager;

public class QIMBeautyManagerImpl
  implements IQIMBeautyManager
{
  public int getBeautyConfigVersion(Context paramContext)
  {
    return QIMBeautyManager.a().a(paramContext);
  }
  
  public void parseConfig()
  {
    QIMBeautyManager.a().b();
  }
  
  public boolean saveBeautyConfig(String paramString, int paramInt, Context paramContext)
  {
    return QIMBeautyManager.a().a(paramString, paramInt, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.QIMBeautyManagerImpl
 * JD-Core Version:    0.7.0.1
 */