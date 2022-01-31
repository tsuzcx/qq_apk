package com.tencent.hydevteam.pluginframework.pluginmanager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class SimpleVersionChecker
  implements VersionChecker
{
  private static String a = "http://dldir1.qq.com/huayang/Android/$TYPE$_StableBackupUrl_1_3.zip";
  
  private static TargetDownloadInfo a(JSONObject paramJSONObject)
    throws VersionCheckException
  {
    int i;
    Object localObject;
    long l2;
    JSONObject localJSONObject;
    try
    {
      i = paramJSONObject.getInt("errCode");
      if (i != 0) {
        break label207;
      }
      localObject = paramJSONObject.getJSONObject("data").getJSONObject("targetversion");
      ((JSONObject)localObject).getInt("versionno");
      paramJSONObject = null;
      str = null;
      long l1 = 0L;
      i = 0;
      JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("content");
      int j = 0;
      int k;
      for (;;)
      {
        k = i;
        localObject = str;
        l2 = l1;
        localJSONObject = paramJSONObject;
        if (j < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(j);
          if (((JSONObject)localObject).getString("type").equals("default"))
          {
            i = 1;
            paramJSONObject = ((JSONObject)localObject).getString("url");
            str = ((JSONObject)localObject).getString("hash");
          }
          try
          {
            l1 = Long.parseLong(((JSONObject)localObject).getString("size"));
            k = i;
            localObject = str;
            l2 = l1;
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
    paramJSONObject = new SimpleTargetDownloadInfo(localJSONObject, (String)localObject, l2);
    return paramJSONObject;
    label207:
    String str = null;
    try
    {
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
    throws VersionCheckException
  {
    // Byte code:
    //   0: new 129	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 130	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 134	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   13: astore_0
    //   14: aload_0
    //   15: instanceof 136
    //   18: ifeq +365 -> 383
    //   21: aload_0
    //   22: checkcast 136	java/net/HttpURLConnection
    //   25: astore 7
    //   27: aload 7
    //   29: invokevirtual 139	java/net/HttpURLConnection:getResponseCode	()I
    //   32: istore_2
    //   33: iload_2
    //   34: sipush 200
    //   37: if_icmpne +310 -> 347
    //   40: new 141	java/util/zip/ZipInputStream
    //   43: dup
    //   44: new 143	java/io/BufferedInputStream
    //   47: dup
    //   48: aload 7
    //   50: invokevirtual 147	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   53: invokespecial 150	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: invokespecial 151	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   59: astore 8
    //   61: aconst_null
    //   62: astore 5
    //   64: aload 8
    //   66: invokevirtual 155	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   69: astore 6
    //   71: aload 5
    //   73: astore_0
    //   74: aload 6
    //   76: ifnull +36 -> 112
    //   79: aload 6
    //   81: invokevirtual 160	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   84: new 105	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   91: aload_1
    //   92: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc 163
    //   97: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifeq -42 -> 64
    //   109: aload 6
    //   111: astore_0
    //   112: aload_0
    //   113: ifnonnull +84 -> 197
    //   116: new 21	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   119: dup
    //   120: new 105	java/lang/StringBuilder
    //   123: dup
    //   124: ldc 165
    //   126: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   129: aload_1
    //   130: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 163
    //   135: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokespecial 96	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   144: athrow
    //   145: astore_0
    //   146: aload 8
    //   148: invokevirtual 168	java/util/zip/ZipInputStream:close	()V
    //   151: aload_0
    //   152: athrow
    //   153: astore_0
    //   154: new 21	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   157: dup
    //   158: ldc 170
    //   160: aload_0
    //   161: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: athrow
    //   165: astore_0
    //   166: aload 7
    //   168: invokevirtual 173	java/net/HttpURLConnection:disconnect	()V
    //   171: aload_0
    //   172: athrow
    //   173: astore_0
    //   174: new 21	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   177: dup
    //   178: ldc 175
    //   180: aload_0
    //   181: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: athrow
    //   185: astore_0
    //   186: new 21	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   189: dup
    //   190: ldc 177
    //   192: aload_0
    //   193: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   196: athrow
    //   197: aload_0
    //   198: invokevirtual 181	java/util/zip/ZipEntry:getSize	()J
    //   201: lstore_3
    //   202: lload_3
    //   203: ldc2_w 182
    //   206: lcmp
    //   207: ifle +30 -> 237
    //   210: new 21	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   213: dup
    //   214: new 105	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   221: aload_0
    //   222: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   225: ldc 188
    //   227: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokespecial 96	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   236: athrow
    //   237: lload_3
    //   238: ldc2_w 189
    //   241: lcmp
    //   242: ifeq +78 -> 320
    //   245: new 192	java/io/ByteArrayOutputStream
    //   248: dup
    //   249: lload_3
    //   250: l2i
    //   251: invokespecial 195	java/io/ByteArrayOutputStream:<init>	(I)V
    //   254: astore_0
    //   255: aload 8
    //   257: invokevirtual 198	java/util/zip/ZipInputStream:read	()I
    //   260: istore_2
    //   261: iload_2
    //   262: iconst_m1
    //   263: if_icmpeq +17 -> 280
    //   266: aload_0
    //   267: iload_2
    //   268: invokevirtual 201	java/io/ByteArrayOutputStream:write	(I)V
    //   271: aload 8
    //   273: invokevirtual 198	java/util/zip/ZipInputStream:read	()I
    //   276: istore_2
    //   277: goto -16 -> 261
    //   280: aload 8
    //   282: invokevirtual 204	java/util/zip/ZipInputStream:closeEntry	()V
    //   285: new 29	org/json/JSONObject
    //   288: dup
    //   289: aload_0
    //   290: invokevirtual 205	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   293: invokespecial 206	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   296: astore_1
    //   297: aload_0
    //   298: invokevirtual 207	java/io/ByteArrayOutputStream:close	()V
    //   301: aload 8
    //   303: invokevirtual 168	java/util/zip/ZipInputStream:close	()V
    //   306: aload 7
    //   308: invokevirtual 173	java/net/HttpURLConnection:disconnect	()V
    //   311: aload_1
    //   312: areturn
    //   313: astore_1
    //   314: aload_0
    //   315: invokevirtual 207	java/io/ByteArrayOutputStream:close	()V
    //   318: aload_1
    //   319: athrow
    //   320: new 21	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   323: dup
    //   324: new 105	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   331: aload_0
    //   332: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   335: ldc 209
    //   337: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokespecial 96	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   346: athrow
    //   347: new 21	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   350: dup
    //   351: new 105	java/lang/StringBuilder
    //   354: dup
    //   355: ldc 211
    //   357: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   360: iload_2
    //   361: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokespecial 96	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   370: athrow
    //   371: astore_0
    //   372: new 21	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   375: dup
    //   376: ldc 213
    //   378: aload_0
    //   379: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   382: athrow
    //   383: new 21	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   386: dup
    //   387: ldc 215
    //   389: invokespecial 96	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   392: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	paramString1	String
    //   0	393	1	paramString2	String
    //   32	329	2	i	int
    //   201	49	3	l	long
    //   62	10	5	localObject	Object
    //   69	41	6	localZipEntry	java.util.zip.ZipEntry
    //   25	282	7	localHttpURLConnection	java.net.HttpURLConnection
    //   59	243	8	localZipInputStream	java.util.zip.ZipInputStream
    // Exception table:
    //   from	to	target	type
    //   64	71	145	finally
    //   79	109	145	finally
    //   116	145	145	finally
    //   197	202	145	finally
    //   210	237	145	finally
    //   245	255	145	finally
    //   297	301	145	finally
    //   314	320	145	finally
    //   320	347	145	finally
    //   27	33	153	java/io/IOException
    //   40	61	153	java/io/IOException
    //   146	153	153	java/io/IOException
    //   301	306	153	java/io/IOException
    //   347	371	153	java/io/IOException
    //   27	33	165	finally
    //   40	61	165	finally
    //   146	153	165	finally
    //   154	165	165	finally
    //   301	306	165	finally
    //   347	371	165	finally
    //   372	383	165	finally
    //   0	9	173	java/net/MalformedURLException
    //   9	14	173	java/net/MalformedURLException
    //   14	27	173	java/net/MalformedURLException
    //   166	173	173	java/net/MalformedURLException
    //   186	197	173	java/net/MalformedURLException
    //   306	311	173	java/net/MalformedURLException
    //   383	393	173	java/net/MalformedURLException
    //   9	14	185	java/io/IOException
    //   255	261	313	finally
    //   266	277	313	finally
    //   280	297	313	finally
    //   27	33	371	org/json/JSONException
    //   40	61	371	org/json/JSONException
    //   146	153	371	org/json/JSONException
    //   301	306	371	org/json/JSONException
    //   347	371	371	org/json/JSONException
  }
  
  /* Error */
  private static JSONObject a(String paramString1, String paramString2, boolean paramBoolean)
    throws VersionCheckException
  {
    // Byte code:
    //   0: new 105	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 218
    //   6: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: aload_1
    //   10: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: ldc 220
    //   15: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: astore_1
    //   19: iload_2
    //   20: ifeq +158 -> 178
    //   23: iconst_1
    //   24: istore_3
    //   25: aload_1
    //   26: iload_3
    //   27: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc 222
    //   32: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore_0
    //   43: new 129	java/net/URL
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 130	java/net/URL:<init>	(Ljava/lang/String;)V
    //   51: astore_0
    //   52: aload_0
    //   53: invokevirtual 134	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   56: astore_0
    //   57: aload_0
    //   58: instanceof 136
    //   61: ifeq +193 -> 254
    //   64: aload_0
    //   65: checkcast 136	java/net/HttpURLConnection
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 139	java/net/HttpURLConnection:getResponseCode	()I
    //   73: istore_3
    //   74: iload_3
    //   75: sipush 200
    //   78: if_icmpne +140 -> 218
    //   81: new 224	java/io/BufferedReader
    //   84: dup
    //   85: new 226	java/io/InputStreamReader
    //   88: dup
    //   89: aload_0
    //   90: invokevirtual 147	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   93: invokespecial 227	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   96: invokespecial 230	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   99: astore_1
    //   100: new 105	java/lang/StringBuilder
    //   103: dup
    //   104: ldc 232
    //   106: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   109: astore 4
    //   111: aload_1
    //   112: invokevirtual 235	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   115: astore 5
    //   117: aload 5
    //   119: ifnull +76 -> 195
    //   122: aload 4
    //   124: aload 5
    //   126: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc 237
    //   131: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: goto -24 -> 111
    //   138: astore 4
    //   140: aload_1
    //   141: invokevirtual 238	java/io/BufferedReader:close	()V
    //   144: aload 4
    //   146: athrow
    //   147: astore_1
    //   148: new 21	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   151: dup
    //   152: ldc 170
    //   154: aload_1
    //   155: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: athrow
    //   159: astore_1
    //   160: aload_0
    //   161: invokevirtual 173	java/net/HttpURLConnection:disconnect	()V
    //   164: aload_1
    //   165: athrow
    //   166: astore_0
    //   167: new 21	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   170: dup
    //   171: ldc 240
    //   173: aload_0
    //   174: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: athrow
    //   178: iconst_0
    //   179: istore_3
    //   180: goto -155 -> 25
    //   183: astore_0
    //   184: new 21	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   187: dup
    //   188: ldc 177
    //   190: aload_0
    //   191: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   194: athrow
    //   195: aload_1
    //   196: invokevirtual 238	java/io/BufferedReader:close	()V
    //   199: new 29	org/json/JSONObject
    //   202: dup
    //   203: aload 4
    //   205: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokespecial 206	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   211: astore_1
    //   212: aload_0
    //   213: invokevirtual 173	java/net/HttpURLConnection:disconnect	()V
    //   216: aload_1
    //   217: areturn
    //   218: new 21	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   221: dup
    //   222: new 105	java/lang/StringBuilder
    //   225: dup
    //   226: ldc 211
    //   228: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: iload_3
    //   232: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokespecial 96	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   241: athrow
    //   242: astore_1
    //   243: new 21	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   246: dup
    //   247: ldc 213
    //   249: aload_1
    //   250: invokespecial 89	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   253: athrow
    //   254: new 21	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   257: dup
    //   258: ldc 242
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
    throws VersionCheckException
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.SimpleVersionChecker
 * JD-Core Version:    0.7.0.1
 */