package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import org.jetbrains.annotations.NotNull;

public class ShapeOperator
  implements DoodleOperator, ShapeEffect.InteractionListener
{
  private float a;
  private float b;
  private float c = 1.0F;
  private int d;
  private int e;
  private Context f;
  private ShapeOperator.Shape g;
  private boolean h;
  private int i;
  private float j;
  private boolean k;
  private boolean l = false;
  private ShapeEffect m;
  private ShapeEffect n;
  private ShapeEffect o;
  private final LinkedList<ShapeEffect> p = new LinkedList();
  private ShapeEffect.InteractionListener q;
  
  public ShapeOperator(Context paramContext)
  {
    this.f = paramContext;
  }
  
  @NotNull
  private static ShapeEffect a(ShapeOperator.Shape paramShape, Context paramContext, float paramFloat, int paramInt, ShapeEffect.InteractionListener paramInteractionListener)
  {
    paramShape = new ShapeEffect(paramContext, paramShape, paramFloat, paramInt);
    paramShape.a(paramInteractionListener);
    return paramShape;
  }
  
  private void a(Canvas paramCanvas, boolean paramBoolean)
  {
    Object localObject = this.p.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ShapeEffect localShapeEffect = (ShapeEffect)((Iterator)localObject).next();
      boolean bool2 = true;
      boolean bool1;
      if ((!paramBoolean) && (localShapeEffect == this.o)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localShapeEffect.a(bool1);
      if ((!paramBoolean) && (!this.k) && (localShapeEffect == this.m)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localShapeEffect.b(bool1);
      localShapeEffect.a(paramCanvas);
    }
    localObject = this.n;
    if (localObject != null) {
      ((ShapeEffect)localObject).a(paramCanvas);
    }
  }
  
  private ShapeEffect b(int paramInt1, int paramInt2)
  {
    Object localObject = this.o;
    if (localObject != null) {
      if ((!((ShapeEffect)localObject).b(paramInt1, paramInt2)) && (!this.o.a(paramInt1, paramInt2)))
      {
        localObject = this.o;
        float f1 = paramInt1;
        float f2 = paramInt2;
        if ((!((ShapeEffect)localObject).c(f1, f2)) && (!this.o.d(f1, f2))) {}
      }
      else
      {
        return this.o;
      }
    }
    localObject = this.p.descendingIterator();
    while (((Iterator)localObject).hasNext())
    {
      ShapeEffect localShapeEffect = (ShapeEffect)((Iterator)localObject).next();
      if ((localShapeEffect.a(paramInt1, paramInt2)) || (localShapeEffect.d(paramInt1, paramInt2))) {
        return localShapeEffect;
      }
    }
    return null;
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    ShapeEffect localShapeEffect = this.n;
    if (localShapeEffect != null) {
      return localShapeEffect.a(paramMotionEvent);
    }
    localShapeEffect = this.o;
    if (localShapeEffect != null) {
      return localShapeEffect.a(paramMotionEvent);
    }
    return false;
  }
  
  private void d(MotionEvent paramMotionEvent)
  {
    float f1 = (paramMotionEvent.getX() - this.a) / this.c;
    float f2 = (paramMotionEvent.getY() - this.b) / this.c;
    this.o = b((int)f1, (int)f2);
    paramMotionEvent = this.o;
    if (paramMotionEvent != null)
    {
      this.p.remove(paramMotionEvent);
      this.p.add(this.o);
    }
    if ((this.o == null) && (!k()))
    {
      paramMotionEvent = this.g;
      if (paramMotionEvent != null) {
        this.n = a(paramMotionEvent, this.f, this.j, this.i, this);
      }
    }
  }
  
  private void e(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      paramMotionEvent = this.n;
      if (paramMotionEvent != null)
      {
        if (paramMotionEvent.b())
        {
          this.p.add(this.n);
          this.m = this.n;
        }
        else
        {
          this.m = null;
        }
        this.n = null;
        return;
      }
      if (this.o != this.m) {
        this.m = null;
      }
    }
    else if ((paramMotionEvent.getAction() == 3) && (this.n != null))
    {
      this.n = null;
    }
  }
  
  private boolean k()
  {
    return this.h;
  }
  
  public void a()
  {
    if (!this.l)
    {
      ShapeEffect.InteractionListener localInteractionListener = this.q;
      if (localInteractionListener != null) {
        localInteractionListener.a();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setViewSize: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("x");
    localStringBuilder.append(paramInt2);
    AEQLog.a("ShapeOperator", localStringBuilder.toString());
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void a(Canvas paramCanvas)
  {
    a(paramCanvas, false);
  }
  
  public void a(ShapeEffect.InteractionListener paramInteractionListener)
  {
    this.q = paramInteractionListener;
  }
  
  public void a(ShapeEffect paramShapeEffect)
  {
    paramShapeEffect = this.q;
    if (paramShapeEffect != null) {
      paramShapeEffect.a(this.o);
    }
  }
  
  public void a(ShapeEffect paramShapeEffect, RectF paramRectF)
  {
    AEQLog.b("ShapeOperator", "onClickTips---");
    ShapeEffect.InteractionListener localInteractionListener = this.q;
    if (localInteractionListener != null) {
      localInteractionListener.a(paramShapeEffect, paramRectF);
    }
  }
  
  public void a(ShapeEffect paramShapeEffect, MotionEvent paramMotionEvent)
  {
    ShapeEffect.InteractionListener localInteractionListener = this.q;
    if (localInteractionListener != null) {
      localInteractionListener.a(paramShapeEffect, paramMotionEvent);
    }
  }
  
  public boolean a(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPenWidthFactor: ");
    localStringBuilder.append(paramFloat);
    AEQLog.a("ShapeOperator", localStringBuilder.toString());
    this.j = paramFloat;
    return false;
  }
  
  public boolean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setColor: ");
    localStringBuilder.append(paramInt);
    AEQLog.a("ShapeOperator", localStringBuilder.toString());
    this.i = paramInt;
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.k = true;
      if ((this.o == null) && (this.m == null)) {
        bool = false;
      } else {
        bool = true;
      }
      this.l = bool;
      d(paramMotionEvent);
    }
    boolean bool = c(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      e(paramMotionEvent);
      this.k = false;
    }
    return bool;
  }
  
  public boolean a(ShapeOperator.Shape paramShape)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMode: ");
    localStringBuilder.append(paramShape);
    AEQLog.a("ShapeOperator", localStringBuilder.toString());
    this.g = paramShape;
    return false;
  }
  
  public void b()
  {
    ShapeEffect.InteractionListener localInteractionListener = this.q;
    if (localInteractionListener != null) {
      localInteractionListener.b();
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, true);
  }
  
  public void b(ShapeEffect paramShapeEffect, MotionEvent paramMotionEvent)
  {
    ShapeEffect.InteractionListener localInteractionListener = this.q;
    if (localInteractionListener != null) {
      localInteractionListener.b(paramShapeEffect, paramMotionEvent);
    }
  }
  
  public boolean b(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSelectedShapePenWidthFactor: ");
    ((StringBuilder)localObject).append(paramFloat);
    AEQLog.a("ShapeOperator", ((StringBuilder)localObject).toString());
    localObject = this.o;
    if (localObject != null)
    {
      ((ShapeEffect)localObject).b(paramFloat);
      return true;
    }
    return false;
  }
  
  public boolean b(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSelectedShapeColor: ");
    ((StringBuilder)localObject).append(paramInt);
    AEQLog.a("ShapeOperator", ((StringBuilder)localObject).toString());
    localObject = this.o;
    if (localObject != null)
    {
      ((ShapeEffect)localObject).a(paramInt);
      return true;
    }
    return false;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = (paramMotionEvent.getX() - this.a) / this.c;
    float f2 = (paramMotionEvent.getY() - this.b) / this.c;
    return b((int)f1, (int)f2) != null;
  }
  
  public void c(ShapeEffect paramShapeEffect, MotionEvent paramMotionEvent)
  {
    ShapeEffect.InteractionListener localInteractionListener = this.q;
    if (localInteractionListener != null) {
      localInteractionListener.c(paramShapeEffect, paramMotionEvent);
    }
  }
  
  public boolean c()
  {
    boolean bool;
    if (this.m != null)
    {
      this.m = null;
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (this.o != null)
    {
      this.o = null;
      ShapeEffect.InteractionListener localInteractionListener = this.q;
      if (localInteractionListener != null) {
        localInteractionListener.b();
      }
      bool = true;
    }
    return bool;
  }
  
  public void d()
  {
    this.h = false;
  }
  
  public boolean e()
  {
    return this.p.isEmpty();
  }
  
  public int f()
  {
    return this.p.size();
  }
  
  public void g()
  {
    this.p.clear();
    this.n = null;
    this.o = null;
  }
  
  public void h()
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      this.p.remove(localObject);
      this.o = null;
      localObject = this.q;
      if (localObject != null) {
        ((ShapeEffect.InteractionListener)localObject).b();
      }
    }
  }
  
  public ShapeEffect i()
  {
    return this.o;
  }
  
  public String j()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.p.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ShapeOperator.Shape localShape = ((ShapeEffect)((Iterator)localObject2).next()).a();
      if (localShape != null)
      {
        int i1 = ShapeOperator.1.a[localShape.ordinal()];
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              if (i1 == 4) {
                ((HashSet)localObject1).add(Integer.valueOf(4));
              }
            }
            else {
              ((HashSet)localObject1).add(Integer.valueOf(3));
            }
          }
          else {
            ((HashSet)localObject1).add(Integer.valueOf(2));
          }
        }
        else {
          ((HashSet)localObject1).add(Integer.valueOf(1));
        }
      }
    }
    localObject2 = new StringBuilder();
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ((StringBuilder)localObject2).append((Integer)((Iterator)localObject1).next());
      ((StringBuilder)localObject2).append("|");
    }
    if (((StringBuilder)localObject2).length() > 0) {
      ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
    }
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeOperator
 * JD-Core Version:    0.7.0.1
 */