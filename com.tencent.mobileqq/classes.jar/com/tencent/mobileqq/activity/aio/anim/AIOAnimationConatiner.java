package com.tencent.mobileqq.activity.aio.anim;

import agax;
import agbi;
import agbj;
import agbk;
import agbv;
import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Transformation;
import apwv;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import yqp;
import zkb;

public class AIOAnimationConatiner
  extends ViewGroup
  implements View.OnLayoutChangeListener
{
  public static final ViewGroup.LayoutParams a;
  public static ClassLoader a;
  private int jdField_a_of_type_Int;
  private agax jdField_a_of_type_Agax;
  public agbv a;
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
  
  private agax a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return null;
    case 2: 
      return new FloorJumperSet(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 1: 
      return new agbk(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 0: 
      return new agbj(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 4: 
      return new PathAnimation(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    }
    return new apwv(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationContainer", 2, "animation end");
    }
    this.jdField_a_of_type_Agax = null;
    removeAllViewsInLayout();
    invalidate();
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetListView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agax != null) {
      this.jdField_a_of_type_Agax.c();
    }
    e();
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Agax != null) && (paramInt == this.jdField_a_of_type_Int)) {
      a();
    }
  }
  
  public void a(ListView paramListView)
  {
    zkb.a(paramListView);
    if (this.jdField_a_of_type_ComTencentWidgetListView == paramListView)
    {
      yqp.e("AIOAnimationConatiner", "attach the same listView!");
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      yqp.e("AIOAnimationConatiner", "attach and override listView!");
      d();
    }
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentWidgetListView.addOnLayoutChangeListener(this);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Agax != null;
  }
  
  public boolean a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    boolean bool1 = false;
    if ((this.jdField_a_of_type_Agax != null) && (paramInt2 < this.jdField_a_of_type_Agax.jdField_a_of_type_Int)) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        if ((this.jdField_a_of_type_Agax != null) && (paramInt2 == this.jdField_a_of_type_Agax.jdField_a_of_type_Int) && (this.jdField_a_of_type_Agax.a(paramInt1))) {
          return this.jdField_a_of_type_Agax.a(paramVarArgs);
        }
        if (this.jdField_a_of_type_Agax != null) {
          a();
        }
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_Agax = a(paramInt1);
      } while (this.jdField_a_of_type_Agax == null);
      this.jdField_a_of_type_Agax.jdField_a_of_type_Int = paramInt2;
      bool2 = this.jdField_a_of_type_Agax.a(paramVarArgs);
      bool1 = bool2;
    } while (bool2);
    this.jdField_a_of_type_Agax = null;
    return bool2;
  }
  
  public boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    return super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Agax != null) {
      this.jdField_a_of_type_Agax.a();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Agax != null) {
      this.jdField_a_of_type_Agax.a(paramInt);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Agax != null) {
      this.jdField_a_of_type_Agax.b();
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
    if ((VersionUtils.isHoneycomb()) && ((localObject instanceof agbi)) && (((agbi)localObject).b))
    {
      localObject = (agbi)localObject;
      Matrix localMatrix = paramTransformation.getMatrix();
      localMatrix.reset();
      int i = paramView.getWidth() / 2;
      int j = paramView.getHeight() / 2;
      localMatrix.preRotate(((agbi)localObject).a, i, j);
      localMatrix.preScale(((agbi)localObject).d, ((agbi)localObject).e, j, j);
      paramTransformation.setAlpha(((agbi)localObject).f);
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
    if (this.jdField_a_of_type_Agax != null) {
      this.jdField_a_of_type_Agax.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.jdField_a_of_type_Agax != null) {
      if ((paramInt1 == paramInt5) && (paramInt2 == paramInt6) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8)) {
        break label53;
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Agax.a(bool, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner
 * JD-Core Version:    0.7.0.1
 */