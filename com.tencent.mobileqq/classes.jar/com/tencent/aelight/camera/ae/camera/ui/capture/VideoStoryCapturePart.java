package com.tencent.aelight.camera.ae.camera.ui.capture;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AECameraConfig;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.FILES;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.album.data.AEAlbumImageModel;
import com.tencent.aelight.camera.ae.album.data.AEAlbumVideoModel;
import com.tencent.aelight.camera.ae.album.data.AEPhotoCropInfoWrapper;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkDataManager;
import com.tencent.aelight.camera.ae.camera.util.AEVoiceVideoMergeUtil;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.play.AETakeFacePhotoPreviewFragment;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AEPreviewSizeUtil;
import com.tencent.aelight.camera.ae.util.AEThemeUtil;
import com.tencent.aelight.camera.ae.util.MediaCodecDPC;
import com.tencent.aelight.camera.aeeditor.AEEditorLauncher;
import com.tencent.aelight.camera.aeeditor.module.clip.image.EditorPicInfo;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QQStoryFlowCallback;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.util.JumpUtil;
import com.tencent.aelight.camera.aioeditor.setting.CaptureEntranceParams;
import com.tencent.aelight.camera.aioeditor.setting.CaptureVideoParams;
import com.tencent.aelight.camera.aioeditor.setting.CaptureVideoParams.CaptureVideoParamsBuilder;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.ScreenUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateThumbArgs;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishFileManager;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishVideoSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.biz.videostory.animator.AnimationBuilder;
import com.tencent.biz.videostory.animator.ViewAnimator;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarTintManager;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class VideoStoryCapturePart
  extends VideoStoryBasePart
{
  public static int a;
  private long jdField_a_of_type_Long = 0L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private AEPituCameraUnit jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
  private AECameraGLSurfaceView jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView;
  private AEVideoStoryTopBarViewModel.Ratio jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AECaptureMode jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode = null;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel;
  private VideoStoryDataBean jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  List<FrameVideoHelper.FrameBuffer> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = ((Long)VSConfigManager.a().a("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue();
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private View e;
  
  public VideoStoryCapturePart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
    jdField_a_of_type_Int = ViewUtils.a(60.0F) + ImmersiveUtils.getStatusBarHeight(paramActivity);
  }
  
  private int a()
  {
    int i = AEPreviewSizeUtil.a();
    int j = this.mActivity.getResources().getDimensionPixelSize(2063990794);
    int k = ImmersiveUtils.getStatusBarHeight(this.mActivity);
    if (i == 1) {
      return j + k;
    }
    return 0;
  }
  
  @NotNull
  private GenerateContext a(EditVideoParams.EditSource paramEditSource, int paramInt1, int paramInt2, String paramString1, float paramFloat, int paramInt3, String paramString2, boolean paramBoolean, String paramString3, EditVideoParams paramEditVideoParams)
  {
    GenerateContext localGenerateContext = new GenerateContext(paramEditVideoParams);
    localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
    if (MediaCodecDPC.f())
    {
      localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoMaxrate = (MediaCodecDPC.b() * 1000);
      localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("composite_key_bitrate_mode", Boolean.valueOf(MediaCodecDPC.f()));
    }
    localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoMinrate = CodecParam.mMinrate;
    localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoUploadGroupTempDir = paramString3;
    localGenerateContext.b = PublishFileManager.a(paramEditVideoParams.jdField_a_of_type_Int);
    localGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGenerateThumbArgs = new GenerateThumbArgs(this.mActivity, paramInt1, paramInt2, paramString1, paramFloat, false, paramInt3, 0.0D, 0.0D, paramString2, paramBoolean);
    if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
      localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(false));
    } else {
      localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(true));
    }
    localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("thumb_rotation", Integer.valueOf(paramInt3));
    paramEditSource = localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a("extra_text_filter_text");
    if (!TextUtils.isEmpty(paramEditSource))
    {
      if (TextUtils.isEmpty(localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoDoodleDescription))
      {
        localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoDoodleDescription = paramEditSource;
        return localGenerateContext;
      }
      paramString1 = new StringBuilder();
      paramString2 = localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry;
      paramString1.append(paramString2.videoDoodleDescription);
      paramString1.append(paramEditSource);
      paramString2.videoDoodleDescription = paramString1.toString();
    }
    return localGenerateContext;
  }
  
  @NotNull
  private static EditVideoParams a(Activity paramActivity, LocalMediaInfo paramLocalMediaInfo, CaptureVideoParams paramCaptureVideoParams, int paramInt1, Bundle paramBundle, EditVideoParams.EditSource paramEditSource, int paramInt2)
  {
    paramLocalMediaInfo = new EditVideoParams(paramInt2, paramInt1, paramEditSource, paramBundle);
    if (paramCaptureVideoParams != null) {
      paramLocalMediaInfo.jdField_b_of_type_Int = paramCaptureVideoParams.jdField_a_of_type_Int;
    }
    paramLocalMediaInfo.f = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    paramLocalMediaInfo.jdField_a_of_type_AndroidOsBundle.putBoolean("enable_hw_encode", true);
    if (QLog.isColorLevel())
    {
      paramCaptureVideoParams = new StringBuilder();
      paramCaptureVideoParams.append("EditVideoParams params:");
      paramCaptureVideoParams.append(paramLocalMediaInfo.toString());
      QLog.d("VideoStoryCapturePart", 2, paramCaptureVideoParams.toString());
    }
    long l = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
    if (l != 0L) {
      paramLocalMediaInfo.jdField_a_of_type_AndroidOsBundle.putLong("troop_uin", l);
    }
    return paramLocalMediaInfo;
  }
  
  private SimpleObserver<GenerateContext> a(int paramInt)
  {
    return new VideoStoryCapturePart.10(this, SystemClock.uptimeMillis(), paramInt);
  }
  
  @Nullable
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramString.indexOf("^");
    String str = paramString;
    if (i >= 0) {
      str = paramString.substring(i + 1);
    }
    return str;
  }
  
  private void a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    Object localObject = (ViewStub)this.mRootView.findViewById(2064122659);
    ViewStub localViewStub1 = (ViewStub)this.mRootView.findViewById(2064122655);
    ViewStub localViewStub2 = (ViewStub)this.mRootView.findViewById(2064122656);
    ViewStub localViewStub3 = (ViewStub)this.mRootView.findViewById(2064122657);
    ViewStub localViewStub4 = (ViewStub)this.mRootView.findViewById(2064122658);
    ViewStub localViewStub5 = (ViewStub)this.mRootView.findViewById(2064122654);
    ((ViewStub)localObject).inflate();
    localViewStub1.inflate();
    localViewStub2.inflate();
    localViewStub3.inflate();
    localViewStub4.inflate();
    localViewStub5.inflate();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mRootView.findViewById(2064121869));
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2064122017);
    this.jdField_b_of_type_AndroidViewView = this.mRootView.findViewById(2064122013);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new VideoStoryCapturePart.1(this));
    this.jdField_c_of_type_AndroidViewView = this.mRootView.findViewById(2064122014);
    this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new VideoStoryCapturePart.2(this));
    this.jdField_d_of_type_AndroidViewView = this.mRootView.findViewById(2064122015);
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(new VideoStoryCapturePart.3(this));
    this.e = this.mRootView.findViewById(2064122012);
    this.e.setOnTouchListener(new VideoStoryCapturePart.4(this));
    if (this.jdField_d_of_type_Boolean)
    {
      boolean bool = AEThemeUtil.a();
      localObject = this.mActivity.getResources();
      if (bool) {
        i = 2063925250;
      } else {
        i = 2063925252;
      }
      int i = ((Resources)localObject).getColor(i);
      this.jdField_d_of_type_AndroidViewView.setBackgroundColor(i);
      this.e.setBackgroundColor(i);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(i);
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(i);
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  private void a(int paramInt, com.tencent.mobileqq.activity.richmedia.Size paramSize)
  {
    long l1 = paramSize.jdField_a_of_type_Int * paramSize.jdField_b_of_type_Int;
    long l2 = this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.getWidth() * this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.getHeight();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("smooth2Size---oldArea=");
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append(", newArea=");
    ((StringBuilder)localObject).append(l1);
    AEQLog.a("VideoStoryCapturePart", ((StringBuilder)localObject).toString());
    if (l1 == l2) {
      return;
    }
    a();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    localObject = ViewAnimator.a(new View[] { this.jdField_b_of_type_AndroidViewView, this.jdField_c_of_type_AndroidViewView });
    float f = this.jdField_b_of_type_AndroidViewView.getWidth();
    double d1 = this.jdField_b_of_type_Int - paramSize.jdField_a_of_type_Int;
    Double.isNaN(d1);
    localObject = ((AnimationBuilder)localObject).d(new float[] { f, (int)Math.ceil(d1 / 2.0D) }).a(new View[] { this.jdField_d_of_type_AndroidViewView }).c(new float[] { this.jdField_d_of_type_AndroidViewView.getHeight(), paramInt }).a(new View[] { this.e }).c(new float[] { this.e.getHeight(), this.mRootView.getHeight() - paramInt - paramSize.jdField_b_of_type_Int });
    if (l1 > l2) {
      localObject = ((AnimationBuilder)localObject).a().a(300L);
    } else {
      localObject = ((AnimationBuilder)localObject).a(1.5F).a(500L);
    }
    ((ViewAnimator)localObject).a(new VideoStoryCapturePart.8(this)).a();
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = paramSize.jdField_a_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).height = paramSize.jdField_b_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void a(@NonNull AECaptureMode paramAECaptureMode)
  {
    if ((paramAECaptureMode == AECaptureMode.GIF) || (paramAECaptureMode == AECaptureMode.NORMAL))
    {
      int j = 0;
      int i;
      if (paramAECaptureMode == AECaptureMode.GIF)
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit != null)
        {
          if (this.jdField_a_of_type_Boolean)
          {
            i = this.jdField_d_of_type_Int;
            if (i != 0) {}
          }
          else
          {
            i = DisplayUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a(), 147.0F);
          }
        }
        else
        {
          float f;
          if (this.jdField_a_of_type_Boolean)
          {
            f = 0.0724138F;
            i = this.mRootView.getHeight();
          }
          else
          {
            f = 0.1810345F;
            i = this.mRootView.getHeight();
          }
          i = (int)(i * f);
        }
        i = (int)i;
      }
      else
      {
        i = j;
        if (this.jdField_d_of_type_Boolean) {
          if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == AEVideoStoryTopBarViewModel.Ratio.R_4_3)
          {
            i = a();
          }
          else
          {
            i = j;
            if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
              i = jdField_a_of_type_Int;
            }
          }
        }
      }
      paramAECaptureMode = AEPreviewSizeUtil.a();
      com.tencent.mobileqq.activity.richmedia.Size localSize = AEPreviewSizeUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode, paramAECaptureMode, this.jdField_d_of_type_Boolean, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      a(i, localSize);
      a(paramAECaptureMode, localSize);
    }
  }
  
  private void a(GenerateContext paramGenerateContext, int paramInt)
  {
    Activity localActivity = this.mActivity;
    if (localActivity != null)
    {
      AEQLog.a("VideoStoryCapturePart", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
      Object localObject = paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraStructEditorPublishParam;
      paramGenerateContext = new StringBuilder();
      paramGenerateContext.append("publishParam = ");
      paramGenerateContext.append(localObject);
      AEQLog.a("VideoStoryCapturePart", paramGenerateContext.toString());
      paramGenerateContext = localActivity.getIntent();
      boolean bool = false;
      int i;
      int j;
      if (paramGenerateContext != null)
      {
        i = paramGenerateContext.getIntExtra("sv_total_frame_count", 0);
        j = paramGenerateContext.getIntExtra("sv_total_record_time", 0);
      }
      else
      {
        i = 0;
        j = 0;
      }
      Intent localIntent = SaveVideoActivity.a(localActivity, ((PublishParam)localObject).b, j, i, paramInt);
      if (paramGenerateContext != null) {
        paramInt = paramGenerateContext.getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
      } else {
        paramInt = 0;
      }
      localIntent.putExtra("mediacodec_encode_enable", true);
      if (((PublishParam)localObject).e != 0) {
        bool = true;
      }
      localIntent.putExtra("video_edit_flag", bool);
      localIntent.putExtra("thumbfile_send_path", ((PublishParam)localObject).c);
      localIntent.putExtra("VIDEO_STORY_FROM_TYPE", paramInt);
      if (paramGenerateContext != null)
      {
        localIntent.putExtra("widgetinfo", paramGenerateContext.getStringExtra("widgetinfo"));
        localObject = paramGenerateContext.getStringExtra("key_camera_material_name");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start SaveVideoActivity---takeSameName=");
        localStringBuilder.append((String)localObject);
        AEQLog.b("VideoStoryCapturePart", localStringBuilder.toString());
        localIntent.putExtra("key_camera_material_name", (String)localObject);
        localIntent.putExtra("qqstory_slide_show_scene", paramGenerateContext.getIntExtra("qqstory_slide_show_scene", -1));
      }
      localActivity.startActivityForResult(localIntent, 1026);
    }
  }
  
  private void a(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    a(false);
    Object localObject2 = this.mActivity.getIntent();
    if (AECameraEntryManager.f((Intent)localObject2))
    {
      AEQLog.b("VideoStoryCapturePart", "handleNoNeedEditPhoto---from playMiniApp");
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
      localIntent.putExtra("file_path", paramAEPhotoCaptureResult.filePath);
      localIntent.putExtra("is_video", false);
      Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a();
      paramAEPhotoCaptureResult = (AEPhotoCaptureResult)localObject1;
      if (localObject1 == null) {
        paramAEPhotoCaptureResult = new HashMap();
      }
      localObject1 = ((Intent)localObject2).getStringExtra("widgetinfo");
      localObject2 = a((String)localObject1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleNoNeedEditPhoto---widgetId=");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(", widgetInfo=");
      localStringBuilder.append((String)localObject1);
      AEQLog.a("VideoStoryCapturePart", localStringBuilder.toString());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        paramAEPhotoCaptureResult.put("extra_info_key_widget_id", localObject2);
      }
      localIntent.putExtra("extra_info", paramAEPhotoCaptureResult);
      this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a().sendBroadcast(localIntent);
      this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a().setResult(-1, localIntent);
      this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a().finish();
    }
  }
  
  private void a(AEVideoCaptureResult paramAEVideoCaptureResult, CaptureEntranceParams paramCaptureEntranceParams, LocalMediaInfo paramLocalMediaInfo)
  {
    AEQLog.b("VideoStoryCapturePart", "handleNoNeedEditVideo---");
    ThreadManager.getUIHandler().post(new VideoStoryCapturePart.9(this));
    paramAEVideoCaptureResult = new EditTakeVideoSource(paramAEVideoCaptureResult.videoMp4FilePath, paramAEVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
    Bundle localBundle = new Bundle();
    int i = paramCaptureEntranceParams.a();
    paramCaptureEntranceParams = a(this.mActivity, paramLocalMediaInfo, null, 0, localBundle, paramAEVideoCaptureResult, i);
    paramLocalMediaInfo = paramCaptureEntranceParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource;
    int j = paramAEVideoCaptureResult.a();
    int k = paramAEVideoCaptureResult.b();
    Stream.of(a(paramLocalMediaInfo, j, k, paramAEVideoCaptureResult.a(), j * 1.0F / k, paramAEVideoCaptureResult.a.rotation, "", false, paramCaptureEntranceParams.a("extra_upload_temp_directory"), paramCaptureEntranceParams)).map(new ThreadOffFunction("VideoStoryCapturePart", 2)).map(new AEGenerateThumbnailSegment()).map(new PublishVideoSegment(paramCaptureEntranceParams)).subscribe(a(i));
  }
  
  private void a(AEVideoCaptureResult paramAEVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    AEQLog.b("VideoStoryCapturePart", "[VideoEnd] ready to enter EditorActivity");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AEPath.CAMERA.FILES.c);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".mp4");
    localObject = ((StringBuilder)localObject).toString();
    localObject = AEVoiceVideoMergeUtil.a(paramAEVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo.path, (String)localObject);
    paramAEVideoCaptureResult = (AEVideoCaptureResult)localObject;
    if (localObject == null) {
      paramAEVideoCaptureResult = paramLocalMediaInfo.path;
    }
    localObject = new Bundle();
    paramLocalMediaInfo = new ArrayList();
    paramLocalMediaInfo.add(paramAEVideoCaptureResult);
    ((Bundle)localObject).putStringArrayList("PhotoConst.SELECTED_PATHS", paramLocalMediaInfo);
    paramLocalMediaInfo = new ArrayList();
    AEAlbumVideoModel localAEAlbumVideoModel = new AEAlbumVideoModel(paramAEVideoCaptureResult);
    localAEAlbumVideoModel.setOriginPath(paramAEVideoCaptureResult);
    paramLocalMediaInfo.add(localAEAlbumVideoModel);
    ((Bundle)localObject).putSerializable("ae_album_selected_media_models", paramLocalMediaInfo);
    paramAEVideoCaptureResult = this.mActivity.getIntent().getStringExtra("material_id");
    if (!TextUtils.isEmpty(paramAEVideoCaptureResult))
    {
      ((Bundle)localObject).putString("material_id", paramAEVideoCaptureResult);
      ((Bundle)localObject).putString("material_topic", this.mActivity.getIntent().getStringExtra("material_topic"));
      ((Bundle)localObject).putString("key_camera_material_name", this.mActivity.getIntent().getStringExtra("key_camera_material_name"));
      this.mActivity.getIntent().removeExtra("material_id");
      this.mActivity.getIntent().removeExtra("material_topic");
      this.mActivity.getIntent().removeExtra("key_camera_material_name");
    }
    if (AEMaterialManager.a() != null)
    {
      paramLocalMediaInfo = AEMaterialManager.a().k;
      paramAEVideoCaptureResult = paramLocalMediaInfo;
      if (TextUtils.isEmpty(paramLocalMediaInfo)) {
        paramAEVideoCaptureResult = "none";
      }
      ((Bundle)localObject).putString("guajian_id", paramAEVideoCaptureResult);
    }
    if (AEMaterialManager.b() != null)
    {
      paramLocalMediaInfo = AEMaterialManager.b().k;
      paramAEVideoCaptureResult = paramLocalMediaInfo;
      if (TextUtils.isEmpty(paramLocalMediaInfo)) {
        paramAEVideoCaptureResult = "none";
      }
      ((Bundle)localObject).putString("water_mark_id", paramAEVideoCaptureResult);
    }
    paramAEVideoCaptureResult = this.mActivity.getIntent();
    int i = 0;
    ((Bundle)localObject).putInt("ae_editor_is_show_take_same", paramAEVideoCaptureResult.getIntExtra("ae_editor_is_show_take_same", 0));
    this.mActivity.getIntent().removeExtra("ae_editor_is_show_take_same");
    if ((Build.VERSION.SDK_INT < 23) || (this.mActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)) {
      i = 1;
    }
    if (i != 0)
    {
      AEQLog.b("VideoStoryCapturePart", "updateWMProps onGetLocation");
      WatermarkDataManager.a().a(new VideoStoryCapturePart.11(this));
    }
    i = c();
    AEEditorLauncher.a(this.mActivity, 1, (Bundle)localObject, i);
  }
  
  private void a(AEVideoCaptureResult paramAEVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, Integer paramInteger, CaptureEntranceParams paramCaptureEntranceParams, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b().e();
    if (i == 4)
    {
      a(paramAEVideoCaptureResult, paramLocalMediaInfo);
      return;
    }
    if (i == -2)
    {
      AEQLog.b("VideoStoryCapturePart", "enterVideoEditByConfig---no need edit");
      a(paramAEVideoCaptureResult, paramCaptureEntranceParams, paramLocalMediaInfo);
      return;
    }
    c(paramAEVideoCaptureResult, paramLocalMediaInfo, paramInteger, paramCaptureEntranceParams, paramQIMFilterCategoryItem);
  }
  
  private void a(com.tencent.mobileqq.activity.richmedia.Size paramSize1, com.tencent.mobileqq.activity.richmedia.Size paramSize2)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      int k = b();
      int j = this.mActivity.getResources().getDimensionPixelSize(2063990802);
      int m = this.mActivity.getResources().getDimensionPixelSize(2063990804);
      int i = j;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == AEVideoStoryTopBarViewModel.Ratio.R_4_3)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode == AECaptureMode.NORMAL) {
          i = Math.max(paramSize1.jdField_b_of_type_Int - k - paramSize2.jdField_b_of_type_Int + m, j);
        }
      }
      paramSize1 = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramSize1.height = i;
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramSize1);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
      {
        if (this.jdField_a_of_type_AndroidAppDialog == null)
        {
          this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.mActivity, 2131756189);
          this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
          this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
          this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559561);
        }
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
    }
    else
    {
      Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
    }
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 5))
    {
      AEVideoCaptureResult localAEVideoCaptureResult = (AEVideoCaptureResult)paramArrayOfObject[0];
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramArrayOfObject[1];
      Integer localInteger = (Integer)paramArrayOfObject[2];
      CaptureEntranceParams localCaptureEntranceParams = (CaptureEntranceParams)paramArrayOfObject[3];
      paramArrayOfObject = (QIMFilterCategoryItem)paramArrayOfObject[4];
      if (b()) {
        a(localAEVideoCaptureResult, localLocalMediaInfo, localInteger, localCaptureEntranceParams, paramArrayOfObject);
      } else {
        b(localAEVideoCaptureResult, localLocalMediaInfo, localInteger, localCaptureEntranceParams, paramArrayOfObject);
      }
      e();
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b() != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b().f() != -1);
  }
  
  private int b()
  {
    int i = AEPreviewSizeUtil.a();
    int j = this.mActivity.getResources().getDimensionPixelSize(2063990791);
    int k = this.mActivity.getResources().getDimensionPixelSize(2063990794);
    int m = ImmersiveUtils.getStatusBarHeight(this.mActivity);
    if (i == 1) {
      return j + m + k;
    }
    if (i == 2) {
      return j;
    }
    return 0;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = ((AEVideoStoryTopBarViewModel.Ratio)this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.getValue());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new VideoStoryCapturePart.5(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new VideoStoryCapturePart.6(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new VideoStoryCapturePart.7(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.c.postValue(Boolean.valueOf(this.jdField_b_of_type_Boolean));
  }
  
  private void b(AEVideoCaptureResult paramAEVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, Integer paramInteger, CaptureEntranceParams paramCaptureEntranceParams, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (paramInteger.intValue() == 13)
    {
      a(paramAEVideoCaptureResult, paramLocalMediaInfo);
      return;
    }
    c(paramAEVideoCaptureResult, paramLocalMediaInfo, paramInteger, paramCaptureEntranceParams, paramQIMFilterCategoryItem);
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "in photo end.");
    }
    if (a())
    {
      c(paramArrayOfObject);
      return;
    }
    d(paramArrayOfObject);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b() != null) && (this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b().e() != -1);
  }
  
  private int c()
  {
    int i = AECameraEntry.x.a();
    if (this.mActivity.getIntent() != null)
    {
      int j = this.mActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.x.a());
      i = j;
      if (j == AECameraEntry.A.a()) {
        i = AECameraEntry.z.a();
      }
    }
    return i;
  }
  
  private void c()
  {
    a(true);
  }
  
  private void c(AEVideoCaptureResult paramAEVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, Integer paramInteger, CaptureEntranceParams paramCaptureEntranceParams, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    AEQLog.a("VideoStoryCapturePart", "openVideoEditorWithVideo");
    Bundle localBundle1 = this.mActivity.getIntent().getExtras();
    Object localObject = new CaptureVideoParams.CaptureVideoParamsBuilder().a(paramCaptureEntranceParams.jdField_c_of_type_Int).c(10);
    if (AECameraEntryManager.g(this.mActivity.getIntent())) {
      ((CaptureVideoParams.CaptureVideoParamsBuilder)localObject).c(0);
    }
    if (AECameraEntryManager.l(this.mActivity.getIntent())) {
      ((CaptureVideoParams.CaptureVideoParamsBuilder)localObject).b(false);
    }
    paramCaptureEntranceParams.a(((CaptureVideoParams.CaptureVideoParamsBuilder)localObject).a());
    this.mActivity.getIntent().putExtra("extra_transiton_src_from", -1);
    Bundle localBundle2 = new Bundle();
    localBundle2.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable)this.jdField_a_of_type_JavaUtilList);
    localBundle2.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.jdField_a_of_type_Long);
    localBundle2.putInt("KEY_VIDEO_STORY_CAMERA_TYPE", paramInteger.intValue());
    paramInteger = WatermarkDataManager.a().a();
    if (paramInteger != null) {
      paramInteger = paramInteger.p;
    } else {
      paramInteger = "";
    }
    VideoStoryDataBean localVideoStoryDataBean = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
    boolean bool = TextUtils.isEmpty(paramInteger);
    localObject = "empty";
    if (bool) {
      paramInteger = "empty";
    }
    localVideoStoryDataBean.setWatermarkId(paramInteger);
    localVideoStoryDataBean = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
    if (paramQIMFilterCategoryItem != null) {
      paramInteger = paramQIMFilterCategoryItem.b;
    } else {
      paramInteger = "empty";
    }
    localVideoStoryDataBean.setFilterId(paramInteger);
    paramQIMFilterCategoryItem = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
    if (AEMaterialManager.a() == null) {
      paramInteger = "empty";
    } else {
      paramInteger = AEMaterialManager.a().k;
    }
    paramQIMFilterCategoryItem.setLensId(paramInteger);
    paramQIMFilterCategoryItem = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
    if (AEMaterialManager.a() == null) {
      paramInteger = (Integer)localObject;
    } else {
      paramInteger = Integer.valueOf(AEMaterialManager.a().jdField_b_of_type_Int);
    }
    paramQIMFilterCategoryItem.setLensTabId(String.valueOf(paramInteger));
    localBundle2.putSerializable("KEY_VIDEO_STORY_CAMERA_TYPE", this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean);
    this.mActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
    AEQLog.b("VideoStoryCapturePart", "[VideoEnd] jumpToEditVideoActivity");
    JumpUtil.a(this.mActivity, paramAEVideoCaptureResult, paramLocalMediaInfo, paramCaptureEntranceParams, localBundle2, this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b().b().intValue(), localBundle1);
  }
  
  private void c(Object[] paramArrayOfObject)
  {
    AECameraConfig localAECameraConfig = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterPhotoEditByConfig:  editType = ");
    localStringBuilder.append(localAECameraConfig.f());
    localStringBuilder.append(" args = ");
    localStringBuilder.append(paramArrayOfObject);
    AEQLog.a("VideoStoryCapturePart", localStringBuilder.toString());
    int i = localAECameraConfig.f();
    if (i != -2)
    {
      if (i != -1)
      {
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3) {
                return;
              }
              f(paramArrayOfObject);
              a(false);
              return;
            }
            e(paramArrayOfObject);
            a(false);
            return;
          }
          h(paramArrayOfObject);
          a(false);
          return;
        }
        g(paramArrayOfObject);
        a(false);
        return;
      }
      AEQLog.d("VideoStoryCapturePart", "【onPhotoEnd】editType undefined");
      return;
    }
    AEQLog.b("VideoStoryCapturePart", "enterPhotoEditByConfig: no need edit");
    a((AEPhotoCaptureResult)paramArrayOfObject[0]);
  }
  
  private void d()
  {
    e();
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setCaptureRequest(new VideoStoryCapturePart.12(this));
  }
  
  private void d(Object[] paramArrayOfObject)
  {
    Object localObject = this.mActivity.getIntent();
    int i;
    if (AECameraEntryManager.l((Intent)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterPhotoEditByEntry:  isFromARCake args = ");
      if (paramArrayOfObject != null) {
        i = paramArrayOfObject.length;
      } else {
        i = 0;
      }
      ((StringBuilder)localObject).append(i);
      AEQLog.a("VideoStoryCapturePart", ((StringBuilder)localObject).toString());
      h(paramArrayOfObject);
      a(false);
      return;
    }
    if (AECameraEntryManager.g((Intent)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterPhotoEditByEntry:  fromAIO args = ");
      if (paramArrayOfObject != null) {
        i = paramArrayOfObject.length;
      } else {
        i = 0;
      }
      ((StringBuilder)localObject).append(i);
      AEQLog.a("VideoStoryCapturePart", ((StringBuilder)localObject).toString());
      h(paramArrayOfObject);
      a(false);
      return;
    }
    if (AECameraEntryManager.k((Intent)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterPhotoEditByEntry:  fromCircle args = ");
      if (paramArrayOfObject != null) {
        i = paramArrayOfObject.length;
      } else {
        i = 0;
      }
      ((StringBuilder)localObject).append(i);
      AEQLog.a("VideoStoryCapturePart", ((StringBuilder)localObject).toString());
      g(paramArrayOfObject);
      a(false);
      return;
    }
    if (AECameraEntryManager.n((Intent)localObject))
    {
      h(paramArrayOfObject);
      a(false);
      return;
    }
    if ((!AECameraEntryManager.e((Intent)localObject)) && (AECameraEntryManager.a((Intent)localObject)))
    {
      if ((!AECameraEntryManager.i((Intent)localObject)) && (!AECameraEntryManager.j((Intent)localObject)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("【enterPhotoEditByEntry】: wrong entry: ");
        localStringBuilder.append(AECameraEntryManager.a((Intent)localObject));
        AEQLog.d("VideoStoryCapturePart", localStringBuilder.toString());
        ((Intent)localObject).putExtra("VIDEO_STORY_JUMP_TO_TYPE", 1);
        e(paramArrayOfObject);
        a(false);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterPhotoEditByEntry:  isFromQudongTakeFace args = ");
      if (paramArrayOfObject != null) {
        i = paramArrayOfObject.length;
      } else {
        i = 0;
      }
      ((StringBuilder)localObject).append(i);
      AEQLog.a("VideoStoryCapturePart", ((StringBuilder)localObject).toString());
      f(paramArrayOfObject);
      a(false);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enterPhotoEditByEntry:  isFromCheckEntry args = ");
    if (paramArrayOfObject != null) {
      i = paramArrayOfObject.length;
    } else {
      i = 0;
    }
    ((StringBuilder)localObject).append(i);
    AEQLog.a("VideoStoryCapturePart", ((StringBuilder)localObject).toString());
    e(paramArrayOfObject);
    a(false);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setCaptureRequest(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void e(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
    {
      AEPhotoCaptureResult localAEPhotoCaptureResult = (AEPhotoCaptureResult)paramArrayOfObject[0];
      Integer localInteger = (Integer)paramArrayOfObject[1];
      paramArrayOfObject = (Integer)paramArrayOfObject[2];
      if (QLog.isColorLevel()) {
        QLog.d("camera_log_tag_photo", 2, "in normal photo end.");
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", localAEPhotoCaptureResult.filePath);
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.mMimeType = "pic";
      this.mActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
      QQStoryFlowCallback.a(this.mActivity, localAEPhotoCaptureResult.filePath, localLocalMediaInfo, 0, (int)localLocalMediaInfo.mDuration, -1, 10023, 0, null, null, false, localInteger.intValue(), paramArrayOfObject.intValue(), localBundle);
      return;
    }
    AEQLog.d("VideoStoryCapturePart", "【openVideoEditorWithPhoto】args is null or args.length is less than 3");
  }
  
  private void f(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 1))
    {
      int i = AECameraEntryManager.a(this.mActivity.getIntent());
      Object localObject = (AEPhotoCaptureResult)paramArrayOfObject[0];
      paramArrayOfObject = new Intent();
      paramArrayOfObject.putExtra("VIDEO_STORY_FROM_TYPE", i);
      paramArrayOfObject.putExtra("photo_path", ((AEPhotoCaptureResult)localObject).filePath);
      paramArrayOfObject.putExtra("key_disable_face_detect", this.mActivity.getIntent().getBooleanExtra("key_disable_face_detect", false));
      paramArrayOfObject.putExtra("key_need_check_sensitive", this.mActivity.getIntent().getBooleanExtra("key_need_check_sensitive", false));
      localObject = this.mActivity;
      if (i == AECameraEntry.I.a()) {
        i = 1028;
      } else {
        i = 1024;
      }
      AETakeFacePhotoPreviewFragment.jumpToMeForResult((Activity)localObject, paramArrayOfObject, i);
      return;
    }
    AEQLog.d("VideoStoryCapturePart", "[openPhotoPreview] args must not be null or length < 1!");
  }
  
  private void g(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 1))
    {
      AEQLog.b("VideoStoryCapturePart", "[PhotoEnd] ready to enter EditorActivity");
      AEPhotoCaptureResult localAEPhotoCaptureResult = (AEPhotoCaptureResult)paramArrayOfObject[0];
      Bundle localBundle = new Bundle();
      paramArrayOfObject = new ArrayList();
      EditorPicInfo localEditorPicInfo = new EditorPicInfo();
      Object localObject = BitmapUtil.getImageSize(localAEPhotoCaptureResult.filePath);
      localEditorPicInfo.picPath = localAEPhotoCaptureResult.filePath;
      localEditorPicInfo.originPicHeight = ((com.tencent.tavcut.bean.Size)localObject).getHeight();
      localEditorPicInfo.originPicWidth = ((com.tencent.tavcut.bean.Size)localObject).getWidth();
      localEditorPicInfo.x = 0.0D;
      localEditorPicInfo.y = 0.0D;
      localEditorPicInfo.h = 1.0D;
      localEditorPicInfo.w = 1.0D;
      paramArrayOfObject.add(localEditorPicInfo);
      localBundle.putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", paramArrayOfObject);
      localBundle.putBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", this.mActivity.getIntent().getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true));
      paramArrayOfObject = this.mActivity.getIntent().getStringExtra("material_id");
      if (!TextUtils.isEmpty(paramArrayOfObject))
      {
        localBundle.putString("material_id", paramArrayOfObject);
        localBundle.putString("material_topic", this.mActivity.getIntent().getStringExtra("material_topic"));
        localBundle.putString("key_camera_material_name", this.mActivity.getIntent().getStringExtra("key_camera_material_name"));
        this.mActivity.getIntent().removeExtra("material_id");
        this.mActivity.getIntent().removeExtra("material_topic");
        this.mActivity.getIntent().removeExtra("key_camera_material_name");
      }
      if (AEMaterialManager.a() != null)
      {
        localObject = AEMaterialManager.a().k;
        paramArrayOfObject = (Object[])localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramArrayOfObject = "none";
        }
        localBundle.putString("guajian_id", paramArrayOfObject);
      }
      if (AEMaterialManager.b() != null)
      {
        localObject = AEMaterialManager.b().k;
        paramArrayOfObject = (Object[])localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramArrayOfObject = "none";
        }
        localBundle.putString("water_mark_id", paramArrayOfObject);
      }
      localBundle.putInt("ae_editor_is_show_take_same", this.mActivity.getIntent().getIntExtra("ae_editor_is_show_take_same", 0));
      paramArrayOfObject = new ArrayList();
      localObject = new AEPhotoCropInfoWrapper();
      ((AEPhotoCropInfoWrapper)localObject).a = localEditorPicInfo;
      localObject = new AEAlbumImageModel(localAEPhotoCaptureResult.filePath, ((AEPhotoCropInfoWrapper)localObject).a);
      ((AEAlbumImageModel)localObject).setOriginPath(localAEPhotoCaptureResult.filePath);
      paramArrayOfObject.add(localObject);
      localBundle.putSerializable("ae_album_selected_media_models", paramArrayOfObject);
      this.mActivity.getIntent().removeExtra("ae_editor_is_show_take_same");
      if (AECameraEntryManager.o(this.mActivity.getIntent()))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("ae_album_selected_media_models", paramArrayOfObject);
        this.mActivity.setResult(-1, (Intent)localObject);
        this.mActivity.finish();
        return;
      }
      int i = c();
      AEEditorLauncher.a(this.mActivity, 0, localBundle, i);
      AEBaseReportParam.a().a().jdField_b_of_type_Long = AEBaseReportParam.b.longValue();
      AEBaseReportParam.a().a().a = AEBaseReportParam.a().b();
      AEBaseDataReporter.a().a(1);
      return;
    }
    AEQLog.d("VideoStoryCapturePart", "[openAEEditorWithPhoto]: args must not be null or length < 1!");
  }
  
  private void h(Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "in aio photo end.");
    }
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
    {
      AEPhotoCaptureResult localAEPhotoCaptureResult = (AEPhotoCaptureResult)paramArrayOfObject[0];
      CaptureEntranceParams localCaptureEntranceParams = (CaptureEntranceParams)paramArrayOfObject[1];
      paramArrayOfObject = (Integer)paramArrayOfObject[2];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[openPicEditor]: result = ");
      localStringBuilder.append(localAEPhotoCaptureResult);
      localStringBuilder.append(" editFrom = ");
      localStringBuilder.append(paramArrayOfObject);
      localStringBuilder.append(" entranceParams.businessType = ");
      localStringBuilder.append(localCaptureEntranceParams.jdField_c_of_type_Int);
      AEQLog.d("VideoStoryCapturePart", localStringBuilder.toString());
      JumpUtil.a(this.mActivity, localAEPhotoCaptureResult, localCaptureEntranceParams, null, paramArrayOfObject.intValue());
      return;
    }
    AEQLog.d("VideoStoryCapturePart", "[openPicEditor]:args == null or args.length < 3!");
  }
  
  public <T> T get(int paramInt, Object... paramVarArgs)
  {
    return super.get(paramInt, paramVarArgs);
  }
  
  protected void initView()
  {
    this.jdField_d_of_type_Boolean = AECameraEntryManager.k(this.mActivity.getIntent());
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.mRootView.findViewById(2064122016));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.mRootView.findViewById(2064122220));
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
    this.jdField_b_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    this.jdField_c_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    if (ScreenUtil.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int)) {
      this.jdField_b_of_type_Int = (this.jdField_c_of_type_Int * 9 / 16);
    }
    LiuHaiUtils.d(this.mActivity);
    if (LiuHaiUtils.f()) {
      i = LiuHaiUtils.a();
    } else {
      i = 0;
    }
    if (SystemBarTintManager.hasNavBar(this.mActivity)) {
      j = SystemBarTintManager.getNavigationBarHeight(this.mActivity);
    } else {
      j = 0;
    }
    int i = this.jdField_c_of_type_Int - i - j;
    int j = DisplayUtil.a(this.mActivity, 700.0F);
    if (i < j) {
      this.jdField_a_of_type_Boolean = true;
    } else {
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (i < DisplayUtil.a(this.mActivity, 600.0F))
      {
        this.jdField_d_of_type_Int = DisplayUtil.a(this.mActivity, 58.799999F);
      }
      else
      {
        float f = (j - i) / DisplayUtil.a(this.mActivity, 100.0F);
        this.jdField_d_of_type_Int = DisplayUtil.a(this.mActivity, 147.0F - f * 88.199997F);
      }
      if (this.jdField_d_of_type_Int < DisplayUtil.a(this.mActivity, 110.0F))
      {
        this.jdField_b_of_type_Boolean = true;
        if (this.jdField_d_of_type_Int < DisplayUtil.a(this.mActivity, 92.0F)) {
          this.jdField_d_of_type_Int += DisplayUtil.a(this.mActivity, 12.0F);
        }
      }
    }
    b();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1026) || (paramInt1 == 1028))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onActivityResult--REQUEST_CODE_SKIP_EDIT_SAVE_VIDEO--resultCode=");
      ((StringBuilder)localObject1).append(paramInt2);
      AEQLog.b("VideoStoryCapturePart", ((StringBuilder)localObject1).toString());
      a(false);
      if (paramInt2 == -1)
      {
        Object localObject2 = this.mActivity.getIntent();
        if (AECameraEntryManager.f((Intent)localObject2))
        {
          AEQLog.b("VideoStoryCapturePart", "onActivityResult---success--from playMiniApp");
          Intent localIntent = new Intent();
          localIntent.setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
          if (paramInt1 == 1026)
          {
            localObject1 = paramIntent.getStringExtra("key_video_save_path");
            paramIntent = paramIntent.getStringExtra("thumbfile_send_path");
            localIntent.putExtra("file_path", (String)localObject1);
            localIntent.putExtra("video_thumb_path", paramIntent);
            localIntent.putExtra("is_video", true);
          }
          else
          {
            localIntent.putExtra("file_path", paramIntent.getStringExtra("take_photo_path"));
            localIntent.putExtra("is_video", false);
          }
          localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit.a();
          paramIntent = (Intent)localObject1;
          if (localObject1 == null) {
            paramIntent = new HashMap();
          }
          localObject1 = ((Intent)localObject2).getStringExtra("widgetinfo");
          localObject2 = a((String)localObject1);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleNoNeedEditVideo---widgetId=");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(", widgetInfo=");
          localStringBuilder.append((String)localObject1);
          AEQLog.a("VideoStoryCapturePart", localStringBuilder.toString());
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramIntent.put("extra_info_key_widget_id", localObject2);
          }
          localIntent.putExtra("extra_info", paramIntent);
          this.mActivity.sendBroadcast(localIntent);
          this.mActivity.setResult(-1, localIntent);
          this.mActivity.finish();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoStoryCapturePart", 2, "onDestroy()");
    }
    SendPanelManager.a().onDestroy();
    super.onDestroy();
    a(false);
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 262148: 
      b(paramVarArgs);
      return;
    case 262147: 
      c();
      return;
    case 262146: 
      a(paramVarArgs);
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart
 * JD-Core Version:    0.7.0.1
 */