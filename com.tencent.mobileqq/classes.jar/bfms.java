public class bfms<E>
  implements Cloneable
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private long[] jdField_a_of_type_ArrayOfLong;
  private Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  
  public bfms()
  {
    this(10);
  }
  
  public bfms(int paramInt)
  {
    paramInt = b(paramInt);
    this.jdField_a_of_type_ArrayOfLong = new long[paramInt];
    this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[paramInt];
    this.jdField_a_of_type_Int = 0;
  }
  
  public static int a(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private static int a(long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong)
  {
    int j = paramInt1 - 1;
    int i = paramInt1 + paramInt2;
    while (i - j > 1)
    {
      int k = (i + j) / 2;
      if (paramArrayOfLong[k] < paramLong) {
        j = k;
      } else {
        i = k;
      }
    }
    if (i == paramInt1 + paramInt2) {
      paramInt1 = paramInt1 + paramInt2 ^ 0xFFFFFFFF;
    }
    do
    {
      return paramInt1;
      paramInt1 = i;
    } while (paramArrayOfLong[i] == paramLong);
    return i ^ 0xFFFFFFFF;
  }
  
  public static int b(int paramInt)
  {
    return a(paramInt * 8) / 8;
  }
  
  private void b()
  {
    int m = this.jdField_a_of_type_Int;
    long[] arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != jdField_a_of_type_JavaLangObject)
      {
        if (i != j)
        {
          arrayOfLong[j] = arrayOfLong[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = j;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    return this.jdField_a_of_type_Int;
  }
  
  public long a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    return this.jdField_a_of_type_ArrayOfLong[paramInt];
  }
  
  public bfms<E> a()
  {
    try
    {
      bfms localbfms = (bfms)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        localbfms.jdField_a_of_type_ArrayOfLong = ((long[])this.jdField_a_of_type_ArrayOfLong.clone());
        localbfms.jdField_a_of_type_ArrayOfJavaLangObject = ((Object[])this.jdField_a_of_type_ArrayOfJavaLangObject.clone());
        return localbfms;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  public E a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    return this.jdField_a_of_type_ArrayOfJavaLangObject[paramInt];
  }
  
  public E a(long paramLong)
  {
    return a(paramLong, null);
  }
  
  public E a(long paramLong, E paramE)
  {
    int i = a(this.jdField_a_of_type_ArrayOfLong, 0, this.jdField_a_of_type_Int, paramLong);
    if ((i < 0) || (this.jdField_a_of_type_ArrayOfJavaLangObject[i] == jdField_a_of_type_JavaLangObject)) {
      return paramE;
    }
    return this.jdField_a_of_type_ArrayOfJavaLangObject[i];
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_Int;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangObject[paramInt] != jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ArrayOfJavaLangObject[paramInt] = jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(int paramInt, E paramE)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    this.jdField_a_of_type_ArrayOfJavaLangObject[paramInt] = paramE;
  }
  
  public void a(long paramLong)
  {
    int i = a(this.jdField_a_of_type_ArrayOfLong, 0, this.jdField_a_of_type_Int, paramLong);
    if ((i >= 0) && (this.jdField_a_of_type_ArrayOfJavaLangObject[i] != jdField_a_of_type_JavaLangObject))
    {
      this.jdField_a_of_type_ArrayOfJavaLangObject[i] = jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(long paramLong, E paramE)
  {
    int i = a(this.jdField_a_of_type_ArrayOfLong, 0, this.jdField_a_of_type_Int, paramLong);
    if (i >= 0)
    {
      this.jdField_a_of_type_ArrayOfJavaLangObject[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ArrayOfJavaLangObject[j] == jdField_a_of_type_JavaLangObject))
    {
      this.jdField_a_of_type_ArrayOfLong[j] = paramLong;
      this.jdField_a_of_type_ArrayOfJavaLangObject[j] = paramE;
      return;
    }
    i = j;
    if (this.jdField_a_of_type_Boolean)
    {
      i = j;
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ArrayOfLong.length)
      {
        b();
        i = a(this.jdField_a_of_type_ArrayOfLong, 0, this.jdField_a_of_type_Int, paramLong) ^ 0xFFFFFFFF;
      }
    }
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ArrayOfLong.length)
    {
      j = b(this.jdField_a_of_type_Int + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.jdField_a_of_type_ArrayOfLong, 0, arrayOfLong, 0, this.jdField_a_of_type_ArrayOfLong.length);
      System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, arrayOfObject, 0, this.jdField_a_of_type_ArrayOfJavaLangObject.length);
      this.jdField_a_of_type_ArrayOfLong = arrayOfLong;
      this.jdField_a_of_type_ArrayOfJavaLangObject = arrayOfObject;
    }
    if (this.jdField_a_of_type_Int - i != 0)
    {
      System.arraycopy(this.jdField_a_of_type_ArrayOfLong, i, this.jdField_a_of_type_ArrayOfLong, i + 1, this.jdField_a_of_type_Int - i);
      System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, i, this.jdField_a_of_type_ArrayOfJavaLangObject, i + 1, this.jdField_a_of_type_Int - i);
    }
    this.jdField_a_of_type_ArrayOfLong[i] = paramLong;
    this.jdField_a_of_type_ArrayOfJavaLangObject[i] = paramE;
    this.jdField_a_of_type_Int += 1;
  }
  
  public void b(long paramLong)
  {
    a(paramLong);
  }
  
  public void b(long paramLong, E paramE)
  {
    if ((this.jdField_a_of_type_Int != 0) && (paramLong <= this.jdField_a_of_type_ArrayOfLong[(this.jdField_a_of_type_Int - 1)]))
    {
      a(paramLong, paramE);
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ArrayOfLong.length)) {
      b();
    }
    int i = this.jdField_a_of_type_Int;
    if (i >= this.jdField_a_of_type_ArrayOfLong.length)
    {
      int j = b(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.jdField_a_of_type_ArrayOfLong, 0, arrayOfLong, 0, this.jdField_a_of_type_ArrayOfLong.length);
      System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, arrayOfObject, 0, this.jdField_a_of_type_ArrayOfJavaLangObject.length);
      this.jdField_a_of_type_ArrayOfLong = arrayOfLong;
      this.jdField_a_of_type_ArrayOfJavaLangObject = arrayOfObject;
    }
    this.jdField_a_of_type_ArrayOfLong[i] = paramLong;
    this.jdField_a_of_type_ArrayOfJavaLangObject[i] = paramE;
    this.jdField_a_of_type_Int = (i + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfms
 * JD-Core Version:    0.7.0.1
 */