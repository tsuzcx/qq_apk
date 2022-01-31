import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.cs.cmd0xe59.cmd0xe59.ReqBody;
import tencent.im.cs.cmd0xe59.cmd0xe59.RspBody;
import tencent.im.groupstatus.ImStatus.ImStatusDataPush;
import tencent.im.statsvc.song.StatSvcStatSong.ReqBody;
import tencent.im.statsvc.song.StatSvcStatSong.RspBody;

public class awas
  extends alko
{
  private Friends a;
  
  public awas(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public Handler a()
  {
    return ThreadManager.a();
  }
  
  public atsc a(String paramString)
  {
    atsc localatsc2 = atsk.a(paramString, true);
    atsc localatsc1 = localatsc2;
    if (localatsc2 == null) {
      localatsc1 = atsk.a(paramString, false);
    }
    return localatsc1;
  }
  
  public awaf a()
  {
    return awaf.a();
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = a(paramString);
    } while (paramString == null);
    return Uri.parse(paramString.toString()).getQueryParameter("songmid");
  }
  
  public URL a(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setInstanceFollowRedirects(false);
      paramString.setRequestProperty("Accept-Encoding", "identity");
      paramString.connect();
      if (paramString.getResponseCode() == 302)
      {
        paramString = new URL(paramString.getHeaderField("Location"));
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      QLog.d("OnlineStatusHandler", 1, "redirectShortUrl, ", paramString);
    }
    return null;
  }
  
  public void a(awat paramawat)
  {
    long l = a().a(this.app);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusHandler", 2, new Object[] { "pushMusicStatus curExtStatus:", Long.valueOf(l), ", ", paramawat });
    }
    Object localObject = paramawat;
    if (paramawat == null) {
      localObject = new awat();
    }
    if (l == 1028L)
    {
      paramawat = new StatSvcStatSong.ReqBody();
      paramawat.bool_need_convert.set(((awat)localObject).jdField_a_of_type_Boolean);
      paramawat.uint32_song_type.set(((awat)localObject).jdField_a_of_type_Int);
      paramawat.uint32_remaining_time.set(((awat)localObject).jdField_b_of_type_Int);
      paramawat.uint32_source_type.set(((awat)localObject).jdField_c_of_type_Int);
      paramawat.bytes_song_id.set(ByteStringMicro.copyFromUtf8(((awat)localObject).jdField_a_of_type_JavaLangString));
      paramawat.bytes_song_name.set(ByteStringMicro.copyFromUtf8(((awat)localObject).jdField_b_of_type_JavaLangString));
      paramawat.bytes_singer_name.set(ByteStringMicro.copyFromUtf8(((awat)localObject).jdField_c_of_type_JavaLangString));
      paramawat.bool_pause_flag.set(((awat)localObject).jdField_b_of_type_Boolean);
      paramawat.uint32_song_play_time.set(((awat)localObject).d);
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "StatSvc.SetSong");
      ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
      ((ToServiceMsg)localObject).putWupBuffer(paramawat.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public void a(Friends paramFriends)
  {
    String str = paramFriends.songId;
    if (QLog.isColorLevel()) {
      QLog.e("OnlineStatusHandler", 2, new Object[] { "getMusicLyric, id:", str });
    }
    if (awar.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      QLog.e("OnlineStatusHandler", 1, "getMusicLyric return, getting status");
      return;
    }
    this.a = paramFriends;
    awar.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new atsc(0, 0, null));
    cmd0xe59.ReqBody localReqBody = new cmd0xe59.ReqBody();
    localReqBody.song_id.set(ByteStringMicro.copyFromUtf8(str));
    localReqBody.zip_compress_flag.set(true);
    if (!TextUtils.isEmpty(paramFriends.songName)) {
      localReqBody.song_name.set(ByteStringMicro.copyFromUtf8(paramFriends.songName));
    }
    if (!TextUtils.isEmpty(paramFriends.singerName)) {
      localReqBody.singer_name.set(ByteStringMicro.copyFromUtf8(paramFriends.singerName));
    }
    paramFriends = makeOIDBPkg("OidbSvc.0xe59", 3673, 0, localReqBody.toByteArray());
    paramFriends.getAttributes().put("songId", str);
    sendPbReq(paramFriends);
  }
  
  public void a(MusicInfo paramMusicInfo, int paramInt, boolean paramBoolean, long paramLong)
  {
    if (paramMusicInfo == null)
    {
      a(null);
      return;
    }
    awat localawat = new awat();
    localawat.jdField_a_of_type_Boolean = true;
    localawat.jdField_a_of_type_JavaLangString = paramMusicInfo.jdField_a_of_type_JavaLangString;
    localawat.jdField_b_of_type_JavaLangString = paramMusicInfo.jdField_b_of_type_JavaLangString;
    localawat.jdField_a_of_type_Int = 1;
    if ((paramMusicInfo.jdField_a_of_type_JavaUtilList != null) && (!paramMusicInfo.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localawat.jdField_c_of_type_JavaLangString = ((String)paramMusicInfo.jdField_a_of_type_JavaUtilList.get(0));
    }
    localawat.jdField_b_of_type_Int = paramInt;
    localawat.jdField_c_of_type_Int = awar.a().jdField_a_of_type_Int;
    localawat.jdField_b_of_type_Boolean = paramBoolean;
    localawat.d = ((int)paramLong);
    a(localawat);
  }
  
  public void a(SongInfo paramSongInfo, int paramInt, boolean paramBoolean, long paramLong)
  {
    if (paramSongInfo == null)
    {
      a(null);
      return;
    }
    awat localawat = new awat();
    localawat.jdField_a_of_type_Boolean = false;
    localawat.jdField_a_of_type_JavaLangString = paramSongInfo.jdField_a_of_type_JavaLangString;
    if ((TextUtils.isEmpty(paramSongInfo.jdField_a_of_type_JavaLangString)) || (paramSongInfo.jdField_a_of_type_JavaLangString.equals("0")))
    {
      localawat.jdField_a_of_type_JavaLangString = a(paramSongInfo.f);
      if (TextUtils.isEmpty(localawat.jdField_a_of_type_JavaLangString))
      {
        QLog.d("OnlineStatusHandler", 1, "pushMusicStatus, songMid is null");
        return;
      }
    }
    localawat.jdField_b_of_type_JavaLangString = paramSongInfo.jdField_c_of_type_JavaLangString;
    localawat.jdField_a_of_type_Int = 1;
    if (TextUtils.isEmpty(paramSongInfo.h)) {}
    for (paramSongInfo = paramSongInfo.d;; paramSongInfo = paramSongInfo.h)
    {
      localawat.jdField_c_of_type_JavaLangString = paramSongInfo;
      if (localawat.jdField_c_of_type_JavaLangString == null) {
        localawat.jdField_c_of_type_JavaLangString = "";
      }
      localawat.jdField_b_of_type_Int = paramInt;
      localawat.jdField_c_of_type_Int = awar.a().jdField_a_of_type_Int;
      localawat.jdField_b_of_type_Boolean = paramBoolean;
      localawat.d = ((int)paramLong);
      a(localawat);
      return;
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg != null) {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          return;
        }
        StatSvcStatSong.RspBody localRspBody = new StatSvcStatSong.RspBody();
        localRspBody.mergeFrom((byte[])paramObject);
        int i = localRspBody.error_code.get();
        paramObject = localRspBody.error_msg.get();
        paramFromServiceMsg = "";
        if (localRspBody.bytes_song_id.get() != null) {
          paramFromServiceMsg = localRspBody.bytes_song_id.get().toStringUtf8();
        }
        QLog.d("OnlineStatusHandler", 1, new Object[] { "handlePushMusicStatusRsp, errorCode:", Integer.valueOf(i), " errorMsg:", paramObject, " convertSongId:", paramFromServiceMsg });
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("OnlineStatusHandler", 1, "handlePushMusicStatusRsp, ", paramFromServiceMsg);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("songId", "");
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      Object localObject;
      boolean bool1;
      try
      {
        if ((!paramFromServiceMsg.isSuccess()) || (TextUtils.isEmpty(str)))
        {
          awar.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
          return;
        }
        localObject = new cmd0xe59.RspBody();
        parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
        bool1 = ((cmd0xe59.RspBody)localObject).safe_hit_flag.get();
        int i = ((cmd0xe59.RspBody)localObject).ret.get();
        int j = ((cmd0xe59.RspBody)localObject).sub_ret.get();
        paramObject = ((cmd0xe59.RspBody)localObject).msg.get().toStringUtf8();
        boolean bool2 = ((cmd0xe59.RspBody)localObject).zip_compress_flag.get();
        if ((i != 0) || (bool1)) {
          break label343;
        }
        paramFromServiceMsg = new atsc(0, 0, new ArrayList());
        paramToServiceMsg = paramFromServiceMsg;
        if (((cmd0xe59.RspBody)localObject).song_lyric.has())
        {
          localObject = ((cmd0xe59.RspBody)localObject).song_lyric.get().toByteArray();
          paramToServiceMsg = paramFromServiceMsg;
          if (localObject.length > 0)
          {
            if (!bool2) {
              break label330;
            }
            paramToServiceMsg = new String(ayvr.a((byte[])localObject));
            paramToServiceMsg = a(paramToServiceMsg);
          }
        }
        if (paramToServiceMsg != null) {
          awar.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramToServiceMsg);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("OnlineStatusHandler", 2, new Object[] { "handleGetMusicLyric, ret:", Integer.valueOf(i), " subRet:", Integer.valueOf(j), " errorMsg:", paramObject, " zipFlag:", Boolean.valueOf(bool2), " safeHitFlag:", Boolean.valueOf(bool1) });
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("OnlineStatusHandler", 1, "handleGetMusicLyric", paramToServiceMsg);
        awar.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        return;
      }
      label330:
      paramToServiceMsg = new String((byte[])localObject);
      continue;
      label343:
      awar.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
      if ((bool1) && (this.a != null) && (str.equals(this.a.songId)))
      {
        this.a.songName = "";
        this.a.singerName = "";
      }
    }
  }
  
  public boolean a()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity != null) && ((localBaseActivity instanceof SplashActivity))) {
      return ((SplashActivity)localBaseActivity).a() == MainFragment.d;
    }
    return false;
  }
  
  public void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          return;
        }
        paramFromServiceMsg = new ImStatus.ImStatusDataPush();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = String.valueOf(paramFromServiceMsg.uint64_uin.get());
        int k = paramFromServiceMsg.uint32_music_info_refresh.get();
        if (k == 1)
        {
          paramFromServiceMsg = this.app.a().a();
          i = j;
          if (paramObject != null)
          {
            if (paramObject.equals(paramFromServiceMsg)) {
              break label222;
            }
            i = j;
            if (paramObject.equals(this.app.getCurrentAccountUin())) {
              break label222;
            }
          }
          boolean bool = a();
          if ((i != 0) || (bool)) {
            a().postDelayed(new OnlineStatusHandler.1(this, paramObject), 500L);
          }
          QLog.d("OnlineStatusHandler", 1, new Object[] { "handleRecvMusicStatusPush, uin:", bdje.e(paramObject), " currentChatUin:", bdje.e(paramFromServiceMsg), " needRefresh:", Integer.valueOf(k), " isContactShown:", Boolean.valueOf(bool) });
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("OnlineStatusHandler", 1, "handlePushMusicStatusRsp, ", paramFromServiceMsg);
      }
      return;
      label222:
      int i = 1;
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("StatSvc.SetSong");
      this.allowCmdSet.add("ImStatus.ReqPushStatus");
      this.allowCmdSet.add("OidbSvc.0xe59");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends alkr> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      return;
      str = paramFromServiceMsg.getServiceCmd();
      if ((msgCmdFilter(str)) && (QLog.isColorLevel())) {
        QLog.d("OnlineStatusHandler", 2, "onReceive, msgCmdFilter is true,cmd  = " + str);
      }
      if ("StatSvc.SetSong".equals(str))
      {
        a(paramFromServiceMsg, paramObject);
        return;
      }
      if ("ImStatus.ReqPushStatus".equals(str))
      {
        b(paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xe59".equals(str));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awas
 * JD-Core Version:    0.7.0.1
 */