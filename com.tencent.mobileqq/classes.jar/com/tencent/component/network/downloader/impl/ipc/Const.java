package com.tencent.component.network.downloader.impl.ipc;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadMode;

public class Const
{
  public static final String BUNDLE_KEY_REQUEST = "request";
  public static final String BUNDLE_KEY_RESULT = "result";
  public static final String BUNDLE_KEY_URL = "url";
  public static final int MSG_WHAT_BASE = 100;
  public static final int MSG_WHAT_CLEAN_CACHE = 107;
  public static final int MSG_WHAT_DOWNLOAD_REQUEST = 101;
  public static final int MSG_WHAT_DOWNLOAD_REQUEST_ABORT = 103;
  public static final int MSG_WHAT_DOWNLOAD_REQUEST_CANCEL = 102;
  public static final int MSG_WHAT_DOWNLOAD_RESPONSE_CANCELED = 105;
  public static final int MSG_WHAT_DOWNLOAD_RESPONSE_FAILED = 104;
  public static final int MSG_WHAT_DOWNLOAD_RESPONSE_PROGRESS = 106;
  public static final int MSG_WHAT_DOWNLOAD_RESPONSE_SUCCEED = 103;
  
  private static boolean equalsObject(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static Message obtainCleanCacheMsg(String paramString, int paramInt, Messenger paramMessenger)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 107;
    localMessage.replyTo = paramMessenger;
    paramMessenger = new Const.SimpleRequest();
    paramMessenger.url = paramString;
    paramMessenger.content_type = paramInt;
    paramString = new Bundle();
    paramString.putParcelable("request", paramMessenger);
    localMessage.setData(paramString);
    return localMessage;
  }
  
  public static Message obtainDownloadAbortMsg(String paramString, int paramInt, Messenger paramMessenger)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 103;
    localMessage.replyTo = paramMessenger;
    paramMessenger = new Const.SimpleRequest();
    paramMessenger.url = paramString;
    paramMessenger.content_type = paramInt;
    paramString = new Bundle();
    paramString.putParcelable("request", paramMessenger);
    localMessage.setData(paramString);
    return localMessage;
  }
  
  public static Message obtainDownloadCancelMsg(String paramString, int paramInt, Messenger paramMessenger)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 102;
    localMessage.replyTo = paramMessenger;
    paramMessenger = new Const.SimpleRequest();
    paramMessenger.url = paramString;
    paramMessenger.content_type = paramInt;
    paramString = new Bundle();
    paramString.putParcelable("request", paramMessenger);
    localMessage.setData(paramString);
    return localMessage;
  }
  
  public static Message obtainDownloadCanceledMsg(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 105;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localMessage.setData(localBundle);
    return localMessage;
  }
  
  public static Message obtainDownloadFailedMsg(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = Message.obtain();
    paramString.what = 104;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("result", paramDownloadResult);
    paramString.setData(localBundle);
    return paramString;
  }
  
  public static Message obtainDownloadProgressMsg(String paramString, long paramLong, float paramFloat)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 106;
    localMessage.arg1 = ((int)paramLong);
    localMessage.arg2 = ((int)paramFloat);
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localMessage.setData(localBundle);
    return localMessage;
  }
  
  public static Message obtainDownloadRequestMsg(String paramString, String[] paramArrayOfString, int paramInt, Downloader.DownloadMode paramDownloadMode, Messenger paramMessenger)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.replyTo = paramMessenger;
    paramMessenger = new Const.SimpleRequest();
    paramMessenger.url = paramString;
    paramMessenger.content_type = paramInt;
    paramMessenger.mode = paramDownloadMode;
    if (paramArrayOfString != null)
    {
      int i = paramArrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramMessenger.addDstPath(paramArrayOfString[paramInt]);
        paramInt += 1;
      }
    }
    paramString = new Bundle();
    paramString.putParcelable("request", paramMessenger);
    localMessage.setData(paramString);
    return localMessage;
  }
  
  public static Message obtainDownloadSucceedMsg(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = Message.obtain();
    paramString.what = 103;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("result", paramDownloadResult);
    paramString.setData(localBundle);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.Const
 * JD-Core Version:    0.7.0.1
 */