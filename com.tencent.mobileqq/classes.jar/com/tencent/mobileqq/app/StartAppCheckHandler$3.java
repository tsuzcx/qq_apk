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
      Object localObject = StartAppCheckHandler.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        long l = new File(((PackageInfo)localObject).applicationInfo.sourceDir).lastModified();
        String str = SecUtil.getSignatureHash(localObject.signatures[0].toByteArray());
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.c = l;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.d = str;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.b = ((PackageInfo)localObject).versionName;
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.c = MD5Utils.encodeFileHexStr(((PackageInfo)localObject).applicationInfo.sourceDir);
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.jdField_a_of_type_JavaLangString = this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.d;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$CacheInfo.b = this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.c;
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, " " + this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_Long + " " + this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_Int + " " + this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_JavaLangString + " " + this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.b + " " + this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.c + " " + this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.d);
      }
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_JavaLangString != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.b != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.c != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.d != null))
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_ComTencentImsSignature$SignatureReport.u64_uin.set(this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_Long);
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_ComTencentImsSignature$SignatureReport.u32_client_type.set(this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_Int);
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_packname.set(this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_JavaLangString);
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_version.set(this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.b);
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_md5.set(this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.c);
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_signature.set(this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.d);
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP.jdField_a_of_type_ComTencentImsSignature$SignatureReport.u32_protocol_version.set(2);
        localObject = new Message();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = this.this$0.jdField_a_of_type_ComTencentMobileqqAppStartAppCheckHandler$SendingAPP;
        StartAppCheckHandler.a(this.this$0).sendMessage((Message)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("AppStartedHandler", 2, "SendStartedAppInfo end..");
        }
      }
      this.this$0.jdField_a_of_type_Boolean = false;
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