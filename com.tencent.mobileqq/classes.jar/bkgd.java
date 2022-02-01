import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.webbundle.sdk.WebBundleManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.comic.jsp.QQComicJsPlugin.2;
import cooperation.comic.jsp.QQComicJsPlugin.3;
import java.io.File;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class bkgd
  extends VasWebviewJsPlugin
{
  public static final Handler a;
  private static final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static String f;
  public int a;
  bkgc jdField_a_of_type_Bkgc = new bkge(this);
  public bkgg a;
  public String a;
  public final AtomicInteger a;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  public String b;
  public String c = "";
  public String d = "";
  String e = null;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("QQComicJsPluginDeamon", 0);
    localHandlerThread.start();
    jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
  }
  
  public bkgd()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.mPluginNameSpace = "comic";
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle.remove("openWithWebBundle");
      paramBundle.remove("real_url");
      paramBundle.remove("preload_url");
      paramBundle.remove("bundle_data");
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = paramJSONObject.optInt("type");
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject != null) {
      bkfe.jdField_a_of_type_Bkfi.b(this.jdField_a_of_type_OrgJsonJSONObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicJsPlugin", 2, "setContainerInfo success on Resume extrasParams: " + bkfe.jdField_a_of_type_Bkfi.toString());
    }
  }
  
  private void b(JSONObject paramJSONObject)
  {
    bkfe.a(paramJSONObject.optInt("useWebBundle"));
  }
  
  private static String c()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getCacheDir();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((File)localObject1).getAbsolutePath() + "/qqcomic/cache/";
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (!Environment.getExternalStorageState().equals("mounted"));
      localObject1 = localObject2;
    } while (!Environment.getExternalStorageDirectory().exists());
    localObject1 = BaseApplicationImpl.getApplication().getExternalCacheDir();
    if (localObject1 != null) {
      return ((File)localObject1).getAbsolutePath() + "/qqcomic/cache/";
    }
    return VFSAssistantUtils.getSDKPrivatePath("tencent/MobileQQ/qqcomic/cache/");
  }
  
  private void c(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("url");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("data");
    String str2 = paramJSONObject.optString("bundle_url", "");
    paramJSONObject.optString("preloadSource", "");
    paramJSONObject = this.mRuntime.a();
    Intent localIntent;
    if (paramJSONObject != null)
    {
      localIntent = new Intent();
      localIntent.putExtra("url", str1);
      bkfe.a(localIntent);
      if (localJSONObject == null) {
        break label126;
      }
      localIntent.putExtra("openWithWebBundle", true);
      if (!WebBundleManager.getInstance("comic").openWebViewWithWebBundle(paramJSONObject, str1, localJSONObject, localIntent, str2)) {}
    }
    else
    {
      return;
    }
    bkhg.a(str1, false, bkhg.b);
    for (;;)
    {
      a(localIntent.getExtras());
      bkfe.a(paramJSONObject, localIntent, 100);
      return;
      label126:
      bkhg.a(str1, false, bkhg.e);
    }
  }
  
  public long a()
  {
    long l1 = 0L;
    for (;;)
    {
      try
      {
        Object localObject2 = c();
        if (localObject2 == null) {
          return l1;
        }
        Stack localStack = new Stack();
        localStack.push(localObject2);
        l1 = 0L;
        int i;
        if (!localStack.isEmpty())
        {
          localObject2 = new File((String)localStack.pop());
          l2 = l1;
          if (((File)localObject2).isDirectory())
          {
            String[] arrayOfString = ((File)localObject2).list();
            l2 = l1;
            if (arrayOfString != null)
            {
              int j = arrayOfString.length;
              i = 0;
              if (i >= j) {
                break label178;
              }
              File localFile = new File((File)localObject2, arrayOfString[i]);
              if (localFile.isDirectory())
              {
                localStack.push(localFile.getAbsolutePath());
                break label171;
              }
              l1 += localFile.length();
              break label171;
            }
          }
          l1 = ((File)localObject2).length();
          l1 = l2 + l1;
        }
        else
        {
          continue;
        }
        i += 1;
      }
      finally {}
      label171:
      continue;
      label178:
      long l2 = l1;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bkgg != null) {
      this.jdField_a_of_type_Bkgg.a();
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: putstatic 121	bkgd:f	Ljava/lang/String;
    //   6: getstatic 28	bkgd:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   9: invokevirtual 313	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: getstatic 28	bkgd:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: iconst_1
    //   24: invokevirtual 316	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   27: new 318	cooperation/comic/jsp/QQComicJsPlugin$4
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 319	cooperation/comic/jsp/QQComicJsPlugin$4:<init>	(Lbkgd;)V
    //   35: iconst_5
    //   36: aconst_null
    //   37: iconst_1
    //   38: invokestatic 323	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   41: goto -24 -> 17
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	bkgd
    //   0	49	1	paramString	String
    //   12	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	44	finally
    //   20	41	44	finally
  }
  
  public void a(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (this.jdField_a_of_type_Bkgg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "create a new js plugin");
      }
      this.jdField_a_of_type_Bkgg = bkgu.a(this.mRuntime, this.jdField_a_of_type_Bkgc);
    }
    if (this.jdField_a_of_type_Bkgg != null) {
      this.jdField_a_of_type_Bkgg.a(paramString1, paramJSONObject);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "create js plugin failed");
      }
    } while (TextUtils.isEmpty(paramString2));
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("code", 2002);
      paramString1.put("message", "create js plugin failed");
      super.callJs(paramString2, new String[] { paramString1.toString() });
      return;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, JSONObject paramJSONObject, String paramString2, long paramLong)
  {
    jdField_a_of_type_AndroidOsHandler.post(new QQComicJsPlugin.3(this, paramLong, paramString1, paramJSONObject, paramString2));
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934601L)
    {
      if (!TextUtils.isEmpty(this.e))
      {
        super.callJs(this.e, new String[] { "" });
        return true;
      }
    }
    else if ((paramLong == 2L) || (paramLong == 256L)) {
      b();
    }
    return false;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i = -1;
    int m = 0;
    int k = 0;
    boolean bool2 = false;
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QQComicJsPlugin", 2, "handleJsRequest, url=" + paramString1);
    }
    if ((!"comic".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {
      return false;
    }
    try
    {
      if (paramVarArgs.length > 0) {}
      for (paramJsBridgeListener = new JSONObject(paramVarArgs[0]);; paramJsBridgeListener = new JSONObject())
      {
        paramString2 = paramJsBridgeListener.optString("callback", "");
        paramString1 = this.mRuntime.a();
        paramVarArgs = this.mRuntime.a();
        if (paramVarArgs != null) {
          break;
        }
        QLog.e("QQComicJsPlugin", 1, "No fragment...");
        return true;
      }
      if ("getFirstShowData".equals(paramString3))
      {
        paramJsBridgeListener = (String)bkfe.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
        paramString1 = new JSONObject();
        if (!TextUtils.isEmpty(paramJsBridgeListener))
        {
          paramString1.put("code", 0);
          paramString1.put("message", "ok");
          paramString1.put("data", paramJsBridgeListener);
        }
        for (;;)
        {
          super.callJs(paramString2, new String[] { paramString1.toString() });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("QQComicJsPlugin", 2, "js getFirstShowData:" + paramJsBridgeListener);
          break;
          paramString1.put("code", -1);
          paramString1.put("message", amtj.a(2131709283));
          paramString1.put("data", "");
        }
      }
      if (!"setTitleBarBackground".equals(paramString3)) {
        break label340;
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      paramJsBridgeListener.printStackTrace();
      QLog.e("QQComicJsPlugin", 1, "handle js error!", paramJsBridgeListener);
    }
    i = paramJsBridgeListener.optInt("alpha");
    paramVarArgs.mSwiftTitleUI.setTitleBarAlpha(i);
    break label2202;
    label340:
    boolean bool1;
    if ("onWebViewScrollChanged".equals(paramString3))
    {
      paramVarArgs.mSwiftTitleUI.setOnScrollChangedCallback(paramString2);
    }
    else if ("setTitleName".equals(paramString3))
    {
      paramJsBridgeListener = paramJsBridgeListener.optString("name", "");
      paramVarArgs.mSwiftTitleUI.setTitle(paramJsBridgeListener);
    }
    else
    {
      if ("attachSwitchChannel".equals(paramString3))
      {
        paramString1 = paramJsBridgeListener.optString("switchCallback");
        paramJsBridgeListener = "ok";
        if (TextUtils.isEmpty(paramString1)) {
          paramJsBridgeListener = "the subTabCallback isEmpty";
        }
        for (;;)
        {
          paramString1 = new JSONObject();
          paramString3 = new JSONObject();
          try
          {
            paramString1.put("code", i);
            paramString1.put("message", paramJsBridgeListener);
            paramString3.put("subIndex", paramVarArgs.mSwiftTitleUI.getTopTabSelection());
            paramString1.put("data", paramString3);
            super.callJs(paramString2, new String[] { paramString1.toString() });
            break label2202;
            paramVarArgs.mSwiftTitleUI.mTopTabHelper.a(paramString1, false);
            i = 0;
          }
          catch (Exception paramJsBridgeListener)
          {
            for (;;)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
      }
      if ("setSwitchChannel".equals(paramString3))
      {
        k = paramJsBridgeListener.optInt("tabNum", 2);
        m = paramJsBridgeListener.optInt("subIndex");
        paramString1 = paramJsBridgeListener.optString("switchCallback");
        paramString3 = paramJsBridgeListener.optJSONArray("subTextArray");
        if ((paramString3 != null) && (paramString3.length() > 0))
        {
          paramJsBridgeListener = new String[paramString3.length()];
          i = j;
          while (i < paramString3.length())
          {
            paramJsBridgeListener[i] = paramString3.getString(i);
            i += 1;
          }
          paramVarArgs.mSwiftTitleUI.setSubTab(new bgud(m, k, paramString1, paramString2, paramJsBridgeListener));
          break label2202;
        }
      }
      else
      {
        if ("getSwitchChannel".equals(paramString3))
        {
          paramJsBridgeListener = new JSONObject();
          paramString1 = new JSONObject();
          try
          {
            paramJsBridgeListener.put("code", 0);
            paramJsBridgeListener.put("message", "ok");
            paramString1.put("subIndex", paramVarArgs.mSwiftTitleUI.getTopTabSelection());
            paramJsBridgeListener.put("data", paramString1);
            super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              paramString1.printStackTrace();
            }
          }
        }
        if ("showSwitchChannel".equals(paramString3))
        {
          paramJsBridgeListener = "ok";
          if (!paramVarArgs.mSwiftTitleUI.setTopBarVisibility(true))
          {
            paramJsBridgeListener = "not exist sub tab";
            label795:
            paramString1 = new JSONObject();
            try
            {
              paramString1.put("code", i);
              paramString1.put("message", paramJsBridgeListener);
              super.callJs(paramString2, new String[] { paramString1.toString() });
            }
            catch (Exception paramJsBridgeListener)
            {
              for (;;)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
        }
        else
        {
          if ("hideSwitchChannel".equals(paramString3))
          {
            paramJsBridgeListener = "ok";
            i = m;
            if (!paramVarArgs.mSwiftTitleUI.setTopBarVisibility(false))
            {
              paramJsBridgeListener = "not exist sub tab";
              i = -1;
            }
            paramString1 = new JSONObject();
            try
            {
              paramString1.put("code", i);
              paramString1.put("message", paramJsBridgeListener);
              super.callJs(paramString2, new String[] { paramString1.toString() });
            }
            catch (Exception paramJsBridgeListener)
            {
              for (;;)
              {
                paramJsBridgeListener.printStackTrace();
              }
            }
          }
          if ("setTabRedPoint".equals(paramString3))
          {
            j = paramJsBridgeListener.optInt("action");
            paramString3 = paramJsBridgeListener.optJSONArray("subIndexArray");
            if ((paramString3 == null) || (paramString3.length() <= 0)) {
              break label2207;
            }
            paramString1 = new int[paramString3.length()];
            i = k;
            for (;;)
            {
              paramJsBridgeListener = paramString1;
              if (i >= paramString3.length()) {
                break;
              }
              paramString1[i] = paramString3.getInt(i);
              i += 1;
            }
            label1027:
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("code", -1);
            paramJsBridgeListener.put("message", "param is invalid");
            super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
            break label2202;
            label1074:
            paramVarArgs.mSwiftTitleUI.setSubTabRedHot(new bgue(paramJsBridgeListener, j, paramString2));
            break label2202;
          }
          if ("getTitleBarHeight".equals(paramString3))
          {
            paramJsBridgeListener = new JSONObject();
            paramString1 = new JSONObject();
            j = this.mRuntime.a().getResources().getDimensionPixelSize(2131299076);
            i = j;
            if (ImmersiveUtils.isSupporImmersive() == 1) {
              i = j + ImmersiveUtils.getStatusBarHeight(this.mRuntime.a());
            }
            paramString1.put("height", i);
            paramJsBridgeListener.put("code", 0);
            paramJsBridgeListener.put("message", "ok");
            paramJsBridgeListener.put("data", paramString1);
            super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
            break label2202;
          }
          if ("openQQBrowser".equals(paramString3))
          {
            paramString2 = new Intent();
            paramString2.putExtra("url", paramJsBridgeListener.optString("url"));
            bkfe.a(paramString1, paramString2, -1);
            break label2202;
          }
          if ("closeCurrentWebview".equals(paramString3))
          {
            if (paramString1.isFinishing()) {
              break label2202;
            }
            paramString1.finish();
            break label2202;
          }
          if ("setTitleAndBottomBar".equals(paramString3))
          {
            bool1 = paramJsBridgeListener.optBoolean("titleHide");
            boolean bool3 = paramJsBridgeListener.optBoolean("bottomHide");
            paramJsBridgeListener = paramVarArgs.mSwiftTitleUI;
            if (bool1) {
              break label2228;
            }
            bool1 = true;
            label1333:
            paramJsBridgeListener.setTitleBarVisibility(bool1);
            paramJsBridgeListener = (bguf)paramString1;
            bool1 = bool2;
            if (!bool3) {
              bool1 = true;
            }
            paramJsBridgeListener.a(bool1);
            break label2202;
          }
          if ("setLeftCallback".equals(paramString3))
          {
            this.e = paramJsBridgeListener.optString("leftcallback");
            break label2202;
          }
          if ("openView".equals(paramString3))
          {
            paramString2 = paramJsBridgeListener.getJSONObject("options");
            paramJsBridgeListener = paramJsBridgeListener.optString("name");
            paramString3 = new Intent();
            paramString3.setComponent(new ComponentName("com.tencent.mobileqq", paramJsBridgeListener));
            paramString3.putExtra("options", paramString2.toString());
            paramString1.startActivity(paramString3);
            break label2202;
          }
          if ("getReporterInfo".equals(paramString3))
          {
            paramJsBridgeListener = new JSONObject();
            paramString1 = new JSONObject();
            paramString1.put("mod", bkfe.jdField_a_of_type_JavaLangString);
            paramString1.put("land_page", bkfe.c);
            paramString1.put("obj_ownerid", bkfe.b);
            paramJsBridgeListener.put("data", paramString1);
            paramJsBridgeListener.put("resultCode", 0);
            paramJsBridgeListener.put("message", "ok");
            super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
            break label2202;
          }
          if ("getCacheSize".equals(paramString3))
          {
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("result", 0);
            paramJsBridgeListener.put("message", "ok");
            paramString1 = new JSONObject();
            paramString1.put("size", a());
            if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
              break label2234;
            }
          }
        }
      }
    }
    label2202:
    label2207:
    label2228:
    label2234:
    for (i = 1;; i = 2)
    {
      paramString1.put("status", i);
      paramJsBridgeListener.put("data", paramString1);
      super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
      break label2202;
      if ("clearCache".equals(paramString3))
      {
        a(paramString2);
      }
      else if ("initPrivateSettingIcon".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQComicJsPlugin", 2, "initPrivateSettingIcon " + paramJsBridgeListener.optInt("status", -1));
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramJsBridgeListener.optInt("status", -1));
        this.jdField_a_of_type_JavaLangString = paramJsBridgeListener.optString("name");
        this.b = paramJsBridgeListener.optString("callbackName");
        if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 0) && (!this.mRuntime.a().getApp().getSharedPreferences("boodo_" + this.mRuntime.a().getCurrentAccountUin(), 0).getBoolean("private_read_red_dot", false)))
        {
          paramVarArgs.mSwiftTitleUI.showRightCornerRedDot(true);
          QLog.i("QQComicJsPlugin", 1, "show private read red dot.");
        }
        if (!TextUtils.isEmpty(paramString2))
        {
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("code", 0);
          super.callJs(paramString2, new String[] { paramJsBridgeListener.toString() });
        }
      }
      else if ("openWebBundleView".equals(paramString3))
      {
        c(paramJsBridgeListener);
      }
      else if ("setColorfulTabInfo".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicJsPlugin", 2, "setColorfulTabInfo " + paramJsBridgeListener.optString("tabTitle", "fail"));
        }
        this.c = paramJsBridgeListener.optString("tabTitle", "");
        this.d = paramJsBridgeListener.optString("tabSubTitle", "");
      }
      else if ("setWebBundleOption".equals(paramString3))
      {
        b(paramJsBridgeListener);
      }
      else if ("setShareOption".equals(paramString3))
      {
        a(paramJsBridgeListener);
      }
      else if ("setContainerInfo".equals(paramString3))
      {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramJsBridgeListener.optString("read_params"));
        bkfe.jdField_a_of_type_Bkfi.b(this.jdField_a_of_type_OrgJsonJSONObject);
        if (QLog.isColorLevel()) {
          QLog.d("QQComicJsPlugin", 2, "setContainerInfo success extrasParams: " + bkfe.jdField_a_of_type_Bkfi.toString());
        }
      }
      else if (bkgu.a)
      {
        ThreadManager.getUIHandler().post(new QQComicJsPlugin.2(this, paramString3, paramJsBridgeListener, paramString2));
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "js plugin is not ready...");
        }
        a(paramString3, paramJsBridgeListener, paramString2, 3000L);
        break label2202;
        i = 0;
        break label795;
        paramJsBridgeListener = null;
        break;
      }
      return true;
      break;
      paramJsBridgeListener = null;
      if ((j != 1) && (j != 2)) {
        break label1027;
      }
      if (paramJsBridgeListener != null) {
        break label1074;
      }
      break label1027;
      bool1 = false;
      break label1333;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Bkgg != null) {
      this.jdField_a_of_type_Bkgg.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgd
 * JD-Core Version:    0.7.0.1
 */