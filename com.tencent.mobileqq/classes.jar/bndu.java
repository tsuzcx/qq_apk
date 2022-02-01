import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;

public abstract interface bndu<T extends RecyclerView.ViewHolder>
{
  public abstract void a(float paramFloat, int paramInt1, int paramInt2, @Nullable T paramT1, @Nullable T paramT2);
  
  public abstract void b(@NonNull T paramT, int paramInt);
  
  public abstract void c(@NonNull T paramT, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndu
 * JD-Core Version:    0.7.0.1
 */