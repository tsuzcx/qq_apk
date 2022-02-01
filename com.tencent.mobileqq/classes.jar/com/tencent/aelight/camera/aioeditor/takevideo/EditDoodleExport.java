package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;

public abstract interface EditDoodleExport
  extends EditVideoPart.EditExport
{
  public abstract Bitmap a(int paramInt, boolean paramBoolean);
  
  public abstract void a(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void a(Bitmap paramBitmap);
  
  public abstract boolean a(int paramInt);
  
  @NonNull
  public abstract DoodleLayout b();
  
  public abstract boolean c();
  
  public abstract void d();
  
  public abstract boolean h();
  
  public abstract Bitmap i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditDoodleExport
 * JD-Core Version:    0.7.0.1
 */