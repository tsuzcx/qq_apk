import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.cs.cmd0x355.Stt.ReqBody;
import tencent.im.cs.cmd0x355.Stt.RspBody;
import tencent.im.cs.cmd0x355.Stt.TransC2CPttReq;
import tencent.im.cs.cmd0x355.Stt.TransC2CPttResp;
import tencent.im.cs.cmd0x355.Stt.TransGroupPttReq;
import tencent.im.cs.cmd0x355.Stt.TransGroupPttResp;

public class axaj
  extends MSFServlet
{
  public static void a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt, Long paramLong, int paramInt)
  {
    Object localObject = new NewIntent(paramQQAppInterface.getApp(), axaj.class);
    int j = paramMessageForPtt.voiceLength;
    int i = j;
    if (j == 0) {
      i = QQRecorder.a(paramMessageForPtt);
    }
    j = paramMessageForPtt.voiceType;
    ((NewIntent)localObject).putExtra("k_session", paramLong);
    ((NewIntent)localObject).putExtra("k_sneder", Long.parseLong(paramMessageForPtt.senderuin));
    ((NewIntent)localObject).putExtra("k_receiver", Long.parseLong(paramMessageForPtt.frienduin));
    ((NewIntent)localObject).putExtra("k_size", paramMessageForPtt.fileSize);
    ((NewIntent)localObject).putExtra("k_ptt_time", i);
    ((NewIntent)localObject).putExtra("k_voice_type", j);
    ((NewIntent)localObject).putExtra("k_trans_type", paramInt);
    ((NewIntent)localObject).putExtra("k_file_path", paramMessageForPtt.groupFileKeyStr);
    ((NewIntent)localObject).putExtra("k_md5", paramMessageForPtt.md5);
    label198:
    boolean bool;
    if (paramMessageForPtt.autoToText >= 1)
    {
      paramInt = 1;
      ((NewIntent)localObject).putExtra("k_ptt_type", paramInt);
      if (paramMessageForPtt.istroop != 0) {
        break label602;
      }
      ((NewIntent)localObject).putExtra("k_file", paramMessageForPtt.urlAtServer);
      ((NewIntent)localObject).putExtra("k_cmd", 1);
      paramLong = paramMessageForPtt.urlAtServer;
      QLog.d("SttServlet", 1, "translate l:" + paramMessageForPtt.voiceLength + " from:" + paramMessageForPtt.istroop + " issend:" + paramMessageForPtt.isSend() + " format:" + paramMessageForPtt.voiceType + " size:" + paramMessageForPtt.fileSize + " uuid:" + paramLong);
      ((NewIntent)localObject).putExtra("k_retry", 0);
      if (((paramMessageForPtt.istroop != 0) || (!TextUtils.isEmpty(paramMessageForPtt.urlAtServer))) && ((paramMessageForPtt.istroop == 0) || (paramMessageForPtt.groupFileID != 0L) || (!TextUtils.isEmpty(paramMessageForPtt.groupFileKeyStr)))) {
        break label671;
      }
      bool = true;
    }
    label388:
    label671:
    for (;;)
    {
      for (;;)
      {
        ((NewIntent)localObject).putExtra("k_n_uuid", bool);
        paramQQAppInterface.startServlet((NewIntent)localObject);
        try
        {
          paramLong = awrn.a(BaseApplication.getContext());
          localObject = new HashMap();
          ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
          if (paramMessageForPtt.istroop == 0)
          {
            paramQQAppInterface = "1";
            ((HashMap)localObject).put("param_FailCode", paramQQAppInterface);
            ((HashMap)localObject).put("appversion", "8.2.6");
            paramLong.a("", "PttSttRequestV2", false, 0L, 0L, (HashMap)localObject, "");
            label422:
            if (bool) {
              paramInt = 1000;
            }
          }
        }
        catch (Exception paramQQAppInterface)
        {
          try
          {
            if (paramMessageForPtt.istroop != 0) {
              paramInt = 2000;
            }
            if (paramMessageForPtt.isSend())
            {
              paramInt += 100;
              if (paramMessageForPtt.fileSize > 0L) {
                paramInt += 10;
              }
            }
            for (;;)
            {
              paramQQAppInterface = awrn.a(BaseApplication.getContext());
              paramLong = new HashMap();
              paramLong.put(BaseConstants.RDM_NoChangeFailCode, "");
              paramLong.put("param_FailCode", String.valueOf(paramInt));
              paramLong.put("sender", paramMessageForPtt.senderuin);
              paramLong.put("receiver", paramMessageForPtt.frienduin);
              paramLong.put("uinType", String.valueOf(paramMessageForPtt.istroop));
              paramLong.put("uploadState", String.valueOf(paramMessageForPtt.fileSize));
              paramLong.put("voiceType", String.valueOf(paramMessageForPtt.voiceType));
              paramLong.put("url", String.valueOf(paramMessageForPtt.url));
              paramQQAppInterface.a("", "PttSttErrRequest", false, 0L, 0L, paramLong, "");
              return;
              paramInt = 0;
              break;
              label602:
              ((NewIntent)localObject).putExtra("k_cmd", 2);
              ((NewIntent)localObject).putExtra("k_file", paramMessageForPtt.groupFileID);
              paramLong = String.valueOf(paramMessageForPtt.groupFileID);
              break label198;
              paramQQAppInterface = "2";
              break label388;
              paramQQAppInterface = paramQQAppInterface;
              paramQQAppInterface.printStackTrace();
              break label422;
              paramInt += 20;
              continue;
              paramInt += 200;
            }
            bool = false;
          }
          catch (Exception paramQQAppInterface)
          {
            paramQQAppInterface.printStackTrace();
            return;
          }
        }
      }
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    long l3 = 30000L;
    int k = paramIntent.getIntExtra("k_cmd", 0);
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    long l1;
    Object localObject4;
    int i;
    label197:
    int j;
    boolean bool1;
    if (bool2)
    {
      localObject1 = localObject2;
      l1 = l3;
      try
      {
        localObject4 = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        localObject1 = localObject2;
        l1 = l3;
        paramFromServiceMsg = new byte[((ByteBuffer)localObject4).getInt() - 4];
        localObject1 = localObject2;
        l1 = l3;
        ((ByteBuffer)localObject4).get(paramFromServiceMsg);
        localObject1 = localObject2;
        l1 = l3;
        localObject4 = new Stt.RspBody();
        localObject1 = localObject2;
        l1 = l3;
        ((Stt.RspBody)localObject4).mergeFrom(paramFromServiceMsg);
        switch (k)
        {
        case 1: 
          localObject1 = localObject2;
          l1 = l3;
          throw new RuntimeException("unknow cmd: " + k);
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        i = 2001;
        paramFromServiceMsg.printStackTrace();
        bool2 = false;
        l3 = l1;
        localObject2 = localObject1;
      }
      j = paramIntent.getIntExtra("k_retry", 0);
      bool1 = paramIntent.getBooleanExtra("k_n_uuid", false);
      QLog.d("SttServlet", 1, "onReceive " + bool2 + " retry " + j + " nouuid" + bool1 + " resultCode=" + i);
      if ((bool2) || (bool1) || (i == 48)) {
        break label808;
      }
      j += 1;
      if (j >= 3) {
        break label808;
      }
      paramIntent.putExtra("k_retry", j);
      getAppRuntime().startServlet((NewIntent)paramIntent);
      return;
      localObject1 = localObject2;
      l1 = l3;
      if (((Stt.RspBody)localObject4).msg_c2c_ptt_resp.uint32_error_code.get() != 0) {
        break label877;
      }
    }
    label808:
    label877:
    for (bool2 = true;; bool2 = false)
    {
      localObject1 = localObject2;
      l1 = l3;
      i = ((Stt.RspBody)localObject4).msg_c2c_ptt_resp.uint32_error_code.get();
      localObject1 = localObject2;
      l1 = l3;
      l3 = ((Stt.RspBody)localObject4).msg_c2c_ptt_resp.uint32_waittime.get();
      localObject1 = localObject2;
      l1 = l3;
      paramFromServiceMsg = localObject3;
      j = i;
      bool1 = bool2;
      long l2 = l3;
      if (((Stt.RspBody)localObject4).msg_c2c_ptt_resp.str_text != null)
      {
        localObject1 = localObject2;
        l1 = l3;
        paramFromServiceMsg = localObject3;
        j = i;
        bool1 = bool2;
        l2 = l3;
        if (((Stt.RspBody)localObject4).msg_c2c_ptt_resp.str_text.has())
        {
          localObject1 = localObject2;
          l1 = l3;
          paramFromServiceMsg = ((Stt.RspBody)localObject4).msg_c2c_ptt_resp.str_text.get();
          l2 = l3;
          bool1 = bool2;
          j = i;
        }
      }
      localObject1 = paramFromServiceMsg;
      l1 = l2;
      localObject2 = paramFromServiceMsg;
      i = j;
      bool2 = bool1;
      l3 = l2;
      if (!QLog.isColorLevel()) {
        break label197;
      }
      localObject2 = paramFromServiceMsg;
      i = j;
      bool2 = bool1;
      l3 = l2;
      if (paramFromServiceMsg == null) {
        break label197;
      }
      localObject1 = paramFromServiceMsg;
      l1 = l2;
      QLog.d("SttServlet", 1, "onReceive  text =" + paramFromServiceMsg.length());
      localObject2 = paramFromServiceMsg;
      i = j;
      bool2 = bool1;
      l3 = l2;
      break label197;
      localObject1 = localObject2;
      l1 = l3;
      if (((Stt.RspBody)localObject4).msg_group_ptt_resp.uint32_error_code.get() == 0) {}
      for (bool2 = true;; bool2 = false)
      {
        localObject1 = localObject2;
        l1 = l3;
        i = ((Stt.RspBody)localObject4).msg_group_ptt_resp.uint32_error_code.get();
        localObject1 = localObject2;
        l1 = l3;
        l3 = ((Stt.RspBody)localObject4).msg_group_ptt_resp.uint32_waittime.get();
        localObject1 = localObject2;
        l1 = l3;
        paramFromServiceMsg = localObject3;
        j = i;
        bool1 = bool2;
        l2 = l3;
        if (((Stt.RspBody)localObject4).msg_group_ptt_resp.str_text == null) {
          break;
        }
        localObject1 = localObject2;
        l1 = l3;
        paramFromServiceMsg = localObject3;
        j = i;
        bool1 = bool2;
        l2 = l3;
        if (!((Stt.RspBody)localObject4).msg_group_ptt_resp.str_text.has()) {
          break;
        }
        localObject1 = localObject2;
        l1 = l3;
        paramFromServiceMsg = ((Stt.RspBody)localObject4).msg_group_ptt_resp.str_text.get();
        j = i;
        bool1 = bool2;
        l2 = l3;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SttServlet", 1, "onReceive  errormsg =" + paramFromServiceMsg.toString());
      }
      i = 0;
      localObject2 = localObject1;
      break label197;
      paramFromServiceMsg = new Bundle();
      paramFromServiceMsg.putLong("k_session", paramIntent.getLongExtra("k_session", 0L));
      paramFromServiceMsg.putLong("k_time_out", l3);
      paramFromServiceMsg.putInt("k_result_code", i);
      if (localObject2 != null) {
        paramFromServiceMsg.putString("k_ptt_trans_txt", (String)localObject2);
      }
      notifyObserver(paramIntent, k, bool2, paramFromServiceMsg, axaf.class);
      return;
      break;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("k_retry", 0);
    byte[] arrayOfByte = null;
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "str_filemd5" + paramIntent.getStringExtra("k_md5") + " uint32_msg_type=" + paramIntent.getIntExtra("k_ptt_type", 0));
    }
    Stt.ReqBody localReqBody;
    String str;
    Object localObject;
    if (i == 0)
    {
      i = paramIntent.getIntExtra("k_cmd", 0);
      localReqBody = new Stt.ReqBody();
      switch (i)
      {
      default: 
        throw new RuntimeException("unknow cmd: " + i);
      case 1: 
        str = "pttTrans.TransC2CPttReq";
        localObject = new Stt.TransC2CPttReq();
        ((Stt.TransC2CPttReq)localObject).uint64_sessionid.set(paramIntent.getLongExtra("k_session", 0L));
        ((Stt.TransC2CPttReq)localObject).uint64_sender_uin.set(paramIntent.getLongExtra("k_sneder", 0L));
        ((Stt.TransC2CPttReq)localObject).uint64_receiver_uin.set(paramIntent.getLongExtra("k_receiver", 0L));
        ((Stt.TransC2CPttReq)localObject).str_file_path.set(paramIntent.getStringExtra("k_file"));
        ((Stt.TransC2CPttReq)localObject).uint32_ptt_time.set(paramIntent.getIntExtra("k_ptt_time", 0));
        ((Stt.TransC2CPttReq)localObject).uint32_filesize.set((int)paramIntent.getLongExtra("k_size", 0L));
        ((Stt.TransC2CPttReq)localObject).uint32_ptt_format.set(paramIntent.getIntExtra("k_voice_type", 0));
        ((Stt.TransC2CPttReq)localObject).uint32_event_type.set(paramIntent.getIntExtra("k_trans_type", 1));
        ((Stt.TransC2CPttReq)localObject).str_filemd5.set(paramIntent.getStringExtra("k_md5"));
        ((Stt.TransC2CPttReq)localObject).uint32_msg_type.set(paramIntent.getIntExtra("k_ptt_type", 0));
        localReqBody.uint32_sub_cmd.set(2);
        localReqBody.msg_c2c_ptt_req.set((MessageMicro)localObject);
        ((Stt.TransC2CPttReq)localObject).str_file_path.get();
        localObject = str;
        if (str != null)
        {
          paramIntent.putExtra("k_sso_id", str);
          arrayOfByte = localReqBody.toByteArray();
          localObject = ByteBuffer.allocate(arrayOfByte.length + 4);
          ((ByteBuffer)localObject).putInt(arrayOfByte.length + 4).put(arrayOfByte);
          arrayOfByte = ((ByteBuffer)localObject).array();
          paramIntent.putExtra("k_sso_data", arrayOfByte);
          paramIntent.putExtra("k_request_hash", arrayOfByte.hashCode());
          localObject = str;
        }
        break;
      }
    }
    for (;;)
    {
      paramPacket.setSSOCommand((String)localObject);
      paramPacket.putSendData(arrayOfByte);
      return;
      str = "pttTrans.TransGroupPttReq";
      localObject = new Stt.TransGroupPttReq();
      ((Stt.TransGroupPttReq)localObject).uint64_sessionid.set(paramIntent.getLongExtra("k_session", 0L));
      ((Stt.TransGroupPttReq)localObject).uint64_sender_uin.set(paramIntent.getLongExtra("k_sneder", 0L));
      ((Stt.TransGroupPttReq)localObject).uint64_group_uin.set(paramIntent.getLongExtra("k_receiver", 0L));
      ((Stt.TransGroupPttReq)localObject).uint32_fileid.set((int)paramIntent.getLongExtra("k_file", 0L));
      ((Stt.TransGroupPttReq)localObject).str_filemd5.set(paramIntent.getStringExtra("k_md5"));
      ((Stt.TransGroupPttReq)localObject).uint32_ptt_time.set(paramIntent.getIntExtra("k_ptt_time", 0));
      ((Stt.TransGroupPttReq)localObject).uint32_filesize.set((int)paramIntent.getLongExtra("k_size", 0L));
      ((Stt.TransGroupPttReq)localObject).uint32_ptt_format.set(paramIntent.getIntExtra("k_voice_type", 0));
      ((Stt.TransGroupPttReq)localObject).uint32_event_type.set(paramIntent.getIntExtra("k_trans_type", 1));
      ((Stt.TransGroupPttReq)localObject).uint32_msg_type.set(paramIntent.getIntExtra("k_ptt_type", 0));
      if (paramIntent.getStringExtra("k_file_path") != null) {
        ((Stt.TransGroupPttReq)localObject).str_file_path.set(paramIntent.getStringExtra("k_file_path"));
      }
      localReqBody.uint32_sub_cmd.set(1);
      localReqBody.msg_group_ptt_req.set((MessageMicro)localObject);
      break;
      localObject = paramIntent.getStringExtra("k_sso_id");
      arrayOfByte = paramIntent.getByteArrayExtra("k_sso_data");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axaj
 * JD-Core Version:    0.7.0.1
 */