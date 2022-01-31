import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aovu
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public astt a;
  public asug a;
  public HashMap<String, ArrayList<MessageRecord>> a;
  List<aovs> jdField_a_of_type_JavaUtilList;
  List<aovs> b;
  List<aovs> c;
  public List<aovs> d;
  List<aovs> e;
  
  public aovu(long paramLong, asug paramasug, HashMap<String, ArrayList<MessageRecord>> paramHashMap, astt paramastt)
  {
    this.jdField_a_of_type_Long = ???;
    this.jdField_a_of_type_Asug = paramHashMap;
    this.jdField_a_of_type_Int = 0;
    Object localObject;
    this.jdField_a_of_type_Astt = localObject;
    this.jdField_a_of_type_JavaUtilHashMap = paramastt;
    this.b = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.c = new ArrayList();
    this.d = new ArrayList();
    this.e = new ArrayList();
  }
  
  public int a()
  {
    return this.b.size();
  }
  
  public void a()
  {
    c();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aovs)localIterator.next()).a();
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(aovs paramaovs)
  {
    if (paramaovs != null) {
      this.b.add(paramaovs);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aovs)localIterator.next()).b();
    }
    this.jdField_a_of_type_Int = 5;
  }
  
  void c()
  {
    if (10 <= this.b.size()) {}
    ArrayList localArrayList;
    for (int i = 10;; i = this.b.size())
    {
      localArrayList = new ArrayList(i);
      int j = 0;
      while (j < i)
      {
        aovs localaovs = (aovs)this.b.get(j);
        this.jdField_a_of_type_JavaUtilList.add(localaovs);
        localArrayList.add(localaovs);
        j += 1;
      }
    }
    this.b.removeAll(localArrayList);
  }
  
  public void d()
  {
    int j = this.c.size();
    int k = this.e.size();
    int m = this.d.size();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    aovs localaovs;
    if (localIterator.hasNext())
    {
      localaovs = (aovs)localIterator.next();
      if ((localaovs.b == 2) || (localaovs.b == 3) || (localaovs.b == 4)) {
        localIterator.remove();
      }
      if (localaovs.b == 2)
      {
        this.c.add(localaovs);
        i += 1;
      }
    }
    for (;;)
    {
      break;
      if (localaovs.b == 3)
      {
        this.e.add(localaovs);
        i += 1;
      }
      else if (localaovs.b == 4)
      {
        this.d.add(localaovs);
        i += 1;
        continue;
        c();
        if (QLog.isColorLevel())
        {
          int n = this.jdField_a_of_type_JavaUtilList.size();
          int i1 = this.b.size();
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "request update, multiUniseq[ " + this.jdField_a_of_type_Long + "] removeCount[" + i + "] leftCount[" + (n + i1) + "] finishCount[" + (m + (j + k)) + "]");
        }
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((aovs)localIterator.next()).a();
        }
        if ((this.jdField_a_of_type_JavaUtilList.size() <= 0) && (this.b.size() <= 0))
        {
          this.jdField_a_of_type_Int = 5;
          if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "all task upload finish , remove multi request: multiUniseq[ " + this.jdField_a_of_type_Long + "]");
          }
          aouy.a(this.jdField_a_of_type_Aouy, this.jdField_a_of_type_Long);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovu
 * JD-Core Version:    0.7.0.1
 */