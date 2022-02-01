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

public class bebn
  extends bebf
{
  void a(int paramInt, becg parambecg, cmd0x388.ReqBody paramReqBody)
  {
    parambecg = (becf)parambecg;
    cmd0x388.TryUpPttReq localTryUpPttReq = new cmd0x388.TryUpPttReq();
    localTryUpPttReq.setHasFlag(true);
    localTryUpPttReq.uint64_src_uin.set(Long.valueOf(parambecg.jdField_c_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_group_code.set(Long.valueOf(parambecg.jdField_d_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_file_id.set(paramInt);
    localTryUpPttReq.uint64_file_size.set(parambecg.b);
    localTryUpPttReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambecg.jdField_a_of_type_ArrayOfByte));
    localTryUpPttReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(parambecg.jdField_a_of_type_JavaLangString));
    localTryUpPttReq.uint32_src_term.set(5);
    localTryUpPttReq.uint32_platform_type.set(9);
    PBUInt32Field localPBUInt32Field = localTryUpPttReq.uint32_bu_type;
    if (parambecg.f == 1) {}
    for (paramInt = 3;; paramInt = 4)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(bdxz.a()));
      localTryUpPttReq.uint32_voice_length.set(parambecg.jdField_a_of_type_Int);
      localTryUpPttReq.uint32_codec.set(parambecg.jdField_c_of_type_Int);
      localTryUpPttReq.uint32_voice_type.set(parambecg.jdField_d_of_type_Int);
      localTryUpPttReq.bool_new_up_chan.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "GroupPttUp: panel[" + parambecg.jdField_d_of_type_Int + "] type[" + parambecg.jdField_c_of_type_Int + "] length[" + parambecg.jdField_a_of_type_Int + "] size[" + parambecg.b + "]");
      }
      paramReqBody.rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
      return;
    }
  }
  
  public void a(bdxf parambdxf, bdxe parambdxe)
  {
    FromServiceMsg localFromServiceMsg = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bebv localbebv = (bebv)parambdxe.jdField_a_of_type_JavaLangObject;
    beck localbeck = localbebv.jdField_a_of_type_Beck;
    anqe localanqe = parambdxf.jdField_a_of_type_Anqe;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        parambdxe = localFromServiceMsg.getBusinessFailMsg();
        parambdxf = parambdxe;
        if (parambdxe == null) {
          parambdxf = "";
        }
        a(-1, 9311, (String)localObject1, parambdxf, localanqe, localbeck.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      bedb.a(localbebv, localbeck);
      return;
      localObject1 = MessageHandler.a(localFromServiceMsg);
      parambdxe = localFromServiceMsg.getBusinessFailMsg();
      parambdxf = parambdxe;
      if (parambdxe == null) {
        parambdxf = "";
      }
      a(-1, 9044, (String)localObject1, parambdxf, localanqe, localbeck.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        parambdxf = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_ptt_rsp.get();
        if ((parambdxf != null) && (parambdxf.size() != 0)) {
          break label264;
        }
        throw new Exception("resps null");
      }
      catch (Exception parambdxf)
      {
        a(-1, -9527, bdsx.a("P", -9529L), parambdxf.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localanqe, localbeck.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label264:
      Iterator localIterator = parambdxf.iterator();
      while (localIterator.hasNext())
      {
        parambdxf = (cmd0x388.TryUpPttRsp)localIterator.next();
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject1 = (becr)localbeck.jdField_a_of_type_JavaUtilList.get((int)parambdxf.uint64_file_id.get());
              try
              {
                ((becr)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
                if (QLog.isColorLevel()) {
                  QLog.e("http_sideway", 2, "GroupPttUpHandler.onProtoResp:isSendByQuickHttp=" + ((becr)localObject1).d);
                }
                i = parambdxf.uint32_result.get();
                if (i != 0) {
                  break label745;
                }
                ((becr)localObject1).jdField_a_of_type_Long = parambdxf.uint64_fileid.get();
                if (parambdxf.bytes_file_key.has()) {
                  ((becr)localObject1).jdField_a_of_type_ArrayOfByte = parambdxf.bytes_file_key.get().toByteArray();
                }
                if ((!parambdxf.bool_file_exit.has()) || (!parambdxf.bool_file_exit.get())) {
                  break label524;
                }
                ((becr)localObject1).jdField_a_of_type_Boolean = true;
                a(0, 0, "", "", localanqe, (becx)localObject1);
              }
              catch (Exception parambdxf) {}
            }
          }
          catch (Exception parambdxf)
          {
            label524:
            List localList;
            Object localObject2;
            long l1;
            long l2;
            bdyf localbdyf;
            localObject1 = null;
            continue;
          }
          a(-1, -9527, bdsx.a("P", -9529L), parambdxf.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localanqe, (becx)localObject1);
          break;
          localList = parambdxf.rpt_uint32_up_ip.get();
          localObject2 = parambdxf.rpt_uint32_up_port.get();
          if ((localList != null) && (localList.size() > 0))
          {
            i = 0;
            if (i < localList.size())
            {
              l1 = ((Integer)localList.get(i)).intValue();
              l2 = ((Integer)((List)localObject2).get(i)).intValue();
              localbdyf = new bdyf();
              localbdyf.jdField_a_of_type_JavaLangString = bgva.a(l1 & 0xFFFFFFFF);
              localbdyf.jdField_a_of_type_Int = ((int)l2);
              ((becr)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localbdyf);
              i += 1;
              continue;
            }
          }
          localObject2 = HexUtil.bytes2HexStr(parambdxf.bytes_up_ukey.get().toByteArray());
          if ((localObject2 == null) || (((String)localObject2).equals("")) || (localList == null) || (localList.size() == 0)) {
            throw new Exception("check ukey,iplist");
          }
          ((becr)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
          ((becr)localObject1).jdField_a_of_type_Int = ((int)parambdxf.uint64_block_size.get());
          ((becr)localObject1).b = ((int)parambdxf.uint64_up_offset.get());
        }
        label745:
        if (bebl.a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambdxe);
            return;
          }
        }
        a(-1, -9527, bdsx.a(i), "", localanqe, (becx)localObject1);
      }
    }
  }
  
  public void a(bebv parambebv)
  {
    if ((parambebv != null) && (parambebv.jdField_a_of_type_JavaUtilList != null) && (parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bdxe localbdxe = new bdxe();
      localbdxe.jdField_a_of_type_JavaLangString = "PttStore.GroupPttUp";
      localbdxe.jdField_a_of_type_ArrayOfByte = a(parambebv.jdField_a_of_type_JavaUtilList);
      localbdxe.jdField_a_of_type_JavaLangObject = parambebv;
      localbdxe.jdField_a_of_type_Bdxd = this;
      a(parambebv, localbdxe);
    }
  }
  
  byte[] a(List<becg> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(3);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (becg)paramList.get(i), localReqBody);
      i += 1;
    }
    i = a();
    localReqBody.uint32_net_type.set(i);
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "GroupPttUp: net[" + i + "]");
    }
    return localReqBody.toByteArray();
  }
  
  void b(bebv parambebv)
  {
    beck localbeck = parambebv.jdField_a_of_type_Beck;
    localbeck.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambebv.jdField_a_of_type_JavaUtilList.size())
    {
      becr localbecr = new becr();
      localbeck.jdField_a_of_type_JavaUtilList.add(i, localbecr);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebn
 * JD-Core Version:    0.7.0.1
 */