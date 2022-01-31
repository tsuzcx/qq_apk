import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public abstract class biek<M, VH extends biej<M>>
  extends RecyclerView.Adapter<biej<M>>
{
  protected Context a;
  protected View a;
  protected bieh a;
  protected biei a;
  protected View b;
  
  public biek(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public abstract VH a(ViewGroup paramViewGroup, int paramInt);
  
  public void a(View paramView)
  {
    if (paramView == null)
    {
      Log.w("HeaderAndFooterAdapter", "add the footer view is null");
      return;
    }
    this.b = paramView;
    notifyDataSetChanged();
  }
  
  public abstract void a(VH paramVH, int paramInt);
  
  public final biej b(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new biej(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bieh != null) {
        paramViewGroup.itemView.setOnClickListener(new biel(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Biei != null) {
        paramViewGroup.itemView.setOnLongClickListener(new biem(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new biej(this.b);
      } else {
        paramViewGroup = a(paramViewGroup, paramInt);
      }
    }
  }
  
  public final void b(biej parambiej, int paramInt)
  {
    switch (parambiej.getItemViewType())
    {
    default: 
      a(parambiej, paramInt);
    }
  }
  
  public int c()
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      i = 1;
    }
    int j = i;
    if (this.b != null) {
      j = i + 1;
    }
    return j;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biek
 * JD-Core Version:    0.7.0.1
 */