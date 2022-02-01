import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.GetImgUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388.GetImgUrlRsp;
import tencent.im.cs.cmd0x388.cmd0x388.IPv6Info;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;

public class bebk
  extends bebs
{
  private void a(beby parambeby, cmd0x388.GetImgUrlRsp paramGetImgUrlRsp, becw parambecw)
  {
    int j = 0;
    Object localObject = null;
    if (parambeby.jdField_a_of_type_Int == 65537) {
      if (bcsc.a()) {
        localObject = paramGetImgUrlRsp.bytes_big_thumb_down_para.get().toStringUtf8();
      }
    }
    int i;
    for (;;)
    {
      parambecw.jdField_a_of_type_JavaLangString = ((String)localObject);
      if ((!paramGetImgUrlRsp.rpt_uint32_down_ip.has()) || (paramGetImgUrlRsp.rpt_uint32_down_ip.size() <= 0) || (!paramGetImgUrlRsp.rpt_uint32_down_port.has()) || (paramGetImgUrlRsp.rpt_uint32_down_port.size() <= 0)) {
        break;
      }
      parambeby = paramGetImgUrlRsp.rpt_uint32_down_ip.get();
      localObject = paramGetImgUrlRsp.rpt_uint32_down_port.get();
      i = 0;
      while (i < parambeby.size())
      {
        bdyf localbdyf = new bdyf();
        localbdyf.jdField_a_of_type_JavaLangString = bgva.a(((Integer)parambeby.get(i)).intValue() & 0xFFFFFFFF);
        localbdyf.jdField_a_of_type_Int = ((Integer)((List)localObject).get(i)).intValue();
        parambecw.jdField_a_of_type_JavaUtilArrayList.add(i, localbdyf);
        i += 1;
      }
      localObject = paramGetImgUrlRsp.bytes_thumb_down_para.get().toStringUtf8();
      continue;
      if (parambeby.jdField_a_of_type_Int == 1) {
        localObject = paramGetImgUrlRsp.bytes_big_down_para.get().toStringUtf8();
      } else if (parambeby.jdField_a_of_type_Int == 131075) {
        localObject = paramGetImgUrlRsp.bytes_original_down_para.get().toStringUtf8();
      }
    }
    if ((paramGetImgUrlRsp.rpt_msg_down_ip6.has()) && (paramGetImgUrlRsp.rpt_msg_down_ip6.size() > 0))
    {
      parambeby = paramGetImgUrlRsp.rpt_msg_down_ip6.get();
      i = j;
      while (i < parambeby.size())
      {
        localObject = new bdyf();
        ((bdyf)localObject).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x388.IPv6Info)parambeby.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
        ((bdyf)localObject).jdField_a_of_type_Int = ((cmd0x388.IPv6Info)parambeby.get(i)).uint32_port.get();
        ((bdyf)localObject).jdField_a_of_type_Boolean = true;
        parambecw.jdField_b_of_type_JavaUtilArrayList.add(i, localObject);
        i += 1;
      }
    }
    if (paramGetImgUrlRsp.bytes_down_domain.has())
    {
      parambeby = new bdyf();
      parambeby.jdField_a_of_type_JavaLangString = paramGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
      parambeby.jdField_a_of_type_Int = 80;
      parambecw.jdField_a_of_type_JavaUtilArrayList.add(parambeby);
      parambecw.jdField_b_of_type_JavaLangString = parambeby.jdField_a_of_type_JavaLangString;
    }
    if (paramGetImgUrlRsp.uint32_https_url_flag.has()) {
      parambecw.jdField_a_of_type_Int = paramGetImgUrlRsp.uint32_https_url_flag.get();
    }
  }
  
  void a(int paramInt, becg parambecg, cmd0x388.ReqBody paramReqBody)
  {
    int i = 1;
    parambecg = (beby)parambecg;
    cmd0x388.GetImgUrlReq localGetImgUrlReq = new cmd0x388.GetImgUrlReq();
    localGetImgUrlReq.setHasFlag(true);
    localGetImgUrlReq.uint64_file_id.set(paramInt);
    localGetImgUrlReq.uint64_dst_uin.set(Long.valueOf(parambecg.jdField_c_of_type_JavaLangString).longValue());
    localGetImgUrlReq.uint64_group_code.set(Long.parseLong(parambecg.d));
    localGetImgUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambecg.jdField_a_of_type_ArrayOfByte));
    localGetImgUrlReq.uint32_pic_up_timestamp.set(parambecg.b);
    if (parambecg.jdField_a_of_type_Long != 0L) {
      localGetImgUrlReq.uint64_fileid.set(parambecg.jdField_a_of_type_Long);
    }
    PBUInt32Field localPBUInt32Field;
    if (parambecg.jdField_a_of_type_Int == 65537) {
      if (bcsc.a())
      {
        localGetImgUrlReq.uint32_url_flag.set(16);
        localGetImgUrlReq.uint32_url_type.set(2);
        localGetImgUrlReq.uint32_req_platform_type.set(9);
        localGetImgUrlReq.uint32_req_term.set(5);
        localGetImgUrlReq.uint32_inner_ip.set(0);
        localPBUInt32Field = localGetImgUrlReq.uint32_bu_type;
        if (parambecg.f != 1) {
          break label317;
        }
      }
    }
    label317:
    for (paramInt = i;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localGetImgUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(bdxz.a()));
      localGetImgUrlReq.uint32_req_transfer_type.set(parambecg.jdField_c_of_type_Int);
      paramReqBody.rpt_msg_getimg_url_req.add(localGetImgUrlReq);
      return;
      localGetImgUrlReq.uint32_url_flag.set(1);
      localGetImgUrlReq.uint32_url_type.set(2);
      break;
      if (parambecg.jdField_a_of_type_Int == 1)
      {
        localGetImgUrlReq.uint32_url_flag.set(8);
        localGetImgUrlReq.uint32_url_type.set(3);
        break;
      }
      if (parambecg.jdField_a_of_type_Int != 131075) {
        break;
      }
      localGetImgUrlReq.uint32_url_flag.set(2);
      localGetImgUrlReq.uint32_url_type.set(4);
      break;
    }
  }
  
  protected void a(bdxf parambdxf, bdxe parambdxe, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, bebv parambebv, beck parambeck, anqe paramanqe)
  {
    try
    {
      parambdxf = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(paramArrayOfByte)).rpt_msg_getimg_url_rsp.get();
      if ((parambdxf == null) || (parambdxf.size() == 0)) {
        throw new Exception("resps null");
      }
    }
    catch (Exception parambdxf)
    {
      a(-1, -9527, bdsx.a("P", -9529L), parambdxf.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramanqe, parambeck.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      return;
      Iterator localIterator = parambdxf.iterator();
      while (localIterator.hasNext())
      {
        parambdxf = (cmd0x388.GetImgUrlRsp)localIterator.next();
        try
        {
          localbecw = (becw)parambeck.jdField_a_of_type_JavaUtilList.get((int)parambdxf.uint64_file_id.get());
          try
          {
            beby localbeby = (beby)parambebv.jdField_a_of_type_JavaUtilList.get(0);
            if (localbecw == null) {
              continue;
            }
            if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              localbecw.d = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = parambdxf.uint32_result.get();
            if (i != 0) {
              break label309;
            }
            a(localbeby, parambdxf, localbecw);
            a(0, 0, "", "", paramanqe, localbecw);
          }
          catch (Exception parambdxf) {}
        }
        catch (Exception parambdxf)
        {
          for (;;)
          {
            int i;
            becw localbecw = null;
          }
        }
        a(-1, -9527, bdsx.a("P", -9529L), parambdxf.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramanqe, localbecw);
        continue;
        label309:
        if (bebl.a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambdxe);
            return;
          }
        }
        a(-1, -9527, bdsx.a(i), bdsx.a(i), paramanqe, localbecw);
      }
    }
  }
  
  public void a(bebv parambebv)
  {
    if ((parambebv != null) && (parambebv.jdField_a_of_type_JavaUtilList != null) && (parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bdxe localbdxe = new bdxe();
      localbdxe.jdField_a_of_type_JavaLangString = "ImgStore.GroupPicDown";
      localbdxe.jdField_a_of_type_ArrayOfByte = a(parambebv.jdField_a_of_type_JavaUtilList);
      localbdxe.jdField_a_of_type_JavaLangObject = parambebv;
      localbdxe.jdField_a_of_type_Bdxd = this;
      a(parambebv, localbdxe);
    }
  }
  
  byte[] a(List<becg> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (becg)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (bdwu.a().a())
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
      becw localbecw = new becw();
      localbeck.jdField_a_of_type_JavaUtilList.add(i, localbecw);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebk
 * JD-Core Version:    0.7.0.1
 */