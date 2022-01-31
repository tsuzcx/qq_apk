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

public class bbar
  extends bbaj
{
  void a(int paramInt, bbbi parambbbi, cmd0x388.ReqBody paramReqBody)
  {
    parambbbi = (bbbh)parambbbi;
    cmd0x388.TryUpPttReq localTryUpPttReq = new cmd0x388.TryUpPttReq();
    localTryUpPttReq.setHasFlag(true);
    localTryUpPttReq.uint64_src_uin.set(Long.valueOf(parambbbi.jdField_c_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_group_code.set(Long.valueOf(parambbbi.jdField_d_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_file_id.set(paramInt);
    localTryUpPttReq.uint64_file_size.set(parambbbi.b);
    localTryUpPttReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambbbi.jdField_a_of_type_ArrayOfByte));
    localTryUpPttReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(parambbbi.jdField_a_of_type_JavaLangString));
    localTryUpPttReq.uint32_src_term.set(5);
    localTryUpPttReq.uint32_platform_type.set(9);
    PBUInt32Field localPBUInt32Field = localTryUpPttReq.uint32_bu_type;
    if (parambbbi.f == 1) {}
    for (paramInt = 3;; paramInt = 4)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(baws.a()));
      localTryUpPttReq.uint32_voice_length.set(parambbbi.jdField_a_of_type_Int);
      localTryUpPttReq.uint32_codec.set(parambbbi.jdField_c_of_type_Int);
      localTryUpPttReq.uint32_voice_type.set(parambbbi.jdField_d_of_type_Int);
      localTryUpPttReq.bool_new_up_chan.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "GroupPttUp: panel[" + parambbbi.jdField_d_of_type_Int + "] type[" + parambbbi.jdField_c_of_type_Int + "] length[" + parambbbi.jdField_a_of_type_Int + "] size[" + parambbbi.b + "]");
      }
      paramReqBody.rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
      return;
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
        parambavr = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_ptt_rsp.get();
        if ((parambavr != null) && (parambavr.size() != 0)) {
          break label264;
        }
        throw new Exception("resps null");
      }
      catch (Exception parambavr)
      {
        a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label264:
      Iterator localIterator = parambavr.iterator();
      while (localIterator.hasNext())
      {
        parambavr = (cmd0x388.TryUpPttRsp)localIterator.next();
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject1 = (bbbt)localbbbm.jdField_a_of_type_JavaUtilList.get((int)parambavr.uint64_file_id.get());
              try
              {
                ((bbbt)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
                if (QLog.isColorLevel()) {
                  QLog.e("http_sideway", 2, "GroupPttUpHandler.onProtoResp:isSendByQuickHttp=" + ((bbbt)localObject1).d);
                }
                i = parambavr.uint32_result.get();
                if (i != 0) {
                  break label745;
                }
                ((bbbt)localObject1).jdField_a_of_type_Long = parambavr.uint64_fileid.get();
                if (parambavr.bytes_file_key.has()) {
                  ((bbbt)localObject1).jdField_a_of_type_ArrayOfByte = parambavr.bytes_file_key.get().toByteArray();
                }
                if ((!parambavr.bool_file_exit.has()) || (!parambavr.bool_file_exit.get())) {
                  break label524;
                }
                ((bbbt)localObject1).jdField_a_of_type_Boolean = true;
                a(0, 0, "", "", localalwy, (bbbz)localObject1);
              }
              catch (Exception parambavr) {}
            }
          }
          catch (Exception parambavr)
          {
            label524:
            List localList;
            Object localObject2;
            long l1;
            long l2;
            bawy localbawy;
            localObject1 = null;
            continue;
          }
          a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalwy, (bbbz)localObject1);
          break;
          localList = parambavr.rpt_uint32_up_ip.get();
          localObject2 = parambavr.rpt_uint32_up_port.get();
          if ((localList != null) && (localList.size() > 0))
          {
            i = 0;
            if (i < localList.size())
            {
              l1 = ((Integer)localList.get(i)).intValue();
              l2 = ((Integer)((List)localObject2).get(i)).intValue();
              localbawy = new bawy();
              localbawy.jdField_a_of_type_JavaLangString = bdqa.a(l1 & 0xFFFFFFFF);
              localbawy.jdField_a_of_type_Int = ((int)l2);
              ((bbbt)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localbawy);
              i += 1;
              continue;
            }
          }
          localObject2 = HexUtil.bytes2HexStr(parambavr.bytes_up_ukey.get().toByteArray());
          if ((localObject2 == null) || (((String)localObject2).equals("")) || (localList == null) || (localList.size() == 0)) {
            throw new Exception("check ukey,iplist");
          }
          ((bbbt)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
          ((bbbt)localObject1).jdField_a_of_type_Int = ((int)parambavr.uint64_block_size.get());
          ((bbbt)localObject1).b = ((int)parambavr.uint64_up_offset.get());
        }
        label745:
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
  }
  
  public void a(bbax parambbax)
  {
    if ((parambbax != null) && (parambbax.jdField_a_of_type_JavaUtilList != null) && (parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bavq localbavq = new bavq();
      localbavq.jdField_a_of_type_JavaLangString = "PttStore.GroupPttUp";
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
    localReqBody.uint32_subcmd.set(3);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (bbbi)paramList.get(i), localReqBody);
      i += 1;
    }
    i = a();
    localReqBody.uint32_net_type.set(i);
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "GroupPttUp: net[" + i + "]");
    }
    return localReqBody.toByteArray();
  }
  
  void b(bbax parambbax)
  {
    bbbm localbbbm = parambbax.jdField_a_of_type_Bbbm;
    localbbbm.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambbax.jdField_a_of_type_JavaUtilList.size())
    {
      bbbt localbbbt = new bbbt();
      localbbbm.jdField_a_of_type_JavaUtilList.add(i, localbbbt);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbar
 * JD-Core Version:    0.7.0.1
 */