package com.tencent.gathererga.core.internal.provider;

import com.tencent.gathererga.core.ProviderMethodPriority;

public class ProviderMethodPriorityImpl
  implements ProviderMethodPriority
{
  private static ProviderMethodPriorityImpl jdField_a_of_type_ComTencentGatherergaCoreInternalProviderProviderMethodPriorityImpl = new ProviderMethodPriorityImpl(4, 2, 1);
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = true;
  private int c = 0;
  
  private ProviderMethodPriorityImpl(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
  }
  
  private ProviderMethodPriorityImpl(ProviderMethodPriorityImpl.Builder paramBuilder)
  {
    this.jdField_a_of_type_Int = ProviderMethodPriorityImpl.Builder.a(paramBuilder);
    this.jdField_b_of_type_Int = ProviderMethodPriorityImpl.Builder.b(paramBuilder);
    this.c = ProviderMethodPriorityImpl.Builder.c(paramBuilder);
    this.jdField_a_of_type_Boolean = ProviderMethodPriorityImpl.Builder.a(paramBuilder);
    this.jdField_b_of_type_Boolean = ProviderMethodPriorityImpl.Builder.b(paramBuilder);
  }
  
  public static ProviderMethodPriorityImpl.Builder a()
  {
    return new ProviderMethodPriorityImpl.Builder(null);
  }
  
  public static ProviderMethodPriorityImpl a()
  {
    return jdField_a_of_type_ComTencentGatherergaCoreInternalProviderProviderMethodPriorityImpl;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.provider.ProviderMethodPriorityImpl
 * JD-Core Version:    0.7.0.1
 */