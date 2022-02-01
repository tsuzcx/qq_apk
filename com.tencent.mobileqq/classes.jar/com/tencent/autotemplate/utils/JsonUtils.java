package com.tencent.autotemplate.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.tencent.autotemplate.parse.RhythmDataBean;

public class JsonUtils
{
  public static final String KEY_BGM = "bgm";
  public static final String KEY_EFFECTS = "effects";
  public static final String KEY_FILTERS = "filters";
  public static final String KEY_FONTS = "fonts";
  public static final String KEY_IMAGE_DURATIONS = "imageDurations";
  public static final String KEY_OVERLAYS = "overlays";
  public static final String KEY_TRANSITIONS = "transitions";
  public static final String KEY_VOLUME_EFFECTS = "volumeEffects";
  public static final String TAG = "JsonUtils";
  
  public static void confirmValueIsArray(JsonObject paramJsonObject, String paramString)
  {
    if (paramJsonObject != null)
    {
      if (paramString == null) {
        return;
      }
      JsonElement localJsonElement = paramJsonObject.get(paramString);
      if (localJsonElement == null) {
        return;
      }
      if (localJsonElement.isJsonArray()) {
        return;
      }
      JsonArray localJsonArray = new JsonArray();
      localJsonArray.add(localJsonElement);
      paramJsonObject.remove(paramString);
      paramJsonObject.add(paramString, localJsonArray);
    }
  }
  
  public static String encodeObjectToJsonString(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new GsonBuilder().create().toJson(paramObject);
  }
  
  /* Error */
  public static String loadJsonString(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: ldc 84
    //   5: invokevirtual 90	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   8: ifeq +24 -> 32
    //   11: aload_0
    //   12: ifnull +20 -> 32
    //   15: aload_0
    //   16: invokevirtual 96	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   19: aload_1
    //   20: bipush 9
    //   22: invokevirtual 100	java/lang/String:substring	(I)Ljava/lang/String;
    //   25: invokevirtual 106	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   28: astore_0
    //   29: goto +12 -> 41
    //   32: new 108	java/io/FileInputStream
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   40: astore_0
    //   41: aload_0
    //   42: ifnonnull +20 -> 62
    //   45: aload_0
    //   46: ifnull +14 -> 60
    //   49: aload_0
    //   50: invokevirtual 116	java/io/InputStream:close	()V
    //   53: aconst_null
    //   54: areturn
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   60: aconst_null
    //   61: areturn
    //   62: new 121	java/io/BufferedReader
    //   65: dup
    //   66: new 123	java/io/InputStreamReader
    //   69: dup
    //   70: aload_0
    //   71: ldc 125
    //   73: invokestatic 131	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   76: invokespecial 134	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   79: invokespecial 137	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   82: astore_3
    //   83: new 139	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   90: astore_1
    //   91: aload_3
    //   92: invokevirtual 144	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   95: astore_2
    //   96: aload_2
    //   97: ifnull +12 -> 109
    //   100: aload_1
    //   101: aload_2
    //   102: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: goto -15 -> 91
    //   109: aload_1
    //   110: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: astore_1
    //   114: aload_3
    //   115: invokevirtual 152	java/io/BufferedReader:close	()V
    //   118: aload_0
    //   119: ifnull +14 -> 133
    //   122: aload_0
    //   123: invokevirtual 116	java/io/InputStream:close	()V
    //   126: aload_1
    //   127: areturn
    //   128: astore_0
    //   129: aload_0
    //   130: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   133: aload_1
    //   134: areturn
    //   135: astore_1
    //   136: aload_3
    //   137: astore_2
    //   138: goto +66 -> 204
    //   141: astore_2
    //   142: aload_3
    //   143: astore_1
    //   144: goto +24 -> 168
    //   147: astore_1
    //   148: goto +56 -> 204
    //   151: astore_2
    //   152: aconst_null
    //   153: astore_1
    //   154: goto +14 -> 168
    //   157: astore_1
    //   158: aconst_null
    //   159: astore_0
    //   160: goto +44 -> 204
    //   163: astore_2
    //   164: aconst_null
    //   165: astore_1
    //   166: aload_1
    //   167: astore_0
    //   168: aload_2
    //   169: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   172: aload_1
    //   173: ifnull +10 -> 183
    //   176: aload_1
    //   177: invokevirtual 152	java/io/BufferedReader:close	()V
    //   180: goto +3 -> 183
    //   183: aload_0
    //   184: ifnull +13 -> 197
    //   187: aload_0
    //   188: invokevirtual 116	java/io/InputStream:close	()V
    //   191: aconst_null
    //   192: areturn
    //   193: aload_0
    //   194: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   197: aconst_null
    //   198: areturn
    //   199: astore_3
    //   200: aload_1
    //   201: astore_2
    //   202: aload_3
    //   203: astore_1
    //   204: aload_2
    //   205: ifnull +10 -> 215
    //   208: aload_2
    //   209: invokevirtual 152	java/io/BufferedReader:close	()V
    //   212: goto +3 -> 215
    //   215: aload_0
    //   216: ifnull +14 -> 230
    //   219: aload_0
    //   220: invokevirtual 116	java/io/InputStream:close	()V
    //   223: goto +7 -> 230
    //   226: aload_0
    //   227: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   230: goto +5 -> 235
    //   233: aload_1
    //   234: athrow
    //   235: goto -2 -> 233
    //   238: astore_0
    //   239: goto -46 -> 193
    //   242: astore_0
    //   243: goto -17 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramContext	Context
    //   0	246	1	paramString	String
    //   1	137	2	localObject1	Object
    //   141	1	2	localIOException1	java.io.IOException
    //   151	1	2	localIOException2	java.io.IOException
    //   163	6	2	localIOException3	java.io.IOException
    //   201	8	2	str	String
    //   82	61	3	localBufferedReader	java.io.BufferedReader
    //   199	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   49	53	55	java/io/IOException
    //   114	118	128	java/io/IOException
    //   122	126	128	java/io/IOException
    //   83	91	135	finally
    //   91	96	135	finally
    //   100	106	135	finally
    //   109	114	135	finally
    //   83	91	141	java/io/IOException
    //   91	96	141	java/io/IOException
    //   100	106	141	java/io/IOException
    //   109	114	141	java/io/IOException
    //   62	83	147	finally
    //   62	83	151	java/io/IOException
    //   2	11	157	finally
    //   15	29	157	finally
    //   32	41	157	finally
    //   2	11	163	java/io/IOException
    //   15	29	163	java/io/IOException
    //   32	41	163	java/io/IOException
    //   168	172	199	finally
    //   176	180	238	java/io/IOException
    //   187	191	238	java/io/IOException
    //   208	212	242	java/io/IOException
    //   219	223	242	java/io/IOException
  }
  
