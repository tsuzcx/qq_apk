import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ayvg
  extends RecyclerView.Adapter<ayvh>
{
  private int jdField_a_of_type_Int = 3;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private aywc jdField_a_of_type_Aywc;
  private final List<ayxa> jdField_a_of_type_JavaUtilList;
  
  public ayvg(FragmentActivity paramFragmentActivity, RecyclerView paramRecyclerView, List<ayxa> paramList)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public ayvh a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return new ayvi(LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559536, paramViewGroup, false));
    case 0: 
      if (this.jdField_a_of_type_Aywc == null)
      {
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559535, paramViewGroup, false);
        this.jdField_a_of_type_Aywc = new aywc(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramViewGroup);
      }
      return this.jdField_a_of_type_Aywc;
    case 1: 
      return new ayvl(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559531, paramViewGroup, false));
    }
    return new aywt(LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559537, paramViewGroup, false));
  }
  
  public void a()
  {
    notifyItemChanged(0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ayvh paramayvh)
  {
    super.onViewAttachedToWindow(paramayvh);
    ViewGroup.LayoutParams localLayoutParams = paramayvh.itemView.getLayoutParams();
    if ((localLayoutParams != null) && ((localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) && (a(paramayvh.getLayoutPosition()))) {
      ((StaggeredGridLayoutManager.LayoutParams)localLayoutParams).setFullSpan(true);
    }
  }
  
  public void a(ayvh paramayvh, int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramayvh, paramInt, getItemId(paramInt));
      return;
      this.jdField_a_of_type_Aywc.a();
      continue;
      ayvk.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramayvh);
      continue;
      if (paramInt - 2 < this.jdField_a_of_type_JavaUtilList.size())
      {
        aywu.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramayvh, (ayxa)this.jdField_a_of_type_JavaUtilList.get(paramInt - 2), paramInt);
        continue;
        aywu.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramayvh, this.jdField_a_of_type_Int);
      }
    }
  }
  
  protected boolean a(int paramInt)
  {
    return getItemViewType(paramInt) != 2;
  }
  
  public int getItemCount()
  {
    if ((this.jdField_a_of_type_Int != 1) && ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))) {
      return 3;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 2;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      i = 0;
    }
    while (paramInt == 1) {
      return i;
    }
    if ((this.jdField_a_of_type_Int != 1) && ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))) {
      return 3;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvg
 * JD-Core Version:    0.7.0.1
 */