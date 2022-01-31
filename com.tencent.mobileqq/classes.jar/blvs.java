import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class blvs
{
  private blvo jdField_a_of_type_Blvo;
  private ConcurrentHashMap<String, ArrayList<WeakReference<blvr>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public blvs(blvo paramblvo)
  {
    this.jdField_a_of_type_Blvo = paramblvo;
  }
  
  public void a(@NonNull bmvz parambmvz, blvr paramblvr)
  {
    String str = parambmvz.e;
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
          parambmvz = localArrayList.iterator();
          if (!parambmvz.hasNext()) {
            break label292;
          }
          if (((WeakReference)parambmvz.next()).get() != paramblvr) {
            continue;
          }
          i = 1;
          if (i == 0) {
            localArrayList.add(new WeakReference(paramblvr));
          }
          if (QLog.isColorLevel()) {
            QLog.i("QIMInformationPasterManager", 2, "already put url " + str);
          }
          return;
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new WeakReference(paramblvr));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localArrayList);
      paramblvr = new baub();
      paramblvr.jdField_a_of_type_Baug = new blvt(this);
      paramblvr.jdField_a_of_type_JavaLangString = str;
      paramblvr.jdField_a_of_type_Int = 0;
      paramblvr.jdField_c_of_type_JavaLangString = blvo.a(parambmvz);
      paramblvr.jdField_c_of_type_Int = bdin.a(bavg.a().a());
      paramblvr.a(parambmvz);
      lel.a().a(paramblvr);
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
 * Qualified Name:     blvs
 * JD-Core Version:    0.7.0.1
 */