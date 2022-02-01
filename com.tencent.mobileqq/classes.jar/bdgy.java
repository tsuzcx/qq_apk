import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class bdgy
  implements bdgt
{
  bdgy(bdgx parambdgx, LoadParam paramLoadParam) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    synchronized (bdgx.a(this.jdField_a_of_type_Bdgx))
    {
      Object localObject2 = (List)bdgx.a(this.jdField_a_of_type_Bdgx).get(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam);
      bdgx.a(this.jdField_a_of_type_Bdgx).remove(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam);
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoLoadManager", 2, "load resCode=" + paramInt + ", loadExtResult=" + paramLoadExtResult + ",loadParam=" + this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam + ",ls=" + localObject2);
      }
      if (localObject2 != null)
      {
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (bdgt)((Iterator)???).next();
          if (localObject2 != null) {
            ((bdgt)localObject2).onLoadResult(paramInt, paramLoadExtResult);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgy
 * JD-Core Version:    0.7.0.1
 */