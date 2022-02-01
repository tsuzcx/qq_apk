package com.tencent.av.opengl.effects;

import com.tencent.av.business.manager.avatar2d.Avatar2dItem;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.ttpic.openapi.model.VideoMaterial;

public class RenderParams
{
  public FilterDesc a;
  public VideoMaterial b;
  public PendantItem c;
  public Avatar2dItem d;
  public boolean e;
  public boolean f;
  public boolean g = false;
  
  public RenderParams()
  {
    a();
  }
  
  public void a()
  {
    this.a = null;
    this.b = null;
    this.e = false;
    this.f = false;
    this.c = null;
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.RenderParams
 * JD-Core Version:    0.7.0.1
 */