import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.biz.huiyin.HuiyinRedDotProto.RedDotGetReq;
import com.tencent.biz.huiyin.HuiyinRedDotProto.RedDotSetReq;
import com.tencent.biz.huiyin.ILiveProto.iLiveRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huiyin.HuiyinUtilsImpl.2;
import com.tencent.mobileqq.intervideo.huiyin.HuiyinUtilsImpl.4;
import com.tencent.mobileqq.intervideo.od.ODLoadingActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class asxy
{
  public int a;
  public long a;
  public asuy a;
  private IVPluginDataReporter jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter = new IVPluginDataReporter();
  public String a;
  List<asyf> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  public byte[] a;
  public String b;
  public boolean b;
  String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  String jdField_d_of_type_JavaLangString = "http://huiyin.qq.com/mobile/register/index.html?_wv=16777218";
  private boolean jdField_d_of_type_Boolean;
  String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private String f = "EchoMainSvc";
  
  public asxy()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opDepartment("huiyin");
  }
  
  public static void a(boolean paramBoolean)
  {
    String str = Environment.getExternalStorageDirectory().getPath() + "/tencent/huiyin";
    if (!new File(str).exists()) {
      new File(str).mkdir();
    }
    str = str + "/load.click";
    if (paramBoolean) {
      try
      {
        new File(str).createNewFile();
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return;
      }
    }
    new File(localIOException).delete();
  }
  
  public void a(int paramInt, String paramString)
  {
    IVPluginDataReporter localIVPluginDataReporter = this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoIVPluginDataReporter.opType("huiyin").opName("step").d1(String.valueOf(paramInt));
    String str = paramString;
    if (paramString == null) {
      str = "null";
    }
    localIVPluginDataReporter.d2(str).report();
    Log.i("huiyin.step", "step: " + paramInt);
  }
  
  void a(AppInterface paramAppInterface)
  {
    Intent localIntent;
    if (this.jdField_a_of_type_Boolean)
    {
      a(10, this.jdField_c_of_type_JavaLangString);
      b(paramAppInterface, this.jdField_c_of_type_JavaLangString);
      localIntent = new Intent(paramAppInterface.getApp().getApplicationContext(), QQBrowserActivity.class);
      localIntent.putExtra("fragmentStyle", 3);
      localIntent.putExtra("url", this.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("isTransparentTitle", true);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.setFlags(268435456);
      paramAppInterface.getApp().startActivity(localIntent);
    }
    for (;;)
    {
      c(paramAppInterface);
      return;
      JSONObject localJSONObject;
      if (this.jdField_c_of_type_JavaLangString != null)
      {
        a(true);
        localIntent = new Intent(paramAppInterface.getApp(), ODLoadingActivity.class);
        localIntent.putExtra("is_start_huiyin", true);
        localIntent.putExtra("uin", paramAppInterface.getCurrentAccountUin());
        localIntent.setFlags(268435456);
        localIntent.putExtra("param_general", this.jdField_c_of_type_JavaLangString);
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("tinyid", String.valueOf(this.jdField_a_of_type_Long));
        localJSONObject.put("a2", this.jdField_a_of_type_JavaLangString);
        localJSONObject.put("openid", this.jdField_a_of_type_Asuy.a().jdField_b_of_type_JavaLangString);
        localJSONObject.put("accesstoken", this.jdField_a_of_type_Asuy.a().jdField_a_of_type_JavaLangString);
        localJSONObject.put("usersig", this.jdField_b_of_type_JavaLangString);
        localJSONObject.put("startTS", System.currentTimeMillis());
        localJSONObject.put("qqVersion", "7.9.9");
        localJSONObject.put("params", this.jdField_c_of_type_JavaLangString);
        if (this.jdField_a_of_type_ArrayOfByte != null) {
          localJSONObject.put("ex", new String(this.jdField_a_of_type_ArrayOfByte, "UTF-8"));
        }
        localIntent.putExtra("extra", localJSONObject.toString());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("huiyin", 2, "tinyid " + this.jdField_a_of_type_Long);
      }
      paramAppInterface.getApp().startActivity(localIntent);
    }
  }
  
  public void a(AppInterface paramAppInterface, asyg paramasyg)
  {
    if (!bdiv.d(paramAppInterface.getApp().getApplicationContext())) {
      return;
    }
    if (this.jdField_a_of_type_Long == 0L)
    {
      b(paramAppInterface);
      paramAppInterface = new asyc(this, paramAppInterface, paramasyg);
      this.jdField_a_of_type_JavaUtilList.add(paramAppInterface);
      return;
    }
    b(paramAppInterface, paramasyg);
  }
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    try
    {
      this.jdField_d_of_type_JavaLangString = new JSONObject(paramString).getString("register_url");
      paramString = paramAppInterface.getAccount();
      if ((paramString != null) && (!paramString.equals(this.jdField_e_of_type_JavaLangString)) && (this.jdField_e_of_type_JavaLangString != null))
      {
        this.jdField_e_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Long = 0L;
      }
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_JavaUtilList.add(new asxz(this, paramAppInterface));
        b(paramAppInterface);
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
      a(paramAppInterface);
    }
  }
  
  public void b(AppInterface paramAppInterface)
  {
    if (!bdiv.d(paramAppInterface.getApp().getApplicationContext())) {}
    while ((this.jdField_a_of_type_Long != 0L) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    new Handler(Looper.getMainLooper()).postDelayed(new HuiyinUtilsImpl.2(this, paramAppInterface), 5000L);
    if (this.jdField_a_of_type_Asuy == null) {
      this.jdField_a_of_type_Asuy = new asuy();
    }
    this.jdField_a_of_type_Asuy.a(paramAppInterface, "", paramAppInterface.getApplication(), "101462571", new asya(this, paramAppInterface));
  }
  
  void b(AppInterface paramAppInterface, asyg paramasyg)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    ILiveProto.iLiveRequest localiLiveRequest = new ILiveProto.iLiveRequest();
    localiLiveRequest.auth_appid.set(101462571L);
    localiLiveRequest.auth_type.set(1);
    localiLiveRequest.cmd.set(10129);
    localiLiveRequest.subcmd.set(1);
    localiLiveRequest.auth_key.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localiLiveRequest.tinyid.set(this.jdField_a_of_type_Long);
    localiLiveRequest.client_type.set(401);
    localiLiveRequest.buss_id.set(160000001L);
    Object localObject = new HuiyinRedDotProto.RedDotGetReq();
    ((HuiyinRedDotProto.RedDotGetReq)localObject).appid.set(63);
    ((HuiyinRedDotProto.RedDotGetReq)localObject).uid.set(this.jdField_a_of_type_Long);
    localiLiveRequest.ex.set(ByteStringMicro.copyFrom(((HuiyinRedDotProto.RedDotGetReq)localObject).toByteArray()));
    localObject = new NewIntent(paramAppInterface.getApplication(), mzx.class);
    ((NewIntent)localObject).putExtra("cmd", this.f + ".0x2791_0x1");
    ((NewIntent)localObject).putExtra("data", localiLiveRequest.toByteArray());
    ((NewIntent)localObject).setObserver(new asyd(this, paramasyg));
    paramAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void b(AppInterface paramAppInterface, String paramString)
  {
    if (!bdiv.d(paramAppInterface.getApp().getApplicationContext())) {}
    while ((this.jdField_c_of_type_Boolean) || (paramString == null)) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    Object localObject = paramAppInterface.getAccount();
    if ((localObject != null) && (!((String)localObject).equals(this.jdField_e_of_type_JavaLangString)) && (this.jdField_e_of_type_JavaLangString != null))
    {
      this.jdField_e_of_type_JavaLangString = ((String)localObject);
      this.jdField_a_of_type_Long = 0L;
    }
    a(false);
    localObject = new Intent(paramAppInterface.getApp(), ODLoadingActivity.class);
    ((Intent)localObject).putExtra("is_start_huiyin", true);
    ((Intent)localObject).putExtra("uin", paramAppInterface.getCurrentAccountUin());
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).putExtra("param_general", paramString);
    ((Intent)localObject).putExtra("preloadOnly", true);
    paramString = new JSONObject();
    try
    {
      paramString.put("preloadOnly", true);
      paramString.put("tinyid", String.valueOf(this.jdField_a_of_type_Long));
      paramString.put("a2", this.jdField_a_of_type_JavaLangString);
      paramString.put("openid", this.jdField_a_of_type_Asuy.a().jdField_b_of_type_JavaLangString);
      paramString.put("accesstoken", this.jdField_a_of_type_Asuy.a().jdField_a_of_type_JavaLangString);
      paramString.put("usersig", this.jdField_b_of_type_JavaLangString);
      paramString.put("startTS", System.currentTimeMillis());
      paramString.put("qqVersion", "7.9.9");
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        paramString.put("ex", new String(this.jdField_a_of_type_ArrayOfByte, "UTF-8"));
      }
      ((Intent)localObject).putExtra("extra", paramString.toString());
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    new Handler(Looper.getMainLooper()).postDelayed(new HuiyinUtilsImpl.4(this, paramAppInterface, (Intent)localObject), 500L);
  }
  
  public void c(AppInterface paramAppInterface)
  {
    if (!bdiv.d(paramAppInterface.getApp().getApplicationContext())) {
      return;
    }
    ILiveProto.iLiveRequest localiLiveRequest = new ILiveProto.iLiveRequest();
    localiLiveRequest.auth_appid.set(101462571L);
    localiLiveRequest.auth_type.set(1);
    localiLiveRequest.cmd.set(10129);
    localiLiveRequest.subcmd.set(2);
    localiLiveRequest.auth_key.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localiLiveRequest.tinyid.set(this.jdField_a_of_type_Long);
    localiLiveRequest.client_type.set(401);
    localiLiveRequest.buss_id.set(160000001L);
    Object localObject = new HuiyinRedDotProto.RedDotSetReq();
    ((HuiyinRedDotProto.RedDotSetReq)localObject).appid.set(63);
    ((HuiyinRedDotProto.RedDotSetReq)localObject).from_uid.set(this.jdField_a_of_type_Long);
    ((HuiyinRedDotProto.RedDotSetReq)localObject).to_uid.set(this.jdField_a_of_type_Long);
    ((HuiyinRedDotProto.RedDotSetReq)localObject).clear.set(true);
    localiLiveRequest.ex.set(ByteStringMicro.copyFrom(((HuiyinRedDotProto.RedDotSetReq)localObject).toByteArray()));
    localObject = new NewIntent(paramAppInterface.getApplication(), mzx.class);
    ((NewIntent)localObject).putExtra("cmd", this.f + ".0x2791_0x2");
    ((NewIntent)localObject).putExtra("data", localiLiveRequest.toByteArray());
    ((NewIntent)localObject).setObserver(new asye(this));
    paramAppInterface.startServlet((NewIntent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxy
 * JD-Core Version:    0.7.0.1
 */