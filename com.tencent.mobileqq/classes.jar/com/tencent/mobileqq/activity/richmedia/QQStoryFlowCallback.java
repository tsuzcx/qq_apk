package com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.nearby.now.send.capturepart.QQNowVideoFlowCallback;
import java.io.File;

public class QQStoryFlowCallback
  implements FlowComponentInterface
{
  public static float a;
  public static int a;
  public static Bitmap a;
  public static float b;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  
  static
  {
    jdField_a_of_type_Int = 419430400;
    jdField_b_of_type_Int = 240;
    c = 60000;
    d = 10002200;
    e = 10485760;
    f = 240;
    jdField_a_of_type_Float = d / 10000 / 1000.0F;
    jdField_b_of_type_Float = d % 10000 / 1000.0F;
  }
  
  public static String a(Activity paramActivity, int paramInt)
  {
    if (paramActivity.getIntent().hasExtra("extra_upload_temp_directory")) {
      return paramActivity.getIntent().getStringExtra("extra_upload_temp_directory");
    }
    String str = PublishFileManager.a(paramInt);
    paramActivity.getIntent().putExtra("extra_upload_temp_directory", str);
    return str;
  }
  
  public static String a(@NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    return paramLocalMediaInfo.fileSize + "|" + paramLocalMediaInfo.mediaWidth + "|" + paramLocalMediaInfo.mediaHeight + "|" + paramLocalMediaInfo.mDuration + "," + paramLocalMediaInfo.mMimeType + "," + paramLocalMediaInfo.rotation;
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    a(paramActivity, paramInt1, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramInt2, 0, null, null, 0L, false, 0, paramInt3);
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, int paramInt3, String paramString5, String paramString6, long paramLong, boolean paramBoolean2, int paramInt4, int paramInt5)
  {
    Intent localIntent = new Intent(paramActivity, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", paramInt1);
    localIntent.putExtra("from_qqstory", true);
    localIntent.putExtra("shareGroupType", paramInt3);
    localIntent.putExtra("shareGroupId", paramString5);
    localIntent.putExtra("shareGroupName", paramString6);
    localIntent.putExtra("add_video_source", paramInt4);
    localIntent.putExtra("groupUin", paramLong);
    localIntent.putExtra("ignorePersonalPublish", paramBoolean2);
    localIntent.putExtra("ALBUM_NAME", "最近照片");
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("video_refer", paramString1);
    localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("enable_multi_fragment", paramBoolean1);
    localIntent.putExtra("entrance_type", paramInt2);
    localIntent.putExtra("story_default_label", paramActivity.getIntent().getStringExtra("story_default_label"));
    localIntent.putExtra("troop_uin", paramActivity.getIntent().getLongExtra("troop_uin", 0L));
    if (paramString2 != null)
    {
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString2);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    }
    if (paramString3 != null)
    {
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", paramString3);
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    }
    if (paramString4 != null) {
      localIntent.putExtra("launch_take_video_view_extra_value_key", paramString4);
    }
    if (paramInt5 >= 0)
    {
      paramActivity.startActivityForResult(localIntent, paramInt5);
      return;
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, boolean paramBoolean1, int paramInt2, int paramInt3, String paramString2, String paramString3, long paramLong, boolean paramBoolean2, int paramInt4, int paramInt5)
  {
    a(paramActivity, paramInt1, paramString1, NewFlowCameraActivity.class.getName(), LocalVideoSelectActivity.class.getName(), null, paramBoolean1, paramInt2, paramInt3, paramString2, paramString3, paramLong, paramBoolean2, paramInt4, paramInt5);
  }
  
  public static void a(Activity paramActivity, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, long paramLong, boolean paramBoolean, int paramInt5)
  {
    a(paramActivity, paramString1, paramLocalMediaInfo, paramInt1, paramInt2, paramInt3, paramInt4, paramString2, paramString3, paramLong, paramBoolean, paramInt5, 1);
  }
  
  public static void a(Activity paramActivity, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, long paramLong, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    for (;;)
    {
      long l;
      int i;
      boolean bool2;
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("extra_upload_temp_directory", a(paramActivity, 1));
        localBundle.putInt("entrance_type", paramInt3);
        localBundle.putString("story_default_label", paramActivity.getIntent().getStringExtra("story_default_label"));
        l = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
        i = 4374893;
        if (paramLocalMediaInfo.mMimeType.contains("video"))
        {
          paramLocalMediaInfo = new EditLocalVideoSource(paramString1, paramLocalMediaInfo, paramInt1, paramInt2);
          int j = paramInt2 - paramInt1;
          paramInt1 = 1;
          if (j / 10000.0F > 1.0F)
          {
            paramInt2 = j / 10000;
            paramInt1 = paramInt2;
            if (j % 10000 >= 1000) {
              paramInt1 = paramInt2 + 1;
            }
          }
          localBundle.putInt("expect_fragment_count", paramInt1);
          paramInt2 = i;
          paramString1 = paramLocalMediaInfo;
          if (paramInt1 <= 1)
          {
            paramInt2 = 4342125;
            paramString1 = paramLocalMediaInfo;
            break label605;
            paramInt2 = paramInt1;
            if (paramInt6 == 10)
            {
              bool1 = paramActivity.getIntent().getBooleanExtra("needVideoDoodle", false);
              bool2 = paramActivity.getIntent().getBooleanExtra("needVideoWording", false);
              paramInt3 = paramInt1;
              if (bool1) {
                break label705;
              }
              paramInt3 = paramInt1 & 0xFFFFFFFE;
              break label705;
            }
            label213:
            paramString1 = new EditVideoParams(paramInt6, paramInt2, paramString1, localBundle);
            if (l != 0L) {
              paramString1.a.putLong("troop_uin", l);
            }
            paramString1.a.putBoolean("enable_hw_encode", false);
            paramString1.a.putBoolean("ignorePersonalPublish", paramBoolean);
            paramString1.a.putInt("shareGroupType", paramInt4);
            paramString1.a.putString("shareGroupId", paramString2);
            paramString1.a.putString("shareGroupName", paramString3);
            paramString1.a.putInt("add_video_source", paramInt5);
            paramString1.a.putLong("groupUin", paramLong);
            SLog.b("Q.qqstory.publish.QQStoryFlowCallback", "EditVideoParams params:" + paramString1.toString());
            paramLocalMediaInfo = new Intent(paramActivity, EditVideoActivity.class);
            paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramString1);
            paramLocalMediaInfo.putExtra("op_department", "grp_qq");
            paramLocalMediaInfo.putExtra("op_type", "video_edit");
            paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
            if (paramInt6 != 10) {
              break label724;
            }
            paramBoolean = paramActivity.getIntent().getBooleanExtra("needTheme", false);
            boolean bool1 = paramActivity.getIntent().getBooleanExtra("needVideoDoodle", false);
            bool2 = paramActivity.getIntent().getBooleanExtra("needVideoWording", false);
            paramString1 = paramActivity.getIntent().getStringExtra("from");
            paramInt1 = paramActivity.getIntent().getIntExtra("theme_id", -1);
            paramString2 = paramActivity.getIntent().getStringExtra("theme_name");
            paramLocalMediaInfo.putExtra("needTheme", paramBoolean);
            paramLocalMediaInfo.putExtra("needVideoDoodle", bool1);
            paramLocalMediaInfo.putExtra("needVideoWording", bool2);
            paramLocalMediaInfo.putExtra("from", paramString1);
            paramLocalMediaInfo.putExtra("theme_id", paramInt1);
            paramLocalMediaInfo.putExtra("theme_name", paramString2);
            break label724;
            label546:
            paramActivity.startActivityForResult(paramLocalMediaInfo, paramInt1);
          }
        }
        else
        {
          paramString1 = new EditLocalPhotoSource(paramString1, paramLocalMediaInfo);
          paramInt2 = i;
        }
      }
      catch (Exception paramActivity)
      {
        SLog.e("Q.qqstory.publish.QQStoryFlowCallback", "startEditVideoActivity exception:" + paramActivity);
        return;
      }
      label605:
      do
      {
        paramInt1 = 10002;
        break label546;
        if ((paramInt3 != 16) && (paramInt3 != 5))
        {
          paramInt1 = paramInt2;
          if (paramInt3 != 102) {}
        }
        else
        {
          paramInt1 = paramInt2 & 0xFFFFBFFF;
        }
        paramInt2 = paramInt1;
        if (l != 0L) {
          paramInt2 = paramInt1 & 0xFFFFBFFF & 0xFFFDFFFF & 0xFFBFFFFF;
        }
        i = paramInt2;
        if (paramInt3 == 102) {
          i = paramInt2 | 0x200000;
        }
        if (paramInt4 != 1)
        {
          paramInt1 = i;
          if (paramInt6 != 10) {
            break;
          }
        }
        paramInt1 = i & 0xFFFDFFFF;
        break;
        paramInt2 = paramInt3;
        if (bool2) {
          break label213;
        }
        paramInt2 = paramInt3 & 0xFFFFFFFB;
        break label213;
      } while (paramInt6 != 10);
      label705:
      label724:
      paramInt1 = 10012;
    }
  }
  
  public static void a(Activity paramActivity, String paramString, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    for (;;)
    {
      if (paramBundle.getInt("local_video_from_type", -1) == 1001)
      {
        QQNowVideoFlowCallback.a(paramActivity, paramString, paramLocalMediaInfo, paramInt1, paramInt2, paramBundle);
        return;
      }
      paramBundle.putString("extra_upload_temp_directory", a(paramActivity, 1));
      paramBundle.putBoolean("enable_hw_encode", false);
      int i;
      if (paramLocalMediaInfo.mMimeType.contains("video"))
      {
        paramString = new EditLocalVideoSource(paramString, paramLocalMediaInfo, paramInt1, paramInt2);
        i = paramInt2 - paramInt1;
        paramInt1 = 1;
        if (i / 10000.0F > 1.0F)
        {
          paramInt2 = i / 10000;
          paramInt1 = paramInt2;
          if (i % 10000 >= 1000) {
            paramInt1 = paramInt2 + 1;
          }
        }
        paramBundle.putInt("expect_fragment_count", paramInt1);
        if (paramInt1 > 1) {
          break label350;
        }
        paramInt2 = 4342125;
      }
      for (;;)
      {
        i = paramBundle.getInt("entrance_type");
        if ((i != 16) && (i != 5))
        {
          paramInt1 = paramInt2;
          if (i != 102) {}
        }
        else
        {
          paramInt1 = paramInt2 & 0xFFFFBFFF;
        }
        paramInt2 = paramInt1;
        if (paramBundle.getLong("troop_uin") != 0L) {
          paramInt2 = paramInt1 & 0xFFFFBFFF & 0xFFFDFFFF & 0xFFBFFFFF;
        }
        paramInt1 = paramInt2;
        if (i == 102) {
          paramInt1 = paramInt2 | 0x200000;
        }
        paramInt2 = paramInt1;
        if (paramBundle.getInt("shareGroupType") == 1) {
          paramInt2 = paramInt1 & 0xFFFDFFFF;
        }
        paramString = new EditVideoParams(1, paramInt2, paramString, paramBundle);
        SLog.b("Q.qqstory.publish.QQStoryFlowCallback", "EditVideoParams params:" + paramString.toString());
        paramLocalMediaInfo = new Intent(paramActivity, EditVideoActivity.class);
        paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramString);
        paramActivity.startActivityForResult(paramLocalMediaInfo, 10002);
        return;
        paramString = new EditLocalPhotoSource(paramString, paramLocalMediaInfo);
        paramInt2 = 4374893;
        continue;
        label350:
        paramInt2 = 4374893;
      }
    }
  }
  
  /* Error */
  public static boolean a(Activity paramActivity, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokestatic 219	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;I)Ljava/lang/String;
    //   5: pop
    //   6: aload_1
    //   7: ldc_w 348
    //   10: lconst_0
    //   11: invokevirtual 178	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   14: lstore 7
    //   16: aload_1
    //   17: ldc_w 350
    //   20: invokevirtual 354	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   23: checkcast 77	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   26: astore 15
    //   28: aload_1
    //   29: ldc 170
    //   31: bipush 99
    //   33: invokevirtual 311	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   36: istore 4
    //   38: aload 15
    //   40: ifnonnull +14 -> 54
    //   43: new 356	java/lang/IllegalArgumentException
    //   46: dup
    //   47: ldc_w 358
    //   50: invokespecial 361	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   53: athrow
    //   54: aload 15
    //   56: getfield 364	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   59: astore 16
    //   61: aload 15
    //   63: getfield 108	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   66: ldc 230
    //   68: invokevirtual 236	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   71: ifeq +369 -> 440
    //   74: aload_0
    //   75: invokevirtual 368	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   78: astore 14
    //   80: aload 14
    //   82: getstatic 374	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   85: aconst_null
    //   86: ldc_w 376
    //   89: iconst_1
    //   90: anewarray 232	java/lang/String
    //   93: dup
    //   94: iconst_0
    //   95: aload 15
    //   97: getfield 379	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   100: invokestatic 383	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   103: aastore
    //   104: aconst_null
    //   105: invokevirtual 389	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   108: astore 11
    //   110: aload 11
    //   112: ifnull +656 -> 768
    //   115: aload 11
    //   117: astore 12
    //   119: aload 11
    //   121: invokeinterface 395 1 0
    //   126: ifeq +636 -> 762
    //   129: aload 11
    //   131: astore 12
    //   133: aload 14
    //   135: aload 15
    //   137: getfield 379	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   140: iconst_1
    //   141: aconst_null
    //   142: invokestatic 401	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   145: astore 13
    //   147: aload 13
    //   149: astore 10
    //   151: aload 13
    //   153: ifnonnull +21 -> 174
    //   156: aload 11
    //   158: astore 12
    //   160: aload 14
    //   162: aload 15
    //   164: getfield 379	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   167: iconst_3
    //   168: aconst_null
    //   169: invokestatic 401	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   172: astore 10
    //   174: aload 11
    //   176: astore 12
    //   178: aload 10
    //   180: astore 13
    //   182: aload 11
    //   184: invokeinterface 404 1 0
    //   189: istore 9
    //   191: iload 9
    //   193: ifne -19 -> 174
    //   196: aload 10
    //   198: astore 12
    //   200: aload 11
    //   202: ifnull +14 -> 216
    //   205: aload 11
    //   207: invokeinterface 407 1 0
    //   212: aload 10
    //   214: astore 12
    //   216: aload 12
    //   218: ifnull +206 -> 424
    //   221: aload_1
    //   222: ldc 160
    //   224: invokevirtual 61	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   227: astore 10
    //   229: aload 12
    //   231: invokevirtual 413	android/graphics/Bitmap:getWidth	()I
    //   234: aload 12
    //   236: invokevirtual 416	android/graphics/Bitmap:getHeight	()I
    //   239: if_icmple +177 -> 416
    //   242: ldc_w 418
    //   245: aload 10
    //   247: invokevirtual 422	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   250: ifne +166 -> 416
    //   253: aload 12
    //   255: ldc_w 423
    //   258: invokestatic 428	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   261: putstatic 430	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   264: aload 12
    //   266: invokevirtual 433	android/graphics/Bitmap:recycle	()V
    //   269: lload 7
    //   271: ldc2_w 434
    //   274: lcmp
    //   275: ifge +464 -> 739
    //   278: aload_1
    //   279: ldc_w 437
    //   282: invokevirtual 441	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   285: astore 10
    //   287: aload 10
    //   289: ifnull +324 -> 613
    //   292: ldc_w 273
    //   295: ldc_w 443
    //   298: invokestatic 280	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: ldc_w 273
    //   304: aload 10
    //   306: invokestatic 448	com/tencent/biz/qqstory/takevideo2/StoryPublishParams:a	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   309: aload 15
    //   311: getfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   314: ldc2_w 449
    //   317: lcmp
    //   318: ifgt +288 -> 606
    //   321: iconst_0
    //   322: istore_2
    //   323: aload_0
    //   324: aload 16
    //   326: aload 15
    //   328: iconst_0
    //   329: iload_2
    //   330: aload 10
    //   332: invokestatic 451	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IILandroid/os/Bundle;)V
    //   335: iconst_1
    //   336: ireturn
    //   337: astore 14
    //   339: aconst_null
    //   340: astore 10
    //   342: aconst_null
    //   343: astore 11
    //   345: aload 11
    //   347: astore 12
    //   349: ldc_w 273
    //   352: ldc_w 453
    //   355: iconst_2
    //   356: anewarray 4	java/lang/Object
    //   359: dup
    //   360: iconst_0
    //   361: aload 15
    //   363: getfield 364	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   366: aastore
    //   367: dup
    //   368: iconst_1
    //   369: aload 14
    //   371: aastore
    //   372: invokestatic 456	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   375: aload 10
    //   377: astore 12
    //   379: aload 11
    //   381: ifnull -165 -> 216
    //   384: aload 11
    //   386: invokeinterface 407 1 0
    //   391: aload 10
    //   393: astore 12
    //   395: goto -179 -> 216
    //   398: astore_0
    //   399: aconst_null
    //   400: astore 12
    //   402: aload 12
    //   404: ifnull +10 -> 414
    //   407: aload 12
    //   409: invokeinterface 407 1 0
    //   414: aload_0
    //   415: athrow
    //   416: aload 12
    //   418: putstatic 430	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   421: goto -152 -> 269
    //   424: invokestatic 461	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   427: getfield 464	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr;
    //   430: iconst_0
    //   431: invokevirtual 469	com/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr:a	(Z)Landroid/graphics/Bitmap;
    //   434: putstatic 430	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   437: goto -168 -> 269
    //   440: aload_1
    //   441: ldc_w 437
    //   444: invokevirtual 441	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   447: astore 10
    //   449: aload 10
    //   451: ifnull +55 -> 506
    //   454: ldc_w 273
    //   457: ldc_w 443
    //   460: invokestatic 280	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: ldc_w 273
    //   466: aload 10
    //   468: invokestatic 448	com/tencent/biz/qqstory/takevideo2/StoryPublishParams:a	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   471: aload 15
    //   473: getfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   476: ldc2_w 449
    //   479: lcmp
    //   480: ifgt +19 -> 499
    //   483: iconst_0
    //   484: istore_2
    //   485: aload_0
    //   486: aload 16
    //   488: aload 15
    //   490: iconst_0
    //   491: iload_2
    //   492: aload 10
    //   494: invokestatic 451	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IILandroid/os/Bundle;)V
    //   497: iconst_1
    //   498: ireturn
    //   499: sipush 10000
    //   502: istore_2
    //   503: goto -18 -> 485
    //   506: aload_1
    //   507: ldc 137
    //   509: iconst_0
    //   510: invokevirtual 311	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   513: istore_3
    //   514: aload_1
    //   515: ldc 139
    //   517: invokevirtual 61	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   520: astore 10
    //   522: aload_1
    //   523: ldc 141
    //   525: invokevirtual 61	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   528: astore 11
    //   530: aload_1
    //   531: ldc 145
    //   533: ldc2_w 470
    //   536: invokevirtual 178	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   539: lstore 7
    //   541: aload_1
    //   542: ldc 150
    //   544: iconst_0
    //   545: invokevirtual 251	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   548: istore 9
    //   550: aload_1
    //   551: ldc 143
    //   553: iconst_0
    //   554: invokevirtual 311	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   557: istore 5
    //   559: aload 15
    //   561: getfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   564: ldc2_w 449
    //   567: lcmp
    //   568: ifgt +31 -> 599
    //   571: iconst_0
    //   572: istore_2
    //   573: aload_0
    //   574: aload 16
    //   576: aload 15
    //   578: iconst_0
    //   579: iload_2
    //   580: iload 4
    //   582: iload_3
    //   583: aload 10
    //   585: aload 11
    //   587: lload 7
    //   589: iload 9
    //   591: iload 5
    //   593: invokestatic 473	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IIIILjava/lang/String;Ljava/lang/String;JZI)V
    //   596: goto -99 -> 497
    //   599: sipush 10000
    //   602: istore_2
    //   603: goto -30 -> 573
    //   606: sipush 10000
    //   609: istore_2
    //   610: goto -287 -> 323
    //   613: aload_1
    //   614: ldc 137
    //   616: iconst_0
    //   617: invokevirtual 311	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   620: istore 5
    //   622: aload_1
    //   623: ldc 139
    //   625: invokevirtual 61	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   628: astore 10
    //   630: aload_1
    //   631: ldc 141
    //   633: invokevirtual 61	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   636: astore 11
    //   638: aload_1
    //   639: ldc 145
    //   641: ldc2_w 470
    //   644: invokevirtual 178	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   647: lstore 7
    //   649: aload_1
    //   650: ldc 150
    //   652: iconst_0
    //   653: invokevirtual 251	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   656: istore 9
    //   658: aload_1
    //   659: ldc 143
    //   661: iconst_0
    //   662: invokevirtual 311	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   665: istore 6
    //   667: ldc_w 418
    //   670: aload_1
    //   671: ldc 160
    //   673: invokevirtual 61	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   676: invokevirtual 422	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   679: ifeq +48 -> 727
    //   682: bipush 10
    //   684: istore_2
    //   685: aload 15
    //   687: getfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   690: ldc2_w 449
    //   693: lcmp
    //   694: ifgt +38 -> 732
    //   697: iconst_0
    //   698: istore_3
    //   699: aload_0
    //   700: aload 16
    //   702: aload 15
    //   704: iconst_0
    //   705: iload_3
    //   706: iload 4
    //   708: iload 5
    //   710: aload 10
    //   712: aload 11
    //   714: lload 7
    //   716: iload 9
    //   718: iload 6
    //   720: iload_2
    //   721: invokestatic 212	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IIIILjava/lang/String;Ljava/lang/String;JZII)V
    //   724: goto -389 -> 335
    //   727: iconst_1
    //   728: istore_2
    //   729: goto -44 -> 685
    //   732: sipush 10000
    //   735: istore_3
    //   736: goto -37 -> 699
    //   739: iconst_0
    //   740: ireturn
    //   741: astore_0
    //   742: goto -340 -> 402
    //   745: astore 14
    //   747: aconst_null
    //   748: astore 10
    //   750: goto -405 -> 345
    //   753: astore 14
    //   755: aload 13
    //   757: astore 10
    //   759: goto -414 -> 345
    //   762: aconst_null
    //   763: astore 10
    //   765: goto -591 -> 174
    //   768: aconst_null
    //   769: astore 10
    //   771: goto -575 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	774	0	paramActivity	Activity
    //   0	774	1	paramIntent	Intent
    //   322	407	2	i	int
    //   513	223	3	j	int
    //   36	671	4	k	int
    //   557	152	5	m	int
    //   665	54	6	n	int
    //   14	701	7	l	long
    //   189	528	9	bool	boolean
    //   149	621	10	localObject1	Object
    //   108	605	11	localObject2	Object
    //   117	300	12	localObject3	Object
    //   145	611	13	localObject4	Object
    //   78	83	14	localContentResolver	android.content.ContentResolver
    //   337	33	14	localException1	Exception
    //   745	1	14	localException2	Exception
    //   753	1	14	localException3	Exception
    //   26	677	15	localLocalMediaInfo	LocalMediaInfo
    //   59	642	16	str	String
    // Exception table:
    //   from	to	target	type
    //   80	110	337	java/lang/Exception
    //   80	110	398	finally
    //   119	129	741	finally
    //   133	147	741	finally
    //   160	174	741	finally
    //   182	191	741	finally
    //   349	375	741	finally
    //   119	129	745	java/lang/Exception
    //   133	147	745	java/lang/Exception
    //   160	174	753	java/lang/Exception
    //   182	191	753	java/lang/Exception
  }
  
  public static void b(Activity paramActivity)
  {
    String str = paramActivity.getIntent().getStringExtra("extra_upload_temp_directory");
    if (!paramActivity.getIntent().getBooleanExtra("edit_video_extra_flag_need_remove_temp_dir", false))
    {
      SLog.b("Q.qqstory.publish.QQStoryFlowCallback", "Publish onActivityResult user confirmed, no need remove temp dir %s!", String.valueOf(str));
      return;
    }
    if (str != null)
    {
      FileUtils.a(new File(str));
      SLog.b("Q.qqstory.publish.QQStoryFlowCallback", "Publish onActivityResult user cancel, delete all files in temp dir %s!", str);
      return;
    }
    SLog.e("Q.qqstory.publish.QQStoryFlowCallback", "Publish onActivityResult user cancel, delete all files in temp dir (null)!");
  }
  
  public String a()
  {
    return "qqstory";
  }
  
  public void a(Activity paramActivity)
  {
    String str = null;
    int k = 0;
    SLog.b("Q.qqstory.publish.QQStoryFlowCallback", "localVideoClick");
    if (paramActivity == null)
    {
      SLog.e("Q.qqstory.publish.QQStoryFlowCallback", "context == null");
      return;
    }
    int i = 99;
    for (;;)
    {
      try
      {
        if (!(paramActivity instanceof NewFlowCameraActivity)) {
          break label211;
        }
        localObject = (NewFlowCameraActivity)paramActivity;
        ((NewFlowCameraActivity)localObject).a("612", "2", "0", true);
        bool1 = ((NewFlowCameraActivity)localObject).k;
        i = ((NewFlowCameraActivity)localObject).a();
        long l = 0L;
        Intent localIntent = paramActivity.getIntent();
        if (localIntent != null)
        {
          j = localIntent.getIntExtra("shareGroupType", 0);
          localObject = localIntent.getStringExtra("shareGroupId");
          str = localIntent.getStringExtra("shareGroupName");
          l = localIntent.getLongExtra("groupUin", -1L);
          bool2 = localIntent.getBooleanExtra("ignorePersonalPublish", false);
          k = localIntent.getIntExtra("add_video_source", 0);
          StoryReportor.a("video_shoot", "clk_local", 0, 0, new String[0]);
          a(paramActivity, 0, a(), bool1, i, j, (String)localObject, str, l, bool2, k, 10006);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        SLog.b("Q.qqstory.publish.QQStoryFlowCallback", "QQStoryFlowCallback ", paramActivity);
        return;
      }
      boolean bool2 = false;
      int j = 0;
      Object localObject = null;
      continue;
      label211:
      boolean bool1 = false;
    }
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramActivity = paramActivity.getIntent();
    if (paramInt2 != -1) {}
    for (boolean bool = true;; bool = false)
    {
      paramActivity.putExtra("edit_video_extra_flag_need_remove_temp_dir", bool);
      if (jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        jdField_a_of_type_AndroidGraphicsBitmap = null;
        SLog.c("Q.qqstory.publish.QQStoryFlowCallback", "mVideoThumbnailCache clear()");
      }
      return;
    }
  }
  
  public void a(Activity paramActivity, Intent paramIntent) {}
  
  public void b(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback
 * JD-Core Version:    0.7.0.1
 */