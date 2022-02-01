package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextBuilder;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.TextParcelData;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeEffect;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.StoryGuideLineView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
public class TextLayer
  extends BaseLayer
{
  private static String N = "TextLayer";
  public static final String a = "TextLayer";
  public static int b;
  public static final int c = com.tencent.aelight.camera.struct.editor.HorizontalStroke.a[1];
  public static final int d = Color.parseColor("#80000000");
  public static int e;
  public static int f = 270;
  public static volatile int g = 5;
  private Paint M;
  public int h;
  public int i;
  public int j;
  public int k = d;
  public int l;
  public GestureHelper m;
  public int n;
  public int o;
  public int p;
  public int q;
  public TextLayer.LayerListener r;
  public TextLayer.TextItem s;
  public ArrayList<TextLayer.TextItem> t = new ArrayList();
  DynamicTextBuilder u = new DynamicTextBuilder();
  public Paint v;
  TextLayer.TextItem w;
  PointF x = new PointF();
  
  public TextLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    z();
  }
  
  private void A()
  {
    this.z.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  private boolean B()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool;
    if ((!((String)localObject).equalsIgnoreCase("vivo-vivo X6Plus D")) && (!((String)localObject).equalsIgnoreCase("motorola-Nexus 6"))) {
      bool = false;
    } else {
      bool = true;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isRubbish:");
    localStringBuilder.append(bool);
    localStringBuilder.append(" brand:");
    localStringBuilder.append((String)localObject);
    SLog.b(str, localStringBuilder.toString());
    return bool;
  }
  
  private void a(TextLayer.TextItem paramTextItem)
  {
    boolean bool1 = this.m.a(paramTextItem, StoryGuideLineView.a, true);
    boolean bool2 = this.m.a(paramTextItem, StoryGuideLineView.b, false);
    boolean bool3 = this.m.b(paramTextItem, StoryGuideLineView.d, false);
    TextLayer.LayerListener localLayerListener = this.r;
    if (localLayerListener != null) {
      localLayerListener.a(bool1, bool2, false, bool3, paramTextItem.S);
    }
    if (paramTextItem != null)
    {
      if (paramTextItem.M)
      {
        this.z.a(paramTextItem.S, paramTextItem.C, paramTextItem.D, paramTextItem.E, paramTextItem.A, paramTextItem.T, 2);
        return;
      }
      this.z.a(paramTextItem.S, paramTextItem.C, paramTextItem.D, paramTextItem.E, paramTextItem.A, paramTextItem.T, 1);
    }
  }
  
  public static void c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      g -= 1;
      break label26;
      g += 1;
      label26:
      g = Math.min(g, 5);
      g = Math.max(g, 4);
      return;
    }
    finally {}
  }
  
  private void z()
  {
    this.l = AIOUtils.b(50.0F, this.y.getResources());
    this.j = DisplayUtil.a(this.y);
    this.i = 1;
    this.h = 1;
    this.m = new GestureHelper();
    this.m.a(6.0F);
    this.m.b(0.2F);
    this.m.a(true);
    this.v = new Paint();
    this.v.setAntiAlias(true);
    this.v.setStyle(Paint.Style.STROKE);
    this.v.setColor(-1);
    this.v.setStrokeWidth(2.0F);
    this.M = new Paint();
    this.M.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    e = ViewConfiguration.get(this.y).getScaledTouchSlop();
    if ((f == 270) && (B())) {
      f = 540;
    }
  }
  
  public DynamicTextItem a(TextLayer.LayerParams paramLayerParams, SegmentKeeper paramSegmentKeeper, int paramInt)
  {
    if (this.t.size() < g)
    {
      if (paramLayerParams != null) {
        paramLayerParams = new TextLayer.TextItem(this, paramLayerParams);
      } else {
        paramLayerParams = new TextLayer.TextItem(this);
      }
      paramLayerParams.l = paramInt;
      paramLayerParams.U = new SegmentKeeper(paramSegmentKeeper);
      paramLayerParams.F.set(this.L);
      this.t.add(paramLayerParams);
      paramSegmentKeeper = paramLayerParams.c;
      this.s = paramLayerParams;
      return paramSegmentKeeper;
    }
    return null;
  }
  
  public String a()
  {
    return a;
  }
  
  public void a(int paramInt)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",preMode:");
    localStringBuilder.append(this.i);
    SLog.b(str, localStringBuilder.toString());
    this.i = this.h;
    this.h = paramInt;
    if (paramInt == 4) {
      x();
    }
    super.u();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    PointF localPointF = this.x;
    localPointF.x = (paramInt1 / 2);
    localPointF.y = (paramInt2 * 0.42F);
    b = (int)(this.z.getBitmapWidth() * 0.04F);
  }
  
  protected void a(Canvas paramCanvas)
  {
    int i1 = this.h;
    Object localObject;
    TextLayer.TextItem localTextItem;
    if (i1 == 6)
    {
      localObject = this.w;
      if (localObject != null) {
        ((TextLayer.TextItem)localObject).a(paramCanvas);
      }
      localObject = this.t.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localTextItem = (TextLayer.TextItem)((Iterator)localObject).next();
        if ((this.w != null) && (localTextItem.c != this.w.c)) {
          localTextItem.a(paramCanvas);
        }
      }
    }
    if ((i1 != 4) && (i1 != 3))
    {
      if (i1 == 5) {
        localObject = this.t.iterator();
      }
    }
    else {
      while (((Iterator)localObject).hasNext())
      {
        localTextItem = (TextLayer.TextItem)((Iterator)localObject).next();
        if (localTextItem.c != this.s.c)
        {
          localTextItem.a(paramCanvas);
          continue;
          localObject = this.t.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((TextLayer.TextItem)((Iterator)localObject).next()).a(paramCanvas);
          }
        }
      }
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat, boolean paramBoolean)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext()) {
      ((TextLayer.TextItem)localIterator.next()).b(paramCanvas);
    }
    paramCanvas.restore();
  }
  
  public void a(Matrix paramMatrix)
  {
    super.a(paramMatrix);
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext()) {
      ((TextLayer.TextItem)localIterator.next()).F.set(paramMatrix);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    super.a(paramBundle);
    a(paramBundle.getParcelableArrayList("TextParcelDataList"), paramBundle.getBoolean("edit_type_photo"));
  }
  
  public void a(DynamicTextItem paramDynamicTextItem)
  {
    if ((paramDynamicTextItem != null) && (this.t.size() > 0))
    {
      Object localObject = null;
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)localIterator.next();
        if (paramDynamicTextItem.equals(localTextItem.c)) {
          localObject = localTextItem;
        }
      }
      this.t.remove(localObject);
    }
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, ShapeEffect paramShapeEffect, RectF paramRectF)
  {
    b(paramDynamicTextItem);
    paramDynamicTextItem = this.s;
    if (paramDynamicTextItem != null)
    {
      paramDynamicTextItem.A.x = (paramRectF.left + this.s.G / 2.0F);
      this.s.A.y = (paramRectF.top + this.s.H / 2.0F);
    }
  }
  
  public void a(TextLayer.LayerListener paramLayerListener)
  {
    this.r = paramLayerListener;
  }
  
  public void a(ArrayList<TextParcelData> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      a(4);
      this.t.clear();
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        TextLayer.TextItem localTextItem = ((TextParcelData)paramArrayList.next()).a(this);
        localTextItem.F.set(this.L);
        this.t.add(localTextItem);
      } while (this.t.size() <= g);
    }
    u();
  }
  
  public void a(boolean paramBoolean)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setKeyboardState:");
    localStringBuilder.append(paramBoolean);
    SLog.b(str, localStringBuilder.toString());
    if (!paramBoolean) {
      a(4);
    }
    super.u();
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext()) {
      if (((TextLayer.TextItem)localIterator.next()).U.isSegmentChanged(paramLong)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (d())
    {
      int i1 = (int)paramMotionEvent.getY();
      int i2 = Math.abs(i1 - this.n);
      int i3 = paramMotionEvent.getAction() & 0xFF;
      if (i3 != 0)
      {
        if (i3 != 1)
        {
          if (i3 != 2)
          {
            if (i3 == 5) {
              this.s.c();
            }
          }
          else
          {
            if (this.h == 3) {
              this.s.c();
            }
            if (i2 > e) {
              a(3);
            }
          }
        }
        else
        {
          TextLayer.TextItem localTextItem = this.s;
          if (localTextItem != null) {
            localTextItem.c();
          }
          a(this, false);
          if (i2 < e) {
            i();
          } else if (this.h == 3) {
            a(4);
          }
        }
      }
      else
      {
        this.m.a(this.s);
        this.s.b();
        this.n = i1;
      }
      this.m.a(paramMotionEvent, false);
      paramMotionEvent = this.s;
      if (paramMotionEvent == null)
      {
        A();
        return true;
      }
      a(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.h = 1;
    this.i = 1;
    this.k = d;
    this.o = 0;
    this.t.clear();
    this.s = null;
    SLog.b(a, "clear over");
  }
  
  public void b(int paramInt)
  {
    if (paramInt < 0)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTextTop:");
      localStringBuilder.append(paramInt);
      SLog.e(str, localStringBuilder.toString());
      return;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTextTop:");
    localStringBuilder.append(paramInt);
    SLog.b(str, localStringBuilder.toString());
    this.o = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0))
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTextTop:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("y=");
      localStringBuilder.append(paramInt2);
      SLog.b(str, localStringBuilder.toString());
      this.p = paramInt1;
      this.q = paramInt2;
      return;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTextOffset x:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("y=");
    localStringBuilder.append(paramInt2);
    SLog.e(str, localStringBuilder.toString());
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.J, false);
  }
  
  public void b(DynamicTextItem paramDynamicTextItem)
  {
    TextLayer.TextItem localTextItem = this.s;
    if (localTextItem != null)
    {
      localTextItem.c = paramDynamicTextItem;
      localTextItem.G = paramDynamicTextItem.c();
      this.s.H = paramDynamicTextItem.d();
    }
    localTextItem = this.w;
    if (localTextItem != null)
    {
      localTextItem.c = paramDynamicTextItem;
      paramDynamicTextItem = this.s;
      if (paramDynamicTextItem != null)
      {
        localTextItem.B = paramDynamicTextItem.B;
        this.w.d = this.s.B;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    a(5);
    if (paramBoolean) {
      k();
    }
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    boolean bool2 = d();
    boolean bool1 = true;
    if (bool2)
    {
      float f1 = paramMotionEvent.getX(0);
      float f2 = paramMotionEvent.getY(0);
      int i1 = this.t.size() - 1;
      while (i1 >= 0)
      {
        paramMotionEvent = (TextLayer.TextItem)this.t.get(i1);
        if (((paramMotionEvent == null) || (paramMotionEvent.U == null) || (!paramMotionEvent.e()) || (paramMotionEvent.U.isCurrentIn())) && (this.m.a(paramMotionEvent, f1, f2, false)))
        {
          this.s = paramMotionEvent;
          break label120;
        }
        i1 -= 1;
      }
    }
    bool1 = false;
    label120:
    if (bool1)
    {
      this.t.remove(this.s);
      this.t.add(this.s);
    }
    return bool1;
  }
  
  public DynamicTextItem c(int paramInt)
  {
    return a(null, null, paramInt);
  }
  
  public boolean c()
  {
    return this.h == 1;
  }
  
  public boolean d()
  {
    int i1 = this.h;
    return (i1 == 4) || (i1 == 3);
  }
  
  public boolean h()
  {
    return (this.p > 0) && (this.q > 0);
  }
  
  public void i()
  {
    TextLayer.LayerListener localLayerListener = this.r;
    if (localLayerListener != null)
    {
      TextLayer.TextItem localTextItem = this.s;
      if (localTextItem != null)
      {
        if (localLayerListener.a(localTextItem))
        {
          this.t.remove(this.s);
          return;
        }
        this.r.a(this.s.c);
      }
    }
  }
  
  public TextLayer.TextItem j()
  {
    ArrayList localArrayList = this.t;
    if ((localArrayList != null) && (localArrayList.size() > g))
    {
      this.t.remove(this.s);
      return this.s;
    }
    return null;
  }
  
  public void k()
  {
    Object localObject;
    if (!c())
    {
      a(6);
      localObject = this.s;
      if (localObject != null)
      {
        this.w = new TextLayer.TextItem(this, (TextLayer.TextItem)localObject);
        this.w.a();
        TextLayer.TextItem.a(this.w);
      }
    }
    else
    {
      localObject = this.r;
      if (localObject != null) {
        ((TextLayer.LayerListener)localObject).a(1.0F);
      }
    }
  }
  
  public void l()
  {
    if (this.t.size() > 0)
    {
      ArrayList localArrayList = this.t;
      localArrayList.remove(localArrayList.size() - 1);
    }
  }
  
  public void m()
  {
    Object localObject1 = new ArrayList();
    Object localObject2;
    if (this.t.size() > 0)
    {
      localObject2 = this.t.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)((Iterator)localObject2).next();
        if ((localTextItem.c != null) && (localTextItem.c.m())) {
          ((List)localObject1).add(localTextItem);
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TextLayer.TextItem)((Iterator)localObject1).next();
      this.t.remove(localObject2);
    }
    localObject1 = this.s;
    if ((localObject1 != null) && (((TextLayer.TextItem)localObject1).c != null) && (this.s.c.m())) {
      this.s = null;
    }
  }
  
  public void n()
  {
    if (this.w != null)
    {
      a(6);
      TextLayer.TextItem.b(this.w);
    }
  }
  
  public DynamicTextItem o()
  {
    TextLayer.TextItem localTextItem = this.s;
    if (localTextItem != null) {
      return localTextItem.c;
    }
    return null;
  }
  
  public void p()
  {
    Object localObject = this.s;
    if (localObject != null)
    {
      this.t.remove(localObject);
      this.s.c();
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete ");
      localStringBuilder.append(this.s);
      SLog.b((String)localObject, localStringBuilder.toString());
      this.s = null;
    }
    if (this.t.size() == 0)
    {
      this.h = 1;
      this.i = 1;
    }
  }
  
  public int q()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void r()
  {
    Object localObject = this.s;
    if ((localObject != null) && (((TextLayer.TextItem)localObject).c != null)) {
      this.s.c.a(-1, false);
    }
    localObject = this.t;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TextLayer.TextItem localTextItem = (TextLayer.TextItem)((Iterator)localObject).next();
        if (localTextItem.c != null) {
          localTextItem.c.a(-1, false);
        }
      }
    }
    u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer
 * JD-Core Version:    0.7.0.1
 */