import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x7a0.oidb_0x7a0.LoginSig;
import tencent.im.oidb.cmd0x7a0.oidb_0x7a0.ReqBody;
import tencent.im.oidb.cmd0x7a0.oidb_0x7a0.RspBody;
import tencent.im.oidb.cmd0x7a1.oidb_0x7a1.ReqBody;
import tencent.im.oidb.cmd0x7a1.oidb_0x7a1.RspBody;
import tencent.im.oidb.cmd0x7a2.oidb_0x7a2.ReqBody;
import tencent.im.oidb.cmd0x7a2.oidb_0x7a2.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aohz
  extends anud
{
  aohz(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  @Nullable
  private oidb_sso.OIDBSSOPkg a(int paramInt1, byte[] paramArrayOfByte, bdxd parambdxd, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4)
  {
    if (paramInt1 != 1000) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramArrayOfByte = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom(paramArrayOfByte);
        if ((!paramArrayOfByte.uint32_result.has()) || (paramArrayOfByte.uint32_result.get() != 0))
        {
          a("12008", paramString1, paramString2, paramString3, false);
          parambdxd.jdField_a_of_type_Int = 1001;
          notifyUI(paramInt2, false, parambdxd);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "getPkg !pkg.uint32_result.has() || pkg.uint32_result.get() != 0");
          }
          return null;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "getPkg InvalidProtocolBufferMicroException");
          }
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = localOIDBSSOPkg;
        }
        if (paramArrayOfByte.bytes_bodybuffer.has())
        {
          paramString1 = paramArrayOfByte;
          if (paramArrayOfByte.bytes_bodybuffer.get() != null) {}
        }
        else
        {
          a("12008", paramString4, paramString2, paramString3, false);
          parambdxd.jdField_a_of_type_Int = 1000;
          notifyUI(paramInt2, false, parambdxd);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "getPkg !pkg.bytes_bodybuffer.has() || pkg.bytes_bodybuffer.get() == null");
          }
        }
      }
    }
    return null;
  }
  
  private void a(bdxd parambdxd, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (paramInt1 == 1000) {
      return;
    }
    if ((paramInt1 == 1002) || (paramInt1 == 1013))
    {
      a("12010", "timeout", paramString3, paramString1, false);
      parambdxd.jdField_a_of_type_Int = 1007;
      if (QLog.isColorLevel()) {
        QLog.e("SUB_ACCOUNT", 2, "handlerRspFailed ERROR_TYPE_SERVER_TIMEOUT");
      }
    }
    for (;;)
    {
      notifyUI(paramInt2, false, parambdxd);
      return;
      a("12012", paramString2, paramString3, paramString1, false);
      parambdxd.jdField_a_of_type_Int = 1000;
      if (QLog.isColorLevel()) {
        QLog.e("SUB_ACCOUNT", 2, "handlerRspFailed ERROR_TYPE_UNKNOWN last");
      }
    }
  }
  
  private void a(bdxd parambdxd, bdxc parambdxc)
  {
    parambdxc.a(parambdxd);
    ArrayList localArrayList = parambdxd.a();
    String str;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount() hint is new,msg num=1, subUin=" + str);
        }
        i = 1 - this.app.a().a(str, 7000);
        if (i != 0) {
          this.app.a().d(str, 7000, i);
        }
      }
    }
    Iterator localIterator = parambdxd.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      boolean bool1 = localArrayList.contains(str);
      boolean bool2 = ((Boolean)bdwt.a(this.app, str).second).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount() subUin=" + str + " isLogin = " + bool2);
      }
      if (bool2)
      {
        parambdxc.a(str, 1);
        bdxd localbdxd = bdxd.a(parambdxd);
        localbdxd.c = str;
        this.app.getSubAccountKey(this.app.getAccount(), localbdxd.c, new aoia(this, localbdxd, parambdxc, bool1));
        i = 0;
      }
      for (;;)
      {
        break;
        if (parambdxc.a(str, 2))
        {
          int j = 1 - this.app.a().a(str, 7000);
          if (j != 0)
          {
            this.app.a().d(str, 7000, j);
            this.app.a().a(new String[] { antf.x, str });
          }
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount() hint need to verify,msg num=1, subUin=" + str);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount, has subaccount but islogin is false");
        }
        parambdxc.a(str, null, bool1);
      }
    }
    if (i != 0) {
      notifyUI(2, true, parambdxd);
    }
  }
  
  private void a(bdxd parambdxd, oidb_0x7a2.RspBody paramRspBody)
  {
    a("12009", "success_0", "SubBind", "actSBGetbindProtol", true);
    bdxc localbdxc = (bdxc)this.app.getManager(61);
    Object localObject = localbdxc.a();
    parambdxd.jdField_a_of_type_Int = 0;
    parambdxd.a(paramRspBody, (ArrayList)localObject);
    localObject = parambdxd.b();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      paramRspBody = (bdwt)this.app.getManager(62);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramRspBody.a((String)((Iterator)localObject).next(), 1);
      }
    }
    if (parambdxd.c())
    {
      a(parambdxd, localbdxc);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount, not has subaccount");
    }
    parambdxd.jdField_a_of_type_Int = 1008;
    bdwt.a(this.app, "sub.uin.all");
    notifyUI(2, true, parambdxd);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, bdxd parambdxd, int paramInt)
  {
    if (paramInt == 1000) {
      return;
    }
    if (paramInt == 2901)
    {
      paramInt = paramToServiceMsg.extraData.getInt("fastResendCount", 0);
      paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("request_ByteArray");
      parambdxd = createToServiceMsg("OidbSvc.0x7a2_0");
      if (paramInt + 1 < 3)
      {
        parambdxd.setEnableFastResend(true);
        parambdxd.extraData.putInt("fastResendCount", paramInt + 1);
        parambdxd.extraData.putByteArray("request_ByteArray", paramToServiceMsg);
      }
      parambdxd.putWupBuffer(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount() result==2901, resend count=" + paramInt + " setFastResend=" + parambdxd.isFastResendEnabled());
      }
      sendPbReq(parambdxd);
      return;
    }
    parambdxd.jdField_b_of_type_Boolean = true;
    a(parambdxd, paramInt, "actSBGetbindProtol", "result_" + paramInt, "SubBind", 2);
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +31 -> 34
    //   6: ldc 58
    //   8: iconst_2
    //   9: new 127	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 329
    //   19: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokestatic 335	java/lang/System:currentTimeMillis	()J
    //   25: invokevirtual 338	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   28: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_1
    //   35: ifnull +327 -> 362
    //   38: aload_1
    //   39: invokevirtual 341	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   42: astore 7
    //   44: aload_1
    //   45: getfield 268	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   48: ldc_w 343
    //   51: invokevirtual 347	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 6
    //   56: aload_1
    //   57: getfield 268	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   60: ldc_w 349
    //   63: invokevirtual 347	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore 5
    //   68: new 44	bdxd
    //   71: dup
    //   72: invokespecial 350	bdxd:<init>	()V
    //   75: astore 8
    //   77: aload_0
    //   78: aload_1
    //   79: aload_2
    //   80: aload 8
    //   82: iconst_0
    //   83: ldc_w 352
    //   86: ldc_w 352
    //   89: invokespecial 355	aohz:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Lbdxd;ILjava/lang/String;Ljava/lang/String;)Z
    //   92: ifeq +4 -> 96
    //   95: return
    //   96: aload_2
    //   97: invokevirtual 360	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   100: istore 4
    //   102: aload 8
    //   104: aload 7
    //   106: putfield 362	bdxd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   109: aload 8
    //   111: aload 6
    //   113: putfield 195	bdxd:c	Ljava/lang/String;
    //   116: aload_0
    //   117: aload 8
    //   119: iload 4
    //   121: ldc_w 364
    //   124: new 127	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 366
    //   134: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: iload 4
    //   139: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: ldc_w 368
    //   148: iconst_0
    //   149: invokespecial 324	aohz:a	(Lbdxd;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   152: aload_0
    //   153: iload 4
    //   155: aload_3
    //   156: checkcast 370	[B
    //   159: checkcast 370	[B
    //   162: aload 8
    //   164: ldc_w 372
    //   167: ldc_w 368
    //   170: ldc_w 364
    //   173: iconst_0
    //   174: ldc_w 374
    //   177: invokespecial 376	aohz:a	(I[BLbdxd;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;
    //   180: astore_2
    //   181: aload_2
    //   182: ifnull +192 -> 374
    //   185: aload_2
    //   186: getfield 73	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   189: invokevirtual 79	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   192: invokevirtual 382	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   195: astore_3
    //   196: new 384	tencent/im/oidb/cmd0x7a0/oidb_0x7a0$RspBody
    //   199: dup
    //   200: invokespecial 385	tencent/im/oidb/cmd0x7a0/oidb_0x7a0$RspBody:<init>	()V
    //   203: astore_2
    //   204: aload_2
    //   205: aload_3
    //   206: invokevirtual 386	tencent/im/oidb/cmd0x7a0/oidb_0x7a0$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   209: checkcast 384	tencent/im/oidb/cmd0x7a0/oidb_0x7a0$RspBody
    //   212: astore_3
    //   213: aload_3
    //   214: astore_2
    //   215: aload_2
    //   216: getfield 387	tencent/im/oidb/cmd0x7a0/oidb_0x7a0$RspBody:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   219: invokevirtual 37	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   222: istore 4
    //   224: aload 8
    //   226: iload 4
    //   228: putfield 389	bdxd:jdField_b_of_type_Int	I
    //   231: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq +30 -> 264
    //   237: ldc 58
    //   239: iconst_2
    //   240: new 127	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   247: ldc_w 391
    //   250: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload 4
    //   255: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: aload_0
    //   265: aload_1
    //   266: aload 7
    //   268: aload 6
    //   270: aload 5
    //   272: aload 8
    //   274: aload_2
    //   275: iload 4
    //   277: invokespecial 394	aohz:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lbdxd;Ltencent/im/oidb/cmd0x7a0/oidb_0x7a0$RspBody;I)V
    //   280: return
    //   281: astore_1
    //   282: aload_1
    //   283: invokevirtual 395	java/lang/Exception:printStackTrace	()V
    //   286: aload_0
    //   287: ldc_w 397
    //   290: ldc_w 399
    //   293: ldc_w 368
    //   296: ldc_w 364
    //   299: iconst_0
    //   300: invokespecial 42	aohz:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   303: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq +68 -> 374
    //   309: ldc 58
    //   311: iconst_2
    //   312: new 127	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   319: ldc_w 401
    //   322: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_1
    //   326: invokevirtual 404	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   329: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: return
    //   339: astore_3
    //   340: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +12 -> 355
    //   346: ldc 58
    //   348: iconst_2
    //   349: ldc_w 406
    //   352: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: aload_3
    //   356: invokevirtual 69	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   359: goto -144 -> 215
    //   362: aconst_null
    //   363: astore 5
    //   365: aconst_null
    //   366: astore 6
    //   368: aconst_null
    //   369: astore 7
    //   371: goto -303 -> 68
    //   374: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	aohz
    //   0	375	1	paramToServiceMsg	ToServiceMsg
    //   0	375	2	paramFromServiceMsg	FromServiceMsg
    //   0	375	3	paramObject	Object
    //   100	176	4	i	int
    //   66	298	5	str1	String
    //   54	313	6	str2	String
    //   42	328	7	str3	String
    //   75	198	8	localbdxd	bdxd
    // Exception table:
    //   from	to	target	type
    //   77	95	281	java/lang/Exception
    //   96	181	281	java/lang/Exception
    //   185	204	281	java/lang/Exception
    //   204	213	281	java/lang/Exception
    //   215	264	281	java/lang/Exception
    //   264	280	281	java/lang/Exception
    //   340	355	281	java/lang/Exception
    //   355	359	281	java/lang/Exception
    //   204	213	339	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void a(ToServiceMsg paramToServiceMsg, String paramString1, String paramString2, String paramString3, bdxd parambdxd, oidb_0x7a0.RspBody paramRspBody, int paramInt)
  {
    boolean bool;
    if (paramInt == 0)
    {
      a("12009", "sucess_0", "bindhandle", "actSBDBindProtol", true);
      parambdxd.jdField_a_of_type_Int = 0;
      paramString1 = (bdxc)this.app.getManager(61);
      paramToServiceMsg = paramToServiceMsg.extraData.getString("subaccount_a2");
      if (paramString1 != null)
      {
        paramString1.a(parambdxd);
        paramString1.a(paramString2, 1);
        paramString1.a(paramString2, paramToServiceMsg, true);
      }
      bdwt.a(this.app, (byte)1, paramString2);
      bdwt.b(this.app, false, paramString2);
      bdwt.a(this.app, paramString2, false);
      paramToServiceMsg = (arjg)aran.a().a(607);
      if ((paramToServiceMsg != null) && (!paramToServiceMsg.a)) {
        bdxb.a(this.app, paramString2);
      }
      if (AccountManageActivity.class.getSimpleName().equals(paramString3)) {
        bdll.b(this.app, "CliOper", "", "", "0X8004003", "0X8004003", 0, 0, "", "", "", "");
      }
      bool = true;
    }
    for (;;)
    {
      notifyUI(0, bool, parambdxd);
      return;
      paramToServiceMsg = "Bind_fail_rsp_" + paramInt;
      if ((paramInt == 1000) || (paramInt == 1001))
      {
        bool = true;
        label240:
        a("12011", paramToServiceMsg, "bindhandle", "actSBDBindProtol", bool);
        parambdxd.jdField_a_of_type_JavaLangString = paramRspBody.str_errmsg.get();
        switch (paramInt)
        {
        default: 
          if (!a(paramInt)) {
            break label495;
          }
          paramToServiceMsg = String.valueOf(paramRspBody.uint64_err_uin.get());
          if ((paramString2 != null) && (paramToServiceMsg.equalsIgnoreCase(paramString2)))
          {
            parambdxd.jdField_a_of_type_Int = 1004;
            this.app.updateSubAccountLogin(parambdxd.c, false);
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_SUBACCOUNT_A2_ERROR");
            }
          }
          break;
        }
      }
      for (;;)
      {
        bool = false;
        break;
        bool = false;
        break label240;
        parambdxd.jdField_a_of_type_Int = 1002;
        if (!QLog.isColorLevel()) {
          break label555;
        }
        QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_MAIN_HADBIND_ANOTHER");
        bool = false;
        break;
        parambdxd.jdField_a_of_type_Int = 1003;
        if (!QLog.isColorLevel()) {
          break label555;
        }
        QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_SUB_HADBIND_ANOTHER");
        bool = false;
        break;
        if ((paramString1 != null) && (paramString1.equalsIgnoreCase(paramToServiceMsg)))
        {
          parambdxd.jdField_a_of_type_Int = 1005;
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_MAINACCOUNT_A2_ERROR");
          }
        }
        else
        {
          parambdxd.jdField_a_of_type_Int = 1000;
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_UNKNOW");
          }
        }
      }
      label495:
      if (paramInt == 1221)
      {
        parambdxd.jdField_a_of_type_Int = 1011;
        if (QLog.isColorLevel())
        {
          QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_EQLIP_LOCK_FAIL");
          bool = false;
        }
      }
      else
      {
        parambdxd.jdField_a_of_type_Int = 1000;
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "handlerBindSubAccount() ERRORTYPE_UNKNOW");
        }
      }
      label555:
      bool = false;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", paramString1);
    localHashMap.put("fail_step", paramString2);
    localHashMap.put("fail_location", paramString3);
    bdmc.a(BaseApplication.getContext()).a(this.app.getCurrentAccountUin(), paramString4, paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 1200) || (paramInt == 1214) || (paramInt == 1215) || (paramInt == 1218) || (paramInt == 1232) || (paramInt == 1233) || (paramInt == 1240) || (paramInt == 1241) || (paramInt == 1242);
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, bdxd parambdxd, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = false;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      if (!TextUtils.isEmpty(paramString1)) {
        a("12007", "req_null", paramString2, paramString1, false);
      }
      parambdxd.jdField_a_of_type_Int = 1000;
      notifyUI(paramInt, false, parambdxd);
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "handlerRespEmpty: req == null || resp == null");
      }
      bool = true;
    }
    return bool;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount() start");
    }
    String str2;
    String str1;
    bdxd localbdxd;
    int i;
    if (paramToServiceMsg != null)
    {
      str2 = paramToServiceMsg.extraData.getString("subAccount");
      str1 = paramToServiceMsg.getUin();
      localbdxd = new bdxd();
      try
      {
        if (a(paramToServiceMsg, paramFromServiceMsg, localbdxd, 1, "actSBUnbindProtol", "SubBind")) {
          return;
        }
        i = paramFromServiceMsg.getResultCode();
        localbdxd.jdField_b_of_type_JavaLangString = str1;
        localbdxd.c = str2;
        a(localbdxd, i, "actSBUnbindProtol", "error", "SubBind", 1);
        paramToServiceMsg = a(i, (byte[])paramObject, localbdxd, "pkg32rs_null", "SubBind", "actSBUnbindProtol", 1, "bytebody_null");
        if (paramToServiceMsg == null) {
          break label543;
        }
        paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramToServiceMsg = new oidb_0x7a1.RspBody();
      }
      catch (Exception paramToServiceMsg)
      {
        label163:
        paramToServiceMsg.printStackTrace();
        a("12013", "exception", "SubBind", "actSBUnbindProtol", false);
        if (!QLog.isColorLevel()) {
          break label543;
        }
      }
      try
      {
        paramFromServiceMsg = (oidb_0x7a1.RspBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          break label396;
        }
        QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount() oidb_0x7a1 parseFrom byte InvalidProtocolBufferMicroException");
        paramFromServiceMsg.printStackTrace();
        break label163;
        a("12009", "rspResult_0", "SubBind", "actSBUnbindProtol", true);
        bool = true;
        localbdxd.jdField_a_of_type_Int = 0;
        bdwt.a(this.app, str2);
        break label313;
        if ((str1 == null) || (!str1.equalsIgnoreCase(paramToServiceMsg))) {
          break label479;
        }
        localbdxd.jdField_a_of_type_Int = 1005;
        if (!QLog.isColorLevel()) {
          break label583;
        }
        QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: ERRORTYPE_MAINACCOUNT_A2_ERROR");
        break label583;
        localbdxd.jdField_a_of_type_Int = 1000;
        if (!QLog.isColorLevel()) {
          break label583;
        }
      }
      i = paramToServiceMsg.uint32_result.get();
      localbdxd.jdField_b_of_type_Int = i;
      localbdxd.jdField_a_of_type_JavaLangString = paramToServiceMsg.str_errmsg.get();
      if (!QLog.isColorLevel()) {
        break label544;
      }
      QLog.d("SUB_ACCOUNT", 2, "handlerUnBindSubAccount()  rspResult = " + i);
      break label544;
      label227:
      a("12011", "rspResult_" + i, "SubBind", "actSBUnbindProtol", false);
      if (a(i))
      {
        paramToServiceMsg = String.valueOf(paramToServiceMsg.uint64_err_uin.get());
        if ((str2 != null) && (paramToServiceMsg.equalsIgnoreCase(str2)))
        {
          if (!QLog.isColorLevel()) {
            break label583;
          }
          QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: server error happen subaccount a2 error? not it is not happan");
          break label583;
        }
      }
    }
    for (;;)
    {
      label313:
      notifyUI(1, bool, localbdxd);
      return;
      QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount:   error e = " + paramToServiceMsg.getMessage());
      return;
      label396:
      label479:
      QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: ERRORTYPE_UNKNOW");
      break label583;
      localbdxd.jdField_a_of_type_Int = 1000;
      if (QLog.isColorLevel()) {
        QLog.e("SUB_ACCOUNT", 2, "handlerUnBindSubAccount: ERRORTYPE_UNKNOW");
      }
      boolean bool = false;
      continue;
      str1 = null;
      str2 = null;
      break;
      label543:
      return;
      label544:
      switch (i)
      {
      }
      break label227;
      label583:
      bool = false;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount:");
    }
    bdxd localbdxd = new bdxd();
    try
    {
      if (a(paramToServiceMsg, paramFromServiceMsg, localbdxd, 2, "actSBGetbindProtol", "SubBind")) {
        return;
      }
      i = paramFromServiceMsg.getResultCode();
      localbdxd.jdField_b_of_type_JavaLangString = paramToServiceMsg.getUin();
      a(paramToServiceMsg, localbdxd, i);
      paramToServiceMsg = a(i, (byte[])paramObject, localbdxd, "pkguint32_null", "SubBind", "actSBGetbindProtol", 2, "bytebody_null");
      if (paramToServiceMsg == null) {
        return;
      }
      paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      paramToServiceMsg = new oidb_0x7a2.RspBody();
    }
    catch (Exception paramToServiceMsg)
    {
      label126:
      a("12013", "exception", "SubBind", "actSBGetbindProtol", false);
      paramToServiceMsg.printStackTrace();
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.e("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: exception happen e = " + paramToServiceMsg.getMessage());
      return;
    }
    try
    {
      paramFromServiceMsg = (oidb_0x7a2.RspBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      if (!QLog.isColorLevel()) {
        break label239;
      }
      QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: parseFrom byte InvalidProtocolBufferMicroException ");
      paramFromServiceMsg.printStackTrace();
      break label126;
      a("12011", "rspResult_" + i, "SubBind", "actSBGetbindProtol", false);
      if (!a(i)) {
        break label338;
      }
      localbdxd.jdField_a_of_type_Int = 1005;
      if (!QLog.isColorLevel()) {
        break label329;
      }
      QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: get main account a2 error rspResult = " + i);
      for (;;)
      {
        notifyUI(2, false, localbdxd);
        return;
        localbdxd.jdField_a_of_type_Int = 1000;
        localbdxd.jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "handlerGetBindSubAccount: get main account error rspResult = " + i);
        }
      }
    }
    int i = paramToServiceMsg.uint32_result.get();
    localbdxd.jdField_b_of_type_Int = i;
    localbdxd.jdField_a_of_type_JavaLangString = paramToServiceMsg.str_errmsg.get();
    if (i == 0)
    {
      a(localbdxd, paramToServiceMsg);
      return;
    }
    label239:
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getBindSubAccount: start");
    }
    Object localObject1 = new oidb_0x7a2.ReqBody();
    ((oidb_0x7a2.ReqBody)localObject1).uint32_flag.set(1);
    Object localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1954);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x7a2.ReqBody)localObject1).toByteArray()));
    localObject1 = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
    localObject2 = createToServiceMsg("OidbSvc.0x7a2_0");
    ((ToServiceMsg)localObject2).setEnableFastResend(true);
    ((ToServiceMsg)localObject2).extraData.putInt("fastResendCount", 0);
    ((ToServiceMsg)localObject2).extraData.putByteArray("request_ByteArray", (byte[])localObject1);
    ((ToServiceMsg)localObject2).putWupBuffer((byte[])localObject1);
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "unBindSubAccount: start");
    }
    Object localObject1 = new oidb_0x7a1.ReqBody();
    ((oidb_0x7a1.ReqBody)localObject1).uint32_flag.set(1);
    Object localObject2 = bhlo.a();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((oidb_0x7a1.ReqBody)localObject1).str_imei.set((String)localObject2);
    }
    ((oidb_0x7a1.ReqBody)localObject1).uint64_bind_uin.set(Long.parseLong(paramString));
    ((oidb_0x7a1.ReqBody)localObject1).uint32_clt_appid.set(this.app.getAppid());
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1953);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x7a1.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0x7a1_0");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("subAccount", paramString);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "bindSubAccount() start");
    }
    oidb_0x7a0.LoginSig localLoginSig = new oidb_0x7a0.LoginSig();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramString2 != null) {}
    try
    {
      localObject1 = bhvd.a(paramString2);
      if (localObject1 != null) {
        localLoginSig.bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject1));
      }
      localLoginSig.uint32_type.set(8);
      localLoginSig.uint32_appid.set(16);
      localObject1 = new oidb_0x7a0.ReqBody();
      ((oidb_0x7a0.ReqBody)localObject1).uint32_flag.set(1);
      ((oidb_0x7a0.ReqBody)localObject1).msg_bind_uin_sig.set(localLoginSig);
      localObject3 = bhlo.a();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((oidb_0x7a0.ReqBody)localObject1).str_imei.set((String)localObject3);
      }
      ((oidb_0x7a0.ReqBody)localObject1).uint64_bind_uin.set(Long.parseLong(paramString1));
      ((oidb_0x7a0.ReqBody)localObject1).uint32_clt_appid.set(this.app.getAppid());
      localObject3 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject3).uint32_command.set(1952);
      ((oidb_sso.OIDBSSOPkg)localObject3).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject3).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject3).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x7a0.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvc.0x7a0_0");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject3).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("subAccount", paramString1);
      ((ToServiceMsg)localObject1).extraData.putString("subaccount_a2", paramString2);
      if (paramString3 != null) {
        ((ToServiceMsg)localObject1).extraData.putString("fromWhere", paramString3);
      }
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject2 = localObject3;
      }
    }
  }
  
  protected Class<? extends anui> observerClass()
  {
    return aoib.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ((str == null) || (str.length() == 0)) {}
    do
    {
      return;
      if ("OidbSvc.0x7a0_0".equalsIgnoreCase(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7a1_0".equalsIgnoreCase(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x7a2_0".equalsIgnoreCase(str));
    try
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    catch (VerifyError paramToServiceMsg)
    {
      QLog.e("SUB_ACCOUNT", 2, "handlerGetBindSubAccount VerifyError: " + paramToServiceMsg.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aohz
 * JD-Core Version:    0.7.0.1
 */