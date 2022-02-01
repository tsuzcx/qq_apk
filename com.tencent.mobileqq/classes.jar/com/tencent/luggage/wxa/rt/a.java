package com.tencent.luggage.wxa.rt;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;

public abstract class a
  implements d
{
  private static d a(d paramd, String paramString, int paramInt)
  {
    while ((paramd instanceof b)) {
      paramd = ((b)paramd).a(paramString, paramInt);
    }
    return paramd;
  }
  
  public ParcelFileDescriptor a(String paramString1, String paramString2)
  {
    throw new FileNotFoundException("Not supported by the filesystem.");
  }
  
  public ReadableByteChannel a(String paramString)
  {
    return Channels.newChannel(b(paramString));
  }
  
  public void a(CancellationSignal paramCancellationSignal) {}
  
  public void a(Map<String, String> paramMap) {}
  
  public boolean a(String paramString1, d paramd, String paramString2)
  {
    d locald = a(this, paramString1, 2);
    paramd = a(paramd, paramString2, 1);
    if ((locald != null) && (paramd != null))
    {
      if ((locald instanceof a)) {
        return ((a)locald).b(paramString1, paramd, paramString2);
      }
      return locald.a(paramString1, paramd, paramString2);
    }
    throw new IOException("Cannot resolve delegate filesystem.");
  }
  
  protected boolean b(String paramString1, d paramd, String paramString2)
  {
    return false;
  }
  
  public long c(String paramString1, d paramd, String paramString2)
  {
    d locald = a(this, paramString1, 2);
    paramd = a(paramd, paramString2, 1);
    if ((locald != null) && (paramd != null))
    {
      if ((locald instanceof a)) {
        return ((a)locald).d(paramString1, paramd, paramString2);
      }
      return locald.c(paramString1, paramd, paramString2);
    }
    throw new IOException("Cannot resolve delegate filesystem.");
  }
  
  protected long d(String paramString1, d paramd, String paramString2)
  {
    return o.a(paramd, paramString2, this, paramString1);
  }
  
  public int describeContents()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.a
 * JD-Core Version:    0.7.0.1
 */