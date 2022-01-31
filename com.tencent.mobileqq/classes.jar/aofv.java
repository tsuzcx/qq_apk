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

public class aofv
  implements axta
{
  private static int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString = "ProtocolManager";
  
  public aofv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(axtb paramaxtb, axtc paramaxtc)
  {
    long l2 = 0L;
    Object localObject2 = null;
    Object localObject1 = null;
    int i = -100003;
    boolean bool2 = false;
    long l1;
    boolean bool1;
    if ((paramaxtc.a.getResultCode() == 1002) || (paramaxtc.a.getResultCode() == 1013))
    {
      i = -100001;
      QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: resp is timeout[" + paramaxtc.a.getResultCode() + "]");
      l1 = 0L;
      paramaxtc = null;
      bool1 = false;
    }
    label96:
    Object localObject3;
    while (i != 0)
    {
      bool1 = bool2;
      ((aoft)((aofx)paramaxtb.jdField_a_of_type_JavaLangObject).a()).a(bool1, i, (String)localObject1, paramaxtc, l1, l2);
      return;
      if (paramaxtc.a.getResultCode() != 1000)
      {
        i = -100002;
        QLog.i("ProtocolManager", 1, "onForwardOfflineResponse: resp is failed[" + paramaxtc.a.getResultCode() + "]");
        l1 = 0L;
        paramaxtc = null;
        bool1 = false;
      }
      else
      {
        paramaxtc = paramaxtc.a.getWupBuffer();
        localObject3 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject3).mergeFrom(paramaxtc);
          if (((cmd0x346.RspBody)localObject3).msg_apply_forward_file_rsp.has()) {
            break label256;
          }
          QLog.i("ProtocolManager", 1, "onForwardOfflineResponse rspBody has not hasMsgApplyForwardFileRsp");
          l1 = 0L;
          paramaxtc = null;
          bool1 = false;
        }
        catch (InvalidProtocolBufferMicroException paramaxtc)
        {
          paramaxtc.printStackTrace();
          l1 = 0L;
          paramaxtc = null;
          bool1 = false;
        }
        continue;
        label256:
        localObject3 = (cmd0x346.ApplyForwardFileRsp)((cmd0x346.RspBody)localObject3).msg_apply_forward_file_rsp.get();
        if (!((cmd0x346.ApplyForwardFileRsp)localObject3).int32_ret_code.has()) {
          break label416;
        }
      }
    }
    label416:
    for (i = ((cmd0x346.ApplyForwardFileRsp)localObject3).int32_ret_code.get();; i = 0)
    {
      if (((cmd0x346.ApplyForwardFileRsp)localObject3).str_ret_msg.has()) {}
      for (paramaxtc = ((cmd0x346.ApplyForwardFileRsp)localObject3).str_ret_msg.get();; paramaxtc = null)
      {
        localObject1 = localObject2;
        if (((cmd0x346.ApplyForwardFileRsp)localObject3).bytes_uuid.has()) {
          localObject1 = new String(((cmd0x346.ApplyForwardFileRsp)localObject3).bytes_uuid.get().toByteArray());
        }
        if (((cmd0x346.ApplyForwardFileRsp)localObject3).uint64_total_space.has()) {}
        for (l1 = ((cmd0x346.ApplyForwardFileRsp)localObject3).uint64_total_space.get();; l1 = 0L)
        {
          if (((cmd0x346.ApplyForwardFileRsp)localObject3).uint64_used_space.has()) {
            l2 = ((cmd0x346.ApplyForwardFileRsp)localObject3).uint64_used_space.get();
          }
          bool1 = true;
          localObject2 = localObject1;
          localObject1 = paramaxtc;
          paramaxtc = localObject2;
          break;
          break label96;
        }
      }
    }
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, aofx paramaofx, int paramInt1, int paramInt2, int paramInt3)
  {
    axtb localaxtb = new axtb();
    localaxtb.jdField_a_of_type_JavaLangString = paramString;
    localaxtb.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localaxtb.jdField_a_of_type_JavaLangObject = paramaofx;
    localaxtb.jdField_a_of_type_Int = paramInt1;
    localaxtb.b = paramInt2;
    localaxtb.c = paramInt3;
    localaxtb.jdField_a_of_type_Axta = this;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager().a(localaxtb);
  }
  
  private void b(axtb paramaxtb, axtc paramaxtc)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = -100003;
    boolean bool2 = false;
    boolean bool1;
    if ((paramaxtc.a.getResultCode() == 1002) || (paramaxtc.a.getResultCode() == 1013))
    {
      i = -100001;
      QLog.i("ProtocolManager", 1, "onForwardOfflineToOther: resp is timeout[" + paramaxtc.a.getResultCode() + "]");
      paramaxtc = null;
      bool1 = false;
    }
    label90:
    Object localObject3;
    while (i != 0)
    {
      bool1 = bool2;
      if (QLog.isColorLevel()) {
        QLog.d("ProtocolManager", 2, "onForwardOfflineToOther: return " + bool1 + ", retCode=" + i + ", retMsg=" + (String)localObject1);
      }
      ((aoft)((aofx)paramaxtb.jdField_a_of_type_JavaLangObject).a()).a(bool1, i, (String)localObject1, paramaxtc, 0L, 0L);
      return;
      if (paramaxtc.a.getResultCode() != 1000)
      {
        i = -100002;
        QLog.i("ProtocolManager", 1, "onForwardOfflineToOther: resp is failed[" + paramaxtc.a.getResultCode() + "]");
        paramaxtc = null;
        bool1 = false;
      }
      else
      {
        paramaxtc = paramaxtc.a.getWupBuffer();
        localObject3 = new cmd0x346.RspBody();
        try
        {
          ((cmd0x346.RspBody)localObject3).mergeFrom(paramaxtc);
          if (((cmd0x346.RspBody)localObject3).msg_apply_copy_to_rsp.has()) {
            break label290;
          }
          QLog.i("ProtocolManager", 1, "onForwardOfflineToOther rspBody has not hasMsgApplyDownloadAbsRsp");
          paramaxtc = null;
          bool1 = false;
        }
        catch (InvalidProtocolBufferMicroException paramaxtc)
        {
          paramaxtc.printStackTrace();
          paramaxtc = null;
          bool1 = false;
        }
        continue;
        label290:
        localObject3 = (cmd0x346.ApplyCopyToRsp)((cmd0x346.RspBody)localObject3).msg_apply_copy_to_rsp.get();
        if (!((cmd0x346.ApplyCopyToRsp)localObject3).int32_ret_code.has()) {
          break label392;
        }
      }
    }
    label392:
    for (i = ((cmd0x346.ApplyCopyToRsp)localObject3).int32_ret_code.get();; i = 0)
    {
      if (((cmd0x346.ApplyCopyToRsp)localObject3).str_ret_msg.has()) {}
      for (paramaxtc = ((cmd0x346.ApplyCopyToRsp)localObject3).str_ret_msg.get();; paramaxtc = null)
      {
        localObject1 = localObject2;
        if (((cmd0x346.ApplyCopyToRsp)localObject3).str_file_key.has()) {
          localObject1 = ((cmd0x346.ApplyCopyToRsp)localObject3).str_file_key.get();
        }
        bool1 = true;
        localObject2 = localObject1;
        localObject1 = paramaxtc;
        paramaxtc = localObject2;
        break;
        break label90;
      }
    }
  }
  
  private void c(axtb paramaxtb, axtc paramaxtc)
  {
    boolean bool = false;
    String str = "";
    Object localObject2 = null;
    Object localObject1;
    if ((paramaxtc.a.getResultCode() == 1002) || (paramaxtc.a.getResultCode() == 1013))
    {
      QLog.i("ProtocolManager", 1, "internalForwardDiscFile: resp is timeout[" + paramaxtc.a.getResultCode() + "]");
      localObject1 = null;
      paramaxtc = "";
    }
    for (int i = -100001;; i = -100002)
    {
      ((aoft)((aofx)paramaxtb.jdField_a_of_type_JavaLangObject).a()).a(bool, i, paramaxtc, (String)localObject1, 0L, 0L);
      return;
      if (paramaxtc.a.getResultCode() == 1000) {
        break;
      }
      QLog.i("ProtocolManager", 1, "internalForwardDiscFile: resp is failed[" + paramaxtc.a.getResultCode() + "]");
      localObject1 = null;
      paramaxtc = "";
    }
    paramaxtc = paramaxtc.a.getWupBuffer();
    Object localObject3 = new cmd0x345.RspBody();
    for (;;)
    {
      try
      {
        ((cmd0x345.RspBody)localObject3).mergeFrom(paramaxtc);
        if (!((cmd0x345.RspBody)localObject3).uint32_return_code.has()) {
          break label440;
        }
        i = ((cmd0x345.RspBody)localObject3).uint32_return_code.get();
        if ((((cmd0x345.RspBody)localObject3).msg_subcmd_0x6_rsp_body.has()) || (((cmd0x345.RspBody)localObject3).msg_subcmd_0x5_rsp_body.has())) {
          break label271;
        }
        QLog.i("ProtocolManager", 1, "internalForwardDiscFile: rspBody has not hasMsgApplyDownloadRsp");
        paramaxtc = "";
        i = -100003;
        localObject1 = null;
      }
      catch (InvalidProtocolBufferMicroException paramaxtc)
      {
        paramaxtc.printStackTrace();
        paramaxtc = "";
        i = -100003;
        localObject1 = null;
      }
      break;
      label271:
      if (((cmd0x345.RspBody)localObject3).msg_subcmd_0x6_rsp_body.has())
      {
        localObject1 = (cmd0x345.RspBody.SubCmd0x6RspBody)((cmd0x345.RspBody)localObject3).msg_subcmd_0x6_rsp_body.get();
        if (!((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_ret_msg.has()) {
          break label434;
        }
      }
      label434:
      for (paramaxtc = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_ret_msg.get();; paramaxtc = "")
      {
        if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_file_id.has()) {
          localObject1 = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject1).str_file_id.get();
        }
        for (;;)
        {
          bool = true;
          break;
          paramaxtc = str;
          localObject1 = localObject2;
          if (((cmd0x345.RspBody)localObject3).msg_subcmd_0x5_rsp_body.has())
          {
            localObject3 = (cmd0x345.RspBody.SubCmd0x5RspBody)((cmd0x345.RspBody)localObject3).msg_subcmd_0x5_rsp_body.get();
            if (((cmd0x345.RspBody.SubCmd0x5RspBody)localObject3).str_ret_msg.has()) {
              str = ((cmd0x345.RspBody.SubCmd0x5RspBody)localObject3).str_ret_msg.get();
            }
            paramaxtc = str;
            localObject1 = localObject2;
            if (((cmd0x345.RspBody.SubCmd0x5RspBody)localObject3).str_file_id.has())
            {
              localObject1 = ((cmd0x345.RspBody.SubCmd0x5RspBody)localObject3).str_file_id.get();
              paramaxtc = str;
              continue;
              localObject1 = null;
            }
          }
        }
      }
      label440:
      i = 0;
    }
  }
  
  private void d(axtb paramaxtb, axtc paramaxtc)
  {
    boolean bool = false;
    Object localObject = null;
    int i = -1;
    if ((paramaxtc.a.getResultCode() == 1002) || (paramaxtc.a.getResultCode() == 1013))
    {
      QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is timeout[" + paramaxtc.a.getResultCode() + "]");
      i = -100001;
      paramaxtc = localObject;
    }
    for (;;)
    {
      ((aofu)((aofx)paramaxtb.jdField_a_of_type_JavaLangObject).a()).a(bool, i, paramaxtc);
      return;
      if (paramaxtc.a.getResultCode() != 1000)
      {
        QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: resp is failed[" + paramaxtc.a.getResultCode() + "]");
        i = -100002;
        paramaxtc = localObject;
      }
      else
      {
        paramaxtc = paramaxtc.a.getWupBuffer();
        cmd0x346.RspBody localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(paramaxtc);
          if (localRspBody.msg_apply_upload_rsp_v3.has()) {
            break label224;
          }
          QLog.i("ProtocolManager", 1, "=_= ^! [CS Replay]handleUploadResponse: rspBody has not hasMsgApplyUploadRsp");
          i = -100003;
          paramaxtc = localObject;
        }
        catch (InvalidProtocolBufferMicroException paramaxtc)
        {
          paramaxtc.printStackTrace();
          i = -100003;
          paramaxtc = localObject;
        }
        continue;
        label224:
        paramaxtc = (cmd0x346.ApplyUploadRspV3)localRspBody.msg_apply_upload_rsp_v3.get();
        bool = true;
      }
    }
  }
  
  private void e(axtb paramaxtb, axtc paramaxtc)
  {
    boolean bool = false;
    int i = -1;
    String str = "";
    if ((paramaxtc.a.getResultCode() == 1002) || (paramaxtc.a.getResultCode() == 1013))
    {
      i = -100001;
      QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: resp is timeout[" + paramaxtc.a.getResultCode() + "]");
      paramaxtc = str;
    }
    cmd0x346.RspBody localRspBody;
    for (;;)
    {
      if (paramaxtb.jdField_a_of_type_JavaLangObject != null) {
        ((aofs)((aofx)paramaxtb.jdField_a_of_type_JavaLangObject).a()).a(bool, i, paramaxtc);
      }
      return;
      if (paramaxtc.a.getResultCode() != 1000)
      {
        i = -100002;
        QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: resp is failed[" + paramaxtc.a.getResultCode() + "]");
        paramaxtc = str;
      }
      else
      {
        paramaxtc = paramaxtc.a.getWupBuffer();
        localRspBody = new cmd0x346.RspBody();
        try
        {
          localRspBody.mergeFrom(paramaxtc);
          if (localRspBody.msg_upload_succ_rsp.has()) {
            break;
          }
          QLog.i("ProtocolManager", 1, "handleUploadSuccResponse: rspBody has not hasMsgUploadSuccRsp");
          i = -100003;
          paramaxtc = str;
        }
        catch (InvalidProtocolBufferMicroException paramaxtc)
        {
          paramaxtc.printStackTrace();
          i = -100003;
          paramaxtc = str;
        }
      }
    }
    paramaxtc = (cmd0x346.UploadSuccRsp)localRspBody.msg_upload_succ_rsp.get();
    if (paramaxtc.int32_ret_code.has()) {
      i = paramaxtc.int32_ret_code.get();
    }
    if (paramaxtc.str_ret_msg.has()) {}
    for (paramaxtc = paramaxtc.str_ret_msg.get();; paramaxtc = "")
    {
      bool = true;
      break;
    }
  }
  
  public void a(axtc paramaxtc, axtb paramaxtb)
  {
    if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700".equals(paramaxtb.jdField_a_of_type_JavaLangString)) {
      a(paramaxtb, paramaxtc);
    }
    for (;;)
    {
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800".equals(paramaxtb.jdField_a_of_type_JavaLangString)) {
        e(paramaxtb, paramaxtc);
      }
      return;
      if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100".equals(paramaxtb.jdField_a_of_type_JavaLangString))
      {
        b(paramaxtb, paramaxtc);
      }
      else if ("GTalkFileAppSvr.CMD_DISCUSS_FILE".equals(paramaxtb.jdField_a_of_type_JavaLangString))
      {
        aofx localaofx = (aofx)paramaxtb.jdField_a_of_type_JavaLangObject;
        int i = localaofx.a();
        if (i == 6) {
          c(paramaxtb, paramaxtc);
        } else if (i == 7) {
          c(paramaxtb, paramaxtc);
        } else {
          QLog.w("ProtocolManager", 1, "unspourt:" + localaofx.a());
        }
      }
      else if ("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700".equals(paramaxtb.jdField_a_of_type_JavaLangString))
      {
        d(paramaxtb, paramaxtc);
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, aoft paramaoft)
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
      localObject = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, paramInt1);
      if (localObject != null) {
        paramString2.bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      paramString1.msg_extension_req.set(paramString2);
      if (QLog.isColorLevel()) {
        QLog.i("ProtocolManager", 2, "forwardOfflineFileToBuddy : add tempinfo SessionType[" + paramInt1 + "]");
      }
    }
    paramString2 = new aofx(this, paramaoft);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_FORWARD_FILE-700", paramString1.toByteArray(), paramString2, paramInt2, paramInt3, 1);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, aofw paramaofw, int paramInt3, int paramInt4, aoft paramaoft)
  {
    cmd0x345.ReqBody.SubCmd0x6ReqBody localSubCmd0x6ReqBody = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
    localSubCmd0x6ReqBody.uint32_dst_bus_id.set(paramInt2);
    localSubCmd0x6ReqBody.uint64_file_size.set(paramaofw.jdField_a_of_type_Long);
    localSubCmd0x6ReqBody.bytes_uuid.set(ByteStringMicro.copyFrom(paramaofw.b.getBytes()));
    if (!TextUtils.isEmpty(paramaofw.c)) {
      localSubCmd0x6ReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(paramaofw.c.getBytes()));
    }
    localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramString2));
    paramString2 = paramString1.replace("+", "");
    localSubCmd0x6ReqBody.uint64_dst_uin.set(Long.parseLong(paramString2));
    localSubCmd0x6ReqBody.str_file_name.set(paramaofw.jdField_a_of_type_JavaLangString);
    localSubCmd0x6ReqBody.str_src_file_path.set(paramaofw.b);
    localSubCmd0x6ReqBody.str_src_parent_folder.set("/");
    localSubCmd0x6ReqBody.uint32_client_type.set(104);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localSubCmd0x6ReqBody.uint64_app_id.set(3L);
      localSubCmd0x6ReqBody.uint64_talk_type.set(paramInt1);
      paramString1 = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt1);
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
    paramString2 = new aofx(this, paramaoft);
    paramString2.a(7);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, paramInt3, paramInt4, 1);
  }
  
  public void a(String paramString1, String paramString2, aofw paramaofw, int paramInt1, int paramInt2, int paramInt3, aoft paramaoft)
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
    localApplyCopyToReq.uint64_file_size.set(paramaofw.jdField_a_of_type_Long);
    localApplyCopyToReq.str_file_name.set(paramaofw.jdField_a_of_type_JavaLangString);
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
    paramString2 = new aofx(this, paramaoft);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", paramString1.toByteArray(), paramString2, paramInt2, paramInt3, 1);
  }
  
  public void a(String paramString1, String paramString2, aofw paramaofw, aoft paramaoft)
  {
    cmd0x345.ReqBody.SubCmd0x5ReqBody localSubCmd0x5ReqBody = new cmd0x345.ReqBody.SubCmd0x5ReqBody();
    localSubCmd0x5ReqBody.uint32_src_bus_id.set(106);
    localSubCmd0x5ReqBody.bytes_src_parent_folder.set(ByteStringMicro.copyFrom("/".getBytes()));
    localSubCmd0x5ReqBody.bytes_src_file_path.set(ByteStringMicro.copyFrom(paramaofw.b.getBytes()));
    localSubCmd0x5ReqBody.uint32_dst_uin.set(Integer.parseInt(paramString1));
    localSubCmd0x5ReqBody.uint64_file_size.set(paramaofw.jdField_a_of_type_Long);
    localSubCmd0x5ReqBody.uint32_from_uin.set(Integer.parseInt(paramString2));
    localSubCmd0x5ReqBody.str_file_name.set(paramaofw.jdField_a_of_type_JavaLangString);
    if ((paramaofw.c != null) && (paramaofw.c.length() > 0)) {
      localSubCmd0x5ReqBody.bytes_md5.set(ByteStringMicro.copyFrom(paramaofw.c.getBytes()));
    }
    paramString1 = new cmd0x345.ReqBody();
    paramString1.msg_subcmd_0x5_req_body.set(localSubCmd0x5ReqBody);
    paramString1.uint32_sub_cmd.set(6);
    paramString2 = new aofx(this, paramaoft);
    paramString2.a(6);
    a("GTalkFileAppSvr.CMD_DISCUSS_FILE", paramString1.toByteArray(), paramString2, 30000, 3, 1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, aofu paramaofu)
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
    paramString1 = new aofx(this, paramaofu);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700", localReqBody.toByteArray(), paramString1, paramInt1, paramInt2, 1);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, aofs paramaofs)
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
    if (paramaofs != null) {
      paramString = new aofx(this, paramaofs);
    }
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800", paramArrayOfByte.toByteArray(), paramString, paramInt1, paramInt2, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aofv
 * JD-Core Version:    0.7.0.1
 */