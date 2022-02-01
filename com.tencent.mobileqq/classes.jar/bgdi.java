import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;

public class bgdi
  extends RecyclerView.ViewHolder
  implements AdapterView.OnItemClickListener
{
  bgdb jdField_a_of_type_Bgdb;
  bgdg jdField_a_of_type_Bgdg;
  bgdh jdField_a_of_type_Bgdh;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  
  public bgdi(View paramView, bgdg parambgdg, bgdh parambgdh, bgdb parambgdb)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramView.findViewById(2131364741));
    this.jdField_a_of_type_Bgdh = parambgdh;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bgdh);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Bgdg = parambgdg;
    this.jdField_a_of_type_Bgdb = parambgdb;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Bgdh.a(paramInt);
    this.jdField_a_of_type_Bgdb.a(-1);
    if (this.jdField_a_of_type_Bgdg != null)
    {
      bgdd localbgdd = new bgdd(2, null, ((Integer)this.jdField_a_of_type_Bgdh.getItem(paramInt)).intValue(), null);
      this.jdField_a_of_type_Bgdg.a(localbgdd);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdi
 * JD-Core Version:    0.7.0.1
 */