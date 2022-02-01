import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aekit.api.standard.ai.AEDetector;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import com.tencent.ttpic.filament.CMShowUserLoader;
import com.tencent.ttpic.openapi.PTFaceAttr;
import dov.com.qq.im.ae.AECMShowCameraUnit.1;
import dov.com.qq.im.ae.AECMShowCameraUnit.10;
import dov.com.qq.im.ae.AECMShowCameraUnit.11;
import dov.com.qq.im.ae.AECMShowCameraUnit.12;
import dov.com.qq.im.ae.AECMShowCameraUnit.13;
import dov.com.qq.im.ae.AECMShowCameraUnit.2;
import dov.com.qq.im.ae.AECMShowCameraUnit.3;
import dov.com.qq.im.ae.AECMShowCameraUnit.4;
import dov.com.qq.im.ae.AECMShowCameraUnit.5;
import dov.com.qq.im.ae.AECMShowCameraUnit.6;
import dov.com.qq.im.ae.AECMShowCameraUnit.7;
import dov.com.qq.im.ae.AECMShowCameraUnit.8;
import dov.com.qq.im.ae.AECMShowCameraUnit.9;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.cmshow.AECMShowLoadingView;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController.CmShowDataWrapper;
import dov.com.qq.im.ae.play.FaceChangeUtils;
import dov.com.qq.im.ae.view.AECMShowFaceScanView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bmvk
  extends bmxa
  implements bnjc, bnrq
{
  private static String jdField_b_of_type_JavaLangString = "";
  private float jdField_a_of_type_Float = 1.0F;
  int jdField_a_of_type_Int = 2;
  public long a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bnrp jdField_a_of_type_Bnrp;
  private AEFilterManager jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  private PTFaceAttr jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr;
  private AECMShowLoadingView jdField_a_of_type_DovComQqImAeCmshowAECMShowLoadingView;
  public AECMShowRequestController.CmShowDataWrapper a;
  private AECMShowRequestController jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController = new AECMShowRequestController(1, this);
  private AECMShowFaceScanView jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView;
  private ArrayList<CMShowUserLoader> jdField_a_of_type_JavaUtilArrayList;
  private int jdField_b_of_type_Int = 1000;
  public long b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ArrayList<CMShowUserLoader> jdField_b_of_type_JavaUtilArrayList;
  private long c;
  private long d;
  public volatile boolean d;
  private long e;
  private volatile boolean h = false;
  private volatile boolean i = false;
  private boolean j;
  
  public bmvk(borh paramborh, borg paramborg)
  {
    super(paramborh, paramborg);
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = false;
    ae();
  }
  
  private bnrp a()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr == null) || (this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getAllFacePoints() == null) || (this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getAllFacePoints().size() == 0)) {
      return b();
    }
    bnrp localbnrp = new bnrp();
    RectF localRectF = new RectF();
    List localList = FaceChangeUtils.getMaxFacePoints(this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getAllFacePoints(), this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getFaceDetectScale() * this.jdField_a_of_type_Float);
    PointF localPointF1 = (PointF)localList.get(0);
    PointF localPointF2 = (PointF)localList.get(18);
    PointF localPointF3 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
    float f1 = TAVStickerUtil.getDistance(localPointF3, (PointF)localList.get(9));
    float f2 = TAVStickerUtil.getDistance(localPointF1, localPointF2) / 2.0F;
    localRectF.left = (localPointF3.x - f2);
    localRectF.right = (f2 + localPointF3.x);
    localRectF.top = (localPointF3.y - f1);
    localRectF.bottom = (f1 + localPointF3.y);
    localbnrp.a(localRectF);
    f1 = localPointF2.y;
    f2 = localPointF1.y;
    float f3 = localPointF2.x;
    float f4 = localPointF1.x;
    localbnrp.a((float)Math.toDegrees(Math.atan2(f1 - f2, f3 - f4)));
    return localbnrp;
  }
  
  private void a(AEFilterManager paramAEFilterManager)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr = ((PTFaceAttr)paramAEFilterManager.getAIAttr().getFaceAttr());
    if ((paramAEFilterManager.getAEDetector() == null) || (paramAEFilterManager.getAEDetector().getFaceDetector() == null)) {
      return;
    }
    paramAEFilterManager = this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getAllFacePoints();
    if ((paramAEFilterManager == null) || (paramAEFilterManager.size() == 0)) {
      if (this.jdField_a_of_type_Long == -1L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      af();
      return;
      this.jdField_b_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
      continue;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_Long = -1L;
    }
  }
  
  private void ad()
  {
    this.i = true;
    this.jdField_b_of_type_Int = 1001;
    this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.a(1003, null);
    D();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.queueEvent(new AECMShowCameraUnit.1(this));
  }
  
  private void ae()
  {
    ThreadManager.getSubThreadHandler().post(new AECMShowCameraUnit.2(this));
  }
  
  private void af()
  {
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.3(this));
  }
  
  private void ag()
  {
    bnqm.a().aE();
    a().setResult(0);
    a().finish();
  }
  
  private void ah()
  {
    switch (((Integer)this.jdField_a_of_type_AndroidWidgetImageView.getTag()).intValue())
    {
    default: 
      an();
      return;
    case 5: 
      an();
      return;
    }
    bnqm.a().aM();
    ai();
  }
  
  private void ai()
  {
    this.jdField_a_of_type_Bnay = null;
    this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper = null;
    ak();
    am();
  }
  
  private void aj()
  {
    switch (((Integer)this.jdField_a_of_type_AndroidWidgetButton.getTag()).intValue())
    {
    default: 
      al();
      return;
    case 1: 
      bnqm.a().aL();
      z();
      return;
    }
    bnqm.a().aN();
    ai();
  }
  
  private void ak()
  {
    ap();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setMaterial(null);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setMaterial(jdField_b_of_type_JavaLangString);
  }
  
  private void al()
  {
    this.i = true;
    bnqm.a().aD();
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.captureByCameraProxy())
    {
      x();
      return;
    }
    w();
  }
  
  private void am()
  {
    this.i = false;
    this.jdField_b_of_type_Int = 1000;
    bnqm.a().aA();
    if (this.jdField_d_of_type_Long > 0L) {
      bnqm.a().g(System.currentTimeMillis() - this.jdField_d_of_type_Long);
    }
    for (;;)
    {
      this.c = System.currentTimeMillis();
      this.jdField_d_of_type_Long = 0L;
      this.e = 0L;
      ThreadManager.getUIHandler().post(new AECMShowCameraUnit.8(this));
      return;
      if (this.e > 0L) {
        bnqm.a().a(0, System.currentTimeMillis() - this.e);
      }
    }
  }
  
  private void an()
  {
    bnqm.a().aB();
    Intent localIntent = new Intent(a(), NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 6);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("enter_from", 51);
    a().startActivityForResult(localIntent, 10006);
  }
  
  private void ao()
  {
    if ((this.jdField_a_of_type_Bnay != null) && (!StringUtil.isEmpty(this.jdField_a_of_type_Bnay.jdField_a_of_type_JavaLangString)))
    {
      D();
      Bitmap localBitmap = BitmapFactory.decodeFile(this.jdField_a_of_type_Bnay.jdField_a_of_type_JavaLangString);
      ThreadManager.getSubThreadHandler().post(new AECMShowCameraUnit.9(this, localBitmap));
      return;
    }
    bnrh.d(this.jdField_a_of_type_JavaLangString, "sendMakeFaceRequests: 拍摄结果异常");
  }
  
  private void ap()
  {
    try
    {
      as();
      this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void aq()
  {
    try
    {
      as();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((CMShowUserLoader)localIterator.next()).destroy();
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    finally {}
  }
  
  private void ar()
  {
    try
    {
      as();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((CMShowUserLoader)localIterator.next()).destroy();
      }
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    finally {}
  }
  
  private void as()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      return;
    }
    finally {}
  }
  
  private bnrp b()
  {
    if (this.jdField_a_of_type_Bnrp == null) {
      this.jdField_a_of_type_Bnrp = c();
    }
    return this.jdField_a_of_type_Bnrp;
  }
  
  private bnrp c()
  {
    bnrp localbnrp = new bnrp();
    RectF localRectF = new RectF();
    int k = UIUtils.dip2px(a(), 65.0F);
    localRectF.left = k;
    localRectF.right = (UIUtils.getScreenWidth(a()) - k);
    k = (int)(localRectF.width() / 0.786047F);
    localRectF.top = ((int)(UIUtils.getScreenHeight(a()) / 2.0F - k / 2.0F));
    float f = UIUtils.getScreenHeight(a()) / 2.0F;
    localRectF.bottom = ((int)(k / 2.0F + f));
    localbnrp.a(localRectF);
    f = localRectF.width();
    localbnrp.a((int)(localRectF.height() * f));
    return localbnrp;
  }
  
  protected void A()
  {
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.4(this));
  }
  
  protected void B()
  {
    this.jdField_b_of_type_Int = 1001;
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.5(this));
  }
  
  protected void C()
  {
    this.jdField_b_of_type_Int = 1001;
    bnqm.a().aK();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.e = 0L;
    this.c = 0L;
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.6(this));
  }
  
  protected void D()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.queueEvent(new AECMShowCameraUnit.10(this));
  }
  
  protected void E()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.queueEvent(new AECMShowCameraUnit.11(this));
  }
  
  public void F()
  {
    if (this.c > 0L)
    {
      bnqm.a().e(System.currentTimeMillis() - this.c);
      this.c = 0L;
    }
    B();
    ao();
  }
  
  public void G() {}
  
  protected int a()
  {
    return 2131558495;
  }
  
  public View a()
  {
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(a(), null, false);
    this.jdField_a_of_type_Bnqc = new bnqc(this.jdField_a_of_type_Borh.a(), this.jdField_a_of_type_AndroidViewView, this);
    this.j = false;
    p();
    ab();
    q();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected void a() {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Float = (1.0F * paramInt1 / paramInt3);
  }
  
  protected void a(int paramInt, AEFilterManager paramAEFilterManager)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = paramAEFilterManager;
    }
    a(paramAEFilterManager);
  }
  
  public void a(int paramInt, @Nullable AECMShowRequestController.CmShowDataWrapper paramCmShowDataWrapper)
  {
    this.i = true;
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (paramCmShowDataWrapper != null))
    {
      this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper = paramCmShowDataWrapper;
      if (paramInt == 1)
      {
        C();
        ThreadManager.getUIHandler().post(new AECMShowCameraUnit.13(this, paramCmShowDataWrapper));
        return;
      }
      b(paramInt);
      return;
    }
    b(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if ((paramIntent != null) && (paramIntent.hasExtra("KEY_CMSHOW_DATA")))
    {
      this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper = ((AECMShowRequestController.CmShowDataWrapper)paramIntent.getSerializableExtra("KEY_CMSHOW_DATA"));
      z();
    }
  }
  
  public void b()
  {
    ar();
    super.b();
    this.j = true;
    if (this.c > 0L) {
      bnqm.a().e(System.currentTimeMillis() - this.c);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController.b();
      this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController = null;
      return;
      if (this.jdField_d_of_type_Long > 0L) {
        bnqm.a().g(System.currentTimeMillis() - this.jdField_d_of_type_Long);
      } else if (this.e > 0L) {
        bnqm.a().a(0, System.currentTimeMillis() - this.e);
      }
    }
  }
  
  protected void b(int paramInt)
  {
    this.jdField_b_of_type_Int = 1001;
    bnqm.a().g(0);
    this.e = System.currentTimeMillis();
    this.jdField_d_of_type_Long = 0L;
    this.c = 0L;
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.7(this, paramInt));
  }
  
  public void c()
  {
    super.c();
    aq();
  }
  
  public void c(int paramInt)
  {
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.12(this, paramInt));
  }
  
  public void onAEKitInited()
  {
    super.onAEKitInited();
    this.h = true;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setPauseFilterChainWhenCapture(false);
    if (!StringUtil.isEmpty(jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setMaterial(jdField_b_of_type_JavaLangString);
      this.jdField_d_of_type_Boolean = true;
      bnrh.a(this.jdField_a_of_type_JavaLangString, "onAEKitInited: 完成设置素材");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aj();
      continue;
      ah();
      continue;
      ag();
    }
  }
  
  public void onFilterReady()
  {
    super.onFilterReady();
    if ((this.jdField_a_of_type_Bnay != null) && (this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper != null) && (this.j)) {
      ad();
    }
    for (;;)
    {
      this.j = false;
      ar();
      return;
      if (this.j)
      {
        ak();
        am();
      }
      else
      {
        this.c = System.currentTimeMillis();
      }
    }
  }
  
  public void onPhotoCaptured(bnay parambnay)
  {
    super.onPhotoCaptured(parambnay);
    Log.d("cmjoy_request", "onPhotoCaptured: 厘米秀 拍摄完成 ---" + Thread.currentThread());
    A();
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      E();
      this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.a(1001, a());
    }
  }
  
  public void onSetFilterProcess(bnaz parambnaz)
  {
    super.onSetFilterProcess(parambnaz);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = parambnaz.a();
    if (this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController == null) {
      this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController = new AECMShowRequestController(1, this);
    }
    AIManager.installDetector(bmyb.class);
    if (this.j) {
      this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.a(1003, null);
    }
  }
  
  protected void p()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363645));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363643));
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364231));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363846));
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(3));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369306));
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(5));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369356));
    this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView = ((AECMShowFaceScanView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366392));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380206));
    this.jdField_a_of_type_DovComQqImAeCmshowAECMShowLoadingView = ((AECMShowLoadingView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364783));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImAeViewAECMShowFaceScanView.setListener(this);
  }
  
  protected void z()
  {
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper != null) {
      localIntent.putExtra("cms_face_data", this.jdField_a_of_type_DovComQqImAeCmshowAECMShowRequestController$CmShowDataWrapper);
    }
    a().setResult(-1, localIntent);
    a().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvk
 * JD-Core Version:    0.7.0.1
 */