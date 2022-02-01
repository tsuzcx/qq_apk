import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class bqru
  extends bqrn<bqrt>
{
  public final ImageView a;
  public final TextView a;
  public final TextView b = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378679);
  
  bqru(bqrt parambqrt, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378603));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368320));
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561738, paramViewGroup, false);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
  }
  
  public void a(bqrt parambqrt, int paramInt)
  {
    super.a(parambqrt, paramInt);
    if ((this.jdField_a_of_type_Bqrm != null) && (((bqrt)this.jdField_a_of_type_Bqrm).c != 0) && (((bqrt)this.jdField_a_of_type_Bqrm).a != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(((bqrt)this.jdField_a_of_type_Bqrm).c);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((bqrt)this.jdField_a_of_type_Bqrm).a);
      this.b.setText(((bqrt)this.jdField_a_of_type_Bqrm).b);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.b.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqru
 * JD-Core Version:    0.7.0.1
 */