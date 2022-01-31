import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class birp
  extends bird
{
  public final int c;
  
  public birp(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3, paramString, paramInt1);
    this.c = paramInt2;
  }
  
  @NonNull
  public bire a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new birq(this, paramContext, paramViewGroup);
  }
  
  @NonNull
  public Class<? extends bire> a()
  {
    return birq.class;
  }
  
  public String toString()
  {
    switch (this.a)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return "";
    case 0: 
      return "normal";
    case 3: 
      return "slow";
    case 2: 
      return "fast";
    case 9: 
      return "very slow";
    case 8: 
      return "little fast";
    }
    return "rewind";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birp
 * JD-Core Version:    0.7.0.1
 */