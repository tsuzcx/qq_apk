package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;

public class BitmapEncoder
  implements ResourceEncoder<Bitmap>
{
  public static final Option<Integer> a = Option.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", Integer.valueOf(90));
  public static final Option<Bitmap.CompressFormat> b = Option.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
  @Nullable
  private final ArrayPool c;
  
  @Deprecated
  public BitmapEncoder()
  {
    this.c = null;
  }
  
  public BitmapEncoder(@NonNull ArrayPool paramArrayPool)
  {
    this.c = paramArrayPool;
  }
  
  private Bitmap.CompressFormat a(Bitmap paramBitmap, Options paramOptions)
  {
    paramOptions = (Bitmap.CompressFormat)paramOptions.a(b);
    if (paramOptions != null) {
      return paramOptions;
    }
    if (paramBitmap.hasAlpha()) {
      return Bitmap.CompressFormat.PNG;
    }
    return Bitmap.CompressFormat.JPEG;
  }
  
  @NonNull
  public EncodeStrategy a(@NonNull Options paramOptions)
  {
    return EncodeStrategy.TRANSFORMED;
  }
  
  /* Error */
  public boolean a(@NonNull com.bumptech.glide.load.engine.Resource<Bitmap> paramResource, @NonNull java.io.File paramFile, @NonNull Options paramOptions)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 88 1 0
    //   6: checkcast 60	android/graphics/Bitmap
    //   9: astore 11
    //   11: aload_0
    //   12: aload 11
    //   14: aload_3
    //   15: invokespecial 90	com/bumptech/glide/load/resource/bitmap/BitmapEncoder:a	(Landroid/graphics/Bitmap;Lcom/bumptech/glide/load/Options;)Landroid/graphics/Bitmap$CompressFormat;
    //   18: astore 12
    //   20: ldc 92
    //   22: aload 11
    //   24: invokevirtual 96	android/graphics/Bitmap:getWidth	()I
    //   27: invokestatic 25	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aload 11
    //   32: invokevirtual 99	android/graphics/Bitmap:getHeight	()I
    //   35: invokestatic 25	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aload 12
    //   40: invokestatic 104	com/bumptech/glide/util/pool/GlideTrace:a	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   43: invokestatic 109	com/bumptech/glide/util/LogTime:a	()J
    //   46: lstore 5
    //   48: aload_3
    //   49: getstatic 32	com/bumptech/glide/load/resource/bitmap/BitmapEncoder:a	Lcom/bumptech/glide/load/Option;
    //   52: invokevirtual 56	com/bumptech/glide/load/Options:a	(Lcom/bumptech/glide/load/Option;)Ljava/lang/Object;
    //   55: checkcast 21	java/lang/Integer
    //   58: invokevirtual 112	java/lang/Integer:intValue	()I
    //   61: istore 4
    //   63: iconst_0
    //   64: istore 7
    //   66: iconst_0
    //   67: istore 8
    //   69: aconst_null
    //   70: astore 10
    //   72: aconst_null
    //   73: astore 9
    //   75: new 114	java/io/FileOutputStream
    //   78: dup
    //   79: aload_2
    //   80: invokespecial 117	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: astore_1
    //   84: aload_0
    //   85: getfield 46	com/bumptech/glide/load/resource/bitmap/BitmapEncoder:c	Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayPool;
    //   88: ifnull +21 -> 109
    //   91: new 119	com/bumptech/glide/load/data/BufferedOutputStream
    //   94: dup
    //   95: aload_1
    //   96: aload_0
    //   97: getfield 46	com/bumptech/glide/load/resource/bitmap/BitmapEncoder:c	Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayPool;
    //   100: invokespecial 122	com/bumptech/glide/load/data/BufferedOutputStream:<init>	(Ljava/io/OutputStream;Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayPool;)V
    //   103: astore_2
    //   104: aload_2
    //   105: astore_1
    //   106: goto +3 -> 109
    //   109: aload_1
    //   110: astore 9
    //   112: aload_1
    //   113: astore 10
    //   115: aload 11
    //   117: aload 12
    //   119: iload 4
    //   121: aload_1
    //   122: invokevirtual 126	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   125: pop
    //   126: aload_1
    //   127: astore 9
    //   129: aload_1
    //   130: astore 10
    //   132: aload_1
    //   133: invokevirtual 131	java/io/OutputStream:close	()V
    //   136: iconst_1
    //   137: istore 7
    //   139: aload_1
    //   140: invokevirtual 131	java/io/OutputStream:close	()V
    //   143: goto +59 -> 202
    //   146: astore_2
    //   147: aload_1
    //   148: astore 9
    //   150: aload_2
    //   151: astore_1
    //   152: goto +167 -> 319
    //   155: astore_2
    //   156: goto +11 -> 167
    //   159: astore_1
    //   160: goto +159 -> 319
    //   163: astore_2
    //   164: aload 10
    //   166: astore_1
    //   167: aload_1
    //   168: astore 9
    //   170: ldc 133
    //   172: iconst_3
    //   173: invokestatic 139	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   176: ifeq +15 -> 191
    //   179: aload_1
    //   180: astore 9
    //   182: ldc 133
    //   184: ldc 141
    //   186: aload_2
    //   187: invokestatic 144	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   190: pop
    //   191: aload_1
    //   192: ifnull +10 -> 202
    //   195: iload 8
    //   197: istore 7
    //   199: goto -60 -> 139
    //   202: ldc 133
    //   204: iconst_2
    //   205: invokestatic 139	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   208: ifeq +105 -> 313
    //   211: new 146	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   218: astore_1
    //   219: aload_1
    //   220: ldc 149
    //   222: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_1
    //   227: aload 12
    //   229: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_1
    //   234: ldc 158
    //   236: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_1
    //   241: aload 11
    //   243: invokestatic 163	com/bumptech/glide/util/Util:a	(Landroid/graphics/Bitmap;)I
    //   246: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_1
    //   251: ldc 168
    //   253: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_1
    //   258: lload 5
    //   260: invokestatic 171	com/bumptech/glide/util/LogTime:a	(J)D
    //   263: invokevirtual 174	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_1
    //   268: ldc 176
    //   270: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_1
    //   275: aload_3
    //   276: getstatic 39	com/bumptech/glide/load/resource/bitmap/BitmapEncoder:b	Lcom/bumptech/glide/load/Option;
    //   279: invokevirtual 56	com/bumptech/glide/load/Options:a	(Lcom/bumptech/glide/load/Option;)Ljava/lang/Object;
    //   282: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_1
    //   287: ldc 178
    //   289: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_1
    //   294: aload 11
    //   296: invokevirtual 64	android/graphics/Bitmap:hasAlpha	()Z
    //   299: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: ldc 133
    //   305: aload_1
    //   306: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 189	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   312: pop
    //   313: invokestatic 191	com/bumptech/glide/util/pool/GlideTrace:a	()V
    //   316: iload 7
    //   318: ireturn
    //   319: aload 9
    //   321: ifnull +8 -> 329
    //   324: aload 9
    //   326: invokevirtual 131	java/io/OutputStream:close	()V
    //   329: aload_1
    //   330: athrow
    //   331: astore_1
    //   332: invokestatic 191	com/bumptech/glide/util/pool/GlideTrace:a	()V
    //   335: goto +5 -> 340
    //   338: aload_1
    //   339: athrow
    //   340: goto -2 -> 338
    //   343: astore_1
    //   344: goto -142 -> 202
    //   347: astore_2
    //   348: goto -19 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	BitmapEncoder
    //   0	351	1	paramResource	com.bumptech.glide.load.engine.Resource<Bitmap>
    //   0	351	2	paramFile	java.io.File
    //   0	351	3	paramOptions	Options
    //   61	59	4	i	int
    //   46	213	5	l	long
    //   64	253	7	bool1	boolean
    //   67	129	8	bool2	boolean
    //   73	252	9	localResource1	com.bumptech.glide.load.engine.Resource<Bitmap>
    //   70	95	10	localResource2	com.bumptech.glide.load.engine.Resource<Bitmap>
    //   9	286	11	localBitmap	Bitmap
    //   18	210	12	localCompressFormat	Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   84	104	146	finally
    //   84	104	155	java/io/IOException
    //   75	84	159	finally
    //   115	126	159	finally
    //   132	136	159	finally
    //   170	179	159	finally
    //   182	191	159	finally
    //   75	84	163	java/io/IOException
    //   115	126	163	java/io/IOException
    //   132	136	163	java/io/IOException
    //   43	63	331	finally
    //   139	143	331	finally
    //   202	313	331	finally
    //   324	329	331	finally
    //   329	331	331	finally
    //   139	143	343	java/io/IOException
    //   324	329	347	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.BitmapEncoder
 * JD-Core Version:    0.7.0.1
 */