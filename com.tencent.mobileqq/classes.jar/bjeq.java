import android.support.annotation.NonNull;
import java.util.List;

public class bjeq
{
  public static bjbf a(String paramString)
  {
    return new bjda(Integer.valueOf(paramString).intValue());
  }
  
  public static bjbf a(String paramString1, @NonNull String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    bkfi localbkfi = ((bjeu)bjae.a(4)).a(paramString2);
    if ((localbkfi instanceof bkfs)) {
      return new bjen((bkfs)localbkfi, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localbkfi instanceof bkfp)) {
      return new bjem((bkfp)localbkfi, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localbkfi instanceof bkfj)) {
      return new bjej((bkfj)localbkfi, paramString1, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    return null;
  }
  
  public static bjbf a(@NonNull String paramString, @NonNull List<String> paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new bjgo(paramString, paramList, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static bjbf b(String paramString)
  {
    return new bjer(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjeq
 * JD-Core Version:    0.7.0.1
 */