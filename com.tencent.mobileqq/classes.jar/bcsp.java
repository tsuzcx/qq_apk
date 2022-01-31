class bcsp
  extends bcru
{
  bcsp(bcso parambcso, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, bibj[] paramArrayOfbibj)
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
    } while ((paramArrayOfbibj == null) || (paramArrayOfbibj.length <= 0) || (paramObject.length != 3));
    if ((paramArrayOfbibj.length < 0) && (paramObject[0] != 0))
    {
      paramArrayOfbibj[0].b = 0;
      paramArrayOfbibj[0].a = 0;
    }
    for (int i = 1;; i = 0)
    {
      paramInt = i;
      if (i < paramArrayOfbibj.length)
      {
        paramInt = i;
        if (paramObject[1] != 0)
        {
          paramArrayOfbibj[i].b = 1;
          paramArrayOfbibj[i].a = 1;
          paramInt = i + 1;
        }
      }
      i = paramInt;
      if (paramInt < paramArrayOfbibj.length)
      {
        i = paramInt;
        if (paramObject[2] != 0)
        {
          paramArrayOfbibj[paramInt].b = 2;
          paramArrayOfbibj[paramInt].a = 0;
          i = paramInt + 1;
        }
      }
      while (i < paramArrayOfbibj.length)
      {
        paramArrayOfbibj[i].b = -1;
        paramArrayOfbibj[i].a = -1;
        i += 1;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsp
 * JD-Core Version:    0.7.0.1
 */