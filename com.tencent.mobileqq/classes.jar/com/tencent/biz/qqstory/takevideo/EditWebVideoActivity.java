package com.tencent.biz.qqstory.takevideo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.PtvGuideUploader;
import com.tencent.mobileqq.transfile.PtvGuideUploader.IPtvGuidUpCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;

public class EditWebVideoActivity
  extends EditVideoActivity
  implements Handler.Callback, PtvGuideUploader.IPtvGuidUpCallback
{
  private int jdField_a_of_type_Int;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private EncodeVideoTask.ResultListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener = new EditWebVideoActivity.1(this);
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String f;
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditWebVideoActivity", 2, "jumpToH5Activity, uid:" + this.d + ", md5:" + this.jdField_c_of_type_JavaLangString + ", callback:" + this.f);
    }
    Intent localIntent = new Intent("tencent.video.q2v.startUploadPTV");
    localIntent.putExtra("broadcastType", 1);
    localIntent.putExtra("recordType", 2);
    sendBroadcast(localIntent);
    f();
    if (!TextUtils.isEmpty(this.f))
    {
      localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.shortVideoJsApiPulgin");
      localIntent.putExtra("uuid", this.d);
      localIntent.putExtra("md5", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("callback", this.f);
      localIntent.putExtra("mediaType", "video");
      finish();
      sendBroadcast(localIntent);
      return;
    }
    QQToast.a(this, HardCodeUtil.a(2131703996), 0).a();
    finish();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager = new EditWebVideoPartManager();
    }
    ((EditWebVideoPartManager)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager).a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener);
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "showProgressDialog " + paramString);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog == null) {
          continue;
        }
        f();
        localTextView = (TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131373066);
        if (!StringUtil.a(paramString)) {
          continue;
        }
        localTextView.setText(2131717003);
      }
      catch (Throwable paramString)
      {
        TextView localTextView;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("EditWebVideoActivity", 2, "showProgressDialog", paramString);
        return;
        localTextView.setText(paramString);
        continue;
      }
      if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
        return;
      }
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      return;
      this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(this, 2131755842);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559683);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    this.f = getIntent().getStringExtra("edit_video_call_back");
    StatisticCollector.report("exposure_old_editWebVideo");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      FileUtils.e(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "onShareClick " + this.jdField_b_of_type_JavaLangString + " mthumbPath" + this.jdField_a_of_type_JavaLangString);
    }
    if ((StringUtil.a(this.jdField_b_of_type_JavaLangString)) || (StringUtil.a(this.jdField_a_of_type_JavaLangString)))
    {
      finish();
      return;
    }
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString == null))
    {
      QQToast.a(this, 2131692498, 0).a();
      f();
      return;
    }
    File localFile1 = new File(this.jdField_a_of_type_JavaLangString);
    File localFile2 = new File(this.jdField_b_of_type_JavaLangString);
    if ((!localFile1.exists()) || (!localFile2.exists()))
    {
      QQToast.a(this, 2131692498, 0).a();
      f();
      return;
    }
    if ((!localFile1.isFile()) || (!localFile2.isFile()))
    {
      QQToast.a(this, 2131692500, 0).a();
      f();
      return;
    }
    if (new PtvGuideUploader(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Int).doUpload())
    {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1003, 60000L);
      return;
    }
    f();
    QQToast.a(this, 1, 2131719292, 0).a();
  }
  
  void f()
  {
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "cancelProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditWebVideoActivity", 2, "handleMessage,msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1003: 
      f();
      QQToast.a(this, 1, 2131719291, 0).a();
      finish();
      return true;
    case 1001: 
      CaptureReportUtil.b(CameraControl.a().jdField_a_of_type_Int, "");
      g();
      return true;
    }
    f();
    a(HardCodeUtil.a(2131703991));
    e();
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onFailed(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditWebVideoActivity", 2, "OnUploadVideoListener onUploadFail!");
    }
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(1003)) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1003);
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1003);
  }
  
  public void onSuccess(String paramString)
  {
    this.d = paramString;
    if (QLog.isColorLevel()) {
      QLog.i("EditWebVideoActivity", 2, "OnUploadVideoListener onUploadSuccess! " + this.d);
    }
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(1003)) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1003);
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditWebVideoActivity
 * JD-Core Version:    0.7.0.1
 */