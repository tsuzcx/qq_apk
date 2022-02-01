package com.tencent.biz.pubaccount.readinjoy.ugc.upload;

import android.content.Context;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.ImageUploadController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class RIJUgcImageUploader
  implements IImageUploader
{
  public static String a;
  private Context jdField_a_of_type_AndroidContentContext;
  private IImageUploadListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcUploadIImageUploadListener;
  private ImageUploadController jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferImageUploadController;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "RIJUGC.RIJUgcImageUploader";
  }
  
  public RIJUgcImageUploader(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "upload, path=" + this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_Boolean = true;
    ThreadManagerV2.getUIHandlerV2().post(new RIJUgcImageUploader.1(this));
  }
  
  public void a(IImageUploadListener paramIImageUploadListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcUploadIImageUploadListener = paramIImageUploadListener;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "cancel, path=" + this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferImageUploadController != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferImageUploadController.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferImageUploadController.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.upload.RIJUgcImageUploader
 * JD-Core Version:    0.7.0.1
 */