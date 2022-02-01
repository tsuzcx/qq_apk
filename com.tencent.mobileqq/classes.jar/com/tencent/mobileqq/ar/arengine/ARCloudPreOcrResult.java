package com.tencent.mobileqq.ar.arengine;

import com.tencent.qphone.base.util.QLog;

public class ARCloudPreOcrResult
  extends ARLocalRecogResultBase
{
  public int a;
  public String b;
  public String c;
  public int d;
  public String e;
  public int f;
  public float g;
  
  public ARCloudPreOcrResult()
  {
    this.j = 64L;
  }
  
  public static boolean a(ARCloudPreOcrResult paramARCloudPreOcrResult)
  {
    boolean bool;
    if ((paramARCloudPreOcrResult != null) && (paramARCloudPreOcrResult.a()) && (paramARCloudPreOcrResult.b())) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramARCloudPreOcrResult = new StringBuilder();
      paramARCloudPreOcrResult.append("isRecogSuccess result = ");
      paramARCloudPreOcrResult.append(bool);
      QLog.d("ARCloudPreOcrResult", 2, paramARCloudPreOcrResult.toString());
    }
    return bool;
  }
  
  public boolean a()
  {
    return (this.a == 0) && (this.d == 0);
  }
  
  public boolean b()
  {
    return this.f == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARCloudPreOcrResult{recogType = ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", recogSvrRetCode = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", recogSvrRetMsg = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", sessionId = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", arWordDetectRetCode = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", arWordDetectRetMsg = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", wordType = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", confidence = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudPreOcrResult
 * JD-Core Version:    0.7.0.1
 */