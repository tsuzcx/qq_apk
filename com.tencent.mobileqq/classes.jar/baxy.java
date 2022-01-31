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

public class baxy
  extends bawa
{
  public void a(bari parambari, barh parambarh)
  {
    Object localObject = parambari.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = parambari.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bawo localbawo = (bawo)parambarh.jdField_a_of_type_JavaLangObject;
    baxd localbaxd = localbawo.jdField_a_of_type_Baxd;
    alsj localalsj = parambari.jdField_a_of_type_Alsj;
    int i;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject), "", localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      }
    }
    label770:
    label783:
    label911:
    for (;;)
    {
      baxu.a(localbawo, localbaxd);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      continue;
      baxr localbaxr;
      PttShortVideo.PttShortVideoAddr localPttShortVideoAddr;
      try
      {
        parambari = new PttShortVideo.RspBody();
        parambari.mergeFrom(arrayOfByte);
        parambarh = (PttShortVideo.PttShortVideoDownloadResp)parambari.msg_PttShortVideoDownload_Resp.get();
        localbaxr = (baxr)localbaxd.jdField_a_of_type_JavaUtilList.get(0);
        i = parambarh.int32_ret_code.get();
        if (i != 0) {
          break label800;
        }
        localbaxr.jdField_a_of_type_JavaLangString = HexUtil.bytes2HexStr(parambarh.bytes_downloadkey.get().toByteArray());
        localbaxr.jdField_a_of_type_ArrayOfByte = parambarh.bytes_file_md5.get().toByteArray();
        if (parambarh.bytes_encrypt_key.has()) {
          localbaxr.jdField_b_of_type_ArrayOfByte = parambarh.bytes_encrypt_key.get().toByteArray();
        }
        localPttShortVideoAddr = (PttShortVideo.PttShortVideoAddr)parambarh.msg_download_addr.get();
        if (localPttShortVideoAddr == null) {
          break label783;
        }
        localbaxr.jdField_a_of_type_Int = localPttShortVideoAddr.uint32_host_type.get();
        if (localbaxr.jdField_a_of_type_Int != 0) {
          break label770;
        }
        localObject = localPttShortVideoAddr.rpt_str_host.get();
        basp localbasp;
        if (localObject != null)
        {
          i = 0;
          while (i < ((List)localObject).size())
          {
            localbasp = new basp();
            parambarh = (String)((List)localObject).get(i);
            parambari = parambarh;
            if (parambarh.startsWith("http://")) {
              parambari = parambarh.substring("http://".length());
            }
            parambarh = parambari;
            if (parambari.endsWith("/")) {
              parambarh = parambari.substring(0, parambari.length() - 1);
            }
            parambari = parambarh.split(":");
            localbasp.jdField_a_of_type_JavaLangString = parambari[0];
            if (parambari.length == 2) {
              localbasp.jdField_a_of_type_Int = Integer.valueOf(parambari[1]).intValue();
            }
            localbaxr.jdField_a_of_type_JavaUtilArrayList.add(i, localbasp);
            i += 1;
          }
        }
        localObject = localPttShortVideoAddr.rpt_str_host_ipv6.get();
        if (localObject != null)
        {
          i = 0;
          if (i < ((List)localObject).size())
          {
            localbasp = new basp();
            parambarh = (String)((List)localObject).get(i);
            parambari = parambarh;
            if (parambarh.startsWith("http://")) {
              parambari = parambarh.substring("http://".length());
            }
            parambarh = parambari;
            if (parambari.endsWith("/")) {
              parambarh = parambari.substring(0, parambari.length() - 1);
            }
            if (parambarh.lastIndexOf(':') > parambarh.lastIndexOf(']'))
            {
              localbasp.jdField_a_of_type_JavaLangString = parambarh.substring(0, parambarh.lastIndexOf(']') + 1);
              localbasp.jdField_a_of_type_Int = Integer.valueOf(parambarh.substring(parambarh.lastIndexOf(':') + 1)).intValue();
            }
            for (;;)
            {
              localbasp.jdField_a_of_type_Boolean = true;
              localbaxr.jdField_b_of_type_JavaUtilArrayList.add(i, localbasp);
              i += 1;
              break;
              localbasp.jdField_a_of_type_JavaLangString = parambarh;
            }
          }
        }
      }
      catch (Exception parambari)
      {
        a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      }
      parambarh = "";
      parambari = parambarh;
      if (localPttShortVideoAddr.rpt_str_domain.has())
      {
        parambari = parambarh;
        if (localPttShortVideoAddr.rpt_str_domain.size() > 0) {
          parambari = (String)localPttShortVideoAddr.rpt_str_domain.get(0);
        }
      }
      localObject = parambari;
      if (parambari != null)
      {
        localObject = parambari;
        if (parambari.length() > 0)
        {
          parambarh = parambari;
          if (parambari.startsWith("http://")) {
            parambarh = parambari.substring("http://".length());
          }
          localObject = parambarh;
          if (parambarh.endsWith("/")) {
            localObject = parambarh.substring(0, parambarh.length() - 1);
          }
        }
      }
      localbaxr.jdField_b_of_type_JavaLangString = ((String)localObject);
      localbaxr.jdField_c_of_type_JavaLangString = localPttShortVideoAddr.str_url_args.get();
      a(0, 0, "", "", localalsj, localbaxr);
      continue;
      label800:
      if (i == -5100026) {
        a(-1, -5100026, bamw.a(i), "", localalsj, localbaxr);
      }
      for (;;)
      {
        if (parambari.uint32_allow_retry.get() != 1) {
          break label911;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onProtoResp : shortVideo server not allow retry");
        }
        localbaxr.e = false;
        break;
        if (i == -5100528) {
          a(-1, -5100528, bamw.a(i), "", localalsj, localbaxr);
        } else {
          a(-1, -9527, bamw.a(i), "", localalsj, localbaxr);
        }
      }
    }
  }
  
  public void a(bawo parambawo)
  {
    barh localbarh;
    bawz localbawz;
    if ((parambawo != null) && (parambawo.jdField_a_of_type_JavaUtilList != null) && (parambawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      localbarh = new barh();
      if (parambawo.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label134;
      }
      localbawz = (bawz)parambawo.jdField_a_of_type_JavaUtilList.get(0);
      if (localbawz.f != 0) {
        break label96;
      }
      localbarh.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
    }
    for (;;)
    {
      localbarh.jdField_a_of_type_ArrayOfByte = a(parambawo.jdField_a_of_type_JavaUtilList);
      localbarh.jdField_a_of_type_JavaLangObject = parambawo;
      localbarh.jdField_a_of_type_Barg = this;
      a(parambawo, localbarh);
      return;
      label96:
      if ((1 == localbawz.f) || (3000 == localbawz.f)) {
        localbarh.jdField_a_of_type_JavaLangString = "PttCenterSvr.GroupShortVideoDownReq";
      } else {
        localbarh.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
      }
    }
    label134:
    throw new RuntimeException("only support one request");
  }
  
  byte[] a(List<bawz> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      paramList = (baxa)paramList.get(0);
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
  
  void b(bawo parambawo)
  {
    baxd localbaxd = parambawo.jdField_a_of_type_Baxd;
    localbaxd.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambawo.jdField_a_of_type_JavaUtilList.size())
    {
      baxr localbaxr = new baxr();
      localbaxd.jdField_a_of_type_JavaUtilList.add(i, localbaxr);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baxy
 * JD-Core Version:    0.7.0.1
 */