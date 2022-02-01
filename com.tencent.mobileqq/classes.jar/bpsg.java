import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class bpsg
{
  private DynamicTextConfigManager jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager;
  private ConcurrentHashMap<String, ArrayList<WeakReference<bpsi>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bpsg(DynamicTextConfigManager paramDynamicTextConfigManager)
  {
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = paramDynamicTextConfigManager;
  }
  
  private void a(bpsf parambpsf)
  {
    if ((parambpsf == null) || (TextUtils.isEmpty(parambpsf.c))) {}
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
        if ((parambpsf.c.equalsIgnoreCase(str2)) && (!str1.equalsIgnoreCase(parambpsf.a()))) {
          localFile.delete();
        }
      }
    }
  }
  
  public void a(@NonNull bpsf parambpsf, bpsi parambpsi)
  {
    if ((parambpsf == null) || (TextUtils.isEmpty(parambpsf.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "startDownloadDynamicTextRes fontInfo is null or resUrl is empty.");
      }
      return;
    }
    Object localObject = parambpsf.jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "startDownloadDynamicText res url: " + (String)localObject);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
        {
          parambpsf = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
          localObject = parambpsf.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label268;
          }
          if (((WeakReference)((Iterator)localObject).next()).get() != parambpsi) {
            continue;
          }
          i = 1;
          if (i == 0) {
            parambpsf.add(new WeakReference(parambpsi));
          }
          return;
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new WeakReference(parambpsi));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localArrayList);
      parambpsi = new beum();
      parambpsi.jdField_a_of_type_Beuq = new bpsh(this);
      parambpsi.jdField_a_of_type_JavaLangString = ((String)localObject);
      parambpsi.jdField_a_of_type_Int = 0;
      parambpsi.c = DynamicTextConfigManager.a(parambpsf);
      parambpsi.b = bhnv.a(bevn.a().a());
      parambpsi.a(parambpsf);
      lbk.a().a(parambpsi);
      return;
      label268:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpsg
 * JD-Core Version:    0.7.0.1
 */