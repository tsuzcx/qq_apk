package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.capture.layer.PickLayer;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextBuilder;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.TextMap;
import com.tencent.aelight.camera.aioeditor.capture.text.NormalTextItem;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.takevideo.AEColorBarManage;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoLimitRegion.LimitMessage;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.StoryMediaEditNotifier;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.EmptyLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.LayerEventListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.LayerParams;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.GuideLineLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.ShapeLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextFaceEditLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextFaceEditLayer.LayerListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.LayerParams;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.DoodleStrategy;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.config.DoodleConfig;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.config.DoodleConfig.Builder;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.PenMode;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodleShapePanel;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.StoryGuideLineView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DoodleUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.strategy.ConfigurableLineLayerStrokeStrategy;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.struct.editor.HorizontalStroke;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

@TargetApi(14)
public class DoodleLayout
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final float jdField_a_of_type_Float = jdField_g_of_type_Int * 1.0F / (jdField_f_of_type_Int - jdField_e_of_type_Int);
  public static boolean a;
  public static final int d;
  public static final int e;
  public static final int f;
  public static final int g;
  public int a;
  public long a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Rect a;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  public SparseArray<DoodleConfig> a;
  public SparseBooleanArray a;
  public FrameLayout a;
  public ImageView a;
  public RelativeLayout a;
  protected IFaceSelectedListener a;
  private PickLayer jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureLayerPickLayer;
  DynamicTextBuilder jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextBuilder = new DynamicTextBuilder();
  private EditVideoDoodle jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
  public FaceLayer.FaceItem a;
  public GuideLineLayer a;
  public EditTextDialog a;
  public DoodleEditView a;
  protected DoodleLayout.DoodleBtnOperationHelper a;
  public DoodleLayout.DoodleEventListener a;
  public DoodleLayout.EditDialogListener a;
  private DoodleLayout.OnTextDialogShowListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$OnTextDialogShowListener;
  private DoodleLayout.TextDialogInputShow jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$TextDialogInputShow;
  public DoodleLayout.TextFaceLayerTouchListener a;
  public DoodleTextureView a;
  public DoodleView a;
  private ShapeEffect jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
  private DoodlePanel jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel;
  private DoodleShapePanel jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodleShapePanel;
  private StoryGuideLineView jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView;
  public HorizontalSelectColorLayout a;
  public EditVideoParams a;
  private RuntimeException jdField_a_of_type_JavaLangRuntimeException;
  private Comparator<BaseLayer> jdField_a_of_type_JavaUtilComparator = new DoodleLayout.1(this);
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private final Condition jdField_a_of_type_JavaUtilConcurrentLocksCondition = this.jdField_a_of_type_JavaUtilConcurrentLocksLock.newCondition();
  private final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  public int b;
  private long jdField_b_of_type_Long;
  public SparseArray<DoodleLayout.LayerCollection> b;
  public SparseBooleanArray b;
  public DoodleView b;
  private DoodlePanel jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel;
  public boolean b;
  public int c;
  private long c;
  public boolean c;
  private long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e;
  private boolean f;
  private boolean g;
  public int h;
  private boolean h;
  private int jdField_i_of_type_Int = -1;
  private boolean jdField_i_of_type_Boolean = true;
  private int jdField_j_of_type_Int = -1;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int = -1;
  private boolean jdField_k_of_type_Boolean = true;
  private int jdField_l_of_type_Int = -1;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int = -1;
  private boolean jdField_m_of_type_Boolean = false;
  private int n;
  private int o = 0;
  
  static
  {
    jdField_d_of_type_Int = DoodlePanel.a[2];
    jdField_e_of_type_Int = UIUtils.a(BaseApplicationImpl.getContext(), 3.0F);
    jdField_f_of_type_Int = UIUtils.a(BaseApplicationImpl.getContext(), 32.0F);
    jdField_g_of_type_Int = UIUtils.a(BaseApplicationImpl.getContext(), 8.0F) - 7;
  }
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_b_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$TextFaceLayerTouchListener = new DoodleLayout.TextFaceLayerTouchListener(this, null);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    LayoutInflater.from(super.getContext()).inflate(2131559072, this);
    v();
    x();
    d(this.jdField_c_of_type_Int);
    this.n = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void A()
  {
    AppInterface localAppInterface = null;
    try
    {
      if ((super.getContext() instanceof QQStoryBaseActivity)) {
        localAppInterface = ((QQStoryBaseActivity)super.getContext()).mApp;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setStrokeStrategy(new ConfigurableLineLayerStrokeStrategy(localAppInterface, true, false, a()), true, 2);
      u();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("DoodleLayout", 1, "refresh Stroke error", localException);
    }
  }
  
  private void B()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodleShapePanel.setVisibility(8);
  }
  
  private void C()
  {
    Object localObject;
    if (a()) {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel;
    } else {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout;
    }
    a(new View[] { localObject });
  }
  
  private void D()
  {
    Object localObject;
    if (a()) {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel;
    } else {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout;
    }
    b(new View[] { localObject });
  }
  
  private void E()
  {
    a(new View[] { this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel });
  }
  
  private void F()
  {
    b(new View[] { this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel });
  }
  
  private void G()
  {
    ((TransitionDrawable)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getBackground()).startTransition(240);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(240L);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localScaleAnimation);
  }
  
  private void H()
  {
    ((TransitionDrawable)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getBackground()).reverseTransition(240);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
  }
  
  public static float a(float paramFloat)
  {
    int i1 = jdField_e_of_type_Int;
    return i1 + (jdField_f_of_type_Int - i1) * paramFloat;
  }
  
  private void a(LineLayer paramLineLayer)
  {
    if (paramLineLayer != null)
    {
      Object localObject = (MosaicOperator)paramLineLayer.a(103);
      int i1;
      if (localObject != null)
      {
        i1 = this.jdField_i_of_type_Int;
        if (i1 != -1) {
          ((MosaicOperator)localObject).b(i1);
        }
      }
      if (localObject != null)
      {
        i1 = this.jdField_j_of_type_Int;
        if (i1 != -1)
        {
          int i2 = this.jdField_k_of_type_Int;
          if (i2 != -1) {
            ((MosaicOperator)localObject).b(i1, i2);
          }
        }
      }
      float f1 = a(jdField_a_of_type_Float);
      paramLineLayer.a.a().a(f1);
      localObject = (PureOperator)paramLineLayer.a(101);
      if (localObject != null)
      {
        ((PureOperator)localObject).a(jdField_d_of_type_Int);
        ((PureOperator)localObject).a(f1);
      }
      paramLineLayer = (MosaicOperator)paramLineLayer.a(104);
      if (paramLineLayer != null) {
        paramLineLayer.a(f1);
      }
    }
  }
  
  private void a(ShapeLayer paramShapeLayer)
  {
    if (paramShapeLayer != null)
    {
      paramShapeLayer.a().a(ShapeOperator.Shape.RECT_HOLLOW);
      paramShapeLayer.a().a(jdField_d_of_type_Int);
      paramShapeLayer.a().a(jdField_a_of_type_Float);
      paramShapeLayer.a().a(new DoodleLayout.12(this, paramShapeLayer));
      paramShapeLayer.a(new DoodleLayout.ShapeLayerTouchListener(this, null));
    }
  }
  
  private void a(ShapeEffect paramShapeEffect)
  {
    if (paramShapeEffect != null)
    {
      E();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodleShapePanel.setVisibility(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodleShapePanel.setSelectedColorAndWidth(paramShapeEffect.a(), paramShapeEffect.a());
    }
  }
  
  private void a(ShapeEffect paramShapeEffect, RectF paramRectF)
  {
    AEQLog.b("DoodleLayout", "addShapeTipsText---");
    this.jdField_j_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect = paramShapeEffect;
    this.jdField_a_of_type_AndroidGraphicsRectF = paramRectF;
    paramRectF = new TextLayer.LayerParams(paramRectF.left, paramRectF.top, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    paramRectF = a().a(paramRectF, null, d());
    a(a().a(), false);
    if (paramRectF != null)
    {
      if (((paramRectF instanceof NormalTextItem)) && (paramShapeEffect != null))
      {
        NormalTextItem localNormalTextItem = (NormalTextItem)paramRectF;
        localNormalTextItem.a(paramShapeEffect.a());
        localNormalTextItem.b(true);
      }
      a(paramRectF, 0, 0);
      return;
    }
    QQToast.a(getContext(), getContext().getString(2131698367), 0).a();
  }
  
  private void a(DoodlePanel.PenMode paramPenMode)
  {
    LineLayer localLineLayer = a();
    if ((localLineLayer != null) && (paramPenMode != null))
    {
      int i1 = DoodleLayout.17.a[paramPenMode.ordinal()];
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return;
          }
          if (!localLineLayer.e()) {
            localLineLayer.f();
          }
          AEBaseDataReporter.a().e(3);
          return;
        }
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel.a())
        {
          if (!localLineLayer.e()) {
            localLineLayer.f();
          }
        }
        else if (!localLineLayer.d()) {
          localLineLayer.g();
        }
        AEBaseDataReporter.a().e(1);
        return;
      }
      localLineLayer.a(2);
      AEBaseDataReporter.a().e(2);
    }
  }
  
  public static void a(String paramString)
  {
    String str;
    if (jdField_a_of_type_Boolean) {
      str = "2";
    } else {
      str = "1";
    }
    a(paramString, 0, 0, new String[] { str });
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    StoryReportor.a("video_edit", paramString, paramInt1, paramInt2, paramVarArgs);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    DoodlePanel localDoodlePanel = this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel;
    long l1 = System.currentTimeMillis();
    long l2 = 500;
    this.jdField_b_of_type_Long = (l1 + l2);
    if (paramBoolean2) {
      this.jdField_b_of_type_Long += l2;
    }
    Object localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(l2);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setAnimationListener(new DoodleLayout.15(this, localDoodlePanel));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(l2);
    if (paramBoolean2) {
      localAlphaAnimation.setStartOffset(l2);
    }
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new DoodleLayout.16(this, localDoodlePanel));
    if (paramBoolean1) {
      localObject = localAlphaAnimation;
    }
    localDoodlePanel.startAnimation((Animation)localObject);
  }
  
  private boolean a(boolean paramBoolean)
  {
    b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBackPressed, buttonState:");
    localStringBuilder.append(this.jdField_h_of_type_Int);
    localStringBuilder.append(",activeLayer:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a());
    SLog.b("DoodleLayout", localStringBuilder.toString());
    int i1 = this.jdField_h_of_type_Int;
    if (i1 != 0)
    {
      if ((i1 == 2) && (!paramBoolean)) {
        return false;
      }
      m();
      e(0);
      if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.b())
      {
        SLog.b("DoodleLayout", "onBackPressed, resetDoodleView.");
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.d();
      }
      return true;
    }
    return false;
  }
  
  private void b(DynamicTextItem paramDynamicTextItem, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1 = ((Activity)getContext()).getWindow().getAttributes().flags;
    boolean bool2 = true;
    boolean bool1;
    if ((i1 & 0x400) == 1024) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.d(bool1);
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog;
    ((EditTextDialog)localObject).jdField_g_of_type_Int = paramInt2;
    EditVideoParams localEditVideoParams = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams;
    if ((localEditVideoParams != null) && (localEditVideoParams.a())) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    ((EditTextDialog)localObject).c(bool1);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.a(a());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.b(paramBoolean);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.setContentView(2131561651);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$EditDialogListener);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextBuilder);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.setOnDismissListener(new DoodleLayout.13(this));
    if (paramInt2 == 0)
    {
      if ((paramDynamicTextItem instanceof NormalTextItem))
      {
        localObject = (NormalTextItem)paramDynamicTextItem;
        if (!((NormalTextItem)localObject).g())
        {
          ((NormalTextItem)localObject).a(AEColorBarManage.a(a()));
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.b(AEColorBarManage.a(a()));
        }
        else
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.b(((NormalTextItem)localObject).e());
          ((NormalTextItem)localObject).b(false);
        }
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.a(paramDynamicTextItem, paramInt1);
    }
    else if ((paramDynamicTextItem instanceof NormalTextItem))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.b(((NormalTextItem)paramDynamicTextItem).e());
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.show();
  }
  
  private void b(LineLayer paramLineLayer)
  {
    HorizontalStroke localHorizontalStroke = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.a();
    if (localHorizontalStroke != null)
    {
      int i1 = localHorizontalStroke.jdField_a_of_type_Int;
      Object localObject;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2) {
            return;
          }
          localObject = null;
          if ((getContext() instanceof QQStoryBaseActivity)) {
            localObject = ((QQStoryBaseActivity)getContext()).mApp;
          }
          paramLineLayer.a((AppInterface)localObject, 2, localHorizontalStroke.jdField_b_of_type_Int);
          return;
        }
        if (!paramLineLayer.e()) {
          paramLineLayer.f();
        }
      }
      else
      {
        i1 = localHorizontalStroke.jdField_b_of_type_Int;
        if (i1 != HorizontalStroke.a(a())) {
          this.jdField_b_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_c_of_type_Int, true);
        } else {
          this.jdField_b_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_c_of_type_Int, false);
        }
        localObject = (PureOperator)paramLineLayer.a(101);
        if (localObject != null) {
          ((PureOperator)localObject).a(i1);
        }
        if (!paramLineLayer.d()) {
          paramLineLayer.g();
        }
      }
    }
  }
  
  private void b(DoodlePanel.PenMode paramPenMode)
  {
    ShapeLayer localShapeLayer = a();
    if ((localShapeLayer != null) && (paramPenMode != null))
    {
      ShapeOperator localShapeOperator = localShapeLayer.a();
      switch (DoodleLayout.17.a[paramPenMode.ordinal()])
      {
      default: 
      case 8: 
        localShapeOperator.c();
        localShapeLayer.a(11);
        localShapeOperator.a(ShapeOperator.Shape.SEQUENCE_NUMBER);
        if (localShapeOperator.a())
        {
          s();
          return;
        }
        break;
      case 7: 
        localShapeLayer.a(8);
        localShapeOperator.c();
        localShapeOperator.a(ShapeOperator.Shape.ARROW);
        if (localShapeOperator.a()) {
          s();
        }
        AEBaseDataReporter.a().f(3);
        return;
      case 6: 
        localShapeLayer.a(7);
        localShapeOperator.c();
        localShapeOperator.a(ShapeOperator.Shape.LINE);
        if (localShapeOperator.a()) {
          s();
        }
        AEBaseDataReporter.a().f(4);
        return;
      case 5: 
        localShapeLayer.a(10);
        localShapeOperator.c();
        localShapeOperator.a(ShapeOperator.Shape.OVAL_HOLLOW);
        if (localShapeOperator.a()) {
          s();
        }
        AEBaseDataReporter.a().f(2);
        return;
      case 4: 
        localShapeLayer.a(9);
        localShapeOperator.c();
        localShapeOperator.a(ShapeOperator.Shape.RECT_HOLLOW);
        if (localShapeOperator.a()) {
          s();
        }
        AEBaseDataReporter.a().f(1);
      }
    }
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerGuideLineLayer == null) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerGuideLineLayer = new GuideLineLayer(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView);
    }
    Object localObject1 = (DoodleConfig)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject1 == null)
    {
      SLog.b("DoodleLayout", "initDoodleView for the %d video", Integer.valueOf(paramInt));
      Object localObject4 = a();
      localObject1 = (FaceLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a(FaceLayer.jdField_a_of_type_JavaLangString);
      DynamicFaceLayer localDynamicFaceLayer = (DynamicFaceLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a("DynamicFaceLayer");
      Object localObject2 = (LineLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a("LineLayer");
      TextLayer localTextLayer = (TextLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a(TextLayer.jdField_a_of_type_JavaLangString);
      Object localObject3 = (GuideLineLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a("GuideLineLayer");
      ShapeLayer localShapeLayer = (ShapeLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a("ShapeLayer");
      a((LineLayer)localObject2);
      a(localShapeLayer);
      localObject4 = new DoodleConfig.Builder().a((DoodleStrategy)localObject4);
      int i1 = this.jdField_l_of_type_Int;
      if (i1 == -1) {
        i1 = 480;
      }
      localObject4 = ((DoodleConfig.Builder)localObject4).a(i1);
      i1 = this.jdField_m_of_type_Int;
      if (i1 == -1) {
        i1 = 640;
      }
      localObject4 = ((DoodleConfig.Builder)localObject4).b(i1).a();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((DoodleConfig)localObject4);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.setDoodleLayout(this);
      EditVideoParams localEditVideoParams = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams;
      if (localEditVideoParams != null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(localEditVideoParams);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView.a(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams);
      }
      localObject3 = new DoodleLayout.LayerCollection(localTextLayer, (LineLayer)localObject2, (FaceLayer)localObject1, localDynamicFaceLayer, (GuideLineLayer)localObject3, (EmptyLayer)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(EmptyLayer.jdField_a_of_type_JavaLangString), localShapeLayer);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject4);
      this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, localObject3);
      if (localObject2 != null)
      {
        ((LineLayer)localObject2).a(new DoodleLayout.LineLayerTouchListener(this, null));
        ((LineLayer)localObject2).a(new DoodleLayout.10(this));
      }
      if (localObject1 != null) {
        ((FaceLayer)localObject1).a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$TextFaceLayerTouchListener);
      }
      if (localDynamicFaceLayer != null) {
        localDynamicFaceLayer.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$TextFaceLayerTouchListener);
      }
      localObject2 = new DoodleLayout.11(this);
      if (localObject1 != null) {
        ((FaceLayer)localObject1).a((FaceLayer.LayerEventListener)localObject2);
      }
      if (localDynamicFaceLayer != null) {
        localDynamicFaceLayer.a((FaceLayer.LayerEventListener)localObject2);
      }
      if ((localTextLayer != null) && (!this.jdField_d_of_type_Boolean))
      {
        localTextLayer.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$TextFaceLayerTouchListener);
        localTextLayer.a(new DoodleLayout.TextLayerListener(this, null));
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureLayerPickLayer = ((PickLayer)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a("PickLayer"));
    }
    else
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.setDoodleConfig((DoodleConfig)localObject1);
    }
    y();
    this.jdField_f_of_type_Boolean = false;
  }
  
  private void e(int paramInt)
  {
    a(paramInt, null);
  }
  
  private void e(boolean paramBoolean)
  {
    if (!this.jdField_k_of_type_Boolean) {
      return;
    }
    if (this.jdField_l_of_type_Boolean != paramBoolean)
    {
      this.jdField_l_of_type_Boolean = paramBoolean;
      if (paramBoolean)
      {
        SLog.b("DoodleLayout", "rubbish active.");
        G();
        return;
      }
      SLog.b("DoodleLayout", "rubbish unActive.");
      H();
    }
  }
  
  private static void f(boolean paramBoolean)
  {
    if (paramBoolean) {
      StoryMediaEditNotifier.a().a();
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131376867));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369486));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener = new DoodleLayout.FaceSelectedListener(this, null);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout = ((HorizontalSelectColorLayout)super.findViewById(2131371812));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnUndoViewClickListener(new DoodleLayout.2(this));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnStrokeSelectedListener(new DoodleLayout.3(this));
    w();
    View localView = super.findViewById(2131363751);
    if (localView != null) {
      localView.setVisibility(0);
    }
    A();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView = ((DoodleView)super.findViewById(2131365800));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView = ((DoodleEditView)super.findViewById(2131365801));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView.setDoodleLayout(this);
    setOnTextDialogShowListener(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView.setOnLayerTouchListener();
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView = ((DoodleView)super.findViewById(2131365809));
    m();
  }
  
  private void w()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel = ((DoodlePanel)findViewById(2131365805));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel.setPanelListener(new DoodleLayout.4(this));
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel = ((DoodlePanel)findViewById(2131365806));
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel.setPanelListener(new DoodleLayout.5(this));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodleShapePanel = ((DoodleShapePanel)findViewById(2131365807));
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodleShapePanel.setPanelListener(new DoodleLayout.6(this));
  }
  
  private void x()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel.a(DoodlePanel.PenMode.FREE_DRAW, jdField_d_of_type_Int, jdField_a_of_type_Float);
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel.a(DoodlePanel.PenMode.RECT, jdField_d_of_type_Int, jdField_a_of_type_Float);
  }
  
  private void y()
  {
    LineLayer localLineLayer = a();
    if ((localLineLayer != null) && (this.jdField_e_of_type_Boolean))
    {
      localLineLayer.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleTextureView);
      localLineLayer.a.a(new DoodleLayout.7(this));
      if (this.jdField_e_of_type_Boolean)
      {
        ((PersonalityOperator)localLineLayer.a.a(102)).a(false);
        localLineLayer.a.a(new DoodleLayout.8(this));
        localLineLayer.y_();
      }
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView.a.b())
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView.a.a();
      ((GestureHelper.ZoomItem)localObject1).jdField_f_of_type_Boolean = false;
      Object localObject2;
      if ((localObject1 instanceof FaceLayer.FaceItem))
      {
        localObject2 = a();
        FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)localObject1;
        if (localFaceItem.jdField_h_of_type_Int != 1)
        {
          localObject1 = localObject2;
          if (localFaceItem.jdField_h_of_type_Int != 3) {}
        }
        else
        {
          EditVideoParams localEditVideoParams = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams;
          if (localEditVideoParams != null)
          {
            localObject1 = localObject2;
            if (!localEditVideoParams.b()) {}
          }
          else
          {
            localObject1 = a();
            localFaceItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView);
          }
        }
        if (localObject1 != null) {
          ((FaceLayer)localObject1).jdField_a_of_type_JavaUtilList.add(localFaceItem);
        }
      }
      else if ((localObject1 instanceof TextLayer.TextItem))
      {
        localObject2 = a();
        if (localObject2 != null) {
          ((TextLayer)localObject2).jdField_a_of_type_JavaUtilArrayList.add((TextLayer.TextItem)localObject1);
        }
      }
    }
  }
  
  protected int a()
  {
    return ScreenUtil.dip2px(65.0F);
  }
  
  public int a(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      paramInt = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer.b();
      int i1 = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerLineLayer.b();
      int i2 = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.b();
      int i3 = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerDynamicFaceLayer.b();
      int i4 = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerShapeLayer.b();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DoodleCount: text->");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",line->");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(",face->");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(i3);
      ((StringBuilder)localObject).append(", shape->");
      ((StringBuilder)localObject).append(i4);
      SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
      return paramInt + i1 + i2 + i3 + i4;
    }
    return 0;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a();
  }
  
  public Bitmap a(int paramInt)
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localLayerCollection != null) {
      return localLayerCollection.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerLineLayer.a();
    }
    return null;
  }
  
  /* Error */
  public Bitmap a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 642	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleView;
    //   4: invokevirtual 1133	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleView:b	()I
    //   7: istore_3
    //   8: aload_0
    //   9: getfield 642	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleView;
    //   12: invokevirtual 1135	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleView:c	()I
    //   15: istore 4
    //   17: iload_3
    //   18: ifle +511 -> 529
    //   21: iload 4
    //   23: ifgt +6 -> 29
    //   26: goto +503 -> 529
    //   29: aload_0
    //   30: getfield 160	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   33: iconst_0
    //   34: invokevirtual 1138	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   37: ifeq +34 -> 71
    //   40: aload_0
    //   41: iload_3
    //   42: iload 4
    //   44: getstatic 1144	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   47: invokestatic 1150	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   50: putfield 1152	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   53: goto +18 -> 71
    //   56: astore 7
    //   58: ldc_w 268
    //   61: ldc_w 1154
    //   64: aload 7
    //   66: invokestatic 1157	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   69: aconst_null
    //   70: areturn
    //   71: aload_0
    //   72: getfield 165	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   75: invokeinterface 1160 1 0
    //   80: aload_0
    //   81: getfield 1152	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   84: astore 7
    //   86: aload 7
    //   88: ifnonnull +94 -> 182
    //   91: ldc_w 268
    //   94: ldc_w 1162
    //   97: invokestatic 1164	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_0
    //   101: getfield 173	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksCondition	Ljava/util/concurrent/locks/Condition;
    //   104: ldc2_w 1165
    //   107: getstatic 1172	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   110: invokeinterface 1178 4 0
    //   115: ifne -35 -> 80
    //   118: ldc_w 268
    //   121: ldc_w 1180
    //   124: iconst_1
    //   125: anewarray 1182	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: invokestatic 1188	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   133: invokevirtual 1191	java/lang/Thread:getId	()J
    //   136: invokestatic 1196	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   139: aastore
    //   140: invokestatic 1199	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_0
    //   144: getfield 1201	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   147: ifnull -67 -> 80
    //   150: ldc_w 268
    //   153: ldc_w 1203
    //   156: aload_0
    //   157: getfield 1201	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaLangRuntimeException	Ljava/lang/RuntimeException;
    //   160: invokestatic 1205	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   163: goto -83 -> 80
    //   166: astore 7
    //   168: ldc_w 268
    //   171: ldc_w 1207
    //   174: aload 7
    //   176: invokestatic 1205	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   179: goto -99 -> 80
    //   182: aload_0
    //   183: getfield 1152	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   186: astore 7
    //   188: aload_0
    //   189: aconst_null
    //   190: putfield 1152	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   193: new 1209	android/graphics/Canvas
    //   196: dup
    //   197: aload 7
    //   199: invokespecial 1212	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   202: astore 8
    //   204: new 1214	android/graphics/Paint
    //   207: dup
    //   208: invokespecial 1215	android/graphics/Paint:<init>	()V
    //   211: astore 9
    //   213: aload 9
    //   215: new 1217	android/graphics/PorterDuffXfermode
    //   218: dup
    //   219: getstatic 1223	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   222: invokespecial 1226	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   225: invokevirtual 1230	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   228: pop
    //   229: aload 8
    //   231: aload 9
    //   233: invokevirtual 1234	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   236: aload_0
    //   237: getfield 123	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_b_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   240: iload_1
    //   241: invokevirtual 790	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   244: checkcast 862	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout$LayerCollection
    //   247: astore 9
    //   249: aload 9
    //   251: ifnonnull +35 -> 286
    //   254: ldc_w 268
    //   257: ldc_w 1236
    //   260: iconst_1
    //   261: anewarray 1182	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: iload_1
    //   267: invokestatic 800	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aastore
    //   271: invokestatic 1238	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: aload_0
    //   275: getfield 165	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   278: invokeinterface 1241 1 0
    //   283: aload 7
    //   285: areturn
    //   286: invokestatic 1246	android/os/SystemClock:uptimeMillis	()J
    //   289: lstore 5
    //   291: aload 9
    //   293: getfield 1099	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout$LayerCollection:jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerLineLayer	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/LineLayer;
    //   296: astore 10
    //   298: aload 10
    //   300: getfield 391	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/LineLayer:a	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleOpController;
    //   303: invokevirtual 1247	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleOpController:a	()Z
    //   306: ifeq +21 -> 327
    //   309: ldc_w 268
    //   312: ldc_w 1249
    //   315: invokestatic 1164	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: aload 10
    //   320: getfield 391	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/LineLayer:a	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleOpController;
    //   323: iload_3
    //   324: invokevirtual 1250	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleOpController:b	(I)V
    //   327: aload_0
    //   328: getfield 692	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams	Lcom/tencent/mobileqq/editor/params/EditVideoParams;
    //   331: ifnull +20 -> 351
    //   334: aload_0
    //   335: getfield 692	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams	Lcom/tencent/mobileqq/editor/params/EditVideoParams;
    //   338: invokevirtual 695	com/tencent/mobileqq/editor/params/EditVideoParams:a	()Z
    //   341: ifeq +10 -> 351
    //   344: aload 10
    //   346: aload 8
    //   348: invokevirtual 1253	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/LineLayer:c	(Landroid/graphics/Canvas;)V
    //   351: new 1255	java/util/LinkedList
    //   354: dup
    //   355: aload 9
    //   357: getfield 1256	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout$LayerCollection:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   360: invokespecial 1259	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   363: astore 9
    //   365: aload 9
    //   367: aload_0
    //   368: getfield 189	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   371: invokestatic 1265	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   374: aload 9
    //   376: invokevirtual 1268	java/util/LinkedList:size	()I
    //   379: iconst_1
    //   380: isub
    //   381: istore_1
    //   382: iload_1
    //   383: iflt +35 -> 418
    //   386: aload 9
    //   388: iload_1
    //   389: invokevirtual 1269	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   392: checkcast 1271	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/base/BaseLayer
    //   395: astore 10
    //   397: aload 10
    //   399: ifnull +160 -> 559
    //   402: aload 10
    //   404: aload 8
    //   406: aload 10
    //   408: invokevirtual 1272	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/base/BaseLayer:a	()F
    //   411: iload_2
    //   412: invokevirtual 1275	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/base/BaseLayer:a	(Landroid/graphics/Canvas;FZ)V
    //   415: goto +144 -> 559
    //   418: iload_2
    //   419: ifeq +52 -> 471
    //   422: aload 9
    //   424: invokevirtual 1268	java/util/LinkedList:size	()I
    //   427: iconst_1
    //   428: isub
    //   429: istore_1
    //   430: iload_1
    //   431: iflt +40 -> 471
    //   434: aload 9
    //   436: iload_1
    //   437: invokevirtual 1269	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   440: checkcast 1271	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/base/BaseLayer
    //   443: astore 10
    //   445: aload 10
    //   447: ifnull +119 -> 566
    //   450: aload 10
    //   452: instanceof 820
    //   455: ifeq +111 -> 566
    //   458: aload 10
    //   460: checkcast 820	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/DynamicFaceLayer
    //   463: aload 8
    //   465: invokevirtual 1276	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/DynamicFaceLayer:c	(Landroid/graphics/Canvas;)V
    //   468: goto +3 -> 471
    //   471: new 628	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 629	java/lang/StringBuilder:<init>	()V
    //   478: astore 8
    //   480: aload 8
    //   482: ldc_w 1278
    //   485: invokevirtual 635	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload 8
    //   491: invokestatic 1246	android/os/SystemClock:uptimeMillis	()J
    //   494: lload 5
    //   496: lsub
    //   497: invokevirtual 1281	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: ldc_w 268
    //   504: aload 8
    //   506: invokevirtual 654	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 657	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: goto -238 -> 274
    //   515: astore 7
    //   517: aload_0
    //   518: getfield 165	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   521: invokeinterface 1241 1 0
    //   526: aload 7
    //   528: athrow
    //   529: ldc_w 268
    //   532: ldc_w 1283
    //   535: iconst_2
    //   536: anewarray 1182	java/lang/Object
    //   539: dup
    //   540: iconst_0
    //   541: iload_3
    //   542: invokestatic 800	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   545: aastore
    //   546: dup
    //   547: iconst_1
    //   548: iload 4
    //   550: invokestatic 800	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   553: aastore
    //   554: invokestatic 1238	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   557: aconst_null
    //   558: areturn
    //   559: iload_1
    //   560: iconst_1
    //   561: isub
    //   562: istore_1
    //   563: goto -181 -> 382
    //   566: iload_1
    //   567: iconst_1
    //   568: isub
    //   569: istore_1
    //   570: goto -140 -> 430
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	this	DoodleLayout
    //   0	573	1	paramInt	int
    //   0	573	2	paramBoolean	boolean
    //   7	535	3	i1	int
    //   15	534	4	i2	int
    //   289	206	5	l1	long
    //   56	9	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   84	3	7	localBitmap1	Bitmap
    //   166	9	7	localInterruptedException	java.lang.InterruptedException
    //   186	98	7	localBitmap2	Bitmap
    //   515	12	7	localObject1	Object
    //   202	303	8	localObject2	Object
    //   211	224	9	localObject3	Object
    //   296	163	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   40	53	56	java/lang/OutOfMemoryError
    //   91	163	166	java/lang/InterruptedException
    //   80	86	515	finally
    //   91	163	515	finally
    //   168	179	515	finally
    //   182	249	515	finally
    //   254	274	515	finally
    //   286	327	515	finally
    //   327	351	515	finally
    //   351	382	515	finally
    //   386	397	515	finally
    //   402	415	515	finally
    //   422	430	515	finally
    //   434	445	515	finally
    //   450	468	515	finally
    //   471	512	515	finally
  }
  
  public IFaceSelectedListener a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener;
  }
  
  public EditPicRawImage a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicRawImage;
  }
  
  public DynamicFaceLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerDynamicFaceLayer;
  }
  
  public EmptyLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerEmptyLayer;
  }
  
  public FaceLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer;
  }
  
  public LineLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerLineLayer;
  }
  
  public ShapeLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerShapeLayer;
  }
  
  public TextLayer a()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_c_of_type_Int);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      return null;
    }
    return localLayerCollection.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer;
  }
  
  protected DoodleLayout.NormalDoodleStategy a()
  {
    return new DoodleLayout.NormalDoodleStategy(new BaseLayer[] { this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerGuideLineLayer, new PickLayer(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView), new FaceLayer(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView), new DynamicFaceLayer(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView), new LineLayer(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView), new ShapeLayer(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView), new TextLayer(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView) });
  }
  
  public String a()
  {
    String str = "empty";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = a();
      if ((localObject1 != null) && (((TextLayer)localObject1).jdField_a_of_type_JavaUtilArrayList != null) && (!((TextLayer)localObject1).jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        localObject1 = ((TextLayer)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TextLayer.TextItem)((Iterator)localObject1).next();
          if (((TextLayer.TextItem)localObject2).jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem != null)
          {
            localObject2 = DynamicTextBuilder.a(((TextLayer.TextItem)localObject2).jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.c());
            if ((localObject2 != null) && (((List)localObject2).size() > 0))
            {
              localObject2 = (String)((List)localObject2).get(0);
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append(",");
              }
            }
          }
        }
      }
      if (localStringBuilder.length() > 0)
      {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        str = localStringBuilder.toString();
      }
      return str;
    }
    catch (Exception localException) {}
    return "empty";
  }
  
  public String a(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    localObject = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer;
    if ((((TextLayer)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (!((TextLayer)localObject).jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      localObject = ((TextLayer)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)((Iterator)localObject).next();
        if (localTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem != null)
        {
          localObject = localTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a().toString();
          return ((String)localObject).substring(0, ((String)localObject).length() - 1);
        }
      }
    }
    return null;
  }
  
  public List<String> a(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerLineLayer.a.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("image doodle type count:");
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        paramInt = ((List)localObject).size();
      } else {
        paramInt = 0;
      }
      localStringBuilder.append(paramInt);
      SLog.b("DoodleLayout", localStringBuilder.toString());
      return localObject;
    }
    return Collections.emptyList();
  }
  
  public Map<String, List<String>> a(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.jdField_a_of_type_JavaUtilMap;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Using face map:");
      localStringBuilder.append(localObject.toString());
      SLog.b("DoodleLayout", localStringBuilder.toString());
      return Collections.unmodifiableMap((Map)localObject);
    }
    return Collections.emptyMap();
  }
  
  public void a()
  {
    this.jdField_k_of_type_Boolean = false;
  }
  
  public void a(float paramFloat)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    paramFloat = a(paramFloat);
    PureOperator localPureOperator = (PureOperator)((LineLayer)localObject).a(101);
    if (localPureOperator != null) {
      localPureOperator.a(paramFloat);
    }
    ((LineLayer)localObject).a.a().a(paramFloat);
    localObject = (MosaicOperator)((LineLayer)localObject).a(104);
    if (localObject != null) {
      ((MosaicOperator)localObject).a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    localObject = (PureOperator)((LineLayer)localObject).a(101);
    if (localObject != null) {
      ((PureOperator)localObject).a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("DoodleLay_State", 4).edit();
    localEditor.putInt("Line_LastType", paramInt1);
    localEditor.putInt("Line_LastSubType", paramInt2);
    localEditor.commit();
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    SLog.b("DoodleLayout", String.format("changeDoodleViewSize, width: %d, height: %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    setDoodleBitmapMaxSize(paramInt1, paramInt2);
    int i1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.getWidth();
    int i2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.getHeight();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.e();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.f();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.onSizeChanged(paramInt1, paramInt2, i1, i2);
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView;
    if (localObject != null) {
      ((DoodleEditView)localObject).a(paramInt1, paramInt2);
    }
    localObject = (MosaicOperator)a().a(104);
    if (localObject != null) {
      ((MosaicOperator)localObject).e();
    }
    if (this.jdField_e_of_type_Boolean)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
      ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyOutsideState---outsideState=");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("DoodleLayout", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener;
    if (localObject != null) {
      ((DoodleLayout.DoodleEventListener)localObject).b(paramInt, paramObject);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        this.jdField_a_of_type_JavaLangRuntimeException = null;
        try
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          this.jdField_a_of_type_JavaUtilConcurrentLocksCondition.signal();
          return;
        }
        finally
        {
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        }
      }
      throw new IllegalStateException("add bitmap as buffer duplicate");
    }
    throw new IllegalArgumentException("bitmap should not be null or recycled");
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt1, int paramInt2)
  {
    a(paramDynamicTextItem, paramInt1, paramInt2, true);
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onClickInside: showEditTextDialog.");
    ((StringBuilder)localObject).append(paramDynamicTextItem);
    SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
    if (paramDynamicTextItem != null) {
      paramDynamicTextItem.b();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$EditDialogListener = new DoodleLayout.EditDialogListener(this, null);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog = new EditTextDialog(super.getContext());
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
    if ((localObject != null) && (((EditVideoDoodle)localObject).a.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.jdField_a_of_type_AndroidWidgetRelativeLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a.jdField_a_of_type_AndroidWidgetRelativeLayout;
    }
    b(paramDynamicTextItem, paramInt1, paramInt2, paramBoolean);
    invalidate();
    paramInt1 = this.jdField_h_of_type_Int;
    if (paramInt1 != 0) {
      if (paramInt1 == 1)
      {
        b(new View[] { this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView });
        setDoodleGLViewVisibility(0);
      }
      else if (paramInt1 == 2)
      {
        C();
        a().d(false);
      }
    }
    paramInt1 = this.jdField_h_of_type_Int;
    if ((paramInt1 != 9) && (paramInt1 != 11)) {
      e(3);
    }
    a(8, Boolean.valueOf(false));
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2)
  {
    b();
    if (paramItem == null)
    {
      SLog.e("DoodleLayout", "the item is null.");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addLocationFaceItem:");
    ((StringBuilder)localObject).append(paramItem.toString());
    SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
    FaceLayer.LayerParams localLayerParams = DoodleUtil.a(paramItem, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.getWidth(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.getHeight(), paramFloat1, paramFloat2);
    if (localLayerParams != null)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        bool1 = bool2;
        if ((paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
        {
          File localFile = ((URLDrawable)paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
          bool1 = bool2;
          if (localFile != null)
          {
            bool1 = bool2;
            if (localFile.exists())
            {
              FaceLayer localFaceLayer = a();
              localObject = localFaceLayer;
              if (paramItem.jdField_a_of_type_Int == 1)
              {
                EditVideoParams localEditVideoParams = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams;
                if (localEditVideoParams != null)
                {
                  localObject = localFaceLayer;
                  if (!localEditVideoParams.b()) {}
                }
                else
                {
                  localObject = a();
                }
              }
              bool1 = ((FaceLayer)localObject).a(paramItem.g, paramItem.c, paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localLayerParams, localFile.getAbsolutePath(), true, paramItem.jdField_a_of_type_Int, d());
            }
          }
        }
      }
      if (bool1)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.a(paramItem);
        VideoEditReport.a("0X80076CE");
      }
    }
    else
    {
      SLog.e("DoodleLayout", "create FaceLayer.ItemParams failed.");
    }
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a(paramItem, paramFloat1, paramFloat2, paramFloat3, null);
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper)
  {
    b();
    if (paramItem == null)
    {
      SLog.e("DoodleLayout", "the item is null.");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addLocationFaceItem:");
    ((StringBuilder)localObject).append(paramItem.toString());
    SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
    FaceLayer.LayerParams localLayerParams = DoodleUtil.a(paramItem, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.getWidth(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.getHeight(), paramFloat1, paramFloat2, paramFloat3);
    if (localLayerParams != null)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        bool1 = bool2;
        if ((paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
        {
          File localFile = ((URLDrawable)paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
          bool1 = bool2;
          if (localFile != null)
          {
            bool1 = bool2;
            if (localFile.exists())
            {
              localObject = a();
              if (((paramItem.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams == null)) || (this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.b())) {
                localObject = a();
              }
              bool1 = ((FaceLayer)localObject).a(paramItem.g, paramItem.c, paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localLayerParams, localFile.getAbsolutePath(), true, paramItem.jdField_a_of_type_Int, d(), paramSegmentKeeper);
            }
          }
        }
      }
      if (bool1)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.a(paramItem);
        VideoEditReport.a("0X80076CE");
        f(this.jdField_b_of_type_Boolean);
      }
    }
    else
    {
      SLog.e("DoodleLayout", "create FaceLayer.ItemParams failed.");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if ((localObject != null) && (paramBoolean))
    {
      localObject = ((RelativeLayout)localObject).getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = UIUtils.a(getContext(), 48.0F);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    GuideLineLayer localGuideLineLayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerGuideLineLayer;
    if (localGuideLineLayer == null) {
      return;
    }
    localGuideLineLayer.a(paramBoolean1, paramFloat, paramInt1, paramInt2, paramPointF, paramBoolean2, paramInt3);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("show limitView in doodleLayout  , mStoryGuideLineView : ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView);
      QLog.d("DoodleLayout", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView;
    if (localObject == null) {
      return;
    }
    if (paramBoolean4) {
      ((StoryGuideLineView)localObject).a(true);
    } else {
      ((StoryGuideLineView)localObject).a();
    }
    if (paramBoolean2) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView.b();
    } else {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView.c();
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView.d();
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiWidgetStoryGuideLineView.e();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.jdField_h_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleLayout", 2, "mEditDoodlePart == null && mListener instanceof QIMCaptureController/AECaptureController, showLimitBorder");
      }
      a(paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoodleLayout", 2, "mEditDoodlePart != null || mListener is not instanceof QIMCaptureController/AECaptureController, broadcast showLimitBorder message");
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a.a(Message.obtain(null, 15, 0, 0, new EditVideoLimitRegion.LimitMessage(paramBoolean3, paramBoolean4, paramBoolean2, paramBoolean1, paramBoolean5)));
  }
  
  protected void a(View... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = paramVarArgs[i1];
      if (localView != null) {
        localView.setVisibility(4);
      }
      i1 += 1;
    }
  }
  
  public boolean a()
  {
    DoodleLayout.DoodleEventListener localDoodleEventListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener;
    if (localDoodleEventListener != null) {
      return localDoodleEventListener.b();
    }
    return true;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, Rect paramRect, float paramFloat3)
  {
    boolean bool = false;
    int i1;
    if (paramRect == null) {
      i1 = 0;
    } else {
      i1 = paramRect.width() / 2;
    }
    float f1 = -i1;
    if ((paramFloat1 < f1) || (paramFloat2 < f1) || (paramFloat1 > this.jdField_a_of_type_AndroidGraphicsRect.width() + i1) || (paramFloat2 > this.jdField_a_of_type_AndroidGraphicsRect.height() + i1 + paramFloat3)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt, false);
  }
  
  public boolean a(TextLayer.TextItem paramTextItem, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView;
    if ((localObject != null) && (paramTextItem != null))
    {
      if (paramBoolean) {
        ((DoodleEditView)localObject).setVisibility(0);
      }
      z();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView.a.a(paramTextItem);
      paramTextItem.jdField_f_of_type_Boolean = true;
      paramTextItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.lockData(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView.a() ^ true);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView.requestLayout();
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView.a();
      if ((localObject != null) && (((TextFaceEditLayer)localObject).a != null) && (paramTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem != null) && (paramTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a()))
      {
        paramTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.c();
        ((TextFaceEditLayer)localObject).a.a(paramTextItem, paramTextItem.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.b(), 0, 0.0F, 0.0F);
      }
      return true;
    }
    return false;
  }
  
  public byte[] a(int paramInt)
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localLayerCollection == null) {
      return null;
    }
    return localLayerCollection.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerLineLayer.a();
  }
  
  public int[] a(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerLineLayer.a.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("normal path count:");
      localStringBuilder.append(localObject[0]);
      localStringBuilder.append(",mosaic path count:");
      localStringBuilder.append(localObject[1]);
      SLog.b("DoodleLayout", localStringBuilder.toString());
      return localObject;
    }
    return new int[] { 0, 0 };
  }
  
  public int b()
  {
    int i1 = 0;
    int i2 = 0;
    while (i1 < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i1);
      i2 = i2 + localLayerCollection.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer.b() + localLayerCollection.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerLineLayer.b() + localLayerCollection.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.b() + localLayerCollection.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerDynamicFaceLayer.b() + localLayerCollection.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerShapeLayer.b();
      i1 += 1;
    }
    return i2;
  }
  
  public Bitmap b()
  {
    DoodleLayout.DoodleBtnOperationHelper localDoodleBtnOperationHelper = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$DoodleBtnOperationHelper;
    if (localDoodleBtnOperationHelper == null) {
      return null;
    }
    return localDoodleBtnOperationHelper.b();
  }
  
  public String b()
  {
    String str = "empty";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject = a();
      FaceLayer.FaceItem localFaceItem;
      if ((localObject != null) && (((FaceLayer)localObject).jdField_a_of_type_JavaUtilList != null) && (!((FaceLayer)localObject).jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject = ((FaceLayer)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localFaceItem = (FaceLayer.FaceItem)((Iterator)localObject).next();
          if ((localFaceItem != null) && (!TextUtils.isEmpty(localFaceItem.e)))
          {
            localStringBuilder.append(localFaceItem.e);
            localStringBuilder.append(",");
          }
        }
      }
      localObject = a();
      if ((localObject != null) && (((DynamicFaceLayer)localObject).jdField_a_of_type_JavaUtilList != null) && (!((DynamicFaceLayer)localObject).jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject = ((DynamicFaceLayer)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localFaceItem = (FaceLayer.FaceItem)((Iterator)localObject).next();
          if ((localFaceItem != null) && (!TextUtils.isEmpty(localFaceItem.e)))
          {
            localStringBuilder.append(localFaceItem.e);
            localStringBuilder.append(",");
          }
        }
      }
      if (localStringBuilder.length() > 0)
      {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        str = localStringBuilder.toString();
      }
      return str;
    }
    catch (Exception localException) {}
    return "empty";
  }
  
  public List<FaceLayer.FaceItem> b(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.b);
      localArrayList.addAll(((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerDynamicFaceLayer.b);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Using poi list:");
      ((StringBuilder)localObject).append(localArrayList.toString());
      SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
      return Collections.unmodifiableList(localArrayList);
    }
    return Collections.emptyList();
  }
  
  protected void b()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return;
    }
    throw new IllegalStateException("Only the original thread that created a view hierarchy can touch its views.");
  }
  
  public void b(float paramFloat)
  {
    ShapeLayer localShapeLayer = a();
    if (localShapeLayer == null) {
      return;
    }
    a(paramFloat);
    localShapeLayer.a().a(paramFloat);
  }
  
  public void b(int paramInt)
  {
    ShapeLayer localShapeLayer = a();
    if (localShapeLayer == null) {
      return;
    }
    localShapeLayer.a().a(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureLayerPickLayer.d(paramBoolean);
  }
  
  protected void b(View... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = paramVarArgs[i1];
      if (localView != null) {
        localView.setVisibility(0);
      }
      i1 += 1;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.c();
  }
  
  public boolean b(int paramInt)
  {
    return this.jdField_b_of_type_AndroidUtilSparseBooleanArray.get(paramInt, false);
  }
  
  public int[] b(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("normal face count:");
      localStringBuilder.append(localObject[0]);
      localStringBuilder.append(",location face count:");
      localStringBuilder.append(localObject[1]);
      SLog.b("DoodleLayout", localStringBuilder.toString());
      return localObject;
    }
    return new int[] { 0, 0 };
  }
  
  public int c()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public String c()
  {
    if (a() != null) {
      return a().a.a();
    }
    return "";
  }
  
  public void c()
  {
    LineLayer localLineLayer = a();
    if (localLineLayer != null) {
      localLineLayer.d();
    }
  }
  
  protected void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setState---buttonState=");
    localStringBuilder.append(paramInt);
    AEQLog.a("DoodleLayout", localStringBuilder.toString());
    if (!DoodleLayout.State.a(paramInt))
    {
      SLog.e("DoodleLayout", "illegal state.");
      return;
    }
    this.jdField_h_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    DynamicFaceLayer localDynamicFaceLayer = a();
    if (localDynamicFaceLayer != null) {
      localDynamicFaceLayer.a(paramBoolean);
    }
  }
  
  public boolean c()
  {
    DoodleView localDoodleView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView;
    return (localDoodleView != null) && (localDoodleView.a() == a());
  }
  
  public boolean c(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((BaseLayer)((Iterator)localObject).next()).a()) {
          return false;
        }
      }
    }
    return true;
  }
  
  public int d()
  {
    DoodleEditView localDoodleEditView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView;
    int i2 = 1;
    int i1 = i2;
    if (localDoodleEditView != null)
    {
      if (localDoodleEditView.a() == 1) {
        return 1;
      }
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView.a() == 0) {
        i1 = 0;
      }
    }
    return i1;
  }
  
  public String d()
  {
    if (a() != null) {
      return a().a().a();
    }
    return "";
  }
  
  public void d()
  {
    ThreadManager.getUIHandler().post(new DoodleLayout.9(this));
  }
  
  public boolean d()
  {
    DoodleView localDoodleView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView;
    return (localDoodleView != null) && (localDoodleView.a() == this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureLayerPickLayer);
  }
  
  public String e()
  {
    String str = "";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = a();
      if ((localObject1 != null) && (((TextLayer)localObject1).jdField_a_of_type_JavaUtilArrayList != null) && (!((TextLayer)localObject1).jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        localObject1 = ((TextLayer)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TextLayer.TextItem)((Iterator)localObject1).next();
          if (((TextLayer.TextItem)localObject2).jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem != null)
          {
            localObject2 = DynamicTextBuilder.a(((TextLayer.TextItem)localObject2).jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.c());
            if ((localObject2 != null) && (((List)localObject2).size() > 0))
            {
              localObject2 = (String)((List)localObject2).get(0);
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localStringBuilder.append((String)localObject2);
                localStringBuilder.append("|");
              }
            }
          }
        }
      }
      if (localStringBuilder.length() > 0)
      {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        str = localStringBuilder.toString();
      }
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public void e()
  {
    b();
    LineLayer localLineLayer = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("undo, activeLayer:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a());
    ((StringBuilder)localObject).append(",pathCount:");
    ((StringBuilder)localObject).append(localLineLayer.a.b());
    SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
    localLineLayer.e();
    int i1 = localLineLayer.a.b();
    boolean bool = false;
    if (i1 == 0) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
    } else {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel;
    if (localLineLayer.a.b() > 0) {
      bool = true;
    }
    ((DoodlePanel)localObject).setUndoEnabled(bool);
  }
  
  public boolean e()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public String f()
  {
    String str1 = "";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject = a();
      Iterator localIterator;
      FaceLayer.FaceItem localFaceItem;
      String str2;
      if ((localObject != null) && (((FaceLayer)localObject).jdField_a_of_type_JavaUtilList != null) && (!((FaceLayer)localObject).jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localIterator = ((FaceLayer)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          localFaceItem = (FaceLayer.FaceItem)localIterator.next();
          if ((localFaceItem != null) && (!TextUtils.isEmpty(localFaceItem.e)))
          {
            str2 = localFaceItem.d;
            localObject = str2;
            if (TextUtils.isEmpty(str2)) {
              localObject = "none";
            }
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("_");
            localStringBuilder.append(localFaceItem.e);
            localStringBuilder.append("|");
          }
        }
      }
      localObject = a();
      if ((localObject != null) && (((DynamicFaceLayer)localObject).jdField_a_of_type_JavaUtilList != null) && (!((DynamicFaceLayer)localObject).jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localIterator = ((DynamicFaceLayer)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          localFaceItem = (FaceLayer.FaceItem)localIterator.next();
          if ((localFaceItem != null) && (!TextUtils.isEmpty(localFaceItem.e)))
          {
            str2 = localFaceItem.d;
            localObject = str2;
            if (TextUtils.isEmpty(str2)) {
              localObject = "none";
            }
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("_");
            localStringBuilder.append(localFaceItem.e);
            localStringBuilder.append("|");
          }
        }
      }
      localObject = str1;
      if (localStringBuilder.length() > 0)
      {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        localObject = localStringBuilder.toString();
      }
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public void f()
  {
    b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onFacePressed, buttonState:");
    ((StringBuilder)localObject).append(this.jdField_h_of_type_Int);
    ((StringBuilder)localObject).append(",activeLayer:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a());
    SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
    VideoEditReport.a("0X80076BA", VideoEditReport.jdField_b_of_type_Int);
    int i1 = this.jdField_h_of_type_Int;
    if (i1 != 0)
    {
      if (i1 == 3)
      {
        c(1);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.a(false);
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView;
        if (localObject != null) {
          ((DoodleEditView)localObject).a(true);
        }
        return;
      }
      if (i1 == 2)
      {
        a().d(false);
        C();
      }
      else if (i1 == 9)
      {
        a().d(false);
        E();
      }
    }
    c(1);
  }
  
  public void g()
  {
    if (this.jdField_h_of_type_Int == 3)
    {
      c(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.a(false);
      DoodleEditView localDoodleEditView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView;
      if (localDoodleEditView != null) {
        localDoodleEditView.a(true);
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_h_of_type_Int == 3)
    {
      c(0);
      e(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.a(false);
      DoodleEditView localDoodleEditView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView;
      if (localDoodleEditView != null) {
        localDoodleEditView.a(true);
      }
    }
  }
  
  public void i()
  {
    if (this.jdField_h_of_type_Int == 3)
    {
      c(0);
      e(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.a(false);
      DoodleEditView localDoodleEditView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView;
      if (localDoodleEditView != null) {
        localDoodleEditView.a(true);
      }
    }
  }
  
  public void j()
  {
    b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onTextPressed, buttonState:");
    ((StringBuilder)localObject).append(this.jdField_h_of_type_Int);
    ((StringBuilder)localObject).append(",activeLayer:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a());
    SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
    localObject = a().a(d());
    a(a().a(), false);
    if (localObject != null)
    {
      a((DynamicTextItem)localObject, 0, 0);
      int i1 = this.jdField_h_of_type_Int;
      if (i1 == 2)
      {
        a().d(false);
        C();
      }
      else if (i1 == 9)
      {
        a().d(false);
        E();
      }
      c(3);
      return;
    }
    QQToast.a(getContext(), getContext().getString(2131698367), 0).a();
    ThreadManager.getUIHandler().post(new DoodleLayout.14(this));
  }
  
  public void k()
  {
    b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLinePressed, buttonState:");
    ((StringBuilder)localObject).append(this.jdField_h_of_type_Int);
    ((StringBuilder)localObject).append(",activeLayer:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a());
    SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
    VideoEditReport.a("0X80076B8", VideoEditReport.jdField_b_of_type_Int);
    a().a().a();
    localObject = a();
    D();
    ((LineLayer)localObject).d(true);
    ((LineLayer)localObject).a(false);
    u();
    if (((LineLayer)localObject).a.b() > 0) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
    } else {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
    }
    DoodlePanel localDoodlePanel = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel;
    boolean bool;
    if (((LineLayer)localObject).a.b() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    localDoodlePanel.setUndoEnabled(bool);
    int i1 = this.jdField_h_of_type_Int;
    if (i1 != 0)
    {
      if (i1 == 3)
      {
        c(2);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.a(false);
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView;
        if (localObject != null) {
          ((DoodleEditView)localObject).a(true);
        }
        return;
      }
      if (i1 == 1)
      {
        b(new View[] { this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView });
        setDoodleGLViewVisibility(0);
      }
      else if (i1 == 9)
      {
        E();
      }
    }
    c(2);
  }
  
  public void l()
  {
    b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onShapePressed, buttonState:");
    ((StringBuilder)localObject).append(this.jdField_h_of_type_Int);
    ((StringBuilder)localObject).append(",activeLayer:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a());
    SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
    VideoEditReport.a("0X80076B8", VideoEditReport.jdField_b_of_type_Int);
    localObject = a();
    F();
    ((ShapeLayer)localObject).d(true);
    ((ShapeLayer)localObject).a(false);
    ((ShapeLayer)localObject).a().c();
    u();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel.setUndoEnabled(false);
    int i1 = this.jdField_h_of_type_Int;
    if (i1 != 0)
    {
      if (i1 == 3)
      {
        c(9);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.a(false);
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView;
        if (localObject != null) {
          ((DoodleEditView)localObject).a(true);
        }
        return;
      }
      if (i1 == 1)
      {
        b(new View[] { this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView });
        setDoodleGLViewVisibility(0);
      }
      else if (i1 == 2)
      {
        C();
      }
    }
    c(9);
  }
  
  public void m()
  {
    b();
    b(new View[] { this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView, this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView });
    setDoodleGLViewVisibility(0);
    C();
    E();
    a(new View[] { this.jdField_a_of_type_AndroidWidgetRelativeLayout });
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel.setUndoEnabled(false);
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelDoodlePanel.setUndoEnabled(false);
    if ((this.jdField_h_of_type_Int == 3) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog != null))
    {
      c(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiEditTextDialog.a(false);
      DoodleEditView localDoodleEditView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView;
      if (localDoodleEditView != null) {
        localDoodleEditView.a(true);
      }
    }
    else
    {
      c(0);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.d();
      this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.d();
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.g();
  }
  
  public void o()
  {
    this.jdField_d_of_type_Boolean = true;
    int i1 = 0;
    while (i1 < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      TextLayer localTextLayer = ((DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i1)).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextLayer;
      localTextLayer.a(null);
      localTextLayer.a(null);
      i1 += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_Long > System.currentTimeMillis()) {
      return;
    }
    if (!a(false))
    {
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener;
      if (paramView != null) {
        paramView.l();
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.b();
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.b();
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleTextureView.b();
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    super.onDetachedFromWindow();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    BaseLayer localBaseLayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a();
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureLayerPickLayer;
    boolean bool = true;
    if (localBaseLayer == localObject)
    {
      e(7);
      localBaseLayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(paramMotionEvent);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onTouchEvent--findActiveLayer: ");
      ((StringBuilder)localObject).append(localBaseLayer);
      AEQLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.setActiveLayer(localBaseLayer);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.setTopLevelLayer(localBaseLayer);
      localBaseLayer.d(paramMotionEvent);
      this.jdField_m_of_type_Boolean = true;
      return true;
    }
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a().d(paramMotionEvent);
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.jdField_m_of_type_Boolean = false;
        return true;
      }
    }
    else
    {
      this.jdField_m_of_type_Boolean = false;
      bool = false;
    }
    return bool;
  }
  
  public void p()
  {
    int i1 = this.jdField_h_of_type_Int;
    Boolean localBoolean = Boolean.valueOf(false);
    if (i1 == 6)
    {
      a(2, localBoolean);
      c(2);
      if (a().a.b() > 0) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
      } else {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(false);
      }
      D();
      if (QLog.isColorLevel()) {
        QLog.d("Personality", 2, "exitFullScreen");
      }
    }
    else if (i1 == 11)
    {
      a(9, localBoolean);
      c(9);
      F();
      if (QLog.isColorLevel()) {
        QLog.d("Personality", 2, "exitFullScreen for shape");
      }
    }
  }
  
  public void q()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener;
    if (localObject != null) {
      ((DoodleLayout.DoodleEventListener)localObject).k();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView;
    if (localObject != null) {
      ((DoodleEditView)localObject).c();
    }
    f(this.jdField_b_of_type_Boolean);
  }
  
  public void r()
  {
    MosaicOperator localMosaicOperator = (MosaicOperator)a().a(104);
    if (localMosaicOperator != null) {
      localMosaicOperator.e();
    }
  }
  
  public void s()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void setDoodleBitmapMaxSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDoodleBitmapMaxSize, maxWidth");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",maxHeight:");
      localStringBuilder.append(paramInt2);
      SLog.b("DoodleLayout", localStringBuilder.toString());
      this.jdField_l_of_type_Int = paramInt1;
      this.jdField_m_of_type_Int = paramInt2;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        ((DoodleConfig)this.jdField_a_of_type_AndroidUtilSparseArray.get(i1)).jdField_a_of_type_Int = paramInt1;
        ((DoodleConfig)this.jdField_a_of_type_AndroidUtilSparseArray.get(i1)).jdField_b_of_type_Int = paramInt2;
        i1 += 1;
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("width or height is illegal, width=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",height=");
    localStringBuilder.append(paramInt2);
    SLog.e("DoodleLayout", localStringBuilder.toString());
  }
  
  public void setDoodleBtnOperationHelper(DoodleLayout.DoodleBtnOperationHelper paramDoodleBtnOperationHelper)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$DoodleBtnOperationHelper = paramDoodleBtnOperationHelper;
  }
  
  public void setDoodleEventListener(DoodleLayout.DoodleEventListener paramDoodleEventListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener = paramDoodleEventListener;
  }
  
  @TargetApi(14)
  public void setDoodleGLViewVisibility(int paramInt)
  {
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      SLog.b("DoodleLayout", "setDoodleGLViewVisibility, soload failed, glview default invisible");
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleTextureView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleTextureView.a(paramInt);
  }
  
  public void setEditMode(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public void setEditVideoDoodle(EditVideoDoodle paramEditVideoDoodle)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle = paramEditVideoDoodle;
  }
  
  public void setEditVideoParams(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams = paramEditVideoParams;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(paramEditVideoParams);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView.a(paramEditVideoParams);
    jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a();
    A();
  }
  
  public void setLocation(TroopBarPOI paramTroopBarPOI)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem == null)
    {
      SLog.e("DoodleLayout", "ClickFaceItem not found.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLocation: clickItem-->");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem);
    SLog.b("DoodleLayout", localStringBuilder.toString());
    a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem, paramTroopBarPOI);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerFaceLayer$FaceItem = null;
  }
  
  public void setMosaicSize(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 1)
    {
      SLog.e("DoodleLayout", "MosaicSize little than 1.");
      i1 = 1;
    }
    this.jdField_i_of_type_Int = i1;
    paramInt = 0;
    while (paramInt < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      MosaicOperator localMosaicOperator = (MosaicOperator)((DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(paramInt)).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerLineLayer.a(103);
      if (localMosaicOperator != null) {
        localMosaicOperator.b(i1);
      }
      paramInt += 1;
    }
  }
  
  public void setMosaicStandardSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.jdField_j_of_type_Int = paramInt1;
      this.jdField_k_of_type_Int = paramInt2;
      int i1 = 0;
      while (i1 < this.jdField_b_of_type_AndroidUtilSparseArray.size())
      {
        localObject = (MosaicOperator)((DoodleLayout.LayerCollection)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i1)).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerLineLayer.a(103);
        if (localObject != null) {
          ((MosaicOperator)localObject).b(paramInt1, paramInt2);
        }
        i1 += 1;
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("StandardMosaicSize, width or height <= 0. width:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",height:");
    ((StringBuilder)localObject).append(paramInt2);
    SLog.e("DoodleLayout", ((StringBuilder)localObject).toString());
  }
  
  public void setOnTextDialogShowListener(DoodleLayout.OnTextDialogShowListener paramOnTextDialogShowListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$OnTextDialogShowListener = paramOnTextDialogShowListener;
  }
  
  public void setRecording(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setTimeStamp(long paramLong, boolean paramBoolean)
  {
    if ((!this.jdField_g_of_type_Boolean) || (paramBoolean))
    {
      Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView;
      if (localObject != null) {
        ((DoodleView)localObject).setTimeStamp(paramLong);
      }
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView;
      if (localObject != null) {
        ((DoodleEditView)localObject).setTimeStamp(paramLong);
      }
      localObject = this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView;
      if (localObject != null) {
        ((DoodleView)localObject).setTimeStamp(paramLong);
      }
    }
  }
  
  public void setupPersonality()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131365802));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleTextureView = new DoodleTextureView(super.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleTextureView, localLayoutParams);
    this.jdField_c_of_type_Boolean = PtvFilterSoLoad.b();
    if (!this.jdField_c_of_type_Boolean)
    {
      a(new View[] { this.jdField_a_of_type_AndroidWidgetFrameLayout });
      setDoodleGLViewVisibility(4);
      this.jdField_e_of_type_Boolean = false;
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    y();
  }
  
  public void t()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle;
    if ((localObject != null) && (((EditVideoDoodle)localObject).a.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void u()
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    if ((PureOperator)((LineLayer)localObject).a(101) == null) {
      return;
    }
    if (this.jdField_a_of_type_Int == -1)
    {
      localObject = BaseApplicationImpl.getContext().getSharedPreferences("DoodleLay_State", 4);
      if ((((SharedPreferences)localObject).contains("Line_LastType")) && (((SharedPreferences)localObject).contains("Line_LastSubType")))
      {
        this.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("Line_LastType", 0);
        this.jdField_b_of_type_Int = ((SharedPreferences)localObject).getInt("Line_LastSubType", 0);
      }
      else
      {
        this.jdField_a_of_type_Int = 0;
        this.jdField_b_of_type_Int = HorizontalStroke.a(a());
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStroke(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
 * JD-Core Version:    0.7.0.1
 */