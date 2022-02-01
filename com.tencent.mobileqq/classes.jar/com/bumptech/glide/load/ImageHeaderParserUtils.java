package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class ImageHeaderParserUtils
{
  @NonNull
  public static ImageHeaderParser.ImageType a(@NonNull List<ImageHeaderParser> paramList, @Nullable InputStream paramInputStream, @NonNull ArrayPool paramArrayPool)
  {
    if (paramInputStream == null) {
      return ImageHeaderParser.ImageType.UNKNOWN;
    }
    Object localObject = paramInputStream;
    if (!paramInputStream.markSupported()) {
      localObject = new RecyclableBufferedInputStream(paramInputStream, paramArrayPool);
    }
    ((InputStream)localObject).mark(5242880);
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      paramInputStream = (ImageHeaderParser)paramList.get(i);
      try
      {
        paramInputStream = paramInputStream.a((InputStream)localObject);
        paramArrayPool = ImageHeaderParser.ImageType.UNKNOWN;
        if (paramInputStream != paramArrayPool) {
          return paramInputStream;
        }
        ((InputStream)localObject).reset();
        i += 1;
      }
      finally
      {
        ((InputStream)localObject).reset();
      }
    }
    return ImageHeaderParser.ImageType.UNKNOWN;
  }
  
  @NonNull
  public static ImageHeaderParser.ImageType a(@NonNull List<ImageHeaderParser> paramList, @Nullable ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      return ImageHeaderParser.ImageType.UNKNOWN;
    }
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      ImageHeaderParser.ImageType localImageType = ((ImageHeaderParser)paramList.get(i)).a(paramByteBuffer);
      if (localImageType != ImageHeaderParser.ImageType.UNKNOWN) {
        return localImageType;
      }
      i += 1;
    }
    return ImageHeaderParser.ImageType.UNKNOWN;
  }
  
  public static int b(@NonNull List<ImageHeaderParser> paramList, @Nullable InputStream paramInputStream, @NonNull ArrayPool paramArrayPool)
  {
    if (paramInputStream == null) {
      return -1;
    }
    Object localObject = paramInputStream;
    if (!paramInputStream.markSupported()) {
      localObject = new RecyclableBufferedInputStream(paramInputStream, paramArrayPool);
    }
    ((InputStream)localObject).mark(5242880);
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      paramInputStream = (ImageHeaderParser)paramList.get(i);
      try
      {
        int k = paramInputStream.a((InputStream)localObject, paramArrayPool);
        if (k != -1) {
          return k;
        }
        ((InputStream)localObject).reset();
        i += 1;
      }
      finally
      {
        ((InputStream)localObject).reset();
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.ImageHeaderParserUtils
 * JD-Core Version:    0.7.0.1
 */