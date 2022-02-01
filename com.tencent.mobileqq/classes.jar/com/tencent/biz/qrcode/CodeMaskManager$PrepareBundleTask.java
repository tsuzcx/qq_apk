package com.tencent.biz.qrcode;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

class CodeMaskManager$PrepareBundleTask
  extends Thread
{
  Bundle jdField_a_of_type_AndroidOsBundle;
  CodeMaskManager.Callback jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager$Callback;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  CodeMaskManager$PrepareBundleTask(CodeMaskManager paramCodeMaskManager, CodeMaskManager.Callback paramCallback, Bundle paramBundle)
  {
    super("qr_code_mask_prepare_thread");
    this.jdField_a_of_type_ComTencentBizQrcodeCodeMaskManager$Callback = paramCallback;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  Bundle a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("qrsz"))
      {
        localObject = ((QRDisplayActivity)this.this$0.jdField_a_of_type_AndroidAppActivity).a();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (bool) {}
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject;
      if (QLog.isColorLevel()) {
        QLog.d("CodeMaskManager", 2, localOutOfMemoryError.getMessage());
      }
      System.gc();
      return null;
    }
    catch (IOException localIOException)
    {
      label52:
      return null;
    }
    try
    {
      localObject = QRUtils.a((String)localObject, this.jdField_a_of_type_AndroidOsBundle.getInt("qrsz"));
    }
    catch (Exception localException)
    {
      break label52;
    }
    localObject = null;
    if (localObject == null) {
      return null;
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("bkgUrl"))
    {
      localObject = CodeMaskManager.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle.getString("bkgUrl"));
      this.jdField_a_of_type_AndroidOsBundle.putParcelable("bkg", (Parcelable)localObject);
      this.jdField_a_of_type_AndroidOsBundle.remove("bkgUrl");
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("qrbkgUrl"))
    {
      localObject = CodeMaskManager.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle.getString("qrbkgUrl"));
      this.jdField_a_of_type_AndroidOsBundle.putParcelable("qrbkg", (Parcelable)localObject);
      this.jdField_a_of_type_AndroidOsBundle.remove("qrbkgUrl");
    }
    localObject = this.jdField_a_of_type_AndroidOsBundle;
    return localObject;
  }
  
  public void run()
  {
    Bundle localBundle = a();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.post(new CodeMaskManager.PrepareBundleTask.1(this, localBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager.PrepareBundleTask
 * JD-Core Version:    0.7.0.1
 */