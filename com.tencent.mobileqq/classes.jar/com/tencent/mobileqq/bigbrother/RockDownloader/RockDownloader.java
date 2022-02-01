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
  private static EntityManager a;
  public static final String a;
  private static String b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".Rock/");
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
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
  
  public static EntityManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
      jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = new RockEntityManagerFactory().createEntityManager();
    }
    return jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  }
  
  public static String a()
  {
    if (jdField_b_of_type_JavaLangString == null)
    {
      jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
      VFSFile localVFSFile = new VFSFile(jdField_b_of_type_JavaLangString);
      if (!localVFSFile.exists()) {
        localVFSFile.mkdirs();
      }
    }
    return jdField_b_of_type_JavaLangString;
  }
  
  private static String a(RockDownloadInfo paramRockDownloadInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(paramRockDownloadInfo.getDownloadFileNameMD5());
    return localStringBuilder.toString();
  }
  
  public static ArrayList<RockDownloadInfo> a(RockDownloaderTask paramRockDownloaderTask)
  {
    if (!paramRockDownloaderTask.getDownloadInfo().verifyDate(2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
      }
      return null;
    }
    Object localObject = a().query(RockDownloadInfo.class, true, "businessName=? AND packageName=?", new String[] { paramRockDownloaderTask.getDownloadInfo().businessName, paramRockDownloaderTask.getDownloadInfo().packageName }, null, null, null, null);
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
            a().remove(localRockDownloadInfo);
          }
        }
      }
    }
    return paramRockDownloaderTask;
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
    //   9: new 302	java/io/RandomAccessFile
    //   12: dup
    //   13: aload_1
    //   14: invokevirtual 305	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   17: iconst_0
    //   18: invokestatic 311	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   21: ldc_w 313
    //   24: invokespecial 316	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 320	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   34: astore 4
    //   36: aload 4
    //   38: getstatic 326	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   41: lconst_0
    //   42: ldc2_w 327
    //   45: invokevirtual 334	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   48: astore 6
    //   50: iconst_0
    //   51: istore_2
    //   52: iload_2
    //   53: iconst_4
    //   54: if_icmpge +41 -> 95
    //   57: aload 6
    //   59: iload_2
    //   60: invokevirtual 340	java/nio/MappedByteBuffer:get	(I)B
    //   63: istore_3
    //   64: iload_2
    //   65: ifne +12 -> 77
    //   68: iload_3
    //   69: bipush 80
    //   71: if_icmpne +6 -> 77
    //   74: goto +21 -> 95
    //   77: aload 6
    //   79: iload_2
    //   80: iload_3
    //   81: iconst_4
    //   82: isub
    //   83: i2b
    //   84: invokevirtual 344	java/nio/MappedByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   87: pop
    //   88: iload_2
    //   89: iconst_1
    //   90: iadd
    //   91: istore_2
    //   92: goto -40 -> 52
    //   95: aload 6
    //   97: invokevirtual 348	java/nio/MappedByteBuffer:flip	()Ljava/nio/Buffer;
    //   100: pop
    //   101: aload 6
    //   103: invokevirtual 352	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   106: pop
    //   107: aload 6
    //   109: invokevirtual 355	java/nio/MappedByteBuffer:clear	()Ljava/nio/Buffer;
    //   112: pop
    //   113: aload 4
    //   115: invokevirtual 358	java/nio/channels/FileChannel:close	()V
    //   118: aload 5
    //   120: invokevirtual 359	java/io/RandomAccessFile:close	()V
    //   123: aload_0
    //   124: aload_1
    //   125: invokevirtual 305	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   128: iconst_0
    //   129: invokestatic 311	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   132: invokestatic 361	com/tencent/mobileqq/bigbrother/RockDownloader/RockDownloader:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/data/RockDownloadInfo;
    //   135: astore_0
    //   136: aload_0
    //   137: ifnull +24 -> 161
    //   140: aload 5
    //   142: invokevirtual 359	java/io/RandomAccessFile:close	()V
    //   145: goto +12 -> 157
    //   148: astore_0
    //   149: goto +10 -> 159
    //   152: astore_0
    //   153: aload_0
    //   154: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   157: iconst_1
    //   158: ireturn
    //   159: aload_0
    //   160: athrow
    //   161: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +12 -> 176
    //   167: ldc 125
    //   169: iconst_2
    //   170: ldc_w 366
    //   173: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload 5
    //   178: invokevirtual 359	java/io/RandomAccessFile:close	()V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_0
    //   184: goto +10 -> 194
    //   187: astore_0
    //   188: aload_0
    //   189: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   192: iconst_0
    //   193: ireturn
    //   194: aload_0
    //   195: athrow
    //   196: astore_0
    //   197: goto +95 -> 292
    //   200: astore_1
    //   201: aload 5
    //   203: astore_0
    //   204: goto +22 -> 226
    //   207: astore_1
    //   208: aload 5
    //   210: astore_0
    //   211: goto +49 -> 260
    //   214: astore_0
    //   215: aload 4
    //   217: astore 5
    //   219: goto +73 -> 292
    //   222: astore_1
    //   223: aload 6
    //   225: astore_0
    //   226: aload_0
    //   227: astore 4
    //   229: aload_1
    //   230: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   233: aload_0
    //   234: ifnull +56 -> 290
    //   237: aload_0
    //   238: invokevirtual 359	java/io/RandomAccessFile:close	()V
    //   241: iconst_0
    //   242: ireturn
    //   243: astore_0
    //   244: goto +10 -> 254
    //   247: astore_0
    //   248: aload_0
    //   249: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   252: iconst_0
    //   253: ireturn
    //   254: aload_0
    //   255: athrow
    //   256: astore_1
    //   257: aload 7
    //   259: astore_0
    //   260: aload_0
    //   261: astore 4
    //   263: aload_1
    //   264: invokevirtual 367	java/io/FileNotFoundException:printStackTrace	()V
    //   267: aload_0
    //   268: ifnull +22 -> 290
    //   271: aload_0
    //   272: invokevirtual 359	java/io/RandomAccessFile:close	()V
    //   275: iconst_0
    //   276: ireturn
    //   277: astore_0
    //   278: goto +10 -> 288
    //   281: astore_0
    //   282: aload_0
    //   283: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   286: iconst_0
    //   287: ireturn
    //   288: aload_0
    //   289: athrow
    //   290: iconst_0
    //   291: ireturn
    //   292: aload 5
    //   294: ifnull +25 -> 319
    //   297: aload 5
    //   299: invokevirtual 359	java/io/RandomAccessFile:close	()V
    //   302: goto +17 -> 319
    //   305: astore_0
    //   306: goto +11 -> 317
    //   309: astore_1
    //   310: aload_1
    //   311: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   314: goto +5 -> 319
    //   317: aload_0
    //   318: athrow
    //   319: goto +5 -> 324
    //   322: aload_0
    //   323: athrow
    //   324: goto -2 -> 322
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	paramContext	Context
    //   0	327	1	paramVFSFile	VFSFile
    //   51	41	2	i	int
    //   63	20	3	j	int
    //   7	255	4	localObject1	Object
    //   27	271	5	localObject2	Object
    //   1	223	6	localMappedByteBuffer	java.nio.MappedByteBuffer
    //   4	254	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   140	145	148	finally
    //   153	157	148	finally
    //   140	145	152	java/io/IOException
    //   176	181	183	finally
    //   188	192	183	finally
    //   176	181	187	java/io/IOException
    //   29	50	196	finally
    //   57	64	196	finally
    //   77	88	196	finally
    //   95	136	196	finally
    //   161	176	196	finally
    //   29	50	200	java/io/IOException
    //   57	64	200	java/io/IOException
    //   77	88	200	java/io/IOException
    //   95	136	200	java/io/IOException
    //   161	176	200	java/io/IOException
    //   29	50	207	java/io/FileNotFoundException
    //   57	64	207	java/io/FileNotFoundException
    //   77	88	207	java/io/FileNotFoundException
    //   95	136	207	java/io/FileNotFoundException
    //   161	176	207	java/io/FileNotFoundException
    //   9	29	214	finally
    //   229	233	214	finally
    //   263	267	214	finally
    //   9	29	222	java/io/IOException
    //   237	241	243	finally
    //   248	252	243	finally
    //   237	241	247	java/io/IOException
    //   9	29	256	java/io/FileNotFoundException
    //   271	275	277	finally
    //   282	286	277	finally
    //   271	275	281	java/io/IOException
    //   297	302	305	finally
    //   310	314	305	finally
    //   297	302	309	java/io/IOException
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
    //   8: new 302	java/io/RandomAccessFile
    //   11: dup
    //   12: aload_0
    //   13: invokevirtual 305	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   16: iconst_0
    //   17: invokestatic 311	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   20: ldc_w 313
    //   23: invokespecial 316	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: astore_0
    //   27: aload_0
    //   28: invokevirtual 320	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   31: astore_2
    //   32: aload_2
    //   33: getstatic 326	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   36: lconst_0
    //   37: ldc2_w 327
    //   40: invokevirtual 334	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   43: astore_3
    //   44: iconst_0
    //   45: istore_1
    //   46: iload_1
    //   47: iconst_4
    //   48: if_icmpge +24 -> 72
    //   51: aload_3
    //   52: iload_1
    //   53: aload_3
    //   54: iload_1
    //   55: invokevirtual 340	java/nio/MappedByteBuffer:get	(I)B
    //   58: iconst_4
    //   59: iadd
    //   60: i2b
    //   61: invokevirtual 344	java/nio/MappedByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   64: pop
    //   65: iload_1
    //   66: iconst_1
    //   67: iadd
    //   68: istore_1
    //   69: goto -23 -> 46
    //   72: aload_3
    //   73: invokevirtual 348	java/nio/MappedByteBuffer:flip	()Ljava/nio/Buffer;
    //   76: pop
    //   77: aload_3
    //   78: invokevirtual 352	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   81: pop
    //   82: aload_3
    //   83: invokevirtual 355	java/nio/MappedByteBuffer:clear	()Ljava/nio/Buffer;
    //   86: pop
    //   87: aload_2
    //   88: invokevirtual 358	java/nio/channels/FileChannel:close	()V
    //   91: aload_0
    //   92: invokevirtual 359	java/io/RandomAccessFile:close	()V
    //   95: aload_0
    //   96: invokevirtual 359	java/io/RandomAccessFile:close	()V
    //   99: goto +12 -> 111
    //   102: astore_0
    //   103: goto +10 -> 113
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   111: iconst_1
    //   112: ireturn
    //   113: aload_0
    //   114: athrow
    //   115: astore_2
    //   116: goto +87 -> 203
    //   119: astore_3
    //   120: goto +19 -> 139
    //   123: astore_3
    //   124: goto +48 -> 172
    //   127: astore_3
    //   128: aload_2
    //   129: astore_0
    //   130: aload_3
    //   131: astore_2
    //   132: goto +71 -> 203
    //   135: astore_3
    //   136: aload 4
    //   138: astore_0
    //   139: aload_0
    //   140: astore_2
    //   141: aload_3
    //   142: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   145: aload_0
    //   146: ifnull +55 -> 201
    //   149: aload_0
    //   150: invokevirtual 359	java/io/RandomAccessFile:close	()V
    //   153: iconst_0
    //   154: ireturn
    //   155: astore_0
    //   156: goto +10 -> 166
    //   159: astore_0
    //   160: aload_0
    //   161: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: aload_0
    //   167: athrow
    //   168: astore_3
    //   169: aload 5
    //   171: astore_0
    //   172: aload_0
    //   173: astore_2
    //   174: aload_3
    //   175: invokevirtual 367	java/io/FileNotFoundException:printStackTrace	()V
    //   178: aload_0
    //   179: ifnull +22 -> 201
    //   182: aload_0
    //   183: invokevirtual 359	java/io/RandomAccessFile:close	()V
    //   186: iconst_0
    //   187: ireturn
    //   188: astore_0
    //   189: goto +10 -> 199
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   197: iconst_0
    //   198: ireturn
    //   199: aload_0
    //   200: athrow
    //   201: iconst_0
    //   202: ireturn
    //   203: aload_0
    //   204: ifnull +24 -> 228
    //   207: aload_0
    //   208: invokevirtual 359	java/io/RandomAccessFile:close	()V
    //   211: goto +17 -> 228
    //   214: astore_0
    //   215: goto +11 -> 226
    //   218: astore_0
    //   219: aload_0
    //   220: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   223: goto +5 -> 228
    //   226: aload_0
    //   227: athrow
    //   228: goto +5 -> 233
    //   231: aload_2
    //   232: athrow
    //   233: goto -2 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramVFSFile	VFSFile
    //   45	24	1	i	int
    //   7	81	2	localFileChannel	java.nio.channels.FileChannel
    //   115	14	2	localObject1	Object
    //   131	101	2	localObject2	Object
    //   43	40	3	localMappedByteBuffer	java.nio.MappedByteBuffer
    //   119	1	3	localIOException1	java.io.IOException
    //   123	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   127	4	3	localObject3	Object
    //   135	7	3	localIOException2	java.io.IOException
    //   168	7	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	136	4	localObject4	Object
    //   4	166	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   95	99	102	finally
    //   107	111	102	finally
    //   95	99	106	java/io/IOException
    //   27	44	115	finally
    //   51	65	115	finally
    //   72	95	115	finally
    //   27	44	119	java/io/IOException
    //   51	65	119	java/io/IOException
    //   72	95	119	java/io/IOException
    //   27	44	123	java/io/FileNotFoundException
    //   51	65	123	java/io/FileNotFoundException
    //   72	95	123	java/io/FileNotFoundException
    //   8	27	127	finally
    //   141	145	127	finally
    //   174	178	127	finally
    //   8	27	135	java/io/IOException
    //   149	153	155	finally
    //   160	164	155	finally
    //   149	153	159	java/io/IOException
    //   8	27	168	java/io/FileNotFoundException
    //   182	186	188	finally
    //   193	197	188	finally
    //   182	186	192	java/io/IOException
    //   207	211	214	finally
    //   219	223	214	finally
    //   207	211	218	java/io/IOException
  }
  
  public static boolean a(RockDownloaderTask paramRockDownloaderTask)
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
    String str = AppSetting.h();
    localIntent.setDataAndType(Uri.fromFile(new File(VFSFileOp.exportExternalPath(localVFSFile.getAbsolutePath(), false))), str);
    paramRockDownloaderTask.getRuntime().getApplication().startActivity(localIntent);
    b(paramRockDownloaderTask, "0x800A1E7");
    return true;
  }
  
  private static boolean a(RockDownloaderTask paramRockDownloaderTask, DownloadInfo paramDownloadInfo)
  {
    paramDownloadInfo = new VFSFile(paramDownloadInfo.l);
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
    Object localObject = a(paramRockDownloaderTask.getRuntime().getApplication(), paramDownloadInfo.l);
    boolean bool1;
    if ((localObject != null) && (paramRockDownloaderTask.getDownloadInfo().getPackageName().equals(((RockDownloadInfo)localObject).getPackageName())))
    {
      paramRockDownloaderTask.getDownloadInfo().setRealVersionCode(((RockDownloadInfo)localObject).getRealVersionCode());
      bool1 = true;
    }
    else
    {
      if (paramDownloadInfo.l != null)
      {
        localObject = new VFSFile(paramDownloadInfo.l);
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
      e(paramRockDownloaderTask);
      a().persistOrReplace(paramRockDownloaderTask.getDownloadInfo());
      if (paramBoolean) {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadSuccess(paramRockDownloaderTask.getDownloadInfo());
      }
      localObject = (DownloadInfo)DownloadManagerV2.a().a().remove(paramDownloadInfo.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "removedDownload=", localObject });
      }
      DownloadInfoDB.a().a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
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
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), HardCodeUtil.a(2131713417), 10010);
      } else {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), paramString, paramInt1);
      }
      paramRockDownloaderTask.getRockDownloadListener().onDownloadFinish(paramRockDownloaderTask.getDownloadInfo());
    }
    paramString = (DownloadInfo)DownloadManagerV2.a().a().remove(paramDownloadInfo.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "onDownloadError removedDownload=", paramString });
    }
    DownloadInfoDB.a().a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
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
        paramRockDownloaderTask.getRockDownloadListener().onDownloadProceedOn(paramRockDownloaderTask.getDownloadInfo(), localDownloadInfo.jdField_f_of_type_Int);
      }
    }
  }
  
  public static boolean b(RockDownloaderTask paramRockDownloaderTask)
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
    a().remove(paramRockDownloaderTask.getDownloadInfo());
    return localVFSFile.delete();
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
  
  private static void d(RockDownloaderTask paramRockDownloaderTask)
  {
    DownloadInfo localDownloadInfo1 = new DownloadInfo();
    paramRockDownloaderTask.getDownloadInfo().setLocalPath(a(paramRockDownloaderTask.getDownloadInfo()));
    localDownloadInfo1.l = paramRockDownloaderTask.getDownloadInfo().getLocalPath();
    localDownloadInfo1.jdField_d_of_type_JavaLangString = paramRockDownloaderTask.getDownloadInfo().getDownloadURL();
    localDownloadInfo1.e = paramRockDownloaderTask.getDownloadInfo().getPackageName();
    localDownloadInfo1.m = paramRockDownloaderTask.getDownloadInfo().getBusinessName();
    localDownloadInfo1.jdField_b_of_type_Boolean = true;
    localDownloadInfo1.jdField_d_of_type_Boolean = false;
    localDownloadInfo1.a = false;
    localDownloadInfo1.h = paramRockDownloaderTask.getDownloadInfo().getBusinessName();
    localDownloadInfo1.jdField_f_of_type_Boolean = true;
    boolean bool;
    if (paramRockDownloaderTask.getRockDownloadListener() != null) {
      bool = true;
    } else {
      bool = false;
    }
    RockDownloader.3 local3 = new RockDownloader.3(paramRockDownloaderTask, bool);
    Iterator localIterator = DownloadManagerV2.a().a().values().iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo2 = (DownloadInfo)localIterator.next();
      if ((!TextUtils.isEmpty(localDownloadInfo2.jdField_d_of_type_JavaLangString)) && (localDownloadInfo2.jdField_d_of_type_JavaLangString.equals(localDownloadInfo1.jdField_d_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RockDownloader", 2, new Object[] { "find exist task, downloadInfo.urlStr=", localDownloadInfo2.jdField_d_of_type_JavaLangString, " downloadInfo.progress=", Integer.valueOf(localDownloadInfo2.jdField_f_of_type_Int), " downloadInfo.filePath=", localDownloadInfo2.l });
        }
        if (localDownloadInfo2.jdField_f_of_type_Int != 100)
        {
          DownloadManagerV2.a().b(localDownloadInfo1);
          if (bool)
          {
            paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), HardCodeUtil.a(2131713414), 10011);
            paramRockDownloaderTask.getRockDownloadListener().onDownloadFinish(paramRockDownloaderTask.getDownloadInfo());
          }
          return;
        }
      }
    }
    DownloadManagerV2.a().a(local3);
    DownloadManagerV2.a().b(localDownloadInfo1);
  }
  
  private static void e(RockDownloaderTask paramRockDownloaderTask)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloader
 * JD-Core Version:    0.7.0.1
 */