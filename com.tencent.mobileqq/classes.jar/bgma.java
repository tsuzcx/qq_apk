import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.1;
import com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.2;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bgma
  extends VasWebviewJsPlugin
  implements DialogInterface.OnDismissListener
{
  public static int a;
  static long jdField_a_of_type_Long;
  private static bgme jdField_a_of_type_Bgme;
  static boolean jdField_a_of_type_Boolean;
  static int jdField_b_of_type_Int;
  static boolean jdField_b_of_type_Boolean = true;
  public Activity a;
  private bhht jdField_a_of_type_Bhht;
  String jdField_a_of_type_JavaLangString = null;
  public HashMap<String, Long> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new bgmc(this);
  String jdField_b_of_type_JavaLangString = null;
  public HashMap<String, Long> b;
  int jdField_c_of_type_Int = 0;
  String jdField_c_of_type_JavaLangString;
  public HashMap<String, Long> c;
  int jdField_d_of_type_Int = 0;
  String jdField_d_of_type_JavaLangString = null;
  String e = null;
  String f = null;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  public bgma()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.mPluginNameSpace = "healthkit";
  }
  
  private JSONObject a(String paramString)
  {
    label260:
    do
    {
      do
      {
        try
        {
          localJSONObject = new JSONObject();
          paramString = new JSONObject(paramString);
          str = paramString.getString("callback");
          i = paramString.optInt("x");
          j = paramString.optInt("y");
          k = paramString.optInt("w");
          m = paramString.optInt("h");
          paramString = this.mRuntime.a();
          if (QLog.isColorLevel()) {
            QLog.i("HealthStepCounterPlugin", 2, "webview:" + paramString.getWidth() + "," + paramString.getHeight());
          }
          localObject = Bitmap.createBitmap(paramString.getWidth(), paramString.getHeight(), Bitmap.Config.ARGB_8888);
          paramString.draw(new Canvas((Bitmap)localObject));
          int n = this.mRuntime.a().getWindowManager().getDefaultDisplay().getWidth();
          int i1 = this.mRuntime.a().getWindowManager().getDefaultDisplay().getHeight();
          if ((i >= 0) && (j >= 0) && (k <= n) && (m <= i1)) {
            break label260;
          }
          localJSONObject.put("code", -1);
          localJSONObject.put("image_url", "");
          callJs(str, new String[] { localJSONObject.toString() });
          paramString = localJSONObject;
          if (this.jdField_a_of_type_Bhht != null)
          {
            this.jdField_a_of_type_Bhht.dismiss();
            paramString = localJSONObject;
          }
        }
        catch (Exception paramString)
        {
          JSONObject localJSONObject;
          String str;
          int i;
          int j;
          int k;
          int m;
          Object localObject;
          if (!QLog.isColorLevel()) {
            break label552;
          }
          QLog.e("HealthStepCounterPlugin", 2, "Exception:" + paramString.toString());
          paramString = null;
          return null;
        }
        finally
        {
          if (this.jdField_a_of_type_Bhht == null) {
            break label585;
          }
          this.jdField_a_of_type_Bhht.dismiss();
        }
        return paramString;
        paramString = (String)localObject;
        if (k > 0)
        {
          paramString = (String)localObject;
          if (m > 0) {
            paramString = Bitmap.createBitmap((Bitmap)localObject, i, j, k, m);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.e("HealthStepCounterPlugin", 2, "bitmap size:" + paramString.getByteCount());
        }
        localObject = new File(VFSAssistantUtils.getSDKPrivatePath("cache"));
        ((File)localObject).mkdirs();
        localObject = ((File)localObject).getAbsolutePath();
        localObject = (String)localObject + File.separator + System.currentTimeMillis() + ".png";
        bfvo.a(paramString, new File((String)localObject));
        if (paramString == null) {
          break;
        }
        localJSONObject.put("code", 0);
        localJSONObject.put("image_url", localObject);
        callJs(str, new String[] { localJSONObject.toString() });
        paramString = localJSONObject;
      } while (this.jdField_a_of_type_Bhht == null);
      this.jdField_a_of_type_Bhht.dismiss();
      return localJSONObject;
      localJSONObject.put("code", -2);
      localJSONObject.put("image_url", "");
      callJs(str, new String[] { localJSONObject.toString() });
      paramString = localJSONObject;
    } while (this.jdField_a_of_type_Bhht == null);
    this.jdField_a_of_type_Bhht.dismiss();
    return localJSONObject;
  }
  
  private void a(String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (jdField_a_of_type_Bgme == null)
    {
      localObject1 = new bgme(null);
      localObject2 = (SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor");
      ((SensorManager)localObject2).registerListener((SensorEventListener)localObject1, ((SensorManager)localObject2).getDefaultSensor(1), 0);
      jdField_a_of_type_Bgme = (bgme)localObject1;
      QLog.d("HealthStepCounterPlugin", 1, "register shakelistener");
    }
    try
    {
      this.jdField_d_of_type_JavaLangString = new JSONObject(paramString).getString("callback");
      label71:
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localObject1 = (SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor");
        localObject2 = ((SensorManager)localObject1).getDefaultSensor(19);
        if ((Build.VERSION.SDK_INT >= 19) && (localObject2 != null)) {
          break label180;
        }
        this.e = "Unsupported model found.";
        paramString = new JSONObject();
      }
      try
      {
        paramString.put("retCode", jdField_a_of_type_Int);
        paramString.put("msg", this.e);
        label160:
        callJs(this.jdField_d_of_type_JavaLangString, new String[] { paramString.toString() });
        return;
        label180:
        bgmd localbgmd = new bgmd(this);
        ((SensorManager)localObject1).registerListener(localbgmd, (Sensor)localObject2, 3, 0);
        ((SensorManager)localObject1).flush(localbgmd);
        localObject1 = new NewIntent(this.mRuntime.a().getApplication(), bgmu.class);
        ((NewIntent)localObject1).putExtra("msf_cmd_type", "cmd_refresh_steps");
        ((NewIntent)localObject1).putExtra("json_string", paramString);
        ((NewIntent)localObject1).setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.mRuntime.a().startServlet((NewIntent)localObject1);
        return;
      }
      catch (Exception localException)
      {
        break label160;
      }
    }
    catch (Throwable localThrowable)
    {
      break label71;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    Object localObject1;
    label132:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              localObject1 = new JSONObject(paramString1);
              paramString1 = ((JSONObject)localObject1).getString("callback");
              if (!TextUtils.isEmpty(paramString1))
              {
                if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity)) {
                  break label132;
                }
                paramString2 = new JSONObject();
                paramString2.put("ssoRet", 103);
                paramString2.put("businessRet", 0);
                paramString2.put("msg", "MSF未连接");
                super.callJs(paramString1, new String[] { paramString2.toString() });
                return;
              }
            }
            catch (Exception paramString1) {}
          }
        } while (!QLog.isColorLevel());
        QLog.e("HealthStepCounterPlugin", 2, "Exception:" + paramString1);
        return;
        l1 = 10240L;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey("yundong_report.steps")) {
          l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get("yundong_report.steps")).longValue();
        }
        if ((l1 > 0L) && (((JSONObject)localObject1).toString().getBytes().length > l1))
        {
          paramString2 = new JSONObject();
          paramString2.put("ssoRet", 101);
          paramString2.put("businessRet", 0);
          paramString2.put("msg", amtj.a(2131704577));
          super.callJs(paramString1, new String[] { paramString2.toString() });
          return;
        }
        if (this.jdField_c_of_type_JavaUtilHashMap.containsKey("yundong_report.steps"))
        {
          long l2 = ((Long)this.jdField_c_of_type_JavaUtilHashMap.get("yundong_report.steps")).longValue();
          l1 = 1000L;
          if (this.jdField_b_of_type_JavaUtilHashMap.containsKey("yundong_report.steps")) {
            l1 = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get("yundong_report.steps")).longValue();
          }
          if ((l1 > 0L) && (System.currentTimeMillis() - l2 < l1))
          {
            paramString2 = new JSONObject();
            paramString2.put("ssoRet", 102);
            paramString2.put("businessRet", 0);
            paramString2.put("msg", amtj.a(2131704576));
            super.callJs(paramString1, new String[] { paramString2.toString() });
            this.jdField_c_of_type_JavaUtilHashMap.put("yundong_report.steps", Long.valueOf(System.currentTimeMillis()));
            return;
          }
        }
        this.jdField_c_of_type_JavaUtilHashMap.put("yundong_report.steps", Long.valueOf(System.currentTimeMillis()));
        paramString2 = new JSONObject(paramString2);
        if (!paramString2.getBoolean("isStepCounterEnable"))
        {
          QLog.i("HealthStepCounterPlugin", 1, "web process report step found step counter off!");
          return;
        }
        localObject2 = String.valueOf(bgmm.a());
      } while ((paramString2 == null) || (!paramString2.has((String)localObject2 + "_total")) || (!paramString2.has((String)localObject2 + "_init")) || (!paramString2.has((String)localObject2 + "_offset")));
      int i = paramString2.getInt((String)localObject2 + "_total");
      int j = paramString2.getInt((String)localObject2 + "_init");
      j = paramString2.getInt((String)localObject2 + "_offset") + (i - j);
      paramString2 = bgmm.a();
      i = j;
      if (paramString2[1] != -1)
      {
        i = j;
        if (paramString2[1] > j)
        {
          QLog.e("HealthStepCounterPlugin", 1, "use device step:" + paramString2[1] + " instead of:" + j);
          i = paramString2[1];
        }
      }
      long l1 = NetConnInfoCenter.getServerTime();
      paramString2 = new JSONArray();
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("type", 1);
      ((JSONObject)localObject2).put("time", l1);
      ((JSONObject)localObject2).put("steps", i);
      paramString2.put(localObject2);
      ((JSONObject)localObject1).put("oauth_consumer_key", 1002);
      ((JSONObject)localObject1).put("data", paramString2);
      ((JSONObject)localObject1).put("version", "8.4.8");
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = URLEncoder.encode(Build.MODEL, "utf-8");
      }
      ((JSONObject)localObject1).put("model", this.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        paramString2 = TimeZone.getDefault();
        this.jdField_c_of_type_JavaLangString = (paramString2.getDisplayName(false, 0) + " " + paramString2.getID());
      }
      ((JSONObject)localObject1).put("zone", String.valueOf(this.jdField_c_of_type_JavaLangString));
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = biaq.c();
      }
      ((JSONObject)localObject1).put("imei", String.valueOf(this.jdField_b_of_type_JavaLangString));
      ((JSONObject)localObject1).put("adcode", LbsManagerService.getCityCode());
      if (QLog.isColorLevel()) {
        QLog.i("HealthStepCounterPlugin", 2, "parameters:" + ((JSONObject)localObject1).toString());
      }
      localObject2 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.4.8");
      paramString2 = new WebSSOAgent.UniSsoServerReq();
      paramString2.comm.set((MessageMicro)localObject2);
      paramString2.reqdata.set(((JSONObject)localObject1).toString());
      localObject1 = new bgmb(this);
    } while (this.mRuntime == null);
    Object localObject2 = new NewIntent(this.mRuntime.a().getApplicationContext(), auwo.class);
    ((NewIntent)localObject2).putExtra("extra_cmd", "yundong_report.steps");
    ((NewIntent)localObject2).putExtra("extra_data", paramString2.toByteArray());
    ((NewIntent)localObject2).putExtra("extra_callbackid", paramString1);
    ((NewIntent)localObject2).setObserver((BusinessObserver)localObject1);
    this.mRuntime.a().startServlet((NewIntent)localObject2);
  }
  
  /* Error */
  private JSONObject b(String paramString)
  {
    // Byte code:
    //   0: new 83	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 84	org/json/JSONObject:<init>	()V
    //   7: astore 9
    //   9: invokestatic 255	java/lang/System:currentTimeMillis	()J
    //   12: lstore_3
    //   13: aload_0
    //   14: getfield 109	bgma:mRuntime	Lbgve;
    //   17: ifnull +1113 -> 1130
    //   20: aload_0
    //   21: getfield 283	bgma:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   24: ifnull +1106 -> 1130
    //   27: iconst_0
    //   28: istore 5
    //   30: new 83	org/json/JSONObject
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 87	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_1
    //   40: ldc 89
    //   42: invokevirtual 93	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 10
    //   47: aload 10
    //   49: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +6 -> 58
    //   55: aload 9
    //   57: areturn
    //   58: aload_1
    //   59: ldc_w 606
    //   62: invokevirtual 447	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   65: istore_2
    //   66: aload_1
    //   67: ldc 201
    //   69: invokevirtual 93	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 11
    //   74: new 608	android/graphics/BitmapFactory$Options
    //   77: dup
    //   78: invokespecial 609	android/graphics/BitmapFactory$Options:<init>	()V
    //   81: astore_1
    //   82: aload_1
    //   83: iconst_1
    //   84: putfield 612	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   87: aload 11
    //   89: aload_1
    //   90: invokestatic 618	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   93: astore 8
    //   95: aload_1
    //   96: iconst_0
    //   97: putfield 612	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   100: aload 11
    //   102: aload_1
    //   103: invokestatic 618	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   106: astore_1
    //   107: aload_1
    //   108: astore 8
    //   110: new 232	java/io/File
    //   113: dup
    //   114: aload 11
    //   116: invokespecial 240	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: astore_1
    //   120: aload_1
    //   121: ifnull +126 -> 247
    //   124: new 620	java/io/FileOutputStream
    //   127: dup
    //   128: aload_1
    //   129: invokespecial 623	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   132: astore 7
    //   134: aload 7
    //   136: astore_1
    //   137: aload 8
    //   139: getstatic 629	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   142: bipush 80
    //   144: aload 7
    //   146: invokevirtual 633	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   149: istore 6
    //   151: aload 7
    //   153: astore_1
    //   154: aload_0
    //   155: getfield 215	bgma:jdField_a_of_type_Bhht	Lbhht;
    //   158: ifnull +975 -> 1133
    //   161: aload 7
    //   163: astore_1
    //   164: aload_0
    //   165: getfield 215	bgma:jdField_a_of_type_Bhht	Lbhht;
    //   168: invokevirtual 636	bhht:isShowing	()Z
    //   171: ifeq +962 -> 1133
    //   174: aload 7
    //   176: astore_1
    //   177: aload_0
    //   178: getfield 215	bgma:jdField_a_of_type_Bhht	Lbhht;
    //   181: invokevirtual 220	bhht:dismiss	()V
    //   184: goto +949 -> 1133
    //   187: aload 7
    //   189: astore_1
    //   190: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +36 -> 229
    //   196: aload 7
    //   198: astore_1
    //   199: ldc 122
    //   201: iconst_2
    //   202: new 124	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 638
    //   212: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokestatic 255	java/lang/System:currentTimeMillis	()J
    //   218: lload_3
    //   219: lsub
    //   220: invokevirtual 258	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: iload 6
    //   231: istore 5
    //   233: aload 7
    //   235: ifnull +12 -> 247
    //   238: aload 7
    //   240: invokevirtual 641	java/io/FileOutputStream:close	()V
    //   243: iload 6
    //   245: istore 5
    //   247: new 83	org/json/JSONObject
    //   250: dup
    //   251: invokespecial 84	org/json/JSONObject:<init>	()V
    //   254: astore_1
    //   255: iload 5
    //   257: ifeq +795 -> 1052
    //   260: aload_1
    //   261: ldc_w 643
    //   264: iconst_0
    //   265: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload_1
    //   270: ldc_w 323
    //   273: ldc_w 644
    //   276: invokestatic 410	amtj:a	(I)Ljava/lang/String;
    //   279: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   282: pop
    //   283: aload_1
    //   284: ldc_w 646
    //   287: aload 11
    //   289: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   292: pop
    //   293: aload 9
    //   295: ldc 195
    //   297: iconst_0
    //   298: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   301: pop
    //   302: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq +12 -> 317
    //   308: ldc 122
    //   310: iconst_2
    //   311: ldc_w 648
    //   314: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: aload_0
    //   318: aload 10
    //   320: iconst_1
    //   321: anewarray 208	java/lang/String
    //   324: dup
    //   325: iconst_0
    //   326: aload 9
    //   328: invokevirtual 209	org/json/JSONObject:toString	()Ljava/lang/String;
    //   331: aastore
    //   332: invokevirtual 213	bgma:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   335: aload 9
    //   337: areturn
    //   338: astore_1
    //   339: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq +788 -> 1130
    //   345: ldc 122
    //   347: iconst_2
    //   348: new 124	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   355: ldc_w 267
    //   358: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload_1
    //   362: invokevirtual 268	java/lang/Exception:toString	()Ljava/lang/String;
    //   365: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: aload 9
    //   376: areturn
    //   377: astore_1
    //   378: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   381: ifeq +32 -> 413
    //   384: ldc 122
    //   386: iconst_2
    //   387: new 124	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   394: ldc_w 267
    //   397: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_1
    //   401: invokevirtual 649	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   404: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   413: goto -303 -> 110
    //   416: aload 7
    //   418: astore_1
    //   419: new 651	android/os/Bundle
    //   422: dup
    //   423: invokespecial 652	android/os/Bundle:<init>	()V
    //   426: astore 8
    //   428: aload 7
    //   430: astore_1
    //   431: aload 8
    //   433: ldc_w 654
    //   436: iconst_1
    //   437: invokevirtual 658	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   440: aload 7
    //   442: astore_1
    //   443: aload 8
    //   445: ldc_w 660
    //   448: aload 11
    //   450: invokevirtual 663	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   453: aload 7
    //   455: astore_1
    //   456: aload 8
    //   458: ldc_w 665
    //   461: aload 11
    //   463: invokevirtual 663	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: aload 7
    //   468: astore_1
    //   469: aload 8
    //   471: ldc_w 667
    //   474: aload 11
    //   476: invokevirtual 663	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: aload 7
    //   481: astore_1
    //   482: aload 8
    //   484: ldc_w 669
    //   487: aload 11
    //   489: invokevirtual 663	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: aload 7
    //   494: astore_1
    //   495: aload 8
    //   497: ldc_w 671
    //   500: iconst_1
    //   501: invokevirtual 675	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   504: aload 7
    //   506: astore_1
    //   507: new 677	android/content/Intent
    //   510: dup
    //   511: invokespecial 678	android/content/Intent:<init>	()V
    //   514: astore 12
    //   516: aload 7
    //   518: astore_1
    //   519: aload 12
    //   521: aload 8
    //   523: invokevirtual 682	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   526: pop
    //   527: aload 7
    //   529: astore_1
    //   530: aload_0
    //   531: getfield 283	bgma:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   534: aload 12
    //   536: bipush 21
    //   538: invokestatic 687	atky:a	(Landroid/app/Activity;Landroid/content/Intent;I)V
    //   541: goto -354 -> 187
    //   544: astore 8
    //   546: aload 7
    //   548: astore_1
    //   549: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   552: ifeq +36 -> 588
    //   555: aload 7
    //   557: astore_1
    //   558: ldc 122
    //   560: iconst_2
    //   561: new 124	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   568: ldc_w 267
    //   571: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload 8
    //   576: invokevirtual 688	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   579: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   588: iconst_0
    //   589: istore 6
    //   591: iload 6
    //   593: istore 5
    //   595: aload 7
    //   597: ifnull -350 -> 247
    //   600: aload 7
    //   602: invokevirtual 641	java/io/FileOutputStream:close	()V
    //   605: iload 6
    //   607: istore 5
    //   609: goto -362 -> 247
    //   612: astore_1
    //   613: iload 6
    //   615: istore 5
    //   617: goto -370 -> 247
    //   620: aload 7
    //   622: astore_1
    //   623: new 651	android/os/Bundle
    //   626: dup
    //   627: invokespecial 652	android/os/Bundle:<init>	()V
    //   630: astore 8
    //   632: aload 7
    //   634: astore_1
    //   635: new 690	java/util/ArrayList
    //   638: dup
    //   639: invokespecial 691	java/util/ArrayList:<init>	()V
    //   642: astore 12
    //   644: aload 7
    //   646: astore_1
    //   647: aload 12
    //   649: aload 11
    //   651: invokestatic 696	java/net/URLDecoder:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   654: invokevirtual 699	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   657: pop
    //   658: aload 7
    //   660: astore_1
    //   661: aload 8
    //   663: ldc_w 701
    //   666: aload 12
    //   668: invokevirtual 705	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   671: aload 7
    //   673: astore_1
    //   674: aload 8
    //   676: ldc_w 707
    //   679: ldc_w 708
    //   682: invokestatic 410	amtj:a	(I)Ljava/lang/String;
    //   685: invokevirtual 663	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   688: aload 7
    //   690: astore_1
    //   691: aload 8
    //   693: ldc_w 710
    //   696: bipush 7
    //   698: invokevirtual 658	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   701: aload 7
    //   703: astore_1
    //   704: aload 8
    //   706: ldc_w 712
    //   709: iconst_0
    //   710: invokevirtual 675	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   713: aload 7
    //   715: astore_1
    //   716: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   719: ifeq +33 -> 752
    //   722: aload 7
    //   724: astore_1
    //   725: ldc 122
    //   727: iconst_2
    //   728: new 124	java/lang/StringBuilder
    //   731: dup
    //   732: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   735: ldc_w 714
    //   738: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: aload 8
    //   743: invokevirtual 383	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   746: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: invokestatic 303	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   752: aload 7
    //   754: astore_1
    //   755: aload_0
    //   756: getfield 109	bgma:mRuntime	Lbgve;
    //   759: invokevirtual 338	bgve:a	()Lcom/tencent/common/app/AppInterface;
    //   762: aload_0
    //   763: getfield 109	bgma:mRuntime	Lbgve;
    //   766: invokevirtual 177	bgve:a	()Landroid/app/Activity;
    //   769: aload 8
    //   771: aload_0
    //   772: invokestatic 720	cooperation/qzone/QZoneShareManager:publishToQzone	(Lcom/tencent/common/app/AppInterface;Landroid/content/Context;Landroid/os/Bundle;Landroid/content/DialogInterface$OnDismissListener;)V
    //   775: goto -588 -> 187
    //   778: astore 8
    //   780: aload_1
    //   781: astore 7
    //   783: aload 8
    //   785: astore_1
    //   786: aload 7
    //   788: ifnull +8 -> 796
    //   791: aload 7
    //   793: invokevirtual 641	java/io/FileOutputStream:close	()V
    //   796: aload_1
    //   797: athrow
    //   798: aload 7
    //   800: astore_1
    //   801: invokestatic 726	com/tencent/mobileqq/wxapi/WXShareHelper:getInstance	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   804: invokevirtual 729	com/tencent/mobileqq/wxapi/WXShareHelper:isWXinstalled	()Z
    //   807: ifeq +20 -> 827
    //   810: aload 7
    //   812: astore_1
    //   813: invokestatic 726	com/tencent/mobileqq/wxapi/WXShareHelper:getInstance	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   816: aload 11
    //   818: aload 8
    //   820: iconst_1
    //   821: invokevirtual 733	com/tencent/mobileqq/wxapi/WXShareHelper:shareImageToWX	(Ljava/lang/String;Landroid/graphics/Bitmap;I)V
    //   824: goto -637 -> 187
    //   827: aload 7
    //   829: astore_1
    //   830: aload_0
    //   831: getfield 109	bgma:mRuntime	Lbgve;
    //   834: invokevirtual 114	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   837: new 735	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$4
    //   840: dup
    //   841: aload_0
    //   842: invokespecial 736	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$4:<init>	(Lbgma;)V
    //   845: invokevirtual 740	com/tencent/biz/pubaccount/CustomWebView:post	(Ljava/lang/Runnable;)Z
    //   848: pop
    //   849: goto -662 -> 187
    //   852: aload 7
    //   854: astore_1
    //   855: invokestatic 726	com/tencent/mobileqq/wxapi/WXShareHelper:getInstance	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   858: invokevirtual 729	com/tencent/mobileqq/wxapi/WXShareHelper:isWXinstalled	()Z
    //   861: ifeq +20 -> 881
    //   864: aload 7
    //   866: astore_1
    //   867: invokestatic 726	com/tencent/mobileqq/wxapi/WXShareHelper:getInstance	()Lcom/tencent/mobileqq/wxapi/WXShareHelper;
    //   870: aload 11
    //   872: aload 8
    //   874: iconst_0
    //   875: invokevirtual 733	com/tencent/mobileqq/wxapi/WXShareHelper:shareImageToWX	(Ljava/lang/String;Landroid/graphics/Bitmap;I)V
    //   878: goto -691 -> 187
    //   881: aload 7
    //   883: astore_1
    //   884: aload_0
    //   885: getfield 109	bgma:mRuntime	Lbgve;
    //   888: invokevirtual 114	bgve:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   891: new 742	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$5
    //   894: dup
    //   895: aload_0
    //   896: invokespecial 743	com/tencent/mobileqq/vashealth/HealthStepCounterPlugin$5:<init>	(Lbgma;)V
    //   899: invokevirtual 740	com/tencent/biz/pubaccount/CustomWebView:post	(Ljava/lang/Runnable;)Z
    //   902: pop
    //   903: goto -716 -> 187
    //   906: aload 7
    //   908: astore_1
    //   909: new 232	java/io/File
    //   912: dup
    //   913: new 124	java/lang/StringBuilder
    //   916: dup
    //   917: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   920: getstatic 748	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   923: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: getstatic 249	java/io/File:separator	Ljava/lang/String;
    //   929: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: invokestatic 255	java/lang/System:currentTimeMillis	()J
    //   935: invokevirtual 258	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   938: ldc_w 260
    //   941: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   947: invokespecial 240	java/io/File:<init>	(Ljava/lang/String;)V
    //   950: astore 12
    //   952: aload 7
    //   954: astore_1
    //   955: aload 8
    //   957: aload 12
    //   959: invokestatic 265	bfvo:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   962: aload 7
    //   964: astore_1
    //   965: new 677	android/content/Intent
    //   968: dup
    //   969: ldc_w 750
    //   972: invokespecial 751	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   975: astore 8
    //   977: aload 7
    //   979: astore_1
    //   980: aload 8
    //   982: aload 12
    //   984: invokestatic 757	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   987: invokevirtual 761	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   990: pop
    //   991: aload 7
    //   993: astore_1
    //   994: aload_0
    //   995: getfield 109	bgma:mRuntime	Lbgve;
    //   998: invokevirtual 177	bgve:a	()Landroid/app/Activity;
    //   1001: invokevirtual 582	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   1004: aload 8
    //   1006: invokevirtual 767	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   1009: aload 7
    //   1011: astore_1
    //   1012: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1015: ifeq -828 -> 187
    //   1018: aload 7
    //   1020: astore_1
    //   1021: ldc 122
    //   1023: iconst_2
    //   1024: new 124	java/lang/StringBuilder
    //   1027: dup
    //   1028: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   1031: ldc_w 769
    //   1034: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: getstatic 748	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_SAVE	Ljava/lang/String;
    //   1040: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1046: invokestatic 303	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1049: goto -862 -> 187
    //   1052: aload_1
    //   1053: ldc_w 643
    //   1056: iconst_m1
    //   1057: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1060: pop
    //   1061: aload_1
    //   1062: ldc_w 323
    //   1065: ldc_w 770
    //   1068: invokestatic 410	amtj:a	(I)Ljava/lang/String;
    //   1071: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1074: pop
    //   1075: aload 9
    //   1077: ldc 195
    //   1079: iconst_m1
    //   1080: invokevirtual 199	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1083: pop
    //   1084: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1087: ifeq -770 -> 317
    //   1090: ldc 122
    //   1092: iconst_2
    //   1093: ldc_w 772
    //   1096: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1099: goto -782 -> 317
    //   1102: astore_1
    //   1103: iload 6
    //   1105: istore 5
    //   1107: goto -860 -> 247
    //   1110: astore 7
    //   1112: goto -316 -> 796
    //   1115: astore_1
    //   1116: aconst_null
    //   1117: astore 7
    //   1119: goto -333 -> 786
    //   1122: astore 8
    //   1124: aconst_null
    //   1125: astore 7
    //   1127: goto -581 -> 546
    //   1130: aload 9
    //   1132: areturn
    //   1133: iload_2
    //   1134: tableswitch	default:+34 -> 1168, 1:+-718->416, 2:+-514->620, 3:+-282->852, 4:+-336->798, 5:+-228->906
    //   1169: <illegal opcode>
    //   1170: aload_1
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1171	0	this	bgma
    //   0	1171	1	paramString	String
    //   65	1069	2	i	int
    //   12	207	3	l	long
    //   28	1078	5	j	int
    //   149	955	6	bool	boolean
    //   132	887	7	localObject1	Object
    //   1110	1	7	localIOException	java.io.IOException
    //   1117	9	7	localObject2	Object
    //   93	429	8	localObject3	Object
    //   544	31	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   630	140	8	localBundle	android.os.Bundle
    //   778	178	8	localBitmap	Bitmap
    //   975	30	8	localIntent	Intent
    //   1122	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   7	1124	9	localJSONObject	JSONObject
    //   45	274	10	str1	String
    //   72	799	11	str2	String
    //   514	469	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   30	55	338	java/lang/Exception
    //   58	100	338	java/lang/Exception
    //   100	107	338	java/lang/Exception
    //   110	120	338	java/lang/Exception
    //   238	243	338	java/lang/Exception
    //   247	255	338	java/lang/Exception
    //   260	317	338	java/lang/Exception
    //   317	335	338	java/lang/Exception
    //   378	413	338	java/lang/Exception
    //   600	605	338	java/lang/Exception
    //   791	796	338	java/lang/Exception
    //   796	798	338	java/lang/Exception
    //   1052	1099	338	java/lang/Exception
    //   100	107	377	java/lang/OutOfMemoryError
    //   137	151	544	java/io/FileNotFoundException
    //   154	161	544	java/io/FileNotFoundException
    //   164	174	544	java/io/FileNotFoundException
    //   177	184	544	java/io/FileNotFoundException
    //   190	196	544	java/io/FileNotFoundException
    //   199	229	544	java/io/FileNotFoundException
    //   419	428	544	java/io/FileNotFoundException
    //   431	440	544	java/io/FileNotFoundException
    //   443	453	544	java/io/FileNotFoundException
    //   456	466	544	java/io/FileNotFoundException
    //   469	479	544	java/io/FileNotFoundException
    //   482	492	544	java/io/FileNotFoundException
    //   495	504	544	java/io/FileNotFoundException
    //   507	516	544	java/io/FileNotFoundException
    //   519	527	544	java/io/FileNotFoundException
    //   530	541	544	java/io/FileNotFoundException
    //   623	632	544	java/io/FileNotFoundException
    //   635	644	544	java/io/FileNotFoundException
    //   647	658	544	java/io/FileNotFoundException
    //   661	671	544	java/io/FileNotFoundException
    //   674	688	544	java/io/FileNotFoundException
    //   691	701	544	java/io/FileNotFoundException
    //   704	713	544	java/io/FileNotFoundException
    //   716	722	544	java/io/FileNotFoundException
    //   725	752	544	java/io/FileNotFoundException
    //   755	775	544	java/io/FileNotFoundException
    //   801	810	544	java/io/FileNotFoundException
    //   813	824	544	java/io/FileNotFoundException
    //   830	849	544	java/io/FileNotFoundException
    //   855	864	544	java/io/FileNotFoundException
    //   867	878	544	java/io/FileNotFoundException
    //   884	903	544	java/io/FileNotFoundException
    //   909	952	544	java/io/FileNotFoundException
    //   955	962	544	java/io/FileNotFoundException
    //   965	977	544	java/io/FileNotFoundException
    //   980	991	544	java/io/FileNotFoundException
    //   994	1009	544	java/io/FileNotFoundException
    //   1012	1018	544	java/io/FileNotFoundException
    //   1021	1049	544	java/io/FileNotFoundException
    //   600	605	612	java/io/IOException
    //   137	151	778	finally
    //   154	161	778	finally
    //   164	174	778	finally
    //   177	184	778	finally
    //   190	196	778	finally
    //   199	229	778	finally
    //   419	428	778	finally
    //   431	440	778	finally
    //   443	453	778	finally
    //   456	466	778	finally
    //   469	479	778	finally
    //   482	492	778	finally
    //   495	504	778	finally
    //   507	516	778	finally
    //   519	527	778	finally
    //   530	541	778	finally
    //   549	555	778	finally
    //   558	588	778	finally
    //   623	632	778	finally
    //   635	644	778	finally
    //   647	658	778	finally
    //   661	671	778	finally
    //   674	688	778	finally
    //   691	701	778	finally
    //   704	713	778	finally
    //   716	722	778	finally
    //   725	752	778	finally
    //   755	775	778	finally
    //   801	810	778	finally
    //   813	824	778	finally
    //   830	849	778	finally
    //   855	864	778	finally
    //   867	878	778	finally
    //   884	903	778	finally
    //   909	952	778	finally
    //   955	962	778	finally
    //   965	977	778	finally
    //   980	991	778	finally
    //   994	1009	778	finally
    //   1012	1018	778	finally
    //   1021	1049	778	finally
    //   238	243	1102	java/io/IOException
    //   791	796	1110	java/io/IOException
    //   124	134	1115	finally
    //   124	134	1122	java/io/FileNotFoundException
  }
  
  private void b(String paramString)
  {
    try
    {
      IX5WebViewExtension localIX5WebViewExtension = this.mRuntime.a().getX5WebViewExtension();
      if (localIX5WebViewExtension == null) {
        return;
      }
      paramString = new JSONObject(paramString).optString("serviceWorkerURL");
      paramString = paramString.substring(1, paramString.length() - 1).split(",");
      int i = 0;
      while (i < paramString.length)
      {
        Object localObject = paramString[i];
        localIX5WebViewExtension.updateServiceWorkerBackground(paramString[i]);
        i += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private JSONObject c(String paramString)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences(this.mRuntime.a().getCurrentAccountUin() + ".qqsport", 4).getInt("STEP_RED_PACK_STATUS", 0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramString = new JSONObject(paramString).getString("callback");
      localJSONObject.put("status", i);
      QLog.i("HealthStepCounterPlugin", 1, "getStepRedPackStatus:" + localJSONObject.toString());
      callJs(paramString, new String[] { localJSONObject.toString() });
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localJSONObject;
  }
  
  private JSONObject d(String paramString)
  {
    int i = 0;
    SharedPreferences.Editor localEditor = this.mRuntime.a().getApplication().getSharedPreferences(this.mRuntime.a().getCurrentAccountUin() + ".qqsport", 4).edit();
    localJSONObject = new JSONObject();
    try
    {
      paramString = new JSONObject(paramString);
      localEditor.putInt("STEP_RED_PACK_STATUS", paramString.optInt("status"));
      boolean bool = localEditor.commit();
      paramString = paramString.getString("callback");
      if (bool == true) {}
      for (;;)
      {
        localJSONObject.put("status", i);
        QLog.i("HealthStepCounterPlugin", 1, "setStepRedPackStatus:" + localJSONObject.toString());
        callJs(paramString, new String[] { localJSONObject.toString() });
        return localJSONObject;
        i = -1;
      }
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramJsBridgeListener = null;
    Object localObject1 = null;
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.i("HealthStepCounterPlugin", 2, "handleJsRequest!!");
    }
    if ((paramString1 == null) || (!"healthkit".equals(paramString2)) || (paramString3 == null)) {
      return false;
    }
    try
    {
      if (!paramString3.equals("readHKData")) {
        break label278;
      }
      if (paramVarArgs.length <= 0) {
        break label276;
      }
      paramJsBridgeListener = (SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor");
      if ((Build.VERSION.SDK_INT < 19) || (paramJsBridgeListener.getDefaultSensor(19) == null))
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
        if (TextUtils.isEmpty(paramJsBridgeListener)) {
          return false;
        }
        paramString1 = new JSONObject();
        paramString1.put("ssoRet", 255);
        paramString1.put("businessRet", 0);
        paramString1.put("msg", amtj.a(2131704582));
        super.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
      }
      else
      {
        paramJsBridgeListener = new NewIntent(this.mRuntime.a().getApplication(), bgmu.class);
        paramJsBridgeListener.putExtra("msf_cmd_type", "cmd_refresh_steps");
        paramJsBridgeListener.putExtra("json_string", paramVarArgs[0]);
        paramJsBridgeListener.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.mRuntime.a().startServlet(paramJsBridgeListener);
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      QLog.d("HealthStepCounterPlugin", 2, "Err:" + paramJsBridgeListener.toString());
    }
    return false;
    label276:
    return true;
    label278:
    int i;
    if (paramString3.equals("healthSwitch"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("HealthStepCounterPlugin", 2, "healthSwitch:" + paramVarArgs[0]);
      }
      paramJsBridgeListener = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.health_ban.name(), "");
      if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (Integer.parseInt(paramJsBridgeListener) == 0))
      {
        paramJsBridgeListener = new JSONObject();
        paramString1 = new JSONObject(paramVarArgs[0]).getString("callback");
        paramJsBridgeListener.put("businessRet", 202);
        paramJsBridgeListener.put("msg", amtj.a(2131704578));
        super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
        return true;
      }
      paramJsBridgeListener = new JSONObject();
      paramString2 = new JSONObject(paramVarArgs[0]);
      paramString1 = paramString2.getString("callback");
      boolean bool = paramString2.getBoolean("isOpen");
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        break label1161;
      }
      paramString2 = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, bgmu.class);
      paramString2.putExtra("msf_cmd_type", "cmd_health_switch");
      paramString2.putExtra("isOpen", bool);
      this.mRuntime.a().startServlet(paramString2);
      paramJsBridgeListener.put("businessRet", 0);
      paramJsBridgeListener.put("msg", amtj.a(2131704579));
      super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramJsBridgeListener.put("businessRet", 201);
        paramJsBridgeListener.put("msg", amtj.a(2131704585));
        super.callJs(paramString1, new String[] { paramJsBridgeListener.toString() });
        break label1169;
        if (paramString3.equals("shareSnapshot"))
        {
          if (this.jdField_a_of_type_Bhht == null)
          {
            paramJsBridgeListener = localObject2;
            if (this.mRuntime.a() != null) {
              paramJsBridgeListener = this.mRuntime.a().getShare().a();
            }
            this.jdField_a_of_type_Bhht = paramJsBridgeListener;
          }
          if (this.jdField_a_of_type_Bhht != null)
          {
            this.jdField_a_of_type_Bhht.c(2131693585);
            this.jdField_a_of_type_Bhht.setCancelable(false);
            this.jdField_a_of_type_Bhht.show();
          }
          ThreadManager.post(new HealthStepCounterPlugin.1(this, paramVarArgs[0]), 5, null, true);
          return true;
        }
        if (paramString3.equals("snapshot"))
        {
          paramString1 = paramVarArgs[0];
          if (this.jdField_a_of_type_Bhht == null)
          {
            if (this.mRuntime.a() != null) {
              paramJsBridgeListener = this.mRuntime.a().getShare().a();
            }
            this.jdField_a_of_type_Bhht = paramJsBridgeListener;
          }
          if (this.jdField_a_of_type_Bhht != null)
          {
            this.jdField_a_of_type_Bhht.c(2131693585);
            this.jdField_a_of_type_Bhht.setCancelable(false);
            this.jdField_a_of_type_Bhht.show();
          }
          ThreadManager.post(new HealthStepCounterPlugin.2(this, paramString1), 5, null, true);
          return true;
        }
        if (paramString3.equals("TestReport"))
        {
          a(paramVarArgs[0]);
          break;
        }
        if (paramString3.equals("getCurrentStep"))
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("callback");
          paramString1 = new NewIntent(this.mRuntime.a().getApplication(), bgmu.class);
          paramString1.putExtra("msf_cmd_type", "cmd_refresh_steps");
          paramString1.putExtra("json_string", paramVarArgs[0]);
          paramString1.putExtra("json_getstepcallback", paramJsBridgeListener);
          paramString1.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
          this.mRuntime.a().startServlet(paramString1);
          break;
        }
        if ("jumpToSetting".equals(paramString3))
        {
          paramString2 = new JSONObject();
          paramJsBridgeListener = localObject1;
          try
          {
            paramString3 = this.mRuntime.a();
            paramJsBridgeListener = localObject1;
            paramString1 = new JSONObject(paramVarArgs[0]).getString("callback");
            paramJsBridgeListener = paramString1;
            paramVarArgs = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            paramJsBridgeListener = paramString1;
            paramVarArgs.setData(Uri.parse("package:" + paramString3.getPackageName()));
            paramJsBridgeListener = paramString1;
            paramString3.startActivity(paramVarArgs);
            paramJsBridgeListener = paramString1;
            paramString2.put("ret", 0);
            paramJsBridgeListener = paramString1;
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              try
              {
                paramString2.put("ret", -1);
              }
              catch (JSONException paramString1) {}
            }
          }
          if (TextUtils.isEmpty(paramJsBridgeListener)) {
            break;
          }
          callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          break;
        }
        if (paramString3.equals("getStepRedPackStatus"))
        {
          c(paramVarArgs[0]);
          return true;
        }
        if (paramString3.equals("setStepRedPackStatus"))
        {
          d(paramVarArgs[0]);
          return true;
        }
        if (!paramString3.equals("updateServiceWorkerBackground")) {
          break;
        }
        b(paramVarArgs[0]);
        break;
        label1161:
        i = 0;
        continue;
        return true;
      }
    }
    label1169:
    return true;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (jdField_a_of_type_Bgme != null)
    {
      ((SensorManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("sensor")).unregisterListener(jdField_a_of_type_Bgme);
      jdField_a_of_type_Bgme = null;
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgma
 * JD-Core Version:    0.7.0.1
 */