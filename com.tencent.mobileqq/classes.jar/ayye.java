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

public class ayye
  extends ayyb
{
  int a;
  
  public ayye()
  {
    this.jdField_a_of_type_Int = 17;
  }
  
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
      Object localObject3;
      ayuq localayuq;
      try
      {
        paramaytk = new cmd0x346.RspBody();
        paramaytk.mergeFrom((byte[])localObject1);
        localObject3 = (cmd0x346.ApplyDownloadRsp)paramaytk.msg_apply_download_rsp.get();
        paramaytl = (ayzh)localayze.jdField_a_of_type_JavaUtilList.get(0);
        if (paramaytl != null) {
          paramaytl.d = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        }
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownHandler.onProtoResp:isSendByQuickHttp=" + paramaytl.d);
        }
        i = ((cmd0x346.ApplyDownloadRsp)localObject3).int32_ret_code.get();
        paramaytk = (cmd0x346.ExtensionRsp)paramaytk.msg_extension_rsp.get();
        if (i != 0) {
          break label637;
        }
        localObject2 = (cmd0x346.DownloadInfo)((cmd0x346.ApplyDownloadRsp)localObject3).msg_download_info.get();
        if ((localObject2 != null) && (((cmd0x346.DownloadInfo)localObject2).str_download_url.has()))
        {
          paramaytl.jdField_a_of_type_JavaLangString = ((cmd0x346.DownloadInfo)localObject2).str_download_url.get();
          localObject2 = ((cmd0x346.DownloadInfo)localObject2).rpt_str_downloadip_list.get();
          if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
            break label477;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            localayuq = new ayuq();
            localayuq.jdField_a_of_type_JavaLangString = ((String)localObject3);
            paramaytl.jdField_a_of_type_JavaUtilArrayList.add(localayuq);
          }
        }
      }
      catch (Exception paramaytl)
      {
        a(-1, -9527, aypb.a("P", -9529L), paramaytl.getMessage() + " hex:" + HexUtil.bytes2HexStr((byte[])localObject1), localakau, localayze.jdField_a_of_type_JavaUtilList);
      }
      throw new Exception("no url");
      label477:
      if ((paramaytk != null) && (paramaytk.server_addr_ipv6_list.has()))
      {
        paramaytk = (cmd0x346.AddrList)paramaytk.server_addr_ipv6_list.get();
        if (paramaytk != null)
        {
          localObject2 = paramaytk.rpt_str_ip.get();
          i = paramaytk.uint32_port.get();
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              localayuq = new ayuq();
              localayuq.jdField_a_of_type_JavaLangString = ((String)localObject3);
              localayuq.jdField_a_of_type_Int = i;
              localayuq.jdField_a_of_type_Boolean = true;
              paramaytl.jdField_b_of_type_JavaUtilArrayList.add(localayuq);
            }
          }
          paramaytl.jdField_b_of_type_JavaLangString = paramaytk.rpt_str_domain.get();
        }
      }
      a(0, 0, "", "", localakau, paramaytl);
      continue;
      label637:
      if ((paramaytk != null) && (paramaytk.uint32_allow_retry.get() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onReceive :c2c ptt server not allow retry");
        }
        paramaytl.e = false;
      }
      a(-1, -9527, aypb.a(i), "", localakau, paramaytl);
    }
  }
  
  public void a(ayyp paramayyp)
  {
    if ((paramayyp != null) && (paramayyp.jdField_a_of_type_JavaUtilList != null) && (paramayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      aytk localaytk = new aytk();
      localaytk.jdField_a_of_type_ArrayOfByte = a(paramayyp.jdField_a_of_type_JavaUtilList);
      localaytk.jdField_a_of_type_JavaLangObject = paramayyp;
      localaytk.jdField_a_of_type_JavaLangString = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200";
      if (this.jdField_a_of_type_Int == 3) {
        localaytk.jdField_a_of_type_JavaLangString = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_APPLY_DOWNLOAD-1200";
      }
      localaytk.jdField_a_of_type_Aytj = this;
      a(paramayyp, localaytk);
    }
  }
  
  byte[] a(List<ayza> paramList)
  {
    int i = 1;
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    if (paramList.size() == 1)
    {
      paramList = (ayyr)paramList.get(0);
      Object localObject;
      if ("ftn".equals(paramList.jdField_b_of_type_JavaLangString))
      {
        this.jdField_a_of_type_Int = 3;
        localObject = new cmd0x346.ApplyDownloadReq();
        ((cmd0x346.ApplyDownloadReq)localObject).uint64_uin.set(Long.parseLong(paramList.c));
        ((cmd0x346.ApplyDownloadReq)localObject).bytes_uuid.set(ByteStringMicro.copyFromUtf8(paramList.jdField_a_of_type_JavaLangString));
        PBUInt32Field localPBUInt32Field = ((cmd0x346.ApplyDownloadReq)localObject).uint32_owner_type;
        if (!paramList.jdField_a_of_type_Boolean) {
          break label428;
        }
        label102:
        localPBUInt32Field.set(i);
        localReqBody.uint32_cmd.set(1200);
        localReqBody.uint32_seq.set(0);
        localReqBody.uint32_business_id.set(this.jdField_a_of_type_Int);
        localReqBody.uint32_client_type.set(104);
        localReqBody.msg_apply_download_req.set((MessageMicro)localObject);
        if (paramList.f == 0) {
          break label501;
        }
        localObject = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject).uint64_id.set(3L);
        switch (paramList.f)
        {
        default: 
          i = 0;
          label310:
          ((cmd0x346.ExtensionReq)localObject).uint64_type.set(i);
          ((cmd0x346.ExtensionReq)localObject).uint32_ptt_format.set(paramList.jdField_a_of_type_Int);
          ((cmd0x346.ExtensionReq)localObject).uint32_file_type.set(paramList.jdField_b_of_type_Int);
          ((cmd0x346.ExtensionReq)localObject).uint32_is_auto.set(paramList.d);
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
        label428:
        i = 2;
        break label102;
        i = 0;
        break label310;
        i = 102;
        break label310;
        i = 104;
        break label310;
        i = 104;
        break label310;
        i = 105;
        break label310;
        i = 0;
        break label310;
        i = 0;
        break label310;
        i = 0;
        break label310;
        i = 101;
        break label310;
        i = 103;
        break label310;
        i = 100;
        break label310;
        i = 114;
        break label310;
        label501:
        localObject = new cmd0x346.ExtensionReq();
        ((cmd0x346.ExtensionReq)localObject).uint32_ptt_format.set(paramList.jdField_a_of_type_Int);
        ((cmd0x346.ExtensionReq)localObject).uint32_is_auto.set(paramList.d);
        localReqBody.msg_extension_req.set((MessageMicro)localObject);
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
      ayzh localayzh = new ayzh();
      localayze.jdField_a_of_type_JavaUtilList.add(i, localayzh);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayye
 * JD-Core Version:    0.7.0.1
 */