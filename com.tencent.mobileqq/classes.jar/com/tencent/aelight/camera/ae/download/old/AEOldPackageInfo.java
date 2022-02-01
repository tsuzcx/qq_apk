package com.tencent.aelight.camera.ae.download.old;

import android.support.annotation.NonNull;
import java.util.List;

public class AEOldPackageInfo
{
  public final int a;
  public final String a;
  public final List<String> a;
  public final String b;
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{packageName:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", packageVersion:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", packageZipPath:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", packageContentList:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.download.old.AEOldPackageInfo
 * JD-Core Version:    0.7.0.1
 */