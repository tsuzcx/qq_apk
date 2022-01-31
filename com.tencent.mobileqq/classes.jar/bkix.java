import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class bkix
  extends bkiq<bkiw>
{
  public final ImageView a;
  public final TextView a;
  public final TextView b = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377105);
  
  bkix(bkiw parambkiw, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377032));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367776));
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561253, paramViewGroup, false);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public void a(bkiw parambkiw, int paramInt)
  {
    super.a(parambkiw, paramInt);
    if ((this.jdField_a_of_type_Bkip != null) && (((bkiw)this.jdField_a_of_type_Bkip).c != 0) && (((bkiw)this.jdField_a_of_type_Bkip).a != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(((bkiw)this.jdField_a_of_type_Bkip).c);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((bkiw)this.jdField_a_of_type_Bkip).a);
      this.b.setText(((bkiw)this.jdField_a_of_type_Bkip).b);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.b.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkix
 * JD-Core Version:    0.7.0.1
 */