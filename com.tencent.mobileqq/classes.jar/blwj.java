import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class blwj
  implements blrt
{
  public static final String[] a;
  public int a;
  public blrs a;
  blwk a;
  public String a;
  public int b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "NoNeedDown", "NoFound", "NeedDown" };
  }
  
  public int a()
  {
    blrs localblrs = a();
    int i;
    if (localblrs != null) {
      if (localblrs.a() == 2) {
        i = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMPredownManager", 2, String.format("getState %s %s %s %s ", new Object[] { toString(), "" + localblrs, jdField_a_of_type_ArrayOfJavaLangString[i], blwl.jdField_a_of_type_ArrayOfJavaLangString[this.b] }));
      }
      return i;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public blrs a()
  {
    Object localObject1 = this.jdField_a_of_type_Blrs;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      switch (this.b)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Blrs = ((blrs)localObject1);
      localObject2 = localObject1;
      return localObject2;
      localObject1 = ((blrx)blqr.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = ((blrx)blqr.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = blve.a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = blve.a("", this.jdField_a_of_type_JavaLangString, "forPredownlaod", 0.0F, 0.0F, 0.0F);
      continue;
      localObject1 = blve.b(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = blve.a(this.jdField_a_of_type_JavaLangString, new ArrayList(), 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void a()
  {
    blrs localblrs = a();
    if (localblrs != null)
    {
      localblrs.a(this);
      localblrs.b();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "starDownload: " + this + localblrs);
    }
  }
  
  public void a(blrs paramblrs) {}
  
  public void a(blrs paramblrs, int paramInt)
  {
    this.jdField_a_of_type_Blwk.a(false, this);
  }
  
  public void a(blwk paramblwk)
  {
    this.jdField_a_of_type_Blwk = paramblwk;
  }
  
  public void b(blrs paramblrs)
  {
    this.jdField_a_of_type_Blwk.a(true, this);
  }
  
  public String toString()
  {
    return "QIMPredownJob{" + this.jdField_a_of_type_Int + "," + blwl.jdField_a_of_type_ArrayOfJavaLangString[this.b] + "," + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwj
 * JD-Core Version:    0.7.0.1
 */