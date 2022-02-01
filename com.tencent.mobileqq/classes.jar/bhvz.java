import android.support.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class bhvz<K, V>
{
  static int jdField_a_of_type_Int;
  @Nullable
  static Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  static int jdField_b_of_type_Int;
  @Nullable
  static Object[] jdField_b_of_type_ArrayOfJavaLangObject;
  int[] jdField_a_of_type_ArrayOfInt = bhvt.jdField_a_of_type_ArrayOfInt;
  int jdField_c_of_type_Int = 0;
  Object[] jdField_c_of_type_ArrayOfJavaLangObject = bhvt.jdField_a_of_type_ArrayOfJavaLangObject;
  
  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = bhvt.a(paramArrayOfInt, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfInt)
    {
      throw new ConcurrentModificationException();
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      try
      {
        if (jdField_b_of_type_ArrayOfJavaLangObject != null)
        {
          Object[] arrayOfObject1 = jdField_b_of_type_ArrayOfJavaLangObject;
          this.jdField_c_of_type_ArrayOfJavaLangObject = arrayOfObject1;
          jdField_b_of_type_ArrayOfJavaLangObject = (Object[])arrayOfObject1[0];
          this.jdField_a_of_type_ArrayOfInt = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          jdField_b_of_type_Int -= 1;
          return;
        }
        this.jdField_a_of_type_ArrayOfInt = new int[paramInt];
        this.jdField_c_of_type_ArrayOfJavaLangObject = new Object[paramInt << 1];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (jdField_a_of_type_ArrayOfJavaLangObject != null)
          {
            Object[] arrayOfObject2 = jdField_a_of_type_ArrayOfJavaLangObject;
            this.jdField_c_of_type_ArrayOfJavaLangObject = arrayOfObject2;
            jdField_a_of_type_ArrayOfJavaLangObject = (Object[])arrayOfObject2[0];
            this.jdField_a_of_type_ArrayOfInt = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            jdField_a_of_type_Int -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (jdField_b_of_type_Int < 10)
        {
          paramArrayOfObject[0] = jdField_b_of_type_ArrayOfJavaLangObject;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label117;
          jdField_b_of_type_ArrayOfJavaLangObject = paramArrayOfObject;
          jdField_b_of_type_Int += 1;
        }
        return;
      }
      finally {}
    } else {
      if (paramArrayOfInt.length != 4) {
        break label133;
      }
    }
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_Int < 10)
        {
          paramArrayOfObject[0] = jdField_a_of_type_ArrayOfJavaLangObject;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label134;
          jdField_a_of_type_ArrayOfJavaLangObject = paramArrayOfObject;
          jdField_a_of_type_Int += 1;
        }
        return;
      }
      finally {}
      label117:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label133:
      return;
      label134:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  int a()
  {
    int m = this.jdField_c_of_type_Int;
    int i;
    if (m == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = a(this.jdField_a_of_type_ArrayOfInt, m, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (this.jdField_c_of_type_ArrayOfJavaLangObject[(j << 1)] == null);
    int k = j + 1;
    while ((k < m) && (this.jdField_a_of_type_ArrayOfInt[k] == 0))
    {
      if (this.jdField_c_of_type_ArrayOfJavaLangObject[(k << 1)] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.jdField_a_of_type_ArrayOfInt[j] != 0)) {
        break label121;
      }
      i = j;
      if (this.jdField_c_of_type_ArrayOfJavaLangObject[(j << 1)] == null) {
        break;
      }
      j -= 1;
    }
    label121:
    return k ^ 0xFFFFFFFF;
  }
  
  public int a(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return a();
    }
    return a(paramObject, paramObject.hashCode());
  }
  
  int a(Object paramObject, int paramInt)
  {
    int m = this.jdField_c_of_type_Int;
    int i;
    if (m == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = a(this.jdField_a_of_type_ArrayOfInt, m, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(this.jdField_c_of_type_ArrayOfJavaLangObject[(j << 1)]));
    int k = j + 1;
    while ((k < m) && (this.jdField_a_of_type_ArrayOfInt[k] == paramInt))
    {
      if (paramObject.equals(this.jdField_c_of_type_ArrayOfJavaLangObject[(k << 1)])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.jdField_a_of_type_ArrayOfInt[j] != paramInt)) {
        break label156;
      }
      i = j;
      if (paramObject.equals(this.jdField_c_of_type_ArrayOfJavaLangObject[(j << 1)])) {
        break;
      }
      j -= 1;
    }
    label156:
    return k ^ 0xFFFFFFFF;
  }
  
  public K a(int paramInt)
  {
    return this.jdField_c_of_type_ArrayOfJavaLangObject[(paramInt << 1)];
  }
  
  @Nullable
  public V a(Object paramObject)
  {
    return a(paramObject, null);
  }
  
  public V a(Object paramObject, V paramV)
  {
    int i = a(paramObject);
    if (i >= 0) {
      paramV = this.jdField_c_of_type_ArrayOfJavaLangObject[((i << 1) + 1)];
    }
    return paramV;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Int <= 0;
  }
  
  public boolean a(@Nullable Object paramObject)
  {
    return a(paramObject) >= 0;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public V b(int paramInt)
  {
    return this.jdField_c_of_type_ArrayOfJavaLangObject[((paramInt << 1) + 1)];
  }
  
  @Nullable
  public V b(K paramK, V paramV)
  {
    int k = 8;
    int m = this.jdField_c_of_type_Int;
    int i;
    int j;
    if (paramK == null)
    {
      i = a();
      j = 0;
    }
    while (i >= 0)
    {
      i = (i << 1) + 1;
      paramK = this.jdField_c_of_type_ArrayOfJavaLangObject[i];
      this.jdField_c_of_type_ArrayOfJavaLangObject[i] = paramV;
      return paramK;
      j = paramK.hashCode();
      i = a(paramK, j);
    }
    int n = i ^ 0xFFFFFFFF;
    if (m >= this.jdField_a_of_type_ArrayOfInt.length)
    {
      if (m >= 8) {
        i = (m >> 1) + m;
      }
      int[] arrayOfInt;
      Object[] arrayOfObject;
      for (;;)
      {
        arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
        arrayOfObject = this.jdField_c_of_type_ArrayOfJavaLangObject;
        a(i);
        if (m == this.jdField_c_of_type_Int) {
          break;
        }
        throw new ConcurrentModificationException();
        i = k;
        if (m < 4) {
          i = 4;
        }
      }
      if (this.jdField_a_of_type_ArrayOfInt.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.jdField_c_of_type_ArrayOfJavaLangObject, 0, arrayOfObject.length);
      }
      a(arrayOfInt, arrayOfObject, m);
    }
    if (n < m)
    {
      System.arraycopy(this.jdField_a_of_type_ArrayOfInt, n, this.jdField_a_of_type_ArrayOfInt, n + 1, m - n);
      System.arraycopy(this.jdField_c_of_type_ArrayOfJavaLangObject, n << 1, this.jdField_c_of_type_ArrayOfJavaLangObject, n + 1 << 1, this.jdField_c_of_type_Int - n << 1);
    }
    if ((m != this.jdField_c_of_type_Int) || (n >= this.jdField_a_of_type_ArrayOfInt.length)) {
      throw new ConcurrentModificationException();
    }
    this.jdField_a_of_type_ArrayOfInt[n] = j;
    this.jdField_c_of_type_ArrayOfJavaLangObject[(n << 1)] = paramK;
    this.jdField_c_of_type_ArrayOfJavaLangObject[((n << 1) + 1)] = paramV;
    this.jdField_c_of_type_Int += 1;
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      int i;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      boolean bool;
      if ((paramObject instanceof bhvz))
      {
        paramObject = (bhvz)paramObject;
        if (b() != paramObject.b()) {
          return false;
        }
        i = 0;
        try
        {
          while (i < this.jdField_c_of_type_Int)
          {
            localObject1 = a(i);
            localObject2 = b(i);
            localObject3 = paramObject.a(localObject1);
            if (localObject2 == null)
            {
              if (localObject3 != null) {
                break label227;
              }
              if (!paramObject.a(localObject1)) {
                break label227;
              }
            }
            else
            {
              bool = localObject2.equals(localObject3);
              if (!bool) {
                return false;
              }
            }
            i += 1;
          }
          if (!(paramObject instanceof Map)) {
            break;
          }
        }
        catch (NullPointerException paramObject)
        {
          return false;
        }
        catch (ClassCastException paramObject)
        {
          return false;
        }
      }
      else
      {
        paramObject = (Map)paramObject;
        if (b() != paramObject.size()) {
          return false;
        }
        i = 0;
        try
        {
          while (i < this.jdField_c_of_type_Int)
          {
            localObject1 = a(i);
            localObject2 = b(i);
            localObject3 = paramObject.get(localObject1);
            if (localObject2 == null)
            {
              if (localObject3 != null) {
                break label229;
              }
              if (!paramObject.containsKey(localObject1)) {
                break label229;
              }
            }
            else
            {
              bool = localObject2.equals(localObject3);
              if (!bool) {
                return false;
              }
            }
            i += 1;
          }
          return false;
        }
        catch (NullPointerException paramObject)
        {
          return false;
        }
        catch (ClassCastException paramObject)
        {
          return false;
        }
      }
    }
    label227:
    return false;
    label229:
    return false;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    Object[] arrayOfObject = this.jdField_c_of_type_ArrayOfJavaLangObject;
    int n = this.jdField_c_of_type_Int;
    int i = 1;
    int j = 0;
    int k = 0;
    if (j < n)
    {
      Object localObject = arrayOfObject[i];
      int i1 = arrayOfInt[j];
      if (localObject == null) {}
      for (int m = 0;; m = localObject.hashCode())
      {
        k += (m ^ i1);
        j += 1;
        i += 2;
        break;
      }
    }
    return k;
  }
  
  public String toString()
  {
    if (a()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_c_of_type_Int * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.jdField_c_of_type_Int)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = a(i);
      if (localObject != this)
      {
        localStringBuilder.append(localObject);
        label70:
        localStringBuilder.append('=');
        localObject = b(i);
        if (localObject == this) {
          break label111;
        }
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
        break label70;
        label111:
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhvz
 * JD-Core Version:    0.7.0.1
 */