package com.tencent.liteav.muxer;

import android.content.Context;
import android.media.MediaFormat;
import com.tencent.liteav.basic.log.TXCLog;

public class c
  implements a
{
  private int a = 0;
  private a b;
  
  public c(Context paramContext, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (a(paramContext))
        {
          this.a = 0;
          this.b = new d();
          TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use sw model ");
          return;
        }
        this.a = 1;
        this.b = new b();
        TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use hw model ");
        return;
      }
      this.a = 1;
      this.b = new b();
      TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use hw model ");
      return;
    }
    this.a = 0;
    this.b = new d();
    TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use sw model ");
  }
  
  public static boolean a(Context paramContext)
  {
    com.tencent.liteav.basic.d.c.a().a(paramContext);
    return com.tencent.liteav.basic.d.c.a().f() == 1;
  }
  
  public int a()
  {
    return this.b.a();
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    this.b.a(paramMediaFormat);
  }
  
  public void a(String paramString)
  {
    this.b.a(paramString);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    this.b.a(paramArrayOfByte, paramInt1, paramInt2, paramLong, paramInt3);
  }
  
  public int b()
  {
    return this.b.b();
  }
  
  public void b(MediaFormat paramMediaFormat)
  {
    this.b.b(paramMediaFormat);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    this.b.b(paramArrayOfByte, paramInt1, paramInt2, paramLong, paramInt3);
  }
  
  public boolean c()
  {
    return this.b.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.muxer.c
 * JD-Core Version:    0.7.0.1
 */