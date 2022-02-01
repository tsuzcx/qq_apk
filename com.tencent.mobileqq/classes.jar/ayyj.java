import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.TroopStatisticsInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ayyj
  extends aywz
{
  public static String a;
  public static String b;
  public long A;
  public long B = -1L;
  public long C;
  public long D;
  public long E;
  public long F;
  public long G;
  public long H;
  public long I;
  public long J;
  public long K;
  public long L;
  public long M;
  public long N;
  public long O = 2147483647L;
  public long P = 2147483647L;
  public long Q = 2147483647L;
  public long R = 2147483647L;
  public long S;
  public anza a;
  public ayyd a;
  public Long a;
  public AtomicBoolean a;
  public long[] a;
  private QQAppInterface b;
  public boolean b;
  public long h;
  public long i;
  public long j;
  public long k;
  public long l;
  public long m;
  public long n;
  public long o;
  public long p;
  public long q;
  public long r;
  public long s;
  public long t;
  public long u;
  public long v;
  public long w;
  public long x;
  public long y;
  public long z;
  
  static
  {
    jdField_a_of_type_JavaLangString = "PRE_DOWNLOAD_TROOP_STATISTICS_KEY";
    jdField_b_of_type_JavaLangString = "PRE_DOWNLOAD_TROOP_STATISTICS_TIME";
  }
  
  public ayyj()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(100L);
  }
  
  private long a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong == 0L)
    {
      paramLong = this.l;
      l1 = paramLong;
      if (QLog.isColorLevel())
      {
        ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "picSize==0,fix by pisSizeAvg");
        l1 = paramLong;
      }
    }
    return l1;
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      l2 = this.z;
      l1 = this.A;
      this.z += paramLong1;
      this.A += paramLong2;
      if (this.z > this.r)
      {
        paramLong1 = this.r;
        this.z = paramLong1;
        if (this.z >= 0L) {
          break label204;
        }
        paramLong1 = 0L;
        label71:
        this.z = paramLong1;
        if (this.A >= 0L) {
          break label212;
        }
      }
      label204:
      label212:
      for (paramLong1 = 0L;; paramLong1 = this.A)
      {
        this.A = paramLong1;
        paramLong2 = this.z;
        paramLong1 = this.A;
        ayxu.a("4gFlowPre", this.z, false);
        ayxu.a("4gFlowWaste", this.A, paramBoolean);
        if (QLog.isColorLevel()) {
          ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "updateFlow", "networkType=" + paramInt + ", preFlowPre=" + l2 + " preFlowWaste=" + l1 + "flowPre=" + paramLong2 + ", flowWaste:" + paramLong1);
        }
        return;
        paramLong1 = this.z;
        break;
        paramLong1 = this.z;
        break label71;
      }
    }
    long l2 = this.B;
    long l1 = this.C;
    this.B += paramLong1;
    this.C += paramLong2;
    if (this.B > this.x)
    {
      paramLong1 = this.x;
      label270:
      this.B = paramLong1;
      if (this.B >= 0L) {
        break label350;
      }
      paramLong1 = 0L;
      label286:
      this.B = paramLong1;
      if (this.C >= 0L) {
        break label358;
      }
    }
    label350:
    label358:
    for (paramLong1 = 0L;; paramLong1 = this.C)
    {
      this.C = paramLong1;
      paramLong2 = this.B;
      paramLong1 = this.C;
      ayxu.a("xgFlowPre", this.B, false);
      ayxu.a("xgFlowWaste", this.C, paramBoolean);
      break;
      paramLong1 = this.B;
      break label270;
      paramLong1 = this.B;
      break label286;
    }
  }
  
  private void a(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ayyd.a(paramInt1, paramInt2, paramMessageForPic.mNotPredownloadReason);
    paramMessageForPic.preDownState = 2;
    a(paramMessageForPic);
    if (paramInt1 == 0)
    {
      this.K += 1L;
      ayxu.a("wifiHitCount", this.K, true);
      if (QLog.isColorLevel()) {
        ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "networkType:" + paramInt1 + ",wifiHitCount:" + this.K + ",uniseq:" + paramMessageForPic.uniseq);
      }
    }
    do
    {
      return;
      paramLong = a(paramLong);
      a(paramInt1, this.i * paramLong / 100L, -paramLong, false);
      this.G += 1L;
      this.E -= paramLong;
      ayxu.a("accFlowWasteTotal", this.E, false);
      ayxu.a("xgHitCount", this.G, true);
    } while (!QLog.isColorLevel());
    ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "networkType:" + paramInt1 + ",xgHitCount:" + this.G + ",uniseq:" + paramMessageForPic.uniseq);
    ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "accFlowPreTotal:" + this.D + ",accFlowWasteTotal:" + this.E);
  }
  
  private void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      PicPreDownloader localPicPreDownloader = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localPicPreDownloader != null)
      {
        if ((paramMessageForPic.mNotPredownloadReason != 0) && (paramMessageForPic.mNotPredownloadReason != 1)) {
          break label164;
        }
        int i1 = localPicPreDownloader.a(paramMessageForPic);
        this.jdField_a_of_type_Ayyd.e(paramInt1, i1);
        this.jdField_a_of_type_Ayyd.a(paramInt1, i1);
        this.jdField_a_of_type_Ayyd.c(paramInt1, paramInt2);
      }
    }
    paramMessageForPic.preDownState = 3;
    a(paramMessageForPic);
    if (paramInt1 == 0)
    {
      this.L += 1L;
      ayxu.a("wifiMissCount", this.L, true);
      ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "networkType:" + paramInt1 + ",wifiMissCount:" + this.L + ",uniseq:" + paramMessageForPic.uniseq);
    }
    label164:
    do
    {
      return;
      this.jdField_a_of_type_Ayyd.a(paramMessageForPic.preDownNetworkType, paramMessageForPic.mNotPredownloadReason);
      if (paramMessageForPic.mNotPredownloadReason == -1) {
        break;
      }
      this.jdField_a_of_type_Ayyd.c(paramInt1, paramInt2);
      break;
      a(paramInt1, this.j, 0L, false);
      this.H += 1L;
      ayxu.a("xgMissCount", this.H, true);
    } while (!QLog.isColorLevel());
    ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "networkType:" + paramInt1 + ", xgMissCount:" + this.H + ", uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void c(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    paramMessageForPic.preDownState = 5;
    a(paramMessageForPic);
    if (paramInt1 == 0) {
      if (QLog.isColorLevel()) {
        ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "networkType:" + paramInt1 + ",wifiHitCount:" + this.K + ",uniseq:" + paramMessageForPic.uniseq);
      }
    }
    do
    {
      return;
      a(paramInt1, this.k, 0L, true);
    } while (!QLog.isColorLevel());
    ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "networkType:" + paramInt1 + ",xgHitCount:" + this.G + ",uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void d(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ayyd.d(paramInt1, paramInt2);
    paramMessageForPic.preDownState = 6;
    a(paramMessageForPic);
    if (paramInt1 == 0) {
      if (QLog.isColorLevel()) {
        ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "networkType:" + paramInt1 + ",wifiHitCount:" + this.K + ",uniseq:" + paramMessageForPic.uniseq);
      }
    }
    do
    {
      return;
      a(paramInt1, this.k, 0L, true);
    } while (!QLog.isColorLevel());
    ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "networkType:" + paramInt1 + ",xgHitCount:" + this.G + ", uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void f()
  {
    this.z = ayxu.a("4gFlowPre", this.r);
    this.A = ayxu.a("4gFlowWaste", 0L);
    this.B = ayxu.a("xgFlowPre", this.x);
    this.C = ayxu.a("xgFlowWaste", 0L);
    this.K = ayxu.a("wifiHitCount", this.K);
    this.L = ayxu.a("wifiMissCount", this.L);
    this.M = ayxu.a("wifiManulClickCount", this.M);
    this.J = ayxu.a("wifiPreDownCout", this.J);
    this.G = ayxu.a("xgHitCount", this.G);
    this.H = ayxu.a("xgMissCount", this.H);
    this.I = ayxu.a("xgManulClickCount", this.I);
    this.F = ayxu.a("xgPreDownCount", this.F);
    this.D = ayxu.a("accFlowPreTotal", this.D);
    this.E = ayxu.a("accFlowWasteTotal", this.E);
    this.N = ayxu.a("requestListOverLimitCount", this.N);
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "getLocalConfig(): wifiHitCount=" + this.K + " wifiMissCount=" + this.L + " wifiManulClickCount=" + this.M + " wifiPreDownCout=" + this.J + " _4gFlowPre=" + this.z + " _4gFlowWaste=" + this.A + " xgFlowPre=" + this.B + " xgFlowWaste=" + this.C + " xgHitCount=" + this.G + " xgMissCount=" + this.H + " xgManulClickCount=" + this.I + " xgPreDownCout=" + this.F + " accFlowPreTotal=" + this.D + " accFlowWasteTotal=" + this.E + " requestOverLimitCount=" + this.N);
    }
  }
  
  private void g()
  {
    Object localObject1 = ayxu.a("flowCombination", "12000|600|20000|400|6000|300|20000|200");
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig(): PicPredownloadFlow=" + (String)localObject1);
    }
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).split("\\|");
      if (localObject1.length == 8) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig(): Error, use Server config");
      }
      this.t = ayxu.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "AMaxPDFlow3G", 614400L);
      this.u = ayxu.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "AMaxWFlow3G", 716800L);
      this.v = 0L;
      this.w = 0L;
      this.n = this.t;
      this.p = 0L;
      this.o = this.u;
      this.q = 0L;
      this.r = (this.n + this.p);
      this.s = (this.o + this.q);
      this.x = (this.t + this.v);
      this.y = (this.u + this.w);
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig():_4gFlowPreLimit=" + this.n + " _4gFlowWasteLimit=" + this.o + " _4gFlowPreFloatLimit" + this.p + " _4gFlowWasteFloatLimit=" + this.q + " xgFlowPreLimit=" + this.t + " xgFlowWasteLimit=" + this.u + " xgFlowPreFloatLimit=" + this.v + " xgFlowWasteFloatLimit=" + this.w);
      }
      localObject1 = ayxu.a("troopCombination", "20|10|50|10");
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "initConfig(): PicPredownloadConfig=" + (String)localObject1);
      }
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        if (!"".equals(localObject1))
        {
          localObject1 = ((String)localObject1).split("\\|");
          if (localObject1.length >= 4) {
            continue;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig(): PicPredownloadConfig Error, use default config");
        }
      }
      catch (Exception localException)
      {
        int i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, localException.getMessage());
        continue;
        Object localObject2 = new StringBuilder();
        int i1 = 0;
        if (i1 >= i2) {
          continue;
        }
        ((StringBuilder)localObject2).append(String.valueOf(this.jdField_a_of_type_ArrayOfLong[i1])).append("-").append(String.valueOf(this.jdField_a_of_type_ArrayOfLong[(i1 + 1)])).append(" ");
        i1 += 2;
        continue;
        localObject2 = ((StringBuilder)localObject2).toString();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "initConfig(): troopDefaultCount=" + this.O + ", troopIncreaseCountEnterAIO=" + this.P + ", troopMaxCount=" + this.Q + ", troopMinPicSize=" + this.R);
      }
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(ayxu.a("maxRequest", 100L));
      this.h = ayxu.a("xGPreDownPolicy", 1374942199L);
      this.i = ayxu.a("AFBFlowHitXG", 150L);
      this.j = ayxu.a("AFBFlowMissXG", 40960L);
      this.k = this.j;
      this.l = ayxu.a("APicAvgSize", 71680L);
      this.m = ayxu.a("APicMaxSize", 204800L);
      this.jdField_b_of_type_Boolean = ayxu.a("enablePeakFlow", Boolean.valueOf(false)).booleanValue();
      this.jdField_a_of_type_ArrayOfLong = ayxu.a();
      this.S = ayxu.a("PeakFlowMaxPicSize", 921600L);
      if (QLog.isColorLevel())
      {
        i2 = this.jdField_a_of_type_ArrayOfLong.length;
        if ((i2 != 0) && ((i2 & 0x1) == 0)) {
          continue;
        }
        localObject1 = "Error(Length=" + i2 + ")";
        QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig(): xGPreDownPolicy=" + this.h + " xgFlowHitFeedback=" + this.i + " XgFlowMissFeedback=" + this.j + " XgFlowLeftRightFeddback=" + this.k + " pisSizeAvg=" + this.l + " pisSizeMax=" + this.m + " mEnablePeakFlow=" + this.jdField_b_of_type_Boolean + " mPeakFlowTimePeriod=" + (String)localObject1 + " mPeakFlowMaxPicSize=" + this.S + ", mRequestListMaxSize=" + this.jdField_a_of_type_JavaLangLong);
      }
      return;
      this.n = (Integer.valueOf(localObject1[0]).intValue() * 1024);
      this.p = (Integer.valueOf(localObject1[1]).intValue() * 1024);
      this.o = (Integer.valueOf(localObject1[2]).intValue() * 1024);
      this.q = (Integer.valueOf(localObject1[3]).intValue() * 1024);
      this.t = (Integer.valueOf(localObject1[4]).intValue() * 1024);
      this.v = (Integer.valueOf(localObject1[5]).intValue() * 1024);
      this.u = (Integer.valueOf(localObject1[6]).intValue() * 1024);
      this.w = (Integer.valueOf(localObject1[7]).intValue() * 1024);
      break;
      this.O = Long.parseLong(localObject1[0]);
      this.P = Long.parseLong(localObject1[1]);
      this.Q = Long.parseLong(localObject1[2]);
      this.R = (Long.parseLong(localObject1[3]) * 1024L);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  int a()
  {
    return ayxu.a();
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1 = super.a(paramLong, paramInt1, paramInt2, paramBoolean);
    if (i1 != 0) {
      paramInt1 = i1;
    }
    do
    {
      boolean bool;
      do
      {
        return paramInt1;
        i1 = 0;
        bool = a();
        if (QLog.isColorLevel()) {
          ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", "NetworkType:" + paramInt2 + " isInDPCWhiteList:" + bool);
        }
        if (paramInt2 != 0) {
          break;
        }
        paramInt1 = i1;
      } while (!QLog.isColorLevel());
      ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", "Wifi, result=" + 0);
      return 0;
      if ((!bool) || (paramInt2 == 3)) {
        break;
      }
      paramInt1 = i1;
    } while (!QLog.isColorLevel());
    ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", "InDPCWhiteList, result=" + 0);
    return 0;
    long l3 = a(paramLong);
    long l1;
    label211:
    long l2;
    if (paramBoolean) {
      if (paramInt2 == 1)
      {
        paramLong = this.o;
        if (paramInt2 != 1) {
          break label388;
        }
        l1 = this.z - this.p;
        if (paramInt2 != 1) {
          break label402;
        }
        l2 = this.A;
        label223:
        if ((l1 >= l3) && (l2 + l3 < paramLong)) {
          break label482;
        }
        if (l1 >= l3) {
          break label475;
        }
        i1 = -9;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit", "result:" + i1 + ",FlowWaste +picSize=" + (l2 + l3) + ",FlowWasteLimit：" + paramLong + ",FlowPre:" + l1 + ",picSize:" + l3 + ",FlowWaste:" + l2 + ",uinType:" + paramInt1 + ",networkType:" + paramInt2 + ",isDynamic:" + paramBoolean);
      }
      return i1;
      paramLong = this.u;
      break;
      label388:
      l1 = this.B - this.v;
      break label211;
      label402:
      l2 = this.C;
      break label223;
      if (paramInt2 == 1)
      {
        paramLong = this.s;
        label422:
        if (paramInt2 != 1) {
          break label457;
        }
        l1 = this.z;
        label434:
        if (paramInt2 != 1) {
          break label466;
        }
      }
      label457:
      label466:
      for (l2 = this.A;; l2 = this.C)
      {
        break;
        paramLong = this.y;
        break label422;
        l1 = this.B;
        break label434;
      }
      label475:
      i1 = -10;
      continue;
      label482:
      if ((!paramBoolean) && (l1 - l3 < this.p)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    long l1 = ayxu.a("4gFlowPre", this.z);
    long l2 = ayxu.a("4gFlowWaste", this.A);
    long l3 = ayxu.a("xgFlowPre", this.B);
    long l4 = ayxu.a("xgFlowWaste", this.C);
    long l5 = ayxu.a("accFlowPreTotal", this.D);
    long l6 = ayxu.a("xgPreDownCount", this.F);
    long l7 = ayxu.a("xgHitCount", this.G);
    long l8 = ayxu.a("xgMissCount", this.H);
    long l9 = ayxu.a("wifiPreDownCout", this.J);
    long l10 = ayxu.a("wifiHitCount", this.K);
    long l11 = ayxu.a("wifiMissCount", this.L);
    long l12 = ayxu.a("xgManulClickCount", this.I);
    long l13 = ayxu.a("wifiManulClickCount", this.M);
    long l14 = ayxu.a("requestListOverLimitCount", this.N);
    if (QLog.isColorLevel()) {
      ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "getReportInfo", "\n|- sp4gFlowPre:" + l1 + "\n|- sp4gFlowWaste:" + l2 + "\n|- spXgFlowPre:" + l3 + "\n|-  spXgFlowWaste：" + l4 + "\n|-  spFlowPreTotal:" + l5 + "\n|-  spXgPreDownCount：" + l6 + "\n|-  spXgHitCount:" + l7 + "\n|-  spXgMissCount：" + l8 + "\n|-  spWifiPreDownCount:" + l9 + "\n|-  spWifiHitCount：" + l10 + "\n|-  spWifiMissCount:" + l11 + "\n|-  spXgManulClickCount：" + l12 + "\n|-  spWifiManulClickCount:" + l13 + "\n|-  spRequestOverLimitCount:" + l14);
    }
    localHashMap.put("4gFlowPre", String.valueOf(l1));
    localHashMap.put("4gFlowWaste", String.valueOf(l2));
    localHashMap.put("xgFlowPre", String.valueOf(l3));
    localHashMap.put("xgFlowWaste", String.valueOf(l4));
    if ((l7 != 0L) || (l8 != 0L) || (l6 != 0L))
    {
      localHashMap.put("accFlowPreTotal", String.valueOf(l5));
      localHashMap.put("xgPreDownCount", String.valueOf(l6));
      localHashMap.put("xgHitCount", String.valueOf(l7));
      localHashMap.put("xgMissCount", String.valueOf(l6 - l7));
      localHashMap.put("xgManulClickCount", String.valueOf(l12));
      localHashMap.put("xgFlowWasteBalance", String.valueOf(this.u - l4));
    }
    localHashMap.put("wifiPreDownCout", String.valueOf(l9));
    localHashMap.put("wifiHitCount", String.valueOf(l10));
    localHashMap.put("wifiMissCount", String.valueOf(l11));
    localHashMap.put("wifiManulClickCount", String.valueOf(l13));
    localHashMap.put("requestListOverLimitCount", String.valueOf(this.N));
    return localHashMap;
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (paramInt == 0)
    {
      this.J += 1L;
      ayxu.a("wifiPreDownCout", this.J, true);
    }
    do
    {
      return;
      paramLong = a(paramLong);
      a(paramInt, -paramLong, paramLong, false);
      this.D += paramLong;
      this.E += paramLong;
      this.F += 1L;
      ayxu.a("accFlowPreTotal", this.D, false);
      ayxu.a("accFlowWasteTotal", this.E, false);
      ayxu.a("xgPreDownCount", this.F, true);
    } while (!QLog.isColorLevel());
    ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "networkType:" + paramInt + ",wifiPreDownCout:" + this.J + ",xgPreDownCout:" + this.F);
    ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "accFlowPreTotal:" + this.D + ",accFlowWasteTotal:" + this.E);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ayyd = ((ayyd)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73));
    this.jdField_a_of_type_Anza = ((anza)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getCache(3));
    g();
    f();
    long l1 = System.currentTimeMillis();
    if (l1 - ayxu.a("lastDayTime", 0L) > 86400000L)
    {
      String str = paramQQAppInterface.getCurrentAccountUin();
      ayxu.a("lastDayTime", l1, true);
      ayxw.a(str, a());
      e();
      ((ayyd)paramQQAppInterface.getManager(73)).a();
    }
    if (QLog.isColorLevel()) {
      ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "init", "");
    }
  }
  
  public void a(MessageForPic paramMessageForPic)
  {
    ayxu.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic);
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong)
  {
    if ((paramMessageForPic != null) && (paramMessageForPic.size == 0L) && ((paramMessageForPic.preDownState == 1) || (paramMessageForPic.preDownState == 2) || (paramMessageForPic.preDownState == 3)))
    {
      paramMessageForPic.size = paramLong;
      a(paramMessageForPic);
      if (paramMessageForPic.preDownNetworkType != 0) {
        break label55;
      }
    }
    label55:
    do
    {
      return;
      paramLong = this.l - paramLong;
      a(paramMessageForPic.preDownNetworkType, paramLong, -paramLong, false);
      this.D -= paramLong;
      this.E -= paramLong;
      ayxu.a("accFlowPreTotal", this.D, false);
      ayxu.a("accFlowWasteTotal", this.E, true);
    } while (!QLog.isColorLevel());
    ayxi.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "fixPicSizeAfter", "accFlowPreTotal:" + this.D + ",accFlowWasteTotal:" + this.E);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Anza == null) {}
    TroopStatisticsInfo localTroopStatisticsInfo;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
      return;
      localTroopStatisticsInfo = this.jdField_a_of_type_Anza.a(paramString);
      if (localTroopStatisticsInfo == null) {
        break label139;
      }
      paramString = Long.valueOf(localTroopStatisticsInfo.count - 1L);
      if (paramString.longValue() >= 0L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "payPredownloadTroopPicCount troopRemainCount = 0");
    return;
    localTroopStatisticsInfo.count = paramString.longValue();
    for (paramString = localTroopStatisticsInfo;; paramString = localTroopStatisticsInfo)
    {
      this.jdField_a_of_type_Anza.addCache(paramString);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "payPredownloadTroopPicCount troopRemainCount = " + paramString.count);
      return;
      label139:
      localTroopStatisticsInfo = new TroopStatisticsInfo();
      localTroopStatisticsInfo.troopUin = paramString;
      localTroopStatisticsInfo.count = (this.O - 1L);
    }
  }
  
  public boolean a(MessageForPic paramMessageForPic)
  {
    if (ayxu.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin) != 0) {}
    label346:
    for (;;)
    {
      return true;
      if (!this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "canPredownloadInPeakFlowTime(): Peek Flow is disable[true]");
          return true;
        }
      }
      else
      {
        if (this.jdField_a_of_type_ArrayOfLong == null) {}
        for (int i1 = 0; (i1 == 0) || ((i1 & 0x1) != 0); i1 = this.jdField_a_of_type_ArrayOfLong.length)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "canPredownloadInPeakFlowTime():  The length(" + i1 + ") of PeakFlowTimePeriod is error![false]");
          }
          return false;
        }
        int i3 = Calendar.getInstance().get(11);
        int i2 = 0;
        for (;;)
        {
          if (i2 >= i1) {
            break label346;
          }
          if ((i3 >= this.jdField_a_of_type_ArrayOfLong[i2]) && (i3 < this.jdField_a_of_type_ArrayOfLong[(i2 + 1)]))
          {
            if (paramMessageForPic.size > this.S)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "picSize=" + paramMessageForPic.size + " is larger than PeakFlowMaxPicSize(" + this.S + ")[false]");
              }
              return false;
            }
            if ((paramMessageForPic.size > this.R) && (a() == 0))
            {
              if (!a(paramMessageForPic.frienduin)) {
                return false;
              }
              if (!paramMessageForPic.hasBigFile())
              {
                a(paramMessageForPic.frienduin);
                return true;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the big picture already exists");
              return true;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download because the pic.size=" + paramMessageForPic.size + " < troopMinPicSize=" + this.R);
            }
          }
          i2 += 2;
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Anza == null) {}
    do
    {
      do
      {
        return true;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
      return true;
      paramString = this.jdField_a_of_type_Anza.a(paramString);
    } while ((paramString == null) || (paramString.count - 1L >= 0L));
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "don't predownload because troopRemainCount = 0");
    }
    return false;
  }
  
  public boolean[] a(int paramInt1, int paramInt2)
  {
    int i2;
    int i1;
    boolean bool1;
    if ((a()) && (paramInt2 != 3))
    {
      i2 = ayxu.a(0, paramInt1, 0);
      i1 = ayxu.a(0, paramInt1, 1);
      if ((this.h >> i2 & 1L) != 1L) {
        break label172;
      }
      bool1 = true;
      label44:
      if ((this.h >> i1 & 1L) != 1L) {
        break label178;
      }
    }
    label172:
    label178:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        ayxi.a("PIC_TAG_PRELOAD", "isPreDownload", "netWokrType:" + paramInt2 + ",uinType:" + paramInt1 + ",preDownThumb:" + bool1 + ",preDownBig:" + bool2 + ",xGPreDownPolicy:" + this.h);
      }
      return new boolean[] { bool1, bool2 };
      i2 = ayxu.a(paramInt2, paramInt1, 0);
      i1 = ayxu.a(paramInt2, paramInt1, 1);
      break;
      bool1 = false;
      break label44;
    }
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong)
  {
    if (this.jdField_a_of_type_Ayyd == null) {}
    int i1;
    do
    {
      do
      {
        return;
      } while ((paramMessageForPic.isSendFromLocal()) || (paramMessageForPic.subVersion < 5));
      i1 = ayxu.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin);
      if (paramMessageForPic.preDownState == 1)
      {
        a(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
        return;
      }
      if (paramMessageForPic.preDownState == 0)
      {
        if (a(i1, paramMessageForPic.preDownNetworkType)[1] == 0)
        {
          d(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
          return;
        }
        b(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
        return;
      }
    } while (paramMessageForPic.preDownState != 4);
    c(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
  }
  
  public void b(String paramString)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.w("PIC_TAG_PRELOAD_TROOP", 2, "increaseTroopCountWhenEnterAIO() troopid is null");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Anza == null);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
    return;
    TroopStatisticsInfo localTroopStatisticsInfo = this.jdField_a_of_type_Anza.a(paramString);
    long l1;
    if (localTroopStatisticsInfo != null)
    {
      long l2 = localTroopStatisticsInfo.count + this.P;
      l1 = l2;
      if (l2 > this.Q) {
        l1 = this.Q;
      }
      localTroopStatisticsInfo.count = l1;
    }
    for (paramString = localTroopStatisticsInfo;; paramString = localTroopStatisticsInfo)
    {
      this.jdField_a_of_type_Anza.updateCache(paramString);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "increaseTroopCountWhenEnterAIO troopRemainCount=" + l1);
      return;
      l1 = this.O;
      l1 = this.P + l1;
      localTroopStatisticsInfo = new TroopStatisticsInfo();
      localTroopStatisticsInfo.troopUin = paramString;
      localTroopStatisticsInfo.count = l1;
    }
  }
  
  public void e()
  {
    this.N = 0L;
    this.K = 0L;
    this.L = 0L;
    this.M = 0L;
    this.J = 0L;
    this.A = 0L;
    this.C = 0L;
    this.G = 0L;
    this.H = 0L;
    this.I = 0L;
    this.F = 0L;
    ayxu.a("requestListOverLimitCount", this.N, false);
    ayxu.a("wifiHitCount", this.K, false);
    ayxu.a("wifiMissCount", this.L, false);
    ayxu.a("wifiManulClickCount", this.M, false);
    ayxu.a("wifiPreDownCout", this.J, false);
    ayxu.a("4gFlowWaste", this.A, false);
    ayxu.a("xgFlowWaste", this.C, false);
    ayxu.a("xgHitCount", this.G, false);
    ayxu.a("xgMissCount", this.H, false);
    ayxu.a("xgManulClickCount", this.I, false);
    ayxu.a("xgPreDownCount", this.F, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyj
 * JD-Core Version:    0.7.0.1
 */