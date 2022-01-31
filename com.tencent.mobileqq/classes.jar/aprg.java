import com.tencent.mobileqq.fts.entity.FTSEntity;

public class aprg
{
  private int jdField_a_of_type_Int;
  private Class<? extends FTSEntity> jdField_a_of_type_JavaLangClass;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  aprh[] jdField_a_of_type_ArrayOfAprh;
  private String b;
  
  public aprf a()
  {
    if (this.jdField_a_of_type_JavaLangClass == null) {
      throw new IllegalArgumentException("entityClazz must not be null.");
    }
    return new aprf(this.jdField_a_of_type_JavaLangClass, this.jdField_a_of_type_ArrayOfAprh, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
  }
  
  public aprg a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public aprg a(Class<? extends FTSEntity> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    return this;
  }
  
  public aprg a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public aprg a(aprh... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfAprh = paramVarArgs;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aprg
 * JD-Core Version:    0.7.0.1
 */