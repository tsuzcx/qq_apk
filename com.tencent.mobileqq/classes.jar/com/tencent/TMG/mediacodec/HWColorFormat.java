package com.tencent.TMG.mediacodec;

public final class HWColorFormat
{
  public static final int COLOR_Format12bitRGB444 = 3;
  public static final int COLOR_Format16bitARGB1555 = 5;
  public static final int COLOR_Format16bitARGB4444 = 4;
  public static final int COLOR_Format16bitBGR565 = 7;
  public static final int COLOR_Format16bitRGB565 = 6;
  public static final int COLOR_Format18BitBGR666 = 41;
  public static final int COLOR_Format18bitARGB1665 = 9;
  public static final int COLOR_Format18bitRGB666 = 8;
  public static final int COLOR_Format19bitARGB1666 = 10;
  public static final int COLOR_Format24BitABGR6666 = 43;
  public static final int COLOR_Format24BitARGB6666 = 42;
  public static final int COLOR_Format24bitARGB1887 = 13;
  public static final int COLOR_Format24bitBGR888 = 12;
  public static final int COLOR_Format24bitRGB888 = 11;
  public static final int COLOR_Format25bitARGB1888 = 14;
  public static final int COLOR_Format32bitARGB8888 = 16;
  public static final int COLOR_Format32bitBGRA8888 = 15;
  public static final int COLOR_Format8bitRGB332 = 2;
  public static final int COLOR_FormatAndroidOpaque = 2130708361;
  public static final int COLOR_FormatCbYCrY = 27;
  public static final int COLOR_FormatCrYCbY = 28;
  public static final int COLOR_FormatKhronosExtensions = 1862270976;
  public static final int COLOR_FormatL16 = 36;
  public static final int COLOR_FormatL2 = 33;
  public static final int COLOR_FormatL24 = 37;
  public static final int COLOR_FormatL32 = 38;
  public static final int COLOR_FormatL4 = 34;
  public static final int COLOR_FormatL8 = 35;
  public static final int COLOR_FormatMonochrome = 1;
  public static final int COLOR_FormatRawBayer10bit = 31;
  public static final int COLOR_FormatRawBayer8bit = 30;
  public static final int COLOR_FormatRawBayer8bitcompressed = 32;
  public static final int COLOR_FormatVendorStartUnused = 2130706432;
  public static final int COLOR_FormatYCbYCr = 25;
  public static final int COLOR_FormatYCrYCb = 26;
  public static final int COLOR_FormatYUV411PackedPlanar = 18;
  public static final int COLOR_FormatYUV411Planar = 17;
  public static final int COLOR_FormatYUV420Flexible = 2135033992;
  public static final int COLOR_FormatYUV420PackedPlanar = 20;
  public static final int COLOR_FormatYUV420PackedSemiPlanar = 39;
  public static final int COLOR_FormatYUV420Planar = 19;
  public static final int COLOR_FormatYUV420SemiPlanar = 21;
  public static final int COLOR_FormatYUV422PackedPlanar = 23;
  public static final int COLOR_FormatYUV422PackedSemiPlanar = 40;
  public static final int COLOR_FormatYUV422Planar = 22;
  public static final int COLOR_FormatYUV422SemiPlanar = 24;
  public static final int COLOR_FormatYUV444Interleaved = 29;
  public static final int COLOR_MTK_FormatYUV420Planar = 2130706944;
  public static final int COLOR_QCOM_FormatYUV420PackedSemiPlanar16m2ka = 2141391874;
  public static final int COLOR_QCOM_FormatYUV420PackedSemiPlanar32m = 2141391876;
  public static final int COLOR_QCOM_FormatYUV420PackedSemiPlanar32mMultiView = 2141391877;
  public static final int COLOR_QCOM_FormatYUV420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
  public static final int COLOR_QCOM_FormatYVU420PackedSemiPlanar32m4ka = 2141391873;
  public static final int COLOR_QCOM_FormatYVU420SemiPlanar = 2141391872;
  public static final int COLOR_SEC_FormatNV12LPhysicalAddresses = 2130706434;
  public static final int COLOR_SEC_FormatNV12LVirtualAddresses = 2130706435;
  public static final int COLOR_SEC_FormatNV12TPhysicalAddresses = 2130706433;
  public static final int COLOR_SEC_FormatNV12Tiled = 2143289346;
  public static final int COLOR_SEC_TI_FormatYUV420PackedSemiPlanar = 2130706688;
  
  public static boolean isSupportedDecodeFormats(int paramInt)
  {
    return (paramInt == 19) || (paramInt == 20) || (paramInt == 21) || (paramInt == 2130706944) || (paramInt == 2141391876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.mediacodec.HWColorFormat
 * JD-Core Version:    0.7.0.1
 */