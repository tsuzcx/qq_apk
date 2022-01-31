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

public class axzr
  extends axxs
{
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
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
    for (;;)
    {
      axzm.a(localaxyg, localaxyv);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        localObject = (PttShortVideo.PttShortVideoRetweetResp)((PttShortVideo.RspBody)new PttShortVideo.RspBody().mergeFrom(arrayOfByte)).rpt_msg_short_video_retweet_resp.get(0);
        if (localObject != null) {
          break label222;
        }
        throw new Exception("forwardResp null");
      }
      catch (Exception paramaxtc)
      {
        a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
      continue;
      for (;;)
      {
        try
        {
          for (;;)
          {
            label222:
            paramaxtc = (axzk)localaxyv.jdField_a_of_type_JavaUtilList.get(0);
            try
            {
              i = ((PttShortVideo.PttShortVideoRetweetResp)localObject).int32_ret_code.get();
              if (i != 0) {
                break label488;
              }
              if (1 != ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_file_exist.get()) {
                break label378;
              }
              paramaxtc.jdField_a_of_type_Boolean = true;
              paramaxtc.jdField_a_of_type_JavaLangString = ((PttShortVideo.PttShortVideoRetweetResp)localObject).str_fileid.get();
              paramaxtc.jdField_a_of_type_Int = ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_is_hot_file.get();
              paramaxtc.jdField_b_of_type_Int = ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_long_video_carry_watch_point_type.get();
              a(0, 0, "", "", localajmn, paramaxtc);
            }
            catch (Exception localException)
            {
              paramaxtb = paramaxtc;
              paramaxtc = localException;
            }
          }
        }
        catch (Exception paramaxtc)
        {
          label378:
          paramaxtb = null;
          continue;
        }
        a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, paramaxtb);
        break;
        paramaxtb = localException.bytes_ukey.get().toByteArray();
        if (((localException.rpt_same_area_out_addr.size() <= 0) && (localException.rpt_diff_area_out_addr.size() <= 0)) || (paramaxtb == null) || (paramaxtb.length == 0)) {
          throw new Exception("check ip, port, ukey");
        }
        paramaxtc.jdField_a_of_type_JavaLangString = localException.str_fileid.get();
        paramaxtb = localException.rpt_data_hole.get();
        if ((paramaxtb != null) && (paramaxtb.size() > 0)) {
          paramaxtc.jdField_a_of_type_Long = ((PttShortVideo.DataHole)paramaxtb.get(0)).uint64_begin.get();
        }
      }
      label488:
      if (i == -5100026)
      {
        a(-1, -5100026, axou.a(i), "", localajmn, paramaxtc);
      }
      else
      {
        if (a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramaxtb);
            return;
          }
        }
        a(-1, -9527, axou.a(i), "", localajmn, paramaxtc);
      }
    }
  }
  
  public void a(axyg paramaxyg)
  {
    if ((paramaxyg != null) && (paramaxyg.jdField_a_of_type_JavaUtilList != null) && (paramaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      axtb localaxtb = new axtb();
      if (paramaxyg.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        localaxtb.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoRetweetReq";
        localaxtb.jdField_a_of_type_ArrayOfByte = a(paramaxyg.jdField_a_of_type_JavaUtilList);
        localaxtb.jdField_a_of_type_JavaLangObject = paramaxyg;
        localaxtb.jdField_a_of_type_Axta = this;
        a(paramaxyg, localaxtb);
      }
    }
    else
    {
      return;
    }
    throw new RuntimeException("only support one request");
  }
  
  byte[] a(List<axyr> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      axyt localaxyt = (axyt)paramList.get(0);
      PttShortVideo.PttShortVideoRetweetReq localPttShortVideoRetweetReq = new PttShortVideo.PttShortVideoRetweetReq();
      localPttShortVideoRetweetReq.setHasFlag(true);
      localPttShortVideoRetweetReq.uint64_from_uin.set(Long.parseLong(localaxyt.jdField_g_of_type_JavaLangString));
      localPttShortVideoRetweetReq.uint64_to_uin.set(Long.parseLong(localaxyt.jdField_d_of_type_JavaLangString));
      localPttShortVideoRetweetReq.uint32_from_chat_type.set(localaxyt.jdField_a_of_type_Int);
      localPttShortVideoRetweetReq.uint32_to_chat_type.set(localaxyt.jdField_b_of_type_Int);
      localPttShortVideoRetweetReq.uint32_from_busi_type.set(localaxyt.c);
      localPttShortVideoRetweetReq.uint32_to_busi_type.set(localaxyt.jdField_d_of_type_Int);
      localPttShortVideoRetweetReq.uint32_client_type.set(localaxyt.e);
      localPttShortVideoRetweetReq.uint32_agent_type.set(localaxyt.l);
      Object localObject = localPttShortVideoRetweetReq.str_fileid;
      if (localaxyt.f == null)
      {
        paramList = "";
        ((PBStringField)localObject).set(paramList);
        if (localaxyt.jdField_b_of_type_JavaLangString == null) {
          break label438;
        }
      }
      for (;;)
      {
        try
        {
          localPttShortVideoRetweetReq.uint64_group_code.set(Long.parseLong(localaxyt.jdField_b_of_type_JavaLangString));
          localPttShortVideoRetweetReq.uint32_flag_support_large_size.set(1);
          localObject = new PttShortVideo.PttShortVideoFileInfo();
          PBStringField localPBStringField = ((PttShortVideo.PttShortVideoFileInfo)localObject).str_file_name;
          if (localaxyt.jdField_a_of_type_JavaLangString != null) {
            break label450;
          }
          paramList = "";
          localPBStringField.set(paramList);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(localaxyt.jdField_a_of_type_ArrayOfByte));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(localaxyt.jdField_b_of_type_ArrayOfByte));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_file_size.set(localaxyt.jdField_a_of_type_Long);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_length.set(localaxyt.h);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_width.set(localaxyt.i);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_format.set(localaxyt.j);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_time.set(localaxyt.k);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_thumb_file_size.set(localaxyt.jdField_b_of_type_Long);
          localPttShortVideoRetweetReq.msg_PttShortVideoFileInfo.set((MessageMicro)localObject);
          localReqBody.uint32_cmd.set(500);
          localReqBody.uint32_seq.set(localaxyt.jdField_g_of_type_Int);
          localReqBody.rpt_msg_short_video_retweet_req.add(localPttShortVideoRetweetReq);
          return localReqBody.toByteArray();
          paramList = localaxyt.f;
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
        paramList = localaxyt.jdField_a_of_type_JavaLangString;
      }
    }
    throw new RuntimeException("only support one request");
  }
  
  void b(axyg paramaxyg)
  {
    axyv localaxyv = paramaxyg.jdField_a_of_type_Axyv;
    localaxyv.jdField_a_of_type_JavaUtilList.clear();
    int j = paramaxyg.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      paramaxyg = new axzk();
      localaxyv.jdField_a_of_type_JavaUtilList.add(i, paramaxyg);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axzr
 * JD-Core Version:    0.7.0.1
 */