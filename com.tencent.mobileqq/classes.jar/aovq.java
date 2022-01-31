import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aovq
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public astr a;
  public asue a;
  public HashMap<String, ArrayList<MessageRecord>> a;
  List<aovo> jdField_a_of_type_JavaUtilList;
  List<aovo> b;
  List<aovo> c;
  public List<aovo> d;
  List<aovo> e;
  
  public aovq(long paramLong, asue paramasue, HashMap<String, ArrayList<MessageRecord>> paramHashMap, astr paramastr)
  {
    this.jdField_a_of_type_Long = ???;
    this.jdField_a_of_type_Asue = paramHashMap;
    this.jdField_a_of_type_Int = 0;
    Object localObject;
    this.jdField_a_of_type_Astr = localObject;
    this.jdField_a_of_type_JavaUtilHashMap = paramastr;
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
      ((aovo)localIterator.next()).a();
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(aovo paramaovo)
  {
    if (paramaovo != null) {
      this.b.add(paramaovo);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aovo)localIterator.next()).b();
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
        aovo localaovo = (aovo)this.b.get(j);
        this.jdField_a_of_type_JavaUtilList.add(localaovo);
        localArrayList.add(localaovo);
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
    aovo localaovo;
    if (localIterator.hasNext())
    {
      localaovo = (aovo)localIterator.next();
      if ((localaovo.b == 2) || (localaovo.b == 3) || (localaovo.b == 4)) {
        localIterator.remove();
      }
      if (localaovo.b == 2)
      {
        this.c.add(localaovo);
        i += 1;
      }
    }
    for (;;)
    {
      break;
      if (localaovo.b == 3)
      {
        this.e.add(localaovo);
        i += 1;
      }
      else if (localaovo.b == 4)
      {
        this.d.add(localaovo);
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
          ((aovo)localIterator.next()).a();
        }
        if ((this.jdField_a_of_type_JavaUtilList.size() <= 0) && (this.b.size() <= 0))
        {
          this.jdField_a_of_type_Int = 5;
          if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "all task upload finish , remove multi request: multiUniseq[ " + this.jdField_a_of_type_Long + "]");
          }
          aouu.a(this.jdField_a_of_type_Aouu, this.jdField_a_of_type_Long);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovq
 * JD-Core Version:    0.7.0.1
 */