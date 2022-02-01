package com.tencent.mobileqq.apollo.task;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import anln;
import anlq;
import bhkm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ApolloAudioPlayer
  implements MediaPlayer.OnPreparedListener
{
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private anlq jdField_a_of_type_Anlq;
  public Object a;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  
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
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new anln(this, paramInt, paramString));
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
            bhkm.a(BaseApplicationImpl.getContext(), true);
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
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if ((paramMediaPlayer != null) && (!paramMediaPlayer.isPlaying())) {
      paramMediaPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.task.ApolloAudioPlayer
 * JD-Core Version:    0.7.0.1
 */