package com.huawei.hms.common.internal;

import com.huawei.hms.utils.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class TransactionIdCreater
{
  private static final int API_SIZE = 6;
  private static final int APPID_SIZE = 9;
  private static final char FILL_BYTE = '0';
  
  public static String getId(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.addByteForNum(paramString1, 9, '0'));
    localStringBuilder.append(StringUtil.addByteForNum(paramString2, 6, '0'));
    localStringBuilder.append(new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.ENGLISH).format(new Date()));
    localStringBuilder.append(String.format(Locale.ENGLISH, "%06d", new Object[] { Integer.valueOf(new Random().nextInt(1000000)) }));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.TransactionIdCreater
 * JD-Core Version:    0.7.0.1
 */