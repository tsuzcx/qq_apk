package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;

public class StreamEncoder
  implements Encoder<InputStream>
{
  private final ArrayPool a;
  
  public StreamEncoder(ArrayPool paramArrayPool)
  {
    this.a = paramArrayPool;
  }
  
  /* Error */
  public boolean a(@android.support.annotation.NonNull InputStream paramInputStream, @android.support.annotation.NonNull java.io.File paramFile, @android.support.annotation.NonNull com.bumptech.glide.load.Options paramOptions)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/bumptech/glide/load/model/StreamEncoder:a	Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayPool;
    //   4: ldc 22
    //   6: ldc 24
    //   8: invokeinterface 29 3 0
    //   13: checkcast 24	[B
    //   16: astore 9
    //   18: iconst_0
    //   19: istore 7
    //   21: iconst_0
    //   22: istore 6
    //   24: aconst_null
    //   25: astore 8
    //   27: aconst_null
    //   28: astore_3
    //   29: new 31	java/io/FileOutputStream
    //   32: dup
    //   33: aload_2
    //   34: invokespecial 34	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore_2
    //   38: aload_1
    //   39: aload 9
    //   41: invokevirtual 40	java/io/InputStream:read	([B)I
    //   44: istore 4
    //   46: iload 4
    //   48: iconst_m1
    //   49: if_icmpeq +15 -> 64
    //   52: aload_2
    //   53: aload 9
    //   55: iconst_0
    //   56: iload 4
    //   58: invokevirtual 46	java/io/OutputStream:write	([BII)V
    //   61: goto -23 -> 38
    //   64: aload_2
    //   65: invokevirtual 49	java/io/OutputStream:close	()V
    //   68: iconst_1
    //   69: istore 5
    //   71: iconst_1
    //   72: istore 6
    //   74: aload_2
    //   75: invokevirtual 49	java/io/OutputStream:close	()V
    //   78: iload 6
    //   80: istore 5
    //   82: goto +67 -> 149
    //   85: astore_1
    //   86: aload_2
    //   87: astore_3
    //   88: goto +75 -> 163
    //   91: astore_3
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: astore_2
    //   96: goto +11 -> 107
    //   99: astore_1
    //   100: goto +63 -> 163
    //   103: astore_2
    //   104: aload 8
    //   106: astore_1
    //   107: aload_1
    //   108: astore_3
    //   109: ldc 51
    //   111: iconst_3
    //   112: invokestatic 57	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   115: ifeq +14 -> 129
    //   118: aload_1
    //   119: astore_3
    //   120: ldc 51
    //   122: ldc 59
    //   124: aload_2
    //   125: invokestatic 63	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   128: pop
    //   129: iload 6
    //   131: istore 5
    //   133: aload_1
    //   134: ifnull +15 -> 149
    //   137: iload 7
    //   139: istore 5
    //   141: aload_1
    //   142: invokevirtual 49	java/io/OutputStream:close	()V
    //   145: iload 6
    //   147: istore 5
    //   149: aload_0
    //   150: getfield 16	com/bumptech/glide/load/model/StreamEncoder:a	Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayPool;
    //   153: aload 9
    //   155: invokeinterface 66 2 0
    //   160: iload 5
    //   162: ireturn
    //   163: aload_3
    //   164: ifnull +7 -> 171
    //   167: aload_3
    //   168: invokevirtual 49	java/io/OutputStream:close	()V
    //   171: aload_0
    //   172: getfield 16	com/bumptech/glide/load/model/StreamEncoder:a	Lcom/bumptech/glide/load/engine/bitmap_recycle/ArrayPool;
    //   175: aload 9
    //   177: invokeinterface 66 2 0
    //   182: goto +5 -> 187
    //   185: aload_1
    //   186: athrow
    //   187: goto -2 -> 185
    //   190: astore_1
    //   191: goto -42 -> 149
    //   194: astore_2
    //   195: goto -24 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	StreamEncoder
    //   0	198	1	paramInputStream	InputStream
    //   0	198	2	paramFile	java.io.File
    //   0	198	3	paramOptions	com.bumptech.glide.load.Options
    //   44	13	4	i	int
    //   69	92	5	bool1	boolean
    //   22	124	6	bool2	boolean
    //   19	119	7	bool3	boolean
    //   25	80	8	localObject	Object
    //   16	160	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   38	46	85	finally
    //   52	61	85	finally
    //   64	68	85	finally
    //   38	46	91	java/io/IOException
    //   52	61	91	java/io/IOException
    //   64	68	91	java/io/IOException
    //   29	38	99	finally
    //   109	118	99	finally
    //   120	129	99	finally
    //   29	38	103	java/io/IOException
    //   74	78	190	java/io/IOException
    //   141	145	190	java/io/IOException
    //   167	171	194	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.model.StreamEncoder
 * JD-Core Version:    0.7.0.1
 */