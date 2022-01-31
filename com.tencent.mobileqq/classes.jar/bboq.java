import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.HorizontalListView;

public class bboq
  extends RecyclerView.ViewHolder
  implements AdapterView.OnItemClickListener
{
  bboj jdField_a_of_type_Bboj;
  bboo jdField_a_of_type_Bboo;
  bbop jdField_a_of_type_Bbop;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  
  public bboq(View paramView, bboo parambboo, bbop parambbop, bboj parambboj)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramView.findViewById(2131364385));
    this.jdField_a_of_type_Bbop = parambbop;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bbop);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Bboo = parambboo;
    this.jdField_a_of_type_Bboj = parambboj;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Bbop.a(paramInt);
    this.jdField_a_of_type_Bboj.a(-1);
    if (this.jdField_a_of_type_Bboo != null)
    {
      paramAdapterView = new bbol(2, null, ((Integer)this.jdField_a_of_type_Bbop.getItem(paramInt)).intValue(), null);
      this.jdField_a_of_type_Bboo.a(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bboq
 * JD-Core Version:    0.7.0.1
 */