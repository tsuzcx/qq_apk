import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class andy
  extends MSFServlet
{
  public static SparseIntArray a;
  public static int[][] a;
  
  static
  {
    Object localObject = { 2131427352, -127 };
    int[] arrayOfInt1 = { 2131427353, -128 };
    int[] arrayOfInt2 = { 2131427351, -208 };
    int[] arrayOfInt3 = { 2131427350, -220 };
    int[] arrayOfInt4 = { 2131427348, 152 };
    int[] arrayOfInt5 = { 2131427361, 317 };
    int[] arrayOfInt6 = { -1, 356 };
    int[] arrayOfInt7 = { -1, 366 };
    jdField_a_of_type_Array2dOfInt = new int[][] { localObject, arrayOfInt1, { 2131427354, -150 }, { 2131427349, -151 }, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, { 2131427363, 318 }, { -1, 219 }, { -1, 350 }, arrayOfInt6, arrayOfInt7 };
    jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray(jdField_a_of_type_Array2dOfInt.length);
    localObject = jdField_a_of_type_Array2dOfInt;
    int j = localObject.length;
    int i = 0;
    if (i < j)
    {
      arrayOfInt1 = localObject[i];
      int k = arrayOfInt1[0];
      int m = arrayOfInt1[1];
      if (k != -1) {
        jdField_a_of_type_AndroidUtilSparseIntArray.put(sxm.a(k), m);
      }
      for (;;)
      {
        i += 1;
        break;
        jdField_a_of_type_AndroidUtilSparseIntArray.put(m, m);
      }
    }
    sxp.a(jdField_a_of_type_AndroidUtilSparseIntArray);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Intent paramIntent, Packet paramPacket)
  {
    ConfigurationService.ReqGetConfig localReqGetConfig = new ConfigurationService.ReqGetConfig();
    paramIntent = paramIntent.getStringExtra("key_uin");
    int k = jdField_a_of_type_AndroidUtilSparseIntArray.size();
    ArrayList localArrayList1 = new ArrayList(k);
    boolean bool = bbkb.b(paramQQAppInterface.getApp(), "Q.qqstory.config.QQStoryConfigServlet");
    ArrayList localArrayList2 = new ArrayList(k);
    int i = 0;
    if (i < k)
    {
      int m = jdField_a_of_type_AndroidUtilSparseIntArray.keyAt(i);
      String str = tcs.a(jdField_a_of_type_AndroidUtilSparseIntArray.valueAt(i));
      ConfigurationService.ConfigSeq localConfigSeq = new ConfigurationService.ConfigSeq();
      localConfigSeq.type.set(m);
      int j = 0;
      if (bool) {
        bbkb.b(paramQQAppInterface.getApp(), str, paramIntent);
      }
      for (;;)
      {
        localConfigSeq.version.set(j);
        localArrayList1.add(localConfigSeq);
        localArrayList2.add(Integer.valueOf(m));
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.config.QQStoryConfigServlet", 2, new Object[] { "addAllConfigs|send type: " + m, " version: ", Integer.valueOf(j) });
        }
        i += 1;
        break;
        j = bbkb.a(paramQQAppInterface.getApp(), str, paramIntent);
      }
    }
    if (bool) {
      bbkb.g(paramQQAppInterface.getApp(), "Q.qqstory.config.QQStoryConfigServlet");
    }
    if (QLog.isColorLevel())
    {
      i = localArrayList2.size();
      QLog.d("Q.qqstory.config.QQStoryConfigServlet", 2, "addAllConfigs|send length: " + i);
    }
    localReqGetConfig.setHasFlag(true);
    localReqGetConfig.seq_list.addAll(localArrayList1);
    paramQQAppInterface = SosoInterface.b();
    ved.b("Q.qqstory.config.QQStoryConfigServlet", "addAllConfigs");
    if (paramQQAppInterface == null) {
      ved.b("Q.qqstory.config.QQStoryConfigServlet", "lbsInfo is null.");
    }
    for (;;)
    {
      paramQQAppInterface = a(localReqGetConfig);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
        paramPacket.putSendData(paramQQAppInterface);
      }
      paramPacket.setSSOCommand("ConfigurationService.ReqGetConfig");
      return;
      if (paramQQAppInterface.a == null)
      {
        ved.b("Q.qqstory.config.QQStoryConfigServlet", "lbsInfo.location is null.");
      }
      else if (TextUtils.isEmpty(paramQQAppInterface.a.f))
      {
        ved.b("Q.qqstory.config.QQStoryConfigServlet", "lbsInfo.location.cityCode is null");
      }
      else
      {
        ved.a("Q.qqstory.config.QQStoryConfigServlet", "adcode:%s", paramQQAppInterface.a.f);
        localReqGetConfig.adcode.set(Long.valueOf(paramQQAppInterface.a.f).longValue());
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), andy.class);
    localNewIntent.putExtra("key_uin", paramString);
    localNewIntent.putExtra("k_req_occasion", 0);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void a(ConfigurationService.RespGetConfig paramRespGetConfig, QQAppInterface paramQQAppInterface, Intent paramIntent, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramRespGetConfig.result.get() != 0) || (paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0))
    {
      if (!paramBoolean) {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, "receiveAllConfigs|isSuccess == false");
        }
      }
      for (;;)
      {
        i = 0;
        while (i < jdField_a_of_type_AndroidUtilSparseIntArray.size())
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, "receiveAllConfigs|failed type: " + jdField_a_of_type_AndroidUtilSparseIntArray.keyAt(i));
          }
          i += 1;
        }
        if (paramRespGetConfig.result.get() != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, "receiveAllConfigs|resultCode != 0");
          }
        }
        else if (((paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() == 0)) && (QLog.isColorLevel())) {
          QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, "receiveAllConfigs|config_list empty data");
        }
      }
    }
    long l1 = System.currentTimeMillis();
    int j = paramRespGetConfig.config_list.size();
    ArrayList localArrayList = new ArrayList(jdField_a_of_type_AndroidUtilSparseIntArray.size());
    int i = 0;
    while (i < jdField_a_of_type_AndroidUtilSparseIntArray.size())
    {
      localArrayList.add(Integer.valueOf(jdField_a_of_type_AndroidUtilSparseIntArray.keyAt(i)));
      i += 1;
    }
    tcs localtcs = (tcs)tcz.a(10);
    i = 0;
    if (i < j)
    {
      ConfigurationService.Config localConfig = (ConfigurationService.Config)paramRespGetConfig.config_list.get(i);
      if (localConfig == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (localConfig.type.has())
        {
          int k = localConfig.type.get();
          localArrayList.remove(Integer.valueOf(k));
          int m = jdField_a_of_type_AndroidUtilSparseIntArray.get(k, k);
          ved.a("Q.qqstory.config.QQStoryConfigServlet", "receiveAllConfigs|receive type: %d, localConfigId: %d, length: %d", Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j));
          String str1 = paramIntent.getStringExtra("key_uin");
          String str2 = tcs.a(m);
          int n = bbkb.a(paramQQAppInterface.getApp(), str2, str1);
          String str3 = andt.a(localConfig, n, m);
          if (localConfig.content_list.size() > 0) {
            ved.a("Q.qqstory.config.QQStoryConfigServlet", "%d --> %s", Integer.valueOf(m), (String)localConfig.content_list.get(0));
          }
          ved.a("Q.qqstory.config.QQStoryConfigServlet", "%d ---> %s", Integer.valueOf(m), str3);
          paramBoolean = localtcs.a(m, paramIntent, localConfig);
          if (paramBoolean) {
            bbkb.a(paramQQAppInterface.getApp(), str2, str1, localConfig.version.get());
          }
          ved.b("Q.qqstory.config.QQStoryConfigServlet", "receiveAllConfigs|receive type: %d, localConfigId: %d, length: %d, localVersion:%d, newVersion: %d, handled: %b", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(localConfig.version.get()), Boolean.valueOf(paramBoolean) });
        }
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.config.QQStoryConfigServlet", 2, "receiveAllConfigs|executeSpendTime: " + (l2 - l1));
    }
    paramRespGetConfig = localArrayList.iterator();
    while (paramRespGetConfig.hasNext())
    {
      paramIntent = (Integer)paramRespGetConfig.next();
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.config.QQStoryConfigServlet", 2, "receiveAllConfigs|noReceiveType: " + paramIntent + ",length: " + localArrayList.size());
      }
      switch (paramIntent.intValue())
      {
      default: 
        break;
      case 243: 
        ((sss)paramQQAppInterface.a(98)).notifyUI(1021, true, null);
      }
    }
  }
  
  public static byte[] a(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    paramReqGetConfig = paramReqGetConfig.toByteArray();
    long l = paramReqGetConfig.length;
    byte[] arrayOfByte = new byte[(int)l + 4];
    bbmx.a(arrayOfByte, 0, 4L + l);
    bbmx.a(arrayOfByte, 4, paramReqGetConfig, (int)l);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length - 4;
    byte[] arrayOfByte = new byte[i];
    bbmx.a(arrayOfByte, 0, paramArrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 433	andy:getAppRuntime	()Lmqq/app/AppRuntime;
    //   4: checkcast 68	com/tencent/mobileqq/app/QQAppInterface
    //   7: astore 6
    //   9: aload_2
    //   10: invokevirtual 438	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: istore 5
    //   15: getstatic 30	andy:jdField_a_of_type_AndroidUtilSparseIntArray	Landroid/util/SparseIntArray;
    //   18: invokevirtual 63	android/util/SparseIntArray:size	()I
    //   21: ifne +10 -> 31
    //   24: aload_0
    //   25: aload_1
    //   26: iconst_0
    //   27: invokestatic 441	sxp:a	(Lmqq/app/MSFServlet;Landroid/content/Intent;Z)V
    //   30: return
    //   31: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +73 -> 107
    //   37: getstatic 30	andy:jdField_a_of_type_AndroidUtilSparseIntArray	Landroid/util/SparseIntArray;
    //   40: invokevirtual 63	android/util/SparseIntArray:size	()I
    //   43: istore 4
    //   45: iconst_0
    //   46: istore_3
    //   47: iload_3
    //   48: getstatic 30	andy:jdField_a_of_type_AndroidUtilSparseIntArray	Landroid/util/SparseIntArray;
    //   51: invokevirtual 63	android/util/SparseIntArray:size	()I
    //   54: if_icmpge +53 -> 107
    //   57: ldc 74
    //   59: iconst_2
    //   60: new 131	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   67: ldc_w 443
    //   70: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: getstatic 30	andy:jdField_a_of_type_AndroidUtilSparseIntArray	Landroid/util/SparseIntArray;
    //   76: iload_3
    //   77: invokevirtual 83	android/util/SparseIntArray:keyAt	(I)I
    //   80: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: ldc_w 393
    //   86: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: iload 4
    //   91: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 288	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: iload_3
    //   101: iconst_1
    //   102: iadd
    //   103: istore_3
    //   104: goto -57 -> 47
    //   107: aload_2
    //   108: invokevirtual 446	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   111: astore 7
    //   113: aload 7
    //   115: ifnull +10 -> 125
    //   118: aload 7
    //   120: arraylength
    //   121: iconst_4
    //   122: if_icmpge +25 -> 147
    //   125: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +12 -> 140
    //   131: ldc 74
    //   133: iconst_2
    //   134: ldc_w 448
    //   137: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload_0
    //   141: aload_1
    //   142: iconst_0
    //   143: invokestatic 441	sxp:a	(Lmqq/app/MSFServlet;Landroid/content/Intent;Z)V
    //   146: return
    //   147: aload_2
    //   148: aload 7
    //   150: invokestatic 450	andy:a	([B)[B
    //   153: invokevirtual 453	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
    //   156: new 273	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig
    //   159: dup
    //   160: invokespecial 454	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:<init>	()V
    //   163: astore 7
    //   165: aload 7
    //   167: aload_2
    //   168: invokevirtual 446	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   171: invokevirtual 458	com/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   174: pop
    //   175: aload_0
    //   176: aload 7
    //   178: aload 6
    //   180: aload_1
    //   181: iload 5
    //   183: invokespecial 460	andy:a	(Lcom/tencent/mobileqq/config/struct/splashproto/ConfigurationService$RespGetConfig;Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Z)V
    //   186: aload_0
    //   187: aload_1
    //   188: iconst_1
    //   189: invokestatic 441	sxp:a	(Lmqq/app/MSFServlet;Landroid/content/Intent;Z)V
    //   192: return
    //   193: astore_2
    //   194: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +32 -> 229
    //   200: ldc 74
    //   202: iconst_2
    //   203: new 131	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 462
    //   213: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_2
    //   217: invokevirtual 463	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   220: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_2
    //   230: invokevirtual 466	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   233: aload_0
    //   234: aload_1
    //   235: iconst_0
    //   236: invokestatic 441	sxp:a	(Lmqq/app/MSFServlet;Landroid/content/Intent;Z)V
    //   239: return
    //   240: astore_2
    //   241: goto -55 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	andy
    //   0	244	1	paramIntent	Intent
    //   0	244	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   46	58	3	i	int
    //   43	47	4	j	int
    //   13	169	5	bool	boolean
    //   7	172	6	localQQAppInterface	QQAppInterface
    //   111	66	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   165	175	193	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   175	186	240	java/lang/Exception
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (jdField_a_of_type_AndroidUtilSparseIntArray.size() == 0) {
      return;
    }
    if (QLog.isColorLevel())
    {
      int j = jdField_a_of_type_AndroidUtilSparseIntArray.size();
      int i = 0;
      while (i < jdField_a_of_type_AndroidUtilSparseIntArray.size())
      {
        QLog.i("Q.qqstory.config.QQStoryConfigServlet", 2, "onSend. cmd: " + jdField_a_of_type_AndroidUtilSparseIntArray.keyAt(i) + ",length: " + j);
        i += 1;
      }
    }
    a(localQQAppInterface, paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     andy
 * JD-Core Version:    0.7.0.1
 */