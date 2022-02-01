package com.tencent.mobileqq.app;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.ims.signature.SignatureReport;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class StartAppCheckHandler$3
  implements Runnable
{
  StartAppCheckHandler$3(StartAppCheckHandler paramStartAppCheckHandler) {}
  
  public void run()
  {
    try
    {
      Object localObject = StartAppCheckHandler.a(this.this$0, this.this$0.c.getApplication(), this.this$0.i.c);
      if (localObject != null)
      {
        long l = new File(((PackageInfo)localObject).applicationInfo.sourceDir).lastModified();
        String str = SecUtil.getSignatureHash(localObject.signatures[0].toByteArray());
        this.this$0.j.c = l;
        this.this$0.i.f = str;
        this.this$0.i.d = ((PackageInfo)localObject).versionName;
        this.this$0.i.e = MD5Utils.encodeFileHexStr(((PackageInfo)localObject).applicationInfo.sourceDir);
      }
      this.this$0.j.d = this.this$0.i.f;
      this.this$0.j.e = this.this$0.i.e;
      boolean bool = QLog.isColorLevel();
      if (bool)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.this$0.i.a);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.this$0.i.b);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.this$0.i.c);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.this$0.i.d);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.this$0.i.e);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.this$0.i.f);
        QLog.d("AppStartedHandler", 2, ((StringBuilder)localObject).toString());
      }
      if ((this.this$0.i.c != null) && (this.this$0.i.d != null) && (this.this$0.i.e != null) && (this.this$0.i.f != null))
      {
        this.this$0.i.g.u64_uin.set(this.this$0.i.a);
        this.this$0.i.g.u32_client_type.set(this.this$0.i.b);
        this.this$0.i.g.str_packname.set(this.this$0.i.c);
        this.this$0.i.g.str_version.set(this.this$0.i.d);
        this.this$0.i.g.str_md5.set(this.this$0.i.e);
        this.this$0.i.g.str_signature.set(this.this$0.i.f);
        this.this$0.i.g.u32_protocol_version.set(2);
        localObject = new Message();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = this.this$0.i;
        StartAppCheckHandler.a(this.this$0).sendMessage((Message)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("AppStartedHandler", 2, "SendStartedAppInfo end..");
        }
      }
      this.this$0.d = false;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.StartAppCheckHandler.3
 * JD-Core Version:    0.7.0.1
 */