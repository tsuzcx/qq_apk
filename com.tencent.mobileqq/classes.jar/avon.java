import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avon
  extends RecyclerView.Adapter
{
  private RecyclerView.Adapter jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter;
  private RecyclerView.AdapterDataObserver jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new avoo(this);
  avma jdField_a_of_type_Avma;
  
  public avon(@NonNull RecyclerView.Adapter paramAdapter, avma paramavma)
  {
    this.jdField_a_of_type_Avma = paramavma;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter = paramAdapter;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_Avma == null) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount();
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_Avma != null) && (paramInt == getItemCount() - 1)) {
      return 2147483647;
    }
    return super.getItemViewType(paramInt);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.jdField_a_of_type_Avma != null) && (paramInt == getItemCount() - 1)) {
      this.jdField_a_of_type_Avma.a(paramViewHolder, paramInt);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onBindViewHolder(paramViewHolder, paramInt);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.jdField_a_of_type_Avma != null) && (2147483647 == paramInt)) {
      return this.jdField_a_of_type_Avma.a(paramViewGroup, paramInt);
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onCreateViewHolder(paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avon
 * JD-Core Version:    0.7.0.1
 */