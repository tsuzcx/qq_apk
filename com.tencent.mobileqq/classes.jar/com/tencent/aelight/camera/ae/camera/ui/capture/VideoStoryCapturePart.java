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
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.RequiresApi;
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
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
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
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
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
  public static int b;
  private boolean A;
  private boolean B;
  private boolean C = false;
  List<FrameVideoHelper.FrameBuffer> a;
  private AEVideoStoryCaptureModeViewModel c;
  private AEVideoStoryTopBarViewModel d;
  private AEPituCameraUnit e;
  private long f = 0L;
  private int g;
  private int h;
  private long i = ((Long)VSConfigManager.a().a("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue();
  private AECameraGLSurfaceView j;
  private ImageView k;
  private View l;
  private View m;
  private View n;
  private View o;
  private View p;
  private ViewGroup q;
  private Dialog r;
  private VideoStoryDataBean s;
  private boolean t = false;
  private boolean u = false;
  private int v = 0;
  private boolean w = false;
  private AEVideoStoryTopBarViewModel.Ratio x;
  private AECaptureMode y = null;
  private boolean z;
  
  public VideoStoryCapturePart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.e = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    this.s = new VideoStoryDataBean();
    b = ViewUtils.dip2px(60.0F) + ImmersiveUtils.getStatusBarHeight(paramActivity);
  }
  
  @NotNull
  private GenerateContext a(EditVideoParams.EditSource paramEditSource, int paramInt1, int paramInt2, String paramString1, float paramFloat, int paramInt3, String paramString2, boolean paramBoolean, String paramString3, EditVideoParams paramEditVideoParams)
  {
    GenerateContext localGenerateContext = new GenerateContext(paramEditVideoParams);
    localGenerateContext.d.videoMaxrate = CodecParam.mMaxrate;
    if (MediaCodecDPC.j())
    {
      localGenerateContext.d.videoMaxrate = (MediaCodecDPC.k() * 1000);
      localGenerateContext.d.putExtra("composite_key_bitrate_mode", Boolean.valueOf(MediaCodecDPC.j()));
    }
    localGenerateContext.d.videoMinrate = CodecParam.mMinrate;
    localGenerateContext.d.videoUploadGroupTempDir = paramString3;
    localGenerateContext.p = PublishFileManager.a(paramEditVideoParams.a);
    localGenerateContext.i = new GenerateThumbArgs(this.mActivity, paramInt1, paramInt2, paramString1, paramFloat, false, paramInt3, 0.0D, 0.0D, paramString2, paramBoolean);
    if ((!(paramEditSource instanceof EditTakeVideoSource)) && (!(paramEditSource instanceof EditLocalVideoSource))) {
      localGenerateContext.d.putExtra("is_hw_encode", Boolean.valueOf(false));
    } else {
      localGenerateContext.d.putExtra("is_hw_encode", Boolean.valueOf(true));
    }
    localGenerateContext.d.putExtra("thumb_rotation", Integer.valueOf(paramInt3));
    paramEditSource = localGenerateContext.a.a("extra_text_filter_text");
    if (!TextUtils.isEmpty(paramEditSource))
    {
      if (TextUtils.isEmpty(localGenerateContext.d.videoDoodleDescription))
      {
        localGenerateContext.d.videoDoodleDescription = paramEditSource;
        return localGenerateContext;
      }
      paramString1 = new StringBuilder();
      paramString2 = localGenerateContext.d;
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
      paramLocalMediaInfo.b = paramCaptureVideoParams.c;
    }
    paramLocalMediaInfo.h = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    paramLocalMediaInfo.d.putBoolean("enable_hw_encode", true);
    if (QLog.isColorLevel())
    {
      paramCaptureVideoParams = new StringBuilder();
      paramCaptureVideoParams.append("EditVideoParams params:");
      paramCaptureVideoParams.append(paramLocalMediaInfo.toString());
      QLog.d("VideoStoryCapturePart", 2, paramCaptureVideoParams.toString());
    }
    long l1 = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
    if (l1 != 0L) {
      paramLocalMediaInfo.d.putLong("troop_uin", l1);
    }
    return paramLocalMediaInfo;
  }
  
  private SimpleObserver<GenerateContext> a(int paramInt)
  {
    return new VideoStoryCapturePart.11(this, SystemClock.uptimeMillis(), paramInt);
  }
  
  @Nullable
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i1 = paramString.indexOf("^");
    String str = paramString;
    if (i1 >= 0) {
      str = paramString.substring(i1 + 1);
    }
    return str;
  }
  
  private void a()
  {
    if (this.w) {
      return;
    }
    Object localObject = (ViewStub)this.mRootView.findViewById(2063991448);
    ViewStub localViewStub1 = (ViewStub)this.mRootView.findViewById(2063991444);
    ViewStub localViewStub2 = (ViewStub)this.mRootView.findViewById(2063991445);
    ViewStub localViewStub3 = (ViewStub)this.mRootView.findViewById(2063991446);
    ViewStub localViewStub4 = (ViewStub)this.mRootView.findViewById(2063991447);
    ViewStub localViewStub5 = (ViewStub)this.mRootView.findViewById(2063991443);
    ((ViewStub)localObject).inflate();
    localViewStub1.inflate();
    localViewStub2.inflate();
    localViewStub3.inflate();
    localViewStub4.inflate();
    localViewStub5.inflate();
    this.k = ((ImageView)this.mRootView.findViewById(2063990787));
    this.l = this.mRootView.findViewById(2063990948);
    this.m = this.mRootView.findViewById(2063990944);
    this.m.setOnTouchListener(new VideoStoryCapturePart.1(this));
    this.n = this.mRootView.findViewById(2063990945);
    this.n.setOnTouchListener(new VideoStoryCapturePart.2(this));
    this.o = this.mRootView.findViewById(2063990946);
    this.o.setOnTouchListener(new VideoStoryCapturePart.3(this));
    this.p = this.mRootView.findViewById(2063990943);
    this.p.setOnTouchListener(new VideoStoryCapturePart.4(this));
    if (this.z)
    {
      boolean bool = AEThemeUtil.b();
      localObject = this.mActivity.getResources();
      if (bool) {
        i1 = 2063794178;
      } else {
        i1 = 2063794180;
      }
      int i1 = ((Resources)localObject).getColor(i1);
      this.o.setBackgroundColor(i1);
      this.p.setBackgroundColor(i1);
      this.m.setBackgroundColor(i1);
      this.n.setBackgroundColor(i1);
    }
    this.w = true;
  }
  
  @RequiresApi(api=21)
  private void a(float paramFloat, AECameraGLSurfaceView paramAECameraGLSurfaceView)
  {
    paramAECameraGLSurfaceView.setOutlineProvider(new VideoStoryCapturePart.9(this, paramFloat));
    paramAECameraGLSurfaceView.setClipToOutline(true);
  }
  
  private void a(int paramInt, com.tencent.mobileqq.activity.richmedia.Size paramSize)
  {
    c(paramInt, paramSize);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    localLayoutParams.width = paramSize.a;
    localLayoutParams.height = paramSize.b;
    localLayoutParams.topMargin = paramInt;
    this.j.setLayoutParams(localLayoutParams);
  }
  
  private void a(@NonNull AECaptureMode paramAECaptureMode)
  {
    if ((paramAECaptureMode == AECaptureMode.GIF) || (paramAECaptureMode == AECaptureMode.NORMAL))
    {
      int i2 = 0;
      int i1;
      if (paramAECaptureMode == AECaptureMode.GIF)
      {
        if (this.e != null)
        {
          if (this.t)
          {
            i1 = this.v;
            if (i1 != 0) {}
          }
          else
          {
            i1 = DisplayUtil.a(this.e.s(), 147.0F);
          }
        }
        else
        {
          float f1;
          if (this.t)
          {
            f1 = 0.0724138F;
            i1 = this.mRootView.getHeight();
          }
          else
          {
            f1 = 0.1810345F;
            i1 = this.mRootView.getHeight();
          }
          i1 = (int)(i1 * f1);
        }
        i1 = (int)i1;
      }
      else
      {
        i1 = i2;
        if (this.z) {
          if (this.x == AEVideoStoryTopBarViewModel.Ratio.R_4_3)
          {
            i1 = c();
          }
          else
          {
            i1 = i2;
            if (this.x == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
              i1 = b;
            }
          }
        }
      }
      paramAECaptureMode = AEPreviewSizeUtil.a();
      com.tencent.mobileqq.activity.richmedia.Size localSize = AEPreviewSizeUtil.a(this.y, paramAECaptureMode, this.z, this.x);
      if (this.z) {
        a(i1, localSize);
      } else if (this.y == AECaptureMode.NORMAL) {
        b(i1, paramAECaptureMode);
      } else {
        a(i1, localSize);
      }
      a(paramAECaptureMode, localSize);
    }
  }
  
  private void a(GenerateContext paramGenerateContext, int paramInt)
  {
    Activity localActivity = this.mActivity;
    if (localActivity != null)
    {
      AEQLog.a("VideoStoryCapturePart", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
      Object localObject = paramGenerateContext.m;
      paramGenerateContext = new StringBuilder();
      paramGenerateContext.append("publishParam = ");
      paramGenerateContext.append(localObject);
      AEQLog.a("VideoStoryCapturePart", paramGenerateContext.toString());
      paramGenerateContext = localActivity.getIntent();
      boolean bool = false;
      int i1;
      int i2;
      if (paramGenerateContext != null)
      {
        i1 = paramGenerateContext.getIntExtra("sv_total_frame_count", 0);
        i2 = paramGenerateContext.getIntExtra("sv_total_record_time", 0);
      }
      else
      {
        i1 = 0;
        i2 = 0;
      }
      Intent localIntent = SaveVideoActivity.a(localActivity, ((PublishParam)localObject).b, i2, i1, paramInt);
      if (paramGenerateContext != null) {
        paramInt = paramGenerateContext.getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
      } else {
        paramInt = 0;
      }
      localIntent.putExtra("mediacodec_encode_enable", true);
      if (((PublishParam)localObject).m != 0) {
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
    if (AECameraEntryManager.j((Intent)localObject2))
    {
      AEQLog.b("VideoStoryCapturePart", "handleNoNeedEditPhoto---from playMiniApp");
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
      localIntent.putExtra("file_path", paramAEPhotoCaptureResult.filePath);
      localIntent.putExtra("is_video", false);
      Object localObject1 = this.e.aJ();
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
      this.e.s().sendBroadcast(localIntent);
      this.e.s().setResult(-1, localIntent);
      this.e.s().finish();
    }
  }
  
  private void a(AEVideoCaptureResult paramAEVideoCaptureResult, CaptureEntranceParams paramCaptureEntranceParams, LocalMediaInfo paramLocalMediaInfo)
  {
    AEQLog.b("VideoStoryCapturePart", "handleNoNeedEditVideo---");
    ThreadManager.getUIHandler().post(new VideoStoryCapturePart.10(this));
    paramAEVideoCaptureResult = new EditTakeVideoSource(paramAEVideoCaptureResult.videoMp4FilePath, paramAEVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
    Bundle localBundle = new Bundle();
    int i1 = paramCaptureEntranceParams.a();
    paramCaptureEntranceParams = a(this.mActivity, paramLocalMediaInfo, null, 0, localBundle, paramAEVideoCaptureResult, i1);
    paramLocalMediaInfo = paramCaptureEntranceParams.e;
    int i2 = paramAEVideoCaptureResult.b();
    int i3 = paramAEVideoCaptureResult.c();
    Stream.of(a(paramLocalMediaInfo, i2, i3, paramAEVideoCaptureResult.a(), i2 * 1.0F / i3, paramAEVideoCaptureResult.b.rotation, "", false, paramCaptureEntranceParams.a("extra_upload_temp_directory"), paramCaptureEntranceParams)).map(new ThreadOffFunction("VideoStoryCapturePart", 2)).map(new AEGenerateThumbnailSegment()).map(new PublishVideoSegment(paramCaptureEntranceParams)).subscribe(a(i1));
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
    if (AEMaterialManager.n() != null)
    {
      paramLocalMediaInfo = AEMaterialManager.n().m;
      paramAEVideoCaptureResult = paramLocalMediaInfo;
      if (TextUtils.isEmpty(paramLocalMediaInfo)) {
        paramAEVideoCaptureResult = "none";
      }
      ((Bundle)localObject).putString("guajian_id", paramAEVideoCaptureResult);
    }
    if (AEMaterialManager.o() != null)
    {
      paramLocalMediaInfo = AEMaterialManager.o().m;
      paramAEVideoCaptureResult = paramLocalMediaInfo;
      if (TextUtils.isEmpty(paramLocalMediaInfo)) {
        paramAEVideoCaptureResult = "none";
      }
      ((Bundle)localObject).putString("water_mark_id", paramAEVideoCaptureResult);
    }
    paramAEVideoCaptureResult = this.mActivity.getIntent();
    int i1 = 0;
    ((Bundle)localObject).putInt("ae_editor_is_show_take_same", paramAEVideoCaptureResult.getIntExtra("ae_editor_is_show_take_same", 0));
    this.mActivity.getIntent().removeExtra("ae_editor_is_show_take_same");
    if ((Build.VERSION.SDK_INT < 23) || (this.mActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)) {
      i1 = 1;
    }
    if (i1 != 0)
    {
      AEQLog.b("VideoStoryCapturePart", "updateWMProps onGetLocation");
      WatermarkDataManager.a().a(new VideoStoryCapturePart.12(this));
    }
    i1 = j();
    AEEditorLauncher.a(this.mActivity, 1, (Bundle)localObject, i1);
  }
  
  private void a(AEVideoCaptureResult paramAEVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, Integer paramInteger, CaptureEntranceParams paramCaptureEntranceParams, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    int i1 = this.e.u().o();
    if (i1 == 4)
    {
      a(paramAEVideoCaptureResult, paramLocalMediaInfo);
      return;
    }
    if (i1 == -2)
    {
      AEQLog.b("VideoStoryCapturePart", "enterVideoEditByConfig---no need edit");
      a(paramAEVideoCaptureResult, paramCaptureEntranceParams, paramLocalMediaInfo);
      return;
    }
    c(paramAEVideoCaptureResult, paramLocalMediaInfo, paramInteger, paramCaptureEntranceParams, paramQIMFilterCategoryItem);
  }
  
  private void a(com.tencent.mobileqq.activity.richmedia.Size paramSize)
  {
    if (this.x == AEVideoStoryTopBarViewModel.Ratio.FULL)
    {
      d(0, paramSize);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    localLayoutParams.width = paramSize.a;
    localLayoutParams.height = (paramSize.b - DisplayUtil.a(BaseApplication.getContext(), 56.0F));
    localLayoutParams.topMargin = 0;
    paramSize = new StringBuilder();
    paramSize.append("adjustRatio lp.height: ");
    paramSize.append(localLayoutParams.height);
    paramSize.append(" : ");
    paramSize.append(localLayoutParams.topMargin);
    AEQLog.b("VideoStoryCapturePart", paramSize.toString());
    this.j.setLayoutParams(localLayoutParams);
    a(32.0F, this.j);
  }
  
  private void a(com.tencent.mobileqq.activity.richmedia.Size paramSize1, com.tencent.mobileqq.activity.richmedia.Size paramSize2)
  {
    if (this.z)
    {
      int i3 = d();
      int i2 = this.mActivity.getResources().getDimensionPixelSize(2063859729);
      int i4 = this.mActivity.getResources().getDimensionPixelSize(2063859731);
      int i1 = i2;
      if (this.x == AEVideoStoryTopBarViewModel.Ratio.R_4_3)
      {
        i1 = i2;
        if (this.y == AECaptureMode.NORMAL) {
          i1 = Math.max(paramSize1.b - i3 - paramSize2.b + i4, i2);
        }
      }
      paramSize1 = this.q.getLayoutParams();
      paramSize1.height = i1;
      this.q.setLayoutParams(paramSize1);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
      {
        if (this.r == null)
        {
          this.r = new Dialog(this.mActivity, 2131953338);
          this.r.setCancelable(false);
          this.r.setCanceledOnTouchOutside(false);
          this.r.setContentView(2131625585);
        }
        this.r.show();
      }
    }
    else
    {
      Dialog localDialog = this.r;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.r.dismiss();
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
      if (i()) {
        a(localAEVideoCaptureResult, localLocalMediaInfo, localInteger, localCaptureEntranceParams, paramArrayOfObject);
      } else {
        b(localAEVideoCaptureResult, localLocalMediaInfo, localInteger, localCaptureEntranceParams, paramArrayOfObject);
      }
      g();
    }
  }
  
  private void b()
  {
    this.c = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.e).get(AEVideoStoryCaptureModeViewModel.class));
    this.d = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.e).get(AEVideoStoryTopBarViewModel.class));
    this.x = ((AEVideoStoryTopBarViewModel.Ratio)this.d.a.getValue());
    this.d.d().observe(this.e, new VideoStoryCapturePart.5(this));
    this.c.a.observe(this.e, new VideoStoryCapturePart.6(this));
    this.d.a.observe(this.e, new VideoStoryCapturePart.7(this));
    this.c.c.postValue(Boolean.valueOf(this.u));
  }
  
  private void b(int paramInt, com.tencent.mobileqq.activity.richmedia.Size paramSize)
  {
    c(paramInt, paramSize);
    a(paramSize);
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
    QLog.i("camera_log_tag_photo", 1, "in photo end.");
    if (h())
    {
      c(paramArrayOfObject);
      return;
    }
    d(paramArrayOfObject);
  }
  
  private int c()
  {
    int i1 = AEPreviewSizeUtil.b();
    int i2 = this.mActivity.getResources().getDimensionPixelSize(2063859721);
    int i3 = ImmersiveUtils.getStatusBarHeight(this.mActivity);
    if (i1 == 1) {
      return i2 + i3;
    }
    return 0;
  }
  
  private void c(int paramInt, com.tencent.mobileqq.activity.richmedia.Size paramSize)
  {
    long l1 = paramSize.a * paramSize.b;
    long l2 = this.j.getWidth() * this.j.getHeight();
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
    this.l.setVisibility(0);
    int i1;
    if ((AEDashboardUtil.d()) && (this.y == AECaptureMode.NORMAL)) {
      i1 = 0;
    } else {
      i1 = this.mRootView.getHeight() - paramInt - paramSize.b;
    }
    localObject = ViewAnimator.a(new View[] { this.m, this.n });
    float f1 = this.m.getWidth();
    double d1 = this.g - paramSize.a;
    Double.isNaN(d1);
    paramSize = ((AnimationBuilder)localObject).f(new float[] { f1, (int)Math.ceil(d1 / 2.0D) }).a(new View[] { this.o }).e(new float[] { this.o.getHeight(), paramInt }).a(new View[] { this.p }).e(new float[] { this.p.getHeight(), i1 });
    if (l1 > l2) {
      paramSize = paramSize.c().a(300L);
    } else {
      paramSize = paramSize.b(1.5F).a(500L);
    }
    paramSize.a(new VideoStoryCapturePart.8(this)).b();
  }
  
  private void c(AEVideoCaptureResult paramAEVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, Integer paramInteger, CaptureEntranceParams paramCaptureEntranceParams, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    AEQLog.a("VideoStoryCapturePart", "openVideoEditorWithVideo");
    Bundle localBundle1 = this.mActivity.getIntent().getExtras();
    Object localObject = new CaptureVideoParams.CaptureVideoParamsBuilder().a(paramCaptureEntranceParams.c).c(10);
    if (AECameraEntryManager.k(this.mActivity.getIntent())) {
      ((CaptureVideoParams.CaptureVideoParamsBuilder)localObject).c(0);
    }
    if (AECameraEntryManager.q(this.mActivity.getIntent())) {
      ((CaptureVideoParams.CaptureVideoParamsBuilder)localObject).b(false);
    }
    paramCaptureEntranceParams.a(((CaptureVideoParams.CaptureVideoParamsBuilder)localObject).a());
    this.mActivity.getIntent().putExtra("extra_transiton_src_from", -1);
    Bundle localBundle2 = new Bundle();
    localBundle2.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable)this.a);
    localBundle2.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.f);
    localBundle2.putInt("KEY_VIDEO_STORY_CAMERA_TYPE", paramInteger.intValue());
    paramInteger = WatermarkDataManager.a().d();
    if (paramInteger != null) {
      paramInteger = paramInteger.t;
    } else {
      paramInteger = "";
    }
    VideoStoryDataBean localVideoStoryDataBean = this.s;
    boolean bool = TextUtils.isEmpty(paramInteger);
    localObject = "empty";
    if (bool) {
      paramInteger = "empty";
    }
    localVideoStoryDataBean.setWatermarkId(paramInteger);
    localVideoStoryDataBean = this.s;
    if (paramQIMFilterCategoryItem != null) {
      paramInteger = paramQIMFilterCategoryItem.b;
    } else {
      paramInteger = "empty";
    }
    localVideoStoryDataBean.setFilterId(paramInteger);
    paramQIMFilterCategoryItem = this.s;
    if (AEMaterialManager.n() == null) {
      paramInteger = "empty";
    } else {
      paramInteger = AEMaterialManager.n().m;
    }
    paramQIMFilterCategoryItem.setLensId(paramInteger);
    paramQIMFilterCategoryItem = this.s;
    if (AEMaterialManager.n() == null) {
      paramInteger = (Integer)localObject;
    } else {
      paramInteger = Integer.valueOf(AEMaterialManager.n().n);
    }
    paramQIMFilterCategoryItem.setLensTabId(String.valueOf(paramInteger));
    localBundle2.putSerializable("KEY_VIDEO_STORY_CAMERA_TYPE", this.s);
    this.mActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
    AEQLog.b("VideoStoryCapturePart", "[VideoEnd] jumpToEditVideoActivity");
    JumpUtil.a(this.mActivity, paramAEVideoCaptureResult, paramLocalMediaInfo, paramCaptureEntranceParams, localBundle2, this.e.u().v().intValue(), localBundle1);
  }
  
  private void c(Object[] paramArrayOfObject)
  {
    AECameraConfig localAECameraConfig = this.e.u();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterPhotoEditByConfig:  editType = ");
    localStringBuilder.append(localAECameraConfig.q());
    localStringBuilder.append(" args = ");
    localStringBuilder.append(paramArrayOfObject);
    AEQLog.b("VideoStoryCapturePart", localStringBuilder.toString());
    int i1 = localAECameraConfig.q();
    if (i1 != -2)
    {
      if (i1 != -1)
      {
        if (i1 != 0)
        {
          if (i1 != 1)
          {
            if (i1 != 2)
            {
              if (i1 != 3) {
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
  
  private int d()
  {
    int i1 = AEPreviewSizeUtil.b();
    int i2 = this.mActivity.getResources().getDimensionPixelSize(2063859718);
    int i3 = this.mActivity.getResources().getDimensionPixelSize(2063859721);
    int i4 = ImmersiveUtils.getStatusBarHeight(this.mActivity);
    if (i1 == 1) {
      return i2 + i4 + i3;
    }
    if (i1 == 2) {
      return i2;
    }
    return 0;
  }
  
  private void d(int paramInt, com.tencent.mobileqq.activity.richmedia.Size paramSize)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    localLayoutParams.width = paramSize.a;
    localLayoutParams.height = paramSize.b;
    localLayoutParams.topMargin = paramInt;
    paramSize = new StringBuilder();
    paramSize.append("adjustRatio lp.height: ");
    paramSize.append(localLayoutParams.height);
    paramSize.append(" : ");
    paramSize.append(localLayoutParams.topMargin);
    AEQLog.b("VideoStoryCapturePart", paramSize.toString());
    this.j.setLayoutParams(localLayoutParams);
  }
  
  private void d(Object[] paramArrayOfObject)
  {
    Object localObject = this.mActivity.getIntent();
    int i1;
    if (AECameraEntryManager.q((Intent)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterPhotoEditByEntry:  isFromARCake args = ");
      if (paramArrayOfObject != null) {
        i1 = paramArrayOfObject.length;
      } else {
        i1 = 0;
      }
      ((StringBuilder)localObject).append(i1);
      AEQLog.b("VideoStoryCapturePart", ((StringBuilder)localObject).toString());
      h(paramArrayOfObject);
      a(false);
      return;
    }
    if (AECameraEntryManager.k((Intent)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterPhotoEditByEntry:  fromAIO args = ");
      if (paramArrayOfObject != null) {
        i1 = paramArrayOfObject.length;
      } else {
        i1 = 0;
      }
      ((StringBuilder)localObject).append(i1);
      AEQLog.b("VideoStoryCapturePart", ((StringBuilder)localObject).toString());
      h(paramArrayOfObject);
      a(false);
      return;
    }
    if (AECameraEntryManager.o((Intent)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterPhotoEditByEntry:  fromCircle args = ");
      if (paramArrayOfObject != null) {
        i1 = paramArrayOfObject.length;
      } else {
        i1 = 0;
      }
      ((StringBuilder)localObject).append(i1);
      AEQLog.b("VideoStoryCapturePart", ((StringBuilder)localObject).toString());
      g(paramArrayOfObject);
      a(false);
      return;
    }
    if (AECameraEntryManager.s((Intent)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterPhotoEditByEntry:  fromAIOWeb args = ");
      if (paramArrayOfObject != null) {
        i1 = paramArrayOfObject.length;
      } else {
        i1 = 0;
      }
      ((StringBuilder)localObject).append(i1);
      AEQLog.b("VideoStoryCapturePart", ((StringBuilder)localObject).toString());
      h(paramArrayOfObject);
      a(false);
      return;
    }
    if ((!AECameraEntryManager.i((Intent)localObject)) && (AECameraEntryManager.c((Intent)localObject)))
    {
      if ((!AECameraEntryManager.m((Intent)localObject)) && (!AECameraEntryManager.n((Intent)localObject)))
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
        i1 = paramArrayOfObject.length;
      } else {
        i1 = 0;
      }
      ((StringBuilder)localObject).append(i1);
      AEQLog.b("VideoStoryCapturePart", ((StringBuilder)localObject).toString());
      f(paramArrayOfObject);
      a(false);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enterPhotoEditByEntry:  isFromCheckEntry args = ");
    if (paramArrayOfObject != null) {
      i1 = paramArrayOfObject.length;
    } else {
      i1 = 0;
    }
    ((StringBuilder)localObject).append(i1);
    AEQLog.b("VideoStoryCapturePart", ((StringBuilder)localObject).toString());
    e(paramArrayOfObject);
    a(false);
  }
  
  private void e()
  {
    a(true);
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
  
  private void f()
  {
    g();
    this.j.setCaptureRequest(new VideoStoryCapturePart.13(this));
  }
  
  private void f(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 1))
    {
      int i1 = AECameraEntryManager.a(this.mActivity.getIntent());
      Object localObject = (AEPhotoCaptureResult)paramArrayOfObject[0];
      paramArrayOfObject = new Intent();
      paramArrayOfObject.putExtra("VIDEO_STORY_FROM_TYPE", i1);
      paramArrayOfObject.putExtra("photo_path", ((AEPhotoCaptureResult)localObject).filePath);
      paramArrayOfObject.putExtra("key_disable_face_detect", this.mActivity.getIntent().getBooleanExtra("key_disable_face_detect", false));
      paramArrayOfObject.putExtra("key_need_check_sensitive", this.mActivity.getIntent().getBooleanExtra("key_need_check_sensitive", false));
      localObject = this.mActivity;
      if (i1 == AECameraEntry.I.a()) {
        i1 = 1028;
      } else {
        i1 = 1024;
      }
      AETakeFacePhotoPreviewFragment.jumpToMeForResult((Activity)localObject, paramArrayOfObject, i1);
      return;
    }
    AEQLog.d("VideoStoryCapturePart", "[openPhotoPreview] args must not be null or length < 1!");
  }
  
  private void g()
  {
    this.j.setCaptureRequest(null);
    this.a.clear();
    this.f = 0L;
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
      localEditorPicInfo.originPicHeight = ((com.tencent.qcircle.tavcut.bean.Size)localObject).getHeight();
      localEditorPicInfo.originPicWidth = ((com.tencent.qcircle.tavcut.bean.Size)localObject).getWidth();
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
      if (AEMaterialManager.n() != null)
      {
        localObject = AEMaterialManager.n().m;
        paramArrayOfObject = (Object[])localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramArrayOfObject = "none";
        }
        localBundle.putString("guajian_id", paramArrayOfObject);
      }
      if (AEMaterialManager.o() != null)
      {
        localObject = AEMaterialManager.o().m;
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
      if (AECameraEntryManager.t(this.mActivity.getIntent()))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("ae_album_selected_media_models", paramArrayOfObject);
        this.mActivity.setResult(-1, (Intent)localObject);
        this.mActivity.finish();
        return;
      }
      int i1 = j();
      AEEditorLauncher.a(this.mActivity, 0, localBundle, i1);
      AEBaseReportParam.a().n().v = AEBaseReportParam.b.longValue();
      AEBaseReportParam.a().n().d = AEBaseReportParam.a().S();
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
      localStringBuilder.append(localCaptureEntranceParams.c);
      AEQLog.d("VideoStoryCapturePart", localStringBuilder.toString());
      JumpUtil.a(this.mActivity, localAEPhotoCaptureResult, localCaptureEntranceParams, null, paramArrayOfObject.intValue());
      return;
    }
    AEQLog.d("VideoStoryCapturePart", "[openPicEditor]:args == null or args.length < 3!");
  }
  
  private boolean h()
  {
    return (this.e.u() != null) && (this.e.u().q() != -1);
  }
  
  private boolean i()
  {
    return (this.e.u() != null) && (this.e.u().o() != -1);
  }
  
  private int j()
  {
    int i1 = AECameraEntry.x.a();
    if (this.mActivity.getIntent() != null)
    {
      int i2 = this.mActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.x.a());
      i1 = i2;
      if (i2 == AECameraEntry.A.a()) {
        i1 = AECameraEntry.z.a();
      }
    }
    return i1;
  }
  
  public <T> T get(int paramInt, Object... paramVarArgs)
  {
    return super.get(paramInt, paramVarArgs);
  }
  
  protected void initView()
  {
    this.z = AECameraEntryManager.o(this.mActivity.getIntent());
    this.A = AECameraEntryManager.k(this.mActivity.getIntent());
    int i1 = AECameraEntryManager.h(this.mActivity.getIntent());
    this.B = AECameraEntryManager.e(i1);
    this.C = AECameraEntryManager.d(i1);
    this.j = ((AECameraGLSurfaceView)this.mRootView.findViewById(2063990947));
    this.q = ((ViewGroup)this.mRootView.findViewById(2063991102));
    this.a = new CopyOnWriteArrayList();
    this.s = new VideoStoryDataBean();
    this.g = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    this.h = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    if (ScreenUtil.a(this.g, this.h)) {
      this.g = (this.h * 9 / 16);
    }
    LiuHaiUtils.i(this.mActivity);
    if (LiuHaiUtils.g()) {
      i1 = LiuHaiUtils.h();
    } else {
      i1 = 0;
    }
    i1 = this.h - i1 - 0;
    int i2 = DisplayUtil.a(this.mActivity, 700.0F);
    if (i1 < i2) {
      this.t = true;
    } else {
      this.t = false;
    }
    if (this.t)
    {
      if (i1 < DisplayUtil.a(this.mActivity, 600.0F))
      {
        this.v = DisplayUtil.a(this.mActivity, 58.799999F);
      }
      else
      {
        float f1 = (i2 - i1) / DisplayUtil.a(this.mActivity, 100.0F);
        this.v = DisplayUtil.a(this.mActivity, 147.0F - f1 * 88.199997F);
      }
      if (this.v < DisplayUtil.a(this.mActivity, 110.0F)) {
        this.u = true;
      }
      i1 = DisplayUtil.a(this.mActivity, LiuHaiUtils.d + 60 + 24);
      if (this.v < i1) {
        this.v = i1;
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
        if (AECameraEntryManager.j((Intent)localObject2))
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
          localObject1 = this.e.aJ();
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
      e();
      return;
    case 262146: 
      a(paramVarArgs);
      return;
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart
 * JD-Core Version:    0.7.0.1
 */