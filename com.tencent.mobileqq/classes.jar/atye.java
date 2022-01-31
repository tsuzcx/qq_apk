import android.app.Dialog;
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

public class atye
  extends Dialog
{
  protected View.OnClickListener a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected TextView b;
  
  public atye(Context paramContext)
  {
    super(paramContext, 2131755791);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new atyf(this);
    a();
  }
  
  private void a()
  {
    setContentView(2131558900);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367408));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377350));
    this.b = ((TextView)findViewById(2131369753));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363368));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367938));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131707132));
  }
  
  public atye a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView, paramLayoutParams);
    return this;
  }
  
  public atye a(atxz paramatxz)
  {
    Button localButton = new Button(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = vzl.a(getContext(), 10.0F);
    Object localObject;
    if (paramatxz.jdField_a_of_type_JavaLangString != null)
    {
      localObject = paramatxz.jdField_a_of_type_JavaLangString;
      localButton.setText((CharSequence)localObject);
      localButton.setTextSize(20.0F);
      if (paramatxz.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break label134;
      }
      localObject = paramatxz.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      label76:
      localButton.setBackgroundDrawable((Drawable)localObject);
      if (paramatxz.jdField_a_of_type_Int == -1) {
        break label150;
      }
    }
    label134:
    label150:
    for (int i = paramatxz.jdField_a_of_type_Int;; i = -1)
    {
      localButton.setTextColor(i);
      localButton.setOnClickListener(new atyg(this, paramatxz));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localButton, localLayoutParams);
      return this;
      localObject = "";
      break;
      localObject = getContext().getResources().getDrawable(2130839026);
      break label76;
    }
  }
  
  public atye a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    return this;
  }
  
  public atye b(CharSequence paramCharSequence)
  {
    this.b.setText(paramCharSequence);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atye
 * JD-Core Version:    0.7.0.1
 */