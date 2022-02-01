package com.tencent.mobileqq.app;

import anjo;
import bbck;
import bctj;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConfigHandler$6
  implements Runnable
{
  public ConfigHandler$6(anjo paramanjo, String paramString, bbck parambbck, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject1 = new File(this.this$0.app.getApplication().getFilesDir(), "rich_status.tmp");
    Object localObject2 = MsfSdkUtils.insertMtype("ConfigCheck", this.jdField_a_of_type_JavaLangString);
    int i = HttpDownloadUtil.a(this.this$0.app, (String)localObject2, (File)localObject1);
    if (QLog.isColorLevel()) {
      QLog.w("Q.richstatus.xml", 2, "handleUpdateStatusActions download " + this.jdField_a_of_type_JavaLangString + " result " + i);
    }
    String str;
    if (i == 0) {
      if (this.jdField_a_of_type_Bbck.a((File)localObject1, this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.uiNewVer))
      {
        this.this$0.notifyUI(7, true, Integer.valueOf(102));
        localObject1 = bctj.a(BaseApplication.getContext());
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("result", String.valueOf(i));
        ((HashMap)localObject2).put("version", String.valueOf(this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo.uiNewVer));
        ((HashMap)localObject2).put("url", this.jdField_a_of_type_JavaLangString);
        str = this.this$0.app.getCurrentAccountUin();
        if (i != 0) {
          break label327;
        }
      }
    }
    for (;;)
    {
      ((bctj)localObject1).a(str, "RichStatusAction", bool, 0L, 0L, (HashMap)localObject2, "");
      return;
      this.this$0.notifyUI(7, false, Integer.valueOf(-3));
      break;
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.xml", 2, "httpdownload failed: " + this.jdField_a_of_type_JavaLangString + ", result " + i);
      }
      if ((i == 4) || (i == 12))
      {
        this.this$0.notifyUI(7, false, Integer.valueOf(-3));
        break;
      }
      this.this$0.notifyUI(7, false, Integer.valueOf(-1));
      break;
      label327:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.6
 * JD-Core Version:    0.7.0.1
 */