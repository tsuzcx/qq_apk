package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.UseDynamicPluginLoaderInstalledPlugin;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONException;
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
    return new File(paramFile.getParentFile(), "unpacked." + paramFile.getName());
  }
  
  private static InstalledPlugin f(File paramFile)
    throws IOException, JSONException
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
        ((StringBuilder)localObject2).append(str1).append("\n");
      }
    }
    finally
    {
      ((BufferedReader)localObject1).close();
    }
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
        if ((e((File)localObject).exists()) && (!d((File)localObject))) {
          try
          {
            localObject = f((File)localObject);
            return localObject;
          }
          catch (Exception localException)
          {
            localFile.delete();
          }
        }
      }
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
  
  final InstalledPlugin c(File paramFile)
    throws IOException, JSONException
  {
    File localFile2 = a(paramFile);
    localFile2.mkdirs();
    File localFile1 = e(localFile2);
    if (e(a(paramFile)).exists()) {
      try
      {
        InstalledPlugin localInstalledPlugin = f(localFile2);
        return localInstalledPlugin;
      }
      catch (Exception localException)
      {
        if (!localFile1.delete()) {
          throw new IOException("解析版本信息失败，且无法删除标记:" + localFile1.getAbsolutePath());
        }
      }
    }
    MinFileUtils.c(localFile2);
    ZipInputStream localZipInputStream = new ZipInputStream(new FileInputStream(paramFile));
    for (;;)
    {
      try
      {
        paramFile = localZipInputStream.getNextEntry();
        if (paramFile != null)
        {
          boolean bool = paramFile.isDirectory();
          if (bool) {
            continue;
          }
          localBufferedInputStream = null;
        }
      }
      finally
      {
        BufferedInputStream localBufferedInputStream;
        localZipInputStream.close();
      }
      try
      {
        paramFile = new BufferedOutputStream(new FileOutputStream(new File(localFile2, paramFile.getName())));
        try
        {
          localBufferedInputStream = new BufferedInputStream(localZipInputStream);
          byte[] arrayOfByte = new byte[8192];
          int i = localBufferedInputStream.read(arrayOfByte, 0, 8192);
          if (i < 0) {
            break label225;
          }
          paramFile.write(arrayOfByte, 0, i);
          continue;
          localZipInputStream.closeEntry();
        }
        finally {}
      }
      finally
      {
        paramFile = localObject1;
        Object localObject2 = localObject3;
        continue;
      }
      if (paramFile != null) {
        paramFile.close();
      }
      throw localObject1;
      label225:
      localZipInputStream.closeEntry();
      paramFile.close();
    }
    paramFile = f(localFile2);
    localFile1.createNewFile();
    localZipInputStream.close();
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.UnpackManager
 * JD-Core Version:    0.7.0.1
 */