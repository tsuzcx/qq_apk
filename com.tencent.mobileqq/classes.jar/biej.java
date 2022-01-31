import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class biej<M>
  extends RecyclerView.ViewHolder
{
  private SparseArray<View> a = new SparseArray();
  
  public biej(View paramView)
  {
    super(paramView);
  }
  
  public biej(ViewGroup paramViewGroup, int paramInt)
  {
    super(LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false));
  }
  
  protected Context a()
  {
    return this.itemView.getContext();
  }
  
  public void a(M paramM) {}
  
  protected <T extends View> T b(@IdRes int paramInt)
  {
    View localView2 = (View)this.a.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.itemView.findViewById(paramInt);
      this.a.put(paramInt, localView1);
    }
    return localView1;
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biej
 * JD-Core Version:    0.7.0.1
 */