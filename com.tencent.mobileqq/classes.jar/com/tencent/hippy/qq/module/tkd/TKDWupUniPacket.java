package com.tencent.hippy.qq.module.tkd;

import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import java.util.HashMap;

public class TKDWupUniPacket
  extends UniPacket
{
  public static String TAG = TKDWupUniPacket.class.getSimpleName();
  
  public byte[] getRawResponseData(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    if (!this._data.containsKey(paramString1)) {
      return null;
    }
    paramString1 = (HashMap)this._data.get(paramString1);
    if (paramString1 == null) {
      return null;
    }
    return (byte[])paramString1.get(paramString2);
  }
  
  public HashMap<String, byte[]> getRspDataMap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this._data.containsKey(paramString)) {
      return null;
    }
    return (HashMap)this._data.get(paramString);
  }
  
  public void putRawRequestData(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString2, paramArrayOfByte);
    this._data.put(paramString1, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDWupUniPacket
 * JD-Core Version:    0.7.0.1
 */