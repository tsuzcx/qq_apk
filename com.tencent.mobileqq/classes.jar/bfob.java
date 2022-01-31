import android.support.annotation.NonNull;
import com.tencent.util.Pair;
import cooperation.qqreader.net.BusinessTask;

public final class bfob
{
  public static final Pair<Integer, Integer> a = new Pair(Integer.valueOf(1154), Integer.valueOf(1));
  public static final Pair<Integer, Integer> b = new Pair(Integer.valueOf(1201), Integer.valueOf(1));
  
  public static void a(@NonNull Pair<Integer, Integer> paramPair, @NonNull bfmg parambfmg)
  {
    a(paramPair, parambfmg, false);
  }
  
  public static void a(@NonNull Pair<Integer, Integer> paramPair, @NonNull bfmg parambfmg, boolean paramBoolean)
  {
    paramPair = new BusinessTask("ZzConfigDataTask", paramPair);
    paramPair.a(parambfmg, paramBoolean);
    paramPair.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfob
 * JD-Core Version:    0.7.0.1
 */