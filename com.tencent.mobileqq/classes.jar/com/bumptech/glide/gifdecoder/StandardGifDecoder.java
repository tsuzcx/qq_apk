package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StandardGifDecoder
  implements GifDecoder
{
  private static final String a = "StandardGifDecoder";
  @ColorInt
  private int[] b;
  @ColorInt
  private final int[] c = new int[256];
  private final GifDecoder.BitmapProvider d;
  private ByteBuffer e;
  private byte[] f;
  private short[] g;
  private byte[] h;
  private byte[] i;
  private byte[] j;
  @ColorInt
  private int[] k;
  private int l;
  private GifHeader m;
  private Bitmap n;
  private boolean o;
  private int p;
  private int q;
  private int r;
  private int s;
  @Nullable
  private Boolean t;
  @NonNull
  private Bitmap.Config u = Bitmap.Config.ARGB_8888;
  
  public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider paramBitmapProvider)
  {
    this.d = paramBitmapProvider;
    this.m = new GifHeader();
  }
  
  public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider paramBitmapProvider, GifHeader paramGifHeader, ByteBuffer paramByteBuffer, int paramInt)
  {
    this(paramBitmapProvider);
    a(paramGifHeader, paramByteBuffer, paramInt);
  }
  
  @ColorInt
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i6 = paramInt1;
    int i5 = 0;
    int i4 = 0;
    int i3 = 0;
    int i2 = 0;
    byte[] arrayOfByte;
    int i11;
    int i9;
    int i8;
    for (int i1 = 0; i6 < this.q + paramInt1; i1 = i7)
    {
      arrayOfByte = this.j;
      if ((i6 >= arrayOfByte.length) || (i6 >= paramInt2)) {
        break;
      }
      i7 = arrayOfByte[i6];
      int i12 = this.b[(i7 & 0xFF)];
      i11 = i5;
      i10 = i4;
      i9 = i3;
      i8 = i2;
      i7 = i1;
      if (i12 != 0)
      {
        i11 = i5 + (i12 >> 24 & 0xFF);
        i10 = i4 + (i12 >> 16 & 0xFF);
        i9 = i3 + (i12 >> 8 & 0xFF);
        i8 = i2 + (i12 & 0xFF);
        i7 = i1 + 1;
      }
      i6 += 1;
      i5 = i11;
      i4 = i10;
      i3 = i9;
      i2 = i8;
    }
    int i10 = paramInt1 + paramInt3;
    paramInt1 = i10;
    int i7 = i5;
    while (paramInt1 < this.q + i10)
    {
      arrayOfByte = this.j;
      if ((paramInt1 >= arrayOfByte.length) || (paramInt1 >= paramInt2)) {
        break;
      }
      paramInt3 = arrayOfByte[paramInt1];
      i11 = this.b[(paramInt3 & 0xFF)];
      i9 = i7;
      i8 = i4;
      i6 = i3;
      i5 = i2;
      paramInt3 = i1;
      if (i11 != 0)
      {
        i9 = i7 + (i11 >> 24 & 0xFF);
        i8 = i4 + (i11 >> 16 & 0xFF);
        i6 = i3 + (i11 >> 8 & 0xFF);
        i5 = i2 + (i11 & 0xFF);
        paramInt3 = i1 + 1;
      }
      paramInt1 += 1;
      i7 = i9;
      i4 = i8;
      i3 = i6;
      i2 = i5;
      i1 = paramInt3;
    }
    if (i1 == 0) {
      return 0;
    }
    return i7 / i1 << 24 | i4 / i1 << 16 | i3 / i1 << 8 | i2 / i1;
  }
  
  private Bitmap a(GifFrame paramGifFrame1, GifFrame paramGifFrame2)
  {
    int[] arrayOfInt = this.k;
    int i1 = 0;
    if (paramGifFrame2 == null)
    {
      Bitmap localBitmap = this.n;
      if (localBitmap != null) {
        this.d.a(localBitmap);
      }
      this.n = null;
      Arrays.fill(arrayOfInt, 0);
    }
    if ((paramGifFrame2 != null) && (paramGifFrame2.g == 3) && (this.n == null)) {
      Arrays.fill(arrayOfInt, 0);
    }
    if ((paramGifFrame2 != null) && (paramGifFrame2.g > 0))
    {
      if (paramGifFrame2.g == 2)
      {
        int i2;
        if (!paramGifFrame1.f)
        {
          i2 = this.m.l;
          if ((paramGifFrame1.k != null) && (this.m.j == paramGifFrame1.h)) {
            i2 = i1;
          }
        }
        else
        {
          i2 = i1;
          if (this.l == 0)
          {
            this.t = Boolean.valueOf(true);
            i2 = i1;
          }
        }
        int i5 = paramGifFrame2.d / this.q;
        i1 = paramGifFrame2.b / this.q;
        int i6 = paramGifFrame2.c / this.q;
        int i3 = paramGifFrame2.a / this.q;
        int i7 = this.s;
        int i4 = i1 * i7 + i3;
        i1 = i4;
        while (i1 < i5 * i7 + i4)
        {
          i3 = i1;
          while (i3 < i1 + i6)
          {
            arrayOfInt[i3] = i2;
            i3 += 1;
          }
          i1 += this.s;
        }
      }
      if (paramGifFrame2.g == 3)
      {
        paramGifFrame2 = this.n;
        if (paramGifFrame2 != null)
        {
          i1 = this.s;
          paramGifFrame2.getPixels(arrayOfInt, 0, i1, 0, 0, i1, this.r);
        }
      }
    }
    c(paramGifFrame1);
    if ((!paramGifFrame1.e) && (this.q == 1)) {
      a(paramGifFrame1);
    } else {
      b(paramGifFrame1);
    }
    if ((this.o) && ((paramGifFrame1.g == 0) || (paramGifFrame1.g == 1)))
    {
      if (this.n == null) {
        this.n = l();
      }
      paramGifFrame1 = this.n;
      i1 = this.s;
      paramGifFrame1.setPixels(arrayOfInt, 0, i1, 0, 0, i1, this.r);
    }
    paramGifFrame1 = l();
    i1 = this.s;
    paramGifFrame1.setPixels(arrayOfInt, 0, i1, 0, 0, i1, this.r);
    return paramGifFrame1;
  }
  
  private void a(GifFrame paramGifFrame)
  {
    Object localObject = paramGifFrame;
    int[] arrayOfInt1 = this.k;
    int i9 = ((GifFrame)localObject).d;
    int i10 = ((GifFrame)localObject).b;
    int i11 = ((GifFrame)localObject).c;
    int i12 = ((GifFrame)localObject).a;
    int i1;
    if (this.l == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i13 = this.s;
    localObject = this.j;
    int[] arrayOfInt2 = this.b;
    int i2 = 0;
    int i4 = -1;
    while (i2 < i9)
    {
      int i3 = (i2 + i10) * i13;
      int i6 = i3 + i12;
      int i5 = i6 + i11;
      int i7 = i3 + i13;
      i3 = i5;
      if (i7 < i5) {
        i3 = i7;
      }
      i5 = paramGifFrame.c * i2;
      while (i6 < i3)
      {
        int i8 = localObject[i5];
        int i14 = i8 & 0xFF;
        i7 = i4;
        if (i14 != i4)
        {
          i7 = arrayOfInt2[i14];
          if (i7 != 0)
          {
            arrayOfInt1[i6] = i7;
            i7 = i4;
          }
          else
          {
            i7 = i8;
          }
        }
        i5 += 1;
        i6 += 1;
        i4 = i7;
      }
      i2 += 1;
    }
    boolean bool;
    if ((this.t == null) && (i1 != 0) && (i4 != -1)) {
      bool = true;
    } else {
      bool = false;
    }
    this.t = Boolean.valueOf(bool);
  }
  
  private void b(GifFrame paramGifFrame)
  {
    int[] arrayOfInt1 = this.k;
    int i8 = paramGifFrame.d / this.q;
    int i7 = paramGifFrame.b / this.q;
    int i1 = paramGifFrame.c / this.q;
    int i16 = paramGifFrame.a / this.q;
    int i2 = this.l;
    Boolean localBoolean = Boolean.valueOf(true);
    int i6;
    if (i2 == 0) {
      i6 = 1;
    } else {
      i6 = 0;
    }
    int i17 = this.q;
    int i18 = this.s;
    int i19 = this.r;
    byte[] arrayOfByte = this.j;
    int[] arrayOfInt2 = this.b;
    Object localObject1 = this.t;
    int i4 = 0;
    i2 = 0;
    int i5 = 1;
    int i10;
    for (int i3 = 8; i4 < i8; i3 = i10)
    {
      int i9;
      int i11;
      if (paramGifFrame.e)
      {
        if (i2 >= i8)
        {
          i5 += 1;
          if (i5 != 2)
          {
            if (i5 != 3)
            {
              if (i5 == 4)
              {
                i2 = 1;
                i3 = 2;
              }
            }
            else
            {
              i2 = 2;
              i3 = 4;
            }
          }
          else {
            i2 = 4;
          }
        }
        i9 = i2 + i3;
        i11 = i2;
        i2 = i9;
        i9 = i5;
        i10 = i3;
      }
      else
      {
        i11 = i4;
        i10 = i3;
        i9 = i5;
      }
      i3 = i11 + i7;
      if (i17 == 1) {
        i5 = 1;
      } else {
        i5 = 0;
      }
      if (i3 < i19)
      {
        i3 *= i18;
        i11 = i3 + i16;
        int i12 = i11 + i1;
        int i13 = i3 + i18;
        i3 = i12;
        if (i13 < i12) {
          i3 = i13;
        }
        i12 = i4 * i17 * paramGifFrame.c;
        if (i5 != 0) {
          for (;;)
          {
            i5 = i1;
            localObject2 = localObject1;
            if (i11 >= i3) {
              break;
            }
            i5 = arrayOfInt2[(arrayOfByte[i12] & 0xFF)];
            if (i5 != 0)
            {
              arrayOfInt1[i11] = i5;
              localObject2 = localObject1;
            }
            else
            {
              localObject2 = localObject1;
              if (i6 != 0)
              {
                localObject2 = localObject1;
                if (localObject1 == null) {
                  localObject2 = localBoolean;
                }
              }
            }
            i12 += i17;
            i11 += 1;
            localObject1 = localObject2;
          }
        }
        i13 = i1;
        int i14 = i11;
        i5 = i12;
        i1 = i3;
        for (;;)
        {
          int i15 = i5;
          i5 = i1;
          localObject2 = localObject1;
          i1 = i13;
          if (i14 >= i5) {
            break;
          }
          i1 = a(i15, (i3 - i11) * i17 + i12, paramGifFrame.c);
          if (i1 != 0)
          {
            arrayOfInt1[i14] = i1;
            localObject2 = localObject1;
          }
          else
          {
            localObject2 = localObject1;
            if (i6 != 0)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = localBoolean;
              }
            }
          }
          i15 += i17;
          i14 += 1;
          i1 = i5;
          i5 = i15;
          localObject1 = localObject2;
        }
      }
      Object localObject2 = localObject1;
      i5 = i1;
      i1 = i5;
      i4 += 1;
      localObject1 = localObject2;
      i5 = i9;
    }
    if (this.t == null)
    {
      boolean bool;
      if (localObject1 == null) {
        bool = false;
      } else {
        bool = ((Boolean)localObject1).booleanValue();
      }
      this.t = Boolean.valueOf(bool);
    }
  }
  
  private void c(GifFrame paramGifFrame)
  {
    StandardGifDecoder localStandardGifDecoder = this;
    if (paramGifFrame != null) {
      localStandardGifDecoder.e.position(paramGifFrame.j);
    }
    int i14;
    if (paramGifFrame == null)
    {
      i14 = localStandardGifDecoder.m.f * localStandardGifDecoder.m.g;
    }
    else
    {
      i2 = paramGifFrame.c;
      i14 = paramGifFrame.d * i2;
    }
    paramGifFrame = localStandardGifDecoder.j;
    if ((paramGifFrame == null) || (paramGifFrame.length < i14)) {
      localStandardGifDecoder.j = localStandardGifDecoder.d.a(i14);
    }
    byte[] arrayOfByte1 = localStandardGifDecoder.j;
    if (localStandardGifDecoder.g == null) {
      localStandardGifDecoder.g = new short[4096];
    }
    short[] arrayOfShort = localStandardGifDecoder.g;
    if (localStandardGifDecoder.h == null) {
      localStandardGifDecoder.h = new byte[4096];
    }
    byte[] arrayOfByte2 = localStandardGifDecoder.h;
    if (localStandardGifDecoder.i == null) {
      localStandardGifDecoder.i = new byte[4097];
    }
    byte[] arrayOfByte3 = localStandardGifDecoder.i;
    int i2 = j();
    int i22 = 1 << i2;
    int i15 = i22 + 2;
    int i17 = i2 + 1;
    int i16 = (1 << i17) - 1;
    int i18 = 0;
    i2 = 0;
    while (i2 < i22)
    {
      arrayOfShort[i2] = 0;
      arrayOfByte2[i2] = ((byte)i2);
      i2 += 1;
    }
    byte[] arrayOfByte4 = localStandardGifDecoder.f;
    int i4 = i17;
    int i7 = i15;
    int i9 = i16;
    int i10 = 0;
    int i8 = 0;
    int i12 = 0;
    int i13 = 0;
    int i3 = 0;
    int i5 = -1;
    int i6 = 0;
    int i11 = 0;
    i2 = i18;
    paramGifFrame = localStandardGifDecoder;
    while (i2 < i14)
    {
      i18 = i10;
      if (i10 == 0)
      {
        i18 = k();
        if (i18 <= 0)
        {
          paramGifFrame.p = 3;
          break;
        }
        i13 = 0;
      }
      i12 += ((arrayOfByte4[i13] & 0xFF) << i8);
      int i19 = i13 + 1;
      int i20 = i18 - 1;
      i13 = i8 + 8;
      i8 = i5;
      i5 = i6;
      i10 = i7;
      i6 = i4;
      i7 = i5;
      i5 = i10;
      i4 = i3;
      i3 = i2;
      i2 = i8;
      i10 = i17;
      i8 = i13;
      for (;;)
      {
        label397:
        if (i8 < i6) {
          break label807;
        }
        i13 = i12 & i9;
        i12 >>= i6;
        i8 -= i6;
        if (i13 == i22)
        {
          i6 = i10;
          i5 = i15;
          i9 = i16;
          i2 = -1;
        }
        for (;;)
        {
          break label397;
          if (i13 == i22 + 1)
          {
            i18 = i6;
            i13 = i3;
            i3 = i4;
            i4 = i5;
            i6 = i7;
            i5 = i2;
            i17 = i10;
            i2 = i13;
            i10 = i20;
            i13 = i19;
            i7 = i4;
            i4 = i18;
            break;
          }
          if (i2 != -1) {
            break label545;
          }
          arrayOfByte1[i4] = arrayOfByte2[i13];
          i4 += 1;
          i3 += 1;
          paramGifFrame = this;
          i2 = i13;
          i7 = i2;
        }
        label545:
        i17 = i5;
        if (i13 >= i17)
        {
          arrayOfByte3[i11] = ((byte)i7);
          i5 = i11 + 1;
          i7 = i2;
        }
        else
        {
          i7 = i13;
          i5 = i11;
        }
        while (i7 >= i22)
        {
          arrayOfByte3[i5] = arrayOfByte2[i7];
          i5 += 1;
          i7 = arrayOfShort[i7];
        }
        int i21 = arrayOfByte2[i7] & 0xFF;
        int i1 = (byte)i21;
        arrayOfByte1[i4] = i1;
        for (;;)
        {
          i4 += 1;
          i11 = i3 + 1;
          if (i5 <= 0) {
            break;
          }
          i5 -= 1;
          arrayOfByte1[i4] = arrayOfByte3[i5];
          i3 = i11;
        }
        i3 = i17;
        i18 = i6;
        i7 = i9;
        if (i17 < 4096)
        {
          arrayOfShort[i17] = ((short)i2);
          arrayOfByte2[i17] = i1;
          i2 = i17 + 1;
          i3 = i2;
          i18 = i6;
          i7 = i9;
          if ((i2 & i9) == 0)
          {
            i3 = i2;
            i18 = i6;
            i7 = i9;
            if (i2 < 4096)
            {
              i18 = i6 + 1;
              i7 = i9 + i2;
              i3 = i2;
            }
          }
        }
        i2 = i13;
        i13 = i21;
        i17 = i3;
        paramGifFrame = this;
        i6 = i18;
        i3 = i11;
        i11 = i5;
        i9 = i7;
        i5 = i17;
        i7 = i13;
      }
      label807:
      i18 = i6;
      i6 = i7;
      i13 = i3;
      i3 = i4;
      i7 = i5;
      i5 = i2;
      paramGifFrame = this;
      i17 = i10;
      i2 = i13;
      i10 = i20;
      i13 = i19;
      i4 = i18;
    }
    Arrays.fill(arrayOfByte1, i3, i14, (byte)0);
  }
  
  private int j()
  {
    return this.e.get() & 0xFF;
  }
  
  private int k()
  {
    int i1 = j();
    if (i1 <= 0) {
      return i1;
    }
    ByteBuffer localByteBuffer = this.e;
    localByteBuffer.get(this.f, 0, Math.min(i1, localByteBuffer.remaining()));
    return i1;
  }
  
  private Bitmap l()
  {
    Object localObject = this.t;
    if ((localObject != null) && (!((Boolean)localObject).booleanValue())) {
      localObject = this.u;
    } else {
      localObject = Bitmap.Config.ARGB_8888;
    }
    localObject = this.d.a(this.s, this.r, (Bitmap.Config)localObject);
    ((Bitmap)localObject).setHasAlpha(true);
    return localObject;
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.m.c)) {
      return ((GifFrame)this.m.e.get(paramInt)).i;
    }
    return -1;
  }
  
  @NonNull
  public ByteBuffer a()
  {
    return this.e;
  }
  
  public void a(@NonNull Bitmap.Config paramConfig)
  {
    if ((paramConfig != Bitmap.Config.ARGB_8888) && (paramConfig != Bitmap.Config.RGB_565))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unsupported format: ");
      localStringBuilder.append(paramConfig);
      localStringBuilder.append(", must be one of ");
      localStringBuilder.append(Bitmap.Config.ARGB_8888);
      localStringBuilder.append(" or ");
      localStringBuilder.append(Bitmap.Config.RGB_565);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.u = paramConfig;
  }
  
  public void a(@NonNull GifHeader paramGifHeader, @NonNull ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt > 0) {
      try
      {
        paramInt = Integer.highestOneBit(paramInt);
        this.p = 0;
        this.m = paramGifHeader;
        this.l = -1;
        this.e = paramByteBuffer.asReadOnlyBuffer();
        this.e.position(0);
        this.e.order(ByteOrder.LITTLE_ENDIAN);
        this.o = false;
        paramByteBuffer = paramGifHeader.e.iterator();
        while (paramByteBuffer.hasNext()) {
          if (((GifFrame)paramByteBuffer.next()).g == 3) {
            this.o = true;
          }
        }
        this.q = paramInt;
        this.s = (paramGifHeader.f / paramInt);
        this.r = (paramGifHeader.g / paramInt);
        this.j = this.d.a(paramGifHeader.f * paramGifHeader.g);
        this.k = this.d.b(this.s * this.r);
        return;
      }
      finally
      {
        break label209;
      }
    }
    paramGifHeader = new StringBuilder();
    paramGifHeader.append("Sample size must be >=0, not: ");
    paramGifHeader.append(paramInt);
    throw new IllegalArgumentException(paramGifHeader.toString());
    for (;;)
    {
      label209:
      throw paramGifHeader;
    }
  }
  
  public void b()
  {
    this.l = ((this.l + 1) % this.m.c);
  }
  
  public int c()
  {
    if (this.m.c > 0)
    {
      int i1 = this.l;
      if (i1 >= 0) {
        return a(i1);
      }
    }
    return 0;
  }
  
  public int d()
  {
    return this.m.c;
  }
  
  public int e()
  {
    return this.l;
  }
  
  public void f()
  {
    this.l = -1;
  }
  
  public int g()
  {
    return this.e.limit() + this.j.length + this.k.length * 4;
  }
  
  @Nullable
  public Bitmap h()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        Object localObject4;
        if ((this.m.c <= 0) || (this.l < 0))
        {
          if (Log.isLoggable(a, 3))
          {
            localObject1 = a;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("Unable to decode frame, frameCount=");
            ((StringBuilder)localObject4).append(this.m.c);
            ((StringBuilder)localObject4).append(", framePointer=");
            ((StringBuilder)localObject4).append(this.l);
            Log.d((String)localObject1, ((StringBuilder)localObject4).toString());
          }
          this.p = 1;
        }
        if ((this.p != 1) && (this.p != 2))
        {
          this.p = 0;
          if (this.f == null) {
            this.f = this.d.a(255);
          }
          GifFrame localGifFrame = (GifFrame)this.m.e.get(this.l);
          int i1 = this.l - 1;
          if (i1 >= 0)
          {
            localObject1 = (GifFrame)this.m.e.get(i1);
            if (localGifFrame.k != null) {
              localObject4 = localGifFrame.k;
            } else {
              localObject4 = this.m.a;
            }
            this.b = ((int[])localObject4);
            if (this.b == null)
            {
              if (Log.isLoggable(a, 3))
              {
                localObject1 = a;
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("No valid color table found for frame #");
                ((StringBuilder)localObject4).append(this.l);
                Log.d((String)localObject1, ((StringBuilder)localObject4).toString());
              }
              this.p = 1;
              return null;
            }
            if (localGifFrame.f)
            {
              System.arraycopy(this.b, 0, this.c, 0, this.b.length);
              this.b = this.c;
              this.b[localGifFrame.h] = 0;
            }
            localObject1 = a(localGifFrame, (GifFrame)localObject1);
            return localObject1;
          }
        }
        else
        {
          if (Log.isLoggable(a, 3))
          {
            localObject1 = a;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("Unable to decode frame, status=");
            ((StringBuilder)localObject4).append(this.p);
            Log.d((String)localObject1, ((StringBuilder)localObject4).toString());
          }
          return null;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
  
  public void i()
  {
    this.m = null;
    Object localObject = this.j;
    if (localObject != null) {
      this.d.a((byte[])localObject);
    }
    localObject = this.k;
    if (localObject != null) {
      this.d.a((int[])localObject);
    }
    localObject = this.n;
    if (localObject != null) {
      this.d.a((Bitmap)localObject);
    }
    this.n = null;
    this.e = null;
    this.t = null;
    localObject = this.f;
    if (localObject != null) {
      this.d.a((byte[])localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.gifdecoder.StandardGifDecoder
 * JD-Core Version:    0.7.0.1
 */