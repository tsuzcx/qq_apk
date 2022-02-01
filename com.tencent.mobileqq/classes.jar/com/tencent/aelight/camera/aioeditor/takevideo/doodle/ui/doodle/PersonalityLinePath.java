package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class PersonalityLinePath
  extends DoodleLinePath
{
  public String b;
  CopyOnWriteArrayList<PointF> c = new CopyOnWriteArrayList();
  int d;
  int e;
  volatile boolean f;
  volatile boolean g;
  volatile boolean h;
  boolean i;
  int j;
  Frame k;
  boolean l = false;
  ArrayList<DoodleMagicAlgoHandler.RenderPoint> m = new ArrayList();
  
  public PersonalityLinePath(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1);
    this.b = paramString;
    this.e = paramInt2;
    this.c.clear();
    this.f = false;
    this.h = false;
  }
  
  public Frame a(int paramInt1, int paramInt2)
  {
    this.j = RendererUtils.createTexture();
    this.k = new Frame();
    GLES20.glBindTexture(3553, this.j);
    this.k.bindFrame(this.j, paramInt1, paramInt2, 1.0D);
    GLES20.glBindFramebuffer(36160, this.k.getFBO());
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFlush();
    return this.k;
  }
  
  public void a()
  {
    if (this.h)
    {
      Frame localFrame = this.k;
      if ((localFrame != null) && (!this.l))
      {
        this.l = true;
        localFrame.clear();
        RendererUtils.clearTexture(this.j);
      }
    }
  }
  
  public void b()
  {
    this.f = true;
    this.g = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.PersonalityLinePath
 * JD-Core Version:    0.7.0.1
 */