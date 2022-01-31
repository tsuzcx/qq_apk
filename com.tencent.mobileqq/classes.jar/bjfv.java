import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bjfv
  implements bjbg
{
  public static final String[] a;
  public int a;
  public bjbf a;
  bjfw a;
  public String a;
  public int b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "NoNeedDown", "NoFound", "NeedDown" };
  }
  
  public int a()
  {
    bjbf localbjbf = a();
    int i;
    if (localbjbf != null) {
      if (localbjbf.a() == 2) {
        i = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMPredownManager", 2, String.format("getState %s %s %s %s ", new Object[] { toString(), "" + localbjbf, jdField_a_of_type_ArrayOfJavaLangString[i], bjfx.jdField_a_of_type_ArrayOfJavaLangString[this.b] }));
      }
      return i;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public bjbf a()
  {
    Object localObject1 = this.jdField_a_of_type_Bjbf;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      switch (this.b)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjbf = ((bjbf)localObject1);
      localObject2 = localObject1;
      return localObject2;
      localObject1 = ((bjbk)bjae.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = ((bjbk)bjae.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bjeq.a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bjeq.a("", this.jdField_a_of_type_JavaLangString, "forPredownlaod", 0.0F, 0.0F, 0.0F);
      continue;
      localObject1 = bjeq.b(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bjeq.a(this.jdField_a_of_type_JavaLangString, new ArrayList(), 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void a()
  {
    bjbf localbjbf = a();
    if (localbjbf != null)
    {
      localbjbf.a(this);
      localbjbf.b();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "starDownload: " + this + localbjbf);
    }
  }
  
  public void a(bjbf parambjbf) {}
  
  public void a(bjbf parambjbf, int paramInt)
  {
    this.jdField_a_of_type_Bjfw.a(false, this);
  }
  
  public void a(bjfw parambjfw)
  {
    this.jdField_a_of_type_Bjfw = parambjfw;
  }
  
  public void b(bjbf parambjbf)
  {
    this.jdField_a_of_type_Bjfw.a(true, this);
  }
  
  public String toString()
  {
    return "QIMPredownJob{" + this.jdField_a_of_type_Int + "," + bjfx.jdField_a_of_type_ArrayOfJavaLangString[this.b] + "," + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfv
 * JD-Core Version:    0.7.0.1
 */