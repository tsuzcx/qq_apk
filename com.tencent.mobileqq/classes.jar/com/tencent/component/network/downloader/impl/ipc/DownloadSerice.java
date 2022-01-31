package com.tencent.component.network.downloader.impl.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import pjx;
import pjy;

public class DownloadSerice
  extends Service
{
  private final Messenger a = new Messenger(new pjy(this));
  
  private void a(Const.SimpleRequest paramSimpleRequest, Messenger paramMessenger)
  {
    if ((paramSimpleRequest == null) || (paramMessenger == null)) {
      return;
    }
    Log.i("DownloadSerice", "download request from DownloadClient:" + paramSimpleRequest.toString());
    int i = paramSimpleRequest.jdField_a_of_type_Int;
    Downloader localDownloader = DownloaderFactory.getInstance(this).getImageDownloader();
    if (i == 2) {
      localDownloader = DownloaderFactory.getInstance(this).getCommonDownloader();
    }
    localDownloader.download(paramSimpleRequest.jdField_a_of_type_JavaLangString, paramSimpleRequest.a(), true, new pjx(this, paramMessenger));
  }
  
  private void b(Const.SimpleRequest paramSimpleRequest, Messenger paramMessenger)
  {
    if ((paramSimpleRequest == null) || (paramMessenger == null)) {
      return;
    }
    Log.i("DownloadSerice", "cancel request from DownloadClient:" + paramSimpleRequest.toString());
    paramSimpleRequest = Const.a(paramSimpleRequest.jdField_a_of_type_JavaLangString);
    try
    {
      paramMessenger.send(paramSimpleRequest);
      return;
    }
    catch (RemoteException paramSimpleRequest)
    {
      paramSimpleRequest.printStackTrace();
    }
  }
  
  private void c(Const.SimpleRequest paramSimpleRequest, Messenger paramMessenger)
  {
    if ((paramSimpleRequest == null) || (paramMessenger == null)) {
      return;
    }
    Log.i("DownloadSerice", "clean cache." + paramSimpleRequest.toString());
    int i = paramSimpleRequest.jdField_a_of_type_Int;
    paramMessenger = DownloaderFactory.getInstance(this).getImageDownloader();
    if (i == 2) {
      paramMessenger = DownloaderFactory.getInstance(this).getCommonDownloader();
    }
    if ("".equals(paramSimpleRequest.jdField_a_of_type_JavaLangString))
    {
      paramMessenger.cleanCache();
      return;
    }
    paramMessenger.cleanCache(paramSimpleRequest.jdField_a_of_type_JavaLangString);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    Log.w("DownloadSerice", "Download Service Binded");
    return this.a.getBinder();
  }
  
  public void onCreate()
  {
    Log.e("DownloadSerice", "start onCreate~~~");
    super.onCreate();
  }
  
  public void onDestroy()
  {
    Log.e("DownloadSerice", "start onDestroy~~~");
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    Log.e("DownloadSerice", "start onStart~~~");
    super.onStart(paramIntent, paramInt);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    Log.e("DownloadSerice", "start onUnbind~~~");
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.DownloadSerice
 * JD-Core Version:    0.7.0.1
 */