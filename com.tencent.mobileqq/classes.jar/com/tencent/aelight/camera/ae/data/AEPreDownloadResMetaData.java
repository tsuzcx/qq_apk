package com.tencent.aelight.camera.ae.data;

import java.io.File;

public class AEPreDownloadResMetaData
  extends AEMaterialMetaData
{
  public String a;
  public String b;
  
  public String e()
  {
    Object localObject = new File(this.b);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.t);
    return ((StringBuilder)localObject).toString();
  }
  
  public String f()
  {
    Object localObject = new File(this.b);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(File.separator);
    return ((StringBuilder)localObject).toString();
  }
  
  public String g()
  {
    Object localObject = new File(this.a);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.t);
    return ((StringBuilder)localObject).toString();
  }
  
  public boolean h()
  {
    Object localObject = new File(e());
    if (!((File)localObject).exists()) {
      return false;
    }
    localObject = ((File)localObject).list();
    return (localObject != null) && (localObject.length > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.data.AEPreDownloadResMetaData
 * JD-Core Version:    0.7.0.1
 */