package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class SimpleVersionChecker
  implements VersionChecker
{
  private static String a = "https://dldir1.qq.com/huayang/Android/$TYPE$_StableBackupUrl_1_4.zip";
  
  private static TargetDownloadInfo a(JSONObject paramJSONObject)
  {
    try
    {
      i = paramJSONObject.getInt("errCode");
      localObject2 = null;
      localObject1 = null;
      if (i != 0) {
        break label172;
      }
      paramJSONObject = paramJSONObject.getJSONObject("data").getJSONObject("targetversion");
      paramJSONObject.getInt("versionno");
      localJSONArray = paramJSONObject.getJSONArray("content");
      j = 0;
      l1 = 0L;
      i = 0;
      paramJSONObject = null;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        int i;
        Object localObject1;
        int j;
        long l1;
        try
        {
          JSONArray localJSONArray;
          label172:
          paramJSONObject = paramJSONObject.getString("message");
          localObject1 = new StringBuilder("查询出错。errCode==");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(" message==");
          ((StringBuilder)localObject1).append(paramJSONObject);
          throw new VersionCheckException(((StringBuilder)localObject1).toString());
          paramJSONObject = paramJSONObject;
          paramJSONObject = new VersionCheckException("Json不符合预期", paramJSONObject);
          continue;
          throw paramJSONObject;
          continue;
        }
        catch (JSONException paramJSONObject)
        {
          paramJSONObject = (JSONObject)localObject2;
          continue;
        }
        Object localObject2 = localObject1;
        JSONObject localJSONObject = paramJSONObject;
        long l2 = l1;
        int k = i;
        if (i == 0) {
          j += 1;
        }
      }
    }
    localObject2 = localObject1;
    localJSONObject = paramJSONObject;
    l2 = l1;
    k = i;
    if (j < localJSONArray.length())
    {
      localObject2 = localJSONArray.getJSONObject(j);
      if (((JSONObject)localObject2).getString("type").equals("default"))
      {
        paramJSONObject = ((JSONObject)localObject2).getString("url");
        localObject1 = ((JSONObject)localObject2).getString("hash");
        try
        {
          l1 = Long.parseLong(((JSONObject)localObject2).getString("size"));
          i = 1;
        }
        catch (NumberFormatException paramJSONObject)
        {
          throw new VersionCheckException("size不是数字", paramJSONObject);
        }
      }
    }
    else
    {
      if (k != 0) {
        return new SimpleTargetDownloadInfo(localJSONObject, (String)localObject2, l2);
      }
      throw new VersionCheckException("json中不包含目标content,目标content的type是default");
    }
  }
  
  /* Error */
  private static JSONObject a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 126	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 127	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 131	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   13: astore_0
    //   14: aload_0
    //   15: instanceof 133
    //   18: ifeq +372 -> 390
    //   21: aload_0
    //   22: checkcast 133	java/net/HttpURLConnection
    //   25: astore 7
    //   27: aload 7
    //   29: invokevirtual 136	java/net/HttpURLConnection:getResponseCode	()I
    //   32: istore_2
    //   33: iload_2
    //   34: sipush 200
    //   37: if_icmpne +290 -> 327
    //   40: new 138	com/tencent/commonsdk/zip/QZipInputStream
    //   43: dup
    //   44: new 140	java/io/BufferedInputStream
    //   47: dup
    //   48: aload 7
    //   50: invokevirtual 144	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   53: invokespecial 147	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: invokespecial 148	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   59: astore 8
    //   61: aconst_null
    //   62: astore 5
    //   64: aload 8
    //   66: invokevirtual 152	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   69: astore 6
    //   71: aload 5
    //   73: astore_0
    //   74: aload 6
    //   76: ifnull +48 -> 124
    //   79: aload 6
    //   81: invokevirtual 157	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   84: astore_0
    //   85: new 101	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   92: astore 9
    //   94: aload 9
    //   96: aload_1
    //   97: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 9
    //   103: ldc 160
    //   105: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_0
    //   110: aload 9
    //   112: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokevirtual 68	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   118: ifeq -54 -> 64
    //   121: aload 6
    //   123: astore_0
    //   124: aload_0
    //   125: ifnull +159 -> 284
    //   128: aload_0
    //   129: invokevirtual 164	java/util/zip/ZipEntry:getSize	()J
    //   132: lstore_3
    //   133: lload_3
    //   134: ldc2_w 165
    //   137: lcmp
    //   138: ifgt +113 -> 251
    //   141: lload_3
    //   142: ldc2_w 167
    //   145: lcmp
    //   146: ifeq +72 -> 218
    //   149: new 170	java/io/ByteArrayOutputStream
    //   152: dup
    //   153: lload_3
    //   154: l2i
    //   155: invokespecial 173	java/io/ByteArrayOutputStream:<init>	(I)V
    //   158: astore_0
    //   159: aload 8
    //   161: invokevirtual 176	com/tencent/commonsdk/zip/QZipInputStream:read	()I
    //   164: istore_2
    //   165: iload_2
    //   166: iconst_m1
    //   167: if_icmpeq +11 -> 178
    //   170: aload_0
    //   171: iload_2
    //   172: invokevirtual 179	java/io/ByteArrayOutputStream:write	(I)V
    //   175: goto -16 -> 159
    //   178: aload 8
    //   180: invokevirtual 182	com/tencent/commonsdk/zip/QZipInputStream:closeEntry	()V
    //   183: new 25	org/json/JSONObject
    //   186: dup
    //   187: aload_0
    //   188: invokevirtual 183	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   191: invokespecial 184	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   194: astore_1
    //   195: aload_0
    //   196: invokevirtual 187	java/io/ByteArrayOutputStream:close	()V
    //   199: aload 8
    //   201: invokevirtual 188	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   204: aload 7
    //   206: invokevirtual 191	java/net/HttpURLConnection:disconnect	()V
    //   209: aload_1
    //   210: areturn
    //   211: astore_1
    //   212: aload_0
    //   213: invokevirtual 187	java/io/ByteArrayOutputStream:close	()V
    //   216: aload_1
    //   217: athrow
    //   218: new 101	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   225: astore_1
    //   226: aload_1
    //   227: aload_0
    //   228: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload_1
    //   233: ldc 196
    //   235: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: new 82	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   242: dup
    //   243: aload_1
    //   244: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokespecial 97	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   250: athrow
    //   251: new 101	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   258: astore_1
    //   259: aload_1
    //   260: aload_0
    //   261: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload_1
    //   266: ldc 198
    //   268: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: new 82	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   275: dup
    //   276: aload_1
    //   277: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokespecial 97	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   283: athrow
    //   284: new 101	java/lang/StringBuilder
    //   287: dup
    //   288: ldc 200
    //   290: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   293: astore_0
    //   294: aload_0
    //   295: aload_1
    //   296: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_0
    //   301: ldc 160
    //   303: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: new 82	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   310: dup
    //   311: aload_0
    //   312: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokespecial 97	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   318: athrow
    //   319: astore_0
    //   320: aload 8
    //   322: invokevirtual 188	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   325: aload_0
    //   326: athrow
    //   327: new 101	java/lang/StringBuilder
    //   330: dup
    //   331: ldc 202
    //   333: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   336: astore_0
    //   337: aload_0
    //   338: iload_2
    //   339: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: new 82	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   346: dup
    //   347: aload_0
    //   348: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokespecial 97	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   354: athrow
    //   355: astore_0
    //   356: goto +27 -> 383
    //   359: astore_0
    //   360: new 82	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   363: dup
    //   364: ldc 204
    //   366: aload_0
    //   367: invokespecial 87	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   370: athrow
    //   371: astore_0
    //   372: new 82	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   375: dup
    //   376: ldc 206
    //   378: aload_0
    //   379: invokespecial 87	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   382: athrow
    //   383: aload 7
    //   385: invokevirtual 191	java/net/HttpURLConnection:disconnect	()V
    //   388: aload_0
    //   389: athrow
    //   390: new 82	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   393: dup
    //   394: ldc 208
    //   396: invokespecial 97	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;)V
    //   399: athrow
    //   400: astore_0
    //   401: new 82	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   404: dup
    //   405: ldc 210
    //   407: aload_0
    //   408: invokespecial 87	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   411: athrow
    //   412: astore_0
    //   413: new 82	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException
    //   416: dup
    //   417: ldc 212
    //   419: aload_0
    //   420: invokespecial 87	com/tencent/hydevteam/pluginframework/pluginmanager/VersionCheckException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   423: astore_0
    //   424: goto +5 -> 429
    //   427: aload_0
    //   428: athrow
    //   429: goto -2 -> 427
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	paramString1	String
    //   0	432	1	paramString2	String
    //   32	307	2	i	int
    //   132	22	3	l	long
    //   62	10	5	localObject	Object
    //   69	53	6	localZipEntry	java.util.zip.ZipEntry
    //   25	359	7	localHttpURLConnection	java.net.HttpURLConnection
    //   59	262	8	localQZipInputStream	com.tencent.commonsdk.zip.QZipInputStream
    //   92	19	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   159	165	211	finally
    //   170	175	211	finally
    //   178	195	211	finally
    //   64	71	319	finally
    //   79	121	319	finally
    //   128	133	319	finally
    //   149	159	319	finally
    //   195	199	319	finally
    //   212	218	319	finally
    //   218	251	319	finally
    //   251	284	319	finally
    //   284	319	319	finally
    //   27	33	355	finally
    //   40	61	355	finally
    //   199	204	355	finally
    //   320	327	355	finally
    //   327	355	355	finally
    //   360	371	355	finally
    //   372	383	355	finally
    //   27	33	359	org/json/JSONException
    //   40	61	359	org/json/JSONException
    //   199	204	359	org/json/JSONException
    //   320	327	359	org/json/JSONException
    //   327	355	359	org/json/JSONException
    //   27	33	371	java/io/IOException
    //   40	61	371	java/io/IOException
    //   199	204	371	java/io/IOException
    //   320	327	371	java/io/IOException
    //   327	355	371	java/io/IOException
    //   9	14	400	java/io/IOException
    //   0	9	412	java/net/MalformedURLException
    //   9	14	412	java/net/MalformedURLException
    //   14	27	412	java/net/MalformedURLException
    //   204	209	412	java/net/MalformedURLException
    //   383	390	412	java/net/MalformedURLException
    //   390	400	412	java/net/MalformedURLException
    //   401	412	412	java/net/MalformedURLException
  }
  
  private static JSONObject a(String paramString1, String paramString2, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public TargetDownloadInfo check(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int i = paramString1.hashCode();
    if (i != -1632807116)
    {
      if ((i == -625079743) && (paramString1.equals("SOURCE_CGI")))
      {
        i = 0;
        break label56;
      }
    }
    else if (paramString1.equals("SOURCE_BACKUP_STABLE"))
    {
      i = 1;
      break label56;
    }
    i = -1;
    label56:
    if (i != 0)
    {
      if (i == 1)
      {
        paramString1 = a.replace("$TYPE$", paramString3);
        a = paramString1;
        return a(a(paramString1, paramString3));
      }
      paramString2 = new StringBuilder("不支持的source:");
      paramString2.append(paramString1);
      throw new VersionCheckException(paramString2.toString());
    }
    return a(a(paramString2, paramString3, paramBoolean));
  }
  
  public TargetDownloadInfo checkForceUpdate(String paramString1, String paramString2, String paramString3, boolean paramBoolean, InstalledPlugin paramInstalledPlugin)
  {
    throw new RuntimeException("SimpleVersionChecker暂不支持checkForceUpdate");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.SimpleVersionChecker
 * JD-Core Version:    0.7.0.1
 */