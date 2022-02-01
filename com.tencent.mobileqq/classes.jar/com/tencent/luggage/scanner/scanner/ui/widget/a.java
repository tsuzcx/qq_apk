package com.tencent.luggage.scanner.scanner.ui.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.scanner.qbar.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.g;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/scanner/scanner/ui/widget/ScanCodeMaskView;", "Lcom/tencent/luggage/scanner/view/BaseScanMaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "accelerateInterpolator", "Landroid/view/animation/AccelerateInterpolator;", "alphaAnimationDistanceFactor", "", "canUpdateMultiCodeTipsDefaultPos", "", "decelerateInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "frameBitmap", "Landroid/graphics/Bitmap;", "frameImage", "Landroid/widget/ImageView;", "isMultiCode", "isShowingSuccessView", "mRect", "Landroid/graphics/Rect;", "multiCodeBgMask", "Landroid/view/View;", "multiCodeTips", "Landroid/widget/TextView;", "multiCodeTipsCurrentBottomMargin", "multiCodeTipsDefaultPosition", "Landroid/graphics/PointF;", "needRotate", "pointCount", "scaleAnimationTimer", "Ljava/util/Timer;", "scaleAnimator", "Landroid/animation/ValueAnimator;", "scaleTimerTask", "Ljava/util/TimerTask;", "scanLineAnimator", "scanLineImageView", "successAnimationListener", "Lcom/tencent/luggage/scanner/view/ScanResultAnimationListener;", "successAnimator", "successMarkClickIndex", "successMarkClickListener", "Lcom/tencent/luggage/scanner/scanner/ui/widget/ScanSuccessMarkClickListener;", "successMarkViewCheckSize", "successMarkViewList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "successMarkViewSize", "viewWidth", "addSuccessView", "attachFlashSwitcherView", "", "flashSwitcher", "cancelScaleAnimator", "cancelScaleTimer", "cancelSuccessAnimator", "checkMultiCodeTipsPositionValid", "x", "y", "computeCenterPosition", "scanCodeResultPoint", "Lcom/tencent/luggage/scanner/qbar/LuggageQBarPoint;", "computeRealPosition", "pos", "fixMultiCodeTipsPosition", "valid", "getFrameBitmap", "frameData", "Lcom/tencent/luggage/scanner/qbar/ScanDecodeFrameData;", "getTargetSuccessMarkView", "init", "initDefaultRect", "initScaleAnimation", "initScanLineAnimator", "onBackPressed", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onPreviewReady", "isSwitchTab", "onResume", "onScanSuccess", "data", "", "scanResultAnimationListener", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "recycleFrameBitmap", "release", "rotateAndScaleBitmap", "bitmap", "rotation", "targetWidth", "targetHeight", "runScaleAnimation", "runZoomAnimation", "fromScale", "toScale", "animationInterpolator", "Landroid/view/animation/Interpolator;", "animationCount", "runZoomInAnimation", "runZoomOutAnimation", "setAnimationRect", "rect", "setBottomExtraHeight", "bottomHeight", "setDecodeSuccessFrameData", "setNeedRotate", "setSuccessMarkClickListener", "showSuccessView", "pointList", "startScanLineAnimation", "stopScanLineAnimation", "updateMultiCodeTipsBottomMargin", "margin", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
  extends com.tencent.luggage.wxa.dl.a
{
  public static final a.a a = new a.a(null);
  private DecelerateInterpolator A = new DecelerateInterpolator(1.5F);
  private int B = 120;
  private PointF C = new PointF();
  private boolean D = true;
  private ImageView c;
  private View d;
  private TextView e;
  private ImageView f;
  private Bitmap g;
  private ArrayList<View> h = new ArrayList();
  private int i = getResources().getDimensionPixelSize(2131299675);
  private int j = this.i - getResources().getDimensionPixelSize(2131296389) * 2 + getResources().getDimensionPixelSize(2131296409) * 2;
  private int k;
  private ValueAnimator l = new ValueAnimator();
  private ValueAnimator m = new ValueAnimator();
  private float n;
  private com.tencent.luggage.wxa.dl.e o;
  private Rect p = new Rect(0, 0, 0, 0);
  private boolean q;
  private boolean r;
  private boolean s;
  private int t;
  private c u;
  private int v = -1;
  private Timer w;
  private TimerTask x;
  private ValueAnimator y;
  private AccelerateInterpolator z = new AccelerateInterpolator(1.5F);
  
  public a(@NotNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public a(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public a(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private final Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBitmap != null)
    {
      o.d("Luggage.ScanCodeMaskView", "alvinlu rotateAndScaleBitmap rotation: %d, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      Object localObject = new Matrix();
      ((Matrix)localObject).postRotate(paramInt1);
      int i4;
      if (paramInt1 % 180 != 0) {
        i4 = 1;
      } else {
        i4 = 0;
      }
      int i5 = paramBitmap.getWidth();
      int i6 = paramBitmap.getHeight();
      if (i4 != 0) {
        paramInt1 = paramBitmap.getHeight();
      } else {
        paramInt1 = paramBitmap.getWidth();
      }
      int i1;
      if (i4 != 0) {
        i1 = paramBitmap.getWidth();
      } else {
        i1 = paramBitmap.getHeight();
      }
      int i2 = i5;
      int i3 = i6;
      if (paramInt2 != 0)
      {
        i2 = i5;
        i3 = i6;
        if (paramInt3 != 0)
        {
          float f1 = paramInt1;
          float f2 = i1;
          float f3 = f1 * 1.0F / f2;
          float f4 = paramInt2 * 1.0F / paramInt3;
          if (f3 > f4)
          {
            i2 = (int)(f4 * f2);
            i3 = i1;
          }
          else
          {
            i3 = (int)(f1 / f4);
            i2 = paramInt1;
          }
        }
      }
      paramInt1 = Math.max(0, (paramInt1 - i2) / 2);
      paramInt2 = Math.max(0, (i1 - i3) / 2);
      o.d("Luggage.ScanCodeMaskView", "alvinluo rotateAndScaleBitmap finalWidth: %d, finalHeight: %d, x: %d, y: %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (i4 != 0) {
        localObject = Bitmap.createBitmap(paramBitmap, paramInt2, paramInt1, i3, i2, (Matrix)localObject, true);
      } else {
        localObject = Bitmap.createBitmap(paramBitmap, paramInt1, paramInt2, i2, i3, (Matrix)localObject, true);
      }
      if (((Intrinsics.areEqual(localObject, paramBitmap) ^ true)) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      return localObject;
    }
    return null;
  }
  
  private final Bitmap a(com.tencent.luggage.scanner.qbar.e parame)
  {
    try
    {
      Object localObject1 = getScanCamera();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      int i1 = ((com.tencent.luggage.scanner.camera.f)localObject1).q();
      localObject1 = getScanCamera();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((com.tencent.luggage.scanner.camera.f)localObject1).g();
      if (parame != null)
      {
        Object localObject2 = parame.a();
        if (localObject2 != null)
        {
          o.d("Luggage.ScanCodeMaskView", "alvinluo getFrameBitmap data length: %d, size: %d, %d, rotation: %d, previewFormat: %d", new Object[] { Integer.valueOf(localObject2.length), Integer.valueOf(parame.c()), Integer.valueOf(parame.d()), Integer.valueOf(parame.b()), Integer.valueOf(i1) });
          localObject2 = new YuvImage(parame.a(), i1, ((Point)localObject1).x, ((Point)localObject1).y, null);
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          ((YuvImage)localObject2).compressToJpeg(new Rect(0, 0, ((Point)localObject1).x, ((Point)localObject1).y), 100, (OutputStream)localByteArrayOutputStream);
          localObject2 = BitmapFactory.decodeByteArray(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.size());
          if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
          {
            o.d("Luggage.ScanCodeMaskView", "alvinluo getFrameBitmap bitmap width: %d, height: %d", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
            localObject1 = localObject2;
            if (parame.b() != 0) {
              localObject1 = a((Bitmap)localObject2, parame.b(), getMeasuredWidth(), getMeasuredHeight());
            }
            return localObject1;
          }
        }
      }
    }
    catch (Exception parame)
    {
      o.a("Luggage.ScanCodeMaskView", (Throwable)parame, "alvinluo getFrameBitmap exception", new Object[0]);
    }
    return null;
  }
  
  private final PointF a(PointF paramPointF)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramPointF != null)
    {
      localObject1 = localObject2;
      if (getMScanRect() != null)
      {
        float f1 = paramPointF.x;
        localObject1 = getMScanRect();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        float f2 = ((Rect)localObject1).width();
        localObject1 = getMScanRect();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        float f3 = ((Rect)localObject1).left;
        float f4 = paramPointF.y;
        paramPointF = getMScanRect();
        if (paramPointF == null) {
          Intrinsics.throwNpe();
        }
        float f5 = paramPointF.height();
        paramPointF = getMScanRect();
        if (paramPointF == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = new PointF(f1 * f2 + f3, f4 * f5 + paramPointF.top);
      }
    }
    return localObject1;
  }
  
  private final PointF a(com.tencent.luggage.scanner.qbar.c paramc)
  {
    if ((paramc.point_cnt == 4) && (getMPreviewRect() != null) && (getScanCamera() != null))
    {
      Object localObject = getScanCamera();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if ((((com.tencent.luggage.scanner.camera.f)localObject).e()) && (this.q))
      {
        f1 = paramc.x0;
        f2 = paramc.x1;
        f3 = paramc.x2;
        f4 = paramc.x3;
        localObject = getMPreviewRect();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        f1 = (f1 + f2 + f3 + f4) / (((Rect)localObject).height() * 4);
        f2 = paramc.y0;
        f3 = paramc.y1;
        f4 = paramc.y2;
        f5 = paramc.y3;
        paramc = getMPreviewRect();
        if (paramc == null) {
          Intrinsics.throwNpe();
        }
        return new PointF(f1, (f2 + f3 + f4 + f5) / (4 * paramc.width()));
      }
      float f1 = paramc.x0;
      float f2 = paramc.x1;
      float f3 = paramc.x2;
      float f4 = paramc.x3;
      localObject = getMPreviewRect();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      f1 = (f1 + f2 + f3 + f4) / (((Rect)localObject).width() * 4);
      f2 = paramc.y0;
      f3 = paramc.y1;
      f4 = paramc.y2;
      float f5 = paramc.y3;
      paramc = getMPreviewRect();
      if (paramc == null) {
        Intrinsics.throwNpe();
      }
      return new PointF(f1, (f2 + f3 + f4 + f5) / (4 * paramc.height()));
    }
    return null;
  }
  
  private final void a(float paramFloat1, float paramFloat2, Interpolator paramInterpolator, Animator.AnimatorListener paramAnimatorListener)
  {
    o.e("Luggage.ScanCodeMaskView", "alvinluo runZoomAnimation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    q();
    this.y = new ValueAnimator();
    ValueAnimator localValueAnimator = this.y;
    if (localValueAnimator != null)
    {
      localValueAnimator.setFloatValues(new float[] { paramFloat1, paramFloat2 });
      localValueAnimator.setInterpolator((TimeInterpolator)paramInterpolator);
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a.f(this, paramFloat1, paramFloat2, paramInterpolator, paramAnimatorListener));
      localValueAnimator.addListener(paramAnimatorListener);
      localValueAnimator.start();
    }
  }
  
  private final void a(int paramInt)
  {
    o.e("Luggage.ScanCodeMaskView", "alvinluo updateMultiCodeTipsBottomMargin: %d", new Object[] { Integer.valueOf(paramInt) });
    TextView localTextView = this.e;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
    }
    Object localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
    }
    localObject = ((TextView)localObject).getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      this.B = paramInt;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.luggage.wxa.qx.a.e(getContext(), paramInt) + getMBottomExtraHeight());
    }
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private final void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131625228, (ViewGroup)this, true);
    View localView = paramContext.findViewById(2131445274);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.scan_line)");
    this.c = ((ImageView)localView);
    localView = paramContext.findViewById(2131438994);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.multi_code_mask)");
    this.d = localView;
    localView = paramContext.findViewById(2131438995);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.multi_code_tips)");
    this.e = ((TextView)localView);
    localView = paramContext.findViewById(2131433672);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.frame_image)");
    this.f = ((ImageView)localView);
    paramContext = paramContext.findViewById(2131445286);
    if (paramContext != null)
    {
      this.h.clear();
      this.h.add(paramContext);
    }
    i();
    j();
  }
  
  private final void a(ArrayList<PointF> paramArrayList)
  {
    o.d("Luggage.ScanCodeMaskView", "alvinluo showSuccessView pointList %d", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.k = 0;
    this.s = true;
    Ref.BooleanRef localBooleanRef = new Ref.BooleanRef();
    localBooleanRef.element = true;
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      PointF localPointF = (PointF)paramArrayList.next();
      if (localPointF != null)
      {
        Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
        localObjectRef.element = ((View)CollectionsKt.getOrNull((List)this.h, this.k));
        if ((View)localObjectRef.element == null)
        {
          localObjectRef.element = m();
          this.h.add((View)localObjectRef.element);
        }
        View localView = (View)localObjectRef.element;
        ImageView localImageView = (ImageView)localView.findViewById(2131445286);
        if (localImageView != null) {
          localImageView.setImageResource(2130851678);
        }
        localView.setVisibility(0);
        localView.setPivotX(this.i / 2.0F);
        localView.setPivotY(this.i / 2.0F);
        localView.setTranslationX(localPointF.x - this.i / 2);
        localView.setTranslationY(localPointF.y - this.i / 2);
        localView.setAlpha(0.0F);
        localView.setScaleX(0.0F);
        localView.setScaleY(0.0F);
        if (!a(localPointF.x, localPointF.y)) {
          localBooleanRef.element = false;
        }
        localView.setOnClickListener((View.OnClickListener)new a.l(this.k, localPointF, localObjectRef, this, localBooleanRef));
        this.k += 1;
      }
    }
    int i1 = this.k;
    int i2 = this.h.size();
    while (i1 < i2)
    {
      paramArrayList = (View)CollectionsKt.getOrNull((List)this.h, i1);
      if (paramArrayList != null) {
        paramArrayList.setVisibility(8);
      }
      i1 += 1;
    }
    boolean bool;
    if (this.k > 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.r = bool;
    if (!this.r)
    {
      paramArrayList = (View)CollectionsKt.firstOrNull((List)this.h);
      if (paramArrayList != null)
      {
        paramArrayList = (ImageView)paramArrayList.findViewById(2131445286);
        if (paramArrayList != null) {
          paramArrayList.setImageResource(2130851677);
        }
      }
      paramArrayList = this.d;
      if (paramArrayList == null) {
        Intrinsics.throwUninitializedPropertyAccessException("multiCodeBgMask");
      }
      paramArrayList.setVisibility(8);
      paramArrayList = this.e;
      if (paramArrayList == null) {
        Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
      }
      paramArrayList.setVisibility(4);
    }
    else
    {
      paramArrayList = this.d;
      if (paramArrayList == null) {
        Intrinsics.throwUninitializedPropertyAccessException("multiCodeBgMask");
      }
      paramArrayList.setVisibility(0);
      paramArrayList = this.d;
      if (paramArrayList == null) {
        Intrinsics.throwUninitializedPropertyAccessException("multiCodeBgMask");
      }
      paramArrayList.setAlpha(0.0F);
      paramArrayList = this.e;
      if (paramArrayList == null) {
        Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
      }
      paramArrayList.setVisibility(0);
      paramArrayList = this.e;
      if (paramArrayList == null) {
        Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
      }
      paramArrayList.setAlpha(0.0F);
      c(localBooleanRef.element);
    }
    o.d("Luggage.ScanCodeMaskView", "alvinluo showSuccessView isMultiCode: %b, pointCount: %d, successMarkViewList: %d, tipsPositionValid: %b", new Object[] { Boolean.valueOf(this.r), Integer.valueOf(this.k), Integer.valueOf(this.h.size()), Boolean.valueOf(localBooleanRef.element) });
    paramArrayList = this.l;
    paramArrayList.removeAllUpdateListeners();
    paramArrayList.removeAllListeners();
    paramArrayList.setFloatValues(new float[] { 0.0F, 1.0F });
    paramArrayList.setInterpolator((TimeInterpolator)new LinearInterpolator());
    paramArrayList.setDuration(300L);
    paramArrayList.addListener((Animator.AnimatorListener)new a.j(this));
    paramArrayList.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a.k(this));
    paramArrayList.start();
    if (this.r)
    {
      paramArrayList = this.d;
      if (paramArrayList == null) {
        Intrinsics.throwUninitializedPropertyAccessException("multiCodeBgMask");
      }
      paramArrayList = paramArrayList.animate();
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.alpha(1.0F);
        if (paramArrayList != null)
        {
          paramArrayList = paramArrayList.setInterpolator((TimeInterpolator)new LinearInterpolator());
          if (paramArrayList != null)
          {
            paramArrayList = paramArrayList.setDuration(600L);
            if (paramArrayList != null)
            {
              paramArrayList = paramArrayList.setListener((Animator.AnimatorListener)new a.m(this));
              if (paramArrayList != null) {
                paramArrayList.start();
              }
            }
          }
        }
      }
    }
  }
  
  private final boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool = false;
    float f1 = this.C.x;
    float f2 = this.C.y;
    TextView localTextView = this.e;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
    }
    int i1 = localTextView.getMeasuredWidth();
    localTextView = this.e;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
    }
    o.d("Luggage.ScanCodeMaskView", "alvinluo checkMultiCodeTipsPositionValid [%s, %s], multiCodeTips: [%s, %s], [%s, %s]", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i1), Integer.valueOf(localTextView.getMeasuredHeight()) });
    if (this.j / 2 + paramFloat1 >= this.C.x)
    {
      f1 = this.j / 2;
      f2 = this.C.x;
      localTextView = this.e;
      if (localTextView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
      }
      if ((paramFloat1 - f1 <= f2 + localTextView.getMeasuredWidth()) && (this.j / 2 + paramFloat2 >= this.C.y))
      {
        paramFloat1 = this.j / 2;
        f1 = this.C.y;
        localTextView = this.e;
        if (localTextView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
        }
        if (paramFloat2 - paramFloat1 <= f1 + localTextView.getMeasuredHeight()) {
          break label264;
        }
      }
    }
    bool = true;
    label264:
    return bool;
  }
  
  private final void b(int paramInt)
  {
    o.e("Luggage.ScanCodeMaskView", "alvinluo runZoomAnimation %d", new Object[] { Integer.valueOf(paramInt) });
    b((Animator.AnimatorListener)new a.g(this, new a.h(this, paramInt)));
  }
  
  private final void b(Animator.AnimatorListener paramAnimatorListener)
  {
    a(1.0F, 0.8F, (Interpolator)this.z, paramAnimatorListener);
  }
  
  private final void c(Animator.AnimatorListener paramAnimatorListener)
  {
    a(0.8F, 1.0F, (Interpolator)this.A, paramAnimatorListener);
  }
  
  private final void c(boolean paramBoolean)
  {
    o.e("Luggage.ScanCodeMaskView", "alvinluo fixMultiCodeTipsPosition valid: %b, current: %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.B) });
    this.D = false;
    if ((!paramBoolean) && (this.B != 32))
    {
      a(32);
      return;
    }
    if ((paramBoolean) && (this.B != 120)) {
      a(120);
    }
  }
  
  private final void i()
  {
    int i1 = getMeasuredWidth();
    float f1 = getMeasuredHeight();
    setAnimationRect(new Rect(0, (int)(0.15F * f1), i1, (int)(f1 * 0.6F)));
  }
  
  private final void j()
  {
    this.n = 0.16F;
    this.m.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.m.setDuration(2500L);
    this.m.addListener((Animator.AnimatorListener)new a.c(this));
    this.m.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a.d(this));
    this.m.setRepeatMode(1);
    this.m.setRepeatCount(-1);
  }
  
  private final void k()
  {
    this.l.removeAllListeners();
    this.l.removeAllUpdateListeners();
    this.l.cancel();
  }
  
  private final void l()
  {
    Bitmap localBitmap = this.g;
    if (localBitmap != null)
    {
      if (localBitmap == null) {
        Intrinsics.throwNpe();
      }
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.g;
        if (localBitmap == null) {
          Intrinsics.throwNpe();
        }
        localBitmap.recycle();
      }
    }
  }
  
  private final View m()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131625229, null);
    int i1 = this.i;
    addView(localView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(i1, i1));
    Intrinsics.checkExpressionValueIsNotNull(localView, "view");
    return localView;
  }
  
  private final void n()
  {
    p();
    this.x = ((TimerTask)new a.b(this));
    this.w = new Timer();
    o.e("Luggage.ScanCodeMaskView", "alvinluo initScaleAnimation period: %d", new Object[] { Long.valueOf(3350L) });
    Timer localTimer = this.w;
    if (localTimer != null) {
      localTimer.scheduleAtFixedRate(this.x, 0L, 3350L);
    }
  }
  
  private final void o()
  {
    o.e("Luggage.ScanCodeMaskView", "alvinluo runScaleAnimation");
    b(1);
  }
  
  private final void p()
  {
    Object localObject = this.w;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    localObject = this.x;
    if (localObject != null) {
      ((TimerTask)localObject).cancel();
    }
    this.w = ((Timer)null);
    this.x = ((TimerTask)null);
  }
  
  private final void q()
  {
    ValueAnimator localValueAnimator = this.y;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllListeners();
    }
    localValueAnimator = this.y;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllUpdateListeners();
    }
    localValueAnimator = this.y;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.y = ((ValueAnimator)null);
  }
  
  public final void a()
  {
    o.e("Luggage.ScanCodeMaskView", "alvinluo startScanLineAnimation");
    this.m.cancel();
    ImageView localImageView = this.c;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanLineImageView");
    }
    localImageView.setVisibility(0);
    this.m.start();
  }
  
  public void a(@Nullable Animator.AnimatorListener paramAnimatorListener)
  {
    super.a(paramAnimatorListener);
    this.m.cancel();
    l();
    a((View)this, 1.0F, 0.0F, (Animator.AnimatorListener)new a.e(this, paramAnimatorListener));
  }
  
  public void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "flashSwitcher");
    super.a(paramView);
    View localView = getFlashSwitcher();
    if (localView != null)
    {
      paramView = getFlashSwitcher();
      if (paramView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        if (localLayoutParams != null)
        {
          paramView = localLayoutParams;
          if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
            break label76;
          }
          ((ViewGroup.MarginLayoutParams)localLayoutParams).bottomMargin = (com.tencent.luggage.wxa.qx.a.e(getContext(), 32) + getMBottomExtraHeight());
          paramView = localLayoutParams;
          break label76;
        }
      }
      paramView = null;
      label76:
      localView.setLayoutParams(paramView);
    }
  }
  
  public void a(@NotNull Object paramObject, @Nullable com.tencent.luggage.wxa.dl.e parame)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "data");
    this.o = parame;
    if (((paramObject instanceof ArrayList)) && ((CollectionsKt.firstOrNull((List)paramObject) instanceof d)))
    {
      parame = new ArrayList();
      paramObject = ((Iterable)paramObject).iterator();
      while (paramObject.hasNext())
      {
        Object localObject = paramObject.next();
        if (localObject != null)
        {
          localObject = ((d)localObject).b;
          if (localObject != null) {
            parame.add(a(a((com.tencent.luggage.scanner.qbar.c)localObject)));
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.scanner.qbar.LuggageQBarResult");
        }
      }
      a(parame);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    Object localObject = ((Iterable)this.h).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((View)((Iterator)localObject).next()).setVisibility(8);
    }
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("multiCodeBgMask");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("frameImage");
    }
    ((ImageView)localObject).setVisibility(8);
    this.s = false;
    this.r = false;
    if (!paramBoolean)
    {
      localObject = getScanTips();
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = getScanTips();
      if (localObject != null) {
        ((TextView)localObject).setAlpha(1.0F);
      }
    }
    a((View)this, 0.0F, 1.0F, null);
    p();
    q();
    k();
  }
  
  public final void b()
  {
    o.e("Luggage.ScanCodeMaskView", "alvinluo stopScanLineAnimation");
    this.m.cancel();
  }
  
  public void c()
  {
    super.c();
    a();
  }
  
  public void d()
  {
    super.d();
    b();
  }
  
  public void e()
  {
    super.e();
    o.f("Luggage.ScanCodeMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
  }
  
  public boolean f()
  {
    if ((this.r) && (this.s)) {
      return true;
    }
    return super.f();
  }
  
  public void g()
  {
    super.g();
    p();
    q();
  }
  
  @Nullable
  public View getTargetSuccessMarkView()
  {
    if (this.r) {
      return (View)CollectionsKt.getOrNull((List)this.h, this.v);
    }
    return (View)CollectionsKt.getOrNull((List)this.h, 0);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((getMeasuredWidth() != 0) && (getMeasuredWidth() != this.t))
    {
      this.t = getMeasuredWidth();
      i();
    }
    if (this.D)
    {
      PointF localPointF = this.C;
      TextView localTextView = this.e;
      if (localTextView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
      }
      localPointF.x = localTextView.getX();
      localPointF = this.C;
      localTextView = this.e;
      if (localTextView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
      }
      localPointF.y = localTextView.getY();
    }
  }
  
  public final void setAnimationRect(@NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "rect");
    this.p.set(paramRect);
    o.e("Luggage.ScanCodeMaskView", "alvinluo setAnimationRect %s", new Object[] { paramRect });
    ImageView localImageView = this.c;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanLineImageView");
    }
    paramRect = this.c;
    if (paramRect == null) {
      Intrinsics.throwUninitializedPropertyAccessException("scanLineImageView");
    }
    ViewGroup.LayoutParams localLayoutParams = paramRect.getLayoutParams();
    if (localLayoutParams != null)
    {
      paramRect = localLayoutParams;
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = this.p.left;
        paramRect = localLayoutParams;
      }
    }
    else
    {
      paramRect = null;
    }
    localImageView.setLayoutParams(paramRect);
    this.m.setFloatValues(new float[] { this.p.top, this.p.bottom });
  }
  
  public void setBottomExtraHeight(int paramInt)
  {
    super.setBottomExtraHeight(paramInt);
    a(120);
  }
  
  public void setDecodeSuccessFrameData(@Nullable com.tencent.luggage.scanner.qbar.e parame)
  {
    super.setDecodeSuccessFrameData(parame);
    com.tencent.luggage.wxa.rz.f.a.c((Runnable)new a.i(this, parame));
  }
  
  public final void setNeedRotate(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public final void setSuccessMarkClickListener(@NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "successMarkClickListener");
    this.u = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */