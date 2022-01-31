import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;

public class atnp
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private SparseArrayCompat<View> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  private RecyclerView.Adapter jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter;
  private SparseArrayCompat<View> b = new SparseArrayCompat();
  
  public atnp(RecyclerView.Adapter paramAdapter)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter = paramAdapter;
  }
  
  private boolean a(int paramInt)
  {
    return paramInt < a();
  }
  
  private boolean b(int paramInt)
  {
    return paramInt >= a() + c();
  }
  
  private int c()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size();
  }
  
  public RecyclerView.Adapter a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size() + 100000, paramView);
  }
  
  public int b()
  {
    return this.b.size();
  }
  
  public void b(View paramView)
  {
    this.b.put(this.b.size() + 200000, paramView);
  }
  
  public int getItemCount()
  {
    return a() + c() + b();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (a(paramInt)) {
      return this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.keyAt(paramInt);
    }
    if (b(paramInt)) {
      return this.b.keyAt(paramInt - a() - c());
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemViewType(paramInt - a());
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((a(paramInt)) || (b(paramInt))) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onBindViewHolder(paramViewHolder, paramInt - a());
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt) != null) {
      return new atnq((View)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt));
    }
    if (this.b.get(paramInt) != null) {
      return new atnq((View)this.b.get(paramInt));
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onCreateViewHolder(paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atnp
 * JD-Core Version:    0.7.0.1
 */