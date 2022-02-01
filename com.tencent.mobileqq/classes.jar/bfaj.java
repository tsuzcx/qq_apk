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

public class bfaj
  extends bfar
{
  private void a(bfax parambfax, cmd0x388.GetImgUrlRsp paramGetImgUrlRsp, bfbv parambfbv)
  {
    int j = 0;
    Object localObject = null;
    if (parambfax.jdField_a_of_type_Int == 65537) {
      if (bdku.a()) {
        localObject = paramGetImgUrlRsp.bytes_big_thumb_down_para.get().toStringUtf8();
      }
    }
    int i;
    for (;;)
    {
      parambfbv.jdField_a_of_type_JavaLangString = ((String)localObject);
      if ((!paramGetImgUrlRsp.rpt_uint32_down_ip.has()) || (paramGetImgUrlRsp.rpt_uint32_down_ip.size() <= 0) || (!paramGetImgUrlRsp.rpt_uint32_down_port.has()) || (paramGetImgUrlRsp.rpt_uint32_down_port.size() <= 0)) {
        break;
      }
      parambfax = paramGetImgUrlRsp.rpt_uint32_down_ip.get();
      localObject = paramGetImgUrlRsp.rpt_uint32_down_port.get();
      i = 0;
      while (i < parambfax.size())
      {
        bewy localbewy = new bewy();
        localbewy.jdField_a_of_type_JavaLangString = bhvd.a(((Integer)parambfax.get(i)).intValue() & 0xFFFFFFFF);
        localbewy.jdField_a_of_type_Int = ((Integer)((List)localObject).get(i)).intValue();
        parambfbv.jdField_a_of_type_JavaUtilArrayList.add(i, localbewy);
        i += 1;
      }
      localObject = paramGetImgUrlRsp.bytes_thumb_down_para.get().toStringUtf8();
      continue;
      if (parambfax.jdField_a_of_type_Int == 1) {
        localObject = paramGetImgUrlRsp.bytes_big_down_para.get().toStringUtf8();
      } else if (parambfax.jdField_a_of_type_Int == 131075) {
        localObject = paramGetImgUrlRsp.bytes_original_down_para.get().toStringUtf8();
      }
    }
    if ((paramGetImgUrlRsp.rpt_msg_down_ip6.has()) && (paramGetImgUrlRsp.rpt_msg_down_ip6.size() > 0))
    {
      parambfax = paramGetImgUrlRsp.rpt_msg_down_ip6.get();
      i = j;
      while (i < parambfax.size())
      {
        localObject = new bewy();
        ((bewy)localObject).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x388.IPv6Info)parambfax.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
        ((bewy)localObject).jdField_a_of_type_Int = ((cmd0x388.IPv6Info)parambfax.get(i)).uint32_port.get();
        ((bewy)localObject).jdField_a_of_type_Boolean = true;
        parambfbv.jdField_b_of_type_JavaUtilArrayList.add(i, localObject);
        i += 1;
      }
    }
    if (paramGetImgUrlRsp.bytes_down_domain.has())
    {
      parambfax = new bewy();
      parambfax.jdField_a_of_type_JavaLangString = paramGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
      parambfax.jdField_a_of_type_Int = 80;
      parambfbv.jdField_a_of_type_JavaUtilArrayList.add(parambfax);
      parambfbv.jdField_b_of_type_JavaLangString = parambfax.jdField_a_of_type_JavaLangString;
    }
    if (paramGetImgUrlRsp.uint32_https_url_flag.has()) {
      parambfbv.jdField_a_of_type_Int = paramGetImgUrlRsp.uint32_https_url_flag.get();
    }
  }
  
  void a(int paramInt, bfbf parambfbf, cmd0x388.ReqBody paramReqBody)
  {
    int i = 1;
    parambfbf = (bfax)parambfbf;
    cmd0x388.GetImgUrlReq localGetImgUrlReq = new cmd0x388.GetImgUrlReq();
    localGetImgUrlReq.setHasFlag(true);
    localGetImgUrlReq.uint64_file_id.set(paramInt);
    localGetImgUrlReq.uint64_dst_uin.set(Long.valueOf(parambfbf.jdField_c_of_type_JavaLangString).longValue());
    localGetImgUrlReq.uint64_group_code.set(Long.parseLong(parambfbf.d));
    localGetImgUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambfbf.jdField_a_of_type_ArrayOfByte));
    localGetImgUrlReq.uint32_pic_up_timestamp.set(parambfbf.b);
    if (parambfbf.jdField_a_of_type_Long != 0L) {
      localGetImgUrlReq.uint64_fileid.set(parambfbf.jdField_a_of_type_Long);
    }
    PBUInt32Field localPBUInt32Field;
    if (parambfbf.jdField_a_of_type_Int == 65537) {
      if (bdku.a())
      {
        localGetImgUrlReq.uint32_url_flag.set(16);
        localGetImgUrlReq.uint32_url_type.set(2);
        localGetImgUrlReq.uint32_req_platform_type.set(9);
        localGetImgUrlReq.uint32_req_term.set(5);
        localGetImgUrlReq.uint32_inner_ip.set(0);
        localPBUInt32Field = localGetImgUrlReq.uint32_bu_type;
        if (parambfbf.f != 1) {
          break label317;
        }
      }
    }
    label317:
    for (paramInt = i;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localGetImgUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(bews.a()));
      localGetImgUrlReq.uint32_req_transfer_type.set(parambfbf.jdField_c_of_type_Int);
      paramReqBody.rpt_msg_getimg_url_req.add(localGetImgUrlReq);
      return;
      localGetImgUrlReq.uint32_url_flag.set(1);
      localGetImgUrlReq.uint32_url_type.set(2);
      break;
      if (parambfbf.jdField_a_of_type_Int == 1)
      {
        localGetImgUrlReq.uint32_url_flag.set(8);
        localGetImgUrlReq.uint32_url_type.set(3);
        break;
      }
      if (parambfbf.jdField_a_of_type_Int != 131075) {
        break;
      }
      localGetImgUrlReq.uint32_url_flag.set(2);
      localGetImgUrlReq.uint32_url_type.set(4);
      break;
    }
  }
  
  protected void a(bevy parambevy, bevx parambevx, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, bfau parambfau, bfbj parambfbj, aock paramaock)
  {
    try
    {
      parambevy = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(paramArrayOfByte)).rpt_msg_getimg_url_rsp.get();
      if ((parambevy == null) || (parambevy.size() == 0)) {
        throw new Exception("resps null");
      }
    }
    catch (Exception parambevy)
    {
      a(-1, -9527, berp.a("P", -9529L), parambevy.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramaock, parambfbj.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      return;
      Iterator localIterator = parambevy.iterator();
      while (localIterator.hasNext())
      {
        parambevy = (cmd0x388.GetImgUrlRsp)localIterator.next();
        try
        {
          localbfbv = (bfbv)parambfbj.jdField_a_of_type_JavaUtilList.get((int)parambevy.uint64_file_id.get());
          try
          {
            bfax localbfax = (bfax)parambfau.jdField_a_of_type_JavaUtilList.get(0);
            if (localbfbv == null) {
              continue;
            }
            if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              localbfbv.d = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = parambevy.uint32_result.get();
            if (i != 0) {
              break label309;
            }
            a(localbfax, parambevy, localbfbv);
            a(0, 0, "", "", paramaock, localbfbv);
          }
          catch (Exception parambevy) {}
        }
        catch (Exception parambevy)
        {
          for (;;)
          {
            int i;
            bfbv localbfbv = null;
          }
        }
        a(-1, -9527, berp.a("P", -9529L), parambevy.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramaock, localbfbv);
        continue;
        label309:
        if (bfak.a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambevx);
            return;
          }
        }
        a(-1, -9527, berp.a(i), berp.a(i), paramaock, localbfbv);
      }
    }
  }
  
  public void a(bfau parambfau)
  {
    if ((parambfau != null) && (parambfau.jdField_a_of_type_JavaUtilList != null) && (parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bevx localbevx = new bevx();
      localbevx.jdField_a_of_type_JavaLangString = "ImgStore.GroupPicDown";
      localbevx.jdField_a_of_type_ArrayOfByte = a(parambfau.jdField_a_of_type_JavaUtilList);
      localbevx.jdField_a_of_type_JavaLangObject = parambfau;
      localbevx.jdField_a_of_type_Bevw = this;
      a(parambfau, localbevx);
    }
  }
  
  byte[] a(List<bfbf> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (bfbf)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (bevn.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = bevn.a().a();
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
  
  void b(bfau parambfau)
  {
    bfbj localbfbj = parambfau.jdField_a_of_type_Bfbj;
    localbfbj.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambfau.jdField_a_of_type_JavaUtilList.size())
    {
      bfbv localbfbv = new bfbv();
      localbfbj.jdField_a_of_type_JavaUtilList.add(i, localbfbv);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfaj
 * JD-Core Version:    0.7.0.1
 */