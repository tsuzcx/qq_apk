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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPluginProxyActivity;
import cooperation.troop.TroopBaseProxyActivity;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class awgr
  extends WebViewPlugin
  implements avxb
{
  public static final String a;
  private static final List<String> jdField_a_of_type_JavaUtilList = Arrays.asList(new String[] { "loginVerify", "identify", "changeSecureMobile" });
  public static final String b;
  public static final String c;
  private static final String d;
  private static final String e;
  private static final String f;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int b;
  private int c;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  
  static
  {
    jdField_a_of_type_JavaLangString = anzj.a(2131704600);
    jdField_b_of_type_JavaLangString = anzj.a(2131704599);
    d = anzj.a(2131704605);
    jdField_c_of_type_JavaLangString = anzj.a(2131704608);
    e = anzj.a(2131704604);
    f = anzj.a(2131690091);
  }
  
  public awgr()
  {
    this.mPluginNameSpace = "identification";
  }
  
  private Activity a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void a(Intent paramIntent)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQIdentiferActivity.class);
    localIntent.putExtra("platformAppId", this.jdField_a_of_type_Int);
    localIntent.putExtra("srcAppId", this.jdField_b_of_type_Int);
    localIntent.putExtra("srcOpenId", this.g);
    localIntent.putExtra("key", this.h);
    localIntent.putExtra("method", this.l);
    if ("identify".equals(this.l))
    {
      localIntent.putExtra("idNum", this.i);
      localIntent.putExtra("name", this.j);
    }
    if ("loginVerify".equals(this.l))
    {
      localIntent.putExtra("uin", this.n);
      localIntent.putExtra("ticket", this.m);
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
    if (!TextUtils.isEmpty(this.k))
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
            break label414;
          }
        }
        try
        {
          if (paramIntent.hasExtra("data"))
          {
            paramIntent = paramIntent.getBundleExtra("data");
            paramInt = paramIntent.getInt("ret", 299);
            localJSONObject.put("ret", paramInt);
            localJSONObject.put("errMsg", paramIntent.getString("errMsg", anzj.a(2131704607)));
            localJSONObject.put("idKey", paramIntent.getString("idKey"));
            localJSONObject.put("allResults", localObject1);
          }
          for (;;)
          {
            bdll.b(null, "dc00898", "", "", "0X8009862", "0X8009862", 0, 0, this.jdField_c_of_type_Int + "", "", this.jdField_b_of_type_Int + "", paramInt + "");
            if (QLog.isColorLevel()) {
              QLog.d("IdentificationApiPlugin", 2, "native invoke web ret:" + paramInt + " all_results:" + (String)localObject1);
            }
            callJs(this.k, new String[] { localJSONObject.toString() });
            return;
            localObject2 = "false";
            break;
            label414:
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
              localJSONObject.put("errMsg", anzj.a(2131704606));
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
  
  private void a(avws paramavws)
  {
    paramavws = paramavws.a();
    if (paramavws != null) {
      paramavws.a(this);
    }
    QLog.d("IdentificationApiPlugin", 1, "doFaceVerify");
    if (((paramavws instanceof avxq)) || ("identify".equals(this.l)))
    {
      e();
      if (!(paramavws instanceof avxq)) {}
    }
    try
    {
      paramavws = new JSONObject();
      paramavws.put("ret", 219);
      paramavws.put("errMsg", f);
      a(paramavws);
      return;
    }
    catch (JSONException paramavws)
    {
      QLog.e("IdentificationApiPlugin", 1, new Object[] { "RET_CODE_AREA_NOT_SUPPORT error : ", paramavws.getMessage() });
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    if (("loginVerify".equals(this.l)) || ("changeSecureMobile".equals(this.l)))
    {
      if ((paramJSONObject != null) && (paramJSONObject.has("errMsg")) && (this.jdField_a_of_type_AndroidAppActivity != null))
      {
        QLog.d("IdentificationApiPlugin", 1, new Object[] { "jsonObject is ", paramJSONObject.toString(), " method is ", this.l });
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramJSONObject.optString("errMsg"), 0).a();
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
    callJs(this.k, new String[] { paramJSONObject.toString() });
  }
  
  private void c()
  {
    if (("loginVerify".equals(this.l)) || ("changeSecureMobile".equals(this.l)))
    {
      avwv.a(this.jdField_a_of_type_AndroidAppActivity, this.h, this.l, this.n, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, new awgt(this));
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQIdentiferLegacyActivity.class);
    localIntent.putExtra("platformAppId", this.jdField_a_of_type_Int);
    localIntent.putExtra("srcAppId", this.jdField_b_of_type_Int);
    localIntent.putExtra("srcOpenId", this.g);
    localIntent.putExtra("key", this.h);
    localIntent.putExtra("method", this.l);
    if ("identify".equals(this.l))
    {
      localIntent.putExtra("idNum", this.i);
      localIntent.putExtra("name", this.j);
    }
    if ("loginVerify".equals(this.l))
    {
      localIntent.putExtra("uin", this.n);
      localIntent.putExtra("nonce", this.jdField_a_of_type_Long);
    }
    localIntent.putExtra("serviceType", this.jdField_c_of_type_Int);
    startActivityForResult(localIntent, (byte)2);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      QLog.e("IdentificationApiPlugin", 1, "showLoadingView activity is null or is finish");
      return;
    }
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = TroopBaseProxyActivity.a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372275).getLayoutParams().width = -2;
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372578);
      localTextView.setSingleLine();
      localTextView.setPadding(15, 0, 15, 0);
      localTextView.setText("请稍等...");
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      QLog.e("IdentificationApiPlugin", 1, "dismissLoadingView activity is null or activity is null");
    }
    while (this.jdField_a_of_type_AndroidAppDialog == null) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  public void a()
  {
    b();
  }
  
  public void b()
  {
    if (TextUtils.isEmpty(this.o)) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(this.o);
        this.jdField_a_of_type_Int = localJSONObject1.optInt("platformAppId", 0);
        this.jdField_a_of_type_Long = localJSONObject1.optLong("nonce");
        this.jdField_b_of_type_Int = localJSONObject1.optInt("srcAppId", 0);
        this.g = localJSONObject1.optString("srcOpenId", "");
        this.h = localJSONObject1.optString("key", "");
        this.i = localJSONObject1.optString("idNum", "");
        this.j = localJSONObject1.optString("name", "");
        this.jdField_c_of_type_Int = localJSONObject1.optInt("serviceType", -1);
        this.m = localJSONObject1.optString("ticket", "");
        if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0) || (TextUtils.isEmpty(this.h)))
        {
          if (((this.l == null) || ("identify".equals(this.l))) && ((TextUtils.isEmpty(this.j)) || (TextUtils.isEmpty(this.k)))) {
            continue;
          }
          QLog.e("IdentificationApiPlugin", 1, "empty param");
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("IdentificationApiPlugin", 1, localJSONException, new Object[0]);
        return;
      }
    }
    JSONObject localJSONObject2;
    if (Build.VERSION.SDK_INT < 18)
    {
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("ret", 203);
      localJSONObject2.put("errMsg", d);
      a(localJSONObject2);
      QLog.e("IdentificationApiPlugin", 1, "sdk version < 18");
      return;
    }
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity)) && (((QQBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).isInMultiWindow()))
    {
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("ret", 206);
      localJSONObject2.put("errMsg", jdField_b_of_type_JavaLangString);
      a(localJSONObject2);
      QLog.e("IdentificationApiPlugin", 1, "current activity is QQBrowserActivity, mode is in multi window");
      return;
    }
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof QWalletPluginProxyActivity)) && (Build.VERSION.SDK_INT >= 24) && (this.jdField_a_of_type_AndroidAppActivity.isInMultiWindowMode()))
    {
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("ret", 206);
      localJSONObject2.put("errMsg", jdField_b_of_type_JavaLangString);
      a(localJSONObject2);
      QLog.e("IdentificationApiPlugin", 1, "current activity is QWalletPluginProxyActivity, mode is in multi window");
      return;
    }
    if (QIPCClientHelper.getInstance().getClient().callServer("IdentificationIpcServer_Model", "action_is_video_chatting", null).code == 1)
    {
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("ret", 204);
      localJSONObject2.put("errMsg", jdField_a_of_type_JavaLangString);
      a(localJSONObject2);
      QLog.e("IdentificationApiPlugin", 1, "current mode is video chatting");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("ret", 212);
      localJSONObject2.put("errMsg", e);
      a(localJSONObject2);
      QLog.e("IdentificationApiPlugin", 1, "current operate is running");
      return;
    }
    c();
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"identification".equals(paramString2)) {}
    while (!jdField_a_of_type_JavaUtilList.contains(paramString3)) {
      return false;
    }
    addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
    this.l = paramString3;
    this.o = paramVarArgs[0];
    try
    {
      paramJsBridgeListener = new JSONObject(this.o);
      int i1 = paramJsBridgeListener.optInt("platformAppId", 0);
      this.n = paramJsBridgeListener.optString("uin", "");
      this.k = paramJsBridgeListener.optString("callback", "");
      d();
      paramJsBridgeListener = avws.a();
      paramJsBridgeListener.a(i1, this.n, paramString3, new awgs(this, paramJsBridgeListener));
      return true;
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        QLog.e("IdentificationApiPlugin", 1, new Object[] { "init ip state error : ", paramJsBridgeListener.getMessage() });
      }
    }
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
        QLog.d("IdentificationApiPlugin", 1, new Object[] { "onActivityResult REQ_IDENTIFICATION, result code is ", Integer.valueOf(paramInt), " method is ", this.l });
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        a(paramIntent, paramInt);
      } while (!"loginVerify".equals(this.l));
      if (this.jdField_a_of_type_AndroidAppActivity != null)
      {
        this.jdField_a_of_type_AndroidAppActivity.finish();
        return;
      }
      QLog.e("IdentificationApiPlugin", 1, "onActivityResult REQ_IDENTIFICATION activity is null");
      return;
      QLog.d("IdentificationApiPlugin", 1, new Object[] { "onActivityResult REQ_LEGACY, result code is ", Integer.valueOf(paramInt), " method is ", this.l });
      if (paramInt == -1)
      {
        a(paramIntent);
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      a(paramIntent, paramInt);
    } while (!"loginVerify".equals(this.l));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awgr
 * JD-Core Version:    0.7.0.1
 */