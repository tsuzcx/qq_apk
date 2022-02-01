package com.tencent.biz.qrcode;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import zro;
import zvc;

class CodeMaskManager$PrepareBundleTask
  extends Thread
{
  Bundle jdField_a_of_type_AndroidOsBundle;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  zro jdField_a_of_type_Zro;
  
  CodeMaskManager$PrepareBundleTask(CodeMaskManager paramCodeMaskManager, zro paramzro, Bundle paramBundle)
  {
    super("qr_code_mask_prepare_thread");
    this.jdField_a_of_type_Zro = paramzro;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  Bundle a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("qrsz"))
      {
        Object localObject1 = ((QRDisplayActivity)this.this$0.jdField_a_of_type_AndroidAppActivity).a();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        if (!bool) {
          try
          {
            localObject1 = zvc.a((String)localObject1, this.jdField_a_of_type_AndroidOsBundle.getInt("qrsz"));
            if (localObject1 == null) {
              return null;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localObject2 = null;
            }
          }
        }
      }
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("bkgUrl"))
      {
        localObject2 = CodeMaskManager.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle.getString("bkgUrl"));
        this.jdField_a_of_type_AndroidOsBundle.putParcelable("bkg", (Parcelable)localObject2);
        this.jdField_a_of_type_AndroidOsBundle.remove("bkgUrl");
      }
      if (this.jdField_a_of_type_AndroidOsBundle.containsKey("qrbkgUrl"))
      {
        localObject2 = CodeMaskManager.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle.getString("qrbkgUrl"));
        this.jdField_a_of_type_AndroidOsBundle.putParcelable("qrbkg", (Parcelable)localObject2);
        this.jdField_a_of_type_AndroidOsBundle.remove("qrbkgUrl");
      }
      Object localObject2 = this.jdField_a_of_type_AndroidOsBundle;
      return localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CodeMaskManager", 2, localOutOfMemoryError.getMessage());
      }
      System.gc();
      return null;
    }
    catch (IOException localIOException)
    {
      label184:
      break label184;
    }
  }
  
  public void run()
  {
    Bundle localBundle = a();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.post(new CodeMaskManager.PrepareBundleTask.1(this, localBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager.PrepareBundleTask
 * JD-Core Version:    0.7.0.1
 */