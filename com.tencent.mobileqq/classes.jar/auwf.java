import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.channel.relation.SCFChannel.1.1;
import com.tencent.mobileqq.flutter.channel.relation.SCFChannel.1.2;
import com.tencent.mobileqq.flutter.channel.relation.SCFChannel.1.3;
import com.tencent.mobileqq.flutter.channel.relation.SCFChannel.1.4;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.Result;
import mqq.os.MqqHandler;

public class auwf
  extends auwg
{
  auwf(auwe paramauwe) {}
  
  protected void a(String paramString, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.SCFSettingChannel", 2, String.format("getSCFSwitchs, uin: %s", new Object[] { paramString }));
    }
    ThreadManager.getSubThreadHandler().post(new SCFChannel.1.3(this, paramString, paramResult));
  }
  
  protected void a(String paramString, Boolean paramBoolean, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.SCFSettingChannel", 2, String.format("setSpecialCare, uin: %s, isSpecialCare: %s", new Object[] { paramString, paramBoolean }));
    }
    ThreadManager.getSubThreadHandler().post(new SCFChannel.1.1(this, paramString, paramBoolean, paramResult));
  }
  
  protected void a(String paramString, Integer paramInteger, MethodChannel.Result paramResult)
  {
    VasWebviewUtil.reportCommercialDrainage(this.a.b(), "Care", "PageView", "", 1, 0, 0, null, null, null);
  }
  
  protected void a(String paramString, Integer paramInteger, Boolean paramBoolean, MethodChannel.Result paramResult)
  {
    paramResult = this.a.b();
    if (paramBoolean.booleanValue()) {}
    for (paramString = "SwitchOn";; paramString = "SwitchOff")
    {
      VasWebviewUtil.reportCommercialDrainage(paramResult, "Care", paramString, Integer.toString(paramInteger.intValue()), 1, 0, 0, null, null, null);
      return;
    }
  }
  
  protected void b(String paramString, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.SCFSettingChannel", 2, String.format("getSpecialRing, uin: %s", new Object[] { paramString }));
    }
    ThreadManager.getSubThreadHandler().post(new SCFChannel.1.4(this, paramString, paramResult));
  }
  
  protected void b(String paramString, Boolean paramBoolean, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.SCFSettingChannel", 2, String.format("setQzoneNotify, uin: %s, isQzoneNotify: %s", new Object[] { paramString, paramBoolean }));
    }
    ThreadManager.getSubThreadHandler().post(new SCFChannel.1.2(this, paramString, paramBoolean, paramResult));
  }
  
  protected void b(String paramString, Integer paramInteger, MethodChannel.Result paramResult)
  {
    VasWebviewUtil.reportCommercialDrainage(this.a.b(), "bell", "care_show", "", 1, 0, 0, "", "", "");
  }
  
  protected void c(String paramString, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.SCFSettingChannel", 2, String.format("openSpecialRingMall", new Object[0]));
    }
    paramResult = new Intent(BaseApplicationImpl.context, QQBrowserActivity.class);
    paramResult.addFlags(268435456);
    paramResult.putExtra("url", bhyk.a("specialCareRingUrl").replace("[uid]", paramString).replace("[lType]", "2"));
    BaseApplicationImpl.getContext().startActivity(paramResult);
  }
  
  protected void c(String paramString, Integer paramInteger, MethodChannel.Result paramResult)
  {
    bdll.b(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 2, 0, "", "", "", "");
    VasWebviewUtil.reportCommercialDrainage(this.a.b(), "bell", " care_click", "", 1, 0, 0, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwf
 * JD-Core Version:    0.7.0.1
 */