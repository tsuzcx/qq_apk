package com.tencent.luggage.wxa.sq;

import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wmpf/samelayer/recordview/util/LuggageGLEnvironmentUtil$EGLEnvironment;", "", "disPlay", "Landroid/opengl/EGLDisplay;", "eglSurface", "Landroid/opengl/EGLSurface;", "eglContext", "Landroid/opengl/EGLContext;", "(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)V", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public final class a$b
{
  @JvmField
  @NotNull
  public EGLDisplay a;
  @JvmField
  @NotNull
  public EGLSurface b;
  @JvmField
  @NotNull
  public EGLContext c;
  
  public a$b(@NotNull EGLDisplay paramEGLDisplay, @NotNull EGLSurface paramEGLSurface, @NotNull EGLContext paramEGLContext)
  {
    this.a = paramEGLDisplay;
    this.b = paramEGLSurface;
    this.c = paramEGLContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sq.a.b
 * JD-Core Version:    0.7.0.1
 */