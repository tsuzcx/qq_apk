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
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
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

public class bomp
  extends bowm
{
  public static int a;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bofh jdField_a_of_type_Bofh;
  private bowk jdField_a_of_type_Bowk;
  private VideoStoryDataBean jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private AEVideoStoryTopBarViewModel.Ratio jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  public List<FrameVideoHelper.FrameBuffer> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = ((Long)abac.a().a("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue();
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private View e;
  private View f;
  
  public bomp(Activity paramActivity, View paramView, bown parambown)
  {
    super(paramActivity, paramView, parambown);
    this.jdField_a_of_type_Bofh = ((bofh)parambown.a(65537, new Object[0]));
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
    jdField_a_of_type_Int = bhtq.a(60.0F) + ImmersiveUtils.getStatusBarHeight(paramActivity);
  }
  
  private int a()
  {
    int i = 0;
    int j = bpal.a();
    int k = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296275);
    int m = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
    if (j == 1) {
      i = k + m;
    }
    while (j != 2) {
      return i;
    }
    return 0;
  }
  
  private void a(int paramInt, alxc paramalxc)
  {
    long l1 = paramalxc.jdField_a_of_type_Int * paramalxc.jdField_b_of_type_Int;
    long l2 = this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getWidth() * this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getHeight();
    bpam.a("VideoStoryCapturePart", "smooth2Size---oldArea=" + l2 + ", newArea=" + l1);
    if (l1 == l2) {
      return;
    }
    b();
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    Object localObject = aazq.a(new View[] { this.jdField_c_of_type_AndroidViewView, this.jdField_d_of_type_AndroidViewView }).d(new float[] { this.jdField_c_of_type_AndroidViewView.getWidth(), (int)Math.ceil((this.jdField_b_of_type_Int - paramalxc.jdField_a_of_type_Int) / 2.0D) }).a(new View[] { this.e }).c(new float[] { this.e.getHeight(), paramInt }).a(new View[] { this.f }).c(new float[] { this.f.getHeight(), this.jdField_a_of_type_AndroidViewView.getHeight() - paramInt - paramalxc.jdField_b_of_type_Int });
    if (l1 > l2) {}
    for (localObject = ((aazg)localObject).a().a(300L);; localObject = ((aazg)localObject).a(1.5F).a(500L))
    {
      ((aazq)localObject).a(new bomx(this)).a();
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = paramalxc.jdField_a_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).height = paramalxc.jdField_b_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  private void a(alxc paramalxc1, alxc paramalxc2)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      int k = b();
      int j = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296278);
      int m = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296279);
      int i = j;
      if (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == AEVideoStoryTopBarViewModel.Ratio.R_4_3)
      {
        i = j;
        if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL) {
          i = Math.max(paramalxc1.jdField_b_of_type_Int - k - paramalxc2.jdField_b_of_type_Int + m, j);
        }
      }
      paramalxc1 = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramalxc1.height = i;
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramalxc1);
    }
  }
  
  private void a(@NonNull AECaptureMode paramAECaptureMode)
  {
    int j;
    float f1;
    int i;
    if ((paramAECaptureMode == AECaptureMode.GIF) || (paramAECaptureMode == AECaptureMode.NORMAL))
    {
      j = 0;
      if (paramAECaptureMode != AECaptureMode.GIF) {
        break label152;
      }
      if (this.jdField_a_of_type_Bofh == null) {
        break label109;
      }
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_d_of_type_Int == 0)) {
        break label91;
      }
      f1 = this.jdField_d_of_type_Int;
      i = (int)f1;
    }
    for (;;)
    {
      paramAECaptureMode = bpal.a();
      alxc localalxc = bpal.a(this.jdField_a_of_type_DovComQqImAeModeAECaptureMode, paramAECaptureMode, this.jdField_d_of_type_Boolean, this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      a(i, localalxc);
      a(paramAECaptureMode, localalxc);
      return;
      label91:
      f1 = bhgr.a(this.jdField_a_of_type_Bofh.a(), 147.0F);
      break;
      label109:
      if (this.jdField_a_of_type_Boolean)
      {
        f1 = (int)(0.0724138F * this.jdField_a_of_type_AndroidViewView.getHeight());
        break;
      }
      f1 = (int)(0.1810345F * this.jdField_a_of_type_AndroidViewView.getHeight());
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
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      if (!paramBoolean) {
        break label80;
      }
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidAppActivity, 2131755824);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559572);
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
    Object localObject1;
    Object localObject2;
    Object localObject4;
    bqaa localbqaa;
    Object localObject3;
    int i;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 5))
    {
      localObject1 = (AEVideoCaptureResult)paramArrayOfObject[0];
      localObject2 = (LocalMediaInfo)paramArrayOfObject[1];
      localObject4 = (Integer)paramArrayOfObject[2];
      localbqaa = (bqaa)paramArrayOfObject[3];
      localObject3 = (QIMFilterCategoryItem)paramArrayOfObject[4];
      if (((Integer)localObject4).intValue() != 13) {
        break label336;
      }
      bpam.b("VideoStoryCapturePart", "[VideoEnd] ready to enter EditorActivity");
      paramArrayOfObject = boev.c + File.separator + System.currentTimeMillis() + ".mp4";
      localObject1 = boqc.a(((AEVideoCaptureResult)localObject1).audioDataFilePath, ((LocalMediaInfo)localObject2).path, paramArrayOfObject);
      paramArrayOfObject = (Object[])localObject1;
      if (localObject1 == null) {
        paramArrayOfObject = ((LocalMediaInfo)localObject2).path;
      }
      localObject1 = new Bundle();
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(paramArrayOfObject);
      ((Bundle)localObject1).putStringArrayList("PhotoConst.SELECTED_PATHS", (ArrayList)localObject2);
      paramArrayOfObject = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("material_id");
      if (!TextUtils.isEmpty(paramArrayOfObject))
      {
        ((Bundle)localObject1).putString("material_id", paramArrayOfObject);
        ((Bundle)localObject1).putString("key_camera_material_name", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("key_camera_material_name"));
        this.jdField_a_of_type_AndroidAppActivity.getIntent().removeExtra("material_id");
        this.jdField_a_of_type_AndroidAppActivity.getIntent().removeExtra("key_camera_material_name");
      }
      ((Bundle)localObject1).putInt("ae_editor_is_show_take_same", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("ae_editor_is_show_take_same", 0));
      this.jdField_a_of_type_AndroidAppActivity.getIntent().removeExtra("ae_editor_is_show_take_same");
      if (Build.VERSION.SDK_INT < 23) {
        break label673;
      }
      if (this.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
        break label331;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        bpam.b("VideoStoryCapturePart", "updateWMProps onGetLocation");
        bopi.a().a();
      }
      i = c();
      bpbj.a(this.jdField_a_of_type_AndroidAppActivity, 1, (Bundle)localObject1, i);
      i();
      return;
      label331:
      i = 0;
      continue;
      label336:
      Bundle localBundle1 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      paramArrayOfObject = new bqag().a(localbqaa.jdField_c_of_type_Int).c(10).j(true);
      if (born.f(this.jdField_a_of_type_AndroidAppActivity.getIntent())) {
        paramArrayOfObject.c(0);
      }
      localbqaa.a(paramArrayOfObject.a());
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("extra_transiton_src_from", -1);
      Bundle localBundle2 = new Bundle();
      localBundle2.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable)this.jdField_a_of_type_JavaUtilList);
      localBundle2.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.jdField_a_of_type_Long);
      localBundle2.putInt("KEY_VIDEO_STORY_CAMERA_TYPE", ((Integer)localObject4).intValue());
      localObject4 = bopi.a().a();
      paramArrayOfObject = "";
      if (localObject4 != null) {
        paramArrayOfObject = ((boqu)localObject4).f;
      }
      localObject4 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (!TextUtils.isEmpty(paramArrayOfObject))
      {
        ((VideoStoryDataBean)localObject4).setWatermarkId(paramArrayOfObject);
        localObject4 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
        if (localObject3 == null) {
          break label643;
        }
        paramArrayOfObject = ((QIMFilterCategoryItem)localObject3).b;
        label524:
        ((VideoStoryDataBean)localObject4).setFilterId(paramArrayOfObject);
        localObject3 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
        if (boqr.a() != null) {
          break label650;
        }
        paramArrayOfObject = "empty";
        label546:
        ((VideoStoryDataBean)localObject3).setLensId(paramArrayOfObject);
        localObject3 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
        if (boqr.a() != null) {
          break label660;
        }
      }
      label643:
      label650:
      label660:
      for (paramArrayOfObject = "empty";; paramArrayOfObject = Integer.valueOf(boqr.a().jdField_a_of_type_Int))
      {
        ((VideoStoryDataBean)localObject3).setLensTabId(String.valueOf(paramArrayOfObject));
        localBundle2.putSerializable("KEY_VIDEO_STORY_CAMERA_TYPE", this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean);
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
        bpam.b("VideoStoryCapturePart", "[VideoEnd] jumpToEditVideoActivity");
        brdx.a(this.jdField_a_of_type_AndroidAppActivity, (CameraCaptureView.VideoCaptureResult)localObject1, (LocalMediaInfo)localObject2, localbqaa, localBundle2, 11, localBundle1);
        i();
        return;
        paramArrayOfObject = "empty";
        break;
        paramArrayOfObject = "empty";
        break label524;
        paramArrayOfObject = boqr.a().jdField_a_of_type_JavaLangString;
        break label546;
      }
      label673:
      i = 1;
    }
  }
  
  private int b()
  {
    int j = bpal.a();
    int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296273);
    int k = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296275);
    int m = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
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
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    Object localObject = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378120);
    ViewStub localViewStub1 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378116);
    ViewStub localViewStub2 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378117);
    ViewStub localViewStub3 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378118);
    ViewStub localViewStub4 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378119);
    ViewStub localViewStub5 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378115);
    ((ViewStub)localObject).inflate();
    localViewStub1.inflate();
    localViewStub2.inflate();
    localViewStub3.inflate();
    localViewStub4.inflate();
    localViewStub5.inflate();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362239));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364135);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364131);
    this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new bomq(this));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364132);
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(new bomr(this));
    this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131364133);
    this.e.setOnTouchListener(new boms(this));
    this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131364130);
    this.f.setOnTouchListener(new bomt(this));
    if (this.jdField_d_of_type_Boolean)
    {
      boolean bool = bpan.a();
      localObject = this.jdField_a_of_type_AndroidAppActivity.getResources();
      if (!bool) {
        break label350;
      }
    }
    label350:
    for (int i = 2131165213;; i = 2131165215)
    {
      i = ((Resources)localObject).getColor(i);
      this.e.setBackgroundColor(i);
      this.f.setBackgroundColor(i);
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(i);
      this.jdField_d_of_type_AndroidViewView.setBackgroundColor(i);
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  private void b(@NotNull AECaptureMode paramAECaptureMode)
  {
    if ((paramAECaptureMode == AECaptureMode.NORMAL) && (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel != null)) {
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().postValue(Boolean.valueOf(false));
    }
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "in photo end.");
    }
    if (born.f(this.jdField_a_of_type_AndroidAppActivity.getIntent()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("camera_log_tag_photo", 2, "in aio photo end.");
      }
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
      {
        localObject1 = (bbhq)paramArrayOfObject[0];
        paramArrayOfObject = (bqaa)paramArrayOfObject[1];
        a(false);
        brdx.a(this.jdField_a_of_type_AndroidAppActivity, (bbhq)localObject1, paramArrayOfObject, null, 1);
      }
    }
    Object localObject2;
    do
    {
      return;
      if (born.j(this.jdField_a_of_type_AndroidAppActivity.getIntent()))
      {
        bpam.b("VideoStoryCapturePart", "[PhotoEnd] ready to enter EditorActivity");
        localObject1 = (bbhq)paramArrayOfObject[0];
        a(false);
        paramArrayOfObject = new Bundle();
        localObject2 = new ArrayList();
        EditorPicInfo localEditorPicInfo = new EditorPicInfo();
        Size localSize = BitmapUtil.getImageSize(((bbhq)localObject1).jdField_a_of_type_JavaLangString);
        localEditorPicInfo.picPath = ((bbhq)localObject1).jdField_a_of_type_JavaLangString;
        localEditorPicInfo.originPicHeight = localSize.getHeight();
        localEditorPicInfo.originPicWidth = localSize.getWidth();
        localEditorPicInfo.x = 0.0D;
        localEditorPicInfo.y = 0.0D;
        localEditorPicInfo.h = 1.0D;
        localEditorPicInfo.w = 1.0D;
        ((ArrayList)localObject2).add(localEditorPicInfo);
        paramArrayOfObject.putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", (Serializable)localObject2);
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("material_id");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramArrayOfObject.putString("material_id", (String)localObject1);
          paramArrayOfObject.putString("key_camera_material_name", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("key_camera_material_name"));
          this.jdField_a_of_type_AndroidAppActivity.getIntent().removeExtra("material_id");
          this.jdField_a_of_type_AndroidAppActivity.getIntent().removeExtra("key_camera_material_name");
        }
        paramArrayOfObject.putInt("ae_editor_is_show_take_same", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("ae_editor_is_show_take_same", 0));
        this.jdField_a_of_type_AndroidAppActivity.getIntent().removeExtra("ae_editor_is_show_take_same");
        int i = c();
        bpbj.a(this.jdField_a_of_type_AndroidAppActivity, 0, paramArrayOfObject, i);
        bozv.a().a().jdField_b_of_type_Long = bozv.b.longValue();
        bozv.a().a().jdField_a_of_type_JavaLangString = bozv.a().b();
        bozr.a().a(1);
        return;
      }
    } while ((paramArrayOfObject == null) || (paramArrayOfObject.length != 2));
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "arg len = 2");
    }
    Object localObject1 = (bbhq)paramArrayOfObject[0];
    paramArrayOfObject = (QIMFilterCategoryItem)paramArrayOfObject[1];
    paramArrayOfObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    if ((born.e(paramArrayOfObject)) || (!born.a(this.jdField_a_of_type_AndroidAppActivity.getIntent())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("camera_log_tag_photo", 2, "in normal photo end.");
      }
      paramArrayOfObject = new Bundle();
      paramArrayOfObject.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", ((bbhq)localObject1).jdField_a_of_type_JavaLangString);
      localObject2 = new LocalMediaInfo();
      ((LocalMediaInfo)localObject2).mMimeType = "pic";
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
      bqyp.a(this.jdField_a_of_type_AndroidAppActivity, ((bbhq)localObject1).jdField_a_of_type_JavaLangString, (LocalMediaInfo)localObject2, 0, (int)((LocalMediaInfo)localObject2).mDuration, -1, 10023, 0, null, null, false, 11, 14, paramArrayOfObject);
      a(false);
      return;
    }
    if ((born.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (born.i(this.jdField_a_of_type_AndroidAppActivity.getIntent())))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("VIDEO_STORY_FROM_TYPE", born.a(paramArrayOfObject));
      ((Intent)localObject2).putExtra("photo_path", ((bbhq)localObject1).jdField_a_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("key_disable_face_detect", paramArrayOfObject.getBooleanExtra("key_disable_face_detect", false));
      ((Intent)localObject2).putExtra("key_need_check_sensitive", paramArrayOfObject.getBooleanExtra("key_need_check_sensitive", false));
      AETakeFacePhotoPreviewFragment.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1024);
      a(false);
      return;
    }
    bpam.d("VideoStoryCapturePart", "【onPhotoEnd】wrong entry");
  }
  
  private int c()
  {
    int i = born.x.a();
    if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null)
    {
      int j = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", born.x.a());
      i = j;
      if (j == born.A.a()) {
        i = born.z.a();
      }
    }
    return i;
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bowk = ((bowk)bofz.a(this.jdField_a_of_type_Bofh).get(bowk.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)bofz.a(this.jdField_a_of_type_Bofh).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = ((AEVideoStoryTopBarViewModel.Ratio)this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.getValue());
    this.jdField_a_of_type_Bowk.a.observe(this.jdField_a_of_type_Bofh, new bomu(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().observe(this.jdField_a_of_type_Bofh, new bomv(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_Bofh, new bomw(this));
    this.jdField_a_of_type_Bowk.c.postValue(Boolean.valueOf(this.jdField_b_of_type_Boolean));
  }
  
  private void f()
  {
    a(true);
  }
  
  private void h()
  {
    i();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureRequest(new bomy(this));
  }
  
  private void i()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureRequest(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Long = 0L;
  }
  
  public <T> T a(int paramInt, Object... paramVarArgs)
  {
    return super.a(paramInt, paramVarArgs);
  }
  
  protected void a()
  {
    this.jdField_d_of_type_Boolean = born.j(this.jdField_a_of_type_AndroidAppActivity.getIntent());
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364134));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131366837));
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
    this.jdField_b_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    this.jdField_c_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    if (brkm.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int)) {
      this.jdField_b_of_type_Int = (this.jdField_c_of_type_Int * 9 / 16);
    }
    int i = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 700.0F);
    if (this.jdField_c_of_type_Int < i)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Boolean)
      {
        int j = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 600.0F);
        if (this.jdField_c_of_type_Int >= j) {
          break label265;
        }
      }
    }
    label265:
    float f1;
    for (this.jdField_d_of_type_Int = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 58.799999F);; this.jdField_d_of_type_Int = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 147.0F - f1 * 88.199997F))
    {
      if (this.jdField_d_of_type_Int < bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 110.0F))
      {
        this.jdField_b_of_type_Boolean = true;
        if (this.jdField_d_of_type_Int < bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 92.0F)) {
          this.jdField_d_of_type_Int += bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 12.0F);
        }
      }
      e();
      return;
      this.jdField_a_of_type_Boolean = false;
      break;
      f1 = (i - this.jdField_c_of_type_Int) / bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 100.0F);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 262145: 
      h();
      return;
    case 262146: 
      a(paramVarArgs);
      return;
    case 262147: 
      f();
      return;
    }
    b(paramVarArgs);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoStoryCapturePart", 2, "onDestroy()");
    }
    bqvm.a().onDestroy();
    super.g();
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bomp
 * JD-Core Version:    0.7.0.1
 */