import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.HorizontalListView;

public class bamg
  extends RecyclerView.ViewHolder
  implements AdapterView.OnItemClickListener
{
  balz jdField_a_of_type_Balz;
  bame jdField_a_of_type_Bame;
  bamf jdField_a_of_type_Bamf;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  
  public bamg(View paramView, bame parambame, bamf parambamf, balz parambalz)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramView.findViewById(2131298829));
    this.jdField_a_of_type_Bamf = parambamf;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bamf);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Bame = parambame;
    this.jdField_a_of_type_Balz = parambalz;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Bamf.a(paramInt);
    this.jdField_a_of_type_Balz.a(-1);
    if (this.jdField_a_of_type_Bame != null)
    {
      paramAdapterView = new bamb(2, null, ((Integer)this.jdField_a_of_type_Bamf.getItem(paramInt)).intValue(), null);
      this.jdField_a_of_type_Bame.a(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bamg
 * JD-Core Version:    0.7.0.1
 */