package com.tencent.mobileqq.Doraemon.impl;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.StoryBoss;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.UserPermission;
import com.tencent.mobileqq.Doraemon.impl.webview.VerifyUrlJobSegment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.miniapp.MiniAppManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
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
    Bosses.initWithBoss(BaseApplicationImpl.getApplication(), new StoryBoss(BaseApplicationImpl.getApplication()));
  }
  
  public static DefaultDoraemonAppInfoHelper a()
  {
    return jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper;
  }
  
  /* Error */
  private static String a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 60	java/io/InputStreamReader
    //   5: dup
    //   6: aload_0
    //   7: invokevirtual 66	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   10: invokevirtual 72	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   13: aload_1
    //   14: invokevirtual 78	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: invokespecial 81	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore_0
    //   23: new 83	java/io/BufferedReader
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 86	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_2
    //   32: aload_1
    //   33: astore_0
    //   34: new 88	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   41: astore 4
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: invokevirtual 93	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnull +47 -> 100
    //   56: aload_1
    //   57: astore_0
    //   58: aload 4
    //   60: aload 5
    //   62: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: astore_0
    //   68: aload 4
    //   70: bipush 10
    //   72: invokevirtual 100	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: goto -33 -> 43
    //   79: astore_2
    //   80: aload_1
    //   81: astore_0
    //   82: aload_2
    //   83: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   86: aload_3
    //   87: astore_0
    //   88: aload_1
    //   89: ifnull +9 -> 98
    //   92: aload_1
    //   93: invokevirtual 106	java/io/InputStreamReader:close	()V
    //   96: aload_3
    //   97: astore_0
    //   98: aload_0
    //   99: areturn
    //   100: aload_1
    //   101: astore_0
    //   102: aload 4
    //   104: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore_2
    //   108: aload_2
    //   109: astore_0
    //   110: aload_1
    //   111: ifnull -13 -> 98
    //   114: aload_1
    //   115: invokevirtual 106	java/io/InputStreamReader:close	()V
    //   118: aload_2
    //   119: areturn
    //   120: astore_0
    //   121: aload_2
    //   122: areturn
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_0
    //   126: aload_0
    //   127: ifnull +7 -> 134
    //   130: aload_0
    //   131: invokevirtual 106	java/io/InputStreamReader:close	()V
    //   134: aload_1
    //   135: athrow
    //   136: astore_0
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: goto -6 -> 134
    //   143: astore_1
    //   144: goto -18 -> 126
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_1
    //   150: goto -70 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramContext	android.content.Context
    //   0	153	1	paramString	String
    //   31	15	2	localBufferedReader	java.io.BufferedReader
    //   79	4	2	localException1	java.lang.Exception
    //   107	15	2	str1	String
    //   147	1	2	localException2	java.lang.Exception
    //   1	96	3	localObject	Object
    //   41	62	4	localStringBuilder	java.lang.StringBuilder
    //   49	12	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   23	32	79	java/lang/Exception
    //   34	43	79	java/lang/Exception
    //   45	51	79	java/lang/Exception
    //   58	66	79	java/lang/Exception
    //   68	76	79	java/lang/Exception
    //   102	108	79	java/lang/Exception
    //   114	118	120	java/io/IOException
    //   2	21	123	finally
    //   92	96	136	java/io/IOException
    //   130	134	139	java/io/IOException
    //   23	32	143	finally
    //   34	43	143	finally
    //   45	51	143	finally
    //   58	66	143	finally
    //   68	76	143	finally
    //   82	86	143	finally
    //   102	108	143	finally
    //   2	21	147	java/lang/Exception
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
      QLog.e("DoraemonOpenAPI.permissionHelper", 1, "parseGroupData error");
    }
    return false;
  }
  
  public UserPermission a(String paramString)
  {
    JSONObject localJSONObject1 = this.jdField_a_of_type_OrgJsonJSONObject;
    Object localObject;
    if (localJSONObject1 == null) {
      localObject = null;
    }
    UserPermission localUserPermission;
    do
    {
      return localObject;
      localUserPermission = (UserPermission)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      localObject = localUserPermission;
    } while (localUserPermission != null);
    Iterator localIterator = localJSONObject1.keys();
    label205:
    for (;;)
    {
      localObject = localUserPermission;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (String)localIterator.next();
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject((String)localObject);
      if (localJSONObject2 != null)
      {
        JSONArray localJSONArray = localJSONObject2.optJSONArray("apis");
        if (localJSONArray != null)
        {
          int j = localJSONArray.length();
          int i = 0;
          label110:
          if (i < j) {
            if (!TextUtils.equals(paramString, localJSONArray.optString(i))) {}
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label205;
            }
            paramString = new UserPermission((String)localObject, localJSONObject2.optString("name"));
            j = localJSONArray.length();
            i = 0;
            for (;;)
            {
              localObject = paramString;
              if (i >= j) {
                break;
              }
              localObject = localJSONArray.optString(i);
              this.jdField_a_of_type_JavaUtilMap.put(localObject, paramString);
              i += 1;
            }
            i += 1;
            break label110;
          }
        }
      }
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/tencent/mobileqq/Doraemon/impl/DefaultDoraemonAppInfoHelper:jdField_a_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 26	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   17: ldc 200
    //   19: iconst_4
    //   20: invokevirtual 204	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   23: astore_3
    //   24: aload_3
    //   25: ldc 206
    //   27: aconst_null
    //   28: invokeinterface 212 3 0
    //   33: astore 4
    //   35: iconst_0
    //   36: istore_2
    //   37: iload_2
    //   38: istore_1
    //   39: aload 4
    //   41: ldc 214
    //   43: invokestatic 167	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   46: ifeq +52 -> 98
    //   49: aload_3
    //   50: ldc 216
    //   52: aconst_null
    //   53: invokeinterface 212 3 0
    //   58: astore 4
    //   60: iload_2
    //   61: istore_1
    //   62: aload 4
    //   64: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifne +31 -> 98
    //   70: aload_0
    //   71: aload 4
    //   73: invokespecial 222	com/tencent/mobileqq/Doraemon/impl/DefaultDoraemonAppInfoHelper:b	(Ljava/lang/String;)Z
    //   76: istore_2
    //   77: iload_2
    //   78: istore_1
    //   79: iload_2
    //   80: ifeq +18 -> 98
    //   83: aload_0
    //   84: aload_3
    //   85: ldc 224
    //   87: lconst_0
    //   88: invokeinterface 228 4 0
    //   93: putfield 52	com/tencent/mobileqq/Doraemon/impl/DefaultDoraemonAppInfoHelper:b	J
    //   96: iload_2
    //   97: istore_1
    //   98: iload_1
    //   99: ifne +45 -> 144
    //   102: ldc 177
    //   104: iconst_1
    //   105: ldc 230
    //   107: invokestatic 233	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: invokestatic 26	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   113: ldc 200
    //   115: invokestatic 235	com/tencent/mobileqq/Doraemon/impl/DefaultDoraemonAppInfoHelper:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_3
    //   119: aload_3
    //   120: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne +9 -> 132
    //   126: aload_0
    //   127: aload_3
    //   128: invokespecial 222	com/tencent/mobileqq/Doraemon/impl/DefaultDoraemonAppInfoHelper:b	(Ljava/lang/String;)Z
    //   131: istore_1
    //   132: iload_1
    //   133: ifne +11 -> 144
    //   136: ldc 177
    //   138: iconst_1
    //   139: ldc 237
    //   141: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload_0
    //   145: iconst_1
    //   146: putfield 43	com/tencent/mobileqq/Doraemon/impl/DefaultDoraemonAppInfoHelper:jdField_a_of_type_Boolean	Z
    //   149: goto -138 -> 11
    //   152: astore_3
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_3
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	DefaultDoraemonAppInfoHelper
    //   6	127	1	bool1	boolean
    //   36	61	2	bool2	boolean
    //   23	105	3	localObject1	Object
    //   152	4	3	localObject2	Object
    //   33	39	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	7	152	finally
    //   14	35	152	finally
    //   39	60	152	finally
    //   62	77	152	finally
    //   83	96	152	finally
    //   102	119	152	finally
    //   119	132	152	finally
    //   136	144	152	finally
    //   144	149	152	finally
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, DefaultDoraemonAppInfoHelper.OnGetAppInfo paramOnGetAppInfo)
  {
    MiniAppInfo localMiniAppInfo = MiniAppManager.a().a(paramString2, paramInt, 1, false, null, 1);
    paramString1 = localMiniAppInfo;
    if (localMiniAppInfo == null) {
      paramString1 = new MiniAppInfo(paramString2, paramInt);
    }
    Stream.of(paramString1).map(new ThreadOffFunction("DoraemonOpenAPI.permissionHelper", 16)).map(new DefaultDoraemonAppInfoHelper.EnsureInitJobSegment(null)).map(new VerifyUrlJobSegment(paramString3)).map(new DefaultDoraemonAppInfoHelper.GetAppAPIPermissionJobSegment(null)).map(new DefaultDoraemonAppInfoHelper.6(this, paramString2, paramInt)).map(new UIThreadOffFunction(null)).subscribe(new DefaultDoraemonAppInfoHelper.5(this, paramOnGetAppInfo));
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, DefaultDoraemonAppInfoHelper.OnGetAppInfo paramOnGetAppInfo)
  {
    paramString1 = MiniAppManager.a().a(paramString2, paramInt, 1, false, null, 1);
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
      label17:
      return;
    } else {
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label17;
      }
      Object localObject = localJSONObject.optJSONObject(String.valueOf((Integer)paramList.next()));
      if (localObject == null) {
        break;
      }
      localObject = ((JSONObject)localObject).optJSONArray("apis");
      if (localObject == null) {
        break;
      }
      int i = 0;
      int j = ((JSONArray)localObject).length();
      while (i < j)
      {
        paramSet.add(((JSONArray)localObject).optString(i));
        i += 1;
      }
    }
  }
  
  public void b()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (l > this.jdField_a_of_type_Long) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper
 * JD-Core Version:    0.7.0.1
 */