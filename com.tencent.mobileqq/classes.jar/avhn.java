import com.tencent.mobileqq.fts.entity.FTSEntity;

public class avhn
{
  private int jdField_a_of_type_Int;
  private Class<? extends FTSEntity> jdField_a_of_type_JavaLangClass;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  avho[] jdField_a_of_type_ArrayOfAvho;
  private String b;
  
  public avhm a()
  {
    if (this.jdField_a_of_type_JavaLangClass == null) {
      throw new IllegalArgumentException("entityClazz must not be null.");
    }
    return new avhm(this.jdField_a_of_type_JavaLangClass, this.jdField_a_of_type_ArrayOfAvho, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
  }
  
  public avhn a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public avhn a(Class<? extends FTSEntity> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    return this;
  }
  
  public avhn a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public avhn a(avho... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfAvho = paramVarArgs;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avhn
 * JD-Core Version:    0.7.0.1
 */