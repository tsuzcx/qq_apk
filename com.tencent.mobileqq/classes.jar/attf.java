import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class attf
{
  int jdField_a_of_type_Int;
  public atzn a;
  String jdField_a_of_type_JavaLangString;
  public HashMap<String, ArrayList<MessageRecord>> a;
  List<attc> jdField_a_of_type_JavaUtilList;
  List<attc> b;
  List<attc> c;
  public List<attc> d;
  List<attc> e;
  
  public attf(String paramString, atzn paramatzn, HashMap<String, ArrayList<MessageRecord>> paramHashMap)
  {
    this.jdField_a_of_type_JavaLangString = paramatzn;
    this.jdField_a_of_type_Atzn = paramHashMap;
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
      ((attc)localIterator.next()).a();
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(attc paramattc)
  {
    if (paramattc != null) {
      this.b.add(paramattc);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((attc)localIterator.next()).b();
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
        attc localattc = (attc)this.b.get(j);
        this.jdField_a_of_type_JavaUtilList.add(localattc);
        localArrayList.add(localattc);
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
    attc localattc;
    if (localIterator.hasNext())
    {
      localattc = (attc)localIterator.next();
      if ((localattc.b == 2) || (localattc.b == 3) || (localattc.b == 4)) {
        localIterator.remove();
      }
      if (localattc.b == 2)
      {
        this.c.add(localattc);
        i += 1;
      }
    }
    for (;;)
    {
      break;
      if (localattc.b == 3)
      {
        this.e.add(localattc);
        i += 1;
      }
      else if (localattc.b == 4)
      {
        this.d.add(localattc);
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
          ((attc)localIterator.next()).a();
        }
        if ((this.jdField_a_of_type_JavaUtilList.size() <= 0) && (this.b.size() <= 0))
        {
          this.jdField_a_of_type_Int = 5;
          if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "all task upload finish , remove multi request: forwardSeq[ " + this.jdField_a_of_type_JavaLangString + "]");
          }
          atsi.a(this.jdField_a_of_type_Atsi, this.jdField_a_of_type_JavaLangString);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     attf
 * JD-Core Version:    0.7.0.1
 */