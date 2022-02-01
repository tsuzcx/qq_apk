import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
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

public class atrw
  implements bevw
{
  private static int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public atrw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(bevx parambevx, bevy parambevy)
  {
    long l2 = 0L;
    int i = -100003;
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool2 = true;
    long l1;
    Object localObject1;
    boolean bool1;
    if ((parambevy.a.getResultCode() == 1002) || (parambevy.a.getResultCode() == 1013))
    {
      i = -100001;
      QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: resp is timeout[" + parambevy.a.getResultCode() + "]");
      l1 = 0L;
      localObject1 = null;
      parambevy = null;
      bool1 = false;
    }
    for (;;)
    {
      if (i != 0) {
        bool1 = false;
      }
      ((atrt)((atrx)parambevx.jdField_a_of_type_JavaLangObject).a()).a(bool1, i, parambevy, (String)localObject1, (String)localObject2, l1, l2);
      return;
      if (parambevy.a.getResultCode() != 1000)
      {
        i = -100002;
        QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: resp is failed[" + parambevy.a.getResultCode() + "]");
        l1 = 0L;
        localObject1 = null;
        parambevy = null;
        bool1 = false;
      }
      else
      {
        parambevy = parambevy.a.getWupBuffer();
        localObject1 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject1).mergeFrom(parambevy);
          if (((cmd0x346.RspBody)localObject1).msg_apply_forward_file_rsp.has()) {
            break;
          }
          QLog.i("ProtocolManager", 1, "onForwardOfflineResponse rspBody has not hasMsgApplyForwardFileRsp");
          l1 = 0L;
          localObject1 = null;
          parambevy = null;
          bool1 = false;
        }
        catch (InvalidProtocolBufferMicroException parambevy)
        {
          parambevy.printStackTrace();
          l1 = 0L;
          localObject1 = null;
          parambevy = null;
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
      for (parambevy = localApplyForwardFileRsp.str_ret_msg.get();; parambevy = null)
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
  
  private void a(String paramString, byte[] paramArrayOfByte, atrx paramatrx, int paramInt1, int paramInt2, int paramInt3)
  {
    bevx localbevx = new bevx();
    localbevx.jdField_a_of_type_JavaLangString = paramString;
    localbevx.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localbevx.jdField_a_of_type_JavaLangObject = paramatrx;
    localbevx.jdField_a_of_type_Int = paramInt1;
    localbevx.b = paramInt2;
    localbevx.c = paramInt3;
    localbevx.jdField_a_of_type_Bevw = this;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localbevx);
  }
  
  private void b(bevx parambevx, bevy parambevy)
  {
    int i = -100003;
    boolean bool;
    if ((parambevy.a.getResultCode() == 1002) || (parambevy.a.getResultCode() == 1013))
    {
      i = -100001;
      QLog.i("ProtocolManager", 1, "onForwardOfflineToOther: resp is timeout[" + parambevy.a.getResultCode() + "]");
      localObject = null;
      parambevy = null;
      bool = false;
    }
    for (;;)
    {
      if (i != 0) {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProtocolManager", 2, "onForwardOfflineToOther: return " + bool + ", retCode=" + i + ", retMsg=" + parambevy);
      }
      ((atrt)((atrx)parambevx.jdField_a_of_type_JavaLangObject).a()).a(bool, i, parambevy, (String)localObject, null, 0L, 0L);
      return;
      if (parambevy.a.getResultCode() != 1000)
      {
        i = -100002;
        QLog.i("ProtocolManager", 1, "onForwardOfflineToOther: resp is failed[" + parambevy.a.getResultCode() + "]");
        localObject = null;
        parambevy = null;
        bool = false;
      }
      else
      {
        parambevy = parambevy.a.getWupBuffer();
        localObject = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject).mergeFrom(parambevy);
          if (((cmd0x346.RspBody)localObject).msg_apply_copy_to_rsp.has()) {
            break;
          }
          QLog.i("ProtocolManager", 1, "onForwardOfflineToOther rspBody has not hasMsgApplyDownloadAbsRsp");
          localObject = null;
          parambevy = null;
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException parambevy)
        {
          parambevy.printStackTrace();
          localObject = null;
          parambevy = null;
          bool = false;
        }
      }
    }
    Object localObject = (cmd0x346.ApplyCopyToRsp)((cmd0x346.RspBody)localObject).msg_apply_copy_to_rsp.get();
    if (((cmd0x346.ApplyCopyToRsp)localObject).int32_ret_code.has()) {}
    for (i = ((cmd0x346.ApplyCopyToRsp)localObject).int32_ret_code.get();; i = 0)
    {
      if (((cmd0x346.ApplyCopyToRsp)localObject).str_ret_msg.has()) {}
      for (parambevy = ((cmd0x346.ApplyCopyToRsp)localObject).str_ret_msg.get();; parambevy = null)
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
  
  private void c(bevx parambevx, bevy parambevy)
  {
    Object localObject1 = "";
    boolean bool;
    if ((parambevy.a.getResultCode() == 1002) || (parambevy.a.getResultCode() == 1013))
    {
      QLog.i("ProtocolManager", 1, "internalForwardDiscFile: resp is timeout[" + parambevy.a.getResultCode() + "]");
      parambevy = null;
      bool = false;
    }
    for (int i = -100001;; i = -100002)
    {
      ((atrt)((atrx)parambevx.jdField_a_of_type_JavaLangObject).a()).a(bool, i, (String)localObject1, parambevy, null, 0L, 0L);
      return;
      if (parambevy.a.getResultCode() == 1000) {
        break;
      }
      QLog.i("ProtocolManager", 1, "internalForwardDiscFile: resp is failed[" + parambevy.a.getResultCode() + "]");
      parambevy = null;
      bool = false;
    }
    Object localObject2 = parambevy.a.getWupBuffer();
    parambevy = new cmd0x345.RspBody();
    for (;;)
    {
      try
      {
        parambevy.mergeFrom((byte[])localObject2);
        if (!parambevy.uint32_return_code.has()) {
          break label434;
        }
        i = parambevy.uint32_return_code.get();
        if ((parambevy.msg_subcmd_0x6_rsp_body.has()) || (parambevy.msg_subcmd_0x5_rsp_body.has())) {
          break label258;
        }
        QLog.i("ProtocolManager", 1, "internalForwardDiscFile: rspBody has not hasMsgApplyDownloadRsp");
        bool = false;
        i = -100003;
        parambevy = null;
      }
      catch (InvalidProtocolBufferMicroException parambevy)
      {
        parambevy.printStackTrace();
        bool = false;
        i = -100003;
        parambevy = null;
      }
      break;
      label258:
      if (parambevy.msg_subcmd_0x6_rsp_body.has())
      {
        localObject1 = (cmd0x345.RspBody.SubCmd0x6RspBody)parambevy.msg_subcmd_0x6_rsp_body.get();
        if (!((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_ret_msg.has()) {
          break label428;
        }
      }
      label428:
      for (parambevy = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_ret_msg.get();; parambevy = "")
      {
        if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_file_id.has()) {
          localObject1 = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_file_id.get();
        }
        for (;;)
        {
          localObject2 = localObject1;
          bool = true;
          localObject1 = parambevy;
          parambevy = (bevy)localObject2;
          break;
          localObject2 = localObject1;
          if (parambevy.msg_subcmd_0x5_rsp_body.has())
          {
            cmd0x345.RspBody.SubCmd0x5RspBody localSubCmd0x5RspBody = (cmd0x345.RspBody.SubCmd0x5RspBody)parambevy.msg_subcmd_0x5_rsp_body.get();
            parambevy = (bevy)localObject1;
            if (localSubCmd0x5RspBody.str_ret_msg.has()) {
              parambevy = localSubCmd0x5RspBody.str_ret_msg.get();
            }
            localObject2 = parambevy;
            if (localSubCmd0x5RspBody.str_file_id.has())
            {
              localObject1 = localSubCmd0x5RspBody.str_file_id.get();
              continue;
            }
          }
          localObject1 = null;
          parambevy = (bevy)localObject2;
          continue;
          localObject1 = null;
        }
      }
      label434:
      i = 0;
    }
  }
  
  private void d(bevx parambevx, bevy parambevy)
  {
    boolean bool = false;
    Object localObject = null;
    int i = -1;
    if ((parambevy.a.getResultCode() == 1002) || (parambevy.a.getResultCode() == 1013))
    {
      QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is timeout[" + parambevy.a.getResultCode() + "]");
      i = -100001;
      parambevy = localObject;
    }
    for (;;)
    {
      ((atru)((atrx)parambevx.jdField_a_of_type_JavaLangObject).a()).a(bool, i, parambevy);
      return;
      if (parambevy.a.getResultCode() != 1000)
      {
        QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is failed[" + parambevy.a.getResultCode() + "]");
        i = -100002;
        parambevy = localObject;
      }
      else
      {
        parambevy = parambevy.a.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(parambevy);
          if (localRspBody.msg_apply_upload_rsp_v3.has()) {
            break label224;
          }
          QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
          i = -100003;
          parambevy = localObject;
        }
        catch (InvalidProtocolBufferMicroException parambevy)
        {
          parambevy.printStackTrace();
          i = -100003;
          parambevy = localObject;
        }
        continue;
        label224:
        parambevy = (cmd0x346.ApplyUploadRspV3)localRspBody.msg_apply_upload_rsp_v3.get();
        bool = true;
      }
    }
  }
  
  private void e(bevx parambevx, bevy parambevy)
  {
    boolean bool = false;
    int i = -1;
    String str = "";
    if ((parambevy.a.getResultCode() == 1002) || (parambevy.a.getResultCode() == 1013))
    {
      i = -100001;
      QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: resp is timeout[" + parambevy.a.getResultCode() + "]");
      parambevy = str;
    }
    cmd0x346.RspBody localRspBody;
    for (;;)
    {
      if (parambevx.jdField_a_of_type_JavaLangObject != null) {
        ((atrv)((atrx)parambevx.jdField_a_of_type_JavaLangObject).a()).a(bool, i, parambevy);
      }
      return;
      if (parambevy.a.getResultCode() != 1000)
      {
        i = -100002;
        QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: resp is failed[" + parambevy.a.getResultCode() + "]");
        parambevy = str;
      }
      else
      {
        parambevy = parambevy.a.getWupBuffer();
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(parambevy);
          if (localRspBody.msg_upload_succ_rsp.has()) {
            break;
          }
          QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
          i = -100003;
          parambevy = str;
        }
        catch (InvalidProtocolBufferMicroException parambevy)
        {
          parambevy.printStackTrace();
          i = -100003;
          parambevy = str;
        }
      }
    }
    parambevy = (cmd0x346.UploadSuccRsp)localRspBody.msg_upload_succ_rsp.get();
    if (parambevy.int32_ret_code.has()) {
      i = parambevy.int32_ret_code.get();
    }
    if (parambevy.str_ret_msg.has()) {}
    for (parambevy = parambevy.str_ret_msg.get();; parambevy = "")
    {
      bool = true;
      break;
    }
  }
  
  public void a(bevy parambevy, bevx parambevx)
  {
    if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700".equals(parambevx.jdField_a_of_type_JavaLangString)) {
      a(parambevx, parambevy);
    }
    for (;;)
    {
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800".equals(parambevx.jdField_a_of_type_JavaLangString)) {
        e(parambevx, parambevy);
      }
      return;
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100".equals(parambevx.jdField_a_of_type_JavaLangString))
      {
        b(parambevx, parambevy);
      }
      else if ("GTalkFileAppSvr.CMD_DISCUSS_FILE".equals(parambevx.jdField_a_of_type_JavaLangString))
      {
        atrx localatrx = (atrx)parambevx.jdField_a_of_type_JavaLangObject;
        int i = localatrx.a();
        if (i == 6) {
          c(parambevx, parambevy);
        } else if (i == 7) {
          c(parambevx, parambevy);
        } else {
          QLog.w("ProtocolManager", 1, "unspourt:" + localatrx.a());
        }
      }
      else if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700".equals(parambevx.jdField_a_of_type_JavaLangString))
      {
        d(parambevx, parambevy);
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, atry paramatry, int paramInt3, int paramInt4, atrt paramatrt)
  {
    cmd0x345.ReqBody.SubCmd0x6ReqBody localSubCmd0x6ReqBody = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
    localSubCmd0x6ReqBody.uint32_dst_bus_id.set(paramInt2);
    localSubCmd0x6ReqBody.uint64_file_size.set(paramatry.jdField_a_of_type_Long);
    localSubCmd0x6ReqBody.bytes_uuid.set(ByteStringMicro.copyFrom(paramatry.b.getBytes()));
    if (!TextUtils.isEmpty(paramatry.c)) {
      localSubCmd0x6ReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(paramatry.c.getBytes()));
    }
    localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramString2));
    paramString2 = paramString1.replace("+", "");
    localSubCmd0x6ReqBody.uint64_dst_uin.set(Long.parseLong(paramString2));
    localSubCmd0x6ReqBody.str_file_name.set(paramatry.jdField_a_of_type_JavaLangString);
    localSubCmd0x6ReqBody.str_src_file_path.set(paramatry.b);
    localSubCmd0x6ReqBody.str_src_parent_folder.set("/");
    localSubCmd0x6ReqBody.uint32_client_type.set(104);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localSubCmd0x6ReqBody.uint64_app_id.set(3L);
      localSubCmd0x6ReqBody.uint64_talk_type.set(paramInt1);
      paramString1 = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt1);
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
    paramString2 = new atrx(this, paramatrt);
    paramString2.a(7);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, paramInt3, paramInt4, 1);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, atrt paramatrt)
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
      localObject = aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, paramInt1);
      if (localObject != null) {
        paramString2.bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      paramString1.msg_extension_req.set(paramString2);
      if (QLog.isColorLevel()) {
        QLog.i("ProtocolManager", 2, "forwardOfflineFileToBuddy : add tempinfo SessionType[" + paramInt1 + "]");
      }
    }
    if (((atsh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).h())
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
      paramString2 = new atrx(this, paramatrt);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700", paramString1.toByteArray(), paramString2, paramInt2, paramInt3, 1);
      return;
      QLog.d("ProtocolManager", 1, "forwardOfflineFileToBuddy: UseMediaPlatform enabled but FileIdCrc is null");
      continue;
      QLog.d("ProtocolManager", 1, "forwardOfflineFileToBuddy: UseMediaPlatform not enabled");
    }
  }
  
  public void a(String paramString1, String paramString2, atry paramatry, int paramInt1, int paramInt2, int paramInt3, atrt paramatrt)
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
    localApplyCopyToReq.uint64_file_size.set(paramatry.jdField_a_of_type_Long);
    localApplyCopyToReq.str_file_name.set(paramatry.jdField_a_of_type_JavaLangString);
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
    paramString2 = new atrx(this, paramatrt);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", paramString1.toByteArray(), paramString2, paramInt2, paramInt3, 1);
  }
  
  public void a(String paramString1, String paramString2, atry paramatry, atrt paramatrt)
  {
    cmd0x345.ReqBody.SubCmd0x5ReqBody localSubCmd0x5ReqBody = new cmd0x345.ReqBody.SubCmd0x5ReqBody();
    localSubCmd0x5ReqBody.uint32_src_bus_id.set(106);
    localSubCmd0x5ReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom("/".getBytes()));
    localSubCmd0x5ReqBody.bytes_src_file_path.set(ByteStringMicro.copyFrom(paramatry.b.getBytes()));
    localSubCmd0x5ReqBody.uint32_dst_uin.set(Integer.parseInt(paramString1));
    localSubCmd0x5ReqBody.uint64_file_size.set(paramatry.jdField_a_of_type_Long);
    localSubCmd0x5ReqBody.uint32_from_uin.set(Integer.parseInt(paramString2));
    localSubCmd0x5ReqBody.str_file_name.set(paramatry.jdField_a_of_type_JavaLangString);
    if ((paramatry.c != null) && (paramatry.c.length() > 0)) {
      localSubCmd0x5ReqBody.bytes_md5.set(ByteStringMicro.copyFrom(paramatry.c.getBytes()));
    }
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x5_req_body.set(localSubCmd0x5ReqBody);
    paramString1.uint32_sub_cmd.set(6);
    paramString2 = new atrx(this, paramatrt);
    paramString2.a(6);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, atru paramatru)
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
    paramString1 = new atrx(this, paramatru);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700", localReqBody.toByteArray(), paramString1, paramInt1, paramInt2, 1);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, atrv paramatrv)
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
    if (paramatrv != null) {
      paramString = new atrx(this, paramatrv);
    }
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800", paramArrayOfByte.toByteArray(), paramString, paramInt1, paramInt2, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atrw
 * JD-Core Version:    0.7.0.1
 */