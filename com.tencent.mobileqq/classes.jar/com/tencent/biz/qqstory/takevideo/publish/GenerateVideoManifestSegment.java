package com.tencent.biz.qqstory.takevideo.publish;

public class GenerateVideoManifestSegment
  extends MeasureJobSegment
{
  /* Error */
  protected void a(com.tribe.async.async.JobContext paramJobContext, com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr paramRMVideoStateMgr)
  {
    // Byte code:
    //   0: ldc 17
    //   2: ldc 19
    //   4: invokestatic 25	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: invokestatic 31	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   10: ifeq +185 -> 195
    //   13: ldc 33
    //   15: iconst_0
    //   16: invokestatic 39	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;Z)Lcooperation/qzone/thread/QzoneBaseThread;
    //   19: new 41	opx
    //   22: dup
    //   23: aload_0
    //   24: aload_2
    //   25: invokespecial 44	opx:<init>	(Lcom/tencent/biz/qqstory/takevideo/publish/GenerateVideoManifestSegment;Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   28: invokevirtual 50	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
    //   31: invokestatic 31	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   34: ifeq +155 -> 189
    //   37: lconst_0
    //   38: lstore 6
    //   40: aload_2
    //   41: getfield 55	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   44: astore_1
    //   45: aload_1
    //   46: monitorenter
    //   47: aload_2
    //   48: getfield 55	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   51: invokevirtual 60	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   54: istore 10
    //   56: lload 6
    //   58: lstore 4
    //   60: iload 10
    //   62: ifne +82 -> 144
    //   65: lload 6
    //   67: lstore 4
    //   69: ldc 17
    //   71: ldc 62
    //   73: invokestatic 25	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: lload 6
    //   78: lstore 4
    //   80: invokestatic 68	android/os/SystemClock:elapsedRealtime	()J
    //   83: lstore 8
    //   85: lload 6
    //   87: lstore 4
    //   89: aload_2
    //   90: getfield 55	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   93: ldc2_w 69
    //   96: invokevirtual 76	java/lang/Object:wait	(J)V
    //   99: lload 6
    //   101: lstore 4
    //   103: invokestatic 68	android/os/SystemClock:elapsedRealtime	()J
    //   106: lload 8
    //   108: lsub
    //   109: lstore 6
    //   111: lload 6
    //   113: lstore 4
    //   115: ldc 17
    //   117: new 78	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   124: ldc 81
    //   126: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: lload 6
    //   131: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   134: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 25	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: lload 6
    //   142: lstore 4
    //   144: aload_1
    //   145: monitorexit
    //   146: ldc 17
    //   148: ldc 94
    //   150: invokestatic 25	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: lload 4
    //   155: ldc2_w 95
    //   158: lcmp
    //   159: ifge +30 -> 189
    //   162: bipush 30
    //   164: lload 4
    //   166: l2i
    //   167: isub
    //   168: istore_3
    //   169: ldc 17
    //   171: ldc 98
    //   173: iload_3
    //   174: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: invokestatic 107	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   180: iload_3
    //   181: i2l
    //   182: lstore 4
    //   184: lload 4
    //   186: invokestatic 112	java/lang/Thread:sleep	(J)V
    //   189: aload_0
    //   190: aconst_null
    //   191: invokespecial 116	com/tencent/biz/qqstory/takevideo/publish/MeasureJobSegment:notifyResult	(Ljava/lang/Object;)V
    //   194: return
    //   195: invokestatic 121	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/mobileqq/shortvideo/mediadevice/RecordManager;
    //   198: invokevirtual 124	com/tencent/mobileqq/shortvideo/mediadevice/RecordManager:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   201: invokevirtual 130	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   204: pop
    //   205: ldc 17
    //   207: ldc 132
    //   209: invokestatic 25	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: goto -181 -> 31
    //   215: astore_1
    //   216: ldc 17
    //   218: ldc 134
    //   220: aload_1
    //   221: invokestatic 137	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: goto -193 -> 31
    //   227: astore_2
    //   228: ldc 17
    //   230: new 78	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   237: ldc 139
    //   239: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_2
    //   243: invokevirtual 142	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   246: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 25	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: goto -111 -> 144
    //   258: astore_2
    //   259: aload_1
    //   260: monitorexit
    //   261: aload_2
    //   262: athrow
    //   263: astore_1
    //   264: goto -75 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	GenerateVideoManifestSegment
    //   0	267	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	267	2	paramRMVideoStateMgr	com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
    //   168	13	3	i	int
    //   58	127	4	l1	long
    //   38	103	6	l2	long
    //   83	24	8	l3	long
    //   54	7	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   195	212	215	java/lang/UnsatisfiedLinkError
    //   69	76	227	java/lang/InterruptedException
    //   80	85	227	java/lang/InterruptedException
    //   89	99	227	java/lang/InterruptedException
    //   103	111	227	java/lang/InterruptedException
    //   115	140	227	java/lang/InterruptedException
    //   47	56	258	finally
    //   69	76	258	finally
    //   80	85	258	finally
    //   89	99	258	finally
    //   103	111	258	finally
    //   115	140	258	finally
    //   144	146	258	finally
    //   228	255	258	finally
    //   259	261	258	finally
    //   184	189	263	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.publish.GenerateVideoManifestSegment
 * JD-Core Version:    0.7.0.1
 */