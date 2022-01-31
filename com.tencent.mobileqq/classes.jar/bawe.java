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
import java.util.List<Lbawz;>;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class bawe
  extends bawa
{
  private static int a;
  
  public void a(bari parambari, barh parambarh)
  {
    Object localObject2 = parambari.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject1 = parambari.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bawo localbawo = (bawo)parambarh.jdField_a_of_type_JavaLangObject;
    baxd localbaxd = localbawo.jdField_a_of_type_Baxd;
    alsj localalsj = parambari.jdField_a_of_type_Alsj;
    int i;
    if (((FromServiceMsg)localObject2).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject2).getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
        parambarh = ((FromServiceMsg)localObject2).getBusinessFailMsg();
        parambari = parambarh;
        if (parambarh == null) {
          parambari = "";
        }
        a(-1, 9311, (String)localObject1, parambari, localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      }
    }
    cmd0x346.ApplyUploadRsp localApplyUploadRsp;
    baxh localbaxh;
    for (;;)
    {
      baxu.a(localbawo, localbaxd);
      return;
      localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
      parambarh = ((FromServiceMsg)localObject2).getBusinessFailMsg();
      parambari = parambarh;
      if (parambarh == null) {
        parambari = "";
      }
      a(-1, 9044, (String)localObject1, parambari, localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        parambari = new cmd0x346.RspBody();
        parambari.mergeFrom((byte[])localObject1);
        localApplyUploadRsp = (cmd0x346.ApplyUploadRsp)parambari.msg_apply_upload_rsp.get();
        localbaxh = (baxh)localbaxd.jdField_a_of_type_JavaUtilList.get(0);
        if ((localbaxh != null) && (localObject2 != null) && (((FromServiceMsg)localObject2).getAttributes().containsKey("_attr_send_by_quickHttp"))) {
          localbaxh.d = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        }
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttUpHandler.onProtoResp:isSendByQuickHttp=" + localbaxh.d);
        }
        i = localApplyUploadRsp.int32_ret_code.get();
        if (i != 0) {
          break label577;
        }
        localbaxh.jdField_a_of_type_JavaLangString = localApplyUploadRsp.bytes_uuid.get().toStringUtf8();
        if ((!localApplyUploadRsp.bool_file_exist.has()) || (!localApplyUploadRsp.bool_file_exist.get())) {
          break;
        }
        localbaxh.jdField_a_of_type_Boolean = true;
      }
      catch (Exception parambari)
      {
        a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr((byte[])localObject1), localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      }
    }
    if (localApplyUploadRsp.uint32_pack_size.has()) {
      localbaxh.jdField_a_of_type_Int = localApplyUploadRsp.uint32_pack_size.get();
    }
    localObject2 = HexUtil.bytes2HexStr(localApplyUploadRsp.bytes_upload_key.get().toByteArray());
    localbaxh.b = ((String)localObject2);
    parambarh = localApplyUploadRsp.str_upload_ip.get();
    parambari = parambarh;
    if (parambarh == null) {
      parambari = localApplyUploadRsp.str_upload_domain.get();
    }
    for (;;)
    {
      label473:
      throw new Exception("ukey or ip missing");
      label577:
      do
      {
        parambari = localApplyUploadRsp.rpt_str_uploadip_list.get();
        if ((parambari != null) && (parambari.size() > 0))
        {
          parambari = parambari.iterator();
          while (parambari.hasNext())
          {
            parambarh = (String)parambari.next();
            localObject2 = new basp();
            ((basp)localObject2).jdField_a_of_type_JavaLangString = parambarh;
            localbaxh.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          }
        }
        a(0, 0, "", "", localalsj, localbaxh);
        break;
        a(-1, -9527, bamw.a(i), "", localalsj, localbaxh);
        break;
        if (localObject2 == null) {
          break label473;
        }
      } while (parambari != null);
    }
  }
  
  public void a(bawo parambawo)
  {
    if ((parambawo != null) && (parambawo.jdField_a_of_type_JavaUtilList != null) && (parambawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      barh localbarh = new barh();
      localbarh.jdField_a_of_type_JavaLangString = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500";
      localbarh.jdField_a_of_type_ArrayOfByte = a(parambawo.jdField_a_of_type_JavaUtilList);
      localbarh.jdField_a_of_type_JavaLangObject = parambawo;
      localbarh.jdField_a_of_type_Barg = this;
      a(parambawo, localbarh);
    }
  }
  
  byte[] a(List<bawz> paramList)
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
    bawy localbawy;
    if (paramList.size() == 1)
    {
      localbawy = (bawy)paramList.get(0);
      cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
      localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localbawy.jdField_c_of_type_JavaLangString));
      try
      {
        localObject = localbawy.jdField_d_of_type_JavaLangString;
        paramList = (List<bawz>)localObject;
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
          if (localbawy.jdField_a_of_type_Boolean)
          {
            i = 500;
            continue;
            paramList.str_dst_phonenum.set(localbawy.jdField_d_of_type_JavaLangString);
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
            if (localbawy.f == 9999) {
              paramList.uint32_file_type.set(102);
            }
          }
        }
      }
      localApplyUploadReq.uint32_file_type.set(2);
      localApplyUploadReq.str_file_name.set(localbawy.jdField_a_of_type_JavaLangString);
      localApplyUploadReq.uint64_file_size.set(localbawy.b);
      localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localbawy.jdField_a_of_type_ArrayOfByte));
      localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
      paramList = new cmd0x346.ExtensionReq();
      paramList.uint64_id.set(3L);
      paramList.uint32_ptt_format.set(localbawy.jdField_c_of_type_Int);
      paramList.uint32_ptt_time.set(localbawy.jdField_a_of_type_Int);
      i = a();
      paramList.uint32_net_type.set(i);
      paramList.uint32_voice_type.set(localbawy.jdField_d_of_type_Int);
      if (QLog.isColorLevel())
      {
        QLog.d("RecordParams", 2, "C2CPttUp: panel[" + localbawy.jdField_d_of_type_Int + "] type[" + localbawy.jdField_c_of_type_Int + "] length[" + localbawy.jdField_a_of_type_Int + "] size[" + localbawy.b + "]");
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "C2CPttUp: net[" + i + "]");
        }
      }
      i = j;
      switch (localbawy.f)
      {
      default: 
        i = j;
      case 1005: 
      case 1023: 
      case 1024: 
        paramList.uint64_type.set(i);
        if (localbawy.f == 1008)
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
  
  void b(bawo parambawo)
  {
    baxd localbaxd = parambawo.jdField_a_of_type_Baxd;
    localbaxd.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambawo.jdField_a_of_type_JavaUtilList.size())
    {
      baxh localbaxh = new baxh();
      localbaxd.jdField_a_of_type_JavaUtilList.add(i, localbaxh);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawe
 * JD-Core Version:    0.7.0.1
 */