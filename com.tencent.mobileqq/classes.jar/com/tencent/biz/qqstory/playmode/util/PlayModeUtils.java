package com.tencent.biz.qqstory.playmode.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.boundaries.StoryDepends.QimUtil;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TroopNickNameManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchGetVideoFullInfoList;
import com.tencent.biz.qqstory.network.request.GetVideoFullInfoListRequest;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryProfileUtils;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandUnit;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.ExecuteFhlipResponseCallback;
import com.tencent.biz.qqstory.utils.mediaCodec.VideoMergeHelper;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo;
import com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Dispatchers;
import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import nmu;
import nmv;
import nmw;
import nmx;
import nmy;
import nmz;
import nna;
import nnb;

public class PlayModeUtils
{
  private static SparseArray a;
  public static final String a;
  public static final int[] a;
  public static final String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.report_comment");
    b = StoryApi.a(2131432087);
    jdField_a_of_type_ArrayOfInt = new int[] { 90 };
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt == 76) || (paramInt == 77)) {
      return 221;
    }
    return 220;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      switch (paramInt1)
      {
      default: 
        return 0;
      case 10: 
        return 74;
      case 11: 
        return 76;
      case 23: 
      case 210: 
        return 75;
      }
      return 77;
    }
    return paramInt2;
  }
  
  public static int a(StoryVideoItem paramStoryVideoItem, int paramInt, String paramString)
  {
    Object localObject2 = FFmpegUtils.a(a(), paramStoryVideoItem.mVid, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      QLog.i("Q.qqstory.player.PlayModeUtils", 1, "get download water mark failed, logoMarkPath is null!");
    }
    Object localObject3 = FFmpegUtils.b(paramStoryVideoItem);
    Object localObject1 = FFmpegUtils.a(paramStoryVideoItem);
    String str = FFmpegUtils.a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    while ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      str = QQStoryConstant.q;
      str = str + paramStoryVideoItem.mVid + System.currentTimeMillis() + "_max.png";
      if (!FFmpegUtils.a((String)localObject3, (String)localObject1, str))
      {
        QLog.e("Q.qqstory.player.PlayModeUtils", 2, "combineTwoImg maxMask videoVote failed");
        return -997;
        localObject1 = str;
      }
      else
      {
        localObject1 = str;
      }
    }
    while ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      localObject3 = localObject2;
      if (FFmpegUtils.a((String)localObject1, (String)localObject2, (String)localObject2)) {
        break label236;
      }
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, "watermarkVideoByMediaCodec() combineTwoImg failed");
      return -997;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = localObject3;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    label236:
    long l;
    for (;;)
    {
      localObject3 = localObject1;
      localObject1 = new PublishVideoEntry();
      ((PublishVideoEntry)localObject1).doodlePath = ((String)localObject3);
      ((PublishVideoEntry)localObject1).isPicture = false;
      ((PublishVideoEntry)localObject1).mLocalRawVideoDir = paramStoryVideoItem.mLocalVideoPath;
      ((PublishVideoEntry)localObject1).businessId = 1;
      l = SystemClock.elapsedRealtime();
      localObject1 = new MergeEditVideo.EditParam(2000000, (PublishVideoEntry)localObject1);
      ((MergeEditVideo.EditParam)localObject1).b(0);
      localObject2 = new MergeEditVideo();
      localObject3 = QQStoryConstant.i + paramStoryVideoItem.mVid + ".mp4";
      paramInt = ((MergeEditVideo)localObject2).a(paramStoryVideoItem.mLocalVideoPath, (String)localObject3, (MergeEditVideo.EditParam)localObject1);
      if (paramInt == 0) {
        break label481;
      }
      if (paramInt == -1) {
        break;
      }
      SLog.b("Q.qqstory.player.PlayModeUtils", new Throwable("MergeVideoError"), "watermarkVideoByMediaCodec() error after mergeVideo() return, errorCode=%d", new Object[] { Integer.valueOf(paramInt) });
      return paramInt;
      localObject1 = localObject2;
    }
    FileUtils.c(paramStoryVideoItem.mLocalVideoPath, paramString);
    label481:
    for (paramInt = 0;; paramInt = VideoMergeHelper.a((String)localObject3, paramStoryVideoItem.mLocalVideoPath, paramString, 0))
    {
      if (paramInt == 0) {
        FileUtils.a(BaseApplication.getContext(), new File(paramString));
      }
      paramStoryVideoItem = new File((String)localObject3);
      if (paramStoryVideoItem.exists()) {
        paramStoryVideoItem.delete();
      }
      QLog.i("Q.qqstory.player.PlayModeUtils", 1, "hardware watermar cost:" + (SystemClock.elapsedRealtime() - l) / 1000.0D);
      return paramInt;
    }
  }
  
  public static Context a()
  {
    return BaseApplicationImpl.getApplication().getApplicationContext();
  }
  
  public static StoryVideoItem a()
  {
    return a("");
  }
  
  public static StoryVideoItem a(String paramString)
  {
    StoryVideoItem localStoryVideoItem = new StoryVideoItem();
    localStoryVideoItem.id = -1000L;
    localStoryVideoItem.mIsPlaying = 0;
    localStoryVideoItem.mVid = ("fake_vid_loadingData" + paramString);
    return localStoryVideoItem;
  }
  
  @NonNull
  public static PlayModeUtils.DebugInfo a(int paramInt)
  {
    PlayModeUtils.DebugInfo localDebugInfo2 = (PlayModeUtils.DebugInfo)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    PlayModeUtils.DebugInfo localDebugInfo1 = localDebugInfo2;
    if (localDebugInfo2 == null)
    {
      localDebugInfo1 = new PlayModeUtils.DebugInfo();
      jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localDebugInfo1);
    }
    return localDebugInfo1;
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new InvalidParameterException("can't get AppInterface");
  }
  
  public static String a(QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem == null) || (!paramQQUserUIItem.isAvailable())) {
      return b;
    }
    if ((paramQQUserUIItem.isVip) && (!paramQQUserUIItem.isFriend())) {
      return paramQQUserUIItem.nickName;
    }
    return paramQQUserUIItem.getDisplayName();
  }
  
  public static String a(StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (paramStoryVideoItem.mVideoSource == 1)
    {
      if (paramStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L) {
        return StoryListUtils.a(paramStoryVideoItem.mCreateTime, paramStoryVideoItem.mTimeZoneOffsetMillis, true) + " • 历史" + "日迹";
      }
      return StoryListUtils.a(paramStoryVideoItem.mCreateTime) + " • 历史" + "日迹";
    }
    if (paramStoryVideoItem.mLocalCreateTime <= 0L)
    {
      if (paramStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L) {
        return StoryListUtils.a(paramStoryVideoItem.mCreateTime, paramStoryVideoItem.mTimeZoneOffsetMillis, true);
      }
      return StoryListUtils.a(paramStoryVideoItem.mCreateTime);
    }
    if (paramStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L) {}
    for (paramStoryVideoItem = StoryListUtils.a(paramStoryVideoItem.mLocalCreateTime, paramStoryVideoItem.mTimeZoneOffsetMillis, true);; paramStoryVideoItem = StoryListUtils.a(paramStoryVideoItem.mLocalCreateTime)) {
      return paramStoryVideoItem + " • 手机相册";
    }
  }
  
  /* Error */
  @TargetApi(14)
  public static String a(StoryVideoItem paramStoryVideoItem, String paramString, VideoListFeedItem paramVideoListFeedItem)
  {
    // Byte code:
    //   0: new 95	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: new 335	android/media/MediaMetadataRetriever
    //   12: dup
    //   13: invokespecial 336	android/media/MediaMetadataRetriever:<init>	()V
    //   16: astore_3
    //   17: aload_3
    //   18: aload_1
    //   19: invokevirtual 339	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   22: aload_3
    //   23: bipush 9
    //   25: invokevirtual 342	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   28: astore 6
    //   30: aload_3
    //   31: bipush 20
    //   33: invokevirtual 342	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   36: astore 4
    //   38: aload_3
    //   39: bipush 19
    //   41: invokevirtual 342	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   44: astore 7
    //   46: aload_3
    //   47: bipush 18
    //   49: invokevirtual 342	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   52: astore 8
    //   54: aload_3
    //   55: bipush 25
    //   57: invokevirtual 342	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   60: astore 9
    //   62: aload_3
    //   63: invokevirtual 345	android/media/MediaMetadataRetriever:release	()V
    //   66: aload 4
    //   68: invokestatic 351	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   71: invokestatic 354	com/tencent/mobileqq/filemanager/util/FileUtil:a	(J)Ljava/lang/String;
    //   74: astore_3
    //   75: new 202	java/io/File
    //   78: dup
    //   79: aload_1
    //   80: invokespecial 203	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: astore_1
    //   84: aload 5
    //   86: new 95	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 356
    //   96: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_1
    //   100: invokevirtual 359	java/io/File:length	()J
    //   103: invokestatic 354	com/tencent/mobileqq/filemanager/util/FileUtil:a	(J)Ljava/lang/String;
    //   106: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 361
    //   112: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 7
    //   117: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc_w 363
    //   123: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 8
    //   128: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 365
    //   134: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_3
    //   138: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc_w 367
    //   144: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_0
    //   148: getfield 370	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVideoDuration	J
    //   151: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   154: ldc_w 372
    //   157: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 6
    //   162: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 374
    //   168: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload 9
    //   173: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: invokestatic 379	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   186: pop
    //   187: invokestatic 381	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   190: sipush 180
    //   193: invokevirtual 385	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   196: checkcast 387	com/tencent/biz/qqstory/base/QQStoryManager
    //   199: astore_1
    //   200: aload_1
    //   201: ifnull +42 -> 243
    //   204: new 95	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 389
    //   214: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: astore_3
    //   218: aload_1
    //   219: getfield 392	com/tencent/biz/qqstory/base/QQStoryManager:k	Z
    //   222: ifeq +192 -> 414
    //   225: ldc_w 394
    //   228: astore_1
    //   229: aload 5
    //   231: aload_3
    //   232: aload_1
    //   233: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: new 95	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 396
    //   253: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: astore_3
    //   257: invokestatic 397	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   260: invokestatic 402	com/tencent/biz/qqstory/playvideo/player/VideoViewFactory:a	(Landroid/content/Context;)Lcom/tencent/biz/qqstory/playvideo/player/VideoViewFactory;
    //   263: invokevirtual 404	com/tencent/biz/qqstory/playvideo/player/VideoViewFactory:a	()Z
    //   266: ifeq +155 -> 421
    //   269: ldc_w 406
    //   272: astore_1
    //   273: aload 5
    //   275: aload_3
    //   276: aload_1
    //   277: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_2
    //   288: ifnull +32 -> 320
    //   291: aload 5
    //   293: new 95	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 408
    //   303: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_2
    //   307: getfield 413	com/tencent/biz/qqstory/storyHome/model/VideoListFeedItem:feedId	Ljava/lang/String;
    //   310: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: bipush 28
    //   322: invokestatic 418	com/tencent/biz/qqstory/model/SuperManager:a	(I)Lcom/tencent/biz/qqstory/model/IManager;
    //   325: checkcast 420	com/tencent/biz/qqstory/base/download/DownloadUrlManager
    //   328: astore_1
    //   329: aload 5
    //   331: ldc_w 422
    //   334: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 5
    //   340: aload_1
    //   341: aload_0
    //   342: getfield 48	com/tencent/biz/qqstory/model/item/StoryVideoItem:mVid	Ljava/lang/String;
    //   345: iconst_0
    //   346: invokevirtual 425	com/tencent/biz/qqstory/base/download/DownloadUrlManager:a	(Ljava/lang/String;I)Lcom/tencent/biz/qqstory/base/download/DownloadUrlManager$DumpInfo;
    //   349: invokevirtual 428	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 5
    //   355: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: areturn
    //   359: astore_0
    //   360: aload_3
    //   361: invokevirtual 345	android/media/MediaMetadataRetriever:release	()V
    //   364: ldc 237
    //   366: areturn
    //   367: astore 10
    //   369: aload 4
    //   371: astore_3
    //   372: invokestatic 431	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq -300 -> 75
    //   378: ldc 68
    //   380: iconst_2
    //   381: new 95	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   388: ldc_w 433
    //   391: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload 10
    //   396: invokevirtual 436	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   399: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 439	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: aload 4
    //   410: astore_3
    //   411: goto -336 -> 75
    //   414: ldc_w 441
    //   417: astore_1
    //   418: goto -189 -> 229
    //   421: ldc_w 443
    //   424: astore_1
    //   425: goto -152 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	paramStoryVideoItem	StoryVideoItem
    //   0	428	1	paramString	String
    //   0	428	2	paramVideoListFeedItem	VideoListFeedItem
    //   16	395	3	localObject	Object
    //   36	373	4	str1	String
    //   7	347	5	localStringBuilder	StringBuilder
    //   28	133	6	str2	String
    //   44	72	7	str3	String
    //   52	75	8	str4	String
    //   60	112	9	str5	String
    //   367	28	10	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   17	22	359	java/lang/Exception
    //   66	75	367	java/lang/NumberFormatException
  }
  
  public static String a(VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < paramVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramVideoPlayerPagerAdapter = (StoryVideoItem)paramVideoPlayerPagerAdapter.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (!paramVideoPlayerPagerAdapter.isUploadFail()) {
          break label56;
        }
        localObject1 = "3";
      }
    }
    for (;;)
    {
      paramVideoPlayerPagerAdapter = (VideoPlayerPagerAdapter)localObject1;
      if (localObject1 == null) {
        paramVideoPlayerPagerAdapter = "2";
      }
      return paramVideoPlayerPagerAdapter;
      label56:
      if (paramVideoPlayerPagerAdapter.isUploading()) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
    }
  }
  
  public static String a(String paramString)
  {
    paramString = ((UserManager)SuperManager.a(2)).b(paramString);
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.player.PlayModeUtils", 2, "getNickName, userItem is null");
      }
      return b;
    }
    return a(paramString);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    if (paramString1.contains("?")) {
      return paramString1 + "&" + paramString2 + "=" + paramString3;
    }
    return paramString1 + "?" + paramString2 + "=" + paramString3;
  }
  
  public static final String a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(ShortVideoUtils.c());
    if (paramBoolean) {}
    for (String str = ".png";; str = ".mp4") {
      return FFmpegUtils.a(paramString, str);
    }
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public static void a(Activity paramActivity, CommentEntry paramCommentEntry)
  {
    if (paramActivity.isFinishing()) {}
    do
    {
      do
      {
        return;
        if (NetworkUtil.d(BaseApplicationImpl.getContext())) {
          break;
        }
        QQToast.a(BaseApplicationImpl.getContext(), 1, "网络异常，请稍后重试", 0).a();
        StoryReportor.b("story_net", jdField_a_of_type_JavaLangString, 0, 99980, new String[] { "", "0", StoryReportor.a(BaseApplication.getContext()) });
      } while (!QLog.isColorLevel());
      QLog.w("Q.qqstory.player.PlayModeUtils", 2, "reportVideoCommemt - isNetSupport is false----");
      return;
      paramActivity = (ActionSheet)ActionSheetHelper.b(paramActivity, null);
      paramActivity.a("欺诈骗钱", 5);
      paramActivity.a("色情暴力", 5);
      paramActivity.a("广告骚扰", 5);
      paramActivity.a("其他", 5);
      paramActivity.c(2131433015);
      paramActivity.a(new nna(paramCommentEntry, paramActivity));
    } while (paramActivity.isShowing());
    paramActivity.show();
  }
  
  public static void a(Context paramContext, QQUserUIItem paramQQUserUIItem, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (!NetworkUtil.d(BaseApplicationImpl.getContext())) {
      QQToast.a(BaseApplicationImpl.getContext(), 1, "网络异常，请稍后重试", 0).a();
    }
    do
    {
      return;
      paramContext = (ActionSheet)ActionSheetHelper.b(paramContext, null);
      paramContext.a("欺诈骗钱", 5);
      paramContext.a("色情暴力", 5);
      paramContext.a("广告骚扰", 5);
      paramContext.a("其他", 5);
      paramContext.c(2131433015);
      paramContext.a(new nmz(paramQQUserUIItem, paramContext));
      paramContext.setOnDismissListener(paramOnDismissListener);
    } while (paramContext.isShowing());
    paramContext.show();
  }
  
  public static void a(Context paramContext, StoryVideoItem paramStoryVideoItem, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (!NetworkUtil.d(BaseApplicationImpl.getContext())) {
      QQToast.a(BaseApplicationImpl.getContext(), 1, "网络异常，请稍后重试", 0).a();
    }
    do
    {
      return;
      paramContext = (ActionSheet)ActionSheetHelper.b(paramContext, null);
      paramContext.a("欺诈骗钱", 5);
      paramContext.a("色情暴力", 5);
      paramContext.a("广告骚扰", 5);
      paramContext.a("其他", 5);
      paramContext.c(2131433015);
      paramContext.a(new nnb(paramStoryVideoItem, paramContext));
      paramContext.setOnDismissListener(paramOnDismissListener);
    } while (paramContext.isShowing());
    paramContext.show();
  }
  
  public static void a(Context paramContext, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem)
  {
    paramVideoViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    paramVideoViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramVideoViewHolder.c.setVisibility(8);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramVideoViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
  }
  
  public static void a(Context paramContext, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    Object localObject = ((UserManager)SuperManager.a(2)).b(paramStoryVideoItem.mOwnerUid);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.player.PlayModeUtils", 2, "fillFriendsData, userItem is null");
      }
      return;
    }
    paramStoryVideoItem.mIsPlaying = 0;
    String str = a((QQUserUIItem)localObject);
    TextView localTextView = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131369188);
    localTextView.setText(str);
    a((ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372137), ((QQUserUIItem)localObject).headUrl, true, (int)DisplayUtils.a(paramContext, 35.0F));
    localObject = ((QQUserUIItem)localObject).getUserIconUrl();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      a(paramContext.getResources(), localTextView, (String)localObject, 13.0F, 2.0F);
    }
    ((TextView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131369119)).setText(a(paramStoryVideoItem, paramInt));
    a(paramVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView, paramStoryVideoItem.mLocalMaskPath, paramStoryVideoItem.getDownloadMaskUrl(), paramVideoViewHolder.jdField_b_of_type_Boolean);
  }
  
  public static void a(Context paramContext, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.player.PlayModeUtils", 2, "fillFeedFriendsData, storyVideoItem:" + paramStoryVideoItem.toString());
    }
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(paramStoryVideoItem.mOwnerUid);
    if (localQQUserUIItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.player.PlayModeUtils", 2, "fillFeedFriendsData, userItem is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.player.PlayModeUtils", 2, "fillFeedFriendsData, userItem:" + localQQUserUIItem.toString());
    }
    paramStoryVideoItem.mIsPlaying = 0;
    TextView localTextView = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131369188);
    ImageView localImageView = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372137);
    paramContext = paramContext.getResources();
    boolean bool;
    int i;
    if (paramStoryVideoItem.mStoryType == 2)
    {
      bool = true;
      a(paramContext, localQQUserUIItem, localImageView, 35.0F, localTextView, 13.0F, 2.0F, bool, paramString);
      ((StoryQIMBadgeView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131371682)).a(localQQUserUIItem);
      paramContext = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372142);
      if (!localQQUserUIItem.isVipButNoFriend()) {
        break label432;
      }
      i = 0;
      label222:
      paramContext.setVisibility(i);
      if (localQQUserUIItem.isVipButNoFriend()) {
        StoryReportor.a("weishi_share", "tag_exp", 0, 0, new String[] { "4", localQQUserUIItem.getUnionId(), "weishi", paramStoryVideoItem.mVid });
      }
      paramContext = (View)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131371695);
      paramString = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372140);
      localTextView = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372139);
      if (paramStoryVideoItem.mStoryType != 1) {
        break label528;
      }
      if (((!b(localQQUserUIItem.qq)) && (localQQUserUIItem.isFriend())) && (!a(paramStoryVideoItem))) {
        break label503;
      }
      paramString.setVisibility(0);
      localTextView.setVisibility(0);
      if (paramStoryVideoItem.mBanType != 0) {
        break label449;
      }
      if (!localQQUserUIItem.isVip) {
        break label439;
      }
      paramString.setImageResource(2130843805);
      label388:
      if (!StoryProfileUtils.a(localQQUserUIItem)) {
        break label519;
      }
      paramContext.setVisibility(0);
    }
    for (;;)
    {
      ((TextView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131369119)).setText(a(paramStoryVideoItem, paramStoryVideoItem.mStoryType));
      return;
      bool = false;
      break;
      label432:
      i = 8;
      break label222;
      label439:
      paramString.setImageResource(2130843799);
      break label388;
      label449:
      if (paramStoryVideoItem.mBanType == 1)
      {
        paramString.setImageResource(2130843802);
        break label388;
      }
      if ((paramStoryVideoItem.mBanType == 2) || (paramStoryVideoItem.mBanType == 3))
      {
        paramString.setImageResource(2130843807);
        break label388;
      }
      paramString.setImageResource(2130843805);
      break label388;
      label503:
      paramString.setVisibility(8);
      localTextView.setVisibility(8);
      break label388;
      label519:
      paramContext.setVisibility(8);
      continue;
      label528:
      paramString.setVisibility(8);
      paramContext.setVisibility(8);
      localTextView.setVisibility(8);
    }
  }
  
  public static void a(Context paramContext, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem)
  {
    a(paramContext, paramVideoViewHolder, paramVideoListFeedItem, paramStoryVideoItem, false);
  }
  
  public static void a(Context paramContext, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, boolean paramBoolean)
  {
    Object localObject = (ImageView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372105);
    TextView localTextView = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372106);
    paramContext = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372124);
    paramVideoViewHolder = (ElasticImageView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131364579);
    if (paramVideoListFeedItem == null)
    {
      if ((localObject != null) && (localTextView != null))
      {
        if ((!paramBoolean) || ((paramStoryVideoItem.mHasLike != -1) && (paramStoryVideoItem.mHasLike != 0))) {
          break label148;
        }
        ((ImageView)localObject).setImageResource(2130843513);
        localTextView.setText("取消");
      }
      for (paramStoryVideoItem.mHasLike = 1;; paramStoryVideoItem.mHasLike = 0)
      {
        if ((paramContext != null) && (paramVideoViewHolder != null))
        {
          paramContext.setVisibility(8);
          paramVideoViewHolder.setVisibility(4);
        }
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.player.PlayModeUtils", 2, "fillFeedInteractionData, commentLikeFeedItem is null");
        }
        return;
        label148:
        ((ImageView)localObject).setImageResource(2130843782);
        localTextView.setText("赞");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.player.PlayModeUtils", 2, new Object[] { "fillFeedInteractionData, feedId=", paramVideoListFeedItem.feedId, ", likeCount=", Integer.valueOf(paramVideoListFeedItem.mLikeCount), ", commentCount=", Integer.valueOf(paramVideoListFeedItem.mCommentCount) });
    }
    label268:
    int i;
    if ((localObject != null) && (localTextView != null))
    {
      if (paramVideoListFeedItem.mHadLike == 1)
      {
        ((ImageView)localObject).setImageResource(2130843513);
        localTextView.setText("取消");
      }
    }
    else
    {
      if ((paramContext == null) || (paramVideoViewHolder == null)) {
        break label549;
      }
      paramContext.setClickable(true);
      paramVideoViewHolder.setClickable(true);
      paramBoolean = a(paramStoryVideoItem.mOwnerUid);
      boolean bool = ((UserManager)SuperManager.a(2)).b(paramStoryVideoItem.mOwnerUid);
      localObject = new StringBuilder();
      if (paramVideoListFeedItem.mLikeCount > 0) {
        ((StringBuilder)localObject).append("赞").append(UIUtils.a(paramVideoListFeedItem.mLikeCount));
      }
      if (paramVideoListFeedItem.mCommentCount > 0)
      {
        if (paramVideoListFeedItem.mLikeCount > 0) {
          ((StringBuilder)localObject).append(" • ");
        }
        ((StringBuilder)localObject).append("评论").append(UIUtils.a(paramVideoListFeedItem.mCommentCount));
      }
      if (((paramStoryVideoItem.mStoryType != 1) || (paramBoolean) || (!bool)) && (paramVideoListFeedItem.mViewTotalTime > 0L))
      {
        if ((paramVideoListFeedItem.mLikeCount > 0) || (paramVideoListFeedItem.mCommentCount > 0)) {
          ((StringBuilder)localObject).append(" • ");
        }
        ((StringBuilder)localObject).append("浏览").append(UIUtils.a(paramVideoListFeedItem.mViewTotalTime));
      }
      if (((StringBuilder)localObject).length() <= 0) {
        break label565;
      }
      paramContext.setVisibility(0);
      if ((paramStoryVideoItem.mStoryType != 1) || (paramBoolean) || (paramVideoListFeedItem.mLikeCount != 0) || (paramVideoListFeedItem.mCommentCount != 0)) {
        break label551;
      }
      i = 1;
      label502:
      if (i == 0) {
        break label557;
      }
      paramContext.setClickable(false);
      paramVideoViewHolder.setClickable(false);
      paramVideoViewHolder.setVisibility(4);
    }
    for (;;)
    {
      paramContext.setText(((StringBuilder)localObject).toString());
      return;
      ((ImageView)localObject).setImageResource(2130843782);
      localTextView.setText("赞");
      break label268;
      label549:
      break;
      label551:
      i = 0;
      break label502;
      label557:
      paramVideoViewHolder.setVisibility(0);
      continue;
      label565:
      paramContext.setVisibility(8);
      paramVideoViewHolder.setVisibility(4);
    }
  }
  
  public static void a(Resources paramResources, TextView paramTextView, String paramString, float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    if ((paramResources == null) || (paramTextView == null) || (!HttpUtil.a(paramString))) {
      if (QLog.isColorLevel())
      {
        paramResources = new StringBuilder().append("setAuthIcon fail：textView is null ? ");
        if (paramTextView == null) {
          bool = true;
        }
        QLog.w("Q.qqstory.player.PlayModeUtils", 2, bool + ", url = " + paramString);
      }
    }
    do
    {
      return;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int i = AIOUtils.a(paramFloat1, paramResources);
        Drawable localDrawable = URLDrawableHelper.a;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mRequestHeight = i;
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mMemoryCacheKeySuffix = "StoryPlayModeAuthIcon";
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if (paramString.getStatus() == 2) {
          paramString.restartDownload();
        }
        paramString.setBounds(0, 0, i, i);
        paramTextView.setCompoundDrawablePadding(AIOUtils.a(paramFloat2, paramResources));
        paramTextView.setCompoundDrawables(null, null, paramString, null);
        return;
      }
      catch (Exception paramResources) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.player.PlayModeUtils", 2, QLog.getStackTraceString(paramResources));
  }
  
  public static void a(Resources paramResources, QQUserUIItem paramQQUserUIItem, ImageView paramImageView, float paramFloat1, TextView paramTextView, float paramFloat2, float paramFloat3, boolean paramBoolean, String paramString)
  {
    Drawable localDrawable = ImageUtil.b();
    if (paramQQUserUIItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.player.PlayModeUtils", 2, "setNickNameAndAuthIcon, userItem == null");
      }
      paramImageView.setImageDrawable(localDrawable);
      paramTextView.setText(b);
      return;
    }
    Object localObject;
    int i;
    if (StoryDepends.QimUtil.a())
    {
      localObject = paramQQUserUIItem.getUserIconUrl();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.player.PlayModeUtils", 2, "fillFriendsData userIconUrl = " + (String)localObject);
        }
        a(paramResources, paramTextView, (String)localObject, paramFloat2, paramFloat3);
        i = AIOUtils.a(paramFloat1, paramResources);
        if ((!paramQQUserUIItem.isVipButNoFriend()) && (!paramQQUserUIItem.isNotDovUser())) {
          break label255;
        }
        if (!paramBoolean) {
          break label243;
        }
        paramTextView.setText(((TroopNickNameManager)SuperManager.a(23)).a(paramQQUserUIItem, paramString, false, true));
      }
    }
    for (;;)
    {
      a(paramImageView, paramQQUserUIItem.headUrl, true, i);
      return;
      if (!paramQQUserUIItem.isVipButNoFriend()) {
        break;
      }
      localObject = paramResources.getDrawable(2130843741);
      i = AIOUtils.a(paramFloat2, paramResources);
      int j = AIOUtils.a(paramFloat3, paramResources);
      if (localObject == null) {
        break;
      }
      ((Drawable)localObject).setBounds(0, 0, i, i);
      paramTextView.setCompoundDrawablePadding(j);
      paramTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
      break;
      paramTextView.setCompoundDrawables(null, null, null, null);
      break;
      label243:
      paramTextView.setText(a(paramQQUserUIItem));
    }
    label255:
    paramTextView.setCompoundDrawables(null, null, null, null);
    if (!TextUtils.isEmpty(paramQQUserUIItem.qq))
    {
      paramResources = FaceDrawable.a(a(), 1, paramQQUserUIItem.qq, 3, localDrawable, localDrawable);
      if (paramResources == null)
      {
        paramResources = localDrawable;
        paramImageView.setImageDrawable(paramResources);
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label366;
      }
      paramTextView.setText(((TroopNickNameManager)SuperManager.a(23)).a(paramQQUserUIItem, paramString, false, true));
      return;
      break;
      if (HttpUtil.a(paramQQUserUIItem.headUrl)) {
        a(paramImageView, paramQQUserUIItem.headUrl, true, i);
      } else {
        paramImageView.setImageDrawable(localDrawable);
      }
    }
    label366:
    paramTextView.setText(a(paramQQUserUIItem));
  }
  
  private static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {}
    do
    {
      return;
      localObject = paramView.getLayoutParams();
    } while (!(localObject instanceof ViewGroup.MarginLayoutParams));
    Object localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).width = paramInt1;
    ((ViewGroup.MarginLayoutParams)localObject).height = paramInt2;
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = paramInt3;
    ((ViewGroup.MarginLayoutParams)localObject).rightMargin = paramInt3;
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramInt4;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt4;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public static void a(WindowManager paramWindowManager, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new DisplayMetrics();
    paramWindowManager.getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int n = ((DisplayMetrics)localObject).widthPixels;
    int m = ((DisplayMetrics)localObject).heightPixels;
    localObject = paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
    boolean bool2 = localObject instanceof TextureVideoView;
    boolean bool1;
    int i;
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.qqstory.player.PlayModeUtils", 2, "azrael: \t发现一个没有传 videoWidth 和videoHeight 的!");
      }
      paramInt3 = 0;
      paramInt2 = n;
      paramInt1 = 0;
      bool1 = false;
      i = m;
      if (bool2)
      {
        paramWindowManager = null;
        if (bool1)
        {
          paramWindowManager = new Matrix();
          paramWindowManager.setScale(i / paramInt2, paramInt2 / i, paramInt2 / 2.0F, i / 2.0F);
          paramWindowManager.postRotate(90.0F, paramInt2 / 2.0F, i / 2.0F);
        }
        ((TextureVideoView)localObject).setTransform(paramWindowManager);
      }
      a(paramVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(), paramInt2, i, paramInt3, paramInt1);
      a(paramVideoViewHolder.jdField_b_of_type_AndroidWidgetImageView, paramInt2, i, paramInt3, paramInt1);
      a(paramVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView, paramInt2, i, paramInt3, paramInt1);
      paramVideoViewHolder.jdField_b_of_type_Boolean = bool1;
      return;
    }
    int j;
    int k;
    int i1;
    if (paramInt3 == 1)
    {
      float f1 = n / paramInt1;
      float f2 = m / paramInt2;
      if (f1 < f2)
      {
        paramInt1 = (int)(paramInt1 * f1);
        j = (int)(f1 * paramInt2);
        i = (m - j) / 2;
        paramInt3 = 0;
        paramInt2 = paramInt1;
        paramInt1 = j;
      }
      for (;;)
      {
        j = paramInt1;
        k = paramInt2;
        i1 = i;
        bool1 = false;
        i = paramInt1;
        paramInt1 = i1;
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.qqstory.player.PlayModeUtils", 2, "azrael: layoutImage: \tscreenWidth: " + n + ", screenHeight: " + m + "\n\t\t videoWidth: " + k + ", videoHeight:" + j + "\n\t\t layoutWidth: " + paramInt2 + ", layoutHeight:" + i + "\n\t\t leftMargin: " + paramInt3 + ", topMargin: " + paramInt1 + "\n\t\t shouldRotate: " + bool1);
        }
        break;
        j = (int)(paramInt1 * f2);
        paramInt1 = (int)(paramInt2 * f2);
        i = 0;
        paramInt3 = (n - j) / 2;
        paramInt2 = j;
      }
    }
    double d1 = paramInt1 / paramInt2;
    double d2 = n / m;
    if (bool2) {
      if (d1 < 1.0D)
      {
        paramInt3 = 1;
        label479:
        if (d2 >= 1.0D) {
          break label571;
        }
        i = 1;
        label489:
        if (paramInt3 == i) {
          break label577;
        }
        bool1 = true;
        label499:
        if (!bool1) {
          break label633;
        }
        d1 = paramInt2 / paramInt1;
      }
    }
    for (;;)
    {
      if (d2 >= d1)
      {
        i = (int)(n / d1);
        paramInt3 = 0;
        i1 = (int)(1.0D * (m - i) / 2.0D + 0.5D);
        k = paramInt2;
        j = paramInt1;
        paramInt2 = n;
        paramInt1 = i1;
        break;
        paramInt3 = 0;
        break label479;
        label571:
        i = 0;
        break label489;
        label577:
        bool1 = false;
        break label499;
      }
      i = (int)(d1 * m);
      i1 = 0;
      paramInt3 = (int)(1.0D * (n - i) / 2.0D + 0.5D);
      k = paramInt2;
      j = paramInt1;
      paramInt2 = i;
      i = m;
      paramInt1 = i1;
      break;
      label633:
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = paramInt3;
    }
  }
  
  public static final void a(ImageView paramImageView, QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem == null) || (paramImageView == null))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("Q.qqstory.player.PlayModeUtils", 2, "[zivon]PlayModeUtils.setQIMIconImage erroe: item = " + paramQQUserUIItem + ", iconView = " + paramImageView);
      }
      return;
    }
    paramQQUserUIItem = StoryDepends.QimUtil.a(paramQQUserUIItem);
    if (!TextUtils.isEmpty(paramQQUserUIItem))
    {
      paramImageView.setVisibility(0);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.a;
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.a;
      localURLDrawableOptions.mUseAutoScaleParams = false;
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramQQUserUIItem, localURLDrawableOptions));
      return;
    }
    paramImageView.setVisibility(8);
  }
  
  public static final void a(ImageView paramImageView, String paramString)
  {
    Drawable localDrawable = ImageUtil.a();
    paramImageView.setImageDrawable(FaceDrawable.a(a(), 1, paramString, 3, localDrawable, localDrawable));
  }
  
  protected static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, Drawable paramDrawable, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2)
  {
    a(paramImageView, paramString1, paramInt1, paramInt2, paramBoolean, paramDrawable, paramDecodeHandler, paramObject, paramString2, null);
  }
  
  protected static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, Drawable paramDrawable, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2, PlayModeUtils.ImageViewLoadCallback paramImageViewLoadCallback)
  {
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = paramDrawable;
        localURLDrawableOptions.mFailedDrawable = paramDrawable;
        localURLDrawableOptions.mPlayGifImage = false;
        localURLDrawableOptions.mGifRoundCorner = 0.0F;
        if (paramInt1 > 0) {
          localURLDrawableOptions.mRequestWidth = paramInt1;
        }
        if (paramInt2 > 0) {
          localURLDrawableOptions.mRequestHeight = paramInt2;
        }
        localURLDrawableOptions.mMemoryCacheKeySuffix = paramString2;
        if (paramBoolean)
        {
          paramString1 = URLDrawable.getDrawable(new File(paramString1), localURLDrawableOptions);
          paramString1.setDecodeHandler(paramDecodeHandler);
          paramString1.setTag(paramObject);
          paramImageView.setImageDrawable(paramString1);
          if (paramString1 == null) {
            return;
          }
          if (paramString1.getStatus() != 1) {
            break;
          }
          if (paramImageViewLoadCallback == null) {
            return;
          }
          paramImageViewLoadCallback.a();
          return;
        }
        if (HttpUtil.a(paramString1))
        {
          paramString1 = URLDrawable.getDrawable(a(paramString1, "dummypara", "666"), localURLDrawableOptions);
          paramString1.setDecodeHandler(paramDecodeHandler);
          paramString1.setTag(paramObject);
          paramString1.startDownload();
          paramImageView.setImageDrawable(paramString1);
          continue;
        }
        paramImageView.setImageDrawable(null);
      }
      catch (IllegalArgumentException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.player.PlayModeUtils", 2, "setImageView2 fail: " + QLog.getStackTraceString(paramString1));
        }
        paramImageView.setImageDrawable(null);
        return;
      }
      paramString1 = null;
    }
    paramString1.setURLDrawableListener(new nmu(System.currentTimeMillis(), paramImageViewLoadCallback));
  }
  
  protected static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2)
  {
    a(paramImageView, paramString1, paramInt1, paramInt2, paramBoolean, paramDecodeHandler, paramObject, paramString2, null);
  }
  
  protected static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2, PlayModeUtils.ImageViewLoadCallback paramImageViewLoadCallback)
  {
    a(paramImageView, paramString1, paramInt1, paramInt2, paramBoolean, new ColorDrawable(0), paramDecodeHandler, paramObject, paramString2, paramImageViewLoadCallback);
  }
  
  public static void a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = null;
    boolean bool = FileUtil.a(paramString1);
    DownloadParams.DecodeHandler localDecodeHandler;
    int[] arrayOfInt;
    if (paramBoolean)
    {
      localDecodeHandler = URLDrawableDecodeHandler.n;
      if (!paramBoolean) {
        break label67;
      }
      arrayOfInt = jdField_a_of_type_ArrayOfInt;
      label27:
      if (paramBoolean) {
        str = "rotate90";
      }
      if (!bool) {
        break label73;
      }
    }
    for (;;)
    {
      a(paramImageView, paramString1, ScreenUtil.jdField_a_of_type_Int, ScreenUtil.b, bool, localDecodeHandler, arrayOfInt, str);
      return;
      localDecodeHandler = null;
      break;
      label67:
      arrayOfInt = null;
      break label27;
      label73:
      paramString1 = paramString2;
    }
  }
  
  public static void a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    DownloadParams.DecodeHandler localDecodeHandler;
    if (paramBoolean)
    {
      localDecodeHandler = URLDrawableDecodeHandler.a;
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (String str = "StoryPlayModeRound";; str = null)
    {
      if (!FileUtil.a(paramString1)) {
        break label53;
      }
      a(paramImageView, paramString1, paramInt1, paramInt2, true, localDecodeHandler, null, str);
      return;
      localDecodeHandler = null;
      break;
    }
    label53:
    a(paramImageView, paramString2, paramInt1, paramInt2, false, localDecodeHandler, null, str);
  }
  
  public static void a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, PlayModeUtils.ImageViewLoadCallback paramImageViewLoadCallback)
  {
    String str = null;
    boolean bool = FileUtil.a(paramString1);
    DownloadParams.DecodeHandler localDecodeHandler;
    int[] arrayOfInt;
    if (paramBoolean)
    {
      localDecodeHandler = URLDrawableDecodeHandler.n;
      if (!paramBoolean) {
        break label73;
      }
      arrayOfInt = jdField_a_of_type_ArrayOfInt;
      label27:
      if (paramBoolean) {
        str = "rotate90";
      }
      if (!bool) {
        break label79;
      }
    }
    for (;;)
    {
      a(paramImageView, paramString1, ScreenUtil.jdField_a_of_type_Int / 2, ScreenUtil.b / 2, bool, localDecodeHandler, arrayOfInt, str, paramImageViewLoadCallback);
      return;
      localDecodeHandler = null;
      break;
      label73:
      arrayOfInt = null;
      break label27;
      label79:
      paramString1 = paramString2;
    }
  }
  
  public static void a(ImageView paramImageView, String paramString, boolean paramBoolean, int paramInt)
  {
    a(paramImageView, null, paramString, paramBoolean, paramInt, paramInt);
  }
  
  public static void a(TextView paramTextView)
  {
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public static void a(StoryVideoItem paramStoryVideoItem, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramStoryVideoItem.mLocalVideoPath))
    {
      paramStoryVideoItem = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 3, paramStoryVideoItem);
      Dispatchers.get().dispatch(paramStoryVideoItem);
    }
    for (;;)
    {
      return;
      if (paramStoryVideoItem.mIsPicture == 1)
      {
        b(paramStoryVideoItem, paramInt, paramString);
        return;
      }
      long l1 = SystemClock.uptimeMillis();
      String str2 = a(paramStoryVideoItem.mVid, false);
      try
      {
        i = a(paramStoryVideoItem, paramInt, str2);
        if (i == 0)
        {
          paramString = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 2, paramStoryVideoItem);
          paramString.b = str2;
          Dispatchers.get().dispatch(paramString);
          long l2 = paramStoryVideoItem.mVideoDuration;
          StoryReportor.a("play_video", "down_watermark_time", 1, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - l1), String.valueOf(l2) });
          StoryReportor.a("play_video", "down_watermark", 1, 0, new String[0]);
          StoryReportor.a("play_video", "down_suc", 1, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
          return;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        int i;
        for (;;)
        {
          QLog.e("Q.qqstory.player.PlayModeUtils", 1, "watermarkVideoByMediaCodec throw a exception, fallback to ffmpeg method...", new IllegalStateException("CatchedException, caused by: ", localIllegalStateException));
          i = -1;
        }
        QLog.e("Q.qqstory.player.PlayModeUtils", 1, "HardWare Encoder Watermark failed. ErroCode:" + i);
        Object localObject1 = QQStoryConstant.i + paramStoryVideoItem.mVid + ".mp4";
        FFmpeg localFFmpeg = FFmpeg.a(a());
        if (localFFmpeg.a())
        {
          if (!localFFmpeg.a(str2))
          {
            paramStoryVideoItem = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 1, paramStoryVideoItem);
            Dispatchers.get().dispatch(paramStoryVideoItem);
          }
        }
        else
        {
          if (FileUtils.c(str2))
          {
            paramStoryVideoItem = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 2, paramStoryVideoItem);
            paramStoryVideoItem.b = str2;
            Dispatchers.get().dispatch(paramStoryVideoItem);
            return;
          }
          if (FileUtils.c((String)localObject1))
          {
            a(localFFmpeg, (String)localObject1, paramStoryVideoItem, str2, paramInt, paramString);
            return;
          }
          if ((paramStoryVideoItem.getVideoMaskType() == 0) && (!paramStoryVideoItem.isPollVideo()) && (!paramStoryVideoItem.isInteractVideo()))
          {
            a(localFFmpeg, paramStoryVideoItem.mLocalVideoPath, paramStoryVideoItem, str2, paramInt, paramString);
            return;
          }
          Object localObject3 = FFmpegUtils.a(a(), paramStoryVideoItem.mVid, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, paramInt);
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            QLog.i("Q.qqstory.player.PlayModeUtils", 1, "get download water mark failed, logoMarkPath is null!");
          }
          Object localObject2 = FFmpegUtils.b(paramStoryVideoItem);
          localObject1 = FFmpegUtils.a(paramStoryVideoItem);
          String str1 = FFmpegUtils.a(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
          while ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            str1 = QQStoryConstant.q;
            str1 = str1 + paramStoryVideoItem.mVid + System.currentTimeMillis() + "_max.png";
            if (!FFmpegUtils.a((String)localObject2, (String)localObject1, str1))
            {
              paramStoryVideoItem = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 3, paramStoryVideoItem);
              Dispatchers.get().dispatch(paramStoryVideoItem);
              QLog.e("Q.qqstory.player.PlayModeUtils", 2, "combineTwoImg maxMask videoVote failed");
              return;
              localObject1 = str1;
            }
            else
            {
              localObject1 = str1;
            }
          }
          while ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
            if (!FFmpegUtils.a((String)localObject1, (String)localObject3, (String)localObject3))
            {
              paramStoryVideoItem = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 3, paramStoryVideoItem);
              Dispatchers.get().dispatch(paramStoryVideoItem);
              QLog.e("Q.qqstory.player.PlayModeUtils", 2, "combineTwoImg failed");
              return;
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = localObject2;
              }
            }
            else
            {
              localObject2 = localObject3;
            }
          }
          for (;;)
          {
            try
            {
              localObject1 = new PlayModeUtils.ExecuteDownloadResponseCallback(str2, paramStoryVideoItem, paramString);
              localFFmpeg.a(str2);
              paramInt = VideoUtils.b(paramStoryVideoItem.mLocalVideoPath);
              if ((paramInt != 0) && (paramInt != -1)) {
                break;
              }
              localFFmpeg.a((String)localObject2, paramStoryVideoItem.mLocalVideoPath, str2, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, (FFmpegExecuteResponseCallback)localObject1);
              return;
            }
            catch (Exception localException)
            {
              paramStoryVideoItem = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 3, paramStoryVideoItem);
              Dispatchers.get().dispatch(paramStoryVideoItem);
              QLog.e("Q.qqstory.player.PlayModeUtils", 2, localException.getMessage());
              return;
            }
            localObject2 = localException;
            if (TextUtils.isEmpty(localException)) {
              localObject2 = localObject3;
            }
          }
          localObject3 = new ArrayList();
          str1 = QQStoryConstant.i + "hflip" + paramStoryVideoItem.mVid + ".mp4";
          if (!FileUtils.c(str1))
          {
            localObject4 = new FFmpegCommandUnit();
            ((FFmpegCommandUnit)localObject4).jdField_a_of_type_Int = 10;
            ((FFmpegCommandUnit)localObject4).jdField_a_of_type_JavaUtilArrayList = new PlayModeUtils.2(paramStoryVideoItem, str1);
            ((FFmpegCommandUnit)localObject4).jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = new FFmpegUtils.ExecuteFhlipResponseCallback(localException);
            ((ArrayList)localObject3).add(localObject4);
            localObject4 = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 0, paramStoryVideoItem);
            Dispatchers.get().dispatch((Dispatcher.Dispatchable)localObject4);
          }
          Object localObject4 = new FFmpegCommandUnit();
          ((FFmpegCommandUnit)localObject4).jdField_a_of_type_Int = 1;
          ((FFmpegCommandUnit)localObject4).jdField_a_of_type_JavaUtilArrayList = new PlayModeUtils.3((String)localObject2, str1, str2, paramStoryVideoItem);
          ((FFmpegCommandUnit)localObject4).jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpegExecuteResponseCallback = localException;
          ((ArrayList)localObject3).add(localObject4);
          localFFmpeg.a((ArrayList)localObject3);
        }
      }
    }
  }
  
  protected static final void a(FFmpeg paramFFmpeg, String paramString1, StoryVideoItem paramStoryVideoItem, String paramString2, int paramInt, String paramString3)
  {
    try
    {
      PlayModeUtils.ExecuteDownloadResponseCallback localExecuteDownloadResponseCallback = new PlayModeUtils.ExecuteDownloadResponseCallback(paramString2, paramStoryVideoItem, paramString3);
      paramFFmpeg.a(paramString2);
      paramFFmpeg.a(FFmpegUtils.a(a(), paramStoryVideoItem.mVid, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, paramInt), paramString1, paramString2, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, localExecuteDownloadResponseCallback);
      return;
    }
    catch (Exception paramFFmpeg)
    {
      paramString1 = new PlayModeUtils.DownloadStatusChangeEvent(paramString3, 3, paramStoryVideoItem);
      Dispatchers.get().dispatch(paramString1);
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, paramFFmpeg.getMessage());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    a(paramQQAppInterface, paramString1, new nmy(paramActivity, paramString1, paramInt1, paramBoolean, paramInt2, paramInt3, paramString2, paramInt4));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, PlayModeUtils.VideoInfoObserver paramVideoInfoObserver)
  {
    qqstory_service.ReqBatchGetVideoFullInfoList localReqBatchGetVideoFullInfoList = new qqstory_service.ReqBatchGetVideoFullInfoList();
    localReqBatchGetVideoFullInfoList.vid_list.add(ByteStringMicro.copyFromUtf8(paramString));
    localReqBatchGetVideoFullInfoList.source.set(1);
    long l = System.currentTimeMillis();
    paramString = new Bundle();
    paramString.putLong("key_for_start_time", l);
    ProtoUtils.a(paramQQAppInterface, paramVideoInfoObserver, localReqBatchGetVideoFullInfoList.toByteArray(), GetVideoFullInfoListRequest.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public static final void a(String paramString1, String paramString2, PlayModeUtils.OnFetchUserInfoCallback paramOnFetchUserInfoCallback, boolean paramBoolean)
  {
    if (((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) || ((paramString1 != null) && (paramString1.startsWith("4_"))))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.qqstory.player.PlayModeUtils", 2, "PlayModeUtils.fetchUserInfo: unionId and uin all null !!!!");
      }
      if (paramOnFetchUserInfoCallback != null) {
        paramOnFetchUserInfoCallback.a(false, null, false);
      }
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      localObject1 = "";
      if (!TextUtils.isEmpty(paramString1)) {
        break label147;
      }
    }
    GetUserInfoHandler localGetUserInfoHandler;
    UserManager localUserManager;
    label147:
    for (Object localObject2 = "";; localObject2 = paramString1)
    {
      localObject2 = new QQUserUIItem.UserID((String)localObject1, (String)localObject2);
      localGetUserInfoHandler = new GetUserInfoHandler(new nmv(paramOnFetchUserInfoCallback, paramString1, paramString2));
      localUserManager = (UserManager)SuperManager.a(2);
      if (TextUtils.isEmpty(paramString1)) {
        break label297;
      }
      if (!paramBoolean) {
        break label153;
      }
      localGetUserInfoHandler.a(1, (QQUserUIItem.UserID)localObject2, paramString1);
      return;
      localObject1 = paramString2;
      break;
    }
    label153:
    Object localObject1 = localUserManager.b(paramString1);
    if ((localObject1 != null) && (((QQUserUIItem)localObject1).isAvailable())) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (!TextUtils.isEmpty(paramString2)) && (!paramString2.equals("-9")))
      {
        paramString2 = localUserManager.b(paramString2, false);
        if (!TextUtils.isEmpty(paramString2))
        {
          if (paramBoolean)
          {
            localGetUserInfoHandler.a(0, (QQUserUIItem.UserID)localObject2, paramString1);
            return;
            localGetUserInfoHandler.a(1, (QQUserUIItem.UserID)localObject2, paramString1);
            return;
          }
          paramString2 = localUserManager.b(paramString2);
          if ((paramString2 == null) || (!paramString2.isAvailable())) {}
        }
      }
      for (paramBoolean = true;; paramBoolean = bool)
      {
        if (paramOnFetchUserInfoCallback == null) {
          break label295;
        }
        paramOnFetchUserInfoCallback.a(paramBoolean, paramString2, false);
        return;
        localGetUserInfoHandler.a(0, (QQUserUIItem.UserID)localObject2, paramString1);
        return;
        paramString2 = (String)localObject1;
        break;
        paramString2 = (String)localObject1;
      }
      label295:
      break;
      label297:
      localObject1 = null;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return true;
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem)
  {
    return (paramStoryVideoItem.isMine()) || (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid));
  }
  
  public static boolean a(StoryVideoItem paramStoryVideoItem, Context paramContext)
  {
    if (UIUtils.b()) {
      return false;
    }
    SLog.a("Q.qqstory.player.PlayModeUtils", "onClickRetryUploadBtn=%s", paramStoryVideoItem);
    StoryReportor.a("mystory", "clk_retry", 0, 0, new String[0]);
    if (StoryVideoUploadManager.StoryVideoPublishStatusEvent.a(paramStoryVideoItem.mUpLoadFailedError))
    {
      SLog.d("Q.qqstory.player.PlayModeUtils", "video file not exist, vid:%s", new Object[] { paramStoryVideoItem.mVid });
      String str = paramStoryVideoItem.mVid;
      paramContext = DialogUtil.a(paramContext, 230);
      paramContext.setTitle("发表失败");
      if (StoryVideoUploadManager.StoryVideoPublishStatusEvent.b(paramStoryVideoItem.mUpLoadFailedError)) {
        paramContext.setMessage("音频文件已被删除，请重新拍摄");
      }
      for (;;)
      {
        paramContext.setPositiveButton("我知道了", new nmw(paramStoryVideoItem, str));
        paramContext.setCancelable(false);
        paramContext.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        paramContext.show();
        return false;
        paramContext.setMessage("视频文件已被删除，请重新拍摄");
      }
    }
    return StoryVideoUploadManager.a(paramStoryVideoItem, paramContext);
  }
  
  public static boolean a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, TagItem.TagInfoBase paramTagInfoBase)
  {
    paramVideoViewHolder = (TextView)paramVideoViewHolder.jdField_a_of_type_AndroidUtilSparseArray.get(2131372141);
    if (paramVideoViewHolder != null)
    {
      if ((paramTagInfoBase != null) && (!TextUtils.isEmpty(paramTagInfoBase.jdField_a_of_type_JavaLangString)))
      {
        paramVideoViewHolder.setText(paramTagInfoBase.jdField_a_of_type_JavaLangString);
        paramVideoViewHolder.setVisibility(0);
        return true;
      }
      paramVideoViewHolder.setVisibility(8);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return QQStoryContext.a().b().equals(paramString);
  }
  
  public static final String b(QQUserUIItem paramQQUserUIItem)
  {
    return StoryDepends.QimUtil.b(paramQQUserUIItem);
  }
  
  public static String b(String paramString)
  {
    paramString = ((UserManager)SuperManager.a(2)).b(paramString);
    if (paramString != null) {
      return paramString.headUrl;
    }
    return null;
  }
  
  protected static void b(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2)
  {
    a(paramImageView, paramString1, paramInt1, paramInt2, paramBoolean, ImageUtil.b(), paramDecodeHandler, paramObject, paramString2);
  }
  
  public static void b(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    DownloadParams.DecodeHandler localDecodeHandler;
    if (paramBoolean)
    {
      localDecodeHandler = URLDrawableDecodeHandler.a;
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (String str = "StoryPlayModeRound";; str = null)
    {
      if (!FileUtil.a(paramString1)) {
        break label53;
      }
      b(paramImageView, paramString1, paramInt1, paramInt2, true, localDecodeHandler, null, str);
      return;
      localDecodeHandler = null;
      break;
    }
    label53:
    b(paramImageView, paramString2, paramInt1, paramInt2, false, localDecodeHandler, null, str);
  }
  
  public static void b(ImageView paramImageView, String paramString, boolean paramBoolean, int paramInt)
  {
    b(paramImageView, null, paramString, paramBoolean, paramInt, paramInt);
  }
  
  @TargetApi(10)
  public static void b(StoryVideoItem paramStoryVideoItem, int paramInt, String paramString)
  {
    PlayModeUtils.DownloadStatusChangeEvent localDownloadStatusChangeEvent = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 0, paramStoryVideoItem);
    Dispatchers.get().dispatch(localDownloadStatusChangeEvent);
    ThreadManager.post(new nmx(paramStoryVideoItem, paramString, paramInt), 5, null, false);
  }
  
  public static boolean b(StoryVideoItem paramStoryVideoItem)
  {
    return paramStoryVideoItem.id == -1000L;
  }
  
  public static final boolean b(String paramString)
  {
    return ((FriendsManager)a().getManager(50)).b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils
 * JD-Core Version:    0.7.0.1
 */