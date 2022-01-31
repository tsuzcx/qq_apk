import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.activity.photo.LocalMediaInfo;>;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;

public class bbbx
{
  public static int a;
  public static long a;
  public static String a;
  public static HashMap<String, Integer> a;
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  public static boolean a;
  public static final int[] a;
  static String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static long jdField_b_of_type_Long;
  public static String b;
  public static HashMap<String, LinkedHashMap<String, Integer>> b;
  private static String[] jdField_b_of_type_ArrayOfJavaLangString = { "_id", "_data", "duration", "date_added", "date_modified", "mime_type", "_size" };
  private static long c;
  public static String c;
  public static HashMap<String, Pair<String, String>> c;
  public static final HashMap<String, Integer> d;
  
  static
  {
    jdField_a_of_type_Int = 10485760;
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_JavaUtilHashMap = new HashMap();
    d = new HashMap();
    d.put("image", Integer.valueOf(0));
    d.put("video", Integer.valueOf(1));
    d.put("mobileqq", Integer.valueOf(2));
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 3000, 1 };
    if (Build.VERSION.SDK_INT >= 16) {}
    for (jdField_a_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_added", "date_modified", "orientation", "latitude", "longitude", "_size", "width", "height" }; Build.VERSION.SDK_INT >= 16; jdField_a_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_added", "date_modified", "orientation", "latitude", "longitude", "_size" })
    {
      jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "duration", "date_added", "date_modified", "mime_type", "_size", "width", "height" };
      return;
    }
  }
  
  public static float a()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "photoGroupListImageCropSpaceRatio", 0.25F);
  }
  
  public static int a()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "MaxSelectVideoNum", 50);
  }
  
  public static int a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return -1;
    }
    String[] arrayOfString = agmm.a(paramLocalMediaInfo.mMimeType);
    if (arrayOfString == null) {
      return 0;
    }
    Integer localInteger = (Integer)d.get(arrayOfString[0]);
    if (localInteger == null)
    {
      QLog.w("AlbumUtil", 1, "getMediaType fail : " + paramLocalMediaInfo.mMimeType + " - " + arrayOfString[0]);
      return -1;
    }
    return localInteger.intValue();
  }
  
  public static int a(List<String> paramList, int paramInt, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, Map<String, LocalMediaInfo> paramMap2)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = null;
      if (paramMap2 != null) {
        paramList = (LocalMediaInfo)paramMap2.get(str);
      }
      Object localObject = paramList;
      if (paramList == null)
      {
        localObject = paramList;
        if (paramMap1 != null) {
          localObject = (LocalMediaInfo)paramMap1.get(str);
        }
      }
      if ((localObject == null) || (a((LocalMediaInfo)localObject) != 1))
      {
        long l = new File(str).length();
        if (l <= paramInt) {
          break label148;
        }
        axrn.a(BaseApplicationImpl.getApplication()).a(null, "sendQualityPicLimit", true, paramInt, l, null, "");
        i += 1;
      }
    }
    label148:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static int a(List<String> paramList, long paramLong, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, Map<String, LocalMediaInfo> paramMap2)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = null;
      if (paramMap2 != null) {
        paramList = (LocalMediaInfo)paramMap2.get(str);
      }
      Object localObject = paramList;
      if (paramList == null)
      {
        localObject = paramList;
        if (paramMap1 != null) {
          localObject = (LocalMediaInfo)paramMap1.get(str);
        }
      }
      if ((localObject == null) || (a((LocalMediaInfo)localObject) == 1))
      {
        if (new File(str).length() <= paramLong) {
          break label123;
        }
        i += 1;
      }
    }
    label123:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static int a(List<String> paramList, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, HashMap<String, PhotoSendParams> paramHashMap, Map<String, LocalMediaInfo> paramMap2)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      long l;
      if ((paramHashMap != null) && (NetworkUtils.isNetworkUrl(str))) {
        if (paramHashMap.get(str) != null) {
          l = ((PhotoSendParams)paramHashMap.get(str)).fileSize;
        }
      }
      for (;;)
      {
        i = (int)(i + l);
        if (QLog.isColorLevel()) {
          QLog.d("_photo", 2, "setQualityTextViewText, path:" + str + ",len:" + l);
        }
        break;
        QLog.w("_photo", 1, "mSelectedSendParams.get(p) == null path:" + str);
        l = 0L;
        continue;
        paramList = null;
        if (paramMap2 != null) {
          paramList = (LocalMediaInfo)paramMap2.get(str);
        }
        if ((paramList == null) && (paramMap1 != null)) {
          paramList = (LocalMediaInfo)paramMap1.get(str);
        }
        l = new File(str).length();
      }
    }
    return i;
  }
  
  private static Cursor a(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    if (paramInt > 0)
    {
      localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter("limit", String.valueOf(paramInt));
    }
    for (Object localObject = ((Uri.Builder)localObject).build();; localObject = MediaStore.Images.Media.EXTERNAL_CONTENT_URI) {
      return paramContext.getContentResolver().query((Uri)localObject, jdField_a_of_type_ArrayOfJavaLangString, paramString, paramArrayOfString, "_id DESC");
    }
  }
  
  public static String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_id", null);
  }
  
  public static String a(List<String> paramList)
  {
    Object localObject1 = new StringBuilder("_data");
    ((StringBuilder)localObject1).append(" IS NOT NULL AND ");
    ((StringBuilder)localObject1).append("_size");
    ((StringBuilder)localObject1).append(" > 0 ");
    Object localObject2 = localObject1;
    if (paramList != null)
    {
      localObject2 = localObject1;
      if (paramList.size() > 0)
      {
        ((StringBuilder)localObject1).append(" AND (");
        localObject2 = paramList.iterator();
        paramList = (List<String>)localObject1;
        int i = 1;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (String)((Iterator)localObject2).next();
          if (i == 0) {
            paramList.append(" OR ");
          }
          for (;;)
          {
            paramList.append(" ( ");
            paramList = a("bucket_id", paramList, (String)localObject1);
            paramList.append(" ) ");
            break;
            i = 0;
          }
        }
        paramList.append(" ) ");
        localObject2 = paramList;
      }
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  private static StringBuilder a(String paramString1, StringBuilder paramStringBuilder, String paramString2)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(" = ");
    paramStringBuilder.append(paramString2);
    return paramStringBuilder;
  }
  
  public static URL a(LocalMediaInfo paramLocalMediaInfo)
  {
    return a(paramLocalMediaInfo, null);
  }
  
  public static URL a(LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("albumthumb");
    localStringBuilder.append("://");
    localStringBuilder.append(paramLocalMediaInfo.path);
    if (paramString != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString);
    }
    try
    {
      paramLocalMediaInfo = new URL(localStringBuilder.toString());
      return paramLocalMediaInfo;
    }
    catch (MalformedURLException paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramLocalMediaInfo.getMessage(), paramLocalMediaInfo);
      }
    }
    return null;
  }
  
  public static URL a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("videocover");
    localStringBuilder.append("://");
    localStringBuilder.append(paramString1);
    if (paramString2 != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString2);
    }
    try
    {
      paramString1 = new URL(localStringBuilder.toString());
      return paramString1;
    }
    catch (MalformedURLException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString1.getMessage(), paramString1);
      }
    }
    return null;
  }
  
  private static ArrayList<LocalMediaInfo> a(Context paramContext, Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt, aglv paramaglv, boolean paramBoolean, long paramLong)
  {
    paramContext = new ArrayList();
    paramCursor = (ArrayList)a(paramCursor, paramList, paramInt, paramaglv, paramBoolean, paramLong);
    if (paramCursor != null) {
      paramContext.addAll(paramCursor);
    }
    if (QLog.isColorLevel()) {
      QLog.e("AlbumUtil", 2, "getSystemAndAppVideoList listsize=" + paramContext.size());
    }
    paramCursor = agmg.a(BaseApplicationImpl.getContext());
    if (paramCursor != null)
    {
      paramCursor = paramCursor.a(false, -1);
      if (paramCursor != null)
      {
        paramCursor = paramCursor.iterator();
        while (paramCursor.hasNext())
        {
          paramList = (agml)paramCursor.next();
          paramaglv = new LocalMediaInfo();
          paramaglv._id = paramList.jdField_a_of_type_Int;
          paramaglv.mDuration = paramList.jdField_c_of_type_Long;
          paramaglv.fileSize = paramList.jdField_a_of_type_Long;
          paramaglv.path = paramList.jdField_c_of_type_JavaLangString;
          paramaglv.modifiedDate = paramList.jdField_b_of_type_Long;
          paramaglv.mMimeType = paramList.d;
          paramaglv.isSystemMeidaStore = false;
          paramContext.add(paramaglv);
        }
      }
    }
    Collections.sort(paramContext);
    return paramContext;
  }
  
  public static List<LocalMediaInfo> a(Context paramContext, int paramInt1, int paramInt2, aglv paramaglv)
  {
    return a(paramContext, paramInt1, paramInt2, paramaglv, false, 0, null, false);
  }
  
  /* Error */
  public static List<LocalMediaInfo> a(Context paramContext, int paramInt1, int paramInt2, aglv paramaglv, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 437	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 6
    //   5: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +30 -> 38
    //   11: ldc 139
    //   13: iconst_2
    //   14: new 141	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 439
    //   24: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: lload 6
    //   29: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aconst_null
    //   39: astore 9
    //   41: iload_2
    //   42: ifgt +14 -> 56
    //   45: new 441	java/lang/IllegalArgumentException
    //   48: dup
    //   49: ldc_w 443
    //   52: invokespecial 444	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    //   56: new 357	java/util/ArrayList
    //   59: dup
    //   60: invokespecial 358	java/util/ArrayList:<init>	()V
    //   63: astore 11
    //   65: getstatic 447	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   68: invokevirtual 256	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   71: astore 10
    //   73: aload 10
    //   75: ldc_w 258
    //   78: iload_2
    //   79: bipush 6
    //   81: imul
    //   82: invokestatic 261	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   85: invokevirtual 267	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   88: pop
    //   89: aload 10
    //   91: invokevirtual 271	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   94: astore 10
    //   96: aload_0
    //   97: invokevirtual 277	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   100: aload 10
    //   102: getstatic 97	bbbx:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   105: ldc_w 449
    //   108: aconst_null
    //   109: ldc_w 279
    //   112: invokevirtual 285	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   115: astore_0
    //   116: aload_0
    //   117: astore 9
    //   119: aload 9
    //   121: astore_0
    //   122: getstatic 67	android/os/Build$VERSION:SDK_INT	I
    //   125: bipush 16
    //   127: if_icmplt +188 -> 315
    //   130: iconst_1
    //   131: istore 8
    //   133: aload 9
    //   135: astore_0
    //   136: aload 9
    //   138: aload 11
    //   140: iload_2
    //   141: aload_3
    //   142: iload 8
    //   144: lload 4
    //   146: invokestatic 361	bbbx:a	(Landroid/database/Cursor;Ljava/util/List;ILaglv;ZJ)Ljava/util/List;
    //   149: pop
    //   150: aload 9
    //   152: ifnull +10 -> 162
    //   155: aload 9
    //   157: invokeinterface 454 1 0
    //   162: invokestatic 378	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   165: invokestatic 383	agmg:a	(Landroid/content/Context;)Lagmg;
    //   168: astore_0
    //   169: aload_0
    //   170: ifnull +212 -> 382
    //   173: aload_0
    //   174: iconst_1
    //   175: bipush 100
    //   177: invokevirtual 386	agmg:a	(ZI)Ljava/util/ArrayList;
    //   180: astore_0
    //   181: aload_0
    //   182: ifnull +200 -> 382
    //   185: aload_0
    //   186: invokevirtual 387	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   189: astore_0
    //   190: aload_0
    //   191: invokeinterface 176 1 0
    //   196: ifeq +186 -> 382
    //   199: aload_0
    //   200: invokeinterface 180 1 0
    //   205: checkcast 389	agml
    //   208: astore 9
    //   210: new 125	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   213: dup
    //   214: invokespecial 390	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   217: astore 10
    //   219: aload 10
    //   221: aload 9
    //   223: getfield 391	agml:jdField_a_of_type_Int	I
    //   226: i2l
    //   227: putfield 393	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   230: aload 10
    //   232: aload 9
    //   234: getfield 395	agml:jdField_c_of_type_Long	J
    //   237: putfield 398	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   240: aload 10
    //   242: aload 9
    //   244: getfield 400	agml:jdField_a_of_type_Long	J
    //   247: putfield 401	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   250: aload 10
    //   252: aload 9
    //   254: getfield 403	agml:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   257: putfield 338	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   260: aload 10
    //   262: aload 9
    //   264: getfield 405	agml:jdField_b_of_type_Long	J
    //   267: putfield 408	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   270: aload 10
    //   272: aload 9
    //   274: getfield 410	agml:d	Ljava/lang/String;
    //   277: putfield 128	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   280: aload 10
    //   282: iconst_0
    //   283: putfield 413	com/tencent/mobileqq/activity/photo/LocalMediaInfo:isSystemMeidaStore	Z
    //   286: aload_3
    //   287: ifnull +15 -> 302
    //   290: aload_3
    //   291: aload 9
    //   293: getfield 410	agml:d	Ljava/lang/String;
    //   296: invokevirtual 458	aglv:a	(Ljava/lang/String;)Z
    //   299: ifne -109 -> 190
    //   302: aload 11
    //   304: aload 10
    //   306: invokeinterface 459 2 0
    //   311: pop
    //   312: goto -122 -> 190
    //   315: iconst_0
    //   316: istore 8
    //   318: goto -185 -> 133
    //   321: astore 10
    //   323: aconst_null
    //   324: astore 9
    //   326: aload 9
    //   328: astore_0
    //   329: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +19 -> 351
    //   335: aload 9
    //   337: astore_0
    //   338: ldc 139
    //   340: iconst_2
    //   341: aload 10
    //   343: invokevirtual 460	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   346: aload 10
    //   348: invokestatic 351	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   351: aload 9
    //   353: ifnull -191 -> 162
    //   356: aload 9
    //   358: invokeinterface 454 1 0
    //   363: goto -201 -> 162
    //   366: astore_0
    //   367: aload 9
    //   369: astore_3
    //   370: aload_3
    //   371: ifnull +9 -> 380
    //   374: aload_3
    //   375: invokeinterface 454 1 0
    //   380: aload_0
    //   381: athrow
    //   382: aload 11
    //   384: invokestatic 423	java/util/Collections:sort	(Ljava/util/List;)V
    //   387: new 357	java/util/ArrayList
    //   390: dup
    //   391: invokespecial 358	java/util/ArrayList:<init>	()V
    //   394: astore_3
    //   395: iload_2
    //   396: aload 11
    //   398: invokeinterface 309 1 0
    //   403: invokestatic 466	java/lang/Math:min	(II)I
    //   406: istore_2
    //   407: iconst_0
    //   408: istore_1
    //   409: iload_1
    //   410: iload_2
    //   411: if_icmpge +25 -> 436
    //   414: aload_3
    //   415: aload 11
    //   417: iload_1
    //   418: invokeinterface 469 2 0
    //   423: invokeinterface 459 2 0
    //   428: pop
    //   429: iload_1
    //   430: iconst_1
    //   431: iadd
    //   432: istore_1
    //   433: goto -24 -> 409
    //   436: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   439: ifeq +62 -> 501
    //   442: new 141	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 471
    //   452: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: invokestatic 437	android/os/SystemClock:uptimeMillis	()J
    //   458: lload 6
    //   460: lsub
    //   461: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   464: ldc_w 473
    //   467: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: astore 9
    //   472: aload_3
    //   473: ifnull +30 -> 503
    //   476: aload_3
    //   477: invokeinterface 309 1 0
    //   482: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   485: astore_0
    //   486: ldc 139
    //   488: iconst_2
    //   489: aload 9
    //   491: aload_0
    //   492: invokevirtual 476	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   501: aload_3
    //   502: areturn
    //   503: ldc_w 478
    //   506: astore_0
    //   507: goto -21 -> 486
    //   510: astore 9
    //   512: aload_0
    //   513: astore_3
    //   514: aload 9
    //   516: astore_0
    //   517: goto -147 -> 370
    //   520: astore 10
    //   522: goto -196 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	525	0	paramContext	Context
    //   0	525	1	paramInt1	int
    //   0	525	2	paramInt2	int
    //   0	525	3	paramaglv	aglv
    //   0	525	4	paramLong	long
    //   3	456	6	l	long
    //   131	186	8	bool	boolean
    //   39	451	9	localObject1	Object
    //   510	5	9	localObject2	Object
    //   71	234	10	localObject3	Object
    //   321	26	10	localException1	Exception
    //   520	1	10	localException2	Exception
    //   63	353	11	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   65	116	321	java/lang/Exception
    //   65	116	366	finally
    //   122	130	510	finally
    //   136	150	510	finally
    //   329	335	510	finally
    //   338	351	510	finally
    //   122	130	520	java/lang/Exception
    //   136	150	520	java/lang/Exception
  }
  
  /* Error */
  public static List<LocalMediaInfo> a(Context paramContext, int paramInt1, int paramInt2, aglv paramaglv, boolean paramBoolean1, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 437	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 9
    //   5: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +30 -> 38
    //   11: ldc 139
    //   13: iconst_2
    //   14: new 141	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 481
    //   24: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: lload 9
    //   29: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   32: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aconst_null
    //   39: astore 12
    //   41: iload_2
    //   42: ifgt +14 -> 56
    //   45: new 441	java/lang/IllegalArgumentException
    //   48: dup
    //   49: ldc_w 443
    //   52: invokespecial 444	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   55: athrow
    //   56: new 357	java/util/ArrayList
    //   59: dup
    //   60: invokespecial 358	java/util/ArrayList:<init>	()V
    //   63: astore 13
    //   65: getstatic 67	android/os/Build$VERSION:SDK_INT	I
    //   68: bipush 16
    //   70: if_icmplt +336 -> 406
    //   73: iconst_1
    //   74: istore 8
    //   76: iload 8
    //   78: ifeq +148 -> 226
    //   81: iload 4
    //   83: ifeq +135 -> 218
    //   86: ldc_w 483
    //   89: astore 11
    //   91: aload_0
    //   92: aload 11
    //   94: iconst_3
    //   95: anewarray 69	java/lang/String
    //   98: dup
    //   99: iconst_0
    //   100: iload 5
    //   102: invokestatic 261	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: iload_1
    //   109: invokestatic 261	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   112: aastore
    //   113: dup
    //   114: iconst_2
    //   115: iload_1
    //   116: invokestatic 261	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   119: aastore
    //   120: iload_2
    //   121: invokestatic 485	bbbx:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   124: astore_0
    //   125: aload_0
    //   126: aload 13
    //   128: iload_1
    //   129: iload_2
    //   130: iload 8
    //   132: aload_3
    //   133: aload 6
    //   135: iload 7
    //   137: invokestatic 488	bbbx:a	(Landroid/database/Cursor;Ljava/util/List;IIZLaglv;Ljava/util/ArrayList;Z)V
    //   140: aload_0
    //   141: ifnull +9 -> 150
    //   144: aload_0
    //   145: invokeinterface 454 1 0
    //   150: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +62 -> 215
    //   156: new 141	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   163: ldc_w 490
    //   166: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokestatic 437	android/os/SystemClock:uptimeMillis	()J
    //   172: lload 9
    //   174: lsub
    //   175: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   178: ldc_w 492
    //   181: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: astore_3
    //   185: aload 13
    //   187: ifnull +188 -> 375
    //   190: aload 13
    //   192: invokeinterface 309 1 0
    //   197: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: astore_0
    //   201: ldc 139
    //   203: iconst_2
    //   204: aload_3
    //   205: aload_0
    //   206: invokevirtual 476	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload 13
    //   217: areturn
    //   218: ldc_w 494
    //   221: astore 11
    //   223: goto -132 -> 91
    //   226: iload 5
    //   228: ifle +90 -> 318
    //   231: new 141	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   238: ldc_w 496
    //   241: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: iload 5
    //   246: invokevirtual 371	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: ldc_w 498
    //   252: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc 73
    //   257: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: astore 11
    //   265: getstatic 250	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   268: invokevirtual 256	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   271: astore 14
    //   273: aload 14
    //   275: ldc_w 258
    //   278: iload_2
    //   279: bipush 6
    //   281: imul
    //   282: invokestatic 261	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   285: invokevirtual 267	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   288: pop
    //   289: aload 14
    //   291: invokevirtual 271	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   294: astore 14
    //   296: aload_0
    //   297: invokevirtual 277	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   300: aload 14
    //   302: getstatic 93	bbbx:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   305: aload 11
    //   307: aconst_null
    //   308: ldc_w 279
    //   311: invokevirtual 285	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   314: astore_0
    //   315: goto -190 -> 125
    //   318: ldc_w 449
    //   321: astore 11
    //   323: goto -58 -> 265
    //   326: astore_3
    //   327: aconst_null
    //   328: astore_0
    //   329: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +14 -> 346
    //   335: ldc 139
    //   337: iconst_2
    //   338: aload_3
    //   339: invokevirtual 460	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   342: aload_3
    //   343: invokestatic 351	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   346: aload_0
    //   347: ifnull -197 -> 150
    //   350: aload_0
    //   351: invokeinterface 454 1 0
    //   356: goto -206 -> 150
    //   359: astore_0
    //   360: aload 12
    //   362: astore_3
    //   363: aload_3
    //   364: ifnull +9 -> 373
    //   367: aload_3
    //   368: invokeinterface 454 1 0
    //   373: aload_0
    //   374: athrow
    //   375: ldc_w 478
    //   378: astore_0
    //   379: goto -178 -> 201
    //   382: astore 6
    //   384: aload_0
    //   385: astore_3
    //   386: aload 6
    //   388: astore_0
    //   389: goto -26 -> 363
    //   392: astore 6
    //   394: aload_0
    //   395: astore_3
    //   396: aload 6
    //   398: astore_0
    //   399: goto -36 -> 363
    //   402: astore_3
    //   403: goto -74 -> 329
    //   406: iconst_0
    //   407: istore 8
    //   409: goto -333 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	paramContext	Context
    //   0	412	1	paramInt1	int
    //   0	412	2	paramInt2	int
    //   0	412	3	paramaglv	aglv
    //   0	412	4	paramBoolean1	boolean
    //   0	412	5	paramInt3	int
    //   0	412	6	paramArrayList	ArrayList<String>
    //   0	412	7	paramBoolean2	boolean
    //   74	334	8	bool	boolean
    //   3	170	9	l	long
    //   89	233	11	str	String
    //   39	322	12	localObject1	Object
    //   63	153	13	localArrayList	ArrayList
    //   271	30	14	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   91	125	326	java/lang/Exception
    //   231	265	326	java/lang/Exception
    //   265	315	326	java/lang/Exception
    //   91	125	359	finally
    //   231	265	359	finally
    //   265	315	359	finally
    //   125	140	382	finally
    //   329	346	392	finally
    //   125	140	402	java/lang/Exception
  }
  
  /* Error */
  public static List<LocalMediaInfo> a(Context paramContext, int paramInt, List<String> paramList, aglv paramaglv)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 357	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 358	java/util/ArrayList:<init>	()V
    //   10: astore 5
    //   12: aload_2
    //   13: invokestatic 502	bbbx:a	(Ljava/util/List;)Ljava/lang/String;
    //   16: astore_2
    //   17: getstatic 250	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   20: invokevirtual 256	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   23: astore 6
    //   25: aload 6
    //   27: ldc_w 258
    //   30: iload_1
    //   31: invokestatic 261	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   34: invokevirtual 267	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   37: pop
    //   38: aload 6
    //   40: invokevirtual 271	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   43: astore 6
    //   45: aload_0
    //   46: invokevirtual 277	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   49: aload 6
    //   51: getstatic 93	bbbx:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   54: aload_2
    //   55: aconst_null
    //   56: ldc_w 279
    //   59: invokevirtual 285	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore_0
    //   63: aload_0
    //   64: aload 5
    //   66: iconst_0
    //   67: iload_1
    //   68: iconst_0
    //   69: aload_3
    //   70: aconst_null
    //   71: iconst_0
    //   72: invokestatic 488	bbbx:a	(Landroid/database/Cursor;Ljava/util/List;IIZLaglv;Ljava/util/ArrayList;Z)V
    //   75: aload_0
    //   76: ifnull +9 -> 85
    //   79: aload_0
    //   80: invokeinterface 454 1 0
    //   85: aload 5
    //   87: areturn
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_0
    //   91: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +14 -> 108
    //   97: ldc 139
    //   99: iconst_2
    //   100: aload_2
    //   101: invokevirtual 460	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   104: aload_2
    //   105: invokestatic 351	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_0
    //   109: ifnull -24 -> 85
    //   112: aload_0
    //   113: invokeinterface 454 1 0
    //   118: aload 5
    //   120: areturn
    //   121: astore_0
    //   122: aload 4
    //   124: astore_2
    //   125: aload_2
    //   126: ifnull +9 -> 135
    //   129: aload_2
    //   130: invokeinterface 454 1 0
    //   135: aload_0
    //   136: athrow
    //   137: astore_3
    //   138: aload_0
    //   139: astore_2
    //   140: aload_3
    //   141: astore_0
    //   142: goto -17 -> 125
    //   145: astore_3
    //   146: aload_0
    //   147: astore_2
    //   148: aload_3
    //   149: astore_0
    //   150: goto -25 -> 125
    //   153: astore_2
    //   154: goto -63 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramContext	Context
    //   0	157	1	paramInt	int
    //   0	157	2	paramList	List<String>
    //   0	157	3	paramaglv	aglv
    //   1	122	4	localObject1	Object
    //   10	109	5	localArrayList	ArrayList
    //   23	27	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   45	63	88	java/lang/Exception
    //   45	63	121	finally
    //   63	75	137	finally
    //   91	108	145	finally
    //   63	75	153	java/lang/Exception
  }
  
  /* Error */
  private static List<LocalMediaInfo> a(Context paramContext, String paramString, int paramInt, aglv paramaglv)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 357	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 358	java/util/ArrayList:<init>	()V
    //   13: astore 7
    //   15: aload_0
    //   16: aload_1
    //   17: aconst_null
    //   18: iload_2
    //   19: invokestatic 485	bbbx:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   22: astore_0
    //   23: getstatic 67	android/os/Build$VERSION:SDK_INT	I
    //   26: bipush 16
    //   28: if_icmplt +30 -> 58
    //   31: iconst_1
    //   32: istore 4
    //   34: aload_0
    //   35: aload 7
    //   37: iconst_m1
    //   38: iload_2
    //   39: iload 4
    //   41: aload_3
    //   42: invokestatic 507	bbbx:a	(Landroid/database/Cursor;Ljava/util/List;IIZLaglv;)V
    //   45: aload_0
    //   46: ifnull +9 -> 55
    //   49: aload_0
    //   50: invokeinterface 454 1 0
    //   55: aload 7
    //   57: areturn
    //   58: iconst_0
    //   59: istore 4
    //   61: goto -27 -> 34
    //   64: astore_1
    //   65: aload 6
    //   67: astore_0
    //   68: aload_0
    //   69: astore 5
    //   71: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +17 -> 91
    //   77: aload_0
    //   78: astore 5
    //   80: ldc 139
    //   82: iconst_2
    //   83: aload_1
    //   84: invokevirtual 460	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   87: aload_1
    //   88: invokestatic 351	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   91: aload_0
    //   92: ifnull -37 -> 55
    //   95: aload_0
    //   96: invokeinterface 454 1 0
    //   101: aload 7
    //   103: areturn
    //   104: astore_1
    //   105: aload 5
    //   107: astore_0
    //   108: aload_0
    //   109: ifnull +9 -> 118
    //   112: aload_0
    //   113: invokeinterface 454 1 0
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: goto -13 -> 108
    //   124: astore_1
    //   125: goto -57 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramContext	Context
    //   0	128	1	paramString	String
    //   0	128	2	paramInt	int
    //   0	128	3	paramaglv	aglv
    //   32	28	4	bool	boolean
    //   1	105	5	localContext	Context
    //   4	62	6	localObject	Object
    //   13	89	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   15	23	64	java/lang/Exception
    //   15	23	104	finally
    //   71	77	104	finally
    //   80	91	104	finally
    //   23	31	120	finally
    //   34	45	120	finally
    //   23	31	124	java/lang/Exception
    //   34	45	124	java/lang/Exception
  }
  
  /* Error */
  public static List<LocalMediaInfo> a(Context paramContext, String paramString1, String paramString2, int paramInt1, aglv paramaglv, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    // Byte code:
    //   0: new 357	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 358	java/util/ArrayList:<init>	()V
    //   7: astore 13
    //   9: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 139
    //   17: iconst_2
    //   18: ldc_w 511
    //   21: invokestatic 374	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: aconst_null
    //   25: astore 12
    //   27: new 141	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   34: astore 14
    //   36: iconst_0
    //   37: istore 10
    //   39: aload_2
    //   40: ifnull +13 -> 53
    //   43: ldc_w 513
    //   46: aload_1
    //   47: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifeq +6 -> 56
    //   53: iconst_1
    //   54: istore 10
    //   56: iload 10
    //   58: ifeq +18 -> 76
    //   61: iload_3
    //   62: ifgt +55 -> 117
    //   65: new 441	java/lang/IllegalArgumentException
    //   68: dup
    //   69: ldc_w 518
    //   72: invokespecial 444	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   75: athrow
    //   76: aload 14
    //   78: new 141	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 520
    //   88: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc_w 522
    //   98: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 14
    //   110: ldc_w 524
    //   113: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: getstatic 67	android/os/Build$VERSION:SDK_INT	I
    //   120: bipush 16
    //   122: if_icmplt +516 -> 638
    //   125: iconst_1
    //   126: istore 11
    //   128: iload 11
    //   130: ifeq +313 -> 443
    //   133: iload 7
    //   135: ifeq +194 -> 329
    //   138: aload 14
    //   140: new 141	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 526
    //   150: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 32	bbbx:jdField_a_of_type_Int	I
    //   156: invokevirtual 371	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: ldc_w 528
    //   162: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 89
    //   167: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: ldc_w 530
    //   173: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc 89
    //   178: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc_w 532
    //   184: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 91
    //   189: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc_w 530
    //   195: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 91
    //   200: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc_w 534
    //   206: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 91
    //   211: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc_w 536
    //   217: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc 89
    //   222: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc_w 538
    //   228: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc 91
    //   233: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc_w 536
    //   239: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc 89
    //   244: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc_w 540
    //   250: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_0
    //   261: aload 14
    //   263: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: iconst_3
    //   267: anewarray 69	java/lang/String
    //   270: dup
    //   271: iconst_0
    //   272: iload 5
    //   274: invokestatic 261	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: iload 6
    //   282: invokestatic 261	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   285: aastore
    //   286: dup
    //   287: iconst_2
    //   288: iload 6
    //   290: invokestatic 261	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   293: aastore
    //   294: iload_3
    //   295: invokestatic 485	bbbx:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   298: astore_0
    //   299: aload_0
    //   300: aload 13
    //   302: iload 6
    //   304: iload_3
    //   305: iload 11
    //   307: aload 4
    //   309: aload 8
    //   311: iload 9
    //   313: invokestatic 488	bbbx:a	(Landroid/database/Cursor;Ljava/util/List;IIZLaglv;Ljava/util/ArrayList;Z)V
    //   316: aload_0
    //   317: ifnull +9 -> 326
    //   320: aload_0
    //   321: invokeinterface 454 1 0
    //   326: aload 13
    //   328: areturn
    //   329: aload 14
    //   331: new 141	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   338: ldc_w 526
    //   341: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: getstatic 32	bbbx:jdField_a_of_type_Int	I
    //   347: invokevirtual 371	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: ldc_w 528
    //   353: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: ldc 89
    //   358: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc_w 530
    //   364: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc 89
    //   369: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: ldc_w 542
    //   375: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: ldc 91
    //   380: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: ldc_w 530
    //   386: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: ldc 91
    //   391: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: ldc_w 544
    //   397: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: goto -147 -> 260
    //   410: astore_1
    //   411: aconst_null
    //   412: astore_0
    //   413: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   416: ifeq +14 -> 430
    //   419: ldc 139
    //   421: iconst_2
    //   422: aload_1
    //   423: invokevirtual 460	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   426: aload_1
    //   427: invokestatic 351	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   430: aload_0
    //   431: ifnull -105 -> 326
    //   434: aload_0
    //   435: invokeinterface 454 1 0
    //   440: aload 13
    //   442: areturn
    //   443: iload 5
    //   445: ifle +115 -> 560
    //   448: aload 14
    //   450: new 141	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   457: ldc_w 496
    //   460: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: iload 5
    //   465: invokevirtual 371	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   468: ldc_w 546
    //   471: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: ldc 87
    //   476: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: ldc_w 548
    //   482: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: getstatic 32	bbbx:jdField_a_of_type_Int	I
    //   488: invokevirtual 371	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   491: ldc_w 550
    //   494: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: ldc 73
    //   499: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: getstatic 250	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   512: invokevirtual 256	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   515: astore_1
    //   516: aload_1
    //   517: ldc_w 258
    //   520: iload_3
    //   521: bipush 6
    //   523: imul
    //   524: invokestatic 261	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   527: invokevirtual 267	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   530: pop
    //   531: aload_1
    //   532: invokevirtual 271	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   535: astore_1
    //   536: aload_0
    //   537: invokevirtual 277	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   540: aload_1
    //   541: getstatic 93	bbbx:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   544: aload 14
    //   546: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: aconst_null
    //   550: ldc_w 279
    //   553: invokevirtual 285	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   556: astore_0
    //   557: goto -258 -> 299
    //   560: aload 14
    //   562: new 141	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   569: ldc_w 552
    //   572: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: getstatic 32	bbbx:jdField_a_of_type_Int	I
    //   578: invokevirtual 371	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   581: ldc_w 550
    //   584: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: ldc 73
    //   589: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: goto -90 -> 509
    //   602: astore_0
    //   603: aload 12
    //   605: astore_1
    //   606: aload_1
    //   607: ifnull +9 -> 616
    //   610: aload_1
    //   611: invokeinterface 454 1 0
    //   616: aload_0
    //   617: athrow
    //   618: astore_2
    //   619: aload_0
    //   620: astore_1
    //   621: aload_2
    //   622: astore_0
    //   623: goto -17 -> 606
    //   626: astore_2
    //   627: aload_0
    //   628: astore_1
    //   629: aload_2
    //   630: astore_0
    //   631: goto -25 -> 606
    //   634: astore_1
    //   635: goto -222 -> 413
    //   638: iconst_0
    //   639: istore 11
    //   641: goto -513 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	paramContext	Context
    //   0	644	1	paramString1	String
    //   0	644	2	paramString2	String
    //   0	644	3	paramInt1	int
    //   0	644	4	paramaglv	aglv
    //   0	644	5	paramInt2	int
    //   0	644	6	paramInt3	int
    //   0	644	7	paramBoolean1	boolean
    //   0	644	8	paramArrayList	ArrayList<String>
    //   0	644	9	paramBoolean2	boolean
    //   37	20	10	i	int
    //   126	514	11	bool	boolean
    //   25	579	12	localObject	Object
    //   7	434	13	localArrayList	ArrayList
    //   34	527	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   138	260	410	java/lang/Exception
    //   260	299	410	java/lang/Exception
    //   329	407	410	java/lang/Exception
    //   448	509	410	java/lang/Exception
    //   509	557	410	java/lang/Exception
    //   560	599	410	java/lang/Exception
    //   138	260	602	finally
    //   260	299	602	finally
    //   329	407	602	finally
    //   448	509	602	finally
    //   509	557	602	finally
    //   560	599	602	finally
    //   299	316	618	finally
    //   413	430	626	finally
    //   299	316	634	java/lang/Exception
  }
  
  public static List<LocalMediaInfo> a(Context paramContext, String paramString1, String paramString2, int paramInt1, aglv paramaglv, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2, long paramLong)
  {
    return a(paramContext, paramString1, paramString2, paramInt1, paramaglv, paramInt2, paramInt3, paramBoolean1, paramArrayList, paramBoolean2, paramLong, -1);
  }
  
  /* Error */
  public static List<LocalMediaInfo> a(Context paramContext, String paramString1, String paramString2, int paramInt1, aglv paramaglv, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2, long paramLong, int paramInt4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 19
    //   3: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +12 -> 18
    //   9: ldc 139
    //   11: iconst_2
    //   12: ldc_w 560
    //   15: invokestatic 374	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: ldc_w 562
    //   21: aload_1
    //   22: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +127 -> 152
    //   28: aload_0
    //   29: invokevirtual 277	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   32: getstatic 447	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   35: getstatic 97	bbbx:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   38: aconst_null
    //   39: aconst_null
    //   40: ldc_w 279
    //   43: invokevirtual 285	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore 16
    //   48: aload 16
    //   50: astore 17
    //   52: getstatic 67	android/os/Build$VERSION:SDK_INT	I
    //   55: bipush 16
    //   57: if_icmplt +47 -> 104
    //   60: iconst_1
    //   61: istore 15
    //   63: aload 16
    //   65: astore 17
    //   67: aload_0
    //   68: aload 16
    //   70: aconst_null
    //   71: iload_3
    //   72: aload 4
    //   74: iload 15
    //   76: lload 10
    //   78: invokestatic 564	bbbx:a	(Landroid/content/Context;Landroid/database/Cursor;Ljava/util/List;ILaglv;ZJ)Ljava/util/ArrayList;
    //   81: astore 18
    //   83: aload 18
    //   85: astore_0
    //   86: aload_0
    //   87: astore_1
    //   88: aload 16
    //   90: ifnull +12 -> 102
    //   93: aload 16
    //   95: invokeinterface 454 1 0
    //   100: aload_0
    //   101: astore_1
    //   102: aload_1
    //   103: areturn
    //   104: iconst_0
    //   105: istore 15
    //   107: goto -44 -> 63
    //   110: astore 18
    //   112: aconst_null
    //   113: astore 16
    //   115: aload 16
    //   117: astore 17
    //   119: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +18 -> 140
    //   125: aload 16
    //   127: astore 17
    //   129: ldc 139
    //   131: iconst_2
    //   132: ldc_w 566
    //   135: aload 18
    //   137: invokestatic 568	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: aload 16
    //   142: ifnull +10 -> 152
    //   145: aload 16
    //   147: invokeinterface 454 1 0
    //   152: aload 19
    //   154: astore 16
    //   156: aload 4
    //   158: ifnull +42 -> 200
    //   161: aload 19
    //   163: astore 16
    //   165: aload 4
    //   167: invokevirtual 570	aglv:a	()Z
    //   170: ifeq +30 -> 200
    //   173: iload 12
    //   175: iconst_1
    //   176: if_icmpne +229 -> 405
    //   179: aload_0
    //   180: aload_1
    //   181: aload_2
    //   182: iload_3
    //   183: aload 4
    //   185: iload 5
    //   187: iload 6
    //   189: iload 7
    //   191: aload 8
    //   193: iload 9
    //   195: invokestatic 572	bbbx:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILaglv;IIZLjava/util/ArrayList;Z)Ljava/util/List;
    //   198: astore 16
    //   200: aload 4
    //   202: ifnull +576 -> 778
    //   205: aload 4
    //   207: invokevirtual 574	aglv:b	()Z
    //   210: ifeq +568 -> 778
    //   213: aload_0
    //   214: aload_1
    //   215: aload_2
    //   216: iload_3
    //   217: aload 4
    //   219: lload 10
    //   221: invokestatic 577	bbbx:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILaglv;J)Ljava/util/List;
    //   224: astore_0
    //   225: ldc_w 513
    //   228: aload_1
    //   229: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   232: ifeq +63 -> 295
    //   235: invokestatic 437	android/os/SystemClock:uptimeMillis	()J
    //   238: lstore 10
    //   240: aload 16
    //   242: ifnull +8 -> 250
    //   245: aload 16
    //   247: invokestatic 423	java/util/Collections:sort	(Ljava/util/List;)V
    //   250: aload_0
    //   251: ifnull +7 -> 258
    //   254: aload_0
    //   255: invokestatic 423	java/util/Collections:sort	(Ljava/util/List;)V
    //   258: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +34 -> 295
    //   264: ldc 139
    //   266: iconst_2
    //   267: new 141	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 579
    //   277: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokestatic 437	android/os/SystemClock:uptimeMillis	()J
    //   283: lload 10
    //   285: lsub
    //   286: invokevirtual 238	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   289: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +73 -> 371
    //   301: new 141	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   308: ldc_w 581
    //   311: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: astore_2
    //   315: aload 16
    //   317: ifnull +112 -> 429
    //   320: aload 16
    //   322: invokeinterface 309 1 0
    //   327: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   330: astore_1
    //   331: aload_2
    //   332: aload_1
    //   333: invokevirtual 476	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   336: ldc_w 583
    //   339: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: astore_2
    //   343: aload_0
    //   344: ifnull +92 -> 436
    //   347: aload_0
    //   348: invokeinterface 309 1 0
    //   353: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   356: astore_1
    //   357: ldc 139
    //   359: iconst_2
    //   360: aload_2
    //   361: aload_1
    //   362: invokevirtual 476	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: aload_0
    //   372: ifnull +12 -> 384
    //   375: aload_0
    //   376: invokeinterface 586 1 0
    //   381: ifeq +62 -> 443
    //   384: aload 16
    //   386: areturn
    //   387: astore_0
    //   388: aconst_null
    //   389: astore 17
    //   391: aload 17
    //   393: ifnull +10 -> 403
    //   396: aload 17
    //   398: invokeinterface 454 1 0
    //   403: aload_0
    //   404: athrow
    //   405: aload_0
    //   406: aload_1
    //   407: aload_2
    //   408: iload_3
    //   409: aload 4
    //   411: iload 5
    //   413: iload 6
    //   415: iload 7
    //   417: aload 8
    //   419: iload 9
    //   421: invokestatic 588	bbbx:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILaglv;IIZLjava/util/ArrayList;Z)Ljava/util/List;
    //   424: astore 16
    //   426: goto -226 -> 200
    //   429: ldc_w 478
    //   432: astore_1
    //   433: goto -102 -> 331
    //   436: ldc_w 478
    //   439: astore_1
    //   440: goto -83 -> 357
    //   443: aload_0
    //   444: astore_1
    //   445: aload 16
    //   447: ifnull -345 -> 102
    //   450: aload_0
    //   451: astore_1
    //   452: aload 16
    //   454: invokeinterface 586 1 0
    //   459: ifne -357 -> 102
    //   462: aload 16
    //   464: invokeinterface 309 1 0
    //   469: istore 5
    //   471: iconst_0
    //   472: istore 6
    //   474: iconst_0
    //   475: istore 12
    //   477: iload 12
    //   479: aload_0
    //   480: invokeinterface 309 1 0
    //   485: if_icmpge +266 -> 751
    //   488: aload_0
    //   489: iload 12
    //   491: invokeinterface 469 2 0
    //   496: checkcast 125	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   499: astore_1
    //   500: aload 16
    //   502: iload 5
    //   504: iconst_1
    //   505: isub
    //   506: invokeinterface 469 2 0
    //   511: checkcast 125	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   514: astore_2
    //   515: aload_1
    //   516: getfield 408	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   519: aload_2
    //   520: getfield 408	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   523: lcmp
    //   524: ifgt +95 -> 619
    //   527: iload_3
    //   528: iconst_m1
    //   529: if_icmpne +39 -> 568
    //   532: iload 12
    //   534: aload_0
    //   535: invokeinterface 309 1 0
    //   540: if_icmpge +211 -> 751
    //   543: aload 16
    //   545: aload_0
    //   546: iload 12
    //   548: invokeinterface 469 2 0
    //   553: invokeinterface 459 2 0
    //   558: pop
    //   559: iload 12
    //   561: iconst_1
    //   562: iadd
    //   563: istore 12
    //   565: goto -33 -> 532
    //   568: aload_0
    //   569: invokeinterface 309 1 0
    //   574: iload 12
    //   576: isub
    //   577: iload_3
    //   578: iload 5
    //   580: isub
    //   581: invokestatic 466	java/lang/Math:min	(II)I
    //   584: istore 5
    //   586: iconst_0
    //   587: istore_3
    //   588: iload_3
    //   589: iload 5
    //   591: if_icmpge +160 -> 751
    //   594: aload 16
    //   596: aload_0
    //   597: iload_3
    //   598: iload 12
    //   600: iadd
    //   601: invokeinterface 469 2 0
    //   606: invokeinterface 459 2 0
    //   611: pop
    //   612: iload_3
    //   613: iconst_1
    //   614: iadd
    //   615: istore_3
    //   616: goto -28 -> 588
    //   619: iload 6
    //   621: istore 13
    //   623: iload 13
    //   625: iload 5
    //   627: if_icmpge +136 -> 763
    //   630: aload 16
    //   632: iload 13
    //   634: invokeinterface 469 2 0
    //   639: checkcast 125	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   642: astore_2
    //   643: aload_1
    //   644: getfield 408	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   647: aload_2
    //   648: getfield 408	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   651: lcmp
    //   652: ifgt +12 -> 664
    //   655: iload 13
    //   657: iconst_1
    //   658: iadd
    //   659: istore 13
    //   661: goto -38 -> 623
    //   664: aload 16
    //   666: iload 13
    //   668: aload_1
    //   669: invokeinterface 591 3 0
    //   674: iload_3
    //   675: iconst_m1
    //   676: if_icmpeq +24 -> 700
    //   679: aload 16
    //   681: invokeinterface 309 1 0
    //   686: iload_3
    //   687: if_icmple +13 -> 700
    //   690: aload 16
    //   692: iload 5
    //   694: invokeinterface 594 2 0
    //   699: pop
    //   700: aload 16
    //   702: invokeinterface 309 1 0
    //   707: istore 14
    //   709: iload 5
    //   711: istore 6
    //   713: iload 5
    //   715: iload 14
    //   717: if_icmpeq +7 -> 724
    //   720: iload 14
    //   722: istore 6
    //   724: iload 13
    //   726: iconst_1
    //   727: iadd
    //   728: istore 5
    //   730: iload 12
    //   732: iconst_1
    //   733: iadd
    //   734: istore 12
    //   736: iload 6
    //   738: istore 13
    //   740: iload 5
    //   742: istore 6
    //   744: iload 13
    //   746: istore 5
    //   748: goto -271 -> 477
    //   751: aload 16
    //   753: areturn
    //   754: astore_0
    //   755: goto -364 -> 391
    //   758: astore 18
    //   760: goto -645 -> 115
    //   763: iload 5
    //   765: istore 13
    //   767: iload 6
    //   769: istore 5
    //   771: iload 13
    //   773: istore 6
    //   775: goto -45 -> 730
    //   778: aconst_null
    //   779: astore_0
    //   780: goto -555 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	783	0	paramContext	Context
    //   0	783	1	paramString1	String
    //   0	783	2	paramString2	String
    //   0	783	3	paramInt1	int
    //   0	783	4	paramaglv	aglv
    //   0	783	5	paramInt2	int
    //   0	783	6	paramInt3	int
    //   0	783	7	paramBoolean1	boolean
    //   0	783	8	paramArrayList	ArrayList<String>
    //   0	783	9	paramBoolean2	boolean
    //   0	783	10	paramLong	long
    //   0	783	12	paramInt4	int
    //   621	151	13	i	int
    //   707	14	14	j	int
    //   61	45	15	bool	boolean
    //   46	706	16	localObject1	Object
    //   50	347	17	localObject2	Object
    //   81	3	18	localArrayList	ArrayList
    //   110	26	18	localException1	Exception
    //   758	1	18	localException2	Exception
    //   1	161	19	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   28	48	110	java/lang/Exception
    //   28	48	387	finally
    //   52	60	754	finally
    //   67	83	754	finally
    //   119	125	754	finally
    //   129	140	754	finally
    //   52	60	758	java/lang/Exception
    //   67	83	758	java/lang/Exception
  }
  
  /* Error */
  public static List<LocalMediaInfo> a(Context paramContext, String paramString1, String paramString2, int paramInt, aglv paramaglv, long paramLong)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +13 -> 14
    //   4: ldc_w 513
    //   7: aload_1
    //   8: invokevirtual 516	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: sipush 210
    //   18: iload_3
    //   19: aload 4
    //   21: lload 5
    //   23: invokestatic 597	bbbx:a	(Landroid/content/Context;IILaglv;J)Ljava/util/List;
    //   26: areturn
    //   27: new 357	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 358	java/util/ArrayList:<init>	()V
    //   34: astore 8
    //   36: new 141	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 520
    //   46: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 522
    //   56: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore_1
    //   63: aload_0
    //   64: invokevirtual 277	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   67: getstatic 447	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   70: getstatic 97	bbbx:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   73: aload_1
    //   74: aconst_null
    //   75: ldc_w 279
    //   78: invokevirtual 285	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   81: astore_1
    //   82: aload_1
    //   83: astore_0
    //   84: getstatic 67	android/os/Build$VERSION:SDK_INT	I
    //   87: bipush 16
    //   89: if_icmplt +35 -> 124
    //   92: iconst_1
    //   93: istore 7
    //   95: aload_1
    //   96: astore_0
    //   97: aload_1
    //   98: aload 8
    //   100: iload_3
    //   101: aload 4
    //   103: iload 7
    //   105: lload 5
    //   107: invokestatic 361	bbbx:a	(Landroid/database/Cursor;Ljava/util/List;ILaglv;ZJ)Ljava/util/List;
    //   110: pop
    //   111: aload_1
    //   112: ifnull +77 -> 189
    //   115: aload_1
    //   116: invokeinterface 454 1 0
    //   121: aload 8
    //   123: areturn
    //   124: iconst_0
    //   125: istore 7
    //   127: goto -32 -> 95
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_1
    //   134: astore_0
    //   135: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +15 -> 153
    //   141: aload_1
    //   142: astore_0
    //   143: ldc 139
    //   145: iconst_2
    //   146: ldc_w 566
    //   149: aload_2
    //   150: invokestatic 568	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload_1
    //   154: ifnull +35 -> 189
    //   157: aload_1
    //   158: invokeinterface 454 1 0
    //   163: aload 8
    //   165: areturn
    //   166: astore_1
    //   167: aconst_null
    //   168: astore_0
    //   169: aload_0
    //   170: ifnull +9 -> 179
    //   173: aload_0
    //   174: invokeinterface 454 1 0
    //   179: aload_1
    //   180: athrow
    //   181: astore_1
    //   182: goto -13 -> 169
    //   185: astore_2
    //   186: goto -53 -> 133
    //   189: aload 8
    //   191: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	Context
    //   0	192	1	paramString1	String
    //   0	192	2	paramString2	String
    //   0	192	3	paramInt	int
    //   0	192	4	paramaglv	aglv
    //   0	192	5	paramLong	long
    //   93	33	7	bool	boolean
    //   34	156	8	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   63	82	130	java/lang/Exception
    //   63	82	166	finally
    //   84	92	181	finally
    //   97	111	181	finally
    //   135	141	181	finally
    //   143	153	181	finally
    //   84	92	185	java/lang/Exception
    //   97	111	185	java/lang/Exception
  }
  
  /* Error */
  @android.annotation.TargetApi(10)
  private static List<LocalMediaInfo> a(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt, aglv paramaglv, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 606 1 0
    //   6: istore 7
    //   8: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +30 -> 41
    //   14: ldc 139
    //   16: iconst_2
    //   17: new 141	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 608
    //   27: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload 7
    //   32: invokevirtual 371	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 611	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: iload 7
    //   43: ifgt +7 -> 50
    //   46: aconst_null
    //   47: astore_0
    //   48: aload_0
    //   49: areturn
    //   50: aload_1
    //   51: astore 22
    //   53: aload_1
    //   54: ifnonnull +12 -> 66
    //   57: new 357	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 358	java/util/ArrayList:<init>	()V
    //   64: astore 22
    //   66: aload_0
    //   67: ldc 71
    //   69: invokeinterface 615 2 0
    //   74: istore 11
    //   76: aload_0
    //   77: ldc 73
    //   79: invokeinterface 615 2 0
    //   84: istore 12
    //   86: aload_0
    //   87: ldc 77
    //   89: invokeinterface 615 2 0
    //   94: istore 13
    //   96: aload_0
    //   97: ldc 79
    //   99: invokeinterface 615 2 0
    //   104: istore 14
    //   106: aload_0
    //   107: ldc 95
    //   109: invokeinterface 615 2 0
    //   114: istore 15
    //   116: aload_0
    //   117: ldc 75
    //   119: invokeinterface 615 2 0
    //   124: istore 16
    //   126: aload_0
    //   127: ldc 87
    //   129: invokeinterface 615 2 0
    //   134: istore 17
    //   136: iconst_0
    //   137: istore 8
    //   139: iconst_0
    //   140: istore 7
    //   142: iload 4
    //   144: ifeq +23 -> 167
    //   147: aload_0
    //   148: ldc 89
    //   150: invokeinterface 615 2 0
    //   155: istore 8
    //   157: aload_0
    //   158: ldc 91
    //   160: invokeinterface 615 2 0
    //   165: istore 7
    //   167: iconst_0
    //   168: istore 9
    //   170: aconst_null
    //   171: astore 24
    //   173: aload_0
    //   174: invokeinterface 618 1 0
    //   179: ifeq +421 -> 600
    //   182: aload_0
    //   183: iload 12
    //   185: invokeinterface 620 2 0
    //   190: astore 25
    //   192: aload 25
    //   194: invokestatic 625	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   197: ifne +18 -> 215
    //   200: new 187	java/io/File
    //   203: dup
    //   204: aload 25
    //   206: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;)V
    //   209: invokevirtual 628	java/io/File:exists	()Z
    //   212: ifne +57 -> 269
    //   215: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq -45 -> 173
    //   221: new 141	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   228: ldc_w 630
    //   231: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: astore 23
    //   236: aload 25
    //   238: ifnull +24 -> 262
    //   241: aload 25
    //   243: astore_1
    //   244: ldc 139
    //   246: iconst_2
    //   247: aload 23
    //   249: aload_1
    //   250: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 611	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: goto -86 -> 173
    //   262: ldc_w 478
    //   265: astore_1
    //   266: goto -22 -> 244
    //   269: aload_0
    //   270: iload 16
    //   272: invokeinterface 620 2 0
    //   277: astore 23
    //   279: aload_3
    //   280: ifnull +70 -> 350
    //   283: aload_3
    //   284: aload 23
    //   286: invokevirtual 458	aglv:a	(Ljava/lang/String;)Z
    //   289: ifeq +61 -> 350
    //   292: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq -122 -> 173
    //   298: aload 24
    //   300: astore_1
    //   301: aload 24
    //   303: ifnonnull +11 -> 314
    //   306: new 141	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   313: astore_1
    //   314: aload_1
    //   315: ldc_w 632
    //   318: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload 23
    //   323: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc_w 634
    //   329: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload 25
    //   334: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: ldc_w 636
    //   340: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_1
    //   345: astore 24
    //   347: goto -174 -> 173
    //   350: aload_0
    //   351: iload 13
    //   353: invokeinterface 640 2 0
    //   358: lstore 18
    //   360: aload_0
    //   361: iload 14
    //   363: invokeinterface 640 2 0
    //   368: lstore 20
    //   370: new 125	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   373: dup
    //   374: invokespecial 390	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   377: astore 26
    //   379: aload 26
    //   381: aload_0
    //   382: iload 11
    //   384: invokeinterface 640 2 0
    //   389: putfield 393	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   392: aload 26
    //   394: aload 25
    //   396: putfield 338	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   399: aload 26
    //   401: aload 23
    //   403: putfield 128	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   406: aload 26
    //   408: lload 18
    //   410: putfield 643	com/tencent/mobileqq/activity/photo/LocalMediaInfo:addedDate	J
    //   413: aload 26
    //   415: lload 20
    //   417: putfield 408	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   420: aload 26
    //   422: aload_0
    //   423: iload 15
    //   425: invokeinterface 640 2 0
    //   430: putfield 398	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   433: aload 26
    //   435: aload_0
    //   436: iload 17
    //   438: invokeinterface 640 2 0
    //   443: putfield 401	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   446: iload 4
    //   448: ifeq +243 -> 691
    //   451: aload 26
    //   453: aload_0
    //   454: iload 8
    //   456: invokeinterface 647 2 0
    //   461: putfield 650	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   464: aload 26
    //   466: aload_0
    //   467: iload 7
    //   469: invokeinterface 647 2 0
    //   474: putfield 653	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   477: aload 26
    //   479: getfield 398	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   482: lconst_0
    //   483: lcmp
    //   484: ifne +50 -> 534
    //   487: new 655	android/media/MediaMetadataRetriever
    //   490: dup
    //   491: invokespecial 656	android/media/MediaMetadataRetriever:<init>	()V
    //   494: astore 23
    //   496: aload 23
    //   498: astore_1
    //   499: aload 23
    //   501: aload 25
    //   503: invokevirtual 659	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   506: aload 23
    //   508: astore_1
    //   509: aload 26
    //   511: aload 23
    //   513: bipush 9
    //   515: invokevirtual 662	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   518: invokestatic 668	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   521: putfield 398	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   524: aload 23
    //   526: ifnull +8 -> 534
    //   529: aload 23
    //   531: invokevirtual 671	android/media/MediaMetadataRetriever:release	()V
    //   534: lload 5
    //   536: lconst_0
    //   537: lcmp
    //   538: ifle +14 -> 552
    //   541: aload 26
    //   543: getfield 398	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   546: lload 5
    //   548: lcmp
    //   549: ifgt -376 -> 173
    //   552: aload 22
    //   554: aload 26
    //   556: invokeinterface 459 2 0
    //   561: pop
    //   562: iload 9
    //   564: iconst_1
    //   565: iadd
    //   566: istore 10
    //   568: getstatic 672	bbbx:jdField_b_of_type_Long	J
    //   571: lload 20
    //   573: lcmp
    //   574: ifge +8 -> 582
    //   577: lload 20
    //   579: putstatic 672	bbbx:jdField_b_of_type_Long	J
    //   582: iload 10
    //   584: istore 9
    //   586: iload_2
    //   587: ifle -414 -> 173
    //   590: iload 10
    //   592: istore 9
    //   594: iload 10
    //   596: iload_2
    //   597: if_icmplt -424 -> 173
    //   600: aload 22
    //   602: astore_0
    //   603: aload 24
    //   605: ifnull -557 -> 48
    //   608: aload 22
    //   610: astore_0
    //   611: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   614: ifeq -566 -> 48
    //   617: ldc 139
    //   619: iconst_2
    //   620: aload 24
    //   622: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: aload 22
    //   630: areturn
    //   631: astore 25
    //   633: aconst_null
    //   634: astore 23
    //   636: aload 23
    //   638: astore_1
    //   639: aload 25
    //   641: invokevirtual 675	java/lang/Exception:printStackTrace	()V
    //   644: aload 23
    //   646: astore_1
    //   647: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +15 -> 665
    //   653: aload 23
    //   655: astore_1
    //   656: ldc 139
    //   658: iconst_2
    //   659: ldc_w 677
    //   662: invokestatic 611	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   665: aload 23
    //   667: ifnull -133 -> 534
    //   670: aload 23
    //   672: invokevirtual 671	android/media/MediaMetadataRetriever:release	()V
    //   675: goto -141 -> 534
    //   678: astore_0
    //   679: aconst_null
    //   680: astore_1
    //   681: aload_1
    //   682: ifnull +7 -> 689
    //   685: aload_1
    //   686: invokevirtual 671	android/media/MediaMetadataRetriever:release	()V
    //   689: aload_0
    //   690: athrow
    //   691: invokestatic 681	bfnz:d	()Z
    //   694: ifeq -160 -> 534
    //   697: new 655	android/media/MediaMetadataRetriever
    //   700: dup
    //   701: invokespecial 656	android/media/MediaMetadataRetriever:<init>	()V
    //   704: astore_1
    //   705: aload_1
    //   706: aload 25
    //   708: invokevirtual 659	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   711: aload_1
    //   712: bipush 18
    //   714: invokevirtual 662	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   717: astore 23
    //   719: aload_1
    //   720: bipush 19
    //   722: invokevirtual 662	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   725: astore 25
    //   727: aload_1
    //   728: invokevirtual 671	android/media/MediaMetadataRetriever:release	()V
    //   731: aload 26
    //   733: aload 23
    //   735: invokestatic 684	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   738: putfield 650	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   741: aload 26
    //   743: aload 25
    //   745: invokestatic 684	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   748: putfield 653	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   751: goto -217 -> 534
    //   754: astore_1
    //   755: aload 26
    //   757: iconst_0
    //   758: putfield 650	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   761: aload 26
    //   763: iconst_0
    //   764: putfield 653	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   767: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   770: ifeq -236 -> 534
    //   773: ldc 139
    //   775: iconst_2
    //   776: ldc_w 686
    //   779: invokestatic 611	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   782: goto -248 -> 534
    //   785: astore_0
    //   786: goto -105 -> 681
    //   789: astore 25
    //   791: goto -155 -> 636
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	794	0	paramCursor	Cursor
    //   0	794	1	paramList	List<LocalMediaInfo>
    //   0	794	2	paramInt	int
    //   0	794	3	paramaglv	aglv
    //   0	794	4	paramBoolean	boolean
    //   0	794	5	paramLong	long
    //   6	462	7	i	int
    //   137	318	8	j	int
    //   168	425	9	k	int
    //   566	32	10	m	int
    //   74	309	11	n	int
    //   84	100	12	i1	int
    //   94	258	13	i2	int
    //   104	258	14	i3	int
    //   114	310	15	i4	int
    //   124	147	16	i5	int
    //   134	303	17	i6	int
    //   358	51	18	l1	long
    //   368	210	20	l2	long
    //   51	578	22	localObject1	Object
    //   234	500	23	localObject2	Object
    //   171	450	24	localList	List<LocalMediaInfo>
    //   190	312	25	str1	String
    //   631	76	25	localException1	Exception
    //   725	19	25	str2	String
    //   789	1	25	localException2	Exception
    //   377	385	26	localLocalMediaInfo	LocalMediaInfo
    // Exception table:
    //   from	to	target	type
    //   487	496	631	java/lang/Exception
    //   487	496	678	finally
    //   731	751	754	java/lang/NumberFormatException
    //   499	506	785	finally
    //   509	524	785	finally
    //   639	644	785	finally
    //   647	653	785	finally
    //   656	665	785	finally
    //   499	506	789	java/lang/Exception
    //   509	524	789	java/lang/Exception
  }
  
  public static void a() {}
  
  public static void a(int paramInt1, int paramInt2)
  {
    axqy.b(null, "CliOper", "", "", "0X8009E99", "0X8009E99", 0, 0, paramInt1 + "", paramInt2 + "", "", "");
  }
  
  private static void a(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771992, 2130771993);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        a(paramActivity);
        return;
      }
      b(paramActivity);
      return;
    }
    if (paramBoolean2)
    {
      c(paramActivity);
      return;
    }
    d(paramActivity);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("album_file", 0).edit();
    paramContext.putString("album_key_id", jdField_b_of_type_JavaLangString);
    paramContext.putString("album_key_name", jdField_c_of_type_JavaLangString);
    paramContext.commit();
  }
  
  public static void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false))
    {
      String str = paramIntent.getStringExtra("ALBUM_ID");
      paramIntent = paramIntent.getStringExtra("PhotoConst.LAST_ALBUMPATH");
      if ((paramIntent != null) && (str != null))
      {
        jdField_a_of_type_JavaLangString = paramIntent;
        jdField_a_of_type_Long = System.currentTimeMillis();
      }
    }
  }
  
  public static void a(Intent paramIntent, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", paramBoolean);
      paramIntent.putExtra("ALBUM_ID", paramString1);
      paramIntent.putExtra("PhotoConst.LAST_ALBUMPATH", paramString2);
    }
  }
  
  private static void a(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, int paramInt2, boolean paramBoolean, aglv paramaglv)
  {
    a(paramCursor, paramList, paramInt1, paramInt2, paramBoolean, paramaglv, null, false);
  }
  
  private static void a(Cursor paramCursor, List<LocalMediaInfo> paramList, int paramInt1, int paramInt2, boolean paramBoolean1, aglv paramaglv, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    Object localObject1;
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int i11;
    int n;
    if (paramCursor.getCount() > 0)
    {
      localObject1 = paramList;
      if (paramList == null) {
        localObject1 = new ArrayList();
      }
      i3 = paramCursor.getColumnIndexOrThrow("_id");
      i4 = paramCursor.getColumnIndexOrThrow("_data");
      i5 = paramCursor.getColumnIndexOrThrow("orientation");
      i6 = paramCursor.getColumnIndexOrThrow("date_added");
      i7 = paramCursor.getColumnIndexOrThrow("date_modified");
      i8 = paramCursor.getColumnIndexOrThrow("mime_type");
      i9 = paramCursor.getColumnIndexOrThrow("_size");
      i10 = paramCursor.getColumnIndexOrThrow("latitude");
      i11 = paramCursor.getColumnIndexOrThrow("longitude");
      if (!paramBoolean1) {
        break label1305;
      }
      n = paramCursor.getColumnIndexOrThrow("width");
    }
    for (int m = paramCursor.getColumnIndexOrThrow("height");; m = 0)
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      int[] arrayOfInt = new int[2];
      if (QLog.isColorLevel()) {
        QLog.i("AlbumUtil", 2, "getImageList imageCursor count:" + paramCursor.getCount());
      }
      int k = 0;
      int i = 0;
      int j = 0;
      for (;;)
      {
        String str;
        label252:
        Object localObject2;
        if (paramCursor.moveToNext())
        {
          str = paramCursor.getString(i4);
          if (!apvd.b(str))
          {
            if (str == null)
            {
              i1 = j;
              j = i + 1;
              i = i1;
              if (!QLog.isColorLevel()) {
                break label1290;
              }
              localObject2 = new StringBuilder().append("getImageList file not exists:");
              if (str == null) {
                break label328;
              }
            }
            label328:
            for (paramList = str;; paramList = "null")
            {
              QLog.i("AlbumUtil", 2, paramList);
              i1 = j;
              j = i;
              i = i1;
              break;
              i1 = j + 1;
              j = i;
              i = i1;
              break label252;
            }
          }
          if ((paramArrayList != null) && (paramArrayList.size() > 0))
          {
            paramList = paramArrayList.iterator();
            do
            {
              if (!paramList.hasNext()) {
                break;
              }
            } while (!str.contains((String)paramList.next()));
          }
        }
        for (int i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {
            break label1288;
          }
          localObject2 = paramCursor.getString(i8);
          paramList = (List<LocalMediaInfo>)localObject2;
          if (paramaglv != null)
          {
            paramList = (List<LocalMediaInfo>)localObject2;
            if (paramaglv.a((String)localObject2))
            {
              if ((!"*/*".equals(localObject2)) && (!"image/*".equals(localObject2))) {
                break label972;
              }
              if ((str.indexOf(".jpg") == -1) && (str.indexOf(".jpeg") == -1)) {
                break label868;
              }
              paramList = "image/jpeg";
            }
          }
          label469:
          long l1 = paramCursor.getLong(i6);
          long l2 = paramCursor.getLong(i7);
          if (jdField_b_of_type_Long < l2) {
            jdField_b_of_type_Long = l2;
          }
          int i2 = 0;
          i1 = i2;
          if (paramBoolean1)
          {
            i1 = i2;
            if (paramCursor.getInt(n) == 0) {
              i1 = 1;
            }
          }
          long l3 = paramCursor.getLong(i3);
          if ((paramInt1 > 0) && ((!paramBoolean1) || (i1 != 0)))
          {
            a(str, localOptions, arrayOfInt);
            if ((arrayOfInt[0] < paramInt1) && (arrayOfInt[1] < paramInt1)) {
              break label1281;
            }
            localObject2 = new LocalMediaInfo();
            ((LocalMediaInfo)localObject2)._id = l3;
            ((LocalMediaInfo)localObject2).path = str;
            ((LocalMediaInfo)localObject2).addedDate = l1;
            ((LocalMediaInfo)localObject2).modifiedDate = l2;
            ((LocalMediaInfo)localObject2).orientation = paramCursor.getInt(i5);
            ((LocalMediaInfo)localObject2).mMimeType = paramList;
            ((LocalMediaInfo)localObject2).fileSize = paramCursor.getLong(i9);
            ((LocalMediaInfo)localObject2).mediaWidth = arrayOfInt[0];
            ((LocalMediaInfo)localObject2).mediaHeight = arrayOfInt[1];
            ((LocalMediaInfo)localObject2).latitude = ((int)(paramCursor.getDouble(i10) * 1000000.0D));
            ((LocalMediaInfo)localObject2).longitude = ((int)(paramCursor.getDouble(i11) * 1000000.0D));
            if (((((LocalMediaInfo)localObject2).mediaWidth <= 0) || (((LocalMediaInfo)localObject2).mediaHeight <= 0)) && (QLog.isColorLevel())) {
              QLog.i("AlbumUtil", 2, "no size " + str);
            }
            ((List)localObject1).add(localObject2);
            k += 1;
          }
          label1281:
          for (;;)
          {
            if ((paramInt2 > 0) && (k >= paramInt2))
            {
              if (!jdField_a_of_type_Boolean)
              {
                if ((i > 0) || (j > 0))
                {
                  paramCursor = new StringBuffer();
                  paramCursor.append("imagePathNullCount:");
                  paramCursor.append(i);
                  paramCursor.append(" imagePathFileNotExistCount:");
                  paramCursor.append(j);
                  paramCursor = paramCursor.toString();
                  if (i > 0) {
                    axrd.a("Album_Query_File_Path_Null", paramCursor);
                  }
                  if (j > 0) {
                    axrd.a("Album_Query_File_Not_Exist", paramCursor);
                  }
                }
                jdField_a_of_type_Boolean = true;
              }
              return;
              label868:
              if (str.indexOf(".gif") != -1)
              {
                paramList = "image/gif";
                break label469;
              }
              if (str.indexOf(".bmp") != -1)
              {
                paramList = "image/bmp";
                break label469;
              }
              if (str.indexOf(".png") != -1)
              {
                paramList = "image/png";
                break label469;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("AlbumUtil", 2, "Filter mime type:" + (String)localObject2 + ", path is " + str);
              break;
              label972:
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("AlbumUtil", 2, "Filter unknown " + (String)localObject2 + ", path is " + str);
              break;
              localObject2 = new LocalMediaInfo();
              ((LocalMediaInfo)localObject2)._id = l3;
              ((LocalMediaInfo)localObject2).path = str;
              ((LocalMediaInfo)localObject2).addedDate = paramCursor.getLong(i6);
              ((LocalMediaInfo)localObject2).modifiedDate = paramCursor.getLong(i7);
              ((LocalMediaInfo)localObject2).orientation = paramCursor.getInt(i5);
              ((LocalMediaInfo)localObject2).mMimeType = paramList;
              ((LocalMediaInfo)localObject2).fileSize = paramCursor.getLong(i9);
              ((LocalMediaInfo)localObject2).latitude = ((int)(paramCursor.getDouble(i10) * 1000000.0D));
              ((LocalMediaInfo)localObject2).longitude = ((int)(paramCursor.getDouble(i11) * 1000000.0D));
              if (paramBoolean1)
              {
                ((LocalMediaInfo)localObject2).mediaWidth = paramCursor.getInt(n);
                ((LocalMediaInfo)localObject2).mediaHeight = paramCursor.getInt(m);
              }
              if ((((LocalMediaInfo)localObject2).mediaWidth <= 0) || (((LocalMediaInfo)localObject2).mediaHeight <= 0))
              {
                a(str, localOptions, arrayOfInt);
                ((LocalMediaInfo)localObject2).mediaWidth = arrayOfInt[0];
                ((LocalMediaInfo)localObject2).mediaHeight = arrayOfInt[1];
              }
              if (((((LocalMediaInfo)localObject2).mediaWidth <= 0) || (((LocalMediaInfo)localObject2).mediaHeight <= 0)) && (QLog.isColorLevel())) {
                QLog.i("AlbumUtil", 2, "no size " + str);
              }
              ((List)localObject1).add(localObject2);
              k += 1;
              continue;
            }
            break;
          }
        }
        label1288:
        continue;
        label1290:
        i1 = j;
        j = i;
        i = i1;
      }
      label1305:
      n = 0;
    }
  }
  
  public static void a(TextView paramTextView, List<String> paramList, Map<String, LocalMediaInfo> paramMap1, boolean paramBoolean, Activity paramActivity, HashMap<String, PhotoSendParams> paramHashMap, Map<String, LocalMediaInfo> paramMap2)
  {
    Iterator localIterator = paramList.iterator();
    label254:
    label255:
    for (;;)
    {
      LocalMediaInfo localLocalMediaInfo;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (NetworkUtils.isNetworkUrl(str)) {
          continue;
        }
        localLocalMediaInfo = null;
        if (paramMap2 != null) {
          localLocalMediaInfo = (LocalMediaInfo)paramMap2.get(str);
        }
        if ((localLocalMediaInfo != null) || (paramMap1 == null)) {
          break label254;
        }
        localLocalMediaInfo = (LocalMediaInfo)paramMap1.get(str);
      }
      for (;;)
      {
        if ((localLocalMediaInfo == null) || (a(localLocalMediaInfo) != 1)) {
          break label255;
        }
        break;
        int i = a(paramList, paramMap1, paramBoolean, paramHashMap, paramMap2);
        if (i == 0) {
          paramTextView.setVisibility(4);
        }
        do
        {
          return;
          paramMap1 = PhotoUtils.a(paramActivity, i);
          if (paramMap1.equals("0"))
          {
            paramMap1 = "(999K)";
            paramTextView.setVisibility(4);
          }
          for (;;)
          {
            int j = paramMap1.length();
            i = 0;
            while (i < 6 - j)
            {
              paramMap1 = paramMap1 + " ";
              i += 1;
            }
            paramMap1 = "(" + paramMap1 + ")";
            paramTextView.setVisibility(0);
          }
          paramTextView.setText(paramMap1);
        } while (!paramList.isEmpty());
        paramTextView.setVisibility(4);
        return;
      }
    }
  }
  
  public static void a(LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      paramLocalMediaInfo.mediaHeight = localOptions.outHeight;
      paramLocalMediaInfo.mediaWidth = localOptions.outWidth;
      paramLocalMediaInfo.mMimeType = localOptions.outMimeType;
      paramLocalMediaInfo.addedDate = System.currentTimeMillis();
      paramLocalMediaInfo.modifiedDate = System.currentTimeMillis();
      paramLocalMediaInfo.path = paramString;
      paramLocalMediaInfo.panoramaPhotoType = 3;
      paramLocalMediaInfo.fileSize = new File(paramString).length();
      return;
    }
    catch (Exception paramLocalMediaInfo)
    {
      QLog.e("AlbumUtil", 2, "decode image error", paramLocalMediaInfo);
    }
  }
  
  private static void a(String paramString, BitmapFactory.Options paramOptions, int[] paramArrayOfInt)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localInteger == null) {}
    for (;;)
    {
      try
      {
        SafeBitmapFactory.decodeFile(paramString, paramOptions);
        k = paramOptions.outWidth;
      }
      catch (OutOfMemoryError paramString)
      {
        i = 0;
        j = 0;
        continue;
      }
      try
      {
        m = paramOptions.outHeight;
        i = m;
        j = k;
        if (k <= 65535)
        {
          i = m;
          j = k;
          if (m > 65535) {}
        }
      }
      catch (OutOfMemoryError paramString)
      {
        i = 0;
        j = k;
        continue;
      }
      try
      {
        i = paramOptions.outWidth;
        j = paramOptions.outHeight;
        jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(i << 16 & 0xFFFF0000 | j & 0xFFFF));
        j = k;
        i = m;
      }
      catch (OutOfMemoryError paramString)
      {
        i = m;
        j = k;
        continue;
      }
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      return;
      j = localInteger.intValue() >> 16 & 0xFFFF;
      i = localInteger.intValue() & 0xFFFF;
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(Context paramContext, int paramInt, LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if ((paramLocalMediaInfo != null) && (a(paramLocalMediaInfo) == 1)) {
      if (!paramBoolean) {
        break label222;
      }
    }
    label222:
    for (int i = b();; i = a())
    {
      paramBoolean = bool;
      if (paramInt >= i)
      {
        if (System.currentTimeMillis() - jdField_c_of_type_Long > 2000L)
        {
          bcql.a(paramContext, ajya.a(2131700220) + i + ajya.a(2131700221), 0).a();
          jdField_c_of_type_Long = System.currentTimeMillis();
        }
        paramBoolean = false;
      }
      long l = bgyp.b();
      if (paramLocalMediaInfo.fileSize > l)
      {
        bcql.a(paramContext, ajya.a(2131700219) + (float)l / 1024.0F / 1024.0F / 1024.0F + "G的视频", 0).a();
        paramBoolean = false;
      }
      if (paramLocalMediaInfo.mDuration <= 601000L) {
        break;
      }
      bcql.a(paramContext, ajya.a(2131700218) + 10L + ajya.a(2131700222), 0).a();
      return false;
    }
    return paramBoolean;
  }
  
  public static final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(List<String> paramList, Activity paramActivity, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.size() >= paramInt))
    {
      bcql.a(paramActivity, String.format(paramActivity.getResources().getString(2131718799), new Object[] { Integer.valueOf(paramInt) }), 0).b(paramActivity.getResources().getDimensionPixelSize(2131298865));
      return true;
    }
    return false;
  }
  
  public static int b()
  {
    return QzoneConfig.getInstance().getConfig("MiniVideo", "ShuoShuoMaxSelectVideoNum", 10);
  }
  
  public static String b(Context paramContext)
  {
    return paramContext.getSharedPreferences("album_file", 0).getString("album_key_name", null);
  }
  
  public static List<LocalMediaInfo> b(Context paramContext, String paramString1, String paramString2, int paramInt1, aglv paramaglv, int paramInt2, int paramInt3, boolean paramBoolean1, ArrayList<String> paramArrayList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("AlbumUtil", 2, "getAlbumPhotos");
    }
    if ((paramString2 == null) || ("$RecentAlbumId".equals(paramString1))) {
      paramContext = a(paramContext, paramInt3, paramInt1, paramaglv, paramBoolean1, paramInt2, paramArrayList, paramBoolean2);
    }
    do
    {
      do
      {
        return paramContext;
        paramString1 = a(paramContext, "bucket_id='" + paramString1 + "'", paramInt1, paramaglv);
        paramContext = paramString1;
      } while (paramString1 == null);
      paramContext = paramString1;
    } while (!QLog.isColorLevel());
    QLog.d("AlbumUtil", 2, "photo list size is:" + paramString1.size());
    return paramString1;
  }
  
  public static List<LocalMediaInfo> b(Context paramContext, String paramString1, String paramString2, int paramInt, aglv paramaglv, long paramLong)
  {
    return a(paramContext, paramString1, paramString2, paramInt, paramaglv, 0, -1, false, null, false, paramLong);
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_JavaLangString = null;
    jdField_c_of_type_JavaLangString = null;
  }
  
  private static void b(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771988, 2130771989);
  }
  
  public static void c()
  {
    jdField_c_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashMap.clear();
  }
  
  private static void c(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771979, 2130771980);
  }
  
  public static void d()
  {
    axqy.b(null, "CliOper", "", "", "0X8009E98", "0X8009E98", 0, 0, "", "", "", "");
  }
  
  private static void d(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771977, 2130771978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbx
 * JD-Core Version:    0.7.0.1
 */