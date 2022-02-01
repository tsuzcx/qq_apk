import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.ViewGroup;

public class bffk
{
  private SparseArray<bffi> a;
  
  @NonNull
  public RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    bffi localbffi = a(paramInt);
    if (localbffi != null) {
      return localbffi.a(paramViewGroup);
    }
    return null;
  }
  
  public bffi a(int paramInt)
  {
    return (bffi)this.a.get(paramInt);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((bffi)this.a.valueAt(i)).a();
      i += 1;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bffl)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bffi localbffi = a(paramViewHolder.a.b());
      if (localbffi != null) {
        localbffi.a(paramViewHolder);
      }
    }
  }
  
  public void a(@NonNull RecyclerView.ViewHolder paramViewHolder, bfem parambfem, int paramInt)
  {
    bffi localbffi = a(parambfem.b());
    if (localbffi != null)
    {
      ((bffl)paramViewHolder).a = parambfem;
      localbffi.a(paramViewHolder, parambfem, paramInt);
    }
  }
  
  public void a(SparseArray<bffi> paramSparseArray)
  {
    this.a = paramSparseArray;
  }
  
  public void a(bfem parambfem)
  {
    bffi localbffi = a(parambfem.b());
    if (localbffi != null) {
      localbffi.b(parambfem);
    }
  }
  
  public void a(bfew parambfew)
  {
    bffi localbffi = a(parambfew.b());
    if ((localbffi != null) && ((localbffi instanceof bfgb))) {
      ((bfgb)localbffi).a(parambfew);
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bffl)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bffi localbffi = a(paramViewHolder.a.b());
      if (localbffi != null) {
        localbffi.b(paramViewHolder);
      }
    }
  }
  
  public void b(bfem parambfem)
  {
    bffi localbffi = a(parambfem.b());
    if (localbffi != null) {
      localbffi.c(parambfem);
    }
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bffl)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bffi localbffi = a(paramViewHolder.a.b());
      if (localbffi != null) {
        localbffi.c(paramViewHolder);
      }
    }
  }
  
  public void c(bfem parambfem)
  {
    bffi localbffi = a(parambfem.b());
    if (localbffi != null) {
      localbffi.d(parambfem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffk
 * JD-Core Version:    0.7.0.1
 */