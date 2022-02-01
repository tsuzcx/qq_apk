import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class bkrw<M, VH extends bkrv<M>>
  extends RecyclerView.Adapter<bkrv<M>>
{
  protected Context a;
  protected View a;
  protected bkrt a;
  protected bkru a;
  protected View b;
  
  public bkrw(Context paramContext)
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
  
  public void a(bkrt parambkrt)
  {
    this.jdField_a_of_type_Bkrt = parambkrt;
  }
  
  public abstract void a(VH paramVH, int paramInt);
  
  public final bkrv b(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new bkrv(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bkrt != null) {
        paramViewGroup.itemView.setOnClickListener(new bkrx(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Bkru != null) {
        paramViewGroup.itemView.setOnLongClickListener(new bkry(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new bkrv(this.b);
      } else {
        paramViewGroup = a(paramViewGroup, paramInt);
      }
    }
  }
  
  public final void b(bkrv parambkrv, int paramInt)
  {
    switch (parambkrv.getItemViewType())
    {
    default: 
      a(parambkrv, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(parambkrv, paramInt, getItemId(paramInt));
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
  
  public abstract long getItemId(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkrw
 * JD-Core Version:    0.7.0.1
 */