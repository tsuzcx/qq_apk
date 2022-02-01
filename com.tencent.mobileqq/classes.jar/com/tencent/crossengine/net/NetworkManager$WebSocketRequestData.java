package com.tencent.crossengine.net;

import android.util.Pair;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

@Keep
public class NetworkManager$WebSocketRequestData
{
  public NetworkManager.WebSocketDelegate delegate;
  public final List<Pair<String, String>> header = new ArrayList();
  public final List<String> protocols = new ArrayList();
  public long timeout;
  public String url;
  public String userAgent;
  
  private void addProtocol(String paramString)
  {
    this.protocols.add(paramString);
  }
  
  private void setDelegate(long paramLong)
  {
    this.delegate = new NetworkManager.WebSocketDelegate(paramLong, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.net.NetworkManager.WebSocketRequestData
 * JD-Core Version:    0.7.0.1
 */