import android.support.annotation.NonNull;
import java.util.List;

public class bmtx
{
  public static bmrm a(String paramString)
  {
    return new bmta(Integer.valueOf(paramString).intValue());
  }
  
  public static bmrm a(String paramString1, @NonNull String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    bnle localbnle = ((bmua)bmql.a(4)).a(paramString2);
    if ((localbnle instanceof bnln)) {
      return new bmtu((bnln)localbnle, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localbnle instanceof bnlk)) {
      return new bmtt((bnlk)localbnle, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localbnle instanceof bnlf)) {
      return new bmtq((bnlf)localbnle, paramString1, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    return null;
  }
  
  public static bmrm a(@NonNull String paramString, @NonNull List<String> paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new bmvh(paramString, paramList, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static bmrm b(String paramString)
  {
    return new bmty(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtx
 * JD-Core Version:    0.7.0.1
 */