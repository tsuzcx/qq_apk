import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.ShortVideoConfig;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.facedetect.FaceDetector;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.StarParam;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.util.PhoneProperty;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.util.List;
import mqq.app.AppRuntime;

@SuppressLint({"NewApi"})
public class bdcg
{
  private double jdField_a_of_type_Double;
  public int a;
  private long jdField_a_of_type_Long;
  public akqy a;
  private bdci jdField_a_of_type_Bdci = new bdci(null);
  private bdeq jdField_a_of_type_Bdeq = new bdeq();
  volatile AESticker jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker;
  Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  BeautyRender jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
  BaseFilter jdField_a_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  public GestureKeyInfo a;
  private PTFaceAttr jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr;
  PTFaceDetector jdField_a_of_type_ComTencentTtpicOpenapiPTFaceDetector = null;
  VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private double jdField_b_of_type_Double;
  public int b;
  private long jdField_b_of_type_Long;
  Frame jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  BaseFilter jdField_b_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  public volatile boolean b;
  private int[] jdField_b_of_type_ArrayOfInt = new int[1];
  private double jdField_c_of_type_Double;
  private int jdField_c_of_type_Int;
  Frame jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  BaseFilter jdField_c_of_type_ComTencentFilterBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  public boolean c;
  private double jdField_d_of_type_Double = 1.0D;
  private int jdField_d_of_type_Int;
  Frame jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  public volatile boolean d;
  private int jdField_e_of_type_Int;
  private Frame jdField_e_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  public volatile boolean e;
  private int f;
  public volatile boolean f;
  private int g;
  public volatile boolean g;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = PhoneProperty.instance().isCannotReuseFrameBuffer();
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m = true;
  
