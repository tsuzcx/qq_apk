package com.tencent.mobileqq.activity.qwallet;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PasswdRedBagInfo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  public String c;
  @Deprecated
  public boolean c;
  public String d;
  public String e;
  public String f;
  
  public PasswdRedBagInfo() {}
  
  public PasswdRedBagInfo(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.d = paramString4;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public PasswdRedBagInfo(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramLong, paramString4, paramBoolean1, paramBoolean2, paramBoolean3, paramInt);
    this.e = paramString5;
  }
  
  public PasswdRedBagInfo(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString5, String paramString6)
  {
    this(paramString1, paramString2, paramString3, paramLong, paramString4, paramBoolean1, paramBoolean2, paramBoolean3, paramInt, paramString5);
    this.f = paramString6;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("-");
    if (paramString.length < 2) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < paramString.length) {}
      try
      {
        localJSONArray.put(Integer.parseInt(paramString[i]));
        label53:
        i += 1;
        continue;
        if (localJSONArray.length() > 0) {
          return localJSONArray.toString();
        }
        return "";
      }
      catch (Throwable localThrowable)
      {
        break label53;
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString)
  {
    paramString = a(paramString);
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      paramJSONObject.put("key_poem_rule", paramString);
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  public int a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("passwdredinfo", 2, "[getWordChainSubChannel] " + this.f);
      }
      int i = new JSONObject(this.f).optInt("key_sub_channel");
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("passwdredinfo", 1, QLog.getStackTraceString(localThrowable));
    }
    return -1;
  }
  
  /* Error */
  List<Integer> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 140	java/util/LinkedList
    //   5: dup
    //   6: invokespecial 141	java/util/LinkedList:<init>	()V
    //   9: astore 4
    //   11: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +31 -> 45
    //   17: ldc 109
    //   19: iconst_2
    //   20: new 111	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   27: ldc 143
    //   29: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 49	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:f	Ljava/lang/String;
    //   36: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 123	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: new 98	org/json/JSONObject
    //   48: dup
    //   49: aload_0
    //   50: getfield 49	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:f	Ljava/lang/String;
    //   53: invokespecial 126	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   56: ldc 96
    //   58: invokevirtual 146	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: astore_3
    //   62: aload_3
    //   63: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: ifne +65 -> 131
    //   69: new 70	org/json/JSONArray
    //   72: dup
    //   73: aload_3
    //   74: invokespecial 147	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   77: astore_3
    //   78: aload_3
    //   79: ifnull +85 -> 164
    //   82: aload_3
    //   83: invokevirtual 85	org/json/JSONArray:length	()I
    //   86: ifle +78 -> 164
    //   89: iconst_0
    //   90: istore_1
    //   91: aload_3
    //   92: invokevirtual 85	org/json/JSONArray:length	()I
    //   95: istore_2
    //   96: iload_1
    //   97: iload_2
    //   98: if_icmpge +66 -> 164
    //   101: aload_3
    //   102: iload_1
    //   103: invokevirtual 150	org/json/JSONArray:optInt	(I)I
    //   106: istore_2
    //   107: iload_2
    //   108: iconst_1
    //   109: if_icmple +15 -> 124
    //   112: aload 4
    //   114: iload_2
    //   115: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: invokeinterface 160 2 0
    //   123: pop
    //   124: iload_1
    //   125: iconst_1
    //   126: iadd
    //   127: istore_1
    //   128: goto -37 -> 91
    //   131: aconst_null
    //   132: astore_3
    //   133: goto -55 -> 78
    //   136: astore 5
    //   138: ldc 109
    //   140: iconst_1
    //   141: aload 5
    //   143: iconst_0
    //   144: anewarray 4	java/lang/Object
    //   147: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   150: goto -26 -> 124
    //   153: astore_3
    //   154: ldc 109
    //   156: iconst_1
    //   157: aload_3
    //   158: invokestatic 135	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   161: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload 4
    //   166: invokeinterface 166 1 0
    //   171: ifgt +15 -> 186
    //   174: aload 4
    //   176: iconst_0
    //   177: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: invokeinterface 160 2 0
    //   185: pop
    //   186: aload_0
    //   187: monitorexit
    //   188: aload 4
    //   190: areturn
    //   191: astore_3
    //   192: aload_0
    //   193: monitorexit
    //   194: aload_3
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	PasswdRedBagInfo
    //   90	38	1	i	int
    //   95	20	2	j	int
    //   61	72	3	localObject1	Object
    //   153	5	3	localThrowable1	Throwable
    //   191	4	3	localObject2	Object
    //   9	180	4	localLinkedList	java.util.LinkedList
    //   136	6	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   101	107	136	java/lang/Throwable
    //   112	124	136	java/lang/Throwable
    //   11	45	153	java/lang/Throwable
    //   45	78	153	java/lang/Throwable
    //   82	89	153	java/lang/Throwable
    //   91	96	153	java/lang/Throwable
    //   138	150	153	java/lang/Throwable
    //   2	11	191	finally
    //   11	45	191	finally
    //   45	78	191	finally
    //   82	89	191	finally
    //   91	96	191	finally
    //   101	107	191	finally
    //   112	124	191	finally
    //   138	150	191	finally
    //   154	164	191	finally
    //   164	186	191	finally
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Long < NetConnInfoCenter.getServerTime();
  }
  
  public boolean a(int paramInt)
  {
    boolean bool1 = false;
    try
    {
      List localList = a();
      if (!localList.contains(Integer.valueOf(paramInt)))
      {
        boolean bool2 = localList.contains(Integer.valueOf(0));
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("passwdredinfo", 1, localThrowable, new Object[0]);
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof PasswdRedBagInfo))
    {
      paramObject = (PasswdRedBagInfo)paramObject;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label24;
      }
    }
    label24:
    while (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagInfo
 * JD-Core Version:    0.7.0.1
 */