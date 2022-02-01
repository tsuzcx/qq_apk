package com.tencent.mobileqq.activity.aio.anim;

import afup;
import afva;
import afvb;
import afvc;
import afvn;
import afvo;
import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Transformation;
import aqhk;
import com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsAnimation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ykq;
import zdl;

public class AIOAnimationConatiner
  extends ViewGroup
  implements View.OnLayoutChangeListener
{
  public static final ViewGroup.LayoutParams a;
  public static ClassLoader a;
  private int jdField_a_of_type_Int;
  private afup jdField_a_of_type_Afup;
  public afvn a;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private List<afup> jdField_a_of_type_JavaUtilList;
  
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
  
  private afup a(int paramInt)
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
      return new afvc(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 0: 
      return new afvb(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 4: 
      return new PathAnimation(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 5: 
      return new aqhk(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    case 7: 
      return new afvo(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
    }
    return new BusinessEggsAnimation(paramInt, this, this.jdField_a_of_type_ComTencentWidgetListView);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        a(((afup)localIterator.next()).jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationContainer", 2, "animation end");
    }
    this.jdField_a_of_type_Afup = null;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      removeAllViewsInLayout();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAnimationConatiner", 2, "[end] removeAllViews");
      }
    }
    invalidate();
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetListView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Afup != null) {
      this.jdField_a_of_type_Afup.c();
    }
    g();
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    afup localafup;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (i < this.jdField_a_of_type_JavaUtilList.size()))
    {
      localafup = (afup)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localafup == null) || (paramInt != localafup.jdField_a_of_type_Int)) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        localafup.c();
        this.jdField_a_of_type_JavaUtilList.remove(i);
      }
      if (((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) && (this.jdField_a_of_type_Afup == null))
      {
        removeAllViewsInLayout();
        if (QLog.isColorLevel()) {
          QLog.d("AIOAnimationConatiner", 2, "[stopConcurrentAnimation] removeAllViews");
        }
      }
      invalidate();
      return;
      i += 1;
      break;
      localafup = null;
      i = -1;
    }
  }
  
  public void a(ListView paramListView)
  {
    zdl.a(paramListView);
    if (this.jdField_a_of_type_ComTencentWidgetListView == paramListView)
    {
      ykq.e("AIOAnimationConatiner", "attach the same listView!");
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      ykq.e("AIOAnimationConatiner", "attach and override listView!");
      e();
    }
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentWidgetListView.addOnLayoutChangeListener(this);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Afup != null;
  }
  
  public boolean a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    boolean bool1 = false;
    if ((this.jdField_a_of_type_Afup != null) && (paramInt2 < this.jdField_a_of_type_Afup.jdField_a_of_type_Int)) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        if ((this.jdField_a_of_type_Afup != null) && (paramInt2 == this.jdField_a_of_type_Afup.jdField_a_of_type_Int) && (this.jdField_a_of_type_Afup.a(paramInt1))) {
          return this.jdField_a_of_type_Afup.a(paramVarArgs);
        }
        if (this.jdField_a_of_type_Afup != null) {
          a();
        }
        this.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_Afup = a(paramInt1);
      } while (this.jdField_a_of_type_Afup == null);
      this.jdField_a_of_type_Afup.jdField_a_of_type_Int = paramInt2;
      bool2 = this.jdField_a_of_type_Afup.a(paramVarArgs);
      bool1 = bool2;
    } while (bool2);
    this.jdField_a_of_type_Afup = null;
    return bool2;
  }
  
  public boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    return super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
  }
  
  public void b()
  {
    f();
    a();
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Afup != null) && (paramInt == this.jdField_a_of_type_Int)) {
      a();
    }
  }
  
  public boolean b(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        afup localafup = (afup)((Iterator)localObject).next();
        if ((paramInt1 == localafup.jdField_a_of_type_Int) && (localafup.a(paramInt1)))
        {
          localafup.a(paramVarArgs);
          if (QLog.isColorLevel())
          {
            QLog.d("AIOAnimationConatiner", 2, "[concurrentStartAnimation] reuse animator, type: " + paramInt1);
            paramInt2 = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (paramInt2 == 0)
      {
        localObject = a(paramInt1);
        if (localObject == null) {
          return false;
        }
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        ((afup)localObject).a(paramVarArgs);
        if (QLog.isColorLevel()) {
          QLog.d("AIOAnimationConatiner", 2, "[concurrentStartAnimation] create new animator, type: " + paramInt1);
        }
      }
      return true;
      paramInt2 = 1;
      continue;
      paramInt2 = 0;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Afup != null) {
      this.jdField_a_of_type_Afup.a();
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((afup)localIterator.next()).a();
      }
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Afup != null) {
      this.jdField_a_of_type_Afup.a(paramInt);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Afup != null) {
      this.jdField_a_of_type_Afup.b();
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((afup)localIterator.next()).b();
      }
    }
  }
  
  public void e()
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
    if ((VersionUtils.isHoneycomb()) && ((localObject instanceof afva)) && (((afva)localObject).b))
    {
      localObject = (afva)localObject;
      Matrix localMatrix = paramTransformation.getMatrix();
      localMatrix.reset();
      int i = paramView.getWidth() / 2;
      int j = paramView.getHeight() / 2;
      localMatrix.preRotate(((afva)localObject).a, i, j);
      localMatrix.preScale(((afva)localObject).d, ((afva)localObject).e, j, j);
      paramTransformation.setAlpha(((afva)localObject).f);
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
    if (this.jdField_a_of_type_Afup != null) {
      this.jdField_a_of_type_Afup.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.jdField_a_of_type_Afup != null) {
      if ((paramInt1 == paramInt5) && (paramInt2 == paramInt6) && (paramInt3 == paramInt7) && (paramInt4 == paramInt8)) {
        break label53;
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Afup.a(bool, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner
 * JD-Core Version:    0.7.0.1
 */