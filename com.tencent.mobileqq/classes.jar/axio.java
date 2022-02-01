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

public class axio
  extends RecyclerView.Adapter<axip>
{
  private int jdField_a_of_type_Int = 3;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private axjk jdField_a_of_type_Axjk;
  private final List<axki> jdField_a_of_type_JavaUtilList;
  
  public axio(FragmentActivity paramFragmentActivity, RecyclerView paramRecyclerView, List<axki> paramList)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public axip a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return new axiq(LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559538, paramViewGroup, false));
    case 0: 
      if (this.jdField_a_of_type_Axjk == null)
      {
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559537, paramViewGroup, false);
        this.jdField_a_of_type_Axjk = new axjk(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, paramViewGroup);
      }
      return this.jdField_a_of_type_Axjk;
    case 1: 
      return new axit(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559533, paramViewGroup, false));
    }
    return new axkb(LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559539, paramViewGroup, false));
  }
  
  public void a()
  {
    notifyItemChanged(0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(axip paramaxip)
  {
    super.onViewAttachedToWindow(paramaxip);
    ViewGroup.LayoutParams localLayoutParams = paramaxip.itemView.getLayoutParams();
    if ((localLayoutParams != null) && ((localLayoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) && (a(paramaxip.getLayoutPosition()))) {
      ((StaggeredGridLayoutManager.LayoutParams)localLayoutParams).setFullSpan(true);
    }
  }
  
  public void a(axip paramaxip, int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaxip, paramInt, getItemId(paramInt));
      return;
      this.jdField_a_of_type_Axjk.a();
      continue;
      axis.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramaxip);
      continue;
      if (paramInt - 2 < this.jdField_a_of_type_JavaUtilList.size())
      {
        axkc.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramaxip, (axki)this.jdField_a_of_type_JavaUtilList.get(paramInt - 2), paramInt);
        continue;
        axkc.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramaxip, this.jdField_a_of_type_Int);
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
 * Qualified Name:     axio
 * JD-Core Version:    0.7.0.1
 */