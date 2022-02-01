import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xca6.WeatherReportStore.TipsItem;
import tencent.im.oidb.cmd0xca6.WeatherReportStore.TipsList;
import tencent.im.oidb.cmd0xca6.WeatherReportStore.WeatherInfo;
import tencent.im.oidb.cmd0xca6.oidb_0xca6.ReqBody;
import tencent.im.oidb.cmd0xca6.oidb_0xca6.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class azgl
  extends MSFServlet
{
  public static NewIntent a(QQAppInterface paramQQAppInterface, ArrayList<Integer> paramArrayList, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), azgl.class);
    localNewIntent.putExtra("type", paramArrayList);
    localNewIntent.putExtra("adcode", paramInt1);
    localNewIntent.putExtra("request_from", paramInt2);
    localNewIntent.putExtra("request_bundle", paramBundle);
    paramQQAppInterface.startServlet(localNewIntent);
    return localNewIntent;
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherServlet", 2, "packWeatherPackage");
    }
    Object localObject = paramIntent.getIntegerArrayListExtra("type");
    int i = paramIntent.getIntExtra("adcode", 0);
    paramIntent = new oidb_0xca6.ReqBody();
    if (localObject != null) {
      paramIntent.type.set((List)localObject);
    }
    paramIntent.adcode.set(i);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3238);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(4);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    paramPacket.setSSOCommand("OidbSvc.0xca6_4");
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
  }
  
  private void a(oidb_0xca6.RspBody paramRspBody, Intent paramIntent, int paramInt)
  {
    int i = paramIntent.getIntExtra("adcode", 0);
    String str1 = paramRspBody.weather_info.temper.get();
    String str2 = paramRspBody.weather_info.weather_type.get();
    String str3 = paramRspBody.weather_info.weather_type_id.get();
    List localList = paramRspBody.tips_list.tips.get();
    QQAppInterface localQQAppInterface;
    anvk localanvk;
    Friends localFriends;
    if ((getAppRuntime() instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)getAppRuntime();
      localanvk = (anvk)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localFriends = localanvk.d(localQQAppInterface.getCurrentUin());
      localFriends.temper = str1;
      localFriends.weatherType = str2;
      localFriends.weatherTypeId = str3;
      localFriends.weatherUpdateTime = NetConnInfoCenter.getServerTime();
      localFriends.adCode = String.valueOf(i);
      localFriends.city = paramRspBody.city.get();
      localFriends.area = paramRspBody.area.get();
      if ((localList != null) && (localList.size() > 0)) {
        localFriends.weatherTip = ((WeatherReportStore.TipsItem)localList.get(0)).content.get();
      }
      if (QLog.isColorLevel()) {
        QLog.d("WeatherServlet", 2, "handleWeatherPackage temper:" + str1 + " weatherType=" + str2 + " weatherTypeId=" + str3 + " weatherUpdateTime=" + localFriends.weatherUpdateTime + " adCode=" + localFriends.adCode + " city=" + localFriends.city + " area=" + localFriends.area);
      }
      if (!azch.c(localFriends)) {
        break label351;
      }
    }
    label351:
    for (i = 0;; i = 1)
    {
      localFriends.weatherFlag = i;
      localanvk.a(localFriends);
      ((azbv)localQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).b(paramInt, paramIntent);
      return;
    }
  }
  
  /* Error */
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 35
    //   3: iconst_0
    //   4: invokevirtual 71	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   7: istore_3
    //   8: aload_2
    //   9: invokevirtual 327	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   12: ifeq +282 -> 294
    //   15: new 93	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   18: dup
    //   19: invokespecial 94	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   22: astore 5
    //   24: aload_2
    //   25: invokevirtual 330	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   28: invokestatic 333	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   31: astore_2
    //   32: aload_2
    //   33: invokevirtual 336	java/nio/ByteBuffer:getInt	()I
    //   36: iconst_4
    //   37: isub
    //   38: newarray byte
    //   40: astore 6
    //   42: aload_2
    //   43: aload 6
    //   45: invokevirtual 338	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   48: pop
    //   49: aload 5
    //   51: aload 6
    //   53: invokevirtual 342	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   56: pop
    //   57: aload 5
    //   59: astore 6
    //   61: aload 6
    //   63: getfield 103	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   66: invokevirtual 344	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   69: istore 4
    //   71: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +27 -> 101
    //   77: ldc 55
    //   79: iconst_2
    //   80: iconst_2
    //   81: anewarray 346	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: ldc_w 348
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: iload 4
    //   94: invokestatic 353	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: invokestatic 356	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   101: iload 4
    //   103: ifne +179 -> 282
    //   106: aload 6
    //   108: getfield 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   111: invokevirtual 359	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   114: ifeq +168 -> 282
    //   117: aload 6
    //   119: getfield 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   122: invokevirtual 362	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   125: ifnull +157 -> 282
    //   128: aload 6
    //   130: getfield 107	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   133: invokevirtual 362	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   136: invokevirtual 363	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   139: astore_2
    //   140: new 154	tencent/im/oidb/cmd0xca6/oidb_0xca6$RspBody
    //   143: dup
    //   144: invokespecial 364	tencent/im/oidb/cmd0xca6/oidb_0xca6$RspBody:<init>	()V
    //   147: astore 5
    //   149: aload 5
    //   151: aload_2
    //   152: invokevirtual 365	tencent/im/oidb/cmd0xca6/oidb_0xca6$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   155: pop
    //   156: aload 5
    //   158: getfield 368	tencent/im/oidb/cmd0xca6/oidb_0xca6$RspBody:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   161: invokevirtual 369	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   164: ifeq +118 -> 282
    //   167: aload 5
    //   169: getfield 368	tencent/im/oidb/cmd0xca6/oidb_0xca6$RspBody:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   172: invokevirtual 344	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   175: ifne +107 -> 282
    //   178: aload 5
    //   180: getfield 158	tencent/im/oidb/cmd0xca6/oidb_0xca6$RspBody:weather_info	Ltencent/im/oidb/cmd0xca6/WeatherReportStore$WeatherInfo;
    //   183: invokevirtual 370	tencent/im/oidb/cmd0xca6/WeatherReportStore$WeatherInfo:has	()Z
    //   186: ifeq +96 -> 282
    //   189: aload 5
    //   191: getfield 180	tencent/im/oidb/cmd0xca6/oidb_0xca6$RspBody:tips_list	Ltencent/im/oidb/cmd0xca6/WeatherReportStore$TipsList;
    //   194: invokevirtual 371	tencent/im/oidb/cmd0xca6/WeatherReportStore$TipsList:has	()Z
    //   197: ifeq +85 -> 282
    //   200: aload_0
    //   201: aload 5
    //   203: aload_1
    //   204: iload_3
    //   205: invokespecial 373	azgl:a	(Ltencent/im/oidb/cmd0xca6/oidb_0xca6$RspBody;Landroid/content/Intent;I)V
    //   208: new 375	android/os/Bundle
    //   211: dup
    //   212: invokespecial 376	android/os/Bundle:<init>	()V
    //   215: astore_2
    //   216: aload_2
    //   217: ldc 35
    //   219: iload_3
    //   220: invokevirtual 379	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   223: aload_0
    //   224: aload_1
    //   225: iconst_1
    //   226: iconst_1
    //   227: aload_2
    //   228: ldc_w 381
    //   231: invokevirtual 385	azgl:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   234: return
    //   235: astore 5
    //   237: aconst_null
    //   238: astore_2
    //   239: aload_2
    //   240: astore 6
    //   242: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq -184 -> 61
    //   248: ldc 55
    //   250: iconst_2
    //   251: ldc_w 387
    //   254: aload 5
    //   256: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   259: aload_2
    //   260: astore 6
    //   262: goto -201 -> 61
    //   265: astore_2
    //   266: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +13 -> 282
    //   272: ldc 55
    //   274: iconst_2
    //   275: ldc_w 392
    //   278: aload_2
    //   279: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: aload_0
    //   283: aload_1
    //   284: iconst_1
    //   285: iconst_0
    //   286: aconst_null
    //   287: ldc_w 381
    //   290: invokevirtual 385	azgl:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   293: return
    //   294: invokestatic 53	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq -15 -> 282
    //   300: ldc 55
    //   302: iconst_2
    //   303: new 272	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 393	java/lang/StringBuilder:<init>	()V
    //   310: ldc_w 395
    //   313: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: aload_2
    //   317: invokevirtual 398	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   320: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   323: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 61	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: goto -47 -> 282
    //   332: astore 6
    //   334: aload 5
    //   336: astore_2
    //   337: aload 6
    //   339: astore 5
    //   341: goto -102 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	azgl
    //   0	344	1	paramIntent	Intent
    //   0	344	2	paramFromServiceMsg	FromServiceMsg
    //   7	213	3	i	int
    //   69	33	4	j	int
    //   22	180	5	localObject1	Object
    //   235	100	5	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   339	1	5	localObject2	Object
    //   40	221	6	localObject3	Object
    //   332	6	6	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    // Exception table:
    //   from	to	target	type
    //   15	24	235	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   140	234	265	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   24	57	332	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    a(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgl
 * JD-Core Version:    0.7.0.1
 */