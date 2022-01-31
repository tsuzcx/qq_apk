import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class azmz
  implements azmw
{
  azmz(azmy paramazmy, azms paramazms) {}
  
  public void a(int paramInt, LoadExtResult paramLoadExtResult)
  {
    synchronized (azmy.a(this.jdField_a_of_type_Azmy))
    {
      Object localObject2 = (List)azmy.a(this.jdField_a_of_type_Azmy).get(this.jdField_a_of_type_Azms);
      azmy.a(this.jdField_a_of_type_Azmy).remove(this.jdField_a_of_type_Azms);
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoLoadManager", 2, "load resCode=" + paramInt + ", loadExtResult=" + paramLoadExtResult + ",loadParam=" + this.jdField_a_of_type_Azms + ",ls=" + localObject2);
      }
      if (localObject2 != null)
      {
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (azmw)((Iterator)???).next();
          if (localObject2 != null) {
            ((azmw)localObject2).a(paramInt, paramLoadExtResult);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmz
 * JD-Core Version:    0.7.0.1
 */