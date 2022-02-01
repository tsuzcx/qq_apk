package com.tencent.luggage.wxa.p;

import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.l.l.a;

public final class k
{
  public final boolean a;
  @Nullable
  public final String b;
  public final l.a c;
  public final int d;
  public final byte[] e;
  
  public k(boolean paramBoolean, @Nullable String paramString, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, @Nullable byte[] paramArrayOfByte2)
  {
    int j = 1;
    int i;
    if (paramInt1 == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramArrayOfByte2 != null) {
      j = 0;
    }
    a.a(j ^ i);
    this.a = paramBoolean;
    this.b = paramString;
    this.d = paramInt1;
    this.e = paramArrayOfByte2;
    this.c = new l.a(a(paramString), paramArrayOfByte1, paramInt2, paramInt3);
  }
  
  private static int a(@Nullable String paramString)
  {
    if (paramString == null) {
      return 1;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 3049895: 
      if (paramString.equals("cens")) {
        i = 1;
      }
      break;
    case 3049879: 
      if (paramString.equals("cenc")) {
        i = 0;
      }
      break;
    case 3046671: 
      if (paramString.equals("cbcs")) {
        i = 3;
      }
      break;
    case 3046605: 
      if (paramString.equals("cbc1")) {
        i = 2;
      }
      break;
    }
    if ((i != 0) && (i != 1))
    {
      if ((i != 2) && (i != 3))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unsupported protection scheme type '");
        localStringBuilder.append(paramString);
        localStringBuilder.append("'. Assuming AES-CTR crypto mode.");
        Log.w("TrackEncryptionBox", localStringBuilder.toString());
        return 1;
      }
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.p.k
 * JD-Core Version:    0.7.0.1
 */