import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.IProtoRespBack;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x5ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x6ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x5RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x6RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyForwardFileRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReqV3;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV3;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccReq;
import tencent.im.cs.cmd0x346.cmd0x346.UploadSuccRsp;

public class atim
  implements ProtoReqManager.IProtoRespBack
{
  private static int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public atim(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    long l2 = 0L;
    int i = -100003;
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool2 = true;
    long l1;
    Object localObject1;
    boolean bool1;
    if ((paramProtoResp.resp.getResultCode() == 1002) || (paramProtoResp.resp.getResultCode() == 1013))
    {
      i = -100001;
      QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      l1 = 0L;
      localObject1 = null;
      paramProtoResp = null;
      bool1 = false;
    }
    for (;;)
    {
      if (i != 0) {
        bool1 = false;
      }
      ((atij)((atin)paramProtoReq.busiData).a()).a(bool1, i, paramProtoResp, (String)localObject1, (String)localObject2, l1, l2);
      return;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        i = -100002;
        QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
        l1 = 0L;
        localObject1 = null;
        paramProtoResp = null;
        bool1 = false;
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject1 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject1).mergeFrom(paramProtoResp);
          if (((cmd0x346.RspBody)localObject1).msg_apply_forward_file_rsp.has()) {
            break;
          }
          QLog.i("ProtocolManager", 1, "onForwardOfflineResponse rspBody has not hasMsgApplyForwardFileRsp");
          l1 = 0L;
          localObject1 = null;
          paramProtoResp = null;
          bool1 = false;
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          l1 = 0L;
          localObject1 = null;
          paramProtoResp = null;
          bool1 = false;
        }
      }
    }
    label295:
    label321:
    cmd0x346.ApplyForwardFileRsp localApplyForwardFileRsp;
    if (((cmd0x346.RspBody)localObject1).uint32_flag_use_media_platform.has()) {
      if (((cmd0x346.RspBody)localObject1).uint32_flag_use_media_platform.get() == 1)
      {
        bool1 = true;
        QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: bUseMediaPlatform " + bool1);
        localApplyForwardFileRsp = (cmd0x346.ApplyForwardFileRsp)((cmd0x346.RspBody)localObject1).msg_apply_forward_file_rsp.get();
        if (!localApplyForwardFileRsp.int32_ret_code.has()) {
          break label525;
        }
      }
    }
    label525:
    for (i = localApplyForwardFileRsp.int32_ret_code.get();; i = 0)
    {
      if (localApplyForwardFileRsp.str_ret_msg.has()) {}
      for (paramProtoResp = localApplyForwardFileRsp.str_ret_msg.get();; paramProtoResp = null)
      {
        if (localApplyForwardFileRsp.bytes_uuid.has()) {}
        for (localObject1 = new String(localApplyForwardFileRsp.bytes_uuid.get().toByteArray());; localObject1 = null)
        {
          localObject2 = localObject3;
          if (bool1)
          {
            localObject2 = localObject3;
            if (localApplyForwardFileRsp.str_fileidcrc.has()) {
              localObject2 = localApplyForwardFileRsp.str_fileidcrc.get();
            }
          }
          if (localApplyForwardFileRsp.uint64_total_space.has()) {}
          for (l1 = localApplyForwardFileRsp.uint64_total_space.get();; l1 = 0L)
          {
            if (localApplyForwardFileRsp.uint64_used_space.has()) {
              l2 = localApplyForwardFileRsp.uint64_used_space.get();
            }
            bool1 = bool2;
            break;
            bool1 = false;
            break label295;
            QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: bUseMediaPlatform false uint32_flag_use_media_platform not set");
            bool1 = false;
            break label321;
          }
        }
      }
    }
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, atin paramatin, int paramInt1, int paramInt2, int paramInt3)
  {
    ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
    localProtoReq.ssoCmd = paramString;
    localProtoReq.reqBody = paramArrayOfByte;
    localProtoReq.busiData = paramatin;
    localProtoReq.tryTime = paramInt1;
    localProtoReq.tryCount = paramInt2;
    localProtoReq.fixScheduleCount = paramInt3;
    localProtoReq.callback = this;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().sendProtoReq(localProtoReq);
  }
  
  private void b(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    int i = -100003;
    boolean bool;
    if ((paramProtoResp.resp.getResultCode() == 1002) || (paramProtoResp.resp.getResultCode() == 1013))
    {
      i = -100001;
      QLog.i("ProtocolManager", 1, "onForwardOfflineToOther: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      localObject = null;
      paramProtoResp = null;
      bool = false;
    }
    for (;;)
    {
      if (i != 0) {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProtocolManager", 2, "onForwardOfflineToOther: return " + bool + ", retCode=" + i + ", retMsg=" + paramProtoResp);
      }
      ((atij)((atin)paramProtoReq.busiData).a()).a(bool, i, paramProtoResp, (String)localObject, null, 0L, 0L);
      return;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        i = -100002;
        QLog.i("ProtocolManager", 1, "onForwardOfflineToOther: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
        localObject = null;
        paramProtoResp = null;
        bool = false;
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localObject = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject).mergeFrom(paramProtoResp);
          if (((cmd0x346.RspBody)localObject).msg_apply_copy_to_rsp.has()) {
            break;
          }
          QLog.i("ProtocolManager", 1, "onForwardOfflineToOther rspBody has not hasMsgApplyDownloadAbsRsp");
          localObject = null;
          paramProtoResp = null;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          localObject = null;
          paramProtoResp = null;
          bool = false;
        }
      }
    }
    Object localObject = (cmd0x346.ApplyCopyToRsp)((cmd0x346.RspBody)localObject).msg_apply_copy_to_rsp.get();
    if (((cmd0x346.ApplyCopyToRsp)localObject).int32_ret_code.has()) {}
    for (i = ((cmd0x346.ApplyCopyToRsp)localObject).int32_ret_code.get();; i = 0)
    {
      if (((cmd0x346.ApplyCopyToRsp)localObject).str_ret_msg.has()) {}
      for (paramProtoResp = ((cmd0x346.ApplyCopyToRsp)localObject).str_ret_msg.get();; paramProtoResp = null)
      {
        if (((cmd0x346.ApplyCopyToRsp)localObject).str_file_key.has()) {}
        for (localObject = ((cmd0x346.ApplyCopyToRsp)localObject).str_file_key.get();; localObject = null)
        {
          bool = true;
          break;
        }
      }
    }
  }
  
  private void c(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    Object localObject1 = "";
    boolean bool;
    if ((paramProtoResp.resp.getResultCode() == 1002) || (paramProtoResp.resp.getResultCode() == 1013))
    {
      QLog.i("ProtocolManager", 1, "internalForwardDiscFile: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      paramProtoResp = null;
      bool = false;
    }
    for (int i = -100001;; i = -100002)
    {
      ((atij)((atin)paramProtoReq.busiData).a()).a(bool, i, (String)localObject1, paramProtoResp, null, 0L, 0L);
      return;
      if (paramProtoResp.resp.getResultCode() == 1000) {
        break;
      }
      QLog.i("ProtocolManager", 1, "internalForwardDiscFile: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
      paramProtoResp = null;
      bool = false;
    }
    Object localObject2 = paramProtoResp.resp.getWupBuffer();
    paramProtoResp = new cmd0x345.RspBody();
    for (;;)
    {
      try
      {
        paramProtoResp.mergeFrom((byte[])localObject2);
        if (!paramProtoResp.uint32_return_code.has()) {
          break label434;
        }
        i = paramProtoResp.uint32_return_code.get();
        if ((paramProtoResp.msg_subcmd_0x6_rsp_body.has()) || (paramProtoResp.msg_subcmd_0x5_rsp_body.has())) {
          break label258;
        }
        QLog.i("ProtocolManager", 1, "internalForwardDiscFile: rspBody has not hasMsgApplyDownloadRsp");
        bool = false;
        i = -100003;
        paramProtoResp = null;
      }
      catch (InvalidProtocolBufferMicroException paramProtoResp)
      {
        paramProtoResp.printStackTrace();
        bool = false;
        i = -100003;
        paramProtoResp = null;
      }
      break;
      label258:
      if (paramProtoResp.msg_subcmd_0x6_rsp_body.has())
      {
        localObject1 = (cmd0x345.RspBody.SubCmd0x6RspBody)paramProtoResp.msg_subcmd_0x6_rsp_body.get();
        if (!((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_ret_msg.has()) {
          break label428;
        }
      }
      label428:
      for (paramProtoResp = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_ret_msg.get();; paramProtoResp = "")
      {
        if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_file_id.has()) {
          localObject1 = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_file_id.get();
        }
        for (;;)
        {
          localObject2 = localObject1;
          bool = true;
          localObject1 = paramProtoResp;
          paramProtoResp = (ProtoReqManager.ProtoResp)localObject2;
          break;
          localObject2 = localObject1;
          if (paramProtoResp.msg_subcmd_0x5_rsp_body.has())
          {
            cmd0x345.RspBody.SubCmd0x5RspBody localSubCmd0x5RspBody = (cmd0x345.RspBody.SubCmd0x5RspBody)paramProtoResp.msg_subcmd_0x5_rsp_body.get();
            paramProtoResp = (ProtoReqManager.ProtoResp)localObject1;
            if (localSubCmd0x5RspBody.str_ret_msg.has()) {
              paramProtoResp = localSubCmd0x5RspBody.str_ret_msg.get();
            }
            localObject2 = paramProtoResp;
            if (localSubCmd0x5RspBody.str_file_id.has())
            {
              localObject1 = localSubCmd0x5RspBody.str_file_id.get();
              continue;
            }
          }
          localObject1 = null;
          paramProtoResp = (ProtoReqManager.ProtoResp)localObject2;
          continue;
          localObject1 = null;
        }
      }
      label434:
      i = 0;
    }
  }
  
  private void d(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    boolean bool = false;
    Object localObject = null;
    int i = -1;
    if ((paramProtoResp.resp.getResultCode() == 1002) || (paramProtoResp.resp.getResultCode() == 1013))
    {
      QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      i = -100001;
      paramProtoResp = localObject;
    }
    for (;;)
    {
      ((atik)((atin)paramProtoReq.busiData).a()).a(bool, i, paramProtoResp);
      return;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
        i = -100002;
        paramProtoResp = localObject;
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(paramProtoResp);
          if (localRspBody.msg_apply_upload_rsp_v3.has()) {
            break label224;
          }
          QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
          i = -100003;
          paramProtoResp = localObject;
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          i = -100003;
          paramProtoResp = localObject;
        }
        continue;
        label224:
        paramProtoResp = (cmd0x346.ApplyUploadRspV3)localRspBody.msg_apply_upload_rsp_v3.get();
        bool = true;
      }
    }
  }
  
  private void e(ProtoReqManager.ProtoReq paramProtoReq, ProtoReqManager.ProtoResp paramProtoResp)
  {
    boolean bool = false;
    int i = -1;
    String str = "";
    if ((paramProtoResp.resp.getResultCode() == 1002) || (paramProtoResp.resp.getResultCode() == 1013))
    {
      i = -100001;
      QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: resp is timeout[" + paramProtoResp.resp.getResultCode() + "]");
      paramProtoResp = str;
    }
    cmd0x346.RspBody localRspBody;
    for (;;)
    {
      if (paramProtoReq.busiData != null) {
        ((atil)((atin)paramProtoReq.busiData).a()).a(bool, i, paramProtoResp);
      }
      return;
      if (paramProtoResp.resp.getResultCode() != 1000)
      {
        i = -100002;
        QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: resp is failed[" + paramProtoResp.resp.getResultCode() + "]");
        paramProtoResp = str;
      }
      else
      {
        paramProtoResp = paramProtoResp.resp.getWupBuffer();
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(paramProtoResp);
          if (localRspBody.msg_upload_succ_rsp.has()) {
            break;
          }
          QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
          i = -100003;
          paramProtoResp = str;
        }
        catch (InvalidProtocolBufferMicroException paramProtoResp)
        {
          paramProtoResp.printStackTrace();
          i = -100003;
          paramProtoResp = str;
        }
      }
    }
    paramProtoResp = (cmd0x346.UploadSuccRsp)localRspBody.msg_upload_succ_rsp.get();
    if (paramProtoResp.int32_ret_code.has()) {
      i = paramProtoResp.int32_ret_code.get();
    }
    if (paramProtoResp.str_ret_msg.has()) {}
    for (paramProtoResp = paramProtoResp.str_ret_msg.get();; paramProtoResp = "")
    {
      bool = true;
      break;
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, atio paramatio, int paramInt3, int paramInt4, atij paramatij)
  {
    cmd0x345.ReqBody.SubCmd0x6ReqBody localSubCmd0x6ReqBody = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
    localSubCmd0x6ReqBody.uint32_dst_bus_id.set(paramInt2);
    localSubCmd0x6ReqBody.uint64_file_size.set(paramatio.jdField_a_of_type_Long);
    localSubCmd0x6ReqBody.bytes_uuid.set(ByteStringMicro.copyFrom(paramatio.b.getBytes()));
    if (!TextUtils.isEmpty(paramatio.c)) {
      localSubCmd0x6ReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(paramatio.c.getBytes()));
    }
    localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramString2));
    paramString2 = paramString1.replace("+", "");
    localSubCmd0x6ReqBody.uint64_dst_uin.set(Long.parseLong(paramString2));
    localSubCmd0x6ReqBody.str_file_name.set(paramatio.jdField_a_of_type_JavaLangString);
    localSubCmd0x6ReqBody.str_src_file_path.set(paramatio.b);
    localSubCmd0x6ReqBody.str_src_parent_folder.set("/");
    localSubCmd0x6ReqBody.uint32_client_type.set(104);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localSubCmd0x6ReqBody.uint64_app_id.set(3L);
      localSubCmd0x6ReqBody.uint64_talk_type.set(paramInt1);
      paramString1 = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt1);
      if (paramString1 != null) {
        localSubCmd0x6ReqBody.bytes_sig.set(ByteStringMicro.copyFrom(paramString1));
      }
      if (QLog.isColorLevel()) {
        QLog.i("ProtocolManager", 2, "forwardDiscToOther : add tempinfo SessionType[" + paramInt1 + "]");
      }
    }
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x6_req_body.set(localSubCmd0x6ReqBody);
    paramString1.uint32_sub_cmd.set(7);
    paramString2 = new atin(this, paramatij);
    paramString2.a(7);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, paramInt3, paramInt4, 1);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, atij paramatij)
  {
    cmd0x346.ApplyForwardFileReq localApplyForwardFileReq = new cmd0x346.ApplyForwardFileReq();
    localApplyForwardFileReq.uint64_sender_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    Object localObject = paramString1.replace("+", "");
    localApplyForwardFileReq.uint64_recver_uin.set(Long.parseLong((String)localObject));
    localApplyForwardFileReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_apply_forward_file_req.set(localApplyForwardFileReq);
    paramString1.uint32_cmd.set(700);
    paramString2 = paramString1.uint32_seq;
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    paramString2.set(i);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    if (paramInt1 != 0)
    {
      paramString2 = new cmd0x346.ExtensionReq();
      paramString2.uint64_id.set(3L);
      paramString2.uint64_type.set(paramInt1);
      localObject = auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, paramInt1);
      if (localObject != null) {
        paramString2.bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      paramString1.msg_extension_req.set(paramString2);
      if (QLog.isColorLevel()) {
        QLog.i("ProtocolManager", 2, "forwardOfflineFileToBuddy : add tempinfo SessionType[" + paramInt1 + "]");
      }
    }
    if (((atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER)).h())
    {
      paramString1.uint32_flag_support_mediaplatform.set(1);
      if ((paramString3 != null) && (paramString3.length() > 0))
      {
        localApplyForwardFileReq.str_fileidcrc.set(paramString3);
        QLog.d("ProtocolManager", 1, "forwardOfflineFileToBuddy: UseMediaPlatform enabled");
      }
    }
    for (;;)
    {
      paramString2 = new atin(this, paramatij);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700", paramString1.toByteArray(), paramString2, paramInt2, paramInt3, 1);
      return;
      QLog.d("ProtocolManager", 1, "forwardOfflineFileToBuddy: UseMediaPlatform enabled but FileIdCrc is null");
      continue;
      QLog.d("ProtocolManager", 1, "forwardOfflineFileToBuddy: UseMediaPlatform not enabled");
    }
  }
  
  public void a(String paramString1, String paramString2, atio paramatio, int paramInt1, int paramInt2, int paramInt3, atij paramatij)
  {
    cmd0x346.ApplyCopyToReq localApplyCopyToReq = new cmd0x346.ApplyCopyToReq();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount().replace("+", "");
    localApplyCopyToReq.uint64_dst_id.set(Long.parseLong(str));
    if ((paramInt1 == 106) || (paramInt1 == 102) || (paramInt1 == 104))
    {
      paramString2 = paramString2.replace("+", "");
      localApplyCopyToReq.uint64_dst_id.set(Long.parseLong(paramString2));
    }
    localApplyCopyToReq.uint32_dst_svcid.set(paramInt1);
    localApplyCopyToReq.uint64_src_uin.set(Long.parseLong(str));
    localApplyCopyToReq.uint64_file_size.set(paramatio.jdField_a_of_type_Long);
    localApplyCopyToReq.str_file_name.set(paramatio.jdField_a_of_type_JavaLangString);
    localApplyCopyToReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    paramString1 = new cmd0x346.ReqBody();
    paramString1.msg_apply_copy_to_req.set(localApplyCopyToReq);
    paramString1.uint32_cmd.set(60100);
    paramString2 = paramString1.uint32_seq;
    paramInt1 = jdField_a_of_type_Int;
    jdField_a_of_type_Int = paramInt1 + 1;
    paramString2.set(paramInt1);
    paramString1.uint32_business_id.set(3);
    paramString1.uint32_client_type.set(104);
    paramString2 = new atin(this, paramatij);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", paramString1.toByteArray(), paramString2, paramInt2, paramInt3, 1);
  }
  
  public void a(String paramString1, String paramString2, atio paramatio, atij paramatij)
  {
    cmd0x345.ReqBody.SubCmd0x5ReqBody localSubCmd0x5ReqBody = new cmd0x345.ReqBody.SubCmd0x5ReqBody();
    localSubCmd0x5ReqBody.uint32_src_bus_id.set(106);
    localSubCmd0x5ReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom("/".getBytes()));
    localSubCmd0x5ReqBody.bytes_src_file_path.set(ByteStringMicro.copyFrom(paramatio.b.getBytes()));
    localSubCmd0x5ReqBody.uint32_dst_uin.set(Integer.parseInt(paramString1));
    localSubCmd0x5ReqBody.uint64_file_size.set(paramatio.jdField_a_of_type_Long);
    localSubCmd0x5ReqBody.uint32_from_uin.set(Integer.parseInt(paramString2));
    localSubCmd0x5ReqBody.str_file_name.set(paramatio.jdField_a_of_type_JavaLangString);
    if ((paramatio.c != null) && (paramatio.c.length() > 0)) {
      localSubCmd0x5ReqBody.bytes_md5.set(ByteStringMicro.copyFrom(paramatio.c.getBytes()));
    }
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x5_req_body.set(localSubCmd0x5ReqBody);
    paramString1.uint32_sub_cmd.set(6);
    paramString2 = new atin(this, paramatij);
    paramString2.a(6);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, atik paramatik)
  {
    long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(1700);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    Object localObject = localReqBody.uint32_seq;
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    ((PBUInt32Field)localObject).set(i);
    localObject = new cmd0x346.ApplyUploadReqV3();
    ((cmd0x346.ApplyUploadReqV3)localObject).uint64_sender_uin.set(l);
    ((cmd0x346.ApplyUploadReqV3)localObject).uint64_recver_uin.set(Long.parseLong(paramString1));
    ((cmd0x346.ApplyUploadReqV3)localObject).uint64_file_size.set(paramLong);
    ((cmd0x346.ApplyUploadReqV3)localObject).str_file_name.set(new String(paramString3));
    ((cmd0x346.ApplyUploadReqV3)localObject).bytes_10m_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte1));
    ((cmd0x346.ApplyUploadReqV3)localObject).bytes_sha.set(ByteStringMicro.copyFrom(paramArrayOfByte2));
    ((cmd0x346.ApplyUploadReqV3)localObject).str_local_filepath.set(paramString2);
    ((cmd0x346.ApplyUploadReqV3)localObject).uint32_danger_level.set(0);
    ((cmd0x346.ApplyUploadReqV3)localObject).uint64_total_space.set(0L);
    localReqBody.msg_apply_upload_req_v3.set((MessageMicro)localObject);
    localReqBody.setHasFlag(true);
    paramString1 = new atin(this, paramatik);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700", localReqBody.toByteArray(), paramString1, paramInt1, paramInt2, 1);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, atil paramatil)
  {
    cmd0x346.UploadSuccReq localUploadSuccReq = new cmd0x346.UploadSuccReq();
    localUploadSuccReq.uint64_sender_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    paramString = paramString.replace("+", "");
    localUploadSuccReq.uint64_recver_uin.set(Long.parseLong(paramString));
    localUploadSuccReq.bytes_uuid.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramArrayOfByte = new cmd0x346.ReqBody();
    paramArrayOfByte.msg_upload_succ_req.set(localUploadSuccReq);
    paramArrayOfByte.uint32_cmd.set(800);
    paramString = paramArrayOfByte.uint32_seq;
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    paramString.set(i);
    paramArrayOfByte.uint32_business_id.set(3);
    paramArrayOfByte.uint32_client_type.set(104);
    paramString = null;
    if (paramatil != null) {
      paramString = new atin(this, paramatil);
    }
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800", paramArrayOfByte.toByteArray(), paramString, paramInt1, paramInt2, 1);
  }
  
  public void onProtoResp(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700".equals(paramProtoReq.ssoCmd)) {
      a(paramProtoReq, paramProtoResp);
    }
    for (;;)
    {
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800".equals(paramProtoReq.ssoCmd)) {
        e(paramProtoReq, paramProtoResp);
      }
      return;
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100".equals(paramProtoReq.ssoCmd))
      {
        b(paramProtoReq, paramProtoResp);
      }
      else if ("GTalkFileAppSvr.CMD_DISCUSS_FILE".equals(paramProtoReq.ssoCmd))
      {
        atin localatin = (atin)paramProtoReq.busiData;
        int i = localatin.a();
        if (i == 6) {
          c(paramProtoReq, paramProtoResp);
        } else if (i == 7) {
          c(paramProtoReq, paramProtoResp);
        } else {
          QLog.w("ProtocolManager", 1, "unspourt:" + localatin.a());
        }
      }
      else if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700".equals(paramProtoReq.ssoCmd))
      {
        d(paramProtoReq, paramProtoResp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atim
 * JD-Core Version:    0.7.0.1
 */