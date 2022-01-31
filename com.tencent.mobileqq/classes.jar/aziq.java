import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class aziq
  implements azin
{
  aziq(azip paramazip, azij paramazij) {}
  
  public void a(int paramInt, LoadExtResult paramLoadExtResult)
  {
    synchronized (azip.a(this.jdField_a_of_type_Azip))
    {
      Object localObject2 = (List)azip.a(this.jdField_a_of_type_Azip).get(this.jdField_a_of_type_Azij);
      azip.a(this.jdField_a_of_type_Azip).remove(this.jdField_a_of_type_Azij);
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoLoadManager", 2, "load resCode=" + paramInt + ", loadExtResult=" + paramLoadExtResult + ",loadParam=" + this.jdField_a_of_type_Azij + ",ls=" + localObject2);
      }
      if (localObject2 != null)
      {
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (azin)((Iterator)???).next();
          if (localObject2 != null) {
            ((azin)localObject2).a(paramInt, paramLoadExtResult);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aziq
 * JD-Core Version:    0.7.0.1
 */