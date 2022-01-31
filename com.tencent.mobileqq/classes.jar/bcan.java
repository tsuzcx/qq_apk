import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.ViewGroup;

public class bcan
{
  private SparseArray<bcal> a;
  
  @NonNull
  public RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    bcal localbcal = a(paramInt);
    if (localbcal != null) {
      return localbcal.a(paramViewGroup);
    }
    return null;
  }
  
  public bcal a(int paramInt)
  {
    return (bcal)this.a.get(paramInt);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((bcal)this.a.valueAt(i)).a();
      i += 1;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bcao)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bcal localbcal = a(paramViewHolder.a.b());
      if (localbcal != null) {
        localbcal.a(paramViewHolder);
      }
    }
  }
  
  public void a(@NonNull RecyclerView.ViewHolder paramViewHolder, bbzp parambbzp, int paramInt)
  {
    bcal localbcal = a(parambbzp.b());
    if (localbcal != null)
    {
      ((bcao)paramViewHolder).a = parambbzp;
      localbcal.a(paramViewHolder, parambbzp, paramInt);
    }
  }
  
  public void a(SparseArray<bcal> paramSparseArray)
  {
    this.a = paramSparseArray;
  }
  
  public void a(bbzp parambbzp)
  {
    bcal localbcal = a(parambbzp.b());
    if (localbcal != null) {
      localbcal.b(parambbzp);
    }
  }
  
  public void a(bbzz parambbzz)
  {
    bcal localbcal = a(parambbzz.b());
    if ((localbcal != null) && ((localbcal instanceof bcbe))) {
      ((bcbe)localbcal).a(parambbzz);
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bcao)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bcal localbcal = a(paramViewHolder.a.b());
      if (localbcal != null) {
        localbcal.b(paramViewHolder);
      }
    }
  }
  
  public void b(bbzp parambbzp)
  {
    bcal localbcal = a(parambbzp.b());
    if (localbcal != null) {
      localbcal.c(parambbzp);
    }
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (bcao)paramViewHolder;
    if (paramViewHolder.a != null)
    {
      bcal localbcal = a(paramViewHolder.a.b());
      if (localbcal != null) {
        localbcal.c(paramViewHolder);
      }
    }
  }
  
  public void c(bbzp parambbzp)
  {
    bcal localbcal = a(parambbzp.b());
    if (localbcal != null) {
      localbcal.d(parambbzp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcan
 * JD-Core Version:    0.7.0.1
 */