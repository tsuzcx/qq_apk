package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import java.util.HashMap;
import mew;
import mex;
import mqq.manager.Manager;

public class VideoUploadManager
  implements Manager
{
  public static int a;
  public static int b;
  public TroopMemberApiService a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  public HashMap b;
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public VideoUploadManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(int paramInt) {}
  
  public void a(TroopMemberApiService paramTroopMemberApiService)
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService == null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if ((TextUtils.isEmpty(paramString)) || (!FileUtils.b(paramString))) {}
    for (;;)
    {
      mew localmew = new mew(this);
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = new mex(this);
      TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localmew.a(new Class[] { BDHCommonUploadProcessor.class });
      localTransFileController.a(localmew);
      localTransferRequest.i = paramString;
      localTransferRequest.jdField_a_of_type_Boolean = true;
      localTransferRequest.jdField_b_of_type_Int = 24;
      localTransferRequest.jdField_c_of_type_Int = 54;
      localTransferRequest.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      localTransferRequest.jdField_c_of_type_JavaLangString = "0";
      localTransferRequest.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      localTransFileController.a(localTransferRequest);
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localTransferRequest.jdField_a_of_type_Long), paramBundle);
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localTransferRequest.jdField_a_of_type_Long), paramBundle);
      return;
      a(jdField_a_of_type_Int);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUploadManager
 * JD-Core Version:    0.7.0.1
 */