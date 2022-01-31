import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public abstract class biad<M, VH extends biac<M>>
  extends RecyclerView.Adapter<biac<M>>
{
  protected Context a;
  protected View a;
  protected biaa a;
  protected biab a;
  protected View b;
  
  public biad(Context paramContext)
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
  
  public final biac b(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new biac(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Biaa != null) {
        paramViewGroup.itemView.setOnClickListener(new biae(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Biab != null) {
        paramViewGroup.itemView.setOnLongClickListener(new biaf(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new biac(this.b);
      } else {
        paramViewGroup = a(paramViewGroup, paramInt);
      }
    }
  }
  
  public final void b(biac parambiac, int paramInt)
  {
    switch (parambiac.getItemViewType())
    {
    default: 
      a(parambiac, paramInt);
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
 * Qualified Name:     biad
 * JD-Core Version:    0.7.0.1
 */