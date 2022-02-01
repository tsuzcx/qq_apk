package com.tencent.luggage.wxa.sn;

import android.graphics.Point;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wmpf/samelayer/recordview/camera/CameraConfig;", "", "()V", "encodeVideoBestSizeHeight", "", "getEncodeVideoBestSizeHeight", "()I", "setEncodeVideoBestSizeHeight", "(I)V", "encodeVideoBestSizeWidth", "getEncodeVideoBestSizeWidth", "setEncodeVideoBestSizeWidth", "isCpuCrop", "", "()Z", "setCpuCrop", "(Z)V", "isFrontCamera", "setFrontCamera", "previewHeight", "getPreviewHeight", "setPreviewHeight", "previewWidth", "getPreviewWidth", "setPreviewWidth", "rotateDegree", "getRotateDegree", "setRotateDegree", "cameraTextureSize", "Landroid/graphics/Point;", "toString", "", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public class a
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private boolean f;
  private boolean g;
  
  public final int a()
  {
    return this.c;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final boolean b()
  {
    return this.f;
  }
  
  @NotNull
  public final Point c()
  {
    return new Point(this.b, this.a);
  }
  
  public final void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("previewHeight: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ,previewWidth:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ,rotateDegree: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ,isFrontCamera:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(' ');
    localStringBuilder.append(" encodeVideoBestSizeWidth : ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" , encodeVideoBestSizeHeight : ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", isCpuCrop: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(' ');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sn.a
 * JD-Core Version:    0.7.0.1
 */