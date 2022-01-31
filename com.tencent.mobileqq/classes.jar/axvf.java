import java.util.ArrayList;
import java.util.List;

class axvf
{
  private int[] jdField_a_of_type_ArrayOfInt;
  
  axvf(axve paramaxve) {}
  
  private axzt a(List<axzt> paramList, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (paramArrayOfInt != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      int j = 5;
      if (i < paramArrayOfInt.length)
      {
        int k = j;
        if (((axzt)paramList.get(i)).a() == paramBoolean)
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
          return (axzt)paramList.get(i);
        }
      }
    }
    return null;
  }
  
  axzt a(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = null;
    List localList = axve.a(this.jdField_a_of_type_Axve, paramInt);
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
  
  void a(List<axzt> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axvf
 * JD-Core Version:    0.7.0.1
 */