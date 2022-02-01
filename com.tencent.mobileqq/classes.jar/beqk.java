import android.support.v4.util.SparseArrayCompat;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class beqk<E extends Enum>
{
  private SparseArrayCompat<beql<E>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private E jdField_a_of_type_JavaLangEnum;
  private String jdField_a_of_type_JavaLangString = "EditorStateMachine";
  private SparseArrayCompat<List<E>> jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private E jdField_b_of_type_JavaLangEnum;
  
  public beqk(E paramE, String paramString)
  {
    this.jdField_a_of_type_JavaLangEnum = paramE;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "." + paramString);
  }
  
  private void a(E paramE, List<E> paramList)
  {
    if (this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat == null) {
      this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    }
    this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.put(paramE.ordinal(), paramList);
  }
  
  private boolean a(E paramE)
  {
    List localList = (List)this.jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramE.ordinal());
    return (localList != null) && (localList.contains(this.jdField_a_of_type_JavaLangEnum)) && (this.jdField_a_of_type_JavaLangEnum != paramE);
  }
  
  public <T extends beql<E>> T a(E paramE)
  {
    return (beql)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramE.ordinal());
  }
  
  public E a()
  {
    return this.jdField_a_of_type_JavaLangEnum;
  }
  
  public void a()
  {
    a(this.jdField_b_of_type_JavaLangEnum);
  }
  
  public void a(int paramInt)
  {
    beql localbeql = a(this.jdField_a_of_type_JavaLangEnum);
    if (localbeql != null) {
      localbeql.a(paramInt);
    }
  }
  
  public void a(beql<E> parambeql)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) {
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    }
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(((Enum)parambeql.a()).ordinal(), parambeql);
    a((Enum)parambeql.a(), parambeql.a());
  }
  
  public void a(E paramE)
  {
    a(paramE, null);
  }
  
  public void a(E paramE, String paramString)
  {
    if (a(paramE))
    {
      localbeql = a(paramE);
      if ((localbeql == null) || (!localbeql.a())) {
        this.jdField_b_of_type_JavaLangEnum = this.jdField_a_of_type_JavaLangEnum;
      }
      this.jdField_a_of_type_JavaLangEnum = paramE;
      paramE = a(this.jdField_b_of_type_JavaLangEnum);
      if (paramE != null) {
        paramE.a();
      }
      if (localbeql != null)
      {
        localbeql.jdField_a_of_type_JavaLangString = paramString;
        localbeql.a(this.jdField_b_of_type_JavaLangEnum);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[setState] from: " + this.jdField_b_of_type_JavaLangEnum + " -> to: " + this.jdField_a_of_type_JavaLangEnum);
      }
    }
    while (!QLog.isColorLevel())
    {
      beql localbeql;
      return;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[setState] not allowed state trans: from: " + this.jdField_a_of_type_JavaLangEnum + " -> to: " + paramE);
  }
  
  public E b()
  {
    return this.jdField_b_of_type_JavaLangEnum;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqk
 * JD-Core Version:    0.7.0.1
 */