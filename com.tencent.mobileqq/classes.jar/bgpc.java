class bgpc
  extends bgoh
{
  bgpc(bgpb parambgpb, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, blfm[] paramArrayOfblfm)
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
    } while ((paramArrayOfblfm == null) || (paramArrayOfblfm.length <= 0) || (paramObject.length != 3));
    if ((paramArrayOfblfm.length < 0) && (paramObject[0] != 0))
    {
      paramArrayOfblfm[0].b = 0;
      paramArrayOfblfm[0].a = 0;
    }
    for (int i = 1;; i = 0)
    {
      paramInt = i;
      if (i < paramArrayOfblfm.length)
      {
        paramInt = i;
        if (paramObject[1] != 0)
        {
          paramArrayOfblfm[i].b = 1;
          paramArrayOfblfm[i].a = 1;
          paramInt = i + 1;
        }
      }
      i = paramInt;
      if (paramInt < paramArrayOfblfm.length)
      {
        i = paramInt;
        if (paramObject[2] != 0)
        {
          paramArrayOfblfm[paramInt].b = 2;
          paramArrayOfblfm[paramInt].a = 0;
          i = paramInt + 1;
        }
      }
      while (i < paramArrayOfblfm.length)
      {
        paramArrayOfblfm[i].b = -1;
        paramArrayOfblfm[i].a = -1;
        i += 1;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpc
 * JD-Core Version:    0.7.0.1
 */