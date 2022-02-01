package com.tencent.aelight.camera.ae.album.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractAlbumListFragment;
import com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogic;
import com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogic.IalbumListAdapterCallBack;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AEAlbumListAdapter
  extends BaseAdapter
{
  public static final ColorDrawable a;
  static final String jdField_a_of_type_JavaLangString;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  static String[] jdField_b_of_type_ArrayOfJavaLangString;
  static final String[] c = { "_id", "_data", "duration", "date_modified", "mime_type", "_size" };
  static final String[] d = { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "mime_type", "COUNT(_data) as count" };
  public int a;
  public Resources a;
  public Drawable.ConstantState a;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  AEAlbumListLogic.IalbumListAdapterCallBack jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack;
  List<QQAlbumInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  public int b;
  private boolean jdField_b_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-2141891243);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "orientation", "mime_type", "COUNT(_data) as count" };
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
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    if (Build.VERSION.SDK_INT >= 16) {
      jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size", "width" };
    } else {
      jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size" };
    }
  }
  
  public AEAlbumListAdapter(AEAbstractAlbumListFragment paramAEAbstractAlbumListFragment)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack = paramAEAbstractAlbumListFragment.a.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack;
    this.jdField_a_of_type_AndroidContentResResources = paramAEAbstractAlbumListFragment.getResources();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130839275).getConstantState();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131296467);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
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
  
  public QQAlbumInfo a(int paramInt)
  {
    return (QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  /* Error */
  public QQAlbumInfo a(Context paramContext)
  {
    // Byte code:
    //   0: new 216	com/tencent/mobileqq/data/QQAlbumInfo
    //   3: dup
    //   4: invokespecial 220	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc 222
    //   13: putfield 225	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   16: aload 6
    //   18: getstatic 230	com/tencent/mobileqq/activity/photo/album/QAlbumCustomAlbumConstants:VIDEO_ALBUM_NAME	Ljava/lang/String;
    //   21: putfield 233	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   24: aload 6
    //   26: iconst_0
    //   27: putfield 236	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   30: aconst_null
    //   31: astore 5
    //   33: aconst_null
    //   34: astore 4
    //   36: aconst_null
    //   37: astore_3
    //   38: aload 5
    //   40: astore_2
    //   41: getstatic 242	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   44: astore 7
    //   46: aload 5
    //   48: astore_2
    //   49: aload_1
    //   50: invokevirtual 248	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   53: aload 7
    //   55: getstatic 139	com/tencent/aelight/camera/ae/album/adapter/AEAlbumListAdapter:c	[Ljava/lang/String;
    //   58: ldc 250
    //   60: aconst_null
    //   61: ldc 252
    //   63: invokevirtual 258	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   66: astore_1
    //   67: iconst_2
    //   68: invokestatic 264	com/tencent/mobileqq/activity/photo/MediaFileFilter:getFilter	(I)Lcom/tencent/mobileqq/activity/photo/MediaFileFilter;
    //   71: astore 4
    //   73: aload_3
    //   74: astore_2
    //   75: aload 4
    //   77: ifnull +12 -> 89
    //   80: aload_0
    //   81: aload_1
    //   82: iconst_m1
    //   83: aload 4
    //   85: invokevirtual 267	com/tencent/aelight/camera/ae/album/adapter/AEAlbumListAdapter:a	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   88: astore_2
    //   89: invokestatic 273	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   92: invokestatic 279	com/tencent/mobileqq/activity/photo/MediaScanner:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/activity/photo/MediaScanner;
    //   95: iconst_0
    //   96: iconst_m1
    //   97: invokevirtual 283	com/tencent/mobileqq/activity/photo/MediaScanner:getMediaScannerInfos	(ZI)Ljava/util/ArrayList;
    //   100: astore_3
    //   101: aload_2
    //   102: ifnull +44 -> 146
    //   105: aload_2
    //   106: invokeinterface 287 1 0
    //   111: ifne +35 -> 146
    //   114: aload 6
    //   116: aload 6
    //   118: getfield 236	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   121: aload_2
    //   122: invokeinterface 291 1 0
    //   127: iadd
    //   128: putfield 236	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   131: aload 6
    //   133: aload_2
    //   134: iconst_0
    //   135: invokeinterface 214 2 0
    //   140: checkcast 293	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   143: putfield 297	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   146: aload_3
    //   147: ifnull +152 -> 299
    //   150: aload_3
    //   151: invokevirtual 298	java/util/ArrayList:isEmpty	()Z
    //   154: ifne +145 -> 299
    //   157: aload 6
    //   159: aload 6
    //   161: getfield 236	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   164: aload_3
    //   165: invokevirtual 299	java/util/ArrayList:size	()I
    //   168: iadd
    //   169: putfield 236	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   172: aload_3
    //   173: iconst_0
    //   174: invokevirtual 300	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   177: checkcast 302	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   180: astore_2
    //   181: aload 6
    //   183: getfield 297	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   186: ifnull +19 -> 205
    //   189: aload 6
    //   191: getfield 297	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   194: getfield 306	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   197: aload_2
    //   198: getfield 307	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   201: lcmp
    //   202: ifge +97 -> 299
    //   205: aload 6
    //   207: new 293	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   210: dup
    //   211: invokespecial 308	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   214: putfield 297	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   217: aload 6
    //   219: getfield 297	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   222: aload_2
    //   223: getfield 310	com/tencent/mobileqq/activity/photo/MediaScannerInfo:id	I
    //   226: i2l
    //   227: putfield 312	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   230: aload 6
    //   232: getfield 297	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   235: aload_2
    //   236: getfield 314	com/tencent/mobileqq/activity/photo/MediaScannerInfo:duration	J
    //   239: putfield 317	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   242: aload 6
    //   244: getfield 297	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   247: aload_2
    //   248: getfield 320	com/tencent/mobileqq/activity/photo/MediaScannerInfo:fileSize	J
    //   251: putfield 321	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   254: aload 6
    //   256: getfield 297	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   259: aload_2
    //   260: getfield 324	com/tencent/mobileqq/activity/photo/MediaScannerInfo:path	Ljava/lang/String;
    //   263: putfield 325	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   266: aload 6
    //   268: getfield 297	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   271: aload_2
    //   272: getfield 307	com/tencent/mobileqq/activity/photo/MediaScannerInfo:modifiedDate	J
    //   275: putfield 306	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   278: aload 6
    //   280: getfield 297	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   283: aload_2
    //   284: getfield 328	com/tencent/mobileqq/activity/photo/MediaScannerInfo:mimeType	Ljava/lang/String;
    //   287: putfield 331	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   290: aload 6
    //   292: getfield 297	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   295: iconst_0
    //   296: putfield 334	com/tencent/mobileqq/activity/photo/LocalMediaInfo:isSystemMeidaStore	Z
    //   299: aload_1
    //   300: ifnull +64 -> 364
    //   303: aload_1
    //   304: invokeinterface 339 1 0
    //   309: aload 6
    //   311: areturn
    //   312: astore_2
    //   313: goto +54 -> 367
    //   316: astore_3
    //   317: goto +15 -> 332
    //   320: astore_3
    //   321: aload_2
    //   322: astore_1
    //   323: aload_3
    //   324: astore_2
    //   325: goto +42 -> 367
    //   328: astore_3
    //   329: aload 4
    //   331: astore_1
    //   332: aload_1
    //   333: astore_2
    //   334: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +17 -> 354
    //   340: aload_1
    //   341: astore_2
    //   342: ldc_w 346
    //   345: iconst_2
    //   346: aload_3
    //   347: invokevirtual 349	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   350: aload_3
    //   351: invokestatic 353	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   354: aload_1
    //   355: ifnull +9 -> 364
    //   358: aload_1
    //   359: invokeinterface 339 1 0
    //   364: aload 6
    //   366: areturn
    //   367: aload_1
    //   368: ifnull +9 -> 377
    //   371: aload_1
    //   372: invokeinterface 339 1 0
    //   377: aload_2
    //   378: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	AEAlbumListAdapter
    //   0	379	1	paramContext	Context
    //   40	244	2	localObject1	Object
    //   312	10	2	localObject2	Object
    //   324	54	2	localObject3	Object
    //   37	136	3	localArrayList	ArrayList
    //   316	1	3	localException1	java.lang.Exception
    //   320	4	3	localObject4	Object
    //   328	23	3	localException2	java.lang.Exception
    //   34	296	4	localMediaFileFilter	MediaFileFilter
    //   31	16	5	localObject5	Object
    //   7	358	6	localQQAlbumInfo	QQAlbumInfo
    //   44	10	7	localUri	android.net.Uri
    // Exception table:
    //   from	to	target	type
    //   67	73	312	finally
    //   80	89	312	finally
    //   89	101	312	finally
    //   105	146	312	finally
    //   150	205	312	finally
    //   205	299	312	finally
    //   67	73	316	java/lang/Exception
    //   80	89	316	java/lang/Exception
    //   89	101	316	java/lang/Exception
    //   105	146	316	java/lang/Exception
    //   150	205	316	java/lang/Exception
    //   205	299	316	java/lang/Exception
    //   41	46	320	finally
    //   49	67	320	finally
    //   334	340	320	finally
    //   342	354	320	finally
    //   41	46	328	java/lang/Exception
    //   49	67	328	java/lang/Exception
  }
  
  /* Error */
  QQAlbumInfo a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: iload_3
    //   1: ifle +263 -> 264
    //   4: new 216	com/tencent/mobileqq/data/QQAlbumInfo
    //   7: dup
    //   8: invokespecial 220	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   11: astore 10
    //   13: aload 10
    //   15: ldc_w 356
    //   18: putfield 225	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   21: aload 10
    //   23: getstatic 359	com/tencent/mobileqq/activity/photo/album/QAlbumCustomAlbumConstants:RECENT_ALBUM_NAME	Ljava/lang/String;
    //   26: putfield 233	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   29: aconst_null
    //   30: astore 9
    //   32: aconst_null
    //   33: astore 7
    //   35: aconst_null
    //   36: astore 8
    //   38: iload_3
    //   39: ifle +46 -> 85
    //   42: aload 9
    //   44: astore 5
    //   46: getstatic 242	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   49: invokevirtual 365	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   52: astore 6
    //   54: aload 9
    //   56: astore 5
    //   58: aload 6
    //   60: ldc_w 367
    //   63: iload_3
    //   64: invokestatic 371	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   67: invokevirtual 377	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   70: pop
    //   71: aload 9
    //   73: astore 5
    //   75: aload 6
    //   77: invokevirtual 381	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   80: astore 6
    //   82: goto +12 -> 94
    //   85: aload 9
    //   87: astore 5
    //   89: getstatic 242	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   92: astore 6
    //   94: aload 9
    //   96: astore 5
    //   98: aload_1
    //   99: invokevirtual 248	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   102: aload 6
    //   104: getstatic 139	com/tencent/aelight/camera/ae/album/adapter/AEAlbumListAdapter:c	[Ljava/lang/String;
    //   107: ldc 250
    //   109: aconst_null
    //   110: ldc 252
    //   112: invokevirtual 258	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   115: astore_1
    //   116: aload 8
    //   118: astore 5
    //   120: aload 4
    //   122: ifnull +16 -> 138
    //   125: aload_0
    //   126: aload_1
    //   127: iload_3
    //   128: aload 4
    //   130: invokevirtual 267	com/tencent/aelight/camera/ae/album/adapter/AEAlbumListAdapter:a	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   133: astore 5
    //   135: goto +3 -> 138
    //   138: aload 5
    //   140: ifnull +47 -> 187
    //   143: aload 5
    //   145: invokeinterface 287 1 0
    //   150: ifne +37 -> 187
    //   153: aload 5
    //   155: invokeinterface 291 1 0
    //   160: istore_2
    //   161: aload 10
    //   163: iload_2
    //   164: putfield 236	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   167: iload_2
    //   168: ifle +19 -> 187
    //   171: aload 10
    //   173: aload 5
    //   175: iconst_0
    //   176: invokeinterface 214 2 0
    //   181: checkcast 293	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   184: putfield 297	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   187: aload_1
    //   188: ifnull +58 -> 246
    //   191: aload_1
    //   192: invokeinterface 339 1 0
    //   197: aload 10
    //   199: areturn
    //   200: astore 4
    //   202: goto +47 -> 249
    //   205: astore 4
    //   207: aload 7
    //   209: astore_1
    //   210: aload_1
    //   211: astore 5
    //   213: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +20 -> 236
    //   219: aload_1
    //   220: astore 5
    //   222: ldc_w 346
    //   225: iconst_2
    //   226: aload 4
    //   228: invokevirtual 349	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   231: aload 4
    //   233: invokestatic 353	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aload_1
    //   237: ifnull +9 -> 246
    //   240: aload_1
    //   241: invokeinterface 339 1 0
    //   246: aload 10
    //   248: areturn
    //   249: aload 5
    //   251: ifnull +10 -> 261
    //   254: aload 5
    //   256: invokeinterface 339 1 0
    //   261: aload 4
    //   263: athrow
    //   264: new 383	java/lang/IllegalArgumentException
    //   267: dup
    //   268: ldc_w 385
    //   271: invokespecial 388	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   274: athrow
    //   275: astore 4
    //   277: aload_1
    //   278: astore 5
    //   280: goto -31 -> 249
    //   283: astore 4
    //   285: goto -75 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	AEAlbumListAdapter
    //   0	288	1	paramContext	Context
    //   0	288	2	paramInt1	int
    //   0	288	3	paramInt2	int
    //   0	288	4	paramMediaFileFilter	MediaFileFilter
    //   44	235	5	localObject1	Object
    //   52	51	6	localObject2	Object
    //   33	175	7	localObject3	Object
    //   36	81	8	localObject4	Object
    //   30	65	9	localObject5	Object
    //   11	236	10	localQQAlbumInfo	QQAlbumInfo
    // Exception table:
    //   from	to	target	type
    //   46	54	200	finally
    //   58	71	200	finally
    //   75	82	200	finally
    //   89	94	200	finally
    //   98	116	200	finally
    //   213	219	200	finally
    //   222	236	200	finally
    //   46	54	205	java/lang/Exception
    //   58	71	205	java/lang/Exception
    //   75	82	205	java/lang/Exception
    //   89	94	205	java/lang/Exception
    //   98	116	205	java/lang/Exception
    //   125	135	275	finally
    //   143	167	275	finally
    //   171	187	275	finally
    //   125	135	283	java/lang/Exception
    //   143	167	283	java/lang/Exception
    //   171	187	283	java/lang/Exception
  }
  
  QQAlbumInfo a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo.id = "$RecentAlbumId";
    localQQAlbumInfo.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
    paramArrayList = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack.a(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramArrayList.get(0));
      localQQAlbumInfo.mMediaFileCount = paramArrayList.size();
    }
    if (localQQAlbumInfo.mMediaFileCount >= paramInt2) {
      return localQQAlbumInfo;
    }
    paramContext = QAlbumUtil.queryRecentVideos(paramContext, 0, paramInt2, paramMediaFileFilter, -1L);
    if (paramContext == null) {
      return localQQAlbumInfo;
    }
    if ((localQQAlbumInfo.mMediaFileCount == 0) && (paramContext.size() > 0)) {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramContext.get(0));
    }
    if (localQQAlbumInfo.mMediaFileCount + paramContext.size() <= paramInt2)
    {
      localQQAlbumInfo.mMediaFileCount += paramContext.size();
      return localQQAlbumInfo;
    }
    localQQAlbumInfo.mMediaFileCount = paramInt2;
    return localQQAlbumInfo;
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
    //   13: getstatic 406	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   16: astore 12
    //   18: goto +539 -> 557
    //   21: getstatic 406	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   24: invokevirtual 365	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   27: astore 12
    //   29: aload 12
    //   31: ldc_w 367
    //   34: iload_2
    //   35: invokestatic 371	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   38: invokevirtual 377	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   41: pop
    //   42: aload 12
    //   44: invokevirtual 381	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   47: astore 12
    //   49: goto +508 -> 557
    //   52: aload_1
    //   53: invokevirtual 248	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   56: astore 16
    //   58: getstatic 50	com/tencent/aelight/camera/ae/album/adapter/AEAlbumListAdapter:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   61: astore 17
    //   63: aload 15
    //   65: astore_1
    //   66: aload 16
    //   68: aload 12
    //   70: aload 17
    //   72: aload_0
    //   73: getfield 166	com/tencent/aelight/camera/ae/album/adapter/AEAlbumListAdapter:jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack	Lcom/tencent/aelight/camera/ae/album/logic/AEAlbumListLogic$IalbumListAdapterCallBack;
    //   76: invokeinterface 408 1 0
    //   81: aconst_null
    //   82: ldc_w 410
    //   85: invokevirtual 258	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore 13
    //   90: aload 13
    //   92: ifnonnull +17 -> 109
    //   95: aload 13
    //   97: ifnull +10 -> 107
    //   100: aload 13
    //   102: invokeinterface 339 1 0
    //   107: aconst_null
    //   108: areturn
    //   109: new 412	java/util/LinkedList
    //   112: dup
    //   113: invokespecial 413	java/util/LinkedList:<init>	()V
    //   116: astore_1
    //   117: aload 13
    //   119: ldc 34
    //   121: invokeinterface 417 2 0
    //   126: istore_2
    //   127: aload 13
    //   129: ldc 36
    //   131: invokeinterface 417 2 0
    //   136: istore_3
    //   137: aload 13
    //   139: ldc 42
    //   141: invokeinterface 417 2 0
    //   146: istore 4
    //   148: aload 13
    //   150: ldc 40
    //   152: invokeinterface 417 2 0
    //   157: istore 5
    //   159: aload 13
    //   161: ldc 131
    //   163: invokeinterface 417 2 0
    //   168: istore 6
    //   170: aload 13
    //   172: ldc 44
    //   174: invokeinterface 417 2 0
    //   179: istore 7
    //   181: aload 13
    //   183: ldc 46
    //   185: invokeinterface 417 2 0
    //   190: istore 8
    //   192: aload 13
    //   194: ldc_w 419
    //   197: invokeinterface 417 2 0
    //   202: istore 9
    //   204: aload 13
    //   206: invokeinterface 422 1 0
    //   211: ifeq +204 -> 415
    //   214: aload 13
    //   216: iload_2
    //   217: invokeinterface 425 2 0
    //   222: astore 15
    //   224: aload 13
    //   226: iload_3
    //   227: invokeinterface 425 2 0
    //   232: astore 16
    //   234: aload 15
    //   236: invokestatic 430	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   239: ifne -35 -> 204
    //   242: aload 16
    //   244: invokestatic 430	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifeq +6 -> 253
    //   250: goto -46 -> 204
    //   253: aload 13
    //   255: iload 4
    //   257: invokeinterface 425 2 0
    //   262: astore 12
    //   264: aload 13
    //   266: iload 5
    //   268: invokeinterface 434 2 0
    //   273: lstore 10
    //   275: new 216	com/tencent/mobileqq/data/QQAlbumInfo
    //   278: dup
    //   279: invokespecial 220	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   282: astore 14
    //   284: aload 14
    //   286: aload 16
    //   288: putfield 233	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   291: aload 14
    //   293: aload 15
    //   295: putfield 225	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   298: aload 14
    //   300: lload 10
    //   302: putfield 437	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   305: aload 14
    //   307: getfield 297	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   310: astore 15
    //   312: aload 15
    //   314: aload 12
    //   316: putfield 325	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   319: aload 15
    //   321: aload 13
    //   323: iload 6
    //   325: invokeinterface 434 2 0
    //   330: putfield 312	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   333: aload 15
    //   335: lload 10
    //   337: putfield 306	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   340: aload 15
    //   342: aload 13
    //   344: iload 7
    //   346: invokeinterface 440 2 0
    //   351: putfield 442	com/tencent/mobileqq/activity/photo/LocalMediaInfo:orientation	I
    //   354: aload 15
    //   356: aload 13
    //   358: iload 8
    //   360: invokeinterface 425 2 0
    //   365: putfield 331	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   368: ldc 94
    //   370: aload 15
    //   372: getfield 331	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   375: invokevirtual 446	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   378: ifeq +11 -> 389
    //   381: aload 15
    //   383: ldc_w 448
    //   386: putfield 331	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   389: aload 14
    //   391: aload 13
    //   393: iload 9
    //   395: invokeinterface 440 2 0
    //   400: putfield 236	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   403: aload_1
    //   404: aload 14
    //   406: invokeinterface 451 2 0
    //   411: pop
    //   412: goto -208 -> 204
    //   415: aload_1
    //   416: astore 14
    //   418: aload 13
    //   420: ifnull +110 -> 530
    //   423: aload 13
    //   425: invokeinterface 339 1 0
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
    //   489: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq +18 -> 510
    //   495: aload 12
    //   497: astore_1
    //   498: ldc_w 453
    //   501: iconst_2
    //   502: ldc_w 455
    //   505: aload 14
    //   507: invokestatic 457	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   510: aload 13
    //   512: astore 14
    //   514: aload 12
    //   516: ifnull +14 -> 530
    //   519: aload 12
    //   521: invokeinterface 339 1 0
    //   526: aload 13
    //   528: astore 14
    //   530: aload 14
    //   532: areturn
    //   533: astore 12
    //   535: goto -63 -> 472
    //   538: aload_1
    //   539: ifnull +9 -> 548
    //   542: aload_1
    //   543: invokeinterface 339 1 0
    //   548: goto +6 -> 554
    //   551: aload 12
    //   553: athrow
    //   554: goto -3 -> 551
    //   557: goto -505 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	560	0	this	AEAlbumListAdapter
    //   0	560	1	paramContext	Context
    //   0	560	2	paramInt	int
    //   136	91	3	i	int
    //   146	110	4	j	int
    //   157	110	5	k	int
    //   168	156	6	m	int
    //   179	166	7	n	int
    //   190	169	8	i1	int
    //   202	192	9	i2	int
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
    //   13: getstatic 242	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   16: astore 12
    //   18: goto +447 -> 465
    //   21: aload 14
    //   23: astore_3
    //   24: getstatic 242	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   27: invokevirtual 365	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   30: astore 12
    //   32: aload 14
    //   34: astore_3
    //   35: aload 12
    //   37: ldc_w 367
    //   40: iload_2
    //   41: invokestatic 371	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   44: invokevirtual 377	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   47: pop
    //   48: aload 14
    //   50: astore_3
    //   51: aload 12
    //   53: invokevirtual 381	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   56: astore 12
    //   58: goto +407 -> 465
    //   61: aload 14
    //   63: astore_3
    //   64: aload_1
    //   65: invokevirtual 248	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   68: aload 12
    //   70: getstatic 141	com/tencent/aelight/camera/ae/album/adapter/AEAlbumListAdapter:d	[Ljava/lang/String;
    //   73: ldc_w 461
    //   76: aconst_null
    //   77: ldc_w 410
    //   80: invokevirtual 258	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 12
    //   85: aload 12
    //   87: ifnonnull +17 -> 104
    //   90: aload 12
    //   92: ifnull +10 -> 102
    //   95: aload 12
    //   97: invokeinterface 339 1 0
    //   102: aconst_null
    //   103: areturn
    //   104: new 412	java/util/LinkedList
    //   107: dup
    //   108: invokespecial 413	java/util/LinkedList:<init>	()V
    //   111: astore_1
    //   112: aload 12
    //   114: ldc 34
    //   116: invokeinterface 417 2 0
    //   121: istore_2
    //   122: aload 12
    //   124: ldc 131
    //   126: invokeinterface 417 2 0
    //   131: istore 4
    //   133: aload 12
    //   135: ldc 36
    //   137: invokeinterface 417 2 0
    //   142: istore 5
    //   144: aload 12
    //   146: ldc 42
    //   148: invokeinterface 417 2 0
    //   153: istore 6
    //   155: aload 12
    //   157: ldc 40
    //   159: invokeinterface 417 2 0
    //   164: istore 7
    //   166: aload 12
    //   168: ldc 46
    //   170: invokeinterface 417 2 0
    //   175: istore 8
    //   177: aload 12
    //   179: ldc_w 419
    //   182: invokeinterface 417 2 0
    //   187: istore 9
    //   189: aload 12
    //   191: invokeinterface 422 1 0
    //   196: ifeq +159 -> 355
    //   199: aload 12
    //   201: iload_2
    //   202: invokeinterface 425 2 0
    //   207: astore 13
    //   209: aload 12
    //   211: iload 5
    //   213: invokeinterface 425 2 0
    //   218: astore 14
    //   220: aload 13
    //   222: invokestatic 430	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   225: ifne -36 -> 189
    //   228: aload 14
    //   230: invokestatic 430	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifeq +6 -> 239
    //   236: goto -47 -> 189
    //   239: aload 12
    //   241: iload 7
    //   243: invokeinterface 434 2 0
    //   248: lstore 10
    //   250: new 216	com/tencent/mobileqq/data/QQAlbumInfo
    //   253: dup
    //   254: invokespecial 220	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   257: astore_3
    //   258: aload_3
    //   259: aload 14
    //   261: putfield 233	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   264: aload_3
    //   265: aload 13
    //   267: putfield 225	com/tencent/mobileqq/data/QQAlbumInfo:id	Ljava/lang/String;
    //   270: aload_3
    //   271: lload 10
    //   273: putfield 437	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   276: aload_3
    //   277: getfield 297	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   280: astore 13
    //   282: aload 13
    //   284: aload 12
    //   286: iload 6
    //   288: invokeinterface 425 2 0
    //   293: putfield 325	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   296: aload 13
    //   298: aload 12
    //   300: iload 4
    //   302: invokeinterface 434 2 0
    //   307: putfield 312	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   310: aload 13
    //   312: lload 10
    //   314: putfield 306	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   317: aload 13
    //   319: aload 12
    //   321: iload 8
    //   323: invokeinterface 425 2 0
    //   328: putfield 331	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   331: aload_3
    //   332: aload 12
    //   334: iload 9
    //   336: invokeinterface 440 2 0
    //   341: putfield 236	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   344: aload_1
    //   345: aload_3
    //   346: invokeinterface 451 2 0
    //   351: pop
    //   352: goto -163 -> 189
    //   355: aload_1
    //   356: astore_3
    //   357: aload 12
    //   359: ifnull +86 -> 445
    //   362: aload 12
    //   364: invokeinterface 339 1 0
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
    //   408: invokestatic 344	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +18 -> 429
    //   414: aload 12
    //   416: astore_3
    //   417: ldc_w 453
    //   420: iconst_2
    //   421: ldc_w 463
    //   424: aload 13
    //   426: invokestatic 457	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   429: aload_1
    //   430: astore_3
    //   431: aload 12
    //   433: ifnull +12 -> 445
    //   436: aload 12
    //   438: invokeinterface 339 1 0
    //   443: aload_1
    //   444: astore_3
    //   445: aload_3
    //   446: areturn
    //   447: aload_3
    //   448: ifnull +9 -> 457
    //   451: aload_3
    //   452: invokeinterface 339 1 0
    //   457: goto +5 -> 462
    //   460: aload_1
    //   461: athrow
    //   462: goto -2 -> 460
    //   465: goto -404 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	AEAlbumListAdapter
    //   0	468	1	paramContext	Context
    //   0	468	2	paramInt	int
    //   0	468	3	paramMediaFileFilter	MediaFileFilter
    //   131	170	4	i	int
    //   142	70	5	j	int
    //   153	134	6	k	int
    //   164	78	7	m	int
    //   175	147	8	n	int
    //   187	148	9	i1	int
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
    int n = paramCursor.getColumnIndexOrThrow("_id");
    int j = paramCursor.getColumnIndexOrThrow("_data");
    int i = paramCursor.getColumnIndexOrThrow("date_modified");
    int i1 = paramCursor.getColumnIndexOrThrow("duration");
    int i2 = paramCursor.getColumnIndexOrThrow("mime_type");
    int i3 = paramCursor.getColumnIndexOrThrow("_size");
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    while (paramCursor.moveToNext())
    {
      String str = paramCursor.getString(i2);
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
        localObject = paramCursor.getString(j);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
        {
          long l = paramCursor.getLong(i);
          LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
          localLocalMediaInfo._id = paramCursor.getLong(n);
          localLocalMediaInfo.path = ((String)localObject);
          localLocalMediaInfo.mMimeType = str;
          localLocalMediaInfo.modifiedDate = l;
          localLocalMediaInfo.mDuration = paramCursor.getLong(i1);
          localLocalMediaInfo.fileSize = paramCursor.getLong(i3);
          localArrayList.add(localLocalMediaInfo);
          int m = k + 1;
          k = m;
          if (paramInt > 0)
          {
            k = m;
            if (m >= paramInt) {
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
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack.a(-1);
  }
  
  void a(QQAlbumInfo paramQQAlbumInfo)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return;
    }
    if (localList.isEmpty()) {
      this.jdField_a_of_type_JavaUtilList.add(paramQQAlbumInfo);
    } else if (((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(0)).id.equals("$RecentAlbumId")) {
      this.jdField_a_of_type_JavaUtilList.set(0, paramQQAlbumInfo);
    }
    b(paramQQAlbumInfo);
    notifyDataSetChanged();
  }
  
  void a(List<QQAlbumInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public QQAlbumInfo b(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (paramMediaFileFilter == null) {
      return null;
    }
    if (paramMediaFileFilter.showImage()) {
      return a(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
    }
    return a(paramContext, paramInt1, paramInt2, paramMediaFileFilter);
  }
  
  protected void b(QQAlbumInfo paramQQAlbumInfo) {}
  
  public void b(List<QQAlbumInfo> paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramList);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AEAlbumListAdapter.1(this, paramList));
  }
  
  public void c(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramQQAlbumInfo);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AEAlbumListAdapter.2(this, paramQQAlbumInfo));
  }
  
  void d(QQAlbumInfo paramQQAlbumInfo)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return;
    }
    if (localList.size() < 2)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramQQAlbumInfo);
    }
    else
    {
      int k = 0;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        if (((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(i)).id.equals("$VideoAlbumId"))
        {
          j = 1;
          break;
        }
        i += 1;
      }
      if (j != 0)
      {
        if (paramQQAlbumInfo.mMediaFileCount > 0) {
          this.jdField_a_of_type_JavaUtilList.set(i, paramQQAlbumInfo);
        } else {
          this.jdField_a_of_type_JavaUtilList.remove(i);
        }
      }
      else if (paramQQAlbumInfo.mMediaFileCount > 0) {
        this.jdField_a_of_type_JavaUtilList.add(1, paramQQAlbumInfo);
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
    this.jdField_a_of_type_AndroidOsHandler.post(new AEAlbumListAdapter.3(this, paramQQAlbumInfo));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return QAlbumUtil.getMediaType(((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mCoverInfo);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack.a(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return QAlbumUtil.MEDIA_TYPE_MAPS.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.adapter.AEAlbumListAdapter
 * JD-Core Version:    0.7.0.1
 */