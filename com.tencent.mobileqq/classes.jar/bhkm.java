import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class bhkm
{
  private bhki jdField_a_of_type_Bhki;
  private ConcurrentHashMap<String, ArrayList<WeakReference<bhkl>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bhkm(bhki parambhki)
  {
    this.jdField_a_of_type_Bhki = parambhki;
  }
  
  public void a(@NonNull bior parambior, bhkl parambhkl)
  {
    String str = parambior.e;
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
          parambior = localArrayList.iterator();
          if (!parambior.hasNext()) {
            break label292;
          }
          if (((WeakReference)parambior.next()).get() != parambhkl) {
            continue;
          }
          i = 1;
          if (i == 0) {
            localArrayList.add(new WeakReference(parambhkl));
          }
          if (QLog.isColorLevel()) {
            QLog.i("QIMInformationPasterManager", 2, "already put url " + str);
          }
          return;
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new WeakReference(parambhkl));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localArrayList);
      parambhkl = new axro();
      parambhkl.jdField_a_of_type_Axrt = new bhkn(this);
      parambhkl.jdField_a_of_type_JavaLangString = str;
      parambhkl.jdField_a_of_type_Int = 0;
      parambhkl.jdField_c_of_type_JavaLangString = bhki.a(parambior);
      parambhkl.jdField_c_of_type_Int = badq.a(axsr.a().a());
      parambhkl.a(parambior);
      kry.a().a(parambhkl);
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
 * Qualified Name:     bhkm
 * JD-Core Version:    0.7.0.1
 */