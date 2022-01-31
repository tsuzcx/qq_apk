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
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.cs.ptt_apply.ptt_apply.Addr;
import tencent.im.cs.ptt_apply.ptt_apply.QQApplyAuthkeyRsp;

public final class ayqf
{
  private static ayqf jdField_a_of_type_Ayqf;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[1];
  private static final String jdField_b_of_type_JavaLangString = ajsf.cq + "fmtSrvAddr.ini";
  private static final String c = ajsf.cq + "srvAddr.ini";
  private static final String d = ajsf.cq + "ipDownAddr.ini";
  private static final String e = ajsf.cq + "ipDownAddr.tmp";
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  private FileStoragePushFSSvcList jdField_a_of_type_ConfigPushFileStoragePushFSSvcList = b();
  private avbu jdField_a_of_type_Avbu = new avbu();
  private ayqg jdField_a_of_type_Ayqg = new ayqg();
  private ayqh jdField_a_of_type_Ayqh = new ayqh(this);
  private ayvp jdField_a_of_type_Ayvp = new ayvp();
  private subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf;
  public Object a;
  private String jdField_a_of_type_JavaLangString = "";
  private Hashtable<Integer, ArrayList<FileStorageServerListInfo>> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private FileStoragePushFSSvcList jdField_b_of_type_ConfigPushFileStoragePushFSSvcList;
  private Hashtable<Integer, ArrayList<FileStorageServerListInfo>> jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  
  private ayqf()
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
  
