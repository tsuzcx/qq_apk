package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.mobileqq.apollo.api.player.model.BusinessConfig;
import cooperation.qzone.util.GifCoder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloGifEncoder;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "config", "Lcom/tencent/mobileqq/apollo/api/player/model/BusinessConfig;", "tempFilePath", "", "(Lcom/tencent/mobileqq/apollo/api/player/model/BusinessConfig;Ljava/lang/String;)V", "getConfig", "()Lcom/tencent/mobileqq/apollo/api/player/model/BusinessConfig;", "gifEncoder", "Lcooperation/qzone/util/GifCoder;", "picList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPicList", "()Ljava/util/ArrayList;", "addFrame", "", "pixels", "", "width", "", "height", "close", "encode", "", "outputFilePath", "frameTime", "getFrameCount", "init", "removePicList", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloGifEncoder
  implements IApolloScreenshotEncoder
{
  public static final ApolloGifEncoder.Companion a;
  @NotNull
  private final BusinessConfig jdField_a_of_type_ComTencentMobileqqApolloApiPlayerModelBusinessConfig;
  private final GifCoder jdField_a_of_type_CooperationQzoneUtilGifCoder;
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloGifEncoder$Companion = new ApolloGifEncoder.Companion(null);
  }
  
  public ApolloGifEncoder(@NotNull BusinessConfig paramBusinessConfig, @NotNull String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerModelBusinessConfig = paramBusinessConfig;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_CooperationQzoneUtilGifCoder = new GifCoder();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  @NotNull
  public final ArrayList<String> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_CooperationQzoneUtilGifCoder.setUseOrignalBitmap(true);
  }
  
  /* Error */
  public void a(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 102
    //   3: invokestatic 69	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aconst_null
    //   7: checkcast 104	android/graphics/Bitmap
    //   10: astore 7
    //   12: iload_2
    //   13: iload_3
    //   14: getstatic 110	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   17: invokestatic 114	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   20: astore 6
    //   22: aload 6
    //   24: aload_1
    //   25: invokestatic 120	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   28: checkcast 122	java/nio/Buffer
    //   31: invokevirtual 126	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   34: invokestatic 132	android/os/SystemClock:elapsedRealtime	()J
    //   37: lstore 4
    //   39: new 134	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   46: aload_0
    //   47: getfield 76	com/tencent/mobileqq/apollo/screenshot/ApolloGifEncoder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   50: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: getstatic 144	java/io/File:separator	Ljava/lang/String;
    //   56: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: lload 4
    //   61: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   64: ldc 149
    //   66: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore 7
    //   74: aload 6
    //   76: aload_0
    //   77: getfield 74	com/tencent/mobileqq/apollo/screenshot/ApolloGifEncoder:jdField_a_of_type_ComTencentMobileqqApolloApiPlayerModelBusinessConfig	Lcom/tencent/mobileqq/apollo/api/player/model/BusinessConfig;
    //   80: invokevirtual 158	com/tencent/mobileqq/apollo/api/player/model/BusinessConfig:b	()I
    //   83: invokestatic 163	com/tencent/mobileqq/apollo/utils/ApolloRecordUtil:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   86: astore_1
    //   87: aload_1
    //   88: astore 6
    //   90: aload_1
    //   91: new 141	java/io/File
    //   94: dup
    //   95: aload 7
    //   97: invokespecial 166	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: invokestatic 171	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)Z
    //   103: pop
    //   104: aload_1
    //   105: astore 6
    //   107: aload_0
    //   108: getfield 81	com/tencent/mobileqq/apollo/screenshot/ApolloGifEncoder:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   111: aload 7
    //   113: invokevirtual 175	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   116: pop
    //   117: aload_1
    //   118: ifnull +7 -> 125
    //   121: aload_1
    //   122: invokevirtual 178	android/graphics/Bitmap:recycle	()V
    //   125: return
    //   126: astore 6
    //   128: aload 7
    //   130: astore_1
    //   131: aload 6
    //   133: astore 7
    //   135: aload_1
    //   136: astore 6
    //   138: ldc 180
    //   140: iconst_1
    //   141: ldc 182
    //   143: aload 7
    //   145: checkcast 184	java/lang/Throwable
    //   148: invokestatic 190	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   151: aload_1
    //   152: astore 6
    //   154: invokestatic 195	java/lang/System:gc	()V
    //   157: aload_1
    //   158: ifnull -33 -> 125
    //   161: aload_1
    //   162: invokevirtual 178	android/graphics/Bitmap:recycle	()V
    //   165: return
    //   166: astore_1
    //   167: aload 7
    //   169: astore 6
    //   171: aload 6
    //   173: ifnull +8 -> 181
    //   176: aload 6
    //   178: invokevirtual 178	android/graphics/Bitmap:recycle	()V
    //   181: aload_1
    //   182: athrow
    //   183: astore_1
    //   184: goto -13 -> 171
    //   187: astore_1
    //   188: goto -17 -> 171
    //   191: astore 7
    //   193: aload 6
    //   195: astore_1
    //   196: goto -61 -> 135
    //   199: astore 7
    //   201: goto -66 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	ApolloGifEncoder
    //   0	204	1	paramArrayOfByte	byte[]
    //   0	204	2	paramInt1	int
    //   0	204	3	paramInt2	int
    //   37	23	4	l	long
    //   20	86	6	localObject1	Object
    //   126	6	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   136	58	6	localObject2	Object
    //   10	158	7	localObject3	Object
    //   191	1	7	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   199	1	7	localOutOfMemoryError3	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   12	34	126	java/lang/OutOfMemoryError
    //   12	34	166	finally
    //   34	87	183	finally
    //   90	104	187	finally
    //   107	117	187	finally
    //   138	151	187	finally
    //   154	157	187	finally
    //   34	87	191	java/lang/OutOfMemoryError
    //   90	104	199	java/lang/OutOfMemoryError
    //   107	117	199	java/lang/OutOfMemoryError
  }
  
  public boolean a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "outputFilePath");
    return this.jdField_a_of_type_CooperationQzoneUtilGifCoder.encodeGif(paramString, this.jdField_a_of_type_JavaUtilArrayList, paramInt, true);
  }
  
  public void b()
  {
    this.jdField_a_of_type_CooperationQzoneUtilGifCoder.closeEncoder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloGifEncoder
 * JD-Core Version:    0.7.0.1
 */