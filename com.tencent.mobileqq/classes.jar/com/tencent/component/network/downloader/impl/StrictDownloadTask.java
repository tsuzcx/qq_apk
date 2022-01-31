package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyLib;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.DnsService;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.http.base.QZoneHttp2Client;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

public class StrictDownloadTask
  extends DownloadTask
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static List jdField_a_of_type_JavaUtilList;
  Response jdField_a_of_type_ComSquareupOkhttpResponse = null;
  private String jdField_a_of_type_JavaLangString;
  HttpResponse jdField_a_of_type_OrgApacheHttpHttpResponse = null;
  private int[] jdField_a_of_type_ArrayOfInt = new int[this.h];
  private String b;
  long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int = 0;
  long jdField_e_of_type_Long = 0L;
  private boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int = 0;
  long jdField_f_of_type_Long = 0L;
  private int jdField_g_of_type_Int = 0;
  private final long jdField_g_of_type_Long = SystemClock.uptimeMillis();
  private int h = 4;
  
  public StrictDownloadTask(Context paramContext, QZoneHttp2Client paramQZoneHttp2Client, QZoneHttpClient paramQZoneHttpClient, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramQZoneHttp2Client, paramQZoneHttpClient, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  private String a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return "{" + "1.1" + "," + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramString1 + "," + paramString2 + "," + paramString3 + "," + paramString4 + "," + NetworkManager.getIspType() + "," + NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext) + "}";
  }
  
  private void a(HttpRequest paramHttpRequest, Request.Builder paramBuilder, HttpResponse paramHttpResponse, Response paramResponse)
  {
    int k = 0;
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\n/****************************************************/\n");
    localStringBuffer.append("<---------Request Content--------->\n");
    int i;
    if (paramHttpRequest != null)
    {
      localStringBuffer.append(paramHttpRequest.getRequestLine()).append("\n");
      paramHttpRequest = paramHttpRequest.getAllHeaders();
      if (paramHttpRequest != null)
      {
        i = 0;
        while (i < paramHttpRequest.length)
        {
          localStringBuffer.append(paramHttpRequest[i].getName()).append(": ").append(paramHttpRequest[i].getValue()).append("\n");
          i += 1;
        }
      }
    }
    else if (paramBuilder != null)
    {
      localStringBuffer.append(paramBuilder.build().urlString()).append("\n");
      paramHttpRequest = paramBuilder.build().headers();
      if (paramHttpRequest != null)
      {
        i = 0;
        while (i < paramHttpRequest.size())
        {
          localStringBuffer.append(paramHttpRequest.name(i)).append(": ").append(paramHttpRequest.value(i)).append("\n");
          i += 1;
        }
      }
    }
    localStringBuffer.append("<---------Response Headers--------->\n");
    if (paramHttpResponse != null)
    {
      localStringBuffer.append(paramHttpResponse.getStatusLine()).append("\n");
      paramHttpRequest = paramHttpResponse.getAllHeaders();
      if (paramHttpRequest != null)
      {
        i = j;
        while (i < paramHttpRequest.length)
        {
          localStringBuffer.append(paramHttpRequest[i].getName()).append(": ").append(paramHttpRequest[i].getValue()).append("\n");
          i += 1;
        }
      }
    }
    else if (paramResponse != null)
    {
      localStringBuffer.append(paramResponse.code()).append("\n");
      paramHttpRequest = paramResponse.headers();
      if (paramHttpRequest != null)
      {
        i = k;
        while (i < paramHttpRequest.size())
        {
          localStringBuffer.append(paramHttpRequest.name(i)).append(": ").append(paramHttpRequest.value(i)).append("\n");
          i += 1;
        }
      }
    }
    localStringBuffer.append("/****************************************************/");
    QDLog.c("downloader", "Http Details:" + localStringBuffer.toString());
  }
  
  private boolean a(int paramInt)
  {
    int j = 80;
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib == null)
    {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib = DownloadGlobalStrategy.a(this.jdField_a_of_type_AndroidContentContext).a(a(), b(), this.jdField_b_of_type_Boolean);
      g();
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a();
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(false);
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(jdField_a_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo;
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a() != null) {}
    for (int i = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a().size();; i = 0)
    {
      if (i == 0) {}
      String str;
      label759:
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              for (this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(this.jdField_d_of_type_Int % i); (this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo != null) && (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo != null) && (this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int); this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(this.jdField_d_of_type_Int % i)) {
                this.jdField_d_of_type_Int += 1;
              }
              this.jdField_d_of_type_Int += 1;
              if ((this.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_Int > i))
              {
                this.jdField_b_of_type_Boolean = false;
                this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(80);
                this.jdField_b_of_type_Int = 0;
              }
              i = j;
              if (this.jdField_b_of_type_Boolean) {
                i = 443;
              }
              this.jdField_c_of_type_Int = i;
              this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(this.jdField_c_of_type_Int);
              if (QDLog.b()) {
                QDLog.b("downloader_strategy", "downloader strategy: " + this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.toString() + " currAttempCount:" + paramInt + " attemptStrategyCount:" + this.jdField_d_of_type_Int + " best:" + this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.b() + " url:" + a() + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
              }
              this.jdField_d_of_type_Boolean = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Boolean;
              this.jdField_e_of_type_Boolean = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_b_of_type_Boolean;
              str = b();
              i = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a();
              paramInt = i;
              if (!Utils.isPortValid(i))
              {
                this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(this.jdField_c_of_type_Int);
                paramInt = this.jdField_c_of_type_Int;
              }
              if (DownloadGlobalStrategy.d.jdField_a_of_type_Int != this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int) {
                break label891;
              }
              i = paramInt;
              if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo == null) {
                break;
              }
              i = paramInt;
              if (DownloadGlobalStrategy.d.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int) {
                break;
              }
              i = paramInt;
              if (this.jdField_b_of_type_Boolean) {
                break;
              }
              if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy == null) || (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str))) {
                break label759;
              }
              i = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str, paramInt);
              if ((i != paramInt) && (Utils.isPortValid(i))) {
                break;
              }
            } while (!QDLog.b());
            QDLog.b("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
            return false;
            localObject2 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c();
            localObject1 = localObject2;
            if (this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy != null)
            {
              localObject1 = localObject2;
              if (!this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str, (String)localObject2))
              {
                this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c(null);
                localObject1 = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str);
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break label816;
                }
                this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c((String)localObject1);
              }
            }
            if ((localObject1 != null) && (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a())) && (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.b()))) {
              break label854;
            }
          } while (!QDLog.b());
          QDLog.b("downloader", "downloader strategy: Pass! Backup IP 重复. threadId:" + Thread.currentThread().getId());
          return false;
        } while (!QDLog.b());
        QDLog.b("downloader", "downloader strategy: Pass! Not support !" + this.jdField_c_of_type_Int + "." + " threadId:" + Thread.currentThread().getId());
        return false;
      } while (!QDLog.b());
      label816:
      QDLog.b("downloader", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
      return false;
      label854:
      this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
      this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject1, i));
      for (;;)
      {
        b(NetworkManager.getIspType());
        return true;
        label891:
        if (DownloadGlobalStrategy.e.jdField_a_of_type_Int == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
        {
          i = paramInt;
          if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.e.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
            {
              i = paramInt;
              if (!this.jdField_b_of_type_Boolean)
              {
                if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy == null) || (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str))) {
                  break label1134;
                }
                i = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str, paramInt);
                if ((i == paramInt) || (!Utils.isPortValid(i)))
                {
                  if (!QDLog.b()) {
                    break;
                  }
                  QDLog.b("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                  return false;
                }
              }
            }
          }
          localObject1 = DnsService.a().a(str);
          if ((localObject1 == null) || (((String)localObject1).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c())) || (((String)localObject1).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a())))
          {
            this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.b(null);
            if (!QDLog.b()) {
              break;
            }
            QDLog.b("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            return false;
            if (!QDLog.b()) {
              break;
            }
            QDLog.b("downloader", "downloader strategy: Pass! Not support !" + this.jdField_c_of_type_Int + "." + " threadId:" + Thread.currentThread().getId());
            return false;
          }
          this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.b((String)localObject1);
          this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
          this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject1, i));
          continue;
        }
        label1134:
        if (6 == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
        {
          if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy != null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str);
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = DnsService.a().a(str);
            }
          }
          if (localObject1 == null)
          {
            if (!QDLog.b()) {
              break;
            }
            QDLog.b("downloader", "downloader strategy: direct ip is null. Pass! 6 threadId:" + Thread.currentThread().getId());
            return false;
          }
          this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
          this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject1, this.jdField_c_of_type_Int));
          continue;
        }
        if (7 == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
        {
          localObject1 = localObject2;
          if (this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy != null)
          {
            localObject2 = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str);
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = DnsService.a().a(str);
            }
          }
          if (localObject1 == null)
          {
            if (!QDLog.b()) {
              break;
            }
            QDLog.b("downloader", "downloader strategy: backup ip is null. Pass! 7 threadId:" + Thread.currentThread().getId());
            return false;
          }
          this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
          this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject1, this.jdField_c_of_type_Int));
          continue;
        }
        if (8 == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
        {
          localObject1 = null;
          label1512:
          paramInt = e();
          if (paramInt == 0) {}
          for (;;)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = DnsService.a().a(str);
            }
            if (localObject2 != null) {
              break label1627;
            }
            if (!QDLog.b()) {
              break;
            }
            QDLog.b("downloader", "downloader strategy:  ip is null. Pass! 8 threadId:" + Thread.currentThread().getId());
            return false;
            localObject2 = localObject1;
            if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy != null) {
              localObject2 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str, paramInt);
            }
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label1512;
            }
            localObject1 = localObject2;
          }
          label1627:
          this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
          this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject2, this.jdField_c_of_type_Int));
        }
        else if (9 == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
        {
          localObject1 = null;
          label1676:
          paramInt = e();
          if (paramInt == 0) {}
          for (;;)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = DnsService.a().a(str);
            }
            if (localObject2 != null) {
              break label1791;
            }
            if (!QDLog.b()) {
              break;
            }
            QDLog.b("downloader", "downloader strategy:  ip is null. Pass! 9 threadId:" + Thread.currentThread().getId());
            return false;
            localObject2 = localObject1;
            if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy != null) {
              localObject2 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str, paramInt);
            }
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label1676;
            }
            localObject1 = localObject2;
          }
          label1791:
          this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
          this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject2, this.jdField_c_of_type_Int));
        }
        else
        {
          if (DownloadGlobalStrategy.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
          {
            i = paramInt;
            if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo != null)
            {
              i = paramInt;
              if (DownloadGlobalStrategy.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
              {
                i = paramInt;
                if (!this.jdField_b_of_type_Boolean)
                {
                  if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy == null) || (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str))) {
                    break label2128;
                  }
                  i = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str, paramInt);
                  if ((i == paramInt) || (!Utils.isPortValid(i)))
                  {
                    if (!QDLog.b()) {
                      break;
                    }
                    QDLog.b("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                    return false;
                  }
                }
              }
            }
          }
          label2128:
          do
          {
            localObject2 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a();
            localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy != null)
            {
              localObject1 = localObject2;
              if (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a((String)localObject2, str))
              {
                this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(null);
                localObject1 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str);
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break label2305;
                }
                this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a((String)localObject1);
              }
            }
            if ((localObject1 != null) && (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c())) && (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.b()))) {
              break label2343;
            }
            if (!QDLog.b()) {
              break;
            }
            QDLog.b("downloader", "downloader strategy: Pass! Direct IP 重复. threadId:" + Thread.currentThread().getId());
            return false;
            if (!QDLog.b()) {
              break;
            }
            QDLog.b("downloader", "downloader strategy: Pass! Not support !" + this.jdField_c_of_type_Int + "." + " threadId:" + Thread.currentThread().getId());
            return false;
            if (DownloadGlobalStrategy.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int) {
              break label2219;
            }
            i = paramInt;
          } while (DownloadGlobalStrategy.c.jdField_a_of_type_Int != this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int);
          label2219:
          localObject1 = this.jdField_a_of_type_AndroidContentContext;
          if (DownloadGlobalStrategy.c.jdField_a_of_type_Int == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int) {}
          for (boolean bool = true;; bool = false)
          {
            if (NetworkUtils.getProxy((Context)localObject1, bool) != null) {
              break label2298;
            }
            if (!QDLog.b()) {
              break;
            }
            QDLog.b("downloader", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
            return false;
          }
          label2298:
          paramInt = this.jdField_c_of_type_Int;
          return true;
          label2305:
          if (!QDLog.b()) {
            break;
          }
          QDLog.b("downloader", "downloader strategy: direct ip is null. Pass! threadId:" + Thread.currentThread().getId());
          return false;
          label2343:
          this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
          this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject1, i));
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.h)) {
      return;
    }
    this.jdField_a_of_type_ArrayOfInt[(paramInt - 1)] = 1;
  }
  
  private int e()
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.h)
      {
        if (this.jdField_a_of_type_ArrayOfInt[i] == 0)
        {
          this.jdField_a_of_type_ArrayOfInt[i] = 1;
          j = i + 1;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private void g()
  {
    if (jdField_a_of_type_JavaUtilList == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_JavaUtilList == null)
        {
          jdField_a_of_type_JavaUtilList = new ArrayList();
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo1 = new DownloadGlobalStrategy.StrategyInfo(6, false, false, false, true);
          localStrategyInfo1.jdField_a_of_type_Int = 6;
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo2 = new DownloadGlobalStrategy.StrategyInfo(7, false, false, false, true);
          localStrategyInfo2.jdField_a_of_type_Int = 7;
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo3 = new DownloadGlobalStrategy.StrategyInfo(8, false, false, false, true);
          localStrategyInfo3.jdField_a_of_type_Int = 8;
          DownloadGlobalStrategy.StrategyInfo localStrategyInfo4 = new DownloadGlobalStrategy.StrategyInfo(9, false, false, false, true);
          localStrategyInfo4.jdField_a_of_type_Int = 9;
          jdField_a_of_type_JavaUtilList.add(localStrategyInfo1);
          jdField_a_of_type_JavaUtilList.add(localStrategyInfo2);
          jdField_a_of_type_JavaUtilList.add(localStrategyInfo3);
          jdField_a_of_type_JavaUtilList.add(localStrategyInfo4);
        }
        return;
      }
    }
  }
  
  protected void a()
  {
    super.a();
    this.jdField_b_of_type_JavaLangString = Utils.getDominWithPort(a());
    this.jdField_g_of_type_Int = Utils.getPort(a());
  }
  
  /* Error */
  public void a(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc_w 449
    //   6: astore 21
    //   8: iconst_2
    //   9: anewarray 24	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: aload_0
    //   15: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: aload_2
    //   22: aastore
    //   23: invokestatic 454	poh:a	([Ljava/lang/Object;)I
    //   26: istore 7
    //   28: lconst_0
    //   29: lstore 8
    //   31: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   34: lstore 14
    //   36: aload_1
    //   37: invokeinterface 459 1 0
    //   42: ifeq +11 -> 53
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: aconst_null
    //   49: invokevirtual 462	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   52: return
    //   53: aload_0
    //   54: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   57: invokestatic 93	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   60: ifne +30 -> 90
    //   63: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   66: lload 14
    //   68: lsub
    //   69: ldc2_w 463
    //   72: lcmp
    //   73: ifgt +17 -> 90
    //   76: ldc2_w 465
    //   79: invokestatic 470	java/lang/Thread:sleep	(J)V
    //   82: goto -29 -> 53
    //   85: astore 22
    //   87: goto -34 -> 53
    //   90: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   93: lload 14
    //   95: lsub
    //   96: ldc2_w 463
    //   99: lcmp
    //   100: ifle +77 -> 177
    //   103: aload 21
    //   105: astore_1
    //   106: iload 4
    //   108: istore_3
    //   109: aload_0
    //   110: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   113: invokestatic 93	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   116: ifne +12 -> 128
    //   119: aload_2
    //   120: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   123: bipush 6
    //   125: invokevirtual 481	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   128: aload_2
    //   129: aload_0
    //   130: aload_2
    //   131: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   134: invokevirtual 484	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   137: aload_2
    //   138: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   141: getfield 487	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   144: iload_3
    //   145: invokestatic 278	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   148: ldc_w 449
    //   151: aload_2
    //   152: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   155: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   158: aload_1
    //   159: invokespecial 498	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   162: invokevirtual 501	com/tencent/component/network/downloader/DownloadResult:setDescInfo	(Ljava/lang/String;)V
    //   165: return
    //   166: astore_1
    //   167: ldc 187
    //   169: ldc_w 449
    //   172: aload_1
    //   173: invokestatic 504	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   176: return
    //   177: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   180: lstore 16
    //   182: new 506	com/tencent/component/network/downloader/DownloadReport
    //   185: dup
    //   186: invokespecial 507	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   189: astore 26
    //   191: aload 26
    //   193: iload 7
    //   195: putfield 510	com/tencent/component/network/downloader/DownloadReport:id	I
    //   198: aload 26
    //   200: aload_0
    //   201: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   204: putfield 513	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   207: aload 26
    //   209: aload_0
    //   210: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   213: putfield 516	com/tencent/component/network/downloader/DownloadReport:domain	Ljava/lang/String;
    //   216: aload 26
    //   218: invokestatic 521	java/lang/System:currentTimeMillis	()J
    //   221: putfield 524	com/tencent/component/network/downloader/DownloadReport:startTime	J
    //   224: aload_0
    //   225: aconst_null
    //   226: putfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   229: aload_0
    //   230: aconst_null
    //   231: putfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   234: aload_0
    //   235: aconst_null
    //   236: putfield 530	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   239: aload_0
    //   240: aconst_null
    //   241: putfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   244: aconst_null
    //   245: astore 24
    //   247: aconst_null
    //   248: astore 23
    //   250: iconst_0
    //   251: istore 6
    //   253: invokestatic 521	java/lang/System:currentTimeMillis	()J
    //   256: lstore 18
    //   258: aload_0
    //   259: aload_0
    //   260: getfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   263: invokespecial 532	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(I)Z
    //   266: istore 20
    //   268: iload 20
    //   270: ifne +19 -> 289
    //   273: iload 4
    //   275: istore_3
    //   276: aload_0
    //   277: invokevirtual 534	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Z
    //   280: ifne +9411 -> 9691
    //   283: aload 21
    //   285: astore_1
    //   286: goto -177 -> 109
    //   289: aconst_null
    //   290: astore 21
    //   292: aload 21
    //   294: ifnull +1242 -> 1536
    //   297: lload 8
    //   299: lstore 10
    //   301: lload 8
    //   303: lstore 12
    //   305: aload 24
    //   307: astore 22
    //   309: aload 21
    //   311: athrow
    //   312: astore 21
    //   314: lload 10
    //   316: lstore 8
    //   318: aconst_null
    //   319: astore 22
    //   321: iconst_0
    //   322: istore_3
    //   323: aload_2
    //   324: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   327: aload 21
    //   329: invokevirtual 537	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   332: iload 4
    //   334: iconst_1
    //   335: iadd
    //   336: istore 5
    //   338: aload_2
    //   339: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   342: lload 16
    //   344: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   347: invokevirtual 546	com/tencent/component/network/downloader/DownloadResult$Process:a	(JJ)V
    //   350: aload_0
    //   351: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   354: invokestatic 551	com/tencent/component/network/module/common/NetworkStatus:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   357: invokevirtual 554	com/tencent/component/network/module/common/NetworkStatus:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   360: astore 27
    //   362: aload_0
    //   363: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   366: ifnull +7037 -> 7403
    //   369: aload_0
    //   370: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   373: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   376: ifnull +7027 -> 7403
    //   379: aload_0
    //   380: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   383: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   386: invokevirtual 558	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   389: astore 24
    //   391: aload_0
    //   392: aload_0
    //   393: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   396: aload_0
    //   397: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   400: aload_0
    //   401: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   404: invokevirtual 561	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   407: astore 28
    //   409: aload 24
    //   411: ifnull +7000 -> 7411
    //   414: aload 24
    //   416: astore 23
    //   418: aload 22
    //   420: ifnull +9250 -> 9670
    //   423: aload 22
    //   425: ldc_w 563
    //   428: invokeinterface 569 2 0
    //   433: checkcast 354	java/lang/String
    //   436: astore 22
    //   438: aload_2
    //   439: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   442: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   445: ifne +64 -> 509
    //   448: aload_0
    //   449: getfield 575	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   452: ifnull +28 -> 480
    //   455: aload_0
    //   456: getfield 575	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   459: aload_0
    //   460: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   463: aload_2
    //   464: invokevirtual 578	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   467: aload_0
    //   468: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   471: aload_0
    //   472: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   475: invokeinterface 583 5 0
    //   480: aload_0
    //   481: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   484: invokestatic 93	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   487: ifne +22 -> 509
    //   490: aload_0
    //   491: aload_0
    //   492: getfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   495: iconst_1
    //   496: isub
    //   497: putfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   500: aload_2
    //   501: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   504: bipush 6
    //   506: invokevirtual 481	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   509: aload_1
    //   510: invokeinterface 459 1 0
    //   515: ifne +985 -> 1500
    //   518: aload_2
    //   519: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   522: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   525: ifne +6904 -> 7429
    //   528: new 64	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   535: ldc_w 585
    //   538: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload_0
    //   542: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   545: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: ldc_w 587
    //   551: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: astore 29
    //   556: aload_0
    //   557: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   560: ifeq +7450 -> 8010
    //   563: aload_0
    //   564: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   567: ifnull +7443 -> 8010
    //   570: aload_0
    //   571: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   574: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   577: ifnull +7433 -> 8010
    //   580: aload_0
    //   581: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   584: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   587: invokevirtual 594	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   590: astore 25
    //   592: aload 29
    //   594: aload 25
    //   596: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: ldc_w 596
    //   602: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload 27
    //   607: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   610: ldc_w 601
    //   613: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload 24
    //   618: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: ldc_w 603
    //   624: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: ldc_w 605
    //   630: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: ldc_w 607
    //   636: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: invokestatic 288	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   642: invokevirtual 291	java/lang/Thread:getId	()J
    //   645: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   648: ldc_w 609
    //   651: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: invokestatic 278	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   657: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: ldc_w 611
    //   663: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_0
    //   667: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   670: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   673: ldc_w 613
    //   676: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: aload_0
    //   680: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   683: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   686: ldc_w 615
    //   689: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: astore 25
    //   694: aload_0
    //   695: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   698: ifeq +7320 -> 8018
    //   701: aload_0
    //   702: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   705: aload_0
    //   706: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   709: invokestatic 419	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   712: astore 24
    //   714: aload 25
    //   716: aload 24
    //   718: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   721: ldc_w 617
    //   724: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: aload_0
    //   728: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   731: invokestatic 93	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   734: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   737: ldc_w 619
    //   740: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload_2
    //   744: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   747: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   750: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: ldc_w 621
    //   756: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload_2
    //   760: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   763: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   766: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   769: ldc_w 625
    //   772: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   778: aload_0
    //   779: getfield 43	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_g_of_type_Long	J
    //   782: lsub
    //   783: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   786: ldc_w 627
    //   789: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: aload_2
    //   793: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   796: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   799: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   802: ldc_w 632
    //   805: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: aload_2
    //   809: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   812: getfield 634	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   815: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   818: ldc_w 636
    //   821: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: aload_2
    //   825: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   828: getfield 639	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   831: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   834: ldc_w 641
    //   837: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: aload_0
    //   841: getfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   844: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   847: ldc 75
    //   849: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: aload_0
    //   853: getfield 642	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_Int	I
    //   856: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   859: ldc_w 644
    //   862: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: ldc_w 646
    //   868: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: iload 5
    //   873: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   876: ldc_w 644
    //   879: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: ldc_w 648
    //   885: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: aload_2
    //   889: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   892: invokevirtual 484	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   895: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   898: ldc_w 650
    //   901: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: iload_3
    //   905: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   908: ldc_w 652
    //   911: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: aload 28
    //   916: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: ldc_w 654
    //   922: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: aload 22
    //   927: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: ldc_w 656
    //   933: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: astore 22
    //   938: aload_0
    //   939: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   942: ifnull +7082 -> 8024
    //   945: aload_0
    //   946: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   949: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   952: istore 4
    //   954: aload 22
    //   956: iload 4
    //   958: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   961: ldc_w 658
    //   964: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: aload_2
    //   968: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   971: getfield 661	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   974: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: ldc_w 663
    //   980: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: lload 8
    //   985: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   988: ldc_w 665
    //   991: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: aload_0
    //   995: getfield 53	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Long	J
    //   998: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1001: ldc 75
    //   1003: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: aload_0
    //   1007: getfield 55	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Int	I
    //   1010: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1013: ldc_w 644
    //   1016: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: ldc_w 667
    //   1022: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: aload_0
    //   1026: getfield 57	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Long	J
    //   1029: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1032: ldc 75
    //   1034: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: aload_0
    //   1038: getfield 59	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Int	I
    //   1041: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1044: ldc_w 644
    //   1047: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: ldc_w 669
    //   1053: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: aload_0
    //   1057: getfield 61	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Long	J
    //   1060: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1063: ldc_w 671
    //   1066: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: aload_0
    //   1070: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_c_of_type_Long	J
    //   1073: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1076: ldc_w 674
    //   1079: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: aload_0
    //   1083: invokevirtual 676	com/tencent/component/network/downloader/impl/StrictDownloadTask:d	()I
    //   1086: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1089: ldc_w 644
    //   1092: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: ldc_w 678
    //   1098: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: astore 24
    //   1103: aload_0
    //   1104: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1107: ifnull +6923 -> 8030
    //   1110: aload_0
    //   1111: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1114: invokeinterface 687 1 0
    //   1119: astore 22
    //   1121: ldc_w 689
    //   1124: aload 24
    //   1126: aload 22
    //   1128: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1131: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1134: aload 21
    //   1136: invokestatic 504	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1139: getstatic 312	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:d	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1142: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   1145: aload_0
    //   1146: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1149: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   1152: if_icmpne +37 -> 1189
    //   1155: aload_0
    //   1156: getfield 334	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1159: ifnull +30 -> 1189
    //   1162: aload_0
    //   1163: getfield 334	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1166: aload_0
    //   1167: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   1170: aload_0
    //   1171: getfield 691	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1174: invokestatic 694	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1177: aload_2
    //   1178: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1181: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1184: invokeinterface 697 4 0
    //   1189: getstatic 408	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1192: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   1195: aload_0
    //   1196: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1199: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   1202: if_icmpne +37 -> 1239
    //   1205: aload_0
    //   1206: getfield 394	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1209: ifnull +30 -> 1239
    //   1212: aload_0
    //   1213: getfield 394	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1216: aload_0
    //   1217: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   1220: aload_0
    //   1221: getfield 691	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1224: invokestatic 694	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1227: aload_2
    //   1228: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1231: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1234: invokeinterface 697 4 0
    //   1239: aload 26
    //   1241: invokestatic 521	java/lang/System:currentTimeMillis	()J
    //   1244: putfield 700	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   1247: aload 26
    //   1249: aload_0
    //   1250: getfield 702	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_Long	J
    //   1253: putfield 705	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   1256: aload 26
    //   1258: aload_0
    //   1259: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   1262: putfield 708	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   1265: aload 26
    //   1267: iload_3
    //   1268: putfield 709	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   1271: aload 26
    //   1273: aload 21
    //   1275: putfield 713	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   1278: aload 27
    //   1280: ifnonnull +6812 -> 8092
    //   1283: aconst_null
    //   1284: astore 21
    //   1286: aload 26
    //   1288: aload 21
    //   1290: putfield 716	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   1293: aload_0
    //   1294: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1297: ifnull +6805 -> 8102
    //   1300: aload_0
    //   1301: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1304: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1307: ifnull +6795 -> 8102
    //   1310: aload_0
    //   1311: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1314: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1317: getfield 717	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1320: astore 21
    //   1322: aload 26
    //   1324: aload 21
    //   1326: putfield 720	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   1329: aload 26
    //   1331: ldc_w 605
    //   1334: putfield 723	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   1337: aload 26
    //   1339: aload_2
    //   1340: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1343: getfield 661	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1346: putfield 724	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   1349: aload 26
    //   1351: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   1354: aload_0
    //   1355: getfield 43	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_g_of_type_Long	J
    //   1358: lsub
    //   1359: putfield 727	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1362: aload 26
    //   1364: aload_2
    //   1365: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1368: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   1371: putfield 730	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   1374: aload 26
    //   1376: aload 26
    //   1378: getfield 727	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1381: aload_2
    //   1382: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1385: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   1388: lsub
    //   1389: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   1392: aload 26
    //   1394: lload 8
    //   1396: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   1399: aload 26
    //   1401: aload_0
    //   1402: getfield 53	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Long	J
    //   1405: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   1408: aload 26
    //   1410: aload_0
    //   1411: getfield 61	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Long	J
    //   1414: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   1417: aload 26
    //   1419: aload_0
    //   1420: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_c_of_type_Long	J
    //   1423: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   1426: aload 26
    //   1428: lconst_0
    //   1429: putfield 748	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   1432: aload 26
    //   1434: aload_0
    //   1435: invokevirtual 676	com/tencent/component/network/downloader/impl/StrictDownloadTask:d	()I
    //   1438: putfield 751	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   1441: aload 26
    //   1443: aload_2
    //   1444: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1447: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1450: putfield 754	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   1453: aload 26
    //   1455: aload_0
    //   1456: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   1459: invokestatic 758	com/tencent/component/network/module/base/Config:b	(Ljava/lang/String;)Z
    //   1462: putfield 761	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   1465: aload 26
    //   1467: aload_0
    //   1468: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   1471: putfield 764	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   1474: aload 26
    //   1476: aload_2
    //   1477: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1480: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1483: putfield 766	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   1486: aload_2
    //   1487: aload 26
    //   1489: invokevirtual 770	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1492: aload_0
    //   1493: aload_1
    //   1494: aload_2
    //   1495: aload 26
    //   1497: invokevirtual 462	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1500: aload_0
    //   1501: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   1504: ifeq +6604 -> 8108
    //   1507: aload_0
    //   1508: getfield 773	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   1511: ifnull +10 -> 1521
    //   1514: aload_0
    //   1515: getfield 773	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   1518: invokevirtual 778	com/squareup/okhttp/Call:cancel	()V
    //   1521: aload_0
    //   1522: aconst_null
    //   1523: putfield 530	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   1526: aload 23
    //   1528: astore 21
    //   1530: iload 5
    //   1532: istore_3
    //   1533: goto -1257 -> 276
    //   1536: lload 8
    //   1538: lstore 10
    //   1540: lload 8
    //   1542: lstore 12
    //   1544: aload 24
    //   1546: astore 22
    //   1548: getstatic 781	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_JavaLangThreadLocal	Ljava/lang/ThreadLocal;
    //   1551: invokevirtual 787	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   1554: checkcast 789	com/tencent/component/network/utils/http/HttpUtil$RequestOptions
    //   1557: astore 27
    //   1559: lload 8
    //   1561: lstore 10
    //   1563: lload 8
    //   1565: lstore 12
    //   1567: aload 24
    //   1569: astore 22
    //   1571: aload 27
    //   1573: aload_0
    //   1574: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   1577: putfield 790	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:jdField_a_of_type_Boolean	Z
    //   1580: lload 8
    //   1582: lstore 10
    //   1584: lload 8
    //   1586: lstore 12
    //   1588: aload 24
    //   1590: astore 22
    //   1592: aload 27
    //   1594: aload_0
    //   1595: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   1598: putfield 791	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:jdField_b_of_type_Boolean	Z
    //   1601: lload 8
    //   1603: lstore 10
    //   1605: lload 8
    //   1607: lstore 12
    //   1609: aload 24
    //   1611: astore 22
    //   1613: aload_0
    //   1614: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1617: ifnull +2316 -> 3933
    //   1620: lload 8
    //   1622: lstore 10
    //   1624: lload 8
    //   1626: lstore 12
    //   1628: aload 24
    //   1630: astore 22
    //   1632: aload_0
    //   1633: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1636: invokeinterface 687 1 0
    //   1641: astore 21
    //   1643: lload 8
    //   1645: lstore 10
    //   1647: lload 8
    //   1649: lstore 12
    //   1651: aload 24
    //   1653: astore 22
    //   1655: aload 27
    //   1657: aload 21
    //   1659: putfield 794	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:jdField_a_of_type_JavaNetProxy	Ljava/net/Proxy;
    //   1662: lload 8
    //   1664: lstore 10
    //   1666: lload 8
    //   1668: lstore 12
    //   1670: aload 24
    //   1672: astore 22
    //   1674: aload 26
    //   1676: iload 4
    //   1678: putfield 797	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   1681: lload 8
    //   1683: lstore 10
    //   1685: lload 8
    //   1687: lstore 12
    //   1689: aload 24
    //   1691: astore 22
    //   1693: aload_2
    //   1694: invokevirtual 800	com/tencent/component/network/downloader/DownloadResult:reset	()V
    //   1697: lload 8
    //   1699: lstore 10
    //   1701: lload 8
    //   1703: lstore 12
    //   1705: aload 24
    //   1707: astore 22
    //   1709: aload_0
    //   1710: aload_0
    //   1711: aload_0
    //   1712: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   1715: invokevirtual 801	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1718: putfield 691	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1721: lload 8
    //   1723: lstore 10
    //   1725: lload 8
    //   1727: lstore 12
    //   1729: aload 24
    //   1731: astore 22
    //   1733: aload 27
    //   1735: getfield 794	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:jdField_a_of_type_JavaNetProxy	Ljava/net/Proxy;
    //   1738: ifnonnull +483 -> 2221
    //   1741: lload 8
    //   1743: lstore 10
    //   1745: lload 8
    //   1747: lstore 12
    //   1749: aload 24
    //   1751: astore 22
    //   1753: aload_0
    //   1754: getfield 691	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1757: ldc_w 803
    //   1760: invokevirtual 806	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1763: ifeq +22 -> 1785
    //   1766: lload 8
    //   1768: lstore 10
    //   1770: lload 8
    //   1772: lstore 12
    //   1774: aload 24
    //   1776: astore 22
    //   1778: aload_0
    //   1779: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   1782: ifeq +439 -> 2221
    //   1785: lload 8
    //   1787: lstore 10
    //   1789: lload 8
    //   1791: lstore 12
    //   1793: aload 24
    //   1795: astore 22
    //   1797: aload_0
    //   1798: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1801: ifnull +420 -> 2221
    //   1804: lload 8
    //   1806: lstore 10
    //   1808: lload 8
    //   1810: lstore 12
    //   1812: aload 24
    //   1814: astore 22
    //   1816: aload_0
    //   1817: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1820: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1823: ifnull +398 -> 2221
    //   1826: lload 8
    //   1828: lstore 10
    //   1830: lload 8
    //   1832: lstore 12
    //   1834: aload 24
    //   1836: astore 22
    //   1838: aload_0
    //   1839: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1842: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1845: getfield 717	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1848: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1851: ifne +370 -> 2221
    //   1854: lload 8
    //   1856: lstore 10
    //   1858: lload 8
    //   1860: lstore 12
    //   1862: aload 24
    //   1864: astore 22
    //   1866: aload_0
    //   1867: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1870: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1873: getfield 717	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1876: astore 25
    //   1878: lload 8
    //   1880: lstore 10
    //   1882: lload 8
    //   1884: lstore 12
    //   1886: aload 24
    //   1888: astore 22
    //   1890: aload_0
    //   1891: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   1894: astore 21
    //   1896: lload 8
    //   1898: lstore 10
    //   1900: lload 8
    //   1902: lstore 12
    //   1904: aload 24
    //   1906: astore 22
    //   1908: aload 25
    //   1910: bipush 58
    //   1912: invokestatic 810	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   1915: iconst_2
    //   1916: if_icmpge +183 -> 2099
    //   1919: lload 8
    //   1921: lstore 10
    //   1923: lload 8
    //   1925: lstore 12
    //   1927: aload 24
    //   1929: astore 22
    //   1931: aload_0
    //   1932: getfield 35	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_g_of_type_Int	I
    //   1935: istore_3
    //   1936: iload_3
    //   1937: ifle +2002 -> 3939
    //   1940: lload 8
    //   1942: lstore 10
    //   1944: lload 8
    //   1946: lstore 12
    //   1948: aload 24
    //   1950: astore 22
    //   1952: aload_0
    //   1953: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1956: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1959: iload_3
    //   1960: putfield 811	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_Int	I
    //   1963: lload 8
    //   1965: lstore 10
    //   1967: iload_3
    //   1968: istore 5
    //   1970: lload 8
    //   1972: lstore 12
    //   1974: aload 24
    //   1976: astore 22
    //   1978: iload_3
    //   1979: invokestatic 310	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   1982: ifne +21 -> 2003
    //   1985: lload 8
    //   1987: lstore 10
    //   1989: lload 8
    //   1991: lstore 12
    //   1993: aload 24
    //   1995: astore 22
    //   1997: aload_0
    //   1998: getfield 255	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_c_of_type_Int	I
    //   2001: istore 5
    //   2003: lload 8
    //   2005: lstore 10
    //   2007: lload 8
    //   2009: lstore 12
    //   2011: aload 24
    //   2013: astore 22
    //   2015: new 64	java/lang/StringBuilder
    //   2018: dup
    //   2019: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2022: aload 25
    //   2024: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2027: ldc_w 813
    //   2030: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2033: iload 5
    //   2035: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2038: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2041: astore 25
    //   2043: lload 8
    //   2045: lstore 10
    //   2047: aload 25
    //   2049: astore 21
    //   2051: lload 8
    //   2053: lstore 12
    //   2055: aload 24
    //   2057: astore 22
    //   2059: aload_0
    //   2060: getfield 438	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2063: ifnull +36 -> 2099
    //   2066: lload 8
    //   2068: lstore 10
    //   2070: lload 8
    //   2072: lstore 12
    //   2074: aload 24
    //   2076: astore 22
    //   2078: aload_0
    //   2079: aload_0
    //   2080: getfield 691	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2083: aload_0
    //   2084: getfield 438	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2087: aload 25
    //   2089: invokevirtual 817	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2092: putfield 691	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2095: aload 25
    //   2097: astore 21
    //   2099: lload 8
    //   2101: lstore 10
    //   2103: lload 8
    //   2105: lstore 12
    //   2107: aload 24
    //   2109: astore 22
    //   2111: aload 26
    //   2113: aload_0
    //   2114: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2117: invokevirtual 263	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2120: putfield 820	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2123: lload 8
    //   2125: lstore 10
    //   2127: lload 8
    //   2129: lstore 12
    //   2131: aload 24
    //   2133: astore 22
    //   2135: invokestatic 258	com/tencent/component/network/module/base/QDLog:b	()Z
    //   2138: ifeq +83 -> 2221
    //   2141: lload 8
    //   2143: lstore 10
    //   2145: lload 8
    //   2147: lstore 12
    //   2149: aload 24
    //   2151: astore 22
    //   2153: ldc 187
    //   2155: new 64	java/lang/StringBuilder
    //   2158: dup
    //   2159: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2162: ldc_w 822
    //   2165: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2168: aload 26
    //   2170: getfield 820	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2173: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2176: ldc_w 824
    //   2179: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2182: aload 21
    //   2184: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2187: ldc_w 273
    //   2190: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2193: aload_0
    //   2194: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   2197: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2200: ldc_w 329
    //   2203: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2206: invokestatic 288	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2209: invokevirtual 291	java/lang/Thread:getId	()J
    //   2212: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2215: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2218: invokestatic 296	com/tencent/component/network/module/base/QDLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2221: lload 8
    //   2223: lstore 10
    //   2225: lload 8
    //   2227: lstore 12
    //   2229: aload 24
    //   2231: astore 22
    //   2233: aload_0
    //   2234: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2237: ifnull +51 -> 2288
    //   2240: lload 8
    //   2242: lstore 10
    //   2244: lload 8
    //   2246: lstore 12
    //   2248: aload 24
    //   2250: astore 22
    //   2252: aload 26
    //   2254: aload_0
    //   2255: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2258: invokevirtual 263	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2261: putfield 820	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2264: lload 8
    //   2266: lstore 10
    //   2268: lload 8
    //   2270: lstore 12
    //   2272: aload 24
    //   2274: astore 22
    //   2276: aload 26
    //   2278: aload_0
    //   2279: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2282: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   2285: putfield 827	com/tencent/component/network/downloader/DownloadReport:strategyId	I
    //   2288: lload 8
    //   2290: lstore 10
    //   2292: lload 8
    //   2294: lstore 12
    //   2296: aload 24
    //   2298: astore 22
    //   2300: aload_0
    //   2301: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   2304: ifeq +1661 -> 3965
    //   2307: lload 8
    //   2309: lstore 10
    //   2311: lload 8
    //   2313: lstore 12
    //   2315: aload 24
    //   2317: astore 22
    //   2319: aload_0
    //   2320: aload_0
    //   2321: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2324: aload_0
    //   2325: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   2328: aload_0
    //   2329: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   2332: aload_0
    //   2333: getfield 691	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2336: invokestatic 832	com/tencent/component/network/utils/http/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   2339: putfield 530	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   2342: lload 8
    //   2344: lstore 10
    //   2346: lload 8
    //   2348: lstore 12
    //   2350: aload 24
    //   2352: astore 22
    //   2354: aload_0
    //   2355: getfield 575	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2358: ifnull +40 -> 2398
    //   2361: lload 8
    //   2363: lstore 10
    //   2365: lload 8
    //   2367: lstore 12
    //   2369: aload 24
    //   2371: astore 22
    //   2373: aload_0
    //   2374: getfield 575	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2377: aload_0
    //   2378: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   2381: aload_0
    //   2382: getfield 530	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   2385: aload_0
    //   2386: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   2389: aload_0
    //   2390: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   2393: invokeinterface 835 5 0
    //   2398: lload 8
    //   2400: lstore 10
    //   2402: lload 8
    //   2404: lstore 12
    //   2406: aload 24
    //   2408: astore 22
    //   2410: aload_0
    //   2411: aload_0
    //   2412: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   2415: aload_0
    //   2416: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   2419: aload_0
    //   2420: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   2423: aload_0
    //   2424: getfield 530	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   2427: invokevirtual 838	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lcom/squareup/okhttp/Request$Builder;)V
    //   2430: lload 8
    //   2432: lstore 10
    //   2434: lload 8
    //   2436: lstore 12
    //   2438: aload 24
    //   2440: astore 22
    //   2442: aload_0
    //   2443: aload_0
    //   2444: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   2447: aload_0
    //   2448: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   2451: aload_0
    //   2452: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   2455: aload_0
    //   2456: getfield 530	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   2459: aload 27
    //   2461: invokevirtual 841	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lcom/squareup/okhttp/Request$Builder;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)V
    //   2464: lload 8
    //   2466: lstore 10
    //   2468: lload 8
    //   2470: lstore 12
    //   2472: aload 24
    //   2474: astore 22
    //   2476: invokestatic 521	java/lang/System:currentTimeMillis	()J
    //   2479: lload 18
    //   2481: lsub
    //   2482: lstore 8
    //   2484: lload 8
    //   2486: lstore 10
    //   2488: lload 8
    //   2490: lstore 12
    //   2492: aload 24
    //   2494: astore 22
    //   2496: aload_0
    //   2497: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   2500: putfield 61	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Long	J
    //   2503: lload 8
    //   2505: lstore 10
    //   2507: lload 8
    //   2509: lstore 12
    //   2511: aload 24
    //   2513: astore 22
    //   2515: aload_0
    //   2516: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   2519: ifnull +2699 -> 5218
    //   2522: lload 8
    //   2524: lstore 10
    //   2526: lload 8
    //   2528: lstore 12
    //   2530: aload 24
    //   2532: astore 22
    //   2534: aload_0
    //   2535: getfield 844	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseQZoneHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2538: ifnonnull +22 -> 2560
    //   2541: lload 8
    //   2543: lstore 10
    //   2545: lload 8
    //   2547: lstore 12
    //   2549: aload 24
    //   2551: astore 22
    //   2553: aload_0
    //   2554: invokestatic 847	com/tencent/component/network/utils/http/HttpUtil:a	()Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2557: putfield 844	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseQZoneHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2560: lload 8
    //   2562: lstore 10
    //   2564: lload 8
    //   2566: lstore 12
    //   2568: aload 24
    //   2570: astore 22
    //   2572: invokestatic 850	com/tencent/component/network/utils/http/HttpUtil:a	()Lorg/apache/http/protocol/HttpContext;
    //   2575: astore 21
    //   2577: aload_0
    //   2578: aload_0
    //   2579: getfield 844	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseQZoneHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2582: aload_0
    //   2583: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   2586: aload 21
    //   2588: invokevirtual 856	com/tencent/component/network/utils/http/base/QZoneHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   2591: putfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   2594: lload 8
    //   2596: lstore 12
    //   2598: aload 21
    //   2600: astore 22
    //   2602: aload_0
    //   2603: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   2606: aload_0
    //   2607: getfield 61	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Long	J
    //   2610: lsub
    //   2611: putfield 61	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Long	J
    //   2614: lload 8
    //   2616: lstore 12
    //   2618: aload 21
    //   2620: astore 22
    //   2622: aload_0
    //   2623: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   2626: ifnonnull +18 -> 2644
    //   2629: lload 8
    //   2631: lstore 12
    //   2633: aload 21
    //   2635: astore 22
    //   2637: aload_0
    //   2638: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   2641: ifnull +4023 -> 6664
    //   2644: lload 8
    //   2646: lstore 12
    //   2648: aload 21
    //   2650: astore 22
    //   2652: aload_0
    //   2653: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   2656: ifnull +2647 -> 5303
    //   2659: lload 8
    //   2661: lstore 12
    //   2663: aload 21
    //   2665: astore 22
    //   2667: aload_0
    //   2668: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   2671: invokeinterface 173 1 0
    //   2676: invokeinterface 861 1 0
    //   2681: istore_3
    //   2682: aload_2
    //   2683: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2686: iload_3
    //   2687: putfield 487	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   2690: sipush 200
    //   2693: iload_3
    //   2694: if_icmpeq +10 -> 2704
    //   2697: sipush 206
    //   2700: iload_3
    //   2701: if_icmpne +2636 -> 5337
    //   2704: iload_3
    //   2705: istore 5
    //   2707: aload_0
    //   2708: aload_0
    //   2709: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   2712: aload_0
    //   2713: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   2716: aload_2
    //   2717: aload_1
    //   2718: iload_3
    //   2719: invokevirtual 864	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   2722: ifeq +2740 -> 5462
    //   2725: aload_2
    //   2726: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2729: invokevirtual 867	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   2732: iload 4
    //   2734: iconst_1
    //   2735: iadd
    //   2736: istore 5
    //   2738: aload_2
    //   2739: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2742: lload 16
    //   2744: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   2747: invokevirtual 546	com/tencent/component/network/downloader/DownloadResult$Process:a	(JJ)V
    //   2750: aload_0
    //   2751: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2754: invokestatic 551	com/tencent/component/network/module/common/NetworkStatus:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   2757: invokevirtual 554	com/tencent/component/network/module/common/NetworkStatus:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   2760: astore 25
    //   2762: aload_0
    //   2763: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2766: ifnull +5359 -> 8125
    //   2769: aload_0
    //   2770: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2773: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2776: ifnull +5349 -> 8125
    //   2779: aload_0
    //   2780: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2783: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2786: invokevirtual 558	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   2789: astore 23
    //   2791: aload_0
    //   2792: aload_0
    //   2793: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   2796: aload_0
    //   2797: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   2800: aload_0
    //   2801: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   2804: invokevirtual 561	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   2807: astore 27
    //   2809: aload 23
    //   2811: ifnull +5322 -> 8133
    //   2814: aload 23
    //   2816: astore 22
    //   2818: aload 21
    //   2820: ifnull +6842 -> 9662
    //   2823: aload 21
    //   2825: ldc_w 563
    //   2828: invokeinterface 569 2 0
    //   2833: checkcast 354	java/lang/String
    //   2836: astore 21
    //   2838: aload_2
    //   2839: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2842: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2845: ifne +64 -> 2909
    //   2848: aload_0
    //   2849: getfield 575	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2852: ifnull +28 -> 2880
    //   2855: aload_0
    //   2856: getfield 575	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2859: aload_0
    //   2860: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   2863: aload_2
    //   2864: invokevirtual 578	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   2867: aload_0
    //   2868: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   2871: aload_0
    //   2872: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   2875: invokeinterface 583 5 0
    //   2880: aload_0
    //   2881: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2884: invokestatic 93	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2887: ifne +22 -> 2909
    //   2890: aload_0
    //   2891: aload_0
    //   2892: getfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   2895: iconst_1
    //   2896: isub
    //   2897: putfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   2900: aload_2
    //   2901: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2904: bipush 6
    //   2906: invokevirtual 481	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   2909: aload_1
    //   2910: invokeinterface 459 1 0
    //   2915: ifne +983 -> 3898
    //   2918: aload_2
    //   2919: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2922: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2925: ifne +5226 -> 8151
    //   2928: new 64	java/lang/StringBuilder
    //   2931: dup
    //   2932: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2935: ldc_w 585
    //   2938: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2941: aload_0
    //   2942: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   2945: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2948: ldc_w 587
    //   2951: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2954: astore 28
    //   2956: aload_0
    //   2957: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   2960: ifeq +5772 -> 8732
    //   2963: aload_0
    //   2964: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   2967: ifnull +5765 -> 8732
    //   2970: aload_0
    //   2971: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   2974: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   2977: ifnull +5755 -> 8732
    //   2980: aload_0
    //   2981: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   2984: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   2987: invokevirtual 594	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   2990: astore 24
    //   2992: aload 28
    //   2994: aload 24
    //   2996: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2999: ldc_w 596
    //   3002: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3005: aload 25
    //   3007: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3010: ldc_w 601
    //   3013: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3016: aload 23
    //   3018: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3021: ldc_w 603
    //   3024: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3027: ldc_w 605
    //   3030: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3033: ldc_w 607
    //   3036: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3039: invokestatic 288	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3042: invokevirtual 291	java/lang/Thread:getId	()J
    //   3045: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3048: ldc_w 609
    //   3051: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3054: invokestatic 278	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3057: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3060: ldc_w 611
    //   3063: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3066: aload_0
    //   3067: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   3070: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3073: ldc_w 613
    //   3076: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3079: aload_0
    //   3080: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   3083: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3086: ldc_w 615
    //   3089: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3092: astore 24
    //   3094: aload_0
    //   3095: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   3098: ifeq +5642 -> 8740
    //   3101: aload_0
    //   3102: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   3105: aload_0
    //   3106: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   3109: invokestatic 419	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   3112: astore 23
    //   3114: aload 24
    //   3116: aload 23
    //   3118: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3121: ldc_w 617
    //   3124: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3127: aload_0
    //   3128: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   3131: invokestatic 93	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3134: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3137: ldc_w 619
    //   3140: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3143: aload_2
    //   3144: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3147: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3150: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3153: ldc_w 621
    //   3156: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3159: aload_2
    //   3160: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3163: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   3166: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3169: ldc_w 625
    //   3172: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3175: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   3178: aload_0
    //   3179: getfield 43	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_g_of_type_Long	J
    //   3182: lsub
    //   3183: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3186: ldc_w 627
    //   3189: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3192: aload_2
    //   3193: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3196: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3199: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3202: ldc_w 632
    //   3205: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3208: aload_2
    //   3209: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3212: getfield 634	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3215: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3218: ldc_w 636
    //   3221: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3224: aload_2
    //   3225: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3228: getfield 639	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3231: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3234: ldc_w 641
    //   3237: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3240: aload_0
    //   3241: getfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   3244: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3247: ldc 75
    //   3249: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3252: aload_0
    //   3253: getfield 642	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_Int	I
    //   3256: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3259: ldc_w 644
    //   3262: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3265: ldc_w 646
    //   3268: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3271: iload 5
    //   3273: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3276: ldc_w 644
    //   3279: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3282: ldc_w 648
    //   3285: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3288: aload_2
    //   3289: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3292: invokevirtual 484	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3295: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3298: ldc_w 650
    //   3301: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3304: iload_3
    //   3305: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3308: ldc_w 652
    //   3311: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3314: aload 27
    //   3316: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3319: ldc_w 654
    //   3322: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3325: aload 21
    //   3327: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3330: ldc_w 656
    //   3333: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3336: astore 21
    //   3338: aload_0
    //   3339: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3342: ifnull +5404 -> 8746
    //   3345: aload_0
    //   3346: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3349: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3352: istore 4
    //   3354: aload 21
    //   3356: iload 4
    //   3358: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3361: ldc_w 658
    //   3364: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3367: aload_2
    //   3368: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3371: getfield 661	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3374: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3377: ldc_w 663
    //   3380: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3383: lload 8
    //   3385: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3388: ldc_w 665
    //   3391: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3394: aload_0
    //   3395: getfield 53	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Long	J
    //   3398: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3401: ldc 75
    //   3403: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3406: aload_0
    //   3407: getfield 55	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Int	I
    //   3410: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3413: ldc_w 644
    //   3416: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3419: ldc_w 667
    //   3422: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3425: aload_0
    //   3426: getfield 57	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Long	J
    //   3429: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3432: ldc 75
    //   3434: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3437: aload_0
    //   3438: getfield 59	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Int	I
    //   3441: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3444: ldc_w 644
    //   3447: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3450: ldc_w 669
    //   3453: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3456: aload_0
    //   3457: getfield 61	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Long	J
    //   3460: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3463: ldc_w 671
    //   3466: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3469: aload_0
    //   3470: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_c_of_type_Long	J
    //   3473: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3476: ldc_w 674
    //   3479: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3482: aload_0
    //   3483: invokevirtual 676	com/tencent/component/network/downloader/impl/StrictDownloadTask:d	()I
    //   3486: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3489: ldc_w 644
    //   3492: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3495: ldc_w 678
    //   3498: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3501: astore 23
    //   3503: aload_0
    //   3504: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3507: ifnull +5245 -> 8752
    //   3510: aload_0
    //   3511: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3514: invokeinterface 687 1 0
    //   3519: astore 21
    //   3521: ldc_w 689
    //   3524: aload 23
    //   3526: aload 21
    //   3528: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3531: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3534: aconst_null
    //   3535: invokestatic 504	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3538: getstatic 312	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:d	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3541: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3544: aload_0
    //   3545: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3548: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3551: if_icmpne +37 -> 3588
    //   3554: aload_0
    //   3555: getfield 334	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3558: ifnull +30 -> 3588
    //   3561: aload_0
    //   3562: getfield 334	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3565: aload_0
    //   3566: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   3569: aload_0
    //   3570: getfield 691	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3573: invokestatic 694	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   3576: aload_2
    //   3577: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3580: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3583: invokeinterface 697 4 0
    //   3588: getstatic 408	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3591: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3594: aload_0
    //   3595: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3598: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3601: if_icmpne +37 -> 3638
    //   3604: aload_0
    //   3605: getfield 394	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3608: ifnull +30 -> 3638
    //   3611: aload_0
    //   3612: getfield 394	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3615: aload_0
    //   3616: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   3619: aload_0
    //   3620: getfield 691	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3623: invokestatic 694	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   3626: aload_2
    //   3627: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3630: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3633: invokeinterface 697 4 0
    //   3638: aload 26
    //   3640: invokestatic 521	java/lang/System:currentTimeMillis	()J
    //   3643: putfield 700	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   3646: aload 26
    //   3648: aload_0
    //   3649: getfield 702	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_Long	J
    //   3652: putfield 705	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   3655: aload 26
    //   3657: aload_0
    //   3658: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   3661: putfield 708	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   3664: aload 26
    //   3666: iload_3
    //   3667: putfield 709	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   3670: aload 26
    //   3672: aconst_null
    //   3673: putfield 713	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   3676: aload 25
    //   3678: ifnonnull +5136 -> 8814
    //   3681: aconst_null
    //   3682: astore 21
    //   3684: aload 26
    //   3686: aload 21
    //   3688: putfield 716	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   3691: aload_0
    //   3692: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3695: ifnull +5129 -> 8824
    //   3698: aload_0
    //   3699: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3702: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3705: ifnull +5119 -> 8824
    //   3708: aload_0
    //   3709: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3712: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3715: getfield 717	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3718: astore 21
    //   3720: aload 26
    //   3722: aload 21
    //   3724: putfield 720	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   3727: aload 26
    //   3729: ldc_w 605
    //   3732: putfield 723	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   3735: aload 26
    //   3737: aload_2
    //   3738: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3741: getfield 661	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3744: putfield 724	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   3747: aload 26
    //   3749: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   3752: aload_0
    //   3753: getfield 43	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_g_of_type_Long	J
    //   3756: lsub
    //   3757: putfield 727	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   3760: aload 26
    //   3762: aload_2
    //   3763: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3766: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   3769: putfield 730	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   3772: aload 26
    //   3774: aload 26
    //   3776: getfield 727	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   3779: aload_2
    //   3780: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3783: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   3786: lsub
    //   3787: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   3790: aload 26
    //   3792: lload 8
    //   3794: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   3797: aload 26
    //   3799: aload_0
    //   3800: getfield 53	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Long	J
    //   3803: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   3806: aload 26
    //   3808: aload_0
    //   3809: getfield 61	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Long	J
    //   3812: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   3815: aload 26
    //   3817: aload_0
    //   3818: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_c_of_type_Long	J
    //   3821: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   3824: aload 26
    //   3826: lconst_0
    //   3827: putfield 748	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   3830: aload 26
    //   3832: aload_0
    //   3833: invokevirtual 676	com/tencent/component/network/downloader/impl/StrictDownloadTask:d	()I
    //   3836: putfield 751	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   3839: aload 26
    //   3841: aload_2
    //   3842: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3845: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3848: putfield 754	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   3851: aload 26
    //   3853: aload_0
    //   3854: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   3857: invokestatic 758	com/tencent/component/network/module/base/Config:b	(Ljava/lang/String;)Z
    //   3860: putfield 761	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   3863: aload 26
    //   3865: aload_0
    //   3866: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   3869: putfield 764	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   3872: aload 26
    //   3874: aload_2
    //   3875: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3878: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3881: putfield 766	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   3884: aload_2
    //   3885: aload 26
    //   3887: invokevirtual 770	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   3890: aload_0
    //   3891: aload_1
    //   3892: aload_2
    //   3893: aload 26
    //   3895: invokevirtual 462	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   3898: aload_0
    //   3899: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   3902: ifeq +4928 -> 8830
    //   3905: aload_0
    //   3906: getfield 773	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   3909: ifnull +10 -> 3919
    //   3912: aload_0
    //   3913: getfield 773	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   3916: invokevirtual 778	com/squareup/okhttp/Call:cancel	()V
    //   3919: aload_0
    //   3920: aconst_null
    //   3921: putfield 530	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   3924: aload 22
    //   3926: astore_1
    //   3927: iload 5
    //   3929: istore_3
    //   3930: goto -3821 -> 109
    //   3933: aconst_null
    //   3934: astore 21
    //   3936: goto -2293 -> 1643
    //   3939: lload 8
    //   3941: lstore 10
    //   3943: lload 8
    //   3945: lstore 12
    //   3947: aload 24
    //   3949: astore 22
    //   3951: aload_0
    //   3952: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3955: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3958: getfield 811	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_Int	I
    //   3961: istore_3
    //   3962: goto -1999 -> 1963
    //   3965: lload 8
    //   3967: lstore 10
    //   3969: lload 8
    //   3971: lstore 12
    //   3973: aload 24
    //   3975: astore 22
    //   3977: aload_0
    //   3978: aload_0
    //   3979: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   3982: aload_0
    //   3983: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   3986: aload_0
    //   3987: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   3990: aload_0
    //   3991: getfield 691	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3994: aload 27
    //   3996: invokestatic 870	com/tencent/component/network/utils/http/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lorg/apache/http/client/methods/HttpGet;
    //   3999: putfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   4002: goto -1660 -> 2342
    //   4005: astore 24
    //   4007: aconst_null
    //   4008: astore 23
    //   4010: aload 22
    //   4012: astore 21
    //   4014: iload 6
    //   4016: istore_3
    //   4017: lload 12
    //   4019: lstore 8
    //   4021: aload 24
    //   4023: astore 22
    //   4025: iload 4
    //   4027: iconst_1
    //   4028: iadd
    //   4029: istore 4
    //   4031: aload_2
    //   4032: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4035: lload 16
    //   4037: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   4040: invokevirtual 546	com/tencent/component/network/downloader/DownloadResult$Process:a	(JJ)V
    //   4043: aload_0
    //   4044: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4047: invokestatic 551	com/tencent/component/network/module/common/NetworkStatus:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   4050: invokevirtual 554	com/tencent/component/network/module/common/NetworkStatus:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4053: astore 27
    //   4055: aload_0
    //   4056: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4059: ifnull +2627 -> 6686
    //   4062: aload_0
    //   4063: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4066: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4069: ifnull +2617 -> 6686
    //   4072: aload_0
    //   4073: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4076: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4079: invokevirtual 558	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   4082: astore 24
    //   4084: aload_0
    //   4085: aload_0
    //   4086: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   4089: aload_0
    //   4090: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   4093: aload_0
    //   4094: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   4097: invokevirtual 561	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   4100: astore 28
    //   4102: aload 24
    //   4104: ifnull +2590 -> 6694
    //   4107: aload 21
    //   4109: ifnull +5569 -> 9678
    //   4112: aload 21
    //   4114: ldc_w 563
    //   4117: invokeinterface 569 2 0
    //   4122: checkcast 354	java/lang/String
    //   4125: astore 21
    //   4127: aload_2
    //   4128: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4131: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4134: ifne +64 -> 4198
    //   4137: aload_0
    //   4138: getfield 575	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4141: ifnull +28 -> 4169
    //   4144: aload_0
    //   4145: getfield 575	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4148: aload_0
    //   4149: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   4152: aload_2
    //   4153: invokevirtual 578	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   4156: aload_0
    //   4157: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   4160: aload_0
    //   4161: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   4164: invokeinterface 583 5 0
    //   4169: aload_0
    //   4170: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4173: invokestatic 93	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   4176: ifne +22 -> 4198
    //   4179: aload_0
    //   4180: aload_0
    //   4181: getfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   4184: iconst_1
    //   4185: isub
    //   4186: putfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   4189: aload_2
    //   4190: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4193: bipush 6
    //   4195: invokevirtual 481	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   4198: aload_1
    //   4199: invokeinterface 459 1 0
    //   4204: ifne +985 -> 5189
    //   4207: aload_2
    //   4208: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4211: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4214: ifne +2493 -> 6707
    //   4217: new 64	java/lang/StringBuilder
    //   4220: dup
    //   4221: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   4224: ldc_w 585
    //   4227: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4230: aload_0
    //   4231: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   4234: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4237: ldc_w 587
    //   4240: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4243: astore 29
    //   4245: aload_0
    //   4246: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   4249: ifeq +3039 -> 7288
    //   4252: aload_0
    //   4253: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   4256: ifnull +3032 -> 7288
    //   4259: aload_0
    //   4260: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   4263: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   4266: ifnull +3022 -> 7288
    //   4269: aload_0
    //   4270: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   4273: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   4276: invokevirtual 594	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   4279: astore 25
    //   4281: aload 29
    //   4283: aload 25
    //   4285: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4288: ldc_w 596
    //   4291: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4294: aload 27
    //   4296: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4299: ldc_w 601
    //   4302: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4305: aload 24
    //   4307: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4310: ldc_w 603
    //   4313: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4316: ldc_w 605
    //   4319: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4322: ldc_w 607
    //   4325: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4328: invokestatic 288	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4331: invokevirtual 291	java/lang/Thread:getId	()J
    //   4334: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4337: ldc_w 609
    //   4340: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4343: invokestatic 278	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   4346: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4349: ldc_w 611
    //   4352: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4355: aload_0
    //   4356: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   4359: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4362: ldc_w 613
    //   4365: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4368: aload_0
    //   4369: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   4372: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4375: ldc_w 615
    //   4378: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4381: astore 25
    //   4383: aload_0
    //   4384: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   4387: ifeq +2909 -> 7296
    //   4390: aload_0
    //   4391: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4394: aload_0
    //   4395: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   4398: invokestatic 419	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   4401: astore 24
    //   4403: aload 25
    //   4405: aload 24
    //   4407: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4410: ldc_w 617
    //   4413: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4416: aload_0
    //   4417: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4420: invokestatic 93	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   4423: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4426: ldc_w 619
    //   4429: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4432: aload_2
    //   4433: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4436: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4439: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4442: ldc_w 621
    //   4445: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4448: aload_2
    //   4449: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4452: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   4455: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4458: ldc_w 625
    //   4461: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4464: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   4467: aload_0
    //   4468: getfield 43	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_g_of_type_Long	J
    //   4471: lsub
    //   4472: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4475: ldc_w 627
    //   4478: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4481: aload_2
    //   4482: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4485: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4488: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4491: ldc_w 632
    //   4494: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4497: aload_2
    //   4498: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4501: getfield 634	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4504: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4507: ldc_w 636
    //   4510: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4513: aload_2
    //   4514: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4517: getfield 639	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   4520: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4523: ldc_w 641
    //   4526: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4529: aload_0
    //   4530: getfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   4533: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4536: ldc 75
    //   4538: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4541: aload_0
    //   4542: getfield 642	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_Int	I
    //   4545: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4548: ldc_w 644
    //   4551: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4554: ldc_w 646
    //   4557: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4560: iload 4
    //   4562: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4565: ldc_w 644
    //   4568: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4571: ldc_w 648
    //   4574: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4577: aload_2
    //   4578: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4581: invokevirtual 484	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   4584: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4587: ldc_w 650
    //   4590: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4593: iload_3
    //   4594: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4597: ldc_w 652
    //   4600: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4603: aload 28
    //   4605: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4608: ldc_w 654
    //   4611: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4614: aload 21
    //   4616: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4619: ldc_w 656
    //   4622: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4625: astore 21
    //   4627: aload_0
    //   4628: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4631: ifnull +2671 -> 7302
    //   4634: aload_0
    //   4635: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4638: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   4641: istore 4
    //   4643: aload 21
    //   4645: iload 4
    //   4647: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4650: ldc_w 658
    //   4653: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4656: aload_2
    //   4657: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4660: getfield 661	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4663: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4666: ldc_w 663
    //   4669: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4672: lload 8
    //   4674: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4677: ldc_w 665
    //   4680: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4683: aload_0
    //   4684: getfield 53	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Long	J
    //   4687: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4690: ldc 75
    //   4692: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4695: aload_0
    //   4696: getfield 55	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Int	I
    //   4699: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4702: ldc_w 644
    //   4705: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4708: ldc_w 667
    //   4711: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4714: aload_0
    //   4715: getfield 57	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Long	J
    //   4718: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4721: ldc 75
    //   4723: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4726: aload_0
    //   4727: getfield 59	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Int	I
    //   4730: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4733: ldc_w 644
    //   4736: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4739: ldc_w 669
    //   4742: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4745: aload_0
    //   4746: getfield 61	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Long	J
    //   4749: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4752: ldc_w 671
    //   4755: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4758: aload_0
    //   4759: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_c_of_type_Long	J
    //   4762: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4765: ldc_w 674
    //   4768: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4771: aload_0
    //   4772: invokevirtual 676	com/tencent/component/network/downloader/impl/StrictDownloadTask:d	()I
    //   4775: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4778: ldc_w 644
    //   4781: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4784: ldc_w 678
    //   4787: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4790: astore 24
    //   4792: aload_0
    //   4793: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4796: ifnull +2512 -> 7308
    //   4799: aload_0
    //   4800: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   4803: invokeinterface 687 1 0
    //   4808: astore 21
    //   4810: ldc_w 689
    //   4813: aload 24
    //   4815: aload 21
    //   4817: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4820: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4823: aload 23
    //   4825: invokestatic 504	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4828: getstatic 312	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:d	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4831: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   4834: aload_0
    //   4835: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4838: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   4841: if_icmpne +37 -> 4878
    //   4844: aload_0
    //   4845: getfield 334	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4848: ifnull +30 -> 4878
    //   4851: aload_0
    //   4852: getfield 334	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4855: aload_0
    //   4856: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   4859: aload_0
    //   4860: getfield 691	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4863: invokestatic 694	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4866: aload_2
    //   4867: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4870: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4873: invokeinterface 697 4 0
    //   4878: getstatic 408	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4881: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   4884: aload_0
    //   4885: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4888: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   4891: if_icmpne +37 -> 4928
    //   4894: aload_0
    //   4895: getfield 394	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4898: ifnull +30 -> 4928
    //   4901: aload_0
    //   4902: getfield 394	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   4905: aload_0
    //   4906: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   4909: aload_0
    //   4910: getfield 691	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4913: invokestatic 694	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   4916: aload_2
    //   4917: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4920: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4923: invokeinterface 697 4 0
    //   4928: aload 26
    //   4930: invokestatic 521	java/lang/System:currentTimeMillis	()J
    //   4933: putfield 700	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   4936: aload 26
    //   4938: aload_0
    //   4939: getfield 702	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_Long	J
    //   4942: putfield 705	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   4945: aload 26
    //   4947: aload_0
    //   4948: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   4951: putfield 708	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   4954: aload 26
    //   4956: iload_3
    //   4957: putfield 709	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   4960: aload 26
    //   4962: aload 23
    //   4964: putfield 713	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   4967: aload 27
    //   4969: ifnonnull +2401 -> 7370
    //   4972: aconst_null
    //   4973: astore 21
    //   4975: aload 26
    //   4977: aload 21
    //   4979: putfield 716	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   4982: aload_0
    //   4983: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4986: ifnull +2394 -> 7380
    //   4989: aload_0
    //   4990: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4993: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4996: ifnull +2384 -> 7380
    //   4999: aload_0
    //   5000: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5003: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5006: getfield 717	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5009: astore 21
    //   5011: aload 26
    //   5013: aload 21
    //   5015: putfield 720	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   5018: aload 26
    //   5020: ldc_w 605
    //   5023: putfield 723	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   5026: aload 26
    //   5028: aload_2
    //   5029: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5032: getfield 661	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5035: putfield 724	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   5038: aload 26
    //   5040: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   5043: aload_0
    //   5044: getfield 43	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_g_of_type_Long	J
    //   5047: lsub
    //   5048: putfield 727	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5051: aload 26
    //   5053: aload_2
    //   5054: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5057: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   5060: putfield 730	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   5063: aload 26
    //   5065: aload 26
    //   5067: getfield 727	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5070: aload_2
    //   5071: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5074: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   5077: lsub
    //   5078: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   5081: aload 26
    //   5083: lload 8
    //   5085: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   5088: aload 26
    //   5090: aload_0
    //   5091: getfield 53	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Long	J
    //   5094: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   5097: aload 26
    //   5099: aload_0
    //   5100: getfield 61	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Long	J
    //   5103: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   5106: aload 26
    //   5108: aload_0
    //   5109: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_c_of_type_Long	J
    //   5112: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   5115: aload 26
    //   5117: lconst_0
    //   5118: putfield 748	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   5121: aload 26
    //   5123: aload_0
    //   5124: invokevirtual 676	com/tencent/component/network/downloader/impl/StrictDownloadTask:d	()I
    //   5127: putfield 751	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   5130: aload 26
    //   5132: aload_2
    //   5133: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5136: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5139: putfield 754	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   5142: aload 26
    //   5144: aload_0
    //   5145: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   5148: invokestatic 758	com/tencent/component/network/module/base/Config:b	(Ljava/lang/String;)Z
    //   5151: putfield 761	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   5154: aload 26
    //   5156: aload_0
    //   5157: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   5160: putfield 764	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   5163: aload 26
    //   5165: aload_2
    //   5166: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5169: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5172: putfield 766	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   5175: aload_2
    //   5176: aload 26
    //   5178: invokevirtual 770	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5181: aload_0
    //   5182: aload_1
    //   5183: aload_2
    //   5184: aload 26
    //   5186: invokevirtual 462	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5189: aload_0
    //   5190: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   5193: ifeq +2193 -> 7386
    //   5196: aload_0
    //   5197: getfield 773	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   5200: ifnull +10 -> 5210
    //   5203: aload_0
    //   5204: getfield 773	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   5207: invokevirtual 778	com/squareup/okhttp/Call:cancel	()V
    //   5210: aload_0
    //   5211: aconst_null
    //   5212: putfield 530	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   5215: aload 22
    //   5217: athrow
    //   5218: lload 8
    //   5220: lstore 10
    //   5222: aload 23
    //   5224: astore 21
    //   5226: lload 8
    //   5228: lstore 12
    //   5230: aload 24
    //   5232: astore 22
    //   5234: aload_0
    //   5235: getfield 530	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   5238: ifnull -2644 -> 2594
    //   5241: lload 8
    //   5243: lstore 10
    //   5245: lload 8
    //   5247: lstore 12
    //   5249: aload 24
    //   5251: astore 22
    //   5253: aload_0
    //   5254: aload_0
    //   5255: getfield 873	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseQZoneHttp2Client	Lcom/tencent/component/network/utils/http/base/QZoneHttp2Client;
    //   5258: aload_0
    //   5259: getfield 530	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   5262: invokevirtual 144	com/squareup/okhttp/Request$Builder:build	()Lcom/squareup/okhttp/Request;
    //   5265: aload 27
    //   5267: invokevirtual 878	com/tencent/component/network/utils/http/base/QZoneHttp2Client:a	(Lcom/squareup/okhttp/Request;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lcom/squareup/okhttp/Call;
    //   5270: putfield 773	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   5273: lload 8
    //   5275: lstore 10
    //   5277: lload 8
    //   5279: lstore 12
    //   5281: aload 24
    //   5283: astore 22
    //   5285: aload_0
    //   5286: aload_0
    //   5287: getfield 773	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   5290: invokevirtual 881	com/squareup/okhttp/Call:execute	()Lcom/squareup/okhttp/Response;
    //   5293: putfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   5296: aload 23
    //   5298: astore 21
    //   5300: goto -2706 -> 2594
    //   5303: lload 8
    //   5305: lstore 12
    //   5307: aload 21
    //   5309: astore 22
    //   5311: aload_0
    //   5312: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   5315: ifnull +4371 -> 9686
    //   5318: lload 8
    //   5320: lstore 12
    //   5322: aload 21
    //   5324: astore 22
    //   5326: aload_0
    //   5327: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   5330: invokevirtual 179	com/squareup/okhttp/Response:code	()I
    //   5333: istore_3
    //   5334: goto -2652 -> 2682
    //   5337: aload_0
    //   5338: aload_0
    //   5339: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   5342: aload_0
    //   5343: getfield 530	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   5346: aload_0
    //   5347: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   5350: aload_0
    //   5351: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   5354: invokespecial 883	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(Lorg/apache/http/HttpRequest;Lcom/squareup/okhttp/Request$Builder;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)V
    //   5357: aload_0
    //   5358: aload_0
    //   5359: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   5362: aload_0
    //   5363: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   5366: invokevirtual 886	com/tencent/component/network/downloader/impl/StrictDownloadTask:c	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)I
    //   5369: ifne +8 -> 5377
    //   5372: aload_0
    //   5373: iconst_0
    //   5374: invokevirtual 887	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(I)V
    //   5377: sipush 404
    //   5380: iload_3
    //   5381: if_icmpne +46 -> 5427
    //   5384: aload_0
    //   5385: aload_0
    //   5386: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   5389: aload_0
    //   5390: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   5393: invokevirtual 889	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)I
    //   5396: istore 5
    //   5398: iload 5
    //   5400: sipush -6101
    //   5403: if_icmpeq +19 -> 5422
    //   5406: iload 5
    //   5408: sipush -5062
    //   5411: if_icmpeq +11 -> 5422
    //   5414: iload 5
    //   5416: sipush -5023
    //   5419: if_icmpne +8 -> 5427
    //   5422: aload_0
    //   5423: iconst_0
    //   5424: invokevirtual 887	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(I)V
    //   5427: aload_2
    //   5428: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5431: iconst_3
    //   5432: invokevirtual 481	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   5435: iload_3
    //   5436: istore 5
    //   5438: aload_0
    //   5439: getfield 575	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5442: ifnull +20 -> 5462
    //   5445: aload_0
    //   5446: getfield 575	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5449: aload_0
    //   5450: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   5453: iconst_1
    //   5454: invokeinterface 892 3 0
    //   5459: iload_3
    //   5460: istore 5
    //   5462: iload 4
    //   5464: iconst_1
    //   5465: iadd
    //   5466: istore 4
    //   5468: aload_2
    //   5469: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5472: lload 16
    //   5474: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   5477: invokevirtual 546	com/tencent/component/network/downloader/DownloadResult$Process:a	(JJ)V
    //   5480: aload_0
    //   5481: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   5484: invokestatic 551	com/tencent/component/network/module/common/NetworkStatus:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   5487: invokevirtual 554	com/tencent/component/network/module/common/NetworkStatus:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   5490: astore 25
    //   5492: aload_0
    //   5493: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5496: ifnull +3351 -> 8847
    //   5499: aload_0
    //   5500: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5503: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5506: ifnull +3341 -> 8847
    //   5509: aload_0
    //   5510: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5513: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5516: invokevirtual 558	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   5519: astore 23
    //   5521: aload_0
    //   5522: aload_0
    //   5523: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   5526: aload_0
    //   5527: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   5530: aload_0
    //   5531: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   5534: invokevirtual 561	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   5537: astore 27
    //   5539: aload 23
    //   5541: ifnull +3314 -> 8855
    //   5544: aload 23
    //   5546: astore 22
    //   5548: aload 21
    //   5550: ifnull +4104 -> 9654
    //   5553: aload 21
    //   5555: ldc_w 563
    //   5558: invokeinterface 569 2 0
    //   5563: checkcast 354	java/lang/String
    //   5566: astore 21
    //   5568: aload_2
    //   5569: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5572: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5575: ifne +64 -> 5639
    //   5578: aload_0
    //   5579: getfield 575	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5582: ifnull +28 -> 5610
    //   5585: aload_0
    //   5586: getfield 575	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5589: aload_0
    //   5590: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   5593: aload_2
    //   5594: invokevirtual 578	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   5597: aload_0
    //   5598: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   5601: aload_0
    //   5602: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   5605: invokeinterface 583 5 0
    //   5610: aload_0
    //   5611: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   5614: invokestatic 93	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   5617: ifne +22 -> 5639
    //   5620: aload_0
    //   5621: aload_0
    //   5622: getfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   5625: iconst_1
    //   5626: isub
    //   5627: putfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   5630: aload_2
    //   5631: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5634: bipush 6
    //   5636: invokevirtual 481	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   5639: aload_1
    //   5640: invokeinterface 459 1 0
    //   5645: ifne +983 -> 6628
    //   5648: aload_2
    //   5649: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5652: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5655: ifne +3218 -> 8873
    //   5658: new 64	java/lang/StringBuilder
    //   5661: dup
    //   5662: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   5665: ldc_w 585
    //   5668: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5671: aload_0
    //   5672: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   5675: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5678: ldc_w 587
    //   5681: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5684: astore 28
    //   5686: aload_0
    //   5687: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   5690: ifeq +3763 -> 9453
    //   5693: aload_0
    //   5694: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   5697: ifnull +3756 -> 9453
    //   5700: aload_0
    //   5701: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   5704: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   5707: ifnull +3746 -> 9453
    //   5710: aload_0
    //   5711: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   5714: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   5717: invokevirtual 594	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   5720: astore 24
    //   5722: aload 28
    //   5724: aload 24
    //   5726: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5729: ldc_w 596
    //   5732: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5735: aload 25
    //   5737: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5740: ldc_w 601
    //   5743: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5746: aload 23
    //   5748: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5751: ldc_w 603
    //   5754: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5757: ldc_w 605
    //   5760: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5763: ldc_w 607
    //   5766: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5769: invokestatic 288	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5772: invokevirtual 291	java/lang/Thread:getId	()J
    //   5775: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5778: ldc_w 609
    //   5781: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5784: invokestatic 278	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5787: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5790: ldc_w 611
    //   5793: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5796: aload_0
    //   5797: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   5800: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5803: ldc_w 613
    //   5806: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5809: aload_0
    //   5810: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   5813: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5816: ldc_w 615
    //   5819: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5822: astore 24
    //   5824: aload_0
    //   5825: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   5828: ifeq +3633 -> 9461
    //   5831: aload_0
    //   5832: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   5835: aload_0
    //   5836: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   5839: invokestatic 419	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   5842: astore 23
    //   5844: aload 24
    //   5846: aload 23
    //   5848: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5851: ldc_w 617
    //   5854: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5857: aload_0
    //   5858: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   5861: invokestatic 93	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   5864: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5867: ldc_w 619
    //   5870: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5873: aload_2
    //   5874: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5877: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5880: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5883: ldc_w 621
    //   5886: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5889: aload_2
    //   5890: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5893: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   5896: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5899: ldc_w 625
    //   5902: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5905: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   5908: aload_0
    //   5909: getfield 43	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_g_of_type_Long	J
    //   5912: lsub
    //   5913: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5916: ldc_w 627
    //   5919: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5922: aload_2
    //   5923: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5926: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5929: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5932: ldc_w 632
    //   5935: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5938: aload_2
    //   5939: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5942: getfield 634	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5945: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5948: ldc_w 636
    //   5951: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5954: aload_2
    //   5955: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5958: getfield 639	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5961: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5964: ldc_w 641
    //   5967: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5970: aload_0
    //   5971: getfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   5974: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5977: ldc 75
    //   5979: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5982: aload_0
    //   5983: getfield 642	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_Int	I
    //   5986: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5989: ldc_w 644
    //   5992: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5995: ldc_w 646
    //   5998: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6001: iload 4
    //   6003: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6006: ldc_w 644
    //   6009: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6012: ldc_w 648
    //   6015: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6018: aload_2
    //   6019: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6022: invokevirtual 484	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   6025: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6028: ldc_w 650
    //   6031: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6034: iload 5
    //   6036: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6039: ldc_w 652
    //   6042: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6045: aload 27
    //   6047: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6050: ldc_w 654
    //   6053: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6056: aload 21
    //   6058: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6061: ldc_w 656
    //   6064: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6067: astore 21
    //   6069: aload_0
    //   6070: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6073: ifnull +3394 -> 9467
    //   6076: aload_0
    //   6077: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6080: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   6083: istore_3
    //   6084: aload 21
    //   6086: iload_3
    //   6087: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6090: ldc_w 658
    //   6093: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6096: aload_2
    //   6097: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6100: getfield 661	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6103: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6106: ldc_w 663
    //   6109: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6112: lload 8
    //   6114: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6117: ldc_w 665
    //   6120: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6123: aload_0
    //   6124: getfield 53	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Long	J
    //   6127: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6130: ldc 75
    //   6132: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6135: aload_0
    //   6136: getfield 55	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Int	I
    //   6139: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6142: ldc_w 644
    //   6145: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6148: ldc_w 667
    //   6151: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6154: aload_0
    //   6155: getfield 57	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Long	J
    //   6158: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6161: ldc 75
    //   6163: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6166: aload_0
    //   6167: getfield 59	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Int	I
    //   6170: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6173: ldc_w 644
    //   6176: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6179: ldc_w 669
    //   6182: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6185: aload_0
    //   6186: getfield 61	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Long	J
    //   6189: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6192: ldc_w 671
    //   6195: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6198: aload_0
    //   6199: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_c_of_type_Long	J
    //   6202: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6205: ldc_w 674
    //   6208: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6211: aload_0
    //   6212: invokevirtual 676	com/tencent/component/network/downloader/impl/StrictDownloadTask:d	()I
    //   6215: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6218: ldc_w 644
    //   6221: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6224: ldc_w 678
    //   6227: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6230: astore 23
    //   6232: aload_0
    //   6233: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6236: ifnull +3236 -> 9472
    //   6239: aload_0
    //   6240: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6243: invokeinterface 687 1 0
    //   6248: astore 21
    //   6250: ldc_w 689
    //   6253: aload 23
    //   6255: aload 21
    //   6257: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6260: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6263: aconst_null
    //   6264: invokestatic 504	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6267: getstatic 312	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:d	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6270: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   6273: aload_0
    //   6274: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6277: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   6280: if_icmpne +37 -> 6317
    //   6283: aload_0
    //   6284: getfield 334	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6287: ifnull +30 -> 6317
    //   6290: aload_0
    //   6291: getfield 334	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6294: aload_0
    //   6295: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   6298: aload_0
    //   6299: getfield 691	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6302: invokestatic 694	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   6305: aload_2
    //   6306: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6309: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6312: invokeinterface 697 4 0
    //   6317: getstatic 408	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6320: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   6323: aload_0
    //   6324: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6327: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   6330: if_icmpne +37 -> 6367
    //   6333: aload_0
    //   6334: getfield 394	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6337: ifnull +30 -> 6367
    //   6340: aload_0
    //   6341: getfield 394	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   6344: aload_0
    //   6345: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   6348: aload_0
    //   6349: getfield 691	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6352: invokestatic 694	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   6355: aload_2
    //   6356: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6359: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6362: invokeinterface 697 4 0
    //   6367: aload 26
    //   6369: invokestatic 521	java/lang/System:currentTimeMillis	()J
    //   6372: putfield 700	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   6375: aload 26
    //   6377: aload_0
    //   6378: getfield 702	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_Long	J
    //   6381: putfield 705	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   6384: aload 26
    //   6386: aload_0
    //   6387: getfield 51	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpHttpResponse	Lorg/apache/http/HttpResponse;
    //   6390: putfield 708	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   6393: aload 26
    //   6395: iload 5
    //   6397: putfield 709	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   6400: aload 26
    //   6402: aconst_null
    //   6403: putfield 713	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   6406: aload 25
    //   6408: ifnonnull +3125 -> 9533
    //   6411: aconst_null
    //   6412: astore 21
    //   6414: aload 26
    //   6416: aload 21
    //   6418: putfield 716	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   6421: aload_0
    //   6422: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6425: ifnull +3118 -> 9543
    //   6428: aload_0
    //   6429: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6432: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6435: ifnull +3108 -> 9543
    //   6438: aload_0
    //   6439: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6442: invokevirtual 557	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6445: getfield 717	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6448: astore 21
    //   6450: aload 26
    //   6452: aload 21
    //   6454: putfield 720	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   6457: aload 26
    //   6459: ldc_w 605
    //   6462: putfield 723	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   6465: aload 26
    //   6467: aload_2
    //   6468: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6471: getfield 661	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6474: putfield 724	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   6477: aload 26
    //   6479: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   6482: aload_0
    //   6483: getfield 43	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_g_of_type_Long	J
    //   6486: lsub
    //   6487: putfield 727	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6490: aload 26
    //   6492: aload_2
    //   6493: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6496: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   6499: putfield 730	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   6502: aload 26
    //   6504: aload 26
    //   6506: getfield 727	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   6509: aload_2
    //   6510: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6513: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   6516: lsub
    //   6517: putfield 733	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   6520: aload 26
    //   6522: lload 8
    //   6524: putfield 736	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   6527: aload 26
    //   6529: aload_0
    //   6530: getfield 53	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Long	J
    //   6533: putfield 739	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   6536: aload 26
    //   6538: aload_0
    //   6539: getfield 61	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Long	J
    //   6542: putfield 742	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   6545: aload 26
    //   6547: aload_0
    //   6548: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_c_of_type_Long	J
    //   6551: putfield 745	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   6554: aload 26
    //   6556: lconst_0
    //   6557: putfield 748	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   6560: aload 26
    //   6562: aload_0
    //   6563: invokevirtual 676	com/tencent/component/network/downloader/impl/StrictDownloadTask:d	()I
    //   6566: putfield 751	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   6569: aload 26
    //   6571: aload_2
    //   6572: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6575: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6578: putfield 754	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   6581: aload 26
    //   6583: aload_0
    //   6584: invokevirtual 209	com/tencent/component/network/downloader/impl/StrictDownloadTask:b	()Ljava/lang/String;
    //   6587: invokestatic 758	com/tencent/component/network/module/base/Config:b	(Ljava/lang/String;)Z
    //   6590: putfield 761	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   6593: aload 26
    //   6595: aload_0
    //   6596: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   6599: putfield 764	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   6602: aload 26
    //   6604: aload_2
    //   6605: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6608: invokevirtual 572	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6611: putfield 766	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   6614: aload_2
    //   6615: aload 26
    //   6617: invokevirtual 770	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6620: aload_0
    //   6621: aload_1
    //   6622: aload_2
    //   6623: aload 26
    //   6625: invokevirtual 462	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   6628: aload_0
    //   6629: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   6632: ifeq +2917 -> 9549
    //   6635: aload_0
    //   6636: getfield 773	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   6639: ifnull +10 -> 6649
    //   6642: aload_0
    //   6643: getfield 773	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   6646: invokevirtual 778	com/squareup/okhttp/Call:cancel	()V
    //   6649: aload_0
    //   6650: aconst_null
    //   6651: putfield 530	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   6654: iload 4
    //   6656: istore_3
    //   6657: aload 22
    //   6659: astore 21
    //   6661: goto -6385 -> 276
    //   6664: lload 8
    //   6666: lstore 12
    //   6668: aload 21
    //   6670: astore 22
    //   6672: aload_2
    //   6673: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6676: iconst_3
    //   6677: invokevirtual 481	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   6680: iconst_0
    //   6681: istore 5
    //   6683: goto -1221 -> 5462
    //   6686: ldc_w 605
    //   6689: astore 24
    //   6691: goto -2607 -> 4084
    //   6694: goto -2587 -> 4107
    //   6697: astore 21
    //   6699: ldc_w 449
    //   6702: astore 21
    //   6704: goto -2577 -> 4127
    //   6707: new 64	java/lang/StringBuilder
    //   6710: dup
    //   6711: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   6714: ldc_w 894
    //   6717: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6720: aload_0
    //   6721: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   6724: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6727: ldc_w 587
    //   6730: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6733: astore 29
    //   6735: aload_0
    //   6736: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   6739: ifeq +575 -> 7314
    //   6742: aload_0
    //   6743: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   6746: ifnull +568 -> 7314
    //   6749: aload_0
    //   6750: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   6753: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   6756: ifnull +558 -> 7314
    //   6759: aload_0
    //   6760: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   6763: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   6766: invokevirtual 594	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   6769: astore 25
    //   6771: aload 29
    //   6773: aload 25
    //   6775: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6778: ldc_w 596
    //   6781: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6784: aload 27
    //   6786: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6789: ldc_w 601
    //   6792: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6795: aload 24
    //   6797: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6800: ldc_w 603
    //   6803: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6806: ldc_w 605
    //   6809: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6812: ldc_w 607
    //   6815: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6818: invokestatic 288	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6821: invokevirtual 291	java/lang/Thread:getId	()J
    //   6824: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6827: ldc_w 609
    //   6830: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6833: invokestatic 278	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   6836: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6839: ldc_w 611
    //   6842: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6845: aload_0
    //   6846: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   6849: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6852: ldc_w 613
    //   6855: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6858: aload_0
    //   6859: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   6862: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6865: ldc_w 615
    //   6868: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6871: astore 25
    //   6873: aload_0
    //   6874: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   6877: ifeq +445 -> 7322
    //   6880: aload_0
    //   6881: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   6884: aload_0
    //   6885: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   6888: invokestatic 419	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   6891: astore 24
    //   6893: aload 25
    //   6895: aload 24
    //   6897: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6900: ldc_w 621
    //   6903: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6906: aload_2
    //   6907: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6910: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   6913: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6916: ldc_w 625
    //   6919: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6922: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   6925: aload_0
    //   6926: getfield 43	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_g_of_type_Long	J
    //   6929: lsub
    //   6930: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6933: ldc_w 627
    //   6936: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6939: aload_2
    //   6940: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6943: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   6946: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6949: ldc_w 632
    //   6952: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6955: aload_2
    //   6956: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6959: getfield 634	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6962: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6965: ldc_w 636
    //   6968: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6971: aload_2
    //   6972: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6975: getfield 639	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   6978: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6981: ldc_w 641
    //   6984: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6987: aload_0
    //   6988: getfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   6991: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6994: ldc 75
    //   6996: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6999: aload_0
    //   7000: getfield 642	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_Int	I
    //   7003: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7006: ldc_w 644
    //   7009: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7012: ldc_w 646
    //   7015: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7018: iload 4
    //   7020: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7023: ldc_w 644
    //   7026: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7029: ldc_w 650
    //   7032: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7035: iload_3
    //   7036: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7039: ldc_w 619
    //   7042: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7045: aload_2
    //   7046: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7049: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7052: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7055: ldc_w 652
    //   7058: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7061: aload 28
    //   7063: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7066: ldc_w 654
    //   7069: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7072: aload 21
    //   7074: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7077: ldc_w 656
    //   7080: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7083: astore 21
    //   7085: aload_0
    //   7086: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7089: ifnull +239 -> 7328
    //   7092: aload_0
    //   7093: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7096: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   7099: istore 4
    //   7101: aload 21
    //   7103: iload 4
    //   7105: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7108: ldc_w 658
    //   7111: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7114: aload_2
    //   7115: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7118: getfield 661	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7121: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7124: ldc_w 663
    //   7127: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7130: lload 8
    //   7132: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7135: ldc_w 665
    //   7138: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7141: aload_0
    //   7142: getfield 53	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Long	J
    //   7145: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7148: ldc 75
    //   7150: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7153: aload_0
    //   7154: getfield 55	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Int	I
    //   7157: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7160: ldc_w 644
    //   7163: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7166: ldc_w 667
    //   7169: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7172: aload_0
    //   7173: getfield 57	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Long	J
    //   7176: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7179: ldc 75
    //   7181: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7184: aload_0
    //   7185: getfield 59	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Int	I
    //   7188: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7191: ldc_w 644
    //   7194: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7197: ldc_w 669
    //   7200: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7203: aload_0
    //   7204: getfield 61	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Long	J
    //   7207: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7210: ldc_w 671
    //   7213: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7216: aload_0
    //   7217: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_c_of_type_Long	J
    //   7220: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7223: ldc_w 674
    //   7226: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7229: aload_0
    //   7230: invokevirtual 676	com/tencent/component/network/downloader/impl/StrictDownloadTask:d	()I
    //   7233: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7236: ldc_w 644
    //   7239: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7242: ldc_w 678
    //   7245: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7248: astore 24
    //   7250: aload_0
    //   7251: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7254: ifnull +80 -> 7334
    //   7257: aload_0
    //   7258: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7261: invokeinterface 687 1 0
    //   7266: astore 21
    //   7268: ldc_w 689
    //   7271: aload 24
    //   7273: aload 21
    //   7275: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7278: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7281: aconst_null
    //   7282: invokestatic 896	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7285: goto -2457 -> 4828
    //   7288: ldc_w 898
    //   7291: astore 25
    //   7293: goto -3012 -> 4281
    //   7296: aconst_null
    //   7297: astore 24
    //   7299: goto -2896 -> 4403
    //   7302: iconst_0
    //   7303: istore 4
    //   7305: goto -2662 -> 4643
    //   7308: aconst_null
    //   7309: astore 21
    //   7311: goto -2501 -> 4810
    //   7314: ldc_w 898
    //   7317: astore 25
    //   7319: goto -548 -> 6771
    //   7322: aconst_null
    //   7323: astore 24
    //   7325: goto -432 -> 6893
    //   7328: iconst_0
    //   7329: istore 4
    //   7331: goto -230 -> 7101
    //   7334: aconst_null
    //   7335: astore 21
    //   7337: goto -69 -> 7268
    //   7340: astore 21
    //   7342: ldc 187
    //   7344: ldc_w 900
    //   7347: aload 21
    //   7349: invokestatic 896	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7352: goto -2474 -> 4878
    //   7355: astore 21
    //   7357: ldc 187
    //   7359: ldc_w 902
    //   7362: aload 21
    //   7364: invokestatic 896	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   7367: goto -2439 -> 4928
    //   7370: aload 27
    //   7372: invokevirtual 905	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   7375: astore 21
    //   7377: goto -2402 -> 4975
    //   7380: aconst_null
    //   7381: astore 21
    //   7383: goto -2372 -> 5011
    //   7386: aload_0
    //   7387: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   7390: ifnull -2175 -> 5215
    //   7393: aload_0
    //   7394: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   7397: invokevirtual 910	org/apache/http/client/methods/HttpGet:abort	()V
    //   7400: goto -2185 -> 5215
    //   7403: ldc_w 605
    //   7406: astore 24
    //   7408: goto -7017 -> 391
    //   7411: ldc_w 912
    //   7414: astore 23
    //   7416: goto -6998 -> 418
    //   7419: astore 22
    //   7421: ldc_w 449
    //   7424: astore 22
    //   7426: goto -6988 -> 438
    //   7429: new 64	java/lang/StringBuilder
    //   7432: dup
    //   7433: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   7436: ldc_w 894
    //   7439: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7442: aload_0
    //   7443: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   7446: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7449: ldc_w 587
    //   7452: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7455: astore 29
    //   7457: aload_0
    //   7458: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   7461: ifeq +575 -> 8036
    //   7464: aload_0
    //   7465: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   7468: ifnull +568 -> 8036
    //   7471: aload_0
    //   7472: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   7475: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   7478: ifnull +558 -> 8036
    //   7481: aload_0
    //   7482: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   7485: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   7488: invokevirtual 594	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   7491: astore 25
    //   7493: aload 29
    //   7495: aload 25
    //   7497: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7500: ldc_w 596
    //   7503: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7506: aload 27
    //   7508: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7511: ldc_w 601
    //   7514: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7517: aload 24
    //   7519: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7522: ldc_w 603
    //   7525: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7528: ldc_w 605
    //   7531: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7534: ldc_w 607
    //   7537: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7540: invokestatic 288	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7543: invokevirtual 291	java/lang/Thread:getId	()J
    //   7546: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7549: ldc_w 609
    //   7552: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7555: invokestatic 278	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7558: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7561: ldc_w 611
    //   7564: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7567: aload_0
    //   7568: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   7571: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7574: ldc_w 613
    //   7577: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7580: aload_0
    //   7581: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   7584: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7587: ldc_w 615
    //   7590: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7593: astore 25
    //   7595: aload_0
    //   7596: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   7599: ifeq +445 -> 8044
    //   7602: aload_0
    //   7603: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   7606: aload_0
    //   7607: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   7610: invokestatic 419	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   7613: astore 24
    //   7615: aload 25
    //   7617: aload 24
    //   7619: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7622: ldc_w 621
    //   7625: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7628: aload_2
    //   7629: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7632: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   7635: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7638: ldc_w 625
    //   7641: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7644: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   7647: aload_0
    //   7648: getfield 43	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_g_of_type_Long	J
    //   7651: lsub
    //   7652: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7655: ldc_w 627
    //   7658: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7661: aload_2
    //   7662: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7665: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7668: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7671: ldc_w 632
    //   7674: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7677: aload_2
    //   7678: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7681: getfield 634	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7684: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7687: ldc_w 636
    //   7690: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7693: aload_2
    //   7694: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7697: getfield 639	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   7700: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7703: ldc_w 641
    //   7706: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7709: aload_0
    //   7710: getfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   7713: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7716: ldc 75
    //   7718: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7721: aload_0
    //   7722: getfield 642	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_Int	I
    //   7725: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7728: ldc_w 644
    //   7731: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7734: ldc_w 646
    //   7737: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7740: iload 5
    //   7742: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7745: ldc_w 644
    //   7748: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7751: ldc_w 650
    //   7754: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7757: iload_3
    //   7758: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7761: ldc_w 619
    //   7764: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7767: aload_2
    //   7768: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7771: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7774: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7777: ldc_w 652
    //   7780: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7783: aload 28
    //   7785: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7788: ldc_w 654
    //   7791: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7794: aload 22
    //   7796: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7799: ldc_w 656
    //   7802: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7805: astore 22
    //   7807: aload_0
    //   7808: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7811: ifnull +239 -> 8050
    //   7814: aload_0
    //   7815: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7818: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   7821: istore 4
    //   7823: aload 22
    //   7825: iload 4
    //   7827: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7830: ldc_w 658
    //   7833: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7836: aload_2
    //   7837: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7840: getfield 661	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7843: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7846: ldc_w 663
    //   7849: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7852: lload 8
    //   7854: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7857: ldc_w 665
    //   7860: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7863: aload_0
    //   7864: getfield 53	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Long	J
    //   7867: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7870: ldc 75
    //   7872: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7875: aload_0
    //   7876: getfield 55	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Int	I
    //   7879: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7882: ldc_w 644
    //   7885: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7888: ldc_w 667
    //   7891: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7894: aload_0
    //   7895: getfield 57	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Long	J
    //   7898: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7901: ldc 75
    //   7903: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7906: aload_0
    //   7907: getfield 59	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Int	I
    //   7910: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7913: ldc_w 644
    //   7916: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7919: ldc_w 669
    //   7922: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7925: aload_0
    //   7926: getfield 61	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Long	J
    //   7929: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7932: ldc_w 671
    //   7935: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7938: aload_0
    //   7939: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_c_of_type_Long	J
    //   7942: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7945: ldc_w 674
    //   7948: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7951: aload_0
    //   7952: invokevirtual 676	com/tencent/component/network/downloader/impl/StrictDownloadTask:d	()I
    //   7955: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7958: ldc_w 644
    //   7961: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7964: ldc_w 678
    //   7967: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7970: astore 24
    //   7972: aload_0
    //   7973: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7976: ifnull +80 -> 8056
    //   7979: aload_0
    //   7980: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   7983: invokeinterface 687 1 0
    //   7988: astore 22
    //   7990: ldc_w 689
    //   7993: aload 24
    //   7995: aload 22
    //   7997: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8000: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8003: aconst_null
    //   8004: invokestatic 896	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8007: goto -6868 -> 1139
    //   8010: ldc_w 898
    //   8013: astore 25
    //   8015: goto -7423 -> 592
    //   8018: aconst_null
    //   8019: astore 24
    //   8021: goto -7307 -> 714
    //   8024: iconst_0
    //   8025: istore 4
    //   8027: goto -7073 -> 954
    //   8030: aconst_null
    //   8031: astore 22
    //   8033: goto -6912 -> 1121
    //   8036: ldc_w 898
    //   8039: astore 25
    //   8041: goto -548 -> 7493
    //   8044: aconst_null
    //   8045: astore 24
    //   8047: goto -432 -> 7615
    //   8050: iconst_0
    //   8051: istore 4
    //   8053: goto -230 -> 7823
    //   8056: aconst_null
    //   8057: astore 22
    //   8059: goto -69 -> 7990
    //   8062: astore 22
    //   8064: ldc 187
    //   8066: ldc_w 900
    //   8069: aload 22
    //   8071: invokestatic 896	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8074: goto -6885 -> 1189
    //   8077: astore 22
    //   8079: ldc 187
    //   8081: ldc_w 902
    //   8084: aload 22
    //   8086: invokestatic 896	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8089: goto -6850 -> 1239
    //   8092: aload 27
    //   8094: invokevirtual 905	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   8097: astore 21
    //   8099: goto -6813 -> 1286
    //   8102: aconst_null
    //   8103: astore 21
    //   8105: goto -6783 -> 1322
    //   8108: aload_0
    //   8109: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   8112: ifnull -6586 -> 1526
    //   8115: aload_0
    //   8116: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   8119: invokevirtual 910	org/apache/http/client/methods/HttpGet:abort	()V
    //   8122: goto -6596 -> 1526
    //   8125: ldc_w 605
    //   8128: astore 23
    //   8130: goto -5339 -> 2791
    //   8133: ldc_w 912
    //   8136: astore 22
    //   8138: goto -5320 -> 2818
    //   8141: astore 21
    //   8143: ldc_w 449
    //   8146: astore 21
    //   8148: goto -5310 -> 2838
    //   8151: new 64	java/lang/StringBuilder
    //   8154: dup
    //   8155: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   8158: ldc_w 894
    //   8161: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8164: aload_0
    //   8165: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   8168: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8171: ldc_w 587
    //   8174: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8177: astore 28
    //   8179: aload_0
    //   8180: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   8183: ifeq +575 -> 8758
    //   8186: aload_0
    //   8187: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   8190: ifnull +568 -> 8758
    //   8193: aload_0
    //   8194: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   8197: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   8200: ifnull +558 -> 8758
    //   8203: aload_0
    //   8204: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   8207: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   8210: invokevirtual 594	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   8213: astore 24
    //   8215: aload 28
    //   8217: aload 24
    //   8219: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8222: ldc_w 596
    //   8225: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8228: aload 25
    //   8230: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8233: ldc_w 601
    //   8236: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8239: aload 23
    //   8241: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8244: ldc_w 603
    //   8247: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8250: ldc_w 605
    //   8253: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8256: ldc_w 607
    //   8259: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8262: invokestatic 288	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8265: invokevirtual 291	java/lang/Thread:getId	()J
    //   8268: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8271: ldc_w 609
    //   8274: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8277: invokestatic 278	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   8280: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8283: ldc_w 611
    //   8286: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8289: aload_0
    //   8290: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   8293: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8296: ldc_w 613
    //   8299: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8302: aload_0
    //   8303: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   8306: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8309: ldc_w 615
    //   8312: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8315: astore 24
    //   8317: aload_0
    //   8318: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   8321: ifeq +445 -> 8766
    //   8324: aload_0
    //   8325: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8328: aload_0
    //   8329: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   8332: invokestatic 419	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   8335: astore 23
    //   8337: aload 24
    //   8339: aload 23
    //   8341: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8344: ldc_w 621
    //   8347: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8350: aload_2
    //   8351: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8354: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   8357: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8360: ldc_w 625
    //   8363: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8366: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   8369: aload_0
    //   8370: getfield 43	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_g_of_type_Long	J
    //   8373: lsub
    //   8374: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8377: ldc_w 627
    //   8380: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8383: aload_2
    //   8384: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8387: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8390: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8393: ldc_w 632
    //   8396: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8399: aload_2
    //   8400: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8403: getfield 634	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8406: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8409: ldc_w 636
    //   8412: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8415: aload_2
    //   8416: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8419: getfield 639	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   8422: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8425: ldc_w 641
    //   8428: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8431: aload_0
    //   8432: getfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   8435: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8438: ldc 75
    //   8440: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8443: aload_0
    //   8444: getfield 642	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_Int	I
    //   8447: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8450: ldc_w 644
    //   8453: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8456: ldc_w 646
    //   8459: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8462: iload 5
    //   8464: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8467: ldc_w 644
    //   8470: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8473: ldc_w 650
    //   8476: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8479: iload_3
    //   8480: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8483: ldc_w 619
    //   8486: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8489: aload_2
    //   8490: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8493: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8496: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8499: ldc_w 652
    //   8502: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8505: aload 27
    //   8507: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8510: ldc_w 654
    //   8513: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8516: aload 21
    //   8518: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8521: ldc_w 656
    //   8524: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8527: astore 21
    //   8529: aload_0
    //   8530: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8533: ifnull +239 -> 8772
    //   8536: aload_0
    //   8537: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8540: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   8543: istore 4
    //   8545: aload 21
    //   8547: iload 4
    //   8549: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8552: ldc_w 658
    //   8555: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8558: aload_2
    //   8559: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8562: getfield 661	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8565: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8568: ldc_w 663
    //   8571: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8574: lload 8
    //   8576: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8579: ldc_w 665
    //   8582: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8585: aload_0
    //   8586: getfield 53	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Long	J
    //   8589: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8592: ldc 75
    //   8594: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8597: aload_0
    //   8598: getfield 55	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Int	I
    //   8601: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8604: ldc_w 644
    //   8607: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8610: ldc_w 667
    //   8613: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8616: aload_0
    //   8617: getfield 57	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Long	J
    //   8620: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8623: ldc 75
    //   8625: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8628: aload_0
    //   8629: getfield 59	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Int	I
    //   8632: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8635: ldc_w 644
    //   8638: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8641: ldc_w 669
    //   8644: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8647: aload_0
    //   8648: getfield 61	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Long	J
    //   8651: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8654: ldc_w 671
    //   8657: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8660: aload_0
    //   8661: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_c_of_type_Long	J
    //   8664: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8667: ldc_w 674
    //   8670: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8673: aload_0
    //   8674: invokevirtual 676	com/tencent/component/network/downloader/impl/StrictDownloadTask:d	()I
    //   8677: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8680: ldc_w 644
    //   8683: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8686: ldc_w 678
    //   8689: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8692: astore 23
    //   8694: aload_0
    //   8695: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8698: ifnull +80 -> 8778
    //   8701: aload_0
    //   8702: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8705: invokeinterface 687 1 0
    //   8710: astore 21
    //   8712: ldc_w 689
    //   8715: aload 23
    //   8717: aload 21
    //   8719: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8722: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8725: aconst_null
    //   8726: invokestatic 896	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8729: goto -5191 -> 3538
    //   8732: ldc_w 898
    //   8735: astore 24
    //   8737: goto -5745 -> 2992
    //   8740: aconst_null
    //   8741: astore 23
    //   8743: goto -5629 -> 3114
    //   8746: iconst_0
    //   8747: istore 4
    //   8749: goto -5395 -> 3354
    //   8752: aconst_null
    //   8753: astore 21
    //   8755: goto -5234 -> 3521
    //   8758: ldc_w 898
    //   8761: astore 24
    //   8763: goto -548 -> 8215
    //   8766: aconst_null
    //   8767: astore 23
    //   8769: goto -432 -> 8337
    //   8772: iconst_0
    //   8773: istore 4
    //   8775: goto -230 -> 8545
    //   8778: aconst_null
    //   8779: astore 21
    //   8781: goto -69 -> 8712
    //   8784: astore 21
    //   8786: ldc 187
    //   8788: ldc_w 900
    //   8791: aload 21
    //   8793: invokestatic 896	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8796: goto -5208 -> 3588
    //   8799: astore 21
    //   8801: ldc 187
    //   8803: ldc_w 902
    //   8806: aload 21
    //   8808: invokestatic 896	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8811: goto -5173 -> 3638
    //   8814: aload 25
    //   8816: invokevirtual 905	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   8819: astore 21
    //   8821: goto -5137 -> 3684
    //   8824: aconst_null
    //   8825: astore 21
    //   8827: goto -5107 -> 3720
    //   8830: aload_0
    //   8831: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   8834: ifnull -4910 -> 3924
    //   8837: aload_0
    //   8838: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   8841: invokevirtual 910	org/apache/http/client/methods/HttpGet:abort	()V
    //   8844: goto -4920 -> 3924
    //   8847: ldc_w 605
    //   8850: astore 23
    //   8852: goto -3331 -> 5521
    //   8855: ldc_w 912
    //   8858: astore 22
    //   8860: goto -3312 -> 5548
    //   8863: astore 21
    //   8865: ldc_w 449
    //   8868: astore 21
    //   8870: goto -3302 -> 5568
    //   8873: new 64	java/lang/StringBuilder
    //   8876: dup
    //   8877: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   8880: ldc_w 894
    //   8883: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8886: aload_0
    //   8887: invokevirtual 207	com/tencent/component/network/downloader/impl/StrictDownloadTask:a	()Ljava/lang/String;
    //   8890: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8893: ldc_w 587
    //   8896: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8899: astore 28
    //   8901: aload_0
    //   8902: getfield 211	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Boolean	Z
    //   8905: ifeq +573 -> 9478
    //   8908: aload_0
    //   8909: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   8912: ifnull +566 -> 9478
    //   8915: aload_0
    //   8916: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   8919: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   8922: ifnull +556 -> 9478
    //   8925: aload_0
    //   8926: getfield 49	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComSquareupOkhttpResponse	Lcom/squareup/okhttp/Response;
    //   8929: invokevirtual 591	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   8932: invokevirtual 594	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   8935: astore 24
    //   8937: aload 28
    //   8939: aload 24
    //   8941: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8944: ldc_w 596
    //   8947: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8950: aload 25
    //   8952: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8955: ldc_w 601
    //   8958: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8961: aload 23
    //   8963: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8966: ldc_w 603
    //   8969: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8972: ldc_w 605
    //   8975: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8978: ldc_w 607
    //   8981: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8984: invokestatic 288	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8987: invokevirtual 291	java/lang/Thread:getId	()J
    //   8990: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8993: ldc_w 609
    //   8996: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8999: invokestatic 278	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9002: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9005: ldc_w 611
    //   9008: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9011: aload_0
    //   9012: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   9015: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9018: ldc_w 613
    //   9021: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9024: aload_0
    //   9025: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   9028: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9031: ldc_w 615
    //   9034: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9037: astore 24
    //   9039: aload_0
    //   9040: getfield 300	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Boolean	Z
    //   9043: ifeq +443 -> 9486
    //   9046: aload_0
    //   9047: getfield 87	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9050: aload_0
    //   9051: getfield 303	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Boolean	Z
    //   9054: invokestatic 419	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   9057: astore 23
    //   9059: aload 24
    //   9061: aload 23
    //   9063: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9066: ldc_w 621
    //   9069: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9072: aload_2
    //   9073: invokevirtual 541	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9076: getfield 623	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   9079: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9082: ldc_w 625
    //   9085: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9088: invokestatic 41	android/os/SystemClock:uptimeMillis	()J
    //   9091: aload_0
    //   9092: getfield 43	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_g_of_type_Long	J
    //   9095: lsub
    //   9096: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9099: ldc_w 627
    //   9102: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9105: aload_2
    //   9106: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9109: getfield 630	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9112: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9115: ldc_w 632
    //   9118: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9121: aload_2
    //   9122: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9125: getfield 634	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9128: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9131: ldc_w 636
    //   9134: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9137: aload_2
    //   9138: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9141: getfield 639	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   9144: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9147: ldc_w 641
    //   9150: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9153: aload_0
    //   9154: getfield 253	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_Int	I
    //   9157: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9160: ldc 75
    //   9162: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9165: aload_0
    //   9166: getfield 642	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_Int	I
    //   9169: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9172: ldc_w 644
    //   9175: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9178: ldc_w 646
    //   9181: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9184: iload 4
    //   9186: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9189: ldc_w 644
    //   9192: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9195: ldc_w 650
    //   9198: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9201: iload 5
    //   9203: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9206: ldc_w 619
    //   9209: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9212: aload_2
    //   9213: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9216: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9219: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9222: ldc_w 652
    //   9225: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9228: aload 27
    //   9230: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9233: ldc_w 654
    //   9236: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9239: aload 21
    //   9241: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9244: ldc_w 656
    //   9247: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9250: astore 21
    //   9252: aload_0
    //   9253: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9256: ifnull +236 -> 9492
    //   9259: aload_0
    //   9260: getfield 231	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9263: getfield 248	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   9266: istore_3
    //   9267: aload 21
    //   9269: iload_3
    //   9270: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9273: ldc_w 658
    //   9276: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9279: aload_2
    //   9280: invokevirtual 491	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9283: getfield 661	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9286: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9289: ldc_w 663
    //   9292: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9295: lload 8
    //   9297: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9300: ldc_w 665
    //   9303: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9306: aload_0
    //   9307: getfield 53	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_d_of_type_Long	J
    //   9310: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9313: ldc 75
    //   9315: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9318: aload_0
    //   9319: getfield 55	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Int	I
    //   9322: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9325: ldc_w 644
    //   9328: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9331: ldc_w 667
    //   9334: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9337: aload_0
    //   9338: getfield 57	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_e_of_type_Long	J
    //   9341: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9344: ldc 75
    //   9346: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9349: aload_0
    //   9350: getfield 59	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Int	I
    //   9353: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9356: ldc_w 644
    //   9359: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9362: ldc_w 669
    //   9365: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9368: aload_0
    //   9369: getfield 61	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_f_of_type_Long	J
    //   9372: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9375: ldc_w 671
    //   9378: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9381: aload_0
    //   9382: getfield 672	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_c_of_type_Long	J
    //   9385: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9388: ldc_w 674
    //   9391: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9394: aload_0
    //   9395: invokevirtual 676	com/tencent/component/network/downloader/impl/StrictDownloadTask:d	()I
    //   9398: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9401: ldc_w 644
    //   9404: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9407: ldc_w 678
    //   9410: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9413: astore 23
    //   9415: aload_0
    //   9416: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9419: ifnull +78 -> 9497
    //   9422: aload_0
    //   9423: getfield 681	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9426: invokeinterface 687 1 0
    //   9431: astore 21
    //   9433: ldc_w 689
    //   9436: aload 23
    //   9438: aload 21
    //   9440: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9443: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9446: aconst_null
    //   9447: invokestatic 896	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9450: goto -3183 -> 6267
    //   9453: ldc_w 898
    //   9456: astore 24
    //   9458: goto -3736 -> 5722
    //   9461: aconst_null
    //   9462: astore 23
    //   9464: goto -3620 -> 5844
    //   9467: iconst_0
    //   9468: istore_3
    //   9469: goto -3385 -> 6084
    //   9472: aconst_null
    //   9473: astore 21
    //   9475: goto -3225 -> 6250
    //   9478: ldc_w 898
    //   9481: astore 24
    //   9483: goto -546 -> 8937
    //   9486: aconst_null
    //   9487: astore 23
    //   9489: goto -430 -> 9059
    //   9492: iconst_0
    //   9493: istore_3
    //   9494: goto -227 -> 9267
    //   9497: aconst_null
    //   9498: astore 21
    //   9500: goto -67 -> 9433
    //   9503: astore 21
    //   9505: ldc 187
    //   9507: ldc_w 900
    //   9510: aload 21
    //   9512: invokestatic 896	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9515: goto -3198 -> 6317
    //   9518: astore 21
    //   9520: ldc 187
    //   9522: ldc_w 902
    //   9525: aload 21
    //   9527: invokestatic 896	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9530: goto -3163 -> 6367
    //   9533: aload 25
    //   9535: invokevirtual 905	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   9538: astore 21
    //   9540: goto -3126 -> 6414
    //   9543: aconst_null
    //   9544: astore 21
    //   9546: goto -3096 -> 6450
    //   9549: aload_0
    //   9550: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   9553: ifnull -2899 -> 6654
    //   9556: aload_0
    //   9557: getfield 527	com/tencent/component/network/downloader/impl/StrictDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   9560: invokevirtual 910	org/apache/http/client/methods/HttpGet:abort	()V
    //   9563: goto -2909 -> 6654
    //   9566: astore 22
    //   9568: aconst_null
    //   9569: astore 23
    //   9571: iload 6
    //   9573: istore_3
    //   9574: goto -5549 -> 4025
    //   9577: astore 22
    //   9579: aconst_null
    //   9580: astore 23
    //   9582: goto -5557 -> 4025
    //   9585: astore 23
    //   9587: aload 22
    //   9589: astore 24
    //   9591: aload 23
    //   9593: astore 22
    //   9595: aload 21
    //   9597: astore 23
    //   9599: aload 24
    //   9601: astore 21
    //   9603: goto -5578 -> 4025
    //   9606: astore 23
    //   9608: iconst_0
    //   9609: istore_3
    //   9610: aload 21
    //   9612: astore 22
    //   9614: aload 23
    //   9616: astore 21
    //   9618: goto -9295 -> 323
    //   9621: astore 23
    //   9623: iconst_0
    //   9624: istore_3
    //   9625: aload 21
    //   9627: astore 22
    //   9629: aload 23
    //   9631: astore 21
    //   9633: goto -9310 -> 323
    //   9636: astore 23
    //   9638: aload 21
    //   9640: astore 22
    //   9642: aload 23
    //   9644: astore 21
    //   9646: goto -9323 -> 323
    //   9649: astore 21
    //   9651: goto -9359 -> 292
    //   9654: ldc_w 449
    //   9657: astore 21
    //   9659: goto -4091 -> 5568
    //   9662: ldc_w 449
    //   9665: astore 21
    //   9667: goto -6829 -> 2838
    //   9670: ldc_w 449
    //   9673: astore 22
    //   9675: goto -9237 -> 438
    //   9678: ldc_w 449
    //   9681: astore 21
    //   9683: goto -5556 -> 4127
    //   9686: iconst_0
    //   9687: istore_3
    //   9688: goto -7006 -> 2682
    //   9691: iload_3
    //   9692: istore 4
    //   9694: goto -9658 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	9697	0	this	StrictDownloadTask
    //   0	9697	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	9697	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   108	9584	3	i	int
    //   1	9692	4	j	int
    //   336	8866	5	k	int
    //   251	9321	6	m	int
    //   26	168	7	n	int
    //   29	9267	8	l1	long
    //   299	4977	10	l2	long
    //   303	6364	12	l3	long
    //   34	60	14	l4	long
    //   180	5293	16	l5	long
    //   256	2224	18	l6	long
    //   266	3	20	bool	boolean
    //   6	304	21	str1	String
    //   312	962	21	localThrowable1	java.lang.Throwable
    //   1284	5385	21	localObject1	Object
    //   6697	1	21	localException1	java.lang.Exception
    //   6702	634	21	localObject2	Object
    //   7340	8	21	localException2	java.lang.Exception
    //   7355	8	21	localException3	java.lang.Exception
    //   7375	729	21	str2	String
    //   8141	1	21	localException4	java.lang.Exception
    //   8146	634	21	localObject3	Object
    //   8784	8	21	localException5	java.lang.Exception
    //   8799	8	21	localException6	java.lang.Exception
    //   8819	7	21	str3	String
    //   8863	1	21	localException7	java.lang.Exception
    //   8868	631	21	localObject4	Object
    //   9503	8	21	localException8	java.lang.Exception
    //   9518	8	21	localException9	java.lang.Exception
    //   9538	107	21	localObject5	Object
    //   9649	1	21	localThrowable2	java.lang.Throwable
    //   9657	25	21	str4	String
    //   85	1	22	localException10	java.lang.Exception
    //   307	6364	22	localObject6	Object
    //   7419	1	22	localException11	java.lang.Exception
    //   7424	634	22	localObject7	Object
    //   8062	8	22	localException12	java.lang.Exception
    //   8077	8	22	localException13	java.lang.Exception
    //   8136	723	22	str5	String
    //   9566	1	22	localObject8	Object
    //   9577	11	22	localObject9	Object
    //   9593	81	22	localObject10	Object
    //   248	9333	23	localObject11	Object
    //   9585	7	23	localObject12	Object
    //   9597	1	23	localObject13	Object
    //   9606	9	23	localThrowable3	java.lang.Throwable
    //   9621	9	23	localThrowable4	java.lang.Throwable
    //   9636	7	23	localThrowable5	java.lang.Throwable
    //   245	3729	24	localObject14	Object
    //   4005	17	24	localObject15	Object
    //   4082	5518	24	localObject16	Object
    //   590	8944	25	localObject17	Object
    //   189	6435	26	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   360	8869	27	localObject18	Object
    //   407	8531	28	localObject19	Object
    //   554	6940	29	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   76	82	85	java/lang/Exception
    //   109	128	166	java/lang/Throwable
    //   128	165	166	java/lang/Throwable
    //   309	312	312	java/lang/Throwable
    //   1548	1559	312	java/lang/Throwable
    //   1571	1580	312	java/lang/Throwable
    //   1592	1601	312	java/lang/Throwable
    //   1613	1620	312	java/lang/Throwable
    //   1632	1643	312	java/lang/Throwable
    //   1655	1662	312	java/lang/Throwable
    //   1674	1681	312	java/lang/Throwable
    //   1693	1697	312	java/lang/Throwable
    //   1709	1721	312	java/lang/Throwable
    //   1733	1741	312	java/lang/Throwable
    //   1753	1766	312	java/lang/Throwable
    //   1778	1785	312	java/lang/Throwable
    //   1797	1804	312	java/lang/Throwable
    //   1816	1826	312	java/lang/Throwable
    //   1838	1854	312	java/lang/Throwable
    //   1866	1878	312	java/lang/Throwable
    //   1890	1896	312	java/lang/Throwable
    //   1908	1919	312	java/lang/Throwable
    //   1931	1936	312	java/lang/Throwable
    //   1952	1963	312	java/lang/Throwable
    //   1978	1985	312	java/lang/Throwable
    //   1997	2003	312	java/lang/Throwable
    //   2015	2043	312	java/lang/Throwable
    //   2059	2066	312	java/lang/Throwable
    //   2078	2095	312	java/lang/Throwable
    //   2111	2123	312	java/lang/Throwable
    //   2135	2141	312	java/lang/Throwable
    //   2153	2221	312	java/lang/Throwable
    //   2233	2240	312	java/lang/Throwable
    //   2252	2264	312	java/lang/Throwable
    //   2276	2288	312	java/lang/Throwable
    //   2300	2307	312	java/lang/Throwable
    //   2319	2342	312	java/lang/Throwable
    //   2354	2361	312	java/lang/Throwable
    //   2373	2398	312	java/lang/Throwable
    //   2410	2430	312	java/lang/Throwable
    //   2442	2464	312	java/lang/Throwable
    //   2476	2484	312	java/lang/Throwable
    //   2496	2503	312	java/lang/Throwable
    //   2515	2522	312	java/lang/Throwable
    //   2534	2541	312	java/lang/Throwable
    //   2553	2560	312	java/lang/Throwable
    //   2572	2577	312	java/lang/Throwable
    //   3951	3962	312	java/lang/Throwable
    //   3977	4002	312	java/lang/Throwable
    //   5234	5241	312	java/lang/Throwable
    //   5253	5273	312	java/lang/Throwable
    //   5285	5296	312	java/lang/Throwable
    //   309	312	4005	finally
    //   1548	1559	4005	finally
    //   1571	1580	4005	finally
    //   1592	1601	4005	finally
    //   1613	1620	4005	finally
    //   1632	1643	4005	finally
    //   1655	1662	4005	finally
    //   1674	1681	4005	finally
    //   1693	1697	4005	finally
    //   1709	1721	4005	finally
    //   1733	1741	4005	finally
    //   1753	1766	4005	finally
    //   1778	1785	4005	finally
    //   1797	1804	4005	finally
    //   1816	1826	4005	finally
    //   1838	1854	4005	finally
    //   1866	1878	4005	finally
    //   1890	1896	4005	finally
    //   1908	1919	4005	finally
    //   1931	1936	4005	finally
    //   1952	1963	4005	finally
    //   1978	1985	4005	finally
    //   1997	2003	4005	finally
    //   2015	2043	4005	finally
    //   2059	2066	4005	finally
    //   2078	2095	4005	finally
    //   2111	2123	4005	finally
    //   2135	2141	4005	finally
    //   2153	2221	4005	finally
    //   2233	2240	4005	finally
    //   2252	2264	4005	finally
    //   2276	2288	4005	finally
    //   2300	2307	4005	finally
    //   2319	2342	4005	finally
    //   2354	2361	4005	finally
    //   2373	2398	4005	finally
    //   2410	2430	4005	finally
    //   2442	2464	4005	finally
    //   2476	2484	4005	finally
    //   2496	2503	4005	finally
    //   2515	2522	4005	finally
    //   2534	2541	4005	finally
    //   2553	2560	4005	finally
    //   2572	2577	4005	finally
    //   2602	2614	4005	finally
    //   2622	2629	4005	finally
    //   2637	2644	4005	finally
    //   2652	2659	4005	finally
    //   2667	2682	4005	finally
    //   3951	3962	4005	finally
    //   3977	4002	4005	finally
    //   5234	5241	4005	finally
    //   5253	5273	4005	finally
    //   5285	5296	4005	finally
    //   5311	5318	4005	finally
    //   5326	5334	4005	finally
    //   6672	6680	4005	finally
    //   4112	4127	6697	java/lang/Exception
    //   4851	4878	7340	java/lang/Exception
    //   4901	4928	7355	java/lang/Exception
    //   423	438	7419	java/lang/Exception
    //   1162	1189	8062	java/lang/Exception
    //   1212	1239	8077	java/lang/Exception
    //   2823	2838	8141	java/lang/Exception
    //   3561	3588	8784	java/lang/Exception
    //   3611	3638	8799	java/lang/Exception
    //   5553	5568	8863	java/lang/Exception
    //   6290	6317	9503	java/lang/Exception
    //   6340	6367	9518	java/lang/Exception
    //   2577	2594	9566	finally
    //   2682	2690	9577	finally
    //   2707	2732	9577	finally
    //   5337	5377	9577	finally
    //   5384	5398	9577	finally
    //   5422	5427	9577	finally
    //   5427	5435	9577	finally
    //   5438	5459	9577	finally
    //   323	332	9585	finally
    //   2577	2594	9606	java/lang/Throwable
    //   2602	2614	9621	java/lang/Throwable
    //   2622	2629	9621	java/lang/Throwable
    //   2637	2644	9621	java/lang/Throwable
    //   2652	2659	9621	java/lang/Throwable
    //   2667	2682	9621	java/lang/Throwable
    //   5311	5318	9621	java/lang/Throwable
    //   5326	5334	9621	java/lang/Throwable
    //   6672	6680	9621	java/lang/Throwable
    //   2682	2690	9636	java/lang/Throwable
    //   2707	2732	9636	java/lang/Throwable
    //   5337	5377	9636	java/lang/Throwable
    //   5384	5398	9636	java/lang/Throwable
    //   5422	5427	9636	java/lang/Throwable
    //   5427	5435	9636	java/lang/Throwable
    //   5438	5459	9636	java/lang/Throwable
    //   258	268	9649	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.StrictDownloadTask
 * JD-Core Version:    0.7.0.1
 */