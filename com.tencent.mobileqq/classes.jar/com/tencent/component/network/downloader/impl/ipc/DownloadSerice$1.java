package com.tencent.component.network.downloader.impl.ipc;

import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;

class DownloadSerice$1
  implements Downloader.DownloadListener
{
  DownloadSerice$1(DownloadSerice paramDownloadSerice, Messenger paramMessenger) {}
  
  public void onDownloadCanceled(String paramString)
  {
    paramString = Const.obtainDownloadCanceledMsg(paramString);
    try
    {
      this.val$messenger.send(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onDownloadFailed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = Const.obtainDownloadFailedMsg(paramString, paramDownloadResult);
    try
    {
      this.val$messenger.send(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    paramString = Const.obtainDownloadProgressMsg(paramString, paramLong, paramFloat);
    try
    {
      this.val$messenger.send(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = Const.obtainDownloadSucceedMsg(paramString, paramDownloadResult);
    try
    {
      this.val$messenger.send(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.DownloadSerice.1
 * JD-Core Version:    0.7.0.1
 */