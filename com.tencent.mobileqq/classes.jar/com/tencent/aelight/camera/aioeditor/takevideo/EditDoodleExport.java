package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;

public abstract interface EditDoodleExport
  extends EditVideoPart.EditExport
{
  public abstract Bitmap a();
  
  public abstract Bitmap a(int paramInt, boolean paramBoolean);
  
  @NonNull
  public abstract DoodleLayout a();
  
  public abstract void a(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void a(Bitmap paramBitmap);
  
  public abstract boolean a(int paramInt);
  
  public abstract void b();
  
  public abstract boolean e_();
  
  public abstract boolean f_();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditDoodleExport
 * JD-Core Version:    0.7.0.1
 */