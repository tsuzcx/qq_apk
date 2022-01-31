import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
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

public class ayye
  extends ayxz
{
  void a(int paramInt, ayyy paramayyy, cmd0x388.ReqBody paramReqBody)
  {
    int i = 1;
    paramayyy = (ayyq)paramayyy;
    cmd0x388.GetImgUrlReq localGetImgUrlReq = new cmd0x388.GetImgUrlReq();
    localGetImgUrlReq.setHasFlag(true);
    localGetImgUrlReq.uint64_file_id.set(paramInt);
    localGetImgUrlReq.uint64_dst_uin.set(Long.valueOf(paramayyy.jdField_c_of_type_JavaLangString).longValue());
    localGetImgUrlReq.uint64_group_code.set(Long.parseLong(paramayyy.d));
    localGetImgUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramayyy.jdField_a_of_type_ArrayOfByte));
    localGetImgUrlReq.uint32_pic_up_timestamp.set(paramayyy.b);
    if (paramayyy.jdField_a_of_type_Long != 0L) {
      localGetImgUrlReq.uint64_fileid.set(paramayyy.jdField_a_of_type_Long);
    }
    PBUInt32Field localPBUInt32Field;
    if (paramayyy.jdField_a_of_type_Int == 65537) {
      if (axqf.a())
      {
        localGetImgUrlReq.uint32_url_flag.set(16);
        localGetImgUrlReq.uint32_url_type.set(2);
        localGetImgUrlReq.uint32_req_platform_type.set(9);
        localGetImgUrlReq.uint32_req_term.set(5);
        localGetImgUrlReq.uint32_inner_ip.set(0);
        localPBUInt32Field = localGetImgUrlReq.uint32_bu_type;
        if (paramayyy.f != 1) {
          break label317;
        }
      }
    }
    label317:
    for (paramInt = i;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localGetImgUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(ayui.a()));
      localGetImgUrlReq.uint32_req_transfer_type.set(paramayyy.jdField_c_of_type_Int);
      paramReqBody.rpt_msg_getimg_url_req.add(localGetImgUrlReq);
      return;
      localGetImgUrlReq.uint32_url_flag.set(1);
      localGetImgUrlReq.uint32_url_type.set(2);
      break;
      if (paramayyy.jdField_a_of_type_Int == 1)
      {
        localGetImgUrlReq.uint32_url_flag.set(8);
        localGetImgUrlReq.uint32_url_type.set(3);
        break;
      }
      if (paramayyy.jdField_a_of_type_Int != 131075) {
        break;
      }
      localGetImgUrlReq.uint32_url_flag.set(2);
      localGetImgUrlReq.uint32_url_type.set(4);
      break;
    }
  }
  
  public void a(aytj paramaytj, ayti paramayti)
  {
    FromServiceMsg localFromServiceMsg = paramaytj.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramaytj.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    ayyn localayyn = (ayyn)paramayti.jdField_a_of_type_JavaLangObject;
    ayzc localayzc = localayyn.jdField_a_of_type_Ayzc;
    akaw localakaw = paramaytj.jdField_a_of_type_Akaw;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        paramayti = localFromServiceMsg.getBusinessFailMsg();
        paramaytj = paramayti;
        if (paramayti == null) {
          paramaytj = "";
        }
        a(-1, 9311, (String)localObject1, paramaytj, localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      ayzt.a(localayyn, localayzc);
      return;
      localObject1 = MessageHandler.a(localFromServiceMsg);
      paramayti = localFromServiceMsg.getBusinessFailMsg();
      paramaytj = paramayti;
      if (paramayti == null) {
        paramaytj = "";
      }
      a(-1, 9044, (String)localObject1, paramaytj, localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramaytj = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getimg_url_rsp.get();
        if ((paramaytj != null) && (paramaytj.size() != 0)) {
          break label261;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramaytj)
      {
        a(-1, -9527, ayoz.a("P", -9529L), paramaytj.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label261:
      Iterator localIterator = paramaytj.iterator();
      while (localIterator.hasNext())
      {
        cmd0x388.GetImgUrlRsp localGetImgUrlRsp = (cmd0x388.GetImgUrlRsp)localIterator.next();
        try
        {
          localObject1 = (ayzo)localayzc.jdField_a_of_type_JavaUtilList.get((int)localGetImgUrlRsp.uint64_file_id.get());
        }
        catch (Exception paramaytj)
        {
          for (;;)
          {
            label412:
            Object localObject2;
            localObject1 = null;
            continue;
            paramaytj = null;
          }
        }
        try
        {
          paramaytj = (ayyq)localayyn.jdField_a_of_type_JavaUtilList.get(0);
          if (localObject1 == null) {
            continue;
          }
          if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
            ((ayzo)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          }
          i = localGetImgUrlRsp.uint32_result.get();
          if (i != 0) {
            break label908;
          }
          if (paramaytj.jdField_a_of_type_Int == 65537)
          {
            if (axqf.a()) {}
            for (paramaytj = localGetImgUrlRsp.bytes_big_thumb_down_para.get().toStringUtf8();; paramaytj = localGetImgUrlRsp.bytes_thumb_down_para.get().toStringUtf8())
            {
              ((ayzo)localObject1).jdField_a_of_type_JavaLangString = paramaytj;
              if ((!localGetImgUrlRsp.rpt_uint32_down_ip.has()) || (localGetImgUrlRsp.rpt_uint32_down_ip.size() <= 0) || (!localGetImgUrlRsp.rpt_uint32_down_port.has()) || (localGetImgUrlRsp.rpt_uint32_down_port.size() <= 0)) {
                break;
              }
              paramaytj = localGetImgUrlRsp.rpt_uint32_down_ip.get();
              localObject2 = localGetImgUrlRsp.rpt_uint32_down_port.get();
              i = 0;
              while (i < paramaytj.size())
              {
                ayuo localayuo = new ayuo();
                localayuo.jdField_a_of_type_JavaLangString = bbmj.a(((Integer)paramaytj.get(i)).intValue() & 0xFFFFFFFF);
                localayuo.jdField_a_of_type_Int = ((Integer)((List)localObject2).get(i)).intValue();
                ((ayzo)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localayuo);
                i += 1;
              }
            }
          }
          else
          {
            if (paramaytj.jdField_a_of_type_Int == 1)
            {
              paramaytj = localGetImgUrlRsp.bytes_big_down_para.get().toStringUtf8();
              break label412;
            }
            if (paramaytj.jdField_a_of_type_Int != 131075) {
              break label975;
            }
            paramaytj = localGetImgUrlRsp.bytes_original_down_para.get().toStringUtf8();
            break label412;
          }
          if ((localGetImgUrlRsp.rpt_msg_down_ip6.has()) && (localGetImgUrlRsp.rpt_msg_down_ip6.size() > 0))
          {
            paramaytj = localGetImgUrlRsp.rpt_msg_down_ip6.get();
            i = 0;
            while (i < paramaytj.size())
            {
              localObject2 = new ayuo();
              ((ayuo)localObject2).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x388.IPv6Info)paramaytj.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
              ((ayuo)localObject2).jdField_a_of_type_Int = ((cmd0x388.IPv6Info)paramaytj.get(i)).uint32_port.get();
              ((ayuo)localObject2).jdField_a_of_type_Boolean = true;
              ((ayzo)localObject1).jdField_b_of_type_JavaUtilArrayList.add(i, localObject2);
              i += 1;
            }
          }
          if (localGetImgUrlRsp.bytes_down_domain.has())
          {
            paramaytj = new ayuo();
            paramaytj.jdField_a_of_type_JavaLangString = localGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
            paramaytj.jdField_a_of_type_Int = 80;
            ((ayzo)localObject1).jdField_a_of_type_JavaUtilArrayList.add(paramaytj);
            ((ayzo)localObject1).jdField_b_of_type_JavaLangString = paramaytj.jdField_a_of_type_JavaLangString;
          }
          if (localGetImgUrlRsp.uint32_https_url_flag.has()) {
            ((ayzo)localObject1).jdField_a_of_type_Int = localGetImgUrlRsp.uint32_https_url_flag.get();
          }
          a(0, 0, "", "", localakaw, (ayzp)localObject1);
        }
        catch (Exception paramaytj)
        {
          a(-1, -9527, ayoz.a("P", -9529L), paramaytj.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakaw, (ayzp)localObject1);
        }
        continue;
        label908:
        if (ayyf.a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramayti);
            return;
          }
        }
        a(-1, -9527, ayoz.a(i), ayoz.a(i), localakaw, (ayzp)localObject1);
      }
    }
  }
  
  public void a(ayyn paramayyn)
  {
    if ((paramayyn != null) && (paramayyn.jdField_a_of_type_JavaUtilList != null) && (paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ayti localayti = new ayti();
      localayti.jdField_a_of_type_JavaLangString = "ImgStore.GroupPicDown";
      localayti.jdField_a_of_type_ArrayOfByte = a(paramayyn.jdField_a_of_type_JavaUtilList);
      localayti.jdField_a_of_type_JavaLangObject = paramayyn;
      localayti.jdField_a_of_type_Ayth = this;
      a(paramayyn, localayti);
    }
  }
  
  byte[] a(List<ayyy> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (ayyy)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (aysy.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = aysy.a().a();
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
  
  void b(ayyn paramayyn)
  {
    ayzc localayzc = paramayyn.jdField_a_of_type_Ayzc;
    localayzc.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramayyn.jdField_a_of_type_JavaUtilList.size())
    {
      ayzo localayzo = new ayzo();
      localayzc.jdField_a_of_type_JavaUtilList.add(i, localayzo);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayye
 * JD-Core Version:    0.7.0.1
 */