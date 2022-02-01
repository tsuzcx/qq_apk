package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.R.styleable;

public class LinearLayoutCompat$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  public int gravity = -1;
  public float weight;
  
  public LinearLayoutCompat$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.weight = 0.0F;
  }
  
  public LinearLayoutCompat$LayoutParams(int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramInt1, paramInt2);
    this.weight = paramFloat;
  }
  
  public LinearLayoutCompat$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LinearLayoutCompat_Layout);
    this.weight = paramContext.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
    this.gravity = paramContext.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
    paramContext.recycle();
  }
  
  public LinearLayoutCompat$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public LinearLayoutCompat$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public LinearLayoutCompat$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.weight = paramLayoutParams.weight;
    this.gravity = paramLayoutParams.gravity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.LinearLayoutCompat.LayoutParams
 * JD-Core Version:    0.7.0.1
 */