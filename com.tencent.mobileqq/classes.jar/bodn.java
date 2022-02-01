import android.text.TextUtils;
import android.util.LruCache;
import java.util.ArrayList;

public class bodn
{
  private static LruCache<String, ArrayList<Double>> jdField_a_of_type_AndroidUtilLruCache = new LruCache(10);
  private static ArrayList<Double> jdField_a_of_type_JavaUtilArrayList;
  
  private static double a()
  {
    double d2 = Math.random();
    double d1 = d2;
    if (d2 < 0.1D) {
      d1 = d2 + 0.1000000014901161D;
    }
    return d1;
  }
  
  static double a(int paramInt)
  {
    double d;
    if (jdField_a_of_type_JavaUtilArrayList == null)
    {
      bnrh.a("AEEditorMusicWaveRandomGenerator", "obtainRandomValue() mRandoms == null.");
      d = a();
    }
    for (;;)
    {
      return d;
      if (paramInt == jdField_a_of_type_JavaUtilArrayList.size())
      {
        bnrh.a("AEEditorMusicWaveRandomGenerator", "obtainRandomValue() index == mRandoms.size().");
        d = a();
        jdField_a_of_type_JavaUtilArrayList.add(paramInt, Double.valueOf(d));
        return d;
      }
      if (paramInt < 0)
      {
        bnrh.a("AEEditorMusicWaveRandomGenerator", "obtainRandomValue() index < 0.");
        return a();
      }
      if (paramInt <= jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      bnrh.a("AEEditorMusicWaveRandomGenerator", "obtainRandomValue() index > mRandoms.size().");
      d = a();
      int i = jdField_a_of_type_JavaUtilArrayList.size();
      while (i <= paramInt)
      {
        d = a();
        jdField_a_of_type_JavaUtilArrayList.add(i, Double.valueOf(d));
        i += 1;
      }
    }
    return ((Double)jdField_a_of_type_JavaUtilArrayList.get(paramInt)).doubleValue();
  }
  
  static void a(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      if ((jdField_a_of_type_AndroidUtilLruCache != null) && (!TextUtils.isEmpty(paramString2)) && (jdField_a_of_type_AndroidUtilLruCache.get(paramString2) != null))
      {
        jdField_a_of_type_JavaUtilArrayList = (ArrayList)jdField_a_of_type_AndroidUtilLruCache.get(paramString2);
        return;
      }
      int i = Math.min(paramInt, 10000);
      paramString1 = new ArrayList();
      paramInt = 0;
      while (paramInt < i)
      {
        paramString1.add(Double.valueOf(a()));
        paramInt += 1;
      }
      if (jdField_a_of_type_AndroidUtilLruCache != null) {
        jdField_a_of_type_AndroidUtilLruCache.put(paramString2, paramString1);
      }
      jdField_a_of_type_JavaUtilArrayList = paramString1;
      return;
      paramString2 = paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bodn
 * JD-Core Version:    0.7.0.1
 */