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
import java.util.List<Laxyr;>;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class axxw
  extends axxs
{
  private static int a;
  
  public void a(axtc paramaxtc, axtb paramaxtb)
  {
    Object localObject2 = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject1 = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    axyg localaxyg = (axyg)paramaxtb.jdField_a_of_type_JavaLangObject;
    axyv localaxyv = localaxyg.jdField_a_of_type_Axyv;
    ajmn localajmn = paramaxtc.jdField_a_of_type_Ajmn;
    int i;
    if (((FromServiceMsg)localObject2).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject2).getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
        paramaxtb = ((FromServiceMsg)localObject2).getBusinessFailMsg();
        paramaxtc = paramaxtb;
        if (paramaxtb == null) {
          paramaxtc = "";
        }
        a(-1, 9311, (String)localObject1, paramaxtc, localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
    }
    cmd0x346.ApplyUploadRsp localApplyUploadRsp;
    axyz localaxyz;
    for (;;)
    {
      axzm.a(localaxyg, localaxyv);
      return;
      localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
      paramaxtb = ((FromServiceMsg)localObject2).getBusinessFailMsg();
      paramaxtc = paramaxtb;
      if (paramaxtb == null) {
        paramaxtc = "";
      }
      a(-1, 9044, (String)localObject1, paramaxtc, localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramaxtc = new cmd0x346.RspBody();
        paramaxtc.mergeFrom((byte[])localObject1);
        localApplyUploadRsp = (cmd0x346.ApplyUploadRsp)paramaxtc.msg_apply_upload_rsp.get();
        localaxyz = (axyz)localaxyv.jdField_a_of_type_JavaUtilList.get(0);
        if ((localaxyz != null) && (localObject2 != null) && (((FromServiceMsg)localObject2).getAttributes().containsKey("_attr_send_by_quickHttp"))) {
          localaxyz.d = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        }
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttUpHandler.onProtoResp:isSendByQuickHttp=" + localaxyz.d);
        }
        i = localApplyUploadRsp.int32_ret_code.get();
        if (i != 0) {
          break label577;
        }
        localaxyz.jdField_a_of_type_JavaLangString = localApplyUploadRsp.bytes_uuid.get().toStringUtf8();
        if ((!localApplyUploadRsp.bool_file_exist.has()) || (!localApplyUploadRsp.bool_file_exist.get())) {
          break;
        }
        localaxyz.jdField_a_of_type_Boolean = true;
      }
      catch (Exception paramaxtc)
      {
        a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr((byte[])localObject1), localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
    }
    if (localApplyUploadRsp.uint32_pack_size.has()) {
      localaxyz.jdField_a_of_type_Int = localApplyUploadRsp.uint32_pack_size.get();
    }
    localObject2 = HexUtil.bytes2HexStr(localApplyUploadRsp.bytes_upload_key.get().toByteArray());
    localaxyz.b = ((String)localObject2);
    paramaxtb = localApplyUploadRsp.str_upload_ip.get();
    paramaxtc = paramaxtb;
    if (paramaxtb == null) {
      paramaxtc = localApplyUploadRsp.str_upload_domain.get();
    }
    for (;;)
    {
      label473:
      throw new Exception("ukey or ip missing");
      label577:
      do
      {
        paramaxtc = localApplyUploadRsp.rpt_str_uploadip_list.get();
        if ((paramaxtc != null) && (paramaxtc.size() > 0))
        {
          paramaxtc = paramaxtc.iterator();
          while (paramaxtc.hasNext())
          {
            paramaxtb = (String)paramaxtc.next();
            localObject2 = new axuh();
            ((axuh)localObject2).jdField_a_of_type_JavaLangString = paramaxtb;
            localaxyz.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          }
        }
        a(0, 0, "", "", localajmn, localaxyz);
        break;
        a(-1, -9527, axou.a(i), "", localajmn, localaxyz);
        break;
        if (localObject2 == null) {
          break label473;
        }
      } while (paramaxtc != null);
    }
  }
  
  public void a(axyg paramaxyg)
  {
    if ((paramaxyg != null) && (paramaxyg.jdField_a_of_type_JavaUtilList != null) && (paramaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      axtb localaxtb = new axtb();
      localaxtb.jdField_a_of_type_JavaLangString = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500";
      localaxtb.jdField_a_of_type_ArrayOfByte = a(paramaxyg.jdField_a_of_type_JavaUtilList);
      localaxtb.jdField_a_of_type_JavaLangObject = paramaxyg;
      localaxtb.jdField_a_of_type_Axta = this;
      a(paramaxyg, localaxtb);
    }
  }
  
  byte[] a(List<axyr> paramList)
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
    axyq localaxyq;
    if (paramList.size() == 1)
    {
      localaxyq = (axyq)paramList.get(0);
      cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
      localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localaxyq.jdField_c_of_type_JavaLangString));
      try
      {
        localObject = localaxyq.jdField_d_of_type_JavaLangString;
        paramList = (List<axyr>)localObject;
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
          if (localaxyq.jdField_a_of_type_Boolean)
          {
            i = 500;
            continue;
            paramList.str_dst_phonenum.set(localaxyq.jdField_d_of_type_JavaLangString);
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
            if (localaxyq.f == 9999) {
              paramList.uint32_file_type.set(102);
            }
          }
        }
      }
      localApplyUploadReq.uint32_file_type.set(2);
      localApplyUploadReq.str_file_name.set(localaxyq.jdField_a_of_type_JavaLangString);
      localApplyUploadReq.uint64_file_size.set(localaxyq.b);
      localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localaxyq.jdField_a_of_type_ArrayOfByte));
      localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
      paramList = new cmd0x346.ExtensionReq();
      paramList.uint64_id.set(3L);
      paramList.uint32_ptt_format.set(localaxyq.jdField_c_of_type_Int);
      paramList.uint32_ptt_time.set(localaxyq.jdField_a_of_type_Int);
      i = a();
      paramList.uint32_net_type.set(i);
      paramList.uint32_voice_type.set(localaxyq.jdField_d_of_type_Int);
      if (QLog.isColorLevel())
      {
        QLog.d("RecordParams", 2, "C2CPttUp: panel[" + localaxyq.jdField_d_of_type_Int + "] type[" + localaxyq.jdField_c_of_type_Int + "] length[" + localaxyq.jdField_a_of_type_Int + "] size[" + localaxyq.b + "]");
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "C2CPttUp: net[" + i + "]");
        }
      }
      i = j;
      switch (localaxyq.f)
      {
      default: 
        i = j;
      case 1005: 
      case 1023: 
      case 1024: 
        paramList.uint64_type.set(i);
        if (localaxyq.f == 1008)
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
  
  void b(axyg paramaxyg)
  {
    axyv localaxyv = paramaxyg.jdField_a_of_type_Axyv;
    localaxyv.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramaxyg.jdField_a_of_type_JavaUtilList.size())
    {
      axyz localaxyz = new axyz();
      localaxyv.jdField_a_of_type_JavaUtilList.add(i, localaxyz);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxw
 * JD-Core Version:    0.7.0.1
 */