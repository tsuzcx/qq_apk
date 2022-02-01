package com.tencent.luggage.wxa.qz;

import com.tencent.luggage.wxa.qr.a;
import com.tencent.mmkv.MMKVHandler;
import com.tencent.mmkv.MMKVLogLevel;
import com.tencent.mmkv.MMKVRecoverStrategic;

final class w$1
  implements MMKVHandler
{
  public void mmkvLog(MMKVLogLevel paramMMKVLogLevel, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    o.d("MMKV", "[%s][%d][%s] %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramString3 });
  }
  
  public MMKVRecoverStrategic onMMKVCRCCheckFail(String paramString)
  {
    o.d("MicroMsg.MultiProcessMMKV", "onMMKVCRCCheckFail:%s", new Object[] { paramString });
    a.a.a(941L, 3L, 1L, true);
    return MMKVRecoverStrategic.OnErrorDiscard;
  }
  
  public MMKVRecoverStrategic onMMKVFileLengthError(String paramString)
  {
    o.d("MicroMsg.MultiProcessMMKV", "onMMKVFileLengthError:%s", new Object[] { paramString });
    a.a.a(941L, 4L, 1L, true);
    return MMKVRecoverStrategic.OnErrorDiscard;
  }
  
  public boolean wantLogRedirecting()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.w.1
 * JD-Core Version:    0.7.0.1
 */