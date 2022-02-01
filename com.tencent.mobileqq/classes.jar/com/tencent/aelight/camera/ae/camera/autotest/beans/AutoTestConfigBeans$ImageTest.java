package com.tencent.aelight.camera.ae.camera.autotest.beans;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AutoTestConfigBeans$ImageTest
{
  public String a;
  public int b;
  public int c;
  public boolean d;
  public String e;
  private String g;
  private String h;
  
  private void a()
  {
    if (this.g == null)
    {
      Object localObject = this.a;
      if (localObject == null) {
        return;
      }
      localObject = ((String)localObject).split(File.separator);
      localObject = localObject[(localObject.length - 1)];
      int i = ((String)localObject).lastIndexOf('.');
      if (i < 0) {
        return;
      }
      this.g = ((String)localObject).substring(0, i);
      this.h = ((String)localObject).substring(i);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file name:");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(",suffix:");
      ((StringBuilder)localObject).append(this.h);
      QLog.i("AutoTestConfigBeans", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  AutoTestConfigBeans.AutoTestNode a(AutoTestConfigBeans.AutoTestNode paramAutoTestNode, String paramString)
  {
    AutoTestConfigBeans.AutoTestNode localAutoTestNode;
    if (paramAutoTestNode == null) {
      localAutoTestNode = new AutoTestConfigBeans.AutoTestNode(this.f);
    } else {
      localAutoTestNode = paramAutoTestNode.b();
    }
    localAutoTestNode.a = this.a;
    localAutoTestNode.c = this.b;
    localAutoTestNode.d = this.c;
    localAutoTestNode.f = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/qq_img_auto_test/result_imgs/");
    localStringBuilder.append(paramString);
    localStringBuilder.append(this.e);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.g);
    localStringBuilder.append(paramAutoTestNode.n);
    localStringBuilder.append(this.h);
    localAutoTestNode.e = localStringBuilder.toString();
    return localAutoTestNode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.autotest.beans.AutoTestConfigBeans.ImageTest
 * JD-Core Version:    0.7.0.1
 */