class bfgu
  extends bffz
{
  bfgu(bfgt parambfgt, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, bjua[] paramArrayOfbjua)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 2) {
        break label22;
      }
    }
    label22:
    do
    {
      do
      {
        return;
        paramObject = paramObject[0];
      } while (!(paramObject instanceof boolean[]));
      paramObject = (boolean[])paramObject;
    } while ((paramArrayOfbjua == null) || (paramArrayOfbjua.length <= 0) || (paramObject.length != 3));
    if ((paramArrayOfbjua.length < 0) && (paramObject[0] != 0))
    {
      paramArrayOfbjua[0].b = 0;
      paramArrayOfbjua[0].a = 0;
    }
    for (int i = 1;; i = 0)
    {
      paramInt = i;
      if (i < paramArrayOfbjua.length)
      {
        paramInt = i;
        if (paramObject[1] != 0)
        {
          paramArrayOfbjua[i].b = 1;
          paramArrayOfbjua[i].a = 1;
          paramInt = i + 1;
        }
      }
      i = paramInt;
      if (paramInt < paramArrayOfbjua.length)
      {
        i = paramInt;
        if (paramObject[2] != 0)
        {
          paramArrayOfbjua[paramInt].b = 2;
          paramArrayOfbjua[paramInt].a = 0;
          i = paramInt + 1;
        }
      }
      while (i < paramArrayOfbjua.length)
      {
        paramArrayOfbjua[i].b = -1;
        paramArrayOfbjua[i].a = -1;
        i += 1;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgu
 * JD-Core Version:    0.7.0.1
 */