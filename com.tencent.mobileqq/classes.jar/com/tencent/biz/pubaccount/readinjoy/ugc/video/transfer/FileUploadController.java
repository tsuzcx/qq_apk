package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class FileUploadController
{
  Context jdField_a_of_type_AndroidContentContext;
  FileUploadController.FileUploadListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public FileUploadController(Context paramContext, QQAppInterface paramQQAppInterface, FileUploadController.FileUploadListener paramFileUploadListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener = paramFileUploadListener;
  }
  
  public void a() {}
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.FileUploadController
 * JD-Core Version:    0.7.0.1
 */