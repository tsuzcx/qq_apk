package com.tencent.mobileqq.ar.arengine;

import amxf;
import amxg;
import amxt;
import amxw;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ARLocalFaceRecog$3
  implements Runnable
{
  public ARLocalFaceRecog$3(amxt paramamxt, amxf paramamxf, long paramLong) {}
  
  public void run()
  {
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.this$0.jdField_a_of_type_JavaUtilList.clear();
      this.this$0.b.clear();
      this.this$0.f = 10;
      this.this$0.jdField_a_of_type_Amxf = this.jdField_a_of_type_Amxf;
      if ((this.this$0.jdField_a_of_type_Amxf == null) || (this.this$0.jdField_a_of_type_Amxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus == null)) {}
    }
    for (;;)
    {
      int i;
      amxw localamxw;
      synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
      {
        if (this.this$0.jdField_a_of_type_Amxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length > 2)
        {
          this.this$0.a(this.this$0.jdField_a_of_type_JavaUtilList, this.this$0.jdField_a_of_type_Amxf);
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
        if (i >= this.this$0.jdField_a_of_type_Amxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus.length) {
          continue;
        }
        FaceStatus localFaceStatus = this.this$0.jdField_a_of_type_Amxf.jdField_a_of_type_ArrayOfComTencentYTFaceModelFaceStatus[i];
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]addFaceCloudRecogResult faceFeature = " + Arrays.toString(localFaceStatus.feature));
        }
        localamxw = new amxw();
        localamxw.jdField_a_of_type_Int = 1;
        localamxw.jdField_a_of_type_JavaLangString = "";
        if (this.this$0.jdField_a_of_type_Amxf.jdField_a_of_type_JavaUtilArrayList != null)
        {
          Iterator localIterator = this.this$0.jdField_a_of_type_Amxf.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            amxg localamxg = (amxg)localIterator.next();
            if (localamxg.jdField_a_of_type_Int != i) {
              continue;
            }
            localamxw.jdField_a_of_type_Int = 2;
            localamxw.jdField_a_of_type_JavaLangString = localamxg.jdField_a_of_type_JavaLangString;
            localamxw.jdField_b_of_type_JavaLangString = localamxg.jdField_b_of_type_JavaLangString;
            localamxw.c = String.valueOf(localamxg.jdField_a_of_type_Long);
            localamxw.d = localamxg.c;
            localamxw.e = localamxg.d;
            localamxw.f = localamxg.e;
            localamxw.jdField_a_of_type_Float = localamxg.jdField_a_of_type_Float;
          }
        }
      }
      localamxw.jdField_a_of_type_Boolean = true;
      localamxw.jdField_a_of_type_ComTencentYTFaceModelFaceStatus = localObject3;
      localamxw.jdField_b_of_type_Int = i;
      this.this$0.jdField_a_of_type_JavaUtilList.add(localamxw);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.3
 * JD-Core Version:    0.7.0.1
 */