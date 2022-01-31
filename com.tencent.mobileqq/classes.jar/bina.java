import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.3;
import dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.4;
import dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.5;
import dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class bina
  extends biwr
{
  private final float jdField_a_of_type_Float = 147.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bijd jdField_a_of_type_Bijd;
  private bipp jdField_a_of_type_Bipp;
  private biwp jdField_a_of_type_Biwp;
  private VideoStoryDataBean jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private final String jdField_a_of_type_JavaLangString = "VideoStoryCapturePart";
  public List<FrameVideoHelper.FrameBuffer> a;
  private boolean jdField_a_of_type_Boolean;
  private final float jdField_b_of_type_Float = 58.799999F;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = ((Long)xfo.a().a("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue();
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private final int jdField_d_of_type_Int = 700;
  private View jdField_d_of_type_AndroidViewView;
  private final int jdField_e_of_type_Int = 600;
  private View jdField_e_of_type_AndroidViewView;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private int g;
  
  public bina(Activity paramActivity, View paramView, biws parambiws)
  {
    super(paramActivity, paramView, parambiws);
    this.jdField_a_of_type_Bijd = ((bijd)parambiws.a(65537, new Object[0]));
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
  }
  
  private void a(@NotNull biwo parambiwo)
  {
    if ((parambiwo == biwo.a) && (this.jdField_a_of_type_Bipp != null)) {
      this.jdField_a_of_type_Bipp.b().a(Boolean.valueOf(false));
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      ThreadManager.getUIHandler().post(paramRunnable);
      return;
    }
    xfc.a(new View[] { this.jdField_c_of_type_AndroidViewView, this.jdField_d_of_type_AndroidViewView }).d(new float[] { this.jdField_c_of_type_AndroidViewView.getWidth(), 0.0F }).a(new View[] { this.jdField_e_of_type_AndroidViewView }).c(new float[] { this.jdField_e_of_type_AndroidViewView.getHeight(), 0.0F }).a(new View[] { this.jdField_f_of_type_AndroidViewView }).c(new float[] { this.jdField_f_of_type_AndroidViewView.getHeight(), 0.0F }).a().a(300L).a(new binh(this)).a(new bing(this, paramRunnable)).a();
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    AEVideoCaptureResult localAEVideoCaptureResult;
    LocalMediaInfo localLocalMediaInfo;
    bjrd localbjrd;
    Object localObject1;
    Bundle localBundle1;
    Bundle localBundle2;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 5))
    {
      localAEVideoCaptureResult = (AEVideoCaptureResult)paramArrayOfObject[0];
      localLocalMediaInfo = (LocalMediaInfo)paramArrayOfObject[1];
      Object localObject2 = (Integer)paramArrayOfObject[2];
      localbjrd = (bjrd)paramArrayOfObject[3];
      localObject1 = (QIMFilterCategoryItem)paramArrayOfObject[4];
      localBundle1 = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      paramArrayOfObject = new bjrj().a(localbjrd.jdField_c_of_type_Int).c(10).j(true);
      if (birt.f(this.jdField_a_of_type_AndroidAppActivity.getIntent())) {
        paramArrayOfObject.c(0);
      }
      localbjrd.a(paramArrayOfObject.a());
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("extra_transiton_src_from", -1);
      localBundle2 = new Bundle();
      localBundle2.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable)this.jdField_a_of_type_JavaUtilList);
      localBundle2.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.jdField_a_of_type_Long);
      localBundle2.putInt("KEY_VIDEO_STORY_CAMERA_TYPE", ((Integer)localObject2).intValue());
      localObject2 = bips.a().a();
      paramArrayOfObject = "";
      if (localObject2 != null) {
        paramArrayOfObject = ((bire)localObject2).f;
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (TextUtils.isEmpty(paramArrayOfObject)) {
        break label339;
      }
      ((VideoStoryDataBean)localObject2).setWatermarkId(paramArrayOfObject);
      localObject2 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (localObject1 == null) {
        break label346;
      }
      paramArrayOfObject = ((QIMFilterCategoryItem)localObject1).b;
      label236:
      ((VideoStoryDataBean)localObject2).setFilterId(paramArrayOfObject);
      localObject1 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (birb.a() != null) {
        break label353;
      }
      paramArrayOfObject = "empty";
      label258:
      ((VideoStoryDataBean)localObject1).setLensId(paramArrayOfObject);
      localObject1 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (birb.a() != null) {
        break label363;
      }
    }
    label339:
    label346:
    label353:
    label363:
    for (paramArrayOfObject = "empty";; paramArrayOfObject = Integer.valueOf(birb.a().jdField_a_of_type_Int))
    {
      ((VideoStoryDataBean)localObject1).setLensTabId(String.valueOf(paramArrayOfObject));
      localBundle2.putSerializable("KEY_VIDEO_STORY_CAMERA_TYPE", this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean);
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
      bkvh.a(this.jdField_a_of_type_AndroidAppActivity, localAEVideoCaptureResult, localLocalMediaInfo, localbjrd, localBundle2, 11, localBundle1);
      r();
      return;
      paramArrayOfObject = "empty";
      break;
      paramArrayOfObject = "empty";
      break label236;
      paramArrayOfObject = birb.a().jdField_a_of_type_JavaLangString;
      break label258;
    }
  }
  
  private void b(@NotNull biwo parambiwo)
  {
    if (this.jdField_a_of_type_Biwp.d())
    {
      bjah.b("VideoStoryCapturePart", "checkAniByMode--isCaptureModeChangedByInit: do nothing");
      this.jdField_a_of_type_Biwp.a(false);
      return;
    }
    bjah.b("VideoStoryCapturePart", "checkAniByMode--captureMode=" + parambiwo);
    if (parambiwo == biwo.a)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.p();
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBlockCameraFlag(false);
      bika.a().c(avsz.a());
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.o();
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_a_of_type_Biwp.b(true);
      a(new VideoStoryCapturePart.3(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a = parambiwo;
      return;
      if (parambiwo == biwo.c)
      {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.p();
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBlockCameraFlag(false);
        bika.a().c(1);
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.o();
        this.jdField_a_of_type_Biwp.b(true);
        b(new VideoStoryCapturePart.4(this));
      }
      else if (parambiwo == biwo.b)
      {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.p();
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBlockCameraFlag(true);
        this.jdField_a_of_type_Biwp.b(true);
        if (this.jdField_c_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        ThreadManager.getUIHandler().postDelayed(new VideoStoryCapturePart.5(this), 200L);
      }
    }
  }
  
  private void b(Runnable paramRunnable)
  {
    d();
    float f1;
    if (this.jdField_a_of_type_Bijd != null) {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_f_of_type_Int != 0)) {
        f1 = this.jdField_f_of_type_Int;
      }
    }
    for (;;)
    {
      xfc.a(new View[] { this.jdField_c_of_type_AndroidViewView, this.jdField_d_of_type_AndroidViewView }).d(new float[] { 0.0F, (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int) / 2 }).a(new View[] { this.jdField_e_of_type_AndroidViewView }).c(new float[] { 0.0F, f1 }).a(new View[] { this.jdField_f_of_type_AndroidViewView }).c(new float[] { 0.0F, this.jdField_a_of_type_AndroidViewView.getHeight() - f1 - this.jdField_a_of_type_Int + 1.0F }).a(1.5F).a(500L).a(new binc(this)).a(new bini(this, paramRunnable)).a();
      return;
      f1 = baxn.a(this.jdField_a_of_type_Bijd.a(), 147.0F);
      continue;
      if (this.jdField_a_of_type_Boolean) {
        f1 = (int)(0.0724138F * this.jdField_a_of_type_AndroidViewView.getHeight());
      } else {
        f1 = (int)(0.1810345F * this.jdField_a_of_type_AndroidViewView.getHeight());
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      if (!paramBoolean) {
        break label80;
      }
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131755791);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559386);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    label80:
    while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "in photo end.");
    }
    if (birt.f(this.jdField_a_of_type_AndroidAppActivity.getIntent()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("camera_log_tag_photo", 2, "in aio photo end.");
      }
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
      {
        localavuo = (avuo)paramArrayOfObject[0];
        paramArrayOfObject = (bjrd)paramArrayOfObject[1];
        b(false);
        bkvh.a(this.jdField_a_of_type_AndroidAppActivity, localavuo, paramArrayOfObject, null, 1);
      }
    }
    while ((paramArrayOfObject == null) || (paramArrayOfObject.length != 2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "arg len = 2");
    }
    avuo localavuo = (avuo)paramArrayOfObject[0];
    paramArrayOfObject = (QIMFilterCategoryItem)paramArrayOfObject[1];
    paramArrayOfObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    Object localObject;
    if ((birt.e(paramArrayOfObject)) || (!birt.a(this.jdField_a_of_type_AndroidAppActivity.getIntent())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("camera_log_tag_photo", 2, "in normal photo end.");
      }
      paramArrayOfObject = new Bundle();
      paramArrayOfObject.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", localavuo.jdField_a_of_type_JavaLangString);
      localObject = new LocalMediaInfo();
      ((LocalMediaInfo)localObject).mMimeType = "pic";
      this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
      bkpv.a(this.jdField_a_of_type_AndroidAppActivity, localavuo.jdField_a_of_type_JavaLangString, (LocalMediaInfo)localObject, 0, (int)((LocalMediaInfo)localObject).mDuration, -1, 10023, 0, null, null, false, 11, 14, paramArrayOfObject);
      b(false);
      return;
    }
    if ((birt.g(this.jdField_a_of_type_AndroidAppActivity.getIntent())) || (birt.h(this.jdField_a_of_type_AndroidAppActivity.getIntent())))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("VIDEO_STORY_FROM_TYPE", birt.a(paramArrayOfObject));
      ((Intent)localObject).putExtra("photo_path", localavuo.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("key_disable_face_detect", paramArrayOfObject.getBooleanExtra("key_disable_face_detect", false));
      ((Intent)localObject).putExtra("key_need_check_sensitive", paramArrayOfObject.getBooleanExtra("key_need_check_sensitive", false));
      AETakeFacePhotoPreviewFragment.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject, 1024);
      b(false);
      return;
    }
    bjah.d("VideoStoryCapturePart", "【onPhotoEnd】wrong entry");
  }
  
  private void d()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    ViewStub localViewStub1 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376603);
    ViewStub localViewStub2 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376599);
    ViewStub localViewStub3 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376600);
    ViewStub localViewStub4 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376601);
    ViewStub localViewStub5 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376602);
    ViewStub localViewStub6 = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376598);
    localViewStub1.inflate();
    localViewStub2.inflate();
    localViewStub3.inflate();
    localViewStub4.inflate();
    localViewStub5.inflate();
    localViewStub6.inflate();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362150));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363833);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363829);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363830);
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363831);
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363828);
    this.jdField_c_of_type_Boolean = true;
  }
  
  private void e()
  {
    this.jdField_a_of_type_Biwp = ((biwp)bijo.a(this.jdField_a_of_type_Bijd).a(biwp.class));
    this.jdField_a_of_type_Biwp.a().a(this.jdField_a_of_type_Bijd, new binb(this));
    this.jdField_a_of_type_Bipp = ((bipp)bijo.a(this.jdField_a_of_type_Bijd).a(bipp.class));
    this.jdField_a_of_type_Bipp.b().a(this.jdField_a_of_type_Bijd, new bine(this));
  }
  
  private void f()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.topMargin = 0;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setLayoutParams(localLayoutParams);
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
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getLayoutParams();
    localLayoutParams1.width = this.jdField_a_of_type_Int;
    localLayoutParams1.height = this.jdField_a_of_type_Int;
    RelativeLayout.LayoutParams localLayoutParams2;
    if (this.jdField_a_of_type_Bijd != null)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        View localView = this.jdField_a_of_type_Bijd.a().findViewById(2131365839);
        if (localView != null)
        {
          localLayoutParams2 = (RelativeLayout.LayoutParams)localView.getLayoutParams();
          if ((!this.jdField_a_of_type_Boolean) || (this.jdField_f_of_type_Int == 0)) {
            break label154;
          }
          localLayoutParams2.topMargin = (this.jdField_f_of_type_Int + baxn.a(this.jdField_a_of_type_Bijd.a(), 62.0F));
          localView.setLayoutParams(localLayoutParams2);
        }
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_f_of_type_Int != 0)) {
        localLayoutParams1.topMargin = this.jdField_f_of_type_Int;
      }
    }
    for (;;)
    {
      if (this.g == 0) {
        this.g = localLayoutParams1.topMargin;
      }
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setLayoutParams(localLayoutParams1);
      return;
      label154:
      localLayoutParams2.topMargin = baxn.a(this.jdField_a_of_type_Bijd.a(), 209.0F);
      break;
      localLayoutParams1.topMargin = baxn.a(this.jdField_a_of_type_Bijd.a(), 147.0F);
      continue;
      if (this.jdField_a_of_type_Boolean) {
        localLayoutParams1.topMargin = ((int)(0.0724138F * this.jdField_c_of_type_Int));
      } else {
        localLayoutParams1.topMargin = ((int)(0.1810345F * this.jdField_c_of_type_Int));
      }
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setOnSurfaceChangedListener(new binf(this));
  }
  
  private void n()
  {
    int i = 200;
    Object localObject = this.jdField_a_of_type_Bijd.a().getIntent();
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("AECAMERA_MODE", 200);
    }
    switch (i)
    {
    default: 
      o();
      return;
    case 203: 
      this.jdField_b_of_type_Boolean = false;
      l();
      d();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    case 202: 
      this.jdField_b_of_type_Boolean = true;
      l();
      d();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    localObject = this.jdField_a_of_type_Biwp.a(this.jdField_a_of_type_Bijd);
    if (localObject == biwo.a) {
      o();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.a = ((biwo)localObject);
      return;
      if (localObject == biwo.b)
      {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.p();
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBlockCameraFlag(true);
        k();
      }
    }
  }
  
  private void o()
  {
    this.jdField_b_of_type_Boolean = false;
    f();
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void p()
  {
    b(true);
  }
  
  private void q()
  {
    r();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureRequest(new bind(this));
  }
  
  private void r()
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
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363832));
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
    this.jdField_b_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    this.jdField_c_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    if (blcq.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int)) {
      this.jdField_b_of_type_Int = (this.jdField_c_of_type_Int * 9 / 16);
    }
    int i;
    if (this.jdField_a_of_type_Bijd != null)
    {
      this.jdField_a_of_type_Int = baxn.a(this.jdField_a_of_type_Bijd.a(), 250.0F);
      i = baxn.a(this.jdField_a_of_type_AndroidAppActivity, 700.0F);
      if (this.jdField_c_of_type_Int >= i) {
        break label208;
      }
      this.jdField_a_of_type_Boolean = true;
      label147:
      if (this.jdField_a_of_type_Boolean)
      {
        int j = baxn.a(this.jdField_a_of_type_AndroidAppActivity, 600.0F);
        if (this.jdField_c_of_type_Int >= j) {
          break label216;
        }
      }
    }
    label208:
    label216:
    float f1;
    for (this.jdField_f_of_type_Int = baxn.a(this.jdField_a_of_type_AndroidAppActivity, 58.799999F);; this.jdField_f_of_type_Int = baxn.a(this.jdField_a_of_type_AndroidAppActivity, 147.0F - f1 * 88.199997F))
    {
      e();
      return;
      this.jdField_a_of_type_Int = ((int)(0.6666667F * this.jdField_b_of_type_Int));
      break;
      this.jdField_a_of_type_Boolean = false;
      break label147;
      f1 = (i - this.jdField_c_of_type_Int) / baxn.a(this.jdField_a_of_type_AndroidAppActivity, 100.0F);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 262145: 
      q();
      return;
    case 262146: 
      a(paramVarArgs);
      return;
    case 262147: 
      p();
      return;
    case 262148: 
      b(paramVarArgs);
      return;
    }
    n();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoStoryCapturePart", 2, "onDestroy()");
    }
    bkmp.a().onDestroy();
    super.g();
    b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bina
 * JD-Core Version:    0.7.0.1
 */