import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class blrg
{
  private blrc jdField_a_of_type_Blrc;
  private ConcurrentHashMap<String, ArrayList<WeakReference<blrf>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public blrg(blrc paramblrc)
  {
    this.jdField_a_of_type_Blrc = paramblrc;
  }
  
  public void a(@NonNull bmrn parambmrn, blrf paramblrf)
  {
    String str = parambmrn.e;
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
          parambmrn = localArrayList.iterator();
          if (!parambmrn.hasNext()) {
            break label292;
          }
          if (((WeakReference)parambmrn.next()).get() != paramblrf) {
            continue;
          }
          i = 1;
          if (i == 0) {
            localArrayList.add(new WeakReference(paramblrf));
          }
          if (QLog.isColorLevel()) {
            QLog.i("QIMInformationPasterManager", 2, "already put url " + str);
          }
          return;
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new WeakReference(paramblrf));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localArrayList);
      paramblrf = new baps();
      paramblrf.jdField_a_of_type_Bapx = new blrh(this);
      paramblrf.jdField_a_of_type_JavaLangString = str;
      paramblrf.jdField_a_of_type_Int = 0;
      paramblrf.jdField_c_of_type_JavaLangString = blrc.a(parambmrn);
      paramblrf.jdField_c_of_type_Int = bdee.a(baqx.a().a());
      paramblrf.a(parambmrn);
      lel.a().a(paramblrf);
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
 * Qualified Name:     blrg
 * JD-Core Version:    0.7.0.1
 */