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
import java.util.List<Lbfbf;>;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class bfai
  extends bfae
{
  private static int a;
  
  public void a(bevy parambevy, bevx parambevx)
  {
    Object localObject2 = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject1 = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bfau localbfau = (bfau)parambevx.jdField_a_of_type_JavaLangObject;
    bfbj localbfbj = localbfau.jdField_a_of_type_Bfbj;
    aock localaock = parambevy.jdField_a_of_type_Aock;
    int i;
    if (((FromServiceMsg)localObject2).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject2).getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
        parambevx = ((FromServiceMsg)localObject2).getBusinessFailMsg();
        parambevy = parambevx;
        if (parambevx == null) {
          parambevy = "";
        }
        a(-1, 9311, (String)localObject1, parambevy, localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      }
    }
    cmd0x346.ApplyUploadRsp localApplyUploadRsp;
    bfbn localbfbn;
    for (;;)
    {
      bfca.a(localbfau, localbfbj);
      return;
      localObject1 = MessageHandler.a((FromServiceMsg)localObject2);
      parambevx = ((FromServiceMsg)localObject2).getBusinessFailMsg();
      parambevy = parambevx;
      if (parambevx == null) {
        parambevy = "";
      }
      a(-1, 9044, (String)localObject1, parambevy, localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        parambevy = new cmd0x346.RspBody();
        parambevy.mergeFrom((byte[])localObject1);
        localApplyUploadRsp = (cmd0x346.ApplyUploadRsp)parambevy.msg_apply_upload_rsp.get();
        localbfbn = (bfbn)localbfbj.jdField_a_of_type_JavaUtilList.get(0);
        if ((localbfbn != null) && (localObject2 != null) && (((FromServiceMsg)localObject2).getAttributes().containsKey("_attr_send_by_quickHttp"))) {
          localbfbn.d = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        }
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttUpHandler.onProtoResp:isSendByQuickHttp=" + localbfbn.d);
        }
        i = localApplyUploadRsp.int32_ret_code.get();
        if (i != 0) {
          break label577;
        }
        localbfbn.jdField_a_of_type_JavaLangString = localApplyUploadRsp.bytes_uuid.get().toStringUtf8();
        if ((!localApplyUploadRsp.bool_file_exist.has()) || (!localApplyUploadRsp.bool_file_exist.get())) {
          break;
        }
        localbfbn.jdField_a_of_type_Boolean = true;
      }
      catch (Exception parambevy)
      {
        a(-1, -9527, berp.a("P", -9529L), parambevy.getMessage() + " hex:" + HexUtil.bytes2HexStr((byte[])localObject1), localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      }
    }
    if (localApplyUploadRsp.uint32_pack_size.has()) {
      localbfbn.jdField_a_of_type_Int = localApplyUploadRsp.uint32_pack_size.get();
    }
    localObject2 = HexUtil.bytes2HexStr(localApplyUploadRsp.bytes_upload_key.get().toByteArray());
    localbfbn.b = ((String)localObject2);
    parambevx = localApplyUploadRsp.str_upload_ip.get();
    parambevy = parambevx;
    if (parambevx == null) {
      parambevy = localApplyUploadRsp.str_upload_domain.get();
    }
    for (;;)
    {
      label473:
      throw new Exception("ukey or ip missing");
      label577:
      do
      {
        parambevy = localApplyUploadRsp.rpt_str_uploadip_list.get();
        if ((parambevy != null) && (parambevy.size() > 0))
        {
          parambevy = parambevy.iterator();
          while (parambevy.hasNext())
          {
            parambevx = (String)parambevy.next();
            localObject2 = new bewy();
            ((bewy)localObject2).jdField_a_of_type_JavaLangString = parambevx;
            localbfbn.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          }
        }
        a(0, 0, "", "", localaock, localbfbn);
        break;
        a(-1, -9527, berp.a(i), "", localaock, localbfbn);
        break;
        if (localObject2 == null) {
          break label473;
        }
      } while (parambevy != null);
    }
  }
  
  public void a(bfau parambfau)
  {
    if ((parambfau != null) && (parambfau.jdField_a_of_type_JavaUtilList != null) && (parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bevx localbevx = new bevx();
      localbevx.jdField_a_of_type_JavaLangString = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500";
      localbevx.jdField_a_of_type_ArrayOfByte = a(parambfau.jdField_a_of_type_JavaUtilList);
      localbevx.jdField_a_of_type_JavaLangObject = parambfau;
      localbevx.jdField_a_of_type_Bevw = this;
      a(parambfau, localbevx);
    }
  }
  
  byte[] a(List<bfbf> paramList)
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
    bfbe localbfbe;
    if (paramList.size() == 1)
    {
      localbfbe = (bfbe)paramList.get(0);
      cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
      localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localbfbe.jdField_c_of_type_JavaLangString));
      try
      {
        localObject = localbfbe.jdField_d_of_type_JavaLangString;
        paramList = (List<bfbf>)localObject;
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
          if (localbfbe.jdField_a_of_type_Boolean)
          {
            i = 500;
            continue;
            paramList.str_dst_phonenum.set(localbfbe.jdField_d_of_type_JavaLangString);
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
            if (localbfbe.f == 9999) {
              paramList.uint32_file_type.set(102);
            }
          }
        }
      }
      localApplyUploadReq.uint32_file_type.set(2);
      localApplyUploadReq.str_file_name.set(localbfbe.jdField_a_of_type_JavaLangString);
      localApplyUploadReq.uint64_file_size.set(localbfbe.b);
      localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localbfbe.jdField_a_of_type_ArrayOfByte));
      localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
      paramList = new cmd0x346.ExtensionReq();
      paramList.uint64_id.set(3L);
      paramList.uint32_ptt_format.set(localbfbe.jdField_c_of_type_Int);
      paramList.uint32_ptt_time.set(localbfbe.jdField_a_of_type_Int);
      i = a();
      paramList.uint32_net_type.set(i);
      paramList.uint32_voice_type.set(localbfbe.jdField_d_of_type_Int);
      if (QLog.isColorLevel())
      {
        QLog.d("RecordParams", 2, "C2CPttUp: panel[" + localbfbe.jdField_d_of_type_Int + "] type[" + localbfbe.jdField_c_of_type_Int + "] length[" + localbfbe.jdField_a_of_type_Int + "] size[" + localbfbe.b + "]");
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "C2CPttUp: net[" + i + "]");
        }
      }
      i = j;
      switch (localbfbe.f)
      {
      default: 
        i = j;
      case 1005: 
      case 1023: 
      case 1024: 
        paramList.uint64_type.set(i);
        if (localbfbe.f == 1008)
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
  
  void b(bfau parambfau)
  {
    bfbj localbfbj = parambfau.jdField_a_of_type_Bfbj;
    localbfbj.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambfau.jdField_a_of_type_JavaUtilList.size())
    {
      bfbn localbfbn = new bfbn();
      localbfbj.jdField_a_of_type_JavaUtilList.add(i, localbfbn);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfai
 * JD-Core Version:    0.7.0.1
 */