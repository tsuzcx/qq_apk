import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.aio.media.VideoWriteReply;
import tencent.aio.media.VideoWriteRequest;
import tencent.aio.media.aio_media.DynamicInfo;
import tencent.aio.media.aio_media.ReqCreateRoom;
import tencent.aio.media.aio_media.ReqGetDynamicInfo;
import tencent.aio.media.aio_media.ReqLatestPlayingState;
import tencent.aio.media.aio_media.RspGetDynamicInfo;
import tencent.aio.media.aio_media.RspLatestPlayingState;

public class bddd
  extends BusinessHandler
{
  public bddd(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private aio_media.RspLatestPlayingState a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = new aio_media.RspLatestPlayingState();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        return paramToServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherOperationHandler", 2, "parseResBdy, success=" + paramFromServiceMsg.isSuccess() + " code=" + paramFromServiceMsg.getResultCode());
    }
    return null;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (("QQAIOMediaSvc.create_room".equals(paramFromServiceMsg.getServiceCmd())) && (paramToServiceMsg.extraData.getInt("KEY_SERVICE_TYPE", -1) == 1)) {}
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    if (QLog.isColorLevel()) {
      QLog.d("TogetherOperationHandler", 2, new Object[] { "handleOperateTogetherWatchRsp isSuccess:", Boolean.valueOf(bool2), " errorCode:", Integer.valueOf(paramFromServiceMsg.getResultCode()) });
    }
    Bundle localBundle = paramToServiceMsg.extraData;
    if (bool2) {}
    for (;;)
    {
      try
      {
        VideoWriteReply localVideoWriteReply = new VideoWriteReply();
        localVideoWriteReply.mergeFrom((byte[])paramObject);
        if (!localVideoWriteReply.errmsg.has()) {
          continue;
        }
        paramToServiceMsg = localVideoWriteReply.errmsg.get();
        if (!localVideoWriteReply.jumpUrl.has()) {
          continue;
        }
        paramFromServiceMsg = localVideoWriteReply.jumpUrl.get();
        int i = localVideoWriteReply.result.get();
        if (QLog.isColorLevel()) {
          QLog.d("TogetherOperationHandler", 2, new Object[] { "handleOperateTogetherWatchRsp errorTip:", paramToServiceMsg, " errorCode:", Integer.valueOf(i), " jumpURL=", paramFromServiceMsg });
        }
        localBundle.putString("error_msg", paramToServiceMsg);
        localBundle.putInt("error_code", i);
        localBundle.putString("jump_url", paramFromServiceMsg);
        if (i != 0) {
          continue;
        }
        bool1 = true;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TogetherOperationHandler", 2, "InvalidProtocolBufferMicroException");
        bool1 = bool2;
        continue;
      }
      notifyUI(4, bool1, localBundle);
      return;
      paramToServiceMsg = "";
      continue;
      paramFromServiceMsg = "";
      continue;
      boolean bool1 = false;
      continue;
      localBundle.putInt("error_code", paramFromServiceMsg.getResultCode());
      bool1 = bool2;
    }
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherOperationHandler", 2, "getFakePanelData");
      }
      aio_media.ReqGetDynamicInfo localReqGetDynamicInfo = new aio_media.ReqGetDynamicInfo();
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "QQAIOMediaSvc.get_dynamic_info");
      localToServiceMsg.putWupBuffer(localReqGetDynamicInfo.toByteArray());
      localToServiceMsg.setTimeout(30000L);
      sendPbReq(localToServiceMsg);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TogetherOperationHandler", 2, "getFakePanelData, exception", localNumberFormatException);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherOperationHandler", 2, "getPlayingState, service=" + paramInt1 + ",sessionType= " + paramInt2 + ", uin=" + paramString + ", by=" + paramInt3);
    }
    try
    {
      aio_media.ReqLatestPlayingState localReqLatestPlayingState = new aio_media.ReqLatestPlayingState();
      localReqLatestPlayingState.enum_aio_type.set(paramInt2);
      localReqLatestPlayingState.uint64_id.set(Long.valueOf(paramString).longValue());
      localReqLatestPlayingState.uint32_version.set(2);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "QQAIOMediaSvc.get_latest_playing_state");
      localToServiceMsg.extraData.putInt("KEY_SERVICE_TYPE", paramInt1);
      localToServiceMsg.extraData.putInt("KEY_SESSION_TYPE", paramInt2);
      localToServiceMsg.extraData.putString("KEY_SESSION_UIN", paramString);
      localToServiceMsg.extraData.putInt("KEY_REFRESH_SESSION_BY", paramInt3);
      localToServiceMsg.putWupBuffer(localReqLatestPlayingState.toByteArray());
      localToServiceMsg.setTimeout(30000L);
      sendPbReq(localToServiceMsg);
      return;
    }
    catch (NumberFormatException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TogetherOperationHandler", 2, "getPlayingState, exception", paramString);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherOperationHandler", 2, "reqCreateRoom, service=" + paramInt1 + ",sessionType= " + paramInt2 + ", uin=" + paramString1 + ", songId=" + paramString2 + ", from=" + paramInt3);
    }
    try
    {
      aio_media.ReqCreateRoom localReqCreateRoom = new aio_media.ReqCreateRoom();
      localReqCreateRoom.enum_aio_type.set(paramInt2);
      localReqCreateRoom.uint64_id.set(Long.valueOf(paramString1).longValue());
      if (!TextUtils.isEmpty(paramString2)) {
        localReqCreateRoom.str_song_id.set(paramString2);
      }
      localReqCreateRoom.enum_media_type.set(paramInt1);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "QQAIOMediaSvc.create_room");
      localToServiceMsg.extraData.putInt("KEY_SERVICE_TYPE", paramInt1);
      localToServiceMsg.extraData.putInt("KEY_SESSION_TYPE", paramInt2);
      localToServiceMsg.extraData.putString("KEY_SESSION_UIN", paramString1);
      localToServiceMsg.extraData.putInt("KEY_FROM", paramInt3);
      if (!TextUtils.isEmpty(paramString2)) {
        localToServiceMsg.extraData.putString("KEY_SONG_ID", paramString2);
      }
      localToServiceMsg.putWupBuffer(localReqCreateRoom.toByteArray());
      localToServiceMsg.setTimeout(30000L);
      sendPbReq(localToServiceMsg);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TogetherOperationHandler", 2, "getPlayingState, exception", paramString1);
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherOperationHandler", 2, "operateTogetherWatch");
    }
    long l2 = -1L;
    long l1;
    VideoWriteRequest localVideoWriteRequest;
    try
    {
      l1 = Long.parseLong(paramString4);
      if (l1 == -1L) {
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.e("TogetherOperationHandler", 2, "operateTogetherWatch, exception", localNumberFormatException);
          l1 = l2;
        }
      }
      localVideoWriteRequest = new VideoWriteRequest();
      localVideoWriteRequest.categoryId.set(paramInt1);
      if (paramInt3 != 1) {
        break label277;
      }
    }
    l2 = l1;
    if (paramInt3 == 2) {}
    for (;;)
    {
      if (l2 != -1L) {
        localVideoWriteRequest.gid.set(l2);
      }
      if (l1 != -1L) {
        localVideoWriteRequest.targetUin.set(l1);
      }
      if (!TextUtils.isEmpty(paramString1)) {
        localVideoWriteRequest.matchId.set(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localVideoWriteRequest.roomTitle.set(paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localVideoWriteRequest.roomCover.set(paramString3);
      }
      localVideoWriteRequest.operType.set(paramInt2);
      paramString1 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "QQAIOMediaSvc.VideoWrite");
      paramString1.putWupBuffer(localVideoWriteRequest.toByteArray());
      paramString1.setTimeout(30000L);
      paramString1.extraData.putInt("KEY_SESSION_TYPE", paramInt3);
      paramString1.extraData.putString("KEY_SESSION_UIN", paramString4);
      paramString1.extraData.putInt("KEY_FROM", paramInt4);
      sendPbReq(paramString1);
      return;
      label277:
      l2 = -1L;
      break;
      l1 = -1L;
    }
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("QQAIOMediaSvc.get_latest_playing_state");
      this.allowCmdSet.add("QQAIOMediaSvc.get_dynamic_info");
      this.allowCmdSet.add("QQAIOMediaSvc.create_room");
      this.allowCmdSet.add("QQAIOMediaSvc.VideoWrite");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return bddc.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))) {}
    int i;
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
          if (!"QQAIOMediaSvc.get_latest_playing_state".equals(paramFromServiceMsg.getServiceCmd())) {
            break label181;
          }
          if (paramToServiceMsg.extraData.getInt("KEY_SERVICE_TYPE", -1) != 1) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TogetherOperationHandler", 2, "RspLatestPlayingState serviceType is listener");
        return;
        paramObject = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        if ((paramObject != null) && (paramObject.enum_media_type.has())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TogetherOperationHandler", 2, "RspLatestPlayingState is null or type is empty");
      return;
      i = paramObject.enum_media_type.get();
      localObject1 = ((bdct)this.mApp.getManager(339)).a(i);
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherOperationHandler", 2, "RspLatestPlayingState receive type= " + i);
    return;
    ((bdde)localObject1).a(paramToServiceMsg, paramObject);
    for (;;)
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
      label181:
      if ("QQAIOMediaSvc.get_dynamic_info".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherOperationHandler", 2, new Object[] { "Rsp CMD_GET_FAKE_DATA, isSuccess=", Boolean.valueOf(paramFromServiceMsg.isSuccess()) });
        }
        if (paramFromServiceMsg.isSuccess())
        {
          localObject1 = new aio_media.RspGetDynamicInfo();
          Object localObject2;
          Long localLong;
          try
          {
            ((aio_media.RspGetDynamicInfo)localObject1).mergeFrom((byte[])paramObject);
            bdct.a(this.app).b();
            if (!((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).msg_music_info.has()) {
              break label466;
            }
            paramObject = new bddb();
            paramObject.b = 1001;
            paramObject.jdField_a_of_type_Boolean = true;
            paramObject.f = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).msg_music_info.get()).uint32_user_num.get();
            localObject2 = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).msg_music_info.get()).rpt_uint64_uins.get();
            paramObject.jdField_a_of_type_JavaUtilArrayList = new ArrayList(((List)localObject2).size());
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localLong = (Long)((Iterator)localObject2).next();
              paramObject.jdField_a_of_type_JavaUtilArrayList.add(localLong + "");
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
          }
          catch (InvalidProtocolBufferMicroException paramObject)
          {
            paramObject.printStackTrace();
          }
          QLog.d("TogetherOperationHandler", 2, "InvalidProtocolBufferMicroException");
          continue;
          bdct.a(this.app).a(paramObject);
          label466:
          if (((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).msg_video_info.has())
          {
            paramObject = new bddb();
            paramObject.b = 1002;
            paramObject.jdField_a_of_type_Boolean = true;
            paramObject.f = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).msg_video_info.get()).uint32_user_num.get();
            localObject2 = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).msg_video_info.get()).rpt_uint64_uins.get();
            paramObject.jdField_a_of_type_JavaUtilArrayList = new ArrayList(((List)localObject2).size());
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localLong = (Long)((Iterator)localObject2).next();
              paramObject.jdField_a_of_type_JavaUtilArrayList.add(localLong + "");
            }
            bdct.a(this.app).a(paramObject);
          }
          if (((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).msg_ksing_info.has())
          {
            paramObject = new bddb();
            paramObject.b = 1003;
            paramObject.jdField_a_of_type_Boolean = true;
            paramObject.f = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).msg_ksing_info.get()).uint32_user_num.get();
            localObject2 = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).msg_ksing_info.get()).rpt_uint64_uins.get();
            paramObject.jdField_a_of_type_JavaUtilArrayList = new ArrayList(((List)localObject2).size());
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localLong = (Long)((Iterator)localObject2).next();
              paramObject.jdField_a_of_type_JavaUtilArrayList.add(localLong + "");
            }
            bdct.a(this.app).a(paramObject);
          }
          if (((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).msg_play_info.has())
          {
            paramObject = new bddb();
            paramObject.b = 1004;
            paramObject.jdField_a_of_type_Boolean = true;
            paramObject.f = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).msg_play_info.get()).uint32_user_num.get();
            localObject2 = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).msg_play_info.get()).rpt_uint64_uins.get();
            paramObject.jdField_a_of_type_JavaUtilArrayList = new ArrayList(((List)localObject2).size());
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localLong = (Long)((Iterator)localObject2).next();
              paramObject.jdField_a_of_type_JavaUtilArrayList.add(localLong + "");
            }
            bdct.a(this.app).a(paramObject);
          }
          if (((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).rpt_dynamic_info.has())
          {
            paramObject = ((aio_media.RspGetDynamicInfo)((aio_media.RspGetDynamicInfo)localObject1).get()).rpt_dynamic_info.get().iterator();
            while (paramObject.hasNext())
            {
              localObject2 = (aio_media.DynamicInfo)paramObject.next();
              if ((localObject2 != null) && (((aio_media.DynamicInfo)localObject2).int32_media_type.get() == 16))
              {
                localObject1 = new bddb();
                ((bddb)localObject1).b = 1005;
                ((bddb)localObject1).jdField_a_of_type_Boolean = true;
                ((bddb)localObject1).f = ((aio_media.DynamicInfo)localObject2).uint32_user_num.get();
                localObject2 = ((aio_media.DynamicInfo)localObject2).rpt_uint64_uins.get();
                ((bddb)localObject1).jdField_a_of_type_JavaUtilArrayList = new ArrayList(((List)localObject2).size());
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localLong = (Long)((Iterator)localObject2).next();
                  ((bddb)localObject1).jdField_a_of_type_JavaUtilArrayList.add(localLong + "");
                }
                bdct.a(this.app).a((bddb)localObject1);
              }
            }
          }
          notifyUI(3, true, null);
        }
      }
      else if ("QQAIOMediaSvc.VideoWrite".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddd
 * JD-Core Version:    0.7.0.1
 */