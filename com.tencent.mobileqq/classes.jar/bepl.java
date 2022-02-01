import android.support.v4.util.SparseArrayCompat;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bepl<E extends Enum>
{
  private SparseArrayCompat<bepm<E>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private E jdField_a_of_type_JavaLangEnum;
  private String jdField_a_of_type_JavaLangString = "EditorStateMachine";
  private SparseArrayCompat<List<E>> jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private E jdField_b_of_type_JavaLangEnum;
  
  public bepl(E paramE, String paramString)
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
  
  public <T extends bepm<E>> T a(E paramE)
  {
    return (bepm)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramE.ordinal());
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
    bepm localbepm = a(this.jdField_a_of_type_JavaLangEnum);
    if (localbepm != null) {
      localbepm.a(paramInt);
    }
  }
  
  public void a(bepm<E> parambepm)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) {
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    }
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(((Enum)parambepm.a()).ordinal(), parambepm);
    a((Enum)parambepm.a(), parambepm.a());
  }
  
  public void a(E paramE)
  {
    a(paramE, null);
  }
  
  public void a(E paramE, String paramString)
  {
    if (a(paramE))
    {
      localbepm = a(paramE);
      if ((localbepm == null) || (!localbepm.a())) {
        this.jdField_b_of_type_JavaLangEnum = this.jdField_a_of_type_JavaLangEnum;
      }
      this.jdField_a_of_type_JavaLangEnum = paramE;
      paramE = a(this.jdField_b_of_type_JavaLangEnum);
      if (paramE != null) {
        paramE.a();
      }
      if (localbepm != null)
      {
        localbepm.jdField_a_of_type_JavaLangString = paramString;
        localbepm.a(this.jdField_b_of_type_JavaLangEnum);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[setState] from: " + this.jdField_b_of_type_JavaLangEnum + " -> to: " + this.jdField_a_of_type_JavaLangEnum);
      }
    }
    while (!QLog.isColorLevel())
    {
      bepm localbepm;
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
 * Qualified Name:     bepl
 * JD-Core Version:    0.7.0.1
 */