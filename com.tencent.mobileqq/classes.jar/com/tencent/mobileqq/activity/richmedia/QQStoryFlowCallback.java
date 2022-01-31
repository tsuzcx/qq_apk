package com.tencent.mobileqq.activity.richmedia;

import ahua;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import bbbw;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import java.io.File;
import ved;
import vei;
import vsq;
import vyf;

public class QQStoryFlowCallback
  implements ahua
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
  public static int g;
  
  static
  {
    jdField_a_of_type_Int = 419430400;
    jdField_b_of_type_Int = 240;
    c = 180000;
    d = 2000;
    e = 10002200;
    f = 10485760;
    g = 240;
    jdField_a_of_type_Float = e / 10000 / 1000.0F;
    jdField_b_of_type_Float = e % 10000 / 1000.0F;
  }
  
  public static String a(Activity paramActivity, int paramInt)
  {
    if (paramActivity.getIntent().hasExtra("extra_upload_temp_directory")) {
      return paramActivity.getIntent().getStringExtra("extra_upload_temp_directory");
    }
    String str = vsq.a(paramInt);
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
    localIntent.putExtra("ALBUM_NAME", bbbw.l);
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
            break label698;
            paramInt2 = paramInt1;
            if (paramInt6 == 10)
            {
              bool1 = paramActivity.getIntent().getBooleanExtra("needVideoDoodle", false);
              bool2 = paramActivity.getIntent().getBooleanExtra("needVideoWording", false);
              paramInt3 = paramInt1;
              if (bool1) {
                break label817;
              }
              paramInt3 = paramInt1 & 0xFFFFFFFE;
              break label817;
            }
            label238:
            paramInt1 = paramInt2;
            if (paramInt6 == 12)
            {
              paramInt1 = paramInt2 & 0xFFBFFFFF & 0xFFFFBFFF & 0xFFFDFFFF;
              bool1 = paramActivity.getIntent().getBooleanExtra("needVideoDoodle", false);
              bool2 = paramActivity.getIntent().getBooleanExtra("needVideoWording", false);
              paramInt2 = paramInt1;
              if (bool1) {
                break label836;
              }
              paramInt2 = paramInt1 & 0xFFFFFFFE;
              break label836;
            }
            label305:
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
            ved.b("Q.qqstory.publish.QQStoryFlowCallback", "EditVideoParams params:" + paramString1.toString());
            paramLocalMediaInfo = new Intent(paramActivity, EditVideoActivity.class);
            paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramString1);
            paramLocalMediaInfo.putExtra("op_department", "grp_qq");
            paramLocalMediaInfo.putExtra("op_type", "video_edit");
            paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
            if (paramInt6 != 10) {
              break label853;
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
            break label853;
            label640:
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
        ved.e("Q.qqstory.publish.QQStoryFlowCallback", "startEditVideoActivity exception:" + paramActivity);
        return;
      }
      label698:
      label836:
      label853:
      do
      {
        paramInt1 = 10002;
        break label640;
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
          break label238;
        }
        paramInt2 = paramInt3 & 0xFFFFFFFB;
        break label238;
        paramInt1 = paramInt2;
        if (bool2) {
          break label305;
        }
        paramInt1 = paramInt2 & 0xFFFFFFFB;
        break label305;
      } while (paramInt6 != 10);
      label817:
      paramInt1 = 10012;
    }
  }
  
  public static void a(Activity paramActivity, String paramString, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("extra_upload_temp_directory", a(paramActivity, 1));
    localBundle.putBoolean("enable_hw_encode", false);
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
      localBundle.putInt("expect_fragment_count", paramInt1);
      if (paramInt1 > 1) {
        break label328;
      }
      paramInt2 = 4342125;
    }
    for (;;)
    {
      i = localBundle.getInt("entrance_type");
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
      if (localBundle.getLong("troop_uin") != 0L) {
        paramInt2 = paramInt1 & 0xFFFFBFFF & 0xFFFDFFFF & 0xFFBFFFFF;
      }
      paramInt1 = paramInt2;
      if (i == 102) {
        paramInt1 = paramInt2 | 0x200000;
      }
      paramInt2 = paramInt1;
      if (localBundle.getInt("shareGroupType") == 1) {
        paramInt2 = paramInt1 & 0xFFFDFFFF;
      }
      paramString = new EditVideoParams(1, paramInt2, paramString, localBundle);
      ved.b("Q.qqstory.publish.QQStoryFlowCallback", "EditVideoParams params:" + paramString.toString());
      paramLocalMediaInfo = new Intent(paramActivity, EditVideoActivity.class);
      paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramString);
      paramActivity.startActivityForResult(paramLocalMediaInfo, 10002);
      return;
      paramString = new EditLocalPhotoSource(paramString, paramLocalMediaInfo);
      paramInt2 = 4374893;
      continue;
      label328:
      paramInt2 = 4374893;
    }
  }
  
  /* Error */
  public static boolean a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 166
    //   3: invokevirtual 64	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   6: pop
    //   7: aload_0
    //   8: iconst_1
    //   9: invokestatic 225	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;I)Ljava/lang/String;
    //   12: pop
    //   13: aload_1
    //   14: ldc_w 347
    //   17: lconst_0
    //   18: invokevirtual 184	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   21: lstore 9
    //   23: aload_1
    //   24: ldc_w 349
    //   27: invokevirtual 353	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   30: checkcast 80	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   33: astore 16
    //   35: aload_1
    //   36: ldc 176
    //   38: bipush 99
    //   40: invokevirtual 319	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   43: istore 5
    //   45: aload 16
    //   47: ifnonnull +17 -> 64
    //   50: new 355	java/lang/IllegalArgumentException
    //   53: dup
    //   54: ldc_w 356
    //   57: invokestatic 359	ajya:a	(I)Ljava/lang/String;
    //   60: invokespecial 362	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   63: athrow
    //   64: aload 16
    //   66: getfield 365	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   69: astore 17
    //   71: aload 16
    //   73: getfield 111	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   76: ldc 236
    //   78: invokevirtual 242	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   81: ifeq +324 -> 405
    //   84: aload_0
    //   85: invokevirtual 369	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   88: astore 15
    //   90: aload 15
    //   92: getstatic 375	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   95: aconst_null
    //   96: ldc_w 377
    //   99: iconst_1
    //   100: anewarray 238	java/lang/String
    //   103: dup
    //   104: iconst_0
    //   105: aload 16
    //   107: getfield 380	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   110: invokestatic 384	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   113: aastore
    //   114: aconst_null
    //   115: invokevirtual 390	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   118: astore 12
    //   120: aload 12
    //   122: ifnull +633 -> 755
    //   125: aload 12
    //   127: astore 13
    //   129: aload 12
    //   131: invokeinterface 396 1 0
    //   136: ifeq +613 -> 749
    //   139: aload 12
    //   141: astore 13
    //   143: aload 15
    //   145: aload 16
    //   147: getfield 380	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   150: iconst_1
    //   151: aconst_null
    //   152: invokestatic 402	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   155: astore 14
    //   157: aload 14
    //   159: astore 11
    //   161: aload 14
    //   163: ifnonnull +21 -> 184
    //   166: aload 12
    //   168: astore 13
    //   170: aload 15
    //   172: aload 16
    //   174: getfield 380	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   177: iconst_3
    //   178: aconst_null
    //   179: invokestatic 402	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   182: astore 11
    //   184: aload 12
    //   186: astore 13
    //   188: aload 11
    //   190: astore 14
    //   192: aload 12
    //   194: invokeinterface 405 1 0
    //   199: istore 8
    //   201: iload 8
    //   203: ifne -19 -> 184
    //   206: aload 11
    //   208: astore 13
    //   210: aload 12
    //   212: ifnull +14 -> 226
    //   215: aload 12
    //   217: invokeinterface 408 1 0
    //   222: aload 11
    //   224: astore 13
    //   226: aload 13
    //   228: ifnull +161 -> 389
    //   231: aload 13
    //   233: putstatic 410	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   236: lload 9
    //   238: sipush 10500
    //   241: i2l
    //   242: lcmp
    //   243: ifge +480 -> 723
    //   246: iload_2
    //   247: ifeq +476 -> 723
    //   250: aload_1
    //   251: ldc_w 412
    //   254: invokevirtual 416	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   257: astore 11
    //   259: aload 11
    //   261: ifnull +319 -> 580
    //   264: ldc_w 281
    //   267: ldc_w 418
    //   270: invokestatic 288	ved:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: ldc_w 281
    //   276: aload 11
    //   278: invokestatic 423	vwl:a	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   281: aload 16
    //   283: getfield 105	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   286: sipush 10000
    //   289: i2l
    //   290: lcmp
    //   291: ifgt +282 -> 573
    //   294: iconst_0
    //   295: istore_3
    //   296: aload_0
    //   297: aload 17
    //   299: aload 16
    //   301: iconst_0
    //   302: iload_3
    //   303: aload 11
    //   305: invokestatic 425	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IILandroid/os/Bundle;)V
    //   308: iconst_1
    //   309: ireturn
    //   310: astore 15
    //   312: aconst_null
    //   313: astore 11
    //   315: aconst_null
    //   316: astore 12
    //   318: aload 12
    //   320: astore 13
    //   322: ldc_w 281
    //   325: ldc_w 427
    //   328: iconst_2
    //   329: anewarray 4	java/lang/Object
    //   332: dup
    //   333: iconst_0
    //   334: aload 16
    //   336: getfield 365	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   339: aastore
    //   340: dup
    //   341: iconst_1
    //   342: aload 15
    //   344: aastore
    //   345: invokestatic 430	ved:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   348: aload 11
    //   350: astore 13
    //   352: aload 12
    //   354: ifnull -128 -> 226
    //   357: aload 12
    //   359: invokeinterface 408 1 0
    //   364: aload 11
    //   366: astore 13
    //   368: goto -142 -> 226
    //   371: astore_0
    //   372: aconst_null
    //   373: astore 13
    //   375: aload 13
    //   377: ifnull +10 -> 387
    //   380: aload 13
    //   382: invokeinterface 408 1 0
    //   387: aload_0
    //   388: athrow
    //   389: invokestatic 435	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   392: getfield 438	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr;
    //   395: iconst_0
    //   396: invokevirtual 443	com/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr:a	(Z)Landroid/graphics/Bitmap;
    //   399: putstatic 410	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   402: goto -166 -> 236
    //   405: aload_1
    //   406: ldc_w 412
    //   409: invokevirtual 416	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   412: astore 11
    //   414: aload 11
    //   416: ifnull +56 -> 472
    //   419: ldc_w 281
    //   422: ldc_w 418
    //   425: invokestatic 288	ved:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   428: ldc_w 281
    //   431: aload 11
    //   433: invokestatic 423	vwl:a	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   436: aload 16
    //   438: getfield 105	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   441: sipush 10000
    //   444: i2l
    //   445: lcmp
    //   446: ifgt +19 -> 465
    //   449: iconst_0
    //   450: istore_3
    //   451: aload_0
    //   452: aload 17
    //   454: aload 16
    //   456: iconst_0
    //   457: iload_3
    //   458: aload 11
    //   460: invokestatic 425	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IILandroid/os/Bundle;)V
    //   463: iconst_1
    //   464: ireturn
    //   465: sipush 10000
    //   468: istore_3
    //   469: goto -18 -> 451
    //   472: aload_1
    //   473: ldc 140
    //   475: iconst_0
    //   476: invokevirtual 319	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   479: istore 4
    //   481: aload_1
    //   482: ldc 142
    //   484: invokevirtual 64	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   487: astore 11
    //   489: aload_1
    //   490: ldc 144
    //   492: invokevirtual 64	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   495: astore 12
    //   497: aload_1
    //   498: ldc 148
    //   500: ldc2_w 444
    //   503: invokevirtual 184	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   506: lstore 9
    //   508: aload_1
    //   509: ldc 153
    //   511: iconst_0
    //   512: invokevirtual 257	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   515: istore_2
    //   516: aload_1
    //   517: ldc 146
    //   519: iconst_0
    //   520: invokevirtual 319	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   523: istore 6
    //   525: aload 16
    //   527: getfield 105	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   530: sipush 10000
    //   533: i2l
    //   534: lcmp
    //   535: ifgt +31 -> 566
    //   538: iconst_0
    //   539: istore_3
    //   540: aload_0
    //   541: aload 17
    //   543: aload 16
    //   545: iconst_0
    //   546: iload_3
    //   547: iload 5
    //   549: iload 4
    //   551: aload 11
    //   553: aload 12
    //   555: lload 9
    //   557: iload_2
    //   558: iload 6
    //   560: invokestatic 447	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IIIILjava/lang/String;Ljava/lang/String;JZI)V
    //   563: goto -100 -> 463
    //   566: sipush 10000
    //   569: istore_3
    //   570: goto -30 -> 540
    //   573: sipush 10000
    //   576: istore_3
    //   577: goto -281 -> 296
    //   580: aload_1
    //   581: ldc 140
    //   583: iconst_0
    //   584: invokevirtual 319	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   587: istore 6
    //   589: aload_1
    //   590: ldc 142
    //   592: invokevirtual 64	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   595: astore 11
    //   597: aload_1
    //   598: ldc 144
    //   600: invokevirtual 64	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   603: astore 12
    //   605: aload_1
    //   606: ldc 148
    //   608: ldc2_w 444
    //   611: invokevirtual 184	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   614: lstore 9
    //   616: aload_1
    //   617: ldc 153
    //   619: iconst_0
    //   620: invokevirtual 257	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   623: istore_2
    //   624: aload_1
    //   625: ldc 146
    //   627: iconst_0
    //   628: invokevirtual 319	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   631: istore 7
    //   633: aload_1
    //   634: ldc 166
    //   636: invokevirtual 64	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   639: astore_1
    //   640: ldc_w 449
    //   643: aload_1
    //   644: invokevirtual 453	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   647: ifeq +63 -> 710
    //   650: bipush 10
    //   652: istore_3
    //   653: aload_1
    //   654: ldc_w 455
    //   657: invokevirtual 453	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   660: ifeq +86 -> 746
    //   663: bipush 12
    //   665: istore_3
    //   666: aload 16
    //   668: getfield 105	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   671: sipush 10000
    //   674: i2l
    //   675: lcmp
    //   676: ifgt +39 -> 715
    //   679: iconst_0
    //   680: istore 4
    //   682: aload_0
    //   683: aload 17
    //   685: aload 16
    //   687: iconst_0
    //   688: iload 4
    //   690: iload 5
    //   692: iload 6
    //   694: aload 11
    //   696: aload 12
    //   698: lload 9
    //   700: iload_2
    //   701: iload 7
    //   703: iload_3
    //   704: invokestatic 218	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IIIILjava/lang/String;Ljava/lang/String;JZII)V
    //   707: goto -399 -> 308
    //   710: iconst_1
    //   711: istore_3
    //   712: goto -59 -> 653
    //   715: sipush 10000
    //   718: istore 4
    //   720: goto -38 -> 682
    //   723: iconst_0
    //   724: ireturn
    //   725: astore_0
    //   726: goto -351 -> 375
    //   729: astore 15
    //   731: aconst_null
    //   732: astore 11
    //   734: goto -416 -> 318
    //   737: astore 15
    //   739: aload 14
    //   741: astore 11
    //   743: goto -425 -> 318
    //   746: goto -80 -> 666
    //   749: aconst_null
    //   750: astore 11
    //   752: goto -568 -> 184
    //   755: aconst_null
    //   756: astore 11
    //   758: goto -552 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	761	0	paramActivity	Activity
    //   0	761	1	paramIntent	Intent
    //   0	761	2	paramBoolean	boolean
    //   295	417	3	i	int
    //   479	240	4	j	int
    //   43	648	5	k	int
    //   523	170	6	m	int
    //   631	71	7	n	int
    //   199	3	8	bool	boolean
    //   21	678	9	l	long
    //   159	598	11	localObject1	Object
    //   118	579	12	localObject2	Object
    //   127	254	13	localObject3	Object
    //   155	585	14	localObject4	Object
    //   88	83	15	localContentResolver	android.content.ContentResolver
    //   310	33	15	localException1	Exception
    //   729	1	15	localException2	Exception
    //   737	1	15	localException3	Exception
    //   33	653	16	localLocalMediaInfo	LocalMediaInfo
    //   69	615	17	str	String
    // Exception table:
    //   from	to	target	type
    //   90	120	310	java/lang/Exception
    //   90	120	371	finally
    //   129	139	725	finally
    //   143	157	725	finally
    //   170	184	725	finally
    //   192	201	725	finally
    //   322	348	725	finally
    //   129	139	729	java/lang/Exception
    //   143	157	729	java/lang/Exception
    //   170	184	737	java/lang/Exception
    //   192	201	737	java/lang/Exception
  }
  
  public static void b(Activity paramActivity)
  {
    String str = paramActivity.getIntent().getStringExtra("extra_upload_temp_directory");
    if (!paramActivity.getIntent().getBooleanExtra("edit_video_extra_flag_need_remove_temp_dir", false))
    {
      ved.b("Q.qqstory.publish.QQStoryFlowCallback", "Publish onActivityResult user confirmed, no need remove temp dir %s!", String.valueOf(str));
      return;
    }
    if (str != null)
    {
      vyf.a(new File(str));
      ved.b("Q.qqstory.publish.QQStoryFlowCallback", "Publish onActivityResult user cancel, delete all files in temp dir %s!", str);
      return;
    }
    ved.e("Q.qqstory.publish.QQStoryFlowCallback", "Publish onActivityResult user cancel, delete all files in temp dir (null)!");
  }
  
  public String a()
  {
    return "qqstory";
  }
  
  public void a(Activity paramActivity)
  {
    String str = null;
    int k = 0;
    ved.b("Q.qqstory.publish.QQStoryFlowCallback", "localVideoClick");
    if (paramActivity == null)
    {
      ved.e("Q.qqstory.publish.QQStoryFlowCallback", "context == null");
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
          vei.a("video_shoot", "clk_local", 0, 0, new String[0]);
          a(paramActivity, 0, a(), bool1, i, j, (String)localObject, str, l, bool2, k, 10006);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        ved.b("Q.qqstory.publish.QQStoryFlowCallback", "QQStoryFlowCallback ", paramActivity);
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
        ved.c("Q.qqstory.publish.QQStoryFlowCallback", "mVideoThumbnailCache clear()");
      }
      return;
    }
  }
  
  public void a(Activity paramActivity, Intent paramIntent) {}
  
  public void c_(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback
 * JD-Core Version:    0.7.0.1
 */