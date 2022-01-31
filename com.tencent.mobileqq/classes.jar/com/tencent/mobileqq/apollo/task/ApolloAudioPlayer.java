package com.tencent.mobileqq.apollo.task;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import zbr;
import zbs;

public class ApolloAudioPlayer
  implements MediaPlayer.OnPreparedListener, IAudioPlayerInterface
{
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private IAudioPlayerListener jdField_a_of_type_ComTencentMobileqqApolloTaskIAudioPlayerListener;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), null);
  public Object a;
  private String jdField_a_of_type_JavaLangString;
  private zbs jdField_a_of_type_Zbs;
  public boolean a;
  
  public ApolloAudioPlayer(IAudioPlayerListener paramIAudioPlayerListener)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqApolloTaskIAudioPlayerListener = paramIAudioPlayerListener;
  }
  
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_0
    //   5: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +5 -> 13
    //   11: iload_2
    //   12: ireturn
    //   13: new 52	android/media/MediaPlayer
    //   16: dup
    //   17: invokespecial 53	android/media/MediaPlayer:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: astore_3
    //   25: aload 4
    //   27: invokevirtual 56	android/media/MediaPlayer:reset	()V
    //   30: aload 4
    //   32: astore_3
    //   33: aload 4
    //   35: aload_0
    //   36: invokevirtual 60	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   39: aload 4
    //   41: astore_3
    //   42: aload 4
    //   44: invokevirtual 63	android/media/MediaPlayer:prepare	()V
    //   47: aload 4
    //   49: astore_3
    //   50: aload 4
    //   52: invokevirtual 67	android/media/MediaPlayer:getDuration	()I
    //   55: istore_2
    //   56: iload_2
    //   57: istore_1
    //   58: aload 4
    //   60: invokevirtual 70	android/media/MediaPlayer:release	()V
    //   63: iload_1
    //   64: istore_2
    //   65: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq -57 -> 11
    //   71: ldc 78
    //   73: iconst_2
    //   74: new 80	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   81: ldc 83
    //   83: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: iload_1
    //   87: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: ldc 92
    //   92: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: iload_1
    //   106: ireturn
    //   107: astore 5
    //   109: aconst_null
    //   110: astore 4
    //   112: aload 4
    //   114: astore_3
    //   115: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +35 -> 153
    //   121: aload 4
    //   123: astore_3
    //   124: ldc 78
    //   126: iconst_2
    //   127: new 80	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   134: ldc 102
    //   136: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 5
    //   141: invokevirtual 105	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   144: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokestatic 108	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload 4
    //   155: invokevirtual 70	android/media/MediaPlayer:release	()V
    //   158: goto -95 -> 63
    //   161: astore 5
    //   163: aconst_null
    //   164: astore 4
    //   166: aload 4
    //   168: astore_3
    //   169: invokestatic 76	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   172: ifeq +35 -> 207
    //   175: aload 4
    //   177: astore_3
    //   178: ldc 78
    //   180: iconst_2
    //   181: new 80	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   188: ldc 110
    //   190: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 5
    //   195: invokevirtual 111	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   198: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 108	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload 4
    //   209: invokevirtual 70	android/media/MediaPlayer:release	()V
    //   212: goto -149 -> 63
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_3
    //   218: aload_3
    //   219: invokevirtual 70	android/media/MediaPlayer:release	()V
    //   222: aload_0
    //   223: athrow
    //   224: astore_0
    //   225: goto -7 -> 218
    //   228: astore 5
    //   230: goto -64 -> 166
    //   233: astore 5
    //   235: goto -123 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramString	String
    //   1	105	1	i	int
    //   3	62	2	j	int
    //   24	195	3	localMediaPlayer1	MediaPlayer
    //   20	188	4	localMediaPlayer2	MediaPlayer
    //   107	33	5	localOutOfMemoryError1	OutOfMemoryError
    //   161	33	5	localThrowable1	Throwable
    //   228	1	5	localThrowable2	Throwable
    //   233	1	5	localOutOfMemoryError2	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   13	22	107	java/lang/OutOfMemoryError
    //   13	22	161	java/lang/Throwable
    //   13	22	215	finally
    //   25	30	224	finally
    //   33	39	224	finally
    //   42	47	224	finally
    //   50	56	224	finally
    //   115	121	224	finally
    //   124	153	224	finally
    //   169	175	224	finally
    //   178	207	224	finally
    //   25	30	228	java/lang/Throwable
    //   33	39	228	java/lang/Throwable
    //   42	47	228	java/lang/Throwable
    //   50	56	228	java/lang/Throwable
    //   25	30	233	java/lang/OutOfMemoryError
    //   33	39	233	java/lang/OutOfMemoryError
    //   42	47	233	java/lang/OutOfMemoryError
    //   50	56	233	java/lang/OutOfMemoryError
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAudioPlayer", 2, "[doPlayVoice], path:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloAudioPlayer", 2, "Fail to play, path is null or file not exist.");
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new zbr(this, paramInt, paramString));
        try
        {
          boolean bool = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).isMusicActive();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloAudioPlayer", 2, "isMusicActive:" + bool);
          }
        }
        catch (OutOfMemoryError paramString)
        {
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            this.jdField_a_of_type_JavaLangString = paramString;
            AudioUtil.a(BaseApplicationImpl.getContext(), true);
            long l = System.currentTimeMillis();
            this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
            this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
            this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
            this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
            this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
            QLog.e("ApolloAudioPlayer", 1, "AudioPlayer " + (System.currentTimeMillis() - l));
            return;
            paramString = paramString;
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloAudioPlayer", 2, "play,oom->errInfo:" + paramString.getMessage());
              return;
            }
          }
        }
        catch (Throwable paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloAudioPlayer", 2, "play, other->errInfo:" + paramString.getMessage());
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAudioPlayer", 2, "[stopVoice]");
    }
    if ((this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) && (this.jdField_a_of_type_Zbs != null)) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacks(this.jdField_a_of_type_Zbs);
    }
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_JavaLangString = null;
        AudioUtil.a(BaseApplicationImpl.getContext(), false);
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ApolloAudioPlayer", 2, "stop->errInfo:" + localIllegalStateException.getMessage());
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ApolloAudioPlayer", 2, "stop->errInfo:" + localThrowable.getMessage());
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null) {
      return;
    }
    this.jdField_a_of_type_Zbs = new zbs(paramString, this, paramInt);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(this.jdField_a_of_type_Zbs, paramLong);
  }
  
  public void a(String paramString, long paramLong)
  {
    a(paramString, 1, paramLong);
  }
  
  public boolean a(String paramString)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramString)))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAudioPlayer", 2, "[release]");
    }
    a();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if ((paramMediaPlayer != null) && (!paramMediaPlayer.isPlaying())) {
      paramMediaPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloAudioPlayer
 * JD-Core Version:    0.7.0.1
 */