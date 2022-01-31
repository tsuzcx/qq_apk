import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.ViewGroup;

public class babq
{
  private SparseArray<babo> a;
  
  @NonNull
  public RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    babo localbabo = a(paramInt);
    if (localbabo != null) {
      return localbabo.a(paramViewGroup);
    }
    return null;
  }
  
  public babo a(int paramInt)
  {
    return (babo)this.a.get(paramInt);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((babo)this.a.valueAt(i)).a();
      i += 1;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (babr)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      babo localbabo = a(paramViewHolder.a.b());
      if (localbabo != null) {
        localbabo.a(paramViewHolder);
      }
    }
  }
  
  public void a(@NonNull RecyclerView.ViewHolder paramViewHolder, baas parambaas, int paramInt)
  {
    babo localbabo = a(parambaas.b());
    if (localbabo != null)
    {
      ((babr)paramViewHolder).a = parambaas;
      localbabo.a(paramViewHolder, parambaas, paramInt);
    }
  }
  
  public void a(SparseArray<babo> paramSparseArray)
  {
    this.a = paramSparseArray;
  }
  
  public void a(baas parambaas)
  {
    babo localbabo = a(parambaas.b());
    if (localbabo != null) {
      localbabo.b(parambaas);
    }
  }
  
  public void a(babc parambabc)
  {
    babo localbabo = a(parambabc.b());
    if ((localbabo != null) && ((localbabo instanceof bach))) {
      ((bach)localbabo).a(parambabc);
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (babr)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      babo localbabo = a(paramViewHolder.a.b());
      if (localbabo != null) {
        localbabo.b(paramViewHolder);
      }
    }
  }
  
  public void b(baas parambaas)
  {
    babo localbabo = a(parambaas.b());
    if (localbabo != null) {
      localbabo.c(parambaas);
    }
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (babr)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      babo localbabo = a(paramViewHolder.a.b());
      if (localbabo != null) {
        localbabo.c(paramViewHolder);
      }
    }
  }
  
  public void c(baas parambaas)
  {
    babo localbabo = a(parambaas.b());
    if (localbabo != null) {
      localbabo.d(parambaas);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     babq
 * JD-Core Version:    0.7.0.1
 */