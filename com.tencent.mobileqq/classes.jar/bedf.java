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
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pttcenterservice.PttShortVideo.ExtensionReq;
import pttcenterservice.PttShortVideo.PttShortVideoAddr;
import pttcenterservice.PttShortVideo.PttShortVideoDownloadReq;
import pttcenterservice.PttShortVideo.PttShortVideoDownloadResp;
import pttcenterservice.PttShortVideo.ReqBody;
import pttcenterservice.PttShortVideo.RspBody;

public class bedf
  extends bebf
{
  private ArrayList<bdyf> a(becy parambecy, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        try
        {
          bdyf localbdyf = new bdyf();
          URL localURL = new URL(str);
          localbdyf.jdField_a_of_type_JavaLangString = localURL.getHost();
          localbdyf.jdField_a_of_type_Int = localURL.getPort();
          localArrayList.add(localbdyf);
          if (!str.startsWith("https://")) {
            break label119;
          }
          parambecy.jdField_a_of_type_Boolean = true;
        }
        catch (Exception localException)
        {
          QLog.e("Q.richmedia.ShortVideoDownHandler", 1, "parseSrvAddlist err.", localException);
        }
        continue;
        label119:
        parambecy.jdField_a_of_type_Boolean = false;
      }
    }
    return localArrayList;
  }
  
  public void a(bdxf parambdxf, bdxe parambdxe)
  {
    FromServiceMsg localFromServiceMsg = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    parambdxe = (bebv)parambdxe.jdField_a_of_type_JavaLangObject;
    beck localbeck = parambdxe.jdField_a_of_type_Beck;
    parambdxf = parambdxf.jdField_a_of_type_Anqe;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      int i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a(localFromServiceMsg), "", parambdxf, localbeck.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      bedb.a(parambdxe, localbeck);
      return;
      a(-1, 9044, MessageHandler.a(localFromServiceMsg), "", parambdxf, localbeck.jdField_a_of_type_JavaUtilList);
      continue;
      a(arrayOfByte, localbeck, parambdxf);
    }
  }
  
  public void a(bebv parambebv)
  {
    bdxe localbdxe;
    becg localbecg;
    if ((parambebv != null) && (parambebv.jdField_a_of_type_JavaUtilList != null) && (parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      localbdxe = new bdxe();
      if (parambebv.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label131;
      }
      localbecg = (becg)parambebv.jdField_a_of_type_JavaUtilList.get(0);
      if (localbecg.f != 0) {
        break label95;
      }
      localbdxe.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
    }
    for (;;)
    {
      localbdxe.jdField_a_of_type_ArrayOfByte = a(parambebv.jdField_a_of_type_JavaUtilList);
      localbdxe.jdField_a_of_type_JavaLangObject = parambebv;
      localbdxe.jdField_a_of_type_Bdxd = this;
      a(parambebv, localbdxe);
      return;
      label95:
      if ((1 == localbecg.f) || (3000 == localbecg.f)) {
        localbdxe.jdField_a_of_type_JavaLangString = "PttCenterSvr.GroupShortVideoDownReq";
      } else {
        localbdxe.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoDownReq";
      }
    }
    label131:
    throw new RuntimeException("only support one request");
  }
  
  public void a(becy parambecy, PttShortVideo.PttShortVideoDownloadResp paramPttShortVideoDownloadResp)
  {
    PttShortVideo.PttShortVideoAddr localPttShortVideoAddr = (PttShortVideo.PttShortVideoAddr)paramPttShortVideoDownloadResp.msg_download_addr.get();
    if (localPttShortVideoAddr != null)
    {
      parambecy.jdField_a_of_type_Int = localPttShortVideoAddr.uint32_host_type.get();
      if (parambecy.jdField_a_of_type_Int == 0)
      {
        parambecy.jdField_a_of_type_JavaUtilArrayList = a(parambecy, localPttShortVideoAddr.rpt_str_host.get());
        parambecy.jdField_b_of_type_JavaUtilArrayList = a(parambecy, localPttShortVideoAddr.rpt_str_host_ipv6.get());
        Object localObject = "";
        paramPttShortVideoDownloadResp = (PttShortVideo.PttShortVideoDownloadResp)localObject;
        if (localPttShortVideoAddr.rpt_str_domain.has())
        {
          paramPttShortVideoDownloadResp = (PttShortVideo.PttShortVideoDownloadResp)localObject;
          if (localPttShortVideoAddr.rpt_str_domain.size() > 0) {
            paramPttShortVideoDownloadResp = (String)localPttShortVideoAddr.rpt_str_domain.get(0);
          }
        }
        localObject = paramPttShortVideoDownloadResp;
        if (paramPttShortVideoDownloadResp != null)
        {
          localObject = paramPttShortVideoDownloadResp;
          if (paramPttShortVideoDownloadResp.length() > 0) {
            localObject = InnerDns.getHostFromUrl(paramPttShortVideoDownloadResp);
          }
        }
        parambecy.jdField_b_of_type_JavaLangString = ((String)localObject);
      }
      parambecy.jdField_c_of_type_JavaLangString = localPttShortVideoAddr.str_url_args.get();
    }
  }
  
  public void a(byte[] paramArrayOfByte, beck parambeck, anqe paramanqe)
  {
    for (;;)
    {
      becy localbecy;
      int i;
      try
      {
        PttShortVideo.RspBody localRspBody = new PttShortVideo.RspBody();
        localRspBody.mergeFrom(paramArrayOfByte);
        PttShortVideo.PttShortVideoDownloadResp localPttShortVideoDownloadResp = (PttShortVideo.PttShortVideoDownloadResp)localRspBody.msg_PttShortVideoDownload_Resp.get();
        localbecy = (becy)parambeck.jdField_a_of_type_JavaUtilList.get(0);
        i = localPttShortVideoDownloadResp.int32_ret_code.get();
        if (i == 0)
        {
          localbecy.jdField_a_of_type_JavaLangString = HexUtil.bytes2HexStr(localPttShortVideoDownloadResp.bytes_downloadkey.get().toByteArray());
          localbecy.jdField_a_of_type_ArrayOfByte = localPttShortVideoDownloadResp.bytes_file_md5.get().toByteArray();
          a(localbecy, localPttShortVideoDownloadResp);
          a(0, 0, "", "", paramanqe, localbecy);
          return;
        }
        if (i == -5100026)
        {
          a(-1, -5100026, bdsx.a(i), "", paramanqe, localbecy);
          if (localRspBody.uint32_allow_retry.get() != 1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.BaseHandler", 2, "onProtoResp : shortVideo server not allow retry");
          }
          localbecy.e = false;
          return;
        }
      }
      catch (Exception localException)
      {
        a(-1, -9527, bdsx.a("P", -9529L), localException.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramanqe, parambeck.jdField_a_of_type_JavaUtilList);
        return;
      }
      if (i == -5100528)
      {
        long l = i;
        a(-1, -5100528, bdsx.a(l), "", paramanqe, localbecy);
      }
      else
      {
        a(-1, -9527, bdsx.a(i), "", paramanqe, localbecy);
      }
    }
  }
  
  byte[] a(List<becg> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      paramList = (bech)paramList.get(0);
      PttShortVideo.PttShortVideoDownloadReq localPttShortVideoDownloadReq = new PttShortVideo.PttShortVideoDownloadReq();
      localPttShortVideoDownloadReq.uint64_touin.set(Long.parseLong(paramList.jdField_c_of_type_JavaLangString));
      localPttShortVideoDownloadReq.uint32_chat_type.set(paramList.jdField_a_of_type_Int);
      if (paramList.jdField_a_of_type_Int == 0)
      {
        localPttShortVideoDownloadReq.uint64_fromuin.set(Long.parseLong(paramList.jdField_d_of_type_JavaLangString));
        localPttShortVideoDownloadReq.uint32_client_type.set(paramList.jdField_b_of_type_Int);
        localPttShortVideoDownloadReq.str_fileid.set(paramList.jdField_a_of_type_JavaLangString);
        if (paramList.jdField_b_of_type_JavaLangString == null) {
          break label391;
        }
        localPttShortVideoDownloadReq.uint64_group_code.set(Long.parseLong(paramList.jdField_b_of_type_JavaLangString));
        label131:
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
        if (paramList.jdField_e_of_type_Int != 0) {
          break label402;
        }
        localPttShortVideoDownloadReq.uint32_req_transfer_type.set(1);
      }
      for (;;)
      {
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
        label391:
        localPttShortVideoDownloadReq.uint64_group_code.set(0L);
        break label131;
        label402:
        localPttShortVideoDownloadReq.uint32_req_transfer_type.set(2);
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
      becy localbecy = new becy();
      localbeck.jdField_a_of_type_JavaUtilList.add(i, localbecy);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedf
 * JD-Core Version:    0.7.0.1
 */