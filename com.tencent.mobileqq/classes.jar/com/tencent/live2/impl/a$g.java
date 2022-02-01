package com.tencent.live2.impl;

import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolutionMode;

public class a$g
{
  public int a = 544;
  public int b = 960;
  public int c = 15;
  public int d = 1200;
  
  public a$g() {}
  
  public a$g(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution, V2TXLiveDef.V2TXLiveVideoResolutionMode paramV2TXLiveVideoResolutionMode)
  {
    paramV2TXLiveVideoResolutionMode = b.a(paramV2TXLiveVideoResolution, paramV2TXLiveVideoResolutionMode);
    this.a = paramV2TXLiveVideoResolutionMode.a;
    this.b = paramV2TXLiveVideoResolutionMode.b;
    this.d = b.b(paramV2TXLiveVideoResolution).b;
    this.c = 15;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[width:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("][height:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("][fps:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("][bitrate:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.a.g
 * JD-Core Version:    0.7.0.1
 */