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
import org.json.JSONArray;

@TargetApi(14)
public class DoodleLayout
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final float aj = o * 1.0F / (n - m);
  public static boolean c;
  public static final int l = DoodlePanel.a[2];
  public static final int m = UIUtils.a(BaseApplicationImpl.getContext(), 3.0F);
  public static final int n = UIUtils.a(BaseApplicationImpl.getContext(), 32.0F);
  public static final int o = UIUtils.a(BaseApplicationImpl.getContext(), 8.0F) - 7;
  public EditTextDialog A;
  public boolean B;
  public int C = 0;
  public FaceLayer.FaceItem D;
  protected DoodleLayout.DoodleBtnOperationHelper E;
  DynamicTextBuilder F = new DynamicTextBuilder();
  public DoodleLayout.TextFaceLayerTouchListener G = new DoodleLayout.TextFaceLayerTouchListener(this, null);
  public long H;
  public Rect I = new Rect();
  private PickLayer J;
  private int K = -1;
  private int L = -1;
  private int M = -1;
  private int N = -1;
  private int O = -1;
  private boolean P = false;
  private long Q;
  private DoodleLayout.OnTextDialogShowListener R;
  private DoodleLayout.TextDialogInputShow S;
  private int T;
  private int U = 0;
  private boolean V = false;
  private EditVideoDoodle W;
  private boolean Z;
  public int a = -1;
  private long aa = 0L;
  private long ab = 0L;
  private boolean ac = false;
  private StoryGuideLineView ad;
  private boolean ae = false;
  private boolean af = true;
  private boolean ag = false;
  private ShapeEffect ah;
  private RectF ai;
  private DoodlePanel ak;
  private DoodlePanel al;
  private DoodleShapePanel am;
  private Bitmap an;
  private AtomicBoolean ao = new AtomicBoolean(true);
  private final Lock ap = new ReentrantLock();
  private final Condition aq = this.ap.newCondition();
  private RuntimeException ar;
  private boolean as = true;
  private boolean at;
  private Comparator<BaseLayer> au = new DoodleLayout.1(this);
  private boolean av = false;
  public int b = -1;
  public int d = 0;
  public SparseBooleanArray e = new SparseBooleanArray();
  public SparseBooleanArray f = new SparseBooleanArray();
  public SparseArray<DoodleConfig> g = new SparseArray();
  public SparseArray<DoodleLayout.LayerCollection> h = new SparseArray();
  public GuideLineLayer i;
  protected IFaceSelectedListener j;
  public boolean k = false;
  public EditVideoParams p;
  public RelativeLayout q;
  public ImageView r;
  public HorizontalSelectColorLayout s;
  public FrameLayout t;
  public DoodleTextureView u;
  public DoodleView v;
  public DoodleEditView w;
  public DoodleView x;
  public DoodleLayout.DoodleEventListener y;
  public DoodleLayout.EditDialogListener z;
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(super.getContext()).inflate(2131624732, this);
    A();
    C();
    o(this.d);
    this.T = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void A()
  {
    this.q = ((RelativeLayout)super.findViewById(2131445201));
    this.r = ((ImageView)super.findViewById(2131436557));
    this.j = new DoodleLayout.FaceSelectedListener(this, null);
    this.s = ((HorizontalSelectColorLayout)super.findViewById(2131439247));
    this.s.setOnUndoViewClickListener(new DoodleLayout.2(this));
    this.s.setOnStrokeSelectedListener(new DoodleLayout.3(this));
    B();
    View localView = super.findViewById(2131429675);
    if (localView != null) {
      localView.setVisibility(0);
    }
    F();
    this.v = ((DoodleView)super.findViewById(2131432057));
    this.w = ((DoodleEditView)super.findViewById(2131432058));
    this.w.setDoodleLayout(this);
    setOnTextDialogShowListener(this.w);
    this.w.setOnLayerTouchListener();
    this.x = ((DoodleView)super.findViewById(2131432066));
    n();
  }
  
  private void B()
  {
    this.ak = ((DoodlePanel)findViewById(2131432062));
    this.ak.setPanelListener(new DoodleLayout.4(this));
    this.al = ((DoodlePanel)findViewById(2131432063));
    this.al.setPanelListener(new DoodleLayout.5(this));
    this.am = ((DoodleShapePanel)findViewById(2131432064));
    this.am.setPanelListener(new DoodleLayout.6(this));
  }
  
  private void C()
  {
    this.ak.a(DoodlePanel.PenMode.FREE_DRAW, l, aj);
    this.al.a(DoodlePanel.PenMode.RECT, l, aj);
  }
  
  private void D()
  {
    LineLayer localLineLayer = getLineLayer();
    if ((localLineLayer != null) && (this.V))
    {
      localLineLayer.a(this.u);
      localLineLayer.b.a(new DoodleLayout.7(this));
      if (this.V)
      {
        ((PersonalityOperator)localLineLayer.b.a(102)).a(false);
        localLineLayer.b.a(new DoodleLayout.8(this));
        localLineLayer.g();
      }
    }
  }
  
  private void E()
  {
    if (this.w.a.d())
    {
      Object localObject1 = this.w.a.h();
      ((GestureHelper.ZoomItem)localObject1).M = false;
      Object localObject2;
      if ((localObject1 instanceof FaceLayer.FaceItem))
      {
        localObject2 = getFaceLayer();
        FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)localObject1;
        if (localFaceItem.y != 1)
        {
          localObject1 = localObject2;
          if (localFaceItem.y != 3) {}
        }
        else
        {
          EditVideoParams localEditVideoParams = this.p;
          if (localEditVideoParams != null)
          {
            localObject1 = localObject2;
            if (!localEditVideoParams.c()) {}
          }
          else
          {
            localObject1 = getDynamicFaceLayer();
            localFaceItem.l.setCallback(this.v);
          }
        }
        if (localObject1 != null) {
          ((FaceLayer)localObject1).b.add(localFaceItem);
        }
      }
      else if ((localObject1 instanceof TextLayer.TextItem))
      {
        localObject2 = getTextLayer();
        if (localObject2 != null) {
          ((TextLayer)localObject2).t.add((TextLayer.TextItem)localObject1);
        }
      }
    }
  }
  
  private void F()
  {
    AppInterface localAppInterface = null;
    try
    {
      if ((super.getContext() instanceof QQStoryBaseActivity)) {
        localAppInterface = ((QQStoryBaseActivity)super.getContext()).mApp;
      }
      this.s.setStrokeStrategy(new ConfigurableLineLayerStrokeStrategy(localAppInterface, true, false, e()), true, 2);
      y();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("DoodleLayout", 1, "refresh Stroke error", localException);
    }
  }
  
  private void G()
  {
    this.am.setVisibility(8);
  }
  
  private void H()
  {
    Object localObject;
    if (e()) {
      localObject = this.ak;
    } else {
      localObject = this.s;
    }
    setViewsInVisible(new View[] { localObject });
  }
  
  private void I()
  {
    Object localObject;
    if (e()) {
      localObject = this.ak;
    } else {
      localObject = this.s;
    }
    setViewsVisible(new View[] { localObject });
  }
  
  private void J()
  {
    setViewsInVisible(new View[] { this.al });
  }
  
  private void K()
  {
    setViewsVisible(new View[] { this.al });
  }
  
  private void L()
  {
    ((TransitionDrawable)this.q.getBackground()).startTransition(240);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(240L);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    this.q.startAnimation(localScaleAnimation);
  }
  
  private void M()
  {
    ((TransitionDrawable)this.q.getBackground()).reverseTransition(240);
    this.q.clearAnimation();
  }
  
  private void a(LineLayer paramLineLayer)
  {
    if (paramLineLayer != null)
    {
      Object localObject = (MosaicOperator)paramLineLayer.b(103);
      int i1;
      if (localObject != null)
      {
        i1 = this.K;
        if (i1 != -1) {
          ((MosaicOperator)localObject).b(i1);
        }
      }
      if (localObject != null)
      {
        i1 = this.L;
        if (i1 != -1)
        {
          int i2 = this.M;
          if (i2 != -1) {
            ((MosaicOperator)localObject).b(i1, i2);
          }
        }
      }
      float f1 = b(aj);
      paramLineLayer.b.h().a(f1);
      localObject = (PureOperator)paramLineLayer.b(101);
      if (localObject != null)
      {
        ((PureOperator)localObject).a(l);
        ((PureOperator)localObject).a(f1);
      }
      paramLineLayer = (MosaicOperator)paramLineLayer.b(104);
      if (paramLineLayer != null) {
        paramLineLayer.a(f1);
      }
    }
  }
  
  private void a(ShapeLayer paramShapeLayer)
  {
    if (paramShapeLayer != null)
    {
      paramShapeLayer.i().a(ShapeOperator.Shape.RECT_HOLLOW);
      paramShapeLayer.i().a(l);
      paramShapeLayer.i().a(aj);
      paramShapeLayer.i().a(new DoodleLayout.12(this, paramShapeLayer));
      paramShapeLayer.a(new DoodleLayout.ShapeLayerTouchListener(this, null));
    }
  }
  
  private void a(ShapeEffect paramShapeEffect)
  {
    if (paramShapeEffect != null)
    {
      J();
      this.am.setVisibility(0);
      this.am.setSelectedColorAndWidth(paramShapeEffect.d(), paramShapeEffect.c());
    }
  }
  
  private void a(ShapeEffect paramShapeEffect, RectF paramRectF)
  {
    AEQLog.b("DoodleLayout", "addShapeTipsText---");
    this.ag = true;
    this.ah = paramShapeEffect;
    this.ai = paramRectF;
    paramRectF = new TextLayer.LayerParams(paramRectF.left, paramRectF.top, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    paramRectF = getTextLayer().a(paramRectF, null, getFrom());
    a(getTextLayer().j(), false);
    if (paramRectF != null)
    {
      if (((paramRectF instanceof NormalTextItem)) && (paramShapeEffect != null))
      {
        NormalTextItem localNormalTextItem = (NormalTextItem)paramRectF;
        localNormalTextItem.a(paramShapeEffect.d());
        localNormalTextItem.b(true);
      }
      a(paramRectF, 0, 0);
      return;
    }
    QQToast.makeText(getContext(), getContext().getString(2131896291), 0).show();
  }
  
  private void a(DoodlePanel.PenMode paramPenMode)
  {
    LineLayer localLineLayer = getLineLayer();
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
          if (!localLineLayer.n()) {
            localLineLayer.k();
          }
          AEBaseDataReporter.a().f(3);
          return;
        }
        if (this.ak.a())
        {
          if (!localLineLayer.n()) {
            localLineLayer.k();
          }
        }
        else if (!localLineLayer.m()) {
          localLineLayer.l();
        }
        AEBaseDataReporter.a().f(1);
        return;
      }
      localLineLayer.a(2);
      AEBaseDataReporter.a().f(2);
    }
  }
  
  public static void a(String paramString)
  {
    String str;
    if (c) {
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
    DoodlePanel localDoodlePanel = this.al;
    long l1 = System.currentTimeMillis();
    long l2 = 500;
    this.Q = (l1 + l2);
    if (paramBoolean2) {
      this.Q += l2;
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
  
  public static float b(float paramFloat)
  {
    int i1 = m;
    return i1 + (n - i1) * paramFloat;
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
    this.A.d(bool1);
    Object localObject = this.A;
    ((EditTextDialog)localObject).w = paramInt2;
    EditVideoParams localEditVideoParams = this.p;
    if ((localEditVideoParams != null) && (localEditVideoParams.b())) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    ((EditTextDialog)localObject).c(bool1);
    this.A.a(getControlBarHeight());
    this.A.b(paramBoolean);
    this.A.setContentView(2131628030);
    this.A.a(this.z);
    this.A.a(this.F);
    this.A.setOnDismissListener(new DoodleLayout.13(this));
    if (paramInt2 == 0)
    {
      if ((paramDynamicTextItem instanceof NormalTextItem))
      {
        localObject = (NormalTextItem)paramDynamicTextItem;
        if (!((NormalTextItem)localObject).v())
        {
          ((NormalTextItem)localObject).a(AEColorBarManage.a(e()));
          this.A.d(AEColorBarManage.a(e()));
        }
        else
        {
          this.A.d(((NormalTextItem)localObject).u());
          ((NormalTextItem)localObject).b(false);
        }
      }
      this.A.a(paramDynamicTextItem, paramInt1);
    }
    else if ((paramDynamicTextItem instanceof NormalTextItem))
    {
      this.A.d(((NormalTextItem)paramDynamicTextItem).u());
    }
    this.A.show();
  }
  
  private void b(LineLayer paramLineLayer)
  {
    HorizontalStroke localHorizontalStroke = this.s.getCurrentStroke();
    if (localHorizontalStroke != null)
    {
      int i1 = localHorizontalStroke.c;
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
          paramLineLayer.a((AppInterface)localObject, 2, localHorizontalStroke.d);
          return;
        }
        if (!paramLineLayer.n()) {
          paramLineLayer.k();
        }
      }
      else
      {
        i1 = localHorizontalStroke.d;
        if (i1 != HorizontalStroke.a(e())) {
          this.f.put(this.d, true);
        } else {
          this.f.put(this.d, false);
        }
        localObject = (PureOperator)paramLineLayer.b(101);
        if (localObject != null) {
          ((PureOperator)localObject).a(i1);
        }
        if (!paramLineLayer.m()) {
          paramLineLayer.l();
        }
      }
    }
  }
  
  private void b(DoodlePanel.PenMode paramPenMode)
  {
    ShapeLayer localShapeLayer = getShapeLayer();
    if ((localShapeLayer != null) && (paramPenMode != null))
    {
      ShapeOperator localShapeOperator = localShapeLayer.i();
      switch (DoodleLayout.17.a[paramPenMode.ordinal()])
      {
      default: 
      case 8: 
        localShapeOperator.d();
        localShapeLayer.a(11);
        localShapeOperator.a(ShapeOperator.Shape.SEQUENCE_NUMBER);
        if (localShapeOperator.c())
        {
          w();
          return;
        }
        break;
      case 7: 
        localShapeLayer.a(8);
        localShapeOperator.d();
        localShapeOperator.a(ShapeOperator.Shape.ARROW);
        if (localShapeOperator.c()) {
          w();
        }
        AEBaseDataReporter.a().g(3);
        return;
      case 6: 
        localShapeLayer.a(7);
        localShapeOperator.d();
        localShapeOperator.a(ShapeOperator.Shape.LINE);
        if (localShapeOperator.c()) {
          w();
        }
        AEBaseDataReporter.a().g(4);
        return;
      case 5: 
        localShapeLayer.a(10);
        localShapeOperator.d();
        localShapeOperator.a(ShapeOperator.Shape.OVAL_HOLLOW);
        if (localShapeOperator.c()) {
          w();
        }
        AEBaseDataReporter.a().g(2);
        return;
      case 4: 
        localShapeLayer.a(9);
        localShapeOperator.d();
        localShapeOperator.a(ShapeOperator.Shape.RECT_HOLLOW);
        if (localShapeOperator.c()) {
          w();
        }
        AEBaseDataReporter.a().g(1);
      }
    }
  }
  
  private boolean e(boolean paramBoolean)
  {
    b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBackPressed, buttonState:");
    localStringBuilder.append(this.C);
    localStringBuilder.append(",activeLayer:");
    localStringBuilder.append(this.v.getActiveLayer());
    SLog.b("DoodleLayout", localStringBuilder.toString());
    int i1 = this.C;
    if (i1 != 0)
    {
      if ((i1 == 2) && (!paramBoolean)) {
        return false;
      }
      n();
      p(0);
      if (!this.v.f())
      {
        SLog.b("DoodleLayout", "onBackPressed, resetDoodleView.");
        this.v.e();
      }
      return true;
    }
    return false;
  }
  
  private static void f(boolean paramBoolean)
  {
    if (paramBoolean) {
      StoryMediaEditNotifier.b().a();
    }
  }
  
  private void o(int paramInt)
  {
    if (this.i == null) {
      this.i = new GuideLineLayer(this.v);
    }
    Object localObject1 = (DoodleConfig)this.g.get(paramInt);
    if (localObject1 == null)
    {
      SLog.b("DoodleLayout", "initDoodleView for the %d video", Integer.valueOf(paramInt));
      Object localObject4 = getStrategy();
      localObject1 = (FaceLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a(FaceLayer.a);
      DynamicFaceLayer localDynamicFaceLayer = (DynamicFaceLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a("DynamicFaceLayer");
      Object localObject2 = (LineLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a("LineLayer");
      TextLayer localTextLayer = (TextLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a(TextLayer.a);
      Object localObject3 = (GuideLineLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a("GuideLineLayer");
      ShapeLayer localShapeLayer = (ShapeLayer)((DoodleLayout.NormalDoodleStategy)localObject4).a("ShapeLayer");
      a((LineLayer)localObject2);
      a(localShapeLayer);
      localObject4 = new DoodleConfig.Builder().a((DoodleStrategy)localObject4);
      int i1 = this.N;
      if (i1 == -1) {
        i1 = 480;
      }
      localObject4 = ((DoodleConfig.Builder)localObject4).a(i1);
      i1 = this.O;
      if (i1 == -1) {
        i1 = 640;
      }
      localObject4 = ((DoodleConfig.Builder)localObject4).b(i1).a();
      this.v.setDoodleConfig((DoodleConfig)localObject4);
      this.v.setDoodleLayout(this);
      EditVideoParams localEditVideoParams = this.p;
      if (localEditVideoParams != null)
      {
        this.v.a(localEditVideoParams);
        this.w.a(this.p);
      }
      localObject3 = new DoodleLayout.LayerCollection(localTextLayer, (LineLayer)localObject2, (FaceLayer)localObject1, localDynamicFaceLayer, (GuideLineLayer)localObject3, (EmptyLayer)this.v.a(EmptyLayer.a), localShapeLayer);
      this.g.put(paramInt, localObject4);
      this.h.put(paramInt, localObject3);
      if (localObject2 != null)
      {
        ((LineLayer)localObject2).a(new DoodleLayout.LineLayerTouchListener(this, null));
        ((LineLayer)localObject2).a(new DoodleLayout.10(this));
      }
      if (localObject1 != null) {
        ((FaceLayer)localObject1).a(this.G);
      }
      if (localDynamicFaceLayer != null) {
        localDynamicFaceLayer.a(this.G);
      }
      localObject2 = new DoodleLayout.11(this);
      if (localObject1 != null) {
        ((FaceLayer)localObject1).a((FaceLayer.LayerEventListener)localObject2);
      }
      if (localDynamicFaceLayer != null) {
        localDynamicFaceLayer.a((FaceLayer.LayerEventListener)localObject2);
      }
      if ((localTextLayer != null) && (!this.P))
      {
        localTextLayer.a(this.G);
        localTextLayer.a(new DoodleLayout.TextLayerListener(this, null));
      }
      this.J = ((PickLayer)this.v.a("PickLayer"));
    }
    else
    {
      this.v.setDoodleConfig((DoodleConfig)localObject1);
    }
    D();
    this.Z = false;
  }
  
  private void p(int paramInt)
  {
    a(paramInt, null);
  }
  
  private void setRubbishActive(boolean paramBoolean)
  {
    if (!this.as) {
      return;
    }
    if (this.at != paramBoolean)
    {
      this.at = paramBoolean;
      if (paramBoolean)
      {
        SLog.b("DoodleLayout", "rubbish active.");
        L();
        return;
      }
      SLog.b("DoodleLayout", "rubbish unActive.");
      M();
    }
  }
  
  /* Error */
  public Bitmap a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 340	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:v	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleView;
    //   4: invokevirtual 1155	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleView:getBitmapWidth	()I
    //   7: istore_3
    //   8: aload_0
    //   9: getfield 340	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:v	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleView;
    //   12: invokevirtual 1158	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleView:getBitmapHeight	()I
    //   15: istore 4
    //   17: iload_3
    //   18: ifle +511 -> 529
    //   21: iload 4
    //   23: ifgt +6 -> 29
    //   26: goto +503 -> 529
    //   29: aload_0
    //   30: getfield 213	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:ao	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   33: iconst_0
    //   34: invokevirtual 1161	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   37: ifeq +34 -> 71
    //   40: aload_0
    //   41: iload_3
    //   42: iload 4
    //   44: getstatic 1167	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   47: invokestatic 1173	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   50: putfield 1175	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:an	Landroid/graphics/Bitmap;
    //   53: goto +18 -> 71
    //   56: astore 7
    //   58: ldc_w 524
    //   61: ldc_w 1177
    //   64: aload 7
    //   66: invokestatic 1180	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   69: aconst_null
    //   70: areturn
    //   71: aload_0
    //   72: getfield 218	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:ap	Ljava/util/concurrent/locks/Lock;
    //   75: invokeinterface 1183 1 0
    //   80: aload_0
    //   81: getfield 1175	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:an	Landroid/graphics/Bitmap;
    //   84: astore 7
    //   86: aload 7
    //   88: ifnonnull +94 -> 182
    //   91: ldc_w 524
    //   94: ldc_w 1185
    //   97: invokestatic 1187	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_0
    //   101: getfield 226	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:aq	Ljava/util/concurrent/locks/Condition;
    //   104: ldc2_w 1188
    //   107: getstatic 1195	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   110: invokeinterface 1201 4 0
    //   115: ifne -35 -> 80
    //   118: ldc_w 524
    //   121: ldc_w 1203
    //   124: iconst_1
    //   125: anewarray 1205	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: invokestatic 1211	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   133: invokevirtual 1214	java/lang/Thread:getId	()J
    //   136: invokestatic 1219	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   139: aastore
    //   140: invokestatic 1222	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_0
    //   144: getfield 1224	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:ar	Ljava/lang/RuntimeException;
    //   147: ifnull -67 -> 80
    //   150: ldc_w 524
    //   153: ldc_w 1226
    //   156: aload_0
    //   157: getfield 1224	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:ar	Ljava/lang/RuntimeException;
    //   160: invokestatic 1228	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   163: goto -83 -> 80
    //   166: astore 7
    //   168: ldc_w 524
    //   171: ldc_w 1230
    //   174: aload 7
    //   176: invokestatic 1228	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   179: goto -99 -> 80
    //   182: aload_0
    //   183: getfield 1175	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:an	Landroid/graphics/Bitmap;
    //   186: astore 7
    //   188: aload_0
    //   189: aconst_null
    //   190: putfield 1175	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:an	Landroid/graphics/Bitmap;
    //   193: new 1232	android/graphics/Canvas
    //   196: dup
    //   197: aload 7
    //   199: invokespecial 1235	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   202: astore 8
    //   204: new 1237	android/graphics/Paint
    //   207: dup
    //   208: invokespecial 1238	android/graphics/Paint:<init>	()V
    //   211: astore 9
    //   213: aload 9
    //   215: new 1240	android/graphics/PorterDuffXfermode
    //   218: dup
    //   219: getstatic 1246	android/graphics/PorterDuff$Mode:CLEAR	Landroid/graphics/PorterDuff$Mode;
    //   222: invokespecial 1249	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   225: invokevirtual 1253	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   228: pop
    //   229: aload 8
    //   231: aload 9
    //   233: invokevirtual 1257	android/graphics/Canvas:drawPaint	(Landroid/graphics/Paint;)V
    //   236: aload_0
    //   237: getfield 176	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:h	Landroid/util/SparseArray;
    //   240: iload_1
    //   241: invokevirtual 1012	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   244: checkcast 1077	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout$LayerCollection
    //   247: astore 9
    //   249: aload 9
    //   251: ifnonnull +35 -> 286
    //   254: ldc_w 524
    //   257: ldc_w 1259
    //   260: iconst_1
    //   261: anewarray 1205	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: iload_1
    //   267: invokestatic 1022	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aastore
    //   271: invokestatic 1261	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: aload_0
    //   275: getfield 218	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:ap	Ljava/util/concurrent/locks/Lock;
    //   278: invokeinterface 1264 1 0
    //   283: aload 7
    //   285: areturn
    //   286: invokestatic 1269	android/os/SystemClock:uptimeMillis	()J
    //   289: lstore 5
    //   291: aload 9
    //   293: getfield 1272	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout$LayerCollection:b	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/LineLayer;
    //   296: astore 10
    //   298: aload 10
    //   300: getfield 414	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/LineLayer:b	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleOpController;
    //   303: invokevirtual 1274	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleOpController:g	()Z
    //   306: ifeq +21 -> 327
    //   309: ldc_w 524
    //   312: ldc_w 1276
    //   315: invokestatic 1187	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: aload 10
    //   320: getfield 414	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/LineLayer:b	Lcom/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleOpController;
    //   323: iload_3
    //   324: invokevirtual 1278	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleOpController:c	(I)V
    //   327: aload_0
    //   328: getfield 459	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:p	Lcom/tencent/mobileqq/editor/params/EditVideoParams;
    //   331: ifnull +20 -> 351
    //   334: aload_0
    //   335: getfield 459	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:p	Lcom/tencent/mobileqq/editor/params/EditVideoParams;
    //   338: invokevirtual 857	com/tencent/mobileqq/editor/params/EditVideoParams:b	()Z
    //   341: ifeq +10 -> 351
    //   344: aload 10
    //   346: aload 8
    //   348: invokevirtual 1281	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/LineLayer:c	(Landroid/graphics/Canvas;)V
    //   351: new 1283	java/util/LinkedList
    //   354: dup
    //   355: aload 9
    //   357: getfield 1285	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout$LayerCollection:h	Ljava/util/ArrayList;
    //   360: invokespecial 1288	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   363: astore 9
    //   365: aload 9
    //   367: aload_0
    //   368: getfield 242	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:au	Ljava/util/Comparator;
    //   371: invokestatic 1294	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   374: aload 9
    //   376: invokevirtual 1297	java/util/LinkedList:size	()I
    //   379: iconst_1
    //   380: isub
    //   381: istore_1
    //   382: iload_1
    //   383: iflt +35 -> 418
    //   386: aload 9
    //   388: iload_1
    //   389: invokevirtual 1298	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   392: checkcast 1300	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/base/BaseLayer
    //   395: astore 10
    //   397: aload 10
    //   399: ifnull +160 -> 559
    //   402: aload 10
    //   404: aload 8
    //   406: aload 10
    //   408: invokevirtual 1302	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/base/BaseLayer:w	()F
    //   411: iload_2
    //   412: invokevirtual 1305	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/base/BaseLayer:a	(Landroid/graphics/Canvas;FZ)V
    //   415: goto +144 -> 559
    //   418: iload_2
    //   419: ifeq +52 -> 471
    //   422: aload 9
    //   424: invokevirtual 1297	java/util/LinkedList:size	()I
    //   427: iconst_1
    //   428: isub
    //   429: istore_1
    //   430: iload_1
    //   431: iflt +40 -> 471
    //   434: aload 9
    //   436: iload_1
    //   437: invokevirtual 1298	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   440: checkcast 1300	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/base/BaseLayer
    //   443: astore 10
    //   445: aload 10
    //   447: ifnull +119 -> 566
    //   450: aload 10
    //   452: instanceof 1041
    //   455: ifeq +111 -> 566
    //   458: aload 10
    //   460: checkcast 1041	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/DynamicFaceLayer
    //   463: aload 8
    //   465: invokevirtual 1306	com/tencent/aelight/camera/aioeditor/takevideo/doodle/layer/DynamicFaceLayer:c	(Landroid/graphics/Canvas;)V
    //   468: goto +3 -> 471
    //   471: new 955	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 956	java/lang/StringBuilder:<init>	()V
    //   478: astore 8
    //   480: aload 8
    //   482: ldc_w 1308
    //   485: invokevirtual 962	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload 8
    //   491: invokestatic 1269	android/os/SystemClock:uptimeMillis	()J
    //   494: lload 5
    //   496: lsub
    //   497: invokevirtual 1311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: ldc_w 524
    //   504: aload 8
    //   506: invokevirtual 978	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 981	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: goto -238 -> 274
    //   515: astore 7
    //   517: aload_0
    //   518: getfield 218	com/tencent/aelight/camera/aioeditor/takevideo/doodle/ui/doodle/DoodleLayout:ap	Ljava/util/concurrent/locks/Lock;
    //   521: invokeinterface 1264 1 0
    //   526: aload 7
    //   528: athrow
    //   529: ldc_w 524
    //   532: ldc_w 1313
    //   535: iconst_2
    //   536: anewarray 1205	java/lang/Object
    //   539: dup
    //   540: iconst_0
    //   541: iload_3
    //   542: invokestatic 1022	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   545: aastore
    //   546: dup
    //   547: iconst_1
    //   548: iload 4
    //   550: invokestatic 1022	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   553: aastore
    //   554: invokestatic 1261	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public void a()
  {
    this.as = false;
  }
  
  public void a(float paramFloat)
  {
    Object localObject = getLineLayer();
    if (localObject == null) {
      return;
    }
    paramFloat = b(paramFloat);
    PureOperator localPureOperator = (PureOperator)((LineLayer)localObject).b(101);
    if (localPureOperator != null) {
      localPureOperator.a(paramFloat);
    }
    ((LineLayer)localObject).b.h().a(paramFloat);
    localObject = (MosaicOperator)((LineLayer)localObject).b(104);
    if (localObject != null) {
      ((MosaicOperator)localObject).a(paramFloat);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("DoodleLay_State", 4).edit();
    localEditor.putInt("Line_LastType", paramInt1);
    localEditor.putInt("Line_LastSubType", paramInt2);
    localEditor.commit();
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    SLog.b("DoodleLayout", String.format("changeDoodleViewSize, width: %d, height: %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    setDoodleBitmapMaxSize(paramInt1, paramInt2);
    int i1 = this.v.getWidth();
    int i2 = this.v.getHeight();
    Object localObject = (RelativeLayout.LayoutParams)this.v.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
    ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
    this.v.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (!paramBoolean) {
      this.v.h();
    }
    this.v.i();
    this.v.onSizeChanged(paramInt1, paramInt2, i1, i2);
    localObject = this.w;
    if (localObject != null) {
      ((DoodleEditView)localObject).a(paramInt1, paramInt2);
    }
    localObject = (MosaicOperator)getLineLayer().b(104);
    if (localObject != null) {
      ((MosaicOperator)localObject).e();
    }
    if (this.V)
    {
      localObject = (RelativeLayout.LayoutParams)this.t.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
      ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
      this.t.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyOutsideState---outsideState=");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("DoodleLayout", ((StringBuilder)localObject).toString());
    localObject = this.y;
    if (localObject != null) {
      ((DoodleLayout.DoodleEventListener)localObject).b(paramInt, paramObject);
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.ap.lock();
      if (this.an == null)
      {
        this.ar = null;
        try
        {
          this.an = paramBitmap;
          this.aq.signal();
          return;
        }
        finally
        {
          this.ap.unlock();
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
      paramDynamicTextItem.p();
    }
    this.z = new DoodleLayout.EditDialogListener(this, null);
    this.A = new EditTextDialog(super.getContext());
    localObject = this.W;
    if ((localObject != null) && (((EditVideoDoodle)localObject).t.Z != null)) {
      this.A.x = this.W.t.Z;
    }
    b(paramDynamicTextItem, paramInt1, paramInt2, paramBoolean);
    invalidate();
    paramInt1 = this.C;
    if (paramInt1 != 0) {
      if (paramInt1 == 1)
      {
        setViewsVisible(new View[] { this.v });
        setDoodleGLViewVisibility(0);
      }
      else if (paramInt1 == 2)
      {
        H();
        getLineLayer().d(false);
      }
    }
    paramInt1 = this.C;
    if ((paramInt1 != 9) && (paramInt1 != 11)) {
      p(3);
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
    FaceLayer.LayerParams localLayerParams = DoodleUtil.a(paramItem, this.v.getWidth(), this.v.getHeight(), paramFloat1, paramFloat2);
    if (localLayerParams != null)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramItem.e != null)
      {
        bool1 = bool2;
        if ((paramItem.e instanceof URLDrawable))
        {
          File localFile = ((URLDrawable)paramItem.e).getFileInLocal();
          bool1 = bool2;
          if (localFile != null)
          {
            bool1 = bool2;
            if (localFile.exists())
            {
              FaceLayer localFaceLayer = getFaceLayer();
              localObject = localFaceLayer;
              if (paramItem.j == 1)
              {
                EditVideoParams localEditVideoParams = this.p;
                if (localEditVideoParams != null)
                {
                  localObject = localFaceLayer;
                  if (!localEditVideoParams.c()) {}
                }
                else
                {
                  localObject = getDynamicFaceLayer();
                }
              }
              bool1 = ((FaceLayer)localObject).a(paramItem.i, paramItem.c, paramItem.e, localLayerParams, localFile.getAbsolutePath(), true, paramItem.j, getFrom());
            }
          }
        }
      }
      if (bool1)
      {
        this.y.a(paramItem);
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
    FaceLayer.LayerParams localLayerParams = DoodleUtil.a(paramItem, this.v.getWidth(), this.v.getHeight(), paramFloat1, paramFloat2, paramFloat3);
    if (localLayerParams != null)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramItem.e != null)
      {
        bool1 = bool2;
        if ((paramItem.e instanceof URLDrawable))
        {
          File localFile = ((URLDrawable)paramItem.e).getFileInLocal();
          bool1 = bool2;
          if (localFile != null)
          {
            bool1 = bool2;
            if (localFile.exists())
            {
              localObject = getFaceLayer();
              if (((paramItem.j == 1) && (this.p == null)) || (this.p.c())) {
                localObject = getDynamicFaceLayer();
              }
              bool1 = ((FaceLayer)localObject).a(paramItem.i, paramItem.c, paramItem.e, localLayerParams, localFile.getAbsolutePath(), true, paramItem.j, getFrom(), paramSegmentKeeper);
            }
          }
        }
      }
      if (bool1)
      {
        this.y.a(paramItem);
        VideoEditReport.a("0X80076CE");
        f(this.k);
      }
    }
    else
    {
      SLog.e("DoodleLayout", "create FaceLayer.ItemParams failed.");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.q;
    if ((localObject != null) && (paramBoolean))
    {
      localObject = ((RelativeLayout)localObject).getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = UIUtils.a(getContext(), 48.0F);
        this.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3)
  {
    GuideLineLayer localGuideLineLayer = this.i;
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
      ((StringBuilder)localObject).append(this.ad);
      QLog.d("DoodleLayout", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.ad;
    if (localObject == null) {
      return;
    }
    if (paramBoolean4) {
      ((StoryGuideLineView)localObject).a(true);
    } else {
      ((StoryGuideLineView)localObject).a();
    }
    if (paramBoolean2) {
      this.ad.b();
    } else {
      this.ad.c();
    }
    if (paramBoolean1)
    {
      this.ad.d();
      return;
    }
    this.ad.e();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (this.ae) {
      return;
    }
    if (this.W == null)
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
    this.W.t.a(Message.obtain(null, 15, 0, 0, new EditVideoLimitRegion.LimitMessage(paramBoolean3, paramBoolean4, paramBoolean2, paramBoolean1, paramBoolean5)));
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
    if ((paramFloat1 < f1) || (paramFloat2 < f1) || (paramFloat1 > this.I.width() + i1) || (paramFloat2 > this.I.height() + i1 + paramFloat3)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(int paramInt)
  {
    return this.e.get(paramInt, false);
  }
  
  public boolean a(TextLayer.TextItem paramTextItem, boolean paramBoolean)
  {
    Object localObject = this.w;
    if ((localObject != null) && (paramTextItem != null))
    {
      if (paramBoolean) {
        ((DoodleEditView)localObject).setVisibility(0);
      }
      E();
      this.w.a.a(paramTextItem);
      paramTextItem.M = true;
      paramTextItem.U.lockData(this.w.b() ^ true);
      this.w.requestLayout();
      localObject = this.w.getTextFaceEditLayer();
      if ((localObject != null) && (((TextFaceEditLayer)localObject).f != null) && (paramTextItem.c != null) && (paramTextItem.c.a()))
      {
        paramTextItem.c.r();
        ((TextFaceEditLayer)localObject).f.a(paramTextItem, paramTextItem.c.g(), 0, 0.0F, 0.0F);
      }
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return;
    }
    throw new IllegalStateException("Only the original thread that created a view hierarchy can touch its views.");
  }
  
  public void b(boolean paramBoolean)
  {
    this.J.d(paramBoolean);
  }
  
  public boolean b(int paramInt)
  {
    return this.f.get(paramInt, false);
  }
  
  public void c()
  {
    LineLayer localLineLayer = getLineLayer();
    if (localLineLayer != null) {
      localLineLayer.h();
    }
  }
  
  public void c(float paramFloat)
  {
    ShapeLayer localShapeLayer = getShapeLayer();
    if (localShapeLayer == null) {
      return;
    }
    b(paramFloat);
    localShapeLayer.i().a(paramFloat);
  }
  
  public void c(int paramInt)
  {
    Object localObject = getLineLayer();
    if (localObject == null) {
      return;
    }
    localObject = (PureOperator)((LineLayer)localObject).b(101);
    if (localObject != null) {
      ((PureOperator)localObject).a(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    DynamicFaceLayer localDynamicFaceLayer = getDynamicFaceLayer();
    if (localDynamicFaceLayer != null) {
      localDynamicFaceLayer.a(paramBoolean);
    }
  }
  
  public void d()
  {
    ThreadManager.getUIHandler().post(new DoodleLayout.9(this));
  }
  
  public void d(int paramInt)
  {
    ShapeLayer localShapeLayer = getShapeLayer();
    if (localShapeLayer == null) {
      return;
    }
    localShapeLayer.i().a(paramInt);
  }
  
  public boolean e()
  {
    DoodleLayout.DoodleEventListener localDoodleEventListener = this.y;
    if (localDoodleEventListener != null) {
      return localDoodleEventListener.p();
    }
    return true;
  }
  
  public byte[] e(int paramInt)
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.h.get(paramInt);
    if (localLayerCollection == null) {
      return null;
    }
    return localLayerCollection.b.p();
  }
  
  public Bitmap f(int paramInt)
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.h.get(paramInt);
    if (localLayerCollection != null) {
      return localLayerCollection.b.q();
    }
    return null;
  }
  
  public void f()
  {
    b();
    LineLayer localLineLayer = getLineLayer();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("undo, activeLayer:");
    ((StringBuilder)localObject).append(this.v.getActiveLayer());
    ((StringBuilder)localObject).append(",pathCount:");
    ((StringBuilder)localObject).append(localLineLayer.b.c());
    SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
    localLineLayer.j();
    int i1 = localLineLayer.b.c();
    boolean bool = false;
    if (i1 == 0) {
      this.s.setUndoViewEnable(false);
    } else {
      this.s.setUndoViewEnable(true);
    }
    localObject = this.ak;
    if (localLineLayer.b.c() > 0) {
      bool = true;
    }
    ((DoodlePanel)localObject).setUndoEnabled(bool);
  }
  
  public String g(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.h.get(paramInt);
    if (localObject == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    localObject = ((DoodleLayout.LayerCollection)localObject).a;
    if ((((TextLayer)localObject).t != null) && (!((TextLayer)localObject).t.isEmpty()))
    {
      localObject = ((TextLayer)localObject).t.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)((Iterator)localObject).next();
        if (localTextItem.c != null)
        {
          localObject = localTextItem.c.i().toString();
          return ((String)localObject).substring(0, ((String)localObject).length() - 1);
        }
      }
    }
    return null;
  }
  
  public void g()
  {
    b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onFacePressed, buttonState:");
    ((StringBuilder)localObject).append(this.C);
    ((StringBuilder)localObject).append(",activeLayer:");
    ((StringBuilder)localObject).append(this.v.getActiveLayer());
    SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
    VideoEditReport.a("0X80076BA", VideoEditReport.d);
    int i1 = this.C;
    if (i1 != 0)
    {
      if (i1 == 3)
      {
        setState(1);
        this.A.a(false);
        localObject = this.w;
        if (localObject != null) {
          ((DoodleEditView)localObject).a(true);
        }
        return;
      }
      if (i1 == 2)
      {
        getLineLayer().d(false);
        H();
      }
      else if (i1 == 9)
      {
        getShapeLayer().d(false);
        J();
      }
    }
    setState(1);
  }
  
  public String getAllDoodleText()
  {
    Object localObject = getTextLayer();
    if ((localObject != null) && (((TextLayer)localObject).t != null) && (!((TextLayer)localObject).t.isEmpty()))
    {
      JSONArray localJSONArray = new JSONArray();
      localObject = ((TextLayer)localObject).t.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)((Iterator)localObject).next();
        if ((localTextItem.c != null) && (localTextItem.c.i() != null)) {
          localJSONArray.put(localTextItem.c.i().toString());
        }
      }
      return localJSONArray.toString();
    }
    return "";
  }
  
  public int getBusinessId()
  {
    EditVideoParams localEditVideoParams = this.p;
    if (localEditVideoParams == null) {
      return 0;
    }
    return localEditVideoParams.h();
  }
  
  protected int getControlBarHeight()
  {
    return ScreenUtil.dip2px(65.0F);
  }
  
  public int getCurrentState()
  {
    return this.C;
  }
  
  public Bitmap getDoodleBitmap()
  {
    return this.v.getDoodleBitmap();
  }
  
  public String getDoodleStickerId()
  {
    String str = "empty";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject = getFaceLayer();
      FaceLayer.FaceItem localFaceItem;
      if ((localObject != null) && (((FaceLayer)localObject).b != null) && (!((FaceLayer)localObject).b.isEmpty()))
      {
        localObject = ((FaceLayer)localObject).b.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localFaceItem = (FaceLayer.FaceItem)((Iterator)localObject).next();
          if ((localFaceItem != null) && (!TextUtils.isEmpty(localFaceItem.o)))
          {
            localStringBuilder.append(localFaceItem.o);
            localStringBuilder.append(",");
          }
        }
      }
      localObject = getDynamicFaceLayer();
      if ((localObject != null) && (((DynamicFaceLayer)localObject).b != null) && (!((DynamicFaceLayer)localObject).b.isEmpty()))
      {
        localObject = ((DynamicFaceLayer)localObject).b.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localFaceItem = (FaceLayer.FaceItem)((Iterator)localObject).next();
          if ((localFaceItem != null) && (!TextUtils.isEmpty(localFaceItem.o)))
          {
            localStringBuilder.append(localFaceItem.o);
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
  
  public String getDoodleTextId()
  {
    String str = "empty";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = getTextLayer();
      if ((localObject1 != null) && (((TextLayer)localObject1).t != null) && (!((TextLayer)localObject1).t.isEmpty()))
      {
        localObject1 = ((TextLayer)localObject1).t.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TextLayer.TextItem)((Iterator)localObject1).next();
          if (((TextLayer.TextItem)localObject2).c != null)
          {
            localObject2 = DynamicTextBuilder.a(((TextLayer.TextItem)localObject2).c.k());
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
  
  public DynamicFaceLayer getDynamicFaceLayer()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.h.get(this.d);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.d) });
      return null;
    }
    return localLayerCollection.d;
  }
  
  public EditPicRawImage getEditPicRawImage()
  {
    return this.W.t.R;
  }
  
  public Bitmap getEditPicRawImageBitmap()
  {
    DoodleLayout.DoodleBtnOperationHelper localDoodleBtnOperationHelper = this.E;
    if (localDoodleBtnOperationHelper == null) {
      return null;
    }
    return localDoodleBtnOperationHelper.q();
  }
  
  public EmptyLayer getEmptyLayer()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.h.get(this.d);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.d) });
      return null;
    }
    return localLayerCollection.e;
  }
  
  public FaceLayer getFaceLayer()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.h.get(this.d);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.d) });
      return null;
    }
    return localLayerCollection.c;
  }
  
  public IFaceSelectedListener getFaceSelectedListener()
  {
    return this.j;
  }
  
  public int getFrom()
  {
    DoodleEditView localDoodleEditView = this.w;
    int i2 = 1;
    int i1 = i2;
    if (localDoodleEditView != null)
    {
      if (localDoodleEditView.getFrom() == 1) {
        return 1;
      }
      i1 = i2;
      if (this.w.getFrom() == 0) {
        i1 = 0;
      }
    }
    return i1;
  }
  
  public String getGraffitiTypesForReport()
  {
    if (getLineLayer() != null) {
      return getLineLayer().b.l();
    }
    return "";
  }
  
  public LineLayer getLineLayer()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.h.get(this.d);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.d) });
      return null;
    }
    return localLayerCollection.b;
  }
  
  public String getMarkTypesForReport()
  {
    if (getShapeLayer() != null) {
      return getShapeLayer().i().j();
    }
    return "";
  }
  
  public ShapeLayer getShapeLayer()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.h.get(this.d);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.d) });
      return null;
    }
    return localLayerCollection.g;
  }
  
  public String getStickerIdsForReport()
  {
    String str1 = "";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject = getFaceLayer();
      Iterator localIterator;
      FaceLayer.FaceItem localFaceItem;
      String str2;
      if ((localObject != null) && (((FaceLayer)localObject).b != null) && (!((FaceLayer)localObject).b.isEmpty()))
      {
        localIterator = ((FaceLayer)localObject).b.iterator();
        while (localIterator.hasNext())
        {
          localFaceItem = (FaceLayer.FaceItem)localIterator.next();
          if ((localFaceItem != null) && (!TextUtils.isEmpty(localFaceItem.o)))
          {
            str2 = localFaceItem.n;
            localObject = str2;
            if (TextUtils.isEmpty(str2)) {
              localObject = "none";
            }
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("_");
            localStringBuilder.append(localFaceItem.o);
            localStringBuilder.append("|");
          }
        }
      }
      localObject = getDynamicFaceLayer();
      if ((localObject != null) && (((DynamicFaceLayer)localObject).b != null) && (!((DynamicFaceLayer)localObject).b.isEmpty()))
      {
        localIterator = ((DynamicFaceLayer)localObject).b.iterator();
        while (localIterator.hasNext())
        {
          localFaceItem = (FaceLayer.FaceItem)localIterator.next();
          if ((localFaceItem != null) && (!TextUtils.isEmpty(localFaceItem.o)))
          {
            str2 = localFaceItem.n;
            localObject = str2;
            if (TextUtils.isEmpty(str2)) {
              localObject = "none";
            }
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("_");
            localStringBuilder.append(localFaceItem.o);
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
  
  protected DoodleLayout.NormalDoodleStategy getStrategy()
  {
    return new DoodleLayout.NormalDoodleStategy(new BaseLayer[] { this.i, new PickLayer(this.v), new FaceLayer(this.v), new DynamicFaceLayer(this.v), new LineLayer(this.v), new ShapeLayer(this.v), new TextLayer(this.v) });
  }
  
  public String getTextIdsForReport()
  {
    String str = "";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = getTextLayer();
      if ((localObject1 != null) && (((TextLayer)localObject1).t != null) && (!((TextLayer)localObject1).t.isEmpty()))
      {
        localObject1 = ((TextLayer)localObject1).t.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (TextLayer.TextItem)((Iterator)localObject1).next();
          if (((TextLayer.TextItem)localObject2).c != null)
          {
            localObject2 = DynamicTextBuilder.a(((TextLayer.TextItem)localObject2).c.k());
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
  
  public TextLayer getTextLayer()
  {
    DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.h.get(this.d);
    if (localLayerCollection == null)
    {
      SLog.d("DoodleLayout", "can not find LayerCollection by video index %d", new Object[] { Integer.valueOf(this.d) });
      return null;
    }
    return localLayerCollection.a;
  }
  
  public int getTotalDoodleCount()
  {
    int i1 = 0;
    int i2 = 0;
    while (i1 < this.h.size())
    {
      DoodleLayout.LayerCollection localLayerCollection = (DoodleLayout.LayerCollection)this.h.valueAt(i1);
      i2 = i2 + localLayerCollection.a.q() + localLayerCollection.b.o() + localLayerCollection.c.g() + localLayerCollection.d.g() + localLayerCollection.g.j();
      i1 += 1;
    }
    return i2;
  }
  
  public void h()
  {
    if (this.C == 3)
    {
      setState(0);
      this.A.a(false);
      DoodleEditView localDoodleEditView = this.w;
      if (localDoodleEditView != null) {
        localDoodleEditView.a(true);
      }
    }
  }
  
  public boolean h(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.h.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).h.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((BaseLayer)((Iterator)localObject).next()).c()) {
          return false;
        }
      }
    }
    return true;
  }
  
  public int i(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.h.get(paramInt);
    if (localObject != null)
    {
      paramInt = ((DoodleLayout.LayerCollection)localObject).a.q();
      int i1 = ((DoodleLayout.LayerCollection)localObject).b.o();
      int i2 = ((DoodleLayout.LayerCollection)localObject).c.g();
      int i3 = ((DoodleLayout.LayerCollection)localObject).d.g();
      int i4 = ((DoodleLayout.LayerCollection)localObject).g.j();
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
  
  public void i()
  {
    if (this.C == 3)
    {
      setState(0);
      p(0);
      this.A.a(false);
      DoodleEditView localDoodleEditView = this.w;
      if (localDoodleEditView != null) {
        localDoodleEditView.a(true);
      }
    }
  }
  
  public void j()
  {
    if (this.C == 3)
    {
      setState(0);
      p(0);
      this.A.a(false);
      DoodleEditView localDoodleEditView = this.w;
      if (localDoodleEditView != null) {
        localDoodleEditView.a(true);
      }
    }
  }
  
  public int[] j(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.h.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).b.b.q();
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
  
  public List<String> k(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.h.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).b.b.r();
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
  
  public void k()
  {
    b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onTextPressed, buttonState:");
    ((StringBuilder)localObject).append(this.C);
    ((StringBuilder)localObject).append(",activeLayer:");
    ((StringBuilder)localObject).append(this.v.getActiveLayer());
    SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
    localObject = getTextLayer().c(getFrom());
    a(getTextLayer().j(), false);
    if (localObject != null)
    {
      a((DynamicTextItem)localObject, 0, 0);
      int i1 = this.C;
      if (i1 == 2)
      {
        getLineLayer().d(false);
        H();
      }
      else if (i1 == 9)
      {
        getShapeLayer().d(false);
        J();
      }
      setState(3);
      return;
    }
    QQToast.makeText(getContext(), getContext().getString(2131896291), 0).show();
    ThreadManager.getUIHandler().post(new DoodleLayout.14(this));
  }
  
  public void l()
  {
    b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLinePressed, buttonState:");
    ((StringBuilder)localObject).append(this.C);
    ((StringBuilder)localObject).append(",activeLayer:");
    ((StringBuilder)localObject).append(this.v.getActiveLayer());
    SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
    VideoEditReport.a("0X80076B8", VideoEditReport.d);
    getShapeLayer().i().c();
    localObject = getLineLayer();
    I();
    ((LineLayer)localObject).d(true);
    ((LineLayer)localObject).a(false);
    y();
    if (((LineLayer)localObject).b.c() > 0) {
      this.s.setUndoViewEnable(true);
    } else {
      this.s.setUndoViewEnable(false);
    }
    DoodlePanel localDoodlePanel = this.ak;
    boolean bool;
    if (((LineLayer)localObject).b.c() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    localDoodlePanel.setUndoEnabled(bool);
    int i1 = this.C;
    if (i1 != 0)
    {
      if (i1 == 3)
      {
        setState(2);
        this.A.a(false);
        localObject = this.w;
        if (localObject != null) {
          ((DoodleEditView)localObject).a(true);
        }
        return;
      }
      if (i1 == 1)
      {
        setViewsVisible(new View[] { this.v });
        setDoodleGLViewVisibility(0);
      }
      else if (i1 == 9)
      {
        J();
      }
    }
    setState(2);
  }
  
  public int[] l(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.h.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).c.h();
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
  
  public Map<String, List<String>> m(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.h.get(paramInt);
    if (localObject != null)
    {
      localObject = ((DoodleLayout.LayerCollection)localObject).c.q;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Using face map:");
      localStringBuilder.append(localObject.toString());
      SLog.b("DoodleLayout", localStringBuilder.toString());
      return Collections.unmodifiableMap((Map)localObject);
    }
    return Collections.emptyMap();
  }
  
  public void m()
  {
    b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onShapePressed, buttonState:");
    ((StringBuilder)localObject).append(this.C);
    ((StringBuilder)localObject).append(",activeLayer:");
    ((StringBuilder)localObject).append(this.v.getActiveLayer());
    SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
    VideoEditReport.a("0X80076B8", VideoEditReport.d);
    localObject = getShapeLayer();
    K();
    ((ShapeLayer)localObject).d(true);
    ((ShapeLayer)localObject).a(false);
    ((ShapeLayer)localObject).i().d();
    y();
    this.ak.setUndoEnabled(false);
    int i1 = this.C;
    if (i1 != 0)
    {
      if (i1 == 3)
      {
        setState(9);
        this.A.a(false);
        localObject = this.w;
        if (localObject != null) {
          ((DoodleEditView)localObject).a(true);
        }
        return;
      }
      if (i1 == 1)
      {
        setViewsVisible(new View[] { this.v });
        setDoodleGLViewVisibility(0);
      }
      else if (i1 == 2)
      {
        H();
      }
    }
    setState(9);
  }
  
  public List<FaceLayer.FaceItem> n(int paramInt)
  {
    Object localObject = (DoodleLayout.LayerCollection)this.h.get(paramInt);
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(((DoodleLayout.LayerCollection)localObject).c.r);
      localArrayList.addAll(((DoodleLayout.LayerCollection)localObject).d.r);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Using poi list:");
      ((StringBuilder)localObject).append(localArrayList.toString());
      SLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
      return Collections.unmodifiableList(localArrayList);
    }
    return Collections.emptyList();
  }
  
  public void n()
  {
    b();
    setViewsVisible(new View[] { this.v, this.x });
    setDoodleGLViewVisibility(0);
    H();
    J();
    setViewsInVisible(new View[] { this.q });
    this.s.setUndoViewEnable(false);
    this.ak.setUndoEnabled(false);
    this.al.setUndoEnabled(false);
    if ((this.C == 3) && (this.A != null))
    {
      setState(0);
      this.A.a(false);
      DoodleEditView localDoodleEditView = this.w;
      if (localDoodleEditView != null) {
        localDoodleEditView.a(true);
      }
    }
    else
    {
      setState(0);
      this.v.e();
      this.x.e();
    }
  }
  
  public void o()
  {
    this.v.j();
  }
  
  public void onClick(View paramView)
  {
    if (this.Q > System.currentTimeMillis()) {
      return;
    }
    if (!e(false))
    {
      paramView = this.y;
      if (paramView != null) {
        paramView.n();
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.v.c();
    this.x.c();
    if (this.V) {
      this.u.b();
    }
    this.q.clearAnimation();
    super.onDetachedFromWindow();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    BaseLayer localBaseLayer = this.v.getActiveLayer();
    Object localObject = this.J;
    boolean bool = true;
    if (localBaseLayer == localObject)
    {
      p(7);
      localBaseLayer = this.v.a(paramMotionEvent);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onTouchEvent--findActiveLayer: ");
      ((StringBuilder)localObject).append(localBaseLayer);
      AEQLog.b("DoodleLayout", ((StringBuilder)localObject).toString());
      this.v.setActiveLayer(localBaseLayer);
      this.v.setTopLevelLayer(localBaseLayer);
      localBaseLayer.d(paramMotionEvent);
      this.av = true;
      return true;
    }
    if (this.av)
    {
      this.v.getActiveLayer().d(paramMotionEvent);
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        this.av = false;
        return true;
      }
    }
    else
    {
      this.av = false;
      bool = false;
    }
    return bool;
  }
  
  public boolean p()
  {
    return this.v.g();
  }
  
  public void q()
  {
    this.P = true;
    int i1 = 0;
    while (i1 < this.h.size())
    {
      TextLayer localTextLayer = ((DoodleLayout.LayerCollection)this.h.valueAt(i1)).a;
      localTextLayer.a(null);
      localTextLayer.a(null);
      i1 += 1;
    }
  }
  
  public void r()
  {
    int i1 = this.C;
    Boolean localBoolean = Boolean.valueOf(false);
    if (i1 == 6)
    {
      a(2, localBoolean);
      setState(2);
      if (getLineLayer().b.c() > 0) {
        this.s.setUndoViewEnable(true);
      } else {
        this.s.setUndoViewEnable(false);
      }
      I();
      if (QLog.isColorLevel()) {
        QLog.d("Personality", 2, "exitFullScreen");
      }
    }
    else if (i1 == 11)
    {
      a(9, localBoolean);
      setState(9);
      K();
      if (QLog.isColorLevel()) {
        QLog.d("Personality", 2, "exitFullScreen for shape");
      }
    }
  }
  
  public boolean s()
  {
    DoodleView localDoodleView = this.v;
    return (localDoodleView != null) && (localDoodleView.getActiveLayer() == getEmptyLayer());
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
      this.N = paramInt1;
      this.O = paramInt2;
      int i1 = 0;
      while (i1 < this.g.size())
      {
        ((DoodleConfig)this.g.get(i1)).b = paramInt1;
        ((DoodleConfig)this.g.get(i1)).c = paramInt2;
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
    this.E = paramDoodleBtnOperationHelper;
  }
  
  public void setDoodleEventListener(DoodleLayout.DoodleEventListener paramDoodleEventListener)
  {
    this.y = paramDoodleEventListener;
  }
  
  @TargetApi(14)
  public void setDoodleGLViewVisibility(int paramInt)
  {
    if (!this.V) {
      return;
    }
    if (!this.B)
    {
      SLog.b("DoodleLayout", "setDoodleGLViewVisibility, soload failed, glview default invisible");
      this.u.setVisibility(4);
      return;
    }
    this.u.a(paramInt);
  }
  
  public void setEditMode(boolean paramBoolean)
  {
    this.ae = true;
    this.af = paramBoolean;
  }
  
  public void setEditVideoDoodle(EditVideoDoodle paramEditVideoDoodle)
  {
    this.W = paramEditVideoDoodle;
  }
  
  public void setEditVideoParams(EditVideoParams paramEditVideoParams)
  {
    this.p = paramEditVideoParams;
    this.v.a(paramEditVideoParams);
    this.w.a(paramEditVideoParams);
    c = this.p.b();
    F();
  }
  
  public void setLocation(TroopBarPOI paramTroopBarPOI)
  {
    if (this.D == null)
    {
      SLog.e("DoodleLayout", "ClickFaceItem not found.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLocation: clickItem-->");
    localStringBuilder.append(this.D);
    SLog.b("DoodleLayout", localStringBuilder.toString());
    getFaceLayer().a(this.D, paramTroopBarPOI);
    this.D = null;
  }
  
  public void setMosaicSize(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 1)
    {
      SLog.e("DoodleLayout", "MosaicSize little than 1.");
      i1 = 1;
    }
    this.K = i1;
    paramInt = 0;
    while (paramInt < this.h.size())
    {
      MosaicOperator localMosaicOperator = (MosaicOperator)((DoodleLayout.LayerCollection)this.h.valueAt(paramInt)).b.b(103);
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
      this.L = paramInt1;
      this.M = paramInt2;
      int i1 = 0;
      while (i1 < this.h.size())
      {
        localObject = (MosaicOperator)((DoodleLayout.LayerCollection)this.h.valueAt(i1)).b.b(103);
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
    this.R = paramOnTextDialogShowListener;
  }
  
  public void setRecording(boolean paramBoolean)
  {
    this.Z = paramBoolean;
  }
  
  protected void setState(int paramInt)
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
    this.C = paramInt;
  }
  
  public void setTimeStamp(long paramLong, boolean paramBoolean)
  {
    if ((!this.ac) || (paramBoolean))
    {
      Object localObject = this.v;
      if (localObject != null) {
        ((DoodleView)localObject).setTimeStamp(paramLong);
      }
      localObject = this.w;
      if (localObject != null) {
        ((DoodleEditView)localObject).setTimeStamp(paramLong);
      }
      localObject = this.x;
      if (localObject != null) {
        ((DoodleView)localObject).setTimeStamp(paramLong);
      }
    }
  }
  
  protected void setViewsInVisible(View... paramVarArgs)
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
  
  protected void setViewsVisible(View... paramVarArgs)
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
  
  public void setupPersonality()
  {
    this.t = ((FrameLayout)super.findViewById(2131432059));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.u = new DoodleTextureView(super.getContext());
    this.t.addView(this.u, localLayoutParams);
    this.B = PtvFilterSoLoad.d();
    if (!this.B)
    {
      setViewsInVisible(new View[] { this.t });
      setDoodleGLViewVisibility(4);
      this.V = false;
      return;
    }
    this.V = true;
    D();
  }
  
  public boolean t()
  {
    DoodleView localDoodleView = this.v;
    return (localDoodleView != null) && (localDoodleView.getActiveLayer() == this.J);
  }
  
  public void u()
  {
    Object localObject = this.y;
    if (localObject != null) {
      ((DoodleLayout.DoodleEventListener)localObject).m();
    }
    localObject = this.w;
    if (localObject != null) {
      ((DoodleEditView)localObject).d();
    }
    f(this.k);
  }
  
  public void v()
  {
    MosaicOperator localMosaicOperator = (MosaicOperator)getLineLayer().b(104);
    if (localMosaicOperator != null) {
      localMosaicOperator.e();
    }
  }
  
  public void w()
  {
    this.v.invalidate();
  }
  
  public void x()
  {
    Object localObject = this.W;
    if ((localObject != null) && (((EditVideoDoodle)localObject).t.Z != null))
    {
      localObject = (RelativeLayout.LayoutParams)this.s.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
      this.s.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void y()
  {
    Object localObject = getLineLayer();
    if (localObject == null) {
      return;
    }
    if ((PureOperator)((LineLayer)localObject).b(101) == null) {
      return;
    }
    if (this.a == -1)
    {
      localObject = BaseApplicationImpl.getContext().getSharedPreferences("DoodleLay_State", 4);
      if ((((SharedPreferences)localObject).contains("Line_LastType")) && (((SharedPreferences)localObject).contains("Line_LastSubType")))
      {
        this.a = ((SharedPreferences)localObject).getInt("Line_LastType", 0);
        this.b = ((SharedPreferences)localObject).getInt("Line_LastSubType", 0);
      }
      else
      {
        this.a = 0;
        this.b = HorizontalStroke.a(e());
      }
    }
    this.s.setSelectedStroke(this.a, this.b);
  }
  
  public boolean z()
  {
    return this.ae;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout
 * JD-Core Version:    0.7.0.1
 */