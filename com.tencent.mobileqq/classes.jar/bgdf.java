import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bgdf
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  bgdb jdField_a_of_type_Bgdb;
  bgdg jdField_a_of_type_Bgdg;
  ImageView b;
  
  public bgdf(View paramView, bgdb parambgdb, bgdg parambgdg)
  {
    super(paramView);
    this.jdField_a_of_type_Bgdb = parambgdb;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364727));
    this.b = ((ImageView)paramView.findViewById(2131364728));
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_Bgdg = parambgdg;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bgdb.a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Bgdg != null) {
      this.jdField_a_of_type_Bgdg.a(this.jdField_a_of_type_Bgdb.a(this.jdField_a_of_type_Int));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdf
 * JD-Core Version:    0.7.0.1
 */