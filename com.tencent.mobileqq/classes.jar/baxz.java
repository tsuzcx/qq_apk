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

public class baxz
  extends bawa
{
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
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
    for (;;)
    {
      baxu.a(localbawo, localbaxd);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        localObject = (PttShortVideo.PttShortVideoRetweetResp)((PttShortVideo.RspBody)new PttShortVideo.RspBody().mergeFrom(arrayOfByte)).rpt_msg_short_video_retweet_resp.get(0);
        if (localObject != null) {
          break label222;
        }
        throw new Exception("forwardResp null");
      }
      catch (Exception parambari)
      {
        a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      }
      continue;
      for (;;)
      {
        try
        {
          for (;;)
          {
            label222:
            parambari = (baxs)localbaxd.jdField_a_of_type_JavaUtilList.get(0);
            try
            {
              i = ((PttShortVideo.PttShortVideoRetweetResp)localObject).int32_ret_code.get();
              if (i != 0) {
                break label488;
              }
              if (1 != ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_file_exist.get()) {
                break label378;
              }
              parambari.jdField_a_of_type_Boolean = true;
              parambari.jdField_a_of_type_JavaLangString = ((PttShortVideo.PttShortVideoRetweetResp)localObject).str_fileid.get();
              parambari.jdField_a_of_type_Int = ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_is_hot_file.get();
              parambari.jdField_b_of_type_Int = ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_long_video_carry_watch_point_type.get();
              a(0, 0, "", "", localalsj, parambari);
            }
            catch (Exception localException)
            {
              parambarh = parambari;
              parambari = localException;
            }
          }
        }
        catch (Exception parambari)
        {
          label378:
          parambarh = null;
          continue;
        }
        a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalsj, parambarh);
        break;
        parambarh = localException.bytes_ukey.get().toByteArray();
        if (((localException.rpt_same_area_out_addr.size() <= 0) && (localException.rpt_diff_area_out_addr.size() <= 0)) || (parambarh == null) || (parambarh.length == 0)) {
          throw new Exception("check ip, port, ukey");
        }
        parambari.jdField_a_of_type_JavaLangString = localException.str_fileid.get();
        parambarh = localException.rpt_data_hole.get();
        if ((parambarh != null) && (parambarh.size() > 0)) {
          parambari.jdField_a_of_type_Long = ((PttShortVideo.DataHole)parambarh.get(0)).uint64_begin.get();
        }
      }
      label488:
      if (i == -5100026)
      {
        a(-1, -5100026, bamw.a(i), "", localalsj, parambari);
      }
      else
      {
        if (a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambarh);
            return;
          }
        }
        a(-1, -9527, bamw.a(i), "", localalsj, parambari);
      }
    }
  }
  
  public void a(bawo parambawo)
  {
    if ((parambawo != null) && (parambawo.jdField_a_of_type_JavaUtilList != null) && (parambawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      barh localbarh = new barh();
      if (parambawo.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        localbarh.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoRetweetReq";
        localbarh.jdField_a_of_type_ArrayOfByte = a(parambawo.jdField_a_of_type_JavaUtilList);
        localbarh.jdField_a_of_type_JavaLangObject = parambawo;
        localbarh.jdField_a_of_type_Barg = this;
        a(parambawo, localbarh);
      }
    }
    else
    {
      return;
    }
    throw new RuntimeException("only support one request");
  }
  
  byte[] a(List<bawz> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      baxb localbaxb = (baxb)paramList.get(0);
      PttShortVideo.PttShortVideoRetweetReq localPttShortVideoRetweetReq = new PttShortVideo.PttShortVideoRetweetReq();
      localPttShortVideoRetweetReq.setHasFlag(true);
      localPttShortVideoRetweetReq.uint64_from_uin.set(Long.parseLong(localbaxb.jdField_g_of_type_JavaLangString));
      localPttShortVideoRetweetReq.uint64_to_uin.set(Long.parseLong(localbaxb.jdField_d_of_type_JavaLangString));
      localPttShortVideoRetweetReq.uint32_from_chat_type.set(localbaxb.jdField_a_of_type_Int);
      localPttShortVideoRetweetReq.uint32_to_chat_type.set(localbaxb.jdField_b_of_type_Int);
      localPttShortVideoRetweetReq.uint32_from_busi_type.set(localbaxb.c);
      localPttShortVideoRetweetReq.uint32_to_busi_type.set(localbaxb.jdField_d_of_type_Int);
      localPttShortVideoRetweetReq.uint32_client_type.set(localbaxb.e);
      localPttShortVideoRetweetReq.uint32_agent_type.set(localbaxb.l);
      Object localObject = localPttShortVideoRetweetReq.str_fileid;
      if (localbaxb.f == null)
      {
        paramList = "";
        ((PBStringField)localObject).set(paramList);
        if (localbaxb.jdField_b_of_type_JavaLangString == null) {
          break label438;
        }
      }
      for (;;)
      {
        try
        {
          localPttShortVideoRetweetReq.uint64_group_code.set(Long.parseLong(localbaxb.jdField_b_of_type_JavaLangString));
          localPttShortVideoRetweetReq.uint32_flag_support_large_size.set(1);
          localObject = new PttShortVideo.PttShortVideoFileInfo();
          PBStringField localPBStringField = ((PttShortVideo.PttShortVideoFileInfo)localObject).str_file_name;
          if (localbaxb.jdField_a_of_type_JavaLangString != null) {
            break label450;
          }
          paramList = "";
          localPBStringField.set(paramList);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(localbaxb.jdField_a_of_type_ArrayOfByte));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(localbaxb.jdField_b_of_type_ArrayOfByte));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_file_size.set(localbaxb.jdField_a_of_type_Long);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_length.set(localbaxb.h);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_width.set(localbaxb.i);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_format.set(localbaxb.j);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_time.set(localbaxb.k);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_thumb_file_size.set(localbaxb.jdField_b_of_type_Long);
          localPttShortVideoRetweetReq.msg_PttShortVideoFileInfo.set((MessageMicro)localObject);
          localReqBody.uint32_cmd.set(500);
          localReqBody.uint32_seq.set(localbaxb.jdField_g_of_type_Int);
          localReqBody.rpt_msg_short_video_retweet_req.add(localPttShortVideoRetweetReq);
          return localReqBody.toByteArray();
          paramList = localbaxb.f;
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
        paramList = localbaxb.jdField_a_of_type_JavaLangString;
      }
    }
    throw new RuntimeException("only support one request");
  }
  
  void b(bawo parambawo)
  {
    baxd localbaxd = parambawo.jdField_a_of_type_Baxd;
    localbaxd.jdField_a_of_type_JavaUtilList.clear();
    int j = parambawo.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      parambawo = new baxs();
      localbaxd.jdField_a_of_type_JavaUtilList.add(i, parambawo);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baxz
 * JD-Core Version:    0.7.0.1
 */