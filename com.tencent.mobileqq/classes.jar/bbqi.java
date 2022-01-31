import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.URLInterceptManager.1;
import com.tencent.mobileqq.vas.URLInterceptManager.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

public class bbqi
  implements Manager
{
  public static int a;
  public static String a;
  public static int b;
  public static int c;
  public static int d = 3;
  Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  Map<String, String> b;
  Map<String, String> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "URLInterceptManager";
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
  }
  
  public bbqi(Context paramContext)
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    ThreadManager.post(new URLInterceptManager.1(this, paramContext), 8, null, true);
  }
  
  public bbqi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int i;
    String str1;
    label65:
    String str2;
    label84:
    int j;
    label120:
    String str3;
    if (paramJSONObject != null)
    {
      try
      {
        if (!paramJSONObject.has("urltoapi")) {
          break label399;
        }
        paramJSONObject = paramJSONObject.getJSONArray("urltoapi");
      }
      catch (Exception paramJSONObject)
      {
        label146:
        QLog.e(jdField_a_of_type_JavaLangString, 1, "doParseJson fail: " + paramJSONObject.getMessage());
      }
      if (i >= paramJSONObject.length()) {
        break label369;
      }
      localObject = paramJSONObject.getJSONObject(i);
      if (localObject == null) {
        break label392;
      }
      if (!((JSONObject)localObject).has("url")) {
        break label404;
      }
      str1 = ((JSONObject)localObject).getString("url");
      break label387;
      if (!((JSONObject)localObject).has("api")) {
        break label308;
      }
      str2 = ((JSONObject)localObject).getString("api");
      if ((TextUtils.isEmpty(str2)) || (!str2.startsWith("mqqapi"))) {
        break label392;
      }
      if (!((JSONObject)localObject).has("match_type")) {
        break label314;
      }
      j = ((JSONObject)localObject).getInt("match_type");
      if (j == jdField_a_of_type_Int) {
        break label392;
      }
      if (!((JSONObject)localObject).has("minVer")) {
        break label410;
      }
      str3 = ((JSONObject)localObject).getString("minVer");
      if (TextUtils.isEmpty(str3)) {
        break label392;
      }
      if (!((JSONObject)localObject).has("maxVer")) {
        break label416;
      }
    }
    label387:
    label392:
    label399:
    label402:
    label404:
    label408:
    label410:
    label416:
    for (Object localObject = ((JSONObject)localObject).getString("maxVer");; localObject = null)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (bbpm.a("8.2.8", (String)localObject)) && (bbpm.a(str3, "8.2.8")))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "Parse from Json: URL = " + str1 + " API = " + str2 + " type = " + j);
        }
        if (j == jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_JavaUtilMap.put(str1, str2);
          break label392;
          return;
          label308:
          str2 = null;
          break label84;
          label314:
          j = jdField_a_of_type_Int;
          break label120;
        }
        if (j == jdField_c_of_type_Int)
        {
          this.jdField_b_of_type_JavaUtilMap.put(str1, str2);
        }
        else if (j == d)
        {
          this.jdField_c_of_type_JavaUtilMap.put(str1, str2);
          break label392;
          label369:
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          return;
          label378:
          if (paramJSONObject == null) {
            break label402;
          }
          i = 0;
          break;
        }
      }
      for (;;)
      {
        if (str1 != null) {
          break label408;
        }
        i += 1;
        break;
        paramJSONObject = null;
        break label378;
        break label369;
        str1 = null;
      }
      break label65;
      str3 = null;
      break label146;
    }
  }
  
  public String a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "checkURL fail config not load");
      }
      return null;
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "checkURL url = null");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkURL original url = " + paramString);
    }
    String str1 = paramString;
    if (paramString.contains("www.urlshare.cn/umirror_url_check"))
    {
      i = paramString.indexOf("&url=");
      str1 = paramString;
      if (i > 0)
      {
        i += 5;
        j = paramString.indexOf("&src_uin", i);
        str1 = paramString;
        if (j > i) {
          str1 = paramString.substring(i, j);
        }
      }
    }
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkURL full match url=" + str1 + " Replace with: " + (String)this.jdField_a_of_type_JavaUtilMap.get(str1));
      }
      return (String)this.jdField_a_of_type_JavaUtilMap.get(str1);
    }
    int i = str1.indexOf("?");
    int j = str1.indexOf("#");
    int k = Math.min(i, j);
    if (k > 0) {
      paramString = str1.substring(0, k);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_JavaUtilMap.containsKey(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkURL without param match url=" + str1 + " Replace with: " + (String)this.jdField_b_of_type_JavaUtilMap.get(paramString));
        }
        return (String)this.jdField_b_of_type_JavaUtilMap.get(paramString);
        i = Math.max(i, j);
        if (i > 0) {
          paramString = str1.substring(0, i);
        }
      }
      else
      {
        if (this.jdField_c_of_type_JavaUtilMap.keySet().size() > 0)
        {
          paramString = this.jdField_c_of_type_JavaUtilMap.keySet().iterator();
          while (paramString.hasNext())
          {
            String str2 = (String)paramString.next();
            if (str1.startsWith(str2))
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "checkURL part match url=" + str1 + " Replace with: " + (String)this.jdField_c_of_type_JavaUtilMap.get(str1));
              }
              return (String)this.jdField_c_of_type_JavaUtilMap.get(str2);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkURL not match! url = " + str1);
        }
        return null;
      }
      paramString = str1;
    }
  }
  
  public void a(Context paramContext)
  {
    String str = bbnq.h.jdField_a_of_type_JavaLangString;
    paramContext = new File(paramContext.getFilesDir(), str);
    if (paramContext.exists()) {
      try
      {
        paramContext = bbdj.a(paramContext);
        if (paramContext == null) {}
      }
      catch (OutOfMemoryError paramContext)
      {
        for (;;)
        {
          try
          {
            a(new JSONObject(paramContext));
            return;
          }
          catch (Exception paramContext)
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "getJsonError,Exception:" + str + paramContext.getMessage());
            return;
          }
          paramContext = paramContext;
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "getJsonOOM,json_name:" + str + paramContext.getMessage());
          }
          paramContext = null;
        }
      }
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "json file not exist");
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    a(bbnq.a(paramQQAppInterface, bbnq.h, true));
  }
  
  public boolean a(Intent paramIntent, Activity paramActivity)
  {
    if ((paramIntent.getComponent() != null) && ("com.tencent.mobileqq.activity.QQBrowserActivity".equals(paramIntent.getComponent().getClassName())))
    {
      paramIntent = a(paramIntent.getStringExtra("url"));
      if (!TextUtils.isEmpty(paramIntent))
      {
        Intent localIntent = new Intent(paramActivity, JumpActivity.class);
        localIntent.setData(Uri.parse(paramIntent));
        localIntent.putExtra("from", "webview");
        paramActivity.startActivity(localIntent);
        return true;
      }
    }
    return false;
  }
  
  public boolean a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramIntent.getComponent() != null) && ("com.tencent.mobileqq.activity.QQBrowserActivity".equals(paramIntent.getComponent().getClassName())))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break label51;
      }
      ThreadManager.post(new URLInterceptManager.2(this, paramQQAppInterface), 8, null, true);
    }
    label51:
    do
    {
      do
      {
        return false;
        paramIntent = a(paramIntent.getStringExtra("url"));
      } while (TextUtils.isEmpty(paramIntent));
      paramIntent = bbej.a(paramQQAppInterface, paramContext, paramIntent);
    } while (paramIntent == null);
    paramIntent.c();
    return true;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbqi
 * JD-Core Version:    0.7.0.1
 */