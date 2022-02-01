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
  private static boolean jdField_a_of_type_Boolean = false;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString = "none";
  private List<Float> jdField_a_of_type_JavaUtilList = new ArrayList();
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  public AEFpsManager()
  {
    jdField_a_of_type_Boolean = false;
    this.mEnableBase = true;
  }
  
  private float a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAverageFps: fps list size=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
    a(localStringBuilder.toString());
    float f = 0.0F;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      f += ((Float)this.jdField_a_of_type_JavaUtilList.get(i)).floatValue();
      i += 1;
    }
    return f / this.jdField_a_of_type_JavaUtilList.size();
  }
  
  private void a(String paramString)
  {
    if (jdField_a_of_type_Boolean)
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
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.c) {
        return;
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 5000L) {
        return;
      }
      int i = this.jdField_a_of_type_Int;
      if (i >= 30)
      {
        long l = this.jdField_b_of_type_Long;
        if (l > 0L)
        {
          float f = i * 1000.0F / (float)l;
          if (this.jdField_a_of_type_JavaUtilList.size() >= 500) {
            this.jdField_a_of_type_JavaUtilList.remove(0);
          }
          this.jdField_a_of_type_JavaUtilList.add(Float.valueOf(f));
        }
        this.jdField_a_of_type_Int = 0;
        this.jdField_b_of_type_Long = 0L;
        return;
      }
      if (this.mOneFrameCost != 0L)
      {
        this.jdField_b_of_type_Long += this.mOneFrameCost;
        this.jdField_a_of_type_Int += 1;
      }
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    float f = a();
    Object localObject = AEBaseDataReporter.a();
    String str = this.jdField_a_of_type_JavaLangString;
    boolean bool;
    if (FlowCameraConstant.jdField_a_of_type_Int == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((AEBaseDataReporter)localObject).a(str, bool, f, 0.0D, 0.0D, "");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fps=");
    ((StringBuilder)localObject).append(f);
    a(((StringBuilder)localObject).toString());
  }
  
  public void a()
  {
    a("stopMonitor");
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMaterialSelected, useMaterial=");
    localStringBuilder.append(paramVideoMaterial);
    a(localStringBuilder.toString());
    if ((paramVideoMaterial != null) && (!TextUtils.isEmpty(paramVideoMaterial.getId()))) {
      this.jdField_a_of_type_JavaLangString = paramVideoMaterial.getId();
    } else {
      this.jdField_a_of_type_JavaLangString = "none";
    }
    a();
    h();
  }
  
  public void a(boolean paramBoolean)
  {
    a("onCameraSwitch");
    j();
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
    this.c = paramBoolean;
    if (paramBoolean) {
      a();
    }
  }
  
  public void c()
  {
    a("onFirstFrame");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    h();
  }
  
  public void d()
  {
    i();
  }
  
  public void e()
  {
    a("onCaptureVideo");
    j();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.perf.AEFpsManager
 * JD-Core Version:    0.7.0.1
 */