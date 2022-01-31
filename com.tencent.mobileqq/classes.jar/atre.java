import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_808;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_808_web;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_common;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_common_web;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.ReqBody;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class atre
  extends alko
{
  public atre(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  /* Error */
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_2
    //   7: invokevirtual 19	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   10: ifeq +332 -> 342
    //   13: new 21	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   16: dup
    //   17: invokespecial 24	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   20: astore_1
    //   21: aload_1
    //   22: aload_3
    //   23: checkcast 26	[B
    //   26: checkcast 26	[B
    //   29: invokevirtual 30	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   32: pop
    //   33: aload_1
    //   34: getfield 34	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   37: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   40: ifeq +226 -> 266
    //   43: aload_1
    //   44: getfield 34	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   47: invokevirtual 43	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   50: ifne +216 -> 266
    //   53: new 45	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody
    //   56: dup
    //   57: invokespecial 46	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:<init>	()V
    //   60: astore_3
    //   61: aload_3
    //   62: aload_1
    //   63: getfield 50	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   66: invokevirtual 55	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   69: invokevirtual 61	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   72: invokevirtual 62	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   75: pop
    //   76: aload_3
    //   77: getfield 65	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:uint32_is_first_login	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   80: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   83: ifeq +214 -> 297
    //   86: aload_3
    //   87: getfield 65	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:uint32_is_first_login	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   90: invokevirtual 43	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   93: iconst_1
    //   94: if_icmpne +203 -> 297
    //   97: iconst_4
    //   98: anewarray 67	java/lang/Object
    //   101: astore_1
    //   102: aload_3
    //   103: getfield 71	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:str_reg_mobile	Lcom/tencent/mobileqq/pb/PBStringField;
    //   106: invokevirtual 74	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   109: ifeq +141 -> 250
    //   112: aload_3
    //   113: getfield 71	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:str_reg_mobile	Lcom/tencent/mobileqq/pb/PBStringField;
    //   116: invokevirtual 77	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   119: astore_2
    //   120: aload_1
    //   121: iconst_0
    //   122: aload_2
    //   123: aastore
    //   124: aload_3
    //   125: getfield 81	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:msg_contact_bind_info	Ltencent/im/oidb/cmd0x59f/oidb_0x59f$BindContactInfo;
    //   128: invokevirtual 84	tencent/im/oidb/cmd0x59f/oidb_0x59f$BindContactInfo:has	()Z
    //   131: ifeq +124 -> 255
    //   134: aload_3
    //   135: getfield 81	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:msg_contact_bind_info	Ltencent/im/oidb/cmd0x59f/oidb_0x59f$BindContactInfo;
    //   138: invokevirtual 87	tencent/im/oidb/cmd0x59f/oidb_0x59f$BindContactInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   141: checkcast 83	tencent/im/oidb/cmd0x59f/oidb_0x59f$BindContactInfo
    //   144: astore_2
    //   145: aload_1
    //   146: iconst_1
    //   147: aload_2
    //   148: aastore
    //   149: aload_3
    //   150: getfield 90	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:uint32_gray_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   153: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   156: ifeq +104 -> 260
    //   159: aload_3
    //   160: getfield 90	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:uint32_gray_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   163: invokevirtual 43	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   166: istore 4
    //   168: aload_1
    //   169: iconst_2
    //   170: iload 4
    //   172: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: aload 7
    //   178: astore_2
    //   179: aload_3
    //   180: getfield 99	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:str_guide_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   183: invokevirtual 74	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   186: ifeq +11 -> 197
    //   189: aload_3
    //   190: getfield 99	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:str_guide_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   193: invokevirtual 77	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   196: astore_2
    //   197: aload_1
    //   198: iconst_3
    //   199: aload_2
    //   200: aastore
    //   201: iconst_1
    //   202: istore 5
    //   204: aload_1
    //   205: astore_2
    //   206: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +29 -> 238
    //   212: ldc 106
    //   214: iconst_2
    //   215: new 108	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   222: ldc 111
    //   224: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: iload 5
    //   229: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   232: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload_0
    //   239: sipush 558
    //   242: iload 5
    //   244: aload_2
    //   245: iconst_1
    //   246: invokevirtual 129	atre:notifyUI	(IZLjava/lang/Object;Z)V
    //   249: return
    //   250: aconst_null
    //   251: astore_2
    //   252: goto -132 -> 120
    //   255: aconst_null
    //   256: astore_2
    //   257: goto -112 -> 145
    //   260: iconst_0
    //   261: istore 4
    //   263: goto -95 -> 168
    //   266: ldc 106
    //   268: iconst_1
    //   269: new 108	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   276: ldc 131
    //   278: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_1
    //   282: getfield 34	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   285: invokevirtual 43	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   288: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: aconst_null
    //   298: astore_2
    //   299: iconst_0
    //   300: istore 5
    //   302: goto -96 -> 206
    //   305: astore_3
    //   306: aconst_null
    //   307: astore_1
    //   308: aload_1
    //   309: astore_2
    //   310: iload 6
    //   312: istore 5
    //   314: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq -111 -> 206
    //   320: ldc 106
    //   322: iconst_2
    //   323: ldc 139
    //   325: aload_3
    //   326: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   329: aload_1
    //   330: astore_2
    //   331: iload 6
    //   333: istore 5
    //   335: goto -129 -> 206
    //   338: astore_3
    //   339: goto -31 -> 308
    //   342: aconst_null
    //   343: astore_2
    //   344: iload 6
    //   346: istore 5
    //   348: goto -142 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	atre
    //   0	351	1	paramToServiceMsg	ToServiceMsg
    //   0	351	2	paramFromServiceMsg	FromServiceMsg
    //   0	351	3	paramObject	Object
    //   166	96	4	i	int
    //   202	145	5	bool1	boolean
    //   1	344	6	bool2	boolean
    //   4	173	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	102	305	java/lang/Throwable
    //   266	297	305	java/lang/Throwable
    //   102	120	338	java/lang/Throwable
    //   124	145	338	java/lang/Throwable
    //   149	168	338	java/lang/Throwable
    //   168	176	338	java/lang/Throwable
    //   179	197	338	java/lang/Throwable
  }
  
  public void a(boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = makeOIDBPkg("OidbSvc.0x59f", 1439, 1, new oidb_0x59f.ReqBody().toByteArray());
    localToServiceMsg.extraData.putBoolean("isFirst", paramBoolean);
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.i("LoginWelcomeHandler", 2, "requestGuide [" + paramBoolean + "]");
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0)) {
          continue;
        }
        oidb_0x59f.RspBody localRspBody = new oidb_0x59f.RspBody();
        localRspBody.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramObject = new atrn();
        int i;
        if (localRspBody.uint32_addrlist_entrance_flag.has()) {
          if (localRspBody.uint32_addrlist_entrance_flag.get() != 0)
          {
            bool1 = true;
            paramObject.jdField_b_of_type_Boolean = bool1;
            if (!localRspBody.msg_guidelines808.has()) {
              continue;
            }
            paramToServiceMsg = (oidb_0x59f.Guidelines_808)localRspBody.msg_guidelines808.get();
            if (paramToServiceMsg != null)
            {
              if (!paramToServiceMsg.uint32_welcomepage_flag.has()) {
                continue;
              }
              if (paramToServiceMsg.uint32_welcomepage_flag.get() == 0) {
                continue;
              }
              bool1 = true;
              paramObject.jdField_a_of_type_Boolean = bool1;
              if (!paramToServiceMsg.msg_guidelines_web.has()) {
                continue;
              }
              paramToServiceMsg = (oidb_0x59f.Guidelines_808_web)paramToServiceMsg.msg_guidelines_web.get();
              if (paramToServiceMsg != null)
              {
                if (!paramToServiceMsg.str_web_url.has()) {
                  continue;
                }
                paramFromServiceMsg = paramToServiceMsg.str_web_url.get();
                if (!TextUtils.isEmpty(paramFromServiceMsg)) {
                  paramObject.jdField_a_of_type_JavaLangString = paramFromServiceMsg;
                }
                if (!paramToServiceMsg.uint32_friends_recomm_flag.has()) {
                  continue;
                }
                i = paramToServiceMsg.uint32_friends_recomm_flag.get();
                paramObject.jdField_a_of_type_Int = i;
                if (!paramToServiceMsg.uint32_groups_recomm_flag.has()) {
                  continue;
                }
                i = paramToServiceMsg.uint32_groups_recomm_flag.get();
                paramObject.jdField_b_of_type_Int = i;
              }
            }
            paramToServiceMsg = new Object[3];
            paramToServiceMsg[0] = paramObject;
          }
        }
        try
        {
          localatrm = new atrm();
          if (localRspBody.msg_guidelines813.has())
          {
            paramFromServiceMsg = (oidb_0x59f.Guidelines_common)localRspBody.msg_guidelines813.get();
            if (paramFromServiceMsg != null)
            {
              if (!paramFromServiceMsg.msg_guidelines_web.has()) {
                continue;
              }
              paramFromServiceMsg = (oidb_0x59f.Guidelines_common_web)paramFromServiceMsg.msg_guidelines_web.get();
              if (paramFromServiceMsg != null)
              {
                if (!paramFromServiceMsg.str_web_url.has()) {
                  continue;
                }
                paramObject = paramFromServiceMsg.str_web_url.get();
                localatrm.jdField_a_of_type_JavaLangString = paramObject;
                if ((!paramFromServiceMsg.uint32_groups_recomm_flag.has()) || (paramFromServiceMsg.uint32_groups_recomm_flag.get() != 1)) {
                  continue;
                }
                localatrm.jdField_a_of_type_Int = 1;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("LoginWelcomeManager", 2, String.format("813 guide :type %s, url %s", new Object[] { Integer.valueOf(localatrm.jdField_a_of_type_Int), localatrm.jdField_a_of_type_JavaLangString }));
            }
            paramToServiceMsg[1] = localatrm;
            if ((!localRspBody.uint32_need_not_req_nexttime.has()) || (localRspBody.uint32_need_not_req_nexttime.get() != 1)) {
              continue;
            }
            paramToServiceMsg[2] = Boolean.FALSE;
            bool1 = true;
            paramFromServiceMsg = paramToServiceMsg;
            if (QLog.isColorLevel()) {
              QLog.d("LoginWelcomeManager", 2, "handleRequestGuide, result " + bool1);
            }
            notifyUI(559, bool1, paramFromServiceMsg, true);
            return;
            bool1 = false;
            continue;
            bool1 = false;
            continue;
            paramToServiceMsg = null;
            continue;
            bool1 = false;
            continue;
            bool1 = false;
            continue;
            paramToServiceMsg = null;
            continue;
            paramFromServiceMsg = "";
            continue;
            i = 0;
            continue;
            i = 0;
            continue;
          }
          else
          {
            paramFromServiceMsg = null;
            continue;
          }
          paramFromServiceMsg = null;
          continue;
          paramObject = null;
          continue;
          if ((!paramFromServiceMsg.uint32_set_gender.has()) || (paramFromServiceMsg.uint32_set_gender.get() != 1)) {
            continue;
          }
          localatrm.jdField_a_of_type_Int = 2;
          continue;
          paramFromServiceMsg = paramToServiceMsg;
        }
        catch (Throwable paramObject) {}
      }
      catch (Throwable paramObject)
      {
        atrm localatrm;
        paramToServiceMsg = null;
        continue;
      }
      boolean bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("LoginWelcomeManager", 2, "handleRequestGuide failed", paramObject);
        paramFromServiceMsg = paramToServiceMsg;
        bool1 = bool2;
        continue;
        if ((paramFromServiceMsg.uint32_set_birthday.has()) && (paramFromServiceMsg.uint32_set_birthday.get() == 1))
        {
          localatrm.jdField_a_of_type_Int = 3;
        }
        else if ((paramFromServiceMsg.uint32_set_head.has()) && (paramFromServiceMsg.uint32_set_head.get() == 1))
        {
          localatrm.jdField_a_of_type_Int = 4;
        }
        else if ((paramFromServiceMsg.uint32_set_school.has()) && (paramFromServiceMsg.uint32_set_school.get() == 1))
        {
          localatrm.jdField_a_of_type_Int = 5;
        }
        else if ((paramFromServiceMsg.uint32_set_region.has()) && (paramFromServiceMsg.uint32_set_region.get() == 1))
        {
          localatrm.jdField_a_of_type_Int = 6;
        }
        else if ((paramFromServiceMsg.uint32_set_company.has()) && (paramFromServiceMsg.uint32_set_company.get() == 1))
        {
          localatrm.jdField_a_of_type_Int = 7;
        }
        else
        {
          localatrm.jdField_a_of_type_Int = 0;
          continue;
          paramToServiceMsg[2] = Boolean.TRUE;
          continue;
          QLog.e("LoginWelcomeManager", 1, "handleRequestGuide sso failed: " + paramToServiceMsg.uint32_result.get());
          paramFromServiceMsg = null;
          bool1 = false;
          continue;
          paramFromServiceMsg = null;
          bool1 = bool2;
        }
      }
    }
  }
  
  protected Class<? extends alkr> observerClass()
  {
    return LoginWelcomeManager.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.getServiceCmd().equals("OidbSvc.0x59f"))
    {
      if (paramToServiceMsg.extraData.getBoolean("isFirst")) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atre
 * JD-Core Version:    0.7.0.1
 */