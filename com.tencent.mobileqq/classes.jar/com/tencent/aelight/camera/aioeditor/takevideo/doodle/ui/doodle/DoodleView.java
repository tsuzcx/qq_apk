package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.EmptyLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.ShapeLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.DoodleStrategy;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.config.DoodleConfig;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class DoodleView
  extends View
{
  private BaseLayer a;
  private BaseLayer b;
  public int c;
  public int d;
  public int e;
  public int f;
  public DoodleConfig g;
  public EditVideoParams h;
  protected List<BaseLayer> i;
  protected Map<String, BaseLayer> j;
  protected EmptyLayer k;
  public DoodleLayout l;
  public boolean m = true;
  private Bitmap n;
  private Paint o;
  private Canvas p;
  private LinkedList<BaseLayer> q = new LinkedList();
  private Comparator<BaseLayer> r = new DoodleView.1(this);
  private long s = 0L;
  private final Matrix t = new Matrix();
  @Nullable
  private RectF u = null;
  private final RectF v = new RectF();
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = this.u;
      if (localObject == null) {
        return paramBitmap;
      }
      Rect localRect1 = new Rect((int)((RectF)localObject).left, (int)this.u.top, (int)this.u.right, (int)this.u.bottom);
      Rect localRect2 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      localObject = paramBitmap;
      if (localRect2.intersect(localRect1))
      {
        localObject = paramBitmap;
        if (!localRect2.isEmpty()) {
          try
          {
            paramBitmap = Bitmap.createBitmap(paramBitmap, localRect2.left, localRect2.top, localRect2.width(), localRect2.height());
            return paramBitmap;
          }
          catch (OutOfMemoryError paramBitmap)
          {
            SLog.c("DoodleView", "crop doodle bitmap fail: ", paramBitmap);
            localObject = null;
          }
        }
      }
    }
    return localObject;
  }
  
  private boolean a(long paramLong)
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      if (((Map)localObject).size() == 0) {
        return false;
      }
      localObject = this.j.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((BaseLayer)((Iterator)localObject).next()).a(paramLong)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void b()
  {
    this.i.add(this.k);
    this.g.a.a(this.i, this);
    Object localObject = this.i.iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseLayer localBaseLayer = (BaseLayer)((Iterator)localObject).next();
      this.j.put(localBaseLayer.a(), localBaseLayer);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DoodleView hold layers:");
    ((StringBuilder)localObject).append(this.j.toString());
    SLog.b("DoodleView", ((StringBuilder)localObject).toString());
    this.a = this.k;
    if (this.i.size() > 1) {
      localObject = (BaseLayer)this.i.get(1);
    } else {
      localObject = null;
    }
    if ((localObject != null) && ((((BaseLayer)localObject).s() != this.c) || (((BaseLayer)localObject).t() != this.d))) {
      onSizeChanged(this.c, this.d, ((BaseLayer)localObject).s(), ((BaseLayer)localObject).t());
    }
    super.requestLayout();
  }
  
  private void d()
  {
    long l1 = SystemClock.uptimeMillis();
    Object localObject2 = (LineLayer)this.j.get("LineLayer");
    if ((localObject2 != null) && (((LineLayer)localObject2).b.g()) && (((LineLayer)localObject2).b.a == null)) {
      ((LineLayer)localObject2).b.c(this.n.getWidth());
    }
    this.p.drawPaint(this.o);
    Object localObject1 = new Canvas(this.n);
    Object localObject3 = this.h;
    if ((localObject3 != null) && (((EditVideoParams)localObject3).b()) && (localObject2 != null)) {
      ((LineLayer)localObject2).c((Canvas)localObject1);
    }
    localObject2 = new LinkedList(this.j.values());
    Collections.sort((List)localObject2, this.r);
    int i1 = ((LinkedList)localObject2).size() - 1;
    while (i1 >= 0)
    {
      localObject3 = (BaseLayer)((LinkedList)localObject2).get(i1);
      if (localObject3 != null) {
        ((BaseLayer)localObject3).b((Canvas)localObject1);
      }
      i1 -= 1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("drawLayerInDoodleBitmap cost time:");
    ((StringBuilder)localObject1).append(SystemClock.uptimeMillis() - l1);
    SLog.b("DoodleView", ((StringBuilder)localObject1).toString());
  }
  
  private boolean k()
  {
    int i1 = this.e;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (i1 > 0)
    {
      int i2 = this.f;
      bool1 = bool3;
      if (i2 > 0)
      {
        bool1 = bool2;
        try
        {
          this.n = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
          bool1 = bool2;
          this.p = new Canvas(this.n);
          bool2 = true;
          bool1 = bool2;
          StringBuilder localStringBuilder = new StringBuilder();
          bool1 = bool2;
          localStringBuilder.append("create Doodle bitmap, width:");
          bool1 = bool2;
          localStringBuilder.append(this.e);
          bool1 = bool2;
          localStringBuilder.append(",height:");
          bool1 = bool2;
          localStringBuilder.append(this.f);
          bool1 = bool2;
          SLog.b("DoodleView", localStringBuilder.toString());
          return true;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          SLog.c("DoodleView", "create doodle bitmap failed: %s", localOutOfMemoryError);
        }
      }
    }
    return bool1;
  }
  
  private boolean l()
  {
    Bitmap localBitmap = this.n;
    return (localBitmap != null) && (!localBitmap.isRecycled());
  }
  
  public BaseLayer a(MotionEvent paramMotionEvent)
  {
    LinkedList localLinkedList = new LinkedList(this.i);
    Collections.sort(localLinkedList, this.r);
    int i1 = 0;
    while (i1 < localLinkedList.size())
    {
      BaseLayer localBaseLayer = (BaseLayer)localLinkedList.get(i1);
      if ((localBaseLayer != null) && (localBaseLayer.b(paramMotionEvent))) {
        return localBaseLayer;
      }
      i1 += 1;
    }
    return this.k;
  }
  
  public <LAYER extends BaseLayer> LAYER a(String paramString)
  {
    paramString = (BaseLayer)this.j.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    throw new IllegalArgumentException("this layer is not exist in DoodleView.");
  }
  
  protected void a()
  {
    this.o = new Paint();
    this.o.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.i = new ArrayList();
    this.j = new LinkedHashMap();
    this.k = new EmptyLayer(this);
    this.a = this.k;
    setLayerType(1, null);
  }
  
  public void a(BaseLayer paramBaseLayer)
  {
    if (this.a == paramBaseLayer) {
      e();
    }
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.h = paramEditVideoParams;
    Object localObject = (LineLayer)this.j.get("LineLayer");
    if (localObject != null)
    {
      localObject = (MosaicOperator)((LineLayer)localObject).b.a(103);
      if (localObject != null)
      {
        if (paramEditVideoParams.b())
        {
          ((MosaicOperator)localObject).a(104);
          return;
        }
        if ((!(paramEditVideoParams.e instanceof EditTakeVideoSource)) && (!(paramEditVideoParams.e instanceof EditLocalVideoSource)))
        {
          ((MosaicOperator)localObject).a(103);
          return;
        }
        ((MosaicOperator)localObject).a(105);
      }
    }
  }
  
  public void a(boolean paramBoolean1, float paramFloat1, float paramFloat2, float paramFloat3, PointF paramPointF, boolean paramBoolean2, int paramInt)
  {
    DoodleLayout localDoodleLayout = this.l;
    if (localDoodleLayout == null) {
      return;
    }
    localDoodleLayout.a(paramBoolean1, paramFloat1, (int)paramFloat2, (int)paramFloat3, paramPointF, paramBoolean2, paramInt);
  }
  
  public void c()
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((BaseLayer)localIterator.next()).f();
    }
    i();
  }
  
  public void e()
  {
    setActiveLayer(this.k);
    setTopLevelLayer(this.k);
  }
  
  public boolean f()
  {
    return this.a == this.k;
  }
  
  public boolean g()
  {
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      if (!((BaseLayer)localIterator.next()).c()) {
        return false;
      }
    }
    return true;
  }
  
  public BaseLayer getActiveLayer()
  {
    return this.a;
  }
  
  public int getBitmapHeight()
  {
    return this.f;
  }
  
  public int getBitmapWidth()
  {
    return this.e;
  }
  
  @Nullable
  public RectF getContentBounds()
  {
    RectF localRectF = this.u;
    if (localRectF == null) {
      return null;
    }
    return new RectF(localRectF);
  }
  
  public Bitmap getDoodleBitmap()
  {
    if (!k())
    {
      SLog.e("DoodleView", "create doodle bitmap failed.");
      return null;
    }
    d();
    return a(this.n);
  }
  
  public long getTimeStamp()
  {
    return this.s;
  }
  
  public void h()
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BaseLayer)((Iterator)localObject).next()).b();
      }
      localObject = this.p;
      if (localObject != null) {
        ((Canvas)localObject).drawPaint(this.o);
      }
    }
    super.invalidate();
  }
  
  public void i()
  {
    SLog.b("DoodleView", "recycle bitmap.");
    if (l())
    {
      this.n.recycle();
      this.n = null;
      this.p = null;
    }
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    invalidate();
  }
  
  public void j()
  {
    LineLayer localLineLayer = (LineLayer)this.j.get("LineLayer");
    if ((localLineLayer != null) && (localLineLayer.b.g()) && (this.e > 0)) {
      localLineLayer.b.b(this.e);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.m) {
      return;
    }
    if (this.u != null)
    {
      paramCanvas.save();
      this.t.mapRect(this.v, this.u);
      paramCanvas.clipRect(this.v);
    }
    Object localObject = this.h;
    if ((localObject != null) && (((EditVideoParams)localObject).b()))
    {
      localObject = this.j.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseLayer localBaseLayer = (BaseLayer)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((localBaseLayer instanceof LineLayer)) {
          ((LineLayer)localBaseLayer).b.a(paramCanvas);
        }
      }
    }
    this.q.clear();
    this.q.addAll(this.j.values());
    Collections.sort(this.q, this.r);
    int i1 = this.q.size() - 1;
    while (i1 >= 0)
    {
      localObject = (BaseLayer)this.q.get(i1);
      if (localObject != null) {
        ((BaseLayer)localObject).d(paramCanvas);
      }
      i1 -= 1;
    }
    if (this.u != null) {
      paramCanvas.restore();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (i2 == -2147483648) {
      paramInt1 = i1 * 3 / 2;
    }
    setMeasuredDimension(i1, paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return;
      }
      if (this.g != null)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("DoodleViewWidth:");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(",DoodleViewHeight:");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(",MaxWidth:");
        ((StringBuilder)localObject).append(this.g.b);
        ((StringBuilder)localObject).append(",MaxHeight:");
        ((StringBuilder)localObject).append(this.g.c);
        SLog.b("DoodleView", ((StringBuilder)localObject).toString());
        this.c = paramInt1;
        this.d = paramInt2;
        if (this.g.b == 0) {
          paramInt3 = this.c;
        } else {
          paramInt3 = this.g.b;
        }
        if (this.g.c == 0) {
          paramInt4 = this.d;
        } else {
          paramInt4 = this.g.c;
        }
        float f1 = DisplayUtil.a(this.c, this.d, paramInt3, paramInt4);
        this.e = ((int)(this.c * f1));
        this.f = ((int)(this.d * f1));
        localObject = this.i.iterator();
        while (((Iterator)localObject).hasNext())
        {
          BaseLayer localBaseLayer = (BaseLayer)((Iterator)localObject).next();
          localBaseLayer.b(f1);
          localBaseLayer.a(paramInt1, paramInt2);
        }
      }
      this.e = 0;
      this.f = 0;
      SLog.e("DoodleView", "DoodleConfig is null.");
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.a;
    if ((localObject != null) && ((localObject instanceof LineLayer))) {
      return ((BaseLayer)localObject).d(paramMotionEvent);
    }
    if (paramMotionEvent.getActionMasked() == 0)
    {
      this.b = a(paramMotionEvent);
      BaseLayer localBaseLayer = this.b;
      localObject = this.k;
      if (localBaseLayer == localObject)
      {
        localBaseLayer = this.a;
        if ((localBaseLayer != localObject) && (localBaseLayer != null)) {
          this.b = localBaseLayer;
        }
      }
      localObject = this.b;
      if (((localObject instanceof ShapeLayer)) && (!(this.a instanceof ShapeLayer))) {
        ((ShapeLayer)localObject).a(true);
      }
      if (!(this.b instanceof ShapeLayer))
      {
        localObject = (ShapeLayer)this.j.get("ShapeLayer");
        if (localObject != null) {
          ((ShapeLayer)localObject).i().c();
        }
      }
      setTopLevelLayer(this.b);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b.toString());
      ((StringBuilder)localObject).append(" hold the TouchEvent.");
      SLog.b("DoodleView", ((StringBuilder)localObject).toString());
    }
    localObject = this.b;
    if (localObject != null) {
      return ((BaseLayer)localObject).d(paramMotionEvent);
    }
    return false;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (isShown()) {
      super.invalidate();
    }
  }
  
  public void setActiveLayer(BaseLayer paramBaseLayer)
  {
    this.a = paramBaseLayer;
  }
  
  public void setContentBounds(@Nullable RectF paramRectF)
  {
    this.u = paramRectF;
    invalidate();
  }
  
  public void setDoodleConfig(DoodleConfig paramDoodleConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init DoodleConfig: ");
    localStringBuilder.append(paramDoodleConfig.toString());
    SLog.b("DoodleView", localStringBuilder.toString());
    this.g = paramDoodleConfig;
    this.i.clear();
    this.j.clear();
    b();
  }
  
  public void setDoodleLayout(DoodleLayout paramDoodleLayout)
  {
    this.l = paramDoodleLayout;
  }
  
  public void setExtraTransform(@NonNull Matrix paramMatrix)
  {
    this.t.set(paramMatrix);
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((BaseLayer)localIterator.next()).a(paramMatrix);
    }
    invalidate();
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.s = paramLong;
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (a(paramLong))
      {
        requestLayout();
        invalidate();
      }
      return;
    }
    ThreadManager.getUIHandler().post(new DoodleView.2(this, paramLong));
  }
  
  public void setTopLevelLayer(BaseLayer paramBaseLayer)
  {
    Iterator localIterator = this.i.iterator();
    Object localObject = null;
    int i1 = 0;
    while (localIterator.hasNext())
    {
      BaseLayer localBaseLayer = (BaseLayer)localIterator.next();
      if ((localBaseLayer.e() > i1) && (!(localBaseLayer instanceof DynamicFaceLayer)))
      {
        i1 = localBaseLayer.e();
        localObject = localBaseLayer;
      }
    }
    if (paramBaseLayer != localObject)
    {
      paramBaseLayer.d(i1);
      if (localObject != null) {
        localObject.aw_();
      }
      paramBaseLayer.v();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView
 * JD-Core Version:    0.7.0.1
 */