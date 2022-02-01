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
import java.util.List<Lbecg;>;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class bebj
  extends bebf
{
  private static int a;
  
  public void a(bdxf parambdxf, bdxe parambdxe)
  {
    Object localObject2 = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject1 = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bebv localbebv = (bebv)parambdxe.jdField_a_of_type_JavaLangObject;
    beck localbeck = localbebv.jdField_a_of_type_Beck;
    anqe localanqe = parambdxf.jdField_a_of_type_Anqe;
    int i;
    if (((FromServiceMsg)localObject2).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject2).getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
        parambdxe = ((FromServiceMsg)localObject2).getBusinessFailMsg();
        parambdxf = parambdxe;
        if (parambdxe == null) {
          parambdxf = "";
        }
        a(-1, 9311, (String)localObject1, parambdxf, localanqe, localbeck.jdField_a_of_type_JavaUtilList);
      }
    }
    cmd0x346.ApplyUploadRsp localApplyUploadRsp;
    beco localbeco;
    for (;;)
    {
      bedb.a(localbebv, localbeck);
      return;
      localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
      parambdxe = ((FromServiceMsg)localObject2).getBusinessFailMsg();
      parambdxf = parambdxe;
      if (parambdxe == null) {
        parambdxf = "";
      }
      a(-1, 9044, (String)localObject1, parambdxf, localanqe, localbeck.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        parambdxf = new cmd0x346.RspBody();
        parambdxf.mergeFrom((byte[])localObject1);
        localApplyUploadRsp = (cmd0x346.ApplyUploadRsp)parambdxf.msg_apply_upload_rsp.get();
        localbeco = (beco)localbeck.jdField_a_of_type_JavaUtilList.get(0);
        if ((localbeco != null) && (localObject2 != null) && (((FromServiceMsg)localObject2).getAttributes().containsKey("_attr_send_by_quickHttp"))) {
          localbeco.d = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        }
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttUpHandler.onProtoResp:isSendByQuickHttp=" + localbeco.d);
        }
        i = localApplyUploadRsp.int32_ret_code.get();
        if (i != 0) {
          break label577;
        }
        localbeco.jdField_a_of_type_JavaLangString = localApplyUploadRsp.bytes_uuid.get().toStringUtf8();
        if ((!localApplyUploadRsp.bool_file_exist.has()) || (!localApplyUploadRsp.bool_file_exist.get())) {
          break;
        }
        localbeco.jdField_a_of_type_Boolean = true;
      }
      catch (Exception parambdxf)
      {
        a(-1, -9527, bdsx.a("P", -9529L), parambdxf.getMessage() + " hex:" + HexUtil.bytes2HexStr((byte[])localObject1), localanqe, localbeck.jdField_a_of_type_JavaUtilList);
      }
    }
    if (localApplyUploadRsp.uint32_pack_size.has()) {
      localbeco.jdField_a_of_type_Int = localApplyUploadRsp.uint32_pack_size.get();
    }
    localObject2 = HexUtil.bytes2HexStr(localApplyUploadRsp.bytes_upload_key.get().toByteArray());
    localbeco.b = ((String)localObject2);
    parambdxe = localApplyUploadRsp.str_upload_ip.get();
    parambdxf = parambdxe;
    if (parambdxe == null) {
      parambdxf = localApplyUploadRsp.str_upload_domain.get();
    }
    for (;;)
    {
      label473:
      throw new Exception("ukey or ip missing");
      label577:
      do
      {
        parambdxf = localApplyUploadRsp.rpt_str_uploadip_list.get();
        if ((parambdxf != null) && (parambdxf.size() > 0))
        {
          parambdxf = parambdxf.iterator();
          while (parambdxf.hasNext())
          {
            parambdxe = (String)parambdxf.next();
            localObject2 = new bdyf();
            ((bdyf)localObject2).jdField_a_of_type_JavaLangString = parambdxe;
            localbeco.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          }
        }
        a(0, 0, "", "", localanqe, localbeco);
        break;
        a(-1, -9527, bdsx.a(i), "", localanqe, localbeco);
        break;
        if (localObject2 == null) {
          break label473;
        }
      } while (parambdxf != null);
    }
  }
  
  public void a(bebv parambebv)
  {
    if ((parambebv != null) && (parambebv.jdField_a_of_type_JavaUtilList != null) && (parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bdxe localbdxe = new bdxe();
      localbdxe.jdField_a_of_type_JavaLangString = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500";
      localbdxe.jdField_a_of_type_ArrayOfByte = a(parambebv.jdField_a_of_type_JavaUtilList);
      localbdxe.jdField_a_of_type_JavaLangObject = parambebv;
      localbdxe.jdField_a_of_type_Bdxd = this;
      a(parambebv, localbdxe);
    }
  }
  
  byte[] a(List<becg> paramList)
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
    becf localbecf;
    if (paramList.size() == 1)
    {
      localbecf = (becf)paramList.get(0);
      cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
      localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localbecf.jdField_c_of_type_JavaLangString));
      try
      {
        localObject = localbecf.jdField_d_of_type_JavaLangString;
        paramList = (List<becg>)localObject;
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
          if (localbecf.jdField_a_of_type_Boolean)
          {
            i = 500;
            continue;
            paramList.str_dst_phonenum.set(localbecf.jdField_d_of_type_JavaLangString);
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
            i = 100;
            continue;
            i = 114;
            continue;
            i = 130;
            continue;
            if (localbecf.f == 9999) {
              paramList.uint32_file_type.set(102);
            }
          }
        }
      }
      localApplyUploadReq.uint32_file_type.set(2);
      localApplyUploadReq.str_file_name.set(localbecf.jdField_a_of_type_JavaLangString);
      localApplyUploadReq.uint64_file_size.set(localbecf.b);
      localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localbecf.jdField_a_of_type_ArrayOfByte));
      localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
      paramList = new cmd0x346.ExtensionReq();
      paramList.uint64_id.set(3L);
      paramList.uint32_ptt_format.set(localbecf.jdField_c_of_type_Int);
      paramList.uint32_ptt_time.set(localbecf.jdField_a_of_type_Int);
      i = a();
      paramList.uint32_net_type.set(i);
      paramList.uint32_voice_type.set(localbecf.jdField_d_of_type_Int);
      if (QLog.isColorLevel())
      {
        QLog.d("RecordParams", 2, "C2CPttUp: panel[" + localbecf.jdField_d_of_type_Int + "] type[" + localbecf.jdField_c_of_type_Int + "] length[" + localbecf.jdField_a_of_type_Int + "] size[" + localbecf.b + "]");
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "C2CPttUp: net[" + i + "]");
        }
      }
      i = j;
      switch (localbecf.f)
      {
      default: 
        i = j;
      case 1005: 
      case 1023: 
      case 1024: 
        paramList.uint64_type.set(i);
        if (localbecf.f == 1008)
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
  
  void b(bebv parambebv)
  {
    beck localbeck = parambebv.jdField_a_of_type_Beck;
    localbeck.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambebv.jdField_a_of_type_JavaUtilList.size())
    {
      beco localbeco = new beco();
      localbeck.jdField_a_of_type_JavaUtilList.add(i, localbeco);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebj
 * JD-Core Version:    0.7.0.1
 */