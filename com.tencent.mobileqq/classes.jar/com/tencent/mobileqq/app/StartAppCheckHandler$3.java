package com.tencent.mobileqq.app;

import anbg;
import anbl;
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

public class StartAppCheckHandler$3
  implements Runnable
{
  public StartAppCheckHandler$3(anbg paramanbg) {}
  
  public void run()
  {
    try
    {
      Object localObject = anbg.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.this$0.jdField_a_of_type_Anbl.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        long l = new File(((PackageInfo)localObject).applicationInfo.sourceDir).lastModified();
        String str = SecUtil.getSignatureHash(localObject.signatures[0].toByteArray());
        this.this$0.jdField_a_of_type_Anbj.c = l;
        this.this$0.jdField_a_of_type_Anbl.d = str;
        this.this$0.jdField_a_of_type_Anbl.b = ((PackageInfo)localObject).versionName;
        this.this$0.jdField_a_of_type_Anbl.c = MD5Utils.encodeFileHexStr(((PackageInfo)localObject).applicationInfo.sourceDir);
      }
      this.this$0.jdField_a_of_type_Anbj.jdField_a_of_type_JavaLangString = this.this$0.jdField_a_of_type_Anbl.d;
      this.this$0.jdField_a_of_type_Anbj.b = this.this$0.jdField_a_of_type_Anbl.c;
      if (QLog.isColorLevel()) {
        QLog.d("AppStartedHandler", 2, " " + this.this$0.jdField_a_of_type_Anbl.jdField_a_of_type_Long + " " + this.this$0.jdField_a_of_type_Anbl.jdField_a_of_type_Int + " " + this.this$0.jdField_a_of_type_Anbl.jdField_a_of_type_JavaLangString + " " + this.this$0.jdField_a_of_type_Anbl.b + " " + this.this$0.jdField_a_of_type_Anbl.c + " " + this.this$0.jdField_a_of_type_Anbl.d);
      }
      if ((this.this$0.jdField_a_of_type_Anbl.jdField_a_of_type_JavaLangString != null) && (this.this$0.jdField_a_of_type_Anbl.b != null) && (this.this$0.jdField_a_of_type_Anbl.c != null) && (this.this$0.jdField_a_of_type_Anbl.d != null))
      {
        this.this$0.jdField_a_of_type_Anbl.jdField_a_of_type_ComTencentImsSignature$SignatureReport.u64_uin.set(this.this$0.jdField_a_of_type_Anbl.jdField_a_of_type_Long);
        this.this$0.jdField_a_of_type_Anbl.jdField_a_of_type_ComTencentImsSignature$SignatureReport.u32_client_type.set(this.this$0.jdField_a_of_type_Anbl.jdField_a_of_type_Int);
        this.this$0.jdField_a_of_type_Anbl.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_packname.set(this.this$0.jdField_a_of_type_Anbl.jdField_a_of_type_JavaLangString);
        this.this$0.jdField_a_of_type_Anbl.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_version.set(this.this$0.jdField_a_of_type_Anbl.b);
        this.this$0.jdField_a_of_type_Anbl.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_md5.set(this.this$0.jdField_a_of_type_Anbl.c);
        this.this$0.jdField_a_of_type_Anbl.jdField_a_of_type_ComTencentImsSignature$SignatureReport.str_signature.set(this.this$0.jdField_a_of_type_Anbl.d);
        this.this$0.jdField_a_of_type_Anbl.jdField_a_of_type_ComTencentImsSignature$SignatureReport.u32_protocol_version.set(2);
        localObject = new Message();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = this.this$0.jdField_a_of_type_Anbl;
        anbg.a(this.this$0).sendMessage((Message)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.StartAppCheckHandler.3
 * JD-Core Version:    0.7.0.1
 */