import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.HorizontalListView;

public class bdrt
  extends RecyclerView.ViewHolder
  implements AdapterView.OnItemClickListener
{
  bdrm jdField_a_of_type_Bdrm;
  bdrr jdField_a_of_type_Bdrr;
  bdrs jdField_a_of_type_Bdrs;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  
  public bdrt(View paramView, bdrr parambdrr, bdrs parambdrs, bdrm parambdrm)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramView.findViewById(2131364458));
    this.jdField_a_of_type_Bdrs = parambdrs;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bdrs);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Bdrr = parambdrr;
    this.jdField_a_of_type_Bdrm = parambdrm;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Bdrs.a(paramInt);
    this.jdField_a_of_type_Bdrm.a(-1);
    if (this.jdField_a_of_type_Bdrr != null)
    {
      paramAdapterView = new bdro(2, null, ((Integer)this.jdField_a_of_type_Bdrs.getItem(paramInt)).intValue(), null);
      this.jdField_a_of_type_Bdrr.a(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdrt
 * JD-Core Version:    0.7.0.1
 */