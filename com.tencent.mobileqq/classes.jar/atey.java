import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.aio.video.aio_video.ReqGetOpenIdByUin;

public class atey
  extends MSFServlet
{
  public static NewIntent a(long paramLong1, long paramLong2, QQAppInterface paramQQAppInterface)
  {
    int i = bdeu.a(paramLong2);
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), atey.class);
    localNewIntent.putExtra("appId", i);
    localNewIntent.putExtra("sso_command", "QQAIOMediaSvc.get_openid_by_uin");
    localNewIntent.putExtra("req_type", 1);
    localNewIntent.putExtra("uin", paramLong1);
    paramQQAppInterface.startServlet(localNewIntent);
    return localNewIntent;
  }
  
  /* Error */
  private void a(int paramInt, Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_3
    //   4: invokevirtual 62	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   7: invokestatic 68	bdpd:b	([B)[B
    //   10: astore 9
    //   12: aload_3
    //   13: invokevirtual 72	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +326 -> 342
    //   19: aload 9
    //   21: ifnull +321 -> 342
    //   24: new 74	android/os/Bundle
    //   27: dup
    //   28: invokespecial 75	android/os/Bundle:<init>	()V
    //   31: astore 8
    //   33: aload_2
    //   34: ldc 29
    //   36: iconst_0
    //   37: invokevirtual 81	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   40: istore 4
    //   42: aload_2
    //   43: ldc 44
    //   45: lconst_0
    //   46: invokevirtual 85	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   49: lstore 6
    //   51: aload 8
    //   53: ldc 29
    //   55: iload 4
    //   57: invokevirtual 89	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   60: aload 8
    //   62: ldc 44
    //   64: lload 6
    //   66: invokevirtual 93	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   69: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +61 -> 133
    //   75: ldc 100
    //   77: iconst_2
    //   78: new 102	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   85: ldc 105
    //   87: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: iload 5
    //   92: invokevirtual 112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   95: ldc 114
    //   97: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_3
    //   101: invokevirtual 118	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   104: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: ldc 123
    //   109: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: iload 4
    //   114: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc 125
    //   119: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: lload 6
    //   124: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   127: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: iload 5
    //   135: ifeq +154 -> 289
    //   138: new 138	tencent/aio/video/aio_video$RspGetOpenIdByUin
    //   141: dup
    //   142: invokespecial 139	tencent/aio/video/aio_video$RspGetOpenIdByUin:<init>	()V
    //   145: astore_3
    //   146: aload_3
    //   147: aload 9
    //   149: invokevirtual 143	tencent/aio/video/aio_video$RspGetOpenIdByUin:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   152: pop
    //   153: aload_3
    //   154: getfield 147	tencent/aio/video/aio_video$RspGetOpenIdByUin:err_info	Ltencent/aio/video/aio_video$ErrInfo;
    //   157: getfield 153	tencent/aio/video/aio_video$ErrInfo:err_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   160: invokevirtual 158	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   163: istore 4
    //   165: iload 4
    //   167: ifne +59 -> 226
    //   170: aload_3
    //   171: getfield 162	tencent/aio/video/aio_video$RspGetOpenIdByUin:open_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   174: invokevirtual 167	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   177: invokevirtual 172	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   180: astore_3
    //   181: aload 8
    //   183: ldc 174
    //   185: aload_3
    //   186: invokevirtual 178	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: ldc 100
    //   191: iconst_2
    //   192: new 102	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   199: ldc 180
    //   201: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_3
    //   205: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload_0
    //   215: aload_2
    //   216: iload_1
    //   217: iconst_1
    //   218: aload 8
    //   220: ldc 182
    //   222: invokevirtual 186	atey:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   225: return
    //   226: aload_3
    //   227: getfield 147	tencent/aio/video/aio_video$RspGetOpenIdByUin:err_info	Ltencent/aio/video/aio_video$ErrInfo;
    //   230: getfield 189	tencent/aio/video/aio_video$ErrInfo:err_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: invokevirtual 167	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   236: invokevirtual 172	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   239: astore_3
    //   240: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +38 -> 281
    //   246: ldc 100
    //   248: iconst_2
    //   249: new 102	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   256: ldc 191
    //   258: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: iload 4
    //   263: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: ldc 193
    //   268: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_3
    //   272: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 196	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload 8
    //   283: ldc 198
    //   285: aload_3
    //   286: invokevirtual 178	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload_0
    //   290: aload_2
    //   291: iload_1
    //   292: iconst_0
    //   293: aload 8
    //   295: ldc 182
    //   297: invokevirtual 186	atey:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   300: return
    //   301: astore_3
    //   302: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq -16 -> 289
    //   308: ldc 100
    //   310: iconst_2
    //   311: ldc 200
    //   313: aload_3
    //   314: invokestatic 203	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   317: goto -28 -> 289
    //   320: astore_2
    //   321: aload_2
    //   322: athrow
    //   323: astore_3
    //   324: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq -38 -> 289
    //   330: ldc 100
    //   332: iconst_2
    //   333: ldc 205
    //   335: aload_3
    //   336: invokestatic 203	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   339: goto -50 -> 289
    //   342: iconst_0
    //   343: istore 5
    //   345: goto -321 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	this	atey
    //   0	348	1	paramInt	int
    //   0	348	2	paramIntent	Intent
    //   0	348	3	paramFromServiceMsg	FromServiceMsg
    //   40	222	4	i	int
    //   1	343	5	bool	boolean
    //   49	74	6	l	long
    //   31	263	8	localBundle	android.os.Bundle
    //   10	138	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   138	165	301	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   170	225	301	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   226	281	301	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   281	289	301	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   138	165	320	finally
    //   170	225	320	finally
    //   226	281	320	finally
    //   281	289	320	finally
    //   302	317	320	finally
    //   324	339	320	finally
    //   138	165	323	java/lang/Exception
    //   170	225	323	java/lang/Exception
    //   226	281	323	java/lang/Exception
    //   281	289	323	java/lang/Exception
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("uin", 0L);
    int i = paramIntent.getIntExtra("appId", 0);
    paramIntent = paramIntent.getStringExtra("sso_command");
    if (QLog.isColorLevel()) {
      QLog.d("FetchOpenIdServlet", 2, "sendPacket uin=" + l + " appId=" + i);
    }
    aio_video.ReqGetOpenIdByUin localReqGetOpenIdByUin = new aio_video.ReqGetOpenIdByUin();
    localReqGetOpenIdByUin.app_id.set(i);
    localReqGetOpenIdByUin.target_uin.set(l);
    paramPacket.setSSOCommand(paramIntent);
    paramPacket.putSendData(bdpd.a(localReqGetOpenIdByUin.toByteArray()));
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramIntent.getIntExtra("req_type", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FetchOpenIdServlet", 2, "onReceive cmd:" + i);
    }
    a(i, paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FetchOpenIdServlet", 2, "onSend");
    }
    a(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atey
 * JD-Core Version:    0.7.0.1
 */