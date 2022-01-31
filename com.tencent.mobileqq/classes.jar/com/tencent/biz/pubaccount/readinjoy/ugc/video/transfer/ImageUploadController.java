package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import lzk;

public class ImageUploadController
  extends FileUploadController
{
  private long jdField_a_of_type_Long;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new lzk(this);
  private Long jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private Long jdField_b_of_type_JavaLangLong = Long.valueOf(0L);
  private String jdField_b_of_type_JavaLangString;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  
  public ImageUploadController(Context paramContext, QQAppInterface paramQQAppInterface, FileUploadController.FileUploadListener paramFileUploadListener)
  {
    super(paramContext, paramQQAppInterface, paramFileUploadListener);
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = this.jdField_b_of_type_Long;
    long l2 = this.jdField_a_of_type_Long;
    StatisticCollector localStatisticCollector = StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    b(paramInt);
    c(paramInt);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener.a(paramInt, paramString1, paramString2, paramString3);
    }
  }
  
  private void b(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("cover_size_before_compression", this.jdField_a_of_type_JavaLangLong.toString());
    localHashMap.put("cover_size_after_compression", this.jdField_b_of_type_JavaLangLong.toString());
    StatisticCollector localStatisticCollector = StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext);
    String str = ReadInJoyUtils.a();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str, "actReadInJoyDeliverVideoCompressCover", bool, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
  }
  
  private void c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector localStatisticCollector = StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext);
    String str = ReadInJoyUtils.a();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str, "actReadInJoyDeliverVideoUploadCover", bool, this.jdField_c_of_type_Long - this.jdField_d_of_type_Long, 0L, localHashMap, "");
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageUploadController", 2, "startUploadPic path=" + paramString);
    }
    this.jdField_d_of_type_JavaLangString = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "startUploadPic empty path!");
      }
      a(1001, null, null, null);
      return;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "startUploadPic file not exist, path=" + paramString);
      }
      a(1002, null, null, null);
      return;
    }
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(((File)localObject).length());
    if (!NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext))
    {
      a(1003, null, null, null);
      return;
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    localObject = new CompressInfo(paramString, 0);
    ((CompressInfo)localObject).f = 0;
    if (!CompressOperator.a((CompressInfo)localObject)) {
      a(1001);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImageUploadController", 2, "startUploadPic compressPath=" + ((CompressInfo)localObject).jdField_e_of_type_JavaLangString + ", originPath=" + paramString + ", outWidth=" + ((CompressInfo)localObject).d + ", outHeight=" + ((CompressInfo)localObject).jdField_e_of_type_Int);
    }
    if (TextUtils.isEmpty(((CompressInfo)localObject).jdField_e_of_type_JavaLangString)) {}
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_JavaLangLong = Long.valueOf(new File(this.jdField_a_of_type_JavaLangString).length());
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { BDHCommonUploadProcessor.class });
      paramString.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      localObject = new TransferRequest();
      ((TransferRequest)localObject).jdField_a_of_type_Boolean = true;
      ((TransferRequest)localObject).jdField_c_of_type_Int = 10;
      ((TransferRequest)localObject).i = this.jdField_a_of_type_JavaLangString;
      ((TransferRequest)localObject).jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
      ((TransferRequest)localObject).jdField_c_of_type_JavaLangString = "0";
      ((TransferRequest)localObject).b = 24;
      ((TransferRequest)localObject).jdField_a_of_type_JavaLangString = "KandianUGCPicUpload";
      paramString.a((TransferRequest)localObject);
      return;
      paramString = ((CompressInfo)localObject).jdField_e_of_type_JavaLangString;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_d_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageUploadController", 2, "clearTempFile(image), origin:" + this.jdField_d_of_type_JavaLangString + ", compress:" + this.jdField_a_of_type_JavaLangString);
      }
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.ImageUploadController
 * JD-Core Version:    0.7.0.1
 */