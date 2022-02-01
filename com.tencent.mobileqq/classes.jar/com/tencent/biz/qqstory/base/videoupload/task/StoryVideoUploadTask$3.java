package com.tencent.biz.qqstory.base.videoupload.task;

import com.tencent.biz.qqstory.base.videoupload.meta.UploadObject.UploadFinishListener;

class StoryVideoUploadTask$3
  implements UploadObject.UploadFinishListener
{
  StoryVideoUploadTask$3(StoryVideoUploadTask paramStoryVideoUploadTask) {}
  
  /* Error */
  public void a(com.tencent.biz.qqstory.base.videoupload.meta.UploadObject paramUploadObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 21	com/tencent/biz/qqstory/base/videoupload/meta/StoryVideoFileObject
    //   4: astore 9
    //   6: aload_0
    //   7: getfield 12	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask$3:a	Lcom/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask;
    //   10: getfield 27	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask:b	Lcom/tencent/biz/qqstory/base/videoupload/task/BaseTaskInfo;
    //   13: checkcast 29	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo
    //   16: aload 9
    //   18: getfield 33	com/tencent/biz/qqstory/base/videoupload/meta/StoryVideoFileObject:c	Lcom/tencent/biz/qqstory/base/videoupload/UploadResult;
    //   21: getfield 38	com/tencent/biz/qqstory/base/videoupload/UploadResult:b	Ljava/lang/String;
    //   24: putfield 41	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo:s	Ljava/lang/String;
    //   27: aload_0
    //   28: getfield 12	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask$3:a	Lcom/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask;
    //   31: getfield 27	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask:b	Lcom/tencent/biz/qqstory/base/videoupload/task/BaseTaskInfo;
    //   34: checkcast 29	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo
    //   37: aload 9
    //   39: getfield 33	com/tencent/biz/qqstory/base/videoupload/meta/StoryVideoFileObject:c	Lcom/tencent/biz/qqstory/base/videoupload/UploadResult;
    //   42: getfield 44	com/tencent/biz/qqstory/base/videoupload/UploadResult:d	Ljava/lang/String;
    //   45: putfield 47	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo:t	Ljava/lang/String;
    //   48: aload_0
    //   49: getfield 12	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask$3:a	Lcom/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask;
    //   52: getfield 27	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask:b	Lcom/tencent/biz/qqstory/base/videoupload/task/BaseTaskInfo;
    //   55: checkcast 29	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo
    //   58: aload 9
    //   60: getfield 48	com/tencent/biz/qqstory/base/videoupload/meta/StoryVideoFileObject:b	Ljava/lang/String;
    //   63: putfield 51	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo:g	Ljava/lang/String;
    //   66: new 53	android/media/MediaMetadataRetriever
    //   69: dup
    //   70: invokespecial 54	android/media/MediaMetadataRetriever:<init>	()V
    //   73: astore 8
    //   75: aload 8
    //   77: aload 9
    //   79: getfield 48	com/tencent/biz/qqstory/base/videoupload/meta/StoryVideoFileObject:b	Ljava/lang/String;
    //   82: invokevirtual 58	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   85: aload 8
    //   87: bipush 24
    //   89: invokevirtual 62	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   92: astore 7
    //   94: aload 7
    //   96: astore_1
    //   97: aload 7
    //   99: ifnonnull +6 -> 105
    //   102: ldc 64
    //   104: astore_1
    //   105: aload_1
    //   106: invokestatic 70	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   109: invokevirtual 74	java/lang/Integer:intValue	()I
    //   112: istore_2
    //   113: aload 8
    //   115: bipush 18
    //   117: invokevirtual 62	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   120: invokestatic 70	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   123: invokevirtual 74	java/lang/Integer:intValue	()I
    //   126: istore_3
    //   127: aload 8
    //   129: bipush 19
    //   131: invokevirtual 62	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   134: invokestatic 70	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   137: invokevirtual 74	java/lang/Integer:intValue	()I
    //   140: istore 4
    //   142: iload_2
    //   143: sipush 180
    //   146: irem
    //   147: ifle +35 -> 182
    //   150: aload_0
    //   151: getfield 12	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask$3:a	Lcom/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask;
    //   154: getfield 27	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask:b	Lcom/tencent/biz/qqstory/base/videoupload/task/BaseTaskInfo;
    //   157: checkcast 29	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo
    //   160: iload 4
    //   162: putfield 78	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo:o	I
    //   165: aload_0
    //   166: getfield 12	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask$3:a	Lcom/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask;
    //   169: getfield 27	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask:b	Lcom/tencent/biz/qqstory/base/videoupload/task/BaseTaskInfo;
    //   172: checkcast 29	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo
    //   175: iload_3
    //   176: putfield 81	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo:p	I
    //   179: goto +48 -> 227
    //   182: aload_0
    //   183: getfield 12	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask$3:a	Lcom/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask;
    //   186: getfield 27	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask:b	Lcom/tencent/biz/qqstory/base/videoupload/task/BaseTaskInfo;
    //   189: checkcast 29	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo
    //   192: iload_3
    //   193: putfield 78	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo:o	I
    //   196: aload_0
    //   197: getfield 12	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask$3:a	Lcom/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask;
    //   200: getfield 27	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask:b	Lcom/tencent/biz/qqstory/base/videoupload/task/BaseTaskInfo;
    //   203: checkcast 29	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo
    //   206: iload 4
    //   208: putfield 81	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo:p	I
    //   211: goto +16 -> 227
    //   214: astore_1
    //   215: goto +163 -> 378
    //   218: astore_1
    //   219: ldc 83
    //   221: ldc 85
    //   223: aload_1
    //   224: invokestatic 90	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   227: aload 8
    //   229: invokevirtual 93	android/media/MediaMetadataRetriever:release	()V
    //   232: aload 9
    //   234: getfield 48	com/tencent/biz/qqstory/base/videoupload/meta/StoryVideoFileObject:b	Ljava/lang/String;
    //   237: invokestatic 96	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask:a	(Ljava/lang/String;)J
    //   240: lstore 5
    //   242: lload 5
    //   244: lconst_0
    //   245: lcmp
    //   246: ifle +95 -> 341
    //   249: ldc 83
    //   251: ldc 98
    //   253: aload_0
    //   254: getfield 12	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask$3:a	Lcom/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask;
    //   257: getfield 27	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask:b	Lcom/tencent/biz/qqstory/base/videoupload/task/BaseTaskInfo;
    //   260: checkcast 29	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo
    //   263: getfield 102	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo:m	J
    //   266: invokestatic 107	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   269: lload 5
    //   271: invokestatic 107	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   274: invokestatic 110	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   277: aload_0
    //   278: getfield 12	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask$3:a	Lcom/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask;
    //   281: getfield 27	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask:b	Lcom/tencent/biz/qqstory/base/videoupload/task/BaseTaskInfo;
    //   284: checkcast 29	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo
    //   287: lload 5
    //   289: putfield 102	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo:m	J
    //   292: ldc 83
    //   294: ldc 112
    //   296: aload_0
    //   297: getfield 12	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask$3:a	Lcom/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask;
    //   300: getfield 27	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask:b	Lcom/tencent/biz/qqstory/base/videoupload/task/BaseTaskInfo;
    //   303: checkcast 29	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo
    //   306: invokevirtual 115	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo:d	()Ljava/lang/String;
    //   309: aload_0
    //   310: getfield 12	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask$3:a	Lcom/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask;
    //   313: getfield 27	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask:b	Lcom/tencent/biz/qqstory/base/videoupload/task/BaseTaskInfo;
    //   316: checkcast 29	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo
    //   319: getfield 102	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo:m	J
    //   322: invokestatic 107	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   325: aload_0
    //   326: getfield 12	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask$3:a	Lcom/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask;
    //   329: getfield 27	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask:b	Lcom/tencent/biz/qqstory/base/videoupload/task/BaseTaskInfo;
    //   332: checkcast 29	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo
    //   335: getfield 51	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo:g	Ljava/lang/String;
    //   338: invokestatic 118	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   341: aload_0
    //   342: getfield 12	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask$3:a	Lcom/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask;
    //   345: getfield 27	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask:b	Lcom/tencent/biz/qqstory/base/videoupload/task/BaseTaskInfo;
    //   348: checkcast 29	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo
    //   351: aload 9
    //   353: getfield 48	com/tencent/biz/qqstory/base/videoupload/meta/StoryVideoFileObject:b	Ljava/lang/String;
    //   356: invokestatic 121	com/tencent/biz/qqstory/utils/FileUtils:a	(Ljava/lang/String;)J
    //   359: putfield 124	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoTaskInfo:n	J
    //   362: aload_0
    //   363: getfield 12	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask$3:a	Lcom/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask;
    //   366: iconst_1
    //   367: new 126	com/tencent/biz/qqstory/base/ErrorMessage
    //   370: dup
    //   371: invokespecial 127	com/tencent/biz/qqstory/base/ErrorMessage:<init>	()V
    //   374: invokevirtual 130	com/tencent/biz/qqstory/base/videoupload/task/StoryVideoUploadTask:a	(ILcom/tencent/biz/qqstory/base/ErrorMessage;)V
    //   377: return
    //   378: aload 8
    //   380: invokevirtual 93	android/media/MediaMetadataRetriever:release	()V
    //   383: aload_1
    //   384: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	this	3
    //   0	385	1	paramUploadObject	com.tencent.biz.qqstory.base.videoupload.meta.UploadObject
    //   112	35	2	i	int
    //   126	67	3	j	int
    //   140	67	4	k	int
    //   240	48	5	l	long
    //   92	6	7	str	java.lang.String
    //   73	306	8	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   4	348	9	localStoryVideoFileObject	com.tencent.biz.qqstory.base.videoupload.meta.StoryVideoFileObject
    // Exception table:
    //   from	to	target	type
    //   75	94	214	finally
    //   105	142	214	finally
    //   150	179	214	finally
    //   182	211	214	finally
    //   219	227	214	finally
    //   75	94	218	java/lang/Exception
    //   105	142	218	java/lang/Exception
    //   150	179	218	java/lang/Exception
    //   182	211	218	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask.3
 * JD-Core Version:    0.7.0.1
 */