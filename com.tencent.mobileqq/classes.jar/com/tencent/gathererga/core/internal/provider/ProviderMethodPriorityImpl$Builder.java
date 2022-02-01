package com.tencent.gathererga.core.internal.provider;

public final class ProviderMethodPriorityImpl$Builder
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = true;
  private int c = 0;
  
  public final Builder a()
  {
    this.jdField_a_of_type_Int = 4;
    return this;
  }
  
  public final Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public final ProviderMethodPriorityImpl a()
  {
    return new ProviderMethodPriorityImpl(this, null);
  }
  
  public final Builder b()
  {
    this.jdField_a_of_type_Int = 1;
    return this;
  }
  
  public final Builder b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public final Builder c()
  {
    this.jdField_b_of_type_Int = 2;
    return this;
  }
  
  public final Builder d()
  {
    this.jdField_b_of_type_Int = 1;
    return this;
  }
  
  public final Builder e()
  {
    this.c = 2;
    return this;
  }
  
  public final Builder f()
  {
    this.c = 1;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.provider.ProviderMethodPriorityImpl.Builder
 * JD-Core Version:    0.7.0.1
 */