import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.widget.XEditTextEx;
import com.tribe.async.dispatch.IEventReceiver;

public class bmzh
  implements IEventReceiver
{
  public View.OnClickListener a;
  public final View a;
  public ImageButton a;
  public TextView a;
  public bmzk a;
  public XEditTextEx a;
  public String a;
  
  public bmzh(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    a(paramView);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131363042));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364664));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)paramView.findViewById(2131365601));
    paramView = new SpannableString(alud.a(2131711187));
    paramView.setSpan(new AbsoluteSizeSpan(14, true), 0, paramView.length(), 33);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(paramView);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(new bmzj(this));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener(new bmzi(this));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidViewView.getVisibility();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(paramOnClickListener);
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzh
 * JD-Core Version:    0.7.0.1
 */