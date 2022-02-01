package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.nio.charset.Charset;

public class d
{
  public static final Charset a = Charset.forName("UTF-8");
  
  public static Pair<byte[], String> a(String paramString)
  {
    if ((paramString != null) && (paramString.length() >= 32))
    {
      String str = paramString.substring(0, 32);
      paramString = paramString.substring(32);
      return new Pair(HexUtil.hexStr2ByteArray(str), paramString);
    }
    return new Pair(new byte[0], paramString);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    return new String(AesCbc.decrypt(HexUtil.hexStr2ByteArray((String)paramString1.second), HexUtil.hexStr2ByteArray(paramString2), (byte[])paramString1.first), a);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return HexUtil.byteArray2HexStr(AesCbc.encrypt(paramString1.getBytes(a), HexUtil.hexStr2ByteArray(paramString2)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.d
 * JD-Core Version:    0.7.0.1
 */