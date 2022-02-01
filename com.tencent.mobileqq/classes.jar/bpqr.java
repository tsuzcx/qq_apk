import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class bpqr
{
  private bpqn jdField_a_of_type_Bpqn;
  private ConcurrentHashMap<String, ArrayList<WeakReference<bpqq>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bpqr(bpqn parambpqn)
  {
    this.jdField_a_of_type_Bpqn = parambpqn;
  }
  
  public void a(@NonNull bqpa parambqpa, bpqq parambpqq)
  {
    String str = parambqpa.e;
    if ((str == null) || (TextUtils.isEmpty(str)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMInformationPasterManager", 2, "startDownloadDynamicTextRes fontInfo is null or resUrl is empty.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMInformationPasterManager", 2, "startDownloadDynamicText res url: " + str);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        if (localArrayList != null)
        {
          parambqpa = localArrayList.iterator();
          if (!parambqpa.hasNext()) {
            break label292;
          }
          if (((WeakReference)parambqpa.next()).get() != parambpqq) {
            continue;
          }
          i = 1;
          if (i == 0) {
            localArrayList.add(new WeakReference(parambpqq));
          }
          if (QLog.isColorLevel()) {
            QLog.i("QIMInformationPasterManager", 2, "already put url " + str);
          }
          return;
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new WeakReference(parambpqq));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localArrayList);
      parambpqq = new beum();
      parambpqq.jdField_a_of_type_Beuq = new bpqs(this);
      parambpqq.jdField_a_of_type_JavaLangString = str;
      parambpqq.jdField_a_of_type_Int = 0;
      parambpqq.c = bpqn.a(parambqpa);
      parambpqq.b = bhnv.a(bevn.a().a());
      parambpqq.a(parambqpa);
      lbk.a().a(parambpqq);
      return;
      label292:
      int i = 0;
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqr
 * JD-Core Version:    0.7.0.1
 */