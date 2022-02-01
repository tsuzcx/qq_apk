import android.annotation.TargetApi;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.MainThread;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager.StickerInnerEffectFilterListener;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.string.StringUtils;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import com.tencent.ttpic.openapi.watermark.LogicDataManager.IOnClickWatermarkListener;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.ae.AEPituCameraUnit.10;
import dov.com.qq.im.ae.AEPituCameraUnit.12;
import dov.com.qq.im.ae.AEPituCameraUnit.13;
import dov.com.qq.im.ae.AEPituCameraUnit.14;
import dov.com.qq.im.ae.AEPituCameraUnit.15;
import dov.com.qq.im.ae.AEPituCameraUnit.16;
import dov.com.qq.im.ae.AEPituCameraUnit.17;
import dov.com.qq.im.ae.AEPituCameraUnit.18;
import dov.com.qq.im.ae.AEPituCameraUnit.24;
import dov.com.qq.im.ae.AEPituCameraUnit.25;
import dov.com.qq.im.ae.AEPituCameraUnit.26;
import dov.com.qq.im.ae.AEPituCameraUnit.27;
import dov.com.qq.im.ae.AEPituCameraUnit.28;
import dov.com.qq.im.ae.AEPituCameraUnit.29;
import dov.com.qq.im.ae.AEPituCameraUnit.30;
import dov.com.qq.im.ae.AEPituCameraUnit.31;
import dov.com.qq.im.ae.AEPituCameraUnit.32;
import dov.com.qq.im.ae.AEPituCameraUnit.33;
import dov.com.qq.im.ae.AEPituCameraUnit.36;
import dov.com.qq.im.ae.AEPituCameraUnit.39;
import dov.com.qq.im.ae.AEPituCameraUnit.8;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import dov.com.qq.im.ae.camera.core.AECameraBroadcastReceiver;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.AEEffectListener;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView.AEGLSurfaceListener;
import dov.com.qq.im.ae.camera.core.AECameraManager;
import dov.com.qq.im.ae.camera.core.AECameraManager.CameraManagerListener;
import dov.com.qq.im.ae.camera.core.AEFilterManagerHolder;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkPanel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.gif.AEStoryGIFPreviewActivity;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.ae.view.AEPituCameraCaptureButtonLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@TargetApi(9)
public class bmxa
  extends bmvf
  implements View.OnClickListener, View.OnTouchListener, bbhp, bnfg, bnsc, bpjw, AEFilterManager.StickerInnerEffectFilterListener, MediaScanner.OnMediaInfoScannerListener, AECameraGLSurfaceView.AEEffectListener
{
  public static boolean f;
  public static boolean g;
  private long jdField_a_of_type_Long;
  protected GestureDetector a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected bbgz a;
  protected bbha a;
  protected bbhb a;
  protected bbhd a;
  protected bbhe a;
  protected bbhf a;
  protected bbhg a;
  protected bbhh a;
  protected bbhi a;
  private bmxy jdField_a_of_type_Bmxy;
  public bnbg a;
  public bnbn a;
  protected bnfv a;
  protected bngl a;
  private bngm jdField_a_of_type_Bngm;
  public bngy a;
  private bnpz jdField_a_of_type_Bnpz;
  private bnqa jdField_a_of_type_Bnqa;
  public bnqc a;
  private LogicDataManager.IOnClickWatermarkListener jdField_a_of_type_ComTencentTtpicOpenapiWatermarkLogicDataManager$IOnClickWatermarkListener;
  private AECameraBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver = new AECameraBroadcastReceiver(this);
  protected final AECameraGLSurfaceView.AEGLSurfaceListener a;
  protected final AECameraManager.CameraManagerListener a;
  protected AEMaterialPanel a;
  protected AEWaterMarkPanel a;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  private long jdField_b_of_type_Long = -1L;
  protected View b;
  private AECompoundButton jdField_b_of_type_DovComQqImAeViewAECompoundButton;
  private boolean d;
  protected int e;
  public boolean e;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k = bnri.a();
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  public bmxa()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager$CameraManagerListener = new bmxb(this);
    this.jdField_a_of_type_Bnfv = new bmxf(this);
    this.jdField_a_of_type_Bngl = new bmxk(this);
    this.jdField_a_of_type_Bbha = new bmxr(this);
    this.jdField_a_of_type_Bbhi = new bmxt(this);
    this.jdField_a_of_type_Bbhe = new bmxu(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$AEGLSurfaceListener = new bmxv(this);
    this.jdField_e_of_type_Int = 0;
    bnrh.b(this.jdField_a_of_type_JavaLangString, "[AEPituCameraUnit] + BEGIN");
    bnrh.a(this.jdField_a_of_type_JavaLangString, "unitConstructor--fake");
    bnrh.b(this.jdField_a_of_type_JavaLangString, "[AEPituCameraUnit] + END");
  }
  
  public bmxa(borh paramborh, borg paramborg)
  {
    super(paramborh, paramborg);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager$CameraManagerListener = new bmxb(this);
    this.jdField_a_of_type_Bnfv = new bmxf(this);
    this.jdField_a_of_type_Bngl = new bmxk(this);
    this.jdField_a_of_type_Bbha = new bmxr(this);
    this.jdField_a_of_type_Bbhi = new bmxt(this);
    this.jdField_a_of_type_Bbhe = new bmxu(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$AEGLSurfaceListener = new bmxv(this);
    this.jdField_e_of_type_Int = 0;
    bnrh.b(this.jdField_a_of_type_JavaLangString, "[AEPituCameraUnit] + BEGIN");
    long l1 = System.currentTimeMillis();
    bnqe.a().a("unitConstructor-begin");
    Log.d(this.jdField_a_of_type_JavaLangString, "AEPituCameraUnit: cameraConfig.getFrom() =" + this.jdField_a_of_type_Bmvr.i());
    this.jdField_d_of_type_Int = 11;
    if (k())
    {
      this.jdField_d_of_type_Int = 13;
      this.jdField_a_of_type_Boqz = new boqz(10023, this.jdField_a_of_type_Bmvr.d(), this.jdField_a_of_type_Bmvr.a());
    }
    for (;;)
    {
      bnrh.b(this.jdField_a_of_type_JavaLangString, "[AEPituCameraUnit] submit unit init");
      H();
      bnrh.b(this.jdField_a_of_type_JavaLangString, "[AEPituCameraUnit] + END, time cost = " + (System.currentTimeMillis() - l1));
      return;
      if (!bnlb.e.a(this.jdField_a_of_type_Bmvr.i()))
      {
        this.jdField_d_of_type_Int = this.jdField_a_of_type_Bmvr.b().intValue();
        this.jdField_a_of_type_Boqz = new boqz(this.jdField_a_of_type_Borh.a().getIntent().getIntExtra("edit_video_type", 10002), this.jdField_a_of_type_Bmvr.d(), this.jdField_a_of_type_Bmvr.a());
      }
      else
      {
        this.jdField_d_of_type_Int = 1;
      }
    }
  }
  
  private void A()
  {
    if ((this.l) || (this.m) || (this.n))
    {
      bnrh.b(this.jdField_a_of_type_JavaLangString, "checkSetOnClickWatermarkListener--FAIL, some panel is showing");
      LogicDataManager.getInstance().setOnClickWatermarkListener(null);
      return;
    }
    bnrh.b(this.jdField_a_of_type_JavaLangString, "checkSetOnClickWatermarkListener--PASS, no panel is showing");
    LogicDataManager.getInstance().setOnClickWatermarkListener(this.jdField_a_of_type_ComTencentTtpicOpenapiWatermarkLogicDataManager$IOnClickWatermarkListener);
  }
  
  private void B()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView == null) && (this.jdField_a_of_type_AndroidViewViewStub != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    }
  }
  
  private Intent a(Activity paramActivity, Class<?> paramClass, PublishParam paramPublishParam, Intent paramIntent)
  {
    paramClass = new Intent(paramActivity, paramClass);
    paramClass.putExtra("arg_video_source", 2);
    if (paramActivity.getIntent().getExtras() != null) {
      paramClass.putExtras(paramActivity.getIntent().getExtras());
    }
    if (paramIntent != null)
    {
      paramActivity = paramIntent.getParcelableArrayListExtra("key_read_in_joy_video_upload_report");
      if (paramActivity != null) {
        paramClass.putParcelableArrayListExtra("key_read_in_joy_video_upload_report", paramActivity);
      }
    }
    if (paramPublishParam != null)
    {
      paramClass.putExtra(PublishParam.jdField_a_of_type_JavaLangString, paramPublishParam);
      paramClass.putExtra("arg_video_duration", paramPublishParam.jdField_a_of_type_Long);
      paramClass.putExtra("arg_video_path", paramPublishParam.j);
      paramClass.putExtra("arg_video_cover", paramPublishParam.c);
      paramClass.putExtra("arg_video_width", paramPublishParam.jdField_a_of_type_Int);
      paramClass.putExtra("arg_video_height", paramPublishParam.b);
    }
    return paramClass;
  }
  
  private AECaptureMode a(AECaptureMode[] paramArrayOfAECaptureMode, int paramInt)
  {
    String str = a().getIntent().getStringExtra("KEY_CURRENT_TAB");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      AECaptureMode localAECaptureMode2 = AECaptureMode.fromName(str);
      int i1;
      if (localAECaptureMode2 != null)
      {
        i1 = paramArrayOfAECaptureMode.length;
        paramInt = 0;
        label40:
        if (paramInt < i1) {
          if (paramArrayOfAECaptureMode[paramInt] != localAECaptureMode2) {}
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        AECaptureMode localAECaptureMode1 = localAECaptureMode2;
        if (paramInt == 0)
        {
          bnrh.d(this.jdField_a_of_type_JavaLangString, "[getFirstModeAccordingABTest], get invalid mode=" + localAECaptureMode2);
          localAECaptureMode1 = paramArrayOfAECaptureMode[0];
        }
        bnrh.b(this.jdField_a_of_type_JavaLangString, "[getFirstModeAccordingABTest], ABTest name=" + str + ", real picked mode=" + localAECaptureMode1);
        return localAECaptureMode1;
        i1 = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1);
        if ((paramInt == 201) && (bnlb.c.a() == i1)) {
          return AECaptureMode.PLAY;
        }
        if ((paramInt != 204) || (!bnlb.d(i1))) {
          break label218;
        }
        str = bnqu.a().a("app_alg_entrance_qzone_id_from833", "", 4);
        break;
        paramInt += 1;
        break label40;
      }
      label218:
      str = null;
    }
  }
  
  private void a(bnay parambnay)
  {
    switch (this.jdField_a_of_type_Bmvr.f())
    {
    default: 
      return;
    case 0: 
    case 3: 
      this.jdField_a_of_type_Bnqc.a(262148, new Object[] { parambnay });
      return;
    case 2: 
      this.jdField_a_of_type_Bnqc.a(262148, new Object[] { parambnay, this.jdField_a_of_type_Bmvr.b(), Integer.valueOf(this.jdField_a_of_type_Bmvr.a()) });
      return;
    }
    bora localbora = new borc(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.getSelectedCamera()).a(this.jdField_a_of_type_Bmvr.a()).a(this.jdField_a_of_type_Bmvr.a()).a(1).a();
    this.jdField_a_of_type_Boqz.a(localbora);
    this.jdField_a_of_type_Bnqc.a(262148, new Object[] { parambnay, this.jdField_a_of_type_Boqz, this.jdField_a_of_type_Bmvr.b() });
  }
  
  private void a(LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable)
  {
    T();
    if (paramLazyLoadAnimationDrawable == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable = new AEPituCameraUnit.25(this);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.26(this, paramLazyLoadAnimationDrawable));
  }
  
  private void a(@Nullable AECaptureMode paramAECaptureMode1, @NonNull AECaptureMode paramAECaptureMode2)
  {
    boolean bool2 = true;
    this.jdField_b_of_type_DovComQqImAeModeAECaptureMode = paramAECaptureMode2;
    if (paramAECaptureMode1 == paramAECaptureMode2) {}
    label233:
    label238:
    do
    {
      return;
      bnrh.b(this.jdField_a_of_type_JavaLangString, "onCaptureModeChanged---from " + paramAECaptureMode1 + " to " + paramAECaptureMode2);
      b(paramAECaptureMode1, paramAECaptureMode2);
      if (this.jdField_a_of_type_Bbgz != null) {
        this.jdField_a_of_type_Bbgz.a();
      }
      if (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF)
      {
        bool1 = true;
        bnqq.a().b(bool1);
        if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
          this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsGIFMode(bool1);
        }
        ThreadManager.getUIHandler().post(new AEPituCameraUnit.24(this));
        paramAECaptureMode1 = this.jdField_a_of_type_Bnbn;
        if (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.NORMAL) {
          break label233;
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramAECaptureMode1.c(bool1);
        if (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera()) {
          break label238;
        }
        if (this.jdField_a_of_type_Bngy != null) {
          this.jdField_a_of_type_Bngy.b();
        }
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbhb);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbhg);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbhh);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbhf);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbgz);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbhd);
        return;
        bool1 = false;
        break;
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Bbhb)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbhb);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Bbhg)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbhg);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Bbhf)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbhf);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Bbhh)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbhh);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Bbhf)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbhf);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Bbgz)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbgz);
      }
    } while (GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Bbhd));
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbhd);
  }
  
  private long b()
  {
    long l1 = 9223372036854775807L;
    try
    {
      long l2 = bhbx.b();
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    l1 >>>= 20;
    QLog.d(this.jdField_a_of_type_JavaLangString, 4, "available size = " + l1 + "M");
    return l1 / 30L;
  }
  
  private void b(bnay parambnay)
  {
    Object localObject = a().getIntent();
    if (bnlb.j((Intent)localObject))
    {
      this.jdField_a_of_type_Bnqc.a(262148, new Object[] { parambnay });
      return;
    }
    if (bnlb.f((Intent)localObject))
    {
      localObject = new borc(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.getSelectedCamera()).a(this.jdField_a_of_type_Bmvr.a()).a(this.jdField_a_of_type_Bmvr.a()).a(1).a();
      this.jdField_a_of_type_Boqz.a((bora)localObject);
      this.jdField_a_of_type_Bnqc.a(262148, new Object[] { parambnay, this.jdField_a_of_type_Boqz, Integer.valueOf(this.jdField_d_of_type_Int) });
      return;
    }
    if (bnlb.l((Intent)localObject))
    {
      b(true);
      this.jdField_a_of_type_Bnqc.a(262148, new Object[] { parambnay, this.jdField_a_of_type_Boqz, Integer.valueOf(this.jdField_d_of_type_Int) });
      return;
    }
    this.jdField_a_of_type_Bnqc.a(262148, new Object[] { parambnay, this.jdField_a_of_type_Bmvr.b(), Integer.valueOf(14) });
  }
  
  private void b(@Nullable AECaptureMode paramAECaptureMode1, @NonNull AECaptureMode paramAECaptureMode2)
  {
    if ((paramAECaptureMode1 != null) && (paramAECaptureMode1.shouldStartCamera())) {
      r();
    }
    if (!paramAECaptureMode2.shouldStartCamera()) {
      d(false);
    }
    int i1;
    do
    {
      return;
      if (this.jdField_a_of_type_Bmvr.g() == 0) {}
      for (i1 = bbhk.a();; i1 = this.jdField_a_of_type_Bmvr.g())
      {
        if (paramAECaptureMode2 == AECaptureMode.GIF) {
          i1 = 1;
        }
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setSelectedCamera(i1);
        return;
      }
    } while (!this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.changeCamera(i1, new bmxn(this));
  }
  
  private void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.o)
      {
        if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
        {
          this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
          this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(true);
        }
        e(true);
        this.o = false;
        bnrh.b(this.jdField_a_of_type_JavaLangString, "【Dark Mode】Start");
      }
      return;
    }
    if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
    {
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(false);
    }
    e(false);
    this.o = false;
  }
  
  private boolean m()
  {
    return this.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF;
  }
  
  private boolean n()
  {
    return (!this.m) && (!this.l) && (!this.n);
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_Bmvr.i() != bnlb.x.a())
    {
      String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
      if (bnlb.a(this.jdField_a_of_type_Bmvr.i()).a()) {
        bnqq.a().a(this.jdField_a_of_type_Bmvr.i(), str);
      }
      str = a().getIntent().getStringExtra("intent_key_uid_for_report");
      bnqq.a().a(str);
      bnqq.a().a(true);
      bnqq.a().b();
      bnqq.a().a();
      bnqq.a().b(bnjq.a(a()));
    }
    bnqm.a().ac();
    if (bnlb.e.a(this.jdField_a_of_type_Bmvr.i())) {
      ykv.a("check_Android", bnlb.e.a(), 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
    }
  }
  
  protected void H()
  {
    ThreadManager.excute(new AEPituCameraUnit.8(this), 16, null, true);
  }
  
  @NotNull
  protected void I()
  {
    if (!this.jdField_b_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera())
    {
      Z();
      if (k())
      {
        ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378164);
        if (localViewStub != null)
        {
          localViewStub.inflate();
          bnrh.b(this.jdField_a_of_type_JavaLangString, "AEPartAction--inflate bottom");
        }
      }
      this.jdField_a_of_type_Bnqc.a();
    }
  }
  
  public void J()
  {
    X();
  }
  
  public void K()
  {
    this.jdField_a_of_type_Bnqc.a(786435, new Object[0]);
  }
  
  public void L()
  {
    O();
  }
  
  public void M()
  {
    bmuv localbmuv = (bmuv)bogd.a(13);
    if (bnlb.e.a(this.jdField_a_of_type_Bmvr.i()))
    {
      localbmuv.b(14);
      return;
    }
    localbmuv.b(this.jdField_a_of_type_Boqz.jdField_c_of_type_Int);
  }
  
  protected void N()
  {
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null) {
      book.a(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.a(), 200L, null);
    }
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null)
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFrontCamera()) {
        this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setContentDescription(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.getResources().getString(2131718070));
      }
    }
    else {
      if (!m()) {
        break label93;
      }
    }
    for (;;)
    {
      o();
      return;
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setContentDescription(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.getResources().getString(2131718071));
      break;
      label93:
      bnqm.a().J();
      bnrh.b(this.jdField_a_of_type_JavaLangString, "【Change Camera】:isFrontCamera:" + this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFrontCamera());
    }
  }
  
  protected void O()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.16(this));
  }
  
  public void P()
  {
    if (i()) {
      R();
    }
    while (!j()) {
      return;
    }
    Q();
  }
  
  protected void Q()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", false);
    a().sendBroadcast(localIntent);
    this.jdField_a_of_type_Bnqc.a(131076, new Object[0]);
  }
  
  protected void R()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", true);
    a().sendBroadcast(localIntent);
    this.jdField_a_of_type_Bnqc.a(131077, new Object[0]);
  }
  
  protected void S()
  {
    this.jdField_a_of_type_Bmxy = ((bmxy)bmxz.a(this).get(bmxy.class));
    this.jdField_a_of_type_Bnpz = ((bnpz)bmxz.a(this).get(bnpz.class));
    this.jdField_a_of_type_Bnpz.a.observe(this, new bmxe(this));
    this.jdField_a_of_type_Bnqa = ((bnqa)bmxz.a(this).get(bnqa.class));
    this.jdField_a_of_type_Bnqa.e().observe(this, new bmxg(this));
    this.jdField_a_of_type_Bnqa.d().observe(this, new bmxh(this));
    this.jdField_a_of_type_Bnqa.b().observe(this, new bmxi(this));
    this.jdField_a_of_type_Bnqa.c().observe(this, new bmxj(this));
  }
  
  public void T()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.27(this));
    }
  }
  
  public void U()
  {
    this.jdField_a_of_type_Borh.a().onBackPressed();
  }
  
  public void V()
  {
    a().getIntent().removeExtra("widgetinfo");
    bnrj.a(a());
  }
  
  protected void W()
  {
    bmvv.a(false, a());
    this.jdField_a_of_type_Bnqa.a().postValue(Boolean.valueOf(false));
  }
  
  public void X()
  {
    if (this.jdField_a_of_type_Bngy != null) {
      this.jdField_a_of_type_Bngy.c();
    }
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null) {
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    }
    bmvv.a(false, a());
    this.jdField_a_of_type_Bnqa.a().postValue(Boolean.valueOf(false));
  }
  
  protected void Y()
  {
    this.jdField_a_of_type_Bbhb = new bbhb();
    this.jdField_a_of_type_Bbhb.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel);
    this.jdField_a_of_type_Bbhb.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel);
    this.jdField_a_of_type_Bbhb.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Bbhb.a(new bmxo(this));
    this.jdField_a_of_type_Bbhh = new bbhh(this.jdField_a_of_type_Bbhi);
    this.jdField_a_of_type_Bbhf = new bbhf(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
    this.jdField_a_of_type_Bbgz = new bbgz(a(), this.jdField_a_of_type_Bbha);
    this.jdField_a_of_type_Bbhd = new bbhd(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getContext(), this.jdField_a_of_type_Bbhe);
  }
  
  @MainThread
  public void Z()
  {
    bnrh.b(this.jdField_a_of_type_JavaLangString, "setCaptureModeViewModel---");
    bnpz localbnpz = (bnpz)bmxz.a(this).get(bnpz.class);
    localbnpz.a.setValue(new bnpr(null, this.jdField_a_of_type_Bmvr.a(), 1));
    localbnpz.b.setValue(this.jdField_a_of_type_Bmvr.a());
  }
  
  protected int a()
  {
    if (k()) {
      return 2131558527;
    }
    return 2131558526;
  }
  
  protected long a()
  {
    return 5L;
  }
  
  protected BroadcastReceiver a()
  {
    return this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_a_of_type_Bnbg = a();
    this.jdField_a_of_type_Bnqc = new bnqc(this.jdField_a_of_type_Borh.a(), this.jdField_a_of_type_AndroidViewView, this);
    ((AEVideoStoryTopBarViewModel)bmxz.a(this).get(AEVideoStoryTopBarViewModel.class)).a.setValue(this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
    ab();
    I();
    S();
    Y();
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setMaterialPanelListener(this.jdField_a_of_type_Bnfv);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.setMaterialPanelListener(this.jdField_a_of_type_Bngl);
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(a(), new bmxx(this), null, true);
    this.jdField_a_of_type_Bngy = new bngy(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Bnqc);
    this.jdField_a_of_type_Bnbn = new bnbn((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378170));
    this.jdField_a_of_type_Bmxy.b.postValue(this.jdField_a_of_type_Bnbn);
    Object localObject = this.jdField_a_of_type_Bnbn;
    if (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL)
    {
      bool = true;
      ((bnbn)localObject).a(bool);
      this.jdField_a_of_type_Bngm = new bngm((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131378162));
      this.jdField_a_of_type_Bmxy.a.setValue(this.jdField_a_of_type_Bngm);
      CosFunHelper.setCountDownListener(new bmxc(this));
      this.jdField_a_of_type_Bngm.a(this.jdField_a_of_type_Bbhb);
      this.jdField_a_of_type_Bbhg = this.jdField_a_of_type_Bnbn.a();
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)) {
        break label502;
      }
    }
    label502:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 1, "onCreateView needLiuHaiTop:" + bool);
        }
        localObject = a().getIntent().getStringExtra("key_guide_image");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = axln.a(((String)localObject).substring("data:image/png;base64,".length()));
          localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
          if (BitmapUtils.isLegal((Bitmap)localObject))
          {
            ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363666);
            localImageView.setImageBitmap((Bitmap)localObject);
            localImageView.setVisibility(0);
          }
        }
        bnrh.b(this.jdField_a_of_type_JavaLangString, "[UnitAsyncInit] before await");
        try
        {
          this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
          bnrh.b(this.jdField_a_of_type_JavaLangString, "[UnitAsyncInit] after await");
          return localView;
          bool = false;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            bnrh.d(this.jdField_a_of_type_JavaLangString, "[UnitAsyncInit] await interrupt exp: " + localInterruptedException.getMessage());
          }
        }
      }
    }
  }
  
  protected bbhp a()
  {
    return this;
  }
  
  protected bnax a()
  {
    int i2 = 1;
    Intent localIntent = a().getIntent();
    if (bnlb.i(localIntent)) {
      if ((localIntent.getBooleanExtra("key_camera_prefer_id", false)) || (!aqmy.d())) {
        i2 = 2;
      }
    }
    label103:
    while (bddt.l())
    {
      return bpnj.a().a(this.jdField_a_of_type_Borh.a(), i2);
      if (this.jdField_a_of_type_Bmvr.g() == 0) {}
      for (int i1 = bbhk.a();; i1 = this.jdField_a_of_type_Bmvr.g())
      {
        if ((this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) && (aqmy.d())) {
          break label103;
        }
        i2 = i1;
        break;
      }
    }
    return bpnj.a().a(this.jdField_a_of_type_Bmvr);
  }
  
  public bnbg a()
  {
    if (this.jdField_a_of_type_Bnbg == null) {
      this.jdField_a_of_type_Bnbg = new bnbg(this.jdField_a_of_type_AndroidViewView, this);
    }
    return this.jdField_a_of_type_Bnbg;
  }
  
  protected AECameraManager.CameraManagerListener a()
  {
    return this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager$CameraManagerListener;
  }
  
  public AECaptureMode a(int paramInt)
  {
    AECaptureMode localAECaptureMode = AECaptureMode.NORMAL;
    switch (paramInt)
    {
    default: 
      localAECaptureMode = AECaptureMode.NORMAL;
    }
    for (;;)
    {
      bnrh.b(this.jdField_a_of_type_JavaLangString, "initCaptureModesAndFirstMode---initialMode=" + localAECaptureMode + ", initialCModes=" + Arrays.toString(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode));
      return localAECaptureMode;
      localAECaptureMode = AECaptureMode.PLAY;
      continue;
      localAECaptureMode = AECaptureMode.PLAY;
      continue;
      localAECaptureMode = AECaptureMode.NORMAL;
      continue;
      localAECaptureMode = a(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode, paramInt);
      continue;
      localAECaptureMode = a(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode, paramInt);
      continue;
      localAECaptureMode = AECaptureMode.GIF;
    }
  }
  
  protected void a()
  {
    if (this.j) {
      return;
    }
    this.j = true;
    bnrh.b(this.jdField_a_of_type_JavaLangString, "actionAfterFirstFrame");
    int i1 = this.jdField_a_of_type_Borh.a().getIntent().getIntExtra("edit_video_type", 10002);
    PeakAppInterface.a.a(boha.jdField_a_of_type_JavaLangString, new Object[] { this, Integer.valueOf(i1) });
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      PeakAppInterface.a.a(1010);
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.17(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.12(this));
    this.jdField_a_of_type_Bnbg.e();
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "notifyPreviewSizeChanged: ");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onActivityResult:requestCode=" + paramInt1 + " resultCode=" + paramInt2 + " data=" + paramIntent + " publishStoryFlag=" + f);
    }
    Activity localActivity = this.jdField_a_of_type_Borh.a();
    bbht.a(localActivity, paramInt1, paramInt2);
    boolean bool;
    if ((localActivity == null) || (localActivity.isFinishing())) {
      if (QLog.isColorLevel())
      {
        paramIntent = this.jdField_a_of_type_JavaLangString;
        if (localActivity != null) {
          break label147;
        }
        bool = true;
        QLog.d(paramIntent, 2, new Object[] { "activity is finishing, ", Boolean.valueOf(bool) });
      }
    }
    label147:
    label178:
    Object localObject1;
    do
    {
      do
      {
        return;
        bool = false;
        break;
        if (paramInt1 != 1024) {
          break label178;
        }
      } while (paramInt2 != -1);
      localActivity.setResult(-1, paramIntent);
      localActivity.finish();
      return;
      Object localObject2;
      if ((paramInt1 == 1025) && (paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("file_send_path");
        long l1 = paramIntent.getLongExtra("file_send_duration", -1L);
        localObject2 = paramIntent.getStringExtra("widgetinfo");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (l1 > 0L))
        {
          paramIntent = new Intent(localActivity, SendVideoActivity.class);
          paramIntent.putExtra("file_send_path", (String)localObject1);
          paramIntent.putExtra("file_send_size", new File((String)localObject1).length());
          paramIntent.putExtra("file_send_duration", l1);
          paramIntent.putExtra("uin", this.jdField_a_of_type_Bmvr.a().jdField_a_of_type_JavaLangString);
          paramIntent.putExtra("uintype", this.jdField_a_of_type_Bmvr.a().jdField_a_of_type_Int);
          paramIntent.putExtra("file_source", "album");
          paramIntent.putExtra("start_init_activity_after_sended", false);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramIntent.putExtra("widgetinfo", (String)localObject2);
          }
          localActivity.startActivity(paramIntent);
          localActivity.finish();
          return;
        }
      }
      if ((paramInt1 == 10013) && (paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
        localObject2 = (boje)bogd.a().c(8);
        if (localObject2 != null) {
          ((boje)localObject2).c();
        }
        localActivity.startActivityForResult(a(localActivity, ReadInJoyDeliverVideoActivity.class, (PublishParam)localObject1, paramIntent), 111);
        localActivity.setResult(paramInt2, paramIntent);
        localActivity.finish();
        return;
      }
      if (paramInt1 == 111)
      {
        localActivity.setResult(paramInt2, paramIntent);
        localActivity.finish();
        return;
      }
      bnrh.a(this.jdField_a_of_type_JavaLangString, String.format("onActivityResult, requestCode=%d, resultCode=%d, data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent }));
      if ((paramInt1 == 10001) && (paramInt2 == -1))
      {
        if (this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult != null) {}
        for (paramInt1 = this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoFrameCount;; paramInt1 = 0)
        {
          paramIntent.putExtra("KEY_VIDEO_FRAME_COUNT", paramInt1);
          localActivity.setResult(paramInt2, paramIntent);
          localActivity.finish();
          return;
        }
      }
      if (paramInt1 != 10020) {
        break label594;
      }
    } while (paramInt2 != -1);
    localActivity.setResult(paramInt2, paramIntent);
    localActivity.finish();
    return;
    label594:
    if ((paramIntent == null) && (paramInt2 == 0) && (f))
    {
      f = false;
      return;
    }
    if ((paramInt2 == -1) && ((paramInt1 == 10006) || (paramInt1 == 1012))) {
      this.jdField_a_of_type_Bnbg.i();
    }
    if (paramInt2 == 0) {
      bmvb.a(null);
    }
    if ((paramIntent != null) && (this.jdField_a_of_type_Bmvr.a() != null)) {
      paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_Bmvr.a().a());
    }
    if ((paramInt1 == 1012) && (paramInt2 == -1))
    {
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if ((paramIntent == null) || (!paramIntent.getBooleanExtra("input_full_screen_mode", false))) {
          break label767;
        }
        bool = true;
        label722:
        if (paramIntent == null) {
          break label773;
        }
        paramIntent.putExtra("input_full_screen_mode_result", (String)localObject1);
        paramIntent.putExtra("input_full_screen_mode", bool);
        localActivity.setResult(-1, paramIntent);
      }
      for (;;)
      {
        localActivity.finish();
        return;
        localObject1 = "";
        break;
        label767:
        bool = false;
        break label722;
        label773:
        paramIntent = new Intent();
        paramIntent.putExtra("input_full_screen_mode_result", (String)localObject1);
        paramIntent.putExtra("input_full_screen_mode", bool);
        localActivity.setResult(-1, paramIntent);
      }
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      bmvc.a(this.jdField_a_of_type_Borh.a(), paramIntent, this.jdField_a_of_type_Borg, null);
      return;
    }
    this.jdField_a_of_type_Bnqc.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void a(int paramInt, AEFilterManager paramAEFilterManager)
  {
    if (this.jdField_a_of_type_Bnqc != null) {
      this.jdField_a_of_type_Bnqc.a(196617, new Object[] { Integer.valueOf(paramInt), paramAEFilterManager });
    }
  }
  
  protected void a(long paramLong)
  {
    boolean bool2 = false;
    Intent localIntent = new Intent(a(), AEStoryGIFPreviewActivity.class);
    localIntent.putExtra("KEY_PREVIEW_SOURCE_PATH", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath);
    localIntent.putExtra("KEY_AVAILABLE_EMO_COUNT", paramLong);
    Object localObject = (bnmb)bmxz.a(this).get(bnmb.class);
    bnkg localbnkg = (bnkg)((bnmb)localObject).b().getValue();
    if (localbnkg != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localIntent.putExtra("KEY_MATERIAL_APPLIED", bool1);
      if (localbnkg != null) {
        localIntent.putExtra("ARG_GIF_MATERIAL_ID", localbnkg.jdField_a_of_type_JavaLangString);
      }
      localIntent.putExtra("KEY_AVAILABLE_SAVENAME", (String)((bnmb)localObject).c().getValue());
      localIntent.putExtra("ARG_SESSION_INFO", this.jdField_a_of_type_Bmvr.a());
      localObject = a().getIntent();
      if (!bnlb.f((Intent)localObject))
      {
        bool1 = bool2;
        if (!bnlb.g((Intent)localObject)) {}
      }
      else
      {
        bool1 = true;
      }
      localIntent.putExtra("ARG_GIF_SEND_TO_AIO", bool1);
      localObject = a();
      if (localObject != null)
      {
        localIntent.putExtra("AECAMERA_MODE", this.jdField_a_of_type_Bmvr.j());
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", this.jdField_a_of_type_Bmvr.i());
        ((Activity)localObject).startActivityForResult(localIntent, 101);
      }
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    bnrh.a(this.jdField_a_of_type_JavaLangString, "[AE Profiler] AEPituCameraUnit onCreate");
    long l1 = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    bnqq.a().c(l1);
    super.a(paramBundle);
    com.tencent.sveffects.SvEffectSdkInitor.isDovCapture = true;
    f = false;
    bpjt.a().b(false);
    this.jdField_a_of_type_ComTencentTtpicOpenapiWatermarkLogicDataManager$IOnClickWatermarkListener = new bmxw(this);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) && ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton instanceof AEPituCameraCaptureButtonLayout))) {
      ((AEPituCameraCaptureButtonLayout)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton).a(paramMotionEvent);
    }
  }
  
  protected void a(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (paramAEVideoCaptureResult.videoFrameCount < a())
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onVideoCaptured. videoFrameCount = " + this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoFrameCount + " ; minFrameCount = " + a());
        }
        O();
        return;
      }
      bnrh.b(this.jdField_a_of_type_JavaLangString, "【GIF Capture】during time:" + (paramAEVideoCaptureResult.finishTimeMs - paramAEVideoCaptureResult.startTimeMs) + "ms");
      bnqq.a().b(5L);
      bnqm.a().ah();
      long l1 = b();
      if (l1 > 0L)
      {
        a(l1);
        return;
      }
      paramAEVideoCaptureResult = BaseApplicationImpl.getContext();
    } while (paramAEVideoCaptureResult == null);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.36(this, paramAEVideoCaptureResult));
  }
  
  public void a(@NonNull List<bnes> paramList, @NonNull List<bner> paramList1)
  {
    this.jdField_a_of_type_Bnqc.a(720897, new Object[] { paramList, paramList1 });
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.18(this));
  }
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected boolean a()
  {
    return k();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramInt == 4) {
      b();
    }
    return super.a(paramInt, paramKeyEvent, paramBoolean);
  }
  
  public AECaptureMode[] a(int paramInt)
  {
    AECaptureMode[] arrayOfAECaptureMode;
    switch (paramInt)
    {
    default: 
      arrayOfAECaptureMode = new AECaptureMode[1];
      arrayOfAECaptureMode[0] = AECaptureMode.NORMAL;
    }
    for (;;)
    {
      bnrh.b(this.jdField_a_of_type_JavaLangString, "initCaptureModesAndFirstMode---initialMode=" + this.jdField_a_of_type_DovComQqImAeModeAECaptureMode + ", initialCModes=" + Arrays.toString(arrayOfAECaptureMode));
      return arrayOfAECaptureMode;
      arrayOfAECaptureMode = new AECaptureMode[1];
      arrayOfAECaptureMode[0] = AECaptureMode.PLAY;
      continue;
      arrayOfAECaptureMode = new AECaptureMode[2];
      arrayOfAECaptureMode[0] = AECaptureMode.PLAY;
      arrayOfAECaptureMode[1] = AECaptureMode.GIF;
      continue;
      arrayOfAECaptureMode = new AECaptureMode[2];
      arrayOfAECaptureMode[0] = AECaptureMode.NORMAL;
      arrayOfAECaptureMode[1] = AECaptureMode.GIF;
      continue;
      arrayOfAECaptureMode = new AECaptureMode[2];
      arrayOfAECaptureMode[0] = AECaptureMode.NORMAL;
      arrayOfAECaptureMode[1] = AECaptureMode.PLAY;
      continue;
      arrayOfAECaptureMode = new AECaptureMode[3];
      arrayOfAECaptureMode[0] = AECaptureMode.NORMAL;
      arrayOfAECaptureMode[1] = AECaptureMode.PLAY;
      arrayOfAECaptureMode[2] = AECaptureMode.GIF;
      continue;
      arrayOfAECaptureMode = new AECaptureMode[1];
      arrayOfAECaptureMode[0] = AECaptureMode.GIF;
    }
  }
  
  public void aa()
  {
    this.jdField_a_of_type_Bnbg.a();
  }
  
  public void ab()
  {
    LiuHaiUtils.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, ViewUtils.dip2px(1.0F));
    ac();
  }
  
  protected void ac()
  {
    Object localObject = a();
    if (ScreenUtil.getRealHeight((Context)localObject) / ScreenUtil.getRealWidth((Context)localObject) >= 2.0F)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (!bnlb.h(this.jdField_a_of_type_Bmvr.i())) {
        a((Activity)localObject);
      }
    }
    if ((Build.MODEL.contains("Pixel 2")) && (Build.VERSION.SDK_INT >= 16))
    {
      localObject = ((Activity)localObject).getWindow().getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() & 0xFFFFFFFB);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_b_of_type_AndroidViewView.getViewTreeObserver();
      if (((ViewTreeObserver)localObject).isAlive()) {
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(new bmxs(this));
      }
    }
  }
  
  protected int b()
  {
    int i1;
    if (k())
    {
      i1 = bnrg.a();
      if (i1 == 1)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
        ((AEVideoStoryTopBarViewModel)bmxz.a(this).get(AEVideoStoryTopBarViewModel.class)).a.setValue(this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio.code;
      if (i1 == 2)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
        break;
      }
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.FULL;
      break;
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.FULL;
    }
  }
  
  public void b()
  {
    bnrh.b(this.jdField_a_of_type_JavaLangString, "onActivityPause");
    super.b();
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbhb);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbhg);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbhh);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbhf);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbgz);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbhd);
    if (this.jdField_a_of_type_Bnbn != null) {
      this.jdField_a_of_type_Bnbn.b();
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.l();
    }
    this.jdField_a_of_type_Bnbg.g();
    this.jdField_a_of_type_Bnqc.c();
    bnkb.b = false;
    if (QLog.isDevelopLevel()) {
      bnrh.a(this.jdField_a_of_type_JavaLangString, "onActivityPause, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void b(String paramString)
  {
    bnkb localbnkb = (bnkb)bogd.a().c(18);
    if ((localbnkb != null) && (!TextUtils.isEmpty(paramString)))
    {
      localbnkb.a(false);
      paramString = localbnkb.a(paramString, k());
      if (paramString == null) {
        Toast.makeText(a(), 2131689682, 1).show();
      }
    }
    else
    {
      return;
    }
    bmvv.a(false, a());
    a().a(true, 150);
    this.jdField_a_of_type_Bnqc.a(327683, new Object[] { paramString });
    this.jdField_a_of_type_Bnqc.a(196612, new Object[0]);
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Bnbg == null) {
      return false;
    }
    if (this.jdField_a_of_type_Bnbg.a()) {
      return false;
    }
    if ((this.jdField_a_of_type_Bnqc.a(589824)) && (((Boolean)this.jdField_a_of_type_Bnqc.a(589826, new Object[0])).booleanValue()))
    {
      bnrh.a(this.jdField_a_of_type_JavaLangString, "WaterMark editor need hide");
      this.jdField_a_of_type_Bnqc.a(589826, new Object[0]);
      return true;
    }
    this.jdField_a_of_type_Bnbg.g();
    this.jdField_a_of_type_Bnbg.i();
    Intent localIntent;
    String str1;
    String str2;
    if (k())
    {
      localIntent = a().getIntent();
      str1 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      if (str1 != null)
      {
        localIntent.setClassName(str2, str1);
        localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
        localIntent.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
        localIntent.addFlags(603979776);
        if (localIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
          break label207;
        }
        a().startActivity(localIntent);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Borh.a();
      bnqm.a().G();
      bnrh.b(this.jdField_a_of_type_JavaLangString, "【Click】onBackPressed");
      return true;
      label207:
      localIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
      str2 = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      String str3 = localIntent.getStringExtra("PhotoConst.UIN");
      if ("qzone_plugin.apk".equals(str2))
      {
        QzonePluginProxyActivity.setActivityNameToIntent(localIntent, str1);
        QZoneHelper.launchQZone(a(), str3, localIntent, 2);
      }
    }
  }
  
  public void c()
  {
    super.c();
    if (bnep.a()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.debugInfoCallback = null;
    }
    this.jdField_a_of_type_Bnqc.f();
    if (this.jdField_a_of_type_Bnbn != null) {
      this.jdField_a_of_type_Bnbn.c();
    }
    bpss.a.clear();
    this.jdField_a_of_type_Bnqz.b();
    bnqq.a().k();
    bnqq.a().a(false);
    bnqi.b();
    if ((a() != null) && (bnlb.i(a().getIntent()))) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setSelectedCamera(bbhk.a());
    }
    bnkb localbnkb = (bnkb)bogd.a(18);
    localbnkb.a();
    localbnkb.g();
    if (this.jdField_a_of_type_Bnbg != null) {
      this.jdField_a_of_type_Bnbg.d();
    }
    LogicDataManager.getInstance().setOnClickWatermarkListener(null);
  }
  
  protected boolean c()
  {
    if (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) {}
    while (bnlb.i(a().getIntent())) {
      return false;
    }
    return true;
  }
  
  public void d()
  {
    bnrh.b(this.jdField_a_of_type_JavaLangString, "onActivityResume");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onResume();
    if (f) {
      bnrh.d(this.jdField_a_of_type_JavaLangString, "onActivityResume---publishStoryFlag is true, activity will finish soon, fast return");
    }
    do
    {
      return;
      super.d();
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.refreshDarkModeTimer();
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onResume();
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbhb);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbhg);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbhh);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbhf);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbgz);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbhd);
      this.jdField_a_of_type_Bnbg.h();
      if (this.i)
      {
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.k();
        }
        e();
        a(false);
      }
      if (this.jdField_a_of_type_Bnqc != null) {
        this.jdField_a_of_type_Bnqc.b();
      }
      M();
      f(false);
      bnkb.b = true;
    } while (!QLog.isDevelopLevel());
    bnrh.a(this.jdField_a_of_type_JavaLangString, "onActivityResume, ID=" + this.jdField_c_of_type_Int);
  }
  
  public void d(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366988);
    if ((localView instanceof VideoFilterViewPager))
    {
      ((VideoFilterViewPager)localView).setVisibility(paramInt);
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "yes to domVideoFilterViewPager setVisibility: " + paramInt);
    }
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    int i3 = 1;
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Borh.a();
    int i1;
    int i2;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i1 = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label193;
      }
      i2 = 1;
      label48:
      if (PermissionUtils.isStorePermissionEnable((Context)localObject)) {
        break label198;
      }
    }
    for (;;)
    {
      localObject = new LinkedList();
      if (i1 != 0)
      {
        ((List)localObject).add("android.permission.CAMERA");
        bnrh.b(this.jdField_a_of_type_JavaLangString, "【Camera Permission】denied");
      }
      if (i2 != 0)
      {
        ((List)localObject).add("android.permission.RECORD_AUDIO");
        bnrh.b(this.jdField_a_of_type_JavaLangString, "【Audio Permission】denied");
      }
      if (i3 != 0)
      {
        ((List)localObject).add("android.permission.READ_EXTERNAL_STORAGE");
        ((List)localObject).add("android.permission.WRITE_EXTERNAL_STORAGE");
        bnrh.b(this.jdField_a_of_type_JavaLangString, "【External Storage Permission】denied");
      }
      localObject = bhdj.a((String[])((List)localObject).toArray(new String[0]));
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.33(this, (String)localObject));
      return;
      i1 = 0;
      break;
      label193:
      i2 = 0;
      break label48;
      label198:
      i3 = 0;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null)
    {
      if (aqmy.d()) {
        this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      }
    }
    else
    {
      if (!GLVideoClipUtil.b()) {
        break label125;
      }
      if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null) {
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      }
    }
    for (;;)
    {
      f(true);
      bnqq.a().h();
      bnqm.a().ab();
      if ((!this.jdField_a_of_type_Bnpz.c()) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null)) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setVisibility(0);
      }
      if (n()) {
        bmvv.a(true, a());
      }
      this.jdField_a_of_type_Bnqa.a().postValue(Boolean.valueOf(true));
      return;
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(4);
      break;
      label125:
      if ((this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null) && (this.o))
      {
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(false);
      }
    }
  }
  
  public void e(int paramInt)
  {
    try
    {
      this.jdField_e_of_type_Int = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void f()
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_Bnqa.e().postValue(Boolean.valueOf(true));
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.resetMaterial();
    if ((this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFlashEnabled()) && (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF)) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.turnFlash(a(), true);
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.startCaptureVideo();
    if (!this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFrontCamera()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setFocusModeRecording();
    }
    ((bohj)bogd.a(5)).a(true);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bnqc.a(327687, new Object[0]);
      return;
    }
    this.jdField_a_of_type_Bnqc.a(327688, new Object[0]);
  }
  
  protected boolean f()
  {
    return bnlb.k(this.jdField_a_of_type_Bmvr.i());
  }
  
  public void g()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "onCaptureButtonVideoStop: thread = " + Thread.currentThread().getName());
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.stopCaptureVideo();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.stopRecordVideo();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Bnqa.e().postValue(Boolean.valueOf(false));
    ((bohj)bogd.a(5)).a(false);
    d(0);
  }
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onResourceDownload isOnlineRes: " + paramBoolean);
    }
    if (!g)
    {
      g = true;
      this.jdField_a_of_type_Borh.a().runOnUiThread(new AEPituCameraUnit.30(this));
      return;
    }
    this.jdField_a_of_type_Borh.a().runOnUiThread(new AEPituCameraUnit.31(this));
  }
  
  public boolean g()
  {
    return true;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    bnrh.b(this.jdField_a_of_type_JavaLangString, "【Camera / Audio / Storage Permission】grant");
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Boolean) {
      t();
    }
  }
  
  protected boolean h()
  {
    return (this.jdField_a_of_type_Bmvr != null) && (this.jdField_a_of_type_Bmvr.f() != -1);
  }
  
  public void i()
  {
    super.i();
  }
  
  protected boolean i()
  {
    return (this.jdField_a_of_type_Bmvr.c() == 101) && (this.jdField_a_of_type_Bmvr.c()) && (this.jdField_a_of_type_Bmvr.a()) && (this.jdField_a_of_type_Bmvr.f());
  }
  
  public void j()
  {
    bnrh.b(this.jdField_a_of_type_JavaLangString, "onActivityStart");
    super.j();
    if (this.jdField_a_of_type_Bnqc != null) {
      this.jdField_a_of_type_Bnqc.d();
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    bnqm.a().F();
    if (QLog.isDevelopLevel()) {
      bnrh.a(this.jdField_a_of_type_JavaLangString, "onActivityStart, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  protected boolean j()
  {
    return (this.jdField_a_of_type_Bmvr.c() == 101) && (this.jdField_a_of_type_Bmvr.e());
  }
  
  public void k()
  {
    bnrh.b(this.jdField_a_of_type_JavaLangString, "onActivityStop");
    super.k();
    this.jdField_a_of_type_Bnqc.e();
    bnqm.a().c(this.jdField_b_of_type_Long);
    if (QLog.isDevelopLevel()) {
      bnrh.a(this.jdField_a_of_type_JavaLangString, "onActivityStop, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  public boolean k()
  {
    return bnlb.j(a().getIntent());
  }
  
  protected void l()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAECaptureController(a());
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAeGLSurfaceListener(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$AEGLSurfaceListener);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setFaceEffectListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setStickerInnerLutFilterListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setRecommendTextCallback(new bmxp(this));
    if (bddt.l())
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(true);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setDynamicResolutionMode(true);
    }
    for (;;)
    {
      if (bnep.a()) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.debugInfoCallback = this;
      }
      if (k()) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAeEditMaterialSelectedListener(new bmxq(this));
      }
      return;
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(false);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setDynamicResolutionMode(false);
    }
  }
  
  /* Error */
  public boolean l()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 123	bmxa:jdField_e_of_type_Int	I
    //   8: istore_1
    //   9: iload_1
    //   10: iconst_1
    //   11: if_icmpeq +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	bmxa
    //   8	4	1	i1	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  protected void m()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.32(this));
  }
  
  public void n()
  {
    W();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setVisibility(8);
    }
    this.jdField_a_of_type_Bnqc.a(196609, new Object[0]);
    this.jdField_a_of_type_Bnqc.a(262147, new Object[0]);
  }
  
  public void notifyEnableStickerInnerEffectFilter(boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject;
    boolean bool1;
    if (paramBoolean)
    {
      e(1);
      if (this.jdField_a_of_type_Bnqc != null) {
        this.jdField_a_of_type_Bnqc.a(196609, new Object[0]);
      }
      localObject = AEFilterManagerHolder.getAEFilterManager();
      if (localObject != null)
      {
        if (paramBoolean) {
          break label97;
        }
        bool1 = true;
        label48:
        ((bnaz)localObject).jdField_a_of_type_Boolean = bool1;
        if (paramBoolean) {
          ((bnaz)localObject).f();
        }
      }
      if (this.jdField_a_of_type_Bnbg != null)
      {
        localObject = this.jdField_a_of_type_Bnbg;
        if (paramBoolean) {
          break label102;
        }
      }
    }
    label97:
    label102:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((bnbg)localObject).jdField_a_of_type_Boolean = paramBoolean;
      return;
      e(0);
      break;
      bool1 = false;
      break label48;
    }
  }
  
  public void onAEKitInited()
  {
    super.onAEKitInited();
    int i1 = AEBeautyProviderView.a();
    int i2 = AEBeautyProviderView.b();
    this.jdField_a_of_type_Bnbg.a(i1);
    this.jdField_a_of_type_Bnbg.b(i2);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.10(this));
    bnlh.a().a();
  }
  
  public void onCaptureError(int paramInt)
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Bnqa.e().postValue(Boolean.valueOf(false));
    bnrh.a(this.jdField_a_of_type_JavaLangString, "onCaptureError. errorCode = " + paramInt, new Throwable());
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.39(this, paramInt));
  }
  
  public void onClick(View paramView)
  {
    int i1 = 1;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
      {
        book.a(this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.a(), 200L, null);
        boolean bool;
        if (!this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.isSelected())
        {
          bool = true;
          label105:
          this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(bool);
          e(bool);
          if (bool) {
            break label147;
          }
          this.o = true;
          label127:
          bbht.a(bool);
          if (!bool) {
            break label155;
          }
        }
        for (;;)
        {
          bbhl.a(i1);
          break;
          bool = false;
          break label105;
          label147:
          this.o = false;
          break label127;
          label155:
          i1 = 2;
        }
        N();
        continue;
        book.a(paramView, 200L, null);
        U();
        continue;
        a().getIntent().removeExtra("widgetinfo");
      }
    }
  }
  
  public void onDetectStateChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bngy != null) {
      this.jdField_a_of_type_Bngy.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void onFilterReady() {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Bnqa.e().postValue(Boolean.valueOf(false));
    if (!paramBoolean)
    {
      onCaptureError(101);
      return;
    }
    bnrh.b(this.jdField_a_of_type_JavaLangString, "[onVideoCaptured] videoInfo = " + paramLocalMediaInfo.mDuration);
    bnqq.a().b(2L);
    bnqm.a().d(paramLocalMediaInfo.mDuration);
    b(false);
    this.jdField_a_of_type_Bnqc.a(196609, new Object[0]);
    this.jdField_a_of_type_Bnqc.a(262146, new Object[] { this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult, paramLocalMediaInfo, Integer.valueOf(this.jdField_d_of_type_Int), this.jdField_a_of_type_Boqz, this.jdField_a_of_type_Bnqc.a(196610, new Object[0]) });
  }
  
  public void onPhotoCaptured(bnay parambnay)
  {
    this.jdField_a_of_type_Bnay = parambnay;
    bnqq.a().b(1L);
    bnqm.a().d(-1L);
    bnrh.b(this.jdField_a_of_type_JavaLangString, "【Type】Photo");
    if (h()) {
      a(parambnay);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.15(this));
      return;
      b(parambnay);
    }
  }
  
  public void onSelectFaceEffect(VideoMaterial paramVideoMaterial)
  {
    T();
    if (!m())
    {
      if (paramVideoMaterial == null) {
        bnqq.a().c("none");
      }
    }
    else
    {
      if (VideoMaterialUtil.isWatermarkMaterial(paramVideoMaterial)) {
        bnhv.a().a();
      }
      if ((!VideoMaterialUtil.isWatermarkEditable(paramVideoMaterial)) || (m())) {
        break label118;
      }
      a().runOnUiThread(new AEPituCameraUnit.28(this, paramVideoMaterial));
      label67:
      if (this.jdField_a_of_type_Bngy != null) {
        this.jdField_a_of_type_Bngy.a(paramVideoMaterial);
      }
      if (paramVideoMaterial != null)
      {
        if (!StringUtils.equals(paramVideoMaterial.getPreferCameraId(), "back")) {
          break label137;
        }
        a(2);
      }
    }
    label118:
    while (!StringUtils.equals(paramVideoMaterial.getPreferCameraId(), "front"))
    {
      return;
      bnqq.a().c(paramVideoMaterial.getId());
      break;
      a().runOnUiThread(new AEPituCameraUnit.29(this, paramVideoMaterial));
      break label67;
    }
    label137:
    a(1);
  }
  
  public void onSetFilterProcess(bnaz parambnaz)
  {
    if ((parambnaz != null) && (this.jdField_a_of_type_Bngy != null)) {
      parambnaz.a(this.jdField_a_of_type_Bngy.a());
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.a(), this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
    }
    return true;
  }
  
  public void onVideoCaptureStart()
  {
    X();
    d(8);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.13(this));
    this.jdField_a_of_type_Bnqc.a(196609, new Object[0]);
    this.jdField_a_of_type_Bnqc.a(262145, new Object[0]);
  }
  
  public void onVideoCaptured(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = paramAEVideoCaptureResult;
    this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.finishTimeMs = System.currentTimeMillis();
    if (m()) {
      a(paramAEVideoCaptureResult);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.14(this));
      return;
      int i1 = 500;
      if (this.jdField_d_of_type_Int == 13) {
        i1 = 2000;
      }
      if (bpqb.a(paramAEVideoCaptureResult.videoMp4FilePath) < i1)
      {
        this.jdField_e_of_type_Boolean = false;
        this.jdField_a_of_type_Bnqa.e().postValue(Boolean.valueOf(false));
        O();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = paramAEVideoCaptureResult.videoMp4FilePath;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
      MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    }
  }
  
  protected void p()
  {
    super.p();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367064);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131373297));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel = ((AEWaterMarkPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131373298));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxa
 * JD-Core Version:    0.7.0.1
 */