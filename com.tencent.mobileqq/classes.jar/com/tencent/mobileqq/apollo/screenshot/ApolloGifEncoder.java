package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.mobileqq.apollo.meme.ERROR_ENCODE_NO_FRAME;
import com.tencent.mobileqq.apollo.meme.ERROR_GIF_ENCODE_FAIL;
import com.tencent.mobileqq.apollo.meme.RECORD_COMPLETE;
import com.tencent.mobileqq.apollo.meme.model.BusinessConfig;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import cooperation.qzone.util.GifCoder;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloGifEncoder;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "config", "Lcom/tencent/mobileqq/apollo/meme/model/BusinessConfig;", "tempFilePath", "", "(Lcom/tencent/mobileqq/apollo/meme/model/BusinessConfig;Ljava/lang/String;)V", "getConfig", "()Lcom/tencent/mobileqq/apollo/meme/model/BusinessConfig;", "gifEncoder", "Lcooperation/qzone/util/GifCoder;", "picList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPicList", "()Ljava/util/ArrayList;", "addFrame", "", "pixels", "", "width", "", "height", "close", "encode", "Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "outputFilePath", "frameTime", "getFrameCount", "init", "removePicList", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloGifEncoder
  implements IApolloScreenshotEncoder
{
  public static final ApolloGifEncoder.Companion a = new ApolloGifEncoder.Companion(null);
  @NotNull
  private final ArrayList<String> b;
  private final GifCoder c;
  @NotNull
  private final BusinessConfig d;
  private final String e;
  
  public ApolloGifEncoder(@NotNull BusinessConfig paramBusinessConfig, @NotNull String paramString)
  {
    this.d = paramBusinessConfig;
    this.e = paramString;
    this.b = new ArrayList();
    this.c = new GifCoder();
  }
  
  @NotNull
  public ActionStatus a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "outputFilePath");
    if (this.b.size() == 0) {
      return (ActionStatus)ERROR_ENCODE_NO_FRAME.a;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)this.b);
    if (this.c.encodeGif(paramString, localArrayList, paramInt, true)) {
      return (ActionStatus)RECORD_COMPLETE.a;
    }
    return (ActionStatus)ERROR_GIF_ENCODE_FAIL.a;
  }
  
  public void a()
  {
    this.c.setUseOrignalBitmap(true);
  }
  
  /* Error */
  public void a(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 134
    //   3: invokestatic 74	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aconst_null
    //   7: checkcast 136	android/graphics/Bitmap
    //   10: astore 9
    //   12: aload 9
    //   14: astore 6
    //   16: aload 9
    //   18: astore 7
    //   20: iload_2
    //   21: iload_3
    //   22: getstatic 142	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   25: invokestatic 146	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   28: astore 8
    //   30: aload 9
    //   32: astore 6
    //   34: aload 9
    //   36: astore 7
    //   38: aload 8
    //   40: aload_1
    //   41: invokestatic 152	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   44: checkcast 154	java/nio/Buffer
    //   47: invokevirtual 158	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   50: invokestatic 164	android/os/SystemClock:elapsedRealtime	()J
    //   53: lstore 4
    //   55: new 166	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_0
    //   65: getfield 81	com/tencent/mobileqq/apollo/screenshot/ApolloGifEncoder:e	Ljava/lang/String;
    //   68: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_1
    //   73: getstatic 176	java/io/File:separator	Ljava/lang/String;
    //   76: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_1
    //   81: lload 4
    //   83: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_1
    //   88: ldc 181
    //   90: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_1
    //   95: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: astore 9
    //   100: aload 8
    //   102: aload_0
    //   103: getfield 79	com/tencent/mobileqq/apollo/screenshot/ApolloGifEncoder:d	Lcom/tencent/mobileqq/apollo/meme/model/BusinessConfig;
    //   106: invokevirtual 189	com/tencent/mobileqq/apollo/meme/model/BusinessConfig:b	()I
    //   109: invokestatic 194	com/tencent/mobileqq/apollo/utils/ApolloRecordUtil:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   112: astore_1
    //   113: aload_1
    //   114: astore 6
    //   116: aload_1
    //   117: astore 7
    //   119: aload_1
    //   120: new 173	java/io/File
    //   123: dup
    //   124: aload 9
    //   126: invokespecial 197	java/io/File:<init>	(Ljava/lang/String;)V
    //   129: invokestatic 202	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;Ljava/io/File;)Z
    //   132: pop
    //   133: aload_1
    //   134: astore 6
    //   136: aload_1
    //   137: astore 7
    //   139: aload_0
    //   140: getfield 86	com/tencent/mobileqq/apollo/screenshot/ApolloGifEncoder:b	Ljava/util/ArrayList;
    //   143: aload 9
    //   145: invokevirtual 206	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   148: pop
    //   149: aload_1
    //   150: ifnull +66 -> 216
    //   153: aload_1
    //   154: invokevirtual 209	android/graphics/Bitmap:recycle	()V
    //   157: return
    //   158: astore_1
    //   159: aload 8
    //   161: astore 6
    //   163: goto +54 -> 217
    //   166: astore 6
    //   168: aload 8
    //   170: astore_1
    //   171: aload 6
    //   173: astore 8
    //   175: goto +12 -> 187
    //   178: astore_1
    //   179: goto +38 -> 217
    //   182: astore 8
    //   184: aload 7
    //   186: astore_1
    //   187: aload_1
    //   188: astore 6
    //   190: ldc 211
    //   192: iconst_1
    //   193: ldc 213
    //   195: aload 8
    //   197: checkcast 215	java/lang/Throwable
    //   200: invokestatic 220	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   203: aload_1
    //   204: astore 6
    //   206: invokestatic 225	java/lang/System:gc	()V
    //   209: aload_1
    //   210: ifnull +6 -> 216
    //   213: goto -60 -> 153
    //   216: return
    //   217: aload 6
    //   219: ifnull +8 -> 227
    //   222: aload 6
    //   224: invokevirtual 209	android/graphics/Bitmap:recycle	()V
    //   227: goto +5 -> 232
    //   230: aload_1
    //   231: athrow
    //   232: goto -2 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	this	ApolloGifEncoder
    //   0	235	1	paramArrayOfByte	byte[]
    //   0	235	2	paramInt1	int
    //   0	235	3	paramInt2	int
    //   53	29	4	l	long
    //   14	148	6	localObject1	Object
    //   166	6	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   188	35	6	arrayOfByte	byte[]
    //   18	167	7	localObject2	Object
    //   28	146	8	localObject3	Object
    //   182	14	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   10	134	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   50	113	158	finally
    //   50	113	166	java/lang/OutOfMemoryError
    //   20	30	178	finally
    //   38	50	178	finally
    //   119	133	178	finally
    //   139	149	178	finally
    //   190	203	178	finally
    //   206	209	178	finally
    //   20	30	182	java/lang/OutOfMemoryError
    //   38	50	182	java/lang/OutOfMemoryError
    //   119	133	182	java/lang/OutOfMemoryError
    //   139	149	182	java/lang/OutOfMemoryError
  }
  
  public void b()
  {
    this.c.closeEncoder();
  }
  
  public int c()
  {
    return this.b.size();
  }
  
  @NotNull
  public final ArrayList<String> d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloGifEncoder
 * JD-Core Version:    0.7.0.1
 */