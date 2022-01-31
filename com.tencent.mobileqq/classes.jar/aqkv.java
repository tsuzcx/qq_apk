import com.tencent.mobileqq.fts.entity.FTSEntity;

public class aqkv
{
  private int jdField_a_of_type_Int;
  private Class<? extends FTSEntity> jdField_a_of_type_JavaLangClass;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  aqkw[] jdField_a_of_type_ArrayOfAqkw;
  private String b;
  
  public aqku a()
  {
    if (this.jdField_a_of_type_JavaLangClass == null) {
      throw new IllegalArgumentException("entityClazz must not be null.");
    }
    return new aqku(this.jdField_a_of_type_JavaLangClass, this.jdField_a_of_type_ArrayOfAqkw, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
  }
  
  public aqkv a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public aqkv a(Class<? extends FTSEntity> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    return this;
  }
  
  public aqkv a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public aqkv a(aqkw... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfAqkw = paramVarArgs;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqkv
 * JD-Core Version:    0.7.0.1
 */