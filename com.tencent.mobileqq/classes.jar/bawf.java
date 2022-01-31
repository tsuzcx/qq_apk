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

public class bawf
  extends bawa
{
  void a(int paramInt, bawz parambawz, cmd0x388.ReqBody paramReqBody)
  {
    int i = 1;
    parambawz = (bawr)parambawz;
    cmd0x388.GetImgUrlReq localGetImgUrlReq = new cmd0x388.GetImgUrlReq();
    localGetImgUrlReq.setHasFlag(true);
    localGetImgUrlReq.uint64_file_id.set(paramInt);
    localGetImgUrlReq.uint64_dst_uin.set(Long.valueOf(parambawz.jdField_c_of_type_JavaLangString).longValue());
    localGetImgUrlReq.uint64_group_code.set(Long.parseLong(parambawz.d));
    localGetImgUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambawz.jdField_a_of_type_ArrayOfByte));
    localGetImgUrlReq.uint32_pic_up_timestamp.set(parambawz.b);
    if (parambawz.jdField_a_of_type_Long != 0L) {
      localGetImgUrlReq.uint64_fileid.set(parambawz.jdField_a_of_type_Long);
    }
    PBUInt32Field localPBUInt32Field;
    if (parambawz.jdField_a_of_type_Int == 65537) {
      if (azls.a())
      {
        localGetImgUrlReq.uint32_url_flag.set(16);
        localGetImgUrlReq.uint32_url_type.set(2);
        localGetImgUrlReq.uint32_req_platform_type.set(9);
        localGetImgUrlReq.uint32_req_term.set(5);
        localGetImgUrlReq.uint32_inner_ip.set(0);
        localPBUInt32Field = localGetImgUrlReq.uint32_bu_type;
        if (parambawz.f != 1) {
          break label317;
        }
      }
    }
    label317:
    for (paramInt = i;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localGetImgUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(basj.a()));
      localGetImgUrlReq.uint32_req_transfer_type.set(parambawz.jdField_c_of_type_Int);
      paramReqBody.rpt_msg_getimg_url_req.add(localGetImgUrlReq);
      return;
      localGetImgUrlReq.uint32_url_flag.set(1);
      localGetImgUrlReq.uint32_url_type.set(2);
      break;
      if (parambawz.jdField_a_of_type_Int == 1)
      {
        localGetImgUrlReq.uint32_url_flag.set(8);
        localGetImgUrlReq.uint32_url_type.set(3);
        break;
      }
      if (parambawz.jdField_a_of_type_Int != 131075) {
        break;
      }
      localGetImgUrlReq.uint32_url_flag.set(2);
      localGetImgUrlReq.uint32_url_type.set(4);
      break;
    }
  }
  
  public void a(bari parambari, barh parambarh)
  {
    FromServiceMsg localFromServiceMsg = parambari.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = parambari.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bawo localbawo = (bawo)parambarh.jdField_a_of_type_JavaLangObject;
    baxd localbaxd = localbawo.jdField_a_of_type_Baxd;
    alsj localalsj = parambari.jdField_a_of_type_Alsj;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        parambarh = localFromServiceMsg.getBusinessFailMsg();
        parambari = parambarh;
        if (parambarh == null) {
          parambari = "";
        }
        a(-1, 9311, (String)localObject1, parambari, localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      baxu.a(localbawo, localbaxd);
      return;
      localObject1 = MessageHandler.a(localFromServiceMsg);
      parambarh = localFromServiceMsg.getBusinessFailMsg();
      parambari = parambarh;
      if (parambarh == null) {
        parambari = "";
      }
      a(-1, 9044, (String)localObject1, parambari, localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        parambari = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getimg_url_rsp.get();
        if ((parambari != null) && (parambari.size() != 0)) {
          break label261;
        }
        throw new Exception("resps null");
      }
      catch (Exception parambari)
      {
        a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label261:
      Iterator localIterator = parambari.iterator();
      while (localIterator.hasNext())
      {
        cmd0x388.GetImgUrlRsp localGetImgUrlRsp = (cmd0x388.GetImgUrlRsp)localIterator.next();
        try
        {
          localObject1 = (baxp)localbaxd.jdField_a_of_type_JavaUtilList.get((int)localGetImgUrlRsp.uint64_file_id.get());
        }
        catch (Exception parambari)
        {
          for (;;)
          {
            label412:
            Object localObject2;
            localObject1 = null;
            continue;
            parambari = null;
          }
        }
        try
        {
          parambari = (bawr)localbawo.jdField_a_of_type_JavaUtilList.get(0);
          if (localObject1 == null) {
            continue;
          }
          if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
            ((baxp)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          }
          i = localGetImgUrlRsp.uint32_result.get();
          if (i != 0) {
            break label908;
          }
          if (parambari.jdField_a_of_type_Int == 65537)
          {
            if (azls.a()) {}
            for (parambari = localGetImgUrlRsp.bytes_big_thumb_down_para.get().toStringUtf8();; parambari = localGetImgUrlRsp.bytes_thumb_down_para.get().toStringUtf8())
            {
              ((baxp)localObject1).jdField_a_of_type_JavaLangString = parambari;
              if ((!localGetImgUrlRsp.rpt_uint32_down_ip.has()) || (localGetImgUrlRsp.rpt_uint32_down_ip.size() <= 0) || (!localGetImgUrlRsp.rpt_uint32_down_port.has()) || (localGetImgUrlRsp.rpt_uint32_down_port.size() <= 0)) {
                break;
              }
              parambari = localGetImgUrlRsp.rpt_uint32_down_ip.get();
              localObject2 = localGetImgUrlRsp.rpt_uint32_down_port.get();
              i = 0;
              while (i < parambari.size())
              {
                basp localbasp = new basp();
                localbasp.jdField_a_of_type_JavaLangString = bdlr.a(((Integer)parambari.get(i)).intValue() & 0xFFFFFFFF);
                localbasp.jdField_a_of_type_Int = ((Integer)((List)localObject2).get(i)).intValue();
                ((baxp)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localbasp);
                i += 1;
              }
            }
          }
          else
          {
            if (parambari.jdField_a_of_type_Int == 1)
            {
              parambari = localGetImgUrlRsp.bytes_big_down_para.get().toStringUtf8();
              break label412;
            }
            if (parambari.jdField_a_of_type_Int != 131075) {
              break label975;
            }
            parambari = localGetImgUrlRsp.bytes_original_down_para.get().toStringUtf8();
            break label412;
          }
          if ((localGetImgUrlRsp.rpt_msg_down_ip6.has()) && (localGetImgUrlRsp.rpt_msg_down_ip6.size() > 0))
          {
            parambari = localGetImgUrlRsp.rpt_msg_down_ip6.get();
            i = 0;
            while (i < parambari.size())
            {
              localObject2 = new basp();
              ((basp)localObject2).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x388.IPv6Info)parambari.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
              ((basp)localObject2).jdField_a_of_type_Int = ((cmd0x388.IPv6Info)parambari.get(i)).uint32_port.get();
              ((basp)localObject2).jdField_a_of_type_Boolean = true;
              ((baxp)localObject1).jdField_b_of_type_JavaUtilArrayList.add(i, localObject2);
              i += 1;
            }
          }
          if (localGetImgUrlRsp.bytes_down_domain.has())
          {
            parambari = new basp();
            parambari.jdField_a_of_type_JavaLangString = localGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
            parambari.jdField_a_of_type_Int = 80;
            ((baxp)localObject1).jdField_a_of_type_JavaUtilArrayList.add(parambari);
            ((baxp)localObject1).jdField_b_of_type_JavaLangString = parambari.jdField_a_of_type_JavaLangString;
          }
          if (localGetImgUrlRsp.uint32_https_url_flag.has()) {
            ((baxp)localObject1).jdField_a_of_type_Int = localGetImgUrlRsp.uint32_https_url_flag.get();
          }
          a(0, 0, "", "", localalsj, (baxq)localObject1);
        }
        catch (Exception parambari)
        {
          a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalsj, (baxq)localObject1);
        }
        continue;
        label908:
        if (bawg.a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambarh);
            return;
          }
        }
        a(-1, -9527, bamw.a(i), bamw.a(i), localalsj, (baxq)localObject1);
      }
    }
  }
  
  public void a(bawo parambawo)
  {
    if ((parambawo != null) && (parambawo.jdField_a_of_type_JavaUtilList != null) && (parambawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      barh localbarh = new barh();
      localbarh.jdField_a_of_type_JavaLangString = "ImgStore.GroupPicDown";
      localbarh.jdField_a_of_type_ArrayOfByte = a(parambawo.jdField_a_of_type_JavaUtilList);
      localbarh.jdField_a_of_type_JavaLangObject = parambawo;
      localbarh.jdField_a_of_type_Barg = this;
      a(parambawo, localbarh);
    }
  }
  
  byte[] a(List<bawz> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (bawz)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (baqx.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = baqx.a().a();
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
  
  void b(bawo parambawo)
  {
    baxd localbaxd = parambawo.jdField_a_of_type_Baxd;
    localbaxd.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambawo.jdField_a_of_type_JavaUtilList.size())
    {
      baxp localbaxp = new baxp();
      localbaxd.jdField_a_of_type_JavaUtilList.add(i, localbaxp);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawf
 * JD-Core Version:    0.7.0.1
 */