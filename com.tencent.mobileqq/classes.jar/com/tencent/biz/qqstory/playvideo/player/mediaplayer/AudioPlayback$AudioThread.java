package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

class AudioPlayback$AudioThread
  extends Thread
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean = true;
  
  AudioPlayback$AudioThread(AudioPlayback paramAudioPlayback)
  {
    super("AudioPlayback");
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    try
    {
      notify();
      return;
    }
    finally {}
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 39	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:isInterrupted	()Z
    //   4: ifne +102 -> 106
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 27	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:jdField_a_of_type_Boolean	Z
    //   13: ifeq +23 -> 36
    //   16: aload_0
    //   17: invokevirtual 42	java/lang/Object:wait	()V
    //   20: goto -11 -> 9
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    //   28: astore_1
    //   29: aload_0
    //   30: invokevirtual 45	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:interrupt	()V
    //   33: goto -33 -> 0
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_0
    //   39: getfield 25	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   42: astore_1
    //   43: aload_1
    //   44: monitorenter
    //   45: aload_0
    //   46: getfield 13	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback;
    //   49: getfield 50	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback:a	Luer;
    //   52: invokevirtual 55	uer:a	()Lues;
    //   55: astore_2
    //   56: aload_2
    //   57: ifnonnull +18 -> 75
    //   60: aload_0
    //   61: getfield 25	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   64: invokevirtual 42	java/lang/Object:wait	()V
    //   67: goto -22 -> 45
    //   70: astore_2
    //   71: aload_1
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    //   75: aload_1
    //   76: monitorexit
    //   77: aload_0
    //   78: getfield 13	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback;
    //   81: aload_2
    //   82: getfield 60	ues:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   85: aload_2
    //   86: getfield 63	ues:jdField_a_of_type_Long	J
    //   89: invokevirtual 67	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback:b	(Ljava/nio/ByteBuffer;J)V
    //   92: aload_0
    //   93: getfield 13	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback$AudioThread:this$0	Lcom/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback;
    //   96: getfield 50	com/tencent/biz/qqstory/playvideo/player/mediaplayer/AudioPlayback:a	Luer;
    //   99: aload_2
    //   100: invokevirtual 70	uer:a	(Lues;)V
    //   103: goto -103 -> 0
    //   106: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	AudioThread
    //   23	4	1	localObject1	Object
    //   28	1	1	localInterruptedException	java.lang.InterruptedException
    //   55	2	2	localues1	ues
    //   70	30	2	localues2	ues
    // Exception table:
    //   from	to	target	type
    //   9	20	23	finally
    //   24	26	23	finally
    //   36	38	23	finally
    //   7	9	28	java/lang/InterruptedException
    //   26	28	28	java/lang/InterruptedException
    //   38	45	28	java/lang/InterruptedException
    //   73	75	28	java/lang/InterruptedException
    //   77	103	28	java/lang/InterruptedException
    //   45	56	70	finally
    //   60	67	70	finally
    //   71	73	70	finally
    //   75	77	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback.AudioThread
 * JD-Core Version:    0.7.0.1
 */