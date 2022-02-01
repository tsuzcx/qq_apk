import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class bcog
  implements bcob
{
  bcog(bcof parambcof, LoadParam paramLoadParam) {}
  
  public void a(int paramInt, LoadExtResult paramLoadExtResult)
  {
    synchronized (bcof.a(this.jdField_a_of_type_Bcof))
    {
      Object localObject2 = (List)bcof.a(this.jdField_a_of_type_Bcof).get(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam);
      bcof.a(this.jdField_a_of_type_Bcof).remove(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam);
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoLoadManager", 2, "load resCode=" + paramInt + ", loadExtResult=" + paramLoadExtResult + ",loadParam=" + this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam + ",ls=" + localObject2);
      }
      if (localObject2 != null)
      {
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (bcob)((Iterator)???).next();
          if (localObject2 != null) {
            ((bcob)localObject2).a(paramInt, paramLoadExtResult);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcog
 * JD-Core Version:    0.7.0.1
 */