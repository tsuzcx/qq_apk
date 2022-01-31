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
import java.util.List;
import pttcenterservice.PttShortVideo.DataHole;
import pttcenterservice.PttShortVideo.ExtensionReq;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;
import pttcenterservice.PttShortVideo.ReqBody;
import pttcenterservice.PttShortVideo.RspBody;

public class azab
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
        localObject = (PttShortVideo.PttShortVideoUploadResp)((PttShortVideo.RspBody)new PttShortVideo.RspBody().mergeFrom(arrayOfByte)).msg_PttShortVideoUpload_Resp.get();
        if (localObject != null) {
          break label221;
        }
        throw new Exception("svUpResp null");
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
            label221:
            paramaytl = (ayzu)localayze.jdField_a_of_type_JavaUtilList.get(0);
            try
            {
              i = ((PttShortVideo.PttShortVideoUploadResp)localObject).int32_ret_code.get();
              if (i != 0) {
                break label487;
              }
              if (1 != ((PttShortVideo.PttShortVideoUploadResp)localObject).uint32_file_exist.get()) {
                break label377;
              }
              paramaytl.jdField_a_of_type_Boolean = true;
              paramaytl.jdField_a_of_type_JavaLangString = ((PttShortVideo.PttShortVideoUploadResp)localObject).str_fileid.get();
              paramaytl.jdField_a_of_type_Int = ((PttShortVideo.PttShortVideoUploadResp)localObject).uint32_is_hot_file.get();
              paramaytl.jdField_b_of_type_Int = ((PttShortVideo.PttShortVideoUploadResp)localObject).uint32_long_video_carry_watch_point_type.get();
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
          label377:
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
      label487:
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
  
  public void a(ayyp paramayyp)
  {
    aytk localaytk;
    ayza localayza;
    if ((paramayyp != null) && (paramayyp.jdField_a_of_type_JavaUtilList != null) && (paramayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      localaytk = new aytk();
      if (paramayyp.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label131;
      }
      localayza = (ayza)paramayyp.jdField_a_of_type_JavaUtilList.get(0);
      if (localayza.f != 0) {
        break label95;
      }
      localaytk.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoUpReq";
    }
    for (;;)
    {
      localaytk.jdField_a_of_type_ArrayOfByte = a(paramayyp.jdField_a_of_type_JavaUtilList);
      localaytk.jdField_a_of_type_JavaLangObject = paramayyp;
      localaytk.jdField_a_of_type_Aytj = this;
      a(paramayyp, localaytk);
      return;
      label95:
      if ((1 == localayza.f) || (3000 == localayza.f)) {
        localaytk.jdField_a_of_type_JavaLangString = "PttCenterSvr.GroupShortVideoUpReq";
      } else {
        localaytk.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoUpReq";
      }
    }
    label131:
    throw new RuntimeException("only support one request");
  }
  
  byte[] a(List<ayza> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      paramList = (ayzd)paramList.get(0);
      PttShortVideo.PttShortVideoUploadReq localPttShortVideoUploadReq = new PttShortVideo.PttShortVideoUploadReq();
      localPttShortVideoUploadReq.setHasFlag(true);
      localPttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(paramList.jdField_c_of_type_JavaLangString));
      localPttShortVideoUploadReq.uint64_touin.set(Long.parseLong(paramList.jdField_d_of_type_JavaLangString));
      localPttShortVideoUploadReq.uint32_chat_type.set(paramList.jdField_a_of_type_Int);
      localPttShortVideoUploadReq.uint32_client_type.set(paramList.jdField_b_of_type_Int);
      if (paramList.jdField_b_of_type_JavaLangString != null) {
        localPttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(paramList.jdField_b_of_type_JavaLangString));
      }
      for (;;)
      {
        localPttShortVideoUploadReq.uint32_agent_type.set(paramList.i);
        localPttShortVideoUploadReq.uint32_business_type.set(paramList.j);
        localPttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
        Object localObject = new PttShortVideo.PttShortVideoFileInfo();
        ((PttShortVideo.PttShortVideoFileInfo)localObject).str_file_name.set(paramList.jdField_a_of_type_JavaLangString);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(paramList.jdField_a_of_type_ArrayOfByte));
        ((PttShortVideo.PttShortVideoFileInfo)localObject).bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(paramList.jdField_b_of_type_ArrayOfByte));
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_file_size.set(paramList.jdField_a_of_type_Long);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_length.set(paramList.jdField_d_of_type_Int);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_res_width.set(paramList.e);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_format.set(paramList.g);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint32_file_time.set(paramList.h);
        ((PttShortVideo.PttShortVideoFileInfo)localObject).uint64_thumb_file_size.set(paramList.jdField_b_of_type_Long);
        localPttShortVideoUploadReq.msg_PttShortVideoFileInfo.set((MessageMicro)localObject);
        localObject = new PttShortVideo.ExtensionReq();
        ((PttShortVideo.ExtensionReq)localObject).uint32_sub_busi_type.set(paramList.k);
        ((PttShortVideo.ExtensionReq)localObject).uint32_user_cnt.set(paramList.l);
        localReqBody.uint32_cmd.set(300);
        localReqBody.uint32_seq.set(paramList.jdField_c_of_type_Int);
        localReqBody.msg_PttShortVideoUpload_Req.set(localPttShortVideoUploadReq);
        localReqBody.rpt_msg_extension_req.add((MessageMicro)localObject);
        return localReqBody.toByteArray();
        localPttShortVideoUploadReq.uint64_group_code.set(0L);
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
      ayzu localayzu = new ayzu();
      localayze.jdField_a_of_type_JavaUtilList.add(i, localayzu);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     azab
 * JD-Core Version:    0.7.0.1
 */