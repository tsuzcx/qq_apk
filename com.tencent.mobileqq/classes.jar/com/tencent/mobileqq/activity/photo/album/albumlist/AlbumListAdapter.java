package com.tencent.mobileqq.activity.photo.album.albumlist;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper.Builder;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class AlbumListAdapter
  extends BaseAdapter
{
  static final ColorDrawable c = new ColorDrawable(-2141891243);
  static final String[] d = { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "orientation", "mime_type", "COUNT(_data) as count" };
  static final String e;
  static final String[] f;
  static final String[] g;
  static String[] h = { "_id", "_data", "mime_type", "date_modified", "orientation", "_size" };
  private List<QQAlbumInfo> a = new ArrayList();
  private QQAlbumInfo b;
  AlbumListCustomization.IalbumListAdapterCallBack i;
  Resources j;
  public int k;
  public int l;
  Drawable.ConstantState m;
  Handler n = new Handler();
  private QQAlbumInfo o;
  private List<QQAlbumInfo> p;
  private boolean q = false;
  
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
    e = localStringBuilder.toString();
    f = new String[] { "_id", "_data", "duration", "date_modified", "mime_type", "_size" };
    g = new String[] { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "mime_type", "COUNT(_data) as count" };
    if (Build.VERSION.SDK_INT >= 16)
    {
      h = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size", "width" };
      return;
    }
  }
  
  public AlbumListAdapter(AbstractAlbumListFragment paramAbstractAlbumListFragment)
  {
    this.i = paramAbstractAlbumListFragment.c.g;
    this.j = paramAbstractAlbumListFragment.getResources();
    this.m = this.j.getDrawable(2130839455).getConstantState();
    this.k = this.j.getDimensionPixelSize(2131296706);
    this.l = this.k;
  }
  
  static boolean a(String paramString)
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
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i1 = paramString.lastIndexOf("/");
    if (i1 >= 0) {
      return paramString.substring(0, i1 + 1);
    }
    return null;
  }
  
  public QQAlbumInfo a(int paramInt)
  {
    return (QQAlbumInfo)this.a.get(paramInt);
  }
  
  QQAlbumInfo a(AbstractAlbumListFragment paramAbstractAlbumListFragment, QQAlbumInfo paramQQAlbumInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    QQAlbumInfo localQQAlbumInfo = paramQQAlbumInfo;
    if (paramQQAlbumInfo == null) {
      localQQAlbumInfo = new QQAlbumInfo();
    }
    paramAbstractAlbumListFragment.c.d.createFilterListener();
    paramAbstractAlbumListFragment = new MediaQueryHelper.Builder().setEachCount(3).needImage(paramBoolean1).needVideo(paramBoolean2).setListener(paramAbstractAlbumListFragment.c.d.filterListener).build(paramAbstractAlbumListFragment.getActivity());
    while ((!paramAbstractAlbumListFragment.mTraversalDone) && (paramAbstractAlbumListFragment.mediaList.isEmpty())) {
      paramAbstractAlbumListFragment.queryNext();
    }
    if (!paramAbstractAlbumListFragment.mediaList.isEmpty())
    {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramAbstractAlbumListFragment.mediaList.get(0));
      localQQAlbumInfo.coverDate = localQQAlbumInfo.mCoverInfo.modifiedDate;
    }
    if (paramBoolean3)
    {
      paramAbstractAlbumListFragment.upDateCount();
      localQQAlbumInfo.mMediaFileCount = paramAbstractAlbumListFragment.cursorsCount;
    }
    paramAbstractAlbumListFragment.close();
    return localQQAlbumInfo;
  }
  
  protected List<QQAlbumInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.b;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = this.o;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = this.p;
    if (localObject != null) {
      localArrayList.addAll((Collection)localObject);
    }
    return localArrayList;
  }
  
  /* Error */
  public List<QQAlbumInfo> a(android.content.Context paramContext, int paramInt)
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
    //   13: getstatic 348	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   16: astore 12
    //   18: goto +539 -> 557
    //   21: getstatic 348	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   24: invokevirtual 354	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   27: astore 12
    //   29: aload 12
    //   31: ldc_w 356
    //   34: iload_2
    //   35: invokestatic 360	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   38: invokevirtual 366	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   41: pop
    //   42: aload 12
    //   44: invokevirtual 369	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   47: astore 12
    //   49: goto +508 -> 557
    //   52: aload_1
    //   53: invokevirtual 375	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   56: astore 16
    //   58: getstatic 64	com/tencent/mobileqq/activity/photo/album/albumlist/AlbumListAdapter:d	[Ljava/lang/String;
    //   61: astore 17
    //   63: aload 15
    //   65: astore_1
    //   66: aload 16
    //   68: aload 12
    //   70: aload 17
    //   72: aload_0
    //   73: getfield 181	com/tencent/mobileqq/activity/photo/album/albumlist/AlbumListAdapter:i	Lcom/tencent/mobileqq/activity/photo/album/albumlist/AlbumListCustomization$IalbumListAdapterCallBack;
    //   76: invokeinterface 379 1 0
    //   81: aconst_null
    //   82: ldc_w 381
    //   85: invokevirtual 387	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore 13
    //   90: aload 13
    //   92: ifnonnull +17 -> 109
    //   95: aload 13
    //   97: ifnull +10 -> 107
    //   100: aload 13
    //   102: invokeinterface 390 1 0
    //   107: aconst_null
    //   108: areturn
    //   109: new 392	java/util/LinkedList
    //   112: dup
    //   113: invokespecial 393	java/util/LinkedList:<init>	()V
    //   116: astore_1
    //   117: aload 13
    //   119: ldc 48
    //   121: invokeinterface 396 2 0
    //   126: istore_2
    //   127: aload 13
    //   129: ldc 50
    //   131: invokeinterface 396 2 0
    //   136: istore_3
    //   137: aload 13
    //   139: ldc 56
    //   141: invokeinterface 396 2 0
    //   146: istore 4
    //   148: aload 13
    //   150: ldc 54
    //   152: invokeinterface 396 2 0
    //   157: istore 5
    //   159: aload 13
    //   161: ldc 140
    //   163: invokeinterface 396 2 0
    //   168: istore 6
    //   170: aload 13
    //   172: ldc 58
    //   174: invokeinterface 396 2 0
    //   179: istore 7
    //   181: aload 13
    //   183: ldc 60
    //   185: invokeinterface 396 2 0
    //   190: istore 8
    //   192: aload 13
    //   194: ldc_w 398
    //   197: invokeinterface 396 2 0
    //   202: istore 9
    //   204: aload 13
    //   206: invokeinterface 401 1 0
    //   211: ifeq +204 -> 415
    //   214: aload 13
    //   216: iload_2
    //   217: invokeinterface 404 2 0
    //   222: astore 15
    //   224: aload 13
    //   226: iload_3
    //   227: invokeinterface 404 2 0
    //   232: astore 16
    //   234: aload 15
    //   236: invokestatic 409	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   239: ifne -35 -> 204
    //   242: aload 16
    //   244: invokestatic 409	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifeq +6 -> 253
    //   250: goto -46 -> 204
    //   253: aload 13
    //   255: iload 4
    //   257: invokeinterface 404 2 0
    //   262: astore 12
    //   264: aload 13
    //   266: iload 5
    //   268: invokeinterface 413 2 0
    //   273: lstore 10
    //   275: new 242	com/tencent/mobileqq/data/QQAlbumInfo
    //   278: dup
    //   279: invokespecial 244	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   282: astore 14
    //   284: aload 14
    //   286: aload 16
    //   288: putfield 416	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   291: aload 14
    //   293: aload 15
    //   295: putfield 419	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   298: aload 14
    //   300: lload 10
    //   302: putfield 310	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   305: aload 14
    //   307: getfield 303	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   310: astore 15
    //   312: aload 15
    //   314: aload 12
    //   316: putfield 422	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   319: aload 15
    //   321: aload 13
    //   323: iload 6
    //   325: invokeinterface 413 2 0
    //   330: putfield 424	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   333: aload 15
    //   335: lload 10
    //   337: putfield 307	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   340: aload 15
    //   342: aload 13
    //   344: iload 7
    //   346: invokeinterface 427 2 0
    //   351: putfield 429	com/tencent/mobileqq/activity/photo/LocalMediaInfo:orientation	I
    //   354: aload 15
    //   356: aload 13
    //   358: iload 8
    //   360: invokeinterface 404 2 0
    //   365: putfield 432	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   368: ldc 108
    //   370: aload 15
    //   372: getfield 432	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   375: invokevirtual 435	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   378: ifeq +11 -> 389
    //   381: aload 15
    //   383: ldc_w 437
    //   386: putfield 432	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   389: aload 14
    //   391: aload 13
    //   393: iload 9
    //   395: invokeinterface 427 2 0
    //   400: putfield 319	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   403: aload_1
    //   404: aload 14
    //   406: invokeinterface 329 2 0
    //   411: pop
    //   412: goto -208 -> 204
    //   415: aload_1
    //   416: astore 14
    //   418: aload 13
    //   420: ifnull +110 -> 530
    //   423: aload 13
    //   425: invokeinterface 390 1 0
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
    //   489: invokestatic 442	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq +18 -> 510
    //   495: aload 12
    //   497: astore_1
    //   498: ldc_w 444
    //   501: iconst_2
    //   502: ldc_w 446
    //   505: aload 14
    //   507: invokestatic 449	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   510: aload 13
    //   512: astore 14
    //   514: aload 12
    //   516: ifnull +14 -> 530
    //   519: aload 12
    //   521: invokeinterface 390 1 0
    //   526: aload 13
    //   528: astore 14
    //   530: aload 14
    //   532: areturn
    //   533: astore 12
    //   535: goto -63 -> 472
    //   538: aload_1
    //   539: ifnull +9 -> 548
    //   542: aload_1
    //   543: invokeinterface 390 1 0
    //   548: goto +6 -> 554
    //   551: aload 12
    //   553: athrow
    //   554: goto -3 -> 551
    //   557: goto -505 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	560	0	this	AlbumListAdapter
    //   0	560	1	paramContext	android.content.Context
    //   0	560	2	paramInt	int
    //   136	91	3	i1	int
    //   146	110	4	i2	int
    //   157	110	5	i3	int
    //   168	156	6	i4	int
    //   179	166	7	i5	int
    //   190	169	8	i6	int
    //   202	192	9	i7	int
    //   273	63	10	l1	long
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
  public List<QQAlbumInfo> a(android.content.Context paramContext, int paramInt, com.tencent.mobileqq.activity.photo.MediaFileFilter paramMediaFileFilter)
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
    //   13: getstatic 454	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   16: astore 12
    //   18: goto +447 -> 465
    //   21: aload 14
    //   23: astore_3
    //   24: getstatic 454	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   27: invokevirtual 354	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   30: astore 12
    //   32: aload 14
    //   34: astore_3
    //   35: aload 12
    //   37: ldc_w 356
    //   40: iload_2
    //   41: invokestatic 360	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   44: invokevirtual 366	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   47: pop
    //   48: aload 14
    //   50: astore_3
    //   51: aload 12
    //   53: invokevirtual 369	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   56: astore 12
    //   58: goto +407 -> 465
    //   61: aload 14
    //   63: astore_3
    //   64: aload_1
    //   65: invokevirtual 375	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   68: aload 12
    //   70: getstatic 148	com/tencent/mobileqq/activity/photo/album/albumlist/AlbumListAdapter:g	[Ljava/lang/String;
    //   73: ldc_w 456
    //   76: aconst_null
    //   77: ldc_w 381
    //   80: invokevirtual 387	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 12
    //   85: aload 12
    //   87: ifnonnull +17 -> 104
    //   90: aload 12
    //   92: ifnull +10 -> 102
    //   95: aload 12
    //   97: invokeinterface 390 1 0
    //   102: aconst_null
    //   103: areturn
    //   104: new 392	java/util/LinkedList
    //   107: dup
    //   108: invokespecial 393	java/util/LinkedList:<init>	()V
    //   111: astore_1
    //   112: aload 12
    //   114: ldc 48
    //   116: invokeinterface 396 2 0
    //   121: istore_2
    //   122: aload 12
    //   124: ldc 140
    //   126: invokeinterface 396 2 0
    //   131: istore 4
    //   133: aload 12
    //   135: ldc 50
    //   137: invokeinterface 396 2 0
    //   142: istore 5
    //   144: aload 12
    //   146: ldc 56
    //   148: invokeinterface 396 2 0
    //   153: istore 6
    //   155: aload 12
    //   157: ldc 54
    //   159: invokeinterface 396 2 0
    //   164: istore 7
    //   166: aload 12
    //   168: ldc 60
    //   170: invokeinterface 396 2 0
    //   175: istore 8
    //   177: aload 12
    //   179: ldc_w 398
    //   182: invokeinterface 396 2 0
    //   187: istore 9
    //   189: aload 12
    //   191: invokeinterface 401 1 0
    //   196: ifeq +159 -> 355
    //   199: aload 12
    //   201: iload_2
    //   202: invokeinterface 404 2 0
    //   207: astore 13
    //   209: aload 12
    //   211: iload 5
    //   213: invokeinterface 404 2 0
    //   218: astore 14
    //   220: aload 13
    //   222: invokestatic 409	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   225: ifne -36 -> 189
    //   228: aload 14
    //   230: invokestatic 409	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifeq +6 -> 239
    //   236: goto -47 -> 189
    //   239: aload 12
    //   241: iload 7
    //   243: invokeinterface 413 2 0
    //   248: lstore 10
    //   250: new 242	com/tencent/mobileqq/data/QQAlbumInfo
    //   253: dup
    //   254: invokespecial 244	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   257: astore_3
    //   258: aload_3
    //   259: aload 14
    //   261: putfield 416	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   264: aload_3
    //   265: aload 13
    //   267: putfield 419	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   270: aload_3
    //   271: lload 10
    //   273: putfield 310	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   276: aload_3
    //   277: getfield 303	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   280: astore 13
    //   282: aload 13
    //   284: aload 12
    //   286: iload 6
    //   288: invokeinterface 404 2 0
    //   293: putfield 422	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   296: aload 13
    //   298: aload 12
    //   300: iload 4
    //   302: invokeinterface 413 2 0
    //   307: putfield 424	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   310: aload 13
    //   312: lload 10
    //   314: putfield 307	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   317: aload 13
    //   319: aload 12
    //   321: iload 8
    //   323: invokeinterface 404 2 0
    //   328: putfield 432	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   331: aload_3
    //   332: aload 12
    //   334: iload 9
    //   336: invokeinterface 427 2 0
    //   341: putfield 319	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   344: aload_1
    //   345: aload_3
    //   346: invokeinterface 329 2 0
    //   351: pop
    //   352: goto -163 -> 189
    //   355: aload_1
    //   356: astore_3
    //   357: aload 12
    //   359: ifnull +86 -> 445
    //   362: aload 12
    //   364: invokeinterface 390 1 0
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
    //   408: invokestatic 442	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +18 -> 429
    //   414: aload 12
    //   416: astore_3
    //   417: ldc_w 444
    //   420: iconst_2
    //   421: ldc_w 458
    //   424: aload 13
    //   426: invokestatic 449	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   429: aload_1
    //   430: astore_3
    //   431: aload 12
    //   433: ifnull +12 -> 445
    //   436: aload 12
    //   438: invokeinterface 390 1 0
    //   443: aload_1
    //   444: astore_3
    //   445: aload_3
    //   446: areturn
    //   447: aload_3
    //   448: ifnull +9 -> 457
    //   451: aload_3
    //   452: invokeinterface 390 1 0
    //   457: goto +5 -> 462
    //   460: aload_1
    //   461: athrow
    //   462: goto -2 -> 460
    //   465: goto -404 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	AlbumListAdapter
    //   0	468	1	paramContext	android.content.Context
    //   0	468	2	paramInt	int
    //   0	468	3	paramMediaFileFilter	com.tencent.mobileqq.activity.photo.MediaFileFilter
    //   131	170	4	i1	int
    //   142	70	5	i2	int
    //   153	134	6	i3	int
    //   164	78	7	i4	int
    //   175	147	8	i5	int
    //   187	148	9	i6	int
    //   248	65	10	l1	long
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
  
  public void a(QQAlbumInfo paramQQAlbumInfo)
  {
    this.b = paramQQAlbumInfo;
  }
  
  void a(List<QQAlbumInfo> paramList)
  {
    this.p = paramList;
  }
  
  public void b()
  {
    this.a.clear();
    this.a.addAll(a());
    notifyDataSetChanged();
  }
  
  void b(QQAlbumInfo paramQQAlbumInfo)
  {
    this.o = paramQQAlbumInfo;
  }
  
  public void c()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      b();
      return;
    }
    this.n.post(new AlbumListAdapter.1(this));
  }
  
  protected List<QQAlbumInfo> d()
  {
    return this.a;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType(((QQAlbumInfo)this.a.get(paramInt)).mCoverInfo);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = this.i.a(paramInt, paramView, paramViewGroup);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return QAlbumUtil.MEDIA_TYPE_MAPS.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListAdapter
 * JD-Core Version:    0.7.0.1
 */