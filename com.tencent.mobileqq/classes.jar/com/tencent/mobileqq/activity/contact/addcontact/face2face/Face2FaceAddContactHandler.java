package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
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
import tencent.im.nearfield_friend.nearfield_friend.GPS;
import tencent.im.nearfield_friend.nearfield_friend.ReqEnter;
import tencent.im.nearfield_friend.nearfield_friend.ReqExit;
import tencent.im.nearfield_friend.nearfield_friend.ReqHeartBeat;
import tencent.im.nearfield_friend.nearfield_friend.ResultInfo;
import tencent.im.nearfield_friend.nearfield_friend.RspEnter;
import tencent.im.nearfield_friend.nearfield_friend.RspExit;
import tencent.im.nearfield_friend.nearfield_friend.RspHeartBeat;
import tencent.im.s2c.msgtype0x210.submsgtype0x133.submsgtype0x133.FaceFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x133.submsgtype0x133.MsgBody;

public class Face2FaceAddContactHandler
  extends BusinessHandler
{
  public Face2FaceAddContactHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1;
    boolean bool;
    if (paramToServiceMsg != null)
    {
      localObject1 = paramToServiceMsg.extraData.getString("face2face_add_contact_session_id");
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("face2face_add_contact_number");
      bool = paramToServiceMsg.extraData.getBoolean("face2face_add_contact_enter_after_verify", false);
      paramToServiceMsg = (ToServiceMsg)localObject1;
    }
    else
    {
      paramToServiceMsg = null;
      paramFromServiceMsg = paramToServiceMsg;
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleEnterFace2faceAddContact:");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" sessionId:");
      ((StringBuilder)localObject1).append(paramToServiceMsg);
      ((StringBuilder)localObject1).append(" number:");
      ((StringBuilder)localObject1).append(paramFromServiceMsg);
      QLog.d("Face2FaceAddContactHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean)
    {
      paramFromServiceMsg = new nearfield_friend.RspEnter();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handleEnterFace2faceAddContact:");
          paramObject.append(paramFromServiceMsg.toString());
          QLog.e("Face2FaceAddContactHandler", 2, paramObject.toString());
        }
        paramFromServiceMsg = null;
        paramBoolean = false;
      }
      if ((paramBoolean) && (paramFromServiceMsg != null))
      {
        if (paramFromServiceMsg.result.has()) {
          localObject1 = (nearfield_friend.ResultInfo)paramFromServiceMsg.result.get();
        } else {
          localObject1 = null;
        }
        paramObject = "";
        int i;
        int j;
        if (localObject1 != null)
        {
          if (((nearfield_friend.ResultInfo)localObject1).errcode.has()) {
            i = ((nearfield_friend.ResultInfo)localObject1).errcode.get();
          } else {
            i = 0;
          }
          j = i;
          if (((nearfield_friend.ResultInfo)localObject1).errmsg.has())
          {
            paramObject = ((nearfield_friend.ResultInfo)localObject1).errmsg.get().toStringUtf8();
            j = i;
          }
        }
        else
        {
          j = 0;
        }
        if (paramFromServiceMsg.security_level.has()) {
          i = paramFromServiceMsg.security_level.get();
        } else {
          i = 0;
        }
        localObject1 = localObject2;
        if (paramFromServiceMsg.verify_url.has()) {
          localObject1 = paramFromServiceMsg.verify_url.get().toStringUtf8();
        }
        int k;
        if (paramFromServiceMsg.heartbeat_time.has()) {
          k = paramFromServiceMsg.heartbeat_time.get();
        } else {
          k = 60;
        }
        int m;
        if (paramFromServiceMsg.expire_time.has()) {
          m = paramFromServiceMsg.expire_time.get();
        } else {
          m = 1200;
        }
        notifyUI(1, true, new Object[] { paramToServiceMsg, Integer.valueOf(j), paramObject, Integer.valueOf(i), localObject1, Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool) });
        return;
      }
    }
    notifyUI(1, false, new Object[] { paramToServiceMsg, Boolean.valueOf(bool) });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean, Object paramObject)
  {
    paramFromServiceMsg = null;
    if (paramToServiceMsg != null) {
      paramToServiceMsg = paramToServiceMsg.extraData.getString("face2face_add_contact_session_id");
    } else {
      paramToServiceMsg = null;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleExitFace2FaceAddContact:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" sessionId:");
      ((StringBuilder)localObject).append(paramToServiceMsg);
      QLog.d("Face2FaceAddContactHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = new nearfield_friend.RspExit();
      try
      {
        ((nearfield_friend.RspExit)localObject).mergeFrom((byte[])paramObject);
        paramObject = localObject;
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleExitFace2FaceAddContact:");
          ((StringBuilder)localObject).append(paramObject.toString());
          QLog.e("Face2FaceAddContactHandler", 2, ((StringBuilder)localObject).toString());
        }
        paramObject = null;
        paramBoolean = false;
      }
      if ((paramBoolean) && (paramObject != null))
      {
        if (paramObject.result.has()) {
          paramFromServiceMsg = (nearfield_friend.ResultInfo)paramObject.result.get();
        }
        paramObject = "";
        int j;
        if (paramFromServiceMsg != null)
        {
          int i;
          if (paramFromServiceMsg.errcode.has()) {
            i = paramFromServiceMsg.errcode.get();
          } else {
            i = 0;
          }
          j = i;
          if (paramFromServiceMsg.errmsg.has())
          {
            paramObject = paramFromServiceMsg.errmsg.get().toStringUtf8();
            j = i;
          }
        }
        else
        {
          j = 0;
        }
        notifyUI(2, true, new Object[] { paramToServiceMsg, Integer.valueOf(j), paramObject });
        return;
      }
    }
    notifyUI(2, false, new Object[] { paramToServiceMsg });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean, Object paramObject)
  {
    Object localObject2 = null;
    if (paramToServiceMsg != null) {
      paramToServiceMsg = paramToServiceMsg.extraData.getString("face2face_add_contact_session_id");
    } else {
      paramToServiceMsg = null;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleFace2FaceAddContactHeartBeat:");
      paramFromServiceMsg.append(paramBoolean);
      paramFromServiceMsg.append(" sessionId:");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.d("Face2FaceAddContactHandler", 2, paramFromServiceMsg.toString());
    }
    if (paramBoolean)
    {
      paramFromServiceMsg = new nearfield_friend.RspHeartBeat();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handleFace2FaceAddContactHeartBeat:");
          paramObject.append(paramFromServiceMsg.toString());
          QLog.e("Face2FaceAddContactHandler", 2, paramObject.toString());
        }
        paramFromServiceMsg = null;
        paramBoolean = false;
      }
      if ((paramBoolean) && (paramFromServiceMsg != null))
      {
        if (paramFromServiceMsg.result.has()) {
          localObject1 = (nearfield_friend.ResultInfo)paramFromServiceMsg.result.get();
        } else {
          localObject1 = null;
        }
        paramObject = "";
        int j;
        if (localObject1 != null)
        {
          int i;
          if (((nearfield_friend.ResultInfo)localObject1).errcode.has()) {
            i = ((nearfield_friend.ResultInfo)localObject1).errcode.get();
          } else {
            i = 0;
          }
          j = i;
          if (((nearfield_friend.ResultInfo)localObject1).errmsg.has())
          {
            paramObject = ((nearfield_friend.ResultInfo)localObject1).errmsg.get().toStringUtf8();
            j = i;
          }
        }
        else
        {
          j = 0;
        }
        Object localObject1 = localObject2;
        if (paramFromServiceMsg.uin_list.has()) {
          localObject1 = paramFromServiceMsg.uin_list.get();
        }
        paramFromServiceMsg = new ArrayList();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            paramFromServiceMsg.add(String.valueOf((Long)((Iterator)localObject1).next()));
          }
        }
        notifyUI(3, true, new Object[] { paramToServiceMsg, Integer.valueOf(j), paramObject, paramFromServiceMsg });
        return;
      }
    }
    notifyUI(3, false, new Object[] { paramToServiceMsg });
  }
  
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exitFace2FaceAddContact sessionId=");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("Face2FaceAddContactHandler", 1, ((StringBuilder)localObject).toString());
    localObject = new nearfield_friend.ReqExit();
    ((nearfield_friend.ReqExit)localObject).session_id.set(paramString);
    ToServiceMsg localToServiceMsg = createToServiceMsg("NearFieldFriendSvr.ReqExit");
    localToServiceMsg.extraData.putString("face2face_add_contact_session_id", paramString);
    localToServiceMsg.putWupBuffer(((nearfield_friend.ReqExit)localObject).toByteArray());
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, nearfield_friend.GPS paramGPS, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enterFace2faceAddContact sessionId=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" number:");
    ((StringBuilder)localObject).append(paramString2);
    QLog.i("Face2FaceAddContactHandler", 1, ((StringBuilder)localObject).toString());
    localObject = new nearfield_friend.ReqEnter();
    ((nearfield_friend.ReqEnter)localObject).session_id.set(paramString1);
    if (paramGPS != null) {
      ((nearfield_friend.ReqEnter)localObject).gps_info.set(paramGPS);
    }
    ((nearfield_friend.ReqEnter)localObject).number.set(paramString2);
    paramGPS = createToServiceMsg("NearFieldFriendSvr.ReqEnter");
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      ((nearfield_friend.ReqEnter)localObject).verify_sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      paramGPS.extraData.putBoolean("face2face_add_contact_enter_after_verify", true);
    }
    paramGPS.extraData.putString("face2face_add_contact_number", paramString2);
    paramGPS.extraData.putString("face2face_add_contact_session_id", paramString1);
    paramGPS.putWupBuffer(((nearfield_friend.ReqEnter)localObject).toByteArray());
    paramGPS.setTimeout(30000L);
    sendPbReq(paramGPS);
  }
  
  public void a(String paramString, List<String> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("face2FaceAddContactHeartBeat sessionId=");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("Face2FaceAddContactHandler", 1, ((StringBuilder)localObject).toString());
    localObject = new nearfield_friend.ReqHeartBeat();
    ((nearfield_friend.ReqHeartBeat)localObject).session_id.set(paramString);
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          long l = Long.parseLong((String)paramList.next());
          ((nearfield_friend.ReqHeartBeat)localObject).uin_list.add(Long.valueOf(l));
        }
        StringBuilder localStringBuilder;
        paramList = createToServiceMsg("NearFieldFriendSvr.ReqHeartBeat");
      }
      catch (Exception paramList)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("face2FaceAddContactHeartBeat error:");
        localStringBuilder.append(paramList.getMessage());
        QLog.e("Face2FaceAddContactHandler", 1, localStringBuilder.toString());
      }
    }
    paramList.extraData.putString("face2face_add_contact_session_id", paramString);
    paramList.putWupBuffer(((nearfield_friend.ReqHeartBeat)localObject).toByteArray());
    paramList.setTimeout(30000L);
    sendPbReq(paramList);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        Object localObject3 = new submsgtype0x133.MsgBody();
        ((submsgtype0x133.MsgBody)localObject3).mergeFrom(paramArrayOfByte);
        boolean bool = ((submsgtype0x133.MsgBody)localObject3).uint64_uin.has();
        localObject2 = null;
        if (!bool) {
          break label409;
        }
        paramArrayOfByte = String.valueOf(((submsgtype0x133.MsgBody)localObject3).uint64_uin.get());
        if (!((submsgtype0x133.MsgBody)localObject3).str_session_id.has()) {
          break label414;
        }
        localObject1 = ((submsgtype0x133.MsgBody)localObject3).str_session_id.get();
        if (((submsgtype0x133.MsgBody)localObject3).rpt_msg_friends.has()) {
          localObject2 = ((submsgtype0x133.MsgBody)localObject3).rpt_msg_friends.get();
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("decodePush0x210_0x133 uin:");
        ((StringBuilder)localObject3).append(paramArrayOfByte);
        ((StringBuilder)localObject3).append(" sessionId:");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.i("Face2FaceAddContactHandler", 1, ((StringBuilder)localObject3).toString());
        if ((TextUtils.isEmpty(paramArrayOfByte)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.equals(paramArrayOfByte, this.appRuntime.getAccount()))) {
          break label408;
        }
        localObject3 = new ArrayList();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          Iterator localIterator = ((List)localObject2).iterator();
          if (localIterator.hasNext())
          {
            submsgtype0x133.FaceFriend localFaceFriend = (submsgtype0x133.FaceFriend)localIterator.next();
            Face2FaceFriendInfo localFace2FaceFriendInfo = new Face2FaceFriendInfo();
            localFace2FaceFriendInfo.jdField_a_of_type_JavaLangString = String.valueOf(localFaceFriend.uint64_friend.get());
            if (!localFaceFriend.bytes_name.has()) {
              break label420;
            }
            localObject2 = localFaceFriend.bytes_name.get().toStringUtf8();
            localFace2FaceFriendInfo.b = ((String)localObject2);
            if (!localFaceFriend.uint32_type.has()) {
              break label427;
            }
            i = localFaceFriend.uint32_type.get();
            localFace2FaceFriendInfo.jdField_a_of_type_Int = i;
            ((List)localObject3).add(localFace2FaceFriendInfo);
            continue;
          }
        }
        notifyUI(4, true, new Object[] { paramArrayOfByte, localObject1, localObject3 });
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("decodePush0x210_0x133 decode error, e=");
        ((StringBuilder)localObject1).append(paramArrayOfByte.toString());
        QLog.e("Face2FaceAddContactHandler", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      QLog.e("Face2FaceAddContactHandler", 1, "decodePush0x210_0x133 pbData = null");
      label408:
      return;
      label409:
      paramArrayOfByte = null;
      continue;
      label414:
      Object localObject1 = null;
      continue;
      label420:
      Object localObject2 = "";
      continue;
      label427:
      int i = 0;
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("NearFieldFriendSvr.ReqEnter");
      this.allowCmdSet.add("NearFieldFriendSvr.ReqExit");
      this.allowCmdSet.add("NearFieldFriendSvr.ReqHeartBeat");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return Face2FaceAddContactObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str;
    if (paramFromServiceMsg != null) {
      str = paramFromServiceMsg.getServiceCmd();
    } else {
      str = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive:");
      localStringBuilder.append(str);
      QLog.d("Face2FaceAddContactHandler", 2, localStringBuilder.toString());
    }
    if (msgCmdFilter(str))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("msgCmdFilter error=");
        paramToServiceMsg.append(str);
        QLog.d("Face2FaceAddContactHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if ("NearFieldFriendSvr.ReqEnter".equalsIgnoreCase(str))
    {
      a(paramToServiceMsg, paramFromServiceMsg, bool, paramObject);
      return;
    }
    if ("NearFieldFriendSvr.ReqExit".equalsIgnoreCase(str))
    {
      b(paramToServiceMsg, paramFromServiceMsg, bool, paramObject);
      return;
    }
    if ("NearFieldFriendSvr.ReqHeartBeat".equalsIgnoreCase(str)) {
      c(paramToServiceMsg, paramFromServiceMsg, bool, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactHandler
 * JD-Core Version:    0.7.0.1
 */