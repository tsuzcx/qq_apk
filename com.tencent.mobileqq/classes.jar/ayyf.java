import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Layza;>;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class ayyf
  extends ayyb
{
  private static int a;
  
  public void a(aytl paramaytl, aytk paramaytk)
  {
    Object localObject2 = paramaytl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject1 = paramaytl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    ayyp localayyp = (ayyp)paramaytk.jdField_a_of_type_JavaLangObject;
    ayze localayze = localayyp.jdField_a_of_type_Ayze;
    akau localakau = paramaytl.jdField_a_of_type_Akau;
    int i;
    if (((FromServiceMsg)localObject2).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject2).getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
        paramaytk = ((FromServiceMsg)localObject2).getBusinessFailMsg();
        paramaytl = paramaytk;
        if (paramaytk == null) {
          paramaytl = "";
        }
        a(-1, 9311, (String)localObject1, paramaytl, localakau, localayze.jdField_a_of_type_JavaUtilList);
      }
    }
    cmd0x346.ApplyUploadRsp localApplyUploadRsp;
    ayzi localayzi;
    for (;;)
    {
      ayzv.a(localayyp, localayze);
      return;
      localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
      paramaytk = ((FromServiceMsg)localObject2).getBusinessFailMsg();
      paramaytl = paramaytk;
      if (paramaytk == null) {
        paramaytl = "";
      }
      a(-1, 9044, (String)localObject1, paramaytl, localakau, localayze.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramaytl = new cmd0x346.RspBody();
        paramaytl.mergeFrom((byte[])localObject1);
        localApplyUploadRsp = (cmd0x346.ApplyUploadRsp)paramaytl.msg_apply_upload_rsp.get();
        localayzi = (ayzi)localayze.jdField_a_of_type_JavaUtilList.get(0);
        if ((localayzi != null) && (localObject2 != null) && (((FromServiceMsg)localObject2).getAttributes().containsKey("_attr_send_by_quickHttp"))) {
          localayzi.d = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        }
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttUpHandler.onProtoResp:isSendByQuickHttp=" + localayzi.d);
        }
        i = localApplyUploadRsp.int32_ret_code.get();
        if (i != 0) {
          break label577;
        }
        localayzi.jdField_a_of_type_JavaLangString = localApplyUploadRsp.bytes_uuid.get().toStringUtf8();
        if ((!localApplyUploadRsp.bool_file_exist.has()) || (!localApplyUploadRsp.bool_file_exist.get())) {
          break;
        }
        localayzi.jdField_a_of_type_Boolean = true;
      }
      catch (Exception paramaytl)
      {
        a(-1, -9527, aypb.a("P", -9529L), paramaytl.getMessage() + " hex:" + HexUtil.bytes2HexStr((byte[])localObject1), localakau, localayze.jdField_a_of_type_JavaUtilList);
      }
    }
    if (localApplyUploadRsp.uint32_pack_size.has()) {
      localayzi.jdField_a_of_type_Int = localApplyUploadRsp.uint32_pack_size.get();
    }
    localObject2 = HexUtil.bytes2HexStr(localApplyUploadRsp.bytes_upload_key.get().toByteArray());
    localayzi.b = ((String)localObject2);
    paramaytk = localApplyUploadRsp.str_upload_ip.get();
    paramaytl = paramaytk;
    if (paramaytk == null) {
      paramaytl = localApplyUploadRsp.str_upload_domain.get();
    }
    for (;;)
    {
      label473:
      throw new Exception("ukey or ip missing");
      label577:
      do
      {
        paramaytl = localApplyUploadRsp.rpt_str_uploadip_list.get();
        if ((paramaytl != null) && (paramaytl.size() > 0))
        {
          paramaytl = paramaytl.iterator();
          while (paramaytl.hasNext())
          {
            paramaytk = (String)paramaytl.next();
            localObject2 = new ayuq();
            ((ayuq)localObject2).jdField_a_of_type_JavaLangString = paramaytk;
            localayzi.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          }
        }
        a(0, 0, "", "", localakau, localayzi);
        break;
        a(-1, -9527, aypb.a(i), "", localakau, localayzi);
        break;
        if (localObject2 == null) {
          break label473;
        }
      } while (paramaytl != null);
    }
  }
  
  public void a(ayyp paramayyp)
  {
    if ((paramayyp != null) && (paramayyp.jdField_a_of_type_JavaUtilList != null) && (paramayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      aytk localaytk = new aytk();
      localaytk.jdField_a_of_type_JavaLangString = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500";
      localaytk.jdField_a_of_type_ArrayOfByte = a(paramayyp.jdField_a_of_type_JavaUtilList);
      localaytk.jdField_a_of_type_JavaLangObject = paramayyp;
      localaytk.jdField_a_of_type_Aytj = this;
      a(paramayyp, localaytk);
    }
  }
  
  byte[] a(List<ayza> paramList)
  {
    int j = 0;
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(500);
    Object localObject = localReqBody.uint32_seq;
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    ((PBUInt32Field)localObject).set(i);
    localReqBody.uint32_business_id.set(17);
    localReqBody.uint32_client_type.set(104);
    ayyz localayyz;
    if (paramList.size() == 1)
    {
      localayyz = (ayyz)paramList.get(0);
      cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
      localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localayyz.jdField_c_of_type_JavaLangString));
      try
      {
        localObject = localayyz.jdField_d_of_type_JavaLangString;
        paramList = (List<ayza>)localObject;
        if (((String)localObject).startsWith("+")) {
          paramList = ((String)localObject).substring(1);
        }
        long l = Long.valueOf(paramList).longValue();
        localApplyUploadReq.uint64_recver_uin.set(l);
      }
      catch (Exception paramList)
      {
        for (;;)
        {
          paramList.printStackTrace();
          continue;
          i = j;
          if (localayyz.jdField_a_of_type_Boolean)
          {
            i = 500;
            continue;
            paramList.str_dst_phonenum.set(localayyz.jdField_d_of_type_JavaLangString);
            i = 102;
            continue;
            i = 104;
            continue;
            i = 104;
            continue;
            i = 105;
            continue;
            i = 101;
            continue;
            i = 103;
            continue;
            i = 114;
            continue;
            if (localayyz.f == 9999) {
              paramList.uint32_file_type.set(102);
            }
          }
        }
      }
      localApplyUploadReq.uint32_file_type.set(2);
      localApplyUploadReq.str_file_name.set(localayyz.jdField_a_of_type_JavaLangString);
      localApplyUploadReq.uint64_file_size.set(localayyz.b);
      localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localayyz.jdField_a_of_type_ArrayOfByte));
      localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
      paramList = new cmd0x346.ExtensionReq();
      paramList.uint64_id.set(3L);
      paramList.uint32_ptt_format.set(localayyz.jdField_c_of_type_Int);
      paramList.uint32_ptt_time.set(localayyz.jdField_a_of_type_Int);
      i = a();
      paramList.uint32_net_type.set(i);
      paramList.uint32_voice_type.set(localayyz.jdField_d_of_type_Int);
      if (QLog.isColorLevel())
      {
        QLog.d("RecordParams", 2, "C2CPttUp: panel[" + localayyz.jdField_d_of_type_Int + "] type[" + localayyz.jdField_c_of_type_Int + "] length[" + localayyz.jdField_a_of_type_Int + "] size[" + localayyz.b + "]");
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "C2CPttUp: net[" + i + "]");
        }
      }
      i = j;
      switch (localayyz.f)
      {
      default: 
        i = j;
      case 1005: 
      case 1023: 
      case 1024: 
        paramList.uint64_type.set(i);
        if (localayyz.f == 1008)
        {
          paramList.uint32_file_type.set(3);
          localReqBody.msg_extension_req.set(paramList);
          return localReqBody.toByteArray();
        }
        break;
      }
    }
    throw new RuntimeException("only support one request");
  }
  
  void b(ayyp paramayyp)
  {
    ayze localayze = paramayyp.jdField_a_of_type_Ayze;
    localayze.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramayyp.jdField_a_of_type_JavaUtilList.size())
    {
      ayzi localayzi = new ayzi();
      localayze.jdField_a_of_type_JavaUtilList.add(i, localayzi);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyf
 * JD-Core Version:    0.7.0.1
 */