import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aogw
{
  int jdField_a_of_type_Int;
  public aood a;
  String jdField_a_of_type_JavaLangString;
  public HashMap<String, ArrayList<MessageRecord>> a;
  List<aogt> jdField_a_of_type_JavaUtilList;
  List<aogt> b;
  List<aogt> c;
  public List<aogt> d;
  List<aogt> e;
  
  public aogw(String paramString, aood paramaood, HashMap<String, ArrayList<MessageRecord>> paramHashMap)
  {
    this.jdField_a_of_type_JavaLangString = paramaood;
    this.jdField_a_of_type_Aood = paramHashMap;
    this.jdField_a_of_type_Int = 0;
    Object localObject;
    this.jdField_a_of_type_JavaUtilHashMap = localObject;
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
      ((aogt)localIterator.next()).a();
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(aogt paramaogt)
  {
    if (paramaogt != null) {
      this.b.add(paramaogt);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aogt)localIterator.next()).b();
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
        aogt localaogt = (aogt)this.b.get(j);
        this.jdField_a_of_type_JavaUtilList.add(localaogt);
        localArrayList.add(localaogt);
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
    aogt localaogt;
    if (localIterator.hasNext())
    {
      localaogt = (aogt)localIterator.next();
      if ((localaogt.b == 2) || (localaogt.b == 3) || (localaogt.b == 4)) {
        localIterator.remove();
      }
      if (localaogt.b == 2)
      {
        this.c.add(localaogt);
        i += 1;
      }
    }
    for (;;)
    {
      break;
      if (localaogt.b == 3)
      {
        this.e.add(localaogt);
        i += 1;
      }
      else if (localaogt.b == 4)
      {
        this.d.add(localaogt);
        i += 1;
        continue;
        c();
        if (QLog.isColorLevel())
        {
          int n = this.jdField_a_of_type_JavaUtilList.size();
          int i1 = this.b.size();
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "request update, forwardSeq[ " + this.jdField_a_of_type_JavaLangString + "] removeCount[" + i + "] leftCount[" + (n + i1) + "] finishCount[" + (m + (j + k)) + "]");
        }
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          ((aogt)localIterator.next()).a();
        }
        if ((this.jdField_a_of_type_JavaUtilList.size() <= 0) && (this.b.size() <= 0))
        {
          this.jdField_a_of_type_Int = 5;
          if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "all task upload finish , remove multi request: forwardSeq[ " + this.jdField_a_of_type_JavaLangString + "]");
          }
          aofz.a(this.jdField_a_of_type_Aofz, this.jdField_a_of_type_JavaLangString);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aogw
 * JD-Core Version:    0.7.0.1
 */