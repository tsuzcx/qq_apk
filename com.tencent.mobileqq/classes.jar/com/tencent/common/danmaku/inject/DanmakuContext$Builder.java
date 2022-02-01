package com.tencent.common.danmaku.inject;

import com.tencent.common.danmaku.render.BaseDanmakuRender;
import java.util.ArrayList;
import java.util.List;

public final class DanmakuContext$Builder
{
  public int a = 3;
  public IDanmakuLineHeightDecider b;
  public IDanmakuCreator c;
  private boolean d;
  private IDanmakuPlayTimeSupplier e;
  private IDanmakuExposureCallback f;
  private IDanmakuDrawableFetcher g;
  private IDanmakuWindowConfigCreator h;
  private IDanmakuUIConfigCreator i;
  private List<BaseDanmakuRender> j = new ArrayList();
  private IDanmakuClearScreenCallback k;
  private IDanmakuWindowCreator l;
  private int m;
  private boolean n = false;
  
  public Builder a(int paramInt)
  {
    this.m = paramInt;
    return this;
  }
  
  public Builder a(IDanmakuCreator paramIDanmakuCreator)
  {
    this.c = paramIDanmakuCreator;
    return this;
  }
  
  public Builder a(IDanmakuExposureCallback paramIDanmakuExposureCallback)
  {
    this.f = paramIDanmakuExposureCallback;
    return this;
  }
  
  public Builder a(IDanmakuPlayTimeSupplier paramIDanmakuPlayTimeSupplier)
  {
    this.e = paramIDanmakuPlayTimeSupplier;
    return this;
  }
  
  public Builder a(IDanmakuUIConfigCreator paramIDanmakuUIConfigCreator)
  {
    this.i = paramIDanmakuUIConfigCreator;
    return this;
  }
  
  public Builder a(IDanmakuWindowCreator paramIDanmakuWindowCreator)
  {
    this.l = paramIDanmakuWindowCreator;
    return this;
  }
  
  public Builder a(BaseDanmakuRender paramBaseDanmakuRender)
  {
    this.j.add(paramBaseDanmakuRender);
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public DanmakuContext a()
  {
    return new DanmakuContext(this, null);
  }
  
  public Builder b(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.inject.DanmakuContext.Builder
 * JD-Core Version:    0.7.0.1
 */