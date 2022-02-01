package com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
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
  public static int g;
  public static int h;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsBitmap = null;
    jdField_a_of_type_Int = 419430400;
    jdField_b_of_type_Int = 240;
    c = 180000;
    d = 2000;
    e = 10002200;
    f = 10485760;
    g = 240;
    h = 0;
    jdField_a_of_type_Float = e / 10000 / 1000.0F;
    jdField_b_of_type_Float = e % 10000 / 1000.0F;
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
  
  public static void a(Activity paramActivity)
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
            break label686;
            paramInt2 = paramInt1;
            if (paramInt6 == 10)
            {
              bool1 = paramActivity.getIntent().getBooleanExtra("needVideoDoodle", false);
              bool2 = paramActivity.getIntent().getBooleanExtra("needVideoWording", false);
              paramInt3 = paramInt1;
              if (bool1) {
                break label802;
              }
              paramInt3 = paramInt1 & 0xFFFFFFFE;
              break label802;
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
                break label821;
              }
              paramInt2 = paramInt1 & 0xFFFFFFFE;
              break label821;
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
              break label838;
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
            break label838;
            label629:
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
      label686:
      label821:
      label838:
      do
      {
        paramInt1 = 10002;
        break label629;
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
      label802:
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
        break label320;
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
      SLog.b("Q.qqstory.publish.QQStoryFlowCallback", "EditVideoParams params:" + paramString.toString());
      paramLocalMediaInfo = new Intent(paramActivity, EditVideoActivity.class);
      paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramString);
      paramActivity.startActivityForResult(paramLocalMediaInfo, 10002);
      return;
      paramString = new EditLocalPhotoSource(paramString, paramLocalMediaInfo);
      paramInt2 = 4374893;
      continue;
      label320:
      paramInt2 = 4374893;
    }
  }
  
  /* Error */
  public static boolean a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 326
    //   4: invokevirtual 69	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   7: pop
    //   8: aload_0
    //   9: iconst_1
    //   10: invokestatic 174	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;I)Ljava/lang/String;
    //   13: pop
    //   14: aload_1
    //   15: ldc_w 328
    //   18: lconst_0
    //   19: invokevirtual 191	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   22: lstore 9
    //   24: aload_1
    //   25: ldc_w 330
    //   28: invokevirtual 334	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   31: checkcast 85	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   34: astore 16
    //   36: aload_1
    //   37: ldc 179
    //   39: bipush 99
    //   41: invokevirtual 290	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   44: istore 5
    //   46: aload 16
    //   48: ifnonnull +17 -> 65
    //   51: new 336	java/lang/IllegalArgumentException
    //   54: dup
    //   55: ldc_w 337
    //   58: invokestatic 340	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   61: invokespecial 341	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   64: athrow
    //   65: aload 16
    //   67: getfield 344	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   70: astore 17
    //   72: aload 16
    //   74: getfield 116	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   77: ldc 194
    //   79: invokevirtual 198	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   82: ifeq +321 -> 403
    //   85: aload_0
    //   86: invokevirtual 348	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   89: astore 15
    //   91: aload 15
    //   93: getstatic 354	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   96: aconst_null
    //   97: ldc_w 356
    //   100: iconst_1
    //   101: anewarray 137	java/lang/String
    //   104: dup
    //   105: iconst_0
    //   106: aload 16
    //   108: getfield 359	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   111: invokestatic 362	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   114: aastore
    //   115: aconst_null
    //   116: invokevirtual 368	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   119: astore 12
    //   121: aload 12
    //   123: ifnull +629 -> 752
    //   126: aload 12
    //   128: astore 13
    //   130: aload 12
    //   132: invokeinterface 374 1 0
    //   137: ifeq +609 -> 746
    //   140: aload 12
    //   142: astore 13
    //   144: aload 15
    //   146: aload 16
    //   148: getfield 359	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   151: iconst_1
    //   152: aconst_null
    //   153: invokestatic 380	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   156: astore 14
    //   158: aload 14
    //   160: astore 11
    //   162: aload 14
    //   164: ifnonnull +21 -> 185
    //   167: aload 12
    //   169: astore 13
    //   171: aload 15
    //   173: aload 16
    //   175: getfield 359	com/tencent/mobileqq/activity/photo/LocalMediaInfo:_id	J
    //   178: iconst_3
    //   179: aconst_null
    //   180: invokestatic 380	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   183: astore 11
    //   185: aload 12
    //   187: astore 13
    //   189: aload 11
    //   191: astore 14
    //   193: aload 12
    //   195: invokeinterface 383 1 0
    //   200: istore 8
    //   202: iload 8
    //   204: ifne -19 -> 185
    //   207: aload 11
    //   209: astore 13
    //   211: aload 12
    //   213: ifnull +14 -> 227
    //   216: aload 12
    //   218: invokeinterface 386 1 0
    //   223: aload 11
    //   225: astore 13
    //   227: aload 13
    //   229: ifnull +158 -> 387
    //   232: aload 13
    //   234: putstatic 21	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   237: lload 9
    //   239: sipush 10500
    //   242: i2l
    //   243: lcmp
    //   244: ifge +476 -> 720
    //   247: iload_2
    //   248: ifeq +472 -> 720
    //   251: aload_1
    //   252: ldc_w 388
    //   255: invokevirtual 392	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   258: astore 11
    //   260: aload 11
    //   262: ifnull +314 -> 576
    //   265: ldc 133
    //   267: ldc_w 394
    //   270: invokestatic 248	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: ldc 133
    //   275: aload 11
    //   277: invokestatic 399	com/tencent/biz/qqstory/takevideo2/StoryPublishParams:a	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   280: aload 16
    //   282: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   285: sipush 10000
    //   288: i2l
    //   289: lcmp
    //   290: ifgt +279 -> 569
    //   293: iconst_0
    //   294: istore_3
    //   295: aload_0
    //   296: aload 17
    //   298: aload 16
    //   300: iconst_0
    //   301: iload_3
    //   302: aload 11
    //   304: invokestatic 401	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IILandroid/os/Bundle;)V
    //   307: iconst_1
    //   308: ireturn
    //   309: astore 15
    //   311: aconst_null
    //   312: astore 11
    //   314: aconst_null
    //   315: astore 12
    //   317: aload 12
    //   319: astore 13
    //   321: ldc 133
    //   323: ldc_w 403
    //   326: iconst_2
    //   327: anewarray 4	java/lang/Object
    //   330: dup
    //   331: iconst_0
    //   332: aload 16
    //   334: getfield 344	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   337: aastore
    //   338: dup
    //   339: iconst_1
    //   340: aload 15
    //   342: aastore
    //   343: invokestatic 406	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   346: aload 11
    //   348: astore 13
    //   350: aload 12
    //   352: ifnull -125 -> 227
    //   355: aload 12
    //   357: invokeinterface 386 1 0
    //   362: aload 11
    //   364: astore 13
    //   366: goto -139 -> 227
    //   369: astore_0
    //   370: aconst_null
    //   371: astore 13
    //   373: aload 13
    //   375: ifnull +10 -> 385
    //   378: aload 13
    //   380: invokeinterface 386 1 0
    //   385: aload_0
    //   386: athrow
    //   387: invokestatic 411	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   390: getfield 414	com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Lcom/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr;
    //   393: iconst_0
    //   394: invokevirtual 419	com/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr:a	(Z)Landroid/graphics/Bitmap;
    //   397: putstatic 21	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   400: goto -163 -> 237
    //   403: aload_1
    //   404: ldc_w 388
    //   407: invokevirtual 392	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   410: astore 11
    //   412: aload 11
    //   414: ifnull +54 -> 468
    //   417: ldc 133
    //   419: ldc_w 394
    //   422: invokestatic 248	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: ldc 133
    //   427: aload 11
    //   429: invokestatic 399	com/tencent/biz/qqstory/takevideo2/StoryPublishParams:a	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   432: aload 16
    //   434: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   437: sipush 10000
    //   440: i2l
    //   441: lcmp
    //   442: ifgt +19 -> 461
    //   445: iconst_0
    //   446: istore_3
    //   447: aload_0
    //   448: aload 17
    //   450: aload 16
    //   452: iconst_0
    //   453: iload_3
    //   454: aload 11
    //   456: invokestatic 401	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IILandroid/os/Bundle;)V
    //   459: iconst_1
    //   460: ireturn
    //   461: sipush 10000
    //   464: istore_3
    //   465: goto -18 -> 447
    //   468: aload_1
    //   469: ldc 235
    //   471: iconst_0
    //   472: invokevirtual 290	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   475: istore 4
    //   477: aload_1
    //   478: ldc 237
    //   480: invokevirtual 69	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   483: astore 11
    //   485: aload_1
    //   486: ldc 239
    //   488: invokevirtual 69	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   491: astore 12
    //   493: aload_1
    //   494: ldc 243
    //   496: ldc2_w 420
    //   499: invokevirtual 191	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   502: lstore 9
    //   504: aload_1
    //   505: ldc 233
    //   507: iconst_0
    //   508: invokevirtual 131	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   511: istore_2
    //   512: aload_1
    //   513: ldc 241
    //   515: iconst_0
    //   516: invokevirtual 290	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   519: istore 6
    //   521: aload 16
    //   523: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   526: sipush 10000
    //   529: i2l
    //   530: lcmp
    //   531: ifgt +31 -> 562
    //   534: iconst_0
    //   535: istore_3
    //   536: aload_0
    //   537: aload 17
    //   539: aload 16
    //   541: iconst_0
    //   542: iload_3
    //   543: iload 5
    //   545: iload 4
    //   547: aload 11
    //   549: aload 12
    //   551: lload 9
    //   553: iload_2
    //   554: iload 6
    //   556: invokestatic 423	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IIIILjava/lang/String;Ljava/lang/String;JZI)V
    //   559: goto -100 -> 459
    //   562: sipush 10000
    //   565: istore_3
    //   566: goto -30 -> 536
    //   569: sipush 10000
    //   572: istore_3
    //   573: goto -278 -> 295
    //   576: aload_1
    //   577: ldc 235
    //   579: iconst_0
    //   580: invokevirtual 290	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   583: istore 6
    //   585: aload_1
    //   586: ldc 237
    //   588: invokevirtual 69	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   591: astore 11
    //   593: aload_1
    //   594: ldc 239
    //   596: invokevirtual 69	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   599: astore 12
    //   601: aload_1
    //   602: ldc 243
    //   604: ldc2_w 420
    //   607: invokevirtual 191	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   610: lstore 9
    //   612: aload_1
    //   613: ldc 233
    //   615: iconst_0
    //   616: invokevirtual 131	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   619: istore_2
    //   620: aload_1
    //   621: ldc 241
    //   623: iconst_0
    //   624: invokevirtual 290	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   627: istore 7
    //   629: aload_1
    //   630: ldc_w 326
    //   633: invokevirtual 69	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   636: astore_1
    //   637: ldc_w 425
    //   640: aload_1
    //   641: invokevirtual 429	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   644: ifeq +63 -> 707
    //   647: bipush 10
    //   649: istore_3
    //   650: aload_1
    //   651: ldc_w 431
    //   654: invokevirtual 429	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   657: ifeq +86 -> 743
    //   660: bipush 12
    //   662: istore_3
    //   663: aload 16
    //   665: getfield 110	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   668: sipush 10000
    //   671: i2l
    //   672: lcmp
    //   673: ifgt +39 -> 712
    //   676: iconst_0
    //   677: istore 4
    //   679: aload_0
    //   680: aload 17
    //   682: aload 16
    //   684: iconst_0
    //   685: iload 4
    //   687: iload 5
    //   689: iload 6
    //   691: aload 11
    //   693: aload 12
    //   695: lload 9
    //   697: iload_2
    //   698: iload 7
    //   700: iload_3
    //   701: invokestatic 167	com/tencent/mobileqq/activity/richmedia/QQStoryFlowCallback:a	(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;IIIILjava/lang/String;Ljava/lang/String;JZII)V
    //   704: goto -397 -> 307
    //   707: iconst_1
    //   708: istore_3
    //   709: goto -59 -> 650
    //   712: sipush 10000
    //   715: istore 4
    //   717: goto -38 -> 679
    //   720: iconst_0
    //   721: ireturn
    //   722: astore_0
    //   723: goto -350 -> 373
    //   726: astore 15
    //   728: aconst_null
    //   729: astore 11
    //   731: goto -414 -> 317
    //   734: astore 15
    //   736: aload 14
    //   738: astore 11
    //   740: goto -423 -> 317
    //   743: goto -80 -> 663
    //   746: aconst_null
    //   747: astore 11
    //   749: goto -564 -> 185
    //   752: aconst_null
    //   753: astore 11
    //   755: goto -548 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	758	0	paramActivity	Activity
    //   0	758	1	paramIntent	Intent
    //   0	758	2	paramBoolean	boolean
    //   294	415	3	i	int
    //   475	241	4	j	int
    //   44	644	5	k	int
    //   519	171	6	m	int
    //   627	72	7	n	int
    //   200	3	8	bool	boolean
    //   22	674	9	l	long
    //   160	594	11	localObject1	Object
    //   119	575	12	localObject2	Object
    //   128	251	13	localObject3	Object
    //   156	581	14	localObject4	Object
    //   89	83	15	localContentResolver	android.content.ContentResolver
    //   309	32	15	localException1	Exception
    //   726	1	15	localException2	Exception
    //   734	1	15	localException3	Exception
    //   34	649	16	localLocalMediaInfo	LocalMediaInfo
    //   70	611	17	str	String
    // Exception table:
    //   from	to	target	type
    //   91	121	309	java/lang/Exception
    //   91	121	369	finally
    //   130	140	722	finally
    //   144	158	722	finally
    //   171	185	722	finally
    //   193	202	722	finally
    //   321	346	722	finally
    //   130	140	726	java/lang/Exception
    //   144	158	726	java/lang/Exception
    //   171	185	734	java/lang/Exception
    //   193	202	734	java/lang/Exception
  }
  
  public String getRefer()
  {
    return "qqstory";
  }
  
  public void localVideoClick(Activity paramActivity)
  {
    SLog.b("Q.qqstory.publish.QQStoryFlowCallback", "localVideoClick");
    if (paramActivity == null) {
      SLog.e("Q.qqstory.publish.QQStoryFlowCallback", "context == null");
    }
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
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
  
  public void sendClick(Activity paramActivity, Intent paramIntent) {}
  
  public void setRefer(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback
 * JD-Core Version:    0.7.0.1
 */