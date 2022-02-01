package com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.KanDianVideoUploadUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadController;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadController.DeliverVideoTaskListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.VideoCompressTask;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.VideoCompressTask.VideoCompressTaskListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.VideoMetaInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.VideoMetaInfo.Builder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class NormalVideoDeliverController
  extends KandianVideoUploadController
  implements VideoCompressTask.VideoCompressTaskListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  public Bundle a;
  private VideoCompressTask jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask;
  private FileUploadController.FileUploadListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener = new NormalVideoDeliverController.1(this);
  private FileUploadController jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController;
  ShortVideoResourceManager.INet_ShortVideoResource jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceManager$INet_ShortVideoResource = new NormalVideoDeliverController.4(this);
  ShortVideoResourceStatus.ISVConfig jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceStatus$ISVConfig = new NormalVideoDeliverController.3(this);
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private long jdField_b_of_type_Long = 0L;
  private FileUploadController.FileUploadListener jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener = new NormalVideoDeliverController.2(this);
  private FileUploadController jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController;
  private QQAppInterface jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference<KandianVideoUploadController.DeliverVideoTaskListener> jdField_b_of_type_JavaLangRefWeakReference;
  private long c = 0L;
  private long jdField_d_of_type_Long = 0L;
  private String jdField_d_of_type_JavaLangString;
  private long jdField_e_of_type_Long = 0L;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long = 0L;
  private String jdField_f_of_type_JavaLangString = null;
  private boolean jdField_f_of_type_Boolean;
  private long jdField_g_of_type_Long = 0L;
  private String jdField_g_of_type_JavaLangString = null;
  private boolean jdField_g_of_type_Boolean = false;
  private long jdField_h_of_type_Long = 0L;
  private String jdField_h_of_type_JavaLangString = null;
  private boolean jdField_h_of_type_Boolean = false;
  private long jdField_i_of_type_Long = 0L;
  private String jdField_i_of_type_JavaLangString = null;
  
  public NormalVideoDeliverController(Context paramContext, KandianVideoUploadController.DeliverVideoTaskListener paramDeliverVideoTaskListener, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramDeliverVideoTaskListener);
    this.jdField_a_of_type_AndroidOsBundle = paramIntent.getExtras();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(this.jdField_a_of_type_AndroidOsBundle);
    KanDianVideoUploadUtils.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController = new ImageUploadController(paramContext, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController = new VideoUploadController(paramContext, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController$FileUploadListener, this.jdField_d_of_type_JavaLangString);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)) {
      ((KandianVideoUploadController.DeliverVideoTaskListener)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, paramInt, VideoMetaInfo.a().a(paramString1).b(paramString2).d(paramString4).c(paramString3).e(paramString5).a(this.c).b(this.jdField_d_of_type_Long).a());
    }
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("mTaskID");
    this.jdField_e_of_type_Boolean = paramBundle.getBoolean("supportShortVideo", false);
    this.jdField_f_of_type_Boolean = paramBundle.getBoolean("shortVideoSoReady", false);
    if (!this.jdField_f_of_type_Boolean) {
      d();
    }
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("arg_video_path");
    this.jdField_e_of_type_JavaLangString = paramBundle.getString("arg_video_cover");
    paramBundle.putString("mTaskID", this.jdField_a_of_type_JavaLangString);
  }
  
  private void a(VideoMetaInfo paramVideoMetaInfo)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("compressPath", this.jdField_h_of_type_JavaLangString);
    a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidOsBundle, paramVideoMetaInfo, (KandianVideoUploadController.DeliverVideoTaskListener)this.jdField_b_of_type_JavaLangRefWeakReference.get());
  }
  
  private void b(float paramFloat)
  {
    this.jdField_a_of_type_Float = (50.0F * (1.0F + paramFloat / 100.0F));
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (!this.jdField_g_of_type_Boolean)) {
      ((KandianVideoUploadController.DeliverVideoTaskListener)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
    }
  }
  
  private void b(int paramInt)
  {
    QLog.d("VideoDeliverController", 1, "transitState: from " + this.jdField_a_of_type_Int + " to " + paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController.a(this.jdField_e_of_type_JavaLangString, true);
      continue;
      c(100.0F);
      if (!this.jdField_g_of_type_Boolean)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController.a(this.jdField_h_of_type_JavaLangString, true);
        continue;
        b(100.0F);
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask = new VideoCompressTask((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_e_of_type_Boolean, this.jdField_f_of_type_Boolean, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask.execute(new String[] { this.jdField_d_of_type_JavaLangString });
    this.jdField_f_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  private void c(float paramFloat)
  {
    this.jdField_a_of_type_Float = (50.0F * paramFloat / 100.0F);
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (!this.jdField_g_of_type_Boolean)) {
      ((KandianVideoUploadController.DeliverVideoTaskListener)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
    }
  }
  
  private void c(int paramInt)
  {
    a(paramInt, null, null, null, null, null);
  }
  
  private void d()
  {
    this.jdField_e_of_type_Boolean = VideoEnvironment.supportShortVideoRecordAndPlay();
    this.jdField_f_of_type_Boolean = VideoEnvironment.checkAndLoadAVCodec();
    if (!this.jdField_e_of_type_Boolean)
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131707598), null);
      return;
    }
    if (this.jdField_f_of_type_Boolean)
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件ready", null);
      return;
    }
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", "短视频插件not ready", null);
    if (NetworkUtil.g(null))
    {
      VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131707593), null);
      ShortVideoResourceManager.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceStatus$ISVConfig);
      return;
    }
    VideoEnvironment.LogDownLoad("ReadInJoyDeliverVideoActivity_AvCodecSo", HardCodeUtil.a(2131707591), null);
  }
  
  private void d(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_i_of_type_Long;
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.collectPerformance(str, "actReadInJoyUGCVideo", bool, l1 - l2, 0L, localHashMap, "");
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    c();
    b(1);
    this.jdField_i_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public void a(float paramFloat)
  {
    c(paramFloat);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_e_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
      this.jdField_b_of_type_Long = paramLong1;
      this.c = paramLong2;
      this.jdField_d_of_type_Long = paramLong3;
      return;
      c(1);
      continue;
      c(2);
      continue;
      c(3);
      d(1003);
      continue;
      c(4);
      d(1005);
      continue;
      this.jdField_h_of_type_JavaLangString = paramString1;
      this.jdField_i_of_type_JavaLangString = paramString2;
      b(2);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController.b();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyUgcVideoTransferFileUploadController.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.NormalVideoDeliverController
 * JD-Core Version:    0.7.0.1
 */