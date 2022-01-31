package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class SimpleVersionChecker
  implements VersionChecker
{
  private static String a = "http://dldir1.qq.com/huayang/Android/$TYPE$_StableBackupUrl_1_4.zip";
  
  private static TargetDownloadInfo a(JSONObject paramJSONObject)
  {
    String str = null;
    int i;
    long l2;
    Object localObject;
    JSONObject localJSONObject;
    try
    {
      i = paramJSONObject.getInt("errCode");
      if (i != 0) {
        break label207;
      }
      paramJSONObject = paramJSONObject.getJSONObject("data").getJSONObject("targetversion");
      paramJSONObject.getInt("versionno");
      JSONArray localJSONArray = paramJSONObject.getJSONArray("content");
      int j = 0;
      paramJSONObject = null;
      long l1 = 0L;
      i = 0;
      str = null;
      int k;
      for (;;)
      {
        l2 = l1;
        k = i;
        localObject = str;
        localJSONObject = paramJSONObject;
        if (j < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(j);
          if (((JSONObject)localObject).getString("type").equals("default"))
          {
            i = 1;
            str = ((JSONObject)localObject).getString("url");
            paramJSONObject = ((JSONObject)localObject).getString("hash");
          }
          try
          {
            l1 = Long.parseLong(((JSONObject)localObject).getString("size"));
            l2 = l1;
            k = i;
            localObject = str;
            localJSONObject = paramJSONObject;
            if (i == 0) {
              j += 1;
            }
          }
          catch (NumberFormatException paramJSONObject)
          {
            throw new VersionCheckException("size不是数字", paramJSONObject);
          }
        }
      }
      if (k != 0) {
        break label191;
      }
    }
    catch (JSONException paramJSONObject)
    {
      throw new VersionCheckException("Json不符合预期", paramJSONObject);
    }
    throw new VersionCheckException("json中不包含目标content,目标content的type是default");
    label191:
    paramJSONObject = new SimpleTargetDownloadInfo((String)localObject, localJSONObject, l2);
    return paramJSONObject;
    try
    {
      label207:
      paramJSONObject = paramJSONObject.getString("message");
      throw new VersionCheckException("查询出错。errCode==" + i + " message==" + paramJSONObject);
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject = str;
      }
    }
  }
  
  /* Error */
  private static JSONObject a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 128	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 129	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 133	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   13: astore_0
    //   14: aload_0
    //   15: instanceof 135
    //   18: ifeq +353 -> 371
    //   21: aload_0
    //   22: checkcast 135	java/net/HttpURLConnection
    //   25: astore 5
    //   27: aload 5
    //   29: invokevirtual 138	java/net/HttpURLConnection:getResponseCode	()I
    //   32: istore_2
    //   33: iload_2
    //   34: sipush 200
    //   37: if_icmpne +298 -> 335
    //   40: new 140	com/tencent/commonsdk/zip/QZipInputStream
    //   43: dup
    //   44: new 142	java/io/BufferedInputStream
    //   47: dup
    //   48: aload 5
    //   50: invokevirtual 146	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   53: invokespecial 149	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: invokespecial 150	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   59: astore 6
    //   61: aload 6
    //   63: invokevirtual 154	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   66: astore_0
    //   67: aload_0
    //   68: ifnull +313 -> 381
    //   71: aload_0
    //   72: invokevirtual 159	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   75: new 105	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   82: aload_1
    //   83: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 162
    //   88: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifeq -36 -> 61
    //   100: aload_0
    //   101: ifnonnull +84 -> 185
    //   104: new 84	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   107: dup
    //   108: new 105	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 164
    //   114: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_1
    //   118: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 162
    //   123: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokespecial 96	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   132: athrow
    //   133: astore_0
    //   134: aload 6
    //   136: invokevirtual 167	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   139: aload_0
    //   140: athrow
    //   141: astore_0
    //   142: new 84	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   145: dup
    //   146: ldc 169
    //   148: aload_0
    //   149: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   152: athrow
    //   153: astore_0
    //   154: aload 5
    //   156: invokevirtual 172	java/net/HttpURLConnection:disconnect	()V
    //   159: aload_0
    //   160: athrow
    //   161: astore_0
    //   162: new 84	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   165: dup
    //   166: ldc 174
    //   168: aload_0
    //   169: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   172: athrow
    //   173: astore_0
    //   174: new 84	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   177: dup
    //   178: ldc 176
    //   180: aload_0
    //   181: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: athrow
    //   185: aload_0
    //   186: invokevirtual 180	java/util/zip/ZipEntry:getSize	()J
    //   189: lstore_3
    //   190: lload_3
    //   191: ldc2_w 181
    //   194: lcmp
    //   195: ifle +30 -> 225
    //   198: new 84	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   201: dup
    //   202: new 105	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   209: aload_0
    //   210: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   213: ldc 187
    //   215: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokespecial 96	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   224: athrow
    //   225: lload_3
    //   226: ldc2_w 188
    //   229: lcmp
    //   230: ifeq +78 -> 308
    //   233: new 191	java/io/ByteArrayOutputStream
    //   236: dup
    //   237: lload_3
    //   238: l2i
    //   239: invokespecial 194	java/io/ByteArrayOutputStream:<init>	(I)V
    //   242: astore_0
    //   243: aload 6
    //   245: invokevirtual 197	com/tencent/commonsdk/zip/QZipInputStream:read	()I
    //   248: istore_2
    //   249: iload_2
    //   250: iconst_m1
    //   251: if_icmpeq +17 -> 268
    //   254: aload_0
    //   255: iload_2
    //   256: invokevirtual 200	java/io/ByteArrayOutputStream:write	(I)V
    //   259: aload 6
    //   261: invokevirtual 197	com/tencent/commonsdk/zip/QZipInputStream:read	()I
    //   264: istore_2
    //   265: goto -16 -> 249
    //   268: aload 6
    //   270: invokevirtual 203	com/tencent/commonsdk/zip/QZipInputStream:closeEntry	()V
    //   273: new 27	org/json/JSONObject
    //   276: dup
    //   277: aload_0
    //   278: invokevirtual 204	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   281: invokespecial 205	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   284: astore_1
    //   285: aload_0
    //   286: invokevirtual 206	java/io/ByteArrayOutputStream:close	()V
    //   289: aload 6
    //   291: invokevirtual 167	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   294: aload 5
    //   296: invokevirtual 172	java/net/HttpURLConnection:disconnect	()V
    //   299: aload_1
    //   300: areturn
    //   301: astore_1
    //   302: aload_0
    //   303: invokevirtual 206	java/io/ByteArrayOutputStream:close	()V
    //   306: aload_1
    //   307: athrow
    //   308: new 84	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   311: dup
    //   312: new 105	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   319: aload_0
    //   320: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   323: ldc 208
    //   325: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokespecial 96	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   334: athrow
    //   335: new 84	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   338: dup
    //   339: new 105	java/lang/StringBuilder
    //   342: dup
    //   343: ldc 210
    //   345: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   348: iload_2
    //   349: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokespecial 96	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   358: athrow
    //   359: astore_0
    //   360: new 84	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   363: dup
    //   364: ldc 212
    //   366: aload_0
    //   367: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   370: athrow
    //   371: new 84	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   374: dup
    //   375: ldc 214
    //   377: invokespecial 96	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   380: athrow
    //   381: aconst_null
    //   382: astore_0
    //   383: goto -283 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	paramString1	String
    //   0	386	1	paramString2	String
    //   32	317	2	i	int
    //   189	49	3	l	long
    //   25	270	5	localHttpURLConnection	java.net.HttpURLConnection
    //   59	231	6	localQZipInputStream	com.tencent.commonsdk.zip.QZipInputStream
    // Exception table:
    //   from	to	target	type
    //   61	67	133	finally
    //   71	100	133	finally
    //   104	133	133	finally
    //   185	190	133	finally
    //   198	225	133	finally
    //   233	243	133	finally
    //   285	289	133	finally
    //   302	308	133	finally
    //   308	335	133	finally
    //   27	33	141	java/io/IOException
    //   40	61	141	java/io/IOException
    //   134	141	141	java/io/IOException
    //   289	294	141	java/io/IOException
    //   335	359	141	java/io/IOException
    //   27	33	153	finally
    //   40	61	153	finally
    //   134	141	153	finally
    //   142	153	153	finally
    //   289	294	153	finally
    //   335	359	153	finally
    //   360	371	153	finally
    //   0	9	161	java/net/MalformedURLException
    //   9	14	161	java/net/MalformedURLException
    //   14	27	161	java/net/MalformedURLException
    //   154	161	161	java/net/MalformedURLException
    //   174	185	161	java/net/MalformedURLException
    //   294	299	161	java/net/MalformedURLException
    //   371	381	161	java/net/MalformedURLException
    //   9	14	173	java/io/IOException
    //   243	249	301	finally
    //   254	265	301	finally
    //   268	285	301	finally
    //   27	33	359	org/json/JSONException
    //   40	61	359	org/json/JSONException
    //   134	141	359	org/json/JSONException
    //   289	294	359	org/json/JSONException
    //   335	359	359	org/json/JSONException
  }
  
  /* Error */
  private static JSONObject a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 105	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 217
    //   6: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: aload_1
    //   10: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: ldc 219
    //   15: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: astore_1
    //   19: iload_2
    //   20: ifeq +158 -> 178
    //   23: iconst_1
    //   24: istore_3
    //   25: aload_1
    //   26: iload_3
    //   27: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 221
    //   32: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore_0
    //   43: new 128	java/net/URL
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 129	java/net/URL:<init>	(Ljava/lang/String;)V
    //   51: astore_0
    //   52: aload_0
    //   53: invokevirtual 133	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   56: astore_0
    //   57: aload_0
    //   58: instanceof 135
    //   61: ifeq +193 -> 254
    //   64: aload_0
    //   65: checkcast 135	java/net/HttpURLConnection
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 138	java/net/HttpURLConnection:getResponseCode	()I
    //   73: istore_3
    //   74: iload_3
    //   75: sipush 200
    //   78: if_icmpne +140 -> 218
    //   81: new 223	java/io/BufferedReader
    //   84: dup
    //   85: new 225	java/io/InputStreamReader
    //   88: dup
    //   89: aload_0
    //   90: invokevirtual 146	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   93: invokespecial 226	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   96: invokespecial 229	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   99: astore_1
    //   100: new 105	java/lang/StringBuilder
    //   103: dup
    //   104: ldc 231
    //   106: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   109: astore 4
    //   111: aload_1
    //   112: invokevirtual 234	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   115: astore 5
    //   117: aload 5
    //   119: ifnull +76 -> 195
    //   122: aload 4
    //   124: aload 5
    //   126: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc 236
    //   131: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: goto -24 -> 111
    //   138: astore 4
    //   140: aload_1
    //   141: invokevirtual 237	java/io/BufferedReader:close	()V
    //   144: aload 4
    //   146: athrow
    //   147: astore_1
    //   148: new 84	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   151: dup
    //   152: ldc 169
    //   154: aload_1
    //   155: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: athrow
    //   159: astore_1
    //   160: aload_0
    //   161: invokevirtual 172	java/net/HttpURLConnection:disconnect	()V
    //   164: aload_1
    //   165: athrow
    //   166: astore_0
    //   167: new 84	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   170: dup
    //   171: ldc 239
    //   173: aload_0
    //   174: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: athrow
    //   178: iconst_0
    //   179: istore_3
    //   180: goto -155 -> 25
    //   183: astore_0
    //   184: new 84	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   187: dup
    //   188: ldc 176
    //   190: aload_0
    //   191: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   194: athrow
    //   195: aload_1
    //   196: invokevirtual 237	java/io/BufferedReader:close	()V
    //   199: new 27	org/json/JSONObject
    //   202: dup
    //   203: aload 4
    //   205: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokespecial 205	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   211: astore_1
    //   212: aload_0
    //   213: invokevirtual 172	java/net/HttpURLConnection:disconnect	()V
    //   216: aload_1
    //   217: areturn
    //   218: new 84	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   221: dup
    //   222: new 105	java/lang/StringBuilder
    //   225: dup
    //   226: ldc 210
    //   228: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: iload_3
    //   232: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokespecial 96	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   241: athrow
    //   242: astore_1
    //   243: new 84	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   246: dup
    //   247: ldc 212
    //   249: aload_1
    //   250: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   253: athrow
    //   254: new 84	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   257: dup
    //   258: ldc 241
    //   260: invokespecial 96	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   263: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramString1	String
    //   0	264	1	paramString2	String
    //   0	264	2	paramBoolean	boolean
    //   24	208	3	i	int
    //   109	14	4	localStringBuilder	java.lang.StringBuilder
    //   138	66	4	localObject	Object
    //   115	10	5	str	String
    // Exception table:
    //   from	to	target	type
    //   111	117	138	finally
    //   122	135	138	finally
    //   69	74	147	java/io/IOException
    //   81	111	147	java/io/IOException
    //   140	147	147	java/io/IOException
    //   195	212	147	java/io/IOException
    //   218	242	147	java/io/IOException
    //   69	74	159	finally
    //   81	111	159	finally
    //   140	147	159	finally
    //   148	159	159	finally
    //   195	212	159	finally
    //   218	242	159	finally
    //   243	254	159	finally
    //   43	52	166	java/net/MalformedURLException
    //   52	57	166	java/net/MalformedURLException
    //   57	69	166	java/net/MalformedURLException
    //   160	166	166	java/net/MalformedURLException
    //   184	195	166	java/net/MalformedURLException
    //   212	216	166	java/net/MalformedURLException
    //   254	264	166	java/net/MalformedURLException
    //   52	57	183	java/io/IOException
    //   69	74	242	org/json/JSONException
    //   81	111	242	org/json/JSONException
    //   140	147	242	org/json/JSONException
    //   195	212	242	org/json/JSONException
    //   218	242	242	org/json/JSONException
  }
  
  public TargetDownloadInfo check(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new VersionCheckException("不支持的source:" + paramString1);
        if (paramString1.equals("SOURCE_CGI"))
        {
          i = 0;
          continue;
          if (paramString1.equals("SOURCE_BACKUP_STABLE")) {
            i = 1;
          }
        }
        break;
      }
    }
    return a(a(paramString2, paramString3, paramBoolean));
    paramString1 = a.replace("$TYPE$", paramString3);
    a = paramString1;
    return a(a(paramString1, paramString3));
  }
  
  public TargetDownloadInfo checkForceUpdate(String paramString1, String paramString2, String paramString3, boolean paramBoolean, InstalledPlugin paramInstalledPlugin)
  {
    throw new RuntimeException("SimpleVersionChecker暂不支持checkForceUpdate");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.SimpleVersionChecker
 * JD-Core Version:    0.7.0.1
 */