package com.tencent.live2.impl;

import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolutionMode;

public class a$e
{
  public int a = 15;
  public int b = 1300;
  public int c = 850;
  public int d = 3;
  public int e;
  public boolean f;
  public int g;
  public int h;
  
  public a$e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.e = 1;
    this.f = true;
    this.g = -1;
    this.h = -1;
    this.a = paramInt2;
    this.b = paramInt5;
    this.c = paramInt4;
    this.d = paramInt3;
    this.e = paramInt1;
    this.f = b.a(paramInt1);
    this.g = paramInt6;
    this.h = paramInt7;
  }
  
  public a$e(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution, V2TXLiveDef.V2TXLiveVideoResolutionMode paramV2TXLiveVideoResolutionMode)
  {
    boolean bool = true;
    this.e = 1;
    this.f = true;
    this.g = -1;
    this.h = -1;
    this.e = b.a(paramV2TXLiveVideoResolution);
    paramV2TXLiveVideoResolution = b.b(paramV2TXLiveVideoResolution);
    this.c = paramV2TXLiveVideoResolution.a;
    this.b = paramV2TXLiveVideoResolution.b;
    this.a = 15;
    this.d = 3;
    V2TXLiveDef.V2TXLiveVideoResolutionMode localV2TXLiveVideoResolutionMode = V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait;
    int i = 0;
    if (paramV2TXLiveVideoResolutionMode != localV2TXLiveVideoResolutionMode) {
      bool = false;
    }
    this.f = bool;
    if (paramV2TXLiveVideoResolution.a == paramV2TXLiveVideoResolution.b) {
      i = -1;
    }
    this.h = i;
    this.g = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[resolution:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("][fps:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("][gop:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("][maxBitrate:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("][minBitrate:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("][homeOrientation:");
    localStringBuilder.append(this.g);
    localStringBuilder.append("][portrait:");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.a.e
 * JD-Core Version:    0.7.0.1
 */