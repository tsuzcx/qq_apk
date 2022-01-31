import android.support.annotation.NonNull;
import java.util.List;

public class bjfh
{
  public static bjbw a(String paramString)
  {
    return new bjdr(Integer.valueOf(paramString).intValue());
  }
  
  public static bjbw a(String paramString1, @NonNull String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    bkfz localbkfz = ((bjfl)bjav.a(4)).a(paramString2);
    if ((localbkfz instanceof bkgj)) {
      return new bjfe((bkgj)localbkfz, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localbkfz instanceof bkgg)) {
      return new bjfd((bkgg)localbkfz, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localbkfz instanceof bkga)) {
      return new bjfa((bkga)localbkfz, paramString1, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    return null;
  }
  
  public static bjbw a(@NonNull String paramString, @NonNull List<String> paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new bjhf(paramString, paramList, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static bjbw b(String paramString)
  {
    return new bjfi(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfh
 * JD-Core Version:    0.7.0.1
 */