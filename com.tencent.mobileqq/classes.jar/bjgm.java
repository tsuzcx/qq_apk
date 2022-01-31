import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bjgm
  implements bjbx
{
  public static final String[] a;
  public int a;
  public bjbw a;
  bjgn a;
  public String a;
  public int b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "NoNeedDown", "NoFound", "NeedDown" };
  }
  
  public int a()
  {
    bjbw localbjbw = a();
    int i;
    if (localbjbw != null) {
      if (localbjbw.a() == 2) {
        i = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMPredownManager", 2, String.format("getState %s %s %s %s ", new Object[] { toString(), "" + localbjbw, jdField_a_of_type_ArrayOfJavaLangString[i], bjgo.jdField_a_of_type_ArrayOfJavaLangString[this.b] }));
      }
      return i;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public bjbw a()
  {
    Object localObject1 = this.jdField_a_of_type_Bjbw;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      switch (this.b)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjbw = ((bjbw)localObject1);
      localObject2 = localObject1;
      return localObject2;
      localObject1 = ((bjcb)bjav.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = ((bjcb)bjav.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bjfh.a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bjfh.a("", this.jdField_a_of_type_JavaLangString, "forPredownlaod", 0.0F, 0.0F, 0.0F);
      continue;
      localObject1 = bjfh.b(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bjfh.a(this.jdField_a_of_type_JavaLangString, new ArrayList(), 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void a()
  {
    bjbw localbjbw = a();
    if (localbjbw != null)
    {
      localbjbw.a(this);
      localbjbw.b();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "starDownload: " + this + localbjbw);
    }
  }
  
  public void a(bjbw parambjbw) {}
  
  public void a(bjbw parambjbw, int paramInt)
  {
    this.jdField_a_of_type_Bjgn.a(false, this);
  }
  
  public void a(bjgn parambjgn)
  {
    this.jdField_a_of_type_Bjgn = parambjgn;
  }
  
  public void b(bjbw parambjbw)
  {
    this.jdField_a_of_type_Bjgn.a(true, this);
  }
  
  public String toString()
  {
    return "QIMPredownJob{" + this.jdField_a_of_type_Int + "," + bjgo.jdField_a_of_type_ArrayOfJavaLangString[this.b] + "," + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjgm
 * JD-Core Version:    0.7.0.1
 */