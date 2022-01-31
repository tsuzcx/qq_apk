import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class bdrq
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  bdrm jdField_a_of_type_Bdrm;
  bdrr jdField_a_of_type_Bdrr;
  ImageView b;
  
  public bdrq(View paramView, bdrm parambdrm, bdrr parambdrr)
  {
    super(paramView);
    this.jdField_a_of_type_Bdrm = parambdrm;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364444));
    this.b = ((ImageView)paramView.findViewById(2131364445));
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_Bdrr = parambdrr;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bdrm.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bdrr != null) {
      this.jdField_a_of_type_Bdrr.a(this.jdField_a_of_type_Bdrm.a(this.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdrq
 * JD-Core Version:    0.7.0.1
 */