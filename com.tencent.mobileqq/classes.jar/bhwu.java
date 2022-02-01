import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bhwu
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  bhwq jdField_a_of_type_Bhwq;
  bhwv jdField_a_of_type_Bhwv;
  ImageView b;
  
  public bhwu(View paramView, bhwq parambhwq, bhwv parambhwv)
  {
    super(paramView);
    this.jdField_a_of_type_Bhwq = parambhwq;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364696));
    this.b = ((ImageView)paramView.findViewById(2131364697));
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_Bhwv = parambhwv;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bhwq.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bhwv != null) {
      this.jdField_a_of_type_Bhwv.a(this.jdField_a_of_type_Bhwq.a(this.jdField_a_of_type_Int));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhwu
 * JD-Core Version:    0.7.0.1
 */