package com.tencent.aelight.camera.ae.cmshow.config;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AECMShowConfig$RequestConfig
  implements Serializable
{
  @SerializedName("img_max_length")
  public int imgMaxLength;
  @SerializedName("img_quality")
  public float imgQuality;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{imgMaxLength=");
    localStringBuilder.append(this.imgMaxLength);
    localStringBuilder.append(", imgQuality=");
    localStringBuilder.append(this.imgQuality);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.config.AECMShowConfig.RequestConfig
 * JD-Core Version:    0.7.0.1
 */