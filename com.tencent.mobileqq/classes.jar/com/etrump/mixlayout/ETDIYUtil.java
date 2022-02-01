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
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.JceProtocol;
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
    int j = 0;
    paramMsg = MessageProtoCodec.a(paramMsg);
    int i = j;
    if (paramMsg != null)
    {
      if (paramMsg.bytes_pb_reserve.has()) {
        break label27;
      }
      i = j;
    }
    for (;;)
    {
      return i;
      label27:
      generalflags.ResvAttr localResvAttr = MessageProtoCodec.a(paramMsg);
      i = j;
      if (localResvAttr == null) {
        continue;
      }
      i = j;
      if (!localResvAttr.bytes_user_vip_info.has()) {
        continue;
      }
      paramMsg = new Dialogue();
      try
      {
        paramMsg.mergeFrom(localResvAttr.bytes_user_vip_info.get().toByteArray());
        j = paramMsg.diyfontid.get();
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ETDIYUtil", 2, "decodeC2CMsgPkg_DiyFontId->" + j);
        return j;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
  }
  
  private static void a(String paramString1, File paramFile, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    String str = (String)a.get(paramString2);
    if (!TextUtils.isEmpty(str))
    {
      b(paramFile, str, paramString3);
      return;
    }
    new JceProtocol("QC.UniBusinessLoginServer.UniBusinessLoginObj", "QCUniBusinessLogin.diyfont", "stReq", "stRsp").a("GetUserDiyFont", new GetUserDiyFontReq(Long.parseLong(paramString2), VipUtils.a(paramString1, 0)), new GetUserDiyFontRsp(), new ETDIYUtil.1(paramFile, paramString3), true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (b.get(paramString3) != null) {
      return;
    }
    File localFile = new File("/data/data/com.tencent.mobileqq/files/diy_fonts" + File.separator + paramString3 + ".png");
    if (!localFile.exists())
    {
      a(paramString1, localFile, paramString2, paramString3);
      return;
    }
    b(localFile, paramString3);
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 191	java/io/File:isFile	()Z
    //   7: ifeq +184 -> 191
    //   10: new 193	java/io/FileInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 196	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   18: astore_3
    //   19: aload_3
    //   20: astore_2
    //   21: sipush 1024
    //   24: newarray byte
    //   26: astore 5
    //   28: aload_3
    //   29: astore_2
    //   30: new 198	java/io/ByteArrayOutputStream
    //   33: dup
    //   34: invokespecial 199	java/io/ByteArrayOutputStream:<init>	()V
    //   37: astore 6
    //   39: aload_3
    //   40: astore_2
    //   41: aload_3
    //   42: aload 5
    //   44: invokevirtual 203	java/io/FileInputStream:read	([B)I
    //   47: istore_1
    //   48: iload_1
    //   49: iconst_m1
    //   50: if_icmpeq +64 -> 114
    //   53: aload_3
    //   54: astore_2
    //   55: aload 6
    //   57: aload 5
    //   59: iconst_0
    //   60: iload_1
    //   61: invokevirtual 207	java/io/ByteArrayOutputStream:write	([BII)V
    //   64: goto -25 -> 39
    //   67: astore_2
    //   68: aload_3
    //   69: astore_2
    //   70: ldc 82
    //   72: iconst_1
    //   73: new 84	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   80: ldc 209
    //   82: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: invokevirtual 212	java/io/File:getPath	()Ljava/lang/String;
    //   89: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload 4
    //   100: astore_0
    //   101: aload_3
    //   102: ifnull +10 -> 112
    //   105: aload_3
    //   106: invokevirtual 218	java/io/FileInputStream:close	()V
    //   109: aload 4
    //   111: astore_0
    //   112: aload_0
    //   113: areturn
    //   114: aload_3
    //   115: astore_2
    //   116: aload 6
    //   118: invokevirtual 219	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   121: astore 5
    //   123: aload 5
    //   125: astore_2
    //   126: aload_2
    //   127: astore_0
    //   128: aload_3
    //   129: ifnull -17 -> 112
    //   132: aload_3
    //   133: invokevirtual 218	java/io/FileInputStream:close	()V
    //   136: aload_2
    //   137: areturn
    //   138: astore_0
    //   139: ldc 82
    //   141: iconst_1
    //   142: aload_0
    //   143: invokevirtual 222	java/io/IOException:getMessage	()Ljava/lang/String;
    //   146: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload_2
    //   150: areturn
    //   151: astore_0
    //   152: ldc 82
    //   154: iconst_1
    //   155: aload_0
    //   156: invokevirtual 222	java/io/IOException:getMessage	()Ljava/lang/String;
    //   159: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aconst_null
    //   163: areturn
    //   164: astore_0
    //   165: aconst_null
    //   166: astore_2
    //   167: aload_2
    //   168: ifnull +7 -> 175
    //   171: aload_2
    //   172: invokevirtual 218	java/io/FileInputStream:close	()V
    //   175: aload_0
    //   176: athrow
    //   177: astore_2
    //   178: ldc 82
    //   180: iconst_1
    //   181: aload_2
    //   182: invokevirtual 222	java/io/IOException:getMessage	()Ljava/lang/String;
    //   185: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: goto -13 -> 175
    //   191: ldc 82
    //   193: iconst_1
    //   194: new 84	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   201: ldc 224
    //   203: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_0
    //   207: invokevirtual 212	java/io/File:getPath	()Ljava/lang/String;
    //   210: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aconst_null
    //   220: areturn
    //   221: astore_0
    //   222: goto -55 -> 167
    //   225: astore_2
    //   226: aconst_null
    //   227: astore_3
    //   228: goto -160 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramFile	File
    //   47	14	1	i	int
    //   20	35	2	localFileInputStream1	java.io.FileInputStream
    //   67	1	2	localIOException1	java.io.IOException
    //   69	103	2	localObject1	Object
    //   177	5	2	localIOException2	java.io.IOException
    //   225	1	2	localIOException3	java.io.IOException
    //   18	210	3	localFileInputStream2	java.io.FileInputStream
    //   1	109	4	localObject2	Object
    //   26	98	5	arrayOfByte	byte[]
    //   37	80	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   21	28	67	java/io/IOException
    //   30	39	67	java/io/IOException
    //   41	48	67	java/io/IOException
    //   55	64	67	java/io/IOException
    //   116	123	67	java/io/IOException
    //   132	136	138	java/io/IOException
    //   105	109	151	java/io/IOException
    //   10	19	164	finally
    //   171	175	177	java/io/IOException
    //   21	28	221	finally
    //   30	39	221	finally
    //   41	48	221	finally
    //   55	64	221	finally
    //   70	98	221	finally
    //   116	123	221	finally
    //   10	19	225	java/io/IOException
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
    paramString1.d = 60L;
    ((DownloaderFactory)BaseApplicationImpl.sApplication.getRuntime().getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).a(paramString1, new ETDIYUtil.2(paramFile, paramString2), localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.ETDIYUtil
 * JD-Core Version:    0.7.0.1
 */