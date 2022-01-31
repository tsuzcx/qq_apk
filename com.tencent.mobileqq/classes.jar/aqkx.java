import com.tencent.mobileqq.fts.entity.FTSEntity;

public class aqkx
{
  private int jdField_a_of_type_Int;
  private Class<? extends FTSEntity> jdField_a_of_type_JavaLangClass;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  aqky[] jdField_a_of_type_ArrayOfAqky;
  private String b;
  
  public aqkw a()
  {
    if (this.jdField_a_of_type_JavaLangClass == null) {
      throw new IllegalArgumentException("entityClazz must not be null.");
    }
    return new aqkw(this.jdField_a_of_type_JavaLangClass, this.jdField_a_of_type_ArrayOfAqky, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
  }
  
  public aqkx a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public aqkx a(Class<? extends FTSEntity> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    return this;
  }
  
  public aqkx a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public aqkx a(aqky... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfAqky = paramVarArgs;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqkx
 * JD-Core Version:    0.7.0.1
 */