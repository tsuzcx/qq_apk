package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase;
import com.tencent.aelight.camera.aioeditor.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import com.tencent.common.app.AppInterface;

public class CaptureComboPtvTemplate
  extends CaptureComboBase
{
  private int f = 2;
  private float g = 0.0F;
  private AppInterface h = QIMManager.c();
  private QIMPtvTemplateManager i = (QIMPtvTemplateManager)QIMManager.a(3);
  private PtvTemplateInfo j = this.i.a(paramString);
  private PtvTemplateManager.IPtvTemplateDownloadListener k = new CaptureComboPtvTemplate.1(this);
  
  public CaptureComboPtvTemplate(String paramString)
  {
    super(null);
    paramString = this.j;
    if ((paramString != null) && (paramString.g))
    {
      this.f = 3;
      return;
    }
    if (this.j == null) {
      this.f = 3;
    }
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    paramActivity = this.j;
    if ((paramActivity != null) && (paramActivity.g))
    {
      paramActivity = new StringBuilder();
      paramActivity.append(QIMPtvTemplateManager.b);
      paramActivity.append(this.j.e);
      paramActivity = paramActivity.toString();
      this.i.a(this.j, 111);
      this.i.a(this.j.a, this.j.l, paramActivity);
      return 0;
    }
    return -1;
  }
  
  public void b(Activity paramActivity, int paramInt) {}
  
  public int c()
  {
    try
    {
      int m = this.f;
      return m;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int d()
  {
    try
    {
      if (this.j == null)
      {
        this.f = 3;
        m = this.f;
        return m;
      }
      if (!this.j.g)
      {
        this.i.a(this.h, this.j, this.k);
        a();
        this.f = 1;
      }
      else if (this.j.h)
      {
        this.f = 1;
      }
      else
      {
        this.g = 1.0F;
        this.f = 3;
        b();
      }
      int m = this.f;
      return m;
    }
    finally {}
  }
  
  public float e()
  {
    try
    {
      float f1 = this.g;
      return f1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboPtvTemplate
 * JD-Core Version:    0.7.0.1
 */