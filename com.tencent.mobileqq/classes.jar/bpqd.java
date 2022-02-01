import android.support.annotation.NonNull;
import java.util.List;

public class bpqd
{
  public static bpmr a(String paramString)
  {
    return new bpon(Integer.valueOf(paramString).intValue());
  }
  
  public static bpmr a(String paramString1, @NonNull String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    bqow localbqow = ((bpqh)bplq.a(4)).a(paramString2);
    if ((localbqow instanceof bqpg)) {
      return new bpqa((bqpg)localbqow, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localbqow instanceof bqpd)) {
      return new bppz((bqpd)localbqow, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    if ((localbqow instanceof bqox)) {
      return new bppw((bqox)localbqow, paramString1, paramString2, paramString3, paramFloat1, paramFloat2, paramFloat3);
    }
    return null;
  }
  
  public static bpmr a(@NonNull String paramString, @NonNull List<String> paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new bpsb(paramString, paramList, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static bpmr b(String paramString)
  {
    return new bpqe(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqd
 * JD-Core Version:    0.7.0.1
 */