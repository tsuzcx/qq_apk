package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogic.IalbumListAdapterCallBack;
import com.tencent.aelight.camera.ae.biz.circle.AECircleAlbumListFragment;
import com.tencent.aelight.camera.ae.biz.circle.AECircleAlbumListLogic;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper.Builder;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlbumListAdapter
  extends BaseAdapter
{
  public static final ColorDrawable a = new ColorDrawable(-2141891243);
  static final String[] f = { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "orientation", "mime_type", "COUNT(_data) as count" };
  static final String g;
  static String[] h;
  static final String[] i = { "_id", "_data", "duration", "date_modified", "mime_type", "_size" };
  static final String[] j = { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "mime_type", "COUNT(_data) as count" };
  AEAlbumListLogic.IalbumListAdapterCallBack b;
  public boolean c;
  List<QQAlbumInfo> d = new ArrayList();
  Handler e = new Handler();
  private final String k = BaseApplication.getContext().getResources().getString(2131895879);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_size>0 and ( _size < ");
    localStringBuilder.append(QAlbumUtil.CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE);
    localStringBuilder.append(" )  and (");
    localStringBuilder.append("width");
    localStringBuilder.append(">= 240 or ");
    localStringBuilder.append("width");
    localStringBuilder.append(" IS NULL) and (");
    localStringBuilder.append("height");
    localStringBuilder.append(">= 240 or ");
    localStringBuilder.append("height");
    localStringBuilder.append(" IS NULL )  and ");
    localStringBuilder.append("height");
    localStringBuilder.append("  * 1.0 / ");
    localStringBuilder.append("width");
    localStringBuilder.append(">= 0.45 and ");
    localStringBuilder.append("height");
    localStringBuilder.append("  * 1.0 / ");
    localStringBuilder.append("width");
    localStringBuilder.append("<= 2.2 and (");
    localStringBuilder.append("mime_type");
    localStringBuilder.append("='");
    localStringBuilder.append("image/jpeg");
    localStringBuilder.append("' or (");
    localStringBuilder.append("mime_type");
    localStringBuilder.append("='");
    localStringBuilder.append("*/*");
    localStringBuilder.append("' and ");
    localStringBuilder.append("_display_name");
    localStringBuilder.append(" LIKE'%.jpg%' )  or (");
    localStringBuilder.append("mime_type");
    localStringBuilder.append("='");
    localStringBuilder.append("*/*");
    localStringBuilder.append("' and ");
    localStringBuilder.append("_display_name");
    localStringBuilder.append(" LIKE'%.jpeg%' )  or (");
    localStringBuilder.append("mime_type");
    localStringBuilder.append("='");
    localStringBuilder.append("*/*");
    localStringBuilder.append("' and ");
    localStringBuilder.append("_display_name");
    localStringBuilder.append(" LIKE'%.bmp%' )  or (");
    localStringBuilder.append("mime_type");
    localStringBuilder.append("='");
    localStringBuilder.append("*/*");
    localStringBuilder.append("' and ");
    localStringBuilder.append("_display_name");
    localStringBuilder.append(" LIKE'%.png%' )  or ");
    localStringBuilder.append("mime_type");
    localStringBuilder.append(" LIKE'%");
    localStringBuilder.append("bmp");
    localStringBuilder.append("%' or ");
    localStringBuilder.append("mime_type");
    localStringBuilder.append(" LIKE'%");
    localStringBuilder.append("bitmap");
    localStringBuilder.append("%' or ");
    localStringBuilder.append("mime_type");
    localStringBuilder.append("='");
    localStringBuilder.append("image/png");
    localStringBuilder.append("'");
    g = localStringBuilder.toString();
    if (Build.VERSION.SDK_INT >= 16) {
      h = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size", "width" };
    } else {
      h = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size" };
    }
  }
  
  public AlbumListAdapter(AECircleAlbumListFragment paramAECircleAlbumListFragment)
  {
    this.b = paramAECircleAlbumListFragment.b.d;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = paramString.toLowerCase();
    if (paramString.equalsIgnoreCase("camera")) {
      return true;
    }
    return paramString.equalsIgnoreCase("100media");
  }
  
  public static QQAlbumInfo b(Context paramContext)
  {
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo.id = "$RecentAlbumId";
    localQQAlbumInfo.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    paramContext = new MediaQueryHelper.Builder().setEachCount(3).needImage(true).needVideo(true).build(paramContext);
    while ((!paramContext.mTraversalDone) && (paramContext.mediaList.isEmpty())) {
      paramContext.queryNext();
    }
    if (!paramContext.mediaList.isEmpty())
    {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramContext.mediaList.get(0));
      localQQAlbumInfo.coverDate = localQQAlbumInfo.mCoverInfo.modifiedDate;
    }
    paramContext.upDateCount();
    localQQAlbumInfo.mMediaFileCount = paramContext.cursorsCount;
    paramContext.close();
    return localQQAlbumInfo;
  }
  
  public QQAlbumInfo a(int paramInt)
  {
    return (QQAlbumInfo)this.d.get(paramInt);
  }
  
  /* Error */
  public QQAlbumInfo a(Context paramContext)
  {
    // Byte code:
    //   0: new 203	com/tencent/mobileqq/data/QQAlbumInfo
    //   3: dup
    //   4: invokespecial 204	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 286
    //   14: putfield 209	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   17: aload 6
    //   19: getstatic 289	com/tencent/mobileqq/activity/photo/album/QAlbumCustomAlbumConstants:VIDEO_ALBUM_NAME	Ljava/lang/String;
    //   22: putfield 217	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   25: aload 6
    //   27: iconst_0
    //   28: putfield 278	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   31: aconst_null
    //   32: astore 5
    //   34: aconst_null
    //   35: astore 4
    //   37: aconst_null
    //   38: astore_3
    //   39: aload 5
    //   41: astore_2
    //   42: getstatic 295	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   45: astore 7
    //   47: aload 5
    //   49: astore_2
    //   50: aload_1
    //   51: invokevirtual 301	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   54: aload 7
    //   56: getstatic 144	com/tencent/aelight/camera/ae/biz/circle/adapter/AlbumListAdapter:i	[Ljava/lang/String;
    //   59: ldc_w 303
    //   62: aconst_null
    //   63: ldc_w 305
    //   66: invokevirtual 311	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   69: astore_1
    //   70: iconst_2
    //   71: invokestatic 317	com/tencent/mobileqq/activity/photo/MediaFileFilter:getFilter	(I)Lcom/tencent/mobileqq/activity/photo/MediaFileFilter;
    //   74: astore 4
    //   76: aload_3
    //   77: astore_2
    //   78: aload 4
    //   80: ifnull +12 -> 92
    //   83: aload_0
    //   84: aload_1
    //   85: iconst_m1
    //   86: aload 4
    //   88: invokevirtual 320	com/tencent/aelight/camera/ae/biz/circle/adapter/AlbumListAdapter:a	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   91: astore_2
    //   92: invokestatic 323	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   95: invokestatic 329	com/tencent/mobileqq/activity/photo/MediaScanner:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/activity/photo/MediaScanner;
    //   98: iconst_0
    //   99: iconst_m1
    //   100: invokevirtual 333	com/tencent/mobileqq/activity/photo/MediaScanner:getMediaScannerInfos	(ZI)Ljava/util/ArrayList;
    //   103: astore_3
    //   104: aload_2
    //   105: ifnull +44 -> 149
    //   108: aload_2
    //   109: invokeinterface 249 1 0
    //   114: ifne +35 -> 149
    //   117: aload 6
    //   119: aload 6
    //   121: getfield 278	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   124: aload_2
    //   125: invokeinterface 337 1 0
    //   130: iadd
    //   131: putfield 278	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   134: aload 6
    //   136: aload_2
    //   137: iconst_0
    //   138: invokeinterface 256 2 0
    //   143: checkcast 258	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   146: putfield 262	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   149: aload_3
    //   150: ifnull +152 -> 302
    //   153: aload_3
    //   154: invokevirtual 338	java/util/ArrayList:isEmpty	()Z
    //   157: ifne +145 -> 302
    //   160: aload 6
    //   162: aload 6
    //   164: getfield 278	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   167: aload_3
    //   168: invokevirtual 339	java/util/ArrayList:size	()I
    //   171: iadd
    //   172: putfield 278	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   175: aload_3
    //   176: iconst_0
    //   177: invokevirtual 340	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   180: checkcast 342	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   183: astore_2
    //   184: aload 6
    //   186: getfield 262	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   189: ifnull +19 -> 208
    //   192: aload 6
    //   194: getfield 262	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   197: getfield 266	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   200: aload_2
    //   201: getfield 343	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   204: lcmp
    //   205: ifge +97 -> 302
    //   208: aload 6
    //   210: new 258	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   213: dup
    //   214: invokespecial 344	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   217: putfield 262	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   220: aload 6
    //   222: getfield 262	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   225: aload_2
    //   226: getfield 346	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   229: i2l
    //   230: putfield 348	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   233: aload 6
    //   235: getfield 262	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   238: aload_2
    //   239: getfield 350	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   242: putfield 353	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   245: aload 6
    //   247: getfield 262	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   250: aload_2
    //   251: getfield 356	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   254: putfield 357	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   257: aload 6
    //   259: getfield 262	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   262: aload_2
    //   263: getfield 360	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   266: putfield 361	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   269: aload 6
    //   271: getfield 262	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   274: aload_2
    //   275: getfield 343	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   278: putfield 266	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   281: aload 6
    //   283: getfield 262	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   286: aload_2
    //   287: getfield 364	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   290: putfield 367	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   293: aload 6
    //   295: getfield 262	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   298: iconst_0
    //   299: putfield 370	com/tencent/mobileqq/activity/photo/LocalMediaInfo:isSystemMeidaStore	Z
    //   302: aload_1
    //   303: ifnull +64 -> 367
    //   306: aload_1
    //   307: invokeinterface 373 1 0
    //   312: aload 6
    //   314: areturn
    //   315: astore_2
    //   316: goto +54 -> 370
    //   319: astore_3
    //   320: goto +15 -> 335
    //   323: astore_3
    //   324: aload_2
    //   325: astore_1
    //   326: aload_3
    //   327: astore_2
    //   328: goto +42 -> 370
    //   331: astore_3
    //   332: aload 4
    //   334: astore_1
    //   335: aload_1
    //   336: astore_2
    //   337: invokestatic 378	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq +17 -> 357
    //   343: aload_1
    //   344: astore_2
    //   345: ldc_w 380
    //   348: iconst_2
    //   349: aload_3
    //   350: invokevirtual 383	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   353: aload_3
    //   354: invokestatic 386	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   357: aload_1
    //   358: ifnull +9 -> 367
    //   361: aload_1
    //   362: invokeinterface 373 1 0
    //   367: aload 6
    //   369: areturn
    //   370: aload_1
    //   371: ifnull +9 -> 380
    //   374: aload_1
    //   375: invokeinterface 373 1 0
    //   380: aload_2
    //   381: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	this	AlbumListAdapter
    //   0	382	1	paramContext	Context
    //   41	246	2	localObject1	Object
    //   315	10	2	localObject2	Object
    //   327	54	2	localObject3	Object
    //   38	138	3	localArrayList	ArrayList
    //   319	1	3	localException1	java.lang.Exception
    //   323	4	3	localObject4	Object
    //   331	23	3	localException2	java.lang.Exception
    //   35	298	4	localMediaFileFilter	MediaFileFilter
    //   32	16	5	localObject5	Object
    //   7	361	6	localQQAlbumInfo	QQAlbumInfo
    //   45	10	7	localUri	android.net.Uri
    // Exception table:
    //   from	to	target	type
    //   70	76	315	finally
    //   83	92	315	finally
    //   92	104	315	finally
    //   108	149	315	finally
    //   153	208	315	finally
    //   208	302	315	finally
    //   70	76	319	java/lang/Exception
    //   83	92	319	java/lang/Exception
    //   92	104	319	java/lang/Exception
    //   108	149	319	java/lang/Exception
    //   153	208	319	java/lang/Exception
    //   208	302	319	java/lang/Exception
    //   42	47	323	finally
    //   50	70	323	finally
    //   337	343	323	finally
    //   345	357	323	finally
    //   42	47	331	java/lang/Exception
    //   50	70	331	java/lang/Exception
  }
  
  /* Error */
  public List<QQAlbumInfo> a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 14
    //   3: aconst_null
    //   4: astore 15
    //   6: aconst_null
    //   7: astore 13
    //   9: iload_2
    //   10: ifge +11 -> 21
    //   13: getstatic 390	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   16: astore 12
    //   18: goto +539 -> 557
    //   21: getstatic 390	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   24: invokevirtual 396	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   27: astore 12
    //   29: aload 12
    //   31: ldc_w 398
    //   34: iload_2
    //   35: invokestatic 401	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   38: invokevirtual 407	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   41: pop
    //   42: aload 12
    //   44: invokevirtual 410	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   47: astore 12
    //   49: goto +508 -> 557
    //   52: aload_1
    //   53: invokevirtual 301	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   56: astore 16
    //   58: getstatic 54	com/tencent/aelight/camera/ae/biz/circle/adapter/AlbumListAdapter:f	[Ljava/lang/String;
    //   61: astore 17
    //   63: aload 15
    //   65: astore_1
    //   66: aload 16
    //   68: aload 12
    //   70: aload 17
    //   72: aload_0
    //   73: getfield 189	com/tencent/aelight/camera/ae/biz/circle/adapter/AlbumListAdapter:b	Lcom/tencent/aelight/camera/ae/album/logic/AEAlbumListLogic$IalbumListAdapterCallBack;
    //   76: invokeinterface 414 1 0
    //   81: aconst_null
    //   82: ldc_w 416
    //   85: invokevirtual 311	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore 13
    //   90: aload 13
    //   92: ifnonnull +17 -> 109
    //   95: aload 13
    //   97: ifnull +10 -> 107
    //   100: aload 13
    //   102: invokeinterface 373 1 0
    //   107: aconst_null
    //   108: areturn
    //   109: new 418	java/util/LinkedList
    //   112: dup
    //   113: invokespecial 419	java/util/LinkedList:<init>	()V
    //   116: astore_1
    //   117: aload 13
    //   119: ldc 38
    //   121: invokeinterface 423 2 0
    //   126: istore_2
    //   127: aload 13
    //   129: ldc 40
    //   131: invokeinterface 423 2 0
    //   136: istore_3
    //   137: aload 13
    //   139: ldc 46
    //   141: invokeinterface 423 2 0
    //   146: istore 4
    //   148: aload 13
    //   150: ldc 44
    //   152: invokeinterface 423 2 0
    //   157: istore 5
    //   159: aload 13
    //   161: ldc 136
    //   163: invokeinterface 423 2 0
    //   168: istore 6
    //   170: aload 13
    //   172: ldc 48
    //   174: invokeinterface 423 2 0
    //   179: istore 7
    //   181: aload 13
    //   183: ldc 50
    //   185: invokeinterface 423 2 0
    //   190: istore 8
    //   192: aload 13
    //   194: ldc_w 425
    //   197: invokeinterface 423 2 0
    //   202: istore 9
    //   204: aload 13
    //   206: invokeinterface 428 1 0
    //   211: ifeq +204 -> 415
    //   214: aload 13
    //   216: iload_2
    //   217: invokeinterface 429 2 0
    //   222: astore 15
    //   224: aload 13
    //   226: iload_3
    //   227: invokeinterface 429 2 0
    //   232: astore 16
    //   234: aload 15
    //   236: invokestatic 434	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   239: ifne -35 -> 204
    //   242: aload 16
    //   244: invokestatic 434	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifeq +6 -> 253
    //   250: goto -46 -> 204
    //   253: aload 13
    //   255: iload 4
    //   257: invokeinterface 429 2 0
    //   262: astore 12
    //   264: aload 13
    //   266: iload 5
    //   268: invokeinterface 438 2 0
    //   273: lstore 10
    //   275: new 203	com/tencent/mobileqq/data/QQAlbumInfo
    //   278: dup
    //   279: invokespecial 204	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   282: astore 14
    //   284: aload 14
    //   286: aload 16
    //   288: putfield 217	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   291: aload 14
    //   293: aload 15
    //   295: putfield 209	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   298: aload 14
    //   300: lload 10
    //   302: putfield 269	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   305: aload 14
    //   307: getfield 262	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   310: astore 15
    //   312: aload 15
    //   314: aload 12
    //   316: putfield 361	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   319: aload 15
    //   321: aload 13
    //   323: iload 6
    //   325: invokeinterface 438 2 0
    //   330: putfield 348	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   333: aload 15
    //   335: lload 10
    //   337: putfield 266	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   340: aload 15
    //   342: aload 13
    //   344: iload 7
    //   346: invokeinterface 442 2 0
    //   351: putfield 444	com/tencent/mobileqq/activity/photo/LocalMediaInfo:orientation	I
    //   354: aload 15
    //   356: aload 13
    //   358: iload 8
    //   360: invokeinterface 429 2 0
    //   365: putfield 367	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   368: ldc 99
    //   370: aload 15
    //   372: getfield 367	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   375: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   378: ifeq +11 -> 389
    //   381: aload 15
    //   383: ldc_w 450
    //   386: putfield 367	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   389: aload 14
    //   391: aload 13
    //   393: iload 9
    //   395: invokeinterface 442 2 0
    //   400: putfield 278	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   403: aload_1
    //   404: aload 14
    //   406: invokeinterface 453 2 0
    //   411: pop
    //   412: goto -208 -> 204
    //   415: aload_1
    //   416: astore 14
    //   418: aload 13
    //   420: ifnull +110 -> 530
    //   423: aload 13
    //   425: invokeinterface 373 1 0
    //   430: aload_1
    //   431: areturn
    //   432: astore 12
    //   434: goto +15 -> 449
    //   437: astore 12
    //   439: aload 13
    //   441: astore_1
    //   442: goto +96 -> 538
    //   445: astore 12
    //   447: aconst_null
    //   448: astore_1
    //   449: aload 12
    //   451: astore 14
    //   453: aload 13
    //   455: astore 12
    //   457: aload_1
    //   458: astore 13
    //   460: goto +26 -> 486
    //   463: astore_1
    //   464: goto +12 -> 476
    //   467: astore 12
    //   469: aload 13
    //   471: astore_1
    //   472: goto +66 -> 538
    //   475: astore_1
    //   476: aconst_null
    //   477: astore 13
    //   479: aload 14
    //   481: astore 12
    //   483: aload_1
    //   484: astore 14
    //   486: aload 12
    //   488: astore_1
    //   489: invokestatic 378	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq +18 -> 510
    //   495: aload 12
    //   497: astore_1
    //   498: ldc_w 455
    //   501: iconst_2
    //   502: ldc_w 457
    //   505: aload 14
    //   507: invokestatic 459	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   510: aload 13
    //   512: astore 14
    //   514: aload 12
    //   516: ifnull +14 -> 530
    //   519: aload 12
    //   521: invokeinterface 373 1 0
    //   526: aload 13
    //   528: astore 14
    //   530: aload 14
    //   532: areturn
    //   533: astore 12
    //   535: goto -63 -> 472
    //   538: aload_1
    //   539: ifnull +9 -> 548
    //   542: aload_1
    //   543: invokeinterface 373 1 0
    //   548: goto +6 -> 554
    //   551: aload 12
    //   553: athrow
    //   554: goto -3 -> 551
    //   557: goto -505 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	560	0	this	AlbumListAdapter
    //   0	560	1	paramContext	Context
    //   0	560	2	paramInt	int
    //   136	91	3	m	int
    //   146	110	4	n	int
    //   157	110	5	i1	int
    //   168	156	6	i2	int
    //   179	166	7	i3	int
    //   190	169	8	i4	int
    //   202	192	9	i5	int
    //   273	63	10	l	long
    //   16	299	12	localObject1	Object
    //   432	1	12	localException1	java.lang.Exception
    //   437	1	12	localObject2	Object
    //   445	5	12	localException2	java.lang.Exception
    //   455	1	12	localObject3	Object
    //   467	1	12	localObject4	Object
    //   481	39	12	localObject5	Object
    //   533	19	12	localObject6	Object
    //   7	520	13	localObject7	Object
    //   1	530	14	localObject8	Object
    //   4	378	15	localObject9	Object
    //   56	231	16	localObject10	Object
    //   61	10	17	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   117	204	432	java/lang/Exception
    //   204	250	432	java/lang/Exception
    //   253	389	432	java/lang/Exception
    //   389	412	432	java/lang/Exception
    //   109	117	437	finally
    //   117	204	437	finally
    //   204	250	437	finally
    //   253	389	437	finally
    //   389	412	437	finally
    //   109	117	445	java/lang/Exception
    //   66	90	463	java/lang/Exception
    //   13	18	467	finally
    //   21	49	467	finally
    //   52	63	467	finally
    //   13	18	475	java/lang/Exception
    //   21	49	475	java/lang/Exception
    //   52	63	475	java/lang/Exception
    //   66	90	533	finally
    //   489	495	533	finally
    //   498	510	533	finally
  }
  
  /* Error */
  public List<QQAlbumInfo> a(Context paramContext, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 14
    //   6: iload_2
    //   7: ifge +14 -> 21
    //   10: aload 14
    //   12: astore_3
    //   13: getstatic 295	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   16: astore 12
    //   18: goto +447 -> 465
    //   21: aload 14
    //   23: astore_3
    //   24: getstatic 295	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   27: invokevirtual 396	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   30: astore 12
    //   32: aload 14
    //   34: astore_3
    //   35: aload 12
    //   37: ldc_w 398
    //   40: iload_2
    //   41: invokestatic 401	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   44: invokevirtual 407	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   47: pop
    //   48: aload 14
    //   50: astore_3
    //   51: aload 12
    //   53: invokevirtual 410	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   56: astore 12
    //   58: goto +407 -> 465
    //   61: aload 14
    //   63: astore_3
    //   64: aload_1
    //   65: invokevirtual 301	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   68: aload 12
    //   70: getstatic 146	com/tencent/aelight/camera/ae/biz/circle/adapter/AlbumListAdapter:j	[Ljava/lang/String;
    //   73: ldc_w 464
    //   76: aconst_null
    //   77: ldc_w 416
    //   80: invokevirtual 311	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 12
    //   85: aload 12
    //   87: ifnonnull +17 -> 104
    //   90: aload 12
    //   92: ifnull +10 -> 102
    //   95: aload 12
    //   97: invokeinterface 373 1 0
    //   102: aconst_null
    //   103: areturn
    //   104: new 418	java/util/LinkedList
    //   107: dup
    //   108: invokespecial 419	java/util/LinkedList:<init>	()V
    //   111: astore_1
    //   112: aload 12
    //   114: ldc 38
    //   116: invokeinterface 423 2 0
    //   121: istore_2
    //   122: aload 12
    //   124: ldc 136
    //   126: invokeinterface 423 2 0
    //   131: istore 4
    //   133: aload 12
    //   135: ldc 40
    //   137: invokeinterface 423 2 0
    //   142: istore 5
    //   144: aload 12
    //   146: ldc 46
    //   148: invokeinterface 423 2 0
    //   153: istore 6
    //   155: aload 12
    //   157: ldc 44
    //   159: invokeinterface 423 2 0
    //   164: istore 7
    //   166: aload 12
    //   168: ldc 50
    //   170: invokeinterface 423 2 0
    //   175: istore 8
    //   177: aload 12
    //   179: ldc_w 425
    //   182: invokeinterface 423 2 0
    //   187: istore 9
    //   189: aload 12
    //   191: invokeinterface 428 1 0
    //   196: ifeq +159 -> 355
    //   199: aload 12
    //   201: iload_2
    //   202: invokeinterface 429 2 0
    //   207: astore 13
    //   209: aload 12
    //   211: iload 5
    //   213: invokeinterface 429 2 0
    //   218: astore 14
    //   220: aload 13
    //   222: invokestatic 434	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   225: ifne -36 -> 189
    //   228: aload 14
    //   230: invokestatic 434	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifeq +6 -> 239
    //   236: goto -47 -> 189
    //   239: aload 12
    //   241: iload 7
    //   243: invokeinterface 438 2 0
    //   248: lstore 10
    //   250: new 203	com/tencent/mobileqq/data/QQAlbumInfo
    //   253: dup
    //   254: invokespecial 204	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   257: astore_3
    //   258: aload_3
    //   259: aload 14
    //   261: putfield 217	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   264: aload_3
    //   265: aload 13
    //   267: putfield 209	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   270: aload_3
    //   271: lload 10
    //   273: putfield 269	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   276: aload_3
    //   277: getfield 262	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   280: astore 13
    //   282: aload 13
    //   284: aload 12
    //   286: iload 6
    //   288: invokeinterface 429 2 0
    //   293: putfield 361	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   296: aload 13
    //   298: aload 12
    //   300: iload 4
    //   302: invokeinterface 438 2 0
    //   307: putfield 348	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   310: aload 13
    //   312: lload 10
    //   314: putfield 266	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   317: aload 13
    //   319: aload 12
    //   321: iload 8
    //   323: invokeinterface 429 2 0
    //   328: putfield 367	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   331: aload_3
    //   332: aload 12
    //   334: iload 9
    //   336: invokeinterface 442 2 0
    //   341: putfield 278	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   344: aload_1
    //   345: aload_3
    //   346: invokeinterface 453 2 0
    //   351: pop
    //   352: goto -163 -> 189
    //   355: aload_1
    //   356: astore_3
    //   357: aload 12
    //   359: ifnull +86 -> 445
    //   362: aload 12
    //   364: invokeinterface 373 1 0
    //   369: aload_1
    //   370: areturn
    //   371: astore_3
    //   372: goto +13 -> 385
    //   375: astore_1
    //   376: aload 12
    //   378: astore_3
    //   379: goto +68 -> 447
    //   382: astore_3
    //   383: aconst_null
    //   384: astore_1
    //   385: aload_3
    //   386: astore 13
    //   388: goto +17 -> 405
    //   391: astore_1
    //   392: goto +55 -> 447
    //   395: astore_3
    //   396: aconst_null
    //   397: astore_1
    //   398: aload 13
    //   400: astore 12
    //   402: aload_3
    //   403: astore 13
    //   405: aload 12
    //   407: astore_3
    //   408: invokestatic 378	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +18 -> 429
    //   414: aload 12
    //   416: astore_3
    //   417: ldc_w 455
    //   420: iconst_2
    //   421: ldc_w 466
    //   424: aload 13
    //   426: invokestatic 459	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   429: aload_1
    //   430: astore_3
    //   431: aload 12
    //   433: ifnull +12 -> 445
    //   436: aload 12
    //   438: invokeinterface 373 1 0
    //   443: aload_1
    //   444: astore_3
    //   445: aload_3
    //   446: areturn
    //   447: aload_3
    //   448: ifnull +9 -> 457
    //   451: aload_3
    //   452: invokeinterface 373 1 0
    //   457: goto +5 -> 462
    //   460: aload_1
    //   461: athrow
    //   462: goto -2 -> 460
    //   465: goto -404 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	AlbumListAdapter
    //   0	468	1	paramContext	Context
    //   0	468	2	paramInt	int
    //   0	468	3	paramMediaFileFilter	MediaFileFilter
    //   131	170	4	m	int
    //   142	70	5	n	int
    //   153	134	6	i1	int
    //   164	78	7	i2	int
    //   175	147	8	i3	int
    //   187	148	9	i4	int
    //   248	65	10	l	long
    //   16	421	12	localObject1	Object
    //   1	424	13	localObject2	Object
    //   4	256	14	str	String
    // Exception table:
    //   from	to	target	type
    //   112	189	371	java/lang/Exception
    //   189	236	371	java/lang/Exception
    //   239	352	371	java/lang/Exception
    //   104	112	375	finally
    //   112	189	375	finally
    //   189	236	375	finally
    //   239	352	375	finally
    //   104	112	382	java/lang/Exception
    //   13	18	391	finally
    //   24	32	391	finally
    //   35	48	391	finally
    //   51	58	391	finally
    //   64	85	391	finally
    //   408	414	391	finally
    //   417	429	391	finally
    //   13	18	395	java/lang/Exception
    //   24	32	395	java/lang/Exception
    //   35	48	395	java/lang/Exception
    //   51	58	395	java/lang/Exception
    //   64	85	395	java/lang/Exception
  }
  
  List<LocalMediaInfo> a(Cursor paramCursor, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    if (paramCursor.getCount() <= 0) {
      return null;
    }
    int i3 = paramCursor.getColumnIndexOrThrow("_id");
    int n = paramCursor.getColumnIndexOrThrow("_data");
    int m = paramCursor.getColumnIndexOrThrow("date_modified");
    int i4 = paramCursor.getColumnIndexOrThrow("duration");
    int i5 = paramCursor.getColumnIndexOrThrow("mime_type");
    int i6 = paramCursor.getColumnIndexOrThrow("_size");
    int i1 = 0;
    ArrayList localArrayList = new ArrayList();
    while (paramCursor.moveToNext())
    {
      String str = paramCursor.getString(i5);
      Object localObject;
      if ((paramMediaFileFilter != null) && (paramMediaFileFilter.filter(str)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Filter mime type:");
          ((StringBuilder)localObject).append(str);
          QLog.i("AlbumListAdapter", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localObject = paramCursor.getString(n);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
        {
          long l = paramCursor.getLong(m);
          LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
          localLocalMediaInfo._id = paramCursor.getLong(i3);
          localLocalMediaInfo.path = ((String)localObject);
          localLocalMediaInfo.mMimeType = str;
          localLocalMediaInfo.modifiedDate = l;
          localLocalMediaInfo.mDuration = paramCursor.getLong(i4);
          localLocalMediaInfo.fileSize = paramCursor.getLong(i6);
          localArrayList.add(localLocalMediaInfo);
          int i2 = i1 + 1;
          i1 = i2;
          if (paramInt > 0)
          {
            i1 = i2;
            if (i2 >= paramInt) {
              return localArrayList;
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.b.a(-1);
  }
  
  void a(QQAlbumInfo paramQQAlbumInfo)
  {
    List localList = this.d;
    if (localList == null) {
      return;
    }
    if (localList.isEmpty()) {
      this.d.add(paramQQAlbumInfo);
    } else if (((QQAlbumInfo)this.d.get(0)).id.equals("$RecentAlbumId")) {
      this.d.set(0, paramQQAlbumInfo);
    }
    b(paramQQAlbumInfo);
    notifyDataSetChanged();
  }
  
  void a(List<QQAlbumInfo> paramList)
  {
    this.d.clear();
    if (paramList != null) {
      this.d.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  protected void b(QQAlbumInfo paramQQAlbumInfo) {}
  
  public void b(List<QQAlbumInfo> paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramList);
      return;
    }
    this.e.post(new AlbumListAdapter.1(this, paramList));
  }
  
  public void c(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramQQAlbumInfo);
      return;
    }
    this.e.post(new AlbumListAdapter.2(this, paramQQAlbumInfo));
  }
  
  void d(QQAlbumInfo paramQQAlbumInfo)
  {
    List localList = this.d;
    if (localList == null) {
      return;
    }
    if (localList.size() < 2)
    {
      this.d.add(paramQQAlbumInfo);
    }
    else
    {
      int i1 = 0;
      int m = 0;
      int n;
      for (;;)
      {
        n = i1;
        if (m >= this.d.size()) {
          break;
        }
        if (((QQAlbumInfo)this.d.get(m)).id.equals("$VideoAlbumId"))
        {
          n = 1;
          break;
        }
        m += 1;
      }
      if (n != 0)
      {
        if (paramQQAlbumInfo.mMediaFileCount > 0) {
          this.d.set(m, paramQQAlbumInfo);
        } else {
          this.d.remove(m);
        }
      }
      else if (paramQQAlbumInfo.mMediaFileCount > 0) {
        this.d.add(1, paramQQAlbumInfo);
      }
    }
    notifyDataSetChanged();
  }
  
  public void e(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      d(paramQQAlbumInfo);
      return;
    }
    this.e.post(new AlbumListAdapter.3(this, paramQQAlbumInfo));
  }
  
  public int getCount()
  {
    return this.d.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType(((QQAlbumInfo)this.d.get(paramInt)).mCoverInfo);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.b.a(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return QAlbumUtil.MEDIA_TYPE_MAPS.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.AlbumListAdapter
 * JD-Core Version:    0.7.0.1
 */