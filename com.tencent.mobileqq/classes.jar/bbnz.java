import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class bbnz
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  bbnv jdField_a_of_type_Bbnv;
  bboa jdField_a_of_type_Bboa;
  ImageView b;
  
  public bbnz(View paramView, bbnv parambbnv, bboa parambboa)
  {
    super(paramView);
    this.jdField_a_of_type_Bbnv = parambbnv;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364372));
    this.b = ((ImageView)paramView.findViewById(2131364373));
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_Bboa = parambboa;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bbnv.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bboa != null) {
      this.jdField_a_of_type_Bboa.a(this.jdField_a_of_type_Bbnv.a(this.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbnz
 * JD-Core Version:    0.7.0.1
 */