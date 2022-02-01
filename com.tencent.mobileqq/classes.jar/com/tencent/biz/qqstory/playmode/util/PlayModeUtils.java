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
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TroopNickNameManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchGetVideoFullInfoList;
import com.tencent.biz.qqstory.network.request.GetCollectionVideoListRequest;
import com.tencent.biz.qqstory.network.request.GetVideoFullInfoListRequest;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegCommandUnit;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils;
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
    b = StoryApi.a(2131699904);
    jdField_a_of_type_ArrayOfInt = new int[] { 90 };
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt != 76) && (paramInt != 77)) {
      return 220;
    }
    return 221;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 == 0)
    {
      if (paramInt1 != 10)
      {
        if (paramInt1 != 11)
        {
          if ((paramInt1 != 23) && (paramInt1 != 220) && (paramInt1 != 210))
          {
            if (paramInt1 != 211) {
              return 0;
            }
            return 77;
          }
          return 75;
        }
        return 76;
      }
      i = 74;
    }
    return i;
  }
  
  public static int a(StoryVideoItem paramStoryVideoItem, int paramInt, String paramString)
  {
    paramString = new PublishVideoEntry();
    paramString.doodlePath = null;
    paramString.mLocalRawVideoDir = paramStoryVideoItem.mLocalVideoPath;
    paramString.businessId = 1;
    return 0;
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
    if ((paramQQUserUIItem != null) && (paramQQUserUIItem.isAvailable()))
    {
      if ((paramQQUserUIItem.isVip) && (!paramQQUserUIItem.isFriend())) {
        return paramQQUserUIItem.nickName;
      }
      return paramQQUserUIItem.getDisplayName();
    }
    return b;
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
    if (paramString1.contains("?"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("&");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("=");
      localStringBuilder.append(paramString3);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("?");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("=");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  public static final String a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ShortVideoUtils.getCameraPath());
    String str;
    if (paramBoolean) {
      str = ".png";
    } else {
      str = ".mp4";
    }
    localStringBuilder.append(FFmpegUtils.getSavePublishVidFileName(paramString, str));
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, CommentEntry paramCommentEntry)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131708205), 0).a();
      StoryReportor.b("story_net", jdField_a_of_type_JavaLangString, 0, 99980, new String[] { "", "0", StoryReportor.a(BaseApplication.getContext()) });
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.player.PlayModeUtils", 2, "reportVideoCommemt - isNetSupport is false----");
      }
      return;
    }
    paramContext = (ActionSheet)ActionSheetHelper.b(paramContext, null);
    paramContext.addButton(HardCodeUtil.a(2131708197), 5);
    paramContext.addButton(HardCodeUtil.a(2131708216), 5);
    paramContext.addButton(HardCodeUtil.a(2131708213), 5);
    paramContext.addButton(HardCodeUtil.a(2131708201), 5);
    paramContext.addCancelButton(2131690728);
    paramContext.setOnButtonClickListener(new PlayModeUtils.8(paramCommentEntry, paramContext));
    if (!paramContext.isShowing()) {
      paramContext.show();
    }
  }
  
  public static void a(Context paramContext, QQUserUIItem paramQQUserUIItem, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131708214), 0).a();
      return;
    }
    paramContext = (ActionSheet)ActionSheetHelper.b(paramContext, null);
    paramContext.addButton(HardCodeUtil.a(2131708212), 5);
    paramContext.addButton(HardCodeUtil.a(2131708206), 5);
    paramContext.addButton(HardCodeUtil.a(2131708219), 5);
    paramContext.addButton(HardCodeUtil.a(2131708196), 5);
    paramContext.addCancelButton(2131690728);
    paramContext.setOnButtonClickListener(new PlayModeUtils.7(paramQQUserUIItem, paramContext));
    paramContext.setOnDismissListener(paramOnDismissListener);
    if (!paramContext.isShowing()) {
      paramContext.show();
    }
  }
  
  public static void a(Context paramContext, StoryVideoItem paramStoryVideoItem, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131708199), 0).a();
      return;
    }
    paramContext = (ActionSheet)ActionSheetHelper.b(paramContext, null);
    paramContext.addButton(HardCodeUtil.a(2131708195), 5);
    paramContext.addButton(HardCodeUtil.a(2131708198), 5);
    paramContext.addButton(HardCodeUtil.a(2131708217), 5);
    paramContext.addButton(HardCodeUtil.a(2131708218), 5);
    paramContext.addCancelButton(2131690728);
    paramContext.setOnButtonClickListener(new PlayModeUtils.9(paramStoryVideoItem, paramContext));
    paramContext.setOnDismissListener(paramOnDismissListener);
    if (!paramContext.isShowing()) {
      paramContext.show();
    }
  }
  
  public static void a(Resources paramResources, TextView paramTextView, String paramString, float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    if ((paramResources != null) && (paramTextView != null) && (HttpUtil.isValidUrl(paramString))) {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int i = AIOUtils.b(paramFloat1, paramResources);
        Drawable localDrawable = URLDrawableHelperConstants.a;
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
        paramTextView.setCompoundDrawablePadding(AIOUtils.b(paramFloat2, paramResources));
        paramTextView.setCompoundDrawables(null, null, paramString, null);
        return;
      }
      catch (Exception paramResources)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.player.PlayModeUtils", 2, QLog.getStackTraceString(paramResources));
        }
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramResources = new StringBuilder();
      paramResources.append("setAuthIcon fail：textView is null ? ");
      if (paramTextView == null) {
        bool = true;
      }
      paramResources.append(bool);
      paramResources.append(", url = ");
      paramResources.append(paramString);
      QLog.w("Q.qqstory.player.PlayModeUtils", 2, paramResources.toString());
    }
  }
  
  public static void a(Resources paramResources, QQUserUIItem paramQQUserUIItem, ImageView paramImageView, float paramFloat1, TextView paramTextView, float paramFloat2, float paramFloat3, boolean paramBoolean, String paramString)
  {
    Drawable localDrawable = ImageUtil.e();
    if (paramQQUserUIItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.player.PlayModeUtils", 2, "setNickNameAndAuthIcon, userItem == null");
      }
      paramImageView.setImageDrawable(localDrawable);
      paramTextView.setText(b);
      return;
    }
    if (StoryDepends.QimUtil.a())
    {
      Object localObject = paramQQUserUIItem.getUserIconUrl();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("fillFriendsData userIconUrl = ");
          localStringBuilder.append((String)localObject);
          QLog.d("Q.qqstory.player.PlayModeUtils", 2, localStringBuilder.toString());
        }
        a(paramResources, paramTextView, (String)localObject, paramFloat2, paramFloat3);
      }
      else if (paramQQUserUIItem.isVipButNoFriend())
      {
        localObject = paramResources.getDrawable(2130847062);
        i = AIOUtils.b(paramFloat2, paramResources);
        int j = AIOUtils.b(paramFloat3, paramResources);
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(0, 0, i, i);
          paramTextView.setCompoundDrawablePadding(j);
          paramTextView.setCompoundDrawables(null, null, (Drawable)localObject, null);
        }
      }
    }
    else
    {
      paramTextView.setCompoundDrawables(null, null, null, null);
    }
    int i = AIOUtils.b(paramFloat1, paramResources);
    if ((!paramQQUserUIItem.isVipButNoFriend()) && (!paramQQUserUIItem.isNotDovUser()))
    {
      paramTextView.setCompoundDrawables(null, null, null, null);
      if (!TextUtils.isEmpty(paramQQUserUIItem.qq))
      {
        paramResources = FaceDrawable.getFaceDrawable(a(), 1, paramQQUserUIItem.qq, 3, localDrawable, localDrawable);
        if (paramResources == null) {
          paramResources = localDrawable;
        }
        paramImageView.setImageDrawable(paramResources);
      }
      else if (HttpUtil.isValidUrl(paramQQUserUIItem.headUrl))
      {
        a(paramImageView, paramQQUserUIItem.headUrl, true, i);
      }
      else
      {
        paramImageView.setImageDrawable(localDrawable);
      }
      if (paramBoolean)
      {
        paramTextView.setText(((TroopNickNameManager)SuperManager.a(23)).a(paramQQUserUIItem, paramString, false, true));
        return;
      }
      paramTextView.setText(a(paramQQUserUIItem));
      return;
    }
    if (paramBoolean) {
      paramTextView.setText(((TroopNickNameManager)SuperManager.a(23)).a(paramQQUserUIItem, paramString, false, true));
    } else {
      paramTextView.setText(a(paramQQUserUIItem));
    }
    a(paramImageView, paramQQUserUIItem.headUrl, true, i);
  }
  
  public static final void a(ImageView paramImageView, QQUserUIItem paramQQUserUIItem)
  {
    Object localObject;
    if ((paramQQUserUIItem != null) && (paramImageView != null))
    {
      paramQQUserUIItem = StoryDepends.QimUtil.a(paramQQUserUIItem);
      if (!TextUtils.isEmpty(paramQQUserUIItem))
      {
        paramImageView.setVisibility(0);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
        ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
        paramImageView.setImageDrawable(URLDrawable.getDrawable(paramQQUserUIItem, (URLDrawable.URLDrawableOptions)localObject));
        return;
      }
      paramImageView.setVisibility(8);
      return;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[zivon]PlayModeUtils.setQIMIconImage erroe: item = ");
      ((StringBuilder)localObject).append(paramQQUserUIItem);
      ((StringBuilder)localObject).append(", iconView = ");
      ((StringBuilder)localObject).append(paramImageView);
      QLog.w("Q.qqstory.player.PlayModeUtils", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static final void a(ImageView paramImageView, String paramString)
  {
    Drawable localDrawable = ImageUtil.f();
    paramImageView.setImageDrawable(FaceDrawable.getFaceDrawable(a(), 1, paramString, 3, localDrawable, localDrawable));
  }
  
  protected static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, Drawable paramDrawable, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2)
  {
    a(paramImageView, paramString1, paramInt1, paramInt2, paramBoolean, paramDrawable, paramDecodeHandler, paramObject, paramString2, null);
  }
  
  protected static void a(ImageView paramImageView, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, Drawable paramDrawable, DownloadParams.DecodeHandler paramDecodeHandler, Object paramObject, String paramString2, PlayModeUtils.ImageViewLoadCallback paramImageViewLoadCallback)
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
      }
      else if (HttpUtil.isValidUrl(paramString1))
      {
        paramString1 = URLDrawable.getDrawable(a(paramString1, "dummypara", "666"), localURLDrawableOptions);
        paramString1.setDecodeHandler(paramDecodeHandler);
        paramString1.setTag(paramObject);
        paramString1.startDownload();
        paramImageView.setImageDrawable(paramString1);
      }
      else
      {
        paramImageView.setImageDrawable(null);
        paramString1 = null;
      }
      if (paramString1 != null) {
        if (paramString1.getStatus() == 1)
        {
          if (paramImageViewLoadCallback != null) {
            paramImageViewLoadCallback.a();
          }
        }
        else
        {
          paramString1.setURLDrawableListener(new PlayModeUtils.1(System.currentTimeMillis(), paramImageViewLoadCallback));
          return;
        }
      }
    }
    catch (IllegalArgumentException paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramDrawable = new StringBuilder();
        paramDrawable.append("setImageView2 fail: ");
        paramDrawable.append(QLog.getStackTraceString(paramString1));
        QLog.w("Q.qqstory.player.PlayModeUtils", 2, paramDrawable.toString());
      }
      paramImageView.setImageDrawable(null);
    }
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
    String str = null;
    DownloadParams.DecodeHandler localDecodeHandler;
    if (paramBoolean) {
      localDecodeHandler = URLDrawableDecodeHandler.a;
    } else {
      localDecodeHandler = null;
    }
    if (paramBoolean) {
      str = "StoryPlayModeRound";
    }
    if (FileUtil.b(paramString1))
    {
      a(paramImageView, paramString1, paramInt1, paramInt2, true, localDecodeHandler, null, str);
      return;
    }
    a(paramImageView, paramString2, paramInt1, paramInt2, false, localDecodeHandler, null, str);
  }
  
  public static void a(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, PlayModeUtils.ImageViewLoadCallback paramImageViewLoadCallback)
  {
    boolean bool = FileUtil.b(paramString1);
    DownloadParams.DecodeHandler localDecodeHandler;
    if (paramBoolean) {
      localDecodeHandler = URLDrawableDecodeHandler.q;
    } else {
      localDecodeHandler = null;
    }
    int[] arrayOfInt;
    if (paramBoolean) {
      arrayOfInt = jdField_a_of_type_ArrayOfInt;
    } else {
      arrayOfInt = null;
    }
    String str;
    if (paramBoolean) {
      str = "rotate90";
    } else {
      str = null;
    }
    if (!bool) {
      paramString1 = paramString2;
    }
    a(paramImageView, paramString1, ScreenUtil.SCREEN_WIDTH / 2, ScreenUtil.SCREEN_HIGHT / 2, bool, localDecodeHandler, arrayOfInt, str, paramImageViewLoadCallback);
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
  
  protected static final void a(FFmpeg paramFFmpeg, String paramString1, StoryVideoItem paramStoryVideoItem, String paramString2, int paramInt, String paramString3)
  {
    try
    {
      PlayModeUtils.ExecuteDownloadResponseCallback localExecuteDownloadResponseCallback = new PlayModeUtils.ExecuteDownloadResponseCallback(paramString2, paramStoryVideoItem, paramString3);
      paramFFmpeg.setCurrentTaskUni(paramString2);
      paramFFmpeg.watermark(null, paramString1, paramString2, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, localExecuteDownloadResponseCallback);
      return;
    }
    catch (Exception paramFFmpeg)
    {
      paramString1 = new PlayModeUtils.DownloadStatusChangeEvent(paramString3, 3, paramStoryVideoItem);
      StoryDispatcher.a().dispatch(paramString1);
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, paramFFmpeg.getMessage());
    }
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
      paramContext.setTitle(HardCodeUtil.a(2131708204));
      if (StoryVideoUploadManager.StoryVideoPublishStatusEvent.b(paramStoryVideoItem.mUpLoadFailedError)) {
        paramContext.setMessage(HardCodeUtil.a(2131708211));
      } else {
        paramContext.setMessage(HardCodeUtil.a(2131708207));
      }
      paramContext.setPositiveButton(HardCodeUtil.a(2131708210), new PlayModeUtils.11(paramStoryVideoItem, str));
      paramContext.setCancelable(false);
      paramContext.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      paramContext.show();
      return false;
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
    a(paramImageView, paramString1, paramInt1, paramInt2, paramBoolean, ImageUtil.e(), paramDecodeHandler, paramObject, paramString2);
  }
  
  public static void b(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    String str = null;
    DownloadParams.DecodeHandler localDecodeHandler;
    if (paramBoolean) {
      localDecodeHandler = URLDrawableDecodeHandler.a;
    } else {
      localDecodeHandler = null;
    }
    if (paramBoolean) {
      str = "StoryPlayModeRound";
    }
    if (FileUtil.b(paramString1))
    {
      b(paramImageView, paramString1, paramInt1, paramInt2, true, localDecodeHandler, null, str);
      return;
    }
    b(paramImageView, paramString2, paramInt1, paramInt2, false, localDecodeHandler, null, str);
  }
  
  public static void b(ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean, PlayModeUtils.ImageViewLoadCallback paramImageViewLoadCallback)
  {
    boolean bool = FileUtil.b(paramString1);
    DownloadParams.DecodeHandler localDecodeHandler;
    if (paramBoolean) {
      localDecodeHandler = URLDrawableDecodeHandler.q;
    } else {
      localDecodeHandler = null;
    }
    int[] arrayOfInt;
    if (paramBoolean) {
      arrayOfInt = jdField_a_of_type_ArrayOfInt;
    } else {
      arrayOfInt = null;
    }
    String str;
    if (paramBoolean) {
      str = "rotate90";
    } else {
      str = null;
    }
    if (!bool) {
      paramString1 = paramString2;
    }
    a(paramImageView, paramString1, ScreenUtil.SCREEN_WIDTH, ScreenUtil.SCREEN_HIGHT, bool, localDecodeHandler, arrayOfInt, str, paramImageViewLoadCallback);
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
      return;
    }
    if (paramStoryVideoItem.mIsPicture == 1)
    {
      c(paramStoryVideoItem, paramInt, paramString);
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    String str = a(paramStoryVideoItem.mVid, false);
    int i;
    try
    {
      i = a(paramStoryVideoItem, paramInt, str);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QLog.e("Q.qqstory.player.PlayModeUtils", 1, "watermarkVideoByMediaCodec throw a exception, fallback to ffmpeg method...", new IllegalStateException("CatchedException, caused by: ", localIllegalStateException));
      i = -1;
    }
    if (i == 0)
    {
      paramString = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 2, paramStoryVideoItem);
      paramString.b = str;
      StoryDispatcher.a().dispatch(paramString);
      long l2 = paramStoryVideoItem.mVideoDuration;
      StoryReportor.a("play_video", "down_watermark_time", 1, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - l1), String.valueOf(l2) });
      StoryReportor.a("play_video", "down_watermark", 1, 0, new String[0]);
      StoryReportor.a("play_video", "down_suc", 1, 0, new String[] { "", "", "", paramStoryVideoItem.mVid });
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("HardWare Encoder Watermark failed. ErroCode:");
    ((StringBuilder)localObject1).append(i);
    QLog.e("Q.qqstory.player.PlayModeUtils", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(QQStoryConstant.l);
    ((StringBuilder)localObject1).append(paramStoryVideoItem.mVid);
    ((StringBuilder)localObject1).append(".mp4");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = FFmpeg.getInstance(a());
    if (((FFmpeg)localObject1).isFFmpegCommandRunning())
    {
      if (!((FFmpeg)localObject1).checkSameTask(str))
      {
        paramStoryVideoItem = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 1, paramStoryVideoItem);
        StoryDispatcher.a().dispatch(paramStoryVideoItem);
      }
      return;
    }
    if (FileUtils.c(str))
    {
      paramStoryVideoItem = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 2, paramStoryVideoItem);
      paramStoryVideoItem.b = str;
      StoryDispatcher.a().dispatch(paramStoryVideoItem);
      return;
    }
    if (FileUtils.c((String)localObject2))
    {
      a((FFmpeg)localObject1, (String)localObject2, paramStoryVideoItem, str, paramInt, paramString);
      return;
    }
    if ((paramStoryVideoItem.getVideoMaskType() == 0) && (!paramStoryVideoItem.isPollVideo()) && (!paramStoryVideoItem.isInteractVideo()))
    {
      a((FFmpeg)localObject1, paramStoryVideoItem.mLocalVideoPath, paramStoryVideoItem, str, paramInt, paramString);
      return;
    }
    try
    {
      localObject2 = new PlayModeUtils.ExecuteDownloadResponseCallback(str, paramStoryVideoItem, paramString);
      ((FFmpeg)localObject1).setCurrentTaskUni(str);
      paramInt = VideoUtils.a(paramStoryVideoItem.mLocalVideoPath);
      if ((paramInt != 0) && (paramInt != -1))
      {
        localObject3 = new ArrayList();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(QQStoryConstant.l);
        ((StringBuilder)localObject4).append("hflip");
        ((StringBuilder)localObject4).append(paramStoryVideoItem.mVid);
        ((StringBuilder)localObject4).append(".mp4");
        localObject4 = ((StringBuilder)localObject4).toString();
        if (!FileUtils.c((String)localObject4))
        {
          localObject5 = new FFmpegCommandUnit();
          ((FFmpegCommandUnit)localObject5).cmdType = 10;
          ((FFmpegCommandUnit)localObject5).arguments = new PlayModeUtils.3(paramStoryVideoItem, (String)localObject4);
          ((ArrayList)localObject3).add(localObject5);
          localObject5 = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 0, paramStoryVideoItem);
          StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject5);
        }
        Object localObject5 = new FFmpegCommandUnit();
        ((FFmpegCommandUnit)localObject5).cmdType = 1;
        ((FFmpegCommandUnit)localObject5).arguments = new PlayModeUtils.4(null, (String)localObject4, str, paramStoryVideoItem);
        ((FFmpegCommandUnit)localObject5).callback = ((FFmpegExecuteResponseCallback)localObject2);
        ((ArrayList)localObject3).add(localObject5);
        ((FFmpeg)localObject1).cmdFFmpegQueue((ArrayList)localObject3);
        return;
      }
      Object localObject3 = paramStoryVideoItem.mLocalVideoPath;
      paramInt = paramStoryVideoItem.mVideoWidth;
      i = paramStoryVideoItem.mVideoHeight;
      try
      {
        ((FFmpeg)localObject1).watermark(null, (String)localObject3, str, paramInt, i, (FFmpegExecuteResponseCallback)localObject2);
        return;
      }
      catch (Exception localException1) {}
      paramStoryVideoItem = new PlayModeUtils.DownloadStatusChangeEvent(paramString, 3, paramStoryVideoItem);
    }
    catch (Exception localException2) {}
    StoryDispatcher.a().dispatch(paramStoryVideoItem);
    QLog.e("Q.qqstory.player.PlayModeUtils", 2, localException2.getMessage());
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
    ThreadManager.post(new PlayModeUtils.5(paramStoryVideoItem, paramString), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils
 * JD-Core Version:    0.7.0.1
 */