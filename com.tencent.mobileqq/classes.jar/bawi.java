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

public class bawi
  extends bawa
{
  void a(int paramInt, bawz parambawz, cmd0x388.ReqBody paramReqBody)
  {
    parambawz = (bawy)parambawz;
    cmd0x388.TryUpPttReq localTryUpPttReq = new cmd0x388.TryUpPttReq();
    localTryUpPttReq.setHasFlag(true);
    localTryUpPttReq.uint64_src_uin.set(Long.valueOf(parambawz.jdField_c_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_group_code.set(Long.valueOf(parambawz.jdField_d_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_file_id.set(paramInt);
    localTryUpPttReq.uint64_file_size.set(parambawz.b);
    localTryUpPttReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambawz.jdField_a_of_type_ArrayOfByte));
    localTryUpPttReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(parambawz.jdField_a_of_type_JavaLangString));
    localTryUpPttReq.uint32_src_term.set(5);
    localTryUpPttReq.uint32_platform_type.set(9);
    PBUInt32Field localPBUInt32Field = localTryUpPttReq.uint32_bu_type;
    if (parambawz.f == 1) {}
    for (paramInt = 3;; paramInt = 4)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(basj.a()));
      localTryUpPttReq.uint32_voice_length.set(parambawz.jdField_a_of_type_Int);
      localTryUpPttReq.uint32_codec.set(parambawz.jdField_c_of_type_Int);
      localTryUpPttReq.uint32_voice_type.set(parambawz.jdField_d_of_type_Int);
      localTryUpPttReq.bool_new_up_chan.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "GroupPttUp: panel[" + parambawz.jdField_d_of_type_Int + "] type[" + parambawz.jdField_c_of_type_Int + "] length[" + parambawz.jdField_a_of_type_Int + "] size[" + parambawz.b + "]");
      }
      paramReqBody.rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
      return;
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
        parambari = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_ptt_rsp.get();
        if ((parambari != null) && (parambari.size() != 0)) {
          break label264;
        }
        throw new Exception("resps null");
      }
      catch (Exception parambari)
      {
        a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label264:
      Iterator localIterator = parambari.iterator();
      while (localIterator.hasNext())
      {
        parambari = (cmd0x388.TryUpPttRsp)localIterator.next();
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject1 = (baxk)localbaxd.jdField_a_of_type_JavaUtilList.get((int)parambari.uint64_file_id.get());
              try
              {
                ((baxk)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
                if (QLog.isColorLevel()) {
                  QLog.e("http_sideway", 2, "GroupPttUpHandler.onProtoResp:isSendByQuickHttp=" + ((baxk)localObject1).d);
                }
                i = parambari.uint32_result.get();
                if (i != 0) {
                  break label745;
                }
                ((baxk)localObject1).jdField_a_of_type_Long = parambari.uint64_fileid.get();
                if (parambari.bytes_file_key.has()) {
                  ((baxk)localObject1).jdField_a_of_type_ArrayOfByte = parambari.bytes_file_key.get().toByteArray();
                }
                if ((!parambari.bool_file_exit.has()) || (!parambari.bool_file_exit.get())) {
                  break label524;
                }
                ((baxk)localObject1).jdField_a_of_type_Boolean = true;
                a(0, 0, "", "", localalsj, (baxq)localObject1);
              }
              catch (Exception parambari) {}
            }
          }
          catch (Exception parambari)
          {
            label524:
            List localList;
            Object localObject2;
            long l1;
            long l2;
            basp localbasp;
            localObject1 = null;
            continue;
          }
          a(-1, -9527, bamw.a("P", -9529L), parambari.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalsj, (baxq)localObject1);
          break;
          localList = parambari.rpt_uint32_up_ip.get();
          localObject2 = parambari.rpt_uint32_up_port.get();
          if ((localList != null) && (localList.size() > 0))
          {
            i = 0;
            if (i < localList.size())
            {
              l1 = ((Integer)localList.get(i)).intValue();
              l2 = ((Integer)((List)localObject2).get(i)).intValue();
              localbasp = new basp();
              localbasp.jdField_a_of_type_JavaLangString = bdlr.a(l1 & 0xFFFFFFFF);
              localbasp.jdField_a_of_type_Int = ((int)l2);
              ((baxk)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localbasp);
              i += 1;
              continue;
            }
          }
          localObject2 = HexUtil.bytes2HexStr(parambari.bytes_up_ukey.get().toByteArray());
          if ((localObject2 == null) || (((String)localObject2).equals("")) || (localList == null) || (localList.size() == 0)) {
            throw new Exception("check ukey,iplist");
          }
          ((baxk)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
          ((baxk)localObject1).jdField_a_of_type_Int = ((int)parambari.uint64_block_size.get());
          ((baxk)localObject1).b = ((int)parambari.uint64_up_offset.get());
        }
        label745:
        if (bawg.a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localbawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambarh);
            return;
          }
        }
        a(-1, -9527, bamw.a(i), "", localalsj, (baxq)localObject1);
      }
    }
  }
  
  public void a(bawo parambawo)
  {
    if ((parambawo != null) && (parambawo.jdField_a_of_type_JavaUtilList != null) && (parambawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      barh localbarh = new barh();
      localbarh.jdField_a_of_type_JavaLangString = "PttStore.GroupPttUp";
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
    localReqBody.uint32_subcmd.set(3);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (bawz)paramList.get(i), localReqBody);
      i += 1;
    }
    i = a();
    localReqBody.uint32_net_type.set(i);
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "GroupPttUp: net[" + i + "]");
    }
    return localReqBody.toByteArray();
  }
  
  void b(bawo parambawo)
  {
    baxd localbaxd = parambawo.jdField_a_of_type_Baxd;
    localbaxd.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambawo.jdField_a_of_type_JavaUtilList.size())
    {
      baxk localbaxk = new baxk();
      localbaxd.jdField_a_of_type_JavaUtilList.add(i, localbaxk);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawi
 * JD-Core Version:    0.7.0.1
 */