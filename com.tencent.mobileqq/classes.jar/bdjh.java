import android.support.v4.util.SparseArrayCompat;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bdjh<E extends Enum>
{
  private SparseArrayCompat<bdji<E>> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private E jdField_a_of_type_JavaLangEnum;
  private String jdField_a_of_type_JavaLangString = "EditorStateMachine";
  private SparseArrayCompat<List<E>> jdField_b_of_type_AndroidSupportV4UtilSparseArrayCompat;
  private E jdField_b_of_type_JavaLangEnum;
  
  public bdjh(E paramE, String paramString)
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
  
  public <T extends bdji<E>> T a(E paramE)
  {
    return (bdji)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramE.ordinal());
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
    bdji localbdji = a(this.jdField_a_of_type_JavaLangEnum);
    if (localbdji != null) {
      localbdji.a(paramInt);
    }
  }
  
  public void a(bdji<E> parambdji)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) {
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
    }
    this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(((Enum)parambdji.a()).ordinal(), parambdji);
    a((Enum)parambdji.a(), parambdji.a());
  }
  
  public void a(E paramE)
  {
    a(paramE, null);
  }
  
  public void a(E paramE, String paramString)
  {
    if (a(paramE))
    {
      localbdji = a(paramE);
      if ((localbdji == null) || (!localbdji.a())) {
        this.jdField_b_of_type_JavaLangEnum = this.jdField_a_of_type_JavaLangEnum;
      }
      this.jdField_a_of_type_JavaLangEnum = paramE;
      paramE = a(this.jdField_b_of_type_JavaLangEnum);
      if (paramE != null) {
        paramE.a();
      }
      if (localbdji != null)
      {
        localbdji.jdField_a_of_type_JavaLangString = paramString;
        localbdji.a(this.jdField_b_of_type_JavaLangEnum);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[setState] from: " + this.jdField_b_of_type_JavaLangEnum + " -> to: " + this.jdField_a_of_type_JavaLangEnum);
      }
    }
    while (!QLog.isColorLevel())
    {
      bdji localbdji;
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
 * Qualified Name:     bdjh
 * JD-Core Version:    0.7.0.1
 */