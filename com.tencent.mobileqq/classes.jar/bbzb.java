import AccostSvc.ClientMsg;
import AccostSvc.Msg;
import AccostSvc.MsgItem;
import AccostSvc.ReqDeleteBlackList;
import AccostSvc.ReqGetBlackList;
import AccostSvc.ReqInsertBlackList;
import AccostSvc.RespHeader;
import AccostSvc.RespSvrMsg;
import AccostSvc.RichMsg;
import AccostSvc.SvrMsg;
import AccostSvc.UserInfo;
import MessageSvcPack.AccostMsg;
import MessageSvcPack.SvcDelMsgInfo;
import MessageSvcPack.SvcRequestDelMsgV2;
import MessageSvcPack.SvcRequestDelRoamMsg;
import MessageSvcPack.SvcRequestSendVideoMsg;
import MessageSvcPack.SvcRequestSetRoamMsgAllUser;
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.DeviceInfo;
import OnlinePushPack.SvcRespPushMsg;
import QQService.CSRespPushStreamMsg;
import QQService.CSUploadStreamMsg;
import QQService.ReqGetSign;
import QQService.ReqOffFilePack;
import QQService.ReqTmpChatPicDownload;
import QQService.StreamData;
import QQService.StreamInfo;
import SharpSvrPack.MultiVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class bbzb
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "MessageFactorySender";
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  
  public static long a(long paramLong)
  {
    return 0L | paramLong;
  }
  
  private long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l = Long.parseLong(paramString);
        if (l >= 10000L) {
          return l;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("OnlinePush");
    paramUniPacket.setFuncName("SvcRespPushMsg");
    paramUniPacket.setRequestId(paramToServiceMsg.extraData.getInt("seq"));
    SvcRespPushMsg localSvcRespPushMsg = new SvcRespPushMsg();
    localSvcRespPushMsg.lUin = paramToServiceMsg.extraData.getLong("lUin");
    localSvcRespPushMsg.svrip = paramToServiceMsg.extraData.getInt("svrip");
    if (localSvcRespPushMsg.lUin < 10000L) {
      return false;
    }
    if (paramToServiceMsg.extraData.getSerializable("delMsgInfos") != null)
    {
      Object localObject = (ArrayList)paramToServiceMsg.extraData.getSerializable("delMsgInfos");
      localSvcRespPushMsg.vDelInfos = ((ArrayList)localObject);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DelMsgInfo localDelMsgInfo = (DelMsgInfo)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("MessageHandler", 2, "createC2COnlinePushBuff uin: " + localDelMsgInfo.lFromUin + " seq: " + localDelMsgInfo.shMsgSeq);
        }
        if ((localDelMsgInfo.vMsgCookies != null) && (QLog.isColorLevel())) {
          QLog.d("MessageHandler", 2, "createC2COnlinePushBuff Cookies: " + HexUtil.bytes2HexStr(localDelMsgInfo.vMsgCookies));
        }
      }
    }
    if (paramToServiceMsg.extraData.getByteArray("bytes_push_token") != null) {
      localSvcRespPushMsg.bytes_push_token = ((byte[])paramToServiceMsg.extraData.getByteArray("bytes_push_token").clone());
    }
    int i = paramToServiceMsg.extraData.getInt("service_type");
    if (i != -1) {
      localSvcRespPushMsg.service_type = i;
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getSerializable("deviceInfo");
    if ((paramToServiceMsg != null) && ((paramToServiceMsg instanceof DeviceInfo)))
    {
      localSvcRespPushMsg.deviceInfo = ((DeviceInfo)paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "createC2COnlinePushBuff serviceType=" + i + " device=" + localSvcRespPushMsg.deviceInfo.strOSVer);
      }
    }
    paramUniPacket.put("resp", localSvcRespPushMsg);
    return true;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    int j = 0;
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("MessageSvc");
    paramUniPacket.setFuncName("DelMsgV2");
    SvcRequestDelMsgV2 localSvcRequestDelMsgV2 = new SvcRequestDelMsgV2();
    localSvcRequestDelMsgV2.lUin = Long.parseLong(paramToServiceMsg.getUin());
    localSvcRequestDelMsgV2.vDelInfos = new ArrayList();
    localSvcRequestDelMsgV2.vAccostMsg = new ArrayList();
    long[] arrayOfLong = paramToServiceMsg.extraData.getLongArray("fromUin");
    Object localObject1 = paramToServiceMsg.extraData.getIntArray("msgTime");
    Object localObject2 = paramToServiceMsg.extraData.getShortArray("msgSeq");
    int i;
    Object localObject3;
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      i = 0;
      while (i < arrayOfLong.length)
      {
        localObject3 = new SvcDelMsgInfo();
        ((SvcDelMsgInfo)localObject3).lFromUin = arrayOfLong[i];
        ((SvcDelMsgInfo)localObject3).uMsgTime = localObject1[i];
        ((SvcDelMsgInfo)localObject3).shMsgSeq = localObject2[i];
        localSvcRequestDelMsgV2.vDelInfos.add(localObject3);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "createDelMessageBuff i: " + i + " fromUin:" + arrayOfLong[i] + " msgTime: " + localObject1[i] + " msgSeq:" + localObject2[i]);
        }
        i += 1;
      }
    }
    arrayOfLong = paramToServiceMsg.extraData.getLongArray("accostFromUin");
    localObject1 = paramToServiceMsg.extraData.getLongArray("accostToUin");
    localObject2 = paramToServiceMsg.extraData.getLongArray("accostMsgId");
    paramToServiceMsg = paramToServiceMsg.extraData.getShortArray("accostMsgType");
    if ((arrayOfLong != null) && (arrayOfLong.length > 0))
    {
      i = j;
      while (i < arrayOfLong.length)
      {
        localObject3 = new AccostMsg();
        ((AccostMsg)localObject3).lFromMID = arrayOfLong[i];
        ((AccostMsg)localObject3).lToMID = localObject1[i];
        ((AccostMsg)localObject3).uMsgID = localObject2[i];
        ((AccostMsg)localObject3).shMsgType = paramToServiceMsg[i];
        ((AccostMsg)localObject3).strMsg = new byte[1];
        localSvcRequestDelMsgV2.vAccostMsg.add(localObject3);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "createDelMessageBuff i: " + i + " accostFromUin:" + arrayOfLong[i] + " accostMsgId: " + localObject2[i] + " accostMsgType:" + paramToServiceMsg[i]);
        }
        i += 1;
      }
    }
    paramUniPacket.put("req_DelMsgV2", localSvcRequestDelMsgV2);
    return true;
  }
  
  /* Error */
  private boolean d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: ldc 211
    //   8: invokevirtual 49	com/qq/jce/wup/UniPacket:setServantName	(Ljava/lang/String;)V
    //   11: aload_2
    //   12: ldc_w 299
    //   15: invokevirtual 54	com/qq/jce/wup/UniPacket:setFuncName	(Ljava/lang/String;)V
    //   18: new 301	MessageSvcPack/SvcRequestGetMsgV2
    //   21: dup
    //   22: invokespecial 302	MessageSvcPack/SvcRequestGetMsgV2:<init>	()V
    //   25: astore 10
    //   27: aload 10
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 219	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   34: invokespecial 304	bbzb:a	(Ljava/lang/String;)J
    //   37: putfield 305	MessageSvcPack/SvcRequestGetMsgV2:lUin	J
    //   40: aload 10
    //   42: getfield 305	MessageSvcPack/SvcRequestGetMsgV2:lUin	J
    //   45: lstore 8
    //   47: lload 8
    //   49: lconst_0
    //   50: lcmp
    //   51: ifne +8 -> 59
    //   54: aload_0
    //   55: monitorexit
    //   56: iload 7
    //   58: ireturn
    //   59: aload_1
    //   60: getfield 60	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   63: ldc_w 307
    //   66: invokevirtual 68	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   69: istore 5
    //   71: aload_1
    //   72: getfield 60	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   75: ldc_w 309
    //   78: invokevirtual 313	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   81: istore_3
    //   82: aload_1
    //   83: getfield 60	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   86: ldc_w 315
    //   89: invokevirtual 173	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   92: astore 11
    //   94: aload_1
    //   95: getfield 60	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   98: ldc_w 317
    //   101: invokevirtual 68	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   104: istore 6
    //   106: aload_1
    //   107: getfield 60	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   110: ldc_w 319
    //   113: invokevirtual 313	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   116: istore 4
    //   118: aload_1
    //   119: getfield 60	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   122: ldc_w 321
    //   125: invokevirtual 173	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   128: astore_1
    //   129: aload 10
    //   131: iload 5
    //   133: putfield 324	MessageSvcPack/SvcRequestGetMsgV2:uDateTime	I
    //   136: aload 10
    //   138: iconst_1
    //   139: putfield 328	MessageSvcPack/SvcRequestGetMsgV2:cMsgStoreType	B
    //   142: aload 10
    //   144: iconst_1
    //   145: putfield 331	MessageSvcPack/SvcRequestGetMsgV2:cRecivePic	B
    //   148: aload 10
    //   150: bipush 15
    //   152: putfield 334	MessageSvcPack/SvcRequestGetMsgV2:shAbility	S
    //   155: aload 10
    //   157: iload_3
    //   158: putfield 336	MessageSvcPack/SvcRequestGetMsgV2:cChannel	B
    //   161: aload 10
    //   163: aload 11
    //   165: putfield 338	MessageSvcPack/SvcRequestGetMsgV2:vCookies	[B
    //   168: aload 10
    //   170: iconst_0
    //   171: putfield 341	MessageSvcPack/SvcRequestGetMsgV2:cUnFilter	B
    //   174: aload 10
    //   176: iload 6
    //   178: putfield 343	MessageSvcPack/SvcRequestGetMsgV2:cSyncFlag	I
    //   181: aload 10
    //   183: bipush 20
    //   185: putfield 346	MessageSvcPack/SvcRequestGetMsgV2:shLatestRambleNumber	S
    //   188: aload 10
    //   190: iconst_3
    //   191: putfield 349	MessageSvcPack/SvcRequestGetMsgV2:shOtherRambleNumber	S
    //   194: aload 10
    //   196: iconst_1
    //   197: putfield 352	MessageSvcPack/SvcRequestGetMsgV2:cChannelEx	B
    //   200: aload 10
    //   202: aload_1
    //   203: putfield 354	MessageSvcPack/SvcRequestGetMsgV2:vSyncCookie	[B
    //   206: aload 10
    //   208: iconst_0
    //   209: putfield 357	MessageSvcPack/SvcRequestGetMsgV2:cRambleFlag	B
    //   212: aload 10
    //   214: iconst_0
    //   215: putfield 341	MessageSvcPack/SvcRequestGetMsgV2:cUnFilter	B
    //   218: aload 10
    //   220: iconst_0
    //   221: putfield 360	MessageSvcPack/SvcRequestGetMsgV2:cInst	B
    //   224: aload 10
    //   226: iload 4
    //   228: putfield 363	MessageSvcPack/SvcRequestGetMsgV2:cOnlineSyncFlag	B
    //   231: aload 10
    //   233: iconst_1
    //   234: putfield 366	MessageSvcPack/SvcRequestGetMsgV2:cContextFlag	B
    //   237: aload 10
    //   239: lconst_1
    //   240: putfield 369	MessageSvcPack/SvcRequestGetMsgV2:lGeneralAbi	J
    //   243: aload_2
    //   244: ldc_w 371
    //   247: aload 10
    //   249: invokevirtual 203	com/qq/jce/wup/UniPacket:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   252: iconst_1
    //   253: istore 7
    //   255: goto -201 -> 54
    //   258: astore_1
    //   259: aload_0
    //   260: monitorexit
    //   261: aload_1
    //   262: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	bbzb
    //   0	263	1	paramToServiceMsg	ToServiceMsg
    //   0	263	2	paramUniPacket	UniPacket
    //   81	77	3	b1	byte
    //   116	111	4	b2	byte
    //   69	63	5	i	int
    //   104	73	6	j	int
    //   1	253	7	bool	boolean
    //   45	3	8	l	long
    //   25	223	10	localSvcRequestGetMsgV2	MessageSvcPack.SvcRequestGetMsgV2
    //   92	72	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   5	47	258	finally
    //   59	252	258	finally
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = (SvrMsg)paramToServiceMsg.extraData.getSerializable("SvrMsg");
    paramToServiceMsg = new RespSvrMsg(new RespHeader(paramToServiceMsg.stHeader.shVersion, paramToServiceMsg.stHeader.lMID, 0, ""), paramToServiceMsg.stMsg);
    paramUniPacket.setEncodeName("utf-8");
    paramUniPacket.setServantName("AccostObj");
    paramUniPacket.setFuncName("CMD_SVR_Msg");
    paramUniPacket.put("RespSvrMsg", paramToServiceMsg);
    return true;
  }
  
  private boolean f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new AccostSvc.ReqHeader();
    ((AccostSvc.ReqHeader)localObject).shVersion = 0;
    ((AccostSvc.ReqHeader)localObject).lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    ((AccostSvc.ReqHeader)localObject).iAppID = AppSetting.a();
    long l = paramToServiceMsg.extraData.getLong("lNextMid");
    if (l < 0L) {
      return false;
    }
    localObject = new ReqGetBlackList((AccostSvc.ReqHeader)localObject, l, 1, 0);
    paramUniPacket.setServantName("AccostObj");
    paramUniPacket.setFuncName("CMD_GET_BlackList");
    paramUniPacket.put("ReqGetBlackList", localObject);
    paramToServiceMsg.setTimeout(10000L);
    return true;
  }
  
  private boolean g(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new AccostSvc.ReqHeader();
    ((AccostSvc.ReqHeader)localObject).shVersion = 0;
    ((AccostSvc.ReqHeader)localObject).lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    ((AccostSvc.ReqHeader)localObject).iAppID = AppSetting.a();
    String str = paramToServiceMsg.extraData.getString("deleteUin");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(str));
    localObject = new ReqDeleteBlackList((AccostSvc.ReqHeader)localObject, localArrayList, 0);
    paramUniPacket.setServantName("AccostObj");
    paramUniPacket.setFuncName("CMD_DELETE_BlackList");
    paramUniPacket.put("ReqDeleteBlackList", localObject);
    paramToServiceMsg.setTimeout(10000L);
    return true;
  }
  
  private boolean h(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Object localObject = new AccostSvc.ReqHeader();
    ((AccostSvc.ReqHeader)localObject).shVersion = 0;
    ((AccostSvc.ReqHeader)localObject).lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    ((AccostSvc.ReqHeader)localObject).iAppID = AppSetting.a();
    String str = paramToServiceMsg.extraData.getString("insertUin");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(str));
    localObject = new ReqInsertBlackList((AccostSvc.ReqHeader)localObject, localArrayList, 0);
    paramUniPacket.setServantName("AccostObj");
    paramUniPacket.setFuncName("CMD_INSERT_BlackList");
    paramUniPacket.put("ReqInsertBlackList", localObject);
    paramToServiceMsg.setTimeout(10000L);
    return true;
  }
  
  private boolean i(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    AccostSvc.ReqHeader localReqHeader = new AccostSvc.ReqHeader();
    localReqHeader.shVersion = 0;
    localReqHeader.lMID = a(Long.parseLong(paramToServiceMsg.getUin()));
    localReqHeader.iAppID = AppSetting.a();
    long l1 = paramToServiceMsg.extraData.getLong("to");
    Object localObject2 = paramToServiceMsg.extraData.getString("msg");
    boolean bool = paramToServiceMsg.extraData.getBoolean("hello");
    byte b = paramToServiceMsg.extraData.getByte("cType");
    Object localObject1 = paramToServiceMsg.extraData.getString("pyNickname");
    long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      long l3;
      long l4;
      int j;
      if (b == 18)
      {
        localObject2 = ((String)localObject2).getBytes();
        l3 = paramToServiceMsg.extraData.getLong("timeOut");
        Object localObject3 = new MsgItem(b, (byte[])localObject2);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject3);
        localObject3 = new UserInfo();
        ((UserInfo)localObject3).nickname = ((String)localObject1);
        localObject1 = new RichMsg((ArrayList)localObject2, "", (UserInfo)localObject3, 0);
        l4 = Long.valueOf(paramToServiceMsg.getUin()).longValue();
        j = (int)(System.currentTimeMillis() / 1000L);
        if (!bool) {
          break label313;
        }
      }
      label313:
      for (int i = 1;; i = 2)
      {
        localObject1 = new ClientMsg(localReqHeader, new Msg((short)5, l2, l4, l1, j, i, ((RichMsg)localObject1).toByteArray(), 0L, 0L));
        paramUniPacket.setServantName("AccostObj");
        paramUniPacket.setFuncName("CMD_CLT_Msg");
        paramUniPacket.put("ClientMsg", localObject1);
        paramToServiceMsg.setTimeout(l3);
        return true;
        localObject2 = bbzj.a((String)localObject2);
        break;
      }
    }
  }
  
  private boolean j(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("VideoSvc");
    paramUniPacket.setFuncName("SendVideoMsg");
    Bundle localBundle = paramToServiceMsg.extraData;
    VideoCallMsg localVideoCallMsg = new VideoCallMsg();
    localVideoCallMsg.ver = 1;
    localVideoCallMsg.type = 1;
    localVideoCallMsg.lUin = a(paramToServiceMsg.getUin());
    localVideoCallMsg.lPeerUin = localBundle.getLong("toUin");
    localVideoCallMsg.uDateTime = ((int)System.currentTimeMillis() / 1000);
    localVideoCallMsg.cVerifyType = 0;
    localVideoCallMsg.uSeqId = 0;
    localVideoCallMsg.uSessionId = 0;
    localVideoCallMsg.vMsg = localBundle.getByteArray("vMsg");
    paramUniPacket.put("VideoCallMsg", localVideoCallMsg);
    return true;
  }
  
  private boolean k(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MultiVideo");
    paramUniPacket.setFuncName("MultiVideos2cack");
    paramToServiceMsg = paramToServiceMsg.extraData;
    MultiVideoMsg localMultiVideoMsg = new MultiVideoMsg();
    localMultiVideoMsg.ver = paramToServiceMsg.getByte("ver");
    localMultiVideoMsg.type = paramToServiceMsg.getByte("type");
    localMultiVideoMsg.csCmd = paramToServiceMsg.getShort("cscmd");
    localMultiVideoMsg.subCmd = paramToServiceMsg.getShort("subcmd");
    localMultiVideoMsg.from_uin = a(String.valueOf(paramToServiceMsg.getLong("from_uin")));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramToServiceMsg.getLong("to_uin")));
    localMultiVideoMsg.to_uin = localArrayList;
    localMultiVideoMsg.msg_time = paramToServiceMsg.getLong("msg_time");
    localMultiVideoMsg.msg_type = paramToServiceMsg.getLong("msg_type");
    localMultiVideoMsg.msg_seq = paramToServiceMsg.getLong("msg_seq");
    localMultiVideoMsg.msg_uid = paramToServiceMsg.getLong("msg_uid");
    localMultiVideoMsg.video_buff = paramToServiceMsg.getByteArray("video_buff");
    paramUniPacket.put("MultiVideoMsg", localMultiVideoMsg);
    return true;
  }
  
  private boolean l(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MessageSvc");
    paramUniPacket.setFuncName("SendVideoMsg");
    Bundle localBundle = paramToServiceMsg.extraData;
    SvcRequestSendVideoMsg localSvcRequestSendVideoMsg = new SvcRequestSendVideoMsg();
    localSvcRequestSendVideoMsg.lUin = a(paramToServiceMsg.getUin());
    localSvcRequestSendVideoMsg.lPeerUin = a(localBundle.getString("uin"));
    localSvcRequestSendVideoMsg.uDateTime = ((int)System.currentTimeMillis() / 1000);
    localSvcRequestSendVideoMsg.cVerifyType = localBundle.getByte("cVerifyType");
    localSvcRequestSendVideoMsg.vMsg = localBundle.getByteArray("vMsg");
    paramUniPacket.put("req_SendVideoMsg", localSvcRequestSendVideoMsg);
    paramToServiceMsg = "null";
    if (localSvcRequestSendVideoMsg.vMsg != null) {
      paramToServiceMsg = String.valueOf(localSvcRequestSendVideoMsg.vMsg[2]);
    }
    awch.a("Video", "Send video message :selfUin = " + localSvcRequestSendVideoMsg.lUin + " toUin = " + localSvcRequestSendVideoMsg.lPeerUin + " buffer[2] = " + paramToServiceMsg);
    return true;
  }
  
  private boolean m(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("TransService");
    paramUniPacket.setFuncName("ReqOffFilePack");
    Bundle localBundle = paramToServiceMsg.extraData;
    int k = localBundle.getInt("offfile_type");
    ReqOffFilePack localReqOffFilePack = new ReqOffFilePack();
    localReqOffFilePack.lUIN = a(paramToServiceMsg.getUin());
    paramToServiceMsg = localBundle.getByteArray("filepath");
    int j;
    long l;
    if (paramToServiceMsg == null)
    {
      j = 0;
      l = a(localBundle.getString("uin"));
    }
    int i;
    switch (k)
    {
    default: 
    case 0: 
    case 1: 
      for (;;)
      {
        paramUniPacket.put("ReqOffFilePack", localReqOffFilePack);
        return true;
        j = paramToServiceMsg.length;
        break;
        if (paramToServiceMsg != null)
        {
          localReqOffFilePack.vBody = new byte[10 + j];
          localReqOffFilePack.vBody[0] = 3;
          localReqOffFilePack.vBody[1] = 6;
          bgva.a(localReqOffFilePack.vBody, 2, (short)0);
          bgva.a(localReqOffFilePack.vBody, 4, (short)0);
          bgva.a(localReqOffFilePack.vBody, 6, (short)1);
          bgva.a(localReqOffFilePack.vBody, 8, (short)j);
          bgva.a(localReqOffFilePack.vBody, 10, paramToServiceMsg, j);
          continue;
          localReqOffFilePack.vBody = new byte[13];
          localReqOffFilePack.vBody[0] = 6;
          bgva.a(localReqOffFilePack.vBody, 1, l);
          bgva.a(localReqOffFilePack.vBody, 5, 0L);
          bgva.a(localReqOffFilePack.vBody, 9, 0L);
        }
      }
    case 2: 
      i = localBundle.getByte("result");
      if (paramToServiceMsg == null) {
        break;
      }
    }
    for (k = 8 + j;; k = 8)
    {
      localReqOffFilePack.vBody = new byte[k];
      localReqOffFilePack.vBody[0] = 2;
      localReqOffFilePack.vBody[1] = i;
      bgva.a(localReqOffFilePack.vBody, 2, l);
      bgva.a(localReqOffFilePack.vBody, 6, (short)j);
      bgva.a(localReqOffFilePack.vBody, 8, paramToServiceMsg, j);
      break;
      localBundle.getInt("vip_level");
      byte[] arrayOfByte1 = localBundle.getByteArray("sig");
      l = localBundle.getLong("filesize");
      byte[] arrayOfByte2 = localBundle.getByteArray("filemd5");
      localReqOffFilePack.vBody = a(arrayOfByte1, paramToServiceMsg, localBundle.getByteArray("filename"), arrayOfByte2, l);
      break;
      if (paramToServiceMsg == null) {
        break;
      }
      localReqOffFilePack.vBody = new byte[10 + j];
      localReqOffFilePack.vBody[0] = 3;
      localReqOffFilePack.vBody[1] = 6;
      bgva.a(localReqOffFilePack.vBody, 2, (short)0);
      bgva.a(localReqOffFilePack.vBody, 4, (short)0);
      bgva.a(localReqOffFilePack.vBody, 6, (short)1);
      bgva.a(localReqOffFilePack.vBody, 8, (short)j);
      bgva.a(localReqOffFilePack.vBody, 10, paramToServiceMsg, j);
      break;
    }
  }
  
  private boolean n(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("TransService");
    paramUniPacket.setFuncName("ReqGetSign");
    Bundle localBundle = paramToServiceMsg.extraData;
    ReqGetSign localReqGetSign = new ReqGetSign();
    localReqGetSign.lUIN = a(paramToServiceMsg.getUin());
    localReqGetSign.uSSOVer = localBundle.getInt("ssover");
    localReqGetSign.uAppID = localBundle.getInt("app_id");
    localReqGetSign.cA2Type = localBundle.getByte("a2type");
    localReqGetSign.vA2 = new byte[0];
    localReqGetSign.vCiphertext = localBundle.getByteArray("enkey");
    paramUniPacket.put("ReqGetSign", localReqGetSign);
    return true;
  }
  
  private boolean o(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("TransService");
    paramUniPacket.setFuncName("ReqTmpChatPicDownload");
    Bundle localBundle = paramToServiceMsg.extraData;
    ReqTmpChatPicDownload localReqTmpChatPicDownload = new ReqTmpChatPicDownload();
    localReqTmpChatPicDownload.lUIN = a(paramToServiceMsg.getUin());
    int i = bbxc.a;
    bbxc.a = i + 1;
    localReqTmpChatPicDownload.lSeq = i;
    localReqTmpChatPicDownload.strFlieKey = localBundle.getString("filekey");
    localReqTmpChatPicDownload.getPicSize = localBundle.getByte("picscale");
    paramUniPacket.put("ReqTmpChatPicDownload", localReqTmpChatPicDownload);
    return true;
  }
  
  private boolean p(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MessageSvc.SetRoamMsgAllUser");
    paramUniPacket.setFuncName("SetRoamMsgAllUser");
    Bundle localBundle = paramToServiceMsg.extraData;
    SvcRequestSetRoamMsgAllUser localSvcRequestSetRoamMsgAllUser = new SvcRequestSetRoamMsgAllUser();
    localSvcRequestSetRoamMsgAllUser.lUin = a(paramToServiceMsg.getUin());
    localSvcRequestSetRoamMsgAllUser.shType = localBundle.getShort("shType");
    localSvcRequestSetRoamMsgAllUser.cValue = localBundle.getByte("cValue");
    localSvcRequestSetRoamMsgAllUser.cVerifyType = 0;
    paramUniPacket.put("req_SetRoamMsgAllUser", localSvcRequestSetRoamMsgAllUser);
    return true;
  }
  
  private boolean q(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MessageSvc.DelRoamMsg");
    paramUniPacket.setFuncName("DelRoamMsg");
    Bundle localBundle = paramToServiceMsg.extraData;
    SvcRequestDelRoamMsg localSvcRequestDelRoamMsg = new SvcRequestDelRoamMsg();
    localSvcRequestDelRoamMsg.lUin = a(paramToServiceMsg.getUin());
    localSvcRequestDelRoamMsg.lPeerUin = a(localBundle.getString("uin"));
    localSvcRequestDelRoamMsg.cVerifyType = 0;
    paramUniPacket.put("req_DelRoamMsg", localSvcRequestDelRoamMsg);
    return true;
  }
  
  private boolean r(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StreamSvr");
    paramUniPacket.setFuncName("GetCSUploadStreamMsgBuf");
    long l1 = b(Long.valueOf(paramToServiceMsg.extraData.getString("uin")).longValue());
    String str = paramToServiceMsg.extraData.getString("filepath");
    Object localObject1 = paramToServiceMsg.extraData.getString("selfuin");
    Object localObject2 = paramToServiceMsg.extraData.getString("uin");
    Short localShort = Short.valueOf(paramToServiceMsg.extraData.getShort("PackSeq"));
    int i = paramToServiceMsg.extraData.getInt("msgseq");
    long l2 = paramToServiceMsg.extraData.getLong("random");
    long l3 = paramToServiceMsg.extraData.getLong("VoiceType");
    long l4 = paramToServiceMsg.extraData.getLong("VoiceLength");
    long l5 = paramToServiceMsg.extraData.getLong("SubBubbleId");
    int j = paramToServiceMsg.extraData.getInt("DiyTextId");
    paramToServiceMsg = new StreamInfo();
    paramToServiceMsg.lFromUIN = a((String)localObject1);
    paramToServiceMsg.lToUIN = a((String)localObject2);
    paramToServiceMsg.iMsgId = bcvj.b(str);
    paramToServiceMsg.type = 1;
    paramToServiceMsg.iSendTime = 0;
    paramToServiceMsg.shPackNum = bcvj.b(str);
    paramToServiceMsg.shFlowLayer = bcvj.a(str);
    paramToServiceMsg.pttTime = l4;
    paramToServiceMsg.pttFormat = l3;
    paramToServiceMsg.subBubbleId = l5;
    int k = bebf.a();
    paramToServiceMsg.netType = k;
    if (localShort.shortValue() == 1)
    {
      localObject1 = new ptt_reserve.ReserveStruct();
      ((ptt_reserve.ReserveStruct)localObject1).uint32_change_voice.set(0);
      ((ptt_reserve.ReserveStruct)localObject1).uint32_autototext_voice.set(0);
      localObject2 = new im_msg_body.GeneralFlags();
      ((im_msg_body.GeneralFlags)localObject2).uint32_bubble_sub_id.set((int)l5);
      ((im_msg_body.GeneralFlags)localObject2).uint32_bubble_diy_text_id.set(j);
      ((ptt_reserve.ReserveStruct)localObject1).bytes_general_flags.set(ByteStringMicro.copyFrom(((im_msg_body.GeneralFlags)localObject2).toByteArray()));
      paramToServiceMsg.vPbData = ((ptt_reserve.ReserveStruct)localObject1).toByteArray();
    }
    if (QLog.isColorLevel())
    {
      QLog.d("RecordParams", 2, "C2CStreamUp: type[" + l3 + "] length[" + l4 + "]");
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "C2CStreamUp: net[" + k + "]");
      }
    }
    localObject1 = new StreamData();
    ((StreamData)localObject1).shPackSeq = localShort.shortValue();
    if (((StreamData)localObject1).shPackSeq < paramToServiceMsg.shPackNum) {
      paramToServiceMsg.shPackNum = 0;
    }
    ((StreamData)localObject1).vData = bcvj.a(str, localShort.shortValue());
    boolean bool = bcvj.b(str);
    if (bool)
    {
      paramToServiceMsg.shPackNum = 0;
      paramToServiceMsg.oprType = 1;
      bcvj.a(str);
    }
    if (QLog.isColorLevel()) {
      QLog.d("StreamPtt", 2, "shPackSeq:" + localShort + " shPackNum:" + paramToServiceMsg.shPackNum + ",layer:" + paramToServiceMsg.shFlowLayer + ",msgId:" + paramToServiceMsg.iMsgId + " cancelled:" + bool);
    }
    new QQService.ReqHeader((short)0, paramUniPacket.getRequestId(), l1);
    if ((i == 0) && (l2 == 0L)) {
      paramUniPacket.put("CSUploadStreamMsg", new CSUploadStreamMsg((short)1, paramUniPacket.getRequestId(), paramToServiceMsg, (StreamData)localObject1, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet()));
    }
    for (;;)
    {
      return true;
      paramToServiceMsg.msgSeq = i;
      paramToServiceMsg.random = l2;
      paramUniPacket.put("CSUploadStreamMsg", new CSUploadStreamMsg((short)10, paramUniPacket.getRequestId(), paramToServiceMsg, (StreamData)localObject1, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet()));
    }
  }
  
  private boolean s(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("StreamSvr");
    paramUniPacket.setFuncName("GetCSRespPushStreamMsgBuf");
    String str1 = paramToServiceMsg.extraData.getString("filepath");
    String str2 = paramToServiceMsg.extraData.getString("selfuin");
    String str3 = paramToServiceMsg.extraData.getString("uin");
    Short localShort = Short.valueOf(paramToServiceMsg.extraData.getShort("PackSeq"));
    long l = paramToServiceMsg.extraData.getLong("lkey");
    paramToServiceMsg = new StreamInfo();
    paramToServiceMsg.lFromUIN = a(str3);
    paramToServiceMsg.lToUIN = a(str2);
    paramToServiceMsg.iMsgId = bcvj.b(str1);
    paramToServiceMsg.type = 1;
    paramToServiceMsg.iSendTime = 0;
    paramToServiceMsg.shPackNum = 0;
    paramToServiceMsg.shFlowLayer = bcvj.a(str1);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt.recv", 2, "createReqpushStreamMsg ---streaminfo.lFromUIN= " + paramToServiceMsg.lFromUIN + "---streaminfo.shFlowLayer = " + paramToServiceMsg.shFlowLayer + "---streaminfo.lToUIN = " + paramToServiceMsg.lToUIN + "---streaminfo.iMsgId = " + paramToServiceMsg.iMsgId + "---PackSeq = " + localShort + "---lKey = " + l);
    }
    paramUniPacket.put("CSRespPushStreamMsg", new CSRespPushStreamMsg((short)1, paramUniPacket.getRequestId(), paramToServiceMsg, localShort.shortValue(), l));
    return true;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if ("MessageSvc.DelMsgV2".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.GetMsgV4".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return d(paramToServiceMsg, paramUniPacket);
    }
    if ("TransService.ReqGetSign".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return n(paramToServiceMsg, paramUniPacket);
    }
    if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return o(paramToServiceMsg, paramUniPacket);
    }
    if ("TransService.ReqOffFilePack".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return m(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return p(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return q(paramToServiceMsg, paramUniPacket);
    }
    if ("MessageSvc.SendVideoMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return l(paramToServiceMsg, paramUniPacket);
    }
    if ("StreamSvr.UploadStreamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return r(paramToServiceMsg, paramUniPacket);
    }
    if ("StreamSvr.RespPushStreamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return s(paramToServiceMsg, paramUniPacket);
    }
    if ("VideoCCSvc.Adaptation".equals(paramToServiceMsg.getServiceCmd())) {
      return j(paramToServiceMsg, paramUniPacket);
    }
    if ("MultiVideo.s2cack".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return k(paramToServiceMsg, paramUniPacket);
    }
    if ("OnlinePush.RespPush".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if ("AccostSvc.ClientMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return i(paramToServiceMsg, paramUniPacket);
    }
    if ("AccostSvc.ReqInsertBlackList".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return h(paramToServiceMsg, paramUniPacket);
    }
    if ("AccostSvc.ReqDeleteBlackList".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return g(paramToServiceMsg, paramUniPacket);
    }
    if ("AccostSvc.ReqGetBlackList".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return f(paramToServiceMsg, paramUniPacket);
    }
    if ("AccostSvc.SvrMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, long paramLong)
  {
    int i1 = 2;
    int i;
    int j;
    label17:
    int k;
    label24:
    int m;
    label32:
    int n;
    label40:
    label44:
    byte[] arrayOfByte;
    if (paramArrayOfByte1 == null)
    {
      i = 2;
      if (paramArrayOfByte1 != null) {
        break label341;
      }
      j = 2;
      if (paramArrayOfByte3 != null) {
        break label350;
      }
      k = 2;
      if (paramArrayOfByte4 != null) {
        break label359;
      }
      m = 1;
      if (paramArrayOfByte4 != null) {
        break label369;
      }
      n = 1;
      if (paramArrayOfByte2 != null) {
        break label379;
      }
      arrayOfByte = new byte[i1 + (n + (j + (5 + i) + 6 + k + m))];
      arrayOfByte[0] = 1;
      bgva.a(arrayOfByte, 1, 0L);
      if (paramArrayOfByte1 == null) {
        break label388;
      }
      bgva.a(arrayOfByte, 5, (short)paramArrayOfByte1.length);
      bgva.a(arrayOfByte, 7, paramArrayOfByte1, paramArrayOfByte1.length);
      i = paramArrayOfByte1.length + 7;
      label112:
      if (paramArrayOfByte1 == null) {
        break label402;
      }
      bgva.a(arrayOfByte, i, (short)paramArrayOfByte1.length);
      i += 2;
      bgva.a(arrayOfByte, i, paramArrayOfByte1, paramArrayOfByte1.length);
      i += paramArrayOfByte1.length;
      label149:
      bgva.a(arrayOfByte, i, (short)0);
      i += 2;
      bgva.a(arrayOfByte, i, paramLong);
      i += 4;
      if (paramArrayOfByte3 == null) {
        break label419;
      }
      bgva.a(arrayOfByte, i, (short)paramArrayOfByte3.length);
      i += 2;
      bgva.a(arrayOfByte, i, paramArrayOfByte3, paramArrayOfByte3.length);
      i += paramArrayOfByte3.length;
      label215:
      if (paramArrayOfByte4 == null) {
        break label436;
      }
      arrayOfByte[i] = ((byte)paramArrayOfByte4.length);
      i += 1;
      bgva.a(arrayOfByte, i, paramArrayOfByte4, paramArrayOfByte4.length);
      i += paramArrayOfByte4.length;
      label255:
      if (paramArrayOfByte4 == null) {
        break label451;
      }
      arrayOfByte[i] = ((byte)paramArrayOfByte4.length);
      i += 1;
      bgva.a(arrayOfByte, i, paramArrayOfByte4, paramArrayOfByte4.length);
      i += paramArrayOfByte4.length;
    }
    for (;;)
    {
      if (paramArrayOfByte2 == null) {
        break label466;
      }
      bgva.a(arrayOfByte, i, (short)paramArrayOfByte2.length);
      i += 2;
      bgva.a(arrayOfByte, i, paramArrayOfByte2, paramArrayOfByte2.length);
      i = paramArrayOfByte2.length;
      return arrayOfByte;
      i = paramArrayOfByte1.length + 2;
      break;
      label341:
      j = paramArrayOfByte1.length + 2;
      break label17;
      label350:
      k = paramArrayOfByte3.length + 2;
      break label24;
      label359:
      m = paramArrayOfByte4.length + 1;
      break label32;
      label369:
      n = paramArrayOfByte4.length + 1;
      break label40;
      label379:
      i1 = paramArrayOfByte2.length + 2;
      break label44;
      label388:
      bgva.a(arrayOfByte, 5, (short)0);
      i = 7;
      break label112;
      label402:
      bgva.a(arrayOfByte, i, (short)0);
      i += 2;
      break label149;
      label419:
      bgva.a(arrayOfByte, i, (short)0);
      i += 2;
      break label215;
      label436:
      arrayOfByte[i] = 0;
      i += 1;
      break label255;
      label451:
      arrayOfByte[i] = 0;
      i += 1;
    }
    label466:
    bgva.a(arrayOfByte, i, (short)0);
    return arrayOfByte;
  }
  
  long b(long paramLong)
  {
    return 0xFFFFFFFF & paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbzb
 * JD-Core Version:    0.7.0.1
 */