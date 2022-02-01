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
    if (QDLog.isInfoEnable()) {
      QDLog.i("DnsMain", "hostName:" + paramString + ",timeout:" + paramLong + "get better host for name:" + paramString);
    }
    if ((paramString == null) || (paramString.trim().length() <= 0)) {}
    do
    {
      return null;
      paramString = paramString.trim();
      if (0 == 0) {
        break;
      }
    } while (!QDLog.isInfoEnable());
    QDLog.i("DnsMain", "get ip from cache: " + paramString + " --- " + null);
    return null;
    try
    {
      InetAddress[] arrayOfInetAddress = new Lookup("114.114.114.114").run(paramString, paramLong);
      if ((arrayOfInetAddress != null) && (arrayOfInetAddress.length > 0))
      {
        if (QDLog.isInfoEnable()) {
          QDLog.i("DnsMain", "get ip from Lookup: " + paramString + " --- " + arrayOfInetAddress);
        }
      }
      else
      {
        QDLog.e("DnsMain", "114 - Address == null ? WTF ?!");
        return null;
      }
    }
    catch (UnknownHostException localUnknownHostException)
    {
      QDLog.e("DnsMain", "UnknownHostException cause[" + paramString + "][114.114.114.114]." + localUnknownHostException.getMessage());
      return null;
    }
    catch (WireParseException localWireParseException)
    {
      QDLog.e("DnsMain", "WireParseException cause[" + paramString + "][114.114.114.114]." + localWireParseException.getMessage());
      return null;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      QDLog.e("DnsMain", "SocketTimeoutException cause[" + paramString + "][114.114.114.114]." + localSocketTimeoutException.getMessage());
      return null;
    }
    catch (IOException localIOException)
    {
      QDLog.e("DnsMain", "IOException cause[" + paramString + "][114.114.114.114]." + localIOException.getMessage());
      return null;
    }
    catch (Exception localException)
    {
      QDLog.e("DnsMain", "Exception cause[" + paramString + "][114.114.114.114]." + localException.getMessage());
      return null;
    }
    return localException;
  }
  
  public static String getHostName(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString.trim();
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
    } while (str.indexOf("/", 1) <= 1);
    return str.substring(0, str.indexOf("/", 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.DnsMain
 * JD-Core Version:    0.7.0.1
 */