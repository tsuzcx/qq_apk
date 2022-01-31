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

public class axxr
  extends axxs
{
  int a;
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 194) && (paramInt != 197) && (paramInt != 199) && (paramInt != 200) && (paramInt != 201) && (paramInt != 203) && (paramInt != 202) && (paramInt != 120509) && (paramInt != 400010) && (paramInt != 400011);
  }
  
  void a(int paramInt, axyr paramaxyr, cmd0x388.ReqBody paramReqBody)
  {
    paramaxyr = (axyp)paramaxyr;
    cmd0x388.TryUpImgReq localTryUpImgReq = new cmd0x388.TryUpImgReq();
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(paramaxyr.jdField_c_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_group_code.set(Long.valueOf(paramaxyr.jdField_d_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.uint64_file_size.set(paramaxyr.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramaxyr.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramaxyr.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_pic_width.set(paramaxyr.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(paramaxyr.jdField_d_of_type_Int);
    localTryUpImgReq.uint32_pic_type.set(paramaxyr.jdField_a_of_type_Int);
    PBUInt32Field localPBUInt32Field = localTryUpImgReq.uint32_bu_type;
    if (paramaxyr.f == 1) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(axub.a()));
      if (paramaxyr.jdField_b_of_type_Boolean) {
        localTryUpImgReq.uint32_original_pic.set(1);
      }
      paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
      return;
    }
  }
  
  public void a(axtc paramaxtc, axtb paramaxtb)
  {
    FromServiceMsg localFromServiceMsg = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    axyg localaxyg = (axyg)paramaxtb.jdField_a_of_type_JavaLangObject;
    axyv localaxyv = localaxyg.jdField_a_of_type_Axyv;
    ajmn localajmn = paramaxtc.jdField_a_of_type_Ajmn;
    if (QLog.isColorLevel()) {
      QLog.e("BDHCommonUpHandler", 1, "onProtoResp: " + localFromServiceMsg.getResultCode());
    }
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      paramaxtc = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((paramaxtc.equals("conSucc")) || (paramaxtc.equals("")))
      {
        i = localFromServiceMsg.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject1 = MessageHandler.b(localFromServiceMsg);
          paramaxtb = localFromServiceMsg.getBusinessFailMsg();
          paramaxtc = paramaxtb;
          if (paramaxtb == null) {
            paramaxtc = "";
          }
          a(-1, 9311, (String)localObject1, paramaxtc, localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    for (;;)
    {
      axzm.a(localaxyg, localaxyv);
      return;
      paramaxtb = localFromServiceMsg.getBusinessFailMsg();
      paramaxtc = paramaxtb;
      if (paramaxtb == null) {
        paramaxtc = "";
      }
      a(-1, 9044, String.valueOf(i), paramaxtc, localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      continue;
      a(-1, 9313, paramaxtc, localFromServiceMsg.getBusinessFailMsg(), localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramaxtc = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_img_rsp.get();
        if ((paramaxtc != null) && (paramaxtc.size() != 0)) {
          break label349;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramaxtc)
      {
        a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label349:
      Iterator localIterator = paramaxtc.iterator();
      while (localIterator.hasNext())
      {
        paramaxtc = (cmd0x388.TryUpImgRsp)localIterator.next();
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject1 = (axyw)localaxyv.jdField_a_of_type_JavaUtilList.get((int)paramaxtc.uint64_file_id.get());
              if (localObject1 == null) {
                break;
              }
              try
              {
                if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
                  ((axyw)localObject1).jdField_d_of_type_Boolean = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
                }
                if (paramaxtc.msg_info4busi.has())
                {
                  localObject2 = (cmd0x388.TryUpInfo4Busi)paramaxtc.msg_info4busi.get();
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_down_domain.has()) {
                    ((axyw)localObject1).jdField_b_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_down_domain.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_big_down_url.has()) {
                    ((axyw)localObject1).jdField_d_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_big_down_url.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_original_down_url.has()) {
                    ((axyw)localObject1).e = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_original_down_url.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_thumb_down_url.has()) {
                    ((axyw)localObject1).jdField_c_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_thumb_down_url.get().toStringUtf8();
                  }
                  if (((cmd0x388.TryUpInfo4Busi)localObject2).bytes_file_resid.has()) {
                    ((axyw)localObject1).f = ((cmd0x388.TryUpInfo4Busi)localObject2).bytes_file_resid.get().toStringUtf8();
                  }
                }
                i = paramaxtc.uint32_result.get();
                if (i != 0) {
                  break label1045;
                }
                ((axyw)localObject1).jdField_a_of_type_Long = paramaxtc.uint64_fileid.get();
                localObject2 = paramaxtc.rpt_uint32_up_ip.get();
                localObject3 = paramaxtc.rpt_uint32_up_port.get();
                if ((localObject2 != null) && (((List)localObject2).size() > 0))
                {
                  i = 0;
                  while (i < ((List)localObject2).size())
                  {
                    long l1 = ((Integer)((List)localObject2).get(i)).intValue();
                    long l2 = ((Integer)((List)localObject3).get(i)).intValue();
                    axuh localaxuh = new axuh();
                    localaxuh.jdField_a_of_type_JavaLangString = bakz.a(l1 & 0xFFFFFFFF);
                    localaxuh.jdField_a_of_type_Int = ((int)l2);
                    ((axyw)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localaxuh);
                    i += 1;
                  }
                }
                if ((!paramaxtc.bool_file_exit.has()) || (!paramaxtc.bool_file_exit.get())) {
                  break label852;
                }
                ((axyw)localObject1).jdField_a_of_type_Boolean = true;
                a(0, 0, "", "", localajmn, (axzi)localObject1);
              }
              catch (Exception paramaxtc) {}
            }
          }
          catch (Exception paramaxtc)
          {
            Object localObject2;
            Object localObject3;
            label852:
            localObject1 = null;
            continue;
            boolean bool = false;
            continue;
          }
          a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, (axzi)localObject1);
          break;
          localObject3 = HexUtil.bytes2HexStr(paramaxtc.bytes_up_ukey.get().toByteArray());
          if ((localObject3 == null) || (((String)localObject3).equals("")) || (localObject2 == null) || (((List)localObject2).size() == 0)) {
            throw new Exception("check ukey,iplist");
          }
          ((axyw)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject3);
          ((axyw)localObject1).jdField_a_of_type_Int = ((int)paramaxtc.uint64_block_size.get());
          ((axyw)localObject1).jdField_b_of_type_Int = ((int)paramaxtc.uint64_up_offset.get());
          if (axsr.a().a() == this.jdField_a_of_type_Int) {
            continue;
          }
          bool = true;
          ((axyw)localObject1).jdField_b_of_type_Boolean = bool;
          ((axyw)localObject1).jdField_b_of_type_Long = paramaxtc.uint64_up_offset.get();
          if (QLog.isColorLevel()) {
            QLog.d("BDH_LOG", 2, " Channel:" + paramaxtc.bool_new_big_chan.get());
          }
          if ((paramaxtc.bool_new_big_chan.has()) && (paramaxtc.bool_new_big_chan.get() == true)) {
            ((axyw)localObject1).jdField_c_of_type_Boolean = true;
          }
        }
        label1045:
        if (a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramaxtb);
            return;
          }
        }
        a(-1, -9527, axou.a(i), "", localajmn, (axzi)localObject1);
      }
    }
  }
  
  public void a(axyg paramaxyg)
  {
    if ((paramaxyg != null) && (paramaxyg.jdField_a_of_type_JavaUtilList != null) && (paramaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      axtb localaxtb = new axtb();
      localaxtb.jdField_a_of_type_JavaLangString = "ImgStore.BDHCommonUp";
      localaxtb.jdField_a_of_type_ArrayOfByte = a(paramaxyg);
      localaxtb.jdField_a_of_type_JavaLangObject = paramaxyg;
      localaxtb.jdField_a_of_type_Axta = this;
      a(paramaxyg, localaxtb);
    }
  }
  
  byte[] a(axyg paramaxyg)
  {
    if (paramaxyg == null) {
      return null;
    }
    List localList = paramaxyg.jdField_a_of_type_JavaUtilList;
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    localReqBody.uint32_command_id.set(paramaxyg.jdField_a_of_type_Int);
    if (paramaxyg.jdField_a_of_type_ArrayOfByte != null) {
      localReqBody.bytes_extension.set(ByteStringMicro.copyFrom(paramaxyg.jdField_a_of_type_ArrayOfByte));
    }
    int i = 0;
    while (i < localList.size())
    {
      a(i, (axyr)localList.get(i), localReqBody);
      i += 1;
    }
    i = axsr.a().a();
    this.jdField_a_of_type_Int = i;
    switch (i)
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramaxyg = axsr.a().a();
      int j = i;
      if (paramaxyg != null)
      {
        j = i;
        if (paramaxyg.contains("wap")) {
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
  
  void b(axyg paramaxyg)
  {
    axyv localaxyv = paramaxyg.jdField_a_of_type_Axyv;
    localaxyv.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramaxyg.jdField_a_of_type_JavaUtilList.size())
    {
      axyw localaxyw = new axyw();
      localaxyv.jdField_a_of_type_JavaUtilList.add(i, localaxyw);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxr
 * JD-Core Version:    0.7.0.1
 */