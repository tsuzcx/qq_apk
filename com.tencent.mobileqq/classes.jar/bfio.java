final class bfio
  implements bfjs
{
  private bfio(bfid parambfid) {}
  
  public int a(long paramLong1, long paramLong2, long paramLong3, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramLong1 == 2L) {}
    try
    {
      this.a.flushRequest();
      return 0;
    }
    catch (Exception paramObject1)
    {
      label62:
      paramObject1.printStackTrace();
      return -1;
    }
    if ((paramObject1 != null) && (paramObject2 != null) && (paramArrayOfObject1 != null))
    {
      if (paramArrayOfObject1.length >= 6) {
        break label241;
      }
      break label238;
      if (paramLong2 != 0L)
      {
        paramArrayOfObject2 = new bfin(paramLong2);
        break label251;
        if (((Integer)paramObject1).intValue() == 0) {
          break label270;
        }
      }
    }
    label270:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (((Integer)paramObject2).intValue() == 1) {
        paramObject1 = new bfja((String)paramArrayOfObject1[2]);
      }
      for (;;)
      {
        return this.a.cloudDetect(paramObject1, bool1, bool2, paramArrayOfObject2);
        paramObject1 = new bfjb();
        paramObject1.jdField_a_of_type_Int = ((Integer)paramObject2).intValue();
        paramObject1.b = ((Integer)paramArrayOfObject1[0]).intValue();
        paramObject1.jdField_a_of_type_JavaLangString = ((String)paramArrayOfObject1[1]);
        paramObject1.c = ((String)paramArrayOfObject1[2]);
        paramObject1.d = ((String)paramArrayOfObject1[3]);
        paramObject1.e = ((String)paramArrayOfObject1[4]);
        paramObject1.jdField_a_of_type_ArrayOfByte = ((byte[])paramArrayOfObject1[5]);
      }
      paramArrayOfObject2 = null;
      break label251;
      label238:
      return 13;
      label241:
      if (paramArrayOfObject1[0] != null) {
        break;
      }
      return 13;
      label251:
      if (paramLong3 != 0L)
      {
        bool1 = true;
        break label62;
      }
      boolean bool1 = false;
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfio
 * JD-Core Version:    0.7.0.1
 */