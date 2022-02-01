package com.tencent.mobileqq.app.message.messageclean;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class FileCleanManager
{
  private String a;
  private int b;
  private String c;
  private int d;
  private String e;
  private int f;
  private ConcurrentHashMap<String, FileInfo> g;
  private IFileScanListener h;
  private volatile boolean i = false;
  private volatile boolean j = false;
  
  public FileCleanManager(IFileScanListener paramIFileScanListener)
  {
    this.h = paramIFileScanListener;
  }
  
  private int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return 0;
        }
        return this.f;
      }
      return this.d;
    }
    return this.b;
  }
  
  private void a(String paramString, int paramInt)
  {
    paramString = new File(paramString);
    if (paramString.exists())
    {
      File[] arrayOfFile = paramString.listFiles();
      if (arrayOfFile != null)
      {
        if (arrayOfFile.length == 0) {
          return;
        }
        int m = arrayOfFile.length;
        int k = 0;
        while (k < m)
        {
          File localFile = arrayOfFile[k];
          if (localFile.isDirectory())
          {
            a(localFile.getAbsolutePath(), paramInt);
          }
          else
          {
            int n = a(paramInt);
            paramString = localFile.getAbsolutePath();
            int i1 = paramString.length();
            FileInfo localFileInfo = new FileInfo();
            if (i1 > n) {
              paramString = paramString.substring(n, i1);
            } else {
              paramString = "";
            }
            localFileInfo.a = paramString;
            localFileInfo.b = localFile.length();
            localFileInfo.c = paramInt;
            localFileInfo.d = 0;
            paramString = this.g;
            if (paramString == null) {
              break;
            }
            paramString.put(localFile.getName(), localFileInfo);
          }
          k += 1;
        }
      }
    }
  }
  
  private String b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "";
        }
        return this.e;
      }
      return this.c;
    }
    return this.a;
  }
  
  private void e()
  {
    if ((this.h != null) && (b()))
    {
      this.h.a();
      if (QLog.isColorLevel()) {
        QLog.e("FileCleanManager", 2, "fileScanNotify onScanFinish");
      }
    }
  }
  
  private void f()
  {
    this.a = g();
    this.c = h();
    this.e = i();
    this.b = this.a.length();
    this.d = this.c.length();
    this.f = this.e.length();
  }
  
  private String g()
  {
    return RmVFSUtils.getVFSPath(AbsDownloader.CHAT_IMAGE_ROOT);
  }
  
  private String h()
  {
    return SVUtils.c();
  }
  
  private String i()
  {
    return AppConstants.SDCARD_FILE_SAVE_PATH;
  }
  
  private void j()
  {
    a(this.a, 1);
  }
  
  private void k()
  {
    a(this.c, 2);
  }
  
  private void l()
  {
    a(this.e, 3);
  }
  
  private void m()
  {
    this.i = false;
    this.j = false;
    ConcurrentHashMap localConcurrentHashMap = this.g;
    if (localConcurrentHashMap != null)
    {
      localConcurrentHashMap.clear();
      this.g = null;
    }
  }
  
  public String a(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(b(paramFileInfo.c));
    localStringBuffer.append(paramFileInfo.a);
    return localStringBuffer.toString();
  }
  
  public void a()
  {
    m();
    this.g = new ConcurrentHashMap();
    f();
    ThreadManagerV2.excute(new FileCleanManager.1(this), 64, null, true);
    ThreadManagerV2.excute(new FileCleanManager.2(this), 64, null, true);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ConcurrentHashMap localConcurrentHashMap = this.g;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.remove(paramString);
      }
    }
  }
  
  public void a(String paramString, FileInfo paramFileInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramFileInfo != null))
    {
      ConcurrentHashMap localConcurrentHashMap = this.g;
      if (localConcurrentHashMap != null) {
        localConcurrentHashMap.put(paramString, paramFileInfo);
      }
    }
  }
  
  public void a(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        FileUtils.deleteFile((String)paramList.next());
      }
    }
  }
  
  public boolean b()
  {
    return (this.i) && (this.j);
  }
  
  public ConcurrentHashMap<String, FileInfo> c()
  {
    return this.g;
  }
  
  public void d()
  {
    m();
    this.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.FileCleanManager
 * JD-Core Version:    0.7.0.1
 */