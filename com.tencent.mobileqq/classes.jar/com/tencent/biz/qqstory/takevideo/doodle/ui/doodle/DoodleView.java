package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.layer.EmptyLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleStrategy;
import com.tencent.biz.qqstory.takevideo.doodle.layer.config.DoodleConfig;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DoodleView
  extends View
{
  public int a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public EditVideoParams a;
  private EmptyLayer jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  private BaseLayer jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer;
  public DoodleConfig a;
  public DoodleLayout a;
  private List jdField_a_of_type_JavaUtilList;
  private Map jdField_a_of_type_JavaUtilMap;
  public boolean a;
  public int b;
  private int c;
  private int d;
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseDoodleStrategy.a(this.jdField_a_of_type_JavaUtilList, this);
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseLayer localBaseLayer = (BaseLayer)((Iterator)localObject).next();
      this.jdField_a_of_type_JavaUtilMap.put(localBaseLayer.a(), localBaseLayer);
    }
    SLog.b("DoodleView", "DoodleView hold layers:" + this.jdField_a_of_type_JavaUtilMap.toString());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
    if (this.jdField_a_of_type_JavaUtilList.size() > 1) {}
    for (localObject = (BaseLayer)this.jdField_a_of_type_JavaUtilList.get(1);; localObject = null)
    {
      if ((localObject != null) && ((((BaseLayer)localObject).b() != this.c) || (((BaseLayer)localObject).c() != this.d))) {
        onSizeChanged(this.c, this.d, ((BaseLayer)localObject).b(), ((BaseLayer)localObject).c());
      }
      super.requestLayout();
      return;
    }
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (this.jdField_a_of_type_Int > 0)
    {
      bool1 = bool3;
      if (this.b > 0) {
        bool1 = bool2;
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.b, Bitmap.Config.ARGB_8888);
      bool1 = bool2;
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      bool1 = true;
      bool2 = true;
      SLog.b("DoodleView", "create Doodle bitmap, width:" + this.jdField_a_of_type_Int + ",height:" + this.b);
      bool1 = bool2;
      return bool1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      SLog.c("DoodleView", "create doodle bitmap failed: %s", localOutOfMemoryError);
    }
    return bool1;
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled());
  }
  
  private void h()
  {
    long l = SystemClock.uptimeMillis();
    Object localObject = (LineLayer)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if ((localObject != null) && (((LineLayer)localObject).a.a()) && (((LineLayer)localObject).a.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      ((LineLayer)localObject).a.b(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a()) && (localObject != null)) {
      ((LineLayer)localObject).c(localCanvas);
    }
    localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((BaseLayer)((Map.Entry)((Iterator)localObject).next()).getValue()).b(localCanvas);
    }
    SLog.b("DoodleView", "drawLayerInDoodleBitmap cost time:" + (SystemClock.uptimeMillis() - l));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Bitmap a()
  {
    if (!c())
    {
      SLog.e("DoodleView", "create doodle bitmap failed.");
      return null;
    }
    h();
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public BaseLayer a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer;
  }
  
  public BaseLayer a(MotionEvent paramMotionEvent)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      BaseLayer localBaseLayer = (BaseLayer)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localBaseLayer.b(paramMotionEvent)) {
        return localBaseLayer;
      }
      i -= 1;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  }
  
  public BaseLayer a(String paramString)
  {
    paramString = (BaseLayer)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      throw new IllegalArgumentException("this layer is not exist in DoodleView.");
    }
    return paramString;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer = new EmptyLayer(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    Object localObject = (LineLayer)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if (localObject != null)
    {
      localObject = (MosaicOperator)((LineLayer)localObject).a.a(103);
      if (localObject != null)
      {
        if (!paramEditVideoParams.a()) {
          break label55;
        }
        ((MosaicOperator)localObject).a(104);
      }
    }
    return;
    label55:
    if ((paramEditVideoParams.a instanceof EditTakeVideoSource))
    {
      ((MosaicOperator)localObject).a(105);
      return;
    }
    ((MosaicOperator)localObject).a(103);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer == this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public BaseLayer b(MotionEvent paramMotionEvent)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      BaseLayer localBaseLayer = (BaseLayer)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localBaseLayer.c(paramMotionEvent)) {
        return localBaseLayer;
      }
      i -= 1;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((BaseLayer)localIterator.next()).f();
    }
    f();
  }
  
  public boolean b()
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
    setActiveLayer(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((BaseLayer)localIterator.next()).a();
      }
      if (this.jdField_a_of_type_AndroidGraphicsCanvas != null) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
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
    if ((localLineLayer != null) && (localLineLayer.a.a()) && (this.jdField_a_of_type_Int > 0)) {
      localLineLayer.a.a(this.jdField_a_of_type_Int);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a()))
      {
        localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          BaseLayer localBaseLayer = (BaseLayer)((Map.Entry)localIterator.next()).getValue();
          if ((localBaseLayer instanceof LineLayer)) {
            ((LineLayer)localBaseLayer).a.a(paramCanvas);
          }
        }
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((BaseLayer)((Map.Entry)localIterator.next()).getValue()).d(paramCanvas);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if ((j != -2147483648) || (k == -2147483648)) {
      paramInt1 = i * 3 / 2;
    }
    setMeasuredDimension(i, paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig != null)
    {
      SLog.b("DoodleView", "DoodleViewWidth:" + paramInt1 + ",DoodleViewHeight:" + paramInt2 + ",MaxWidth:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_Int + ",MaxHeight:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.b);
      this.c = paramInt1;
      this.d = paramInt2;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_Int == 0)
      {
        paramInt3 = this.c;
        label108:
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.b != 0) {
          break label227;
        }
      }
      label227:
      for (paramInt4 = this.d;; paramInt4 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.b)
      {
        float f = DisplayUtil.a(this.c, this.d, paramInt3, paramInt4);
        this.jdField_a_of_type_Int = ((int)(this.c * f));
        this.b = ((int)(this.d * f));
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          BaseLayer localBaseLayer = (BaseLayer)localIterator.next();
          localBaseLayer.a(f);
          localBaseLayer.a(paramInt1, paramInt2);
        }
        break;
        paramInt3 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig.jdField_a_of_type_Int;
        break label108;
      }
    }
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    SLog.e("DoodleView", "DoodleConfig is null.");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer == this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer) && (paramMotionEvent.getAction() == 0))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer = a(paramMotionEvent);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer.b(true);
      SLog.b("DoodleView", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer.toString() + " hold the TouchEvent.");
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer.f(paramMotionEvent);
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
    BaseLayer localBaseLayer = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer = paramBaseLayer;
    if (localBaseLayer == this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer) {
      return;
    }
    localBaseLayer.h();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer.i();
  }
  
  public void setDoodleConfig(DoodleConfig paramDoodleConfig)
  {
    SLog.b("DoodleView", "init DoodleConfig: " + paramDoodleConfig.toString());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerConfigDoodleConfig = paramDoodleConfig;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    c();
  }
  
  public void setDoodleLayout(DoodleLayout paramDoodleLayout)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = paramDoodleLayout;
  }
  
  public void setEnableVisible(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView
 * JD-Core Version:    0.7.0.1
 */