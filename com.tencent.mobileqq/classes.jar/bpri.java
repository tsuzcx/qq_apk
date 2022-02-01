import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bpri
  implements bpms
{
  public static final String[] a;
  public int a;
  public bpmr a;
  bprj a;
  public String a;
  public int b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "NoNeedDown", "NoFound", "NeedDown" };
  }
  
  public int a()
  {
    bpmr localbpmr = a();
    int i;
    if (localbpmr != null) {
      if (localbpmr.a() == 2) {
        i = 2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMPredownManager", 2, String.format("getState %s %s %s %s ", new Object[] { toString(), "" + localbpmr, jdField_a_of_type_ArrayOfJavaLangString[i], bprk.jdField_a_of_type_ArrayOfJavaLangString[this.b] }));
      }
      return i;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  public bpmr a()
  {
    Object localObject1 = this.jdField_a_of_type_Bpmr;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      switch (this.b)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bpmr = ((bpmr)localObject1);
      localObject2 = localObject1;
      return localObject2;
      localObject1 = ((bpmw)bplq.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = ((bpmw)bplq.a(5)).a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bpqd.a(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bpqd.a("", this.jdField_a_of_type_JavaLangString, "forPredownlaod", 0.0F, 0.0F, 0.0F);
      continue;
      localObject1 = bpqd.b(this.jdField_a_of_type_JavaLangString);
      continue;
      localObject1 = bpqd.a(this.jdField_a_of_type_JavaLangString, new ArrayList(), 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void a()
  {
    bpmr localbpmr = a();
    if (localbpmr != null)
    {
      localbpmr.a(this);
      localbpmr.b();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "starDownload: " + this + localbpmr);
    }
  }
  
  public void a(bpmr parambpmr) {}
  
  public void a(bpmr parambpmr, int paramInt)
  {
    this.jdField_a_of_type_Bprj.a(false, this);
  }
  
  public void a(bprj parambprj)
  {
    this.jdField_a_of_type_Bprj = parambprj;
  }
  
  public void b(bpmr parambpmr)
  {
    this.jdField_a_of_type_Bprj.a(true, this);
  }
  
  public String toString()
  {
    return "QIMPredownJob{" + this.jdField_a_of_type_Int + "," + bprk.jdField_a_of_type_ArrayOfJavaLangString[this.b] + "," + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpri
 * JD-Core Version:    0.7.0.1
 */