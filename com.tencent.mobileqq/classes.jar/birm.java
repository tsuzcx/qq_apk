import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class birm
  extends bird
{
  public String c;
  
  public birm(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString, paramInt2);
  }
  
  @NonNull
  public bire a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new biro(this, paramContext, paramViewGroup, null);
  }
  
  @NonNull
  public Class<? extends bire> a()
  {
    return biro.class;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birm
 * JD-Core Version:    0.7.0.1
 */