import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class boow
{
  private boos jdField_a_of_type_Boos;
  private ConcurrentHashMap<String, ArrayList<WeakReference<boov>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public boow(boos paramboos)
  {
    this.jdField_a_of_type_Boos = paramboos;
  }
  
  public void a(@NonNull bpnf parambpnf, boov paramboov)
  {
    String str = parambpnf.e;
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
          parambpnf = localArrayList.iterator();
          if (!parambpnf.hasNext()) {
            break label292;
          }
          if (((WeakReference)parambpnf.next()).get() != paramboov) {
            continue;
          }
          i = 1;
          if (i == 0) {
            localArrayList.add(new WeakReference(paramboov));
          }
          if (QLog.isColorLevel()) {
            QLog.i("QIMInformationPasterManager", 2, "already put url " + str);
          }
          return;
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new WeakReference(paramboov));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localArrayList);
      paramboov = new bdvs();
      paramboov.jdField_a_of_type_Bdvw = new boox(this);
      paramboov.jdField_a_of_type_JavaLangString = str;
      paramboov.jdField_a_of_type_Int = 0;
      paramboov.c = boos.a(parambpnf);
      paramboov.b = bgnt.a(bdwu.a().a());
      paramboov.a(parambpnf);
      lbd.a().a(paramboov);
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
 * Qualified Name:     boow
 * JD-Core Version:    0.7.0.1
 */