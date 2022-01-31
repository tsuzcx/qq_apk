import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aqqs
{
  int jdField_a_of_type_Int;
  public aqya a;
  String jdField_a_of_type_JavaLangString;
  public HashMap<String, ArrayList<MessageRecord>> a;
  List<aqqp> jdField_a_of_type_JavaUtilList;
  List<aqqp> b;
  List<aqqp> c;
  public List<aqqp> d;
  List<aqqp> e;
  
  public aqqs(String paramString, aqya paramaqya, HashMap<String, ArrayList<MessageRecord>> paramHashMap)
  {
    this.jdField_a_of_type_JavaLangString = paramaqya;
    this.jdField_a_of_type_Aqya = paramHashMap;
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
      ((aqqp)localIterator.next()).a();
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(aqqp paramaqqp)
  {
    if (paramaqqp != null) {
      this.b.add(paramaqqp);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aqqp)localIterator.next()).b();
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
        aqqp localaqqp = (aqqp)this.b.get(j);
        this.jdField_a_of_type_JavaUtilList.add(localaqqp);
        localArrayList.add(localaqqp);
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
    aqqp localaqqp;
    if (localIterator.hasNext())
    {
      localaqqp = (aqqp)localIterator.next();
      if ((localaqqp.b == 2) || (localaqqp.b == 3) || (localaqqp.b == 4)) {
        localIterator.remove();
      }
      if (localaqqp.b == 2)
      {
        this.c.add(localaqqp);
        i += 1;
      }
    }
    for (;;)
    {
      break;
      if (localaqqp.b == 3)
      {
        this.e.add(localaqqp);
        i += 1;
      }
      else if (localaqqp.b == 4)
      {
        this.d.add(localaqqp);
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
          ((aqqp)localIterator.next()).a();
        }
        if ((this.jdField_a_of_type_JavaUtilList.size() <= 0) && (this.b.size() <= 0))
        {
          this.jdField_a_of_type_Int = 5;
          if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "all task upload finish , remove multi request: forwardSeq[ " + this.jdField_a_of_type_JavaLangString + "]");
          }
          aqpv.a(this.jdField_a_of_type_Aqpv, this.jdField_a_of_type_JavaLangString);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqs
 * JD-Core Version:    0.7.0.1
 */