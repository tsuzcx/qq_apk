import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
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

public class bbak
  extends bbaj
{
  /* Error */
  void a(int paramInt, bbbi parambbbi, cmd0x352.ReqBody paramReqBody)
  {
    // Byte code:
    //   0: bipush 16
    //   2: istore 4
    //   4: aload_2
    //   5: checkcast 17	bbay
    //   8: astore 8
    //   10: new 19	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq
    //   13: dup
    //   14: invokespecial 20	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:<init>	()V
    //   17: astore 9
    //   19: aload 9
    //   21: iconst_1
    //   22: invokevirtual 24	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:setHasFlag	(Z)V
    //   25: aload 9
    //   27: getfield 28	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   30: aload 8
    //   32: getfield 32	bbay:d	Ljava/lang/String;
    //   35: invokestatic 38	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   38: invokevirtual 42	java/lang/Long:longValue	()J
    //   41: invokevirtual 48	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   44: aload 9
    //   46: getfield 52	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_pic_up_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   49: aload 8
    //   51: getfield 56	bbay:jdField_b_of_type_Int	I
    //   54: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   57: aload 8
    //   59: getfield 64	bbay:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   62: astore 7
    //   64: aload 7
    //   66: astore_2
    //   67: aload 7
    //   69: ldc 66
    //   71: invokevirtual 72	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   74: ifeq +10 -> 84
    //   77: aload 7
    //   79: iconst_1
    //   80: invokevirtual 76	java/lang/String:substring	(I)Ljava/lang/String;
    //   83: astore_2
    //   84: aload_2
    //   85: invokestatic 38	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   88: invokevirtual 42	java/lang/Long:longValue	()J
    //   91: lstore 5
    //   93: aload 9
    //   95: getfield 79	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   98: lload 5
    //   100: invokevirtual 48	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   103: aload 8
    //   105: getfield 81	bbay:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   108: ldc 83
    //   110: invokevirtual 87	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   113: astore_2
    //   114: aload 9
    //   116: getfield 91	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bytes_file_resid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   119: aload_2
    //   120: invokestatic 97	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   123: invokevirtual 102	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   126: aload 9
    //   128: getfield 106	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bool_address_book	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   131: aload 8
    //   133: getfield 109	bbay:jdField_a_of_type_Boolean	Z
    //   136: invokevirtual 113	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   139: ldc 115
    //   141: aload 8
    //   143: getfield 117	bbay:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   146: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: ifeq +151 -> 300
    //   152: aload 9
    //   154: getfield 124	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: iconst_2
    //   158: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   161: aload 9
    //   163: getfield 127	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_term	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   166: iconst_5
    //   167: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   170: aload 9
    //   172: getfield 106	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bool_address_book	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   175: aload 8
    //   177: getfield 109	bbay:jdField_a_of_type_Boolean	Z
    //   180: invokevirtual 113	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   183: aload 9
    //   185: getfield 130	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_platform_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   188: bipush 9
    //   190: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   193: aload 9
    //   195: getfield 133	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_bu_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   198: iconst_1
    //   199: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   202: aload 8
    //   204: getfield 135	bbay:jdField_a_of_type_Int	I
    //   207: istore_1
    //   208: iload_1
    //   209: ldc 136
    //   211: if_icmpne +136 -> 347
    //   214: invokestatic 141	azqb:a	()Z
    //   217: ifeq +122 -> 339
    //   220: bipush 16
    //   222: istore_1
    //   223: iconst_4
    //   224: istore 4
    //   226: aload 9
    //   228: getfield 144	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_url_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   231: iload 4
    //   233: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   236: aload 9
    //   238: getfield 147	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_url_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   241: iload_1
    //   242: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   245: aload 9
    //   247: getfield 150	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bytes_build_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   250: invokestatic 155	baws:a	()Ljava/lang/String;
    //   253: invokestatic 159	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   256: invokevirtual 102	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   259: aload 9
    //   261: getfield 162	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_transfer_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   264: aload 8
    //   266: getfield 164	bbay:jdField_c_of_type_Int	I
    //   269: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   272: aload_3
    //   273: getfield 170	tencent/im/cs/cmd0x352/cmd0x352$ReqBody:rpt_msg_getimg_url_req	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   276: aload 9
    //   278: invokevirtual 176	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   281: return
    //   282: astore_2
    //   283: aload_2
    //   284: invokevirtual 179	java/lang/Exception:printStackTrace	()V
    //   287: goto -184 -> 103
    //   290: astore_2
    //   291: aload_2
    //   292: invokevirtual 180	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   295: aconst_null
    //   296: astore_2
    //   297: goto -183 -> 114
    //   300: ldc 182
    //   302: aload 8
    //   304: getfield 117	bbay:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   307: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   310: ifeq +15 -> 325
    //   313: aload 9
    //   315: getfield 124	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   318: iconst_1
    //   319: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   322: goto -161 -> 161
    //   325: aload 9
    //   327: getfield 124	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   330: sipush 255
    //   333: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   336: goto -175 -> 161
    //   339: iconst_1
    //   340: istore_1
    //   341: iconst_4
    //   342: istore 4
    //   344: goto -118 -> 226
    //   347: iload_1
    //   348: iconst_1
    //   349: if_icmpne +13 -> 362
    //   352: bipush 6
    //   354: istore 4
    //   356: bipush 8
    //   358: istore_1
    //   359: goto -133 -> 226
    //   362: iload_1
    //   363: ldc 183
    //   365: if_icmpne +8 -> 373
    //   368: iconst_2
    //   369: istore_1
    //   370: goto -144 -> 226
    //   373: iconst_0
    //   374: istore_1
    //   375: iconst_0
    //   376: istore 4
    //   378: goto -152 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	bbak
    //   0	381	1	paramInt	int
    //   0	381	2	parambbbi	bbbi
    //   0	381	3	paramReqBody	cmd0x352.ReqBody
    //   2	375	4	i	int
    //   91	8	5	l	long
    //   62	16	7	str	String
    //   8	295	8	localbbay	bbay
    //   17	309	9	localGetImgUrlReq	tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlReq
    // Exception table:
    //   from	to	target	type
    //   57	64	282	java/lang/Exception
    //   67	84	282	java/lang/Exception
    //   84	103	282	java/lang/Exception
    //   103	114	290	java/io/UnsupportedEncodingException
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
        parambavr = ((cmd0x352.RspBody)new cmd0x352.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getimg_url_rsp.get();
        if ((parambavr != null) && (parambavr.size() != 0)) {
          break;
        }
        throw new Exception("resps null");
      }
      catch (Exception parambavr)
      {
        a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
      }
    }
    Iterator localIterator = parambavr.iterator();
    label272:
    while (localIterator.hasNext())
    {
      cmd0x352.GetImgUrlRsp localGetImgUrlRsp = (cmd0x352.GetImgUrlRsp)localIterator.next();
      try
      {
        localbbby = (bbby)localbbbm.jdField_a_of_type_JavaUtilList.get(0);
      }
      catch (Exception parambavr)
      {
        for (;;)
        {
          bbby localbbby;
          bbay localbbay;
          Object localObject2;
          label425:
          label435:
          label628:
          localObject1 = null;
          label659:
          label951:
          continue;
          parambavr = null;
          continue;
          if (localObject1 == null)
          {
            localObject1 = null;
            if (localObject2 == null) {
              localObject2 = null;
            }
          }
        }
      }
      try
      {
        localbbay = (bbay)localbbax.jdField_a_of_type_JavaUtilList.get(0);
        if (localbbby == null) {
          continue;
        }
        if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
          localbbby.d = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
        }
        i = localGetImgUrlRsp.uint32_result.get();
        if (i != 0) {
          break label951;
        }
        if (azqb.a())
        {
          parambavr = localGetImgUrlRsp.bytes_big_thumb_down_para.get();
          localObject1 = localGetImgUrlRsp.bytes_original_down_para.get();
          localObject2 = localGetImgUrlRsp.bytes_big_down_para.get();
          if (parambavr == null)
          {
            parambavr = null;
            break label1050;
            if (localbbay.jdField_a_of_type_Int != 65537) {
              break label628;
            }
            localbbby.jdField_a_of_type_JavaLangString = parambavr;
            if ((!localGetImgUrlRsp.rpt_uint32_down_ip.has()) || (localGetImgUrlRsp.rpt_uint32_down_ip.size() <= 0) || (!localGetImgUrlRsp.rpt_uint32_down_port.has()) || (localGetImgUrlRsp.rpt_uint32_down_port.size() <= 0)) {
              break label659;
            }
            parambavr = localGetImgUrlRsp.rpt_uint32_down_ip.get();
            localObject1 = localGetImgUrlRsp.rpt_uint32_down_port.get();
            i = 0;
            while (i < parambavr.size())
            {
              localObject2 = new bawy();
              ((bawy)localObject2).jdField_a_of_type_JavaLangString = bdqa.a(((Integer)parambavr.get(i)).intValue() & 0xFFFFFFFF);
              ((bawy)localObject2).jdField_a_of_type_Int = ((Integer)((List)localObject1).get(i)).intValue();
              localbbby.jdField_a_of_type_JavaUtilArrayList.add(i, localObject2);
              i += 1;
            }
          }
        }
        else
        {
          parambavr = localGetImgUrlRsp.bytes_thumb_down_para.get();
          break label396;
        }
        parambavr = parambavr.toStringUtf8();
        break label1050;
        localObject1 = ((ByteStringMicro)localObject1).toStringUtf8();
        break label1058;
        localObject2 = ((ByteStringMicro)localObject2).toStringUtf8();
        break label425;
        if (localbbay.jdField_a_of_type_Int == 1)
        {
          parambavr = (bavr)localObject2;
          break label435;
        }
        if (localbbay.jdField_a_of_type_Int != 131075) {
          break label1045;
        }
        parambavr = (bavr)localObject1;
        break label435;
        if ((localGetImgUrlRsp.rpt_msg_down_ip6.has()) && (localGetImgUrlRsp.rpt_msg_down_ip6.size() > 0))
        {
          parambavr = localGetImgUrlRsp.rpt_msg_down_ip6.get();
          i = 0;
          while (i < parambavr.size())
          {
            localObject1 = new bawy();
            ((bawy)localObject1).jdField_a_of_type_JavaLangString = Inet6Address.getByAddress(((cmd0x352.IPv6Info)parambavr.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
            ((bawy)localObject1).jdField_a_of_type_Int = ((cmd0x352.IPv6Info)parambavr.get(i)).uint32_port.get();
            ((bawy)localObject1).jdField_a_of_type_Boolean = true;
            localbbby.jdField_b_of_type_JavaUtilArrayList.add(i, localObject1);
            i += 1;
          }
        }
        if (localGetImgUrlRsp.bytes_down_domain.has())
        {
          parambavr = new bawy();
          parambavr.jdField_a_of_type_JavaLangString = localGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
          parambavr.jdField_a_of_type_Int = 80;
          localbbby.jdField_a_of_type_JavaUtilArrayList.add(parambavr);
          localbbby.jdField_b_of_type_JavaLangString = parambavr.jdField_a_of_type_JavaLangString;
        }
        if (localGetImgUrlRsp.uint32_https_url_flag.has()) {
          localbbby.jdField_a_of_type_Int = localGetImgUrlRsp.uint32_https_url_flag.get();
        }
        a(0, 0, "", "", localalwy, localbbby);
      }
      catch (Exception parambavr)
      {
        localObject1 = localbbby;
      }
      if (localObject1 != null)
      {
        a(-1, -9527, barf.a("P", -9529L), parambavr.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localalwy, (bbbz)localObject1);
        continue;
        if (bbal.a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambavq);
            return;
          }
        }
        if ((i == 201) && (QLog.isColorLevel())) {
          break label1024;
        }
      }
    }
    for (;;)
    {
      label396:
      a(-1, -9527, barf.a(i), barf.a(i), localalwy, localbbby);
      break label272;
      break;
      label1024:
      azqy.a("Download_C2C_Pic_Request_Error_Param_Check", localbbay.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(bbax parambbax)
  {
    if ((parambbax != null) && (parambbax.jdField_a_of_type_JavaUtilList != null) && (parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bavq localbavq = new bavq();
      localbavq.jdField_a_of_type_JavaLangString = "LongConn.OffPicDown";
      localbavq.jdField_a_of_type_ArrayOfByte = a(parambbax.jdField_a_of_type_JavaUtilList);
      localbavq.jdField_a_of_type_JavaLangObject = parambbax;
      localbavq.jdField_a_of_type_Bavp = this;
      a(parambbax, localbavq);
    }
  }
  
  byte[] a(List<bbbi> paramList)
  {
    cmd0x352.ReqBody localReqBody = new cmd0x352.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (bbbi)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (bavg.a().a())
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
      bbby localbbby = new bbby();
      localbbbm.jdField_a_of_type_JavaUtilList.add(i, localbbby);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbak
 * JD-Core Version:    0.7.0.1
 */