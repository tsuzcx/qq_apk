package com.android.dex;

public final class ClassData
{
  private final ClassData.Method[] directMethods;
  private final ClassData.Field[] instanceFields;
  private final ClassData.Field[] staticFields;
  private final ClassData.Method[] virtualMethods;
  
  public ClassData(ClassData.Field[] paramArrayOfField1, ClassData.Field[] paramArrayOfField2, ClassData.Method[] paramArrayOfMethod1, ClassData.Method[] paramArrayOfMethod2)
  {
    this.staticFields = paramArrayOfField1;
    this.instanceFields = paramArrayOfField2;
    this.directMethods = paramArrayOfMethod1;
    this.virtualMethods = paramArrayOfMethod2;
  }
  
  public ClassData.Field[] allFields()
  {
    ClassData.Field[] arrayOfField = new ClassData.Field[this.staticFields.length + this.instanceFields.length];
    System.arraycopy(this.staticFields, 0, arrayOfField, 0, this.staticFields.length);
    System.arraycopy(this.instanceFields, 0, arrayOfField, this.staticFields.length, this.instanceFields.length);
    return arrayOfField;
  }
  
  public ClassData.Method[] allMethods()
  {
    ClassData.Method[] arrayOfMethod = new ClassData.Method[this.directMethods.length + this.virtualMethods.length];
    System.arraycopy(this.directMethods, 0, arrayOfMethod, 0, this.directMethods.length);
    System.arraycopy(this.virtualMethods, 0, arrayOfMethod, this.directMethods.length, this.virtualMethods.length);
    return arrayOfMethod;
  }
  
  public ClassData.Method[] getDirectMethods()
  {
    return this.directMethods;
  }
  
  public ClassData.Field[] getInstanceFields()
  {
    return this.instanceFields;
  }
  
  public ClassData.Field[] getStaticFields()
  {
    return this.staticFields;
  }
  
  public ClassData.Method[] getVirtualMethods()
  {
    return this.virtualMethods;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.ClassData
 * JD-Core Version:    0.7.0.1
 */