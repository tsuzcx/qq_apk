import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class axnh
  implements axne
{
  axnh(axng paramaxng, axna paramaxna) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    synchronized (axng.a(this.jdField_a_of_type_Axng))
    {
      Object localObject2 = (List)axng.a(this.jdField_a_of_type_Axng).get(this.jdField_a_of_type_Axna);
      axng.a(this.jdField_a_of_type_Axng).remove(this.jdField_a_of_type_Axna);
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoLoadManager", 2, "load resCode=" + paramInt + ", loadExtResult=" + paramLoadExtResult + ",loadParam=" + this.jdField_a_of_type_Axna + ",ls=" + localObject2);
      }
      if (localObject2 != null)
      {
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (axne)((Iterator)???).next();
          if (localObject2 != null) {
            ((axne)localObject2).onLoadResult(paramInt, paramLoadExtResult);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnh
 * JD-Core Version:    0.7.0.1
 */