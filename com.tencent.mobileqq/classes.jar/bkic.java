import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class bkic
  extends bkhy
{
  public String c;
  
  public bkic(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString, paramInt2);
  }
  
  @NonNull
  public bkhz a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new bkie(this, paramContext, paramViewGroup, null);
  }
  
  @NonNull
  public Class<? extends bkhz> a()
  {
    return bkie.class;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkic
 * JD-Core Version:    0.7.0.1
 */