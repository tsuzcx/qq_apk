import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;

public class blqw
  extends bmar
{
  public static int a;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bljy jdField_a_of_type_Bljy;
  private bmap jdField_a_of_type_Bmap;
  private VideoStoryDataBean jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private AEVideoStoryTopBarViewModel.Ratio jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  public List<FrameVideoHelper.FrameBuffer> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = ((Long)VSConfigManager.getInstance().getValue("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue();
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private View e;
  
  public blqw(Activity paramActivity, View paramView, bmas parambmas)
  {
    super(paramActivity, paramView, parambmas);
    this.jdField_a_of_type_Bljy = ((bljy)parambmas.a(65537, new Object[0]));
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
    jdField_a_of_type_Int = ViewUtils.dip2px(60.0F) + ImmersiveUtils.getStatusBarHeight(paramActivity);
  }
  
  private int a()
  {
    int i = 0;
    int j = bmbw.a();
    int k = this.mActivity.getResources().getDimensionPixelSize(2131296276);
    int m = ImmersiveUtils.getStatusBarHeight(this.mActivity);
    if (j == 1) {
      i = k + m;
    }
    while (j != 2) {
      return i;
    }
    return 0;
  }
  
  private void a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    Object localObject = (ViewStub)this.mRootView.findViewById(2131377891);
    ViewStub localViewStub1 = (ViewStub)this.mRootView.findViewById(2131377887);
    ViewStub localViewStub2 = (ViewStub)this.mRootView.findViewById(2131377888);
    ViewStub localViewStub3 = (ViewStub)this.mRootView.findViewById(2131377889);
    ViewStub localViewStub4 = (ViewStub)this.mRootView.findViewById(2131377890);
    ViewStub localViewStub5 = (ViewStub)this.mRootView.findViewById(2131377886);
    ((ViewStub)localObject).inflate();
    localViewStub1.inflate();
    localViewStub2.inflate();
    localViewStub3.inflate();
    localViewStub4.inflate();
    localViewStub5.inflate();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mRootView.findViewById(2131362237));
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2131364157);
    this.jdField_b_of_type_AndroidViewView = this.mRootView.findViewById(2131364153);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new blqx(this));
    this.jdField_c_of_type_AndroidViewView = this.mRootView.findViewById(2131364154);
    this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new blqy(this));
    this.jdField_d_of_type_AndroidViewView = this.mRootView.findViewById(2131364155);
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(new blqz(this));
    this.e = this.mRootView.findViewById(2131364152);
    this.e.setOnTouchListener(new blra(this));
    if (this.jdField_d_of_type_Boolean)
    {
      boolean bool = bmby.a();
      localObject = this.mActivity.getResources();
      if (!bool) {
        break label337;
      }
    }
    label337:
    for (int i = 2131165213;; i = 2131165215)
    {
      i = ((Resources)localObject).getColor(i);
      this.jdField_d_of_type_AndroidViewView.setBackgroundColor(i);
      this.e.setBackgroundColor(i);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(i);
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(i);
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  private void a(int paramInt, akur paramakur)
  {
    long l1 = paramakur.jdField_a_of_type_Int * paramakur.jdField_b_of_type_Int;
    long l2 = this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getWidth() * this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getHeight();
    bmbx.a("VideoStoryCapturePart", "smooth2Size---oldArea=" + l2 + ", newArea=" + l1);
    if (l1 == l2) {
      return;
    }
    a();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = zwd.a(new View[] { this.jdField_b_of_type_AndroidViewView, this.jdField_c_of_type_AndroidViewView }).d(new float[] { this.jdField_b_of_type_AndroidViewView.getWidth(), (int)Math.ceil((this.jdField_b_of_type_Int - paramakur.jdField_a_of_type_Int) / 2.0D) }).a(new View[] { this.jdField_d_of_type_AndroidViewView }).c(new float[] { this.jdField_d_of_type_AndroidViewView.getHeight(), paramInt }).a(new View[] { this.e }).c(new float[] { this.e.getHeight(), this.mRootView.getHeight() - paramInt - paramakur.jdField_b_of_type_Int });
    if (l1 > l2) {}
    for (localObject = ((zvt)localObject).a().a(300L);; localObject = ((zvt)localObject).a(1.5F).a(500L))
    {
      ((zwd)localObject).a(new blre(this)).a();
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = paramakur.jdField_a_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).height = paramakur.jdField_b_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  private void a(akur paramakur1, akur paramakur2)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      int k = b();
      int j = this.mActivity.getResources().getDimensionPixelSize(2131296279);
      int m = this.mActivity.getResources().getDimensionPixelSize(2131296281);
      int i = j;
      if (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == AEVideoStoryTopBarViewModel.Ratio.R_4_3)
      {
        i = j;
        if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL) {
          i = Math.max(paramakur1.jdField_b_of_type_Int - k - paramakur2.jdField_b_of_type_Int + m, j);
        }
      }
      paramakur1 = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramakur1.height = i;
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramakur1);
    }
  }
  
  private void a(AEVideoCaptureResult paramAEVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    bmbx.b("VideoStoryCapturePart", "[VideoEnd] ready to enter EditorActivity");
    Object localObject = bljm.c + File.separator + System.currentTimeMillis() + ".mp4";
    localObject = bluj.a(paramAEVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo.path, (String)localObject);
    paramAEVideoCaptureResult = (AEVideoCaptureResult)localObject;
    if (localObject == null) {
      paramAEVideoCaptureResult = paramLocalMediaInfo.path;
    }
    paramLocalMediaInfo = new Bundle();
    localObject = new ArrayList();
    ((ArrayList)localObject).add(paramAEVideoCaptureResult);
    paramLocalMediaInfo.putStringArrayList("PhotoConst.SELECTED_PATHS", (ArrayList)localObject);
    paramAEVideoCaptureResult = this.mActivity.getIntent().getStringExtra("material_id");
    if (!TextUtils.isEmpty(paramAEVideoCaptureResult))
    {
      paramLocalMediaInfo.putString("material_id", paramAEVideoCaptureResult);
      paramLocalMediaInfo.putString("key_camera_material_name", this.mActivity.getIntent().getStringExtra("key_camera_material_name"));
      this.mActivity.getIntent().removeExtra("material_id");
      this.mActivity.getIntent().removeExtra("key_camera_material_name");
    }
    paramLocalMediaInfo.putInt("ae_editor_is_show_take_same", this.mActivity.getIntent().getIntExtra("ae_editor_is_show_take_same", 0));
    this.mActivity.getIntent().removeExtra("ae_editor_is_show_take_same");
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (this.mActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        bmbx.b("VideoStoryCapturePart", "updateWMProps onGetLocation");
        bltp.a().a();
      }
      i = c();
      bmct.a(this.mActivity, 1, paramLocalMediaInfo, i);
      return;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  private void a(AEVideoCaptureResult paramAEVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, Integer paramInteger, bnbh parambnbh, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (this.jdField_a_of_type_Bljy.b().e() == 4)
    {
      a(paramAEVideoCaptureResult, paramLocalMediaInfo);
      return;
    }
    c(paramAEVideoCaptureResult, paramLocalMediaInfo, paramInteger, parambnbh, paramQIMFilterCategoryItem);
  }
  
  private void a(@NonNull AECaptureMode paramAECaptureMode)
  {
    int j;
    float f;
    int i;
    if ((paramAECaptureMode == AECaptureMode.GIF) || (paramAECaptureMode == AECaptureMode.NORMAL))
    {
      j = 0;
      if (paramAECaptureMode != AECaptureMode.GIF) {
        break label152;
      }
      if (this.jdField_a_of_type_Bljy == null) {
        break label109;
      }
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_d_of_type_Int == 0)) {
        break label91;
      }
      f = this.jdField_d_of_type_Int;
      i = (int)f;
    }
    for (;;)
    {
      paramAECaptureMode = bmbw.a();
      akur localakur = bmbw.a(this.jdField_a_of_type_DovComQqImAeModeAECaptureMode, paramAECaptureMode, this.jdField_d_of_type_Boolean, this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      a(i, localakur);
      a(paramAECaptureMode, localakur);
      return;
      label91:
      f = DisplayUtil.dip2px(this.jdField_a_of_type_Bljy.a(), 147.0F);
      break;
      label109:
      if (this.jdField_a_of_type_Boolean)
      {
        f = (int)(0.0724138F * this.mRootView.getHeight());
        break;
      }
      f = (int)(0.1810345F * this.mRootView.getHeight());
      break;
      label152:
      i = j;
      if (this.jdField_d_of_type_Boolean) {
        if (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == AEVideoStoryTopBarViewModel.Ratio.R_4_3)
        {
          i = a();
        }
        else
        {
          i = j;
          if (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
            i = jdField_a_of_type_Int;
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      if (!paramBoolean) {
        break label80;
      }
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.mActivity, 2131755826);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559574);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    label80:
    while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    AEVideoCaptureResult localAEVideoCaptureResult;
    LocalMediaInfo localLocalMediaInfo;
    Integer localInteger;
    bnbh localbnbh;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 5))
    {
      localAEVideoCaptureResult = (AEVideoCaptureResult)paramArrayOfObject[0];
      localLocalMediaInfo = (LocalMediaInfo)paramArrayOfObject[1];
      localInteger = (Integer)paramArrayOfObject[2];
      localbnbh = (bnbh)paramArrayOfObject[3];
      paramArrayOfObject = (QIMFilterCategoryItem)paramArrayOfObject[4];
      if (!b()) {
        break label70;
      }
      a(localAEVideoCaptureResult, localLocalMediaInfo, localInteger, localbnbh, paramArrayOfObject);
    }
    for (;;)
    {
      e();
      return;
      label70:
      b(localAEVideoCaptureResult, localLocalMediaInfo, localInteger, localbnbh, paramArrayOfObject);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Bljy.b() != null) && (this.jdField_a_of_type_Bljy.b().f() != -1);
  }
  
  private int b()
  {
    int j = bmbw.a();
    int i = this.mActivity.getResources().getDimensionPixelSize(2131296274);
    int k = this.mActivity.getResources().getDimensionPixelSize(2131296276);
    int m = ImmersiveUtils.getStatusBarHeight(this.mActivity);
    if (j == 1) {
      i = i + m + k;
    }
    while (j == 2) {
      return i;
    }
    return 0;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bmap = ((bmap)blks.a(this.jdField_a_of_type_Bljy).get(bmap.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)blks.a(this.jdField_a_of_type_Bljy).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = ((AEVideoStoryTopBarViewModel.Ratio)this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.getValue());
    this.jdField_a_of_type_Bmap.a.observe(this.jdField_a_of_type_Bljy, new blrb(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().observe(this.jdField_a_of_type_Bljy, new blrc(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_Bljy, new blrd(this));
    this.jdField_a_of_type_Bmap.c.postValue(Boolean.valueOf(this.jdField_b_of_type_Boolean));
  }
  
  private void b(AEVideoCaptureResult paramAEVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, Integer paramInteger, bnbh parambnbh, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (paramInteger.intValue() == 13)
    {
      a(paramAEVideoCaptureResult, paramLocalMediaInfo);
      return;
    }
    c(paramAEVideoCaptureResult, paramLocalMediaInfo, paramInteger, parambnbh, paramQIMFilterCategoryItem);
  }
  
  private void b(@NotNull AECaptureMode paramAECaptureMode)
  {
    bmbx.a("VideoStoryCapturePart", "checkSegByMode: mode = " + paramAECaptureMode);
    if ((paramAECaptureMode == AECaptureMode.NORMAL) && (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel != null))
    {
      bmbx.a("VideoStoryCapturePart", "【抠背开关】->post: false");
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().postValue(Boolean.valueOf(false));
    }
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
    return (this.jdField_a_of_type_Bljy.b() != null) && (this.jdField_a_of_type_Bljy.b().e() != -1);
  }
  
  private int c()
  {
    int i = blvr.x.a();
    if (this.mActivity.getIntent() != null)
    {
      int j = this.mActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", blvr.x.a());
      i = j;
      if (j == blvr.A.a()) {
        i = blvr.z.a();
      }
    }
    return i;
  }
  
  private void c()
  {
    a(true);
  }
  
  private void c(AEVideoCaptureResult paramAEVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, Integer paramInteger, bnbh parambnbh, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    Bundle localBundle = this.mActivity.getIntent().getExtras();
    Object localObject1 = new bnbn().a(parambnbh.jdField_c_of_type_Int).c(10);
    if (blvr.f(this.mActivity.getIntent())) {
      ((bnbn)localObject1).c(0);
    }
    parambnbh.a(((bnbn)localObject1).a());
    this.mActivity.getIntent().putExtra("extra_transiton_src_from", -1);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable)this.jdField_a_of_type_JavaUtilList);
    ((Bundle)localObject1).putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.jdField_a_of_type_Long);
    ((Bundle)localObject1).putInt("KEY_VIDEO_STORY_CAMERA_TYPE", paramInteger.intValue());
    Object localObject2 = bltp.a().a();
    paramInteger = "";
    if (localObject2 != null) {
      paramInteger = ((blvb)localObject2).f;
    }
    localObject2 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
    if (!TextUtils.isEmpty(paramInteger))
    {
      ((VideoStoryDataBean)localObject2).setWatermarkId(paramInteger);
      localObject2 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (paramQIMFilterCategoryItem == null) {
        break label311;
      }
      paramInteger = paramQIMFilterCategoryItem.b;
      label186:
      ((VideoStoryDataBean)localObject2).setFilterId(paramInteger);
      paramQIMFilterCategoryItem = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (bluy.a() != null) {
        break label318;
      }
      paramInteger = "empty";
      label208:
      paramQIMFilterCategoryItem.setLensId(paramInteger);
      paramQIMFilterCategoryItem = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (bluy.a() != null) {
        break label328;
      }
    }
    label311:
    label318:
    label328:
    for (paramInteger = "empty";; paramInteger = Integer.valueOf(bluy.a().jdField_a_of_type_Int))
    {
      paramQIMFilterCategoryItem.setLensTabId(String.valueOf(paramInteger));
      ((Bundle)localObject1).putSerializable("KEY_VIDEO_STORY_CAMERA_TYPE", this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean);
      this.mActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
      bmbx.b("VideoStoryCapturePart", "[VideoEnd] jumpToEditVideoActivity");
      bnxs.a(this.mActivity, paramAEVideoCaptureResult, paramLocalMediaInfo, parambnbh, (Bundle)localObject1, this.jdField_a_of_type_Bljy.b().b().intValue(), localBundle);
      return;
      paramInteger = "empty";
      break;
      paramInteger = "empty";
      break label186;
      paramInteger = bluy.a().jdField_a_of_type_JavaLangString;
      break label208;
    }
  }
  
  private void c(Object[] paramArrayOfObject)
  {
    blit localblit = this.jdField_a_of_type_Bljy.b();
    bmbx.a("VideoStoryCapturePart", "enterPhotoEditByConfig:  editType = " + localblit.f() + " args = " + paramArrayOfObject);
    switch (localblit.f())
    {
    default: 
      return;
    case 0: 
      g(paramArrayOfObject);
      a(false);
      return;
    case 3: 
      f(paramArrayOfObject);
      a(false);
      return;
    case 1: 
      h(paramArrayOfObject);
      a(false);
      return;
    case 2: 
      e(paramArrayOfObject);
      a(false);
      return;
    }
    bmbx.d("VideoStoryCapturePart", "【onPhotoEnd】editType undefined");
  }
  
  private void d()
  {
    e();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureRequest(new blrf(this));
  }
  
  private void d(Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder;
    int i;
    if (blvr.f(this.mActivity.getIntent()))
    {
      localStringBuilder = new StringBuilder().append("enterPhotoEditByEntry:  fromAIO args = ");
      if (paramArrayOfObject != null) {}
      for (i = paramArrayOfObject.length;; i = 0)
      {
        bmbx.a("VideoStoryCapturePart", i);
        h(paramArrayOfObject);
        a(false);
        return;
      }
    }
    if (blvr.j(this.mActivity.getIntent()))
    {
      localStringBuilder = new StringBuilder().append("enterPhotoEditByEntry:  fromCircle args = ");
      if (paramArrayOfObject != null) {}
      for (i = paramArrayOfObject.length;; i = 0)
      {
        bmbx.a("VideoStoryCapturePart", i);
        g(paramArrayOfObject);
        a(false);
        return;
      }
    }
    if (blvr.l(this.mActivity.getIntent()))
    {
      h(paramArrayOfObject);
      a(false);
      return;
    }
    if ((blvr.e(this.mActivity.getIntent())) || (!blvr.a(this.mActivity.getIntent())))
    {
      localStringBuilder = new StringBuilder().append("enterPhotoEditByEntry:  isFromCheckEntry args = ");
      if (paramArrayOfObject != null) {}
      for (i = paramArrayOfObject.length;; i = 0)
      {
        bmbx.a("VideoStoryCapturePart", i);
        e(paramArrayOfObject);
        a(false);
        return;
      }
    }
    if ((blvr.h(this.mActivity.getIntent())) || (blvr.i(this.mActivity.getIntent())))
    {
      localStringBuilder = new StringBuilder().append("enterPhotoEditByEntry:  isFromQudongTakeFace args = ");
      if (paramArrayOfObject != null) {}
      for (i = paramArrayOfObject.length;; i = 0)
      {
        bmbx.a("VideoStoryCapturePart", i);
        f(paramArrayOfObject);
        a(false);
        return;
      }
    }
    bmbx.d("VideoStoryCapturePart", "【enterPhotoEditByEntry】: wrong entry");
  }
  
  private void e()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureRequest(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void e(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3))
    {
      bmbx.d("VideoStoryCapturePart", "【openVideoEditorWithPhoto】args is null or args.length is less than 3");
      return;
    }
    blnp localblnp = (blnp)paramArrayOfObject[0];
    Integer localInteger = (Integer)paramArrayOfObject[1];
    paramArrayOfObject = (Integer)paramArrayOfObject[2];
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "in normal photo end.");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", localblnp.jdField_a_of_type_JavaLangString);
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.mMimeType = "pic";
    this.mActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
    bnsr.a(this.mActivity, localblnp.jdField_a_of_type_JavaLangString, localLocalMediaInfo, 0, (int)localLocalMediaInfo.mDuration, -1, 10023, 0, null, null, false, localInteger.intValue(), paramArrayOfObject.intValue(), localBundle);
  }
  
  private void f(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 1))
    {
      bmbx.d("VideoStoryCapturePart", "[openPhotoPreview] args must not be null or length < 1!");
      return;
    }
    paramArrayOfObject = (blnp)paramArrayOfObject[0];
    Intent localIntent = new Intent();
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", blvr.a(this.mActivity.getIntent()));
    localIntent.putExtra("photo_path", paramArrayOfObject.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key_disable_face_detect", this.mActivity.getIntent().getBooleanExtra("key_disable_face_detect", false));
    localIntent.putExtra("key_need_check_sensitive", this.mActivity.getIntent().getBooleanExtra("key_need_check_sensitive", false));
    AETakeFacePhotoPreviewFragment.jumpToMeForResult(this.mActivity, localIntent, 1024);
  }
  
  private void g(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 1))
    {
      bmbx.d("VideoStoryCapturePart", "[openAEEditorWithPhoto]: args must not be null or length < 1!");
      return;
    }
    bmbx.b("VideoStoryCapturePart", "[PhotoEnd] ready to enter EditorActivity");
    Object localObject = (blnp)paramArrayOfObject[0];
    paramArrayOfObject = new Bundle();
    ArrayList localArrayList = new ArrayList();
    EditorPicInfo localEditorPicInfo = new EditorPicInfo();
    Size localSize = BitmapUtil.getImageSize(((blnp)localObject).jdField_a_of_type_JavaLangString);
    localEditorPicInfo.picPath = ((blnp)localObject).jdField_a_of_type_JavaLangString;
    localEditorPicInfo.originPicHeight = localSize.getHeight();
    localEditorPicInfo.originPicWidth = localSize.getWidth();
    localEditorPicInfo.x = 0.0D;
    localEditorPicInfo.y = 0.0D;
    localEditorPicInfo.h = 1.0D;
    localEditorPicInfo.w = 1.0D;
    localArrayList.add(localEditorPicInfo);
    paramArrayOfObject.putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", localArrayList);
    localObject = this.mActivity.getIntent().getStringExtra("material_id");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramArrayOfObject.putString("material_id", (String)localObject);
      paramArrayOfObject.putString("key_camera_material_name", this.mActivity.getIntent().getStringExtra("key_camera_material_name"));
      this.mActivity.getIntent().removeExtra("material_id");
      this.mActivity.getIntent().removeExtra("key_camera_material_name");
    }
    paramArrayOfObject.putInt("ae_editor_is_show_take_same", this.mActivity.getIntent().getIntExtra("ae_editor_is_show_take_same", 0));
    this.mActivity.getIntent().removeExtra("ae_editor_is_show_take_same");
    int i = c();
    bmct.a(this.mActivity, 0, paramArrayOfObject, i);
    bmbg.a().a().jdField_b_of_type_Long = bmbg.b.longValue();
    bmbg.a().a().jdField_a_of_type_JavaLangString = bmbg.a().b();
    bmbc.a().a(1);
  }
  
  private void h(Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "in aio photo end.");
    }
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
    {
      blnp localblnp = (blnp)paramArrayOfObject[0];
      bnbh localbnbh = (bnbh)paramArrayOfObject[1];
      paramArrayOfObject = (Integer)paramArrayOfObject[2];
      bmbx.d("VideoStoryCapturePart", "[openPicEditor]: result = " + localblnp + " editFrom = " + paramArrayOfObject + " entranceParams.businessType = " + localbnbh.jdField_c_of_type_Int);
      bnxs.a(this.mActivity, localblnp, localbnbh, null, paramArrayOfObject.intValue());
      return;
    }
    bmbx.d("VideoStoryCapturePart", "[openPicEditor]:args == null or args.length < 3!");
  }
  
  public <T> T get(int paramInt, Object... paramVarArgs)
  {
    return super.get(paramInt, paramVarArgs);
  }
  
  protected void initView()
  {
    this.jdField_d_of_type_Boolean = blvr.j(this.mActivity.getIntent());
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.mRootView.findViewById(2131364156));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.mRootView.findViewById(2131366861));
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
    this.jdField_b_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    this.jdField_c_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    if (bodx.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int)) {
      this.jdField_b_of_type_Int = (this.jdField_c_of_type_Int * 9 / 16);
    }
    int i = DisplayUtil.dip2px(this.mActivity, 700.0F);
    if (this.jdField_c_of_type_Int < i)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Boolean)
      {
        int j = DisplayUtil.dip2px(this.mActivity, 600.0F);
        if (this.jdField_c_of_type_Int >= j) {
          break label265;
        }
      }
    }
    label265:
    float f;
    for (this.jdField_d_of_type_Int = DisplayUtil.dip2px(this.mActivity, 58.799999F);; this.jdField_d_of_type_Int = DisplayUtil.dip2px(this.mActivity, 147.0F - f * 88.199997F))
    {
      if (this.jdField_d_of_type_Int < DisplayUtil.dip2px(this.mActivity, 110.0F))
      {
        this.jdField_b_of_type_Boolean = true;
        if (this.jdField_d_of_type_Int < DisplayUtil.dip2px(this.mActivity, 92.0F)) {
          this.jdField_d_of_type_Int += DisplayUtil.dip2px(this.mActivity, 12.0F);
        }
      }
      b();
      return;
      this.jdField_a_of_type_Boolean = false;
      break;
      f = (i - this.jdField_c_of_type_Int) / DisplayUtil.dip2px(this.mActivity, 100.0F);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoStoryCapturePart", 2, "onDestroy()");
    }
    bnqa.a().onDestroy();
    super.onDestroy();
    a(false);
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 262145: 
      d();
      return;
    case 262146: 
      a(paramVarArgs);
      return;
    case 262147: 
      c();
      return;
    }
    b(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqw
 * JD-Core Version:    0.7.0.1
 */