import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class azik
{
  public static azin a;
  public static azio a;
  public static azin b;
  public static azio b;
  public static azin c = new azin(7.82D);
  public static azin d = new azin(0.0D);
  public aziq a;
  
  static
  {
    jdField_a_of_type_Azio = new azil();
    jdField_b_of_type_Azio = new azim();
    jdField_a_of_type_Azin = new azin(16.27D);
    jdField_b_of_type_Azin = new azin(11.34D);
  }
  
  public static aziq a(List<azip> paramList, azio paramazio)
  {
    paramList = new aziq(null, paramList);
    a(paramList, paramazio, d, 0);
    return paramList;
  }
  
  static void a(aziq paramaziq, azio paramazio, azin paramazin, int paramInt)
  {
    paramaziq.jdField_a_of_type_JavaUtilList.size();
    int i = ((azip)paramaziq.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ArrayOfInt.length;
    i = azip.jdField_a_of_type_Int;
    Object localObject1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
    int k = 0;
    int m = 0;
    i = 0;
    if (i < paramaziq.jdField_a_of_type_JavaUtilList.size())
    {
      if (((azip)paramaziq.jdField_a_of_type_JavaUtilList.get(i)).b == 1) {
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
    if (i < paramaziq.b)
    {
      int n = azip.jdField_a_of_type_Int;
      localObject2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, 2 });
      localObject3 = paramaziq.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        azip localazip = (azip)((Iterator)localObject3).next();
        if (localazip.b == 1)
        {
          localazip = localObject2[localazip.jdField_a_of_type_ArrayOfInt[i]];
          localazip[1] += 1;
        }
        else
        {
          localazip = localObject2[localazip.jdField_a_of_type_ArrayOfInt[i]];
          localazip[0] += 1;
        }
      }
      double d2 = paramazio.a(k, m);
      n = 0;
      while (n < azip.jdField_a_of_type_Int)
      {
        d2 -= 1.0D * (localObject2[n][0] + localObject2[n][1]) / (k + m) * paramazio.a(localObject2[n][0], localObject2[n][1]);
        n += 1;
      }
      if (d2 <= d1) {
        break label633;
      }
      j = 0;
      while (j < azip.jdField_a_of_type_Int)
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
      if ((d1 > 1.0E-010D) && (paramazin.a((int[][])localObject1)))
      {
        paramaziq.jdField_a_of_type_Int = j;
        localObject1 = new ArrayList();
        i = 0;
        while (i < azip.jdField_a_of_type_Int)
        {
          ((ArrayList)localObject1).add(new ArrayList());
          i += 1;
        }
        localObject2 = paramaziq.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (azip)((Iterator)localObject2).next();
          ((ArrayList)((ArrayList)localObject1).get(localObject3.jdField_a_of_type_ArrayOfInt[j])).add(localObject3);
        }
        i = 0;
        while (i < azip.jdField_a_of_type_Int)
        {
          if (((j != 16) || (i != 2)) || (((ArrayList)((ArrayList)localObject1).get(i)).size() > 0))
          {
            paramaziq.jdField_a_of_type_ArrayOfAziq[i] = new aziq(paramaziq, (List)((ArrayList)localObject1).get(i));
            a(paramaziq.jdField_a_of_type_ArrayOfAziq[i], paramazio, paramazin, paramInt + 1);
          }
          i += 1;
        }
      }
      return;
    }
  }
  
  public void a(List<azip> paramList)
  {
    this.jdField_a_of_type_Aziq = a(paramList, jdField_a_of_type_Azio);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azik
 * JD-Core Version:    0.7.0.1
 */