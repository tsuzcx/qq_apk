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
  public int a;
  private long jdField_a_of_type_Long = 0L;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  @Nullable
  private RectF jdField_a_of_type_AndroidGraphicsRectF = null;
  protected EmptyLayer a;
  private BaseLayer jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer;
  public DoodleConfig a;
  public DoodleLayout a;
  public EditVideoParams a;
  private Comparator<BaseLayer> jdField_a_of_type_JavaUtilComparator = new DoodleView.1(this);
  private LinkedList<BaseLayer> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  protected List<BaseLayer> a;
  protected Map<String, BaseLayer> a;
  public boolean a;
  public int b;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private BaseLayer jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer;
  public int c;
  public int d;
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
      if (localObject == null) {
        return paramBitmap;
      }
      Rect localRect1 = new Rect((int)((RectF)localObject).left, (int)this.jdField_a_of_type_AndroidGraphicsRectF.top, (int)this.jdField_a_of_type_AndroidGraphicsRectF.right, (int)this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
      Rect localRect2 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      localObject = paramBitmap;
      if (localRect2.intersect(localRect1))
      {
        localObject = paramBitmap;
        if (!localRect2.isEmpty()) {
          localObject = Bitmap.createBitmap(paramBitmap, localRect2.left, localRect2.top, localRect2.width(), localRect2.height());
        }
      }
    }
    return localObject;
  }
  
  private boolean a()
  {
    int i = this.c;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (i > 0)
    {
      int j = this.d;
      bool1 = bool3;
      if (j > 0)
      {
        bool1 = bool2;
        try
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          bool1 = bool2;
          this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
          bool2 = true;
          bool1 = bool2;
          StringBuilder localStringBuilder = new StringBuilder();
          bool1 = bool2;
          localStringBuilder.append("create Doodle bitmap, width:");
          bool1 = bool2;
          localStringBuilder.append(this.c);
          bool1 = bool2;
          localStringBuilder.append(",height:");
          bool1 = bool2;
          localStringBuilder.append(this.d);
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
  
  private boolean a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null)
    {
      if (((Map)localObject).size() == 0) {
        return false;
      }
      localObject = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((BaseLayer)((Iterator)localObject).next()).a(paramLong)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerEmptyLayer);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseDoodleStrategy.a(this.jdField_a_of_type_JavaUtilList, this);
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseLayer localBaseLayer = (BaseLayer)((Iterator)localObject).next();
      this.jdField_a_of_type_JavaUtilMap.put(localBaseLayer.a(), localBaseLayer);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DoodleView hold layers:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilMap.toString());
    SLog.b("DoodleView", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerEmptyLayer;
    if (this.jdField_a_of_type_JavaUtilList.size() > 1) {
      localObject = (BaseLayer)this.jdField_a_of_type_JavaUtilList.get(1);
    } else {
      localObject = null;
    }
    if ((localObject != null) && ((((BaseLayer)localObject).c() != this.jdField_a_of_type_Int) || (((BaseLayer)localObject).d() != this.jdField_b_of_type_Int))) {
      onSizeChanged(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, ((BaseLayer)localObject).c(), ((BaseLayer)localObject).d());
    }
    super.requestLayout();
  }
  
  private boolean d()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    return (localBitmap != null) && (!localBitmap.isRecycled());
  }
  
  private void h()
  {
    long l = SystemClock.uptimeMillis();
    Object localObject2 = (LineLayer)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if ((localObject2 != null) && (((LineLayer)localObject2).a.a()) && (((LineLayer)localObject2).a.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      ((LineLayer)localObject2).a.b(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    Object localObject1 = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams;
    if ((localObject3 != null) && (((EditVideoParams)localObject3).a()) && (localObject2 != null)) {
      ((LineLayer)localObject2).c((Canvas)localObject1);
    }
    localObject2 = new LinkedList(this.jdField_a_of_type_JavaUtilMap.values());
    Collections.sort((List)localObject2, this.jdField_a_of_type_JavaUtilComparator);
    int i = ((LinkedList)localObject2).size() - 1;
    while (i >= 0)
    {
      localObject3 = (BaseLayer)((LinkedList)localObject2).get(i);
      if (localObject3 != null) {
        ((BaseLayer)localObject3).b((Canvas)localObject1);
      }
      i -= 1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("drawLayerInDoodleBitmap cost time:");
    ((StringBuilder)localObject1).append(SystemClock.uptimeMillis() - l);
    SLog.b("DoodleView", ((StringBuilder)localObject1).toString());
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Bitmap a()
  {
    if (!a())
    {
      SLog.e("DoodleView", "create doodle bitmap failed.");
      return null;
    }
    h();
    return a(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  @Nullable
  public RectF a()
  {
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    if (localRectF == null) {
      return null;
    }
    return new RectF(localRectF);
  }
  
  public BaseLayer a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer;
  }
  
  public BaseLayer a(MotionEvent paramMotionEvent)
  {
    LinkedList localLinkedList = new LinkedList(this.jdField_a_of_type_JavaUtilList);
    Collections.sort(localLinkedList, this.jdField_a_of_type_JavaUtilComparator);
    int i = 0;
    while (i < localLinkedList.size())
    {
      BaseLayer localBaseLayer = (BaseLayer)localLinkedList.get(i);
      if ((localBaseLayer != null) && (localBaseLayer.b(paramMotionEvent))) {
        return localBaseLayer;
      }
      i += 1;
    }
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerEmptyLayer;
  }
  
  public <LAYER extends BaseLayer> LAYER a(String paramString)
  {
    paramString = (BaseLayer)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString;
    }
    throw new IllegalArgumentException("this layer is not exist in DoodleView.");
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerEmptyLayer = new EmptyLayer(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerEmptyLayer;
    setLayerType(1, null);
  }
  
  public void a(BaseLayer paramBaseLayer)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer == paramBaseLayer) {
      d();
    }
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams = paramEditVideoParams;
    Object localObject = (LineLayer)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if (localObject != null)
    {
      localObject = (MosaicOperator)((LineLayer)localObject).a.a(103);
      if (localObject != null)
      {
        if (paramEditVideoParams.a())
        {
          ((MosaicOperator)localObject).a(104);
          return;
        }
        if ((!(paramEditVideoParams.a instanceof EditTakeVideoSource)) && (!(paramEditVideoParams.a instanceof EditLocalVideoSource)))
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
    DoodleLayout localDoodleLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout;
    if (localDoodleLayout == null) {
      return;
    }
    localDoodleLayout.a(paramBoolean1, paramFloat1, (int)paramFloat2, (int)paramFloat3, paramPointF, paramBoolean2, paramInt);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((BaseLayer)localIterator.next()).b();
    }
    f();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer == this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerEmptyLayer;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public boolean c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (!((BaseLayer)localIterator.next()).a()) {
        return false;
      }
    }
    return true;
  }
  
  public void d()
  {
    setActiveLayer(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerEmptyLayer);
    setTopLevelLayer(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerEmptyLayer);
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BaseLayer)((Iterator)localObject).next()).a();
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsCanvas;
      if (localObject != null) {
        ((Canvas)localObject).drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    super.invalidate();
  }
  
  public void f()
  {
    SLog.b("DoodleView", "recycle bitmap.");
    if (d())
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
    }
  }
  
  public void g()
  {
    LineLayer localLineLayer = (LineLayer)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if ((localLineLayer != null) && (localLineLayer.a.a()) && (this.c > 0)) {
      localLineLayer.a.a(this.c);
    }
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsRectF != null)
    {
      paramCanvas.save();
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsRectF);
      paramCanvas.clipRect(this.jdField_b_of_type_AndroidGraphicsRectF);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams;
    if ((localObject != null) && (((EditVideoParams)localObject).a()))
    {
      localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseLayer localBaseLayer = (BaseLayer)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((localBaseLayer instanceof LineLayer)) {
          ((LineLayer)localBaseLayer).a.a(paramCanvas);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.addAll(this.jdField_a_of_type_JavaUtilMap.values());
    Collections.sort(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilComparator);
    int i = this.jdField_a_of_type_JavaUtilLinkedList.size() - 1;
    while (i >= 0)
    {
      localObject = (BaseLayer)this.jdField_a_of_type_JavaUtilLinkedList.get(i);
      if (localObject != null) {
        ((BaseLayer)localObject).d(paramCanvas);
      }
      i -= 1;
    }
    if (this.jdField_a_of_type_AndroidGraphicsRectF != null) {
      paramCanvas.restore();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (j == -2147483648) {
      paramInt1 = i * 3 / 2;
    }
    setMeasuredDimension(i, paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerConfigDoodleConfig != null)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("DoodleViewWidth:");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(",DoodleViewHeight:");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(",MaxWidth:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(",MaxHeight:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerConfigDoodleConfig.jdField_b_of_type_Int);
        SLog.b("DoodleView", ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_b_of_type_Int = paramInt2;
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_Int == 0) {
          paramInt3 = this.jdField_a_of_type_Int;
        } else {
          paramInt3 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_Int;
        }
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerConfigDoodleConfig.jdField_b_of_type_Int == 0) {
          paramInt4 = this.jdField_b_of_type_Int;
        } else {
          paramInt4 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerConfigDoodleConfig.jdField_b_of_type_Int;
        }
        float f = DisplayUtil.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt3, paramInt4);
        this.c = ((int)(this.jdField_a_of_type_Int * f));
        this.d = ((int)(this.jdField_b_of_type_Int * f));
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          BaseLayer localBaseLayer = (BaseLayer)((Iterator)localObject).next();
          localBaseLayer.b(f);
          localBaseLayer.a(paramInt1, paramInt2);
        }
      }
      this.c = 0;
      this.d = 0;
      SLog.e("DoodleView", "DoodleConfig is null.");
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer;
    if ((localObject != null) && ((localObject instanceof LineLayer))) {
      return ((BaseLayer)localObject).d(paramMotionEvent);
    }
    if (paramMotionEvent.getActionMasked() == 0)
    {
      this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer = a(paramMotionEvent);
      BaseLayer localBaseLayer = this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer;
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerEmptyLayer;
      if (localBaseLayer == localObject)
      {
        localBaseLayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer;
        if ((localBaseLayer != localObject) && (localBaseLayer != null)) {
          this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer = localBaseLayer;
        }
      }
      localObject = this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer;
      if (((localObject instanceof ShapeLayer)) && (!(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer instanceof ShapeLayer))) {
        ((ShapeLayer)localObject).a(true);
      }
      if (!(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer instanceof ShapeLayer))
      {
        localObject = (ShapeLayer)this.jdField_a_of_type_JavaUtilMap.get("ShapeLayer");
        if (localObject != null) {
          ((ShapeLayer)localObject).a().a();
        }
      }
      setTopLevelLayer(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer.toString());
      ((StringBuilder)localObject).append(" hold the TouchEvent.");
      SLog.b("DoodleView", ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer;
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
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseBaseLayer = paramBaseLayer;
  }
  
  public void setContentBounds(@Nullable RectF paramRectF)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = paramRectF;
    invalidate();
  }
  
  public void setDoodleConfig(DoodleConfig paramDoodleConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init DoodleConfig: ");
    localStringBuilder.append(paramDoodleConfig.toString());
    SLog.b("DoodleView", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerConfigDoodleConfig = paramDoodleConfig;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    c();
  }
  
  public void setDoodleLayout(DoodleLayout paramDoodleLayout)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout = paramDoodleLayout;
  }
  
  public void setExtraTransform(@NonNull Matrix paramMatrix)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(paramMatrix);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((BaseLayer)localIterator.next()).a(paramMatrix);
    }
    invalidate();
  }
  
  public void setTimeStamp(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject = null;
    int i = 0;
    while (localIterator.hasNext())
    {
      BaseLayer localBaseLayer = (BaseLayer)localIterator.next();
      if ((localBaseLayer.a() > i) && (!(localBaseLayer instanceof DynamicFaceLayer)))
      {
        i = localBaseLayer.a();
        localObject = localBaseLayer;
      }
    }
    if (paramBaseLayer != localObject)
    {
      paramBaseLayer.c(i);
      if (localObject != null) {
        localObject.c();
      }
      paramBaseLayer.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView
 * JD-Core Version:    0.7.0.1
 */