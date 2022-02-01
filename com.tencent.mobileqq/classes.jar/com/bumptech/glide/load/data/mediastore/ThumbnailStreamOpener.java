package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

class ThumbnailStreamOpener
{
  private static final FileService a = new FileService();
  private final FileService b;
  private final ThumbnailQuery c;
  private final ArrayPool d;
  private final ContentResolver e;
  private final List<ImageHeaderParser> f;
  
  ThumbnailStreamOpener(List<ImageHeaderParser> paramList, FileService paramFileService, ThumbnailQuery paramThumbnailQuery, ArrayPool paramArrayPool, ContentResolver paramContentResolver)
  {
    this.b = paramFileService;
    this.c = paramThumbnailQuery;
    this.d = paramArrayPool;
    this.e = paramContentResolver;
    this.f = paramList;
  }
  
  ThumbnailStreamOpener(List<ImageHeaderParser> paramList, ThumbnailQuery paramThumbnailQuery, ArrayPool paramArrayPool, ContentResolver paramContentResolver)
  {
    this(paramList, a, paramThumbnailQuery, paramArrayPool, paramContentResolver);
  }
  
  private boolean a(File paramFile)
  {
    return (this.b.a(paramFile)) && (0L < this.b.b(paramFile));
  }
  
  @Nullable
  private String c(@NonNull Uri paramUri)
  {
    paramUri = this.c.a(paramUri);
    if (paramUri != null) {
      try
      {
        if (paramUri.moveToFirst())
        {
          String str = paramUri.getString(0);
          return str;
        }
      }
      finally
      {
        if (paramUri != null) {
          paramUri.close();
        }
      }
    }
    if (paramUri != null) {
      paramUri.close();
    }
    return null;
  }
  
  /* Error */
  int a(Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 36	com/bumptech/glide/load/data/mediastore/ThumbnailStreamOpener:e	Landroid/content/ContentResolver;
    //   12: aload_1
    //   13: invokevirtual 84	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   16: astore 6
    //   18: aload 6
    //   20: astore_3
    //   21: aload 6
    //   23: astore 4
    //   25: aload 6
    //   27: astore 5
    //   29: aload_0
    //   30: getfield 38	com/bumptech/glide/load/data/mediastore/ThumbnailStreamOpener:f	Ljava/util/List;
    //   33: aload 6
    //   35: aload_0
    //   36: getfield 34	com/bumptech/glide/load/data/mediastore/ThumbnailStreamOpener:d	Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayPool;
    //   39: invokestatic 89	com/bumptech/glide/load/ImageHeaderParserUtils:b	(Ljava/util/List;Ljava/io/InputStream;Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayPool;)I
    //   42: istore_2
    //   43: aload 6
    //   45: ifnull +8 -> 53
    //   48: aload 6
    //   50: invokevirtual 92	java/io/InputStream:close	()V
    //   53: iload_2
    //   54: ireturn
    //   55: astore_1
    //   56: goto +87 -> 143
    //   59: astore 6
    //   61: goto +9 -> 70
    //   64: astore 6
    //   66: aload 5
    //   68: astore 4
    //   70: aload 4
    //   72: astore_3
    //   73: ldc 94
    //   75: iconst_3
    //   76: invokestatic 100	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   79: ifeq +52 -> 131
    //   82: aload 4
    //   84: astore_3
    //   85: new 102	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   92: astore 5
    //   94: aload 4
    //   96: astore_3
    //   97: aload 5
    //   99: ldc 105
    //   101: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 4
    //   107: astore_3
    //   108: aload 5
    //   110: aload_1
    //   111: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: astore_3
    //   118: ldc 94
    //   120: aload 5
    //   122: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aload 6
    //   127: invokestatic 119	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   130: pop
    //   131: aload 4
    //   133: ifnull +8 -> 141
    //   136: aload 4
    //   138: invokevirtual 92	java/io/InputStream:close	()V
    //   141: iconst_m1
    //   142: ireturn
    //   143: aload_3
    //   144: ifnull +7 -> 151
    //   147: aload_3
    //   148: invokevirtual 92	java/io/InputStream:close	()V
    //   151: aload_1
    //   152: athrow
    //   153: astore_1
    //   154: iload_2
    //   155: ireturn
    //   156: astore_1
    //   157: goto -16 -> 141
    //   160: astore_3
    //   161: goto -10 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	ThumbnailStreamOpener
    //   0	164	1	paramUri	Uri
    //   42	113	2	i	int
    //   7	141	3	localObject1	Object
    //   160	1	3	localIOException1	java.io.IOException
    //   1	136	4	localObject2	Object
    //   4	117	5	localObject3	Object
    //   16	33	6	localInputStream	InputStream
    //   59	1	6	localNullPointerException	NullPointerException
    //   64	62	6	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   8	18	55	finally
    //   29	43	55	finally
    //   73	82	55	finally
    //   85	94	55	finally
    //   97	105	55	finally
    //   108	115	55	finally
    //   118	131	55	finally
    //   8	18	59	java/lang/NullPointerException
    //   29	43	59	java/lang/NullPointerException
    //   8	18	64	java/io/IOException
    //   29	43	64	java/io/IOException
    //   48	53	153	java/io/IOException
    //   136	141	156	java/io/IOException
    //   147	151	160	java/io/IOException
  }
  
  public InputStream b(Uri paramUri)
  {
    Object localObject = c(paramUri);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = this.b.a((String)localObject);
    if (!a((File)localObject)) {
      return null;
    }
    localObject = Uri.fromFile((File)localObject);
    try
    {
      InputStream localInputStream = this.e.openInputStream((Uri)localObject);
      return localInputStream;
    }
    catch (NullPointerException localNullPointerException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NPE opening uri: ");
      localStringBuilder.append(paramUri);
      localStringBuilder.append(" -> ");
      localStringBuilder.append(localObject);
      throw ((FileNotFoundException)new FileNotFoundException(localStringBuilder.toString()).initCause(localNullPointerException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener
 * JD-Core Version:    0.7.0.1
 */