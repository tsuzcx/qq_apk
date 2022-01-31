package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.common.progress.ProgressFutureImpl;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

class SimpleURLConnectionDownloader
  implements Downloader
{
  private final ExecutorService a = Executors.newSingleThreadExecutor();
  
  public ProgressFuture<File> download(TargetDownloadInfo paramTargetDownloadInfo, File paramFile1, File paramFile2)
  {
    AtomicLong localAtomicLong = new AtomicLong(0L);
    final double d = paramTargetDownloadInfo.size;
    paramTargetDownloadInfo = new DownloadTask(paramTargetDownloadInfo, paramFile1, paramFile2, localAtomicLong);
    new ProgressFutureImpl(this.a.submit(paramTargetDownloadInfo), d)
    {
      public double getProgress()
      {
        double d = 0.0D;
        if ((d != 0.0D) && (!isDone())) {
          d = this.b.get() / d;
        }
        while (!isDone()) {
          return d;
        }
        return 1.0D;
      }
    };
  }
  
  class DownloadTask
    implements Callable<File>
  {
    private File b;
    private File c;
    private AtomicLong d;
    
    DownloadTask(File paramFile1, File paramFile2, AtomicLong paramAtomicLong)
    {
      this.b = paramFile1;
      this.d = paramAtomicLong;
      this.c = paramFile2;
    }
    
    private File a()
      throws Exception
    {
      String str = null;
      Object localObject1 = str;
      if (!SimpleURLConnectionDownloader.this.hash.isEmpty()) {}
      try
      {
        localObject1 = MessageDigest.getInstance("MD5");
        str = SimpleURLConnectionDownloader.this.url;
        localObject6 = new URL(str);
        arrayOfByte = null;
        try
        {
          localObject6 = ((URL)localObject6).openConnection();
          if ((localObject6 instanceof HttpURLConnection)) {
            break label107;
          }
          throw new Error(str + "连接不是http(s)协议的");
        }
        finally
        {
          localObject1 = arrayOfByte;
        }
        if (localObject1 != null) {
          ((RandomAccessFile)localObject1).close();
        }
        throw localObject3;
        label107:
        localObject6 = (HttpURLConnection)localObject6;
        if ((this.c.exists()) && (!this.c.delete())) {
          throw new Exception("无法删除" + this.c.getAbsolutePath());
        }
        localObject4 = this.c.getParentFile();
        ((File)localObject4).mkdirs();
        if (!((File)localObject4).isDirectory()) {
          throw new Exception("创建目录失败:" + ((File)localObject4).getAbsolutePath());
        }
        this.c.createNewFile();
        localObject4 = new RandomAccessFile(this.c, "rw");
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;)
        {
          try
          {
            byte[] arrayOfByte = new byte[4096];
            if (((HttpURLConnection)localObject6).getResponseCode() != 200) {
              throw new Error("连接返回值不是200,而为" + ((HttpURLConnection)localObject6).getResponseCode());
            }
            Object localObject6 = new BufferedInputStream(((HttpURLConnection)localObject6).getInputStream());
            int i = ((BufferedInputStream)localObject6).read(arrayOfByte);
            if (i > 0)
            {
              ((RandomAccessFile)localObject4).write(arrayOfByte, 0, i);
              this.d.getAndAdd(i);
              if (localObject1 != null) {
                ((MessageDigest)localObject1).update(arrayOfByte, 0, i);
              }
              if (!Thread.interrupted()) {
                continue;
              }
              throw new Error("interrupted");
            }
            ((BufferedInputStream)localObject6).close();
            ((RandomAccessFile)localObject4).close();
            if (localObject1 != null)
            {
              localObject1 = ((MessageDigest)localObject1).digest();
              localObject4 = new StringBuilder(localObject1.length << 1);
              int j = localObject1.length;
              i = 0;
              if (i < j)
              {
                ((StringBuilder)localObject4).append(Integer.toHexString(localObject1[i] & 0xFF | 0x100).substring(1, 3));
                i += 1;
                continue;
              }
              localObject1 = ((StringBuilder)localObject4).toString();
              if (!((String)localObject1).equalsIgnoreCase(SimpleURLConnectionDownloader.this.hash)) {
                throw new Error("MD5检验失败expect==" + SimpleURLConnectionDownloader.this.hash + " actual==" + (String)localObject1);
              }
            }
            MinFileUtils.a(this.b);
            if (!this.c.renameTo(this.b)) {
              throw new Exception("重命名失败: " + this.c.getAbsolutePath() + "->" + this.b.getAbsolutePath());
            }
            return this.b;
          }
          finally
          {
            Object localObject2 = localObject4;
            Object localObject4 = localObject5;
          }
          localNoSuchAlgorithmException = localNoSuchAlgorithmException;
          localObject2 = localObject4;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.SimpleURLConnectionDownloader
 * JD-Core Version:    0.7.0.1
 */