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

public class ayzz
  extends ayyb
{
  public void a(aytl paramaytl, aytk paramaytk)
  {
    Object localObject = paramaytl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramaytl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    ayyp localayyp = (ayyp)paramaytk.jdField_a_of_type_JavaLangObject;
    ayze localayze = localayyp.jdField_a_of_type_Ayze;
    akau localakau = paramaytl.jdField_a_of_type_Akau;
    int i;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject), "", localakau, localayze.jdField_a_of_type_JavaUtilList);
      }
    }
    label770:
    label783:
    label911:
    for (;;)
    {
      ayzv.a(localayyp, localayze);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localakau, localayze.jdField_a_of_type_JavaUtilList);
      continue;
      ayzs localayzs;
      PttShortVideo.PttShortVideoAddr localPttShortVideoAddr;
      try
      {
        paramaytl = new PttShortVideo.RspBody();
        paramaytl.mergeFrom(arrayOfByte);
        paramaytk = (PttShortVideo.PttShortVideoDownloadResp)paramaytl.msg_PttShortVideoDownload_Resp.get();
        localayzs = (ayzs)localayze.jdField_a_of_type_JavaUtilList.get(0);
        i = paramaytk.int32_ret_code.get();
        if (i != 0) {
          break label800;
        }
        localayzs.jdField_a_of_type_JavaLangString = HexUtil.bytes2HexStr(paramaytk.bytes_downloadkey.get().toByteArray());
        localayzs.jdField_a_of_type_ArrayOfByte = paramaytk.bytes_file_md5.get().toByteArray();
        if (paramaytk.bytes_encrypt_key.has()) {
          localayzs.jdField_b_of_type_ArrayOfByte = paramaytk.bytes_encrypt_key.get().toByteArray();
        }
        localPttShortVideoAddr = (PttShortVideo.PttShortVideoAddr)paramaytk.msg_download_addr.get();
        if (localPttShortVideoAddr == null) {
          break label783;
        }
        localayzs.jdField_a_of_type_Int = localPttShortVideoAddr.uint32_host_type.get();
        if (localayzs.jdField_a_of_type_Int != 0) {
          break label770;
        }
        localObject = localPttShortVideoAddr.rpt_str_host.get();
        ayuq localayuq;
        if (localObject != null)
        {
          i = 0;
          while (i < ((List)localObject).size())
          {
            localayuq = new ayuq();
            paramaytk = (String)((List)localObject).get(i);
            paramaytl = paramaytk;
            if (paramaytk.startsWith("http://")) {
              paramaytl = paramaytk.substring("http://".length());
            }
            paramaytk = paramaytl;
            if (paramaytl.endsWith("/")) {
              paramaytk = paramaytl.substring(0, paramaytl.length() - 1);
            }
            paramaytl = paramaytk.split(":");
            localayuq.jdField_a_of_type_JavaLangString = paramaytl[0];
            if (paramaytl.length == 2) {
              localayuq.jdField_a_of_type_Int = Integer.valueOf(paramaytl[1]).intValue();
            }
            localayzs.jdField_a_of_type_JavaUtilArrayList.add(i, localayuq);
            i += 1;
          }
        }
        localObject = localPttShortVideoAddr.rpt_str_host_ipv6.get();
        if (localObject != null)
        {
          i = 0;
          if (i < ((List)localObject).size())
          {
            localayuq = new ayuq();
            paramaytk = (String)((List)localObject).get(i);
            paramaytl = paramaytk;
            if (paramaytk.startsWith("http://")) {
              paramaytl = paramaytk.substring("http://".length());
            }
            paramaytk = paramaytl;
            if (paramaytl.endsWith("/")) {
              paramaytk = paramaytl.substring(0, paramaytl.length() - 1);
            }
            if (paramaytk.lastIndexOf(':') > paramaytk.lastIndexOf(']'))
            {
              localayuq.jdField_a_of_type_JavaLangString = paramaytk.substring(0, paramaytk.lastIndexOf(']') + 1);
              localayuq.jdField_a_of_type_Int = Integer.valueOf(paramaytk.substring(paramaytk.lastIndexOf(':') + 1)).intValue();
            }
            for (;;)
            {
              localayuq.jdField_a_of_type_Boolean = true;
              localayzs.jdField_b_of_type_JavaUtilArrayList.add(i, localayuq);
              i += 1;
              break;
              localayuq.jdField_a_of_type_JavaLangString = paramaytk;
            }
          }
        }
      }
      catch (Exception paramaytl)
      {
        a(-1, -9527, aypb.a("P", -9529L), paramaytl.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakau, localayze.jdField_a_of_type_JavaUtilList);
      }
      paramaytk = "";
      paramaytl = paramaytk;
      if (localPttShortVideoAddr.rpt_str_domain.has())
      {
        paramaytl = paramaytk;
        if (localPttShortVideoAddr.rpt_str_domain.size() > 0) {
          paramaytl = (String)localPttShortVideoAddr.rpt_str_domain.get(0);
        }
      }
      localObject = paramaytl;
      if (paramaytl != null)
      {
        localObject = paramaytl;
        if (paramaytl.length() > 0)
        {
          paramaytk = paramaytl;
          if (paramaytl.startsWith("http://")) {
            paramaytk = paramaytl.substring("http://".length());
          }
          localObject = paramaytk;
          if (paramaytk.endsWith("/")) {
            localObject = paramaytk.substring(0, paramaytk.length() - 1);
          }
        }
      }
      localayzs.jdField_b_of_type_JavaLangString = ((String)localObject);
      localayzs.jdField_c_of_type_JavaLangString = localPttShortVideoAddr.str_url_args.get();
      a(0, 0, "", "", localakau, localayzs);
      continue;
      label800:
      if (i == -5100026) {
        a(-1, -5100026, aypb.a(i), "", localakau, localayzs);
      }
      for (;;)
      {
        if (paramaytl.uint32_allow_retry.get() != 1) {
          break label911;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onProtoResp : shortVideo server not allow retry");
        }
        localayzs.e = false;
        break;
        if (i == -5100528) {
          a(-1, -5100528, aypb.a(i), "", localakau, localayzs);
        } else {
          a(-1, -9527, aypb.a(i), "", localakau, localayzs);
        }
      }
    }
  }
  
  public void a(ayyp paramayyp)
  {
    aytk localaytk;
    ayza localayza;
    if ((paramayyp != null) && (paramayyp.jdField_a_of_type_JavaUtilList != null) && (paramayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      localaytk = new aytk();
      if (paramayyp.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label134;
      }
      localayza = (ayza)paramayyp.jdField_a_of_type_JavaUtilList.get(0);
      if (localayza.f != 0) {
        break label96;
      }
      localaytk.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
    }
    for (;;)
    {
      localaytk.jdField_a_of_type_ArrayOfByte = a(paramayyp.jdField_a_of_type_JavaUtilList);
      localaytk.jdField_a_of_type_JavaLangObject = paramayyp;
      localaytk.jdField_a_of_type_Aytj = this;
      a(paramayyp, localaytk);
      return;
      label96:
      if ((1 == localayza.f) || (3000 == localayza.f)) {
        localaytk.jdField_a_of_type_JavaLangString = "PttCenterSvr.GroupShortVideoDownReq";
      } else {
        localaytk.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
      }
    }
    label134:
    throw new RuntimeException("only support one request");
  }
  
  byte[] a(List<ayza> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      paramList = (ayzb)paramList.get(0);
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
  
  void b(ayyp paramayyp)
  {
    ayze localayze = paramayyp.jdField_a_of_type_Ayze;
    localayze.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramayyp.jdField_a_of_type_JavaUtilList.size())
    {
      ayzs localayzs = new ayzs();
      localayze.jdField_a_of_type_JavaUtilList.add(i, localayzs);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayzz
 * JD-Core Version:    0.7.0.1
 */