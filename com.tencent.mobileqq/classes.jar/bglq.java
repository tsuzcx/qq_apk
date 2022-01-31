import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.WnsConfigProxy;

public class bglq
{
  public static int a(String paramString1, String paramString2, int paramInt)
  {
    WnsConfigProxy localWnsConfigProxy = (WnsConfigProxy)ProxyManager.get(WnsConfigProxy.class);
    if (localWnsConfigProxy == null) {}
    do
    {
      return paramInt;
      paramString1 = localWnsConfigProxy.getConfig(paramString1, paramString2);
    } while (paramString1 == null);
    try
    {
      int i = Integer.valueOf(paramString1).intValue();
      return i;
    }
    catch (Exception paramString1) {}
    return paramInt;
  }
  
  public static long a(String paramString1, String paramString2, long paramLong)
  {
    WnsConfigProxy localWnsConfigProxy = (WnsConfigProxy)ProxyManager.get(WnsConfigProxy.class);
    if (localWnsConfigProxy == null) {}
    do
    {
      return paramLong;
      paramString1 = localWnsConfigProxy.getConfig(paramString1, paramString2);
    } while (paramString1 == null);
    try
    {
      long l = Long.valueOf(paramString1).longValue();
      return l;
    }
    catch (Exception paramString1) {}
    return paramLong;
  }
  
  public static final String a(String paramString1, String paramString2)
  {
    WnsConfigProxy localWnsConfigProxy = (WnsConfigProxy)ProxyManager.get(WnsConfigProxy.class);
    if (localWnsConfigProxy == null) {
      return null;
    }
    return localWnsConfigProxy.getConfig(paramString1, paramString2);
  }
  
  public static final String a(String paramString1, String paramString2, String paramString3)
  {
    WnsConfigProxy localWnsConfigProxy = (WnsConfigProxy)ProxyManager.get(WnsConfigProxy.class);
    if (localWnsConfigProxy == null) {}
    do
    {
      return paramString3;
      paramString1 = localWnsConfigProxy.getConfig(paramString1, paramString2);
    } while (TextUtils.isEmpty(paramString1));
    return paramString1;
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    WnsConfigProxy localWnsConfigProxy = (WnsConfigProxy)ProxyManager.get(WnsConfigProxy.class);
    if (localWnsConfigProxy == null) {}
    do
    {
      return paramBoolean;
      paramString1 = localWnsConfigProxy.getConfig(paramString1, paramString2);
    } while (paramString1 == null);
    try
    {
      boolean bool = Boolean.parseBoolean(paramString1);
      return bool;
    }
    catch (Exception paramString1) {}
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bglq
 * JD-Core Version:    0.7.0.1
 */