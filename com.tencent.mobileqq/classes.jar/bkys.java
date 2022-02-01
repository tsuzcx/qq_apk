import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy.MusicPlayerListener;

@ProxyService(proxy=MusicPlayerProxy.class)
public class bkys
  implements MusicPlayerProxy
{
  private static String jdField_a_of_type_JavaLangString;
  private long jdField_a_of_type_Long = -1L;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new bkyt(this);
  private axqq jdField_a_of_type_Axqq = new bkyv(this);
  private axqs jdField_a_of_type_Axqs;
  private MusicPlayerProxy.MusicPlayerListener jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyMusicPlayerProxy$MusicPlayerListener;
  private String b;
  private String c;
  
  private String a()
  {
    if (jdField_a_of_type_JavaLangString == null) {
      jdField_a_of_type_JavaLangString = QQPlayerService.a(8, "MusicPlayerProxyImpl" + this.jdField_b_of_type_JavaLangString);
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  private void a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Axqs == null)
        {
          long l = System.currentTimeMillis();
          if ((this.jdField_a_of_type_Long != -1L) && (l - this.jdField_a_of_type_Long <= 10000L)) {
            continue;
          }
          this.jdField_a_of_type_Long = l;
          Intent localIntent = new Intent(BaseApplication.getContext(), QQPlayerService.class);
          BaseApplication.getContext().bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 33);
          QLog.e("MusicPlayerProxyImpl", 1, "bindQQPlayerService end!");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MusicPlayerProxyImpl", 1, "bindQQPlayerService exception", localThrowable);
        continue;
      }
      finally {}
      return;
      QLog.e("MusicPlayerProxyImpl", 1, "waiting for binding service");
    }
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_a_of_type_Axqs != null)
      {
        BaseApplication.getContext().unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
        this.jdField_a_of_type_Axqs = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MusicPlayerProxyImpl", 1, "unbindQQPlayerService exception", localThrowable);
      }
    }
    finally {}
  }
  
  public com.tencent.qqmini.sdk.launcher.core.model.SongInfo getCurrentSong()
  {
    try
    {
      if (this.jdField_a_of_type_Axqs != null)
      {
        com.tencent.mobileqq.music.SongInfo localSongInfo = this.jdField_a_of_type_Axqs.a();
        com.tencent.qqmini.sdk.launcher.core.model.SongInfo localSongInfo1 = new com.tencent.qqmini.sdk.launcher.core.model.SongInfo();
        localSongInfo1.id = localSongInfo.jdField_a_of_type_Long;
        localSongInfo1.mid = localSongInfo.jdField_a_of_type_JavaLangString;
        localSongInfo1.uin = localSongInfo.jdField_b_of_type_Long;
        localSongInfo1.url = localSongInfo.jdField_b_of_type_JavaLangString;
        localSongInfo1.title = localSongInfo.jdField_c_of_type_JavaLangString;
        localSongInfo1.summary = localSongInfo.jdField_d_of_type_JavaLangString;
        localSongInfo1.coverUrl = localSongInfo.e;
        localSongInfo1.detailUrl = localSongInfo.f;
        localSongInfo1.album = localSongInfo.g;
        localSongInfo1.singer = localSongInfo.h;
        localSongInfo1.singerId = localSongInfo.jdField_c_of_type_Long;
        localSongInfo1.startTime = localSongInfo.jdField_a_of_type_Int;
        localSongInfo1.type = localSongInfo.jdField_b_of_type_Int;
        localSongInfo1.fromMini = localSongInfo.jdField_a_of_type_Boolean;
        localSongInfo1.duration = localSongInfo.jdField_d_of_type_Long;
        return localSongInfo1;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "getCurrentSong exception ", localException);
    }
    return null;
  }
  
  public int getCurrentSongPosition()
  {
    if (this.jdField_a_of_type_Axqs != null) {
      try
      {
        int i = this.jdField_a_of_type_Axqs.d();
        return i;
      }
      catch (Exception localException)
      {
        QLog.e("MusicPlayerProxyImpl", 1, "getCurrentSongPosition exception ", localException);
      }
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (this.jdField_a_of_type_Axqs != null) {
      try
      {
        int i = this.jdField_a_of_type_Axqs.c();
        return i;
      }
      catch (Exception localException)
      {
        QLog.e("MusicPlayerProxyImpl", 1, "getCurrentSongDuration exception ", localException);
      }
    }
    return 0;
  }
  
  public void init(MusicPlayerProxy.MusicPlayerListener paramMusicPlayerListener, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyMusicPlayerProxy$MusicPlayerListener = paramMusicPlayerListener;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    a();
  }
  
  public boolean isInit()
  {
    return this.jdField_a_of_type_Axqs != null;
  }
  
  public boolean isPlaying()
  {
    boolean bool = true;
    try
    {
      StringBuilder localStringBuilder;
      if ((this.jdField_a_of_type_Axqs == null) || (!this.jdField_a_of_type_Axqs.a(a())))
      {
        localStringBuilder = new StringBuilder().append("getBackgroundAudioState: null ");
        if (this.jdField_a_of_type_Axqs != null) {
          break label65;
        }
      }
      label65:
      for (bool = true;; bool = false)
      {
        Log.i("MusicPlayerProxyImpl", bool);
        bool = false;
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "isPlaying exception ", localException);
    }
  }
  
  public void pause()
  {
    try
    {
      if (this.jdField_a_of_type_Axqs != null) {
        this.jdField_a_of_type_Axqs.a();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "pause exception ", localException);
    }
  }
  
  public void resume()
  {
    try
    {
      if (this.jdField_a_of_type_Axqs != null) {
        this.jdField_a_of_type_Axqs.b();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "resume exception ", localException);
    }
  }
  
  public void seekTo(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Axqs != null) {
        this.jdField_a_of_type_Axqs.b(paramInt);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "seekTo exception ", localException);
    }
  }
  
  public void setPlayMode(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_Axqs != null) {
        this.jdField_a_of_type_Axqs.a(paramInt);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "setPlayMode exception ", localException);
    }
  }
  
  public void startPlay(com.tencent.qqmini.sdk.launcher.core.model.SongInfo[] paramArrayOfSongInfo, int paramInt)
  {
    if ((paramArrayOfSongInfo == null) || (paramArrayOfSongInfo.length < 1)) {}
    while (this.jdField_a_of_type_Axqs == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Axqs.a(new Intent(BaseApplication.getContext(), MusicPlayerActivity.class));
      Bundle localBundle = this.jdField_a_of_type_Axqs.a();
      Object localObject = localBundle;
      if (localBundle == null)
      {
        localObject = new Bundle();
        this.jdField_a_of_type_Axqs.a((Bundle)localObject);
      }
      ((Bundle)localObject).putString("KEY_SOURCE_NAME", this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_Axqs.a((Bundle)localObject);
      localObject = new com.tencent.mobileqq.music.SongInfo[paramArrayOfSongInfo.length];
      int i = 0;
      while (i < paramArrayOfSongInfo.length)
      {
        localObject[i] = new com.tencent.mobileqq.music.SongInfo();
        localObject[i].g = paramArrayOfSongInfo[i].album;
        localObject[i].e = paramArrayOfSongInfo[i].coverUrl;
        localObject[i].f = paramArrayOfSongInfo[i].detailUrl;
        localObject[i].jdField_d_of_type_Long = paramArrayOfSongInfo[i].duration;
        localObject[i].jdField_a_of_type_Boolean = paramArrayOfSongInfo[i].fromMini;
        localObject[i].jdField_a_of_type_Long = paramArrayOfSongInfo[i].id;
        localObject[i].jdField_a_of_type_JavaLangString = paramArrayOfSongInfo[i].mid;
        localObject[i].h = paramArrayOfSongInfo[i].singer;
        localObject[i].jdField_c_of_type_Long = paramArrayOfSongInfo[i].singerId;
        localObject[i].jdField_a_of_type_Int = paramArrayOfSongInfo[i].startTime;
        localObject[i].jdField_d_of_type_JavaLangString = paramArrayOfSongInfo[i].summary;
        localObject[i].jdField_c_of_type_JavaLangString = paramArrayOfSongInfo[i].title;
        localObject[i].jdField_b_of_type_Int = paramArrayOfSongInfo[i].type;
        localObject[i].jdField_b_of_type_Long = paramArrayOfSongInfo[i].uin;
        localObject[i].jdField_b_of_type_JavaLangString = paramArrayOfSongInfo[i].url;
        i += 1;
      }
      this.jdField_a_of_type_Axqs.a(100);
      this.jdField_a_of_type_Axqs.a(a(), (com.tencent.mobileqq.music.SongInfo[])localObject, paramInt);
      return;
    }
    catch (Exception paramArrayOfSongInfo)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "startPlay exception ", paramArrayOfSongInfo);
    }
  }
  
  public void stop()
  {
    try
    {
      if (this.jdField_a_of_type_Axqs != null) {
        this.jdField_a_of_type_Axqs.c();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicPlayerProxyImpl", 1, "stop exception ", localException);
    }
  }
  
  public void unInit()
  {
    b();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyMusicPlayerProxy$MusicPlayerListener = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkys
 * JD-Core Version:    0.7.0.1
 */