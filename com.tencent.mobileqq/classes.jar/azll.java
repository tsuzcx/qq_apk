import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler.1;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler.2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
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
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime.Status;
import tencent.im.cs.cmd0xe59.cmd0xe59.ReqBody;
import tencent.im.cs.cmd0xe59.cmd0xe59.RspBody;
import tencent.im.groupstatus.ImStatus.ImStatusDataPush;
import tencent.im.oidb.cmd0xe62.ReqBody;
import tencent.im.statsvc.business.info.businessinfo.ReqBody;
import tencent.im.statsvc.business.info.businessinfo.RspBody;
import tencent.im.statsvc.song.StatSvcStatSong.ReqBody;
import tencent.im.statsvc.song.StatSvcStatSong.RspBody;

public class azll
  extends anud
{
  private Friends a;
  
  public azll(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      int i;
      try
      {
        paramFromServiceMsg = new businessinfo.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = paramFromServiceMsg.uint32_error_code.get();
        paramObject = paramFromServiceMsg.string_error_msg.get();
        int j = paramFromServiceMsg.uint32_interval.get();
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetExtBusinessInfo,errorCode  = ", Integer.valueOf(i), " errorMsg=", paramObject, " interval=", Integer.valueOf(j) });
        }
        if (i != 0) {
          break label301;
        }
        paramFromServiceMsg = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramToServiceMsg.getAttribute("online_status_permission_item");
        if (paramFromServiceMsg != null) {
          ((azih)this.mApp.getManager(370)).a(new OnlineStatusFriendsPermissionItem(paramFromServiceMsg.isAllHasPermission(), paramFromServiceMsg.getPermissionUins()));
        }
        int k = paramToServiceMsg.extraData.getInt("StatusId");
        if (((Boolean)paramToServiceMsg.getAttribute("from_need_update_delay_time", Boolean.valueOf(false))).booleanValue())
        {
          paramFromServiceMsg = (azic)this.mApp.getManager(369);
          paramFromServiceMsg.a(k, j);
          paramFromServiceMsg.a().a(k, NetConnInfoCenter.getServerTime());
        }
        bool1 = ((Boolean)paramToServiceMsg.getAttribute("from_register", Boolean.valueOf(false))).booleanValue();
        boolean bool2 = ((Boolean)paramToServiceMsg.getAttribute("from_modify", Boolean.valueOf(false))).booleanValue();
        if ((bool1) || (bool2)) {
          break label301;
        }
        this.app.a(AppRuntime.Status.online, k);
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      notifyUI(7, bool1, paramToServiceMsg.extraData);
      return;
      boolean bool1 = false;
      continue;
      label301:
      if (i == 0) {
        bool1 = true;
      }
    }
  }
  
  private void c(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      paramFromServiceMsg = new businessinfo.RspBody();
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      int i = paramFromServiceMsg.uint32_error_code.get();
      paramObject = paramFromServiceMsg.string_error_msg.get();
      int j = paramFromServiceMsg.uint32_interval.get();
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetBatteryBusinessInfo,errorCode  = ", Integer.valueOf(i), " errorMsg=", paramObject, " interval=", Integer.valueOf(j) });
      }
      if (i == 0) {}
      return;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      int i;
      try
      {
        paramFromServiceMsg = new businessinfo.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = paramFromServiceMsg.uint32_error_code.get();
        paramObject = paramFromServiceMsg.string_error_msg.get();
        int j = paramFromServiceMsg.uint32_interval.get();
        long l = ((Integer)paramToServiceMsg.getAttribute("StatusId", Integer.valueOf(0))).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetLocationBusinessInfo,errorCode  = ", Integer.valueOf(i), " errorMsg=", paramObject, " interval=", Integer.valueOf(j), " id=", Long.valueOf(l) });
        }
        if (i == 0)
        {
          paramToServiceMsg = (azic)this.mApp.getManager(369);
          if (l > 40000L)
          {
            paramToServiceMsg.a().b(40000, j);
            break label221;
            notifyUI(3, bool, null);
          }
          else
          {
            paramToServiceMsg.a(l, j);
            paramToServiceMsg.a().a((int)l, NetConnInfoCenter.getServerTime());
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      label221:
      while (i != 0)
      {
        bool = false;
        break;
      }
      boolean bool = true;
    }
  }
  
  private void d(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = (SvcRespRegister)paramObject;
      long l1 = paramObject.timeStamp;
      byte b = paramObject.cReplyCode;
      long l2 = paramObject.iStatus;
      long l3 = paramObject.uExtOnlineStatus;
      long l4 = paramObject.uClientAutoStatusInterval;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusHandler", 2, new Object[] { "[status][autoMgr] handleRecvSetOnlineStatus timeStamp:", Long.valueOf(l1), " cCode:", Byte.valueOf(b), " iStatus:", Long.valueOf(l2), " extOnlineStatus:", Long.valueOf(l3), " autoStatusInterval: ", Long.valueOf(l4) });
      }
      if (b == 0)
      {
        localBundle.putLong("onlineStatus", l2);
        localBundle.putLong("extStatus", l3);
        localBundle.putLong("autoStatusInterval", l4);
        this.mApp.setOnlineStatus(AppRuntime.Status.build((int)l2));
        this.mApp.setExtOnlineStatus(l3);
        ((azic)this.mApp.getManager(369)).c();
        notifyUI(1, true, localBundle);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetOnlineStatus res:", Boolean.valueOf(paramFromServiceMsg.isSuccess()) });
    }
    notifyUI(1, false, localBundle);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      int i;
      try
      {
        paramFromServiceMsg = new businessinfo.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = paramFromServiceMsg.uint32_error_code.get();
        paramObject = paramFromServiceMsg.string_error_msg.get();
        int j = paramFromServiceMsg.uint32_interval.get();
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetLocationBusinessInfo,errorCode  = ", Integer.valueOf(i), " errorMsg=", paramObject, " interval=", Integer.valueOf(j) });
        }
        if (i == 0)
        {
          paramFromServiceMsg = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramToServiceMsg.getAttribute("online_status_permission_item");
          if (paramFromServiceMsg != null) {
            ((azih)this.mApp.getManager(370)).a(new OnlineStatusFriendsPermissionItem(paramFromServiceMsg.isAllHasPermission(), paramFromServiceMsg.getPermissionUins()));
          }
          ((azic)this.mApp.getManager(369)).a(-1L, j);
          if (!((Boolean)paramToServiceMsg.getAttribute("from_register", Boolean.valueOf(false))).booleanValue())
          {
            this.app.a(AppRuntime.Status.online, -1L);
            break label244;
            notifyUI(2, bool, null);
          }
        }
        else
        {
          this.app.runOnUiThread(new OnlineStatusHandler.1(this));
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      label244:
      while (i != 0)
      {
        bool = false;
        break;
      }
      boolean bool = true;
    }
  }
  
  public Handler a()
  {
    return ThreadManager.getSubThreadHandler();
  }
  
  public awwm a(String paramString)
  {
    awwm localawwm2 = awwu.a(paramString, true);
    awwm localawwm1 = localawwm2;
    if (localawwm2 == null) {
      localawwm1 = awwu.a(paramString, false);
    }
    return localawwm1;
  }
  
  public azhq a()
  {
    return azhq.a();
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
  
  public void a(int paramInt, Bundle paramBundle)
  {
    int i = 1000;
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "StatSvc.SyncBusinessInfo");
    businessinfo.ReqBody localReqBody = new businessinfo.ReqBody();
    int j = paramBundle.getInt("StatusId", 0);
    switch (paramInt)
    {
    default: 
      QLog.w("OnlineStatusHandler", 1, "error type:" + paramInt);
      return;
    case 1: 
      j = paramBundle.getInt("BatteryInfo", 0);
      localReqBody.int32_battery_status.set(j);
      localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
      localReqBody.uint32_ext_status.set(1000);
    }
    for (;;)
    {
      localToServiceMsg.addAttribute("StatusId", Integer.valueOf(i));
      localToServiceMsg.addAttribute("business_type", Integer.valueOf(paramInt));
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      sendPbReq(localToServiceMsg);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("OnlineStatusHandler", 2, new Object[] { "requestSynBusinessInfo type:", Integer.valueOf(paramInt) });
      return;
      paramBundle = paramBundle.getByteArray("LocationInfo");
      localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
      localReqBody.uint32_ext_status.set(-1);
      localReqBody.bytes_business_info.set(ByteStringMicro.copyFrom(paramBundle));
      paramBundle = new cmd0xe62.ReqBody();
      localReqBody.private_info.set(paramBundle);
      i = -1;
      continue;
      paramBundle = paramBundle.getByteArray("ExtInfo");
      localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
      localReqBody.uint32_ext_status.set(j);
      localReqBody.bytes_business_info.set(ByteStringMicro.copyFrom(paramBundle));
      paramBundle = new cmd0xe62.ReqBody();
      localReqBody.private_info.set(paramBundle);
      i = j;
    }
  }
  
  public void a(int paramInt, Bundle paramBundle, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "StatSvc.SetBusinessInfo");
    businessinfo.ReqBody localReqBody = new businessinfo.ReqBody();
    PBUInt32Field localPBUInt32Field;
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        for (;;)
        {
          localToServiceMsg.addAttribute("from_modify", Boolean.valueOf(paramBundle.getBoolean("from_modify", false)));
          localToServiceMsg.addAttribute("from_register", Boolean.valueOf(paramBundle.getBoolean("from_register", false)));
          localToServiceMsg.addAttribute("from_need_update_delay_time", Boolean.valueOf(paramBundle.getBoolean("from_need_update_delay_time", false)));
          localToServiceMsg.addAttribute("business_type", Integer.valueOf(paramInt));
          localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
          sendPbReq(localToServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusHandler", 2, new Object[] { "requestSetBusinessInfo type:", Integer.valueOf(paramInt) });
          }
          return;
          i = paramBundle.getInt("BatteryInfo", 0);
          localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
          localReqBody.uint32_ext_status.set(1000);
          localReqBody.int32_battery_status.set(i);
        }
        localObject = paramBundle.getByteArray("LocationInfo");
        localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
        localReqBody.uint32_ext_status.set(-1);
        localReqBody.bytes_business_info.set(ByteStringMicro.copyFrom((byte[])localObject));
      } while (paramOnlineStatusPermissionItem == null);
      localObject = new cmd0xe62.ReqBody();
      localPBUInt32Field = ((cmd0xe62.ReqBody)localObject).set_type;
      if (paramOnlineStatusPermissionItem.isAllHasPermission()) {}
      for (i = 1;; i = 2)
      {
        localPBUInt32Field.set(i);
        if (paramOnlineStatusPermissionItem.getPermissionUins() != null) {
          ((cmd0xe62.ReqBody)localObject).rpt_uint64_uin.set(paramOnlineStatusPermissionItem.getPermissionUins());
        }
        localReqBody.private_info.set((MessageMicro)localObject);
        localToServiceMsg.addAttribute("online_status_permission_item", paramOnlineStatusPermissionItem);
        break;
      }
    }
    Object localObject = paramBundle.getByteArray("ExtInfo");
    int j = paramBundle.getInt("StatusId");
    localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
    localReqBody.uint32_ext_status.set(j);
    localReqBody.bytes_business_info.set(ByteStringMicro.copyFrom((byte[])localObject));
    if (paramOnlineStatusPermissionItem != null)
    {
      localObject = new cmd0xe62.ReqBody();
      localPBUInt32Field = ((cmd0xe62.ReqBody)localObject).set_type;
      if (!paramOnlineStatusPermissionItem.isAllHasPermission()) {
        break label537;
      }
    }
    label537:
    for (int i = 1;; i = 2)
    {
      localPBUInt32Field.set(i);
      if (paramOnlineStatusPermissionItem.getPermissionUins() != null) {
        ((cmd0xe62.ReqBody)localObject).rpt_uint64_uin.set(paramOnlineStatusPermissionItem.getPermissionUins());
      }
      localReqBody.private_info.set((MessageMicro)localObject);
      localToServiceMsg.addAttribute("online_status_permission_item", paramOnlineStatusPermissionItem);
      localToServiceMsg.extraData.putAll(paramBundle);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("OnlineStatusHandler", 2, new Object[] { "requestSetBusinessInfo: invoked. ", " statusId: ", Integer.valueOf(j), " onlinePermission: ", paramOnlineStatusPermissionItem });
      break;
    }
  }
  
  public void a(azlm paramazlm)
  {
    long l = a().a(this.app);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusHandler", 2, new Object[] { "pushMusicStatus curExtStatus:", Long.valueOf(l), ", ", paramazlm });
    }
    Object localObject = paramazlm;
    if (paramazlm == null) {
      localObject = new azlm();
    }
    if (l == 1028L)
    {
      paramazlm = new StatSvcStatSong.ReqBody();
      paramazlm.bool_need_convert.set(((azlm)localObject).jdField_a_of_type_Boolean);
      paramazlm.uint32_song_type.set(((azlm)localObject).jdField_a_of_type_Int);
      paramazlm.uint32_remaining_time.set(((azlm)localObject).jdField_b_of_type_Int);
      paramazlm.uint32_source_type.set(((azlm)localObject).jdField_c_of_type_Int);
      paramazlm.bytes_song_id.set(ByteStringMicro.copyFromUtf8(((azlm)localObject).jdField_a_of_type_JavaLangString));
      paramazlm.bytes_song_name.set(ByteStringMicro.copyFromUtf8(((azlm)localObject).jdField_b_of_type_JavaLangString));
      paramazlm.bytes_singer_name.set(ByteStringMicro.copyFromUtf8(((azlm)localObject).jdField_c_of_type_JavaLangString));
      paramazlm.bool_pause_flag.set(((azlm)localObject).jdField_b_of_type_Boolean);
      paramazlm.uint32_song_play_time.set(((azlm)localObject).d);
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "StatSvc.SetSong");
      ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
      ((ToServiceMsg)localObject).putWupBuffer(paramazlm.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, AppRuntime.Status paramStatus, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusHandler", 2, new Object[] { "requestSetOnlineStatus onlineStatus:", paramStatus, " extStatus:", Long.valueOf(paramLong1), " largeSeq:", Long.valueOf(paramLong2), " isAutoSet: " + paramBoolean });
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), "StatSvc.SetStatusFromClient");
    Bundle localBundle = localToServiceMsg.extraData;
    localBundle.putLong("K_SEQ", paramLong2);
    localBundle.putSerializable("onlineStatus", paramStatus);
    localBundle.putLong("extOnlineStatus", paramLong1);
    if ((paramStatus == AppRuntime.Status.online) && (paramLong1 == 1000L)) {}
    try
    {
      if (paramQQAppInterface.getExtOnlineStatus() != 1000L) {
        paramQQAppInterface.setPowerConnect(azhq.c());
      }
      localBundle.putInt("batteryCapacity", paramQQAppInterface.getBatteryCapacity());
      localBundle.putInt("powerConnect", paramQQAppInterface.getPowerConnect());
      localBundle.putBoolean("isAutoSet", paramBoolean);
      send(localToServiceMsg);
      return;
    }
    catch (Throwable paramStatus)
    {
      for (;;)
      {
        QLog.e("OnlineStatusHandler", 1, "setOnlineStatus t:", paramStatus);
      }
    }
  }
  
  public void a(Friends paramFriends)
  {
    String str = paramFriends.songId;
    if (QLog.isColorLevel()) {
      QLog.e("OnlineStatusHandler", 2, new Object[] { "getMusicLyric, id:", str });
    }
    if (azlk.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      QLog.e("OnlineStatusHandler", 1, "getMusicLyric return, getting status");
      return;
    }
    this.a = paramFriends;
    azlk.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new awwm(0, 0, null));
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
    azlm localazlm = new azlm();
    localazlm.jdField_a_of_type_Boolean = true;
    localazlm.jdField_a_of_type_JavaLangString = paramMusicInfo.jdField_a_of_type_JavaLangString;
    localazlm.jdField_b_of_type_JavaLangString = paramMusicInfo.jdField_b_of_type_JavaLangString;
    localazlm.jdField_a_of_type_Int = 1;
    if ((paramMusicInfo.jdField_a_of_type_JavaUtilList != null) && (!paramMusicInfo.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localazlm.jdField_c_of_type_JavaLangString = ((String)paramMusicInfo.jdField_a_of_type_JavaUtilList.get(0));
    }
    localazlm.jdField_b_of_type_Int = paramInt;
    localazlm.jdField_c_of_type_Int = azlk.a().jdField_a_of_type_Int;
    localazlm.jdField_b_of_type_Boolean = paramBoolean;
    localazlm.d = ((int)paramLong);
    a(localazlm);
  }
  
  public void a(SongInfo paramSongInfo, int paramInt, boolean paramBoolean, long paramLong)
  {
    if (paramSongInfo == null)
    {
      a(null);
      return;
    }
    azlm localazlm = new azlm();
    localazlm.jdField_a_of_type_Boolean = false;
    localazlm.jdField_a_of_type_JavaLangString = paramSongInfo.jdField_a_of_type_JavaLangString;
    if ((TextUtils.isEmpty(paramSongInfo.jdField_a_of_type_JavaLangString)) || (paramSongInfo.jdField_a_of_type_JavaLangString.equals("0")))
    {
      localazlm.jdField_a_of_type_JavaLangString = a(paramSongInfo.f);
      if (TextUtils.isEmpty(localazlm.jdField_a_of_type_JavaLangString))
      {
        QLog.d("OnlineStatusHandler", 1, "pushMusicStatus, songMid is null");
        return;
      }
    }
    localazlm.jdField_b_of_type_JavaLangString = paramSongInfo.jdField_c_of_type_JavaLangString;
    localazlm.jdField_a_of_type_Int = 1;
    if (TextUtils.isEmpty(paramSongInfo.h)) {}
    for (paramSongInfo = paramSongInfo.d;; paramSongInfo = paramSongInfo.h)
    {
      localazlm.jdField_c_of_type_JavaLangString = paramSongInfo;
      if (localazlm.jdField_c_of_type_JavaLangString == null) {
        localazlm.jdField_c_of_type_JavaLangString = "";
      }
      localazlm.jdField_b_of_type_Int = paramInt;
      localazlm.jdField_c_of_type_Int = azlk.a().jdField_a_of_type_Int;
      localazlm.jdField_b_of_type_Boolean = paramBoolean;
      localazlm.d = ((int)paramLong);
      a(localazlm);
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
          azlk.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
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
        paramFromServiceMsg = new awwm(0, 0, new ArrayList());
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
            paramToServiceMsg = new String(bcrt.a((byte[])localObject));
            paramToServiceMsg = a(paramToServiceMsg);
          }
        }
        if (paramToServiceMsg != null) {
          azlk.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramToServiceMsg);
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
        azlk.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        return;
      }
      label330:
      paramToServiceMsg = new String((byte[])localObject);
      continue;
      label343:
      azlk.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
      if ((bool1) && (this.a != null) && (str.equals(this.a.songId)))
      {
        this.a.songName = "";
        this.a.singerName = "";
        azlk.a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(this.a.songId);
        ((FriendListHandler)this.app.a(1)).c(this.a.uin, false);
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
            a().postDelayed(new OnlineStatusHandler.2(this, paramObject), 500L);
          }
          QLog.d("OnlineStatusHandler", 1, new Object[] { "handleRecvMusicStatusPush, uin:", bhsr.e(paramObject), " currentChatUin:", bhsr.e(paramFromServiceMsg), " needRefresh:", Integer.valueOf(k), " isContactShown:", Boolean.valueOf(bool) });
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
      this.allowCmdSet.add("StatSvc.SetStatusFromClient");
      this.allowCmdSet.add("StatSvc.SetBusinessInfo");
      this.allowCmdSet.add("StatSvc.SyncBusinessInfo");
      this.allowCmdSet.add("StatSvc.SetSong");
      this.allowCmdSet.add("ImStatus.ReqPushStatus");
      this.allowCmdSet.add("OidbSvc.0xe59");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends anui> observerClass()
  {
    return azie.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      int i;
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
        if ("StatSvc.SetStatusFromClient".equals(str))
        {
          d(paramFromServiceMsg, paramObject);
          return;
        }
        if ("StatSvc.SyncBusinessInfo".equals(str))
        {
          c(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (!"StatSvc.SetBusinessInfo".equals(str)) {
          break;
        }
        i = ((Integer)paramToServiceMsg.getAttribute("business_type", Integer.valueOf(-1))).intValue();
        if (i == 2)
        {
          d(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (i == 1)
        {
          c(paramFromServiceMsg, paramObject);
          return;
        }
      } while (i != 3);
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if ("ImStatus.ReqPushStatus".equals(str))
      {
        b(paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xe59".equals(str));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azll
 * JD-Core Version:    0.7.0.1
 */