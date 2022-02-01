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

public class bfcf
  extends bfae
{
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
  public void a(bevy parambevy, bevx parambevx)
  {
    Object localObject = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bfau localbfau = (bfau)parambevx.jdField_a_of_type_JavaLangObject;
    bfbj localbfbj = localbfau.jdField_a_of_type_Bfbj;
    aock localaock = parambevy.jdField_a_of_type_Aock;
    int i;
    if (((FromServiceMsg)localObject).getResultCode() != 1000)
    {
      i = ((FromServiceMsg)localObject).getResultCode();
      if ((i == 1002) || (i == 1013)) {
        a(-1, 9311, MessageHandler.a((FromServiceMsg)localObject), "", localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      bfca.a(localbfau, localbfbj);
      return;
      a(-1, 9044, MessageHandler.a((FromServiceMsg)localObject), "", localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        localObject = (PttShortVideo.PttShortVideoRetweetResp)((PttShortVideo.RspBody)new PttShortVideo.RspBody().mergeFrom(arrayOfByte)).rpt_msg_short_video_retweet_resp.get(0);
        if (localObject != null) {
          break label222;
        }
        throw new Exception("forwardResp null");
      }
      catch (Exception parambevy)
      {
        a(-1, -9527, berp.a("P", -9529L), parambevy.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      }
      continue;
      for (;;)
      {
        try
        {
          for (;;)
          {
            label222:
            parambevy = (bfby)localbfbj.jdField_a_of_type_JavaUtilList.get(0);
            try
            {
              i = ((PttShortVideo.PttShortVideoRetweetResp)localObject).int32_ret_code.get();
              if (i != 0) {
                break label488;
              }
              if (1 != ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_file_exist.get()) {
                break label378;
              }
              parambevy.jdField_a_of_type_Boolean = true;
              parambevy.jdField_a_of_type_JavaLangString = ((PttShortVideo.PttShortVideoRetweetResp)localObject).str_fileid.get();
              parambevy.jdField_a_of_type_Int = ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_is_hot_file.get();
              parambevy.jdField_b_of_type_Int = ((PttShortVideo.PttShortVideoRetweetResp)localObject).uint32_long_video_carry_watch_point_type.get();
              a(0, 0, "", "", localaock, parambevy);
            }
            catch (Exception localException)
            {
              parambevx = parambevy;
              parambevy = localException;
            }
          }
        }
        catch (Exception parambevy)
        {
          label378:
          parambevx = null;
          continue;
        }
        a(-1, -9527, berp.a("P", -9529L), parambevy.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localaock, parambevx);
        break;
        parambevx = localException.bytes_ukey.get().toByteArray();
        if (((localException.rpt_same_area_out_addr.size() <= 0) && (localException.rpt_diff_area_out_addr.size() <= 0)) || (parambevx == null) || (parambevx.length == 0)) {
          throw new Exception("check ip, port, ukey");
        }
        parambevy.jdField_a_of_type_JavaLangString = localException.str_fileid.get();
        parambevx = localException.rpt_data_hole.get();
        if ((parambevx != null) && (parambevx.size() > 0)) {
          parambevy.jdField_a_of_type_Long = ((PttShortVideo.DataHole)parambevx.get(0)).uint64_begin.get();
        }
      }
      label488:
      if (i == -5100026)
      {
        a(-1, -5100026, berp.a(i), "", localaock, parambevy);
      }
      else
      {
        if (a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambevx);
            return;
          }
        }
        a(-1, -9527, berp.a(i), "", localaock, parambevy);
      }
    }
  }
  
  public void a(bfau parambfau)
  {
    if ((parambfau != null) && (parambfau.jdField_a_of_type_JavaUtilList != null) && (parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bevx localbevx = new bevx();
      if (parambfau.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        localbevx.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoRetweetReq";
        localbevx.jdField_a_of_type_ArrayOfByte = a(parambfau.jdField_a_of_type_JavaUtilList);
        localbevx.jdField_a_of_type_JavaLangObject = parambfau;
        localbevx.jdField_a_of_type_Bevw = this;
        a(parambfau, localbevx);
      }
    }
    else
    {
      return;
    }
    throw new RuntimeException("only support one request");
  }
  
  byte[] a(List<bfbf> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      bfbh localbfbh = (bfbh)paramList.get(0);
      PttShortVideo.PttShortVideoRetweetReq localPttShortVideoRetweetReq = new PttShortVideo.PttShortVideoRetweetReq();
      localPttShortVideoRetweetReq.setHasFlag(true);
      localPttShortVideoRetweetReq.uint64_from_uin.set(Long.parseLong(localbfbh.jdField_g_of_type_JavaLangString));
      localPttShortVideoRetweetReq.uint64_to_uin.set(Long.parseLong(localbfbh.jdField_d_of_type_JavaLangString));
      localPttShortVideoRetweetReq.uint32_from_chat_type.set(localbfbh.jdField_a_of_type_Int);
      localPttShortVideoRetweetReq.uint32_to_chat_type.set(localbfbh.jdField_b_of_type_Int);
      localPttShortVideoRetweetReq.uint32_from_busi_type.set(localbfbh.c);
      localPttShortVideoRetweetReq.uint32_to_busi_type.set(localbfbh.jdField_d_of_type_Int);
      localPttShortVideoRetweetReq.uint32_client_type.set(localbfbh.e);
      localPttShortVideoRetweetReq.uint32_agent_type.set(localbfbh.l);
      Object localObject = localPttShortVideoRetweetReq.str_fileid;
      if (localbfbh.f == null)
      {
        paramList = "";
        ((PBStringField)localObject).set(paramList);
        if (localbfbh.jdField_b_of_type_JavaLangString == null) {
          break label438;
        }
      }
      for (;;)
      {
        try
        {
          localPttShortVideoRetweetReq.uint64_group_code.set(Long.parseLong(localbfbh.jdField_b_of_type_JavaLangString));
          localPttShortVideoRetweetReq.uint32_flag_support_large_size.set(1);
          localObject = new PttShortVideo.PttShortVideoFileInfo();
          PBStringField localPBStringField = ((PttShortVideo.PttShortVideoFileInfo)localObject).str_file_name;
          if (localbfbh.jdField_a_of_type_JavaLangString != null) {
            break label450;
          }
          paramList = "";
          localPBStringField.set(paramList);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(localbfbh.jdField_a_of_type_ArrayOfByte));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(localbfbh.jdField_b_of_type_ArrayOfByte));
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_file_size.set(localbfbh.jdField_a_of_type_Long);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_length.set(localbfbh.h);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_width.set(localbfbh.i);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_format.set(localbfbh.j);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_time.set(localbfbh.k);
          ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_thumb_file_size.set(localbfbh.jdField_b_of_type_Long);
          localPttShortVideoRetweetReq.msg_PttShortVideoFileInfo.set((MessageMicro)localObject);
          localReqBody.uint32_cmd.set(500);
          localReqBody.uint32_seq.set(localbfbh.jdField_g_of_type_Int);
          localReqBody.rpt_msg_short_video_retweet_req.add(localPttShortVideoRetweetReq);
          return localReqBody.toByteArray();
          paramList = localbfbh.f;
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
        paramList = localbfbh.jdField_a_of_type_JavaLangString;
      }
    }
    throw new RuntimeException("only support one request");
  }
  
  void b(bfau parambfau)
  {
    bfbj localbfbj = parambfau.jdField_a_of_type_Bfbj;
    localbfbj.jdField_a_of_type_JavaUtilList.clear();
    int j = parambfau.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      parambfau = new bfby();
      localbfbj.jdField_a_of_type_JavaUtilList.add(i, parambfau);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfcf
 * JD-Core Version:    0.7.0.1
 */