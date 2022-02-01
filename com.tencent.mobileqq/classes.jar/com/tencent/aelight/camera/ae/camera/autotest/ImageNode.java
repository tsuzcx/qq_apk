package com.tencent.aelight.camera.ae.camera.autotest;

import com.tencent.aelight.camera.ae.camera.autotest.beans.AutoTestConfigBeans.AutoTestNode;
import com.tencent.aelight.camera.ae.camera.autotest.beans.AutoTestConfigBeans.LipsLUTConfig;
import com.tencent.aelight.camera.ae.camera.autotest.beans.AutoTestConfigBeans.SpecialConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ImageNode
{
  private AutoTestConfigBeans.AutoTestNode a;
  private int b;
  private boolean c;
  private AutoImageTestManager.IParamsListener d;
  private final boolean e;
  
  public ImageNode(AutoTestConfigBeans.AutoTestNode paramAutoTestNode)
  {
    boolean bool = false;
    this.b = 0;
    this.c = false;
    this.a = paramAutoTestNode;
    if (this.a.c < 5) {
      this.a.c = 5;
    }
    if (this.a.d < 4) {
      this.a.d = 4;
    }
    if (this.a.k == null) {
      bool = true;
    }
    this.c = bool;
    this.e = new File(paramAutoTestNode.a).exists();
  }
  
  private void g()
  {
    if (this.d == null) {
      return;
    }
    h();
    if (this.b > 0) {
      return;
    }
    i();
    j();
    k();
    l();
    n();
    m();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.a);
    localStringBuilder.append(" 首次初始化完成:");
    localStringBuilder.append(this.a.n);
    QLog.d("ImageNode", 4, localStringBuilder.toString());
  }
  
  private void h()
  {
    if (!this.c)
    {
      if (this.a.k == null) {
        return;
      }
      if (this.a.k.a == null)
      {
        this.d.a(null, this.a.k.b);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadMaterial:none,");
        ((StringBuilder)localObject).append(this.a.k.b);
        QLog.d("ImageNode", 4, ((StringBuilder)localObject).toString());
        this.c = true;
        return;
      }
      Object localObject = this.d.a(this.a.k.a);
      if (localObject == null) {
        return;
      }
      this.d.a((VideoMaterial)localObject, this.a.k.b);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMaterial:");
      localStringBuilder.append(((VideoMaterial)localObject).getId());
      localStringBuilder.append(",");
      localStringBuilder.append(this.a.k.b);
      QLog.d("ImageNode", 4, localStringBuilder.toString());
      this.c = true;
    }
  }
  
  private void i()
  {
    if (this.a.h == null) {
      return;
    }
    AutoTestConfigBeans.LipsLUTConfig localLipsLUTConfig = this.a.h;
    this.d.a(localLipsLUTConfig.a, localLipsLUTConfig.b, localLipsLUTConfig.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initLipsLut:");
    localStringBuilder.append(localLipsLUTConfig.a);
    localStringBuilder.append(",");
    localStringBuilder.append(localLipsLUTConfig.b);
    localStringBuilder.append(",");
    localStringBuilder.append(localLipsLUTConfig.c);
    QLog.d("ImageNode", 4, localStringBuilder.toString());
  }
  
  private void j()
  {
    if (this.a.i == null) {
      return;
    }
    AutoTestConfigBeans.SpecialConfig localSpecialConfig = this.a.i;
    this.d.b(localSpecialConfig.a, localSpecialConfig.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initRedCheek:");
    localStringBuilder.append(localSpecialConfig.a);
    localStringBuilder.append(",");
    localStringBuilder.append(localSpecialConfig.b);
    QLog.d("ImageNode", 4, localStringBuilder.toString());
  }
  
  private void k()
  {
    if (this.a.j == null) {
      return;
    }
    AutoTestConfigBeans.SpecialConfig localSpecialConfig = this.a.j;
    this.d.c(localSpecialConfig.a, localSpecialConfig.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initFaceSoft:");
    localStringBuilder.append(localSpecialConfig.a);
    localStringBuilder.append(",");
    localStringBuilder.append(localSpecialConfig.b);
    QLog.d("ImageNode", 4, localStringBuilder.toString());
  }
  
  private void l()
  {
    if (this.a.l == null) {
      return;
    }
    this.d.b(this.a.l);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initThinFace:");
    localStringBuilder.append(this.a.l);
    QLog.d("ImageNode", 4, localStringBuilder.toString());
  }
  
  private void m()
  {
    if (this.a.m == null) {
      return;
    }
    AutoTestConfigBeans.SpecialConfig localSpecialConfig = this.a.m;
    this.d.a(localSpecialConfig.a, localSpecialConfig.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initLUT:");
    localStringBuilder.append(localSpecialConfig.a);
    localStringBuilder.append(",");
    localStringBuilder.append(localSpecialConfig.b);
    QLog.d("ImageNode", 4, localStringBuilder.toString());
  }
  
  private void n()
  {
    HashMap localHashMap = this.a.a();
    if (localHashMap != null)
    {
      if (localHashMap.size() == 0) {
        return;
      }
      Object localObject = localHashMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        this.d.a((BeautyRealConfig.TYPE)localEntry.getKey(), ((Integer)localEntry.getValue()).intValue());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initBeautyParams: ");
      ((StringBuilder)localObject).append(localHashMap);
      QLog.d("ImageNode", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public String a()
  {
    return this.a.a;
  }
  
  public void a(AutoImageTestManager.IParamsListener paramIParamsListener)
  {
    this.d = paramIParamsListener;
  }
  
  public String b()
  {
    return this.a.e;
  }
  
  public boolean c()
  {
    return this.a.f;
  }
  
  public void d()
  {
    g();
    this.b += 1;
  }
  
  public boolean e()
  {
    return (!this.e) || (this.b > this.a.c);
  }
  
  public boolean f()
  {
    return this.b == this.a.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.autotest.ImageNode
 * JD-Core Version:    0.7.0.1
 */