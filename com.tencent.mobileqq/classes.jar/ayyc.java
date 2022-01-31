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

public class ayyc
  extends ayxz
{
  int a;
  
  public ayyc()
  {
    this.jdField_a_of_type_Int = 17;
  }
  
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
      Object localObject3;
      ayuo localayuo;
      try
      {
        paramayti = new cmd0x346.RspBody();
        paramayti.mergeFrom((byte[])localObject1);
        localObject3 = (cmd0x346.ApplyDownloadRsp)paramayti.msg_apply_download_rsp.get();
        paramaytj = (ayzf)localayzc.jdField_a_of_type_JavaUtilList.get(0);
        if (paramaytj != null) {
          paramaytj.d = ((Boolean)((FromServiceMsg)localObject2).getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        }
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "C2CPttDownHandler.onProtoResp:isSendByQuickHttp=" + paramaytj.d);
        }
        i = ((cmd0x346.ApplyDownloadRsp)localObject3).int32_ret_code.get();
        paramayti = (cmd0x346.ExtensionRsp)paramayti.msg_extension_rsp.get();
        if (i != 0) {
          break label637;
        }
        localObject2 = (cmd0x346.DownloadInfo)((cmd0x346.ApplyDownloadRsp)localObject3).msg_download_info.get();
        if ((localObject2 != null) && (((cmd0x346.DownloadInfo)localObject2).str_download_url.has()))
        {
          paramaytj.jdField_a_of_type_JavaLangString = ((cmd0x346.DownloadInfo)localObject2).str_download_url.get();
          localObject2 = ((cmd0x346.DownloadInfo)localObject2).rpt_str_downloadip_list.get();
          if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
            break label477;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            localayuo = new ayuo();
            localayuo.jdField_a_of_type_JavaLangString = ((String)localObject3);
            paramaytj.jdField_a_of_type_JavaUtilArrayList.add(localayuo);
          }
        }
      }
      catch (Exception paramaytj)
      {
        a(-1, -9527, ayoz.a("P", -9529L), paramaytj.getMessage() + " hex:" + HexUtil.bytes2HexStr((byte[])localObject1), localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      }
      throw new Exception("no url");
      label477:
      if ((paramayti != null) && (paramayti.server_addr_ipv6_list.has()))
      {
        paramayti = (cmd0x346.AddrList)paramayti.server_addr_ipv6_list.get();
        if (paramayti != null)
        {
          localObject2 = paramayti.rpt_str_ip.get();
          i = paramayti.uint32_port.get();
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              localayuo = new ayuo();
              localayuo.jdField_a_of_type_JavaLangString = ((String)localObject3);
              localayuo.jdField_a_of_type_Int = i;
              localayuo.jdField_a_of_type_Boolean = true;
              paramaytj.jdField_b_of_type_JavaUtilArrayList.add(localayuo);
            }
          }
          paramaytj.jdField_b_of_type_JavaLangString = paramayti.rpt_str_domain.get();
        }
      }
      a(0, 0, "", "", localakaw, paramaytj);
      continue;
      label637:
      if ((paramayti != null) && (paramayti.uint32_allow_retry.get() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onReceive :c2c ptt server not allow retry");
        }
        paramaytj.e = false;
      }
      a(-1, -9527, ayoz.a(i), "", localakaw, paramaytj);
    }
  }
  
  public void a(ayyn paramayyn)
  {
    if ((paramayyn != null) && (paramayyn.jdField_a_of_type_JavaUtilList != null) && (paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ayti localayti = new ayti();
      localayti.jdField_a_of_type_ArrayOfByte = a(paramayyn.jdField_a_of_type_JavaUtilList);
      localayti.jdField_a_of_type_JavaLangObject = paramayyn;
      localayti.jdField_a_of_type_JavaLangString = "PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200";
      if (this.jdField_a_of_type_Int == 3) {
        localayti.jdField_a_of_type_JavaLangString = "OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_APPLY_DOWNLOAD-1200";
      }
      localayti.jdField_a_of_type_Ayth = this;
      a(paramayyn, localayti);
    }
  }
  
  byte[] a(List<ayyy> paramList)
  {
    int i = 1;
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    if (paramList.size() == 1)
    {
      paramList = (ayyp)paramList.get(0);
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
  
  void b(ayyn paramayyn)
  {
    ayzc localayzc = paramayyn.jdField_a_of_type_Ayzc;
    localayzc.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramayyn.jdField_a_of_type_JavaUtilList.size())
    {
      ayzf localayzf = new ayzf();
      localayzc.jdField_a_of_type_JavaUtilList.add(i, localayzf);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyc
 * JD-Core Version:    0.7.0.1
 */