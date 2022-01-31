package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.Global;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.http.HttpUtil.ClientOptions;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.HttpClient;
import pih;

public class StrategyProvider
{
  public static IPConfigStrategy a;
  public static PortConfigStrategy a;
  private static HttpUtil.ClientOptions jdField_a_of_type_ComTencentComponentNetworkUtilsHttpHttpUtil$ClientOptions = new HttpUtil.ClientOptions(true);
  private static final ThreadLocal jdField_a_of_type_JavaLangThreadLocal = new pih();
  private static HttpClient jdField_a_of_type_OrgApacheHttpClientHttpClient = null;
  public static IPConfigStrategy b;
  
  public static List a(String paramString)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return localObject;
      str = Utils.getDomin(paramString);
    } while (TextUtils.isEmpty(str));
    paramString = new ArrayList();
    label116:
    for (;;)
    {
      try
      {
        if (DownloaderFactory.getInstance(Global.a()).getDirectIpStrategy() == null) {
          break label116;
        }
        localObject = DownloaderFactory.getInstance(Global.a()).getDirectIpStrategy().a(str);
        if (localObject == null) {
          break label116;
        }
        int i = ((List)localObject).size();
        if (i <= 0) {
          break label116;
        }
        paramString = (String)localObject;
        return paramString;
      }
      catch (Exception localException)
      {
        localObject = paramString;
      }
      if (!QDLog.b()) {
        break;
      }
      QDLog.b("StrategyProvider", "provide video ip list error = " + localException.toString());
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.StrategyProvider
 * JD-Core Version:    0.7.0.1
 */