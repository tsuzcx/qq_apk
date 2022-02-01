package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public class VideoDecoder<T>
  implements ResourceDecoder<T, Bitmap>
{
  public static final Option<Long> a = Option.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1L), new VideoDecoder.1());
  public static final Option<Integer> b = Option.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", Integer.valueOf(2), new VideoDecoder.2());
  private static final VideoDecoder.MediaMetadataRetrieverFactory c = new VideoDecoder.MediaMetadataRetrieverFactory();
  private final VideoDecoder.MediaMetadataRetrieverInitializer<T> d;
  private final BitmapPool e;
  private final VideoDecoder.MediaMetadataRetrieverFactory f;
  
  VideoDecoder(BitmapPool paramBitmapPool, VideoDecoder.MediaMetadataRetrieverInitializer<T> paramMediaMetadataRetrieverInitializer)
  {
    this(paramBitmapPool, paramMediaMetadataRetrieverInitializer, c);
  }
  
  @VisibleForTesting
  VideoDecoder(BitmapPool paramBitmapPool, VideoDecoder.MediaMetadataRetrieverInitializer<T> paramMediaMetadataRetrieverInitializer, VideoDecoder.MediaMetadataRetrieverFactory paramMediaMetadataRetrieverFactory)
  {
    this.e = paramBitmapPool;
    this.d = paramMediaMetadataRetrieverInitializer;
    this.f = paramMediaMetadataRetrieverFactory;
  }
  
  private static Bitmap a(MediaMetadataRetriever paramMediaMetadataRetriever, long paramLong, int paramInt)
  {
    return paramMediaMetadataRetriever.getFrameAtTime(paramLong, paramInt);
  }
  
  @Nullable
  private static Bitmap a(MediaMetadataRetriever paramMediaMetadataRetriever, long paramLong, int paramInt1, int paramInt2, int paramInt3, DownsampleStrategy paramDownsampleStrategy)
  {
    if ((Build.VERSION.SDK_INT >= 27) && (paramInt2 != -2147483648) && (paramInt3 != -2147483648) && (paramDownsampleStrategy != DownsampleStrategy.f)) {
      paramDownsampleStrategy = b(paramMediaMetadataRetriever, paramLong, paramInt1, paramInt2, paramInt3, paramDownsampleStrategy);
    } else {
      paramDownsampleStrategy = null;
    }
    Object localObject = paramDownsampleStrategy;
    if (paramDownsampleStrategy == null) {
      localObject = a(paramMediaMetadataRetriever, paramLong, paramInt1);
    }
    return localObject;
  }
  
  public static ResourceDecoder<AssetFileDescriptor, Bitmap> a(BitmapPool paramBitmapPool)
  {
    return new VideoDecoder(paramBitmapPool, new VideoDecoder.AssetFileDescriptorInitializer(null));
  }
  
  @TargetApi(27)
  private static Bitmap b(MediaMetadataRetriever paramMediaMetadataRetriever, long paramLong, int paramInt1, int paramInt2, int paramInt3, DownsampleStrategy paramDownsampleStrategy)
  {
    for (;;)
    {
      int k;
      int i;
      try
      {
        k = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(18));
        i = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(19));
        int n = Integer.parseInt(paramMediaMetadataRetriever.extractMetadata(24));
        if (n != 90)
        {
          j = k;
          m = i;
          if (n != 270)
          {
            float f1 = paramDownsampleStrategy.a(j, m, paramInt2, paramInt3);
            paramMediaMetadataRetriever = paramMediaMetadataRetriever.getScaledFrameAtTime(paramLong, paramInt1, Math.round(j * f1), Math.round(f1 * m));
            return paramMediaMetadataRetriever;
          }
        }
      }
      catch (Throwable paramMediaMetadataRetriever)
      {
        if (Log.isLoggable("VideoDecoder", 3)) {
          Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", paramMediaMetadataRetriever);
        }
        return null;
      }
      int j = i;
      int m = k;
    }
  }
  
  public static ResourceDecoder<ParcelFileDescriptor, Bitmap> b(BitmapPool paramBitmapPool)
  {
    return new VideoDecoder(paramBitmapPool, new VideoDecoder.ParcelFileDescriptorInitializer());
  }
  
  /* Error */
  public com.bumptech.glide.load.engine.Resource<Bitmap> a(@NonNull T paramT, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    // Byte code:
    //   0: aload 4
    //   2: getstatic 44	com/bumptech/glide/load/resource/bitmap/VideoDecoder:a	Lcom/bumptech/glide/load/Option;
    //   5: invokevirtual 164	com/bumptech/glide/load/Options:a	(Lcom/bumptech/glide/load/Option;)Ljava/lang/Object;
    //   8: checkcast 28	java/lang/Long
    //   11: invokevirtual 168	java/lang/Long:longValue	()J
    //   14: lstore 5
    //   16: lload 5
    //   18: lconst_0
    //   19: lcmp
    //   20: ifge +49 -> 69
    //   23: lload 5
    //   25: ldc2_w 25
    //   28: lcmp
    //   29: ifne +6 -> 35
    //   32: goto +37 -> 69
    //   35: new 170	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   42: astore_1
    //   43: aload_1
    //   44: ldc 173
    //   46: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_1
    //   51: lload 5
    //   53: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: new 182	java/lang/IllegalArgumentException
    //   60: dup
    //   61: aload_1
    //   62: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokespecial 189	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   68: athrow
    //   69: aload 4
    //   71: getstatic 56	com/bumptech/glide/load/resource/bitmap/VideoDecoder:b	Lcom/bumptech/glide/load/Option;
    //   74: invokevirtual 164	com/bumptech/glide/load/Options:a	(Lcom/bumptech/glide/load/Option;)Ljava/lang/Object;
    //   77: checkcast 48	java/lang/Integer
    //   80: astore 8
    //   82: aload 8
    //   84: astore 7
    //   86: aload 8
    //   88: ifnonnull +9 -> 97
    //   91: iconst_2
    //   92: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: astore 7
    //   97: aload 4
    //   99: getstatic 192	com/bumptech/glide/load/resource/bitmap/DownsampleStrategy:h	Lcom/bumptech/glide/load/Option;
    //   102: invokevirtual 164	com/bumptech/glide/load/Options:a	(Lcom/bumptech/glide/load/Option;)Ljava/lang/Object;
    //   105: checkcast 96	com/bumptech/glide/load/resource/bitmap/DownsampleStrategy
    //   108: astore 8
    //   110: aload 8
    //   112: astore 4
    //   114: aload 8
    //   116: ifnonnull +8 -> 124
    //   119: getstatic 195	com/bumptech/glide/load/resource/bitmap/DownsampleStrategy:g	Lcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy;
    //   122: astore 4
    //   124: aload_0
    //   125: getfield 76	com/bumptech/glide/load/resource/bitmap/VideoDecoder:f	Lcom/bumptech/glide/load/resource/bitmap/VideoDecoder$MediaMetadataRetrieverFactory;
    //   128: invokevirtual 198	com/bumptech/glide/load/resource/bitmap/VideoDecoder$MediaMetadataRetrieverFactory:a	()Landroid/media/MediaMetadataRetriever;
    //   131: astore 8
    //   133: aload_0
    //   134: getfield 74	com/bumptech/glide/load/resource/bitmap/VideoDecoder:d	Lcom/bumptech/glide/load/resource/bitmap/VideoDecoder$MediaMetadataRetrieverInitializer;
    //   137: aload 8
    //   139: aload_1
    //   140: invokeinterface 203 3 0
    //   145: aload 8
    //   147: lload 5
    //   149: aload 7
    //   151: invokevirtual 207	java/lang/Integer:intValue	()I
    //   154: iload_2
    //   155: iload_3
    //   156: aload 4
    //   158: invokestatic 209	com/bumptech/glide/load/resource/bitmap/VideoDecoder:a	(Landroid/media/MediaMetadataRetriever;JIIILcom/bumptech/glide/load/resource/bitmap/DownsampleStrategy;)Landroid/graphics/Bitmap;
    //   161: astore_1
    //   162: aload 8
    //   164: invokevirtual 212	android/media/MediaMetadataRetriever:release	()V
    //   167: aload_1
    //   168: aload_0
    //   169: getfield 72	com/bumptech/glide/load/resource/bitmap/VideoDecoder:e	Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;
    //   172: invokestatic 217	com/bumptech/glide/load/resource/bitmap/BitmapResource:a	(Landroid/graphics/Bitmap;Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;)Lcom/bumptech/glide/load/resource/bitmap/BitmapResource;
    //   175: areturn
    //   176: astore_1
    //   177: goto +13 -> 190
    //   180: astore_1
    //   181: new 219	java/io/IOException
    //   184: dup
    //   185: aload_1
    //   186: invokespecial 222	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   189: athrow
    //   190: aload 8
    //   192: invokevirtual 212	android/media/MediaMetadataRetriever:release	()V
    //   195: aload_1
    //   196: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	VideoDecoder
    //   0	197	1	paramT	T
    //   0	197	2	paramInt1	int
    //   0	197	3	paramInt2	int
    //   0	197	4	paramOptions	Options
    //   14	134	5	l	long
    //   84	66	7	localObject1	Object
    //   80	111	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   133	162	176	finally
    //   181	190	176	finally
    //   133	162	180	java/lang/RuntimeException
  }
  
  public boolean a(@NonNull T paramT, @NonNull Options paramOptions)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.VideoDecoder
 * JD-Core Version:    0.7.0.1
 */