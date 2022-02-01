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

public class ayot
  extends RecyclerView.Adapter<ayou>
{
  private int jdField_a_of_type_Int = 3;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private aypp jdField_a_of_type_Aypp;
  private final List<ayqn> jdField_a_of_type_JavaUtilList;
  
  public ayot(FragmentActivity paramFragmentActivity, RecyclerView paramRecyclerView, List<ayqn> paramList)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public ayou a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return new ayov(LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559571, paramViewGroup, false));
    case 0: 
      if (this.jdField_a_of_type_Aypp == null)
      {
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559570, paramViewGroup, false);
        this.jdField_a_of_type_Aypp = new aypp(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramViewGroup);
      }
      return this.jdField_a_of_type_Aypp;
    case 1: 
      return new ayoy(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559566, paramViewGroup, false));
    }
    return new ayqg(LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559572, paramViewGroup, false));
  }
  
  public void a()
  {
    notifyItemChanged(0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ayou paramayou)
  {
    super.onViewAttachedToWindow(paramayou);
    ViewGroup.LayoutParams localLayoutParams = paramayou.itemView.getLayoutParams();
    if ((localLayoutParams != null) && ((localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) && (a(paramayou.getLayoutPosition()))) {
      ((StaggeredGridLayoutManager.LayoutParams)localLayoutParams).setFullSpan(true);
    }
  }
  
  public void a(ayou paramayou, int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramayou, paramInt, getItemId(paramInt));
      return;
      this.jdField_a_of_type_Aypp.a();
      continue;
      ayox.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramayou);
      continue;
      if (paramInt - 2 < this.jdField_a_of_type_JavaUtilList.size())
      {
        ayqh.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramayou, (ayqn)this.jdField_a_of_type_JavaUtilList.get(paramInt - 2), paramInt);
        continue;
        ayqh.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramayou, this.jdField_a_of_type_Int);
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
 * Qualified Name:     ayot
 * JD-Core Version:    0.7.0.1
 */