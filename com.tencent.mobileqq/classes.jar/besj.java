import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.soload.LoadExtResult;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

class besj
  implements besg
{
  besj(besi parambesi, besc parambesc) {}
  
  public void a(int paramInt, LoadExtResult paramLoadExtResult)
  {
    synchronized (besi.a(this.jdField_a_of_type_Besi))
    {
      Object localObject2 = (List)besi.a(this.jdField_a_of_type_Besi).get(this.jdField_a_of_type_Besc);
      besi.a(this.jdField_a_of_type_Besi).remove(this.jdField_a_of_type_Besc);
      if (paramInt != 7) {
        ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this.jdField_a_of_type_Besc);
      }
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoLoadManager", 2, "load resCode=" + paramInt + ", loadExtResult=" + paramLoadExtResult + ",loadParam=" + this.jdField_a_of_type_Besc + ",ls=" + localObject2);
      }
      if (localObject2 != null)
      {
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (besg)((Iterator)???).next();
          if (localObject2 != null) {
            ((besg)localObject2).a(paramInt, paramLoadExtResult);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     besj
 * JD-Core Version:    0.7.0.1
 */