package com.tencent.component.network.downloader.impl.ipc;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadMode;

public class Const
{
  public static Message a(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 105;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localMessage.setData(localBundle);
    return localMessage;
  }
  
  public static Message a(String paramString, int paramInt, Messenger paramMessenger)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 102;
    localMessage.replyTo = paramMessenger;
    paramMessenger = new Const.SimpleRequest();
    paramMessenger.jdField_a_of_type_JavaLangString = paramString;
    paramMessenger.jdField_a_of_type_Int = paramInt;
    paramString = new Bundle();
    paramString.putParcelable("request", paramMessenger);
    localMessage.setData(paramString);
    return localMessage;
  }
  
  public static Message a(String paramString, long paramLong, float paramFloat)
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
  
  public static Message a(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = Message.obtain();
    paramString.what = 103;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("result", paramDownloadResult);
    paramString.setData(localBundle);
    return paramString;
  }
  
  public static Message a(String paramString, String[] paramArrayOfString, int paramInt, Downloader.DownloadMode paramDownloadMode, Messenger paramMessenger)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.replyTo = paramMessenger;
    paramMessenger = new Const.SimpleRequest();
    paramMessenger.jdField_a_of_type_JavaLangString = paramString;
    paramMessenger.jdField_a_of_type_Int = paramInt;
    paramMessenger.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadMode = paramDownloadMode;
    if (paramArrayOfString != null)
    {
      int i = paramArrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramMessenger.a(paramArrayOfString[paramInt]);
        paramInt += 1;
      }
    }
    paramString = new Bundle();
    paramString.putParcelable("request", paramMessenger);
    localMessage.setData(paramString);
    return localMessage;
  }
  
  public static Message b(String paramString, int paramInt, Messenger paramMessenger)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 107;
    localMessage.replyTo = paramMessenger;
    paramMessenger = new Const.SimpleRequest();
    paramMessenger.jdField_a_of_type_JavaLangString = paramString;
    paramMessenger.jdField_a_of_type_Int = paramInt;
    paramString = new Bundle();
    paramString.putParcelable("request", paramMessenger);
    localMessage.setData(paramString);
    return localMessage;
  }
  
  public static Message b(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = Message.obtain();
    paramString.what = 104;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("result", paramDownloadResult);
    paramString.setData(localBundle);
    return paramString;
  }
  
  private static boolean b(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.Const
 * JD-Core Version:    0.7.0.1
 */