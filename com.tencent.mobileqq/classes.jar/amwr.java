import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
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

public class amwr
  implements amxf
{
  public static String a;
  private int jdField_a_of_type_Int = 1;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new amwt(this);
  AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<MediaPlayer> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "cmgame_process.ApolloGameMusicPlayer";
  }
  
  public amwr(AppInterface paramAppInterface, int paramInt)
  {
    if (BaseApplicationImpl.sProcessId != 1) {
      i = 4;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", i);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.b = paramInt;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
    a(paramAppInterface);
  }
  
  private MediaPlayer a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
  }
  
  private void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {}
    while (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("apollo_game_music_switch" + paramAppInterface.getCurrentAccountUin() + "_" + this.b, 1);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {}
      for (int i = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2); QLog.isColorLevel(); i = this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[execAudioFocus], requestFocus:", Boolean.valueOf(paramBoolean), ",ret:", Integer.valueOf(i) });
        return;
      }
    }
  }
  
  private MediaPlayer b(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.hashCode() == paramInt)) {
      return this.jdField_a_of_type_AndroidMediaMediaPlayer;
    }
    return null;
  }
  
  public int a(int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[getCurPosition], hashCode:", Integer.valueOf(paramInt) });
    }
    MediaPlayer localMediaPlayer = a(paramInt);
    if (localMediaPlayer != null) {
      paramInt = localMediaPlayer.getCurrentPosition();
    }
    do
    {
      return paramInt;
      localMediaPlayer = b(paramInt);
      paramInt = i;
    } while (localMediaPlayer == null);
    return localMediaPlayer.getCurrentPosition();
  }
  
  public int a(amqs paramamqs, int paramInt1, int paramInt2, String paramString, long paramLong, int paramInt3, float paramFloat)
  {
    if (paramamqs == null) {
      return -1;
    }
    Object localObject1 = a();
    if (localObject1 == null) {
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[playMusic], type:", Integer.valueOf(paramInt1), ",musicPath:", paramString, ",loopCount:", Integer.valueOf(paramInt2), ",gameId", Integer.valueOf(this.b), ",gameId:", Integer.valueOf(this.b), ",pos:", Integer.valueOf(paramInt3), ",volumn,:", Float.valueOf(paramFloat) });
    }
    if ((this.b > 0) && ((this.jdField_a_of_type_Int == 0) || (localObject1 == null) || (!amwn.d()) || (paramamqs == null)))
    {
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
      label286:
      label684:
      for (localObject1 = null;; localObject1 = null)
      {
        boolean bool;
        try
        {
          if ((paramamqs instanceof ApolloSurfaceView))
          {
            localObject1 = ((ApolloSurfaceView)paramamqs).getRender();
            if (localObject1 == null) {
              continue;
            }
            bool = URLUtil.isNetworkUrl(paramString);
            if (!bool) {
              break label286;
            }
          }
          for (localObject1 = paramString;; localObject1 = ((File)localObject1).getPath())
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              break label368;
            }
            QLog.w(jdField_a_of_type_JavaLangString, 1, "music NOT exist.path:" + paramString);
            return -1;
            if (!(paramamqs instanceof ApolloTextureView)) {
              break;
            }
            localObject1 = ((ApolloTextureView)paramamqs).getRender();
            break;
            localObject1 = ((ApolloRender)localObject1).getRscPath(paramString, "mp3");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label684;
            }
            localObject1 = new File((String)localObject1);
            if (!((File)localObject1).exists()) {
              break label684;
            }
          }
          if (paramInt1 != 0) {
            break label448;
          }
        }
        catch (Throwable paramamqs)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[playMusic], errInfo->" + paramamqs.getMessage());
          return -1;
        }
        label368:
        paramString = a((String)localObject1, paramInt2);
        if (paramString != null)
        {
          if (-1 != paramInt3) {
            paramString.seekTo(paramInt3);
          }
          if (-1.0F != paramFloat) {
            paramString.setVolume(paramFloat, paramFloat);
          }
          localObject1 = amwn.a();
          if (localObject1 != null) {
            ((ApolloCmdChannel)localObject1).playMusicInner(paramamqs, paramString.hashCode(), paramLong);
          }
          return paramString.hashCode();
        }
        return -1;
        label448:
        if (this.b == -10000) {
          c(0, paramString);
        }
        for (;;)
        {
          try
          {
            paramString = new MediaPlayer();
            synchronized (this.jdField_a_of_type_JavaLangObject)
            {
              this.jdField_a_of_type_JavaUtilList.add(paramString);
              a(true);
              paramString.setDataSource((String)localObject1);
              if (paramInt2 == 2147483647)
              {
                bool = true;
                paramString.setLooping(bool);
                if (paramInt2 != 2147483647)
                {
                  paramString.setOnCompletionListener(new amws(this, paramInt2, paramamqs, paramLong));
                  if (QLog.isColorLevel()) {
                    QLog.d(jdField_a_of_type_JavaLangString, 2, "create player, audio_sessionID: " + paramString.getAudioSessionId());
                  }
                }
                paramString.prepare();
                paramString.start();
                if (-1 != paramInt3) {
                  paramString.seekTo(paramInt3);
                }
                if (-1.0F != paramFloat) {
                  paramString.setVolume(paramFloat, paramFloat);
                }
                localObject1 = amwn.a();
                if (localObject1 != null) {
                  ((ApolloCmdChannel)localObject1).playMusicInner(paramamqs, paramString.hashCode(), paramLong);
                }
                paramInt1 = paramString.hashCode();
                return paramInt1;
              }
            }
            bool = false;
          }
          catch (Throwable paramamqs)
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "prepare - start :", paramamqs);
            return -1;
          }
        }
      }
    }
  }
  
  public int a(AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[getMusicSwitch], gameId:", Integer.valueOf(this.b) });
    }
    a(paramAppInterface);
    return this.jdField_a_of_type_Int;
  }
  
  public MediaPlayer a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        a(true);
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
        a(false);
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
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[seekTo], hashCode:", Integer.valueOf(paramInt1), ",pos:", Integer.valueOf(paramInt2) });
    }
    MediaPlayer localMediaPlayer = a(paramInt1);
    if (localMediaPlayer != null) {
      localMediaPlayer.seekTo(paramInt2);
    }
    localMediaPlayer = b(paramInt1);
    if (localMediaPlayer != null) {
      localMediaPlayer.seekTo(paramInt2);
    }
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
        this.jdField_a_of_type_Int = paramInt;
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
              a(false);
            }
            localMediaPlayer.pause();
            return;
          }
        }
      }
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.hashCode() == paramInt))
      {
        a(false);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
        return;
      }
    }
  }
  
  public int b(int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[getDuration], hashCode:", Integer.valueOf(paramInt) });
    }
    MediaPlayer localMediaPlayer = a(paramInt);
    if (localMediaPlayer != null) {
      paramInt = localMediaPlayer.getDuration();
    }
    do
    {
      return paramInt;
      localMediaPlayer = b(paramInt);
      paramInt = i;
    } while (localMediaPlayer == null);
    return localMediaPlayer.getDuration();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[resumeMusic], gameId:", Integer.valueOf(this.b) });
    }
    if ((this.jdField_a_of_type_Int == 0) || (amwn.b()) || (amwn.c()) || (!amwn.d())) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "DO NOT play music.");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      a(true);
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
            a(true);
            localMediaPlayer.start();
            return;
          }
        }
      }
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.hashCode() == paramInt))
      {
        a(true);
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
    a(false);
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label144;
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
    label144:
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
    a(false);
    for (;;)
    {
      MediaPlayer localMediaPlayer1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label206;
        }
        if (this.b != -10000) {
          break label137;
        }
        if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
          break label134;
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
    label134:
    return;
    label137:
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      MediaPlayer localMediaPlayer2 = (MediaPlayer)localIterator.next();
      if ((localMediaPlayer2 != null) && (localMediaPlayer2.hashCode() == paramInt))
      {
        this.jdField_a_of_type_JavaUtilList.remove(localMediaPlayer2);
        localMediaPlayer2.stop();
        localMediaPlayer2.release();
        return;
      }
    }
    label206:
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.hashCode() == paramInt))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwr
 * JD-Core Version:    0.7.0.1
 */