  public static ayqf a()
  {
    if (jdField_a_of_type_Ayqf == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Ayqf == null) {
        jdField_a_of_type_Ayqf = new ayqf();
      }
      return jdField_a_of_type_Ayqf;
    }
  }
  
  public static String a(int paramInt)
  {
    return (paramInt >> 0 & 0xFF) + '.' + (paramInt >> 8 & 0xFF) + '.' + (paramInt >> 16 & 0xFF) + '.' + (paramInt >> 24 & 0xFF);
  }
  
  private byte[] a(ayqg paramayqg)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    ByteArrayOutputStream localByteArrayOutputStream;
    DataOutputStream localDataOutputStream;
    int k;
    int j;
    if (paramayqg != null)
    {
      localObject1 = (byte[][])null;
      localObject3 = (byte[][])null;
      if ((paramayqg.jdField_a_of_type_JavaUtilArrayList == null) || (paramayqg.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
        break label842;
      }
      localObject1 = new byte[paramayqg.jdField_a_of_type_JavaUtilArrayList.size()][];
      localObject2 = localObject3;
      if (paramayqg.jdField_b_of_type_JavaUtilArrayList != null)
      {
        localObject2 = localObject3;
        if (paramayqg.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
          localObject2 = new byte[paramayqg.jdField_b_of_type_JavaUtilArrayList.size()][];
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
        if (paramayqg.jdField_a_of_type_JavaLangString == null) {
          break label836;
        }
        localDataOutputStream.writeUTF(paramayqg.jdField_a_of_type_JavaLangString);
        localObject3 = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.reset();
        k = 0 + (localObject3.length + 3);
        j = 1;
        if (paramayqg.jdField_b_of_type_JavaLangString == null) {
          break label830;
        }
        localDataOutputStream.writeUTF(paramayqg.jdField_b_of_type_JavaLangString);
        arrayOfByte = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.reset();
        k += arrayOfByte.length + 3;
        j += 1;
        i = j;
        m = k;
        Object localObject4;
        if (paramayqg.jdField_a_of_type_JavaUtilArrayList != null)
        {
          i = j;
          m = k;
          if (paramayqg.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            m = 0;
            i = k;
            k = m;
            if (k >= paramayqg.jdField_a_of_type_JavaUtilArrayList.size()) {
              break label845;
            }
            localObject4 = (FileStorageServerListInfo)paramayqg.jdField_a_of_type_JavaUtilArrayList.get(k);
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
        if ((paramayqg.jdField_b_of_type_JavaUtilArrayList != null) && (paramayqg.jdField_b_of_type_JavaUtilArrayList.size() > 0))
        {
          k = 0;
          j = m;
          if (k >= paramayqg.jdField_b_of_type_JavaUtilArrayList.size()) {
            break label853;
          }
          localObject4 = (FileStorageServerListInfo)paramayqg.jdField_b_of_type_JavaUtilArrayList.get(k);
          localDataOutputStream.writeInt(((FileStorageServerListInfo)localObject4).iPort);
          localDataOutputStream.writeUTF(((FileStorageServerListInfo)localObject4).sIP);
          localObject2[k] = localByteArrayOutputStream.toByteArray();
          localByteArrayOutputStream.reset();
          j += localObject2[k].length + 3;
          i += 1;
          k += 1;
          continue;
          paramayqg = new byte[j + 2];
          paramayqg[0] = 0;
          paramayqg[1] = ((byte)i);
          j = 2;
          if (localObject3 != null)
          {
            paramayqg[2] = 1;
            localObject4 = bbmj.a((short)localObject3.length);
            System.arraycopy(localObject4, 0, paramayqg, 3, localObject4.length);
            i = localObject4.length + 3;
            System.arraycopy(localObject3, 0, paramayqg, i, localObject3.length);
            j = i + localObject3.length;
          }
          i = j;
          if (arrayOfByte != null)
          {
            paramayqg[j] = 2;
            i = j + 1;
            localObject3 = bbmj.a((short)arrayOfByte.length);
            System.arraycopy(localObject3, 0, paramayqg, i, localObject3.length);
            i += localObject3.length;
            System.arraycopy(arrayOfByte, 0, paramayqg, i, arrayOfByte.length);
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
                paramayqg[i] = 3;
                i += 1;
                localObject3 = bbmj.a((short)localObject1[k].length);
                System.arraycopy(localObject3, 0, paramayqg, i, localObject3.length);
                i += localObject3.length;
                System.arraycopy(localObject1[k], 0, paramayqg, i, localObject1[k].length);
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
              paramayqg[j] = 4;
              j += 1;
              localObject1 = bbmj.a((short)localObject2[i].length);
              System.arraycopy(localObject1, 0, paramayqg, j, localObject1.length);
              j += localObject1.length;
              System.arraycopy(localObject2[i], 0, paramayqg, j, localObject2[i].length);
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
      catch (Throwable paramayqg)
      {
        paramayqg = paramayqg;
        paramayqg.printStackTrace();
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
    //   0: getstatic 53	ayqf:c	Ljava/lang/String;
    //   3: invokestatic 218	bbdj:a	(Ljava/lang/String;)Ljava/io/File;
    //   6: astore_2
    //   7: aload_2
    //   8: invokevirtual 224	java/io/File:length	()J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifne +33 -> 46
    //   16: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +11 -> 30
    //   22: ldc 232
    //   24: iconst_2
    //   25: ldc 234
    //   27: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: iconst_0
    //   31: ifeq +11 -> 42
    //   34: new 239	java/lang/NullPointerException
    //   37: dup
    //   38: invokespecial 240	java/lang/NullPointerException:<init>	()V
    //   41: athrow
    //   42: aconst_null
    //   43: astore_3
    //   44: aload_3
    //   45: areturn
    //   46: new 242	java/io/FileInputStream
    //   49: dup
    //   50: aload_2
    //   51: invokespecial 245	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore 4
    //   56: aload 4
    //   58: astore_3
    //   59: sipush 1024
    //   62: newarray byte
    //   64: astore 5
    //   66: aload 4
    //   68: astore_3
    //   69: new 154	java/io/ByteArrayOutputStream
    //   72: dup
    //   73: invokespecial 155	java/io/ByteArrayOutputStream:<init>	()V
    //   76: astore_2
    //   77: aload 4
    //   79: astore_3
    //   80: aload 4
    //   82: aload 5
    //   84: invokevirtual 249	java/io/FileInputStream:read	([B)I
    //   87: istore_1
    //   88: iload_1
    //   89: iconst_m1
    //   90: if_icmpeq +60 -> 150
    //   93: aload 4
    //   95: astore_3
    //   96: aload_2
    //   97: aload 5
    //   99: iconst_0
    //   100: iload_1
    //   101: invokevirtual 253	java/io/ByteArrayOutputStream:write	([BII)V
    //   104: goto -27 -> 77
    //   107: astore 5
    //   109: aconst_null
    //   110: astore_2
    //   111: aload 4
    //   113: astore_3
    //   114: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +16 -> 133
    //   120: aload 4
    //   122: astore_3
    //   123: ldc 232
    //   125: iconst_2
    //   126: ldc 81
    //   128: aload 5
    //   130: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   133: aload_2
    //   134: astore_3
    //   135: aload 4
    //   137: ifnull -93 -> 44
    //   140: aload 4
    //   142: invokevirtual 257	java/io/FileInputStream:close	()V
    //   145: aload_2
    //   146: areturn
    //   147: astore_3
    //   148: aload_2
    //   149: areturn
    //   150: aload 4
    //   152: astore_3
    //   153: new 259	com/qq/taf/jce/JceInputStream
    //   156: dup
    //   157: aload_2
    //   158: invokevirtual 169	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   161: invokespecial 262	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   164: astore 5
    //   166: aload 4
    //   168: astore_3
    //   169: new 264	ConfigPush/FileStoragePushFSSvcList
    //   172: dup
    //   173: invokespecial 265	ConfigPush/FileStoragePushFSSvcList:<init>	()V
    //   176: astore_2
    //   177: aload 4
    //   179: astore_3
    //   180: aload_2
    //   181: aload 5
    //   183: invokevirtual 269	ConfigPush/FileStoragePushFSSvcList:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   186: aload_2
    //   187: astore_3
    //   188: aload 4
    //   190: ifnull -146 -> 44
    //   193: aload 4
    //   195: invokevirtual 257	java/io/FileInputStream:close	()V
    //   198: aload_2
    //   199: areturn
    //   200: astore_3
    //   201: aload_2
    //   202: areturn
    //   203: astore_2
    //   204: aconst_null
    //   205: astore_3
    //   206: aload_3
    //   207: ifnull +7 -> 214
    //   210: aload_3
    //   211: invokevirtual 257	java/io/FileInputStream:close	()V
    //   214: aload_2
    //   215: athrow
    //   216: astore_2
    //   217: goto -175 -> 42
    //   220: astore_3
    //   221: goto -7 -> 214
    //   224: astore_2
    //   225: goto -19 -> 206
    //   228: astore 5
    //   230: aconst_null
    //   231: astore 4
    //   233: aconst_null
    //   234: astore_2
    //   235: goto -124 -> 111
    //   238: astore 5
    //   240: goto -129 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	ayqf
    //   87	14	1	i	int
    //   6	196	2	localObject1	Object
    //   203	12	2	localObject2	Object
    //   216	1	2	localIOException1	java.io.IOException
    //   224	1	2	localObject3	Object
    //   234	1	2	localObject4	Object
    //   43	92	3	localObject5	Object
    //   147	1	3	localIOException2	java.io.IOException
    //   152	36	3	localObject6	Object
    //   200	1	3	localIOException3	java.io.IOException
    //   205	6	3	localObject7	Object
    //   220	1	3	localIOException4	java.io.IOException
    //   54	178	4	localFileInputStream	java.io.FileInputStream
    //   64	34	5	arrayOfByte	byte[]
    //   107	22	5	localException1	Exception
    //   164	18	5	localJceInputStream	com.qq.taf.jce.JceInputStream
    //   228	1	5	localException2	Exception
    //   238	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   59	66	107	java/lang/Exception
    //   69	77	107	java/lang/Exception
    //   80	88	107	java/lang/Exception
    //   96	104	107	java/lang/Exception
    //   153	166	107	java/lang/Exception
    //   169	177	107	java/lang/Exception
    //   140	145	147	java/io/IOException
    //   193	198	200	java/io/IOException
    //   0	30	203	finally
    //   46	56	203	finally
    //   34	42	216	java/io/IOException
    //   210	214	220	java/io/IOException
    //   59	66	224	finally
    //   69	77	224	finally
    //   80	88	224	finally
    //   96	104	224	finally
    //   114	120	224	finally
    //   123	133	224	finally
    //   153	166	224	finally
    //   169	177	224	finally
    //   180	186	224	finally
    //   0	30	228	java/lang/Exception
    //   46	56	228	java/lang/Exception
    //   180	186	238	java/lang/Exception
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
      return this.jdField_a_of_type_Ayqg.a(this.jdField_a_of_type_Avbu.b());
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getSvcList error,mSvcList=null");
    }
    return null;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Ayqf == null) {
      return;
    }
    jdField_a_of_type_Ayqf.c();
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
    //   7: getstatic 49	ayqf:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   10: invokestatic 218	bbdj:a	(Ljava/lang/String;)Ljava/io/File;
    //   13: astore 5
    //   15: aload_1
    //   16: ifnonnull +77 -> 93
    //   19: aload_3
    //   20: astore_2
    //   21: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +14 -> 38
    //   27: aload_3
    //   28: astore_2
    //   29: ldc 232
    //   31: iconst_2
    //   32: ldc_w 355
    //   35: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload 5
    //   40: ifnull +40 -> 80
    //   43: aload_3
    //   44: astore_2
    //   45: aload 5
    //   47: invokevirtual 358	java/io/File:exists	()Z
    //   50: ifeq +30 -> 80
    //   53: aload_3
    //   54: astore_2
    //   55: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +14 -> 72
    //   61: aload_3
    //   62: astore_2
    //   63: ldc 232
    //   65: iconst_2
    //   66: ldc_w 360
    //   69: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_3
    //   73: astore_2
    //   74: aload 5
    //   76: invokevirtual 363	java/io/File:delete	()Z
    //   79: pop
    //   80: iconst_0
    //   81: ifeq +11 -> 92
    //   84: new 239	java/lang/NullPointerException
    //   87: dup
    //   88: invokespecial 240	java/lang/NullPointerException:<init>	()V
    //   91: athrow
    //   92: return
    //   93: aload_3
    //   94: astore_2
    //   95: new 365	com/qq/taf/jce/JceOutputStream
    //   98: dup
    //   99: invokespecial 366	com/qq/taf/jce/JceOutputStream:<init>	()V
    //   102: astore 6
    //   104: aload_3
    //   105: astore_2
    //   106: aload_1
    //   107: aload 6
    //   109: invokevirtual 370	ConfigPush/FileStoragePushFSSvcList:writeTo	(Lcom/qq/taf/jce/JceOutputStream;)V
    //   112: aload_3
    //   113: astore_2
    //   114: aload 6
    //   116: invokevirtual 371	com/qq/taf/jce/JceOutputStream:toByteArray	()[B
    //   119: astore 6
    //   121: aload_3
    //   122: astore_2
    //   123: new 373	java/io/FileOutputStream
    //   126: dup
    //   127: aload 5
    //   129: iconst_0
    //   130: invokespecial 376	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   133: astore_3
    //   134: aload_3
    //   135: aload 6
    //   137: invokevirtual 378	java/io/FileOutputStream:write	([B)V
    //   140: new 220	java/io/File
    //   143: dup
    //   144: getstatic 53	ayqf:c	Ljava/lang/String;
    //   147: invokespecial 380	java/io/File:<init>	(Ljava/lang/String;)V
    //   150: astore_2
    //   151: aload_2
    //   152: invokevirtual 358	java/io/File:exists	()Z
    //   155: ifeq +8 -> 163
    //   158: aload_2
    //   159: invokevirtual 363	java/io/File:delete	()Z
    //   162: pop
    //   163: aload 5
    //   165: aload_2
    //   166: invokevirtual 384	java/io/File:renameTo	(Ljava/io/File;)Z
    //   169: pop
    //   170: aload_3
    //   171: ifnull +7 -> 178
    //   174: aload_3
    //   175: invokevirtual 385	java/io/FileOutputStream:close	()V
    //   178: aload_1
    //   179: ifnull -87 -> 92
    //   182: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq -93 -> 92
    //   188: ldc 232
    //   190: iconst_2
    //   191: ldc_w 387
    //   194: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: return
    //   198: astore_2
    //   199: aload 4
    //   201: astore_3
    //   202: aload_2
    //   203: astore 4
    //   205: aload_3
    //   206: astore_2
    //   207: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq +16 -> 226
    //   213: aload_3
    //   214: astore_2
    //   215: ldc 232
    //   217: iconst_2
    //   218: ldc_w 389
    //   221: aload 4
    //   223: invokestatic 256	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload_3
    //   227: ifnull -49 -> 178
    //   230: aload_3
    //   231: invokevirtual 385	java/io/FileOutputStream:close	()V
    //   234: goto -56 -> 178
    //   237: astore_2
    //   238: goto -60 -> 178
    //   241: astore_1
    //   242: aload_2
    //   243: ifnull +7 -> 250
    //   246: aload_2
    //   247: invokevirtual 385	java/io/FileOutputStream:close	()V
    //   250: aload_1
    //   251: athrow
    //   252: astore_1
    //   253: return
    //   254: astore_2
    //   255: goto -77 -> 178
    //   258: astore_2
    //   259: goto -9 -> 250
    //   262: astore_1
    //   263: aload_3
    //   264: astore_2
    //   265: goto -23 -> 242
    //   268: astore 4
    //   270: goto -65 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	ayqf
    //   0	273	1	paramFileStoragePushFSSvcList	FileStoragePushFSSvcList
    //   6	160	2	localObject1	Object
    //   198	5	2	localException1	Exception
    //   206	9	2	localObject2	Object
    //   237	10	2	localIOException1	java.io.IOException
    //   254	1	2	localIOException2	java.io.IOException
    //   258	1	2	localIOException3	java.io.IOException
    //   264	1	2	localObject3	Object
    //   1	263	3	localObject4	Object
    //   3	219	4	localObject5	Object
    //   268	1	4	localException2	Exception
    //   13	151	5	localFile	java.io.File
    //   102	34	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   7	15	198	java/lang/Exception
    //   21	27	198	java/lang/Exception
    //   29	38	198	java/lang/Exception
    //   45	53	198	java/lang/Exception
    //   55	61	198	java/lang/Exception
    //   63	72	198	java/lang/Exception
    //   74	80	198	java/lang/Exception
    //   95	104	198	java/lang/Exception
    //   106	112	198	java/lang/Exception
    //   114	121	198	java/lang/Exception
    //   123	134	198	java/lang/Exception
    //   230	234	237	java/io/IOException
    //   7	15	241	finally
    //   21	27	241	finally
    //   29	38	241	finally
    //   45	53	241	finally
    //   55	61	241	finally
    //   63	72	241	finally
    //   74	80	241	finally
    //   95	104	241	finally
    //   106	112	241	finally
    //   114	121	241	finally
    //   123	134	241	finally
    //   207	213	241	finally
    //   215	226	241	finally
    //   84	92	252	java/io/IOException
    //   174	178	254	java/io/IOException
    //   246	250	258	java/io/IOException
    //   134	163	262	finally
    //   163	170	262	finally
    //   134	163	268	java/lang/Exception
    //   163	170	268	java/lang/Exception
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
              break label352;
            }
            localObject2 = ((DomainIpList)localObject1).vIplist;
            localObject1 = new ArrayList();
            i = j;
            if (i < ((ArrayList)localObject2).size())
            {
              localObject3 = new FileStorageServerListInfo();
              ((FileStorageServerListInfo)localObject3).sIP = bbev.a(((DomainIpInfo)((ArrayList)localObject2).get(i)).uIp);
              ((FileStorageServerListInfo)localObject3).iPort = ((DomainIpInfo)((ArrayList)localObject2).get(i)).uPort;
              ((ArrayList)localObject1).add(localObject3);
              i += 1;
              continue;
            }
            this.jdField_b_of_type_JavaUtilHashtable.put(Integer.valueOf(paramInt), localObject1);
            if (!QLog.isColorLevel()) {
              break label349;
            }
            localObject2 = new StringBuffer();
            Object localObject3 = ((ArrayList)localObject1).iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label309;
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
      label309:
      QLog.d("FMT_ADDR", 2, "Domain type=" + paramInt + ",iplist=" + ((StringBuffer)localObject2).toString());
      label349:
      return localNoSuchFieldError;
      label352:
      i += 1;
    }
  }
  
  private void d()
  {
    int i = 1;
    while (i < 7)
    {
      c(i);
      i += 1;
    }
    this.jdField_a_of_type_Ayqh.a(this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList);
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
    this.jdField_a_of_type_Ayqg = new ayqg();
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
    this.jdField_a_of_type_Ayqg = a(this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.pttlist);
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
  
  public avbu a()
  {
    return this.jdField_a_of_type_Avbu;
  }
  
  /* Error */
  public ayqg a(byte[] paramArrayOfByte)
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
    //   23: invokevirtual 491	ayqf:a	([B)Z
    //   26: ifne +15 -> 41
    //   29: new 76	ayqg
    //   32: dup
    //   33: invokespecial 77	ayqg:<init>	()V
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
    //   106: new 76	ayqg
    //   109: dup
    //   110: invokespecial 77	ayqg:<init>	()V
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
    //   156: invokestatic 200	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   159: iload_3
    //   160: iconst_2
    //   161: iadd
    //   162: istore_3
    //   163: aload 9
    //   165: iconst_0
    //   166: invokestatic 496	bbbd:a	([BI)S
    //   169: istore 6
    //   171: aload_1
    //   172: iload_3
    //   173: iload 6
    //   175: newarray byte
    //   177: iconst_0
    //   178: iload 6
    //   180: invokestatic 200	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   183: iload 5
    //   185: iconst_1
    //   186: if_icmpne +117 -> 303
    //   189: new 498	java/io/ByteArrayInputStream
    //   192: dup
    //   193: aload_1
    //   194: iload_3
    //   195: iload 6
    //   197: invokespecial 500	java/io/ByteArrayInputStream:<init>	([BII)V
    //   200: astore 9
    //   202: new 502	java/io/DataInputStream
    //   205: dup
    //   206: aload 9
    //   208: invokespecial 505	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   211: astore 10
    //   213: aload 15
    //   215: aload 10
    //   217: invokevirtual 508	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   220: putfield 161	ayqg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   254: invokevirtual 509	java/io/ByteArrayInputStream:close	()V
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
    //   280: invokevirtual 510	java/io/DataInputStream:close	()V
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
    //   309: new 498	java/io/ByteArrayInputStream
    //   312: dup
    //   313: aload_1
    //   314: iload_3
    //   315: iload 6
    //   317: invokespecial 500	java/io/ByteArrayInputStream:<init>	([BII)V
    //   320: astore 9
    //   322: new 502	java/io/DataInputStream
    //   325: dup
    //   326: aload 9
    //   328: invokespecial 505	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   331: astore 10
    //   333: aload 15
    //   335: aload 10
    //   337: invokevirtual 508	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   340: putfield 173	ayqg:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   343: new 498	java/io/ByteArrayInputStream
    //   346: dup
    //   347: aload_1
    //   348: iload_3
    //   349: iload 6
    //   351: invokespecial 500	java/io/ByteArrayInputStream:<init>	([BII)V
    //   354: astore 12
    //   356: new 502	java/io/DataInputStream
    //   359: dup
    //   360: aload 12
    //   362: invokespecial 505	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
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
    //   385: getfield 513	ayqg:jdField_b_of_type_ArrayOfInt	[I
    //   388: iconst_0
    //   389: aload 9
    //   391: invokevirtual 516	java/io/DataInputStream:readInt	()I
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
    //   413: getfield 513	ayqg:jdField_b_of_type_ArrayOfInt	[I
    //   416: iconst_1
    //   417: aload 9
    //   419: invokevirtual 516	java/io/DataInputStream:readInt	()I
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
    //   448: invokevirtual 207	java/lang/Throwable:printStackTrace	()V
    //   451: aload_1
    //   452: astore 10
    //   454: aload 8
    //   456: astore 11
    //   458: new 76	ayqg
    //   461: dup
    //   462: invokespecial 77	ayqg:<init>	()V
    //   465: astore 12
    //   467: aload 8
    //   469: ifnull +8 -> 477
    //   472: aload 8
    //   474: invokevirtual 509	java/io/ByteArrayInputStream:close	()V
    //   477: aload 12
    //   479: astore 9
    //   481: aload_1
    //   482: ifnull -444 -> 38
    //   485: aload_1
    //   486: invokevirtual 510	java/io/DataInputStream:close	()V
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
    //   508: new 498	java/io/ByteArrayInputStream
    //   511: dup
    //   512: aload_1
    //   513: iload_3
    //   514: iload 6
    //   516: invokespecial 500	java/io/ByteArrayInputStream:<init>	([BII)V
    //   519: astore 9
    //   521: new 502	java/io/DataInputStream
    //   524: dup
    //   525: aload 9
    //   527: invokespecial 505	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   530: astore 10
    //   532: aload 10
    //   534: invokevirtual 516	java/io/DataInputStream:readInt	()I
    //   537: istore 7
    //   539: aload 10
    //   541: invokevirtual 508	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   544: astore 8
    //   546: iload 5
    //   548: iconst_3
    //   549: if_icmpne +34 -> 583
    //   552: aload 15
    //   554: getfield 143	ayqg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   557: new 179	ConfigPush/FileStorageServerListInfo
    //   560: dup
    //   561: aload 8
    //   563: iload 7
    //   565: invokespecial 519	ConfigPush/FileStorageServerListInfo:<init>	(Ljava/lang/String;I)V
    //   568: invokevirtual 346	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   571: pop
    //   572: aload 9
    //   574: astore 8
    //   576: aload 10
    //   578: astore 9
    //   580: goto -349 -> 231
    //   583: aload 15
    //   585: getfield 152	ayqg:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   588: new 179	ConfigPush/FileStorageServerListInfo
    //   591: dup
    //   592: aload 8
    //   594: iload 7
    //   596: invokespecial 519	ConfigPush/FileStorageServerListInfo:<init>	(Ljava/lang/String;I)V
    //   599: invokevirtual 346	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   633: invokevirtual 509	java/io/ByteArrayInputStream:close	()V
    //   636: aload 8
    //   638: astore 9
    //   640: aload 12
    //   642: ifnull -604 -> 38
    //   645: aload 12
    //   647: invokevirtual 510	java/io/DataInputStream:close	()V
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
    //   673: invokevirtual 509	java/io/ByteArrayInputStream:close	()V
    //   676: aload 8
    //   678: ifnull +8 -> 686
    //   681: aload 8
    //   683: invokevirtual 510	java/io/DataInputStream:close	()V
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
    //   0	876	0	this	ayqf
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
    //   7	616	15	localayqg	ayqg
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
  
  public ayvp a()
  {
    return this.jdField_a_of_type_Ayvp;
  }
  
  public HwConfig a()
  {
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
          Object localObject3 = this.jdField_a_of_type_ConfigPushFileStoragePushFSSvcList.bigDataChannel.vBigdata_pb_buf;
          localObject1 = new subcmd0x501.RspBody();
          try
          {
            ((subcmd0x501.RspBody)localObject1).mergeFrom((byte[])localObject3);
            if (localObject1 != null)
            {
              localObject1 = (subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)localObject1).msg_subcmd_0x501_rsp_body.get();
              localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
              SessionInfo.updateSessionInfo(((subcmd0x501.SubCmd0x501Rspbody)localObject1).bytes_httpconn_sig_session.get().toByteArray(), ((subcmd0x501.SubCmd0x501Rspbody)localObject1).bytes_session_key.get().toByteArray(), (String)localObject3);
              localObject3 = ((subcmd0x501.SubCmd0x501Rspbody)localObject1).rpt_msg_httpconn_addrs.get();
              if ((localObject3 == null) || (((List)localObject3).size() == 0)) {
                break label884;
              }
              localObject3 = ((List)localObject3).iterator();
              for (;;)
              {
                if (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)((Iterator)localObject3).next();
                  if (((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject4).uint32_service_type.get() == 10)
                  {
                    localObject3 = new HwConfig();
                    ((HwConfig)localObject3).ipList = new ArrayList();
                    localObject5 = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject4).rpt_msg_addrs.get();
                    if ((localObject5 != null) && (((List)localObject5).size() != 0))
                    {
                      i = 0;
                      for (;;)
                      {
                        if (i < ((List)localObject5).size())
                        {
                          localObject6 = (subcmd0x501.SubCmd0x501Rspbody.IpAddr)((List)localObject5).get(i);
                          localArrayList = ((HwConfig)localObject3).ipList;
                          str = HwServlet.spliceCircleUrl(((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject6).uint32_ip.get());
                          j = ((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject6).uint32_port.get();
                          if (((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject6).uint32_same_isp.get() == 1)
                          {
                            bool = true;
                            localArrayList.add(new EndPoint(str, j, bool));
                            i += 1;
                            continue;
                            bool = false;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          catch (Exception localException)
          {
            int i;
            Object localObject6;
            ArrayList localArrayList;
            String str;
            int j;
            Object localObject2;
            for (;;)
            {
              localException.printStackTrace();
              localObject2 = null;
              continue;
              bool = false;
            }
            ((HwConfig)localObject3).ipv6List = new ArrayList();
            Object localObject5 = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject4).rpt_msg_addrs_v6.get();
            if ((localObject5 != null) && (((List)localObject5).size() != 0))
            {
              i = 0;
              if (i < ((List)localObject5).size())
              {
                localObject6 = (subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)((List)localObject5).get(i);
                localArrayList = ((HwConfig)localObject3).ipv6List;
                str = HwServlet.spliceIpv6Url(((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject6).bytes_ip6.get().toByteArray());
                j = ((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject6).uint32_port.get();
                if (((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject6).uint32_same_isp.get() == 1) {}
                for (bool = true;; bool = false)
                {
                  localArrayList.add(new EndPoint(str, j, bool));
                  i += 1;
                  break;
                }
              }
            }
            ((HwConfig)localObject3).netSegConfList = new ArrayList();
            Object localObject4 = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject4).rpt_msg_netsegconf.get();
            if ((localObject4 != null) && (((List)localObject4).size() != 0))
            {
              i = 0;
              while (i < ((List)localObject4).size())
              {
                localObject5 = (subcmd0x501.SubCmd0x501Rspbody.NetSegConf)((List)localObject4).get(i);
                ((HwConfig)localObject3).netSegConfList.add(new HwNetSegConf(((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject5).uint32_net_type.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject5).uint32_segsize.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject5).uint32_segnum.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject5).uint32_curconnnum.get()));
                i += 1;
              }
            }
            if (localObject2.msg_ip_learn_conf.has()) {
              ((HwConfig)localObject3).ipConf = ((subcmd0x501.SubCmd0x501Rspbody.IpLearnConf)localObject2.msg_ip_learn_conf.get());
            }
            if (localObject2.msg_dyn_timeout_conf.has()) {
              ((HwConfig)localObject3).dtConf = ((subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf)localObject2.msg_dyn_timeout_conf.get());
            }
            if (localObject2.msg_open_up_conf.has()) {
              ((HwConfig)localObject3).openUpConf = ((subcmd0x501.SubCmd0x501Rspbody.OpenUpConf)localObject2.msg_open_up_conf.get());
            }
            if (localObject2.msg_short_video_conf.has())
            {
              ((HwConfig)localObject3).videoConf = localObject2.msg_short_video_conf;
              if (!localObject2.msg_ptv_conf.has()) {
                break label834;
              }
              ((HwConfig)localObject3).ptvCof = localObject2.msg_ptv_conf;
            }
            for (;;)
            {
              return localObject3;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("FMT_ADDR", 2, "<BDH_LOG> getHighwayConfig from push. rspBody.msg_short_video_conf.has() : false ! ");
              break;
              label834:
              if (QLog.isColorLevel()) {
                QLog.d("FMT_ADDR", 2, "<BDH_LOG> getHighwayConfig from push. rspBody.msg_ptv_conf.has() : false ! ");
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("FMT_ADDR", 2, "GetHighwayConfig cannot find HwServlet.HIGHWAY_SERVICE_TYPE");
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 1, "getBigDataDefaultIpList() cannot find channel(service type = 10)");
      }
      return null;
      label884:
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "GetHighwayConfig srvAddrList == null || srvAddrList.size() == 0");
      }
    }
  }
  
  public subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf == null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf = b();
    }
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf == null) {
        break label106;
      }
      QLog.d("FMT_ADDR", 2, "getPicEncryptSwitch: pic:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf.bool_enable_encrypted_pic.get() + ",url:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf.bool_enable_encrypt_request.get() + ",ctlFlag:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf.uint32_ctrl_flag.get());
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolSubcmd0x501$SubCmd0x501Rspbody$DownloadEncryptConf;
      label106:
      QLog.d("FMT_ADDR", 2, "getPicEncryptSwitch: none!");
    }
  }
  
  public String a()
  {
    Object localObject1 = null;
    try
    {
      FileStorageServerListInfo localFileStorageServerListInfo = this.jdField_a_of_type_Ayqh.a();
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
      this.jdField_a_of_type_Ayqh.a();
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
        this.jdField_a_of_type_Ayqg.a(this.jdField_a_of_type_Avbu.b(), paramString);
        if (QLog.isDevelopLevel()) {
          QLog.d("SPD", 4, "onFailed for GroupPtt: " + paramString);
        }
        return;
      }
      finally {}
      this.jdField_a_of_type_Ayqh.a(paramInt, paramString);
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
        j = j + 2 + bbbd.a(arrayOfByte, 0);
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
    //   3: getfield 97	ayqf:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 97	ayqf:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   13: getfield 320	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   16: ifnull +33 -> 49
    //   19: aload_0
    //   20: getfield 97	ayqf:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   23: getfield 320	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   26: getfield 837	ConfigPush/BigDataChannel:uSig_Uin	J
    //   29: lload_1
    //   30: lcmp
    //   31: ifne +18 -> 49
    //   34: aload_0
    //   35: getfield 97	ayqf:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   38: getfield 320	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   41: getfield 840	ConfigPush/BigDataChannel:sBigdata_sig_session	[B
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
    //   0	59	0	this	ayqf
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
    String str = this.jdField_a_of_type_Avbu.b();
    boolean bool = this.jdField_a_of_type_Avbu.a();
    if (this.jdField_a_of_type_Ayqg != null)
    {
      if (!bool) {
        break label58;
      }
      this.jdField_a_of_type_Ayqg.jdField_a_of_type_JavaUtilArrayList = paramArrayOfByte;
      this.jdField_a_of_type_Ayqg.jdField_a_of_type_JavaLangString = str;
    }
    for (;;)
    {
      return a(this.jdField_a_of_type_Ayqg);
      label58:
      this.jdField_a_of_type_Ayqg.jdField_b_of_type_JavaUtilArrayList = paramArrayOfByte;
      this.jdField_a_of_type_Ayqg.jdField_b_of_type_JavaLangString = str;
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
      FileStorageServerListInfo localFileStorageServerListInfo = this.jdField_a_of_type_Ayqh.a(paramInt);
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
    //   3: getfield 97	ayqf:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 97	ayqf:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   13: getfield 320	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   16: ifnull +33 -> 49
    //   19: aload_0
    //   20: getfield 97	ayqf:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   23: getfield 320	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   26: getfield 837	ConfigPush/BigDataChannel:uSig_Uin	J
    //   29: lload_1
    //   30: lcmp
    //   31: ifne +18 -> 49
    //   34: aload_0
    //   35: getfield 97	ayqf:jdField_a_of_type_ConfigPushFileStoragePushFSSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   38: getfield 320	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   41: getfield 862	ConfigPush/BigDataChannel:sBigdata_key_session	[B
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
    //   0	59	0	this	ayqf
    //   0	59	1	paramLong	long
    //   44	7	3	arrayOfByte	byte[]
    //   54	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	45	54	finally
  }
  
  public void c()
  {
    this.jdField_a_of_type_Avbu.b();
    this.jdField_a_of_type_Ayvp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayqf
 * JD-Core Version:    0.7.0.1
 */