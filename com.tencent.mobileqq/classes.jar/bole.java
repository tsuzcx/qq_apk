import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class bole
{
  private DynamicTextConfigManager jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager;
  private ConcurrentHashMap<String, ArrayList<WeakReference<bolg>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bole(DynamicTextConfigManager paramDynamicTextConfigManager)
  {
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = paramDynamicTextConfigManager;
  }
  
  private void a(bold parambold)
  {
    if ((parambold == null) || (TextUtils.isEmpty(parambold.c))) {}
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
        if ((parambold.c.equalsIgnoreCase(str2)) && (!str1.equalsIgnoreCase(parambold.a()))) {
          localFile.delete();
        }
      }
    }
  }
  
  public void a(@NonNull bold parambold, bolg parambolg)
  {
    if ((parambold == null) || (TextUtils.isEmpty(parambold.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DText", 2, "startDownloadDynamicTextRes fontInfo is null or resUrl is empty.");
      }
      return;
    }
    Object localObject = parambold.a;
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "startDownloadDynamicText res url: " + (String)localObject);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
        {
          parambold = (ArrayList)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
          localObject = parambold.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label268;
          }
          if (((WeakReference)((Iterator)localObject).next()).get() != parambolg) {
            continue;
          }
          i = 1;
          if (i == 0) {
            parambold.add(new WeakReference(parambolg));
          }
          return;
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new WeakReference(parambolg));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localArrayList);
      parambolg = new HttpNetReq();
      parambolg.mCallback = new bolf(this);
      parambolg.mReqUrl = ((String)localObject);
      parambolg.mHttpMethod = 0;
      parambolg.mOutPath = DynamicTextConfigManager.a(parambold);
      parambolg.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      parambolg.setUserData(parambold);
      lbf.a().sendReq(parambolg);
      return;
      label268:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bole
 * JD-Core Version:    0.7.0.1
 */