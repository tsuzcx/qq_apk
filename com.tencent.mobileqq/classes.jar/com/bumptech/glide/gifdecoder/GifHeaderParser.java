package com.bumptech.glide.gifdecoder;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

public class GifHeaderParser
{
  private final byte[] a = new byte[256];
  private ByteBuffer b;
  private GifHeader c;
  private int d = 0;
  
  private void a(int paramInt)
  {
    int i = 0;
    while ((i == 0) && (!o()) && (this.c.c <= paramInt))
    {
      int j = m();
      if (j != 33)
      {
        if (j != 44)
        {
          if (j != 59) {
            this.c.b = 1;
          } else {
            i = 1;
          }
        }
        else
        {
          if (this.c.d == null) {
            this.c.d = new GifFrame();
          }
          f();
        }
      }
      else
      {
        j = m();
        if (j != 1)
        {
          if (j != 249)
          {
            if (j != 254)
            {
              if (j != 255)
              {
                k();
              }
              else
              {
                l();
                StringBuilder localStringBuilder = new StringBuilder();
                j = 0;
                while (j < 11)
                {
                  localStringBuilder.append((char)this.a[j]);
                  j += 1;
                }
                if (localStringBuilder.toString().equals("NETSCAPE2.0")) {
                  g();
                } else {
                  k();
                }
              }
            }
            else {
              k();
            }
          }
          else
          {
            this.c.d = new GifFrame();
            e();
          }
        }
        else {
          k();
        }
      }
    }
  }
  
  @Nullable
  private int[] b(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt * 3];
    localObject = null;
    try
    {
      this.b.get(arrayOfByte);
      int[] arrayOfInt = new int[256];
      int i = 0;
      int j = 0;
      for (;;)
      {
        localObject = arrayOfInt;
        if (i >= paramInt) {
          break;
        }
        int k = j + 1;
        j = arrayOfByte[j];
        int m = k + 1;
        arrayOfInt[i] = ((j & 0xFF) << 16 | 0xFF000000 | (arrayOfByte[k] & 0xFF) << 8 | arrayOfByte[m] & 0xFF);
        j = m + 1;
        i += 1;
      }
      return localObject;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      if (Log.isLoggable("GifHeaderParser", 3)) {
        Log.d("GifHeaderParser", "Format Error Reading Color Table", localBufferUnderflowException);
      }
      this.c.b = 1;
    }
  }
  
  private void c()
  {
    this.b = null;
    Arrays.fill(this.a, (byte)0);
    this.c = new GifHeader();
    this.d = 0;
  }
  
  private void d()
  {
    a(2147483647);
  }
  
  private void e()
  {
    m();
    int i = m();
    this.c.d.g = ((i & 0x1C) >> 2);
    int j = this.c.d.g;
    boolean bool = true;
    if (j == 0) {
      this.c.d.g = 1;
    }
    GifFrame localGifFrame = this.c.d;
    if ((i & 0x1) == 0) {
      bool = false;
    }
    localGifFrame.f = bool;
    j = n();
    i = j;
    if (j < 2) {
      i = 10;
    }
    this.c.d.i = (i * 10);
    this.c.d.h = m();
    m();
  }
  
  private void f()
  {
    this.c.d.a = n();
    this.c.d.b = n();
    this.c.d.c = n();
    this.c.d.d = n();
    int j = m();
    boolean bool = false;
    int i;
    if ((j & 0x80) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    int k = (int)Math.pow(2.0D, (j & 0x7) + 1);
    Object localObject = this.c.d;
    if ((j & 0x40) != 0) {
      bool = true;
    }
    ((GifFrame)localObject).e = bool;
    if (i != 0) {
      this.c.d.k = b(k);
    } else {
      this.c.d.k = null;
    }
    this.c.d.j = this.b.position();
    j();
    if (o()) {
      return;
    }
    localObject = this.c;
    ((GifHeader)localObject).c += 1;
    this.c.e.add(this.c.d);
  }
  
  private void g()
  {
    do
    {
      l();
      byte[] arrayOfByte = this.a;
      if (arrayOfByte[0] == 1)
      {
        int i = arrayOfByte[1];
        int j = arrayOfByte[2];
        this.c.m = ((j & 0xFF) << 8 | i & 0xFF);
      }
    } while ((this.d > 0) && (!o()));
  }
  
  private void h()
  {
    Object localObject = new StringBuilder();
    int i = 0;
    while (i < 6)
    {
      ((StringBuilder)localObject).append((char)m());
      i += 1;
    }
    if (!((StringBuilder)localObject).toString().startsWith("GIF"))
    {
      this.c.b = 1;
      return;
    }
    i();
    if ((this.c.h) && (!o()))
    {
      localObject = this.c;
      ((GifHeader)localObject).a = b(((GifHeader)localObject).i);
      localObject = this.c;
      ((GifHeader)localObject).l = localObject.a[this.c.j];
    }
  }
  
  private void i()
  {
    this.c.f = n();
    this.c.g = n();
    int i = m();
    GifHeader localGifHeader = this.c;
    boolean bool;
    if ((i & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localGifHeader.h = bool;
    this.c.i = ((int)Math.pow(2.0D, (i & 0x7) + 1));
    this.c.j = m();
    this.c.k = m();
  }
  
  private void j()
  {
    m();
    k();
  }
  
  private void k()
  {
    int i;
    do
    {
      i = m();
      int j = Math.min(this.b.position() + i, this.b.limit());
      this.b.position(j);
    } while (i > 0);
  }
  
  private void l()
  {
    this.d = m();
    if (this.d > 0)
    {
      int j = 0;
      int i = 0;
      for (;;)
      {
        int k = i;
        try
        {
          if (j < this.d)
          {
            k = i;
            i = this.d - j;
            k = i;
            this.b.get(this.a, j, i);
            j += i;
          }
        }
        catch (Exception localException)
        {
          if (Log.isLoggable("GifHeaderParser", 3))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Error Reading Block n: ");
            localStringBuilder.append(j);
            localStringBuilder.append(" count: ");
            localStringBuilder.append(k);
            localStringBuilder.append(" blockSize: ");
            localStringBuilder.append(this.d);
            Log.d("GifHeaderParser", localStringBuilder.toString(), localException);
          }
          this.c.b = 1;
        }
      }
    }
  }
  
  private int m()
  {
    try
    {
      int i = this.b.get();
      return i & 0xFF;
    }
    catch (Exception localException)
    {
      label14:
      break label14;
    }
    this.c.b = 1;
    return 0;
  }
  
  private int n()
  {
    return this.b.getShort();
  }
  
  private boolean o()
  {
    return this.c.b != 0;
  }
  
  public GifHeaderParser a(@NonNull ByteBuffer paramByteBuffer)
  {
    c();
    this.b = paramByteBuffer.asReadOnlyBuffer();
    this.b.position(0);
    this.b.order(ByteOrder.LITTLE_ENDIAN);
    return this;
  }
  
  public void a()
  {
    this.b = null;
    this.c = null;
  }
  
  @NonNull
  public GifHeader b()
  {
    if (this.b != null)
    {
      if (o()) {
        return this.c;
      }
      h();
      if (!o())
      {
        d();
        if (this.c.c < 0) {
          this.c.b = 1;
        }
      }
      return this.c;
    }
    throw new IllegalStateException("You must call setData() before parseHeader()");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.gifdecoder.GifHeaderParser
 * JD-Core Version:    0.7.0.1
 */