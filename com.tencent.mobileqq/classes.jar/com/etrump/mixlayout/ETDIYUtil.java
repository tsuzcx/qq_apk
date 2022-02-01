package com.etrump.mixlayout;

import QC.GetUserDiyFontReq;
import QC.GetUserDiyFontRsp;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import gxh_message.Dialogue;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class ETDIYUtil
{
  public static final Map<String, String> a = new HashMap();
  public static final Map<String, String> b = new HashMap();
  
  public static int a(msg_comm.Msg paramMsg)
  {
    paramMsg = MessageProtoCodec.a(paramMsg);
    if (paramMsg != null)
    {
      if (!paramMsg.bytes_pb_reserve.has()) {
        return 0;
      }
      generalflags.ResvAttr localResvAttr = MessageProtoCodec.a(paramMsg);
      if (localResvAttr != null)
      {
        if (!localResvAttr.bytes_user_vip_info.has()) {
          return 0;
        }
        paramMsg = new Dialogue();
        try
        {
          paramMsg.mergeFrom(localResvAttr.bytes_user_vip_info.get().toByteArray());
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        int i = paramMsg.diyfontid.get();
        if (QLog.isColorLevel())
        {
          paramMsg = new StringBuilder();
          paramMsg.append("decodeC2CMsgPkg_DiyFontId->");
          paramMsg.append(i);
          QLog.d("ETDIYUtil", 2, paramMsg.toString());
        }
        return i;
      }
    }
    return 0;
  }
  
  private static void a(String paramString1, File paramFile, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      String str = (String)a.get(paramString2);
      if (!TextUtils.isEmpty(str))
      {
        b(paramFile, str, paramString3);
        return;
      }
      VasUtil.a().getJceRequset().build("QC.UniBusinessLoginServer.UniBusinessLoginObj", "QCUniBusinessLogin.diyfont", "stReq", "stRsp").request("GetUserDiyFont", new GetUserDiyFontReq(Long.parseLong(paramString2), VipUtils.a(paramString1, 0)), new GetUserDiyFontRsp(), new ETDIYUtil.1(paramFile, paramString3), true);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (b.get(paramString3) != null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/data/data/com.tencent.mobileqq/files/diy_fonts");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(".png");
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists())
    {
      a(paramString1, (File)localObject, paramString2, paramString3);
      return;
    }
    b((File)localObject, paramString3);
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 204	java/io/File:isFile	()Z
    //   4: ifeq +195 -> 199
    //   7: new 206	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 209	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: astore_3
    //   16: aload_3
    //   17: astore_2
    //   18: sipush 1024
    //   21: newarray byte
    //   23: astore 4
    //   25: aload_3
    //   26: astore_2
    //   27: new 211	java/io/ByteArrayOutputStream
    //   30: dup
    //   31: invokespecial 212	java/io/ByteArrayOutputStream:<init>	()V
    //   34: astore 5
    //   36: aload_3
    //   37: astore_2
    //   38: aload_3
    //   39: aload 4
    //   41: invokevirtual 216	java/io/FileInputStream:read	([B)I
    //   44: istore_1
    //   45: iload_1
    //   46: iconst_m1
    //   47: if_icmpeq +17 -> 64
    //   50: aload_3
    //   51: astore_2
    //   52: aload 5
    //   54: aload 4
    //   56: iconst_0
    //   57: iload_1
    //   58: invokevirtual 220	java/io/ByteArrayOutputStream:write	([BII)V
    //   61: goto -25 -> 36
    //   64: aload_3
    //   65: astore_2
    //   66: aload 5
    //   68: invokevirtual 221	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   71: astore 4
    //   73: aload_3
    //   74: invokevirtual 224	java/io/FileInputStream:close	()V
    //   77: aload 4
    //   79: areturn
    //   80: astore_0
    //   81: ldc 97
    //   83: iconst_1
    //   84: aload_0
    //   85: invokevirtual 227	java/io/IOException:getMessage	()Ljava/lang/String;
    //   88: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload 4
    //   93: areturn
    //   94: astore_0
    //   95: goto +80 -> 175
    //   98: astore_0
    //   99: aconst_null
    //   100: astore_2
    //   101: goto +74 -> 175
    //   104: aconst_null
    //   105: astore_3
    //   106: aload_3
    //   107: astore_2
    //   108: new 85	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   115: astore 4
    //   117: aload_3
    //   118: astore_2
    //   119: aload 4
    //   121: ldc 232
    //   123: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_3
    //   128: astore_2
    //   129: aload 4
    //   131: aload_0
    //   132: invokevirtual 235	java/io/File:getPath	()Ljava/lang/String;
    //   135: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_3
    //   140: astore_2
    //   141: ldc 97
    //   143: iconst_1
    //   144: aload 4
    //   146: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_3
    //   153: ifnull +20 -> 173
    //   156: aload_3
    //   157: invokevirtual 224	java/io/FileInputStream:close	()V
    //   160: aconst_null
    //   161: areturn
    //   162: astore_0
    //   163: ldc 97
    //   165: iconst_1
    //   166: aload_0
    //   167: invokevirtual 227	java/io/IOException:getMessage	()Ljava/lang/String;
    //   170: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aconst_null
    //   174: areturn
    //   175: aload_2
    //   176: ifnull +21 -> 197
    //   179: aload_2
    //   180: invokevirtual 224	java/io/FileInputStream:close	()V
    //   183: goto +14 -> 197
    //   186: astore_2
    //   187: ldc 97
    //   189: iconst_1
    //   190: aload_2
    //   191: invokevirtual 227	java/io/IOException:getMessage	()Ljava/lang/String;
    //   194: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_0
    //   198: athrow
    //   199: new 85	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   206: astore_2
    //   207: aload_2
    //   208: ldc 237
    //   210: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload_2
    //   215: aload_0
    //   216: invokevirtual 235	java/io/File:getPath	()Ljava/lang/String;
    //   219: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: ldc 97
    //   225: iconst_1
    //   226: aload_2
    //   227: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aconst_null
    //   234: areturn
    //   235: astore_2
    //   236: goto -132 -> 104
    //   239: astore_2
    //   240: goto -134 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramFile	File
    //   44	14	1	i	int
    //   17	163	2	localFileInputStream1	java.io.FileInputStream
    //   186	5	2	localIOException1	java.io.IOException
    //   206	21	2	localStringBuilder	StringBuilder
    //   235	1	2	localIOException2	java.io.IOException
    //   239	1	2	localIOException3	java.io.IOException
    //   15	142	3	localFileInputStream2	java.io.FileInputStream
    //   23	122	4	localObject	Object
    //   34	33	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   73	77	80	java/io/IOException
    //   18	25	94	finally
    //   27	36	94	finally
    //   38	45	94	finally
    //   52	61	94	finally
    //   66	73	94	finally
    //   108	117	94	finally
    //   119	127	94	finally
    //   129	139	94	finally
    //   141	152	94	finally
    //   7	16	98	finally
    //   156	160	162	java/io/IOException
    //   179	183	186	java/io/IOException
    //   7	16	235	java/io/IOException
    //   18	25	239	java/io/IOException
    //   27	36	239	java/io/IOException
    //   38	45	239	java/io/IOException
    //   52	61	239	java/io/IOException
    //   66	73	239	java/io/IOException
  }
  
  private static void b(File paramFile, String paramString)
  {
    paramFile = a(paramFile);
    if (paramFile == null) {
      return;
    }
    paramFile = Base64.encode(paramFile, 0);
    b.put(paramString, new String(paramFile));
  }
  
  private static void b(File paramFile, String paramString1, String paramString2)
  {
    if (paramFile.exists()) {
      return;
    }
    Bundle localBundle = new Bundle();
    paramString1 = new DownloadTask(paramString1, paramFile);
    paramString1.u = 60L;
    ((DownloaderFactory)BaseApplicationImpl.sApplication.getRuntime().getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).startDownload(paramString1, new ETDIYUtil.2(paramFile, paramString2), localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETDIYUtil
 * JD-Core Version:    0.7.0.1
 */