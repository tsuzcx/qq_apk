package com.tencent.biz.qqstory.playmode.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.boundaries.StoryDepends.QimUtil;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TroopNickNameManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler.OnGetShareGroupInfoCallback;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchGetVideoFullInfoList;
import com.tencent.biz.qqstory.network.request.GetCollectionVideoListRequest;
import com.tencent.biz.qqstory.network.request.GetVideoFullInfoListRequest;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandUnit;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.ExecuteFhlipResponseCallback;
import com.tencent.biz.qqstory.utils.mediaCodec.VideoMergeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
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
import com.tencent.mobileqq.utils.DialogUtil;
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
import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class PlayModeUtils
{
  private static SparseArray<PlayModeUtils.DebugInfo> a;
  public static final String a;
  public static final int[] a;
  public static final String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.report_comment");
    b = StoryApi.a(2131699763);
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
      case 220: 
        return 75;
      }
      return 77;
    }
    return paramInt2;
  }
  
  public static int a(StoryVideoItem paramStoryVideoItem, int paramInt, String paramString)
  {
    Object localObject2 = FFmpegUtils.getVideoDownloadWatermarkPath(a(), paramStoryVideoItem.mVid, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, paramInt);
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      QLog.i("Q.qqstory.player.PlayModeUtils", 1, "get download water mark failed, logoMarkPath is null!");
    }
    Object localObject3 = FFmpegUtils.getVideoMaxMaskPath(paramStoryVideoItem);
    Object localObject1 = FFmpegUtils.getVideoVoteWidgetPath(paramStoryVideoItem);
    String str = FFmpegUtils.generateInteractWidgetImage(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    while ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      str = QQStoryConstant.u;
      str = str + paramStoryVideoItem.mVid + System.currentTimeMillis() + "_max.png";
      if (!FFmpegUtils.combineTwoImg((String)localObject3, (String)localObject1, str))
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
      if (FFmpegUtils.combineTwoImg((String)localObject1, (String)localObject2, (String)localObject2)) {
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
      localObject3 = QQStoryConstant.k + paramStoryVideoItem.mVid + ".mp4";
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
  
  public static ShareGroupItem a(String paramString, GetShareGroupInfoHandler.OnGetShareGroupInfoCallback paramOnGetShareGroupInfoCallback)
  {
    ShareGroupItem localShareGroupItem = ((ShareGroupManager)SuperManager.a(7)).a(paramString);
    if ((localShareGroupItem != null) || (paramOnGetShareGroupInfoCallback == null)) {
      return localShareGroupItem;
    }
    paramString = new GetShareGroupInfoHandler(paramString, String.valueOf(System.currentTimeMillis()));
    paramString.a(new PlayModeUtils.10(paramOnGetShareGroupInfoCallback));
    paramString.a();
    return null;
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
    StringBuilder localStringBuilder = new StringBuilder().append(ShortVideoUtils.getCameraPath());
    if (paramBoolean) {}
    for (String str = ".png";; str = ".mp4") {
      return FFmpegUtils.getSavePublishVidFileName(paramString, str);
    }
  }
  
  public static void a(Context paramContext, CommentEntry paramCommentEntry)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {}
    do
    {
      do
      {
        return;
        if (NetworkUtil.d(BaseApplicationImpl.getContext())) {
          break;
        }
        QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131708196), 0).a();
        StoryReportor.b("story_net", jdField_a_of_type_JavaLangString, 0, 99980, new String[] { "", "0", StoryReportor.a(BaseApplication.getContext()) });
      } while (!QLog.isColorLevel());
      QLog.w("Q.qqstory.player.PlayModeUtils", 2, "reportVideoCommemt - isNetSupport is false----");
      return;
      paramContext = (ActionSheet)ActionSheetHelper.b(paramContext, null);
      paramContext.addButton(HardCodeUtil.a(2131708188), 5);
      paramContext.addButton(HardCodeUtil.a(2131708207), 5);
      paramContext.addButton(HardCodeUtil.a(2131708204), 5);
      paramContext.addButton(HardCodeUtil.a(2131708192), 5);
      paramContext.addCancelButton(2131690800);
      paramContext.setOnButtonClickListener(new PlayModeUtils.8(paramCommentEntry, paramContext));
    } while (paramContext.isShowing());
    paramContext.show();
  }
  
  public static void a(Context paramContext, QQUserUIItem paramQQUserUIItem, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (!NetworkUtil.d(BaseApplicationImpl.getContext())) {
      QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131708205), 0).a();
    }
    do
    {
      return;
      paramContext = (ActionSheet)ActionSheetHelper.b(paramContext, null);
      paramContext.addButton(HardCodeUtil.a(2131708203), 5);
      paramContext.addButton(HardCodeUtil.a(2131708197), 5);
      paramContext.addButton(HardCodeUtil.a(2131708210), 5);
      paramContext.addButton(HardCodeUtil.a(2131708187), 5);
      paramContext.addCancelButton(2131690800);
      paramContext.setOnButtonClickListener(new PlayModeUtils.7(paramQQUserUIItem, paramContext));
      paramContext.setOnDismissListener(paramOnDismissListener);
    } while (paramContext.isShowing());
    paramContext.show();
  }
  
  public static void a(Context paramContext, StoryVideoItem paramStoryVideoItem, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (!NetworkUtil.d(BaseApplicationImpl.getContext())) {
      QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131708190), 0).a();
    }
    do
    {
      return;
      paramContext = (ActionSheet)ActionSheetHelper.b(paramContext, null);
      paramContext.addButton(HardCodeUtil.a(2131708186), 5);
      paramContext.addButton(HardCodeUtil.a(2131708189), 5);
      paramContext.addButton(HardCodeUtil.a(2131708208), 5);
      paramContext.addButton(HardCodeUtil.a(2131708209), 5);
      paramContext.addCancelButton(2131690800);
      paramContext.setOnButtonClickListener(new PlayModeUtils.9(paramStoryVideoItem, paramContext));
      paramContext.setOnDismissListener(paramOnDismissListener);
    } while (paramContext.isShowing());
    paramContext.show();
  }
  
  public static void a(Resources paramResources, TextView paramTextView, String paramString, float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    if ((paramResources == null) || (paramTextView == null) || (!HttpUtil.isValidUrl(paramString))) {
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
        Drawable localDrawable = URLDrawableHelper.TRANSPARENT;
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
    Drawable localDrawable = ImageUtil.c();
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
      localObject = paramResources.getDrawable(2130847187);
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
      paramResources = FaceDrawable.getFaceDrawable(a(), 1, paramQQUserUIItem.qq, 3, localDrawable, localDrawable);
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
      if (HttpUtil.isValidUrl(paramQQUserUIItem.headUrl)) {
        a(paramImageView, paramQQUserUIItem.headUrl, true, i);
      } else {
        paramImageView.setImageDrawable(localDrawable);
      }
    }
    label366:
    paramTextView.setText(a(paramQQUserUIItem));
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
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      localURLDrawableOptions.mUseAutoScaleParams = false;
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramQQUserUIItem, localURLDrawableOptions));
      return;
    }
    paramImageView.setVisibility(8);
  }
  
  public static final void a(ImageView paramImageView, String paramString)
  {
    Drawable localDrawable = ImageUtil.d();
    paramImageView.setImageDrawable(FaceDrawable.getFaceDrawable(a(), 1, paramString, 3, localDrawable, localDrawable));
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
        if (HttpUtil.isValidUrl(paramString1))
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
    paramString1.setURLDrawableListener(new PlayModeUtils.1(System.currentTimeMillis(), paramImageViewLoadCallback));
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
    b(paramImageView, paramString1, paramString2, paramBoolean, null);
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
      localDecodeHandler = URLDrawableDecodeHandler.s;
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
      a(paramImageView, paramString1, ScreenUtil.SCREEN_WIDTH / 2, ScreenUtil.SCREEN_HIGHT / 2, bool, localDecodeHandler, arrayOfInt, str, paramImageViewLoadCallback);
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
    ThreadManager.post(new PlayModeUtils.2(paramStoryVideoItem, paramInt, paramString), 5, null, false);
  }
  
  public static void a(ShareFromMemoryPlayInfo paramShareFromMemoryPlayInfo, PlayModeUtils.FeedShareInteractStatusObserver paramFeedShareInteractStatusObserver)
  {
    GetCollectionVideoListRequest localGetCollectionVideoListRequest = new GetCollectionVideoListRequest();
    localGetCollectionVideoListRequest.jdField_c_of_type_JavaLangString = paramShareFromMemoryPlayInfo.uid;
    localGetCollectionVideoListRequest.d = "";
    localGetCollectionVideoListRequest.jdField_c_of_type_Int = 20;
    localGetCollectionVideoListRequest.jdField_e_of_type_Int = paramShareFromMemoryPlayInfo.shareTimeZone;
    localGetCollectionVideoListRequest.jdField_e_of_type_JavaLangString = paramShareFromMemoryPlayInfo.feedId;
    localGetCollectionVideoListRequest.f = paramShareFromMemoryPlayInfo.identify;
    localGetCollectionVideoListRequest.g = paramShareFromMemoryPlayInfo.videoListOrder;
    CmdTaskManger.a().a(localGetCollectionVideoListRequest, new PlayModeUtils.6(paramFeedShareInteractStatusObserver));
  }
  
  protected static final void a(FFmpeg paramFFmpeg, String paramString1, StoryVideoItem paramStoryVideoItem, String paramString2, int paramInt, String paramString3)
  {
    try
    {
      PlayModeUtils.ExecuteDownloadResponseCallback localExecuteDownloadResponseCallback = new PlayModeUtils.ExecuteDownloadResponseCallback(paramString2, paramStoryVideoItem, paramString3);
      paramFFmpeg.setCurrentTaskUni(paramString2);
      paramFFmpeg.watermark(FFmpegUtils.getVideoDownloadWatermarkPath(a(), paramStoryVideoItem.mVid, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, paramInt), paramString1, paramString2, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, localExecuteDownloadResponseCallback);
      return;
    }
    catch (Exception paramFFmpeg)
    {
      paramString1 = new PlayModeUtils.DownloadStatusChangeEvent(paramString3, 3, paramStoryVideoItem);
      StoryDispatcher.a().dispatch(paramString1);
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, paramFFmpeg.getMessage());
    }
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
      paramContext.setTitle(HardCodeUtil.a(2131708195));
      if (StoryVideoUploadManager.StoryVideoPublishStatusEvent.b(paramStoryVideoItem.mUpLoadFailedError)) {
        paramContext.setMessage(HardCodeUtil.a(2131708202));
      }
      for (;;)
      {
        paramContext.setPositiveButton(HardCodeUtil.a(2131708201), new PlayModeUtils.11(paramStoryVideoItem, str));
        paramContext.setCancelable(false);
        paramContext.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        paramContext.show();
        return false;
        paramContext.setMessage(HardCodeUtil.a(2131708198));
      }
    }
    return StoryVideoUploadManager.a(paramStoryVideoItem, paramContext);
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
    a(paramImageView, paramString1, paramInt1, paramInt2, paramBoolean, ImageUtil.c(), paramDecodeHandler, paramObject, paramString2);
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
  
  public static void b(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, PlayModeUtils.ImageViewLoadCallback paramImageViewLoadCallback)
  {
    String str = null;
    boolean bool = FileUtil.a(paramString1);
    DownloadParams.DecodeHandler localDecodeHandler;
    int[] arrayOfInt;
    if (paramBoolean)
    {
      localDecodeHandler = URLDrawableDecodeHandler.s;
      if (!paramBoolean) {
        break label69;
      }
      arrayOfInt = jdField_a_of_type_ArrayOfInt;
      label27:
      if (paramBoolean) {
        str = "rotate90";
      }
      if (!bool) {
        break label75;
      }
    }
    for (;;)
    {
      a(paramImageView, paramString1, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT, bool, localDecodeHandler, arrayOfInt, str, paramImageViewLoadCallback);
      return;
      localDecodeHandler = null;
      break;
      label69:
      arrayOfInt = null;
      break label27;
      label75:
      paramString1 = paramString2;
    }
  }
  
  public static void b(ImageView paramImageView, String paramString, boolean paramBoolean, int paramInt)
  {
    b(paramImageView, null, paramString, paramBoolean, paramInt, paramInt);
  }
  
  public static void b(StoryVideoItem paramStoryVideoItem, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramStoryVideoItem.mLocalVideoPath))
    {
      paramStoryVideoItem = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 3, paramStoryVideoItem);
      StoryDispatcher.a().dispatch(paramStoryVideoItem);
    }
    for (;;)
    {
      return;
      if (paramStoryVideoItem.mIsPicture == 1)
      {
        c(paramStoryVideoItem, paramInt, paramString);
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
          StoryDispatcher.a().dispatch(paramString);
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
        Object localObject1 = QQStoryConstant.k + paramStoryVideoItem.mVid + ".mp4";
        FFmpeg localFFmpeg = FFmpeg.getInstance(a());
        if (localFFmpeg.isFFmpegCommandRunning())
        {
          if (!localFFmpeg.checkSameTask(str2))
          {
            paramStoryVideoItem = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 1, paramStoryVideoItem);
            StoryDispatcher.a().dispatch(paramStoryVideoItem);
          }
        }
        else
        {
          if (FileUtils.c(str2))
          {
            paramStoryVideoItem = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 2, paramStoryVideoItem);
            paramStoryVideoItem.b = str2;
            StoryDispatcher.a().dispatch(paramStoryVideoItem);
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
          Object localObject3 = FFmpegUtils.getVideoDownloadWatermarkPath(a(), paramStoryVideoItem.mVid, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, paramInt);
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            QLog.i("Q.qqstory.player.PlayModeUtils", 1, "get download water mark failed, logoMarkPath is null!");
          }
          Object localObject2 = FFmpegUtils.getVideoMaxMaskPath(paramStoryVideoItem);
          localObject1 = FFmpegUtils.getVideoVoteWidgetPath(paramStoryVideoItem);
          String str1 = FFmpegUtils.generateInteractWidgetImage(paramStoryVideoItem.getInteractLayout(), paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
          while ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            str1 = QQStoryConstant.u;
            str1 = str1 + paramStoryVideoItem.mVid + System.currentTimeMillis() + "_max.png";
            if (!FFmpegUtils.combineTwoImg((String)localObject2, (String)localObject1, str1))
            {
              paramStoryVideoItem = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 3, paramStoryVideoItem);
              StoryDispatcher.a().dispatch(paramStoryVideoItem);
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
            if (!FFmpegUtils.combineTwoImg((String)localObject1, (String)localObject3, (String)localObject3))
            {
              paramStoryVideoItem = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 3, paramStoryVideoItem);
              StoryDispatcher.a().dispatch(paramStoryVideoItem);
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
              localFFmpeg.setCurrentTaskUni(str2);
              paramInt = VideoUtils.b(paramStoryVideoItem.mLocalVideoPath);
              if ((paramInt != 0) && (paramInt != -1)) {
                break;
              }
              localFFmpeg.watermark((String)localObject2, paramStoryVideoItem.mLocalVideoPath, str2, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, (FFmpegExecuteResponseCallback)localObject1);
              return;
            }
            catch (Exception localException)
            {
              paramStoryVideoItem = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 3, paramStoryVideoItem);
              StoryDispatcher.a().dispatch(paramStoryVideoItem);
              QLog.e("Q.qqstory.player.PlayModeUtils", 2, localException.getMessage());
              return;
            }
            localObject2 = localException;
            if (TextUtils.isEmpty(localException)) {
              localObject2 = localObject3;
            }
          }
          localObject3 = new ArrayList();
          str1 = QQStoryConstant.k + "hflip" + paramStoryVideoItem.mVid + ".mp4";
          if (!FileUtils.c(str1))
          {
            localObject4 = new FFmpegCommandUnit();
            ((FFmpegCommandUnit)localObject4).cmdType = 10;
            ((FFmpegCommandUnit)localObject4).arguments = new PlayModeUtils.3(paramStoryVideoItem, str1);
            ((FFmpegCommandUnit)localObject4).callback = new FFmpegUtils.ExecuteFhlipResponseCallback(localException);
            ((ArrayList)localObject3).add(localObject4);
            localObject4 = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 0, paramStoryVideoItem);
            StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject4);
          }
          Object localObject4 = new FFmpegCommandUnit();
          ((FFmpegCommandUnit)localObject4).cmdType = 1;
          ((FFmpegCommandUnit)localObject4).arguments = new PlayModeUtils.4((String)localObject2, str1, str2, paramStoryVideoItem);
          ((FFmpegCommandUnit)localObject4).callback = localException;
          ((ArrayList)localObject3).add(localObject4);
          localFFmpeg.cmdFFmpegQueue((ArrayList)localObject3);
        }
      }
    }
  }
  
  public static boolean b(StoryVideoItem paramStoryVideoItem)
  {
    return paramStoryVideoItem.id == -1000L;
  }
  
  @TargetApi(10)
  public static void c(StoryVideoItem paramStoryVideoItem, int paramInt, String paramString)
  {
    PlayModeUtils.DownloadStatusChangeEvent localDownloadStatusChangeEvent = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 0, paramStoryVideoItem);
    StoryDispatcher.a().dispatch(localDownloadStatusChangeEvent);
    ThreadManager.post(new PlayModeUtils.5(paramStoryVideoItem, paramString, paramInt), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils
 * JD-Core Version:    0.7.0.1
 */