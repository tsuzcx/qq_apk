import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bmuo
  implements bmrn
{
  public static final String[] a;
  public int a;
  public bmrm a;
  bmup a;
  public String a;
  public int b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "NoNeedDown", "NoFound", "NeedDown" };
  }
  
  public int a()
  {
    bmrm localbmrm = a();
    int i;
    if (localbmrm != null) {
      if (localbmrm.a() == 2) {
        i = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMPredownManager", 2, String.format("getState %s %s %s %s ", new Object[] { toString(), "" + localbmrm, jdField_a_of_type_ArrayOfJavaLangString[i], bmuq.jdField_a_of_type_ArrayOfJavaLangString[this.b] }));
      }
      return i;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public bmrm a()
  {
    Object localObject1 = this.jdField_a_of_type_Bmrm;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      switch (this.b)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bmrm = ((bmrm)localObject1);
      localObject2 = localObject1;
      return localObject2;
      localObject1 = ((bmrr)bmql.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = ((bmrr)bmql.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bmtx.a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bmtx.a("", this.jdField_a_of_type_JavaLangString, "forPredownlaod", 0.0F, 0.0F, 0.0F);
      continue;
      localObject1 = bmtx.b(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bmtx.a(this.jdField_a_of_type_JavaLangString, new ArrayList(), 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void a()
  {
    bmrm localbmrm = a();
    if (localbmrm != null)
    {
      localbmrm.a(this);
      localbmrm.b();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "starDownload: " + this + localbmrm);
    }
  }
  
  public void a(bmrm parambmrm) {}
  
  public void a(bmrm parambmrm, int paramInt)
  {
    this.jdField_a_of_type_Bmup.a(false, this);
  }
  
  public void a(bmup parambmup)
  {
    this.jdField_a_of_type_Bmup = parambmup;
  }
  
  public void b(bmrm parambmrm)
  {
    this.jdField_a_of_type_Bmup.a(true, this);
  }
  
  public String toString()
  {
    return "QIMPredownJob{" + this.jdField_a_of_type_Int + "," + bmuq.jdField_a_of_type_ArrayOfJavaLangString[this.b] + "," + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmuo
 * JD-Core Version:    0.7.0.1
 */