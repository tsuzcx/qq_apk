package com.tencent.mobileqq.apollo.game.process.audio;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderRunner;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;

public class ApolloGameMusicPlayer
  implements ICmGameAudioPlayer
{
  public static String a = "cmgame_process.ApolloGameMusicPlayer";
  AtomicBoolean b;
  AudioManager c;
  private SharedPreferences d;
  private List<MediaPlayer> e = Collections.synchronizedList(new ArrayList());
  private MediaPlayer f;
  private int g = 1;
  private int h;
  private final Object i;
  private WeakReference<AppInterface> j;
  private AudioManager.OnAudioFocusChangeListener k;
  
  public ApolloGameMusicPlayer(int paramInt)
  {
    int m = 0;
    this.b = new AtomicBoolean(false);
    this.i = new Object();
    this.k = new ApolloGameMusicPlayer.2(this);
    AppInterface localAppInterface = CmGameUtil.b();
    if (BaseApplicationImpl.sProcessId != 1) {
      m = 4;
    }
    this.d = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", m);
    this.j = new WeakReference(localAppInterface);
    this.h = paramInt;
    this.c = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
    b(localAppInterface);
  }
  
  @NotNull
  private MediaPlayer.OnCompletionListener a(IRenderRunner paramIRenderRunner, long paramLong, int paramInt)
  {
    return new ApolloGameMusicPlayer.1(this, paramInt, paramIRenderRunner, paramLong);
  }
  
  @NotNull
  private MediaPlayer a(IRenderRunner paramIRenderRunner, int paramInt, long paramLong, String paramString)
  {
    MediaPlayer localMediaPlayer = new MediaPlayer();
    synchronized (this.i)
    {
      this.e.add(localMediaPlayer);
      boolean bool = true;
      a(true);
      localMediaPlayer.setDataSource(paramString);
      if (paramInt != 2147483647) {
        bool = false;
      }
      localMediaPlayer.setLooping(bool);
      if (paramInt != 2147483647)
      {
        localMediaPlayer.setOnCompletionListener(a(paramIRenderRunner, paramLong, paramInt));
        if (QLog.isColorLevel())
        {
          paramIRenderRunner = a;
          paramString = new StringBuilder();
          paramString.append("create player, audio_sessionID: ");
          paramString.append(localMediaPlayer.getAudioSessionId());
          QLog.d(paramIRenderRunner, 2, paramString.toString());
        }
      }
      localMediaPlayer.prepare();
      return localMediaPlayer;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    AudioManager localAudioManager = this.c;
    if (localAudioManager == null) {
      return;
    }
    int m;
    if (paramBoolean) {
      m = localAudioManager.requestAudioFocus(this.k, 3, 2);
    } else {
      m = localAudioManager.abandonAudioFocus(this.k);
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "[execAudioFocus], requestFocus:", Boolean.valueOf(paramBoolean), ",ret:", Integer.valueOf(m) });
    }
  }
  
  private void b(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return;
    }
    SharedPreferences localSharedPreferences = this.d;
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo_game_music_switch");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(this.h);
      this.g = localSharedPreferences.getInt(localStringBuilder.toString(), 1);
    }
  }
  
  private MediaPlayer c(int paramInt)
  {
    synchronized (this.i)
    {
      if (this.e != null)
      {
        Iterator localIterator = this.e.iterator();
        while (localIterator.hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
          if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt)) {
            return localMediaPlayer;
          }
        }
      }
      return null;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private MediaPlayer d(int paramInt)
  {
    MediaPlayer localMediaPlayer = this.f;
    if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt)) {
      return this.f;
    }
    return null;
  }
  
  public int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "[getCurPosition], hashCode:", Integer.valueOf(paramInt) });
    }
    MediaPlayer localMediaPlayer = c(paramInt);
    if (localMediaPlayer != null) {
      return localMediaPlayer.getCurrentPosition();
    }
    localMediaPlayer = d(paramInt);
    if (localMediaPlayer != null) {
      return localMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public int a(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "[getMusicSwitch], gameId:", Integer.valueOf(this.h) });
    }
    b(paramAppInterface);
    return this.g;
  }
  
  public int a(IRenderRunner paramIRenderRunner, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3, float paramFloat)
  {
    if (paramIRenderRunner == null) {
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "[playMusic], type:", Integer.valueOf(paramInt1), ",musicPath:", paramString, ",loopCount:", Integer.valueOf(paramInt2), ",gameId", Integer.valueOf(this.h), ",gameId:", Integer.valueOf(this.h), ",pos:", Integer.valueOf(paramInt3), ",volumn,:", Float.valueOf(paramFloat) });
    }
    if ((this.h > 0) && ((this.g == 0) || (!CmGameUtil.g()) || (paramIRenderRunner == null)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "DO NOT play music.");
      }
      return -1;
    }
    if (-1 == paramInt2) {
      paramInt2 = 2147483647;
    }
    label561:
    for (;;)
    {
      try
      {
        if ((paramIRenderRunner instanceof ApolloSurfaceView))
        {
          localObject = ((ApolloSurfaceView)paramIRenderRunner).getRender();
        }
        else
        {
          if (!(paramIRenderRunner instanceof ApolloTextureView)) {
            break label561;
          }
          localObject = ((ApolloTextureView)paramIRenderRunner).getRender();
        }
        if (localObject != null)
        {
          if (URLUtil.isNetworkUrl(paramString))
          {
            localObject = paramString;
            continue;
          }
          localObject = ((ApolloRender)localObject).getRscPath(paramString, "mp3");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new File((String)localObject);
            if (((File)localObject).exists())
            {
              localObject = ((File)localObject).getPath();
              continue;
            }
          }
        }
        Object localObject = null;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramIRenderRunner = a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("music NOT exist.path:");
          ((StringBuilder)localObject).append(paramString);
          QLog.w(paramIRenderRunner, 1, ((StringBuilder)localObject).toString());
          return -1;
        }
        if (paramInt1 == 0)
        {
          paramString = a((String)localObject, paramInt2);
          if (paramString != null)
          {
            if (-1 != paramInt3) {
              paramString.seekTo(paramInt3);
            }
            if (-1.0F != paramFloat) {
              paramString.setVolume(paramFloat, paramFloat);
            }
            ApolloCmdChannel.getInstance().playMusicInner(paramIRenderRunner, paramString.hashCode(), paramLong);
            return paramString.hashCode();
          }
          return -1;
        }
        if (this.h == -10000) {
          c(0, paramString);
        }
        try
        {
          paramString = a(paramIRenderRunner, paramInt2, paramLong, (String)localObject);
          paramString.start();
          if (-1 != paramInt3) {
            paramString.seekTo(paramInt3);
          }
          if (-1.0F != paramFloat) {
            paramString.setVolume(paramFloat, paramFloat);
          }
          ApolloCmdChannel.getInstance().playMusicInner(paramIRenderRunner, paramString.hashCode(), paramLong);
          paramInt1 = paramString.hashCode();
          return paramInt1;
        }
        catch (Throwable paramIRenderRunner)
        {
          QLog.e(a, 1, "prepare - start :", paramIRenderRunner);
          return -1;
        }
        localObject = null;
      }
      catch (Throwable paramIRenderRunner)
      {
        paramString = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[playMusic], errInfo->");
        ((StringBuilder)localObject).append(paramIRenderRunner.getMessage());
        QLog.e(paramString, 1, ((StringBuilder)localObject).toString());
        return -1;
      }
    }
  }
  
  public MediaPlayer a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.f == null) {
          this.f = new MediaPlayer();
        }
        this.f.stop();
        this.f.reset();
        a(true);
        this.f.setDataSource(paramString);
        paramString = this.f;
        if (paramInt != 2147483647) {
          break label100;
        }
        bool = true;
        paramString.setLooping(bool);
        this.f.prepare();
        this.f.start();
      }
      catch (Throwable paramString)
      {
        QLog.e(a, 1, "prepare - start :", paramString);
      }
      return this.f;
      label100:
      boolean bool = false;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "[pauseMusic], gameId:", Integer.valueOf(this.h) });
    }
    this.b.set(true);
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameMusicPlayer", 2, "pauseMusic bMute false");
      }
      a(false);
      synchronized (this.i)
      {
        if (this.e != null)
        {
          Iterator localIterator = this.e.iterator();
          while (localIterator.hasNext())
          {
            MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
            if (localMediaPlayer != null) {
              localMediaPlayer.pause();
            }
          }
        }
        if (this.f != null)
        {
          this.f.pause();
          return;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, "pause error:", localException);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "[seekTo], hashCode:", Integer.valueOf(paramInt1), ",pos:", Integer.valueOf(paramInt2) });
    }
    MediaPlayer localMediaPlayer = c(paramInt1);
    if (localMediaPlayer != null) {
      localMediaPlayer.seekTo(paramInt2);
    }
    localMediaPlayer = d(paramInt1);
    if (localMediaPlayer != null) {
      localMediaPlayer.seekTo(paramInt2);
    }
  }
  
  public void a(int paramInt, AppInterface arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "[setMusicSwitch], sw:", Integer.valueOf(paramInt), ",gameId:", Integer.valueOf(this.h) });
    }
    Object localObject1 = this.d;
    if (localObject1 != null)
    {
      if (??? == null) {
        return;
      }
      this.g = paramInt;
      localObject1 = ((SharedPreferences)localObject1).edit();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("apollo_game_music_switch");
      ((StringBuilder)localObject3).append(???.getCurrentAccountUin());
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(this.h);
      ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject3).toString(), paramInt).commit();
      if (paramInt == 0) {
        synchronized (this.i)
        {
          if (this.e != null)
          {
            localObject1 = this.e.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (MediaPlayer)((Iterator)localObject1).next();
              if (localObject3 != null) {
                ((MediaPlayer)localObject3).reset();
              }
            }
          }
          ??? = this.f;
          if (??? != null)
          {
            ???.reset();
            return;
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "[pauseMusic], path:", ???, ",gameId:", Integer.valueOf(this.h) });
    }
    synchronized (this.i)
    {
      if (this.e != null)
      {
        Iterator localIterator = this.e.iterator();
        while (localIterator.hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
          if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt))
          {
            if (this.e.size() == 1) {
              a(false);
            }
            localMediaPlayer.pause();
            return;
          }
        }
      }
      ??? = this.f;
      if ((??? != null) && (???.hashCode() == paramInt))
      {
        a(false);
        this.f.pause();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public int b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "[getDuration], hashCode:", Integer.valueOf(paramInt) });
    }
    MediaPlayer localMediaPlayer = c(paramInt);
    if (localMediaPlayer != null) {
      return localMediaPlayer.getDuration();
    }
    localMediaPlayer = d(paramInt);
    if (localMediaPlayer != null) {
      return localMediaPlayer.getDuration();
    }
    return 0;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "[resumeMusic], gameId:", Integer.valueOf(this.h) });
    }
    if ((this.g != 0) && (!CmGameUtil.e()) && (!CmGameUtil.f()) && (CmGameUtil.g()))
    {
      this.b.set(false);
      a(true);
      try
      {
        synchronized (this.i)
        {
          if (this.e != null)
          {
            Iterator localIterator = this.e.iterator();
            while (localIterator.hasNext())
            {
              MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
              if (localMediaPlayer != null) {
                localMediaPlayer.start();
              }
            }
          }
          if (this.f != null)
          {
            this.f.start();
            return;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e(a, 1, "resumeMusic error:", localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "DO NOT play music.");
    }
  }
  
  public void b(int paramInt, String arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "[resumeMusic], path:", ???, ",gameId:", Integer.valueOf(this.h) });
    }
    synchronized (this.i)
    {
      if (this.e != null)
      {
        Iterator localIterator = this.e.iterator();
        while (localIterator.hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
          if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt))
          {
            a(true);
            localMediaPlayer.start();
            return;
          }
        }
      }
      ??? = this.f;
      if ((??? != null) && (???.hashCode() == paramInt))
      {
        a(true);
        this.f.start();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "[onDestroy],gameId:", Integer.valueOf(this.h) });
    }
    a(false);
    if (!this.b.get()) {
      this.b.set(false);
    }
    synchronized (this.i)
    {
      if (this.e != null)
      {
        Iterator localIterator = this.e.iterator();
        while (localIterator.hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)localIterator.next();
          if (localMediaPlayer != null)
          {
            localMediaPlayer.stop();
            localMediaPlayer.release();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "stop front music.");
        }
        this.e.clear();
      }
      if (this.f != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "stop back music.");
        }
        this.f.stop();
        this.f.release();
        this.f = null;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void c(int paramInt, String arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, new Object[] { "[stopMusic], path:", ???, ",gameId:", Integer.valueOf(this.h) });
    }
    a(false);
    synchronized (this.i)
    {
      if (this.e != null)
      {
        if (this.h == -10000)
        {
          while (this.e.size() > 0)
          {
            localObject1 = (MediaPlayer)this.e.get(0);
            try
            {
              ((MediaPlayer)localObject1).stop();
            }
            catch (IllegalStateException localIllegalStateException)
            {
              localIllegalStateException.printStackTrace();
            }
            ((MediaPlayer)localObject1).release();
            this.e.remove(localObject1);
          }
          return;
        }
        Object localObject1 = this.e.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          MediaPlayer localMediaPlayer = (MediaPlayer)((Iterator)localObject1).next();
          if ((localMediaPlayer != null) && (localMediaPlayer.hashCode() == paramInt))
          {
            this.e.remove(localMediaPlayer);
            localMediaPlayer.stop();
            localMediaPlayer.release();
            return;
          }
        }
      }
      ??? = this.f;
      if ((??? != null) && (???.hashCode() == paramInt))
      {
        this.f.stop();
        this.f.release();
        this.f = null;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.ApolloGameMusicPlayer
 * JD-Core Version:    0.7.0.1
 */