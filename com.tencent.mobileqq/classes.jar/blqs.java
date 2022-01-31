import android.support.annotation.NonNull;
import java.util.List;

public class blqs
{
  public static blng a(String paramString)
  {
    return new blpc(Integer.valueOf(paramString).intValue());
  }
  
  public static blng a(String paramString1, @NonNull String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    bmrj localbmrj = ((blqw)blmf.a(4)).a(paramString2);
    if ((localbmrj instanceof bmrt)) {
      return new blqp((bmrt)localbmrj, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localbmrj instanceof bmrq)) {
      return new blqo((bmrq)localbmrj, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localbmrj instanceof bmrk)) {
      return new blql((bmrk)localbmrj, paramString1, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    return null;
  }
  
  public static blng a(@NonNull String paramString, @NonNull List<String> paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new blsq(paramString, paramList, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static blng b(String paramString)
  {
    return new blqt(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqs
 * JD-Core Version:    0.7.0.1
 */