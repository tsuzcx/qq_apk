import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bgwq
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  bgwm jdField_a_of_type_Bgwm;
  bgwr jdField_a_of_type_Bgwr;
  ImageView b;
  
  public bgwq(View paramView, bgwm parambgwm, bgwr parambgwr)
  {
    super(paramView);
    this.jdField_a_of_type_Bgwm = parambgwm;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364650));
    this.b = ((ImageView)paramView.findViewById(2131364651));
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_Bgwr = parambgwr;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bgwm.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bgwr != null) {
      this.jdField_a_of_type_Bgwr.a(this.jdField_a_of_type_Bgwm.a(this.jdField_a_of_type_Int));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwq
 * JD-Core Version:    0.7.0.1
 */