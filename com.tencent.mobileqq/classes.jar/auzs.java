import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.hiboom.HiBoomPanelView;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class auzs
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public auzs(HiBoomPanelView paramHiBoomPanelView)
  {
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-1));
  }
  
  public int a(int paramInt)
  {
    return ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).intValue();
  }
  
  public void a(List<Integer> paramList1, List<Integer> paramList2, List<Integer> paramList3)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList1 != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
    }
    if ((paramList2 != null) && (paramList2.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList2);
    }
    if ((paramList3 != null) && (paramList3.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList3);
    }
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-1));
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (a(paramInt) == -2) {
      return 2;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    auzt localauzt;
    if ((paramViewHolder instanceof auzt))
    {
      localauzt = (auzt)paramViewHolder;
      localauzt.jdField_a_of_type_Int = paramInt;
      if (localauzt.jdField_a_of_type_Boolean) {
        break label41;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      label41:
      int i = a(paramInt);
      ViewGroup.LayoutParams localLayoutParams = localauzt.itemView.getLayoutParams();
      localLayoutParams.height = HiBoomPanelView.jdField_a_of_type_Int;
      localLayoutParams.width = HiBoomPanelView.b;
      localauzt.itemView.setPadding(0, 0, HiBoomPanelView.c, HiBoomPanelView.c);
      localLayoutParams = localauzt.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.getLayoutParams();
      localLayoutParams.width = (HiBoomPanelView.b - HiBoomPanelView.c - HiBoomPanelView.d * 2);
      localLayoutParams.height = localLayoutParams.width;
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.a(localauzt, i);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = null;
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      return null;
    }
    try
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext()).inflate(2131563064, paramViewGroup, false);
      localObject = paramViewGroup;
      if (paramViewGroup == null) {
        localObject = new View(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext());
      }
      return new auzt(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView, (View)localObject, bool);
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        QLog.e("HiBoomFont.HiBoomPanelView", 1, "inflate hiboom item error: ", paramViewGroup);
        bool = false;
        paramViewGroup = (ViewGroup)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzs
 * JD-Core Version:    0.7.0.1
 */