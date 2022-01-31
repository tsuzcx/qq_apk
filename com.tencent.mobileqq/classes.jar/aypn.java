import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.TmpPtt;

public class aypn
  extends aype
  implements bbzu, INetEventHandler
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  akav jdField_a_of_type_Akav = new aypo(this);
  private String jdField_a_of_type_JavaLangString;
  WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference = new WeakReference((QQAppInterface)this.a);
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private volatile boolean g;
  
  public aypn(ayvv paramayvv, aywa paramaywa)
  {
    super(paramayvv, paramaywa);
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getManager(3)).getProxyIp(4);
    this.jdField_a_of_type_Bgam = avbx.a();
    AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
  }
  
  private ayyx a()
  {
    ayyx localayyx = new ayyx();
    localayyx.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_b_of_type_JavaLangString;
    localayyx.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString;
    localayyx.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_d_of_type_JavaLangString;
    localayyx.f = this.jdField_a_of_type_Aywa.jdField_a_of_type_Int;
    localayyx.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localayyx.b = ((int)this.q);
    localayyx.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localMessageForPtt != null)
    {
      localayyx.jdField_c_of_type_Int = localMessageForPtt.voiceType;
      localayyx.jdField_a_of_type_Int = localMessageForPtt.voiceLength;
      localayyx.jdField_e_of_type_Int = localMessageForPtt.autoToText;
    }
    localayyx.jdField_d_of_type_Int = this.jdField_a_of_type_Aywa.jdField_n_of_type_Int;
    return localayyx;
  }
  
  public static byte[] a(MessageForPtt paramMessageForPtt)
  {
    ptt_reserve.ReserveStruct localReserveStruct = new ptt_reserve.ReserveStruct();
    localReserveStruct.uint32_change_voice.set(paramMessageForPtt.voiceChangeFlag);
    localReserveStruct.uint32_redpack_type.set(ahjm.a(paramMessageForPtt));
    localReserveStruct.uint32_autototext_voice.set(paramMessageForPtt.autoToText);
    if (paramMessageForPtt.hasSttTxt()) {
      localReserveStruct.bytes_voice_text_abs.set(ByteStringMicro.copyFrom(paramMessageForPtt.sttText.getBytes()));
    }
    paramMessageForPtt = ahjm.a(paramMessageForPtt);
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
    this.jdField_a_of_type_Ayqm.a();
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!j()))
    {
      d();
      return;
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_Aywa.i, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
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
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    String str = this.jdField_a_of_type_Aywa.i;
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
      aytl.a(str, false, false, i, l);
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
    byte[] arrayOfByte3 = bbmj.a((short)4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 2, arrayOfByte3.length);
    int i = arrayOfByte3.length + 2;
    arrayOfByte3 = bbmj.c(paramMessageForPtt.voiceType);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, i, arrayOfByte3.length);
    i += arrayOfByte3.length;
    arrayOfByte2[i] = 9;
    i += 1;
    arrayOfByte3 = bbmj.a((short)4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, i, 2);
    i += arrayOfByte3.length;
    paramMessageForPtt = bbmj.c(bbbd.a(paramMessageForPtt.voiceLength));
    System.arraycopy(paramMessageForPtt, 0, arrayOfByte2, i, paramMessageForPtt.length);
    i += paramMessageForPtt.length;
    arrayOfByte2[i] = 10;
    i += 1;
    paramMessageForPtt = bbmj.a((short)arrayOfByte1.length);
    System.arraycopy(paramMessageForPtt, 0, arrayOfByte2, i, 2);
    i += paramMessageForPtt.length;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, i, arrayOfByte1.length);
    i = arrayOfByte1.length;
    return arrayOfByte2;
  }
  
  private int d()
  {
    b("uiParam", this.jdField_a_of_type_Aywa.toString());
    String str = this.jdField_a_of_type_Aywa.i;
    if ((str == null) || ("".equals(str)))
    {
      b(9302, a(new Exception("filePath null")));
      d();
      return -1;
    }
    if (str != null)
    {
      this.jdField_b_of_type_JavaLangString = str;
      File localFile = new File(str);
      if (!localFile.exists())
      {
        b(9042, a(new Exception("sendFile not exist " + str)));
        d();
        return -1;
      }
      if (!localFile.canRead())
      {
        b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Ayqm.jdField_c_of_type_JavaLangString)));
        d();
        return -1;
      }
      this.jdField_e_of_type_JavaLangString = "amr";
      long l = localFile.length();
      this.jdField_a_of_type_Ayqm.jdField_a_of_type_Long = l;
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
  
  protected ayrv a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = super.a(paramArrayOfByte);
    paramArrayOfByte.d = true;
    return paramArrayOfByte;
  }
  
  public im_msg_body.RichText a()
  {
    return b();
  }
  
  /* Error */
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	aypn:jdField_a_of_type_Aywa	Laywa;
    //   6: iconst_1
    //   7: putfield 364	aywa:l	Z
    //   10: aload_0
    //   11: getfield 89	aypn:jdField_a_of_type_Aywa	Laywa;
    //   14: getfield 124	aywa:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 126	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 134	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 129	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 366	aypn:jdField_a_of_type_Boolean	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokespecial 368	aypn:d	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokespecial 370	aypn:b	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokespecial 368	aypn:d	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokespecial 370	aypn:b	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	aypn
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
    avbx.a(this.jdField_a_of_type_Bgam);
    if ((!paramBoolean) && (ayua.b(this.jdField_j_of_type_Int))) {}
    while ((this.h) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    long l2;
    Object localObject1;
    label215:
    long l1;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      l2 = (System.nanoTime() - this.k) / 1000000L;
      if (this.jdField_a_of_type_Aywa.jdField_n_of_type_Boolean)
      {
        this.jdField_a_of_type_Aypb.a(this.k);
        this.jdField_b_of_type_Aypb.a(this.k);
      }
      localObject1 = this.jdField_a_of_type_Aypb.a(1) + ";" + this.jdField_b_of_type_Aypb.a(2) + ";" + this.jdField_c_of_type_Aypb.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.f != null) {
        break label511;
      }
      localObject1 = this.jdField_l_of_type_JavaLangString;
      ((HashMap)localObject2).put("param_uuid", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Aywa.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.i));
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(avbv.a((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get())));
      }
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_pttNetDown", String.valueOf(this.jdField_a_of_type_Long / 1000000L));
        if (QLog.isColorLevel()) {
          QLog.d("weak_net", 2, String.valueOf(this.jdField_a_of_type_Long / 1000000L));
        }
      }
      aytl.a(paramBoolean, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, l2, this.q);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aywa.i))
      {
        localObject1 = (MessageForPtt)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        localObject2 = this.jdField_a_of_type_Aywa.i;
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
        aytl.a((String)localObject2, true, paramBoolean, i, l1);
      }
      if (!paramBoolean) {
        break label539;
      }
      axrl.a(BaseApplication.getContext()).a(null, b(), true, l2, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      b(paramBoolean, l2);
      l();
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
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.q));
      axrl.a(BaseApplication.getContext()).a(null, b(), false, l2, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    String str2 = this.jdField_c_of_type_JavaLangString;
    if (this.f == null) {}
    for (String str1 = this.jdField_l_of_type_JavaLangString;; str1 = this.f)
    {
      a("actRichMediaNetMonitor_pttUp", paramBoolean, paramInt, paramString1, paramString2, str2, str1);
      return;
    }
  }
  
  public void aR_()
  {
    super.aR_();
    if (!this.jdField_a_of_type_Aywa.l)
    {
      if (bbzp.a(this.jdField_a_of_type_Aywa.i, this)) {
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
    if ((this.jdField_a_of_type_Aywa.jdField_n_of_type_Boolean) && (this.jdField_a_of_type_Aywa.o))
    {
      i();
      f();
    }
    return super.b();
  }
  
  protected String b()
  {
    return "actC2CPttUpload";
  }
  
  protected im_msg_body.RichText b()
  {
    try
    {
      int i;
      if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Int == 0)
      {
        localObject1 = new im_msg_body.Ptt();
        ((im_msg_body.Ptt)localObject1).uint32_file_type.set(4);
        ((im_msg_body.Ptt)localObject1).uint64_src_uin.set(Long.parseLong(this.jdField_a_of_type_Aywa.jdField_b_of_type_JavaLangString));
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject2 = (ayuo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          ((im_msg_body.Ptt)localObject1).uint32_server_ip.set(ayrd.a(((ayuo)localObject2).jdField_a_of_type_JavaLangString));
          ((im_msg_body.Ptt)localObject1).uint32_server_port.set(((ayuo)localObject2).jdField_a_of_type_Int);
        }
        localObject2 = new im_msg_body.Elem();
        Object localObject3 = new im_msg_body.ElemFlags2();
        if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
        {
          i = axas.a((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin());
          ((im_msg_body.ElemFlags2)localObject3).uint32_vip_status.set(i);
        }
        ((im_msg_body.Elem)localObject2).elem_flags2.set((MessageMicro)localObject3);
        ((im_msg_body.Ptt)localObject1).bool_valid.set(true);
        ((im_msg_body.Ptt)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.f));
        ((im_msg_body.Ptt)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
        ((im_msg_body.Ptt)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
        ((im_msg_body.Ptt)localObject1).uint32_file_size.set((int)this.q);
        localObject3 = b((MessageForPtt)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
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
      ((im_msg_body.TmpPtt)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
      ((im_msg_body.TmpPtt)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
      ((im_msg_body.TmpPtt)localObject1).uint32_file_size.set((int)this.q);
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
      {
        localObject2 = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin();
        i = axas.a((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get(), (String)localObject2);
        ((im_msg_body.TmpPtt)localObject1).uint32_user_type.set(i);
      }
      ((im_msg_body.TmpPtt)localObject1).uint64_ptt_times.set(QQRecorder.a(this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
      if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Int == 1008) {
        ((im_msg_body.TmpPtt)localObject1).uint32_busi_type.set(3);
      }
      Object localObject2 = a((MessageForPtt)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
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
    if (!this.jdField_a_of_type_Aywa.l) {
      return 0;
    }
    return d();
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_Aywa.l) {
      return super.c();
    }
    return 7000L;
  }
  
  void d()
  {
    super.d();
    d(1005);
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo != null)
    {
      auop localauop = new auop();
      localauop.jdField_a_of_type_Int = -1;
      localauop.b = this.jdField_j_of_type_Int;
      localauop.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo.b(localauop);
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (this.jdField_a_of_type_Aywa.jdField_n_of_type_Boolean)) {
      avco.a((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(a());
    }
  }
  
  public void d(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
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
        localMessageRecord = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
        b("updateDb", "findmsgbyMsgId,need fix");
        break;
      } while (!(localMessageRecord instanceof MessageForPtt));
      MessageForPtt localMessageForPtt = (MessageForPtt)localMessageRecord;
      if (!this.jdField_a_of_type_Aywa.jdField_n_of_type_Boolean) {
        localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.jdField_a_of_type_Aywa.i);
      }
      localMessageForPtt.fileSize = this.q;
      localMessageForPtt.urlAtServer = this.f;
      localMessageForPtt.itemType = 2;
      localMessageForPtt.md5 = this.jdField_c_of_type_JavaLangString;
      localMessageForPtt.serial();
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
        ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForPtt.msgData);
      }
    } while ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (localMessageRecord == null) || (!(localMessageRecord instanceof MessageForPtt)) || (!((ayah)((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getManager(17)).b((MessageForPtt)localMessageRecord)));
    axqw.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
    ((ayae)((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getManager(17)).a((MessageForPtt)localMessageRecord, 2);
  }
  
  void e()
  {
    super.e();
    d(true);
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
      this.jdField_c_of_type_Aypb.a();
      localObject1 = b();
      if (localObject1 == null)
      {
        a(9360, "constructpberror", null, this.jdField_c_of_type_Aypb);
        d();
        return;
      }
      if (this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        localMessageRecord = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
      for (;;)
      {
        if ((localMessageRecord instanceof MessageForPtt)) {
          break label173;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("accost_ptt", 4, "mr not ptt?......");
        }
        a(9360, "constructpberror", null, this.jdField_c_of_type_Aypb);
        d();
        return;
        if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
          break;
        }
        localMessageRecord = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
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
        a(9366, "illegal app", null, this.jdField_c_of_type_Aypb);
        d();
        return;
      }
      if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo != null)
      {
        d(true);
        this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo.a((im_msg_body.RichText)localObject1);
        return;
      }
    } while ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null));
    if (ahjm.a(localMessageRecord))
    {
      localObject2 = ahjm.a();
      akav localakav = this.jdField_a_of_type_Akav;
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      if (this.f == null) {}
      for (localObject1 = this.jdField_l_of_type_JavaLangString;; localObject1 = this.f)
      {
        ((ahjm)localObject2).a(localMessageRecord, localakav, 0L, arrayOfByte, (String)localObject1, this);
        return;
      }
    }
    ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).a().b(localMessageRecord, this.jdField_a_of_type_Akav);
  }
  
  public void g()
  {
    i = 500;
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
    }
    this.jdField_b_of_type_Aypb.a();
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {}
    do
    {
      return;
      long l1 = SystemClock.uptimeMillis();
      localayyx = a();
      cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
      localReqBody.uint32_cmd.set(500);
      Object localObject1 = localReqBody.uint32_seq;
      int j = jdField_a_of_type_Int;
      jdField_a_of_type_Int = j + 1;
      ((PBUInt32Field)localObject1).set(j);
      localReqBody.uint32_business_id.set(17);
      localReqBody.uint32_client_type.set(104);
      cmd0x346.ApplyUploadReq localApplyUploadReq = new cmd0x346.ApplyUploadReq();
      localApplyUploadReq.uint64_sender_uin.set(Long.parseLong(localayyx.jdField_c_of_type_JavaLangString));
      try
      {
        localObject2 = localayyx.jdField_d_of_type_JavaLangString;
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
          if (localayyx.jdField_a_of_type_Boolean)
          {
            continue;
            localException.str_dst_phonenum.set(localayyx.jdField_d_of_type_JavaLangString);
            i = 102;
            continue;
            i = 104;
            continue;
            i = 104;
            continue;
            i = 105;
            continue;
            i = 0;
            continue;
            i = 0;
            continue;
            i = 0;
            continue;
            i = 101;
            continue;
            i = 103;
            continue;
            i = 114;
            continue;
            if (localayyx.f == 9999) {
              localException.uint32_file_type.set(102);
            }
          }
        }
      }
      localApplyUploadReq.uint32_file_type.set(2);
      localApplyUploadReq.str_file_name.set(localayyx.jdField_a_of_type_JavaLangString);
      localApplyUploadReq.uint64_file_size.set(localayyx.b);
      localApplyUploadReq.bytes_10m_md5.set(ByteStringMicro.copyFrom(localayyx.jdField_a_of_type_ArrayOfByte));
      localReqBody.msg_apply_upload_req.set(localApplyUploadReq);
      localObject1 = new cmd0x346.ExtensionReq();
      ((cmd0x346.ExtensionReq)localObject1).uint64_id.set(3L);
      ((cmd0x346.ExtensionReq)localObject1).uint32_ptt_format.set(localayyx.jdField_c_of_type_Int);
      ((cmd0x346.ExtensionReq)localObject1).uint32_ptt_time.set(localayyx.jdField_a_of_type_Int);
      j = ayxz.a();
      ((cmd0x346.ExtensionReq)localObject1).uint32_net_type.set(j);
      ((cmd0x346.ExtensionReq)localObject1).uint32_voice_type.set(localayyx.jdField_d_of_type_Int);
      if (QLog.isColorLevel())
      {
        QLog.d("RecordParams", 2, "C2CPttUp: panel[" + localayyx.jdField_d_of_type_Int + "] type[" + localayyx.jdField_c_of_type_Int + "] length[" + localayyx.jdField_a_of_type_Int + "] size[" + localayyx.b + "]");
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "C2CPttUp: net[" + j + "]");
        }
      }
      switch (localayyx.f)
      {
      default: 
        i = 0;
        ((cmd0x346.ExtensionReq)localObject1).uint64_type.set(i);
        if (localayyx.f != 1008) {
          break label961;
        }
        ((cmd0x346.ExtensionReq)localObject1).uint32_file_type.set(3);
        localReqBody.msg_extension_req.set((MessageMicro)localObject1);
        localObject1 = localReqBody.toByteArray();
        localObject2 = new aypp(this, l1);
        this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getCurrentAccountUin(), 26, this.jdField_b_of_type_JavaLangString, (int)this.r, this.jdField_a_of_type_ArrayOfByte, (ITransactionCallback)localObject2, (byte[])localObject1, false);
        localObject1 = new aypq(this);
        this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cbForReport = ((ITransCallbackForReport)localObject1);
        i = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Aywa.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_l_of_type_JavaLangString + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 26);
        }
        break;
      }
    } while (i == 0);
    a(i, "sendFileByBDH SubmitError.", "", this.jdField_b_of_type_Aypb);
    d();
  }
  
  protected void n()
  {
    if ((this.jdField_a_of_type_Aysw != null) && ((this.jdField_a_of_type_Aysw instanceof ayrv))) {
      ((ayrv)this.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("pttCu", ((ayrv)this.jdField_a_of_type_Aysw).jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aypn
 * JD-Core Version:    0.7.0.1
 */