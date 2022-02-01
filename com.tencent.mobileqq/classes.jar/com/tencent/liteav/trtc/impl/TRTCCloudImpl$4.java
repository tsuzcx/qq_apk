package com.tencent.liteav.trtc.impl;

class TRTCCloudImpl$4
  implements Runnable
{
  TRTCCloudImpl$4(TRTCCloudImpl paramTRTCCloudImpl) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: invokestatic 27	com/tencent/liteav/audio/impl/TXCAudioEngineJNI:nativeSetAudioPlayoutTunnelEnabled	(Z)V
    //   4: aload_0
    //   5: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   8: getfield 33	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mNativeLock	Ljava/lang/Object;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   18: getfield 37	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mNativeRtcContext	J
    //   21: lconst_0
    //   22: lcmp
    //   23: ifeq +26 -> 49
    //   26: aload_0
    //   27: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   30: ldc 39
    //   32: invokevirtual 43	com/tencent/liteav/trtc/impl/TRTCCloudImpl:apiLog	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   39: aload_0
    //   40: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   43: getfield 37	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mNativeRtcContext	J
    //   46: invokevirtual 47	com/tencent/liteav/trtc/impl/TRTCCloudImpl:nativeDestroyContext	(J)V
    //   49: aload_0
    //   50: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   53: lconst_0
    //   54: putfield 37	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mNativeRtcContext	J
    //   57: aload_1
    //   58: monitorexit
    //   59: aload_0
    //   60: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
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
    //   81: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   84: bipush 100
    //   86: invokevirtual 62	com/tencent/liteav/trtc/impl/TRTCCloudImpl:setAudioPlayoutVolume	(I)V
    //   89: invokestatic 68	com/tencent/liteav/audio/TXCSoundEffectPlayer:getInstance	()Lcom/tencent/liteav/audio/TXCSoundEffectPlayer;
    //   92: aconst_null
    //   93: invokevirtual 72	com/tencent/liteav/audio/TXCSoundEffectPlayer:setSoundEffectListener	(Lcom/tencent/liteav/audio/c;)V
    //   96: invokestatic 77	com/tencent/liteav/audio/TXCAudioEngine:getInstance	()Lcom/tencent/liteav/audio/TXCAudioEngine;
    //   99: invokevirtual 80	com/tencent/liteav/audio/TXCAudioEngine:clean	()V
    //   102: invokestatic 77	com/tencent/liteav/audio/TXCAudioEngine:getInstance	()Lcom/tencent/liteav/audio/TXCAudioEngine;
    //   105: invokevirtual 83	com/tencent/liteav/audio/TXCAudioEngine:UnInitAudioDevice	()V
    //   108: aload_0
    //   109: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   112: getfield 87	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mCurrentPublishClouds	Ljava/util/HashMap;
    //   115: astore_1
    //   116: aload_1
    //   117: monitorenter
    //   118: aload_0
    //   119: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   122: getfield 87	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mCurrentPublishClouds	Ljava/util/HashMap;
    //   125: invokevirtual 92	java/util/HashMap:clear	()V
    //   128: aload_1
    //   129: monitorexit
    //   130: aload_0
    //   131: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
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
    //   178: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   181: getfield 96	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mSubClouds	Ljava/util/ArrayList;
    //   184: invokevirtual 121	java/util/ArrayList:clear	()V
    //   187: invokestatic 127	com/tencent/liteav/audio/a:a	()Lcom/tencent/liteav/audio/a;
    //   190: aload_0
    //   191: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   194: invokevirtual 131	java/lang/Object:hashCode	()I
    //   197: invokevirtual 133	com/tencent/liteav/audio/a:a	(I)V
    //   200: aload_0
    //   201: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   204: invokestatic 137	com/tencent/liteav/trtc/impl/TRTCCloudImpl:access$200	(Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   207: iconst_0
    //   208: invokevirtual 142	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   211: aload_0
    //   212: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   215: getfield 146	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mSDKHandler	Lcom/tencent/liteav/basic/util/f;
    //   218: ifnull +110 -> 328
    //   221: aload_0
    //   222: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   225: getfield 146	com/tencent/liteav/trtc/impl/TRTCCloudImpl:mSDKHandler	Lcom/tencent/liteav/basic/util/f;
    //   228: invokevirtual 152	com/tencent/liteav/basic/util/f:getLooper	()Landroid/os/Looper;
    //   231: invokevirtual 157	android/os/Looper:quit	()V
    //   234: goto +94 -> 328
    //   237: new 159	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   244: astore_1
    //   245: aload_1
    //   246: ldc 162
    //   248: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_1
    //   253: aload_0
    //   254: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   257: invokevirtual 131	java/lang/Object:hashCode	()I
    //   260: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_1
    //   265: ldc 171
    //   267: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: ldc 173
    //   273: aload_1
    //   274: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 183	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: goto +48 -> 328
    //   283: astore_1
    //   284: new 159	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   291: astore_2
    //   292: aload_2
    //   293: ldc 162
    //   295: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload_2
    //   300: aload_0
    //   301: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   304: invokevirtual 131	java/lang/Object:hashCode	()I
    //   307: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_2
    //   312: ldc 171
    //   314: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: ldc 173
    //   320: aload_2
    //   321: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: aload_1
    //   325: invokestatic 186	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   328: aload_0
    //   329: getfield 12	com/tencent/liteav/trtc/impl/TRTCCloudImpl$4:this$0	Lcom/tencent/liteav/trtc/impl/TRTCCloudImpl;
    //   332: ldc 188
    //   334: invokevirtual 43	com/tencent/liteav/trtc/impl/TRTCCloudImpl:apiLog	(Ljava/lang/String;)V
    //   337: return
    //   338: astore_2
    //   339: aload_1
    //   340: monitorexit
    //   341: aload_2
    //   342: athrow
    //   343: astore_2
    //   344: aload_1
    //   345: monitorexit
    //   346: goto +5 -> 351
    //   349: aload_2
    //   350: athrow
    //   351: goto -2 -> 349
    //   354: astore_1
    //   355: goto -118 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	4
    //   11	263	1	localObject1	Object
    //   283	62	1	localException	java.lang.Exception
    //   354	1	1	localError	java.lang.Error
    //   165	156	2	localObject2	Object
    //   338	4	2	localObject3	Object
    //   343	7	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   211	234	283	java/lang/Exception
    //   118	130	338	finally
    //   339	341	338	finally
    //   14	49	343	finally
    //   49	59	343	finally
    //   344	346	343	finally
    //   211	234	354	java/lang/Error
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.4
 * JD-Core Version:    0.7.0.1
 */