package com.tencent.mobileqq.activity.aio.anim;

import agkr;
import aglc;
import agld;
import agle;
import aglp;
import aglq;
import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Transformation;
import aqkv;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import yuk;
import znw;

public class AIOAnimationConatiner
  extends ViewGroup
  implements View.OnLayoutChangeListener
{
  public static final ViewGroup.LayoutParams a;
  public static ClassLoader a;
  private int jdField_a_of_type_Int;
  private agkr jdField_a_of_type_Agkr;
  public aglp a;
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
  
  private agkr a(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 6: 
    default: 
      return null;
    case 2: 
      return new FloorJumperSet(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 1: 
      return new agle(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 0: 
      return new agld(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 4: 
      return new PathAnimation(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 5: 
      return new aqkv(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    }
    return new aglq(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationContainer", 2, "animation end");
    }
    this.jdField_a_of_type_Agkr = null;
    removeAllViewsInLayout();
    invalidate();
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetListView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agkr != null) {
      this.jdField_a_of_type_Agkr.c();
    }
    e();
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Agkr != null) && (paramInt == this.jdField_a_of_type_Int)) {
      a();
    }
  }
  
  public void a(ListView paramListView)
  {
    znw.a(paramListView);
    if (this.jdField_a_of_type_ComTencentWidgetListView == paramListView)
    {
      yuk.e("AIOAnimationConatiner", "attach the same listView!");
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      yuk.e("AIOAnimationConatiner", "attach and override listView!");
      d();
    }
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentWidgetListView.addOnLayoutChangeListener(this);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Agkr != null;
  }
  
  public boolean a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    boolean bool1 = false;
    if ((this.jdField_a_of_type_Agkr != null) && (paramInt2 < this.jdField_a_of_type_Agkr.jdField_a_of_type_Int)) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        if ((this.jdField_a_of_type_Agkr != null) && (paramInt2 == this.jdField_a_of_type_Agkr.jdField_a_of_type_Int) && (this.jdField_a_of_type_Agkr.a(paramInt1))) {
          return this.jdField_a_of_type_Agkr.a(paramVarArgs);
        }
        if (this.jdField_a_of_type_Agkr != null) {
          a();
        }
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_Agkr = a(paramInt1);
      } while (this.jdField_a_of_type_Agkr == null);
      this.jdField_a_of_type_Agkr.jdField_a_of_type_Int = paramInt2;
      bool2 = this.jdField_a_of_type_Agkr.a(paramVarArgs);
      bool1 = bool2;
    } while (bool2);
    this.jdField_a_of_type_Agkr = null;
    return bool2;
  }
  
  public boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    return super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Agkr != null) {
      this.jdField_a_of_type_Agkr.a();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Agkr != null) {
      this.jdField_a_of_type_Agkr.a(paramInt);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Agkr != null) {
      this.jdField_a_of_type_Agkr.b();
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
    if ((VersionUtils.isHoneycomb()) && ((localObject instanceof aglc)) && (((aglc)localObject).b))
    {
      localObject = (aglc)localObject;
      Matrix localMatrix = paramTransformation.getMatrix();
      localMatrix.reset();
      int i = paramView.getWidth() / 2;
      int j = paramView.getHeight() / 2;
      localMatrix.preRotate(((aglc)localObject).a, i, j);
      localMatrix.preScale(((aglc)localObject).d, ((aglc)localObject).e, j, j);
      paramTransformation.setAlpha(((aglc)localObject).f);
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
    if (this.jdField_a_of_type_Agkr != null) {
      this.jdField_a_of_type_Agkr.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.jdField_a_of_type_Agkr != null) {
      if ((paramInt1 == paramInt5) && (paramInt2 == paramInt6) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8)) {
        break label53;
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Agkr.a(bool, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner
 * JD-Core Version:    0.7.0.1
 */