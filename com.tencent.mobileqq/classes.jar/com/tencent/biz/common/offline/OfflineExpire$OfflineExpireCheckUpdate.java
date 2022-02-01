package com.tencent.biz.common.offline;

import KQQ.RespItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.sso.offlinpkg.OfflinePkg.RspBody;

public class OfflineExpire$OfflineExpireCheckUpdate
  implements CheckUpdateItemInterface
{
  public OfflineExpire$OfflineExpireCheckUpdate(AppRuntime paramAppRuntime)
  {
    boolean bool;
    if (paramAppRuntime.getLongAccountUin() % 10L == 6L) {
      bool = true;
    } else {
      bool = false;
    }
    HtmlOffline.i = bool;
  }
  
  public int a()
  {
    return 1;
  }
  
  /* Error */
  public KQQ.ReqItem a(int paramInt)
  {
    // Byte code:
    //   0: getstatic 40	com/tencent/biz/common/offline/OfflineExpire:c	Z
    //   3: ifeq +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: iconst_1
    //   9: putstatic 40	com/tencent/biz/common/offline/OfflineExpire:c	Z
    //   12: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +12 -> 27
    //   18: getstatic 49	com/tencent/biz/common/offline/OfflineExpire:a	Ljava/lang/String;
    //   21: iconst_2
    //   22: ldc 51
    //   24: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: getstatic 61	mqq/app/MobileQQ:sProcessId	I
    //   30: iconst_1
    //   31: if_icmpeq +5 -> 36
    //   34: aconst_null
    //   35: areturn
    //   36: new 63	KQQ/ReqItem
    //   39: dup
    //   40: invokespecial 64	KQQ/ReqItem:<init>	()V
    //   43: astore 6
    //   45: aload 6
    //   47: iconst_1
    //   48: putfield 68	KQQ/ReqItem:cOperType	B
    //   51: aload 6
    //   53: bipush 127
    //   55: putfield 71	KQQ/ReqItem:eServiceID	I
    //   58: new 73	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody
    //   61: dup
    //   62: invokespecial 74	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:<init>	()V
    //   65: astore 7
    //   67: aload 7
    //   69: getfield 78	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:uint32_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   72: iconst_2
    //   73: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   76: aload 7
    //   78: getfield 87	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:uint32_platform	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   81: getstatic 90	com/tencent/biz/common/offline/OfflineExpire:b	I
    //   84: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   87: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +24 -> 114
    //   93: getstatic 49	com/tencent/biz/common/offline/OfflineExpire:a	Ljava/lang/String;
    //   96: iconst_1
    //   97: ldc 92
    //   99: iconst_1
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: ldc 94
    //   107: aastore
    //   108: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   111: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload 7
    //   116: getfield 104	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:str_qver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   119: ldc 94
    //   121: invokevirtual 108	java/lang/String:getBytes	()[B
    //   124: invokestatic 114	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   127: invokevirtual 119	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   130: aload 7
    //   132: getfield 122	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:str_osrelease	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   135: getstatic 127	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   138: invokevirtual 108	java/lang/String:getBytes	()[B
    //   141: invokestatic 114	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   144: invokevirtual 119	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   147: invokestatic 132	com/tencent/mobileqq/utils/NetworkUtil:getNetWorkType	()I
    //   150: istore_1
    //   151: aload 7
    //   153: getfield 136	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:int32_network	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   156: iload_1
    //   157: invokevirtual 139	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   160: aload 7
    //   162: getfield 142	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:str_from	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   165: ldc 144
    //   167: invokevirtual 108	java/lang/String:getBytes	()[B
    //   170: invokestatic 114	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   173: invokevirtual 119	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   176: invokestatic 147	com/tencent/biz/common/offline/HtmlOffline:a	()Ljava/lang/String;
    //   179: astore 5
    //   181: aload 5
    //   183: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   186: ifne +260 -> 446
    //   189: aload 5
    //   191: ldc 155
    //   193: invokevirtual 159	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   196: astore 8
    //   198: aload 8
    //   200: arraylength
    //   201: istore 4
    //   203: iconst_0
    //   204: istore_3
    //   205: iload_3
    //   206: iload 4
    //   208: if_icmpge +238 -> 446
    //   211: aload 8
    //   213: iload_3
    //   214: aaload
    //   215: astore 9
    //   217: aload 9
    //   219: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   222: ifne +217 -> 439
    //   225: aload 9
    //   227: ldc 161
    //   229: invokevirtual 159	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   232: astore 5
    //   234: aload 5
    //   236: iconst_0
    //   237: aaload
    //   238: invokestatic 167	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   241: invokevirtual 170	java/lang/Integer:intValue	()I
    //   244: istore_1
    //   245: aload 5
    //   247: iconst_1
    //   248: aaload
    //   249: invokestatic 167	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   252: invokevirtual 170	java/lang/Integer:intValue	()I
    //   255: istore_2
    //   256: goto +136 -> 392
    //   259: iload_1
    //   260: istore_2
    //   261: goto +12 -> 273
    //   264: astore 5
    //   266: iload_1
    //   267: istore_2
    //   268: goto +65 -> 333
    //   271: iconst_0
    //   272: istore_2
    //   273: iload_2
    //   274: istore_1
    //   275: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq +46 -> 324
    //   281: getstatic 49	com/tencent/biz/common/offline/OfflineExpire:a	Ljava/lang/String;
    //   284: astore 5
    //   286: new 172	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   293: astore 10
    //   295: aload 10
    //   297: ldc 175
    //   299: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 10
    //   305: aload 9
    //   307: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 5
    //   313: iconst_2
    //   314: aload 10
    //   316: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: iload_2
    //   323: istore_1
    //   324: iconst_0
    //   325: istore_2
    //   326: goto +66 -> 392
    //   329: astore 5
    //   331: iconst_0
    //   332: istore_2
    //   333: aload 5
    //   335: invokevirtual 187	java/lang/NumberFormatException:printStackTrace	()V
    //   338: iload_2
    //   339: istore_1
    //   340: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq -19 -> 324
    //   346: getstatic 49	com/tencent/biz/common/offline/OfflineExpire:a	Ljava/lang/String;
    //   349: astore 5
    //   351: new 172	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 173	java/lang/StringBuilder:<init>	()V
    //   358: astore 10
    //   360: aload 10
    //   362: ldc 189
    //   364: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 10
    //   370: aload 9
    //   372: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 5
    //   378: iconst_2
    //   379: aload 10
    //   381: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 184	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: iload_2
    //   388: istore_1
    //   389: goto -65 -> 324
    //   392: iload_1
    //   393: ifne +6 -> 399
    //   396: goto +43 -> 439
    //   399: new 191	tencent/im/sso/offlinpkg/OfflinePkg$BidPkg
    //   402: dup
    //   403: invokespecial 192	tencent/im/sso/offlinpkg/OfflinePkg$BidPkg:<init>	()V
    //   406: astore 5
    //   408: aload 5
    //   410: getfield 195	tencent/im/sso/offlinpkg/OfflinePkg$BidPkg:uint32_bid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   413: iload_1
    //   414: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   417: aload 5
    //   419: getfield 199	tencent/im/sso/offlinpkg/OfflinePkg$BidPkg:uint32_pkg_id	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   422: iload_2
    //   423: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   426: invokevirtual 208	com/tencent/mobileqq/pb/PBRepeatField:add	(Ljava/lang/Object;)V
    //   429: aload 7
    //   431: getfield 212	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:st_bid_pkg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   434: aload 5
    //   436: invokevirtual 217	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   439: iload_3
    //   440: iconst_1
    //   441: iadd
    //   442: istore_3
    //   443: goto -238 -> 205
    //   446: aload 6
    //   448: aload 7
    //   450: invokevirtual 220	tencent/im/sso/offlinpkg/OfflinePkg$ReqBody:toByteArray	()[B
    //   453: invokestatic 225	com/tencent/mobileqq/utils/WupUtil:a	([B)[B
    //   456: putfield 229	KQQ/ReqItem:vecParam	[B
    //   459: aload 6
    //   461: areturn
    //   462: astore 5
    //   464: goto -193 -> 271
    //   467: astore 5
    //   469: goto -210 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	this	OfflineExpireCheckUpdate
    //   0	472	1	paramInt	int
    //   255	168	2	i	int
    //   204	239	3	j	int
    //   201	8	4	k	int
    //   179	67	5	localObject1	Object
    //   264	1	5	localNumberFormatException1	java.lang.NumberFormatException
    //   284	28	5	str1	String
    //   329	5	5	localNumberFormatException2	java.lang.NumberFormatException
    //   349	86	5	localObject2	Object
    //   462	1	5	localException1	Exception
    //   467	1	5	localException2	Exception
    //   43	417	6	localReqItem	KQQ.ReqItem
    //   65	384	7	localReqBody	tencent.im.sso.offlinpkg.OfflinePkg.ReqBody
    //   196	16	8	arrayOfString	String[]
    //   215	156	9	str2	String
    //   293	87	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   245	256	264	java/lang/NumberFormatException
    //   234	245	329	java/lang/NumberFormatException
    //   234	245	462	java/lang/Exception
    //   245	256	467	java/lang/Exception
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d(OfflineExpire.a, 2, "handleCheckUpdateItemData");
    }
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (MobileQQ.sProcessId != 1) {
      return;
    }
    Object localObject2;
    if (paramRespItem.cResult == 2)
    {
      if (paramRespItem.eServiceID == 127)
      {
        paramRespItem = WupUtil.b(paramRespItem.vecUpdate);
        if (paramRespItem != null)
        {
          localObject2 = new OfflinePkg.RspBody();
          try
          {
            ((OfflinePkg.RspBody)localObject2).mergeFrom(paramRespItem);
            OfflineExpire.a(new String(((OfflinePkg.RspBody)localObject2).str_expire_pkg.get().toByteArray(), "UTF-8"));
            OfflineExpire.a(new String(((OfflinePkg.RspBody)localObject2).str_predown_pkg_ex.get().toByteArray(), "UTF-8"), (AppRuntime)localObject1, ((AppRuntime)localObject1).getApplicationContext(), 1);
          }
          catch (Exception paramRespItem)
          {
            paramRespItem.printStackTrace();
            if (QLog.isColorLevel())
            {
              localObject1 = OfflineExpire.a;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleCheckUpdateItemData: ");
              ((StringBuilder)localObject2).append(QLog.getStackTraceString(paramRespItem));
              QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
          }
          catch (UnsupportedEncodingException paramRespItem)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = OfflineExpire.a;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleCheckUpdateItemData: ");
              ((StringBuilder)localObject2).append(QLog.getStackTraceString(paramRespItem));
              QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
          }
          catch (InvalidProtocolBufferMicroException paramRespItem)
          {
            paramRespItem.printStackTrace();
            if (QLog.isColorLevel())
            {
              localObject1 = OfflineExpire.a;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleCheckUpdateItemData: ");
              ((StringBuilder)localObject2).append(QLog.getStackTraceString(paramRespItem));
              QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
      }
      ThreadManager.getSubThreadHandler().postDelayed(new OfflineExpire.OfflineExpireCheckUpdate.1(this), 180000L);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = OfflineExpire.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("***handleCheckUpdateItemData fail respitem.cResult:");
      ((StringBuilder)localObject2).append(paramRespItem.cResult);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire.OfflineExpireCheckUpdate
 * JD-Core Version:    0.7.0.1
 */