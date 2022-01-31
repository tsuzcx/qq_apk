import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axiv
{
  public static axiy a;
  public static axiz a;
  public static axiy b;
  public static axiz b;
  public static axiy c = new axiy(7.82D);
  public static axiy d = new axiy(0.0D);
  public axjb a;
  
  static
  {
    jdField_a_of_type_Axiz = new axiw();
    jdField_b_of_type_Axiz = new axix();
    jdField_a_of_type_Axiy = new axiy(16.27D);
    jdField_b_of_type_Axiy = new axiy(11.34D);
  }
  
  public static axjb a(List<axja> paramList, axiz paramaxiz)
  {
    paramList = new axjb(null, paramList);
    a(paramList, paramaxiz, d, 0);
    return paramList;
  }
  
  static void a(axjb paramaxjb, axiz paramaxiz, axiy paramaxiy, int paramInt)
  {
    paramaxjb.jdField_a_of_type_JavaUtilList.size();
    int i = ((axja)paramaxjb.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ArrayOfInt.length;
    i = axja.jdField_a_of_type_Int;
    Object localObject1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
    int k = 0;
    int m = 0;
    i = 0;
    if (i < paramaxjb.jdField_a_of_type_JavaUtilList.size())
    {
      if (((axja)paramaxjb.jdField_a_of_type_JavaUtilList.get(i)).b == 1) {
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
    if (i < paramaxjb.b)
    {
      int n = axja.jdField_a_of_type_Int;
      localObject2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, 2 });
      localObject3 = paramaxjb.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        axja localaxja = (axja)((Iterator)localObject3).next();
        if (localaxja.b == 1)
        {
          localaxja = localObject2[localaxja.jdField_a_of_type_ArrayOfInt[i]];
          localaxja[1] += 1;
        }
        else
        {
          localaxja = localObject2[localaxja.jdField_a_of_type_ArrayOfInt[i]];
          localaxja[0] += 1;
        }
      }
      double d2 = paramaxiz.a(k, m);
      n = 0;
      while (n < axja.jdField_a_of_type_Int)
      {
        d2 -= 1.0D * (localObject2[n][0] + localObject2[n][1]) / (k + m) * paramaxiz.a(localObject2[n][0], localObject2[n][1]);
        n += 1;
      }
      if (d2 <= d1) {
        break label633;
      }
      j = 0;
      while (j < axja.jdField_a_of_type_Int)
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
      if ((d1 > 1.0E-010D) && (paramaxiy.a((int[][])localObject1)))
      {
        paramaxjb.jdField_a_of_type_Int = j;
        localObject1 = new ArrayList();
        i = 0;
        while (i < axja.jdField_a_of_type_Int)
        {
          ((ArrayList)localObject1).add(new ArrayList());
          i += 1;
        }
        localObject2 = paramaxjb.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (axja)((Iterator)localObject2).next();
          ((ArrayList)((ArrayList)localObject1).get(localObject3.jdField_a_of_type_ArrayOfInt[j])).add(localObject3);
        }
        i = 0;
        while (i < axja.jdField_a_of_type_Int)
        {
          if (((j != 16) || (i != 2)) || (((ArrayList)((ArrayList)localObject1).get(i)).size() > 0))
          {
            paramaxjb.jdField_a_of_type_ArrayOfAxjb[i] = new axjb(paramaxjb, (List)((ArrayList)localObject1).get(i));
            a(paramaxjb.jdField_a_of_type_ArrayOfAxjb[i], paramaxiz, paramaxiy, paramInt + 1);
          }
          i += 1;
        }
      }
      return;
    }
  }
  
  public void a(List<axja> paramList)
  {
    this.jdField_a_of_type_Axjb = a(paramList, jdField_a_of_type_Axiz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axiv
 * JD-Core Version:    0.7.0.1
 */