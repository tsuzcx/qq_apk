package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.color;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.resources.MaterialResources;
import java.util.Arrays;

class ClockFaceView
  extends RadialViewGroup
  implements ClockHandView.OnRotateListener
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private final ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private final SparseArray<TextView> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final AccessibilityDelegateCompat jdField_a_of_type_AndroidxCoreViewAccessibilityDelegateCompat;
  private final ClockHandView jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockHandView;
  private final float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 0.9F, 1.0F };
  private final int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public ClockFaceView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ClockFaceView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.B);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public ClockFaceView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.m, paramInt, R.style.J);
    Object localObject = getResources();
    this.jdField_a_of_type_AndroidContentResColorStateList = MaterialResources.a(paramContext, paramAttributeSet, R.styleable.bc);
    LayoutInflater.from(paramContext).inflate(R.layout.n, this, true);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockHandView = ((ClockHandView)findViewById(R.id.n));
    this.jdField_a_of_type_Int = ((Resources)localObject).getDimensionPixelSize(R.dimen.u);
    localObject = this.jdField_a_of_type_AndroidContentResColorStateList;
    paramInt = ((ColorStateList)localObject).getDefaultColor();
    paramInt = ((ColorStateList)localObject).getColorForState(new int[] { 16842913 }, paramInt);
    this.jdField_a_of_type_ArrayOfInt = new int[] { paramInt, paramInt, this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor() };
    this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockHandView.a(this);
    paramInt = AppCompatResources.getColorStateList(paramContext, R.color.l).getDefaultColor();
    paramContext = MaterialResources.a(paramContext, paramAttributeSet, R.styleable.bb);
    if (paramContext != null) {
      paramInt = paramContext.getDefaultColor();
    }
    setBackgroundColor(paramInt);
    getViewTreeObserver().addOnPreDrawListener(new ClockFaceView.1(this));
    setFocusable(true);
    paramAttributeSet.recycle();
    this.jdField_a_of_type_AndroidxCoreViewAccessibilityDelegateCompat = new ClockFaceView.2(this);
    paramContext = new String[12];
    Arrays.fill(paramContext, "");
    a(paramContext, 0);
  }
  
  private RadialGradient a(RectF paramRectF1, RectF paramRectF2)
  {
    if (!RectF.intersects(paramRectF1, paramRectF2)) {
      return null;
    }
    return new RadialGradient(paramRectF1.centerX() - this.jdField_a_of_type_AndroidGraphicsRectF.left, paramRectF1.centerY() - this.jdField_a_of_type_AndroidGraphicsRectF.top, paramRectF1.width() * 0.5F, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP);
  }
  
  private void b()
  {
    RectF localRectF = this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockHandView.a();
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if (localTextView != null)
      {
        localTextView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidGraphicsRect.offset(localTextView.getPaddingLeft(), localTextView.getPaddingTop());
        offsetDescendantRectToMyCoords(localTextView, this.jdField_a_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRect);
        RadialGradient localRadialGradient = a(localRectF, this.jdField_a_of_type_AndroidGraphicsRectF);
        localTextView.getPaint().setShader(localRadialGradient);
        localTextView.invalidate();
      }
      i += 1;
    }
  }
  
  private void b(@StringRes int paramInt)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    int i = 0;
    while (i < Math.max(this.jdField_a_of_type_ArrayOfJavaLangString.length, j))
    {
      TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        removeView(localTextView2);
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
      }
      else
      {
        TextView localTextView1 = localTextView2;
        if (localTextView2 == null)
        {
          localTextView1 = (TextView)localLayoutInflater.inflate(R.layout.m, this, false);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localTextView1);
          addView(localTextView1);
        }
        localTextView1.setVisibility(0);
        localTextView1.setText(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        localTextView1.setTag(R.id.B, Integer.valueOf(i));
        ViewCompat.setAccessibilityDelegate(localTextView1, this.jdField_a_of_type_AndroidxCoreViewAccessibilityDelegateCompat);
        localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        if (paramInt != 0) {
          localTextView1.setContentDescription(getResources().getString(paramInt, new Object[] { this.jdField_a_of_type_ArrayOfJavaLangString[i] }));
        }
      }
      i += 1;
    }
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    if (Math.abs(this.jdField_a_of_type_Float - paramFloat) > 0.001F)
    {
      this.jdField_a_of_type_Float = paramFloat;
      b();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt != a())
    {
      super.a(paramInt);
      this.jdField_a_of_type_ComGoogleAndroidMaterialTimepickerClockHandView.a(a());
    }
  }
  
  public void a(String[] paramArrayOfString, @StringRes int paramInt)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    b(paramInt);
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.jdField_a_of_type_ArrayOfJavaLangString.length, false, 1));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.timepicker.ClockFaceView
 * JD-Core Version:    0.7.0.1
 */