  public bdcg()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private int a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int n = -1;
    BeautyRender localBeautyRender = a();
    if (localBeautyRender != null)
    {
      if (!paramBoolean) {
        break label42;
      }
      localBeautyRender.setNeedSkinColor(false);
    }
    for (;;)
    {
      n = localBeautyRender.process(paramInt1, -1, paramInt2, paramInt3).getTextureId();
      return n;
      label42:
      localBeautyRender.setNeedSkinColor(true);
    }
  }
  
  private Frame a(Frame paramFrame)
  {
    if (paramFrame == null) {
      return null;
    }
    Frame localFrame2 = paramFrame;
    Frame localFrame1 = paramFrame;
    for (paramFrame = localFrame2; (paramFrame.nextFrame != null) && (paramFrame.nextFrame.getTextureId() != 0); paramFrame = localFrame2)
    {
      localFrame2 = paramFrame.nextFrame;
      localFrame1 = paramFrame;
    }
    localFrame1.nextFrame = null;
    return paramFrame;
  }
  
  private void a(float paramFloat)
  {
    a().setBeautyLevel(bddt.a() * paramFloat);
    if (QLog.isColorLevel()) {
      QLog.i("FilterBeauty", 2, "setBeautyLevel " + paramFloat + "rate : " + bddt.a());
    }
  }
  
  private boolean a(FilterRender paramFilterRender)
  {
    if (!bddt.b()) {
      return false;
    }
    if (also.b())
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramFilterRender != null) {
        if (paramFilterRender.getFilterType() != 3)
        {
          bool1 = bool2;
          if (!also.a().c()) {}
        }
        else
        {
          bool1 = false;
        }
      }
      return bool1;
    }
    QLog.e("filterbeauty", 2, "checkSkinColorAvailable false");
    return false;
  }
  
  private boolean b(FilterRender paramFilterRender)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFilterRender != null) {
      if (paramFilterRender.getFilterType() != 1)
      {
        bool1 = bool2;
        if (paramFilterRender.getFilterType() != 2) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void h()
  {
    boolean bool = bnky.c();
    String str;
    if ((!this.k) && (bool))
    {
      YTCommonInterface.initAuthForQQ(BaseApplicationImpl.getContext());
      str = bnky.b(bnkt.b);
      if (!TextUtils.isEmpty(str)) {
        FeatureManager.setModelDir(str);
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceDetector = new PTFaceDetector();
      this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceDetector.init();
      this.k = true;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "mFaceDetector path:" + str);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        VideoEnvironment.LogDownLoad("QQFilterRenderManager", "OutOfMemoryError:", localOutOfMemoryError);
        bbnu.a(new RuntimeException("initFaceDetector failed"));
        this.k = false;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getLastRenderTextureId();
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, FramePerformanceMonitor paramFramePerformanceMonitor, boolean paramBoolean3)
  {
    return a(paramInt1, paramInt2, paramInt3, this.jdField_a_of_type_Boolean, paramBoolean1, true, paramBoolean2, paramFramePerformanceMonitor, paramBoolean3);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, FramePerformanceMonitor paramFramePerformanceMonitor, boolean paramBoolean5)
  {
    long l1 = PtvFilterUtils.a();
    bdcs.a();
    Object localObject = new float[16];
    Matrix.setIdentityM((float[])localObject, 0);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.updateMatrix((float[])localObject);
    FilterRender localFilterRender = also.a().a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    bdcs.jdField_a_of_type_Boolean = paramBoolean4;
    boolean bool1 = a(localFilterRender);
    boolean bool2 = b(localFilterRender);
    int n;
    if ((paramBoolean4) && (this.jdField_a_of_type_Boolean) && (bool1) && (paramBoolean1))
    {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
      n = a(bool2, paramInt3, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[BeautyTime1=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us]");
      }
      if (n != -1) {
        this.jdField_a_of_type_ArrayOfInt[2] = n;
      }
      n = this.jdField_a_of_type_ArrayOfInt[2];
      paramBoolean4 = true;
    }
    for (;;)
    {
      h();
      if (((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker != null) && (paramBoolean2)) || (this.jdField_a_of_type_Akqy != null))
      {
        if (paramBoolean4) {
          break label1905;
        }
        if ((this.jdField_a_of_type_Boolean) && (bool1) && (paramBoolean1))
        {
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
          n = a(bool2, paramInt3, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[BeautyTime1=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us]");
          }
          if (n != -1) {
            this.jdField_a_of_type_ArrayOfInt[2] = n;
          }
          n = this.jdField_a_of_type_ArrayOfInt[2];
          paramBoolean1 = true;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
        BaseFilter localBaseFilter = this.jdField_a_of_type_ComTencentFilterBaseFilter.getmNextFilter();
        this.jdField_a_of_type_ComTencentFilterBaseFilter.setNextFilter(null, null);
        this.jdField_c_of_type_ComTencentFilterBaseFilter.RenderProcess(n, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_Double, this.jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame);
        this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[mFlipFrame=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us]");
        }
        label521:
        label625:
        VideoMaterial localVideoMaterial;
        int i1;
        label791:
        long l2;
        if ((this.jdField_d_of_type_Boolean) && (this.k))
        {
          this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr = this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceDetector.detectFrame(this.jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame, 0L, 0, this.jdField_c_of_type_Double, 90.0F, false, false, new StarParam());
          if (this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getFaceCount() > 0)
          {
            this.jdField_b_of_type_Boolean = true;
            if (this.jdField_e_of_type_Boolean)
            {
              bdcj.a().c();
              GestureMgrRecognize.getInstance().transferRGBAbuffer(this.jdField_a_of_type_ArrayOfInt[0], this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
              localObject = GestureMgrRecognize.getInstance().getGestureInfo();
              if ((localObject != null) && (((GestureKeyInfo)localObject).vaild) && (((GestureKeyInfo)localObject).type.equalsIgnoreCase(GestureFilterManager.sGestureType)))
              {
                this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo = ((GestureKeyInfo)localObject);
                this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo.timeStamp = System.currentTimeMillis();
              }
              if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo != null) {
                break label1647;
              }
              this.jdField_f_of_type_Boolean = false;
              bdcj.a().d();
              if ((this.jdField_g_of_type_Boolean) && (this.jdField_f_of_type_Boolean))
              {
                bdck.a(this.jdField_f_of_type_Boolean);
                QLog.d("GestureTestUse", 2, "we have record sucess result");
              }
              if ((!QLog.isColorLevel()) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo == null)) {}
            }
            n = 0;
            localVideoMaterial = null;
            i1 = n;
            localObject = localVideoMaterial;
            if (this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceDetector != null)
            {
              i1 = n;
              localObject = localVideoMaterial;
              if (this.jdField_d_of_type_Boolean)
              {
                i1 = n;
                localObject = localVideoMaterial;
                if (this.k)
                {
                  i1 = this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getFaceCount();
                  localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getAllFacePoints();
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[getFaceCount faceCount=" + i1 + "]");
            }
            if (i1 <= 0) {
              break label1681;
            }
            paramBoolean4 = true;
            NewFlowCameraActivity.jdField_b_of_type_Boolean = paramBoolean4;
            this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
            if ((this.jdField_a_of_type_Akqy != null) && (this.jdField_c_of_type_Int != 0) && (localObject != null)) {
              this.jdField_a_of_type_Akqy.a(i1, paramInt1, paramInt2, paramInt1 * 1.0F / this.jdField_c_of_type_Int / this.jdField_c_of_type_Double, (List)localObject);
            }
            this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
            l2 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[onCameraCallBack<Qzone> steptime=" + l2 + "us]");
            }
            this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
            int i2 = this.jdField_a_of_type_ArrayOfInt[0];
            n = i2;
            if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker != null)
            {
              n = i2;
              if (this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr != null) {
                n = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker.processTransformRelatedFilters(this.jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame, this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr, null, null).getTextureId();
              }
            }
            this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
            l2 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderProcess<TempFrame> steptime=" + l2 + "us]");
            }
            this.jdField_c_of_type_ComTencentFilterBaseFilter.RenderProcess(n, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfInt[1], this.jdField_a_of_type_Double, this.jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame);
            i2 = this.jdField_a_of_type_ArrayOfInt[1];
            n = i2;
            if (localFilterRender != null)
            {
              n = i2;
              if (paramBoolean3) {
                n = localFilterRender.process(i2, -1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int).getTextureId();
              }
            }
            this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
            if (!paramBoolean5) {
              break label1687;
            }
            localBaseFilter.RenderProcess(n, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, -2, this.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentFilterBaseFilter.setNextFilter(localBaseFilter, null);
          this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
          l2 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderProcess<filterDrawTexture> steptime=" + l2 + "us] faceCount=" + i1);
          }
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderProcess<DrawWindow>  afterChange=" + this.i);
          }
          if (paramBoolean5)
          {
            if (!this.i) {
              break label1846;
            }
            this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_e_of_type_ComTencentAekitOpenrenderInternalFrame.getTextureId(), paramInt1, paramInt2, 0, this.jdField_a_of_type_Double, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
            this.jdField_e_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
            this.i = false;
            label1316:
            paramInt3 = a();
          }
          this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
          l2 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderOperation<DrawWindow> steptime=" + l2 + "us]");
          }
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
          if (this.jdField_h_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
            this.jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
            this.jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
          }
          this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
          if (QLog.isColorLevel()) {
            QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[ReuseFrameBuffer=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L + "us] cannotReuseFrameBuffer=" + this.jdField_h_of_type_Boolean);
          }
          l1 = (PtvFilterUtils.a() - l1) / 1000L;
          if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker == null) || (!paramBoolean2)) {
            break label1874;
          }
          localVideoMaterial = this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
          localObject = "";
          if (localVideoMaterial != null) {
            localObject = localVideoMaterial.getId();
          }
          bdcs.a((String)localObject, l1);
          label1535:
          paramInt1 = this.jdField_h_of_type_Int + 1;
          this.jdField_h_of_type_Int = paramInt1;
          if (paramInt1 >= 20)
          {
            if ((!paramBoolean1) && (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker == null) && (paramFramePerformanceMonitor != null)) {
              paramFramePerformanceMonitor.a(l1 / 1000L);
            }
            if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker != null) {
              break label1882;
            }
            paramFramePerformanceMonitor = null;
            label1592:
            if (alps.jdField_a_of_type_Int != 2) {
              break label1894;
            }
            localObject = "back";
            label1604:
            alrr.a((String)localObject, paramBoolean1, paramFramePerformanceMonitor, l1 / 1000L);
          }
          return paramInt3;
          n = paramInt3;
          paramBoolean1 = paramBoolean4;
          break;
          this.jdField_b_of_type_Boolean = false;
          break label521;
          this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr = null;
          break label521;
          label1647:
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo.timeStamp + 2000L >= System.currentTimeMillis())
          {
            this.jdField_f_of_type_Boolean = true;
            break label625;
          }
          this.jdField_f_of_type_Boolean = false;
          break label625;
          label1681:
          paramBoolean4 = false;
          break label791;
          label1687:
          paramInt3 = n;
        }
        if ((localFilterRender != null) && (paramBoolean3)) {
          n = localFilterRender.process(n, -1, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int).getTextureId();
        }
        for (;;)
        {
          NewFlowCameraActivity.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtimeNanos();
          if (paramBoolean5) {
            this.jdField_a_of_type_ComTencentFilterBaseFilter.RenderProcess(n, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, -2, this.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
          }
          for (;;)
          {
            this.jdField_b_of_type_Long = SystemClock.elapsedRealtimeNanos();
            l2 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[RenderProcess<NofilterDrawTexture>=" + l2 + "us]");
            }
            bdcs.a(l2);
            paramBoolean1 = paramBoolean4;
            break;
            paramInt3 = n;
          }
          label1846:
          this.jdField_b_of_type_ComTencentFilterBaseFilter.RenderProcess(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getLastRenderTextureId(), paramInt1, paramInt2, 0, this.jdField_a_of_type_Double, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
          break label1316;
          label1874:
          bdcs.b(l1);
          break label1535;
          label1882:
          paramFramePerformanceMonitor = this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.getId();
          break label1592;
          label1894:
          localObject = "front";
          break label1604;
        }
        label1905:
        paramBoolean1 = paramBoolean4;
      }
      paramBoolean4 = false;
      n = paramInt3;
    }
  }
  
  public bdeq a()
  {
    return this.jdField_a_of_type_Bdeq;
  }
  
  public BeautyRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = new BeautyRender(BaseApplicationImpl.context, lbh.h());
    }
    return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender;
  }
  
  public VideoPreviewFaceOutlineDetector a()
  {
    return this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceDetector.getFaceDetector();
  }
  
  public void a()
  {
    a(null, false);
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceDetector != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceDetector.destroy();
      this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceDetector = null;
    }
    this.k = false;
    this.l = false;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentFilterBaseFilter.applyFilterChain(true, paramInt1, paramInt2);
  }
  
  public void a(AESticker paramAESticker, boolean paramBoolean)
  {
    this.i = true;
    this.jdField_e_of_type_ComTencentAekitOpenrenderInternalFrame = a(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
    this.jdField_e_of_type_ComTencentAekitOpenrenderInternalFrame.nextFrame = null;
    if ((this.jdField_e_of_type_ComTencentAekitOpenrenderInternalFrame != this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    }
    this.jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker != null)
    {
      GestureMgrRecognize.getInstance().stop();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureKeyInfo = null;
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker.clear();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker = null;
      this.jdField_g_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("GestureTestUse", 2, "have run destroy here");
      }
    }
    if (paramAESticker != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker = paramAESticker;
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker.updateVideoSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_d_of_type_Double);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker.setRatio((float)this.jdField_b_of_type_Double);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker.apply();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, float paramFloat)
  {
    if (paramBoolean)
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      paramFloat = BaseApplicationImpl.getApplication().getSharedPreferences("beauty_setting", 0).getInt("beauty_level" + str, (int)(NewFlowCameraActivity.jdField_b_of_type_Float * 100.0F)) / 100.0F;
    }
    a(paramFloat);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr != null) {
      return this.jdField_a_of_type_ComTencentTtpicOpenapiPTFaceAttr.getFaceCount();
    }
    return 0;
  }
  
  public void b()
  {
    c();
    this.k = false;
    this.l = false;
    this.jdField_a_of_type_Bdeq.a();
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.setNextFilter(this.jdField_b_of_type_ComTencentFilterBaseFilter, null);
    this.jdField_c_of_type_ComTencentFilterBaseFilter.apply();
    this.jdField_c_of_type_ComTencentFilterBaseFilter.setRotationAndFlip(0, 0, 1);
    a(true, 0.0F);
    n = 200;
    i3 = 5;
    try
    {
      i1 = Integer.parseInt(PtvTemplateManager.h);
      n = i1;
      i2 = Integer.parseInt(PtvTemplateManager.g);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i2 = i3;
        int i1 = n;
        if (QLog.isColorLevel())
        {
          QLog.d("GestureTestUse", 2, "GestureMgr.getInstance().setRecognizeMillis number exception" + n);
          i2 = i3;
          i1 = n;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GestureTestUse", 2, "PtvTemplateManager.mGestureGapTime raw value " + PtvTemplateManager.h + ":GestureMgr.getInstance().setRecognizeMillis normal result" + i1 + ",frameRate is:" + i2);
    }
    GestureMgrRecognize.getInstance().setRecognizeMillis(i1);
    GestureMgrRecognize.getInstance().setRecognizeFrameRate(i2);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    float f1 = VideoEnvironment.configParam.mTextureScale;
    if (Math.max(paramInt1, paramInt2) < 960) {
      f1 = 1.0F;
    }
    this.jdField_a_of_type_Int = ((int)(paramInt1 * f1));
    this.jdField_b_of_type_Int = ((int)(f1 * paramInt2));
    this.jdField_b_of_type_Double = (paramInt1 / paramInt2);
    this.jdField_c_of_type_Double = (FaceDetector.FACE_DETECT_WIDTH / this.jdField_a_of_type_Int);
    this.jdField_e_of_type_Int = ((int)(this.jdField_a_of_type_Int * this.jdField_c_of_type_Double));
    this.jdField_f_of_type_Int = ((int)(this.jdField_b_of_type_Int * this.jdField_c_of_type_Double));
    this.jdField_g_of_type_Int = (this.jdField_e_of_type_Int * this.jdField_f_of_type_Int * 4);
    this.jdField_d_of_type_Double = (paramInt1 / paramInt1);
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker.updateVideoSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_d_of_type_Double);
    }
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "updatePreviewSize:: width=" + paramInt1 + ";height=" + paramInt2 + ";widthFilter=" + this.jdField_a_of_type_Int + ";heightFilter=" + this.jdField_b_of_type_Int + ";mFaceDetectWidth" + this.jdField_e_of_type_Int + ";mFaceDetectHeight=" + this.jdField_f_of_type_Int);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    if (this.jdField_e_of_type_Boolean)
    {
      GestureMgrRecognize.getInstance().start();
      return;
    }
    this.jdField_f_of_type_Boolean = false;
    GestureMgrRecognize.getInstance().stop();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_c_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_d_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    this.jdField_e_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_ComTencentFilterBaseFilter.clearGLSL();
    this.jdField_c_of_type_ComTencentFilterBaseFilter.clearGLSL();
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
    }
    this.jdField_a_of_type_Bdeq.b();
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker.clear();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker = null;
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a(null, true);
    b(paramInt1, paramInt2);
    this.j = true;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker.destroyAudio();
    }
  }
  
  public void e() {}
  
  public void f()
  {
    also.a().c();
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
    }
  }
  
  public void g()
  {
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdcg
 * JD-Core Version:    0.7.0.1
 */