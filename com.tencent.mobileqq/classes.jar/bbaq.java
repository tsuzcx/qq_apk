import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlRsp;
import tencent.im.cs.cmd0x388.cmd0x388.IPv6Info;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;

public class bbaq
  extends bbaj
{
  void a(int paramInt, bbbi parambbbi, cmd0x388.ReqBody paramReqBody)
  {
    parambbbi = (bbbb)parambbbi;
    cmd0x388.GetPttUrlReq localGetPttUrlReq = new cmd0x388.GetPttUrlReq();
    localGetPttUrlReq.setHasFlag(true);
    localGetPttUrlReq.uint64_file_id.set(paramInt);
    localGetPttUrlReq.uint64_dst_uin.set(Long.valueOf(parambbbi.c).longValue());
    localGetPttUrlReq.uint64_group_code.set(Long.parseLong(parambbbi.d));
    localGetPttUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambbbi.jdField_a_of_type_ArrayOfByte));
    if (parambbbi.jdField_a_of_type_Long != 0L) {
      localGetPttUrlReq.uint64_fileid.set(parambbbi.jdField_a_of_type_Long);
    }
    localGetPttUrlReq.uint32_req_platform_type.set(9);
    localGetPttUrlReq.uint32_req_term.set(5);
    localGetPttUrlReq.uint32_inner_ip.set(0);
    Object localObject = localGetPttUrlReq.uint32_bu_type;
    if (parambbbi.f == 1) {
      paramInt = 3;
    }
    for (;;)
    {
      ((PBUInt32Field)localObject).set(paramInt);
      localGetPttUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(baws.a()));
      localGetPttUrlReq.uint32_codec.set(parambbbi.jdField_a_of_type_Int);
      if (parambbbi.jdField_a_of_type_JavaLangString != null) {}
      try
      {
        localObject = parambbbi.jdField_a_of_type_JavaLangString.getBytes("utf-8");
        localGetPttUrlReq.bytes_file_key.set(ByteStringMicro.copyFrom((byte[])localObject));
        label207:
        localGetPttUrlReq.uint32_is_auto.set(parambbbi.b);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.GroupPttDownHandler", 2, "constructReqBody GroupPttDownReq = " + parambbbi.toString());
        }
        paramReqBody.rpt_msg_getptt_url_req.add(localGetPttUrlReq);
        return;
        paramInt = 4;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label207;
      }
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
      }
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getptt_url_rsp.get().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        parambavr = (cmd0x388.GetPttUrlRsp)localIterator.next();
      }
      catch (Exception parambavr)
      {
        a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      }
      try
      {
        localObject1 = (bbbs)localbbbm.jdField_a_of_type_JavaUtilList.get((int)parambavr.uint64_file_id.get());
        if ((localObject1 != null) && (localFromServiceMsg != null)) {}
        try
        {
          ((bbbs)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          if (QLog.isColorLevel()) {
            QLog.e("http_sideway", 2, "GroupPttDownHandler.onProtoResp:isSendByQuickHttp=" + ((bbbs)localObject1).d);
          }
          i = parambavr.uint32_result.get();
          if (i != 0) {
            break label714;
          }
          ((bbbs)localObject1).jdField_a_of_type_JavaLangString = parambavr.bytes_down_para.get().toStringUtf8();
          List localList = parambavr.rpt_uint32_down_ip.get();
          Object localObject2 = parambavr.rpt_uint32_down_port.get();
          i = 0;
          if (i < localList.size())
          {
            bawy localbawy = new bawy();
            localbawy.jdField_a_of_type_JavaLangString = bdqa.a(((Integer)localList.get(i)).intValue() & 0xFFFFFFFF);
            localbawy.jdField_a_of_type_Int = ((Integer)((List)localObject2).get(i)).intValue();
            ((bbbs)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localbawy);
            i += 1;
            continue;
          }
          if ((parambavr.rpt_msg_down_ip6.has()) && (parambavr.rpt_msg_down_ip6.size() > 0))
          {
            localList = parambavr.rpt_msg_down_ip6.get();
            i = 0;
            if (i < localList.size())
            {
              localObject2 = new bawy();
              ((bawy)localObject2).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x388.IPv6Info)localList.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
              ((bawy)localObject2).jdField_a_of_type_Int = ((cmd0x388.IPv6Info)localList.get(i)).uint32_port.get();
              ((bawy)localObject2).jdField_a_of_type_Boolean = true;
              ((bbbs)localObject1).jdField_b_of_type_JavaUtilArrayList.add(i, localObject2);
              i += 1;
              continue;
            }
          }
          if (parambavr.rpt_str_domain.has()) {
            ((bbbs)localObject1).jdField_b_of_type_JavaLangString = parambavr.rpt_str_domain.get();
          }
          a(0, 0, "", "", localalwy, (bbbz)localObject1);
        }
        catch (Exception parambavr) {}
      }
      catch (Exception parambavr)
      {
        localObject1 = null;
        continue;
      }
      a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalwy, (bbbz)localObject1);
      continue;
      break;
      label714:
      if (parambavr.uint32_allow_retry.get() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onProtoResp :group ptt server not allow retry");
        }
        ((bbbs)localObject1).e = false;
      }
      if (bbap.a(i))
      {
        this.b += 1;
        if (this.b < 2)
        {
          localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambavq);
          return;
        }
      }
      a(-1, -9527, barf.a(i), "", localalwy, (bbbz)localObject1);
    }
  }
  
  public void a(bbax parambbax)
  {
    if ((parambbax != null) && (parambbax.jdField_a_of_type_JavaUtilList != null) && (parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bavq localbavq = new bavq();
      localbavq.jdField_a_of_type_JavaLangString = "PttStore.GroupPttDown";
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
    localReqBody.uint32_subcmd.set(4);
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
      bbbs localbbbs = new bbbs();
      localbbbm.jdField_a_of_type_JavaUtilList.add(i, localbbbs);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbaq
 * JD-Core Version:    0.7.0.1
 */