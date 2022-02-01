import java.util.ArrayList;
import java.util.List;

class bexs
{
  private int[] jdField_a_of_type_ArrayOfInt;
  
  bexs(bexr parambexr) {}
  
  private bfck a(List<bfck> paramList, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (paramArrayOfInt != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int j = 5;
      if (i < paramArrayOfInt.length)
      {
        int k = j;
        if (((bfck)paramList.get(i)).a() == paramBoolean)
        {
          if (paramArrayOfInt[i] >= j) {
            break label94;
          }
          k = paramArrayOfInt[i];
          localArrayList.clear();
          localArrayList.add(Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          label94:
          k = j;
          if (paramArrayOfInt[i] == j)
          {
            localArrayList.add(Integer.valueOf(i));
            k = j;
          }
        }
      }
      if (localArrayList.size() > 0)
      {
        i = ((Integer)localArrayList.get(0)).intValue();
        if ((i >= 0) && (i < paramList.size())) {
          return (bfck)paramList.get(i);
        }
      }
    }
    return null;
  }
  
  bfck a(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = null;
    List localList = bexr.a(this.jdField_a_of_type_Bexr, paramInt);
    Object localObject1 = localObject2;
    if (localList != null)
    {
      localObject1 = localObject2;
      if (localList.size() > 0) {
        localObject1 = a(localList, a(paramInt), paramBoolean);
      }
    }
    return localObject1;
  }
  
  void a(List<bfck> paramList)
  {
    if ((paramList != null) && (paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_ArrayOfInt = new int[paramList.size()];
    }
  }
  
  int[] a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_ArrayOfInt;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexs
 * JD-Core Version:    0.7.0.1
 */