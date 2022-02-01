import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgReq;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgRsp;

public class bfak
  extends bfas
{
  int a;
  
  private void a(aock paramaock, cmd0x388.TryUpImgRsp paramTryUpImgRsp, bfbo parambfbo)
  {
    parambfbo.jdField_a_of_type_Long = paramTryUpImgRsp.uint64_fileid.get();
    List localList;
    int i;
    if ((paramTryUpImgRsp.bool_file_exit.has()) && (paramTryUpImgRsp.bool_file_exit.get()))
    {
      parambfbo.jdField_a_of_type_Boolean = true;
      localList = paramTryUpImgRsp.rpt_uint32_up_ip.get();
      paramTryUpImgRsp = paramTryUpImgRsp.rpt_uint32_up_port.get();
      if ((localList != null) && (localList.size() > 0)) {
        i = 0;
      }
    }
    else
    {
      while (i < localList.size())
      {
        long l1 = ((Integer)localList.get(i)).intValue();
        long l2 = ((Integer)paramTryUpImgRsp.get(i)).intValue();
        Object localObject = new bewy();
        ((bewy)localObject).jdField_a_of_type_JavaLangString = bhvd.a(l1 & 0xFFFFFFFF);
        ((bewy)localObject).jdField_a_of_type_Int = ((int)l2);
        parambfbo.jdField_a_of_type_JavaUtilArrayList.add(i, localObject);
        i += 1;
        continue;
        localList = paramTryUpImgRsp.rpt_uint32_up_ip.get();
        localObject = paramTryUpImgRsp.rpt_uint32_up_port.get();
        if ((localList != null) && (localList.size() > 0))
        {
          i = 0;
          while (i < localList.size())
          {
            l1 = ((Integer)localList.get(i)).intValue();
            l2 = ((Integer)((List)localObject).get(i)).intValue();
            bewy localbewy = new bewy();
            localbewy.jdField_a_of_type_JavaLangString = bhvd.a(l1 & 0xFFFFFFFF);
            localbewy.jdField_a_of_type_Int = ((int)l2);
            parambfbo.jdField_a_of_type_JavaUtilArrayList.add(i, localbewy);
            i += 1;
          }
        }
        localObject = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
        if ((localObject == null) || (((String)localObject).equals("")) || (localList == null) || (localList.size() == 0)) {
          throw new Exception("check ukey,iplist");
        }
        parambfbo.jdField_a_of_type_JavaLangString = ((String)localObject);
        parambfbo.jdField_a_of_type_Int = ((int)paramTryUpImgRsp.uint64_block_size.get());
        parambfbo.jdField_b_of_type_Int = ((int)paramTryUpImgRsp.uint64_up_offset.get());
        if (bevn.a().a() == this.jdField_a_of_type_Int) {
          break label498;
        }
      }
    }
    label498:
    for (boolean bool = true;; bool = false)
    {
      parambfbo.jdField_b_of_type_Boolean = bool;
      parambfbo.jdField_b_of_type_Long = paramTryUpImgRsp.uint64_up_offset.get();
      if (QLog.isColorLevel()) {
        QLog.d("BDH_LOG", 2, " Channel:" + paramTryUpImgRsp.bool_new_big_chan.get());
      }
      if ((paramTryUpImgRsp.bool_new_big_chan.has()) && (paramTryUpImgRsp.bool_new_big_chan.get() == true)) {
        parambfbo.c = true;
      }
      a(0, 0, "", "", paramaock, parambfbo);
      return;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 194) && (paramInt != 197) && (paramInt != 199) && (paramInt != 200) && (paramInt != 201) && (paramInt != 203) && (paramInt != 202);
  }
  
  void a(int paramInt, bfbf parambfbf, cmd0x388.ReqBody paramReqBody)
  {
    parambfbf = (bfbd)parambfbf;
    cmd0x388.TryUpImgReq localTryUpImgReq = new cmd0x388.TryUpImgReq();
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(parambfbf.jdField_c_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_group_code.set(Long.valueOf(parambfbf.jdField_d_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.uint64_file_size.set(parambfbf.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambfbf.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(parambfbf.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_pic_width.set(parambfbf.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(parambfbf.jdField_d_of_type_Int);
    localTryUpImgReq.uint32_pic_type.set(parambfbf.jdField_a_of_type_Int);
    localTryUpImgReq.uint32_app_pic_type.set(parambfbf.jdField_b_of_type_Int);
    PBUInt32Field localPBUInt32Field = localTryUpImgReq.uint32_bu_type;
    if (parambfbf.f == 1) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(bews.a()));
      localTryUpImgReq.uint32_srv_upload.set(parambfbf.e);
      if (parambfbf.jdField_b_of_type_Boolean) {
        localTryUpImgReq.uint32_original_pic.set(1);
      }
      if (!TextUtils.isEmpty(parambfbf.jdField_b_of_type_JavaLangString)) {
        localTryUpImgReq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(parambfbf.jdField_b_of_type_JavaLangString));
      }
      paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
      return;
    }
  }
  
  public void a(bfau parambfau)
  {
    if ((parambfau != null) && (parambfau.jdField_a_of_type_JavaUtilList != null) && (parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bevx localbevx = new bevx();
      localbevx.jdField_a_of_type_JavaLangString = "ImgStore.GroupPicUp";
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
      parambevy = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(paramArrayOfByte)).rpt_msg_tryup_img_rsp.get();
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
        parambevy = (cmd0x388.TryUpImgRsp)localIterator.next();
        try
        {
          localbfbo = (bfbo)parambfbj.jdField_a_of_type_JavaUtilList.get((int)parambevy.uint64_file_id.get());
          if (localbfbo == null) {
            continue;
          }
          try
          {
            if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              localbfbo.d = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = parambevy.uint32_result.get();
            if (i != 0) {
              break label284;
            }
            a(paramaock, parambevy, localbfbo);
          }
          catch (Exception parambevy) {}
        }
        catch (Exception parambevy)
        {
          for (;;)
          {
            int i;
            bfbo localbfbo = null;
          }
        }
        a(-1, -9527, berp.a("P", -9529L), parambevy.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramaock, localbfbo);
        continue;
        label284:
        if (a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambevx);
            return;
          }
        }
        a(-1, -9527, berp.a(i), "", paramaock, localbfbo);
      }
    }
  }
  
  byte[] a(List<bfbf> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
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
      bfbo localbfbo = new bfbo();
      localbfbj.jdField_a_of_type_JavaUtilList.add(i, localbfbo);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfak
 * JD-Core Version:    0.7.0.1
 */