  public static Object parseObjectFromFile(Context paramContext, String paramString, Class paramClass)
  {
    paramContext = loadJsonString(paramContext, paramString);
    if ((paramContext != null) && (!TextUtils.isEmpty(paramContext)))
    {
      paramContext = new JsonParser().parse(paramContext).getAsJsonObject();
      confirmValueIsArray(paramContext, "fonts");
      confirmValueIsArray(paramContext, "imageDurations");
      confirmValueIsArray(paramContext, "volumeEffects");
      confirmValueIsArray(paramContext, "transitions");
      paramString = paramContext.get("bgm");
      if ((paramString != null) && (paramString.isJsonObject()))
      {
        confirmValueIsArray(paramString.getAsJsonObject(), "volumeEffects");
        paramContext.remove("bgm");
        paramContext.add("bgm", paramString);
      }
      paramString = paramContext.get("effects");
      if ((paramString != null) && (paramString.isJsonObject()))
      {
        confirmValueIsArray(paramString.getAsJsonObject(), "filters");
        confirmValueIsArray(paramString.getAsJsonObject(), "overlays");
        paramContext.remove("effects");
        paramContext.add("effects", paramString);
      }
      paramString = new GsonBuilder().create();
      try
      {
        paramContext = paramString.fromJson(paramContext.toString(), paramClass);
        return paramContext;
      }
      catch (JsonSyntaxException paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    Log.e("JsonUtils", "parseObjectFromFile: get json string failed");
    return null;
  }
  
  public static Object parseObjectFromJsonString(String paramString, Class paramClass)
  {
    Gson localGson = new GsonBuilder().create();
    try
    {
      paramString = localGson.fromJson(paramString, paramClass);
      return paramString;
    }
    catch (JsonSyntaxException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static RhythmDataBean parseRhythmTemplate(Context paramContext, String paramString)
  {
    paramContext = loadJsonString(paramContext, paramString);
    if ((paramContext != null) && (!TextUtils.isEmpty(paramContext)))
    {
      paramString = new GsonBuilder().create();
      try
      {
        paramContext = (RhythmDataBean)paramString.fromJson(paramContext, RhythmDataBean.class);
        return paramContext;
      }
      catch (JsonSyntaxException paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    Log.e("JsonUtils", "parseObjectFromFile: get json string failed");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.utils.JsonUtils
 * JD-Core Version:    0.7.0.1
 */