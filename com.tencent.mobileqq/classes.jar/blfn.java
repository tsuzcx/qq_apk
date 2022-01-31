import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.TextView;

public class blfn
  extends FrameLayout
{
  private int jdField_a_of_type_Int = Color.parseColor("#BABABA");
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private int b = -1;
  
  public blfn(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 15.0F);
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (int i = this.b;; i = this.jdField_a_of_type_Int)
    {
      localTextView.setTextColor(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfn
 * JD-Core Version:    0.7.0.1
 */