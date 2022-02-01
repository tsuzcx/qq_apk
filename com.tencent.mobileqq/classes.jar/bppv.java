import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class bppv
  extends bppr
{
  public String c;
  
  public bppv(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString, paramInt2);
  }
  
  @NonNull
  public bpps a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new bppx(this, paramContext, paramViewGroup, null);
  }
  
  @NonNull
  public Class<? extends bpps> a()
  {
    return bppx.class;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bppv
 * JD-Core Version:    0.7.0.1
 */