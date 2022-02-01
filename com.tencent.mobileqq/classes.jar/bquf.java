import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.lang.ref.WeakReference;

@TargetApi(10)
public class bquf
  extends bquq<bqua, bqua>
{
  private final String a;
  public WeakReference<bqbr> a;
  
  public bquf()
  {
    this(null);
  }
  
  public bquf(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private Bitmap a(bqua parambqua, Bitmap paramBitmap)
  {
    Object localObject = null;
    if (paramBitmap == null) {
      return null;
    }
    brgc localbrgc = new brgc();
    localbrgc.a(paramBitmap.getWidth(), paramBitmap.getHeight());
    parambqua = (bqua)localObject;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      parambqua = (bqua)localObject;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {}
    }
    try
    {
      parambqua = ((bqbr)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(0);
      localObject = paramBitmap;
      if (parambqua != null)
      {
        localObject = (brgg)brgb.a(106);
        ((brgg)localObject).a(parambqua);
        ((brgg)localObject).init();
        parambqua = localbrgc.a(paramBitmap, (GPUBaseFilter)localObject);
        yuk.a("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, mosaicThumbBitmap = %s", parambqua);
        if (parambqua != null) {
          paramBitmap = parambqua;
        }
        ((brgg)localObject).destroy();
        localObject = paramBitmap;
      }
      localbrgc.a();
      return localObject;
    }
    catch (Exception parambqua)
    {
      for (;;)
      {
        yuk.e("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, read mosaic bitmap " + parambqua.toString());
        parambqua = (bqua)localObject;
      }
    }
  }
  
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, bqua parambqua)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: aload_2
    //   4: getfield 116	bqua:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   7: instanceof 118
    //   10: ifne +13 -> 23
    //   13: aload_2
    //   14: getfield 116	bqua:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   17: instanceof 120
    //   20: ifeq +468 -> 488
    //   23: aload_0
    //   24: getfield 22	bquf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   27: astore 10
    //   29: aload 10
    //   31: ifnonnull +485 -> 516
    //   34: aload_2
    //   35: getfield 123	bqua:jdField_a_of_type_Int	I
    //   38: aload_2
    //   39: getfield 126	bqua:b	Ljava/lang/String;
    //   42: ldc 128
    //   44: invokestatic 133	bqut:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 10
    //   49: aload_2
    //   50: getfield 116	bqua:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   53: instanceof 118
    //   56: ifeq +454 -> 510
    //   59: aload_2
    //   60: getfield 116	bqua:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   63: checkcast 118	dov/com/tencent/biz/qqstory/takevideo/EditLocalVideoSource
    //   66: getfield 134	dov/com/tencent/biz/qqstory/takevideo/EditLocalVideoSource:jdField_a_of_type_Int	I
    //   69: i2l
    //   70: lstore 6
    //   72: aload_2
    //   73: getfield 116	bqua:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   76: invokeinterface 138 1 0
    //   81: astore_1
    //   82: new 140	android/media/MediaMetadataRetriever
    //   85: dup
    //   86: invokespecial 141	android/media/MediaMetadataRetriever:<init>	()V
    //   89: astore 11
    //   91: aload 11
    //   93: aload_1
    //   94: invokevirtual 144	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   97: aload_2
    //   98: getfield 147	bqua:jdField_a_of_type_Bqui	Lbqui;
    //   101: getfield 152	bqui:a	Z
    //   104: ifeq +415 -> 519
    //   107: aload_2
    //   108: getfield 116	bqua:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   111: instanceof 118
    //   114: ifeq +262 -> 376
    //   117: aload_2
    //   118: getfield 116	bqua:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   121: checkcast 118	dov/com/tencent/biz/qqstory/takevideo/EditLocalVideoSource
    //   124: getfield 154	dov/com/tencent/biz/qqstory/takevideo/EditLocalVideoSource:b	I
    //   127: istore_3
    //   128: iload_3
    //   129: i2l
    //   130: lstore 4
    //   132: new 156	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   135: dup
    //   136: invokespecial 157	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   139: astore 9
    //   141: aload 9
    //   143: aload_2
    //   144: getfield 116	bqua:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   147: invokeinterface 159 1 0
    //   152: putfield 162	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   155: aload 9
    //   157: aload_2
    //   158: getfield 116	bqua:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   161: invokeinterface 164 1 0
    //   166: putfield 167	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   169: aload_1
    //   170: aload 9
    //   172: lload 4
    //   174: invokestatic 172	brgs:a	(Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;J)Landroid/graphics/Bitmap;
    //   177: astore_1
    //   178: aload_1
    //   179: astore 9
    //   181: aload_1
    //   182: ifnonnull +16 -> 198
    //   185: aload 11
    //   187: ldc2_w 173
    //   190: lload 6
    //   192: lmul
    //   193: invokevirtual 178	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   196: astore 9
    //   198: aload 9
    //   200: astore_1
    //   201: aload 9
    //   203: ifnull +24 -> 227
    //   206: aload 9
    //   208: astore_1
    //   209: aload_2
    //   210: getfield 181	bqua:jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry	Lcom/tencent/biz/qqstory/database/PublishVideoEntry;
    //   213: getfield 186	com/tencent/biz/qqstory/database/PublishVideoEntry:videoNeedRotate	Z
    //   216: ifeq +11 -> 227
    //   219: aload 9
    //   221: ldc 187
    //   223: invokestatic 192	zps:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   226: astore_1
    //   227: aload_1
    //   228: astore 9
    //   230: aload_2
    //   231: getfield 116	bqua:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   234: instanceof 120
    //   237: ifeq +11 -> 248
    //   240: aload_0
    //   241: aload_2
    //   242: aload_1
    //   243: invokespecial 194	bquf:a	(Lbqua;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   246: astore 9
    //   248: aload 9
    //   250: ifnull +215 -> 465
    //   253: aload 9
    //   255: getstatic 200	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   258: bipush 80
    //   260: aload 10
    //   262: invokestatic 205	zoc:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   265: istore 8
    //   267: aload 9
    //   269: invokevirtual 208	android/graphics/Bitmap:recycle	()V
    //   272: iload 8
    //   274: ifeq +158 -> 432
    //   277: new 210	java/io/File
    //   280: dup
    //   281: aload 10
    //   283: invokespecial 211	java/io/File:<init>	(Ljava/lang/String;)V
    //   286: astore_1
    //   287: aload_1
    //   288: invokevirtual 215	java/io/File:exists	()Z
    //   291: ifeq +148 -> 439
    //   294: aload_1
    //   295: invokevirtual 218	java/io/File:isFile	()Z
    //   298: ifeq +141 -> 439
    //   301: ldc 76
    //   303: ldc 220
    //   305: aload 10
    //   307: invokestatic 83	yuk:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   310: aload_2
    //   311: aload 10
    //   313: putfield 221	bqua:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   316: aload_0
    //   317: aload_2
    //   318: invokespecial 225	bquq:notifyResult	(Ljava/lang/Object;)V
    //   321: aload 11
    //   323: ifnull +8 -> 331
    //   326: aload 11
    //   328: invokevirtual 228	android/media/MediaMetadataRetriever:release	()V
    //   331: return
    //   332: astore 9
    //   334: ldc 76
    //   336: new 90	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   343: ldc 230
    //   345: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload_1
    //   349: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: aload 9
    //   357: invokestatic 234	yuk:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   360: goto -263 -> 97
    //   363: astore_1
    //   364: aload 11
    //   366: ifnull +8 -> 374
    //   369: aload 11
    //   371: invokevirtual 228	android/media/MediaMetadataRetriever:release	()V
    //   374: aload_1
    //   375: athrow
    //   376: aload 11
    //   378: bipush 9
    //   380: invokevirtual 238	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   383: astore 9
    //   385: aload 9
    //   387: ifnull -255 -> 132
    //   390: aload 9
    //   392: invokestatic 244	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   395: invokevirtual 248	java/lang/Long:longValue	()J
    //   398: lstore 4
    //   400: goto -268 -> 132
    //   403: astore_1
    //   404: ldc 76
    //   406: ldc 250
    //   408: aload_1
    //   409: invokestatic 234	yuk:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   412: goto +107 -> 519
    //   415: astore 9
    //   417: ldc 76
    //   419: ldc 252
    //   421: aload 9
    //   423: invokestatic 234	yuk:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   426: aload_1
    //   427: astore 9
    //   429: goto -231 -> 198
    //   432: ldc 76
    //   434: ldc 254
    //   436: invokestatic 257	yuk:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: aload 11
    //   441: ifnull +8 -> 449
    //   444: aload 11
    //   446: invokevirtual 228	android/media/MediaMetadataRetriever:release	()V
    //   449: aload_0
    //   450: new 259	com/tencent/biz/qqstory/base/ErrorMessage
    //   453: dup
    //   454: iconst_m1
    //   455: ldc_w 261
    //   458: invokespecial 264	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   461: invokevirtual 268	bquf:notifyError	(Ljava/lang/Error;)V
    //   464: return
    //   465: ldc 76
    //   467: ldc_w 270
    //   470: iconst_1
    //   471: anewarray 272	java/lang/Object
    //   474: dup
    //   475: iconst_0
    //   476: lload 6
    //   478: invokestatic 275	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   481: aastore
    //   482: invokestatic 278	yuk:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   485: goto -46 -> 439
    //   488: ldc 76
    //   490: ldc_w 280
    //   493: iconst_1
    //   494: anewarray 272	java/lang/Object
    //   497: dup
    //   498: iconst_0
    //   499: aload_2
    //   500: getfield 116	bqua:jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource	Ldov/com/tencent/biz/qqstory/takevideo/EditVideoParams$EditSource;
    //   503: aastore
    //   504: invokestatic 278	yuk:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   507: goto -58 -> 449
    //   510: lconst_0
    //   511: lstore 6
    //   513: goto -441 -> 72
    //   516: goto -467 -> 49
    //   519: aconst_null
    //   520: astore_1
    //   521: goto -343 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	524	0	this	bquf
    //   0	524	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	524	2	parambqua	bqua
    //   127	2	3	i	int
    //   1	398	4	l1	long
    //   70	442	6	l2	long
    //   265	8	8	bool	boolean
    //   139	129	9	localObject	Object
    //   332	24	9	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   383	8	9	str1	String
    //   415	7	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   427	1	9	localJobContext	com.tribe.async.async.JobContext
    //   27	285	10	str2	String
    //   89	356	11	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   91	97	332	java/lang/IllegalArgumentException
    //   91	97	363	finally
    //   97	128	363	finally
    //   132	178	363	finally
    //   185	198	363	finally
    //   209	227	363	finally
    //   230	248	363	finally
    //   253	272	363	finally
    //   277	321	363	finally
    //   334	360	363	finally
    //   376	385	363	finally
    //   390	400	363	finally
    //   404	412	363	finally
    //   417	426	363	finally
    //   432	439	363	finally
    //   465	485	363	finally
    //   132	178	403	java/lang/OutOfMemoryError
    //   185	198	415	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bquf
 * JD-Core Version:    0.7.0.1
 */