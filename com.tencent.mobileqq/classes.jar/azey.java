import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;

public final class azey
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private Drawable b;
  
  public azey(@NonNull LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidContentContext = paramLinearLayout.getContext();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bamn.a(this.jdField_a_of_type_AndroidContentContext.getResources(), Color.parseColor("#66ffffff"), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843106));
    this.b = bamn.a(this.jdField_a_of_type_AndroidContentContext.getResources(), Color.parseColor("#ffffffff"), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843106));
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      this.b.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    int i = axli.a(7.5F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(i, i);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = axli.a(7.0F);
  }
  
  public void a(int paramInt)
  {
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    if ((paramInt < 0) || (paramInt >= j)) {
      return;
    }
    int i = 0;
    label20:
    View localView;
    if (i < j)
    {
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if (paramInt != i) {
        break label60;
      }
    }
    label60:
    for (Drawable localDrawable = this.b;; localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
    {
      localView.setBackgroundDrawable(localDrawable);
      i += 1;
      break label20;
      break;
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() != paramInt)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      while (paramInt > 0)
      {
        View localView = new View(this.jdField_a_of_type_AndroidContentContext);
        localView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
        paramInt -= 1;
      }
    }
    a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azey
 * JD-Core Version:    0.7.0.1
 */