import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bcjk
{
  public static bcjn a;
  public static bcjo a;
  public static bcjn b;
  public static bcjo b;
  public static bcjn c = new bcjn(7.82D);
  public static bcjn d = new bcjn(0.0D);
  public bcjq a;
  
  static
  {
    jdField_a_of_type_Bcjo = new bcjl();
    jdField_b_of_type_Bcjo = new bcjm();
    jdField_a_of_type_Bcjn = new bcjn(16.27D);
    jdField_b_of_type_Bcjn = new bcjn(11.34D);
  }
  
  public static bcjq a(List<bcjp> paramList, bcjo parambcjo)
  {
    paramList = new bcjq(null, paramList);
    a(paramList, parambcjo, d, 0);
    return paramList;
  }
  
  static void a(bcjq parambcjq, bcjo parambcjo, bcjn parambcjn, int paramInt)
  {
    parambcjq.jdField_a_of_type_JavaUtilList.size();
    int i = ((bcjp)parambcjq.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ArrayOfInt.length;
    i = bcjp.jdField_a_of_type_Int;
    Object localObject1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
    int k = 0;
    int m = 0;
    i = 0;
    if (i < parambcjq.jdField_a_of_type_JavaUtilList.size())
    {
      if (((bcjp)parambcjq.jdField_a_of_type_JavaUtilList.get(i)).b == 1) {
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
    if (i < parambcjq.b)
    {
      int n = bcjp.jdField_a_of_type_Int;
      localObject2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, 2 });
      localObject3 = parambcjq.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        bcjp localbcjp = (bcjp)((Iterator)localObject3).next();
        if (localbcjp.b == 1)
        {
          localbcjp = localObject2[localbcjp.jdField_a_of_type_ArrayOfInt[i]];
          localbcjp[1] += 1;
        }
        else
        {
          localbcjp = localObject2[localbcjp.jdField_a_of_type_ArrayOfInt[i]];
          localbcjp[0] += 1;
        }
      }
      double d2 = parambcjo.a(k, m);
      n = 0;
      while (n < bcjp.jdField_a_of_type_Int)
      {
        d2 -= 1.0D * (localObject2[n][0] + localObject2[n][1]) / (k + m) * parambcjo.a(localObject2[n][0], localObject2[n][1]);
        n += 1;
      }
      if (d2 <= d1) {
        break label633;
      }
      j = 0;
      while (j < bcjp.jdField_a_of_type_Int)
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
      if ((d1 > 1.0E-010D) && (parambcjn.a((int[][])localObject1)))
      {
        parambcjq.jdField_a_of_type_Int = j;
        localObject1 = new ArrayList();
        i = 0;
        while (i < bcjp.jdField_a_of_type_Int)
        {
          ((ArrayList)localObject1).add(new ArrayList());
          i += 1;
        }
        localObject2 = parambcjq.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bcjp)((Iterator)localObject2).next();
          ((ArrayList)((ArrayList)localObject1).get(localObject3.jdField_a_of_type_ArrayOfInt[j])).add(localObject3);
        }
        i = 0;
        while (i < bcjp.jdField_a_of_type_Int)
        {
          if (((j != 16) || (i != 2)) || (((ArrayList)((ArrayList)localObject1).get(i)).size() > 0))
          {
            parambcjq.jdField_a_of_type_ArrayOfBcjq[i] = new bcjq(parambcjq, (List)((ArrayList)localObject1).get(i));
            a(parambcjq.jdField_a_of_type_ArrayOfBcjq[i], parambcjo, parambcjn, paramInt + 1);
          }
          i += 1;
        }
      }
      return;
    }
  }
  
  public void a(List<bcjp> paramList)
  {
    this.jdField_a_of_type_Bcjq = a(paramList, jdField_a_of_type_Bcjo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjk
 * JD-Core Version:    0.7.0.1
 */