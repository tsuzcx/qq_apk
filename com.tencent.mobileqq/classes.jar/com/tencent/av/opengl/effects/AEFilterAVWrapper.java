package com.tencent.av.opengl.effects;

import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.ttpic.openapi.model.VideoMaterial;

public abstract interface AEFilterAVWrapper
{
  public abstract int a(int paramInt, boolean paramBoolean1, FaceData paramFaceData, boolean paramBoolean2);
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(long paramLong);
  
  public abstract void a(PendantItem paramPendantItem, VideoMaterial paramVideoMaterial);
  
  public abstract void a(FaceData paramFaceData);
  
  public abstract void a(FilterDesc paramFilterDesc);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract boolean a(BeautyConfig paramBeautyConfig);
  
  public abstract void b();
  
  public abstract void b(int paramInt1, int paramInt2);
  
  public abstract boolean b();
  
  public abstract void c();
  
  public abstract void c(int paramInt1, int paramInt2);
  
  public abstract boolean c();
  
  public abstract boolean d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AEFilterAVWrapper
 * JD-Core Version:    0.7.0.1
 */