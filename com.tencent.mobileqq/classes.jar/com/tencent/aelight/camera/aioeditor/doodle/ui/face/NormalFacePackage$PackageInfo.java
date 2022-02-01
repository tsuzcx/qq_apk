package com.tencent.aelight.camera.aioeditor.doodle.ui.face;

import android.support.annotation.NonNull;

public class NormalFacePackage$PackageInfo
  implements Comparable
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public NormalFacePackage$PackageInfo(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString3;
  }
  
  public int compareTo(@NonNull Object paramObject)
  {
    if ((paramObject instanceof PackageInfo)) {
      return this.b.compareTo(((PackageInfo)paramObject).b);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage.PackageInfo
 * JD-Core Version:    0.7.0.1
 */