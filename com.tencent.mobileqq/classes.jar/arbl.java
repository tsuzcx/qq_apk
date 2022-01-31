import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

public class arbl
  extends RecyclerView.Adapter
{
  private RecyclerView.Adapter jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter;
  private RecyclerView.AdapterDataObserver jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new arbm(this);
  aqyx jdField_a_of_type_Aqyx;
  
  public arbl(@NonNull RecyclerView.Adapter paramAdapter, aqyx paramaqyx)
  {
    this.jdField_a_of_type_Aqyx = paramaqyx;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter = paramAdapter;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_Aqyx == null) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount();
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_Aqyx != null) && (paramInt == getItemCount() - 1)) {
      return 2147483647;
    }
    return super.getItemViewType(paramInt);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.jdField_a_of_type_Aqyx != null) && (paramInt == getItemCount() - 1))
    {
      this.jdField_a_of_type_Aqyx.a(paramViewHolder, paramInt);
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onBindViewHolder(paramViewHolder, paramInt);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.jdField_a_of_type_Aqyx != null) && (2147483647 == paramInt)) {
      return this.jdField_a_of_type_Aqyx.a(paramViewGroup, paramInt);
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onCreateViewHolder(paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arbl
 * JD-Core Version:    0.7.0.1
 */