import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class beqv<M, VH extends bequ<M>>
  extends RecyclerView.Adapter<bequ<M>>
{
  protected Context a;
  protected View a;
  protected beqs a;
  protected beqt a;
  protected View b;
  
  public beqv(Context paramContext)
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
  
  public final bequ b(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new bequ(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Beqs != null) {
        paramViewGroup.itemView.setOnClickListener(new beqw(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Beqt != null) {
        paramViewGroup.itemView.setOnLongClickListener(new beqx(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new bequ(this.b);
      } else {
        paramViewGroup = a(paramViewGroup, paramInt);
      }
    }
  }
  
  public final void b(bequ parambequ, int paramInt)
  {
    switch (parambequ.getItemViewType())
    {
    default: 
      a(parambequ, paramInt);
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
 * Qualified Name:     beqv
 * JD-Core Version:    0.7.0.1
 */