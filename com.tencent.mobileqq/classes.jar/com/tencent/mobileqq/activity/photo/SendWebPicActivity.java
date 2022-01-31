package com.tencent.mobileqq.activity.photo;

import aipr;
import alud;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import awkj;
import baqy;
import bayf;
import bayj;
import bayk;
import bdin;
import bdnn;
import bhsl;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class SendWebPicActivity
  extends BaseActivity
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  bayj jdField_a_of_type_Bayj = new aipr(this);
  private bhsl jdField_a_of_type_Bhsl;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendWebPicActivity", 2, "jumpToH5Activity, uuid:" + this.jdField_c_of_type_JavaLangString + ", md5:" + this.jdField_b_of_type_JavaLangString + ", callback:" + this.jdField_e_of_type_JavaLangString);
    }
    Intent localIntent = new Intent("tencent.video.q2v.startUploadPTV");
    localIntent.putExtra("broadcastType", 1);
    localIntent.putExtra("recordType", 3);
    sendBroadcast(localIntent);
    a();
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.shortVideoJsApiPulgin");
      localIntent.putExtra("uuid", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("md5", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("imgurl", this.d);
      localIntent.putExtra("callback", this.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("mediaType", "image");
      sendBroadcast(localIntent);
    }
    for (;;)
    {
      setResult(-1);
      finish();
      return;
      QQToast.a(this, alud.a(2131714223), 0).a();
    }
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SendWebPicActivity", 2, "cancelProgressDialog");
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
  
  public void a(String paramString)
  {
    ThreadManager.executeOnSubThread(new SendWebPicActivity.1(this, paramString));
  }
  
  public void b(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, BlessSelectMemberActivity.class);
    localIntent.putExtra("param_type", 9003);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_title", getString(2131690565));
    localIntent.putExtra("param_done_button_wording", getString(2131691089));
    localIntent.putExtra("param_exit_animation", 1);
    localIntent.putExtra("param_entrance", 32);
    localIntent.putExtra("param_blesstype", 3);
    localIntent.putExtra("thumbfile_send_path", paramString);
    startActivity(localIntent);
    setResult(-1);
    finish();
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendWebPicActivity", 2, "startUploadPic path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_Bhsl.sendEmptyMessage(1003);
      if (QLog.isColorLevel()) {
        QLog.d("SendWebPicActivity", 2, "startUploadPic empty path!");
      }
    }
    do
    {
      return;
      localObject = new File(paramString);
      if (((File)localObject).exists()) {
        break;
      }
      this.jdField_a_of_type_Bhsl.sendEmptyMessage(1003);
    } while (!QLog.isColorLevel());
    QLog.d("SendWebPicActivity", 2, "startUploadPic file not exist, path=" + paramString);
    return;
    this.jdField_a_of_type_Long = ((File)localObject).length();
    if (!bdin.g(this))
    {
      this.jdField_a_of_type_Bhsl.sendEmptyMessage(1004);
      return;
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.d = "";
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0);
    localCompressInfo.f = 0;
    if (!awkj.a(localCompressInfo)) {
      QLog.d("SendWebPicActivity", 1, "CompressOperator failed");
    }
    if (TextUtils.isEmpty(localCompressInfo.jdField_e_of_type_JavaLangString)) {}
    for (Object localObject = paramString;; localObject = localCompressInfo.jdField_e_of_type_JavaLangString)
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      this.jdField_b_of_type_Long = new File(this.jdField_a_of_type_JavaLangString).length();
      if (QLog.isColorLevel()) {
        QLog.d("SendWebPicActivity", 2, String.format("startUploadPic outWidth[%s], outHeight[%s], sizeBefore[%s], sizeAfter[%s], compressPath=[%s], originPath[%s]", new Object[] { Integer.valueOf(localCompressInfo.d), Integer.valueOf(localCompressInfo.jdField_e_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.jdField_b_of_type_Long), localCompressInfo.jdField_e_of_type_JavaLangString, paramString }));
      }
      paramString = this.app.a();
      this.jdField_a_of_type_Bayj.addFilter(new Class[] { baqy.class });
      paramString.a(this.jdField_a_of_type_Bayj);
      localObject = new bayk();
      ((bayk)localObject).jdField_a_of_type_Boolean = true;
      ((bayk)localObject).jdField_c_of_type_Int = 51;
      ((bayk)localObject).i = this.jdField_a_of_type_JavaLangString;
      ((bayk)localObject).jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
      ((bayk)localObject).jdField_c_of_type_JavaLangString = "0";
      ((bayk)localObject).b = 24;
      ((bayk)localObject).jdField_a_of_type_JavaLangString = "h5UploadPicHit";
      paramString.a((bayk)localObject);
      return;
    }
  }
  
  void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("SendWebPicActivity", 2, "showProgressDialog " + paramString);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog == null) {
          continue;
        }
        a();
        localTextView = (TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131371894);
        if (!bdnn.a(paramString)) {
          continue;
        }
        localTextView.setText(2131717582);
      }
      catch (Throwable paramString)
      {
        TextView localTextView;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("SendWebPicActivity", 2, "showProgressDialog", paramString);
        return;
        localTextView.setText(paramString);
        continue;
      }
      if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
        return;
      }
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      return;
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131755801);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559437);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Bhsl = new bhsl(this);
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("edit_video_call_back");
    paramBundle = getIntent().getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    this.jdField_a_of_type_Int = getIntent().getIntExtra("shareto_web_mode", -1);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Boolean = false;
      a(paramBundle);
    }
    while (this.jdField_a_of_type_Int != 1) {
      return true;
    }
    b(paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.a().b(this.jdField_a_of_type_Bayj);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendWebPicActivity", 2, "handleMessage,msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1003: 
      a();
      QQToast.a(this, 1, 2131720031, 0).a();
      finish();
      return true;
    case 1001: 
      b();
      return true;
    case 1002: 
      a();
      d(alud.a(2131714224));
      return true;
    }
    a();
    QQToast.a(this, 1, 2131695065, 0).a();
    finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendWebPicActivity
 * JD-Core Version:    0.7.0.1
 */