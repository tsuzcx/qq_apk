import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import pttcenterservice.PttShortVideo.DataHole;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoRetweetReq;
import pttcenterservice.PttShortVideo.PttShortVideoRetweetResp;
import pttcenterservice.PttShortVideo.ReqBody;
import pttcenterservice.PttShortVideo.RspBody;

public class bbci
  extends bbaj
{
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
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
    for (;;)
    {
      bbcd.a(localbbax, localbbbm);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        localObject = (PttShortVideo.PttShortVideoRetweetResp)((PttShortVideo.RspBody)new PttShortVideo.RspBody().mergeFrom(arrayOfByte)).rpt_msg_short_video_retweet_resp.get(0);
        if (localObject != null) {
          break label222;
        }
        throw new Exception("forwardResp null");
      }
      catch (Exception parambavr)
      {
        a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      }
      continue;
      for (;;)
      {
        try
        {
          for (;;)
          {
            label222:
            parambavr = (bbcb)localbbbm.jdField_a_of_type_JavaUtilList.get(0);
            try
            {
              i = ((PttShortVideo.PttShortVideoRetweetResp)localObject).int32_ret_code.get();
              if (i != 0) {
                break label488;
              }
              if (1 != ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_file_exist.get()) {
                break label378;
              }
              parambavr.jdField_a_of_type_Boolean = true;
              parambavr.jdField_a_of_type_JavaLangString = ((PttShortVideo.PttShortVideoRetweetResp)localObject).str_fileid.get();
              parambavr.jdField_a_of_type_Int = ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_is_hot_file.get();
              parambavr.jdField_b_of_type_Int = ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_long_video_carry_watch_point_type.get();
              a(0, 0, "", "", localalwy, parambavr);
            }
            catch (Exception localException)
            {
              parambavq = parambavr;
              parambavr = localException;
            }
          }
        }
        catch (Exception parambavr)
        {
          label378:
          parambavq = null;
          continue;
        }
        a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalwy, parambavq);
        break;
        parambavq = localException.bytes_ukey.get().toByteArray();
        if (((localException.rpt_same_area_out_addr.size() <= 0) && (localException.rpt_diff_area_out_addr.size() <= 0)) || (parambavq == null) || (parambavq.length == 0)) {
          throw new Exception("check ip, port, ukey");
        }
        parambavr.jdField_a_of_type_JavaLangString = localException.str_fileid.get();
        parambavq = localException.rpt_data_hole.get();
        if ((parambavq != null) && (parambavq.size() > 0)) {
          parambavr.jdField_a_of_type_Long = ((PttShortVideo.DataHole)parambavq.get(0)).uint64_begin.get();
        }
      }
      label488:
      if (i == -5100026)
      {
        a(-1, -5100026, barf.a(i), "", localalwy, parambavr);
      }
      else
      {
        if (a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambavq);
            return;
          }
        }
        a(-1, -9527, barf.a(i), "", localalwy, parambavr);
      }
    }
  }
  
  public void a(bbax parambbax)
  {
    if ((parambbax != null) && (parambbax.jdField_a_of_type_JavaUtilList != null) && (parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bavq localbavq = new bavq();
      if (parambbax.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        localbavq.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoRetweetReq";
        localbavq.jdField_a_of_type_ArrayOfByte = a(parambbax.jdField_a_of_type_JavaUtilList);
        localbavq.jdField_a_of_type_JavaLangObject = parambbax;
        localbavq.jdField_a_of_type_Bavp = this;
        a(parambbax, localbavq);
      }
    }
    else
    {
      return;
    }
    throw new RuntimeException("only support one request");
  }
  
  byte[] a(List<bbbi> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      bbbk localbbbk = (bbbk)paramList.get(0);
      PttShortVideo.PttShortVideoRetweetReq localPttShortVideoRetweetReq = new PttShortVideo.PttShortVideoRetweetReq();
      localPttShortVideoRetweetReq.setHasFlag(true);
      localPttShortVideoRetweetReq.uint64_from_uin.set(Long.parseLong(localbbbk.jdField_g_of_type_JavaLangString));
      localPttShortVideoRetweetReq.uint64_to_uin.set(Long.parseLong(localbbbk.jdField_d_of_type_JavaLangString));
      localPttShortVideoRetweetReq.uint32_from_chat_type.set(localbbbk.jdField_a_of_type_Int);
      localPttShortVideoRetweetReq.uint32_to_chat_type.set(localbbbk.jdField_b_of_type_Int);
      localPttShortVideoRetweetReq.uint32_from_busi_type.set(localbbbk.c);
      localPttShortVideoRetweetReq.uint32_to_busi_type.set(localbbbk.jdField_d_of_type_Int);
      localPttShortVideoRetweetReq.uint32_client_type.set(localbbbk.e);
      localPttShortVideoRetweetReq.uint32_agent_type.set(localbbbk.l);
      Object localObject = localPttShortVideoRetweetReq.str_fileid;
      if (localbbbk.f == null)
      {
        paramList = "";
        ((PBStringField)localObject).set(paramList);
        if (localbbbk.jdField_b_of_type_JavaLangString == null) {
          break label438;
        }
      }
      for (;;)
      {
        try
        {
          localPttShortVideoRetweetReq.uint64_group_code.set(Long.parseLong(localbbbk.jdField_b_of_type_JavaLangString));
          localPttShortVideoRetweetReq.uint32_flag_support_large_size.set(1);
          localObject = new PttShortVideo.PttShortVideoFileInfo();
          PBStringField localPBStringField = ((PttShortVideo.PttShortVideoFileInfo)localObject).str_file_name;
          if (localbbbk.jdField_a_of_type_JavaLangString != null) {
            break label450;
          }
          paramList = "";
          localPBStringField.set(paramList);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(localbbbk.jdField_a_of_type_ArrayOfByte));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(localbbbk.jdField_b_of_type_ArrayOfByte));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_file_size.set(localbbbk.jdField_a_of_type_Long);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_length.set(localbbbk.h);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_width.set(localbbbk.i);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_format.set(localbbbk.j);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_time.set(localbbbk.k);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_thumb_file_size.set(localbbbk.jdField_b_of_type_Long);
          localPttShortVideoRetweetReq.msg_PttShortVideoFileInfo.set((MessageMicro)localObject);
          localReqBody.uint32_cmd.set(500);
          localReqBody.uint32_seq.set(localbbbk.jdField_g_of_type_Int);
          localReqBody.rpt_msg_short_video_retweet_req.add(localPttShortVideoRetweetReq);
          return localReqBody.toByteArray();
          paramList = localbbbk.f;
        }
        catch (NumberFormatException paramList)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.ShortVideoForwardHandler", 2, "NumberFormatException e = " + paramList);
          }
          localPttShortVideoRetweetReq.uint64_group_code.set(0L);
          continue;
        }
        label438:
        localPttShortVideoRetweetReq.uint64_group_code.set(0L);
        continue;
        label450:
        paramList = localbbbk.jdField_a_of_type_JavaLangString;
      }
    }
    throw new RuntimeException("only support one request");
  }
  
  void b(bbax parambbax)
  {
    bbbm localbbbm = parambbax.jdField_a_of_type_Bbbm;
    localbbbm.jdField_a_of_type_JavaUtilList.clear();
    int j = parambbax.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      parambbax = new bbcb();
      localbbbm.jdField_a_of_type_JavaUtilList.add(i, parambbax);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbci
 * JD-Core Version:    0.7.0.1
 */