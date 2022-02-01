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
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class ImageUploadController
  extends FileUploadController
{
  private long jdField_a_of_type_Long = 0L;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new ImageUploadController.1(this);
  TransferRequest jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
  private Long jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  private String jdField_a_of_type_JavaLangString = null;
  private long jdField_b_of_type_Long = 0L;
  private Long jdField_b_of_type_JavaLangLong = Long.valueOf(0L);
  private String jdField_b_of_type_JavaLangString = null;
  private long jdField_c_of_type_Long = 0L;
  private String jdField_c_of_type_JavaLangString = null;
  private long jdField_d_of_type_Long = 0L;
  private String jdField_d_of_type_JavaLangString = null;
  
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
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.collectPerformance(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
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
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext);
    String str = ReadInJoyUtils.a();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverVideoCompressCover", bool, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
  }
  
  private void c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext);
    String str = ReadInJoyUtils.a();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverVideoUploadCover", bool, this.jdField_c_of_type_Long - this.jdField_d_of_type_Long, 0L, localHashMap, "");
      return;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, 0);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
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
    localObject = new CompressInfo(paramString, paramInt);
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
      paramString = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
      paramString.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = new TransferRequest();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mIsUp = true;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mCommandId = 10;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mLocalPath = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mPeerUin = "0";
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mFileType = 24;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mRichTag = "KandianUGCPicUpload";
      paramString.transferAsync(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
      return;
      paramString = ((CompressInfo)localObject).jdField_e_of_type_JavaLangString;
    }
  }
  
  public void b()
  {
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.ImageUploadController
 * JD-Core Version:    0.7.0.1
 */