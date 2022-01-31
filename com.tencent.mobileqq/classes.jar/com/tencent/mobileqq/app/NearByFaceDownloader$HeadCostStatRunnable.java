package com.tencent.mobileqq.app;

import AvatarInfo.QQHeadInfo;
import alnk;
import azmz;
import bdee;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class NearByFaceDownloader$HeadCostStatRunnable
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  FaceInfo jdField_a_of_type_ComTencentMobileqqUtilFaceInfo;
  String jdField_a_of_type_JavaLangString;
  int b;
  int c;
  int d;
  
  public NearByFaceDownloader$HeadCostStatRunnable(NearByFaceDownloader paramNearByFaceDownloader, int paramInt1, FaceInfo paramFaceInfo, int paramInt2, int paramInt3, String paramString, int paramInt4, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.d = paramInt4;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = paramFaceInfo;
  }
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo.dstUsrType + "_" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.b + "_" + this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_JavaLangString;
    this.this$0.jdField_a_of_type_Alnk.a(str1, false);
    if (bdee.d(BaseApplication.getContext())) {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.m] <= 0L) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.l] <= 0L)) {
        break label770;
      }
    }
    label770:
    for (long l1 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.m] - this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.l];; l1 = 0L)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.n] > this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.m]) && (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.m] > 0L)) {}
      for (long l2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.n] - this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.m];; l2 = 0L)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.o] > 0L) && (this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.n] > 0L)) {}
        for (long l3 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.o] - this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.n];; l3 = 0L)
        {
          Object localObject1 = new HashMap();
          ((HashMap)localObject1).put("key", str1);
          ((HashMap)localObject1).put("totalTime", String.valueOf((float)this.jdField_a_of_type_Long / 1000.0F));
          ((HashMap)localObject1).put("downInfo_time", String.valueOf(l1));
          ((HashMap)localObject1).put("downInfo_stime", String.valueOf((float)l1 / 1000.0F));
          ((HashMap)localObject1).put("interval_time", String.valueOf(l2));
          ((HashMap)localObject1).put("downPic_time", String.valueOf(l3));
          ((HashMap)localObject1).put("downPic_stime", String.valueOf((float)l3 / 1000.0F));
          ((HashMap)localObject1).put("downPic_size", String.valueOf(this.c));
          ((HashMap)localObject1).put("download_url", this.jdField_a_of_type_JavaLangString);
          ((HashMap)localObject1).put("param_FailCode", Integer.toString(this.jdField_a_of_type_Int));
          ((HashMap)localObject1).put("fail_reason", Integer.toString(this.d));
          ((HashMap)localObject1).put("ssoAndHttp", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.e));
          Object localObject2 = FaceDownloader.a(32);
          Object localObject3 = azmz.a(BaseApplication.getContext());
          String str2 = this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin();
          boolean bool;
          if (this.jdField_a_of_type_Int == 0)
          {
            bool = true;
            ((azmz)localObject3).a(str2, (String)localObject2, bool, this.jdField_a_of_type_Long, 0L, (HashMap)localObject1, "");
            localObject2 = azmz.a(BaseApplication.getContext());
            localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin();
            if (this.jdField_a_of_type_Int != 0) {
              break label747;
            }
            bool = true;
            label528:
            ((azmz)localObject2).a((String)localObject3, "actGetNearbyHead", bool, this.jdField_a_of_type_Long, 0L, (HashMap)localObject1, "");
            if ((QLog.isColorLevel()) || (this.jdField_a_of_type_Long > 3000L))
            {
              localObject1 = new StringBuffer(200);
              ((StringBuffer)localObject1).append("NearByFaceDownloader resultCode=").append(this.jdField_a_of_type_Int);
              ((StringBuffer)localObject1).append(", key=").append(str1);
              ((StringBuffer)localObject1).append(", totalTime=").append(String.format("%-5s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long) }));
              ((StringBuffer)localObject1).append(", downInfoTime=").append(l1);
              ((StringBuffer)localObject1).append(", intervalTime=").append(l2);
              ((StringBuffer)localObject1).append(", picSize=").append(String.valueOf(this.c));
              ((StringBuffer)localObject1).append(", downPicTime=").append(l3);
              ((StringBuffer)localObject1).append(", reasonCode=").append(this.d);
              ((StringBuffer)localObject1).append(", downUrl=").append(this.jdField_a_of_type_JavaLangString);
              if (!QLog.isColorLevel()) {
                break label753;
              }
            }
          }
          label747:
          label753:
          for (int i = 2;; i = 1)
          {
            QLog.i("Q.qqhead.NearByFaceDownloader", i, ((StringBuffer)localObject1).toString());
            return;
            bool = false;
            break;
            bool = false;
            break label528;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearByFaceDownloader.HeadCostStatRunnable
 * JD-Core Version:    0.7.0.1
 */