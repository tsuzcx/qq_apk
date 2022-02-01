package com.tencent.biz.pubaccount.readinjoy.imageopt;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/imageopt/RIJImageOptConfig;", "", "()V", "FILE_TYPE_SHARPP", "", "FILE_TYPE_WEBP", "TAG", "", "bitmapOpt", "decodeHttpStream", "fileTypeOpt", "isBitmapOpt", "", "()Z", "isDecodeHttpStream", "isLifoOn", "isRenderFirst", "isRportOn", "lifoOn", "monitorTime", "", "renderFirst", "reportOn", "useInnerDns", "useKandianIpConnect", "getMonitorTime", "updateConfig", "", "useIpConnect", "useSharpP", "useWebp", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJImageOptConfig
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long = 0L;
  public static final RIJImageOptConfig a;
  private static final String jdField_a_of_type_JavaLangString = "RIJImageOptConfig";
  private static int b = 0;
  private static int c = 0;
  private static int d = 0;
  private static int e = 0;
  private static int f = 0;
  private static int g = 0;
  private static final int h = 1;
  private static final int i = 2;
  private static int j;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyImageoptRIJImageOptConfig = new RIJImageOptConfig();
  }
  
  public final long a()
  {
    if (jdField_a_of_type_Long > 0L) {
      return jdField_a_of_type_Long;
    }
    return 10000L;
  }
  
  public final void a()
  {
    jdField_a_of_type_Int = Aladdin.getConfig(293).getIntegerFromString("reportOn", 0);
    b = Aladdin.getConfig(293).getIntegerFromString("lifoOn", 0);
    c = Aladdin.getConfig(293).getIntegerFromString("renderFirst", 0);
    d = Aladdin.getConfig(293).getIntegerFromString("decodeHttpStream", 0);
    e = Aladdin.getConfig(293).getIntegerFromString("bitmapOpt", 0);
    jdField_a_of_type_Long = Aladdin.getConfig(293).getIntegerFromString("monitorTime", 10000);
    j = Aladdin.getConfig(323).getIntegerFromString("image_flow_optimization_config", 0);
    f = Aladdin.getConfig(323).getIntegerFromString("use_ip", 0);
    g = Aladdin.getConfig(293).getIntegerFromString("use_kandian_ip_connect", 0);
    QLog.d(jdField_a_of_type_JavaLangString, 1, "reportOn:" + jdField_a_of_type_Int + ", lifoOn:" + b + ", renderFirst:" + c + ", decodeHttpStream:" + d + ", bitmapOpt:" + e + ", monitorTime:" + jdField_a_of_type_Long + ", fileTypeOpt:" + j + ", use_ip:" + f + ", use_ip_connect:" + g);
  }
  
  public final boolean a()
  {
    return jdField_a_of_type_Int == 1;
  }
  
  public final boolean b()
  {
    return b == 1;
  }
  
  public final boolean c()
  {
    return c == 1;
  }
  
  public final boolean d()
  {
    return d == 1;
  }
  
  public final boolean e()
  {
    return e == 1;
  }
  
  public final boolean f()
  {
    return j == h;
  }
  
  public final boolean g()
  {
    return j == i;
  }
  
  public final boolean h()
  {
    return f == 1;
  }
  
  public final boolean i()
  {
    return g == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptConfig
 * JD-Core Version:    0.7.0.1
 */