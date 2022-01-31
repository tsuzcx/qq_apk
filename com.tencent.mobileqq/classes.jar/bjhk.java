import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class bjhk
{
  private DynamicTextConfigManager jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager;
  private ConcurrentHashMap<String, ArrayList<WeakReference<bjhm>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bjhk(DynamicTextConfigManager paramDynamicTextConfigManager)
  {
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = paramDynamicTextConfigManager;
  }
  
  private void a(bjhj parambjhj)
  {
    if ((parambjhj == null) || (TextUtils.isEmpty(parambjhj.jdField_c_of_type_JavaLangString))) {}
    File[] arrayOfFile;
    do
    {
      return;
      arrayOfFile = DynamicTextConfigManager.a.listFiles();
    } while ((arrayOfFile == null) || (arrayOfFile.length == 0));
    int j = arrayOfFile.length;
    int i = 0;
    label40:
    File localFile;
    if (i < j)
    {
      localFile = arrayOfFile[i];
      if (localFile != null) {
        break label63;
      }
    }
    for (;;)
    {
      i += 1;
      break label40;
      break;
      label63:
      String str1 = localFile.getName();
      if (TextUtils.isEmpty(str1)) {
        localFile.delete();
      }
      if (str1.contains("_"))
      {
        String str2 = str1.substring(0, str1.lastIndexOf("_"));
        if ((parambjhj.jdField_c_of_type_JavaLangString.equalsIgnoreCase(str2)) && (!str1.equalsIgnoreCase(parambjhj.a()))) {
          localFile.delete();
        }
      }
    }
  }
  
  public void a(@NonNull bjhj parambjhj, bjhm parambjhm)
  {
    if ((parambjhj == null) || (TextUtils.isEmpty(parambjhj.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "startDownloadDynamicTextRes fontInfo is null or resUrl is empty.");
      }
      return;
    }
    Object localObject = parambjhj.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "startDownloadDynamicText res url: " + (String)localObject);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
        {
          parambjhj = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
          localObject = parambjhj.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label268;
          }
          if (((WeakReference)((Iterator)localObject).next()).get() != parambjhm) {
            continue;
          }
          i = 1;
          if (i == 0) {
            parambjhj.add(new WeakReference(parambjhm));
          }
          return;
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new WeakReference(parambjhm));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localArrayList);
      parambjhm = new ayrx();
      parambjhm.jdField_a_of_type_Aysc = new bjhl(this);
      parambjhm.jdField_a_of_type_JavaLangString = ((String)localObject);
      parambjhm.jdField_a_of_type_Int = 0;
      parambjhm.jdField_c_of_type_JavaLangString = DynamicTextConfigManager.a(parambjhj);
      parambjhm.jdField_c_of_type_Int = bbfj.a(ayta.a().a());
      parambjhm.a(parambjhj);
      lch.a().a(parambjhm);
      return;
      label268:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjhk
 * JD-Core Version:    0.7.0.1
 */