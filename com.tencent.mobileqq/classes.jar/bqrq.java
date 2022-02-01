import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class bqrq
  extends bqrm
{
  public String c;
  
  public bqrq(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString, paramInt2);
  }
  
  @NonNull
  public bqrn a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new bqrs(this, paramContext, paramViewGroup, null);
  }
  
  @NonNull
  public Class<? extends bqrn> a()
  {
    return bqrs.class;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqrq
 * JD-Core Version:    0.7.0.1
 */