import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.QIMCameraBroadcastReceiver;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.QIMCameraCaptureUnit.1;
import dov.com.qq.im.QIMCameraCaptureUnit.10;
import dov.com.qq.im.QIMCameraCaptureUnit.11;
import dov.com.qq.im.QIMCameraCaptureUnit.13;
import dov.com.qq.im.QIMCameraCaptureUnit.14;
import dov.com.qq.im.QIMCameraCaptureUnit.2;
import dov.com.qq.im.QIMCameraCaptureUnit.4;
import dov.com.qq.im.QIMCameraCaptureUnit.5;
import dov.com.qq.im.QIMCameraCaptureUnit.6;
import dov.com.qq.im.QIMCameraCaptureUnit.7;
import dov.com.qq.im.QIMCameraCaptureUnit.8;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

public class bocn
  extends bocu
  implements View.OnClickListener, View.OnTouchListener, bbgk, bbhl, bbhm, bqaj, brfc, MediaScanner.OnMediaInfoScannerListener
{
  protected int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new QIMCameraBroadcastReceiver(this);
  public Bitmap a;
  public View a;
  protected ViewGroup a;
  protected Button a;
  protected FrameLayout a;
  public ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected bbft a;
  protected bbfw a;
  protected bbfz a;
  private bhpc jdField_a_of_type_Bhpc;
  bocw jdField_a_of_type_Bocw;
  protected bqaa a;
  public bqah a;
  public bqai a;
  protected CameraFocusView a;
  protected LocalMediaInfo a;
  public CameraCaptureView.VideoCaptureResult a;
  public CameraCaptureView a;
  public CaptureModeController a;
  public QIMCameraCaptureButtonLayout a;
  public QIMCameraSegmentCaptureButtonLayout a;
  public String a;
  public List<LocalMediaInfo> a;
  protected AtomicBoolean a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  protected long b;
  public View b;
  protected Button b;
  protected ImageView b;
  public RelativeLayout b;
  private LocalMediaInfo jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  protected CameraCaptureView.VideoCaptureResult b;
  protected QIMCameraCaptureButtonLayout b;
  public String b;
  List<CameraCaptureView.VideoCaptureResult> jdField_b_of_type_JavaUtilList = new ArrayList();
  protected boolean b;
  protected long c;
  protected View c;
  public Button c;
  protected boolean c;
  public boolean d;
  protected boolean e;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  protected boolean j;
  public boolean k = true;
  public boolean l;
  public boolean m;
  public boolean n;
  private boolean o;
  private boolean p;
  
  public bocn(bqai parambqai, bqah parambqah)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Long = 3L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_JavaLangString = anzj.a(2131708645);
    this.jdField_a_of_type_Bqaa = new bqaa(10000, 100, 2);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bqai = parambqai;
    this.jdField_a_of_type_Bqah = parambqah;
  }
  
  private boolean e()
  {
    return this.jdField_b_of_type_Int != 5;
  }
  
  public void A()
  {
    if (!d()) {}
    do
    {
      do
      {
        return;
      } while (!c());
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
      this.jdField_b_of_type_JavaUtilList.remove(this.jdField_b_of_type_JavaUtilList.size() - 1);
      this.o = true;
      if (QLog.isColorLevel()) {
        QLog.d("QIMCameraCaptureUnit", 2, "[segmentCapture] onSegmentCaptureDelete, mediaInfos size = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.u();
      if ((this.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) {
        B();
      }
    } while ((this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null) || (this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mTransferPosList == null) || (this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mTransferPosList.size() <= 0));
    this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mTransferPosList.remove(this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mTransferPosList.size() - 1);
  }
  
  protected void B()
  {
    e(false);
  }
  
  public void C()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void C_()
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (!(this.jdField_a_of_type_Bqai.a() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Bqai.a();
    int i1;
    if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i1 = 1;
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label93;
      }
    }
    label93:
    for (int i2 = 1;; i2 = 0)
    {
      if ((i1 == 0) || (i2 == 0)) {
        break label98;
      }
      localQIMCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
      i1 = 0;
      break;
    }
    label98:
    if (i1 != 0)
    {
      localQIMCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
      return;
    }
    localQIMCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  public void D()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureUnit", 2, "onCaptureButtonTouchedWhenDisable");
    }
  }
  
  public void E()
  {
    h();
  }
  
  public void F()
  {
    g();
    L();
    QQToast.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString, 0).a();
  }
  
  public void G() {}
  
  public void H()
  {
    this.j = true;
    h();
    C();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
  }
  
  public void I() {}
  
  public void J()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, "[segmentCapture] onSegmentCaptureError, mediaInfos size = " + this.jdField_a_of_type_JavaUtilList.size());
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.u();
    K();
  }
  
  public void K()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, "[segmentCapture] onSegmentError");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.j = false;
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void L() {}
  
  public void M() {}
  
  public void N() {}
  
  protected void O()
  {
    bpoz localbpoz = (bpoz)bplq.a().c(8);
    if ((localbpoz != null) && (localbpoz.a()))
    {
      this.p = true;
      localbpoz.d();
    }
  }
  
  protected void P()
  {
    if (this.p)
    {
      this.p = false;
      bpoz localbpoz = (bpoz)bplq.a().c(8);
      if (localbpoz != null) {
        localbpoz.c();
      }
    }
  }
  
  public void Q() {}
  
  public void R() {}
  
  public void S() {}
  
  public void T()
  {
    this.d = LiuHaiUtils.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout, bhtq.a(1.0F));
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.d, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  protected int a()
  {
    return 2131560967;
  }
  
  public Activity a()
  {
    if (this.jdField_a_of_type_Bqai == null) {
      return null;
    }
    return this.jdField_a_of_type_Bqai.a();
  }
  
  public IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    return localIntentFilter;
  }
  
  public View a()
  {
    bqyo.a("onCreateView");
    Object localObject = new RelativeLayout(this.jdField_a_of_type_Bqai.a());
    ((RelativeLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Bqai.a().getLayoutInflater().inflate(a(), (ViewGroup)localObject, false).findViewById(2131366922);
    bqyo.a("onCreateView1");
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364134));
    a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureParam(a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCameraPermissionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setUseVideoOrientation(false);
    if (bddz.n()) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDynamicResolutionMode(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366923));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363547));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363545));
      this.d = LiuHaiUtils.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout, bhtq.a(1.0F));
      if (QLog.isColorLevel()) {
        QLog.i("QIMCameraCaptureUnit", 1, "initLiuHaiScreenUI_Common mEnableLHLayout:" + this.d);
      }
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364342));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131717468));
      if (!aqql.d())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366787));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131365266));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton.setSelected(false);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364153));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364158));
      u();
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374175);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364144));
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Bqai.a().getIntent().getBooleanExtra("enable_local_video", false);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370343));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130849208);
      int i1 = agej.a(36.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      ((Drawable)localObject).setBounds(0, 0, i1, i1);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_Bbfz = new bbfz(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
      this.jdField_a_of_type_Bbft = a();
      this.jdField_a_of_type_Bbfw = new bbfw(this.jdField_a_of_type_Bqai.a());
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366891);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364191));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController = new CaptureModeController(this);
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a();
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.d);
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_AndroidViewViewGroup;
      return this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDynamicResolutionMode(false);
    }
  }
  
  protected bbft a()
  {
    return new bbft(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView);
  }
  
  protected bbhn a()
  {
    if (bddz.n()) {
      return brdw.a().a(this.jdField_a_of_type_Bqai.a());
    }
    return brdw.a().b(this.jdField_a_of_type_Bqai.a());
  }
  
  public CameraCaptureView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a();
    }
    return null;
  }
  
  public ArrayList<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(0));
    return localArrayList;
  }
  
  protected List<View> a()
  {
    return null;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Long != -1L) {
      QLog.d("QIMCameraCaptureUnit", 1, "(NEW)LaunchActivity to FirstFrameShown cost : " + (System.currentTimeMillis() - this.jdField_b_of_type_Long) + "ms");
    }
  }
  
  public void a(int paramInt)
  {
    this.f = false;
    QLog.e("QIMCameraCaptureUnit", 2, "onCaptureError. errorCode = " + paramInt);
    ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.7(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(int paramInt, bpny parambpny) {}
  
  public void a(Intent paramIntent) {}
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Bqai.a().getIntent().getLongExtra("ACTIVITY_START_TIME", -1L);
    if (paramBundle != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = ((CameraCaptureView.VideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
    }
    this.jdField_a_of_type_Bqai.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, a());
    bbgr.a();
  }
  
  public void a(bbhq parambbhq) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, new Object[] { "handleSegmentVideoResult, ", Boolean.valueOf(paramBoolean) });
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramLocalMediaInfo);
      this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
      if (QLog.isColorLevel()) {
        QLog.d("QIMCameraCaptureUnit", 2, "[segmentCapture] onMediaInfoChanged, mediaInfos size = " + this.jdField_a_of_type_JavaUtilList.size());
      }
    }
    this.o = true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    boolean bool = this.j;
    ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.8(this, paramBoolean, paramLocalMediaInfo, bool));
    if ((this.j) && (this.k))
    {
      a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList);
      this.g = true;
      this.j = false;
    }
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = paramVideoCaptureResult;
    if (this.l)
    {
      this.l = false;
      this.f = false;
      ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.4(this));
      return;
    }
    int i1;
    if ((this.h) && (bbgr.a < 500L))
    {
      i1 = 1;
      if ((paramVideoCaptureResult.videoFrameCount >= this.jdField_c_of_type_Long) && (i1 == 0)) {
        break label191;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMCameraCaptureUnit", 2, "onVideoCaptured. videoFrameCount = " + paramVideoCaptureResult.videoFrameCount + " ; minFrameCount = " + this.jdField_c_of_type_Long);
      }
      if ((!this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.a()) || (!this.h)) {
        break label168;
      }
      a(null, false);
    }
    for (;;)
    {
      yup.a("clk_shoot", yup.b(bbgf.jdField_a_of_type_Int), 2, new String[0]);
      return;
      i1 = 0;
      break;
      label168:
      this.f = false;
      ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.5(this));
    }
    label191:
    i();
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo) {}
  
  protected void a(CameraCaptureView paramCameraCaptureView)
  {
    if (paramCameraCaptureView != null) {
      paramCameraCaptureView.d(false);
    }
  }
  
  protected void a(List<CameraCaptureView.VideoCaptureResult> paramList, List<LocalMediaInfo> paramList1)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("QIMCameraCaptureUnit", 2, "[segmentCapture] onSegmentVideoCaptured results empty");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
      this.j = true;
    } while (!QLog.isColorLevel());
    QLog.d("QIMCameraCaptureUnit", 2, "[segmentCapture] onSegmentVideoCaptured segment not finish, wait");
    return;
    if ((!this.o) || (paramList.size() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMCameraCaptureUnit", 2, "[segmentCapture] onSegmentVideoCaptured segment need not merge, directly queryMediaInfoAsync");
      }
      if ((paramList.size() == 1) && (this.o))
      {
        this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = ((CameraCaptureView.VideoCaptureResult)paramList.get(0)).videoMp4FilePath;
        this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = ((CameraCaptureView.VideoCaptureResult)paramList.get(0));
      }
      MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(new boct(this), this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      return;
    }
    ThreadManager.excute(new QIMCameraCaptureUnit.10(this, paramList), 16, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidWidgetButton == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.11(this, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.m = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramString;
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.2(this, paramString));
    }
    bbgr.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public boolean a()
  {
    if (this.i)
    {
      if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
        this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().a();
      }
      return false;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.b(false);
    }
    this.jdField_a_of_type_Bqai.a();
    return true;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public View b()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void b() {}
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
  }
  
  public void b(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.b((float)paramLocalMediaInfo.mDuration);
  }
  
  public void b_(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.14(this));
  }
  
  public int c()
  {
    return 0;
  }
  
  public void c() {}
  
  public boolean c()
  {
    return (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_b_of_type_JavaUtilList.size() > 0);
  }
  
  public int d()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.q();
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a();
  }
  
  public void d()
  {
    super.d();
    this.n = false;
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbfz);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbft);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Bbfw);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onPause();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.o();
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, new Object[] { "handleSegmentCaptureMode", Boolean.valueOf(paramBoolean) });
    }
    if (this.h != paramBoolean)
    {
      this.jdField_a_of_type_Bocw = ((bocw)bplq.a().c(13));
      this.jdField_a_of_type_Bocw.a(paramBoolean);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof AppInterface)) {
        localAppRuntime.notifyObservers(bpop.class, 7, false, null);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setSegmentMode(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.x();
      if (paramBoolean)
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.l();
        this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.setVisibility(0);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        h();
        g();
        N();
        this.h = true;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.setVisibility(8);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.l();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.h = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.i)
    {
      e(false);
      return;
    }
    h();
    g();
  }
  
  public boolean d()
  {
    if (this.h) {
      return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    }
    return true;
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Bqai.a();
    int i1;
    int i2;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i1 = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label89;
      }
      i2 = 1;
      label41:
      if ((i1 == 0) || (i2 == 0)) {
        break label94;
      }
      localObject = bhlq.a(new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.13(this, (String)localObject));
      return;
      i1 = 0;
      break;
      label89:
      i2 = 0;
      break label41;
      label94:
      if (i1 != 0) {
        localObject = bhlq.a(new String[] { "android.permission.CAMERA" });
      } else {
        localObject = bhlq.a(new String[] { "android.permission.RECORD_AUDIO" });
      }
    }
  }
  
  public int e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.e();
    }
    GLGestureProxy.getInstance().removeAllListener();
    this.jdField_a_of_type_Bqai.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.i != paramBoolean)
    {
      this.i = paramBoolean;
      if (!paramBoolean) {
        break label41;
      }
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setAlpha(1.0F);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(0.0F);
      }
    }
    return;
    label41:
    g();
    float f1 = zps.a(this.jdField_a_of_type_Bqai.a(), 90.0F);
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      localArrayList.add(new bpuo(this.jdField_a_of_type_AndroidWidgetFrameLayout, "translationY", 0.0F, f1, 450L, 0L));
      localArrayList.add(new bpuo(this.jdField_a_of_type_AndroidWidgetFrameLayout, "alpha", 1.0F, 0.0F, 450L, 0L));
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localArrayList.add(new bpuo(this.jdField_a_of_type_AndroidViewViewGroup, "translationY", f1, 0.0F, 450L, 0L));
      localArrayList.add(new bpuo(this.jdField_a_of_type_AndroidViewViewGroup, "alpha", 0.0F, 1.0F, 450L, 0L));
      this.jdField_a_of_type_AndroidViewViewGroup.setAlpha(0.0F);
    }
    Object localObject = a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        localArrayList.add(new bpuo(localView, "translationY", f1, 0.0F, 450L, 0L));
        localArrayList.add(new bpuo(localView, "alpha", 0.0F, 1.0F, 450L, 0L));
        localView.setAlpha(0.0F);
      }
    }
    bpul.a(localArrayList, new bocp(this));
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, "onActivityResume");
    }
    this.n = true;
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbfz);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbft);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Bbfw);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onResume();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.n();
    if (this.h) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    g();
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      w();
    }
    this.g = false;
    a(false);
    if (this.e)
    {
      this.e = false;
      a(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = null;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.f();
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.c();
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      g();
      N();
    }
  }
  
  public int g()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
      return 0;
    }
    return this.jdField_b_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight();
  }
  
  public void g()
  {
    int i1 = 8;
    if (aqql.d())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      if (!GLVideoClipUtil.b()) {
        break label88;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      label39:
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
      if (!this.h) {
        break label151;
      }
      if (!this.i) {
        break label121;
      }
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
    }
    label88:
    label121:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        break;
        if ((this.jdField_c_of_type_AndroidWidgetButton == null) || (!this.jdField_a_of_type_Boolean)) {
          break label39;
        }
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setSelected(false);
        break label39;
      } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
      localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      if (this.jdField_c_of_type_Boolean) {}
      for (;;)
      {
        localViewGroup.setVisibility(i1);
        return;
        i1 = 0;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.l();
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
    label151:
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (this.jdField_c_of_type_Boolean) {}
    for (;;)
    {
      localViewGroup.setVisibility(i1);
      return;
      i1 = 0;
    }
  }
  
  public void g(boolean paramBoolean) {}
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCameraPermissionResult(true);
  }
  
  public void h()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
  }
  
  public void h(boolean paramBoolean) {}
  
  protected void i()
  {
    if (!this.h) {
      ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.6(this));
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
    this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath;
    this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, new Object[] { "onVideoCaptured. isSegmentMode:", Boolean.valueOf(this.h), " result = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.toString() });
    }
    MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(this, this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
  }
  
  public void i(boolean paramBoolean) {}
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureUnit", 2, "onCaptureButtonVideoStart");
    }
    this.f = true;
    if (this.h) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.i();
    h();
  }
  
  public void j(boolean paramBoolean) {}
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureUnit", 2, "onCaptureButtonVideoStop");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.j();
  }
  
  public void k(boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    int i2 = 1;
    int i1 = 1;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bpvq.a(this.jdField_a_of_type_AndroidWidgetButton, 200L, null);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.q();
      if (this.jdField_a_of_type_AndroidWidgetButton != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a() != 1) {
          break label148;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131717467));
      }
      for (;;)
      {
        bbgr.f();
        yup.a("clk_switch", this.jdField_a_of_type_Bqaa.a(), 0, new String[0]);
        break;
        label148:
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131717468));
      }
      bpvq.a(this.jdField_b_of_type_AndroidWidgetButton, 200L, null);
      boolean bool;
      if (!this.jdField_b_of_type_AndroidWidgetButton.isSelected())
      {
        bool = true;
        label195:
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a(bool)) {
          this.jdField_b_of_type_AndroidWidgetButton.setSelected(bool);
        }
        bbgr.d();
        if (!bool) {
          break label261;
        }
      }
      for (;;)
      {
        bbgf.d(i1);
        yup.a("clk_flash", this.jdField_a_of_type_Bqaa.a(), 0, new String[0]);
        bozr.a().E();
        break;
        bool = false;
        break label195;
        label261:
        i1 = 2;
      }
      bpvq.a(this.jdField_c_of_type_AndroidWidgetButton, 200L, null);
      if (!this.jdField_c_of_type_AndroidWidgetButton.isSelected())
      {
        bool = true;
        label290:
        this.jdField_c_of_type_AndroidWidgetButton.setSelected(bool);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.c(bool);
        if (bool) {
          break label343;
        }
        this.jdField_a_of_type_Boolean = true;
        label318:
        bbgr.a(bool);
        if (!bool) {
          break label351;
        }
      }
      label343:
      label351:
      for (i1 = i2;; i1 = 2)
      {
        bbgf.c(i1);
        break;
        bool = false;
        break label290;
        this.jdField_a_of_type_Boolean = false;
        break label318;
      }
      bpvq.a(paramView, 200L, null);
      x();
    }
  }
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, new Object[] { "onMediaInfoChanged, suc:", Boolean.valueOf(paramBoolean), " isSegmentMode:", Boolean.valueOf(this.h) });
    }
    this.f = false;
    if (!paramBoolean)
    {
      a(101);
      return;
    }
    int i1 = i2;
    if (this.h)
    {
      i1 = i2;
      if (!bczv.a().b()) {
        i1 = 1;
      }
    }
    if (i1 == 0)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, paramLocalMediaInfo);
      this.g = true;
      return;
    }
    a(paramLocalMediaInfo, true);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    return true;
  }
  
  public void p()
  {
    super.p();
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.b();
    }
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureUnit", 2, "onCaptureButtonPhoto!");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.r();
  }
  
  public void r()
  {
    this.jdField_a_of_type_Bqah.a(2);
  }
  
  public void s() {}
  
  public void t()
  {
    super.t();
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.d();
    }
  }
  
  protected void u()
  {
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = ((QIMCameraCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364184));
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.a(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout = ((QIMCameraSegmentCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377259));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.a(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
  }
  
  public void v()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.getLayoutParams();
    localLayoutParams.bottomMargin = agej.a(-30.0F, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.getResources());
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.g();
    if (this.jdField_b_of_type_Boolean)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.bottomMargin = agej.a(50.0F, this.jdField_a_of_type_AndroidWidgetImageView.getResources());
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  protected void w()
  {
    ThreadManager.excute(new QIMCameraCaptureUnit.1(this), 64, null, true);
  }
  
  public void x()
  {
    if (this.i) {
      if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
        this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().a();
      }
    }
    for (;;)
    {
      yup.a("clk_cancel", yup.b(this.jdField_a_of_type_Bqaa.a()), 0, new String[0]);
      return;
      this.jdField_a_of_type_Bqai.a().onBackPressed();
      bbgr.e();
      bbgf.f();
    }
  }
  
  public void y()
  {
    h();
    C();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList);
    this.g = true;
  }
  
  public void z()
  {
    if (this.jdField_a_of_type_Bhpc != null) {
      return;
    }
    Activity localActivity = this.jdField_a_of_type_Bqai.a();
    String str = localActivity.getString(2131698318);
    this.jdField_a_of_type_Bhpc = bhlq.a(localActivity, 230).setMessage(str).setPositiveButton(localActivity.getString(2131693485), new bocs(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bocn
 * JD-Core Version:    0.7.0.1
 */