package com.tencent.mm.opensdk.channel;

import android.os.Bundle;

public class MMessageActV2$Args
{
  public static final int INVALID_FLAGS = -1;
  public Bundle bundle;
  public String content;
  public int flags = -1;
  public String targetClassName;
  public String targetPkgName;
  public String token;
  
  public String toString()
  {
    return "targetPkgName:" + this.targetPkgName + ", targetClassName:" + this.targetClassName + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.bundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.opensdk.channel.MMessageActV2.Args
 * JD-Core Version:    0.7.0.1
 */