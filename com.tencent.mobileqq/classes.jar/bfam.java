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

public class bfam
  extends bfae
{
  void a(int paramInt, bfbf parambfbf, cmd0x388.ReqBody paramReqBody)
  {
    parambfbf = (bfbe)parambfbf;
    cmd0x388.TryUpPttReq localTryUpPttReq = new cmd0x388.TryUpPttReq();
    localTryUpPttReq.setHasFlag(true);
    localTryUpPttReq.uint64_src_uin.set(Long.valueOf(parambfbf.jdField_c_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_group_code.set(Long.valueOf(parambfbf.jdField_d_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_file_id.set(paramInt);
    localTryUpPttReq.uint64_file_size.set(parambfbf.b);
    localTryUpPttReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambfbf.jdField_a_of_type_ArrayOfByte));
    localTryUpPttReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(parambfbf.jdField_a_of_type_JavaLangString));
    localTryUpPttReq.uint32_src_term.set(5);
    localTryUpPttReq.uint32_platform_type.set(9);
    PBUInt32Field localPBUInt32Field = localTryUpPttReq.uint32_bu_type;
    if (parambfbf.f == 1) {}
    for (paramInt = 3;; paramInt = 4)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(bews.a()));
      localTryUpPttReq.uint32_voice_length.set(parambfbf.jdField_a_of_type_Int);
      localTryUpPttReq.uint32_codec.set(parambfbf.jdField_c_of_type_Int);
      localTryUpPttReq.uint32_voice_type.set(parambfbf.jdField_d_of_type_Int);
      localTryUpPttReq.bool_new_up_chan.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "GroupPttUp: panel[" + parambfbf.jdField_d_of_type_Int + "] type[" + parambfbf.jdField_c_of_type_Int + "] length[" + parambfbf.jdField_a_of_type_Int + "] size[" + parambfbf.b + "]");
      }
      paramReqBody.rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
      return;
    }
  }
  
  public void a(bevy parambevy, bevx parambevx)
  {
    FromServiceMsg localFromServiceMsg = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bfau localbfau = (bfau)parambevx.jdField_a_of_type_JavaLangObject;
    bfbj localbfbj = localbfau.jdField_a_of_type_Bfbj;
    aock localaock = parambevy.jdField_a_of_type_Aock;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        parambevx = localFromServiceMsg.getBusinessFailMsg();
        parambevy = parambevx;
        if (parambevx == null) {
          parambevy = "";
        }
        a(-1, 9311, (String)localObject1, parambevy, localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      bfca.a(localbfau, localbfbj);
      return;
      localObject1 = MessageHandler.a(localFromServiceMsg);
      parambevx = localFromServiceMsg.getBusinessFailMsg();
      parambevy = parambevx;
      if (parambevx == null) {
        parambevy = "";
      }
      a(-1, 9044, (String)localObject1, parambevy, localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        parambevy = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_ptt_rsp.get();
        if ((parambevy != null) && (parambevy.size() != 0)) {
          break label264;
        }
        throw new Exception("resps null");
      }
      catch (Exception parambevy)
      {
        a(-1, -9527, berp.a("P", -9529L), parambevy.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localaock, localbfbj.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label264:
      Iterator localIterator = parambevy.iterator();
      while (localIterator.hasNext())
      {
        parambevy = (cmd0x388.TryUpPttRsp)localIterator.next();
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject1 = (bfbq)localbfbj.jdField_a_of_type_JavaUtilList.get((int)parambevy.uint64_file_id.get());
              try
              {
                ((bfbq)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
                if (QLog.isColorLevel()) {
                  QLog.e("http_sideway", 2, "GroupPttUpHandler.onProtoResp:isSendByQuickHttp=" + ((bfbq)localObject1).d);
                }
                i = parambevy.uint32_result.get();
                if (i != 0) {
                  break label745;
                }
                ((bfbq)localObject1).jdField_a_of_type_Long = parambevy.uint64_fileid.get();
                if (parambevy.bytes_file_key.has()) {
                  ((bfbq)localObject1).jdField_a_of_type_ArrayOfByte = parambevy.bytes_file_key.get().toByteArray();
                }
                if ((!parambevy.bool_file_exit.has()) || (!parambevy.bool_file_exit.get())) {
                  break label524;
                }
                ((bfbq)localObject1).jdField_a_of_type_Boolean = true;
                a(0, 0, "", "", localaock, (bfbw)localObject1);
              }
              catch (Exception parambevy) {}
            }
          }
          catch (Exception parambevy)
          {
            label524:
            List localList;
            Object localObject2;
            long l1;
            long l2;
            bewy localbewy;
            localObject1 = null;
            continue;
          }
          a(-1, -9527, berp.a("P", -9529L), parambevy.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localaock, (bfbw)localObject1);
          break;
          localList = parambevy.rpt_uint32_up_ip.get();
          localObject2 = parambevy.rpt_uint32_up_port.get();
          if ((localList != null) && (localList.size() > 0))
          {
            i = 0;
            if (i < localList.size())
            {
              l1 = ((Integer)localList.get(i)).intValue();
              l2 = ((Integer)((List)localObject2).get(i)).intValue();
              localbewy = new bewy();
              localbewy.jdField_a_of_type_JavaLangString = bhvd.a(l1 & 0xFFFFFFFF);
              localbewy.jdField_a_of_type_Int = ((int)l2);
              ((bfbq)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localbewy);
              i += 1;
              continue;
            }
          }
          localObject2 = HexUtil.bytes2HexStr(parambevy.bytes_up_ukey.get().toByteArray());
          if ((localObject2 == null) || (((String)localObject2).equals("")) || (localList == null) || (localList.size() == 0)) {
            throw new Exception("check ukey,iplist");
          }
          ((bfbq)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
          ((bfbq)localObject1).jdField_a_of_type_Int = ((int)parambevy.uint64_block_size.get());
          ((bfbq)localObject1).b = ((int)parambevy.uint64_up_offset.get());
        }
        label745:
        if (bfak.a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambevx);
            return;
          }
        }
        a(-1, -9527, berp.a(i), "", localaock, (bfbw)localObject1);
      }
    }
  }
  
  public void a(bfau parambfau)
  {
    if ((parambfau != null) && (parambfau.jdField_a_of_type_JavaUtilList != null) && (parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bevx localbevx = new bevx();
      localbevx.jdField_a_of_type_JavaLangString = "PttStore.GroupPttUp";
      localbevx.jdField_a_of_type_ArrayOfByte = a(parambfau.jdField_a_of_type_JavaUtilList);
      localbevx.jdField_a_of_type_JavaLangObject = parambfau;
      localbevx.jdField_a_of_type_Bevw = this;
      a(parambfau, localbevx);
    }
  }
  
  byte[] a(List<bfbf> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(3);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (bfbf)paramList.get(i), localReqBody);
      i += 1;
    }
    i = a();
    localReqBody.uint32_net_type.set(i);
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "GroupPttUp: net[" + i + "]");
    }
    return localReqBody.toByteArray();
  }
  
  void b(bfau parambfau)
  {
    bfbj localbfbj = parambfau.jdField_a_of_type_Bfbj;
    localbfbj.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambfau.jdField_a_of_type_JavaUtilList.size())
    {
      bfbq localbfbq = new bfbq();
      localbfbj.jdField_a_of_type_JavaUtilList.add(i, localbfbq);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfam
 * JD-Core Version:    0.7.0.1
 */