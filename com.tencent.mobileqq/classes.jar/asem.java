import com.tencent.mobileqq.fts.entity.FTSEntity;
import java.util.Arrays;

public class asem
{
  public int a;
  public Class<? extends FTSEntity> a;
  public String a;
  public boolean a;
  public aseo[] a;
  public String b;
  
  public asem(Class<? extends FTSEntity> paramClass, aseo[] paramArrayOfaseo, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_ArrayOfAseo = paramArrayOfaseo;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public String toString()
  {
    return "FTSQueryArgs{entityClazz=" + this.jdField_a_of_type_JavaLangClass + ", matchKeys=" + Arrays.toString(this.jdField_a_of_type_ArrayOfAseo) + ", matchKeysOr=" + this.jdField_a_of_type_Boolean + ", limit=" + this.jdField_a_of_type_Int + ", selectionSql='" + this.jdField_a_of_type_JavaLangString + '\'' + ", orderBySql='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asem
 * JD-Core Version:    0.7.0.1
 */