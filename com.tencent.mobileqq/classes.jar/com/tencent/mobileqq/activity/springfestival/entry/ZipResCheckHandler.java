package com.tencent.mobileqq.activity.springfestival.entry;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.springfestival.entry.model.ZipRes;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wifi.WifiSdkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ZipResCheckHandler
  implements Handler.Callback, IZipResCheck
{
  IZipResCheck.OnZipResCheckCallback a;
  CopyOnWriteArrayList<ZipRes> b = new CopyOnWriteArrayList();
  volatile int c;
  Handler d = new Handler(ThreadManager.getSubThreadLooper(), this);
  
  public ZipResCheckHandler(IZipResCheck.OnZipResCheckCallback paramOnZipResCheckCallback)
  {
    this.a = paramOnZipResCheckCallback;
  }
  
  @Nullable
  private ZipRes a(@NotNull String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ZipRes localZipRes = (ZipRes)localIterator.next();
      if (paramString.equals(localZipRes.url)) {
        return localZipRes;
      }
    }
    return null;
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = ((List)paramMessage.obj).iterator();
    boolean bool = true;
    while (paramMessage.hasNext()) {
      bool &= a((ZipRes)paramMessage.next(), true);
    }
    paramMessage = this.a;
    if (paramMessage != null) {
      paramMessage.a(bool, this.c);
    }
  }
  
  private void a(ZipRes paramZipRes)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.filePos = 0;
    localDownloadParam.url = paramZipRes.url;
    localDownloadParam.md5 = paramZipRes.md5;
    localDownloadParam.isForceUnzip = true;
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_ZipResCheckHandler", 2, String.format("downloadZipRes [%s]", new Object[] { paramZipRes }));
    }
    PreloadStaticApi.a().getResPath(localDownloadParam, new ZipResCheckHandler.1(this, paramZipRes));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramBoolean) {
        return;
      }
      ZipRes localZipRes = a(paramString);
      if (QLog.isColorLevel())
      {
        if (localZipRes != null) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        QLog.i("shua2021_ZipResCheckHandler", 2, String.format("onZipResDownloaded url=%s findZipRes=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
      }
      if (localZipRes != null)
      {
        if (!localZipRes.isNecessary) {
          return;
        }
        if (a(localZipRes, false)) {
          a(false);
        }
      }
    }
  }
  
  private boolean a(ZipRes paramZipRes, boolean paramBoolean)
  {
    try
    {
      if (paramZipRes.isRecentlyCheckOk()) {
        return true;
      }
      String str1 = PreloadStaticApi.a(paramZipRes.url);
      String str2 = PreloadResHandler.c(paramZipRes.url);
      boolean bool3 = PreloadStaticApi.f(str2);
      boolean bool1;
      boolean bool2;
      if (!bool3)
      {
        bool1 = false;
        bool2 = false;
      }
      else
      {
        bool2 = b(str2);
        if (!bool2)
        {
          bool1 = false;
        }
        else
        {
          paramZipRes.markRecentlyCheckOk();
          bool1 = true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_ZipResCheckHandler", 2, String.format("checkZipRes checkOk=%b zipFolderValid=%b checkIntegrity=%b \nzipRes=%s \nzipFilePath=%s zipFolderPath=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2), paramZipRes, str1, str2 }));
      }
      if ((!bool1) && (paramBoolean))
      {
        c(str1);
        c(str2);
        a(paramZipRes);
      }
      return bool1;
    }
    catch (Throwable paramZipRes)
    {
      SpringHbMonitorReporter.a(401, paramZipRes, new String[0]);
      QLog.d("shua2021_ZipResCheckHandler", 1, paramZipRes.getMessage(), paramZipRes);
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ZipRes localZipRes = (ZipRes)((Iterator)localObject).next();
      if ((localZipRes.isNecessary) && (!TextUtils.isEmpty(localZipRes.url)) && (!localZipRes.isRecentlyCheckOk())) {
        localArrayList.add(localZipRes);
      }
    }
    this.d.removeMessages(1);
    if (!localArrayList.isEmpty())
    {
      Message.obtain(this.d, 1, 0, 0, localArrayList).sendToTarget();
    }
    else if (!paramBoolean)
    {
      localObject = this.a;
      if (localObject != null) {
        ((IZipResCheck.OnZipResCheckCallback)localObject).a(true, this.c);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_ZipResCheckHandler", 2, String.format("makeCheckAllResIfNeed needCheck=%b", new Object[] { Boolean.valueOf(localArrayList.isEmpty() ^ true) }));
    }
    return localArrayList.isEmpty() ^ true;
  }
  
  private boolean b(String paramString)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append("list.txt");
        localObject1 = WifiSdkUtil.a(new File(((StringBuilder)localObject1).toString()));
        if (((List)localObject1).isEmpty())
        {
          QLog.d("shua2021_ZipResCheckHandler", 1, String.format("checkIntegrityOfFolder md5List is empty. folder=%s", new Object[] { paramString }));
          return false;
        }
        Object localObject2 = new File(paramString);
        if (((File)localObject2).isDirectory())
        {
          localObject2 = ((File)localObject2).listFiles();
          if (localObject2 == null) {
            i = 0;
          } else {
            i = localObject2.length;
          }
          if ((i != 0) && (i >= ((List)localObject1).size() + 1))
          {
            int k = localObject2.length;
            i = 0;
            if (i < k)
            {
              paramString = MD5Coding.encodeFile2HexStr(localObject2[i].getPath());
              if (TextUtils.isEmpty(paramString)) {
                break label371;
              }
              j = ((List)localObject1).size() - 1;
              if (j < 0) {
                break label371;
              }
              if (!paramString.equalsIgnoreCase((String)((List)localObject1).get(j))) {
                break label364;
              }
              ((List)localObject1).remove(j);
              break label364;
            }
          }
          else
          {
            QLog.d("shua2021_ZipResCheckHandler", 1, String.format("checkIntegrityOfFolder size not match. md5.size=%d fileSize=%d folder=%s", new Object[] { Integer.valueOf(((List)localObject1).size()), Integer.valueOf(i), paramString }));
            return false;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("shua2021_ZipResCheckHandler", 2, String.format("checkIntegrityOfFolder checkOk=%b remainMd5List=%s", new Object[] { Boolean.valueOf(((List)localObject1).isEmpty()), localObject1 }));
        }
        boolean bool = ((List)localObject1).isEmpty();
        return bool;
      }
      catch (Throwable paramString)
      {
        SpringHbMonitorReporter.a(402, paramString, new String[0]);
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkIntegrityOfFolder");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        QLog.d("shua2021_ZipResCheckHandler", 1, ((StringBuilder)localObject1).toString(), paramString);
        return false;
      }
      label364:
      j -= 1;
      continue;
      label371:
      i += 1;
    }
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    try
    {
      FileUtils.deleteFile(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d("shua2021_ZipResCheckHandler", 1, paramString.getMessage(), paramString);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    try
    {
      a(paramMessage);
      return false;
    }
    catch (Throwable paramMessage)
    {
      SpringHbMonitorReporter.a(403, paramMessage, new String[0]);
      QLog.d("shua2021_ZipResCheckHandler", 1, paramMessage.getMessage(), paramMessage);
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.d.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ZipResCheckHandler
 * JD-Core Version:    0.7.0.1
 */