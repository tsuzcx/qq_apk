package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import myu;
import myv;
import myw;
import myx;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountH5AbilityForPtt
  implements QQRecorder.OnQQRecorderListener
{
  private static double jdField_a_of_type_Double;
  private static int jdField_a_of_type_Int;
  private static String c = "";
  private static String d = "";
  private static String e = "";
  private static String f = "";
  private static String g = "";
  public Activity a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  private VoicePlayer.VoicePlayerListener jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer$VoicePlayerListener = new myu(this);
  public VoicePlayer a;
  public WebViewPlugin.PluginRuntime a;
  private File jdField_a_of_type_JavaIoFile;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  private String jdField_a_of_type_JavaLangString = "PublicAccountH5AbilityForPtt";
  private int jdField_b_of_type_Int = 60000;
  private String jdField_b_of_type_JavaLangString;
  
  public PublicAccountH5AbilityForPtt() {}
  
  public PublicAccountH5AbilityForPtt(Activity paramActivity, String paramString, WebViewPlugin.PluginRuntime paramPluginRuntime)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime = paramPluginRuntime;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public static String a()
  {
    return c;
  }
  
  public static int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public static String b()
  {
    return d;
  }
  
  public static int c()
  {
    if (jdField_a_of_type_Double != 0.0D) {
      return QQRecorder.a(jdField_a_of_type_Double);
    }
    return 0;
  }
  
  public static String c()
  {
    return e;
  }
  
  public static void c(String paramString)
  {
    c = paramString;
  }
  
  public static void d(String paramString)
  {
    g = paramString;
  }
  
  private void j()
  {
    SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_AndroidAppActivity.getString(2131433403));
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, "权限提示", localSpannableString, 0, 2131435212, null, null, new myx(this)).show();
  }
  
  public int a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", 0);
      localJSONObject.put("msg", "startRecord");
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().a(PublicAccountH5AbilityPlugin.c, new String[] { localJSONObject.toString() });
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, 0, "1", "", "", "");
      i();
      return 0;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = g;
    }
    paramString = str.split("/");
    str = paramString[(paramString.length - 1)];
    paramString = "";
    if (str.length() >= 21) {
      paramString = str.substring(0, str.length() - 4);
    }
    return paramString;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (a(AppConstants.aK + this.jdField_b_of_type_JavaLangString + "/" + "c2bPTT/"))
    {
      this.jdField_a_of_type_JavaIoFile = new File(paramString);
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
      try
      {
        this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaIoFile);
        this.jdField_a_of_type_JavaIoFileOutputStream.write("#!AMR\n".getBytes());
        return;
      }
      catch (FileNotFoundException paramString)
      {
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
        paramString.printStackTrace();
        return;
      }
      catch (IOException paramString)
      {
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
        return;
      }
    }
    paramString = new JSONObject();
    try
    {
      paramString.put("retCode", -1);
      paramString.put("msg", "no sdCard");
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().a(PublicAccountH5AbilityPlugin.c, new String[] { paramString.toString() });
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    jdField_a_of_type_Double = paramDouble;
    paramString = new JSONObject();
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_Double == this.jdField_b_of_type_Int)
        {
          paramString.put("retCode", 0);
          paramString.put("msg", "录音时间已超过一分钟");
          paramString.put("localId", d());
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a() != null) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().a(PublicAccountH5AbilityPlugin.g, new String[] { paramString.toString() });
          }
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2B", "0X8005D2B", 0, 0, "1", "", "", "");
          return;
        }
        if (this.jdField_a_of_type_JavaIoFile.exists())
        {
          paramString.put("retCode", 0);
          paramString.put("msg", "localId 为" + d());
          paramString.put("localId", d());
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, 0, "1", "", "", "");
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a() == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().a(PublicAccountH5AbilityPlugin.d, new String[] { paramString.toString() });
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString.put("retCode", -1);
      paramString.put("msg", "文件不存在");
      paramString.put("localId", d());
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, -1, "1", "", "", "");
    }
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("retCode", -1);
      paramString1.put("msg", "onRecorderError");
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().a(PublicAccountH5AbilityPlugin.c, new String[] { paramString1.toString() });
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {
        this.jdField_a_of_type_JavaIoFileOutputStream.write(paramArrayOfByte, 0, paramInt1);
      }
      return;
    }
    catch (IOException paramString) {}
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b());
  }
  
  boolean a(String paramString)
  {
    paramString = new File(paramString);
    return (paramString.exists()) || (paramString.mkdirs());
  }
  
  public String b(String paramString)
  {
    return AppConstants.aK + this.jdField_b_of_type_JavaLangString + "/" + "c2bPTT/" + paramString + ".amr";
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_AndroidAppActivity);
    }
    f = AppConstants.aK + this.jdField_b_of_type_JavaLangString + "/" + "c2bPTT/" + FileMsg.a() + ".amr";
    AudioUtil.a(this.jdField_a_of_type_AndroidAppActivity, true);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(f);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer == null) || (this.jdField_a_of_type_AndroidOsHandler == null) || ((this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a() != 3)))
      {
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(paramString, this.jdField_a_of_type_AndroidOsHandler);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer$VoicePlayerListener);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a() == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.c();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a() != 3);
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.d();
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    d(paramString, paramRecorderParam);
    paramString = new JSONObject();
    try
    {
      paramString.put("retCode", -1);
      paramString.put("msg", "onRecorderAbnormal");
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().a(PublicAccountH5AbilityPlugin.c, new String[] { paramString.toString() });
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a() == 2);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = null;
    }
    d();
    AudioUtil.a(this.jdField_a_of_type_AndroidAppActivity, false);
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    d(paramString, paramRecorderParam);
    paramString = new JSONObject();
    try
    {
      paramString.put("retCode", -1);
      paramString.put("msg", "onInitFailed");
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().a(PublicAccountH5AbilityPlugin.c, new String[] { paramString.toString() });
      }
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, -1, "1", "", "", "");
      return;
    }
    catch (JSONException paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam.printStackTrace();
      }
    }
  }
  
  public String d()
  {
    Object localObject1 = f.split("/");
    Object localObject2 = localObject1[(localObject1.length - 1)];
    localObject1 = "";
    if (localObject2.length() >= 21) {
      localObject1 = localObject2.substring(0, localObject2.length() - 4);
    }
    return localObject1;
  }
  
  public void d()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {
        this.jdField_a_of_type_JavaIoFileOutputStream.close();
      }
      label14:
      this.jdField_a_of_type_JavaIoFileOutputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      break label14;
    }
  }
  
  public void d(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new myw(this));
  }
  
  public void e()
  {
    JSONObject localJSONObject;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.f();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("retCode", 0);
      localJSONObject.put("msg", "录音(" + d() + ")播放结束");
      localJSONObject.put("localId", d());
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin$PluginRuntime.a().a(PublicAccountH5AbilityPlugin.f, new String[] { localJSONObject.toString() });
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void f()
  {
    if (b()) {
      e();
    }
    c();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a() == 2)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.e();
    }
  }
  
  public void h()
  {
    try
    {
      File localFile = new File(f);
      if (localFile.exists())
      {
        d = MD5FileUtil.a(localFile);
        jdField_a_of_type_Int = (int)localFile.length();
        e = d;
      }
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public void i()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new myv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountH5AbilityForPtt
 * JD-Core Version:    0.7.0.1
 */