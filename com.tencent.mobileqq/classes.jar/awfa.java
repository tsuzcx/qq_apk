import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime.Status;
import tencent.im.statsvc.song.StatSvcStatSong.SongInfo;

public class awfa
  implements Handler.Callback, aurc
{
  private static awfa jdField_a_of_type_Awfa;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public ConcurrentHashMap<String, atwl> a;
  
  public awfa()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    QQPlayerService.b(this);
    a(null);
  }
  
  public static awfa a()
  {
    if (jdField_a_of_type_Awfa == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Awfa == null) {
        jdField_a_of_type_Awfa = new awfa();
      }
      return jdField_a_of_type_Awfa;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Friends paramFriends, TextView paramTextView)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getResources();
    if ((!TextUtils.isEmpty(paramFriends.songName)) && (System.currentTimeMillis() < paramFriends.songEndTime))
    {
      if (!TextUtils.isEmpty(paramFriends.singerName))
      {
        paramQQAppInterface = String.format(paramQQAppInterface.getString(2131698757), new Object[] { paramFriends.songName, paramFriends.singerName });
        if (!(paramTextView instanceof OnlineStatusLyricView)) {
          break label152;
        }
        ((awfb)blqh.a().getBusinessHandler(174)).a(paramFriends);
        ((OnlineStatusLyricView)paramTextView).setFriendSession(paramFriends, paramQQAppInterface);
      }
      for (;;)
      {
        azqs.b(null, "dc00898", "", "", "0X800AC92", "0X800AC92", paramFriends.songSourceType, 0, "", "0", "0", "");
        return paramQQAppInterface;
        paramQQAppInterface = String.format(paramQQAppInterface.getString(2131698758), new Object[] { paramFriends.songName });
        break;
        label152:
        paramQQAppInterface = aogl.a(paramTextView.getPaint(), paramQQAppInterface, bdoo.a(200.0F));
      }
    }
    return paramQQAppInterface.getString(2131698759);
  }
  
  public static void a()
  {
    BaseApplicationImpl.getContext().getSharedPreferences("online_music_status", 0).edit().putBoolean("has_set_online_music", true).apply();
  }
  
  public static void a(Friends paramFriends, byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length > 0)
      {
        StatSvcStatSong.SongInfo localSongInfo = new StatSvcStatSong.SongInfo();
        localSongInfo.mergeFrom(paramArrayOfByte);
        paramFriends.songId = localSongInfo.bytes_song_id.get().toStringUtf8();
        paramFriends.songName = localSongInfo.bytes_song_name.get().toStringUtf8();
        paramFriends.singerName = localSongInfo.bytes_singer_name.get().toStringUtf8();
        paramFriends.songEndTime = localSongInfo.uint64_end_time.get();
        paramFriends.songSourceType = localSongInfo.uint32_source_type.get();
        paramFriends.songPauseRemainTime = localSongInfo.uint32_pause_remaining_time.get();
        paramFriends.songDuration = localSongInfo.uint32_song_play_time.get();
        if (QLog.isColorLevel()) {
          QLog.d("OnlineMusicStatusManager", 2, new Object[] { "update onlineSongState from ", paramString, ", uin:", bdnn.e(paramFriends.uin), " songId:", paramFriends.songId, " songName:", paramFriends.songName, " songEndTime:", Long.valueOf(paramFriends.songEndTime), " source:", Integer.valueOf(paramFriends.songSourceType), " pauseRemain:", Integer.valueOf(paramFriends.songPauseRemainTime), " duration:", Integer.valueOf(paramFriends.songDuration), " remainTime:", Long.valueOf(paramFriends.songEndTime - System.currentTimeMillis()) });
        }
      }
      else
      {
        paramFriends.songId = "";
        paramFriends.songName = "";
        paramFriends.singerName = "";
        paramFriends.songEndTime = 0L;
        paramFriends.songSourceType = 0;
        paramFriends.songPauseRemainTime = 0;
        paramFriends.songDuration = 0;
        return;
      }
    }
    catch (Exception paramFriends)
    {
      QLog.d("OnlineMusicStatusManager", 1, "parseFriendMusicInfo fail", paramFriends);
    }
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("online_music_status", 0).getBoolean("has_set_online_music", false);
  }
  
  public aweo a()
  {
    return aweo.a();
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)blqh.a();
  }
  
  public String a()
  {
    return QQPlayerService.a();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 3000L);
    }
    do
    {
      do
      {
        return;
        if (paramInt == 8)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
          return;
        }
        if ((paramInt != 4) && (paramInt != 5)) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      } while (paramInt != 4);
      this.jdField_a_of_type_Int = 0;
      return;
    } while (paramInt != 3);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 1, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    QLog.d("OnlineMusicStatusManager", 1, new Object[] { "handleOnlineStatusChanged, ", Long.valueOf(paramLong1), "->", Long.valueOf(paramLong2) });
    if ((paramLong1 == 1028L) && (paramLong2 != 1028L)) {}
    do
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      do
      {
        return;
      } while ((paramLong1 == 1028L) || (paramLong2 != 1028L));
      if (b())
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 3000L);
        return;
      }
    } while (!c());
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 3000L);
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      QLog.d("OnlineMusicStatusManager", 1, "openH5 fail");
      return;
    }
    paramString = "https://i.y.qq.com/v8/playsong.html?songmid=".concat(paramString);
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramActivity.startActivity(localIntent);
    azqs.b(null, "dc00898", "", "", "0X800ABB2", "0X800ABB2", 0, 0, "", "0", "0", "");
  }
  
  public void a(Handler paramHandler)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler = paramHandler;
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public boolean a(Activity paramActivity, SessionInfo paramSessionInfo)
  {
    if (a(a(), paramSessionInfo.a))
    {
      paramSessionInfo = ((alto)a().getManager(51)).e(paramSessionInfo.a);
      if ((paramSessionInfo != null) && (!TextUtils.isEmpty(paramSessionInfo.songId))) {
        a(paramActivity, paramSessionInfo.songId);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((alto)paramQQAppInterface.getManager(51)).e(paramString);
    return (paramQQAppInterface != null) && (a().a(AppRuntime.Status.online, paramQQAppInterface.uExtOnlineStatus).a == 1028L);
  }
  
  public boolean b()
  {
    return (QQMusicPlayService.a()) && (QQMusicPlayService.a() != null);
  }
  
  public boolean c()
  {
    return (QQPlayerService.a()) && (QQPlayerService.b() != null);
  }
  
  public String getToken()
  {
    return getClass().getName();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      ((awfb)a().a(174)).a(null);
      return false;
    case 2: 
      localawfb = (awfb)a().a(174);
      localObject = (MusicInfo)QQMusicPlayService.a();
      int j = QQMusicPlayService.a() - QQMusicPlayService.b();
      ListenTogetherManager localListenTogetherManager = (ListenTogetherManager)a().getManager(331);
      if (localListenTogetherManager.a() != null)
      {
        if (localListenTogetherManager.a().e == 1)
        {
          i = 3;
          this.jdField_a_of_type_Int = i;
        }
      }
      else {
        if (paramMessage.arg1 != 1) {
          break label169;
        }
      }
      label169:
      for (bool = true;; bool = false)
      {
        localawfb.a((MusicInfo)localObject, j, bool, QQMusicPlayService.a());
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, j);
        return false;
        i = 2;
        break;
      }
    }
    int i = QQPlayerService.d() - QQPlayerService.f();
    awfb localawfb = (awfb)a().a(174);
    Object localObject = QQPlayerService.b();
    if (paramMessage.arg1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localawfb.a((SongInfo)localObject, i, bool, QQPlayerService.d());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, i);
      return false;
    }
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    Object localObject = a();
    QLog.d("OnlineMusicStatusManager", 1, new Object[] { "onPlayStateChanged, playState:", Integer.valueOf(paramInt), " token:", localObject });
    if ((localObject != null) && ((((String)localObject).startsWith("music_gene_")) || (((String)localObject).startsWith("aio_"))))
    {
      if (paramInt != 2) {
        break label88;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 3000L);
    }
    label88:
    do
    {
      do
      {
        return;
        if (paramInt == 8)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
          return;
        }
        if ((paramInt != 4) && (paramInt != 5) && (paramInt != 7)) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      } while (paramInt != 4);
      this.jdField_a_of_type_Int = 0;
      return;
    } while (paramInt != 3);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, 1, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awfa
 * JD-Core Version:    0.7.0.1
 */