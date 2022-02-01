import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class blsz<M, VH extends blsy<M>>
  extends RecyclerView.Adapter<blsy<M>>
{
  protected Context a;
  protected View a;
  protected blsw a;
  protected blsx a;
  protected View b;
  
  public blsz(Context paramContext)
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
  
  public void a(blsw paramblsw)
  {
    this.jdField_a_of_type_Blsw = paramblsw;
  }
  
  public abstract void a(VH paramVH, int paramInt);
  
  public final blsy b(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new blsy(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Blsw != null) {
        paramViewGroup.itemView.setOnClickListener(new blta(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Blsx != null) {
        paramViewGroup.itemView.setOnLongClickListener(new bltb(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new blsy(this.b);
      } else {
        paramViewGroup = a(paramViewGroup, paramInt);
      }
    }
  }
  
  public final void b(blsy paramblsy, int paramInt)
  {
    switch (paramblsy.getItemViewType())
    {
    default: 
      a(paramblsy, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramblsy, paramInt, getItemId(paramInt));
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
 * Qualified Name:     blsz
 * JD-Core Version:    0.7.0.1
 */