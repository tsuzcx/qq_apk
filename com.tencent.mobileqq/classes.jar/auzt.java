import com.tencent.mobileqq.fts.entity.FTSEntity;

public class auzt
{
  private int jdField_a_of_type_Int;
  private Class<? extends FTSEntity> jdField_a_of_type_JavaLangClass;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  auzu[] jdField_a_of_type_ArrayOfAuzu;
  private String b;
  
  public auzs a()
  {
    if (this.jdField_a_of_type_JavaLangClass == null) {
      throw new IllegalArgumentException("entityClazz must not be null.");
    }
    return new auzs(this.jdField_a_of_type_JavaLangClass, this.jdField_a_of_type_ArrayOfAuzu, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
  }
  
  public auzt a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public auzt a(Class<? extends FTSEntity> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    return this;
  }
  
  public auzt a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public auzt a(auzu... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfAuzu = paramVarArgs;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzt
 * JD-Core Version:    0.7.0.1
 */