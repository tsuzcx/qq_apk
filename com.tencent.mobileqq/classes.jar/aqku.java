import com.tencent.mobileqq.fts.entity.FTSEntity;
import java.util.Arrays;

public class aqku
{
  public int a;
  public Class<? extends FTSEntity> a;
  public String a;
  public boolean a;
  public aqkw[] a;
  public String b;
  
  public aqku(Class<? extends FTSEntity> paramClass, aqkw[] paramArrayOfaqkw, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_ArrayOfAqkw = paramArrayOfaqkw;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public String toString()
  {
    return "FTSQueryArgs{entityClazz=" + this.jdField_a_of_type_JavaLangClass + ", matchKeys=" + Arrays.toString(this.jdField_a_of_type_ArrayOfAqkw) + ", matchKeysOr=" + this.jdField_a_of_type_Boolean + ", limit=" + this.jdField_a_of_type_Int + ", selectionSql='" + this.jdField_a_of_type_JavaLangString + '\'' + ", orderBySql='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqku
 * JD-Core Version:    0.7.0.1
 */