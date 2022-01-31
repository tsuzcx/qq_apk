package com.tencent.mobileqq.apollo.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.aioChannel.IRenderRunner;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import zcy;

public class ApolloGameMusicPlayer
{
  public static String a;
  private int jdField_a_of_type_Int = 1;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  public AtomicBoolean a;
  private int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "cmgame_process.ApolloGameMusicPlayer";
  }
  
  public ApolloGameMusicPlayer(AppInterface paramAppInterface, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.b = paramInt;
  }
  
  private void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {}
    while (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("apollo_game_music_switch" + paramAppInterface.getCurrentAccountUin() + "_" + this.b, 1);
  }
  
  public int a(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[getMusicSwitch], gameId:", Integer.valueOf(this.b) });
    }
    a(paramAppInterface);
    return this.jdField_a_of_type_Int;
  }
  
  public int a(IRenderRunner paramIRenderRunner, int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    if (paramIRenderRunner == null) {
      return -1;
    }
    Object localObject1 = a();
    if (localObject1 == null) {
      return -1;
    }
    boolean bool = true;
    if ((paramIRenderRunner instanceof ApolloSurfaceView)) {
      if (((ApolloSurfaceView)paramIRenderRunner).getGameId() <= 0) {
        break label188;
      }
    }
    label188:
    for (bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[playMusic], type:", Integer.valueOf(paramInt1), ",musicPath:", paramString, ",loopCount:", Integer.valueOf(paramInt2), ",isGameMode", Boolean.valueOf(bool), ",gameId:", Integer.valueOf(this.b) });
      }
      a((AppInterface)localObject1);
      if ((!bool) || ((this.jdField_a_of_type_Int != 0) && (localObject1 != null) && (!CmGameUtil.b()) && (!CmGameUtil.c()) && (CmGameUtil.d()) && (paramIRenderRunner != null))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "DO NOT play music.");
      }
      return -1;
    }
    if (-1 == paramInt2) {
      paramInt2 = 2147483647;
    }
    for (;;)
    {
      label563:
      for (localObject1 = null;; localObject1 = null)
      {
        try
        {
          if ((paramIRenderRunner instanceof ApolloSurfaceView)) {
            localObject1 = ((ApolloSurfaceView)paramIRenderRunner).getRender();
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label563;
            }
            localObject1 = new File(((ApolloRender)localObject1).getRscPath(paramString, "mp3"));
            if ((localObject1 != null) && (((File)localObject1).exists())) {
              break;
            }
            QLog.w(jdField_a_of_type_JavaLangString, 1, "music NOT exist.path:" + ((File)localObject1).getAbsolutePath());
            return -1;
            if ((paramIRenderRunner instanceof ApolloTextureView)) {
              localObject1 = ((ApolloTextureView)paramIRenderRunner).getRender();
            }
          }
          if (paramInt1 != 0) {
            break label366;
          }
        }
        catch (Throwable paramIRenderRunner)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[playMusic], errInfo->" + paramIRenderRunner.getMessage());
          return -1;
        }
        paramIRenderRunner = a(((File)localObject1).getPath(), paramInt2);
        if (paramIRenderRunner != null) {
          return paramIRenderRunner.hashCode();
        }
        return -1;
        label366:
        if (this.b == -10000) {
          c(0, paramString);
        }
        if (0 == 0)
        {
          paramString = new MediaPlayer();
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            this.jdField_a_of_type_JavaUtilList.add(paramString);
          }
        }
        for (;;)
        {
          try
          {
            AudioUtil.a(BaseApplicationImpl.getContext(), true);
            paramString.setDataSource(((File)localObject1).getPath());
            if (paramInt2 == 2147483647)
            {
              bool = true;
              paramString.setLooping(bool);
              if (paramInt2 != 2147483647)
              {
                paramString.setOnCompletionListener(new zcy(this, paramInt2, paramIRenderRunner, paramLong));
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "create player, audio_sessionID: " + paramString.getAudioSessionId());
                }
              }
              paramString.prepare();
              paramString.start();
              paramInt1 = paramString.hashCode();
              return paramInt1;
              paramIRenderRunner = finally;
              throw paramIRenderRunner;
            }
            bool = false;
            continue;
            paramString = null;
          }
          catch (Throwable paramIRenderRunner)
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "prepare - start :", paramIRenderRunner);
            return -1;
          }
        }
      }
    }
  }
  
  public MediaPlayer a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        AudioUtil.a(BaseApplicationImpl.getContext(), true);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
        paramString = this.jdField_a_of_type_AndroidMediaMediaPlayer;
        if (paramInt != 2147483647) {
          continue;
        }
        bool = true;
        paramString.setLooping(bool);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
      catch (Throwable paramString)
      {
        boolean bool;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "prepare - start :", paramString);
        continue;
      }
      return this.jdField_a_of_type_AndroidMediaMediaPlayer;
      bool = false;
    }
  }
  
  public AppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[pauseMusic], gameId:", Integer.valueOf(this.b) });
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    do
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameMusicPlayer", 2, "pauseMusic bMute false");
        }
        AudioUtil.a(BaseApplicationImpl.getContext(), false);
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            while (localIterator.hasNext())
            {
              MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
              if (localMediaPlayer != null) {
                localMediaPlayer.pause();
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "pause error:", localException);
        }
        return;
      }
    } while (this.jdField_a_of_type_AndroidMediaMediaPlayer == null);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
  }
  
  public void a(int paramInt, AppInterface arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[setMusicSwitch], sw:", Integer.valueOf(paramInt), ",gameId:", Integer.valueOf(this.b) });
    }
    if ((this.jdField_a_of_type_AndroidContentSharedPreferences == null) || (??? == null)) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("apollo_game_music_switch" + ???.getCurrentAccountUin() + "_" + this.b, paramInt).commit();
      } while (paramInt != 0);
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
            if (localMediaPlayer != null) {
              localMediaPlayer.reset();
            }
          }
        }
      }
    } while (this.jdField_a_of_type_AndroidMediaMediaPlayer == null);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
  }
  
  public void a(int paramInt, String arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[pauseMusic], path:", ???, ",gameId:", Integer.valueOf(this.b) });
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
          if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt))
          {
            if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
              AudioUtil.a(BaseApplicationImpl.getContext(), false);
            }
            localMediaPlayer.pause();
            return;
          }
        }
      }
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.hashCode() == paramInt))
      {
        AudioUtil.a(BaseApplicationImpl.getContext(), true);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
        return;
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[resumeMusic], gameId:", Integer.valueOf(this.b) });
    }
    if ((this.jdField_a_of_type_Int == 0) || (CmGameUtil.b()) || (CmGameUtil.c()) || (!CmGameUtil.d())) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "DO NOT play music.");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      AudioUtil.a(BaseApplicationImpl.getContext(), true);
      try
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            while (localIterator.hasNext())
            {
              MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
              if (localMediaPlayer != null) {
                localMediaPlayer.start();
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "resumeMusic error:", localException);
        return;
      }
    } while (this.jdField_a_of_type_AndroidMediaMediaPlayer == null);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
  }
  
  public void b(int paramInt, String arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[resumeMusic], path:", ???, ",gameId:", Integer.valueOf(this.b) });
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
          if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt))
          {
            AudioUtil.a(BaseApplicationImpl.getContext(), true);
            localMediaPlayer.start();
            return;
          }
        }
      }
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.hashCode() == paramInt))
      {
        AudioUtil.a(BaseApplicationImpl.getContext(), true);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        return;
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[onDestroy],gameId:", Integer.valueOf(this.b) });
    }
    AudioUtil.a(BaseApplicationImpl.getContext(), false);
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label147;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
        if (localMediaPlayer != null)
        {
          localMediaPlayer.stop();
          localMediaPlayer.release();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "stop front music.");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    label147:
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "stop back music.");
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
  }
  
  public void c(int paramInt, String arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[stopMusic], path:", ???, ",gameId:", Integer.valueOf(this.b) });
    }
    for (;;)
    {
      MediaPlayer localMediaPlayer1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label209;
        }
        if (this.b != -10000) {
          break label132;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
          break label129;
        }
        localMediaPlayer1 = (MediaPlayer)this.jdField_a_of_type_JavaUtilList.get(0);
      }
      try
      {
        localMediaPlayer1.stop();
        localMediaPlayer1.release();
        this.jdField_a_of_type_JavaUtilList.remove(localMediaPlayer1);
        continue;
        localObject = finally;
        throw localObject;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          localIllegalStateException.printStackTrace();
        }
      }
    }
    label129:
    return;
    label132:
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      MediaPlayer localMediaPlayer2 = (MediaPlayer)localIterator.next();
      if ((localMediaPlayer2 != null) && (localMediaPlayer2.hashCode() == paramInt))
      {
        AudioUtil.a(BaseApplicationImpl.getContext(), false);
        this.jdField_a_of_type_JavaUtilList.remove(localMediaPlayer2);
        localMediaPlayer2.stop();
        localMediaPlayer2.release();
        return;
      }
    }
    label209:
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.hashCode() == paramInt))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameMusicPlayer
 * JD-Core Version:    0.7.0.1
 */