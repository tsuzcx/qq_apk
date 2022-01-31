import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.util.BitmapUtil;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.7;
import dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.8;
import dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.9;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class bkvx
  extends blfs
{
  private final float jdField_a_of_type_Float = 147.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bkpl jdField_a_of_type_Bkpl;
  private bkyq jdField_a_of_type_Bkyq;
  private blfq jdField_a_of_type_Blfq;
  private VideoStoryDataBean jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private final String jdField_a_of_type_JavaLangString = "VideoStoryCapturePart";
  public List<FrameVideoHelper.FrameBuffer> a;
  private boolean jdField_a_of_type_Boolean;
  private final float jdField_b_of_type_Float = 58.799999F;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = ((Long)yyw.a().a("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue();
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private final float jdField_c_of_type_Float = 60.0F;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private final int jdField_d_of_type_Int = 700;
  private View jdField_d_of_type_AndroidViewView;
  private final int jdField_e_of_type_Int = 600;
  private View jdField_e_of_type_AndroidViewView;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private int g;
  
  public bkvx(Activity paramActivity, View paramView, blft paramblft)
  {
    super(paramActivity, paramView, paramblft);
    this.jdField_a_of_type_Bkpl = ((bkpl)paramblft.a(65537, new Object[0]));
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
  }
  
  private int a()
  {
    int i = blat.x.a();
    if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null)
    {
      int j = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", blat.x.a());
      i = j;
      if (j == blat.A.a()) {
        i = blat.z.a();
      }
    }
    return i;
  }
  
  private void a(@NotNull blfi paramblfi)
  {
    AECaptureMode localAECaptureMode = paramblfi.jdField_a_of_type_DovComQqImAeModeAECaptureMode;
    bljn.b("VideoStoryCapturePart", "checkAniByMode--captureMode=" + localAECaptureMode);
    if (localAECaptureMode == AECaptureMode.NORMAL) {
      if ((AECaptureMode.NORMAL.getIsCirclrMode()) || ((paramblfi.jdField_a_of_type_Int != 1) && (paramblfi.jdField_a_of_type_Int != 2)))
      {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.p();
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBlockCameraFlag(false);
        bksp.a().c(axph.a());
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.o();
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        this.jdField_a_of_type_Blfq.a(true);
        a(new VideoStoryCapturePart.7(this));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.jdField_a_of_type_DovComQqImAeModeAECaptureMode = localAECaptureMode;
      return;
      if (localAECaptureMode == AECaptureMode.GIF)
      {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.p();
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBlockCameraFlag(false);
        bksp.a().c(1);
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.o();
        this.jdField_a_of_type_Blfq.a(true);
        b(new VideoStoryCapturePart.8(this));
      }
      else if (localAECaptureMode == AECaptureMode.PLAY)
      {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.p();
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBlockCameraFlag(true);
        this.jdField_a_of_type_Blfq.a(true);
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        ThreadManager.getUIHandler().postDelayed(new VideoStoryCapturePart.9(this), 200L);
      }
    }
  }
  
  private void a(@NotNull AECaptureMode paramAECaptureMode)
  {
    if ((paramAECaptureMode == AECaptureMode.NORMAL) && (this.jdField_a_of_type_Bkyq != null)) {
      this.jdField_a_of_type_Bkyq.b().a(Boolean.valueOf(false));
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      ThreadManager.getUIHandler().post(paramRunnable);
      return;
    }
    yyk.a(new View[] { this.jdField_c_of_type_AndroidViewView, this.jdField_d_of_type_AndroidViewView }).d(new float[] { this.jdField_c_of_type_AndroidViewView.getWidth(), 0.0F }).a(new View[] { this.jdField_e_of_type_AndroidViewView }).c(new float[] { this.jdField_e_of_type_AndroidViewView.getHeight(), 0.0F }).a(new View[] { this.jdField_f_of_type_AndroidViewView }).c(new float[] { this.jdField_f_of_type_AndroidViewView.getHeight(), 0.0F }).a().a(300L).a(new bkwb(this)).a(new bkwa(this, paramRunnable)).a();
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
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131755801);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559437);
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
    bmgz localbmgz;
    Object localObject3;
    int i;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 5))
    {
      localObject1 = (AEVideoCaptureResult)paramArrayOfObject[0];
      localObject2 = (LocalMediaInfo)paramArrayOfObject[1];
      localObject4 = (Integer)paramArrayOfObject[2];
      localbmgz = (bmgz)paramArrayOfObject[3];
      localObject3 = (QIMFilterCategoryItem)paramArrayOfObject[4];
      if (((Integer)localObject4).intValue() != 13) {
        break label247;
      }
      bljn.b("VideoStoryCapturePart", "[VideoEnd] ready to enter EditorActivity");
      paramArrayOfObject = bkoz.c + File.separator + System.currentTimeMillis() + ".mp4";
      localObject1 = bkzn.a(((AEVideoCaptureResult)localObject1).audioDataFilePath, ((LocalMediaInfo)localObject2).path, paramArrayOfObject);
      paramArrayOfObject = (Object[])localObject1;
      if (localObject1 == null) {
        paramArrayOfObject = ((LocalMediaInfo)localObject2).path;
      }
      localObject1 = new Bundle();
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(paramArrayOfObject);
      ((Bundle)localObject1).putStringArrayList("PhotoConst.SELECTED_PATHS", (ArrayList)localObject2);
      ((Bundle)localObject1).putString("material_id", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("widgetinfo"));
      if (Build.VERSION.SDK_INT < 23) {
        break label576;
      }
      if (this.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
        break label242;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        bljn.b("VideoStoryCapturePart", "updateWMProps onGetLocation");
        bkyt.a().a();
      }
      i = a();
      bljx.a(this.jdField_a_of_type_AndroidAppActivity, 1, (Bundle)localObject1, i);
      p();
      return;
      label242:
      i = 0;
      continue;
      label247:
      Bundle localBundle1 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      paramArrayOfObject = new bmhf().a(localbmgz.jdField_c_of_type_Int).c(10).j(true);
      if (blat.f(this.jdField_a_of_type_AndroidAppActivity.getIntent())) {
        paramArrayOfObject.c(0);
      }
      localbmgz.a(paramArrayOfObject.a());
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("extra_transiton_src_from", -1);
      Bundle localBundle2 = new Bundle();
      localBundle2.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable)this.jdField_a_of_type_JavaUtilList);
      localBundle2.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.jdField_a_of_type_Long);
      localBundle2.putInt("KEY_VIDEO_STORY_CAMERA_TYPE", ((Integer)localObject4).intValue());
      localObject4 = bkyt.a().a();
      paramArrayOfObject = "";
      if (localObject4 != null) {
        paramArrayOfObject = ((blab)localObject4).f;
      }
      localObject4 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (!TextUtils.isEmpty(paramArrayOfObject))
      {
        ((VideoStoryDataBean)localObject4).setWatermarkId(paramArrayOfObject);
        localObject4 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
        if (localObject3 == null) {
          break label546;
        }
        paramArrayOfObject = ((QIMFilterCategoryItem)localObject3).b;
        label435:
        ((VideoStoryDataBean)localObject4).setFilterId(paramArrayOfObject);
        localObject3 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
        if (bkzy.a() != null) {
          break label553;
        }
        paramArrayOfObject = "empty";
        label457:
        ((VideoStoryDataBean)localObject3).setLensId(paramArrayOfObject);
        localObject3 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
        if (bkzy.a() != null) {
          break label563;
        }
      }
      label546:
      label553:
      label563:
      for (paramArrayOfObject = "empty";; paramArrayOfObject = Integer.valueOf(bkzy.a().jdField_a_of_type_Int))
      {
        ((VideoStoryDataBean)localObject3).setLensTabId(String.valueOf(paramArrayOfObject));
        localBundle2.putSerializable("KEY_VIDEO_STORY_CAMERA_TYPE", this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean);
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
        bnld.a(this.jdField_a_of_type_AndroidAppActivity, (CameraCaptureView.VideoCaptureResult)localObject1, (LocalMediaInfo)localObject2, localbmgz, localBundle2, 11, localBundle1);
        p();
        return;
        paramArrayOfObject = "empty";
        break;
        paramArrayOfObject = "empty";
        break label435;
        paramArrayOfObject = bkzy.a().jdField_a_of_type_JavaLangString;
        break label457;
      }
      label576:
      i = 1;
    }
  }
  
  private void b(Runnable paramRunnable)
  {
    d();
    float f1;
    if (this.jdField_a_of_type_Bkpl != null) {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_f_of_type_Int != 0)) {
        f1 = this.jdField_f_of_type_Int;
      }
    }
    for (;;)
    {
      yyk.a(new View[] { this.jdField_c_of_type_AndroidViewView, this.jdField_d_of_type_AndroidViewView }).d(new float[] { 0.0F, (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int) / 2 }).a(new View[] { this.jdField_e_of_type_AndroidViewView }).c(new float[] { 0.0F, f1 }).a(new View[] { this.jdField_f_of_type_AndroidViewView }).c(new float[] { 0.0F, this.jdField_a_of_type_AndroidViewView.getHeight() - f1 - this.jdField_a_of_type_Int + 1.0F }).a(1.5F).a(500L).a(new bkwd(this)).a(new bkwc(this, paramRunnable)).a();
      return;
      f1 = bdaq.a(this.jdField_a_of_type_Bkpl.a(), 147.0F);
      continue;
      if (this.jdField_a_of_type_Boolean) {
        f1 = (int)(0.0724138F * this.jdField_a_of_type_AndroidViewView.getHeight());
      } else {
        f1 = (int)(0.1810345F * this.jdField_a_of_type_AndroidViewView.getHeight());
      }
    }
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "in photo end.");
    }
    if (blat.f(this.jdField_a_of_type_AndroidAppActivity.getIntent()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("camera_log_tag_photo", 2, "in aio photo end.");
      }
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
      {
        localObject1 = (axqw)paramArrayOfObject[0];
        paramArrayOfObject = (bmgz)paramArrayOfObject[1];
        a(false);
        bnld.a(this.jdField_a_of_type_AndroidAppActivity, (axqw)localObject1, paramArrayOfObject, null, 1);
      }
    }
    Object localObject2;
    do
    {
      return;
      if (blat.i(this.jdField_a_of_type_AndroidAppActivity.getIntent()))
      {
        bljn.b("VideoStoryCapturePart", "[PhotoEnd] ready to enter EditorActivity");
        paramArrayOfObject = (axqw)paramArrayOfObject[0];
        a(false);
        localObject1 = new Bundle();
        localObject2 = new ArrayList();
        EditorPicInfo localEditorPicInfo = new EditorPicInfo();
        Size localSize = BitmapUtil.getImageSize(paramArrayOfObject.jdField_a_of_type_JavaLangString);
        localEditorPicInfo.picPath = paramArrayOfObject.jdField_a_of_type_JavaLangString;
        localEditorPicInfo.originPicHeight = localSize.getHeight();
        localEditorPicInfo.originPicWidth = localSize.getWidth();
        localEditorPicInfo.x = 0.0D;
        localEditorPicInfo.y = 0.0D;
        localEditorPicInfo.h = 1.0D;
        localEditorPicInfo.w = 1.0D;
        ((ArrayList)localObject2).add(localEditorPicInfo);
        ((Bundle)localObject1).putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", (Serializable)localObject2);
        ((Bundle)localObject1).putString("material_id", this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("widgetinfo"));
        int i = a();
        bljx.a(this.jdField_a_of_type_AndroidAppActivity, 0, (Bundle)localObject1, i);
        bliy.a().a().jdField_b_of_type_Long = bliy.b.longValue();
        bliy.a().a().jdField_a_of_type_JavaLangString = bliy.a().a();
        bliu.a().a(1);
        return;
      }
    } while ((paramArrayOfObject == null) || (paramArrayOfObject.length != 2));
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "arg len = 2");
    }
    Object localObject1 = (axqw)paramArrayOfObject[0];
    paramArrayOfObject = (QIMFilterCategoryItem)paramArrayOfObject[1];
    paramArrayOfObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    if ((blat.e(paramArrayOfObject)) || (!blat.a(this.jdField_a_of_type_AndroidAppActivity.getIntent())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("camera_log_tag_photo", 2, "in normal photo end.");
      }
      paramArrayOfObject = new Bundle();
      paramArrayOfObject.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", ((axqw)localObject1).jdField_a_of_type_JavaLangString);
      localObject2 = new LocalMediaInfo();
      ((LocalMediaInfo)localObject2).mMimeType = "pic";
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
      bnfr.a(this.jdField_a_of_type_AndroidAppActivity, ((axqw)localObject1).jdField_a_of_type_JavaLangString, (LocalMediaInfo)localObject2, 0, (int)((LocalMediaInfo)localObject2).mDuration, -1, 10023, 0, null, null, false, 11, 14, paramArrayOfObject);
      a(false);
      return;
    }
    if ((blat.g(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (blat.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("VIDEO_STORY_FROM_TYPE", blat.a(paramArrayOfObject));
      ((Intent)localObject2).putExtra("photo_path", ((axqw)localObject1).jdField_a_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("key_disable_face_detect", paramArrayOfObject.getBooleanExtra("key_disable_face_detect", false));
      ((Intent)localObject2).putExtra("key_need_check_sensitive", paramArrayOfObject.getBooleanExtra("key_need_check_sensitive", false));
      AETakeFacePhotoPreviewFragment.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1024);
      a(false);
      return;
    }
    bljn.d("VideoStoryCapturePart", "【onPhotoEnd】wrong entry");
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    ViewStub localViewStub1 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377158);
    ViewStub localViewStub2 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377154);
    ViewStub localViewStub3 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377155);
    ViewStub localViewStub4 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377156);
    ViewStub localViewStub5 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377157);
    ViewStub localViewStub6 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377153);
    localViewStub1.inflate();
    localViewStub2.inflate();
    localViewStub3.inflate();
    localViewStub4.inflate();
    localViewStub5.inflate();
    localViewStub6.inflate();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362158));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363891);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363887);
    this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new bkvy(this));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363888);
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(new bkwf(this));
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363889);
    this.jdField_e_of_type_AndroidViewView.setOnTouchListener(new bkwg(this));
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363886);
    this.jdField_f_of_type_AndroidViewView.setOnTouchListener(new bkwh(this));
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void e()
  {
    this.jdField_a_of_type_Blfq = ((blfq)bkpx.a(this.jdField_a_of_type_Bkpl).a(blfq.class));
    this.jdField_a_of_type_Blfq.a.a(this.jdField_a_of_type_Bkpl, new bkwi(this));
    this.jdField_a_of_type_Bkyq = ((bkyq)bkpx.a(this.jdField_a_of_type_Bkpl).a(bkyq.class));
    this.jdField_a_of_type_Bkyq.b().a(this.jdField_a_of_type_Bkpl, new bkwj(this));
  }
  
  private void f()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getLayoutParams();
    if (blat.i(this.jdField_a_of_type_AndroidAppActivity.getIntent()))
    {
      localLayoutParams.width = this.jdField_b_of_type_Int;
      localLayoutParams.height = localLayoutParams.width;
    }
    for (localLayoutParams.topMargin = bdaq.a(this.jdField_a_of_type_Bkpl.a(), 60.0F);; localLayoutParams.topMargin = 0)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
    }
  }
  
  private void k()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getLayoutParams();
    localLayoutParams.width = (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getMeasuredWidth() - 1);
    localLayoutParams.height = -1;
    localLayoutParams.topMargin = 0;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setLayoutParams(localLayoutParams);
  }
  
  private void l()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getLayoutParams();
    localLayoutParams.width = this.jdField_a_of_type_Int;
    localLayoutParams.height = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Bkpl != null) {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_f_of_type_Int != 0)) {
        localLayoutParams.topMargin = this.jdField_f_of_type_Int;
      }
    }
    for (;;)
    {
      if (this.g == 0) {
        this.g = localLayoutParams.topMargin;
      }
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.topMargin = bdaq.a(this.jdField_a_of_type_Bkpl.a(), 147.0F);
      continue;
      if (this.jdField_a_of_type_Boolean) {
        localLayoutParams.topMargin = ((int)(0.0724138F * this.jdField_c_of_type_Int));
      } else {
        localLayoutParams.topMargin = ((int)(0.1810345F * this.jdField_c_of_type_Int));
      }
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setOnSurfaceChangedListener(new bkvz(this));
  }
  
  private void n()
  {
    a(true);
  }
  
  private void o()
  {
    p();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureRequest(new bkwe(this));
  }
  
  private void p()
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
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363890));
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
    this.jdField_b_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    this.jdField_c_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    if (bnsm.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int)) {
      this.jdField_b_of_type_Int = (this.jdField_c_of_type_Int * 9 / 16);
    }
    int i;
    if (this.jdField_a_of_type_Bkpl != null)
    {
      this.jdField_a_of_type_Int = bdaq.a(this.jdField_a_of_type_Bkpl.a(), 250.0F);
      i = bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 700.0F);
      if (this.jdField_c_of_type_Int >= i) {
        break label208;
      }
      this.jdField_a_of_type_Boolean = true;
      label147:
      if (this.jdField_a_of_type_Boolean)
      {
        int j = bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 600.0F);
        if (this.jdField_c_of_type_Int >= j) {
          break label216;
        }
      }
    }
    label208:
    label216:
    float f1;
    for (this.jdField_f_of_type_Int = bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 58.799999F);; this.jdField_f_of_type_Int = bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 147.0F - f1 * 88.199997F))
    {
      e();
      return;
      this.jdField_a_of_type_Int = ((int)(0.6666667F * this.jdField_b_of_type_Int));
      break;
      this.jdField_a_of_type_Boolean = false;
      break label147;
      f1 = (i - this.jdField_c_of_type_Int) / bdaq.a(this.jdField_a_of_type_AndroidAppActivity, 100.0F);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 262145: 
      o();
      return;
    case 262146: 
      a(paramVarArgs);
      return;
    case 262147: 
      n();
      return;
    }
    b(paramVarArgs);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoStoryCapturePart", 2, "onDestroy()");
    }
    bncl.a().onDestroy();
    super.g();
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvx
 * JD-Core Version:    0.7.0.1
 */