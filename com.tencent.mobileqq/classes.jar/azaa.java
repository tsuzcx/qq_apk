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

public class azaa
  extends ayyb
{
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
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
    for (;;)
    {
      ayzv.a(localayyp, localayze);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localakau, localayze.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        localObject = (PttShortVideo.PttShortVideoRetweetResp)((PttShortVideo.RspBody)new PttShortVideo.RspBody().mergeFrom(arrayOfByte)).rpt_msg_short_video_retweet_resp.get(0);
        if (localObject != null) {
          break label222;
        }
        throw new Exception("forwardResp null");
      }
      catch (Exception paramaytl)
      {
        a(-1, -9527, aypb.a("P", -9529L), paramaytl.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakau, localayze.jdField_a_of_type_JavaUtilList);
      }
      continue;
      for (;;)
      {
        try
        {
          for (;;)
          {
            label222:
            paramaytl = (ayzt)localayze.jdField_a_of_type_JavaUtilList.get(0);
            try
            {
              i = ((PttShortVideo.PttShortVideoRetweetResp)localObject).int32_ret_code.get();
              if (i != 0) {
                break label488;
              }
              if (1 != ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_file_exist.get()) {
                break label378;
              }
              paramaytl.jdField_a_of_type_Boolean = true;
              paramaytl.jdField_a_of_type_JavaLangString = ((PttShortVideo.PttShortVideoRetweetResp)localObject).str_fileid.get();
              paramaytl.jdField_a_of_type_Int = ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_is_hot_file.get();
              paramaytl.jdField_b_of_type_Int = ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_long_video_carry_watch_point_type.get();
              a(0, 0, "", "", localakau, paramaytl);
            }
            catch (Exception localException)
            {
              paramaytk = paramaytl;
              paramaytl = localException;
            }
          }
        }
        catch (Exception paramaytl)
        {
          label378:
          paramaytk = null;
          continue;
        }
        a(-1, -9527, aypb.a("P", -9529L), paramaytl.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakau, paramaytk);
        break;
        paramaytk = localException.bytes_ukey.get().toByteArray();
        if (((localException.rpt_same_area_out_addr.size() <= 0) && (localException.rpt_diff_area_out_addr.size() <= 0)) || (paramaytk == null) || (paramaytk.length == 0)) {
          throw new Exception("check ip, port, ukey");
        }
        paramaytl.jdField_a_of_type_JavaLangString = localException.str_fileid.get();
        paramaytk = localException.rpt_data_hole.get();
        if ((paramaytk != null) && (paramaytk.size() > 0)) {
          paramaytl.jdField_a_of_type_Long = ((PttShortVideo.DataHole)paramaytk.get(0)).uint64_begin.get();
        }
      }
      label488:
      if (i == -5100026)
      {
        a(-1, -5100026, aypb.a(i), "", localakau, paramaytl);
      }
      else
      {
        if (a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            localayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramaytk);
            return;
          }
        }
        a(-1, -9527, aypb.a(i), "", localakau, paramaytl);
      }
    }
  }
  
  public void a(ayyp paramayyp)
  {
    if ((paramayyp != null) && (paramayyp.jdField_a_of_type_JavaUtilList != null) && (paramayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      aytk localaytk = new aytk();
      if (paramayyp.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        localaytk.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoRetweetReq";
        localaytk.jdField_a_of_type_ArrayOfByte = a(paramayyp.jdField_a_of_type_JavaUtilList);
        localaytk.jdField_a_of_type_JavaLangObject = paramayyp;
        localaytk.jdField_a_of_type_Aytj = this;
        a(paramayyp, localaytk);
      }
    }
    else
    {
      return;
    }
    throw new RuntimeException("only support one request");
  }
  
  byte[] a(List<ayza> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      ayzc localayzc = (ayzc)paramList.get(0);
      PttShortVideo.PttShortVideoRetweetReq localPttShortVideoRetweetReq = new PttShortVideo.PttShortVideoRetweetReq();
      localPttShortVideoRetweetReq.setHasFlag(true);
      localPttShortVideoRetweetReq.uint64_from_uin.set(Long.parseLong(localayzc.jdField_g_of_type_JavaLangString));
      localPttShortVideoRetweetReq.uint64_to_uin.set(Long.parseLong(localayzc.jdField_d_of_type_JavaLangString));
      localPttShortVideoRetweetReq.uint32_from_chat_type.set(localayzc.jdField_a_of_type_Int);
      localPttShortVideoRetweetReq.uint32_to_chat_type.set(localayzc.jdField_b_of_type_Int);
      localPttShortVideoRetweetReq.uint32_from_busi_type.set(localayzc.c);
      localPttShortVideoRetweetReq.uint32_to_busi_type.set(localayzc.jdField_d_of_type_Int);
      localPttShortVideoRetweetReq.uint32_client_type.set(localayzc.e);
      localPttShortVideoRetweetReq.uint32_agent_type.set(localayzc.l);
      Object localObject = localPttShortVideoRetweetReq.str_fileid;
      if (localayzc.f == null)
      {
        paramList = "";
        ((PBStringField)localObject).set(paramList);
        if (localayzc.jdField_b_of_type_JavaLangString == null) {
          break label438;
        }
      }
      for (;;)
      {
        try
        {
          localPttShortVideoRetweetReq.uint64_group_code.set(Long.parseLong(localayzc.jdField_b_of_type_JavaLangString));
          localPttShortVideoRetweetReq.uint32_flag_support_large_size.set(1);
          localObject = new PttShortVideo.PttShortVideoFileInfo();
          PBStringField localPBStringField = ((PttShortVideo.PttShortVideoFileInfo)localObject).str_file_name;
          if (localayzc.jdField_a_of_type_JavaLangString != null) {
            break label450;
          }
          paramList = "";
          localPBStringField.set(paramList);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(localayzc.jdField_a_of_type_ArrayOfByte));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(localayzc.jdField_b_of_type_ArrayOfByte));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_file_size.set(localayzc.jdField_a_of_type_Long);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_length.set(localayzc.h);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_width.set(localayzc.i);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_format.set(localayzc.j);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_time.set(localayzc.k);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_thumb_file_size.set(localayzc.jdField_b_of_type_Long);
          localPttShortVideoRetweetReq.msg_PttShortVideoFileInfo.set((MessageMicro)localObject);
          localReqBody.uint32_cmd.set(500);
          localReqBody.uint32_seq.set(localayzc.jdField_g_of_type_Int);
          localReqBody.rpt_msg_short_video_retweet_req.add(localPttShortVideoRetweetReq);
          return localReqBody.toByteArray();
          paramList = localayzc.f;
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
        paramList = localayzc.jdField_a_of_type_JavaLangString;
      }
    }
    throw new RuntimeException("only support one request");
  }
  
  void b(ayyp paramayyp)
  {
    ayze localayze = paramayyp.jdField_a_of_type_Ayze;
    localayze.jdField_a_of_type_JavaUtilList.clear();
    int j = paramayyp.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      paramayyp = new ayzt();
      localayze.jdField_a_of_type_JavaUtilList.add(i, paramayyp);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     azaa
 * JD-Core Version:    0.7.0.1
 */