import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aqtb
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public auoz a;
  public aupm a;
  public HashMap<String, ArrayList<MessageRecord>> a;
  List<aqsz> jdField_a_of_type_JavaUtilList;
  List<aqsz> b;
  List<aqsz> c;
  public List<aqsz> d;
  List<aqsz> e;
  
  public aqtb(long paramLong, aupm paramaupm, HashMap<String, ArrayList<MessageRecord>> paramHashMap, auoz paramauoz)
  {
    this.jdField_a_of_type_Long = ???;
    this.jdField_a_of_type_Aupm = paramHashMap;
    this.jdField_a_of_type_Int = 0;
    Object localObject;
    this.jdField_a_of_type_Auoz = localObject;
    this.jdField_a_of_type_JavaUtilHashMap = paramauoz;
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
      ((aqsz)localIterator.next()).a();
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(aqsz paramaqsz)
  {
    if (paramaqsz != null) {
      this.b.add(paramaqsz);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aqsz)localIterator.next()).b();
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
        aqsz localaqsz = (aqsz)this.b.get(j);
        this.jdField_a_of_type_JavaUtilList.add(localaqsz);
        localArrayList.add(localaqsz);
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
    aqsz localaqsz;
    if (localIterator.hasNext())
    {
      localaqsz = (aqsz)localIterator.next();
      if ((localaqsz.b == 2) || (localaqsz.b == 3) || (localaqsz.b == 4)) {
        localIterator.remove();
      }
      if (localaqsz.b == 2)
      {
        this.c.add(localaqsz);
        i += 1;
      }
    }
    for (;;)
    {
      break;
      if (localaqsz.b == 3)
      {
        this.e.add(localaqsz);
        i += 1;
      }
      else if (localaqsz.b == 4)
      {
        this.d.add(localaqsz);
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
          ((aqsz)localIterator.next()).a();
        }
        if ((this.jdField_a_of_type_JavaUtilList.size() <= 0) && (this.b.size() <= 0))
        {
          this.jdField_a_of_type_Int = 5;
          if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "all task upload finish , remove multi request: multiUniseq[ " + this.jdField_a_of_type_Long + "]");
          }
          aqsf.a(this.jdField_a_of_type_Aqsf, this.jdField_a_of_type_Long);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqtb
 * JD-Core Version:    0.7.0.1
 */