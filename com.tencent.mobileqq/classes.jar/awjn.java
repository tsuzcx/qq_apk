import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class awjn
{
  public static awjq a;
  public static awjr a;
  public static awjq b;
  public static awjr b;
  public static awjq c = new awjq(7.82D);
  public static awjq d = new awjq(0.0D);
  public awjt a;
  
  static
  {
    jdField_a_of_type_Awjr = new awjo();
    jdField_b_of_type_Awjr = new awjp();
    jdField_a_of_type_Awjq = new awjq(16.27D);
    jdField_b_of_type_Awjq = new awjq(11.34D);
  }
  
  public static awjt a(List<awjs> paramList, awjr paramawjr)
  {
    paramList = new awjt(null, paramList);
    a(paramList, paramawjr, d, 0);
    return paramList;
  }
  
  static void a(awjt paramawjt, awjr paramawjr, awjq paramawjq, int paramInt)
  {
    paramawjt.jdField_a_of_type_JavaUtilList.size();
    int i = ((awjs)paramawjt.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ArrayOfInt.length;
    i = awjs.jdField_a_of_type_Int;
    Object localObject1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
    int k = 0;
    int m = 0;
    i = 0;
    if (i < paramawjt.jdField_a_of_type_JavaUtilList.size())
    {
      if (((awjs)paramawjt.jdField_a_of_type_JavaUtilList.get(i)).b == 1) {
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
    if (i < paramawjt.b)
    {
      int n = awjs.jdField_a_of_type_Int;
      localObject2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, 2 });
      localObject3 = paramawjt.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        awjs localawjs = (awjs)((Iterator)localObject3).next();
        if (localawjs.b == 1)
        {
          localawjs = localObject2[localawjs.jdField_a_of_type_ArrayOfInt[i]];
          localawjs[1] += 1;
        }
        else
        {
          localawjs = localObject2[localawjs.jdField_a_of_type_ArrayOfInt[i]];
          localawjs[0] += 1;
        }
      }
      double d2 = paramawjr.a(k, m);
      n = 0;
      while (n < awjs.jdField_a_of_type_Int)
      {
        d2 -= 1.0D * (localObject2[n][0] + localObject2[n][1]) / (k + m) * paramawjr.a(localObject2[n][0], localObject2[n][1]);
        n += 1;
      }
      if (d2 <= d1) {
        break label633;
      }
      j = 0;
      while (j < awjs.jdField_a_of_type_Int)
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
      if ((d1 > 1.0E-010D) && (paramawjq.a((int[][])localObject1)))
      {
        paramawjt.jdField_a_of_type_Int = j;
        localObject1 = new ArrayList();
        i = 0;
        while (i < awjs.jdField_a_of_type_Int)
        {
          ((ArrayList)localObject1).add(new ArrayList());
          i += 1;
        }
        localObject2 = paramawjt.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (awjs)((Iterator)localObject2).next();
          ((ArrayList)((ArrayList)localObject1).get(localObject3.jdField_a_of_type_ArrayOfInt[j])).add(localObject3);
        }
        i = 0;
        while (i < awjs.jdField_a_of_type_Int)
        {
          if (((j != 16) || (i != 2)) || (((ArrayList)((ArrayList)localObject1).get(i)).size() > 0))
          {
            paramawjt.jdField_a_of_type_ArrayOfAwjt[i] = new awjt(paramawjt, (List)((ArrayList)localObject1).get(i));
            a(paramawjt.jdField_a_of_type_ArrayOfAwjt[i], paramawjr, paramawjq, paramInt + 1);
          }
          i += 1;
        }
      }
      return;
    }
  }
  
  public void a(List<awjs> paramList)
  {
    this.jdField_a_of_type_Awjt = a(paramList, jdField_a_of_type_Awjr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awjn
 * JD-Core Version:    0.7.0.1
 */