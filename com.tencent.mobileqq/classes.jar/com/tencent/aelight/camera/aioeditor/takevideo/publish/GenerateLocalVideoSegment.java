package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import com.tencent.aelight.camera.aioeditor.takevideo.EditDoodleExport;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.filter.FilterFactory;
import com.tencent.mobileqq.filter.GPUImagePixelationFilter;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.lang.ref.WeakReference;

@TargetApi(10)
public class GenerateLocalVideoSegment
  extends MeasureJobSegment<GenerateContext, GenerateContext>
{
  private final String a;
  public WeakReference<EditDoodleExport> a;
  
  public GenerateLocalVideoSegment()
  {
    this(null);
  }
  
  public GenerateLocalVideoSegment(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private Bitmap a(GenerateContext paramGenerateContext, Bitmap paramBitmap)
  {
    Object localObject1 = null;
    if (paramBitmap == null) {
      return null;
    }
    GPUBitmapImageRender localGPUBitmapImageRender = new GPUBitmapImageRender();
    localGPUBitmapImageRender.a(paramBitmap.getWidth(), paramBitmap.getHeight());
    Object localObject2 = this.jdField_a_of_type_JavaLangRefWeakReference;
    paramGenerateContext = (GenerateContext)localObject1;
    if (localObject2 != null)
    {
      paramGenerateContext = (GenerateContext)localObject1;
      if (((WeakReference)localObject2).get() != null) {
        try
        {
          paramGenerateContext = ((EditDoodleExport)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(0);
        }
        catch (Exception paramGenerateContext)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("generateMosaicThumbBitmap, read mosaic bitmap ");
          ((StringBuilder)localObject2).append(paramGenerateContext.toString());
          SLog.e("Q.qqstory.publish.edit.GenerateLocalVideoSegment", ((StringBuilder)localObject2).toString());
          paramGenerateContext = (GenerateContext)localObject1;
        }
      }
    }
    localObject1 = paramBitmap;
    if (paramGenerateContext != null)
    {
      localObject1 = (GPUImagePixelationFilter)FilterFactory.a(106);
      ((GPUImagePixelationFilter)localObject1).a(paramGenerateContext);
      ((GPUImagePixelationFilter)localObject1).init();
      paramGenerateContext = localGPUBitmapImageRender.a(paramBitmap, (GPUBaseFilter)localObject1);
      SLog.a("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, mosaicThumbBitmap = %s", paramGenerateContext);
      if (paramGenerateContext != null) {
        paramBitmap = paramGenerateContext;
      }
      ((GPUImagePixelationFilter)localObject1).destroy();
      localObject1 = paramBitmap;
    }
    localGPUBitmapImageRender.a();
    return localObject1;
  }
  
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 116	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource	Lcom/tencent/mobileqq/editor/params/EditVideoParams$EditSource;
    //   4: instanceof 118
    //   7: ifne +37 -> 44
    //   10: aload_2
    //   11: getfield 116	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource	Lcom/tencent/mobileqq/editor/params/EditVideoParams$EditSource;
    //   14: instanceof 120
    //   17: ifeq +6 -> 23
    //   20: goto +24 -> 44
    //   23: ldc 73
    //   25: ldc 122
    //   27: iconst_1
    //   28: anewarray 124	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: aload_2
    //   34: getfield 116	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource	Lcom/tencent/mobileqq/editor/params/EditVideoParams$EditSource;
    //   37: aastore
    //   38: invokestatic 128	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: goto +456 -> 497
    //   44: aload_0
    //   45: getfield 22	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateLocalVideoSegment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   48: astore_1
    //   49: aload_1
    //   50: astore 9
    //   52: aload_1
    //   53: ifnonnull +18 -> 71
    //   56: aload_2
    //   57: getfield 131	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:jdField_a_of_type_Int	I
    //   60: aload_2
    //   61: getfield 134	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:b	Ljava/lang/String;
    //   64: ldc 136
    //   66: invokestatic 141	com/tencent/aelight/camera/aioeditor/takevideo/publish/PublishFileManager:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 9
    //   71: aload_2
    //   72: getfield 116	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource	Lcom/tencent/mobileqq/editor/params/EditVideoParams$EditSource;
    //   75: instanceof 118
    //   78: istore_3
    //   79: lconst_0
    //   80: lstore 4
    //   82: iload_3
    //   83: ifeq +19 -> 102
    //   86: aload_2
    //   87: getfield 116	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource	Lcom/tencent/mobileqq/editor/params/EditVideoParams$EditSource;
    //   90: checkcast 118	com/tencent/mobileqq/editor/params/EditLocalVideoSource
    //   93: getfield 142	com/tencent/mobileqq/editor/params/EditLocalVideoSource:jdField_a_of_type_Int	I
    //   96: i2l
    //   97: lstore 6
    //   99: goto +6 -> 105
    //   102: lconst_0
    //   103: lstore 6
    //   105: aload_2
    //   106: getfield 116	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource	Lcom/tencent/mobileqq/editor/params/EditVideoParams$EditSource;
    //   109: invokeinterface 146 1 0
    //   114: astore 11
    //   116: new 148	android/media/MediaMetadataRetriever
    //   119: dup
    //   120: invokespecial 149	android/media/MediaMetadataRetriever:<init>	()V
    //   123: astore 10
    //   125: aload 10
    //   127: aload 11
    //   129: invokevirtual 152	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   132: goto +44 -> 176
    //   135: astore_1
    //   136: goto +377 -> 513
    //   139: astore_1
    //   140: new 60	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   147: astore 8
    //   149: aload 8
    //   151: ldc 154
    //   153: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 8
    //   159: aload 11
    //   161: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: ldc 73
    //   167: aload 8
    //   169: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: aload_1
    //   173: invokestatic 158	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   176: aconst_null
    //   177: astore 8
    //   179: aload 8
    //   181: astore_1
    //   182: aload_2
    //   183: getfield 161	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGenerateThumbArgs	Lcom/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateThumbArgs;
    //   186: getfield 166	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateThumbArgs:a	Z
    //   189: ifeq +108 -> 297
    //   192: aload_2
    //   193: getfield 116	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource	Lcom/tencent/mobileqq/editor/params/EditVideoParams$EditSource;
    //   196: instanceof 118
    //   199: ifeq +19 -> 218
    //   202: aload_2
    //   203: getfield 116	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource	Lcom/tencent/mobileqq/editor/params/EditVideoParams$EditSource;
    //   206: checkcast 118	com/tencent/mobileqq/editor/params/EditLocalVideoSource
    //   209: getfield 168	com/tencent/mobileqq/editor/params/EditLocalVideoSource:b	I
    //   212: i2l
    //   213: lstore 4
    //   215: goto +24 -> 239
    //   218: aload 10
    //   220: bipush 9
    //   222: invokevirtual 172	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   225: astore_1
    //   226: aload_1
    //   227: ifnull +12 -> 239
    //   230: aload_1
    //   231: invokestatic 178	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   234: invokevirtual 182	java/lang/Long:longValue	()J
    //   237: lstore 4
    //   239: new 184	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   242: dup
    //   243: invokespecial 185	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   246: astore_1
    //   247: aload_1
    //   248: aload_2
    //   249: getfield 116	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource	Lcom/tencent/mobileqq/editor/params/EditVideoParams$EditSource;
    //   252: invokeinterface 187 1 0
    //   257: putfield 190	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   260: aload_1
    //   261: aload_2
    //   262: getfield 116	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource	Lcom/tencent/mobileqq/editor/params/EditVideoParams$EditSource;
    //   265: invokeinterface 192 1 0
    //   270: putfield 195	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   273: aload 11
    //   275: aload_1
    //   276: lload 4
    //   278: invokestatic 200	com/tencent/aelight/camera/aioeditor/richmedia/mediacodec/utils/MediaUtil:a	(Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;J)Landroid/graphics/Bitmap;
    //   281: astore_1
    //   282: goto +15 -> 297
    //   285: astore_1
    //   286: ldc 73
    //   288: ldc 202
    //   290: aload_1
    //   291: invokestatic 158	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   294: aload 8
    //   296: astore_1
    //   297: aload_1
    //   298: astore 8
    //   300: aload_1
    //   301: ifnonnull +33 -> 334
    //   304: aload 10
    //   306: ldc2_w 203
    //   309: lload 6
    //   311: lmul
    //   312: invokevirtual 208	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   315: astore 8
    //   317: goto +17 -> 334
    //   320: astore 8
    //   322: ldc 73
    //   324: ldc 210
    //   326: aload 8
    //   328: invokestatic 158	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   331: aload_1
    //   332: astore 8
    //   334: aload 8
    //   336: astore_1
    //   337: aload 8
    //   339: ifnull +24 -> 363
    //   342: aload 8
    //   344: astore_1
    //   345: aload_2
    //   346: getfield 213	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry	Lcom/tencent/mobileqq/editor/database/PublishVideoEntry;
    //   349: getfield 218	com/tencent/mobileqq/editor/database/PublishVideoEntry:videoNeedRotate	Z
    //   352: ifeq +11 -> 363
    //   355: aload 8
    //   357: ldc 219
    //   359: invokestatic 224	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   362: astore_1
    //   363: aload_1
    //   364: astore 8
    //   366: aload_2
    //   367: getfield 116	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource	Lcom/tencent/mobileqq/editor/params/EditVideoParams$EditSource;
    //   370: instanceof 120
    //   373: ifeq +11 -> 384
    //   376: aload_0
    //   377: aload_2
    //   378: aload_1
    //   379: invokespecial 226	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateLocalVideoSegment:a	(Lcom/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   382: astore 8
    //   384: aload 8
    //   386: ifnull +86 -> 472
    //   389: aload 8
    //   391: getstatic 232	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   394: bipush 80
    //   396: aload 9
    //   398: invokestatic 237	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   401: istore_3
    //   402: aload 8
    //   404: invokevirtual 240	android/graphics/Bitmap:recycle	()V
    //   407: iload_3
    //   408: ifeq +53 -> 461
    //   411: new 242	java/io/File
    //   414: dup
    //   415: aload 9
    //   417: invokespecial 243	java/io/File:<init>	(Ljava/lang/String;)V
    //   420: astore_1
    //   421: aload_1
    //   422: invokevirtual 247	java/io/File:exists	()Z
    //   425: ifeq +67 -> 492
    //   428: aload_1
    //   429: invokevirtual 250	java/io/File:isFile	()Z
    //   432: ifeq +60 -> 492
    //   435: ldc 73
    //   437: ldc 252
    //   439: aload 9
    //   441: invokestatic 101	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   444: aload_2
    //   445: aload 9
    //   447: putfield 253	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateContext:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   450: aload_0
    //   451: aload_2
    //   452: invokespecial 257	com/tencent/aelight/camera/aioeditor/takevideo/publish/MeasureJobSegment:notifyResult	(Ljava/lang/Object;)V
    //   455: aload 10
    //   457: invokevirtual 260	android/media/MediaMetadataRetriever:release	()V
    //   460: return
    //   461: ldc 73
    //   463: ldc_w 262
    //   466: invokestatic 264	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: goto +23 -> 492
    //   472: ldc 73
    //   474: ldc_w 266
    //   477: iconst_1
    //   478: anewarray 124	java/lang/Object
    //   481: dup
    //   482: iconst_0
    //   483: lload 6
    //   485: invokestatic 269	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   488: aastore
    //   489: invokestatic 128	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   492: aload 10
    //   494: invokevirtual 260	android/media/MediaMetadataRetriever:release	()V
    //   497: aload_0
    //   498: new 271	com/tencent/biz/qqstory/base/ErrorMessage
    //   501: dup
    //   502: iconst_m1
    //   503: ldc_w 273
    //   506: invokespecial 276	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   509: invokevirtual 280	com/tencent/aelight/camera/aioeditor/takevideo/publish/GenerateLocalVideoSegment:notifyError	(Ljava/lang/Error;)V
    //   512: return
    //   513: aload 10
    //   515: invokevirtual 260	android/media/MediaMetadataRetriever:release	()V
    //   518: aload_1
    //   519: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	520	0	this	GenerateLocalVideoSegment
    //   0	520	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	520	2	paramGenerateContext	GenerateContext
    //   78	330	3	bool	boolean
    //   80	197	4	l1	long
    //   97	387	6	l2	long
    //   147	169	8	localObject1	Object
    //   320	7	8	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   332	71	8	localObject2	Object
    //   50	396	9	localObject3	Object
    //   123	391	10	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   114	160	11	str	String
    // Exception table:
    //   from	to	target	type
    //   125	132	135	finally
    //   140	176	135	finally
    //   182	215	135	finally
    //   218	226	135	finally
    //   230	239	135	finally
    //   239	282	135	finally
    //   286	294	135	finally
    //   304	317	135	finally
    //   322	331	135	finally
    //   345	363	135	finally
    //   366	384	135	finally
    //   389	407	135	finally
    //   411	455	135	finally
    //   461	469	135	finally
    //   472	492	135	finally
    //   125	132	139	java/lang/IllegalArgumentException
    //   239	282	285	java/lang/OutOfMemoryError
    //   304	317	320	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateLocalVideoSegment
 * JD-Core Version:    0.7.0.1
 */