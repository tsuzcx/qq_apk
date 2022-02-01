package com.tencent.gathererga.core.internal.provider;

import com.tencent.gathererga.core.ProviderResult;

public class ProviderResultImpl
  implements ProviderResult
{
  public static final String[] a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject;
  private Throwable jdField_a_of_type_JavaLangThrowable;
  private long jdField_b_of_type_Long;
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  }
  
  public ProviderResultImpl(long paramLong, Object paramObject)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public ProviderResultImpl(long paramLong, Object paramObject, int paramInt, String[] paramArrayOfString, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
    this.jdField_b_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public static ProviderResult a(long paramLong)
  {
    return new ProviderResultImpl(paramLong, null, 0, jdField_a_of_type_ArrayOfJavaLangString, null);
  }
  
  public static ProviderResult a(long paramLong, Throwable paramThrowable)
  {
    return new ProviderResultImpl(paramLong, null, 0, jdField_a_of_type_ArrayOfJavaLangString, paramThrowable);
  }
  
  public static ProviderResult a(long paramLong, String[] paramArrayOfString)
  {
    return new ProviderResultImpl(paramLong, null, -1, paramArrayOfString, null);
  }
  
  public static ProviderResult a(Object paramObject, int paramInt)
  {
    return new ProviderResultImpl(0L, paramObject, paramInt, jdField_a_of_type_ArrayOfJavaLangString, null);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Long == 0L;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.provider.ProviderResultImpl
 * JD-Core Version:    0.7.0.1
 */