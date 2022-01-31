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

public class axxx
  extends axxs
{
  void a(int paramInt, axyr paramaxyr, cmd0x388.ReqBody paramReqBody)
  {
    int i = 1;
    paramaxyr = (axyj)paramaxyr;
    cmd0x388.GetImgUrlReq localGetImgUrlReq = new cmd0x388.GetImgUrlReq();
    localGetImgUrlReq.setHasFlag(true);
    localGetImgUrlReq.uint64_file_id.set(paramInt);
    localGetImgUrlReq.uint64_dst_uin.set(Long.valueOf(paramaxyr.jdField_c_of_type_JavaLangString).longValue());
    localGetImgUrlReq.uint64_group_code.set(Long.parseLong(paramaxyr.d));
    localGetImgUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramaxyr.jdField_a_of_type_ArrayOfByte));
    localGetImgUrlReq.uint32_pic_up_timestamp.set(paramaxyr.b);
    if (paramaxyr.jdField_a_of_type_Long != 0L) {
      localGetImgUrlReq.uint64_fileid.set(paramaxyr.jdField_a_of_type_Long);
    }
    PBUInt32Field localPBUInt32Field;
    if (paramaxyr.jdField_a_of_type_Int == 65537) {
      if (awqg.a())
      {
        localGetImgUrlReq.uint32_url_flag.set(16);
        localGetImgUrlReq.uint32_url_type.set(2);
        localGetImgUrlReq.uint32_req_platform_type.set(9);
        localGetImgUrlReq.uint32_req_term.set(5);
        localGetImgUrlReq.uint32_inner_ip.set(0);
        localPBUInt32Field = localGetImgUrlReq.uint32_bu_type;
        if (paramaxyr.f != 1) {
          break label317;
        }
      }
    }
    label317:
    for (paramInt = i;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localGetImgUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(axub.a()));
      localGetImgUrlReq.uint32_req_transfer_type.set(paramaxyr.jdField_c_of_type_Int);
      paramReqBody.rpt_msg_getimg_url_req.add(localGetImgUrlReq);
      return;
      localGetImgUrlReq.uint32_url_flag.set(1);
      localGetImgUrlReq.uint32_url_type.set(2);
      break;
      if (paramaxyr.jdField_a_of_type_Int == 1)
      {
        localGetImgUrlReq.uint32_url_flag.set(8);
        localGetImgUrlReq.uint32_url_type.set(3);
        break;
      }
      if (paramaxyr.jdField_a_of_type_Int != 131075) {
        break;
      }
      localGetImgUrlReq.uint32_url_flag.set(2);
      localGetImgUrlReq.uint32_url_type.set(4);
      break;
    }
  }
  
  public void a(axtc paramaxtc, axtb paramaxtb)
  {
    FromServiceMsg localFromServiceMsg = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    axyg localaxyg = (axyg)paramaxtb.jdField_a_of_type_JavaLangObject;
    axyv localaxyv = localaxyg.jdField_a_of_type_Axyv;
    ajmn localajmn = paramaxtc.jdField_a_of_type_Ajmn;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        paramaxtb = localFromServiceMsg.getBusinessFailMsg();
        paramaxtc = paramaxtb;
        if (paramaxtb == null) {
          paramaxtc = "";
        }
        a(-1, 9311, (String)localObject1, paramaxtc, localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      axzm.a(localaxyg, localaxyv);
      return;
      localObject1 = MessageHandler.a(localFromServiceMsg);
      paramaxtb = localFromServiceMsg.getBusinessFailMsg();
      paramaxtc = paramaxtb;
      if (paramaxtb == null) {
        paramaxtc = "";
      }
      a(-1, 9044, (String)localObject1, paramaxtc, localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramaxtc = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getimg_url_rsp.get();
        if ((paramaxtc != null) && (paramaxtc.size() != 0)) {
          break label261;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramaxtc)
      {
        a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label261:
      Iterator localIterator = paramaxtc.iterator();
      while (localIterator.hasNext())
      {
        cmd0x388.GetImgUrlRsp localGetImgUrlRsp = (cmd0x388.GetImgUrlRsp)localIterator.next();
        try
        {
          localObject1 = (axzh)localaxyv.jdField_a_of_type_JavaUtilList.get((int)localGetImgUrlRsp.uint64_file_id.get());
        }
        catch (Exception paramaxtc)
        {
          for (;;)
          {
            label412:
            Object localObject2;
            localObject1 = null;
            continue;
            paramaxtc = null;
          }
        }
        try
        {
          paramaxtc = (axyj)localaxyg.jdField_a_of_type_JavaUtilList.get(0);
          if (localObject1 == null) {
            continue;
          }
          if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
            ((axzh)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          }
          i = localGetImgUrlRsp.uint32_result.get();
          if (i != 0) {
            break label908;
          }
          if (paramaxtc.jdField_a_of_type_Int == 65537)
          {
            if (awqg.a()) {}
            for (paramaxtc = localGetImgUrlRsp.bytes_big_thumb_down_para.get().toStringUtf8();; paramaxtc = localGetImgUrlRsp.bytes_thumb_down_para.get().toStringUtf8())
            {
              ((axzh)localObject1).jdField_a_of_type_JavaLangString = paramaxtc;
              if ((!localGetImgUrlRsp.rpt_uint32_down_ip.has()) || (localGetImgUrlRsp.rpt_uint32_down_ip.size() <= 0) || (!localGetImgUrlRsp.rpt_uint32_down_port.has()) || (localGetImgUrlRsp.rpt_uint32_down_port.size() <= 0)) {
                break;
              }
              paramaxtc = localGetImgUrlRsp.rpt_uint32_down_ip.get();
              localObject2 = localGetImgUrlRsp.rpt_uint32_down_port.get();
              i = 0;
              while (i < paramaxtc.size())
              {
                axuh localaxuh = new axuh();
                localaxuh.jdField_a_of_type_JavaLangString = bakz.a(((Integer)paramaxtc.get(i)).intValue() & 0xFFFFFFFF);
                localaxuh.jdField_a_of_type_Int = ((Integer)((List)localObject2).get(i)).intValue();
                ((axzh)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localaxuh);
                i += 1;
              }
            }
          }
          else
          {
            if (paramaxtc.jdField_a_of_type_Int == 1)
            {
              paramaxtc = localGetImgUrlRsp.bytes_big_down_para.get().toStringUtf8();
              break label412;
            }
            if (paramaxtc.jdField_a_of_type_Int != 131075) {
              break label975;
            }
            paramaxtc = localGetImgUrlRsp.bytes_original_down_para.get().toStringUtf8();
            break label412;
          }
          if ((localGetImgUrlRsp.rpt_msg_down_ip6.has()) && (localGetImgUrlRsp.rpt_msg_down_ip6.size() > 0))
          {
            paramaxtc = localGetImgUrlRsp.rpt_msg_down_ip6.get();
            i = 0;
            while (i < paramaxtc.size())
            {
              localObject2 = new axuh();
              ((axuh)localObject2).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x388.IPv6Info)paramaxtc.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
              ((axuh)localObject2).jdField_a_of_type_Int = ((cmd0x388.IPv6Info)paramaxtc.get(i)).uint32_port.get();
              ((axuh)localObject2).jdField_a_of_type_Boolean = true;
              ((axzh)localObject1).jdField_b_of_type_JavaUtilArrayList.add(i, localObject2);
              i += 1;
            }
          }
          if (localGetImgUrlRsp.bytes_down_domain.has())
          {
            paramaxtc = new axuh();
            paramaxtc.jdField_a_of_type_JavaLangString = localGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
            paramaxtc.jdField_a_of_type_Int = 80;
            ((axzh)localObject1).jdField_a_of_type_JavaUtilArrayList.add(paramaxtc);
            ((axzh)localObject1).jdField_b_of_type_JavaLangString = paramaxtc.jdField_a_of_type_JavaLangString;
          }
          if (localGetImgUrlRsp.uint32_https_url_flag.has()) {
            ((axzh)localObject1).jdField_a_of_type_Int = localGetImgUrlRsp.uint32_https_url_flag.get();
          }
          a(0, 0, "", "", localajmn, (axzi)localObject1);
        }
        catch (Exception paramaxtc)
        {
          a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, (axzi)localObject1);
        }
        continue;
        label908:
        if (axxy.a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramaxtb);
            return;
          }
        }
        a(-1, -9527, axou.a(i), axou.a(i), localajmn, (axzi)localObject1);
      }
    }
  }
  
  public void a(axyg paramaxyg)
  {
    if ((paramaxyg != null) && (paramaxyg.jdField_a_of_type_JavaUtilList != null) && (paramaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      axtb localaxtb = new axtb();
      localaxtb.jdField_a_of_type_JavaLangString = "ImgStore.GroupPicDown";
      localaxtb.jdField_a_of_type_ArrayOfByte = a(paramaxyg.jdField_a_of_type_JavaUtilList);
      localaxtb.jdField_a_of_type_JavaLangObject = paramaxyg;
      localaxtb.jdField_a_of_type_Axta = this;
      a(paramaxyg, localaxtb);
    }
  }
  
  byte[] a(List<axyr> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (axyr)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (axsr.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = axsr.a().a();
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
  
  void b(axyg paramaxyg)
  {
    axyv localaxyv = paramaxyg.jdField_a_of_type_Axyv;
    localaxyv.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramaxyg.jdField_a_of_type_JavaUtilList.size())
    {
      axzh localaxzh = new axzh();
      localaxyv.jdField_a_of_type_JavaUtilList.add(i, localaxzh);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxx
 * JD-Core Version:    0.7.0.1
 */