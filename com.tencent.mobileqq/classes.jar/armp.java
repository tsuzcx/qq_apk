import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.mobileqq.activity.QQIdentiferLegacyActivity;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPluginProxyActivity;
import cooperation.troop.TroopBaseProxyActivity;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class armp
  extends WebViewPlugin
{
  public static final String a;
  public static final String b;
  public static final String c;
  private static final String d;
  private static final String e = ajyc.a(2131705701);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int b;
  private int c;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajyc.a(2131705697);
    jdField_b_of_type_JavaLangString = ajyc.a(2131705696);
    d = ajyc.a(2131705702);
    jdField_c_of_type_JavaLangString = ajyc.a(2131705705);
  }
  
  public armp()
  {
    this.mPluginNameSpace = "identification";
  }
  
  private Activity a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void a()
  {
    if ("loginVerify".equals(this.k))
    {
      b();
      arch.a(this.jdField_a_of_type_AndroidAppActivity, this.g, this.k, this.m, this.jdField_a_of_type_Long, new armq(this));
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQIdentiferLegacyActivity.class);
    localIntent.putExtra("platformAppId", this.jdField_a_of_type_Int);
    localIntent.putExtra("srcAppId", this.jdField_b_of_type_Int);
    localIntent.putExtra("srcOpenId", this.f);
    localIntent.putExtra("key", this.g);
    localIntent.putExtra("method", this.k);
    if ("identify".equals(this.k))
    {
      localIntent.putExtra("idNum", this.h);
      localIntent.putExtra("name", this.i);
    }
    if ("loginVerify".equals(this.k))
    {
      localIntent.putExtra("uin", this.m);
      localIntent.putExtra("nonce", this.jdField_a_of_type_Long);
    }
    localIntent.putExtra("serviceType", this.jdField_c_of_type_Int);
    startActivityForResult(localIntent, (byte)2);
  }
  
  private void a(Intent paramIntent)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQIdentiferActivity.class);
    localIntent.putExtra("platformAppId", this.jdField_a_of_type_Int);
    localIntent.putExtra("srcAppId", this.jdField_b_of_type_Int);
    localIntent.putExtra("srcOpenId", this.f);
    localIntent.putExtra("key", this.g);
    localIntent.putExtra("method", this.k);
    if ("identify".equals(this.k))
    {
      localIntent.putExtra("idNum", this.h);
      localIntent.putExtra("name", this.i);
    }
    if ("loginVerify".equals(this.k))
    {
      localIntent.putExtra("uin", this.m);
      localIntent.putExtra("ticket", this.l);
    }
    localIntent.putExtra("serviceType", this.jdField_c_of_type_Int);
    if ((paramIntent != null) && (paramIntent.getSerializableExtra("FaceRecognition.AppConf") != null))
    {
      paramIntent = (FaceDetectForThirdPartyManager.AppConf)paramIntent.getSerializableExtra("FaceRecognition.AppConf");
      localIntent.putExtra("FaceRecognition.AppConf", paramIntent);
      localIntent.putExtra("key_identification_type", paramIntent.mode);
    }
    startActivityForResult(localIntent, (byte)1);
  }
  
  private void a(Intent paramIntent, int paramInt)
  {
    JSONObject localJSONObject;
    Object localObject2;
    Object localObject1;
    if (!TextUtils.isEmpty(this.j))
    {
      localJSONObject = new JSONObject();
      localObject2 = "";
      localObject1 = localObject2;
      if (paramIntent != null)
      {
        localObject1 = localObject2;
        if (paramIntent.hasExtra("allResults"))
        {
          localObject2 = paramIntent.getStringExtra("allResults");
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (((String)localObject2).endsWith("|")) {
              localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
            }
          }
        }
      }
    }
    else
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("identificationPlugin invokeCallback intent=");
          if (paramIntent == null)
          {
            localObject2 = "true";
            localObject2 = localStringBuilder.append((String)localObject2);
            if ((paramIntent != null) && (paramIntent.hasExtra("data"))) {
              ((StringBuilder)localObject2).append(" has_key_data=").append("true");
            }
            ((StringBuilder)localObject2).append(" resultCode=").append(paramInt);
            QLog.d("IdentificationApiPlugin", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          if (paramIntent == null) {
            break label416;
          }
        }
        try
        {
          if (paramIntent.hasExtra("data"))
          {
            paramIntent = paramIntent.getBundleExtra("data");
            paramInt = paramIntent.getInt("ret", 299);
            localJSONObject.put("ret", paramInt);
            localJSONObject.put("errMsg", paramIntent.getString("errMsg", ajyc.a(2131705704)));
            localJSONObject.put("idKey", paramIntent.getString("idKey"));
            localJSONObject.put("allResults", localObject1);
          }
          for (;;)
          {
            axqw.b(null, "dc00898", "", "", "0X8009862", "0X8009862", 0, 0, this.jdField_c_of_type_Int + "", "", this.jdField_b_of_type_Int + "", paramInt + "");
            if (QLog.isColorLevel()) {
              QLog.d("IdentificationApiPlugin", 2, "native invoke web ret:" + paramInt + " all_results:" + (String)localObject1);
            }
            callJs(this.j, new String[] { localJSONObject.toString() });
            return;
            localObject2 = "false";
            break;
            label416:
            if (paramInt == 0)
            {
              localJSONObject.put("ret", 201);
              localJSONObject.put("errMsg", jdField_c_of_type_JavaLangString);
              localJSONObject.put("allResults", localObject1);
              paramInt = 201;
            }
            else
            {
              localJSONObject.put("ret", 299);
              localJSONObject.put("errMsg", ajyc.a(2131705703));
              localJSONObject.put("allResults", localObject1);
              paramInt = 299;
            }
          }
        }
        catch (JSONException paramIntent)
        {
          QLog.e("IdentificationApiPlugin", 1, paramIntent, new Object[0]);
          return;
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_a_of_type_Int = paramString.optInt("platformAppId", 0);
        this.jdField_a_of_type_Long = paramString.optLong("nonce");
        this.jdField_b_of_type_Int = paramString.optInt("srcAppId", 0);
        this.f = paramString.optString("srcOpenId", "");
        this.g = paramString.optString("key", "");
        this.h = paramString.optString("idNum", "");
        this.i = paramString.optString("name", "");
        this.j = paramString.optString("callback", "");
        this.jdField_c_of_type_Int = paramString.optInt("serviceType", -1);
        this.l = paramString.optString("ticket", "");
        this.m = paramString.optString("uin", "");
        if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0) || (TextUtils.isEmpty(this.f)) || (TextUtils.isEmpty(this.g)))
        {
          if (((this.k == null) || ("identify".equals(this.k))) && ((TextUtils.isEmpty(this.i)) || (TextUtils.isEmpty(this.j)))) {
            continue;
          }
          QLog.e("IdentificationApiPlugin", 1, "empty param");
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("IdentificationApiPlugin", 1, paramString, new Object[0]);
        return;
      }
    }
    if (Build.VERSION.SDK_INT < 18)
    {
      paramString = new JSONObject();
      paramString.put("ret", 203);
      paramString.put("errMsg", d);
      a(paramString);
      QLog.e("IdentificationApiPlugin", 1, "sdk version < 18");
      return;
    }
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity)) && (((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).isInMultiWindow()))
    {
      paramString = new JSONObject();
      paramString.put("ret", 206);
      paramString.put("errMsg", jdField_b_of_type_JavaLangString);
      a(paramString);
      QLog.e("IdentificationApiPlugin", 1, "current activity is QQBrowserActivity, mode is in multi window");
      return;
    }
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof QWalletPluginProxyActivity)) && (Build.VERSION.SDK_INT >= 24) && (this.jdField_a_of_type_AndroidAppActivity.isInMultiWindowMode()))
    {
      paramString = new JSONObject();
      paramString.put("ret", 206);
      paramString.put("errMsg", jdField_b_of_type_JavaLangString);
      a(paramString);
      QLog.e("IdentificationApiPlugin", 1, "current activity is QWalletPluginProxyActivity, mode is in multi window");
      return;
    }
    if (QIPCClientHelper.getInstance().getClient().callServer("IdentificationIpcServer_Model", "action_is_video_chatting", null).code == 1)
    {
      paramString = new JSONObject();
      paramString.put("ret", 204);
      paramString.put("errMsg", jdField_a_of_type_JavaLangString);
      a(paramString);
      QLog.e("IdentificationApiPlugin", 1, "current mode is video chatting");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      paramString = new JSONObject();
      paramString.put("ret", 212);
      paramString.put("errMsg", e);
      a(paramString);
      QLog.e("IdentificationApiPlugin", 1, "current operate is running");
      return;
    }
    a();
  }
  
  private void a(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    if ("loginVerify".equals(this.k))
    {
      if ((paramJSONObject != null) && (paramJSONObject.has("errMsg")) && (this.jdField_a_of_type_AndroidAppActivity != null))
      {
        QLog.d("IdentificationApiPlugin", 1, new Object[] { "jsonObject is ", paramJSONObject.toString(), " method is ", this.k });
        bcpw.a(this.jdField_a_of_type_AndroidAppActivity, paramJSONObject.optString("errMsg"), 0).a();
        return;
      }
      if (this.jdField_a_of_type_AndroidAppActivity == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramJSONObject == null) {
          bool2 = true;
        }
        QLog.e("IdentificationApiPlugin", 1, new Object[] { "activity is null ? ", Boolean.valueOf(bool1), " jsonObject is null ? ", Boolean.valueOf(bool2) });
        return;
      }
    }
    callJs(this.j, new String[] { paramJSONObject.toString() });
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      QLog.e("IdentificationApiPlugin", 1, "showLoadingView activity is null or is finish");
      return;
    }
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = TroopBaseProxyActivity.a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371256).getLayoutParams().width = -2;
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371557);
      localTextView.setSingleLine();
      localTextView.setPadding(15, 0, 15, 0);
      localTextView.setText("请稍等...");
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      QLog.e("IdentificationApiPlugin", 1, "dismissLoadingView activity is null or activity is null");
    }
    while (this.jdField_a_of_type_AndroidAppDialog == null) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.cancel();
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if ("identification".equals(paramString2))
    {
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      if (("identify".equals(paramString3)) || ("loginVerify".equals(paramString3)))
      {
        this.k = paramString3;
        a(paramVarArgs[0]);
      }
      bool = true;
    }
    return bool;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    switch (paramByte)
    {
    }
    do
    {
      do
      {
        return;
        QLog.d("IdentificationApiPlugin", 1, new Object[] { "onActivityResult REQ_IDENTIFICATION, result code is ", Integer.valueOf(paramInt), " method is ", this.k });
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        a(paramIntent, paramInt);
      } while (!"loginVerify".equals(this.k));
      if (this.jdField_a_of_type_AndroidAppActivity != null)
      {
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return;
      }
      QLog.e("IdentificationApiPlugin", 1, "onActivityResult REQ_IDENTIFICATION activity is null");
      return;
      QLog.d("IdentificationApiPlugin", 1, new Object[] { "onActivityResult REQ_LEGACY, result code is ", Integer.valueOf(paramInt), " method is ", this.k });
      if (paramInt == -1)
      {
        a(paramIntent);
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      a(paramIntent, paramInt);
    } while (!"loginVerify".equals(this.k));
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    QLog.e("IdentificationApiPlugin", 1, "onActivityResult REQ_LEGACY activity is null");
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidAppActivity = a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     armp
 * JD-Core Version:    0.7.0.1
 */