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

public class ayyj
  extends ayyb
{
  void a(int paramInt, ayza paramayza, cmd0x388.ReqBody paramReqBody)
  {
    paramayza = (ayyz)paramayza;
    cmd0x388.TryUpPttReq localTryUpPttReq = new cmd0x388.TryUpPttReq();
    localTryUpPttReq.setHasFlag(true);
    localTryUpPttReq.uint64_src_uin.set(Long.valueOf(paramayza.jdField_c_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_group_code.set(Long.valueOf(paramayza.jdField_d_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_file_id.set(paramInt);
    localTryUpPttReq.uint64_file_size.set(paramayza.b);
    localTryUpPttReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramayza.jdField_a_of_type_ArrayOfByte));
    localTryUpPttReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramayza.jdField_a_of_type_JavaLangString));
    localTryUpPttReq.uint32_src_term.set(5);
    localTryUpPttReq.uint32_platform_type.set(9);
    PBUInt32Field localPBUInt32Field = localTryUpPttReq.uint32_bu_type;
    if (paramayza.f == 1) {}
    for (paramInt = 3;; paramInt = 4)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(ayuk.a()));
      localTryUpPttReq.uint32_voice_length.set(paramayza.jdField_a_of_type_Int);
      localTryUpPttReq.uint32_codec.set(paramayza.jdField_c_of_type_Int);
      localTryUpPttReq.uint32_voice_type.set(paramayza.jdField_d_of_type_Int);
      localTryUpPttReq.bool_new_up_chan.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "GroupPttUp: panel[" + paramayza.jdField_d_of_type_Int + "] type[" + paramayza.jdField_c_of_type_Int + "] length[" + paramayza.jdField_a_of_type_Int + "] size[" + paramayza.b + "]");
      }
      paramReqBody.rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
      return;
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
        paramaytl = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_ptt_rsp.get();
        if ((paramaytl != null) && (paramaytl.size() != 0)) {
          break label264;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramaytl)
      {
        a(-1, -9527, aypb.a("P", -9529L), paramaytl.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakau, localayze.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label264:
      Iterator localIterator = paramaytl.iterator();
      while (localIterator.hasNext())
      {
        paramaytl = (cmd0x388.TryUpPttRsp)localIterator.next();
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject1 = (ayzl)localayze.jdField_a_of_type_JavaUtilList.get((int)paramaytl.uint64_file_id.get());
              try
              {
                ((ayzl)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
                if (QLog.isColorLevel()) {
                  QLog.e("http_sideway", 2, "GroupPttUpHandler.onProtoResp:isSendByQuickHttp=" + ((ayzl)localObject1).d);
                }
                i = paramaytl.uint32_result.get();
                if (i != 0) {
                  break label745;
                }
                ((ayzl)localObject1).jdField_a_of_type_Long = paramaytl.uint64_fileid.get();
                if (paramaytl.bytes_file_key.has()) {
                  ((ayzl)localObject1).jdField_a_of_type_ArrayOfByte = paramaytl.bytes_file_key.get().toByteArray();
                }
                if ((!paramaytl.bool_file_exit.has()) || (!paramaytl.bool_file_exit.get())) {
                  break label524;
                }
                ((ayzl)localObject1).jdField_a_of_type_Boolean = true;
                a(0, 0, "", "", localakau, (ayzr)localObject1);
              }
              catch (Exception paramaytl) {}
            }
          }
          catch (Exception paramaytl)
          {
            label524:
            List localList;
            Object localObject2;
            long l1;
            long l2;
            ayuq localayuq;
            localObject1 = null;
            continue;
          }
          a(-1, -9527, aypb.a("P", -9529L), paramaytl.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localakau, (ayzr)localObject1);
          break;
          localList = paramaytl.rpt_uint32_up_ip.get();
          localObject2 = paramaytl.rpt_uint32_up_port.get();
          if ((localList != null) && (localList.size() > 0))
          {
            i = 0;
            if (i < localList.size())
            {
              l1 = ((Integer)localList.get(i)).intValue();
              l2 = ((Integer)((List)localObject2).get(i)).intValue();
              localayuq = new ayuq();
              localayuq.jdField_a_of_type_JavaLangString = bbmx.a(l1 & 0xFFFFFFFF);
              localayuq.jdField_a_of_type_Int = ((int)l2);
              ((ayzl)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localayuq);
              i += 1;
              continue;
            }
          }
          localObject2 = HexUtil.bytes2HexStr(paramaytl.bytes_up_ukey.get().toByteArray());
          if ((localObject2 == null) || (((String)localObject2).equals("")) || (localList == null) || (localList.size() == 0)) {
            throw new Exception("check ukey,iplist");
          }
          ((ayzl)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
          ((ayzl)localObject1).jdField_a_of_type_Int = ((int)paramaytl.uint64_block_size.get());
          ((ayzl)localObject1).b = ((int)paramaytl.uint64_up_offset.get());
        }
        label745:
        if (ayyh.a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramaytk);
            return;
          }
        }
        a(-1, -9527, aypb.a(i), "", localakau, (ayzr)localObject1);
      }
    }
  }
  
  public void a(ayyp paramayyp)
  {
    if ((paramayyp != null) && (paramayyp.jdField_a_of_type_JavaUtilList != null) && (paramayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      aytk localaytk = new aytk();
      localaytk.jdField_a_of_type_JavaLangString = "PttStore.GroupPttUp";
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
    localReqBody.uint32_subcmd.set(3);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (ayza)paramList.get(i), localReqBody);
      i += 1;
    }
    i = a();
    localReqBody.uint32_net_type.set(i);
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "GroupPttUp: net[" + i + "]");
    }
    return localReqBody.toByteArray();
  }
  
  void b(ayyp paramayyp)
  {
    ayze localayze = paramayyp.jdField_a_of_type_Ayze;
    localayze.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramayyp.jdField_a_of_type_JavaUtilList.size())
    {
      ayzl localayzl = new ayzl();
      localayze.jdField_a_of_type_JavaUtilList.add(i, localayzl);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyj
 * JD-Core Version:    0.7.0.1
 */