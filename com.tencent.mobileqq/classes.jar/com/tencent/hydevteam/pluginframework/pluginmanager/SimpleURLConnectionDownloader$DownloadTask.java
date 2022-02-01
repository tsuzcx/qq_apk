package com.tencent.hydevteam.pluginframework.pluginmanager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

class SimpleURLConnectionDownloader$DownloadTask
  implements Callable<File>
{
  final File a;
  private TargetDownloadInfo b;
  private File c;
  private AtomicLong d;
  
  SimpleURLConnectionDownloader$DownloadTask(TargetDownloadInfo paramTargetDownloadInfo, File paramFile1, File paramFile2, AtomicLong paramAtomicLong)
  {
    this.b = paramTargetDownloadInfo;
    this.a = paramFile1;
    this.d = paramAtomicLong;
    this.c = paramFile2;
  }
  
  public File a()
  {
    a(b());
    return this.a;
  }
  
  final void a(HttpURLConnection paramHttpURLConnection)
  {
    if ((this.c.exists()) && (!this.c.delete()))
    {
      paramHttpURLConnection = new StringBuilder("无法删除");
      paramHttpURLConnection.append(this.c.getAbsolutePath());
      throw new Exception(paramHttpURLConnection.toString());
    }
    Object localObject1 = this.c.getParentFile();
    ((File)localObject1).mkdirs();
    if (((File)localObject1).isDirectory())
    {
      this.c.createNewFile();
      try
      {
        boolean bool = this.b.hash.isEmpty();
        if (bool) {}
      }
      finally
      {
        label115:
        RandomAccessFile localRandomAccessFile;
        paramHttpURLConnection = null;
      }
    }
    try
    {
      localObject1 = MessageDigest.getInstance("MD5");
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      break label115;
    }
    localObject1 = null;
    localRandomAccessFile = new RandomAccessFile(this.c, "rw");
    try
    {
      byte[] arrayOfByte = new byte[4096];
      paramHttpURLConnection = new BufferedInputStream(paramHttpURLConnection.getInputStream());
      int j;
      int i;
      do
      {
        j = paramHttpURLConnection.read(arrayOfByte);
        i = 0;
        if (j <= 0) {
          break;
        }
        localRandomAccessFile.write(arrayOfByte, 0, j);
        this.d.getAndAdd(j);
        if (localObject1 != null) {
          ((MessageDigest)localObject1).update(arrayOfByte, 0, j);
        }
      } while (!Thread.interrupted());
      throw new Error("interrupted");
      paramHttpURLConnection.close();
      localRandomAccessFile.close();
      if (localObject1 != null)
      {
        paramHttpURLConnection = ((MessageDigest)localObject1).digest();
        localObject1 = new StringBuilder(paramHttpURLConnection.length << 1);
        j = paramHttpURLConnection.length;
        while (i < j)
        {
          ((StringBuilder)localObject1).append(Integer.toHexString(paramHttpURLConnection[i] & 0xFF | 0x100).substring(1, 3));
          i += 1;
        }
        paramHttpURLConnection = ((StringBuilder)localObject1).toString();
        if (!paramHttpURLConnection.equalsIgnoreCase(this.b.hash))
        {
          localObject1 = new StringBuilder("MD5检验失败expect==");
          ((StringBuilder)localObject1).append(this.b.hash);
          ((StringBuilder)localObject1).append(" actual==");
          ((StringBuilder)localObject1).append(paramHttpURLConnection);
          throw new Error(((StringBuilder)localObject1).toString());
        }
      }
      MinFileUtils.a(this.a);
      if (this.c.renameTo(this.a)) {
        return;
      }
      paramHttpURLConnection = new StringBuilder("重命名失败: ");
      paramHttpURLConnection.append(this.c.getAbsolutePath());
      paramHttpURLConnection.append("->");
      paramHttpURLConnection.append(this.a.getAbsolutePath());
      throw new Exception(paramHttpURLConnection.toString());
    }
    finally
    {
      paramHttpURLConnection = localRandomAccessFile;
    }
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.close();
    }
    throw localObject3;
    paramHttpURLConnection = new StringBuilder("创建目录失败:");
    paramHttpURLConnection.append(localObject3.getAbsolutePath());
    paramHttpURLConnection = new Exception(paramHttpURLConnection.toString());
    for (;;)
    {
      throw paramHttpURLConnection;
    }
  }
  
  final HttpURLConnection b()
  {
    Object localObject1 = this.b.url;
    Object localObject2 = new URL((String)localObject1).openConnection();
    if ((localObject2 instanceof HttpURLConnection))
    {
      localObject1 = (HttpURLConnection)localObject2;
      if (((HttpURLConnection)localObject1).getResponseCode() == 200) {
        return localObject1;
      }
      localObject2 = new StringBuilder("连接返回值不是200,而为");
      ((StringBuilder)localObject2).append(((HttpURLConnection)localObject1).getResponseCode());
      throw new Error(((StringBuilder)localObject2).toString());
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("连接不是http(s)协议的");
    throw new Error(((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.SimpleURLConnectionDownloader.DownloadTask
 * JD-Core Version:    0.7.0.1
 */