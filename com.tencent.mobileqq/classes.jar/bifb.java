import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class bifb<T extends RecyclerView.Adapter>
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final T jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter;
  private biff jdField_a_of_type_Biff;
  private bifg jdField_a_of_type_Bifg;
  private final List<View> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final List<View> b = new ArrayList();
  
  public bifb(T paramT)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter = paramT;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.registerAdapterDataObserver(new bifc(this));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public T a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter;
  }
  
  public bifb a(biff parambiff)
  {
    this.jdField_a_of_type_Biff = parambiff;
    return this;
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bifg != null) {
      this.jdField_a_of_type_Bifg.a(paramViewHolder, paramInt);
    }
  }
  
  public void a(@NonNull View paramView)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramView);
  }
  
  public void a(bifg parambifg)
  {
    this.jdField_a_of_type_Bifg = parambifg;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt < this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public boolean a(View paramView)
  {
    return this.jdField_a_of_type_JavaUtilList.contains(paramView);
  }
  
  public void b(@NonNull View paramView)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramView);
  }
  
  public boolean b(int paramInt)
  {
    return paramInt >= getItemCount() - this.b.size();
  }
  
  public void c(@NonNull View paramView)
  {
    this.b.add(paramView);
  }
  
  public boolean c(int paramInt)
  {
    return (paramInt >= -1000) && (paramInt < this.jdField_a_of_type_JavaUtilList.size() - 1000);
  }
  
  public boolean d(int paramInt)
  {
    return (paramInt >= -2000) && (paramInt < this.b.size() - 2000);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount() + this.b.size();
  }
  
  public long getItemId(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return ((View)this.jdField_a_of_type_JavaUtilList.get(paramInt)).hashCode();
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount()) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemId(paramInt - this.jdField_a_of_type_JavaUtilList.size());
    }
    return ((View)this.b.get(paramInt - this.jdField_a_of_type_JavaUtilList.size() - this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount())).hashCode();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return paramInt - 1000;
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount()) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemViewType(paramInt - this.jdField_a_of_type_JavaUtilList.size());
    }
    return paramInt - 2000 - this.jdField_a_of_type_JavaUtilList.size() - this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (StaggeredGridLayoutManager.LayoutParams.class.isInstance(paramViewHolder.itemView.getLayoutParams())) {
        localObject1 = (StaggeredGridLayoutManager.LayoutParams)paramViewHolder.itemView.getLayoutParams();
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
        paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      ((StaggeredGridLayoutManager.LayoutParams)localObject2).setFullSpan(true);
      a(paramViewHolder, paramInt);
      return;
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount())
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onBindViewHolder(paramViewHolder, paramInt - this.jdField_a_of_type_JavaUtilList.size());
      return;
    }
    localObject1 = localObject2;
    if (StaggeredGridLayoutManager.LayoutParams.class.isInstance(paramViewHolder.itemView.getLayoutParams())) {
      localObject1 = (StaggeredGridLayoutManager.LayoutParams)paramViewHolder.itemView.getLayoutParams();
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
      paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    ((StaggeredGridLayoutManager.LayoutParams)localObject2).setFullSpan(true);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt, List<Object> paramList)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      super.onBindViewHolder(paramViewHolder, paramInt, paramList);
      return;
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size() + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount())
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onBindViewHolder(paramViewHolder, paramInt - this.jdField_a_of_type_JavaUtilList.size(), paramList);
      return;
    }
    super.onBindViewHolder(paramViewHolder, paramInt, paramList);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (c(paramInt))
    {
      paramInt = Math.abs(paramInt + 1000);
      return new bifd(this, (View)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    if (d(paramInt))
    {
      paramInt = Math.abs(paramInt + 2000);
      return new bife(this, (View)this.b.get(paramInt));
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onCreateViewHolder(paramViewGroup, paramInt);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter != null) && ((paramViewHolder instanceof biej))) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onViewAttachedToWindow(paramViewHolder);
    }
  }
  
  public void onViewDetachedFromWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter != null) && ((paramViewHolder instanceof biej))) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onViewDetachedFromWindow(paramViewHolder);
    }
  }
  
  public void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter != null) && ((paramViewHolder instanceof biej))) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onViewRecycled(paramViewHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bifb
 * JD-Core Version:    0.7.0.1
 */