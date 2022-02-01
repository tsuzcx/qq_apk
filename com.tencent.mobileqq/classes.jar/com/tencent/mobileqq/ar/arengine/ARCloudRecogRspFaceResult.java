package com.tencent.mobileqq.ar.arengine;

import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ARCloudRecogRspFaceResult
{
  public int a;
  public String b;
  public int c;
  public String d;
  public int e;
  public int f;
  public String g;
  public ArrayList<ARCloudRecogRspFaceResult.StarInfo> h;
  public FaceStatus[] i;
  
  public static boolean a(ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult)
  {
    boolean bool;
    if ((paramARCloudRecogRspFaceResult != null) && (paramARCloudRecogRspFaceResult.a == 0) && (paramARCloudRecogRspFaceResult.c == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramARCloudRecogRspFaceResult = new StringBuilder();
      paramARCloudRecogRspFaceResult.append("[ScanStarFace]isRecogSuccess result = ");
      paramARCloudRecogRspFaceResult.append(bool);
      QLog.d("ARRspFaceResult", 2, paramARCloudRecogRspFaceResult.toString());
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARCloudRecogRspFaceResult{errCode_MQ=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", errMsg_MQ='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", errCode_YT=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", errMsg_YT=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", time_ms_YT=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", group_size_YT=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", sessionID='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", starInfoList=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", faceStatus[]=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudRecogRspFaceResult
 * JD-Core Version:    0.7.0.1
 */