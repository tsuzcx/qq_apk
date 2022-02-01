import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.ViewGroup;

public class bfvp
{
  private SparseArray<bfvn> a;
  
  @NonNull
  public RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    bfvn localbfvn = a(paramInt);
    if (localbfvn != null) {
      return localbfvn.a(paramViewGroup);
    }
    return null;
  }
  
  public bfvn a(int paramInt)
  {
    return (bfvn)this.a.get(paramInt);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((bfvn)this.a.valueAt(i)).a();
      i += 1;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bfvq)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bfvn localbfvn = a(paramViewHolder.a.b());
      if (localbfvn != null) {
        localbfvn.a(paramViewHolder);
      }
    }
  }
  
  public void a(@NonNull RecyclerView.ViewHolder paramViewHolder, bfur parambfur, int paramInt)
  {
    bfvn localbfvn = a(parambfur.b());
    if (localbfvn != null)
    {
      ((bfvq)paramViewHolder).a = parambfur;
      localbfvn.a(paramViewHolder, parambfur, paramInt);
    }
  }
  
  public void a(SparseArray<bfvn> paramSparseArray)
  {
    this.a = paramSparseArray;
  }
  
  public void a(bfur parambfur)
  {
    bfvn localbfvn = a(parambfur.b());
    if (localbfvn != null) {
      localbfvn.b(parambfur);
    }
  }
  
  public void a(bfvb parambfvb)
  {
    bfvn localbfvn = a(parambfvb.b());
    if ((localbfvn != null) && ((localbfvn instanceof bfwg))) {
      ((bfwg)localbfvn).a(parambfvb);
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bfvq)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bfvn localbfvn = a(paramViewHolder.a.b());
      if (localbfvn != null) {
        localbfvn.b(paramViewHolder);
      }
    }
  }
  
  public void b(bfur parambfur)
  {
    bfvn localbfvn = a(parambfur.b());
    if (localbfvn != null) {
      localbfvn.c(parambfur);
    }
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bfvq)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bfvn localbfvn = a(paramViewHolder.a.b());
      if (localbfvn != null) {
        localbfvn.c(paramViewHolder);
      }
    }
  }
  
  public void c(bfur parambfur)
  {
    bfvn localbfvn = a(parambfur.b());
    if (localbfvn != null) {
      localbfvn.d(parambfur);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfvp
 * JD-Core Version:    0.7.0.1
 */