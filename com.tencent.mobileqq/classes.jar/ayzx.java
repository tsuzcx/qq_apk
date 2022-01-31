import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pttcenterservice.PttShortVideo.ExtensionReq;
import pttcenterservice.PttShortVideo.PttShortVideoAddr;
import pttcenterservice.PttShortVideo.PttShortVideoDownloadReq;
import pttcenterservice.PttShortVideo.PttShortVideoDownloadResp;
import pttcenterservice.PttShortVideo.ReqBody;
import pttcenterservice.PttShortVideo.RspBody;

public class ayzx
  extends ayxz
{
  public void a(aytj paramaytj, ayti paramayti)
  {
    Object localObject = paramaytj.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramaytj.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    ayyn localayyn = (ayyn)paramayti.jdField_a_of_type_JavaLangObject;
    ayzc localayzc = localayyn.jdField_a_of_type_Ayzc;
    akaw localakaw = paramaytj.jdField_a_of_type_Akaw;
    int i;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject), "", localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      }
    }
    label770:
    label783:
    label911:
    for (;;)
    {
      ayzt.a(localayyn, localayzc);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      continue;
      ayzq localayzq;
      PttShortVideo.PttShortVideoAddr localPttShortVideoAddr;
      try
      {
        paramaytj = new PttShortVideo.RspBody();
        paramaytj.mergeFrom(arrayOfByte);
        paramayti = (PttShortVideo.PttShortVideoDownloadResp)paramaytj.msg_PttShortVideoDownload_Resp.get();
        localayzq = (ayzq)localayzc.jdField_a_of_type_JavaUtilList.get(0);
        i = paramayti.int32_ret_code.get();
        if (i != 0) {
          break label800;
        }
        localayzq.jdField_a_of_type_JavaLangString = HexUtil.bytes2HexStr(paramayti.bytes_downloadkey.get().toByteArray());
        localayzq.jdField_a_of_type_ArrayOfByte = paramayti.bytes_file_md5.get().toByteArray();
        if (paramayti.bytes_encrypt_key.has()) {
          localayzq.jdField_b_of_type_ArrayOfByte = paramayti.bytes_encrypt_key.get().toByteArray();
        }
        localPttShortVideoAddr = (PttShortVideo.PttShortVideoAddr)paramayti.msg_download_addr.get();
        if (localPttShortVideoAddr == null) {
          break label783;
        }
        localayzq.jdField_a_of_type_Int = localPttShortVideoAddr.uint32_host_type.get();
        if (localayzq.jdField_a_of_type_Int != 0) {
          break label770;
        }
        localObject = localPttShortVideoAddr.rpt_str_host.get();
        ayuo localayuo;
        if (localObject != null)
        {
          i = 0;
          while (i < ((List)localObject).size())
          {
            localayuo = new ayuo();
            paramayti = (String)((List)localObject).get(i);
            paramaytj = paramayti;
            if (paramayti.startsWith("http://")) {
              paramaytj = paramayti.substring("http://".length());
            }
            paramayti = paramaytj;
            if (paramaytj.endsWith("/")) {
              paramayti = paramaytj.substring(0, paramaytj.length() - 1);
            }
            paramaytj = paramayti.split(":");
            localayuo.jdField_a_of_type_JavaLangString = paramaytj[0];
            if (paramaytj.length == 2) {
              localayuo.jdField_a_of_type_Int = Integer.valueOf(paramaytj[1]).intValue();
            }
            localayzq.jdField_a_of_type_JavaUtilArrayList.add(i, localayuo);
            i += 1;
          }
        }
        localObject = localPttShortVideoAddr.rpt_str_host_ipv6.get();
        if (localObject != null)
        {
          i = 0;
          if (i < ((List)localObject).size())
          {
            localayuo = new ayuo();
            paramayti = (String)((List)localObject).get(i);
            paramaytj = paramayti;
            if (paramayti.startsWith("http://")) {
              paramaytj = paramayti.substring("http://".length());
            }
            paramayti = paramaytj;
            if (paramaytj.endsWith("/")) {
              paramayti = paramaytj.substring(0, paramaytj.length() - 1);
            }
            if (paramayti.lastIndexOf(':') > paramayti.lastIndexOf(']'))
            {
              localayuo.jdField_a_of_type_JavaLangString = paramayti.substring(0, paramayti.lastIndexOf(']') + 1);
              localayuo.jdField_a_of_type_Int = Integer.valueOf(paramayti.substring(paramayti.lastIndexOf(':') + 1)).intValue();
            }
            for (;;)
            {
              localayuo.jdField_a_of_type_Boolean = true;
              localayzq.jdField_b_of_type_JavaUtilArrayList.add(i, localayuo);
              i += 1;
              break;
              localayuo.jdField_a_of_type_JavaLangString = paramayti;
            }
          }
        }
      }
      catch (Exception paramaytj)
      {
        a(-1, -9527, ayoz.a("P", -9529L), paramaytj.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      }
      paramayti = "";
      paramaytj = paramayti;
      if (localPttShortVideoAddr.rpt_str_domain.has())
      {
        paramaytj = paramayti;
        if (localPttShortVideoAddr.rpt_str_domain.size() > 0) {
          paramaytj = (String)localPttShortVideoAddr.rpt_str_domain.get(0);
        }
      }
      localObject = paramaytj;
      if (paramaytj != null)
      {
        localObject = paramaytj;
        if (paramaytj.length() > 0)
        {
          paramayti = paramaytj;
          if (paramaytj.startsWith("http://")) {
            paramayti = paramaytj.substring("http://".length());
          }
          localObject = paramayti;
          if (paramayti.endsWith("/")) {
            localObject = paramayti.substring(0, paramayti.length() - 1);
          }
        }
      }
      localayzq.jdField_b_of_type_JavaLangString = ((String)localObject);
      localayzq.jdField_c_of_type_JavaLangString = localPttShortVideoAddr.str_url_args.get();
      a(0, 0, "", "", localakaw, localayzq);
      continue;
      label800:
      if (i == -5100026) {
        a(-1, -5100026, ayoz.a(i), "", localakaw, localayzq);
      }
      for (;;)
      {
        if (paramaytj.uint32_allow_retry.get() != 1) {
          break label911;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onProtoResp : shortVideo server not allow retry");
        }
        localayzq.e = false;
        break;
        if (i == -5100528) {
          a(-1, -5100528, ayoz.a(i), "", localakaw, localayzq);
        } else {
          a(-1, -9527, ayoz.a(i), "", localakaw, localayzq);
        }
      }
    }
  }
  
  public void a(ayyn paramayyn)
  {
    ayti localayti;
    ayyy localayyy;
    if ((paramayyn != null) && (paramayyn.jdField_a_of_type_JavaUtilList != null) && (paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      localayti = new ayti();
      if (paramayyn.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label134;
      }
      localayyy = (ayyy)paramayyn.jdField_a_of_type_JavaUtilList.get(0);
      if (localayyy.f != 0) {
        break label96;
      }
      localayti.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
    }
    for (;;)
    {
      localayti.jdField_a_of_type_ArrayOfByte = a(paramayyn.jdField_a_of_type_JavaUtilList);
      localayti.jdField_a_of_type_JavaLangObject = paramayyn;
      localayti.jdField_a_of_type_Ayth = this;
      a(paramayyn, localayti);
      return;
      label96:
      if ((1 == localayyy.f) || (3000 == localayyy.f)) {
        localayti.jdField_a_of_type_JavaLangString = "PttCenterSvr.GroupShortVideoDownReq";
      } else {
        localayti.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
      }
    }
    label134:
    throw new RuntimeException("only support one request");
  }
  
  byte[] a(List<ayyy> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      paramList = (ayyz)paramList.get(0);
      PttShortVideo.PttShortVideoDownloadReq localPttShortVideoDownloadReq = new PttShortVideo.PttShortVideoDownloadReq();
      localPttShortVideoDownloadReq.uint64_touin.set(Long.parseLong(paramList.jdField_c_of_type_JavaLangString));
      localPttShortVideoDownloadReq.uint32_chat_type.set(paramList.jdField_a_of_type_Int);
      if (paramList.jdField_a_of_type_Int == 0)
      {
        localPttShortVideoDownloadReq.uint64_fromuin.set(Long.parseLong(paramList.jdField_d_of_type_JavaLangString));
        localPttShortVideoDownloadReq.uint32_client_type.set(paramList.jdField_b_of_type_Int);
        localPttShortVideoDownloadReq.str_fileid.set(paramList.jdField_a_of_type_JavaLangString);
        if (paramList.jdField_b_of_type_JavaLangString == null) {
          break label386;
        }
        localPttShortVideoDownloadReq.uint64_group_code.set(Long.parseLong(paramList.jdField_b_of_type_JavaLangString));
      }
      for (;;)
      {
        localPttShortVideoDownloadReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramList.jdField_a_of_type_ArrayOfByte));
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ShortVideoDownHandler", 2, "download md5 = " + paramList.jdField_a_of_type_ArrayOfByte);
        }
        localPttShortVideoDownloadReq.uint32_agent_type.set(paramList.jdField_d_of_type_Int);
        localPttShortVideoDownloadReq.uint32_business_type.set(paramList.jdField_e_of_type_Int);
        localPttShortVideoDownloadReq.uint32_flag_support_large_size.set(1);
        localPttShortVideoDownloadReq.uint32_file_type.set(paramList.g);
        localPttShortVideoDownloadReq.uint32_down_type.set(paramList.h);
        localPttShortVideoDownloadReq.uint32_scene_type.set(paramList.i);
        localPttShortVideoDownloadReq.uint32_need_inner_addr.set(0);
        localPttShortVideoDownloadReq.uint32_req_transfer_type.set(0);
        localPttShortVideoDownloadReq.uint32_req_host_type.set(11);
        PttShortVideo.ExtensionReq localExtensionReq = new PttShortVideo.ExtensionReq();
        localExtensionReq.uint32_sub_busi_type.set(paramList.j);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ShortVideoDownHandler", 2, "constructReqBody ShortVideoDownReq = " + paramList.toString());
        }
        localReqBody.uint32_cmd.set(400);
        localReqBody.uint32_seq.set(paramList.jdField_c_of_type_Int);
        localReqBody.msg_PttShortVideoDownload_Req.set(localPttShortVideoDownloadReq);
        localReqBody.rpt_msg_extension_req.add(localExtensionReq);
        return localReqBody.toByteArray();
        localPttShortVideoDownloadReq.uint64_fromuin.set(Long.parseLong(paramList.jdField_e_of_type_JavaLangString));
        break;
        label386:
        localPttShortVideoDownloadReq.uint64_group_code.set(0L);
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
      ayzq localayzq = new ayzq();
      localayzc.jdField_a_of_type_JavaUtilList.add(i, localayzq);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayzx
 * JD-Core Version:    0.7.0.1
 */