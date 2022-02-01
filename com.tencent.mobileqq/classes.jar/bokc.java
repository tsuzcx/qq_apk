import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class bokc
{
  private bojy jdField_a_of_type_Bojy;
  private ConcurrentHashMap<String, ArrayList<WeakReference<bokb>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public bokc(bojy parambojy)
  {
    this.jdField_a_of_type_Bojy = parambojy;
  }
  
  public void a(@NonNull bpba parambpba, bokb parambokb)
  {
    String str = parambpba.e;
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
          parambpba = localArrayList.iterator();
          if (!parambpba.hasNext()) {
            break label292;
          }
          if (((WeakReference)parambpba.next()).get() != parambokb) {
            continue;
          }
          i = 1;
          if (i == 0) {
            localArrayList.add(new WeakReference(parambokb));
          }
          if (QLog.isColorLevel()) {
            QLog.i("QIMInformationPasterManager", 2, "already put url " + str);
          }
          return;
        }
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new WeakReference(parambokb));
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localArrayList);
      parambokb = new HttpNetReq();
      parambokb.mCallback = new bokd(this);
      parambokb.mReqUrl = str;
      parambokb.mHttpMethod = 0;
      parambokb.mOutPath = bojy.a(parambpba);
      parambokb.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      parambokb.setUserData(parambpba);
      lbf.a().sendReq(parambokb);
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
 * Qualified Name:     bokc
 * JD-Core Version:    0.7.0.1
 */