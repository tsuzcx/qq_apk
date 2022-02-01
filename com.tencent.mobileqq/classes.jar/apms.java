import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class apms
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private apmn jdField_a_of_type_Apmn;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  Object jdField_a_of_type_JavaLangObject = new Object();
  long b;
  
  public apms(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Apmn = new apmn(paramAppInterface);
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
    if (this.jdField_a_of_type_Apmn != null) {
      this.jdField_a_of_type_Apmn.a();
    }
  }
  
  public void a(ArrayList<apmr> paramArrayList, apmv paramapmv)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "startDowdLoad");
    this.b = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    if (paramArrayList.size() < 1) {
      return;
    }
    Object localObject = paramArrayList.iterator();
    apmr localapmr;
    while (((Iterator)localObject).hasNext())
    {
      localapmr = (apmr)((Iterator)localObject).next();
      this.b = Math.max(this.b, localapmr.jdField_a_of_type_Long);
    }
    if (paramapmv != null) {
      paramapmv.a();
    }
    localObject = (ArrayList)paramArrayList.clone();
    QLog.i("AREngine_ARResourceManagerTools", 1, "startDowdLoad size is " + ((ArrayList)localObject).size());
    int i = 0;
    label129:
    if (i < paramArrayList.size())
    {
      if (((apmr)paramArrayList.get(i)).jdField_a_of_type_Int == 4) {
        break label187;
      }
      this.jdField_a_of_type_Apmn.a((apmr)paramArrayList.get(i), new apmt(this, paramapmv, paramArrayList, (ArrayList)localObject));
    }
    for (;;)
    {
      i += 1;
      break label129;
      break;
      label187:
      if (((apmr)paramArrayList.get(i)).jdField_a_of_type_Int == 4)
      {
        nuz.a();
        localapmr = (apmr)paramArrayList.get(i);
        nuz.a(((apmr)paramArrayList.get(i)).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface, new apmu(this, paramapmv, (ArrayList)localObject, localapmr), true, 0, true);
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
    if (this.jdField_a_of_type_Apmn != null) {
      this.jdField_a_of_type_Apmn.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apms
 * JD-Core Version:    0.7.0.1
 */