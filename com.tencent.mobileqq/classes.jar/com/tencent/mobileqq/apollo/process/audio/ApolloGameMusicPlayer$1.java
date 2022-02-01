package com.tencent.mobileqq.apollo.process.audio;

import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.apollo.api.render.IRenderRunner;

class ApolloGameMusicPlayer$1
  implements MediaPlayer.OnCompletionListener
{
  int jdField_a_of_type_Int = this.b;
  
  ApolloGameMusicPlayer$1(ApolloGameMusicPlayer paramApolloGameMusicPlayer, int paramInt, IRenderRunner paramIRenderRunner, long paramLong) {}
  
  /* Error */
  public void onCompletion(android.media.MediaPlayer paramMediaPlayer)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 27	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1:jdField_a_of_type_Int	I
    //   5: iconst_1
    //   6: isub
    //   7: putfield 27	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1:jdField_a_of_type_Int	I
    //   10: aload_1
    //   11: iconst_0
    //   12: invokevirtual 38	android/media/MediaPlayer:seekTo	(I)V
    //   15: aload_0
    //   16: getfield 27	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1:jdField_a_of_type_Int	I
    //   19: ifle +21 -> 40
    //   22: aload_0
    //   23: getfield 16	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1:jdField_a_of_type_ComTencentMobileqqApolloProcessAudioApolloGameMusicPlayer	Lcom/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer;
    //   26: getfield 43	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   29: invokevirtual 49	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   32: ifne +8 -> 40
    //   35: aload_1
    //   36: invokevirtual 52	android/media/MediaPlayer:start	()V
    //   39: return
    //   40: aload_0
    //   41: getfield 16	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1:jdField_a_of_type_ComTencentMobileqqApolloProcessAudioApolloGameMusicPlayer	Lcom/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer;
    //   44: getfield 43	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   47: invokevirtual 49	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   50: ifeq +11 -> 61
    //   53: aload_0
    //   54: getfield 16	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1:jdField_a_of_type_ComTencentMobileqqApolloProcessAudioApolloGameMusicPlayer	Lcom/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer;
    //   57: iconst_0
    //   58: invokestatic 55	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer:a	(Lcom/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer;Z)V
    //   61: aload_0
    //   62: getfield 16	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1:jdField_a_of_type_ComTencentMobileqqApolloProcessAudioApolloGameMusicPlayer	Lcom/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer;
    //   65: invokestatic 58	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer:a	(Lcom/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer;)Ljava/lang/Object;
    //   68: astore_2
    //   69: aload_2
    //   70: monitorenter
    //   71: aload_0
    //   72: getfield 16	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1:jdField_a_of_type_ComTencentMobileqqApolloProcessAudioApolloGameMusicPlayer	Lcom/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer;
    //   75: invokestatic 61	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer:a	(Lcom/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer;)Ljava/util/List;
    //   78: aload_1
    //   79: invokeinterface 67 2 0
    //   84: ifeq +17 -> 101
    //   87: aload_0
    //   88: getfield 16	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1:jdField_a_of_type_ComTencentMobileqqApolloProcessAudioApolloGameMusicPlayer	Lcom/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer;
    //   91: invokestatic 61	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer:a	(Lcom/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer;)Ljava/util/List;
    //   94: aload_1
    //   95: invokeinterface 70 2 0
    //   100: pop
    //   101: aload_2
    //   102: monitorexit
    //   103: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +32 -> 138
    //   109: getstatic 78	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   112: iconst_2
    //   113: new 80	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   120: ldc 83
    //   122: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_1
    //   126: invokevirtual 91	android/media/MediaPlayer:getAudioSessionId	()I
    //   129: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload_0
    //   139: getfield 20	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1:jdField_a_of_type_ComTencentMobileqqApolloApiRenderIRenderRunner	Lcom/tencent/mobileqq/apollo/api/render/IRenderRunner;
    //   142: instanceof 104
    //   145: ifeq +24 -> 169
    //   148: aload_0
    //   149: getfield 20	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1:jdField_a_of_type_ComTencentMobileqqApolloApiRenderIRenderRunner	Lcom/tencent/mobileqq/apollo/api/render/IRenderRunner;
    //   152: checkcast 104	com/tencent/mobileqq/apollo/ApolloSurfaceView
    //   155: astore_2
    //   156: aload_2
    //   157: new 106	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1$1
    //   160: dup
    //   161: aload_0
    //   162: aload_2
    //   163: invokespecial 109	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1$1:<init>	(Lcom/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer$1;Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;)V
    //   166: invokevirtual 113	com/tencent/mobileqq/apollo/ApolloSurfaceView:runRenderTask	(Lcom/tencent/mobileqq/apollo/IApolloRunnableTask;)V
    //   169: aload_1
    //   170: invokevirtual 116	android/media/MediaPlayer:reset	()V
    //   173: aload_1
    //   174: invokevirtual 119	android/media/MediaPlayer:release	()V
    //   177: return
    //   178: astore_2
    //   179: aload_1
    //   180: ifnull +7 -> 187
    //   183: aload_1
    //   184: invokevirtual 119	android/media/MediaPlayer:release	()V
    //   187: getstatic 78	com/tencent/mobileqq/apollo/process/audio/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   190: iconst_1
    //   191: ldc 121
    //   193: aload_2
    //   194: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: return
    //   198: astore_3
    //   199: aload_2
    //   200: monitorexit
    //   201: aload_3
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	1
    //   0	203	1	paramMediaPlayer	android.media.MediaPlayer
    //   178	22	2	localThrowable	java.lang.Throwable
    //   198	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	39	178	java/lang/Throwable
    //   40	61	178	java/lang/Throwable
    //   61	71	178	java/lang/Throwable
    //   103	138	178	java/lang/Throwable
    //   138	169	178	java/lang/Throwable
    //   169	177	178	java/lang/Throwable
    //   201	203	178	java/lang/Throwable
    //   71	101	198	finally
    //   101	103	198	finally
    //   199	201	198	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.audio.ApolloGameMusicPlayer.1
 * JD-Core Version:    0.7.0.1
 */