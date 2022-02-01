import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.apollo.utils.task.TaskFlowEngine.1;
import com.tencent.mobileqq.apollo.utils.task.TaskFlowEngine.2;
import com.tencent.mobileqq.mini.util.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class anms
  implements Handler.Callback, anmq
{
  private anmu jdField_a_of_type_Anmu;
  private final List<anmt> jdField_a_of_type_JavaUtilList = new ArrayList();
  private anmp[] jdField_a_of_type_ArrayOfAnmp;
  private List<anmp> b = new ArrayList();
  
  public anms()
  {
    try
    {
      int j = DeviceInfoUtil.getNumberOfCPUCores();
      QLog.w("TaskFlow", 1, "create thread pool, cpuCores=" + j);
      if (j > 0) {
        i = j + 1;
      }
      this.jdField_a_of_type_Anmu = new anmu("TaskFlowEngine", 2, i);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TaskFlow", 1, "create thread pool error!", localException);
    }
  }
  
  private void d(anmp paramanmp)
  {
    if (paramanmp == null) {}
    for (;;)
    {
      return;
      paramanmp.a(this);
      if (!this.b.contains(paramanmp)) {
        this.b.add(paramanmp);
      }
      paramanmp = paramanmp.a();
      if ((paramanmp != null) && (paramanmp.size() > 0))
      {
        paramanmp = paramanmp.iterator();
        while (paramanmp.hasNext()) {
          d((anmp)paramanmp.next());
        }
      }
    }
  }
  
  private void e(anmp arg1)
  {
    if (??? == null) {
      return;
    }
    List localList = ???.a();
    if ((localList == null) || (localList.size() <= 0))
    {
      ???.c();
      return;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (((anmt)((Iterator)localObject2).next()).a != ???);
    for (int i = 1;; i = 0) {
      for (;;)
      {
        if (i == 0) {
          localObject2 = new anmt(this, ???, localList);
        }
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          ??? = localList.iterator();
          if (!???.hasNext()) {
            break;
          }
          e((anmp)???.next());
        }
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ArrayOfAnmp == null) || (this.jdField_a_of_type_ArrayOfAnmp.length <= 0)) {
      return;
    }
    this.jdField_a_of_type_Anmu.a(new TaskFlowEngine.1(this));
  }
  
  public void a(anmp paramanmp)
  {
    if (paramanmp == null) {}
    while (!paramanmp.b()) {
      return;
    }
    this.jdField_a_of_type_Anmu.a(new TaskFlowEngine.2(this, paramanmp));
  }
  
  public final void a(anmp[] paramArrayOfanmp)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.b.clear();
    this.jdField_a_of_type_ArrayOfAnmp = paramArrayOfanmp;
    if (this.jdField_a_of_type_ArrayOfAnmp == null) {}
    for (;;)
    {
      return;
      paramArrayOfanmp = this.jdField_a_of_type_ArrayOfAnmp;
      int j = paramArrayOfanmp.length;
      int i = 0;
      while (i < j)
      {
        d(paramArrayOfanmp[i]);
        i += 1;
      }
    }
  }
  
  public void b(anmp paramanmp) {}
  
  public void c(anmp paramanmp)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        anmt localanmt = (anmt)localIterator.next();
        if (localanmt.a(paramanmp)) {
          localanmt.a();
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anms
 * JD-Core Version:    0.7.0.1
 */