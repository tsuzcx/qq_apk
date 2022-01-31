import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class bhmb
{
  private DynamicTextConfigManager jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager;
  private ConcurrentHashMap<String, ArrayList<WeakReference<bhmd>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bhmb(DynamicTextConfigManager paramDynamicTextConfigManager)
  {
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = paramDynamicTextConfigManager;
  }
  
  private void a(bhma parambhma)
  {
    if ((parambhma == null) || (TextUtils.isEmpty(parambhma.jdField_c_of_type_JavaLangString))) {}
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
        if ((parambhma.jdField_c_of_type_JavaLangString.equalsIgnoreCase(str2)) && (!str1.equalsIgnoreCase(parambhma.a()))) {
          localFile.delete();
        }
      }
    }
  }
  
  public void a(@NonNull bhma parambhma, bhmd parambhmd)
  {
    if ((parambhma == null) || (TextUtils.isEmpty(parambhma.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "startDownloadDynamicTextRes fontInfo is null or resUrl is empty.");
      }
      return;
    }
    Object localObject = parambhma.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "startDownloadDynamicText res url: " + (String)localObject);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
        {
          parambhma = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
          localObject = parambhma.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label268;
          }
          if (((WeakReference)((Iterator)localObject).next()).get() != parambhmd) {
            continue;
          }
          i = 1;
          if (i == 0) {
            parambhma.add(new WeakReference(parambhmd));
          }
          return;
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new WeakReference(parambhmd));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localArrayList);
      parambhmd = new axro();
      parambhmd.jdField_a_of_type_Axrt = new bhmc(this);
      parambhmd.jdField_a_of_type_JavaLangString = ((String)localObject);
      parambhmd.jdField_a_of_type_Int = 0;
      parambhmd.jdField_c_of_type_JavaLangString = DynamicTextConfigManager.a(parambhma);
      parambhmd.jdField_c_of_type_Int = badq.a(axsr.a().a());
      parambhmd.a(parambhma);
      kry.a().a(parambhmd);
      return;
      label268:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhmb
 * JD-Core Version:    0.7.0.1
 */