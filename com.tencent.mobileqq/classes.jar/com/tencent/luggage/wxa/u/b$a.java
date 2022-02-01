package com.tencent.luggage.wxa.u;

import android.annotation.TargetApi;
import android.media.MediaCodec.CodecException;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.k;

public class b$a
  extends Exception
{
  public final String a;
  public final boolean b;
  public final String c;
  public final String d;
  
  public b$a(k paramk, Throwable paramThrowable, boolean paramBoolean, int paramInt)
  {
    super(localStringBuilder.toString(), paramThrowable);
    this.a = paramk.f;
    this.b = paramBoolean;
    this.c = null;
    this.d = a(paramInt);
  }
  
  public b$a(k paramk, Throwable paramThrowable, boolean paramBoolean, String paramString)
  {
    super(localStringBuilder.toString(), paramThrowable);
    this.a = paramk.f;
    this.b = paramBoolean;
    this.c = paramString;
    if (x.a >= 21) {
      paramk = a(paramThrowable);
    } else {
      paramk = null;
    }
    this.d = paramk;
  }
  
  private static String a(int paramInt)
  {
    String str;
    if (paramInt < 0) {
      str = "neg_";
    } else {
      str = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.google.android.exoplayer.MediaCodecTrackRenderer_");
    localStringBuilder.append(str);
    localStringBuilder.append(Math.abs(paramInt));
    return localStringBuilder.toString();
  }
  
  @TargetApi(21)
  private static String a(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof MediaCodec.CodecException)) {
      return ((MediaCodec.CodecException)paramThrowable).getDiagnosticInfo();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.u.b.a
 * JD-Core Version:    0.7.0.1
 */