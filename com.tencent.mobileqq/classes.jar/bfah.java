import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x346.cmd0x346.AddrList;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class bfah
  extends bfae
{
  int a;
  
  public bfah()
  {
    this.jdField_a_of_type_Int = 17;
  }
  
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
      Object localObject3;
      bewy localbewy;
      try
      {
        parambevx = new cmd0x346.RspBody();
        parambevx.mergeFrom((byte[])localObject1);
        localObject3 = (cmd0x346.ApplyDownloadRsp)parambevx.msg_apply_download_rsp.get();
        parambevy = (bfbm)localbfbj.jdField_a_of_type_JavaUtilList.get(0);
        if (parambevy != null) {
          parambevy.d = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        }
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownHandler.onProtoResp:isSendByQuickHttp=" + parambevy.d);
        }
        i = ((cmd0x346.ApplyDownloadRsp)localObject3).int32_ret_code.get();
        parambevx = (cmd0x346.ExtensionRsp)parambevx.msg_extension_rsp.get();
        if (i != 0) {
          break label637;
        }
        localObject2 = (cmd0x346.DownloadInfo)((cmd0x346.ApplyDownloadRsp)localObject3).msg_download_info.get();
        if ((localObject2 != null) && (((cmd0x346.DownloadInfo)localObject2).str_download_url.has()))
        {
          parambevy.jdField_a_of_type_JavaLangString = ((cmd0x346.DownloadInfo)localObject2).str_download_url.get();
          localObject2 = ((cmd0x346.DownloadInfo)localObject2).rpt_str_downloadip_list.get();
          if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
            break label477;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            localbewy = new bewy();
            localbewy.jdField_a_of_type_JavaLangString = ((String)localObject3);
            parambevy.jdField_a_of_type_JavaUtilArrayList.add(localbewy);
          }
        }
      }
      catch (Exception parambevy)
      {
        a(-1, -9527, berp.a("P", -9529L), parambevy.getMessage() + " hex:" + HexUtil.bytes2HexStr((byte[])localObject1), localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      }
      throw new Exception("no url");
      label477:
      if ((parambevx != null) && (parambevx.server_addr_ipv6_list.has()))
      {
        parambevx = (cmd0x346.AddrList)parambevx.server_addr_ipv6_list.get();
        if (parambevx != null)
        {
          localObject2 = parambevx.rpt_str_ip.get();
          i = parambevx.uint32_port.get();
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              localbewy = new bewy();
              localbewy.jdField_a_of_type_JavaLangString = ((String)localObject3);
              localbewy.jdField_a_of_type_Int = i;
              localbewy.jdField_a_of_type_Boolean = true;
              parambevy.jdField_b_of_type_JavaUtilArrayList.add(localbewy);
            }
          }
          parambevy.jdField_b_of_type_JavaLangString = parambevx.rpt_str_domain.get();
        }
      }
      a(0, 0, "", "", localaock, parambevy);
      continue;
      label637:
      if ((parambevx != null) && (parambevx.uint32_allow_retry.get() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.C2CPttDownHandler", 2, "onReceive :c2c ptt server not allow retry");
        }
        parambevy.e = false;
      }
      a(-1, -9527, berp.a(i), "", localaock, parambevy);
    }
  }
  
  public void a(bfau parambfau)
  {
    if ((parambfau != null) && (parambfau.jdField_a_of_type_JavaUtilList != null) && (parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bevx localbevx = new bevx();
      localbevx.jdField_a_of_type_ArrayOfByte = a(parambfau.jdField_a_of_type_JavaUtilList);
      localbevx.jdField_a_of_type_JavaLangObject = parambfau;
      localbevx.jdField_a_of_type_JavaLangString = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200";
      if (this.jdField_a_of_type_Int == 3) {
        localbevx.jdField_a_of_type_JavaLangString = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_APPLY_DOWNLOAD-1200";
      }
      localbevx.jdField_a_of_type_Bevw = this;
      a(parambfau, localbevx);
    }
  }
  
  byte[] a(List<bfbf> paramList)
  {
    int i = 1;
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    if (paramList.size() == 1)
    {
      paramList = (bfaw)paramList.get(0);
      Object localObject;
      if ("ftn".equals(paramList.jdField_b_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Int = 3;
        localObject = new cmd0x346.ApplyDownloadReq();
        ((cmd0x346.ApplyDownloadReq)localObject).uint64_uin.set(Long.parseLong(paramList.c));
        ((cmd0x346.ApplyDownloadReq)localObject).bytes_uuid.set(ByteStringMicro.copyFromUtf8(paramList.jdField_a_of_type_JavaLangString));
        PBUInt32Field localPBUInt32Field = ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type;
        if (!paramList.jdField_a_of_type_Boolean) {
          break label445;
        }
        label102:
        localPBUInt32Field.set(i);
        localReqBody.uint32_cmd.set(1200);
        localReqBody.uint32_seq.set(0);
        localReqBody.uint32_business_id.set(this.jdField_a_of_type_Int);
        localReqBody.uint32_client_type.set(104);
        localReqBody.msg_apply_download_req.set((MessageMicro)localObject);
        if (paramList.f == 0) {
          break label525;
        }
        localObject = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
        switch (paramList.f)
        {
        default: 
          i = 0;
          label318:
          ((cmd0x346.ExtensionReq)localObject).uint64_type.set(i);
          ((cmd0x346.ExtensionReq)localObject).uint32_ptt_format.set(paramList.jdField_a_of_type_Int);
          ((cmd0x346.ExtensionReq)localObject).uint32_file_type.set(paramList.jdField_b_of_type_Int);
          ((cmd0x346.ExtensionReq)localObject).uint32_is_auto.set(paramList.d);
          ((cmd0x346.ExtensionReq)localObject).uint32_req_transfer_type.set(2);
          localReqBody.msg_extension_req.set((MessageMicro)localObject);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.C2CPttDownHandler", 2, "constructReqBody C2CPttDownReq = " + paramList.toString());
        }
        return localReqBody.toByteArray();
        if (!"pttcenter".equals(paramList.jdField_b_of_type_JavaLangString)) {
          break;
        }
        this.jdField_a_of_type_Int = 17;
        break;
        label445:
        i = 2;
        break label102;
        i = 0;
        break label318;
        i = 102;
        break label318;
        i = 104;
        break label318;
        i = 104;
        break label318;
        i = 105;
        break label318;
        i = 0;
        break label318;
        i = 0;
        break label318;
        i = 0;
        break label318;
        i = 101;
        break label318;
        i = 103;
        break label318;
        i = 100;
        break label318;
        i = 114;
        break label318;
        i = 130;
        break label318;
        label525:
        localObject = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject).uint32_ptt_format.set(paramList.jdField_a_of_type_Int);
        ((cmd0x346.ExtensionReq)localObject).uint32_is_auto.set(paramList.d);
        ((cmd0x346.ExtensionReq)localObject).uint32_req_transfer_type.set(2);
        localReqBody.msg_extension_req.set((MessageMicro)localObject);
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
      bfbm localbfbm = new bfbm();
      localbfbj.jdField_a_of_type_JavaUtilList.add(i, localbfbm);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfah
 * JD-Core Version:    0.7.0.1
 */