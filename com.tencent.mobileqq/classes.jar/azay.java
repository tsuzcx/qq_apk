import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.ViewGroup;

public class azay
{
  private SparseArray<azaw> a;
  
  @NonNull
  public RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    azaw localazaw = a(paramInt);
    if (localazaw != null) {
      return localazaw.a(paramViewGroup);
    }
    return null;
  }
  
  public azaw a(int paramInt)
  {
    return (azaw)this.a.get(paramInt);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((azaw)this.a.valueAt(i)).a();
      i += 1;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (azaz)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      azaw localazaw = a(paramViewHolder.a.b());
      if (localazaw != null) {
        localazaw.a(paramViewHolder);
      }
    }
  }
  
  public void a(@NonNull RecyclerView.ViewHolder paramViewHolder, azaa paramazaa, int paramInt)
  {
    azaw localazaw = a(paramazaa.b());
    if (localazaw != null)
    {
      ((azaz)paramViewHolder).a = paramazaa;
      localazaw.a(paramViewHolder, paramazaa, paramInt);
    }
  }
  
  public void a(SparseArray<azaw> paramSparseArray)
  {
    this.a = paramSparseArray;
  }
  
  public void a(azaa paramazaa)
  {
    azaw localazaw = a(paramazaa.b());
    if (localazaw != null) {
      localazaw.b(paramazaa);
    }
  }
  
  public void a(azak paramazak)
  {
    azaw localazaw = a(paramazak.b());
    if ((localazaw != null) && ((localazaw instanceof azbp))) {
      ((azbp)localazaw).a(paramazak);
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (azaz)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      azaw localazaw = a(paramViewHolder.a.b());
      if (localazaw != null) {
        localazaw.b(paramViewHolder);
      }
    }
  }
  
  public void b(azaa paramazaa)
  {
    azaw localazaw = a(paramazaa.b());
    if (localazaw != null) {
      localazaw.c(paramazaa);
    }
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (azaz)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      azaw localazaw = a(paramViewHolder.a.b());
      if (localazaw != null) {
        localazaw.c(paramViewHolder);
      }
    }
  }
  
  public void c(azaa paramazaa)
  {
    azaw localazaw = a(paramazaa.b());
    if (localazaw != null) {
      localazaw.d(paramazaa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azay
 * JD-Core Version:    0.7.0.1
 */