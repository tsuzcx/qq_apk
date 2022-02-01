package com.tencent.aelight.camera.aioeditor.takevideo.doodle.model;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.download.DownloadProgressListener;
import com.tencent.biz.qqstory.base.download.Downloader;
import com.tencent.biz.qqstory.base.download.DownloaderImp;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;

class DoodleEmojiManager$DownloadAndUnZipJob
  extends SimpleJob<DoodleEmojiItem>
  implements DownloadProgressListener
{
  protected long a;
  private final DoodleEmojiItem jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem;
  private final Downloader jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader;
  private long b = 0L;
  
  public DoodleEmojiManager$DownloadAndUnZipJob(DoodleEmojiItem paramDoodleEmojiItem)
  {
    super("DownloadAndUnZipJob");
    if (paramDoodleEmojiItem != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader = new DownloaderImp();
      this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader.a(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem = paramDoodleEmojiItem;
      return;
    }
    throw new IllegalArgumentException("doodleEmojiItem should not be null");
  }
  
  protected DoodleEmojiItem a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem.download_url, DoodleEmojiManager.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem.pack_id), 0L);
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem;
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager$DownloadAndUnZipJob:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem;
    //   4: astore 9
    //   6: iload_2
    //   7: ifne +362 -> 369
    //   10: aload 9
    //   12: getfield 53	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   15: invokestatic 58	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 8
    //   20: aload 9
    //   22: getfield 53	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   25: invokestatic 67	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore_1
    //   29: new 69	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   36: astore 10
    //   38: aload 10
    //   40: ldc 72
    //   42: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 10
    //   48: aload 8
    //   50: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: ldc 78
    //   56: aload 10
    //   58: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 87	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: new 69	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   71: astore 10
    //   73: aload 10
    //   75: ldc 89
    //   77: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 10
    //   83: aload_1
    //   84: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: ldc 78
    //   90: aload 10
    //   92: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 87	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_1
    //   99: invokestatic 95	com/tencent/biz/qqstory/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   102: pop
    //   103: goto +29 -> 132
    //   106: astore_1
    //   107: goto +247 -> 354
    //   110: astore 10
    //   112: ldc 78
    //   114: ldc 97
    //   116: iconst_2
    //   117: anewarray 99	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_1
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload 10
    //   128: aastore
    //   129: invokestatic 102	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload 8
    //   134: aload_1
    //   135: invokestatic 108	com/tencent/biz/common/util/ZipUtils:unZipFolder	(Ljava/lang/String;Ljava/lang/String;)I
    //   138: istore_3
    //   139: iload_3
    //   140: ifne +150 -> 290
    //   143: invokestatic 114	android/os/SystemClock:uptimeMillis	()J
    //   146: lstore 4
    //   148: aload_0
    //   149: getfield 116	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager$DownloadAndUnZipJob:jdField_a_of_type_Long	J
    //   152: lstore 6
    //   154: aload 9
    //   156: getfield 53	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   159: astore 10
    //   161: new 69	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   168: astore 11
    //   170: aload 11
    //   172: lload 4
    //   174: lload 6
    //   176: lsub
    //   177: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 11
    //   183: ldc 121
    //   185: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: ldc 123
    //   191: ldc 125
    //   193: iconst_0
    //   194: iconst_0
    //   195: iconst_2
    //   196: anewarray 127	java/lang/String
    //   199: dup
    //   200: iconst_0
    //   201: aload 10
    //   203: aastore
    //   204: dup
    //   205: iconst_1
    //   206: aload 11
    //   208: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: aastore
    //   212: invokestatic 132	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   215: ldc 123
    //   217: ldc 134
    //   219: iconst_0
    //   220: iconst_0
    //   221: iconst_1
    //   222: anewarray 127	java/lang/String
    //   225: dup
    //   226: iconst_0
    //   227: aload 9
    //   229: getfield 53	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   232: aastore
    //   233: invokestatic 132	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   236: ldc 78
    //   238: ldc 136
    //   240: invokestatic 139	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 9
    //   245: aload_1
    //   246: invokevirtual 142	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:setLocalEmojiFolderPath	(Ljava/lang/String;)V
    //   249: new 144	java/io/File
    //   252: dup
    //   253: aload_1
    //   254: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   257: invokestatic 150	java/lang/System:currentTimeMillis	()J
    //   260: invokevirtual 154	java/io/File:setLastModified	(J)Z
    //   263: pop
    //   264: invokestatic 159	com/tencent/biz/qqstory/base/StoryDispatcher:a	()Lcom/tribe/async/dispatch/Dispatcher;
    //   267: astore_1
    //   268: aload_1
    //   269: new 161	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager$DoodleEmojiDownloadEvent
    //   272: dup
    //   273: aload 9
    //   275: iload_2
    //   276: iconst_1
    //   277: lconst_0
    //   278: lconst_0
    //   279: invokespecial 164	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager$DoodleEmojiDownloadEvent:<init>	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem;IZJJ)V
    //   282: invokeinterface 170 2 0
    //   287: goto +52 -> 339
    //   290: ldc 78
    //   292: ldc 172
    //   294: invokestatic 174	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: invokestatic 159	com/tencent/biz/qqstory/base/StoryDispatcher:a	()Lcom/tribe/async/dispatch/Dispatcher;
    //   300: new 161	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager$DoodleEmojiDownloadEvent
    //   303: dup
    //   304: aload 9
    //   306: iload_3
    //   307: iconst_0
    //   308: lconst_0
    //   309: lconst_0
    //   310: invokespecial 164	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager$DoodleEmojiDownloadEvent:<init>	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem;IZJJ)V
    //   313: invokeinterface 170 2 0
    //   318: ldc 123
    //   320: ldc 134
    //   322: iconst_0
    //   323: iload_3
    //   324: iconst_1
    //   325: anewarray 127	java/lang/String
    //   328: dup
    //   329: iconst_0
    //   330: aload 9
    //   332: getfield 53	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   335: aastore
    //   336: invokestatic 132	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   339: new 144	java/io/File
    //   342: dup
    //   343: aload 8
    //   345: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   348: invokevirtual 178	java/io/File:delete	()Z
    //   351: pop
    //   352: return
    //   353: astore_1
    //   354: new 144	java/io/File
    //   357: dup
    //   358: aload 8
    //   360: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   363: invokevirtual 178	java/io/File:delete	()Z
    //   366: pop
    //   367: aload_1
    //   368: athrow
    //   369: new 69	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   376: astore 8
    //   378: aload 8
    //   380: ldc 180
    //   382: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 8
    //   388: iload_2
    //   389: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 8
    //   395: ldc 185
    //   397: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 8
    //   403: aload_1
    //   404: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: ldc 78
    //   410: aload 8
    //   412: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 188	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   418: invokestatic 159	com/tencent/biz/qqstory/base/StoryDispatcher:a	()Lcom/tribe/async/dispatch/Dispatcher;
    //   421: new 161	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager$DoodleEmojiDownloadEvent
    //   424: dup
    //   425: aload 9
    //   427: iload_2
    //   428: iconst_1
    //   429: lconst_0
    //   430: lconst_0
    //   431: invokespecial 164	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiManager$DoodleEmojiDownloadEvent:<init>	(Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem;IZJJ)V
    //   434: invokeinterface 170 2 0
    //   439: ldc 123
    //   441: ldc 134
    //   443: iconst_0
    //   444: iload_2
    //   445: iconst_1
    //   446: anewarray 127	java/lang/String
    //   449: dup
    //   450: iconst_0
    //   451: aload 9
    //   453: getfield 53	com/tencent/aelight/camera/aioeditor/takevideo/doodle/model/DoodleEmojiItem:pack_id	Ljava/lang/String;
    //   456: aastore
    //   457: invokestatic 132	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   460: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	this	DownloadAndUnZipJob
    //   0	461	1	paramString	String
    //   0	461	2	paramInt	int
    //   138	186	3	i	int
    //   146	27	4	l1	long
    //   152	23	6	l2	long
    //   18	393	8	localObject	Object
    //   4	448	9	localDoodleEmojiItem	DoodleEmojiItem
    //   36	55	10	localStringBuilder1	StringBuilder
    //   110	17	10	localException	java.lang.Exception
    //   159	43	10	str	String
    //   168	39	11	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   98	103	106	finally
    //   112	132	106	finally
    //   132	139	106	finally
    //   143	268	106	finally
    //   98	103	110	java/lang/Exception
    //   268	287	353	finally
    //   290	339	353	finally
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem;
    if (!TextUtils.equals(((DoodleEmojiItem)localObject).download_url, paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DownloadListener onProgress error : ");
      localStringBuilder.append(localObject);
      SLog.d("DoodleEmojiManager", localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DownloadListener onProgress error : call back url = ");
      ((StringBuilder)localObject).append(paramString);
      SLog.d("DoodleEmojiManager", ((StringBuilder)localObject).toString());
      return;
    }
    long l = paramLong2 / 10L;
    if (paramLong1 > this.b + l)
    {
      paramString = new StringBuilder();
      paramString.append("DownloadListener onProgress ");
      paramString.append(paramLong1);
      paramString.append(" / ");
      paramString.append(paramLong2);
      SLog.a("DoodleEmojiManager", paramString.toString());
      StoryDispatcher.a().dispatch(new DoodleEmojiManager.DoodleEmojiDownloadEvent((DoodleEmojiItem)localObject, 0, false, paramLong2, paramLong1));
      this.b = paramLong1;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadStart : url = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", path = ");
    localStringBuilder.append(paramString2);
    SLog.b("DoodleEmojiManager", localStringBuilder.toString());
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.DownloadAndUnZipJob
 * JD-Core Version:    0.7.0.1
 */