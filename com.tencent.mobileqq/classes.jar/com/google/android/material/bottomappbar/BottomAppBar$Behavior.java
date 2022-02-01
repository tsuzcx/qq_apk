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
  @NonNull
  private final Rect a = new Rect();
  private WeakReference<BottomAppBar> b;
  private int c;
  private final View.OnLayoutChangeListener d = new BottomAppBar.Behavior.1(this);
  
  public BottomAppBar$Behavior() {}
  
  public BottomAppBar$Behavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull BottomAppBar paramBottomAppBar, int paramInt)
  {
    this.b = new WeakReference(paramBottomAppBar);
    Object localObject = BottomAppBar.w(paramBottomAppBar);
    if ((localObject != null) && (!ViewCompat.isLaidOut((View)localObject)))
    {
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.anchorGravity = 49;
      this.c = localLayoutParams.bottomMargin;
      if ((localObject instanceof FloatingActionButton))
      {
        localObject = (FloatingActionButton)localObject;
        ((FloatingActionButton)localObject).addOnLayoutChangeListener(this.d);
        BottomAppBar.a(paramBottomAppBar, (FloatingActionButton)localObject);
      }
      BottomAppBar.l(paramBottomAppBar);
    }
    paramCoordinatorLayout.onLayoutChild(paramBottomAppBar, paramInt);
    return super.onLayoutChild(paramCoordinatorLayout, paramBottomAppBar, paramInt);
  }
  
  public boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull BottomAppBar paramBottomAppBar, @NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    return (paramBottomAppBar.getHideOnScroll()) && (super.onStartNestedScroll(paramCoordinatorLayout, paramBottomAppBar, paramView1, paramView2, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar.Behavior
 * JD-Core Version:    0.7.0.1
 */