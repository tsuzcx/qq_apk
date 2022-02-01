package com.tencent.mm.opensdk.channel;

import android.os.Bundle;

public class MMessageActV2$Args
{
  public static final int INVALID_FLAGS = -1;
  public Bundle bundle;
  public String content;
  public int flags = -1;
  public int launchMode = 2;
  public String targetClassName;
  public String targetPkgName;
  public String token;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("targetPkgName:");
    localStringBuilder.append(this.targetPkgName);
    localStringBuilder.append(", targetClassName:");
    localStringBuilder.append(this.targetClassName);
    localStringBuilder.append(", content:");
    localStringBuilder.append(this.content);
    localStringBuilder.append(", flags:");
    localStringBuilder.append(this.flags);
    localStringBuilder.append(", bundle:");
    localStringBuilder.append(this.bundle);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.opensdk.channel.MMessageActV2.Args
 * JD-Core Version:    0.7.0.1
 */