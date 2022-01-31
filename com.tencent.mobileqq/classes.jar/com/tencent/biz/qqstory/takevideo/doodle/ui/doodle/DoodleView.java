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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import urk;
import uxs;
import uyd;
import uyn;
import uyq;
import uys;
import vbj;
import vbn;
import vct;

public class DoodleView
  extends View
{
  public int a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public EditVideoParams a;
  public DoodleLayout a;
  private List<uyn> jdField_a_of_type_JavaUtilList;
  private Map<String, uyn> jdField_a_of_type_JavaUtilMap;
  private uxs jdField_a_of_type_Uxs;
  private uyn jdField_a_of_type_Uyn;
  public uys a;
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
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Uxs);
    this.jdField_a_of_type_Uys.jdField_a_of_type_Uyq.a(this.jdField_a_of_type_JavaUtilList, this);
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      uyn localuyn = (uyn)((Iterator)localObject).next();
      this.jdField_a_of_type_JavaUtilMap.put(localuyn.a(), localuyn);
    }
    urk.b("DoodleView", "DoodleView hold layers:" + this.jdField_a_of_type_JavaUtilMap.toString());
    this.jdField_a_of_type_Uyn = this.jdField_a_of_type_Uxs;
    if (this.jdField_a_of_type_JavaUtilList.size() > 1) {}
    for (localObject = (uyn)this.jdField_a_of_type_JavaUtilList.get(1);; localObject = null)
    {
      if ((localObject != null) && ((((uyn)localObject).b() != this.c) || (((uyn)localObject).c() != this.d))) {
        onSizeChanged(this.c, this.d, ((uyn)localObject).b(), ((uyn)localObject).c());
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
      urk.b("DoodleView", "create Doodle bitmap, width:" + this.jdField_a_of_type_Int + ",height:" + this.b);
      bool1 = bool2;
      return bool1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      urk.c("DoodleView", "create doodle bitmap failed: %s", localOutOfMemoryError);
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
    Object localObject = (uyd)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if ((localObject != null) && (((uyd)localObject).a.a()) && (((uyd)localObject).a.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      ((uyd)localObject).a.b(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a()) && (localObject != null)) {
      ((uyd)localObject).c(localCanvas);
    }
    localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((uyn)((Map.Entry)((Iterator)localObject).next()).getValue()).b(localCanvas);
    }
    urk.b("DoodleView", "drawLayerInDoodleBitmap cost time:" + (SystemClock.uptimeMillis() - l));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Bitmap a()
  {
    if (!c())
    {
      urk.e("DoodleView", "create doodle bitmap failed.");
      return null;
    }
    h();
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public uyn a()
  {
    return this.jdField_a_of_type_Uyn;
  }
  
  public uyn a(MotionEvent paramMotionEvent)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      uyn localuyn = (uyn)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localuyn.b(paramMotionEvent)) {
        return localuyn;
      }
      i -= 1;
    }
    return this.jdField_a_of_type_Uxs;
  }
  
  public <LAYER extends uyn> LAYER a(String paramString)
  {
    paramString = (uyn)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    this.jdField_a_of_type_Uxs = new uxs(this);
    this.jdField_a_of_type_Uyn = this.jdField_a_of_type_Uxs;
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    Object localObject = (uyd)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if (localObject != null)
    {
      localObject = (vbn)((uyd)localObject).a.a(103);
      if (localObject != null)
      {
        if (!paramEditVideoParams.a()) {
          break label55;
        }
        ((vbn)localObject).a(104);
      }
    }
    return;
    label55:
    if ((paramEditVideoParams.a instanceof EditTakeVideoSource))
    {
      ((vbn)localObject).a(105);
      return;
    }
    ((vbn)localObject).a(103);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Uyn == this.jdField_a_of_type_Uxs;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public uyn b(MotionEvent paramMotionEvent)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      uyn localuyn = (uyn)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localuyn.c(paramMotionEvent)) {
        return localuyn;
      }
      i -= 1;
    }
    return this.jdField_a_of_type_Uxs;
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((uyn)localIterator.next()).f();
    }
    f();
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (!((uyn)localIterator.next()).a()) {
        return false;
      }
    }
    return true;
  }
  
  public void d()
  {
    setActiveLayer(this.jdField_a_of_type_Uxs);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((uyn)localIterator.next()).a();
      }
      if (this.jdField_a_of_type_AndroidGraphicsCanvas != null) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    super.invalidate();
  }
  
  public void f()
  {
    urk.b("DoodleView", "recycle bitmap.");
    if (d())
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidGraphicsCanvas = null;
    }
  }
  
  public void g()
  {
    uyd localuyd = (uyd)this.jdField_a_of_type_JavaUtilMap.get("LineLayer");
    if ((localuyd != null) && (localuyd.a.a()) && (this.jdField_a_of_type_Int > 0)) {
      localuyd.a.a(this.jdField_a_of_type_Int);
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
          uyn localuyn = (uyn)((Map.Entry)localIterator.next()).getValue();
          if ((localuyn instanceof uyd)) {
            ((uyd)localuyn).a.a(paramCanvas);
          }
        }
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((uyn)((Map.Entry)localIterator.next()).getValue()).d(paramCanvas);
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
    if (this.jdField_a_of_type_Uys != null)
    {
      urk.b("DoodleView", "DoodleViewWidth:" + paramInt1 + ",DoodleViewHeight:" + paramInt2 + ",MaxWidth:" + this.jdField_a_of_type_Uys.jdField_a_of_type_Int + ",MaxHeight:" + this.jdField_a_of_type_Uys.b);
      this.c = paramInt1;
      this.d = paramInt2;
      if (this.jdField_a_of_type_Uys.jdField_a_of_type_Int == 0)
      {
        paramInt3 = this.c;
        label108:
        if (this.jdField_a_of_type_Uys.b != 0) {
          break label227;
        }
      }
      label227:
      for (paramInt4 = this.d;; paramInt4 = this.jdField_a_of_type_Uys.b)
      {
        float f = vct.a(this.c, this.d, paramInt3, paramInt4);
        this.jdField_a_of_type_Int = ((int)(this.c * f));
        this.b = ((int)(this.d * f));
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          uyn localuyn = (uyn)localIterator.next();
          localuyn.b(f);
          localuyn.a(paramInt1, paramInt2);
        }
        break;
        paramInt3 = this.jdField_a_of_type_Uys.jdField_a_of_type_Int;
        break label108;
      }
    }
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    urk.e("DoodleView", "DoodleConfig is null.");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Uyn == this.jdField_a_of_type_Uxs) && (paramMotionEvent.getAction() == 0))
    {
      this.jdField_a_of_type_Uyn = a(paramMotionEvent);
      this.jdField_a_of_type_Uyn.b(true);
      urk.b("DoodleView", this.jdField_a_of_type_Uyn.toString() + " hold the TouchEvent.");
    }
    return this.jdField_a_of_type_Uyn.f(paramMotionEvent);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (isShown()) {
      super.invalidate();
    }
  }
  
  public void setActiveLayer(uyn paramuyn)
  {
    uyn localuyn = this.jdField_a_of_type_Uyn;
    this.jdField_a_of_type_Uyn = paramuyn;
    if (localuyn == this.jdField_a_of_type_Uyn) {
      return;
    }
    localuyn.h();
    this.jdField_a_of_type_Uyn.i();
  }
  
  public void setDoodleConfig(uys paramuys)
  {
    urk.b("DoodleView", "init DoodleConfig: " + paramuys.toString());
    this.jdField_a_of_type_Uys = paramuys;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView
 * JD-Core Version:    0.7.0.1
 */