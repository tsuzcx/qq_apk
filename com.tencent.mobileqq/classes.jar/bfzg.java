import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class bfzg<M, VH extends bfzf<M>>
  extends RecyclerView.Adapter<bfzf<M>>
{
  protected Context a;
  protected View a;
  protected bfzd a;
  protected bfze a;
  protected View b;
  
  public bfzg(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public abstract VH a(ViewGroup paramViewGroup, int paramInt);
  
  public abstract void a(VH paramVH, int paramInt);
  
  public int b()
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
  
  public final bfzf b(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new bfzf(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bfzd != null) {
        paramViewGroup.itemView.setOnClickListener(new bfzh(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Bfze != null) {
        paramViewGroup.itemView.setOnLongClickListener(new bfzi(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new bfzf(this.b);
      } else {
        paramViewGroup = a(paramViewGroup, paramInt);
      }
    }
  }
  
  public final void b(bfzf parambfzf, int paramInt)
  {
    switch (parambfzf.getItemViewType())
    {
    default: 
      a(parambfzf, paramInt);
    }
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfzg
 * JD-Core Version:    0.7.0.1
 */