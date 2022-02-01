package com.tencent.mobileqq.Doraemon.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.Doraemon.IDoraemonApi;
import com.tencent.mobileqq.Doraemon.UserPermission;
import com.tencent.mobileqq.Doraemon.impl.webview.VerifyUrlJobSegment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DefaultDoraemonAppInfoHelper
{
  private static DefaultDoraemonAppInfoHelper jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper = new DefaultDoraemonAppInfoHelper();
  long jdField_a_of_type_Long = 0L;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  Map<String, UserPermission> jdField_a_of_type_JavaUtilMap = new HashMap();
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  boolean jdField_a_of_type_Boolean = false;
  long b = 0L;
  
  static
  {
    ((IDoraemonApi)QRoute.api(IDoraemonApi.class)).initBosses();
  }
  
  public static DefaultDoraemonAppInfoHelper a()
  {
    return jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper;
  }
  
  /* Error */
  private static String a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 54	java/io/InputStreamReader
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 60	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   8: invokevirtual 66	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   11: aload_1
    //   12: invokevirtual 72	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   15: invokespecial 75	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   18: astore_1
    //   19: aload_1
    //   20: astore_0
    //   21: new 77	java/io/BufferedReader
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 80	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   29: astore_2
    //   30: aload_1
    //   31: astore_0
    //   32: new 82	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   39: astore_3
    //   40: aload_1
    //   41: astore_0
    //   42: aload_2
    //   43: invokevirtual 87	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore 4
    //   48: aload 4
    //   50: ifnull +24 -> 74
    //   53: aload_1
    //   54: astore_0
    //   55: aload_3
    //   56: aload 4
    //   58: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_1
    //   63: astore_0
    //   64: aload_3
    //   65: bipush 10
    //   67: invokevirtual 94	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: goto -31 -> 40
    //   74: aload_1
    //   75: astore_0
    //   76: aload_3
    //   77: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore_2
    //   81: aload_1
    //   82: invokevirtual 100	java/io/InputStreamReader:close	()V
    //   85: aload_2
    //   86: areturn
    //   87: astore_2
    //   88: goto +12 -> 100
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_0
    //   94: goto +23 -> 117
    //   97: astore_2
    //   98: aconst_null
    //   99: astore_1
    //   100: aload_1
    //   101: astore_0
    //   102: aload_2
    //   103: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 100	java/io/InputStreamReader:close	()V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_1
    //   117: aload_0
    //   118: ifnull +7 -> 125
    //   121: aload_0
    //   122: invokevirtual 100	java/io/InputStreamReader:close	()V
    //   125: goto +5 -> 130
    //   128: aload_1
    //   129: athrow
    //   130: goto -2 -> 128
    //   133: astore_0
    //   134: aload_2
    //   135: areturn
    //   136: astore_0
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: goto -15 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramContext	android.content.Context
    //   0	143	1	paramString	String
    //   29	57	2	localObject	Object
    //   87	1	2	localException1	Exception
    //   97	38	2	localException2	Exception
    //   39	38	3	localStringBuilder	java.lang.StringBuilder
    //   46	11	4	str	String
    // Exception table:
    //   from	to	target	type
    //   21	30	87	java/lang/Exception
    //   32	40	87	java/lang/Exception
    //   42	48	87	java/lang/Exception
    //   55	62	87	java/lang/Exception
    //   64	71	87	java/lang/Exception
    //   76	81	87	java/lang/Exception
    //   0	19	91	finally
    //   0	19	97	java/lang/Exception
    //   21	30	116	finally
    //   32	40	116	finally
    //   42	48	116	finally
    //   55	62	116	finally
    //   64	71	116	finally
    //   76	81	116	finally
    //   102	106	116	finally
    //   81	85	133	java/io/IOException
    //   110	114	136	java/io/IOException
    //   121	125	139	java/io/IOException
  }
  
  private void a(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable)
    {
      QLog.d("DoraemonOpenAPI.permissionHelper", 1, "closeClosable error : ", paramCloseable);
    }
  }
  
  private boolean a(String paramString)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (localJSONObject == null) {
      return false;
    }
    if ((UserPermission)this.jdField_a_of_type_JavaUtilMap.get(paramString) != null) {
      return true;
    }
    Iterator localIterator = localJSONObject.keys();
    while (localIterator.hasNext())
    {
      Object localObject = localJSONObject.optJSONObject((String)localIterator.next());
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optJSONArray("apis");
        if (localObject != null)
        {
          int j = ((JSONArray)localObject).length();
          int i = 0;
          while (i < j)
          {
            if (TextUtils.equals(paramString, ((JSONArray)localObject).optString(i))) {
              return true;
            }
            i += 1;
          }
        }
      }
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramString);
      this.jdField_a_of_type_JavaUtilMap.clear();
      return true;
    }
    catch (JSONException paramString)
    {
      label23:
      break label23;
    }
    QLog.e("DoraemonOpenAPI.permissionHelper", 1, "parseGroupData error");
    return false;
  }
  
  public UserPermission a(String paramString)
  {
    JSONObject localJSONObject1 = this.jdField_a_of_type_OrgJsonJSONObject;
    if (localJSONObject1 == null) {
      return null;
    }
    UserPermission localUserPermission = (UserPermission)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    Object localObject = localUserPermission;
    if (localUserPermission == null)
    {
      Iterator localIterator = localJSONObject1.keys();
      JSONObject localJSONObject2;
      JSONArray localJSONArray;
      int j;
      label148:
      do
      {
        do
        {
          do
          {
            localObject = localUserPermission;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (String)localIterator.next();
            localJSONObject2 = localJSONObject1.optJSONObject((String)localObject);
          } while (localJSONObject2 == null);
          localJSONArray = localJSONObject2.optJSONArray("apis");
        } while (localJSONArray == null);
        k = localJSONArray.length();
        j = 0;
        i = 0;
        while (i < k)
        {
          if (TextUtils.equals(paramString, localJSONArray.optString(i)))
          {
            i = 1;
            break label148;
          }
          i += 1;
        }
        i = 0;
      } while (i == 0);
      paramString = new UserPermission((String)localObject, localJSONObject2.optString("name"));
      int k = localJSONArray.length();
      int i = j;
      for (;;)
      {
        localObject = paramString;
        if (i >= k) {
          break;
        }
        localObject = localJSONArray.optString(i);
        this.jdField_a_of_type_JavaUtilMap.put(localObject, paramString);
        i += 1;
      }
    }
    return localObject;
  }
  
  public void a()
  {
    try
    {
      boolean bool1 = this.jdField_a_of_type_Boolean;
      if (bool1) {
        return;
      }
      Object localObject1 = BaseApplication.getContext().getSharedPreferences("DoraemonApiGroup.json", 4);
      String str = ((SharedPreferences)localObject1).getString("app_version", null);
      boolean bool2 = false;
      bool1 = bool2;
      if (TextUtils.equals(str, "8.7.0"))
      {
        str = ((SharedPreferences)localObject1).getString("content", null);
        bool1 = bool2;
        if (!TextUtils.isEmpty(str))
        {
          bool2 = b(str);
          bool1 = bool2;
          if (bool2)
          {
            this.b = ((SharedPreferences)localObject1).getLong("version", 0L);
            bool1 = bool2;
          }
        }
      }
      if (!bool1)
      {
        QLog.i("DoraemonOpenAPI.permissionHelper", 1, "fail to read group info, use default");
        localObject1 = a(BaseApplication.getContext(), "DoraemonApiGroup.json");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          bool1 = b((String)localObject1);
        }
        if (!bool1) {
          QLog.e("DoraemonOpenAPI.permissionHelper", 1, "fail to read default group info!");
        }
      }
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, DefaultDoraemonAppInfoHelper.OnGetAppInfo paramOnGetAppInfo)
  {
    MiniAppInfo localMiniAppInfo = ((IDoraemonApi)QRoute.api(IDoraemonApi.class)).getAppInfo(paramString2, paramInt, 1, false, null, 1);
    paramString1 = localMiniAppInfo;
    if (localMiniAppInfo == null) {
      paramString1 = new MiniAppInfo(paramString2, paramInt);
    }
    Stream.of(paramString1).map(new ThreadOffFunction("DoraemonOpenAPI.permissionHelper", 16)).map(new DefaultDoraemonAppInfoHelper.EnsureInitJobSegment(null)).map(new VerifyUrlJobSegment(paramString3)).map(new DefaultDoraemonAppInfoHelper.GetAppAPIPermissionJobSegment(null)).map(new DefaultDoraemonAppInfoHelper.6(this, paramString2, paramInt)).map(new UIThreadOffFunction(null)).subscribe(new DefaultDoraemonAppInfoHelper.5(this, paramOnGetAppInfo));
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, DefaultDoraemonAppInfoHelper.OnGetAppInfo paramOnGetAppInfo)
  {
    paramString1 = ((IDoraemonApi)QRoute.api(IDoraemonApi.class)).getAppInfo(paramString2, paramInt, 1, false, null, 1);
    if (paramString1 != null)
    {
      ThreadManager.getUIHandler().post(new DefaultDoraemonAppInfoHelper.2(this, paramOnGetAppInfo, paramString1));
      return;
    }
    paramString1 = new MiniAppInfo(paramString2, paramInt);
    paramString1.k = paramString3;
    paramString1.i = paramString4;
    paramString1.j = paramString5;
    Stream.of(paramString1).map(new ThreadOffFunction("DoraemonOpenAPI.permissionHelper", 16)).map(new DefaultDoraemonAppInfoHelper.EnsureInitJobSegment(null)).map(new DefaultDoraemonAppInfoHelper.GetAppAPIPermissionJobSegment(null)).map(new DefaultDoraemonAppInfoHelper.4(this, paramString2, paramInt)).map(new UIThreadOffFunction(null)).subscribe(new DefaultDoraemonAppInfoHelper.3(this, paramOnGetAppInfo));
  }
  
  public void a(List<Integer> paramList, Set<String> paramSet)
  {
    paramSet.clear();
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (localJSONObject == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = localJSONObject.optJSONObject(String.valueOf((Integer)paramList.next()));
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optJSONArray("apis");
        if (localObject != null)
        {
          int i = 0;
          int j = ((JSONArray)localObject).length();
          while (i < j)
          {
            paramSet.add(((JSONArray)localObject).optString(i));
            i += 1;
          }
        }
      }
    }
  }
  
  public void b()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (l > this.jdField_a_of_type_Long) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (l > this.jdField_a_of_type_Long)
        {
          this.jdField_a_of_type_Long = (l + 300000L);
          ThreadManager.post(new DefaultDoraemonAppInfoHelper.1(this), 5, null, false);
          return;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper
 * JD-Core Version:    0.7.0.1
 */