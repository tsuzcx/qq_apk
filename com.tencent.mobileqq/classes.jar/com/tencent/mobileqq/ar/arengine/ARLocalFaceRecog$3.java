package com.tencent.mobileqq.ar.arengine;

import anbo;
import anbp;
import ancc;
import ancf;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ARLocalFaceRecog$3
  implements Runnable
{
  public ARLocalFaceRecog$3(ancc paramancc, anbo paramanbo, long paramLong) {}
  
  public void run()
  {
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.this$0.jdField_a_of_type_JavaUtilList.clear();
      this.this$0.b.clear();
      this.this$0.f = 10;
      this.this$0.jdField_a_of_type_Anbo = this.jdField_a_of_type_Anbo;
      if ((this.this$0.jdField_a_of_type_Anbo == null) || (this.this$0.jdField_a_of_type_Anbo.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus == null)) {}
    }
    for (;;)
    {
      int i;
      ancf localancf;
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        if (this.this$0.jdField_a_of_type_Anbo.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length > 2)
        {
          this.this$0.a(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_Anbo);
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
        if (i >= this.this$0.jdField_a_of_type_Anbo.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length) {
          continue;
        }
        FaceStatus localFaceStatus = this.this$0.jdField_a_of_type_Anbo.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]addFaceCloudRecogResult faceFeature = " + Arrays.toString(localFaceStatus.feature));
        }
        localancf = new ancf();
        localancf.jdField_a_of_type_Int = 1;
        localancf.jdField_a_of_type_JavaLangString = "";
        if (this.this$0.jdField_a_of_type_Anbo.jdField_a_of_type_JavaUtilArrayList != null)
        {
          Iterator localIterator = this.this$0.jdField_a_of_type_Anbo.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            anbp localanbp = (anbp)localIterator.next();
            if (localanbp.jdField_a_of_type_Int != i) {
              continue;
            }
            localancf.jdField_a_of_type_Int = 2;
            localancf.jdField_a_of_type_JavaLangString = localanbp.jdField_a_of_type_JavaLangString;
            localancf.jdField_b_of_type_JavaLangString = localanbp.jdField_b_of_type_JavaLangString;
            localancf.c = String.valueOf(localanbp.jdField_a_of_type_Long);
            localancf.d = localanbp.c;
            localancf.e = localanbp.d;
            localancf.f = localanbp.e;
            localancf.jdField_a_of_type_Float = localanbp.jdField_a_of_type_Float;
          }
        }
      }
      localancf.jdField_a_of_type_Boolean = true;
      localancf.jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localObject3;
      localancf.jdField_b_of_type_Int = i;
      this.this$0.jdField_a_of_type_JavaUtilList.add(localancf);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.3
 * JD-Core Version:    0.7.0.1
 */