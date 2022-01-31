package com.tencent.mobileqq.activity.aio.anim;

import acnv;
import acof;
import acog;
import acoh;
import acoq;
import almv;
import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Transformation;
import befo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import urk;
import vkw;

public class AIOAnimationConatiner
  extends ViewGroup
  implements View.OnLayoutChangeListener
{
  public static final ViewGroup.LayoutParams a;
  public static ClassLoader a;
  private int jdField_a_of_type_Int;
  private acnv jdField_a_of_type_Acnv;
  public acoq a;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  
  static
  {
    jdField_a_of_type_AndroidViewViewGroup$LayoutParams = new ViewGroup.LayoutParams(-2, -2);
    jdField_a_of_type_JavaLangClassLoader = AIOAnimationConatiner.class.getClassLoader();
  }
  
  public AIOAnimationConatiner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AIOAnimationConatiner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private acnv a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return null;
    case 2: 
      return new FloorJumperSet(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 1: 
      return new acoh(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 0: 
      return new acog(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 4: 
      return new PathAnimation(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    }
    return new almv(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationContainer", 2, "animation end");
    }
    this.jdField_a_of_type_Acnv = null;
    removeAllViewsInLayout();
    invalidate();
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetListView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Acnv != null) {
      this.jdField_a_of_type_Acnv.c();
    }
    e();
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Acnv != null) && (paramInt == this.jdField_a_of_type_Int)) {
      a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    if ((this.jdField_a_of_type_Acnv != null) && (paramInt2 < this.jdField_a_of_type_Acnv.jdField_a_of_type_Int)) {}
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_Acnv != null) && (paramInt2 == this.jdField_a_of_type_Acnv.jdField_a_of_type_Int) && (this.jdField_a_of_type_Acnv.a(paramInt1)))
        {
          this.jdField_a_of_type_Acnv.a(paramVarArgs);
          return;
        }
        if (this.jdField_a_of_type_Acnv != null) {
          a();
        }
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_Acnv = a(paramInt1);
      } while (this.jdField_a_of_type_Acnv == null);
      this.jdField_a_of_type_Acnv.jdField_a_of_type_Int = paramInt2;
    } while (this.jdField_a_of_type_Acnv.a(paramVarArgs));
    this.jdField_a_of_type_Acnv = null;
  }
  
  public void a(ListView paramListView)
  {
    vkw.a(paramListView);
    if (this.jdField_a_of_type_ComTencentWidgetListView == paramListView)
    {
      urk.e("AIOAnimationConatiner", "attach the same listView!");
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      urk.e("AIOAnimationConatiner", "attach and override listView!");
      d();
    }
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentWidgetListView.addOnLayoutChangeListener(this);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Acnv != null;
  }
  
  public boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    return super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Acnv != null) {
      this.jdField_a_of_type_Acnv.a();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Acnv != null) {
      this.jdField_a_of_type_Acnv.a(paramInt);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Acnv != null) {
      this.jdField_a_of_type_Acnv.b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetListView.removeOnLayoutChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView = null;
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    Object localObject = paramView.getTag();
    if ((befo.e()) && ((localObject instanceof acof)) && (((acof)localObject).b))
    {
      localObject = (acof)localObject;
      Matrix localMatrix = paramTransformation.getMatrix();
      localMatrix.reset();
      int i = paramView.getWidth() / 2;
      int j = paramView.getHeight() / 2;
      localMatrix.preRotate(((acof)localObject).a, i, j);
      localMatrix.preScale(((acof)localObject).d, ((acof)localObject).e, j, j);
      paramTransformation.setAlpha(((acof)localObject).f);
      return true;
    }
    return false;
  }
  
  public boolean isInEditMode()
  {
    return true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentWidgetListView != null) {
      this.jdField_a_of_type_ComTencentWidgetListView.removeOnLayoutChangeListener(this);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Acnv != null) {
      this.jdField_a_of_type_Acnv.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.jdField_a_of_type_Acnv != null) {
      if ((paramInt1 == paramInt5) && (paramInt2 == paramInt6) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8)) {
        break label53;
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Acnv.a(bool, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner
 * JD-Core Version:    0.7.0.1
 */