import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
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
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpPttReq;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpPttRsp;

public class ayyh
  extends ayxz
{
  void a(int paramInt, ayyy paramayyy, cmd0x388.ReqBody paramReqBody)
  {
    paramayyy = (ayyx)paramayyy;
    cmd0x388.TryUpPttReq localTryUpPttReq = new cmd0x388.TryUpPttReq();
    localTryUpPttReq.setHasFlag(true);
    localTryUpPttReq.uint64_src_uin.set(Long.valueOf(paramayyy.jdField_c_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_group_code.set(Long.valueOf(paramayyy.jdField_d_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_file_id.set(paramInt);
    localTryUpPttReq.uint64_file_size.set(paramayyy.b);
    localTryUpPttReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramayyy.jdField_a_of_type_ArrayOfByte));
    localTryUpPttReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramayyy.jdField_a_of_type_JavaLangString));
    localTryUpPttReq.uint32_src_term.set(5);
    localTryUpPttReq.uint32_platform_type.set(9);
    PBUInt32Field localPBUInt32Field = localTryUpPttReq.uint32_bu_type;
    if (paramayyy.f == 1) {}
    for (paramInt = 3;; paramInt = 4)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(ayui.a()));
      localTryUpPttReq.uint32_voice_length.set(paramayyy.jdField_a_of_type_Int);
      localTryUpPttReq.uint32_codec.set(paramayyy.jdField_c_of_type_Int);
      localTryUpPttReq.uint32_voice_type.set(paramayyy.jdField_d_of_type_Int);
      localTryUpPttReq.bool_new_up_chan.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "GroupPttUp: panel[" + paramayyy.jdField_d_of_type_Int + "] type[" + paramayyy.jdField_c_of_type_Int + "] length[" + paramayyy.jdField_a_of_type_Int + "] size[" + paramayyy.b + "]");
      }
      paramReqBody.rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
      return;
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
        paramaytj = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_ptt_rsp.get();
        if ((paramaytj != null) && (paramaytj.size() != 0)) {
          break label264;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramaytj)
      {
        a(-1, -9527, ayoz.a("P", -9529L), paramaytj.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakaw, localayzc.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label264:
      Iterator localIterator = paramaytj.iterator();
      while (localIterator.hasNext())
      {
        paramaytj = (cmd0x388.TryUpPttRsp)localIterator.next();
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject1 = (ayzj)localayzc.jdField_a_of_type_JavaUtilList.get((int)paramaytj.uint64_file_id.get());
              try
              {
                ((ayzj)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
                if (QLog.isColorLevel()) {
                  QLog.e("http_sideway", 2, "GroupPttUpHandler.onProtoResp:isSendByQuickHttp=" + ((ayzj)localObject1).d);
                }
                i = paramaytj.uint32_result.get();
                if (i != 0) {
                  break label745;
                }
                ((ayzj)localObject1).jdField_a_of_type_Long = paramaytj.uint64_fileid.get();
                if (paramaytj.bytes_file_key.has()) {
                  ((ayzj)localObject1).jdField_a_of_type_ArrayOfByte = paramaytj.bytes_file_key.get().toByteArray();
                }
                if ((!paramaytj.bool_file_exit.has()) || (!paramaytj.bool_file_exit.get())) {
                  break label524;
                }
                ((ayzj)localObject1).jdField_a_of_type_Boolean = true;
                a(0, 0, "", "", localakaw, (ayzp)localObject1);
              }
              catch (Exception paramaytj) {}
            }
          }
          catch (Exception paramaytj)
          {
            label524:
            List localList;
            Object localObject2;
            long l1;
            long l2;
            ayuo localayuo;
            localObject1 = null;
            continue;
          }
          a(-1, -9527, ayoz.a("P", -9529L), paramaytj.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakaw, (ayzp)localObject1);
          break;
          localList = paramaytj.rpt_uint32_up_ip.get();
          localObject2 = paramaytj.rpt_uint32_up_port.get();
          if ((localList != null) && (localList.size() > 0))
          {
            i = 0;
            if (i < localList.size())
            {
              l1 = ((Integer)localList.get(i)).intValue();
              l2 = ((Integer)((List)localObject2).get(i)).intValue();
              localayuo = new ayuo();
              localayuo.jdField_a_of_type_JavaLangString = bbmj.a(l1 & 0xFFFFFFFF);
              localayuo.jdField_a_of_type_Int = ((int)l2);
              ((ayzj)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localayuo);
              i += 1;
              continue;
            }
          }
          localObject2 = HexUtil.bytes2HexStr(paramaytj.bytes_up_ukey.get().toByteArray());
          if ((localObject2 == null) || (((String)localObject2).equals("")) || (localList == null) || (localList.size() == 0)) {
            throw new Exception("check ukey,iplist");
          }
          ((ayzj)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
          ((ayzj)localObject1).jdField_a_of_type_Int = ((int)paramaytj.uint64_block_size.get());
          ((ayzj)localObject1).b = ((int)paramaytj.uint64_up_offset.get());
        }
        label745:
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
  }
  
  public void a(ayyn paramayyn)
  {
    if ((paramayyn != null) && (paramayyn.jdField_a_of_type_JavaUtilList != null) && (paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ayti localayti = new ayti();
      localayti.jdField_a_of_type_JavaLangString = "PttStore.GroupPttUp";
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
    localReqBody.uint32_subcmd.set(3);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (ayyy)paramList.get(i), localReqBody);
      i += 1;
    }
    i = a();
    localReqBody.uint32_net_type.set(i);
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "GroupPttUp: net[" + i + "]");
    }
    return localReqBody.toByteArray();
  }
  
  void b(ayyn paramayyn)
  {
    ayzc localayzc = paramayyn.jdField_a_of_type_Ayzc;
    localayzc.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramayyn.jdField_a_of_type_JavaUtilList.size())
    {
      ayzj localayzj = new ayzj();
      localayzc.jdField_a_of_type_JavaUtilList.add(i, localayzj);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyh
 * JD-Core Version:    0.7.0.1
 */