import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ayua
  extends ReportDialog
{
  protected View.OnClickListener a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected TextView b;
  
  public ayua(Context paramContext)
  {
    super(paramContext, 2131755824);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ayub(this);
    a();
  }
  
  private void a()
  {
    setContentView(2131559002);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367926));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378936));
    this.b = ((TextView)findViewById(2131370580));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363625));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368483));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131706014));
  }
  
  public ayua a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView, paramLayoutParams);
    return this;
  }
  
  public ayua a(aytv paramaytv)
  {
    Button localButton = new Button(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = zps.a(getContext(), 10.0F);
    Object localObject;
    if (paramaytv.jdField_a_of_type_JavaLangString != null)
    {
      localObject = paramaytv.jdField_a_of_type_JavaLangString;
      localButton.setText((CharSequence)localObject);
      localButton.setTextSize(20.0F);
      if (paramaytv.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label134;
      }
      localObject = paramaytv.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label76:
      localButton.setBackgroundDrawable((Drawable)localObject);
      if (paramaytv.jdField_a_of_type_Int == -1) {
        break label150;
      }
    }
    label134:
    label150:
    for (int i = paramaytv.jdField_a_of_type_Int;; i = -1)
    {
      localButton.setTextColor(i);
      localButton.setOnClickListener(new ayuc(this, paramaytv));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localButton, localLayoutParams);
      return this;
      localObject = "";
      break;
      localObject = getContext().getResources().getDrawable(2130839291);
      break label76;
    }
  }
  
  public ayua a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    return this;
  }
  
  public ayua b(CharSequence paramCharSequence)
  {
    this.b.setText(paramCharSequence);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayua
 * JD-Core Version:    0.7.0.1
 */