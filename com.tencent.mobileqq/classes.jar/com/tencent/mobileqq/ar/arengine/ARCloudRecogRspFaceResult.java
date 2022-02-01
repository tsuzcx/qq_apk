package com.tencent.mobileqq.ar.arengine;

import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ARCloudRecogRspFaceResult
{
  public int a;
  public String a;
  public ArrayList<ARCloudRecogRspFaceResult.StarInfo> a;
  public FaceStatus[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  
  public static boolean a(ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult)
  {
    boolean bool;
    if ((paramARCloudRecogRspFaceResult != null) && (paramARCloudRecogRspFaceResult.jdField_a_of_type_Int == 0) && (paramARCloudRecogRspFaceResult.jdField_b_of_type_Int == 0)) {
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
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", errMsg_MQ='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", errCode_YT=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", errMsg_YT=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", time_ms_YT=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", group_size_YT=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", sessionID='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", starInfoList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append(", faceStatus[]=");
    localStringBuilder.append(this.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudRecogRspFaceResult
 * JD-Core Version:    0.7.0.1
 */