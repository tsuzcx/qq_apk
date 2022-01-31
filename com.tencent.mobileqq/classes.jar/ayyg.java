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

public class ayyg
  extends ayxz
{
  void a(int paramInt, ayyy paramayyy, cmd0x388.ReqBody paramReqBody)
  {
    paramayyy = (ayyr)paramayyy;
    cmd0x388.GetPttUrlReq localGetPttUrlReq = new cmd0x388.GetPttUrlReq();
    localGetPttUrlReq.setHasFlag(true);
    localGetPttUrlReq.uint64_file_id.set(paramInt);
    localGetPttUrlReq.uint64_dst_uin.set(Long.valueOf(paramayyy.c).longValue());
    localGetPttUrlReq.uint64_group_code.set(Long.parseLong(paramayyy.d));
    localGetPttUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramayyy.jdField_a_of_type_ArrayOfByte));
    if (paramayyy.jdField_a_of_type_Long != 0L) {
      localGetPttUrlReq.uint64_fileid.set(paramayyy.jdField_a_of_type_Long);
    }
    localGetPttUrlReq.uint32_req_platform_type.set(9);
    localGetPttUrlReq.uint32_req_term.set(5);
    localGetPttUrlReq.uint32_inner_ip.set(0);
    Object localObject = localGetPttUrlReq.uint32_bu_type;
    if (paramayyy.f == 1) {
      paramInt = 3;
    }
    for (;;)
    {
      ((PBUInt32Field)localObject).set(paramInt);
      localGetPttUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(ayui.a()));
      localGetPttUrlReq.uint32_codec.set(paramayyy.jdField_a_of_type_Int);
      if (paramayyy.jdField_a_of_type_JavaLangString != null) {}
      try
      {
        localObject = paramayyy.jdField_a_of_type_JavaLangString.getBytes("utf-8");
        localGetPttUrlReq.bytes_file_key.set(ByteStringMicro.copyFrom((byte[])localObject));
        label207:
        localGetPttUrlReq.uint32_is_auto.set(paramayyy.b);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.GroupPttDownHandler", 2, "constructReqBody GroupPttDownReq = " + paramayyy.toString());
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
        paramaytj = (cmd0x388.GetPttUrlRsp)localIterator.next();
      }
      catch (Exception paramaytj)
      {
        a(-1, -9527, ayoz.a("P", -9529L), paramaytj.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      }
      try
      {
        localObject1 = (ayzi)localayzc.jdField_a_of_type_JavaUtilList.get((int)paramaytj.uint64_file_id.get());
        if ((localObject1 != null) && (localFromServiceMsg != null)) {}
        try
        {
          ((ayzi)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          if (QLog.isColorLevel()) {
            QLog.e("http_sideway", 2, "GroupPttDownHandler.onProtoResp:isSendByQuickHttp=" + ((ayzi)localObject1).d);
          }
          i = paramaytj.uint32_result.get();
          if (i != 0) {
            break label714;
          }
          ((ayzi)localObject1).jdField_a_of_type_JavaLangString = paramaytj.bytes_down_para.get().toStringUtf8();
          List localList = paramaytj.rpt_uint32_down_ip.get();
          Object localObject2 = paramaytj.rpt_uint32_down_port.get();
          i = 0;
          if (i < localList.size())
          {
            ayuo localayuo = new ayuo();
            localayuo.jdField_a_of_type_JavaLangString = bbmj.a(((Integer)localList.get(i)).intValue() & 0xFFFFFFFF);
            localayuo.jdField_a_of_type_Int = ((Integer)((List)localObject2).get(i)).intValue();
            ((ayzi)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localayuo);
            i += 1;
            continue;
          }
          if ((paramaytj.rpt_msg_down_ip6.has()) && (paramaytj.rpt_msg_down_ip6.size() > 0))
          {
            localList = paramaytj.rpt_msg_down_ip6.get();
            i = 0;
            if (i < localList.size())
            {
              localObject2 = new ayuo();
              ((ayuo)localObject2).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x388.IPv6Info)localList.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
              ((ayuo)localObject2).jdField_a_of_type_Int = ((cmd0x388.IPv6Info)localList.get(i)).uint32_port.get();
              ((ayuo)localObject2).jdField_a_of_type_Boolean = true;
              ((ayzi)localObject1).jdField_b_of_type_JavaUtilArrayList.add(i, localObject2);
              i += 1;
              continue;
            }
          }
          if (paramaytj.rpt_str_domain.has()) {
            ((ayzi)localObject1).jdField_b_of_type_JavaLangString = paramaytj.rpt_str_domain.get();
          }
          a(0, 0, "", "", localakaw, (ayzp)localObject1);
        }
        catch (Exception paramaytj) {}
      }
      catch (Exception paramaytj)
      {
        localObject1 = null;
        continue;
      }
      a(-1, -9527, ayoz.a("P", -9529L), paramaytj.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakaw, (ayzp)localObject1);
      continue;
      break;
      label714:
      if (paramaytj.uint32_allow_retry.get() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.BaseHandler", 2, "onProtoResp :group ptt server not allow retry");
        }
        ((ayzi)localObject1).e = false;
      }
      if (ayyf.a(i))
      {
        this.b += 1;
        if (this.b < 2)
        {
          localayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramayti);
          return;
        }
      }
      a(-1, -9527, ayoz.a(i), "", localakaw, (ayzp)localObject1);
    }
  }
  
  public void a(ayyn paramayyn)
  {
    if ((paramayyn != null) && (paramayyn.jdField_a_of_type_JavaUtilList != null) && (paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ayti localayti = new ayti();
      localayti.jdField_a_of_type_JavaLangString = "PttStore.GroupPttDown";
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
    localReqBody.uint32_subcmd.set(4);
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
      ayzi localayzi = new ayzi();
      localayzc.jdField_a_of_type_JavaUtilList.add(i, localayzi);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyg
 * JD-Core Version:    0.7.0.1
 */