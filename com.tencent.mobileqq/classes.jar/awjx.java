import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.TroopStatisticsInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class awjx
  extends awin
  implements alrb
{
  public static String a;
  public static String b;
  public long A;
  public long B;
  public long C = -1L;
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
  public long O;
  public long P = 2147483647L;
  public long Q = 2147483647L;
  public long R = 2147483647L;
  public long S = 2147483647L;
  public long T;
  public int a;
  public amhc a;
  private awjr a;
  public AtomicBoolean a;
  public boolean a;
  public long[] a;
  private QQAppInterface b;
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
  
  public awjx()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = 100;
  }
  
  private long a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong == 0L)
    {
      paramLong = this.m;
      l1 = paramLong;
      if (QLog.isColorLevel())
      {
        awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "picSize==0,fix by pisSizeAvg");
        l1 = paramLong;
      }
    }
    return l1;
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      l2 = this.A;
      l1 = this.B;
      this.A += paramLong1;
      this.B += paramLong2;
      if (this.A > this.s)
      {
        paramLong1 = this.s;
        this.A = paramLong1;
        if (this.A >= 0L) {
          break label204;
        }
        paramLong1 = 0L;
        label71:
        this.A = paramLong1;
        if (this.B >= 0L) {
          break label212;
        }
      }
      label204:
      label212:
      for (paramLong1 = 0L;; paramLong1 = this.B)
      {
        this.B = paramLong1;
        paramLong2 = this.A;
        paramLong1 = this.B;
        awji.a("4gFlowPre", this.A, false);
        awji.a("4gFlowWaste", this.B, paramBoolean);
        if (QLog.isColorLevel()) {
          awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "updateFlow", "networkType=" + paramInt + ", preFlowPre=" + l2 + " preFlowWaste=" + l1 + "flowPre=" + paramLong2 + ", flowWaste:" + paramLong1);
        }
        return;
        paramLong1 = this.A;
        break;
        paramLong1 = this.A;
        break label71;
      }
    }
    long l2 = this.C;
    long l1 = this.D;
    this.C += paramLong1;
    this.D += paramLong2;
    if (this.C > this.y)
    {
      paramLong1 = this.y;
      label270:
      this.C = paramLong1;
      if (this.C >= 0L) {
        break label350;
      }
      paramLong1 = 0L;
      label286:
      this.C = paramLong1;
      if (this.D >= 0L) {
        break label358;
      }
    }
    label350:
    label358:
    for (paramLong1 = 0L;; paramLong1 = this.D)
    {
      this.D = paramLong1;
      paramLong2 = this.C;
      paramLong1 = this.D;
      awji.a("xgFlowPre", this.C, false);
      awji.a("xgFlowWaste", this.D, paramBoolean);
      break;
      paramLong1 = this.C;
      break label270;
      paramLong1 = this.C;
      break label286;
    }
  }
  
  private void a(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Awjr.a(paramInt1, paramInt2, paramMessageForPic.mNotPredownloadReason);
    paramMessageForPic.preDownState = 2;
    a(paramMessageForPic);
    if (paramInt1 == 0)
    {
      this.L += 1L;
      awji.a("wifiHitCount", this.L, true);
      if (QLog.isColorLevel()) {
        awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "networkType:" + paramInt1 + ",wifiHitCount:" + this.L + ",uniseq:" + paramMessageForPic.uniseq);
      }
    }
    do
    {
      return;
      paramLong = a(paramLong);
      a(paramInt1, this.j * paramLong / 100L, -paramLong, false);
      this.H += 1L;
      this.F -= paramLong;
      awji.a("accFlowWasteTotal", this.F, false);
      awji.a("xgHitCount", this.H, true);
    } while (!QLog.isColorLevel());
    awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "networkType:" + paramInt1 + ",xgHitCount:" + this.H + ",uniseq:" + paramMessageForPic.uniseq);
    awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "accFlowPreTotal:" + this.E + ",accFlowWasteTotal:" + this.F);
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
        this.jdField_a_of_type_Awjr.e(paramInt1, i1);
        this.jdField_a_of_type_Awjr.a(paramInt1, i1);
        this.jdField_a_of_type_Awjr.c(paramInt1, paramInt2);
      }
    }
    paramMessageForPic.preDownState = 3;
    a(paramMessageForPic);
    if (paramInt1 == 0)
    {
      this.M += 1L;
      awji.a("wifiMissCount", this.M, true);
      awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "networkType:" + paramInt1 + ",wifiMissCount:" + this.M + ",uniseq:" + paramMessageForPic.uniseq);
    }
    label164:
    do
    {
      return;
      this.jdField_a_of_type_Awjr.a(paramMessageForPic.preDownNetworkType, paramMessageForPic.mNotPredownloadReason);
      if (paramMessageForPic.mNotPredownloadReason == -1) {
        break;
      }
      this.jdField_a_of_type_Awjr.c(paramInt1, paramInt2);
      break;
      a(paramInt1, this.k, 0L, false);
      this.I += 1L;
      awji.a("xgMissCount", this.I, true);
    } while (!QLog.isColorLevel());
    awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "networkType:" + paramInt1 + ", xgMissCount:" + this.I + ", uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void c(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    paramMessageForPic.preDownState = 5;
    a(paramMessageForPic);
    if (paramInt1 == 0) {
      if (QLog.isColorLevel()) {
        awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "networkType:" + paramInt1 + ",wifiHitCount:" + this.L + ",uniseq:" + paramMessageForPic.uniseq);
      }
    }
    do
    {
      return;
      a(paramInt1, this.l, 0L, true);
    } while (!QLog.isColorLevel());
    awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "networkType:" + paramInt1 + ",xgHitCount:" + this.H + ",uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void d(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Awjr.d(paramInt1, paramInt2);
    paramMessageForPic.preDownState = 6;
    a(paramMessageForPic);
    if (paramInt1 == 0) {
      if (QLog.isColorLevel()) {
        awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "networkType:" + paramInt1 + ",wifiHitCount:" + this.L + ",uniseq:" + paramMessageForPic.uniseq);
      }
    }
    do
    {
      return;
      a(paramInt1, this.l, 0L, true);
    } while (!QLog.isColorLevel());
    awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "networkType:" + paramInt1 + ",xgHitCount:" + this.H + ", uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void e()
  {
    this.A = awji.a("4gFlowPre", this.s);
    this.B = awji.a("4gFlowWaste", 0L);
    this.C = awji.a("xgFlowPre", this.y);
    this.D = awji.a("xgFlowWaste", 0L);
    this.L = awji.a("wifiHitCount", this.L);
    this.M = awji.a("wifiMissCount", this.M);
    this.N = awji.a("wifiManulClickCount", this.N);
    this.K = awji.a("wifiPreDownCout", this.K);
    this.H = awji.a("xgHitCount", this.H);
    this.I = awji.a("xgMissCount", this.I);
    this.J = awji.a("xgManulClickCount", this.J);
    this.G = awji.a("xgPreDownCount", this.G);
    this.E = awji.a("accFlowPreTotal", this.E);
    this.F = awji.a("accFlowWasteTotal", this.F);
    this.O = awji.a("requestListOverLimitCount", this.O);
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "getLocalConfig(): wifiHitCount=" + this.L + " wifiMissCount=" + this.M + " wifiManulClickCount=" + this.N + " wifiPreDownCout=" + this.K + " _4gFlowPre=" + this.A + " _4gFlowWaste=" + this.B + " xgFlowPre=" + this.C + " xgFlowWaste=" + this.D + " xgHitCount=" + this.H + " xgMissCount=" + this.I + " xgManulClickCount=" + this.J + " xgPreDownCout=" + this.G + " accFlowPreTotal=" + this.E + " accFlowWasteTotal=" + this.F + " requestOverLimitCount=" + this.O);
    }
  }
  
  private void f()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.PicPredownloadFlow.name(), "1200|400|1400|400|600|200|700|200");
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initDPCConfig(): PicPredownloadFlow=" + (String)localObject);
    }
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length == 8) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initDPCConfig(): Error, use Server config");
      }
      this.u = awji.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "AMaxPDFlow3G", 614400L);
      this.v = awji.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "AMaxWFlow3G", 716800L);
      this.w = 0L;
      this.x = 0L;
      this.o = this.u;
      this.q = 0L;
      this.p = this.v;
      this.r = 0L;
      this.s = (this.o + this.q);
      this.t = (this.p + this.r);
      this.y = (this.u + this.w);
      this.z = (this.v + this.x);
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initDPCConfig():_4gFlowPreLimit=" + this.o + " _4gFlowWasteLimit=" + this.p + " _4gFlowPreFloatLimit" + this.q + " _4gFlowWasteFloatLimit=" + this.r + " xgFlowPreLimit=" + this.u + " xgFlowWasteLimit=" + this.v + " xgFlowPreFloatLimit=" + this.w + " xgFlowWasteFloatLimit=" + this.x);
      }
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.PicPredownloadConfig.name(), "");
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "initDPCConfig(): PicPredownloadConfig=" + (String)localObject);
      }
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        if (!"".equals(localObject))
        {
          localObject = ((String)localObject).split("\\|");
          if (localObject.length >= 4) {
            continue;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initDPCConfig(): PicPredownloadConfig Error, use default config");
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, localException.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "initDPCConfig(): troopDefaultCount=" + this.P + ", troopIncreaseCountEnterAIO=" + this.Q + ", troopMaxCount=" + this.R + ", troopMinPicSize=" + this.S + ", mRequestListMaxSize=" + this.jdField_a_of_type_Int);
      }
      return;
      this.o = (Integer.valueOf(localObject[0]).intValue() * 1024);
      this.q = (Integer.valueOf(localObject[1]).intValue() * 1024);
      this.p = (Integer.valueOf(localObject[2]).intValue() * 1024);
      this.r = (Integer.valueOf(localObject[3]).intValue() * 1024);
      this.u = (Integer.valueOf(localObject[4]).intValue() * 1024);
      this.w = (Integer.valueOf(localObject[5]).intValue() * 1024);
      this.v = (Integer.valueOf(localObject[6]).intValue() * 1024);
      this.x = (Integer.valueOf(localObject[7]).intValue() * 1024);
      break;
      this.P = Long.parseLong(localObject[0]);
      this.Q = Long.parseLong(localObject[1]);
      this.R = Long.parseLong(localObject[2]);
      this.S = (Long.parseLong(localObject[3]) * 1024L);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_Int = Integer.parseInt(localObject[4]);
    }
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
        bool = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name());
        if (QLog.isColorLevel()) {
          awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", "NetworkType:" + paramInt2 + " isInDPCWhiteList:" + bool);
        }
        if (paramInt2 != 0) {
          break;
        }
        paramInt1 = i1;
      } while (!QLog.isColorLevel());
      awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", "Wifi, result=" + 0);
      return 0;
      if ((!bool) || (paramInt2 == 3)) {
        break;
      }
      paramInt1 = i1;
    } while (!QLog.isColorLevel());
    awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", "InDPCWhiteList, result=" + 0);
    return 0;
    long l3 = a(paramLong);
    long l1;
    label219:
    long l2;
    if (paramBoolean) {
      if (paramInt2 == 1)
      {
        paramLong = this.p;
        if (paramInt2 != 1) {
          break label396;
        }
        l1 = this.A - this.q;
        if (paramInt2 != 1) {
          break label410;
        }
        l2 = this.B;
        label231:
        if ((l1 >= l3) && (l2 + l3 < paramLong)) {
          break label490;
        }
        if (l1 >= l3) {
          break label483;
        }
        i1 = -9;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit", "result:" + i1 + ",FlowWaste +picSize=" + (l2 + l3) + ",FlowWasteLimit：" + paramLong + ",FlowPre:" + l1 + ",picSize:" + l3 + ",FlowWaste:" + l2 + ",uinType:" + paramInt1 + ",networkType:" + paramInt2 + ",isDynamic:" + paramBoolean);
      }
      return i1;
      paramLong = this.v;
      break;
      label396:
      l1 = this.C - this.w;
      break label219;
      label410:
      l2 = this.D;
      break label231;
      if (paramInt2 == 1)
      {
        paramLong = this.t;
        label430:
        if (paramInt2 != 1) {
          break label465;
        }
        l1 = this.A;
        label442:
        if (paramInt2 != 1) {
          break label474;
        }
      }
      label465:
      label474:
      for (l2 = this.B;; l2 = this.D)
      {
        break;
        paramLong = this.z;
        break label430;
        l1 = this.C;
        break label442;
      }
      label483:
      i1 = -10;
      continue;
      label490:
      if ((!paramBoolean) && (l1 - l3 < this.q)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    long l1 = awji.a("4gFlowPre", this.A);
    long l2 = awji.a("4gFlowWaste", this.B);
    long l3 = awji.a("xgFlowPre", this.C);
    long l4 = awji.a("xgFlowWaste", this.D);
    long l5 = awji.a("accFlowPreTotal", this.E);
    long l6 = awji.a("xgPreDownCount", this.G);
    long l7 = awji.a("xgHitCount", this.H);
    long l8 = awji.a("xgMissCount", this.I);
    long l9 = awji.a("wifiPreDownCout", this.K);
    long l10 = awji.a("wifiHitCount", this.L);
    long l11 = awji.a("wifiMissCount", this.M);
    long l12 = awji.a("xgManulClickCount", this.J);
    long l13 = awji.a("wifiManulClickCount", this.N);
    long l14 = awji.a("requestListOverLimitCount", this.O);
    if (QLog.isColorLevel()) {
      awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "getReportInfo", "\n|- sp4gFlowPre:" + l1 + "\n|- sp4gFlowWaste:" + l2 + "\n|- spXgFlowPre:" + l3 + "\n|-  spXgFlowWaste：" + l4 + "\n|-  spFlowPreTotal:" + l5 + "\n|-  spXgPreDownCount：" + l6 + "\n|-  spXgHitCount:" + l7 + "\n|-  spXgMissCount：" + l8 + "\n|-  spWifiPreDownCount:" + l9 + "\n|-  spWifiHitCount：" + l10 + "\n|-  spWifiMissCount:" + l11 + "\n|-  spXgManulClickCount：" + l12 + "\n|-  spWifiManulClickCount:" + l13 + "\n|-  spRequestOverLimitCount:" + l14);
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
      localHashMap.put("xgFlowWasteBalance", String.valueOf(this.v - l4));
    }
    localHashMap.put("wifiPreDownCout", String.valueOf(l9));
    localHashMap.put("wifiHitCount", String.valueOf(l10));
    localHashMap.put("wifiMissCount", String.valueOf(l11));
    localHashMap.put("wifiManulClickCount", String.valueOf(l13));
    localHashMap.put("requestListOverLimitCount", String.valueOf(this.O));
    return localHashMap;
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (paramInt == 0)
    {
      this.K += 1L;
      awji.a("wifiPreDownCout", this.K, true);
    }
    do
    {
      return;
      paramLong = a(paramLong);
      a(paramInt, -paramLong, paramLong, false);
      this.E += paramLong;
      this.F += paramLong;
      this.G += 1L;
      awji.a("accFlowPreTotal", this.E, false);
      awji.a("accFlowWasteTotal", this.F, false);
      awji.a("xgPreDownCount", this.G, true);
    } while (!QLog.isColorLevel());
    awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "networkType:" + paramInt + ",wifiPreDownCout:" + this.K + ",xgPreDownCout:" + this.G);
    awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "accFlowPreTotal:" + this.E + ",accFlowWasteTotal:" + this.F);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awjr = ((awjr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(73));
    this.jdField_a_of_type_Amhc = ((amhc)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(3));
    f();
    c();
    e();
    long l1 = System.currentTimeMillis();
    if (l1 - awji.a("lastDayTime", 0L) > 86400000L)
    {
      String str = paramQQAppInterface.getCurrentAccountUin();
      awji.a("lastDayTime", l1, true);
      awjk.a(str, a());
      d();
      ((awjr)paramQQAppInterface.getManager(73)).a();
    }
    if (QLog.isColorLevel()) {
      awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "init", "");
    }
  }
  
  public void a(MessageForPic paramMessageForPic)
  {
    awji.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic);
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
      paramLong = this.m - paramLong;
      a(paramMessageForPic.preDownNetworkType, paramLong, -paramLong, false);
      this.E -= paramLong;
      this.F -= paramLong;
      awji.a("accFlowPreTotal", this.E, false);
      awji.a("accFlowWasteTotal", this.F, true);
    } while (!QLog.isColorLevel());
    awiw.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "fixPicSizeAfter", "accFlowPreTotal:" + this.E + ",accFlowWasteTotal:" + this.F);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Amhc == null) {}
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
      localTroopStatisticsInfo = this.jdField_a_of_type_Amhc.a(paramString);
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
      this.jdField_a_of_type_Amhc.a(paramString);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "payPredownloadTroopPicCount troopRemainCount = " + paramString.count);
      return;
      label139:
      localTroopStatisticsInfo = new TroopStatisticsInfo();
      localTroopStatisticsInfo.troopUin = paramString;
      localTroopStatisticsInfo.count = (this.P - 1L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        awiw.a("PIC_TAG_PRELOAD_TROOP", "onDpcPullFinished", "try to initDPCConfig again");
      }
      f();
    }
  }
  
  public boolean a(MessageForPic paramMessageForPic)
  {
    if (awji.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin) != 0) {}
    label349:
    for (;;)
    {
      return true;
      if (!this.jdField_a_of_type_Boolean)
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
        int i3 = awji.a();
        int i4 = Calendar.getInstance().get(11);
        int i2 = 0;
        for (;;)
        {
          if (i2 >= i1) {
            break label349;
          }
          if ((i4 >= this.jdField_a_of_type_ArrayOfLong[i2]) && (i4 < this.jdField_a_of_type_ArrayOfLong[(i2 + 1)]))
          {
            if (paramMessageForPic.size > this.T)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "picSize=" + paramMessageForPic.size + " is larger than PeakFlowMaxPicSize(" + this.T + ")[false]");
              }
              return false;
            }
            if ((paramMessageForPic.size > this.S) && (i3 == 0))
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
              QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download because the pic.size=" + paramMessageForPic.size + " < troopMinPicSize=" + this.S);
            }
          }
          i2 += 2;
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Amhc == null) {}
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
      paramString = this.jdField_a_of_type_Amhc.a(paramString);
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
    if ((DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name())) && (paramInt2 != 3))
    {
      i2 = awji.a(0, paramInt1, 0);
      i1 = awji.a(0, paramInt1, 1);
      if ((this.i >> i2 & 1L) != 1L) {
        break label180;
      }
      bool1 = true;
      label52:
      if ((this.i >> i1 & 1L) != 1L) {
        break label186;
      }
    }
    label180:
    label186:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        awiw.a("PIC_TAG_PRELOAD", "isPreDownload", "netWokrType:" + paramInt2 + ",uinType:" + paramInt1 + ",preDownThumb:" + bool1 + ",preDownBig:" + bool2 + ",xGPreDownPolicy:" + this.i);
      }
      return new boolean[] { bool1, bool2 };
      i2 = awji.a(paramInt2, paramInt1, 0);
      i1 = awji.a(paramInt2, paramInt1, 1);
      break;
      bool1 = false;
      break label52;
    }
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong)
  {
    if (this.jdField_a_of_type_Awjr == null) {}
    int i1;
    do
    {
      do
      {
        return;
      } while ((paramMessageForPic.isSendFromLocal()) || (paramMessageForPic.subVersion < 5));
      i1 = awji.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin);
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
    if (this.jdField_a_of_type_Amhc == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
    return;
    TroopStatisticsInfo localTroopStatisticsInfo = this.jdField_a_of_type_Amhc.a(paramString);
    long l1;
    if (localTroopStatisticsInfo != null)
    {
      long l2 = localTroopStatisticsInfo.count + this.Q;
      l1 = l2;
      if (l2 > this.R) {
        l1 = this.R;
      }
      localTroopStatisticsInfo.count = l1;
    }
    for (paramString = localTroopStatisticsInfo;; paramString = localTroopStatisticsInfo)
    {
      this.jdField_a_of_type_Amhc.b(paramString);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "increaseTroopCountWhenEnterAIO troopRemainCount=" + l1);
      return;
      l1 = this.P;
      l1 = this.Q + l1;
      localTroopStatisticsInfo = new TroopStatisticsInfo();
      localTroopStatisticsInfo.troopUin = paramString;
      localTroopStatisticsInfo.count = l1;
    }
  }
  
  public void c()
  {
    int i1 = 0;
    this.i = awji.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "PicDPy471", 1374942199L);
    this.j = awji.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "AFBFlowHit3G", 150L);
    this.k = awji.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "AFBFlowMiss3G", 40960L);
    this.l = this.k;
    this.m = awji.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "APicAvgSize", 71680L);
    this.n = awji.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "APicMaxSize", 204800L);
    this.jdField_a_of_type_Boolean = awji.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, false);
    this.jdField_a_of_type_ArrayOfLong = awji.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.T = awji.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "APicMaxSize", 921600L);
    int i2;
    if (QLog.isColorLevel())
    {
      i2 = this.jdField_a_of_type_ArrayOfLong.length;
      if ((i2 != 0) && ((i2 & 0x1) == 0)) {
        break label315;
      }
    }
    for (Object localObject = "Error(Length=" + i2 + ")";; localObject = ((StringBuilder)localObject).toString())
    {
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "getServerConfig(): xGPreDownPolicy=" + this.i + " xgFlowHitFeedback=" + this.j + " XgFlowMissFeedback=" + this.k + " XgFlowLeftRightFeddback=" + this.l + " pisSizeAvg=" + this.m + " pisSizeMax=" + this.n + " mEnablePeakFlow=" + this.jdField_a_of_type_Boolean + " mPeakFlowTimePeriod=" + (String)localObject + " mPeakFlowMaxPicSize=" + this.T);
      return;
      label315:
      localObject = new StringBuilder();
      while (i1 < i2)
      {
        ((StringBuilder)localObject).append(String.valueOf(this.jdField_a_of_type_ArrayOfLong[i1])).append("-").append(String.valueOf(this.jdField_a_of_type_ArrayOfLong[(i1 + 1)])).append(" ");
        i1 += 2;
      }
    }
  }
  
  public void d()
  {
    this.O = 0L;
    this.L = 0L;
    this.M = 0L;
    this.N = 0L;
    this.K = 0L;
    this.B = 0L;
    this.D = 0L;
    this.H = 0L;
    this.I = 0L;
    this.J = 0L;
    this.G = 0L;
    awji.a("requestListOverLimitCount", this.O, false);
    awji.a("wifiHitCount", this.L, false);
    awji.a("wifiMissCount", this.M, false);
    awji.a("wifiManulClickCount", this.N, false);
    awji.a("wifiPreDownCout", this.K, false);
    awji.a("4gFlowWaste", this.B, false);
    awji.a("xgFlowWaste", this.D, false);
    awji.a("xgHitCount", this.H, false);
    awji.a("xgMissCount", this.I, false);
    awji.a("xgManulClickCount", this.J, false);
    awji.a("xgPreDownCount", this.G, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awjx
 * JD-Core Version:    0.7.0.1
 */