package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$2
  implements Runnable
{
  TRTCCloudImpl$2(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: invokestatic 27	com/tencent/liteav/audio/impl/TXCAudioEngineJNI:nativeSetAudioPlayoutTunnelEnabled	(Z)V
    //   4: aload_0
    //   5: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   8: getfield 33	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mNativeLock	Ljava/lang/Object;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   18: getfield 37	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mNativeRtcContext	J
    //   21: lconst_0
    //   22: lcmp
    //   23: ifeq +26 -> 49
    //   26: aload_0
    //   27: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   30: ldc 39
    //   32: invokevirtual 43	com/tencent/liteav/trtc/impl/TRTCCloudImpl:apiLog	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   39: aload_0
    //   40: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   43: getfield 37	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mNativeRtcContext	J
    //   46: invokevirtual 47	com/tencent/liteav/trtc/impl/TRTCCloudImpl:nativeDestroyContext	(J)V
    //   49: aload_0
    //   50: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   53: lconst_0
    //   54: putfield 37	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mNativeRtcContext	J
    //   57: aload_1
    //   58: monitorexit
    //   59: aload_0
    //   60: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   63: astore_1
    //   64: aload_1
    //   65: aconst_null
    //   66: putfield 51	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mTRTCListener	Lcom/tencent/trtc/TRTCCloudListener;
    //   69: aload_1
    //   70: aconst_null
    //   71: putfield 55	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mAudioFrameListener	Lcom/tencent/trtc/TRTCCloudListener$TRTCAudioFrameListener;
    //   74: aload_1
    //   75: bipush 100
    //   77: invokevirtual 59	com/tencent/liteav/trtc/impl/TRTCCloudImpl:setAudioCaptureVolume	(I)V
    //   80: aload_0
    //   81: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   84: bipush 100
    //   86: invokevirtual 62	com/tencent/liteav/trtc/impl/TRTCCloudImpl:setAudioPlayoutVolume	(I)V
    //   89: invokestatic 68	com/tencent/liteav/audio/TXCSoundEffectPlayer:getInstance	()Lcom/tencent/liteav/audio/TXCSoundEffectPlayer;
    //   92: aconst_null
    //   93: invokevirtual 72	com/tencent/liteav/audio/TXCSoundEffectPlayer:setSoundEffectListener	(Lcom/tencent/liteav/audio/b;)V
    //   96: invokestatic 77	com/tencent/liteav/audio/TXCAudioEngine:getInstance	()Lcom/tencent/liteav/audio/TXCAudioEngine;
    //   99: invokevirtual 80	com/tencent/liteav/audio/TXCAudioEngine:clean	()V
    //   102: invokestatic 77	com/tencent/liteav/audio/TXCAudioEngine:getInstance	()Lcom/tencent/liteav/audio/TXCAudioEngine;
    //   105: invokevirtual 83	com/tencent/liteav/audio/TXCAudioEngine:UnInitAudioDevice	()V
    //   108: aload_0
    //   109: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   112: getfield 87	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mCurrentPublishClouds	Ljava/util/HashMap;
    //   115: astore_1
    //   116: aload_1
    //   117: monitorenter
    //   118: aload_0
    //   119: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   122: getfield 87	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mCurrentPublishClouds	Ljava/util/HashMap;
    //   125: invokevirtual 92	java/util/HashMap:clear	()V
    //   128: aload_1
    //   129: monitorexit
    //   130: aload_0
    //   131: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   134: getfield 96	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mSubClouds	Ljava/util/ArrayList;
    //   137: invokevirtual 102	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   140: astore_1
    //   141: aload_1
    //   142: invokeinterface 108 1 0
    //   147: ifeq +30 -> 177
    //   150: aload_1
    //   151: invokeinterface 112 1 0
    //   156: checkcast 114	java/lang/ref/WeakReference
    //   159: invokevirtual 117	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   162: checkcast 29	com/tencent/liteav/trtc/impl/TRTCCloudImpl
    //   165: astore_2
    //   166: aload_2
    //   167: ifnull -26 -> 141
    //   170: aload_2
    //   171: invokevirtual 120	com/tencent/liteav/trtc/impl/TRTCCloudImpl:destroy	()V
    //   174: goto -33 -> 141
    //   177: aload_0
    //   178: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   181: getfield 96	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mSubClouds	Ljava/util/ArrayList;
    //   184: invokevirtual 121	java/util/ArrayList:clear	()V
    //   187: aload_0
    //   188: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   191: invokestatic 125	com/tencent/liteav/trtc/impl/TRTCCloudImpl:access$000	(Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   194: iconst_0
    //   195: invokevirtual 130	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   198: aload_0
    //   199: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   202: getfield 134	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mSDKHandler	Landroid/os/Handler;
    //   205: ifnull +110 -> 315
    //   208: aload_0
    //   209: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   212: getfield 134	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mSDKHandler	Landroid/os/Handler;
    //   215: invokevirtual 140	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   218: invokevirtual 145	android/os/Looper:quit	()V
    //   221: goto +94 -> 315
    //   224: new 147	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   231: astore_1
    //   232: aload_1
    //   233: ldc 150
    //   235: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_1
    //   240: aload_0
    //   241: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   244: invokevirtual 158	java/lang/Object:hashCode	()I
    //   247: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_1
    //   252: ldc 163
    //   254: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: ldc 165
    //   260: aload_1
    //   261: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 175	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: goto +48 -> 315
    //   270: astore_1
    //   271: new 147	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   278: astore_2
    //   279: aload_2
    //   280: ldc 150
    //   282: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_2
    //   287: aload_0
    //   288: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   291: invokevirtual 158	java/lang/Object:hashCode	()I
    //   294: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_2
    //   299: ldc 163
    //   301: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: ldc 165
    //   307: aload_2
    //   308: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: aload_1
    //   312: invokestatic 178	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   315: aload_0
    //   316: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$2:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   319: ldc 180
    //   321: invokevirtual 43	com/tencent/liteav/trtc/impl/TRTCCloudImpl:apiLog	(Ljava/lang/String;)V
    //   324: return
    //   325: astore_2
    //   326: aload_1
    //   327: monitorexit
    //   328: aload_2
    //   329: athrow
    //   330: astore_2
    //   331: aload_1
    //   332: monitorexit
    //   333: goto +5 -> 338
    //   336: aload_2
    //   337: athrow
    //   338: goto -2 -> 336
    //   341: astore_1
    //   342: goto -118 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	2
    //   11	250	1	localObject1	Object
    //   270	62	1	localException	java.lang.Exception
    //   341	1	1	localError	java.lang.Error
    //   165	143	2	localObject2	Object
    //   325	4	2	localObject3	Object
    //   330	7	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   198	221	270	java/lang/Exception
    //   118	130	325	finally
    //   326	328	325	finally
    //   14	49	330	finally
    //   49	59	330	finally
    //   331	333	330	finally
    //   198	221	341	java/lang/Error
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.2
 * JD-Core Version:    0.7.0.1
 */