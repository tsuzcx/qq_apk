import android.text.TextUtils;
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

public class bebl
  extends bebt
{
  int a;
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 194) && (paramInt != 197) && (paramInt != 199) && (paramInt != 200) && (paramInt != 201) && (paramInt != 203) && (paramInt != 202);
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
    localTryUpImgReq.uint32_app_pic_type.set(parambecg.jdField_b_of_type_Int);
    PBUInt32Field localPBUInt32Field = localTryUpImgReq.uint32_bu_type;
    if (parambecg.f == 1) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(bdxz.a()));
      localTryUpImgReq.uint32_srv_upload.set(parambecg.e);
      if (parambecg.jdField_b_of_type_Boolean) {
        localTryUpImgReq.uint32_original_pic.set(1);
      }
      if (!TextUtils.isEmpty(parambecg.jdField_b_of_type_JavaLangString)) {
        localTryUpImgReq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(parambecg.jdField_b_of_type_JavaLangString));
      }
      paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
      return;
    }
  }
  
  public void a(bebv parambebv)
  {
    if ((parambebv != null) && (parambebv.jdField_a_of_type_JavaUtilList != null) && (parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bdxe localbdxe = new bdxe();
      localbdxe.jdField_a_of_type_JavaLangString = "ImgStore.GroupPicUp";
      localbdxe.jdField_a_of_type_ArrayOfByte = a(parambebv.jdField_a_of_type_JavaUtilList);
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
          localbecp = (becp)parambeck.jdField_a_of_type_JavaUtilList.get((int)parambdxf.uint64_file_id.get());
          if (localbecp == null) {
            continue;
          }
          try
          {
            if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              localbecp.d = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = parambdxf.uint32_result.get();
            if (i != 0) {
              break label800;
            }
            localbecp.jdField_a_of_type_Long = parambdxf.uint64_fileid.get();
            long l1;
            long l2;
            if ((parambdxf.bool_file_exit.has()) && (parambdxf.bool_file_exit.get()))
            {
              localbecp.jdField_a_of_type_Boolean = true;
              localList = parambdxf.rpt_uint32_up_ip.get();
              parambdxf = parambdxf.rpt_uint32_up_port.get();
              if ((localList == null) || (localList.size() <= 0)) {
                break label781;
              }
              i = 0;
              while (i < localList.size())
              {
                l1 = ((Integer)localList.get(i)).intValue();
                l2 = ((Integer)parambdxf.get(i)).intValue();
                localObject = new bdyf();
                ((bdyf)localObject).jdField_a_of_type_JavaLangString = bgva.a(l1 & 0xFFFFFFFF);
                ((bdyf)localObject).jdField_a_of_type_Int = ((int)l2);
                localbecp.jdField_a_of_type_JavaUtilArrayList.add(i, localObject);
                i += 1;
              }
            }
            List localList = parambdxf.rpt_uint32_up_ip.get();
            localObject = parambdxf.rpt_uint32_up_port.get();
            if ((localList != null) && (localList.size() > 0))
            {
              i = 0;
              while (i < localList.size())
              {
                l1 = ((Integer)localList.get(i)).intValue();
                l2 = ((Integer)((List)localObject).get(i)).intValue();
                bdyf localbdyf = new bdyf();
                localbdyf.jdField_a_of_type_JavaLangString = bgva.a(l1 & 0xFFFFFFFF);
                localbdyf.jdField_a_of_type_Int = ((int)l2);
                localbecp.jdField_a_of_type_JavaUtilArrayList.add(i, localbdyf);
                i += 1;
              }
            }
            localObject = HexUtil.bytes2HexStr(parambdxf.bytes_up_ukey.get().toByteArray());
            if ((localObject != null) && (!((String)localObject).equals("")) && (localList != null) && (localList.size() != 0)) {
              break label641;
            }
            throw new Exception("check ukey,iplist");
          }
          catch (Exception parambdxf) {}
        }
        catch (Exception parambdxf)
        {
          for (;;)
          {
            int i;
            Object localObject;
            becp localbecp = null;
            continue;
            boolean bool = false;
          }
        }
        a(-1, -9527, bdsx.a("P", -9529L), parambdxf.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramanqe, localbecp);
        continue;
        label641:
        localbecp.jdField_a_of_type_JavaLangString = ((String)localObject);
        localbecp.jdField_a_of_type_Int = ((int)parambdxf.uint64_block_size.get());
        localbecp.jdField_b_of_type_Int = ((int)parambdxf.uint64_up_offset.get());
        if (bdwu.a().a() == this.jdField_a_of_type_Int) {
          break label868;
        }
        bool = true;
        localbecp.jdField_b_of_type_Boolean = bool;
        localbecp.jdField_b_of_type_Long = parambdxf.uint64_up_offset.get();
        if (QLog.isColorLevel()) {
          QLog.d("BDH_LOG", 2, " Channel:" + parambdxf.bool_new_big_chan.get());
        }
        if ((parambdxf.bool_new_big_chan.has()) && (parambdxf.bool_new_big_chan.get() == true)) {
          localbecp.c = true;
        }
        label781:
        a(0, 0, "", "", paramanqe, localbecp);
        continue;
        label800:
        if (a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambdxe);
            return;
          }
        }
        a(-1, -9527, bdsx.a(i), "", paramanqe, localbecp);
      }
    }
  }
  
  byte[] a(List<becg> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (becg)paramList.get(i), localReqBody);
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
      paramList = bdwu.a().a();
      int j = i;
      if (paramList != null)
      {
        j = i;
        if (paramList.contains("wap")) {
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
      becp localbecp = new becp();
      localbeck.jdField_a_of_type_JavaUtilList.add(i, localbecp);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebl
 * JD-Core Version:    0.7.0.1
 */