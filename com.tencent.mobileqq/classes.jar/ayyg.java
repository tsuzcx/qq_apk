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

public class ayyg
  extends ayyb
{
  void a(int paramInt, ayza paramayza, cmd0x388.ReqBody paramReqBody)
  {
    int i = 1;
    paramayza = (ayys)paramayza;
    cmd0x388.GetImgUrlReq localGetImgUrlReq = new cmd0x388.GetImgUrlReq();
    localGetImgUrlReq.setHasFlag(true);
    localGetImgUrlReq.uint64_file_id.set(paramInt);
    localGetImgUrlReq.uint64_dst_uin.set(Long.valueOf(paramayza.jdField_c_of_type_JavaLangString).longValue());
    localGetImgUrlReq.uint64_group_code.set(Long.parseLong(paramayza.d));
    localGetImgUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramayza.jdField_a_of_type_ArrayOfByte));
    localGetImgUrlReq.uint32_pic_up_timestamp.set(paramayza.b);
    if (paramayza.jdField_a_of_type_Long != 0L) {
      localGetImgUrlReq.uint64_fileid.set(paramayza.jdField_a_of_type_Long);
    }
    PBUInt32Field localPBUInt32Field;
    if (paramayza.jdField_a_of_type_Int == 65537) {
      if (axqh.a())
      {
        localGetImgUrlReq.uint32_url_flag.set(16);
        localGetImgUrlReq.uint32_url_type.set(2);
        localGetImgUrlReq.uint32_req_platform_type.set(9);
        localGetImgUrlReq.uint32_req_term.set(5);
        localGetImgUrlReq.uint32_inner_ip.set(0);
        localPBUInt32Field = localGetImgUrlReq.uint32_bu_type;
        if (paramayza.f != 1) {
          break label317;
        }
      }
    }
    label317:
    for (paramInt = i;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localGetImgUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(ayuk.a()));
      localGetImgUrlReq.uint32_req_transfer_type.set(paramayza.jdField_c_of_type_Int);
      paramReqBody.rpt_msg_getimg_url_req.add(localGetImgUrlReq);
      return;
      localGetImgUrlReq.uint32_url_flag.set(1);
      localGetImgUrlReq.uint32_url_type.set(2);
      break;
      if (paramayza.jdField_a_of_type_Int == 1)
      {
        localGetImgUrlReq.uint32_url_flag.set(8);
        localGetImgUrlReq.uint32_url_type.set(3);
        break;
      }
      if (paramayza.jdField_a_of_type_Int != 131075) {
        break;
      }
      localGetImgUrlReq.uint32_url_flag.set(2);
      localGetImgUrlReq.uint32_url_type.set(4);
      break;
    }
  }
  
  public void a(aytl paramaytl, aytk paramaytk)
  {
    FromServiceMsg localFromServiceMsg = paramaytl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramaytl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    ayyp localayyp = (ayyp)paramaytk.jdField_a_of_type_JavaLangObject;
    ayze localayze = localayyp.jdField_a_of_type_Ayze;
    akau localakau = paramaytl.jdField_a_of_type_Akau;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        paramaytk = localFromServiceMsg.getBusinessFailMsg();
        paramaytl = paramaytk;
        if (paramaytk == null) {
          paramaytl = "";
        }
        a(-1, 9311, (String)localObject1, paramaytl, localakau, localayze.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      ayzv.a(localayyp, localayze);
      return;
      localObject1 = MessageHandler.a(localFromServiceMsg);
      paramaytk = localFromServiceMsg.getBusinessFailMsg();
      paramaytl = paramaytk;
      if (paramaytk == null) {
        paramaytl = "";
      }
      a(-1, 9044, (String)localObject1, paramaytl, localakau, localayze.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramaytl = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getimg_url_rsp.get();
        if ((paramaytl != null) && (paramaytl.size() != 0)) {
          break label261;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramaytl)
      {
        a(-1, -9527, aypb.a("P", -9529L), paramaytl.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakau, localayze.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label261:
      Iterator localIterator = paramaytl.iterator();
      while (localIterator.hasNext())
      {
        cmd0x388.GetImgUrlRsp localGetImgUrlRsp = (cmd0x388.GetImgUrlRsp)localIterator.next();
        try
        {
          localObject1 = (ayzq)localayze.jdField_a_of_type_JavaUtilList.get((int)localGetImgUrlRsp.uint64_file_id.get());
        }
        catch (Exception paramaytl)
        {
          for (;;)
          {
            label412:
            Object localObject2;
            localObject1 = null;
            continue;
            paramaytl = null;
          }
        }
        try
        {
          paramaytl = (ayys)localayyp.jdField_a_of_type_JavaUtilList.get(0);
          if (localObject1 == null) {
            continue;
          }
          if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
            ((ayzq)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          }
          i = localGetImgUrlRsp.uint32_result.get();
          if (i != 0) {
            break label908;
          }
          if (paramaytl.jdField_a_of_type_Int == 65537)
          {
            if (axqh.a()) {}
            for (paramaytl = localGetImgUrlRsp.bytes_big_thumb_down_para.get().toStringUtf8();; paramaytl = localGetImgUrlRsp.bytes_thumb_down_para.get().toStringUtf8())
            {
              ((ayzq)localObject1).jdField_a_of_type_JavaLangString = paramaytl;
              if ((!localGetImgUrlRsp.rpt_uint32_down_ip.has()) || (localGetImgUrlRsp.rpt_uint32_down_ip.size() <= 0) || (!localGetImgUrlRsp.rpt_uint32_down_port.has()) || (localGetImgUrlRsp.rpt_uint32_down_port.size() <= 0)) {
                break;
              }
              paramaytl = localGetImgUrlRsp.rpt_uint32_down_ip.get();
              localObject2 = localGetImgUrlRsp.rpt_uint32_down_port.get();
              i = 0;
              while (i < paramaytl.size())
              {
                ayuq localayuq = new ayuq();
                localayuq.jdField_a_of_type_JavaLangString = bbmx.a(((Integer)paramaytl.get(i)).intValue() & 0xFFFFFFFF);
                localayuq.jdField_a_of_type_Int = ((Integer)((List)localObject2).get(i)).intValue();
                ((ayzq)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localayuq);
                i += 1;
              }
            }
          }
          else
          {
            if (paramaytl.jdField_a_of_type_Int == 1)
            {
              paramaytl = localGetImgUrlRsp.bytes_big_down_para.get().toStringUtf8();
              break label412;
            }
            if (paramaytl.jdField_a_of_type_Int != 131075) {
              break label975;
            }
            paramaytl = localGetImgUrlRsp.bytes_original_down_para.get().toStringUtf8();
            break label412;
          }
          if ((localGetImgUrlRsp.rpt_msg_down_ip6.has()) && (localGetImgUrlRsp.rpt_msg_down_ip6.size() > 0))
          {
            paramaytl = localGetImgUrlRsp.rpt_msg_down_ip6.get();
            i = 0;
            while (i < paramaytl.size())
            {
              localObject2 = new ayuq();
              ((ayuq)localObject2).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x388.IPv6Info)paramaytl.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
              ((ayuq)localObject2).jdField_a_of_type_Int = ((cmd0x388.IPv6Info)paramaytl.get(i)).uint32_port.get();
              ((ayuq)localObject2).jdField_a_of_type_Boolean = true;
              ((ayzq)localObject1).jdField_b_of_type_JavaUtilArrayList.add(i, localObject2);
              i += 1;
            }
          }
          if (localGetImgUrlRsp.bytes_down_domain.has())
          {
            paramaytl = new ayuq();
            paramaytl.jdField_a_of_type_JavaLangString = localGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
            paramaytl.jdField_a_of_type_Int = 80;
            ((ayzq)localObject1).jdField_a_of_type_JavaUtilArrayList.add(paramaytl);
            ((ayzq)localObject1).jdField_b_of_type_JavaLangString = paramaytl.jdField_a_of_type_JavaLangString;
          }
          if (localGetImgUrlRsp.uint32_https_url_flag.has()) {
            ((ayzq)localObject1).jdField_a_of_type_Int = localGetImgUrlRsp.uint32_https_url_flag.get();
          }
          a(0, 0, "", "", localakau, (ayzr)localObject1);
        }
        catch (Exception paramaytl)
        {
          a(-1, -9527, aypb.a("P", -9529L), paramaytl.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakau, (ayzr)localObject1);
        }
        continue;
        label908:
        if (ayyh.a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramaytk);
            return;
          }
        }
        a(-1, -9527, aypb.a(i), aypb.a(i), localakau, (ayzr)localObject1);
      }
    }
  }
  
  public void a(ayyp paramayyp)
  {
    if ((paramayyp != null) && (paramayyp.jdField_a_of_type_JavaUtilList != null) && (paramayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      aytk localaytk = new aytk();
      localaytk.jdField_a_of_type_JavaLangString = "ImgStore.GroupPicDown";
      localaytk.jdField_a_of_type_ArrayOfByte = a(paramayyp.jdField_a_of_type_JavaUtilList);
      localaytk.jdField_a_of_type_JavaLangObject = paramayyp;
      localaytk.jdField_a_of_type_Aytj = this;
      a(paramayyp, localaytk);
    }
  }
  
  byte[] a(List<ayza> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (ayza)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (ayta.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = ayta.a().a();
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
  
  void b(ayyp paramayyp)
  {
    ayze localayze = paramayyp.jdField_a_of_type_Ayze;
    localayze.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramayyp.jdField_a_of_type_JavaUtilList.size())
    {
      ayzq localayzq = new ayzq();
      localayze.jdField_a_of_type_JavaUtilList.add(i, localayzq);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyg
 * JD-Core Version:    0.7.0.1
 */