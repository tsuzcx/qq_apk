import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bdbz
{
  public static bdcc a;
  public static bdcd a;
  public static bdcc b;
  public static bdcd b;
  public static bdcc c = new bdcc(7.82D);
  public static bdcc d = new bdcc(0.0D);
  public bdcf a;
  
  static
  {
    jdField_a_of_type_Bdcd = new bdca();
    jdField_b_of_type_Bdcd = new bdcb();
    jdField_a_of_type_Bdcc = new bdcc(16.27D);
    jdField_b_of_type_Bdcc = new bdcc(11.34D);
  }
  
  public static bdcf a(List<bdce> paramList, bdcd parambdcd)
  {
    paramList = new bdcf(null, paramList);
    a(paramList, parambdcd, d, 0);
    return paramList;
  }
  
  static void a(bdcf parambdcf, bdcd parambdcd, bdcc parambdcc, int paramInt)
  {
    parambdcf.jdField_a_of_type_JavaUtilList.size();
    int i = ((bdce)parambdcf.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ArrayOfInt.length;
    i = bdce.jdField_a_of_type_Int;
    Object localObject1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
    int k = 0;
    int m = 0;
    i = 0;
    if (i < parambdcf.jdField_a_of_type_JavaUtilList.size())
    {
      if (((bdce)parambdcf.jdField_a_of_type_JavaUtilList.get(i)).b == 1) {
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
    if (i < parambdcf.b)
    {
      int n = bdce.jdField_a_of_type_Int;
      localObject2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, 2 });
      localObject3 = parambdcf.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        bdce localbdce = (bdce)((Iterator)localObject3).next();
        if (localbdce.b == 1)
        {
          localbdce = localObject2[localbdce.jdField_a_of_type_ArrayOfInt[i]];
          localbdce[1] += 1;
        }
        else
        {
          localbdce = localObject2[localbdce.jdField_a_of_type_ArrayOfInt[i]];
          localbdce[0] += 1;
        }
      }
      double d2 = parambdcd.a(k, m);
      n = 0;
      while (n < bdce.jdField_a_of_type_Int)
      {
        d2 -= 1.0D * (localObject2[n][0] + localObject2[n][1]) / (k + m) * parambdcd.a(localObject2[n][0], localObject2[n][1]);
        n += 1;
      }
      if (d2 <= d1) {
        break label633;
      }
      j = 0;
      while (j < bdce.jdField_a_of_type_Int)
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
      if ((d1 > 1.0E-010D) && (parambdcc.a((int[][])localObject1)))
      {
        parambdcf.jdField_a_of_type_Int = j;
        localObject1 = new ArrayList();
        i = 0;
        while (i < bdce.jdField_a_of_type_Int)
        {
          ((ArrayList)localObject1).add(new ArrayList());
          i += 1;
        }
        localObject2 = parambdcf.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bdce)((Iterator)localObject2).next();
          ((ArrayList)((ArrayList)localObject1).get(localObject3.jdField_a_of_type_ArrayOfInt[j])).add(localObject3);
        }
        i = 0;
        while (i < bdce.jdField_a_of_type_Int)
        {
          if (((j != 16) || (i != 2)) || (((ArrayList)((ArrayList)localObject1).get(i)).size() > 0))
          {
            parambdcf.jdField_a_of_type_ArrayOfBdcf[i] = new bdcf(parambdcf, (List)((ArrayList)localObject1).get(i));
            a(parambdcf.jdField_a_of_type_ArrayOfBdcf[i], parambdcd, parambdcc, paramInt + 1);
          }
          i += 1;
        }
      }
      return;
    }
  }
  
  public void a(List<bdce> paramList)
  {
    this.jdField_a_of_type_Bdcf = a(paramList, jdField_a_of_type_Bdcd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbz
 * JD-Core Version:    0.7.0.1
 */