import com.qq.taf.jce.HexUtil;
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

public class bebe
  extends bebf
{
  int a;
  
  private void a(becl parambecl, cmd0x388.TryUpImgRsp paramTryUpImgRsp)
  {
    boolean bool = false;
    if (paramTryUpImgRsp.msg_info4busi.has())
    {
      localObject1 = (cmd0x388.TryUpInfo4Busi)paramTryUpImgRsp.msg_info4busi.get();
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_down_domain.has()) {
        parambecl.jdField_b_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_down_domain.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_big_down_url.has()) {
        parambecl.jdField_d_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_big_down_url.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_original_down_url.has()) {
        parambecl.e = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_original_down_url.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_thumb_down_url.has()) {
        parambecl.jdField_c_of_type_JavaLangString = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_thumb_down_url.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_file_resid.has()) {
        parambecl.f = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_file_resid.get().toStringUtf8();
      }
    }
    parambecl.jdField_a_of_type_Long = paramTryUpImgRsp.uint64_fileid.get();
    Object localObject1 = paramTryUpImgRsp.rpt_uint32_up_ip.get();
    Object localObject2 = paramTryUpImgRsp.rpt_uint32_up_port.get();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        long l1 = ((Integer)((List)localObject1).get(i)).intValue();
        long l2 = ((Integer)((List)localObject2).get(i)).intValue();
        bdyf localbdyf = new bdyf();
        localbdyf.jdField_a_of_type_JavaLangString = bgva.a(l1 & 0xFFFFFFFF);
        localbdyf.jdField_a_of_type_Int = ((int)l2);
        parambecl.jdField_a_of_type_JavaUtilArrayList.add(i, localbdyf);
        i += 1;
      }
    }
    if ((paramTryUpImgRsp.bool_file_exit.has()) && (paramTryUpImgRsp.bool_file_exit.get())) {
      parambecl.jdField_a_of_type_Boolean = true;
    }
    do
    {
      return;
      localObject2 = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
      if ((localObject2 == null) || (((String)localObject2).equals("")) || (localObject1 == null) || (((List)localObject1).size() == 0)) {
        throw new Exception("check ukey,iplist");
      }
      parambecl.jdField_a_of_type_JavaLangString = ((String)localObject2);
      parambecl.jdField_a_of_type_Int = ((int)paramTryUpImgRsp.uint64_block_size.get());
      parambecl.jdField_b_of_type_Int = ((int)paramTryUpImgRsp.uint64_up_offset.get());
      if (bdwu.a().a() != this.jdField_a_of_type_Int) {
        bool = true;
      }
      parambecl.jdField_b_of_type_Boolean = bool;
      parambecl.jdField_b_of_type_Long = paramTryUpImgRsp.uint64_up_offset.get();
      if (QLog.isColorLevel()) {
        QLog.d("BDH_LOG", 2, " Channel:" + paramTryUpImgRsp.bool_new_big_chan.get());
      }
    } while ((!paramTryUpImgRsp.bool_new_big_chan.has()) || (paramTryUpImgRsp.bool_new_big_chan.get() != true));
    parambecl.jdField_c_of_type_Boolean = true;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 194) && (paramInt != 197) && (paramInt != 199) && (paramInt != 200) && (paramInt != 201) && (paramInt != 203) && (paramInt != 202) && (paramInt != 120509) && (paramInt != 400010) && (paramInt != 400011);
  }
  
  void a(int paramInt, becg parambecg, cmd0x388.ReqBody paramReqBody)
  {
    parambecg = (bece)parambecg;
    cmd0x388.TryUpImgReq localTryUpImgReq = new cmd0x388.TryUpImgReq();
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(parambecg.jdField_c_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_group_code.set(Long.valueOf(parambecg.jdField_d_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.uint64_file_size.set(parambecg.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambecg.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(parambecg.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_pic_width.set(parambecg.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(parambecg.jdField_d_of_type_Int);
    localTryUpImgReq.uint32_pic_type.set(parambecg.jdField_a_of_type_Int);
    PBUInt32Field localPBUInt32Field = localTryUpImgReq.uint32_bu_type;
    if (parambecg.f == 1) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(bdxz.a()));
      if (parambecg.jdField_b_of_type_Boolean) {
        localTryUpImgReq.uint32_original_pic.set(1);
      }
      paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
      return;
    }
  }
  
  public void a(bdxf parambdxf, bdxe parambdxe)
  {
    if (QLog.isColorLevel()) {
      QLog.e("BDHCommonUpHandler", 1, "onProtoResp: " + parambdxf.a.getResultCode());
    }
    super.a(parambdxf, parambdxe);
  }
  
  public void a(bebv parambebv)
  {
    if ((parambebv != null) && (parambebv.jdField_a_of_type_JavaUtilList != null) && (parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bdxe localbdxe = new bdxe();
      localbdxe.jdField_a_of_type_JavaLangString = "ImgStore.BDHCommonUp";
      localbdxe.jdField_a_of_type_ArrayOfByte = a(parambebv);
      localbdxe.jdField_a_of_type_JavaLangObject = parambebv;
      localbdxe.jdField_a_of_type_Bdxd = this;
      a(parambebv, localbdxe);
    }
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, bebv parambebv, beck parambeck, anqe paramanqe, bdxf parambdxf, bdxe parambdxe)
  {
    try
    {
      parambdxf = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(paramArrayOfByte)).rpt_msg_tryup_img_rsp.get();
      if ((parambdxf == null) || (parambdxf.size() == 0)) {
        throw new Exception("resps null");
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      a(-1, -9527, bdsx.a("P", -9529L), paramFromServiceMsg.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramanqe, parambeck.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      return;
      Iterator localIterator = parambdxf.iterator();
      while (localIterator.hasNext())
      {
        parambdxf = (cmd0x388.TryUpImgRsp)localIterator.next();
        try
        {
          localbecl = (becl)parambeck.jdField_a_of_type_JavaUtilList.get((int)parambdxf.uint64_file_id.get());
          if (localbecl == null) {
            continue;
          }
          try
          {
            if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              localbecl.jdField_d_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = parambdxf.uint32_result.get();
            if (i != 0) {
              break label296;
            }
            a(localbecl, parambdxf);
            a(0, 0, "", "", paramanqe, localbecl);
          }
          catch (Exception parambdxf) {}
        }
        catch (Exception parambdxf)
        {
          for (;;)
          {
            int i;
            becl localbecl = null;
          }
        }
        a(-1, -9527, bdsx.a("P", -9529L), parambdxf.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramanqe, localbecl);
        continue;
        label296:
        if (a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambdxe);
            return;
          }
        }
        a(-1, -9527, bdsx.a(i), "", paramanqe, localbecl);
      }
    }
  }
  
  byte[] a(bebv parambebv)
  {
    if (parambebv == null) {
      return null;
    }
    List localList = parambebv.jdField_a_of_type_JavaUtilList;
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    localReqBody.uint32_command_id.set(parambebv.jdField_a_of_type_Int);
    if (parambebv.jdField_a_of_type_ArrayOfByte != null) {
      localReqBody.bytes_extension.set(ByteStringMicro.copyFrom(parambebv.jdField_a_of_type_ArrayOfByte));
    }
    int i = 0;
    while (i < localList.size())
    {
      a(i, (becg)localList.get(i), localReqBody);
      i += 1;
    }
    i = bdwu.a().a();
    this.jdField_a_of_type_Int = i;
    switch (i)
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      parambebv = bdwu.a().a();
      int j = i;
      if (parambebv != null)
      {
        j = i;
        if (parambebv.contains("wap")) {
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
  
  void b(bebv parambebv)
  {
    beck localbeck = parambebv.jdField_a_of_type_Beck;
    localbeck.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambebv.jdField_a_of_type_JavaUtilList.size())
    {
      becl localbecl = new becl();
      localbeck.jdField_a_of_type_JavaUtilList.add(i, localbecl);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebe
 * JD-Core Version:    0.7.0.1
 */