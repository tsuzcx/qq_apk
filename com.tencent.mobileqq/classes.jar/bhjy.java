import android.support.annotation.NonNull;
import java.util.List;

public class bhjy
{
  public static bhgn a(String paramString)
  {
    return new bhii(Integer.valueOf(paramString).intValue());
  }
  
  public static bhgn a(String paramString1, @NonNull String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    bion localbion = ((bhkc)bhfm.a(4)).a(paramString2);
    if ((localbion instanceof biox)) {
      return new bhjv((biox)localbion, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localbion instanceof biou)) {
      return new bhju((biou)localbion, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localbion instanceof bioo)) {
      return new bhjr((bioo)localbion, paramString1, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    return null;
  }
  
  public static bhgn a(@NonNull String paramString, @NonNull List<String> paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new bhlw(paramString, paramList, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static bhgn b(String paramString)
  {
    return new bhjz(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhjy
 * JD-Core Version:    0.7.0.1
 */