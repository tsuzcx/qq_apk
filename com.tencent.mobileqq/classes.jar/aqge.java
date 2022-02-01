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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloader.2;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderTask;
import com.tencent.mobileqq.bigbrother.ServerApi.RspPreDownloadRecmd;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
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

public class aqge
{
  private static EntityManager a;
  public static final String a;
  private static String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".Rock/");
  }
  
  public static RockDownloadInfo a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 16384);
    } while (paramContext == null);
    paramString = new RockDownloadInfo();
    paramString.setPackageName(paramContext.packageName);
    paramString.setRealVersionCode(paramContext.versionCode);
    return paramString;
  }
  
  public static EntityManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) {
      jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = new aqgl().createEntityManager();
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
    return a() + paramRockDownloadInfo.getDownloadFileNameMD5();
  }
  
  public static ArrayList<RockDownloadInfo> a(RockDownloaderTask paramRockDownloaderTask)
  {
    ArrayList localArrayList = null;
    if (!paramRockDownloaderTask.getDownloadInfo().verifyDate(2))
    {
      paramRockDownloaderTask = localArrayList;
      if (QLog.isColorLevel())
      {
        QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
        paramRockDownloaderTask = localArrayList;
      }
    }
    do
    {
      do
      {
        return paramRockDownloaderTask;
        localObject = a().query(RockDownloadInfo.class, true, "businessName=? AND packageName=?", new String[] { paramRockDownloaderTask.getDownloadInfo().businessName, paramRockDownloaderTask.getDownloadInfo().packageName }, null, null, null, null);
        localArrayList = new ArrayList();
        paramRockDownloaderTask = localArrayList;
      } while (localObject == null);
      paramRockDownloaderTask = localArrayList;
    } while (((List)localObject).size() <= 0);
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { "result size=", Integer.valueOf(((List)localObject).size()) });
    }
    Object localObject = ((List)localObject).iterator();
    for (;;)
    {
      paramRockDownloaderTask = localArrayList;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramRockDownloaderTask = (Entity)((Iterator)localObject).next();
      if ((paramRockDownloaderTask instanceof RockDownloadInfo))
      {
        RockDownloadInfo localRockDownloadInfo = (RockDownloadInfo)paramRockDownloaderTask;
        if ((!TextUtils.isEmpty(localRockDownloadInfo.localPath)) && (new VFSFile(localRockDownloadInfo.localPath).exists()))
        {
          localArrayList.add(localRockDownloadInfo);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("RockDownloader", 2, new Object[] { "File Removed: ", paramRockDownloaderTask.toString() });
          }
          a().remove(localRockDownloadInfo);
        }
      }
    }
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
    NewIntent localNewIntent = new NewIntent(paramRockDownloaderTask.getRuntime().getApplication(), aqgk.class);
    localNewIntent.putExtra("BUNDLE_CMD", "QQApkSvc.pre_download_apk");
    localNewIntent.putExtra("BUNDLE_KEY_UIN", paramRockDownloaderTask.getRuntime().getLongAccountUin());
    localNewIntent.putExtra("BUNDLE_KEY_SOURCE", paramRockDownloaderTask.getDownloadInfo().getBusinessName());
    localNewIntent.putExtra("BUNDLE_KEY_SCENE", paramRockDownloaderTask.getDownloadInfo().getBusinessScene());
    localNewIntent.putExtra("BUNDLE_KEY_PKG_NAME", paramRockDownloaderTask.getDownloadInfo().getPackageName());
    localNewIntent.setObserver(new aqgf(paramRockDownloaderTask));
    paramRockDownloaderTask.getRuntime().startServlet(localNewIntent);
    b(paramRockDownloaderTask, "0x800A1E8");
  }
  
  /* Error */
  private static boolean a(Context paramContext, VFSFile paramVFSFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 301	java/io/RandomAccessFile
    //   6: dup
    //   7: aload_1
    //   8: invokevirtual 304	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   11: iconst_0
    //   12: invokestatic 310	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   15: ldc_w 312
    //   18: invokespecial 315	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: astore 5
    //   23: aload 5
    //   25: astore 6
    //   27: aload 5
    //   29: invokevirtual 319	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   32: astore 7
    //   34: aload 5
    //   36: astore 6
    //   38: aload 7
    //   40: getstatic 325	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   43: lconst_0
    //   44: ldc2_w 326
    //   47: invokevirtual 333	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   50: astore 8
    //   52: iconst_0
    //   53: istore_3
    //   54: iload_3
    //   55: iconst_4
    //   56: if_icmpge +26 -> 82
    //   59: aload 5
    //   61: astore 6
    //   63: aload 8
    //   65: iload_3
    //   66: invokevirtual 339	java/nio/MappedByteBuffer:get	(I)B
    //   69: istore 4
    //   71: iload_3
    //   72: ifne +91 -> 163
    //   75: iload 4
    //   77: bipush 80
    //   79: if_icmpne +84 -> 163
    //   82: aload 5
    //   84: astore 6
    //   86: aload 8
    //   88: invokevirtual 343	java/nio/MappedByteBuffer:flip	()Ljava/nio/Buffer;
    //   91: pop
    //   92: aload 5
    //   94: astore 6
    //   96: aload 8
    //   98: invokevirtual 347	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   101: pop
    //   102: aload 5
    //   104: astore 6
    //   106: aload 8
    //   108: invokevirtual 350	java/nio/MappedByteBuffer:clear	()Ljava/nio/Buffer;
    //   111: pop
    //   112: aload 5
    //   114: astore 6
    //   116: aload 7
    //   118: invokevirtual 353	java/nio/channels/FileChannel:close	()V
    //   121: aload 5
    //   123: astore 6
    //   125: aload 5
    //   127: invokevirtual 354	java/io/RandomAccessFile:close	()V
    //   130: aload 5
    //   132: astore 6
    //   134: aload_0
    //   135: aload_1
    //   136: invokevirtual 304	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   139: iconst_0
    //   140: invokestatic 310	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   143: invokestatic 356	aqge:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/data/RockDownloadInfo;
    //   146: astore_0
    //   147: aload_0
    //   148: ifnull +50 -> 198
    //   151: aload 5
    //   153: ifnull +8 -> 161
    //   156: aload 5
    //   158: invokevirtual 354	java/io/RandomAccessFile:close	()V
    //   161: iconst_1
    //   162: ireturn
    //   163: iload 4
    //   165: iconst_4
    //   166: isub
    //   167: i2b
    //   168: istore_2
    //   169: aload 5
    //   171: astore 6
    //   173: aload 8
    //   175: iload_3
    //   176: iload_2
    //   177: invokevirtual 360	java/nio/MappedByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   180: pop
    //   181: iload_3
    //   182: iconst_1
    //   183: iadd
    //   184: istore_3
    //   185: goto -131 -> 54
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   193: iconst_1
    //   194: ireturn
    //   195: astore_0
    //   196: aload_0
    //   197: athrow
    //   198: aload 5
    //   200: astore 6
    //   202: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +16 -> 221
    //   208: aload 5
    //   210: astore 6
    //   212: ldc 124
    //   214: iconst_2
    //   215: ldc_w 365
    //   218: invokestatic 130	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload 5
    //   223: ifnull +8 -> 231
    //   226: aload 5
    //   228: invokevirtual 354	java/io/RandomAccessFile:close	()V
    //   231: iconst_0
    //   232: ireturn
    //   233: astore_0
    //   234: aload_0
    //   235: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   238: goto -7 -> 231
    //   241: astore_0
    //   242: aload_0
    //   243: athrow
    //   244: astore_1
    //   245: aload 6
    //   247: astore_0
    //   248: aload_1
    //   249: invokevirtual 366	java/io/FileNotFoundException:printStackTrace	()V
    //   252: aload_0
    //   253: ifnull +7 -> 260
    //   256: aload_0
    //   257: invokevirtual 354	java/io/RandomAccessFile:close	()V
    //   260: iconst_0
    //   261: ireturn
    //   262: astore_0
    //   263: aload_0
    //   264: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   267: goto -7 -> 260
    //   270: astore_0
    //   271: aload_0
    //   272: athrow
    //   273: astore_0
    //   274: aconst_null
    //   275: astore 5
    //   277: aload 5
    //   279: astore 6
    //   281: aload_0
    //   282: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   285: aload 5
    //   287: ifnull -27 -> 260
    //   290: aload 5
    //   292: invokevirtual 354	java/io/RandomAccessFile:close	()V
    //   295: goto -35 -> 260
    //   298: astore_0
    //   299: aload_0
    //   300: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   303: goto -43 -> 260
    //   306: astore_0
    //   307: aload_0
    //   308: athrow
    //   309: astore_0
    //   310: aconst_null
    //   311: astore 6
    //   313: aload 6
    //   315: ifnull +8 -> 323
    //   318: aload 6
    //   320: invokevirtual 354	java/io/RandomAccessFile:close	()V
    //   323: aload_0
    //   324: athrow
    //   325: astore_1
    //   326: aload_1
    //   327: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   330: goto -7 -> 323
    //   333: astore_0
    //   334: aload_0
    //   335: athrow
    //   336: astore_0
    //   337: goto -24 -> 313
    //   340: astore_1
    //   341: aload_0
    //   342: astore 6
    //   344: aload_1
    //   345: astore_0
    //   346: goto -33 -> 313
    //   349: astore_0
    //   350: goto -73 -> 277
    //   353: astore_1
    //   354: aload 5
    //   356: astore_0
    //   357: goto -109 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	paramContext	Context
    //   0	360	1	paramVFSFile	VFSFile
    //   168	9	2	b1	byte
    //   53	132	3	i	int
    //   69	98	4	j	int
    //   21	334	5	localRandomAccessFile	java.io.RandomAccessFile
    //   1	342	6	localObject	Object
    //   32	85	7	localFileChannel	java.nio.channels.FileChannel
    //   50	124	8	localMappedByteBuffer	java.nio.MappedByteBuffer
    // Exception table:
    //   from	to	target	type
    //   156	161	188	java/io/IOException
    //   156	161	195	finally
    //   189	193	195	finally
    //   226	231	233	java/io/IOException
    //   226	231	241	finally
    //   234	238	241	finally
    //   3	23	244	java/io/FileNotFoundException
    //   256	260	262	java/io/IOException
    //   256	260	270	finally
    //   263	267	270	finally
    //   3	23	273	java/io/IOException
    //   290	295	298	java/io/IOException
    //   290	295	306	finally
    //   299	303	306	finally
    //   3	23	309	finally
    //   318	323	325	java/io/IOException
    //   318	323	333	finally
    //   326	330	333	finally
    //   27	34	336	finally
    //   38	52	336	finally
    //   63	71	336	finally
    //   86	92	336	finally
    //   96	102	336	finally
    //   106	112	336	finally
    //   116	121	336	finally
    //   125	130	336	finally
    //   134	147	336	finally
    //   173	181	336	finally
    //   202	208	336	finally
    //   212	221	336	finally
    //   281	285	336	finally
    //   248	252	340	finally
    //   27	34	349	java/io/IOException
    //   38	52	349	java/io/IOException
    //   63	71	349	java/io/IOException
    //   86	92	349	java/io/IOException
    //   96	102	349	java/io/IOException
    //   106	112	349	java/io/IOException
    //   116	121	349	java/io/IOException
    //   125	130	349	java/io/IOException
    //   134	147	349	java/io/IOException
    //   173	181	349	java/io/IOException
    //   202	208	349	java/io/IOException
    //   212	221	349	java/io/IOException
    //   27	34	353	java/io/FileNotFoundException
    //   38	52	353	java/io/FileNotFoundException
    //   63	71	353	java/io/FileNotFoundException
    //   86	92	353	java/io/FileNotFoundException
    //   96	102	353	java/io/FileNotFoundException
    //   106	112	353	java/io/FileNotFoundException
    //   116	121	353	java/io/FileNotFoundException
    //   125	130	353	java/io/FileNotFoundException
    //   134	147	353	java/io/FileNotFoundException
    //   173	181	353	java/io/FileNotFoundException
    //   202	208	353	java/io/FileNotFoundException
    //   212	221	353	java/io/FileNotFoundException
  }
  
  /* Error */
  private static boolean a(VFSFile paramVFSFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 301	java/io/RandomAccessFile
    //   5: dup
    //   6: aload_0
    //   7: invokevirtual 304	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   10: iconst_0
    //   11: invokestatic 310	com/tencent/mm/vfs/VFSFileOp:exportExternalPath	(Ljava/lang/String;Z)Ljava/lang/String;
    //   14: ldc_w 312
    //   17: invokespecial 315	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: astore_0
    //   21: aload_0
    //   22: astore_2
    //   23: aload_0
    //   24: invokevirtual 319	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   27: astore_3
    //   28: aload_0
    //   29: astore_2
    //   30: aload_3
    //   31: getstatic 325	java/nio/channels/FileChannel$MapMode:READ_WRITE	Ljava/nio/channels/FileChannel$MapMode;
    //   34: lconst_0
    //   35: ldc2_w 326
    //   38: invokevirtual 333	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   41: astore 4
    //   43: iconst_0
    //   44: istore_1
    //   45: iload_1
    //   46: iconst_4
    //   47: if_icmpge +28 -> 75
    //   50: aload_0
    //   51: astore_2
    //   52: aload 4
    //   54: iload_1
    //   55: aload 4
    //   57: iload_1
    //   58: invokevirtual 339	java/nio/MappedByteBuffer:get	(I)B
    //   61: iconst_4
    //   62: iadd
    //   63: i2b
    //   64: invokevirtual 360	java/nio/MappedByteBuffer:put	(IB)Ljava/nio/ByteBuffer;
    //   67: pop
    //   68: iload_1
    //   69: iconst_1
    //   70: iadd
    //   71: istore_1
    //   72: goto -27 -> 45
    //   75: aload_0
    //   76: astore_2
    //   77: aload 4
    //   79: invokevirtual 343	java/nio/MappedByteBuffer:flip	()Ljava/nio/Buffer;
    //   82: pop
    //   83: aload_0
    //   84: astore_2
    //   85: aload 4
    //   87: invokevirtual 347	java/nio/MappedByteBuffer:force	()Ljava/nio/MappedByteBuffer;
    //   90: pop
    //   91: aload_0
    //   92: astore_2
    //   93: aload 4
    //   95: invokevirtual 350	java/nio/MappedByteBuffer:clear	()Ljava/nio/Buffer;
    //   98: pop
    //   99: aload_0
    //   100: astore_2
    //   101: aload_3
    //   102: invokevirtual 353	java/nio/channels/FileChannel:close	()V
    //   105: aload_0
    //   106: astore_2
    //   107: aload_0
    //   108: invokevirtual 354	java/io/RandomAccessFile:close	()V
    //   111: aload_0
    //   112: ifnull +7 -> 119
    //   115: aload_0
    //   116: invokevirtual 354	java/io/RandomAccessFile:close	()V
    //   119: iconst_1
    //   120: ireturn
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   126: iconst_1
    //   127: ireturn
    //   128: astore_0
    //   129: aload_0
    //   130: athrow
    //   131: astore_3
    //   132: aload_2
    //   133: astore_0
    //   134: aload_3
    //   135: astore_2
    //   136: aload_2
    //   137: invokevirtual 366	java/io/FileNotFoundException:printStackTrace	()V
    //   140: aload_0
    //   141: ifnull +7 -> 148
    //   144: aload_0
    //   145: invokevirtual 354	java/io/RandomAccessFile:close	()V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   155: goto -7 -> 148
    //   158: astore_0
    //   159: aload_0
    //   160: athrow
    //   161: astore_3
    //   162: aconst_null
    //   163: astore_0
    //   164: aload_0
    //   165: astore_2
    //   166: aload_3
    //   167: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   170: aload_0
    //   171: ifnull -23 -> 148
    //   174: aload_0
    //   175: invokevirtual 354	java/io/RandomAccessFile:close	()V
    //   178: goto -30 -> 148
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   186: goto -38 -> 148
    //   189: astore_0
    //   190: aload_0
    //   191: athrow
    //   192: astore_0
    //   193: aconst_null
    //   194: astore_2
    //   195: aload_2
    //   196: ifnull +7 -> 203
    //   199: aload_2
    //   200: invokevirtual 354	java/io/RandomAccessFile:close	()V
    //   203: aload_0
    //   204: athrow
    //   205: astore_2
    //   206: aload_2
    //   207: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   210: goto -7 -> 203
    //   213: astore_0
    //   214: aload_0
    //   215: athrow
    //   216: astore_0
    //   217: goto -22 -> 195
    //   220: astore_3
    //   221: aload_0
    //   222: astore_2
    //   223: aload_3
    //   224: astore_0
    //   225: goto -30 -> 195
    //   228: astore_3
    //   229: goto -65 -> 164
    //   232: astore_2
    //   233: goto -97 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramVFSFile	VFSFile
    //   44	28	1	i	int
    //   1	199	2	localObject1	Object
    //   205	2	2	localIOException1	java.io.IOException
    //   222	1	2	localVFSFile	VFSFile
    //   232	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   27	75	3	localFileChannel	java.nio.channels.FileChannel
    //   131	4	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   161	6	3	localIOException2	java.io.IOException
    //   220	4	3	localObject2	Object
    //   228	1	3	localIOException3	java.io.IOException
    //   41	53	4	localMappedByteBuffer	java.nio.MappedByteBuffer
    // Exception table:
    //   from	to	target	type
    //   115	119	121	java/io/IOException
    //   115	119	128	finally
    //   122	126	128	finally
    //   2	21	131	java/io/FileNotFoundException
    //   144	148	150	java/io/IOException
    //   144	148	158	finally
    //   151	155	158	finally
    //   2	21	161	java/io/IOException
    //   174	178	181	java/io/IOException
    //   174	178	189	finally
    //   182	186	189	finally
    //   2	21	192	finally
    //   199	203	205	java/io/IOException
    //   199	203	213	finally
    //   206	210	213	finally
    //   23	28	216	finally
    //   30	43	216	finally
    //   52	68	216	finally
    //   77	83	216	finally
    //   85	91	216	finally
    //   93	99	216	finally
    //   101	105	216	finally
    //   107	111	216	finally
    //   166	170	216	finally
    //   136	140	220	finally
    //   23	28	228	java/io/IOException
    //   30	43	228	java/io/IOException
    //   52	68	228	java/io/IOException
    //   77	83	228	java/io/IOException
    //   85	91	228	java/io/IOException
    //   93	99	228	java/io/IOException
    //   101	105	228	java/io/IOException
    //   107	111	228	java/io/IOException
    //   23	28	232	java/io/FileNotFoundException
    //   30	43	232	java/io/FileNotFoundException
    //   52	68	232	java/io/FileNotFoundException
    //   77	83	232	java/io/FileNotFoundException
    //   85	91	232	java/io/FileNotFoundException
    //   93	99	232	java/io/FileNotFoundException
    //   101	105	232	java/io/FileNotFoundException
    //   107	111	232	java/io/FileNotFoundException
  }
  
  public static boolean a(RockDownloaderTask paramRockDownloaderTask)
  {
    if (!paramRockDownloaderTask.getDownloadInfo().verifyDate(4)) {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
      }
    }
    VFSFile localVFSFile;
    do
    {
      return false;
      localVFSFile = new VFSFile(paramRockDownloaderTask.getDownloadInfo().localPath);
    } while ((!localVFSFile.exists()) || (!a(paramRockDownloaderTask.getRuntime().getApplication(), localVFSFile)));
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
    boolean bool2 = false;
    paramDownloadInfo = new VFSFile(paramDownloadInfo.l);
    paramRockDownloaderTask = new VFSFile(paramRockDownloaderTask.getDownloadInfo().getLocalPath());
    boolean bool1 = bool2;
    if (paramDownloadInfo.exists())
    {
      bool1 = bool2;
      if (a(paramDownloadInfo))
      {
        if (paramRockDownloaderTask.exists()) {
          break label62;
        }
        bool1 = paramDownloadInfo.renameTo(paramRockDownloaderTask);
      }
    }
    label62:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!paramRockDownloaderTask.delete());
      bool1 = bool2;
    } while (!paramDownloadInfo.renameTo(paramRockDownloaderTask));
    return true;
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
    boolean bool2;
    if ((localObject != null) && (paramRockDownloaderTask.getDownloadInfo().getPackageName().equals(((RockDownloadInfo)localObject).getPackageName())))
    {
      paramRockDownloaderTask.getDownloadInfo().setRealVersionCode(((RockDownloadInfo)localObject).getRealVersionCode());
      bool1 = true;
      if (!bool1) {
        break label361;
      }
      paramRockDownloaderTask.getDownloadInfo().setLocalPath(a(paramRockDownloaderTask.getDownloadInfo()));
      bool2 = a(paramRockDownloaderTask, paramDownloadInfo);
      if ((!bool2) && (paramBoolean)) {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), "隐匿APK失败", 10007);
      }
      b(paramRockDownloaderTask, "0x800A1E6");
    }
    for (;;)
    {
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
        localObject = (DownloadInfo)bjjq.a().a().remove(paramDownloadInfo.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("RockDownloader", 2, new Object[] { "removedDownload=", localObject });
        }
        bjjo.a().a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
        b(paramRockDownloaderTask, "0x800A1E5");
      }
      if (paramBoolean) {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFinish(paramRockDownloaderTask.getDownloadInfo());
      }
      return;
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
      break;
      label361:
      bool2 = false;
    }
  }
  
  private static void b(@NonNull RockDownloaderTask paramRockDownloaderTask, String paramString)
  {
    Object localObject = paramRockDownloaderTask.getDownloadInfo();
    StringBuilder localStringBuilder = new StringBuilder();
    HashMap localHashMap = new HashMap();
    if (localObject != null)
    {
      localStringBuilder.append(((RockDownloadInfo)localObject).getBusinessName()).append("&").append(((RockDownloadInfo)localObject).getBusinessScene()).append("&").append(((RockDownloadInfo)localObject).getPackageName()).append("&").append(QQDeviceInfo.getIMEI("0"));
      localHashMap.put("BusinessName", ((RockDownloadInfo)localObject).getBusinessName());
      localHashMap.put("BusinessScene", ((RockDownloadInfo)localObject).getBusinessScene());
      localHashMap.put("PackageName", ((RockDownloadInfo)localObject).getPackageName());
      localHashMap.put("IMEI", QQDeviceInfo.getIMEI("0"));
      localHashMap.put("reportID", paramString);
    }
    try
    {
      if ((paramRockDownloaderTask.getRuntime() instanceof QQAppInterface))
      {
        bdla.b((QQAppInterface)paramRockDownloaderTask.getRuntime(), "dc00898", "", ((QQAppInterface)paramRockDownloaderTask.getRuntime()).getCurrentUin(), paramString, paramString, 1, 1, "", "", localStringBuilder.toString(), "");
        StatisticCollector.getInstance(((QQAppInterface)paramRockDownloaderTask.getRuntime()).getApp()).collectPerformance(((QQAppInterface)paramRockDownloaderTask.getRuntime()).getCurrentUin(), "RockDownloader", true, 0L, 0L, localHashMap, "");
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        paramRockDownloaderTask = new StringBuilder();
        paramString = localHashMap.keySet().iterator();
        while (paramString.hasNext())
        {
          localObject = (String)paramString.next();
          paramRockDownloaderTask.append((String)localObject).append("=").append((String)localHashMap.get(localObject)).append("\n");
        }
        if (paramRockDownloaderTask.getRuntime() == null) {
          break;
        }
        bdla.b(null, "dc00898", "", paramRockDownloaderTask.getRuntime().getAccount(), paramString, paramString, 1, 1, "", "", localStringBuilder.toString(), "");
        StatisticCollector.getInstance(paramRockDownloaderTask.getRuntime().getApplication()).collectPerformance(paramRockDownloaderTask.getRuntime().getAccount(), "RockDownloader", true, 0L, 0L, localHashMap, "");
      }
    }
    catch (Throwable paramRockDownloaderTask)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("RockDownloader", 2, paramRockDownloaderTask, new Object[0]);
          continue;
          bdla.b(null, "dc00898", "", "", paramString, paramString, 1, 1, "", "", localStringBuilder.toString(), "");
          StatisticCollector.getInstance(BaseApplicationImpl.context).collectPerformance("", "RockDownloader", true, 0L, 0L, localHashMap, "");
        }
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
      if (paramInt1 != 6) {
        break label157;
      }
      paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), anvx.a(2131712953), 10010);
    }
    for (;;)
    {
      paramRockDownloaderTask.getRockDownloadListener().onDownloadFinish(paramRockDownloaderTask.getDownloadInfo());
      paramString = (DownloadInfo)bjjq.a().a().remove(paramDownloadInfo.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "onDownloadError removedDownload=", paramString });
      }
      bjjo.a().a(paramDownloadInfo.jdField_b_of_type_JavaLangString);
      b(paramRockDownloaderTask, "0x800A1E6");
      return;
      label157:
      paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), paramString, paramInt1);
    }
  }
  
  private static void b(DownloadInfo paramDownloadInfo, RockDownloaderTask paramRockDownloaderTask)
  {
    if ((paramDownloadInfo.e == null) || (!paramDownloadInfo.e.equals(paramRockDownloaderTask.getDownloadInfo().getPackageName()))) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("RockDownloader", 2, new Object[] { "onDownloadPause: info=", paramDownloadInfo });
  }
  
  private static void b(DownloadInfo paramDownloadInfo, RockDownloaderTask paramRockDownloaderTask, boolean paramBoolean)
  {
    if ((paramDownloadInfo.e == null) || (!paramDownloadInfo.e.equals(paramRockDownloaderTask.getDownloadInfo().getPackageName()))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "onDownloadWait: info=", paramDownloadInfo });
      }
    } while (!paramBoolean);
    paramRockDownloaderTask.getRockDownloadListener().onDownloadWait(paramRockDownloaderTask.getDownloadInfo());
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
    if (!paramBoolean) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return;
      while (!paramList.hasNext()) {
        paramList = paramList.iterator();
      }
      localDownloadInfo = (DownloadInfo)paramList.next();
    } while ((localDownloadInfo.e == null) || (!localDownloadInfo.e.equals(paramRockDownloaderTask.getDownloadInfo().getPackageName())));
    paramRockDownloaderTask.getRockDownloadListener().onDownloadProceedOn(paramRockDownloaderTask.getDownloadInfo(), localDownloadInfo.jdField_f_of_type_Int);
  }
  
  public static boolean b(RockDownloaderTask paramRockDownloaderTask)
  {
    if (!paramRockDownloaderTask.getDownloadInfo().verifyDate(3)) {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "RockDownloadInfo verifyDate fail");
      }
    }
    VFSFile localVFSFile;
    do
    {
      return false;
      localVFSFile = new VFSFile(paramRockDownloaderTask.getDownloadInfo().localPath);
    } while (!localVFSFile.exists());
    a().remove(paramRockDownloaderTask.getDownloadInfo());
    return localVFSFile.delete();
  }
  
  private static boolean b(ServerApi.RspPreDownloadRecmd paramRspPreDownloadRecmd, RockDownloaderTask paramRockDownloaderTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RockDownloader", 2, new Object[] { " download_url.", paramRspPreDownloadRecmd.download_url.get(), " start_time.", Integer.valueOf(paramRspPreDownloadRecmd.start_time.get()), " end_time.", Integer.valueOf(paramRspPreDownloadRecmd.end_time.get()), " interval.", Integer.valueOf(paramRspPreDownloadRecmd.interval.get()), " quota_num.", Integer.valueOf(paramRspPreDownloadRecmd.quota_num.get()), " daily_num.", Integer.valueOf(paramRspPreDownloadRecmd.daily_num.get()) });
    }
    long l = System.currentTimeMillis() / 1000L;
    if ((l < paramRspPreDownloadRecmd.start_time.get()) || (l > paramRspPreDownloadRecmd.end_time.get())) {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, "checkDownloadPermission Task Time Error");
      }
    }
    do
    {
      do
      {
        return false;
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
        if ((System.currentTimeMillis() - paramRockDownloaderTask.getLong("LAST_TIME", 0L)) / 1000L >= paramRspPreDownloadRecmd.interval.get()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("RockDownloader", 2, "checkDownloadPermission interval Time Error");
      return false;
      String str = paramRockDownloaderTask.getString("DATE", "");
      if ((TextUtils.isEmpty(str)) || (!str.equals(DateFormat.getDateInstance().format(new Date()))) || (paramRockDownloaderTask.getInt("TIME", 0) <= paramRspPreDownloadRecmd.daily_num.get())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RockDownloader", 2, "checkDownloadPermission daily number Error");
    return false;
    return true;
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
    if (paramRockDownloaderTask.getRockDownloadListener() != null) {}
    aqgg localaqgg;
    for (boolean bool = true;; bool = false)
    {
      localaqgg = new aqgg(paramRockDownloaderTask, bool);
      Iterator localIterator = bjjq.a().a().values().iterator();
      DownloadInfo localDownloadInfo2;
      do
      {
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localDownloadInfo2 = (DownloadInfo)localIterator.next();
        } while ((TextUtils.isEmpty(localDownloadInfo2.jdField_d_of_type_JavaLangString)) || (!localDownloadInfo2.jdField_d_of_type_JavaLangString.equals(localDownloadInfo1.jdField_d_of_type_JavaLangString)));
        if (QLog.isColorLevel()) {
          QLog.d("RockDownloader", 2, new Object[] { "find exist task, downloadInfo.urlStr=", localDownloadInfo2.jdField_d_of_type_JavaLangString, " downloadInfo.progress=", Integer.valueOf(localDownloadInfo2.jdField_f_of_type_Int), " downloadInfo.filePath=", localDownloadInfo2.l });
        }
      } while (localDownloadInfo2.jdField_f_of_type_Int == 100);
      bjjq.a().b(localDownloadInfo1);
      if (bool)
      {
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFail(paramRockDownloaderTask.getDownloadInfo(), anvx.a(2131712950), 10011);
        paramRockDownloaderTask.getRockDownloadListener().onDownloadFinish(paramRockDownloaderTask.getDownloadInfo());
      }
      return;
    }
    bjjq.a().a(localaqgg);
    bjjq.a().b(localDownloadInfo1);
  }
  
  private static void e(RockDownloaderTask paramRockDownloaderTask)
  {
    Object localObject = new NewIntent(paramRockDownloaderTask.getRuntime().getApplication(), aqgk.class);
    ((NewIntent)localObject).putExtra("BUNDLE_CMD", "QQApkSvc.update_download_count");
    try
    {
      ((NewIntent)localObject).putExtra("BUNDLE_KEY_UIN", Long.parseLong(paramRockDownloaderTask.getRuntime().getAccount()));
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
        ((SharedPreferences.Editor)localObject).putLong("LAST_TIME", System.currentTimeMillis());
        ((SharedPreferences.Editor)localObject).apply();
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("RockDownloader", 2, localNumberFormatException, new Object[0]);
          ((NewIntent)localObject).putExtra("BUNDLE_KEY_UIN", 0);
          continue;
          ((SharedPreferences.Editor)localObject).putString("DATA", DateFormat.getDateInstance().format(new Date()));
          ((SharedPreferences.Editor)localObject).putInt("TIME", 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqge
 * JD-Core Version:    0.7.0.1
 */