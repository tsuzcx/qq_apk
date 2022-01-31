import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.HorizontalListView;

public class bdnk
  extends RecyclerView.ViewHolder
  implements AdapterView.OnItemClickListener
{
  bdnd jdField_a_of_type_Bdnd;
  bdni jdField_a_of_type_Bdni;
  bdnj jdField_a_of_type_Bdnj;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  
  public bdnk(View paramView, bdni parambdni, bdnj parambdnj, bdnd parambdnd)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramView.findViewById(2131364456));
    this.jdField_a_of_type_Bdnj = parambdnj;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bdnj);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Bdni = parambdni;
    this.jdField_a_of_type_Bdnd = parambdnd;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Bdnj.a(paramInt);
    this.jdField_a_of_type_Bdnd.a(-1);
    if (this.jdField_a_of_type_Bdni != null)
    {
      paramAdapterView = new bdnf(2, null, ((Integer)this.jdField_a_of_type_Bdnj.getItem(paramInt)).intValue(), null);
      this.jdField_a_of_type_Bdni.a(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdnk
 * JD-Core Version:    0.7.0.1
 */