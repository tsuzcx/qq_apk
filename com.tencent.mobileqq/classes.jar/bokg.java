import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bokg
  implements bohf
{
  public static final String[] a;
  public int a;
  public bohe a;
  bokh a;
  public String a;
  public int b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "NoNeedDown", "NoFound", "NeedDown" };
  }
  
  public int a()
  {
    bohe localbohe = a();
    int i;
    if (localbohe != null) {
      if (localbohe.a() == 2) {
        i = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMPredownManager", 2, String.format("getState %s %s %s %s ", new Object[] { toString(), "" + localbohe, jdField_a_of_type_ArrayOfJavaLangString[i], boki.jdField_a_of_type_ArrayOfJavaLangString[this.b] }));
      }
      return i;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public bohe a()
  {
    Object localObject1 = this.jdField_a_of_type_Bohe;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      switch (this.b)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bohe = ((bohe)localObject1);
      localObject2 = localObject1;
      return localObject2;
      localObject1 = ((bohj)bogd.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = ((bohj)bogd.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bojp.a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bojp.a("", this.jdField_a_of_type_JavaLangString, "forPredownlaod", 0.0F, 0.0F, 0.0F);
      continue;
      localObject1 = bojp.b(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bojp.a(this.jdField_a_of_type_JavaLangString, new ArrayList(), 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void a()
  {
    bohe localbohe = a();
    if (localbohe != null)
    {
      localbohe.a(this);
      localbohe.b();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "starDownload: " + this + localbohe);
    }
  }
  
  public void a(bohe parambohe) {}
  
  public void a(bohe parambohe, int paramInt)
  {
    this.jdField_a_of_type_Bokh.a(false, this);
  }
  
  public void a(bokh parambokh)
  {
    this.jdField_a_of_type_Bokh = parambokh;
  }
  
  public void b(bohe parambohe)
  {
    this.jdField_a_of_type_Bokh.a(true, this);
  }
  
  public String toString()
  {
    return "QIMPredownJob{" + this.jdField_a_of_type_Int + "," + boki.jdField_a_of_type_ArrayOfJavaLangString[this.b] + "," + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bokg
 * JD-Core Version:    0.7.0.1
 */