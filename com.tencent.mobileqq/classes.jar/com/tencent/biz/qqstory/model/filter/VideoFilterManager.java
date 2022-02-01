package com.tencent.biz.qqstory.model.filter;

import android.annotation.TargetApi;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.download.Downloader;
import com.tencent.biz.qqstory.base.download.DownloaderImp;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.IManager;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Input;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@TargetApi(11)
public class VideoFilterManager
  implements IManager
{
  public static final String a;
  public static final String b;
  @GuardedBy("filterItemList")
  private int jdField_a_of_type_Int = 0;
  @GuardedBy("filterItemList")
  private long jdField_a_of_type_Long = 0L;
  private final Downloader jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader = new DownloaderImp();
  @GuardedBy("filterItemList")
  private FilterItem jdField_a_of_type_ComTencentBizQqstoryModelFilterFilterItem = null;
  @GuardedBy("get list process")
  protected final List<FilterItem> a;
  protected Map<String, PictureFilterConfig> a;
  @GuardedBy("filterItemList")
  private Queue<FilterItem> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  @GuardedBy("filterItemList")
  protected final List<FilterItem> b;
  @GuardedBy("get list process")
  protected String c = "";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QQStoryConstant.h);
    localStringBuilder.append("filter");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("list_cache");
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public VideoFilterManager()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static String a(FilterItem paramFilterItem)
  {
    if ((paramFilterItem != null) && (!TextUtils.isEmpty(paramFilterItem.filterConfigMd5)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append("/");
      localStringBuilder.append(paramFilterItem.filterConfigMd5);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.isFile()) {
      SLog.d("VideoFilterManager", "delete file : %s", new Object[] { Boolean.valueOf(paramString.delete()) });
    }
    if (!paramString.exists()) {
      SLog.d("VideoFilterManager", "create folder : %s", new Object[] { Boolean.valueOf(paramString.mkdirs()) });
    }
  }
  
  /* Error */
  @GuardedBy("filterItemList")
  private boolean a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 31	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   13: astore_1
    //   14: aload_1
    //   15: getstatic 55	com/tencent/biz/qqstory/model/filter/VideoFilterManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   18: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_1
    //   23: ldc 111
    //   25: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_1
    //   30: ldc 153
    //   32: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_1
    //   37: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 158	com/tencent/biz/qqstory/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   43: pop
    //   44: goto +23 -> 67
    //   47: astore_1
    //   48: aconst_null
    //   49: astore_3
    //   50: aload_3
    //   51: astore_2
    //   52: goto +319 -> 371
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_2
    //   58: aload_2
    //   59: astore_3
    //   60: aload 5
    //   62: astore 4
    //   64: goto +234 -> 298
    //   67: new 160	java/io/ByteArrayOutputStream
    //   70: dup
    //   71: sipush 4096
    //   74: invokespecial 163	java/io/ByteArrayOutputStream:<init>	(I)V
    //   77: astore_3
    //   78: new 165	java/io/ObjectOutputStream
    //   81: dup
    //   82: aload_3
    //   83: invokespecial 168	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: astore_2
    //   87: aload_2
    //   88: aload_0
    //   89: getfield 75	com/tencent/biz/qqstory/model/filter/VideoFilterManager:jdField_a_of_type_Long	J
    //   92: invokevirtual 172	java/io/ObjectOutputStream:writeLong	(J)V
    //   95: aload_2
    //   96: aload_0
    //   97: getfield 77	com/tencent/biz/qqstory/model/filter/VideoFilterManager:jdField_a_of_type_Int	I
    //   100: invokevirtual 175	java/io/ObjectOutputStream:writeInt	(I)V
    //   103: aload_2
    //   104: aload_0
    //   105: getfield 79	com/tencent/biz/qqstory/model/filter/VideoFilterManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   108: invokevirtual 179	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   111: aload_2
    //   112: invokevirtual 182	java/io/ObjectOutputStream:flush	()V
    //   115: aload_2
    //   116: invokevirtual 185	java/io/ObjectOutputStream:close	()V
    //   119: new 31	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   126: astore_1
    //   127: aload_1
    //   128: getstatic 55	com/tencent/biz/qqstory/model/filter/VideoFilterManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   131: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_1
    //   136: ldc 111
    //   138: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_1
    //   143: ldc 153
    //   145: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: new 187	java/io/FileOutputStream
    //   152: dup
    //   153: aload_1
    //   154: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokespecial 188	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   160: astore 5
    //   162: aload_3
    //   163: aload 5
    //   165: invokevirtual 191	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   168: aload_3
    //   169: invokevirtual 192	java/io/ByteArrayOutputStream:flush	()V
    //   172: aload_3
    //   173: invokevirtual 193	java/io/ByteArrayOutputStream:close	()V
    //   176: aload 5
    //   178: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   181: ldc 122
    //   183: ldc 196
    //   185: aload_0
    //   186: getfield 79	com/tencent/biz/qqstory/model/filter/VideoFilterManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   189: invokeinterface 202 1 0
    //   194: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: invokestatic 210	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   200: aload_3
    //   201: invokevirtual 193	java/io/ByteArrayOutputStream:close	()V
    //   204: goto +8 -> 212
    //   207: astore_1
    //   208: aload_1
    //   209: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   212: aload_2
    //   213: invokevirtual 185	java/io/ObjectOutputStream:close	()V
    //   216: goto +8 -> 224
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   224: aload 5
    //   226: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   229: iconst_1
    //   230: ireturn
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   236: iconst_1
    //   237: ireturn
    //   238: astore_1
    //   239: aload 5
    //   241: astore 4
    //   243: goto +128 -> 371
    //   246: astore_1
    //   247: aload_2
    //   248: astore 4
    //   250: aload 5
    //   252: astore_2
    //   253: goto +33 -> 286
    //   256: astore_1
    //   257: goto +114 -> 371
    //   260: astore_1
    //   261: aconst_null
    //   262: astore 5
    //   264: aload_2
    //   265: astore 4
    //   267: aload 5
    //   269: astore_2
    //   270: goto +16 -> 286
    //   273: astore_1
    //   274: aconst_null
    //   275: astore_2
    //   276: goto +95 -> 371
    //   279: astore_1
    //   280: aconst_null
    //   281: astore 4
    //   283: aload 4
    //   285: astore_2
    //   286: aload_3
    //   287: astore 5
    //   289: aload_2
    //   290: astore_3
    //   291: aload 4
    //   293: astore_2
    //   294: aload 5
    //   296: astore 4
    //   298: ldc 122
    //   300: ldc 215
    //   302: aload_1
    //   303: invokestatic 218	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   306: aload 4
    //   308: ifnull +16 -> 324
    //   311: aload 4
    //   313: invokevirtual 193	java/io/ByteArrayOutputStream:close	()V
    //   316: goto +8 -> 324
    //   319: astore_1
    //   320: aload_1
    //   321: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   324: aload_2
    //   325: ifnull +15 -> 340
    //   328: aload_2
    //   329: invokevirtual 185	java/io/ObjectOutputStream:close	()V
    //   332: goto +8 -> 340
    //   335: astore_1
    //   336: aload_1
    //   337: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   340: aload_3
    //   341: ifnull +15 -> 356
    //   344: aload_3
    //   345: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   348: goto +8 -> 356
    //   351: astore_1
    //   352: aload_1
    //   353: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   356: iconst_0
    //   357: ireturn
    //   358: astore 5
    //   360: aload 4
    //   362: astore_1
    //   363: aload_3
    //   364: astore 4
    //   366: aload_1
    //   367: astore_3
    //   368: aload 5
    //   370: astore_1
    //   371: aload_3
    //   372: ifnull +15 -> 387
    //   375: aload_3
    //   376: invokevirtual 193	java/io/ByteArrayOutputStream:close	()V
    //   379: goto +8 -> 387
    //   382: astore_3
    //   383: aload_3
    //   384: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   387: aload_2
    //   388: ifnull +15 -> 403
    //   391: aload_2
    //   392: invokevirtual 185	java/io/ObjectOutputStream:close	()V
    //   395: goto +8 -> 403
    //   398: astore_2
    //   399: aload_2
    //   400: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   403: aload 4
    //   405: ifnull +16 -> 421
    //   408: aload 4
    //   410: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   413: goto +8 -> 421
    //   416: astore_2
    //   417: aload_2
    //   418: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   421: aload_1
    //   422: athrow
    //   423: astore_1
    //   424: goto -357 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	this	VideoFilterManager
    //   13	24	1	localStringBuilder1	StringBuilder
    //   47	1	1	localObject1	Object
    //   55	1	1	localIOException1	java.io.IOException
    //   126	28	1	localStringBuilder2	StringBuilder
    //   207	2	1	localIOException2	java.io.IOException
    //   219	2	1	localIOException3	java.io.IOException
    //   231	2	1	localIOException4	java.io.IOException
    //   238	1	1	localObject2	Object
    //   246	1	1	localIOException5	java.io.IOException
    //   256	1	1	localObject3	Object
    //   260	1	1	localIOException6	java.io.IOException
    //   273	1	1	localObject4	Object
    //   279	24	1	localIOException7	java.io.IOException
    //   319	2	1	localIOException8	java.io.IOException
    //   335	2	1	localIOException9	java.io.IOException
    //   351	2	1	localIOException10	java.io.IOException
    //   362	60	1	localObject5	Object
    //   423	1	1	localException	Exception
    //   51	341	2	localObject6	Object
    //   398	2	2	localIOException11	java.io.IOException
    //   416	2	2	localIOException12	java.io.IOException
    //   49	327	3	localObject7	Object
    //   382	2	3	localIOException13	java.io.IOException
    //   1	408	4	localObject8	Object
    //   4	291	5	localObject9	Object
    //   358	11	5	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   6	44	47	finally
    //   67	78	47	finally
    //   6	44	55	java/io/IOException
    //   67	78	55	java/io/IOException
    //   200	204	207	java/io/IOException
    //   212	216	219	java/io/IOException
    //   224	229	231	java/io/IOException
    //   162	200	238	finally
    //   162	200	246	java/io/IOException
    //   87	162	256	finally
    //   87	162	260	java/io/IOException
    //   78	87	273	finally
    //   78	87	279	java/io/IOException
    //   311	316	319	java/io/IOException
    //   328	332	335	java/io/IOException
    //   344	348	351	java/io/IOException
    //   298	306	358	finally
    //   375	379	382	java/io/IOException
    //   391	395	398	java/io/IOException
    //   408	413	416	java/io/IOException
    //   6	44	423	java/lang/Exception
  }
  
  public static boolean a(FilterItem paramFilterItem)
  {
    return a(a(paramFilterItem), false);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(paramString);
      if ((localFile.exists()) && (localFile.isDirectory()))
      {
        localFile = new File(paramString, "config.json");
        if ((localFile.exists()) && (localFile.isFile())) {
          return true;
        }
        if (paramBoolean) {
          SLog.d("VideoFilterManager", "remove illegal filter folder : %s", new Object[] { paramString });
        }
      }
    }
    try
    {
      FileUtils.d(paramString);
      return false;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private static String b(FilterItem paramFilterItem)
  {
    if ((paramFilterItem != null) && (!TextUtils.isEmpty(paramFilterItem.filterConfigMd5)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append("/");
      localStringBuilder.append(paramFilterItem.filterConfigMd5);
      localStringBuilder.append(".zip");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  /* Error */
  @GuardedBy("filterItemList")
  private boolean b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore_3
    //   8: new 31	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   15: astore_2
    //   16: aload_2
    //   17: getstatic 55	com/tencent/biz/qqstory/model/filter/VideoFilterManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   20: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_2
    //   25: ldc 111
    //   27: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_2
    //   32: ldc 153
    //   34: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: new 239	java/io/ByteArrayInputStream
    //   41: dup
    //   42: new 114	java/io/File
    //   45: dup
    //   46: aload_2
    //   47: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: invokestatic 242	com/tencent/biz/qqstory/utils/FileUtils:b	(Ljava/io/File;)[B
    //   56: invokespecial 245	java/io/ByteArrayInputStream:<init>	([B)V
    //   59: astore_2
    //   60: new 247	java/io/ObjectInputStream
    //   63: dup
    //   64: aload_2
    //   65: invokespecial 250	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   68: astore_3
    //   69: aload_0
    //   70: getfield 79	com/tencent/biz/qqstory/model/filter/VideoFilterManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   73: invokeinterface 253 1 0
    //   78: aload_0
    //   79: aload_3
    //   80: invokevirtual 257	java/io/ObjectInputStream:readLong	()J
    //   83: putfield 75	com/tencent/biz/qqstory/model/filter/VideoFilterManager:jdField_a_of_type_Long	J
    //   86: aload_0
    //   87: aload_3
    //   88: invokevirtual 260	java/io/ObjectInputStream:readInt	()I
    //   91: putfield 77	com/tencent/biz/qqstory/model/filter/VideoFilterManager:jdField_a_of_type_Int	I
    //   94: aload_3
    //   95: invokevirtual 264	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   98: checkcast 198	java/util/List
    //   101: astore 4
    //   103: aload 4
    //   105: ifnull +15 -> 120
    //   108: aload_0
    //   109: getfield 79	com/tencent/biz/qqstory/model/filter/VideoFilterManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   112: aload 4
    //   114: invokeinterface 268 2 0
    //   119: pop
    //   120: aload 4
    //   122: ifnull +254 -> 376
    //   125: aload 4
    //   127: invokeinterface 202 1 0
    //   132: istore_1
    //   133: goto +3 -> 136
    //   136: ldc 122
    //   138: ldc_w 270
    //   141: iload_1
    //   142: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   145: invokestatic 210	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   148: aload_2
    //   149: invokevirtual 271	java/io/ByteArrayInputStream:close	()V
    //   152: aload_3
    //   153: invokevirtual 272	java/io/ObjectInputStream:close	()V
    //   156: iconst_1
    //   157: ireturn
    //   158: astore 5
    //   160: aload_3
    //   161: astore 4
    //   163: goto +21 -> 184
    //   166: astore 4
    //   168: aload_2
    //   169: astore 5
    //   171: aload_3
    //   172: astore_2
    //   173: aload 5
    //   175: astore_3
    //   176: goto +55 -> 231
    //   179: astore 5
    //   181: aconst_null
    //   182: astore 4
    //   184: aload_2
    //   185: astore_3
    //   186: aload 5
    //   188: astore_2
    //   189: goto +122 -> 311
    //   192: astore 4
    //   194: aconst_null
    //   195: astore 5
    //   197: aload_2
    //   198: astore_3
    //   199: aload 5
    //   201: astore_2
    //   202: goto +29 -> 231
    //   205: aconst_null
    //   206: astore 4
    //   208: aload_2
    //   209: astore_3
    //   210: goto +69 -> 279
    //   213: astore_2
    //   214: aconst_null
    //   215: astore 5
    //   217: aload 4
    //   219: astore_3
    //   220: aload 5
    //   222: astore 4
    //   224: goto +87 -> 311
    //   227: astore 4
    //   229: aconst_null
    //   230: astore_2
    //   231: ldc 122
    //   233: ldc_w 274
    //   236: aload 4
    //   238: invokestatic 218	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload_3
    //   242: ifnull +10 -> 252
    //   245: aload_3
    //   246: invokevirtual 271	java/io/ByteArrayInputStream:close	()V
    //   249: goto +3 -> 252
    //   252: aload_2
    //   253: ifnull +55 -> 308
    //   256: aload_2
    //   257: invokevirtual 272	java/io/ObjectInputStream:close	()V
    //   260: iconst_0
    //   261: ireturn
    //   262: astore 5
    //   264: aload_2
    //   265: astore 4
    //   267: aload 5
    //   269: astore_2
    //   270: goto +41 -> 311
    //   273: aconst_null
    //   274: astore 4
    //   276: aload 5
    //   278: astore_3
    //   279: ldc 122
    //   281: ldc_w 276
    //   284: invokestatic 278	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: aload_3
    //   288: ifnull +10 -> 298
    //   291: aload_3
    //   292: invokevirtual 271	java/io/ByteArrayInputStream:close	()V
    //   295: goto +3 -> 298
    //   298: aload 4
    //   300: ifnull +8 -> 308
    //   303: aload 4
    //   305: invokevirtual 272	java/io/ObjectInputStream:close	()V
    //   308: iconst_0
    //   309: ireturn
    //   310: astore_2
    //   311: aload_3
    //   312: ifnull +10 -> 322
    //   315: aload_3
    //   316: invokevirtual 271	java/io/ByteArrayInputStream:close	()V
    //   319: goto +3 -> 322
    //   322: aload 4
    //   324: ifnull +8 -> 332
    //   327: aload 4
    //   329: invokevirtual 272	java/io/ObjectInputStream:close	()V
    //   332: aload_2
    //   333: athrow
    //   334: astore_2
    //   335: goto -62 -> 273
    //   338: astore_3
    //   339: goto -134 -> 205
    //   342: astore 4
    //   344: aload_3
    //   345: astore 4
    //   347: goto -139 -> 208
    //   350: astore_2
    //   351: goto -199 -> 152
    //   354: astore_2
    //   355: iconst_1
    //   356: ireturn
    //   357: astore_3
    //   358: goto -106 -> 252
    //   361: astore_2
    //   362: iconst_0
    //   363: ireturn
    //   364: astore_2
    //   365: goto -67 -> 298
    //   368: astore_3
    //   369: goto -47 -> 322
    //   372: astore_3
    //   373: goto -41 -> 332
    //   376: iconst_0
    //   377: istore_1
    //   378: goto -242 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	VideoFilterManager
    //   132	246	1	i	int
    //   15	194	2	localObject1	Object
    //   213	1	2	localObject2	Object
    //   230	40	2	localObject3	Object
    //   310	23	2	localObject4	Object
    //   334	1	2	localIOException1	java.io.IOException
    //   350	1	2	localIOException2	java.io.IOException
    //   354	1	2	localIOException3	java.io.IOException
    //   361	1	2	localIOException4	java.io.IOException
    //   364	1	2	localIOException5	java.io.IOException
    //   7	309	3	localObject5	Object
    //   338	7	3	localIOException6	java.io.IOException
    //   357	1	3	localIOException7	java.io.IOException
    //   368	1	3	localIOException8	java.io.IOException
    //   372	1	3	localIOException9	java.io.IOException
    //   4	158	4	localObject6	Object
    //   166	1	4	localException1	Exception
    //   182	1	4	localObject7	Object
    //   192	1	4	localException2	Exception
    //   206	17	4	localObject8	Object
    //   227	10	4	localException3	Exception
    //   265	63	4	localObject9	Object
    //   342	1	4	localIOException10	java.io.IOException
    //   345	1	4	localObject10	Object
    //   1	1	5	localObject11	Object
    //   158	1	5	localObject12	Object
    //   169	5	5	localObject13	Object
    //   179	8	5	localObject14	Object
    //   195	26	5	localObject15	Object
    //   262	15	5	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   69	103	158	finally
    //   108	120	158	finally
    //   125	133	158	finally
    //   136	148	158	finally
    //   69	103	166	java/lang/Exception
    //   108	120	166	java/lang/Exception
    //   125	133	166	java/lang/Exception
    //   136	148	166	java/lang/Exception
    //   60	69	179	finally
    //   60	69	192	java/lang/Exception
    //   8	60	213	finally
    //   8	60	227	java/lang/Exception
    //   231	241	262	finally
    //   279	287	310	finally
    //   8	60	334	java/io/IOException
    //   60	69	338	java/io/IOException
    //   69	103	342	java/io/IOException
    //   108	120	342	java/io/IOException
    //   125	133	342	java/io/IOException
    //   136	148	342	java/io/IOException
    //   148	152	350	java/io/IOException
    //   152	156	354	java/io/IOException
    //   245	249	357	java/io/IOException
    //   256	260	361	java/io/IOException
    //   303	308	361	java/io/IOException
    //   291	295	364	java/io/IOException
    //   315	319	368	java/io/IOException
    //   327	332	372	java/io/IOException
  }
  
  protected PictureFilterConfig a(File paramFile)
  {
    if ((paramFile.exists()) && (paramFile.isFile()) && (paramFile.canRead()))
    {
      long l = SystemClock.uptimeMillis();
      paramFile = (PictureFilterConfig)JsonORM.a(new JSONObject(new String(FileUtils.a(paramFile), "UTF-8")), PictureFilterConfig.class);
      SLog.a("VideoFilterManager", "parseFilterConfigFile success, cost = %d ms", Long.valueOf(SystemClock.uptimeMillis() - l));
      return paramFile;
    }
    SLog.d("VideoFilterManager", "parseFilterConfigFile failed, file is illegal %s", new Object[] { paramFile });
    return null;
  }
  
  public void a()
  {
    SLog.d("VideoFilterManager", "onInit");
    a(jdField_a_of_type_JavaLangString);
    a(jdField_b_of_type_JavaLangString);
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      b();
      return;
    }
  }
  
  @GuardedBy("get list process")
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        SLog.a("VideoFilterManager", "fireGetFilterListFinish, filter count %d -> %d", Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size()), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
        this.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_b_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Int = paramInt;
        a();
        this.jdField_a_of_type_JavaUtilQueue.clear();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          FilterItem localFilterItem = (FilterItem)localIterator.next();
          if ((!localFilterItem.isLocalType()) && (!a(localFilterItem))) {
            this.jdField_a_of_type_JavaUtilQueue.offer(localFilterItem);
          }
        }
        SLog.a("VideoFilterManager", "fireGetFilterListFinish, download pending list size = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilQueue.size()));
        d();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public void b()
  {
    SLog.d("VideoFilterManager", "onDestroy");
    e();
  }
  
  @GuardedBy("get list process")
  protected void c()
  {
    SLog.a("VideoFilterManager", "fireGetFilterListInner %s", this.c);
    CmdTaskManger.a().a(new VideoFilterManager.GetFilterListRequest(this.c), new VideoFilterManager.FilterListCallback(this, null));
  }
  
  protected void d()
  {
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelFilterFilterItem == null)
        {
          FilterItem localFilterItem = (FilterItem)this.jdField_a_of_type_JavaUtilQueue.poll();
          this.jdField_a_of_type_ComTencentBizQqstoryModelFilterFilterItem = localFilterItem;
          if (localFilterItem != null)
          {
            SLog.d("VideoFilterManager", "start to download filter resource : %s", new Object[] { localFilterItem });
            new VideoFilterManager.1(this, this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloader).executeOnExecutor(Bosses.get().getExecutor(16), new FileDownloadTask.Input[] { new FileDownloadTask.Input(localFilterItem.filterConfigUrl, b(localFilterItem), localFilterItem.filterConfigMd5) });
          }
          return;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public void e()
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      SLog.a("VideoFilterManager", "trimMemory, download pending list %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilQueue.size()));
      this.jdField_a_of_type_JavaUtilQueue.clear();
      SLog.a("VideoFilterManager", "trimMemory, filter list %d", Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size()));
      this.jdField_b_of_type_JavaUtilList.clear();
      SLog.a("VideoFilterManager", "trimMemory, picture config cache %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilMap.size()));
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.filter.VideoFilterManager
 * JD-Core Version:    0.7.0.1
 */