package com.tencent.mobileqq.app;

import AvatarInfo.QQHeadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceHandler;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.utils.AvatarImplUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class NearByFaceDownloader$HeadCostStatRunnable
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  FaceInfo jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo;
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
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo = paramFaceInfo;
  }
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo.dstUsrType);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.b);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_JavaLangString);
    localObject1 = ((StringBuilder)localObject1).toString();
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppFaceFaceHandler.a((String)localObject1, false);
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      long l1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.m];
      long l4 = 0L;
      if ((l1 > 0L) && (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.l] > 0L)) {
        l1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.m] - this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.l];
      } else {
        l1 = 0L;
      }
      long l2;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.n] > this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.m]) && (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.m] > 0L)) {
        l2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.n] - this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.m];
      } else {
        l2 = 0L;
      }
      long l3 = l4;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.o] > 0L)
      {
        l3 = l4;
        if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.n] > 0L) {
          l3 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.o] - this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.jdField_a_of_type_ArrayOfLong[FaceInfo.n];
        }
      }
      Object localObject2 = new HashMap();
      ((HashMap)localObject2).put("key", localObject1);
      ((HashMap)localObject2).put("totalTime", String.valueOf((float)this.jdField_a_of_type_Long / 1000.0F));
      ((HashMap)localObject2).put("downInfo_time", String.valueOf(l1));
      ((HashMap)localObject2).put("downInfo_stime", String.valueOf((float)l1 / 1000.0F));
      ((HashMap)localObject2).put("interval_time", String.valueOf(l2));
      ((HashMap)localObject2).put("downPic_time", String.valueOf(l3));
      ((HashMap)localObject2).put("downPic_stime", String.valueOf((float)l3 / 1000.0F));
      ((HashMap)localObject2).put("downPic_size", String.valueOf(this.c));
      ((HashMap)localObject2).put("download_url", this.jdField_a_of_type_JavaLangString);
      ((HashMap)localObject2).put("param_FailCode", Integer.toString(this.jdField_a_of_type_Int));
      ((HashMap)localObject2).put("fail_reason", Integer.toString(this.d));
      ((HashMap)localObject2).put("ssoAndHttp", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.e));
      Object localObject3 = AvatarImplUtil.a(32);
      Object localObject4 = StatisticCollector.getInstance(BaseApplication.getContext());
      String str = this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      boolean bool;
      if (this.jdField_a_of_type_Int == 0) {
        bool = true;
      } else {
        bool = false;
      }
      l4 = this.jdField_a_of_type_Long;
      int i = 1;
      ((StatisticCollector)localObject4).collectPerformance(str, (String)localObject3, bool, l4, 0L, (HashMap)localObject2, "");
      localObject3 = StatisticCollector.getInstance(BaseApplication.getContext());
      localObject4 = this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      if (this.jdField_a_of_type_Int == 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((StatisticCollector)localObject3).collectPerformance((String)localObject4, "actGetNearbyHead", bool, this.jdField_a_of_type_Long, 0L, (HashMap)localObject2, "");
      if ((QLog.isColorLevel()) || (this.jdField_a_of_type_Long > 3000L))
      {
        localObject2 = new StringBuffer(200);
        ((StringBuffer)localObject2).append("NearByFaceDownloader resultCode=");
        ((StringBuffer)localObject2).append(this.jdField_a_of_type_Int);
        ((StringBuffer)localObject2).append(", key=");
        ((StringBuffer)localObject2).append((String)localObject1);
        ((StringBuffer)localObject2).append(", totalTime=");
        ((StringBuffer)localObject2).append(String.format("%-5s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long) }));
        ((StringBuffer)localObject2).append(", downInfoTime=");
        ((StringBuffer)localObject2).append(l1);
        ((StringBuffer)localObject2).append(", intervalTime=");
        ((StringBuffer)localObject2).append(l2);
        ((StringBuffer)localObject2).append(", picSize=");
        ((StringBuffer)localObject2).append(String.valueOf(this.c));
        ((StringBuffer)localObject2).append(", downPicTime=");
        ((StringBuffer)localObject2).append(l3);
        ((StringBuffer)localObject2).append(", reasonCode=");
        ((StringBuffer)localObject2).append(this.d);
        ((StringBuffer)localObject2).append(", downUrl=");
        ((StringBuffer)localObject2).append(this.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          i = 2;
        }
        QLog.i("Q.qqhead.NearByFaceDownloader", i, ((StringBuffer)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearByFaceDownloader.HeadCostStatRunnable
 * JD-Core Version:    0.7.0.1
 */