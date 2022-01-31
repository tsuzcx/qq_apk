import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class blrx
  implements blnh
{
  public static final String[] a;
  public int a;
  public blng a;
  blry a;
  public String a;
  public int b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "NoNeedDown", "NoFound", "NeedDown" };
  }
  
  public int a()
  {
    blng localblng = a();
    int i;
    if (localblng != null) {
      if (localblng.a() == 2) {
        i = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMPredownManager", 2, String.format("getState %s %s %s %s ", new Object[] { toString(), "" + localblng, jdField_a_of_type_ArrayOfJavaLangString[i], blrz.jdField_a_of_type_ArrayOfJavaLangString[this.b] }));
      }
      return i;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public blng a()
  {
    Object localObject1 = this.jdField_a_of_type_Blng;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      switch (this.b)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Blng = ((blng)localObject1);
      localObject2 = localObject1;
      return localObject2;
      localObject1 = ((blnl)blmf.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = ((blnl)blmf.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = blqs.a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = blqs.a("", this.jdField_a_of_type_JavaLangString, "forPredownlaod", 0.0F, 0.0F, 0.0F);
      continue;
      localObject1 = blqs.b(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = blqs.a(this.jdField_a_of_type_JavaLangString, new ArrayList(), 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void a()
  {
    blng localblng = a();
    if (localblng != null)
    {
      localblng.a(this);
      localblng.b();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "starDownload: " + this + localblng);
    }
  }
  
  public void a(blng paramblng) {}
  
  public void a(blng paramblng, int paramInt)
  {
    this.jdField_a_of_type_Blry.a(false, this);
  }
  
  public void a(blry paramblry)
  {
    this.jdField_a_of_type_Blry = paramblry;
  }
  
  public void b(blng paramblng)
  {
    this.jdField_a_of_type_Blry.a(true, this);
  }
  
  public String toString()
  {
    return "QIMPredownJob{" + this.jdField_a_of_type_Int + "," + blrz.jdField_a_of_type_ArrayOfJavaLangString[this.b] + "," + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrx
 * JD-Core Version:    0.7.0.1
 */