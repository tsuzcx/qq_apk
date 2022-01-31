package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.VideoCompressTask;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.VideoCompressTask.VideoCompressTaskListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mcz;
import mda;

public class NormalVideoDeliverController
  implements VideoCompressTask.VideoCompressTaskListener, VideoDeliverController
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private VideoCompressTask jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask;
  private FileUploadController.FileUploadListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener = new mcz(this);
  private FileUploadController jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private FileUploadController.FileUploadListener jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener = new mda(this);
  private FileUploadController jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString;
  private long g;
  
  public NormalVideoDeliverController(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, QQAppInterface paramQQAppInterface, VideoDeliverController.DeliverVideoTaskListener paramDeliverVideoTaskListener, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramDeliverVideoTaskListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController = new ImageUploadController(paramContext, paramQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController = new VideoUploadController(paramContext, paramQQAppInterface, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener, paramString);
  }
  
  private void a(int paramInt)
  {
    QLog.d("VideoDeliverController", 2, "transitState: from " + this.jdField_a_of_type_Int + " to " + paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController.a(this.jdField_b_of_type_JavaLangString, true);
      continue;
      c(100.0F);
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController.a(this.jdField_e_of_type_JavaLangString, false);
        continue;
        b(100.0F);
      }
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)) {
      ((VideoDeliverController.DeliverVideoTaskListener)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramString1, paramString2, paramString3, paramString4, paramString5);
    }
  }
  
  private void b(float paramFloat)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (!this.jdField_c_of_type_Boolean))
    {
      paramFloat /= 100.0F;
      ((VideoDeliverController.DeliverVideoTaskListener)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a((1.0F + paramFloat) * 50.0F);
    }
  }
  
  private void b(int paramInt)
  {
    a(paramInt, null, null, null, null, null);
  }
  
  private void c(float paramFloat)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (!this.jdField_c_of_type_Boolean))
    {
      paramFloat = 50.0F * paramFloat / 100.0F;
      ((VideoDeliverController.DeliverVideoTaskListener)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(paramFloat);
    }
  }
  
  private void c(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.g;
    StatisticCollector localStatisticCollector = StatisticCollector.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask = new VideoCompressTask((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask.execute(new String[] { this.jdField_a_of_type_JavaLangString });
    this.jdField_d_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public void a()
  {
    this.jdField_d_of_type_Boolean = true;
    switch (this.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask == null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask.cancel(true);
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController.b();
      return;
    } while (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController == null);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController.a();
  }
  
  public void a(float paramFloat)
  {
    c(paramFloat);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_c_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_b_of_type_Long = paramLong2;
      return;
      b(1);
      continue;
      b(2);
      continue;
      b(3);
      c(1003);
      continue;
      b(4);
      c(1005);
      continue;
      this.jdField_e_of_type_JavaLangString = paramString1;
      this.jdField_f_of_type_JavaLangString = paramString2;
      a(2);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    d();
    a(1);
    this.g = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = false;
    switch (this.jdField_a_of_type_Int)
    {
    case 3: 
    default: 
      return;
    case 1: 
      d();
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController.a(this.jdField_b_of_type_JavaLangString, true);
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController.a(this.jdField_a_of_type_JavaLangString, paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = true;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      a(0);
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask.cancel(true);
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController.b();
          continue;
          if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController != null) {
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController.b();
          }
        }
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController.c();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.NormalVideoDeliverController
 * JD-Core Version:    0.7.0.1
 */