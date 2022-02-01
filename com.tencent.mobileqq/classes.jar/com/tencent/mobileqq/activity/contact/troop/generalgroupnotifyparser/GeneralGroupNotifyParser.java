package com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser;

import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.general_group_notify.general_group_notify.GroupNotify;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public abstract class GeneralGroupNotifyParser
{
  protected final String a = getClass().getSimpleName();
  
  /* Error */
  private general_group_notify.GroupNotify a(structmsg.StructMsg paramStructMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +76 -> 77
    //   4: aload_1
    //   5: getfield 32	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   8: getfield 38	tencent/mobileim/structmsg/structmsg$SystemMsg:bytes_transparent_group_notify	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11: invokevirtual 44	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   14: ifeq +63 -> 77
    //   17: aload_1
    //   18: getfield 32	tencent/mobileim/structmsg/structmsg$StructMsg:msg	Ltencent/mobileim/structmsg/structmsg$SystemMsg;
    //   21: getfield 38	tencent/mobileim/structmsg/structmsg$SystemMsg:bytes_transparent_group_notify	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   24: invokevirtual 48	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +48 -> 77
    //   32: aload_1
    //   33: invokevirtual 54	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   36: astore_2
    //   37: new 56	tencent/im/oidb/general_group_notify/general_group_notify$GroupNotify
    //   40: dup
    //   41: invokespecial 57	tencent/im/oidb/general_group_notify/general_group_notify$GroupNotify:<init>	()V
    //   44: astore_1
    //   45: aload_1
    //   46: aload_2
    //   47: invokevirtual 61	tencent/im/oidb/general_group_notify/general_group_notify$GroupNotify:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   50: pop
    //   51: aload_1
    //   52: areturn
    //   53: astore_2
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_2
    //   57: invokevirtual 64	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   60: aload_0
    //   61: getfield 22	com/tencent/mobileqq/activity/contact/troop/generalgroupnotifyparser/GeneralGroupNotifyParser:a	Ljava/lang/String;
    //   64: iconst_1
    //   65: ldc 66
    //   67: aload_2
    //   68: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   71: aload_1
    //   72: areturn
    //   73: astore_2
    //   74: goto -18 -> 56
    //   77: aconst_null
    //   78: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	GeneralGroupNotifyParser
    //   0	79	1	paramStructMsg	structmsg.StructMsg
    //   36	11	2	arrayOfByte	byte[]
    //   53	15	2	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   73	1	2	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    // Exception table:
    //   from	to	target	type
    //   32	45	53	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   45	51	73	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  protected abstract <T extends GeneralGroupNotifyParser.GeneralGroupNotifyInfo> T a(general_group_notify.GroupNotify paramGroupNotify);
  
  public <T extends GeneralGroupNotifyParser.GeneralGroupNotifyInfo> T a(structmsg.StructMsg paramStructMsg)
  {
    Object localObject = null;
    general_group_notify.GroupNotify localGroupNotify = a(paramStructMsg);
    paramStructMsg = localObject;
    if (localGroupNotify != null) {
      paramStructMsg = a(localGroupNotify);
    }
    if ((paramStructMsg != null) && (QLog.isColorLevel())) {
      QLog.i(this.a, 1, "info:" + paramStructMsg.toString());
    }
    return paramStructMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser.GeneralGroupNotifyParser
 * JD-Core Version:    0.7.0.1
 */