package com.tencent.component.network.module.common.dns;

import com.tencent.component.network.module.base.QDLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class DnsMain
{
  private static final String TAG = "DnsMain";
  
  public static InetAddress[] getBetterHostByName(String paramString, long paramLong)
  {
    paramString = getHostName(paramString);
    Object localObject;
    if (QDLog.isInfoEnable())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hostName:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",timeout:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("get better host for name:");
      ((StringBuilder)localObject).append(paramString);
      QDLog.i("DnsMain", ((StringBuilder)localObject).toString());
    }
    if (paramString != null)
    {
      if (paramString.trim().length() <= 0) {
        return null;
      }
      paramString = paramString.trim();
      try
      {
        localObject = new Lookup("114.114.114.114").run(paramString, paramLong);
        if ((localObject != null) && (localObject.length > 0))
        {
          if (!QDLog.isInfoEnable()) {
            return localObject;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("get ip from Lookup: ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" --- ");
          localStringBuilder.append(localObject);
          QDLog.i("DnsMain", localStringBuilder.toString());
          return localObject;
        }
        QDLog.e("DnsMain", "114 - Address == null ? WTF ?!");
        return null;
      }
      catch (Exception localException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exception cause[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("][114.114.114.114].");
        localStringBuilder.append(localException.getMessage());
        QDLog.e("DnsMain", localStringBuilder.toString());
        return null;
      }
      catch (IOException localIOException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("IOException cause[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("][114.114.114.114].");
        localStringBuilder.append(localIOException.getMessage());
        QDLog.e("DnsMain", localStringBuilder.toString());
        return null;
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("SocketTimeoutException cause[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("][114.114.114.114].");
        localStringBuilder.append(localSocketTimeoutException.getMessage());
        QDLog.e("DnsMain", localStringBuilder.toString());
        return null;
      }
      catch (WireParseException localWireParseException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("WireParseException cause[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("][114.114.114.114].");
        localStringBuilder.append(localWireParseException.getMessage());
        QDLog.e("DnsMain", localStringBuilder.toString());
        return null;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("UnknownHostException cause[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("][114.114.114.114].");
        localStringBuilder.append(localUnknownHostException.getMessage());
        QDLog.e("DnsMain", localStringBuilder.toString());
      }
    }
    else
    {
      return null;
    }
    return localUnknownHostException;
  }
  
  public static String getHostName(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String str = paramString.trim();
    paramString = str.toLowerCase();
    int i;
    if (paramString.startsWith("http://"))
    {
      i = str.indexOf("/", 8);
      if (i > 7) {
        return str.substring(7, i);
      }
      return str.substring(7);
    }
    if (paramString.startsWith("https://"))
    {
      i = str.indexOf("/", 9);
      if (i > 8) {
        return str.substring(8, i);
      }
      return str.substring(8);
    }
    paramString = str;
    if (str.indexOf("/", 1) > 1) {
      paramString = str.substring(0, str.indexOf("/", 1));
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.DnsMain
 * JD-Core Version:    0.7.0.1
 */