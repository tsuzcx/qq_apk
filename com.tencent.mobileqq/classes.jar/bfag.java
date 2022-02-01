import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.RspBody;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgReq;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgRsp;

public class bfag
  extends bfas
{
  int a;
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
  void a(int paramInt, bfbf parambfbf, cmd0x352.ReqBody paramReqBody)
  {
    bfbd localbfbd = (bfbd)parambfbf;
    cmd0x352.TryUpImgReq localTryUpImgReq = new cmd0x352.TryUpImgReq();
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(localbfbd.jdField_c_of_type_JavaLangString).longValue());
    try
    {
      String str = localbfbd.jdField_d_of_type_JavaLangString;
      parambfbf = str;
      if (str.startsWith("+")) {
        parambfbf = str.substring(1);
      }
      long l = Long.valueOf(parambfbf).longValue();
      localTryUpImgReq.uint64_dst_uin.set(l);
    }
    catch (Exception parambfbf)
    {
      for (;;)
      {
        parambfbf.printStackTrace();
      }
    }
    localTryUpImgReq.uint64_file_size.set(localbfbd.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(localbfbd.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(localbfbd.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.bool_address_book.set(localbfbd.jdField_c_of_type_Boolean);
    localTryUpImgReq.uint32_platform_type.set(9);
    a(localTryUpImgReq);
    localTryUpImgReq.bool_pic_original.set(localbfbd.jdField_b_of_type_Boolean);
    localTryUpImgReq.uint32_pic_width.set(localbfbd.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(localbfbd.jdField_d_of_type_Int);
    localTryUpImgReq.uint32_pic_type.set(localbfbd.jdField_a_of_type_Int);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(bews.a()));
    localTryUpImgReq.bool_reject_tryfast.set(false);
    localTryUpImgReq.uint32_srv_upload.set(localbfbd.e);
    if (!TextUtils.isEmpty(localbfbd.jdField_b_of_type_JavaLangString)) {
      localTryUpImgReq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(localbfbd.jdField_b_of_type_JavaLangString));
    }
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  protected void a(bevx parambevx)
  {
    parambevx.jdField_a_of_type_JavaLangString = "LongConn.OffPicUp";
  }
  
  public void a(bfau parambfau)
  {
    if ((parambfau != null) && (parambfau.jdField_a_of_type_JavaUtilList != null) && (parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bevx localbevx = new bevx();
      a(localbevx);
      localbevx.jdField_a_of_type_ArrayOfByte = a(parambfau.jdField_a_of_type_JavaUtilList);
      localbevx.jdField_a_of_type_JavaLangObject = parambfau;
      localbevx.jdField_a_of_type_Bevw = this;
      a(parambfau, localbevx);
    }
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, bfau parambfau, bfbj parambfbj, aock paramaock, bevy parambevy, bevx parambevx)
  {
    try
    {
      parambevy = ((cmd0x352.RspBody)new cmd0x352.RspBody().mergeFrom(paramArrayOfByte)).rpt_msg_tryup_img_rsp.get();
      if ((parambevy == null) || (parambevy.size() == 0)) {
        throw new Exception("resps null");
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      a(-1, -9527, berp.a("P", -9529L), paramFromServiceMsg.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramaock, parambfbj.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      return;
      Iterator localIterator = parambevy.iterator();
      while (localIterator.hasNext())
      {
        parambevy = (cmd0x352.TryUpImgRsp)localIterator.next();
        try
        {
          localbfbl = (bfbl)parambfbj.jdField_a_of_type_JavaUtilList.get((int)parambevy.uint64_file_id.get());
          if (localbfbl == null) {
            continue;
          }
          try
          {
            if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              localbfbl.jdField_d_of_type_Boolean = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = parambevy.uint32_result.get();
            if (i != 0) {
              break label295;
            }
            a(parambevy, localbfbl);
            a(0, 0, "", "", paramaock, localbfbl);
          }
          catch (Exception parambevy) {}
        }
        catch (Exception parambevy)
        {
          for (;;)
          {
            int i;
            bfbl localbfbl = null;
          }
        }
        a(-1, -9527, berp.a("P", -9529L), parambevy.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramaock, localbfbl);
        continue;
        label295:
        if (a(i))
        {
          this.b += 1;
          if (this.b < 2)
          {
            parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambevx);
            return;
          }
        }
        a(-1, -9527, berp.a(i), "", paramaock, localbfbl);
      }
    }
  }
  
  protected void a(cmd0x352.TryUpImgReq paramTryUpImgReq)
  {
    paramTryUpImgReq.uint32_bu_type.set(1);
  }
  
  void a(cmd0x352.TryUpImgRsp paramTryUpImgRsp, bfbl parambfbl)
  {
    boolean bool = true;
    if (paramTryUpImgRsp.bytes_up_resid.has()) {
      parambfbl.jdField_a_of_type_JavaLangString = paramTryUpImgRsp.bytes_up_resid.get().toStringUtf8();
    }
    if (paramTryUpImgRsp.bytes_up_uuid.has()) {
      parambfbl.jdField_b_of_type_JavaLangString = paramTryUpImgRsp.bytes_up_uuid.get().toStringUtf8();
    }
    parambfbl.jdField_a_of_type_Long = paramTryUpImgRsp.uint64_up_offset.get();
    if (QLog.isColorLevel()) {
      QLog.d("BDH_LOG", 2, " TryUpLoad : Offset:" + parambfbl.jdField_a_of_type_Long + " Value:" + paramTryUpImgRsp.uint64_up_offset.get());
    }
    if ((paramTryUpImgRsp.bool_file_exit.has()) && (paramTryUpImgRsp.bool_file_exit.get()))
    {
      parambfbl.jdField_a_of_type_Boolean = true;
      if (paramTryUpImgRsp.bytes_original_down_para.has()) {
        parambfbl.jdField_d_of_type_JavaLangString = paramTryUpImgRsp.bytes_original_down_para.get().toStringUtf8();
      }
      return;
    }
    parambfbl.jdField_c_of_type_JavaLangString = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
    parambfbl.jdField_a_of_type_Int = ((int)paramTryUpImgRsp.uint64_block_size.get());
    if (bevn.a().a() != this.jdField_a_of_type_Int) {}
    for (;;)
    {
      parambfbl.jdField_b_of_type_Boolean = bool;
      break;
      bool = false;
    }
  }
  
  byte[] a(List<bfbf> paramList)
  {
    cmd0x352.ReqBody localReqBody = new cmd0x352.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (bfbf)paramList.get(i), localReqBody);
      i += 1;
    }
    i = bevn.a().a();
    this.jdField_a_of_type_Int = i;
    switch (i)
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = bevn.a().a();
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
  
  void b(bfau parambfau)
  {
    bfbj localbfbj = parambfau.jdField_a_of_type_Bfbj;
    localbfbj.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambfau.jdField_a_of_type_JavaUtilList.size())
    {
      bfbl localbfbl = new bfbl();
      localbfbj.jdField_a_of_type_JavaUtilList.add(i, localbfbl);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfag
 * JD-Core Version:    0.7.0.1
 */