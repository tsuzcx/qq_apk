package com.tencent.biz.qqstory.base.videoupload;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.BaseManger;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.shortvideo.util.HwVideoMerge;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import naw;

@TargetApi(14)
public class VideoCompositeManager
  extends BaseManger
{
  private VideoSaveToAlbumHelper a;
  public final Object a;
  public final ArrayList a;
  public final ConcurrentHashMap a;
  public AtomicBoolean a;
  public final Object b = new Object();
  
  public VideoCompositeManager()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(3);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(3);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoSaveToAlbumHelper = new VideoSaveToAlbumHelper();
  }
  
  public static int a(String paramString)
  {
    long l = System.currentTimeMillis();
    String str = paramString + ".temp.mp4";
    int i = HwVideoMerge.a(paramString, str, 0);
    if (i != 0) {
      QLog.e("Q.qqstory.publish.upload.VideoCompositeManager", 2, "[NewVersion]HwVideoMerge->merge: errcode=" + i);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.publish.upload.VideoCompositeManager", 2, "reEncodeVideoWithFFmpeg cost=" + (System.currentTimeMillis() - l));
      }
      return i;
      FileUtils.d(paramString);
      FileUtils.c(str, paramString);
      i = 0;
    }
  }
  
  private void a(String paramString, long paramLong, VideoCompositeManager.CompositeResult paramCompositeResult)
  {
    long l = SystemClock.elapsedRealtime();
    PublishVideoEntry localPublishVideoEntry = VideoCompositeHelper.a(paramString);
    if (TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath)) {}
    for (paramString = "0";; paramString = "1")
    {
      StoryReportor.b("publish_story", "video_composite_wait", a(localPublishVideoEntry), paramCompositeResult.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, new String[] { paramCompositeResult.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg, String.valueOf(l - paramLong), String.valueOf(localPublishVideoEntry.videoDuration), paramString });
      return;
    }
  }
  
  public int a(PublishVideoEntry paramPublishVideoEntry)
  {
    if (!paramPublishVideoEntry.isLocalPublish)
    {
      if (!paramPublishVideoEntry.isPicture) {
        return 1;
      }
      return 2;
    }
    if (!paramPublishVideoEntry.isPicture) {
      return 3;
    }
    return 4;
  }
  
  /* Error */
  public VideoCompositeManager.CompositeResult a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 117	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: getfield 35	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   8: astore 6
    //   10: aload 6
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 30	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   17: aload_1
    //   18: invokevirtual 188	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 145	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager$CompositeResult
    //   24: astore 7
    //   26: aload 6
    //   28: monitorexit
    //   29: aload 7
    //   31: ifnull +44 -> 75
    //   34: aload 7
    //   36: getfield 190	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager$CompositeResult:b	Ljava/lang/String;
    //   39: invokestatic 194	com/tencent/biz/qqstory/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   42: ifeq +20 -> 62
    //   45: aload_0
    //   46: aload_1
    //   47: lload_3
    //   48: aload 7
    //   50: invokespecial 196	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:a	(Ljava/lang/String;JLcom/tencent/biz/qqstory/base/videoupload/VideoCompositeManager$CompositeResult;)V
    //   53: aload 7
    //   55: areturn
    //   56: astore_1
    //   57: aload 6
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    //   62: aload_0
    //   63: getfield 30	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   66: aload 7
    //   68: getfield 198	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager$CompositeResult:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   71: invokevirtual 201	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_0
    //   76: aload_1
    //   77: invokevirtual 204	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:a	(Ljava/lang/String;)V
    //   80: iconst_0
    //   81: istore_2
    //   82: aload_0
    //   83: getfield 37	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:b	Ljava/lang/Object;
    //   86: astore 6
    //   88: aload 6
    //   90: monitorenter
    //   91: ldc 77
    //   93: ldc 206
    //   95: iconst_1
    //   96: anewarray 32	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: aload_1
    //   102: aastore
    //   103: invokestatic 211	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: getfield 37	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:b	Ljava/lang/Object;
    //   110: ldc2_w 212
    //   113: invokevirtual 217	java/lang/Object:wait	(J)V
    //   116: ldc 77
    //   118: ldc 219
    //   120: iconst_1
    //   121: anewarray 32	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload_1
    //   127: aastore
    //   128: invokestatic 211	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload 6
    //   133: monitorexit
    //   134: aload_0
    //   135: getfield 35	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   138: astore 6
    //   140: aload 6
    //   142: monitorenter
    //   143: aload_0
    //   144: getfield 25	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   147: aload_1
    //   148: invokevirtual 223	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   151: istore 5
    //   153: aload_0
    //   154: getfield 30	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   157: aload_1
    //   158: invokevirtual 188	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   161: checkcast 145	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager$CompositeResult
    //   164: astore 7
    //   166: aload 6
    //   168: monitorexit
    //   169: aload 7
    //   171: ifnull +56 -> 227
    //   174: ldc 77
    //   176: ldc 225
    //   178: iconst_1
    //   179: anewarray 32	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload 7
    //   186: aastore
    //   187: invokestatic 211	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: aload_0
    //   191: aload_1
    //   192: lload_3
    //   193: aload 7
    //   195: invokespecial 196	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:a	(Ljava/lang/String;JLcom/tencent/biz/qqstory/base/videoupload/VideoCompositeManager$CompositeResult;)V
    //   198: aload 7
    //   200: areturn
    //   201: astore 7
    //   203: ldc 77
    //   205: ldc 227
    //   207: aload 7
    //   209: invokestatic 230	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   212: goto -81 -> 131
    //   215: astore_1
    //   216: aload 6
    //   218: monitorexit
    //   219: aload_1
    //   220: athrow
    //   221: astore_1
    //   222: aload 6
    //   224: monitorexit
    //   225: aload_1
    //   226: athrow
    //   227: iload 5
    //   229: ifne +55 -> 284
    //   232: new 145	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager$CompositeResult
    //   235: dup
    //   236: aload_0
    //   237: invokespecial 233	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager$CompositeResult:<init>	(Lcom/tencent/biz/qqstory/base/videoupload/VideoCompositeManager;)V
    //   240: astore 6
    //   242: aload 6
    //   244: new 150	com/tencent/biz/qqstory/base/ErrorMessage
    //   247: dup
    //   248: ldc 234
    //   250: ldc 236
    //   252: invokespecial 239	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   255: putfield 148	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager$CompositeResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   258: ldc 77
    //   260: ldc 241
    //   262: iconst_1
    //   263: anewarray 32	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: aload_1
    //   269: aastore
    //   270: invokestatic 243	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: aload_0
    //   274: aload_1
    //   275: lload_3
    //   276: aload 6
    //   278: invokespecial 196	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:a	(Ljava/lang/String;JLcom/tencent/biz/qqstory/base/videoupload/VideoCompositeManager$CompositeResult;)V
    //   281: aload 6
    //   283: areturn
    //   284: iload_2
    //   285: bipush 40
    //   287: if_icmple +90 -> 377
    //   290: new 145	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager$CompositeResult
    //   293: dup
    //   294: aload_0
    //   295: invokespecial 233	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager$CompositeResult:<init>	(Lcom/tencent/biz/qqstory/base/videoupload/VideoCompositeManager;)V
    //   298: astore 7
    //   300: aload 7
    //   302: new 150	com/tencent/biz/qqstory/base/ErrorMessage
    //   305: dup
    //   306: ldc 244
    //   308: ldc 246
    //   310: invokespecial 239	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   313: putfield 148	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager$CompositeResult:jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   316: ldc 77
    //   318: ldc 248
    //   320: iconst_1
    //   321: anewarray 32	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: aload_1
    //   327: aastore
    //   328: invokestatic 243	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   331: aload_0
    //   332: aload_1
    //   333: lload_3
    //   334: aload 7
    //   336: invokespecial 196	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:a	(Ljava/lang/String;JLcom/tencent/biz/qqstory/base/videoupload/VideoCompositeManager$CompositeResult;)V
    //   339: aload_0
    //   340: getfield 35	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   343: astore 6
    //   345: aload 6
    //   347: monitorenter
    //   348: aload_0
    //   349: getfield 25	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   352: aload_1
    //   353: invokevirtual 250	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   356: pop
    //   357: aload_0
    //   358: getfield 44	com/tencent/biz/qqstory/base/videoupload/VideoCompositeManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   361: iconst_0
    //   362: invokevirtual 253	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   365: aload 6
    //   367: monitorexit
    //   368: aload 7
    //   370: areturn
    //   371: astore_1
    //   372: aload 6
    //   374: monitorexit
    //   375: aload_1
    //   376: athrow
    //   377: iload_2
    //   378: iconst_1
    //   379: iadd
    //   380: istore_2
    //   381: goto -299 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	VideoCompositeManager
    //   0	384	1	paramString	String
    //   81	300	2	i	int
    //   3	331	3	l	long
    //   151	77	5	bool	boolean
    //   24	175	7	localCompositeResult1	VideoCompositeManager.CompositeResult
    //   201	7	7	localInterruptedException	java.lang.InterruptedException
    //   298	71	7	localCompositeResult2	VideoCompositeManager.CompositeResult
    // Exception table:
    //   from	to	target	type
    //   13	29	56	finally
    //   57	60	56	finally
    //   91	131	201	java/lang/InterruptedException
    //   91	131	215	finally
    //   131	134	215	finally
    //   203	212	215	finally
    //   216	219	215	finally
    //   143	169	221	finally
    //   222	225	221	finally
    //   348	368	371	finally
    //   372	375	371	finally
  }
  
  public void a(int paramInt, String paramString, PublishVideoEntry paramPublishVideoEntry)
  {
    try
    {
      int i = (int)FileUtils.a(paramString);
      if (i <= 0) {
        return;
      }
      Object localObject = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      paramString = ((MediaMetadataRetriever)localObject).extractMetadata(9);
      String str1 = ((MediaMetadataRetriever)localObject).extractMetadata(20);
      String str2 = ((MediaMetadataRetriever)localObject).extractMetadata(18);
      String str3 = ((MediaMetadataRetriever)localObject).extractMetadata(19);
      ((MediaMetadataRetriever)localObject).release();
      localObject = str2 + "*" + str3;
      StoryReportor.b("publish_story", "video_info", paramInt, i, new String[] { localObject, paramString, String.valueOf(paramPublishVideoEntry.recordFrames), str1 });
      SLog.b("Q.qqstory.publish.upload.VideoCompositeManager", "video info size:%d, duration:%s, framesCount:%d, bitRate:%s, picSize:%s", new Object[] { Integer.valueOf(i), paramString, Integer.valueOf(paramPublishVideoEntry.recordFrames), str1, localObject });
      return;
    }
    catch (Exception paramString)
    {
      SLog.b("Q.qqstory.publish.upload.VideoCompositeManager", "exception ", paramString);
    }
  }
  
  public void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "add composite vid:%s", new Object[] { paramString });
      }
      c();
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "video composite ing");
      return;
    }
    String str1 = "";
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        str1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      }
      if (TextUtils.isEmpty(str1))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "no video to composite");
        return;
      }
    }
    long l = SystemClock.elapsedRealtime();
    SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "will composite vid:%s", new Object[] { str2 });
    Bosses.get().postJob(new naw(this, str2, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeManager
 * JD-Core Version:    0.7.0.1
 */