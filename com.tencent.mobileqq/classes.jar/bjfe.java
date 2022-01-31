import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class bjfe
{
  private bjfa jdField_a_of_type_Bjfa;
  private ConcurrentHashMap<String, ArrayList<WeakReference<bjfd>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bjfe(bjfa parambjfa)
  {
    this.jdField_a_of_type_Bjfa = parambjfa;
  }
  
  public void a(@NonNull bkfm parambkfm, bjfd parambjfd)
  {
    String str = parambkfm.e;
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
          parambkfm = localArrayList.iterator();
          if (!parambkfm.hasNext()) {
            break label292;
          }
          if (((WeakReference)parambkfm.next()).get() != parambjfd) {
            continue;
          }
          i = 1;
          if (i == 0) {
            localArrayList.add(new WeakReference(parambjfd));
          }
          if (QLog.isColorLevel()) {
            QLog.i("QIMInformationPasterManager", 2, "already put url " + str);
          }
          return;
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new WeakReference(parambjfd));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localArrayList);
      parambjfd = new ayrv();
      parambjfd.jdField_a_of_type_Aysa = new bjff(this);
      parambjfd.jdField_a_of_type_JavaLangString = str;
      parambjfd.jdField_a_of_type_Int = 0;
      parambjfd.jdField_c_of_type_JavaLangString = bjfa.a(parambkfm);
      parambjfd.jdField_c_of_type_Int = bbev.a(aysy.a().a());
      parambjfd.a(parambkfm);
      lcm.a().a(parambjfd);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfe
 * JD-Core Version:    0.7.0.1
 */