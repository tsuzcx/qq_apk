import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;

public class bhwx
  extends RecyclerView.ViewHolder
  implements AdapterView.OnItemClickListener
{
  bhwq jdField_a_of_type_Bhwq;
  bhwv jdField_a_of_type_Bhwv;
  bhww jdField_a_of_type_Bhww;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  
  public bhwx(View paramView, bhwv parambhwv, bhww parambhww, bhwq parambhwq)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramView.findViewById(2131364710));
    this.jdField_a_of_type_Bhww = parambhww;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bhww);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Bhwv = parambhwv;
    this.jdField_a_of_type_Bhwq = parambhwq;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Bhww.a(paramInt);
    this.jdField_a_of_type_Bhwq.a(-1);
    if (this.jdField_a_of_type_Bhwv != null)
    {
      bhws localbhws = new bhws(2, null, ((Integer)this.jdField_a_of_type_Bhww.getItem(paramInt)).intValue(), null);
      this.jdField_a_of_type_Bhwv.a(localbhws);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhwx
 * JD-Core Version:    0.7.0.1
 */