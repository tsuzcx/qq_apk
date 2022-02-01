import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class awah
  extends WebViewPlugin
{
  public Context a;
  awam jdField_a_of_type_Awam;
  awar jdField_a_of_type_Awar = new awai(this);
  bika jdField_a_of_type_Bika = null;
  bikg jdField_a_of_type_Bikg = null;
  
  public awah()
  {
    this.mPluginNameSpace = "QQApi";
  }
  
  Activity a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public String a(String paramString)
  {
    String str = "";
    if (this.jdField_a_of_type_Bikg != null)
    {
      paramString = this.jdField_a_of_type_Bikg.getOpenidBatch(paramString);
      str = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d("gamecenter", 2, "<--getOpenidBatch result=" + paramString);
        str = paramString;
      }
    }
    return str;
  }
  
  public void a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("appID");
      String str1 = ((JSONObject)localObject).optString("paramsStr");
      String str2 = ((JSONObject)localObject).optString("packageName");
      String str3 = ((JSONObject)localObject).optString("flags");
      String str4 = ((JSONObject)localObject).optString("type");
      localObject = ((JSONObject)localObject).optString("subappid");
      a(paramString, str1, str2, str3, str4, (String)localObject);
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("launchAppWithTokens", 2, "parse params error");
      }
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (QLog.isColorLevel()) {
      QLog.d("gamecenter", 2, "launchAppWithTokens " + paramString3);
    }
    bcqt localbcqt = new bcqt();
    Object localObject;
    if ((this.jdField_a_of_type_Bika != null) || ((this.jdField_a_of_type_AndroidContentContext instanceof PublicFragmentActivityForTool))) {
      localObject = this.mRuntime.a();
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
          localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app;
        }
      }
      else
      {
        int j = 268435456;
        try
        {
          k = Integer.parseInt(paramString4);
          if ((0x4000000 & k) == 67108864) {
            j = 335544320;
          }
          i = j;
          if ((0x20000000 & k) == 536870912) {
            i = j | 0x20000000;
          }
          j = i;
          if ((k & 0x400000) == 4194304) {
            j = i | 0x400000;
          }
          i = j;
        }
        catch (Exception paramString4)
        {
          int i;
          for (;;)
          {
            int k;
            String str;
            i = 268435456;
            continue;
            paramString2 = paramString4;
            if (QLog.isColorLevel())
            {
              QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin webview is null");
              paramString2 = paramString4;
            }
          }
          localbcqt.a((AppInterface)localObject, this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, paramString3, i);
          return;
        }
        bdla.b(null, "CliOper", "", "", "Game", "Launch_game", 0, 0, paramString1, "", "", "");
        k = 0;
        str = "tencentwtlogin" + paramString1 + "://";
        j = k;
        if ("wtlogin".equals(paramString5))
        {
          paramString4 = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
          paramString5 = new Intent("android.intent.action.VIEW");
          paramString5.setData(Uri.parse(str));
          j = k;
          if (paramString4 != null)
          {
            j = k;
            if (paramString4.queryIntentActivities(paramString5, 0).size() > 0) {
              j = 1;
            }
          }
        }
        if (j != 0)
        {
          paramString4 = "";
          if ((this.mRuntime != null) && (this.mRuntime.a() != null))
          {
            paramString2 = this.mRuntime.a().getUrl();
            localbcqt.a(str, this.jdField_a_of_type_AndroidContentContext, paramString2, (AppInterface)localObject, paramString1, paramString3, i, paramString6);
            return;
          }
        }
      }
      localObject = null;
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString, 10);
      paramString = (bihb)super.getBrowserComponent(32);
      if (paramString != null)
      {
        Message localMessage = paramString.a.obtainMessage(0, i, 0);
        paramString.a.sendMessage(localMessage);
      }
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject = null;
    boolean bool3 = false;
    boolean bool2 = bool3;
    boolean bool1;
    int i;
    if ("QQApi".equals(paramString2))
    {
      if ((paramJsBridgeListener == null) || (!paramJsBridgeListener.a)) {
        break label96;
      }
      bool1 = true;
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      i = paramVarArgs.length;
      if ((!"isAppInstalled".equals(paramString3)) || (i != 1)) {
        break label102;
      }
      paramString1 = Boolean.valueOf(bhfn.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]));
      label77:
      if (!bool1) {
        break label695;
      }
      callJs4OpenApiIfNeeded(paramString3, 0, paramString1);
    }
    for (;;)
    {
      bool2 = true;
      label96:
      label102:
      do
      {
        do
        {
          return bool2;
          bool1 = false;
          break;
          if (("checkAppInstalled".equals(paramString3)) && (i == 1))
          {
            paramString1 = bhfn.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break label77;
          }
          if (("checkAppInstalledBatch".equals(paramString3)) && (i == 1))
          {
            paramString1 = bhfn.b(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break label77;
          }
          if (("isAppInstalledBatch".equals(paramString3)) && (i == 1))
          {
            paramString1 = bhfn.c(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break label77;
          }
          if (("startAppWithPkgName".equals(paramString3)) && (i == 1))
          {
            paramString1 = Boolean.valueOf(bhfn.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0], null));
            break label77;
          }
          if (("startAppWithPkgNameAndOpenId".equals(paramString3)) && (i == 2))
          {
            paramString1 = Boolean.valueOf(bhfn.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0], paramVarArgs[1]));
            break label77;
          }
          if (("getOpenidBatch".equals(paramString3)) && (i == 1))
          {
            paramString1 = a(paramVarArgs[0]);
            break label77;
          }
          if (("launchAppWithTokens".equals(paramString3)) && ((i == 1) || (i == 4)))
          {
            if (i == 1)
            {
              a(paramVarArgs[0]);
              paramString1 = localObject;
              break label77;
            }
            paramString1 = localObject;
            if (i != 4) {
              break label77;
            }
            a(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], null, "");
            paramString1 = localObject;
            break label77;
          }
          if (("getAppsVerionCodeBatch".equals(paramString3)) && (i == 1))
          {
            paramString1 = bhfn.d(this.jdField_a_of_type_AndroidContentContext, paramVarArgs[0]);
            break label77;
          }
          if (("setShareURL".equals(paramString3)) && (i == 1))
          {
            paramString1 = Boolean.valueOf(this.jdField_a_of_type_Awam.a(paramVarArgs[0]));
            break label77;
          }
          if (("setShareInfo".equals(paramString3)) && (i == 1))
          {
            paramString1 = Boolean.valueOf(this.jdField_a_of_type_Awam.b(paramVarArgs[0]));
            break label77;
          }
          if (("setToolHiddenFlags".equals(paramString3)) && (i == 1))
          {
            b(paramVarArgs[0]);
            paramString1 = localObject;
            break label77;
          }
          if (("shareMsg".equals(paramString3)) && (i == 1))
          {
            this.jdField_a_of_type_Awam.a(paramVarArgs[0], bool1);
            paramString1 = localObject;
            break label77;
          }
          if (("shareText".equals(paramString3)) && (i == 1))
          {
            this.jdField_a_of_type_Awam.b(paramVarArgs[0]);
            paramString1 = localObject;
            break label77;
          }
          if (("shareHypertext".equals(paramString3)) && (i == 1))
          {
            this.jdField_a_of_type_Awam.c(paramVarArgs[0]);
            paramString1 = localObject;
            break label77;
          }
          if (("sendPokeMsg".equals(paramString3)) && (i == 1))
          {
            this.jdField_a_of_type_Awam.d(paramVarArgs[0]);
            paramString1 = localObject;
            break label77;
          }
          bool2 = bool3;
        } while (!"shareArkMessage".equals(paramString3));
        bool2 = bool3;
      } while (i != 1);
      this.jdField_a_of_type_Awam.a(paramVarArgs[0]);
      paramString1 = localObject;
      break label77;
      label695:
      paramJsBridgeListener.a(paramString1);
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    this.jdField_a_of_type_Awam.a(paramIntent, paramByte, paramInt);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = a();
    this.jdField_a_of_type_Awam = new awam(this.jdField_a_of_type_AndroidContentContext, this.mRuntime.a(), this.mRuntime.a(), this.jdField_a_of_type_Awar);
    this.jdField_a_of_type_Awam.a(this);
    bifb localbifb = this.mRuntime.a(this.mRuntime.a());
    if ((localbifb != null) && ((localbifb instanceof bika))) {
      this.jdField_a_of_type_Bika = ((bika)localbifb);
    }
    localbifb = this.mRuntime.a(this.mRuntime.a());
    if ((localbifb != null) && ((localbifb instanceof bikg))) {
      this.jdField_a_of_type_Bikg = ((bikg)localbifb);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Awam.a();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awah
 * JD-Core Version:    0.7.0.1
 */