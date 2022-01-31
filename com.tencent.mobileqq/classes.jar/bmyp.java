import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class bmyp
  extends bmyl
{
  public String c;
  
  public bmyp(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString, paramInt2);
  }
  
  @NonNull
  public bmym a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new bmyr(this, paramContext, paramViewGroup, null);
  }
  
  @NonNull
  public Class<? extends bmym> a()
  {
    return bmyr.class;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyp
 * JD-Core Version:    0.7.0.1
 */