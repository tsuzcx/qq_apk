import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.ViewGroup;

public class beom
{
  private SparseArray<beok> a;
  
  @NonNull
  public RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    beok localbeok = a(paramInt);
    if (localbeok != null) {
      return localbeok.a(paramViewGroup);
    }
    return null;
  }
  
  public beok a(int paramInt)
  {
    return (beok)this.a.get(paramInt);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((beok)this.a.valueAt(i)).a();
      i += 1;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (beon)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      beok localbeok = a(paramViewHolder.a.b());
      if (localbeok != null) {
        localbeok.a(paramViewHolder);
      }
    }
  }
  
  public void a(@NonNull RecyclerView.ViewHolder paramViewHolder, beno parambeno, int paramInt)
  {
    beok localbeok = a(parambeno.b());
    if (localbeok != null)
    {
      ((beon)paramViewHolder).a = parambeno;
      localbeok.a(paramViewHolder, parambeno, paramInt);
    }
  }
  
  public void a(SparseArray<beok> paramSparseArray)
  {
    this.a = paramSparseArray;
  }
  
  public void a(beno parambeno)
  {
    beok localbeok = a(parambeno.b());
    if (localbeok != null) {
      localbeok.b(parambeno);
    }
  }
  
  public void a(beny parambeny)
  {
    beok localbeok = a(parambeny.b());
    if ((localbeok != null) && ((localbeok instanceof bepd))) {
      ((bepd)localbeok).a(parambeny);
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (beon)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      beok localbeok = a(paramViewHolder.a.b());
      if (localbeok != null) {
        localbeok.b(paramViewHolder);
      }
    }
  }
  
  public void b(beno parambeno)
  {
    beok localbeok = a(parambeno.b());
    if (localbeok != null) {
      localbeok.c(parambeno);
    }
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (beon)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      beok localbeok = a(paramViewHolder.a.b());
      if (localbeok != null) {
        localbeok.c(paramViewHolder);
      }
    }
  }
  
  public void c(beno parambeno)
  {
    beok localbeok = a(parambeno.b());
    if (localbeok != null) {
      localbeok.d(parambeno);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beom
 * JD-Core Version:    0.7.0.1
 */