import ConfigPush.BigDataChannel;
import ConfigPush.BigDataIpInfo;
import ConfigPush.BigDataIpList;
import ConfigPush.DomainIpChannel;
import ConfigPush.DomainIpInfo;
import ConfigPush.DomainIpList;
import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import ConfigPush.FmtIPInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.highway.config.HwConfig;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.RspBody;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.Ip6Addr;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpAddr;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpLearnConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.NetSegConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.OpenUpConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.PTVConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.SrvAddrs;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import tencent.im.cs.ptt_apply.ptt_apply.Addr;
import tencent.im.cs.ptt_apply.ptt_apply.QQApplyAuthkeyRsp;

@Deprecated
public final class bdud
{
  private static bdud jdField_a_of_type_Bdud;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[1];
  private static final String jdField_b_of_type_JavaLangString = anhk.cu + "fmtSrvAddr.ini";
  private static final String c = anhk.cu + "srvAddr.ini";
  private static final String d = anhk.cu + "ipDownAddr.ini";
  private static final String e = anhk.cu + "ipDownAddr.tmp";
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  private FileStoragePushFSSvcList jdField_a_of_type_ConfigPushFileStoragePushFSSvcList = b();
  private azth jdField_a_of_type_Azth = new azth();
  private bdue jdField_a_of_type_Bdue = new bdue();
  private bduf jdField_a_of_type_Bduf = new bduf(this);
  private bdzc jdField_a_of_type_Bdzc = new bdzc();
  private subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf;
  public Object a;
  private String jdField_a_of_type_JavaLangString = "";
  private Hashtable<Integer, ArrayList<FileStorageServerListInfo>> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private FileStoragePushFSSvcList jdField_b_of_type_ConfigPushFileStoragePushFSSvcList;
  private Hashtable<Integer, ArrayList<FileStorageServerListInfo>> jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  
  private bdud()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    f();
    d();
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 6) {}
    do
    {
      return 1;
      if (paramInt == 7) {
        return 2;
      }
      if (paramInt == 8) {
        return 3;
      }
      if (paramInt == 9) {
        return 4;
      }
    } while (paramInt != 10);
    return 5;
  }
  
  public static bdud a()
  {
    if (jdField_a_of_type_Bdud == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bdud == null) {
        jdField_a_of_type_Bdud = new bdud();
      }
      return jdField_a_of_type_Bdud;
    }
  }
  
  private HwConfig a(subcmd0x501.SubCmd0x501Rspbody.SrvAddrs paramSrvAddrs)
  {
    HwConfig localHwConfig = new HwConfig();
    localHwConfig.ipList = new ArrayList();
    Object localObject1 = paramSrvAddrs.rpt_msg_addrs.get();
    int i;
    Object localObject2;
    Object localObject3;
    int j;
    boolean bool;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      i = 0;
      if (i < ((List)localObject1).size())
      {
        localObject2 = (subcmd0x501.SubCmd0x501Rspbody.IpAddr)((List)localObject1).get(i);
        localObject3 = localHwConfig.ipList;
        String str = HwServlet.spliceCircleUrl(((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject2).uint32_ip.get());
        j = ((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject2).uint32_port.get();
        if (((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject2).uint32_same_isp.get() == 1) {}
        for (bool = true;; bool = false)
        {
          ((ArrayList)localObject3).add(new EndPoint(str, j, bool));
          i += 1;
          break;
        }
      }
    }
    localHwConfig.ipv6List = new ArrayList();
    paramSrvAddrs = paramSrvAddrs.rpt_msg_addrs_v6.get();
    if ((paramSrvAddrs != null) && (paramSrvAddrs.size() != 0))
    {
      i = 0;
      if (i < paramSrvAddrs.size())
      {
        localObject1 = (subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)paramSrvAddrs.get(i);
        localObject2 = localHwConfig.ipv6List;
        localObject3 = HwServlet.spliceIpv6Url(((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject1).bytes_ip6.get().toByteArray());
        j = ((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject1).uint32_port.get();
        if (((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject1).uint32_same_isp.get() == 1) {}
        for (bool = true;; bool = false)
        {
          ((ArrayList)localObject2).add(new EndPoint((String)localObject3, j, bool));
          i += 1;
          break;
        }
      }
    }
    return localHwConfig;
  }
  
  public static String a(int paramInt)
  {
    return (paramInt >> 0 & 0xFF) + '.' + (paramInt >> 8 & 0xFF) + '.' + (paramInt >> 16 & 0xFF) + '.' + (paramInt >> 24 & 0xFF);
  }
  
  private byte[] a(bdue parambdue)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    ByteArrayOutputStream localByteArrayOutputStream;
    DataOutputStream localDataOutputStream;
    int k;
    int j;
    if (parambdue != null)
    {
      localObject1 = (byte[][])null;
      localObject3 = (byte[][])null;
      if ((parambdue.jdField_a_of_type_JavaUtilArrayList == null) || (parambdue.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label842;
      }
      localObject1 = new byte[parambdue.jdField_a_of_type_JavaUtilArrayList.size()][];
      localObject2 = localObject3;
      if (parambdue.jdField_b_of_type_JavaUtilArrayList != null)
      {
        localObject2 = localObject3;
        if (parambdue.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
          localObject2 = new byte[parambdue.jdField_b_of_type_JavaUtilArrayList.size()][];
        }
      }
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
      k = 0;
      j = 0;
    }
    label830:
    label836:
    label842:
    label845:
    label853:
    for (;;)
    {
      try
      {
        if (parambdue.jdField_a_of_type_JavaLangString == null) {
          break label836;
        }
        localDataOutputStream.writeUTF(parambdue.jdField_a_of_type_JavaLangString);
        localObject3 = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.reset();
        k = 0 + (localObject3.length + 3);
        j = 1;
        if (parambdue.jdField_b_of_type_JavaLangString == null) {
          break label830;
        }
        localDataOutputStream.writeUTF(parambdue.jdField_b_of_type_JavaLangString);
        arrayOfByte = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.reset();
        k += arrayOfByte.length + 3;
        j += 1;
        i = j;
        m = k;
        Object localObject4;
        if (parambdue.jdField_a_of_type_JavaUtilArrayList != null)
        {
          i = j;
          m = k;
          if (parambdue.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            m = 0;
            i = k;
            k = m;
            if (k >= parambdue.jdField_a_of_type_JavaUtilArrayList.size()) {
              break label845;
            }
            localObject4 = (FileStorageServerListInfo)parambdue.jdField_a_of_type_JavaUtilArrayList.get(k);
            localDataOutputStream.writeInt(((FileStorageServerListInfo)localObject4).iPort);
            localDataOutputStream.writeUTF(((FileStorageServerListInfo)localObject4).sIP);
            localObject1[k] = localByteArrayOutputStream.toByteArray();
            localByteArrayOutputStream.reset();
            i += localObject1[k].length + 3;
            j += 1;
            k += 1;
            continue;
          }
        }
        if ((parambdue.jdField_b_of_type_JavaUtilArrayList != null) && (parambdue.jdField_b_of_type_JavaUtilArrayList.size() > 0))
        {
          k = 0;
          j = m;
          if (k >= parambdue.jdField_b_of_type_JavaUtilArrayList.size()) {
            break label853;
          }
          localObject4 = (FileStorageServerListInfo)parambdue.jdField_b_of_type_JavaUtilArrayList.get(k);
          localDataOutputStream.writeInt(((FileStorageServerListInfo)localObject4).iPort);
          localDataOutputStream.writeUTF(((FileStorageServerListInfo)localObject4).sIP);
          localObject2[k] = localByteArrayOutputStream.toByteArray();
          localByteArrayOutputStream.reset();
          j += localObject2[k].length + 3;
          i += 1;
          k += 1;
          continue;
          parambdue = new byte[j + 2];
          parambdue[0] = 0;
          parambdue[1] = ((byte)i);
          j = 2;
          if (localObject3 != null)
          {
            parambdue[2] = 1;
            localObject4 = bgva.a((short)localObject3.length);
            System.arraycopy(localObject4, 0, parambdue, 3, localObject4.length);
            i = localObject4.length + 3;
            System.arraycopy(localObject3, 0, parambdue, i, localObject3.length);
            j = i + localObject3.length;
          }
          i = j;
          if (arrayOfByte != null)
          {
            parambdue[j] = 2;
            i = j + 1;
            localObject3 = bgva.a((short)arrayOfByte.length);
            System.arraycopy(localObject3, 0, parambdue, i, localObject3.length);
            i += localObject3.length;
            System.arraycopy(arrayOfByte, 0, parambdue, i, arrayOfByte.length);
            i += arrayOfByte.length;
          }
          j = i;
          if (localObject1 != null)
          {
            j = i;
            if (localObject1.length > 0)
            {
              k = 0;
              j = i;
              if (k < localObject1.length)
              {
                parambdue[i] = 3;
                i += 1;
                localObject3 = bgva.a((short)localObject1[k].length);
                System.arraycopy(localObject3, 0, parambdue, i, localObject3.length);
                i += localObject3.length;
                System.arraycopy(localObject1[k], 0, parambdue, i, localObject1[k].length);
                j = localObject1[k].length;
                k += 1;
                i = j + i;
                continue;
              }
            }
          }
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            i = 0;
            if (i < localObject2.length)
            {
              parambdue[j] = 4;
              j += 1;
              localObject1 = bgva.a((short)localObject2[i].length);
              System.arraycopy(localObject1, 0, parambdue, j, localObject1.length);
              j += localObject1.length;
              System.arraycopy(localObject2[i], 0, parambdue, j, localObject2[i].length);
              k = localObject2[i].length;
              j += k;
              i += 1;
              continue;
            }
          }
          if (localByteArrayOutputStream == null) {}
        }
        j = m;
      }
      catch (Throwable parambdue)
      {
        parambdue = parambdue;
        parambdue.printStackTrace();
        return null;
      }
      finally
      {
        if (localByteArrayOutputStream != null) {}
        try
        {
          localByteArrayOutputStream.close();
          if (localDataOutputStream != null) {
            localDataOutputStream.close();
          }
        }
        catch (Throwable localThrowable1)
        {
          continue;
        }
      }
      continue;
      byte[] arrayOfByte = null;
      continue;
      localObject3 = null;
      continue;
      break;
      int m = i;
      int i = j;
    }
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    case 16: 
    default: 
      return -1;
    case 12: 
      return 1;
    case 13: 
      return 2;
    case 14: 
      return 3;
    case 15: 
      return 7;
    }
    return 16;
  }
  
  /* Error */
  private FileStoragePushFSSvcList b()
  {
    // Byte code:
    //   0: getstatic 54	bdud:c	Ljava/lang/String;
    //   3: invokestatic 302	bgmg:a	(Ljava/lang/String;)Ljava/io/File;
    //   6: astore_2
    //   7: aload_2
    //   8: invokevirtual 308	java/io/File:length	()J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifne +35 -> 48
    //   16: invokestatic 314	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +13 -> 32
    //   22: ldc_w 316
    //   25: iconst_2
    //   26: ldc_w 318
    //   29: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 323	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 324	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: aconst_null
    //   45: astore_3
    //   46: aload_3
    //   47: areturn
    //   48: new 326	java/io/FileInputStream
    //   51: dup
    //   52: aload_2
    //   53: invokespecial 329	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: astore 4
    //   58: aload 4
    //   60: astore_3
    //   61: sipush 1024
    //   64: newarray byte
    //   66: astore 5
    //   68: aload 4
    //   70: astore_3
    //   71: new 244	java/io/ByteArrayOutputStream
    //   74: dup
    //   75: invokespecial 245	java/io/ByteArrayOutputStream:<init>	()V
    //   78: astore_2
    //   79: aload 4
    //   81: astore_3
    //   82: aload 4
    //   84: aload 5
    //   86: invokevirtual 333	java/io/FileInputStream:read	([B)I
    //   89: istore_1
    //   90: iload_1
    //   91: iconst_m1
    //   92: if_icmpeq +61 -> 153
    //   95: aload 4
    //   97: astore_3
    //   98: aload_2
    //   99: aload 5
    //   101: iconst_0
    //   102: iload_1
    //   103: invokevirtual 337	java/io/ByteArrayOutputStream:write	([BII)V
    //   106: goto -27 -> 79
    //   109: astore 5
    //   111: aconst_null
    //   112: astore_2
    //   113: aload 4
    //   115: astore_3
    //   116: invokestatic 314	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +17 -> 136
    //   122: aload 4
    //   124: astore_3
    //   125: ldc_w 316
    //   128: iconst_2
    //   129: ldc 82
    //   131: aload 5
    //   133: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload_2
    //   137: astore_3
    //   138: aload 4
    //   140: ifnull -94 -> 46
    //   143: aload 4
    //   145: invokevirtual 341	java/io/FileInputStream:close	()V
    //   148: aload_2
    //   149: areturn
    //   150: astore_3
    //   151: aload_2
    //   152: areturn
    //   153: aload 4
    //   155: astore_3
    //   156: new 343	com/qq/taf/jce/JceInputStream
    //   159: dup
    //   160: aload_2
    //   161: invokevirtual 256	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   164: invokespecial 346	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   167: astore 5
    //   169: aload 4
    //   171: astore_3
    //   172: new 348	ConfigPush/FileStoragePushFSSvcList
    //   175: dup
    //   176: invokespecial 349	ConfigPush/FileStoragePushFSSvcList:<init>	()V
    //   179: astore_2
    //   180: aload 4
    //   182: astore_3
    //   183: aload_2
    //   184: aload 5
    //   186: invokevirtual 353	ConfigPush/FileStoragePushFSSvcList:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   189: aload_2
    //   190: astore_3
    //   191: aload 4
    //   193: ifnull -147 -> 46
    //   196: aload 4
    //   198: invokevirtual 341	java/io/FileInputStream:close	()V
    //   201: aload_2
    //   202: areturn
    //   203: astore_3
    //   204: aload_2
    //   205: areturn
    //   206: astore_2
    //   207: aconst_null
    //   208: astore_3
    //   209: aload_3
    //   210: ifnull +7 -> 217
    //   213: aload_3
    //   214: invokevirtual 341	java/io/FileInputStream:close	()V
    //   217: aload_2
    //   218: athrow
    //   219: astore_2
    //   220: goto -176 -> 44
    //   223: astore_3
    //   224: goto -7 -> 217
    //   227: astore_2
    //   228: goto -19 -> 209
    //   231: astore 5
    //   233: aconst_null
    //   234: astore 4
    //   236: aconst_null
    //   237: astore_2
    //   238: goto -125 -> 113
    //   241: astore 5
    //   243: goto -130 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	bdud
    //   89	14	1	i	int
    //   6	199	2	localObject1	Object
    //   206	12	2	localObject2	Object
    //   219	1	2	localIOException1	java.io.IOException
    //   227	1	2	localObject3	Object
    //   237	1	2	localObject4	Object
    //   45	93	3	localObject5	Object
    //   150	1	3	localIOException2	java.io.IOException
    //   155	36	3	localObject6	Object
    //   203	1	3	localIOException3	java.io.IOException
    //   208	6	3	localObject7	Object
    //   223	1	3	localIOException4	java.io.IOException
    //   56	179	4	localFileInputStream	java.io.FileInputStream
    //   66	34	5	arrayOfByte	byte[]
    //   109	23	5	localException1	Exception
    //   167	18	5	localJceInputStream	com.qq.taf.jce.JceInputStream
    //   231	1	5	localException2	Exception
    //   241	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   61	68	109	java/lang/Exception
    //   71	79	109	java/lang/Exception
    //   82	90	109	java/lang/Exception
    //   98	106	109	java/lang/Exception
    //   156	169	109	java/lang/Exception
    //   172	180	109	java/lang/Exception
    //   143	148	150	java/io/IOException
    //   196	201	203	java/io/IOException
    //   0	32	206	finally
    //   48	58	206	finally
    //   36	44	219	java/io/IOException
    //   213	217	223	java/io/IOException
    //   61	68	227	finally
    //   71	79	227	finally
    //   82	90	227	finally
    //   98	106	227	finally
    //   116	122	227	finally
    //   125	136	227	finally
    //   156	169	227	finally
    //   172	180	227	finally
    //   183	189	227	finally
    //   0	32	231	java/lang/Exception
    //   48	58	231	java/lang/Exception
    //   183	189	241	java/lang/Exception
  }
  
  private ArrayList<FileStorageServerListInfo> b(int paramInt)
  {
    if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null)
    {
      switch (paramInt)
      {
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      default: 
        return c(a(paramInt));
      case 0: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vUpLoadList;
      case 1: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vPicDownLoadList;
      case 2: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vGPicDownLoadList;
      case 3: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vQzoneProxyServiceList;
      case 4: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vUrlEncodeServiceList;
      case 5: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vVipEmotionList;
      case 11: 
        return this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vC2CPicDownList;
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 17: 
        return d(b(paramInt));
      }
      return this.jdField_a_of_type_Bdue.a(this.jdField_a_of_type_Azth.b());
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getSvcList error,mSvcList=null");
    }
    return null;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Bdud == null) {
      return;
    }
    jdField_a_of_type_Bdud.c();
  }
  
  private ArrayList<FileStorageServerListInfo> c(int paramInt)
  {
    int j = 0;
    if (this.jdField_a_of_type_JavaUtilHashtable.containsKey(Integer.valueOf(paramInt))) {
      return (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(paramInt));
    }
    if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_iplists != null))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_iplists.size())
      {
        Object localObject = (BigDataIpList)this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_iplists.get(i);
        if (((BigDataIpList)localObject).uService_type == paramInt)
        {
          localObject = ((BigDataIpList)localObject).vIplist;
          ArrayList localArrayList = new ArrayList();
          i = j;
          while (i < ((ArrayList)localObject).size())
          {
            FileStorageServerListInfo localFileStorageServerListInfo = new FileStorageServerListInfo();
            localFileStorageServerListInfo.sIP = ((BigDataIpInfo)((ArrayList)localObject).get(i)).sIp;
            localFileStorageServerListInfo.iPort = ((int)((BigDataIpInfo)((ArrayList)localObject).get(i)).uPort);
            localArrayList.add(localFileStorageServerListInfo);
            i += 1;
          }
          this.jdField_a_of_type_JavaUtilHashtable.put(Integer.valueOf(paramInt), localArrayList);
          return localArrayList;
        }
        i += 1;
      }
    }
    return null;
  }
  
  /* Error */
  private void c(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_3
    //   6: astore_2
    //   7: getstatic 50	bdud:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   10: invokestatic 302	bgmg:a	(Ljava/lang/String;)Ljava/io/File;
    //   13: astore 5
    //   15: aload_1
    //   16: ifnonnull +79 -> 95
    //   19: aload_3
    //   20: astore_2
    //   21: invokestatic 314	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +15 -> 39
    //   27: aload_3
    //   28: astore_2
    //   29: ldc_w 316
    //   32: iconst_2
    //   33: ldc_w 434
    //   36: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aload 5
    //   41: ifnull +41 -> 82
    //   44: aload_3
    //   45: astore_2
    //   46: aload 5
    //   48: invokevirtual 437	java/io/File:exists	()Z
    //   51: ifeq +31 -> 82
    //   54: aload_3
    //   55: astore_2
    //   56: invokestatic 314	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +15 -> 74
    //   62: aload_3
    //   63: astore_2
    //   64: ldc_w 316
    //   67: iconst_2
    //   68: ldc_w 439
    //   71: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_3
    //   75: astore_2
    //   76: aload 5
    //   78: invokevirtual 442	java/io/File:delete	()Z
    //   81: pop
    //   82: iconst_0
    //   83: ifeq +11 -> 94
    //   86: new 323	java/lang/NullPointerException
    //   89: dup
    //   90: invokespecial 324	java/lang/NullPointerException:<init>	()V
    //   93: athrow
    //   94: return
    //   95: aload_3
    //   96: astore_2
    //   97: new 444	com/qq/taf/jce/JceOutputStream
    //   100: dup
    //   101: invokespecial 445	com/qq/taf/jce/JceOutputStream:<init>	()V
    //   104: astore 6
    //   106: aload_3
    //   107: astore_2
    //   108: aload_1
    //   109: aload 6
    //   111: invokevirtual 449	ConfigPush/FileStoragePushFSSvcList:writeTo	(Lcom/qq/taf/jce/JceOutputStream;)V
    //   114: aload_3
    //   115: astore_2
    //   116: aload 6
    //   118: invokevirtual 450	com/qq/taf/jce/JceOutputStream:toByteArray	()[B
    //   121: astore 6
    //   123: aload_3
    //   124: astore_2
    //   125: new 452	java/io/FileOutputStream
    //   128: dup
    //   129: aload 5
    //   131: iconst_0
    //   132: invokespecial 455	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   135: astore_3
    //   136: aload_3
    //   137: aload 6
    //   139: invokevirtual 457	java/io/FileOutputStream:write	([B)V
    //   142: new 304	java/io/File
    //   145: dup
    //   146: getstatic 54	bdud:c	Ljava/lang/String;
    //   149: invokespecial 459	java/io/File:<init>	(Ljava/lang/String;)V
    //   152: astore_2
    //   153: aload_2
    //   154: invokevirtual 437	java/io/File:exists	()Z
    //   157: ifeq +8 -> 165
    //   160: aload_2
    //   161: invokevirtual 442	java/io/File:delete	()Z
    //   164: pop
    //   165: aload 5
    //   167: aload_2
    //   168: invokevirtual 463	java/io/File:renameTo	(Ljava/io/File;)Z
    //   171: pop
    //   172: aload_3
    //   173: ifnull +7 -> 180
    //   176: aload_3
    //   177: invokevirtual 464	java/io/FileOutputStream:close	()V
    //   180: aload_1
    //   181: ifnull -87 -> 94
    //   184: invokestatic 314	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq -93 -> 94
    //   190: ldc_w 316
    //   193: iconst_2
    //   194: ldc_w 466
    //   197: invokestatic 321	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: return
    //   201: astore_2
    //   202: aload 4
    //   204: astore_3
    //   205: aload_2
    //   206: astore 4
    //   208: aload_3
    //   209: astore_2
    //   210: invokestatic 314	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +17 -> 230
    //   216: aload_3
    //   217: astore_2
    //   218: ldc_w 316
    //   221: iconst_2
    //   222: ldc_w 468
    //   225: aload 4
    //   227: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   230: aload_3
    //   231: ifnull -51 -> 180
    //   234: aload_3
    //   235: invokevirtual 464	java/io/FileOutputStream:close	()V
    //   238: goto -58 -> 180
    //   241: astore_2
    //   242: goto -62 -> 180
    //   245: astore_1
    //   246: aload_2
    //   247: ifnull +7 -> 254
    //   250: aload_2
    //   251: invokevirtual 464	java/io/FileOutputStream:close	()V
    //   254: aload_1
    //   255: athrow
    //   256: astore_1
    //   257: return
    //   258: astore_2
    //   259: goto -79 -> 180
    //   262: astore_2
    //   263: goto -9 -> 254
    //   266: astore_1
    //   267: aload_3
    //   268: astore_2
    //   269: goto -23 -> 246
    //   272: astore 4
    //   274: goto -66 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	bdud
    //   0	277	1	paramFileStoragePushFSSvcList	FileStoragePushFSSvcList
    //   6	162	2	localObject1	Object
    //   201	5	2	localException1	Exception
    //   209	9	2	localObject2	Object
    //   241	10	2	localIOException1	java.io.IOException
    //   258	1	2	localIOException2	java.io.IOException
    //   262	1	2	localIOException3	java.io.IOException
    //   268	1	2	localObject3	Object
    //   1	267	3	localObject4	Object
    //   3	223	4	localObject5	Object
    //   272	1	4	localException2	Exception
    //   13	153	5	localFile	java.io.File
    //   104	34	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   7	15	201	java/lang/Exception
    //   21	27	201	java/lang/Exception
    //   29	39	201	java/lang/Exception
    //   46	54	201	java/lang/Exception
    //   56	62	201	java/lang/Exception
    //   64	74	201	java/lang/Exception
    //   76	82	201	java/lang/Exception
    //   97	106	201	java/lang/Exception
    //   108	114	201	java/lang/Exception
    //   116	123	201	java/lang/Exception
    //   125	136	201	java/lang/Exception
    //   234	238	241	java/io/IOException
    //   7	15	245	finally
    //   21	27	245	finally
    //   29	39	245	finally
    //   46	54	245	finally
    //   56	62	245	finally
    //   64	74	245	finally
    //   76	82	245	finally
    //   97	106	245	finally
    //   108	114	245	finally
    //   116	123	245	finally
    //   125	136	245	finally
    //   210	216	245	finally
    //   218	230	245	finally
    //   86	94	256	java/io/IOException
    //   176	180	258	java/io/IOException
    //   250	254	262	java/io/IOException
    //   136	165	266	finally
    //   165	172	266	finally
    //   136	165	272	java/lang/Exception
    //   165	172	272	java/lang/Exception
  }
  
  private ArrayList<FileStorageServerListInfo> d(int paramInt)
  {
    int j = 0;
    if (this.jdField_b_of_type_JavaUtilHashtable.containsKey(Integer.valueOf(paramInt))) {
      return (ArrayList)this.jdField_b_of_type_JavaUtilHashtable.get(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      int i;
      Object localObject2;
      try
      {
        if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.domainIpChannel != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists != null))
        {
          i = 0;
          if (i < this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists.size())
          {
            Object localObject1 = (DomainIpList)this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists.get(i);
            if (((DomainIpList)localObject1).uDomain_type != paramInt) {
              break label354;
            }
            localObject2 = ((DomainIpList)localObject1).vIplist;
            localObject1 = new ArrayList();
            i = j;
            if (i < ((ArrayList)localObject2).size())
            {
              localObject3 = new FileStorageServerListInfo();
              ((FileStorageServerListInfo)localObject3).sIP = bgnt.a(((DomainIpInfo)((ArrayList)localObject2).get(i)).uIp);
              ((FileStorageServerListInfo)localObject3).iPort = ((DomainIpInfo)((ArrayList)localObject2).get(i)).uPort;
              ((ArrayList)localObject1).add(localObject3);
              i += 1;
              continue;
            }
            this.jdField_b_of_type_JavaUtilHashtable.put(Integer.valueOf(paramInt), localObject1);
            if (!QLog.isColorLevel()) {
              break label351;
            }
            localObject2 = new StringBuffer();
            Object localObject3 = ((ArrayList)localObject1).iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label310;
            }
            FileStorageServerListInfo localFileStorageServerListInfo = (FileStorageServerListInfo)((Iterator)localObject3).next();
            ((StringBuffer)localObject2).append(localFileStorageServerListInfo.sIP).append(":").append(localFileStorageServerListInfo.iPort).append(",");
            continue;
          }
        }
        return null;
      }
      catch (NoSuchFieldError localNoSuchFieldError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FMT_ADDR", 2, localNoSuchFieldError.getMessage());
        }
      }
      label310:
      QLog.d("FMT_ADDR", 2, "Domain type=" + paramInt + ",iplist=" + ((StringBuffer)localObject2).toString());
      label351:
      return localNoSuchFieldError;
      label354:
      i += 1;
    }
  }
  
  private void d()
  {
    int i = 1;
    while (i < 8)
    {
      c(i);
      i += 1;
    }
    this.jdField_a_of_type_Bduf.a(this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList);
    if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.fmtIPInfo != null))
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.fmtIPInfo.sGateIp;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.fmtIPInfo.iGateIpOper;
    }
    if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList == null)
    {
      this.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_JavaLangString = "";
    }
    b();
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bdue = new bdue();
    if (QLog.isDevelopLevel()) {
      QLog.d("SPD", 4, "Clear GroupPtt D-IpList");
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList == null) || (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.pttlist == null) || (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.pttlist.length == 0))
    {
      e();
      return;
    }
    this.jdField_a_of_type_Bdue = a(this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.pttlist);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    FileStoragePushFSSvcList localFileStoragePushFSSvcList = b();
    if ((localFileStoragePushFSSvcList != null) && (localFileStoragePushFSSvcList.fmtIPInfo != null)) {
      return localFileStoragePushFSSvcList.fmtIPInfo.iGateIpOper;
    }
    return -1L;
  }
  
  public FileStoragePushFSSvcList a()
  {
    try
    {
      FileStoragePushFSSvcList localFileStoragePushFSSvcList = this.jdField_b_of_type_ConfigPushFileStoragePushFSSvcList;
      return localFileStoragePushFSSvcList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public azth a()
  {
    return this.jdField_a_of_type_Azth;
  }
  
  /* Error */
  public bdue a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 17
    //   6: aconst_null
    //   7: astore 15
    //   9: aconst_null
    //   10: astore 19
    //   12: aconst_null
    //   13: astore 18
    //   15: aconst_null
    //   16: astore 16
    //   18: aconst_null
    //   19: astore 10
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 570	bdud:a	([B)Z
    //   26: ifne +15 -> 41
    //   29: new 77	bdue
    //   32: dup
    //   33: invokespecial 78	bdue:<init>	()V
    //   36: astore 9
    //   38: aload 9
    //   40: areturn
    //   41: aload 10
    //   43: astore 8
    //   45: aload 19
    //   47: astore 12
    //   49: aload 11
    //   51: astore 9
    //   53: aload_1
    //   54: ifnull +572 -> 626
    //   57: aload 16
    //   59: astore 13
    //   61: aload 15
    //   63: astore 14
    //   65: aload 10
    //   67: astore 8
    //   69: aload 19
    //   71: astore 12
    //   73: aload 11
    //   75: astore 9
    //   77: aload 18
    //   79: astore 10
    //   81: aload 17
    //   83: astore 11
    //   85: aload_1
    //   86: arraylength
    //   87: ifle +539 -> 626
    //   90: aload 16
    //   92: astore 13
    //   94: aload 15
    //   96: astore 14
    //   98: aload 18
    //   100: astore 10
    //   102: aload 17
    //   104: astore 11
    //   106: new 77	bdue
    //   109: dup
    //   110: invokespecial 78	bdue:<init>	()V
    //   113: astore 15
    //   115: aload_1
    //   116: iconst_1
    //   117: baload
    //   118: istore 4
    //   120: iconst_0
    //   121: istore_2
    //   122: iconst_2
    //   123: istore_3
    //   124: aconst_null
    //   125: astore 10
    //   127: aconst_null
    //   128: astore 8
    //   130: iload_2
    //   131: iload 4
    //   133: if_icmpge +481 -> 614
    //   136: aload_1
    //   137: iload_3
    //   138: baload
    //   139: istore 5
    //   141: iload_3
    //   142: iconst_1
    //   143: iadd
    //   144: istore_3
    //   145: iconst_2
    //   146: newarray byte
    //   148: astore 9
    //   150: aload_1
    //   151: iload_3
    //   152: aload 9
    //   154: iconst_0
    //   155: iconst_2
    //   156: invokestatic 284	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   159: iload_3
    //   160: iconst_2
    //   161: iadd
    //   162: istore_3
    //   163: aload 9
    //   165: iconst_0
    //   166: invokestatic 575	bgjw:a	([BI)S
    //   169: istore 6
    //   171: aload_1
    //   172: iload_3
    //   173: iload 6
    //   175: newarray byte
    //   177: iconst_0
    //   178: iload 6
    //   180: invokestatic 284	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   183: iload 5
    //   185: iconst_1
    //   186: if_icmpne +117 -> 303
    //   189: new 577	java/io/ByteArrayInputStream
    //   192: dup
    //   193: aload_1
    //   194: iload_3
    //   195: iload 6
    //   197: invokespecial 579	java/io/ByteArrayInputStream:<init>	([BII)V
    //   200: astore 9
    //   202: new 581	java/io/DataInputStream
    //   205: dup
    //   206: aload 9
    //   208: invokespecial 584	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   211: astore 10
    //   213: aload 15
    //   215: aload 10
    //   217: invokevirtual 587	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   220: putfield 251	bdue:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   223: aload 9
    //   225: astore 8
    //   227: aload 10
    //   229: astore 9
    //   231: aload 8
    //   233: ifnull +24 -> 257
    //   236: aload 9
    //   238: astore 13
    //   240: aload 8
    //   242: astore 14
    //   244: aload 9
    //   246: astore 10
    //   248: aload 8
    //   250: astore 11
    //   252: aload 8
    //   254: invokevirtual 588	java/io/ByteArrayInputStream:close	()V
    //   257: aload 9
    //   259: ifnull +24 -> 283
    //   262: aload 9
    //   264: astore 13
    //   266: aload 8
    //   268: astore 14
    //   270: aload 9
    //   272: astore 10
    //   274: aload 8
    //   276: astore 11
    //   278: aload 9
    //   280: invokevirtual 589	java/io/DataInputStream:close	()V
    //   283: iload_2
    //   284: iconst_1
    //   285: iadd
    //   286: istore_2
    //   287: iload_3
    //   288: iload 6
    //   290: iadd
    //   291: istore_3
    //   292: aload 8
    //   294: astore 10
    //   296: aload 9
    //   298: astore 8
    //   300: goto -170 -> 130
    //   303: iload 5
    //   305: iconst_2
    //   306: if_icmpne +190 -> 496
    //   309: new 577	java/io/ByteArrayInputStream
    //   312: dup
    //   313: aload_1
    //   314: iload_3
    //   315: iload 6
    //   317: invokespecial 579	java/io/ByteArrayInputStream:<init>	([BII)V
    //   320: astore 9
    //   322: new 581	java/io/DataInputStream
    //   325: dup
    //   326: aload 9
    //   328: invokespecial 584	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   331: astore 10
    //   333: aload 15
    //   335: aload 10
    //   337: invokevirtual 587	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   340: putfield 260	bdue:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   343: new 577	java/io/ByteArrayInputStream
    //   346: dup
    //   347: aload_1
    //   348: iload_3
    //   349: iload 6
    //   351: invokespecial 579	java/io/ByteArrayInputStream:<init>	([BII)V
    //   354: astore 12
    //   356: new 581	java/io/DataInputStream
    //   359: dup
    //   360: aload 12
    //   362: invokespecial 584	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   365: astore 9
    //   367: aload 9
    //   369: astore 13
    //   371: aload 12
    //   373: astore 14
    //   375: aload 9
    //   377: astore 10
    //   379: aload 12
    //   381: astore 11
    //   383: aload 15
    //   385: getfield 592	bdue:jdField_b_of_type_ArrayOfInt	[I
    //   388: iconst_0
    //   389: aload 9
    //   391: invokevirtual 595	java/io/DataInputStream:readInt	()I
    //   394: iastore
    //   395: aload 9
    //   397: astore 13
    //   399: aload 12
    //   401: astore 14
    //   403: aload 9
    //   405: astore 10
    //   407: aload 12
    //   409: astore 11
    //   411: aload 15
    //   413: getfield 592	bdue:jdField_b_of_type_ArrayOfInt	[I
    //   416: iconst_1
    //   417: aload 9
    //   419: invokevirtual 595	java/io/DataInputStream:readInt	()I
    //   422: iastore
    //   423: aload 12
    //   425: astore 8
    //   427: goto -196 -> 231
    //   430: astore 9
    //   432: aload 14
    //   434: astore 8
    //   436: aload 13
    //   438: astore_1
    //   439: aload_1
    //   440: astore 10
    //   442: aload 8
    //   444: astore 11
    //   446: aload 9
    //   448: invokevirtual 291	java/lang/Throwable:printStackTrace	()V
    //   451: aload_1
    //   452: astore 10
    //   454: aload 8
    //   456: astore 11
    //   458: new 77	bdue
    //   461: dup
    //   462: invokespecial 78	bdue:<init>	()V
    //   465: astore 12
    //   467: aload 8
    //   469: ifnull +8 -> 477
    //   472: aload 8
    //   474: invokevirtual 588	java/io/ByteArrayInputStream:close	()V
    //   477: aload 12
    //   479: astore 9
    //   481: aload_1
    //   482: ifnull -444 -> 38
    //   485: aload_1
    //   486: invokevirtual 589	java/io/DataInputStream:close	()V
    //   489: aload 12
    //   491: areturn
    //   492: astore_1
    //   493: aload 12
    //   495: areturn
    //   496: iload 5
    //   498: iconst_3
    //   499: if_icmpeq +9 -> 508
    //   502: iload 5
    //   504: iconst_4
    //   505: if_icmpne +360 -> 865
    //   508: new 577	java/io/ByteArrayInputStream
    //   511: dup
    //   512: aload_1
    //   513: iload_3
    //   514: iload 6
    //   516: invokespecial 579	java/io/ByteArrayInputStream:<init>	([BII)V
    //   519: astore 9
    //   521: new 581	java/io/DataInputStream
    //   524: dup
    //   525: aload 9
    //   527: invokespecial 584	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   530: astore 10
    //   532: aload 10
    //   534: invokevirtual 595	java/io/DataInputStream:readInt	()I
    //   537: istore 7
    //   539: aload 10
    //   541: invokevirtual 587	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   544: astore 8
    //   546: iload 5
    //   548: iconst_3
    //   549: if_icmpne +34 -> 583
    //   552: aload 15
    //   554: getfield 238	bdue:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   557: new 263	ConfigPush/FileStorageServerListInfo
    //   560: dup
    //   561: aload 8
    //   563: iload 7
    //   565: invokespecial 598	ConfigPush/FileStorageServerListInfo:<init>	(Ljava/lang/String;I)V
    //   568: invokevirtual 192	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   571: pop
    //   572: aload 9
    //   574: astore 8
    //   576: aload 10
    //   578: astore 9
    //   580: goto -349 -> 231
    //   583: aload 15
    //   585: getfield 242	bdue:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   588: new 263	ConfigPush/FileStorageServerListInfo
    //   591: dup
    //   592: aload 8
    //   594: iload 7
    //   596: invokespecial 598	ConfigPush/FileStorageServerListInfo:<init>	(Ljava/lang/String;I)V
    //   599: invokevirtual 192	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   602: pop
    //   603: aload 9
    //   605: astore 8
    //   607: aload 10
    //   609: astore 9
    //   611: goto -380 -> 231
    //   614: aload 10
    //   616: astore 9
    //   618: aload 8
    //   620: astore 12
    //   622: aload 15
    //   624: astore 8
    //   626: aload 9
    //   628: ifnull +8 -> 636
    //   631: aload 9
    //   633: invokevirtual 588	java/io/ByteArrayInputStream:close	()V
    //   636: aload 8
    //   638: astore 9
    //   640: aload 12
    //   642: ifnull -604 -> 38
    //   645: aload 12
    //   647: invokevirtual 589	java/io/DataInputStream:close	()V
    //   650: aload 8
    //   652: areturn
    //   653: astore_1
    //   654: aload 8
    //   656: areturn
    //   657: astore_1
    //   658: aload 11
    //   660: astore 9
    //   662: aload 10
    //   664: astore 8
    //   666: aload 9
    //   668: ifnull +8 -> 676
    //   671: aload 9
    //   673: invokevirtual 588	java/io/ByteArrayInputStream:close	()V
    //   676: aload 8
    //   678: ifnull +8 -> 686
    //   681: aload 8
    //   683: invokevirtual 589	java/io/DataInputStream:close	()V
    //   686: aload_1
    //   687: athrow
    //   688: astore 8
    //   690: goto -4 -> 686
    //   693: astore_1
    //   694: aload 10
    //   696: astore 8
    //   698: goto -32 -> 666
    //   701: astore_1
    //   702: aload 10
    //   704: astore 8
    //   706: goto -40 -> 666
    //   709: astore_1
    //   710: aload 10
    //   712: astore 8
    //   714: aload 12
    //   716: astore 9
    //   718: goto -52 -> 666
    //   721: astore_1
    //   722: aload 10
    //   724: astore 8
    //   726: goto -60 -> 666
    //   729: astore_1
    //   730: aload 10
    //   732: astore 9
    //   734: goto -68 -> 666
    //   737: astore_1
    //   738: goto -72 -> 666
    //   741: astore_1
    //   742: goto -76 -> 666
    //   745: astore_1
    //   746: goto -80 -> 666
    //   749: astore_1
    //   750: aload 9
    //   752: astore 8
    //   754: aload_1
    //   755: astore 9
    //   757: aload 10
    //   759: astore_1
    //   760: goto -321 -> 439
    //   763: astore 11
    //   765: aload 10
    //   767: astore_1
    //   768: aload 9
    //   770: astore 8
    //   772: aload 11
    //   774: astore 9
    //   776: goto -337 -> 439
    //   779: astore 9
    //   781: aload 10
    //   783: astore_1
    //   784: aload 12
    //   786: astore 8
    //   788: goto -349 -> 439
    //   791: astore_1
    //   792: aload 9
    //   794: astore 8
    //   796: aload_1
    //   797: astore 9
    //   799: aload 10
    //   801: astore_1
    //   802: goto -363 -> 439
    //   805: astore 9
    //   807: aload 8
    //   809: astore_1
    //   810: aload 10
    //   812: astore 8
    //   814: goto -375 -> 439
    //   817: astore 10
    //   819: aload 8
    //   821: astore_1
    //   822: aload 9
    //   824: astore 8
    //   826: aload 10
    //   828: astore 9
    //   830: goto -391 -> 439
    //   833: astore 10
    //   835: aload 8
    //   837: astore_1
    //   838: aload 9
    //   840: astore 8
    //   842: aload 10
    //   844: astore 9
    //   846: goto -407 -> 439
    //   849: astore 10
    //   851: aload 8
    //   853: astore_1
    //   854: aload 9
    //   856: astore 8
    //   858: aload 10
    //   860: astore 9
    //   862: goto -423 -> 439
    //   865: aload 8
    //   867: astore 9
    //   869: aload 10
    //   871: astore 8
    //   873: goto -642 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	876	0	this	bdud
    //   0	876	1	paramArrayOfByte	byte[]
    //   121	166	2	i	int
    //   123	391	3	j	int
    //   118	16	4	k	int
    //   139	411	5	m	int
    //   169	346	6	n	int
    //   537	58	7	i1	int
    //   43	639	8	localObject1	Object
    //   688	1	8	localThrowable1	Throwable
    //   696	176	8	localObject2	Object
    //   36	382	9	localObject3	Object
    //   430	17	9	localThrowable2	Throwable
    //   479	296	9	localObject4	Object
    //   779	14	9	localThrowable3	Throwable
    //   797	1	9	arrayOfByte	byte[]
    //   805	18	9	localThrowable4	Throwable
    //   828	40	9	localObject5	Object
    //   19	792	10	localObject6	Object
    //   817	10	10	localThrowable5	Throwable
    //   833	10	10	localThrowable6	Throwable
    //   849	21	10	localThrowable7	Throwable
    //   1	658	11	localObject7	Object
    //   763	10	11	localThrowable8	Throwable
    //   47	738	12	localObject8	Object
    //   59	378	13	localObject9	Object
    //   63	370	14	localObject10	Object
    //   7	616	15	localbdue	bdue
    //   16	75	16	localObject11	Object
    //   4	99	17	localObject12	Object
    //   13	86	18	localObject13	Object
    //   10	60	19	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   85	90	430	java/lang/Throwable
    //   106	115	430	java/lang/Throwable
    //   252	257	430	java/lang/Throwable
    //   278	283	430	java/lang/Throwable
    //   383	395	430	java/lang/Throwable
    //   411	423	430	java/lang/Throwable
    //   472	477	492	java/lang/Throwable
    //   485	489	492	java/lang/Throwable
    //   631	636	653	java/lang/Throwable
    //   645	650	653	java/lang/Throwable
    //   85	90	657	finally
    //   106	115	657	finally
    //   252	257	657	finally
    //   278	283	657	finally
    //   383	395	657	finally
    //   411	423	657	finally
    //   446	451	657	finally
    //   458	467	657	finally
    //   671	676	688	java/lang/Throwable
    //   681	686	688	java/lang/Throwable
    //   213	223	693	finally
    //   333	356	701	finally
    //   356	367	709	finally
    //   532	546	721	finally
    //   552	572	721	finally
    //   583	603	721	finally
    //   145	159	729	finally
    //   163	183	729	finally
    //   189	202	729	finally
    //   309	322	729	finally
    //   508	521	729	finally
    //   202	213	737	finally
    //   322	333	741	finally
    //   521	532	745	finally
    //   213	223	749	java/lang/Throwable
    //   333	356	763	java/lang/Throwable
    //   356	367	779	java/lang/Throwable
    //   532	546	791	java/lang/Throwable
    //   552	572	791	java/lang/Throwable
    //   583	603	791	java/lang/Throwable
    //   145	159	805	java/lang/Throwable
    //   163	183	805	java/lang/Throwable
    //   189	202	805	java/lang/Throwable
    //   309	322	805	java/lang/Throwable
    //   508	521	805	java/lang/Throwable
    //   202	213	817	java/lang/Throwable
    //   322	333	833	java/lang/Throwable
    //   521	532	849	java/lang/Throwable
  }
  
  public bdzc a()
  {
    return this.jdField_a_of_type_Bdzc;
  }
  
  public HwConfig a()
  {
    HwConfig localHwConfig = null;
    Map localMap = a();
    if (localMap != null) {
      localHwConfig = (HwConfig)localMap.get(Integer.valueOf(10));
    }
    return localHwConfig;
  }
  
  public subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf == null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf = b();
    }
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf == null) {
        break label107;
      }
      QLog.d("FMT_ADDR", 2, "getPicEncryptSwitch: pic:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf.bool_enable_encrypted_pic.get() + ",url:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf.bool_enable_encrypt_request.get() + ",ctlFlag:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf.uint32_ctrl_flag.get());
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf;
      label107:
      QLog.d("FMT_ADDR", 2, "getPicEncryptSwitch: none!");
    }
  }
  
  public String a()
  {
    Object localObject1 = null;
    try
    {
      FileStorageServerListInfo localFileStorageServerListInfo = this.jdField_a_of_type_Bduf.a();
      if (localFileStorageServerListInfo != null)
      {
        localObject1 = new StringBuffer(200);
        ((StringBuffer)localObject1).append("http://").append(localFileStorageServerListInfo.sIP);
        if (localFileStorageServerListInfo.iPort != 80) {
          ((StringBuffer)localObject1).append(":").append(localFileStorageServerListInfo.iPort);
        }
        ((StringBuffer)localObject1).append("/");
        localObject1 = ((StringBuffer)localObject1).toString();
      }
      return localObject1;
    }
    finally {}
  }
  
  public ArrayList<FileStorageServerListInfo> a(int paramInt)
  {
    try
    {
      ArrayList localArrayList = b(paramInt);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ArrayList<FileStorageServerListInfo> a(byte[] paramArrayOfByte)
  {
    Object localObject = new ptt_apply.QQApplyAuthkeyRsp();
    try
    {
      ((ptt_apply.QQApplyAuthkeyRsp)localObject).mergeFrom(paramArrayOfByte);
      if (((ptt_apply.QQApplyAuthkeyRsp)localObject).address.has())
      {
        paramArrayOfByte = ((ptt_apply.QQApplyAuthkeyRsp)localObject).address.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
        {
          localObject = new ArrayList();
          int i = 0;
          while (i < paramArrayOfByte.size())
          {
            ptt_apply.Addr localAddr = (ptt_apply.Addr)paramArrayOfByte.get(i);
            int j = localAddr.uint32_out_ip.get();
            if (j != 0)
            {
              int k = localAddr.uint32_out_port.get();
              ((ArrayList)localObject).add(new FileStorageServerListInfo(a(j), k));
            }
            i += 1;
          }
          return localObject;
        }
      }
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public Map<Integer, HwConfig> a()
  {
    HashMap localHashMap = new HashMap();
    if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel != null))
    {
      Object localObject1 = new StringBuilder().append("GetHighwayConfig  Has PbBuffer : ");
      boolean bool;
      if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_pb_buf != null) {
        bool = true;
      }
      for (;;)
      {
        QLog.d("FMT_ADDR", 2, String.valueOf(bool) + " IpList : " + this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_iplists.size());
        if ((this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_pb_buf != null) && (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_pb_buf.length > 0))
        {
          Object localObject2 = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_pb_buf;
          localObject1 = new subcmd0x501.RspBody();
          try
          {
            ((subcmd0x501.RspBody)localObject1).mergeFrom((byte[])localObject2);
            if (localObject1 != null)
            {
              localObject1 = (subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)localObject1).msg_subcmd_0x501_rsp_body.get();
              localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
              SessionInfo.updateSessionInfo(((subcmd0x501.SubCmd0x501Rspbody)localObject1).bytes_httpconn_sig_session.get().toByteArray(), ((subcmd0x501.SubCmd0x501Rspbody)localObject1).bytes_session_key.get().toByteArray(), (String)localObject2);
              localObject2 = ((subcmd0x501.SubCmd0x501Rspbody)localObject1).rpt_msg_httpconn_addrs.get();
              if ((localObject2 != null) && (((List)localObject2).size() != 0))
              {
                localObject2 = ((List)localObject2).iterator();
                if (!((Iterator)localObject2).hasNext()) {
                  break label802;
                }
                localObject3 = (subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)((Iterator)localObject2).next();
                j = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject3).uint32_service_type.get();
                if (QLog.isColorLevel()) {
                  QLog.d("FMT_ADDR", 2, "GetHighwayConfig   find HwServlet.HIGHWAY_SERVICE_TYPE" + j);
                }
                if (j == 10)
                {
                  localHwConfig = a((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject3);
                  localHwConfig.netSegConfList = new ArrayList();
                  localObject3 = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject3).rpt_msg_netsegconf.get();
                  if ((localObject3 != null) && (((List)localObject3).size() != 0))
                  {
                    int i = 0;
                    while (i < ((List)localObject3).size())
                    {
                      subcmd0x501.SubCmd0x501Rspbody.NetSegConf localNetSegConf = (subcmd0x501.SubCmd0x501Rspbody.NetSegConf)((List)localObject3).get(i);
                      localHwConfig.netSegConfList.add(new HwNetSegConf(localNetSegConf.uint32_net_type.get(), localNetSegConf.uint32_segsize.get(), localNetSegConf.uint32_segnum.get(), localNetSegConf.uint32_curconnnum.get()));
                      i += 1;
                      continue;
                      bool = false;
                    }
                  }
                }
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Object localObject3;
              int j;
              HwConfig localHwConfig;
              localObject1 = null;
              localException.printStackTrace();
              continue;
              if (((subcmd0x501.SubCmd0x501Rspbody)localObject1).msg_ip_learn_conf.has()) {
                localHwConfig.ipConf = ((subcmd0x501.SubCmd0x501Rspbody.IpLearnConf)((subcmd0x501.SubCmd0x501Rspbody)localObject1).msg_ip_learn_conf.get());
              }
              if (((subcmd0x501.SubCmd0x501Rspbody)localObject1).msg_dyn_timeout_conf.has()) {
                localHwConfig.dtConf = ((subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf)((subcmd0x501.SubCmd0x501Rspbody)localObject1).msg_dyn_timeout_conf.get());
              }
              if (((subcmd0x501.SubCmd0x501Rspbody)localObject1).msg_open_up_conf.has()) {
                localHwConfig.openUpConf = ((subcmd0x501.SubCmd0x501Rspbody.OpenUpConf)((subcmd0x501.SubCmd0x501Rspbody)localObject1).msg_open_up_conf.get());
              }
              if (((subcmd0x501.SubCmd0x501Rspbody)localObject1).msg_short_video_conf.has())
              {
                localHwConfig.videoConf = ((subcmd0x501.SubCmd0x501Rspbody)localObject1).msg_short_video_conf;
                label563:
                if (!((subcmd0x501.SubCmd0x501Rspbody)localObject1).msg_ptv_conf.has()) {
                  break label683;
                }
                localHwConfig.ptvCof = ((subcmd0x501.SubCmd0x501Rspbody)localObject1).msg_ptv_conf;
                label584:
                if (!((subcmd0x501.SubCmd0x501Rspbody)localObject1).uint32_fmt_policy.has()) {
                  break label702;
                }
                localHwConfig.fmtIpv6Policy = ((subcmd0x501.SubCmd0x501Rspbody)localObject1).uint32_fmt_policy;
                label605:
                if (!((subcmd0x501.SubCmd0x501Rspbody)localObject1).uint32_bigdata_policy.has()) {
                  break label721;
                }
                localHwConfig.bdhIpv6Policy = ((subcmd0x501.SubCmd0x501Rspbody)localObject1).uint32_bigdata_policy;
                label626:
                if (!((subcmd0x501.SubCmd0x501Rspbody)localObject1).uint32_conn_attempt_delay.has()) {
                  break label740;
                }
                localHwConfig.connAttemptDelay = ((subcmd0x501.SubCmd0x501Rspbody)localObject1).uint32_conn_attempt_delay;
              }
              for (;;)
              {
                localHashMap.put(Integer.valueOf(j), localHwConfig);
                break;
                if (!QLog.isColorLevel()) {
                  break label563;
                }
                QLog.d("FMT_ADDR", 2, "<BDH_LOG> getHighwayConfig from push. rspBody.msg_short_video_conf.has() : false ! ");
                break label563;
                label683:
                if (!QLog.isColorLevel()) {
                  break label584;
                }
                QLog.d("FMT_ADDR", 2, "<BDH_LOG> getHighwayConfig from push. rspBody.msg_ptv_conf.has() : false ! ");
                break label584;
                label702:
                if (!QLog.isColorLevel()) {
                  break label605;
                }
                QLog.d("FMT_ADDR", 2, "<BDH_LOG> getHighwayConfig from push. rspBody.uint32_fmt_policy.has() : false ! ");
                break label605;
                label721:
                if (!QLog.isColorLevel()) {
                  break label626;
                }
                QLog.d("FMT_ADDR", 2, "<BDH_LOG> getHighwayConfig from push. rspBody.uint32_bigdata_policy.has() : false ! ");
                break label626;
                label740:
                if (QLog.isColorLevel()) {
                  QLog.d("FMT_ADDR", 2, "<BDH_LOG> getHighwayConfig from push. rspBody.uint32_conn_attempt_delay.has() : false ! ");
                }
              }
              if (j == 21) {
                localHashMap.put(Integer.valueOf(j), a((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject3));
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("FMT_ADDR", 2, "GetHighwayConfig srvAddrList == null || srvAddrList.size() == 0");
            }
          }
        }
      }
    }
    label802:
    return localHashMap;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "FMT SERVER LIST CLEARED!!!");
      }
      if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList == null)
      {
        this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList = new FileStoragePushFSSvcList();
        if (QLog.isColorLevel()) {
          QLog.d("FMT_ADDR", 2, "bug, not supposed to be null");
        }
      }
      ArrayList localArrayList1 = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vC2CPicDownList;
      ArrayList localArrayList2 = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vGPicDownLoadList;
      FileStoragePushFSSvcList localFileStoragePushFSSvcList = new FileStoragePushFSSvcList();
      localFileStoragePushFSSvcList.vC2CPicDownList = localArrayList1;
      localFileStoragePushFSSvcList.vGPicDownLoadList = localArrayList2;
      localFileStoragePushFSSvcList.pttlist = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.pttlist;
      a(localFileStoragePushFSSvcList);
      this.jdField_a_of_type_Bduf.a();
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      this.jdField_b_of_type_JavaUtilHashtable.clear();
      this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList = new FileStoragePushFSSvcList();
      this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vC2CPicDownList = localArrayList1;
      this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.vGPicDownLoadList = localArrayList2;
      this.jdField_a_of_type_Int = 2;
      d();
      return;
    }
    finally {}
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 16) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bdue.a(this.jdField_a_of_type_Azth.b(), paramString);
        if (QLog.isDevelopLevel()) {
          QLog.d("SPD", 4, "onFailed for GroupPtt: " + paramString);
        }
        return;
      }
      finally {}
      this.jdField_a_of_type_Bduf.a(paramInt, paramString);
    }
  }
  
  public void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "set svclist" + paramFileStoragePushFSSvcList);
      }
      this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList = paramFileStoragePushFSSvcList;
      this.jdField_a_of_type_Int = 1;
      d();
      c(paramFileStoragePushFSSvcList);
      return;
    }
    finally {}
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        if (paramArrayOfByte.length != 0) {
          break label82;
        }
        return false;
      }
      catch (Throwable paramArrayOfByte) {}
      if (i < k)
      {
        j += 1;
        byte[] arrayOfByte = new byte[2];
        System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, 2);
        j = j + 2 + bgjw.a(arrayOfByte, 0);
        if (j <= paramArrayOfByte.length) {
          i += 1;
        }
      }
      else
      {
        i = paramArrayOfByte.length;
        if (j == i) {
          return bool;
        }
        bool = false;
        continue;
      }
      label82:
      while (paramArrayOfByte[0] != 0) {
        return false;
      }
      int k = paramArrayOfByte[1];
      int j = 2;
      int i = 0;
    }
  }
  
  /* Error */
  public byte[] a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 98	bdud:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 98	bdud:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   13: getfield 403	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   16: ifnull +33 -> 49
    //   19: aload_0
    //   20: getfield 98	bdud:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   23: getfield 403	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   26: getfield 875	ConfigPush/BigDataChannel:uSig_Uin	J
    //   29: lload_1
    //   30: lcmp
    //   31: ifne +18 -> 49
    //   34: aload_0
    //   35: getfield 98	bdud:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   38: getfield 403	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   41: getfield 878	ConfigPush/BigDataChannel:sBigdata_sig_session	[B
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: areturn
    //   49: aconst_null
    //   50: astore_3
    //   51: goto -6 -> 45
    //   54: astore_3
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_3
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	bdud
    //   0	59	1	paramLong	long
    //   44	7	3	arrayOfByte	byte[]
    //   54	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	45	54	finally
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = a(paramArrayOfByte);
    String str = this.jdField_a_of_type_Azth.b();
    boolean bool = this.jdField_a_of_type_Azth.a();
    if (this.jdField_a_of_type_Bdue != null)
    {
      if (!bool) {
        break label58;
      }
      this.jdField_a_of_type_Bdue.jdField_a_of_type_JavaUtilArrayList = paramArrayOfByte;
      this.jdField_a_of_type_Bdue.jdField_a_of_type_JavaLangString = str;
    }
    for (;;)
    {
      return a(this.jdField_a_of_type_Bdue);
      label58:
      this.jdField_a_of_type_Bdue.jdField_b_of_type_JavaUtilArrayList = paramArrayOfByte;
      this.jdField_a_of_type_Bdue.jdField_b_of_type_JavaLangString = str;
    }
  }
  
  public subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf b()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2;
    if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList != null)
    {
      localObject1 = localObject3;
      if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel != null)
      {
        localObject1 = localObject3;
        if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_pb_buf != null)
        {
          localObject1 = localObject3;
          if (this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_pb_buf.length > 0)
          {
            localObject1 = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_pb_buf;
            localObject2 = new subcmd0x501.RspBody();
          }
        }
      }
    }
    try
    {
      ((subcmd0x501.RspBody)localObject2).mergeFrom((byte[])localObject1);
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject2 = ((subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)localObject2).msg_subcmd_0x501_rsp_body.get()).msg_download_encrypt_conf;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            QLog.d("FMT_ADDR", 2, "picEncryptSwitchInit: pic:" + ((subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf)localObject2).bool_enable_encrypted_pic.get() + ",url:" + ((subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf)localObject2).bool_enable_encrypt_request.get() + ",ctlFlg:" + ((subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf)localObject2).uint32_ctrl_flag.get());
            localObject1 = localObject2;
          }
        }
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localObject2 = null;
      }
    }
  }
  
  public String b(int paramInt)
  {
    Object localObject1 = null;
    try
    {
      FileStorageServerListInfo localFileStorageServerListInfo = this.jdField_a_of_type_Bduf.a(paramInt);
      if (localFileStorageServerListInfo != null)
      {
        localObject1 = new StringBuffer(200);
        ((StringBuffer)localObject1).append("http://").append(localFileStorageServerListInfo.sIP);
        if (localFileStorageServerListInfo.iPort != 80) {
          ((StringBuffer)localObject1).append(":").append(localFileStorageServerListInfo.iPort);
        }
        ((StringBuffer)localObject1).append("/");
        localObject1 = ((StringBuffer)localObject1).toString();
      }
      return localObject1;
    }
    finally {}
  }
  
  public void b(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "setSvcListCache" + paramFileStoragePushFSSvcList);
      }
      this.jdField_b_of_type_ConfigPushFileStoragePushFSSvcList = paramFileStoragePushFSSvcList;
      return;
    }
    finally {}
  }
  
  /* Error */
  public byte[] b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 98	bdud:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 98	bdud:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   13: getfield 403	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   16: ifnull +33 -> 49
    //   19: aload_0
    //   20: getfield 98	bdud:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   23: getfield 403	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   26: getfield 875	ConfigPush/BigDataChannel:uSig_Uin	J
    //   29: lload_1
    //   30: lcmp
    //   31: ifne +18 -> 49
    //   34: aload_0
    //   35: getfield 98	bdud:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   38: getfield 403	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   41: getfield 900	ConfigPush/BigDataChannel:sBigdata_key_session	[B
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: areturn
    //   49: aconst_null
    //   50: astore_3
    //   51: goto -6 -> 45
    //   54: astore_3
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_3
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	bdud
    //   0	59	1	paramLong	long
    //   44	7	3	arrayOfByte	byte[]
    //   54	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	45	54	finally
  }
  
  public void c()
  {
    this.jdField_a_of_type_Azth.b();
    this.jdField_a_of_type_Bdzc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdud
 * JD-Core Version:    0.7.0.1
 */