import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.SimpleJob;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import mqq.os.MqqHandler;

public class aofi
  extends SimpleJob
{
  public aofi(LocalVideoSelectActivity paramLocalVideoSelectActivity, LocalMediaInfo paramLocalMediaInfo) {}
  
  /* Error */
  protected Bitmap a(@android.support.annotation.NonNull com.tribe.async.async.JobContext paramJobContext, @Nullable java.lang.Void... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_1
    //   5: aload_0
    //   6: getfield 11	aofi:jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalVideoSelectActivity	Ldov/com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity;
    //   9: invokevirtual 28	dov/com/tencent/biz/qqstory/takevideo/LocalVideoSelectActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   12: astore 4
    //   14: aload 4
    //   16: getstatic 34	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   19: aconst_null
    //   20: ldc 36
    //   22: iconst_1
    //   23: anewarray 38	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: getfield 13	aofi:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   32: getfield 44	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   35: invokestatic 48	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   38: aastore
    //   39: aconst_null
    //   40: invokevirtual 54	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +230 -> 275
    //   48: aload_2
    //   49: invokeinterface 60 1 0
    //   54: ifeq +216 -> 270
    //   57: aload 4
    //   59: aload_0
    //   60: getfield 13	aofi:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   63: getfield 44	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   66: iconst_1
    //   67: aconst_null
    //   68: invokestatic 66	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   71: astore 5
    //   73: aload 5
    //   75: astore_1
    //   76: aload 5
    //   78: ifnonnull +18 -> 96
    //   81: aload 4
    //   83: aload_0
    //   84: getfield 13	aofi:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   87: getfield 44	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   90: iconst_3
    //   91: aconst_null
    //   92: invokestatic 66	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   95: astore_1
    //   96: aload_1
    //   97: astore 5
    //   99: aload_2
    //   100: invokeinterface 69 1 0
    //   105: istore_3
    //   106: iload_3
    //   107: ifne -11 -> 96
    //   110: aload_1
    //   111: astore 4
    //   113: aload_2
    //   114: ifnull +150 -> 264
    //   117: aload_2
    //   118: invokeinterface 72 1 0
    //   123: aload_1
    //   124: ifnull +107 -> 231
    //   127: aload_1
    //   128: astore_2
    //   129: aload_1
    //   130: invokevirtual 78	android/graphics/Bitmap:getWidth	()I
    //   133: aload_1
    //   134: invokevirtual 81	android/graphics/Bitmap:getHeight	()I
    //   137: if_icmple +22 -> 159
    //   140: aload_1
    //   141: astore_2
    //   142: aload_0
    //   143: getfield 13	aofi:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   146: getfield 85	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   149: ifeq +10 -> 159
    //   152: aload_1
    //   153: ldc 86
    //   155: invokestatic 91	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   158: astore_2
    //   159: aload_2
    //   160: areturn
    //   161: astore 4
    //   163: aconst_null
    //   164: astore 5
    //   166: aload_1
    //   167: astore_2
    //   168: aload 5
    //   170: astore_1
    //   171: aload_2
    //   172: astore 5
    //   174: ldc 93
    //   176: ldc 95
    //   178: iconst_2
    //   179: anewarray 97	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload_0
    //   185: getfield 13	aofi:jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   188: getfield 101	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   191: aastore
    //   192: dup
    //   193: iconst_1
    //   194: aload 4
    //   196: aastore
    //   197: invokestatic 107	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: aload_1
    //   201: astore 4
    //   203: aload_2
    //   204: ifnull +60 -> 264
    //   207: aload_2
    //   208: invokeinterface 72 1 0
    //   213: goto -90 -> 123
    //   216: astore_1
    //   217: aload 5
    //   219: ifnull +10 -> 229
    //   222: aload 5
    //   224: invokeinterface 72 1 0
    //   229: aload_1
    //   230: athrow
    //   231: invokestatic 112	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   234: getfield 115	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr;
    //   237: iconst_0
    //   238: invokevirtual 120	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr:a	(Z)Landroid/graphics/Bitmap;
    //   241: areturn
    //   242: astore_1
    //   243: aload_2
    //   244: astore 5
    //   246: goto -29 -> 217
    //   249: astore 4
    //   251: aconst_null
    //   252: astore_1
    //   253: goto -82 -> 171
    //   256: astore 4
    //   258: aload 5
    //   260: astore_1
    //   261: goto -90 -> 171
    //   264: aload 4
    //   266: astore_1
    //   267: goto -144 -> 123
    //   270: aconst_null
    //   271: astore_1
    //   272: goto -176 -> 96
    //   275: aconst_null
    //   276: astore_1
    //   277: goto -167 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	aofi
    //   0	280	1	paramJobContext	com.tribe.async.async.JobContext
    //   0	280	2	paramVarArgs	java.lang.Void[]
    //   105	2	3	bool	boolean
    //   12	100	4	localObject1	java.lang.Object
    //   161	34	4	localException1	java.lang.Exception
    //   201	1	4	localJobContext	com.tribe.async.async.JobContext
    //   249	1	4	localException2	java.lang.Exception
    //   256	9	4	localException3	java.lang.Exception
    //   1	258	5	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   14	44	161	java/lang/Exception
    //   14	44	216	finally
    //   174	200	216	finally
    //   48	73	242	finally
    //   81	96	242	finally
    //   99	106	242	finally
    //   48	73	249	java/lang/Exception
    //   81	96	256	java/lang/Exception
    //   99	106	256	java/lang/Exception
  }
  
  protected void a(@Nullable Bitmap paramBitmap)
  {
    super.onResult(paramBitmap);
    ThreadManager.getUIHandler().post(new aofj(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aofi
 * JD-Core Version:    0.7.0.1
 */