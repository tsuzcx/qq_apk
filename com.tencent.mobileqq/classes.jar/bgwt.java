import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;

public class bgwt
  extends RecyclerView.ViewHolder
  implements AdapterView.OnItemClickListener
{
  bgwm jdField_a_of_type_Bgwm;
  bgwr jdField_a_of_type_Bgwr;
  bgws jdField_a_of_type_Bgws;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  
  public bgwt(View paramView, bgwr parambgwr, bgws parambgws, bgwm parambgwm)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramView.findViewById(2131364664));
    this.jdField_a_of_type_Bgws = parambgws;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bgws);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Bgwr = parambgwr;
    this.jdField_a_of_type_Bgwm = parambgwm;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Bgws.a(paramInt);
    this.jdField_a_of_type_Bgwm.a(-1);
    if (this.jdField_a_of_type_Bgwr != null)
    {
      bgwo localbgwo = new bgwo(2, null, ((Integer)this.jdField_a_of_type_Bgws.getItem(paramInt)).intValue(), null);
      this.jdField_a_of_type_Bgwr.a(localbgwo);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwt
 * JD-Core Version:    0.7.0.1
 */