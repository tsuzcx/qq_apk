import android.text.TextUtils;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgReq;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgRsp;

public class bbap
  extends bbaj
{
  int a;
  
  public static boolean a(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 194) && (paramInt != 197) && (paramInt != 199) && (paramInt != 200) && (paramInt != 201) && (paramInt != 203) && (paramInt != 202);
  }
  
  void a(int paramInt, bbbi parambbbi, cmd0x388.ReqBody paramReqBody)
  {
    parambbbi = (bbbg)parambbbi;
    cmd0x388.TryUpImgReq localTryUpImgReq = new cmd0x388.TryUpImgReq();
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(parambbbi.jdField_c_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_group_code.set(Long.valueOf(parambbbi.jdField_d_of_type_JavaLangString).longValue());
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.uint64_file_size.set(parambbbi.jdField_a_of_type_Long);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(parambbbi.jdField_a_of_type_ArrayOfByte));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(parambbbi.jdField_a_of_type_JavaLangString));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_pic_width.set(parambbbi.jdField_c_of_type_Int);
    localTryUpImgReq.uint32_pic_height.set(parambbbi.jdField_d_of_type_Int);
    localTryUpImgReq.uint32_pic_type.set(parambbbi.jdField_a_of_type_Int);
    localTryUpImgReq.uint32_app_pic_type.set(parambbbi.jdField_b_of_type_Int);
    PBUInt32Field localPBUInt32Field = localTryUpImgReq.uint32_bu_type;
    if (parambbbi.f == 1) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(baws.a()));
      localTryUpImgReq.uint32_srv_upload.set(parambbbi.e);
      if (parambbbi.jdField_b_of_type_Boolean) {
        localTryUpImgReq.uint32_original_pic.set(1);
      }
      if (!TextUtils.isEmpty(parambbbi.jdField_b_of_type_JavaLangString)) {
        localTryUpImgReq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(parambbbi.jdField_b_of_type_JavaLangString));
      }
      paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
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
      parambavr = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((parambavr.equals("conSucc")) || (parambavr.equals("")))
      {
        i = localFromServiceMsg.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject1 = MessageHandler.b(localFromServiceMsg);
          parambavq = localFromServiceMsg.getBusinessFailMsg();
          parambavr = parambavq;
          if (parambavq == null) {
            parambavr = "";
          }
          a(-1, 9311, (String)localObject1, parambavr, localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    for (;;)
    {
      bbcd.a(localbbax, localbbbm);
      return;
      parambavq = localFromServiceMsg.getBusinessFailMsg();
      parambavr = parambavq;
      if (parambavq == null) {
        parambavr = "";
      }
      a(-1, 9044, String.valueOf(i), parambavr, localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      continue;
      a(-1, 9313, parambavr, localFromServiceMsg.getBusinessFailMsg(), localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        parambavr = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_img_rsp.get();
        if ((parambavr != null) && (parambavr.size() != 0)) {
          break label314;
        }
        throw new Exception("resps null");
      }
      catch (Exception parambavr)
      {
        a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label314:
      Iterator localIterator = parambavr.iterator();
      while (localIterator.hasNext())
      {
        parambavr = (cmd0x388.TryUpImgRsp)localIterator.next();
        try
        {
          localObject1 = (bbbr)localbbbm.jdField_a_of_type_JavaUtilList.get((int)parambavr.uint64_file_id.get());
          if (localObject1 == null) {
            continue;
          }
          try
          {
            if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
              ((bbbr)localObject1).d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
            }
            i = parambavr.uint32_result.get();
            if (i != 0) {
              break label977;
            }
            ((bbbr)localObject1).jdField_a_of_type_Long = parambavr.uint64_fileid.get();
            long l1;
            long l2;
            if ((parambavr.bool_file_exit.has()) && (parambavr.bool_file_exit.get()))
            {
              ((bbbr)localObject1).jdField_a_of_type_Boolean = true;
              localList = parambavr.rpt_uint32_up_ip.get();
              parambavr = parambavr.rpt_uint32_up_port.get();
              if ((localList == null) || (localList.size() <= 0)) {
                break label960;
              }
              i = 0;
              while (i < localList.size())
              {
                l1 = ((Integer)localList.get(i)).intValue();
                l2 = ((Integer)parambavr.get(i)).intValue();
                localObject2 = new bawy();
                ((bawy)localObject2).jdField_a_of_type_JavaLangString = bdqa.a(l1 & 0xFFFFFFFF);
                ((bawy)localObject2).jdField_a_of_type_Int = ((int)l2);
                ((bbbr)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localObject2);
                i += 1;
              }
            }
            List localList = parambavr.rpt_uint32_up_ip.get();
            localObject2 = parambavr.rpt_uint32_up_port.get();
            if ((localList != null) && (localList.size() > 0))
            {
              i = 0;
              while (i < localList.size())
              {
                l1 = ((Integer)localList.get(i)).intValue();
                l2 = ((Integer)((List)localObject2).get(i)).intValue();
                bawy localbawy = new bawy();
                localbawy.jdField_a_of_type_JavaLangString = bdqa.a(l1 & 0xFFFFFFFF);
                localbawy.jdField_a_of_type_Int = ((int)l2);
                ((bbbr)localObject1).jdField_a_of_type_JavaUtilArrayList.add(i, localbawy);
                i += 1;
              }
            }
            localObject2 = HexUtil.bytes2HexStr(parambavr.bytes_up_ukey.get().toByteArray());
            if ((localObject2 != null) && (!((String)localObject2).equals("")) && (localList != null) && (localList.size() != 0)) {
              break label826;
            }
            throw new Exception("check ukey,iplist");
          }
          catch (Exception parambavr) {}
        }
        catch (Exception parambavr)
        {
          for (;;)
          {
            Object localObject2;
            localObject1 = null;
            continue;
            boolean bool = false;
          }
        }
        a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalwy, (bbbz)localObject1);
        continue;
        label826:
        ((bbbr)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
        ((bbbr)localObject1).jdField_a_of_type_Int = ((int)parambavr.uint64_block_size.get());
        ((bbbr)localObject1).jdField_b_of_type_Int = ((int)parambavr.uint64_up_offset.get());
        if (bavg.a().a() == this.jdField_a_of_type_Int) {
          break label1041;
        }
        bool = true;
        ((bbbr)localObject1).jdField_b_of_type_Boolean = bool;
        ((bbbr)localObject1).jdField_b_of_type_Long = parambavr.uint64_up_offset.get();
        if (QLog.isColorLevel()) {
          QLog.d("BDH_LOG", 2, " Channel:" + parambavr.bool_new_big_chan.get());
        }
        if ((parambavr.bool_new_big_chan.has()) && (parambavr.bool_new_big_chan.get() == true)) {
          ((bbbr)localObject1).c = true;
        }
        label960:
        a(0, 0, "", "", localalwy, (bbbz)localObject1);
        continue;
        label977:
        if (a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
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
      localbavq.jdField_a_of_type_JavaLangString = "ImgStore.GroupPicUp";
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
    localReqBody.uint32_subcmd.set(1);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (bbbi)paramList.get(i), localReqBody);
      i += 1;
    }
    i = bavg.a().a();
    this.jdField_a_of_type_Int = i;
    switch (i)
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = bavg.a().a();
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
  
  void b(bbax parambbax)
  {
    bbbm localbbbm = parambbax.jdField_a_of_type_Bbbm;
    localbbbm.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambbax.jdField_a_of_type_JavaUtilList.size())
    {
      bbbr localbbbr = new bbbr();
      localbbbm.jdField_a_of_type_JavaUtilList.add(i, localbbbr);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbap
 * JD-Core Version:    0.7.0.1
 */