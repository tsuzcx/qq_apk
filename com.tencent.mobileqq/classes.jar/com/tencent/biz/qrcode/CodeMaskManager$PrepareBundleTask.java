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
  AtomicBoolean a = new AtomicBoolean(false);
  CodeMaskManager.Callback b;
  Bundle c;
  
  CodeMaskManager$PrepareBundleTask(CodeMaskManager paramCodeMaskManager, CodeMaskManager.Callback paramCallback, Bundle paramBundle)
  {
    super("qr_code_mask_prepare_thread");
    this.b = paramCallback;
    this.c = paramBundle;
  }
  
  Bundle a()
  {
    try
    {
      if (this.c.containsKey("qrsz"))
      {
        localObject = ((QRDisplayActivity)this.this$0.c).j();
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
      localObject = QRUtils.a((String)localObject, this.c.getInt("qrsz"));
    }
    catch (Exception localException)
    {
      break label52;
    }
    localObject = null;
    if (localObject == null) {
      return null;
    }
    if (this.c.containsKey("bkgUrl"))
    {
      localObject = CodeMaskManager.a(this.this$0, this.c.getString("bkgUrl"));
      this.c.putParcelable("bkg", (Parcelable)localObject);
      this.c.remove("bkgUrl");
    }
    if (this.c.containsKey("qrbkgUrl"))
    {
      localObject = CodeMaskManager.a(this.this$0, this.c.getString("qrbkgUrl"));
      this.c.putParcelable("qrbkg", (Parcelable)localObject);
      this.c.remove("qrbkgUrl");
    }
    localObject = this.c;
    return localObject;
  }
  
  public void run()
  {
    Bundle localBundle = a();
    if (this.a.compareAndSet(false, true)) {
      this.this$0.g.post(new CodeMaskManager.PrepareBundleTask.1(this, localBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager.PrepareBundleTask
 * JD-Core Version:    0.7.0.1
 */