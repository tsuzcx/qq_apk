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

public class bbch
  extends bbaj
{
  public void a(bavr parambavr, bavq parambavq)
  {
    Object localObject = parambavr.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = parambavr.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bbax localbbax = (bbax)parambavq.jdField_a_of_type_JavaLangObject;
    bbbm localbbbm = localbbax.jdField_a_of_type_Bbbm;
    alwy localalwy = parambavr.jdField_a_of_type_Alwy;
    int i;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject), "", localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      }
    }
    label770:
    label783:
    label911:
    for (;;)
    {
      bbcd.a(localbbax, localbbbm);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      continue;
      bbca localbbca;
      PttShortVideo.PttShortVideoAddr localPttShortVideoAddr;
      try
      {
        parambavr = new PttShortVideo.RspBody();
        parambavr.mergeFrom(arrayOfByte);
        parambavq = (PttShortVideo.PttShortVideoDownloadResp)parambavr.msg_PttShortVideoDownload_Resp.get();
        localbbca = (bbca)localbbbm.jdField_a_of_type_JavaUtilList.get(0);
        i = parambavq.int32_ret_code.get();
        if (i != 0) {
          break label800;
        }
        localbbca.jdField_a_of_type_JavaLangString = HexUtil.bytes2HexStr(parambavq.bytes_downloadkey.get().toByteArray());
        localbbca.jdField_a_of_type_ArrayOfByte = parambavq.bytes_file_md5.get().toByteArray();
        if (parambavq.bytes_encrypt_key.has()) {
          localbbca.jdField_b_of_type_ArrayOfByte = parambavq.bytes_encrypt_key.get().toByteArray();
        }
        localPttShortVideoAddr = (PttShortVideo.PttShortVideoAddr)parambavq.msg_download_addr.get();
        if (localPttShortVideoAddr == null) {
          break label783;
        }
        localbbca.jdField_a_of_type_Int = localPttShortVideoAddr.uint32_host_type.get();
        if (localbbca.jdField_a_of_type_Int != 0) {
          break label770;
        }
        localObject = localPttShortVideoAddr.rpt_str_host.get();
        bawy localbawy;
        if (localObject != null)
        {
          i = 0;
          while (i < ((List)localObject).size())
          {
            localbawy = new bawy();
            parambavq = (String)((List)localObject).get(i);
            parambavr = parambavq;
            if (parambavq.startsWith("http://")) {
              parambavr = parambavq.substring("http://".length());
            }
            parambavq = parambavr;
            if (parambavr.endsWith("/")) {
              parambavq = parambavr.substring(0, parambavr.length() - 1);
            }
            parambavr = parambavq.split(":");
            localbawy.jdField_a_of_type_JavaLangString = parambavr[0];
            if (parambavr.length == 2) {
              localbawy.jdField_a_of_type_Int = Integer.valueOf(parambavr[1]).intValue();
            }
            localbbca.jdField_a_of_type_JavaUtilArrayList.add(i, localbawy);
            i += 1;
          }
        }
        localObject = localPttShortVideoAddr.rpt_str_host_ipv6.get();
        if (localObject != null)
        {
          i = 0;
          if (i < ((List)localObject).size())
          {
            localbawy = new bawy();
            parambavq = (String)((List)localObject).get(i);
            parambavr = parambavq;
            if (parambavq.startsWith("http://")) {
              parambavr = parambavq.substring("http://".length());
            }
            parambavq = parambavr;
            if (parambavr.endsWith("/")) {
              parambavq = parambavr.substring(0, parambavr.length() - 1);
            }
            if (parambavq.lastIndexOf(':') > parambavq.lastIndexOf(']'))
            {
              localbawy.jdField_a_of_type_JavaLangString = parambavq.substring(0, parambavq.lastIndexOf(']') + 1);
              localbawy.jdField_a_of_type_Int = Integer.valueOf(parambavq.substring(parambavq.lastIndexOf(':') + 1)).intValue();
            }
            for (;;)
            {
              localbawy.jdField_a_of_type_Boolean = true;
              localbbca.jdField_b_of_type_JavaUtilArrayList.add(i, localbawy);
              i += 1;
              break;
              localbawy.jdField_a_of_type_JavaLangString = parambavq;
            }
          }
        }
      }
      catch (Exception parambavr)
      {
        a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      }
      parambavq = "";
      parambavr = parambavq;
      if (localPttShortVideoAddr.rpt_str_domain.has())
      {
        parambavr = parambavq;
        if (localPttShortVideoAddr.rpt_str_domain.size() > 0) {
          parambavr = (String)localPttShortVideoAddr.rpt_str_domain.get(0);
        }
      }
      localObject = parambavr;
      if (parambavr != null)
      {
        localObject = parambavr;
        if (parambavr.length() > 0)
        {
          parambavq = parambavr;
          if (parambavr.startsWith("http://")) {
            parambavq = parambavr.substring("http://".length());
          }
          localObject = parambavq;
          if (parambavq.endsWith("/")) {
            localObject = parambavq.substring(0, parambavq.length() - 1);
          }
        }
      }
      localbbca.jdField_b_of_type_JavaLangString = ((String)localObject);
      localbbca.jdField_c_of_type_JavaLangString = localPttShortVideoAddr.str_url_args.get();
      a(0, 0, "", "", localalwy, localbbca);
      continue;
      label800:
      if (i == -5100026) {
        a(-1, -5100026, barf.a(i), "", localalwy, localbbca);
      }
      for (;;)
      {
        if (parambavr.uint32_allow_retry.get() != 1) {
          break label911;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onProtoResp : shortVideo server not allow retry");
        }
        localbbca.e = false;
        break;
        if (i == -5100528) {
          a(-1, -5100528, barf.a(i), "", localalwy, localbbca);
        } else {
          a(-1, -9527, barf.a(i), "", localalwy, localbbca);
        }
      }
    }
  }
  
  public void a(bbax parambbax)
  {
    bavq localbavq;
    bbbi localbbbi;
    if ((parambbax != null) && (parambbax.jdField_a_of_type_JavaUtilList != null) && (parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      localbavq = new bavq();
      if (parambbax.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label134;
      }
      localbbbi = (bbbi)parambbax.jdField_a_of_type_JavaUtilList.get(0);
      if (localbbbi.f != 0) {
        break label96;
      }
      localbavq.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
    }
    for (;;)
    {
      localbavq.jdField_a_of_type_ArrayOfByte = a(parambbax.jdField_a_of_type_JavaUtilList);
      localbavq.jdField_a_of_type_JavaLangObject = parambbax;
      localbavq.jdField_a_of_type_Bavp = this;
      a(parambbax, localbavq);
      return;
      label96:
      if ((1 == localbbbi.f) || (3000 == localbbbi.f)) {
        localbavq.jdField_a_of_type_JavaLangString = "PttCenterSvr.GroupShortVideoDownReq";
      } else {
        localbavq.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
      }
    }
    label134:
    throw new RuntimeException("only support one request");
  }
  
  byte[] a(List<bbbi> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      paramList = (bbbj)paramList.get(0);
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
  
  void b(bbax parambbax)
  {
    bbbm localbbbm = parambbax.jdField_a_of_type_Bbbm;
    localbbbm.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambbax.jdField_a_of_type_JavaUtilList.size())
    {
      bbca localbbca = new bbca();
      localbbbm.jdField_a_of_type_JavaUtilList.add(i, localbbca);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbch
 * JD-Core Version:    0.7.0.1
 */