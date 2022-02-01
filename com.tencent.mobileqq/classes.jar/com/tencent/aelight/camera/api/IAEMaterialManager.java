package com.tencent.aelight.camera.api;

import com.tencent.aelight.camera.struct.camera.AEMaterialOnShow;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
public abstract interface IAEMaterialManager
  extends QRouteApi
{
  public abstract boolean isSpecialTemplate(VideoMaterial paramVideoMaterial);
  
  public abstract String materialListToString(@Nullable ArrayList<AEMaterialOnShow> paramArrayList);
  
  public abstract ArrayList<AEMaterialOnShow> stringToLastMaterialList(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.api.IAEMaterialManager
 * JD-Core Version:    0.7.0.1
 */