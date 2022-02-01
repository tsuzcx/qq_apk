import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class avai
{
  public View a;
  public ImageView a;
  public ProgressBar a;
  public TextView a;
  public TextView b;
  public TextView c;
  
  public void a(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramDrawable == null) {
      return;
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      if (!paramBoolean2)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setAdjustViewBounds(true);
        this.jdField_a_of_type_AndroidWidgetImageView.setMaxHeight(bhtq.a(140.0F));
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        if (paramInt >= 2) {
          break;
        }
        this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setAdjustViewBounds(true);
        this.jdField_a_of_type_AndroidWidgetImageView.setMaxWidth(bhtq.a(120.0F));
        this.jdField_a_of_type_AndroidWidgetImageView.setMaxHeight(bhtq.a(120.0F));
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      if (paramInt == 2)
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130840141);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130840142);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramDrawable, null, null, null);
    if (paramDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avai
 * JD-Core Version:    0.7.0.1
 */