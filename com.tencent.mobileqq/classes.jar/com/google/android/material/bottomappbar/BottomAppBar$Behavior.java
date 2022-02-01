package com.google.android.material.bottomappbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;

public class BottomAppBar$Behavior
  extends HideBottomViewOnScrollBehavior<BottomAppBar>
{
  private int jdField_a_of_type_Int;
  @NonNull
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new BottomAppBar.Behavior.1(this);
  private WeakReference<BottomAppBar> jdField_a_of_type_JavaLangRefWeakReference;
  
  public BottomAppBar$Behavior() {}
  
  public BottomAppBar$Behavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull BottomAppBar paramBottomAppBar, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBottomAppBar);
    Object localObject = BottomAppBar.a(paramBottomAppBar);
    if ((localObject != null) && (!ViewCompat.isLaidOut((View)localObject)))
    {
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.anchorGravity = 49;
      this.jdField_a_of_type_Int = localLayoutParams.bottomMargin;
      if ((localObject instanceof FloatingActionButton))
      {
        localObject = (FloatingActionButton)localObject;
        ((FloatingActionButton)localObject).addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
        BottomAppBar.a(paramBottomAppBar, (FloatingActionButton)localObject);
      }
      BottomAppBar.b(paramBottomAppBar);
    }
    paramCoordinatorLayout.onLayoutChild(paramBottomAppBar, paramInt);
    return super.onLayoutChild(paramCoordinatorLayout, paramBottomAppBar, paramInt);
  }
  
  public boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull BottomAppBar paramBottomAppBar, @NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    return (paramBottomAppBar.a()) && (super.onStartNestedScroll(paramCoordinatorLayout, paramBottomAppBar, paramView1, paramView2, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar.Behavior
 * JD-Core Version:    0.7.0.1
 */