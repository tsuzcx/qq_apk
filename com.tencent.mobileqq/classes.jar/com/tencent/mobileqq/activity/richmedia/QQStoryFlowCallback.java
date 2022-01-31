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
      boolean bool2;
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("extra_upload_temp_directory", a(paramActivity, 1));
        localBundle.putInt("entrance_type", paramInt3);
        localBundle.putString("story_default_label", paramActivity.getIntent().getStringExtra("story_default_label"));
        l = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
        int j = 4374893;
        if (paramLocalMediaInfo.mMimeType.contains("video"))
        {
          paramLocalMediaInfo = new EditLocalVideoSource(paramString1, paramLocalMediaInfo, paramInt1, paramInt2);
          int k = 1;
          int i = k;
          if (paramInt6 != 10)
          {
            i = k;
            if (paramInt6 != 12)
            {
              paramInt2 -= paramInt1;
              i = k;
              if (paramInt2 / 10000.0F > 1.0F)
              {
                paramInt1 = paramInt2 / 10000;
                i = paramInt1;
                if (paramInt2 % 10000 >= 1000) {
                  i = paramInt1 + 1;
                }
              }
            }
          }
          localBundle.putInt("expect_fragment_count", i);
          paramInt2 = j;
          if (i <= 1)
          {
            paramInt2 = 4342125;
            break label692;
            paramInt2 = paramInt1;
            if (paramInt6 == 10)
            {
              bool1 = paramActivity.getIntent().getBooleanExtra("needVideoDoodle", false);
              bool2 = paramActivity.getIntent().getBooleanExtra("needVideoWording", false);
              paramInt3 = paramInt1;
              if (bool1) {
                break label808;
              }
              paramInt3 = paramInt1 & 0xFFFFFFFE;
              break label808;
            }
            label237:
            paramInt1 = paramInt2;
            if (paramInt6 == 12)
            {
              paramInt1 = paramInt2 & 0xFFBFFFFF & 0xFFFFBFFF & 0xFFFDFFFF;
              bool1 = paramActivity.getIntent().getBooleanExtra("needVideoDoodle", false);
              bool2 = paramActivity.getIntent().getBooleanExtra("needVideoWording", false);
              paramInt2 = paramInt1;
              if (bool1) {
                break label827;
              }
              paramInt2 = paramInt1 & 0xFFFFFFFE;
              break label827;
            }
            label301:
            paramString1 = new EditVideoParams(paramInt6, paramInt1, paramString1, localBundle);
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
              break label844;
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
            break label844;
            label634:
            paramActivity.startActivityForResult(paramLocalMediaInfo, paramInt1);
          }
        }
        else
        {
          paramString1 = new EditLocalPhotoSource(paramString1, paramLocalMediaInfo);
          paramInt1 = j;
        }
      }
      catch (Exception paramActivity)
      {
        SLog.e("Q.qqstory.publish.QQStoryFlowCallback", "startEditVideoActivity exception:" + paramActivity);
        return;
      }
      label692:
      label827:
      label844:
      do
      {
        paramInt1 = 10002;
        break label634;
        paramInt1 = paramInt2;
        paramString1 = paramLocalMediaInfo;
        if (paramInt6 == 12)
        {
          paramInt1 = paramInt2 & 0xFFFF7FFF;
          paramString1 = paramLocalMediaInfo;
        }
        if ((paramInt3 != 16) && (paramInt3 != 5))
        {
          paramInt2 = paramInt1;
          if (paramInt3 != 102) {}
        }
        else
        {
          paramInt2 = paramInt1 & 0xFFFFBFFF;
        }
        paramInt1 = paramInt2;
        if (l != 0L) {
          paramInt1 = paramInt2 & 0xFFFFBFFF & 0xFFFDFFFF & 0xFFBFFFFF;
        }
        paramInt2 = paramInt1;
        if (paramInt3 == 102) {
          paramInt2 = paramInt1 | 0x200000;
        }
        if (paramInt4 != 1)
        {
          paramInt1 = paramInt2;
          if (paramInt6 != 10) {
            break;
          }
        }
        paramInt1 = paramInt2 & 0xFFFDFFFF;
        break;
        paramInt2 = paramInt3;
        if (bool2) {
          break label237;
        }
        paramInt2 = paramInt3 & 0xFFFFFFFB;
        break label237;
        paramInt1 = paramInt2;
        if (bool2) {
          break label301;
        }
        paramInt1 = paramInt2 & 0xFFFFFFFB;
        break label301;
      } while (paramInt6 != 10);
      label808:
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
          break label348;
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
        label348:
        paramInt2 = 4374893;
      }
    }
  }
  
  /* Error */
  public static boolean a(Activity paramActivity, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 160
    //   3: invokevirtual 61	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 17
    //   8: ldc_w 349
    //   11: aload 17
    //   13: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   16: ifeq +61 -> 77
    //   19: getstatic 356	com/tencent/mobileqq/tribe/TribeFlowComponentInterface:jdField_a_of_type_Int	I
    //   22: istore_2
    //   23: aload_0
    //   24: iconst_1
    //   25: invokestatic 219	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;I)Ljava/lang/String;
    //   28: pop
    //   29: aload_1
    //   30: ldc_w 358
    //   33: lconst_0
    //   34: invokevirtual 178	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   37: lstore 7
    //   39: aload_1
    //   40: ldc_w 360
    //   43: invokevirtual 364	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   46: checkcast 77	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   49: astore 15
    //   51: aload_1
    //   52: ldc 170
    //   54: bipush 99
    //   56: invokevirtual 313	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   59: istore 4
    //   61: aload 15
    //   63: ifnonnull +21 -> 84
    //   66: new 366	java/lang/IllegalArgumentException
    //   69: dup
    //   70: ldc_w 368
    //   73: invokespecial 371	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   76: athrow
    //   77: sipush 10000
    //   80: istore_2
    //   81: goto -58 -> 23
    //   84: aload 15
    //   86: getfield 374	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   89: astore 16
    //   91: aload 15
    //   93: getfield 108	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   96: ldc 230
    //   98: invokevirtual 236	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +374 -> 475
    //   104: aload_0
    //   105: invokevirtual 378	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   108: astore 14
    //   110: aload 14
    //   112: getstatic 384	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   115: aconst_null
    //   116: ldc_w 386
    //   119: iconst_1
    //   120: anewarray 232	java/lang/String
    //   123: dup
    //   124: iconst_0
    //   125: aload 15
    //   127: getfield 389	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   130: invokestatic 393	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   133: aastore
    //   134: aconst_null
    //   135: invokevirtual 399	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   138: astore 11
    //   140: aload 11
    //   142: ifnull +660 -> 802
    //   145: aload 11
    //   147: astore 12
    //   149: aload 11
    //   151: invokeinterface 405 1 0
    //   156: ifeq +640 -> 796
    //   159: aload 11
    //   161: astore 12
    //   163: aload 14
    //   165: aload 15
    //   167: getfield 389	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   170: iconst_1
    //   171: aconst_null
    //   172: invokestatic 411	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   175: astore 13
    //   177: aload 13
    //   179: astore 10
    //   181: aload 13
    //   183: ifnonnull +21 -> 204
    //   186: aload 11
    //   188: astore 12
    //   190: aload 14
    //   192: aload 15
    //   194: getfield 389	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   197: iconst_3
    //   198: aconst_null
    //   199: invokestatic 411	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   202: astore 10
    //   204: aload 11
    //   206: astore 12
    //   208: aload 10
    //   210: astore 13
    //   212: aload 11
    //   214: invokeinterface 414 1 0
    //   219: istore 9
    //   221: iload 9
    //   223: ifne -19 -> 204
    //   226: aload 10
    //   228: astore 12
    //   230: aload 11
    //   232: ifnull +14 -> 246
    //   235: aload 11
    //   237: invokeinterface 417 1 0
    //   242: aload 10
    //   244: astore 12
    //   246: aload 12
    //   248: ifnull +211 -> 459
    //   251: aload 12
    //   253: invokevirtual 423	android/graphics/Bitmap:getWidth	()I
    //   256: aload 12
    //   258: invokevirtual 426	android/graphics/Bitmap:getHeight	()I
    //   261: if_icmple +190 -> 451
    //   264: ldc_w 349
    //   267: aload 17
    //   269: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   272: ifne +179 -> 451
    //   275: ldc_w 428
    //   278: aload 17
    //   280: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   283: ifne +168 -> 451
    //   286: aload 12
    //   288: ldc_w 429
    //   291: invokestatic 434	com/tencent/biz/qqstory/utils/UIUtils:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   294: putstatic 436	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   297: aload 12
    //   299: invokevirtual 439	android/graphics/Bitmap:recycle	()V
    //   302: lload 7
    //   304: iload_2
    //   305: sipush 500
    //   308: iadd
    //   309: i2l
    //   310: lcmp
    //   311: ifge +459 -> 770
    //   314: aload_1
    //   315: ldc_w 441
    //   318: invokevirtual 445	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   321: astore 10
    //   323: aload 10
    //   325: ifnull +309 -> 634
    //   328: ldc_w 275
    //   331: ldc_w 447
    //   334: invokestatic 282	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: ldc_w 275
    //   340: aload 10
    //   342: invokestatic 452	com/tencent/biz/qqstory/takevideo2/StoryPublishParams:a	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   345: aload 15
    //   347: getfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   350: iload_2
    //   351: i2l
    //   352: lcmp
    //   353: ifgt +278 -> 631
    //   356: iconst_0
    //   357: istore_2
    //   358: aload_0
    //   359: aload 16
    //   361: aload 15
    //   363: iconst_0
    //   364: iload_2
    //   365: aload 10
    //   367: invokestatic 453	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IILandroid/os/Bundle;)V
    //   370: iconst_1
    //   371: ireturn
    //   372: astore 14
    //   374: aconst_null
    //   375: astore 10
    //   377: aconst_null
    //   378: astore 11
    //   380: aload 11
    //   382: astore 12
    //   384: ldc_w 275
    //   387: ldc_w 455
    //   390: iconst_2
    //   391: anewarray 4	java/lang/Object
    //   394: dup
    //   395: iconst_0
    //   396: aload 15
    //   398: getfield 374	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   401: aastore
    //   402: dup
    //   403: iconst_1
    //   404: aload 14
    //   406: aastore
    //   407: invokestatic 458	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: aload 10
    //   412: astore 12
    //   414: aload 11
    //   416: ifnull -170 -> 246
    //   419: aload 11
    //   421: invokeinterface 417 1 0
    //   426: aload 10
    //   428: astore 12
    //   430: goto -184 -> 246
    //   433: astore_0
    //   434: aconst_null
    //   435: astore 12
    //   437: aload 12
    //   439: ifnull +10 -> 449
    //   442: aload 12
    //   444: invokeinterface 417 1 0
    //   449: aload_0
    //   450: athrow
    //   451: aload 12
    //   453: putstatic 436	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   456: goto -154 -> 302
    //   459: invokestatic 463	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   462: getfield 466	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr;
    //   465: iconst_0
    //   466: invokevirtual 471	com/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr:a	(Z)Landroid/graphics/Bitmap;
    //   469: putstatic 436	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   472: goto -170 -> 302
    //   475: aload_1
    //   476: ldc_w 441
    //   479: invokevirtual 445	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   482: astore 10
    //   484: aload 10
    //   486: ifnull +50 -> 536
    //   489: ldc_w 275
    //   492: ldc_w 447
    //   495: invokestatic 282	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   498: ldc_w 275
    //   501: aload 10
    //   503: invokestatic 452	com/tencent/biz/qqstory/takevideo2/StoryPublishParams:a	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   506: aload 15
    //   508: getfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   511: iload_2
    //   512: i2l
    //   513: lcmp
    //   514: ifgt +19 -> 533
    //   517: iconst_0
    //   518: istore_2
    //   519: aload_0
    //   520: aload 16
    //   522: aload 15
    //   524: iconst_0
    //   525: iload_2
    //   526: aload 10
    //   528: invokestatic 453	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IILandroid/os/Bundle;)V
    //   531: iconst_1
    //   532: ireturn
    //   533: goto -14 -> 519
    //   536: aload_1
    //   537: ldc 137
    //   539: iconst_0
    //   540: invokevirtual 313	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   543: istore_3
    //   544: aload_1
    //   545: ldc 139
    //   547: invokevirtual 61	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   550: astore 10
    //   552: aload_1
    //   553: ldc 141
    //   555: invokevirtual 61	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   558: astore 11
    //   560: aload_1
    //   561: ldc 145
    //   563: ldc2_w 472
    //   566: invokevirtual 178	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   569: lstore 7
    //   571: aload_1
    //   572: ldc 150
    //   574: iconst_0
    //   575: invokevirtual 251	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   578: istore 9
    //   580: aload_1
    //   581: ldc 143
    //   583: iconst_0
    //   584: invokevirtual 313	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   587: istore 5
    //   589: aload 15
    //   591: getfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   594: iload_2
    //   595: i2l
    //   596: lcmp
    //   597: ifgt +31 -> 628
    //   600: iconst_0
    //   601: istore_2
    //   602: aload_0
    //   603: aload 16
    //   605: aload 15
    //   607: iconst_0
    //   608: iload_2
    //   609: iload 4
    //   611: iload_3
    //   612: aload 10
    //   614: aload 11
    //   616: lload 7
    //   618: iload 9
    //   620: iload 5
    //   622: invokestatic 475	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IIIILjava/lang/String;Ljava/lang/String;JZI)V
    //   625: goto -94 -> 531
    //   628: goto -26 -> 602
    //   631: goto -273 -> 358
    //   634: aload_1
    //   635: ldc 137
    //   637: iconst_0
    //   638: invokevirtual 313	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   641: istore 5
    //   643: aload_1
    //   644: ldc 139
    //   646: invokevirtual 61	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   649: astore 10
    //   651: aload_1
    //   652: ldc 141
    //   654: invokevirtual 61	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   657: astore 11
    //   659: aload_1
    //   660: ldc 145
    //   662: ldc2_w 472
    //   665: invokevirtual 178	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   668: lstore 7
    //   670: aload_1
    //   671: ldc 150
    //   673: iconst_0
    //   674: invokevirtual 251	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   677: istore 9
    //   679: aload_1
    //   680: ldc 143
    //   682: iconst_0
    //   683: invokevirtual 313	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   686: istore 6
    //   688: aload_1
    //   689: ldc 160
    //   691: invokevirtual 61	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   694: astore_1
    //   695: ldc_w 349
    //   698: aload_1
    //   699: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   702: ifeq +60 -> 762
    //   705: bipush 10
    //   707: istore_3
    //   708: aload_1
    //   709: ldc_w 428
    //   712: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   715: ifeq +78 -> 793
    //   718: bipush 12
    //   720: istore_3
    //   721: aload 15
    //   723: getfield 102	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   726: iload_2
    //   727: i2l
    //   728: lcmp
    //   729: ifgt +38 -> 767
    //   732: iconst_0
    //   733: istore_2
    //   734: aload_0
    //   735: aload 16
    //   737: aload 15
    //   739: iconst_0
    //   740: iload_2
    //   741: iload 4
    //   743: iload 5
    //   745: aload 10
    //   747: aload 11
    //   749: lload 7
    //   751: iload 9
    //   753: iload 6
    //   755: iload_3
    //   756: invokestatic 212	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IIIILjava/lang/String;Ljava/lang/String;JZII)V
    //   759: goto -389 -> 370
    //   762: iconst_1
    //   763: istore_3
    //   764: goto -56 -> 708
    //   767: goto -33 -> 734
    //   770: iconst_0
    //   771: ireturn
    //   772: astore_0
    //   773: goto -336 -> 437
    //   776: astore 14
    //   778: aconst_null
    //   779: astore 10
    //   781: goto -401 -> 380
    //   784: astore 14
    //   786: aload 13
    //   788: astore 10
    //   790: goto -410 -> 380
    //   793: goto -72 -> 721
    //   796: aconst_null
    //   797: astore 10
    //   799: goto -595 -> 204
    //   802: aconst_null
    //   803: astore 10
    //   805: goto -579 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	808	0	paramActivity	Activity
    //   0	808	1	paramIntent	Intent
    //   22	719	2	i	int
    //   543	221	3	j	int
    //   59	683	4	k	int
    //   587	157	5	m	int
    //   686	68	6	n	int
    //   37	713	7	l	long
    //   219	533	9	bool	boolean
    //   179	625	10	localObject1	Object
    //   138	610	11	localObject2	Object
    //   147	305	12	localObject3	Object
    //   175	612	13	localObject4	Object
    //   108	83	14	localContentResolver	android.content.ContentResolver
    //   372	33	14	localException1	Exception
    //   776	1	14	localException2	Exception
    //   784	1	14	localException3	Exception
    //   49	689	15	localLocalMediaInfo	LocalMediaInfo
    //   89	647	16	str1	String
    //   6	273	17	str2	String
    // Exception table:
    //   from	to	target	type
    //   110	140	372	java/lang/Exception
    //   110	140	433	finally
    //   149	159	772	finally
    //   163	177	772	finally
    //   190	204	772	finally
    //   212	221	772	finally
    //   384	410	772	finally
    //   149	159	776	java/lang/Exception
    //   163	177	776	java/lang/Exception
    //   190	204	784	java/lang/Exception
    //   212	221	784	java/lang/Exception
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
  
  public void c_(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback
 * JD-Core Version:    0.7.0.1
 */