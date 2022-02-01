import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class apqd
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private appy jdField_a_of_type_Appy;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  Object jdField_a_of_type_JavaLangObject = new Object();
  long b;
  
  public apqd(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Appy = new appy(paramAppInterface);
  }
  
  private int a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Long = Math.max(paramLong, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Int = Math.max(paramInt, this.jdField_a_of_type_Int);
    if (this.b == 0L) {
      return this.jdField_a_of_type_Int;
    }
    return Math.max((int)(100L * paramLong / this.b), this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Appy != null) {
      this.jdField_a_of_type_Appy.a();
    }
  }
  
  public void a(ArrayList<apqc> paramArrayList, apqg paramapqg)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "startDowdLoad");
    this.b = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    if (paramArrayList.size() < 1) {
      return;
    }
    Object localObject = paramArrayList.iterator();
    apqc localapqc;
    while (((Iterator)localObject).hasNext())
    {
      localapqc = (apqc)((Iterator)localObject).next();
      this.b = Math.max(this.b, localapqc.jdField_a_of_type_Long);
    }
    if (paramapqg != null) {
      paramapqg.a();
    }
    localObject = (ArrayList)paramArrayList.clone();
    QLog.i("AREngine_ARResourceManagerTools", 1, "startDowdLoad size is " + ((ArrayList)localObject).size());
    int i = 0;
    label129:
    if (i < paramArrayList.size())
    {
      if (((apqc)paramArrayList.get(i)).jdField_a_of_type_Int == 4) {
        break label187;
      }
      this.jdField_a_of_type_Appy.a((apqc)paramArrayList.get(i), new apqe(this, paramapqg, paramArrayList, (ArrayList)localObject));
    }
    for (;;)
    {
      i += 1;
      break label129;
      break;
      label187:
      if (((apqc)paramArrayList.get(i)).jdField_a_of_type_Int == 4)
      {
        nmj.a();
        localapqc = (apqc)paramArrayList.get(i);
        nmj.a(((apqc)paramArrayList.get(i)).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface, new apqf(this, paramapqg, (ArrayList)localObject, localapqc), true, 0, true);
      }
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      a();
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Appy != null) {
      this.jdField_a_of_type_Appy.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqd
 * JD-Core Version:    0.7.0.1
 */