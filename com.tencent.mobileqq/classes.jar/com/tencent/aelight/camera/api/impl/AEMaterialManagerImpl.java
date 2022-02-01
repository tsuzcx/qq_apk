package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.api.IAEMaterialManager;
import com.tencent.aelight.camera.struct.camera.AEMaterialOnShow;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

public class AEMaterialManagerImpl
  implements IAEMaterialManager
{
  public boolean isSpecialTemplate(VideoMaterial paramVideoMaterial)
  {
    return AEMaterialManager.a(paramVideoMaterial);
  }
  
  public String materialListToString(@Nullable ArrayList<AEMaterialOnShow> paramArrayList)
  {
    return AEMaterialManager.a(paramArrayList);
  }
  
  public ArrayList<AEMaterialOnShow> stringToLastMaterialList(@Nullable String paramString)
  {
    return AEMaterialManager.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.AEMaterialManagerImpl
 * JD-Core Version:    0.7.0.1
 */