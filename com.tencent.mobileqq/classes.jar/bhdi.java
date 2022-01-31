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
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.qphone.base.util.QLog;
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
import dov.com.qq.im.story.SessionWrap;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
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

public class bhdi
  extends bhdp
  implements agal, View.OnClickListener, View.OnTouchListener, autx, auut, auuu, bhzd, bjfu
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
  protected auth a;
  protected autk a;
  protected autm a;
  private bafb jdField_a_of_type_Bafb;
  bhdr jdField_a_of_type_Bhdr;
  protected bhyu a;
  public bhzb a;
  public bhzc a;
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
  
  public bhdi(bhzc parambhzc, bhzb parambhzb)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Long = 3L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.jdField_a_of_type_JavaLangString = ajjy.a(2131643980);
    this.jdField_a_of_type_Bhyu = new bhyu(10000, 100, 2);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bhzc = parambhzc;
    this.jdField_a_of_type_Bhzb = parambhzb;
  }
  
  private boolean e()
  {
    return this.jdField_b_of_type_Int != 5;
  }
  
  public void A()
  {
    h();
    E();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
    a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList);
    this.g = true;
  }
  
  public void B()
  {
    if (this.jdField_a_of_type_Bafb != null) {
      return;
    }
    Activity localActivity = this.jdField_a_of_type_Bhzc.a();
    String str = localActivity.getString(2131633588);
    this.jdField_a_of_type_Bafb = babr.a(localActivity, 230).setMessage(str).setPositiveButton(localActivity.getString(2131628445), new bhdn(this));
  }
  
  public void C()
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
        D();
      }
    } while ((this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null) || (this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mTransferPosList == null) || (this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mTransferPosList.size() <= 0));
    this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mTransferPosList.remove(this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mTransferPosList.size() - 1);
  }
  
  protected void D()
  {
    e(false);
  }
  
  public void E()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void F()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureUnit", 2, "onCaptureButtonTouchedWhenDisable");
    }
  }
  
  public void G()
  {
    h();
  }
  
  public void H()
  {
    g();
    N();
    bbmy.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString, 0).a();
  }
  
  public void I() {}
  
  public void J()
  {
    this.j = true;
    h();
    E();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
  }
  
  public void J_()
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (!(this.jdField_a_of_type_Bhzc.a() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Bhzc.a();
    int i1;
    if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i1 = 1;
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label97;
      }
    }
    label97:
    for (int i2 = 1;; i2 = 0)
    {
      if ((i1 == 0) || (i2 == 0)) {
        break label102;
      }
      localQIMCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
      i1 = 0;
      break;
    }
    label102:
    if (i1 != 0)
    {
      localQIMCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
      return;
    }
    localQIMCameraCaptureActivity.requestPermissions(this, 1, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  public void K() {}
  
  public void L()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, "[segmentCapture] onSegmentCaptureError, mediaInfos size = " + this.jdField_a_of_type_JavaUtilList.size());
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.u();
    M();
  }
  
  public void M()
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
  
  public void N() {}
  
  public void O() {}
  
  public void P() {}
  
  protected void Q()
  {
    bhiu localbhiu = (bhiu)bhfm.a().c(8);
    if ((localbhiu != null) && (localbhiu.a()))
    {
      this.p = true;
      localbhiu.d();
    }
  }
  
  protected void R()
  {
    if (this.p)
    {
      this.p = false;
      bhiu localbhiu = (bhiu)bhfm.a().c(8);
      if (localbhiu != null) {
        localbhiu.c();
      }
    }
  }
  
  public void S() {}
  
  public void T() {}
  
  public void U() {}
  
  public void V()
  {
    this.d = bjeh.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout, bajq.a(1.0F));
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.d, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public void W() {}
  
  protected int a()
  {
    return 2131494964;
  }
  
  public Activity a()
  {
    if (this.jdField_a_of_type_Bhzc == null) {
      return null;
    }
    return this.jdField_a_of_type_Bhzc.a();
  }
  
  public IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    return localIntentFilter;
  }
  
  public View a()
  {
    biyr.a("onCreateView");
    Object localObject = new RelativeLayout(this.jdField_a_of_type_Bhzc.a());
    ((RelativeLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Bhzc.a().getLayoutInflater().inflate(a(), (ViewGroup)localObject, false).findViewById(2131300884);
    biyr.a("onCreateView1");
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298277));
    a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureParam(a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCameraPermissionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setUseVideoOrientation(false);
    if (awll.n()) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDynamicResolutionMode(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300885));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297747));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297745));
      this.d = bjeh.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_b_of_type_AndroidWidgetRelativeLayout, bajq.a(1.0F));
      if (QLog.isColorLevel()) {
        QLog.i("QIMCameraCaptureUnit", 1, "initLiuHaiScreenUI_Common mEnableLHLayout:" + this.d);
      }
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298472));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131652942));
      if (!alrg.d())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131300750));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setSelected(false);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131299334));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton.setSelected(false);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298297));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298302));
      w();
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131307132);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298287));
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Bhzc.a().getIntent().getBooleanExtra("enable_local_video", true);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303850));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130848018);
      int i1 = aciy.a(36.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      ((Drawable)localObject).setBounds(0, 0, i1, i1);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_Autm = new autm(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
      this.jdField_a_of_type_Auth = a();
      this.jdField_a_of_type_Autk = new autk(this.jdField_a_of_type_Bhzc.a());
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300854);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131298332));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController = new CaptureModeController(this);
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a();
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.d);
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.jdField_a_of_type_AndroidViewViewGroup;
      return this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDynamicResolutionMode(false);
    }
  }
  
  protected auth a()
  {
    return new auth(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView);
  }
  
  protected auuv a()
  {
    if (awll.n()) {
      return bjef.a().a(this.jdField_a_of_type_Bhzc.a());
    }
    return bjef.a().b(this.jdField_a_of_type_Bhzc.a());
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
  
  public void a(int paramInt, bhht parambhht) {}
  
  public void a(Activity paramActivity)
  {
    for (;;)
    {
      try
      {
        Object localObject = QIMCameraCaptureActivity.class.getName();
        String str = LocalVideoSelectActivity.class.getName();
        Intent localIntent = new Intent(paramActivity, PhotoListActivity.class);
        c(localIntent);
        vmo.a(localIntent, paramActivity.getIntent().getExtras(), paramActivity);
        localIntent.putExtra("from_qqstory", true);
        localIntent.putExtra("edit_video_type", this.jdField_a_of_type_Bhyu.a());
        if (!localIntent.hasExtra("ALBUM_NAME")) {
          localIntent.putExtra("ALBUM_NAME", baae.l);
        }
        if (!localIntent.hasExtra("ALBUM_ID")) {
          localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
        }
        localIntent.putExtra("video_refer", this.jdField_a_of_type_Bhyu.a());
        localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
        localIntent.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
        localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        localIntent.putExtra("PhotoConst.ENABLE_MULTI_FRAGMENT_VIDEO", false);
        localIntent.putExtra("entrance_type", this.jdField_a_of_type_Bhyu.c());
        localIntent.putExtra("story_default_label", paramActivity.getIntent().getStringExtra("story_default_label"));
        localIntent.putExtra("troop_uin", paramActivity.getIntent().getLongExtra("troop_uin", 0L));
        if (localObject != null)
        {
          localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", (String)localObject);
          localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        }
        if (str != null)
        {
          localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", str);
          localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        }
        localObject = (SessionWrap)this.jdField_a_of_type_Bhzc.a().getIntent().getParcelableExtra("ARG_SESSION_INFO");
        if (localObject != null)
        {
          localIntent.putExtra("uin", ((SessionWrap)localObject).jdField_a_of_type_JavaLangString);
          localIntent.putExtra("uintype", ((SessionWrap)localObject).jdField_a_of_type_Int);
          localIntent.putExtra("troop_uin", ((SessionWrap)localObject).c);
          localIntent.putExtra("uinname", ((SessionWrap)localObject).jdField_b_of_type_JavaLangString);
          localIntent = aciy.a(localIntent, null);
          localObject = SplashActivity.class.getName();
          str = this.jdField_a_of_type_Bhzc.a().getIntent().getStringExtra("f_a_a_n");
          if ((str != null) && (str.equals(ChatActivity.class.getName())))
          {
            localObject = str;
            localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", (String)localObject);
            localIntent.putExtra("key_activity_code", this.jdField_a_of_type_Bhzc.a().getIntent().getStringExtra("key_activity_code"));
            localIntent.putExtra("edit_video_way", this.jdField_a_of_type_Int);
            localIntent.putExtra("from_camera_album", true);
            localIntent.putExtra("VIDEO_STORY_JUMP_TO_TYPE", bjeg.b(paramActivity.getIntent()));
            localIntent.putExtra("VIDEO_STORY_FROM_TYPE", bjeg.a(paramActivity.getIntent()));
            if (this.jdField_b_of_type_Int == 5)
            {
              i1 = 10014;
              paramActivity.startActivityForResult(localIntent, i1);
              return;
            }
            int i1 = 10006;
            continue;
          }
        }
      }
      catch (Exception paramActivity)
      {
        urk.b("QIMCameraCaptureUnit", "QQStoryFlowCallback ", paramActivity);
        return;
      }
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      vhg.a().e();
      Intent localIntent = new Intent(paramActivity, PhotoListActivity.class);
      vmo.a(localIntent, paramActivity.getIntent().getExtras(), paramActivity);
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
      localIntent.putExtra("from_qqstory_slideshow", true);
      localIntent.putExtra("from_qqstory_entrance", paramBoolean);
      localIntent.putExtra("ALBUM_NAME", baae.l);
      localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", c());
      localIntent.putExtra("report_first_exposure", true);
      localIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      localIntent.putExtra("qq_sub_business_id", this.jdField_a_of_type_Bhyu.b());
      localIntent.putExtra("edit_video_type", this.jdField_a_of_type_Bhyu.a());
      b(localIntent);
      paramActivity.startActivityForResult(localIntent, 10006);
      paramActivity.overridePendingTransition(2130772277, 2130771990);
      return;
    }
    catch (Exception paramActivity)
    {
      urk.b("QIMCameraCaptureUnit", "intentToPhotoList ", paramActivity);
    }
  }
  
  public void a(Intent paramIntent) {}
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Bhzc.a().getIntent().getLongExtra("ACTIVITY_START_TIME", -1L);
    if (paramBundle != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = ((CameraCaptureView.VideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
    }
    this.jdField_a_of_type_Bhzc.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, a());
    auue.a();
  }
  
  public void a(auuy paramauuy) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
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
      if (!awhg.a().b()) {
        i1 = 1;
      }
    }
    if (i1 == 0)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, paramLocalMediaInfo);
      this.g = true;
      return;
    }
    b(paramLocalMediaInfo, true);
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
    if ((this.h) && (auue.a < 500L))
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
      b(null, false);
    }
    for (;;)
    {
      urp.a("clk_shoot", urp.b(auts.jdField_a_of_type_Int), 2, new String[0]);
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
      agak.a(BaseApplicationImpl.getContext()).a(new bhdo(this), this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
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
    auue.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a();
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
    this.jdField_a_of_type_Bhzc.a();
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
  
  protected void b(Intent paramIntent) {}
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
  }
  
  public void b(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
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
  
  public void b(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.b((float)paramLocalMediaInfo.mDuration);
  }
  
  public void b_(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.14(this));
  }
  
  protected int c()
  {
    return 10;
  }
  
  public void c() {}
  
  protected void c(Intent paramIntent)
  {
    paramIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_b_of_type_JavaUtilList.size() > 0);
  }
  
  public int d()
  {
    return 0;
  }
  
  public void d()
  {
    super.d();
    this.n = false;
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Autm);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Auth);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Autk);
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
      this.jdField_a_of_type_Bhdr = ((bhdr)bhfm.a().c(13));
      this.jdField_a_of_type_Bhdr.a(paramBoolean);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof AppInterface)) {
        localAppRuntime.notifyObservers(bhik.class, 7, false, null);
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
        P();
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
    Object localObject = this.jdField_a_of_type_Bhzc.a();
    int i1;
    int i2;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i1 = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label93;
      }
      i2 = 1;
      label43:
      if ((i1 == 0) || (i2 == 0)) {
        break label98;
      }
      localObject = babr.a(new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new QIMCameraCaptureUnit.13(this, (String)localObject));
      return;
      i1 = 0;
      break;
      label93:
      i2 = 0;
      break label43;
      label98:
      if (i1 != 0) {
        localObject = babr.a(new String[] { "android.permission.CAMERA" });
      } else {
        localObject = babr.a(new String[] { "android.permission.RECORD_AUDIO" });
      }
    }
  }
  
  public int e()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.q();
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.e();
    }
    GLGestureProxy.getInstance().removeAllListener();
    this.jdField_a_of_type_Bhzc.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
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
    float f1 = vms.a(this.jdField_a_of_type_Bhzc.a(), 90.0F);
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      localArrayList.add(new bhoj(this.jdField_a_of_type_AndroidWidgetFrameLayout, "translationY", 0.0F, f1, 450L, 0L));
      localArrayList.add(new bhoj(this.jdField_a_of_type_AndroidWidgetFrameLayout, "alpha", 1.0F, 0.0F, 450L, 0L));
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localArrayList.add(new bhoj(this.jdField_a_of_type_AndroidViewViewGroup, "translationY", f1, 0.0F, 450L, 0L));
      localArrayList.add(new bhoj(this.jdField_a_of_type_AndroidViewViewGroup, "alpha", 0.0F, 1.0F, 450L, 0L));
      this.jdField_a_of_type_AndroidViewViewGroup.setAlpha(0.0F);
    }
    Object localObject = a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        localArrayList.add(new bhoj(localView, "translationY", f1, 0.0F, 450L, 0L));
        localArrayList.add(new bhoj(localView, "alpha", 0.0F, 1.0F, 450L, 0L));
        localView.setAlpha(0.0F);
      }
    }
    bhog.a(localArrayList, new bhdk(this));
  }
  
  public int f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a();
  }
  
  public void f()
  {
    super.f();
    if (QLog.isColorLevel()) {
      QLog.d("QIMCameraCaptureUnit", 2, "onActivityResume");
    }
    this.n = true;
    GLGestureProxy.getInstance().setListener(this.jdField_a_of_type_Autm);
    GLGestureProxy.getInstance().setListener(this.jdField_a_of_type_Auth);
    GLGestureProxy.getInstance().setListener(this.jdField_a_of_type_Autk);
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
      y();
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
      P();
    }
  }
  
  public int g()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
  }
  
  public void g()
  {
    int i1 = 8;
    if (alrg.d())
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
  
  public int h()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
      return 0;
    }
    return this.jdField_b_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight();
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
    agak.a(BaseApplicationImpl.getContext()).a(this, this.jdField_b_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
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
    label155:
    boolean bool;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298472: 
      bhpm.a(this.jdField_a_of_type_AndroidWidgetButton, 200L, null);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.q();
      if (this.jdField_a_of_type_AndroidWidgetButton != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a() != 1) {
          break label155;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131652941));
      }
      for (;;)
      {
        auue.f();
        urp.a("clk_switch", this.jdField_a_of_type_Bhyu.a(), 0, new String[0]);
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidWidgetButton.getResources().getString(2131652942));
      }
    case 2131300750: 
      bhpm.a(this.jdField_b_of_type_AndroidWidgetButton, 200L, null);
      if (!this.jdField_b_of_type_AndroidWidgetButton.isSelected())
      {
        bool = true;
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a(bool)) {
          this.jdField_b_of_type_AndroidWidgetButton.setSelected(bool);
        }
        auue.d();
        if (!bool) {
          break label266;
        }
      }
      for (;;)
      {
        auts.d(i1);
        urp.a("clk_flash", this.jdField_a_of_type_Bhyu.a(), 0, new String[0]);
        bhci.a().l();
        return;
        bool = false;
        break;
        i1 = 2;
      }
    case 2131299334: 
      bhpm.a(this.jdField_c_of_type_AndroidWidgetButton, 200L, null);
      if (!this.jdField_c_of_type_AndroidWidgetButton.isSelected())
      {
        bool = true;
        this.jdField_c_of_type_AndroidWidgetButton.setSelected(bool);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.c(bool);
        if (bool) {
          break label346;
        }
        this.jdField_a_of_type_Boolean = true;
        auue.a(bool);
        if (!bool) {
          break label354;
        }
      }
      for (i1 = i2;; i1 = 2)
      {
        auts.c(i1);
        return;
        bool = false;
        break;
        this.jdField_a_of_type_Boolean = false;
        break label323;
      }
    case 2131298297: 
    case 2131298302: 
      label266:
      label323:
      label346:
      label354:
      bhpm.a(paramView, 200L, null);
      z();
      return;
    }
    bhpm.a(this.jdField_a_of_type_AndroidWidgetImageView, 200L, null);
    paramView = new awtv();
    paramView.d = "0X800822E";
    awqt.a(null, paramView);
    urp.a("clk_local", this.jdField_a_of_type_Bhyu.a(), 0, new String[0]);
    if ((this.jdField_a_of_type_Int == 9) || (this.jdField_a_of_type_Int == 11))
    {
      a(this.jdField_a_of_type_Bhzc.a());
      return;
    }
    if (this.jdField_b_of_type_Int == 5)
    {
      a(this.jdField_a_of_type_Bhzc.a());
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      vhg.a().c(21);
      vhg.a().b(11);
      a(this.jdField_a_of_type_Bhzc.a(), true);
      return;
    }
    a(this.jdField_a_of_type_Bhzc.a());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    return true;
  }
  
  public void p() {}
  
  public void q()
  {
    super.q();
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.b();
    }
  }
  
  public void r()
  {
    super.r();
    if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.d();
    }
  }
  
  public void u()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMCameraCaptureUnit", 2, "onCaptureButtonPhoto!");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.r();
  }
  
  public void v()
  {
    this.jdField_a_of_type_Bhzb.a(2);
  }
  
  protected void w()
  {
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = ((QIMCameraCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131298325));
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.a(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout = ((QIMCameraSegmentCaptureButtonLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131310023));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.a(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout;
  }
  
  public void x()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.getLayoutParams();
    localLayoutParams.bottomMargin = aciy.a(-30.0F, this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.getResources());
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.g();
    if (this.jdField_b_of_type_Boolean)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.bottomMargin = aciy.a(50.0F, this.jdField_a_of_type_AndroidWidgetImageView.getResources());
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  protected void y()
  {
    ThreadManager.excute(new QIMCameraCaptureUnit.1(this), 64, null, true);
  }
  
  public void z()
  {
    if (this.i) {
      if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController != null) {
        this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().a();
      }
    }
    for (;;)
    {
      urp.a("clk_cancel", urp.b(this.jdField_a_of_type_Bhyu.a()), 0, new String[0]);
      return;
      this.jdField_a_of_type_Bhzc.a().onBackPressed();
      auue.e();
      auts.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhdi
 * JD-Core Version:    0.7.0.1
 */