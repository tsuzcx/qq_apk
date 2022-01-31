package com.tencent.mobileqq.Doraemon.impl;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.AppInfo;
import com.tencent.mobileqq.Doraemon.UserPermission;
import com.tencent.mobileqq.app.ThreadManager;
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
import rei;
import rej;
import rek;
import rel;
import rem;
import ren;
import rep;

public class DefaultDoraemonAppInfoHelper
{
  private static DefaultDoraemonAppInfoHelper a;
  public long a;
  public final Object a;
  public Map a;
  public JSONObject a;
  public boolean a;
  public long b;
  public Map b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper = new DefaultDoraemonAppInfoHelper();
    Bosses.init(BaseApplicationImpl.getApplication());
  }
  
  public DefaultDoraemonAppInfoHelper()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
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
    //   2: new 56	java/io/InputStreamReader
    //   5: dup
    //   6: aload_0
    //   7: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   10: invokevirtual 68	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   13: aload_1
    //   14: invokevirtual 74	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: invokespecial 77	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore_0
    //   23: new 79	java/io/BufferedReader
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 82	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_2
    //   32: aload_1
    //   33: astore_0
    //   34: new 84	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   41: astore 4
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: invokevirtual 89	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnull +47 -> 100
    //   56: aload_1
    //   57: astore_0
    //   58: aload 4
    //   60: aload 5
    //   62: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: astore_0
    //   68: aload 4
    //   70: bipush 10
    //   72: invokevirtual 96	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: goto -33 -> 43
    //   79: astore_2
    //   80: aload_1
    //   81: astore_0
    //   82: aload_2
    //   83: invokevirtual 99	java/lang/Exception:printStackTrace	()V
    //   86: aload_3
    //   87: astore_0
    //   88: aload_1
    //   89: ifnull +9 -> 98
    //   92: aload_1
    //   93: invokevirtual 102	java/io/InputStreamReader:close	()V
    //   96: aload_3
    //   97: astore_0
    //   98: aload_0
    //   99: areturn
    //   100: aload_1
    //   101: astore_0
    //   102: aload 4
    //   104: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore_2
    //   108: aload_2
    //   109: astore_0
    //   110: aload_1
    //   111: ifnull -13 -> 98
    //   114: aload_1
    //   115: invokevirtual 102	java/io/InputStreamReader:close	()V
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
    //   131: invokevirtual 102	java/io/InputStreamReader:close	()V
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
    //   3: getfield 37	com/tencent/mobileqq/Doraemon/impl/DefaultDoraemonAppInfoHelper:jdField_a_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 25	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   17: ldc 196
    //   19: iconst_4
    //   20: invokevirtual 200	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   23: astore_3
    //   24: aload_3
    //   25: ldc 202
    //   27: aconst_null
    //   28: invokeinterface 208 3 0
    //   33: astore 4
    //   35: iconst_0
    //   36: istore_1
    //   37: aload 4
    //   39: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifne +31 -> 73
    //   45: aload_0
    //   46: aload 4
    //   48: invokespecial 214	com/tencent/mobileqq/Doraemon/impl/DefaultDoraemonAppInfoHelper:b	(Ljava/lang/String;)Z
    //   51: istore_2
    //   52: iload_2
    //   53: istore_1
    //   54: iload_2
    //   55: ifeq +18 -> 73
    //   58: aload_0
    //   59: aload_3
    //   60: ldc 216
    //   62: lconst_0
    //   63: invokeinterface 220 4 0
    //   68: putfield 48	com/tencent/mobileqq/Doraemon/impl/DefaultDoraemonAppInfoHelper:jdField_b_of_type_Long	J
    //   71: iload_2
    //   72: istore_1
    //   73: iload_1
    //   74: ifne +45 -> 119
    //   77: ldc 173
    //   79: iconst_1
    //   80: ldc 222
    //   82: invokestatic 225	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: invokestatic 25	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   88: ldc 196
    //   90: invokestatic 227	com/tencent/mobileqq/Doraemon/impl/DefaultDoraemonAppInfoHelper:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   93: astore_3
    //   94: aload_3
    //   95: invokestatic 212	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   98: ifne +9 -> 107
    //   101: aload_0
    //   102: aload_3
    //   103: invokespecial 214	com/tencent/mobileqq/Doraemon/impl/DefaultDoraemonAppInfoHelper:b	(Ljava/lang/String;)Z
    //   106: istore_1
    //   107: iload_1
    //   108: ifne +11 -> 119
    //   111: ldc 173
    //   113: iconst_1
    //   114: ldc 229
    //   116: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   119: aload_0
    //   120: iconst_1
    //   121: putfield 37	com/tencent/mobileqq/Doraemon/impl/DefaultDoraemonAppInfoHelper:jdField_a_of_type_Boolean	Z
    //   124: goto -113 -> 11
    //   127: astore_3
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_3
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	DefaultDoraemonAppInfoHelper
    //   6	102	1	bool1	boolean
    //   51	21	2	bool2	boolean
    //   23	80	3	localObject1	Object
    //   127	4	3	localObject2	Object
    //   33	14	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	7	127	finally
    //   14	35	127	finally
    //   37	52	127	finally
    //   58	71	127	finally
    //   77	94	127	finally
    //   94	107	127	finally
    //   111	119	127	finally
    //   119	124	127	finally
  }
  
  public void a(String paramString1, int paramInt, String paramString2, DefaultDoraemonAppInfoHelper.OnGetAppInfo paramOnGetAppInfo)
  {
    rem localrem = (rem)this.jdField_b_of_type_JavaUtilMap.get(paramString1);
    if ((localrem != null) && (localrem.jdField_a_of_type_Long > NetConnInfoCenter.getServerTimeMillis()))
    {
      ThreadManager.getUIHandler().post(new rej(this, paramOnGetAppInfo, localrem));
      return;
    }
    localrem = new rem(null);
    localrem.jdField_a_of_type_ComTencentMobileqqDoraemonAppInfo = new AppInfo();
    localrem.jdField_a_of_type_ComTencentMobileqqDoraemonAppInfo.jdField_a_of_type_Int = paramInt;
    localrem.jdField_a_of_type_ComTencentMobileqqDoraemonAppInfo.jdField_a_of_type_JavaLangString = paramString2;
    Stream.of(localrem).map(new ThreadOffFunction(16)).map(new rel(this)).map(new ren(null)).map(new rep(null)).map(new UIThreadOffFunction(null)).subscribe(new rek(this, paramString1, paramOnGetAppInfo));
  }
  
  public void a(List paramList, Set paramSet)
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
        ThreadManager.post(new rei(this), 5, null, false);
        return;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper
 * JD-Core Version:    0.7.0.1
 */