package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.api.IAEFilterManagerHolder;

public class AEFilterManagerHolderImpl
  implements IAEFilterManagerHolder
{
  public boolean isAEFilterManagerEmpty()
  {
    return AEFilterManagerHolder.getAEFilterManager() == null;
  }
  
  public void setIsAfterUpdateMaterial(boolean paramBoolean)
  {
    AEFilterManagerHolder.getAEFilterManager().g(paramBoolean);
  }
  
  public void updateLutGL(String paramString)
  {
    AEFilterManagerHolder.getAEFilterManager().c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.AEFilterManagerHolderImpl
 * JD-Core Version:    0.7.0.1
 */