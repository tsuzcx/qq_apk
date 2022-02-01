package com.bumptech.glide.load.resource.bitmap;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser
  implements ImageHeaderParser
{
  static final byte[] a = "".getBytes(Charset.forName("UTF-8"));
  private static final int[] b = { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 + 2 + paramInt2 * 12;
  }
  
  private static int a(DefaultImageHeaderParser.RandomAccessReader paramRandomAccessReader)
  {
    int i = paramRandomAccessReader.b(6);
    Object localObject;
    if (i != 18761)
    {
      if (i != 19789)
      {
        if (Log.isLoggable("DfltImageHeaderParser", 3))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unknown endianness = ");
          ((StringBuilder)localObject).append(i);
          Log.d("DfltImageHeaderParser", ((StringBuilder)localObject).toString());
        }
        localObject = ByteOrder.BIG_ENDIAN;
      }
      else
      {
        localObject = ByteOrder.BIG_ENDIAN;
      }
    }
    else {
      localObject = ByteOrder.LITTLE_ENDIAN;
    }
    paramRandomAccessReader.a((ByteOrder)localObject);
    int j = paramRandomAccessReader.a(10) + 6;
    int k = paramRandomAccessReader.b(j);
    i = 0;
    while (i < k)
    {
      int n = a(j, i);
      int m = paramRandomAccessReader.b(n);
      if (m == 274)
      {
        int i1 = paramRandomAccessReader.b(n + 2);
        if ((i1 >= 1) && (i1 <= 12))
        {
          int i2 = paramRandomAccessReader.a(n + 4);
          if (i2 < 0)
          {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
              Log.d("DfltImageHeaderParser", "Negative tiff component count");
            }
          }
          else
          {
            if (Log.isLoggable("DfltImageHeaderParser", 3))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Got tagIndex=");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(" tagType=");
              ((StringBuilder)localObject).append(m);
              ((StringBuilder)localObject).append(" formatCode=");
              ((StringBuilder)localObject).append(i1);
              ((StringBuilder)localObject).append(" componentCount=");
              ((StringBuilder)localObject).append(i2);
              Log.d("DfltImageHeaderParser", ((StringBuilder)localObject).toString());
            }
            i2 += b[i1];
            if (i2 > 4)
            {
              if (Log.isLoggable("DfltImageHeaderParser", 3))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("Got byte count > 4, not orientation, continuing, formatCode=");
                ((StringBuilder)localObject).append(i1);
                Log.d("DfltImageHeaderParser", ((StringBuilder)localObject).toString());
              }
            }
            else
            {
              n += 8;
              if ((n >= 0) && (n <= paramRandomAccessReader.a()))
              {
                if ((i2 >= 0) && (i2 + n <= paramRandomAccessReader.a())) {
                  return paramRandomAccessReader.b(n);
                }
                if (Log.isLoggable("DfltImageHeaderParser", 3))
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("Illegal number of bytes for TI tag data tagType=");
                  ((StringBuilder)localObject).append(m);
                  Log.d("DfltImageHeaderParser", ((StringBuilder)localObject).toString());
                }
              }
              else if (Log.isLoggable("DfltImageHeaderParser", 3))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("Illegal tagValueOffset=");
                ((StringBuilder)localObject).append(n);
                ((StringBuilder)localObject).append(" tagType=");
                ((StringBuilder)localObject).append(m);
                Log.d("DfltImageHeaderParser", ((StringBuilder)localObject).toString());
              }
            }
          }
        }
        else if (Log.isLoggable("DfltImageHeaderParser", 3))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Got invalid format code = ");
          ((StringBuilder)localObject).append(i1);
          Log.d("DfltImageHeaderParser", ((StringBuilder)localObject).toString());
        }
      }
      i += 1;
    }
    return -1;
  }
  
  private int a(DefaultImageHeaderParser.Reader paramReader, ArrayPool paramArrayPool)
  {
    int i = paramReader.a();
    if (!a(i))
    {
      if (Log.isLoggable("DfltImageHeaderParser", 3))
      {
        paramReader = new StringBuilder();
        paramReader.append("Parser doesn't handle magic number: ");
        paramReader.append(i);
        Log.d("DfltImageHeaderParser", paramReader.toString());
      }
      return -1;
    }
    i = b(paramReader);
    if (i == -1)
    {
      if (Log.isLoggable("DfltImageHeaderParser", 3)) {
        Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
      }
      return -1;
    }
    byte[] arrayOfByte = (byte[])paramArrayPool.a(i, [B.class);
    try
    {
      i = a(paramReader, arrayOfByte, i);
      return i;
    }
    finally
    {
      paramArrayPool.a(arrayOfByte);
    }
  }
  
  private int a(DefaultImageHeaderParser.Reader paramReader, byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramReader.a(paramArrayOfByte, paramInt);
    if (i != paramInt)
    {
      if (Log.isLoggable("DfltImageHeaderParser", 3))
      {
        paramReader = new StringBuilder();
        paramReader.append("Unable to read exif segment data, length: ");
        paramReader.append(paramInt);
        paramReader.append(", actually read: ");
        paramReader.append(i);
        Log.d("DfltImageHeaderParser", paramReader.toString());
      }
      return -1;
    }
    if (a(paramArrayOfByte, paramInt)) {
      return a(new DefaultImageHeaderParser.RandomAccessReader(paramArrayOfByte, paramInt));
    }
    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
      Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
    }
    return -1;
  }
  
  @NonNull
  private ImageHeaderParser.ImageType a(DefaultImageHeaderParser.Reader paramReader)
  {
    int i = paramReader.a();
    if (i == 65496) {
      return ImageHeaderParser.ImageType.JPEG;
    }
    i = i << 16 & 0xFFFF0000 | paramReader.a() & 0xFFFF;
    if (i == -1991225785)
    {
      paramReader.a(21L);
      if (paramReader.c() >= 3) {
        return ImageHeaderParser.ImageType.PNG_A;
      }
      return ImageHeaderParser.ImageType.PNG;
    }
    if (i >> 8 == 4671814) {
      return ImageHeaderParser.ImageType.GIF;
    }
    if (i != 1380533830) {
      return ImageHeaderParser.ImageType.UNKNOWN;
    }
    paramReader.a(4L);
    if ((paramReader.a() << 16 & 0xFFFF0000 | paramReader.a() & 0xFFFF) != 1464156752) {
      return ImageHeaderParser.ImageType.UNKNOWN;
    }
    i = paramReader.a() << 16 & 0xFFFF0000 | paramReader.a() & 0xFFFF;
    if ((i & 0xFFFFFF00) != 1448097792) {
      return ImageHeaderParser.ImageType.UNKNOWN;
    }
    i &= 0xFF;
    if (i == 88)
    {
      paramReader.a(4L);
      if ((paramReader.c() & 0x10) != 0) {
        return ImageHeaderParser.ImageType.WEBP_A;
      }
      return ImageHeaderParser.ImageType.WEBP;
    }
    if (i == 76)
    {
      paramReader.a(4L);
      if ((paramReader.c() & 0x8) != 0) {
        return ImageHeaderParser.ImageType.WEBP_A;
      }
      return ImageHeaderParser.ImageType.WEBP;
    }
    return ImageHeaderParser.ImageType.WEBP;
  }
  
  private static boolean a(int paramInt)
  {
    return ((paramInt & 0xFFD8) == 65496) || (paramInt == 19789) || (paramInt == 18761);
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool;
    if ((paramArrayOfByte != null) && (paramInt > a.length)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      paramInt = 0;
      for (;;)
      {
        byte[] arrayOfByte = a;
        if (paramInt >= arrayOfByte.length) {
          break;
        }
        if (paramArrayOfByte[paramInt] != arrayOfByte[paramInt]) {
          return false;
        }
        paramInt += 1;
      }
    }
    return bool;
  }
  
  private int b(DefaultImageHeaderParser.Reader paramReader)
  {
    int i;
    int j;
    long l1;
    long l2;
    do
    {
      i = paramReader.b();
      if (i != 255)
      {
        if (Log.isLoggable("DfltImageHeaderParser", 3))
        {
          paramReader = new StringBuilder();
          paramReader.append("Unknown segmentId=");
          paramReader.append(i);
          Log.d("DfltImageHeaderParser", paramReader.toString());
        }
        return -1;
      }
      i = paramReader.b();
      if (i == 218) {
        return -1;
      }
      if (i == 217)
      {
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
          Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
        }
        return -1;
      }
      j = paramReader.a() - 2;
      if (i == 225) {
        break;
      }
      l1 = j;
      l2 = paramReader.a(l1);
    } while (l2 == l1);
    if (Log.isLoggable("DfltImageHeaderParser", 3))
    {
      paramReader = new StringBuilder();
      paramReader.append("Unable to skip enough data, type: ");
      paramReader.append(i);
      paramReader.append(", wanted to skip: ");
      paramReader.append(j);
      paramReader.append(", but actually skipped: ");
      paramReader.append(l2);
      Log.d("DfltImageHeaderParser", paramReader.toString());
    }
    return -1;
    return j;
  }
  
  public int a(@NonNull InputStream paramInputStream, @NonNull ArrayPool paramArrayPool)
  {
    return a(new DefaultImageHeaderParser.StreamReader((InputStream)Preconditions.a(paramInputStream)), (ArrayPool)Preconditions.a(paramArrayPool));
  }
  
  @NonNull
  public ImageHeaderParser.ImageType a(@NonNull InputStream paramInputStream)
  {
    return a(new DefaultImageHeaderParser.StreamReader((InputStream)Preconditions.a(paramInputStream)));
  }
  
  @NonNull
  public ImageHeaderParser.ImageType a(@NonNull ByteBuffer paramByteBuffer)
  {
    return a(new DefaultImageHeaderParser.ByteBufferReader((ByteBuffer)Preconditions.a(paramByteBuffer)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser
 * JD-Core Version:    0.7.0.1
 */