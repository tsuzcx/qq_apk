import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class bfyp<M, VH extends bfyo<M>>
  extends RecyclerView.Adapter<bfyo<M>>
{
  protected Context a;
  protected View a;
  protected bfym a;
  protected bfyn a;
  protected View b;
  
  public bfyp(Context paramContext)
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
  
  public final bfyo b(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new bfyo(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bfym != null) {
        paramViewGroup.itemView.setOnClickListener(new bfyq(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Bfyn != null) {
        paramViewGroup.itemView.setOnLongClickListener(new bfyr(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new bfyo(this.b);
      } else {
        paramViewGroup = a(paramViewGroup, paramInt);
      }
    }
  }
  
  public final void b(bfyo parambfyo, int paramInt)
  {
    switch (parambfyo.getItemViewType())
    {
    default: 
      a(parambfyo, paramInt);
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
 * Qualified Name:     bfyp
 * JD-Core Version:    0.7.0.1
 */