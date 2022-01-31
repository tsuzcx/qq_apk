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

public class axya
  extends axxs
{
  void a(int paramInt, axyr paramaxyr, cmd0x388.ReqBody paramReqBody)
  {
    paramaxyr = (axyq)paramaxyr;
    cmd0x388.TryUpPttReq localTryUpPttReq = new cmd0x388.TryUpPttReq();
    localTryUpPttReq.setHasFlag(true);
    localTryUpPttReq.uint64_src_uin.set(Long.valueOf(paramaxyr.jdField_c_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_group_code.set(Long.valueOf(paramaxyr.jdField_d_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_file_id.set(paramInt);
    localTryUpPttReq.uint64_file_size.set(paramaxyr.b);
    localTryUpPttReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramaxyr.jdField_a_of_type_ArrayOfByte));
    localTryUpPttReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramaxyr.jdField_a_of_type_JavaLangString));
    localTryUpPttReq.uint32_src_term.set(5);
    localTryUpPttReq.uint32_platform_type.set(9);
    PBUInt32Field localPBUInt32Field = localTryUpPttReq.uint32_bu_type;
    if (paramaxyr.f == 1) {}
    for (paramInt = 3;; paramInt = 4)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(axub.a()));
      localTryUpPttReq.uint32_voice_length.set(paramaxyr.jdField_a_of_type_Int);
      localTryUpPttReq.uint32_codec.set(paramaxyr.jdField_c_of_type_Int);
      localTryUpPttReq.uint32_voice_type.set(paramaxyr.jdField_d_of_type_Int);
      localTryUpPttReq.bool_new_up_chan.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "GroupPttUp: panel[" + paramaxyr.jdField_d_of_type_Int + "] type[" + paramaxyr.jdField_c_of_type_Int + "] length[" + paramaxyr.jdField_a_of_type_Int + "] size[" + paramaxyr.b + "]");
      }
      paramReqBody.rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
      return;
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
        paramaxtc = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_ptt_rsp.get();
        if ((paramaxtc != null) && (paramaxtc.size() != 0)) {
          break label264;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramaxtc)
      {
        a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label264:
      Iterator localIterator = paramaxtc.iterator();
      while (localIterator.hasNext())
      {
        paramaxtc = (cmd0x388.TryUpPttRsp)localIterator.next();
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject1 = (axzc)localaxyv.jdField_a_of_type_JavaUtilList.get((int)paramaxtc.uint64_file_id.get());
              try
              {
                ((axzc)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
                if (QLog.isColorLevel()) {
                  QLog.e("http_sideway", 2, "GroupPttUpHandler.onProtoResp:isSendByQuickHttp=" + ((axzc)localObject1).d);
                }
                i = paramaxtc.uint32_result.get();
                if (i != 0) {
                  break label745;
                }
                ((axzc)localObject1).jdField_a_of_type_Long = paramaxtc.uint64_fileid.get();
                if (paramaxtc.bytes_file_key.has()) {
                  ((axzc)localObject1).jdField_a_of_type_ArrayOfByte = paramaxtc.bytes_file_key.get().toByteArray();
                }
                if ((!paramaxtc.bool_file_exit.has()) || (!paramaxtc.bool_file_exit.get())) {
                  break label524;
                }
                ((axzc)localObject1).jdField_a_of_type_Boolean = true;
                a(0, 0, "", "", localajmn, (axzi)localObject1);
              }
              catch (Exception paramaxtc) {}
            }
          }
          catch (Exception paramaxtc)
          {
            label524:
            List localList;
            Object localObject2;
            long l1;
            long l2;
            axuh localaxuh;
            localObject1 = null;
            continue;
          }
          a(-1, -9527, axou.a("P", -9529L), paramaxtc.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localajmn, (axzi)localObject1);
          break;
          localList = paramaxtc.rpt_uint32_up_ip.get();
          localObject2 = paramaxtc.rpt_uint32_up_port.get();
          if ((localList != null) && (localList.size() > 0))
          {
            i = 0;
            if (i < localList.size())
            {
              l1 = ((Integer)localList.get(i)).intValue();
              l2 = ((Integer)((List)localObject2).get(i)).intValue();
              localaxuh = new axuh();
              localaxuh.jdField_a_of_type_JavaLangString = bakz.a(l1 & 0xFFFFFFFF);
              localaxuh.jdField_a_of_type_Int = ((int)l2);
              ((axzc)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localaxuh);
              i += 1;
              continue;
            }
          }
          localObject2 = HexUtil.bytes2HexStr(paramaxtc.bytes_up_ukey.get().toByteArray());
          if ((localObject2 == null) || (((String)localObject2).equals("")) || (localList == null) || (localList.size() == 0)) {
            throw new Exception("check ukey,iplist");
          }
          ((axzc)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
          ((axzc)localObject1).jdField_a_of_type_Int = ((int)paramaxtc.uint64_block_size.get());
          ((axzc)localObject1).b = ((int)paramaxtc.uint64_up_offset.get());
        }
        label745:
        if (axxy.a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramaxtb);
            return;
          }
        }
        a(-1, -9527, axou.a(i), "", localajmn, (axzi)localObject1);
      }
    }
  }
  
  public void a(axyg paramaxyg)
  {
    if ((paramaxyg != null) && (paramaxyg.jdField_a_of_type_JavaUtilList != null) && (paramaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      axtb localaxtb = new axtb();
      localaxtb.jdField_a_of_type_JavaLangString = "PttStore.GroupPttUp";
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
    localReqBody.uint32_subcmd.set(3);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (axyr)paramList.get(i), localReqBody);
      i += 1;
    }
    i = a();
    localReqBody.uint32_net_type.set(i);
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "GroupPttUp: net[" + i + "]");
    }
    return localReqBody.toByteArray();
  }
  
  void b(axyg paramaxyg)
  {
    axyv localaxyv = paramaxyg.jdField_a_of_type_Axyv;
    localaxyv.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramaxyg.jdField_a_of_type_JavaUtilList.size())
    {
      axzc localaxzc = new axzc();
      localaxyv.jdField_a_of_type_JavaUtilList.add(i, localaxzc);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axya
 * JD-Core Version:    0.7.0.1
 */