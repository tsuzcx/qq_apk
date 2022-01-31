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

public class azat
{
  public static String a;
  private static AtomicInteger a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "hostuin";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(Math.abs(new Random(65535L).nextInt()));
  }
  
  public static JceStruct a(int paramInt, long paramLong)
  {
    localObject3 = null;
    Object localObject2 = null;
    try
    {
      localObject1 = zih.a();
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        int i;
        label86:
        Object localObject1 = localObject3;
        QLog.e("UndealCount.QZoneFeedCountPackeger", 1, localThrowable1, new Object[0]);
        continue;
        localObject1 = "";
      }
    }
    try
    {
      QLog.d("UndealCount.QZoneFeedCountPackeger", 1, "getCongfigPacket cookies: " + (String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label168;
      }
      i = ((String)localObject1).indexOf("&TjSwTm_" + paramLong);
      if (i >= 0) {
        break label168;
      }
      QLog.d("UndealCount.QZoneFeedCountPackeger", 1, "getCongfigPacket: cookies cleared");
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable2)
    {
      break label141;
      break label86;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("GetUndealCountTag", 4, "config Scene=" + paramInt);
    }
    if (localObject1 != null) {
      return new mobile_get_config_req(1000027, paramInt, (String)localObject1);
    }
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = new WNSStream();
    try
    {
      localObject1 = ((WNSStream)localObject1).unpack(bdpd.b(paramArrayOfByte));
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
      zig.a(parammobile_get_config_rsp.config, true);
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
      zih.a(parammobile_get_config_rsp.config, parammobile_get_config_rsp.cookies, str1, paramQQAppInterface);
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
    //   0: ldc 49
    //   2: iconst_1
    //   3: new 51	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   10: ldc 232
    //   12: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: lload_2
    //   16: invokevirtual 79	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: new 128	com/qq/jce/wup/UniAttribute
    //   28: dup
    //   29: invokespecial 129	com/qq/jce/wup/UniAttribute:<init>	()V
    //   32: astore 7
    //   34: aload 7
    //   36: ldc 234
    //   38: invokevirtual 141	com/qq/jce/wup/UniAttribute:setEncodeName	(Ljava/lang/String;)V
    //   41: aload 7
    //   43: getstatic 13	azat:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   46: lload_2
    //   47: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   50: invokevirtual 244	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   53: aload_0
    //   54: ifnull +21 -> 75
    //   57: aload_1
    //   58: ifnull +17 -> 75
    //   61: aload_1
    //   62: invokevirtual 247	java/lang/String:length	()I
    //   65: ifle +10 -> 75
    //   68: aload 7
    //   70: aload_1
    //   71: aload_0
    //   72: invokevirtual 244	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   75: aload 7
    //   77: invokevirtual 251	com/qq/jce/wup/UniAttribute:encode	()[B
    //   80: astore 9
    //   82: new 51	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   89: ldc 253
    //   91: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: iload 4
    //   96: invokevirtual 98	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc 255
    //   101: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload 5
    //   106: invokevirtual 98	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: astore 8
    //   114: new 51	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   121: astore 10
    //   123: aload 10
    //   125: ldc_w 257
    //   128: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokestatic 262	bjdl:a	()Lbjdl;
    //   134: invokevirtual 265	bjdl:c	()Ljava/lang/String;
    //   137: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: ldc_w 267
    //   144: invokestatic 272	azby:a	(Ljava/lang/String;)Lcooperation/qzone/LbsDataV2$GpsInfo;
    //   147: astore 11
    //   149: ldc 110
    //   151: astore 7
    //   153: ldc 110
    //   155: astore_0
    //   156: aload 11
    //   158: ifnonnull +160 -> 318
    //   161: ldc_w 267
    //   164: invokestatic 274	azby:a	(Ljava/lang/String;)V
    //   167: aload 10
    //   169: bipush 38
    //   171: invokevirtual 277	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   174: ldc_w 279
    //   177: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 10
    //   187: bipush 38
    //   189: invokevirtual 277	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   192: ldc_w 281
    //   195: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 7
    //   200: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 8
    //   206: astore_0
    //   207: aload 10
    //   209: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   215: ifne +27 -> 242
    //   218: new 51	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   225: aload 8
    //   227: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload 10
    //   232: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: astore_0
    //   242: new 115	cooperation/qzone/WNSStream
    //   245: dup
    //   246: ldc 101
    //   248: invokestatic 284	bjdt:a	()Ljava/lang/String;
    //   251: lload_2
    //   252: iconst_0
    //   253: newarray byte
    //   255: aload_0
    //   256: invokespecial 287	cooperation/qzone/WNSStream:<init>	(ILjava/lang/String;J[BLjava/lang/String;)V
    //   259: astore 8
    //   261: aload 9
    //   263: ifnull +111 -> 374
    //   266: aconst_null
    //   267: astore_0
    //   268: iload 6
    //   270: lload_2
    //   271: invokestatic 289	azat:a	(IJ)Lcom/qq/taf/jce/JceStruct;
    //   274: astore 7
    //   276: aload 7
    //   278: astore_0
    //   279: aload 8
    //   281: getstatic 38	azat:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   284: invokevirtual 292	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   287: new 51	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   294: ldc_w 294
    //   297: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload_1
    //   301: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: aload 9
    //   309: iconst_0
    //   310: aload_0
    //   311: invokevirtual 298	cooperation/qzone/WNSStream:packForUndeal	(ILjava/lang/String;[BZLcom/qq/taf/jce/JceStruct;)[B
    //   314: invokestatic 300	bdpd:a	([B)[B
    //   317: areturn
    //   318: dconst_1
    //   319: aload 11
    //   321: getfield 305	cooperation/qzone/LbsDataV2$GpsInfo:lat	I
    //   324: i2d
    //   325: dmul
    //   326: ldc2_w 306
    //   329: ddiv
    //   330: invokestatic 310	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   333: astore 7
    //   335: dconst_1
    //   336: aload 11
    //   338: getfield 313	cooperation/qzone/LbsDataV2$GpsInfo:lon	I
    //   341: i2d
    //   342: dmul
    //   343: ldc2_w 306
    //   346: ddiv
    //   347: invokestatic 310	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   350: astore_0
    //   351: goto -184 -> 167
    //   354: astore 7
    //   356: ldc 49
    //   358: iconst_1
    //   359: aload 7
    //   361: iconst_0
    //   362: anewarray 4	java/lang/Object
    //   365: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   368: goto -89 -> 279
    //   371: astore_0
    //   372: aconst_null
    //   373: areturn
    //   374: aconst_null
    //   375: areturn
    //   376: astore_0
    //   377: goto -236 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramJceStruct	JceStruct
    //   0	380	1	paramString	String
    //   0	380	2	paramLong	long
    //   0	380	4	paramInt1	int
    //   0	380	5	paramInt2	int
    //   0	380	6	paramInt3	int
    //   32	302	7	localObject1	Object
    //   354	6	7	localError	Error
    //   112	168	8	localObject2	Object
    //   80	228	9	arrayOfByte	byte[]
    //   121	110	10	localStringBuilder	java.lang.StringBuilder
    //   147	190	11	localGpsInfo	cooperation.qzone.LbsDataV2.GpsInfo
    // Exception table:
    //   from	to	target	type
    //   268	276	354	java/lang/Error
    //   0	53	371	java/lang/Throwable
    //   61	75	371	java/lang/Throwable
    //   75	123	371	java/lang/Throwable
    //   123	141	371	java/lang/Throwable
    //   141	149	371	java/lang/Throwable
    //   161	167	371	java/lang/Throwable
    //   167	204	371	java/lang/Throwable
    //   207	242	371	java/lang/Throwable
    //   242	261	371	java/lang/Throwable
    //   268	276	371	java/lang/Throwable
    //   279	318	371	java/lang/Throwable
    //   318	351	371	java/lang/Throwable
    //   356	368	371	java/lang/Throwable
    //   123	141	376	java/lang/Exception
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
 * Qualified Name:     azat
 * JD-Core Version:    0.7.0.1
 */