package com.tencent.mobileqq.ar.arengine;

import apnv;
import apnw;
import apoj;
import apom;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ARLocalFaceRecog$3
  implements Runnable
{
  public ARLocalFaceRecog$3(apoj paramapoj, apnv paramapnv, long paramLong) {}
  
  public void run()
  {
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.this$0.a(this.this$0.jdField_a_of_type_JavaUtilList);
      this.this$0.a(this.this$0.b);
      this.this$0.f = 10;
      this.this$0.jdField_a_of_type_Apnv = this.jdField_a_of_type_Apnv;
      if ((this.this$0.jdField_a_of_type_Apnv == null) || (this.this$0.jdField_a_of_type_Apnv.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus == null)) {}
    }
    for (;;)
    {
      int i;
      apom localapom;
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        if (this.this$0.jdField_a_of_type_Apnv.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length > 2)
        {
          this.this$0.a(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_Apnv);
          this.this$0.b(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_Apnv);
          long l1 = System.currentTimeMillis();
          long l2 = this.jdField_a_of_type_Long;
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face][ScanStarFace]addFaceCloudRecogResult finish,totalFaceList = " + this.this$0.jdField_a_of_type_JavaUtilList + ",addFaceClouDResultCost = " + (l1 - l2));
          }
          this.this$0.c = System.currentTimeMillis();
          this.this$0.d = false;
          return;
          localObject2 = finally;
          throw localObject2;
        }
        i = 0;
        if (i >= this.this$0.jdField_a_of_type_Apnv.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length) {
          continue;
        }
        FaceStatus localFaceStatus = this.this$0.jdField_a_of_type_Apnv.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]addFaceCloudRecogResult faceFeature = " + Arrays.toString(localFaceStatus.feature));
        }
        localapom = new apom();
        localapom.jdField_a_of_type_Int = 1;
        localapom.jdField_a_of_type_JavaLangString = "";
        if (this.this$0.jdField_a_of_type_Apnv.jdField_a_of_type_JavaUtilArrayList != null)
        {
          Iterator localIterator = this.this$0.jdField_a_of_type_Apnv.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            apnw localapnw = (apnw)localIterator.next();
            if (localapnw.jdField_a_of_type_Int != i) {
              continue;
            }
            localapom.jdField_a_of_type_Int = 2;
            localapom.jdField_a_of_type_JavaLangString = localapnw.jdField_a_of_type_JavaLangString;
            localapom.jdField_b_of_type_JavaLangString = localapnw.jdField_b_of_type_JavaLangString;
            localapom.c = String.valueOf(localapnw.jdField_a_of_type_Long);
            localapom.d = localapnw.c;
            localapom.e = localapnw.d;
            localapom.f = localapnw.e;
            localapom.jdField_a_of_type_Float = localapnw.jdField_a_of_type_Float;
          }
        }
      }
      localapom.jdField_a_of_type_Boolean = true;
      localapom.jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localObject3;
      localapom.jdField_b_of_type_Int = i;
      this.this$0.jdField_a_of_type_JavaUtilList.add(localapom);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.3
 * JD-Core Version:    0.7.0.1
 */