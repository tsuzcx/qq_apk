package com.tencent.aelight.camera.cmsshow.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CmShowDataWrapper
  implements Serializable
{
  public String cmJsonString;
  public Map<String, Integer> dressidMaps;
  public int errorCode = 0;
  public String errorMessage;
  public HashMap<String, String> namePathMap;
  public String rolePath;
  public int sceneMode;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{sceneMode=");
    localStringBuilder.append(this.sceneMode);
    localStringBuilder.append(", namePathMap=");
    localStringBuilder.append(this.namePathMap);
    localStringBuilder.append(", rolePath=");
    localStringBuilder.append(this.rolePath);
    localStringBuilder.append(", dressidMaps=");
    localStringBuilder.append(this.dressidMaps);
    localStringBuilder.append(", cmJsonString=");
    localStringBuilder.append(this.cmJsonString);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper
 * JD-Core Version:    0.7.0.1
 */