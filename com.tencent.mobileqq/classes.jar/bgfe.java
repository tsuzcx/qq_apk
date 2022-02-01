import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.ViewGroup;

public class bgfe
{
  private SparseArray<bgfc> a;
  
  @NonNull
  public RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    bgfc localbgfc = a(paramInt);
    if (localbgfc != null) {
      return localbgfc.a(paramViewGroup);
    }
    return null;
  }
  
  public bgfc a(int paramInt)
  {
    return (bgfc)this.a.get(paramInt);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((bgfc)this.a.valueAt(i)).a();
      i += 1;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bgff)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bgfc localbgfc = a(paramViewHolder.a.b());
      if (localbgfc != null) {
        localbgfc.a(paramViewHolder);
      }
    }
  }
  
  public void a(@NonNull RecyclerView.ViewHolder paramViewHolder, bgeg parambgeg, int paramInt)
  {
    bgfc localbgfc = a(parambgeg.b());
    if (localbgfc != null)
    {
      ((bgff)paramViewHolder).a = parambgeg;
      localbgfc.a(paramViewHolder, parambgeg, paramInt);
    }
  }
  
  public void a(SparseArray<bgfc> paramSparseArray)
  {
    this.a = paramSparseArray;
  }
  
  public void a(bgeg parambgeg)
  {
    bgfc localbgfc = a(parambgeg.b());
    if (localbgfc != null) {
      localbgfc.b(parambgeg);
    }
  }
  
  public void a(bgeq parambgeq)
  {
    bgfc localbgfc = a(parambgeq.b());
    if ((localbgfc != null) && ((localbgfc instanceof bgfv))) {
      ((bgfv)localbgfc).a(parambgeq);
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bgff)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bgfc localbgfc = a(paramViewHolder.a.b());
      if (localbgfc != null) {
        localbgfc.b(paramViewHolder);
      }
    }
  }
  
  public void b(bgeg parambgeg)
  {
    bgfc localbgfc = a(parambgeg.b());
    if (localbgfc != null) {
      localbgfc.c(parambgeg);
    }
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bgff)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bgfc localbgfc = a(paramViewHolder.a.b());
      if (localbgfc != null) {
        localbgfc.c(paramViewHolder);
      }
    }
  }
  
  public void c(bgeg parambgeg)
  {
    bgfc localbgfc = a(parambgeg.b());
    if (localbgfc != null) {
      localbgfc.d(parambgeg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfe
 * JD-Core Version:    0.7.0.1
 */