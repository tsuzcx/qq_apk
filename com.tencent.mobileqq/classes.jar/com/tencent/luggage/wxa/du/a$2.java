package com.tencent.luggage.wxa.du;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.dq.d.a;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.ku.t.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.Arrays;

class a$2
  implements t.b
{
  a$2(a parama, int paramInt, String paramString1, String paramString2) {}
  
  public void a(@Nullable String paramString, @NonNull d.a[] paramArrayOfa, @NonNull boolean[] paramArrayOfBoolean, @NonNull Object[] paramArrayOfObject, long paramLong1, long paramLong2)
  {
    o.d("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFileWithOptions appId[%s] contextId[%d] paths[%s] options[%s] results[%s]", new Object[] { this.d.c.getAppId(), Integer.valueOf(this.a), this.b, this.c, Arrays.toString(paramArrayOfBoolean) });
    this.d.a(paramString, paramArrayOfa, paramArrayOfBoolean, paramArrayOfObject, paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.du.a.2
 * JD-Core Version:    0.7.0.1
 */