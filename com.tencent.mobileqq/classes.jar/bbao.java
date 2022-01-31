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

public class bbao
  extends bbaj
{
  void a(int paramInt, bbbi parambbbi, cmd0x388.ReqBody paramReqBody)
  {
    int i = 1;
    parambbbi = (bbba)parambbbi;
    cmd0x388.GetImgUrlReq localGetImgUrlReq = new cmd0x388.GetImgUrlReq();
    localGetImgUrlReq.setHasFlag(true);
    localGetImgUrlReq.uint64_file_id.set(paramInt);
    localGetImgUrlReq.uint64_dst_uin.set(Long.valueOf(parambbbi.jdField_c_of_type_JavaLangString).longValue());
    localGetImgUrlReq.uint64_group_code.set(Long.parseLong(parambbbi.d));
    localGetImgUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambbbi.jdField_a_of_type_ArrayOfByte));
    localGetImgUrlReq.uint32_pic_up_timestamp.set(parambbbi.b);
    if (parambbbi.jdField_a_of_type_Long != 0L) {
      localGetImgUrlReq.uint64_fileid.set(parambbbi.jdField_a_of_type_Long);
    }
    PBUInt32Field localPBUInt32Field;
    if (parambbbi.jdField_a_of_type_Int == 65537) {
      if (azqb.a())
      {
        localGetImgUrlReq.uint32_url_flag.set(16);
        localGetImgUrlReq.uint32_url_type.set(2);
        localGetImgUrlReq.uint32_req_platform_type.set(9);
        localGetImgUrlReq.uint32_req_term.set(5);
        localGetImgUrlReq.uint32_inner_ip.set(0);
        localPBUInt32Field = localGetImgUrlReq.uint32_bu_type;
        if (parambbbi.f != 1) {
          break label317;
        }
      }
    }
    label317:
    for (paramInt = i;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localGetImgUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(baws.a()));
      localGetImgUrlReq.uint32_req_transfer_type.set(parambbbi.jdField_c_of_type_Int);
      paramReqBody.rpt_msg_getimg_url_req.add(localGetImgUrlReq);
      return;
      localGetImgUrlReq.uint32_url_flag.set(1);
      localGetImgUrlReq.uint32_url_type.set(2);
      break;
      if (parambbbi.jdField_a_of_type_Int == 1)
      {
        localGetImgUrlReq.uint32_url_flag.set(8);
        localGetImgUrlReq.uint32_url_type.set(3);
        break;
      }
      if (parambbbi.jdField_a_of_type_Int != 131075) {
        break;
      }
      localGetImgUrlReq.uint32_url_flag.set(2);
      localGetImgUrlReq.uint32_url_type.set(4);
      break;
    }
  }
  
  public void a(bavr parambavr, bavq parambavq)
  {
    FromServiceMsg localFromServiceMsg = parambavr.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = parambavr.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bbax localbbax = (bbax)parambavq.jdField_a_of_type_JavaLangObject;
    bbbm localbbbm = localbbax.jdField_a_of_type_Bbbm;
    alwy localalwy = parambavr.jdField_a_of_type_Alwy;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        parambavq = localFromServiceMsg.getBusinessFailMsg();
        parambavr = parambavq;
        if (parambavq == null) {
          parambavr = "";
        }
        a(-1, 9311, (String)localObject1, parambavr, localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      bbcd.a(localbbax, localbbbm);
      return;
      localObject1 = MessageHandler.a(localFromServiceMsg);
      parambavq = localFromServiceMsg.getBusinessFailMsg();
      parambavr = parambavq;
      if (parambavq == null) {
        parambavr = "";
      }
      a(-1, 9044, (String)localObject1, parambavr, localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        parambavr = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getimg_url_rsp.get();
        if ((parambavr != null) && (parambavr.size() != 0)) {
          break label261;
        }
        throw new Exception("resps null");
      }
      catch (Exception parambavr)
      {
        a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label261:
      Iterator localIterator = parambavr.iterator();
      while (localIterator.hasNext())
      {
        cmd0x388.GetImgUrlRsp localGetImgUrlRsp = (cmd0x388.GetImgUrlRsp)localIterator.next();
        try
        {
          localObject1 = (bbby)localbbbm.jdField_a_of_type_JavaUtilList.get((int)localGetImgUrlRsp.uint64_file_id.get());
        }
        catch (Exception parambavr)
        {
          for (;;)
          {
            label412:
            Object localObject2;
            localObject1 = null;
            continue;
            parambavr = null;
          }
        }
        try
        {
          parambavr = (bbba)localbbax.jdField_a_of_type_JavaUtilList.get(0);
          if (localObject1 == null) {
            continue;
          }
          if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
            ((bbby)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          }
          i = localGetImgUrlRsp.uint32_result.get();
          if (i != 0) {
            break label908;
          }
          if (parambavr.jdField_a_of_type_Int == 65537)
          {
            if (azqb.a()) {}
            for (parambavr = localGetImgUrlRsp.bytes_big_thumb_down_para.get().toStringUtf8();; parambavr = localGetImgUrlRsp.bytes_thumb_down_para.get().toStringUtf8())
            {
              ((bbby)localObject1).jdField_a_of_type_JavaLangString = parambavr;
              if ((!localGetImgUrlRsp.rpt_uint32_down_ip.has()) || (localGetImgUrlRsp.rpt_uint32_down_ip.size() <= 0) || (!localGetImgUrlRsp.rpt_uint32_down_port.has()) || (localGetImgUrlRsp.rpt_uint32_down_port.size() <= 0)) {
                break;
              }
              parambavr = localGetImgUrlRsp.rpt_uint32_down_ip.get();
              localObject2 = localGetImgUrlRsp.rpt_uint32_down_port.get();
              i = 0;
              while (i < parambavr.size())
              {
                bawy localbawy = new bawy();
                localbawy.jdField_a_of_type_JavaLangString = bdqa.a(((Integer)parambavr.get(i)).intValue() & 0xFFFFFFFF);
                localbawy.jdField_a_of_type_Int = ((Integer)((List)localObject2).get(i)).intValue();
                ((bbby)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localbawy);
                i += 1;
              }
            }
          }
          else
          {
            if (parambavr.jdField_a_of_type_Int == 1)
            {
              parambavr = localGetImgUrlRsp.bytes_big_down_para.get().toStringUtf8();
              break label412;
            }
            if (parambavr.jdField_a_of_type_Int != 131075) {
              break label975;
            }
            parambavr = localGetImgUrlRsp.bytes_original_down_para.get().toStringUtf8();
            break label412;
          }
          if ((localGetImgUrlRsp.rpt_msg_down_ip6.has()) && (localGetImgUrlRsp.rpt_msg_down_ip6.size() > 0))
          {
            parambavr = localGetImgUrlRsp.rpt_msg_down_ip6.get();
            i = 0;
            while (i < parambavr.size())
            {
              localObject2 = new bawy();
              ((bawy)localObject2).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x388.IPv6Info)parambavr.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
              ((bawy)localObject2).jdField_a_of_type_Int = ((cmd0x388.IPv6Info)parambavr.get(i)).uint32_port.get();
              ((bawy)localObject2).jdField_a_of_type_Boolean = true;
              ((bbby)localObject1).jdField_b_of_type_JavaUtilArrayList.add(i, localObject2);
              i += 1;
            }
          }
          if (localGetImgUrlRsp.bytes_down_domain.has())
          {
            parambavr = new bawy();
            parambavr.jdField_a_of_type_JavaLangString = localGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
            parambavr.jdField_a_of_type_Int = 80;
            ((bbby)localObject1).jdField_a_of_type_JavaUtilArrayList.add(parambavr);
            ((bbby)localObject1).jdField_b_of_type_JavaLangString = parambavr.jdField_a_of_type_JavaLangString;
          }
          if (localGetImgUrlRsp.uint32_https_url_flag.has()) {
            ((bbby)localObject1).jdField_a_of_type_Int = localGetImgUrlRsp.uint32_https_url_flag.get();
          }
          a(0, 0, "", "", localalwy, (bbbz)localObject1);
        }
        catch (Exception parambavr)
        {
          a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalwy, (bbbz)localObject1);
        }
        continue;
        label908:
        if (bbap.a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambavq);
            return;
          }
        }
        a(-1, -9527, barf.a(i), barf.a(i), localalwy, (bbbz)localObject1);
      }
    }
  }
  
  public void a(bbax parambbax)
  {
    if ((parambbax != null) && (parambbax.jdField_a_of_type_JavaUtilList != null) && (parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bavq localbavq = new bavq();
      localbavq.jdField_a_of_type_JavaLangString = "ImgStore.GroupPicDown";
      localbavq.jdField_a_of_type_ArrayOfByte = a(parambbax.jdField_a_of_type_JavaUtilList);
      localbavq.jdField_a_of_type_JavaLangObject = parambbax;
      localbavq.jdField_a_of_type_Bavp = this;
      a(parambbax, localbavq);
    }
  }
  
  byte[] a(List<bbbi> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (bbbi)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (bavg.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = bavg.a().a();
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
  
  void b(bbax parambbax)
  {
    bbbm localbbbm = parambbax.jdField_a_of_type_Bbbm;
    localbbbm.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambbax.jdField_a_of_type_JavaUtilList.size())
    {
      bbby localbbby = new bbby();
      localbbbm.jdField_a_of_type_JavaUtilList.add(i, localbbby);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbao
 * JD-Core Version:    0.7.0.1
 */