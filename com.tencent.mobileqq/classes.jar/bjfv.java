import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class bjfv
{
  private bjfr jdField_a_of_type_Bjfr;
  private ConcurrentHashMap<String, ArrayList<WeakReference<bjfu>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bjfv(bjfr parambjfr)
  {
    this.jdField_a_of_type_Bjfr = parambjfr;
  }
  
  public void a(@NonNull bkgd parambkgd, bjfu parambjfu)
  {
    String str = parambkgd.e;
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
          parambkgd = localArrayList.iterator();
          if (!parambkgd.hasNext()) {
            break label292;
          }
          if (((WeakReference)parambkgd.next()).get() != parambjfu) {
            continue;
          }
          i = 1;
          if (i == 0) {
            localArrayList.add(new WeakReference(parambjfu));
          }
          if (QLog.isColorLevel()) {
            QLog.i("QIMInformationPasterManager", 2, "already put url " + str);
          }
          return;
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new WeakReference(parambjfu));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localArrayList);
      parambjfu = new ayrx();
      parambjfu.jdField_a_of_type_Aysc = new bjfw(this);
      parambjfu.jdField_a_of_type_JavaLangString = str;
      parambjfu.jdField_a_of_type_Int = 0;
      parambjfu.jdField_c_of_type_JavaLangString = bjfr.a(parambkgd);
      parambjfu.jdField_c_of_type_Int = bbfj.a(ayta.a().a());
      parambjfu.a(parambkgd);
      lch.a().a(parambjfu);
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
 * Qualified Name:     bjfv
 * JD-Core Version:    0.7.0.1
 */