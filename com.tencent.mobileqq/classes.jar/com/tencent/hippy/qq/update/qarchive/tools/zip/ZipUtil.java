package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.CRC32;

public abstract class ZipUtil
{
  private static final byte[] DOS_TIME_MIN = ZipLong.getBytes(8448L);
  
  public static long adjustToLong(int paramInt)
  {
    if (paramInt < 0) {
      return paramInt + 4294967296L;
    }
    return paramInt;
  }
  
  static boolean canHandleEntryData(ZipEntry paramZipEntry)
  {
    return (supportsEncryptionOf(paramZipEntry)) && (supportsMethodOf(paramZipEntry));
  }
  
  static void checkRequestedFeatures(ZipEntry paramZipEntry)
  {
    if (supportsEncryptionOf(paramZipEntry))
    {
      if (supportsMethodOf(paramZipEntry)) {
        return;
      }
      throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.METHOD, paramZipEntry);
    }
    throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.ENCRYPTION, paramZipEntry);
  }
  
  static byte[] copy(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
      return arrayOfByte;
    }
    return null;
  }
  
  public static long dosToJavaTime(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, (int)(paramLong >> 25 & 0x7F) + 1980);
    localCalendar.set(2, (int)(paramLong >> 21 & 0xF) - 1);
    localCalendar.set(5, (int)(paramLong >> 16) & 0x1F);
    localCalendar.set(11, (int)(paramLong >> 11) & 0x1F);
    localCalendar.set(12, (int)(paramLong >> 5) & 0x3F);
    localCalendar.set(13, (int)(paramLong << 1) & 0x3E);
    return localCalendar.getTime().getTime();
  }
  
  public static Date fromDosTime(ZipLong paramZipLong)
  {
    return new Date(dosToJavaTime(paramZipLong.getValue()));
  }
  
  private static String getUnicodeStringIfOriginalMatches(AbstractUnicodeExtraField paramAbstractUnicodeExtraField, byte[] paramArrayOfByte)
  {
    if (paramAbstractUnicodeExtraField != null)
    {
      CRC32 localCRC32 = new CRC32();
      localCRC32.update(paramArrayOfByte);
      if (localCRC32.getValue() != paramAbstractUnicodeExtraField.getNameCRC32()) {}
    }
    try
    {
      paramAbstractUnicodeExtraField = ZipEncodingHelper.UTF8_ZIP_ENCODING.decode(paramAbstractUnicodeExtraField.getUnicodeName());
      return paramAbstractUnicodeExtraField;
    }
    catch (IOException paramAbstractUnicodeExtraField) {}
    return null;
    return null;
  }
  
  static void setNameAndCommentFromExtraFields(ZipEntry paramZipEntry, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    UnicodePathExtraField localUnicodePathExtraField = (UnicodePathExtraField)paramZipEntry.getExtraField(UnicodePathExtraField.UPATH_ID);
    String str = paramZipEntry.getName();
    paramArrayOfByte1 = getUnicodeStringIfOriginalMatches(localUnicodePathExtraField, paramArrayOfByte1);
    if ((paramArrayOfByte1 != null) && (!str.equals(paramArrayOfByte1))) {
      paramZipEntry.setName(paramArrayOfByte1);
    }
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0))
    {
      paramArrayOfByte1 = getUnicodeStringIfOriginalMatches((UnicodeCommentExtraField)paramZipEntry.getExtraField(UnicodeCommentExtraField.UCOM_ID), paramArrayOfByte2);
      if (paramArrayOfByte1 != null) {
        paramZipEntry.setComment(paramArrayOfByte1);
      }
    }
  }
  
  private static boolean supportsEncryptionOf(ZipEntry paramZipEntry)
  {
    return paramZipEntry.getGeneralPurposeBit().usesEncryption() ^ true;
  }
  
  private static boolean supportsMethodOf(ZipEntry paramZipEntry)
  {
    return (paramZipEntry.getMethod() == 0) || (paramZipEntry.getMethod() == 8);
  }
  
  public static ZipLong toDosTime(Date paramDate)
  {
    return new ZipLong(toDosTime(paramDate.getTime()));
  }
  
  public static byte[] toDosTime(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(1);
    if (i < 1980) {
      return copy(DOS_TIME_MIN);
    }
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    int m = localCalendar.get(11);
    int n = localCalendar.get(12);
    return ZipLong.getBytes(localCalendar.get(13) >> 1 | i - 1980 << 25 | j + 1 << 21 | k << 16 | m << 11 | n << 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ZipUtil
 * JD-Core Version:    0.7.0.1
 */