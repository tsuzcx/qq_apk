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
import java.util.List<Lbbbi;>;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class bban
  extends bbaj
{
  private static int a;
  
  public void a(bavr parambavr, bavq parambavq)
  {
    Object localObject2 = parambavr.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject1 = parambavr.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bbax localbbax = (bbax)parambavq.jdField_a_of_type_JavaLangObject;
    bbbm localbbbm = localbbax.jdField_a_of_type_Bbbm;
    alwy localalwy = parambavr.jdField_a_of_type_Alwy;
    int i;
    if (((FromServiceMsg)localObject2).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject2).getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
        parambavq = ((FromServiceMsg)localObject2).getBusinessFailMsg();
        parambavr = parambavq;
        if (parambavq == null) {
          parambavr = "";
        }
        a(-1, 9311, (String)localObject1, parambavr, localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      }
    }
    cmd0x346.ApplyUploadRsp localApplyUploadRsp;
    bbbq localbbbq;
    for (;;)
    {
      bbcd.a(localbbax, localbbbm);
      return;
      localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
      parambavq = ((FromServiceMsg)localObject2).getBusinessFailMsg();
      parambavr = parambavq;
      if (parambavq == null) {
        parambavr = "";
      }
      a(-1, 9044, (String)localObject1, parambavr, localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        parambavr = new cmd0x346.RspBody();
        parambavr.mergeFrom((byte[])localObject1);
        localApplyUploadRsp = (cmd0x346.ApplyUploadRsp)parambavr.msg_apply_upload_rsp.get();
        localbbbq = (bbbq)localbbbm.jdField_a_of_type_JavaUtilList.get(0);
        if ((localbbbq != null) && (localObject2 != null) && (((FromServiceMsg)localObject2).getAttributes().containsKey("_attr_send_by_quickHttp"))) {
          localbbbq.d = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        }
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttUpHandler.onProtoResp:isSendByQuickHttp=" + localbbbq.d);
        }
        i = localApplyUploadRsp.int32_ret_code.get();
        if (i != 0) {
          break label577;
        }
        localbbbq.jdField_a_of_type_JavaLangString = localApplyUploadRsp.bytes_uuid.get().toStringUtf8();
        if ((!localApplyUploadRsp.bool_file_exist.has()) || (!localApplyUploadRsp.bool_file_exist.get())) {
          break;
        }
        localbbbq.jdField_a_of_type_Boolean = true;
      }
      catch (Exception parambavr)
      {
        a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr((byte[])localObject1), localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      }
    }
    if (localApplyUploadRsp.uint32_pack_size.has()) {
      localbbbq.jdField_a_of_type_Int = localApplyUploadRsp.uint32_pack_size.get();
    }
    localObject2 = HexUtil.bytes2HexStr(localApplyUploadRsp.bytes_upload_key.get().toByteArray());
    localbbbq.b = ((String)localObject2);
    parambavq = localApplyUploadRsp.str_upload_ip.get();
    parambavr = parambavq;
    if (parambavq == null) {
      parambavr = localApplyUploadRsp.str_upload_domain.get();
    }
    for (;;)
    {
      label473:
      throw new Exception("ukey or ip missing");
      label577:
      do
      {
        parambavr = localApplyUploadRsp.rpt_str_uploadip_list.get();
        if ((parambavr != null) && (parambavr.size() > 0))
        {
          parambavr = parambavr.iterator();
          while (parambavr.hasNext())
          {
            parambavq = (String)parambavr.next();
            localObject2 = new bawy();
            ((bawy)localObject2).jdField_a_of_type_JavaLangString = parambavq;
            localbbbq.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          }
        }
        a(0, 0, "", "", localalwy, localbbbq);
        break;
        a(-1, -9527, barf.a(i), "", localalwy, localbbbq);
        break;
        if (localObject2 == null) {
          break label473;
        }
      } while (parambavr != null);
    }
  }
  
  public void a(bbax parambbax)
  {
    if ((parambbax != null) && (parambbax.jdField_a_of_type_JavaUtilList != null) && (parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bavq localbavq = new bavq();
      localbavq.jdField_a_of_type_JavaLangString = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500";
      localbavq.jdField_a_of_type_ArrayOfByte = a(parambbax.jdField_a_of_type_JavaUtilList);
      localbavq.jdField_a_of_type_JavaLangObject = parambbax;
      localbavq.jdField_a_of_type_Bavp = this;
      a(parambbax, localbavq);
    }
  }
  
  byte[] a(List<bbbi> paramList)
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
    bbbh localbbbh;
    if (paramList.size() == 1)
    {
      localbbbh = (bbbh)paramList.get(0);
      cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
      localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localbbbh.jdField_c_of_type_JavaLangString));
      try
      {
        localObject = localbbbh.jdField_d_of_type_JavaLangString;
        paramList = (List<bbbi>)localObject;
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
          if (localbbbh.jdField_a_of_type_Boolean)
          {
            i = 500;
            continue;
            paramList.str_dst_phonenum.set(localbbbh.jdField_d_of_type_JavaLangString);
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
            if (localbbbh.f == 9999) {
              paramList.uint32_file_type.set(102);
            }
          }
        }
      }
      localApplyUploadReq.uint32_file_type.set(2);
      localApplyUploadReq.str_file_name.set(localbbbh.jdField_a_of_type_JavaLangString);
      localApplyUploadReq.uint64_file_size.set(localbbbh.b);
      localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localbbbh.jdField_a_of_type_ArrayOfByte));
      localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
      paramList = new cmd0x346.ExtensionReq();
      paramList.uint64_id.set(3L);
      paramList.uint32_ptt_format.set(localbbbh.jdField_c_of_type_Int);
      paramList.uint32_ptt_time.set(localbbbh.jdField_a_of_type_Int);
      i = a();
      paramList.uint32_net_type.set(i);
      paramList.uint32_voice_type.set(localbbbh.jdField_d_of_type_Int);
      if (QLog.isColorLevel())
      {
        QLog.d("RecordParams", 2, "C2CPttUp: panel[" + localbbbh.jdField_d_of_type_Int + "] type[" + localbbbh.jdField_c_of_type_Int + "] length[" + localbbbh.jdField_a_of_type_Int + "] size[" + localbbbh.b + "]");
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "C2CPttUp: net[" + i + "]");
        }
      }
      i = j;
      switch (localbbbh.f)
      {
      default: 
        i = j;
      case 1005: 
      case 1023: 
      case 1024: 
        paramList.uint64_type.set(i);
        if (localbbbh.f == 1008)
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
  
  void b(bbax parambbax)
  {
    bbbm localbbbm = parambbax.jdField_a_of_type_Bbbm;
    localbbbm.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambbax.jdField_a_of_type_JavaUtilList.size())
    {
      bbbq localbbbq = new bbbq();
      localbbbm.jdField_a_of_type_JavaUtilList.add(i, localbbbq);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bban
 * JD-Core Version:    0.7.0.1
 */