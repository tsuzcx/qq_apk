import com.tencent.mobileqq.fts.entity.FTSEntity;

public class asiw
{
  private int jdField_a_of_type_Int;
  private Class<? extends FTSEntity> jdField_a_of_type_JavaLangClass;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  asix[] jdField_a_of_type_ArrayOfAsix;
  private String b;
  
  public asiv a()
  {
    if (this.jdField_a_of_type_JavaLangClass == null) {
      throw new IllegalArgumentException("entityClazz must not be null.");
    }
    return new asiv(this.jdField_a_of_type_JavaLangClass, this.jdField_a_of_type_ArrayOfAsix, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
  }
  
  public asiw a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public asiw a(Class<? extends FTSEntity> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    return this;
  }
  
  public asiw a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public asiw a(asix... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfAsix = paramVarArgs;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asiw
 * JD-Core Version:    0.7.0.1
 */