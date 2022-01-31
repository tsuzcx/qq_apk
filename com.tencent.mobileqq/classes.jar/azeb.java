import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class azeb
{
  public static azee a;
  public static azef a;
  public static azee b;
  public static azef b;
  public static azee c = new azee(7.82D);
  public static azee d = new azee(0.0D);
  public azeh a;
  
  static
  {
    jdField_a_of_type_Azef = new azec();
    jdField_b_of_type_Azef = new azed();
    jdField_a_of_type_Azee = new azee(16.27D);
    jdField_b_of_type_Azee = new azee(11.34D);
  }
  
  public static azeh a(List<azeg> paramList, azef paramazef)
  {
    paramList = new azeh(null, paramList);
    a(paramList, paramazef, d, 0);
    return paramList;
  }
  
  static void a(azeh paramazeh, azef paramazef, azee paramazee, int paramInt)
  {
    paramazeh.jdField_a_of_type_JavaUtilList.size();
    int i = ((azeg)paramazeh.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ArrayOfInt.length;
    i = azeg.jdField_a_of_type_Int;
    Object localObject1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
    int k = 0;
    int m = 0;
    i = 0;
    if (i < paramazeh.jdField_a_of_type_JavaUtilList.size())
    {
      if (((azeg)paramazeh.jdField_a_of_type_JavaUtilList.get(i)).b == 1) {
        k += 1;
      }
      for (;;)
      {
        i += 1;
        break;
        m += 1;
      }
    }
    double d1 = -100000.0D;
    int j = -1;
    i = 0;
    Object localObject2;
    Object localObject3;
    if (i < paramazeh.b)
    {
      int n = azeg.jdField_a_of_type_Int;
      localObject2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, 2 });
      localObject3 = paramazeh.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        azeg localazeg = (azeg)((Iterator)localObject3).next();
        if (localazeg.b == 1)
        {
          localazeg = localObject2[localazeg.jdField_a_of_type_ArrayOfInt[i]];
          localazeg[1] += 1;
        }
        else
        {
          localazeg = localObject2[localazeg.jdField_a_of_type_ArrayOfInt[i]];
          localazeg[0] += 1;
        }
      }
      double d2 = paramazef.a(k, m);
      n = 0;
      while (n < azeg.jdField_a_of_type_Int)
      {
        d2 -= 1.0D * (localObject2[n][0] + localObject2[n][1]) / (k + m) * paramazef.a(localObject2[n][0], localObject2[n][1]);
        n += 1;
      }
      if (d2 <= d1) {
        break label633;
      }
      j = 0;
      while (j < azeg.jdField_a_of_type_Int)
      {
        localObject1[j][0] = localObject2[j][0];
        localObject1[j][1] = localObject2[j][1];
        j += 1;
      }
      j = i;
      d1 = d2;
    }
    label633:
    for (;;)
    {
      i += 1;
      break;
      if ((d1 > 1.0E-010D) && (paramazee.a((int[][])localObject1)))
      {
        paramazeh.jdField_a_of_type_Int = j;
        localObject1 = new ArrayList();
        i = 0;
        while (i < azeg.jdField_a_of_type_Int)
        {
          ((ArrayList)localObject1).add(new ArrayList());
          i += 1;
        }
        localObject2 = paramazeh.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (azeg)((Iterator)localObject2).next();
          ((ArrayList)((ArrayList)localObject1).get(localObject3.jdField_a_of_type_ArrayOfInt[j])).add(localObject3);
        }
        i = 0;
        while (i < azeg.jdField_a_of_type_Int)
        {
          if (((j != 16) || (i != 2)) || (((ArrayList)((ArrayList)localObject1).get(i)).size() > 0))
          {
            paramazeh.jdField_a_of_type_ArrayOfAzeh[i] = new azeh(paramazeh, (List)((ArrayList)localObject1).get(i));
            a(paramazeh.jdField_a_of_type_ArrayOfAzeh[i], paramazef, paramazee, paramInt + 1);
          }
          i += 1;
        }
      }
      return;
    }
  }
  
  public void a(List<azeg> paramList)
  {
    this.jdField_a_of_type_Azeh = a(paramList, jdField_a_of_type_Azef);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azeb
 * JD-Core Version:    0.7.0.1
 */