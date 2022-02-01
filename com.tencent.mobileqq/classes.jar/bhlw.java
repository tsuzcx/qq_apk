import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bhlw
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  bhls jdField_a_of_type_Bhls;
  bhlx jdField_a_of_type_Bhlx;
  ImageView b;
  
  public bhlw(View paramView, bhls parambhls, bhlx parambhlx)
  {
    super(paramView);
    this.jdField_a_of_type_Bhls = parambhls;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364814));
    this.b = ((ImageView)paramView.findViewById(2131364815));
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_Bhlx = parambhlx;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bhls.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bhlx != null) {
      this.jdField_a_of_type_Bhlx.a(this.jdField_a_of_type_Bhls.a(this.jdField_a_of_type_Int));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhlw
 * JD-Core Version:    0.7.0.1
 */