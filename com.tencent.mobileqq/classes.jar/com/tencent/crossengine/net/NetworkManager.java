package com.tencent.crossengine.net;

import android.util.Pair;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import java.util.List;

@Keep
abstract class NetworkManager
{
  private static NetworkManager mManager;
  
  private static String[] convertHeader(List<Pair<String, String>> paramList)
  {
    String[] arrayOfString = new String[paramList.size() * 2];
    int i = 0;
    while (i < paramList.size())
    {
      int j = i * 2;
      arrayOfString[j] = ((String)((Pair)paramList.get(i)).first);
      arrayOfString[(j + 1)] = ((String)((Pair)paramList.get(i)).second);
      i += 1;
    }
    return arrayOfString;
  }
  
  @Keep
  @NonNull
  private static NetworkManager getManager()
  {
    try
    {
      if (mManager == null) {
        mManager = new OkHttpNetworkManager();
      }
      NetworkManager localNetworkManager = mManager;
      return localNetworkManager;
    }
    finally {}
  }
  
  public static void setManager(@NonNull NetworkManager paramNetworkManager)
  {
    try
    {
      mManager = paramNetworkManager;
      return;
    }
    finally
    {
      paramNetworkManager = finally;
      throw paramNetworkManager;
    }
  }
  
  public abstract NetworkManager.HttpRequest performHttpRequest(@NonNull NetworkManager.HttpRequestData paramHttpRequestData);
  
  public abstract NetworkManager.WebSocket performWebSocketRequest(@NonNull NetworkManager.WebSocketRequestData paramWebSocketRequestData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.net.NetworkManager
 * JD-Core Version:    0.7.0.1
 */