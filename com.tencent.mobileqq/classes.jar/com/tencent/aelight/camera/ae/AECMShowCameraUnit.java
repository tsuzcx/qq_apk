package com.tencent.aelight.camera.ae;

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
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.ae.cmshow.AECMShowLoadingView;
import com.tencent.aelight.camera.ae.cmshow.AECMShowRequestController;
import com.tencent.aelight.camera.ae.cmshow.AECMShowRequestController.Callback;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.play.FaceChangeUtils;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.view.AECMShowFaceScanView;
import com.tencent.aelight.camera.ae.view.AECMShowFaceScanView.FaceRectData;
import com.tencent.aelight.camera.ae.view.AECMShowFaceScanView.ScanViewListener;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAECameraForCMShow;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAECMShow;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AECMShowCameraUnit
  extends AEPituCameraUnit
  implements AECMShowRequestController.Callback, AECMShowFaceScanView.ScanViewListener
{
  private float jdField_a_of_type_Float = 1.0F;
  long jdField_a_of_type_Long = -1L;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AECMShowLoadingView jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowLoadingView;
  private AECMShowRequestController jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController = new AECMShowRequestController(1, this);
  private AECMShowFaceScanView.FaceRectData jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView$FaceRectData;
  private AECMShowFaceScanView jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView;
  CmShowDataWrapper jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper;
  private PTFaceAttr jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr;
  private List<AEResInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  long jdField_b_of_type_Long = 0L;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString = "";
  private long c = 0L;
  private long jdField_d_of_type_Long = 0L;
  volatile boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 1000;
  private long jdField_e_of_type_Long = 0L;
  private volatile boolean h = false;
  private volatile boolean i = false;
  private boolean j = false;
  
  public AECMShowCameraUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    ac();
    ae();
  }
  
  private AECMShowFaceScanView.FaceRectData a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr;
    if ((localObject != null) && (((PTFaceAttr)localObject).getAllFacePoints() != null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getAllFacePoints().size() != 0))
    {
      localObject = new AECMShowFaceScanView.FaceRectData();
      RectF localRectF = new RectF();
      List localList = FaceChangeUtils.getMaxFacePoints(this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getAllFacePoints(), this.jdField_a_of_type_Float);
      PointF localPointF1 = (PointF)localList.get(0);
      PointF localPointF2 = (PointF)localList.get(18);
      PointF localPointF3 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      float f1 = TAVStickerUtil.getDistance(localPointF3, (PointF)localList.get(9));
      float f2 = TAVStickerUtil.getDistance(localPointF1, localPointF2) / 2.0F;
      localRectF.left = (localPointF3.x - f2);
      localRectF.right = (localPointF3.x + f2);
      localRectF.top = (localPointF3.y - f1);
      localRectF.bottom = (localPointF3.y + f1);
      ((AECMShowFaceScanView.FaceRectData)localObject).a(localRectF);
      f1 = localPointF2.y;
      f2 = localPointF1.y;
      float f3 = localPointF2.x;
      float f4 = localPointF1.x;
      ((AECMShowFaceScanView.FaceRectData)localObject).a((float)Math.toDegrees(Math.atan2(f1 - f2, f3 - f4)));
      return localObject;
    }
    return b();
  }
  
  private void a(AEFilterManager paramAEFilterManager)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr = paramAEFilterManager.getFaceAttr();
    paramAEFilterManager = this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr;
    if (paramAEFilterManager == null) {
      return;
    }
    paramAEFilterManager = paramAEFilterManager.getAllFacePoints();
    if ((paramAEFilterManager != null) && (paramAEFilterManager.size() != 0))
    {
      this.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_Long = -1L;
    }
    else if (this.jdField_a_of_type_Long == -1L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    else
    {
      this.jdField_b_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
    }
    af();
  }
  
  private void ac()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(AEResInfo.LIGHT_RES_BUNDLE_3DMM);
  }
  
  private void ad()
  {
    this.i = true;
    this.jdField_e_of_type_Int = 1001;
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView.a(1003, null);
    a("triggerState1", "1");
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.queueEvent(new AECMShowCameraUnit.1(this));
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
    AEBaseDataReporter.a().aH();
    a().setResult(0);
    a().finish();
  }
  
  private void ah()
  {
    int k = ((Integer)this.jdField_a_of_type_AndroidWidgetImageView.getTag()).intValue();
    if (k != 4)
    {
      if (k != 5)
      {
        an();
        return;
      }
      an();
      return;
    }
    AEBaseDataReporter.a().aP();
    ai();
  }
  
  private void ai()
  {
    this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEPhotoCaptureResult = null;
    this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper = null;
    ak();
    am();
  }
  
  private void aj()
  {
    int k = ((Integer)this.jdField_a_of_type_AndroidWidgetButton.getTag()).intValue();
    if (k != 1)
    {
      if (k != 2)
      {
        al();
        return;
      }
      AEBaseDataReporter.a().aQ();
      ai();
      return;
    }
    AEBaseDataReporter.a().aO();
    s();
  }
  
  private void ak()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setMaterial(null);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setMaterial(this.jdField_b_of_type_JavaLangString);
  }
  
  private void al()
  {
    this.i = true;
    AEBaseDataReporter.a().aG();
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.captureByCameraProxy())
    {
      q();
      return;
    }
    p();
  }
  
  private void am()
  {
    this.i = false;
    this.jdField_e_of_type_Int = 1000;
    AEBaseDataReporter.a().aD();
    if (this.jdField_d_of_type_Long > 0L) {
      AEBaseDataReporter.a().g(System.currentTimeMillis() - this.jdField_d_of_type_Long);
    } else if (this.jdField_e_of_type_Long > 0L) {
      AEBaseDataReporter.a().a(0, System.currentTimeMillis() - this.jdField_e_of_type_Long);
    }
    this.c = System.currentTimeMillis();
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.8(this));
  }
  
  private void an()
  {
    AEBaseDataReporter.a().aE();
    Intent localIntent = new Intent(a(), NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 6);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("enter_from", 53);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationAECameraForCMShow.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationAECMShow.jdField_a_of_type_JavaLangString);
    a().startActivityForResult(localIntent, 10006);
  }
  
  private void ao()
  {
    AEQLog.b(this.jdField_a_of_type_JavaLangString, "sendMakeFaceRequests");
    if ((this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEPhotoCaptureResult != null) && (!StringUtil.a(this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEPhotoCaptureResult.filePath)))
    {
      a("triggerState1", "1");
      Bitmap localBitmap = BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEPhotoCaptureResult.filePath);
      ThreadManager.getSubThreadHandler().post(new AECMShowCameraUnit.9(this, localBitmap));
      return;
    }
    AEQLog.d(this.jdField_a_of_type_JavaLangString, "sendMakeFaceRequests: 拍摄结果异常");
  }
  
  private AECMShowFaceScanView.FaceRectData b()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView$FaceRectData == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView$FaceRectData = c();
    }
    return this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView$FaceRectData;
  }
  
  private AECMShowFaceScanView.FaceRectData c()
  {
    AECMShowFaceScanView.FaceRectData localFaceRectData = new AECMShowFaceScanView.FaceRectData();
    RectF localRectF = new RectF();
    int k = UIUtils.a(a(), 65.0F);
    localRectF.left = k;
    localRectF.right = (UIUtils.b(a()) - k);
    k = (int)(localRectF.width() / 0.786047F);
    float f1 = UIUtils.c(a()) / 2.0F;
    float f2 = k / 2.0F;
    localRectF.top = ((int)(f1 - f2));
    localRectF.bottom = ((int)(UIUtils.c(a()) / 2.0F + f2));
    localFaceRectData.a(localRectF);
    localFaceRectData.a((int)(localRectF.width() * localRectF.height()));
    return localFaceRectData;
  }
  
  protected int a()
  {
    return 2064318486;
  }
  
  public View a()
  {
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(a(), null, false);
    this.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager = new VideoStoryCapturePartManager(this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a(), this.jdField_a_of_type_AndroidViewView, this);
    this.j = false;
    i();
    aa();
    j();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected void a(int paramInt)
  {
    this.jdField_e_of_type_Int = 1001;
    AEBaseDataReporter.a().d(0);
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    this.jdField_d_of_type_Long = 0L;
    this.c = 0L;
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.7(this, paramInt));
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Float = (paramInt1 * 1.0F / paramInt3);
  }
  
  protected void a(int paramInt, AEFilterManager paramAEFilterManager)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = paramAEFilterManager;
    }
    a(paramAEFilterManager);
  }
  
  public void a(int paramInt, @Nullable CmShowDataWrapper paramCmShowDataWrapper)
  {
    this.i = true;
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (paramCmShowDataWrapper != null))
    {
      this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper = paramCmShowDataWrapper;
      if (paramInt == 1)
      {
        ThreadManager.getUIHandler().post(new AECMShowCameraUnit.12(this, paramCmShowDataWrapper));
        return;
      }
      a(paramInt);
      return;
    }
    a(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if ((paramIntent != null) && (paramIntent.hasExtra("KEY_CMSHOW_DATA")))
    {
      this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper = ((CmShowDataWrapper)paramIntent.getSerializableExtra("KEY_CMSHOW_DATA"));
      s();
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    AEQLog.a(this.jdField_a_of_type_JavaLangString, "invokeTriggerState");
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.queueEvent(new AECMShowCameraUnit.10(this, paramString1, paramString2));
  }
  
  public void b(int paramInt)
  {
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.11(this, paramInt));
  }
  
  public void f()
  {
    super.f();
    this.j = true;
    if (this.c > 0L) {
      AEBaseDataReporter.a().e(System.currentTimeMillis() - this.c);
    } else if (this.jdField_d_of_type_Long > 0L) {
      AEBaseDataReporter.a().g(System.currentTimeMillis() - this.jdField_d_of_type_Long);
    } else if (this.jdField_e_of_type_Long > 0L) {
      AEBaseDataReporter.a().a(0, System.currentTimeMillis() - this.jdField_e_of_type_Long);
    }
    AECMShowRequestController localAECMShowRequestController = this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController;
    if (localAECMShowRequestController != null)
    {
      localAECMShowRequestController.b();
      this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController = null;
    }
  }
  
  public void g()
  {
    super.g();
  }
  
  protected void i()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2064121981));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2064121980));
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122016));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2064121989));
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(3));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122292));
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(5));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122298));
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView = ((AECMShowFaceScanView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122179));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122797));
    this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowLoadingView = ((AECMShowLoadingView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122050));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView.setListener(this);
  }
  
  public void onAEKitInited()
  {
    super.onAEKitInited();
    this.h = true;
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setPauseFilterChainWhenCapture(false);
    if (!StringUtil.a(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setMaterial(this.jdField_b_of_type_JavaLangString);
      this.jdField_d_of_type_Boolean = true;
      AEQLog.a(this.jdField_a_of_type_JavaLangString, "[cmShowFirstFrame] onAEKitInited: 完成设置素材");
    }
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k != 2064121989)
    {
      if (k != 2064122292)
      {
        if (k != 2064122298) {
          return;
        }
        ag();
        return;
      }
      ah();
      return;
    }
    aj();
  }
  
  public void onPhotoCaptured(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    super.onPhotoCaptured(paramAEPhotoCaptureResult);
    paramAEPhotoCaptureResult = new StringBuilder();
    paramAEPhotoCaptureResult.append("onPhotoCaptured: 厘米秀 拍摄完成 ---");
    paramAEPhotoCaptureResult.append(Thread.currentThread());
    Log.d("cmjoy_request", paramAEPhotoCaptureResult.toString());
    u();
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      a("shoot", "1");
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView.a(1001, a());
    }
  }
  
  public void onSetFilterProcess(AEFilterProcessTex paramAEFilterProcessTex)
  {
    super.onSetFilterProcess(paramAEFilterProcessTex);
    if (this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController = new AECMShowRequestController(1, this);
    }
    if (this.j) {
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView.a(1003, null);
    }
  }
  
  public void reportFirstFrameShown()
  {
    super.reportFirstFrameShown();
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[cmShowFirstFrame]:  revisible = ");
    localStringBuilder.append(this.j);
    AEQLog.a(str, localStringBuilder.toString());
    if ((this.jdField_a_of_type_ComTencentAelightCameraStructCameraAEPhotoCaptureResult != null) && (this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper != null) && (this.j))
    {
      AEQLog.a(this.jdField_a_of_type_JavaLangString, "[cmShowFirstFrame]: 还原捏脸结果");
      ad();
    }
    else if (this.j)
    {
      AEQLog.a(this.jdField_a_of_type_JavaLangString, "[cmShowFirstFrame]: 重置素材");
      ak();
      am();
    }
    else
    {
      AEQLog.a(this.jdField_a_of_type_JavaLangString, "[cmShowFirstFrame]: 首次打开");
      this.c = System.currentTimeMillis();
    }
    this.j = false;
  }
  
  protected void s()
  {
    Intent localIntent = new Intent();
    CmShowDataWrapper localCmShowDataWrapper = this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper;
    if (localCmShowDataWrapper != null) {
      localIntent.putExtra("cms_face_data", localCmShowDataWrapper);
    }
    a().setResult(-1, localIntent);
    a().finish();
  }
  
  public void t()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AEResInfo)localIterator.next();
      String str1 = AEResUtil.c((AEResInfo)localObject);
      localObject = ((AEResInfo)localObject).agentType;
      if ((this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView != null) && (!StringUtil.a(str1)))
      {
        String str2 = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[cmShowSetKapuModel][refreshBundle] bundlePath =");
        localStringBuilder.append(str1);
        QLog.d(str2, 2, localStringBuilder.toString());
        str2 = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[cmShowSetKapuModel][refreshBundle] agentType =");
        localStringBuilder.append((String)localObject);
        QLog.d(str2, 2, localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.setBundlePath(str1, (String)localObject);
      }
    }
  }
  
  protected void u()
  {
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.4(this));
  }
  
  protected void v()
  {
    this.jdField_e_of_type_Int = 1001;
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.5(this));
  }
  
  protected void w()
  {
    this.jdField_e_of_type_Int = 1001;
    AEBaseDataReporter.a().aN();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Long = 0L;
    this.c = 0L;
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.6(this));
  }
  
  protected void x()
  {
    t();
  }
  
  public void y()
  {
    if (this.c > 0L)
    {
      AEBaseDataReporter.a().e(System.currentTimeMillis() - this.c);
      this.c = 0L;
    }
    v();
    ao();
  }
  
  public void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit
 * JD-Core Version:    0.7.0.1
 */