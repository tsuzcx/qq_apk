import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.ViewGroup;

public class bcew
{
  private SparseArray<bceu> a;
  
  @NonNull
  public RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    bceu localbceu = a(paramInt);
    if (localbceu != null) {
      return localbceu.a(paramViewGroup);
    }
    return null;
  }
  
  public bceu a(int paramInt)
  {
    return (bceu)this.a.get(paramInt);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((bceu)this.a.valueAt(i)).a();
      i += 1;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bcex)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bceu localbceu = a(paramViewHolder.a.b());
      if (localbceu != null) {
        localbceu.a(paramViewHolder);
      }
    }
  }
  
  public void a(@NonNull RecyclerView.ViewHolder paramViewHolder, bcdy parambcdy, int paramInt)
  {
    bceu localbceu = a(parambcdy.b());
    if (localbceu != null)
    {
      ((bcex)paramViewHolder).a = parambcdy;
      localbceu.a(paramViewHolder, parambcdy, paramInt);
    }
  }
  
  public void a(SparseArray<bceu> paramSparseArray)
  {
    this.a = paramSparseArray;
  }
  
  public void a(bcdy parambcdy)
  {
    bceu localbceu = a(parambcdy.b());
    if (localbceu != null) {
      localbceu.b(parambcdy);
    }
  }
  
  public void a(bcei parambcei)
  {
    bceu localbceu = a(parambcei.b());
    if ((localbceu != null) && ((localbceu instanceof bcfn))) {
      ((bcfn)localbceu).a(parambcei);
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bcex)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bceu localbceu = a(paramViewHolder.a.b());
      if (localbceu != null) {
        localbceu.b(paramViewHolder);
      }
    }
  }
  
  public void b(bcdy parambcdy)
  {
    bceu localbceu = a(parambcdy.b());
    if (localbceu != null) {
      localbceu.c(parambcdy);
    }
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bcex)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bceu localbceu = a(paramViewHolder.a.b());
      if (localbceu != null) {
        localbceu.c(paramViewHolder);
      }
    }
  }
  
  public void c(bcdy parambcdy)
  {
    bceu localbceu = a(parambcdy.b());
    if (localbceu != null) {
      localbceu.d(parambcdy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcew
 * JD-Core Version:    0.7.0.1
 */