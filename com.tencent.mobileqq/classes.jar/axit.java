import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axit
{
  public static axiw a;
  public static axix a;
  public static axiw b;
  public static axix b;
  public static axiw c = new axiw(7.82D);
  public static axiw d = new axiw(0.0D);
  public axiz a;
  
  static
  {
    jdField_a_of_type_Axix = new axiu();
    jdField_b_of_type_Axix = new axiv();
    jdField_a_of_type_Axiw = new axiw(16.27D);
    jdField_b_of_type_Axiw = new axiw(11.34D);
  }
  
  public static axiz a(List<axiy> paramList, axix paramaxix)
  {
    paramList = new axiz(null, paramList);
    a(paramList, paramaxix, d, 0);
    return paramList;
  }
  
  static void a(axiz paramaxiz, axix paramaxix, axiw paramaxiw, int paramInt)
  {
    paramaxiz.jdField_a_of_type_JavaUtilList.size();
    int i = ((axiy)paramaxiz.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ArrayOfInt.length;
    i = axiy.jdField_a_of_type_Int;
    Object localObject1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
    int k = 0;
    int m = 0;
    i = 0;
    if (i < paramaxiz.jdField_a_of_type_JavaUtilList.size())
    {
      if (((axiy)paramaxiz.jdField_a_of_type_JavaUtilList.get(i)).b == 1) {
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
    if (i < paramaxiz.b)
    {
      int n = axiy.jdField_a_of_type_Int;
      localObject2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, 2 });
      localObject3 = paramaxiz.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        axiy localaxiy = (axiy)((Iterator)localObject3).next();
        if (localaxiy.b == 1)
        {
          localaxiy = localObject2[localaxiy.jdField_a_of_type_ArrayOfInt[i]];
          localaxiy[1] += 1;
        }
        else
        {
          localaxiy = localObject2[localaxiy.jdField_a_of_type_ArrayOfInt[i]];
          localaxiy[0] += 1;
        }
      }
      double d2 = paramaxix.a(k, m);
      n = 0;
      while (n < axiy.jdField_a_of_type_Int)
      {
        d2 -= 1.0D * (localObject2[n][0] + localObject2[n][1]) / (k + m) * paramaxix.a(localObject2[n][0], localObject2[n][1]);
        n += 1;
      }
      if (d2 <= d1) {
        break label633;
      }
      j = 0;
      while (j < axiy.jdField_a_of_type_Int)
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
      if ((d1 > 1.0E-010D) && (paramaxiw.a((int[][])localObject1)))
      {
        paramaxiz.jdField_a_of_type_Int = j;
        localObject1 = new ArrayList();
        i = 0;
        while (i < axiy.jdField_a_of_type_Int)
        {
          ((ArrayList)localObject1).add(new ArrayList());
          i += 1;
        }
        localObject2 = paramaxiz.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (axiy)((Iterator)localObject2).next();
          ((ArrayList)((ArrayList)localObject1).get(localObject3.jdField_a_of_type_ArrayOfInt[j])).add(localObject3);
        }
        i = 0;
        while (i < axiy.jdField_a_of_type_Int)
        {
          if (((j != 16) || (i != 2)) || (((ArrayList)((ArrayList)localObject1).get(i)).size() > 0))
          {
            paramaxiz.jdField_a_of_type_ArrayOfAxiz[i] = new axiz(paramaxiz, (List)((ArrayList)localObject1).get(i));
            a(paramaxiz.jdField_a_of_type_ArrayOfAxiz[i], paramaxix, paramaxiw, paramInt + 1);
          }
          i += 1;
        }
      }
      return;
    }
  }
  
  public void a(List<axiy> paramList)
  {
    this.jdField_a_of_type_Axiz = a(paramList, jdField_a_of_type_Axix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axit
 * JD-Core Version:    0.7.0.1
 */