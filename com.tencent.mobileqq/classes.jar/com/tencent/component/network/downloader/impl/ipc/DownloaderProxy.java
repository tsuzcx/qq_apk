package com.tencent.component.network.downloader.impl.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Message;
import android.os.Messenger;
import com.tencent.component.network.downloader.DownloadRequest;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.MultiHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DownloaderProxy
  extends Downloader
{
  private int jdField_a_of_type_Int;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  private Messenger jdField_a_of_type_AndroidOsMessenger;
  private final MultiHashMap jdField_a_of_type_ComTencentComponentNetworkUtilsMultiHashMap;
  private final List jdField_a_of_type_JavaUtilList;
  private Messenger b;
  
  private void a()
  {
    Intent localIntent;
    if (this.jdField_a_of_type_AndroidOsMessenger == null)
    {
      localIntent = new Intent();
      localIntent.setComponent(new ComponentName(this.mContext, "com.tencent.component.network.downloader.impl.ipc.DownloadSerice"));
    }
    try
    {
      this.mContext.bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      return;
    }
    catch (Throwable localThrowable)
    {
      QDLog.d("RemoteDownloader", "exception when bind download service!!!", localThrowable);
    }
  }
  
  private void a(String paramString, String[] paramArrayOfString, Downloader.DownloadMode paramDownloadMode)
  {
    paramString = Const.a(paramString, paramArrayOfString, this.jdField_a_of_type_Int, paramDownloadMode, this.b);
    try
    {
      if (this.jdField_a_of_type_AndroidOsMessenger != null) {
        this.jdField_a_of_type_AndroidOsMessenger.send(paramString);
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(Collection paramCollection)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Const.SimpleRequest localSimpleRequest = (Const.SimpleRequest)paramCollection.next();
        if (localSimpleRequest != null)
        {
          Downloader.DownloadListener localDownloadListener = localSimpleRequest.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener;
          if (localDownloadListener != null) {
            localDownloadListener.onDownloadCanceled(localSimpleRequest.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
  }
  
  private boolean a(String paramString, Const.SimpleRequest paramSimpleRequest, Collection paramCollection)
  {
    boolean bool2 = false;
    if (paramSimpleRequest == null) {
      return false;
    }
    synchronized (this.jdField_a_of_type_ComTencentComponentNetworkUtilsMultiHashMap)
    {
      int i = this.jdField_a_of_type_ComTencentComponentNetworkUtilsMultiHashMap.sizeOf(paramString);
      if (paramCollection != null) {
        paramCollection.clear();
      }
      if ((this.jdField_a_of_type_ComTencentComponentNetworkUtilsMultiHashMap.remove(paramString, paramSimpleRequest)) && (paramCollection != null)) {
        paramCollection.add(paramSimpleRequest);
      }
      boolean bool1 = bool2;
      if (i > 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentComponentNetworkUtilsMultiHashMap.sizeOf(paramString) == 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  private boolean a(String arg1, String paramString2, Const.SimpleRequest paramSimpleRequest)
  {
    boolean bool = false;
    if (paramSimpleRequest == null) {
      return false;
    }
    synchronized (this.jdField_a_of_type_ComTencentComponentNetworkUtilsMultiHashMap)
    {
      int i = this.jdField_a_of_type_ComTencentComponentNetworkUtilsMultiHashMap.sizeOf(paramString2);
      this.jdField_a_of_type_ComTencentComponentNetworkUtilsMultiHashMap.add(paramString2, paramSimpleRequest);
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public void abort(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    if (!Utils.checkUrl(paramString)) {
      return;
    }
    Const.SimpleRequest localSimpleRequest = new Const.SimpleRequest();
    localSimpleRequest.jdField_a_of_type_JavaLangString = paramString;
    localSimpleRequest.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = paramDownloadListener;
    paramDownloadListener = new ArrayList();
    if (a(paramString, localSimpleRequest, paramDownloadListener))
    {
      paramString = Const.a(paramString, this.jdField_a_of_type_Int, this.b);
      if (this.jdField_a_of_type_AndroidOsMessenger == null) {}
    }
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.send(paramString);
      a(paramDownloadListener);
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void cancel(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    if (!Utils.checkUrl(paramString)) {
      return;
    }
    Const.SimpleRequest localSimpleRequest = new Const.SimpleRequest();
    localSimpleRequest.jdField_a_of_type_JavaLangString = paramString;
    localSimpleRequest.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = paramDownloadListener;
    paramDownloadListener = new ArrayList();
    if (a(paramString, localSimpleRequest, paramDownloadListener))
    {
      paramString = Const.a(paramString, this.jdField_a_of_type_Int, this.b);
      if (this.jdField_a_of_type_AndroidOsMessenger == null) {}
    }
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.send(paramString);
      a(paramDownloadListener);
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void cancelAll() {}
  
  public void cleanCache()
  {
    Message localMessage = Const.b("", this.jdField_a_of_type_Int, this.b);
    if (this.jdField_a_of_type_AndroidOsMessenger != null) {}
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.send(localMessage);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void cleanCache(String paramString)
  {
    if (!Utils.checkUrl(paramString)) {}
    do
    {
      return;
      paramString = Const.b(paramString, this.jdField_a_of_type_Int, this.b);
    } while (this.jdField_a_of_type_AndroidOsMessenger == null);
    try
    {
      this.jdField_a_of_type_AndroidOsMessenger.send(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean download(DownloadRequest arg1, boolean paramBoolean)
  {
    paramBoolean = true;
    int i = 0;
    String str = ???.getUrl();
    String[] arrayOfString = ???.getPaths();
    if ((!Utils.checkUrl(str)) || (arrayOfString == null)) {
      paramBoolean = false;
    }
    do
    {
      return paramBoolean;
      Const.SimpleRequest localSimpleRequest1 = new Const.SimpleRequest();
      localSimpleRequest1.jdField_a_of_type_JavaLangString = str;
      int j = arrayOfString.length;
      while (i < j)
      {
        localSimpleRequest1.a(arrayOfString[i]);
        i += 1;
      }
      localSimpleRequest1.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = ???.getListener();
      localSimpleRequest1.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadMode = ???.mode;
      if (this.jdField_a_of_type_AndroidOsMessenger == null) {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_JavaUtilList.add(localSimpleRequest1);
          a();
          return true;
        }
      }
    } while (!a(str, str, localSimpleRequest2));
    a(str, arrayOfString, ???.mode);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.DownloaderProxy
 * JD-Core Version:    0.7.0.1
 */