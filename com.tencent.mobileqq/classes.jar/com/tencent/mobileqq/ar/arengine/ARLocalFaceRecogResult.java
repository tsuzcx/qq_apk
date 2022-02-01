package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.DrawView2.FaceData;
import java.util.ArrayList;

public class ARLocalFaceRecogResult
  extends ARLocalRecogResultBase
{
  public long a;
  public boolean b;
  public ArrayList<DrawView2.FaceData> c = null;
  
  public ARLocalFaceRecogResult()
  {
    this.j = 4L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARLocalFaceRecogResult{recogType = ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",isTimeOut = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",frameIdx = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", faceDatas.size = ");
    ArrayList localArrayList = this.c;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecogResult
 * JD-Core Version:    0.7.0.1
 */