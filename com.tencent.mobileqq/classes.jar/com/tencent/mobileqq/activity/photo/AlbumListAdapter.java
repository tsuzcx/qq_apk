package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import wsn;
import wso;
import wsp;
import wsq;
import wsr;
import wss;
import wst;

public class AlbumListAdapter
  extends BaseAdapter
{
  static final ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-2141891243);
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "orientation", "mime_type", "COUNT(_data) as count" };
  static String[] jdField_b_of_type_ArrayOfJavaLangString;
  static final String[] jdField_c_of_type_ArrayOfJavaLangString;
  static final String[] jdField_d_of_type_ArrayOfJavaLangString;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public Activity a;
  Resources jdField_a_of_type_AndroidContentResResources;
  Drawable.ConstantState jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  public MediaFileFilter a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public List a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  private List jdField_b_of_type_JavaUtilList;
  boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 100;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e = -1;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size", "width" };; jdField_b_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "mime_type", "date_modified", "orientation", "_size" })
    {
      jdField_c_of_type_ArrayOfJavaLangString = new String[] { "_id", "_data", "duration", "date_modified", "mime_type", "_size" };
      jdField_d_of_type_ArrayOfJavaLangString = new String[] { "bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "mime_type", "COUNT(_data) as count" };
      return;
    }
  }
  
  public AlbumListAdapter(Activity paramActivity, MediaFileFilter paramMediaFileFilter, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentResResources = paramActivity.getResources();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = paramMediaFileFilter;
    if (paramList != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130838337).getConstantState();
      this.jdField_b_of_type_JavaUtilList = paramList;
      this.jdField_d_of_type_Boolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131558591);
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      ThreadManager.getFileThreadHandler().post(new wsn(this));
      return;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130838480).getConstantState();
    }
  }
  
  static boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = paramString.toLowerCase();
      if (paramString.equalsIgnoreCase("camera")) {
        return true;
      }
    } while (!paramString.equalsIgnoreCase("100media"));
    return true;
  }
  
  public QQAlbumInfo a(int paramInt)
  {
    return (QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  /* Error */
  public QQAlbumInfo a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 177	com/tencent/mobileqq/data/QQAlbumInfo
    //   5: dup
    //   6: invokespecial 181	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: ldc 183
    //   15: putfield 186	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   18: aload 4
    //   20: ldc 188
    //   22: putfield 191	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   25: aload 4
    //   27: iconst_0
    //   28: putfield 194	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   31: getstatic 200	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   34: astore_2
    //   35: aload_1
    //   36: invokevirtual 206	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   39: aload_2
    //   40: getstatic 69	com/tencent/mobileqq/activity/photo/AlbumListAdapter:jdField_c_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   43: ldc 208
    //   45: aconst_null
    //   46: ldc 210
    //   48: invokevirtual 216	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   51: astore_2
    //   52: aload_2
    //   53: astore_1
    //   54: getstatic 221	com/tencent/mobileqq/activity/photo/MediaFileFilter:a	Landroid/util/SparseArray;
    //   57: iconst_2
    //   58: invokevirtual 224	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   61: checkcast 218	com/tencent/mobileqq/activity/photo/MediaFileFilter
    //   64: astore 5
    //   66: aload 5
    //   68: ifnull +14 -> 82
    //   71: aload_2
    //   72: astore_1
    //   73: aload_0
    //   74: aload_2
    //   75: iconst_m1
    //   76: aload 5
    //   78: invokevirtual 227	com/tencent/mobileqq/activity/photo/AlbumListAdapter:a	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   81: astore_3
    //   82: aload_2
    //   83: astore_1
    //   84: invokestatic 233	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   87: invokestatic 238	com/tencent/mobileqq/activity/photo/MediaScanner:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/activity/photo/MediaScanner;
    //   90: iconst_0
    //   91: iconst_m1
    //   92: invokevirtual 241	com/tencent/mobileqq/activity/photo/MediaScanner:a	(ZI)Ljava/util/ArrayList;
    //   95: astore 5
    //   97: aload_3
    //   98: ifnull +50 -> 148
    //   101: aload_2
    //   102: astore_1
    //   103: aload_3
    //   104: invokeinterface 245 1 0
    //   109: ifne +39 -> 148
    //   112: aload_2
    //   113: astore_1
    //   114: aload 4
    //   116: aload 4
    //   118: getfield 194	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   121: aload_3
    //   122: invokeinterface 249 1 0
    //   127: iadd
    //   128: putfield 194	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   131: aload_2
    //   132: astore_1
    //   133: aload 4
    //   135: aload_3
    //   136: iconst_0
    //   137: invokeinterface 175 2 0
    //   142: checkcast 251	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   145: putfield 255	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   148: aload 5
    //   150: ifnull +181 -> 331
    //   153: aload_2
    //   154: astore_1
    //   155: aload 5
    //   157: invokevirtual 256	java/util/ArrayList:isEmpty	()Z
    //   160: ifne +171 -> 331
    //   163: aload_2
    //   164: astore_1
    //   165: aload 4
    //   167: aload 4
    //   169: getfield 194	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   172: aload 5
    //   174: invokevirtual 257	java/util/ArrayList:size	()I
    //   177: iadd
    //   178: putfield 194	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   181: aload_2
    //   182: astore_1
    //   183: aload 5
    //   185: iconst_0
    //   186: invokevirtual 258	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   189: checkcast 260	com/tencent/mobileqq/activity/photo/MediaScannerInfo
    //   192: astore_3
    //   193: aload_2
    //   194: astore_1
    //   195: aload 4
    //   197: getfield 255	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   200: ifnull +21 -> 221
    //   203: aload_2
    //   204: astore_1
    //   205: aload 4
    //   207: getfield 255	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   210: getfield 263	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   213: aload_3
    //   214: getfield 265	com/tencent/mobileqq/activity/photo/MediaScannerInfo:b	J
    //   217: lcmp
    //   218: ifge +113 -> 331
    //   221: aload_2
    //   222: astore_1
    //   223: aload 4
    //   225: new 251	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   228: dup
    //   229: invokespecial 266	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   232: putfield 255	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   235: aload_2
    //   236: astore_1
    //   237: aload 4
    //   239: getfield 255	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   242: aload_3
    //   243: getfield 267	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_a_of_type_Int	I
    //   246: i2l
    //   247: putfield 269	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   250: aload_2
    //   251: astore_1
    //   252: aload 4
    //   254: getfield 255	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   257: aload_3
    //   258: getfield 271	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_c_of_type_Long	J
    //   261: putfield 274	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   264: aload_2
    //   265: astore_1
    //   266: aload 4
    //   268: getfield 255	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   271: aload_3
    //   272: getfield 276	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_a_of_type_Long	J
    //   275: putfield 279	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   278: aload_2
    //   279: astore_1
    //   280: aload 4
    //   282: getfield 255	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   285: aload_3
    //   286: getfield 281	com/tencent/mobileqq/activity/photo/MediaScannerInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   289: putfield 284	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   292: aload_2
    //   293: astore_1
    //   294: aload 4
    //   296: getfield 255	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   299: aload_3
    //   300: getfield 265	com/tencent/mobileqq/activity/photo/MediaScannerInfo:b	J
    //   303: putfield 263	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   306: aload_2
    //   307: astore_1
    //   308: aload 4
    //   310: getfield 255	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   313: aload_3
    //   314: getfield 286	com/tencent/mobileqq/activity/photo/MediaScannerInfo:d	Ljava/lang/String;
    //   317: putfield 289	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   320: aload_2
    //   321: astore_1
    //   322: aload 4
    //   324: getfield 255	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   327: iconst_0
    //   328: putfield 292	com/tencent/mobileqq/activity/photo/LocalMediaInfo:isSystemMeidaStore	Z
    //   331: aload_2
    //   332: ifnull +9 -> 341
    //   335: aload_2
    //   336: invokeinterface 297 1 0
    //   341: aload 4
    //   343: areturn
    //   344: astore_3
    //   345: aconst_null
    //   346: astore_2
    //   347: aload_2
    //   348: astore_1
    //   349: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq +17 -> 369
    //   355: aload_2
    //   356: astore_1
    //   357: ldc_w 304
    //   360: iconst_2
    //   361: aload_3
    //   362: invokevirtual 307	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   365: aload_3
    //   366: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   369: aload_2
    //   370: ifnull -29 -> 341
    //   373: aload_2
    //   374: invokeinterface 297 1 0
    //   379: aload 4
    //   381: areturn
    //   382: astore_2
    //   383: aconst_null
    //   384: astore_1
    //   385: aload_1
    //   386: ifnull +9 -> 395
    //   389: aload_1
    //   390: invokeinterface 297 1 0
    //   395: aload_2
    //   396: athrow
    //   397: astore_2
    //   398: goto -13 -> 385
    //   401: astore_3
    //   402: goto -55 -> 347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	this	AlbumListAdapter
    //   0	405	1	paramContext	Context
    //   34	340	2	localObject1	Object
    //   382	14	2	localObject2	Object
    //   397	1	2	localObject3	Object
    //   1	313	3	localObject4	Object
    //   344	22	3	localException1	java.lang.Exception
    //   401	1	3	localException2	java.lang.Exception
    //   9	371	4	localQQAlbumInfo	QQAlbumInfo
    //   64	120	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   31	52	344	java/lang/Exception
    //   31	52	382	finally
    //   54	66	397	finally
    //   73	82	397	finally
    //   84	97	397	finally
    //   103	112	397	finally
    //   114	131	397	finally
    //   133	148	397	finally
    //   155	163	397	finally
    //   165	181	397	finally
    //   183	193	397	finally
    //   195	203	397	finally
    //   205	221	397	finally
    //   223	235	397	finally
    //   237	250	397	finally
    //   252	264	397	finally
    //   266	278	397	finally
    //   280	292	397	finally
    //   294	306	397	finally
    //   308	320	397	finally
    //   322	331	397	finally
    //   349	355	397	finally
    //   357	369	397	finally
    //   54	66	401	java/lang/Exception
    //   73	82	401	java/lang/Exception
    //   84	97	401	java/lang/Exception
    //   103	112	401	java/lang/Exception
    //   114	131	401	java/lang/Exception
    //   133	148	401	java/lang/Exception
    //   155	163	401	java/lang/Exception
    //   165	181	401	java/lang/Exception
    //   183	193	401	java/lang/Exception
    //   195	203	401	java/lang/Exception
    //   205	221	401	java/lang/Exception
    //   223	235	401	java/lang/Exception
    //   237	250	401	java/lang/Exception
    //   252	264	401	java/lang/Exception
    //   266	278	401	java/lang/Exception
    //   280	292	401	java/lang/Exception
    //   294	306	401	java/lang/Exception
    //   308	320	401	java/lang/Exception
    //   322	331	401	java/lang/Exception
  }
  
  /* Error */
  QQAlbumInfo a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iload_3
    //   7: ifgt +14 -> 21
    //   10: new 313	java/lang/IllegalArgumentException
    //   13: dup
    //   14: ldc_w 315
    //   17: invokespecial 318	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: new 177	com/tencent/mobileqq/data/QQAlbumInfo
    //   24: dup
    //   25: invokespecial 181	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   28: astore 8
    //   30: aload 8
    //   32: ldc_w 320
    //   35: putfield 186	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   38: aload 8
    //   40: ldc_w 322
    //   43: putfield 191	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   46: iload_3
    //   47: ifle +141 -> 188
    //   50: getstatic 200	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   53: invokevirtual 328	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   56: astore 5
    //   58: aload 5
    //   60: ldc_w 330
    //   63: iload_3
    //   64: invokestatic 334	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   67: invokevirtual 340	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   70: pop
    //   71: aload 5
    //   73: invokevirtual 344	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   76: astore 5
    //   78: aload_1
    //   79: invokevirtual 206	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   82: aload 5
    //   84: getstatic 69	com/tencent/mobileqq/activity/photo/AlbumListAdapter:jdField_c_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   87: ldc 208
    //   89: aconst_null
    //   90: ldc 210
    //   92: invokevirtual 216	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   95: astore_1
    //   96: aload 4
    //   98: ifnull +16 -> 114
    //   101: aload_1
    //   102: astore 5
    //   104: aload_0
    //   105: aload_1
    //   106: iload_3
    //   107: aload 4
    //   109: invokevirtual 227	com/tencent/mobileqq/activity/photo/AlbumListAdapter:a	(Landroid/database/Cursor;ILcom/tencent/mobileqq/activity/photo/MediaFileFilter;)Ljava/util/List;
    //   112: astore 6
    //   114: aload 6
    //   116: ifnull +59 -> 175
    //   119: aload_1
    //   120: astore 5
    //   122: aload 6
    //   124: invokeinterface 245 1 0
    //   129: ifne +46 -> 175
    //   132: aload_1
    //   133: astore 5
    //   135: aload 6
    //   137: invokeinterface 249 1 0
    //   142: istore_2
    //   143: aload_1
    //   144: astore 5
    //   146: aload 8
    //   148: iload_2
    //   149: putfield 194	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   152: iload_2
    //   153: ifle +22 -> 175
    //   156: aload_1
    //   157: astore 5
    //   159: aload 8
    //   161: aload 6
    //   163: iconst_0
    //   164: invokeinterface 175 2 0
    //   169: checkcast 251	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   172: putfield 255	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   175: aload_1
    //   176: ifnull +9 -> 185
    //   179: aload_1
    //   180: invokeinterface 297 1 0
    //   185: aload 8
    //   187: areturn
    //   188: getstatic 200	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   191: astore 5
    //   193: goto -115 -> 78
    //   196: astore 4
    //   198: aconst_null
    //   199: astore_1
    //   200: aload_1
    //   201: astore 5
    //   203: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +20 -> 226
    //   209: aload_1
    //   210: astore 5
    //   212: ldc_w 304
    //   215: iconst_2
    //   216: aload 4
    //   218: invokevirtual 307	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: aload 4
    //   223: invokestatic 310	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload_1
    //   227: ifnull -42 -> 185
    //   230: aload_1
    //   231: invokeinterface 297 1 0
    //   236: aload 8
    //   238: areturn
    //   239: astore_1
    //   240: aload 7
    //   242: astore 4
    //   244: aload 4
    //   246: ifnull +10 -> 256
    //   249: aload 4
    //   251: invokeinterface 297 1 0
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: aload 5
    //   261: astore 4
    //   263: goto -19 -> 244
    //   266: astore 4
    //   268: goto -68 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	AlbumListAdapter
    //   0	271	1	paramContext	Context
    //   0	271	2	paramInt1	int
    //   0	271	3	paramInt2	int
    //   0	271	4	paramMediaFileFilter	MediaFileFilter
    //   56	204	5	localObject1	Object
    //   4	158	6	localList	List
    //   1	240	7	localObject2	Object
    //   28	209	8	localQQAlbumInfo	QQAlbumInfo
    // Exception table:
    //   from	to	target	type
    //   50	78	196	java/lang/Exception
    //   78	96	196	java/lang/Exception
    //   188	193	196	java/lang/Exception
    //   50	78	239	finally
    //   78	96	239	finally
    //   188	193	239	finally
    //   104	114	258	finally
    //   122	132	258	finally
    //   135	143	258	finally
    //   146	152	258	finally
    //   159	175	258	finally
    //   203	209	258	finally
    //   212	226	258	finally
    //   104	114	266	java/lang/Exception
    //   122	132	266	java/lang/Exception
    //   135	143	266	java/lang/Exception
    //   146	152	266	java/lang/Exception
    //   159	175	266	java/lang/Exception
  }
  
  QQAlbumInfo a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList paramArrayList)
  {
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo._id = "$RecentAlbumId";
    localQQAlbumInfo.name = "最近照片";
    paramArrayList = AlbumUtil.a(paramContext, paramInt3, paramInt2, paramMediaFileFilter, paramBoolean, paramInt1, paramArrayList, false);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramArrayList.get(0));
      localQQAlbumInfo.mMediaFileCount = paramArrayList.size();
    }
    if (localQQAlbumInfo.mMediaFileCount >= paramInt2) {
      return localQQAlbumInfo;
    }
    paramContext = AlbumUtil.a(paramContext, 0, paramInt2, paramMediaFileFilter, -1L);
    if (paramContext == null) {
      return localQQAlbumInfo;
    }
    if ((localQQAlbumInfo.mMediaFileCount == 0) && (paramContext.size() > 0)) {
      localQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)paramContext.get(0));
    }
    if (localQQAlbumInfo.mMediaFileCount + paramContext.size() <= paramInt2) {}
    for (localQQAlbumInfo.mMediaFileCount += paramContext.size();; localQQAlbumInfo.mMediaFileCount = paramInt2) {
      return localQQAlbumInfo;
    }
  }
  
  /* Error */
  public List a(Context paramContext, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +69 -> 70
    //   4: getstatic 359	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore 13
    //   9: ldc_w 361
    //   12: astore 14
    //   14: aload_3
    //   15: instanceof 363
    //   18: ifeq +8 -> 26
    //   21: ldc_w 365
    //   24: astore 14
    //   26: aload_1
    //   27: invokevirtual 206	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   30: aload 13
    //   32: getstatic 52	com/tencent/mobileqq/activity/photo/AlbumListAdapter:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   35: aload 14
    //   37: aconst_null
    //   38: ldc_w 367
    //   41: invokevirtual 216	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_3
    //   45: aload_3
    //   46: ifnonnull +55 -> 101
    //   49: aconst_null
    //   50: astore_1
    //   51: aload_1
    //   52: astore 13
    //   54: aload_3
    //   55: ifnull +12 -> 67
    //   58: aload_3
    //   59: invokeinterface 297 1 0
    //   64: aload_1
    //   65: astore 13
    //   67: aload 13
    //   69: areturn
    //   70: getstatic 359	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   73: invokevirtual 328	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   76: astore 13
    //   78: aload 13
    //   80: ldc_w 330
    //   83: iload_2
    //   84: invokestatic 334	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   87: invokevirtual 340	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   90: pop
    //   91: aload 13
    //   93: invokevirtual 344	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   96: astore 13
    //   98: goto -89 -> 9
    //   101: aload_3
    //   102: astore 13
    //   104: new 369	java/util/LinkedList
    //   107: dup
    //   108: invokespecial 370	java/util/LinkedList:<init>	()V
    //   111: astore_1
    //   112: aload_3
    //   113: astore 13
    //   115: aload_3
    //   116: ldc 36
    //   118: invokeinterface 374 2 0
    //   123: istore_2
    //   124: aload_3
    //   125: astore 13
    //   127: aload_3
    //   128: ldc 38
    //   130: invokeinterface 374 2 0
    //   135: istore 4
    //   137: aload_3
    //   138: astore 13
    //   140: aload_3
    //   141: ldc 44
    //   143: invokeinterface 374 2 0
    //   148: istore 5
    //   150: aload_3
    //   151: astore 13
    //   153: aload_3
    //   154: ldc 42
    //   156: invokeinterface 374 2 0
    //   161: istore 6
    //   163: aload_3
    //   164: astore 13
    //   166: aload_3
    //   167: ldc 59
    //   169: invokeinterface 374 2 0
    //   174: istore 7
    //   176: aload_3
    //   177: astore 13
    //   179: aload_3
    //   180: ldc 46
    //   182: invokeinterface 374 2 0
    //   187: istore 8
    //   189: aload_3
    //   190: astore 13
    //   192: aload_3
    //   193: ldc 48
    //   195: invokeinterface 374 2 0
    //   200: istore 9
    //   202: aload_3
    //   203: astore 13
    //   205: aload_3
    //   206: ldc_w 376
    //   209: invokeinterface 374 2 0
    //   214: istore 10
    //   216: aload_3
    //   217: astore 13
    //   219: aload_3
    //   220: invokeinterface 379 1 0
    //   225: ifeq +296 -> 521
    //   228: aload_3
    //   229: astore 13
    //   231: aload_3
    //   232: iload_2
    //   233: invokeinterface 382 2 0
    //   238: astore 16
    //   240: aload_3
    //   241: astore 13
    //   243: aload_3
    //   244: iload 4
    //   246: invokeinterface 382 2 0
    //   251: astore 17
    //   253: aload_3
    //   254: astore 13
    //   256: aload 16
    //   258: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   261: ifne -45 -> 216
    //   264: aload_3
    //   265: astore 13
    //   267: aload 17
    //   269: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   272: ifne -56 -> 216
    //   275: aload_3
    //   276: astore 13
    //   278: aload_3
    //   279: iload 5
    //   281: invokeinterface 382 2 0
    //   286: astore 14
    //   288: aload_3
    //   289: astore 13
    //   291: aload_3
    //   292: iload 6
    //   294: invokeinterface 391 2 0
    //   299: lstore 11
    //   301: aload_3
    //   302: astore 13
    //   304: new 177	com/tencent/mobileqq/data/QQAlbumInfo
    //   307: dup
    //   308: invokespecial 181	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   311: astore 15
    //   313: aload_3
    //   314: astore 13
    //   316: aload 15
    //   318: aload 17
    //   320: putfield 191	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   323: aload_3
    //   324: astore 13
    //   326: aload 15
    //   328: aload 16
    //   330: putfield 186	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   333: aload_3
    //   334: astore 13
    //   336: aload 15
    //   338: lload 11
    //   340: putfield 394	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   343: aload_3
    //   344: astore 13
    //   346: aload 15
    //   348: getfield 255	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   351: astore 16
    //   353: aload_3
    //   354: astore 13
    //   356: aload 16
    //   358: aload 14
    //   360: putfield 284	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   363: aload_3
    //   364: astore 13
    //   366: aload 16
    //   368: aload_3
    //   369: iload 7
    //   371: invokeinterface 391 2 0
    //   376: putfield 269	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   379: aload_3
    //   380: astore 13
    //   382: aload 16
    //   384: lload 11
    //   386: putfield 263	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   389: aload_3
    //   390: astore 13
    //   392: aload 16
    //   394: aload_3
    //   395: iload 8
    //   397: invokeinterface 397 2 0
    //   402: putfield 399	com/tencent/mobileqq/activity/photo/LocalMediaInfo:orientation	I
    //   405: aload_3
    //   406: astore 13
    //   408: aload 16
    //   410: aload_3
    //   411: iload 9
    //   413: invokeinterface 382 2 0
    //   418: putfield 289	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   421: aload_3
    //   422: astore 13
    //   424: ldc_w 401
    //   427: aload 16
    //   429: getfield 289	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   432: invokevirtual 405	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   435: ifeq +14 -> 449
    //   438: aload_3
    //   439: astore 13
    //   441: aload 16
    //   443: ldc_w 407
    //   446: putfield 289	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   449: aload_3
    //   450: astore 13
    //   452: aload 15
    //   454: aload_3
    //   455: iload 10
    //   457: invokeinterface 397 2 0
    //   462: putfield 194	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   465: aload_3
    //   466: astore 13
    //   468: aload_1
    //   469: aload 15
    //   471: invokeinterface 410 2 0
    //   476: pop
    //   477: goto -261 -> 216
    //   480: astore 14
    //   482: aload_3
    //   483: astore 13
    //   485: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   488: ifeq +18 -> 506
    //   491: aload_3
    //   492: astore 13
    //   494: ldc_w 412
    //   497: iconst_2
    //   498: ldc_w 414
    //   501: aload 14
    //   503: invokestatic 416	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   506: aload_1
    //   507: astore 13
    //   509: aload_3
    //   510: ifnull -443 -> 67
    //   513: aload_3
    //   514: invokeinterface 297 1 0
    //   519: aload_1
    //   520: areturn
    //   521: aload_1
    //   522: astore 13
    //   524: aload_3
    //   525: ifnull -458 -> 67
    //   528: aload_3
    //   529: invokeinterface 297 1 0
    //   534: aload_1
    //   535: areturn
    //   536: astore_1
    //   537: aconst_null
    //   538: astore 13
    //   540: aload 13
    //   542: ifnull +10 -> 552
    //   545: aload 13
    //   547: invokeinterface 297 1 0
    //   552: aload_1
    //   553: athrow
    //   554: astore_1
    //   555: goto -15 -> 540
    //   558: astore 14
    //   560: aconst_null
    //   561: astore_3
    //   562: aconst_null
    //   563: astore_1
    //   564: goto -82 -> 482
    //   567: astore 14
    //   569: aconst_null
    //   570: astore_1
    //   571: goto -89 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	574	0	this	AlbumListAdapter
    //   0	574	1	paramContext	Context
    //   0	574	2	paramInt	int
    //   0	574	3	paramMediaFileFilter	MediaFileFilter
    //   135	110	4	i	int
    //   148	132	5	j	int
    //   161	132	6	k	int
    //   174	196	7	m	int
    //   187	209	8	n	int
    //   200	212	9	i1	int
    //   214	242	10	i2	int
    //   299	86	11	l	long
    //   7	539	13	localObject1	Object
    //   12	347	14	str1	String
    //   480	22	14	localException1	java.lang.Exception
    //   558	1	14	localException2	java.lang.Exception
    //   567	1	14	localException3	java.lang.Exception
    //   311	159	15	localQQAlbumInfo	QQAlbumInfo
    //   238	204	16	localObject2	Object
    //   251	68	17	str2	String
    // Exception table:
    //   from	to	target	type
    //   115	124	480	java/lang/Exception
    //   127	137	480	java/lang/Exception
    //   140	150	480	java/lang/Exception
    //   153	163	480	java/lang/Exception
    //   166	176	480	java/lang/Exception
    //   179	189	480	java/lang/Exception
    //   192	202	480	java/lang/Exception
    //   205	216	480	java/lang/Exception
    //   219	228	480	java/lang/Exception
    //   231	240	480	java/lang/Exception
    //   243	253	480	java/lang/Exception
    //   256	264	480	java/lang/Exception
    //   267	275	480	java/lang/Exception
    //   278	288	480	java/lang/Exception
    //   291	301	480	java/lang/Exception
    //   304	313	480	java/lang/Exception
    //   316	323	480	java/lang/Exception
    //   326	333	480	java/lang/Exception
    //   336	343	480	java/lang/Exception
    //   346	353	480	java/lang/Exception
    //   356	363	480	java/lang/Exception
    //   366	379	480	java/lang/Exception
    //   382	389	480	java/lang/Exception
    //   392	405	480	java/lang/Exception
    //   408	421	480	java/lang/Exception
    //   424	438	480	java/lang/Exception
    //   441	449	480	java/lang/Exception
    //   452	465	480	java/lang/Exception
    //   468	477	480	java/lang/Exception
    //   4	9	536	finally
    //   14	21	536	finally
    //   26	45	536	finally
    //   70	98	536	finally
    //   104	112	554	finally
    //   115	124	554	finally
    //   127	137	554	finally
    //   140	150	554	finally
    //   153	163	554	finally
    //   166	176	554	finally
    //   179	189	554	finally
    //   192	202	554	finally
    //   205	216	554	finally
    //   219	228	554	finally
    //   231	240	554	finally
    //   243	253	554	finally
    //   256	264	554	finally
    //   267	275	554	finally
    //   278	288	554	finally
    //   291	301	554	finally
    //   304	313	554	finally
    //   316	323	554	finally
    //   326	333	554	finally
    //   336	343	554	finally
    //   346	353	554	finally
    //   356	363	554	finally
    //   366	379	554	finally
    //   382	389	554	finally
    //   392	405	554	finally
    //   408	421	554	finally
    //   424	438	554	finally
    //   441	449	554	finally
    //   452	465	554	finally
    //   468	477	554	finally
    //   485	491	554	finally
    //   494	506	554	finally
    //   4	9	558	java/lang/Exception
    //   14	21	558	java/lang/Exception
    //   26	45	558	java/lang/Exception
    //   70	98	558	java/lang/Exception
    //   104	112	567	java/lang/Exception
  }
  
  List a(Cursor paramCursor, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    if (paramCursor.getCount() <= 0) {
      return null;
    }
    int k = paramCursor.getColumnIndexOrThrow("_id");
    int m = paramCursor.getColumnIndexOrThrow("_data");
    int n = paramCursor.getColumnIndexOrThrow("date_modified");
    int i1 = paramCursor.getColumnIndexOrThrow("duration");
    int i2 = paramCursor.getColumnIndexOrThrow("mime_type");
    int i3 = paramCursor.getColumnIndexOrThrow("_size");
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    int j;
    do
    {
      do
      {
        String str1;
        String str2;
        do
        {
          for (;;)
          {
            if (!paramCursor.moveToNext()) {
              break label298;
            }
            str1 = paramCursor.getString(i2);
            if ((paramMediaFileFilter == null) || (!paramMediaFileFilter.a(str1))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("AlbumListAdapter", 2, "Filter mime type:" + str1);
            }
          }
          str2 = paramCursor.getString(m);
        } while ((TextUtils.isEmpty(str2)) || (!new File(str2).exists()));
        long l = paramCursor.getLong(n);
        LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
        localLocalMediaInfo._id = paramCursor.getLong(k);
        localLocalMediaInfo.path = str2;
        localLocalMediaInfo.mMimeType = str1;
        localLocalMediaInfo.modifiedDate = l;
        localLocalMediaInfo.mDuration = paramCursor.getLong(i1);
        localLocalMediaInfo.fileSize = paramCursor.getLong(i3);
        localArrayList.add(localLocalMediaInfo);
        j = i + 1;
        i = j;
      } while (paramInt <= 0);
      i = j;
    } while (j < paramInt);
    label298:
    return localArrayList;
  }
  
  List a(List paramList1, List paramList2, int paramInt)
  {
    Object localObject;
    if ((paramList1 == null) && (paramList2 == null)) {
      localObject = null;
    }
    int j;
    int i;
    do
    {
      for (;;)
      {
        LogTag.a();
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label491;
        }
        j = ((List)localObject).size();
        i = 0;
        while (i < j)
        {
          paramList1 = (QQAlbumInfo)((List)localObject).get(i);
          if ((i != 0) && (a(paramList1.name)))
          {
            ((List)localObject).remove(paramList1);
            ((List)localObject).add(0, paramList1);
          }
          i += 1;
        }
        if ((paramList1 != null) || (paramList2 == null)) {
          break;
        }
        localObject = paramList2;
      }
      if (paramList1 == null) {
        break;
      }
      localObject = paramList1;
    } while (paramList2 == null);
    paramList2 = paramList2.iterator();
    label239:
    label631:
    label637:
    for (;;)
    {
      localObject = paramList1;
      if (!paramList2.hasNext()) {
        break;
      }
      localObject = (QQAlbumInfo)paramList2.next();
      Iterator localIterator = paramList1.iterator();
      QQAlbumInfo localQQAlbumInfo;
      while (localIterator.hasNext())
      {
        localQQAlbumInfo = (QQAlbumInfo)localIterator.next();
        if (localQQAlbumInfo._id.equals(((QQAlbumInfo)localObject)._id)) {
          localQQAlbumInfo.mMediaFileCount += ((QQAlbumInfo)localObject).mMediaFileCount;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label637;
        }
        localIterator = paramList1.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          localQQAlbumInfo = (QQAlbumInfo)localIterator.next();
          if (((QQAlbumInfo)localObject).coverDate > localQQAlbumInfo.coverDate)
          {
            j = 1;
            paramList1.add(i, localObject);
          }
        }
        for (i = j;; i = 0)
        {
          if (i != 0) {
            break label631;
          }
          paramList1.add(localObject);
          break;
          i += 1;
          break label239;
          if (!this.jdField_d_of_type_Boolean)
          {
            if (paramInt != -1) {
              break label524;
            }
            if (this.jdField_c_of_type_Boolean)
            {
              paramList1 = b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_d_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter, this.e, true, this.jdField_a_of_type_JavaUtilArrayList);
              ((List)localObject).add(0, paramList1);
            }
          }
          else if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter.b()) && (!this.jdField_d_of_type_Boolean))
          {
            paramList1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            paramList1 = this.jdField_a_of_type_AndroidAppActivity.getContentResolver().query(paramList1, new String[] { "_id" }, "_size>0 ", null, null);
            i = 0;
            if (paramList1 != null)
            {
              i = paramList1.getCount();
              paramList1.close();
            }
            if (i <= 0) {
              break label560;
            }
            this.jdField_a_of_type_Boolean = true;
            if (this.jdField_a_of_type_Boolean)
            {
              if (paramInt != -1) {
                break label593;
              }
              paramList1 = a(this.jdField_a_of_type_AndroidAppActivity);
            }
          }
          for (;;)
          {
            ((List)localObject).add(1, paramList1);
            LogTag.a("PEAK", "compact.queryRecentBucket");
            return localObject;
            paramList1 = b(this.jdField_a_of_type_AndroidAppActivity, 210, 100, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter);
            break;
            paramList1 = new QQAlbumInfo();
            paramList1._id = "$RecentAlbumId";
            paramList1.name = "最近照片";
            paramList1.mCoverInfo = new LocalMediaInfo();
            break;
            paramList1 = MediaScanner.a(BaseApplicationImpl.getContext());
            i = 0;
            if (paramList1 != null) {
              i = paramList1.a();
            }
            if (i <= 0) {
              break label461;
            }
            this.jdField_a_of_type_Boolean = true;
            break label461;
            paramList1 = new QQAlbumInfo();
            paramList1._id = "$VideoAlbumId";
            paramList1.name = "本地视频";
            paramList1.mCoverInfo = new LocalMediaInfo();
          }
        }
        break;
      }
    }
  }
  
  public void a()
  {
    a(-1);
  }
  
  public void a(int paramInt)
  {
    int k = 1;
    int n = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
    List localList;
    int i;
    if ((localObject != null) && (((MediaFileFilter)localObject).a()))
    {
      LogTag.a();
      localList = a(this.jdField_a_of_type_AndroidAppActivity, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter);
      if ((paramInt != -1) && (localList != null) && (localList.size() == paramInt))
      {
        i = 1;
        LogTag.a("PEAK", "queryImageBuckets");
      }
    }
    for (;;)
    {
      int j;
      if ((localObject != null) && (((MediaFileFilter)localObject).b()) && (!this.jdField_d_of_type_Boolean))
      {
        LogTag.a();
        localObject = b(this.jdField_a_of_type_AndroidAppActivity, paramInt, (MediaFileFilter)localObject);
        j = i;
        if (paramInt != -1)
        {
          j = i;
          if (localObject != null)
          {
            j = i;
            if (((List)localObject).size() == paramInt) {
              j = 1;
            }
          }
        }
        LogTag.a("PEAK", "queryVideoBuckets");
      }
      for (;;)
      {
        LogTag.a();
        localList = a(localList, (List)localObject, paramInt);
        if (localList != null) {
          for (i = 0;; i = m + i)
          {
            m = i;
            if (k >= localList.size()) {
              break;
            }
            m = ((QQAlbumInfo)localList.get(k)).mMediaFileCount;
            k += 1;
          }
        }
        int m = 0;
        localObject = new StringBuilder().append("compact(");
        if (localList == null) {}
        for (i = n;; i = localList.size() - 1)
        {
          LogTag.a("PEAK", i + "," + m + ")");
          b(localList);
          if (paramInt != -1)
          {
            if ((j == 0) && (!this.jdField_d_of_type_Boolean)) {
              break;
            }
            ThreadManager.getFileThreadHandler().post(new wss(this));
          }
          return;
        }
        ThreadManager.getFileThreadHandler().post(new wst(this));
        return;
        localObject = null;
        j = i;
      }
      i = 0;
      break;
      localList = null;
      i = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, ArrayList paramArrayList)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.e = paramInt3;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_a_of_type_JavaUtilList.add(paramQQAlbumInfo);
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Long > 0L))
      {
        paramQQAlbumInfo = new QQAlbumInfo();
        paramQQAlbumInfo._id = "qzone_album";
        paramQQAlbumInfo.name = "空间相册";
        paramQQAlbumInfo.mMediaFileCount = ((int)this.jdField_a_of_type_Long);
        this.jdField_a_of_type_JavaUtilList.add(0, paramQQAlbumInfo);
      }
      notifyDataSetChanged();
      return;
      if (((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(0))._id.equals("$RecentAlbumId")) {
        this.jdField_a_of_type_JavaUtilList.set(0, paramQQAlbumInfo);
      } else {
        this.jdField_a_of_type_JavaUtilList.add(0, paramQQAlbumInfo);
      }
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
    ThreadManager.post(new wso(this), 2, null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public QQAlbumInfo b(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter)
  {
    return b(paramContext, paramInt1, paramInt2, paramMediaFileFilter, -1, false, null);
  }
  
  public QQAlbumInfo b(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList paramArrayList)
  {
    if (paramMediaFileFilter == null) {
      return null;
    }
    if (paramMediaFileFilter.a()) {
      return a(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
    }
    return a(paramContext, paramInt1, paramInt2, paramMediaFileFilter);
  }
  
  /* Error */
  public List b(Context paramContext, int paramInt, MediaFileFilter paramMediaFileFilter)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifge +51 -> 52
    //   4: getstatic 200	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: astore_3
    //   8: aload_1
    //   9: invokevirtual 206	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: aload_3
    //   13: getstatic 71	com/tencent/mobileqq/activity/photo/AlbumListAdapter:jdField_d_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   16: ldc_w 562
    //   19: aconst_null
    //   20: ldc_w 367
    //   23: invokevirtual 216	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnonnull +51 -> 79
    //   31: aconst_null
    //   32: astore_1
    //   33: aload_1
    //   34: astore 12
    //   36: aload_3
    //   37: ifnull +12 -> 49
    //   40: aload_3
    //   41: invokeinterface 297 1 0
    //   46: aload_1
    //   47: astore 12
    //   49: aload 12
    //   51: areturn
    //   52: getstatic 200	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   55: invokevirtual 328	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   58: astore_3
    //   59: aload_3
    //   60: ldc_w 330
    //   63: iload_2
    //   64: invokestatic 334	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   67: invokevirtual 340	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   70: pop
    //   71: aload_3
    //   72: invokevirtual 344	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   75: astore_3
    //   76: goto -68 -> 8
    //   79: aload_3
    //   80: astore 12
    //   82: new 369	java/util/LinkedList
    //   85: dup
    //   86: invokespecial 370	java/util/LinkedList:<init>	()V
    //   89: astore_1
    //   90: aload_3
    //   91: astore 12
    //   93: aload_3
    //   94: ldc 36
    //   96: invokeinterface 374 2 0
    //   101: istore_2
    //   102: aload_3
    //   103: astore 12
    //   105: aload_3
    //   106: ldc 59
    //   108: invokeinterface 374 2 0
    //   113: istore 4
    //   115: aload_3
    //   116: astore 12
    //   118: aload_3
    //   119: ldc 38
    //   121: invokeinterface 374 2 0
    //   126: istore 5
    //   128: aload_3
    //   129: astore 12
    //   131: aload_3
    //   132: ldc 44
    //   134: invokeinterface 374 2 0
    //   139: istore 6
    //   141: aload_3
    //   142: astore 12
    //   144: aload_3
    //   145: ldc 42
    //   147: invokeinterface 374 2 0
    //   152: istore 7
    //   154: aload_3
    //   155: astore 12
    //   157: aload_3
    //   158: ldc 48
    //   160: invokeinterface 374 2 0
    //   165: istore 8
    //   167: aload_3
    //   168: astore 12
    //   170: aload_3
    //   171: ldc_w 376
    //   174: invokeinterface 374 2 0
    //   179: istore 9
    //   181: aload_3
    //   182: astore 12
    //   184: aload_3
    //   185: invokeinterface 379 1 0
    //   190: ifeq +245 -> 435
    //   193: aload_3
    //   194: astore 12
    //   196: aload_3
    //   197: iload_2
    //   198: invokeinterface 382 2 0
    //   203: astore 14
    //   205: aload_3
    //   206: astore 12
    //   208: aload_3
    //   209: iload 5
    //   211: invokeinterface 382 2 0
    //   216: astore 15
    //   218: aload_3
    //   219: astore 12
    //   221: aload 14
    //   223: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   226: ifne -45 -> 181
    //   229: aload_3
    //   230: astore 12
    //   232: aload 15
    //   234: invokestatic 387	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   237: ifne -56 -> 181
    //   240: aload_3
    //   241: astore 12
    //   243: aload_3
    //   244: iload 7
    //   246: invokeinterface 391 2 0
    //   251: lstore 10
    //   253: aload_3
    //   254: astore 12
    //   256: new 177	com/tencent/mobileqq/data/QQAlbumInfo
    //   259: dup
    //   260: invokespecial 181	com/tencent/mobileqq/data/QQAlbumInfo:<init>	()V
    //   263: astore 13
    //   265: aload_3
    //   266: astore 12
    //   268: aload 13
    //   270: aload 15
    //   272: putfield 191	com/tencent/mobileqq/data/QQAlbumInfo:name	Ljava/lang/String;
    //   275: aload_3
    //   276: astore 12
    //   278: aload 13
    //   280: aload 14
    //   282: putfield 186	com/tencent/mobileqq/data/QQAlbumInfo:_id	Ljava/lang/String;
    //   285: aload_3
    //   286: astore 12
    //   288: aload 13
    //   290: lload 10
    //   292: putfield 394	com/tencent/mobileqq/data/QQAlbumInfo:coverDate	J
    //   295: aload_3
    //   296: astore 12
    //   298: aload 13
    //   300: getfield 255	com/tencent/mobileqq/data/QQAlbumInfo:mCoverInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   303: astore 14
    //   305: aload_3
    //   306: astore 12
    //   308: aload 14
    //   310: aload_3
    //   311: iload 6
    //   313: invokeinterface 382 2 0
    //   318: putfield 284	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   321: aload_3
    //   322: astore 12
    //   324: aload 14
    //   326: aload_3
    //   327: iload 4
    //   329: invokeinterface 391 2 0
    //   334: putfield 269	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   337: aload_3
    //   338: astore 12
    //   340: aload 14
    //   342: lload 10
    //   344: putfield 263	com/tencent/mobileqq/activity/photo/LocalMediaInfo:modifiedDate	J
    //   347: aload_3
    //   348: astore 12
    //   350: aload 14
    //   352: aload_3
    //   353: iload 8
    //   355: invokeinterface 382 2 0
    //   360: putfield 289	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   363: aload_3
    //   364: astore 12
    //   366: aload 13
    //   368: aload_3
    //   369: iload 9
    //   371: invokeinterface 397 2 0
    //   376: putfield 194	com/tencent/mobileqq/data/QQAlbumInfo:mMediaFileCount	I
    //   379: aload_3
    //   380: astore 12
    //   382: aload_1
    //   383: aload 13
    //   385: invokeinterface 410 2 0
    //   390: pop
    //   391: goto -210 -> 181
    //   394: astore 13
    //   396: aload_3
    //   397: astore 12
    //   399: invokestatic 302	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +18 -> 420
    //   405: aload_3
    //   406: astore 12
    //   408: ldc_w 412
    //   411: iconst_2
    //   412: ldc_w 564
    //   415: aload 13
    //   417: invokestatic 416	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   420: aload_1
    //   421: astore 12
    //   423: aload_3
    //   424: ifnull -375 -> 49
    //   427: aload_3
    //   428: invokeinterface 297 1 0
    //   433: aload_1
    //   434: areturn
    //   435: aload_1
    //   436: astore 12
    //   438: aload_3
    //   439: ifnull -390 -> 49
    //   442: aload_3
    //   443: invokeinterface 297 1 0
    //   448: aload_1
    //   449: areturn
    //   450: astore_1
    //   451: aconst_null
    //   452: astore 12
    //   454: aload 12
    //   456: ifnull +10 -> 466
    //   459: aload 12
    //   461: invokeinterface 297 1 0
    //   466: aload_1
    //   467: athrow
    //   468: astore_1
    //   469: goto -15 -> 454
    //   472: astore 13
    //   474: aconst_null
    //   475: astore_3
    //   476: aconst_null
    //   477: astore_1
    //   478: goto -82 -> 396
    //   481: astore 13
    //   483: aconst_null
    //   484: astore_1
    //   485: goto -89 -> 396
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	AlbumListAdapter
    //   0	488	1	paramContext	Context
    //   0	488	2	paramInt	int
    //   0	488	3	paramMediaFileFilter	MediaFileFilter
    //   113	215	4	i	int
    //   126	84	5	j	int
    //   139	173	6	k	int
    //   152	93	7	m	int
    //   165	189	8	n	int
    //   179	191	9	i1	int
    //   251	92	10	l	long
    //   34	426	12	localObject1	Object
    //   263	121	13	localQQAlbumInfo	QQAlbumInfo
    //   394	22	13	localException1	java.lang.Exception
    //   472	1	13	localException2	java.lang.Exception
    //   481	1	13	localException3	java.lang.Exception
    //   203	148	14	localObject2	Object
    //   216	55	15	str	String
    // Exception table:
    //   from	to	target	type
    //   93	102	394	java/lang/Exception
    //   105	115	394	java/lang/Exception
    //   118	128	394	java/lang/Exception
    //   131	141	394	java/lang/Exception
    //   144	154	394	java/lang/Exception
    //   157	167	394	java/lang/Exception
    //   170	181	394	java/lang/Exception
    //   184	193	394	java/lang/Exception
    //   196	205	394	java/lang/Exception
    //   208	218	394	java/lang/Exception
    //   221	229	394	java/lang/Exception
    //   232	240	394	java/lang/Exception
    //   243	253	394	java/lang/Exception
    //   256	265	394	java/lang/Exception
    //   268	275	394	java/lang/Exception
    //   278	285	394	java/lang/Exception
    //   288	295	394	java/lang/Exception
    //   298	305	394	java/lang/Exception
    //   308	321	394	java/lang/Exception
    //   324	337	394	java/lang/Exception
    //   340	347	394	java/lang/Exception
    //   350	363	394	java/lang/Exception
    //   366	379	394	java/lang/Exception
    //   382	391	394	java/lang/Exception
    //   4	8	450	finally
    //   8	27	450	finally
    //   52	76	450	finally
    //   82	90	468	finally
    //   93	102	468	finally
    //   105	115	468	finally
    //   118	128	468	finally
    //   131	141	468	finally
    //   144	154	468	finally
    //   157	167	468	finally
    //   170	181	468	finally
    //   184	193	468	finally
    //   196	205	468	finally
    //   208	218	468	finally
    //   221	229	468	finally
    //   232	240	468	finally
    //   243	253	468	finally
    //   256	265	468	finally
    //   268	275	468	finally
    //   278	285	468	finally
    //   288	295	468	finally
    //   298	305	468	finally
    //   308	321	468	finally
    //   324	337	468	finally
    //   340	347	468	finally
    //   350	363	468	finally
    //   366	379	468	finally
    //   382	391	468	finally
    //   399	405	468	finally
    //   408	420	468	finally
    //   4	8	472	java/lang/Exception
    //   8	27	472	java/lang/Exception
    //   52	76	472	java/lang/Exception
    //   82	90	481	java/lang/Exception
  }
  
  public void b(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramQQAlbumInfo);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new wsq(this, paramQQAlbumInfo));
  }
  
  void b(List paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramList);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new wsp(this, paramList));
  }
  
  public void c(QQAlbumInfo paramQQAlbumInfo)
  {
    int k = 0;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() < 2) {
      this.jdField_a_of_type_JavaUtilList.add(paramQQAlbumInfo);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(i))._id.equals("$VideoAlbumId")) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            break label131;
          }
          if (paramQQAlbumInfo.mMediaFileCount <= 0) {
            break label117;
          }
          this.jdField_a_of_type_JavaUtilList.set(i, paramQQAlbumInfo);
          break;
        }
        i += 1;
      }
      label117:
      this.jdField_a_of_type_JavaUtilList.remove(i);
      continue;
      label131:
      if (paramQQAlbumInfo.mMediaFileCount > 0) {
        this.jdField_a_of_type_JavaUtilList.add(1, paramQQAlbumInfo);
      }
    }
  }
  
  public void d(QQAlbumInfo paramQQAlbumInfo)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      c(paramQQAlbumInfo);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new wsr(this, paramQQAlbumInfo));
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
    return AlbumUtil.a(((QQAlbumInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mCoverInfo);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    TextView localTextView;
    QQAlbumInfo localQQAlbumInfo;
    label100:
    Object localObject;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2130970179, null);
      localTextView = (TextView)localView;
      localQQAlbumInfo = a(paramInt);
      localView.setContentDescription(localQQAlbumInfo.name + "，" + localQQAlbumInfo.mMediaFileCount + "张照片");
      paramView = localQQAlbumInfo.name;
      if (!this.jdField_d_of_type_Boolean) {
        break label390;
      }
      localTextView.setText(localQQAlbumInfo.name);
      paramView = localTextView.getCompoundDrawables()[0];
      if (localQQAlbumInfo._id.equals("qzone_album")) {
        break label520;
      }
      if (getItemViewType(paramInt) != 1) {
        break label465;
      }
      if (!localQQAlbumInfo.mCoverInfo.isSystemMeidaStore) {
        break label450;
      }
      paramViewGroup = AlbumUtil.a(localQQAlbumInfo.mCoverInfo, "VIDEO");
      label154:
      localObject = localQQAlbumInfo.mCoverInfo;
      localQQAlbumInfo.mCoverInfo.thumbHeight = 200;
      ((LocalMediaInfo)localObject).thumbWidth = 200;
      if ((paramView == null) || (!URLDrawable.class.isInstance(paramView))) {
        break label583;
      }
      localObject = (URLDrawable)paramView;
      paramView = (View)localObject;
      if (!paramViewGroup.equals(((URLDrawable)localObject).getURL())) {
        ((URLDrawable)localObject).cancelDownload(true);
      }
    }
    label390:
    label450:
    label583:
    for (paramView = null;; paramView = null)
    {
      localObject = paramView;
      if (paramView == null)
      {
        if (VersionUtils.d())
        {
          paramView = URLDrawableHelper.a(paramViewGroup, jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
          label247:
          paramView.setTag(localQQAlbumInfo.mCoverInfo);
          paramView.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          paramViewGroup = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState.newDrawable(this.jdField_a_of_type_AndroidContentResResources);
          paramViewGroup.setBounds(0, 0, paramViewGroup.getIntrinsicWidth(), paramViewGroup.getIntrinsicHeight());
          localTextView.setCompoundDrawables(paramView, null, paramViewGroup, null);
          localObject = paramView;
        }
      }
      else if (this.jdField_b_of_type_JavaUtilList != null)
      {
        if (!this.jdField_b_of_type_JavaUtilList.contains(localQQAlbumInfo._id)) {
          break label498;
        }
        paramView = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130839270);
        localTextView.setContentDescription("已选中");
      }
      for (;;)
      {
        paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
        localTextView.setCompoundDrawables((Drawable)localObject, null, paramView, null);
        return localView;
        localTextView = (TextView)paramView;
        localView = paramView;
        break;
        if (localQQAlbumInfo.mMediaFileCount > 0) {
          paramView = localQQAlbumInfo.name + String.format(" (%d)", new Object[] { Integer.valueOf(localQQAlbumInfo.mMediaFileCount) });
        }
        localTextView.setText(paramView);
        break label100;
        paramViewGroup = AlbumUtil.a(localQQAlbumInfo.mCoverInfo, "APP_VIDEO");
        break label154;
        label465:
        paramViewGroup = AlbumUtil.a(localQQAlbumInfo.mCoverInfo);
        break label154;
        paramView = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130841056);
        paramView = URLDrawableHelper.a(paramViewGroup, paramView, paramView);
        break label247;
        label498:
        paramView = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130839271);
        localTextView.setContentDescription("未选中");
      }
      paramView = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130844222);
      paramView.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      paramViewGroup = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState.newDrawable(this.jdField_a_of_type_AndroidContentResResources);
      paramViewGroup.setBounds(0, 0, paramViewGroup.getIntrinsicWidth(), paramViewGroup.getIntrinsicHeight());
      localTextView.setCompoundDrawables(paramView, null, paramViewGroup, null);
      return localView;
    }
  }
  
  public int getViewTypeCount()
  {
    return AlbumUtil.d.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AlbumListAdapter
 * JD-Core Version:    0.7.0.1
 */