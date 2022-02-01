package com.tencent.component.network.downloader.impl.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;

public class DownloadSerice
  extends Service
{
  private static final String TAG = "DownloadSerice";
  private final Messenger mMessenger = new Messenger(new DownloadSerice.ClientHandler(this));
  
  private void cancel(Const.SimpleRequest paramSimpleRequest, Messenger paramMessenger)
  {
    if ((paramSimpleRequest == null) || (paramMessenger == null)) {
      return;
    }
    Log.i("DownloadSerice", "cancel request from DownloadClient:" + paramSimpleRequest.toString());
    paramSimpleRequest = Const.obtainDownloadCanceledMsg(paramSimpleRequest.url);
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
  
  private void cleanCache(Const.SimpleRequest paramSimpleRequest, Messenger paramMessenger)
  {
    if ((paramSimpleRequest == null) || (paramMessenger == null)) {
      return;
    }
    Log.i("DownloadSerice", "clean cache." + paramSimpleRequest.toString());
    int i = paramSimpleRequest.content_type;
    paramMessenger = DownloaderFactory.getInstance(this).getImageDownloader();
    if (i == 2) {
      paramMessenger = DownloaderFactory.getInstance(this).getCommonDownloader();
    }
    if ("".equals(paramSimpleRequest.url))
    {
      paramMessenger.cleanCache();
      return;
    }
    paramMessenger.cleanCache(paramSimpleRequest.url);
  }
  
  private void download(Const.SimpleRequest paramSimpleRequest, Messenger paramMessenger)
  {
    if ((paramSimpleRequest == null) || (paramMessenger == null)) {
      return;
    }
    Log.i("DownloadSerice", "download request from DownloadClient:" + paramSimpleRequest.toString());
    int i = paramSimpleRequest.content_type;
    Downloader localDownloader = DownloaderFactory.getInstance(this).getImageDownloader();
    if (i == 2) {
      localDownloader = DownloaderFactory.getInstance(this).getCommonDownloader();
    }
    localDownloader.download(paramSimpleRequest.url, paramSimpleRequest.getPaths(), true, new DownloadSerice.1(this, paramMessenger));
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    Log.w("DownloadSerice", "Download Service Binded");
    return this.mMessenger.getBinder();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.DownloadSerice
 * JD-Core Version:    0.7.0.1
 */