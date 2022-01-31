import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.HorizontalListView;

public class bboc
  extends RecyclerView.ViewHolder
  implements AdapterView.OnItemClickListener
{
  bbnv jdField_a_of_type_Bbnv;
  bboa jdField_a_of_type_Bboa;
  bbob jdField_a_of_type_Bbob;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  
  public bboc(View paramView, bboa parambboa, bbob parambbob, bbnv parambbnv)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramView.findViewById(2131364386));
    this.jdField_a_of_type_Bbob = parambbob;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bbob);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Bboa = parambboa;
    this.jdField_a_of_type_Bbnv = parambbnv;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Bbob.a(paramInt);
    this.jdField_a_of_type_Bbnv.a(-1);
    if (this.jdField_a_of_type_Bboa != null)
    {
      paramAdapterView = new bbnx(2, null, ((Integer)this.jdField_a_of_type_Bbob.getItem(paramInt)).intValue(), null);
      this.jdField_a_of_type_Bboa.a(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bboc
 * JD-Core Version:    0.7.0.1
 */