package com.tencent.ad.tangram.system;

public final class a
{
  public static final long NETWORK_CLASS_BITMASK_2G = 32843L;
  public static final long NETWORK_CLASS_BITMASK_3G = 93108L;
  public static final long NETWORK_CLASS_BITMASK_4G = 397312L;
  public static final long NETWORK_CLASS_BITMASK_5G = 524288L;
  public static final long NETWORK_STANDARDS_FAMILY_BITMASK_3GPP = 906119L;
  public static final long NETWORK_STANDARDS_FAMILY_BITMASK_3GPP2 = 10360L;
  public static final long NETWORK_TYPE_BITMASK_1xRTT = 64L;
  public static final long NETWORK_TYPE_BITMASK_CDMA = 8L;
  public static final long NETWORK_TYPE_BITMASK_EDGE = 2L;
  public static final long NETWORK_TYPE_BITMASK_EHRPD = 8192L;
  public static final long NETWORK_TYPE_BITMASK_EVDO_0 = 16L;
  public static final long NETWORK_TYPE_BITMASK_EVDO_A = 32L;
  public static final long NETWORK_TYPE_BITMASK_EVDO_B = 2048L;
  public static final long NETWORK_TYPE_BITMASK_GPRS = 1L;
  public static final long NETWORK_TYPE_BITMASK_GSM = 32768L;
  public static final long NETWORK_TYPE_BITMASK_HSDPA = 128L;
  public static final long NETWORK_TYPE_BITMASK_HSPA = 512L;
  public static final long NETWORK_TYPE_BITMASK_HSPAP = 16384L;
  public static final long NETWORK_TYPE_BITMASK_HSUPA = 256L;
  public static final long NETWORK_TYPE_BITMASK_IWLAN = 131072L;
  public static final long NETWORK_TYPE_BITMASK_LTE = 4096L;
  public static final long NETWORK_TYPE_BITMASK_LTE_CA = 262144L;
  public static final long NETWORK_TYPE_BITMASK_NR = 524288L;
  public static final long NETWORK_TYPE_BITMASK_TD_SCDMA = 65536L;
  public static final long NETWORK_TYPE_BITMASK_UMTS = 4L;
  public static final long NETWORK_TYPE_BITMASK_UNKNOWN = 0L;
  public static final int NETWORK_TYPE_LTE_CA = 19;
  public static final int NETWORK_TYPE_NR = 20;
  
  public static long getBitMaskForNetworkType(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    case 18: 
    default: 
      return 0L;
    case 16: 
      return 32768L;
    case 1: 
      return 1L;
    case 2: 
      return 2L;
    case 4: 
      return 8L;
    case 7: 
      return 64L;
    case 5: 
      return 16L;
    case 6: 
      return 32L;
    case 12: 
      return 2048L;
    case 14: 
      return 8192L;
    case 9: 
      return 256L;
    case 8: 
      return 128L;
    case 10: 
      return 512L;
    case 15: 
      return 16384L;
    case 3: 
      return 4L;
    case 17: 
      return 65536L;
    case 13: 
      return 4096L;
    case 19: 
      return 262144L;
    }
    return 524288L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.system.a
 * JD-Core Version:    0.7.0.1
 */