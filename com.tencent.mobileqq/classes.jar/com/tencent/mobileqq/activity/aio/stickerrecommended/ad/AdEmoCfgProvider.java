package com.tencent.mobileqq.activity.aio.stickerrecommended.ad;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdEmoCfgProvider
{
  public static volatile AdEmoCfg a;
  
  public static AdEmoCfg a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null)) {
      try
      {
        if (a == null)
        {
          paramContext = paramContext.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("RECOMMENDED_STICKER_AD_CFG");
          localStringBuilder.append(paramString);
          paramString = paramContext.getString(localStringBuilder.toString(), null);
          boolean bool = TextUtils.isEmpty(paramString);
          if (bool) {
            return null;
          }
          try
          {
            paramContext = new JSONObject(paramString);
          }
          catch (Exception paramContext)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getAdEmoCfg has exception，cfgStr = ");
            localStringBuilder.append(paramString);
            QLog.e("AdEmoCfgProvider", 2, localStringBuilder.toString(), paramContext);
            paramContext = null;
          }
          if (paramContext != null) {
            a = a(paramContext);
          }
        }
        paramContext = a;
        return paramContext;
      }
      finally {}
    }
    return null;
  }
  
  /* Error */
  public static AdEmoCfg a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: new 71	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 72	java/util/ArrayList:<init>	()V
    //   7: astore 7
    //   9: iconst_0
    //   10: istore_3
    //   11: aload_0
    //   12: ldc 74
    //   14: invokevirtual 78	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   17: ifeq +21 -> 38
    //   20: aload_0
    //   21: ldc 74
    //   23: invokevirtual 82	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   26: istore_1
    //   27: iconst_1
    //   28: istore 4
    //   30: iload_1
    //   31: iconst_1
    //   32: if_icmpne +6 -> 38
    //   35: goto +6 -> 41
    //   38: iconst_0
    //   39: istore 4
    //   41: aload_0
    //   42: ldc 84
    //   44: invokevirtual 78	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   47: ifeq +13 -> 60
    //   50: aload_0
    //   51: ldc 84
    //   53: invokevirtual 82	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   56: istore_1
    //   57: goto +5 -> 62
    //   60: iconst_0
    //   61: istore_1
    //   62: iload_1
    //   63: istore_2
    //   64: iload 4
    //   66: istore 5
    //   68: aload_0
    //   69: ldc 86
    //   71: invokevirtual 78	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   74: ifeq +124 -> 198
    //   77: aload_0
    //   78: ldc 86
    //   80: invokevirtual 90	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   83: astore 6
    //   85: iload_1
    //   86: istore_2
    //   87: iload 4
    //   89: istore 5
    //   91: iload_3
    //   92: aload 6
    //   94: invokevirtual 96	org/json/JSONArray:length	()I
    //   97: if_icmpge +101 -> 198
    //   100: aload 6
    //   102: iload_3
    //   103: invokevirtual 100	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   106: invokestatic 103	com/tencent/mobileqq/activity/aio/stickerrecommended/ad/AdEmoCfgProvider:a	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/activity/aio/stickerrecommended/ad/AdItem;
    //   109: astore 8
    //   111: aload 8
    //   113: ifnull +13 -> 126
    //   116: aload 7
    //   118: aload 8
    //   120: invokeinterface 109 2 0
    //   125: pop
    //   126: iload_3
    //   127: iconst_1
    //   128: iadd
    //   129: istore_3
    //   130: goto -45 -> 85
    //   133: astore 6
    //   135: goto +17 -> 152
    //   138: astore 6
    //   140: iconst_0
    //   141: istore_1
    //   142: goto +10 -> 152
    //   145: astore 6
    //   147: iconst_0
    //   148: istore_1
    //   149: iconst_0
    //   150: istore 4
    //   152: new 26	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   159: astore 8
    //   161: aload 8
    //   163: ldc 111
    //   165: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 8
    //   171: aload_0
    //   172: invokevirtual 112	org/json/JSONObject:toString	()Ljava/lang/String;
    //   175: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: ldc 58
    //   181: iconst_2
    //   182: aload 8
    //   184: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: aload 6
    //   189: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   192: iload 4
    //   194: istore 5
    //   196: iload_1
    //   197: istore_2
    //   198: new 114	com/tencent/mobileqq/activity/aio/stickerrecommended/ad/AdEmoCfg
    //   201: dup
    //   202: iload 5
    //   204: iload_2
    //   205: aload 7
    //   207: invokespecial 117	com/tencent/mobileqq/activity/aio/stickerrecommended/ad/AdEmoCfg:<init>	(ZILjava/util/List;)V
    //   210: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramJSONObject	JSONObject
    //   26	171	1	i	int
    //   63	142	2	j	int
    //   10	120	3	k	int
    //   28	165	4	bool1	boolean
    //   66	137	5	bool2	boolean
    //   83	18	6	localJSONArray	JSONArray
    //   133	1	6	localJSONException1	JSONException
    //   138	1	6	localJSONException2	JSONException
    //   145	43	6	localJSONException3	JSONException
    //   7	199	7	localArrayList	ArrayList
    //   109	74	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   68	85	133	org/json/JSONException
    //   91	111	133	org/json/JSONException
    //   116	126	133	org/json/JSONException
    //   41	57	138	org/json/JSONException
    //   11	27	145	org/json/JSONException
  }
  
  public static AdItem a(JSONObject paramJSONObject)
  {
    localArrayList1 = new ArrayList();
    localArrayList2 = new ArrayList();
    try
    {
      JSONArray localJSONArray;
      int i;
      if (paramJSONObject.has("keyWords"))
      {
        localJSONArray = paramJSONObject.getJSONArray("keyWords");
        i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList1.add(localJSONArray.getString(i));
          i += 1;
        }
      }
      Object localObject1;
      if (paramJSONObject.has("emos"))
      {
        localJSONArray = paramJSONObject.getJSONArray("emos");
        i = 0;
        while (i < localJSONArray.length())
        {
          Object localObject2 = localJSONArray.getJSONObject(i);
          localObject1 = ((JSONObject)localObject2).optString("imgUrl", "");
          String str1 = ((JSONObject)localObject2).optString("md5", "");
          long l = ((JSONObject)localObject2).optLong("fileSize", 0L);
          int j = ((JSONObject)localObject2).optInt("width", 0);
          int k = ((JSONObject)localObject2).optInt("height", 0);
          String str2 = ((JSONObject)localObject2).optString("jumpUrl", "");
          localObject2 = ((JSONObject)localObject2).optString("desc", "");
          AdEmoItem localAdEmoItem = new AdEmoItem();
          localAdEmoItem.jdField_a_of_type_JavaLangString = ((String)localObject1);
          localAdEmoItem.jdField_b_of_type_JavaLangString = str1;
          localAdEmoItem.jdField_a_of_type_Long = Long.valueOf(l).longValue();
          localAdEmoItem.jdField_a_of_type_Int = j;
          localAdEmoItem.jdField_b_of_type_Int = k;
          localAdEmoItem.c = str2;
          localAdEmoItem.d = ((String)localObject2);
          localArrayList2.add(localAdEmoItem);
          i += 1;
        }
      }
      return new AdItem(localArrayList1, localArrayList2);
    }
    catch (JSONException localJSONException)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseAdItemJson has exception， adObject = ");
      ((StringBuilder)localObject1).append(paramJSONObject.toString());
      QLog.e("AdEmoCfgProvider", 2, ((StringBuilder)localObject1).toString(), localJSONException);
    }
  }
  
  public static void a(Context paramContext, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateCfgStr, cfgJsonObject = ");
        if (paramJSONObject == null) {
          localObject = "null";
        } else {
          localObject = paramJSONObject.toString();
        }
        localStringBuilder.append((String)localObject);
        QLog.d("AdEmoCfgProvider", 2, localStringBuilder.toString());
      }
      if (paramJSONObject != null)
      {
        a = a(paramJSONObject);
        if (paramContext != null)
        {
          paramContext = paramContext.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("RECOMMENDED_STICKER_AD_CFG");
          ((StringBuilder)localObject).append(paramString);
          paramContext.putString(((StringBuilder)localObject).toString(), paramJSONObject.toString()).apply();
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.ad.AdEmoCfgProvider
 * JD-Core Version:    0.7.0.1
 */