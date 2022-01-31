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

public class axzq
  extends axxs
{
  public void a(axtc paramaxtc, axtb paramaxtb)
  {
    Object localObject = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    axyg localaxyg = (axyg)paramaxtb.jdField_a_of_type_JavaLangObject;
    axyv localaxyv = localaxyg.jdField_a_of_type_Axyv;
    ajmn localajmn = paramaxtc.jdField_a_of_type_Ajmn;
    int i;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject), "", localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
    }
    label770:
    label783:
    label911:
    for (;;)
    {
      axzm.a(localaxyg, localaxyv);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      continue;
      axzj localaxzj;
      PttShortVideo.PttShortVideoAddr localPttShortVideoAddr;
      try
      {
        paramaxtc = new PttShortVideo.RspBody();
        paramaxtc.mergeFrom(arrayOfByte);
        paramaxtb = (PttShortVideo.PttShortVideoDownloadResp)paramaxtc.msg_PttShortVideoDownload_Resp.get();
        localaxzj = (axzj)localaxyv.jdField_a_of_type_JavaUtilList.get(0);
        i = paramaxtb.int32_ret_code.get();
        if (i != 0) {
          break label800;
        }
        localaxzj.jdField_a_of_type_JavaLangString = HexUtil.bytes2HexStr(paramaxtb.bytes_downloadkey.get().toByteArray());
        localaxzj.jdField_a_of_type_ArrayOfByte = paramaxtb.bytes_file_md5.get().toByteArray();
        if (paramaxtb.bytes_encrypt_key.has()) {
          localaxzj.jdField_b_of_type_ArrayOfByte = paramaxtb.bytes_encrypt_key.get().toByteArray();
        }
        localPttShortVideoAddr = (PttShortVideo.PttShortVideoAddr)paramaxtb.msg_download_addr.get();
        if (localPttShortVideoAddr == null) {
          break label783;
        }
        localaxzj.jdField_a_of_type_Int = localPttShortVideoAddr.uint32_host_type.get();
        if (localaxzj.jdField_a_of_type_Int != 0) {
          break label770;
        }
        localObject = localPttShortVideoAddr.rpt_str_host.get();
        axuh localaxuh;
        if (localObject != null)
        {
          i = 0;
          while (i < ((List)localObject).size())
          {
            localaxuh = new axuh();
            paramaxtb = (String)((List)localObject).get(i);
            paramaxtc = paramaxtb;
            if (paramaxtb.startsWith("http://")) {
              paramaxtc = paramaxtb.substring("http://".length());
            }
            paramaxtb = paramaxtc;
            if (paramaxtc.endsWith("/")) {
              paramaxtb = paramaxtc.substring(0, paramaxtc.length() - 1);
            }
            paramaxtc = paramaxtb.split(":");
            localaxuh.jdField_a_of_type_JavaLangString = paramaxtc[0];
            if (paramaxtc.length == 2) {
              localaxuh.jdField_a_of_type_Int = Integer.valueOf(paramaxtc[1]).intValue();
            }
            localaxzj.jdField_a_of_type_JavaUtilArrayList.add(i, localaxuh);
            i += 1;
          }
        }
        localObject = localPttShortVideoAddr.rpt_str_host_ipv6.get();
        if (localObject != null)
        {
          i = 0;
          if (i < ((List)localObject).size())
          {
            localaxuh = new axuh();
            paramaxtb = (String)((List)localObject).get(i);
            paramaxtc = paramaxtb;
            if (paramaxtb.startsWith("http://")) {
              paramaxtc = paramaxtb.substring("http://".length());
            }
            paramaxtb = paramaxtc;
            if (paramaxtc.endsWith("/")) {
              paramaxtb = paramaxtc.substring(0, paramaxtc.length() - 1);
            }
            if (paramaxtb.lastIndexOf(':') > paramaxtb.lastIndexOf(']'))
            {
              localaxuh.jdField_a_of_type_JavaLangString = paramaxtb.substring(0, paramaxtb.lastIndexOf(']') + 1);
              localaxuh.jdField_a_of_type_Int = Integer.valueOf(paramaxtb.substring(paramaxtb.lastIndexOf(':') + 1)).intValue();
            }
            for (;;)
            {
              localaxuh.jdField_a_of_type_Boolean = true;
              localaxzj.jdField_b_of_type_JavaUtilArrayList.add(i, localaxuh);
              i += 1;
              break;
              localaxuh.jdField_a_of_type_JavaLangString = paramaxtb;
            }
          }
        }
      }
      catch (Exception paramaxtc)
      {
        a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
      paramaxtb = "";
      paramaxtc = paramaxtb;
      if (localPttShortVideoAddr.rpt_str_domain.has())
      {
        paramaxtc = paramaxtb;
        if (localPttShortVideoAddr.rpt_str_domain.size() > 0) {
          paramaxtc = (String)localPttShortVideoAddr.rpt_str_domain.get(0);
        }
      }
      localObject = paramaxtc;
      if (paramaxtc != null)
      {
        localObject = paramaxtc;
        if (paramaxtc.length() > 0)
        {
          paramaxtb = paramaxtc;
          if (paramaxtc.startsWith("http://")) {
            paramaxtb = paramaxtc.substring("http://".length());
          }
          localObject = paramaxtb;
          if (paramaxtb.endsWith("/")) {
            localObject = paramaxtb.substring(0, paramaxtb.length() - 1);
          }
        }
      }
      localaxzj.jdField_b_of_type_JavaLangString = ((String)localObject);
      localaxzj.jdField_c_of_type_JavaLangString = localPttShortVideoAddr.str_url_args.get();
      a(0, 0, "", "", localajmn, localaxzj);
      continue;
      label800:
      if (i == -5100026) {
        a(-1, -5100026, axou.a(i), "", localajmn, localaxzj);
      }
      for (;;)
      {
        if (paramaxtc.uint32_allow_retry.get() != 1) {
          break label911;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onProtoResp : shortVideo server not allow retry");
        }
        localaxzj.e = false;
        break;
        if (i == -5100528) {
          a(-1, -5100528, axou.a(i), "", localajmn, localaxzj);
        } else {
          a(-1, -9527, axou.a(i), "", localajmn, localaxzj);
        }
      }
    }
  }
  
  public void a(axyg paramaxyg)
  {
    axtb localaxtb;
    axyr localaxyr;
    if ((paramaxyg != null) && (paramaxyg.jdField_a_of_type_JavaUtilList != null) && (paramaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      localaxtb = new axtb();
      if (paramaxyg.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label134;
      }
      localaxyr = (axyr)paramaxyg.jdField_a_of_type_JavaUtilList.get(0);
      if (localaxyr.f != 0) {
        break label96;
      }
      localaxtb.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
    }
    for (;;)
    {
      localaxtb.jdField_a_of_type_ArrayOfByte = a(paramaxyg.jdField_a_of_type_JavaUtilList);
      localaxtb.jdField_a_of_type_JavaLangObject = paramaxyg;
      localaxtb.jdField_a_of_type_Axta = this;
      a(paramaxyg, localaxtb);
      return;
      label96:
      if ((1 == localaxyr.f) || (3000 == localaxyr.f)) {
        localaxtb.jdField_a_of_type_JavaLangString = "PttCenterSvr.GroupShortVideoDownReq";
      } else {
        localaxtb.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
      }
    }
    label134:
    throw new RuntimeException("only support one request");
  }
  
  byte[] a(List<axyr> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      paramList = (axys)paramList.get(0);
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
  
  void b(axyg paramaxyg)
  {
    axyv localaxyv = paramaxyg.jdField_a_of_type_Axyv;
    localaxyv.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramaxyg.jdField_a_of_type_JavaUtilList.size())
    {
      axzj localaxzj = new axzj();
      localaxyv.jdField_a_of_type_JavaUtilList.add(i, localaxzj);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axzq
 * JD-Core Version:    0.7.0.1
 */