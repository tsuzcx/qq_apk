package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import lzo;
import lzp;

public class VideoUploadController
  extends FileUploadController
{
  private long jdField_a_of_type_Long;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new lzp(this);
  private TransferRequest jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public VideoUploadController(Context paramContext, QQAppInterface paramQQAppInterface, FileUploadController.FileUploadListener paramFileUploadListener, String paramString)
  {
    super(paramContext, paramQQAppInterface, paramFileUploadListener);
    this.d = paramString;
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector localStatisticCollector = StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext);
    String str = ReadInJoyUtils.a();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str, "actReadInJoyDeliverVideoUploadVideo", bool, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    QLog.d("VideoUploadController", 2, "finish: retCode - " + paramInt + " fileUrl : " + paramString1);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    a(paramInt);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener.a(paramInt, paramString1, paramString2, paramString3);
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "pauseUploadVideo");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null))
    {
      localObject = (BaseTransProcessor)((TransFileController)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      if (localObject != null) {
        ((BaseTransProcessor)localObject).c();
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.e = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "startUploadVideo path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "startUploadVideo empty path!");
      }
      a(1001, null, null, null);
      return;
    }
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "startUploadVideo file not exist, path=" + paramString);
      }
      a(1002, null, null, null);
      return;
    }
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QLog.d("VideoUploadController", 2, "upload: network not available");
      a(1003, null, null, null);
      return;
    }
    if ((!paramBoolean) && (!NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext)))
    {
      QLog.d("VideoUploadController", 2, "upload: wifi not connected and not upload with mobile");
      a(1005, null, null, null);
      return;
    }
    TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a().size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { BDHCommonUploadProcessor.class });
    }
    localTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = new TransferRequest();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_Int = 54;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i = paramString;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString = "0";
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int = 24;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString = "KandianUGCVideoUpload";
    }
    localTransFileController.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
  }
  
  public void b()
  {
    super.b();
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "cancelUploadVideo");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest != null))
    {
      localObject = (BaseTransProcessor)((TransFileController)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      if (localObject != null)
      {
        ((BaseTransProcessor)localObject).a();
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = null;
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    ThreadManager.executeOnFileThread(new lzo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.VideoUploadController
 * JD-Core Version:    0.7.0.1
 */