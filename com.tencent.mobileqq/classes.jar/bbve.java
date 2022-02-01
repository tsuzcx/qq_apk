import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bbve
{
  public static bbvh a;
  public static bbvi a;
  public static bbvh b;
  public static bbvi b;
  public static bbvh c = new bbvh(7.82D);
  public static bbvh d = new bbvh(0.0D);
  public bbvk a;
  
  static
  {
    jdField_a_of_type_Bbvi = new bbvf();
    jdField_b_of_type_Bbvi = new bbvg();
    jdField_a_of_type_Bbvh = new bbvh(16.27D);
    jdField_b_of_type_Bbvh = new bbvh(11.34D);
  }
  
  public static bbvk a(List<bbvj> paramList, bbvi parambbvi)
  {
    paramList = new bbvk(null, paramList);
    a(paramList, parambbvi, d, 0);
    return paramList;
  }
  
  static void a(bbvk parambbvk, bbvi parambbvi, bbvh parambbvh, int paramInt)
  {
    parambbvk.jdField_a_of_type_JavaUtilList.size();
    int i = ((bbvj)parambbvk.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ArrayOfInt.length;
    i = bbvj.jdField_a_of_type_Int;
    Object localObject1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
    int k = 0;
    int m = 0;
    i = 0;
    if (i < parambbvk.jdField_a_of_type_JavaUtilList.size())
    {
      if (((bbvj)parambbvk.jdField_a_of_type_JavaUtilList.get(i)).b == 1) {
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
    if (i < parambbvk.b)
    {
      int n = bbvj.jdField_a_of_type_Int;
      localObject2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, 2 });
      localObject3 = parambbvk.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        bbvj localbbvj = (bbvj)((Iterator)localObject3).next();
        if (localbbvj.b == 1)
        {
          localbbvj = localObject2[localbbvj.jdField_a_of_type_ArrayOfInt[i]];
          localbbvj[1] += 1;
        }
        else
        {
          localbbvj = localObject2[localbbvj.jdField_a_of_type_ArrayOfInt[i]];
          localbbvj[0] += 1;
        }
      }
      double d2 = parambbvi.a(k, m);
      n = 0;
      while (n < bbvj.jdField_a_of_type_Int)
      {
        d2 -= 1.0D * (localObject2[n][0] + localObject2[n][1]) / (k + m) * parambbvi.a(localObject2[n][0], localObject2[n][1]);
        n += 1;
      }
      if (d2 <= d1) {
        break label633;
      }
      j = 0;
      while (j < bbvj.jdField_a_of_type_Int)
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
      if ((d1 > 1.0E-010D) && (parambbvh.a((int[][])localObject1)))
      {
        parambbvk.jdField_a_of_type_Int = j;
        localObject1 = new ArrayList();
        i = 0;
        while (i < bbvj.jdField_a_of_type_Int)
        {
          ((ArrayList)localObject1).add(new ArrayList());
          i += 1;
        }
        localObject2 = parambbvk.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bbvj)((Iterator)localObject2).next();
          ((ArrayList)((ArrayList)localObject1).get(localObject3.jdField_a_of_type_ArrayOfInt[j])).add(localObject3);
        }
        i = 0;
        while (i < bbvj.jdField_a_of_type_Int)
        {
          if (((j != 16) || (i != 2)) || (((ArrayList)((ArrayList)localObject1).get(i)).size() > 0))
          {
            parambbvk.jdField_a_of_type_ArrayOfBbvk[i] = new bbvk(parambbvk, (List)((ArrayList)localObject1).get(i));
            a(parambbvk.jdField_a_of_type_ArrayOfBbvk[i], parambbvi, parambbvh, paramInt + 1);
          }
          i += 1;
        }
      }
      return;
    }
  }
  
  public void a(List<bbvj> paramList)
  {
    this.jdField_a_of_type_Bbvk = a(paramList, jdField_a_of_type_Bbvi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbve
 * JD-Core Version:    0.7.0.1
 */