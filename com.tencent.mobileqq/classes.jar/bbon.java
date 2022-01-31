import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class bbon
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  bboj jdField_a_of_type_Bboj;
  bboo jdField_a_of_type_Bboo;
  ImageView b;
  
  public bbon(View paramView, bboj parambboj, bboo parambboo)
  {
    super(paramView);
    this.jdField_a_of_type_Bboj = parambboj;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364371));
    this.b = ((ImageView)paramView.findViewById(2131364372));
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_Bboo = parambboo;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bboj.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bboo != null) {
      this.jdField_a_of_type_Bboo.a(this.jdField_a_of_type_Bboj.a(this.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbon
 * JD-Core Version:    0.7.0.1
 */