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
import java.util.List<Layyy;>;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class ayyd
  extends ayxz
{
  private static int a;
  
  public void a(aytj paramaytj, ayti paramayti)
  {
    Object localObject2 = paramaytj.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject1 = paramaytj.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    ayyn localayyn = (ayyn)paramayti.jdField_a_of_type_JavaLangObject;
    ayzc localayzc = localayyn.jdField_a_of_type_Ayzc;
    akaw localakaw = paramaytj.jdField_a_of_type_Akaw;
    int i;
    if (((FromServiceMsg)localObject2).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject2).getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
        paramayti = ((FromServiceMsg)localObject2).getBusinessFailMsg();
        paramaytj = paramayti;
        if (paramayti == null) {
          paramaytj = "";
        }
        a(-1, 9311, (String)localObject1, paramaytj, localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      }
    }
    cmd0x346.ApplyUploadRsp localApplyUploadRsp;
    ayzg localayzg;
    for (;;)
    {
      ayzt.a(localayyn, localayzc);
      return;
      localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
      paramayti = ((FromServiceMsg)localObject2).getBusinessFailMsg();
      paramaytj = paramayti;
      if (paramayti == null) {
        paramaytj = "";
      }
      a(-1, 9044, (String)localObject1, paramaytj, localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramaytj = new cmd0x346.RspBody();
        paramaytj.mergeFrom((byte[])localObject1);
        localApplyUploadRsp = (cmd0x346.ApplyUploadRsp)paramaytj.msg_apply_upload_rsp.get();
        localayzg = (ayzg)localayzc.jdField_a_of_type_JavaUtilList.get(0);
        if ((localayzg != null) && (localObject2 != null) && (((FromServiceMsg)localObject2).getAttributes().containsKey("_attr_send_by_quickHttp"))) {
          localayzg.d = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        }
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttUpHandler.onProtoResp:isSendByQuickHttp=" + localayzg.d);
        }
        i = localApplyUploadRsp.int32_ret_code.get();
        if (i != 0) {
          break label577;
        }
        localayzg.jdField_a_of_type_JavaLangString = localApplyUploadRsp.bytes_uuid.get().toStringUtf8();
        if ((!localApplyUploadRsp.bool_file_exist.has()) || (!localApplyUploadRsp.bool_file_exist.get())) {
          break;
        }
        localayzg.jdField_a_of_type_Boolean = true;
      }
      catch (Exception paramaytj)
      {
        a(-1, -9527, ayoz.a("P", -9529L), paramaytj.getMessage() + " hex:" + HexUtil.bytes2HexStr((byte[])localObject1), localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      }
    }
    if (localApplyUploadRsp.uint32_pack_size.has()) {
      localayzg.jdField_a_of_type_Int = localApplyUploadRsp.uint32_pack_size.get();
    }
    localObject2 = HexUtil.bytes2HexStr(localApplyUploadRsp.bytes_upload_key.get().toByteArray());
    localayzg.b = ((String)localObject2);
    paramayti = localApplyUploadRsp.str_upload_ip.get();
    paramaytj = paramayti;
    if (paramayti == null) {
      paramaytj = localApplyUploadRsp.str_upload_domain.get();
    }
    for (;;)
    {
      label473:
      throw new Exception("ukey or ip missing");
      label577:
      do
      {
        paramaytj = localApplyUploadRsp.rpt_str_uploadip_list.get();
        if ((paramaytj != null) && (paramaytj.size() > 0))
        {
          paramaytj = paramaytj.iterator();
          while (paramaytj.hasNext())
          {
            paramayti = (String)paramaytj.next();
            localObject2 = new ayuo();
            ((ayuo)localObject2).jdField_a_of_type_JavaLangString = paramayti;
            localayzg.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          }
        }
        a(0, 0, "", "", localakaw, localayzg);
        break;
        a(-1, -9527, ayoz.a(i), "", localakaw, localayzg);
        break;
        if (localObject2 == null) {
          break label473;
        }
      } while (paramaytj != null);
    }
  }
  
  public void a(ayyn paramayyn)
  {
    if ((paramayyn != null) && (paramayyn.jdField_a_of_type_JavaUtilList != null) && (paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ayti localayti = new ayti();
      localayti.jdField_a_of_type_JavaLangString = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500";
      localayti.jdField_a_of_type_ArrayOfByte = a(paramayyn.jdField_a_of_type_JavaUtilList);
      localayti.jdField_a_of_type_JavaLangObject = paramayyn;
      localayti.jdField_a_of_type_Ayth = this;
      a(paramayyn, localayti);
    }
  }
  
  byte[] a(List<ayyy> paramList)
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
    ayyx localayyx;
    if (paramList.size() == 1)
    {
      localayyx = (ayyx)paramList.get(0);
      cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
      localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localayyx.jdField_c_of_type_JavaLangString));
      try
      {
        localObject = localayyx.jdField_d_of_type_JavaLangString;
        paramList = (List<ayyy>)localObject;
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
          if (localayyx.jdField_a_of_type_Boolean)
          {
            i = 500;
            continue;
            paramList.str_dst_phonenum.set(localayyx.jdField_d_of_type_JavaLangString);
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
            if (localayyx.f == 9999) {
              paramList.uint32_file_type.set(102);
            }
          }
        }
      }
      localApplyUploadReq.uint32_file_type.set(2);
      localApplyUploadReq.str_file_name.set(localayyx.jdField_a_of_type_JavaLangString);
      localApplyUploadReq.uint64_file_size.set(localayyx.b);
      localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localayyx.jdField_a_of_type_ArrayOfByte));
      localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
      paramList = new cmd0x346.ExtensionReq();
      paramList.uint64_id.set(3L);
      paramList.uint32_ptt_format.set(localayyx.jdField_c_of_type_Int);
      paramList.uint32_ptt_time.set(localayyx.jdField_a_of_type_Int);
      i = a();
      paramList.uint32_net_type.set(i);
      paramList.uint32_voice_type.set(localayyx.jdField_d_of_type_Int);
      if (QLog.isColorLevel())
      {
        QLog.d("RecordParams", 2, "C2CPttUp: panel[" + localayyx.jdField_d_of_type_Int + "] type[" + localayyx.jdField_c_of_type_Int + "] length[" + localayyx.jdField_a_of_type_Int + "] size[" + localayyx.b + "]");
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "C2CPttUp: net[" + i + "]");
        }
      }
      i = j;
      switch (localayyx.f)
      {
      default: 
        i = j;
      case 1005: 
      case 1023: 
      case 1024: 
        paramList.uint64_type.set(i);
        if (localayyx.f == 1008)
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
  
  void b(ayyn paramayyn)
  {
    ayzc localayzc = paramayyn.jdField_a_of_type_Ayzc;
    localayzc.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramayyn.jdField_a_of_type_JavaUtilList.size())
    {
      ayzg localayzg = new ayzg();
      localayzc.jdField_a_of_type_JavaUtilList.add(i, localayzg);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyd
 * JD-Core Version:    0.7.0.1
 */