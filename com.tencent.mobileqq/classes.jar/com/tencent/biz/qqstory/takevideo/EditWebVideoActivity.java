package com.tencent.biz.qqstory.takevideo;

import aigq;
import ajyc;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import avtb;
import axhp;
import ayto;
import aytq;
import bbdj;
import bbjw;
import bcpw;
import bfmt;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import vjb;
import vjc;

public class EditWebVideoActivity
  extends EditVideoActivity
  implements Handler.Callback, aytq
{
  private int jdField_a_of_type_Int;
  private aigq jdField_a_of_type_Aigq = new vjb(this);
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private bfmt jdField_a_of_type_Bfmt;
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
    bcpw.a(this, ajyc.a(2131703968), 0).a();
    finish();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Vhp == null) {
      this.jdField_a_of_type_Vhp = new vjc();
    }
    ((vjc)this.jdField_a_of_type_Vhp).a(this.jdField_a_of_type_Aigq);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditWebVideoActivity", 2, "OnUploadVideoListener onUploadFail!");
    }
    if (this.jdField_a_of_type_Bfmt.hasMessages(1003)) {
      this.jdField_a_of_type_Bfmt.removeMessages(1003);
    }
    this.jdField_a_of_type_Bfmt.sendEmptyMessage(1003);
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
    if (QLog.isColorLevel()) {
      QLog.i("EditWebVideoActivity", 2, "OnUploadVideoListener onUploadSuccess! " + this.d);
    }
    if (this.jdField_a_of_type_Bfmt.hasMessages(1003)) {
      this.jdField_a_of_type_Bfmt.removeMessages(1003);
    }
    this.jdField_a_of_type_Bfmt.sendEmptyMessage(1001);
  }
  
  public void d(String paramString)
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
        localTextView = (TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131371557);
        if (!bbjw.a(paramString)) {
          continue;
        }
        localTextView.setText(2131717187);
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
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131755791);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559386);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Bfmt = new bfmt(this);
    this.f = getIntent().getStringExtra("edit_video_call_back");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      bbdj.d(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "onShareClick " + this.jdField_b_of_type_JavaLangString + " mthumbPath" + this.jdField_a_of_type_JavaLangString);
    }
    if ((bbjw.a(this.jdField_b_of_type_JavaLangString)) || (bbjw.a(this.jdField_a_of_type_JavaLangString)))
    {
      finish();
      return;
    }
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString == null))
    {
      bcpw.a(this, 2131692558, 0).a();
      f();
      return;
    }
    File localFile1 = new File(this.jdField_a_of_type_JavaLangString);
    File localFile2 = new File(this.jdField_b_of_type_JavaLangString);
    if ((!localFile1.exists()) || (!localFile2.exists()))
    {
      bcpw.a(this, 2131692558, 0).a();
      f();
      return;
    }
    if ((!localFile1.isFile()) || (!localFile2.isFile()))
    {
      bcpw.a(this, 2131692560, 0).a();
      f();
      return;
    }
    if (new ayto(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Int).a())
    {
      this.jdField_a_of_type_Bfmt.sendEmptyMessageDelayed(1003, 60000L);
      return;
    }
    f();
    bcpw.a(this, 1, 2131719477, 0).a();
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
      bcpw.a(this, 1, 2131719476, 0).a();
      finish();
      return true;
    case 1001: 
      avtb.b(axhp.a().jdField_a_of_type_Int, "");
      g();
      return true;
    }
    f();
    d(ajyc.a(2131703963));
    e();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditWebVideoActivity
 * JD-Core Version:    0.7.0.1
 */