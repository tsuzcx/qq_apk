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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.string.StringUtils;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import dov.com.qq.im.ae.AEPituCameraUnit.10;
import dov.com.qq.im.ae.AEPituCameraUnit.11;
import dov.com.qq.im.ae.AEPituCameraUnit.12;
import dov.com.qq.im.ae.AEPituCameraUnit.13;
import dov.com.qq.im.ae.AEPituCameraUnit.14;
import dov.com.qq.im.ae.AEPituCameraUnit.15;
import dov.com.qq.im.ae.AEPituCameraUnit.16;
import dov.com.qq.im.ae.AEPituCameraUnit.19;
import dov.com.qq.im.ae.AEPituCameraUnit.20;
import dov.com.qq.im.ae.AEPituCameraUnit.21;
import dov.com.qq.im.ae.AEPituCameraUnit.22;
import dov.com.qq.im.ae.AEPituCameraUnit.23;
import dov.com.qq.im.ae.AEPituCameraUnit.24;
import dov.com.qq.im.ae.AEPituCameraUnit.25;
import dov.com.qq.im.ae.AEPituCameraUnit.26;
import dov.com.qq.im.ae.AEPituCameraUnit.27;
import dov.com.qq.im.ae.AEPituCameraUnit.28;
import dov.com.qq.im.ae.AEPituCameraUnit.31;
import dov.com.qq.im.ae.AEPituCameraUnit.34;
import dov.com.qq.im.ae.AEPituCameraUnit.7;
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
public class bljy
  extends blio
  implements View.OnClickListener, View.OnTouchListener, babg, blrx, bmcl, bnue, AEFilterManager.StickerInnerEffectFilterListener, MediaScanner.OnMediaInfoScannerListener, AECameraGLSurfaceView.AEEffectListener
{
  public static boolean e;
  public static boolean f;
  private long jdField_a_of_type_Long;
  protected GestureDetector a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected baaq a;
  protected baar a;
  protected baas a;
  protected baau a;
  protected baav a;
  protected baaw a;
  protected baax a;
  protected baay a;
  protected baaz a;
  private blkr jdField_a_of_type_Blkr;
  public blnv a;
  public bloc a;
  protected blsm a;
  private blst jdField_a_of_type_Blst;
  public blsw a;
  private bmap jdField_a_of_type_Bmap;
  private bmaq jdField_a_of_type_Bmaq;
  public bmas a;
  private AECameraBroadcastReceiver jdField_a_of_type_DovComQqImAeCameraCoreAECameraBroadcastReceiver = new AECameraBroadcastReceiver(this);
  protected final AECameraGLSurfaceView.AEGLSurfaceListener a;
  protected final AECameraManager.CameraManagerListener a;
  protected AEMaterialPanel a;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  private long jdField_b_of_type_Long = -1L;
  protected View b;
  private AECompoundButton jdField_b_of_type_DovComQqImAeViewAECompoundButton;
  public boolean d;
  protected int e;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k = bmby.a();
  private boolean l;
  
  public bljy()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager$CameraManagerListener = new bljz(this);
    this.jdField_a_of_type_Blsm = new blkd(this);
    this.jdField_a_of_type_Baar = new blkh(this);
    this.jdField_a_of_type_Baaz = new blkm(this);
    this.jdField_a_of_type_Baav = new blkn(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$AEGLSurfaceListener = new blko(this);
    this.jdField_e_of_type_Int = 0;
    bmbx.b(this.jdField_a_of_type_JavaLangString, "[AEPituCameraUnit] + BEGIN");
    bmbx.a(this.jdField_a_of_type_JavaLangString, "unitConstructor--fake");
    bmbx.b(this.jdField_a_of_type_JavaLangString, "[AEPituCameraUnit] + END");
  }
  
  public bljy(bnbp parambnbp, bnbo parambnbo)
  {
    super(parambnbp, parambnbo);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager$CameraManagerListener = new bljz(this);
    this.jdField_a_of_type_Blsm = new blkd(this);
    this.jdField_a_of_type_Baar = new blkh(this);
    this.jdField_a_of_type_Baaz = new blkm(this);
    this.jdField_a_of_type_Baav = new blkn(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$AEGLSurfaceListener = new blko(this);
    this.jdField_e_of_type_Int = 0;
    bmbx.b(this.jdField_a_of_type_JavaLangString, "[AEPituCameraUnit] + BEGIN");
    long l1 = System.currentTimeMillis();
    bmau.a().a("unitConstructor-begin");
    Log.d(this.jdField_a_of_type_JavaLangString, "AEPituCameraUnit: cameraConfig.getFrom() =" + this.jdField_a_of_type_Blit.i());
    this.jdField_d_of_type_Int = 11;
    if (k())
    {
      this.jdField_d_of_type_Int = 13;
      this.jdField_a_of_type_Bnbh = new bnbh(10023, this.jdField_a_of_type_Blit.d(), this.jdField_a_of_type_Blit.a());
    }
    for (;;)
    {
      bmbx.b(this.jdField_a_of_type_JavaLangString, "[AEPituCameraUnit] submit unit init");
      v();
      bmbx.b(this.jdField_a_of_type_JavaLangString, "[AEPituCameraUnit] + END, time cost = " + (System.currentTimeMillis() - l1));
      return;
      if (!blvr.e.a(this.jdField_a_of_type_Blit.i()))
      {
        this.jdField_d_of_type_Int = this.jdField_a_of_type_Blit.b().intValue();
        this.jdField_a_of_type_Bnbh = new bnbh(this.jdField_a_of_type_Bnbp.a().getIntent().getIntExtra("edit_video_type", 10002), this.jdField_a_of_type_Blit.d(), this.jdField_a_of_type_Blit.a());
      }
      else
      {
        this.jdField_d_of_type_Int = 1;
      }
    }
  }
  
  private void U()
  {
    if (this.jdField_a_of_type_Blit.i() != blvr.x.a())
    {
      String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
      if (blvr.a(this.jdField_a_of_type_Blit.i()).a()) {
        bmbg.a().a(this.jdField_a_of_type_Blit.i(), str);
      }
      str = a().getIntent().getStringExtra("intent_key_uid_for_report");
      bmbg.a().a(str);
      bmbg.a().a(true);
      bmbg.a().b();
      bmbg.a().a();
      bmbg.a().b(blun.a(a()));
    }
    bmbc.a().ac();
    if (blvr.e.a(this.jdField_a_of_type_Blit.i())) {
      xwa.a("check_Android", blvr.e.a(), 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
    }
  }
  
  private void V()
  {
    if (this.j) {
      return;
    }
    this.j = true;
    bmbx.b(this.jdField_a_of_type_JavaLangString, "actionAfterFirstFrame");
    int m = this.jdField_a_of_type_Bnbp.a().getIntent().getIntExtra("edit_video_type", 10002);
    PeakAppInterface.a.a(bmri.jdField_a_of_type_JavaLangString, new Object[] { this, Integer.valueOf(m) });
    if (!this.g)
    {
      this.g = true;
      PeakAppInterface.a.a(1010);
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.15(this));
  }
  
  private void W()
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
      int m;
      if (localAECaptureMode2 != null)
      {
        m = paramArrayOfAECaptureMode.length;
        paramInt = 0;
        label40:
        if (paramInt < m) {
          if (paramArrayOfAECaptureMode[paramInt] != localAECaptureMode2) {}
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        AECaptureMode localAECaptureMode1 = localAECaptureMode2;
        if (paramInt == 0)
        {
          bmbx.d(this.jdField_a_of_type_JavaLangString, "[getFirstModeAccordingABTest], get invalid mode=" + localAECaptureMode2);
          localAECaptureMode1 = paramArrayOfAECaptureMode[0];
        }
        bmbx.b(this.jdField_a_of_type_JavaLangString, "[getFirstModeAccordingABTest], ABTest name=" + str + ", real picked mode=" + localAECaptureMode1);
        return localAECaptureMode1;
        m = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1);
        if ((paramInt == 201) && (blvr.c.a() == m)) {
          return AECaptureMode.PLAY;
        }
        if ((paramInt != 204) || (!blvr.d(m))) {
          break label218;
        }
        str = bmbk.a().a("app_alg_entrance_qzone_id_from833", "", 4);
        break;
        paramInt += 1;
        break label40;
      }
      label218:
      str = null;
    }
  }
  
  private void a(blnp paramblnp)
  {
    switch (this.jdField_a_of_type_Blit.f())
    {
    default: 
      return;
    case 0: 
    case 3: 
      this.jdField_a_of_type_Bmas.a(262148, new Object[] { paramblnp });
      return;
    case 2: 
      this.jdField_a_of_type_Bmas.a(262148, new Object[] { paramblnp, this.jdField_a_of_type_Blit.b(), Integer.valueOf(this.jdField_a_of_type_Blit.a()) });
      return;
    }
    bnbi localbnbi = new bnbk(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.getSelectedCamera()).a(this.jdField_a_of_type_Blit.a()).a(this.jdField_a_of_type_Blit.a()).a(1).a();
    this.jdField_a_of_type_Bnbh.a(localbnbi);
    this.jdField_a_of_type_Bmas.a(262148, new Object[] { paramblnp, this.jdField_a_of_type_Bnbh, this.jdField_a_of_type_Blit.b() });
  }
  
  private void a(LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable)
  {
    K();
    if (paramLazyLoadAnimationDrawable == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRunnable = new AEPituCameraUnit.20(this);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.21(this, paramLazyLoadAnimationDrawable));
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
      bmbx.b(this.jdField_a_of_type_JavaLangString, "onCaptureModeChanged---from " + paramAECaptureMode1 + " to " + paramAECaptureMode2);
      b(paramAECaptureMode1, paramAECaptureMode2);
      if (this.jdField_a_of_type_Baaq != null) {
        this.jdField_a_of_type_Baaq.a();
      }
      if (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF)
      {
        bool1 = true;
        bmbg.a().b(bool1);
        if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) {
          this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setIsGIFMode(bool1);
        }
        ThreadManager.getUIHandler().post(new AEPituCameraUnit.19(this));
        paramAECaptureMode1 = this.jdField_a_of_type_Bloc;
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
        if (this.jdField_a_of_type_Blsw != null) {
          this.jdField_a_of_type_Blsw.b();
        }
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Baas);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Baax);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Baay);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Baaw);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Baaq);
        GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Baau);
        return;
        bool1 = false;
        break;
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Baas)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Baas);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Baax)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Baax);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Baaw)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Baaw);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Baay)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Baay);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Baaw)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Baaw);
      }
      if (!GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Baaq)) {
        GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Baaq);
      }
    } while (GLGestureProxy.getInstance().hasListener(this.jdField_a_of_type_Baau));
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Baau);
  }
  
  private long b()
  {
    long l1 = 9223372036854775807L;
    try
    {
      long l2 = bftf.b();
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
  
  private void b(blnp paramblnp)
  {
    Object localObject = a().getIntent();
    if (blvr.j((Intent)localObject))
    {
      this.jdField_a_of_type_Bmas.a(262148, new Object[] { paramblnp });
      return;
    }
    if (blvr.f((Intent)localObject))
    {
      localObject = new bnbk(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.getSelectedCamera()).a(this.jdField_a_of_type_Blit.a()).a(this.jdField_a_of_type_Blit.a()).a(1).a();
      this.jdField_a_of_type_Bnbh.a((bnbi)localObject);
      this.jdField_a_of_type_Bmas.a(262148, new Object[] { paramblnp, this.jdField_a_of_type_Bnbh, Integer.valueOf(this.jdField_d_of_type_Int) });
      return;
    }
    if (blvr.l((Intent)localObject))
    {
      b(true);
      this.jdField_a_of_type_Bmas.a(262148, new Object[] { paramblnp, this.jdField_a_of_type_Bnbh, Integer.valueOf(this.jdField_d_of_type_Int) });
      return;
    }
    this.jdField_a_of_type_Bmas.a(262148, new Object[] { paramblnp, this.jdField_a_of_type_Blit.b(), Integer.valueOf(14) });
  }
  
  private void b(@Nullable AECaptureMode paramAECaptureMode1, @NonNull AECaptureMode paramAECaptureMode2)
  {
    if ((paramAECaptureMode1 != null) && (paramAECaptureMode1.shouldStartCamera())) {
      k();
    }
    if (!paramAECaptureMode2.shouldStartCamera()) {
      d(false);
    }
    int m;
    do
    {
      return;
      if (this.jdField_a_of_type_Blit.g() == 0) {}
      for (m = babb.a();; m = this.jdField_a_of_type_Blit.g())
      {
        if (paramAECaptureMode2 == AECaptureMode.GIF) {
          m = 1;
        }
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setSelectedCamera(m);
        return;
      }
    } while (!this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.changeCamera(m, new blkg(this));
  }
  
  private void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.l)
      {
        if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
        {
          this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
          this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(true);
        }
        e(true);
        this.l = false;
        bmbx.b(this.jdField_a_of_type_JavaLangString, "【Dark Mode】Start");
      }
      return;
    }
    if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
    {
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(false);
    }
    e(false);
    this.l = false;
  }
  
  private boolean m()
  {
    return this.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF;
  }
  
  public void A()
  {
    this.jdField_a_of_type_Bmas.a(786435, new Object[0]);
  }
  
  public void B()
  {
    E();
  }
  
  public void C()
  {
    blie localblie = (blie)bmql.a(13);
    if (blvr.e.a(this.jdField_a_of_type_Blit.i()))
    {
      localblie.b(14);
      return;
    }
    localblie.b(this.jdField_a_of_type_Bnbh.jdField_c_of_type_Int);
  }
  
  protected void D()
  {
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null) {
      bmys.a(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.a(), 200L, null);
    }
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null)
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFrontCamera()) {
        this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setContentDescription(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.getResources().getString(2131717699));
      }
    }
    else {
      if (!m()) {
        break label93;
      }
    }
    for (;;)
    {
      h();
      return;
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setContentDescription(this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.getResources().getString(2131717700));
      break;
      label93:
      bmbc.a().J();
      bmbx.b(this.jdField_a_of_type_JavaLangString, "【Change Camera】:isFrontCamera:" + this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFrontCamera());
    }
  }
  
  protected void E()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.14(this));
  }
  
  public void F()
  {
    if (i()) {
      H();
    }
    while (!j()) {
      return;
    }
    G();
  }
  
  protected void G()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", false);
    a().sendBroadcast(localIntent);
    this.jdField_a_of_type_Bmas.a(131076, new Object[0]);
  }
  
  protected void H()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("ae_editor_bottom_tab_show_hide");
    localIntent.putExtra("is_show", true);
    a().sendBroadcast(localIntent);
    this.jdField_a_of_type_Bmas.a(131077, new Object[0]);
  }
  
  protected void I()
  {
    this.jdField_a_of_type_Blkr = ((blkr)blks.a(this).get(blkr.class));
    this.jdField_a_of_type_Bmap = ((bmap)blks.a(this).get(bmap.class));
    this.jdField_a_of_type_Bmap.a.observe(this, new blkb(this));
    this.jdField_a_of_type_Bmaq = ((bmaq)blks.a(this).get(bmaq.class));
    this.jdField_a_of_type_Bmaq.d().observe(this, new blkc(this));
  }
  
  public void J()
  {
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null)
    {
      if (apju.d()) {
        this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      }
    }
    else
    {
      if (!GLVideoClipUtil.b()) {
        break label118;
      }
      if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null) {
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      }
    }
    for (;;)
    {
      f(true);
      bmbg.a().h();
      bmbc.a().ab();
      if ((!this.jdField_a_of_type_Bmap.c()) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null)) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setVisibility(0);
      }
      blix.a(true, a());
      this.jdField_a_of_type_Bmaq.a().postValue(Boolean.valueOf(true));
      return;
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(4);
      break;
      label118:
      if ((this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null) && (this.l))
      {
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
        this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setSelected(false);
      }
    }
  }
  
  public void K()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.22(this));
    }
  }
  
  public void L()
  {
    this.jdField_a_of_type_Bnbp.a().onBackPressed();
  }
  
  public void M()
  {
    a().getIntent().removeExtra("widgetinfo");
    bmbz.a(a());
  }
  
  protected void N()
  {
    blix.a(false, a());
    this.jdField_a_of_type_Bmaq.a().postValue(Boolean.valueOf(false));
  }
  
  public void O()
  {
    if (this.jdField_a_of_type_Blsw != null) {
      this.jdField_a_of_type_Blsw.c();
    }
    if (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton != null) {
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    }
    blix.a(false, a());
    this.jdField_a_of_type_Bmaq.a().postValue(Boolean.valueOf(false));
  }
  
  protected void P()
  {
    this.jdField_a_of_type_Baas = new baas();
    this.jdField_a_of_type_Baas.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel);
    this.jdField_a_of_type_Baas.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Baas.a(new blki(this));
    this.jdField_a_of_type_Baay = new baay(this.jdField_a_of_type_Baaz);
    this.jdField_a_of_type_Baaw = new baaw(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView);
    this.jdField_a_of_type_Baaq = new baaq(a(), this.jdField_a_of_type_Baar);
    this.jdField_a_of_type_Baau = new baau(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getContext(), this.jdField_a_of_type_Baav);
  }
  
  @MainThread
  public void Q()
  {
    bmbx.b(this.jdField_a_of_type_JavaLangString, "setCaptureModeViewModel---");
    bmap localbmap = (bmap)blks.a(this).get(bmap.class);
    localbmap.a.setValue(new bmah(null, this.jdField_a_of_type_Blit.a(), 1));
    localbmap.b.setValue(this.jdField_a_of_type_Blit.a());
  }
  
  public void R()
  {
    this.jdField_a_of_type_Blnv.a();
  }
  
  public void S()
  {
    LiuHaiUtils.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, ViewUtils.dip2px(1.0F));
    T();
  }
  
  protected void T()
  {
    Object localObject = a();
    if (ScreenUtil.getRealHeight((Context)localObject) / ScreenUtil.getRealWidth((Context)localObject) >= 2.0F)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (!blvr.h(this.jdField_a_of_type_Blit.i())) {
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
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(new blkl(this));
      }
    }
  }
  
  protected int a()
  {
    if (k()) {
      return 2131558516;
    }
    return 2131558515;
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
    this.jdField_a_of_type_Blnv = a();
    this.jdField_a_of_type_Bmas = new bmas(this.jdField_a_of_type_Bnbp.a(), this.jdField_a_of_type_AndroidViewView, this);
    ((AEVideoStoryTopBarViewModel)blks.a(this).get(AEVideoStoryTopBarViewModel.class)).a.setValue(this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
    S();
    w();
    I();
    P();
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setMaterialPanelListener(this.jdField_a_of_type_Blsm);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(a(), new blkq(this), null, true);
    this.jdField_a_of_type_Blsw = new blsw(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Bmas);
    this.jdField_a_of_type_Bloc = new bloc((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377884));
    this.jdField_a_of_type_Blkr.b.postValue(this.jdField_a_of_type_Bloc);
    Object localObject = this.jdField_a_of_type_Bloc;
    if (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL)
    {
      bool = true;
      ((bloc)localObject).a(bool);
      this.jdField_a_of_type_Blst = new blst((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377876));
      this.jdField_a_of_type_Blkr.a.setValue(this.jdField_a_of_type_Blst);
      CosFunHelper.setCountDownListener(new blkp(this));
      this.jdField_a_of_type_Blst.a(this.jdField_a_of_type_Baas);
      this.jdField_a_of_type_Baax = this.jdField_a_of_type_Bloc.a();
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0)) {
        break label484;
      }
    }
    label484:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 1, "onCreateView needLiuHaiTop:" + bool);
        }
        localObject = a().getIntent().getStringExtra("key_guide_image");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = awfl.a(((String)localObject).substring("data:image/png;base64,".length()));
          localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
          if (BitmapUtils.isLegal((Bitmap)localObject))
          {
            ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363597);
            localImageView.setImageBitmap((Bitmap)localObject);
            localImageView.setVisibility(0);
          }
        }
        bmbx.b(this.jdField_a_of_type_JavaLangString, "[UnitAsyncInit] before await");
        try
        {
          this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
          bmbx.b(this.jdField_a_of_type_JavaLangString, "[UnitAsyncInit] after await");
          return localView;
          bool = false;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            bmbx.d(this.jdField_a_of_type_JavaLangString, "[UnitAsyncInit] await interrupt exp: " + localInterruptedException.getMessage());
          }
        }
      }
    }
  }
  
  protected babg a()
  {
    return this;
  }
  
  protected blno a()
  {
    int n = 1;
    Intent localIntent = a().getIntent();
    if (blvr.i(localIntent)) {
      if ((localIntent.getBooleanExtra("key_camera_prefer_id", false)) || (!apju.d())) {
        n = 2;
      }
    }
    label103:
    while (bbwy.l())
    {
      return bnxr.a().a(this.jdField_a_of_type_Bnbp.a(), n);
      if (this.jdField_a_of_type_Blit.g() == 0) {}
      for (int m = babb.a();; m = this.jdField_a_of_type_Blit.g())
      {
        if ((this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) && (apju.d())) {
          break label103;
        }
        n = m;
        break;
      }
    }
    return bnxr.a().a(this.jdField_a_of_type_Blit);
  }
  
  public blnv a()
  {
    if (this.jdField_a_of_type_Blnv == null) {
      this.jdField_a_of_type_Blnv = new blnv(this.jdField_a_of_type_AndroidViewView, this);
    }
    return this.jdField_a_of_type_Blnv;
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
      bmbx.b(this.jdField_a_of_type_JavaLangString, "initCaptureModesAndFirstMode---initialMode=" + localAECaptureMode + ", initialCModes=" + Arrays.toString(this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode));
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
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.10(this));
    this.jdField_a_of_type_Blnv.e();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onActivityResult:requestCode=" + paramInt1 + " resultCode=" + paramInt2 + " data=" + paramIntent + " publishStoryFlag=" + jdField_e_of_type_Boolean);
    }
    Activity localActivity = this.jdField_a_of_type_Bnbp.a();
    babk.a(localActivity, paramInt1, paramInt2);
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
          paramIntent.putExtra("uin", this.jdField_a_of_type_Blit.a().jdField_a_of_type_JavaLangString);
          paramIntent.putExtra("uintype", this.jdField_a_of_type_Blit.a().jdField_a_of_type_Int);
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
        localObject2 = (bmtm)bmql.a().c(8);
        if (localObject2 != null) {
          ((bmtm)localObject2).c();
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
      bmbx.a(this.jdField_a_of_type_JavaLangString, String.format("onActivityResult, requestCode=%d, resultCode=%d, data=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent }));
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
    if ((paramIntent == null) && (paramInt2 == 0) && (jdField_e_of_type_Boolean))
    {
      jdField_e_of_type_Boolean = false;
      return;
    }
    if ((paramInt2 == -1) && ((paramInt1 == 10006) || (paramInt1 == 1012))) {
      this.jdField_a_of_type_Blnv.i();
    }
    if (paramInt2 == 0) {
      blik.a(null);
    }
    if ((paramIntent != null) && (this.jdField_a_of_type_Blit.a() != null)) {
      paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_Blit.a().a());
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
      blil.a(this.jdField_a_of_type_Bnbp.a(), paramIntent, this.jdField_a_of_type_Bnbo, null);
      return;
    }
    this.jdField_a_of_type_Bmas.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void a(long paramLong)
  {
    boolean bool2 = false;
    Intent localIntent = new Intent(a(), AEStoryGIFPreviewActivity.class);
    localIntent.putExtra("KEY_PREVIEW_SOURCE_PATH", this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath);
    localIntent.putExtra("KEY_AVAILABLE_EMO_COUNT", paramLong);
    Object localObject = (blwr)blks.a(this).get(blwr.class);
    blvd localblvd = (blvd)((blwr)localObject).b().getValue();
    if (localblvd != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localIntent.putExtra("KEY_MATERIAL_APPLIED", bool1);
      if (localblvd != null) {
        localIntent.putExtra("ARG_GIF_MATERIAL_ID", localblvd.jdField_a_of_type_JavaLangString);
      }
      localIntent.putExtra("KEY_AVAILABLE_SAVENAME", (String)((blwr)localObject).c().getValue());
      localIntent.putExtra("ARG_SESSION_INFO", this.jdField_a_of_type_Blit.a());
      localObject = a().getIntent();
      if (!blvr.f((Intent)localObject))
      {
        bool1 = bool2;
        if (!blvr.g((Intent)localObject)) {}
      }
      else
      {
        bool1 = true;
      }
      localIntent.putExtra("ARG_GIF_SEND_TO_AIO", bool1);
      localObject = a();
      if (localObject != null)
      {
        localIntent.putExtra("AECAMERA_MODE", this.jdField_a_of_type_Blit.j());
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", this.jdField_a_of_type_Blit.i());
        ((Activity)localObject).startActivityForResult(localIntent, 101);
      }
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    bmbx.a(this.jdField_a_of_type_JavaLangString, "[AE Profiler] AEPituCameraUnit onCreate");
    long l1 = a().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    bmbg.a().c(l1);
    super.a(paramBundle);
    com.tencent.sveffects.SvEffectSdkInitor.isDovCapture = true;
    jdField_e_of_type_Boolean = false;
    bnub.a().b(false);
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
        E();
        return;
      }
      bmbx.b(this.jdField_a_of_type_JavaLangString, "【GIF Capture】during time:" + (paramAEVideoCaptureResult.finishTimeMs - paramAEVideoCaptureResult.startTimeMs) + "ms");
      bmbg.a().b(5L);
      bmbc.a().ah();
      long l1 = b();
      if (l1 > 0L)
      {
        a(l1);
        return;
      }
      paramAEVideoCaptureResult = BaseApplicationImpl.getContext();
    } while (paramAEVideoCaptureResult == null);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.31(this, paramAEVideoCaptureResult));
  }
  
  public void a(@NonNull List<blrj> paramList, @NonNull List<blri> paramList1)
  {
    this.jdField_a_of_type_Bmas.a(720897, new Object[] { paramList, paramList1 });
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.16(this));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Blnv == null) {
      return false;
    }
    if (this.jdField_a_of_type_Blnv.a()) {
      return false;
    }
    if ((this.jdField_a_of_type_Bmas.a(589824)) && (((Boolean)this.jdField_a_of_type_Bmas.a(589826, new Object[0])).booleanValue()))
    {
      this.jdField_a_of_type_Bmas.a(589826, new Object[0]);
      return true;
    }
    this.jdField_a_of_type_Blnv.g();
    this.jdField_a_of_type_Blnv.i();
    Intent localIntent;
    String str1;
    String str2;
    if (k())
    {
      localIntent = a().getIntent();
      str1 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      if (str1 != null) {
        break label164;
      }
      QQToast.a(a(), "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Bnbp.a();
      bmbc.a().G();
      bmbx.b(this.jdField_a_of_type_JavaLangString, "【Click】onBackPressed");
      return true;
      label164:
      localIntent.setClassName(str2, str1);
      localIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      localIntent.removeExtra("PhotoConst.SINGLE_PHOTO_PATH");
      localIntent.addFlags(603979776);
      if (!localIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
      {
        a().startActivity(localIntent);
      }
      else
      {
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
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramInt == 4) {
      a();
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
      bmbx.b(this.jdField_a_of_type_JavaLangString, "initCaptureModesAndFirstMode---initialMode=" + this.jdField_a_of_type_DovComQqImAeModeAECaptureMode + ", initialCModes=" + Arrays.toString(arrayOfAECaptureMode));
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
  
  protected int b()
  {
    int m;
    if (k())
    {
      m = bmbw.a();
      if (m == 1)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
        ((AEVideoStoryTopBarViewModel)blks.a(this).get(AEVideoStoryTopBarViewModel.class)).a.setValue(this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio.code;
      if (m == 2)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.R_4_3;
        break;
      }
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.FULL;
      break;
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = AEVideoStoryTopBarViewModel.Ratio.FULL;
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAECaptureController(a());
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAeGLSurfaceListener(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView$AEGLSurfaceListener);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setFaceEffectListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setStickerInnerLutFilterListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setRecommendTextCallback(new blkj(this));
    if (bbwy.l())
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(true);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setDynamicResolutionMode(true);
    }
    for (;;)
    {
      if (blrg.a()) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.debugInfoCallback = this;
      }
      if (k()) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setAeEditMaterialSelectedListener(new blkk(this));
      }
      return;
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setDynamicResolutionMode(false);
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setDynamicResolutionMode(false);
    }
  }
  
  public void b(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366870);
    if ((localView instanceof VideoFilterViewPager))
    {
      ((VideoFilterViewPager)localView).setVisibility(paramInt);
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "yes to domVideoFilterViewPager setVisibility: " + paramInt);
    }
  }
  
  public void b(String paramString)
  {
    bluy localbluy = (bluy)bmql.a().c(18);
    if ((localbluy != null) && (!TextUtils.isEmpty(paramString)))
    {
      localbluy.a(false);
      paramString = localbluy.a(paramString, k());
      if (paramString == null) {
        Toast.makeText(a(), 2131689674, 1).show();
      }
    }
    else
    {
      return;
    }
    blix.a(false, a());
    a().a(true, 150);
    this.jdField_a_of_type_Bmas.a(327683, new Object[] { paramString });
    this.jdField_a_of_type_Bmas.a(196612, new Object[0]);
  }
  
  public void b(boolean paramBoolean) {}
  
  protected boolean b()
  {
    if (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) {}
    while (blvr.i(a().getIntent())) {
      return false;
    }
    return true;
  }
  
  protected void c()
  {
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.27(this));
  }
  
  public void c(int paramInt)
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
  
  public void d()
  {
    bmbx.b(this.jdField_a_of_type_JavaLangString, "onActivityPause");
    super.d();
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Baas);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Baax);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Baay);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Baaw);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Baaq);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Baau);
    this.jdField_a_of_type_Bloc.b();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.l();
    }
    this.jdField_a_of_type_Blnv.g();
    this.jdField_a_of_type_Bmas.c();
    bluy.b = false;
    if (QLog.isDevelopLevel()) {
      bmbx.a(this.jdField_a_of_type_JavaLangString, "onActivityPause, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    int i1 = 1;
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Bnbp.a();
    int m;
    int n;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      m = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label193;
      }
      n = 1;
      label48:
      if (PermissionUtils.isStorePermissionEnable((Context)localObject)) {
        break label198;
      }
    }
    for (;;)
    {
      localObject = new LinkedList();
      if (m != 0)
      {
        ((List)localObject).add("android.permission.CAMERA");
        bmbx.b(this.jdField_a_of_type_JavaLangString, "【Camera Permission】denied");
      }
      if (n != 0)
      {
        ((List)localObject).add("android.permission.RECORD_AUDIO");
        bmbx.b(this.jdField_a_of_type_JavaLangString, "【Audio Permission】denied");
      }
      if (i1 != 0)
      {
        ((List)localObject).add("android.permission.READ_EXTERNAL_STORAGE");
        ((List)localObject).add("android.permission.WRITE_EXTERNAL_STORAGE");
        bmbx.b(this.jdField_a_of_type_JavaLangString, "【External Storage Permission】denied");
      }
      localObject = bfur.a((String[])((List)localObject).toArray(new String[0]));
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.28(this, (String)localObject));
      return;
      m = 0;
      break;
      label193:
      n = 0;
      break label48;
      label198:
      i1 = 0;
    }
  }
  
  public void e()
  {
    super.e();
    if (blrg.a()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.debugInfoCallback = null;
    }
    this.jdField_a_of_type_Bmas.f();
    this.jdField_a_of_type_Bloc.c();
    boda.a.clear();
    this.jdField_a_of_type_Bmbp.b();
    bmbg.a().k();
    bmbg.a().a(false);
    bmay.b();
    if ((a() != null) && (blvr.i(a().getIntent()))) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setSelectedCamera(babb.a());
    }
    ((bluy)bmql.a(18)).a();
    if (this.jdField_a_of_type_Blnv != null) {
      this.jdField_a_of_type_Blnv.d();
    }
  }
  
  protected boolean e()
  {
    return k();
  }
  
  public void f()
  {
    bmbx.b(this.jdField_a_of_type_JavaLangString, "onActivityResume");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onResume();
    if (jdField_e_of_type_Boolean) {
      bmbx.d(this.jdField_a_of_type_JavaLangString, "onActivityResume---publishStoryFlag is true, activity will finish soon, fast return");
    }
    do
    {
      return;
      super.f();
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.refreshDarkModeTimer();
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.onResume();
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Baas);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Baax);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Baay);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Baaw);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Baaq);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Baau);
      this.jdField_a_of_type_Blnv.h();
      if (this.i)
      {
        if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.k();
        }
        J();
        a(false);
      }
      this.jdField_a_of_type_Bmas.b();
      C();
      f(false);
      bluy.b = true;
    } while (!QLog.isDevelopLevel());
    bmbx.a(this.jdField_a_of_type_JavaLangString, "onActivityResume, ID=" + this.jdField_c_of_type_Int);
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bmas.a(327687, new Object[0]);
      return;
    }
    this.jdField_a_of_type_Bmas.a(327688, new Object[0]);
  }
  
  protected boolean f()
  {
    return blvr.k(this.jdField_a_of_type_Blit.i());
  }
  
  public void g()
  {
    N();
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setVisibility(8);
    }
    this.jdField_a_of_type_Bmas.a(196609, new Object[0]);
    this.jdField_a_of_type_Bmas.a(262147, new Object[0]);
  }
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onResourceDownload isOnlineRes: " + paramBoolean);
    }
    if (!f)
    {
      f = true;
      this.jdField_a_of_type_Bnbp.a().runOnUiThread(new AEPituCameraUnit.25(this));
      return;
    }
    this.jdField_a_of_type_Bnbp.a().runOnUiThread(new AEPituCameraUnit.26(this));
  }
  
  public boolean g()
  {
    return true;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    bmbx.b(this.jdField_a_of_type_JavaLangString, "【Camera / Audio / Storage Permission】grant");
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Boolean) {
      m();
    }
  }
  
  protected boolean h()
  {
    return (this.jdField_a_of_type_Blit != null) && (this.jdField_a_of_type_Blit.f() != -1);
  }
  
  protected void i()
  {
    super.i();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366946);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131373087));
  }
  
  protected boolean i()
  {
    return (this.jdField_a_of_type_Blit.c() == 101) && (this.jdField_a_of_type_Blit.c()) && (this.jdField_a_of_type_Blit.a()) && (this.jdField_a_of_type_Blit.f());
  }
  
  protected boolean j()
  {
    return (this.jdField_a_of_type_Blit.c() == 101) && (this.jdField_a_of_type_Blit.e());
  }
  
  public boolean k()
  {
    return blvr.j(a().getIntent());
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
    //   5: getfield 112	bljy:jdField_e_of_type_Int	I
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
    //   0	28	0	this	bljy
    //   8	4	1	m	int
    //   1	19	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	23	finally
  }
  
  public void n()
  {
    super.n();
  }
  
  public void notifyEnableStickerInnerEffectFilter(boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject;
    boolean bool1;
    if (paramBoolean)
    {
      c(1);
      if (this.jdField_a_of_type_Bmas != null) {
        this.jdField_a_of_type_Bmas.a(196609, new Object[0]);
      }
      localObject = AEFilterManagerHolder.getAEFilterManager();
      if (localObject != null)
      {
        if (paramBoolean) {
          break label97;
        }
        bool1 = true;
        label48:
        ((blnq)localObject).jdField_a_of_type_Boolean = bool1;
        if (paramBoolean) {
          ((blnq)localObject).f();
        }
      }
      if (this.jdField_a_of_type_Blnv != null)
      {
        localObject = this.jdField_a_of_type_Blnv;
        if (paramBoolean) {
          break label102;
        }
      }
    }
    label97:
    label102:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((blnv)localObject).jdField_a_of_type_Boolean = paramBoolean;
      return;
      c(0);
      break;
      bool1 = false;
      break label48;
    }
  }
  
  public void o()
  {
    bmbx.b(this.jdField_a_of_type_JavaLangString, "onActivityStart");
    super.o();
    this.jdField_a_of_type_Bmas.d();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    bmbc.a().F();
    if (QLog.isDevelopLevel()) {
      bmbx.a(this.jdField_a_of_type_JavaLangString, "onActivityStart, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  public void onAEKitInited()
  {
    super.onAEKitInited();
    int m = AEBeautyProviderView.a();
    int n = AEBeautyProviderView.b();
    this.jdField_a_of_type_Blnv.a(m);
    this.jdField_a_of_type_Blnv.b(n);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEPituCameraUnit.8(this));
  }
  
  public void onCaptureError(int paramInt)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Bmaq.d().postValue(Boolean.valueOf(false));
    bmbx.a(this.jdField_a_of_type_JavaLangString, "onCaptureError. errorCode = " + paramInt, new Throwable());
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.34(this, paramInt));
  }
  
  public void onClick(View paramView)
  {
    int m = 1;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_b_of_type_DovComQqImAeViewAECompoundButton != null)
      {
        bmys.a(this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.a(), 200L, null);
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
          this.l = true;
          label127:
          babk.a(bool);
          if (!bool) {
            break label155;
          }
        }
        for (;;)
        {
          babc.a(m);
          break;
          bool = false;
          break label105;
          label147:
          this.l = false;
          break label127;
          label155:
          m = 2;
        }
        D();
        continue;
        bmys.a(paramView, 200L, null);
        L();
        continue;
        a().getIntent().removeExtra("widgetinfo");
      }
    }
  }
  
  public void onDetectStateChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Blsw != null) {
      this.jdField_a_of_type_Blsw.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Bmaq.d().postValue(Boolean.valueOf(false));
    if (!paramBoolean)
    {
      onCaptureError(101);
      return;
    }
    bmbx.b(this.jdField_a_of_type_JavaLangString, "[onVideoCaptured] videoInfo = " + paramLocalMediaInfo.mDuration);
    bmbg.a().b(2L);
    bmbc.a().d(paramLocalMediaInfo.mDuration);
    b(false);
    this.jdField_a_of_type_Bmas.a(196609, new Object[0]);
    this.jdField_a_of_type_Bmas.a(262146, new Object[] { this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult, paramLocalMediaInfo, Integer.valueOf(this.jdField_d_of_type_Int), this.jdField_a_of_type_Bnbh, this.jdField_a_of_type_Bmas.a(196610, new Object[0]) });
  }
  
  public void onPhotoCaptured(blnp paramblnp)
  {
    bmbg.a().b(1L);
    bmbc.a().d(-1L);
    bmbx.b(this.jdField_a_of_type_JavaLangString, "【Type】Photo");
    if (h()) {
      a(paramblnp);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.13(this));
      return;
      b(paramblnp);
    }
  }
  
  public void onSelectFaceEffect(VideoMaterial paramVideoMaterial)
  {
    K();
    if (!m())
    {
      if (paramVideoMaterial == null) {
        bmbg.a().c("none");
      }
    }
    else
    {
      if (VideoMaterialUtil.isWatermarkMaterial(paramVideoMaterial)) {
        blts.a().a();
      }
      if ((!VideoMaterialUtil.isWatermarkEditable(paramVideoMaterial)) || (m())) {
        break label118;
      }
      a().runOnUiThread(new AEPituCameraUnit.23(this, paramVideoMaterial));
      label67:
      if (this.jdField_a_of_type_Blsw != null) {
        this.jdField_a_of_type_Blsw.a(paramVideoMaterial);
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
      bmbg.a().c(paramVideoMaterial.getId());
      break;
      a().runOnUiThread(new AEPituCameraUnit.24(this, paramVideoMaterial));
      break label67;
    }
    label137:
    a(1);
  }
  
  public void onSetFilterProcess(blnq paramblnq)
  {
    if ((paramblnq != null) && (this.jdField_a_of_type_Blsw != null)) {
      paramblnq.a(this.jdField_a_of_type_Blsw.a());
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
    O();
    b(8);
    ThreadManager.getUIHandler().post(new AEPituCameraUnit.11(this));
    this.jdField_a_of_type_Bmas.a(196609, new Object[0]);
    this.jdField_a_of_type_Bmas.a(262145, new Object[0]);
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
      ThreadManager.getUIHandler().post(new AEPituCameraUnit.12(this));
      return;
      int m = 500;
      if (this.jdField_d_of_type_Int == 13) {
        m = 2000;
      }
      if (boaj.a(paramAEVideoCaptureResult.videoMp4FilePath) < m)
      {
        this.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_Bmaq.d().postValue(Boolean.valueOf(true));
        E();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = paramAEVideoCaptureResult.videoMp4FilePath;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
      MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    }
  }
  
  public void p()
  {
    bmbx.b(this.jdField_a_of_type_JavaLangString, "onActivityStop");
    super.p();
    this.jdField_a_of_type_Bmas.e();
    bmbc.a().c(this.jdField_b_of_type_Long);
    if (QLog.isDevelopLevel()) {
      bmbx.a(this.jdField_a_of_type_JavaLangString, "onActivityStop, ID=" + this.jdField_c_of_type_Int);
    }
  }
  
  protected void v()
  {
    ThreadManager.excute(new AEPituCameraUnit.7(this), 16, null, true);
  }
  
  @NotNull
  protected void w()
  {
    if (!this.jdField_b_of_type_DovComQqImAeModeAECaptureMode.shouldStartCamera())
    {
      Q();
      if (k())
      {
        ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131377878);
        if (localViewStub != null)
        {
          localViewStub.inflate();
          bmbx.b(this.jdField_a_of_type_JavaLangString, "AEPartAction--inflate bottom");
        }
      }
      this.jdField_a_of_type_Bmas.a();
    }
  }
  
  public void x()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "onCaptureButtonVideoStop: thread = " + Thread.currentThread().getName());
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.stopCaptureVideo();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.stopRecordVideo();
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Bmaq.d().postValue(Boolean.valueOf(false));
    ((bmrr)bmql.a(5)).a(false);
    b(0);
  }
  
  public void y()
  {
    O();
  }
  
  public void z()
  {
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Bmaq.d().postValue(Boolean.valueOf(true));
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.resetMaterial();
    if ((this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFlashEnabled()) && (this.jdField_b_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF)) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.turnFlash(a(), true);
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.startCaptureVideo();
    if (!this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.isFrontCamera()) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraManager.setFocusModeRecording();
    }
    ((bmrr)bmql.a(5)).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljy
 * JD-Core Version:    0.7.0.1
 */