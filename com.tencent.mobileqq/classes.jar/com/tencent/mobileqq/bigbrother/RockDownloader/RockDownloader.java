package com.tencent.mobileqq.bigbrother.RockDownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mm.vfs.VFSFileOp;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bigbrother.ServerApi.RspPreDownloadRecmd;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.open.appstore.db.DownloadInfoDB;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class RockDownloader
{
  public static final String a;
  private static String b;
  private static EntityManager c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".Rock/");
    a = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static RockDownloadInfo a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 16384);
    if (paramContext != null)
    {
      paramString = new RockDownloadInfo();
      paramString.setPackageName(paramContext.packageName);
      paramString.setRealVersionCode(paramContext.versionCode);
      return paramString;
    }
    return null;
  }
  
  public static String a()
  {
    if (b == null)
    {
      b = a;
      VFSFile localVFSFile = new VFSFile(b);
      if (!localVFSFile.exists()) {
        localVFSFile.mkdirs();
      }
    }
    return b;
  }
  
  private static String a(RockDownloadInfo paramRockDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(paramRockDownloadInfo.getDownloadFileNameMD5());
    return localStringBuilder.toString();
  }
  
  public static void a(RockDownloaderTask paramRockDownloaderTask)
  {
    if (!paramRockDownloaderTask.getDownloadInfo().verifyDate(1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
      }
      if (paramRockDownloaderTask.getRockDownloadListener() != null) {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), "RockDownloadInfo verifyDate fail", 10001);
      }
      b(paramRockDownloaderTask, "0x800A1E6");
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramRockDownloaderTask.getRuntime().getApplication(), RockDownloaderServlet.class);
    localNewIntent.putExtra("BUNDLE_CMD", "QQApkSvc.pre_download_apk");
    localNewIntent.putExtra("BUNDLE_KEY_UIN", paramRockDownloaderTask.getRuntime().getLongAccountUin());
    localNewIntent.putExtra("BUNDLE_KEY_SOURCE", paramRockDownloaderTask.getDownloadInfo().getBusinessName());
    localNewIntent.putExtra("BUNDLE_KEY_SCENE", paramRockDownloaderTask.getDownloadInfo().getBusinessScene());
    localNewIntent.putExtra("BUNDLE_KEY_PKG_NAME", paramRockDownloaderTask.getDownloadInfo().getPackageName());
    localNewIntent.setObserver(new RockDownloader.1(paramRockDownloaderTask));
    paramRockDownloaderTask.getRuntime().startServlet(localNewIntent);
    b(paramRockDownloaderTask, "0x800A1E8");
  }
  
  /* Error */
  private static boolean a(Context paramContext, VFSFile paramVFSFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 4
    //   9: new 226	java/io/RandomAccessFile
    //   12: dup
    //   13: aload_1
    //   14: invokevirtual 229	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   17: iconst_0
    //   18: invokestatic 235	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   21: ldc 237
    //   23: invokespecial 240	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: astore 5
    //   28: aload 5
    //   30: invokevirtual 244	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   33: astore 4
    //   35: aload 4
    //   37: getstatic 250	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   40: lconst_0
    //   41: ldc2_w 251
    //   44: invokevirtual 258	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   47: astore 6
    //   49: iconst_0
    //   50: istore_2
    //   51: iload_2
    //   52: iconst_4
    //   53: if_icmpge +41 -> 94
    //   56: aload 6
    //   58: iload_2
    //   59: invokevirtual 264	java/nio/MappedByteBuffer:get	(I)B
    //   62: istore_3
    //   63: iload_2
    //   64: ifne +12 -> 76
    //   67: iload_3
    //   68: bipush 80
    //   70: if_icmpne +6 -> 76
    //   73: goto +21 -> 94
    //   76: aload 6
    //   78: iload_2
    //   79: iload_3
    //   80: iconst_4
    //   81: isub
    //   82: i2b
    //   83: invokevirtual 268	java/nio/MappedByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   86: pop
    //   87: iload_2
    //   88: iconst_1
    //   89: iadd
    //   90: istore_2
    //   91: goto -40 -> 51
    //   94: aload 6
    //   96: invokevirtual 272	java/nio/MappedByteBuffer:flip	()Ljava/nio/Buffer;
    //   99: pop
    //   100: aload 6
    //   102: invokevirtual 276	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   105: pop
    //   106: aload 6
    //   108: invokevirtual 279	java/nio/MappedByteBuffer:clear	()Ljava/nio/Buffer;
    //   111: pop
    //   112: aload 4
    //   114: invokevirtual 282	java/nio/channels/FileChannel:close	()V
    //   117: aload 5
    //   119: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   122: aload_0
    //   123: aload_1
    //   124: invokevirtual 229	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   127: iconst_0
    //   128: invokestatic 235	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   131: invokestatic 285	com/tencent/mobileqq/bigbrother/RockDownloader/RockDownloader:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/data/RockDownloadInfo;
    //   134: astore_0
    //   135: aload_0
    //   136: ifnull +24 -> 160
    //   139: aload 5
    //   141: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   144: goto +12 -> 156
    //   147: astore_0
    //   148: goto +10 -> 158
    //   151: astore_0
    //   152: aload_0
    //   153: invokevirtual 288	java/io/IOException:printStackTrace	()V
    //   156: iconst_1
    //   157: ireturn
    //   158: aload_0
    //   159: athrow
    //   160: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   163: ifeq +12 -> 175
    //   166: ldc 117
    //   168: iconst_2
    //   169: ldc_w 290
    //   172: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload 5
    //   177: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   180: iconst_0
    //   181: ireturn
    //   182: astore_0
    //   183: goto +10 -> 193
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 288	java/io/IOException:printStackTrace	()V
    //   191: iconst_0
    //   192: ireturn
    //   193: aload_0
    //   194: athrow
    //   195: astore_0
    //   196: goto +95 -> 291
    //   199: astore_1
    //   200: aload 5
    //   202: astore_0
    //   203: goto +22 -> 225
    //   206: astore_1
    //   207: aload 5
    //   209: astore_0
    //   210: goto +49 -> 259
    //   213: astore_0
    //   214: aload 4
    //   216: astore 5
    //   218: goto +73 -> 291
    //   221: astore_1
    //   222: aload 6
    //   224: astore_0
    //   225: aload_0
    //   226: astore 4
    //   228: aload_1
    //   229: invokevirtual 288	java/io/IOException:printStackTrace	()V
    //   232: aload_0
    //   233: ifnull +56 -> 289
    //   236: aload_0
    //   237: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   240: iconst_0
    //   241: ireturn
    //   242: astore_0
    //   243: goto +10 -> 253
    //   246: astore_0
    //   247: aload_0
    //   248: invokevirtual 288	java/io/IOException:printStackTrace	()V
    //   251: iconst_0
    //   252: ireturn
    //   253: aload_0
    //   254: athrow
    //   255: astore_1
    //   256: aload 7
    //   258: astore_0
    //   259: aload_0
    //   260: astore 4
    //   262: aload_1
    //   263: invokevirtual 291	java/io/FileNotFoundException:printStackTrace	()V
    //   266: aload_0
    //   267: ifnull +22 -> 289
    //   270: aload_0
    //   271: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   274: iconst_0
    //   275: ireturn
    //   276: astore_0
    //   277: goto +10 -> 287
    //   280: astore_0
    //   281: aload_0
    //   282: invokevirtual 288	java/io/IOException:printStackTrace	()V
    //   285: iconst_0
    //   286: ireturn
    //   287: aload_0
    //   288: athrow
    //   289: iconst_0
    //   290: ireturn
    //   291: aload 5
    //   293: ifnull +25 -> 318
    //   296: aload 5
    //   298: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   301: goto +17 -> 318
    //   304: astore_0
    //   305: goto +11 -> 316
    //   308: astore_1
    //   309: aload_1
    //   310: invokevirtual 288	java/io/IOException:printStackTrace	()V
    //   313: goto +5 -> 318
    //   316: aload_0
    //   317: athrow
    //   318: goto +5 -> 323
    //   321: aload_0
    //   322: athrow
    //   323: goto -2 -> 321
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramContext	Context
    //   0	326	1	paramVFSFile	VFSFile
    //   50	41	2	i	int
    //   62	20	3	j	int
    //   7	254	4	localObject1	Object
    //   26	271	5	localObject2	Object
    //   1	222	6	localMappedByteBuffer	java.nio.MappedByteBuffer
    //   4	253	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   139	144	147	finally
    //   152	156	147	finally
    //   139	144	151	java/io/IOException
    //   175	180	182	finally
    //   187	191	182	finally
    //   175	180	186	java/io/IOException
    //   28	49	195	finally
    //   56	63	195	finally
    //   76	87	195	finally
    //   94	135	195	finally
    //   160	175	195	finally
    //   28	49	199	java/io/IOException
    //   56	63	199	java/io/IOException
    //   76	87	199	java/io/IOException
    //   94	135	199	java/io/IOException
    //   160	175	199	java/io/IOException
    //   28	49	206	java/io/FileNotFoundException
    //   56	63	206	java/io/FileNotFoundException
    //   76	87	206	java/io/FileNotFoundException
    //   94	135	206	java/io/FileNotFoundException
    //   160	175	206	java/io/FileNotFoundException
    //   9	28	213	finally
    //   228	232	213	finally
    //   262	266	213	finally
    //   9	28	221	java/io/IOException
    //   236	240	242	finally
    //   247	251	242	finally
    //   236	240	246	java/io/IOException
    //   9	28	255	java/io/FileNotFoundException
    //   270	274	276	finally
    //   281	285	276	finally
    //   270	274	280	java/io/IOException
    //   296	301	304	finally
    //   309	313	304	finally
    //   296	301	308	java/io/IOException
  }
  
  /* Error */
  private static boolean a(VFSFile paramVFSFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_2
    //   8: new 226	java/io/RandomAccessFile
    //   11: dup
    //   12: aload_0
    //   13: invokevirtual 229	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   16: iconst_0
    //   17: invokestatic 235	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   20: ldc 237
    //   22: invokespecial 240	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 244	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   30: astore_2
    //   31: aload_2
    //   32: getstatic 250	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   35: lconst_0
    //   36: ldc2_w 251
    //   39: invokevirtual 258	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   42: astore_3
    //   43: iconst_0
    //   44: istore_1
    //   45: iload_1
    //   46: iconst_4
    //   47: if_icmpge +24 -> 71
    //   50: aload_3
    //   51: iload_1
    //   52: aload_3
    //   53: iload_1
    //   54: invokevirtual 264	java/nio/MappedByteBuffer:get	(I)B
    //   57: iconst_4
    //   58: iadd
    //   59: i2b
    //   60: invokevirtual 268	java/nio/MappedByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   63: pop
    //   64: iload_1
    //   65: iconst_1
    //   66: iadd
    //   67: istore_1
    //   68: goto -23 -> 45
    //   71: aload_3
    //   72: invokevirtual 272	java/nio/MappedByteBuffer:flip	()Ljava/nio/Buffer;
    //   75: pop
    //   76: aload_3
    //   77: invokevirtual 276	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   80: pop
    //   81: aload_3
    //   82: invokevirtual 279	java/nio/MappedByteBuffer:clear	()Ljava/nio/Buffer;
    //   85: pop
    //   86: aload_2
    //   87: invokevirtual 282	java/nio/channels/FileChannel:close	()V
    //   90: aload_0
    //   91: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   94: aload_0
    //   95: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   98: goto +12 -> 110
    //   101: astore_0
    //   102: goto +10 -> 112
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 288	java/io/IOException:printStackTrace	()V
    //   110: iconst_1
    //   111: ireturn
    //   112: aload_0
    //   113: athrow
    //   114: astore_2
    //   115: goto +87 -> 202
    //   118: astore_3
    //   119: goto +19 -> 138
    //   122: astore_3
    //   123: goto +48 -> 171
    //   126: astore_3
    //   127: aload_2
    //   128: astore_0
    //   129: aload_3
    //   130: astore_2
    //   131: goto +71 -> 202
    //   134: astore_3
    //   135: aload 4
    //   137: astore_0
    //   138: aload_0
    //   139: astore_2
    //   140: aload_3
    //   141: invokevirtual 288	java/io/IOException:printStackTrace	()V
    //   144: aload_0
    //   145: ifnull +55 -> 200
    //   148: aload_0
    //   149: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   152: iconst_0
    //   153: ireturn
    //   154: astore_0
    //   155: goto +10 -> 165
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 288	java/io/IOException:printStackTrace	()V
    //   163: iconst_0
    //   164: ireturn
    //   165: aload_0
    //   166: athrow
    //   167: astore_3
    //   168: aload 5
    //   170: astore_0
    //   171: aload_0
    //   172: astore_2
    //   173: aload_3
    //   174: invokevirtual 291	java/io/FileNotFoundException:printStackTrace	()V
    //   177: aload_0
    //   178: ifnull +22 -> 200
    //   181: aload_0
    //   182: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   185: iconst_0
    //   186: ireturn
    //   187: astore_0
    //   188: goto +10 -> 198
    //   191: astore_0
    //   192: aload_0
    //   193: invokevirtual 288	java/io/IOException:printStackTrace	()V
    //   196: iconst_0
    //   197: ireturn
    //   198: aload_0
    //   199: athrow
    //   200: iconst_0
    //   201: ireturn
    //   202: aload_0
    //   203: ifnull +24 -> 227
    //   206: aload_0
    //   207: invokevirtual 283	java/io/RandomAccessFile:close	()V
    //   210: goto +17 -> 227
    //   213: astore_0
    //   214: goto +11 -> 225
    //   217: astore_0
    //   218: aload_0
    //   219: invokevirtual 288	java/io/IOException:printStackTrace	()V
    //   222: goto +5 -> 227
    //   225: aload_0
    //   226: athrow
    //   227: goto +5 -> 232
    //   230: aload_2
    //   231: athrow
    //   232: goto -2 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	235	0	paramVFSFile	VFSFile
    //   44	24	1	i	int
    //   7	80	2	localFileChannel	java.nio.channels.FileChannel
    //   114	14	2	localObject1	Object
    //   130	101	2	localObject2	Object
    //   42	40	3	localMappedByteBuffer	java.nio.MappedByteBuffer
    //   118	1	3	localIOException1	java.io.IOException
    //   122	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   126	4	3	localObject3	Object
    //   134	7	3	localIOException2	java.io.IOException
    //   167	7	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	135	4	localObject4	Object
    //   4	165	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   94	98	101	finally
    //   106	110	101	finally
    //   94	98	105	java/io/IOException
    //   26	43	114	finally
    //   50	64	114	finally
    //   71	94	114	finally
    //   26	43	118	java/io/IOException
    //   50	64	118	java/io/IOException
    //   71	94	118	java/io/IOException
    //   26	43	122	java/io/FileNotFoundException
    //   50	64	122	java/io/FileNotFoundException
    //   71	94	122	java/io/FileNotFoundException
    //   8	26	126	finally
    //   140	144	126	finally
    //   173	177	126	finally
    //   8	26	134	java/io/IOException
    //   148	152	154	finally
    //   159	163	154	finally
    //   148	152	158	java/io/IOException
    //   8	26	167	java/io/FileNotFoundException
    //   181	185	187	finally
    //   192	196	187	finally
    //   181	185	191	java/io/IOException
    //   206	210	213	finally
    //   218	222	213	finally
    //   206	210	217	java/io/IOException
  }
  
  private static boolean a(RockDownloaderTask paramRockDownloaderTask, DownloadInfo paramDownloadInfo)
  {
    paramDownloadInfo = new VFSFile(paramDownloadInfo.q);
    paramRockDownloaderTask = new VFSFile(paramRockDownloaderTask.getDownloadInfo().getLocalPath());
    boolean bool3 = paramDownloadInfo.exists();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (a(paramDownloadInfo))
      {
        if (!paramRockDownloaderTask.exists()) {
          return paramDownloadInfo.renameTo(paramRockDownloaderTask);
        }
        bool1 = bool2;
        if (paramRockDownloaderTask.delete())
        {
          bool1 = bool2;
          if (paramDownloadInfo.renameTo(paramRockDownloaderTask)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static EntityManager b()
  {
    if (c == null) {
      c = new RockEntityManagerFactory().createEntityManager();
    }
    return c;
  }
  
  public static void b(RockDownloaderTask paramRockDownloaderTask)
  {
    if (!paramRockDownloaderTask.getDownloadInfo().verifyDate(2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
      }
      if (paramRockDownloaderTask.getQueryAPKListener() != null) {
        paramRockDownloaderTask.getQueryAPKListener().a(paramRockDownloaderTask.getDownloadInfo(), "RockDownloadInfo verifyDate fail", 10001);
      }
      return;
    }
    ThreadManagerV2.executeOnFileThread(new RockDownloader.2(paramRockDownloaderTask));
  }
  
  private static void b(RockDownloaderTask paramRockDownloaderTask, DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "onDownloadFinish: info=", paramDownloadInfo });
    }
    Object localObject = a(paramRockDownloaderTask.getRuntime().getApplication(), paramDownloadInfo.q);
    boolean bool1;
    if ((localObject != null) && (paramRockDownloaderTask.getDownloadInfo().getPackageName().equals(((RockDownloadInfo)localObject).getPackageName())))
    {
      paramRockDownloaderTask.getDownloadInfo().setRealVersionCode(((RockDownloadInfo)localObject).getRealVersionCode());
      bool1 = true;
    }
    else
    {
      if (paramDownloadInfo.q != null)
      {
        localObject = new VFSFile(paramDownloadInfo.q);
        if (((VFSFile)localObject).exists()) {
          ((VFSFile)localObject).delete();
        }
      }
      if (paramBoolean) {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), "解析APK失败或包名不匹配", 10008);
      }
      b(paramRockDownloaderTask, "0x800A1E6");
      bool1 = false;
    }
    boolean bool2;
    if (bool1)
    {
      paramRockDownloaderTask.getDownloadInfo().setLocalPath(a(paramRockDownloaderTask.getDownloadInfo()));
      bool2 = a(paramRockDownloaderTask, paramDownloadInfo);
      if ((!bool2) && (paramBoolean)) {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), "隐匿APK失败", 10007);
      }
      b(paramRockDownloaderTask, "0x800A1E6");
    }
    else
    {
      bool2 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "CheckState=", Boolean.valueOf(bool1), " hiddenState=", Boolean.valueOf(bool2) });
    }
    if ((bool1) && (bool2))
    {
      h(paramRockDownloaderTask);
      b().persistOrReplace(paramRockDownloaderTask.getDownloadInfo());
      if (paramBoolean) {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadSuccess(paramRockDownloaderTask.getDownloadInfo());
      }
      localObject = (DownloadInfo)DownloadManagerV2.a().d().remove(paramDownloadInfo.b);
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "removedDownload=", localObject });
      }
      DownloadInfoDB.a().c(paramDownloadInfo.b);
      b(paramRockDownloaderTask, "0x800A1E5");
    }
    if (paramBoolean) {
      paramRockDownloaderTask.getRockDownloadListener().onDownloadFinish(paramRockDownloaderTask.getDownloadInfo());
    }
  }
  
  private static void b(@NonNull RockDownloaderTask paramRockDownloaderTask, String paramString)
  {
    Object localObject2 = paramRockDownloaderTask.getDownloadInfo();
    Object localObject1 = new StringBuilder();
    HashMap localHashMap = new HashMap();
    if (localObject2 != null)
    {
      ((StringBuilder)localObject1).append(((RockDownloadInfo)localObject2).getBusinessName());
      ((StringBuilder)localObject1).append("&");
      ((StringBuilder)localObject1).append(((RockDownloadInfo)localObject2).getBusinessScene());
      ((StringBuilder)localObject1).append("&");
      ((StringBuilder)localObject1).append(((RockDownloadInfo)localObject2).getPackageName());
      ((StringBuilder)localObject1).append("&");
      ((StringBuilder)localObject1).append(QQDeviceInfo.getIMEI("0"));
      localHashMap.put("BusinessName", ((RockDownloadInfo)localObject2).getBusinessName());
      localHashMap.put("BusinessScene", ((RockDownloadInfo)localObject2).getBusinessScene());
      localHashMap.put("PackageName", ((RockDownloadInfo)localObject2).getPackageName());
      localHashMap.put("IMEI", QQDeviceInfo.getIMEI("0"));
      localHashMap.put("reportID", paramString);
    }
    try
    {
      if ((paramRockDownloaderTask.getRuntime() instanceof QQAppInterface))
      {
        ReportController.b((QQAppInterface)paramRockDownloaderTask.getRuntime(), "dc00898", "", ((QQAppInterface)paramRockDownloaderTask.getRuntime()).getCurrentUin(), paramString, paramString, 1, 1, "", "", ((StringBuilder)localObject1).toString(), "");
        StatisticCollector.getInstance(((QQAppInterface)paramRockDownloaderTask.getRuntime()).getApp()).collectPerformance(((QQAppInterface)paramRockDownloaderTask.getRuntime()).getCurrentUin(), "RockDownloader", true, 0L, 0L, localHashMap, "");
      }
      else if (paramRockDownloaderTask.getRuntime() != null)
      {
        localObject2 = paramRockDownloaderTask.getRuntime().getAccount();
        localObject1 = ((StringBuilder)localObject1).toString();
        try
        {
          ReportController.b(null, "dc00898", "", (String)localObject2, paramString, paramString, 1, 1, "", "", (String)localObject1, "");
          StatisticCollector.getInstance(paramRockDownloaderTask.getRuntime().getApplication()).collectPerformance(paramRockDownloaderTask.getRuntime().getAccount(), "RockDownloader", true, 0L, 0L, localHashMap, "");
        }
        catch (Throwable paramRockDownloaderTask)
        {
          break label388;
        }
      }
      else
      {
        ReportController.b(null, "dc00898", "", "", paramString, paramString, 1, 1, "", "", ((StringBuilder)localObject1).toString(), "");
        paramRockDownloaderTask = StatisticCollector.getInstance(BaseApplicationImpl.context);
        paramRockDownloaderTask.collectPerformance("", "RockDownloader", true, 0L, 0L, localHashMap, "");
      }
    }
    catch (Throwable paramRockDownloaderTask)
    {
      label388:
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, paramRockDownloaderTask, new Object[0]);
      }
    }
    if (QLog.isColorLevel())
    {
      paramRockDownloaderTask = new StringBuilder();
      paramString = localHashMap.keySet().iterator();
      while (paramString.hasNext())
      {
        localObject1 = (String)paramString.next();
        paramRockDownloaderTask.append((String)localObject1);
        paramRockDownloaderTask.append("=");
        paramRockDownloaderTask.append((String)localHashMap.get(localObject1));
        paramRockDownloaderTask.append("\n");
      }
      QLog.d("RockDownloader", 2, paramRockDownloaderTask.toString());
    }
  }
  
  private static void b(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, RockDownloaderTask paramRockDownloaderTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "onDownloadError: info=", paramDownloadInfo, " errorMsg=", paramString, " state=", Integer.valueOf(paramInt2) });
    }
    if (paramBoolean)
    {
      if (paramInt1 == 6) {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), HardCodeUtil.a(2131910968), 10010);
      } else {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), paramString, paramInt1);
      }
      paramRockDownloaderTask.getRockDownloadListener().onDownloadFinish(paramRockDownloaderTask.getDownloadInfo());
    }
    paramString = (DownloadInfo)DownloadManagerV2.a().d().remove(paramDownloadInfo.b);
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "onDownloadError removedDownload=", paramString });
    }
    DownloadInfoDB.a().c(paramDownloadInfo.b);
    b(paramRockDownloaderTask, "0x800A1E6");
  }
  
  private static void b(DownloadInfo paramDownloadInfo, RockDownloaderTask paramRockDownloaderTask)
  {
    if (paramDownloadInfo.e != null)
    {
      if (!paramDownloadInfo.e.equals(paramRockDownloaderTask.getDownloadInfo().getPackageName())) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "onDownloadPause: info=", paramDownloadInfo });
      }
    }
  }
  
  private static void b(DownloadInfo paramDownloadInfo, RockDownloaderTask paramRockDownloaderTask, boolean paramBoolean)
  {
    if (paramDownloadInfo.e != null)
    {
      if (!paramDownloadInfo.e.equals(paramRockDownloaderTask.getDownloadInfo().getPackageName())) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "onDownloadWait: info=", paramDownloadInfo });
      }
      if (paramBoolean) {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadWait(paramRockDownloaderTask.getDownloadInfo());
      }
    }
  }
  
  private static void b(DownloadInfo paramDownloadInfo, boolean paramBoolean, RockDownloaderTask paramRockDownloaderTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "onDownloadCancel: info=", paramDownloadInfo });
    }
    if (paramBoolean)
    {
      paramRockDownloaderTask.getRockDownloadListener().onDownloadCancel(paramRockDownloaderTask.getDownloadInfo());
      paramRockDownloaderTask.getRockDownloadListener().onDownloadFinish(paramRockDownloaderTask.getDownloadInfo());
    }
  }
  
  private static void b(List<DownloadInfo> paramList, boolean paramBoolean, RockDownloaderTask paramRockDownloaderTask)
  {
    if (!paramBoolean) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      if ((localDownloadInfo.e != null) && (localDownloadInfo.e.equals(paramRockDownloaderTask.getDownloadInfo().getPackageName()))) {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadProceedOn(paramRockDownloaderTask.getDownloadInfo(), localDownloadInfo.t);
      }
    }
  }
  
  private static boolean b(ServerApi.RspPreDownloadRecmd paramRspPreDownloadRecmd, RockDownloaderTask paramRockDownloaderTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { " download_url.", paramRspPreDownloadRecmd.download_url.get(), " start_time.", Integer.valueOf(paramRspPreDownloadRecmd.start_time.get()), " end_time.", Integer.valueOf(paramRspPreDownloadRecmd.end_time.get()), " interval.", Integer.valueOf(paramRspPreDownloadRecmd.interval.get()), " quota_num.", Integer.valueOf(paramRspPreDownloadRecmd.quota_num.get()), " daily_num.", Integer.valueOf(paramRspPreDownloadRecmd.daily_num.get()) });
    }
    long l = System.currentTimeMillis() / 1000L;
    if ((l >= paramRspPreDownloadRecmd.start_time.get()) && (l <= paramRspPreDownloadRecmd.end_time.get()))
    {
      paramRockDownloaderTask.getDownloadInfo().startTime = paramRspPreDownloadRecmd.start_time.get();
      paramRockDownloaderTask.getDownloadInfo().endTime = paramRspPreDownloadRecmd.end_time.get();
      if (!paramRockDownloaderTask.getDownloadInfo().getDownloadURL().equals(paramRspPreDownloadRecmd.download_url.get()))
      {
        paramRockDownloaderTask.getDownloadInfo().setDownloadURL(paramRspPreDownloadRecmd.download_url.get());
        if (QLog.isColorLevel()) {
          QLog.d("RockDownloader", 2, "checkDownloadPermission URL Error");
        }
      }
      paramRockDownloaderTask = paramRockDownloaderTask.getRuntime().getApplication().getSharedPreferences("RockDownloader", 4);
      if ((System.currentTimeMillis() - paramRockDownloaderTask.getLong("LAST_TIME", 0L)) / 1000L < paramRspPreDownloadRecmd.interval.get())
      {
        if (QLog.isColorLevel()) {
          QLog.d("RockDownloader", 2, "checkDownloadPermission interval Time Error");
        }
        return false;
      }
      String str = paramRockDownloaderTask.getString("DATE", "");
      if ((!TextUtils.isEmpty(str)) && (str.equals(DateFormat.getDateInstance().format(new Date()))) && (paramRockDownloaderTask.getInt("TIME", 0) > paramRspPreDownloadRecmd.daily_num.get()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RockDownloader", 2, "checkDownloadPermission daily number Error");
        }
        return false;
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, "checkDownloadPermission Task Time Error");
    }
    return false;
  }
  
  public static ArrayList<RockDownloadInfo> c(RockDownloaderTask paramRockDownloaderTask)
  {
    if (!paramRockDownloaderTask.getDownloadInfo().verifyDate(2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
      }
      return null;
    }
    Object localObject = b().query(RockDownloadInfo.class, true, "businessName=? AND packageName=?", new String[] { paramRockDownloaderTask.getDownloadInfo().businessName, paramRockDownloaderTask.getDownloadInfo().packageName }, null, null, null, null);
    paramRockDownloaderTask = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "result size=", Integer.valueOf(((List)localObject).size()) });
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Entity localEntity = (Entity)((Iterator)localObject).next();
        if ((localEntity instanceof RockDownloadInfo))
        {
          RockDownloadInfo localRockDownloadInfo = (RockDownloadInfo)localEntity;
          if ((!TextUtils.isEmpty(localRockDownloadInfo.localPath)) && (new VFSFile(localRockDownloadInfo.localPath).exists()))
          {
            paramRockDownloaderTask.add(localRockDownloadInfo);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("RockDownloader", 2, new Object[] { "File Removed: ", localEntity.toString() });
            }
            b().remove(localRockDownloadInfo);
          }
        }
      }
    }
    return paramRockDownloaderTask;
  }
  
  public static boolean d(RockDownloaderTask paramRockDownloaderTask)
  {
    if (!paramRockDownloaderTask.getDownloadInfo().verifyDate(4))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
      }
      return false;
    }
    VFSFile localVFSFile = new VFSFile(paramRockDownloaderTask.getDownloadInfo().localPath);
    if (!localVFSFile.exists()) {
      return false;
    }
    if (!a(paramRockDownloaderTask.getRuntime().getApplication(), localVFSFile)) {
      return false;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.putExtra("big_brother_source_key", paramRockDownloaderTask.getDownloadInfo().businessName);
    localIntent.setFlags(268435456);
    String str = AppSetting.o();
    localIntent.setDataAndType(Uri.fromFile(new File(VFSFileOp.exportExternalPath(localVFSFile.getAbsolutePath(), false))), str);
    paramRockDownloaderTask.getRuntime().getApplication().startActivity(localIntent);
    b(paramRockDownloaderTask, "0x800A1E7");
    return true;
  }
  
  public static boolean e(RockDownloaderTask paramRockDownloaderTask)
  {
    if (!paramRockDownloaderTask.getDownloadInfo().verifyDate(3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
      }
      return false;
    }
    VFSFile localVFSFile = new VFSFile(paramRockDownloaderTask.getDownloadInfo().localPath);
    if (!localVFSFile.exists()) {
      return false;
    }
    b().remove(paramRockDownloaderTask.getDownloadInfo());
    return localVFSFile.delete();
  }
  
  private static void g(RockDownloaderTask paramRockDownloaderTask)
  {
    DownloadInfo localDownloadInfo1 = new DownloadInfo();
    paramRockDownloaderTask.getDownloadInfo().setLocalPath(a(paramRockDownloaderTask.getDownloadInfo()));
    localDownloadInfo1.q = paramRockDownloaderTask.getDownloadInfo().getLocalPath();
    localDownloadInfo1.d = paramRockDownloaderTask.getDownloadInfo().getDownloadURL();
    localDownloadInfo1.e = paramRockDownloaderTask.getDownloadInfo().getPackageName();
    localDownloadInfo1.r = paramRockDownloaderTask.getDownloadInfo().getBusinessName();
    localDownloadInfo1.x = true;
    localDownloadInfo1.G = false;
    localDownloadInfo1.w = false;
    localDownloadInfo1.h = paramRockDownloaderTask.getDownloadInfo().getBusinessName();
    localDownloadInfo1.U = true;
    boolean bool;
    if (paramRockDownloaderTask.getRockDownloadListener() != null) {
      bool = true;
    } else {
      bool = false;
    }
    RockDownloader.3 local3 = new RockDownloader.3(paramRockDownloaderTask, bool);
    Iterator localIterator = DownloadManagerV2.a().d().values().iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo2 = (DownloadInfo)localIterator.next();
      if ((!TextUtils.isEmpty(localDownloadInfo2.d)) && (localDownloadInfo2.d.equals(localDownloadInfo1.d)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RockDownloader", 2, new Object[] { "find exist task, downloadInfo.urlStr=", localDownloadInfo2.d, " downloadInfo.progress=", Integer.valueOf(localDownloadInfo2.t), " downloadInfo.filePath=", localDownloadInfo2.q });
        }
        if (localDownloadInfo2.t != 100)
        {
          DownloadManagerV2.a().b(localDownloadInfo1);
          if (bool)
          {
            paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), HardCodeUtil.a(2131910965), 10011);
            paramRockDownloaderTask.getRockDownloadListener().onDownloadFinish(paramRockDownloaderTask.getDownloadInfo());
          }
          return;
        }
      }
    }
    DownloadManagerV2.a().a(local3);
    DownloadManagerV2.a().b(localDownloadInfo1);
  }
  
  private static void h(RockDownloaderTask paramRockDownloaderTask)
  {
    Object localObject = new NewIntent(paramRockDownloaderTask.getRuntime().getApplication(), RockDownloaderServlet.class);
    ((NewIntent)localObject).putExtra("BUNDLE_CMD", "QQApkSvc.update_download_count");
    try
    {
      ((NewIntent)localObject).putExtra("BUNDLE_KEY_UIN", Long.parseLong(paramRockDownloaderTask.getRuntime().getAccount()));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("RockDownloader", 2, localNumberFormatException, new Object[0]);
        ((NewIntent)localObject).putExtra("BUNDLE_KEY_UIN", 0);
      }
    }
    ((NewIntent)localObject).putExtra("BUNDLE_KEY_SOURCE", paramRockDownloaderTask.getDownloadInfo().getBusinessName());
    ((NewIntent)localObject).putExtra("BUNDLE_KEY_SCENE", paramRockDownloaderTask.getDownloadInfo().getBusinessScene());
    ((NewIntent)localObject).putExtra("BUNDLE_KEY_PKG_NAME", paramRockDownloaderTask.getDownloadInfo().getPackageName());
    paramRockDownloaderTask.getRuntime().startServlet((NewIntent)localObject);
    paramRockDownloaderTask = paramRockDownloaderTask.getRuntime().getApplication().getSharedPreferences("RockDownloader", 4);
    localObject = paramRockDownloaderTask.edit();
    String str = paramRockDownloaderTask.getString("DATE", "");
    if ((!TextUtils.isEmpty(str)) && (str.equals(DateFormat.getDateInstance().format(new Date()))))
    {
      ((SharedPreferences.Editor)localObject).putInt("TIME", paramRockDownloaderTask.getInt("TIME", 0) + 1);
    }
    else
    {
      ((SharedPreferences.Editor)localObject).putString("DATA", DateFormat.getDateInstance().format(new Date()));
      ((SharedPreferences.Editor)localObject).putInt("TIME", 1);
    }
    ((SharedPreferences.Editor)localObject).putLong("LAST_TIME", System.currentTimeMillis());
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloader
 * JD-Core Version:    0.7.0.1
 */