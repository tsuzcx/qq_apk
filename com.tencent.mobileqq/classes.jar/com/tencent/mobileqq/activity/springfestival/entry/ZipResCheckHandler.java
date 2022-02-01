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
  volatile int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  IZipResCheck.OnZipResCheckCallback jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIZipResCheck$OnZipResCheckCallback;
  CopyOnWriteArrayList<ZipRes> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public ZipResCheckHandler(IZipResCheck.OnZipResCheckCallback paramOnZipResCheckCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIZipResCheck$OnZipResCheckCallback = paramOnZipResCheckCallback;
  }
  
  @Nullable
  private ZipRes a(@NotNull String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
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
    for (boolean bool = true; paramMessage.hasNext(); bool = a((ZipRes)paramMessage.next(), true) & bool) {}
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIZipResCheck$OnZipResCheckCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIZipResCheck$OnZipResCheckCallback.a(bool, this.jdField_a_of_type_Int);
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
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = new File(paramString);
    } while (!paramString.exists());
    try
    {
      FileUtils.a(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.d("shua2021_ZipResCheckHandler", 1, paramString.getMessage(), paramString);
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBoolean)) {
      return;
    }
    ZipRes localZipRes = a(paramString);
    if (QLog.isColorLevel()) {
      if (localZipRes == null) {
        break label83;
      }
    }
    label83:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.i("shua2021_ZipResCheckHandler", 2, String.format("onZipResDownloaded url=%s findZipRes=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
      if ((localZipRes == null) || (!localZipRes.isNecessary) || (!a(localZipRes, false))) {
        break;
      }
      a(false);
      return;
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
      boolean bool3 = PreloadStaticApi.b(str2);
      boolean bool2;
      boolean bool1;
      if (!bool3)
      {
        bool2 = false;
        bool1 = false;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("shua2021_ZipResCheckHandler", 2, String.format("checkZipRes checkOk=%b zipFolderValid=%b checkIntegrity=%b \nzipRes=%s \nzipFilePath=%s zipFolderPath=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2), paramZipRes, str1, str2 }));
        }
        if ((bool1) || (!paramBoolean)) {
          break;
        }
        a(str1);
        a(str2);
        a(paramZipRes);
        break;
        bool2 = a(str2);
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
      return bool1;
    }
    catch (Throwable paramZipRes)
    {
      SpringHbMonitorReporter.a(401, paramZipRes, new String[0]);
      QLog.d("shua2021_ZipResCheckHandler", 1, paramZipRes.getMessage(), paramZipRes);
      return false;
    }
  }
  
  private boolean a(String paramString)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        List localList = WifiSdkUtil.a(new File(paramString + File.separator + "list.txt"));
        if (localList.isEmpty())
        {
          QLog.d("shua2021_ZipResCheckHandler", 1, String.format("checkIntegrityOfFolder md5List is empty. folder=%s", new Object[] { paramString }));
          return false;
        }
        Object localObject = new File(paramString);
        if (((File)localObject).isDirectory())
        {
          localObject = ((File)localObject).listFiles();
          if (localObject == null)
          {
            i = 0;
            if ((i == 0) || (i < localList.size() + 1))
            {
              QLog.d("shua2021_ZipResCheckHandler", 1, String.format("checkIntegrityOfFolder size not match. md5.size=%d fileSize=%d folder=%s", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(i), paramString }));
              return false;
            }
          }
          else
          {
            i = localObject.length;
            continue;
          }
          int k = localObject.length;
          i = 0;
          if (i < k)
          {
            paramString = MD5Coding.encodeFile2HexStr(localObject[i].getPath());
            if (TextUtils.isEmpty(paramString)) {
              break label344;
            }
            j = localList.size() - 1;
            if (j < 0) {
              break label344;
            }
            if (!paramString.equalsIgnoreCase((String)localList.get(j))) {
              break label337;
            }
            localList.remove(j);
            break label337;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("shua2021_ZipResCheckHandler", 2, String.format("checkIntegrityOfFolder checkOk=%b remainMd5List=%s", new Object[] { Boolean.valueOf(localList.isEmpty()), localList }));
        }
        boolean bool = localList.isEmpty();
        return bool;
      }
      catch (Throwable paramString)
      {
        SpringHbMonitorReporter.a(402, paramString, new String[0]);
        QLog.d("shua2021_ZipResCheckHandler", 1, "checkIntegrityOfFolder" + paramString.getMessage(), paramString);
        return false;
      }
      label337:
      j -= 1;
      continue;
      label344:
      i += 1;
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      ZipRes localZipRes = (ZipRes)localIterator.next();
      if ((localZipRes.isNecessary) && (!TextUtils.isEmpty(localZipRes.url)) && (!localZipRes.isRecentlyCheckOk())) {
        localArrayList.add(localZipRes);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (!localArrayList.isEmpty())
    {
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, 0, 0, localArrayList).sendToTarget();
      if (QLog.isColorLevel()) {
        if (localArrayList.isEmpty()) {
          break label185;
        }
      }
    }
    label185:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.i("shua2021_ZipResCheckHandler", 2, String.format("makeCheckAllResIfNeed needCheck=%b", new Object[] { Boolean.valueOf(paramBoolean) }));
      if (localArrayList.isEmpty()) {
        break label190;
      }
      return true;
      if ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIZipResCheck$OnZipResCheckCallback == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntryIZipResCheck$OnZipResCheckCallback.a(true, this.jdField_a_of_type_Int);
      break;
    }
    label190:
    return false;
  }
  
  public boolean a(List<ZipRes> paramList, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(paramList);
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_ZipResCheckHandler", 2, String.format("onGetZipResList resSize=%d cfgVer=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    return a(true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
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
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.ZipResCheckHandler
 * JD-Core Version:    0.7.0.1
 */