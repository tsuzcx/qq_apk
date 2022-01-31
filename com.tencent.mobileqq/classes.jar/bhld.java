import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bhld
  implements bhgo
{
  public static final String[] a;
  public int a;
  public bhgn a;
  bhle a;
  public String a;
  public int b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "NoNeedDown", "NoFound", "NeedDown" };
  }
  
  public int a()
  {
    bhgn localbhgn = a();
    int i;
    if (localbhgn != null) {
      if (localbhgn.a() == 2) {
        i = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMPredownManager", 2, String.format("getState %s %s %s %s ", new Object[] { toString(), "" + localbhgn, jdField_a_of_type_ArrayOfJavaLangString[i], bhlf.jdField_a_of_type_ArrayOfJavaLangString[this.b] }));
      }
      return i;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public bhgn a()
  {
    Object localObject1 = this.jdField_a_of_type_Bhgn;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      switch (this.b)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhgn = ((bhgn)localObject1);
      localObject2 = localObject1;
      return localObject2;
      localObject1 = ((bhgs)bhfm.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = ((bhgs)bhfm.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bhjy.a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bhjy.a("", this.jdField_a_of_type_JavaLangString, "forPredownlaod", 0.0F, 0.0F, 0.0F);
      continue;
      localObject1 = bhjy.b(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bhjy.a(this.jdField_a_of_type_JavaLangString, new ArrayList(), 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void a()
  {
    bhgn localbhgn = a();
    if (localbhgn != null)
    {
      localbhgn.a(this);
      localbhgn.b();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "starDownload: " + this + localbhgn);
    }
  }
  
  public void a(bhgn parambhgn) {}
  
  public void a(bhgn parambhgn, int paramInt)
  {
    this.jdField_a_of_type_Bhle.a(false, this);
  }
  
  public void a(bhle parambhle)
  {
    this.jdField_a_of_type_Bhle = parambhle;
  }
  
  public void b(bhgn parambhgn)
  {
    this.jdField_a_of_type_Bhle.a(true, this);
  }
  
  public String toString()
  {
    return "QIMPredownJob{" + this.jdField_a_of_type_Int + "," + bhlf.jdField_a_of_type_ArrayOfJavaLangString[this.b] + "," + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhld
 * JD-Core Version:    0.7.0.1
 */