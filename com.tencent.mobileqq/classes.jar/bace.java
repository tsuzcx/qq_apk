import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.ViewGroup;

public class bace
{
  private SparseArray<bacc> a;
  
  @NonNull
  public RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    bacc localbacc = a(paramInt);
    if (localbacc != null) {
      return localbacc.a(paramViewGroup);
    }
    return null;
  }
  
  public bacc a(int paramInt)
  {
    return (bacc)this.a.get(paramInt);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((bacc)this.a.valueAt(i)).a();
      i += 1;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bacf)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bacc localbacc = a(paramViewHolder.a.b());
      if (localbacc != null) {
        localbacc.a(paramViewHolder);
      }
    }
  }
  
  public void a(@NonNull RecyclerView.ViewHolder paramViewHolder, babg parambabg, int paramInt)
  {
    bacc localbacc = a(parambabg.b());
    if (localbacc != null)
    {
      ((bacf)paramViewHolder).a = parambabg;
      localbacc.a(paramViewHolder, parambabg, paramInt);
    }
  }
  
  public void a(SparseArray<bacc> paramSparseArray)
  {
    this.a = paramSparseArray;
  }
  
  public void a(babg parambabg)
  {
    bacc localbacc = a(parambabg.b());
    if (localbacc != null) {
      localbacc.b(parambabg);
    }
  }
  
  public void a(babq parambabq)
  {
    bacc localbacc = a(parambabq.b());
    if ((localbacc != null) && ((localbacc instanceof bacv))) {
      ((bacv)localbacc).a(parambabq);
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bacf)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bacc localbacc = a(paramViewHolder.a.b());
      if (localbacc != null) {
        localbacc.b(paramViewHolder);
      }
    }
  }
  
  public void b(babg parambabg)
  {
    bacc localbacc = a(parambabg.b());
    if (localbacc != null) {
      localbacc.c(parambabg);
    }
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bacf)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bacc localbacc = a(paramViewHolder.a.b());
      if (localbacc != null) {
        localbacc.c(paramViewHolder);
      }
    }
  }
  
  public void c(babg parambabg)
  {
    bacc localbacc = a(parambabg.b());
    if (localbacc != null) {
      localbacc.d(parambabg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bace
 * JD-Core Version:    0.7.0.1
 */