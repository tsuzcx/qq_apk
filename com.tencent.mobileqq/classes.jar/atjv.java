import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class atjv
{
  int jdField_a_of_type_Int;
  public atqd a;
  String jdField_a_of_type_JavaLangString;
  public HashMap<String, ArrayList<MessageRecord>> a;
  List<atjs> jdField_a_of_type_JavaUtilList;
  List<atjs> b;
  List<atjs> c;
  public List<atjs> d;
  List<atjs> e;
  
  public atjv(String paramString, atqd paramatqd, HashMap<String, ArrayList<MessageRecord>> paramHashMap)
  {
    this.jdField_a_of_type_JavaLangString = paramatqd;
    this.jdField_a_of_type_Atqd = paramHashMap;
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
      ((atjs)localIterator.next()).a();
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(atjs paramatjs)
  {
    if (paramatjs != null) {
      this.b.add(paramatjs);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((atjs)localIterator.next()).b();
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
        atjs localatjs = (atjs)this.b.get(j);
        this.jdField_a_of_type_JavaUtilList.add(localatjs);
        localArrayList.add(localatjs);
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
    atjs localatjs;
    if (localIterator.hasNext())
    {
      localatjs = (atjs)localIterator.next();
      if ((localatjs.b == 2) || (localatjs.b == 3) || (localatjs.b == 4)) {
        localIterator.remove();
      }
      if (localatjs.b == 2)
      {
        this.c.add(localatjs);
        i += 1;
      }
    }
    for (;;)
    {
      break;
      if (localatjs.b == 3)
      {
        this.e.add(localatjs);
        i += 1;
      }
      else if (localatjs.b == 4)
      {
        this.d.add(localatjs);
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
          ((atjs)localIterator.next()).a();
        }
        if ((this.jdField_a_of_type_JavaUtilList.size() <= 0) && (this.b.size() <= 0))
        {
          this.jdField_a_of_type_Int = 5;
          if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "all task upload finish , remove multi request: forwardSeq[ " + this.jdField_a_of_type_JavaLangString + "]");
          }
          atiy.a(this.jdField_a_of_type_Atiy, this.jdField_a_of_type_JavaLangString);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjv
 * JD-Core Version:    0.7.0.1
 */