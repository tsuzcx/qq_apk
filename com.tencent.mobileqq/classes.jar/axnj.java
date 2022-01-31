import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class axnj
  implements axng
{
  axnj(axni paramaxni, axnc paramaxnc) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    synchronized (axni.a(this.jdField_a_of_type_Axni))
    {
      Object localObject2 = (List)axni.a(this.jdField_a_of_type_Axni).get(this.jdField_a_of_type_Axnc);
      axni.a(this.jdField_a_of_type_Axni).remove(this.jdField_a_of_type_Axnc);
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoLoadManager", 2, "load resCode=" + paramInt + ", loadExtResult=" + paramLoadExtResult + ",loadParam=" + this.jdField_a_of_type_Axnc + ",ls=" + localObject2);
      }
      if (localObject2 != null)
      {
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (axng)((Iterator)???).next();
          if (localObject2 != null) {
            ((axng)localObject2).onLoadResult(paramInt, paramLoadExtResult);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnj
 * JD-Core Version:    0.7.0.1
 */