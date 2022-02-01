import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlRsp;
import tencent.im.cs.cmd0x352.cmd0x352.IPv6Info;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.RspBody;

public class bebg
  extends bebs
{
  private void a(bebw parambebw, cmd0x352.GetImgUrlRsp paramGetImgUrlRsp, becw parambecw)
  {
    int j = 0;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (bcsc.a())
    {
      localObject1 = paramGetImgUrlRsp.bytes_big_thumb_down_para.get();
      localObject2 = paramGetImgUrlRsp.bytes_original_down_para.get();
      localObject3 = paramGetImgUrlRsp.bytes_big_down_para.get();
      if (localObject1 != null) {
        break label234;
      }
      localObject1 = null;
      label44:
      if (localObject2 != null) {
        break label244;
      }
      localObject2 = null;
      label52:
      if (localObject3 != null) {
        break label254;
      }
      localObject3 = null;
      label60:
      if (parambebw.jdField_a_of_type_Int != 65537) {
        break label264;
      }
    }
    for (;;)
    {
      label69:
      parambecw.jdField_a_of_type_JavaLangString = ((String)localObject1);
      int i;
      if ((paramGetImgUrlRsp.rpt_uint32_down_ip.has()) && (paramGetImgUrlRsp.rpt_uint32_down_ip.size() > 0) && (paramGetImgUrlRsp.rpt_uint32_down_port.has()) && (paramGetImgUrlRsp.rpt_uint32_down_port.size() > 0))
      {
        parambebw = paramGetImgUrlRsp.rpt_uint32_down_ip.get();
        localObject1 = paramGetImgUrlRsp.rpt_uint32_down_port.get();
        i = 0;
        for (;;)
        {
          if (i < parambebw.size())
          {
            localObject2 = new bdyf();
            ((bdyf)localObject2).jdField_a_of_type_JavaLangString = bgva.a(((Integer)parambebw.get(i)).intValue() & 0xFFFFFFFF);
            ((bdyf)localObject2).jdField_a_of_type_Int = ((Integer)((List)localObject1).get(i)).intValue();
            parambecw.jdField_a_of_type_JavaUtilArrayList.add(i, localObject2);
            i += 1;
            continue;
            localObject1 = paramGetImgUrlRsp.bytes_thumb_down_para.get();
            break;
            label234:
            localObject1 = ((ByteStringMicro)localObject1).toStringUtf8();
            break label44;
            label244:
            localObject2 = ((ByteStringMicro)localObject2).toStringUtf8();
            break label52;
            label254:
            localObject3 = ((ByteStringMicro)localObject3).toStringUtf8();
            break label60;
            label264:
            localObject1 = localObject3;
            if (parambebw.jdField_a_of_type_Int == 1) {
              break label69;
            }
            if (parambebw.jdField_a_of_type_Int != 131075) {
              break label500;
            }
            localObject1 = localObject2;
            break label69;
          }
        }
      }
      if ((paramGetImgUrlRsp.rpt_msg_down_ip6.has()) && (paramGetImgUrlRsp.rpt_msg_down_ip6.size() > 0))
      {
        parambebw = paramGetImgUrlRsp.rpt_msg_down_ip6.get();
        i = j;
        while (i < parambebw.size())
        {
          localObject1 = new bdyf();
          ((bdyf)localObject1).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x352.IPv6Info)parambebw.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
          ((bdyf)localObject1).jdField_a_of_type_Int = ((cmd0x352.IPv6Info)parambebw.get(i)).uint32_port.get();
          ((bdyf)localObject1).jdField_a_of_type_Boolean = true;
          parambecw.jdField_b_of_type_JavaUtilArrayList.add(i, localObject1);
          i += 1;
        }
      }
      if (paramGetImgUrlRsp.bytes_down_domain.has())
      {
        parambebw = new bdyf();
        parambebw.jdField_a_of_type_JavaLangString = paramGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
        parambebw.jdField_a_of_type_Int = 80;
        parambecw.jdField_a_of_type_JavaUtilArrayList.add(parambebw);
        parambecw.jdField_b_of_type_JavaLangString = parambebw.jdField_a_of_type_JavaLangString;
      }
      if (paramGetImgUrlRsp.uint32_https_url_flag.has()) {
        parambecw.jdField_a_of_type_Int = paramGetImgUrlRsp.uint32_https_url_flag.get();
      }
      return;
      label500:
      localObject1 = null;
    }
  }
  
  /* Error */
  void a(int paramInt, becg parambecg, cmd0x352.ReqBody paramReqBody)
  {
    // Byte code:
    //   0: bipush 16
    //   2: istore 4
    //   4: aload_2
    //   5: checkcast 36	bebw
    //   8: astore 8
    //   10: new 170	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq
    //   13: dup
    //   14: invokespecial 171	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:<init>	()V
    //   17: astore 9
    //   19: aload 9
    //   21: iconst_1
    //   22: invokevirtual 175	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:setHasFlag	(Z)V
    //   25: aload 9
    //   27: getfield 179	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   30: aload 8
    //   32: getfield 182	bebw:d	Ljava/lang/String;
    //   35: invokestatic 188	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   38: invokevirtual 192	java/lang/Long:longValue	()J
    //   41: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   44: aload 9
    //   46: getfield 201	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_pic_up_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   49: aload 8
    //   51: getfield 203	bebw:jdField_b_of_type_Int	I
    //   54: invokevirtual 206	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   57: aload 8
    //   59: getfield 209	bebw:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   62: astore 7
    //   64: aload 7
    //   66: astore_2
    //   67: aload 7
    //   69: ldc 211
    //   71: invokevirtual 217	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   74: ifeq +10 -> 84
    //   77: aload 7
    //   79: iconst_1
    //   80: invokevirtual 221	java/lang/String:substring	(I)Ljava/lang/String;
    //   83: astore_2
    //   84: aload_2
    //   85: invokestatic 188	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   88: invokevirtual 192	java/lang/Long:longValue	()J
    //   91: lstore 5
    //   93: aload 9
    //   95: getfield 224	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   98: lload 5
    //   100: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   103: aload 8
    //   105: getfield 225	bebw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   108: ldc 227
    //   110: invokevirtual 231	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   113: astore_2
    //   114: aload 9
    //   116: getfield 234	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bytes_file_resid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   119: aload_2
    //   120: invokestatic 238	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   123: invokevirtual 241	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   126: aload 9
    //   128: getfield 245	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bool_address_book	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   131: aload 8
    //   133: getfield 246	bebw:jdField_a_of_type_Boolean	Z
    //   136: invokevirtual 250	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   139: ldc 252
    //   141: aload 8
    //   143: getfield 253	bebw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   146: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: ifeq +151 -> 300
    //   152: aload 9
    //   154: getfield 259	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: iconst_2
    //   158: invokevirtual 206	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   161: aload 9
    //   163: getfield 262	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_term	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   166: iconst_5
    //   167: invokevirtual 206	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   170: aload 9
    //   172: getfield 245	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bool_address_book	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   175: aload 8
    //   177: getfield 246	bebw:jdField_a_of_type_Boolean	Z
    //   180: invokevirtual 250	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   183: aload 9
    //   185: getfield 265	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_platform_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   188: bipush 9
    //   190: invokevirtual 206	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   193: aload 9
    //   195: getfield 268	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_bu_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   198: iconst_1
    //   199: invokevirtual 206	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   202: aload 8
    //   204: getfield 39	bebw:jdField_a_of_type_Int	I
    //   207: istore_1
    //   208: iload_1
    //   209: ldc 40
    //   211: if_icmpne +137 -> 348
    //   214: invokestatic 16	bcsc:a	()Z
    //   217: ifeq +123 -> 340
    //   220: bipush 16
    //   222: istore_1
    //   223: iconst_4
    //   224: istore 4
    //   226: aload 9
    //   228: getfield 271	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_url_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   231: iload 4
    //   233: invokevirtual 206	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   236: aload 9
    //   238: getfield 274	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_url_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   241: iload_1
    //   242: invokevirtual 206	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   245: aload 9
    //   247: getfield 277	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bytes_build_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   250: invokestatic 281	bdxz:a	()Ljava/lang/String;
    //   253: invokestatic 285	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   256: invokevirtual 241	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   259: aload 9
    //   261: getfield 288	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_transfer_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   264: aload 8
    //   266: getfield 290	bebw:jdField_c_of_type_Int	I
    //   269: invokevirtual 206	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   272: aload_3
    //   273: getfield 295	tencent/im/cs/cmd0x352/cmd0x352$ReqBody:rpt_msg_getimg_url_req	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   276: aload 9
    //   278: invokevirtual 298	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   281: return
    //   282: astore_2
    //   283: aload_2
    //   284: invokevirtual 301	java/lang/Exception:printStackTrace	()V
    //   287: goto -184 -> 103
    //   290: astore_2
    //   291: aload_2
    //   292: invokevirtual 302	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   295: aconst_null
    //   296: astore_2
    //   297: goto -183 -> 114
    //   300: ldc_w 304
    //   303: aload 8
    //   305: getfield 253	bebw:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   308: invokevirtual 256	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   311: ifeq +15 -> 326
    //   314: aload 9
    //   316: getfield 259	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   319: iconst_1
    //   320: invokevirtual 206	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   323: goto -162 -> 161
    //   326: aload 9
    //   328: getfield 259	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   331: sipush 255
    //   334: invokevirtual 206	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   337: goto -176 -> 161
    //   340: iconst_1
    //   341: istore_1
    //   342: iconst_4
    //   343: istore 4
    //   345: goto -119 -> 226
    //   348: iload_1
    //   349: iconst_1
    //   350: if_icmpne +13 -> 363
    //   353: bipush 6
    //   355: istore 4
    //   357: bipush 8
    //   359: istore_1
    //   360: goto -134 -> 226
    //   363: iload_1
    //   364: ldc 106
    //   366: if_icmpne +8 -> 374
    //   369: iconst_2
    //   370: istore_1
    //   371: goto -145 -> 226
    //   374: iconst_0
    //   375: istore_1
    //   376: iconst_0
    //   377: istore 4
    //   379: goto -153 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	this	bebg
    //   0	382	1	paramInt	int
    //   0	382	2	parambecg	becg
    //   0	382	3	paramReqBody	cmd0x352.ReqBody
    //   2	376	4	i	int
    //   91	8	5	l	long
    //   62	16	7	str	String
    //   8	296	8	localbebw	bebw
    //   17	310	9	localGetImgUrlReq	tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlReq
    // Exception table:
    //   from	to	target	type
    //   57	64	282	java/lang/Exception
    //   67	84	282	java/lang/Exception
    //   84	103	282	java/lang/Exception
    //   103	114	290	java/io/UnsupportedEncodingException
  }
  
  protected void a(bdxf parambdxf, bdxe parambdxe, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, bebv parambebv, beck parambeck, anqe paramanqe)
  {
    try
    {
      parambdxf = ((cmd0x352.RspBody)new cmd0x352.RspBody().mergeFrom(paramArrayOfByte)).rpt_msg_getimg_url_rsp.get();
      if ((parambdxf != null) && (parambdxf.size() != 0)) {
        break label103;
      }
      throw new Exception("resps null");
    }
    catch (Exception parambdxf)
    {
      a(-1, -9527, bdsx.a("P", -9529L), parambdxf.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramanqe, parambeck.jdField_a_of_type_JavaUtilList);
    }
    return;
    label103:
    Iterator localIterator = parambdxf.iterator();
    label111:
    while (localIterator.hasNext())
    {
      parambdxf = (cmd0x352.GetImgUrlRsp)localIterator.next();
      try
      {
        localbecw = (becw)parambeck.jdField_a_of_type_JavaUtilList.get(0);
        try
        {
          localbebw = (bebw)parambebv.jdField_a_of_type_JavaUtilList.get(0);
          if (localbecw == null) {
            continue;
          }
          if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
            localbecw.d = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          }
          i = parambdxf.uint32_result.get();
          if (i != 0) {
            break label307;
          }
          a(localbebw, parambdxf, localbecw);
          a(0, 0, "", "", paramanqe, localbecw);
        }
        catch (Exception parambdxf) {}
      }
      catch (Exception parambdxf)
      {
        for (;;)
        {
          bebw localbebw;
          int i;
          becw localbecw = null;
        }
      }
      if (localbecw != null)
      {
        a(-1, -9527, bdsx.a("P", -9529L), parambdxf.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramanqe, localbecw);
        continue;
        if (bebh.a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambdxe);
            return;
          }
        }
        if ((i == 201) && (QLog.isColorLevel())) {
          break label384;
        }
      }
    }
    for (;;)
    {
      label307:
      a(-1, -9527, bdsx.a(i), bdsx.a(i), paramanqe, localbecw);
      break label111;
      break;
      label384:
      bcsz.a("Download_C2C_Pic_Request_Error_Param_Check", localbebw.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(bebv parambebv)
  {
    if ((parambebv != null) && (parambebv.jdField_a_of_type_JavaUtilList != null) && (parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bdxe localbdxe = new bdxe();
      localbdxe.jdField_a_of_type_JavaLangString = "LongConn.OffPicDown";
      localbdxe.jdField_a_of_type_ArrayOfByte = a(parambebv.jdField_a_of_type_JavaUtilList);
      localbdxe.jdField_a_of_type_JavaLangObject = parambebv;
      localbdxe.jdField_a_of_type_Bdxd = this;
      a(parambebv, localbdxe);
    }
  }
  
  byte[] a(List<becg> paramList)
  {
    cmd0x352.ReqBody localReqBody = new cmd0x352.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (becg)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (bdwu.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = bdwu.a().a();
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
  
  void b(bebv parambebv)
  {
    beck localbeck = parambebv.jdField_a_of_type_Beck;
    localbeck.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < parambebv.jdField_a_of_type_JavaUtilList.size())
    {
      becw localbecw = new becw();
      localbeck.jdField_a_of_type_JavaUtilList.add(i, localbecw);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebg
 * JD-Core Version:    0.7.0.1
 */