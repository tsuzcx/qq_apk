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

public class bbcj
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
        localObject = (PttShortVideo.PttShortVideoUploadResp)((PttShortVideo.RspBody)new PttShortVideo.RspBody().mergeFrom(arrayOfByte)).msg_PttShortVideoUpload_Resp.get();
        if (localObject != null) {
          break label221;
        }
        throw new Exception("svUpResp null");
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
            label221:
            parambavr = (bbcc)localbbbm.jdField_a_of_type_JavaUtilList.get(0);
            try
            {
              i = ((PttShortVideo.PttShortVideoUploadResp)localObject).int32_ret_code.get();
              if (i != 0) {
                break label487;
              }
              if (1 != ((PttShortVideo.PttShortVideoUploadResp)localObject).uint32_file_exist.get()) {
                break label377;
              }
              parambavr.jdField_a_of_type_Boolean = true;
              parambavr.jdField_a_of_type_JavaLangString = ((PttShortVideo.PttShortVideoUploadResp)localObject).str_fileid.get();
              parambavr.jdField_a_of_type_Int = ((PttShortVideo.PttShortVideoUploadResp)localObject).uint32_is_hot_file.get();
              parambavr.jdField_b_of_type_Int = ((PttShortVideo.PttShortVideoUploadResp)localObject).uint32_long_video_carry_watch_point_type.get();
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
          label377:
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
      label487:
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
  
  public void a(bbax parambbax)
  {
    bavq localbavq;
    bbbi localbbbi;
    if ((parambbax != null) && (parambbax.jdField_a_of_type_JavaUtilList != null) && (parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      localbavq = new bavq();
      if (parambbax.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label131;
      }
      localbbbi = (bbbi)parambbax.jdField_a_of_type_JavaUtilList.get(0);
      if (localbbbi.f != 0) {
        break label95;
      }
      localbavq.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoUpReq";
    }
    for (;;)
    {
      localbavq.jdField_a_of_type_ArrayOfByte = a(parambbax.jdField_a_of_type_JavaUtilList);
      localbavq.jdField_a_of_type_JavaLangObject = parambbax;
      localbavq.jdField_a_of_type_Bavp = this;
      a(parambbax, localbavq);
      return;
      label95:
      if ((1 == localbbbi.f) || (3000 == localbbbi.f)) {
        localbavq.jdField_a_of_type_JavaLangString = "PttCenterSvr.GroupShortVideoUpReq";
      } else {
        localbavq.jdField_a_of_type_JavaLangString = "PttCenterSvr.ShortVideoUpReq";
      }
    }
    label131:
    throw new RuntimeException("only support one request");
  }
  
  byte[] a(List<bbbi> paramList)
  {
    PttShortVideo.ReqBody localReqBody = new PttShortVideo.ReqBody();
    localReqBody.setHasFlag(true);
    if (paramList.size() == 1)
    {
      paramList = (bbbl)paramList.get(0);
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
  
  void b(bbax parambbax)
  {
    bbbm localbbbm = parambbax.jdField_a_of_type_Bbbm;
    localbbbm.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambbax.jdField_a_of_type_JavaUtilList.size())
    {
      bbcc localbbcc = new bbcc();
      localbbbm.jdField_a_of_type_JavaUtilList.add(i, localbbcc);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcj
 * JD-Core Version:    0.7.0.1
 */