package com.tencent.aelight.camera.ae.cmshow.config;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AECMShowConfig$CmShowResBean
  implements Serializable
{
  @SerializedName("and_md5")
  public String androidMd5;
  @SerializedName("and_url")
  public String androidUrl;
  @SerializedName("ios_md5")
  public String iOSMd5;
  @SerializedName("ios_url")
  public String iOSUrl;
  public String id;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", iOSUrl=");
    localStringBuilder.append(this.iOSUrl);
    localStringBuilder.append(", iOSMd5=");
    localStringBuilder.append(this.iOSMd5);
    localStringBuilder.append(", androidUrl=");
    localStringBuilder.append(this.androidUrl);
    localStringBuilder.append(", androidMd5=");
    localStringBuilder.append(this.androidMd5);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.config.AECMShowConfig.CmShowResBean
 * JD-Core Version:    0.7.0.1
 */