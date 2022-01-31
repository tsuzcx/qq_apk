import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.ark.Container;
import com.tencent.ark.ark.ModuleRegister;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterEvent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class awsp
  implements awsr, ark.ApplicationCallback
{
  private ArrayList<WeakReference<awta>> a = new ArrayList();
  
  private awta a(long paramLong)
  {
    ark.Container localContainer = ark.arkGetContainer(paramLong);
    awta localawta;
    if (localContainer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkNodeContainer", 2, "getArkNode, arkcontainer is null");
      }
      localawta = null;
    }
    label150:
    label154:
    for (;;)
    {
      return localawta;
      if (this.a.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkNodeContainer", 2, "getArkNode, list is null");
        }
        return null;
      }
      int i = 0;
      if (i < this.a.size())
      {
        localawta = (awta)((WeakReference)this.a.get(i)).get();
        if ((localawta == null) || (!(localawta instanceof awsy))) {
          break label150;
        }
      }
      for (awsu localawsu = ((awsy)localawta).a();; localawsu = null)
      {
        if ((localawsu != null) && (localawsu.getContainer() == localContainer)) {
          break label154;
        }
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ArkNodeContainer", 2, "getArkNode, not found");
        }
        return null;
      }
    }
  }
  
  public void AppCreate(ark.Application paramApplication)
  {
    ArkAppCenterEvent.a(0, paramApplication.GetSpecific("appName"), null);
  }
  
  public void AppDestroy(ark.Application paramApplication)
  {
    paramApplication = paramApplication.GetSpecific("appName");
    ArkAppCenterEvent.a(1, paramApplication, null);
    alwh.a(paramApplication);
  }
  
  public boolean CheckUrlLegalityCallback(ark.Application paramApplication, String paramString)
  {
    paramApplication = paramApplication.GetSpecific("appName");
    ArkAppUrlChecker localArkAppUrlChecker = ArkAppConfigMgr.getInstance().getUrlChecker(paramApplication);
    boolean bool;
    int i;
    if (localArkAppUrlChecker != null)
    {
      int j = localArkAppUrlChecker.checkUrlIsValidByAppResouceList(paramString);
      if (j == 0)
      {
        bool = true;
        if (bool) {
          break label170;
        }
        if (ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramApplication)) {
          break label165;
        }
        QLog.e("ArkNodeContainer", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.EngineCallback seach appName=", paramApplication, ",url=", nax.b(paramString, new String[0]), ", isValid set=true" });
        i = 2;
        bool = true;
        label97:
        alwh.a(paramApplication, paramString, j, i, "");
      }
    }
    for (;;)
    {
      QLog.e("ArkNodeContainer", 1, new Object[] { "ArkSafe.EngineCallback search appName=", paramApplication, ",url=", nax.b(paramString, new String[0]), ", isValid=", Boolean.valueOf(bool) });
      return bool;
      bool = false;
      break;
      label165:
      i = 1;
      break label97;
      label170:
      i = 0;
      break label97;
      bool = true;
    }
  }
  
  public void OutputScriptError(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      if (paramString2 == null) {
        paramString2 = "";
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ArkNodeContainer", 2, String.format("%s.script error: %s", new Object[] { paramString1, paramString2 }));
        }
        altd.a(null, paramString1, "ScriptError", 0, 0, 0L, 0L, 0L, paramString2, "");
        return;
      }
    }
  }
  
  public void RegisterModules(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication)
  {
    aloz.a(paramModuleRegister, paramApplication);
    String str = paramApplication.GetSpecific("appName");
    awsq localawsq = new awsq(paramApplication, aloz.a(str));
    localawsq.a(this);
    paramApplication = aloz.a();
    if ((!TextUtils.isEmpty(str)) && (paramApplication != null))
    {
      paramApplication = (ArkAppCenter)paramApplication.getManager(121);
      if (paramApplication == null) {}
    }
    for (paramApplication = paramApplication.a();; paramApplication = null)
    {
      if (paramApplication != null) {
        localawsq.a((List)alqy.a.get(localawsq.GetTypeName()));
      }
      paramModuleRegister.RegCallbackWrapper(localawsq);
      return;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    awta localawta = a(paramLong);
    if ((localawta != null) && ((localawta instanceof awsy))) {
      ((awsy)localawta).a(paramString);
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkNodeContainer", 2, "onNotify, KEY：" + paramString1 + " VALUE:" + paramString2);
    }
    awta localawta = a(paramLong);
    if ((localawta != null) && ((localawta instanceof awsy))) {
      ((awsy)localawta).a(paramString1, paramString2);
    }
  }
  
  public void a(awsy paramawsy)
  {
    if (paramawsy == null) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramawsy) {
        return;
      }
    }
    this.a.add(new WeakReference(paramawsy));
  }
  
  public void b(awsy paramawsy)
  {
    if (paramawsy == null) {}
    WeakReference localWeakReference;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.a.iterator();
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while (localWeakReference.get() != paramawsy);
    this.a.remove(localWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsp
 * JD-Core Version:    0.7.0.1
 */