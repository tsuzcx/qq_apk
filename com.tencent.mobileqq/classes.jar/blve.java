import android.support.annotation.NonNull;
import java.util.List;

public class blve
{
  public static blrs a(String paramString)
  {
    return new blto(Integer.valueOf(paramString).intValue());
  }
  
  public static blrs a(String paramString1, @NonNull String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    bmvv localbmvv = ((blvi)blqr.a(4)).a(paramString2);
    if ((localbmvv instanceof bmwf)) {
      return new blvb((bmwf)localbmvv, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localbmvv instanceof bmwc)) {
      return new blva((bmwc)localbmvv, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localbmvv instanceof bmvw)) {
      return new blux((bmvw)localbmvv, paramString1, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    return null;
  }
  
  public static blrs a(@NonNull String paramString, @NonNull List<String> paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new blxc(paramString, paramList, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static blrs b(String paramString)
  {
    return new blvf(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blve
 * JD-Core Version:    0.7.0.1
 */