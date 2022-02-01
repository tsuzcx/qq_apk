package com.tencent.aelight.camera.ae.perf;

import android.text.TextUtils;
import com.tencent.aekit.openrender.util.AEProfilerBase;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.List;

public class AEFpsManager
  extends AEProfilerBase
  implements IAEFpsManager
{
  private static boolean a = false;
  private boolean b = false;
  private List<Float> c = new ArrayList();
  private long d = 0L;
  private long e = 0L;
  private int f = 0;
  private boolean g = false;
  private String h = "none";
  
  public AEFpsManager()
  {
    a = false;
    this.mEnableBase = true;
  }
  
  private void a(String paramString)
  {
    if (a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report fps: ");
      localStringBuilder.append(paramString);
      QLog.i("AEFpsManager", 2, localStringBuilder.toString());
    }
  }
  
  private void h()
  {
    a("startMonitor");
    this.b = true;
  }
  
  private void i()
  {
    if (this.b)
    {
      if (this.g) {
        return;
      }
      if (System.currentTimeMillis() - this.d < 5000L) {
        return;
      }
      int i = this.f;
      if (i >= 30)
      {
        long l = this.e;
        if (l > 0L)
        {
          float f1 = i * 1000.0F / (float)l;
          if (this.c.size() >= 500) {
            this.c.remove(0);
          }
          this.c.add(Float.valueOf(f1));
        }
        this.f = 0;
        this.e = 0L;
        return;
      }
      if (this.mOneFrameCost != 0L)
      {
        this.e += this.mOneFrameCost;
        this.f += 1;
      }
    }
  }
  
  private float j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAverageFps: fps list size=");
    localStringBuilder.append(this.c.size());
    a(localStringBuilder.toString());
    float f1 = 0.0F;
    int i = 0;
    while (i < this.c.size())
    {
      f1 += ((Float)this.c.get(i)).floatValue();
      i += 1;
    }
    return f1 / this.c.size();
  }
  
  private void k()
  {
    if (this.c.size() == 0) {
      return;
    }
    float f1 = j();
    Object localObject = AEBaseDataReporter.a();
    String str = this.h;
    boolean bool;
    if (FlowCameraConstant.b == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((AEBaseDataReporter)localObject).a(str, bool, f1, 0.0D, 0.0D, "");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=");
    ((StringBuilder)localObject).append(f1);
    a(((StringBuilder)localObject).toString());
  }
  
  public void a()
  {
    a("stopMonitor");
    this.b = false;
    this.d = 0L;
    this.e = 0L;
    this.f = 0;
    this.c.clear();
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMaterialSelected, useMaterial=");
    localStringBuilder.append(paramVideoMaterial);
    a(localStringBuilder.toString());
    if ((paramVideoMaterial != null) && (!TextUtils.isEmpty(paramVideoMaterial.getId()))) {
      this.h = paramVideoMaterial.getId();
    } else {
      this.h = "none";
    }
    a();
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    a("onCameraSwitch");
    k();
    a();
    h();
  }
  
  public void b()
  {
    a("onCameraOpened");
  }
  
  public void b(boolean paramBoolean)
  {
    a("onModeChangedToGif");
    this.g = paramBoolean;
    if (paramBoolean) {
      a();
    }
  }
  
  public void c()
  {
    a("onFirstFrame");
    this.d = System.currentTimeMillis();
    h();
  }
  
  public void d()
  {
    i();
  }
  
  public void e()
  {
    a("onCaptureVideo");
    k();
    a();
  }
  
  public void f()
  {
    a("onEnterActivity");
  }
  
  public void g()
  {
    a("onExitActivity");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.perf.AEFpsManager
 * JD-Core Version:    0.7.0.1
 */