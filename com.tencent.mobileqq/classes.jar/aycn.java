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

public class aycn
  extends RecyclerView.Adapter<ayco>
{
  private int jdField_a_of_type_Int = 3;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private aydj jdField_a_of_type_Aydj;
  private final List<ayeh> jdField_a_of_type_JavaUtilList;
  
  public aycn(FragmentActivity paramFragmentActivity, RecyclerView paramRecyclerView, List<ayeh> paramList)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public ayco a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return new aycp(LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559531, paramViewGroup, false));
    case 0: 
      if (this.jdField_a_of_type_Aydj == null)
      {
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559530, paramViewGroup, false);
        this.jdField_a_of_type_Aydj = new aydj(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramViewGroup);
      }
      return this.jdField_a_of_type_Aydj;
    case 1: 
      return new aycs(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559526, paramViewGroup, false));
    }
    return new ayea(LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559532, paramViewGroup, false));
  }
  
  public void a()
  {
    notifyItemChanged(0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ayco paramayco)
  {
    super.onViewAttachedToWindow(paramayco);
    ViewGroup.LayoutParams localLayoutParams = paramayco.itemView.getLayoutParams();
    if ((localLayoutParams != null) && ((localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) && (a(paramayco.getLayoutPosition()))) {
      ((StaggeredGridLayoutManager.LayoutParams)localLayoutParams).setFullSpan(true);
    }
  }
  
  public void a(ayco paramayco, int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramayco, paramInt, getItemId(paramInt));
      return;
      this.jdField_a_of_type_Aydj.a();
      continue;
      aycr.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramayco);
      continue;
      if (paramInt - 2 < this.jdField_a_of_type_JavaUtilList.size())
      {
        ayeb.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramayco, (ayeh)this.jdField_a_of_type_JavaUtilList.get(paramInt - 2), paramInt);
        continue;
        ayeb.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramayco, this.jdField_a_of_type_Int);
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
 * Qualified Name:     aycn
 * JD-Core Version:    0.7.0.1
 */