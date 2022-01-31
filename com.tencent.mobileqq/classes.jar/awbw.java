import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.mobile_get_config_req;
import QMF_PROTOCAL.mobile_get_config_rsp;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.service.qzone.QZoneFeedCountPackeger.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.WNSStream;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class awbw
{
  public static String a;
  private static AtomicInteger a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "hostuin";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(Math.abs(new Random(65535L).nextInt()));
  }
  
  public static JceStruct a(int paramInt)
  {
    localObject = null;
    try
    {
      String str = xgc.a();
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("UndealCount.QZoneFeedCountPackeger", 1, localThrowable, new Object[0]);
        continue;
        localObject = "";
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("GetUndealCountTag", 4, "config Scene=" + paramInt);
    }
    if (localObject != null) {
      return new mobile_get_config_req(1000027, paramInt, (String)localObject);
    }
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = new WNSStream();
    try
    {
      localObject1 = ((WNSStream)localObject1).unpack(bakc.b(paramArrayOfByte));
      paramArrayOfByte = new UniAttribute();
      if ((localObject1 != null) && (((QmfDownstream)localObject1).WnsCode == 0))
      {
        paramArrayOfByte.setEncodeName("utf-8");
        paramArrayOfByte.decode(((QmfDownstream)localObject1).Extra);
        Object localObject2 = (QmfBusiControl)paramArrayOfByte.get("busiCompCtl");
        if ((localObject2 != null) && (1 == ((QmfBusiControl)localObject2).compFlag))
        {
          localObject2 = WNSStream.decompress(((QmfDownstream)localObject1).BusiBuff);
          if (localObject2 == null) {
            break label186;
          }
          ((QmfDownstream)localObject1).BusiBuff = ((byte[])localObject2);
        }
        localObject2 = new UniAttribute();
        ((UniAttribute)localObject2).setEncodeName("utf-8");
        ((UniAttribute)localObject2).decode(((QmfDownstream)localObject1).BusiBuff);
        paramString = (JceStruct)((UniAttribute)localObject2).get(paramString);
        ThreadManager.post(new QZoneFeedCountPackeger.1(paramArrayOfByte, paramQQAppInterface), 8, null, true);
        return paramString;
      }
      if (localObject1 != null)
      {
        int i = ((QmfDownstream)localObject1).WnsCode;
        if (i != 0) {
          return null;
        }
      }
      if (localObject1 == null) {
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    return null;
    label186:
    return null;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, mobile_get_config_rsp parammobile_get_config_rsp)
  {
    if ((parammobile_get_config_rsp != null) && (parammobile_get_config_rsp.config != null) && (!parammobile_get_config_rsp.config.isEmpty())) {}
    try
    {
      xgb.a(parammobile_get_config_rsp.config, true);
      label32:
      String str2 = BaseApplication.getContext().getPackageName();
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "unknow";
      }
      if (QLog.isColorLevel()) {
        QLog.i("ConfigProvider", 2, "qq config update:" + str1);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("UndealCount.QZoneFeedCountPackeger", 4, "UndealCount.QZoneFeedCountPackeger saveConfigToProvider");
      }
      xgc.a(parammobile_get_config_rsp.config, parammobile_get_config_rsp.cookies, str1, paramQQAppInterface);
      return;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  /* Error */
  public static byte[] a(JceStruct paramJceStruct, String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: new 107	com/qq/jce/wup/UniAttribute
    //   3: dup
    //   4: invokespecial 108	com/qq/jce/wup/UniAttribute:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc 217
    //   13: invokevirtual 120	com/qq/jce/wup/UniAttribute:setEncodeName	(Ljava/lang/String;)V
    //   16: aload 7
    //   18: getstatic 13	awbw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: lload_2
    //   22: invokestatic 223	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   25: invokevirtual 227	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   28: aload_0
    //   29: ifnull +21 -> 50
    //   32: aload_1
    //   33: ifnull +17 -> 50
    //   36: aload_1
    //   37: invokevirtual 232	java/lang/String:length	()I
    //   40: ifle +10 -> 50
    //   43: aload 7
    //   45: aload_1
    //   46: aload_0
    //   47: invokevirtual 227	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   50: aload 7
    //   52: invokevirtual 236	com/qq/jce/wup/UniAttribute:encode	()[B
    //   55: astore 9
    //   57: new 57	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   64: ldc 238
    //   66: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: iload 4
    //   71: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: ldc 240
    //   76: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: iload 5
    //   81: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 8
    //   89: new 57	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   96: astore 10
    //   98: aload 10
    //   100: ldc 242
    //   102: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokestatic 247	bfpj:a	()Lbfpj;
    //   108: invokevirtual 250	bfpj:c	()Ljava/lang/String;
    //   111: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: ldc 252
    //   117: invokestatic 257	awdb:a	(Ljava/lang/String;)Lcooperation/qzone/LbsDataV2$GpsInfo;
    //   120: astore 11
    //   122: ldc 89
    //   124: astore 7
    //   126: ldc 89
    //   128: astore_0
    //   129: aload 11
    //   131: ifnonnull +158 -> 289
    //   134: ldc 252
    //   136: invokestatic 259	awdb:a	(Ljava/lang/String;)V
    //   139: aload 10
    //   141: bipush 38
    //   143: invokevirtual 262	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   146: ldc_w 264
    //   149: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 10
    //   159: bipush 38
    //   161: invokevirtual 262	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   164: ldc_w 266
    //   167: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 7
    //   172: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 8
    //   178: astore_0
    //   179: aload 10
    //   181: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 192	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   187: ifne +27 -> 214
    //   190: new 57	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   197: aload 8
    //   199: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 10
    //   204: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: astore_0
    //   214: new 94	cooperation/qzone/WNSStream
    //   217: dup
    //   218: ldc 78
    //   220: invokestatic 269	bfpr:a	()Ljava/lang/String;
    //   223: lload_2
    //   224: iconst_0
    //   225: newarray byte
    //   227: aload_0
    //   228: invokespecial 272	cooperation/qzone/WNSStream:<init>	(ILjava/lang/String;J[BLjava/lang/String;)V
    //   231: astore 8
    //   233: aload 9
    //   235: ifnull +110 -> 345
    //   238: aconst_null
    //   239: astore_0
    //   240: iload 6
    //   242: invokestatic 274	awbw:a	(I)Lcom/qq/taf/jce/JceStruct;
    //   245: astore 7
    //   247: aload 7
    //   249: astore_0
    //   250: aload 8
    //   252: getstatic 38	awbw:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   255: invokevirtual 277	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   258: new 57	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   265: ldc_w 279
    //   268: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_1
    //   272: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: aload 9
    //   280: iconst_0
    //   281: aload_0
    //   282: invokevirtual 283	cooperation/qzone/WNSStream:packForUndeal	(ILjava/lang/String;[BZLcom/qq/taf/jce/JceStruct;)[B
    //   285: invokestatic 285	bakc:a	([B)[B
    //   288: areturn
    //   289: dconst_1
    //   290: aload 11
    //   292: getfield 290	cooperation/qzone/LbsDataV2$GpsInfo:lat	I
    //   295: i2d
    //   296: dmul
    //   297: ldc2_w 291
    //   300: ddiv
    //   301: invokestatic 295	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   304: astore 7
    //   306: dconst_1
    //   307: aload 11
    //   309: getfield 298	cooperation/qzone/LbsDataV2$GpsInfo:lon	I
    //   312: i2d
    //   313: dmul
    //   314: ldc2_w 291
    //   317: ddiv
    //   318: invokestatic 295	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   321: astore_0
    //   322: goto -183 -> 139
    //   325: astore 7
    //   327: ldc 83
    //   329: iconst_1
    //   330: aload 7
    //   332: iconst_0
    //   333: anewarray 4	java/lang/Object
    //   336: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   339: goto -89 -> 250
    //   342: astore_0
    //   343: aconst_null
    //   344: areturn
    //   345: aconst_null
    //   346: areturn
    //   347: astore_0
    //   348: goto -233 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramJceStruct	JceStruct
    //   0	351	1	paramString	String
    //   0	351	2	paramLong	long
    //   0	351	4	paramInt1	int
    //   0	351	5	paramInt2	int
    //   0	351	6	paramInt3	int
    //   7	298	7	localObject1	Object
    //   325	6	7	localError	Error
    //   87	164	8	localObject2	Object
    //   55	224	9	arrayOfByte	byte[]
    //   96	107	10	localStringBuilder	java.lang.StringBuilder
    //   120	188	11	localGpsInfo	cooperation.qzone.LbsDataV2.GpsInfo
    // Exception table:
    //   from	to	target	type
    //   240	247	325	java/lang/Error
    //   0	28	342	java/lang/Throwable
    //   36	50	342	java/lang/Throwable
    //   50	98	342	java/lang/Throwable
    //   98	115	342	java/lang/Throwable
    //   115	122	342	java/lang/Throwable
    //   134	139	342	java/lang/Throwable
    //   139	176	342	java/lang/Throwable
    //   179	214	342	java/lang/Throwable
    //   214	233	342	java/lang/Throwable
    //   240	247	342	java/lang/Throwable
    //   250	289	342	java/lang/Throwable
    //   289	322	342	java/lang/Throwable
    //   327	339	342	java/lang/Throwable
    //   98	115	347	java/lang/Exception
  }
  
  private static void b(UniAttribute paramUniAttribute, QQAppInterface paramQQAppInterface)
  {
    if (paramUniAttribute != null) {
      try
      {
        Object localObject = paramUniAttribute.get("conf_info_rsp_len");
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UndealCount.QZoneFeedCountPackeger", 2, "processConfig pack get conf_info_rsp_len is null ");
          }
        }
        else
        {
          int i = ((Integer)localObject).intValue();
          localObject = (byte[])paramUniAttribute.get("conf_info_rsp");
          paramUniAttribute = (UniAttribute)localObject;
          if (localObject != null)
          {
            paramUniAttribute = (UniAttribute)localObject;
            if (i != 0) {
              paramUniAttribute = WNSStream.decompress((byte[])localObject);
            }
          }
          if (paramUniAttribute != null)
          {
            paramUniAttribute = WNSStream.decodeWup(mobile_get_config_rsp.class, paramUniAttribute);
            if ((paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null) && (paramUniAttribute != null))
            {
              a(paramQQAppInterface, (mobile_get_config_rsp)paramUniAttribute);
              return;
            }
          }
        }
      }
      catch (Error paramUniAttribute)
      {
        paramUniAttribute.printStackTrace();
        return;
      }
      catch (Exception paramUniAttribute)
      {
        paramUniAttribute.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbw
 * JD-Core Version:    0.7.0.1
 */