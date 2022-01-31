package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
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
import com.tencent.component.network.utils.http.HttpUtil;
import com.tencent.component.network.utils.http.base.QZoneHttp2Client;
import com.tencent.component.network.utils.http.base.QZoneHttpClient;
import java.net.Proxy;
import java.util.List;

public class FastDownloadTask
  extends DownloadTask
{
  private String jdField_a_of_type_JavaLangString;
  private Proxy jdField_a_of_type_JavaNetProxy;
  private String b;
  private String c;
  long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int = 0;
  long jdField_e_of_type_Long = 0L;
  private boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int = 0;
  long jdField_f_of_type_Long = 0L;
  private int jdField_g_of_type_Int = 0;
  private final long jdField_g_of_type_Long = SystemClock.uptimeMillis();
  
  public FastDownloadTask(Context paramContext, QZoneHttp2Client paramQZoneHttp2Client, QZoneHttpClient paramQZoneHttpClient, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramQZoneHttp2Client, paramQZoneHttpClient, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  private boolean a(int paramInt)
  {
    int j = 80;
    String str2 = b();
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib == null) {
      this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib = DownloadGlobalStrategy.a(this.jdField_a_of_type_AndroidContentContext).a(a(), b(), this.jdField_b_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo;
    if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a() != null) {}
    for (int i = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a().size();; i = 0)
    {
      if (i == 0) {}
      String str1;
      Object localObject;
      label686:
      label723:
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
              }
              i = j;
              if (this.jdField_b_of_type_Boolean) {
                i = 443;
              }
              this.jdField_c_of_type_Int = i;
              if (QDLog.b()) {
                QDLog.b("downloader_strategy", "downloader strategy: " + this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.toString() + " currAttempCount:" + paramInt + " attemptStrategyCount:" + this.jdField_d_of_type_Int + " ,best:" + this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.b() + " url:" + a() + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
              }
              this.jdField_d_of_type_Boolean = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Boolean;
              this.jdField_e_of_type_Boolean = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_b_of_type_Boolean;
              i = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a();
              paramInt = i;
              if (!Utils.isPortValid(i))
              {
                this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(this.jdField_c_of_type_Int);
                paramInt = this.jdField_c_of_type_Int;
              }
              if (DownloadGlobalStrategy.d.jdField_a_of_type_Int != this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int) {
                break label790;
              }
              i = paramInt;
              if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo == null) {
                break;
              }
              i = paramInt;
              if (DownloadGlobalStrategy.d.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int) {
                break;
              }
              if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy == null) || (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str2))) {
                break label686;
              }
              i = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str2, paramInt);
              if ((i != paramInt) && (Utils.isPortValid(i))) {
                break;
              }
            } while (!QDLog.b());
            QDLog.b("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
            return false;
            str1 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c();
            localObject = str1;
            if (this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy != null)
            {
              localObject = str1;
              if (!this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str2, str1))
              {
                this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c(null);
                localObject = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str2);
                if (TextUtils.isEmpty((CharSequence)localObject)) {
                  break label723;
                }
                this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c((String)localObject);
              }
            }
            if ((localObject != null) && (!((String)localObject).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a())) && (!((String)localObject).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.b()))) {
              break label760;
            }
          } while (!QDLog.b());
          QDLog.b("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
          return false;
        } while (!QDLog.b());
        QDLog.b("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
        return false;
      } while (!QDLog.b());
      QDLog.b("downloader", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
      return false;
      label760:
      this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
      this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject, i));
      for (;;)
      {
        return true;
        label790:
        if (DownloadGlobalStrategy.e.jdField_a_of_type_Int == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
        {
          i = paramInt;
          if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.e.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
            {
              if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy == null) || (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str2))) {
                break label1020;
              }
              i = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str2, paramInt);
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
          localObject = DnsService.a().a(str2);
          if ((localObject == null) || (((String)localObject).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c())) || (((String)localObject).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a())))
          {
            this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.b(null);
            if (!QDLog.b()) {
              break;
            }
            QDLog.b("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            return false;
            label1020:
            if (!QDLog.b()) {
              break;
            }
            QDLog.b("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
            return false;
          }
          this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.b((String)localObject);
          this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
          this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject, i));
          continue;
        }
        if (DownloadGlobalStrategy.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
        {
          i = paramInt;
          if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int)
            {
              if ((this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy == null) || (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str2))) {
                break label1387;
              }
              i = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(str2, paramInt);
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
        label1387:
        do
        {
          str1 = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a();
          localObject = str1;
          if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy != null)
          {
            localObject = str1;
            if (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str2, str1))
            {
              this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a(null);
              localObject = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy.a(str2);
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                break label1623;
              }
              this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.a((String)localObject);
            }
          }
          if ((localObject != null) && (!((String)localObject).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.c())) && (!((String)localObject).equals(this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyLib.b()))) {
            break label1661;
          }
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
          if (DownloadGlobalStrategy.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int) {
            break label1477;
          }
          i = paramInt;
        } while (DownloadGlobalStrategy.c.jdField_a_of_type_Int != this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int);
        label1477:
        localObject = this.jdField_a_of_type_AndroidContentContext;
        if (DownloadGlobalStrategy.c.jdField_a_of_type_Int == this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int) {}
        for (boolean bool = true;; bool = false)
        {
          localObject = NetworkUtils.getProxy((Context)localObject, bool);
          if (localObject != null) {
            break label1560;
          }
          if (!QDLog.b()) {
            break;
          }
          QDLog.b("downloader", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
          return false;
        }
        label1560:
        if (((Proxy)localObject).equals(this.jdField_a_of_type_JavaNetProxy))
        {
          if (!QDLog.b()) {
            break;
          }
          QDLog.b("downloader", "downloader strategy: proxy 重复. Pass! threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.jdField_a_of_type_JavaNetProxy = ((Proxy)localObject);
        paramInt = this.jdField_c_of_type_Int;
        return true;
        label1623:
        if (!QDLog.b()) {
          break;
        }
        QDLog.b("downloader", "downloader strategy: direct ip is null. Pass! threadId:" + Thread.currentThread().getId());
        return false;
        label1661:
        this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a();
        this.jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.a(new IPInfo((String)localObject, i));
      }
    }
  }
  
  protected void a()
  {
    super.a();
    this.jdField_b_of_type_JavaLangString = Utils.getDominWithPort(a());
    this.jdField_g_of_type_Int = Utils.getPort(a());
    this.jdField_c_of_type_JavaLangString = HttpUtil.a(a());
    if (!DownloadGlobalStrategy.a(this.jdField_a_of_type_AndroidContentContext).a())
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  /* Error */
  public void a(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 307	java/lang/Object
    //   4: dup
    //   5: iconst_0
    //   6: aload_0
    //   7: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   10: aastore
    //   11: dup
    //   12: iconst_1
    //   13: aload_2
    //   14: aastore
    //   15: invokestatic 312	pjp:a	([Ljava/lang/Object;)I
    //   18: istore 7
    //   20: lconst_0
    //   21: lstore 8
    //   23: iconst_0
    //   24: istore 4
    //   26: aload_1
    //   27: invokeinterface 317 1 0
    //   32: ifeq +11 -> 43
    //   35: aload_0
    //   36: aload_1
    //   37: aload_2
    //   38: aconst_null
    //   39: invokevirtual 320	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   42: return
    //   43: aload_0
    //   44: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   47: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   50: ifne +37 -> 87
    //   53: iload 4
    //   55: aload_0
    //   56: getfield 325	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_Int	I
    //   59: iconst_1
    //   60: isub
    //   61: if_icmpne +20 -> 81
    //   64: aload_2
    //   65: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   68: bipush 6
    //   70: invokevirtual 336	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   73: aload_0
    //   74: aload_1
    //   75: aload_2
    //   76: aconst_null
    //   77: invokevirtual 320	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   80: return
    //   81: ldc2_w 337
    //   84: invokestatic 342	java/lang/Thread:sleep	(J)V
    //   87: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   90: lstore 14
    //   92: new 344	com/tencent/component/network/downloader/DownloadReport
    //   95: dup
    //   96: invokespecial 345	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   99: astore 26
    //   101: aload 26
    //   103: iload 7
    //   105: putfield 348	com/tencent/component/network/downloader/DownloadReport:id	I
    //   108: aload 26
    //   110: aload_0
    //   111: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   114: putfield 351	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   117: aload 26
    //   119: aload_0
    //   120: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   123: putfield 354	com/tencent/component/network/downloader/DownloadReport:domain	Ljava/lang/String;
    //   126: aload 26
    //   128: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   131: putfield 362	com/tencent/component/network/downloader/DownloadReport:startTime	J
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   139: aconst_null
    //   140: astore 23
    //   142: aconst_null
    //   143: astore 21
    //   145: aload_0
    //   146: aconst_null
    //   147: putfield 368	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   150: aconst_null
    //   151: astore 22
    //   153: iconst_0
    //   154: istore 6
    //   156: aconst_null
    //   157: astore 19
    //   159: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   162: lstore 16
    //   164: aload_0
    //   165: aload_0
    //   166: invokevirtual 369	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()I
    //   169: invokespecial 371	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(I)Z
    //   172: istore 18
    //   174: iload 18
    //   176: ifne +34 -> 210
    //   179: iload 4
    //   181: istore_3
    //   182: aload_0
    //   183: invokevirtual 372	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Z
    //   186: ifeq -144 -> 42
    //   189: iload_3
    //   190: istore 4
    //   192: goto -166 -> 26
    //   195: astore 19
    //   197: ldc 186
    //   199: ldc_w 374
    //   202: invokestatic 376	com/tencent/component/network/module/base/QDLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: goto -118 -> 87
    //   208: astore 19
    //   210: aload 19
    //   212: ifnull +1543 -> 1755
    //   215: lload 8
    //   217: lstore 10
    //   219: lload 8
    //   221: lstore 12
    //   223: aload 19
    //   225: athrow
    //   226: astore 22
    //   228: iconst_0
    //   229: istore_3
    //   230: aconst_null
    //   231: astore 20
    //   233: aconst_null
    //   234: astore 19
    //   236: aconst_null
    //   237: astore 21
    //   239: lload 10
    //   241: lstore 8
    //   243: ldc 186
    //   245: ldc_w 378
    //   248: aload 22
    //   250: invokestatic 381	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   253: aload_2
    //   254: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   257: aload 22
    //   259: invokevirtual 384	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   262: iload 4
    //   264: iconst_1
    //   265: iadd
    //   266: istore 5
    //   268: aload_2
    //   269: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   272: lload 14
    //   274: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   277: invokevirtual 393	com/tencent/component/network/downloader/DownloadResult$Process:a	(JJ)V
    //   280: aload_0
    //   281: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   284: invokestatic 398	com/tencent/component/network/module/common/NetworkStatus:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   287: invokevirtual 401	com/tencent/component/network/module/common/NetworkStatus:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   290: astore 25
    //   292: aload_0
    //   293: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   296: ifnull +8005 -> 8301
    //   299: aload_0
    //   300: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   303: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   306: ifnull +7995 -> 8301
    //   309: aload_0
    //   310: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   313: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   316: getfield 406	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   319: astore 23
    //   321: aload_0
    //   322: aload_0
    //   323: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   326: aload 19
    //   328: aload 20
    //   330: invokevirtual 409	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   333: astore 27
    //   335: aload 21
    //   337: ifnull +15026 -> 15363
    //   340: aload 21
    //   342: ldc_w 411
    //   345: invokeinterface 417 2 0
    //   350: checkcast 217	java/lang/String
    //   353: astore 21
    //   355: aload_0
    //   356: lconst_0
    //   357: putfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   360: aload_0
    //   361: iconst_0
    //   362: putfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   365: aload_0
    //   366: lconst_0
    //   367: putfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   370: aload_0
    //   371: iconst_0
    //   372: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   375: aload_2
    //   376: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   379: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   382: ifeq +12 -> 394
    //   385: aload_1
    //   386: invokeinterface 317 1 0
    //   391: ifeq +31 -> 422
    //   394: aload_0
    //   395: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   398: ifnull +24 -> 422
    //   401: aload_0
    //   402: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   405: aload_0
    //   406: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   409: aload_2
    //   410: invokevirtual 426	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   413: aload 19
    //   415: aload 20
    //   417: invokeinterface 431 5 0
    //   422: aload_1
    //   423: invokeinterface 317 1 0
    //   428: ifne +1295 -> 1723
    //   431: aload_0
    //   432: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   435: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   438: istore 18
    //   440: aload_2
    //   441: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   444: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   447: ifne +7870 -> 8317
    //   450: new 102	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   457: ldc_w 433
    //   460: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload_0
    //   464: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   467: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc_w 435
    //   473: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_0
    //   477: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   480: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   483: ldc_w 440
    //   486: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: astore 28
    //   491: aload_0
    //   492: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   495: ifeq +8438 -> 8933
    //   498: aload 20
    //   500: ifnull +8433 -> 8933
    //   503: aload 20
    //   505: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   508: ifnull +8425 -> 8933
    //   511: aload 20
    //   513: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   516: invokevirtual 449	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   519: astore 24
    //   521: aload 28
    //   523: aload 24
    //   525: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: ldc_w 451
    //   531: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload 25
    //   536: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   539: ldc_w 456
    //   542: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: aload 23
    //   547: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: ldc_w 458
    //   553: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aconst_null
    //   557: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: ldc_w 460
    //   563: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: invokestatic 147	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   569: invokevirtual 150	java/lang/Thread:getId	()J
    //   572: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   575: ldc_w 462
    //   578: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: invokestatic 134	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   584: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: ldc_w 464
    //   590: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload_0
    //   594: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   597: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   600: ldc_w 466
    //   603: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload_0
    //   607: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   610: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   613: ldc_w 468
    //   616: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: astore 28
    //   621: aload_0
    //   622: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   625: ifeq +8316 -> 8941
    //   628: aload_0
    //   629: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   632: aload_0
    //   633: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   636: invokestatic 267	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   639: astore 24
    //   641: aload 28
    //   643: aload 24
    //   645: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   648: ldc_w 470
    //   651: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: iload 18
    //   656: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   659: ldc_w 472
    //   662: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload_2
    //   666: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   669: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   672: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: ldc_w 483
    //   678: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_2
    //   682: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   685: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   688: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   691: ldc_w 487
    //   694: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   700: aload_0
    //   701: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   704: lsub
    //   705: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   708: ldc_w 489
    //   711: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: aload_2
    //   715: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   718: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   721: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   724: ldc_w 494
    //   727: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: aload_2
    //   731: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   734: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   737: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   740: ldc_w 498
    //   743: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: aload_2
    //   747: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   750: getfield 501	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   753: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   756: ldc_w 503
    //   759: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: aload_0
    //   763: invokevirtual 369	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()I
    //   766: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   769: ldc_w 505
    //   772: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: aload_0
    //   776: invokevirtual 507	com/tencent/component/network/downloader/impl/FastDownloadTask:c	()I
    //   779: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   782: ldc_w 509
    //   785: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: ldc_w 511
    //   791: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: aload_2
    //   795: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   798: invokevirtual 514	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   801: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   804: ldc_w 516
    //   807: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: iload_3
    //   811: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   814: ldc_w 518
    //   817: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload 27
    //   822: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: ldc_w 520
    //   828: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: aload 21
    //   833: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: ldc_w 522
    //   839: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: astore 28
    //   844: aload_0
    //   845: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   848: ifnull +8099 -> 8947
    //   851: aload_0
    //   852: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   855: iconst_0
    //   856: bipush 30
    //   858: invokevirtual 527	java/lang/String:substring	(II)Ljava/lang/String;
    //   861: astore 24
    //   863: aload 28
    //   865: aload 24
    //   867: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: ldc_w 529
    //   873: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: astore 24
    //   878: aload_0
    //   879: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   882: ifnull +8074 -> 8956
    //   885: aload_0
    //   886: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   889: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   892: istore 4
    //   894: aload 24
    //   896: iload 4
    //   898: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   901: ldc_w 531
    //   904: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: aload_2
    //   908: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   911: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   914: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: ldc_w 536
    //   920: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: lload 8
    //   925: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   928: ldc_w 538
    //   931: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: aload_0
    //   935: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   938: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   941: ldc_w 505
    //   944: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: aload_0
    //   948: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   951: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   954: ldc_w 509
    //   957: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: ldc_w 540
    //   963: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: aload_0
    //   967: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   970: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   973: ldc_w 505
    //   976: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: aload_0
    //   980: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   983: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   986: ldc_w 509
    //   989: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: ldc_w 542
    //   995: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: aload_0
    //   999: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   1002: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1005: ldc_w 544
    //   1008: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: aload_0
    //   1012: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   1015: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1018: ldc_w 547
    //   1021: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: aload_0
    //   1025: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   1028: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1031: ldc_w 509
    //   1034: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: ldc_w 551
    //   1040: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: astore 28
    //   1045: aload_0
    //   1046: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1049: ifnull +7913 -> 8962
    //   1052: aload_0
    //   1053: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1056: invokeinterface 560 1 0
    //   1061: astore 24
    //   1063: aload 26
    //   1065: aload 28
    //   1067: aload 24
    //   1069: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1072: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1075: putfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1078: ldc_w 565
    //   1081: aload 26
    //   1083: getfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   1086: aload 22
    //   1088: invokestatic 381	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1091: iload 18
    //   1093: ifne +8 -> 1101
    //   1096: aload_0
    //   1097: iconst_0
    //   1098: putfield 566	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_Boolean	Z
    //   1101: aload_2
    //   1102: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1105: astore 24
    //   1107: new 102	java/lang/StringBuilder
    //   1110: dup
    //   1111: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1114: aload_0
    //   1115: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   1118: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: ldc_w 568
    //   1124: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: aload 23
    //   1129: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: ldc_w 570
    //   1135: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: aload_2
    //   1139: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1142: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1145: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: ldc_w 572
    //   1151: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: astore 23
    //   1156: aload_0
    //   1157: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1160: ifnull +7843 -> 9003
    //   1163: aload_0
    //   1164: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1167: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   1170: istore 4
    //   1172: aload 23
    //   1174: iload 4
    //   1176: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1179: ldc_w 516
    //   1182: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: iload_3
    //   1186: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1189: ldc_w 472
    //   1192: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1195: aload_2
    //   1196: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1199: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1202: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: ldc_w 574
    //   1208: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: aload_2
    //   1212: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1215: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   1218: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1221: ldc_w 494
    //   1224: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1227: aload_2
    //   1228: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1231: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1234: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1237: ldc_w 483
    //   1240: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: aload_2
    //   1244: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1247: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   1250: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1253: ldc_w 487
    //   1256: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   1262: aload_0
    //   1263: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   1266: lsub
    //   1267: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1270: astore 23
    //   1272: aload 21
    //   1274: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1277: ifne +7732 -> 9009
    //   1280: new 102	java/lang/StringBuilder
    //   1283: dup
    //   1284: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1287: ldc_w 520
    //   1290: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: aload 21
    //   1295: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1301: astore 21
    //   1303: aload 24
    //   1305: aload 23
    //   1307: aload 21
    //   1309: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: ldc_w 518
    //   1315: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: aload 27
    //   1320: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1326: putfield 577	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   1329: getstatic 173	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:d	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1332: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   1335: aload_0
    //   1336: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1339: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   1342: if_icmpne +37 -> 1379
    //   1345: aload_0
    //   1346: getfield 197	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1349: ifnull +30 -> 1379
    //   1352: aload_0
    //   1353: getfield 197	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1356: aload_0
    //   1357: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   1360: aload_0
    //   1361: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1364: invokestatic 580	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1367: aload_2
    //   1368: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1371: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1374: invokeinterface 583 4 0
    //   1379: getstatic 250	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1382: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   1385: aload_0
    //   1386: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1389: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   1392: if_icmpne +37 -> 1429
    //   1395: aload_0
    //   1396: getfield 252	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1399: ifnull +30 -> 1429
    //   1402: aload_0
    //   1403: getfield 252	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1406: aload_0
    //   1407: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   1410: aload_0
    //   1411: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1414: invokestatic 580	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   1417: aload_2
    //   1418: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1421: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1424: invokeinterface 583 4 0
    //   1429: iload 18
    //   1431: ifeq +64 -> 1495
    //   1434: aload_0
    //   1435: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1438: invokestatic 56	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:a	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   1441: astore 21
    //   1443: aload_0
    //   1444: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1447: astore 23
    //   1449: aload_0
    //   1450: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   1453: ifeq +7594 -> 9047
    //   1456: aload_0
    //   1457: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1460: ifnull +7587 -> 9047
    //   1463: aload_0
    //   1464: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1467: ldc_w 585
    //   1470: invokevirtual 588	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1473: ifeq +7574 -> 9047
    //   1476: iconst_1
    //   1477: istore 18
    //   1479: aload 21
    //   1481: aload 23
    //   1483: iload 18
    //   1485: aload_2
    //   1486: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1489: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1492: invokevirtual 591	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:a	(Ljava/lang/String;ZZ)V
    //   1495: aload 26
    //   1497: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   1500: putfield 594	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   1503: aload 26
    //   1505: aload_0
    //   1506: invokevirtual 596	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()J
    //   1509: putfield 599	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   1512: aload 26
    //   1514: aload 19
    //   1516: putfield 603	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   1519: aload 26
    //   1521: aload 20
    //   1523: putfield 607	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   1526: aload 26
    //   1528: iload_3
    //   1529: putfield 610	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   1532: aload 26
    //   1534: aload 22
    //   1536: putfield 614	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   1539: aload 25
    //   1541: ifnonnull +7512 -> 9053
    //   1544: aconst_null
    //   1545: astore 19
    //   1547: aload 26
    //   1549: aload 19
    //   1551: putfield 617	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   1554: aload 26
    //   1556: aconst_null
    //   1557: putfield 620	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   1560: aload 26
    //   1562: aload_2
    //   1563: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1566: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1569: putfield 621	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   1572: aload 26
    //   1574: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   1577: aload_0
    //   1578: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   1581: lsub
    //   1582: putfield 624	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1585: aload 26
    //   1587: aload_2
    //   1588: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1591: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   1594: putfield 627	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   1597: aload 26
    //   1599: aload 26
    //   1601: getfield 624	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1604: aload_2
    //   1605: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1608: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   1611: lsub
    //   1612: putfield 630	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   1615: aload 26
    //   1617: lload 8
    //   1619: putfield 633	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   1622: aload 26
    //   1624: aload_0
    //   1625: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   1628: putfield 636	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   1631: aload 26
    //   1633: aload_0
    //   1634: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   1637: putfield 639	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   1640: aload 26
    //   1642: aload_0
    //   1643: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   1646: putfield 642	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   1649: aload 26
    //   1651: lconst_0
    //   1652: putfield 645	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   1655: aload 26
    //   1657: aload_0
    //   1658: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   1661: putfield 648	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   1664: aload 26
    //   1666: aload_2
    //   1667: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1670: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1673: putfield 651	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   1676: aload 26
    //   1678: aload_0
    //   1679: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   1682: invokestatic 655	com/tencent/component/network/module/base/Config:b	(Ljava/lang/String;)Z
    //   1685: putfield 658	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   1688: aload 26
    //   1690: aload_0
    //   1691: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   1694: putfield 661	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   1697: aload 26
    //   1699: aload_2
    //   1700: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1703: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1706: putfield 663	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   1709: aload_2
    //   1710: aload 26
    //   1712: invokevirtual 667	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1715: aload_0
    //   1716: aload_1
    //   1717: aload_2
    //   1718: aload 26
    //   1720: invokevirtual 320	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1723: aload_0
    //   1724: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   1727: ifeq +7336 -> 9063
    //   1730: aload_0
    //   1731: getfield 670	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   1734: ifnull +10 -> 1744
    //   1737: aload_0
    //   1738: getfield 670	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   1741: invokevirtual 675	com/squareup/okhttp/Call:cancel	()V
    //   1744: aload_0
    //   1745: aconst_null
    //   1746: putfield 368	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   1749: iload 5
    //   1751: istore_3
    //   1752: goto -1570 -> 182
    //   1755: lload 8
    //   1757: lstore 10
    //   1759: lload 8
    //   1761: lstore 12
    //   1763: getstatic 678	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangThreadLocal	Ljava/lang/ThreadLocal;
    //   1766: invokevirtual 684	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   1769: checkcast 686	com/tencent/component/network/utils/http/HttpUtil$RequestOptions
    //   1772: astore 24
    //   1774: lload 8
    //   1776: lstore 10
    //   1778: lload 8
    //   1780: lstore 12
    //   1782: aload 24
    //   1784: aload_0
    //   1785: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   1788: putfield 687	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:jdField_a_of_type_Boolean	Z
    //   1791: lload 8
    //   1793: lstore 10
    //   1795: lload 8
    //   1797: lstore 12
    //   1799: aload 24
    //   1801: aload_0
    //   1802: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   1805: putfield 688	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:jdField_b_of_type_Boolean	Z
    //   1808: lload 8
    //   1810: lstore 10
    //   1812: lload 8
    //   1814: lstore 12
    //   1816: aload_0
    //   1817: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1820: ifnull +2480 -> 4300
    //   1823: lload 8
    //   1825: lstore 10
    //   1827: lload 8
    //   1829: lstore 12
    //   1831: aload_0
    //   1832: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   1835: invokeinterface 560 1 0
    //   1840: astore 19
    //   1842: lload 8
    //   1844: lstore 10
    //   1846: lload 8
    //   1848: lstore 12
    //   1850: aload 24
    //   1852: aload 19
    //   1854: putfield 689	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:jdField_a_of_type_JavaNetProxy	Ljava/net/Proxy;
    //   1857: lload 8
    //   1859: lstore 10
    //   1861: lload 8
    //   1863: lstore 12
    //   1865: aload 26
    //   1867: iload 4
    //   1869: putfield 692	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   1872: lload 8
    //   1874: lstore 10
    //   1876: lload 8
    //   1878: lstore 12
    //   1880: aload 26
    //   1882: aload_0
    //   1883: getfield 294	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1886: putfield 695	com/tencent/component/network/downloader/DownloadReport:refer	Ljava/lang/String;
    //   1889: lload 8
    //   1891: lstore 10
    //   1893: lload 8
    //   1895: lstore 12
    //   1897: aload_0
    //   1898: aload_0
    //   1899: aload_0
    //   1900: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   1903: invokevirtual 696	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1906: putfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1909: lload 8
    //   1911: lstore 10
    //   1913: lload 8
    //   1915: lstore 12
    //   1917: aload 24
    //   1919: getfield 689	com/tencent/component/network/utils/http/HttpUtil$RequestOptions:jdField_a_of_type_JavaNetProxy	Ljava/net/Proxy;
    //   1922: ifnonnull +424 -> 2346
    //   1925: lload 8
    //   1927: lstore 10
    //   1929: lload 8
    //   1931: lstore 12
    //   1933: aload_0
    //   1934: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1937: ldc_w 585
    //   1940: invokevirtual 588	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1943: ifeq +18 -> 1961
    //   1946: lload 8
    //   1948: lstore 10
    //   1950: lload 8
    //   1952: lstore 12
    //   1954: aload_0
    //   1955: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   1958: ifeq +388 -> 2346
    //   1961: lload 8
    //   1963: lstore 10
    //   1965: lload 8
    //   1967: lstore 12
    //   1969: aload_0
    //   1970: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1973: ifnull +373 -> 2346
    //   1976: lload 8
    //   1978: lstore 10
    //   1980: lload 8
    //   1982: lstore 12
    //   1984: aload_0
    //   1985: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1988: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1991: ifnull +355 -> 2346
    //   1994: lload 8
    //   1996: lstore 10
    //   1998: lload 8
    //   2000: lstore 12
    //   2002: aload_0
    //   2003: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2006: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2009: getfield 406	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2012: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2015: ifne +331 -> 2346
    //   2018: lload 8
    //   2020: lstore 10
    //   2022: lload 8
    //   2024: lstore 12
    //   2026: aload_0
    //   2027: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2030: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2033: getfield 406	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2036: astore 20
    //   2038: lload 8
    //   2040: lstore 10
    //   2042: lload 8
    //   2044: lstore 12
    //   2046: aload 26
    //   2048: aload 20
    //   2050: putfield 699	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   2053: lload 8
    //   2055: lstore 10
    //   2057: lload 8
    //   2059: lstore 12
    //   2061: aload_0
    //   2062: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   2065: astore 19
    //   2067: lload 8
    //   2069: lstore 10
    //   2071: lload 8
    //   2073: lstore 12
    //   2075: aload 20
    //   2077: bipush 58
    //   2079: invokestatic 703	com/tencent/component/network/downloader/common/Utils:count	(Ljava/lang/String;C)I
    //   2082: iconst_2
    //   2083: if_icmpge +155 -> 2238
    //   2086: lload 8
    //   2088: lstore 10
    //   2090: lload 8
    //   2092: lstore 12
    //   2094: aload_0
    //   2095: getfield 30	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Int	I
    //   2098: istore_3
    //   2099: iload_3
    //   2100: ifle +2206 -> 4306
    //   2103: lload 8
    //   2105: lstore 10
    //   2107: lload 8
    //   2109: lstore 12
    //   2111: aload_0
    //   2112: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2115: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2118: iload_3
    //   2119: putfield 704	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_Int	I
    //   2122: lload 8
    //   2124: lstore 10
    //   2126: iload_3
    //   2127: istore 5
    //   2129: lload 8
    //   2131: lstore 12
    //   2133: iload_3
    //   2134: invokestatic 171	com/tencent/component/network/downloader/common/Utils:isPortValid	(I)Z
    //   2137: ifne +17 -> 2154
    //   2140: lload 8
    //   2142: lstore 10
    //   2144: lload 8
    //   2146: lstore 12
    //   2148: aload_0
    //   2149: getfield 93	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Int	I
    //   2152: istore 5
    //   2154: lload 8
    //   2156: lstore 10
    //   2158: lload 8
    //   2160: lstore 12
    //   2162: new 102	java/lang/StringBuilder
    //   2165: dup
    //   2166: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   2169: aload 20
    //   2171: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2174: ldc_w 706
    //   2177: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2180: iload 5
    //   2182: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2185: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2188: astore 20
    //   2190: lload 8
    //   2192: lstore 10
    //   2194: aload 20
    //   2196: astore 19
    //   2198: lload 8
    //   2200: lstore 12
    //   2202: aload_0
    //   2203: getfield 285	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2206: ifnull +32 -> 2238
    //   2209: lload 8
    //   2211: lstore 10
    //   2213: lload 8
    //   2215: lstore 12
    //   2217: aload_0
    //   2218: aload_0
    //   2219: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2222: aload_0
    //   2223: getfield 285	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2226: aload 20
    //   2228: invokevirtual 710	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2231: putfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2234: aload 20
    //   2236: astore 19
    //   2238: lload 8
    //   2240: lstore 10
    //   2242: lload 8
    //   2244: lstore 12
    //   2246: aload 26
    //   2248: aload_0
    //   2249: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2252: invokevirtual 114	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2255: putfield 713	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2258: lload 8
    //   2260: lstore 10
    //   2262: lload 8
    //   2264: lstore 12
    //   2266: invokestatic 714	com/tencent/component/network/module/base/QDLog:a	()Z
    //   2269: ifeq +77 -> 2346
    //   2272: lload 8
    //   2274: lstore 10
    //   2276: lload 8
    //   2278: lstore 12
    //   2280: ldc 186
    //   2282: new 102	java/lang/StringBuilder
    //   2285: dup
    //   2286: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   2289: ldc_w 716
    //   2292: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2295: aload 26
    //   2297: getfield 713	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2300: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2303: ldc_w 718
    //   2306: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2309: aload 19
    //   2311: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2314: ldc 127
    //   2316: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2319: aload_0
    //   2320: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   2323: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2326: ldc 192
    //   2328: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2331: invokestatic 147	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2334: invokevirtual 150	java/lang/Thread:getId	()J
    //   2337: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2340: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2343: invokestatic 376	com/tencent/component/network/module/base/QDLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   2346: lload 8
    //   2348: lstore 10
    //   2350: lload 8
    //   2352: lstore 12
    //   2354: aload_0
    //   2355: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2358: ifnull +43 -> 2401
    //   2361: lload 8
    //   2363: lstore 10
    //   2365: lload 8
    //   2367: lstore 12
    //   2369: aload 26
    //   2371: aload_0
    //   2372: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2375: invokevirtual 114	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   2378: putfield 713	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   2381: lload 8
    //   2383: lstore 10
    //   2385: lload 8
    //   2387: lstore 12
    //   2389: aload 26
    //   2391: aload_0
    //   2392: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2395: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   2398: putfield 721	com/tencent/component/network/downloader/DownloadReport:strategyId	I
    //   2401: lload 8
    //   2403: lstore 10
    //   2405: lload 8
    //   2407: lstore 12
    //   2409: aload_0
    //   2410: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   2413: ifeq +1915 -> 4328
    //   2416: lload 8
    //   2418: lstore 10
    //   2420: lload 8
    //   2422: lstore 12
    //   2424: aload_0
    //   2425: aload_0
    //   2426: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2429: aload_0
    //   2430: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   2433: aload_0
    //   2434: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   2437: aload_0
    //   2438: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2441: aload_0
    //   2442: getfield 294	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2445: invokestatic 724	com/tencent/component/network/utils/http/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   2448: putfield 368	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   2451: lload 8
    //   2453: lstore 10
    //   2455: lload 8
    //   2457: lstore 12
    //   2459: aload_0
    //   2460: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2463: ifnull +36 -> 2499
    //   2466: lload 8
    //   2468: lstore 10
    //   2470: lload 8
    //   2472: lstore 12
    //   2474: aload_0
    //   2475: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2478: aload_0
    //   2479: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   2482: aload_0
    //   2483: getfield 368	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   2486: aload_0
    //   2487: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   2490: aload_0
    //   2491: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   2494: invokeinterface 727 5 0
    //   2499: lload 8
    //   2501: lstore 10
    //   2503: lload 8
    //   2505: lstore 12
    //   2507: aload_0
    //   2508: aload_0
    //   2509: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   2512: aload_0
    //   2513: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   2516: aload_0
    //   2517: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   2520: aload_0
    //   2521: getfield 368	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   2524: invokevirtual 730	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lcom/squareup/okhttp/Request$Builder;)V
    //   2527: lload 8
    //   2529: lstore 10
    //   2531: lload 8
    //   2533: lstore 12
    //   2535: aload_0
    //   2536: aload_0
    //   2537: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   2540: aload_0
    //   2541: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   2544: aload_0
    //   2545: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   2548: aload_0
    //   2549: getfield 368	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   2552: aload 24
    //   2554: invokevirtual 733	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;Lcom/squareup/okhttp/Request$Builder;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)V
    //   2557: lload 8
    //   2559: lstore 10
    //   2561: lload 8
    //   2563: lstore 12
    //   2565: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   2568: lload 16
    //   2570: lsub
    //   2571: lstore 8
    //   2573: lload 8
    //   2575: lstore 10
    //   2577: lload 8
    //   2579: lstore 12
    //   2581: aload_0
    //   2582: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   2585: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   2588: lload 8
    //   2590: lstore 10
    //   2592: lload 8
    //   2594: lstore 12
    //   2596: aload_0
    //   2597: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   2600: ifnull +3264 -> 5864
    //   2603: lload 8
    //   2605: lstore 10
    //   2607: lload 8
    //   2609: lstore 12
    //   2611: aload_0
    //   2612: getfield 736	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseQZoneHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2615: ifnonnull +18 -> 2633
    //   2618: lload 8
    //   2620: lstore 10
    //   2622: lload 8
    //   2624: lstore 12
    //   2626: aload_0
    //   2627: invokestatic 739	com/tencent/component/network/utils/http/HttpUtil:a	()Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2630: putfield 736	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseQZoneHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2633: lload 8
    //   2635: lstore 10
    //   2637: lload 8
    //   2639: lstore 12
    //   2641: invokestatic 742	com/tencent/component/network/utils/http/HttpUtil:a	()Lorg/apache/http/protocol/HttpContext;
    //   2644: astore 19
    //   2646: aload_0
    //   2647: getfield 736	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseQZoneHttpClient	Lcom/tencent/component/network/utils/http/base/QZoneHttpClient;
    //   2650: aload_0
    //   2651: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   2654: aload 19
    //   2656: invokevirtual 748	com/tencent/component/network/utils/http/base/QZoneHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   2659: astore 20
    //   2661: aconst_null
    //   2662: astore 22
    //   2664: aload 19
    //   2666: astore 21
    //   2668: aload 20
    //   2670: astore 19
    //   2672: aload 22
    //   2674: astore 20
    //   2676: aload_0
    //   2677: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   2680: aload_0
    //   2681: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   2684: lsub
    //   2685: putfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   2688: aload 19
    //   2690: ifnonnull +8 -> 2698
    //   2693: aload 20
    //   2695: ifnull +4804 -> 7499
    //   2698: aload 19
    //   2700: ifnull +3233 -> 5933
    //   2703: aload 19
    //   2705: invokeinterface 754 1 0
    //   2710: ifnull +3223 -> 5933
    //   2713: aload 19
    //   2715: invokeinterface 754 1 0
    //   2720: invokeinterface 759 1 0
    //   2725: istore_3
    //   2726: aload_2
    //   2727: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2730: iload_3
    //   2731: putfield 760	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   2734: sipush 200
    //   2737: iload_3
    //   2738: if_icmpeq +10 -> 2748
    //   2741: sipush 206
    //   2744: iload_3
    //   2745: if_icmpne +3202 -> 5947
    //   2748: iload_3
    //   2749: istore 5
    //   2751: aload_0
    //   2752: aload 19
    //   2754: aload 20
    //   2756: aload_2
    //   2757: aload_1
    //   2758: iload_3
    //   2759: invokevirtual 763	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   2762: ifeq +3235 -> 5997
    //   2765: aload_2
    //   2766: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2769: invokevirtual 766	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   2772: aload_2
    //   2773: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2776: getfield 769	com/tencent/component/network/downloader/DownloadResult$Content:noCache	Z
    //   2779: ifeq +9364 -> 12143
    //   2782: aload_0
    //   2783: aload 19
    //   2785: aload 20
    //   2787: invokevirtual 772	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)I
    //   2790: istore 5
    //   2792: aload_2
    //   2793: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2796: iload 5
    //   2798: putfield 775	com/tencent/component/network/downloader/DownloadResult$Content:retCode	I
    //   2801: iload 5
    //   2803: invokestatic 776	com/tencent/component/network/module/base/Config:a	(I)Z
    //   2806: istore 18
    //   2808: iload 18
    //   2810: ifeq +7067 -> 9877
    //   2813: aload_2
    //   2814: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2817: lload 14
    //   2819: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   2822: invokevirtual 393	com/tencent/component/network/downloader/DownloadResult$Process:a	(JJ)V
    //   2825: aload_0
    //   2826: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2829: invokestatic 398	com/tencent/component/network/module/common/NetworkStatus:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   2832: invokevirtual 401	com/tencent/component/network/module/common/NetworkStatus:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   2835: astore 24
    //   2837: aload_0
    //   2838: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2841: ifnull +6248 -> 9089
    //   2844: aload_0
    //   2845: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2848: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2851: ifnull +6238 -> 9089
    //   2854: aload_0
    //   2855: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2858: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2861: getfield 406	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2864: astore 22
    //   2866: aload_0
    //   2867: aload_0
    //   2868: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   2871: aload 19
    //   2873: aload 20
    //   2875: invokevirtual 409	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   2878: astore 25
    //   2880: aload 21
    //   2882: ifnull +12473 -> 15355
    //   2885: aload 21
    //   2887: ldc_w 411
    //   2890: invokeinterface 417 2 0
    //   2895: checkcast 217	java/lang/String
    //   2898: astore 21
    //   2900: aload_0
    //   2901: lconst_0
    //   2902: putfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   2905: aload_0
    //   2906: iconst_0
    //   2907: putfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   2910: aload_0
    //   2911: lconst_0
    //   2912: putfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   2915: aload_0
    //   2916: iconst_0
    //   2917: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   2920: aload_2
    //   2921: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2924: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2927: ifeq +12 -> 2939
    //   2930: aload_1
    //   2931: invokeinterface 317 1 0
    //   2936: ifeq +31 -> 2967
    //   2939: aload_0
    //   2940: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2943: ifnull +24 -> 2967
    //   2946: aload_0
    //   2947: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2950: aload_0
    //   2951: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   2954: aload_2
    //   2955: invokevirtual 426	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   2958: aload 19
    //   2960: aload 20
    //   2962: invokeinterface 431 5 0
    //   2967: aload_1
    //   2968: invokeinterface 317 1 0
    //   2973: ifne +1293 -> 4266
    //   2976: aload_0
    //   2977: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2980: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2983: istore 18
    //   2985: aload_2
    //   2986: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2989: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2992: ifne +6113 -> 9105
    //   2995: new 102	java/lang/StringBuilder
    //   2998: dup
    //   2999: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   3002: ldc_w 433
    //   3005: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3008: aload_0
    //   3009: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   3012: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3015: ldc_w 435
    //   3018: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3021: aload_0
    //   3022: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   3025: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3028: ldc_w 440
    //   3031: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3034: astore 27
    //   3036: aload_0
    //   3037: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   3040: ifeq +6681 -> 9721
    //   3043: aload 20
    //   3045: ifnull +6676 -> 9721
    //   3048: aload 20
    //   3050: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   3053: ifnull +6668 -> 9721
    //   3056: aload 20
    //   3058: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   3061: invokevirtual 449	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   3064: astore 23
    //   3066: aload 27
    //   3068: aload 23
    //   3070: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3073: ldc_w 451
    //   3076: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3079: aload 24
    //   3081: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3084: ldc_w 456
    //   3087: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3090: aload 22
    //   3092: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3095: ldc_w 458
    //   3098: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3101: aconst_null
    //   3102: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3105: ldc_w 460
    //   3108: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3111: invokestatic 147	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3114: invokevirtual 150	java/lang/Thread:getId	()J
    //   3117: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3120: ldc_w 462
    //   3123: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3126: invokestatic 134	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3129: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3132: ldc_w 464
    //   3135: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3138: aload_0
    //   3139: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   3142: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3145: ldc_w 466
    //   3148: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3151: aload_0
    //   3152: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   3155: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3158: ldc_w 468
    //   3161: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3164: astore 27
    //   3166: aload_0
    //   3167: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   3170: ifeq +6559 -> 9729
    //   3173: aload_0
    //   3174: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   3177: aload_0
    //   3178: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   3181: invokestatic 267	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   3184: astore 23
    //   3186: aload 27
    //   3188: aload 23
    //   3190: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3193: ldc_w 470
    //   3196: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3199: iload 18
    //   3201: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3204: ldc_w 472
    //   3207: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3210: aload_2
    //   3211: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3214: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3217: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3220: ldc_w 483
    //   3223: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3226: aload_2
    //   3227: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3230: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   3233: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3236: ldc_w 487
    //   3239: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3242: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   3245: aload_0
    //   3246: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   3249: lsub
    //   3250: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3253: ldc_w 489
    //   3256: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3259: aload_2
    //   3260: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3263: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3266: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3269: ldc_w 494
    //   3272: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3275: aload_2
    //   3276: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3279: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3282: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3285: ldc_w 498
    //   3288: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3291: aload_2
    //   3292: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3295: getfield 501	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3298: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3301: ldc_w 503
    //   3304: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3307: aload_0
    //   3308: invokevirtual 369	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()I
    //   3311: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3314: ldc_w 505
    //   3317: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3320: aload_0
    //   3321: invokevirtual 507	com/tencent/component/network/downloader/impl/FastDownloadTask:c	()I
    //   3324: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3327: ldc_w 509
    //   3330: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3333: ldc_w 511
    //   3336: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3339: aload_2
    //   3340: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3343: invokevirtual 514	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3346: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3349: ldc_w 516
    //   3352: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3355: iload_3
    //   3356: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3359: ldc_w 518
    //   3362: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3365: aload 25
    //   3367: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3370: ldc_w 520
    //   3373: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3376: aload 21
    //   3378: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3381: ldc_w 522
    //   3384: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3387: astore 27
    //   3389: aload_0
    //   3390: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3393: ifnull +6342 -> 9735
    //   3396: aload_0
    //   3397: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3400: iconst_0
    //   3401: bipush 30
    //   3403: invokevirtual 527	java/lang/String:substring	(II)Ljava/lang/String;
    //   3406: astore 23
    //   3408: aload 27
    //   3410: aload 23
    //   3412: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3415: ldc_w 529
    //   3418: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3421: astore 23
    //   3423: aload_0
    //   3424: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3427: ifnull +6317 -> 9744
    //   3430: aload_0
    //   3431: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3434: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3437: istore 5
    //   3439: aload 23
    //   3441: iload 5
    //   3443: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3446: ldc_w 531
    //   3449: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3452: aload_2
    //   3453: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3456: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3459: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3462: ldc_w 536
    //   3465: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3468: lload 8
    //   3470: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3473: ldc_w 538
    //   3476: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3479: aload_0
    //   3480: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   3483: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3486: ldc_w 505
    //   3489: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3492: aload_0
    //   3493: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   3496: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3499: ldc_w 509
    //   3502: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3505: ldc_w 540
    //   3508: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3511: aload_0
    //   3512: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   3515: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3518: ldc_w 505
    //   3521: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3524: aload_0
    //   3525: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   3528: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3531: ldc_w 509
    //   3534: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3537: ldc_w 542
    //   3540: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3543: aload_0
    //   3544: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   3547: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3550: ldc_w 544
    //   3553: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3556: aload_0
    //   3557: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   3560: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3563: ldc_w 547
    //   3566: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3569: aload_0
    //   3570: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   3573: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3576: ldc_w 509
    //   3579: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3582: ldc_w 551
    //   3585: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3588: astore 27
    //   3590: aload_0
    //   3591: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3594: ifnull +6156 -> 9750
    //   3597: aload_0
    //   3598: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   3601: invokeinterface 560 1 0
    //   3606: astore 23
    //   3608: aload 26
    //   3610: aload 27
    //   3612: aload 23
    //   3614: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3617: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3620: putfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3623: ldc_w 565
    //   3626: aload 26
    //   3628: getfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   3631: aconst_null
    //   3632: invokestatic 381	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3635: iload 18
    //   3637: ifne +8 -> 3645
    //   3640: aload_0
    //   3641: iconst_0
    //   3642: putfield 566	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_Boolean	Z
    //   3645: aload_2
    //   3646: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3649: astore 23
    //   3651: new 102	java/lang/StringBuilder
    //   3654: dup
    //   3655: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   3658: aload_0
    //   3659: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   3662: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3665: ldc_w 568
    //   3668: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3671: aload 22
    //   3673: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3676: ldc_w 570
    //   3679: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3682: aload_2
    //   3683: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3686: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3689: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3692: ldc_w 572
    //   3695: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3698: astore 22
    //   3700: aload_0
    //   3701: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3704: ifnull +6087 -> 9791
    //   3707: aload_0
    //   3708: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3711: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3714: istore 5
    //   3716: aload 22
    //   3718: iload 5
    //   3720: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3723: ldc_w 516
    //   3726: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3729: iload_3
    //   3730: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3733: ldc_w 472
    //   3736: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3739: aload_2
    //   3740: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3743: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3746: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3749: ldc_w 574
    //   3752: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3755: aload_2
    //   3756: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3759: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3762: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3765: ldc_w 494
    //   3768: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3771: aload_2
    //   3772: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3775: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3778: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3781: ldc_w 483
    //   3784: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3787: aload_2
    //   3788: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3791: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   3794: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3797: ldc_w 487
    //   3800: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3803: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   3806: aload_0
    //   3807: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   3810: lsub
    //   3811: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3814: astore 22
    //   3816: aload 21
    //   3818: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3821: ifne +5976 -> 9797
    //   3824: new 102	java/lang/StringBuilder
    //   3827: dup
    //   3828: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   3831: ldc_w 520
    //   3834: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3837: aload 21
    //   3839: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3842: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3845: astore 21
    //   3847: aload 23
    //   3849: aload 22
    //   3851: aload 21
    //   3853: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3856: ldc_w 518
    //   3859: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3862: aload 25
    //   3864: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3867: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3870: putfield 577	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   3873: getstatic 173	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:d	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3876: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3879: aload_0
    //   3880: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3883: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3886: if_icmpne +37 -> 3923
    //   3889: aload_0
    //   3890: getfield 197	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3893: ifnull +30 -> 3923
    //   3896: aload_0
    //   3897: getfield 197	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3900: aload_0
    //   3901: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   3904: aload_0
    //   3905: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3908: invokestatic 580	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   3911: aload_2
    //   3912: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3915: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3918: invokeinterface 583 4 0
    //   3923: getstatic 250	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3926: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3929: aload_0
    //   3930: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3933: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   3936: if_icmpne +37 -> 3973
    //   3939: aload_0
    //   3940: getfield 252	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3943: ifnull +30 -> 3973
    //   3946: aload_0
    //   3947: getfield 252	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3950: aload_0
    //   3951: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   3954: aload_0
    //   3955: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3958: invokestatic 580	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   3961: aload_2
    //   3962: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3965: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3968: invokeinterface 583 4 0
    //   3973: iload 18
    //   3975: ifeq +64 -> 4039
    //   3978: aload_0
    //   3979: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   3982: invokestatic 56	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:a	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   3985: astore 21
    //   3987: aload_0
    //   3988: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3991: astore 22
    //   3993: aload_0
    //   3994: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   3997: ifeq +5838 -> 9835
    //   4000: aload_0
    //   4001: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4004: ifnull +5831 -> 9835
    //   4007: aload_0
    //   4008: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4011: ldc_w 585
    //   4014: invokevirtual 588	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   4017: ifeq +5818 -> 9835
    //   4020: iconst_1
    //   4021: istore 18
    //   4023: aload 21
    //   4025: aload 22
    //   4027: iload 18
    //   4029: aload_2
    //   4030: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4033: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4036: invokevirtual 591	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:a	(Ljava/lang/String;ZZ)V
    //   4039: aload 26
    //   4041: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   4044: putfield 594	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   4047: aload 26
    //   4049: aload_0
    //   4050: invokevirtual 596	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()J
    //   4053: putfield 599	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   4056: aload 26
    //   4058: aload 19
    //   4060: putfield 603	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   4063: aload 26
    //   4065: aload 20
    //   4067: putfield 607	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   4070: aload 26
    //   4072: iload_3
    //   4073: putfield 610	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   4076: aload 26
    //   4078: aconst_null
    //   4079: putfield 614	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   4082: aload 24
    //   4084: ifnonnull +5757 -> 9841
    //   4087: aconst_null
    //   4088: astore 19
    //   4090: aload 26
    //   4092: aload 19
    //   4094: putfield 617	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   4097: aload 26
    //   4099: aconst_null
    //   4100: putfield 620	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   4103: aload 26
    //   4105: aload_2
    //   4106: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4109: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4112: putfield 621	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   4115: aload 26
    //   4117: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   4120: aload_0
    //   4121: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   4124: lsub
    //   4125: putfield 624	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4128: aload 26
    //   4130: aload_2
    //   4131: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4134: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   4137: putfield 627	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   4140: aload 26
    //   4142: aload 26
    //   4144: getfield 624	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   4147: aload_2
    //   4148: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4151: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   4154: lsub
    //   4155: putfield 630	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   4158: aload 26
    //   4160: lload 8
    //   4162: putfield 633	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   4165: aload 26
    //   4167: aload_0
    //   4168: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   4171: putfield 636	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   4174: aload 26
    //   4176: aload_0
    //   4177: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   4180: putfield 639	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   4183: aload 26
    //   4185: aload_0
    //   4186: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   4189: putfield 642	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   4192: aload 26
    //   4194: lconst_0
    //   4195: putfield 645	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   4198: aload 26
    //   4200: aload_0
    //   4201: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   4204: putfield 648	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   4207: aload 26
    //   4209: aload_2
    //   4210: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4213: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4216: putfield 651	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   4219: aload 26
    //   4221: aload_0
    //   4222: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   4225: invokestatic 655	com/tencent/component/network/module/base/Config:b	(Ljava/lang/String;)Z
    //   4228: putfield 658	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   4231: aload 26
    //   4233: aload_0
    //   4234: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   4237: putfield 661	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   4240: aload 26
    //   4242: aload_2
    //   4243: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4246: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4249: putfield 663	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   4252: aload_2
    //   4253: aload 26
    //   4255: invokevirtual 667	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4258: aload_0
    //   4259: aload_1
    //   4260: aload_2
    //   4261: aload 26
    //   4263: invokevirtual 320	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4266: aload_0
    //   4267: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   4270: ifeq +5581 -> 9851
    //   4273: aload_0
    //   4274: getfield 670	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   4277: ifnull +10 -> 4287
    //   4280: aload_0
    //   4281: getfield 670	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   4284: invokevirtual 675	com/squareup/okhttp/Call:cancel	()V
    //   4287: aload_0
    //   4288: aconst_null
    //   4289: putfield 368	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   4292: iload 4
    //   4294: iconst_1
    //   4295: iadd
    //   4296: istore_3
    //   4297: goto -4115 -> 182
    //   4300: aconst_null
    //   4301: astore 19
    //   4303: goto -2461 -> 1842
    //   4306: lload 8
    //   4308: lstore 10
    //   4310: lload 8
    //   4312: lstore 12
    //   4314: aload_0
    //   4315: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4318: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4321: getfield 704	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_Int	I
    //   4324: istore_3
    //   4325: goto -2203 -> 2122
    //   4328: lload 8
    //   4330: lstore 10
    //   4332: lload 8
    //   4334: lstore 12
    //   4336: aload_0
    //   4337: aload_0
    //   4338: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4341: aload_0
    //   4342: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   4345: aload_0
    //   4346: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   4349: aload_0
    //   4350: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4353: aload_0
    //   4354: getfield 294	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   4357: aload 24
    //   4359: invokestatic 779	com/tencent/component/network/utils/http/HttpUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lorg/apache/http/client/methods/HttpGet;
    //   4362: putfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   4365: goto -1914 -> 2451
    //   4368: astore 19
    //   4370: aconst_null
    //   4371: astore 20
    //   4373: iload 6
    //   4375: istore_3
    //   4376: lload 12
    //   4378: lstore 8
    //   4380: aload_2
    //   4381: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4384: lload 14
    //   4386: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   4389: invokevirtual 393	com/tencent/component/network/downloader/DownloadResult$Process:a	(JJ)V
    //   4392: aload_0
    //   4393: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4396: invokestatic 398	com/tencent/component/network/module/common/NetworkStatus:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   4399: invokevirtual 401	com/tencent/component/network/module/common/NetworkStatus:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4402: astore 27
    //   4404: aload_0
    //   4405: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4408: ifnull +3105 -> 7513
    //   4411: aload_0
    //   4412: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4415: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4418: ifnull +3095 -> 7513
    //   4421: aload_0
    //   4422: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4425: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4428: getfield 406	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4431: astore 24
    //   4433: aload_0
    //   4434: aload_0
    //   4435: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   4438: aload 23
    //   4440: aload 22
    //   4442: invokevirtual 409	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   4445: astore 28
    //   4447: aload 21
    //   4449: ifnull +10922 -> 15371
    //   4452: aload 21
    //   4454: ldc_w 411
    //   4457: invokeinterface 417 2 0
    //   4462: checkcast 217	java/lang/String
    //   4465: astore 21
    //   4467: aload_0
    //   4468: lconst_0
    //   4469: putfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   4472: aload_0
    //   4473: iconst_0
    //   4474: putfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   4477: aload_0
    //   4478: lconst_0
    //   4479: putfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   4482: aload_0
    //   4483: iconst_0
    //   4484: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   4487: aload_2
    //   4488: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4491: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4494: ifeq +12 -> 4506
    //   4497: aload_1
    //   4498: invokeinterface 317 1 0
    //   4503: ifeq +31 -> 4534
    //   4506: aload_0
    //   4507: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4510: ifnull +24 -> 4534
    //   4513: aload_0
    //   4514: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4517: aload_0
    //   4518: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   4521: aload_2
    //   4522: invokevirtual 426	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   4525: aload 23
    //   4527: aload 22
    //   4529: invokeinterface 431 5 0
    //   4534: aload_1
    //   4535: invokeinterface 317 1 0
    //   4540: ifne +1295 -> 5835
    //   4543: aload_0
    //   4544: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4547: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   4550: istore 18
    //   4552: aload_2
    //   4553: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4556: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4559: ifne +2970 -> 7529
    //   4562: new 102	java/lang/StringBuilder
    //   4565: dup
    //   4566: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   4569: ldc_w 433
    //   4572: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4575: aload_0
    //   4576: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   4579: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4582: ldc_w 435
    //   4585: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4588: aload_0
    //   4589: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   4592: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4595: ldc_w 440
    //   4598: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4601: astore 29
    //   4603: aload_0
    //   4604: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   4607: ifeq +3538 -> 8145
    //   4610: aload 22
    //   4612: ifnull +3533 -> 8145
    //   4615: aload 22
    //   4617: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   4620: ifnull +3525 -> 8145
    //   4623: aload 22
    //   4625: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   4628: invokevirtual 449	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   4631: astore 25
    //   4633: aload 29
    //   4635: aload 25
    //   4637: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4640: ldc_w 451
    //   4643: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4646: aload 27
    //   4648: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4651: ldc_w 456
    //   4654: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4657: aload 24
    //   4659: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4662: ldc_w 458
    //   4665: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4668: aconst_null
    //   4669: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4672: ldc_w 460
    //   4675: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4678: invokestatic 147	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4681: invokevirtual 150	java/lang/Thread:getId	()J
    //   4684: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4687: ldc_w 462
    //   4690: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4693: invokestatic 134	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   4696: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4699: ldc_w 464
    //   4702: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4705: aload_0
    //   4706: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   4709: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4712: ldc_w 466
    //   4715: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4718: aload_0
    //   4719: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   4722: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4725: ldc_w 468
    //   4728: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4731: astore 29
    //   4733: aload_0
    //   4734: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   4737: ifeq +3416 -> 8153
    //   4740: aload_0
    //   4741: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4744: aload_0
    //   4745: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   4748: invokestatic 267	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   4751: astore 25
    //   4753: aload 29
    //   4755: aload 25
    //   4757: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4760: ldc_w 470
    //   4763: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4766: iload 18
    //   4768: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4771: ldc_w 472
    //   4774: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4777: aload_2
    //   4778: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4781: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4784: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4787: ldc_w 483
    //   4790: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4793: aload_2
    //   4794: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4797: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   4800: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4803: ldc_w 487
    //   4806: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4809: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   4812: aload_0
    //   4813: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   4816: lsub
    //   4817: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4820: ldc_w 489
    //   4823: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4826: aload_2
    //   4827: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4830: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4833: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4836: ldc_w 494
    //   4839: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4842: aload_2
    //   4843: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4846: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4849: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4852: ldc_w 498
    //   4855: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4858: aload_2
    //   4859: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4862: getfield 501	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   4865: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4868: ldc_w 503
    //   4871: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4874: aload_0
    //   4875: invokevirtual 369	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()I
    //   4878: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4881: ldc_w 505
    //   4884: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4887: aload_0
    //   4888: invokevirtual 507	com/tencent/component/network/downloader/impl/FastDownloadTask:c	()I
    //   4891: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4894: ldc_w 509
    //   4897: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4900: ldc_w 511
    //   4903: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4906: aload_2
    //   4907: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4910: invokevirtual 514	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   4913: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4916: ldc_w 516
    //   4919: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4922: iload_3
    //   4923: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4926: ldc_w 518
    //   4929: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4932: aload 28
    //   4934: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4937: ldc_w 520
    //   4940: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4943: aload 21
    //   4945: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4948: ldc_w 522
    //   4951: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4954: astore 29
    //   4956: aload_0
    //   4957: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4960: ifnull +3199 -> 8159
    //   4963: aload_0
    //   4964: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4967: iconst_0
    //   4968: bipush 30
    //   4970: invokevirtual 527	java/lang/String:substring	(II)Ljava/lang/String;
    //   4973: astore 25
    //   4975: aload 29
    //   4977: aload 25
    //   4979: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4982: ldc_w 529
    //   4985: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4988: astore 25
    //   4990: aload_0
    //   4991: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4994: ifnull +3174 -> 8168
    //   4997: aload_0
    //   4998: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5001: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   5004: istore 4
    //   5006: aload 25
    //   5008: iload 4
    //   5010: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5013: ldc_w 531
    //   5016: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5019: aload_2
    //   5020: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5023: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5026: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5029: ldc_w 536
    //   5032: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5035: lload 8
    //   5037: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5040: ldc_w 538
    //   5043: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5046: aload_0
    //   5047: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   5050: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5053: ldc_w 505
    //   5056: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5059: aload_0
    //   5060: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   5063: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5066: ldc_w 509
    //   5069: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5072: ldc_w 540
    //   5075: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5078: aload_0
    //   5079: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   5082: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5085: ldc_w 505
    //   5088: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5091: aload_0
    //   5092: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   5095: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5098: ldc_w 509
    //   5101: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5104: ldc_w 542
    //   5107: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5110: aload_0
    //   5111: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   5114: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5117: ldc_w 544
    //   5120: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5123: aload_0
    //   5124: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   5127: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5130: ldc_w 547
    //   5133: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5136: aload_0
    //   5137: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   5140: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5143: ldc_w 509
    //   5146: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5149: ldc_w 551
    //   5152: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5155: astore 29
    //   5157: aload_0
    //   5158: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5161: ifnull +3013 -> 8174
    //   5164: aload_0
    //   5165: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   5168: invokeinterface 560 1 0
    //   5173: astore 25
    //   5175: aload 26
    //   5177: aload 29
    //   5179: aload 25
    //   5181: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5184: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5187: putfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5190: ldc_w 565
    //   5193: aload 26
    //   5195: getfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   5198: aload 20
    //   5200: invokestatic 381	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5203: iload 18
    //   5205: ifne +8 -> 5213
    //   5208: aload_0
    //   5209: iconst_0
    //   5210: putfield 566	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_Boolean	Z
    //   5213: aload_2
    //   5214: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5217: astore 25
    //   5219: new 102	java/lang/StringBuilder
    //   5222: dup
    //   5223: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   5226: aload_0
    //   5227: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   5230: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5233: ldc_w 568
    //   5236: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5239: aload 24
    //   5241: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5244: ldc_w 570
    //   5247: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5250: aload_2
    //   5251: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5254: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5257: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5260: ldc_w 572
    //   5263: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5266: astore 24
    //   5268: aload_0
    //   5269: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5272: ifnull +2943 -> 8215
    //   5275: aload_0
    //   5276: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5279: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   5282: istore 4
    //   5284: aload 24
    //   5286: iload 4
    //   5288: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5291: ldc_w 516
    //   5294: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5297: iload_3
    //   5298: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5301: ldc_w 472
    //   5304: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5307: aload_2
    //   5308: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5311: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5314: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5317: ldc_w 574
    //   5320: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5323: aload_2
    //   5324: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5327: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5330: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5333: ldc_w 494
    //   5336: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5339: aload_2
    //   5340: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5343: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5346: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5349: ldc_w 483
    //   5352: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5355: aload_2
    //   5356: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5359: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   5362: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5365: ldc_w 487
    //   5368: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5371: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   5374: aload_0
    //   5375: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   5378: lsub
    //   5379: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5382: astore 24
    //   5384: aload 21
    //   5386: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5389: ifne +2832 -> 8221
    //   5392: new 102	java/lang/StringBuilder
    //   5395: dup
    //   5396: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   5399: ldc_w 520
    //   5402: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5405: aload 21
    //   5407: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5410: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5413: astore 21
    //   5415: aload 25
    //   5417: aload 24
    //   5419: aload 21
    //   5421: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5424: ldc_w 518
    //   5427: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5430: aload 28
    //   5432: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5435: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5438: putfield 577	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   5441: getstatic 173	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:d	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5444: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   5447: aload_0
    //   5448: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5451: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   5454: if_icmpne +37 -> 5491
    //   5457: aload_0
    //   5458: getfield 197	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5461: ifnull +30 -> 5491
    //   5464: aload_0
    //   5465: getfield 197	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5468: aload_0
    //   5469: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   5472: aload_0
    //   5473: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5476: invokestatic 580	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   5479: aload_2
    //   5480: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5483: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5486: invokeinterface 583 4 0
    //   5491: getstatic 250	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5494: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   5497: aload_0
    //   5498: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5501: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   5504: if_icmpne +37 -> 5541
    //   5507: aload_0
    //   5508: getfield 252	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5511: ifnull +30 -> 5541
    //   5514: aload_0
    //   5515: getfield 252	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5518: aload_0
    //   5519: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   5522: aload_0
    //   5523: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5526: invokestatic 580	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   5529: aload_2
    //   5530: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5533: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5536: invokeinterface 583 4 0
    //   5541: iload 18
    //   5543: ifeq +64 -> 5607
    //   5546: aload_0
    //   5547: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   5550: invokestatic 56	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:a	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   5553: astore 21
    //   5555: aload_0
    //   5556: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5559: astore 24
    //   5561: aload_0
    //   5562: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   5565: ifeq +2694 -> 8259
    //   5568: aload_0
    //   5569: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5572: ifnull +2687 -> 8259
    //   5575: aload_0
    //   5576: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5579: ldc_w 585
    //   5582: invokevirtual 588	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   5585: ifeq +2674 -> 8259
    //   5588: iconst_1
    //   5589: istore 18
    //   5591: aload 21
    //   5593: aload 24
    //   5595: iload 18
    //   5597: aload_2
    //   5598: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5601: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5604: invokevirtual 591	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:a	(Ljava/lang/String;ZZ)V
    //   5607: aload 26
    //   5609: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   5612: putfield 594	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   5615: aload 26
    //   5617: aload_0
    //   5618: invokevirtual 596	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()J
    //   5621: putfield 599	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   5624: aload 26
    //   5626: aload 23
    //   5628: putfield 603	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   5631: aload 26
    //   5633: aload 22
    //   5635: putfield 607	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   5638: aload 26
    //   5640: iload_3
    //   5641: putfield 610	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   5644: aload 26
    //   5646: aload 20
    //   5648: putfield 614	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   5651: aload 27
    //   5653: ifnonnull +2612 -> 8265
    //   5656: aconst_null
    //   5657: astore 20
    //   5659: aload 26
    //   5661: aload 20
    //   5663: putfield 617	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   5666: aload 26
    //   5668: aconst_null
    //   5669: putfield 620	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   5672: aload 26
    //   5674: aload_2
    //   5675: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5678: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5681: putfield 621	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   5684: aload 26
    //   5686: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   5689: aload_0
    //   5690: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   5693: lsub
    //   5694: putfield 624	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5697: aload 26
    //   5699: aload_2
    //   5700: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5703: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   5706: putfield 627	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   5709: aload 26
    //   5711: aload 26
    //   5713: getfield 624	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5716: aload_2
    //   5717: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5720: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   5723: lsub
    //   5724: putfield 630	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   5727: aload 26
    //   5729: lload 8
    //   5731: putfield 633	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   5734: aload 26
    //   5736: aload_0
    //   5737: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   5740: putfield 636	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   5743: aload 26
    //   5745: aload_0
    //   5746: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   5749: putfield 639	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   5752: aload 26
    //   5754: aload_0
    //   5755: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   5758: putfield 642	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   5761: aload 26
    //   5763: lconst_0
    //   5764: putfield 645	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   5767: aload 26
    //   5769: aload_0
    //   5770: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   5773: putfield 648	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   5776: aload 26
    //   5778: aload_2
    //   5779: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5782: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5785: putfield 651	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   5788: aload 26
    //   5790: aload_0
    //   5791: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   5794: invokestatic 655	com/tencent/component/network/module/base/Config:b	(Ljava/lang/String;)Z
    //   5797: putfield 658	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   5800: aload 26
    //   5802: aload_0
    //   5803: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   5806: putfield 661	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   5809: aload 26
    //   5811: aload_2
    //   5812: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5815: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5818: putfield 663	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   5821: aload_2
    //   5822: aload 26
    //   5824: invokevirtual 667	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5827: aload_0
    //   5828: aload_1
    //   5829: aload_2
    //   5830: aload 26
    //   5832: invokevirtual 320	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5835: aload_0
    //   5836: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   5839: ifeq +2436 -> 8275
    //   5842: aload_0
    //   5843: getfield 670	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   5846: ifnull +10 -> 5856
    //   5849: aload_0
    //   5850: getfield 670	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   5853: invokevirtual 675	com/squareup/okhttp/Call:cancel	()V
    //   5856: aload_0
    //   5857: aconst_null
    //   5858: putfield 368	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   5861: aload 19
    //   5863: athrow
    //   5864: lload 8
    //   5866: lstore 10
    //   5868: lload 8
    //   5870: lstore 12
    //   5872: aload_0
    //   5873: getfield 368	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   5876: ifnull +9508 -> 15384
    //   5879: lload 8
    //   5881: lstore 10
    //   5883: lload 8
    //   5885: lstore 12
    //   5887: aload_0
    //   5888: aload_0
    //   5889: getfield 782	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkUtilsHttpBaseQZoneHttp2Client	Lcom/tencent/component/network/utils/http/base/QZoneHttp2Client;
    //   5892: aload_0
    //   5893: getfield 368	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   5896: invokevirtual 788	com/squareup/okhttp/Request$Builder:build	()Lcom/squareup/okhttp/Request;
    //   5899: aload 24
    //   5901: invokevirtual 793	com/tencent/component/network/utils/http/base/QZoneHttp2Client:a	(Lcom/squareup/okhttp/Request;Lcom/tencent/component/network/utils/http/HttpUtil$RequestOptions;)Lcom/squareup/okhttp/Call;
    //   5904: putfield 670	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   5907: lload 8
    //   5909: lstore 10
    //   5911: lload 8
    //   5913: lstore 12
    //   5915: aload_0
    //   5916: getfield 670	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   5919: invokevirtual 796	com/squareup/okhttp/Call:execute	()Lcom/squareup/okhttp/Response;
    //   5922: astore 20
    //   5924: aconst_null
    //   5925: astore 19
    //   5927: aconst_null
    //   5928: astore 21
    //   5930: goto -3254 -> 2676
    //   5933: aload 20
    //   5935: ifnull +9444 -> 15379
    //   5938: aload 20
    //   5940: invokevirtual 799	com/squareup/okhttp/Response:code	()I
    //   5943: istore_3
    //   5944: goto -3218 -> 2726
    //   5947: sipush 416
    //   5950: iload_3
    //   5951: if_icmpne +1532 -> 7483
    //   5954: aload_0
    //   5955: ldc_w 801
    //   5958: invokevirtual 802	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Ljava/lang/String;)V
    //   5961: aload_2
    //   5962: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5965: bipush 7
    //   5967: invokevirtual 336	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   5970: iload_3
    //   5971: istore 5
    //   5973: aload_0
    //   5974: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5977: ifnull +20 -> 5997
    //   5980: aload_0
    //   5981: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   5984: aload_0
    //   5985: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   5988: iconst_1
    //   5989: invokeinterface 805 3 0
    //   5994: iload_3
    //   5995: istore 5
    //   5997: aload_2
    //   5998: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6001: lload 14
    //   6003: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   6006: invokevirtual 393	com/tencent/component/network/downloader/DownloadResult$Process:a	(JJ)V
    //   6009: aload_0
    //   6010: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   6013: invokestatic 398	com/tencent/component/network/module/common/NetworkStatus:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   6016: invokevirtual 401	com/tencent/component/network/module/common/NetworkStatus:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   6019: astore 24
    //   6021: aload_0
    //   6022: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6025: ifnull +8379 -> 14404
    //   6028: aload_0
    //   6029: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6032: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6035: ifnull +8369 -> 14404
    //   6038: aload_0
    //   6039: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6042: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   6045: getfield 406	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6048: astore 22
    //   6050: aload_0
    //   6051: aload_0
    //   6052: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   6055: aload 19
    //   6057: aload 20
    //   6059: invokevirtual 409	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   6062: astore 25
    //   6064: aload 21
    //   6066: ifnull +9265 -> 15331
    //   6069: aload 21
    //   6071: ldc_w 411
    //   6074: invokeinterface 417 2 0
    //   6079: checkcast 217	java/lang/String
    //   6082: astore 21
    //   6084: aload_0
    //   6085: lconst_0
    //   6086: putfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   6089: aload_0
    //   6090: iconst_0
    //   6091: putfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   6094: aload_0
    //   6095: lconst_0
    //   6096: putfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   6099: aload_0
    //   6100: iconst_0
    //   6101: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   6104: aload_2
    //   6105: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6108: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6111: ifeq +12 -> 6123
    //   6114: aload_1
    //   6115: invokeinterface 317 1 0
    //   6120: ifeq +31 -> 6151
    //   6123: aload_0
    //   6124: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   6127: ifnull +24 -> 6151
    //   6130: aload_0
    //   6131: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   6134: aload_0
    //   6135: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   6138: aload_2
    //   6139: invokevirtual 426	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   6142: aload 19
    //   6144: aload 20
    //   6146: invokeinterface 431 5 0
    //   6151: aload_1
    //   6152: invokeinterface 317 1 0
    //   6157: ifne +1292 -> 7449
    //   6160: aload_0
    //   6161: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   6164: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   6167: istore 18
    //   6169: aload_2
    //   6170: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6173: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   6176: ifne +8244 -> 14420
    //   6179: new 102	java/lang/StringBuilder
    //   6182: dup
    //   6183: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   6186: ldc_w 433
    //   6189: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6192: aload_0
    //   6193: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   6196: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6199: ldc_w 435
    //   6202: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6205: aload_0
    //   6206: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   6209: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6212: ldc_w 440
    //   6215: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6218: astore 27
    //   6220: aload_0
    //   6221: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   6224: ifeq +8811 -> 15035
    //   6227: aload 20
    //   6229: ifnull +8806 -> 15035
    //   6232: aload 20
    //   6234: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   6237: ifnull +8798 -> 15035
    //   6240: aload 20
    //   6242: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   6245: invokevirtual 449	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   6248: astore 23
    //   6250: aload 27
    //   6252: aload 23
    //   6254: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6257: ldc_w 451
    //   6260: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6263: aload 24
    //   6265: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6268: ldc_w 456
    //   6271: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6274: aload 22
    //   6276: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6279: ldc_w 458
    //   6282: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6285: aconst_null
    //   6286: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6289: ldc_w 460
    //   6292: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6295: invokestatic 147	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6298: invokevirtual 150	java/lang/Thread:getId	()J
    //   6301: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6304: ldc_w 462
    //   6307: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6310: invokestatic 134	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   6313: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6316: ldc_w 464
    //   6319: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6322: aload_0
    //   6323: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   6326: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6329: ldc_w 466
    //   6332: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6335: aload_0
    //   6336: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   6339: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6342: ldc_w 468
    //   6345: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6348: astore 27
    //   6350: aload_0
    //   6351: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   6354: ifeq +8689 -> 15043
    //   6357: aload_0
    //   6358: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   6361: aload_0
    //   6362: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   6365: invokestatic 267	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   6368: astore 23
    //   6370: aload 27
    //   6372: aload 23
    //   6374: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6377: ldc_w 470
    //   6380: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6383: iload 18
    //   6385: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6388: ldc_w 472
    //   6391: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6394: aload_2
    //   6395: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6398: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6401: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6404: ldc_w 483
    //   6407: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6410: aload_2
    //   6411: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6414: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   6417: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6420: ldc_w 487
    //   6423: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6426: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   6429: aload_0
    //   6430: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   6433: lsub
    //   6434: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6437: ldc_w 489
    //   6440: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6443: aload_2
    //   6444: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6447: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   6450: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6453: ldc_w 494
    //   6456: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6459: aload_2
    //   6460: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6463: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6466: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6469: ldc_w 498
    //   6472: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6475: aload_2
    //   6476: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6479: getfield 501	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   6482: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6485: ldc_w 503
    //   6488: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6491: aload_0
    //   6492: invokevirtual 369	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()I
    //   6495: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6498: ldc_w 505
    //   6501: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6504: aload_0
    //   6505: invokevirtual 507	com/tencent/component/network/downloader/impl/FastDownloadTask:c	()I
    //   6508: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6511: ldc_w 509
    //   6514: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6517: ldc_w 511
    //   6520: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6523: aload_2
    //   6524: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6527: invokevirtual 514	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   6530: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6533: ldc_w 516
    //   6536: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6539: iload 5
    //   6541: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6544: ldc_w 518
    //   6547: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6550: aload 25
    //   6552: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6555: ldc_w 520
    //   6558: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6561: aload 21
    //   6563: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6566: ldc_w 522
    //   6569: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6572: astore 27
    //   6574: aload_0
    //   6575: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6578: ifnull +8471 -> 15049
    //   6581: aload_0
    //   6582: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6585: iconst_0
    //   6586: bipush 30
    //   6588: invokevirtual 527	java/lang/String:substring	(II)Ljava/lang/String;
    //   6591: astore 23
    //   6593: aload 27
    //   6595: aload 23
    //   6597: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6600: ldc_w 529
    //   6603: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6606: astore 23
    //   6608: aload_0
    //   6609: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6612: ifnull +8446 -> 15058
    //   6615: aload_0
    //   6616: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6619: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   6622: istore_3
    //   6623: aload 23
    //   6625: iload_3
    //   6626: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6629: ldc_w 531
    //   6632: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6635: aload_2
    //   6636: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6639: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6642: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6645: ldc_w 536
    //   6648: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6651: lload 8
    //   6653: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6656: ldc_w 538
    //   6659: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6662: aload_0
    //   6663: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   6666: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6669: ldc_w 505
    //   6672: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6675: aload_0
    //   6676: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   6679: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6682: ldc_w 509
    //   6685: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6688: ldc_w 540
    //   6691: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6694: aload_0
    //   6695: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   6698: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6701: ldc_w 505
    //   6704: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6707: aload_0
    //   6708: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   6711: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6714: ldc_w 509
    //   6717: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6720: ldc_w 542
    //   6723: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6726: aload_0
    //   6727: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   6730: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6733: ldc_w 544
    //   6736: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6739: aload_0
    //   6740: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   6743: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6746: ldc_w 547
    //   6749: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6752: aload_0
    //   6753: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   6756: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6759: ldc_w 509
    //   6762: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6765: ldc_w 551
    //   6768: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6771: astore 27
    //   6773: aload_0
    //   6774: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6777: ifnull +8286 -> 15063
    //   6780: aload_0
    //   6781: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   6784: invokeinterface 560 1 0
    //   6789: astore 23
    //   6791: aload 26
    //   6793: aload 27
    //   6795: aload 23
    //   6797: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6800: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6803: putfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   6806: ldc_w 565
    //   6809: aload 26
    //   6811: getfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   6814: aconst_null
    //   6815: invokestatic 381	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6818: iload 18
    //   6820: ifne +8 -> 6828
    //   6823: aload_0
    //   6824: iconst_0
    //   6825: putfield 566	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_Boolean	Z
    //   6828: aload_2
    //   6829: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   6832: astore 23
    //   6834: new 102	java/lang/StringBuilder
    //   6837: dup
    //   6838: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   6841: aload_0
    //   6842: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   6845: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6848: ldc_w 568
    //   6851: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6854: aload 22
    //   6856: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6859: ldc_w 570
    //   6862: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6865: aload_2
    //   6866: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6869: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6872: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6875: ldc_w 572
    //   6878: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6881: astore 22
    //   6883: aload_0
    //   6884: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6887: ifnull +8216 -> 15103
    //   6890: aload_0
    //   6891: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6894: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   6897: istore_3
    //   6898: aload 22
    //   6900: iload_3
    //   6901: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6904: ldc_w 516
    //   6907: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6910: iload 5
    //   6912: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6915: ldc_w 472
    //   6918: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6921: aload_2
    //   6922: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6925: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6928: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6931: ldc_w 574
    //   6934: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6937: aload_2
    //   6938: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6941: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   6944: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6947: ldc_w 494
    //   6950: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6953: aload_2
    //   6954: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6957: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6960: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6963: ldc_w 483
    //   6966: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6969: aload_2
    //   6970: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6973: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   6976: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6979: ldc_w 487
    //   6982: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6985: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   6988: aload_0
    //   6989: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   6992: lsub
    //   6993: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6996: astore 22
    //   6998: aload 21
    //   7000: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7003: ifne +8105 -> 15108
    //   7006: new 102	java/lang/StringBuilder
    //   7009: dup
    //   7010: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   7013: ldc_w 520
    //   7016: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7019: aload 21
    //   7021: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7024: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7027: astore 21
    //   7029: aload 23
    //   7031: aload 22
    //   7033: aload 21
    //   7035: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7038: ldc_w 518
    //   7041: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7044: aload 25
    //   7046: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7049: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7052: putfield 577	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   7055: getstatic 173	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:d	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7058: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   7061: aload_0
    //   7062: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7065: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   7068: if_icmpne +37 -> 7105
    //   7071: aload_0
    //   7072: getfield 197	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   7075: ifnull +30 -> 7105
    //   7078: aload_0
    //   7079: getfield 197	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   7082: aload_0
    //   7083: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   7086: aload_0
    //   7087: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7090: invokestatic 580	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   7093: aload_2
    //   7094: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7097: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7100: invokeinterface 583 4 0
    //   7105: getstatic 250	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7108: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   7111: aload_0
    //   7112: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7115: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   7118: if_icmpne +37 -> 7155
    //   7121: aload_0
    //   7122: getfield 252	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   7125: ifnull +30 -> 7155
    //   7128: aload_0
    //   7129: getfield 252	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   7132: aload_0
    //   7133: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   7136: aload_0
    //   7137: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7140: invokestatic 580	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   7143: aload_2
    //   7144: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7147: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7150: invokeinterface 583 4 0
    //   7155: iload 18
    //   7157: ifeq +64 -> 7221
    //   7160: aload_0
    //   7161: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   7164: invokestatic 56	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:a	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   7167: astore 21
    //   7169: aload_0
    //   7170: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7173: astore 22
    //   7175: aload_0
    //   7176: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   7179: ifeq +7967 -> 15146
    //   7182: aload_0
    //   7183: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7186: ifnull +7960 -> 15146
    //   7189: aload_0
    //   7190: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7193: ldc_w 585
    //   7196: invokevirtual 588	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   7199: ifeq +7947 -> 15146
    //   7202: iconst_1
    //   7203: istore 18
    //   7205: aload 21
    //   7207: aload 22
    //   7209: iload 18
    //   7211: aload_2
    //   7212: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7215: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7218: invokevirtual 591	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:a	(Ljava/lang/String;ZZ)V
    //   7221: aload 26
    //   7223: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   7226: putfield 594	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   7229: aload 26
    //   7231: aload_0
    //   7232: invokevirtual 596	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()J
    //   7235: putfield 599	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   7238: aload 26
    //   7240: aload 19
    //   7242: putfield 603	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   7245: aload 26
    //   7247: aload 20
    //   7249: putfield 607	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   7252: aload 26
    //   7254: iload 5
    //   7256: putfield 610	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   7259: aload 26
    //   7261: aconst_null
    //   7262: putfield 614	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   7265: aload 24
    //   7267: ifnonnull +7885 -> 15152
    //   7270: aconst_null
    //   7271: astore 19
    //   7273: aload 26
    //   7275: aload 19
    //   7277: putfield 617	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   7280: aload 26
    //   7282: aconst_null
    //   7283: putfield 620	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   7286: aload 26
    //   7288: aload_2
    //   7289: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7292: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7295: putfield 621	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   7298: aload 26
    //   7300: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   7303: aload_0
    //   7304: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   7307: lsub
    //   7308: putfield 624	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   7311: aload 26
    //   7313: aload_2
    //   7314: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7317: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   7320: putfield 627	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   7323: aload 26
    //   7325: aload 26
    //   7327: getfield 624	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   7330: aload_2
    //   7331: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7334: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   7337: lsub
    //   7338: putfield 630	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   7341: aload 26
    //   7343: lload 8
    //   7345: putfield 633	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   7348: aload 26
    //   7350: aload_0
    //   7351: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   7354: putfield 636	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   7357: aload 26
    //   7359: aload_0
    //   7360: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   7363: putfield 639	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   7366: aload 26
    //   7368: aload_0
    //   7369: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   7372: putfield 642	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   7375: aload 26
    //   7377: lconst_0
    //   7378: putfield 645	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   7381: aload 26
    //   7383: aload_0
    //   7384: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   7387: putfield 648	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   7390: aload 26
    //   7392: aload_2
    //   7393: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7396: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7399: putfield 651	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   7402: aload 26
    //   7404: aload_0
    //   7405: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   7408: invokestatic 655	com/tencent/component/network/module/base/Config:b	(Ljava/lang/String;)Z
    //   7411: putfield 658	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   7414: aload 26
    //   7416: aload_0
    //   7417: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   7420: putfield 661	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   7423: aload 26
    //   7425: aload_2
    //   7426: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7429: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   7432: putfield 663	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   7435: aload_2
    //   7436: aload 26
    //   7438: invokevirtual 667	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   7441: aload_0
    //   7442: aload_1
    //   7443: aload_2
    //   7444: aload 26
    //   7446: invokevirtual 320	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   7449: aload_0
    //   7450: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   7453: ifeq +7709 -> 15162
    //   7456: aload_0
    //   7457: getfield 670	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   7460: ifnull +10 -> 7470
    //   7463: aload_0
    //   7464: getfield 670	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   7467: invokevirtual 675	com/squareup/okhttp/Call:cancel	()V
    //   7470: aload_0
    //   7471: aconst_null
    //   7472: putfield 368	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   7475: iload 4
    //   7477: iconst_1
    //   7478: iadd
    //   7479: istore_3
    //   7480: goto -7298 -> 182
    //   7483: aload_2
    //   7484: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7487: iconst_3
    //   7488: invokevirtual 336	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   7491: goto -1521 -> 5970
    //   7494: astore 22
    //   7496: goto -7253 -> 243
    //   7499: aload_2
    //   7500: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   7503: iconst_3
    //   7504: invokevirtual 336	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   7507: iconst_0
    //   7508: istore 5
    //   7510: goto -1513 -> 5997
    //   7513: aconst_null
    //   7514: astore 24
    //   7516: goto -3083 -> 4433
    //   7519: astore 21
    //   7521: ldc_w 378
    //   7524: astore 21
    //   7526: goto -3059 -> 4467
    //   7529: new 102	java/lang/StringBuilder
    //   7532: dup
    //   7533: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   7536: ldc_w 807
    //   7539: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7542: aload_0
    //   7543: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   7546: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7549: ldc_w 435
    //   7552: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7555: aload_0
    //   7556: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   7559: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7562: ldc_w 440
    //   7565: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7568: astore 29
    //   7570: aload_0
    //   7571: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   7574: ifeq +606 -> 8180
    //   7577: aload 22
    //   7579: ifnull +601 -> 8180
    //   7582: aload 22
    //   7584: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   7587: ifnull +593 -> 8180
    //   7590: aload 22
    //   7592: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   7595: invokevirtual 449	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   7598: astore 25
    //   7600: aload 29
    //   7602: aload 25
    //   7604: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7607: ldc_w 451
    //   7610: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7613: aload 27
    //   7615: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7618: ldc_w 456
    //   7621: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7624: aload 24
    //   7626: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7629: ldc_w 458
    //   7632: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7635: aconst_null
    //   7636: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7639: ldc_w 460
    //   7642: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7645: invokestatic 147	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   7648: invokevirtual 150	java/lang/Thread:getId	()J
    //   7651: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7654: ldc_w 462
    //   7657: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7660: invokestatic 134	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   7663: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7666: ldc_w 464
    //   7669: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7672: aload_0
    //   7673: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   7676: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7679: ldc_w 466
    //   7682: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7685: aload_0
    //   7686: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   7689: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   7692: ldc_w 468
    //   7695: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7698: astore 29
    //   7700: aload_0
    //   7701: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   7704: ifeq +484 -> 8188
    //   7707: aload_0
    //   7708: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   7711: aload_0
    //   7712: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   7715: invokestatic 267	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   7718: astore 25
    //   7720: aload 29
    //   7722: aload 25
    //   7724: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7727: ldc_w 483
    //   7730: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7733: aload_2
    //   7734: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   7737: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   7740: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7743: ldc_w 487
    //   7746: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7749: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   7752: aload_0
    //   7753: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   7756: lsub
    //   7757: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7760: ldc_w 489
    //   7763: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7766: aload_2
    //   7767: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7770: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   7773: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7776: ldc_w 494
    //   7779: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7782: aload_2
    //   7783: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7786: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   7789: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7792: ldc_w 498
    //   7795: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7798: aload_2
    //   7799: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7802: getfield 501	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   7805: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7808: ldc_w 503
    //   7811: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7814: aload_0
    //   7815: invokevirtual 369	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()I
    //   7818: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7821: ldc_w 505
    //   7824: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7827: aload_0
    //   7828: invokevirtual 507	com/tencent/component/network/downloader/impl/FastDownloadTask:c	()I
    //   7831: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7834: ldc_w 509
    //   7837: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7840: ldc_w 516
    //   7843: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7846: iload_3
    //   7847: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7850: ldc_w 518
    //   7853: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7856: aload 28
    //   7858: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7861: ldc_w 472
    //   7864: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7867: aload_2
    //   7868: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7871: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   7874: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7877: ldc_w 520
    //   7880: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7883: aload 21
    //   7885: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7888: ldc_w 522
    //   7891: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7894: astore 29
    //   7896: aload_0
    //   7897: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7900: ifnull +294 -> 8194
    //   7903: aload_0
    //   7904: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7907: iconst_0
    //   7908: bipush 30
    //   7910: invokevirtual 527	java/lang/String:substring	(II)Ljava/lang/String;
    //   7913: astore 25
    //   7915: aload 29
    //   7917: aload 25
    //   7919: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7922: ldc_w 529
    //   7925: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7928: astore 25
    //   7930: aload_0
    //   7931: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7934: ifnull +269 -> 8203
    //   7937: aload_0
    //   7938: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   7941: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   7944: istore 4
    //   7946: aload 25
    //   7948: iload 4
    //   7950: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7953: ldc_w 531
    //   7956: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7959: aload_2
    //   7960: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   7963: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   7966: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7969: ldc_w 536
    //   7972: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7975: lload 8
    //   7977: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7980: ldc_w 538
    //   7983: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7986: aload_0
    //   7987: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   7990: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7993: ldc_w 505
    //   7996: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7999: aload_0
    //   8000: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   8003: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8006: ldc_w 509
    //   8009: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8012: ldc_w 540
    //   8015: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8018: aload_0
    //   8019: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   8022: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8025: ldc_w 505
    //   8028: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8031: aload_0
    //   8032: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   8035: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8038: ldc_w 509
    //   8041: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8044: ldc_w 542
    //   8047: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8050: aload_0
    //   8051: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   8054: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8057: ldc_w 544
    //   8060: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8063: aload_0
    //   8064: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   8067: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8070: ldc_w 547
    //   8073: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8076: aload_0
    //   8077: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   8080: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8083: ldc_w 509
    //   8086: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8089: ldc_w 551
    //   8092: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8095: astore 29
    //   8097: aload_0
    //   8098: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8101: ifnull +108 -> 8209
    //   8104: aload_0
    //   8105: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8108: invokeinterface 560 1 0
    //   8113: astore 25
    //   8115: aload 26
    //   8117: aload 29
    //   8119: aload 25
    //   8121: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8124: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8127: putfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8130: ldc_w 565
    //   8133: aload 26
    //   8135: getfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8138: aconst_null
    //   8139: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8142: goto -2939 -> 5203
    //   8145: ldc_w 811
    //   8148: astore 25
    //   8150: goto -3517 -> 4633
    //   8153: aconst_null
    //   8154: astore 25
    //   8156: goto -3403 -> 4753
    //   8159: aload_0
    //   8160: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8163: astore 25
    //   8165: goto -3190 -> 4975
    //   8168: iconst_0
    //   8169: istore 4
    //   8171: goto -3165 -> 5006
    //   8174: aconst_null
    //   8175: astore 25
    //   8177: goto -3002 -> 5175
    //   8180: ldc_w 811
    //   8183: astore 25
    //   8185: goto -585 -> 7600
    //   8188: aconst_null
    //   8189: astore 25
    //   8191: goto -471 -> 7720
    //   8194: aload_0
    //   8195: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8198: astore 25
    //   8200: goto -285 -> 7915
    //   8203: iconst_0
    //   8204: istore 4
    //   8206: goto -260 -> 7946
    //   8209: aconst_null
    //   8210: astore 25
    //   8212: goto -97 -> 8115
    //   8215: iconst_0
    //   8216: istore 4
    //   8218: goto -2934 -> 5284
    //   8221: ldc_w 378
    //   8224: astore 21
    //   8226: goto -2811 -> 5415
    //   8229: astore 21
    //   8231: ldc 186
    //   8233: ldc_w 813
    //   8236: aload 21
    //   8238: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8241: goto -2750 -> 5491
    //   8244: astore 21
    //   8246: ldc 186
    //   8248: ldc_w 815
    //   8251: aload 21
    //   8253: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8256: goto -2715 -> 5541
    //   8259: iconst_0
    //   8260: istore 18
    //   8262: goto -2671 -> 5591
    //   8265: aload 27
    //   8267: invokevirtual 818	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   8270: astore 20
    //   8272: goto -2613 -> 5659
    //   8275: aload_0
    //   8276: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   8279: ifnull +15 -> 8294
    //   8282: aload_0
    //   8283: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   8286: invokevirtual 823	org/apache/http/client/methods/HttpGet:abort	()V
    //   8289: aload_0
    //   8290: aconst_null
    //   8291: putfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   8294: aload_0
    //   8295: invokevirtual 825	com/tencent/component/network/downloader/impl/FastDownloadTask:f	()V
    //   8298: goto -2437 -> 5861
    //   8301: aconst_null
    //   8302: astore 23
    //   8304: goto -7983 -> 321
    //   8307: astore 21
    //   8309: ldc_w 378
    //   8312: astore 21
    //   8314: goto -7959 -> 355
    //   8317: new 102	java/lang/StringBuilder
    //   8320: dup
    //   8321: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   8324: ldc_w 807
    //   8327: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8330: aload_0
    //   8331: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   8334: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8337: ldc_w 435
    //   8340: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8343: aload_0
    //   8344: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   8347: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8350: ldc_w 440
    //   8353: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8356: astore 28
    //   8358: aload_0
    //   8359: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   8362: ifeq +606 -> 8968
    //   8365: aload 20
    //   8367: ifnull +601 -> 8968
    //   8370: aload 20
    //   8372: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   8375: ifnull +593 -> 8968
    //   8378: aload 20
    //   8380: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   8383: invokevirtual 449	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   8386: astore 24
    //   8388: aload 28
    //   8390: aload 24
    //   8392: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8395: ldc_w 451
    //   8398: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8401: aload 25
    //   8403: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8406: ldc_w 456
    //   8409: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8412: aload 23
    //   8414: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8417: ldc_w 458
    //   8420: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8423: aconst_null
    //   8424: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8427: ldc_w 460
    //   8430: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8433: invokestatic 147	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8436: invokevirtual 150	java/lang/Thread:getId	()J
    //   8439: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8442: ldc_w 462
    //   8445: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8448: invokestatic 134	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   8451: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8454: ldc_w 464
    //   8457: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8460: aload_0
    //   8461: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   8464: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8467: ldc_w 466
    //   8470: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8473: aload_0
    //   8474: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   8477: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   8480: ldc_w 468
    //   8483: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8486: astore 28
    //   8488: aload_0
    //   8489: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   8492: ifeq +484 -> 8976
    //   8495: aload_0
    //   8496: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   8499: aload_0
    //   8500: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   8503: invokestatic 267	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   8506: astore 24
    //   8508: aload 28
    //   8510: aload 24
    //   8512: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8515: ldc_w 483
    //   8518: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8521: aload_2
    //   8522: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   8525: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   8528: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8531: ldc_w 487
    //   8534: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8537: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   8540: aload_0
    //   8541: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   8544: lsub
    //   8545: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8548: ldc_w 489
    //   8551: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8554: aload_2
    //   8555: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8558: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   8561: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8564: ldc_w 494
    //   8567: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8570: aload_2
    //   8571: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8574: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   8577: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8580: ldc_w 498
    //   8583: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8586: aload_2
    //   8587: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8590: getfield 501	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   8593: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8596: ldc_w 503
    //   8599: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8602: aload_0
    //   8603: invokevirtual 369	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()I
    //   8606: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8609: ldc_w 505
    //   8612: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8615: aload_0
    //   8616: invokevirtual 507	com/tencent/component/network/downloader/impl/FastDownloadTask:c	()I
    //   8619: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8622: ldc_w 509
    //   8625: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8628: ldc_w 516
    //   8631: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8634: iload_3
    //   8635: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8638: ldc_w 518
    //   8641: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8644: aload 27
    //   8646: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8649: ldc_w 472
    //   8652: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8655: aload_2
    //   8656: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8659: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   8662: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8665: ldc_w 520
    //   8668: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8671: aload 21
    //   8673: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8676: ldc_w 522
    //   8679: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8682: astore 28
    //   8684: aload_0
    //   8685: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8688: ifnull +294 -> 8982
    //   8691: aload_0
    //   8692: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8695: iconst_0
    //   8696: bipush 30
    //   8698: invokevirtual 527	java/lang/String:substring	(II)Ljava/lang/String;
    //   8701: astore 24
    //   8703: aload 28
    //   8705: aload 24
    //   8707: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8710: ldc_w 529
    //   8713: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8716: astore 24
    //   8718: aload_0
    //   8719: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8722: ifnull +269 -> 8991
    //   8725: aload_0
    //   8726: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   8729: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   8732: istore 4
    //   8734: aload 24
    //   8736: iload 4
    //   8738: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8741: ldc_w 531
    //   8744: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8747: aload_2
    //   8748: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   8751: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   8754: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8757: ldc_w 536
    //   8760: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8763: lload 8
    //   8765: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8768: ldc_w 538
    //   8771: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8774: aload_0
    //   8775: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   8778: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8781: ldc_w 505
    //   8784: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8787: aload_0
    //   8788: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   8791: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8794: ldc_w 509
    //   8797: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8800: ldc_w 540
    //   8803: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8806: aload_0
    //   8807: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   8810: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8813: ldc_w 505
    //   8816: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8819: aload_0
    //   8820: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   8823: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8826: ldc_w 509
    //   8829: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8832: ldc_w 542
    //   8835: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8838: aload_0
    //   8839: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   8842: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8845: ldc_w 544
    //   8848: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8851: aload_0
    //   8852: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   8855: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   8858: ldc_w 547
    //   8861: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8864: aload_0
    //   8865: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   8868: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   8871: ldc_w 509
    //   8874: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8877: ldc_w 551
    //   8880: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8883: astore 28
    //   8885: aload_0
    //   8886: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8889: ifnull +108 -> 8997
    //   8892: aload_0
    //   8893: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   8896: invokeinterface 560 1 0
    //   8901: astore 24
    //   8903: aload 26
    //   8905: aload 28
    //   8907: aload 24
    //   8909: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   8912: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8915: putfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8918: ldc_w 565
    //   8921: aload 26
    //   8923: getfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   8926: aconst_null
    //   8927: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   8930: goto -7839 -> 1091
    //   8933: ldc_w 811
    //   8936: astore 24
    //   8938: goto -8417 -> 521
    //   8941: aconst_null
    //   8942: astore 24
    //   8944: goto -8303 -> 641
    //   8947: aload_0
    //   8948: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8951: astore 24
    //   8953: goto -8090 -> 863
    //   8956: iconst_0
    //   8957: istore 4
    //   8959: goto -8065 -> 894
    //   8962: aconst_null
    //   8963: astore 24
    //   8965: goto -7902 -> 1063
    //   8968: ldc_w 811
    //   8971: astore 24
    //   8973: goto -585 -> 8388
    //   8976: aconst_null
    //   8977: astore 24
    //   8979: goto -471 -> 8508
    //   8982: aload_0
    //   8983: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8986: astore 24
    //   8988: goto -285 -> 8703
    //   8991: iconst_0
    //   8992: istore 4
    //   8994: goto -260 -> 8734
    //   8997: aconst_null
    //   8998: astore 24
    //   9000: goto -97 -> 8903
    //   9003: iconst_0
    //   9004: istore 4
    //   9006: goto -7834 -> 1172
    //   9009: ldc_w 378
    //   9012: astore 21
    //   9014: goto -7711 -> 1303
    //   9017: astore 21
    //   9019: ldc 186
    //   9021: ldc_w 813
    //   9024: aload 21
    //   9026: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9029: goto -7650 -> 1379
    //   9032: astore 21
    //   9034: ldc 186
    //   9036: ldc_w 815
    //   9039: aload 21
    //   9041: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9044: goto -7615 -> 1429
    //   9047: iconst_0
    //   9048: istore 18
    //   9050: goto -7571 -> 1479
    //   9053: aload 25
    //   9055: invokevirtual 818	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   9058: astore 19
    //   9060: goto -7513 -> 1547
    //   9063: aload_0
    //   9064: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   9067: ifnull +15 -> 9082
    //   9070: aload_0
    //   9071: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   9074: invokevirtual 823	org/apache/http/client/methods/HttpGet:abort	()V
    //   9077: aload_0
    //   9078: aconst_null
    //   9079: putfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   9082: aload_0
    //   9083: invokevirtual 825	com/tencent/component/network/downloader/impl/FastDownloadTask:f	()V
    //   9086: goto -7337 -> 1749
    //   9089: aconst_null
    //   9090: astore 22
    //   9092: goto -6226 -> 2866
    //   9095: astore 21
    //   9097: ldc_w 378
    //   9100: astore 21
    //   9102: goto -6202 -> 2900
    //   9105: new 102	java/lang/StringBuilder
    //   9108: dup
    //   9109: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   9112: ldc_w 807
    //   9115: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9118: aload_0
    //   9119: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   9122: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9125: ldc_w 435
    //   9128: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9131: aload_0
    //   9132: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   9135: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9138: ldc_w 440
    //   9141: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9144: astore 27
    //   9146: aload_0
    //   9147: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   9150: ifeq +606 -> 9756
    //   9153: aload 20
    //   9155: ifnull +601 -> 9756
    //   9158: aload 20
    //   9160: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   9163: ifnull +593 -> 9756
    //   9166: aload 20
    //   9168: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   9171: invokevirtual 449	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   9174: astore 23
    //   9176: aload 27
    //   9178: aload 23
    //   9180: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9183: ldc_w 451
    //   9186: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9189: aload 24
    //   9191: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9194: ldc_w 456
    //   9197: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9200: aload 22
    //   9202: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9205: ldc_w 458
    //   9208: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9211: aconst_null
    //   9212: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9215: ldc_w 460
    //   9218: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9221: invokestatic 147	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   9224: invokevirtual 150	java/lang/Thread:getId	()J
    //   9227: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9230: ldc_w 462
    //   9233: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9236: invokestatic 134	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   9239: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9242: ldc_w 464
    //   9245: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9248: aload_0
    //   9249: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   9252: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9255: ldc_w 466
    //   9258: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9261: aload_0
    //   9262: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   9265: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9268: ldc_w 468
    //   9271: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9274: astore 27
    //   9276: aload_0
    //   9277: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   9280: ifeq +484 -> 9764
    //   9283: aload_0
    //   9284: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9287: aload_0
    //   9288: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   9291: invokestatic 267	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   9294: astore 23
    //   9296: aload 27
    //   9298: aload 23
    //   9300: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9303: ldc_w 483
    //   9306: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9309: aload_2
    //   9310: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9313: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   9316: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9319: ldc_w 487
    //   9322: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9325: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   9328: aload_0
    //   9329: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   9332: lsub
    //   9333: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9336: ldc_w 489
    //   9339: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9342: aload_2
    //   9343: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9346: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   9349: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9352: ldc_w 494
    //   9355: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9358: aload_2
    //   9359: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9362: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   9365: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9368: ldc_w 498
    //   9371: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9374: aload_2
    //   9375: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9378: getfield 501	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   9381: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9384: ldc_w 503
    //   9387: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9390: aload_0
    //   9391: invokevirtual 369	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()I
    //   9394: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9397: ldc_w 505
    //   9400: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9403: aload_0
    //   9404: invokevirtual 507	com/tencent/component/network/downloader/impl/FastDownloadTask:c	()I
    //   9407: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9410: ldc_w 509
    //   9413: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9416: ldc_w 516
    //   9419: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9422: iload_3
    //   9423: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9426: ldc_w 518
    //   9429: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9432: aload 25
    //   9434: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9437: ldc_w 472
    //   9440: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9443: aload_2
    //   9444: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9447: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   9450: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9453: ldc_w 520
    //   9456: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9459: aload 21
    //   9461: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9464: ldc_w 522
    //   9467: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9470: astore 27
    //   9472: aload_0
    //   9473: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9476: ifnull +294 -> 9770
    //   9479: aload_0
    //   9480: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9483: iconst_0
    //   9484: bipush 30
    //   9486: invokevirtual 527	java/lang/String:substring	(II)Ljava/lang/String;
    //   9489: astore 23
    //   9491: aload 27
    //   9493: aload 23
    //   9495: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9498: ldc_w 529
    //   9501: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9504: astore 23
    //   9506: aload_0
    //   9507: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9510: ifnull +269 -> 9779
    //   9513: aload_0
    //   9514: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9517: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   9520: istore 5
    //   9522: aload 23
    //   9524: iload 5
    //   9526: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9529: ldc_w 531
    //   9532: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9535: aload_2
    //   9536: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   9539: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   9542: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9545: ldc_w 536
    //   9548: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9551: lload 8
    //   9553: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9556: ldc_w 538
    //   9559: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9562: aload_0
    //   9563: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   9566: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9569: ldc_w 505
    //   9572: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9575: aload_0
    //   9576: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   9579: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9582: ldc_w 509
    //   9585: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9588: ldc_w 540
    //   9591: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9594: aload_0
    //   9595: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   9598: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9601: ldc_w 505
    //   9604: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9607: aload_0
    //   9608: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   9611: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9614: ldc_w 509
    //   9617: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9620: ldc_w 542
    //   9623: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9626: aload_0
    //   9627: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   9630: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9633: ldc_w 544
    //   9636: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9639: aload_0
    //   9640: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   9643: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   9646: ldc_w 547
    //   9649: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9652: aload_0
    //   9653: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   9656: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9659: ldc_w 509
    //   9662: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9665: ldc_w 551
    //   9668: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9671: astore 27
    //   9673: aload_0
    //   9674: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9677: ifnull +108 -> 9785
    //   9680: aload_0
    //   9681: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   9684: invokeinterface 560 1 0
    //   9689: astore 23
    //   9691: aload 26
    //   9693: aload 27
    //   9695: aload 23
    //   9697: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   9700: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9703: putfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   9706: ldc_w 565
    //   9709: aload 26
    //   9711: getfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   9714: aconst_null
    //   9715: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9718: goto -6083 -> 3635
    //   9721: ldc_w 811
    //   9724: astore 23
    //   9726: goto -6660 -> 3066
    //   9729: aconst_null
    //   9730: astore 23
    //   9732: goto -6546 -> 3186
    //   9735: aload_0
    //   9736: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9739: astore 23
    //   9741: goto -6333 -> 3408
    //   9744: iconst_0
    //   9745: istore 5
    //   9747: goto -6308 -> 3439
    //   9750: aconst_null
    //   9751: astore 23
    //   9753: goto -6145 -> 3608
    //   9756: ldc_w 811
    //   9759: astore 23
    //   9761: goto -585 -> 9176
    //   9764: aconst_null
    //   9765: astore 23
    //   9767: goto -471 -> 9296
    //   9770: aload_0
    //   9771: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9774: astore 23
    //   9776: goto -285 -> 9491
    //   9779: iconst_0
    //   9780: istore 5
    //   9782: goto -260 -> 9522
    //   9785: aconst_null
    //   9786: astore 23
    //   9788: goto -97 -> 9691
    //   9791: iconst_0
    //   9792: istore 5
    //   9794: goto -6078 -> 3716
    //   9797: ldc_w 378
    //   9800: astore 21
    //   9802: goto -5955 -> 3847
    //   9805: astore 21
    //   9807: ldc 186
    //   9809: ldc_w 813
    //   9812: aload 21
    //   9814: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9817: goto -5894 -> 3923
    //   9820: astore 21
    //   9822: ldc 186
    //   9824: ldc_w 815
    //   9827: aload 21
    //   9829: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   9832: goto -5859 -> 3973
    //   9835: iconst_0
    //   9836: istore 18
    //   9838: goto -5815 -> 4023
    //   9841: aload 24
    //   9843: invokevirtual 818	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   9846: astore 19
    //   9848: goto -5758 -> 4090
    //   9851: aload_0
    //   9852: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   9855: ifnull +15 -> 9870
    //   9858: aload_0
    //   9859: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   9862: invokevirtual 823	org/apache/http/client/methods/HttpGet:abort	()V
    //   9865: aload_0
    //   9866: aconst_null
    //   9867: putfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   9870: aload_0
    //   9871: invokevirtual 825	com/tencent/component/network/downloader/impl/FastDownloadTask:f	()V
    //   9874: goto -5582 -> 4292
    //   9877: aload_2
    //   9878: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   9881: lload 14
    //   9883: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   9886: invokevirtual 393	com/tencent/component/network/downloader/DownloadResult$Process:a	(JJ)V
    //   9889: aload_0
    //   9890: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9893: invokestatic 398	com/tencent/component/network/module/common/NetworkStatus:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   9896: invokevirtual 401	com/tencent/component/network/module/common/NetworkStatus:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   9899: astore 24
    //   9901: aload_0
    //   9902: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9905: ifnull +1452 -> 11357
    //   9908: aload_0
    //   9909: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9912: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   9915: ifnull +1442 -> 11357
    //   9918: aload_0
    //   9919: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   9922: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   9925: getfield 406	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9928: astore 22
    //   9930: aload_0
    //   9931: aload_0
    //   9932: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   9935: aload 19
    //   9937: aload 20
    //   9939: invokevirtual 409	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   9942: astore 25
    //   9944: aload 21
    //   9946: ifnull +5401 -> 15347
    //   9949: aload 21
    //   9951: ldc_w 411
    //   9954: invokeinterface 417 2 0
    //   9959: checkcast 217	java/lang/String
    //   9962: astore 21
    //   9964: aload_0
    //   9965: lconst_0
    //   9966: putfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   9969: aload_0
    //   9970: iconst_0
    //   9971: putfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   9974: aload_0
    //   9975: lconst_0
    //   9976: putfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   9979: aload_0
    //   9980: iconst_0
    //   9981: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   9984: aload_2
    //   9985: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   9988: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   9991: ifeq +12 -> 10003
    //   9994: aload_1
    //   9995: invokeinterface 317 1 0
    //   10000: ifeq +31 -> 10031
    //   10003: aload_0
    //   10004: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   10007: ifnull +24 -> 10031
    //   10010: aload_0
    //   10011: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   10014: aload_0
    //   10015: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   10018: aload_2
    //   10019: invokevirtual 426	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   10022: aload 19
    //   10024: aload 20
    //   10026: invokeinterface 431 5 0
    //   10031: aload_1
    //   10032: invokeinterface 317 1 0
    //   10037: ifne +1293 -> 11330
    //   10040: aload_0
    //   10041: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   10044: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   10047: istore 18
    //   10049: aload_2
    //   10050: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10053: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10056: ifne +1317 -> 11373
    //   10059: new 102	java/lang/StringBuilder
    //   10062: dup
    //   10063: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   10066: ldc_w 433
    //   10069: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10072: aload_0
    //   10073: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   10076: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10079: ldc_w 435
    //   10082: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10085: aload_0
    //   10086: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   10089: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10092: ldc_w 440
    //   10095: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10098: astore 27
    //   10100: aload_0
    //   10101: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   10104: ifeq +1885 -> 11989
    //   10107: aload 20
    //   10109: ifnull +1880 -> 11989
    //   10112: aload 20
    //   10114: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   10117: ifnull +1872 -> 11989
    //   10120: aload 20
    //   10122: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   10125: invokevirtual 449	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   10128: astore 23
    //   10130: aload 27
    //   10132: aload 23
    //   10134: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10137: ldc_w 451
    //   10140: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10143: aload 24
    //   10145: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10148: ldc_w 456
    //   10151: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10154: aload 22
    //   10156: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10159: ldc_w 458
    //   10162: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10165: aconst_null
    //   10166: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10169: ldc_w 460
    //   10172: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10175: invokestatic 147	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   10178: invokevirtual 150	java/lang/Thread:getId	()J
    //   10181: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10184: ldc_w 462
    //   10187: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10190: invokestatic 134	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   10193: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10196: ldc_w 464
    //   10199: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10202: aload_0
    //   10203: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   10206: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10209: ldc_w 466
    //   10212: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10215: aload_0
    //   10216: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   10219: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10222: ldc_w 468
    //   10225: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10228: astore 27
    //   10230: aload_0
    //   10231: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   10234: ifeq +1763 -> 11997
    //   10237: aload_0
    //   10238: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   10241: aload_0
    //   10242: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   10245: invokestatic 267	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   10248: astore 23
    //   10250: aload 27
    //   10252: aload 23
    //   10254: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10257: ldc_w 470
    //   10260: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10263: iload 18
    //   10265: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   10268: ldc_w 472
    //   10271: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10274: aload_2
    //   10275: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10278: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10281: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10284: ldc_w 483
    //   10287: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10290: aload_2
    //   10291: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10294: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   10297: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10300: ldc_w 487
    //   10303: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10306: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   10309: aload_0
    //   10310: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   10313: lsub
    //   10314: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10317: ldc_w 489
    //   10320: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10323: aload_2
    //   10324: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10327: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   10330: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10333: ldc_w 494
    //   10336: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10339: aload_2
    //   10340: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10343: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10346: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10349: ldc_w 498
    //   10352: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10355: aload_2
    //   10356: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10359: getfield 501	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   10362: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10365: ldc_w 503
    //   10368: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10371: aload_0
    //   10372: invokevirtual 369	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()I
    //   10375: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10378: ldc_w 505
    //   10381: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10384: aload_0
    //   10385: invokevirtual 507	com/tencent/component/network/downloader/impl/FastDownloadTask:c	()I
    //   10388: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10391: ldc_w 509
    //   10394: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10397: ldc_w 511
    //   10400: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10403: aload_2
    //   10404: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10407: invokevirtual 514	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   10410: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10413: ldc_w 516
    //   10416: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10419: iload_3
    //   10420: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10423: ldc_w 518
    //   10426: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10429: aload 25
    //   10431: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10434: ldc_w 520
    //   10437: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10440: aload 21
    //   10442: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10445: ldc_w 522
    //   10448: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10451: astore 27
    //   10453: aload_0
    //   10454: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10457: ifnull +1546 -> 12003
    //   10460: aload_0
    //   10461: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10464: iconst_0
    //   10465: bipush 30
    //   10467: invokevirtual 527	java/lang/String:substring	(II)Ljava/lang/String;
    //   10470: astore 23
    //   10472: aload 27
    //   10474: aload 23
    //   10476: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10479: ldc_w 529
    //   10482: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10485: astore 23
    //   10487: aload_0
    //   10488: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10491: ifnull +1521 -> 12012
    //   10494: aload_0
    //   10495: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10498: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   10501: istore 4
    //   10503: aload 23
    //   10505: iload 4
    //   10507: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10510: ldc_w 531
    //   10513: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10516: aload_2
    //   10517: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10520: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10523: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10526: ldc_w 536
    //   10529: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10532: lload 8
    //   10534: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10537: ldc_w 538
    //   10540: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10543: aload_0
    //   10544: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   10547: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10550: ldc_w 505
    //   10553: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10556: aload_0
    //   10557: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   10560: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10563: ldc_w 509
    //   10566: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10569: ldc_w 540
    //   10572: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10575: aload_0
    //   10576: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   10579: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10582: ldc_w 505
    //   10585: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10588: aload_0
    //   10589: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   10592: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10595: ldc_w 509
    //   10598: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10601: ldc_w 542
    //   10604: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10607: aload_0
    //   10608: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   10611: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10614: ldc_w 544
    //   10617: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10620: aload_0
    //   10621: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   10624: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10627: ldc_w 547
    //   10630: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10633: aload_0
    //   10634: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   10637: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10640: ldc_w 509
    //   10643: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10646: ldc_w 551
    //   10649: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10652: astore 27
    //   10654: aload_0
    //   10655: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10658: ifnull +1360 -> 12018
    //   10661: aload_0
    //   10662: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   10665: invokeinterface 560 1 0
    //   10670: astore 23
    //   10672: aload 26
    //   10674: aload 27
    //   10676: aload 23
    //   10678: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   10681: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10684: putfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10687: ldc_w 565
    //   10690: aload 26
    //   10692: getfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   10695: aconst_null
    //   10696: invokestatic 381	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   10699: iload 18
    //   10701: ifne +8 -> 10709
    //   10704: aload_0
    //   10705: iconst_0
    //   10706: putfield 566	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_Boolean	Z
    //   10709: aload_2
    //   10710: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10713: astore 23
    //   10715: new 102	java/lang/StringBuilder
    //   10718: dup
    //   10719: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   10722: aload_0
    //   10723: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   10726: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10729: ldc_w 568
    //   10732: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10735: aload 22
    //   10737: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10740: ldc_w 570
    //   10743: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10746: aload_2
    //   10747: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10750: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   10753: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10756: ldc_w 572
    //   10759: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10762: astore 22
    //   10764: aload_0
    //   10765: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10768: ifnull +1291 -> 12059
    //   10771: aload_0
    //   10772: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10775: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   10778: istore 4
    //   10780: aload 22
    //   10782: iload 4
    //   10784: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10787: ldc_w 516
    //   10790: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10793: iload_3
    //   10794: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10797: ldc_w 472
    //   10800: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10803: aload_2
    //   10804: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10807: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   10810: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10813: ldc_w 574
    //   10816: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10819: aload_2
    //   10820: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10823: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   10826: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10829: ldc_w 494
    //   10832: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10835: aload_2
    //   10836: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   10839: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   10842: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10845: ldc_w 483
    //   10848: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10851: aload_2
    //   10852: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   10855: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   10858: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10861: ldc_w 487
    //   10864: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10867: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   10870: aload_0
    //   10871: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   10874: lsub
    //   10875: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   10878: astore 22
    //   10880: aload 21
    //   10882: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10885: ifne +1180 -> 12065
    //   10888: new 102	java/lang/StringBuilder
    //   10891: dup
    //   10892: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   10895: ldc_w 520
    //   10898: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10901: aload 21
    //   10903: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10906: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10909: astore 21
    //   10911: aload 23
    //   10913: aload 22
    //   10915: aload 21
    //   10917: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10920: ldc_w 518
    //   10923: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10926: aload 25
    //   10928: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10931: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10934: putfield 577	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   10937: getstatic 173	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:d	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10940: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   10943: aload_0
    //   10944: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10947: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   10950: if_icmpne +37 -> 10987
    //   10953: aload_0
    //   10954: getfield 197	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   10957: ifnull +30 -> 10987
    //   10960: aload_0
    //   10961: getfield 197	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   10964: aload_0
    //   10965: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   10968: aload_0
    //   10969: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10972: invokestatic 580	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   10975: aload_2
    //   10976: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   10979: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   10982: invokeinterface 583 4 0
    //   10987: getstatic 250	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10990: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   10993: aload_0
    //   10994: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   10997: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   11000: if_icmpne +37 -> 11037
    //   11003: aload_0
    //   11004: getfield 252	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11007: ifnull +30 -> 11037
    //   11010: aload_0
    //   11011: getfield 252	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   11014: aload_0
    //   11015: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   11018: aload_0
    //   11019: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11022: invokestatic 580	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   11025: aload_2
    //   11026: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11029: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11032: invokeinterface 583 4 0
    //   11037: iload 18
    //   11039: ifeq +64 -> 11103
    //   11042: aload_0
    //   11043: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   11046: invokestatic 56	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:a	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   11049: astore 21
    //   11051: aload_0
    //   11052: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11055: astore 22
    //   11057: aload_0
    //   11058: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   11061: ifeq +1042 -> 12103
    //   11064: aload_0
    //   11065: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11068: ifnull +1035 -> 12103
    //   11071: aload_0
    //   11072: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11075: ldc_w 585
    //   11078: invokevirtual 588	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11081: ifeq +1022 -> 12103
    //   11084: iconst_1
    //   11085: istore 18
    //   11087: aload 21
    //   11089: aload 22
    //   11091: iload 18
    //   11093: aload_2
    //   11094: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11097: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11100: invokevirtual 591	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:a	(Ljava/lang/String;ZZ)V
    //   11103: aload 26
    //   11105: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   11108: putfield 594	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   11111: aload 26
    //   11113: aload_0
    //   11114: invokevirtual 596	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()J
    //   11117: putfield 599	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   11120: aload 26
    //   11122: aload 19
    //   11124: putfield 603	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   11127: aload 26
    //   11129: aload 20
    //   11131: putfield 607	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   11134: aload 26
    //   11136: iload_3
    //   11137: putfield 610	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   11140: aload 26
    //   11142: aconst_null
    //   11143: putfield 614	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   11146: aload 24
    //   11148: ifnonnull +961 -> 12109
    //   11151: aconst_null
    //   11152: astore 19
    //   11154: aload 26
    //   11156: aload 19
    //   11158: putfield 617	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   11161: aload 26
    //   11163: aconst_null
    //   11164: putfield 620	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   11167: aload 26
    //   11169: aload_2
    //   11170: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11173: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11176: putfield 621	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   11179: aload 26
    //   11181: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   11184: aload_0
    //   11185: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   11188: lsub
    //   11189: putfield 624	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11192: aload 26
    //   11194: aload_2
    //   11195: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11198: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   11201: putfield 627	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   11204: aload 26
    //   11206: aload 26
    //   11208: getfield 624	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   11211: aload_2
    //   11212: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11215: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   11218: lsub
    //   11219: putfield 630	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   11222: aload 26
    //   11224: lload 8
    //   11226: putfield 633	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   11229: aload 26
    //   11231: aload_0
    //   11232: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   11235: putfield 636	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   11238: aload 26
    //   11240: aload_0
    //   11241: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   11244: putfield 639	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   11247: aload 26
    //   11249: aload_0
    //   11250: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   11253: putfield 642	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   11256: aload 26
    //   11258: lconst_0
    //   11259: putfield 645	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   11262: aload 26
    //   11264: aload_0
    //   11265: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   11268: putfield 648	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   11271: aload 26
    //   11273: aload_2
    //   11274: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11277: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11280: putfield 651	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   11283: aload 26
    //   11285: aload_0
    //   11286: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   11289: invokestatic 655	com/tencent/component/network/module/base/Config:b	(Ljava/lang/String;)Z
    //   11292: putfield 658	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   11295: aload 26
    //   11297: aload_0
    //   11298: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   11301: putfield 661	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   11304: aload 26
    //   11306: aload_2
    //   11307: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   11310: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   11313: putfield 663	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   11316: aload_2
    //   11317: aload 26
    //   11319: invokevirtual 667	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   11322: aload_0
    //   11323: aload_1
    //   11324: aload_2
    //   11325: aload 26
    //   11327: invokevirtual 320	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   11330: aload_0
    //   11331: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   11334: ifeq +785 -> 12119
    //   11337: aload_0
    //   11338: getfield 670	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   11341: ifnull +10 -> 11351
    //   11344: aload_0
    //   11345: getfield 670	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   11348: invokevirtual 675	com/squareup/okhttp/Call:cancel	()V
    //   11351: aload_0
    //   11352: aconst_null
    //   11353: putfield 368	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpRequest$Builder	Lcom/squareup/okhttp/Request$Builder;
    //   11356: return
    //   11357: aconst_null
    //   11358: astore 22
    //   11360: goto -1430 -> 9930
    //   11363: astore 21
    //   11365: ldc_w 378
    //   11368: astore 21
    //   11370: goto -1406 -> 9964
    //   11373: new 102	java/lang/StringBuilder
    //   11376: dup
    //   11377: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   11380: ldc_w 807
    //   11383: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11386: aload_0
    //   11387: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   11390: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11393: ldc_w 435
    //   11396: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11399: aload_0
    //   11400: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   11403: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11406: ldc_w 440
    //   11409: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11412: astore 27
    //   11414: aload_0
    //   11415: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   11418: ifeq +606 -> 12024
    //   11421: aload 20
    //   11423: ifnull +601 -> 12024
    //   11426: aload 20
    //   11428: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   11431: ifnull +593 -> 12024
    //   11434: aload 20
    //   11436: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   11439: invokevirtual 449	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   11442: astore 23
    //   11444: aload 27
    //   11446: aload 23
    //   11448: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11451: ldc_w 451
    //   11454: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11457: aload 24
    //   11459: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11462: ldc_w 456
    //   11465: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11468: aload 22
    //   11470: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11473: ldc_w 458
    //   11476: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11479: aconst_null
    //   11480: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11483: ldc_w 460
    //   11486: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11489: invokestatic 147	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11492: invokevirtual 150	java/lang/Thread:getId	()J
    //   11495: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11498: ldc_w 462
    //   11501: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11504: invokestatic 134	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   11507: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11510: ldc_w 464
    //   11513: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11516: aload_0
    //   11517: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   11520: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11523: ldc_w 466
    //   11526: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11529: aload_0
    //   11530: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   11533: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   11536: ldc_w 468
    //   11539: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11542: astore 27
    //   11544: aload_0
    //   11545: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   11548: ifeq +484 -> 12032
    //   11551: aload_0
    //   11552: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   11555: aload_0
    //   11556: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   11559: invokestatic 267	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   11562: astore 23
    //   11564: aload 27
    //   11566: aload 23
    //   11568: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11571: ldc_w 483
    //   11574: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11577: aload_2
    //   11578: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   11581: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   11584: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11587: ldc_w 487
    //   11590: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11593: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   11596: aload_0
    //   11597: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   11600: lsub
    //   11601: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11604: ldc_w 489
    //   11607: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11610: aload_2
    //   11611: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11614: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   11617: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11620: ldc_w 494
    //   11623: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11626: aload_2
    //   11627: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11630: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   11633: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11636: ldc_w 498
    //   11639: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11642: aload_2
    //   11643: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11646: getfield 501	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   11649: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11652: ldc_w 503
    //   11655: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11658: aload_0
    //   11659: invokevirtual 369	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()I
    //   11662: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11665: ldc_w 505
    //   11668: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11671: aload_0
    //   11672: invokevirtual 507	com/tencent/component/network/downloader/impl/FastDownloadTask:c	()I
    //   11675: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11678: ldc_w 509
    //   11681: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11684: ldc_w 516
    //   11687: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11690: iload_3
    //   11691: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11694: ldc_w 518
    //   11697: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11700: aload 25
    //   11702: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11705: ldc_w 472
    //   11708: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11711: aload_2
    //   11712: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11715: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   11718: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11721: ldc_w 520
    //   11724: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11727: aload 21
    //   11729: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11732: ldc_w 522
    //   11735: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11738: astore 27
    //   11740: aload_0
    //   11741: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11744: ifnull +294 -> 12038
    //   11747: aload_0
    //   11748: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   11751: iconst_0
    //   11752: bipush 30
    //   11754: invokevirtual 527	java/lang/String:substring	(II)Ljava/lang/String;
    //   11757: astore 23
    //   11759: aload 27
    //   11761: aload 23
    //   11763: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11766: ldc_w 529
    //   11769: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11772: astore 23
    //   11774: aload_0
    //   11775: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11778: ifnull +269 -> 12047
    //   11781: aload_0
    //   11782: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   11785: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   11788: istore 4
    //   11790: aload 23
    //   11792: iload 4
    //   11794: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11797: ldc_w 531
    //   11800: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11803: aload_2
    //   11804: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   11807: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   11810: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11813: ldc_w 536
    //   11816: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11819: lload 8
    //   11821: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11824: ldc_w 538
    //   11827: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11830: aload_0
    //   11831: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   11834: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11837: ldc_w 505
    //   11840: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11843: aload_0
    //   11844: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   11847: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11850: ldc_w 509
    //   11853: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11856: ldc_w 540
    //   11859: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11862: aload_0
    //   11863: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   11866: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11869: ldc_w 505
    //   11872: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11875: aload_0
    //   11876: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   11879: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11882: ldc_w 509
    //   11885: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11888: ldc_w 542
    //   11891: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11894: aload_0
    //   11895: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   11898: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11901: ldc_w 544
    //   11904: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11907: aload_0
    //   11908: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   11911: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   11914: ldc_w 547
    //   11917: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11920: aload_0
    //   11921: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   11924: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   11927: ldc_w 509
    //   11930: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11933: ldc_w 551
    //   11936: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11939: astore 27
    //   11941: aload_0
    //   11942: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11945: ifnull +108 -> 12053
    //   11948: aload_0
    //   11949: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   11952: invokeinterface 560 1 0
    //   11957: astore 23
    //   11959: aload 26
    //   11961: aload 27
    //   11963: aload 23
    //   11965: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   11968: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11971: putfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   11974: ldc_w 565
    //   11977: aload 26
    //   11979: getfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   11982: aconst_null
    //   11983: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   11986: goto -1287 -> 10699
    //   11989: ldc_w 811
    //   11992: astore 23
    //   11994: goto -1864 -> 10130
    //   11997: aconst_null
    //   11998: astore 23
    //   12000: goto -1750 -> 10250
    //   12003: aload_0
    //   12004: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12007: astore 23
    //   12009: goto -1537 -> 10472
    //   12012: iconst_0
    //   12013: istore 4
    //   12015: goto -1512 -> 10503
    //   12018: aconst_null
    //   12019: astore 23
    //   12021: goto -1349 -> 10672
    //   12024: ldc_w 811
    //   12027: astore 23
    //   12029: goto -585 -> 11444
    //   12032: aconst_null
    //   12033: astore 23
    //   12035: goto -471 -> 11564
    //   12038: aload_0
    //   12039: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12042: astore 23
    //   12044: goto -285 -> 11759
    //   12047: iconst_0
    //   12048: istore 4
    //   12050: goto -260 -> 11790
    //   12053: aconst_null
    //   12054: astore 23
    //   12056: goto -97 -> 11959
    //   12059: iconst_0
    //   12060: istore 4
    //   12062: goto -1282 -> 10780
    //   12065: ldc_w 378
    //   12068: astore 21
    //   12070: goto -1159 -> 10911
    //   12073: astore 21
    //   12075: ldc 186
    //   12077: ldc_w 813
    //   12080: aload 21
    //   12082: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12085: goto -1098 -> 10987
    //   12088: astore 21
    //   12090: ldc 186
    //   12092: ldc_w 815
    //   12095: aload 21
    //   12097: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12100: goto -1063 -> 11037
    //   12103: iconst_0
    //   12104: istore 18
    //   12106: goto -1019 -> 11087
    //   12109: aload 24
    //   12111: invokevirtual 818	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   12114: astore 19
    //   12116: goto -962 -> 11154
    //   12119: aload_0
    //   12120: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   12123: ifnull +15 -> 12138
    //   12126: aload_0
    //   12127: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   12130: invokevirtual 823	org/apache/http/client/methods/HttpGet:abort	()V
    //   12133: aload_0
    //   12134: aconst_null
    //   12135: putfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   12138: aload_0
    //   12139: invokevirtual 825	com/tencent/component/network/downloader/impl/FastDownloadTask:f	()V
    //   12142: return
    //   12143: aload_2
    //   12144: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12147: lload 14
    //   12149: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   12152: invokevirtual 393	com/tencent/component/network/downloader/DownloadResult$Process:a	(JJ)V
    //   12155: aload_0
    //   12156: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   12159: invokestatic 398	com/tencent/component/network/module/common/NetworkStatus:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/NetworkStatus;
    //   12162: invokevirtual 401	com/tencent/component/network/module/common/NetworkStatus:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   12165: astore 24
    //   12167: aload_0
    //   12168: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12171: ifnull +1449 -> 13620
    //   12174: aload_0
    //   12175: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12178: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   12181: ifnull +1439 -> 13620
    //   12184: aload_0
    //   12185: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12188: invokevirtual 404	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:a	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   12191: getfield 406	com/tencent/component/network/downloader/common/IPInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12194: astore 22
    //   12196: aload_0
    //   12197: aload_0
    //   12198: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   12201: aload 19
    //   12203: aload 20
    //   12205: invokevirtual 409	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lcom/squareup/okhttp/Response;)Ljava/lang/String;
    //   12208: astore 25
    //   12210: aload 21
    //   12212: ifnull +3127 -> 15339
    //   12215: aload 21
    //   12217: ldc_w 411
    //   12220: invokeinterface 417 2 0
    //   12225: checkcast 217	java/lang/String
    //   12228: astore 21
    //   12230: aload_0
    //   12231: lconst_0
    //   12232: putfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   12235: aload_0
    //   12236: iconst_0
    //   12237: putfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   12240: aload_0
    //   12241: lconst_0
    //   12242: putfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   12245: aload_0
    //   12246: iconst_0
    //   12247: putfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   12250: aload_2
    //   12251: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12254: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   12257: ifeq +12 -> 12269
    //   12260: aload_1
    //   12261: invokeinterface 317 1 0
    //   12266: ifeq +31 -> 12297
    //   12269: aload_0
    //   12270: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12273: ifnull +24 -> 12297
    //   12276: aload_0
    //   12277: getfield 423	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyResumeTransfer	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   12280: aload_0
    //   12281: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   12284: aload_2
    //   12285: invokevirtual 426	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   12288: aload 19
    //   12290: aload 20
    //   12292: invokeinterface 431 5 0
    //   12297: aload_1
    //   12298: invokeinterface 317 1 0
    //   12303: ifne +1293 -> 13596
    //   12306: aload_0
    //   12307: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   12310: invokestatic 324	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   12313: istore 18
    //   12315: aload_2
    //   12316: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12319: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   12322: ifne +1314 -> 13636
    //   12325: new 102	java/lang/StringBuilder
    //   12328: dup
    //   12329: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   12332: ldc_w 433
    //   12335: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12338: aload_0
    //   12339: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   12342: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12345: ldc_w 435
    //   12348: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12351: aload_0
    //   12352: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   12355: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12358: ldc_w 440
    //   12361: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12364: astore 27
    //   12366: aload_0
    //   12367: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   12370: ifeq +1882 -> 14252
    //   12373: aload 20
    //   12375: ifnull +1877 -> 14252
    //   12378: aload 20
    //   12380: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   12383: ifnull +1869 -> 14252
    //   12386: aload 20
    //   12388: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   12391: invokevirtual 449	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   12394: astore 23
    //   12396: aload 27
    //   12398: aload 23
    //   12400: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12403: ldc_w 451
    //   12406: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12409: aload 24
    //   12411: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12414: ldc_w 456
    //   12417: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12420: aload 22
    //   12422: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12425: ldc_w 458
    //   12428: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12431: aconst_null
    //   12432: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12435: ldc_w 460
    //   12438: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12441: invokestatic 147	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12444: invokevirtual 150	java/lang/Thread:getId	()J
    //   12447: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12450: ldc_w 462
    //   12453: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12456: invokestatic 134	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   12459: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12462: ldc_w 464
    //   12465: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12468: aload_0
    //   12469: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   12472: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12475: ldc_w 466
    //   12478: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12481: aload_0
    //   12482: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   12485: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12488: ldc_w 468
    //   12491: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12494: astore 27
    //   12496: aload_0
    //   12497: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   12500: ifeq +1760 -> 14260
    //   12503: aload_0
    //   12504: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   12507: aload_0
    //   12508: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   12511: invokestatic 267	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   12514: astore 23
    //   12516: aload 27
    //   12518: aload 23
    //   12520: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12523: ldc_w 470
    //   12526: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12529: iload 18
    //   12531: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   12534: ldc_w 472
    //   12537: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12540: aload_2
    //   12541: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12544: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   12547: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12550: ldc_w 483
    //   12553: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12556: aload_2
    //   12557: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   12560: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   12563: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12566: ldc_w 487
    //   12569: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12572: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   12575: aload_0
    //   12576: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   12579: lsub
    //   12580: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12583: ldc_w 489
    //   12586: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12589: aload_2
    //   12590: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12593: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   12596: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12599: ldc_w 494
    //   12602: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12605: aload_2
    //   12606: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12609: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   12612: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12615: ldc_w 498
    //   12618: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12621: aload_2
    //   12622: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12625: getfield 501	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   12628: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12631: ldc_w 503
    //   12634: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12637: aload_0
    //   12638: invokevirtual 369	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()I
    //   12641: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12644: ldc_w 505
    //   12647: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12650: aload_0
    //   12651: invokevirtual 507	com/tencent/component/network/downloader/impl/FastDownloadTask:c	()I
    //   12654: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12657: ldc_w 509
    //   12660: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12663: ldc_w 511
    //   12666: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12669: aload_2
    //   12670: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12673: invokevirtual 514	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   12676: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12679: ldc_w 516
    //   12682: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12685: iload_3
    //   12686: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12689: ldc_w 518
    //   12692: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12695: aload 25
    //   12697: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12700: ldc_w 520
    //   12703: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12706: aload 21
    //   12708: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12711: ldc_w 522
    //   12714: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12717: astore 27
    //   12719: aload_0
    //   12720: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12723: ifnull +1543 -> 14266
    //   12726: aload_0
    //   12727: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12730: iconst_0
    //   12731: bipush 30
    //   12733: invokevirtual 527	java/lang/String:substring	(II)Ljava/lang/String;
    //   12736: astore 23
    //   12738: aload 27
    //   12740: aload 23
    //   12742: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12745: ldc_w 529
    //   12748: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12751: astore 23
    //   12753: aload_0
    //   12754: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12757: ifnull +1518 -> 14275
    //   12760: aload_0
    //   12761: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   12764: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   12767: istore 4
    //   12769: aload 23
    //   12771: iload 4
    //   12773: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12776: ldc_w 531
    //   12779: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12782: aload_2
    //   12783: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   12786: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   12789: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12792: ldc_w 536
    //   12795: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12798: lload 8
    //   12800: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12803: ldc_w 538
    //   12806: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12809: aload_0
    //   12810: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   12813: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12816: ldc_w 505
    //   12819: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12822: aload_0
    //   12823: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   12826: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12829: ldc_w 509
    //   12832: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12835: ldc_w 540
    //   12838: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12841: aload_0
    //   12842: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   12845: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12848: ldc_w 505
    //   12851: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12854: aload_0
    //   12855: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   12858: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12861: ldc_w 509
    //   12864: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12867: ldc_w 542
    //   12870: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12873: aload_0
    //   12874: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   12877: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12880: ldc_w 544
    //   12883: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12886: aload_0
    //   12887: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   12890: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12893: ldc_w 547
    //   12896: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12899: aload_0
    //   12900: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   12903: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12906: ldc_w 509
    //   12909: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12912: ldc_w 551
    //   12915: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12918: astore 27
    //   12920: aload_0
    //   12921: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12924: ifnull +1357 -> 14281
    //   12927: aload_0
    //   12928: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   12931: invokeinterface 560 1 0
    //   12936: astore 23
    //   12938: aload 26
    //   12940: aload 27
    //   12942: aload 23
    //   12944: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12947: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12950: putfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12953: ldc_w 565
    //   12956: aload 26
    //   12958: getfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   12961: aconst_null
    //   12962: invokestatic 381	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   12965: iload 18
    //   12967: ifne +8 -> 12975
    //   12970: aload_0
    //   12971: iconst_0
    //   12972: putfield 566	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_Boolean	Z
    //   12975: aload_2
    //   12976: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   12979: astore 23
    //   12981: new 102	java/lang/StringBuilder
    //   12984: dup
    //   12985: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   12988: aload_0
    //   12989: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   12992: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12995: ldc_w 568
    //   12998: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13001: aload 22
    //   13003: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13006: ldc_w 570
    //   13009: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13012: aload_2
    //   13013: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13016: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13019: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13022: ldc_w 572
    //   13025: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13028: astore 22
    //   13030: aload_0
    //   13031: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13034: ifnull +1288 -> 14322
    //   13037: aload_0
    //   13038: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13041: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   13044: istore 4
    //   13046: aload 22
    //   13048: iload 4
    //   13050: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13053: ldc_w 516
    //   13056: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13059: iload_3
    //   13060: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13063: ldc_w 472
    //   13066: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13069: aload_2
    //   13070: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13073: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13076: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13079: ldc_w 574
    //   13082: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13085: aload_2
    //   13086: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13089: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13092: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13095: ldc_w 494
    //   13098: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13101: aload_2
    //   13102: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13105: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13108: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13111: ldc_w 483
    //   13114: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13117: aload_2
    //   13118: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13121: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   13124: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13127: ldc_w 487
    //   13130: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13133: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   13136: aload_0
    //   13137: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   13140: lsub
    //   13141: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13144: astore 22
    //   13146: aload 21
    //   13148: invokestatic 214	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13151: ifne +1177 -> 14328
    //   13154: new 102	java/lang/StringBuilder
    //   13157: dup
    //   13158: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   13161: ldc_w 520
    //   13164: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13167: aload 21
    //   13169: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13172: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13175: astore 21
    //   13177: aload 23
    //   13179: aload 22
    //   13181: aload 21
    //   13183: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13186: ldc_w 518
    //   13189: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13192: aload 25
    //   13194: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13197: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13200: putfield 577	com/tencent/component/network/downloader/DownloadResult$Status:detailDownloadInfo	Ljava/lang/String;
    //   13203: getstatic 173	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:d	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13206: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   13209: aload_0
    //   13210: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13213: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   13216: if_icmpne +37 -> 13253
    //   13219: aload_0
    //   13220: getfield 197	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13223: ifnull +30 -> 13253
    //   13226: aload_0
    //   13227: getfield 197	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13230: aload_0
    //   13231: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   13234: aload_0
    //   13235: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   13238: invokestatic 580	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   13241: aload_2
    //   13242: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13245: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13248: invokeinterface 583 4 0
    //   13253: getstatic 250	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13256: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   13259: aload_0
    //   13260: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   13263: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   13266: if_icmpne +37 -> 13303
    //   13269: aload_0
    //   13270: getfield 252	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13273: ifnull +30 -> 13303
    //   13276: aload_0
    //   13277: getfield 252	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyIPStrategy	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   13280: aload_0
    //   13281: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   13284: aload_0
    //   13285: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   13288: invokestatic 580	com/tencent/component/network/downloader/common/Utils:getDomin	(Ljava/lang/String;)Ljava/lang/String;
    //   13291: aload_2
    //   13292: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13295: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13298: invokeinterface 583 4 0
    //   13303: iload 18
    //   13305: ifeq +64 -> 13369
    //   13308: aload_0
    //   13309: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   13312: invokestatic 56	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:a	(Landroid/content/Context;)Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy;
    //   13315: astore 21
    //   13317: aload_0
    //   13318: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   13321: astore 22
    //   13323: aload_0
    //   13324: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   13327: ifeq +1039 -> 14366
    //   13330: aload_0
    //   13331: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   13334: ifnull +1032 -> 14366
    //   13337: aload_0
    //   13338: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   13341: ldc_w 585
    //   13344: invokevirtual 588	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   13347: ifeq +1019 -> 14366
    //   13350: iconst_1
    //   13351: istore 18
    //   13353: aload 21
    //   13355: aload 22
    //   13357: iload 18
    //   13359: aload_2
    //   13360: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13363: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13366: invokevirtual 591	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:a	(Ljava/lang/String;ZZ)V
    //   13369: aload 26
    //   13371: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   13374: putfield 594	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   13377: aload 26
    //   13379: aload_0
    //   13380: invokevirtual 596	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()J
    //   13383: putfield 599	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   13386: aload 26
    //   13388: aload 19
    //   13390: putfield 603	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   13393: aload 26
    //   13395: aload 20
    //   13397: putfield 607	com/tencent/component/network/downloader/DownloadReport:okResponse	Lcom/squareup/okhttp/Response;
    //   13400: aload 26
    //   13402: iload_3
    //   13403: putfield 610	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   13406: aload 26
    //   13408: aconst_null
    //   13409: putfield 614	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   13412: aload 24
    //   13414: ifnonnull +958 -> 14372
    //   13417: aconst_null
    //   13418: astore 19
    //   13420: aload 26
    //   13422: aload 19
    //   13424: putfield 617	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   13427: aload 26
    //   13429: aconst_null
    //   13430: putfield 620	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   13433: aload 26
    //   13435: aload_2
    //   13436: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13439: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   13442: putfield 621	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   13445: aload 26
    //   13447: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   13450: aload_0
    //   13451: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   13454: lsub
    //   13455: putfield 624	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   13458: aload 26
    //   13460: aload_2
    //   13461: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13464: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   13467: putfield 627	com/tencent/component/network/downloader/DownloadReport:downloadTime	J
    //   13470: aload 26
    //   13472: aload 26
    //   13474: getfield 624	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   13477: aload_2
    //   13478: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13481: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   13484: lsub
    //   13485: putfield 630	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   13488: aload 26
    //   13490: lload 8
    //   13492: putfield 633	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   13495: aload 26
    //   13497: aload_0
    //   13498: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   13501: putfield 636	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   13504: aload 26
    //   13506: aload_0
    //   13507: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   13510: putfield 639	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   13513: aload 26
    //   13515: aload_0
    //   13516: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   13519: putfield 642	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   13522: aload 26
    //   13524: lconst_0
    //   13525: putfield 645	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   13528: aload 26
    //   13530: aload_0
    //   13531: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   13534: putfield 648	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   13537: aload 26
    //   13539: aload_2
    //   13540: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13543: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13546: putfield 651	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   13549: aload 26
    //   13551: aload_0
    //   13552: invokevirtual 45	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()Ljava/lang/String;
    //   13555: invokestatic 655	com/tencent/component/network/module/base/Config:b	(Ljava/lang/String;)Z
    //   13558: putfield 658	com/tencent/component/network/downloader/DownloadReport:isFromQzoneAlbum	Z
    //   13561: aload 26
    //   13563: aload_0
    //   13564: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   13567: putfield 661	com/tencent/component/network/downloader/DownloadReport:isHttp2	Z
    //   13570: aload 26
    //   13572: aload_2
    //   13573: invokevirtual 331	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   13576: invokevirtual 420	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   13579: putfield 663	com/tencent/component/network/downloader/DownloadReport:isSucceed	Z
    //   13582: aload_2
    //   13583: aload 26
    //   13585: invokevirtual 667	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   13588: aload_0
    //   13589: aload_1
    //   13590: aload_2
    //   13591: aload 26
    //   13593: invokevirtual 320	com/tencent/component/network/downloader/impl/FastDownloadTask:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   13596: aload_0
    //   13597: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   13600: ifeq +782 -> 14382
    //   13603: aload_0
    //   13604: getfield 670	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   13607: ifnull -2256 -> 11351
    //   13610: aload_0
    //   13611: getfield 670	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComSquareupOkhttpCall	Lcom/squareup/okhttp/Call;
    //   13614: invokevirtual 675	com/squareup/okhttp/Call:cancel	()V
    //   13617: goto -2266 -> 11351
    //   13620: aconst_null
    //   13621: astore 22
    //   13623: goto -1427 -> 12196
    //   13626: astore 21
    //   13628: ldc_w 378
    //   13631: astore 21
    //   13633: goto -1403 -> 12230
    //   13636: new 102	java/lang/StringBuilder
    //   13639: dup
    //   13640: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   13643: ldc_w 807
    //   13646: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13649: aload_0
    //   13650: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   13653: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13656: ldc_w 435
    //   13659: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13662: aload_0
    //   13663: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   13666: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13669: ldc_w 440
    //   13672: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13675: astore 27
    //   13677: aload_0
    //   13678: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   13681: ifeq +606 -> 14287
    //   13684: aload 20
    //   13686: ifnull +601 -> 14287
    //   13689: aload 20
    //   13691: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   13694: ifnull +593 -> 14287
    //   13697: aload 20
    //   13699: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   13702: invokevirtual 449	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   13705: astore 23
    //   13707: aload 27
    //   13709: aload 23
    //   13711: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13714: ldc_w 451
    //   13717: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13720: aload 24
    //   13722: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13725: ldc_w 456
    //   13728: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13731: aload 22
    //   13733: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13736: ldc_w 458
    //   13739: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13742: aconst_null
    //   13743: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13746: ldc_w 460
    //   13749: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13752: invokestatic 147	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   13755: invokevirtual 150	java/lang/Thread:getId	()J
    //   13758: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13761: ldc_w 462
    //   13764: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13767: invokestatic 134	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   13770: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13773: ldc_w 464
    //   13776: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13779: aload_0
    //   13780: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   13783: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13786: ldc_w 466
    //   13789: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13792: aload_0
    //   13793: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   13796: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   13799: ldc_w 468
    //   13802: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13805: astore 27
    //   13807: aload_0
    //   13808: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   13811: ifeq +484 -> 14295
    //   13814: aload_0
    //   13815: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   13818: aload_0
    //   13819: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   13822: invokestatic 267	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   13825: astore 23
    //   13827: aload 27
    //   13829: aload 23
    //   13831: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   13834: ldc_w 483
    //   13837: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13840: aload_2
    //   13841: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   13844: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   13847: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13850: ldc_w 487
    //   13853: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13856: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   13859: aload_0
    //   13860: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   13863: lsub
    //   13864: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13867: ldc_w 489
    //   13870: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13873: aload_2
    //   13874: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13877: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   13880: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13883: ldc_w 494
    //   13886: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13889: aload_2
    //   13890: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13893: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   13896: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13899: ldc_w 498
    //   13902: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13905: aload_2
    //   13906: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13909: getfield 501	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   13912: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13915: ldc_w 503
    //   13918: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13921: aload_0
    //   13922: invokevirtual 369	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()I
    //   13925: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13928: ldc_w 505
    //   13931: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13934: aload_0
    //   13935: invokevirtual 507	com/tencent/component/network/downloader/impl/FastDownloadTask:c	()I
    //   13938: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13941: ldc_w 509
    //   13944: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13947: ldc_w 516
    //   13950: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13953: iload_3
    //   13954: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13957: ldc_w 518
    //   13960: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13963: aload 25
    //   13965: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13968: ldc_w 472
    //   13971: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13974: aload_2
    //   13975: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   13978: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   13981: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13984: ldc_w 520
    //   13987: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13990: aload 21
    //   13992: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13995: ldc_w 522
    //   13998: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14001: astore 27
    //   14003: aload_0
    //   14004: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14007: ifnull +294 -> 14301
    //   14010: aload_0
    //   14011: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14014: iconst_0
    //   14015: bipush 30
    //   14017: invokevirtual 527	java/lang/String:substring	(II)Ljava/lang/String;
    //   14020: astore 23
    //   14022: aload 27
    //   14024: aload 23
    //   14026: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14029: ldc_w 529
    //   14032: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14035: astore 23
    //   14037: aload_0
    //   14038: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14041: ifnull +269 -> 14310
    //   14044: aload_0
    //   14045: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14048: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   14051: istore 4
    //   14053: aload 23
    //   14055: iload 4
    //   14057: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14060: ldc_w 531
    //   14063: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14066: aload_2
    //   14067: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14070: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   14073: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14076: ldc_w 536
    //   14079: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14082: lload 8
    //   14084: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14087: ldc_w 538
    //   14090: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14093: aload_0
    //   14094: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   14097: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14100: ldc_w 505
    //   14103: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14106: aload_0
    //   14107: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   14110: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14113: ldc_w 509
    //   14116: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14119: ldc_w 540
    //   14122: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14125: aload_0
    //   14126: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   14129: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14132: ldc_w 505
    //   14135: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14138: aload_0
    //   14139: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   14142: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14145: ldc_w 509
    //   14148: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14151: ldc_w 542
    //   14154: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14157: aload_0
    //   14158: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   14161: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14164: ldc_w 544
    //   14167: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14170: aload_0
    //   14171: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   14174: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14177: ldc_w 547
    //   14180: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14183: aload_0
    //   14184: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   14187: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14190: ldc_w 509
    //   14193: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14196: ldc_w 551
    //   14199: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14202: astore 27
    //   14204: aload_0
    //   14205: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   14208: ifnull +108 -> 14316
    //   14211: aload_0
    //   14212: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   14215: invokeinterface 560 1 0
    //   14220: astore 23
    //   14222: aload 26
    //   14224: aload 27
    //   14226: aload 23
    //   14228: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14231: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14234: putfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   14237: ldc_w 565
    //   14240: aload 26
    //   14242: getfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   14245: aconst_null
    //   14246: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   14249: goto -1284 -> 12965
    //   14252: ldc_w 811
    //   14255: astore 23
    //   14257: goto -1861 -> 12396
    //   14260: aconst_null
    //   14261: astore 23
    //   14263: goto -1747 -> 12516
    //   14266: aload_0
    //   14267: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14270: astore 23
    //   14272: goto -1534 -> 12738
    //   14275: iconst_0
    //   14276: istore 4
    //   14278: goto -1509 -> 12769
    //   14281: aconst_null
    //   14282: astore 23
    //   14284: goto -1346 -> 12938
    //   14287: ldc_w 811
    //   14290: astore 23
    //   14292: goto -585 -> 13707
    //   14295: aconst_null
    //   14296: astore 23
    //   14298: goto -471 -> 13827
    //   14301: aload_0
    //   14302: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14305: astore 23
    //   14307: goto -285 -> 14022
    //   14310: iconst_0
    //   14311: istore 4
    //   14313: goto -260 -> 14053
    //   14316: aconst_null
    //   14317: astore 23
    //   14319: goto -97 -> 14222
    //   14322: iconst_0
    //   14323: istore 4
    //   14325: goto -1279 -> 13046
    //   14328: ldc_w 378
    //   14331: astore 21
    //   14333: goto -1156 -> 13177
    //   14336: astore 21
    //   14338: ldc 186
    //   14340: ldc_w 813
    //   14343: aload 21
    //   14345: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   14348: goto -1095 -> 13253
    //   14351: astore 21
    //   14353: ldc 186
    //   14355: ldc_w 815
    //   14358: aload 21
    //   14360: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   14363: goto -1060 -> 13303
    //   14366: iconst_0
    //   14367: istore 18
    //   14369: goto -1016 -> 13353
    //   14372: aload 24
    //   14374: invokevirtual 818	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   14377: astore 19
    //   14379: goto -959 -> 13420
    //   14382: aload_0
    //   14383: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   14386: ifnull -2248 -> 12138
    //   14389: aload_0
    //   14390: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   14393: invokevirtual 823	org/apache/http/client/methods/HttpGet:abort	()V
    //   14396: aload_0
    //   14397: aconst_null
    //   14398: putfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   14401: goto -2263 -> 12138
    //   14404: aconst_null
    //   14405: astore 22
    //   14407: goto -8357 -> 6050
    //   14410: astore 21
    //   14412: ldc_w 378
    //   14415: astore 21
    //   14417: goto -8333 -> 6084
    //   14420: new 102	java/lang/StringBuilder
    //   14423: dup
    //   14424: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   14427: ldc_w 807
    //   14430: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14433: aload_0
    //   14434: invokevirtual 58	com/tencent/component/network/downloader/impl/FastDownloadTask:a	()Ljava/lang/String;
    //   14437: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14440: ldc_w 435
    //   14443: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14446: aload_0
    //   14447: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   14450: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14453: ldc_w 440
    //   14456: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14459: astore 27
    //   14461: aload_0
    //   14462: getfield 60	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_Boolean	Z
    //   14465: ifeq +604 -> 15069
    //   14468: aload 20
    //   14470: ifnull +599 -> 15069
    //   14473: aload 20
    //   14475: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   14478: ifnull +591 -> 15069
    //   14481: aload 20
    //   14483: invokevirtual 446	com/squareup/okhttp/Response:protocol	()Lcom/squareup/okhttp/Protocol;
    //   14486: invokevirtual 449	com/squareup/okhttp/Protocol:toString	()Ljava/lang/String;
    //   14489: astore 23
    //   14491: aload 27
    //   14493: aload 23
    //   14495: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14498: ldc_w 451
    //   14501: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14504: aload 24
    //   14506: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14509: ldc_w 456
    //   14512: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14515: aload 22
    //   14517: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14520: ldc_w 458
    //   14523: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14526: aconst_null
    //   14527: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14530: ldc_w 460
    //   14533: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14536: invokestatic 147	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   14539: invokevirtual 150	java/lang/Thread:getId	()J
    //   14542: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14545: ldc_w 462
    //   14548: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14551: invokestatic 134	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   14554: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14557: ldc_w 464
    //   14560: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14563: aload_0
    //   14564: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   14567: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14570: ldc_w 466
    //   14573: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14576: aload_0
    //   14577: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   14580: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   14583: ldc_w 468
    //   14586: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14589: astore 27
    //   14591: aload_0
    //   14592: getfield 161	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Boolean	Z
    //   14595: ifeq +482 -> 15077
    //   14598: aload_0
    //   14599: getfield 51	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   14602: aload_0
    //   14603: getfield 164	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Boolean	Z
    //   14606: invokestatic 267	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Ljava/net/Proxy;
    //   14609: astore 23
    //   14611: aload 27
    //   14613: aload 23
    //   14615: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14618: ldc_w 483
    //   14621: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14624: aload_2
    //   14625: invokevirtual 388	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   14628: getfield 485	com/tencent/component/network/downloader/DownloadResult$Process:jdField_c_of_type_Long	J
    //   14631: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14634: ldc_w 487
    //   14637: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14640: invokestatic 26	android/os/SystemClock:uptimeMillis	()J
    //   14643: aload_0
    //   14644: getfield 28	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_g_of_type_Long	J
    //   14647: lsub
    //   14648: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14651: ldc_w 489
    //   14654: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14657: aload_2
    //   14658: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14661: getfield 492	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   14664: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14667: ldc_w 494
    //   14670: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14673: aload_2
    //   14674: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14677: getfield 496	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   14680: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14683: ldc_w 498
    //   14686: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14689: aload_2
    //   14690: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14693: getfield 501	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   14696: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14699: ldc_w 503
    //   14702: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14705: aload_0
    //   14706: invokevirtual 369	com/tencent/component/network/downloader/impl/FastDownloadTask:b	()I
    //   14709: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14712: ldc_w 505
    //   14715: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14718: aload_0
    //   14719: invokevirtual 507	com/tencent/component/network/downloader/impl/FastDownloadTask:c	()I
    //   14722: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14725: ldc_w 509
    //   14728: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14731: ldc_w 516
    //   14734: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14737: iload 5
    //   14739: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14742: ldc_w 518
    //   14745: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14748: aload 25
    //   14750: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14753: ldc_w 472
    //   14756: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14759: aload_2
    //   14760: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14763: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   14766: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14769: ldc_w 520
    //   14772: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14775: aload 21
    //   14777: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14780: ldc_w 522
    //   14783: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14786: astore 27
    //   14788: aload_0
    //   14789: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14792: ifnull +291 -> 15083
    //   14795: aload_0
    //   14796: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14799: iconst_0
    //   14800: bipush 30
    //   14802: invokevirtual 527	java/lang/String:substring	(II)Ljava/lang/String;
    //   14805: astore 23
    //   14807: aload 27
    //   14809: aload 23
    //   14811: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14814: ldc_w 529
    //   14817: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14820: astore 23
    //   14822: aload_0
    //   14823: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14826: ifnull +266 -> 15092
    //   14829: aload_0
    //   14830: getfield 66	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   14833: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:jdField_a_of_type_Int	I
    //   14836: istore_3
    //   14837: aload 23
    //   14839: iload_3
    //   14840: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14843: ldc_w 531
    //   14846: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14849: aload_2
    //   14850: invokevirtual 476	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   14853: getfield 534	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   14856: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14859: ldc_w 536
    //   14862: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14865: lload 8
    //   14867: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14870: ldc_w 538
    //   14873: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14876: aload_0
    //   14877: getfield 32	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_d_of_type_Long	J
    //   14880: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14883: ldc_w 505
    //   14886: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14889: aload_0
    //   14890: getfield 34	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Int	I
    //   14893: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14896: ldc_w 509
    //   14899: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14902: ldc_w 540
    //   14905: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14908: aload_0
    //   14909: getfield 36	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_e_of_type_Long	J
    //   14912: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14915: ldc_w 505
    //   14918: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14921: aload_0
    //   14922: getfield 38	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Int	I
    //   14925: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14928: ldc_w 509
    //   14931: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14934: ldc_w 542
    //   14937: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14940: aload_0
    //   14941: getfield 40	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_f_of_type_Long	J
    //   14944: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14947: ldc_w 544
    //   14950: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14953: aload_0
    //   14954: getfield 545	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_c_of_type_Long	J
    //   14957: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14960: ldc_w 547
    //   14963: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14966: aload_0
    //   14967: invokevirtual 549	com/tencent/component/network/downloader/impl/FastDownloadTask:d	()I
    //   14970: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14973: ldc_w 509
    //   14976: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14979: ldc_w 551
    //   14982: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14985: astore 27
    //   14987: aload_0
    //   14988: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   14991: ifnull +106 -> 15097
    //   14994: aload_0
    //   14995: getfield 554	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_ComTencentComponentNetworkDownloaderImplDownloadTask$DownloadTaskHandler	Lcom/tencent/component/network/downloader/impl/DownloadTask$DownloadTaskHandler;
    //   14998: invokeinterface 560 1 0
    //   15003: astore 23
    //   15005: aload 26
    //   15007: aload 27
    //   15009: aload 23
    //   15011: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15014: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15017: putfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15020: ldc_w 565
    //   15023: aload 26
    //   15025: getfield 563	com/tencent/component/network/downloader/DownloadReport:logInfo	Ljava/lang/String;
    //   15028: aconst_null
    //   15029: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15032: goto -8214 -> 6818
    //   15035: ldc_w 811
    //   15038: astore 23
    //   15040: goto -8790 -> 6250
    //   15043: aconst_null
    //   15044: astore 23
    //   15046: goto -8676 -> 6370
    //   15049: aload_0
    //   15050: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15053: astore 23
    //   15055: goto -8462 -> 6593
    //   15058: iconst_0
    //   15059: istore_3
    //   15060: goto -8437 -> 6623
    //   15063: aconst_null
    //   15064: astore 23
    //   15066: goto -8275 -> 6791
    //   15069: ldc_w 811
    //   15072: astore 23
    //   15074: goto -583 -> 14491
    //   15077: aconst_null
    //   15078: astore 23
    //   15080: goto -469 -> 14611
    //   15083: aload_0
    //   15084: getfield 523	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15087: astore 23
    //   15089: goto -282 -> 14807
    //   15092: iconst_0
    //   15093: istore_3
    //   15094: goto -257 -> 14837
    //   15097: aconst_null
    //   15098: astore 23
    //   15100: goto -95 -> 15005
    //   15103: iconst_0
    //   15104: istore_3
    //   15105: goto -8207 -> 6898
    //   15108: ldc_w 378
    //   15111: astore 21
    //   15113: goto -8084 -> 7029
    //   15116: astore 21
    //   15118: ldc 186
    //   15120: ldc_w 813
    //   15123: aload 21
    //   15125: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15128: goto -8023 -> 7105
    //   15131: astore 21
    //   15133: ldc 186
    //   15135: ldc_w 815
    //   15138: aload 21
    //   15140: invokestatic 809	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15143: goto -7988 -> 7155
    //   15146: iconst_0
    //   15147: istore 18
    //   15149: goto -7944 -> 7205
    //   15152: aload 24
    //   15154: invokevirtual 818	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   15157: astore 19
    //   15159: goto -7886 -> 7273
    //   15162: aload_0
    //   15163: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   15166: ifnull +15 -> 15181
    //   15169: aload_0
    //   15170: getfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   15173: invokevirtual 823	org/apache/http/client/methods/HttpGet:abort	()V
    //   15176: aload_0
    //   15177: aconst_null
    //   15178: putfield 365	com/tencent/component/network/downloader/impl/FastDownloadTask:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   15181: aload_0
    //   15182: invokevirtual 825	com/tencent/component/network/downloader/impl/FastDownloadTask:f	()V
    //   15185: goto -7710 -> 7475
    //   15188: astore 24
    //   15190: aconst_null
    //   15191: astore 20
    //   15193: aload 19
    //   15195: astore 21
    //   15197: aload 24
    //   15199: astore 19
    //   15201: iload 6
    //   15203: istore_3
    //   15204: goto -10824 -> 4380
    //   15207: astore 24
    //   15209: aload 19
    //   15211: astore 23
    //   15213: aload 20
    //   15215: astore 22
    //   15217: aload 24
    //   15219: astore 19
    //   15221: aconst_null
    //   15222: astore 20
    //   15224: iload 6
    //   15226: istore_3
    //   15227: goto -10847 -> 4380
    //   15230: astore 24
    //   15232: aload 19
    //   15234: astore 23
    //   15236: aload 20
    //   15238: astore 22
    //   15240: aload 24
    //   15242: astore 19
    //   15244: aconst_null
    //   15245: astore 20
    //   15247: goto -10867 -> 4380
    //   15250: astore 25
    //   15252: aconst_null
    //   15253: astore 24
    //   15255: aload 20
    //   15257: astore 22
    //   15259: aload 19
    //   15261: astore 23
    //   15263: aload 25
    //   15265: astore 19
    //   15267: aload 24
    //   15269: astore 20
    //   15271: goto -10891 -> 4380
    //   15274: astore 25
    //   15276: aload 20
    //   15278: astore 23
    //   15280: aload 19
    //   15282: astore 24
    //   15284: aload 22
    //   15286: astore 20
    //   15288: aload 25
    //   15290: astore 19
    //   15292: aload 23
    //   15294: astore 22
    //   15296: aload 24
    //   15298: astore 23
    //   15300: goto -10920 -> 4380
    //   15303: astore 22
    //   15305: iconst_0
    //   15306: istore_3
    //   15307: aconst_null
    //   15308: astore 20
    //   15310: aconst_null
    //   15311: astore 23
    //   15313: aload 19
    //   15315: astore 21
    //   15317: aload 23
    //   15319: astore 19
    //   15321: goto -15078 -> 243
    //   15324: astore 22
    //   15326: iconst_0
    //   15327: istore_3
    //   15328: goto -15085 -> 243
    //   15331: ldc_w 378
    //   15334: astore 21
    //   15336: goto -9252 -> 6084
    //   15339: ldc_w 378
    //   15342: astore 21
    //   15344: goto -3114 -> 12230
    //   15347: ldc_w 378
    //   15350: astore 21
    //   15352: goto -5388 -> 9964
    //   15355: ldc_w 378
    //   15358: astore 21
    //   15360: goto -12460 -> 2900
    //   15363: ldc_w 378
    //   15366: astore 21
    //   15368: goto -15013 -> 355
    //   15371: ldc_w 378
    //   15374: astore 21
    //   15376: goto -10909 -> 4467
    //   15379: iconst_0
    //   15380: istore_3
    //   15381: goto -12655 -> 2726
    //   15384: aconst_null
    //   15385: astore 20
    //   15387: aconst_null
    //   15388: astore 19
    //   15390: aconst_null
    //   15391: astore 21
    //   15393: goto -12717 -> 2676
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	15396	0	this	FastDownloadTask
    //   0	15396	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	15396	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   181	15200	3	i	int
    //   24	14300	4	j	int
    //   266	14472	5	k	int
    //   154	15071	6	m	int
    //   18	86	7	n	int
    //   21	14845	8	l1	long
    //   217	5693	10	l2	long
    //   221	5693	12	l3	long
    //   90	12058	14	l4	long
    //   162	2407	16	l5	long
    //   172	14976	18	bool	boolean
    //   157	1	19	localObject1	Object
    //   195	1	19	localException1	java.lang.Exception
    //   208	16	19	localUnknownHostException	java.net.UnknownHostException
    //   234	4068	19	localObject2	Object
    //   4368	1494	19	localObject3	Object
    //   5925	9464	19	localObject4	Object
    //   231	15155	20	localObject5	Object
    //   143	7063	21	localObject6	Object
    //   7519	1	21	localException2	java.lang.Exception
    //   7524	701	21	str1	String
    //   8229	8	21	localException3	java.lang.Exception
    //   8244	8	21	localException4	java.lang.Exception
    //   8307	1	21	localException5	java.lang.Exception
    //   8312	701	21	str2	String
    //   9017	8	21	localException6	java.lang.Exception
    //   9032	8	21	localException7	java.lang.Exception
    //   9095	1	21	localException8	java.lang.Exception
    //   9100	701	21	str3	String
    //   9805	8	21	localException9	java.lang.Exception
    //   9820	130	21	localException10	java.lang.Exception
    //   9962	1126	21	localObject7	Object
    //   11363	1	21	localException11	java.lang.Exception
    //   11368	701	21	str4	String
    //   12073	8	21	localException12	java.lang.Exception
    //   12088	128	21	localException13	java.lang.Exception
    //   12228	1126	21	localObject8	Object
    //   13626	1	21	localException14	java.lang.Exception
    //   13631	701	21	str5	String
    //   14336	8	21	localException15	java.lang.Exception
    //   14351	8	21	localException16	java.lang.Exception
    //   14410	1	21	localException17	java.lang.Exception
    //   14415	697	21	str6	String
    //   15116	8	21	localException18	java.lang.Exception
    //   15131	8	21	localException19	java.lang.Exception
    //   15195	197	21	localObject9	Object
    //   151	1	22	localObject10	Object
    //   226	1309	22	localThrowable1	java.lang.Throwable
    //   2662	4546	22	localObject11	Object
    //   7494	97	22	localThrowable2	java.lang.Throwable
    //   9090	6205	22	localObject12	Object
    //   15303	1	22	localThrowable3	java.lang.Throwable
    //   15324	1	22	localThrowable4	java.lang.Throwable
    //   140	15178	23	localObject13	Object
    //   519	14634	24	localObject14	Object
    //   15188	10	24	localObject15	Object
    //   15207	11	24	localObject16	Object
    //   15230	11	24	localObject17	Object
    //   15253	44	24	localObject18	Object
    //   290	14459	25	localObject19	Object
    //   15250	14	25	localObject20	Object
    //   15274	15	25	localObject21	Object
    //   99	14925	26	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   333	14675	27	localObject22	Object
    //   489	8417	28	localObject23	Object
    //   4601	3517	29	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   81	87	195	java/lang/Exception
    //   164	174	208	java/net/UnknownHostException
    //   223	226	226	java/lang/Throwable
    //   1763	1774	226	java/lang/Throwable
    //   1782	1791	226	java/lang/Throwable
    //   1799	1808	226	java/lang/Throwable
    //   1816	1823	226	java/lang/Throwable
    //   1831	1842	226	java/lang/Throwable
    //   1850	1857	226	java/lang/Throwable
    //   1865	1872	226	java/lang/Throwable
    //   1880	1889	226	java/lang/Throwable
    //   1897	1909	226	java/lang/Throwable
    //   1917	1925	226	java/lang/Throwable
    //   1933	1946	226	java/lang/Throwable
    //   1954	1961	226	java/lang/Throwable
    //   1969	1976	226	java/lang/Throwable
    //   1984	1994	226	java/lang/Throwable
    //   2002	2018	226	java/lang/Throwable
    //   2026	2038	226	java/lang/Throwable
    //   2046	2053	226	java/lang/Throwable
    //   2061	2067	226	java/lang/Throwable
    //   2075	2086	226	java/lang/Throwable
    //   2094	2099	226	java/lang/Throwable
    //   2111	2122	226	java/lang/Throwable
    //   2133	2140	226	java/lang/Throwable
    //   2148	2154	226	java/lang/Throwable
    //   2162	2190	226	java/lang/Throwable
    //   2202	2209	226	java/lang/Throwable
    //   2217	2234	226	java/lang/Throwable
    //   2246	2258	226	java/lang/Throwable
    //   2266	2272	226	java/lang/Throwable
    //   2280	2346	226	java/lang/Throwable
    //   2354	2361	226	java/lang/Throwable
    //   2369	2381	226	java/lang/Throwable
    //   2389	2401	226	java/lang/Throwable
    //   2409	2416	226	java/lang/Throwable
    //   2424	2451	226	java/lang/Throwable
    //   2459	2466	226	java/lang/Throwable
    //   2474	2499	226	java/lang/Throwable
    //   2507	2527	226	java/lang/Throwable
    //   2535	2557	226	java/lang/Throwable
    //   2565	2573	226	java/lang/Throwable
    //   2581	2588	226	java/lang/Throwable
    //   2596	2603	226	java/lang/Throwable
    //   2611	2618	226	java/lang/Throwable
    //   2626	2633	226	java/lang/Throwable
    //   2641	2646	226	java/lang/Throwable
    //   4314	4325	226	java/lang/Throwable
    //   4336	4365	226	java/lang/Throwable
    //   5872	5879	226	java/lang/Throwable
    //   5887	5907	226	java/lang/Throwable
    //   5915	5924	226	java/lang/Throwable
    //   223	226	4368	finally
    //   1763	1774	4368	finally
    //   1782	1791	4368	finally
    //   1799	1808	4368	finally
    //   1816	1823	4368	finally
    //   1831	1842	4368	finally
    //   1850	1857	4368	finally
    //   1865	1872	4368	finally
    //   1880	1889	4368	finally
    //   1897	1909	4368	finally
    //   1917	1925	4368	finally
    //   1933	1946	4368	finally
    //   1954	1961	4368	finally
    //   1969	1976	4368	finally
    //   1984	1994	4368	finally
    //   2002	2018	4368	finally
    //   2026	2038	4368	finally
    //   2046	2053	4368	finally
    //   2061	2067	4368	finally
    //   2075	2086	4368	finally
    //   2094	2099	4368	finally
    //   2111	2122	4368	finally
    //   2133	2140	4368	finally
    //   2148	2154	4368	finally
    //   2162	2190	4368	finally
    //   2202	2209	4368	finally
    //   2217	2234	4368	finally
    //   2246	2258	4368	finally
    //   2266	2272	4368	finally
    //   2280	2346	4368	finally
    //   2354	2361	4368	finally
    //   2369	2381	4368	finally
    //   2389	2401	4368	finally
    //   2409	2416	4368	finally
    //   2424	2451	4368	finally
    //   2459	2466	4368	finally
    //   2474	2499	4368	finally
    //   2507	2527	4368	finally
    //   2535	2557	4368	finally
    //   2565	2573	4368	finally
    //   2581	2588	4368	finally
    //   2596	2603	4368	finally
    //   2611	2618	4368	finally
    //   2626	2633	4368	finally
    //   2641	2646	4368	finally
    //   4314	4325	4368	finally
    //   4336	4365	4368	finally
    //   5872	5879	4368	finally
    //   5887	5907	4368	finally
    //   5915	5924	4368	finally
    //   2726	2734	7494	java/lang/Throwable
    //   2751	2808	7494	java/lang/Throwable
    //   5954	5970	7494	java/lang/Throwable
    //   5973	5994	7494	java/lang/Throwable
    //   7483	7491	7494	java/lang/Throwable
    //   4452	4467	7519	java/lang/Exception
    //   5464	5491	8229	java/lang/Exception
    //   5514	5541	8244	java/lang/Exception
    //   340	355	8307	java/lang/Exception
    //   1352	1379	9017	java/lang/Exception
    //   1402	1429	9032	java/lang/Exception
    //   2885	2900	9095	java/lang/Exception
    //   3896	3923	9805	java/lang/Exception
    //   3946	3973	9820	java/lang/Exception
    //   9949	9964	11363	java/lang/Exception
    //   10960	10987	12073	java/lang/Exception
    //   11010	11037	12088	java/lang/Exception
    //   12215	12230	13626	java/lang/Exception
    //   13226	13253	14336	java/lang/Exception
    //   13276	13303	14351	java/lang/Exception
    //   6069	6084	14410	java/lang/Exception
    //   7078	7105	15116	java/lang/Exception
    //   7128	7155	15131	java/lang/Exception
    //   2646	2661	15188	finally
    //   2676	2688	15207	finally
    //   2703	2726	15207	finally
    //   5938	5944	15207	finally
    //   7499	7507	15207	finally
    //   2726	2734	15230	finally
    //   2751	2808	15230	finally
    //   5954	5970	15230	finally
    //   5973	5994	15230	finally
    //   7483	7491	15230	finally
    //   243	253	15250	finally
    //   253	262	15274	finally
    //   2646	2661	15303	java/lang/Throwable
    //   2676	2688	15324	java/lang/Throwable
    //   2703	2726	15324	java/lang/Throwable
    //   5938	5944	15324	java/lang/Throwable
    //   7499	7507	15324	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.FastDownloadTask
 * JD-Core Version:    0.7.0.1
 */