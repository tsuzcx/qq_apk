import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;

public class bhlz
  extends RecyclerView.ViewHolder
  implements AdapterView.OnItemClickListener
{
  bhls jdField_a_of_type_Bhls;
  bhlx jdField_a_of_type_Bhlx;
  bhly jdField_a_of_type_Bhly;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  
  public bhlz(View paramView, bhlx parambhlx, bhly parambhly, bhls parambhls)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramView.findViewById(2131364828));
    this.jdField_a_of_type_Bhly = parambhly;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bhly);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Bhlx = parambhlx;
    this.jdField_a_of_type_Bhls = parambhls;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Bhly.a(paramInt);
    this.jdField_a_of_type_Bhls.a(-1);
    if (this.jdField_a_of_type_Bhlx != null)
    {
      bhlu localbhlu = new bhlu(2, null, ((Integer)this.jdField_a_of_type_Bhly.getItem(paramInt)).intValue(), null);
      this.jdField_a_of_type_Bhlx.a(localbhlu);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhlz
 * JD-Core Version:    0.7.0.1
 */