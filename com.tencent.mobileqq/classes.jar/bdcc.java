import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdcc
{
  public static bdcf a;
  public static bdcg a;
  public static bdcf b;
  public static bdcg b;
  public static bdcf c = new bdcf(7.82D);
  public static bdcf d = new bdcf(0.0D);
  public bdci a;
  
  static
  {
    jdField_a_of_type_Bdcg = new bdcd();
    jdField_b_of_type_Bdcg = new bdce();
    jdField_a_of_type_Bdcf = new bdcf(16.27D);
    jdField_b_of_type_Bdcf = new bdcf(11.34D);
  }
  
  public static bdci a(List<bdch> paramList, bdcg parambdcg)
  {
    paramList = new bdci(null, paramList);
    a(paramList, parambdcg, d, 0);
    return paramList;
  }
  
  static void a(bdci parambdci, bdcg parambdcg, bdcf parambdcf, int paramInt)
  {
    parambdci.jdField_a_of_type_JavaUtilList.size();
    int i = ((bdch)parambdci.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ArrayOfInt.length;
    i = bdch.jdField_a_of_type_Int;
    Object localObject1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
    int k = 0;
    int m = 0;
    i = 0;
    if (i < parambdci.jdField_a_of_type_JavaUtilList.size())
    {
      if (((bdch)parambdci.jdField_a_of_type_JavaUtilList.get(i)).b == 1) {
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
    if (i < parambdci.b)
    {
      int n = bdch.jdField_a_of_type_Int;
      localObject2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, 2 });
      localObject3 = parambdci.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        bdch localbdch = (bdch)((Iterator)localObject3).next();
        if (localbdch.b == 1)
        {
          localbdch = localObject2[localbdch.jdField_a_of_type_ArrayOfInt[i]];
          localbdch[1] += 1;
        }
        else
        {
          localbdch = localObject2[localbdch.jdField_a_of_type_ArrayOfInt[i]];
          localbdch[0] += 1;
        }
      }
      double d2 = parambdcg.a(k, m);
      n = 0;
      while (n < bdch.jdField_a_of_type_Int)
      {
        d2 -= 1.0D * (localObject2[n][0] + localObject2[n][1]) / (k + m) * parambdcg.a(localObject2[n][0], localObject2[n][1]);
        n += 1;
      }
      if (d2 <= d1) {
        break label633;
      }
      j = 0;
      while (j < bdch.jdField_a_of_type_Int)
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
      if ((d1 > 1.0E-010D) && (parambdcf.a((int[][])localObject1)))
      {
        parambdci.jdField_a_of_type_Int = j;
        localObject1 = new ArrayList();
        i = 0;
        while (i < bdch.jdField_a_of_type_Int)
        {
          ((ArrayList)localObject1).add(new ArrayList());
          i += 1;
        }
        localObject2 = parambdci.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bdch)((Iterator)localObject2).next();
          ((ArrayList)((ArrayList)localObject1).get(localObject3.jdField_a_of_type_ArrayOfInt[j])).add(localObject3);
        }
        i = 0;
        while (i < bdch.jdField_a_of_type_Int)
        {
          if (((j != 16) || (i != 2)) || (((ArrayList)((ArrayList)localObject1).get(i)).size() > 0))
          {
            parambdci.jdField_a_of_type_ArrayOfBdci[i] = new bdci(parambdci, (List)((ArrayList)localObject1).get(i));
            a(parambdci.jdField_a_of_type_ArrayOfBdci[i], parambdcg, parambdcf, paramInt + 1);
          }
          i += 1;
        }
      }
      return;
    }
  }
  
  public void a(List<bdch> paramList)
  {
    this.jdField_a_of_type_Bdci = a(paramList, jdField_a_of_type_Bdcg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdcc
 * JD-Core Version:    0.7.0.1
 */