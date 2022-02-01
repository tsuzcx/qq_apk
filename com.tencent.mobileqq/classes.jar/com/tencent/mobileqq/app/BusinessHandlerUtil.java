package com.tencent.mobileqq.app;

import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class BusinessHandlerUtil
{
  private static final int MM_APP_ID = 1000277;
  
  protected static void checkReportErrorToMM(FromServiceMsg paramFromServiceMsg, String paramString)
  {
    if (reportErrorToMM(paramFromServiceMsg))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report MM:cmd=");
        ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
        ((StringBuilder)localObject).append(", error code=");
        ((StringBuilder)localObject).append(paramFromServiceMsg.getBusinessFailCode());
        ((StringBuilder)localObject).append(", uin=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("msgCmdFilter", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131899505));
      ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
      localObject = ((StringBuilder)localObject).toString();
      ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), paramString, 1000277, (String)localObject, true);
    }
  }
  
  /* Error */
  public static <T extends com.tencent.mobileqq.pb.MessageMicro<T>> T decodeOIDB(String paramString, byte[] paramArrayOfByte, java.lang.Class<T> paramClass)
  {
    // Byte code:
    //   0: new 82	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3: dup
    //   4: invokespecial 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: invokevirtual 87	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13: checkcast 82	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   16: astore_1
    //   17: aload_1
    //   18: getfield 91	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   21: invokevirtual 96	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   24: ifeq +103 -> 127
    //   27: aload_1
    //   28: getfield 91	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   31: invokevirtual 99	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   34: ifne +93 -> 127
    //   37: aload_1
    //   38: getfield 103	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   41: invokevirtual 106	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   44: ifeq +83 -> 127
    //   47: aload_1
    //   48: getfield 103	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 109	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   54: ifnonnull +6 -> 60
    //   57: goto +70 -> 127
    //   60: aload_2
    //   61: invokevirtual 115	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   64: checkcast 117	com/tencent/mobileqq/pb/MessageMicro
    //   67: astore_2
    //   68: aload_2
    //   69: aload_1
    //   70: getfield 103	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   73: invokevirtual 109	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   76: invokevirtual 123	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   79: invokevirtual 124	com/tencent/mobileqq/pb/MessageMicro:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   82: pop
    //   83: aload_2
    //   84: areturn
    //   85: astore_1
    //   86: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +36 -> 125
    //   92: new 26	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   99: astore_2
    //   100: aload_2
    //   101: ldc 126
    //   103: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_2
    //   108: aload_1
    //   109: invokevirtual 127	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   112: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_0
    //   117: iconst_2
    //   118: aload_2
    //   119: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aconst_null
    //   126: areturn
    //   127: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +39 -> 169
    //   133: new 26	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   140: astore_2
    //   141: aload_2
    //   142: ldc 132
    //   144: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_2
    //   149: aload_1
    //   150: getfield 91	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   153: invokevirtual 99	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   156: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_0
    //   161: iconst_2
    //   162: aload_2
    //   163: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_1
    //   172: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +36 -> 211
    //   178: new 26	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   185: astore_2
    //   186: aload_2
    //   187: ldc 134
    //   189: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_2
    //   194: aload_1
    //   195: invokevirtual 127	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   198: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_0
    //   203: iconst_2
    //   204: aload_2
    //   205: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: aconst_null
    //   212: areturn
    //   213: astore_0
    //   214: aconst_null
    //   215: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramString	String
    //   0	216	1	paramArrayOfByte	byte[]
    //   0	216	2	paramClass	java.lang.Class<T>
    //   7	2	3	localOIDBSSOPkg	tencent.im.oidb.oidb_sso.OIDBSSOPkg
    // Exception table:
    //   from	to	target	type
    //   60	83	85	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   8	17	171	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   60	83	213	java/lang/Exception
  }
  
  protected static boolean reportErrorToMM(FromServiceMsg paramFromServiceMsg)
  {
    return (!paramFromServiceMsg.isSuccess()) && ((paramFromServiceMsg.getServiceCmd().equals("EncounterSvc.ReqGetEncounter")) || (paramFromServiceMsg.getServiceCmd().equals("RoamClientSvr.GetQualify")) || (paramFromServiceMsg.getServiceCmd().equals("NeighborSvc.ReqGetPoint")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BusinessHandlerUtil
 * JD-Core Version:    0.7.0.1
 */