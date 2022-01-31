import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class birr
  extends bird
{
  public int c;
  
  public birr(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramString, paramInt2);
    this.c = paramInt3;
  }
  
  @NonNull
  public bire a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new birs(this, paramContext, paramViewGroup);
  }
  
  @NonNull
  public Class<? extends bire> a()
  {
    return birs.class;
  }
  
  public void a(int paramInt)
  {
    urk.a("WeatherFilterData", "updateWeather:%s", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birr
 * JD-Core Version:    0.7.0.1
 */