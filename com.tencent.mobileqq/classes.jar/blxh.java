import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class blxh
{
  private DynamicTextConfigManager jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager;
  private ConcurrentHashMap<String, ArrayList<WeakReference<blxj>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public blxh(DynamicTextConfigManager paramDynamicTextConfigManager)
  {
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = paramDynamicTextConfigManager;
  }
  
  private void a(blxg paramblxg)
  {
    if ((paramblxg == null) || (TextUtils.isEmpty(paramblxg.jdField_c_of_type_JavaLangString))) {}
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
        if ((paramblxg.jdField_c_of_type_JavaLangString.equalsIgnoreCase(str2)) && (!str1.equalsIgnoreCase(paramblxg.a()))) {
          localFile.delete();
        }
      }
    }
  }
  
  public void a(@NonNull blxg paramblxg, blxj paramblxj)
  {
    if ((paramblxg == null) || (TextUtils.isEmpty(paramblxg.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "startDownloadDynamicTextRes fontInfo is null or resUrl is empty.");
      }
      return;
    }
    Object localObject = paramblxg.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "startDownloadDynamicText res url: " + (String)localObject);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
        {
          paramblxg = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
          localObject = paramblxg.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label268;
          }
          if (((WeakReference)((Iterator)localObject).next()).get() != paramblxj) {
            continue;
          }
          i = 1;
          if (i == 0) {
            paramblxg.add(new WeakReference(paramblxj));
          }
          return;
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new WeakReference(paramblxj));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localArrayList);
      paramblxj = new baub();
      paramblxj.jdField_a_of_type_Baug = new blxi(this);
      paramblxj.jdField_a_of_type_JavaLangString = ((String)localObject);
      paramblxj.jdField_a_of_type_Int = 0;
      paramblxj.jdField_c_of_type_JavaLangString = DynamicTextConfigManager.a(paramblxg);
      paramblxj.jdField_c_of_type_Int = bdin.a(bavg.a().a());
      paramblxj.a(paramblxg);
      lel.a().a(paramblxj);
      return;
      label268:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxh
 * JD-Core Version:    0.7.0.1
 */