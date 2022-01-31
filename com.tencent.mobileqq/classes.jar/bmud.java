import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class bmud
  extends bmtz
{
  public String c;
  
  public bmud(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString, paramInt2);
  }
  
  @NonNull
  public bmua a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new bmuf(this, paramContext, paramViewGroup, null);
  }
  
  @NonNull
  public Class<? extends bmua> a()
  {
    return bmuf.class;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmud
 * JD-Core Version:    0.7.0.1
 */