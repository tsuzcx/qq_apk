package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActivityChooserView$InnerLayout
  extends LinearLayout
{
  private static final int[] TINT_ATTRS = { 16842964 };
  
  public ActivityChooserView$InnerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, TINT_ATTRS);
    setBackgroundDrawable(paramContext.getDrawable(0));
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActivityChooserView.InnerLayout
 * JD-Core Version:    0.7.0.1
 */