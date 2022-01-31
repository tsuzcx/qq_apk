package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mcy;

public class KingsMomentVideoDeliverController
  implements VideoDeliverController
{
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new mcy(this);
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private String c;
  
  public KingsMomentVideoDeliverController(Context paramContext, QQAppInterface paramQQAppInterface, VideoDeliverController.DeliverVideoTaskListener paramDeliverVideoTaskListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDeliverVideoTaskListener);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(float paramFloat)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((VideoDeliverController.DeliverVideoTaskListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramFloat);
    }
  }
  
  private void a(int paramInt)
  {
    a(paramInt, null, null, null, null, null);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((VideoDeliverController.DeliverVideoTaskListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramString1, paramString2, paramString3, paramString4, paramString5);
    }
  }
  
  private void b(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    StatisticCollector localStatisticCollector = StatisticCollector.a((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get());
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KingsMomentVideoDeliveControllerr", 2, "startUploadPic path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("KingsMomentVideoDeliveControllerr", 2, "startUploadPic empty path!");
      }
      a(10);
    }
    do
    {
      return;
      if (!new File(paramString).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("KingsMomentVideoDeliveControllerr", 2, "startUploadPic file not exist, path=" + paramString);
        }
        a(5);
        return;
      }
    } while (!NetworkUtil.a((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get()));
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    Object localObject = new CompressInfo(paramString, 0);
    ((CompressInfo)localObject).f = 0;
    if (!CompressOperator.a((CompressInfo)localObject)) {
      b(1001);
    }
    if (QLog.isColorLevel()) {
      QLog.d("KingsMomentVideoDeliveControllerr", 2, "startUploadPic compressPath=" + ((CompressInfo)localObject).jdField_e_of_type_JavaLangString + ", originPath=" + paramString + ", outWidth=" + ((CompressInfo)localObject).d + ", outHeight=" + ((CompressInfo)localObject).jdField_e_of_type_Int);
    }
    if (TextUtils.isEmpty(((CompressInfo)localObject).jdField_e_of_type_JavaLangString)) {}
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
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
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString2);
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.KingsMomentVideoDeliverController
 * JD-Core Version:    0.7.0.1
 */