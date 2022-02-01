package com.tencent.biz.qqstory.network.handler;

import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import mqq.manager.TicketManager;

class ReportEvilToXinanHandler$1
  implements Runnable
{
  ReportEvilToXinanHandler$1(ReportEvilToXinanHandler paramReportEvilToXinanHandler, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    String str4 = ReportEvilToXinanHandler.a(this.this$0);
    String str1;
    if (this.jdField_a_of_type_Boolean) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str3 = this.b;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("android");
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append("8.7.0");
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append("1111");
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(str4);
    str4 = MD5Utils.toMD5(((StringBuilder)localObject1).toString());
    SLog.a("ReportEvilToXinanHandler", "get cryptograph step1. scretKey = %s.", str4);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(str2);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(str3);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(str4);
    str4 = MD5Utils.toMD5(((StringBuilder)localObject1).toString());
    SLog.a("ReportEvilToXinanHandler", "get cryptograph step2. cryptograph = %s.", str4);
    Object localObject2 = (TicketManager)PlayModeUtils.a().getManager(2);
    localObject1 = PlayModeUtils.a().getCurrentAccountUin();
    String str5 = ((TicketManager)localObject2).getSkey((String)localObject1);
    localObject2 = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(";skey=");
    localStringBuilder.append(str5);
    ((Bundle)localObject2).putString("cookie", localStringBuilder.toString());
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("system", "android");
    ((Bundle)localObject1).putString("version", "8.7.0");
    ((Bundle)localObject1).putString("uintype", "1");
    ((Bundle)localObject1).putString("eviluin", this.c);
    ((Bundle)localObject1).putString("appname", "KQQ");
    ((Bundle)localObject1).putString("appid", "2400002");
    ((Bundle)localObject1).putString("subapp", "near_trace");
    ((Bundle)localObject1).putString("scene", "1111");
    ((Bundle)localObject1).putString("evil_type", this.d);
    ((Bundle)localObject1).putString("buddyflag", str1);
    ((Bundle)localObject1).putString("srv_para", "");
    ((Bundle)localObject1).putString("impeach_desc", "");
    ((Bundle)localObject1).putString("text_evidence", str2);
    ((Bundle)localObject1).putString("img_evidence", "");
    ((Bundle)localObject1).putString("url_evidence", "");
    ((Bundle)localObject1).putString("video_evidence", str3);
    ((Bundle)localObject1).putString("file_evidence", "");
    ((Bundle)localObject1).putString("audio_evidence", "");
    ((Bundle)localObject1).putString("user_input_param", "REPORT_IP=0&EVIL_IP=0");
    ((Bundle)localObject1).putString("cryptograph", str4);
    try
    {
      str1 = HttpUtil.openUrl(BaseApplicationImpl.getContext(), "https://jubao.qq.com/uniform_impeach/impeach_submit", "POST", (Bundle)localObject1, (Bundle)localObject2);
      ReportEvilToXinanHandler.a(this.this$0, this.c, this.e, this.d, str1);
      return;
    }
    catch (IOException localIOException)
    {
      QLog.d("ReportEvilToXinanHandler", 1, localIOException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.ReportEvilToXinanHandler.1
 * JD-Core Version:    0.7.0.1
 */