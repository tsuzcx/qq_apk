package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import com.google.android.material.R.styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.util.List;

public class ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton>
  extends CoordinatorLayout.Behavior<T>
{
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  @Nullable
  private ExtendedFloatingActionButton.OnChangedCallback jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$OnChangedCallback;
  private boolean jdField_a_of_type_Boolean;
  @Nullable
  private ExtendedFloatingActionButton.OnChangedCallback jdField_b_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$OnChangedCallback;
  private boolean jdField_b_of_type_Boolean;
  
  public ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.y);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean(R.styleable.bE, false);
    this.jdField_b_of_type_Boolean = paramContext.getBoolean(R.styleable.bF, true);
    paramContext.recycle();
  }
  
  private static boolean a(@NonNull View paramView)
  {
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof CoordinatorLayout.LayoutParams)) {
      return ((CoordinatorLayout.LayoutParams)paramView).getBehavior() instanceof BottomSheetBehavior;
    }
    return false;
  }
  
  private boolean a(@NonNull View paramView, @NonNull ExtendedFloatingActionButton paramExtendedFloatingActionButton)
  {
    paramExtendedFloatingActionButton = (CoordinatorLayout.LayoutParams)paramExtendedFloatingActionButton.getLayoutParams();
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
      return false;
    }
    return paramExtendedFloatingActionButton.getAnchorId() == paramView.getId();
  }
  
  private boolean a(CoordinatorLayout paramCoordinatorLayout, @NonNull AppBarLayout paramAppBarLayout, @NonNull ExtendedFloatingActionButton paramExtendedFloatingActionButton)
  {
    if (!a(paramAppBarLayout, paramExtendedFloatingActionButton)) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    DescendantOffsetUtils.b(paramCoordinatorLayout, paramAppBarLayout, localRect);
    if (localRect.bottom <= paramAppBarLayout.e()) {
      a(paramExtendedFloatingActionButton);
    } else {
      b(paramExtendedFloatingActionButton);
    }
    return true;
  }
  
  private boolean b(@NonNull View paramView, @NonNull ExtendedFloatingActionButton paramExtendedFloatingActionButton)
  {
    if (!a(paramView, paramExtendedFloatingActionButton)) {
      return false;
    }
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramExtendedFloatingActionButton.getLayoutParams();
    if (paramView.getTop() < paramExtendedFloatingActionButton.getHeight() / 2 + localLayoutParams.topMargin) {
      a(paramExtendedFloatingActionButton);
    } else {
      b(paramExtendedFloatingActionButton);
    }
    return true;
  }
  
  protected void a(@NonNull ExtendedFloatingActionButton paramExtendedFloatingActionButton)
  {
    ExtendedFloatingActionButton.OnChangedCallback localOnChangedCallback;
    if (this.jdField_b_of_type_Boolean) {
      localOnChangedCallback = this.jdField_b_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$OnChangedCallback;
    } else {
      localOnChangedCallback = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$OnChangedCallback;
    }
    MotionStrategy localMotionStrategy;
    if (this.jdField_b_of_type_Boolean) {
      localMotionStrategy = ExtendedFloatingActionButton.a(paramExtendedFloatingActionButton);
    } else {
      localMotionStrategy = ExtendedFloatingActionButton.b(paramExtendedFloatingActionButton);
    }
    ExtendedFloatingActionButton.a(paramExtendedFloatingActionButton, localMotionStrategy, localOnChangedCallback);
  }
  
  public boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull ExtendedFloatingActionButton paramExtendedFloatingActionButton, int paramInt)
  {
    List localList = paramCoordinatorLayout.getDependencies(paramExtendedFloatingActionButton);
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)localList.get(i);
      if ((localView instanceof AppBarLayout) ? !a(paramCoordinatorLayout, (AppBarLayout)localView, paramExtendedFloatingActionButton) : (a(localView)) && (b(localView, paramExtendedFloatingActionButton))) {
        break;
      }
      i += 1;
    }
    paramCoordinatorLayout.onLayoutChild(paramExtendedFloatingActionButton, paramInt);
    return true;
  }
  
  public boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull ExtendedFloatingActionButton paramExtendedFloatingActionButton, @NonNull Rect paramRect)
  {
    return super.getInsetDodgeRect(paramCoordinatorLayout, paramExtendedFloatingActionButton, paramRect);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, @NonNull ExtendedFloatingActionButton paramExtendedFloatingActionButton, View paramView)
  {
    if ((paramView instanceof AppBarLayout)) {
      a(paramCoordinatorLayout, (AppBarLayout)paramView, paramExtendedFloatingActionButton);
    } else if (a(paramView)) {
      b(paramView, paramExtendedFloatingActionButton);
    }
    return false;
  }
  
  protected void b(@NonNull ExtendedFloatingActionButton paramExtendedFloatingActionButton)
  {
    ExtendedFloatingActionButton.OnChangedCallback localOnChangedCallback;
    if (this.jdField_b_of_type_Boolean) {
      localOnChangedCallback = this.jdField_b_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$OnChangedCallback;
    } else {
      localOnChangedCallback = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$OnChangedCallback;
    }
    MotionStrategy localMotionStrategy;
    if (this.jdField_b_of_type_Boolean) {
      localMotionStrategy = ExtendedFloatingActionButton.c(paramExtendedFloatingActionButton);
    } else {
      localMotionStrategy = ExtendedFloatingActionButton.d(paramExtendedFloatingActionButton);
    }
    ExtendedFloatingActionButton.a(paramExtendedFloatingActionButton, localMotionStrategy, localOnChangedCallback);
  }
  
  public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.dodgeInsetEdges == 0) {
      paramLayoutParams.dodgeInsetEdges = 80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.ExtendedFloatingActionButtonBehavior
 * JD-Core Version:    0.7.0.1
 */