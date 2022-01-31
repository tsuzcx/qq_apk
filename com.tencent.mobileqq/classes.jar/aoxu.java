import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aoxu
{
  int jdField_a_of_type_Int;
  public apfc a;
  String jdField_a_of_type_JavaLangString;
  public HashMap<String, ArrayList<MessageRecord>> a;
  List<aoxr> jdField_a_of_type_JavaUtilList;
  List<aoxr> b;
  List<aoxr> c;
  public List<aoxr> d;
  List<aoxr> e;
  
  public aoxu(String paramString, apfc paramapfc, HashMap<String, ArrayList<MessageRecord>> paramHashMap)
  {
    this.jdField_a_of_type_JavaLangString = paramapfc;
    this.jdField_a_of_type_Apfc = paramHashMap;
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
      ((aoxr)localIterator.next()).a();
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(aoxr paramaoxr)
  {
    if (paramaoxr != null) {
      this.b.add(paramaoxr);
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aoxr)localIterator.next()).b();
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
        aoxr localaoxr = (aoxr)this.b.get(j);
        this.jdField_a_of_type_JavaUtilList.add(localaoxr);
        localArrayList.add(localaoxr);
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
    aoxr localaoxr;
    if (localIterator.hasNext())
    {
      localaoxr = (aoxr)localIterator.next();
      if ((localaoxr.b == 2) || (localaoxr.b == 3) || (localaoxr.b == 4)) {
        localIterator.remove();
      }
      if (localaoxr.b == 2)
      {
        this.c.add(localaoxr);
        i += 1;
      }
    }
    for (;;)
    {
      break;
      if (localaoxr.b == 3)
      {
        this.e.add(localaoxr);
        i += 1;
      }
      else if (localaoxr.b == 4)
      {
        this.d.add(localaoxr);
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
          ((aoxr)localIterator.next()).a();
        }
        if ((this.jdField_a_of_type_JavaUtilList.size() <= 0) && (this.b.size() <= 0))
        {
          this.jdField_a_of_type_Int = 5;
          if (QLog.isDevelopLevel()) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "all task upload finish , remove multi request: forwardSeq[ " + this.jdField_a_of_type_JavaLangString + "]");
          }
          aowx.a(this.jdField_a_of_type_Aowx, this.jdField_a_of_type_JavaLangString);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxu
 * JD-Core Version:    0.7.0.1
 */