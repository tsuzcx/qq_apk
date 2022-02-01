package com.tencent.mobileqq.activity.aio.photo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IAECaptureContext;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.common.app.AppInterface;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.device.msg.activities.AIODevLittleVideoData;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.image.VideoDrawable;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.OnProGalleryListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.ProGallery;
import com.tencent.mobileqq.activity.photo.ProGallery.OnProGalleryGestureListener;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.VideoPlayController.VideoPlayerStateListener;
import com.tencent.mobileqq.activity.photo.VideoPlayControllerForAIO;
import com.tencent.mobileqq.activity.photo.VideoPlayControllerForAIO.OnDownloadListener;
import com.tencent.mobileqq.activity.photo.VideoPlayControllerForFile;
import com.tencent.mobileqq.activity.photo.VideoPlayMedioInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MiniCodePeakHandler;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanReportApi;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.UnCompletedCode;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.WatchDismissActions;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;
import com.tencent.widget.RecentDynamicAvatarView;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.os.MqqHandler;

public class AIOGalleryScene
  extends AbstractGalleryScene
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, MsgRevokeListener, ProGallery.OnProGalleryGestureListener, VideoPlayController.VideoPlayerStateListener, VideoPlayControllerForAIO.OnDownloadListener, INetInfoHandler, ActionSheet.WatchDismissActions
{
  final int jdField_a_of_type_Int = -3321;
  long jdField_a_of_type_Long = 0L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new AIOGalleryScene.7(this);
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AIOGalleryAdapter jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
  AIOGalleryScene.RawPhotoProgress jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress;
  protected AIOGalleryScene.UIState a;
  AIOImageListModel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
  AIORichMediaData jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
  IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  VideoPlayControllerForAIO jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO = new VideoPlayControllerForFile();
  private INonMainProcAvatarLoader jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader;
  ShareActionSheetBuilder jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  TVKVideoController jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController;
  DragView jdField_a_of_type_ComTencentWidgetDragView;
  RecentDynamicAvatarView jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
  final Runnable jdField_a_of_type_JavaLangRunnable = new AIOGalleryScene.2(this);
  String jdField_a_of_type_JavaLangString;
  final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new AIOGalleryScene.8(this);
  boolean jdField_a_of_type_Boolean = false;
  ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  final Runnable jdField_b_of_type_JavaLangRunnable = new AIOGalleryScene.3(this);
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  ImageButton jdField_c_of_type_AndroidWidgetImageButton;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  final int jdField_d_of_type_Int = -2147483648;
  ImageButton jdField_d_of_type_AndroidWidgetImageButton;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean = false;
  int jdField_f_of_type_Int = 1;
  String jdField_f_of_type_JavaLangString;
  boolean jdField_f_of_type_Boolean = false;
  int jdField_g_of_type_Int;
  String jdField_g_of_type_JavaLangString;
  int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  boolean jdField_h_of_type_Boolean;
  int jdField_i_of_type_Int = 5;
  boolean jdField_i_of_type_Boolean = false;
  int jdField_j_of_type_Int = 0;
  boolean jdField_j_of_type_Boolean;
  protected int k;
  boolean k;
  int jdField_l_of_type_Int;
  boolean jdField_l_of_type_Boolean = false;
  int jdField_m_of_type_Int;
  boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int = 0;
  boolean jdField_n_of_type_Boolean;
  boolean o = false;
  boolean p = false;
  protected boolean q = false;
  protected boolean r = false;
  boolean s = true;
  protected boolean t = false;
  boolean u = false;
  boolean v;
  
  public AIOGalleryScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel, IAIOImageProvider paramIAIOImageProvider, String paramString)
  {
    super(paramActivity, paramAbstractImageListModel);
    this.jdField_k_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState = new AIOGalleryScene.UIState(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = ((AIOImageListModel)paramAbstractImageListModel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    ((VideoPlayControllerForFile)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO).a(paramIAIOImageProvider);
    this.jdField_b_of_type_JavaLangString = paramString;
    if ((paramString == null) && (PeakActivity.class.isInstance(paramActivity))) {
      this.jdField_b_of_type_JavaLangString = ((IAECaptureContext)QRoute.api(IAECaptureContext.class)).getAppInterface().getCurrentAccountUin();
    }
    paramAbstractImageListModel = (PeakAppInterface)((PeakActivity)paramActivity).getAppRuntime();
    if (paramAbstractImageListModel != null) {
      ((MiniCodePeakHandler)paramAbstractImageListModel.getBusinessHandler(PeakAppInterface.jdField_c_of_type_JavaLangString)).a(paramActivity);
    }
  }
  
  private void F()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress = new AIOGalleryScene.RawPhotoProgress(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Long = ((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Int = ((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int;
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        ((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_c_of_type_Boolean = true;
        u();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Int, 4);
        return;
      }
      if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity))
        {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131693759), 0).a();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress = null;
          u();
          return;
        }
        localObject = (AIOFilePicData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (((AIOFilePicData)localObject).jdField_d_of_type_Boolean)
        {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692717), 0).a();
          u();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress = null;
          return;
        }
        if (((AIOFilePicData)localObject).jdField_e_of_type_Boolean) {
          u();
        }
        long l1 = ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize();
        if ((((AIOFilePicData)localObject).jdField_a_of_type_Long <= l1) || (!FileManagerUtil.a())) {}
      }
    }
    try
    {
      FileManagerUtil.a(false, this.jdField_a_of_type_AndroidAppActivity, new AIOGalleryScene.1(this));
      return;
    }
    catch (Throwable localThrowable) {}
    c(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Int, 20);
    this.jdField_a_of_type_ComTencentWidgetGallery.enableDoubleTap(true);
    this.jdField_a_of_type_ComTencentWidgetGallery.enableScaleGesture(true);
    return;
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      if (localObject1 != null)
      {
        if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          ((AIOFileVideoData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.c();
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.e();
          e();
          return;
        }
        Object localObject2;
        if (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
        {
          localObject1 = (AIOShortVideoData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
          if (((AIOShortVideoData)localObject1).jdField_b_of_type_Int == 0)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
            if (localObject2 != null) {
              ((IAIOImageProvider)localObject2).b(((AIOShortVideoData)localObject1).jdField_f_of_type_Long, ((AIOShortVideoData)localObject1).jdField_f_of_type_Int, 256);
            }
            u();
            return;
          }
          if (((AIOShortVideoData)localObject1).jdField_b_of_type_Int == 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.jdField_c_of_type_Boolean = false;
            u();
          }
        }
        else
        {
          if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
          {
            localObject2 = (AIOImageData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
            if (((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_c_of_type_Boolean)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
              if (localObject2 != null) {
                ((IAIOImageProvider)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Int, 4);
              }
              ((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_c_of_type_Boolean = false;
            }
            else
            {
              IAIOImageProvider localIAIOImageProvider = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
              if (localIAIOImageProvider != null) {
                localIAIOImageProvider.b(((AIOImageData)localObject2).jdField_f_of_type_Long, ((AIOImageData)localObject2).jdField_f_of_type_Int, 24);
              }
              ((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_f_of_type_Boolean = true;
            }
            u();
            return;
          }
          if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
          {
            localObject1 = (AIOFilePicData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
            if (localObject2 != null) {
              ((IAIOImageProvider)localObject2).b(((AIOFilePicData)localObject1).jdField_f_of_type_Long, ((AIOFilePicData)localObject1).jdField_f_of_type_Int, 24);
            }
            ((AIOFilePicData)localObject1).jdField_f_of_type_Boolean = false;
            c(false);
            u();
          }
        }
      }
    }
  }
  
  private void H()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
    long l1;
    if (localObject2 != null) {
      l1 = ((VideoPlayControllerForAIO)localObject2).a();
    } else {
      l1 = 0L;
    }
    if ((localObject1 != null) && ((((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
    {
      localObject1 = (AIOShortVideoData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController;
      if (localObject2 != null) {
        ((TVKVideoController)localObject2).b();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController = new TVKVideoController(this.jdField_a_of_type_AndroidAppActivity);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a((AIOShortVideoData)localObject1);
      if (localObject2 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController.a((VideoPlayMedioInfo)localObject2, ((AIOShortVideoData)localObject1).jdField_a_of_type_Long, l1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController.a(((AIOShortVideoData)localObject1).jdField_a_of_type_JavaLangString, ((AIOShortVideoData)localObject1).jdField_c_of_type_Int, ((AIOShortVideoData)localObject1).jdField_d_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController.a(((AIOShortVideoData)localObject1).jdField_g_of_type_Int, ((AIOShortVideoData)localObject1).jdField_c_of_type_Int, ((AIOShortVideoData)localObject1).jdField_d_of_type_Int)) {
          e();
        }
      }
      else
      {
        QLog.d("AIOGalleryScene", 1, "Failed to floating, videoPlayMedioInfo is null");
      }
    }
    else if ((localObject1 != null) && ((((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData)))
    {
      localObject1 = (AIOFileVideoData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (!com.tencent.biz.qqstory.utils.FileUtils.c(((AIOFileVideoData)localObject1).jdField_c_of_type_JavaLangString)) {
        return;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController;
      if (localObject2 != null) {
        ((TVKVideoController)localObject2).b();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController = new TVKVideoController(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController.a(((AIOFileVideoData)localObject1).jdField_c_of_type_JavaLangString, ((AIOFileVideoData)localObject1).jdField_f_of_type_Long, l1);
      if (com.tencent.mobileqq.utils.FileUtils.fileExistsAndNotEmpty(((AIOFileVideoData)localObject1).jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController.a(((AIOFileVideoData)localObject1).jdField_b_of_type_JavaLangString, ((AIOFileVideoData)localObject1).jdField_a_of_type_Int, ((AIOFileVideoData)localObject1).jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController.a(((AIOFileVideoData)localObject1).jdField_g_of_type_Int, ((AIOFileVideoData)localObject1).jdField_a_of_type_Int, ((AIOFileVideoData)localObject1).jdField_b_of_type_Int)) {
        e();
      }
    }
  }
  
  private void I()
  {
    this.jdField_c_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_c_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131700251));
    this.jdField_c_of_type_AndroidWidgetImageButton.setId(2131374213);
    this.jdField_c_of_type_AndroidWidgetImageButton.setImageResource(2130846471);
    this.jdField_c_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
    this.jdField_c_of_type_AndroidWidgetImageButton.setPadding(32, 12, 32, 12);
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.topMargin = ((int)TypedValue.applyDimension(1, 10.0F, (DisplayMetrics)localObject));
    localLayoutParams.leftMargin = ((int)TypedValue.applyDimension(1, 24.0F, (DisplayMetrics)localObject));
    localObject = (AIORichMediaData)this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras().getParcelable("extra.EXTRA_CURRENT_IMAGE");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetImageButton, localLayoutParams);
    this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    a(false);
  }
  
  private void J()
  {
    int i1 = this.jdField_g_of_type_Int;
    String str;
    if (i1 != 0) {
      if (i1 != 1)
      {
        if ((i1 != 1000) && (i1 != 1004)) {
          if (i1 != 3000)
          {
            if (i1 != 10008)
            {
              localObject = "";
              break label98;
            }
          }
          else
          {
            str = this.jdField_d_of_type_JavaLangString;
            localObject = str;
            if (!TextUtils.isEmpty(str)) {
              break label98;
            }
            localObject = this.jdField_c_of_type_JavaLangString;
            break label98;
          }
        }
      }
      else
      {
        str = this.jdField_d_of_type_JavaLangString;
        localObject = str;
        if (!TextUtils.isEmpty(str)) {
          break label98;
        }
        localObject = this.jdField_c_of_type_JavaLangString;
        break label98;
      }
    }
    Object localObject = this.jdField_c_of_type_JavaLangString;
    label98:
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    i1 = this.jdField_g_of_type_Int;
    if (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
      str = this.jdField_c_of_type_JavaLangString;
    } else {
      str = this.jdField_h_of_type_JavaLangString;
    }
    MiniChatActivity.a(localActivity, i1, (String)localObject, str);
  }
  
  private void K()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if ((i3 >= i1) && (i3 <= i2 + i1 - 1))
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i3 - i1);
      if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localObject))
      {
        localObject = (AIOGalleryAdapter.GalleryImageStruct)localObject;
        if ((((AIOGalleryAdapter.GalleryImageStruct)localObject).a() instanceof URLDrawable))
        {
          localObject = ((URLDrawable)((AIOGalleryAdapter.GalleryImageStruct)localObject).a()).getCurrDrawable();
          if ((localObject != null) && ((localObject instanceof VideoDrawable))) {
            ((VideoDrawable)localObject).resetAndPlayAudioCircle();
          }
        }
      }
    }
  }
  
  private int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    int i1 = 5;
    if (localObject != null)
    {
      if ((localObject instanceof AIOFilePicData)) {
        return 2;
      }
      if ((localObject instanceof AIOImageData))
      {
        if (((AIOImageData)localObject).jdField_h_of_type_Boolean) {
          return i1;
        }
        return 1;
      }
      if ((localObject instanceof AIOShortVideoData))
      {
        localObject = (AIOShortVideoData)localObject;
        if (((AIOShortVideoData)localObject).jdField_b_of_type_Int == 0) {
          return 4;
        }
        if (((AIOShortVideoData)localObject).jdField_b_of_type_Int == 1) {
          return 3;
        }
      }
      else if ((localObject instanceof AIOFileVideoData))
      {
        return 5;
      }
    }
    i1 = -1;
    return i1;
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if ((paramInt != 1004) && (paramInt != 1008) && (paramInt != 1009) && (paramInt != 1010) && (paramInt != 1011) && (paramInt != 1020) && (paramInt != 1021) && (paramInt != 1022) && (paramInt != 1023) && (paramInt != 1024) && (paramInt != 1025) && (paramInt != 1036) && (paramInt != 10002) && (paramInt != 10003) && (paramInt != 10004)) {
      return 4;
    }
    return 3;
  }
  
  private int a(String paramString)
  {
    int i1 = this.jdField_k_of_type_Int;
    if (i1 != 1)
    {
      if (i1 != 2) {
        if (i1 != 3) {
          if (i1 == 5) {}
        }
      }
      do
      {
        for (;;)
        {
          return -1;
          if ("0X8009EFC".equals(paramString)) {
            return 6;
          }
          if ("0X8009EFD".equals(paramString))
          {
            break;
            if ("0X8009EFC".equals(paramString)) {
              return 4;
            }
            "0X8009EFD".equals(paramString);
          }
        }
        if ("0X8009EFC".equals(paramString)) {
          return 5;
        }
      } while (!"0X8009EFD".equals(paramString));
      return 4;
    }
    return 1;
  }
  
  private AIOGalleryAdapter.GalleryImageStruct a()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if ((i3 >= i1) && (i3 <= i2 + i1 - 1))
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i3 - i1);
      if ((localView instanceof AIOGalleryAdapter.GalleryImageStruct)) {
        return (AIOGalleryAdapter.GalleryImageStruct)localView;
      }
    }
    return null;
  }
  
  private <T extends AIORichMediaInfo> T a(long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().iterator();
    while (localIterator.hasNext())
    {
      AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
      if ((localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramLong1) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int == paramLong2)) {
        return localAIORichMediaInfo;
      }
    }
    return null;
  }
  
  private ProgressPieDrawable a(Context paramContext)
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(paramContext);
    localProgressPieDrawable.a(AIOUtils.b(50.0F, paramContext.getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.g(-1);
    localProgressPieDrawable.f(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.i(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new AIOGalleryScene.29(this));
    return localProgressPieDrawable;
  }
  
  private File a(AIORichMediaData paramAIORichMediaData)
  {
    Object localObject2;
    Object localObject1;
    if ((paramAIORichMediaData instanceof AIOImageData))
    {
      localObject2 = paramAIORichMediaData.a(4);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramAIORichMediaData.a(2);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        return paramAIORichMediaData.a(1);
      }
    }
    else if ((paramAIORichMediaData instanceof AIOFilePicData))
    {
      localObject2 = paramAIORichMediaData.a(20);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramAIORichMediaData.a(18);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        return paramAIORichMediaData.a(16);
      }
    }
    else
    {
      localObject2 = null;
    }
    return localObject2;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_AndroidAppActivity.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = paramString;
    paramArrayList.add(localActionSheetItem);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_AndroidAppActivity.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = "";
    paramArrayList.add(localActionSheetItem);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList, int paramInt4)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_AndroidAppActivity.getString(paramInt1);
    localActionSheetItem.icon = paramInt2;
    localActionSheetItem.action = paramInt3;
    localActionSheetItem.argus = "";
    localActionSheetItem.firstLineCount = paramInt4;
    paramArrayList.add(localActionSheetItem);
  }
  
  private void a(int paramInt, File paramFile)
  {
    if (paramInt != 1) {
      if (paramInt != 2) {
        localObject1 = null;
      }
    }
    for (;;)
    {
      break;
      localObject1 = "0X8007A25";
      continue;
      localObject1 = "0X8007A24";
    }
    if (localObject1 != null) {
      ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
    }
    Object localObject1 = (PeakActivity)this.jdField_a_of_type_AndroidAppActivity;
    if (this.jdField_a_of_type_AndroidAppActivity.getIntent() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "save video failed, intent is null");
      }
      QQToast.a((Context)localObject1, 1, HardCodeUtil.a(2131700270), 0).a();
      return;
    }
    NativeVideoImage.pauseAll();
    paramInt = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if ((i2 >= paramInt) && (i2 <= i1 + paramInt - 1))
    {
      localObject2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i2 - paramInt);
      if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localObject2)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i2, (AIOGalleryAdapter.GalleryImageStruct)localObject2);
      }
    }
    Object localObject2 = ShortVideoUtils.getLocalShortVideoPath();
    a((Activity)localObject1, HardCodeUtil.a(2131700269), false, 0);
    if (com.tencent.biz.qqstory.utils.FileUtils.a(BaseApplication.getContext(), paramFile.getAbsolutePath(), (String)localObject2)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(10000);
    } else {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(10001);
    }
    ReportController.b(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
  }
  
  private void a(long paramLong, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if ((((AIORichMediaData)localObject).jdField_f_of_type_Long == paramLong) && (((AIORichMediaData)localObject).jdField_f_of_type_Int == paramInt))
    {
      if (this.jdField_a_of_type_AndroidWidgetSeekBar != null)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetTextView;
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131700260));
          double d1 = this.jdField_h_of_type_Int;
          Double.isNaN(d1);
          localStringBuilder.append(d1 / 100.0D);
          localStringBuilder.append("%");
          ((TextView)localObject).setText(localStringBuilder.toString());
          this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.jdField_h_of_type_Int);
        }
      }
      return;
    }
    localObject = a(paramLong, paramInt);
    if (localObject != null) {
      ((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_a_of_type_Int = this.jdField_h_of_type_Int;
    }
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if ((((AIORichMediaData)localObject).jdField_f_of_type_Long == paramLong1) && (((AIORichMediaData)localObject).jdField_f_of_type_Int == paramInt1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_Int = paramInt3;
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131700254));
      double d1 = paramLong2;
      double d2 = paramInt3;
      Double.isNaN(d2);
      d2 /= 10000.0D;
      Double.isNaN(d1);
      localStringBuilder.append(FileUtil.a((d1 * d2)));
      localStringBuilder.append("/");
      localStringBuilder.append(FileUtil.a(paramLong2));
      localStringBuilder.append(")");
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt3);
      return;
    }
    localObject = a(paramLong1, paramInt1);
    if (localObject != null) {
      ((AIORichMediaInfo)localObject).jdField_a_of_type_Int = paramInt3;
    }
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if ((((AIORichMediaData)localObject).jdField_f_of_type_Long == paramLong) && (((AIORichMediaData)localObject).jdField_f_of_type_Int == paramInt1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("save pic result = ");
        ((StringBuilder)localObject).append(paramInt3);
        ((StringBuilder)localObject).append(", resultStr = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt3 == 1) {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131718379), 0).a();
      } else {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131718375), 0).a();
      }
      u();
    }
    else
    {
      paramString = a(paramLong, paramInt1);
      if (paramString != null) {
        paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_e_of_type_Boolean = false;
      }
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress;
    if ((paramString != null) && (paramString.jdField_a_of_type_Long == paramLong) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Int == paramInt1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress = null;
    }
  }
  
  private void a(long paramLong, int paramInt, String paramString)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a())
    {
      AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(i1);
      if ((localAIORichMediaInfo != null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
      {
        AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramLong)
        {
          if (paramInt == 1)
          {
            localAIOFileVideoData.jdField_c_of_type_Boolean = true;
            localAIOFileVideoData.jdField_d_of_type_Boolean = false;
            localAIOFileVideoData.jdField_c_of_type_JavaLangString = paramString;
          }
          else if (paramInt == 2)
          {
            localAIOFileVideoData.jdField_c_of_type_Boolean = false;
          }
          u();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() == localAIORichMediaInfo) {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.b(0);
          }
        }
      }
      i1 += 1;
    }
  }
  
  private void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    int i1 = 0;
    while (i1 < ((List)localObject).size())
    {
      AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)((List)localObject).get(i1);
      if ((localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramLong) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int == paramInt))
      {
        paramInt = this.jdField_h_of_type_Int;
        localAIORichMediaInfo.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(i1, paramInt / 100);
        if (paramBoolean)
        {
          paramInt = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
          int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
          if ((i1 >= paramInt) && (i1 <= i2 + paramInt - 1))
          {
            localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i1 - paramInt);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i1, (View)localObject, paramBoolean);
          }
        }
        return;
      }
      i1 += 1;
    }
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    if (!AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
      return;
    }
    Object localObject2 = (AIOFilePicData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    ((AIOFilePicData)localObject2).jdField_f_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress = new AIOGalleryScene.RawPhotoProgress(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Long = ((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Int = ((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int;
    }
    if ((((AIOFilePicData)localObject2).jdField_f_of_type_Long == paramLong1) && (this.jdField_a_of_type_AndroidWidgetSeekBar != null))
    {
      c(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_Int = this.jdField_h_of_type_Int;
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131700287));
      double d1 = paramLong2;
      double d2 = this.jdField_h_of_type_Int;
      Double.isNaN(d2);
      d2 /= 10000.0D;
      Double.isNaN(d1);
      ((StringBuilder)localObject2).append(FileUtil.a((d1 * d2)));
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(FileUtil.a(paramLong2));
      ((StringBuilder)localObject2).append(")");
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.jdField_h_of_type_Int);
    }
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    int i1 = 0;
    while (i1 < ((List)localObject).size())
    {
      AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)((List)localObject).get(i1);
      if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramLong)
      {
        int i2 = this.jdField_h_of_type_Int;
        localAIORichMediaInfo.jdField_a_of_type_Int = i2;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(i1, i2 / 100);
        if (paramBoolean)
        {
          i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
          int i3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
          if ((i1 >= i2) && (i1 <= i3 + i2 - 1))
          {
            localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i1 - i2);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i1, (View)localObject, paramBoolean);
          }
        }
        return;
      }
      i1 += 1;
    }
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    long l1;
    if ((paramInt2 != 1) && (paramInt2 != 3000)) {
      l1 = paramLong1;
    } else {
      l1 = paramLong2;
    }
    Object localObject2 = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("jumpToTargetAIOPosition, className = ");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(", time = ");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(" , shmsgseq = ");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(", isEmotion = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("need_jump_to_msg", true);
    ((Bundle)localObject1).putLong("searched_timeorseq", l1);
    ((Bundle)localObject1).putLong("searched_time", paramLong1);
    ((Bundle)localObject1).putLong("target_shmsgseq", paramLong2);
    ((Bundle)localObject1).putBoolean("searched_update_session", true);
    Intent localIntent = new Intent();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localIntent.setClassName(paramActivity, (String)localObject2);
    } else {
      localIntent.setClass(paramActivity, SplashActivity.class);
    }
    int i1 = paramActivity.getIntent().getIntExtra("extra.EXTRA_ENTRANCE", -1);
    boolean bool1;
    if ((i1 != 2) && (i1 != 3)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool3 = paramActivity.getIntent().getBooleanExtra("from_chat_history", false);
    boolean bool2;
    if (paramBoolean) {
      bool2 = bool3;
    } else {
      bool2 = bool1;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("jumpToTargetAIOPosition, isFromHistory = ");
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append(", isEmotion = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(", sourceEntrance = ");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append(", fromHistory_picAndVideo = ");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(", fromHistory_emotion = ");
      ((StringBuilder)localObject2).append(bool3);
      QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject2).toString());
    }
    if (bool2)
    {
      paramInt1 = paramActivity.getIntent().getIntExtra("FromChatHistoryTab", 0);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("jumpToTargetAIOPosition, fromType = ");
        ((StringBuilder)localObject2).append(paramInt1);
        QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject2).toString());
      }
      if ((paramInt1 != 2) && (paramInt1 != 4))
      {
        localIntent.putExtras((Bundle)localObject1);
        paramActivity.setResult(-1, localIntent);
        paramActivity.finish();
        return;
      }
      if (paramInt2 == 1)
      {
        ChatHistoryBubbleListForTroopFragment.a(paramActivity, paramString2, paramLong2, -1, 0);
        return;
      }
      ChatHistoryActivity.a(paramActivity, paramString1, paramInt2, "", paramLong1, paramLong2, 0);
      return;
    }
    localIntent = AIOUtils.a(localIntent, null);
    localIntent.putExtras((Bundle)localObject1);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("troop_uin", paramString2);
    localIntent.addFlags(603979776);
    localIntent.putExtra("entrance", 1);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
    paramBundle = new Bundle(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "AIOGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
    }
    paramBundle.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    paramBundle.putBoolean("PhotoConst.IS_FORWARD", true);
    paramBundle.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    paramBundle.putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtras(paramBundle);
    String str = paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(str);
    PhotoUtils.sendPhoto(paramActivity, localIntent, localArrayList, paramBundle.getInt("PhotoConst.SEND_SIZE_SPEC", 0), true);
  }
  
  private void a(Dialog paramDialog)
  {
    if ((paramDialog != null) && (this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      try
      {
        paramDialog.show();
        return;
      }
      catch (Throwable paramDialog)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("showDialogSafe exception: ");
          localStringBuilder.append(paramDialog.getMessage());
          QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  private void a(Uri paramUri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        return;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
      SparseArray localSparseArray = new SparseArray(2);
      AIOGalleryAdapter.GalleryImageStruct localGalleryImageStruct = null;
      Object localObject3 = null;
      int i2;
      Object localObject2;
      if ((localObject1 instanceof AIOGalleryAdapter.GalleryImageStruct))
      {
        localGalleryImageStruct = (AIOGalleryAdapter.GalleryImageStruct)localObject1;
        i2 = localGalleryImageStruct.getWidth();
        int i3 = localGalleryImageStruct.getHeight();
        if (i2 >= i3 * 2) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i3 >= i2 * 2) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if (i1 == 0)
        {
          localObject1 = localObject3;
          if (i2 == 0) {}
        }
        else
        {
          localObject1 = new Matrix();
          ((Matrix)localObject1).set(this.jdField_a_of_type_ComTencentWidgetGallery.getChildMatrix(localGalleryImageStruct));
          Rect localRect = new Rect(localGalleryImageStruct.getLeft(), localGalleryImageStruct.getTop(), localGalleryImageStruct.getRight(), localGalleryImageStruct.getBottom());
          try
          {
            localObject1 = localGalleryImageStruct.a(localRect, (Matrix)localObject1, this.jdField_a_of_type_ComTencentWidgetGallery.getWidth(), this.jdField_a_of_type_ComTencentWidgetGallery.getHeight());
          }
          catch (Throwable localThrowable)
          {
            localObject1 = localObject3;
            if (QLog.isColorLevel())
            {
              QLog.i("AIOGalleryScene", 2, localThrowable.getMessage(), localThrowable);
              localObject1 = localObject3;
            }
          }
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          i2 = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeQQCodeFromBmp((Bitmap)localObject1, 3, localSparseArray) | 0x0;
          i1 = i2;
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break label311;
          }
          QLog.i("AIOGalleryScene", 2, String.format("checkQQCode bmp!=null result=%d", new Object[] { Integer.valueOf(i2) }));
          i1 = i2;
          localObject2 = localObject1;
          break label311;
        }
      }
      int i1 = 0;
      label311:
      if (localObject2 == null)
      {
        i2 = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(paramUri, this.jdField_a_of_type_AndroidAppActivity, 3, localSparseArray);
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.i("AIOGalleryScene", 2, String.format("checkQQCode bmp=null result=%d", new Object[] { Integer.valueOf(i2) }));
          i1 = i2;
        }
      }
      ThreadManager.getUIHandler().post(new AIOGalleryScene.21(this, i1, localSparseArray, paramArrayList));
      if (i1 > 0) {
        this.jdField_f_of_type_JavaLangString = paramUri.getPath();
      }
      ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).onAIOScanRecogTypeReport(i1);
    }
  }
  
  private void a(View paramView)
  {
    paramView = (ImageView)paramView;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData))
    {
      if (((AIOShortVideoData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
        if (localObject != null)
        {
          ((VideoPlayControllerForAIO)localObject).f();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.c()) {
            paramView.setImageResource(2130846309);
          } else {
            paramView.setImageResource(2130846308);
          }
          this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
        }
      }
      else
      {
        localObject = a();
        if (localObject != null)
        {
          Drawable localDrawable = ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
          if ((localDrawable instanceof URLDrawable))
          {
            int i1 = ((URLDrawable)localDrawable).getPlayState();
            int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
            if (i1 == 2)
            {
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(i2);
              paramView.setImageResource(2130846308);
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              return;
            }
            if (i1 == 4)
            {
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(i2);
              paramView.setImageResource(2130846309);
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              return;
            }
            if (i1 == 6)
            {
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(i2);
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              paramView.setImageResource(2130846309);
              return;
            }
            if (i1 == -1)
            {
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(i2);
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              paramView.setImageResource(2130846309);
            }
          }
        }
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
      if (localObject != null)
      {
        ((VideoPlayControllerForAIO)localObject).f();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.c()) {
          paramView.setImageResource(2130846309);
        } else {
          paramView.setImageResource(2130846308);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
      }
    }
  }
  
  private void a(AIOFilePicData paramAIOFilePicData)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    if (paramAIOFilePicData.jdField_a_of_type_Long > 10485760) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
    } else if ((paramAIOFilePicData.a(18) == null) && (paramAIOFilePicData.a(20) == null)) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
    }
    if (FileUtil.a(paramAIOFilePicData.jdField_d_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_g_of_type_Boolean) {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
    } else {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    if (paramAIOFilePicData.jdField_f_of_type_Boolean)
    {
      d(false);
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
  
  private void a(AIOFilePicData paramAIOFilePicData, int paramInt)
  {
    Object localObject2 = paramAIOFilePicData.a(20);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramAIOFilePicData.a(18);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramAIOFilePicData.a(16);
    }
    if ((localObject2 == null) && (this.u)) {
      return;
    }
    a(paramAIOFilePicData, (File)localObject2, paramInt);
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a(8, "");
    this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
    a(true);
    if ((paramAIOFileVideoData.jdField_c_of_type_Boolean) || (paramAIOFileVideoData.a()))
    {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    if (paramAIOFileVideoData.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a(0, paramAIOFileVideoData.a());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (paramAIOFileVideoData.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (!paramAIOFileVideoData.a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.b(8);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.b(0);
      }
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if (this.jdField_k_of_type_Int == 3) {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(2131692767, 2130840161, 59, localArrayList1);
    a(2131692777, 2130840170, 53, localArrayList1);
    ReportController.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
    a(2131692769, 2130844370, 67, localArrayList1);
    a(2131692779, 2130840171, 58, localArrayList1);
    a(2131692766, 2130840160, 57, localArrayList1);
    if ((this.jdField_g_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.s)) {
      a(2131692781, 2130840172, 54, localArrayList2);
    }
    if (FileUtil.a(paramAIOFileVideoData.jdField_c_of_type_JavaLangString)) {
      a(2131692773, 2130840166, 64, localArrayList2, 5);
    }
    a(paramAIOFileVideoData, null, false);
    paramAIOFileVideoData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramAIOFileVideoData);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
  }
  
  private void a(AIOImageData paramAIOImageData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "action sheet add to favorite.");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_md5", paramAIOImageData.jdField_f_of_type_JavaLangString);
    paramAIOImageData = new AIOGalleryScene.11(this);
    QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_add_fav", localBundle, paramAIOImageData);
    if (this.jdField_h_of_type_Boolean) {
      VasWebviewUtil.a("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  private void a(AIOImageData paramAIOImageData, int paramInt, AIORichMediaInfo paramAIORichMediaInfo)
  {
    if ((paramAIOImageData.jdField_g_of_type_Int == 1) && (paramAIOImageData.jdField_h_of_type_Boolean))
    {
      Object localObject = paramAIOImageData.a(4);
      paramAIORichMediaInfo = (AIORichMediaInfo)localObject;
      if (localObject == null) {
        paramAIORichMediaInfo = paramAIOImageData.a(2);
      }
      localObject = paramAIORichMediaInfo;
      if (paramAIORichMediaInfo == null) {
        localObject = paramAIOImageData.a(1);
      }
      if ((localObject == null) && (this.u)) {
        return;
      }
      a(paramAIOImageData, (File)localObject, paramInt);
      return;
    }
    d(paramAIORichMediaInfo);
  }
  
  private void a(AIOImageData paramAIOImageData, AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a(false);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOImageData.jdField_f_of_type_Long, paramAIOImageData.jdField_f_of_type_Int);
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131700262));
      localStringBuilder.append(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_a_of_type_Int);
      localStringBuilder.append("%");
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    else if (paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700250));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_e_of_type_Boolean = false;
    }
    else if ((i1 != -1) && (!paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_f_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
      double d1 = i1;
      Double.isNaN(d1);
      ((SeekBar)localObject).setProgress((int)(d1 / 100.0D * 10000.0D));
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131700263));
      localStringBuilder.append(i1);
      localStringBuilder.append("%");
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    else
    {
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
      } else {
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
      if ((paramAIOImageData.a(4)) && (paramAIOImageData.a(4) == null)) {
        d(true);
      } else {
        d(false);
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      if ((paramAIOImageData.a(2) == null) && (paramAIOImageData.a(4) == null)) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      } else {
        this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(true);
      }
    }
    if (paramAIOImageData.jdField_b_of_type_Int == 3)
    {
      if (!AIOImageData.class.isInstance(paramAIOImageData)) {
        return;
      }
      if (paramAIOImageData.jdField_f_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "troop show pic file, file is progressive");
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
        localObject = this.jdField_b_of_type_AndroidWidgetTextView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131700293));
        localStringBuilder.append(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_a_of_type_Int);
        localStringBuilder.append("%");
        ((TextView)localObject).setText(localStringBuilder.toString());
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress = new AIOGalleryScene.RawPhotoProgress(this);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Long = paramAIOImageData.jdField_f_of_type_Long;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Int = paramAIOImageData.jdField_f_of_type_Int;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_c_of_type_Boolean = true;
          paramAIOImageData.jdField_f_of_type_Boolean = false;
        }
      }
    }
  }
  
  private void a(AIOImageData paramAIOImageData, AIORichMediaInfo paramAIORichMediaInfo, File paramFile)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(new AIOGalleryScene.9(this, paramAIOImageData, paramAIORichMediaInfo, paramFile));
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new AIOGalleryScene.10(this));
  }
  
  private void a(AIORichMediaData paramAIORichMediaData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder())
    {
      Intent localIntent1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIORichMediaData.jdField_f_of_type_Long, paramAIORichMediaData.jdField_f_of_type_Int, 0);
      if (localIntent1 == null)
      {
        QLog.w("AIOGalleryScene", 1, "getForwardData return null from main process");
        return;
      }
      localIntent1.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
      int i1;
      if (paramAIORichMediaData.jdField_g_of_type_Int == 1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 == 0)
      {
        localIntent1.putExtra("filepictest", true);
        paramAIORichMediaData = (ForwardFileInfo)localIntent1.getParcelableExtra("fileinfo");
        String str1 = localIntent1.getStringExtra("forward_filepath");
        boolean bool1 = localIntent1.getBooleanExtra("k_favorites", false);
        String str2 = localIntent1.getStringExtra("forward_text");
        boolean bool2 = localIntent1.getBooleanExtra("isFromShare", false);
        i1 = localIntent1.getIntExtra("forward_type", 0);
        Intent localIntent2 = new Intent();
        localIntent2.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
        Bundle localBundle = new Bundle();
        localBundle.putInt("forward_type", i1);
        localBundle.putParcelable("fileinfo", paramAIORichMediaData);
        localBundle.putBoolean("not_forward", true);
        localIntent2.putExtras(localBundle);
        localIntent2.putExtra("forward_filepath", str1);
        localIntent2.putExtra("forward_text", str2);
        localIntent2.putExtra("k_favorites", bool1);
        localIntent2.putExtra("isFromShare", bool2);
        if (AIOFilePicData.class.isInstance(localIntent1))
        {
          localIntent2.putExtra("isPic", true);
          localIntent2.putExtra("direct_send_if_dataline_forward", true);
        }
        ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, localIntent1, 103);
        return;
      }
      ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, localIntent1, 21);
    }
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, File paramFile)
  {
    if (AIOFilePicData.class.isInstance(paramAIORichMediaData))
    {
      AIOGalleryUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramFile, Utils.Crc64String(paramFile.getAbsolutePath()));
      return;
    }
    if (AIOFileVideoData.class.isInstance(paramAIORichMediaData))
    {
      paramFile = new Bundle();
      float f1 = 0.0F;
      if (VideoPlayControllerForFile.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO)) {
        f1 = ((VideoPlayControllerForFile)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO).a(paramAIORichMediaData.jdField_f_of_type_Long);
      }
      paramFile.putFloat("progress", f1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIORichMediaData.jdField_f_of_type_Long, 13, paramFile);
      ((AIOFileVideoData)paramAIORichMediaData).jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.h();
      u();
      return;
    }
    if (AIOImageData.class.isInstance(paramAIORichMediaData))
    {
      if ((paramFile != null) && (paramFile.exists()))
      {
        AIOGalleryUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramFile, Utils.Crc64String(paramFile.getAbsolutePath()));
        return;
      }
      QLog.i("AIOGalleryScene", 1, "menu item click, troop file action AIOGallerysence, but file is null");
    }
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, File paramFile, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    a(2131692767, 2130840161, 59, localArrayList1);
    if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(paramFile))) {
      a(2131692778, 2130847036, 69, localArrayList1);
    }
    a(2131692777, 2130840170, 53, localArrayList1);
    ReportController.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
    a(2131692769, 2130844370, 67, localArrayList1);
    a(2131692779, 2130840171, 58, localArrayList1);
    a(2131692766, 2130840160, 57, localArrayList1);
    if ((this.jdField_g_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.s)) {
      a(2131692781, 2130840172, 54, localArrayList2);
    }
    if (this.jdField_f_of_type_Boolean) {
      a(2131692772, 2130840165, 52, localArrayList2, 2);
    }
    ThreadManager.getFileThreadHandler().post(new AIOGalleryScene.20(this, paramFile, localArrayList2));
    a(paramAIORichMediaData, paramFile, true);
    paramAIORichMediaData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramAIORichMediaData);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, File paramFile, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(new AIOGalleryScene.22(this, paramAIORichMediaData, paramBoolean, paramFile));
  }
  
  private void a(AIORichMediaData paramAIORichMediaData, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("preResult", paramString);
    if (AIOImageData.class.isInstance(paramAIORichMediaData))
    {
      paramAIORichMediaData = (AIOImageData)paramAIORichMediaData;
      a(this.jdField_f_of_type_JavaLangString, paramAIORichMediaData.jdField_g_of_type_Int, paramAIORichMediaData.jdField_h_of_type_Boolean, paramAIORichMediaData.k, paramAIORichMediaData.jdField_f_of_type_JavaLangString, paramAIORichMediaData.j, paramAIORichMediaData.jdField_e_of_type_JavaLangString, 2, localIntent);
      return;
    }
    if (AIOFilePicData.class.isInstance(paramAIORichMediaData))
    {
      paramString = (AIOFilePicData)paramAIORichMediaData;
      if (MessageRecordInfo.a(paramString.jdField_b_of_type_Int)) {
        paramAIORichMediaData = this.jdField_b_of_type_JavaLangString;
      } else {
        paramAIORichMediaData = this.jdField_c_of_type_JavaLangString;
      }
      a(this.jdField_f_of_type_JavaLangString, paramString.jdField_a_of_type_Int, true, paramAIORichMediaData, null, null, paramString.jdField_h_of_type_JavaLangString, 2, localIntent);
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a(true);
    if (this.jdField_g_of_type_Boolean) {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
    } else {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    Object localObject = (AIOShortVideoData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (((AIOShortVideoData)localObject).jdField_b_of_type_Int == 0)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOShortVideoData)localObject).jdField_f_of_type_Long, ((AIOShortVideoData)localObject).jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a(8, "");
      if (paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.longVideoSaving");
        }
        paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700286));
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      if (i1 != -1)
      {
        paramAIORichMediaInfo = this.jdField_a_of_type_AndroidWidgetSeekBar;
        double d1 = i1;
        Double.isNaN(d1);
        paramAIORichMediaInfo.setProgress((int)(d1 / 100.0D * 10000.0D));
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      if (paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_d_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.longVideoBuffering");
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        return;
      }
      if (!paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_g_of_type_Boolean)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateUI selectedItem.hasEnterPlaying longVideoDownloading=");
          ((StringBuilder)localObject).append(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_h_of_type_Boolean);
          ((StringBuilder)localObject).append(" selectedItem.state=");
          ((StringBuilder)localObject).append(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState);
          ((StringBuilder)localObject).append(" longVideoGetUrl=");
          ((StringBuilder)localObject).append(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_j_of_type_Boolean);
          QLog.i("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_h_of_type_Boolean) {
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        if (paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_j_of_type_Boolean) {
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
      }
      else
      {
        if (paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_k_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a(0, ((AIOShortVideoData)localObject).a());
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_k_of_type_Boolean = false;
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AIOGalleryScene", 2, "updateUI selectedItem.else");
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
    else if (((AIOShortVideoData)localObject).jdField_b_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      if (!paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_g_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_i_of_type_Boolean) {
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo, File paramFile)
  {
    try
    {
      paramAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int);
      if (paramAIORichMediaInfo == null) {
        QfavBuilder.b(paramFile.getAbsolutePath()).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString);
      } else {
        new QfavBuilder(paramAIORichMediaInfo).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString);
      }
      QfavReport.a(null, 40, 3);
      return;
    }
    catch (RemoteException paramAIORichMediaInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AIOGalleryScene", 2, "", paramAIORichMediaInfo);
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_AndroidAppActivity.getString(2131692762), 0).a();
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo, String paramString1, String[] paramArrayOfString, String paramString2, View paramView)
  {
    AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (localAIOFileVideoData.jdField_a_of_type_Boolean)
    {
      paramString1 = new StringBuilder();
      paramString1.append("filevideo is playing:");
      paramString1.append(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
      QLog.i("VideoPlayControllerForFile", 1, paramString1.toString());
      return;
    }
    localAIOFileVideoData.jdField_a_of_type_Boolean = true;
    if ("I:E".equals(paramString1)) {}
    try
    {
      localAIOFileVideoData.jdField_b_of_type_Long = Long.parseLong(paramArrayOfString[0]);
      paramString1 = paramArrayOfString[1];
      localAIOFileVideoData.a(paramString1);
      if (localAIOFileVideoData.jdField_b_of_type_Long == -134L)
      {
        paramAIORichMediaInfo = this.jdField_a_of_type_AndroidAppActivity.getString(2131719103);
      }
      else
      {
        paramAIORichMediaInfo = paramString1;
        if (localAIOFileVideoData.jdField_b_of_type_Long != -7003L) {
          if (localAIOFileVideoData.jdField_b_of_type_Long == -6101L) {
            paramAIORichMediaInfo = paramString1;
          }
        }
      }
    }
    catch (NumberFormatException paramAIORichMediaInfo)
    {
      for (;;)
      {
        continue;
        paramAIORichMediaInfo = paramString1;
        int i1 = 0;
        continue;
        i1 = 1;
      }
    }
    if (i1 != 0)
    {
      paramAIORichMediaInfo = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, "", paramAIORichMediaInfo, null, HardCodeUtil.a(2131700264), new AIOGalleryScene.30(this), null);
      if (!paramAIORichMediaInfo.isShowing()) {
        paramAIORichMediaInfo.show();
      }
      return;
      localAIOFileVideoData.jdField_b_of_type_Long = -1L;
    }
    localAIOFileVideoData.jdField_g_of_type_JavaLangString = paramArrayOfString[1];
    break label239;
    localAIOFileVideoData.jdField_d_of_type_JavaLangString = paramArrayOfString[0];
    localAIOFileVideoData.jdField_f_of_type_JavaLangString = paramString1;
    localAIOFileVideoData.jdField_e_of_type_JavaLangString = paramString2;
    label239:
    paramAIORichMediaInfo = localAIOFileVideoData.a(this.r);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a(paramView, paramAIORichMediaInfo);
    if ((AIOGalleryActivity.class.isInstance(this.jdField_a_of_type_AndroidAppActivity)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(localAIOFileVideoData.jdField_f_of_type_Long)))
    {
      ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.f();
      this.r = false;
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean)
  {
    if ((paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData))
    {
      paramAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
      if ((paramAIORichMediaInfo != null) && (paramAIORichMediaInfo.c())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.h();
      }
    }
    else if ((paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData))
    {
      paramAIORichMediaInfo = (AIOShortVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (paramAIORichMediaInfo.jdField_b_of_type_Int == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "onRevokeMsg BUSI_TYPE_VIDEO");
        }
        if (paramBoolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryScene", 2, "onRevokeMsg cancelDownloadMedia");
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b(paramAIORichMediaInfo.jdField_f_of_type_Long, paramAIORichMediaInfo.jdField_f_of_type_Int, 256);
        }
        paramAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
        if ((paramAIORichMediaInfo != null) && (paramAIORichMediaInfo.c())) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.h();
        }
      }
      else if (paramAIORichMediaInfo.jdField_b_of_type_Int == 1)
      {
        paramAIORichMediaInfo = a();
        if (paramAIORichMediaInfo != null)
        {
          Drawable localDrawable = paramAIORichMediaInfo.a();
          if ((localDrawable instanceof URLDrawable))
          {
            int i1 = ((URLDrawable)localDrawable).getPlayState();
            int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
            if (i1 == 2) {
              paramAIORichMediaInfo.b(i2);
            }
          }
        }
      }
    }
    else if (((paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) && (paramBoolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, 24);
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo, String[] paramArrayOfString, String paramString, View paramView, MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("carverW notifyVideoUrl setShortVideoDrawableWithUrls ,AIOShortVideoData id=");
      localStringBuilder.append(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    LongVideoUrlCacheManager.a().a(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, paramArrayOfString, System.currentTimeMillis(), paramMessageForShortVideo, paramInt, paramString);
    paramString = new VideoPlayMedioInfo();
    paramString.jdField_a_of_type_Boolean = true;
    paramString.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    paramString.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    paramString.jdField_a_of_type_Int = paramInt;
    paramString.jdField_a_of_type_Long = paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long;
    paramString.jdField_b_of_type_Int = paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int;
    paramArrayOfString = new File(((AIOShortVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_JavaLangString);
    if (paramArrayOfString.exists()) {
      paramString.d = paramArrayOfString.length();
    } else {
      paramString.d = 0L;
    }
    if (this.r)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("setShortVideoDrawableWithUrls, dataOfBubble.id =  ");
        paramArrayOfString.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
        paramArrayOfString.append(", msg.uniseq = ");
        paramArrayOfString.append(paramMessageForShortVideo.uniseq);
        paramArrayOfString.append(", mIsmute = ");
        paramArrayOfString.append(this.r);
        QLog.d("AIOGalleryScene", 2, paramArrayOfString.toString());
      }
      paramArrayOfString = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if ((paramArrayOfString != null) && (paramArrayOfString.jdField_f_of_type_Long == paramMessageForShortVideo.uniseq))
      {
        paramString.jdField_e_of_type_Boolean = true;
        if (QLog.isColorLevel())
        {
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("setShortVideoDrawableWithUrls, set playMedioInfo.isMute =  ");
          paramArrayOfString.append(this.r);
          QLog.d("AIOGalleryScene", 2, paramArrayOfString.toString());
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a(paramView, paramString);
    paramArrayOfString = (AIOShortVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(((AIOShortVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.f();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a((AIOShortVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, false, false);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a((AIOShortVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, false, true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) && (paramArrayOfString.a(0) == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "setShortVideoDrawableWithUrls, get THUMB");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramArrayOfString.jdField_f_of_type_Long, paramArrayOfString.jdField_f_of_type_Int, 0);
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder())
    {
      paramAIOShortVideoData = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOShortVideoData.jdField_f_of_type_Long, paramAIOShortVideoData.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
      if (paramAIOShortVideoData != null)
      {
        paramAIOShortVideoData.putExtra("NeedReportForwardShortVideo", true);
        ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, paramAIOShortVideoData);
      }
    }
    if (this.jdField_c_of_type_Boolean) {
      MultiMsgUtil.a("0X8009ABC");
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, int paramInt)
  {
    File localFile = paramAIOShortVideoData.a(1);
    AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((localFile != null) && (localFile.exists()))
    {
      long l1 = localFile.length();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showActionSheetForShortVideo, file.getPath()=");
        localStringBuilder.append(localFile.getPath());
        localStringBuilder.append(", mTransferredSize = ");
        localStringBuilder.append(l1);
        localStringBuilder.append(", data.size = ");
        localStringBuilder.append(paramAIOShortVideoData.jdField_h_of_type_Long);
        QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
      }
      if (l1 >= paramAIOShortVideoData.jdField_h_of_type_Long)
      {
        i1 = 0;
        break label173;
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AIOGalleryScene", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
    }
    int i1 = 1;
    label173:
    if ((paramAIOShortVideoData.jdField_b_of_type_Int != 1) || (i1 == 0)) {
      a(2131692767, 2130840161, 59, localArrayList1);
    }
    if ((VersionUtils.d()) && ((paramAIOShortVideoData.jdField_b_of_type_Int != 1) || (i1 == 0))) {
      a(2131692777, 2130840170, 61, localArrayList1);
    }
    if (i1 == 0)
    {
      a(2131692766, 2130840160, 63, localArrayList1);
      a(2131692770, 2130840163, 60, localArrayList1);
      a(2131692779, 2130840171, 58, localArrayList1);
    }
    if ((this.jdField_g_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.s)) {
      a(2131692781, 2130840172, 62, localArrayList2);
    }
    if (i1 == 0) {
      a(2131692773, 2130840166, 64, localArrayList2, 5);
    }
    a(paramAIOShortVideoData, localFile, paramInt, localAIORichMediaInfo);
    paramAIOShortVideoData = (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramAIOShortVideoData);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (paramAIOShortVideoData != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "dealSaveVideo");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(paramAIOShortVideoData.jdField_f_of_type_Long, paramAIOShortVideoData.jdField_f_of_type_Int, 256);
    }
  }
  
  private void a(AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, AIORichMediaInfo paramAIORichMediaInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(new AIOGalleryScene.17(this, paramAIOShortVideoData, paramFile, paramInt, paramAIORichMediaInfo));
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setCancelListener(new AIOGalleryScene.18(this));
  }
  
  private void a(ActionSheet paramActionSheet, AIOImageData paramAIOImageData, File paramFile1, File paramFile2)
  {
    if ((UinTypeUtil.a(this.jdField_g_of_type_Int) == 1032) && (paramFile1 != null)) {
      paramActionSheet.addButton(2131693262);
    }
    paramActionSheet.addCancelButton(2131690728);
    paramActionSheet.setOnButtonClickListener(new AIOGalleryScene.16(this, paramActionSheet, paramAIOImageData, paramFile2));
    paramActionSheet.show();
    paramActionSheet.registerWatchDisMissActionListener(this);
  }
  
  private void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
    if (localObject != null)
    {
      a((AIORichMediaInfo)localObject);
      if ((((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4)) || (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20)))
      {
        if (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_h_of_type_Long > 0L) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131694999), new Object[] { FileUtil.a(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_h_of_type_Long) }));
        } else {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694996);
        }
        d(true);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
        if (localObject != null)
        {
          ((AIOGalleryAdapter)localObject).a(paramAdapterView, paramView, paramInt, paramLong);
          paramAdapterView = a().findViewById(2131367440);
          if (paramAdapterView != null)
          {
            if (paramAdapterView.getAnimation() != null)
            {
              paramAdapterView.getAnimation().cancel();
              paramAdapterView.setAnimation(null);
            }
            paramAdapterView.setVisibility(4);
          }
        }
      }
    }
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList1, File paramFile1, AIOImageData paramAIOImageData, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList2, File paramFile2)
  {
    if (this.jdField_h_of_type_Boolean)
    {
      a(2131692764, 2130840156, 48, paramArrayList1);
      VasWebviewUtil.a("", "QLbq", "ClickMore", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    if (UinTypeUtil.a(this.jdField_g_of_type_Int) != 1044) {
      a(2131692767, 2130840161, 49, paramArrayList1);
    }
    if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(paramFile1))) {
      a(2131692778, 2130847036, 69, paramArrayList1);
    }
    if (!ZhuoXusManager.a().a()) {
      a(2131692777, 2130840170, 53, paramArrayList1);
    }
    if (!this.jdField_h_of_type_Boolean) {
      a(2131692766, 2130840160, 57, paramArrayList1);
    }
    if (UinTypeUtil.a(this.jdField_g_of_type_Int) != 1044)
    {
      if (paramAIOImageData.jdField_e_of_type_JavaLangString != null) {
        a(2131692771, 2130840164, 50, paramArrayList1, 3);
      }
      if ((this.jdField_i_of_type_Boolean) && (paramAIOImageData.jdField_e_of_type_JavaLangString != null)) {
        a(2131692768, 2130840162, 51, paramArrayList1, 3);
      }
    }
    a(2131692779, 2130840171, 58, paramArrayList1);
    if (UinTypeUtil.a(this.jdField_g_of_type_Int) != 1044)
    {
      if ((this.jdField_g_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.s)) {
        a(2131692781, 2130840172, 54, paramArrayList2, 3);
      }
      if (this.jdField_f_of_type_Boolean) {
        a(2131692772, 2130840165, 52, paramArrayList2, 2);
      }
      ThreadManager.getFileThreadHandler().post(new AIOGalleryScene.15(this, paramFile2, paramArrayList2));
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Aio preview ");
      localStringBuilder.append(paramBoolean);
      QLog.i("PicReporter", 2, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "Pic.AioPreview.Empty", paramBoolean, 0L, 0L, null, "");
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      if ((localAIORichMediaInfo != null) && ((localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)))
      {
        AIOGalleryAdapter localAIOGalleryAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
        if ((localAIOGalleryAdapter == null) || (localAIOGalleryAdapter.a((AIOShortVideoData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData) == null)) {
          break label118;
        }
        this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
      else
      {
        if ((localAIORichMediaInfo == null) || (!(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData)) || (!com.tencent.biz.qqstory.utils.FileUtils.c(((AIOFileVideoData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_c_of_type_JavaLangString))) {
          break label118;
        }
        this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
      return true;
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    label118:
    return false;
  }
  
  private int b()
  {
    int i2 = this.jdField_g_of_type_Int;
    int i1 = 1;
    if (i2 != 0)
    {
      if (i2 != 1) {
        return 4;
      }
      i1 = 2;
    }
    return i1;
  }
  
  private void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AIOImageListModel localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (paramInt3 == 1) {
      localObject = paramString;
    } else {
      localObject = "I:E";
    }
    localAIOImageListModel.a(paramLong, paramInt1, paramInt2, (String)localObject, false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AIOFilePicData.TYPE_ORIGINAL_IMAGE,result:");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append(",resultStr: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
    if (paramInt3 == 1)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      if ((paramString != null) && (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && (AIOFilePicData.class.isInstance(paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
        ((AIOFilePicData)paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_f_of_type_Boolean = false;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mPlayGifImage = true;
      paramString.mUseExifOrientation = false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("AIOGalleryScene", 1, "null url");
        return;
      }
      paramString = URLDrawable.getDrawable((String)localObject, paramString);
      paramInt1 = paramString.getStatus();
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 == 3) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.onLoadCanceled(paramString);
          }
          paramString.setTag(Integer.valueOf(1));
          paramString.setURLDrawableListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress);
          paramString.startDownload();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.onLoadFialed(paramString, null);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.onLoadSuccessed(paramString);
      return;
    }
    if (!"TroopFileError".equals(paramString)) {
      if (this.jdField_a_of_type_AndroidAppActivity.getString(2131692717).equals(paramString)) {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramString, 0).a();
      } else {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131694998), 0).a();
      }
    }
    c(false);
    d(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress = null;
  }
  
  private void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (paramInt3 != 1) {
      paramString = "I:E";
    }
    paramInt2 = ((AIOImageListModel)localObject).a(paramLong, paramInt1, paramInt2, paramString, false);
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    if ((paramInt2 >= i1) && (paramInt2 <= i2 + i1 - 1))
    {
      paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt2 - i1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt2, paramString, paramBoolean);
    }
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("notifyImageResult(): Gallery position is ");
      paramString.append(paramInt2);
      QLog.d("AIOGalleryScene", 4, paramString.toString());
    }
    paramInt2 = 0;
    while (paramInt2 < this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a())
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt2);
      if ((paramString != null) && (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramLong) && (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int == paramInt1) && (paramInt3 == 1) && (AIOImageData.class.isInstance(paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
      {
        paramString = (AIOImageData)paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if (!paramString.jdField_g_of_type_Boolean)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append("_hd");
          if (new File(((StringBuilder)localObject).toString()).exists())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject).append("_hd");
            paramString.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
          }
        }
      }
      paramInt2 += 1;
    }
  }
  
  private void b(AIOImageData paramAIOImageData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("__qzone_pic_permission__");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    if (LocalMultiProcConfig.getInt4Uin(localStringBuilder.toString(), -1, Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue()) == 0)
    {
      paramAIOImageData = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131756189);
      paramAIOImageData.setContentView(2131558978);
      paramAIOImageData.setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131697674));
      paramAIOImageData.setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131697672));
      paramAIOImageData.setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131697673), new AIOGalleryScene.12(this));
      paramAIOImageData.setCanceledOnTouchOutside(false);
      paramAIOImageData.setCancelable(false);
      paramAIOImageData.show();
      QZoneClickReport.startReportImediately(this.jdField_b_of_type_JavaLangString, "40", "1");
      return;
    }
    a("Pic_Forward_Grpalbum", 0);
    AIOGalleryUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, paramAIOImageData.jdField_a_of_type_JavaLangString, paramAIOImageData.jdField_e_of_type_JavaLangString, paramAIOImageData.c, -1);
  }
  
  private void b(AIOImageData paramAIOImageData, AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (paramAIOImageData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress = new AIOGalleryScene.RawPhotoProgress(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Long = paramAIOImageData.jdField_f_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Int = paramAIOImageData.jdField_f_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "dealSaveOriginalImage");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Int, 24);
    }
  }
  
  private void b(AIOImageData paramAIOImageData, AIORichMediaInfo paramAIORichMediaInfo, File paramFile)
  {
    a("Pic_save", 0);
    if ((paramAIOImageData.a(4) == null) && (paramAIOImageData.a(4)) && (AppNetConnInfo.isNetSupport()))
    {
      if ((!AppNetConnInfo.isWifiConn()) && (paramAIOImageData.jdField_h_of_type_Long > 29360128L))
      {
        a(1, paramAIOImageData, paramAIORichMediaInfo);
      }
      else
      {
        b(paramAIOImageData, paramAIORichMediaInfo);
        paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_e_of_type_Boolean = true;
        u();
      }
    }
    else
    {
      paramAIOImageData = this.jdField_a_of_type_AndroidAppActivity;
      paramAIORichMediaInfo = new StringBuilder();
      paramAIORichMediaInfo.append(paramFile.getAbsolutePath());
      paramAIORichMediaInfo.append(NetConnInfoCenter.getServerTime());
      AIOGalleryUtils.a(paramAIOImageData, paramFile, Utils.Crc64String(paramAIORichMediaInfo.toString()));
    }
    a(paramFile.getAbsolutePath(), 55);
    if (this.jdField_h_of_type_Boolean) {
      VasWebviewUtil.a("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
    }
    if (this.jdField_c_of_type_Boolean) {
      MultiMsgUtil.a("0X8009ABB");
    }
  }
  
  private void b(AIORichMediaData paramAIORichMediaData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("__qzone_pic_permission__");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    if (LocalMultiProcConfig.getInt4Uin(localStringBuilder.toString(), -1, Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue()) == 0)
    {
      paramAIORichMediaData = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131756189);
      paramAIORichMediaData.setContentView(2131558978);
      paramAIORichMediaData.setTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131697674));
      paramAIORichMediaData.setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131697672));
      paramAIORichMediaData.setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131697673), new AIOGalleryScene.23(this));
      paramAIORichMediaData.setCanceledOnTouchOutside(false);
      paramAIORichMediaData.setCancelable(false);
      paramAIORichMediaData.show();
      QZoneClickReport.startReportImediately(this.jdField_b_of_type_JavaLangString, "40", "1");
      return;
    }
    paramAIORichMediaData = (AIOImageData)paramAIORichMediaData;
    a("Pic_Forward_Grpalbum", 0);
    AIOGalleryUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, paramAIORichMediaData.jdField_a_of_type_JavaLangString, paramAIORichMediaData.jdField_e_of_type_JavaLangString, paramAIORichMediaData.c, -1);
  }
  
  private void b(AIORichMediaData paramAIORichMediaData, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("preResult", paramString);
    if (AIOImageData.class.isInstance(paramAIORichMediaData))
    {
      paramAIORichMediaData = (AIOImageData)paramAIORichMediaData;
      a(this.jdField_f_of_type_JavaLangString, paramAIORichMediaData.jdField_g_of_type_Int, paramAIORichMediaData.jdField_h_of_type_Boolean, paramAIORichMediaData.k, paramAIORichMediaData.jdField_f_of_type_JavaLangString, paramAIORichMediaData.j, paramAIORichMediaData.jdField_e_of_type_JavaLangString, 1, localIntent);
    }
    else if (AIOFilePicData.class.isInstance(paramAIORichMediaData))
    {
      paramString = (AIOFilePicData)paramAIORichMediaData;
      if (MessageRecordInfo.a(paramString.jdField_b_of_type_Int)) {
        paramAIORichMediaData = this.jdField_b_of_type_JavaLangString;
      } else {
        paramAIORichMediaData = this.jdField_c_of_type_JavaLangString;
      }
      a(this.jdField_f_of_type_JavaLangString, paramString.jdField_a_of_type_Int, true, paramAIORichMediaData, null, null, paramString.jdField_h_of_type_JavaLangString, 1, localIntent);
    }
    ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
  }
  
  private void b(AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (paramAIORichMediaInfo == null) {
      return;
    }
    if (AIOShortVideoData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      AIOShortVideoData localAIOShortVideoData = (AIOShortVideoData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (localAIOShortVideoData.jdField_b_of_type_Int == 0)
      {
        paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_h_of_type_Boolean = false;
        paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_d_of_type_Boolean = false;
      }
      else
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(localAIOShortVideoData.jdField_a_of_type_Int * 1000));
        paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_i_of_type_Boolean = false;
      }
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(0L));
      paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_g_of_type_Boolean = false;
      return;
    }
    if ((paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData))
    {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
      paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_g_of_type_Boolean = false;
      return;
    }
    paramAIORichMediaInfo = this.jdField_a_of_type_MqqOsMqqHandler;
    if (paramAIORichMediaInfo != null) {
      paramAIORichMediaInfo.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public static void b(AIORichMediaInfo paramAIORichMediaInfo, Activity paramActivity, int paramInt)
  {
    if (!AIOImageData.class.isInstance(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
      return;
    }
    AIOImageData localAIOImageData = (AIOImageData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    File localFile = localAIOImageData.a(4);
    int i1;
    if (localFile == null)
    {
      localFile = localAIOImageData.a(2);
      i1 = 0;
    }
    else
    {
      i1 = 1;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putBoolean("forward_urldrawable", true);
    localBundle.putString("forward_urldrawable_thumb_url", localAIOImageData.a(1));
    paramAIORichMediaInfo = paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    int i2;
    if (i1 != 0) {
      i2 = 4;
    } else {
      i2 = 2;
    }
    localBundle.putString("forward_urldrawable_big_url", paramAIORichMediaInfo.a(i2));
    if (paramActivity.getIntent().getBooleanExtra("image_share_by_server", false))
    {
      paramAIORichMediaInfo = Long.toString(paramActivity.getIntent().getLongExtra("appid", 0L));
      i2 = paramActivity.getIntent().getIntExtra("curType", 0);
      String str = paramActivity.getIntent().getStringExtra("title");
      localBundle.putBoolean("key_forward_image_share", true);
      localBundle.putString("key_forward_image_share_appid", paramAIORichMediaInfo);
      localBundle.putInt("key_forward_image_share_uin_type", i2);
      localBundle.putString("key_forward_image_share_title", str);
    }
    if (localFile != null) {}
    try
    {
      localBundle.putString("GALLERY.FORWORD_LOCAL_PATH", localFile.getAbsolutePath());
      localBundle.putInt("forward_source_uin_type", paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1));
      if (i1 != 0) {
        localBundle.putInt("PhotoConst.SEND_SIZE_SPEC", 2);
      }
      localBundle.putParcelable("FORWARD_MSG_FOR_PIC", localAIOImageData);
      if (localAIOImageData.jdField_b_of_type_Int == 4) {
        localBundle.putBoolean("HOT_PIC_HAS_EXTRA", true);
      }
      paramAIORichMediaInfo = new Intent();
      paramAIORichMediaInfo.putExtras(localBundle);
      ForwardBaseOption.a(paramActivity, paramAIORichMediaInfo, paramInt);
      return;
    }
    catch (NullPointerException paramAIORichMediaInfo)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      paramActivity = new StringBuilder();
      paramActivity.append("showFriendPickerForForward ,NullPointerException: ");
      paramActivity.append(paramAIORichMediaInfo);
      QLog.d("AIOGalleryScene", 2, paramActivity.toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "showFriendPickerForForward ,cache path is null");
    }
    return;
  }
  
  private void b(AIOShortVideoData paramAIOShortVideoData)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file://");
    localStringBuilder.append(paramAIOShortVideoData.jdField_b_of_type_JavaLangString);
    localIntent.setDataAndType(Uri.parse(localStringBuilder.toString()), "video/*");
    localIntent.putExtra("big_brother_source_key", " biz_src_jc_video");
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    int i1 = paramAIOShortVideoData.jdField_g_of_type_Int;
    if (i1 == 0)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
      return;
    }
    if (i1 == 3000)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
      return;
    }
    if (i1 == 1)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
  }
  
  private void b(AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt, AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (paramAIOShortVideoData.jdField_j_of_type_Int == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "video file is expired");
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, HardCodeUtil.a(2131700271), 0).a();
      return;
    }
    if (paramAIOShortVideoData.jdField_b_of_type_Int == 1)
    {
      a(paramInt, paramFile);
      return;
    }
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.length() == paramAIOShortVideoData.jdField_h_of_type_Long))
    {
      paramAIOShortVideoData = new StringBuilder();
      paramAIORichMediaInfo = new StringBuilder();
      paramAIORichMediaInfo.append(paramFile.getParentFile().getName());
      paramAIORichMediaInfo.append(NetConnInfoCenter.getServerTime());
      paramAIOShortVideoData.append(paramAIORichMediaInfo.toString().toLowerCase(Locale.US));
      paramAIOShortVideoData.append(".mp4");
      paramAIOShortVideoData = paramAIOShortVideoData.toString();
      ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(paramFile.getAbsolutePath(), this.jdField_a_of_type_MqqOsMqqHandler, paramAIOShortVideoData, false));
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(10001);
      return;
    }
    if ((!AppNetConnInfo.isWifiConn()) && (paramAIOShortVideoData.jdField_h_of_type_Long > 29360128L))
    {
      a(3, paramAIOShortVideoData, paramAIORichMediaInfo);
      return;
    }
    a(paramAIOShortVideoData, paramAIORichMediaInfo);
    paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_a_of_type_Boolean = true;
    u();
  }
  
  private int c()
  {
    int i1 = this.jdField_k_of_type_Int;
    if (i1 == 1) {
      return 1;
    }
    if (i1 == 2) {
      return 5;
    }
    if (i1 == 3) {
      return 4;
    }
    if (this.jdField_c_of_type_Boolean) {
      return 6;
    }
    return 0;
  }
  
  private void c(int paramInt)
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b())
      {
        z();
        return;
      }
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      if (this.jdField_k_of_type_Boolean) {
        if ((i1 - paramInt <= 0) || (paramInt <= i1 - 25)) {}
      }
      for (;;)
      {
        paramInt = 1;
        break;
        do
        {
          paramInt = 0;
          break;
        } while (paramInt >= 25);
      }
      if ((i1 != 1) && (paramInt != 0) && (!this.jdField_a_of_type_Boolean) && (this.jdField_n_of_type_Int != i1))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[onItemSelected] loadMedias: mLastLoadCount=");
          localStringBuilder.append(this.jdField_n_of_type_Int);
          QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
        }
        this.jdField_n_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(0);
      }
    }
  }
  
  private void c(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress;
    if ((localObject != null) && (((AIOGalleryScene.RawPhotoProgress)localObject).jdField_a_of_type_Long == paramLong) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Int == paramInt1))
    {
      AIOImageListModel localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
      if (paramInt3 == 1) {
        localObject = paramString;
      } else {
        localObject = "I:E";
      }
      localAIOImageListModel.a(paramLong, paramInt1, paramInt2, (String)localObject, false);
      if (paramInt3 == 1)
      {
        paramString = URLDrawable.URLDrawableOptions.obtain();
        paramString.mPlayGifImage = true;
        paramString.mUseExifOrientation = false;
        try
        {
          paramString = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4), paramString);
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
          paramString = null;
        }
        if (paramString == null) {
          return;
        }
        paramInt2 = paramString.getStatus();
        if (paramInt2 != 1)
        {
          if (paramInt2 != 2)
          {
            if (paramInt2 == 3) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.onLoadCanceled(paramString);
            }
            paramString.setTag(Integer.valueOf(1));
            paramString.setURLDrawableListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress);
            paramString.startDownload();
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.onLoadFialed(paramString, null);
          }
        }
        else {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.onLoadSuccessed(paramString);
        }
      }
      else
      {
        if (!"TroopFileError".equals(paramString)) {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131694998), 0).a();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress = null;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if ((paramString.jdField_f_of_type_Long == paramLong) && (paramString.jdField_f_of_type_Int == paramInt1))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_c_of_type_Boolean = false;
      }
      else
      {
        paramString = a(paramLong, paramInt1);
        if (paramString != null)
        {
          paramString.jdField_a_of_type_Int = 0;
          paramString.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_c_of_type_Boolean = false;
        }
      }
      u();
    }
  }
  
  private void c(AIOImageData paramAIOImageData)
  {
    if (this.jdField_h_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_Manager", 2, "action sheet share weiyun.");
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("pic_md5", paramAIOImageData.jdField_f_of_type_JavaLangString);
      QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_upload_wy", localBundle, null);
      VasWebviewUtil.a("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
      return;
    }
    if ((paramAIOImageData.jdField_f_of_type_Long > 0L) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.c(paramAIOImageData.jdField_f_of_type_Long);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131692690), 0).a();
    }
  }
  
  private void c(AIORichMediaInfo paramAIORichMediaInfo)
  {
    a("Pic_Forward_Contacts", 0);
    a(paramAIORichMediaInfo, this.jdField_a_of_type_AndroidAppActivity, 0);
    if (this.jdField_h_of_type_Boolean) {
      VasWebviewUtil.a("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
    }
    if (this.jdField_c_of_type_Boolean) {
      MultiMsgUtil.a("0X8009ABA");
    }
  }
  
  private void d(int paramInt)
  {
    AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
    if ((localAIORichMediaInfo != null) && ((localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131694999), new Object[] { FileUtil.a(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_h_of_type_Long) }));
      if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_h_of_type_Long > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())
      {
        d(true);
        this.jdField_a_of_type_ComTencentWidgetGallery.enableDoubleTap(false);
        this.jdField_a_of_type_ComTencentWidgetGallery.enableScaleGesture(false);
      }
      else
      {
        d(true);
      }
    }
    if ((localAIORichMediaInfo != null) && ((localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) && (((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_g_of_type_Int == 1))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidAppActivity.getString(2131694999), new Object[] { FileUtil.a(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_h_of_type_Long) }));
      if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_h_of_type_Long > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize())
      {
        d(true);
        this.jdField_a_of_type_ComTencentWidgetGallery.enableDoubleTap(false);
        this.jdField_a_of_type_ComTencentWidgetGallery.enableScaleGesture(false);
        return;
      }
      d(true);
    }
  }
  
  private void d(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    AIOImageListModel localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (paramInt3 != 1) {
      paramString = "I:E";
    }
    paramInt1 = localAIOImageListModel.a(paramLong, paramInt1, paramInt2, paramString, false);
    paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    paramInt3 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1))
    {
      paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramString, paramBoolean);
    }
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("notifyImageResult(): Gallery position is ");
      paramString.append(paramInt1);
      QLog.d("AIOGalleryScene", 4, paramString.toString());
    }
  }
  
  private void d(AIORichMediaInfo paramAIORichMediaInfo)
  {
    AIOImageData localAIOImageData = (AIOImageData)paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    Object localObject2 = localAIOImageData.a(4);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localAIOImageData.a(2);
    }
    if ((localObject1 == null) && (this.u)) {
      return;
    }
    if (localObject1 != null) {
      this.jdField_g_of_type_JavaLangString = ((File)localObject1).getPath();
    }
    localObject2 = ActionSheet.createMenuSheet(this.jdField_a_of_type_AndroidAppActivity);
    if ((!a((ActionSheet)localObject2, localAIOImageData)) && (UinTypeUtil.a(this.jdField_g_of_type_Int) != 1032))
    {
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      if (localObject1 != null)
      {
        if (!this.jdField_c_of_type_Boolean)
        {
          a((ArrayList)localObject2, (File)localObject1, localAIOImageData, localArrayList, (File)localObject1);
        }
        else
        {
          a(2131693256, 2130840161, 49, (ArrayList)localObject2);
          a(2131693262, 2130840170, 53, (ArrayList)localObject2);
        }
      }
      else if ((!this.jdField_c_of_type_Boolean) && (UinTypeUtil.a(this.jdField_g_of_type_Int) != 1044) && (this.jdField_g_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.s)) {
        a(2131692781, 2130840172, 54, localArrayList, 3);
      }
      if ((localAIOImageData.jdField_e_of_type_Int == 4) && (!localAIOImageData.jdField_i_of_type_Boolean)) {
        a(2131693261, 2130846901, 66, (ArrayList)localObject2);
      }
      a(localAIOImageData, paramAIORichMediaInfo, (File)localObject1);
      paramAIORichMediaInfo = (List[])new ArrayList[] { localObject2, localArrayList };
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(paramAIORichMediaInfo);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
      return;
    }
    a((ActionSheet)localObject2, localAIOImageData, (File)localObject1, (File)localObject1);
  }
  
  private void e(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    AIOImageListModel localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (paramInt3 != 1) {
      paramString = "I:E";
    }
    paramInt1 = localAIOImageListModel.a(paramLong, paramInt1, paramInt2, paramString, false);
    paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    if ((paramInt1 >= paramInt2) && (paramInt1 <= i1 + paramInt2 - 1))
    {
      paramString = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramString, paramBoolean);
      if (paramInt3 == 2)
      {
        c(false);
        d(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress = null;
      }
    }
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("notifyImageResult(): Gallery position is ");
      paramString.append(paramInt1);
      QLog.d("AIOGalleryScene", 4, paramString.toString());
    }
  }
  
  private void e(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561484, null);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    if (paramBoolean) {
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131374214);
    } else {
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localRelativeLayout.findViewById(2131371936));
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131377124));
    localObject = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372192);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373130));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379063));
    ((ImageView)localObject).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(10000);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131380237));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380239));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380238));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131364704));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131364130));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)localRelativeLayout.findViewById(2131375985));
  }
  
  void A()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AIOGalleryScene.28(this), 1000L);
  }
  
  public void B()
  {
    this.jdField_n_of_type_Boolean = true;
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if (localDialog != null) {
      try
      {
        localDialog.dismiss();
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryScene", 2, localException, new Object[0]);
        }
      }
    }
  }
  
  void C()
  {
    try
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (((localObject2 instanceof AIOImageData)) || ((localObject2 instanceof AIOFilePicData)))
      {
        Object localObject1 = a((AIORichMediaData)localObject2);
        if (localObject1 == null) {
          return;
        }
        this.jdField_g_of_type_JavaLangString = ((File)localObject1).getAbsolutePath();
        int i1 = this.jdField_k_of_type_Int;
        int i3 = 19000;
        boolean bool;
        int i2;
        switch (i1)
        {
        default: 
          bool = false;
          i1 = 0;
          i3 = 0;
          i2 = 99;
          break;
        case 6: 
          bool = true;
          i1 = 0;
          i2 = 130;
          break;
        case 5: 
          bool = true;
          i1 = 1;
          i2 = 129;
          break;
        case 4: 
          ReportController.b(null, "dc00898", "", "", "0X800A187", "0X800A187", 0, 0, "", "", "", "");
          bool = true;
          i1 = 0;
          i3 = 19002;
          i2 = 125;
          break;
        case 3: 
          bool = true;
          i1 = 1;
          i2 = 128;
          break;
        case 2: 
          bool = true;
          i1 = 1;
          i2 = 127;
          break;
        case 1: 
          bool = true;
          i1 = 1;
          i2 = 126;
        }
        localObject1 = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.jdField_a_of_type_AndroidAppActivity, ((File)localObject1).getAbsolutePath(), true, true, true, true, true, 2, i2, 7);
        ((Intent)localObject1).putExtra("uintype", this.jdField_g_of_type_Int);
        ((Intent)localObject1).putExtra("open_chatfragment", true);
        ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
        ((Intent)localObject1).putExtra("key_enable_edit_title_bar", true);
        if (bool) {
          ((Intent)localObject1).putExtra("key_help_forward_pic", bool);
        }
        if (i1 != 0) {
          ((Intent)localObject1).putExtra("key_allow_multiple_forward_from_limit", false);
        }
        if ((localObject2 instanceof AIOFilePicData))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder())
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIORichMediaData)localObject2).jdField_f_of_type_Long, ((AIORichMediaData)localObject2).jdField_f_of_type_Int, this.jdField_g_of_type_Int);
            if (localObject2 != null)
            {
              ((Intent)localObject2).setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
              localObject2 = (ForwardFileInfo)((Intent)localObject2).getParcelableExtra("fileinfo");
              if (localObject2 != null) {
                ((Intent)localObject1).putExtra("fileinfo", (Parcelable)localObject2);
              }
            }
          }
          ((Intent)localObject1).putExtra("not_forward", true);
        }
        if (i3 != 0) {
          this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject1, i3);
        } else {
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
        }
        this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772065, 2130772067);
        ReportController.b(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  public void D()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a();
  }
  
  public void E()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
    if ((localObject != null) && (((VideoPlayControllerForAIO)localObject).a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.d(2);
      localObject = this.jdField_a_of_type_AndroidAppActivity.getString(2131719087);
      localObject = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, (String)localObject, 2131694460, 2131720490, new AIOGalleryScene.32(this), new AIOGalleryScene.33(this));
      VideoPlayControllerForAIO localVideoPlayControllerForAIO = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
      if (localVideoPlayControllerForAIO != null) {
        localVideoPlayControllerForAIO.h();
      }
      a((Dialog)localObject);
    }
  }
  
  protected RelativeLayout a()
  {
    return (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561292, null);
  }
  
  protected AbstractImageAdapter a(Context paramContext)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    Object localObject = (AIORichMediaData)localBundle.getParcelable("extra.EXTRA_CURRENT_IMAGE");
    if ((localObject instanceof AIOShortVideoData))
    {
      int i1 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
      if (i1 != -1) {
        ((AIOShortVideoData)localObject).jdField_g_of_type_Int = i1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData = ((AIORichMediaData)localObject);
    localObject = new AIORichMediaInfo((AIORichMediaData)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a((AIORichMediaInfo)localObject);
    this.r = localBundle.getBoolean("muate_play");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initData , mIsMute = ");
      localStringBuilder.append(this.r);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    ((AIORichMediaInfo)localObject).jdField_a_of_type_AndroidGraphicsRect = ((Rect)localBundle.getParcelable("KEY_THUMBNAL_BOUND"));
    this.jdField_c_of_type_Int = localBundle.getInt("extra.AIO_CURRENT_PANEL_STATE", -3321);
    this.u = localBundle.getBoolean("IS_APP_SHARE_PIC", false);
    this.jdField_e_of_type_Int = localBundle.getInt("extra.MOBILE_QQ_PROCESS_ID", -2147483648);
    this.o = localBundle.getBoolean("extra.IS_HOT_CHAT", false);
    this.p = localBundle.getBoolean("extra.IS_SAVING_FILE", false);
    this.jdField_j_of_type_Int = localBundle.getInt("extra.SAVE_FILE_PROGRESS", 0);
    this.jdField_i_of_type_Boolean = localBundle.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    this.jdField_d_of_type_JavaLangString = localBundle.getString("extra.GROUP_UIN");
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_e_of_type_JavaLangString = localBundle.getString("extra.GROUP_CODE");
      if (((this.jdField_d_of_type_JavaLangString == null) || (this.jdField_e_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString == null)) && (QLog.isColorLevel()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mGroupUin=");
        localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
        localStringBuilder.append(", mGroupCode=");
        localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
        localStringBuilder.append(", mMyUin=");
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        QLog.i("AIOGalleryScene", 2, localStringBuilder.toString());
      }
    }
    this.jdField_f_of_type_Int = localBundle.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
    this.jdField_e_of_type_Boolean = localBundle.getBoolean("extra.IS_APOLLO");
    this.jdField_c_of_type_Boolean = localBundle.getBoolean("extra.IS_FROM_MULTI_MSG");
    this.jdField_a_of_type_Long = localBundle.getLong("key_multi_forward_seq", 0L);
    this.jdField_d_of_type_Boolean = localBundle.getBoolean("extra.IS_RECEIPT_MSG");
    this.jdField_g_of_type_Int = localBundle.getInt("forward_source_uin_type", -1);
    this.jdField_c_of_type_JavaLangString = localBundle.getString("uin");
    this.jdField_j_of_type_Boolean = localBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY", false);
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(true);
      this.jdField_k_of_type_Boolean = true;
    }
    else
    {
      ((AIORichMediaInfo)localObject).isImgCenterCropMode = false;
    }
    this.jdField_m_of_type_Boolean = (TextUtils.isEmpty(localBundle.getString("babyq_video_type")) ^ true);
    this.jdField_f_of_type_Boolean = localBundle.getBoolean("extra.OCR", false);
    this.jdField_a_of_type_JavaLangString = localBundle.getString("extra.OCR_TEXT");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131693258);
    }
    this.jdField_h_of_type_Boolean = localBundle.getBoolean("group.emo.big.preview", false);
    this.jdField_k_of_type_Int = localBundle.getInt("extra.EXTRA_ENTRANCE");
    this.s = localBundle.getBoolean("is_ReplyMsg_From_Same_Session", true);
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(this.jdField_a_of_type_AndroidAppActivity.getString(2131692780));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(new AIOGalleryScene.19(this));
    AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    boolean bool = AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
    int i2 = 0;
    Object localObject;
    int i1;
    if (bool)
    {
      localObject = (AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      a((AIOImageData)localObject, paramInt, localAIORichMediaInfo);
      if ((((AIOImageData)localObject).jdField_g_of_type_Int == 1) && (((AIOImageData)localObject).jdField_h_of_type_Boolean)) {
        i1 = 2;
      } else {
        i1 = 1;
      }
    }
    else if (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      localObject = (AIOShortVideoData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (((AIOShortVideoData)localObject).jdField_b_of_type_Int == 0) {
        i1 = 4;
      } else if (((AIOShortVideoData)localObject).jdField_b_of_type_Int == 1) {
        i1 = 3;
      } else {
        i1 = 0;
      }
      a((AIOShortVideoData)localObject, paramInt);
    }
    else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      a((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt);
      i1 = 2;
    }
    else if (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      a((AIOFileVideoData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, paramInt);
      i1 = 5;
    }
    else
    {
      i1 = 0;
    }
    int i3 = a(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_g_of_type_Int);
    int i4 = c();
    if (paramInt == 2) {
      i2 = 1;
    } else if (paramInt == 1) {
      i2 = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X8009EFB", "0X8009EFB", i1, 0, String.valueOf(i3), String.valueOf(i4), String.valueOf(i2), "");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 0))
    {
      a(this.jdField_a_of_type_AndroidAppActivity, paramIntent.getExtras());
      if (this.jdField_g_of_type_Int == 9501) {
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
    }
    else if ((paramInt2 == -1) && (paramInt1 == 10001))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131719081, 0).a();
    }
  }
  
  public void a(int paramInt1, View paramView, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("carverW notifyVideoUrl setShortVideoDrawableWithUrls ,position = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt1);
    if (localObject == null) {
      return;
    }
    if (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      a((AIORichMediaInfo)localObject, paramArrayOfString, paramString2, paramView, paramMessageForShortVideo, paramInt2);
      return;
    }
    if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
      a((AIORichMediaInfo)localObject, paramString1, paramArrayOfString, paramString2, paramView);
    }
  }
  
  public void a(int paramInt, Object paramObject, AIORichMediaInfo paramAIORichMediaInfo)
  {
    a(DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, this.jdField_a_of_type_AndroidAppActivity.getString(2131718382), this.jdField_a_of_type_AndroidAppActivity.getString(2131718381), new AIOGalleryScene.13(this, paramInt, paramObject, paramAIORichMediaInfo), new AIOGalleryScene.14(this)));
  }
  
  public void a(long paramLong)
  {
    int i1;
    if ((this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager != null) && (this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a() == this)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "onRevokeMsg not currentScene!");
      }
      return;
    }
    AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    if ((localAIORichMediaInfo != null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null))
    {
      boolean bool;
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Long == paramLong)) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRevokeMsg seq:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(", selectItem seq:");
        ((StringBuilder)localObject).append(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
        ((StringBuilder)localObject).append(", isFromMultiMsg:");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
        ((StringBuilder)localObject).append(", OriSeq:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
        QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
      if ((localObject != null) && (!bool)) {
        ((IAIOImageProvider)localObject).a(paramLong);
      }
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryScene.31(this, paramLong, localAIORichMediaInfo, bool));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AIOGalleryScene", 2, "onRevokeMsg exp!");
    }
  }
  
  public void a(long paramLong, float paramFloat, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryScene.4(this, paramLong, paramFloat, paramString));
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean)
  {
    if (paramInt2 == 2)
    {
      a(paramLong1, paramInt1, paramBoolean);
      return;
    }
    if (paramInt2 == 24)
    {
      a(paramLong1, paramInt1);
      return;
    }
    if (paramInt2 == 4)
    {
      a(paramLong1, paramInt1, paramInt2, paramInt3, paramLong2);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramInt2 == 1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      paramInt1 = 0;
      while (paramInt1 < ((List)localObject1).size())
      {
        localObject2 = (AIORichMediaInfo)((List)localObject1).get(paramInt1);
        if (((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramLong1)
        {
          ((AIORichMediaInfo)localObject2).jdField_a_of_type_Int = paramInt3;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.b(paramInt1, paramInt3 / 100);
          return;
        }
        paramInt1 += 1;
      }
    }
    if (paramInt2 == 256)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("save video progress : ");
        ((StringBuilder)localObject1).append(paramInt3);
        QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if ((((AIORichMediaData)localObject1).jdField_f_of_type_Long == paramLong1) && (((AIORichMediaData)localObject1).jdField_f_of_type_Int == paramInt1))
      {
        localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131700285));
        ((StringBuilder)localObject2).append(paramInt3);
        ((StringBuilder)localObject2).append("%");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        localObject1 = this.jdField_a_of_type_AndroidWidgetSeekBar;
        double d1 = paramInt3;
        Double.isNaN(d1);
        ((SeekBar)localObject1).setProgress((int)(d1 / 100.0D * 10000.0D));
      }
    }
    else
    {
      if (paramInt2 == 18)
      {
        a(paramLong1, paramBoolean);
        return;
      }
      if (paramInt2 == 20) {
        a(paramLong1, paramLong2);
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if (paramInt2 == 2)
    {
      b(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
      return;
    }
    if (paramInt2 == 24)
    {
      a(paramLong, paramInt1, paramInt2, paramInt3, paramString);
      return;
    }
    if (paramInt2 == 4)
    {
      c(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
      return;
    }
    Object localObject;
    if (paramInt2 == 256)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("save video result resultStr = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt3 == 1) {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131718379), 0).a();
      } else {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131718375), 0).a();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.jdField_b_of_type_Boolean = false;
      u();
      return;
    }
    if ((paramInt2 != 1) && (paramInt2 != 0))
    {
      if (paramInt2 == 18)
      {
        e(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
        return;
      }
      if (paramInt2 == 20)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress;
        if ((localObject != null) && (((AIOGalleryScene.RawPhotoProgress)localObject).jdField_a_of_type_Long == paramLong))
        {
          b(paramLong, paramInt1, paramInt2, paramInt3, paramString);
          return;
        }
      }
      if (paramInt2 == 269484034) {
        a(paramLong, paramInt3, paramString);
      }
    }
    else
    {
      d(paramLong, paramInt1, paramInt2, paramInt3, paramString, paramBoolean);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramLong, paramInt1, paramInt2, paramString1, false);
    paramInt2 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
    int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" carverW notifyVideoUrl(): Gallery position is ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", first = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", count = ");
      localStringBuilder.append(i1);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    if ((paramInt1 >= paramInt2) && (paramInt1 <= i1 + paramInt2 - 1)) {
      a(paramInt1, this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(paramInt1 - paramInt2), paramString1, paramArrayOfString, paramString2, paramMessageForShortVideo, paramInt3);
    }
  }
  
  @TargetApi(14)
  public void a(Activity paramActivity, String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(paramActivity);
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561828);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373123);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a(paramActivity);
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371529)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new AIOGalleryScene.26(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(0);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AIOGalleryScene.27(this), paramInt);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramConfiguration);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    LiuHaiUtils.enableNotch(this.jdField_a_of_type_AndroidAppActivity);
    super.a(paramViewGroup);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a());
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(9, -1);
    paramViewGroup = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)TypedValue.applyDimension(1, 14.0F, paramViewGroup));
    int i1 = (int)TypedValue.applyDimension(1, 5.0F, paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131374219);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131165352));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(2.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165434));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694996);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131694996));
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, i1, i1, i1);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843779));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_d_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131700288));
    this.jdField_d_of_type_AndroidWidgetImageButton.setId(2131374214);
    this.jdField_d_of_type_AndroidWidgetImageButton.setImageResource(2130837999);
    this.jdField_d_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
    this.jdField_d_of_type_AndroidWidgetImageButton.setPadding(0, 0, 0, 0);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)TypedValue.applyDimension(1, 25.0F, paramViewGroup));
    if ((f()) && (!(this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras().getParcelable("extra.EXTRA_CURRENT_IMAGE") instanceof AIODevLittleVideoData))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool;
    if ((i1 != 0) && (this.jdField_k_of_type_Int != 3)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_d_of_type_AndroidWidgetImageButton, (ViewGroup.LayoutParams)localObject1);
    }
    this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131700283));
    this.jdField_b_of_type_AndroidWidgetImageButton.setId(2131374215);
    this.jdField_b_of_type_AndroidWidgetImageButton.setImageResource(2130837997);
    this.jdField_b_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
    this.jdField_b_of_type_AndroidWidgetImageButton.setPadding(0, 0, 0, 0);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)TypedValue.applyDimension(1, 10.0F, paramViewGroup));
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)TypedValue.applyDimension(1, 24.0F, paramViewGroup));
    localObject1 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    if (!((AIORichMediaData)((Bundle)localObject1).getParcelable("extra.EXTRA_CURRENT_IMAGE") instanceof AIODevLittleVideoData)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageButton, (ViewGroup.LayoutParams)localObject2);
    }
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_k_of_type_Int = ((Bundle)localObject1).getInt("extra.EXTRA_ENTRANCE");
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("editPhotoBtn mContext.getIntent().getBooleanExtra: ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("extra.FROM_AIO", false));
      QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject2).toString());
    }
    this.jdField_a_of_type_AndroidWidgetImageButton = new ImageButton(this.jdField_a_of_type_AndroidAppActivity);
    if (!this.jdField_a_of_type_AndroidAppActivity.getIntent().getBooleanExtra("extra.FROM_AIO", false))
    {
      i1 = this.jdField_k_of_type_Int;
      if ((i1 != 3) && (i1 != 2))
      {
        i1 = 0;
        break label779;
      }
    }
    i1 = 1;
    label779:
    if (((i1 != 0) || ((this.jdField_k_of_type_Int == 4) && (((Bundle)localObject1).getBoolean("key_allow_forward_photo_preview_edit", false)))) && (UinTypeUtil.a(this.jdField_g_of_type_Int) != 1032) && (UinTypeUtil.a(this.jdField_g_of_type_Int) != 1044))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131700279));
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837992);
      this.jdField_a_of_type_AndroidWidgetImageButton.setBackgroundDrawable(null);
      this.jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageButton.setId(2131374216);
      this.jdField_a_of_type_AndroidWidgetImageButton.setPadding(0, 0, 0, 0);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
      ((RelativeLayout.LayoutParams)localObject1).alignWithParent = true;
      if (bool) {
        ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131374214);
      } else {
        ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
      }
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((int)TypedValue.applyDimension(1, 23.0F, paramViewGroup));
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)TypedValue.applyDimension(1, 20.0F, paramViewGroup));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageButton, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    e(bool);
    I();
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if ((OnProGalleryListener.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter)) && (ProGallery.class.isInstance(this.jdField_a_of_type_ComTencentWidgetGallery))) {
      ((ProGallery)this.jdField_a_of_type_ComTencentWidgetGallery).setOnNoBlankListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.e(this.jdField_k_of_type_Int);
    ((ProGallery)this.jdField_a_of_type_ComTencentWidgetGallery).setGestureListener(this);
    this.jdField_l_of_type_Int = (SplashADUtil.a(this.jdField_a_of_type_AndroidAppActivity) / 2);
    AIOGalleryMsgRevokeMgr.a().a(this);
  }
  
  protected void a(AIORichMediaInfo paramAIORichMediaInfo, Activity paramActivity, int paramInt)
  {
    b(paramAIORichMediaInfo, this.jdField_a_of_type_AndroidAppActivity, 0);
  }
  
  public void a(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TVKInfo] onPlayStart, id : ");
      Object localObject;
      if (paramVideoPlayMedioInfo == null)
      {
        localObject = "null";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramVideoPlayMedioInfo.jdField_a_of_type_Long);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    if ((paramVideoPlayMedioInfo != null) && (paramVideoPlayMedioInfo.jdField_b_of_type_Boolean) && (paramVideoPlayMedioInfo.jdField_a_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryScene", 2, "Filevideo onPlayStart igon playProgress");
      }
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_g_of_type_Boolean = true;
    u();
  }
  
  public void a(VideoPlayMedioInfo paramVideoPlayMedioInfo, int paramInt)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TVKInfo] onEndBuffering, id : ");
      if (paramVideoPlayMedioInfo == null)
      {
        localObject1 = "null";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramVideoPlayMedioInfo.jdField_a_of_type_Long);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    if ((localObject1 != null) && (((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null))
    {
      if (paramVideoPlayMedioInfo == null) {
        return;
      }
      localObject2 = a(paramVideoPlayMedioInfo.jdField_a_of_type_Long, paramVideoPlayMedioInfo.jdField_b_of_type_Int);
      if (localObject2 != null) {
        ((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_d_of_type_Boolean = false;
      }
      if (((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramVideoPlayMedioInfo.jdField_a_of_type_Long) {
        u();
      }
    }
  }
  
  public void a(VideoPlayMedioInfo paramVideoPlayMedioInfo, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TVKInfo] onError , id : ");
      if (paramVideoPlayMedioInfo == null)
      {
        localObject = "null";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramVideoPlayMedioInfo.jdField_a_of_type_Long);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    if (paramVideoPlayMedioInfo == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    if (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramVideoPlayMedioInfo.jdField_a_of_type_Long) {
      return;
    }
    if (paramVideoPlayMedioInfo.jdField_b_of_type_Boolean)
    {
      if (!AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        return;
      }
      paramString = ((IVideoPlayUtils)QRoute.api(IVideoPlayUtils.class)).makeErrorText(paramInt1, paramInt2);
      localObject = (AIOFileVideoData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if (((AIOFileVideoData)localObject).jdField_b_of_type_Boolean) {
        return;
      }
      ((AIOFileVideoData)localObject).a(paramString);
      paramString = new Bundle();
      float f1 = 0.0F;
      if (VideoPlayControllerForFile.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO)) {
        f1 = ((VideoPlayControllerForFile)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO).a(paramVideoPlayMedioInfo.jdField_a_of_type_Long);
      }
      paramString.putFloat("progress", f1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(((AIOFileVideoData)localObject).jdField_f_of_type_Long, 10, paramString);
      u();
      return;
    }
    paramVideoPlayMedioInfo = a(paramVideoPlayMedioInfo.jdField_a_of_type_Long, paramVideoPlayMedioInfo.jdField_b_of_type_Int);
    if (paramVideoPlayMedioInfo == null) {
      return;
    }
    paramVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_k_of_type_Boolean = true;
    if (!AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
      return;
    }
    ((AIOShortVideoData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(paramString);
    u();
  }
  
  public void a(VideoPlayMedioInfo paramVideoPlayMedioInfo, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[TVKInfo] onDurationReady , id : ");
      if (paramVideoPlayMedioInfo == null)
      {
        paramVideoPlayMedioInfo = "null";
      }
      else
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(paramVideoPlayMedioInfo.jdField_a_of_type_Long);
        localStringBuilder2.append("");
        paramVideoPlayMedioInfo = localStringBuilder2.toString();
      }
      localStringBuilder1.append(paramVideoPlayMedioInfo);
      QLog.d("AIOGalleryScene", 2, localStringBuilder1.toString());
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(paramLong));
  }
  
  public void a(VideoPlayMedioInfo paramVideoPlayMedioInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TVKInfo] onGetUrl, id : ");
      Object localObject;
      if (paramVideoPlayMedioInfo == null)
      {
        localObject = "null";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramVideoPlayMedioInfo.jdField_a_of_type_Long);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" isStart=");
      localStringBuilder.append(paramBoolean);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    if (paramVideoPlayMedioInfo == null) {
      return;
    }
    paramVideoPlayMedioInfo = a(paramVideoPlayMedioInfo.jdField_a_of_type_Long, paramVideoPlayMedioInfo.jdField_b_of_type_Int);
    if (paramVideoPlayMedioInfo == null) {
      return;
    }
    paramVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_j_of_type_Boolean = paramBoolean;
    if (!paramVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_g_of_type_Boolean)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText("");
      u();
    }
  }
  
  @UnCompletedCode
  void a(String paramString, int paramInt)
  {
    IAIOImageProvider localIAIOImageProvider = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.a(paramString, paramInt);
    }
  }
  
  void a(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, Intent paramIntent)
  {
    Intent localIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    } else {
      localIntent = paramIntent;
    }
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("detectType", paramInt2);
    localIntent.putExtra("fromPicQRDecode", true);
    paramInt2 = 0;
    Object localObject = null;
    if ((paramInt1 != 1) && (paramInt1 != 3000)) {
      if (paramBoolean) {
        paramInt1 = 3;
      } else {
        paramInt1 = 1;
      }
    }
    label706:
    label717:
    for (;;)
    {
      String str;
      try
      {
        if (TextUtils.equals(paramString2, this.jdField_b_of_type_JavaLangString)) {
          paramIntent = this.jdField_c_of_type_JavaLangString;
        } else {
          paramIntent = this.jdField_b_of_type_JavaLangString;
        }
        if (!TextUtils.isEmpty(paramString4))
        {
          int i1 = BaseDownloadProcessor.getPicDownloadPort();
          if (paramInt2 == 0) {
            break label706;
          }
          str = "gchat.qpic.cn";
          paramString1 = localObject;
          if (TextUtils.isEmpty(str)) {
            break label717;
          }
          if (i1 != 80)
          {
            paramString1 = new StringBuilder();
            paramString1.append(str);
            paramString1.append(":");
            paramString1.append(i1);
            paramString1.append(paramString4);
            paramString1 = paramString1.toString();
            break label717;
          }
          paramString1 = new StringBuilder();
          paramString1.append(str);
          paramString1.append(paramString4);
          paramString1 = paramString1.toString();
          break label717;
        }
        paramBoolean = TextUtils.isEmpty(paramString5);
        paramString1 = localObject;
        if (paramBoolean) {
          break label717;
        }
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            paramString1 = localObject;
            break label717;
          }
          paramString1 = "gchat.qpic.cn/gchatpic_new";
          if (!TextUtils.isEmpty(paramString2))
          {
            paramString1 = new StringBuilder();
            paramString1.append("gchat.qpic.cn/gchatpic_new");
            paramString1.append("/");
            paramString1.append(paramString2);
            paramString1 = paramString1.toString();
          }
          paramBoolean = paramString5.startsWith("/");
          if (paramBoolean)
          {
            paramString4 = new StringBuilder();
            paramString4.append(paramString1);
            paramString4.append("0-0-");
            paramString4.append(paramString5.replace(".jpg", ""));
            paramString4.append("/0");
            paramString1 = paramString4.toString();
          }
          else
          {
            paramString4 = new StringBuilder();
            paramString4.append(paramString1);
            paramString4.append("/0-0-");
            paramString4.append(paramString5.replace(".jpg", ""));
            paramString4.append("/0");
            paramString1 = paramString4.toString();
          }
        }
        else
        {
          paramString1 = "c2cpicdw.qpic.cn/offpic_new";
          if (!TextUtils.isEmpty(paramString2))
          {
            paramString1 = new StringBuilder();
            paramString1.append("c2cpicdw.qpic.cn/offpic_new");
            paramString1.append("/");
            paramString1.append(paramString2);
            paramString1 = paramString1.toString();
          }
          if (paramString5.startsWith("/"))
          {
            paramString4 = new StringBuilder();
            paramString4.append(paramString1);
            paramString4.append(paramString5);
            paramString4.append("/0");
            paramString1 = paramString4.toString();
          }
          else
          {
            paramString4 = new StringBuilder();
            paramString4.append(paramString1);
            paramString4.append("/");
            paramString4.append(paramString5);
            paramString4.append("/0");
            paramString1 = paramString4.toString();
          }
        }
      }
      catch (Throwable paramString2)
      {
        continue;
      }
      localIntent.putExtra("report_params", ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(paramString3, paramString1, paramString5, paramString2, paramIntent, paramInt1));
      continue;
      paramString1 = new StringBuilder();
      paramString1.append("onQRDecodeSucceed error:");
      paramString1.append(paramString2.getMessage());
      QLog.e("AIOGalleryScene", 1, paramString1.toString());
      RouteUtils.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, "/qrscan/scanner");
      return;
      if (paramBoolean)
      {
        paramIntent = null;
        paramInt1 = 4;
      }
      else
      {
        paramIntent = null;
        paramInt1 = 2;
        paramInt2 = 1;
        continue;
        str = "c2cpicdw.qpic.cn";
        continue;
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode()) {}
    try
    {
      if (AIODevLittleVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        break label52;
      }
      a(3);
    }
    catch (Throwable paramKeyEvent)
    {
      label36:
      break label36;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
    }
    label52:
    return true;
    return super.a(paramInt, paramKeyEvent);
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("distanceX=");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(" x1=");
      localStringBuilder.append(paramMotionEvent1.getRawX());
      localStringBuilder.append(" x2=");
      localStringBuilder.append(paramMotionEvent2.getRawX());
      localStringBuilder.append(" x2-x1=");
      localStringBuilder.append(paramMotionEvent2.getRawX() - paramMotionEvent1.getRawX());
      localStringBuilder.append(" alldis=");
      QLog.d("onScroll", 2, localStringBuilder.toString());
    }
    if (Math.abs(paramMotionEvent2.getRawX() - paramMotionEvent1.getRawX()) > this.jdField_l_of_type_Int) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.d();
    }
    return false;
  }
  
  boolean a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    return false;
  }
  
  boolean a(ActionSheet paramActionSheet, AIOImageData paramAIOImageData)
  {
    return false;
  }
  
  boolean a(String paramString, AIOImageData paramAIOImageData, File paramFile)
  {
    return false;
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
    if (localObject == null) {
      return;
    }
    ((ProgressPieDrawable)localObject).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setProgress] current:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a());
      ((StringBuilder)localObject).append(", progress:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.d(false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("%");
    ((ProgressPieDrawable)localObject).a(localStringBuilder.toString());
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_g_of_type_Boolean = true;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramLong, 0, 0, "", false);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i1);
    if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
    {
      ((AIOFileVideoData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("],download success, set downloadSuccess");
      QLog.i("FileVideoMediaPlayHelper.filevideoPeek", 1, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AIOGalleryScene.5(this));
  }
  
  public void b(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[TVKInfo] onPlayPause , id : ");
      if (paramVideoPlayMedioInfo == null)
      {
        paramVideoPlayMedioInfo = "null";
      }
      else
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(paramVideoPlayMedioInfo.jdField_a_of_type_Long);
        localStringBuilder2.append("");
        paramVideoPlayMedioInfo = localStringBuilder2.toString();
      }
      localStringBuilder1.append(paramVideoPlayMedioInfo);
      QLog.d("AIOGalleryScene", 2, localStringBuilder1.toString());
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b(VideoPlayMedioInfo paramVideoPlayMedioInfo, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TVKInfo] onDownloading, id : ");
      Object localObject;
      if (paramVideoPlayMedioInfo == null)
      {
        localObject = "null";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramVideoPlayMedioInfo.jdField_a_of_type_Long);
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    if (paramVideoPlayMedioInfo == null) {
      return;
    }
    paramVideoPlayMedioInfo = a(paramVideoPlayMedioInfo.jdField_a_of_type_Long, paramVideoPlayMedioInfo.jdField_b_of_type_Int);
    if (paramVideoPlayMedioInfo == null) {
      return;
    }
    paramVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_h_of_type_Boolean = true;
    if (!paramVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_g_of_type_Boolean)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText("");
      u();
    }
  }
  
  protected boolean b()
  {
    return this.jdField_c_of_type_Int != 1;
  }
  
  public void c()
  {
    VideoPlayControllerForAIO localVideoPlayControllerForAIO = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
    if ((localVideoPlayControllerForAIO != null) && (localVideoPlayControllerForAIO.c())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.h();
    }
  }
  
  public void c(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[TVKInfo] onPlayFinish , id : ");
      if (paramVideoPlayMedioInfo == null)
      {
        paramVideoPlayMedioInfo = "null";
      }
      else
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(paramVideoPlayMedioInfo.jdField_a_of_type_Long);
        localStringBuilder2.append("");
        paramVideoPlayMedioInfo = localStringBuilder2.toString();
      }
      localStringBuilder1.append(paramVideoPlayMedioInfo);
      QLog.d("AIOGalleryScene", 2, localStringBuilder1.toString());
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(100);
    u();
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showLoadPanel : ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (localObject == null) {
      return;
    }
    if (paramBoolean)
    {
      ((RelativeLayout)localObject).setVisibility(0);
      d(false);
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    ((RelativeLayout)localObject).setVisibility(8);
  }
  
  protected boolean c()
  {
    int i1 = this.jdField_c_of_type_Int;
    if (((i1 == -3321) || (i1 == 1)) && (!this.jdField_j_of_type_Boolean)) {
      return false;
    }
    i1 = this.jdField_e_of_type_Int;
    int i2 = -2147483648;
    if (i1 == -2147483648) {
      return false;
    }
    Iterator localIterator = ((ActivityManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("activity")).getRunningAppProcesses().iterator();
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      i1 = i2;
      if (!localIterator.hasNext()) {
        break;
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    } while (!localRunningAppProcessInfo.processName.endsWith("mobileqq"));
    i1 = localRunningAppProcessInfo.pid;
    return i1 == this.jdField_e_of_type_Int;
  }
  
  public void d()
  {
    y();
    VideoPlayControllerForAIO localVideoPlayControllerForAIO = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
    if (localVideoPlayControllerForAIO != null) {
      localVideoPlayControllerForAIO.d();
    }
  }
  
  public void d(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[TVKInfo] onBuffering, id : ");
      if (paramVideoPlayMedioInfo == null)
      {
        localObject1 = "null";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramVideoPlayMedioInfo.jdField_a_of_type_Long);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("AIOGalleryScene", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    if ((localObject1 != null) && (((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null))
    {
      if (paramVideoPlayMedioInfo == null) {
        return;
      }
      localObject2 = a(paramVideoPlayMedioInfo.jdField_a_of_type_Long, paramVideoPlayMedioInfo.jdField_b_of_type_Int);
      if (localObject2 != null) {
        ((AIORichMediaInfo)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_d_of_type_Boolean = true;
      }
      if ((((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramVideoPlayMedioInfo.jdField_a_of_type_Long) && (((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int == paramVideoPlayMedioInfo.jdField_b_of_type_Int)) {
        u();
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.v = paramBoolean;
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      if (this.v)
      {
        localTextView.setVisibility(0);
        return;
      }
      localTextView.setVisibility(4);
    }
  }
  
  public boolean e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (localObject != null)
    {
      if (((AIOImageListModel)localObject).a() == null) {
        return false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if ((localObject != null) && (AIOImageData.class.isInstance(localObject)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_c_of_type_Boolean))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress;
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b(((AIOGalleryScene.RawPhotoProgress)localObject).jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress.jdField_a_of_type_Int, 4);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaInfo$DataState.jdField_c_of_type_Boolean = false;
        u();
        return true;
      }
      d(false);
      boolean bool = super.e();
      y();
      localObject = a().findViewById(2131367440);
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
      if (this.jdField_j_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
        if (localObject != null)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", ((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
          this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
        }
      }
      if (this.jdField_m_of_type_Boolean) {
        this.jdField_a_of_type_AndroidAppActivity.setResult(-1, this.jdField_a_of_type_AndroidAppActivity.getIntent());
      }
      return bool;
    }
    return false;
  }
  
  public void f()
  {
    w();
    AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if (localAIORichMediaInfo != null) {
      localAIORichMediaInfo.jdField_b_of_type_Boolean = true;
    }
    if (!g()) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
    if (this.jdField_k_of_type_Int == 4) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.jdField_d_of_type_Boolean = false;
    u();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  public boolean f()
  {
    int i1 = UinTypeUtil.a(this.jdField_g_of_type_Int);
    boolean bool2 = false;
    if (i1 == 1032) {
      return false;
    }
    if (UinTypeUtil.a(this.jdField_g_of_type_Int) == 1044) {
      return false;
    }
    if (this.jdField_c_of_type_Boolean) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    boolean bool1 = true;
    if (localObject != null)
    {
      localObject = ((AIOImageListModel)localObject).a();
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        AIOImageData localAIOImageData = (AIOImageData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        File localFile = localAIOImageData.a(4);
        localObject = localFile;
        if (localFile == null) {
          localObject = localAIOImageData.a(2);
        }
        if ((localObject == null) && (this.u)) {
          return false;
        }
        bool1 = bool2;
        if (!this.u)
        {
          bool1 = bool2;
          if (!this.jdField_c_of_type_Boolean) {
            bool1 = true;
          }
        }
        return bool1;
      }
      if (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject = ((AIOShortVideoData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).a(1);
        if ((localObject != null) && (((File)localObject).exists())) {
          return bool1;
        }
        return false;
      }
      if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        if (!this.jdField_c_of_type_Boolean) {
          return true;
        }
      }
      else if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject = (AIOFileVideoData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if ((!this.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(((AIOFileVideoData)localObject).jdField_c_of_type_JavaLangString))) {
          return true;
        }
      }
    }
    bool1 = false;
    return bool1;
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.jdField_d_of_type_Boolean = true;
    u();
    if (!h()) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    ImageButton localImageButton = this.jdField_d_of_type_AndroidWidgetImageButton;
    if (localImageButton != null) {
      localImageButton.setVisibility(4);
    }
  }
  
  boolean g()
  {
    return false;
  }
  
  public void h()
  {
    if (!h()) {
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    ImageButton localImageButton = this.jdField_a_of_type_AndroidWidgetImageButton;
    if (localImageButton != null) {
      localImageButton.setVisibility(4);
    }
    localImageButton = this.jdField_d_of_type_AndroidWidgetImageButton;
    if (localImageButton != null) {
      localImageButton.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.jdField_f_of_type_Boolean = true;
    u();
  }
  
  boolean h()
  {
    return false;
  }
  
  public void h_()
  {
    r();
    VideoPlayControllerForAIO localVideoPlayControllerForAIO = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
    if (localVideoPlayControllerForAIO != null) {
      localVideoPlayControllerForAIO.i();
    }
  }
  
  public void i()
  {
    if (this.jdField_l_of_type_Boolean)
    {
      this.jdField_l_of_type_Boolean = false;
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatHistoryFileActivity.class);
      localIntent.addFlags(603979776);
      AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      if (localAIORichMediaInfo != null) {
        localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      }
      localIntent.putExtra("tab_tab_type", 0);
      localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("uintype", this.jdField_g_of_type_Int);
      localIntent.putExtra("extra.IS_FROM_CHAT_AIO_GALLERY", true);
      localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getString(2131690874));
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    if ((localObject != null) && (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) && (((AIOShortVideoData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int == 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
      if (localObject != null) {
        ((VideoPlayControllerForAIO)localObject).j();
      }
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    super.j();
    if (this.jdField_m_of_type_Int > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(this.jdField_m_of_type_Int);
      ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_spin", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
    }
    AIOGalleryMsgRevokeMgr.a().b(this);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
    if (localObject != null) {
      ((AIOGalleryAdapter)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
    if (localObject != null)
    {
      ((ShareActionSheetBuilder)localObject).setItemClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    }
    localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    LongVideoUrlCacheManager.a().a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader;
    if (localObject != null) {
      ((INonMainProcAvatarLoader)localObject).b();
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onStop");
    }
    super.n();
    D();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    if (localObject1 != null)
    {
      if (((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) {
        return;
      }
      Object localObject2 = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131372192);
      if (((((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)) && (((AIOShortVideoData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int == 1))
      {
        localObject1 = a();
        if (localObject1 != null)
        {
          localObject2 = ((AIOGalleryAdapter.GalleryImageStruct)localObject1).a();
          if ((localObject2 instanceof URLDrawable)) {
            ((URLDrawable)localObject2).pauseVideo();
          }
          ((AIOGalleryAdapter.GalleryImageStruct)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      else if (((((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)) && (((AIOShortVideoData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int == 0))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
        if (localObject1 != null) {
          ((VideoPlayControllerForAIO)localObject1).h();
        }
      }
      else if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
        if ((localObject1 != null) && (((VideoPlayControllerForAIO)localObject1).c())) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.h();
        }
      }
    }
  }
  
  public void o()
  {
    super.o();
    AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if (localAIORichMediaInfo != null) {
      localAIORichMediaInfo.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject;
    switch (i1)
    {
    default: 
      int i2;
      switch (i1)
      {
      default: 
        break;
      case 2131374217: 
        J();
        break;
      case 2131374216: 
        C();
        i1 = a();
        i2 = b();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(a("0X8009EFC"));
        ReportController.b(null, "dc00898", "", "", "0X8009EFC", "0X8009EFC", i1, i2, ((StringBuilder)localObject).toString(), "", "", "");
        break;
      case 2131374215: 
        ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "1", "", "", "");
        a(2);
        break;
      case 2131374214: 
        x();
        i1 = a();
        i2 = b();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(a("0X8009EFD"));
        ReportController.b(null, "dc00898", "", "", "0X8009EFD", "0X8009EFD", i1, i2, ((StringBuilder)localObject).toString(), "", "", "");
        break;
      case 2131374213: 
        H();
      }
      break;
    case 2131374219: 
      F();
      break;
    case 2131372192: 
      a(paramView);
      break;
    case 2131370699: 
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
      if ((localObject != null) && (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress != null)
        {
          e();
          e();
        }
      }
      else if ((localObject != null) && (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) && (((AIOImageData)((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$RawPhotoProgress != null))
      {
        e();
        e();
      }
      break;
    case 2131364704: 
      G();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismissOperations()
  {
    r();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onItemClick");
    }
    paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(paramInt);
    if ((paramAdapterView != null) && (paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null))
    {
      if ((AIOImageData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (AIOFilePicData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
        e();
      }
      MotionEvent localMotionEvent = ((DragGallery)this.jdField_a_of_type_ComTencentWidgetGallery).a();
      Object localObject;
      if (AIOShortVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        if (((AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_b_of_type_Int != 0)
        {
          if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))
          {
            localObject = (AIOGalleryAdapter.GalleryImageStruct)paramView;
            if (((AIOGalleryAdapter.GalleryImageStruct)localObject).a(localMotionEvent)) {
              ((AIOGalleryAdapter.GalleryImageStruct)localObject).b(paramInt);
            } else {
              e();
            }
          }
          else
          {
            e();
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
          if ((localObject != null) && (localMotionEvent != null) && (((VideoPlayControllerForAIO)localObject).a(localMotionEvent)))
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.jdField_b_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.f();
            }
          }
          else {
            e();
          }
        }
      }
      if (AIOFileVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
        if (localObject != null) {
          if ((localMotionEvent != null) && (localObject != null) && (((VideoPlayControllerForAIO)localObject).a(localMotionEvent)))
          {
            paramAdapterView = (AIOFileVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
            paramAdapterView.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO);
            paramAdapterView.jdField_d_of_type_Boolean = false;
            if (!TextUtils.isEmpty(paramAdapterView.jdField_c_of_type_JavaLangString)) {
              u();
            }
          }
          else
          {
            e();
          }
        }
      }
      return;
    }
    paramAdapterView = new StringBuilder();
    paramAdapterView.append("there data is null, position:");
    paramAdapterView.append(paramInt);
    QLog.e("AIOGalleryScene", 1, paramAdapterView.toString());
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ReportController.b(null, "CliOper", "", "", "View_pic", "View_pic_menu", 0, 0, "0", "", "", "");
    if (this.jdField_k_of_type_Int == 4) {
      return true;
    }
    try
    {
      if (AIODevLittleVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        break label85;
      }
      a(1);
      return true;
    }
    catch (Throwable paramAdapterView)
    {
      label69:
      label85:
      break label69;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AIOGalleryScene", 2, "showActionSheet oom");
    }
    return true;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    c(paramInt);
    d(false);
    this.jdField_a_of_type_ComTencentWidgetGallery.enableDoubleTap(true);
    this.jdField_a_of_type_ComTencentWidgetGallery.enableScaleGesture(true);
    if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(paramView))
    {
      localObject = (AIOGalleryAdapter.GalleryImageStruct)paramView;
      Drawable localDrawable = ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
      if ((!((AIOGalleryAdapter.GalleryImageStruct)localObject).a()) && (localDrawable != null) && ((localDrawable instanceof URLDrawable))) {
        a(paramAdapterView, paramView, paramInt, paramLong);
      } else if ((!((AIOGalleryAdapter.GalleryImageStruct)localObject).a()) && (localDrawable != null) && ((localDrawable instanceof SkinnableBitmapDrawable))) {
        d(paramInt);
      }
    }
    c(false);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
    if (localObject != null)
    {
      ((AIOGalleryAdapter)localObject).a(paramAdapterView, paramView, paramInt, paramLong);
      paramAdapterView = a().findViewById(2131367440);
      if (paramAdapterView != null)
      {
        if (paramAdapterView.getAnimation() != null)
        {
          paramAdapterView.getAnimation().cancel();
          paramAdapterView.setAnimation(null);
        }
        paramAdapterView.setVisibility(4);
      }
    }
    paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
    if (paramAdapterView != null) {
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(paramAdapterView.getThumbRect());
    }
    if (paramAdapterView != null) {
      if (((paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData)) && (((AIOFilePicData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_f_of_type_Boolean))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter;
        if (paramView != null)
        {
          paramView.a(paramInt, -1);
          ((AIOFilePicData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_f_of_type_Boolean = false;
        }
      }
      else if ((paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData))
      {
        c(false);
        this.jdField_a_of_type_MqqOsMqqHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    b(paramAdapterView);
    u();
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetMobile2None");
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetMobile2Wifi s=");
      localStringBuilder.append(paramString);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
    if (paramString != null) {
      paramString.d(1);
    }
    LongVideoUrlCacheManager.a().a();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetNone2Mobile s=");
      localStringBuilder.append(paramString);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    E();
    LongVideoUrlCacheManager.a().a();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetNone2Wifi s=");
      localStringBuilder.append(paramString);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    LongVideoUrlCacheManager.a().a();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetWifi2Mobile s=");
      localStringBuilder.append(paramString);
      QLog.d("AIOGalleryScene", 2, localStringBuilder.toString());
    }
    E();
    LongVideoUrlCacheManager.a().a();
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "onNetWifi2None");
    }
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramSeekBar = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      if ((paramSeekBar instanceof AIOShortVideoData))
      {
        paramSeekBar = (AIOShortVideoData)paramSeekBar;
        if (paramSeekBar.jdField_b_of_type_Int == 0)
        {
          paramSeekBar = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
          if (paramSeekBar != null)
          {
            paramInt = (int)(paramInt / 10000.0F * (float)paramSeekBar.b());
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.c(paramInt);
          }
        }
        else if (paramSeekBar.jdField_b_of_type_Int == 1)
        {
          Object localObject = a();
          if (localObject != null)
          {
            localObject = ((AIOGalleryAdapter.GalleryImageStruct)localObject).a();
            if ((localObject instanceof URLDrawable))
            {
              localObject = (URLDrawable)localObject;
              double d1 = paramInt;
              Double.isNaN(d1);
              d1 /= 10000.0D;
              double d2 = paramSeekBar.jdField_a_of_type_Int;
              Double.isNaN(d2);
              ((URLDrawable)localObject).seek((int)(d1 * d2 * 1000.0D));
            }
          }
        }
      }
      else if (AIOFileVideoData.class.isInstance(paramSeekBar))
      {
        paramSeekBar = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
        if (paramSeekBar != null)
        {
          paramInt = (int)(paramInt / 10000.0F * (float)paramSeekBar.b());
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.c(paramInt);
        }
      }
    }
  }
  
  public void onRotateFinished(View paramView, int paramInt1, int paramInt2) {}
  
  public void onScrollEnd(int paramInt)
  {
    super.onScrollEnd(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.jdField_a_of_type_Boolean = false;
    u();
  }
  
  public void onScrollStart(int paramInt)
  {
    super.onScrollStart(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.jdField_a_of_type_Boolean = true;
    u();
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    VideoPlayControllerForAIO localVideoPlayControllerForAIO = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
    if (localVideoPlayControllerForAIO != null) {
      localVideoPlayControllerForAIO.m();
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void p()
  {
    super.p();
    AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if (localAIORichMediaInfo != null) {
      localAIORichMediaInfo.jdField_b_of_type_Boolean = false;
    }
    this.jdField_k_of_type_Int = 3;
    this.t = true;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AIOGalleryActivity))
    {
      ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).jdField_c_of_type_Boolean = false;
      ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).jdField_a_of_type_Long = -1L;
    }
  }
  
  protected void r()
  {
    int i1;
    if (Build.VERSION.SDK_INT >= 19) {
      i1 = 4356;
    } else {
      i1 = 4;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setSystemUiVisibility(i1);
  }
  
  protected void u()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene$UIState.jdField_f_of_type_Boolean))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData)) {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a());
      } else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOImageData)) {
        a((AIOImageData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a());
      } else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFilePicData)) {
        a((AIOFilePicData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      } else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData)) {
        a((AIOFileVideoData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
      }
      if ((this.jdField_k_of_type_Int == 4) || (UinTypeUtil.a(this.jdField_g_of_type_Int) == 1032)) {
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryScene", 2, "updateUI selectedItem all gone");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    a(false);
  }
  
  public void v() {}
  
  @TargetApi(11)
  public void w()
  {
    if ((!this.u) && (!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b());
  }
  
  protected void x()
  {
    int i1;
    if (this.jdField_k_of_type_Int == 2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_l_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidAppActivity.onBackPressed();
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatHistoryActivity.class);
    localIntent.addFlags(536870912);
    localIntent.putExtra("tab_tab_type", 0);
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("SissionUin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_g_of_type_Int);
    localIntent.putExtra("extra.IS_FROM_CHAT_AIO_GALLERY", true);
    AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.a();
    if (localAIORichMediaInfo != null) {
      localIntent.putExtra("extra.EXTRA_CURRENT_IMAGE", localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData);
    }
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_AndroidAppActivity.getString(2131690874));
    this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", true);
    if (i1 == 0) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772337, 2130772277);
  }
  
  public void y()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel == null) {
        return;
      }
      int i1 = this.jdField_a_of_type_ComTencentWidgetGallery.getFirstVisiblePosition();
      int i2 = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
      if ((i3 >= i1) && (i3 <= i2 + i1 - 1))
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i3 - i1);
        if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localObject))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(i3, (AIOGalleryAdapter.GalleryImageStruct)localObject);
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO;
        if (localObject != null) {
          ((VideoPlayControllerForAIO)localObject).k();
        }
      }
    }
  }
  
  public void z()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.c() == 0)
    {
      a(false);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131692917, 0).a();
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
    else
    {
      a(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(true);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if (i1 == this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemPosition()) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(i1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene
 * JD-Core Version:    0.7.0.1
 */