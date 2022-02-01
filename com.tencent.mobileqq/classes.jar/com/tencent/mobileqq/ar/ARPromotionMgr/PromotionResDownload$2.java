package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.configsp.ARPromotionConfigSP;
import com.tencent.qphone.base.util.QLog;

class PromotionResDownload$2
  implements ResDownloadManager.IResDownloadListener
{
  int jdField_a_of_type_Int = 0;
  final long jdField_a_of_type_Long = QQAudioHelper.b();
  long jdField_b_of_type_Long = System.currentTimeMillis();
  
  PromotionResDownload$2(PromotionResDownload paramPromotionResDownload, AppInterface paramAppInterface, String paramString, int paramInt) {}
  
  public void a() {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramInt != 100) && (paramInt != 0) && (Math.abs(paramInt - this.jdField_a_of_type_Int) < 10)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    long l = System.currentTimeMillis();
    if (l - this.jdField_b_of_type_Long >= 1000L) {
      bool2 = true;
    }
    if ((QLog.isDevelopLevel()) && ((bool2) || (bool1)))
    {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadUpdate, md5[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], activityid[");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("], index[");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("], curPercent[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], lastPercent[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("], needNotify[");
      localStringBuilder.append(bool1);
      localStringBuilder.append("], needNotify2[");
      localStringBuilder.append(bool2);
      localStringBuilder.append("]");
      QLog.w(paramString1, 1, localStringBuilder.toString());
    }
    if (bool1) {
      this.jdField_a_of_type_Int = paramInt;
    }
    if (bool2) {
      this.jdField_b_of_type_Long = l;
    }
    if ((bool1) || (bool2)) {
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if ((paramObject instanceof PromotionConfigInfo.ZipItem))
    {
      paramString1 = (PromotionConfigInfo.ZipItem)paramObject;
      paramString1.c = System.currentTimeMillis();
      paramObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      boolean bool = false;
      if (paramInt == 0) {
        bool = PromotionResDownload.a(paramString1);
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadFinish, md5[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], errCode[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], check[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], path[");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("], id[");
      localStringBuilder.append(paramString1.e);
      localStringBuilder.append("], request[");
      localStringBuilder.append(paramString1.jdField_a_of_type_Long);
      localStringBuilder.append("], Begin[");
      localStringBuilder.append(paramString1.jdField_b_of_type_Long);
      localStringBuilder.append("], End[");
      localStringBuilder.append(paramString1.c);
      localStringBuilder.append("], 调度耗时[");
      localStringBuilder.append(paramString1.jdField_b_of_type_Long - paramString1.jdField_a_of_type_Long);
      localStringBuilder.append("], 下载耗时[");
      localStringBuilder.append(paramString1.c - paramString1.jdField_b_of_type_Long);
      localStringBuilder.append("], fromPreCover[");
      localStringBuilder.append(paramString1.d);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("], Uin[");
      localStringBuilder.append(paramObject);
      localStringBuilder.append("], zipItem[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      if (paramString1.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener == this) {
        paramString1.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener = null;
      }
      int i = paramInt;
      if (paramInt == 0)
      {
        i = paramInt;
        if (!bool) {
          i = -5;
        }
      }
      if (i == 0)
      {
        paramString1.a(2);
        ARPromotionConfigSP.a(paramObject, paramString1.e, paramString1.jdField_a_of_type_Int, paramString1.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload.a(paramString1.e, paramString1.jdField_a_of_type_Int, 100);
        paramString1.d = -1;
      }
      else if (i == 100)
      {
        paramString1.a(2);
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload.a(paramString1.e, paramString1.jdField_a_of_type_Int, 100);
      }
      else
      {
        paramString1.a(-1);
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload.a(paramString1.e, paramString1.jdField_a_of_type_Int, -1);
      }
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString1.jdField_a_of_type_Boolean, paramString1.e, paramString1.jdField_a_of_type_Int + 1);
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    String str = this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZipItem.finalize, activityid[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("], index[");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload.2
 * JD-Core Version:    0.7.0.1
 */