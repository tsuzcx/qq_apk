package com.android.dex;

public final class DexFormat
{
  public static final int API_CURRENT = 24;
  public static final int API_NO_EXTENDED_OPCODES = 13;
  public static final String DEX_IN_JAR_NAME = "classes.dex";
  public static final int ENDIAN_TAG = 305419896;
  public static final String MAGIC_PREFIX = "dex\n";
  public static final String MAGIC_SUFFIX = "";
  public static final int MAX_MEMBER_IDX = 65535;
  public static final int MAX_TYPE_IDX = 65535;
  public static final String VERSION_CURRENT = "037";
  public static final String VERSION_FOR_API_13 = "035";
  
  public static String apiToMagic(int paramInt)
  {
    if (paramInt >= 24) {}
    for (String str = "037";; str = "035") {
      return "dex\n" + str + "";
    }
  }
  
  public static boolean isSupportedDexMagic(byte[] paramArrayOfByte)
  {
    int i = magicToApi(paramArrayOfByte);
    return (i == 13) || (i == 24);
  }
  
  public static int magicToApi(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 8) {}
    do
    {
      do
      {
        return -1;
      } while ((paramArrayOfByte[0] != 100) || (paramArrayOfByte[1] != 101) || (paramArrayOfByte[2] != 120) || (paramArrayOfByte[3] != 10) || (paramArrayOfByte[7] != 0));
      paramArrayOfByte = "" + (char)paramArrayOfByte[4] + (char)paramArrayOfByte[5] + (char)paramArrayOfByte[6];
      if (paramArrayOfByte.equals("037")) {
        return 24;
      }
    } while (!paramArrayOfByte.equals("035"));
    return 13;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.DexFormat
 * JD-Core Version:    0.7.0.1
 */