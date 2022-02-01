import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor.2;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.ProxyIpManager;
import mqq.util.WeakReference;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.TmpPtt;

public class bese
  extends beru
  implements bilj, INetEventHandler
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  aocj jdField_a_of_type_Aocj = new besf(this);
  private String jdField_a_of_type_JavaLangString;
  WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference = new WeakReference((QQAppInterface)this.a);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public bese(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_Bluw = bama.a();
    AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
  }
  
  private bfbe a()
  {
    bfbe localbfbe = new bfbe();
    localbfbe.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.b;
    localbfbe.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
    localbfbe.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_d_of_type_JavaLangString;
    localbfbe.f = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbfbe.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbfbe.b = ((int)this.q);
    localbfbe.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localMessageForPtt != null)
    {
      localbfbe.jdField_c_of_type_Int = localMessageForPtt.voiceType;
      localbfbe.jdField_a_of_type_Int = localMessageForPtt.voiceLength;
      localbfbe.jdField_e_of_type_Int = localMessageForPtt.autoToText;
    }
    localbfbe.jdField_d_of_type_Int = this.jdField_a_of_type_Beyg.n;
    return localbfbe;
  }
  
  public static byte[] a(MessageForPtt paramMessageForPtt)
  {
    ptt_reserve.ReserveStruct localReserveStruct = new ptt_reserve.ReserveStruct();
    localReserveStruct.uint32_change_voice.set(paramMessageForPtt.voiceChangeFlag);
    localReserveStruct.uint32_redpack_type.set(aljb.a(paramMessageForPtt));
    localReserveStruct.uint32_autototext_voice.set(paramMessageForPtt.autoToText);
    if (paramMessageForPtt.hasSttTxt()) {
      localReserveStruct.bytes_voice_text_abs.set(ByteStringMicro.copyFrom(paramMessageForPtt.sttText.getBytes()));
    }
    paramMessageForPtt = aljb.a(paramMessageForPtt);
    if (paramMessageForPtt != null) {
      localReserveStruct.bytes_redpack_score_id.set(paramMessageForPtt);
    }
    return localReserveStruct.toByteArray();
  }
  
  private void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    this.jdField_a_of_type_Bete.a();
    if ((this.jdField_b_of_type_ArrayOfByte == null) && (!h()))
    {
      d();
      return;
    }
    if (this.jdField_b_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_b_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_Beyg.i, "r");
        if (this.jdField_b_of_type_JavaIoRandomAccessFile == null)
        {
          b(9303, "read file error");
          d();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_b_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    String str = this.jdField_a_of_type_Beyg.i;
    int i;
    if (localMessageForPtt == null)
    {
      i = 0;
      if (localMessageForPtt != null) {
        break label158;
      }
    }
    label158:
    for (long l = 0L;; l = localMessageForPtt.fileSize)
    {
      bewa.a(str, false, false, i, l);
      g();
      return;
      i = localMessageForPtt.voiceChangeFlag;
      break;
    }
  }
  
  public static byte[] b(MessageForPtt paramMessageForPtt)
  {
    byte[] arrayOfByte1 = a(paramMessageForPtt);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 3 + 15];
    arrayOfByte2[0] = 3;
    arrayOfByte2[1] = 8;
    byte[] arrayOfByte3 = bhvd.a((short)4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 2, arrayOfByte3.length);
    int i = arrayOfByte3.length + 2;
    arrayOfByte3 = bhvd.c(paramMessageForPtt.voiceType);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, i, arrayOfByte3.length);
    i += arrayOfByte3.length;
    arrayOfByte2[i] = 9;
    i += 1;
    arrayOfByte3 = bhvd.a((short)4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, i, 2);
    i += arrayOfByte3.length;
    paramMessageForPtt = bhvd.c(bhjx.a(paramMessageForPtt.voiceLength));
    System.arraycopy(paramMessageForPtt, 0, arrayOfByte2, i, paramMessageForPtt.length);
    i += paramMessageForPtt.length;
    arrayOfByte2[i] = 10;
    i += 1;
    paramMessageForPtt = bhvd.a((short)arrayOfByte1.length);
    System.arraycopy(paramMessageForPtt, 0, arrayOfByte2, i, 2);
    i += paramMessageForPtt.length;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, i, arrayOfByte1.length);
    i = arrayOfByte1.length;
    return arrayOfByte2;
  }
  
  private int d()
  {
    b("uiParam", this.jdField_a_of_type_Beyg.toString());
    String str = this.jdField_a_of_type_Beyg.i;
    if ((str == null) || ("".equals(str)))
    {
      b(9302, a(new Exception("filePath null")));
      d();
      return -1;
    }
    if (str != null)
    {
      this.jdField_a_of_type_JavaLangString = str;
      File localFile = new File(str);
      if (!localFile.exists())
      {
        b(9042, a(new Exception("sendFile not exist " + str)));
        d();
        return -1;
      }
      if (!localFile.canRead())
      {
        b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Bete.jdField_c_of_type_JavaLangString)));
        d();
        return -1;
      }
      this.jdField_e_of_type_JavaLangString = "amr";
      long l = localFile.length();
      this.jdField_a_of_type_Bete.jdField_a_of_type_Long = l;
      this.q = l;
      if (l <= 0L)
      {
        b(9071, a(new Exception("file size 0 " + str)));
        d();
        return -1;
      }
    }
    return 0;
  }
  
  public int a()
  {
    AppNetConnInfo.unregisterNetEventHandler(this);
    return super.a();
  }
  
  protected beum a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = super.a(paramArrayOfByte);
    paramArrayOfByte.d = true;
    return paramArrayOfByte;
  }
  
  public im_msg_body.RichText a()
  {
    return b();
  }
  
  public void a(bfbe parambfbe, cmd0x346.ExtensionReq paramExtensionReq)
  {
    int j = 0;
    int i = j;
    switch (parambfbe.f)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      paramExtensionReq.uint64_type.set(i);
      return;
      i = j;
      if (parambfbe.jdField_a_of_type_Boolean)
      {
        i = 500;
        continue;
        i = 102;
        paramExtensionReq.str_dst_phonenum.set(parambfbe.jdField_d_of_type_JavaLangString);
        continue;
        i = 104;
        continue;
        i = 104;
        continue;
        i = 105;
        continue;
        i = 101;
        continue;
        i = 103;
        continue;
        i = 100;
        continue;
        i = 114;
        continue;
        i = 130;
      }
    }
  }
  
  /* Error */
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 88	bese:jdField_a_of_type_Beyg	Lbeyg;
    //   6: iconst_1
    //   7: putfield 381	beyg:m	Z
    //   10: aload_0
    //   11: getfield 88	bese:jdField_a_of_type_Beyg	Lbeyg;
    //   14: getfield 124	beyg:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 126	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 134	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 129	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 382	bese:jdField_a_of_type_Boolean	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokespecial 384	bese:d	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokespecial 386	bese:b	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokespecial 384	bese:d	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokespecial 386	bese:b	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	bese
    //   0	73	1	paramString	String
    //   0	73	2	paramInt1	int
    //   0	73	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	50	68	finally
    //   50	52	68	finally
    //   53	65	68	finally
    //   69	71	68	finally
  }
  
  protected void a(boolean paramBoolean)
  {
    bama.a(this.jdField_a_of_type_Bluw);
    if ((!paramBoolean) && (bewk.a(this.jdField_k_of_type_Int))) {}
    while ((this.jdField_j_of_type_Boolean) || ((paramBoolean) && ((this.n & 0x2) > 0)) || ((!paramBoolean) && ((this.n & 0x1) > 0))) {
      return;
    }
    int j = this.n;
    int i;
    long l2;
    Object localObject1;
    label215:
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.n = (i | j);
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      l2 = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      if (this.jdField_a_of_type_Beyg.o)
      {
        this.jdField_a_of_type_Berr.a(this.jdField_k_of_type_Long);
        this.jdField_b_of_type_Berr.a(this.jdField_k_of_type_Long);
      }
      localObject1 = this.jdField_a_of_type_Berr.a(1) + ";" + this.jdField_b_of_type_Berr.a(2) + ";" + this.jdField_c_of_type_Berr.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.f != null) {
        break label511;
      }
      localObject1 = this.jdField_l_of_type_JavaLangString;
      ((HashMap)localObject2).put("param_uuid", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_k_of_type_Boolean));
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(baly.a((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get())));
      }
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_pttNetDown", String.valueOf(this.jdField_a_of_type_Long / 1000000L));
        if (QLog.isColorLevel()) {
          QLog.d("weak_net", 2, String.valueOf(this.jdField_a_of_type_Long / 1000000L));
        }
      }
      bewa.a(paramBoolean, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, l2, this.q);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Beyg.i))
      {
        localObject1 = (MessageForPtt)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        localObject2 = this.jdField_a_of_type_Beyg.i;
        if (localObject1 != null) {
          break label520;
        }
        i = 0;
        label439:
        if (localObject1 != null) {
          break label529;
        }
        l1 = 0L;
        label447:
        bewa.a((String)localObject2, true, paramBoolean, i, l1);
      }
      if (!paramBoolean) {
        break label539;
      }
      b(true, l2);
      bdmc.a(BaseApplication.getContext()).a(null, c(), true, l2, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      m();
      AppNetConnInfo.unregisterNetEventHandler(this);
      return;
      i = 1;
      break;
      label511:
      localObject1 = this.f;
      break label215;
      label520:
      i = ((MessageForPtt)localObject1).voiceChangeFlag;
      break label439;
      label529:
      l1 = ((MessageForPtt)localObject1).fileSize;
      break label447;
      label539:
      if (this.jdField_k_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_k_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.q));
      b(false, l2);
      bdmc.a(BaseApplication.getContext()).a(null, c(), false, l2, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public void a(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, long paramLong)
  {
    long l1 = SystemClock.uptimeMillis();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (cmd0x346.RspBody)new cmd0x346.RspBody().mergeFrom(paramArrayOfByte);
        if ((paramArrayOfByte.msg_apply_upload_rsp != null) && (paramArrayOfByte.msg_apply_upload_rsp.get() != null))
        {
          paramArrayOfByte = (cmd0x346.ApplyUploadRsp)paramArrayOfByte.msg_apply_upload_rsp.get();
          if ((paramArrayOfByte.bytes_uuid != null) && (paramArrayOfByte.bytes_uuid.get() != null))
          {
            paramArrayOfByte = paramArrayOfByte.bytes_uuid.get().toStringUtf8();
            if (paramArrayOfByte.length() > 0)
            {
              this.f = paramArrayOfByte;
              if (QLog.isColorLevel()) {
                QLog.d("C2CPicUploadProcessor", 2, "set uuid from BDH ");
              }
            }
          }
        }
        l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
        l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
        l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
        l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - paramLong) + "ms ,fileSize:" + this.jdField_a_of_type_Bete.jdField_a_of_type_Long + " transInfo:" + (String)paramHashMap.get("rep_bdhTrans"));
        }
        b(paramHashMap);
        this.jdField_b_of_type_Berr.b();
        this.jdField_b_of_type_Berr.jdField_a_of_type_Int = 1;
        this.s = this.q;
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          long l2;
          long l3;
          long l4;
          long l5;
          if ((!this.jdField_a_of_type_Beyg.o) || (this.jdField_a_of_type_Beyg.p))
          {
            j();
            f();
            if (this.jdField_a_of_type_Beyg.o)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("PttPreSendManager", 4, "presend file success, can send msg, direct send");
              }
              if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
                bamr.a((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(b());
              }
            }
            ThreadManager.post(new C2CPttUploadProcessor.2(this, l2, l3, l4, l5), 5, null, true);
            this.jdField_a_of_type_Bete.a();
            if (QLog.isColorLevel()) {
              QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
            }
            String str1 = (String)paramHashMap.get("ip");
            paramHashMap = (String)paramHashMap.get("port");
            String str2 = this.jdField_c_of_type_JavaLangString;
            if (this.f == null)
            {
              paramArrayOfByte = this.jdField_l_of_type_JavaLangString;
              a("actRichMediaNetMonitor_pttUp", true, 0, str1, paramHashMap, str2, paramArrayOfByte, null);
              return;
              paramArrayOfByte = paramArrayOfByte;
              paramArrayOfByte.printStackTrace();
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("C2CPicUploadProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
            }
          }
          else
          {
            this.jdField_a_of_type_Beyg.p = true;
            if (!QLog.isDevelopLevel()) {
              continue;
            }
            QLog.d("PttPreSendManager", 4, "presend file success, wait for send msg");
            continue;
          }
          paramArrayOfByte = this.f;
        }
        finally {}
      }
    }
  }
  
  public void aN_()
  {
    super.aN_();
    if (!this.jdField_a_of_type_Beyg.m)
    {
      if (bile.a(this.jdField_a_of_type_Beyg.i, this)) {
        try
        {
          if (this.jdField_a_of_type_Boolean)
          {
            d(1001);
            this.jdField_a_of_type_Boolean = true;
          }
          return;
        }
        finally {}
      }
      if (d() == 0) {
        b(false);
      }
    }
    else
    {
      b(false);
    }
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Beyg.o) && (this.jdField_a_of_type_Beyg.p))
    {
      j();
      f();
    }
    return super.b();
  }
  
  protected im_msg_body.RichText b()
  {
    try
    {
      int i;
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 0)
      {
        localObject1 = new im_msg_body.Ptt();
        ((im_msg_body.Ptt)localObject1).uint32_file_type.set(4);
        ((im_msg_body.Ptt)localObject1).uint64_src_uin.set(Long.parseLong(this.jdField_a_of_type_Beyg.b));
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject2 = (bewy)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          ((im_msg_body.Ptt)localObject1).uint32_server_ip.set(betv.a(((bewy)localObject2).jdField_a_of_type_JavaLangString));
          ((im_msg_body.Ptt)localObject1).uint32_server_port.set(((bewy)localObject2).jdField_a_of_type_Int);
        }
        localObject2 = new im_msg_body.Elem();
        Object localObject3 = new im_msg_body.ElemFlags2();
        if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
        {
          i = bcsa.a((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin());
          ((im_msg_body.ElemFlags2)localObject3).uint32_vip_status.set(i);
        }
        ((im_msg_body.Elem)localObject2).elem_flags2.set((MessageMicro)localObject3);
        ((im_msg_body.Ptt)localObject1).bool_valid.set(true);
        ((im_msg_body.Ptt)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.f));
        ((im_msg_body.Ptt)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_ArrayOfByte));
        ((im_msg_body.Ptt)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
        ((im_msg_body.Ptt)localObject1).uint32_file_size.set((int)this.q);
        localObject3 = b((MessageForPtt)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        if (localObject3 != null) {
          ((im_msg_body.Ptt)localObject1).bytes_reserve.set(ByteStringMicro.copyFrom((byte[])localObject3));
        }
        localObject3 = new im_msg_body.RichText();
        ((im_msg_body.RichText)localObject3).ptt.set((MessageMicro)localObject1);
        ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject2);
        return localObject3;
      }
      Object localObject1 = new im_msg_body.TmpPtt();
      ((im_msg_body.TmpPtt)localObject1).uint32_file_type.set(4);
      ((im_msg_body.TmpPtt)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.f));
      ((im_msg_body.TmpPtt)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_ArrayOfByte));
      ((im_msg_body.TmpPtt)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
      ((im_msg_body.TmpPtt)localObject1).uint32_file_size.set((int)this.q);
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
      {
        localObject2 = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin();
        i = bcsa.a((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get(), (String)localObject2);
        ((im_msg_body.TmpPtt)localObject1).uint32_user_type.set(i);
      }
      ((im_msg_body.TmpPtt)localObject1).uint64_ptt_times.set(QQRecorder.a(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 1008) {
        ((im_msg_body.TmpPtt)localObject1).uint32_busi_type.set(3);
      }
      Object localObject2 = a((MessageForPtt)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      if (localObject2 != null) {
        ((im_msg_body.TmpPtt)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      if (localObject2 != null) {
        ((im_msg_body.TmpPtt)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      localObject2 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject2).tmp_ptt.set((MessageMicro)localObject1);
      return localObject2;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CPicUploadProcessor", 2, "Construct richtext error");
      }
      localException.printStackTrace();
    }
    return null;
  }
  
  public int c()
  {
    super.c();
    if (!this.jdField_a_of_type_Beyg.m) {
      return 0;
    }
    return d();
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_Beyg.m) {
      return super.c();
    }
    return 7000L;
  }
  
  protected String c()
  {
    return "actC2CPttUpload";
  }
  
  public void c(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageRecord != null) {
        break label101;
      }
      b("updateDb", "msg null");
    }
    label101:
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null));
        localMessageRecord = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
        b("updateDb", "findmsgbyMsgId,need fix");
        break;
      } while (!(localMessageRecord instanceof MessageForPtt));
      MessageForPtt localMessageForPtt = (MessageForPtt)localMessageRecord;
      if (!this.jdField_a_of_type_Beyg.o) {
        localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.jdField_a_of_type_Beyg.i);
      }
      localMessageForPtt.fileSize = this.q;
      localMessageForPtt.urlAtServer = this.f;
      localMessageForPtt.itemType = 2;
      localMessageForPtt.md5 = this.jdField_c_of_type_JavaLangString;
      localMessageForPtt.serial();
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
        ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForPtt.msgData);
      }
    } while ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (localMessageRecord == null) || (!(localMessageRecord instanceof MessageForPtt)) || (!((bduh)((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getManager(17)).b((MessageForPtt)localMessageRecord)));
    bdll.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
    ((bdug)((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getManager(17)).a((MessageForPtt)localMessageRecord, 2);
  }
  
  void d()
  {
    super.d();
    d(1005);
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null)
    {
      azrh localazrh = new azrh();
      localazrh.jdField_a_of_type_Int = -1;
      localazrh.b = this.jdField_k_of_type_Int;
      localazrh.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.b(localazrh);
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (this.jdField_a_of_type_Beyg.o)) {
      bamr.a((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(b());
    }
  }
  
  void e()
  {
    super.e();
    c(true);
    d(1003);
  }
  
  void f()
  {
    if (!f()) {}
    Object localObject1;
    MessageRecord localMessageRecord;
    label173:
    Object localObject2;
    do
    {
      return;
      this.jdField_c_of_type_Berr.a();
      localObject1 = b();
      if (localObject1 == null)
      {
        a(9360, "constructpberror", null, this.jdField_c_of_type_Berr);
        d();
        return;
      }
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        localMessageRecord = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
      for (;;)
      {
        if ((localMessageRecord instanceof MessageForPtt)) {
          break label173;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("accost_ptt", 4, "mr not ptt?......");
        }
        a(9360, "constructpberror", null, this.jdField_c_of_type_Berr);
        d();
        return;
        if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
          break;
        }
        localMessageRecord = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
        b("updateDb", "findmsgbyMsgId,need fix");
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("accost_ptt", 4, "mr is ptt......");
      }
      localObject2 = (MessageForPtt)localMessageRecord;
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---sendC2CMsg voiceType：" + ((MessageForPtt)localObject2).voiceType + " voiceLengh:" + ((MessageForPtt)localObject2).voiceLength);
      }
      ((MessageForPtt)localObject2).richText = ((im_msg_body.RichText)localObject1);
      if (!e())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_Berr);
        d();
        return;
      }
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null)
      {
        c(true);
        this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.a((im_msg_body.RichText)localObject1);
        return;
      }
    } while ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null));
    if (aljb.a(localMessageRecord))
    {
      localObject2 = aljb.a();
      aocj localaocj = this.jdField_a_of_type_Aocj;
      byte[] arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
      if (this.f == null) {}
      for (localObject1 = this.jdField_l_of_type_JavaLangString;; localObject1 = this.f)
      {
        ((aljb)localObject2).a(localMessageRecord, localaocj, 0L, arrayOfByte, (String)localObject1, this);
        return;
      }
    }
    ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a().b(localMessageRecord, this.jdField_a_of_type_Aocj);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
    }
    this.jdField_b_of_type_Berr.a();
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {}
    int i;
    do
    {
      return;
      long l1 = SystemClock.uptimeMillis();
      localbfbe = a();
      cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
      localReqBody.uint32_cmd.set(500);
      Object localObject1 = localReqBody.uint32_seq;
      i = jdField_a_of_type_Int;
      jdField_a_of_type_Int = i + 1;
      ((PBUInt32Field)localObject1).set(i);
      localReqBody.uint32_business_id.set(17);
      localReqBody.uint32_client_type.set(104);
      cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
      localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localbfbe.jdField_c_of_type_JavaLangString));
      try
      {
        localObject2 = localbfbe.jdField_d_of_type_JavaLangString;
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("+")) {
          localObject1 = ((String)localObject2).substring(1);
        }
        long l2 = Long.valueOf((String)localObject1).longValue();
        localApplyUploadReq.uint64_recver_uin.set(l2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          localException.printStackTrace();
          continue;
          if (localbfbe.f == 9999) {
            localException.uint32_file_type.set(102);
          }
        }
      }
      localApplyUploadReq.uint32_file_type.set(2);
      localApplyUploadReq.str_file_name.set(localbfbe.jdField_a_of_type_JavaLangString);
      localApplyUploadReq.uint64_file_size.set(localbfbe.b);
      localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localbfbe.jdField_a_of_type_ArrayOfByte));
      localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
      localObject1 = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject1).uint64_id.set(3L);
      ((cmd0x346.ExtensionReq)localObject1).uint32_ptt_format.set(localbfbe.jdField_c_of_type_Int);
      ((cmd0x346.ExtensionReq)localObject1).uint32_ptt_time.set(localbfbe.jdField_a_of_type_Int);
      i = bfae.a();
      ((cmd0x346.ExtensionReq)localObject1).uint32_net_type.set(i);
      ((cmd0x346.ExtensionReq)localObject1).uint32_voice_type.set(localbfbe.jdField_d_of_type_Int);
      if (QLog.isColorLevel())
      {
        QLog.d("RecordParams", 2, "C2CPttUp: panel[" + localbfbe.jdField_d_of_type_Int + "] type[" + localbfbe.jdField_c_of_type_Int + "] length[" + localbfbe.jdField_a_of_type_Int + "] size[" + localbfbe.b + "]");
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "C2CPttUp: net[" + i + "]");
        }
      }
      a(localbfbe, (cmd0x346.ExtensionReq)localObject1);
      if (localbfbe.f != 1008) {
        break;
      }
      ((cmd0x346.ExtensionReq)localObject1).uint32_file_type.set(3);
      localReqBody.msg_extension_req.set((MessageMicro)localObject1);
      localObject1 = localReqBody.toByteArray();
      localObject2 = new besg(this, l1);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin(), 26, this.jdField_a_of_type_JavaLangString, (int)this.r, this.jdField_b_of_type_ArrayOfByte, (ITransactionCallback)localObject2, (byte[])localObject1, false);
      localObject1 = new besh(this);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cbForReport = ((ITransCallbackForReport)localObject1);
      i = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_l_of_type_JavaLangString + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 26);
      }
    } while (i == 0);
    a(i, "sendFileByBDH SubmitError.", "", this.jdField_b_of_type_Berr);
    d();
  }
  
  protected void o()
  {
    if ((this.jdField_a_of_type_Bevl != null) && ((this.jdField_a_of_type_Bevl instanceof beum))) {
      ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCu", ((beum)this.jdField_a_of_type_Bevl).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_b_of_type_Long > 0L) {
        this.jdField_a_of_type_Long += System.nanoTime() - this.jdField_b_of_type_Long;
      }
    }
    for (this.jdField_b_of_type_Long = 0L;; this.jdField_b_of_type_Long = System.nanoTime())
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bese
 * JD-Core Version:    0.7.0.1
 */