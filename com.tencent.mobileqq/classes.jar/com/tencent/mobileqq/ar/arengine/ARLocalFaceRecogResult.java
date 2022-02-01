package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.DrawView2.FaceData;
import java.util.ArrayList;

public class ARLocalFaceRecogResult
  extends ARLocalRecogResultBase
{
  public long a;
  public ArrayList<DrawView2.FaceData> a;
  public boolean a;
  
  public ARLocalFaceRecogResult()
  {
    this.b = 4L;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARLocalFaceRecogResult{recogType = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",isTimeOut = ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",frameIdx = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", faceDatas.size = ");
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i;
    if (localArrayList != null) {
      i = localArrayList.size();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecogResult
 * JD-Core Version:    0.7.0.1
 */