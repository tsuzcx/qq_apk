import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
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
import tencent.aio.media.aio_media.DynamicInfo;
import tencent.aio.media.aio_media.ReqGetDynamicInfo;
import tencent.aio.media.aio_media.ReqLatestPlayingState;
import tencent.aio.media.aio_media.RspGetDynamicInfo;
import tencent.aio.media.aio_media.RspLatestPlayingState;

public class bekh
  extends anud
{
  public bekh(QQAppInterface paramQQAppInterface)
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
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("QQAIOMediaSvc.get_latest_playing_state");
      this.allowCmdSet.add("QQAIOMediaSvc.get_dynamic_info");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends anui> observerClass()
  {
    return bekg.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))) {}
    Long localLong;
    for (;;)
    {
      return;
      if ("QQAIOMediaSvc.get_latest_playing_state".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramToServiceMsg.extraData.getInt("KEY_SERVICE_TYPE", -1) == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TogetherOperationHandler", 2, "RspLatestPlayingState serviceType is listener");
          }
        }
        else
        {
          paramFromServiceMsg = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.enum_media_type.has()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TogetherOperationHandler", 2, "RspLatestPlayingState is null or type is empty");
            }
          }
          else
          {
            int i = paramFromServiceMsg.enum_media_type.get();
            paramObject = ((bejx)this.mApp.getManager(339)).a(i);
            if (paramObject == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("TogetherOperationHandler", 2, "RspLatestPlayingState receive type= " + i);
              }
            }
            else {
              paramObject.a(paramToServiceMsg, paramFromServiceMsg);
            }
          }
        }
      }
      else if ("QQAIOMediaSvc.get_dynamic_info".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherOperationHandler", 2, new Object[] { "Rsp CMD_GET_FAKE_DATA, isSuccess=", Boolean.valueOf(paramFromServiceMsg.isSuccess()) });
        }
        if (paramFromServiceMsg.isSuccess())
        {
          paramToServiceMsg = new aio_media.RspGetDynamicInfo();
          try
          {
            paramToServiceMsg.mergeFrom((byte[])paramObject);
            bejx.a(this.app).b();
            if (!((aio_media.RspGetDynamicInfo)paramToServiceMsg.get()).msg_music_info.has()) {
              break label443;
            }
            paramFromServiceMsg = new bekf();
            paramFromServiceMsg.b = 1001;
            paramFromServiceMsg.jdField_a_of_type_Boolean = true;
            paramFromServiceMsg.f = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)paramToServiceMsg.get()).msg_music_info.get()).uint32_user_num.get();
            paramObject = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)paramToServiceMsg.get()).msg_music_info.get()).rpt_uint64_uins.get();
            paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramObject.size());
            paramObject = paramObject.iterator();
            while (paramObject.hasNext())
            {
              localLong = (Long)paramObject.next();
              paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList.add(localLong + "");
            }
            if (!QLog.isColorLevel()) {}
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg)
          {
            paramToServiceMsg.printStackTrace();
          }
        }
      }
    }
    QLog.d("TogetherOperationHandler", 2, "InvalidProtocolBufferMicroException");
    return;
    bejx.a(this.app).a(paramFromServiceMsg);
    label443:
    if (((aio_media.RspGetDynamicInfo)paramToServiceMsg.get()).msg_video_info.has())
    {
      paramFromServiceMsg = new bekf();
      paramFromServiceMsg.b = 1002;
      paramFromServiceMsg.jdField_a_of_type_Boolean = true;
      paramFromServiceMsg.f = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)paramToServiceMsg.get()).msg_video_info.get()).uint32_user_num.get();
      paramObject = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)paramToServiceMsg.get()).msg_video_info.get()).rpt_uint64_uins.get();
      paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramObject.size());
      paramObject = paramObject.iterator();
      while (paramObject.hasNext())
      {
        localLong = (Long)paramObject.next();
        paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList.add(localLong + "");
      }
      bejx.a(this.app).a(paramFromServiceMsg);
    }
    if (((aio_media.RspGetDynamicInfo)paramToServiceMsg.get()).msg_ksing_info.has())
    {
      paramFromServiceMsg = new bekf();
      paramFromServiceMsg.b = 1003;
      paramFromServiceMsg.jdField_a_of_type_Boolean = true;
      paramFromServiceMsg.f = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)paramToServiceMsg.get()).msg_ksing_info.get()).uint32_user_num.get();
      paramObject = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)paramToServiceMsg.get()).msg_ksing_info.get()).rpt_uint64_uins.get();
      paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramObject.size());
      paramObject = paramObject.iterator();
      while (paramObject.hasNext())
      {
        localLong = (Long)paramObject.next();
        paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList.add(localLong + "");
      }
      bejx.a(this.app).a(paramFromServiceMsg);
    }
    if (((aio_media.RspGetDynamicInfo)paramToServiceMsg.get()).msg_play_info.has())
    {
      paramFromServiceMsg = new bekf();
      paramFromServiceMsg.b = 1004;
      paramFromServiceMsg.jdField_a_of_type_Boolean = true;
      paramFromServiceMsg.f = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)paramToServiceMsg.get()).msg_play_info.get()).uint32_user_num.get();
      paramToServiceMsg = ((aio_media.DynamicInfo)((aio_media.RspGetDynamicInfo)paramToServiceMsg.get()).msg_play_info.get()).rpt_uint64_uins.get();
      paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramToServiceMsg.size());
      paramToServiceMsg = paramToServiceMsg.iterator();
      while (paramToServiceMsg.hasNext())
      {
        paramObject = (Long)paramToServiceMsg.next();
        paramFromServiceMsg.jdField_a_of_type_JavaUtilArrayList.add(paramObject + "");
      }
      bejx.a(this.app).a(paramFromServiceMsg);
    }
    notifyUI(3, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bekh
 * JD-Core Version:    0.7.0.1
 */