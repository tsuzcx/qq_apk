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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ShapeEffect.InteractionListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener;
  private ShapeEffect jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
  private ShapeOperator.Shape jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape;
  private final LinkedList<ShapeEffect> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private ShapeEffect jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 1.0F;
  private int jdField_c_of_type_Int;
  private ShapeEffect jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
  private boolean jdField_c_of_type_Boolean = false;
  private float d;
  
  public ShapeOperator(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private ShapeEffect a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
    if (localObject != null) {
      if ((!((ShapeEffect)localObject).b(paramInt1, paramInt2)) && (!this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect.a(paramInt1, paramInt2)))
      {
        localObject = this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
        float f1 = paramInt1;
        float f2 = paramInt2;
        if ((!((ShapeEffect)localObject).a(f1, f2)) && (!this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect.b(f1, f2))) {}
      }
      else
      {
        return this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
      }
    }
    localObject = this.jdField_a_of_type_JavaUtilLinkedList.descendingIterator();
    while (((Iterator)localObject).hasNext())
    {
      ShapeEffect localShapeEffect = (ShapeEffect)((Iterator)localObject).next();
      if ((localShapeEffect.a(paramInt1, paramInt2)) || (localShapeEffect.b(paramInt1, paramInt2))) {
        return localShapeEffect;
      }
    }
    return null;
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
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ShapeEffect localShapeEffect = (ShapeEffect)((Iterator)localObject).next();
      boolean bool2 = true;
      boolean bool1;
      if ((!paramBoolean) && (localShapeEffect == this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localShapeEffect.a(bool1);
      if ((!paramBoolean) && (!this.jdField_b_of_type_Boolean) && (localShapeEffect == this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localShapeEffect.b(bool1);
      localShapeEffect.a(paramCanvas);
    }
    localObject = this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
    if (localObject != null) {
      ((ShapeEffect)localObject).a(paramCanvas);
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = (paramMotionEvent.getX() - this.jdField_a_of_type_Float) / this.jdField_c_of_type_Float;
    float f2 = (paramMotionEvent.getY() - this.jdField_b_of_type_Float) / this.jdField_c_of_type_Float;
    this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect = a((int)f1, (int)f2);
    paramMotionEvent = this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
    if (paramMotionEvent != null)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramMotionEvent);
      this.jdField_a_of_type_JavaUtilLinkedList.add(this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect);
    }
    if ((this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect == null) && (!c()))
    {
      paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape;
      if (paramMotionEvent != null) {
        this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect = a(paramMotionEvent, this.jdField_a_of_type_AndroidContentContext, this.d, this.jdField_c_of_type_Int, this);
      }
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      paramMotionEvent = this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
      if (paramMotionEvent != null)
      {
        if (paramMotionEvent.a())
        {
          this.jdField_a_of_type_JavaUtilLinkedList.add(this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect = this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
        }
        else
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect = null;
        }
        this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect = null;
        return;
      }
      if (this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect != this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect = null;
      }
    }
    else if ((paramMotionEvent.getAction() == 3) && (this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect != null))
    {
      this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect = null;
    }
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    ShapeEffect localShapeEffect = this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
    if (localShapeEffect != null) {
      return localShapeEffect.a(paramMotionEvent);
    }
    localShapeEffect = this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
    if (localShapeEffect != null) {
      return localShapeEffect.a(paramMotionEvent);
    }
    return false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.size();
  }
  
  public ShapeEffect a()
  {
    return this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
  }
  
  public String a()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ShapeOperator.Shape localShape = ((ShapeEffect)((Iterator)localObject2).next()).a();
      if (localShape != null)
      {
        int i = ShapeOperator.1.a[localShape.ordinal()];
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 4) {
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
  
  public void a()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      ShapeEffect.InteractionListener localInteractionListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener;
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
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(Canvas paramCanvas)
  {
    a(paramCanvas, false);
  }
  
  public void a(ShapeEffect.InteractionListener paramInteractionListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener = paramInteractionListener;
  }
  
  public void a(ShapeEffect paramShapeEffect)
  {
    paramShapeEffect = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener;
    if (paramShapeEffect != null) {
      paramShapeEffect.a(this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect);
    }
  }
  
  public void a(ShapeEffect paramShapeEffect, RectF paramRectF)
  {
    AEQLog.b("ShapeOperator", "onClickTips---");
    ShapeEffect.InteractionListener localInteractionListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener;
    if (localInteractionListener != null) {
      localInteractionListener.a(paramShapeEffect, paramRectF);
    }
  }
  
  public void a(ShapeEffect paramShapeEffect, MotionEvent paramMotionEvent)
  {
    ShapeEffect.InteractionListener localInteractionListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener;
    if (localInteractionListener != null) {
      localInteractionListener.a(paramShapeEffect, paramMotionEvent);
    }
  }
  
  public boolean a()
  {
    boolean bool;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect != null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect = null;
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect != null)
    {
      this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect = null;
      ShapeEffect.InteractionListener localInteractionListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener;
      if (localInteractionListener != null) {
        localInteractionListener.b();
      }
      bool = true;
    }
    return bool;
  }
  
  public boolean a(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPenWidthFactor: ");
    localStringBuilder.append(paramFloat);
    AEQLog.a("ShapeOperator", localStringBuilder.toString());
    this.d = paramFloat;
    return false;
  }
  
  public boolean a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setColor: ");
    localStringBuilder.append(paramInt);
    AEQLog.a("ShapeOperator", localStringBuilder.toString());
    this.jdField_c_of_type_Int = paramInt;
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_b_of_type_Boolean = true;
      if ((this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect == null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect == null)) {
        bool = false;
      } else {
        bool = true;
      }
      this.jdField_c_of_type_Boolean = bool;
      a(paramMotionEvent);
    }
    boolean bool = c(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      b(paramMotionEvent);
      this.jdField_b_of_type_Boolean = false;
    }
    return bool;
  }
  
  public boolean a(ShapeOperator.Shape paramShape)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMode: ");
    localStringBuilder.append(paramShape);
    AEQLog.a("ShapeOperator", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeOperator$Shape = paramShape;
    return false;
  }
  
  public void b()
  {
    ShapeEffect.InteractionListener localInteractionListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener;
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
    ShapeEffect.InteractionListener localInteractionListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener;
    if (localInteractionListener != null) {
      localInteractionListener.b(paramShapeEffect, paramMotionEvent);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.isEmpty();
  }
  
  public boolean b(float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSelectedShapePenWidthFactor: ");
    ((StringBuilder)localObject).append(paramFloat);
    AEQLog.a("ShapeOperator", ((StringBuilder)localObject).toString());
    localObject = this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
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
    localObject = this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
    if (localObject != null)
    {
      ((ShapeEffect)localObject).a(paramInt);
      return true;
    }
    return false;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = (paramMotionEvent.getX() - this.jdField_a_of_type_Float) / this.jdField_c_of_type_Float;
    float f2 = (paramMotionEvent.getY() - this.jdField_b_of_type_Float) / this.jdField_c_of_type_Float;
    return a((int)f1, (int)f2) != null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(ShapeEffect paramShapeEffect, MotionEvent paramMotionEvent)
  {
    ShapeEffect.InteractionListener localInteractionListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener;
    if (localInteractionListener != null) {
      localInteractionListener.c(paramShapeEffect, paramMotionEvent);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.jdField_b_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect = null;
    this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect = null;
  }
  
  public void e()
  {
    Object localObject = this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect;
    if (localObject != null)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(localObject);
      this.jdField_c_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect = null;
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleShapeEffect$InteractionListener;
      if (localObject != null) {
        ((ShapeEffect.InteractionListener)localObject).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeOperator
 * JD-Core Version:    0.7.0.1
 */