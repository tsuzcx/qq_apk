import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class bamd
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  balz jdField_a_of_type_Balz;
  bame jdField_a_of_type_Bame;
  ImageView b;
  
  public bamd(View paramView, balz parambalz, bame parambame)
  {
    super(paramView);
    this.jdField_a_of_type_Balz = parambalz;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298815));
    this.b = ((ImageView)paramView.findViewById(2131298816));
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_Bame = parambame;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Balz.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bame != null) {
      this.jdField_a_of_type_Bame.a(this.jdField_a_of_type_Balz.a(this.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bamd
 * JD-Core Version:    0.7.0.1
 */