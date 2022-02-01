package com.tencent.luggage.wxa.qq;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ig.e;
import com.tencent.luggage.wxa.qj.a;
import com.tencent.luggage.wxa.qj.i;
import com.tencent.luggage.wxa.qz.o;

public class c
{
  public static boolean a(int paramInt)
  {
    if ((paramInt != 10) && (paramInt != 11))
    {
      a locala = i.i();
      return (locala != null) && (locala.a(paramInt));
    }
    return true;
  }
  
  public static boolean a(e parame)
  {
    if (parame == null) {
      return false;
    }
    if (TextUtils.isEmpty(parame.w)) {
      return false;
    }
    o.e("MicroMsg.Music.MusicPlayerSupport", "protocol:%s", new Object[] { parame.w });
    return "hls".equalsIgnoreCase(parame.w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qq.c
 * JD-Core Version:    0.7.0.1
 */