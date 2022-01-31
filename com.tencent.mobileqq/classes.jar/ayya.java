import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgReq;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgRsp;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpInfo4Busi;

public class ayya
  extends ayyb
{
  int a;
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 194) && (paramInt != 197) && (paramInt != 199) && (paramInt != 200) && (paramInt != 201) && (paramInt != 203) && (paramInt != 202) && (paramInt != 120509) && (paramInt != 400010) && (paramInt != 400011);
  }
  
  void a(int paramInt, ayza paramayza, cmd0x388.ReqBody paramReqBody)
  {
    paramayza = (ayyy)paramayza;
    cmd0x388.TryUpImgReq localTryUpImgReq = new cmd0x388.TryUpImgReq();
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(paramayza.jdField_c_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_group_code.set(Long.valueOf(paramayza.jdField_d_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.uint64_file_size.set(paramayza.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramayza.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramayza.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_pic_width.set(paramayza.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(paramayza.jdField_d_of_type_Int);
    localTryUpImgReq.uint32_pic_type.set(paramayza.jdField_a_of_type_Int);
    PBUInt32Field localPBUInt32Field = localTryUpImgReq.uint32_bu_type;
    if (paramayza.f == 1) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(ayuk.a()));
      if (paramayza.jdField_b_of_type_Boolean) {
        localTryUpImgReq.uint32_original_pic.set(1);
      }
      paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
      return;
    }
  }
  
  public void a(aytl paramaytl, aytk paramaytk)
  {
    FromServiceMsg localFromServiceMsg = paramaytl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramaytl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    ayyp localayyp = (ayyp)paramaytk.jdField_a_of_type_JavaLangObject;
    ayze localayze = localayyp.jdField_a_of_type_Ayze;
    akau localakau = paramaytl.jdField_a_of_type_Akau;
    if (QLog.isColorLevel()) {
      QLog.e("BDHCommonUpHandler", 1, "onProtoResp: " + localFromServiceMsg.getResultCode());
    }
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      paramaytl = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((paramaytl.equals("conSucc")) || (paramaytl.equals("")))
      {
        i = localFromServiceMsg.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject1 = MessageHandler.b(localFromServiceMsg);
          paramaytk = localFromServiceMsg.getBusinessFailMsg();
          paramaytl = paramaytk;
          if (paramaytk == null) {
            paramaytl = "";
          }
          a(-1, 9311, (String)localObject1, paramaytl, localakau, localayze.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    for (;;)
    {
      ayzv.a(localayyp, localayze);
      return;
      paramaytk = localFromServiceMsg.getBusinessFailMsg();
      paramaytl = paramaytk;
      if (paramaytk == null) {
        paramaytl = "";
      }
      a(-1, 9044, String.valueOf(i), paramaytl, localakau, localayze.jdField_a_of_type_JavaUtilList);
      continue;
      a(-1, 9313, paramaytl, localFromServiceMsg.getBusinessFailMsg(), localakau, localayze.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramaytl = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_img_rsp.get();
        if ((paramaytl != null) && (paramaytl.size() != 0)) {
          break label349;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramaytl)
      {
        a(-1, -9527, aypb.a("P", -9529L), paramaytl.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakau, localayze.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label349:
      Iterator localIterator = paramaytl.iterator();
      while (localIterator.hasNext())
      {
        paramaytl = (cmd0x388.TryUpImgRsp)localIterator.next();
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject1 = (ayzf)localayze.jdField_a_of_type_JavaUtilList.get((int)paramaytl.uint64_file_id.get());
              if (localObject1 == null) {
                break;
              }
              try
              {
                if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
                  ((ayzf)localObject1).jdField_d_of_type_Boolean = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
                }
                if (paramaytl.msg_info4busi.has())
                {
                  localObject2 = (cmd0x388.TryUpInfo4Busi)paramaytl.msg_info4busi.get();
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_down_domain.has()) {
                    ((ayzf)localObject1).jdField_b_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_down_domain.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_big_down_url.has()) {
                    ((ayzf)localObject1).jdField_d_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_big_down_url.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_original_down_url.has()) {
                    ((ayzf)localObject1).e = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_original_down_url.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_thumb_down_url.has()) {
                    ((ayzf)localObject1).jdField_c_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_thumb_down_url.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_file_resid.has()) {
                    ((ayzf)localObject1).f = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_file_resid.get().toStringUtf8();
                  }
                }
                i = paramaytl.uint32_result.get();
                if (i != 0) {
                  break label1045;
                }
                ((ayzf)localObject1).jdField_a_of_type_Long = paramaytl.uint64_fileid.get();
                localObject2 = paramaytl.rpt_uint32_up_ip.get();
                localObject3 = paramaytl.rpt_uint32_up_port.get();
                if ((localObject2 != null) && (((List)localObject2).size() > 0))
                {
                  i = 0;
                  while (i < ((List)localObject2).size())
                  {
                    long l1 = ((Integer)((List)localObject2).get(i)).intValue();
                    long l2 = ((Integer)((List)localObject3).get(i)).intValue();
                    ayuq localayuq = new ayuq();
                    localayuq.jdField_a_of_type_JavaLangString = bbmx.a(l1 & 0xFFFFFFFF);
                    localayuq.jdField_a_of_type_Int = ((int)l2);
                    ((ayzf)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localayuq);
                    i += 1;
                  }
                }
                if ((!paramaytl.bool_file_exit.has()) || (!paramaytl.bool_file_exit.get())) {
                  break label852;
                }
                ((ayzf)localObject1).jdField_a_of_type_Boolean = true;
                a(0, 0, "", "", localakau, (ayzr)localObject1);
              }
              catch (Exception paramaytl) {}
            }
          }
          catch (Exception paramaytl)
          {
            Object localObject2;
            Object localObject3;
            label852:
            localObject1 = null;
            continue;
            boolean bool = false;
            continue;
          }
          a(-1, -9527, aypb.a("P", -9529L), paramaytl.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakau, (ayzr)localObject1);
          break;
          localObject3 = HexUtil.bytes2HexStr(paramaytl.bytes_up_ukey.get().toByteArray());
          if ((localObject3 == null) || (((String)localObject3).equals("")) || (localObject2 == null) || (((List)localObject2).size() == 0)) {
            throw new Exception("check ukey,iplist");
          }
          ((ayzf)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject3);
          ((ayzf)localObject1).jdField_a_of_type_Int = ((int)paramaytl.uint64_block_size.get());
          ((ayzf)localObject1).jdField_b_of_type_Int = ((int)paramaytl.uint64_up_offset.get());
          if (ayta.a().a() == this.jdField_a_of_type_Int) {
            continue;
          }
          bool = true;
          ((ayzf)localObject1).jdField_b_of_type_Boolean = bool;
          ((ayzf)localObject1).jdField_b_of_type_Long = paramaytl.uint64_up_offset.get();
          if (QLog.isColorLevel()) {
            QLog.d("BDH_LOG", 2, " Channel:" + paramaytl.bool_new_big_chan.get());
          }
          if ((paramaytl.bool_new_big_chan.has()) && (paramaytl.bool_new_big_chan.get() == true)) {
            ((ayzf)localObject1).jdField_c_of_type_Boolean = true;
          }
        }
        label1045:
        if (a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            localayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramaytk);
            return;
          }
        }
        a(-1, -9527, aypb.a(i), "", localakau, (ayzr)localObject1);
      }
    }
  }
  
  public void a(ayyp paramayyp)
  {
    if ((paramayyp != null) && (paramayyp.jdField_a_of_type_JavaUtilList != null) && (paramayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      aytk localaytk = new aytk();
      localaytk.jdField_a_of_type_JavaLangString = "ImgStore.BDHCommonUp";
      localaytk.jdField_a_of_type_ArrayOfByte = a(paramayyp);
      localaytk.jdField_a_of_type_JavaLangObject = paramayyp;
      localaytk.jdField_a_of_type_Aytj = this;
      a(paramayyp, localaytk);
    }
  }
  
  byte[] a(ayyp paramayyp)
  {
    if (paramayyp == null) {
      return null;
    }
    List localList = paramayyp.jdField_a_of_type_JavaUtilList;
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    localReqBody.uint32_command_id.set(paramayyp.jdField_a_of_type_Int);
    if (paramayyp.jdField_a_of_type_ArrayOfByte != null) {
      localReqBody.bytes_extension.set(ByteStringMicro.copyFrom(paramayyp.jdField_a_of_type_ArrayOfByte));
    }
    int i = 0;
    while (i < localList.size())
    {
      a(i, (ayza)localList.get(i), localReqBody);
      i += 1;
    }
    i = ayta.a().a();
    this.jdField_a_of_type_Int = i;
    switch (i)
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramayyp = ayta.a().a();
      int j = i;
      if (paramayyp != null)
      {
        j = i;
        if (paramayyp.contains("wap")) {
          j = 5;
        }
      }
      localReqBody.uint32_net_type.set(j);
      return localReqBody.toByteArray();
      i = 3;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
    }
  }
  
  void b(ayyp paramayyp)
  {
    ayze localayze = paramayyp.jdField_a_of_type_Ayze;
    localayze.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramayyp.jdField_a_of_type_JavaUtilList.size())
    {
      ayzf localayzf = new ayzf();
      localayze.jdField_a_of_type_JavaUtilList.add(i, localayzf);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayya
 * JD-Core Version:    0.7.0.1
 */