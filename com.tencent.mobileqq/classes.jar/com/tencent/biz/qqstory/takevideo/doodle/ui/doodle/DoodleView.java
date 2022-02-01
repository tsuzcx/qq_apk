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
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import ykq;
import yqu;
import yre;
import yro;
import yrr;
import yrt;
import yud;
import yuh;

public class DoodleView
  extends View
{
  public int a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public EditVideoParams a;
  public DoodleLayout a;
  private List<yro> jdField_a_of_type_JavaUtilList;
  private Map<String, yro> jdField_a_of_type_JavaUtilMap;
  private yqu jdField_a_of_type_Yqu;
  private yro jdField_a_of_type_Yro;
  public yrt a;
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
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Yqu);
    this.jdField_a_of_type_Yrt.jdField_a_of_type_Yrr.a(this.jdField_a_of_type_JavaUtilList, this);
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      yro localyro = (yro)((Iterator)localObject).next();
      this.jdField_a_of_type_JavaUtilMap.put(localyro.a(), localyro);
    }
    ykq.b("DoodleView", "DoodleView hold layers:" + this.jdField_a_of_type_JavaUtilMap.toString());
    this.jdField_a_of_type_Yro = this.jdField_a_of_type_Yqu;
    if (this.jdField_a_of_type_JavaUtilList.size() > 1) {}
    for (localObject = (yro)this.jdField_a_of_type_JavaUtilList.get(1);; localObject = null)
    {
      if ((localObject != null) && ((((yro)localObject).b() != this.c) || (((yro)localObject).c() != this.d))) {
        onSizeChanged(this.c, this.d, ((yro)localObject).b(), ((yro)localObject).c());
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
      ykq.b("DoodleView", "create Doodle bitmap, width:" + this.jdField_a_of_type_Int + ",height:" + this.b);
      bool1 = bool2;
      return bool1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ykq.c("DoodleView", "create doodle bitmap failed: %s", localOutOfMemoryError);
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
    Object localObject = (yre)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if ((localObject != null) && (((yre)localObject).a.a()) && (((yre)localObject).a.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      ((yre)localObject).a.b(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.isEditPhoto()) && (localObject != null)) {
      ((yre)localObject).c(localCanvas);
    }
    localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((yro)((Map.Entry)((Iterator)localObject).next()).getValue()).b(localCanvas);
    }
    ykq.b("DoodleView", "drawLayerInDoodleBitmap cost time:" + (SystemClock.uptimeMillis() - l));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Bitmap a()
  {
    if (!c())
    {
      ykq.e("DoodleView", "create doodle bitmap failed.");
      return null;
    }
    h();
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public yro a()
  {
    return this.jdField_a_of_type_Yro;
  }
  
  public yro a(MotionEvent paramMotionEvent)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      yro localyro = (yro)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localyro.b(paramMotionEvent)) {
        return localyro;
      }
      i -= 1;
    }
    return this.jdField_a_of_type_Yqu;
  }
  
  public <LAYER extends yro> LAYER a(String paramString)
  {
    paramString = (yro)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    this.jdField_a_of_type_Yqu = new yqu(this);
    this.jdField_a_of_type_Yro = this.jdField_a_of_type_Yqu;
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    Object localObject = (yre)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if (localObject != null)
    {
      localObject = (yuh)((yre)localObject).a.a(103);
      if (localObject != null)
      {
        if (!paramEditVideoParams.isEditPhoto()) {
          break label55;
        }
        ((yuh)localObject).a(104);
      }
    }
    return;
    label55:
    if ((paramEditVideoParams.mEditSource instanceof EditTakeVideoSource))
    {
      ((yuh)localObject).a(105);
      return;
    }
    ((yuh)localObject).a(103);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Yro == this.jdField_a_of_type_Yqu;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public yro b(MotionEvent paramMotionEvent)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      yro localyro = (yro)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localyro.c(paramMotionEvent)) {
        return localyro;
      }
      i -= 1;
    }
    return this.jdField_a_of_type_Yqu;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((yro)localIterator.next()).f();
    }
    f();
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (!((yro)localIterator.next()).a()) {
        return false;
      }
    }
    return true;
  }
  
  public void d()
  {
    setActiveLayer(this.jdField_a_of_type_Yqu);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((yro)localIterator.next()).a();
      }
      if (this.jdField_a_of_type_AndroidGraphicsCanvas != null) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    super.invalidate();
  }
  
  public void f()
  {
    ykq.b("DoodleView", "recycle bitmap.");
    if (d())
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
    }
  }
  
  public void g()
  {
    yre localyre = (yre)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if ((localyre != null) && (localyre.a.a()) && (this.jdField_a_of_type_Int > 0)) {
      localyre.a.a(this.jdField_a_of_type_Int);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.isEditPhoto()))
      {
        localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          yro localyro = (yro)((Map.Entry)localIterator.next()).getValue();
          if ((localyro instanceof yre)) {
            ((yre)localyro).a.a(paramCanvas);
          }
        }
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((yro)((Map.Entry)localIterator.next()).getValue()).d(paramCanvas);
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
    if (this.jdField_a_of_type_Yrt != null)
    {
      ykq.b("DoodleView", "DoodleViewWidth:" + paramInt1 + ",DoodleViewHeight:" + paramInt2 + ",MaxWidth:" + this.jdField_a_of_type_Yrt.jdField_a_of_type_Int + ",MaxHeight:" + this.jdField_a_of_type_Yrt.b);
      this.c = paramInt1;
      this.d = paramInt2;
      if (this.jdField_a_of_type_Yrt.jdField_a_of_type_Int == 0)
      {
        paramInt3 = this.c;
        label108:
        if (this.jdField_a_of_type_Yrt.b != 0) {
          break label227;
        }
      }
      label227:
      for (paramInt4 = this.d;; paramInt4 = this.jdField_a_of_type_Yrt.b)
      {
        float f = DisplayUtil.getFitScaleValue(this.c, this.d, paramInt3, paramInt4);
        this.jdField_a_of_type_Int = ((int)(this.c * f));
        this.b = ((int)(this.d * f));
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          yro localyro = (yro)localIterator.next();
          localyro.a(f);
          localyro.a(paramInt1, paramInt2);
        }
        break;
        paramInt3 = this.jdField_a_of_type_Yrt.jdField_a_of_type_Int;
        break label108;
      }
    }
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    ykq.e("DoodleView", "DoodleConfig is null.");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Yro == this.jdField_a_of_type_Yqu) && (paramMotionEvent.getAction() == 0))
    {
      this.jdField_a_of_type_Yro = a(paramMotionEvent);
      this.jdField_a_of_type_Yro.b(true);
      ykq.b("DoodleView", this.jdField_a_of_type_Yro.toString() + " hold the TouchEvent.");
    }
    return this.jdField_a_of_type_Yro.f(paramMotionEvent);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (isShown()) {
      super.invalidate();
    }
  }
  
  public void setActiveLayer(yro paramyro)
  {
    yro localyro = this.jdField_a_of_type_Yro;
    this.jdField_a_of_type_Yro = paramyro;
    if (localyro == this.jdField_a_of_type_Yro) {
      return;
    }
    localyro.h();
    this.jdField_a_of_type_Yro.i();
  }
  
  public void setDoodleConfig(yrt paramyrt)
  {
    ykq.b("DoodleView", "init DoodleConfig: " + paramyrt.toString());
    this.jdField_a_of_type_Yrt = paramyrt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView
 * JD-Core Version:    0.7.0.1
 */