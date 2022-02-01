package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.Manager;

public class VideoUploadManager
  implements Manager
{
  public static int a;
  public static Map<String, String> a;
  public static int b;
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  HashMap<Long, Bundle> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  HashMap<Long, Bundle> b;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 1;
    jdField_a_of_type_JavaUtilMap = null;
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
      VideoUploadManager.1 local1 = new VideoUploadManager.1(this);
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.mUpCallBack = new VideoUploadManager.2(this);
      ITransFileController localITransFileController = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
      local1.addFilter(new Class[] { BDHCommonUploadProcessor.class });
      localITransFileController.addHandle(local1);
      localTransferRequest.mLocalPath = paramString;
      localTransferRequest.mIsUp = true;
      localTransferRequest.mFileType = 24;
      localTransferRequest.mCommandId = 54;
      localTransferRequest.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      localTransferRequest.mPeerUin = "0";
      localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      localITransFileController.transferAsync(localTransferRequest);
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localTransferRequest.mUniseq), paramBundle);
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localTransferRequest.mUniseq), paramBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUploadManager
 * JD-Core Version:    0.7.0.1
 */