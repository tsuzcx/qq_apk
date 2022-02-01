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
    if ((paramJsonObject == null) || (paramString == null)) {}
    JsonElement localJsonElement;
    do
    {
      return;
      localJsonElement = paramJsonObject.get(paramString);
    } while ((localJsonElement == null) || (localJsonElement.isJsonArray()));
    JsonArray localJsonArray = new JsonArray();
    localJsonArray.add(localJsonElement);
    paramJsonObject.remove(paramString);
    paramJsonObject.add(paramString, localJsonArray);
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
    //   1: astore 5
    //   3: aload_1
    //   4: ldc 84
    //   6: invokevirtual 90	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9: ifeq +56 -> 65
    //   12: aload_0
    //   13: ifnull +52 -> 65
    //   16: aload_0
    //   17: invokevirtual 96	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   20: aload_1
    //   21: ldc 84
    //   23: invokevirtual 100	java/lang/String:length	()I
    //   26: invokevirtual 104	java/lang/String:substring	(I)Ljava/lang/String;
    //   29: invokevirtual 110	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   32: astore_0
    //   33: aload_0
    //   34: ifnonnull +93 -> 127
    //   37: iconst_0
    //   38: ifeq +11 -> 49
    //   41: new 112	java/lang/NullPointerException
    //   44: dup
    //   45: invokespecial 113	java/lang/NullPointerException:<init>	()V
    //   48: athrow
    //   49: aload 5
    //   51: astore_1
    //   52: aload_0
    //   53: ifnull +10 -> 63
    //   56: aload_0
    //   57: invokevirtual 118	java/io/InputStream:close	()V
    //   60: aload 5
    //   62: astore_1
    //   63: aload_1
    //   64: areturn
    //   65: new 120	java/io/FileInputStream
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 123	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   73: astore_0
    //   74: goto -41 -> 33
    //   77: astore 4
    //   79: aconst_null
    //   80: astore_1
    //   81: aconst_null
    //   82: astore_0
    //   83: aload_1
    //   84: astore_3
    //   85: aload_0
    //   86: astore_2
    //   87: aload 4
    //   89: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 129	java/io/BufferedReader:close	()V
    //   100: aload 5
    //   102: astore_1
    //   103: aload_0
    //   104: ifnull -41 -> 63
    //   107: aload_0
    //   108: invokevirtual 118	java/io/InputStream:close	()V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_0
    //   121: aload_0
    //   122: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   125: aconst_null
    //   126: areturn
    //   127: new 128	java/io/BufferedReader
    //   130: dup
    //   131: new 131	java/io/InputStreamReader
    //   134: dup
    //   135: aload_0
    //   136: ldc 133
    //   138: invokestatic 139	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   141: invokespecial 142	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   144: invokespecial 145	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   147: astore_1
    //   148: aload_1
    //   149: astore_3
    //   150: aload_0
    //   151: astore_2
    //   152: new 147	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   159: astore 4
    //   161: aload_1
    //   162: astore_3
    //   163: aload_0
    //   164: astore_2
    //   165: aload_1
    //   166: invokevirtual 152	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   169: astore 6
    //   171: aload 6
    //   173: ifnull +18 -> 191
    //   176: aload_1
    //   177: astore_3
    //   178: aload_0
    //   179: astore_2
    //   180: aload 4
    //   182: aload 6
    //   184: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: goto -27 -> 161
    //   191: aload_1
    //   192: astore_3
    //   193: aload_0
    //   194: astore_2
    //   195: aload 4
    //   197: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: astore 4
    //   202: aload 4
    //   204: astore_2
    //   205: aload_1
    //   206: ifnull +7 -> 213
    //   209: aload_1
    //   210: invokevirtual 129	java/io/BufferedReader:close	()V
    //   213: aload_2
    //   214: astore_1
    //   215: aload_0
    //   216: ifnull -153 -> 63
    //   219: aload_0
    //   220: invokevirtual 118	java/io/InputStream:close	()V
    //   223: aload_2
    //   224: areturn
    //   225: astore_0
    //   226: aload_0
    //   227: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   230: aload_2
    //   231: areturn
    //   232: astore_1
    //   233: aconst_null
    //   234: astore_3
    //   235: aconst_null
    //   236: astore_0
    //   237: aload_3
    //   238: ifnull +7 -> 245
    //   241: aload_3
    //   242: invokevirtual 129	java/io/BufferedReader:close	()V
    //   245: aload_0
    //   246: ifnull +7 -> 253
    //   249: aload_0
    //   250: invokevirtual 118	java/io/InputStream:close	()V
    //   253: aload_1
    //   254: athrow
    //   255: astore_0
    //   256: aload_0
    //   257: invokevirtual 126	java/io/IOException:printStackTrace	()V
    //   260: goto -7 -> 253
    //   263: astore_1
    //   264: aconst_null
    //   265: astore_3
    //   266: goto -29 -> 237
    //   269: astore_1
    //   270: aload_2
    //   271: astore_0
    //   272: goto -35 -> 237
    //   275: astore 4
    //   277: aconst_null
    //   278: astore_1
    //   279: goto -196 -> 83
    //   282: astore 4
    //   284: goto -201 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramContext	Context
    //   0	287	1	paramString	String
    //   86	185	2	localObject1	Object
    //   84	182	3	str1	String
    //   77	11	4	localIOException1	java.io.IOException
    //   159	44	4	localObject2	Object
    //   275	1	4	localIOException2	java.io.IOException
    //   282	1	4	localIOException3	java.io.IOException
    //   1	100	5	localObject3	Object
    //   169	14	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   3	12	77	java/io/IOException
    //   16	33	77	java/io/IOException
    //   65	74	77	java/io/IOException
    //   96	100	113	java/io/IOException
    //   107	111	113	java/io/IOException
    //   41	49	120	java/io/IOException
    //   56	60	120	java/io/IOException
    //   209	213	225	java/io/IOException
    //   219	223	225	java/io/IOException
    //   3	12	232	finally
    //   16	33	232	finally
    //   65	74	232	finally
    //   241	245	255	java/io/IOException
    //   249	253	255	java/io/IOException
    //   127	148	263	finally
    //   87	92	269	finally
    //   152	161	269	finally
    //   165	171	269	finally
    //   180	188	269	finally
    //   195	202	269	finally
    //   127	148	275	java/io/IOException
    //   152	161	282	java/io/IOException
    //   165	171	282	java/io/IOException
    //   180	188	282	java/io/IOException
    //   195	202	282	java/io/IOException
  }
  
  public static Object parseObjectFromFile(Context paramContext, String paramString, Class paramClass)
  {
    paramContext = loadJsonString(paramContext, paramString);
    if ((paramContext == null) || (TextUtils.isEmpty(paramContext)))
    {
      Log.e("JsonUtils", "parseObjectFromFile: get json string failed");
      return null;
    }
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
    }
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
    if ((paramContext == null) || (TextUtils.isEmpty(paramContext)))
    {
      Log.e("JsonUtils", "parseObjectFromFile: get json string failed");
      return null;
    }
    paramString = new GsonBuilder().create();
    try
    {
      paramContext = (RhythmDataBean)paramString.fromJson(paramContext, RhythmDataBean.class);
      return paramContext;
    }
    catch (JsonSyntaxException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.utils.JsonUtils
 * JD-Core Version:    0.7.0.1
 */