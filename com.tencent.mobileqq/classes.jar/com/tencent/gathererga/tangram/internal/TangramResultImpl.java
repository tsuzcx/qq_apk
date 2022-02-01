package com.tencent.gathererga.tangram.internal;

import com.tencent.gathererga.core.ProviderResult;
import com.tencent.gathererga.tangram.TangramResult;

public class TangramResultImpl
  implements TangramResult
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -2147483648L;
  private Object jdField_a_of_type_JavaLangObject = null;
  private String jdField_a_of_type_JavaLangString = null;
  private boolean jdField_a_of_type_Boolean = false;
  private long b = -1L;
  
  public TangramResultImpl(ProviderResult paramProviderResult, String paramString)
  {
    if (paramProviderResult != null)
    {
      this.jdField_a_of_type_Long = paramProviderResult.a();
      this.jdField_a_of_type_Boolean = paramProviderResult.a();
      this.jdField_a_of_type_Int = paramProviderResult.a();
      if (this.jdField_a_of_type_Int == 2)
      {
        if ((paramProviderResult.a() instanceof String)) {
          this.jdField_a_of_type_JavaLangString = ((String)paramProviderResult.a());
        }
        this.jdField_a_of_type_JavaLangObject = null;
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_JavaLangObject = paramProviderResult.a();
      }
      this.b = paramProviderResult.b();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.tangram.internal.TangramResultImpl
 * JD-Core Version:    0.7.0.1
 */