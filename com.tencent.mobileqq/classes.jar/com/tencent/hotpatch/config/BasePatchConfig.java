package com.tencent.hotpatch.config;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BasePatchConfig
{
  public int a;
  public String a;
  public Set a;
  public boolean a;
  public int b;
  public String b;
  public Set b;
  public String c;
  public Set c;
  public String d;
  
  public BasePatchConfig()
  {
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_c_of_type_JavaUtilSet = new HashSet();
  }
  
  public static final String a(String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = new JSONObject(paramString).optString("patchType", null);
      return paramString;
    }
    catch (JSONException localJSONException)
    {
      do
      {
        paramString = localObject;
      } while (!QLog.isColorLevel());
      QLog.e("PatchLogTag", 2, "BasePatchConfig getPatchType", localJSONException);
    }
    return null;
  }
  
  public String a()
  {
    Iterator localIterator;
    Object localObject;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("enable", this.jdField_a_of_type_Boolean);
      localJSONObject.put("patchVersion", this.jdField_a_of_type_Int);
      localJSONObject.put("appVersion", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("revision", this.jdField_b_of_type_JavaLangString);
      localStringBuilder = new StringBuilder("");
      if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.size() > 0))
      {
        localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localStringBuilder.append((String)localObject).append(";");
          }
        }
      }
      localJSONException.put("process", localStringBuilder.toString());
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PatchLogTag", 2, "BasePatchConfig writeToJsonString", localJSONException);
      }
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((this.jdField_b_of_type_JavaUtilSet != null) && (this.jdField_b_of_type_JavaUtilSet.size() > 0))
    {
      localIterator = this.jdField_b_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (Integer)localIterator.next();
        if (localObject != null) {
          localStringBuilder.append(((Integer)localObject).toString()).append(";");
        }
      }
    }
    localJSONException.put("systemVersion", localStringBuilder.toString());
    localStringBuilder = new StringBuilder("");
    if ((this.jdField_c_of_type_JavaUtilSet != null) && (this.jdField_c_of_type_JavaUtilSet.size() > 0))
    {
      localIterator = this.jdField_c_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localStringBuilder.append((String)localObject).append(";");
        }
      }
    }
    localJSONException.put("deviceInfo", localStringBuilder.toString());
    String str = localJSONException.toString();
    return str;
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 31	org/json/JSONObject
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 34	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_0
    //   13: aload_1
    //   14: ldc 58
    //   16: iconst_0
    //   17: invokevirtual 141	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   20: putfield 60	com/tencent/hotpatch/config/BasePatchConfig:jdField_a_of_type_Boolean	Z
    //   23: aload_0
    //   24: aload_1
    //   25: ldc 66
    //   27: iconst_0
    //   28: invokevirtual 145	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   31: putfield 68	com/tencent/hotpatch/config/BasePatchConfig:jdField_a_of_type_Int	I
    //   34: aload_0
    //   35: aload_1
    //   36: ldc 73
    //   38: aconst_null
    //   39: invokevirtual 40	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   42: putfield 75	com/tencent/hotpatch/config/BasePatchConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   45: aload_0
    //   46: aload_1
    //   47: ldc 80
    //   49: aconst_null
    //   50: invokevirtual 40	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   53: putfield 82	com/tencent/hotpatch/config/BasePatchConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   56: aload_1
    //   57: ldc 124
    //   59: ldc 86
    //   61: invokevirtual 40	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   64: ldc 120
    //   66: invokevirtual 149	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   69: astore 6
    //   71: aload 6
    //   73: ifnull +49 -> 122
    //   76: aload 6
    //   78: arraylength
    //   79: ifle +43 -> 122
    //   82: aload 6
    //   84: arraylength
    //   85: istore_3
    //   86: iconst_0
    //   87: istore_2
    //   88: iload_2
    //   89: iload_3
    //   90: if_icmpge +32 -> 122
    //   93: aload 6
    //   95: iload_2
    //   96: aaload
    //   97: astore 7
    //   99: aload 7
    //   101: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifne +173 -> 277
    //   107: aload_0
    //   108: getfield 21	com/tencent/hotpatch/config/BasePatchConfig:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   111: aload 7
    //   113: invokeinterface 153 2 0
    //   118: pop
    //   119: goto +158 -> 277
    //   122: aload_1
    //   123: ldc 132
    //   125: ldc 86
    //   127: invokevirtual 40	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   130: ldc 120
    //   132: invokevirtual 149	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   135: astore 6
    //   137: aload 6
    //   139: ifnull +55 -> 194
    //   142: aload 6
    //   144: arraylength
    //   145: ifle +49 -> 194
    //   148: aload 6
    //   150: arraylength
    //   151: istore 5
    //   153: iconst_0
    //   154: istore_2
    //   155: iload_2
    //   156: iload 5
    //   158: if_icmpge +36 -> 194
    //   161: aload 6
    //   163: iload_2
    //   164: aaload
    //   165: astore 7
    //   167: aload 7
    //   169: invokestatic 157	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   172: istore_3
    //   173: iload_3
    //   174: ifle +110 -> 284
    //   177: aload_0
    //   178: getfield 23	com/tencent/hotpatch/config/BasePatchConfig:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   181: iload_3
    //   182: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: invokeinterface 153 2 0
    //   190: pop
    //   191: goto +93 -> 284
    //   194: aload_1
    //   195: ldc 134
    //   197: ldc 86
    //   199: invokevirtual 40	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   202: ldc 120
    //   204: invokevirtual 149	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   207: astore_1
    //   208: aload_1
    //   209: ifnull +67 -> 276
    //   212: aload_1
    //   213: arraylength
    //   214: ifle +62 -> 276
    //   217: aload_1
    //   218: arraylength
    //   219: istore_3
    //   220: iload 4
    //   222: istore_2
    //   223: iload_2
    //   224: iload_3
    //   225: if_icmpge +51 -> 276
    //   228: aload_1
    //   229: iload_2
    //   230: aaload
    //   231: astore 6
    //   233: aload 6
    //   235: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   238: ifne +15 -> 253
    //   241: aload_0
    //   242: getfield 25	com/tencent/hotpatch/config/BasePatchConfig:jdField_c_of_type_JavaUtilSet	Ljava/util/Set;
    //   245: aload 6
    //   247: invokeinterface 153 2 0
    //   252: pop
    //   253: iload_2
    //   254: iconst_1
    //   255: iadd
    //   256: istore_2
    //   257: goto -34 -> 223
    //   260: astore_1
    //   261: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +12 -> 276
    //   267: ldc 48
    //   269: iconst_2
    //   270: ldc 163
    //   272: aload_1
    //   273: invokestatic 54	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   276: return
    //   277: iload_2
    //   278: iconst_1
    //   279: iadd
    //   280: istore_2
    //   281: goto -193 -> 88
    //   284: iload_2
    //   285: iconst_1
    //   286: iadd
    //   287: istore_2
    //   288: goto -133 -> 155
    //   291: astore 7
    //   293: iconst_0
    //   294: istore_3
    //   295: goto -122 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	BasePatchConfig
    //   0	298	1	paramString	String
    //   87	201	2	i	int
    //   85	210	3	j	int
    //   1	220	4	k	int
    //   151	8	5	m	int
    //   69	177	6	arrayOfString	String[]
    //   97	71	7	str	String
    //   291	1	7	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   3	71	260	org/json/JSONException
    //   76	86	260	org/json/JSONException
    //   99	119	260	org/json/JSONException
    //   122	137	260	org/json/JSONException
    //   142	153	260	org/json/JSONException
    //   167	173	260	org/json/JSONException
    //   177	191	260	org/json/JSONException
    //   194	208	260	org/json/JSONException
    //   212	220	260	org/json/JSONException
    //   233	253	260	org/json/JSONException
    //   167	173	291	java/lang/NumberFormatException
  }
  
  public boolean a(Context paramContext, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("PatchLogTag", 1, "BasePatchConfig isValidConfig enable is false");
      return false;
    }
    if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilSet.size() > 0) && (!this.jdField_a_of_type_JavaUtilSet.contains(BaseApplicationImpl.processName)))
    {
      QLog.d("PatchLogTag", 1, "BasePatchConfig isValidConfig process not match");
      return false;
    }
    if (!"351230".equals(this.jdField_b_of_type_JavaLangString))
    {
      QLog.d("PatchLogTag", 1, "BasePatchConfig isValidConfig revision not match");
      return false;
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      QLog.d("PatchLogTag", 1, "BasePatchConfig isValidConfig patchName is null");
      return false;
    }
    if (TextUtils.isEmpty(this.d))
    {
      QLog.d("PatchLogTag", 1, "BasePatchConfig isValidConfig patchUrl is null");
      return false;
    }
    if (this.jdField_b_of_type_Int <= 0)
    {
      QLog.d("PatchLogTag", 1, "BasePatchConfig isValidConfig patchSize is invalid");
      return false;
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.equals(ApkUtils.a(paramContext) + "." + ApkUtils.a(paramContext))))
    {
      QLog.d("PatchLogTag", 1, "BasePatchConfig isValidConfig app version not match");
      return false;
    }
    if ((this.jdField_b_of_type_JavaUtilSet.size() > 0) && (!this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(Build.VERSION.SDK_INT))))
    {
      QLog.d("PatchLogTag", 1, "BasePatchConfig isValidConfig system version not match");
      return false;
    }
    if ((this.jdField_c_of_type_JavaUtilSet.size() > 0) && (!this.jdField_c_of_type_JavaUtilSet.contains(Build.BRAND + "-" + Build.MODEL)))
    {
      QLog.d("PatchLogTag", 1, "BasePatchConfig isValidConfig device info not match");
      return false;
    }
    QLog.d("PatchLogTag", 1, "BasePatchConfig isValidConfig return true");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hotpatch.config.BasePatchConfig
 * JD-Core Version:    0.7.0.1
 */