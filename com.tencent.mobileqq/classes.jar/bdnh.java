import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class bdnh
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  bdnd jdField_a_of_type_Bdnd;
  bdni jdField_a_of_type_Bdni;
  ImageView b;
  
  public bdnh(View paramView, bdnd parambdnd, bdni parambdni)
  {
    super(paramView);
    this.jdField_a_of_type_Bdnd = parambdnd;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364442));
    this.b = ((ImageView)paramView.findViewById(2131364443));
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_Bdni = parambdni;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bdnd.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bdni != null) {
      this.jdField_a_of_type_Bdni.a(this.jdField_a_of_type_Bdnd.a(this.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdnh
 * JD-Core Version:    0.7.0.1
 */