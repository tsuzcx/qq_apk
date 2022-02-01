package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.UseDynamicPluginLoaderInstalledPlugin;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class UnpackManager
{
  private final File a;
  
  UnpackManager(File paramFile)
  {
    this.a = new File(paramFile, "UnpackedPlugin");
    this.a.mkdirs();
  }
  
  private static boolean d(File paramFile)
  {
    return new File(paramFile, "launch.failed").exists();
  }
  
  private static File e(File paramFile)
  {
    File localFile = paramFile.getParentFile();
    StringBuilder localStringBuilder = new StringBuilder("unpacked.");
    localStringBuilder.append(paramFile.getName());
    return new File(localFile, localStringBuilder.toString());
  }
  
  private static InstalledPlugin f(File paramFile)
  {
    Object localObject1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(paramFile, "config.json"))));
    Object localObject2 = new StringBuilder("");
    try
    {
      for (;;)
      {
        str1 = ((BufferedReader)localObject1).readLine();
        if (str1 == null) {
          break;
        }
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append("\n");
      }
      ((BufferedReader)localObject1).close();
      localObject1 = new JSONObject(((StringBuilder)localObject2).toString());
      localObject2 = ((JSONObject)localObject1).getString("DYNAMIC_PLUGIN_LOADER_VERSION");
      String str1 = ((JSONObject)localObject1).getString("DYNAMIC_PLUGIN_CONTAINER_VERSION");
      Object localObject4 = ((JSONObject)localObject1).getString("DYNAMIC_PLUGIN_LOADER_PATH");
      String str2 = ((JSONObject)localObject1).getString("DYNAMIC_PLUGIN_LOADER_CLASSNAME");
      Object localObject3 = ((JSONObject)localObject1).getJSONArray("DYNAMIC_PLUGIN_LOADER_INTERFACE_PACKAGE_NAMES");
      String[] arrayOfString = new String[((JSONArray)localObject3).length()];
      int i = 0;
      while (i < arrayOfString.length)
      {
        arrayOfString[i] = ((JSONArray)localObject3).getString(i);
        i += 1;
      }
      Object localObject5 = ((JSONObject)localObject1).getString("DYNAMIC_PLUGIN_CONTAINER_PATH");
      localObject3 = ((JSONObject)localObject1).getString("PLUGIN_PACKAGE_NAME");
      String str3 = ((JSONObject)localObject1).getString("PLUGIN_VERSION");
      String str4 = ((JSONObject)localObject1).getString("PLUGIN_FILE_PATH");
      localObject4 = new File(paramFile, (String)localObject4);
      localObject5 = new File(paramFile, (String)localObject5);
      return new UseDynamicPluginLoaderInstalledPlugin((String)localObject3, str3, new File(paramFile, str4), (String)localObject2, str1, (File)localObject4, (File)localObject5, str2, arrayOfString, paramFile, ((JSONObject)localObject1).optInt("DYNAMIC_PLUGIN_PLUGIN_FILE_TYPE"));
    }
    finally
    {
      ((BufferedReader)localObject1).close();
    }
    for (;;)
    {
      throw paramFile;
    }
  }
  
  final InstalledPlugin a()
  {
    Iterator localIterator = MinFileUtils.b(this.a).iterator();
    while (localIterator.hasNext())
    {
      File localFile = (File)localIterator.next();
      Object localObject = localFile.getName();
      if (((String)localObject).startsWith("unpacked."))
      {
        localObject = new File(this.a, ((String)localObject).substring(9));
        if ((!e((File)localObject).exists()) || (d((File)localObject))) {}
      }
      try
      {
        localObject = f((File)localObject);
        return localObject;
      }
      catch (Exception localException)
      {
        label88:
        break label88;
      }
      localFile.delete();
    }
    return null;
  }
  
  final File a(File paramFile)
  {
    return new File(this.a, paramFile.getName());
  }
  
  final boolean b(File paramFile)
  {
    return d(a(paramFile));
  }
  
  /* Error */
  final InstalledPlugin c(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 177	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:a	(Ljava/io/File;)Ljava/io/File;
    //   5: astore 7
    //   7: aload 7
    //   9: invokevirtual 24	java/io/File:mkdirs	()Z
    //   12: pop
    //   13: aload 7
    //   15: invokestatic 168	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:e	(Ljava/io/File;)Ljava/io/File;
    //   18: astore 5
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 177	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:a	(Ljava/io/File;)Ljava/io/File;
    //   25: invokestatic 168	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:e	(Ljava/io/File;)Ljava/io/File;
    //   28: invokevirtual 32	java/io/File:exists	()Z
    //   31: ifeq +56 -> 87
    //   34: aload 7
    //   36: invokestatic 172	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:f	(Ljava/io/File;)Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;
    //   39: astore 4
    //   41: aload 4
    //   43: areturn
    //   44: aload 5
    //   46: invokevirtual 175	java/io/File:delete	()Z
    //   49: ifeq +6 -> 55
    //   52: goto +35 -> 87
    //   55: new 40	java/lang/StringBuilder
    //   58: dup
    //   59: ldc 180
    //   61: invokespecial 45	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: astore_1
    //   65: aload_1
    //   66: aload 5
    //   68: invokevirtual 183	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   71: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: new 185	java/io/IOException
    //   78: dup
    //   79: aload_1
    //   80: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokespecial 186	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   86: athrow
    //   87: aload 7
    //   89: invokestatic 188	com/tencent/hydevteam/pluginframework/pluginmanager/MinFileUtils:c	(Ljava/io/File;)V
    //   92: new 190	com/tencent/commonsdk/zip/QZipInputStream
    //   95: dup
    //   96: new 64	java/io/FileInputStream
    //   99: dup
    //   100: aload_1
    //   101: invokespecial 68	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   104: invokespecial 191	com/tencent/commonsdk/zip/QZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore 6
    //   109: aload 6
    //   111: invokevirtual 195	com/tencent/commonsdk/zip/QZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   114: astore_1
    //   115: aload_1
    //   116: ifnull +116 -> 232
    //   119: aload_1
    //   120: invokevirtual 200	java/util/zip/ZipEntry:isDirectory	()Z
    //   123: istore_3
    //   124: iload_3
    //   125: ifne -16 -> 109
    //   128: aconst_null
    //   129: astore 4
    //   131: new 202	java/io/BufferedOutputStream
    //   134: dup
    //   135: new 204	java/io/FileOutputStream
    //   138: dup
    //   139: new 13	java/io/File
    //   142: dup
    //   143: aload 7
    //   145: aload_1
    //   146: invokevirtual 205	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   149: invokespecial 18	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   152: invokespecial 206	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   155: invokespecial 209	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   158: astore_1
    //   159: new 211	java/io/BufferedInputStream
    //   162: dup
    //   163: aload 6
    //   165: invokespecial 212	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   168: astore 4
    //   170: sipush 8192
    //   173: newarray byte
    //   175: astore 8
    //   177: aload 4
    //   179: aload 8
    //   181: iconst_0
    //   182: sipush 8192
    //   185: invokevirtual 216	java/io/BufferedInputStream:read	([BII)I
    //   188: istore_2
    //   189: iload_2
    //   190: iflt +14 -> 204
    //   193: aload_1
    //   194: aload 8
    //   196: iconst_0
    //   197: iload_2
    //   198: invokevirtual 220	java/io/BufferedOutputStream:write	([BII)V
    //   201: goto -24 -> 177
    //   204: aload 6
    //   206: invokevirtual 223	com/tencent/commonsdk/zip/QZipInputStream:closeEntry	()V
    //   209: aload_1
    //   210: invokevirtual 224	java/io/BufferedOutputStream:close	()V
    //   213: goto -104 -> 109
    //   216: aload 6
    //   218: invokevirtual 223	com/tencent/commonsdk/zip/QZipInputStream:closeEntry	()V
    //   221: aload_1
    //   222: ifnull +7 -> 229
    //   225: aload_1
    //   226: invokevirtual 224	java/io/BufferedOutputStream:close	()V
    //   229: aload 4
    //   231: athrow
    //   232: aload 7
    //   234: invokestatic 172	com/tencent/hydevteam/pluginframework/pluginmanager/UnpackManager:f	(Ljava/io/File;)Lcom/tencent/hydevteam/pluginframework/installedplugin/InstalledPlugin;
    //   237: astore_1
    //   238: aload 5
    //   240: invokevirtual 227	java/io/File:createNewFile	()Z
    //   243: pop
    //   244: aload 6
    //   246: invokevirtual 228	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   249: aload_1
    //   250: areturn
    //   251: astore_1
    //   252: aload 6
    //   254: invokevirtual 228	com/tencent/commonsdk/zip/QZipInputStream:close	()V
    //   257: goto +5 -> 262
    //   260: aload_1
    //   261: athrow
    //   262: goto -2 -> 260
    //   265: astore 4
    //   267: goto -223 -> 44
    //   270: astore 4
    //   272: goto -56 -> 216
    //   275: astore 5
    //   277: aload 4
    //   279: astore_1
    //   280: aload 5
    //   282: astore 4
    //   284: goto -68 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	UnpackManager
    //   0	287	1	paramFile	File
    //   188	10	2	i	int
    //   123	2	3	bool	boolean
    //   39	191	4	localObject1	Object
    //   265	1	4	localException	Exception
    //   270	8	4	localObject2	Object
    //   282	1	4	localObject3	Object
    //   18	221	5	localFile1	File
    //   275	6	5	localObject4	Object
    //   107	146	6	localQZipInputStream	com.tencent.commonsdk.zip.QZipInputStream
    //   5	228	7	localFile2	File
    //   175	20	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   109	115	251	finally
    //   119	124	251	finally
    //   204	213	251	finally
    //   216	221	251	finally
    //   225	229	251	finally
    //   229	232	251	finally
    //   232	244	251	finally
    //   34	41	265	java/lang/Exception
    //   159	177	270	finally
    //   177	189	270	finally
    //   193	201	270	finally
    //   131	159	275	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.UnpackManager
 * JD-Core Version:    0.7.0.1
 */