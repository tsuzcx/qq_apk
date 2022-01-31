class bcog
  extends bcnl
{
  bcog(bcof parambcof, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, bhxc[] paramArrayOfbhxc)
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
    } while ((paramArrayOfbhxc == null) || (paramArrayOfbhxc.length <= 0) || (paramObject.length != 3));
    if ((paramArrayOfbhxc.length < 0) && (paramObject[0] != 0))
    {
      paramArrayOfbhxc[0].b = 0;
      paramArrayOfbhxc[0].a = 0;
    }
    for (int i = 1;; i = 0)
    {
      paramInt = i;
      if (i < paramArrayOfbhxc.length)
      {
        paramInt = i;
        if (paramObject[1] != 0)
        {
          paramArrayOfbhxc[i].b = 1;
          paramArrayOfbhxc[i].a = 1;
          paramInt = i + 1;
        }
      }
      i = paramInt;
      if (paramInt < paramArrayOfbhxc.length)
      {
        i = paramInt;
        if (paramObject[2] != 0)
        {
          paramArrayOfbhxc[paramInt].b = 2;
          paramArrayOfbhxc[paramInt].a = 0;
          i = paramInt + 1;
        }
      }
      while (i < paramArrayOfbhxc.length)
      {
        paramArrayOfbhxc[i].b = -1;
        paramArrayOfbhxc[i].a = -1;
        i += 1;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcog
 * JD-Core Version:    0.7.0.1
 */