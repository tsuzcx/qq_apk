package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishFileManager;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.StoryIntentUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQStoryFlowCallback
{
  public static int a = 419430400;
  public static int b = 240;
  public static int c = 180000;
  public static int d = 2000;
  public static int e = 12002200;
  public static int f = 20971520;
  public static int g = 240;
  public static int h;
  public static float i;
  public static float j;
  
  static
  {
    int k = e;
    i = k / 10000 / 1000.0F;
    j = k % 10000 / 1000.0F;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocalMediaInfo.fileSize);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLocalMediaInfo.mediaWidth);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLocalMediaInfo.mediaHeight);
    localStringBuilder.append("|");
    localStringBuilder.append(paramLocalMediaInfo.mDuration);
    localStringBuilder.append(",");
    localStringBuilder.append(paramLocalMediaInfo.mMimeType);
    localStringBuilder.append(",");
    localStringBuilder.append(paramLocalMediaInfo.rotation);
    return localStringBuilder.toString();
  }
  
  public static JSONObject a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("options");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTribeJsonExtra option: ");
        localStringBuilder.append(paramBundle);
        QLog.d("Q.qqstory.publish.QQStoryFlowCallback", 2, localStringBuilder.toString());
      }
      try
      {
        paramBundle = new JSONObject(paramBundle);
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getTribeJsonExtra: ");
          localStringBuilder.append(paramBundle);
          QLog.e("Q.qqstory.publish.QQStoryFlowCallback", 2, localStringBuilder.toString());
        }
      }
    }
    return null;
  }
  
  public static void a(Activity paramActivity, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, boolean paramBoolean, int paramInt6, int paramInt7, Bundle paramBundle)
  {
    boolean bool1;
    boolean bool2;
    try
    {
      localBundle = new Bundle();
      localBundle.putString("extra_upload_temp_directory", a(paramActivity, paramInt7));
      localBundle.putInt("entrance_type", paramInt3);
      l = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
      bool1 = paramLocalMediaInfo.mMimeType.contains("video");
      if (bool1)
      {
        if ((!TextUtils.isEmpty(paramLocalMediaInfo.path)) && (!paramLocalMediaInfo.path.equalsIgnoreCase("null"))) {
          ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setContentType(4L);
        }
        paramString1 = new EditLocalVideoSource(paramString1, paramLocalMediaInfo, paramInt1, paramInt2);
      }
      else
      {
        if ((!TextUtils.isEmpty(paramLocalMediaInfo.path)) && (!paramLocalMediaInfo.path.equalsIgnoreCase("null"))) {
          ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setContentType(3L);
        }
        paramString1 = new EditLocalPhotoSource(paramString1, paramLocalMediaInfo);
      }
      if (paramInt7 != 11) {
        break label847;
      }
      paramLocalMediaInfo = paramActivity.getIntent().getExtras();
      JSONObject localJSONObject = a(paramLocalMediaInfo);
      if (localJSONObject == null) {
        break label809;
      }
      bool2 = localJSONObject.optBoolean("needVideoDoodle", false);
      bool1 = localJSONObject.optBoolean("needVideoWording", false);
    }
    catch (Exception paramActivity)
    {
      Bundle localBundle;
      long l;
      label225:
      paramString1 = new StringBuilder();
      label274:
      label322:
      paramString1.append("startEditVideoActivity exception:");
      label424:
      label437:
      paramString1.append(paramActivity);
      label515:
      SLog.e("Q.qqstory.publish.QQStoryFlowCallback", paramString1.toString());
      return;
    }
    localBundle.putAll(paramLocalMediaInfo);
    if (paramInt7 == 12)
    {
      bool1 = paramActivity.getIntent().getBooleanExtra("needVideoDoodle", false);
      bool2 = paramActivity.getIntent().getBooleanExtra("needVideoWording", false);
      paramInt2 = paramInt1;
      if (!bool1)
      {
        paramInt2 = paramInt1 & 0xFFFFFBFF;
        break label854;
        if (((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryPhoto(paramActivity.getIntent(), paramInt7)) {
          break label901;
        }
        paramInt1 = paramInt2;
        if (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry(paramActivity.getIntent())) {
          break label905;
        }
        break label901;
        paramLocalMediaInfo = new EditVideoParams(paramInt7, paramInt2, paramString1, localBundle);
        paramLocalMediaInfo.h = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
        if (l != 0L) {
          paramLocalMediaInfo.d.putLong("troop_uin", l);
        }
        bool2 = true;
        if (paramInt7 != 14) {
          break label945;
        }
        paramLocalMediaInfo.d.putBoolean("extra_is_fit_center", true);
        localBundle = paramLocalMediaInfo.d;
        paramString1 = paramBundle;
        if ((paramString1 == null) || (!paramString1.getBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT"))) {
          break label939;
        }
        bool1 = true;
        localBundle.putBoolean("extra_photo_list_to_edit", bool1);
        paramLocalMediaInfo.d.putBoolean("enable_hw_encode", true);
        paramLocalMediaInfo.d.putBoolean("ignorePersonalPublish", paramBoolean);
        paramLocalMediaInfo.d.putInt("shareGroupType", paramInt5);
        paramLocalMediaInfo.d.putString("shareGroupId", paramString2);
        paramLocalMediaInfo.d.putString("shareGroupName", paramString3);
        paramString1 = paramLocalMediaInfo.d;
        if (paramInt6 != 7) {
          break label948;
        }
        paramBoolean = bool2;
        paramString1.putBoolean("extra_is_slide_show_video", paramBoolean);
        paramString1 = new StringBuilder();
        paramString1.append("EditVideoParams params:");
        paramString1.append(paramLocalMediaInfo.toString());
        SLog.b("Q.qqstory.publish.QQStoryFlowCallback", paramString1.toString());
        paramString1 = new Intent(paramActivity, EditVideoActivity.class);
        StoryIntentUtils.a(paramString1, paramActivity.getIntent().getExtras(), paramActivity);
        paramString1.putExtra(EditVideoParams.class.getName(), paramLocalMediaInfo);
        paramString1.putExtra("op_department", "grp_qq");
        paramString1.putExtra("op_type", "video_edit");
        paramString1.putExtra("stop_record_time", System.currentTimeMillis());
        paramString1.putExtra("short_video_entrance_type", 6);
        paramString1.putExtra("edit_video_way", paramInt6);
        paramString1.putExtra("VIDEO_STORY_FROM_TYPE", ((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).getAEFromType(paramActivity.getIntent()));
        if (paramInt7 == 14)
        {
          paramString1.putExtra("VIDEO_STORY_JUMP_TO_TYPE", ((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).getStoryShareType(paramActivity.getIntent()));
          paramString1.putExtra("VIDEO_STORY_MEDIA_TYPE", ((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).getStoryMediaType(paramActivity.getIntent()));
        }
        if (paramBundle == null) {
          break label954;
        }
        paramString1.putExtra("state", paramBundle);
        break label954;
      }
    }
    for (;;)
    {
      paramString1.putExtra("stop_record_time", System.currentTimeMillis());
      paramString1.putExtra("key_from_pic_choose", a(paramActivity));
      paramActivity.startActivityForResult(paramString1, paramInt1);
      return;
      label809:
      bool1 = false;
      bool2 = false;
      if (!bool2) {
        paramInt1 = 619;
      } else {
        paramInt1 = 1643;
      }
      if (!bool1)
      {
        paramInt1 &= 0xFFFFFFFE;
        break;
      }
      break;
      label847:
      paramInt1 = 1643;
      break label225;
      label854:
      paramInt1 = paramInt2;
      if (!bool2) {
        paramInt1 = paramInt2 & 0xFFFFFFFE;
      }
      paramInt2 = paramInt1;
      if (paramInt7 == 11) {
        break label274;
      }
      paramInt2 = paramInt1;
      if (paramInt7 == 12) {
        break label274;
      }
      paramInt2 = paramInt1 | 0x1000;
      break label274;
      label901:
      paramInt1 = 512;
      label905:
      paramInt3 = 10023;
      if (paramInt4 != 10023)
      {
        paramInt2 = paramInt1;
        if (paramInt4 != 10024) {
          break label322;
        }
      }
      paramInt2 = paramInt1 | 0x2000;
      break label322;
      label939:
      bool1 = false;
      break label424;
      label945:
      break label437;
      label948:
      paramBoolean = false;
      break label515;
      label954:
      if (paramInt7 == 11) {
        paramInt1 = 10012;
      } else if (paramInt7 == 12) {
        paramInt1 = 10013;
      } else if (paramInt7 == 14) {
        paramInt1 = paramInt3;
      } else if (paramInt7 == 2) {
        paramInt1 = 10000;
      } else {
        paramInt1 = 10002;
      }
    }
  }
  
  public static boolean a()
  {
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    if (localStoryConfigManager == null)
    {
      SLog.e("Q.qqstory.publish.QQStoryFlowCallback", "StoryConfigManager(CONFIG_MANAGER) is null!");
      return false;
    }
    int k = localStoryConfigManager.f();
    if (k == h) {
      return false;
    }
    a = ((Integer)localStoryConfigManager.c("localUploadVideoSizeLimit", Integer.valueOf(a))).intValue();
    b = ((Integer)localStoryConfigManager.c("localUploadVideoMinResolutionLimit", Integer.valueOf(b))).intValue();
    c = ((Integer)localStoryConfigManager.c("localUploadVideoDurationLimit", Integer.valueOf(c))).intValue();
    e = ((Integer)localStoryConfigManager.c("localUploadVideoRatioLimit", Integer.valueOf(e))).intValue();
    f = ((Integer)localStoryConfigManager.c("localUploadImageSizeLimit", Integer.valueOf(f))).intValue();
    g = ((Integer)localStoryConfigManager.c("localUploadImageMinResolutionLimit", Integer.valueOf(g))).intValue();
    int m = e;
    i = m / 10000 / 1000.0F;
    j = m % 10000 / 1000.0F;
    SLog.d("Q.qqstory.publish.QQStoryFlowCallback", "Update Limit Config %d|%d|%d|%d|%d|%d", new Object[] { Integer.valueOf(a), Integer.valueOf(b), Integer.valueOf(c), Integer.valueOf(e), Integer.valueOf(f), Integer.valueOf(g) });
    SLog.d("Q.qqstory.publish.QQStoryFlowCallback", "Update Limit Config from %d to %d", new Object[] { Integer.valueOf(h), Integer.valueOf(k) });
    h = localStoryConfigManager.f();
    return true;
  }
  
  private static boolean a(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getIntent() != null)) {
      return paramActivity.getIntent().getBooleanExtra("key_from_pic_choose", false);
    }
    return false;
  }
  
  /* Error */
  public static boolean a(@NonNull Activity paramActivity, @NonNull LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_1
    //   4: ifnonnull +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: new 437	android/media/MediaMetadataRetriever
    //   12: dup
    //   13: invokespecial 438	android/media/MediaMetadataRetriever:<init>	()V
    //   16: astore 7
    //   18: aload 7
    //   20: aload_1
    //   21: getfield 175	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   24: invokevirtual 441	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   27: aload_1
    //   28: aload 7
    //   30: bipush 19
    //   32: invokevirtual 444	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   35: invokestatic 448	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   38: putfield 92	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   41: aload_1
    //   42: aload 7
    //   44: bipush 18
    //   46: invokevirtual 444	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   49: invokestatic 448	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   52: putfield 86	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   55: aload_1
    //   56: aload 7
    //   58: bipush 24
    //   60: invokevirtual 444	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   63: invokestatic 448	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   66: putfield 104	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   69: goto +20 -> 89
    //   72: astore_0
    //   73: goto +966 -> 1039
    //   76: astore 8
    //   78: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +8 -> 89
    //   84: aload 8
    //   86: invokevirtual 451	java/lang/Exception:printStackTrace	()V
    //   89: aload 7
    //   91: invokevirtual 454	android/media/MediaMetadataRetriever:release	()V
    //   94: invokestatic 456	com/tencent/aelight/camera/aioeditor/activity/richmedia/QQStoryFlowCallback:a	()Z
    //   97: pop
    //   98: aload_1
    //   99: getfield 92	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   102: i2f
    //   103: fconst_1
    //   104: fmul
    //   105: aload_1
    //   106: getfield 86	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   109: i2f
    //   110: fdiv
    //   111: fstore_2
    //   112: aload_1
    //   113: getfield 101	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mMimeType	Ljava/lang/String;
    //   116: ldc 166
    //   118: invokevirtual 172	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   121: ifeq +463 -> 584
    //   124: aload_1
    //   125: getfield 95	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   128: getstatic 417	com/tencent/aelight/camera/aioeditor/activity/richmedia/QQStoryFlowCallback:c	I
    //   131: i2l
    //   132: lcmp
    //   133: ifle +63 -> 196
    //   136: aload_0
    //   137: iconst_1
    //   138: ldc_w 458
    //   141: iconst_0
    //   142: invokestatic 464	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   145: astore 7
    //   147: new 67	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   154: astore 8
    //   156: aload 8
    //   158: ldc_w 466
    //   161: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 8
    //   167: aload_1
    //   168: invokevirtual 467	com/tencent/mobileqq/activity/photo/LocalMediaInfo:toString	()Ljava/lang/String;
    //   171: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: ldc 129
    //   177: aload 8
    //   179: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 469	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: iconst_1
    //   186: istore_3
    //   187: iconst_4
    //   188: istore 4
    //   190: iconst_5
    //   191: istore 5
    //   193: goto +641 -> 834
    //   196: aload_1
    //   197: getfield 95	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   200: getstatic 471	com/tencent/aelight/camera/aioeditor/activity/richmedia/QQStoryFlowCallback:d	I
    //   203: i2l
    //   204: lcmp
    //   205: ifge +64 -> 269
    //   208: aload_0
    //   209: iconst_1
    //   210: ldc_w 473
    //   213: iconst_0
    //   214: invokestatic 464	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   217: astore 7
    //   219: new 67	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   226: astore 8
    //   228: aload 8
    //   230: ldc_w 466
    //   233: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 8
    //   239: aload_1
    //   240: invokevirtual 467	com/tencent/mobileqq/activity/photo/LocalMediaInfo:toString	()Ljava/lang/String;
    //   243: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: ldc 129
    //   249: aload 8
    //   251: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 469	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: iconst_1
    //   258: istore_3
    //   259: iconst_5
    //   260: istore 4
    //   262: bipush 6
    //   264: istore 5
    //   266: goto +568 -> 834
    //   269: aload_1
    //   270: getfield 74	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   273: getstatic 397	com/tencent/aelight/camera/aioeditor/activity/richmedia/QQStoryFlowCallback:a	I
    //   276: i2l
    //   277: lcmp
    //   278: ifle +60 -> 338
    //   281: aload_0
    //   282: iconst_1
    //   283: ldc_w 474
    //   286: invokestatic 477	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   289: iconst_0
    //   290: invokestatic 464	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   293: astore 7
    //   295: new 67	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   302: astore 8
    //   304: aload 8
    //   306: ldc_w 466
    //   309: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 8
    //   315: aload_1
    //   316: invokevirtual 467	com/tencent/mobileqq/activity/photo/LocalMediaInfo:toString	()Ljava/lang/String;
    //   319: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: ldc 129
    //   325: aload 8
    //   327: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 469	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: iconst_1
    //   334: istore_3
    //   335: goto +315 -> 650
    //   338: aload_1
    //   339: getfield 92	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   342: aload_1
    //   343: getfield 86	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   346: invokestatic 483	java/lang/Math:min	(II)I
    //   349: getstatic 413	com/tencent/aelight/camera/aioeditor/activity/richmedia/QQStoryFlowCallback:b	I
    //   352: if_icmpge +60 -> 412
    //   355: aload_0
    //   356: iconst_1
    //   357: ldc_w 484
    //   360: invokestatic 477	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   363: iconst_0
    //   364: invokestatic 464	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   367: astore 7
    //   369: new 67	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   376: astore 8
    //   378: aload 8
    //   380: ldc_w 466
    //   383: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload 8
    //   389: aload_1
    //   390: invokevirtual 467	com/tencent/mobileqq/activity/photo/LocalMediaInfo:toString	()Ljava/lang/String;
    //   393: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: ldc 129
    //   399: aload 8
    //   401: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 469	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: iconst_1
    //   408: istore_3
    //   409: goto +321 -> 730
    //   412: fload_2
    //   413: ldc_w 485
    //   416: fcmpg
    //   417: iflt +110 -> 527
    //   420: fload_2
    //   421: ldc_w 486
    //   424: fcmpl
    //   425: ifle +6 -> 431
    //   428: goto +99 -> 527
    //   431: aload_1
    //   432: getfield 175	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   435: invokestatic 491	com/tencent/component/media/MediaFile:getMimeTypeForFile	(Ljava/lang/String;)Ljava/lang/String;
    //   438: ifnull +84 -> 522
    //   441: aload_1
    //   442: getfield 175	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   445: invokestatic 491	com/tencent/component/media/MediaFile:getMimeTypeForFile	(Ljava/lang/String;)Ljava/lang/String;
    //   448: ldc_w 493
    //   451: invokevirtual 172	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   454: ifne +68 -> 522
    //   457: aload_0
    //   458: iconst_1
    //   459: ldc_w 494
    //   462: invokestatic 477	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   465: iconst_0
    //   466: invokestatic 464	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   469: astore 7
    //   471: new 67	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   478: astore 8
    //   480: aload 8
    //   482: ldc_w 466
    //   485: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload 8
    //   491: aload_1
    //   492: invokevirtual 467	com/tencent/mobileqq/activity/photo/LocalMediaInfo:toString	()Ljava/lang/String;
    //   495: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: pop
    //   499: ldc 129
    //   501: aload 8
    //   503: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 469	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: iconst_1
    //   510: istore_3
    //   511: bipush 6
    //   513: istore 4
    //   515: bipush 8
    //   517: istore 5
    //   519: goto +315 -> 834
    //   522: iconst_1
    //   523: istore_3
    //   524: goto +236 -> 760
    //   527: aload_0
    //   528: iconst_1
    //   529: ldc_w 495
    //   532: invokestatic 477	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   535: iconst_0
    //   536: invokestatic 464	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   539: astore 7
    //   541: new 67	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   548: astore 8
    //   550: aload 8
    //   552: ldc_w 466
    //   555: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload 8
    //   561: aload_1
    //   562: invokevirtual 467	com/tencent/mobileqq/activity/photo/LocalMediaInfo:toString	()Ljava/lang/String;
    //   565: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: ldc 129
    //   571: aload 8
    //   573: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 469	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: iconst_1
    //   580: istore_3
    //   581: goto +247 -> 828
    //   584: aload_1
    //   585: getfield 74	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   588: getstatic 423	com/tencent/aelight/camera/aioeditor/activity/richmedia/QQStoryFlowCallback:f	I
    //   591: i2l
    //   592: lcmp
    //   593: ifle +66 -> 659
    //   596: aload_0
    //   597: iconst_1
    //   598: ldc_w 496
    //   601: invokestatic 477	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   604: iconst_0
    //   605: invokestatic 464	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   608: astore 7
    //   610: new 67	java/lang/StringBuilder
    //   613: dup
    //   614: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   617: astore 8
    //   619: aload 8
    //   621: ldc_w 466
    //   624: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload 8
    //   630: aload_1
    //   631: invokevirtual 467	com/tencent/mobileqq/activity/photo/LocalMediaInfo:toString	()Ljava/lang/String;
    //   634: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: ldc 129
    //   640: aload 8
    //   642: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: invokestatic 469	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   648: iconst_0
    //   649: istore_3
    //   650: iconst_1
    //   651: istore 4
    //   653: iconst_1
    //   654: istore 5
    //   656: goto +178 -> 834
    //   659: aload_1
    //   660: getfield 92	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   663: aload_1
    //   664: getfield 86	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   667: invokestatic 483	java/lang/Math:min	(II)I
    //   670: getstatic 427	com/tencent/aelight/camera/aioeditor/activity/richmedia/QQStoryFlowCallback:g	I
    //   673: if_icmpge +66 -> 739
    //   676: aload_0
    //   677: iconst_1
    //   678: ldc_w 497
    //   681: invokestatic 477	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   684: iconst_0
    //   685: invokestatic 464	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   688: astore 7
    //   690: new 67	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   697: astore 8
    //   699: aload 8
    //   701: ldc_w 466
    //   704: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: pop
    //   708: aload 8
    //   710: aload_1
    //   711: invokevirtual 467	com/tencent/mobileqq/activity/photo/LocalMediaInfo:toString	()Ljava/lang/String;
    //   714: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: ldc 129
    //   720: aload 8
    //   722: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: invokestatic 469	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   728: iconst_0
    //   729: istore_3
    //   730: iconst_2
    //   731: istore 4
    //   733: iconst_3
    //   734: istore 5
    //   736: goto +98 -> 834
    //   739: fload_2
    //   740: ldc_w 485
    //   743: fcmpg
    //   744: iflt +30 -> 774
    //   747: fload_2
    //   748: ldc_w 486
    //   751: fcmpl
    //   752: ifle +6 -> 758
    //   755: goto +19 -> 774
    //   758: iconst_0
    //   759: istore_3
    //   760: aconst_null
    //   761: astore 7
    //   763: iconst_0
    //   764: istore 4
    //   766: sipush 9999
    //   769: istore 5
    //   771: goto +63 -> 834
    //   774: aload_0
    //   775: iconst_1
    //   776: ldc_w 498
    //   779: invokestatic 477	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   782: iconst_0
    //   783: invokestatic 464	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;ILjava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   786: astore 7
    //   788: new 67	java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   795: astore 8
    //   797: aload 8
    //   799: ldc_w 466
    //   802: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: pop
    //   806: aload 8
    //   808: aload_1
    //   809: invokevirtual 467	com/tencent/mobileqq/activity/photo/LocalMediaInfo:toString	()Ljava/lang/String;
    //   812: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: ldc 129
    //   818: aload 8
    //   820: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   823: invokestatic 469	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   826: iconst_0
    //   827: istore_3
    //   828: iconst_3
    //   829: istore 4
    //   831: iconst_4
    //   832: istore 5
    //   834: ldc_w 500
    //   837: ldc_w 502
    //   840: iconst_0
    //   841: iload 4
    //   843: iconst_1
    //   844: anewarray 168	java/lang/String
    //   847: dup
    //   848: iconst_0
    //   849: aload_1
    //   850: invokestatic 504	com/tencent/aelight/camera/aioeditor/activity/richmedia/QQStoryFlowCallback:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Ljava/lang/String;
    //   853: aastore
    //   854: invokestatic 509	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   857: iload_3
    //   858: ifeq +12 -> 870
    //   861: iconst_1
    //   862: invokestatic 511	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   865: astore 8
    //   867: goto +9 -> 876
    //   870: iconst_0
    //   871: invokestatic 511	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   874: astore 8
    //   876: ldc_w 513
    //   879: ldc_w 515
    //   882: iconst_0
    //   883: iconst_0
    //   884: iconst_3
    //   885: anewarray 168	java/lang/String
    //   888: dup
    //   889: iconst_0
    //   890: aload 8
    //   892: aastore
    //   893: dup
    //   894: iconst_1
    //   895: iload 5
    //   897: invokestatic 511	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   900: aastore
    //   901: dup
    //   902: iconst_2
    //   903: fload_2
    //   904: invokestatic 518	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   907: aastore
    //   908: invokestatic 520	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   911: iload_3
    //   912: ifeq +29 -> 941
    //   915: aload_1
    //   916: getfield 95	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   919: ldc2_w 521
    //   922: lcmp
    //   923: iflt +18 -> 941
    //   926: ldc_w 513
    //   929: ldc_w 524
    //   932: iconst_0
    //   933: iconst_0
    //   934: iconst_0
    //   935: anewarray 168	java/lang/String
    //   938: invokestatic 520	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   941: aload_1
    //   942: getfield 527	com/tencent/mobileqq/activity/photo/LocalMediaInfo:addedDate	J
    //   945: lconst_0
    //   946: lcmp
    //   947: ifne +63 -> 1010
    //   950: aload_1
    //   951: new 529	java/io/File
    //   954: dup
    //   955: aload_1
    //   956: getfield 175	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   959: invokespecial 530	java/io/File:<init>	(Ljava/lang/String;)V
    //   962: invokevirtual 533	java/io/File:lastModified	()J
    //   965: ldc2_w 534
    //   968: ldiv
    //   969: putfield 527	com/tencent/mobileqq/activity/photo/LocalMediaInfo:addedDate	J
    //   972: aload_1
    //   973: getfield 527	com/tencent/mobileqq/activity/photo/LocalMediaInfo:addedDate	J
    //   976: lconst_0
    //   977: lcmp
    //   978: ifeq +8 -> 986
    //   981: iconst_0
    //   982: istore_3
    //   983: goto +5 -> 988
    //   986: iconst_1
    //   987: istore_3
    //   988: ldc_w 500
    //   991: ldc_w 537
    //   994: iconst_0
    //   995: iload_3
    //   996: iconst_1
    //   997: anewarray 168	java/lang/String
    //   1000: dup
    //   1001: iconst_0
    //   1002: aload_1
    //   1003: invokestatic 504	com/tencent/aelight/camera/aioeditor/activity/richmedia/QQStoryFlowCallback:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Ljava/lang/String;
    //   1006: aastore
    //   1007: invokestatic 509	com/tencent/biz/qqstory/support/report/StoryReportor:b	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   1010: aload 7
    //   1012: ifnull +16 -> 1028
    //   1015: aload_0
    //   1016: new 539	com/tencent/aelight/camera/aioeditor/activity/richmedia/QQStoryFlowCallback$1
    //   1019: dup
    //   1020: aload 7
    //   1022: invokespecial 542	com/tencent/aelight/camera/aioeditor/activity/richmedia/QQStoryFlowCallback$1:<init>	(Lcom/tencent/mobileqq/widget/QQToast;)V
    //   1025: invokevirtual 546	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   1028: iload 4
    //   1030: ifne +6 -> 1036
    //   1033: iconst_1
    //   1034: istore 6
    //   1036: iload 6
    //   1038: ireturn
    //   1039: aload 7
    //   1041: invokevirtual 454	android/media/MediaMetadataRetriever:release	()V
    //   1044: aload_0
    //   1045: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1046	0	paramActivity	Activity
    //   0	1046	1	paramLocalMediaInfo	LocalMediaInfo
    //   111	793	2	f1	float
    //   186	810	3	k	int
    //   188	841	4	m	int
    //   191	705	5	n	int
    //   1	1036	6	bool	boolean
    //   16	1024	7	localObject1	Object
    //   76	9	8	localException	Exception
    //   154	737	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	69	72	finally
    //   78	89	72	finally
    //   18	69	76	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QQStoryFlowCallback
 * JD-Core Version:    0.7.0.1
 */